package com.tencent.viola.ui.animation;

import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;

public class CameraDistanceProperty
  extends Property<View, Float>
{
  private static final String TAG = "CameraDistance";
  private static CameraDistanceProperty instance;
  
  private CameraDistanceProperty()
  {
    super(Float.class, "CameraDistance");
  }
  
  static Property<View, Float> getInstance()
  {
    return instance;
  }
  
  public Float get(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return Float.valueOf(paramView.getCameraDistance());
    }
    return Float.valueOf((0.0F / 0.0F));
  }
  
  public void set(View paramView, Float paramFloat)
  {
    paramView.setCameraDistance(paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.animation.CameraDistanceProperty
 * JD-Core Version:    0.7.0.1
 */