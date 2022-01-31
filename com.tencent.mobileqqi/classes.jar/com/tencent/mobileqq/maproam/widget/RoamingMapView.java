package com.tencent.mobileqq.maproam.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.QQMapView;

public class RoamingMapView
  extends QQMapView
{
  public static final int a = 0;
  public static final int b = 1;
  private int f = 0;
  
  public RoamingMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setMapMode(this.f);
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void setMapMode(int paramInt)
  {
    this.f = paramInt;
    if (1 == this.f)
    {
      setEnabled(true);
      return;
    }
    setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.widget.RoamingMapView
 * JD-Core Version:    0.7.0.1
 */