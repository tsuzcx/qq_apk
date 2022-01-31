package com.tencent.av;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import bgb;
import bgc;
import bgd;
import bge;
import bgf;
import bgg;
import bgh;
import bgi;
import bgj;
import bgk;
import bgl;
import bgm;
import bgn;
import bgo;
import bgp;
import bgr;
import bgs;
import bgt;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.audio.VcAudioManager;
import com.tencent.av.camera.VcCamera;
import com.tencent.av.camera.VideoChatSettings;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.core.AbstractNetChannel;
import com.tencent.av.core.IVcAudioData;
import com.tencent.av.core.IVcController;
import com.tencent.av.core.IVideoEventListener;
import com.tencent.av.core.VcController;
import com.tencent.av.gaudio.AVGQuality;
import com.tencent.av.gaudio.GaInviteActivity;
import com.tencent.av.gaudio.GaInviteDialogActivity;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.QQGlRender;
import com.tencent.av.report.AVReport;
import com.tencent.av.service.UtilsServiceForAV;
import com.tencent.av.thread.FutureListener;
import com.tencent.av.thread.ThreadPool;
import com.tencent.av.ui.VChatActivity;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.av.ui.VideoInviteLock;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.UITools;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioSession;
import com.tencent.sharp.jni.TraeAudioSession.ITraeAudioCallback;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class VideoController
  extends AbstractNetChannel
  implements IVideoSession, IVideoEventListener
{
  public static final int E = 0;
  public static final int F = 1;
  public static final int G = 0;
  public static final int H = 1;
  public static final int I = 2;
  public static final int J = 0;
  public static final int K = 1;
  public static final int L = 1;
  public static final int M = 2;
  public static final int N = 3;
  public static final int O = 4;
  public static final int Q = 0;
  public static final int R = 1;
  public static final int S = 2;
  public static final int T = 3;
  public static final int U = 4;
  static bgt jdField_a_of_type_Bgt;
  static VideoController jdField_a_of_type_ComTencentAvVideoController;
  public static String a;
  static bgt jdField_b_of_type_Bgt;
  public static String d;
  public static String e;
  public static String f;
  private static String jdField_g_of_type_JavaLangString;
  int C = -1;
  int D = 0;
  int P = 0;
  public int V = 0;
  int W = 1;
  int X = 2;
  int Y = 3;
  int Z = 4;
  public long a;
  public Context a;
  AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = null;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  MediaPlayer.OnCompletionListener jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new bgm(this);
  public bgs a;
  public SessionInfo a;
  public VideoAppInterface a;
  VcAudioManager jdField_a_of_type_ComTencentAvAudioVcAudioManager = null;
  VcCamera jdField_a_of_type_ComTencentAvCameraVcCamera = null;
  public IVcController a;
  GaInviteActivity jdField_a_of_type_ComTencentAvGaudioGaInviteActivity = null;
  QQGAudioCtrl jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
  public GraphicRenderMgr a;
  ThreadPool jdField_a_of_type_ComTencentAvThreadThreadPool = new ThreadPool(1, 1);
  public PhoneStatusMonitor.PhoneStatusListener a;
  public PhoneStatusMonitor a;
  GAClientLogReport jdField_a_of_type_ComTencentAvVideoCallGAClientLogReport = null;
  public TraeAudioSession a;
  Runnable jdField_a_of_type_JavaLangRunnable = new bgj(this);
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = true;
  public long b;
  public MediaPlayer.OnCompletionListener b;
  Runnable jdField_b_of_type_JavaLangRunnable = new bgk(this);
  public String b;
  ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  public long c;
  Runnable jdField_c_of_type_JavaLangRunnable = null;
  public String c;
  boolean jdField_c_of_type_Boolean = false;
  Runnable jdField_d_of_type_JavaLangRunnable = null;
  boolean jdField_d_of_type_Boolean = false;
  Runnable jdField_e_of_type_JavaLangRunnable = null;
  boolean jdField_e_of_type_Boolean = false;
  Runnable f;
  public boolean f;
  public Runnable g;
  boolean jdField_g_of_type_Boolean = false;
  Runnable jdField_h_of_type_JavaLangRunnable = new bgh(this);
  boolean jdField_h_of_type_Boolean = false;
  public boolean i = false;
  boolean j = false;
  boolean k;
  public boolean l = false;
  boolean m = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VideoController";
    jdField_a_of_type_Bgt = null;
    jdField_b_of_type_Bgt = null;
    jdField_a_of_type_ComTencentAvVideoController = null;
    jdField_g_of_type_JavaLangString = "com.tencent.av.count";
    jdField_d_of_type_JavaLangString = "Video";
    jdField_e_of_type_JavaLangString = "Audio";
    jdField_f_of_type_JavaLangString = "GAudio";
  }
  
  private VideoController()
  {
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentAvCoreIVcController = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = null;
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new bgn(this);
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_f_of_type_JavaLangRunnable = null;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_g_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Bgs = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 0;
  }
  
  private int a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController == null) {
      return -1;
    }
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
      return this.jdField_a_of_type_ComTencentAvCoreIVcController.d(paramString);
    case 1: 
      return this.jdField_a_of_type_ComTencentAvCoreIVcController.e(paramString);
    case 2: 
      return this.jdField_a_of_type_ComTencentAvCoreIVcController.f(paramString);
    }
    return this.jdField_a_of_type_ComTencentAvCoreIVcController.g(paramString);
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int n = 0;
    int i2 = 0;
    int i1 = i2;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 4) {
        i1 = i2;
      }
    }
    else {
      return i1;
    }
    i2 = 0;
    for (;;)
    {
      i1 = n;
      if (i2 >= paramInt) {
        break;
      }
      n = (int)(n | (paramArrayOfByte[i2] & 0xFF) << (paramInt - i2 - 1) * 8);
      i2 += 1;
    }
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 8) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    int i1;
    for (int n = 0;; n = i1)
    {
      l2 = l1;
      if (n >= paramInt) {
        break;
      }
      l2 = paramArrayOfByte[n];
      i1 = n + 1;
      l1 = (l2 & 0xFF) << (paramInt - n - 1) * 8 | l1;
    }
  }
  
  public static VideoController a()
  {
    if (jdField_a_of_type_ComTencentAvVideoController == null) {
      jdField_a_of_type_ComTencentAvVideoController = new VideoController();
    }
    return jdField_a_of_type_ComTencentAvVideoController;
  }
  
  private boolean a(long paramLong, long[] paramArrayOfLong)
  {
    boolean bool2 = false;
    int i1 = paramArrayOfLong.length;
    int n = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (n < i1)
      {
        if (paramLong == paramArrayOfLong[n]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      n += 1;
    }
  }
  
  public static int b()
  {
    int i1 = 1;
    String str1 = Build.MODEL;
    String str2 = Build.VERSION.INCREMENTAL;
    String str3 = Build.MANUFACTURER;
    int i2 = Build.VERSION.SDK_INT;
    int n;
    if ((str3.equalsIgnoreCase("HUAWEI")) && (str1.equalsIgnoreCase("C8500")))
    {
      n = i1;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "DEVICE_NOT_SUPPORT");
        n = i1;
      }
    }
    for (;;)
    {
      if ((n != 0) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Model: " + str1 + "\n" + "Version: " + str2 + "\n" + "Manufacturer: " + str3 + "\n" + "SDK Version: " + i2);
      }
      return n;
      if ((str3.equalsIgnoreCase("Samsung")) && (str1.equalsIgnoreCase("GT-I5508")))
      {
        n = i1;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "DEVICE_NOT_SUPPORT");
          n = i1;
        }
      }
      else if ((str3.equalsIgnoreCase("FIH")) && (str1.equalsIgnoreCase("SH8128U")))
      {
        n = i1;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "DEVICE_NOT_SUPPORT");
          n = i1;
        }
      }
      else if (i2 < 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "SDK_NOT_SUPPORT");
        }
        n = 2;
      }
      else
      {
        n = 0;
      }
    }
  }
  
  private void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaChatPPTInOrOut,groupUin=" + paramLong1 + "uin=" + paramLong2 + "bIn=" + paramBoolean);
    }
    f(paramLong2, paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(77), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(78), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
  
  private void b(long paramLong, long[] paramArrayOfLong, boolean paramBoolean)
  {
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    boolean bool2 = a(l1, paramArrayOfLong);
    Object localObject;
    if ((paramBoolean) && (bool2))
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_g_of_type_JavaLangRunnable);
      localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
      if (this.jdField_k_of_type_Boolean) {
        break label146;
      }
    }
    long l2;
    label146:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((QQGAudioCtrl)localObject).setMicState(bool1);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      l2 = paramArrayOfLong[0];
      if (l2 != 0L) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioUserEnterOrLeave-->friendUin = 0 isEnter=" + paramBoolean + " groupUin=" + paramLong);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioUserEnterOrLeave-->GroupId=" + paramLong + "friendUin=" + l2 + "isEnter=" + paramBoolean + "bSelfIn" + bool2 + "selfUin=" + l1);
    }
    c(l2, paramBoolean);
    label292:
    label348:
    int n;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int < 10)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (a(l1, paramArrayOfLong)))
        {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 9;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.w = false;
        }
      }
      else
      {
        if (!paramBoolean) {
          break label557;
        }
        bool1 = false;
        if (this.jdField_f_of_type_Boolean) {
          bool1 = true;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(61), Long.valueOf(paramLong), paramArrayOfLong, Boolean.valueOf(bool1) });
        n = 0;
        label351:
        if (n < paramArrayOfLong.length)
        {
          l1 = paramArrayOfLong[n];
          localObject = new Intent();
          ((Intent)localObject).setAction("tencent.av.v2q.MultiVideo");
          ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
          if (!paramBoolean) {
            break label590;
          }
          ((Intent)localObject).putExtra("type", 22);
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("roomUserNum", this.jdField_a_of_type_JavaUtilArrayList.size());
      ((Intent)localObject).putExtra("discussId", paramLong);
      ((Intent)localObject).putExtra("friendUin", l1);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject);
      n += 1;
      break label351;
      break;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 10;
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Long != 0L) {
        break label292;
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      break label292;
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() != 1) || (((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long != l1)) {
        break label292;
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 9;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.w = true;
      break label292;
      label557:
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong), paramArrayOfLong });
      break label348;
      label590:
      ((Intent)localObject).putExtra("type", 23);
    }
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface)
  {
    Intent localIntent = new Intent(paramVideoAppInterface.getApplication(), VChatActivity.class);
    localIntent.addFlags(268435456);
    paramVideoAppInterface.getApplication().startActivity(localIntent);
  }
  
  private void c(long paramLong, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaChatVideoInOrOut-->Groupid=" + paramLong + "user=" + paramArrayOfLong[0] + "bVideoIn=" + paramBoolean);
    }
    e(paramArrayOfLong[0], paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(69), Long.valueOf(paramLong), paramArrayOfLong });
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(70), Long.valueOf(paramLong), paramArrayOfLong });
  }
  
  public static int d(String paramString)
  {
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences(jdField_g_of_type_JavaLangString, 0);
    int n = ((SharedPreferences)localObject).getInt(paramString, 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(paramString, n + 1);
    ((SharedPreferences.Editor)localObject).commit();
    return n;
  }
  
  private void d(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        int n = b(paramLong);
        if (n == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
          }
          return;
        }
        ((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_Boolean = paramBoolean;
        return;
      }
    }
  }
  
  private void e(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int n;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        n = b(paramLong);
        if (n == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberVideoInOrOut-->Can not find the.Uin=" + paramLong);
          }
          return;
        }
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(n);
        if (localGAudioFriends.jdField_c_of_type_Boolean)
        {
          localGAudioFriends.jdField_b_of_type_Boolean = paramBoolean;
          return;
        }
      }
      int i1 = b(bgr.jdField_c_of_type_Int);
      if (i1 == -1)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(n);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      for (;;)
      {
        localObject.jdField_b_of_type_Boolean = paramBoolean;
        return;
        if (i1 != n) {
          if (n < i1)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(i1, localObject);
            this.jdField_a_of_type_JavaUtilArrayList.remove(n);
          }
          else
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(n);
            this.jdField_a_of_type_JavaUtilArrayList.add(i1, localObject);
          }
        }
      }
    }
  }
  
  private void f(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      for (;;)
      {
        int n;
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          n = b(paramLong);
          if (n == -1)
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
            }
            return;
          }
          VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(n);
          if (paramBoolean)
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(n);
            this.jdField_a_of_type_JavaUtilArrayList.add(0, localGAudioFriends);
            localGAudioFriends.jdField_c_of_type_Boolean = paramBoolean;
            return;
          }
        }
        if (localObject.jdField_b_of_type_Boolean)
        {
          localObject.jdField_c_of_type_Boolean = paramBoolean;
          return;
        }
        int i1 = b(bgr.jdField_c_of_type_Int);
        if (i1 == -1)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(n);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        else if (i1 != n)
        {
          if (n < i1)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(i1, localObject);
            this.jdField_a_of_type_JavaUtilArrayList.remove(n);
          }
          else
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(n);
            this.jdField_a_of_type_JavaUtilArrayList.add(i1, localObject);
          }
        }
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController != null) {
      this.jdField_a_of_type_ComTencentAvCoreIVcController.c();
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvAudioVcAudioManager == null) || (this.jdField_a_of_type_ComTencentAvCoreIVcController.b())) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentAvAudioVcAudioManager.a(paramInt);
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    int n = 0;
    if (paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        n = -1;
      case 0: 
        return n;
      case 1006: 
        return 5;
      case 1000: 
        return 8;
      case 1004: 
        return 9;
      case 1001: 
        return 12;
      }
      return 10;
    }
    switch (paramInt)
    {
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    case 11: 
    default: 
      return -1;
    case 5: 
      return 1006;
    case 8: 
      return 1000;
    case 9: 
      return 1004;
    case 12: 
      return 1001;
    }
    return 1021;
  }
  
  public int a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getVolume();
  }
  
  public int a(long paramLong, long[] paramArrayOfLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startGAudioChat groupId: " + paramLong + ", uinList: " + paramArrayOfLong);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return -1;
    }
    this.l = false;
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    if (a().jdField_e_of_type_Boolean) {}
    for (int n = 2;; n = 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getSessionInfo().localHasVideo = " + a().jdField_e_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startGAudio(2, 1, n, paramLong, paramArrayOfLong, e(), l1, a().o);
      if (this.jdField_g_of_type_JavaLangRunnable == null) {
        this.jdField_g_of_type_JavaLangRunnable = new bgf(this, paramLong);
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 8;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_j_of_type_JavaLangString = String.valueOf(paramLong);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_g_of_type_JavaLangRunnable, 30000L);
      k();
      a(3, false, false);
      return 0;
    }
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController != null) {
      return this.jdField_a_of_type_ComTencentAvCoreIVcController.c(paramString);
    }
    return -1;
  }
  
  public int a(String paramString, int paramInt1, int paramInt2)
  {
    int n = -1;
    int i1;
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      i1 = -2;
    }
    do
    {
      return i1;
      i1 = n;
    } while (this.jdField_a_of_type_ComTencentAvCoreIVcController == null);
    if (paramInt1 == 0) {
      n = this.jdField_a_of_type_ComTencentAvCoreIVcController.a(paramString, 0L, e(), 0, paramInt2);
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "acceptRequest: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", toUin = " + paramString + ", result = " + n);
      }
      i1 = n;
      if (n != 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 3;
      o();
      return n;
      if (1 == paramInt1) {
        n = this.jdField_a_of_type_ComTencentAvCoreIVcController.a(paramString, 0L, e(), 2, paramInt2);
      }
    }
  }
  
  public int a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "request selfUin: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", toUin: " + paramString1 + ", businessType: " + paramInt1 + ", relationType: " + paramInt2 + ", fromNation: " + paramString2 + ", fromMobile: " + paramString3 + ", toMobile: " + paramString4 + ", uinType: " + paramInt3 + ", extraUin: " + paramString5 + ", sig: " + paramArrayOfByte);
      if (paramArrayOfByte != null) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "request sigLength: " + paramArrayOfByte.length);
      }
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "network not support!");
      }
      return -2;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "controller is null!");
      }
      return -1;
    }
    if ((paramInt3 == 1006) && (paramString1.startsWith("+"))) {
      paramString1 = paramString1.substring(1);
    }
    for (;;)
    {
      int i1 = a(paramInt3, true);
      if (i1 == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "request accostType = " + i1);
        }
        return -1;
      }
      int n = -1;
      if (paramInt1 == 0)
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.v = true;
        n = this.jdField_a_of_type_ComTencentAvCoreIVcController.a(paramString1, 0L, e(), 0, paramInt2, paramString2, paramString3, paramString4, i1, paramString5, paramString6, paramArrayOfByte);
        AVReport.a().o = this.jdField_a_of_type_ComTencentAvAppSessionInfo.v;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "request result = " + n + ", uinType = " + paramInt3 + ", accostType = " + i1);
        }
        if (n == 0)
        {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 1;
          if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int != 4)) {
            this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          }
          k();
          if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.v) {
            break label566;
          }
        }
      }
      label566:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        a(paramInt1, false, false);
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_h_of_type_Int = -1;
        this.j = false;
        r(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.x = false;
        return n;
        if (1 != paramInt1) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.v = false;
        n = this.jdField_a_of_type_ComTencentAvCoreIVcController.a(paramString1, 0L, e(), 2, paramInt2, paramString2, paramString3, paramString4, i1, paramString5, paramString6, paramArrayOfByte);
        break;
      }
    }
  }
  
  public int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController != null) {
      this.jdField_a_of_type_ComTencentAvCoreIVcController.a(paramBoolean);
    }
    return 0;
  }
  
  public int a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController == null) {}
    do
    {
      return -1;
      if (this.jdField_a_of_type_ComTencentAvCoreIVcController.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "sharp SetAudioInputMute: " + paramBoolean);
        }
        return this.jdField_a_of_type_ComTencentAvCoreIVcController.a(paramString, paramBoolean);
      }
    } while (this.jdField_a_of_type_ComTencentAvAudioVcAudioManager == null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "M2M SetAudioInputMute: " + paramBoolean);
    }
    return this.jdField_a_of_type_ComTencentAvAudioVcAudioManager.a(paramBoolean);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Long == 0L) {
      return 0L;
    }
    return (SystemClock.elapsedRealtime() - this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Long) / 1000L;
  }
  
  long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str2;
    do
    {
      for (;;)
      {
        return 0L;
        String str1 = paramString;
        str2 = paramString;
        try
        {
          if (paramString.startsWith("+"))
          {
            str2 = paramString;
            str1 = paramString.substring(1);
          }
          str2 = str1;
          long l1 = Long.parseLong(str1);
          if (l1 >= 10000L) {
            return l1;
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "uin = " + str2 + " is error");
    return 0L;
  }
  
  public Context a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext();
    }
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentAvAppSessionInfo;
  }
  
  public VcCamera a()
  {
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera == null) {
      this.jdField_a_of_type_ComTencentAvCameraVcCamera = new VcCamera(this);
    }
    return this.jdField_a_of_type_ComTencentAvCameraVcCamera;
  }
  
  public AVGQuality a()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getAVGQuality();
    }
    return null;
  }
  
  String a()
  {
    try
    {
      String str = ((TelephonyManager)TelephonyManager.class.getMethod("getDefault", new Class[0]).invoke(TelephonyManager.class, (Object[])null)).getDeviceId();
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public ArrayList a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    h(0);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      if (jdField_a_of_type_Bgt != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(jdField_a_of_type_Bgt);
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramInt != 1) || (jdField_b_of_type_Bgt == null));
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(jdField_b_of_type_Bgt);
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d != 1);
    c(2);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController != null) {
      this.jdField_a_of_type_ComTencentAvCoreIVcController.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      if (jdField_a_of_type_Bgt == null) {
        jdField_a_of_type_Bgt = new bgt(this);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(jdField_a_of_type_Bgt);
      jdField_a_of_type_Bgt.jdField_a_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(jdField_a_of_type_Bgt, paramInt3);
    }
    while (paramInt1 != 1) {
      return;
    }
    if (jdField_b_of_type_Bgt == null) {
      jdField_b_of_type_Bgt = new bgt(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(jdField_b_of_type_Bgt);
    jdField_b_of_type_Bgt.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(jdField_b_of_type_Bgt, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "playRing");
    }
    UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (!UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, paramInt2, paramOnCompletionListener))
    {
      a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, 0);
      c(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppSessionInfo.l);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController != null)
    {
      this.jdField_a_of_type_ComTencentAvCoreIVcController.a(paramInt1, paramInt2, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("SharpReport_Node", 2, "report_node is" + paramInt1);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoMsgBroadcast uinType: " + paramInt1 + ", msgType: " + paramInt2 + ", friendUin: " + paramString1 + ", selfUin: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", isReceiver = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Boolean + ", isVideoMsg = " + paramBoolean + ", extraUin: " + paramString2);
    }
    Intent localIntent;
    int n;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.AddVideoMsg");
      localIntent.setPackage("com.tencent.mobileqqi");
      if (paramInt2 != 21) {
        break label579;
      }
      if ((a().jdField_f_of_type_Int != 11) && (a().jdField_f_of_type_Int != 12)) {
        break label399;
      }
      paramInt1 = 47;
      a().jdField_f_of_type_Int = 0;
      n = 0;
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      localIntent.putExtra("uinType", n);
      localIntent.putExtra("msgType", paramInt2);
      localIntent.putExtra("isVideoMsg", paramBoolean);
      String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      label257:
      label291:
      float f1;
      if ((n == 1004) || (n == 1000) || (n == 1020))
      {
        if (paramInt2 != 20) {
          break label565;
        }
        localIntent.putExtra("friendUin", paramString1);
        localIntent.putExtra("senderUin", str1);
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Boolean) {
          break label484;
        }
        paramBoolean = true;
        localIntent.putExtra("isSender", paramBoolean);
        if (paramInt2 != 41) {
          break label535;
        }
        if (this.jdField_b_of_type_Long > 0L)
        {
          f1 = (float)this.jdField_b_of_type_Long / 1024.0F;
          if (f1 >= 1024.0F) {
            break label489;
          }
          paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f1) }) + "KB";
          label375:
          localIntent.putExtra("extra", paramString1);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
        }
        return;
        label399:
        paramInt1 = 48;
        break;
      }
      if (n == 1006) {
        if (paramString1.startsWith("+")) {
          break label572;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Boolean) {}
        for (paramString1 = paramString2;; paramString1 = str1)
        {
          String str2 = paramString2;
          paramString2 = paramString1;
          paramString1 = str2;
          break;
        }
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Boolean)
        {
          paramString2 = paramString1;
          break;
        }
        paramString2 = str1;
        break;
        label484:
        paramBoolean = false;
        break label291;
        label489:
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f1 / 1024.0F) }) + "MB";
        break label375;
        label535:
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Long > 0L)
        {
          paramString1 = UITools.a(a());
          break label375;
        }
        paramString1 = null;
        break label375;
        label565:
        str1 = paramString2;
        break label257;
        label572:
        paramString2 = paramString1;
      }
      label579:
      n = paramInt1;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "netTrafficSize dataTransfered: dirction = " + paramInt + ", size = " + paramLong);
      }
      Intent localIntent = new Intent("tencent.video.v2q.VideoFlowSize");
      localIntent.putExtra("direction", paramInt);
      localIntent.putExtra("size", paramLong);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    switch (paramInt)
    {
    case 0: 
    case 3: 
    default: 
      return;
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onAVShiftEvent remote switch to video mode,waiting for confirm");
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.v = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "remote confirm switch to video");
    }
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.v = false;
  }
  
  void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      localIntent.setAction("tencent.av.v2q.StopVideoChat");
      localIntent.putExtra("uinType", paramInt1);
      localIntent.putExtra("peerUin", paramString1);
      localIntent.putExtra("extraUin", paramString2);
      localIntent.putExtra("stopReason", paramInt2);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramBoolean) && (!ConfigSystemImpl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())))
    {
      a(paramString1);
      c(paramString1, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.v = paramBoolean;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.x = false;
    AVReport.a().o = this.jdField_a_of_type_ComTencentAvAppSessionInfo.v;
    if (a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext())) {}
    for (Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), VideoInviteLock.class);; localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), VideoInviteFull.class))
    {
      if (NoDisturbUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        localIntent.addFlags(262144);
      }
      localIntent.addFlags(268435456);
      localIntent.putExtra("uinType", paramInt);
      localIntent.putExtra("peerUin", paramString1);
      localIntent.putExtra("extraUin", paramString2);
      localIntent.putExtra("isAudioMode", paramBoolean);
      localIntent.putExtra("curUserStatus", this.P);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().startActivity(localIntent);
      k();
      return;
    }
  }
  
  void a(int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMsgSigBroadcast uinType: " + paramInt + ", peerUin: " + paramString1 + ", extraUin: " + paramString2 + ", sig = " + paramArrayOfByte);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      localIntent.setAction("tencent.video.v2q.AddMsgSig");
      localIntent.putExtra("uinType", paramInt);
      localIntent.putExtra("peerUin", paramString1);
      localIntent.putExtra("extraUin", paramString2);
      localIntent.putExtra("sig", paramArrayOfByte);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int n = 1;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo uinType = " + paramInt + ", fromUin = " + paramString1 + ", extraUin = " + paramString2 + ", sig = " + paramArrayOfByte + ", onlyAudio = " + paramBoolean);
    }
    if (this.jdField_e_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
      this.jdField_e_of_type_JavaLangRunnable = null;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 0;
    }
    VideoConstants.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().booleanValue();
    int i1 = a(paramInt, false);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo converted uinType = " + i1);
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.a())
    {
      if (i1 != -1) {
        break label251;
      }
      this.jdField_a_of_type_ComTencentAvCoreIVcController.b(paramString1, e());
      this.jdField_a_of_type_ComTencentAvCoreIVcController.c(paramString1, 0);
      a();
    }
    label251:
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.f()) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.g()))
      {
        g();
        c(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, 2);
      }
      while (this.jdField_f_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.v = paramBoolean;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 2;
        a(i1, paramString1, paramString2, paramArrayOfByte);
        if (!this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor.a()) {
          break label481;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "recv video request when phone isn't idle: fromUin = " + paramString1);
        }
        if ((!this.i) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.jdField_b_of_type_JavaLangString.equals(paramString1))) {
          break label459;
        }
        this.jdField_a_of_type_ComTencentAvCoreIVcController.b(paramString1, e());
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Ignore video request when phone calling: fromUin = " + paramString1);
        return;
      }
      this.jdField_a_of_type_ComTencentAvCoreIVcController.a(paramString1, e());
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "Ignore video request when chatting: fromUin = " + paramString1);
    return;
    label459:
    this.i = true;
    this.V = i1;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    return;
    label481:
    if (paramBoolean) {}
    for (paramInt = n;; paramInt = 2)
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.g = i1;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString = paramString2;
      if (!this.jdField_f_of_type_Boolean) {
        a(paramInt, false, false);
      }
      a(i1, paramString1, paramString2, paramBoolean);
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.StartVideoChat");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("uinType", this.jdField_a_of_type_ComTencentAvAppSessionInfo.g);
      localIntent.putExtra("peerUin", this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("extraUin", this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("updateTime", paramBoolean1);
      localIntent.putExtra("showTime", paramBoolean2);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(long paramLong)
  {
    int n = 2;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ignoreGAudioChat groupId: " + paramLong);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.ignore(2, paramLong);
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int == 7) {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 0;
    }
    for (;;)
    {
      l();
      a(3000, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), String.valueOf(paramLong), n);
      return;
      n = 3;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioSDKError-->GroupId=" + paramLong + "reason=" + paramInt);
    }
    if (paramLong == 0L) {
      return;
    }
    a(3000, paramInt, false, String.valueOf(paramLong), null);
    if (this.jdField_f_of_type_Boolean) {
      b(paramLong);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong) });
    a();
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioUserSpeak groupId: " + paramLong1 + ", friendUin: " + paramLong2 + "isSpeak:" + paramBoolean);
    }
    if (!this.jdField_f_of_type_Boolean) {}
    do
    {
      return;
      b(paramLong2, paramBoolean);
    } while (this.jdField_a_of_type_JavaUtilArrayList == null);
    int n = 0;
    for (;;)
    {
      if (n < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (paramLong2 == ((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_Long) {
          ((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_Boolean = paramBoolean;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(63), Long.valueOf(paramLong2) });
        return;
      }
      n += 1;
    }
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), paramLong1, paramLong2, paramArrayOfByte);
  }
  
  public void a(long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite: " + paramLong2 + " # groupId: " + paramLong1 + " # multiSubType: " + paramInt);
    }
    VideoConstants.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().booleanValue();
    if (this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor.a()) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite phone is calling");
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_e_of_type_JavaLangRunnable != null)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
          this.jdField_e_of_type_JavaLangRunnable = null;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 0;
        }
      } while (((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int <= 4) && (paramInt != 3)) || (7 == this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int) || ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1)));
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int == 0) {
        a(3, false, false);
      }
      this.jdField_c_of_type_Long = paramLong1;
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int == 0) {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 7;
      }
      if ((paramInt == 3) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Long == 0L) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString != null)) {
        try
        {
          if (paramLong2 == Long.valueOf(a().jdField_a_of_type_JavaLangString).longValue())
          {
            if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.l != 0) {
              break;
            }
            this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 0;
            return;
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInviteError-->Exception=" + localException.getMessage());
          }
        }
      }
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    Object localObject;
    if (a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext()))
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), GaInviteLockActivity.class);
      m();
    }
    for (;;)
    {
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("friendUin", paramLong2);
      ((Intent)localObject).putExtra("discussId", paramLong1);
      ((Intent)localObject).putExtra("memberList", paramArrayOfLong);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().startActivity((Intent)localObject);
      return;
      if (this.jdField_c_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      }
      if (!a().o) {
        a(2131165201, 1, null);
      }
      paramInt = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int;
      c(a().jdField_a_of_type_JavaLangString, 21);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Int = 12;
      if (paramInt == 1) {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int = 3;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.g = 3000;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Long = paramLong1;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_j_of_type_JavaLangString = Long.toString(paramLong1);
        if (paramArrayOfLong != null) {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
        }
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_n_of_type_Int = 1;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b() <= 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.o = true;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101) });
        return;
        if (paramInt == 2) {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int = 4;
        } else {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int = 3;
        }
      }
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.o = false;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.p = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.s = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Boolean;
      b(paramLong1, paramArrayOfLong);
      localObject = QAVNotification.a(this.jdField_a_of_type_AndroidContentContext);
      if (localObject != null) {
        ((QAVNotification)localObject).c();
      }
      f();
      return;
      localObject = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), GaInviteDialogActivity.class);
    }
  }
  
  public void a(long paramLong, String paramString, String[] paramArrayOfString)
  {
    if ((!this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Long != paramLong) || (paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(82), paramString, paramArrayOfString });
  }
  
  public void a(long paramLong, ArrayList paramArrayList)
  {
    int i1 = paramArrayList.size();
    long[] arrayOfLong = new long[i1];
    int n = 0;
    while (n < i1)
    {
      String str = (String)paramArrayList.get(n);
      if (str != null) {
        arrayOfLong[n] = Long.valueOf(str).longValue();
      }
      n += 1;
    }
    a(arrayOfLong, false);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setMicState(paramBoolean);
      if (paramBoolean) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_k_of_type_Boolean = bool;
      paramLong = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
      a(this.jdField_a_of_type_Long, new long[] { paramLong }, paramBoolean);
      return;
    }
  }
  
  public void a(long paramLong, long[] paramArrayOfLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate");
    }
    if (this.jdField_b_of_type_JavaUtilArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate-->mSimpleDataList is null");
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if (paramArrayOfLong == null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), this.jdField_b_of_type_JavaUtilArrayList });
      return;
    }
    int n = 0;
    while (n < paramArrayOfLong.length)
    {
      VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends(this);
      localGAudioFriends.jdField_a_of_type_Long = paramArrayOfLong[n];
      this.jdField_b_of_type_JavaUtilArrayList.add(localGAudioFriends);
      n += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), this.jdField_b_of_type_JavaUtilArrayList });
  }
  
  public void a(long paramLong, long[] paramArrayOfLong, int paramInt)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onGaChatUserInOrOut-->userList is null,OpType = " + paramInt);
      }
    }
    do
    {
      do
      {
        return;
        if (paramArrayOfLong[0] != 0L) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onGaChatUserInOrOut-->optype = " + paramInt + " groupid=" + paramLong + " userUin = 0");
      return;
      switch (paramInt)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "Wrong type of GaChatMemBerInType,and Type = " + paramInt);
    return;
    b(paramLong, paramArrayOfLong, true);
    return;
    b(paramLong, paramArrayOfLong, false);
    return;
    a(paramLong, paramArrayOfLong, true);
    return;
    a(paramLong, paramArrayOfLong, false);
    return;
    c(paramLong, paramArrayOfLong, true);
    return;
    c(paramLong, paramArrayOfLong, false);
    return;
    b(paramLong, paramArrayOfLong[0], true);
    return;
    b(paramLong, paramArrayOfLong[0], false);
  }
  
  void a(long paramLong, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->setSpeakingUin,uin=" + paramArrayOfLong[0] + "isSpeaking" + paramBoolean);
    }
    if ((!this.jdField_f_of_type_Boolean) && (QLog.isColorLevel())) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->setSpeakingUin-->Is not In Room.uin=" + paramArrayOfLong[0] + "isSpeaking" + paramBoolean);
    }
    d(paramArrayOfLong[0], paramBoolean);
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(63), paramArrayOfLong, Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void a(Bundle paramBundle)
  {
    g(4);
    boolean bool1 = paramBundle.getBoolean("m2m", false);
    String str = paramBundle.getString("fromUin");
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    boolean bool2 = paramBundle.getBoolean("isFriend");
    if (bool1) {}
    for (int n = b(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), arrayOfByte, null);; n = a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), arrayOfByte, null))
    {
      a(0, 0, 5000);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvVideoCallData m2m = " + bool1 + ", selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", fromUin = " + str + ", buffer[2] = " + arrayOfByte[2] + ", result = " + n + ", isFriend = " + bool2);
      }
      return;
    }
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramVideoAppInterface.a().getApplicationContext();
    bgl localbgl = new bgl(this);
    paramVideoAppInterface.a().post(localbgl);
    c();
  }
  
  public void a(GaInviteActivity paramGaInviteActivity)
  {
    this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity = paramGaInviteActivity;
  }
  
  public void a(QQGlRender paramQQGlRender)
  {
    int i1 = 0;
    int n = 0;
    if (this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr == null) {
      this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr = new GraphicRenderMgr();
    }
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int == 4))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setLocalGlRender MultiVideo");
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        if (paramQQGlRender != null) {
          break label88;
        }
        this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr.setProcessEncodeFrameFunctionPtr(n);
      }
    }
    label88:
    while (this.jdField_a_of_type_ComTencentAvCoreIVcController == null) {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr.setLocalGlRender(paramQQGlRender);
        return;
        n = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getEncodeFrameFunctionPtrFunPtr();
      }
    }
    if (paramQQGlRender == null) {}
    for (n = i1;; n = this.jdField_a_of_type_ComTencentAvCoreIVcController.a())
    {
      this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr.setProcessEncodeFrameFunctionPtr(n);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setLocalGlRender 2Video");
      break;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_ComTencentAvThreadThreadPool.a(new bgb(this, paramRunnable));
  }
  
  public void a(Runnable paramRunnable, FutureListener paramFutureListener)
  {
    this.jdField_a_of_type_ComTencentAvThreadThreadPool.a(new bgi(this, paramRunnable), paramFutureListener);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController == null) {
      return;
    }
    int n = this.jdField_a_of_type_ComTencentAvCoreIVcController.a(paramString, e());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "rejectVideo: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", toUin = " + paramString + ", result = " + n);
    }
    y();
    l();
    p();
  }
  
  public void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.action.QQ_CALLING_CLOSE");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.a()) {}
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_Bgs != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Bgs);
          this.jdField_a_of_type_Bgs = null;
        }
      } while (this.jdField_a_of_type_ComTencentAvCoreIVcController == null);
      if ((1 != e()) && (!c()))
      {
        a(0, this.jdField_a_of_type_ComTencentAvCoreIVcController.a(paramString));
        this.jdField_d_of_type_Boolean = true;
      }
      int n = this.jdField_a_of_type_ComTencentAvCoreIVcController.c(paramString, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "closeVideo: isSharp = " + this.jdField_a_of_type_ComTencentAvCoreIVcController.b() + ", selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", toUin = " + paramString + ", result = " + n);
      }
    } while (paramInt != 1);
    j();
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    int n = 2;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCloseVideo fromUin = " + paramString + ", reason = " + paramInt + ", extraParam = " + paramLong);
    }
    g();
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 13: 
    case 16: 
    case 17: 
    default: 
      paramInt = 5;
    }
    for (;;)
    {
      c(paramString, paramInt);
      return;
      paramInt = 0;
      continue;
      paramInt = n;
      if (paramLong == 9L) {
        paramInt = 43;
      }
      b(paramString, paramInt);
      return;
      paramInt = 3;
      if (paramLong == 3L) {
        paramInt = 42;
      }
      b(paramString, paramInt);
      return;
      paramInt = 5;
      continue;
      b(paramString, 25);
      return;
      paramInt = 9;
      continue;
      paramInt = 1;
      continue;
      paramInt = 4;
      continue;
      paramInt = 10;
      continue;
      paramInt = 28;
      continue;
      paramInt = 29;
      continue;
      paramInt = 39;
      continue;
      paramInt = 35;
      continue;
      b(paramString, 12);
      return;
      paramInt = 21;
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMultiVideoMsg");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("cscmd", (short)(int)paramLong2);
    localNewIntent.putExtra("selfuin", Long.parseLong(paramString));
    localNewIntent.putExtra("toUin", paramLong1);
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    localNewIntent.putExtra("reqType", 8);
    a(localNewIntent);
  }
  
  void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendSharpMsg selfUin: " + paramString + ", toUin: " + paramLong);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 4);
    localNewIntent.putExtra("selfuin", Long.parseLong(paramString));
    localNewIntent.putExtra("toUin", paramLong);
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    a(localNewIntent);
  }
  
  public void a(String paramString, TraeAudioSession.ITraeAudioCallback paramITraeAudioCallback)
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession(this.jdField_a_of_type_AndroidContentContext, null);
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(paramString);
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(paramITraeAudioCallback);
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b();
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.d();
  }
  
  void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoMsg buf[2] = " + paramArrayOfByte[2]);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 0);
    localNewIntent.putExtra("selfuin", paramString1);
    localNewIntent.putExtra("toUin", a(paramString2));
    localNewIntent.putExtra("cVerifyType", Byte.valueOf((byte)0));
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    a(localNewIntent);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherIsRing isCalling = " + paramBoolean);
    }
    if (paramBoolean) {
      DataReport.u(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(23), Boolean.valueOf(paramBoolean) });
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvCoreIVcController.a(paramString, paramArrayOfByte);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (paramLong == 1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo_TRAE:network is bad");
      }
      if (!this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor.a()) {}
    }
    while (paramLong != 0L)
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            paramArrayOfByte = new String(paramArrayOfByte, "GBK");
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(26), paramArrayOfByte });
            return;
          }
          catch (NullPointerException paramArrayOfByte)
          {
            if (QLog.isColorLevel())
            {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo fromUin = " + paramString + ", info = " + paramLong, paramArrayOfByte);
              return;
            }
          }
          catch (UnsupportedEncodingException paramArrayOfByte) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo fromUin = " + paramString + ", info = " + paramLong, paramArrayOfByte);
      return;
    }
    paramString = new String(paramArrayOfByte);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(19), paramString });
  }
  
  void a(NewIntent paramNewIntent)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet(paramNewIntent);
      return;
    }
    catch (Exception paramNewIntent)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMsg", paramNewIntent);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (b()) {}
    while (a() == null) {
      return;
    }
    Intent localIntent = new Intent(a(), UtilsServiceForAV.class);
    if (paramBoolean)
    {
      a().startService(localIntent);
      return;
    }
    a().stopService(localIntent);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, paramArrayOfByte);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr == null) {
      this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr = new GraphicRenderMgr();
    }
    if (paramArrayOfByte == null) {
      return;
    }
    int n = paramArrayOfByte.length;
    if (n != VideoChatSettings.jdField_b_of_type_Int * VideoChatSettings.jdField_c_of_type_Int * 3 / 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnPreviewData", 2, "datalen != preview size");
      }
      if (n == 460800)
      {
        VideoChatSettings.jdField_b_of_type_Int = 640;
        VideoChatSettings.jdField_c_of_type_Int = 480;
      }
      if (n == 115200)
      {
        VideoChatSettings.jdField_b_of_type_Int = 320;
        VideoChatSettings.jdField_c_of_type_Int = 240;
      }
    }
    this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr.sendCameraFrame2Native(paramArrayOfByte, VideoChatSettings.jdField_a_of_type_Int, VideoChatSettings.jdField_b_of_type_Int, VideoChatSettings.jdField_c_of_type_Int, paramInt, System.currentTimeMillis(), paramBoolean);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoCall: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", toUin = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, paramArrayOfByte);
  }
  
  public void a(long[] paramArrayOfLong)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (str != null)
    {
      long l1 = Long.parseLong(str);
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setInviteUserList(l1, paramArrayOfLong);
      }
    }
  }
  
  public void a(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.invite(2, this.jdField_a_of_type_Long, paramArrayOfLong, false);
      }
    } while (!paramBoolean);
    int n = paramArrayOfLong.length;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(68), Long.valueOf(paramArrayOfLong[0]), Integer.valueOf(n) });
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAvCoreIVcController == null;
  }
  
  public boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startRemoteVideo(Long.valueOf(paramString).longValue(), paramInt) != 0)
      {
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startRemoteVideo(Long.valueOf(paramString).longValue(), paramInt);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "RequestGVideo-->Request GVideo Failed.The Cmd Did not Send Suc");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "RequestGVideo-->Request GVideo Failed.The mGAudioCtrl is null");
    }
    return false;
  }
  
  int b(int paramInt)
  {
    if (paramInt == bgr.jdField_c_of_type_Int)
    {
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if ((!localGAudioFriends.jdField_b_of_type_Boolean) && (!localGAudioFriends.jdField_c_of_type_Boolean)) {
          return paramInt;
        }
        paramInt += 1;
      }
      return -1;
    }
    return -2;
  }
  
  int b(long paramLong)
  {
    int n = 0;
    while (n < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_Long == paramLong) {
        return n;
      }
      n += 1;
    }
    return -1;
  }
  
  public int b(long paramLong, long[] paramArrayOfLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "acceptGAudioChat groupId: " + paramLong);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return -1;
    }
    this.l = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 8;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_j_of_type_JavaLangString = String.valueOf(paramLong);
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    if (a().jdField_e_of_type_Boolean) {}
    for (int n = 2;; n = 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getSessionInfo().localHasVideo = " + a().jdField_e_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.acceptGAudio(2, 1, n, paramLong, paramArrayOfLong, e(), l1);
      if (this.jdField_g_of_type_JavaLangRunnable == null) {
        this.jdField_g_of_type_JavaLangRunnable = new bgg(this, paramLong);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_g_of_type_JavaLangRunnable, 30000L);
      k();
      return 0;
    }
  }
  
  public int b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController != null) {
      return this.jdField_a_of_type_ComTencentAvCoreIVcController.h(paramString);
    }
    return -1;
  }
  
  int b(boolean paramBoolean)
  {
    boolean bool = true;
    int n = 0;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      n = -1;
    }
    while (!this.jdField_f_of_type_Boolean) {
      return n;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopOrStartTRAE(true, false);
      return 0;
    }
    if (!this.jdField_k_of_type_Boolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopOrStartTRAE(false, paramBoolean);
      return 0;
    }
  }
  
  public int b(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController == null) {}
    do
    {
      return -1;
      if (this.jdField_a_of_type_ComTencentAvCoreIVcController.b()) {
        return this.jdField_a_of_type_ComTencentAvCoreIVcController.b(paramString, paramBoolean);
      }
    } while (this.jdField_a_of_type_ComTencentAvAudioVcAudioManager == null);
    return this.jdField_a_of_type_ComTencentAvAudioVcAudioManager.b(paramBoolean);
  }
  
  public long b()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr == null) {
      this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr = new GraphicRenderMgr();
    }
    this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr.clearCache();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onApnChanged netType = " + paramInt);
    }
    if (this.D != paramInt)
    {
      this.D = paramInt;
      if (paramInt != 0) {
        break label121;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      if (!this.jdField_f_of_type_Boolean) {
        break label138;
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onApnChanged(e());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(21), Integer.valueOf(paramInt) });
      return;
      label121:
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      break;
      label138:
      if ((this.jdField_a_of_type_ComTencentAvCoreIVcController != null) && ((paramInt == 1) || (paramInt == 2))) {
        this.jdField_a_of_type_ComTencentAvCoreIVcController.b(e());
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Boolean) && ((VideoChatSettings.jdField_b_of_type_Int != paramInt1) || (VideoChatSettings.jdField_c_of_type_Int != paramInt2)))
    {
      VideoChatSettings.jdField_b_of_type_Int = paramInt1;
      VideoChatSettings.jdField_c_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(32) });
    }
  }
  
  public void b(int paramInt, long paramLong)
  {
    if ((paramLong > 0L) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null))
    {
      this.l = true;
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomInfo(paramInt, paramLong, true, true, true);
    }
  }
  
  public void b(long paramLong)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "quitGAudioChat groupId: " + paramLong);
    }
    this.jdField_g_of_type_JavaLangRunnable = null;
    if (this.jdField_d_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      this.jdField_d_of_type_JavaLangRunnable = null;
    }
    long l3 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getNetTrafficSize(paramLong);
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.quit(2, paramLong);
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int == 9) && (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.w)) {}
    for (long l1 = 0L;; l1 = a())
    {
      this.jdField_k_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_Long = 0L;
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int >= 8) {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 0;
      }
      Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        l2 = Long.parseLong((String)localObject);
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        Intent localIntent = new Intent();
        localIntent.setAction("tencent.av.v2q.MultiVideo");
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
        localIntent.putExtra("type", 23);
        localIntent.putExtra("friendUin", l2);
        localIntent.putExtra("discussId", paramLong);
        localIntent.putExtra("time", l1);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
      }
      y();
      l();
      a(3000, (String)localObject, String.valueOf(paramLong), 6);
      this.jdField_b_of_type_Long = l3;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "netTrafficSize size = " + l3);
      }
      localObject = new Intent("tencent.video.v2q.VideoFlowSize");
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      ((Intent)localObject).putExtra("size", l3);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject);
      return;
    }
  }
  
  void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
    }
  }
  
  public void b(long paramLong, long[] paramArrayOfLong)
  {
    int n;
    if (paramArrayOfLong != null)
    {
      a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, 1);
      n = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int;
      c(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, 21);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.l = -1;
      if (n != 1) {
        break label154;
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int = 3;
    }
    for (;;)
    {
      if (this.jdField_c_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.g = 3000;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_j_of_type_JavaLangString = Long.toString(paramLong);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.o = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_n_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101) });
      return;
      label154:
      if (n == 2) {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int = 4;
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    boolean bool = paramBundle.getBoolean("isRequest");
    g(4);
    int n = d(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), arrayOfByte, null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "receiveSharpVideoCall result: " + n + ", buf.length: " + arrayOfByte.length);
    }
    if ((bool) && (this.C == -1)) {
      this.C = 1;
    }
    a(0, 0, 5000);
  }
  
  public void b(QQGlRender paramQQGlRender)
  {
    int i1 = 0;
    int n = 0;
    if (this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr == null) {
      this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr = new GraphicRenderMgr();
    }
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int == 4)) {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        if (paramQQGlRender != null) {
          break label72;
        }
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(n);
      }
    }
    label72:
    while (this.jdField_a_of_type_ComTencentAvCoreIVcController == null) {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr.setPeerGlRender(paramQQGlRender);
        return;
        n = this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr.getRecvDecoderFrameFunctionptr();
      }
    }
    if (paramQQGlRender == null) {}
    for (n = i1;; n = this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr.getRecvDecoderFrameFunctionptr())
    {
      this.jdField_a_of_type_ComTencentAvCoreIVcController.a(n);
      break;
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController == null) {
      return;
    }
    int n = this.jdField_a_of_type_ComTencentAvCoreIVcController.b(paramString, e());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ignoreVideo: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", toUin = " + paramString + ", result = " + n);
    }
    y();
    l();
    p();
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCloseVideo fromUin = " + paramString + ", type = " + paramInt);
    }
    p();
    e();
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.c())
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.l = paramInt;
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.c()) && (paramInt == this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int)) {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Long = 0L;
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 6;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt) });
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.b())
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.l = paramInt;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Long = 0L;
        int n = 2131165204;
        switch (paramInt)
        {
        }
        for (;;)
        {
          a(n, 2, this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 5;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt) });
          return;
          ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "2", "", "", "");
          n = 2131165203;
          continue;
          ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "1", "", "", "");
          n = 2131165203;
          continue;
          a(2131165204, 1, this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 6;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt) });
          return;
          ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "3", "", "", "");
          n = 2131165203;
          continue;
          n = 2131165203;
        }
      }
    } while (this.jdField_a_of_type_ComTencentAvAppSessionInfo.f());
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.l = paramInt;
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.c()) {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Long = 0L;
    }
    a(2131165204, 1, this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 6;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt) });
  }
  
  void b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoMsg buf[2] = " + paramArrayOfByte[2]);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 1);
    localNewIntent.putExtra("selfuin", paramString1);
    localNewIntent.putExtra("toUin", a(paramString2));
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    a(localNewIntent);
  }
  
  public void b(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkInfo_S2C:flag is:" + paramLong);
    }
    if (paramLong != 0L) {
      try
      {
        String str = new String(paramArrayOfByte, "UTF-8");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(31), Integer.valueOf((int)paramLong), str });
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkInfo_S2C fromUin = " + paramString + ", info = " + paramArrayOfByte, localNullPointerException);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkInfo_S2C fromUin = " + paramString + ", info = " + paramArrayOfByte, localUnsupportedEncodingException);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(31), Integer.valueOf(0), null });
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int <= 4))
      {
        if ((!this.jdField_a_of_type_ComTencentAvAppSessionInfo.v) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Boolean)) {
          c(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString);
        }
        if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Boolean) {
          a(true, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString);
        }
        b(false, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvCoreIVcController != null) {
        this.jdField_a_of_type_ComTencentAvCoreIVcController.c(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, paramBoolean);
      }
      return;
      b(true);
      continue;
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int <= 4))
      {
        if ((!this.jdField_a_of_type_ComTencentAvAppSessionInfo.v) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Boolean)) {
          d(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString);
        }
        if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Boolean) {
          a(false, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString);
        }
        b(true, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString);
      }
      else
      {
        b(false);
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_n_of_type_Boolean)
        {
          if (this.jdField_d_of_type_JavaLangRunnable == null) {
            this.jdField_d_of_type_JavaLangRunnable = new bgd(this);
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 2000L);
        }
      }
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvMultiVideoCallData buf: " + paramArrayOfByte);
    }
    g();
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      q();
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onRecvGAudioCMD(this.W, paramArrayOfByte);
    }
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, paramArrayOfByte);
  }
  
  public void b(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      for (;;)
      {
        int n;
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          int i1 = paramArrayOfLong.length;
          n = 0;
          if (n >= i1) {
            break;
          }
          long l1 = paramArrayOfLong[n];
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)localIterator.next();
            if (localGAudioFriends.jdField_a_of_type_Long != l1) {
              continue;
            }
            localGAudioFriends.jdField_a_of_type_Boolean = paramBoolean;
          }
        }
        n += 1;
      }
    }
  }
  
  public boolean b()
  {
    String str1 = Build.MODEL;
    String str2 = Build.MANUFACTURER;
    return ((str2.equalsIgnoreCase("samsung")) && (str1.equalsIgnoreCase("GT-I9200"))) || ((str2.equalsIgnoreCase("samsung")) && (str1.equalsIgnoreCase("GT-I8262D"))) || ((str2.equalsIgnoreCase("samsung")) && (str1.equalsIgnoreCase("SM-N9008")));
  }
  
  public int c()
  {
    return this.P;
  }
  
  public int c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController != null) {
      return this.jdField_a_of_type_ComTencentAvCoreIVcController.i(paramString);
    }
    return -1;
  }
  
  void c()
  {
    if (!NetworkUtil.e(a())) {
      this.D = 0;
    }
    for (;;)
    {
      Object localObject = (WindowManager)a().getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
      int n = localDisplayMetrics.widthPixels;
      int i1 = localDisplayMetrics.heightPixels;
      TraeAudioManager.a(a());
      UITools.a(a());
      if (this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr == null) {
        this.jdField_a_of_type_ComTencentAvOpenglGraphicRenderMgr = new GraphicRenderMgr();
      }
      try
      {
        int i2 = e();
        localObject = new VcController(a(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), String.valueOf(AppSetting.jdField_a_of_type_Int), "130", AppSetting.a(), a(), this, this, n, i1, i2);
        this.jdField_a_of_type_ComTencentAvAudioVcAudioManager = new VcAudioManager((IVcAudioData)localObject);
        this.jdField_a_of_type_ComTencentAvCoreIVcController = ((IVcController)localObject);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        this.jdField_a_of_type_ComTencentAvCoreIVcController = null;
      }
      if (NetworkUtil.b(a())) {
        this.D = 1;
      } else {
        this.D = 2;
      }
    }
  }
  
  public void c(int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 10);
    localNewIntent.putExtra("status", paramInt);
    a(localNewIntent);
  }
  
  public void c(int paramInt, long paramLong)
  {
    if (this.jdField_e_of_type_Boolean == true)
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(true, true, String.valueOf(paramLong));
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(81), Long.valueOf(paramLong) });
      this.jdField_e_of_type_Boolean = false;
    }
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendGAudioTrafficBroadCast" + paramLong);
    }
    Intent localIntent;
    float f1;
    if (this.jdField_b_of_type_Long > 0L)
    {
      localIntent = new Intent();
      str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      localIntent.setAction("tencent.video.v2q.AddVideoMsg");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      localIntent.putExtra("uinType", 3000);
      localIntent.putExtra("msgType", 44);
      localIntent.putExtra("isVideoMsg", true);
      localIntent.putExtra("friendUin", Long.toString(paramLong));
      localIntent.putExtra("senderUin", str);
      f1 = (float)this.jdField_b_of_type_Long / 1024.0F;
      if (f1 >= 1024.0F) {
        break label227;
      }
    }
    label227:
    for (String str = String.format("%.01f", new Object[] { Float.valueOf(f1) }) + "KB";; str = String.format("%.01f", new Object[] { Float.valueOf(f1 / 1024.0F) }) + "MB")
    {
      localIntent.putExtra("extra", str);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
      this.jdField_b_of_type_Long = 0L;
      return;
    }
  }
  
  void c(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          if (b(paramLong) == -1)
          {
            VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends(this);
            localGAudioFriends.jdField_a_of_type_Long = paramLong;
            this.jdField_a_of_type_JavaUtilArrayList.add(localGAudioFriends);
          }
          return;
        }
        finally {}
        int n = b(paramLong);
        if (n != -1) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(n);
        } else if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberInOrOut-->Can not find the.Uin=" + paramLong);
        }
      }
    }
  }
  
  public void c(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvMultiVideoOfflineMsg");
    }
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    g(4);
    paramBundle = paramBundle.getByteArray("buffer");
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      q();
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onRecvGAudioCMD(this.Y, paramBundle);
    }
    a(0, 0, 5000);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "pauseVideo");
    }
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int <= 2) && (this.jdField_a_of_type_ComTencentAvCoreIVcController != null)) {
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.e()) {}
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.jdField_a_of_type_ComTencentAvCoreIVcController.a(paramString);
    }
    QLog.d("VideoController", 2, "pauseVideo end");
  }
  
  public void c(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "closeSession type = " + paramInt + ", peerUin = " + paramString + ", mPeerUin = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString + ", mIsAudioMode = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.v + ", mNetTrafficAllSize = " + this.jdField_b_of_type_Long);
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.a())
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "closeSession state error!!!");
      }
      return;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString.contains(paramString))) {
      paramString = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.f()) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.g())) {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.l = paramInt;
      }
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.b()) || ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.c()) && (paramInt == this.jdField_a_of_type_ComTencentAvAppSessionInfo.l))) {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Long = 0L;
      }
      int n;
      String str;
      if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.x)
      {
        n = this.jdField_a_of_type_ComTencentAvAppSessionInfo.g;
        str = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Int != 2) {
          break label462;
        }
      }
      label450:
      label462:
      for (boolean bool = true;; bool = false)
      {
        a(n, paramInt, bool, paramString, str);
        if (this.jdField_f_of_type_Boolean) {
          a(n, paramString, str, 1);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.x = true;
          this.jdField_b_of_type_Long = 0L;
          y();
          l();
          p();
          v();
          e();
          if (this.jdField_a_of_type_Boolean)
          {
            DataReport.c(this, false);
            DataReport.e(this, false);
            if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b() > 0) {
              DataReport.r(this);
            }
          }
          this.i = false;
          this.jdField_b_of_type_JavaLangString = null;
          this.jdField_c_of_type_JavaLangString = null;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 0;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Int = 0;
          if (paramInt == 21) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b() <= 0) {
            break label450;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), paramString, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
          return;
          a(n, paramString, str, 0);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        a();
        return;
      }
    }
  }
  
  void c(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoConfigReqMsg: buf[2] = " + paramArrayOfByte[2]);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 3);
    localNewIntent.putExtra("selfuin", paramString1);
    localNewIntent.putExtra("toUin", a(paramString2));
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    a(localNewIntent);
  }
  
  public void c(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onSwitchGroup is:" + paramLong);
    }
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int == 4)) {}
    while (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString.compareToIgnoreCase(paramString) != 0) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.o) {
      a(2131165201, 1, null);
    }
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.o = true;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Int = 11;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101) });
    j();
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNotRecvAudioData bNotRecv = " + paramBoolean);
    }
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(24), Boolean.valueOf(true) });
      }
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(24), Boolean.valueOf(false) });
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvMultiVideoAck");
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      q();
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onRecvGAudioCMD(this.X, paramArrayOfByte);
  }
  
  public void c(byte[] paramArrayOfByte, long paramLong)
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), paramLong, paramArrayOfByte);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvCoreIVcController.b();
  }
  
  public int d()
  {
    int n = 0;
    int i2;
    for (int i1 = 0; n < this.jdField_a_of_type_JavaUtilArrayList.size(); i1 = i2)
    {
      i2 = i1;
      if (((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(n)).jdField_b_of_type_Boolean) {
        i2 = i1 + 1;
      }
      n += 1;
    }
    return i1;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendGetGatewayIpReq");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 7);
    a(localNewIntent);
  }
  
  public void d(int paramInt)
  {
    g();
    this.P = paramInt;
  }
  
  public void d(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaSwitchVideoResult-->result=" + paramInt + "uin=" + paramLong);
    }
    if (paramInt == 96)
    {
      if (0L != paramLong) {
        break label71;
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(false, true, null);
    }
    label71:
    while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      return;
      this.jdField_e_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
  }
  
  public void d(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioQuitCallBack groupId " + paramLong);
    }
    a();
  }
  
  public void d(Bundle paramBundle)
  {
    g(4);
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    String str = paramBundle.getString("fromUin");
    boolean bool = paramBundle.getBoolean("isFriend");
    int n = d(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), arrayOfByte, null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvSharpVideoCallData: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", fromUin = " + str + ", result = " + n + ",isFriend:" + bool);
    }
    this.C = 0;
    if (a()) {
      b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    a(0, 0, 5000);
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "resumeVideo");
    }
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int <= 2)) {
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.e()) {}
    }
    while ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int != 3) || (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString == null))
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentAvCoreIVcController == null);
      this.jdField_a_of_type_ComTencentAvCoreIVcController.b(paramString);
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startRemoteVideo(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_Int);
  }
  
  public void d(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController != null) {
      this.jdField_a_of_type_ComTencentAvCoreIVcController.a(paramString, paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetIPAndPort(paramString, paramInt);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvFirstAudioData recvFirstAudio = " + paramBoolean);
    }
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.v) {
        break label119;
      }
      if (this.jdField_a_of_type_ComTencentAvCoreIVcController != null)
      {
        if (-1 != this.jdField_a_of_type_ComTencentAvCoreIVcController.d(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label111;
        }
        this.jdField_g_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(25), Boolean.valueOf(paramBoolean) });
      return;
      label111:
      this.jdField_g_of_type_Boolean = true;
      continue;
      label119:
      this.jdField_g_of_type_Boolean = true;
    }
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    c(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), paramArrayOfByte, null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvVideoCloudConfig cloud-config msg.");
    }
  }
  
  public void d(byte[] paramArrayOfByte, long paramLong)
  {
    String str = null;
    if (paramLong == 0L) {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.t = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(27), str });
      return;
      if (paramLong == 1L)
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.t = true;
      }
      else if (paramLong == 100L)
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.u = false;
      }
      else if (paramLong == 101L)
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.u = true;
        if (paramArrayOfByte != null) {
          str = new String(paramArrayOfByte);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.t = false;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.u = false;
      }
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Int != 1) {
      return true;
    }
    if (!this.jdField_a_of_type_ComTencentAvCoreIVcController.b()) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvCoreIVcController.a(0L);
  }
  
  public int e()
  {
    Object localObject = (ConnectivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("connectivity");
    if (localObject == null) {
      return 0;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null) {
      return 0;
    }
    if (((NetworkInfo)localObject).getType() == 1) {
      return 1;
    }
    localObject = ((NetworkInfo)localObject).getExtraInfo();
    if (localObject == null) {
      return 0;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_c_of_type_JavaLangString)) {
      return 3;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_d_of_type_JavaLangString)) {
      return 2;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_a_of_type_JavaLangString)) {
      return 7;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_b_of_type_JavaLangString)) {
      return 6;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_e_of_type_JavaLangString)) {
      return 5;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_f_of_type_JavaLangString)) {
      return 4;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_g_of_type_JavaLangString)) {
      return 9;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.h)) {
      return 8;
    }
    if (NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext) == 4)
    {
      localObject = (TelephonyManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("phone");
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getSimOperator();
        if (localObject != null)
        {
          if ((((String)localObject).equals("46000")) || (((String)localObject).equals("46002")) || (((String)localObject).equals("46007"))) {
            return 11;
          }
          if (((String)localObject).equals("46001")) {
            return 12;
          }
          if (((String)localObject).equals("46003")) {
            return 13;
          }
        }
      }
      return 11;
    }
    return 0;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentAvAudioVcAudioManager != null) && (!this.jdField_a_of_type_ComTencentAvCoreIVcController.b()) && (this.jdField_h_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvAudioVcAudioManager.b();
      this.jdField_a_of_type_ComTencentAvAudioVcAudioManager = null;
      this.jdField_h_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidContentContext != null) {
        new TraeAudioSession(this.jdField_a_of_type_AndroidContentContext, null).a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
    }
  }
  
  public void e(int paramInt)
  {
    h(paramInt);
  }
  
  public void e(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioRoomDestroy groupId " + paramLong);
    }
    if (this.jdField_c_of_type_Long == paramLong) {
      this.jdField_c_of_type_Long = 0L;
    }
    if ((this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity != null) && (!this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.isFinishing()))
    {
      int n = 5;
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int == 7) {
        n = 4;
      }
      a(3000, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), String.valueOf(paramLong), n);
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int == 7) {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 0;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong) });
  }
  
  public void e(Bundle paramBundle)
  {
    g(4);
    paramBundle = paramBundle.getByteArray("buffer");
    int n = e(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), paramBundle, null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvSharpVideoAck: result = " + n);
    }
    a(0, 0, 3000);
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRejectVideo fromUin = " + paramString);
    }
    c(paramString, 3);
  }
  
  public void e(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached state:" + paramInt);
    }
    int n = 0x80000 & paramInt;
    if ((n > 0) && (this.j)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached :has get phone state");
      }
    }
    label302:
    do
    {
      return;
      if (n == 0) {
        this.j = true;
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_h_of_type_Int = 0;
      if ((0x10000 & paramInt) > 0)
      {
        n = 0x40000 & paramInt;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_j_of_type_Int = (0x20000 & paramInt);
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_k_of_type_Int = n;
        if (((0x100000 & paramInt) > 0) && (n > 0))
        {
          if ((paramInt & 0xFFFF & 0x1) > 0) {
            this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_h_of_type_Int = 1;
          }
          if ((this.jdField_a_of_type_Bgs != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
          {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Bgs);
            this.jdField_a_of_type_Bgs = null;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), paramString });
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_k_of_type_Boolean = true;
          return;
          paramInt &= 0xFFFF;
          if ((paramInt & 0x2) > 0) {
            this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_h_of_type_Int = 2;
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label302;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached low 16bit value is" + paramInt);
            break;
            if ((paramInt & 0x4) > 0) {
              this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_h_of_type_Int = 3;
            } else if ((paramInt & 0x8) > 0) {
              this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_h_of_type_Int = 4;
            }
          }
        }
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_j_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_k_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pc and phone both not online");
      }
      if ((this.jdField_a_of_type_Bgs != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Bgs);
        this.jdField_a_of_type_Bgs = null;
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_k_of_type_Boolean = false;
      a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, 0);
      this.jdField_e_of_type_JavaLangRunnable = new bge(this);
    } while (this.jdField_e_of_type_JavaLangRunnable == null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 2000L);
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopRemoteVideo() != 0)
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(false, true, null);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "StopGVideo-->Stop GVideo Failed.The Cmd Did Not Send Suc");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "StopGVideo-->Stop GVideo Failed.The mGAudioCtrl is null");
    }
    return false;
  }
  
  public int f()
  {
    return e();
  }
  
  public void f()
  {
    int n = 47;
    label303:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.v)
          {
            break label303;
            QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_AndroidContentContext);
            if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int != 4)) {
              break label210;
            }
            localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.g, a().jdField_j_of_type_JavaLangString, null);
            Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.g, a().jdField_j_of_type_JavaLangString, null, true, true);
            if (localBitmap != null)
            {
              localQAVNotification.a((String)localObject2, localBitmap, a().jdField_j_of_type_JavaLangString, 44);
              u();
            }
          }
          else
          {
            n = 42;
            break label303;
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.e())
          {
            if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.v) {
              break label309;
            }
            break;
          }
          if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.v) {
            break label318;
          }
          n = 46;
          break label315;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new bgo(this), 1000L);
        continue;
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString != null) {
          break label255;
        }
      }
      finally {}
      label210:
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.g, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString);
      label255:
      Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.g, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, true, true);
      localObject1.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, (Bitmap)localObject2, null, n);
    }
    for (;;)
    {
      break;
      label309:
      n = 42;
    }
    for (;;)
    {
      label315:
      break;
      label318:
      n = 41;
    }
  }
  
  public void f(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.AvSwitch");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("uinType", this.jdField_a_of_type_ComTencentAvAppSessionInfo.g);
      localIntent.putExtra("peerUin", this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("extraUin", this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void f(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioTerminalEnterRoom,GroupId=" + paramLong);
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int == 7) {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 0;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong) });
  }
  
  public void f(String paramString)
  {
    p();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCancelRequest: fromUin = " + paramString);
    }
    c(paramString, 10);
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int g()
  {
    return this.C;
  }
  
  public void g()
  {
    a(1);
    a(0);
  }
  
  public void g(int paramInt)
  {
    int n = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d;
    switch (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d)
    {
    default: 
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkProcessStatus: " + n + " -> " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d + " act: " + paramInt);
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d == 0) {
        h();
      }
      return;
      if (paramInt == 0)
      {
        c(1);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d = 1;
        a(1, 3, 1600);
      }
      else if (paramInt == 4)
      {
        a(1);
        a(0);
        continue;
        if (paramInt == 4)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d = 2;
          c(2);
          a(1);
        }
        else if (paramInt == 3)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d = 0;
          c(0);
        }
        else if (paramInt == 1)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d = 0;
        }
      }
    }
  }
  
  public void g(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioKickOut-->Groupid=" + paramLong);
    }
    if ((this.jdField_f_of_type_Boolean) && (paramLong == this.jdField_a_of_type_Long))
    {
      a(3000, 20, false, String.valueOf(paramLong), null);
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Calling_kick_off", 0, 0, "", "", "", "");
      b(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong) });
      a();
    }
  }
  
  public void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAcceptedVideo: fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 3;
  }
  
  public boolean g()
  {
    return this.jdField_k_of_type_Boolean;
  }
  
  public int h()
  {
    if ((!this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getNetState();
  }
  
  void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "exitProcess");
    }
    g();
    UITools.a();
    TraeAudioManager.e();
    QAVNotification.a(this.jdField_a_of_type_AndroidContentContext).d();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e();
  }
  
  public void h(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkProcessExitStatus act:" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController == null) {
      h();
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.a());
        if ((!this.jdField_f_of_type_Boolean) && (!this.l)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "is in room or is query member");
      return;
    } while (this.jdField_a_of_type_ComTencentAvCoreIVcController.a());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "CheckEngineActive: engine is not Active");
    }
    g(paramInt);
  }
  
  public void h(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      int n = 0;
      for (;;)
      {
        try
        {
          if (n < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_Long == paramLong) {
              this.jdField_a_of_type_JavaUtilArrayList.remove(n);
            }
          }
          else
          {
            VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends(this);
            if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))))
            {
              localGAudioFriends.jdField_a_of_type_Boolean = ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).booleanValue();
              localGAudioFriends.jdField_a_of_type_Long = paramLong;
              this.jdField_a_of_type_JavaUtilArrayList.add(localGAudioFriends);
              return;
            }
            localGAudioFriends.jdField_a_of_type_Boolean = false;
            continue;
          }
          n += 1;
        }
        finally {}
      }
    }
  }
  
  public void h(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onChannelReady: fromUin = " + paramString);
    }
    if ((this.jdField_a_of_type_Bgs != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Bgs);
      this.jdField_a_of_type_Bgs = null;
    }
    UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
    p();
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    paramString = new TraeAudioSession(this.jdField_a_of_type_AndroidContentContext, null);
    if ((this.jdField_a_of_type_ComTencentAvAudioVcAudioManager != null) && (!this.jdField_a_of_type_ComTencentAvCoreIVcController.b()))
    {
      if (paramString != null) {
        paramString.a();
      }
      k();
      this.jdField_a_of_type_ComTencentAvAudioVcAudioManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Boolean, 0);
      this.jdField_a_of_type_ComTencentAvAudioVcAudioManager.a();
      this.jdField_h_of_type_Boolean = true;
    }
    if (paramString != null) {
      paramString.a();
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b() > 0)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13) });
      if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Boolean) {
        break label336;
      }
      a(true, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = false;
      if ((!this.jdField_a_of_type_ComTencentAvCoreIVcController.b()) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_h_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.v = true;
      }
      a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int, true, true);
      DataReport.o(this);
      DataReport.e(this, true);
      DataReport.c(this, true);
      return;
      f();
      break;
      label336:
      a(false, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.goOnStage() != 0) {}
    }
    while (!QLog.isColorLevel())
    {
      return false;
      return true;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOnstage-->mGAudioCtrl is null");
    return false;
  }
  
  public int i()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getVideoAbilityLevel();
    }
    return -1;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcController != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateConfigInfo");
      }
      this.jdField_a_of_type_ComTencentAvCoreIVcController.b();
    }
  }
  
  public void i(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.changeSpeakerMode(paramInt);
    }
  }
  
  public void i(long paramLong)
  {
    ArrayList localArrayList;
    int n;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "friend " + paramLong + " GetOut");
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      n = 0;
    }
    for (;;)
    {
      try
      {
        if (n < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (paramLong != ((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_Long) {
            break label109;
          }
          this.jdField_a_of_type_JavaUtilArrayList.remove(n);
        }
        return;
      }
      finally {}
      return;
      label109:
      n += 1;
    }
  }
  
  public void i(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPauseVideo fromUin = " + paramString + ", remoteHasVideo = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Boolean);
    }
    if ((!this.jdField_a_of_type_ComTencentAvAppSessionInfo.v) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Boolean = false;
      if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int = 1;
        f(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(15) });
      DataReport.t(this);
    }
  }
  
  void j()
  {
    if (this.jdField_c_of_type_JavaLangRunnable == null)
    {
      this.jdField_c_of_type_JavaLangRunnable = new bgp(this);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_c_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 5000L);
      }
    }
  }
  
  public void j(int paramInt)
  {
    if (paramInt == 90)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(true, false, null);
    }
    long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt), Long.valueOf(l1) });
    }
  }
  
  public void j(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(83), Long.valueOf(paramLong) });
  }
  
  public void j(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeVideo fromUin = " + paramString + ", remoteHasVideo = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Int == 1) && (!d())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Int == 1) {
      f(2);
    }
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16) });
  }
  
  @SuppressLint({"NewApi"})
  void k()
  {
    if (Build.VERSION.SDK_INT <= 7) {}
    int n;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener == null) {
          this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new bgc(this);
        }
        if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
          this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
        }
      } while (this.jdField_a_of_type_AndroidMediaAudioManager == null);
      n = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
    } while ((n == 1) || (!QLog.isColorLevel()));
    QLog.d("AudioManager", 2, "request audio focus fail. " + n);
  }
  
  public void k(int paramInt)
  {
    if (paramInt == 93)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(false, false, null);
    }
    long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt), Long.valueOf(l1) });
    }
  }
  
  public void k(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onEnterSuc-->GroupId=" + paramLong);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(80), Long.valueOf(paramLong) });
  }
  
  public void k(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPauseAudio fromUin = " + paramString + ", remoteMute = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_Boolean);
    }
    if ((!this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(17) });
    }
  }
  
  @SuppressLint({"NewApi"})
  void l()
  {
    if (Build.VERSION.SDK_INT <= 7) {}
    while (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      return;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    this.jdField_a_of_type_AndroidMediaAudioManager = null;
  }
  
  public void l(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeAudio fromUin = " + paramString + ", remoteMute = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_Boolean);
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(18) });
    }
  }
  
  void m()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      if (localIntent != null)
      {
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
        localIntent.setAction("tencent.video.v2q.ReceiveRequest");
        localIntent.putExtra("revVideoRequest", true);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
      }
    }
  }
  
  public void m(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onApptypeNotSuit(): fromUin = " + paramString);
    }
    a(paramString, 0);
    c(paramString, 5);
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNeedShowPeerVideo");
    }
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_Int == 1) && (!d()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "!canAVShift()");
      }
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
    DataReport.s(this);
  }
  
  public void n(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkDisconnect fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(20) });
  }
  
  void o()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 15000L);
  }
  
  public void o(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherHaveAccept fromUin = " + paramString);
    }
    a(paramString, 0);
    c(paramString, 7);
  }
  
  void p()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public void p(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherHaveReject fromUin = " + paramString);
    }
    a(paramString, 0);
    c(paramString, 7);
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = QQGAudioCtrl.getGAudioCtrlInstance();
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.SetVideoController(this);
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
      this.jdField_a_of_type_ComTencentAvVideoCallGAClientLogReport = new GAClientLogReport();
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAppid(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.Init(this.jdField_a_of_type_AndroidContentContext, l1, 1);
    }
  }
  
  public void q(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onConfigSysDealDone fromUin = " + paramString);
    }
  }
  
  public void r()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      long l1 = this.jdField_a_of_type_Long;
      b(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(l1) });
    }
  }
  
  void r(String paramString)
  {
    if ((this.jdField_a_of_type_Bgs != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Bgs);
    }
    this.jdField_a_of_type_Bgs = new bgs(this, paramString);
    if (this.jdField_a_of_type_Bgs != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Bgs, 6000L);
    }
  }
  
  public void s()
  {
    if (!this.jdField_f_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 0;
    }
  }
  
  public void t()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (l1 == ((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long)) {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 9;
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int = 10;
  }
  
  public void u()
  {
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int == 4) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Int == 10)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_h_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void v()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.goOffStage();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOffStage-->mGAudioCtrl is null");
  }
  
  public void x()
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(null);
    }
  }
  
  /* Error */
  void y()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 148	com/tencent/av/VideoController:jdField_a_of_type_ComTencentSharpJniTraeAudioSession	Lcom/tencent/sharp/jni/TraeAudioSession;
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 148	com/tencent/av/VideoController:jdField_a_of_type_ComTencentSharpJniTraeAudioSession	Lcom/tencent/sharp/jni/TraeAudioSession;
    //   11: invokevirtual 1893	com/tencent/sharp/jni/TraeAudioSession:a	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 148	com/tencent/av/VideoController:jdField_a_of_type_ComTencentSharpJniTraeAudioSession	Lcom/tencent/sharp/jni/TraeAudioSession;
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 148	com/tencent/av/VideoController:jdField_a_of_type_ComTencentSharpJniTraeAudioSession	Lcom/tencent/sharp/jni/TraeAudioSession;
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 148	com/tencent/av/VideoController:jdField_a_of_type_ComTencentSharpJniTraeAudioSession	Lcom/tencent/sharp/jni/TraeAudioSession;
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	VideoController
    //   20	1	1	localException	Exception
    //   27	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	14	20	java/lang/Exception
    //   7	14	27	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController
 * JD-Core Version:    0.7.0.1
 */