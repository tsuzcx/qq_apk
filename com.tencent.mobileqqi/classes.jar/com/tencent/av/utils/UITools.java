package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import bmk;
import com.tencent.av.VideoConstants;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sharp.jni.TraeAudioSession;
import java.util.Calendar;
import java.util.Locale;

public class UITools
{
  public static MediaPlayer.OnCompletionListener a;
  static TraeAudioSession jdField_a_of_type_ComTencentSharpJniTraeAudioSession = null;
  public static boolean a;
  static final long[] jdField_a_of_type_ArrayOfLong;
  
  static
  {
    jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = null;
    jdField_a_of_type_ArrayOfLong = new long[] { 100L, 1500L, 1500L, 1500L, 1500L };
    jdField_a_of_type_Boolean = true;
  }
  
  public static float a()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (!MobileIssueSettings.f) {
      KapalaiAdapterUtil.a().a(localLayoutParams);
    }
    for (;;)
    {
      return localLayoutParams.screenBrightness;
      localLayoutParams.screenBrightness = 0.034F;
    }
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static String a(long paramLong)
  {
    String str = "00:00";
    long l1;
    long l2;
    if (paramLong > 0L)
    {
      l1 = paramLong % 60L;
      l2 = paramLong / 60L;
      paramLong = l2 / 60L;
      l2 %= 60L;
      if (paramLong > 0L) {
        str = String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(l1) });
      }
    }
    else
    {
      return str;
    }
    return String.format(Locale.CHINA, "%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
  }
  
  public static String a(Context paramContext, String paramString, TextView paramTextView, float paramFloat)
  {
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = paramString;
    if (paramFloat > 0.0F)
    {
      float f1 = localTextPaint.measureText(paramString);
      paramTextView = paramString;
      if (f1 > paramFloat)
      {
        float f2 = paramFloat - localTextPaint.measureText("...");
        paramFloat = f1;
        paramContext = paramString;
        while ((f2 > 0.0F) && (paramFloat > f2) && (paramContext.length() > 0))
        {
          paramTextView = paramContext.substring(0, paramContext.length() - 1);
          f1 = localTextPaint.measureText(paramTextView);
          paramContext = paramTextView;
          paramFloat = f1;
          if (f1 == 0.0F)
          {
            paramContext = paramTextView;
            paramFloat = f1;
            if (paramTextView.length() > 0)
            {
              paramFloat = 1.0F + f2;
              paramContext = paramTextView;
            }
          }
        }
        paramTextView = paramString;
        if (f2 > 0.0F)
        {
          paramTextView = paramString;
          if (paramContext.length() > 0) {
            paramTextView = paramContext + "...";
          }
        }
      }
    }
    return paramTextView;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null) {
      jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a();
    }
    jdField_a_of_type_ComTencentSharpJniTraeAudioSession = null;
  }
  
  public static void a(Activity paramActivity, float paramFloat)
  {
    if (paramActivity == null) {}
    do
    {
      return;
      paramActivity = paramActivity.getWindow();
    } while (paramActivity == null);
    WindowManager.LayoutParams localLayoutParams = paramActivity.getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    paramActivity.setAttributes(localLayoutParams);
  }
  
  public static void a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
      jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession(paramContext, new bmk());
    }
  }
  
  public static void a(View paramView, String paramString)
  {
    if (jdField_a_of_type_Boolean)
    {
      paramView.setFocusable(true);
      paramView.setContentDescription(paramString);
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
    {
      jdField_a_of_type_ComTencentSharpJniTraeAudioSession.h();
      return;
    }
    ((BaseApplicationImpl)paramVideoAppInterface.a()).a();
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    if ((b(paramVideoAppInterface)) && (a(paramVideoAppInterface.a().getApplicationContext())))
    {
      paramVideoAppInterface = (Vibrator)paramVideoAppInterface.a().getSystemService("vibrator");
      if (paramVideoAppInterface != null)
      {
        if (!paramBoolean) {
          break label49;
        }
        paramVideoAppInterface.vibrate(200L);
      }
    }
    return;
    label49:
    paramVideoAppInterface.vibrate(jdField_a_of_type_ArrayOfLong, 1);
  }
  
  static boolean a(Context paramContext)
  {
    if ((SettingCloneUtil.readValue(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false)) && ((VideoConstants.b) || (!ReflectionUtil.a(BaseApplicationImpl.a))))
    {
      int i = Calendar.getInstance().get(11);
      if ((i >= 23) || (i < 8)) {
        return false;
      }
    }
    return true;
  }
  
  static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramVideoAppInterface.a());
    String str;
    if (paramVideoAppInterface.a() != null)
    {
      str = paramVideoAppInterface.a();
      if (str == null) {}
    }
    for (boolean bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.a().getString(2131563420) + str, true);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (((BaseApplicationImpl)paramVideoAppInterface.a()).a() != 0)
      {
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!PhoneStatusTools.b(paramVideoAppInterface.a()))
          {
            bool2 = bool1;
            if (!PhoneStatusTools.d(paramVideoAppInterface.a()))
            {
              bool2 = bool1;
              if (!PhoneStatusTools.e(paramVideoAppInterface.a())) {
                bool2 = true;
              }
            }
          }
        }
      }
      return bool2;
    }
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if ((a(paramVideoAppInterface)) && (a(paramVideoAppInterface.a().getApplicationContext())))
    {
      TraeAudioSession localTraeAudioSession;
      boolean bool;
      if (jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = paramOnCompletionListener;
        if (paramInt1 != SoundAndVibrateActivity.a)
        {
          localTraeAudioSession = jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
          if (paramInt2 < 0)
          {
            bool = true;
            if (paramInt2 > 0) {
              break label85;
            }
            paramInt2 = 1;
            label55:
            if (paramOnCompletionListener == null) {
              break label88;
            }
            paramVideoAppInterface = "comp-ring";
            label63:
            localTraeAudioSession.a(0, paramInt1, null, null, bool, paramInt2, paramVideoAppInterface);
          }
        }
      }
      for (;;)
      {
        return true;
        bool = false;
        break;
        label85:
        break label55;
        label88:
        paramVideoAppInterface = "normal-ring";
        break label63;
        localTraeAudioSession = jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
        Uri localUri = Settings.System.DEFAULT_NOTIFICATION_URI;
        if (paramInt2 < 0)
        {
          bool = true;
          label112:
          if (paramInt2 > 0) {
            break label150;
          }
          paramInt1 = 1;
          label118:
          if (paramOnCompletionListener == null) {
            break label155;
          }
        }
        label150:
        label155:
        for (paramVideoAppInterface = "comp-ring";; paramVideoAppInterface = "normal-ring")
        {
          localTraeAudioSession.a(1, -1, localUri, null, bool, paramInt1, paramVideoAppInterface);
          break;
          bool = false;
          break label112;
          paramInt1 = paramInt2;
          break label118;
        }
        ((BaseApplicationImpl)paramVideoAppInterface.a()).a(paramInt1, paramInt2, paramOnCompletionListener);
      }
    }
    return false;
  }
  
  public static int b(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = (Vibrator)paramVideoAppInterface.a().getSystemService("vibrator");
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface.cancel();
    }
  }
  
  static boolean b(VideoAppInterface paramVideoAppInterface)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramVideoAppInterface.a());
    boolean bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.a().getString(2131563421), true);
    String str = paramVideoAppInterface.a();
    if (str != null) {
      bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.a().getString(2131563421) + str, true);
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (((BaseApplicationImpl)paramVideoAppInterface.a()).a() != 0)
      {
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!PhoneStatusTools.e(paramVideoAppInterface.a())) {
            bool2 = true;
          }
        }
      }
      return bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.utils.UITools
 * JD-Core Version:    0.7.0.1
 */