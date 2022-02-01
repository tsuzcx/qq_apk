package com.tencent.mobileqq.opencl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintStream;

public class OpenclInfoManager
{
  private static String TAG = "OpenclInfoManager";
  private static boolean cuG;
  private static String gpuInfo;
  private static Object mLock = new Object();
  
  static
  {
    loadSo();
  }
  
  private void NK(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.startsWith("err"))) {}
    do
    {
      return;
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4).edit();
      localEditor.putString("param_ocl_gpuinfo", paramString);
      localEditor.commit();
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "saveOclGpuInfo:" + paramString);
  }
  
  public static void loadSo()
  {
    try
    {
      System.loadLibrary("oclInfo");
      cuG = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      System.out.println(localUnsatisfiedLinkError);
    }
  }
  
  private native String nativeGetOclVersion();
  
  private native String nativeGetPlatformName();
  
  private native int nativeGetSupportedType();
  
  private String xL()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4).getString("param_ocl_gpuinfo", "");
  }
  
  public native String nativeGetGPUInfo();
  
  public native int nativeGetGPUUnit();
  
  public String xK()
  {
    synchronized (mLock)
    {
      if (!TextUtils.isEmpty(gpuInfo))
      {
        String str = gpuInfo;
        return str;
      }
      gpuInfo = xL();
      boolean bool = TextUtils.isEmpty(gpuInfo);
      if (!bool) {}
    }
    try
    {
      gpuInfo = nativeGetGPUInfo();
      NK(gpuInfo);
      return gpuInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getGPUInfo exception!", localException);
        }
      }
      localObject2 = finally;
      throw localObject2;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getGPUInfo UnsatisfiedLinkError!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.opencl.OpenclInfoManager
 * JD-Core Version:    0.7.0.1
 */