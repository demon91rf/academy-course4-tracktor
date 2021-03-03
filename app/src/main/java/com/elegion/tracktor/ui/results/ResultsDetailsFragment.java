package com.elegion.tracktor.ui.results;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elegion.tracktor.R;
import com.elegion.tracktor.util.StringUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.elegion.tracktor.ui.results.ResultsActivity.DISTANCE_KEY;
import static com.elegion.tracktor.ui.results.ResultsActivity.ROUTE_KEY;
import static com.elegion.tracktor.ui.results.ResultsActivity.TIME_KEY;

/**
 * @author Azret Magometov
 */
public class ResultsDetailsFragment extends Fragment implements OnMapReadyCallback {

    @BindView(R.id.tvTime)
    TextView mTimeText;

    @BindView(R.id.tvDistance)
    TextView mDistanceText;

    private GoogleMap mMap;
    private List<LatLng> mRoute;

    public static ResultsDetailsFragment newInstance(Bundle bundle) {
        Bundle args = new Bundle();
        args.putAll(bundle);

        ResultsDetailsFragment fragment = new ResultsDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_result_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        double distance = getArguments().getDouble(DISTANCE_KEY, 0.0);
        long time = getArguments().getLong(TIME_KEY, 0);
        mRoute = (ArrayList<LatLng>) getArguments().getSerializable(ROUTE_KEY);

        mTimeText.setText(StringUtil.getTimeText(time));
        mDistanceText.setText(StringUtil.getDistanceText(distance));

        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.mapContainer);
        if (mapFragment == null){
            mapFragment = SupportMapFragment.newInstance();
            mapFragment.setRetainInstance(true);
            getChildFragmentManager().beginTransaction().replace(R.id.mapContainer, mapFragment).commit();
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.addPolyline(new PolylineOptions().addAll(mRoute));

        mMap.addMarker(new MarkerOptions().position(mRoute.get(0)).title(getString(R.string.start)));
        mMap.addMarker(new MarkerOptions().position(mRoute.get(mRoute.size() - 1)).title(getString(R.string.end)));

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng point : mRoute) {
            builder.include(point);
        }
        int padding = 100;
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(builder.build(), padding);
        mMap.moveCamera(cu);
    }
}
