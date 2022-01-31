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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;

public class AudioHelper
{
  public static final int a = 0;
  private static final long jdField_a_of_type_Long = 2000L;
  private static final String jdField_a_of_type_JavaLangString = "!@$#_";
  private static boolean jdField_a_of_type_Boolean = false;
  private static AudioHelper.AudioPlayerParameter[] jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = null;
  public static final int b = 1;
  private static final String b = "appops";
  public static final int c = 2;
  private static final String c = "AppOpsManager";
  public static final int d = 3;
  private static final int e = 36;
  private static final int f = 27;
  private static final int g = 0;
  
  /* Error */
  public static long a(Context paramContext, byte[] paramArrayOfByte, int paramInt, float paramFloat)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 34	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Boolean	Z
    //   6: ifne +17 -> 23
    //   9: aload_0
    //   10: ldc 43
    //   12: iconst_0
    //   13: invokestatic 48	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;I)Z
    //   16: ifeq +7 -> 23
    //   19: iconst_1
    //   20: putstatic 34	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Boolean	Z
    //   23: getstatic 34	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Boolean	Z
    //   26: ifeq +17 -> 43
    //   29: aload_1
    //   30: iload_2
    //   31: fload_3
    //   32: invokestatic 52	com/tencent/mobileqq/utils/AudioHelper:enlargeVolum	([BIF)J
    //   35: lstore 4
    //   37: ldc 2
    //   39: monitorexit
    //   40: lload 4
    //   42: lreturn
    //   43: ldc2_w 9
    //   46: lstore 4
    //   48: goto -11 -> 37
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramContext	Context
    //   0	57	1	paramArrayOfByte	byte[]
    //   0	57	2	paramInt	int
    //   0	57	3	paramFloat	float
    //   35	12	4	l	long
    // Exception table:
    //   from	to	target	type
    //   3	23	51	finally
    //   23	37	51	finally
  }
  
  public static AudioHelper.AudioPlayerParameter a()
  {
    if (c()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, true);
    }
    if (g()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, true);
    }
    if (h()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, true);
    }
    if (i()) {
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
      return localAudioPlayerParameter;
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
  
  public static void a(int paramInt, AudioHelper.AudioPlayerParameter paramAudioPlayerParameter)
  {
    String str = "!@$#_" + paramInt + "_";
    PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext()).edit().putInt(str + "m", paramAudioPlayerParameter.jdField_a_of_type_Int).putInt(str + "s", paramAudioPlayerParameter.b).putBoolean(str + "so", paramAudioPlayerParameter.jdField_a_of_type_Boolean).commit();
  }
  
  public static boolean a()
  {
    return (e()) || (d());
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
    if (c()) {
      return new AudioHelper.AudioPlayerParameter(0, 3, false);
    }
    if (g()) {
      return new AudioHelper.AudioPlayerParameter(0, 2, false);
    }
    if (h()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (i()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (j()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (k()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new AudioHelper.AudioPlayerParameter(0, 3, false);
    }
    return new AudioHelper.AudioPlayerParameter(0, 2, false);
  }
  
  public static boolean b()
  {
    if ((!f()) || (Build.VERSION.SDK_INT < 17)) {}
    for (;;)
    {
      return false;
      Object localObject = BaseApplicationImpl.getContext().getSystemService("appops");
      if ((localObject != null) && (localObject.getClass().getSimpleName().equals("AppOpsManager"))) {
        try
        {
          Method localMethod = localObject.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          int i = 27;
          if (Build.VERSION.SDK_INT < 19) {
            i = 36;
          }
          ApplicationInfo localApplicationInfo = BaseApplicationImpl.getContext().getApplicationInfo();
          i = ((Integer)localMethod.invoke(localObject, new Object[] { Integer.valueOf(i), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
          if (QLog.isColorLevel()) {
            QLog.d(AudioHelper.class.getSimpleName(), 2, "isForbidByRubbishMeizu(), result = " + i);
          }
          if (i != 0) {}
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
  
  private static boolean c()
  {
    String str = Build.MODEL;
    int i;
    if (((Build.MANUFACTURER.equalsIgnoreCase("Samsung")) || (str.contains("MI 2"))) && (Build.VERSION.SDK_INT >= 11))
    {
      i = 1;
      if (i == 0) {
        break label47;
      }
    }
    label47:
    while ((str.contains("SCH-I699")) && (Build.VERSION.SDK_INT == 10))
    {
      return true;
      i = 0;
      break;
    }
    return false;
  }
  
  private static boolean d()
  {
    return Build.MODEL.contains("Lenovo A750");
  }
  
  private static boolean e()
  {
    String str = Build.MODEL;
    return (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (str.contains("X907"));
  }
  
  @Deprecated
  public static native long enlargeVolum(byte[] paramArrayOfByte, int paramInt, float paramFloat);
  
  private static boolean f()
  {
    return "Meizu".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  private static boolean g()
  {
    String str = Build.MODEL;
    return (str.contains("Lenovo A278t")) || (str.contains("Lenovo A789"));
  }
  
  private static boolean h()
  {
    return (Build.MODEL.contains("ME860")) && (Build.VERSION.SDK_INT == 10);
  }
  
  private static boolean i()
  {
    return Build.MODEL.equals("HUAWEI U9508");
  }
  
  private static boolean j()
  {
    return Build.MODEL.equals("MI 3");
  }
  
  private static boolean k()
  {
    return Build.MODEL.equals("MI 1S");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioHelper
 * JD-Core Version:    0.7.0.1
 */