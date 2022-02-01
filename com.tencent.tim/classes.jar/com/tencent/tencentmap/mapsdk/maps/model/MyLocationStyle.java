package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Color;
import com.tencent.map.sdk.a.fz;

public class MyLocationStyle
{
  public static final int LOCATION_TYPE_FOLLOW_NO_CENTER = 2;
  public static final int LOCATION_TYPE_LOCATION_ROTATE = 0;
  public static final int LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER = 1;
  public static final int LOCATION_TYPE_MAP_ROTATE_NO_CENTER = 3;
  private float a = 0.5F;
  private float b = 0.5F;
  private int c = Color.argb(102, 0, 163, 255);
  private int d = Color.argb(127, 0, 163, 255);
  private float e = 1.0F;
  private BitmapDescriptor f = BitmapDescriptorFactory.fromAsset(fz.n);
  private int g = 0;
  
  public MyLocationStyle anchor(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    return this;
  }
  
  public MyLocationStyle fillColor(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public float getAnchorU()
  {
    return this.a;
  }
  
  public float getAnchorV()
  {
    return this.b;
  }
  
  public int getFillColor()
  {
    return this.c;
  }
  
  public BitmapDescriptor getMyLocationIcon()
  {
    return this.f;
  }
  
  public int getMyLocationType()
  {
    return this.g;
  }
  
  public int getStrokeColor()
  {
    return this.d;
  }
  
  public float getStrokeWidth()
  {
    return this.e;
  }
  
  public MyLocationStyle icon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.f = paramBitmapDescriptor;
    return this;
  }
  
  public MyLocationStyle myLocationType(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public MyLocationStyle strokeColor(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public MyLocationStyle strokeWidth(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle
 * JD-Core Version:    0.7.0.1
 */