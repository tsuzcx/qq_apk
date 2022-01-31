package com.tmsdk.base.utils;

import android.os.Build;
import android.os.Build.VERSION;

public class SDKUtil
{
  public static final int OS_1_5 = 3;
  public static final int OS_1_6 = 4;
  public static final int OS_2_0 = 5;
  public static final int OS_2_0_1 = 6;
  public static final int OS_2_1 = 7;
  public static final int OS_2_2 = 8;
  public static final int OS_2_3 = 9;
  public static final int OS_2_3_3 = 10;
  public static final int OS_3_0 = 11;
  public static final int OS_3_1 = 12;
  public static final int OS_3_2 = 13;
  public static final int OS_4_0 = 14;
  public static final int OS_4_0_3 = 15;
  public static final int OS_4_1_0 = 16;
  public static final int OS_4_2_0 = 17;
  public static final int OS_4_3_0 = 18;
  public static final int OS_4_4_0 = 19;
  public static final int OS_5_0_0 = 21;
  public static final int OS_6_0_0 = 23;
  public static final int OS_7_0_0 = 24;
  public static final int OS_8_0_0 = 26;
  public static final int OS_9_0_0 = 28;
  public static final int RELEASE_ANDROID = 2;
  public static final int RELEASE_LEPHONE = 3;
  public static final int RELEASE_MEIZU_M9 = 4;
  public static final int RELEASE_OMS = 1;
  
  public static int getAndroidReleaseName()
  {
    String str = Build.PRODUCT;
    if ((str.contains("OMS")) || (str.contains("SnapperTD"))) {
      return 1;
    }
    if ((str.contains("qsd8250_surf")) || (str.contains("3GW100"))) {
      return 3;
    }
    if (str.contains("meizu_m9")) {
      return 4;
    }
    return 2;
  }
  
  public static int getSDKVersion()
  {
    return Build.VERSION.SDK_INT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.SDKUtil
 * JD-Core Version:    0.7.0.1
 */