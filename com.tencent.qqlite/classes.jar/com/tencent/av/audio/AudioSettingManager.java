package com.tencent.av.audio;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import java.io.File;
import java.lang.reflect.Method;

public class AudioSettingManager
{
  public static int a;
  static boolean jdField_a_of_type_Boolean;
  static int b;
  public static boolean b;
  static int jdField_c_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f = false;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
  }
  
  public AudioSettingManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  static int a()
  {
    return jdField_b_of_type_Int;
  }
  
  public static int a(Context paramContext)
  {
    if (!jdField_b_of_type_Boolean) {
      return ((AudioManager)paramContext.getSystemService("audio")).getStreamVolume(3);
    }
    return jdField_a_of_type_Int;
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      boolean bool = Boolean.parseBoolean(paramContext.getClass().getMethod("isWiredHeadsetOn", new Class[0]).invoke(paramContext, (Object[])null).toString());
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  static int b()
  {
    return jdField_c_of_type_Int;
  }
  
  static boolean j()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public int a(int paramInt)
  {
    return ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio")).getStreamVolume(paramInt);
  }
  
  void a()
  {
    if (!jdField_b_of_type_Boolean) {
      return;
    }
    AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio");
    localAudioManager.setMode(this.jdField_d_of_type_Int);
    localAudioManager.setSpeakerphoneOn(this.jdField_e_of_type_Boolean);
    localAudioManager.setMicrophoneMute(this.f);
    jdField_b_of_type_Boolean = false;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio");
    int i = paramInt1;
    if (paramInt1 > localAudioManager.getStreamMaxVolume(paramInt2)) {
      i = localAudioManager.getStreamMaxVolume(paramInt2);
    }
    localAudioManager.setStreamVolume(paramInt2, i, 0);
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio")).setMicrophoneMute(this.jdField_d_of_type_Boolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (jdField_b_of_type_Boolean) {
      return;
    }
    AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio");
    this.jdField_d_of_type_Int = localAudioManager.getMode();
    this.jdField_e_of_type_Boolean = localAudioManager.isSpeakerphoneOn();
    this.f = localAudioManager.isMicrophoneMute();
    if (c())
    {
      localAudioManager.setMode(0);
      jdField_b_of_type_Int = 0;
      if (paramInt != 0)
      {
        if (1 != paramInt) {
          break label191;
        }
        localAudioManager.setMode(0);
        jdField_b_of_type_Int = 0;
      }
    }
    for (;;)
    {
      this.jdField_e_of_type_Int = localAudioManager.getStreamVolume(0);
      jdField_a_of_type_Int = localAudioManager.getStreamVolume(3);
      a(false);
      jdField_b_of_type_Boolean = true;
      jdField_a_of_type_Boolean = paramBoolean;
      if (true != jdField_a_of_type_Boolean) {
        break label208;
      }
      jdField_c_of_type_Int = 3;
      return;
      if ((a()) || (d()) || (g()) || (h()))
      {
        localAudioManager.setMode(0);
        jdField_b_of_type_Int = 0;
        break;
      }
      if (i())
      {
        localAudioManager.setMode(0);
        jdField_b_of_type_Int = 0;
        break;
      }
      localAudioManager.setMode(2);
      jdField_b_of_type_Int = 2;
      break;
      label191:
      if (2 == paramInt)
      {
        localAudioManager.setMode(2);
        jdField_b_of_type_Int = 2;
      }
    }
    label208:
    jdField_c_of_type_Int = 0;
  }
  
  public boolean a()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    return (str1.contains("motorola")) || (str2.contains("Milestone")) || (str2.contains("MB860")) || (str2.contains("XT882")) || (str2.contains("Nexus S"));
  }
  
  public int b(int paramInt)
  {
    return ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio")).getStreamMaxVolume(paramInt);
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio")).setSpeakerphoneOn(this.jdField_c_of_type_Boolean);
  }
  
  public boolean b()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    return (str1.contains("samsung")) || (str2.contains("SAMSUNG")) || (str2.contains("SPH-")) || (str2.contains("SGH-")) || (str2.contains("GT-")) || (str2.contains("SCH-"));
  }
  
  public boolean c()
  {
    String str = Build.MODEL;
    return (str.contains("GT-I9082")) || (str.contains("SCH-W2013")) || (str.contains("GT-B9388")) || (str.contains("SCH-I939D")) || (str.contains("GT-N7100 ")) || (str.contains("GT-N7102")) || (str.contains("GT-I8552")) || (str.contains("GT-I9260")) || (str.contains("GT-I9500")) || (str.contains("GT-I9502")) || (str.contains("SCH-I959")) || (str.contains("GT-I9508"));
  }
  
  public boolean d()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    return (str2.contains("D530")) || (str1.contains("YuLong")) || (str2.contains("8150"));
  }
  
  public boolean e()
  {
    return Build.MANUFACTURER.contains("ZTE");
  }
  
  public boolean f()
  {
    return Build.MANUFACTURER.contains("Xiaomi");
  }
  
  public boolean g()
  {
    String str = Build.MANUFACTURER;
    return Build.MODEL.contains("X10");
  }
  
  public boolean h()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    return (str1.contains("HTC")) && (str2.contains("HTC One X"));
  }
  
  public boolean i()
  {
    File localFile1 = new File("/proc/asound/sprdphone");
    File localFile2 = new File("/sys/bus/platform/drivers/sc8800g_vsp");
    File localFile3 = new File("/sys/bus/platform/drivers/sc88xx-vbc");
    return ((localFile1.isDirectory()) && (localFile2.isDirectory())) || ((localFile1.isDirectory()) && (localFile3.isDirectory()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.av.audio.AudioSettingManager
 * JD-Core Version:    0.7.0.1
 */