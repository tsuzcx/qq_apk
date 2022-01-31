package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;

public class AudioHelper
{
  public static final int a = 0;
  private static final long jdField_a_of_type_Long = 2000L;
  private static final String jdField_a_of_type_JavaLangString = "!@$#_";
  private static boolean jdField_a_of_type_Boolean = false;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  private static AudioHelper.AudioPlayerParameter[] jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "appops";
  private static final int[] jdField_b_of_type_ArrayOfInt;
  public static final int c = 2;
  private static final String c = "AppOpsManager";
  public static final int d = 3;
  public static final int e = 0;
  public static final int f = 1;
  private static int g = 0;
  private static final int h = 35;
  private static final int i = 36;
  private static final int j = 26;
  private static final int k = 27;
  private static final int l = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = null;
    jdField_a_of_type_ArrayOfInt = new int[] { 35, 36 };
    b = new int[] { 26, 27 };
  }
  
  public static long a(Context paramContext, byte[] paramArrayOfByte, int paramInt, float paramFloat)
  {
    return 2000L;
  }
  
  public static AudioHelper.AudioPlayerParameter a()
  {
    if (b()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, true);
    }
    return new AudioHelper.AudioPlayerParameter(3, 0, true);
  }
  
  private static AudioHelper.AudioPlayerParameter a(int paramInt)
  {
    AudioHelper.AudioPlayerParameter localAudioPlayerParameter;
    if (paramInt == 0) {
      localAudioPlayerParameter = a();
    }
    for (;;)
    {
      String str = "!@$#_" + paramInt + "_";
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext());
      localAudioPlayerParameter.jdField_a_of_type_Int = localSharedPreferences.getInt(str + "m", localAudioPlayerParameter.jdField_a_of_type_Int);
      localAudioPlayerParameter.b = localSharedPreferences.getInt(str + "s", localAudioPlayerParameter.b);
      localAudioPlayerParameter.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean(str + "so", localAudioPlayerParameter.jdField_a_of_type_Boolean);
      return a(paramInt, localAudioPlayerParameter);
      if (paramInt == 1)
      {
        localAudioPlayerParameter = b();
      }
      else if (paramInt == 2)
      {
        localAudioPlayerParameter = a();
        localAudioPlayerParameter.jdField_a_of_type_Boolean = false;
      }
      else
      {
        localAudioPlayerParameter = a();
        localAudioPlayerParameter.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private static AudioHelper.AudioPlayerParameter a(int paramInt, AudioHelper.AudioPlayerParameter paramAudioPlayerParameter)
  {
    paramAudioPlayerParameter = new AudioHelper.AudioPlayerParameter(paramAudioPlayerParameter.b, paramAudioPlayerParameter.jdField_a_of_type_Int, paramAudioPlayerParameter.jdField_a_of_type_Boolean);
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.qq_audio_play_fix.name(), null);
    if (QLog.isColorLevel()) {
      QLog.d(AudioHelper.class.getSimpleName(), 2, "getDPCFixConfig | dpcConfig = " + (String)localObject);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 1)) {
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (paramInt == 0)
        {
          if (!"-1".equals(localObject[0])) {
            paramAudioPlayerParameter.jdField_a_of_type_Int = Integer.parseInt(localObject[0]);
          }
          if (!"-1".equals(localObject[1]))
          {
            paramAudioPlayerParameter.b = Integer.parseInt(localObject[1]);
            return paramAudioPlayerParameter;
          }
        }
        else if (paramInt == 1)
        {
          if (!"-1".equals(localObject[2])) {
            paramAudioPlayerParameter.jdField_a_of_type_Int = Integer.parseInt(localObject[2]);
          }
          if (!"-1".equals(localObject[3]))
          {
            paramAudioPlayerParameter.b = Integer.parseInt(localObject[3]);
            return paramAudioPlayerParameter;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(AudioHelper.class.getSimpleName(), 2, "getDPCFixConfig error.", localException);
        }
      }
    }
    return paramAudioPlayerParameter;
  }
  
  public static void a(int paramInt, AudioHelper.AudioPlayerParameter paramAudioPlayerParameter)
  {
    String str = "!@$#_" + paramInt + "_";
    PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext()).edit().putInt(str + "m", paramAudioPlayerParameter.jdField_a_of_type_Int).putInt(str + "s", paramAudioPlayerParameter.b).putBoolean(str + "so", paramAudioPlayerParameter.jdField_a_of_type_Boolean).commit();
  }
  
  public static boolean a()
  {
    return (j()) || (i());
  }
  
  public static boolean a(int paramInt)
  {
    if ((!k()) || (Build.VERSION.SDK_INT < 17)) {}
    for (;;)
    {
      return false;
      Object localObject = BaseApplicationImpl.getContext().getSystemService("appops");
      if ((localObject != null) && (localObject.getClass().getSimpleName().equals("AppOpsManager"))) {
        try
        {
          Method localMethod = localObject.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          int m = b[paramInt];
          if (Build.VERSION.SDK_INT < 19) {
            m = jdField_a_of_type_ArrayOfInt[paramInt];
          }
          ApplicationInfo localApplicationInfo = BaseApplicationImpl.getContext().getApplicationInfo();
          paramInt = ((Integer)localMethod.invoke(localObject, new Object[] { Integer.valueOf(m), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
          if (QLog.isColorLevel()) {
            QLog.d(AudioHelper.class.getSimpleName(), 2, "isForbidByRubbishMeizu(), result = " + paramInt);
          }
          if (paramInt != 0) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Exception localException) {}
      }
    }
    QLog.e(AudioHelper.class.getSimpleName(), 2, localException.toString());
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    return ((AudioManager)paramContext.getSystemService("audio")).isBluetoothA2dpOn();
  }
  
  public static AudioHelper.AudioPlayerParameter[] a()
  {
    try
    {
      if (jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter == null)
      {
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = new AudioHelper.AudioPlayerParameter[4];
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[0] = a(0);
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[1] = a(1);
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[2] = a(2);
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[3] = a(3);
      }
      AudioHelper.AudioPlayerParameter[] arrayOfAudioPlayerParameter = jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
      return arrayOfAudioPlayerParameter;
    }
    finally {}
  }
  
  @TargetApi(11)
  public static AudioHelper.AudioPlayerParameter b()
  {
    if (h()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (c()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (d()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (e()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (f()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (g()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new AudioHelper.AudioPlayerParameter(0, 3, false);
    }
    return new AudioHelper.AudioPlayerParameter(0, 2, false);
  }
  
  private static boolean b()
  {
    String str = Build.MODEL;
    int m;
    if (((Build.MANUFACTURER.equalsIgnoreCase("Samsung")) || (str.contains("MI 2")) || (str.contains("Nexus 4"))) && (Build.VERSION.SDK_INT >= 11))
    {
      m = 1;
      if (m == 0) {
        break label57;
      }
    }
    label57:
    while ((str.contains("SCH-I699")) && (Build.VERSION.SDK_INT == 10))
    {
      return true;
      m = 0;
      break;
    }
    return false;
  }
  
  private static boolean c()
  {
    return (Build.MODEL.contains("HUAWEI Y 200T")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean d()
  {
    return (Build.MODEL.contains("Lenovo A278t")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean e()
  {
    return (Build.MODEL.contains("ZTE-T U960s")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean f()
  {
    return Build.MODEL.contains("5910");
  }
  
  private static boolean g()
  {
    return Build.MODEL.contains("V926");
  }
  
  private static boolean h()
  {
    return (Build.MODEL.contains("ME860")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean i()
  {
    return Build.MODEL.contains("Lenovo A750");
  }
  
  private static boolean j()
  {
    String str = Build.MODEL;
    return (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (str.contains("X907"));
  }
  
  private static boolean k()
  {
    return "Meizu".equalsIgnoreCase(Build.MANUFACTURER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioHelper
 * JD-Core Version:    0.7.0.1
 */