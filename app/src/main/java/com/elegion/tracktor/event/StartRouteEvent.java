package com.elegion.tracktor.event;

import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;

public class StartRouteEvent {

    private LatLng mStartPosition;

    public StartRouteEvent(@NonNull LatLng startPosition) {
        mStartPosition = startPosition;
    }

    public LatLng getStartPosition() {
        return mStartPosition;
    }
}
