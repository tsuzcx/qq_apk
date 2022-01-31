package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;

public abstract interface Projection
{
  public abstract GeoPoint fromPixels(int paramInt1, int paramInt2);
  
  public abstract float metersToEquatorPixels(float paramFloat);
  
  public abstract Point toPixels(GeoPoint paramGeoPoint, Point paramPoint);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.Projection
 * JD-Core Version:    0.7.0.1
 */