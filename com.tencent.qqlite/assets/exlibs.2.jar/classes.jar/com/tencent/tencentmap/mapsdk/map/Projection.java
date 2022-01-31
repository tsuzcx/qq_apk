package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;

public abstract interface Projection
{
  public abstract double distanceBetween(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2);
  
  public abstract GeoPoint fromPixels(int paramInt1, int paramInt2);
  
  public abstract float metersToEquatorPixels(float paramFloat);
  
  public abstract float metersToPixels(double paramDouble1, double paramDouble2);
  
  public abstract Point toPixels(GeoPoint paramGeoPoint, Point paramPoint);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.Projection
 * JD-Core Version:    0.7.0.1
 */