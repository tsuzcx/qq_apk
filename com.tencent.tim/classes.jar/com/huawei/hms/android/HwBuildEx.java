package com.huawei.hms.android;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HwBuildEx
{
  public static int getSystemPropertiesInt(String paramString, int paramInt)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      int i = ((Integer)localClass.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(localClass, new Object[] { paramString, Integer.valueOf(paramInt) })).intValue();
      return i;
    }
    catch (ClassNotFoundException paramString)
    {
      Log.e("HwBuildEx", "An exception occurred while reading: EMUI_SDK_INT");
      return paramInt;
    }
    catch (ClassCastException paramString)
    {
      break label56;
    }
    catch (IllegalAccessException paramString)
    {
      break label56;
    }
    catch (IllegalArgumentException paramString)
    {
      break label56;
    }
    catch (NoSuchMethodException paramString)
    {
      break label56;
    }
    catch (InvocationTargetException paramString)
    {
      label56:
      break label56;
    }
  }
  
  public static class VERSION
  {
    public static final int EMUI_SDK_INT = HwBuildEx.getSystemPropertiesInt("ro.build.hw_emui_api_level", 0);
  }
  
  public static class VersionCodes
  {
    public static final int CUR_DEVELOPMENT = 10000;
    public static final int EMUI_10_0 = 21;
    public static final int EMUI_1_0 = 1;
    public static final int EMUI_1_5 = 2;
    public static final int EMUI_1_6 = 3;
    public static final int EMUI_2_0_JB = 4;
    public static final int EMUI_2_0_KK = 5;
    public static final int EMUI_2_3 = 6;
    public static final int EMUI_3_0 = 7;
    public static final int EMUI_3_0_5 = 8;
    public static final int EMUI_3_1 = 8;
    public static final int EMUI_4_0 = 9;
    public static final int EMUI_4_1 = 10;
    public static final int EMUI_5_0 = 11;
    public static final int EMUI_5_1 = 12;
    public static final int EMUI_5_1_b10x = 13;
    public static final int EMUI_5_1_b200 = 13;
    public static final int EMUI_6_0 = 14;
    public static final int EMUI_9_0 = 17;
    public static final int UNKNOWN_EMUI = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.android.HwBuildEx
 * JD-Core Version:    0.7.0.1
 */