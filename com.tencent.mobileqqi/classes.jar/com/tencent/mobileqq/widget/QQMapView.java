package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapView;
import hhd;
import hhe;

@SuppressLint({"HandlerLeak"})
public class QQMapView
  extends MapView
{
  static final int c = 0;
  static final int d = 1;
  public Handler a;
  public QQMapView.QQMapViewObserver a;
  public GeoPoint a;
  public Thread a;
  boolean a;
  public boolean b = false;
  public boolean c;
  public boolean d = false;
  public int e = 0;
  
  public QQMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new hhd(this);
    this.jdField_a_of_type_JavaLangThread = new hhe(this, "qqmapview_calculate_position");
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
    this.e += 1;
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
      this.c = true;
      continue;
      this.c = false;
    }
  }
  
  public void setObserver(QQMapView.QQMapViewObserver paramQQMapViewObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver = paramQQMapViewObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQMapView
 * JD-Core Version:    0.7.0.1
 */