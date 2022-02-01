package com.tencent.youtu.ytagreflectlivecheck.requester;

import android.os.Build;
import android.os.Build.VERSION;

public abstract interface LiveStyleRequester
{
  public static class LiveStyleAndroidData
  {
    public String android_apilevel = "" + Build.VERSION.SDK_INT;
    public String android_version = Build.VERSION.RELEASE;
    public String build_brand = Build.BRAND;
    public String build_device = Build.DEVICE;
    public String build_display = Build.DISPLAY;
    public String build_hardware = Build.HARDWARE;
    public String build_model = Build.MODEL;
    public String build_product = Build.PRODUCT;
    public float lux = 0.0F;
  }
  
  public static class SeleceData
  {
    public LiveStyleRequester.LiveStyleAndroidData android_data = new LiveStyleRequester.LiveStyleAndroidData();
    public int platform = 2;
    public int protocal = 1;
    public String version = "3.4.7";
    
    public SeleceData(float paramFloat)
    {
      this.android_data.lux = paramFloat;
    }
  }
  
  public static class YTLiveStyleReq
  {
    public String app_id;
    public LiveStyleRequester.SeleceData select_data;
    
    public YTLiveStyleReq(float paramFloat, String paramString)
    {
      this.select_data = new LiveStyleRequester.SeleceData(paramFloat);
      this.app_id = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester
 * JD-Core Version:    0.7.0.1
 */