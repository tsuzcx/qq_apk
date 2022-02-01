package com.tencent.av.utils;

import acfp;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqge;
import ausj;
import auss;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sharp.jni.TraeAudioSession;
import com.tencent.sharp.jni.TraeAudioSession.a;
import com.tencent.widget.ListView;
import iiv;
import imm;
import iwu;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jjk;
import jjm;
import jkg;
import jkn;
import jlg;
import jlh;
import jli;
import jlj;
import mqq.util.WeakReference;

public class TraeHelper
{
  static TraeHelper jdField_a_of_type_ComTencentAvUtilsTraeHelper;
  public static int aBf;
  public static int aBg = 1;
  public static final long[] v = { 100L, 1500L, 1500L, 1500L, 1500L };
  String SL = null;
  String SM = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  private a jdField_a_of_type_ComTencentAvUtilsTraeHelper$a;
  c jdField_a_of_type_ComTencentAvUtilsTraeHelper$c = null;
  public TraeAudioSession a;
  private int aBh = 0;
  private int aBi = 0;
  int aBj = -1;
  private boolean aab;
  private boolean aac;
  private boolean aad;
  private boolean aae;
  private boolean aaf;
  private boolean aag;
  private boolean aah;
  public MediaPlayer.OnCompletionListener c;
  Runnable cp = new TraeHelper.4(this);
  private iiv h;
  WeakReference<Context> m;
  boolean mHasInit = false;
  int mVoiceStreamType = 0;
  WeakReference<Button> n = null;
  WeakReference<d> o = null;
  
  public TraeHelper(Context paramContext, VideoController paramVideoController, Button paramButton)
  {
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = null;
    this.m = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    e(paramButton);
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$c = new c();
    axJ();
    b(-1031L, this.jdField_a_of_type_ComTencentAvVideoController.b());
  }
  
  public static String S(Context paramContext)
  {
    if (imm.getCpuArchitecture() > 2) {}
    for (String str = "/txlib/libtraeimp-qq.so";; str = "/txlib/libtraeimp-armeabi.so")
    {
      paramContext = paramContext.getFilesDir().getParent() + str;
      try
      {
        System.load(paramContext);
        return paramContext;
      }
      catch (UnsatisfiedLinkError paramContext) {}
    }
    return null;
  }
  
