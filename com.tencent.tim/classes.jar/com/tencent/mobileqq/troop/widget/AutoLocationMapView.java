package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import apus;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.MapView;

public class AutoLocationMapView
  extends MapView
{
  public a a;
  Handler uiHandler = new apus(this);
  
  public AutoLocationMapView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoLocationMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt, GeoPoint paramGeoPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AutoLocationMapView
 * JD-Core Version:    0.7.0.1
 */