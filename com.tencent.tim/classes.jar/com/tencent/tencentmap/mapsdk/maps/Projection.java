package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.Point;
import com.tencent.map.sdk.a.lc;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;

public final class Projection
{
  lc a;
  
  Projection(lc paramlc)
  {
    this.a = paramlc;
  }
  
  public final LatLng fromScreenLocation(Point paramPoint)
  {
    return this.a.a(paramPoint);
  }
  
  public final VisibleRegion getVisibleRegion()
  {
    return this.a.u();
  }
  
  public final double metersPerPixel(double paramDouble)
  {
    return this.a.a(paramDouble);
  }
  
  public final Point toScreenLocation(LatLng paramLatLng)
  {
    return this.a.b(paramLatLng);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.Projection
 * JD-Core Version:    0.7.0.1
 */