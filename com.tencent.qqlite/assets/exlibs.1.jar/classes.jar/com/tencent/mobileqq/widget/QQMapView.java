package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapView;
import eyv;
import eyw;

@SuppressLint({"HandlerLeak"})
public class QQMapView
  extends MapView
{
  static final String jdField_a_of_type_JavaLangString = "QQMapView";
  static final int c = 0;
  static final int d = 1;
  public Handler a;
  public QQMapView.QQMapViewObserver a;
  public GeoPoint a;
  public Thread a;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b = false;
  public boolean c;
  public boolean d = false;
  public int e;
  protected boolean e;
  
  public QQMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_e_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new eyv(this);
    this.jdField_a_of_type_JavaLangThread = new eyw(this, "qqmapview_calculate_position");
    this.jdField_a_of_type_JavaLangThread.setPriority(10);
    this.jdField_a_of_type_JavaLangThread.start();
  }
  
  public Message a(int paramInt, GeoPoint paramGeoPoint)
  {
    Message localMessage = new Message();
    localMessage.arg1 = paramInt;
    localMessage.obj = paramGeoPoint;
    return localMessage;
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    this.jdField_e_of_type_Int += 1;
    if ((this.b) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver != null) && (this.jdField_a_of_type_JavaLangThread != null)) {
      synchronized (this.jdField_a_of_type_JavaLangThread)
      {
        this.jdField_a_of_type_JavaLangThread.notify();
        return;
      }
    }
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver = null;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      this.jdField_a_of_type_JavaLangThread.interrupt();
      this.jdField_a_of_type_JavaLangThread = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if ((this.c) && (this.jdField_e_of_type_Boolean))
      {
        this.jdField_e_of_type_Boolean = false;
        this.d = true;
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = getMapCenter();
        if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver.c(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.Copy());
          continue;
          this.c = true;
          this.jdField_e_of_type_Boolean = true;
          continue;
          this.c = false;
          computeScroll();
        }
      }
    }
  }
  
  public void setObserver(QQMapView.QQMapViewObserver paramQQMapViewObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver = paramQQMapViewObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQMapView
 * JD-Core Version:    0.7.0.1
 */