  public static TraeHelper a()
  {
    try
    {
      TraeHelper localTraeHelper = jdField_a_of_type_ComTencentAvUtilsTraeHelper;
      return localTraeHelper;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TraeHelper a(Context paramContext, VideoController paramVideoController)
  {
    if (jdField_a_of_type_ComTencentAvUtilsTraeHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvUtilsTraeHelper == null) {
        jdField_a_of_type_ComTencentAvUtilsTraeHelper = new TraeHelper(paramContext, paramVideoController, null);
      }
      return jdField_a_of_type_ComTencentAvUtilsTraeHelper;
    }
    finally {}
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TraeSessionHelper", 2, "startShake seq[" + paramLong + "]");
    }
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.getApp() == null)) {}
    do
    {
      do
      {
        return;
      } while ((!n(paramVideoAppInterface)) || (!ai(paramVideoAppInterface.getApp().getApplicationContext())));
      paramVideoAppInterface = (Vibrator)paramVideoAppInterface.getApp().getSystemService("vibrator");
    } while (paramVideoAppInterface == null);
    if (paramBoolean)
    {
      paramVideoAppInterface.vibrate(200L);
      return;
    }
    paramVideoAppInterface.vibrate(v, 1);
  }
  
  public static boolean ai(Context paramContext)
  {
    int i = SettingCloneUtil.readValueForInt(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
    int j = (int)(AudioHelper.hF() / 1000L);
    boolean bool = true;
    if (j <= i) {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TraeSessionHelper", 2, "canDisturb, ret[" + bool + "], cur[" + j + "], mode[" + i + "]");
    }
    return bool;
  }
  
  private void axL()
  {
    if (this.n != null)
    {
      Button localButton = (Button)this.n.get();
      if (localButton != null)
      {
        Context localContext = localButton.getContext();
        if (localContext != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TraeSessionHelper", 2, "switchButton_handFree onUpdateButtonHandFree()");
          }
          ThreadManager.postImmediately(new TraeHelper.5(this, localButton, localContext), null, false);
        }
      }
    }
  }
  
  private Drawable b(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramResources = localObject;
    }
    for (;;)
    {
      if ((paramResources != null) && (!paramBoolean)) {
        paramResources.setBounds(0, 0, paramResources.getIntrinsicWidth(), paramResources.getIntrinsicHeight());
      }
      return paramResources;
      if (paramBoolean)
      {
        paramResources = jjm.a(paramResources, 2130842898, false);
      }
      else
      {
        paramResources = jlg.a(paramResources, 2130842848, 2131166238);
        continue;
        if (paramBoolean)
        {
          paramResources = jjm.a(paramResources, 2130842897, false);
        }
        else
        {
          paramResources = jlg.a(paramResources, 2130842847, 2131166238);
          continue;
          if (paramBoolean)
          {
            paramResources = jjm.a(paramResources, 2130842846);
          }
          else
          {
            paramResources = jlg.a(paramResources, 2130843121, 2131166275);
            continue;
            if (paramBoolean)
            {
              paramResources = jjm.a(paramResources, 2130842850);
            }
            else
            {
              paramResources = jlg.a(paramResources, 2130843128, 2131166275);
              continue;
              if (paramBoolean)
              {
                paramResources = jjm.a(paramResources, 2130842849);
              }
              else
              {
                paramResources = jlg.a(paramResources, 2130843123, 2131166275);
                continue;
                if (paramBoolean) {
                  paramResources = jjm.a(paramResources, 2130842897, false);
                } else {
                  paramResources = jlg.a(paramResources, 2130843126, 2131166275);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void bk(String paramString1, String paramString2)
  {
    if ((!this.aae) && (!this.aad) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      this.aad = "DEVICE_BLUETOOTHHEADSET".equals(paramString1);
    }
  }
  
  private static boolean m(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramVideoAppInterface == null) {
      bool2 = bool1;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool2;
              if (paramVideoAppInterface.b().sB())
              {
                QLog.d("Q.nearby.video_chat", 1, "canPlayRing false, app.getVideoController().getSessionInfo().uinType == AppConstants.VALUE.UIN_TYPE_NEARBY_VIDEO_CHAT");
                return false;
              }
              SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramVideoAppInterface.getApp());
              bool1 = bool2;
              if (paramVideoAppInterface.getCurrentAccountUin() != null)
              {
                String str = paramVideoAppInterface.getCurrentAccountUin();
                bool1 = bool2;
                if (str != null) {
                  bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.getApp().getString(2131697102) + str, true);
                }
              }
              bool2 = bool1;
            } while (aqge.LR() == 0);
            bool2 = bool1;
          } while (!bool1);
          bool2 = bool1;
        } while (jkg.isRingerVibrate(paramVideoAppInterface.getApp()));
        bool2 = bool1;
      } while (jkg.isRingEqualsZero(paramVideoAppInterface.getApp()));
      bool2 = bool1;
    } while (jkg.isCalling(paramVideoAppInterface.getApp()));
    return true;
  }
  
  static boolean n(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool2;
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.getApp() == null)) {
      bool2 = false;
    }
    do
    {
      boolean bool1;
      do
      {
        do
        {
          return bool2;
          SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramVideoAppInterface.getApp());
          bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.getApp().getString(2131697103), true);
          String str = paramVideoAppInterface.getCurrentAccountUin();
          if (str != null) {
            bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.getApp().getString(2131697103) + str, true);
          }
          bool2 = bool1;
        } while (aqge.LR() == 0);
        bool2 = bool1;
      } while (!bool1);
      bool2 = bool1;
    } while (jkg.isCalling(paramVideoAppInterface.getApp()));
    return true;
  }
  
  private void p(String[] paramArrayOfString)
  {
    boolean bool = this.aae;
    if (paramArrayOfString != null) {}
    for (this.aae = Arrays.asList(paramArrayOfString).contains("DEVICE_BLUETOOTHHEADSET");; this.aae = false)
    {
      if ((this.aae != bool) && (this.aae))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D1D at: " + System.currentTimeMillis());
        }
        anot.a(null, "CliOper", "", "", "0X8008D1D", "0X8008D1D", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  public static void t(VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.getApp() == null)) {}
    do
    {
      return;
      paramVideoAppInterface = (Vibrator)paramVideoAppInterface.getApp().getSystemService("vibrator");
    } while (paramVideoAppInterface == null);
    paramVideoAppInterface.cancel();
  }
  
  public int a(long paramLong, String paramString1, String paramString2)
  {
    int i = 0;
    Throwable localThrowable = null;
    if (QLog.isDevelopLevel()) {
      localThrowable = new Throwable("打印调用栈");
    }
    StringBuilder localStringBuilder = new StringBuilder().append("startService, config[").append(paramString1).append("], WhenServiceOn[").append(paramString2).append("], mHasStartService[").append(this.aab).append("], mAudioSession[");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
    {
      bool = true;
      QLog.w("TraeSessionHelper", 1, bool + "], seq[" + paramLong + "]", localThrowable);
      this.SM = paramString2;
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.m.get(), this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$c);
      }
      if (!this.aab) {
        break label189;
      }
      if (!paramString1.equals(this.SL)) {
        break label181;
      }
    }
    label181:
    label189:
    int j;
    do
    {
      return i;
      bool = false;
      break;
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.stopService();
      j = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(paramLong, paramString1, paramString2);
      i = j;
    } while (j != 0);
    this.SL = paramString1;
    this.aab = true;
    return j;
  }
  
  public boolean a(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if ((m(paramVideoAppInterface)) && (ai(paramVideoAppInterface.getApp().getApplicationContext())))
    {
      TraeAudioSession localTraeAudioSession;
      boolean bool;
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
      {
        if ((QLog.isDevelopLevel()) || (this.c != paramOnCompletionListener)) {
          QLog.w("TraeSessionHelper", 1, "startInviteRing, mRingComListener[" + this.c + "->" + paramOnCompletionListener + "], seq[" + paramLong + "]");
        }
        this.c = paramOnCompletionListener;
        if (paramInt1 != SoundAndVibrateActivity.bAf)
        {
          localTraeAudioSession = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
          if (paramInt2 < 0)
          {
            bool = true;
            if (paramInt2 > 0) {
              break label168;
            }
            paramInt2 = 1;
            label133:
            if (paramOnCompletionListener == null) {
              break label171;
            }
            paramVideoAppInterface = "comp-ring";
            label142:
            localTraeAudioSession.a(paramLong, 0, paramInt1, null, null, bool, paramInt2, paramVideoAppInterface, true);
          }
        }
      }
      for (;;)
      {
        return true;
        bool = false;
        break;
        label168:
        break label133;
        label171:
        paramVideoAppInterface = "normal-ring";
        break label142;
        localTraeAudioSession = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
        Uri localUri = Settings.System.DEFAULT_NOTIFICATION_URI;
        if (paramInt2 < 0)
        {
          bool = true;
          label197:
          if (paramInt2 > 0) {
            break label241;
          }
          paramInt1 = 1;
          label205:
          if (paramOnCompletionListener == null) {
            break label248;
          }
        }
        label241:
        label248:
        for (paramVideoAppInterface = "comp-ring";; paramVideoAppInterface = "normal-ring")
        {
          localTraeAudioSession.a(paramLong, 1, -1, localUri, null, bool, paramInt1, paramVideoAppInterface, true);
          break;
          bool = false;
          break label197;
          paramInt1 = paramInt2;
          break label205;
        }
        aqge.a(paramInt1, paramInt2, paramOnCompletionListener);
      }
    }
    return false;
  }
  
  public boolean a(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    boolean bool;
    int i;
    label139:
    int j;
    try
    {
      if ((m(paramVideoAppInterface)) && (ai(paramVideoAppInterface.getApp().getApplicationContext())))
      {
        if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
        {
          if ((QLog.isDevelopLevel()) || (this.c != paramOnCompletionListener)) {
            QLog.w("TraeSessionHelper", 1, "startRing, mRingComListener[" + this.c + "->" + paramOnCompletionListener + "], seq[" + paramLong + "]");
          }
          this.c = paramOnCompletionListener;
          if (paramInt2 >= 0) {
            break label271;
          }
          bool = true;
          break label230;
          for (;;)
          {
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(paramLong, paramInt1, paramInt2, paramVideoAppInterface, paramString, bool, i, paramOnCompletionListener);
            break;
            if (paramInt1 != SoundAndVibrateActivity.bAf)
            {
              j = 0;
              paramVideoAppInterface = null;
              paramString = null;
              paramInt2 = paramInt1;
              paramInt1 = j;
            }
            else
            {
              paramInt1 = 1;
              paramVideoAppInterface = Settings.System.DEFAULT_NOTIFICATION_URI;
              paramString = null;
              paramInt2 = -1;
            }
          }
        }
        aqge.a(paramInt1, paramInt2, paramOnCompletionListener);
      }
    }
    catch (Exception paramVideoAppInterface)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("TraeSessionHelper", 1, "startRing, Exception", paramVideoAppInterface);
      }
      return false;
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("TraeSessionHelper", 1, "startRing, fail");
    }
    return false;
    label230:
    if (paramInt2 <= 0)
    {
      i = 1;
      label238:
      if (paramOnCompletionListener == null) {
        break label284;
      }
    }
    label271:
    label284:
    for (paramOnCompletionListener = "comp-ring";; paramOnCompletionListener = "normal-ring")
    {
      if (paramInt1 != 0) {
        break label139;
      }
      j = 2;
      paramVideoAppInterface = null;
      paramInt2 = paramInt1;
      paramInt1 = j;
      break;
      return true;
      bool = false;
      break label230;
      i = paramInt2;
      break label238;
    }
  }
  
  public void axH()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("TraeSessionHelper", 1, "setHFBtnStatus, deviceName[" + this.jdField_a_of_type_ComTencentAvVideoController.b().deviceName + "], seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.b().P("setHFBtnStatus", "DEVICE_SPEAKERPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.b().deviceName));
    b(l, this.jdField_a_of_type_ComTencentAvVideoController.b());
  }
  
  public void axI()
  {
    Throwable localThrowable = null;
    if (QLog.isDevelopLevel()) {
      localThrowable = new Throwable("打印调用栈");
    }
    StringBuilder localStringBuilder = new StringBuilder().append("stopSerivce, mHasStartService[").append(this.aab).append("], mAudioSession[");
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("TraeSessionHelper", 1, bool + "]", localThrowable);
      if (this.aab) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.m.get(), this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$c);
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.stopService();
    this.aab = false;
  }
  
  public void axJ()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    long l = AudioHelper.hG();
    if (this.mHasInit)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.b().deviceName))
      {
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(l, this.jdField_a_of_type_ComTencentAvVideoController.b().deviceName);
        return;
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.connectHighestPriorityDevice();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeSessionHelper", 1, "initTRAE, seq[" + l + "]");
    }
    if ((this.m != null) && (this.m.get() != null))
    {
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "initTRAE new mAudioSession");
        }
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.m.get(), this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$c);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.b().deviceName)) {
        break label214;
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(l, this.jdField_a_of_type_ComTencentAvVideoController.b().deviceName);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.getStreamType();
      this.mHasInit = true;
      return;
      label214:
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.connectHighestPriorityDevice();
    }
  }
  
  public void axK()
  {
    nQ(aBf);
  }
  
  public int b(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("connectDevice, strDevice[").append(paramString).append("], mAudioSession[");
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
        break label114;
      }
    }
    label114:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("TraeSessionHelper", 1, bool + "], seq[" + paramLong + "]");
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.m.get(), this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$c);
      }
      return this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(paramLong, paramString);
    }
  }
  
  public void b(long paramLong, iiv paramiiv)
  {
    if (paramiiv == null) {
      if (QLog.isColorLevel()) {
        QLog.w("TraeSessionHelper", 1, "switchButton_handFree, !sessionInfo, seq[" + paramLong + "]");
      }
    }
    while (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeSessionHelper", 1, "switchButton_handFree, isSpeakerOn[" + paramiiv.QB + "], seq[" + paramLong + "]");
    }
    this.h = paramiiv;
    this.jdField_a_of_type_ComTencentAvVideoController.a().getHandler().removeCallbacks(this.cp);
    this.jdField_a_of_type_ComTencentAvVideoController.a().getHandler().postDelayed(this.cp, 100L);
  }
  
  public boolean b(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        if ((m(paramVideoAppInterface)) && (ai(paramVideoAppInterface.getApp().getApplicationContext())))
        {
          if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
          {
            if ((QLog.isDevelopLevel()) || (this.c != paramOnCompletionListener)) {
              QLog.w("TraeSessionHelper", 1, "startInviteRing, [" + this.c + "->" + paramOnCompletionListener + "], seq[" + paramLong + "]");
            }
            this.c = paramOnCompletionListener;
            Object localObject;
            if (paramInt1 == 0)
            {
              localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
              if (paramInt2 >= 0) {
                continue;
              }
              bool = true;
              continue;
              ((TraeAudioSession)localObject).a(paramLong, 2, paramInt1, null, paramString, bool, paramInt2, paramVideoAppInterface, true);
              continue;
            }
            else
            {
              if (paramInt1 != SoundAndVibrateActivity.bAf)
              {
                paramString = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
                if (paramInt2 >= 0) {
                  break label311;
                }
                bool = true;
                continue;
                paramString.a(paramLong, 0, paramInt1, null, null, bool, paramInt2, paramVideoAppInterface, true);
                continue;
              }
              paramString = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
              localObject = Settings.System.DEFAULT_NOTIFICATION_URI;
              if (paramInt2 >= 0) {
                break label347;
              }
              bool = true;
              break label327;
              paramString.a(paramLong, 1, -1, (Uri)localObject, null, bool, paramInt1, paramVideoAppInterface, true);
              continue;
            }
          }
          else
          {
            aqge.a(paramInt1, paramInt2, paramOnCompletionListener);
            continue;
          }
        }
        else {
          return false;
        }
        if (paramInt2 <= 0)
        {
          paramInt2 = 1;
          if (paramOnCompletionListener != null)
          {
            paramVideoAppInterface = "comp-ring";
            continue;
            return true;
            bool = false;
            continue;
          }
        }
        else
        {
          continue;
        }
        paramVideoAppInterface = "normal-ring";
        continue;
        if (paramInt2 > 0) {
          break label317;
        }
        paramInt2 = 1;
        if (paramOnCompletionListener == null) {
          break label320;
        }
        paramVideoAppInterface = "comp-ring";
        continue;
        bool = false;
      }
      catch (Exception paramVideoAppInterface)
      {
        return false;
      }
      label311:
      continue;
      label317:
      continue;
      label320:
      paramVideoAppInterface = "normal-ring";
      continue;
      label327:
      if (paramInt2 <= 0) {}
      for (paramInt1 = 1;; paramInt1 = paramInt2)
      {
        if (paramOnCompletionListener == null) {
          break label360;
        }
        paramVideoAppInterface = "comp-ring";
        break;
        label347:
        bool = false;
        break label327;
      }
      label360:
      paramVideoAppInterface = "normal-ring";
    }
  }
  
  public int connectHighestPriorityDevice()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TraeSessionHelper", 2, "connectHighestPriorityDevice");
    }
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.m.get(), this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$c);
    }
    return this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.connectHighestPriorityDevice();
  }
  
  public void d(Button paramButton)
  {
    this.n = new WeakReference(paramButton);
    this.aaf = false;
  }
  
  public void dN(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.as(paramLong);
      return;
    }
    aqge.bVz();
  }
  
  public void e(Button paramButton)
  {
    this.n = new WeakReference(paramButton);
    this.aaf = true;
  }
  
  public void ee(long paramLong)
  {
    try
    {
      QLog.w("TraeSessionHelper", 1, "releaseTRAE, seq[" + paramLong + "]");
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
      {
        axI();
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.release();
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = null;
        if (QLog.isColorLevel()) {
          QLog.w("TraeSessionHelper", 1, "releaseTRAE, mAudioSession.release, seq[" + paramLong + "]");
        }
        this.mHasInit = false;
      }
      this.c = null;
      return;
    }
    finally {}
  }
  
  public void lk(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TraeSessionHelper", 2, String.format("setLightStyle lightStyle=%s mLightBtnStyle=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aag) }));
    }
    this.aag = paramBoolean;
    axL();
  }
  
  public void nQ(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null)) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int j;
    if (paramInt == aBg)
    {
      j = 1;
      if (!QLog.isDevelopLevel()) {
        break label726;
      }
    }
    label535:
    label583:
    label717:
    label724:
    label726:
    for (Object localObject1 = new Throwable("打印调用栈");; localObject1 = null)
    {
      long l = AudioHelper.hG();
      QLog.w("TraeSessionHelper", 1, "pressHandFreeBtn, isSpeakerOn[" + ((iiv)localObject2).QB + "], seq[" + l + "]", (Throwable)localObject1);
      Object localObject3 = ((iiv)localObject2).aK;
      if ((QLog.isColorLevel()) && (localObject3 != null))
      {
        localObject1 = new StringBuilder();
        paramInt = 0;
        for (;;)
        {
          if (paramInt < localObject3.length)
          {
            ((StringBuilder)localObject1).append(localObject3[paramInt]).append(";");
            paramInt += 1;
            continue;
            j = 0;
            break;
          }
        }
        QLog.w("TraeSessionHelper", 1, "pressHandFreeBtn, strDeviceList[" + localObject1 + "]");
      }
      p((String[])localObject3);
      Button localButton;
      if (localObject3 != null) {
        if ((this.aae) && (jkn.xE()))
        {
          if (this.n == null) {
            break label717;
          }
          localButton = (Button)this.n.get();
          if (localButton == null) {
            break label711;
          }
          localObject1 = localButton.getContext();
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label724;
        }
        localObject3 = new b((String[])localObject3);
        if (!TextUtils.isEmpty(((iiv)localObject2).MY)) {
          ((b)localObject3).setBluetoothName(((iiv)localObject2).MY);
        }
        localObject2 = (ausj)auss.a((Context)localObject1, null);
        ((ausj)localObject2).setMainTitle(2131697806);
        ListView localListView = new ListView((Context)localObject1);
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$a == null) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$a = new a((Context)localObject1, (b)localObject3);
        }
        for (;;)
        {
          localListView.setAdapter(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$a);
          localListView.setDivider(new ColorDrawable(Color.parseColor("#e5e3e4")));
          localListView.setDividerHeight(1);
          if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null) {
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.ar(l);
          }
          localListView.setOnItemClickListener(new jlh(this, localButton, l, (ausj)localObject2));
          ((ausj)localObject2).addView(localListView);
          ((ausj)localObject2).addCancelButton(2131721058);
          ((ausj)localObject2).a(new jli(this));
          ((ausj)localObject2).setOnShowListener(new jlj(this));
          ((ausj)localObject2).show();
          return;
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$a.a((Context)localObject1, (b)localObject3);
        }
        int k;
        if (((iiv)localObject2).QB)
        {
          int i = 0;
          do
          {
            k = 0;
            paramInt = i;
            if (k < localObject3.length)
            {
              paramInt = i;
              if (i == 0)
              {
                if (!"DEVICE_WIREDHEADSET".equals(localObject3[k])) {
                  break;
                }
                this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(l, "DEVICE_WIREDHEADSET");
                paramInt = 1;
              }
            }
            k = 0;
            i = paramInt;
            if (k < localObject3.length)
            {
              i = paramInt;
              if (paramInt == 0)
              {
                if (!"DEVICE_BLUETOOTHHEADSET".equals(localObject3[k])) {
                  break label653;
                }
                this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(l, "DEVICE_BLUETOOTHHEADSET");
                i = 1;
              }
            }
            k = 0;
            paramInt = i;
            if (k < localObject3.length)
            {
              paramInt = i;
              if (i == 0)
              {
                if (!"DEVICE_EARPHONE".equals(localObject3[k])) {
                  break label662;
                }
                this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(l, "DEVICE_EARPHONE");
                paramInt = 1;
              }
            }
            i = paramInt;
          } while (paramInt == 0);
        }
        for (;;)
        {
          if (j == 0) {
            break label685;
          }
          this.aac = true;
          return;
          k += 1;
          break;
          k += 1;
          break label535;
          k += 1;
          break label583;
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(l, "DEVICE_SPEAKERPHONE");
        }
        break;
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "pressHandFreeBtn: devicesList is null");
        }
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.getDeviceList();
        return;
        localObject1 = null;
        continue;
        localButton = null;
        localObject1 = null;
      }
      break;
    }
  }
  
  public int startService(String paramString)
  {
    return a(AudioHelper.hG(), paramString, null);
  }
  
  public boolean xP()
  {
    return this.aab;
  }
  
  static class ActionSheetCustomView
    extends RelativeLayout
  {
    private ImageView gX;
    private ImageView gY;
    private TextView mTextView;
    
    public ActionSheetCustomView(Context paramContext, int paramInt, CharSequence paramCharSequence)
    {
      super();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(paramContext.getResources().getDimensionPixelSize(2131298334), 0, 0, 0);
      localLayoutParams.addRule(15, -1);
      localLayoutParams.addRule(9, -1);
      this.gY = new ImageView(paramContext);
      this.gY.setImageResource(paramInt);
      this.gY.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(0, 0, paramContext.getResources().getDimensionPixelSize(2131298334), 0);
      localLayoutParams.addRule(15, -1);
      localLayoutParams.addRule(11, -1);
      this.gX = new ImageView(paramContext);
      this.gX.setImageResource(2130843124);
      this.gX.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(15, -1);
      localLayoutParams.addRule(14, -1);
      this.mTextView = new TextView(paramContext);
      this.mTextView.setText(paramCharSequence);
      this.mTextView.setLayoutParams(localLayoutParams);
      this.mTextView.setGravity(17);
      this.mTextView.setTextColor(-16777216);
      this.mTextView.setTextSize(0, paramContext.getResources().getDimension(2131299577));
      addView(this.gY);
      addView(this.mTextView);
      addView(this.gX);
      setBackgroundResource(2130837644);
      setId(2131370155);
      setMinimumHeight(paramContext.getResources().getDimensionPixelSize(2131296886));
    }
    
    public void setChecked(boolean paramBoolean)
    {
      ImageView localImageView = this.gX;
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        localImageView.setVisibility(i);
        return;
      }
    }
    
    public void setIcon(int paramInt)
    {
      this.gY.setImageResource(paramInt);
    }
    
    public void setText(CharSequence paramCharSequence)
    {
      this.mTextView.setText(paramCharSequence);
    }
  }
  
  public static class a
    extends BaseAdapter
  {
    TraeHelper.b a;
    private String[] aT;
    private int mCheckedIndex;
    private Context mContext;
    
    a(Context paramContext, @NonNull TraeHelper.b paramb)
    {
      this.mContext = paramContext;
      this.mCheckedIndex = 0;
      this.a = paramb;
      this.aT = paramb.x();
    }
    
    public void a(Context paramContext, @NonNull TraeHelper.b paramb)
    {
      if (paramContext != null) {
        this.mContext = paramContext;
      }
      this.aT = paramb.x();
      this.a = paramb;
      notifyDataSetInvalidated();
    }
    
    public int getCount()
    {
      if (this.a != null) {
        return this.a.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return this.a.a(this.aT[paramInt]);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject = (TraeHelper.b.a)getItem(paramInt);
      if (localObject != null) {
        if (paramView == null)
        {
          paramView = new TraeHelper.ActionSheetCustomView(this.mContext, ((TraeHelper.b.a)localObject).resId, ((TraeHelper.b.a)localObject).name);
          localObject = (TraeHelper.ActionSheetCustomView)paramView;
          if (paramInt != this.mCheckedIndex) {
            break label117;
          }
        }
      }
      label117:
      for (boolean bool = true;; bool = false)
      {
        ((TraeHelper.ActionSheetCustomView)localObject).setChecked(bool);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        ((TraeHelper.ActionSheetCustomView)paramView).setText(((TraeHelper.b.a)localObject).name);
        paramView.setContentDescription(((TraeHelper.b.a)localObject).name);
        ((TraeHelper.ActionSheetCustomView)paramView).setIcon(((TraeHelper.b.a)localObject).resId);
        break;
      }
    }
    
    public void kO(String paramString)
    {
      int j = getCount();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          TraeHelper.b.a locala = (TraeHelper.b.a)getItem(i);
          if ((locala != null) && (locala.SN != null) && (locala.SN.equals(paramString))) {
            nR(i);
          }
        }
        else
        {
          return;
        }
        i += 1;
      }
    }
    
    public void nR(int paramInt)
    {
      this.mCheckedIndex = paramInt;
      notifyDataSetChanged();
    }
  }
  
  public static class b
  {
    private String[] aU;
    private Map<String, a> dl = new HashMap();
    
    public b(String[] paramArrayOfString)
    {
      this.aU = paramArrayOfString;
      if (paramArrayOfString != null)
      {
        int j = paramArrayOfString.length;
        int i = 0;
        if (i < j)
        {
          String str = paramArrayOfString[i];
          if ("DEVICE_BLUETOOTHHEADSET".equals(str)) {
            this.dl.put(str, new a(2130843120, acfp.m(2131715401), str));
          }
          for (;;)
          {
            i += 1;
            break;
            if ("DEVICE_EARPHONE".equals(str)) {
              this.dl.put(str, new a(2130843122, acfp.m(2131715402), str));
            } else if ("DEVICE_SPEAKERPHONE".equals(str)) {
              this.dl.put(str, new a(2130843125, acfp.m(2131715405), str));
            } else if ("DEVICE_WIREDHEADSET".equals(str)) {
              this.dl.put(str, new a(2130843127, acfp.m(2131715403), str));
            }
          }
        }
      }
    }
    
    public a a(String paramString)
    {
      return (a)this.dl.get(paramString);
    }
    
    public void setBluetoothName(String paramString)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        a locala = (a)this.dl.get("DEVICE_BLUETOOTHHEADSET");
        if (locala != null) {
          locala.name = (acfp.m(2131715404) + paramString + "）");
        }
      }
    }
    
    public int size()
    {
      return this.dl.size();
    }
    
    public String[] x()
    {
      return this.aU;
    }
    
    public class a
    {
      public String SN;
      public String name;
      public int resId;
      
      public a(int paramInt, String paramString1, String paramString2)
      {
        this.resId = paramInt;
        this.name = paramString1;
        this.SN = paramString2;
      }
    }
  }
  
  class c
    implements TraeAudioSession.a
  {
    c() {}
    
    public void S(long paramLong, boolean paramBoolean)
    {
      if ((paramBoolean) && (!TextUtils.isEmpty(TraeHelper.this.SM)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeSessionHelper", 1, "ConnectDeviceWhenServiceOn, deviceName[" + TraeHelper.this.SM + "], seq[" + paramLong + "]");
        }
        TraeHelper.this.b(paramLong, TraeHelper.this.SM);
      }
    }
    
    public void U(long paramLong, int paramInt)
    {
      if (TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController == null) {
        return;
      }
      TraeHelper.this.mVoiceStreamType = paramInt;
      TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b().audioStreamType = paramInt;
      if (QLog.isColorLevel()) {
        QLog.w("TraeSessionHelper", 1, "onStreamTypeUpdate, streamType[" + paramInt + "], seq[" + paramLong + "]");
      }
      TraeHelper.this.b(paramLong, TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b());
    }
    
    public void a(long paramLong, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
    {
      int j = 0;
      Object localObject;
      int i;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        i = 0;
        while (i < paramArrayOfString.length)
        {
          ((StringBuilder)localObject).append(paramArrayOfString[i]).append(" ");
          i += 1;
        }
        QLog.w("TraeSessionHelper", 1, "onDeviceListUpdate, strConnectedDeviceName[" + paramString1 + "], strPrevConnectedDeviceName[" + paramString2 + "], bluetoothName[" + paramString3 + "], strDeviceList[" + ((StringBuilder)localObject).toString() + "], seq[" + paramLong + "]");
      }
      if (TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController == null) {}
      label393:
      do
      {
        do
        {
          return;
          localObject = TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b();
          paramString2 = "";
          String[] arrayOfString = ((iiv)localObject).aK;
          if (((iiv)localObject).amH != 3)
          {
            paramString2 = ((iiv)localObject).deviceName;
            ((iiv)localObject).aQ("onDeviceListUpdate", paramString1);
          }
          ((iiv)localObject).aK = paramArrayOfString;
          ((iiv)localObject).MY = paramString3;
          TraeHelper.a(TraeHelper.this, paramArrayOfString);
          TraeHelper.a(TraeHelper.this, paramString2, paramString1);
          if (TraeHelper.a(TraeHelper.this) != null) {
            TraeHelper.a(TraeHelper.this).notifyDataSetChanged();
          }
          TraeHelper.this.axH();
          if ((TraeHelper.this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null) && (arrayOfString != null) && (paramArrayOfString != null))
          {
            paramString2 = Arrays.asList(arrayOfString);
            paramString3 = Arrays.asList(paramArrayOfString);
            if ((paramString3.contains("DEVICE_BLUETOOTHHEADSET")) && (paramString3.contains("DEVICE_WIREDHEADSET")))
            {
              if ((!paramString2.contains("DEVICE_BLUETOOTHHEADSET")) || (paramString2.contains("DEVICE_WIREDHEADSET"))) {
                break label393;
              }
              if ("DEVICE_BLUETOOTHHEADSET".equals(paramString1)) {
                TraeHelper.this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(paramLong, "DEVICE_WIREDHEADSET");
              }
            }
          }
          while (paramArrayOfString != null)
          {
            i = j;
            while (i < paramArrayOfString.length)
            {
              if (paramArrayOfString[i].equals("DEVICE_WIREDHEADSET")) {
                jjk.m(TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController);
              }
              i += 1;
            }
            if ((!paramString2.contains("DEVICE_BLUETOOTHHEADSET")) && (paramString2.contains("DEVICE_WIREDHEADSET")) && ("DEVICE_WIREDHEADSET".equals(paramString1))) {
              TraeHelper.this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(paramLong, "DEVICE_BLUETOOTHHEADSET");
            }
          }
          if (!TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b().mAudioStateBeforePhoneCall.equals("DEVICE_NONE"))
          {
            if (!paramString1.equals(TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b().mAudioStateBeforePhoneCall)) {
              TraeHelper.this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(paramLong, TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b().mAudioStateBeforePhoneCall);
            }
            TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b().mAudioStateBeforePhoneCall = "DEVICE_NONE";
          }
        } while (TraeHelper.a(TraeHelper.this) == null);
        TraeHelper.a(TraeHelper.this).a(null, new TraeHelper.b(paramArrayOfString));
      } while (TraeHelper.this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null);
      TraeHelper.this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.ar(paramLong);
    }
    
    public void g(long paramLong, int paramInt, String paramString)
    {
      MediaPlayer.OnCompletionListener localOnCompletionListener = TraeHelper.this.c;
      TraeHelper.this.c = null;
      QLog.w("TraeSessionHelper", 1, "onRingCompletion, err[" + paramInt + "], userData[" + paramString + "], mRingComListener[" + localOnCompletionListener + "], seq[" + paramLong + "]");
      if (localOnCompletionListener != null) {
        localOnCompletionListener.onCompletion(null);
      }
    }
    
    public void kP(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TraeSessionHelper", 2, "onBeginConnectDevice connectedDev: " + paramString);
      }
      if ("DEVICE_BLUETOOTHHEADSET".equals(paramString)) {
        iwu.b((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 3012);
      }
    }
    
    public void onAudioRouteSwitchEnd(String paramString, long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TraeSessionHelper", 2, "onAudioRouteSwitchEnd connectedDev: " + paramString + " timsMs: " + paramLong);
      }
    }
    
    public void onAudioRouteSwitchStart(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TraeSessionHelper", 2, "onAudioRoteSwitchStart fromDev: " + paramString1 + " toDev: " + paramString2);
      }
    }
    
    public void onConnectDeviceRes(int paramInt, String paramString, boolean paramBoolean)
    {
      long l = AudioHelper.hG();
      if (QLog.isColorLevel()) {
        QLog.w("TraeSessionHelper", 1, "onConnectDeviceRes, err[" + paramInt + "], strDeviceName[" + paramString + "], bIsConnected[" + paramBoolean + "], seq[" + l + "]");
      }
      if ((!paramBoolean) || (TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController == null)) {}
      do
      {
        return;
        if (TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b().amH != 3) {
          TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b().aQ("onConnectDeviceRes", paramString);
        }
        TraeHelper.this.axH();
      } while (TraeHelper.this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null);
      TraeHelper.this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.ar(l);
    }
    
    public void onDeviceChangabledUpdate(boolean paramBoolean)
    {
      if (TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController == null) {}
      Button localButton;
      do
      {
        int i;
        do
        {
          return;
          i = TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
        } while (((i == 1) || (i == 2)) && ((!TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.sp()) || (!TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b().isConnected()) || (TraeHelper.this.n == null)));
        localButton = (Button)TraeHelper.this.n.get();
      } while ((localButton == null) || (paramBoolean == localButton.isClickable()));
      localButton.setClickable(paramBoolean);
    }
    
    public void onGetConnectedDeviceRes(int paramInt, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TraeSessionHelper", 2, "onGetConnectedDeviceRes err is: " + paramInt + " device name is: " + paramString);
      }
      if (TraeHelper.a(TraeHelper.this) != null) {
        TraeHelper.a(TraeHelper.this).kO(paramString);
      }
    }
    
    public void onGetConnectingDeviceRes(int paramInt, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TraeSessionHelper", 2, "onGetConnectingDeviceRes strDeviceName: " + paramString);
      }
    }
    
    public void onGetDeviceListRes(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
    {
      int i = 0;
      if (paramInt != 0) {}
      for (;;)
      {
        return;
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramInt = 0;
          while (paramInt < paramArrayOfString.length)
          {
            paramString2.append(paramArrayOfString[paramInt]).append(" ");
            paramInt += 1;
          }
          QLog.d("TraeSessionHelper", 2, "onGetDeviceListRes strDeviceList: " + paramString2.toString());
        }
        if (TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          paramString2 = TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b().deviceName;
          TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b().aK = paramArrayOfString;
          TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b().aQ("onGetDeviceListRes", paramString1);
          TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b().MY = paramString3;
          TraeHelper.a(TraeHelper.this, paramArrayOfString);
          TraeHelper.a(TraeHelper.this, paramString2, paramString1);
          if (paramArrayOfString != null)
          {
            paramInt = i;
            while (paramInt < paramArrayOfString.length)
            {
              if (paramArrayOfString[paramInt].equals("DEVICE_WIREDHEADSET")) {
                jjk.m(TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController);
              }
              paramInt += 1;
            }
          }
        }
      }
    }
    
    public void onGetStreamTypeRes(int paramInt1, int paramInt2)
    {
      if (paramInt1 != 0) {}
      while (TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController == null) {
        return;
      }
      TraeHelper.this.mVoiceStreamType = paramInt2;
      TraeHelper.this.jdField_a_of_type_ComTencentAvVideoController.b().audioStreamType = paramInt2;
    }
    
    public void onIsDeviceChangabledRes(int paramInt, boolean paramBoolean) {}
    
    public void onVoicecallPreprocessRes(int paramInt) {}
  }
  
  public static abstract interface d
  {
    public abstract void H(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper
 * JD-Core Version:    0.7.0.1
 */