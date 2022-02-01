package com.tencent.youtu.ytagreflectlivecheck.requester;

import android.os.Build;
import android.os.Build.VERSION;

public abstract interface RGBConfigRequester
{
  public abstract void request(RGBConfigRequestCallBack paramRGBConfigRequestCallBack);
  
  public static abstract interface RGBConfigRequestCallBack
  {
    public abstract void onFailed(int paramInt);
    
    public abstract void onSuccess(String paramString, int paramInt);
  }
  
  public static class RGBConfigRequestCallBackType
  {
    public static int RGB_FullResponse = 0;
    public static int RGB_OnlyRgbConfig = 1;
  }
  
  public static class YTColorSeqReq
  {
    public String android_apilevel = "" + Build.VERSION.SDK_INT;
    public String android_version = Build.VERSION.RELEASE;
    public String app_id;
    public String build_brand = Build.BRAND;
    public String build_device = Build.DEVICE;
    public String build_display = Build.DISPLAY;
    public String build_hardware = Build.HARDWARE;
    public String build_id = Build.ID;
    public String build_model = Build.MODEL;
    public String build_product = Build.PRODUCT;
    public String build_serial = Build.SERIAL;
    public String build_test = null;
    public String business_name;
    public String person_id;
    public int platform;
    
    public YTColorSeqReq(String paramString1, String paramString2, String paramString3)
    {
      this.app_id = paramString1;
      this.business_name = paramString2;
      this.person_id = paramString3;
      this.platform = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester
 * JD-Core Version:    0.7.0.1
 */