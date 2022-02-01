package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.model.OverlayLevel;

public final class is
{
  public GeoPoint a;
  Bitmap[] b;
  float c = 0.5F;
  float d = 0.5F;
  public float e = 1.0F;
  public boolean f = false;
  public int g;
  int h;
  int i;
  public int j;
  public int k = OverlayLevel.OverlayLevelAboveLabels;
  public boolean l;
  public boolean m = true;
  protected String n;
  public boolean o;
  public boolean p = true;
  
  public final is a(float paramFloat1, float paramFloat2)
  {
    this.c = paramFloat1;
    this.d = paramFloat2;
    return this;
  }
  
  public final is a(String paramString, Bitmap... paramVarArgs)
  {
    this.n = paramString;
    this.b = paramVarArgs;
    return this;
  }
  
  public final String a()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.is
 * JD-Core Version:    0.7.0.1
 */