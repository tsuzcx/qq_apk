package com.tencent.mobileqq.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;

public class CameraUtil
{
  private static int jdField_a_of_type_Int = -1;
  public static final String a = "open_aio_realtime_bg";
  private static boolean jdField_a_of_type_Boolean = false;
  private static final String b = "CameraUtil";
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (ActivityManager)paramQQAppInterface.getApplication().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    paramQQAppInterface.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem;
  }
  
  public static Camera a()
  {
    try
    {
      Camera localCamera = Camera.open();
      return localCamera;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static void a(Camera paramCamera)
  {
    if (paramCamera != null) {}
    try
    {
      paramCamera.stopPreview();
      label8:
      paramCamera.release();
      return;
    }
    catch (Exception localException)
    {
      break label8;
    }
  }
  
  public static void a(Camera paramCamera, int paramInt)
  {
    try
    {
      paramCamera.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE }).invoke(paramCamera, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramCamera)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraUtil", 2, "setDisplayOrientation  exception");
      }
      paramCamera.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApplication()).edit().putBoolean("open_aio_realtime_bg" + paramQQAppInterface.a(), true).commit();
  }
  
  public static boolean a(Context paramContext)
  {
    if (jdField_a_of_type_Int != -1)
    {
      if (jdField_a_of_type_Int == 1) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    if (paramContext.getPackageManager().hasSystemFeature("android.hardware.camera")) {}
    for (;;)
    {
      int i;
      try
      {
        int j = ((Integer)Camera.class.getMethod("getNumberOfCameras", new Class[0]).invoke(null, new Object[0])).intValue();
        if (j > 0)
        {
          Object localObject = Class.forName("android.hardware.Camera$CameraInfo");
          paramContext = ((Class)localObject).newInstance();
          Field localField = ((Class)localObject).getField("facing");
          localObject = Camera.class.getMethod("getCameraInfo", new Class[] { Integer.TYPE, localObject });
          i = 0;
          if (i < j)
          {
            ((Method)localObject).invoke(null, new Object[] { Integer.valueOf(i), paramContext });
            if (((Integer)localField.get(paramContext)).intValue() != 0) {
              break label177;
            }
          }
          if (i < j) {
            break;
          }
          jdField_a_of_type_Int = 0;
          return false;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      jdField_a_of_type_Int = 0;
      return false;
      label177:
      i += 1;
    }
    jdField_a_of_type_Int = 1;
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApplication()).getBoolean("open_aio_realtime_bg" + paramQQAppInterface.a(), false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (!DeviceProfileManager.a().b(DeviceProfileManager.DpcNames.aio_realtime_bg.name())) {}
    do
    {
      return false;
      if (a(paramQQAppInterface.getApplication())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CameraUtil", 2, "isAioRealTimeBgSupport.hardware not support.");
    return false;
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.equals("open_aio_realtime_bg" + paramQQAppInterface.a())) {
      return false;
    }
    return true;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApplication()).edit().putBoolean("open_aio_realtime_bg" + paramQQAppInterface.a(), false).commit();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApplication()).getBoolean("setting_aio_realtime_bg_open" + paramQQAppInterface.a(), false);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (ActivityManager)paramQQAppInterface.getApplication().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    paramQQAppInterface.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.lowMemory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.CameraUtil
 * JD-Core Version:    0.7.0.1
 */