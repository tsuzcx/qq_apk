package com.tencent.qqmini.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

@SuppressLint({"HandlerLeak"})
public class QQMapView
  extends MapView
{
  static final String TAG = "QQMapView";
  public static boolean isSelectPoiListItem;
  private TencentMap.OnCameraChangeListener cameraChangeListener;
  protected boolean mIsScrolling = false;
  GeoPoint mLastPoint;
  QQMapViewObserver mObserver;
  
  public QQMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.cameraChangeListener = new QQMapView.2(this);
    getMap().setOnCameraChangeListener(this.cameraChangeListener);
  }
  
  public QQMapView(Context paramContext, AttributeSet paramAttributeSet, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext, paramTencentMapOptions);
    this.cameraChangeListener = new QQMapView.1(this);
    getMap().setOnCameraChangeListener(this.cameraChangeListener);
  }
  
  private void dealMapScroll(CameraPosition paramCameraPosition)
  {
    paramCameraPosition = new GeoPoint((int)(paramCameraPosition.target.getLatitude() * 1000000.0D), (int)(paramCameraPosition.target.getLongitude() * 1000000.0D));
    if (this.mLastPoint != null)
    {
      int i = Math.abs(this.mLastPoint.getLatitudeE6() - paramCameraPosition.getLatitudeE6());
      int j = Math.abs(this.mLastPoint.getLongitudeE6() - paramCameraPosition.getLongitudeE6());
      QMLog.d("QQMapView", "dealMapScroll() latScroll =" + i + " lngScroll =" + j);
      if ((i == 0) || (j == 0)) {
        return;
      }
    }
    if (!isSelectPoiListItem) {
      this.mObserver.onMapScrollEnd(paramCameraPosition);
    }
    for (;;)
    {
      this.mIsScrolling = false;
      this.mLastPoint = paramCameraPosition;
      return;
      isSelectPoiListItem = false;
    }
  }
  
  public void destroy()
  {
    this.mObserver = null;
    this.cameraChangeListener = null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setObserver(QQMapViewObserver paramQQMapViewObserver)
  {
    this.mObserver = paramQQMapViewObserver;
  }
  
  public static abstract interface QQMapViewObserver
  {
    public abstract void onMapScrollEnd(GeoPoint paramGeoPoint);
    
    public abstract void onMapScrollStart(GeoPoint paramGeoPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.map.QQMapView
 * JD-Core Version:    0.7.0.1
 */