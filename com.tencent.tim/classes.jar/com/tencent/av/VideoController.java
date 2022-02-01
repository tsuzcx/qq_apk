package com.tencent.av;

import acfp;
import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import anot;
import anpc;
import aqel;
import aqgz;
import aqhu;
import aqiw;
import aqji;
import aqji.c;
import aqmj;
import aqpr;
import aqux;
import atan;
import auri;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.NetAddr;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.compat.InviteUIChecker;
import com.tencent.av.core.SDKConfigInfo.a;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.core.VcControllerImpl.a;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.random.RandomController;
import com.tencent.av.report.AVReport;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import igd;
import igh;
import ign;
import igs;
import igv;
import igx;
import igz;
import iha;
import ihb;
import ihc;
import ihd;
import ihe;
import ihf;
import ihg;
import ihh;
import ihi;
import ihj;
import ihk;
import ihl;
import ihm;
import iho;
import ihp;
import ihq;
import iiv;
import iiv.a;
import iiv.b;
import ije;
import ikp;
import ikr;
import ilj;
import ilo;
import ilu;
import imb;
import imh;
import imi;
import imj;
import imk;
import imm;
import imp;
import imq;
import imr;
import ing;
import ini;
import inw;
import inx;
import iny;
import ioa;
import ios;
import iov;
import iow;
import ipd;
import irc;
import ird;
import itn;
import itq;
import ivv;
import iwu;
import izr;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import jds;
import jeu;
import jhb;
import jht.b;
import jjc;
import jji;
import jjk;
import jjo;
import jkf;
import jkf.a;
import jkg;
import jkn;
import jko;
import jkq;
import jlc;
import jle;
import jll;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tar;
import tencent.im.cs.net.echo.ReqEcho;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MemberInfo;

public class VideoController
  extends imi
  implements VcControllerImpl.a, imk, iny
{
  private static String Mo = "com.tencent.av.count";
  public static String Mp = "WifiQQCall";
  public static String Mq = "WifiRandom";
  public static String Mr = "WifiGuild";
  public static String TAG = "VideoController";
  public static int alI = -1;
  public static int alJ = 1;
  public static int alK;
  static volatile VideoController jdField_b_of_type_ComTencentAvVideoController;
  public float[] K;
  private String Mn = "";
  private String Ms;
  boolean OA = false;
  public boolean OB;
  private boolean OC;
  public boolean OD;
  public boolean OE;
  boolean OF = true;
  public volatile boolean OG = true;
  private boolean OH;
  private boolean OI;
  private boolean OJ;
  private boolean OK;
  boolean OL = false;
  boolean OM = false;
  boolean OO = false;
  private boolean OP;
  public boolean OQ;
  public boolean OR;
  public boolean OS;
  public boolean OT = true;
  public boolean OU;
  boolean OV = false;
  boolean OW = false;
  boolean OX = false;
  public boolean OY;
  boolean Ox = true;
  boolean Oy = false;
  boolean Oz = false;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  AnyChatReqTimeoutRunnable jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = null;
  StartAudioSendRunnable jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = null;
  StartRingRunnable jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
  private a jdField_a_of_type_ComTencentAvVideoController$a;
  c jdField_a_of_type_ComTencentAvVideoController$c = new igz(this);
  private InviteUIChecker jdField_a_of_type_ComTencentAvCompatInviteUIChecker;
  VcControllerImpl jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
  QQGAudioCtrl jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
  private ScreenShareCtrl jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl;
  public TraeHelper a;
  public ign a;
  private volatile igx jdField_a_of_type_Igx;
  public imb a;
  public imj a;
  iov jdField_a_of_type_Iov = null;
  private iow jdField_a_of_type_Iow;
  private jds jdField_a_of_type_Jds;
  public jjo a;
  jkf.a jdField_a_of_type_Jkf$a;
  public jkf a;
  oidb_0x8dd.SelfInfo jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo = new oidb_0x8dd.SelfInfo();
  private jhb[] jdField_a_of_type_ArrayOfJhb;
  Runnable aV = new VideoController.1(this);
  Runnable aW = new VideoController.2(this);
  public Runnable aX = null;
  Runnable aY = null;
  Runnable aZ = null;
  Object ah = new Object();
  int alA = 1;
  int alB = 2;
  int alC = 3;
  int alD = 4;
  private int alE = 1;
  public int alF = 0;
  private int alG = -1;
  int alH = 0;
  int alL = alI;
  private int alM;
  int alq = -1;
  public int alr = 0;
  public int als;
  public int alu;
  public int alv = 0;
  public int alw = 0;
  public int alx;
  private int aly;
  int alz = 0;
  Context appContext;
  public c b;
  igv jdField_b_of_type_Igv = igv.a();
  Runnable ba = null;
  Runnable bb = null;
  Runnable bc = null;
  Runnable bd = null;
  private Runnable be = new VideoController.30(this);
  Runnable bf = new VideoController.31(this);
  private Runnable bg;
  c c = new ihb(this);
  HashMap<Long, Long> cw = new HashMap();
  List<Runnable> fb = new ArrayList();
  private ArrayList<b> hY = new ArrayList();
  private final ArrayList<b> hZ = new ArrayList();
  ArrayList<b> ib = new ArrayList();
  public long kJ;
  public long kK;
  public long kL = 6000L;
  public long kM;
  long kN = 0L;
  long kO = 0L;
  public long kP = -1L;
  private final Object lock = new Object();
  public VideoAppInterface mApp;
  AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = null;
  boolean mIsCalling = false;
  public int mNetType;
  private int mOrientation = 0;
  private OrientationEventListener mOrientationListener;
  Runnable mTimeOutRunnable = null;
  
  private VideoController()
  {
    this.jdField_b_of_type_ComTencentAvVideoController$c = new iha(this);
    if (!jjc.xA()) {}
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker = new InviteUIChecker();
      }
      boolean bool = AEFilterSupport.uP();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "VideoController ret[" + bool + "]");
      }
      return;
      this.jdField_a_of_type_Imb = new imb();
    }
  }
  
  public static int a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean)
    {
      switch (paramInt1)
      {
      default: 
        paramInt2 = -1;
        return paramInt2;
      case 0: 
      case 9500: 
        if (paramInt2 == 2) {
          return 22;
        }
        return 0;
      case 1006: 
        return 5;
      case 1000: 
        return 8;
      case 1004: 
        return 9;
      case 1001: 
        return 12;
      case 10002: 
        return 27;
      case 10003: 
        return 29;
      case 1021: 
        return 10;
      case 1024: 
      case 1025: 
        return 19;
      case 1010: 
        return 20;
      case 1011: 
        return 21;
      case 8: 
        return 22;
      case 24: 
        return 24;
      case 25: 
        return 25;
      case 26: 
        return 26;
      }
      return 30;
    }
    paramInt2 = paramInt1;
    switch (paramInt1)
    {
    case 19: 
    default: 
      return -1;
    case 0: 
    case 9500: 
      return 0;
    case 4: 
    case 5: 
      return 1006;
    case 8: 
      return 1000;
    case 9: 
      return 1004;
    case 12: 
      return 1001;
    case 27: 
      return 10002;
    case 29: 
      return 10003;
    case 10: 
      return 1021;
    case 20: 
      return 1010;
    case 21: 
      return 1011;
    case 22: 
      return 22;
    case 24: 
      return 24;
    case 25: 
      return 25;
    case 26: 
      return 26;
    }
    return 1044;
  }
  
  private int a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 0;
    StartAudioSendRunnable localStartAudioSendRunnable;
    boolean bool1;
    label58:
    label64:
    label104:
    label122:
    String str;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (paramBoolean1) {
        i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioSend(paramBoolean2);
      }
    }
    else
    {
      boolean bool2 = this.OY;
      localStartAudioSendRunnable = this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable;
      if (paramBoolean1) {
        break label307;
      }
      if ((!paramBoolean2) && (!this.OY)) {
        break label301;
      }
      bool1 = true;
      this.OY = bool1;
      if (paramInt == 2) {
        break label368;
      }
      if ((i == 0) || (!paramBoolean2)) {
        break label354;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable != null) {
        break label315;
      }
      this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = new StartAudioSendRunnable(paramLong, paramString, paramBoolean1, paramBoolean2);
      this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable, 1000L);
      str = TAG;
      paramString = new StringBuilder().append("switchAudioSend[").append(paramString).append("], seq[").append(paramLong).append("], flag[").append(paramInt).append("], enable[").append(paramBoolean1).append("], notifySvr[").append(paramBoolean2).append("], mIsMicOffBySelf[").append(bool2).append("->").append(this.OY).append("], result[").append(i).append("], mGAudioCtrl[");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
        break label376;
      }
    }
    label301:
    label307:
    label315:
    label354:
    label368:
    label376:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      QLog.w(str, 1, paramBoolean1 + "], lastRunnable[" + localStartAudioSendRunnable + "], curRunnable[" + this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable + "]");
      return i;
      i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeStopAudioSend(paramBoolean2);
      break;
      bool1 = false;
      break label58;
      this.OY = false;
      break label64;
      this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable);
      if (paramInt != 0) {
        break label104;
      }
      this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = new StartAudioSendRunnable(paramLong, paramString, paramBoolean1, paramBoolean2);
      break label104;
      if (paramInt != 1) {
        break label122;
      }
      this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = null;
      break label122;
      this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = null;
      break label122;
    }
  }
  
  public static VideoController a()
  {
    if (jdField_b_of_type_ComTencentAvVideoController == null) {}
    try
    {
      if (jdField_b_of_type_ComTencentAvVideoController == null) {
        jdField_b_of_type_ComTencentAvVideoController = new VideoController();
      }
      return jdField_b_of_type_ComTencentAvVideoController;
    }
    finally {}
  }
  
  private qav_gvideo_sdk_transfer.RespInfo a(int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = new qav_gvideo_sdk_transfer.ReqInfo();
    ((qav_gvideo_sdk_transfer.ReqInfo)localObject).req_event.set(4);
    ((qav_gvideo_sdk_transfer.ReqInfo)localObject).gAudioInfo.setHasFlag(true);
    qav_gvideo_sdk_transfer.GAudioInfo localGAudioInfo = ((qav_gvideo_sdk_transfer.ReqInfo)localObject).gAudioInfo;
    localGAudioInfo.uint32_relationType.set(paramInt1);
    localGAudioInfo.uint32_multiBusiType.set(paramInt2);
    localGAudioInfo.uint64_relationId.set(paramLong);
    localObject = a(3, ((qav_gvideo_sdk_transfer.ReqInfo)localObject).toByteArray());
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "getGAudioRoomInfo, result[" + ((qav_gvideo_sdk_transfer.RespInfo)localObject).uint32_result.get() + "], uint64_roomId[" + ((qav_gvideo_sdk_transfer.RespInfo)localObject).gAudioInfo.uint64_roomId.get() + "]");
    }
    return localObject;
  }
  
  private iiv a(int paramInt, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = igv.a(3, paramString, new int[0]);
      localObject2 = igv.a().c((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = igv.a(100, paramString, new int[0]);
        localObject1 = igv.a().c((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = igv.a().b(paramString);
      }
      return localObject2;
      if (paramInt == 4)
      {
        localObject1 = igv.a(4, paramString, new int[0]);
        localObject1 = igv.a().c((String)localObject1);
      }
    }
  }
  
  private void a(int paramInt, long paramLong1, ini paramini, boolean paramBoolean, long paramLong2, int... paramVarArgs)
  {
    if ((paramInt == 7) && (!paramBoolean) && (this.jdField_b_of_type_Igv.sk()))
    {
      QLog.w(TAG, 1, "onGAudioUserEnterOrLeave, AV_RELATION_MULTI_RANDOM");
      return;
    }
    long l1 = paramini.account;
    long l2 = jji.B(this.mApp.getCurrentAccountUin());
    boolean bool1;
    if (l2 == l1)
    {
      bool1 = true;
      paramVarArgs = igv.a(paramInt, String.valueOf(paramLong1), new int[0]);
      if (paramInt != 3) {
        break label1684;
      }
      paramVarArgs = igv.a(100, String.valueOf(paramLong1), new int[0]);
    }
    label531:
    label1684:
    for (;;)
    {
      if (paramInt == 1) {}
      for (??? = b();; ??? = igv.a().c(paramVarArgs))
      {
        if ((??? != null) && (!TextUtils.isEmpty(((iiv)???).sessionId))) {
          break label175;
        }
        QLog.i(TAG, 1, "onGAudioUserEnterOrLeave, illegal session, sessionId[" + paramVarArgs + "]");
        return;
        bool1 = false;
        break;
      }
      label175:
      long l3 = AudioHelper.hG();
      if (AudioHelper.aCz()) {
        QLog.w(TAG, 1, "onGAudioUserEnterOrLeave, mGAudioGroupId[" + this.kJ + "], relationId[" + paramLong1 + "], mGAudioRelationType[" + this.alr + "], relationType[" + paramInt + "], UserInfo[" + paramini + "], isEnter[" + paramBoolean + "], bSelfIn[" + bool1 + "], selfUin[" + l2 + "], mGAudioMute[" + this.OO + "], switchToGAudioMode[" + ((iiv)???).and + "], extroInfo = " + paramLong2 + "], seq[" + l3 + "]");
      }
      if ((paramBoolean) && (bool1))
      {
        a("onGAudioUserEnterOrLeave", true, paramInt, paramLong1);
        ((iiv)???).QH = true;
        this.mApp.getHandler().removeCallbacks(this.mTimeOutRunnable);
        if (this.OO) {
          break label531;
        }
        bool2 = true;
        a("onGAudioUserEnterOrLeave", bool2, ((iiv)???).sT());
        if (((this.alr == 1) && (((iiv)???).anb == 10)) || (this.alr == 2)) {
          if (paramLong2 != 0L) {
            break label537;
          }
        }
      }
      label537:
      for (boolean bool2 = false;; bool2 = true)
      {
        ((iiv)???).QP = bool2;
        paramVarArgs = b();
        if ((paramBoolean) || (l1 != Long.valueOf(this.mApp.getCurrentAccountUin()).longValue()) || (paramLong1 != paramVarArgs.ll)) {
          break label543;
        }
        b(paramInt, paramLong1, 72);
        this.mApp.l(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
        return;
        bool2 = false;
        break;
      }
      label543:
      a(paramini, paramBoolean);
      if ((paramVarArgs.amI == 3) && (paramVarArgs.uinType == 1011))
      {
        if (!paramBoolean) {
          break label1093;
        }
        if (kD() != 1) {
          break label1081;
        }
        if (!bool1) {
          break label1069;
        }
        paramVarArgs.jdField_a_of_type_Iiv$a.anA = 4;
        label598:
        if ((!bool1) && ((sx()) || (sw())) && (!this.mApp.sM())) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(l3, this.mApp, 2131230749, null, 0, null);
        }
        e(paramVarArgs.jdField_a_of_type_Iiv$a.anA, 3, null);
        ??? = jko.a(this.mApp);
        if ((??? != null) && (((jko)???).isActive())) {
          alx();
        }
      }
      if (paramBoolean)
      {
        paramVarArgs.aa("onGAudioUserEnterOrLeave", 2);
        if (paramVarArgs.state < 10)
        {
          if ((this.hZ.size() == 1) && (bool1))
          {
            paramVarArgs.Y("onGAudioUserEnterOrLeave.1", 9);
            paramVarArgs.QR = false;
          }
        }
        else
        {
          label743:
          if ((paramVarArgs.lm != l1) && (l1 != l2)) {
            iwu.a(this.mApp, 1047);
          }
          if (!paramVarArgs.Qw) {
            break label1186;
          }
          if (!bool1) {
            paramVarArgs.C(l3, SystemClock.elapsedRealtime());
          }
          label795:
          if (!paramBoolean) {
            break label1350;
          }
          ??? = this.mApp;
          if (paramini.accountType != 0) {
            break label1344;
          }
          bool2 = true;
          label817:
          ((VideoAppInterface)???).l(new Object[] { Integer.valueOf(61), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool2) });
          label864:
          if (!paramVarArgs.Qw) {
            break label1519;
          }
          if ((paramBoolean) && (!bool1))
          {
            paramini = a();
            if (paramini != null) {
              paramini.cz(paramLong1);
            }
          }
          paramini = new Intent();
          paramini.setAction("tencent.av.v2q.MultiVideo");
          if (!paramBoolean) {
            break label1504;
          }
          paramini.putExtra("type", 401);
        }
      }
      for (;;)
      {
        for (;;)
        {
          paramini.putExtra("relationType", 3);
          paramini.putExtra("relationId", paramLong1);
          paramini.putExtra("friendUin", l1);
          paramini.putExtra("MultiAVType", paramVarArgs.anb);
          paramini.setPackage(this.mApp.getApp().getPackageName());
          this.mApp.getApp().sendBroadcast(paramini);
          if (paramBoolean) {
            break;
          }
          if (paramVarArgs.Qx)
          {
            paramini = jko.a(this.mApp);
            alM();
            if (paramini.isActive()) {
              paramini.cancelNotification(paramVarArgs.sessionId);
            }
          }
          if (!paramVarArgs.Ra) {
            break;
          }
          b(l3, paramLong1, false, 2);
          return;
          label1069:
          paramVarArgs.jdField_a_of_type_Iiv$a.anA = 1;
          break label598;
          label1081:
          paramVarArgs.jdField_a_of_type_Iiv$a.anA = 5;
          break label598;
          label1093:
          if (kD() == 1) {
            paramVarArgs.jdField_a_of_type_Iiv$a.anA = 4;
          }
          if ((bool1) || ((!sx()) && (!sw())) || (this.mApp.sM()) || (!sx())) {
            break label647;
          }
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(l3, this.mApp, 2131230750, null, 0, null);
          break label647;
          paramVarArgs.Y("onGAudioUserEnterOrLeave.2", 10);
          alL();
          break label743;
          label1186:
          if (paramVarArgs.lj != 0L) {
            break label795;
          }
          paramVarArgs.C(l3, SystemClock.elapsedRealtime());
          break label795;
          synchronized (this.hZ)
          {
            if ((this.hZ.size() == 1) && (this.hZ.get(0) != null) && (((b)this.hZ.get(0)).uin == l2))
            {
              i = 1;
              if (i != 0)
              {
                paramVarArgs.Y("onGAudioUserEnterOrLeave.3", 9);
                paramVarArgs.QR = true;
                ??? = jko.a(this.mApp);
                if ((??? != null) && (((jko)???).isActive()))
                {
                  alM();
                  alx();
                }
              }
              iwu.a(this.mApp, 1047);
              break label795;
            }
            int i = 0;
          }
        }
        label1344:
        bool2 = false;
        break label817;
        label1350:
        if (paramLong2 == 1L)
        {
          hH(true);
          break label864;
        }
        if (paramLong2 == 0L)
        {
          ??? = this.mApp;
          if (paramini.accountType == 0) {}
          for (bool2 = true;; bool2 = false)
          {
            ((VideoAppInterface)???).l(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool2) });
            break;
          }
        }
        ??? = this.mApp;
        if (paramini.accountType == 0) {}
        for (bool2 = true;; bool2 = false)
        {
          ((VideoAppInterface)???).l(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool2) });
          break;
        }
        label1504:
        paramini.putExtra("type", 402);
      }
      label1519:
      paramini = new Intent();
      paramini.setAction("tencent.av.v2q.MultiVideo");
      if (paramBoolean)
      {
        paramini.putExtra("type", 22);
        paramini.putExtra("isStart", this.OV);
      }
      for (;;)
      {
        paramini.putExtra("roomUserNum", this.hZ.size());
        paramini.putExtra("relationType", paramInt);
        paramini.putExtra("relationId", paramLong1);
        paramini.putExtra("friendUin", l1);
        paramini.putExtra("MultiAVType", b().anb);
        paramini.putExtra("from", "VideoController5");
        paramini.setPackage(this.mApp.getApp().getPackageName());
        this.mApp.getApp().sendBroadcast(paramini);
        return;
        paramini.putExtra("type", 23);
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    QLog.d(TAG, 2, "onVideoRecv ");
    Context localContext = getAppContext();
    if (localContext == null) {
      return;
    }
    igs localigs = this.mApp.a();
    localigs.hO(this.mApp.getApp().getString(2131698070));
    localigs.b(new ihf(this, paramLong1, paramLong2, paramInt1, paramLong3, paramInt2, localContext, localigs));
  }
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt1, long paramLong3, int paramInt2)
  {
    long l1 = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "onGaChatVideoInOrOut, groupId[" + paramLong1 + "], user[" + paramLong2 + "], bVideoIn[" + paramBoolean + "], relationType[" + paramInt1 + "], extraInfo[" + paramLong3 + "], avtype[" + paramInt2 + "], seq[" + l1 + "]");
    }
    long l2 = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
    if ((paramLong3 == 1L) && (!paramBoolean) && (paramLong2 != l2) && (paramInt1 == 3)) {
      return;
    }
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 2) && (paramLong2 != jji.B(this.mApp.getCurrentAccountUin())))
    {
      i = 0;
      label185:
      if (i < b().jdField_if.size()) {
        if (((ioa)b().jdField_if.get(i)).uin != paramLong2) {}
      }
    }
    for (int i = ((ioa)b().jdField_if.get(i)).videoSrcType;; i = 1)
    {
      a(paramLong2, paramBoolean, paramInt1, paramLong3);
      if (paramBoolean)
      {
        if ((paramInt1 != 2) && (paramInt1 != 3) && ((paramInt1 != 1) || (paramInt2 != 10))) {
          break;
        }
        this.mApp.l(new Object[] { Integer.valueOf(69), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
        return;
        i += 1;
        break label185;
      }
      this.mApp.l(new Object[] { Integer.valueOf(70), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i), Long.valueOf(l1) });
      return;
    }
  }
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, long paramLong3, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onGaChatPPTInOrOut,groupUin=" + paramLong1 + " uin = " + paramLong2 + " bIn = " + paramBoolean1 + " bIsPPT = " + paramBoolean2 + " extraInfo = " + paramLong3);
    }
    long l = jjc.A(this.mApp.getCurrentAccountUin());
    if ((paramLong3 == 1L) && (!paramBoolean1) && (paramLong2 != l) && (paramInt1 == 3) && (paramInt2 != 10)) {
      return;
    }
    if (paramInt1 == 3) {}
    for (Object localObject = igv.a(100, String.valueOf(paramLong1), new int[0]);; localObject = igv.a(paramInt1, String.valueOf(paramLong1), new int[0]))
    {
      localObject = this.jdField_b_of_type_Igv.c((String)localObject);
      if (localObject != null) {
        ((iiv)localObject).c(paramLong2, paramBoolean1, paramBoolean2);
      }
      a(paramLong2, paramBoolean1, paramInt1, paramBoolean2, paramInt2);
      if (!paramBoolean1) {
        break;
      }
      this.mApp.l(new Object[] { Integer.valueOf(77), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2) });
      return;
    }
    this.mApp.l(new Object[] { Integer.valueOf(78), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2) });
  }
  
  private void a(long paramLong1, boolean paramBoolean, int paramInt, long paramLong2)
  {
    b localb = a(String.valueOf(paramLong1));
    if (localb == null) {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "onMemberVideoInOrOut-->Can not find the.Uin=" + paramLong1);
      }
    }
    ioa localioa;
    do
    {
      do
      {
        return;
        localb.Ph = paramBoolean;
      } while ((paramLong1 == Long.valueOf(this.mApp.getCurrentAccountUin()).longValue()) && (b().b(paramLong1, 1) != -1));
      if (!paramBoolean) {
        break;
      }
      localioa = new ioa();
      localioa.uin = paramLong1;
      localioa.videoSrcType = 1;
    } while (b().b(paramLong1, localioa.videoSrcType) != -1);
    localioa.mk = paramLong2;
    if ((paramInt == 1) && (paramLong2 != 4L) && (paramLong2 != 2L) && (paramLong2 != 3L)) {
      localioa.mk = 5L;
    }
    if (!b().tl())
    {
      localioa.Tp = true;
      if ((getVideoAbilityLevel() == 4) || (paramInt == 3)) {
        break label320;
      }
      if (b().w(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue()) != -1) {
        break label311;
      }
      localioa.Tq = true;
      label236:
      if (localb.uin != Long.valueOf(this.mApp.getCurrentAccountUin()).longValue()) {
        break label338;
      }
      localioa.isRender = true;
      localioa.Tr = true;
      localioa.Tq = true;
      if (b().tl()) {
        break label329;
      }
    }
    label311:
    label320:
    label329:
    for (localioa.Tp = true;; localioa.Tp = false)
    {
      b().a(localioa);
      return;
      localioa.Tp = false;
      break;
      localioa.Tq = false;
      break label236;
      localioa.Tq = true;
      break label236;
    }
    label338:
    localioa.isRender = false;
    b().a(localioa);
    return;
    if (paramInt == 2) {
      a(paramLong1, b().jdField_if, b().ig, 1, false);
    }
    for (;;)
    {
      alN();
      return;
      if (paramInt == 1)
      {
        if (b().anb == 10) {
          a(paramLong1, b().jdField_if, b().ig, 1, false);
        } else {
          a(paramLong1, b().jdField_if, b().ig, 0, true);
        }
      }
      else if (paramInt == 3) {
        a(paramLong1, b().jdField_if, b().ig, 1, false);
      }
    }
  }
  
  private void a(long paramLong, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    if ((paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 == 1) && (paramInt2 == 2)) {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "onMemberShareSrcInOrOut-->relationtype is not discuss,uin=" + paramLong + ",bin=" + paramBoolean1 + ",relationType=" + paramInt1 + ",isPPT=" + paramBoolean2);
      }
    }
    label158:
    do
    {
      return;
      if (paramLong == Long.valueOf(this.mApp.getCurrentAccountUin()).longValue()) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((sm()) || (paramLong != Long.valueOf(this.mApp.getCurrentAccountUin()).longValue())) {
          break label158;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(TAG, 2, "ScreenShare launcher shoult not display content");
        return;
      }
      ??? = a(String.valueOf(paramLong));
      if (??? != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
    return;
    if (paramBoolean1)
    {
      ioa localioa1 = new ioa();
      if (paramBoolean2) {
        ((b)???).alV = 2;
      }
      for (;;)
      {
        localioa1.uin = paramLong;
        localioa1.videoSrcType = 2;
        localioa1.Tp = true;
        localioa1.isRender = false;
        long l;
        ioa localioa3;
        if (paramInt1 != 0)
        {
          l = 4L;
          localioa1.mk = l;
          if (b().b(paramLong, localioa1.videoSrcType) != -1) {
            break;
          }
          if (b().jdField_if.size() > 0)
          {
            ((ioa)b().jdField_if.get(0)).Tp = false;
            if (getVideoAbilityLevel() != 4)
            {
              paramInt1 = b().w(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue());
              if (paramInt1 != -1) {
                ((ioa)b().jdField_if.get(paramInt1)).Tq = false;
              }
            }
          }
          localioa1.Tq = true;
          if (b().jdField_if.size() <= 1) {
            break label489;
          }
          localioa3 = (ioa)b().jdField_if.get(0);
          b().jdField_if.set(0, localioa1);
        }
        synchronized (b().ig)
        {
          b().ig.set(0, localioa1);
          b().a(localioa3);
          return;
          ((b)???).alV = 1;
          continue;
          l = 5L;
        }
      }
      label489:
      b().a(0, localioa2);
      return;
    }
    ((b)???).alV = 0;
    a(paramLong, b().jdField_if, b().ig, 2, false);
    alN();
  }
  
  private void a(Intent paramIntent, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    imb localimb = a();
    ihq.n("Video:StartActivity", 5000L);
    if ((paramBoolean1) && (Build.VERSION.SDK_INT >= 16))
    {
      ActivityOptions localActivityOptions = ActivityOptions.makeCustomAnimation(this.mApp.getApp(), 2130772239, 0);
      this.mApp.getApp().startActivity(paramIntent, localActivityOptions.toBundle());
      QLog.w(TAG, 1, "startInvite startActivity");
      if (localimb != null) {
        localimb.aB(paramIntent);
      }
      if (!paramBoolean2) {
        break label201;
      }
      a(paramString, "screenState", String.valueOf(2));
    }
    for (;;)
    {
      a(paramString, "inviteUIState", String.valueOf(1));
      long l = 0L;
      if (this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker != null) {
        l = this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker.a(this.mApp, paramIntent, true);
      }
      if (QLog.isColorLevel()) {
        QLog.i("CompatModeTag", 2, "startInvite  canStartActivityNow[" + true + "], timeout[" + l + "]");
      }
      return;
      this.mApp.getApp().startActivity(paramIntent);
      break;
      label201:
      a(paramString, "screenState", String.valueOf(1));
    }
  }
  
  private boolean a(long paramLong, boolean paramBoolean, int paramInt)
  {
    b localb = a(String.valueOf(paramLong));
    if (localb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
      }
      return false;
    }
    localb.Pg = paramBoolean;
    localb.alU = paramInt;
    return false;
  }
  
  private void aA(Intent paramIntent)
  {
    imb localimb = a();
    this.mApp.getApp().startActivity(paramIntent);
    if (localimb != null) {
      localimb.aB(paramIntent);
    }
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker != null) {
      l = this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker.a(this.mApp, paramIntent, true);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CompatModeTag", 2, "startInviteForGroup canStartActivityNow[" + true + "], timeout[" + l + "]");
    }
  }
  
  public static int ag(String paramString)
  {
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences(Mo, 0);
    int i = ((SharedPreferences)localObject).getInt(paramString, 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(paramString, i + 1);
    ((SharedPreferences.Editor)localObject).commit();
    return i;
  }
  
  private void ak(Bundle paramBundle)
  {
    this.Ms = paramBundle.getString("fromUin");
    this.alM = ((int)(System.currentTimeMillis() / 1000L));
  }
  
  private void alP()
  {
    Object localObject = b();
    int m;
    int j;
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() > 0))
    {
      int k = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size();
      long l = ((iiv)localObject).lm;
      localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
      int i = this.alv;
      ((QQGAudioCtrl)localObject).inviteUser(new long[] { l }, i);
      m = k - 1;
      localObject = new long[m * 2];
      j = 0;
      i = 0;
      if (j < k)
      {
        if ((((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(j)).longValue() == l) || (i >= m)) {
          break label186;
        }
        localObject[(i * 2)] = 1L;
        localObject[(i * 2 + 1)] = ((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(j)).longValue();
        i += 1;
      }
    }
    label186:
    for (;;)
    {
      j += 1;
      break;
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject, m, null, 0, 0, false, false, 4);
      return;
    }
  }
  
  private void alQ()
  {
    if (this.jdField_a_of_type_Imj == null)
    {
      this.jdField_a_of_type_Imj = new imj(this, this.mApp);
      b().uinType = 9500;
      if (QLog.isColorLevel()) {
        QLog.w("BaseIMSharp", 2, "init device sharp");
      }
    }
  }
  
  private void alu()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "initOrientationListener");
    }
    this.mOrientationListener = new ihi(this, getAppContext(), 3);
    if (this.mOrientationListener.canDetectOrientation())
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "Can detect orientation");
      }
      this.mOrientationListener.enable();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "Cannot detect orientation");
    }
    this.mOrientationListener.disable();
    this.mOrientationListener = null;
  }
  
  private void alv()
  {
    AudioManager localAudioManager = (AudioManager)this.appContext.getSystemService("audio");
    if (localAudioManager != null)
    {
      long l1 = System.currentTimeMillis();
      boolean bool = localAudioManager.isMicrophoneMute();
      if (bool) {
        localAudioManager.setMicrophoneMute(false);
      }
      long l2 = System.currentTimeMillis();
      igd.aJ(TAG, " ---setMicrophoneMute:" + bool + "|" + (l2 - l1));
    }
  }
  
  private void alw()
  {
    ihl localihl = this.mApp.a();
    if (localihl != null) {
      localihl.alw();
    }
  }
  
  private void amb()
  {
    this.Ms = null;
    this.alM = 0;
  }
  
  private void amc()
  {
    if (this.bg != null) {
      this.mApp.getHandler().removeCallbacks(this.bg);
    }
    this.bg = null;
  }
  
  private void amf()
  {
    if ((this.kP != -1L) && (System.currentTimeMillis() - this.kP < 10000L)) {
      return;
    }
    this.kP = System.currentTimeMillis();
    echo.ReqEcho localReqEcho = new echo.ReqEcho();
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), iho.class);
    localNewIntent.putExtra("reqType", 20);
    localNewIntent.putExtra("vMsg", localReqEcho.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "checkNetStatus -->sendEcho");
    }
    a(localNewIntent);
  }
  
  private void b(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    if (this.bg != null) {
      this.mApp.getHandler().removeCallbacks(this.bg);
    }
    this.bg = new VideoController.36(this, paramString1, paramLong, paramInt1, paramString2, paramString3, paramBoolean1, paramBoolean3, paramInt2);
    this.mApp.getHandler().postDelayed(this.bg, 1000L);
  }
  
  private boolean cm(String paramString)
  {
    if (paramString == null) {}
    iiv localiiv;
    do
    {
      return false;
      localiiv = igv.a().a();
    } while ((localiiv == null) || (localiiv.peerUin == null) || (!paramString.equals(localiiv.peerUin)));
    return true;
  }
  
  private boolean cn(String paramString)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = this.alM;
    return (this.Ms != null) && (paramString != null) && (this.Ms.equals(paramString)) && (i - j < 3);
  }
  
  private boolean isLandscape()
  {
    WindowManager localWindowManager = (WindowManager)getAppContext().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    int k = localWindowManager.getDefaultDisplay().getRotation();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isLandscape screenWidth: " + i + ", screenHeight: " + j + ", rotation: " + k + ", orientation: " + this.mOrientation);
    }
    return (i > j) || (k == 1) || (k == 3) || (this.mOrientation == 4) || (this.mOrientation == 2);
  }
  
  public static boolean isScreenLocked(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public static boolean isScreenOn(Context paramContext)
  {
    return ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
  }
  
  private void p(ArrayList<ioa> paramArrayList, int paramInt)
  {
    int m = 0;
    int i;
    if (b().ani == 3)
    {
      i = 1;
      if (b().amI != 4) {
        break label173;
      }
    }
    label173:
    for (int j = 1;; j = 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        m = 1;
      }
      int k = paramInt;
      if (i != 0)
      {
        k = paramInt;
        if (j != 0)
        {
          k = paramInt;
          if (m != 0)
          {
            i = paramArrayList.size() - 1;
            k = paramInt;
            if (i != paramInt)
            {
              ioa localioa = (ioa)paramArrayList.get(paramInt);
              paramArrayList.set(paramInt, paramArrayList.get(i));
              paramArrayList.set(i, localioa);
              k = i;
            }
          }
        }
      }
      paramArrayList.remove(k);
      if (QLog.isColorLevel()) {
        QLog.w(TAG, 1, "onRequest_ShowVideo,in removeChildrenWithStytle infoLogs[" + f(b().jdField_if) + "]");
      }
      return;
      i = 0;
      break;
    }
  }
  
  private int sendQueryRoomInfoRequest(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendQueryRoomInfoRequest(paramLong1, paramLong2);
    }
    return -100;
  }
  
  public static boolean sm()
  {
    return false;
  }
  
  public void A(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "updateRandomChatInfo uin: " + paramString1 + ", nickName: " + paramString2 + ", headUrl: " + paramString3);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.updateChatInfo");
    if (!TextUtils.isEmpty(paramString1))
    {
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("nickName", paramString2);
      localIntent.putExtra("headUrl", paramString3);
    }
    localIntent.setPackage(this.mApp.getApp().getPackageName());
    this.mApp.getApp().sendBroadcast(localIntent);
  }
  
  public void A(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onGVideoDownloadChannelCtlChanged start");
    }
    qav_gvideo_sdk_transfer.gVideoDownChannelControl localgVideoDownChannelControl;
    if (paramArrayOfByte != null) {
      localgVideoDownChannelControl = new qav_gvideo_sdk_transfer.gVideoDownChannelControl();
    }
    try
    {
      localgVideoDownChannelControl.mergeFrom(paramArrayOfByte);
      i = localgVideoDownChannelControl.uint32_switch.get();
      bool = b().b(localgVideoDownChannelControl);
      if (i == 1) {}
      if (!bool) {
        break label87;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        label87:
        paramArrayOfByte.printStackTrace();
        boolean bool = false;
        continue;
        int i = 0;
      }
    }
    if (b().ani == 3)
    {
      i = 1;
      if (i != 0) {
        F(true);
      }
      return;
    }
  }
  
  public boolean F(boolean paramBoolean)
  {
    boolean bool = false;
    String str = f(b().ih);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "RequestGVideo-->info=" + str);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      alv();
      i = 0;
      if (i >= b().ih.size()) {
        break label334;
      }
      if (((ioa)b().ih.get(i)).uin == Long.valueOf(this.mApp.getCurrentAccountUin()).longValue()) {
        b().ih.remove(i);
      }
    }
    label140:
    label334:
    for (int i = 1;; i = 0)
    {
      if (Build.VERSION.SDK_INT < 21)
      {
        if (i != 0) {
          i = 8;
        }
        for (;;)
        {
          if (i < b().ih.size())
          {
            ArrayList localArrayList = new ArrayList(i);
            int j = 0;
            for (;;)
            {
              if (j < i)
              {
                localArrayList.add(b().ih.get(j));
                j += 1;
                continue;
                i += 1;
                break;
                i = 9;
                break label140;
              }
            }
            b().ih = localArrayList;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startVideoRecv(b().ih, paramBoolean) != 0) {
        paramBoolean = true;
      }
      do
      {
        return paramBoolean;
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "RequestGVideo-->Request video failed,ViewInfos=" + str);
        }
        b().ih.clear();
        return false;
        b().ih.clear();
        paramBoolean = bool;
      } while (!QLog.isColorLevel());
      QLog.e(TAG, 2, "RequestGVideo-->Request video failed,mGaudioCtrl is null,ViewInfo=" + str);
      return false;
    }
  }
  
  public void G(boolean paramBoolean1, boolean paramBoolean2)
  {
    iiv localiiv = b();
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("onPhoneCalling, isSelf[").append(paramBoolean1).append("], isCalling[").append(localiiv.PQ).append("->").append(paramBoolean2).append("], deviceName[").append(localiiv.deviceName).append("], audioStateBeforePhoneCall[").append(localiiv.mAudioStateBeforePhoneCall).append("], mTraeHelper[");
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
        break;
      }
      return;
    }
    if ((localiiv.uinType == 0) && (localiiv.state != 0) && (localiiv.state != 5) && (localiiv.state != 6) && (localiiv.PQ != paramBoolean2))
    {
      localiiv.PQ = paramBoolean2;
      if (!paramBoolean2) {
        break label266;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axI();
      localiiv.mAudioStateBeforePhoneCall = localiiv.deviceName;
    }
    for (;;)
    {
      if (((localiiv.amI == 3) || (localiiv.amI == 4)) && (localiiv.PQ != paramBoolean2)) {
        localiiv.PQ = paramBoolean2;
      }
      if (!paramBoolean1) {
        break label357;
      }
      this.mApp.l(new Object[] { Integer.valueOf(22), Boolean.valueOf(paramBoolean2) });
      return;
      label266:
      if ("DEVICE_SPEAKERPHONE".equals(localiiv.mAudioStateBeforePhoneCall))
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.startService("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      else
      {
        if (!"DEVICE_EARPHONE".equals(localiiv.mAudioStateBeforePhoneCall)) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.startService("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
    }
    if (localiiv.amI == 1) {}
    for (str = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";; str = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;")
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.startService(str);
      break;
    }
    label357:
    this.mApp.l(new Object[] { Integer.valueOf(23), Boolean.valueOf(paramBoolean2) });
  }
  
  public boolean G(boolean paramBoolean)
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return false;
    }
    QLog.w(TAG, 1, "setRoomMicOff, micOff[" + paramBoolean + "]");
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (paramBoolean) {}
    for (;;)
    {
      return localQQGAudioCtrl.setMicMode(i);
      i = 0;
    }
  }
  
  public void L(int paramInt, String paramString)
  {
    if ((this.jdField_b_of_type_Igv == null) || (b() == null) || (b().peerUin == null)) {}
    while (!b().peerUin.equals(paramString)) {
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
        QLog.d(TAG, 2, "onAVShiftEvent remote switch to video mode,waiting for confirm");
      }
      b().QE = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "remote confirm switch to video");
    }
    b().QE = false;
  }
  
  public void L(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onAnotherIsRing isCalling = " + paramBoolean);
    }
    b().QF = paramBoolean;
    if (paramBoolean) {
      jjk.q(this);
    }
    if (jkg.isCalling(this.mApp.getApp())) {
      return;
    }
    G(false, paramBoolean);
  }
  
  public void M(int paramInt, String paramString)
  {
    igd.aJ(TAG, "onReceiveSubtitleChanged:" + paramString);
    this.mApp.l(new Object[] { Integer.valueOf(6009), Integer.valueOf(paramInt), paramString });
  }
  
  public void M(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "setGAudioMute, [" + this.OO + " --> " + paramBoolean + "], from[" + paramString + "]");
    }
    this.OO = paramBoolean;
  }
  
  public void N(int paramInt, String paramString)
  {
    igd.aK(TAG, String.format("onReceiveMagicface|type=%d, id=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    this.mApp.l(new Object[] { Integer.valueOf(6103), Integer.valueOf(paramInt), paramString });
  }
  
  public void O(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onInviteUser --> Count = " + paramInt + " , firstName = " + paramString);
    }
    if ((paramInt > 0) && (paramString != null)) {
      this.mApp.l(new Object[] { Integer.valueOf(409), Integer.valueOf(paramInt), paramString });
    }
  }
  
  public void O(String paramString, int paramInt)
  {
    boolean bool2 = false;
    long l = AudioHelper.hG();
    QLog.w(TAG, 1, "avideo closeVideo begin, peerUin[" + paramString + "], emCloseReason[" + paramInt + "], seq[" + l + "], mStartRing[" + this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable + "]", new Throwable("打印调用栈"));
    if (this.mApp == null) {}
    do
    {
      do
      {
        return;
      } while ((!sB()) && (this.jdField_b_of_type_Igv.sl()));
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      jle.a(getAppContext()).stop();
    } while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null);
    if ((1 != getApn()) && (!sp()))
    {
      n(0, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getTrafficSize(paramString));
      this.Oz = true;
    }
    if (this.jdField_a_of_type_Igx != null) {
      this.jdField_a_of_type_Igx.stopMonitor();
    }
    this.OG = false;
    int i = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, paramInt, this);
    if ((sB()) && (paramInt != 110)) {
      this.mApp.l(new Object[] { Integer.valueOf(40), b().peerUin, Boolean.valueOf(true) });
    }
    Object localObject = this.mApp.a();
    if (localObject != null) {
      ((ihm)localObject).kA(paramInt);
    }
    a(paramString, "inviteUIState", "");
    a(paramString, "screenState", "");
    localObject = b().peerUin;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      bool1 = bool2;
      if (((String)localObject).equalsIgnoreCase(paramString))
      {
        this.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        kq(paramInt);
        jko.bD(this.mApp.getApplication().getApplicationContext());
        bool1 = true;
      }
    }
    QLog.w(TAG, 1, "avideo closeVideo end, result[" + i + "], cancelNotificationForce[" + bool1 + "], seq[" + l + "]");
  }
  
  public void P(String paramString, int paramInt)
  {
    long l = AudioHelper.hG();
    TraeHelper.a().dN(l);
    TraeHelper.t(this.mApp);
    if (cm(paramString)) {
      TraeHelper.a().axI();
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "closeSession", new Throwable("closeSession"));
    }
    b(l, paramString, paramInt, false);
  }
  
  public void Q(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onPeerSwitchTerminalFail fromUin = " + paramString + ", info :" + paramInt);
    }
    a("onPeerSwitchTerminalFail", b());
    this.mApp.l(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(false) });
  }
  
  public void R(String paramString, int paramInt)
  {
    if (!b().QU)
    {
      if (QLog.isColorLevel()) {
        QLog.w(TAG, 2, "not start StartByTerminalSwitch but receive onSyncOtherTerminalChatStatus message");
      }
      return;
    }
    int j = paramInt & 0xFFFFF;
    int i = paramInt >> 20 & 0x1;
    int k = paramInt >> 21 & 0x1;
    paramInt = i;
    if (b().QW)
    {
      paramInt = i;
      if (b().amI == 1)
      {
        paramInt = i;
        if (sq())
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "switch start frome video entry, open camera");
          }
          paramInt = 1;
        }
      }
    }
    b().lk = j;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onSyncOtherTerminalChatStatus time:" + j + ", isCamreOpen:" + paramInt + ", isMicOpen:" + k);
    }
    this.mApp.l(new Object[] { Integer.valueOf(34), Integer.valueOf(paramInt), Integer.valueOf(k) });
  }
  
  public void S(String paramString, int paramInt)
  {
    QLog.d(TAG, 1, String.format("SetNetIPAndPort ip=%s port=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    this.Mn = paramString;
    this.aly = paramInt;
    try
    {
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.SetNetIPAndPort(paramString, paramInt);
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetIPAndPort(paramString, paramInt);
      }
      aqmj.i(this.mApp.getCurrentAccountUin()).edit().putString(VideoConstants.Mh, paramString).commit();
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      QLog.e(TAG, 2, "SetNetIPAndPort fail.", paramString);
    }
  }
  
  public void T(String paramString, int paramInt)
  {
    this.mApp.l(new Object[] { Integer.valueOf(42), paramString, Integer.valueOf(paramInt) });
  }
  
  public void U(String paramString, int paramInt)
  {
    this.mApp.l(new Object[] { Integer.valueOf(43), paramString, Integer.valueOf(paramInt) });
  }
  
  public void V(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "setGAudioSpeakerMode, [" + this.alE + " --> " + paramInt + "], from[" + paramString + "]");
    }
    this.alE = paramInt;
  }
  
  public int a(int paramInt1, long paramLong, int paramInt2, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramLong == 0L)
    {
      QLog.i(TAG, 1, "startGAudioChat, relationId illegal.");
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      alE();
    }
    AudioHelper.G(this.mApp);
    igd.aI("VideoNodeManager", "==> startGAudioChat() ********************************** isVideo = " + paramBoolean + "  getSessionInfo().multiAVType = " + b().anb);
    AudioHelper.rw("startGAudioChat ");
    setAudioOpt(false);
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder().append("startGAudioChat, relationType[").append(paramInt1).append("], relationId[").append(paramLong).append("], businessId[").append(paramInt2).append("], uinList[").append(paramArrayOfLong).append("], isVideo[").append(paramBoolean).append("], mGAudioCtrl[");
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      bool = true;
      localObject2 = ((StringBuilder)localObject2).append(bool).append("], mApp[");
      if (this.mApp == null) {
        break label235;
      }
    }
    label235:
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject1, 1, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        break label241;
      }
      return -1;
      bool = false;
      break;
    }
    label241:
    if (this.mApp == null) {
      return -1;
    }
    localObject1 = igv.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      localObject1 = igv.a(100, String.valueOf(paramLong), new int[0]);
    }
    long l;
    int j;
    int i;
    if (!this.jdField_b_of_type_Igv.ci((String)localObject1))
    {
      localObject2 = this.jdField_b_of_type_Igv.a((String)localObject1, true);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        ((iiv)localObject2).relationType = paramInt1;
        ((iiv)localObject2).anb = paramInt2;
        localObject1 = localObject2;
      }
      this.OQ = false;
      l = jji.B(this.mApp.getCurrentAccountUin());
      if ((paramInt1 != 7) && (paramInt1 != 9)) {
        break label602;
      }
      j = 1;
      i = paramInt2;
      paramInt2 = j;
    }
    for (;;)
    {
      label372:
      localObject1 = b();
      if (paramBoolean) {
        paramInt2 = 2;
      }
      if ((((iiv)localObject1).Qw) && (((iiv)localObject1).Rq)) {
        paramInt2 = 5;
      }
      for (;;)
      {
        alt();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getSessionInfo().localHasVideo = " + b().PY);
        }
        alv();
        this.mApp.amM();
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startGAudio(paramInt1, i, paramInt2, paramLong, paramArrayOfLong, getApn(), l, b().sU(), b().ank, b().anj, b().any);
        if (this.mTimeOutRunnable == null) {
          this.mTimeOutRunnable = new VideoController.22(this, paramInt1, paramLong);
        }
        this.OV = true;
        ((iiv)localObject1).Y("startGAudioChat.2", 8);
        ((iiv)localObject1).ll = paramLong;
        this.mApp.getHandler().postDelayed(this.mTimeOutRunnable, 30000L);
        acV();
        a(((iiv)localObject1).sessionId, 3, false, false, false);
        return 0;
        localObject1 = this.jdField_b_of_type_Igv.c((String)localObject1);
        break;
        label602:
        if (paramInt1 == 2)
        {
          if (b().PY) {}
          for (paramInt2 = 2;; paramInt2 = 1)
          {
            i = 1;
            break;
          }
        }
        if (paramInt1 == 1)
        {
          i = b().anb;
          if (b().PY) {}
          for (paramInt2 = 2;; paramInt2 = 1) {
            break;
          }
        }
        if (paramInt1 == 10)
        {
          j = 1;
          i = paramInt2;
          paramInt2 = j;
          break label372;
        }
        if (paramInt1 == 3)
        {
          if (localObject1 == null) {
            break label774;
          }
          ((iiv)localObject1).ll = paramLong;
          ((iiv)localObject1).relationType = paramInt1;
          ((iiv)localObject1).anb = paramInt2;
          ((iiv)localObject1).peerUin = String.valueOf(paramLong);
          ((iiv)localObject1).uinType = 0;
          ((iiv)localObject1).S("startGAudioChat", true);
          j = 1;
          i = paramInt2;
          paramInt2 = j;
          break label372;
        }
        return -1;
        if (((iiv)localObject1).sU()) {
          paramInt2 = 3;
        }
      }
      label774:
      j = 1;
      i = paramInt2;
      paramInt2 = j;
    }
  }
  
  public int a(int paramInt, AVFunChat.AVFunChatMessage paramAVFunChatMessage)
  {
    if (paramAVFunChatMessage == null)
    {
      QLog.i(TAG, 1, "sendAVFunChatMsg, msg is null.");
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "sendAVFunChatMsg, toUin[" + b().peerUin + "], msg[" + paramAVFunChatMessage.uint64_type.get() + ", " + paramAVFunChatMessage.enum_operator.get() + ", " + paramAVFunChatMessage.str_msg.get() + "]");
    }
    return a(paramInt, paramAVFunChatMessage.toByteArray());
  }
  
  public int a(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool = b().isConnected();
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = TAG;
      localStringBuilder = new StringBuilder().append("sendAVFunChatMsg, type[").append(paramInt).append("], isConnected[").append(bool).append("], dataLen[");
      if (paramArrayOfByte != null) {
        break label90;
      }
    }
    label90:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      QLog.i(str, 2, i + "]");
      if (bool) {
        break;
      }
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendAVFunChatMsg(b().peerUin, paramInt, paramArrayOfByte);
  }
  
  public int a(long paramLong1, int paramInt, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean)
  {
    ??? = TAG + "|VideoNodeManager";
    StringBuilder localStringBuilder = new StringBuilder().append("acceptGAudioChat, relationType[").append(paramInt).append("], relationId[").append(paramLong2).append("], isVideo[").append(paramBoolean).append("], relationId[").append(paramLong2).append("], mIsStartGAuio[").append(this.OV).append("], uinList[");
    if (paramArrayOfLong != null)
    {
      bool = true;
      localStringBuilder = localStringBuilder.append(bool).append("], mGAudioCtrl[");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
        break label186;
      }
    }
    label186:
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)???, 1, bool + "], seq[" + paramLong1 + "]");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
        alE();
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        break label192;
      }
      return -1;
      bool = false;
      break;
    }
    label192:
    hM(false);
    setAudioOpt(false);
    this.OQ = false;
    for (;;)
    {
      int j;
      synchronized (this.hZ)
      {
        this.hZ.clear();
        b().Y("acceptGAudioChat", 8);
        b().ll = paramLong2;
        b().QT = true;
        b().Rc = true;
        paramLong1 = jji.B(this.mApp.getCurrentAccountUin());
        j = 2;
        if (paramInt != 2) {
          break label449;
        }
        j = 1;
        if (b().PY)
        {
          i = 2;
          if (paramBoolean) {
            i = 2;
          }
          if (AudioHelper.aCz()) {
            QLog.w(TAG, 1, "acceptGAudioChat, MainSession[" + b() + "]");
          }
          this.mApp.amM();
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.acceptGAudio(paramInt, j, i, paramLong2, paramArrayOfLong, getApn(), paramLong1, b().anj);
          if (this.mTimeOutRunnable == null) {
            this.mTimeOutRunnable = new VideoController.23(this, paramInt, paramLong2);
          }
          this.OV = false;
          this.mApp.getHandler().postDelayed(this.mTimeOutRunnable, 30000L);
          acV();
          return 0;
        }
      }
      int i = 1;
      continue;
      label449:
      if (paramInt == 1)
      {
        j = b().anb;
        if (b().PY) {}
        for (i = 2;; i = 1) {
          break;
        }
      }
      if (paramInt == 3)
      {
        j = 8;
        i = 1;
      }
      else
      {
        i = 2;
      }
    }
  }
  
  public int a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    QLog.w(TAG, 1, "avideo acceptRequest, peerUin[" + paramString + "], businessType[" + paramInt1 + "], relationType[" + paramInt2 + "], uiMode[" + this.alx + "], seq[" + paramLong + "]");
    if ((sB()) && (this.alx != 3) && (!paramString.equals(b().peerUin)))
    {
      QLog.d(TAG, 1, "acceptRequest fail,is nearby");
      return -1;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QLog.d(TAG, 1, "acceptRequest fail,network not support");
      return -2;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      QLog.d(TAG, 1, "acceptRequest fail,mVcCtrl is null");
      return -1;
    }
    iiv localiiv = a(paramInt2, paramString);
    if (localiiv == null) {
      localiiv = b();
    }
    for (;;)
    {
      hM(false);
      if ((localiiv.uinType == 1011) || (localiiv.uinType == 21)) {
        v(paramLong, 15000L);
      }
      this.mApp.amM();
      if (paramInt1 == 0) {
        paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.acceptVideo(paramString, 0L, getApn(), 0, paramInt2);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "acceptRequest, result[" + paramInt1 + "], peerUin[" + paramString + "], relationType[" + paramInt2 + "], session[" + localiiv + "]");
        }
        if (paramInt1 == 0)
        {
          localiiv.Y("acceptRequest", 3);
          alC();
        }
        if (this.jdField_a_of_type_Imj != null) {
          tar.a(null, "Usr_TV_Video", 4, 0, 0);
        }
        ((ikr)this.mApp.a(4)).d(b().getRoomId(), 9, 1L);
        ikp.kQ(37);
        return paramInt1;
        if (1 == paramInt1) {
          paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.acceptVideo(paramString, 0L, getApn(), 2, paramInt2);
        } else {
          paramInt1 = -1;
        }
      }
    }
  }
  
  public int a(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte, String paramString7, String paramString8, int paramInt4, int paramInt5, String paramString9, String paramString10)
  {
    String str = TAG;
    Object localObject = new StringBuilder().append("avideo request, selfUin[").append(this.mApp.getCurrentAccountUin()).append("], peerUin[").append(paramString1).append("], businessType[").append(paramInt1).append("], relationType[").append(paramInt2).append("], fromNation[").append(paramString2).append("], fromMobile[").append(paramString3).append("], toMobile[").append(paramString4).append("], uinType[").append(paramInt3).append("], extraUin[").append(paramString5).append("], sig[");
    if (paramArrayOfByte != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "], bindID[" + paramString8 + "], bindType[" + paramInt4 + "], subServiceType[" + paramInt5 + "], mStartRing[" + this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable + "], seq[" + paramLong + "]");
      AudioHelper.G(this.mApp);
      if (paramArrayOfByte != null) {
        QLog.d(TAG, 2, "request sigLength: " + paramArrayOfByte.length);
      }
      if (aqiw.isNetSupport(BaseApplication.getContext())) {
        break;
      }
      QLog.e(TAG, 1, "request fail, network not support!");
      return -2;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      QLog.e(TAG, 1, "request fail,controller is null!");
      return -1;
    }
    str = paramString1;
    if (paramInt3 == 1006)
    {
      str = paramString1;
      if (paramString1.startsWith("+")) {
        str = paramString1.substring(1);
      }
    }
    int j = a(paramInt3, true, 1);
    if (j == -1)
    {
      QLog.e(TAG, 1, "request fail, accostType = " + j);
      return -1;
    }
    paramString1 = b();
    if ((paramString1.tc()) && (paramString1.peerUin != null) && (str.equals(paramString1.peerUin)))
    {
      QLog.e(TAG, 1, "request fail,----already receive invite, return~");
      paramString1.PT = true;
      return -1;
    }
    int i;
    long l1;
    long l2;
    if (paramInt3 == 9500)
    {
      alQ();
      i = -1;
      l1 = 0L;
      if (paramString1.QU)
      {
        l1 = paramString1.ln;
        QLog.w(TAG, 1, "request, startTerminalSwitchTimeOutCheck, oldRoomId[" + l1 + "], seq[" + paramLong + "]");
        alA();
      }
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("fun_call_sp_file", 4).getString("key_fun_call_buff", "");
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "request funcall buffer:" + (String)localObject);
      }
      this.mApp.amM();
      ((ikr)this.mApp.a(4)).d(-1L, 2, 1L);
      ikp.kQ(28);
      ikp.report(11, str);
      ikp.r(12, 1L);
      if (!paramString1.QE) {
        break label1020;
      }
      l2 = 1L;
      label610:
      ikp.r(13, l2);
      ikp.r(15, 1L);
      alv();
      if ((paramString1.uinType != 1011) && (paramString1.uinType != 21)) {
        break label1034;
      }
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "request Anychat Mode ");
      }
      paramString1.QE = true;
      if (Long.valueOf(this.mApp.getCurrentAccountUin()).longValue() <= Long.valueOf(str).longValue()) {
        break label1028;
      }
      i = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, getApn(), 0, 4, paramString2, paramString3, paramString4, 21, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      label738:
      AVReport.a().QE = paramString1.QE;
      QLog.d(TAG, 1, "request result = " + i + ", uinType = " + paramInt3 + ", accostType = " + j);
      if (i == 0)
      {
        paramString1.Y("request", 1);
        paramString1.uinType = paramInt3;
        paramString1.amM = j;
        if ((paramString1.amI != 3) && (paramString1.amI != 4)) {
          paramString1.C(paramLong, SystemClock.elapsedRealtime());
        }
        acV();
        if (!paramString1.QE) {
          break label1437;
        }
      }
    }
    label1028:
    label1034:
    label1437:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      for (;;)
      {
        a(paramString1.sessionId, paramInt1, false, false, true);
        paramString1.amR = -1;
        this.OM = false;
        k(paramLong, paramString1.peerUin);
        alx();
        paramString1.QS = false;
        a(str, 2, paramString1.lg);
        a(str, 1, 0L);
        a("deviceMemory", ikp.getTotalMemory() + "");
        a("manufacturer", Build.MANUFACTURER);
        a("qqVersion", AppSetting.aq(getAppContext()));
        if (this.jdField_a_of_type_Igx != null) {
          this.jdField_a_of_type_Igx.stopMonitor();
        }
        this.jdField_a_of_type_Igx = new igx(this.mApp, str);
        return i;
        this.OH = true;
        break;
        label1020:
        l2 = 2L;
        break label610;
        i = 0;
        break label738;
        if (paramInt3 == 9500)
        {
          paramInt4 = 4200;
          try
          {
            l1 = jji.B(str);
            if (!TextUtils.isEmpty(paramString6)) {
              paramInt4 = Integer.valueOf(paramString6).intValue();
            }
            if (QLog.isColorLevel()) {
              QLog.d("SDVideo", 2, "request smart tv " + paramInt4);
            }
            paramString1.QE = false;
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setApType(getApn());
            i = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestFromUnQQ(l1, paramInt1, paramInt2, paramInt4);
          }
          catch (NumberFormatException paramString1)
          {
            paramString1.printStackTrace();
            QLog.e(TAG, 1, "request fail,NumberFormatException ", paramString1);
            return -1;
          }
        }
      }
      if (paramInt1 == 0)
      {
        paramString1.QE = true;
        if ((paramString10 != null) && (!TextUtils.isEmpty(paramString10)))
        {
          paramString10 = igh.a(paramString10);
          if (paramString10 != null) {
            QLog.e(TAG, 2, "requestVideo new number");
          }
          for (paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, getApn(), paramInt1, paramInt2, paramString2, paramString3, paramString4, j, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9, paramString10);; paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, getApn(), paramInt1, paramInt2, paramString2, paramString3, paramString4, j, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9))
          {
            i = paramInt1;
            break;
            QLog.e(TAG, 2, "requestVideo new number is null");
          }
        }
        i = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, getApn(), paramInt1, paramInt2, paramString2, paramString3, paramString4, j, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9);
        break label738;
      }
      if (1 != paramInt1) {
        break label738;
      }
      paramString1.QE = false;
      i = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, getApn(), paramInt1, paramInt2, paramString2, paramString3, paramString4, j, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      break label738;
    }
  }
  
  public int a(long paramLong1, boolean paramBoolean, List<NetAddr> paramList, long paramLong2)
  {
    NetAddr[] arrayOfNetAddr = null;
    if (paramList != null) {
      arrayOfNetAddr = (NetAddr[])paramList.toArray(new NetAddr[paramList.size()]);
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendRecordingRequest(paramLong1, paramBoolean, arrayOfNetAddr, paramLong2);
  }
  
  public int a(iiv paramiiv, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomUserTerminalType(paramiiv, paramString);
    }
    return -1;
  }
  
  int a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(AudioHelper.hG(), paramString, paramBoolean1, paramBoolean2, 0);
  }
  
  public long a(int paramInt1, int paramInt2, long paramLong)
  {
    qav_gvideo_sdk_transfer.RespInfo localRespInfo = a(paramInt1, paramInt2, paramLong);
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "getGAudioRoomId, result[" + localRespInfo.uint32_result.get() + "], uint64_roomId[" + localRespInfo.gAudioInfo.uint64_roomId.get() + "]");
    }
    return localRespInfo.gAudioInfo.uint64_roomId.get();
  }
  
  public long a(iiv paramiiv)
  {
    if (paramiiv == null) {
      return 0L;
    }
    long l = paramiiv.getRoomId();
    switch (paramiiv.amI)
    {
    default: 
      return l;
    }
    return getChatRoomId(paramiiv.peerUin);
  }
  
  public Bitmap a(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1004;
    int i;
    if (this.mApp.isFriend(paramString1)) {
      i = 0;
    }
    for (;;)
    {
      return this.mApp.a(i, paramString1, paramString2, paramBoolean2, paramBoolean1);
      if (paramInt == 1)
      {
        i = 1000;
      }
      else
      {
        i = j;
        if (paramInt == 2) {
          i = j;
        }
      }
    }
  }
  
  public b a(String paramString)
  {
    ArrayList localArrayList = this.hZ;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.hZ.size())
        {
          b localb = (b)this.hZ.get(i);
          if ((localb == null) || (localb.uin != Long.valueOf(paramString).longValue())) {
            break label74;
          }
          paramString = localb;
          return paramString;
        }
      }
      finally {}
      paramString = null;
      continue;
      label74:
      i += 1;
    }
  }
  
  public VideoController a(String paramString1, String paramString2)
  {
    return a(null, paramString1, paramString2);
  }
  
  public VideoController a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "updateProcessInfo peerUin = " + paramString1 + ",key = " + paramString2 + ",value = " + paramString3 + ", isAllSessionIdle = " + this.jdField_b_of_type_Igv.sl());
    }
    long l2 = 0L;
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && (!this.jdField_b_of_type_Igv.sl()))
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateProcessInfo(l1, paramString2, paramString3);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "QuaReport --> updateProcessInfo peerUin = " + l1 + ",key = " + paramString2 + ",value = " + paramString3);
        }
      }
      return this;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e(TAG, 2, Log.getStackTraceString(paramString1));
        l1 = l2;
      }
    }
  }
  
  public VideoAppInterface a()
  {
    return this.mApp;
  }
  
  public AVPhoneUserInfo a(long paramLong, ArrayList<AVPhoneUserInfo> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.next();
      if (paramLong == localAVPhoneUserInfo.account) {
        return localAVPhoneUserInfo;
      }
    }
    return null;
  }
  
  public QQGAudioCtrl a()
  {
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
  }
  
  public qav_gvideo_sdk_transfer.RespInfo a(int paramInt, byte[] paramArrayOfByte)
  {
    qav_gvideo_sdk_transfer.RespInfo localRespInfo = new qav_gvideo_sdk_transfer.RespInfo();
    i = -101;
    int j = i;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      try
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.postData(paramInt, paramArrayOfByte);
        j = i;
      }
      catch (Throwable paramArrayOfByte)
      {
        try
        {
          localRespInfo.mergeFrom(paramArrayOfByte);
          return localRespInfo;
        }
        catch (Throwable paramArrayOfByte)
        {
          for (;;)
          {
            i = -102;
          }
        }
        paramArrayOfByte = paramArrayOfByte;
      }
      if (QLog.isDevelopLevel())
      {
        QLog.w(TAG, 1, "postData exception , event[" + paramInt + "]", paramArrayOfByte);
        j = i;
      }
    }
    localRespInfo.uint32_result.set(j);
    return localRespInfo;
  }
  
  public ScreenShareCtrl a()
  {
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl == null) {
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl = new ScreenShareCtrl(this);
    }
    return this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl;
  }
  
  public AVPbInfo a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "processQCallPush in VideoController");
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
    {
      AVPbInfo localAVPbInfo = new AVPbInfo();
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.processQCallPush(paramArrayOfByte, localAVPbInfo);
      if ((localAVPbInfo != null) && (QLog.isColorLevel())) {
        QLog.d(TAG, 2, "processQCallPush result, bindId:" + localAVPbInfo.bindId + ", bindIdType:" + localAVPbInfo.bindIdType + ", phoneNum:" + localAVPbInfo.phoneNum);
      }
      return localAVPbInfo;
    }
    return null;
  }
  
  public imb a()
  {
    return this.jdField_a_of_type_Imb;
  }
  
  public iow a(Context arg1)
  {
    if (!iow.uW()) {
      return null;
    }
    if ((this.jdField_a_of_type_Iow == null) && (??? != null)) {}
    synchronized (this.ah)
    {
      if (this.jdField_a_of_type_Iow == null)
      {
        this.jdField_a_of_type_Iow = new iow(this.mApp, null);
        this.jdField_a_of_type_Iow.init();
      }
      return this.jdField_a_of_type_Iow;
    }
  }
  
  public ArrayList<b> a(int paramInt, ArrayList<b> paramArrayList)
  {
    long l1 = System.currentTimeMillis();
    if (paramInt > 8) {}
    ArrayList localArrayList1;
    long l2;
    for (int i = 1;; i = 0)
    {
      localArrayList1 = new ArrayList(8);
      l2 = this.mApp.getLongAccountUin();
      localObject2 = null;
      localObject1 = null;
      if (i != 0) {
        break;
      }
      j = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (j >= paramArrayList.size()) {
          break;
        }
        localObject2 = localObject1;
        if (j >= 8) {
          break;
        }
        localObject2 = (b)paramArrayList.get(j);
        if (((b)localObject2).uin == l2) {
          localObject1 = localObject2;
        }
        localArrayList1.add(localObject2);
        j += 1;
      }
    }
    int j = 0;
    Object localObject1 = localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (j >= paramInt) {
        break;
      }
      localObject2 = (b)paramArrayList.get(j);
      if (((b)localObject2).uin == l2) {
        localObject1 = localObject2;
      }
      localArrayList1.add(localObject2);
      j += 1;
    }
    localObject1 = new ArrayList();
    if (localObject2 != null) {
      ((ArrayList)localObject1).add(localObject2);
    }
    Object localObject2 = new ArrayList();
    j = 0;
    if (j < paramInt)
    {
      long l3 = ((b)localArrayList1.get(j)).uin;
      if (l3 == l2) {}
      for (;;)
      {
        j += 1;
        break;
        if (this.mApp.isFriend(String.valueOf(l3))) {
          ((ArrayList)localObject1).add(localArrayList1.get(j));
        } else {
          ((ArrayList)localObject2).add(localArrayList1.get(j));
        }
      }
    }
    if (!((ArrayList)localObject2).isEmpty())
    {
      Collections.sort((List)localObject2, new ihd(this));
      ((ArrayList)localObject1).addAll((Collection)localObject2);
    }
    if (i != 0)
    {
      while (paramInt < paramArrayList.size())
      {
        ((ArrayList)localObject1).add(paramArrayList.get(paramInt));
        paramInt += 1;
      }
      QLog.d(TAG, 1, "InviteMemberList listSort exceedMaxNumber cost" + (System.currentTimeMillis() - l1));
      return localObject1;
    }
    localObject2 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramInt < localArrayList1.size())
    {
      l2 = ((b)localArrayList1.get(paramInt)).uin;
      if (this.mApp.isFriend(String.valueOf(l2))) {
        ((ArrayList)localObject2).add(localArrayList1.get(paramInt));
      }
      for (;;)
      {
        paramInt += 1;
        break;
        localArrayList2.add(localArrayList1.get(paramInt));
      }
    }
    if (!localArrayList2.isEmpty())
    {
      Collections.sort(localArrayList2, new ihe(this));
      ((ArrayList)localObject2).addAll(localArrayList2);
    }
    if (!((ArrayList)localObject2).isEmpty()) {
      ((ArrayList)localObject1).addAll((Collection)localObject2);
    }
    if (paramArrayList.size() > 8)
    {
      paramInt = 8;
      while (paramInt < paramArrayList.size())
      {
        ((ArrayList)localObject1).add(paramArrayList.get(paramInt));
        paramInt += 1;
      }
    }
    QLog.d(TAG, 1, "InviteMemberList listSort not exceedMaxNumber cost" + (System.currentTimeMillis() - l1));
    return localObject1;
  }
  
  public ArrayList<Long> a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    for (;;)
    {
      int i;
      b localb;
      synchronized (this.hZ)
      {
        int j = this.hZ.size();
        ArrayList localArrayList2 = new ArrayList();
        long l = System.currentTimeMillis();
        i = 0;
        if (i >= j) {
          break label152;
        }
        localb = (b)this.hZ.get(i);
        if (localb == null) {
          break label158;
        }
        if (localb.uin == paramLong1)
        {
          if (!localb.Pk)
          {
            localb.Pm = paramBoolean;
            localb.kW = l;
            localb.kX = paramLong2;
          }
        }
        else
        {
          if (!localb.Pm) {
            break label158;
          }
          localArrayList2.add(Long.valueOf(localb.uin));
        }
      }
      if (localb.Pm)
      {
        localb.Pm = false;
        continue;
        label152:
        return localArrayList;
        label158:
        i += 1;
      }
    }
  }
  
  @TargetApi(21)
  public jds a()
  {
    if (this.jdField_a_of_type_Jds == null) {
      this.jdField_a_of_type_Jds = new jds();
    }
    return this.jdField_a_of_type_Jds;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl != null) {
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl.a(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "onVideoSrcChange, videoSrcType[" + paramInt1 + "], relationType[" + paramInt2 + "], userUin[" + paramLong1 + "], groupUin[" + paramLong2 + "], seq[" + l + "]");
    }
    Object localObject = a(String.valueOf(paramLong1));
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "onVideoSrcChange-->can not find the user");
      }
      return;
    }
    int i = 0;
    int k;
    int j;
    if (i < b().jdField_if.size()) {
      if (((ioa)b().jdField_if.get(i)).uin == paramLong1)
      {
        k = ((ioa)b().jdField_if.get(i)).videoSrcType;
        j = i;
      }
    }
    for (i = k;; i = 1)
    {
      if (paramInt1 == 4)
      {
        if (j == -1) {
          break label564;
        }
        a(paramLong1, b().jdField_if, b().ig, 0, true);
        alN();
        this.mApp.l(new Object[] { Integer.valueOf(70), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i), Long.valueOf(l) });
      }
      label562:
      label564:
      for (i = 0;; i = 1)
      {
        this.mApp.l(new Object[] { Integer.valueOf(73), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(l) });
        for (;;)
        {
          if (i == 0) {
            break label562;
          }
          this.mApp.l(new Object[] { Integer.valueOf(87), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          return;
          i += 1;
          break;
          if (paramInt1 != 0)
          {
            i = b().b(paramLong1, 0);
            if (i == -1)
            {
              a(paramLong1, true, paramInt2, 5L);
              a((b)localObject, paramInt1);
              i = b().b(paramLong1, 0);
            }
            for (((ioa)b().jdField_if.get(i)).videoSrcType = paramInt1;; ((ioa)localObject).videoSrcType = paramInt1)
            {
              i = 1;
              break;
              localObject = (ioa)b().jdField_if.get(i);
              ioa localioa = new ioa();
              localioa.uin = ((ioa)localObject).uin;
              localioa.videoSrcType = ((ioa)localObject).videoSrcType;
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localioa);
              this.mApp.l(new Object[] { Integer.valueOf(104), localArrayList });
            }
          }
          i = 0;
        }
        break;
      }
      j = -1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (this.mApp != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.StartDoubleVideoMeeting");
      localIntent.putExtra("sessionType", paramInt1);
      localIntent.putExtra("uinType", paramInt2);
      localIntent.putExtra("peerUin", paramString);
      localIntent.putExtra("isReceiver", true);
      localIntent.putExtra("updateTime", paramBoolean1);
      localIntent.putExtra("showTime", paramBoolean2);
      localIntent.setPackage(this.mApp.getApp().getPackageName());
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramLong, paramInt2, paramInt3, 0);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = igv.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      str = igv.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      long l = AudioHelper.hG();
      QLog.w(TAG, 1, "onGAudioSDKError, relationType[" + paramInt1 + "], relationId[" + paramLong + "], reason[" + paramInt2 + "], detail[" + paramInt3 + "], type[" + paramInt4 + "], sessionId[" + str + "], mGAudioInRoom[" + this.OB + "], seq[" + l + "]");
      if (paramLong == 0L) {
        return;
      }
      Object localObject = b();
      if ((localObject != null) && (((iiv)localObject).PY)) {
        this.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
      }
      if ((sw()) && ((paramInt2 == 16) || (paramInt2 == 69) || (paramInt2 == 68) || (paramInt2 == 17) || (paramInt2 == 71) || (paramInt2 == 70)))
      {
        if (this.OB) {
          b(paramInt1, paramLong, 70);
        }
        hP("onGAudioSDKError_1");
        if ((-19 == paramInt3) || (19 == paramInt3))
        {
          this.mApp.getHandler().removeCallbacks(this.mTimeOutRunnable);
          this.mTimeOutRunnable = null;
        }
        this.mApp.l(new Object[] { Integer.valueOf(200), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        return;
      }
      int i = jll.cM(paramInt1);
      a(b().sessionId, i, paramInt2, false, String.valueOf(paramLong), String.valueOf(paramInt3), false);
      if (this.OB) {
        b(paramInt1, paramLong, 71);
      }
      for (;;)
      {
        hP("onGAudioSDKError_2");
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.ee(l);
        }
        this.mApp.l(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
        this.jdField_b_of_type_Igv.c(l, str);
        return;
        localObject = this.mApp.getCurrentAccountUin();
        a("onGAudioSDKError", str, i, (String)localObject, String.valueOf(paramLong), 7, (String)localObject, false, false);
        if (this.mTimeOutRunnable != null)
        {
          this.mApp.getHandler().removeCallbacks(this.mTimeOutRunnable);
          this.mTimeOutRunnable = null;
        }
      }
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l1 = AudioHelper.hG();
    iiv localiiv = b();
    String str;
    if (paramInt2 == 3)
    {
      str = igv.a(100, String.valueOf(paramLong2), new int[0]);
      boolean bool = TextUtils.equals(localiiv.sessionId, str);
      if ((!bool) || (QLog.isDevelopLevel())) {
        QLog.w(TAG, 1, "onGaGoOnStageResult, result[" + paramInt1 + "], info[" + paramLong1 + "], groupId[" + paramLong2 + "], relationType[" + paramInt2 + "], main[" + localiiv.sessionId + "], seq[" + l1 + "]");
      }
      if (bool) {
        break label169;
      }
    }
    label169:
    while (this.mApp == null)
    {
      return;
      str = igv.a(paramInt2, String.valueOf(paramLong2), new int[0]);
      break;
    }
    if (paramInt1 == 90) {
      if (paramLong1 == 3L) {
        b().a(l1, "onGaGoOnStageResult.1", true, false);
      }
    }
    for (;;)
    {
      long l2 = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
      this.mApp.l(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l1) });
      return;
      b().a(l1, "onGaGoOnStageResult.2", false, false);
      this.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      continue;
      b().a(l1, "onGaGoOnStageResult.3", false, false);
      this.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4)
  {
    this.mApp.l(new Object[] { Integer.valueOf(502), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong3), Long.valueOf(paramLong4) });
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
  {
    this.mApp.l(new Object[] { Integer.valueOf(500), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(paramLong3), Long.valueOf(paramLong4) });
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = AudioHelper.hG();
    igd.aH("VideoNodeManager", "-->VideoController onGAudioInvite()**************************");
    VideoAppInterface localVideoAppInterface = this.mApp;
    AudioHelper.G(this.mApp);
    setAudioOpt(false);
    Object localObject1 = b();
    long l2 = getChatRoomId(String.valueOf(paramLong2));
    long l3 = bw();
    Object localObject2;
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject2 = TAG;
      localObject3 = new StringBuilder().append("onGAudioInvite, friendUin[").append(paramLong2).append("], groupId[").append(paramLong1).append("], multiSubType[").append(paramInt3).append("], multiAVType[").append(paramInt2).append("], relationType[").append(paramInt1).append("], mGAudioInRoom[").append(this.OB).append("], mGAudioGroupId[").append(this.kJ).append("], mCurrentInviteId[").append(this.kM).append("], mCurrentInviteRelationType[").append(this.alF).append("], offLineInvite[").append(paramBoolean).append("], roomId[").append(l2).append("], gRoomId[").append(l3).append("], seq[").append(l1).append("], main[").append(localObject1).append("], app[");
      if (localVideoAppInterface != null)
      {
        paramBoolean = true;
        QLog.w((String)localObject2, 2, paramBoolean + "], original[" + paramInt4 + "]");
      }
    }
    else
    {
      if (localVideoAppInterface != null) {
        break label294;
      }
    }
    label294:
    boolean bool;
    label803:
    do
    {
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      if ((paramInt3 == 6) || (paramInt3 == 5) || (paramInt3 == 4) || (paramInt3 == 3)) {
        paramBoolean = true;
      }
      if (!aqji.a(this.mApp, paramLong1, paramBoolean))
      {
        QLog.w(TAG, 1, "onGAudioInvite, forceDisableInviteBox");
        return;
      }
      localObject3 = igv.a(paramInt1, String.valueOf(paramLong1), new int[0]);
      if (this.jdField_b_of_type_Igv.ci((String)localObject3))
      {
        QLog.d(TAG, 1, "onGAudioInvite, Session already exists");
        return;
      }
      localObject2 = this.jdField_b_of_type_Igv.a((String)localObject3, false);
      ((iiv)localObject2).ll = paramLong1;
      ((iiv)localObject2).relationType = paramInt1;
      ((iiv)localObject2).anb = paramInt2;
      ((iiv)localObject2).QT = false;
      ((iiv)localObject2).f = paramArrayOfLong;
      ((iiv)localObject2).any = paramInt4;
      if (this.jdField_b_of_type_Igv.kv() >= 2)
      {
        a(l1, "too_much_session", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      VideoConstants.Ow = localVideoAppInterface.sL();
      paramBoolean = false;
      if (!((iiv)localObject1).sY()) {
        paramBoolean = true;
      }
      for (;;)
      {
        if (this.bc != null)
        {
          if (localVideoAppInterface.getHandler() != null) {
            localVideoAppInterface.getHandler().removeCallbacks(this.bc);
          }
          this.bc = null;
          ((iiv)localObject2).Y("onGAudioInvite.1", 0);
        }
        alv();
        bool = isScreenLocked(localVideoAppInterface.getApp().getApplicationContext());
        if (!bool) {
          break label803;
        }
        if ((((iiv)localObject1).state <= 0) || (((iiv)localObject1).state > 4) || (paramInt3 == 3)) {
          break;
        }
        a(l1, "ScreenLocked_before_connect", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
        if (localVideoAppInterface.sN()) {
          paramBoolean = true;
        }
      }
      if (7 == ((iiv)localObject1).state)
      {
        a(l1, "ScreenLocked_group_invite", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((this.OB) && (this.kJ == paramLong1))
      {
        a(l1, "ScreenLocked_group_in_room", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((((iiv)localObject1).state == 14) || (((iiv)localObject1).state == 13))
      {
        a(l1, "ScreenLocked_double_meeting", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((((iiv)localObject1).jdField_a_of_type_Iiv$a.anA > 0) && (((iiv)localObject1).jdField_a_of_type_Iiv$a.chatType == 1))
      {
        a(l1, "ScreenLocked_in_random", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((paramBoolean) && (paramInt3 != 3))
      {
        a(l1, "ScreenLocked_session_exist", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w(TAG, 1, "onGAudioInvite, matchStatus[" + ((iiv)localObject1).jdField_a_of_type_Iiv$a.anA + "], chatType[" + ((iiv)localObject1).jdField_a_of_type_Iiv$a.chatType + "], aSessionExists[" + paramBoolean + "], isScreenLocked[" + bool + "], \nmainSession[" + localObject1 + "], \nsessionInfo[" + localObject2 + "]");
      }
      if (((iiv)localObject2).amI == 0)
      {
        ((iiv)localObject2).PT = true;
        ((iiv)localObject2).e(l1, "onGAudioInvite.1", 3);
        ((iiv)localObject2).uinType = jll.cM(paramInt1);
        ((iiv)localObject2).peerUin = String.valueOf(paramLong2);
        if (paramInt1 == 2) {
          ((iiv)localObject2).senderUin = String.valueOf(paramLong2);
        }
        ((iiv)localObject2).PT = true;
        if ((paramInt3 != 3) && (paramInt3 != 4)) {
          a((String)localObject3, ((iiv)localObject2).amI, false, false, false);
        }
      }
      this.kM = paramLong1;
      this.alF = paramInt1;
      if (((iiv)localObject2).state == 0) {
        ((iiv)localObject2).Y("onGAudioInvite", 7);
      }
      bool = false;
      if ((paramInt3 != 3) || (((iiv)localObject1).ll != 0L)) {
        break label1382;
      }
      bool = b((iiv)localObject1, (iiv)localObject2, l1, paramLong2, (String)localObject3, paramInt1, paramLong1, paramArrayOfLong);
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "onGAudioInvite multiSubType[" + paramInt3 + "], hasDeal[" + bool + "]");
      }
    } while (bool);
    if ((localVideoAppInterface != null) && (localVideoAppInterface.sM()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onGAudioInvite, phone is calling");
      }
      paramArrayOfLong = new Intent();
      paramArrayOfLong.setAction("tencent.video.v2q.CallingDialogMulti");
      paramArrayOfLong.setPackage(localVideoAppInterface.getApp().getPackageName());
      paramArrayOfLong.putExtra("friendUin", paramLong2);
      paramArrayOfLong.putExtra("sessionType", 3);
      if (paramInt1 == 1) {
        paramArrayOfLong.putExtra("uinType", 1);
      }
      for (;;)
      {
        paramArrayOfLong.putExtra("relationType", paramInt1);
        paramArrayOfLong.putExtra("extraUin", ((iiv)localObject1).MP);
        paramArrayOfLong.putExtra("relationId", paramLong1);
        paramArrayOfLong.putExtra("type", 13);
        paramArrayOfLong.putExtra("senderUin", localVideoAppInterface.getCurrentAccountUin());
        paramArrayOfLong.putExtra("isSender", false);
        paramArrayOfLong.putExtra("peerUin", localVideoAppInterface.getCurrentAccountUin());
        paramArrayOfLong.putExtra("realSenderUin", ((iiv)localObject1).senderUin);
        localVideoAppInterface.getApp().sendBroadcast(paramArrayOfLong);
        a(l1, this.alF, paramLong1, true);
        new atan(this.appContext, null).a(l1, 0, 2131230750, null, null, false, 1, false, true, 0);
        this.jdField_b_of_type_Igv.c(l1, (String)localObject3);
        return;
        label1382:
        if (paramInt3 != 4) {
          break;
        }
        bool = a((iiv)localObject1, (iiv)localObject2, l1, paramLong2, (String)localObject3, paramInt1, paramLong1, paramArrayOfLong);
        break;
        if (paramInt1 == 2) {
          paramArrayOfLong.putExtra("uinType", 3000);
        }
      }
    }
    ((iiv)localObject1).senderUin = ("" + paramLong2);
    this.OW = isGameMode();
    if (((iiv)localObject2).a(localVideoAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "onGAudioInvite msg blocked [" + ((iiv)localObject2).sessionId + "]");
      }
      if (!localVideoAppInterface.RA) {
        break label1810;
      }
      localVideoAppInterface.RA = false;
    }
    for (;;)
    {
      localVideoAppInterface.RB = true;
      return;
      if ((paramBoolean) || (ihq.sH()))
      {
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        aqji.c.eea();
      }
      for (;;)
      {
        BaseGaInvite.a((Intent)localObject1, "onGAudioInvite");
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).putExtra("uinType", jll.cM(paramInt1));
        ((Intent)localObject1).putExtra("peerUin", String.valueOf(paramLong2));
        ((Intent)localObject1).putExtra("friendUin", paramLong2);
        ((Intent)localObject1).putExtra("relationType", paramInt1);
        ((Intent)localObject1).putExtra("MultiAVType", paramInt2);
        ((Intent)localObject1).putExtra("discussId", paramLong1);
        ((Intent)localObject1).putExtra("memberList", paramArrayOfLong);
        ((Intent)localObject1).putExtra("session_id", ((iiv)localObject2).sessionId);
        if ((!this.OW) || (!ivv.ae(localVideoAppInterface.getApplication().getApplicationContext()))) {
          break label1801;
        }
        if ((!paramBoolean) && (!ihq.sH())) {
          break label1769;
        }
        paramArrayOfLong = new izr(this, localVideoAppInterface, (Intent)localObject1);
        paramArrayOfLong.onCreate();
        paramArrayOfLong.b((Intent)localObject1);
        break;
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), GaInviteLockActivity.class);
      }
      label1769:
      paramArrayOfLong = new jeu(this, localVideoAppInterface, (Intent)localObject1);
      paramArrayOfLong.onCreate();
      paramArrayOfLong.a(l1, (Intent)localObject1);
      break;
      label1801:
      aA((Intent)localObject1);
      break;
      label1810:
      ikp.ant();
    }
  }
  
  public void a(int paramInt, long paramLong, itn paramitn)
  {
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl != null) {
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl.a(paramInt, paramLong, paramitn);
    }
  }
  
  public void a(int paramInt, long paramLong, int... paramVarArgs)
  {
    paramVarArgs = igv.a(paramInt, String.valueOf(paramLong), new int[0]);
    if ((!this.jdField_b_of_type_Igv.ci(paramVarArgs)) && (paramInt == 3)) {
      paramVarArgs = igv.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      iiv localiiv = this.jdField_b_of_type_Igv.c(paramVarArgs);
      long l = AudioHelper.hG();
      if (QLog.isColorLevel()) {
        QLog.w(TAG, 1, "onGAudioTerminalEnterRoom begin, sessionId[" + paramVarArgs + "], seq[" + l + "], \nsession[" + localiiv + "]");
      }
      int i;
      if ((localiiv != null) && ((localiiv.state == 7) || (localiiv.state == 2)))
      {
        localiiv.Y("onGAudioTerminalEnterRoom", 0);
        this.mApp.l(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(1) });
        if (this.jdField_b_of_type_Igv.ci(paramVarArgs))
        {
          localiiv = this.jdField_b_of_type_Igv.c(paramVarArgs);
          i = jll.cM(paramInt);
          if (paramInt != 3) {
            break label255;
          }
          a(localiiv.sessionId, i, 7, true, String.valueOf(paramLong), null, false);
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Igv.c(l, paramVarArgs);
        return;
        label255:
        if ((paramInt == 2) || (paramInt == 1)) {
          a("ignoreGAudioChat_4", paramVarArgs, i, this.mApp.getCurrentAccountUin(), String.valueOf(paramLong), 4, localiiv.senderUin, true, false);
        }
      }
    }
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if (this.mApp != null)
    {
      QLog.d(TAG, 1, "sendAnotherChatingBroadcast session:" + paramInt2 + ", peerUin:" + paramString + "， roomid：" + paramLong);
      if (paramInt2 != 3) {
        break label268;
      }
    }
    for (;;)
    {
      Object localObject1 = this.jdField_b_of_type_Igv;
      localObject1 = this.jdField_b_of_type_Igv;
      localObject1 = igv.a(igv.cn(paramInt1), paramString, new int[0]);
      Object localObject2 = this.jdField_b_of_type_Igv.c((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = b();
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.av.v2q.AnotherTerChating");
      ((Intent)localObject2).putExtra("sessionType", paramInt2);
      if ((((iiv)localObject1).amK == paramInt2) && (paramString.equalsIgnoreCase(((iiv)localObject1).peerUin)) && (((iiv)localObject1).PT)) {
        ((Intent)localObject2).putExtra("isReceiver", true);
      }
      ((Intent)localObject2).putExtra("uinType", paramInt1);
      ((Intent)localObject2).putExtra("peerUin", paramString);
      ((Intent)localObject2).putExtra("bindType", ((iiv)localObject1).bindType);
      ((Intent)localObject2).putExtra("bindId", ((iiv)localObject1).MX);
      ((Intent)localObject2).putExtra("roomId", paramLong);
      ((Intent)localObject2).setPackage(this.mApp.getApp().getPackageName());
      this.mApp.getApp().sendBroadcast((Intent)localObject2);
      return;
      label268:
      if (paramInt2 != 4) {}
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "sendReplyMsgToAio uinType: " + paramInt + ", friendUin: " + paramString1 + ", friendName: " + paramString2 + ", extraUin: " + paramString3 + ", replyMsg: " + paramString4 + ", isDiyMsg: " + paramBoolean);
    }
    if (this.mApp != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.replyMsg");
      localIntent.putExtra("uinType", paramInt);
      localIntent.putExtra("friendUin", paramString1);
      localIntent.putExtra("friendName", paramString2);
      paramString2 = paramString3;
      if (paramInt == 1006)
      {
        paramString2 = paramString3;
        if (paramString3 == null) {
          paramString2 = paramString1;
        }
      }
      localIntent.putExtra("extraUin", paramString2);
      localIntent.putExtra("replyMsg", paramString4);
      localIntent.putExtra("isDiyMsg", paramBoolean);
      localIntent.setPackage(this.mApp.getApp().getPackageName());
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  void a(int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "sendMsgSigBroadcast uinType: " + paramInt + ", peerUin: " + paramString1 + ", extraUin: " + paramString2 + ", sig = " + paramArrayOfByte);
    }
    if (this.mApp != null)
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.mApp.getApp().getPackageName());
      localIntent.setAction("tencent.video.v2q.AddMsgSig");
      localIntent.putExtra("uinType", paramInt);
      localIntent.putExtra("peerUin", paramString1);
      localIntent.putExtra("extraUin", paramString2);
      localIntent.putExtra("sig", paramArrayOfByte);
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3)
  {
    boolean bool3 = cn(paramString1);
    long l2 = AudioHelper.hG();
    String str = TAG;
    Object localObject = new StringBuilder().append("avideo onRequestVideo, uinType[").append(paramInt1).append("], fromUin[").append(paramString1).append("], extraUin[").append(paramString2).append("], sig[");
    if (paramArrayOfByte != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.w(str, 1, bool1 + "], onlyAudio[" + paramBoolean + "], bindID[" + paramString3 + "], bindType[" + paramInt2 + "], isOfflineSession[" + bool3 + "], seq[" + l2 + "]");
      if ((this.mApp != null) && (this.mApp.getApp() != null)) {
        break;
      }
      return;
    }
    amb();
    alv();
    VideoConstants.Ow = this.mApp.sL();
    AudioHelper.G(this.mApp);
    int j = jkq.a(this.mApp, paramInt1, paramString1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onRequestVideo converted uinType = " + j + ",sdkAVAccostType = " + paramInt1 + "|" + VideoConstants.Ow + ", isVideoPaused: " + this.mApp.isBackground_Pause);
    }
    localObject = b();
    if (this.jdField_b_of_type_Igv.kv() >= 2)
    {
      QLog.w(TAG, 1, "onRequestVideo->pending session exists");
      i = -1;
      str = null;
      if (localObject != null)
      {
        i = ((iiv)localObject).uinType;
        str = ((iiv)localObject).peerUin;
      }
      if ((j == 1011) && (i == 1011) && (str != null) && (str.equals(paramString1))) {
        QLog.w(TAG, 1, "onRequestVideo->pending session exists, equals to the current one.");
      }
    }
    else
    {
      str = igv.a(3, paramString1, new int[0]);
      if ((!TextUtils.equals(str, ((iiv)localObject).sessionId)) || (!((iiv)localObject).PS)) {
        break label499;
      }
      ((iiv)localObject).PT = true;
      paramInt1 = 1;
      if (((iiv)localObject).QE) {
        paramInt1 = 0;
      }
      QLog.w(TAG, 1, "onRequestVideo, autoAcceptChat, seq[" + l2 + "]");
      a(l2, paramString1, paramInt1, ((iiv)localObject).relationType);
      return;
    }
    QLog.d(TAG, 1, "onRequestVideo->pending session exists, just reject.");
    a(l2, false, j, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
    return;
    label499:
    boolean bool2 = false;
    boolean bool4 = isScreenLocked(this.mApp.getApp().getApplicationContext());
    QLog.w(TAG, 1, "onRequestVideo->isScreenLocked:" + bool4);
    if ((j != 21) && (j != 1011) && ((((iiv)localObject).jdField_a_of_type_Iiv$a.anA > 0) || (this.OD)) && (((iiv)localObject).jdField_a_of_type_Iiv$a.chatType == 1))
    {
      QLog.w(TAG, 1, "onRequestVideo when in Random Double");
      if (bool4)
      {
        a(l2, false, j, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
        return;
      }
      bool2 = true;
      bool1 = bool2;
      if (!this.OD)
      {
        v(l2, 30000L);
        bool1 = bool2;
      }
      label650:
      this.jdField_b_of_type_Igv.a(str, false);
      localObject = this.jdField_b_of_type_Igv.c(str);
      ((iiv)localObject).bindType = paramInt2;
      ((iiv)localObject).MX = paramString3;
      ((iiv)localObject).signature = paramArrayOfByte;
      ((iiv)localObject).extraType = j;
      if (this.bc != null)
      {
        this.mApp.getHandler().removeCallbacks(this.bc);
        this.bc = null;
        ((iiv)localObject).Y("onRequestVideo.1", 0);
      }
      if (this.jdField_a_of_type_Imj == null) {
        break label1931;
      }
    }
    label770:
    label1931:
    for (int i = 9500;; i = j)
    {
      this.Ox = true;
      ((iiv)localObject).QE = paramBoolean;
      label889:
      long l3;
      if (paramBoolean)
      {
        ((iiv)localObject).amK = 1;
        l1 = getChatRoomId(paramString1);
        QLog.w(TAG, 1, "onRequestVideo  ,roomId = " + l1);
        ((iiv)localObject).bP(l1);
        ((iiv)localObject).uinType = i;
        ((iiv)localObject).amM = paramInt1;
        ((iiv)localObject).peerUin = paramString1;
        ((iiv)localObject).MP = paramString2;
        ((iiv)localObject).PT = true;
        ((iiv)localObject).Y("onRequestVideo.2", 2);
        ((iiv)localObject).ama = paramInt3;
        a(i, paramString1, paramString2, paramArrayOfByte);
        paramArrayOfByte = (ikr)this.mApp.a(4);
        if (!paramBoolean) {
          break label1617;
        }
        paramInt1 = 1;
        paramArrayOfByte.d(l1, 20, paramInt1);
        paramArrayOfByte.d(l1, 6, 1L);
        l3 = getChatRoomId(paramString1);
        ikp.s(l3, 36);
        ikp.d(l3, 9, ((iiv)localObject).getRoomId());
        ikp.e(l3, 11, paramString1);
        ikp.d(l3, 12, 2L);
        if (!((iiv)localObject).QE) {
          break label1622;
        }
      }
      label1617:
      label1622:
      for (long l1 = 1L;; l1 = 2L)
      {
        ikp.d(l3, 13, l1);
        ikp.d(l3, 15, 1L);
        io(paramString1);
        if (!bool3) {
          break label1630;
        }
        ((iiv)localObject).PR = true;
        b(l2, str, i, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
        return;
        if ((((iiv)localObject).jdField_a_of_type_Iiv$a.anA > 0) && (((iiv)localObject).jdField_a_of_type_Iiv$a.chatType == 3))
        {
          QLog.w(TAG, 1, "onRequestVideo when in Random mulit");
          if (bool4)
          {
            a(l2, false, j, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break label650;
        }
        if (((iiv)localObject).sY())
        {
          if (j == -1)
          {
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.ignoreVideo(paramString1, getApn());
            QLog.w(TAG, 1, "closeVideo uinType == -1");
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString1, 0, this);
            paramString1 = this.mApp.a();
            if (paramString1 == null) {
              break;
            }
            paramString1.kA(0);
            return;
          }
          bool1 = bool2;
          if (!this.mApp.sN()) {
            break label650;
          }
          bool1 = true;
          break label650;
        }
        if ((((iiv)localObject).tf()) || (((iiv)localObject).tg()))
        {
          P(((iiv)localObject).peerUin, 2);
          bool1 = bool2;
          break label650;
        }
        if (((((iiv)localObject).state == 7) && (this.kM != 0L)) || (((iiv)localObject).state == 14) || (((iiv)localObject).state == 13))
        {
          if (bool4)
          {
            a(l2, false, j, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break label650;
        }
        if (!this.OB)
        {
          if (((j == 21) || (j == 1011)) && (b().jdField_a_of_type_Iiv$a.nickName != null))
          {
            QLog.w(TAG, 1, "onRequestVideo  auto Accept");
            if ((((iiv)localObject).jdField_a_of_type_Iiv$a.peerUin != null) && (!((iiv)localObject).jdField_a_of_type_Iiv$a.peerUin.equals(paramString1)))
            {
              a(l2, false, j, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
              return;
            }
            v(l2, 30000L);
            bool1 = bool2;
            break label650;
          }
          QLog.w(TAG, 1, "onRequestVideo when chatting: fromUin = " + paramString1 + "|" + bool4);
          bool1 = true;
          if ((((iiv)localObject).peerUin != null) && (paramString1.equals(((iiv)localObject).peerUin)))
          {
            QLog.w(TAG, 1, "onRequestVideo when request: fromUin = " + paramString1);
            amd();
            io(paramString1);
            return;
          }
          if (!bool4) {
            break label650;
          }
          a(l2, false, j, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
          return;
        }
        if ((this.OB) || (((iiv)localObject).state == 8))
        {
          QLog.d(TAG, 1, "onRequestVideo when in group chat, fromUin = " + paramString1);
          if (bool4)
          {
            a(l2, false, j, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break label650;
        }
        bool1 = bool2;
        if (((iiv)localObject).state != 1) {
          break label650;
        }
        bool1 = bool2;
        if (((iiv)localObject).peerUin == null) {
          break label650;
        }
        bool1 = bool2;
        if (!paramString1.equals(((iiv)localObject).peerUin)) {
          break label650;
        }
        return;
        ((iiv)localObject).amK = 2;
        break label770;
        paramInt1 = 2;
        break label889;
      }
      label1630:
      if ((!this.OB) && (((iiv)localObject).uinType != 21) && (((iiv)localObject).uinType != 1011)) {
        a(str, ((iiv)localObject).amK, false, false, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onRequestVideo orientation: " + this.mOrientation + ", isQQPaused: " + VideoConstants.Ow + ", isVideoPaused: " + this.mApp.isBackground_Pause + ", isScreenLocked: " + bool4 + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(getAppContext()));
      }
      if ((this.OI) && (this.mOrientation == 0) && (!bool4) && (VideoConstants.Ow) && (this.mApp.isBackground_Pause))
      {
        this.mApp.getHandler().postDelayed(new VideoController.7(this, l2, str, i, paramString1, paramString2, paramBoolean, bool1, paramInt2), 100L);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "updateProcessInfo INVITEUI_STATE to 0 when onRequestVideo, from = " + paramString1);
      }
      a(paramString1, "inviteUIState", String.valueOf(0));
      if (this.jdField_a_of_type_Igx != null) {
        this.jdField_a_of_type_Igx.stopMonitor();
      }
      this.jdField_a_of_type_Igx = new igx(this.mApp, paramString1);
      a(l2, str, i, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
      return;
    }
  }
  
  public void a(int paramInt, jhb paramjhb)
  {
    QLog.i(TAG, 1, "Record setAudioFrameCallback, type=" + paramInt + ", callback=" + paramjhb);
    if (paramInt >= 2) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfJhb == null) {
      this.jdField_a_of_type_ArrayOfJhb = new jhb[2];
    }
    this.jdField_a_of_type_ArrayOfJhb[paramInt] = paramjhb;
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "onKickOutSuc, groupId[" + paramLong + "], relationType[" + paramInt1 + "], multiAVType[" + paramInt2 + "], errCode[" + paramInt3 + "], strMsg[" + paramString + "]");
    }
    this.mApp.l(new Object[] { Integer.valueOf(518), Boolean.valueOf(true), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "playRing, listener[" + paramOnCompletionListener + "], seq[" + paramLong + "]");
    }
    if (sB()) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG + "Q.nearby.video_chat", 2, "not playRing");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.dN(paramLong);
      if (!this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(paramLong, this.mApp, paramInt1, null, paramInt2, paramOnCompletionListener))
      {
        igd.aK(TAG, "exit !mTraeHelper.startRing");
        O(b().peerUin, 212);
        ko(212);
        P(b().peerUin, b().ana);
      }
    } while (!b().QF);
    igd.aK(TAG, "exit getSessionInfo().isPeerOnPhone");
    O(b().peerUin, 213);
    ko(213);
    P(b().peerUin, b().ana);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = a(paramLong, paramInt1, paramInt2, paramBoolean);
    int i;
    long l;
    if (paramLong == this.mApp.getLongAccountUin())
    {
      if (QLog.isColorLevel()) {
        QLog.w(TAG, 2, "onGAudioMemberMicChanged, uin[" + paramLong + "], mGAudioMute[" + this.OO + "], isMicOff[" + paramBoolean + "], mIsMicOffBySelf[" + this.OY + "]");
      }
      if ((paramBoolean != this.OO) && (!this.OY))
      {
        i = kB();
        l = this.kJ;
        if (paramBoolean) {
          break label230;
        }
      }
    }
    label230:
    for (boolean bool1 = true;; bool1 = false)
    {
      a("onGAudioMemberMicChanged", l, bool1, false, -1);
      f(-1L, i, kB());
      this.mApp.l(new Object[] { Integer.valueOf(138), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
      if ((paramBoolean) && (bool2)) {
        b(0L, false, 0L);
      }
      return;
    }
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    TraeHelper.a().axI();
    String str1;
    Object localObject;
    if (paramInt1 == 3)
    {
      str1 = igv.a(100, String.valueOf(paramLong2), new int[0]);
      localObject = this.jdField_b_of_type_Igv.c(str1);
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        if (paramInt1 != 1) {
          break label175;
        }
        i = 10;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.ignore(paramInt1, paramLong2, i);
      QLog.w(TAG + "|VideoNodeManager", 1, "ignoreGAudioChat, groupId[" + paramLong2 + "], iFlag[" + paramInt2 + "], sessionId[" + str1 + "], sessionInfo[" + localObject + "]");
      if (localObject != null) {
        break label231;
      }
      return;
      str1 = igv.a(paramInt1, String.valueOf(paramLong2), new int[0]);
      break;
      label175:
      if (paramInt1 == 2)
      {
        i = 1;
      }
      else if (paramInt1 == 3)
      {
        i = 8;
      }
      else
      {
        i = 0;
        QLog.e(TAG, 1, "ignoreGAudioChat, Can't Support Ignore" + paramInt1);
      }
    }
    label231:
    this.mApp.RB = false;
    ((iiv)localObject).QT = true;
    int i = 4;
    label277:
    String str2;
    if (((iiv)localObject).state == 7)
    {
      ((iiv)localObject).Y("ignoreGAudioChat", 0);
      if (paramInt2 != -1)
      {
        i = paramInt2;
        abandonAudioFocus();
        paramInt2 = jll.cM(paramInt1);
        str2 = this.mApp.getCurrentAccountUin();
        if (i != 10) {
          break label412;
        }
        a("ignoreGAudioChat_1", ((iiv)localObject).sessionId, jll.cM(paramInt1), this.mApp.getCurrentAccountUin(), String.valueOf(((iiv)localObject).ll), 5, ((iiv)localObject).senderUin, false, false);
      }
    }
    for (;;)
    {
      paramBoolean = this.jdField_b_of_type_Igv.c(paramLong1, str1);
      localObject = jko.a(this.mApp);
      if ((localObject == null) || (!((jko)localObject).isActive())) {
        break;
      }
      ((jko)localObject).cancelNotification(str1);
      if (!paramBoolean) {
        break;
      }
      alx();
      return;
      i = 3;
      break label277;
      if (paramInt2 == -1) {
        break label277;
      }
      i = paramInt2;
      break label277;
      label412:
      if (paramInt1 == 3) {
        a("ignoreGAudioChat_2", str1, paramInt2, ((iiv)localObject).peerUin, String.valueOf(paramLong2), i, ((iiv)localObject).senderUin, paramBoolean, false);
      } else {
        a("ignoreGAudioChat_3", str1, paramInt2, str2, String.valueOf(paramLong2), i, ((iiv)localObject).senderUin, paramBoolean, false);
      }
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2, ArrayList<String> paramArrayList)
  {
    Object localObject2 = new StringBuilder().append("switchToMultiAudio, roomId[").append(paramLong2).append("], memberList[");
    Object localObject1;
    int i;
    label92:
    int j;
    int k;
    if (paramArrayList != null)
    {
      localObject1 = Integer.valueOf(paramArrayList.size());
      QLog.w("double_2_multi", 1, localObject1 + "], seq[" + paramLong1 + "], uinType[" + paramInt + "]");
      if (paramInt != 1) {
        break label442;
      }
      i = 1;
      anot.a(null, "dc00898", "", "", "0X800A2CA", "0X800A2CA", i, 0, "", "", "", "");
      if (paramArrayList == null) {
        break label638;
      }
      hN(true);
      i = 1;
      j = 2;
      if (paramInt == 1)
      {
        j = 1;
        i = 10;
      }
      localObject2 = b();
      localObject1 = igv.a(j, String.valueOf(paramLong2), new int[0]);
      localObject1 = this.jdField_b_of_type_Igv.a((String)localObject1, false);
      k = ((iiv)localObject2).amI;
      ((iiv)localObject1).n(paramLong1, ((iiv)localObject2).PY);
      ((iiv)localObject1).PV = ((iiv)localObject2).PV;
      ((iiv)localObject1).P("switchToMultiAudio", ((iiv)localObject2).QB);
      ((iiv)localObject1).aQ("switchToMultiAudio", ((iiv)localObject2).deviceName);
      ((iiv)localObject1).peerUin = ((iiv)localObject2).peerUin;
      ((iiv)localObject1).anb = i;
      ((iiv)localObject1).Rp = true;
      if (this.aY != null) {
        this.mApp.getHandler().removeCallbacks(this.aY);
      }
      if (!((iiv)localObject2).Qw) {
        break label454;
      }
      boolean bool = this.OO;
      b(paramLong1, Long.valueOf(((iiv)localObject2).peerUin).longValue(), true, 0);
      M("switchToMultiAudio", bool);
      if (!bool) {
        break label448;
      }
      i = 1;
      label328:
      V("switchToMultiAudio", i);
    }
    for (this.alv = 2;; this.alv = 1)
    {
      if (!paramArrayList.contains(((iiv)localObject2).peerUin)) {
        paramArrayList.add(((iiv)localObject2).peerUin);
      }
      localObject2 = new long[paramArrayList.size()];
      paramArrayList = paramArrayList.iterator();
      i = 0;
      for (;;)
      {
        if (!paramArrayList.hasNext()) {
          break label500;
        }
        String str = (String)paramArrayList.next();
        try
        {
          long l = Long.parseLong(str);
          j = i + 1;
          localObject2[i] = l;
          i = j;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
          }
        }
      }
      localObject1 = "null";
      break;
      label442:
      i = 2;
      break label92;
      label448:
      i = 0;
      break label328;
      label454:
      O(((iiv)localObject2).peerUin, 1);
      ko(214);
      P(((iiv)localObject2).peerUin, 21);
    }
    label500:
    if (i == localObject2.length)
    {
      ((iiv)localObject1).f = ((long[])localObject2);
      if (QLog.isDevelopLevel()) {
        QLog.i("double_2_multi", 4, "switchToMultiAudio uinList[" + localObject2.length + "]");
      }
      ((iiv)localObject1).ana = -1;
      if (k != 1) {
        break label680;
      }
      ((iiv)localObject1).e(paramLong1, "switchToMultiAudio.1", 3);
    }
    for (;;)
    {
      ((iiv)localObject1).uinType = paramInt;
      ((iiv)localObject1).ll = paramLong2;
      ((iiv)localObject1).ac("switchToMultiAudio", jjc.cH(paramInt));
      ((iiv)localObject1).aa("switchToMultiAudio", 0);
      this.mApp.l(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
      label638:
      return;
      ((iiv)localObject1).f = new long[i];
      j = 0;
      while (j < i)
      {
        ((iiv)localObject1).f[j] = localObject2[j];
        j += 1;
      }
      break;
      label680:
      if (k == 2) {
        ((iiv)localObject1).e(paramLong1, "switchToMultiAudio.2", 4);
      } else if (k == 3) {
        ((iiv)localObject1).e(paramLong1, "switchToMultiAudio.3", 3);
      } else if (k == 4) {
        ((iiv)localObject1).e(paramLong1, "switchToMultiAudio.4", 3);
      }
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    a(paramLong1, paramInt, paramLong2, -1, paramBoolean);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    boolean bool;
    GraphicRenderMgr localGraphicRenderMgr;
    if ((paramInt == 4) || (paramInt == 3))
    {
      bool = true;
      QLog.w(TAG, 1, "setEncodeDecodePtr, sessionType[" + paramInt + "], clean[" + paramBoolean1 + "], isRemote[" + paramBoolean2 + "], isMultiEngine[" + bool + "], seq[" + paramLong + "]");
      localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      if (!bool) {
        break label249;
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        if (!paramBoolean2) {
          break label224;
        }
        if (!paramBoolean1) {
          break label188;
        }
        if (localGraphicRenderMgr.decoderPtrRef > 0) {
          localGraphicRenderMgr.decoderPtrRef -= 1;
        }
        if (localGraphicRenderMgr.decoderPtrRef == 0) {
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0L);
        }
      }
    }
    label188:
    label224:
    label249:
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      do
      {
        return;
        if (((paramInt == 2) || (paramInt == 1)) && (b().Qw))
        {
          bool = true;
          break;
        }
        bool = false;
        break;
        localGraphicRenderMgr.decoderPtrRef += 1;
      } while (localGraphicRenderMgr.decoderPtrRef != 1);
      paramLong = localGraphicRenderMgr.getRecvDecoderFrameFunctionptr();
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(paramLong);
      return;
      if (paramBoolean1) {}
      for (paramLong = 0L;; paramLong = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getEncodeFrameFunctionPtrFunPtr())
      {
        localGraphicRenderMgr.setProcessEncodeFrameFunctionPtr(paramLong);
        return;
      }
    }
    if (paramBoolean2)
    {
      if (paramBoolean1) {}
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setProcessDecoderFrameFunctionptr(l);
        return;
        l = localGraphicRenderMgr.getRecvDecoderFrameFunctionptr();
      }
    }
    if (paramBoolean1) {}
    for (;;)
    {
      localGraphicRenderMgr.setProcessEncodeFrameFunctionPtr(l);
      return;
      l = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getEncodeFrameFunctionPtrFunPtr();
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    b localb = a(String.valueOf(paramLong2));
    if (localb == null) {}
    while ((paramInt2 == 1) || ((paramInt2 != 3) && (paramInt2 != 4))) {
      return;
    }
    localb.Pj = false;
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      QLog.w(TAG, 2, "onGroupSystemMsgCome()  mGAudioCtrl == null !!    return !");
    }
    do
    {
      do
      {
        return;
        switch (paramInt2)
        {
        default: 
          return;
        case 3: 
          if (paramBoolean) {
            this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.modifyGroupAdmin(paramLong2, true);
          }
          break;
        }
      } while ((!this.OB) || (this.kJ != paramLong1));
      b().QO = true;
      this.mApp.l(new Object[] { Integer.valueOf(302), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
      return;
      this.mApp.l(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
      return;
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.modifyGroupAdmin(paramLong2, false);
      }
    } while ((!this.OB) || (this.kJ != paramLong1));
    b().QO = false;
    this.mApp.l(new Object[] { Integer.valueOf(303), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
  }
  
  public void a(long paramLong1, long paramLong2, ArrayList<inx> paramArrayList)
  {
    this.mApp.getHandler().post(new VideoController.28(this, paramArrayList, paramLong1, paramLong2));
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), iho.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("selfuin", paramBoolean);
    localNewIntent.putExtra("groupuin", paramLong1);
    localNewIntent.putExtra("groupcode", paramLong2);
    localNewIntent.putExtra("reqType", 13);
    a(localNewIntent);
  }
  
  void a(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    this.OW = isGameMode();
    boolean bool3 = ivv.ae(this.mApp.getApplication().getApplicationContext());
    long l = getChatRoomId(paramString2);
    QLog.w(TAG, 1, "processVideoRequest, uinType[" + paramInt1 + "], peerUin[" + paramString2 + "], extraUin[" + paramString3 + "], onlyAudio[" + paramBoolean1 + "], isDoubleVideoMeeting[" + paramBoolean2 + "], mIsGameMode[" + this.OW + "], isFloatWindowOpAllowedOnBackground[" + bool3 + "], aSessionExists[" + paramBoolean3 + "], roomId[" + l + "], sessionId[" + paramString1 + "], seq[" + paramLong + "]");
    if ((paramBoolean1) && (!imh.isDAudioEnable(this.mApp.getApp())))
    {
      a(paramLong, paramString2, 0, paramBoolean2);
      P(paramString2, 0);
    }
    boolean bool1;
    Object localObject;
    label662:
    label705:
    do
    {
      return;
      iiv localiiv = this.jdField_b_of_type_Igv.c(paramString1);
      if (localiiv == null)
      {
        QLog.w(TAG, 1, "processVideoRequest, sessionInfo为空");
        return;
      }
      localiiv.PT = true;
      localiiv.QE = paramBoolean1;
      localiiv.Y("processVideoRequest.1", 2);
      localiiv.QS = false;
      localiiv.lp = System.currentTimeMillis();
      AVReport.a().QE = localiiv.QE;
      bool1 = false;
      if ((paramBoolean3) || (ihq.sH()))
      {
        localObject = new Intent(this.mApp.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        ((Intent)localObject).putExtra("isScreenLocked", isScreenLocked(this.mApp.getApp().getApplicationContext()));
      }
      for (;;)
      {
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("uinType", paramInt1);
        ((Intent)localObject).putExtra("relationType", jll.cL(paramInt1));
        ((Intent)localObject).putExtra("session_id", paramString1);
        ((Intent)localObject).putExtra("peerUin", paramString2);
        ((Intent)localObject).putExtra("extraUin", paramString3);
        ((Intent)localObject).putExtra("isAudioMode", paramBoolean1);
        ((Intent)localObject).putExtra("curUserStatus", this.alz);
        ((Intent)localObject).putExtra("isDoubleVideoMeeting", paramBoolean2);
        ((Intent)localObject).putExtra("bindType", paramInt2);
        if ((b().jdField_a_of_type_Iiv$a.anA > 0) || ((b().jdField_a_of_type_Iiv$b.chatType != 0) && (b().jdField_a_of_type_Iiv$b.groupId > 0L))) {
          ((Intent)localObject).putExtra("isPlayRing", false);
        }
        if ((paramInt1 != 21) && (paramInt1 != 1011)) {
          break label705;
        }
        acV();
        if (!TextUtils.equals(paramString2, b().jdField_a_of_type_Iiv$a.peerUin)) {
          break label662;
        }
        localiiv.peerUin = paramString2;
        a(paramLong, localiiv.peerUin, 0, 4);
        if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable == null) {
          break;
        }
        this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = null;
        return;
        boolean bool2 = true;
        Intent localIntent = new Intent(this.mApp.getApp().getApplicationContext(), VideoInviteActivity.class);
        localObject = localIntent;
        bool1 = bool2;
        if (aqel.a(this.mApp.getApp().getApplicationContext(), this.mApp))
        {
          localIntent.addFlags(262144);
          localObject = localIntent;
          bool1 = bool2;
        }
      }
      QLog.w(TAG, 1, "processVideoRequest UIN_TYPE_ANYONE wait for  activity accept");
      localiiv.jdField_a_of_type_Iiv$a.Rt = true;
      localiiv.Y("processVideoRequest.2", 0);
      localiiv.uinType = paramInt1;
      localiiv.peerUin = paramString2;
      return;
      if (!localiiv.a(this.mApp)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "processVideoRequest block notify video msg");
    return;
    if (isScreenLocked(this.mApp.getApp().getApplicationContext())) {
      a((Intent)localObject, paramString2, bool1, true);
    }
    for (;;)
    {
      acV();
      return;
      if ((this.OW) && (bool3))
      {
        if ((paramBoolean3) || (ihq.sH()))
        {
          paramString1 = new izr(this, this.mApp, (Intent)localObject);
          paramString1.onCreate();
          paramString1.b((Intent)localObject);
        }
        for (;;)
        {
          QLog.w(TAG, 1, "processVideoRequest startActivity when GameMode");
          a("mode", "1");
          co(paramString2);
          a(paramString2, "screenState", String.valueOf(1));
          break;
          paramString1 = new jeu(this, this.mApp, (Intent)localObject);
          paramString1.onCreate();
          paramString1.a(paramLong, (Intent)localObject);
        }
      }
      a((Intent)localObject, paramString2, bool1, false);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("cancelVideoChat, peerUin[").append(paramString).append("], reason[").append(paramInt).append("], isDoubleMetting[").append(paramBoolean).append("], mVcCtrl[");
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject, 1, bool + "], seq[" + paramLong + "]");
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.dN(paramLong);
    localObject = this.jdField_a_of_type_ComTencentAvUtilsTraeHelper;
    TraeHelper.t(this.mApp);
    int i = -99;
    if (!paramBoolean)
    {
      paramInt = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString, getApn(), paramInt);
      ((ikr)this.mApp.a(4)).d(b().getRoomId(), 10, 1L);
      if ((b().peerUin == null) || (!b().peerUin.equals(paramString))) {
        break label278;
      }
      ikp.s(b().getRoomId(), 38);
    }
    for (i = paramInt;; i = paramInt)
    {
      QLog.w(TAG, 1, "cancelVideoChat, result[" + i + "]");
      abandonAudioFocus();
      alD();
      if (this.jdField_a_of_type_Imj == null) {
        break;
      }
      tar.a(null, "Usr_TV_Video", 3, 0, 0);
      return;
      label278:
      ikp.s(getChatRoomId(paramString), 38);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean, Runnable paramRunnable)
  {
    new Thread(new VideoController.5(this, this, paramLong, paramString, paramInt, paramBoolean, paramRunnable)).start();
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "reject3rdMultiCall[" + paramString1 + "], sessionId[" + paramString2 + "], relationType[" + paramInt + "], senderUin[" + paramString3 + "], extraUin[" + paramString4 + "], seq[" + paramLong + "]");
    }
    a(paramString1, paramString2, jll.cM(paramInt), this.mApp.getCurrentAccountUin(), paramString4, 5, paramString3, false, false);
    this.jdField_b_of_type_Igv.c(paramLong, paramString2);
  }
  
  public void a(long paramLong, String paramString, String[] paramArrayOfString)
  {
    if ((!this.OB) || (b().ll != paramLong) || (paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    while (this.mApp.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    this.mApp.l(new Object[] { Integer.valueOf(82), paramString, paramArrayOfString });
  }
  
  public void a(long paramLong, ArrayList<ini> paramArrayList, int paramInt1, int paramInt2)
  {
    this.ib.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      b localb = new b();
      localb.uin = ((ini)paramArrayList.get(i)).account;
      localb.accountType = ((ini)paramArrayList.get(i)).accountType;
      this.ib.add(localb);
      if (((ini)paramArrayList.get(i)).accountType == 1) {
        localArrayList.add(Long.valueOf(((ini)paramArrayList.get(i)).account));
      }
      i += 1;
    }
    if (localArrayList.size() > 0) {
      bw(localArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "onGAudioMemAllUpdate, size[" + this.ib.size() + "]");
    }
    this.mApp.l(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), aP(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(long paramLong, ArrayList<ioa> paramArrayList, int paramInt, boolean paramBoolean)
  {
    if (paramArrayList == b().ig)
    {
      ArrayList localArrayList = b().ig;
      int i = 0;
      label115:
      for (;;)
      {
        try
        {
          if (i < paramArrayList.size())
          {
            if (((ioa)paramArrayList.get(i)).uin != paramLong) {
              break label115;
            }
            if (paramBoolean)
            {
              p(paramArrayList, i);
              b().amI();
            }
          }
          else
          {
            return;
          }
          if (paramInt == ((ioa)paramArrayList.get(i)).videoSrcType)
          {
            p(paramArrayList, i);
            b().amI();
          }
          else
          {
            i += 1;
          }
        }
        finally {}
      }
    }
  }
  
  public void a(long paramLong, ArrayList<ioa> paramArrayList1, ArrayList<ioa> paramArrayList2, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList1.size()) {
        if (((ioa)paramArrayList1.get(i)).uin == paramLong)
        {
          if (paramBoolean)
          {
            p(paramArrayList1, i);
            a(paramLong, paramArrayList2, paramInt, paramBoolean);
            return;
          }
          if (paramInt == ((ioa)paramArrayList1.get(i)).videoSrcType)
          {
            p(paramArrayList1, i);
            a(paramLong, paramArrayList2, paramInt, paramBoolean);
            return;
          }
          i += 1;
        }
        else
        {
          i += 1;
        }
      }
    }
  }
  
  void a(long paramLong, boolean paramBoolean1, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "reject3rdDoubleCall, isDoubleVideoMeeting[" + paramBoolean1 + "], uinType[" + paramInt1 + "], fromUin[" + paramString1 + "], extraUin[" + paramString2 + "], bindType[" + paramInt2 + "], bindID[" + paramString3 + "], onlyAudio[" + paramBoolean2 + "], seq[" + paramLong + "]");
    }
    String str;
    long l2;
    if (paramBoolean1)
    {
      str = igv.a(100, paramString1, new int[0]);
      iiv localiiv2 = this.jdField_b_of_type_Igv.c(str);
      iiv localiiv1 = localiiv2;
      if (localiiv2 == null) {
        localiiv1 = this.jdField_b_of_type_Igv.a(str, false);
      }
      localiiv1.uinType = paramInt1;
      localiiv1.bindType = paramInt2;
      localiiv1.MX = paramString3;
      localiiv1.PT = true;
      paramInt1 = localiiv1.uinType;
      if (paramBoolean2) {
        break label268;
      }
      paramBoolean2 = true;
      a(str, paramInt1, paramBoolean2, paramString1, paramString2);
      if (!paramBoolean1) {
        break label304;
      }
      l2 = -1L;
    }
    for (;;)
    {
      try
      {
        l1 = jji.B(paramString1);
        c(paramLong, 3, l1);
        igv.a().c(paramLong, str);
        return;
        str = igv.a(3, paramString1, new int[0]);
        break;
        label268:
        paramBoolean2 = false;
      }
      catch (NumberFormatException paramString1)
      {
        long l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "", paramString1);
        l1 = l2;
        continue;
      }
      label304:
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString1, getApn(), 65536);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if (paramBoolean2) {
      if (b().ane == 2) {
        bool = true;
      }
    }
    for (;;)
    {
      QLog.w(TAG, 1, "onGAudioRoomMicModeChanged, manager uin[" + paramLong + "], old isRoomMicOff[" + b().QI + "], new isRoomMicOff[" + paramBoolean1 + "], mIsMicOffBySelf[" + this.OY + "], mGAudioGroupId[" + this.kJ + "], micAuthByAdmin[" + b().ane + "], isCreateRoomOrEnterRoom[" + paramBoolean2 + "], bNeedUpdateMic[" + bool + "]");
      b().Q("onGAudioRoomMicModeChanged", paramBoolean1);
      int i;
      long l;
      if ((bool) && (!this.OY) && ((paramLong != this.mApp.getLongAccountUin()) || (!paramBoolean1)) && (paramBoolean1))
      {
        i = kB();
        l = this.kJ;
        if (paramBoolean1) {
          break label279;
        }
      }
      label279:
      for (bool = true;; bool = false)
      {
        a("onGAudioRoomMicModeChanged", l, bool, false, -1);
        f(-1L, i, kB());
        this.mApp.l(new Object[] { Integer.valueOf(139), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
        return;
        bool = false;
        break;
      }
      bool = true;
    }
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, boolean paramBoolean)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnPreviewData", 2, "onPreviewData data is null");
      }
      return;
    }
    if (this.OJ)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController$a != null) {
        this.jdField_a_of_type_ComTencentAvVideoController$a.amh();
      }
      this.OJ = false;
    }
    u(paramArrayOfByte);
    boolean bool = sC();
    jjo localjjo;
    if (jjo.enable())
    {
      localjjo = new jjo(this.jdField_a_of_type_Jjo, paramLong1);
      localjjo.a(paramArrayOfByte.length, paramInt1, paramInt2, ilj.aoD, paramInt3, paramInt4, paramLong2, paramBoolean, bool);
      localjjo.axj();
    }
    for (;;)
    {
      this.jdField_a_of_type_Jjo = localjjo;
      if (bool)
      {
        paramArrayOfByte = new ios(paramLong1, paramArrayOfByte, paramInt1, paramInt2, ilj.aoD, paramInt3, paramInt4, paramBoolean, paramLong2, System.currentTimeMillis());
        paramArrayOfByte.b = localjjo;
        if (this.jdField_a_of_type_Iow == null) {
          break;
        }
        this.jdField_a_of_type_Iow.a(paramArrayOfByte);
        return;
      }
      if (localjjo != null) {
        localjjo.finish();
      }
      GraphicRenderMgr.getInstance().sendCameraFrame(paramArrayOfByte, ilj.aoD, paramInt1, paramInt2, paramInt3, paramInt4, System.currentTimeMillis(), paramBoolean, this.K, null, 0, 0);
      ilo.a().d(paramArrayOfByte, 0);
      ird.a().lu(0);
      return;
      localjjo = null;
    }
  }
  
  public void a(long paramLong, long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    this.ib.clear();
    if (paramArrayOfLong == null)
    {
      this.mApp.l(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), aP(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    paramInt2 = 0;
    while (paramInt2 < paramArrayOfLong.length)
    {
      b localb = new b();
      localb.uin = paramArrayOfLong[paramInt2];
      this.ib.add(localb);
      paramInt2 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "onGAudioMemAllUpdate, size[" + this.ib.size() + "]");
    }
    this.mApp.l(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), aP(), Integer.valueOf(paramInt1) });
  }
  
  public void a(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    if (paramArrayOfLong == null) {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "onGaChatUserInOrOut-->userUin is 0,OpType = " + paramInt1);
      }
    }
    long l;
    do
    {
      return;
      l = paramArrayOfLong[0];
      switch (paramInt1)
      {
      }
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wrong type of GaChatMemBerInType, and Type = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", groupUin = ");
    localStringBuilder.append(paramLong1);
    paramInt2 = paramArrayOfLong.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramLong1 = paramArrayOfLong[paramInt1];
      localStringBuilder.append(", userUin = ");
      localStringBuilder.append(paramLong1);
      paramInt1 += 1;
      continue;
      a(paramLong1, paramArrayOfLong, true, paramInt4);
      return;
      a(paramLong1, paramArrayOfLong, false, paramInt4);
      return;
      a(paramLong1, l, true, paramInt2, paramLong2, paramInt3);
      return;
      a(paramLong1, l, false, paramInt2, paramLong2, paramInt3);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onMultiVideoChatMembersInfoChange = userUin:" + l + "curuin:" + this.mApp.getCurrentAccountUin());
      }
      if (l != this.mApp.getLongAccountUin())
      {
        a(paramLong1, l, paramInt2, paramLong2, paramInt3);
        return;
      }
      a(paramLong1, l, true, paramInt2, false, paramLong2, paramInt3);
      return;
      a(paramLong1, l, false, paramInt2, false, paramLong2, paramInt3);
      return;
      a(Long.valueOf(paramLong1), l, paramInt2, true);
      return;
      a(Long.valueOf(paramLong1), l, paramInt2, false);
      return;
      a(paramLong1, l, true, paramInt2, true, paramLong2, paramInt3);
      return;
      a(paramLong1, l, false, paramInt2, true, paramLong2, paramInt3);
      return;
    }
    QLog.e(TAG, 2, localStringBuilder.toString());
  }
  
  void a(long paramLong, long[] paramArrayOfLong, boolean paramBoolean, int paramInt)
  {
    long l = paramArrayOfLong[0];
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onMemberSpeak-->setSpeakingUin,uin=" + l + ", isSpeaking = " + paramBoolean + ", audioEnergy = " + paramInt);
    }
    boolean bool = a(l, paramBoolean, paramInt);
    this.mApp.l(new Object[] { Integer.valueOf(63), Long.valueOf(l), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
    Intent localIntent = new Intent("tencent.video.v2q.memberSpeaking");
    localIntent.putExtra("groupId", paramLong);
    localIntent.putExtra("uinList", paramArrayOfLong);
    localIntent.putExtra("isSpeaking", paramBoolean);
    localIntent.putExtra("audioEnergy", paramInt);
    this.mApp.getApplication().sendBroadcast(localIntent);
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentAvVideoController$a = parama;
  }
  
  void a(b paramb, int paramInt)
  {
    paramb.alV = 0;
    paramb.Ph = false;
    paramb.Pi = false;
    paramb.Pj = false;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "setVideoSrcType-->wrong type of videosrctype,type=" + paramInt);
      }
    case 0: 
      return;
    case 1: 
      paramb.Ph = true;
      return;
    case 3: 
      paramb.Pi = true;
      return;
    case 2: 
      paramb.alV = 1;
      return;
    }
    paramb.Pj = true;
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.mApp != null)
    {
      this.mApp = paramVideoAppInterface;
      return;
    }
    this.mApp = paramVideoAppInterface;
    this.appContext = paramVideoAppInterface.getApp().getApplicationContext();
    VideoController.3 local3 = new VideoController.3(this);
    paramVideoAppInterface.getHandler().post(local3);
    if (!aqiw.isNetSupport(getAppContext())) {
      this.mNetType = 0;
    }
    for (;;)
    {
      sn();
      if ((this.alH == 0) && (ivv.af(paramVideoAppInterface.getApp()))) {
        this.alH = 1;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a(this.appContext, this);
      if (this.OI) {
        alu();
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateProcessInfo(0L, "qqVersion", AppSetting.aq(getAppContext()));
      return;
      if (aqiw.isWifiEnabled(getAppContext())) {
        this.mNetType = 1;
      } else {
        this.mNetType = 2;
      }
    }
  }
  
  public void a(PBRepeatMessageField<submsgtype0x116.MemberInfo> paramPBRepeatMessageField1, PBRepeatMessageField<submsgtype0x116.MemberInfo> paramPBRepeatMessageField2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "InviteMemberList updateMemberListWithPushMessage joins" + paramPBRepeatMessageField1.size() + ";quits size" + paramPBRepeatMessageField2.size() + ";eventType:=" + paramInt2);
    }
    Object localObject1 = new HashSet();
    Object localObject2 = this.hY.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Set)localObject1).add(Long.valueOf(((b)((Iterator)localObject2).next()).uin));
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "mMemberChangeEventReceiver totalCount:" + paramInt1);
    }
    paramInt1 = 0;
    int i = 0;
    if (i < paramPBRepeatMessageField1.size())
    {
      localObject2 = (submsgtype0x116.MemberInfo)((submsgtype0x116.MemberInfo)paramPBRepeatMessageField1.get(i)).get();
      int k;
      if (((submsgtype0x116.MemberInfo)localObject2).uint64_member_uin.get() == this.mApp.getLongAccountUin())
      {
        k = 1;
        label201:
        j = paramInt1;
        if (!((Set)localObject1).contains(Long.valueOf(((submsgtype0x116.MemberInfo)localObject2).uint64_member_uin.get())))
        {
          if (k == 0) {
            break label251;
          }
          j = paramInt1;
        }
      }
      for (;;)
      {
        i += 1;
        paramInt1 = j;
        break;
        k = 0;
        break label201;
        label251:
        b localb = new b();
        localb.accountType = 0;
        localb.uin = ((submsgtype0x116.MemberInfo)localObject2).uint64_member_uin.get();
        localb.Pn = false;
        localb.timeStamp = ((submsgtype0x116.MemberInfo)localObject2).uint32_invite_timestamp.get();
        this.hY.add(localb);
        paramInt1 = 1;
        j = paramInt1;
        if (QLog.isColorLevel())
        {
          QLog.d(TAG, 2, "mMemberChangeEventReceiver add member UIN:" + localb.uin);
          j = paramInt1;
        }
      }
    }
    int j = 0;
    if (j < paramPBRepeatMessageField2.size())
    {
      paramPBRepeatMessageField1 = (submsgtype0x116.MemberInfo)((submsgtype0x116.MemberInfo)paramPBRepeatMessageField2.get(j)).get();
      localObject1 = this.hY.iterator();
      do
      {
        i = paramInt1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (b)((Iterator)localObject1).next();
      } while (((b)localObject2).uin != paramPBRepeatMessageField1.uint64_member_uin.get());
      this.hY.remove(localObject2);
      if (paramInt2 != 2) {
        paramInt1 = 1;
      }
      i = paramInt1;
      if (!QLog.isColorLevel()) {
        break label548;
      }
      QLog.d(TAG, 2, "mMemberChangeEventReceiver remove member UIN:" + ((b)localObject2).uin);
    }
    for (;;)
    {
      j += 1;
      break;
      if (paramInt1 != 0) {
        this.mApp.l(new Object[] { Integer.valueOf(708), Long.valueOf(1L), Long.valueOf(1L), this.hY });
      }
      return;
      label548:
      paramInt1 = i;
    }
  }
  
  public void a(ini paramini, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onMAVMemberInOrOut--> UserInfo = " + paramini.toString() + " ,relationId = " + paramLong1 + " ,opType = " + paramInt1 + " ,relationType = " + paramInt2 + " ,extroInfo = " + paramLong2);
    }
    AVPhoneUserInfo localAVPhoneUserInfo;
    if (paramInt1 == 70)
    {
      if (paramini.accountType == 1)
      {
        if (b().b(paramini.account, b().ii) == null) {
          break label183;
        }
        localAVPhoneUserInfo = b().b(paramini.account, b().ii);
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "onMAVMemberInOrOut --> This PSTN User is in List. Info = " + localAVPhoneUserInfo);
        }
      }
      a(paramInt2, paramLong1, paramini, true, paramLong2, paramVarArgs);
    }
    label183:
    do
    {
      return;
      localAVPhoneUserInfo = new AVPhoneUserInfo();
      localAVPhoneUserInfo.account = paramini.account;
      localAVPhoneUserInfo.accountType = 2;
      b().a(localAVPhoneUserInfo);
      bB(paramini.account);
      break;
      if (paramInt1 == 71)
      {
        if (paramini.accountType == 1)
        {
          localAVPhoneUserInfo = new AVPhoneUserInfo();
          localAVPhoneUserInfo.account = paramini.account;
          localAVPhoneUserInfo.accountType = 2;
        }
        a(paramInt2, paramLong1, paramini, false, paramLong2, paramVarArgs);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "onMAVMemberInOrOut-->WRONG OPTYPE");
  }
  
  void a(ini paramini, boolean paramBoolean)
  {
    ArrayList localArrayList = this.hZ;
    if (paramBoolean) {}
    Object localObject1;
    try
    {
      if (v(paramini.account) != -1) {
        return;
      }
      localObject1 = new b();
      ((b)localObject1).uin = paramini.account;
      ((b)localObject1).accountType = paramini.accountType;
      this.hZ.add(localObject1);
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.i(TAG, 2, "onMemberInOrOut, size[" + this.hZ.size() + "], coming[" + paramini + "]");
      return;
    }
    finally {}
    int i = v(paramini.account);
    Object localObject2 = null;
    if (i != -1) {
      localObject1 = (b)this.hZ.remove(i);
    }
    for (;;)
    {
      a(paramini.account, b().jdField_if, b().ig, 0, true);
      alN();
      if ((localObject1 == null) || (((b)localObject1).Pk) || (!((b)localObject1).Pm)) {
        break;
      }
      b(0L, false, 0L);
      break;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.e(TAG, 2, "onMemberInOrOut-->can not find the member.userInfo = " + paramini);
        localObject1 = localObject2;
      }
    }
  }
  
  public void a(inw paraminw)
  {
    ArrayList localArrayList;
    StringBuilder localStringBuilder;
    boolean bool;
    if (paraminw == null)
    {
      localArrayList = null;
      if (paraminw != null) {
        itq.ad(paraminw.retCode, paraminw.tip);
      }
      if (QLog.isColorLevel())
      {
        paraminw = TAG;
        localStringBuilder = new StringBuilder().append("onGAudioInviteResp, avInviteAccountList[");
        if (localArrayList == null) {
          break label110;
        }
        bool = true;
        label54:
        localStringBuilder = localStringBuilder.append(bool).append("], size[");
        if (localArrayList != null) {
          break label115;
        }
      }
    }
    label110:
    label115:
    for (int i = 0;; i = localArrayList.size())
    {
      QLog.w(paraminw, 1, i + "]");
      if (localArrayList != null) {
        break label124;
      }
      return;
      localArrayList = paraminw.iz;
      break;
      bool = false;
      break label54;
    }
    label124:
    if (b().id != null)
    {
      i = 0;
      while (i < localArrayList.size())
      {
        if ((((ing)localArrayList.get(i)).aqq == 1) && (((ing)localArrayList.get(i)).aqr == 1) && (!b().id.contains(Long.valueOf(((ing)localArrayList.get(i)).lZ)))) {
          b().id.add(Long.valueOf(((ing)localArrayList.get(i)).lZ));
        }
        i += 1;
      }
    }
    this.mApp.l(new Object[] { Integer.valueOf(99) });
  }
  
  void a(Long paramLong, long paramLong1, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onBanAudio-->relationId" + paramLong + " uin=" + paramLong1 + " relationType=" + paramInt + " bBan=" + paramBoolean);
    }
    if (paramLong1 != Long.valueOf(this.mApp.getCurrentAccountUin()).longValue()) {
      return;
    }
    if (paramBoolean)
    {
      b().QN = true;
      this.mApp.l(new Object[] { Integer.valueOf(71), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
      return;
    }
    b().QN = false;
    this.mApp.l(new Object[] { Integer.valueOf(72), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, long paramLong)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "onSwitchTerminalSuccess, fromUin[" + paramString1 + "], info[" + paramInt1 + "], hdModeFreeUseStartTime[" + paramInt2 + "], hdModeFreeUseEndTime[" + paramInt3 + "], hdModeFreeUseTips[" + paramString2 + "], roomId[" + paramLong + "], seq[" + l + "]");
    }
    if (this.mApp == null) {
      return;
    }
    if (this.ba != null)
    {
      this.mApp.getHandler().removeCallbacks(this.ba);
      this.ba = null;
    }
    paramString1 = b();
    label219:
    boolean bool1;
    if (paramString1.QV)
    {
      paramString1.QV = false;
      if (paramString1.PV) {
        b(true, paramString1.peerUin);
      }
      if (this.mApp.countObservers() > 0)
      {
        this.mApp.l(new Object[] { Integer.valueOf(33), paramString1.peerUin, Boolean.valueOf(false) });
        bA(l);
        paramInt1 = (int)bt();
        boolean bool2 = paramString1.PZ;
        if (paramString1.PW) {
          break label304;
        }
        bool1 = true;
        label247:
        e(paramInt1, bool2, bool1);
      }
    }
    for (;;)
    {
      paramString2 = this.mApp.a();
      if (paramString2 == null) {
        break;
      }
      paramString2.a(this, paramString1);
      return;
      paramString2 = new VideoController.15(this, paramString1);
      this.fb.add(paramString2);
      break label219;
      label304:
      bool1 = false;
      break label247;
      if (paramString1.QU) {
        a(paramString1.peerUin, paramInt2, paramInt3, paramString2, paramLong);
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 2, "onChannelReady, fromUin[" + paramString1 + "], mStartRing[" + this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable + "], seq[" + l + "]");
    }
    if (this.mApp == null) {
      return;
    }
    iiv localiiv = b();
    int j = localiiv.relationType;
    int i;
    if ((j != 1) && (j != 2) && (j != 0))
    {
      i = j;
      if (j != 100) {}
    }
    else
    {
      i = 3;
    }
    if (a("onChannelReady", false, i, paramString1)) {
      localiiv = b();
    }
    for (;;)
    {
      localiiv.amY = paramInt1;
      localiiv.amZ = paramInt2;
      localiiv.MV = paramString2;
      QLog.i(TAG, 1, "onChannelReady, fromUin[" + paramString1 + "], hdModeFreeUseStartTime[" + paramInt1 + "], hdModeFreeUseEndTime[" + paramInt2 + "], hdModeFreeUseTips[" + paramString2 + "], roomId[" + paramLong + "], session[" + localiiv + "]");
      ikp.kQ(30);
      ikp.r(9, localiiv.getRoomId());
      ikp.report(11, localiiv.peerUin);
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      jle.a(getAppContext()).start();
      if (1L == localiiv.li)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.dN(l);
        if ((localiiv.QE) && (localiiv.PT) && (!sw())) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.startService("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        }
        b(true, localiiv.peerUin);
        return;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.dN(l);
      if (localiiv.uinType != 1011) {
        TraeHelper.a(this.mApp, true, l);
      }
      localiiv.kE(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(paramString1));
      localiiv.kF(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString1));
      localiiv.bP(paramLong);
      alD();
      localiiv.amL = localiiv.state;
      localiiv.Y("onChannelReady", 4);
      localiiv.C(l, SystemClock.elapsedRealtime());
      if ((localiiv.PT) && (!sw()))
      {
        if (localiiv.QE) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.startService("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        }
      }
      else
      {
        label501:
        if ((localiiv.amI == 1) && (localiiv.uinType == 1011))
        {
          localiiv.jdField_a_of_type_Iiv$a.anA = 5;
          e(localiiv.jdField_a_of_type_Iiv$a.anA, 1, null);
        }
        paramString2 = (ikr)this.mApp.a(4);
        if (!localiiv.PT) {
          break label876;
        }
        paramInt1 = 11;
        label568:
        paramString2.d(localiiv.getRoomId(), paramInt1, 1L);
        if (this.mApp.countObservers() <= 0) {
          break label881;
        }
        this.mApp.l(new Object[] { Integer.valueOf(13), Long.valueOf(l) });
        if (sw()) {
          a(l, 2131230749, 1, null);
        }
        alx();
        label639:
        if (!localiiv.PV) {
          break label888;
        }
        b(true, localiiv.peerUin);
      }
      for (;;)
      {
        this.Oz = false;
        this.mApp.getHandler().postDelayed(new VideoController.8(this, l), 50L);
        a(localiiv.sessionId, localiiv.amI, true, true, true);
        jjk.k(this);
        jjk.c(this, true);
        jjk.b(this, true);
        paramLong = by();
        paramString2 = aqmj.i(this.mApp.getCurrentAccountUin());
        paramString2.edit().putLong("qav_roomid", paramLong).commit();
        paramLong = getPeerSdkVersion(paramString1);
        paramString2.edit().putLong(VideoConstants.Mg, paramLong).commit();
        hQ(false);
        paramString1 = this.mApp.a();
        if (paramString1 != null) {
          paramString1.amj();
        }
        if (this.jdField_a_of_type_Igx != null) {
          this.jdField_a_of_type_Igx.alr();
        }
        if (this.mApp == null) {
          break;
        }
        paramString1 = this.mApp.a();
        if (paramString1 == null) {
          break;
        }
        paramString1.a(localiiv);
        return;
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.xP()) {
          break label501;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.startService("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        break label501;
        label876:
        paramInt1 = 4;
        break label568;
        label881:
        alx();
        break label639;
        label888:
        b(false, localiiv.peerUin);
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    QLog.d(TAG, 1, "sendVideoMsgBroadcast uinType: " + paramInt1 + ", msgType: " + paramInt2 + ", friendUin: " + paramString2 + ", selfUin: " + this.mApp.getCurrentAccountUin() + ", isReceiver = " + b().PT + ", isVideoMsg = " + paramBoolean1 + ", extraUin: " + paramString3 + ", forceUnread:" + paramBoolean2);
    if ((TextUtils.isEmpty(paramString2)) || ("0".equals(paramString2))) {
      QLog.i(TAG, 1, "sendVideoMsgBroadcast, invalid uin[" + paramString2 + "]");
    }
    while (this.mApp == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.AddVideoMsg");
    iiv localiiv = this.jdField_b_of_type_Igv.c(paramString1);
    if (localiiv == null)
    {
      QLog.d(TAG, 1, "sendVideoMsgBroadcast() -> session == null, return!");
      return;
    }
    if (paramInt2 == 21) {
      if ((localiiv.switchState == 11) || (localiiv.switchState == 12))
      {
        paramInt2 = 47;
        localiiv.bs(1, 0);
        paramInt1 = 0;
      }
    }
    label898:
    label905:
    for (;;)
    {
      boolean bool = false;
      if ((localiiv.tc()) && (paramInt2 == 1)) {
        bool = true;
      }
      String str;
      label452:
      label495:
      float f;
      for (;;)
      {
        if (paramBoolean2) {
          bool = false;
        }
        localIntent.putExtra("uinType", paramInt1);
        localIntent.putExtra("msgType", paramInt2);
        localIntent.putExtra("isVideoMsg", paramBoolean1);
        localIntent.putExtra("isRead", bool);
        localIntent.putExtra("bindType", localiiv.bindType);
        localIntent.putExtra("bindId", localiiv.MX);
        localIntent.putExtra("MultiAVType", localiiv.anb);
        if (paramInt2 == 17) {
          localIntent.putExtra("msgDetail", Integer.parseInt(paramString3));
        }
        paramString1 = this.mApp.getCurrentAccountUin();
        if ((paramInt1 != 1004) && (paramInt1 != 1000)) {
          break label731;
        }
        if (paramInt2 == 20) {
          paramString3 = paramString1;
        }
        str = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          str = paramString1;
        }
        if (localiiv.Qw)
        {
          if (!localiiv.Qz) {
            break label803;
          }
          str = paramString1;
        }
        localIntent.putExtra("friendUin", paramString2);
        localIntent.putExtra("senderUin", str);
        localIntent.putExtra("selfUin", paramString1);
        if (localiiv.PT) {
          break label810;
        }
        paramBoolean1 = true;
        localIntent.putExtra("isSender", paramBoolean1);
        if (paramInt2 != 41) {
          break label872;
        }
        if (this.kK <= 0L) {
          break label861;
        }
        f = (float)this.kK / 1024.0F;
        if (f >= 1024.0F) {
          break label816;
        }
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f) }) + "KB";
        label579:
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getConnectedTime():" + bt() + " extra:" + paramString1);
        }
        localIntent.putExtra("extra", paramString1);
        localIntent.setPackage(this.mApp.getApp().getPackageName());
        this.mApp.getApp().sendBroadcast(localIntent);
        return;
        paramInt2 = 48;
        break;
        if (paramInt2 != 72) {
          break label905;
        }
        if ((localiiv.switchState == 16) || (localiiv.switchState == 17)) {}
        for (paramInt2 = 47;; paramInt2 = 48)
        {
          localiiv.bs(1, 0);
          paramInt1 = 0;
          break;
        }
        if (localiiv.isConnected()) {
          bool = true;
        }
      }
      label731:
      if (paramInt1 == 1006) {
        if (paramString2.startsWith("+")) {
          break label898;
        }
      }
      for (;;)
      {
        if (localiiv.PT) {}
        for (paramString2 = paramString3;; paramString2 = paramString1)
        {
          str = paramString3;
          paramString3 = paramString2;
          paramString2 = str;
          break;
        }
        if (localiiv.PT) {}
        for (paramString3 = paramString2;; paramString3 = paramString1) {
          break;
        }
        label803:
        str = paramString2;
        break label452;
        label810:
        paramBoolean1 = false;
        break label495;
        label816:
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f / 1024.0F) }) + "MB";
        break label579;
        label861:
        QLog.d(TAG, 1, "sendVideoMsgBroadcast() -> return!  no to show net traffic tips msg in AIO");
        return;
        label872:
        if (localiiv.lj > 0L)
        {
          paramString1 = jll.formatTime(bt());
          break label579;
        }
        paramString1 = null;
        break label579;
        paramString3 = paramString2;
      }
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    long l = AudioHelper.hG();
    QLog.w(TAG, 1, "avideo onInviteReached, peerUin[" + paramString + "], friend_state[" + paramInt + "], extraParam0[" + paramLong + "], subState[" + b().li + "], mStartRing[" + this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable + "], seq[" + l + "]");
    b().MW = null;
    if (b() != null)
    {
      if (0L != b().li) {
        break label313;
      }
      if (0L != paramLong) {}
    }
    else
    {
      if ((b() == null) || (!b().isConnected())) {
        break label369;
      }
      QLog.w(TAG, 1, "onInviteReached, isConnected");
    }
    label313:
    label369:
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return;
            if (1L == paramLong)
            {
              b().li = 1L;
              if (paramArrayOfByte == null) {
                break;
              }
              b().MW = new String(paramArrayOfByte);
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onInviteReached :" + b().MW);
              }
              if (this.mApp == null) {
                break;
              }
              this.mApp.l(new Object[] { Integer.valueOf(400), b().MW });
              break;
            }
            if (2L != paramLong) {
              break;
            }
            b().li = 2L;
          } while (paramArrayOfByte == null);
          b().MW = new String(paramArrayOfByte);
          return;
          if (1L != b().li) {
            break;
          }
          if (0L == paramLong)
          {
            b().li = 0L;
            return;
          }
        } while (1L == paramLong);
        if (2L != paramLong) {
          break;
        }
        b().li = 0L;
        by(l);
        return;
        i = 0x80000 & paramInt;
        if ((i <= 0) || (!this.OM)) {
          break label405;
        }
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "onInviteReached :has get phone state");
      return;
      if (i == 0) {
        this.OM = true;
      }
      b().amR = 0;
      if ((0x10000 & paramInt) > 0)
      {
        i = 0x40000 & paramInt;
        b().amP = (0x20000 & paramInt);
        b().amQ = i;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "onInviteReached pcOnLine:" + b().amP + " # phoneOnLine = " + b().amQ);
        }
        if (((0x100000 & paramInt) > 0) && (i > 0))
        {
          if ((0xFFFF & paramInt & 0x1) > 0) {
            b().amR = 1;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
          {
            if (this.mApp != null) {
              this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
            }
            this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
          }
          if (this.mApp != null)
          {
            if ((b() != null) && (b().li == 1L) && (!TextUtils.isEmpty(b().MW))) {
              this.mApp.l(new Object[] { Integer.valueOf(30), paramString, b().MW });
            }
          }
          else if (!b().QU) {
            bz(l);
          }
        }
        for (;;)
        {
          b().Qg = true;
          return;
          this.mApp.l(new Object[] { Integer.valueOf(30), paramString });
          break;
          paramInt &= 0xFFFF;
          if ((paramInt & 0x2) > 0) {
            b().amR = 2;
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label817;
            }
            QLog.d(TAG, 2, "onInviteReached low 16bit value is" + paramInt);
            break;
            if ((paramInt & 0x4) > 0)
            {
              b().amR = 3;
              anot.a(null, "CliOper", "", "", "0x80049A5", "0x80049A5", 0, 0, "", "", "", "");
            }
            else if ((paramInt & 0x8) > 0)
            {
              b().amR = 4;
            }
          }
        }
      }
      b().amP = 0;
      b().amQ = 0;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "pc and phone both not online");
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        if (this.mApp != null) {
          this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        }
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      hR(true);
      b().Qg = false;
      O(b().peerUin, 210);
      ko(210);
      this.bc = new VideoController.21(this, l);
    } while ((this.bc == null) || (this.mApp == null));
    label405:
    label817:
    this.mApp.getHandler().postDelayed(this.bc, 2000L);
  }
  
  void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2, String paramString3)
  {
    a(paramString1, paramInt, 2, paramBoolean, paramString2, paramString3, true);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intent localIntent;
    if (this.mApp != null)
    {
      if (AudioHelper.aCz()) {
        QLog.w(TAG, 1, "sendStartVideoBroadcast, sessionId[" + paramString + "], sessionType[" + paramInt + "], updateTime[" + paramBoolean1 + "], showTime[" + paramBoolean2 + "], isDouble[" + paramBoolean3 + "]");
      }
      localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.StartVideoChat");
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("sessionId", paramString);
      if (this.jdField_b_of_type_Igv != null)
      {
        paramString = this.jdField_b_of_type_Igv.c(paramString);
        if (paramString != null)
        {
          localIntent.putExtra("uinType", paramString.uinType);
          if (paramString.uinType != 26) {
            break label376;
          }
          localIntent.putExtra("peerUin", paramString.MP);
        }
      }
    }
    for (;;)
    {
      if ((paramInt == 3) || (paramInt == 4))
      {
        localIntent.putExtra("peerUin", String.valueOf(paramString.ll));
        localIntent.putExtra("relationType", paramString.relationType);
        localIntent.putExtra("relationId", paramString.ll);
      }
      localIntent.putExtra("extraUin", paramString.MP);
      localIntent.putExtra("bindType", paramString.bindType);
      localIntent.putExtra("bindId", paramString.MX);
      localIntent.putExtra("isReceiver", paramString.PT);
      localIntent.putExtra("isDoubleVideoMeeting", paramString.Qw);
      if (sB()) {
        localIntent.putExtra("isNearbyVideoChat", true);
      }
      localIntent.putExtra("updateTime", paramBoolean1);
      localIntent.putExtra("isDouble", paramBoolean3);
      localIntent.putExtra("showTime", paramBoolean2);
      localIntent.setPackage(this.mApp.getApp().getPackageName());
      this.mApp.getApp().sendBroadcast(localIntent);
      return;
      label376:
      localIntent.putExtra("peerUin", paramString.peerUin);
    }
  }
  
  public void a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    paramString = ije.a(this.mApp);
    StringBuilder localStringBuilder;
    if (((paramString == null) || (!paramString.b(paramInt, paramArrayOfByte))) && (QLog.isDevelopLevel()))
    {
      paramArrayOfByte = TAG;
      localStringBuilder = new StringBuilder().append("收到未知的C2C消息[").append(paramInt).append("], handlerForVideo[");
      if (paramString == null) {
        break label85;
      }
    }
    label85:
    for (boolean bool = true;; bool = false)
    {
      QLog.w(paramArrayOfByte, 1, bool + "]");
      return;
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, String.format("onSDKCustomCommand uin=%s, cmd=%s, arg1=%s, arg2=%s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
    }
    if (paramLong1 == 200L)
    {
      if (paramLong2 != 1L) {
        break label69;
      }
      ihp.ams();
    }
    label69:
    while (paramLong2 != 2L) {
      return;
    }
    ihp.bF(paramLong3);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "sendMultiVideoMsg, cmsCmd[" + paramLong2 + "], seq[" + l + "]");
    }
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), iho.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("cscmd", (short)(int)paramLong2);
    localNewIntent.putExtra("selfuin", jji.B(paramString));
    localNewIntent.putExtra("toUin", paramLong1);
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    localNewIntent.putExtra("reqType", 8);
    jlc.a(localNewIntent, l);
    a(localNewIntent);
  }
  
  public void a(String arg1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      a(??? + "_" + paramLong, paramBoolean1, paramBoolean2);
      if (paramBoolean1) {
        break label143;
      }
      paramBoolean2 = true;
      M("gAudioSetInput", paramBoolean2);
      if (paramInt != -1) {
        break label168;
      }
      if (!paramBoolean1) {
        break label149;
      }
      paramInt = 0;
    }
    label143:
    label149:
    label168:
    for (;;)
    {
      for (;;)
      {
        V("gAudioSetInput", paramInt);
        paramLong = jji.B(this.mApp.getCurrentAccountUin());
        synchronized (this.hZ)
        {
          if (this.hZ.size() > 1)
          {
            paramInt = 1;
            if ((!paramBoolean1) && (paramInt != 0)) {
              a(this.kJ, new long[] { paramLong }, paramBoolean1, 0);
            }
            return;
            paramBoolean2 = false;
            break;
            paramInt = 1;
            continue;
          }
          paramInt = 0;
        }
      }
    }
  }
  
  void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "sendSharpMsg selfUin: " + paramString + ", toUin: " + jji.al(paramLong) + ", uinType = " + b().uinType);
    }
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), iho.class);
    if (b().uinType == 25) {
      localNewIntent.putExtra("reqType", 18);
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "0X80088AF", "0X80088AF", 0, 0, "", "", "", "");
      localNewIntent.putExtra("selfuin", jji.B(paramString));
      localNewIntent.putExtra("toUin", paramLong);
      localNewIntent.putExtra("vMsg", paramArrayOfByte);
      a(localNewIntent);
      return;
      localNewIntent.putExtra("reqType", 4);
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "saveRandomFace uin: " + paramString + ", anonymous: " + paramBoolean);
    }
    if (!sw()) {}
    do
    {
      do
      {
        return;
        if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.mApp.getAccount())))
        {
          if (paramBoolean)
          {
            b().jdField_a_of_type_Iiv$a.bc = paramBitmap;
            return;
          }
          b().jdField_a_of_type_Iiv$a.bb = paramBitmap;
          return;
        }
        if (b().jdField_a_of_type_Iiv$a.chatType != 3) {
          break;
        }
        b localb = a(paramString);
        if (localb != null)
        {
          localb.faceBitmap = paramBitmap;
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "saveRandomFace uin:" + paramString + ", audiofrind null");
      return;
    } while (b().jdField_a_of_type_Iiv$a.chatType != 1);
    b().jdField_a_of_type_Iiv$a.ba = paramBitmap;
  }
  
  public void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage)
  {
    igd.aK(TAG, String.format("onReceiveCreativeCopMsg|type=%d, id=%s", new Object[] { Long.valueOf(paramAVFunChatMessage.uint64_type.get()), paramAVFunChatMessage.str_msg.get() }));
    this.mApp.l(new Object[] { Integer.valueOf(173), paramString, paramAVFunChatMessage });
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    iiv localiiv = null;
    if (this.jdField_b_of_type_Igv != null) {
      localiiv = this.jdField_b_of_type_Igv.c(paramString2);
    }
    if (this.mApp == null) {}
    for (String str = "mApp is null";; str = this.mApp.getCurrentAccountUin())
    {
      QLog.w(TAG, 1, "sendStopVideoBroadcast[" + paramString1 + "], sessionId[" + paramString2 + "], uinType[" + paramInt1 + "], peerUin[" + paramString3 + "], extraUin[" + paramString4 + "], stopReason[" + paramInt2 + "], senderUin[" + paramString5 + "], isSystemCalling[" + paramBoolean1 + "], selfUin[" + str + "], isDouble[" + paramBoolean2 + "], session[" + localiiv + "]");
      if ((this.mApp != null) && (localiiv != null) && (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)) {
        break;
      }
      return;
    }
    paramString1 = new Intent();
    paramString1.setPackage(this.mApp.getApp().getPackageName());
    paramString1.setAction("tencent.av.v2q.StopVideoChat");
    paramString1.putExtra("sessionId", paramString2);
    paramString1.putExtra("uinType", paramInt1);
    paramString1.putExtra("bindType", localiiv.bindType);
    paramString1.putExtra("bindId", localiiv.MX);
    paramString1.putExtra("peerUin", paramString3);
    paramString1.putExtra("sessionType", localiiv.amI);
    paramString1.putExtra("isDoubleVideoMeeting", localiiv.Qw);
    paramString1.putExtra("extraUin", paramString4);
    paramString1.putExtra("stopReason", paramInt2);
    paramString1.putExtra("isSystemCalling", paramBoolean1);
    paramString1.putExtra("isDouble", paramBoolean2);
    paramString1.putExtra("selfUin", this.mApp.getCurrentAccountUin());
    paramString1.putExtra(VideoConstants.Md, localiiv.lj);
    paramString1.putExtra(VideoConstants.Me, SystemClock.elapsedRealtime());
    paramString1.putExtra(VideoConstants.Mf, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getSdkVersion());
    paramString1.putExtra("score_connect_duration", bt());
    long l = 0L;
    if ((localiiv.amI == 1) || (localiiv.amI == 2)) {
      l = 1L;
    }
    if ((localiiv.amI == 3) || (localiiv.amI == 4)) {
      l = 2L;
    }
    paramString1.putExtra(VideoConstants.Mi, l);
    if ((localiiv.amI == 1) || (localiiv.amI == 3)) {}
    for (l = 1L;; l = 0L)
    {
      paramString1.putExtra(VideoConstants.Mj, l);
      if (this.jdField_b_of_type_Igv.c(paramString2).actId != null) {
        paramString1.putExtra("actId", this.jdField_b_of_type_Igv.c(paramString2).actId);
      }
      if (this.jdField_b_of_type_Igv.c(paramString2).MU != null) {
        paramString1.putExtra("mp_ext_params", this.jdField_b_of_type_Igv.c(paramString2).MU);
      }
      if (!paramBoolean2)
      {
        paramString1.putExtra("relationType", this.jdField_b_of_type_Igv.c(paramString2).relationType);
        paramString1.putExtra("relationId", this.jdField_b_of_type_Igv.c(paramString2).ll);
        if (!TextUtils.isEmpty(paramString5)) {
          break label661;
        }
        paramString1.putExtra("senderUin", "");
      }
      for (;;)
      {
        this.mApp.getApp().sendBroadcast(paramString1);
        return;
        imp.a().a.aol();
        break;
        label661:
        paramString1.putExtra("senderUin", paramString5);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt, long paramLong)
  {
    if ((this.OB != paramBoolean) || (this.alr != paramInt) || (this.kJ != paramLong) || (QLog.isColorLevel())) {
      QLog.i(TAG, 1, String.format("updateCurJoinGRoomInfo, from[%s], [%s, %s, %s] --> [%s, %s, %s]", new Object[] { paramString, Boolean.valueOf(this.OB), Integer.valueOf(this.alr), Long.valueOf(this.kJ), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    }
    this.OB = paramBoolean;
    this.kJ = paramLong;
    this.alr = paramInt;
  }
  
  public void a(NewIntent paramNewIntent)
  {
    try
    {
      this.mApp.startServlet(paramNewIntent);
      return;
    }
    catch (Exception paramNewIntent)
    {
      QLog.w(TAG, 1, "sendMsg, Exception", paramNewIntent);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    if (b().amI != 2) {
      return;
    }
    try
    {
      this.mApp.l(new Object[] { Integer.valueOf(10002), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
      return;
    }
    catch (NullPointerException paramString) {}
  }
  
  public void a(boolean paramBoolean, int paramInt, int... paramVarArgs)
  {
    long l1 = AudioHelper.hG();
    paramVarArgs = b();
    if (paramVarArgs.state == 0) {}
    do
    {
      do
      {
        return;
        jko localjko = jko.a(this.mApp);
        if (localjko != null) {
          localjko.cancelNotification(paramVarArgs.sessionId);
        }
        QLog.w(TAG, 1, "closeMainSession, mGAudioInRoom[" + this.OB + "], isDoubleVideoMeeting[" + paramVarArgs.Qw + "], \nsession[" + paramVarArgs + "], \nseq[" + l1 + "]");
        if ((sw()) || (sx()))
        {
          hI(true);
          return;
        }
        if ((paramVarArgs.amI != 3) && (paramVarArgs.amI != 4)) {
          break;
        }
      } while (!this.OB);
      if (paramBoolean) {
        this.mApp.l(new Object[] { Integer.valueOf(28), String.valueOf(paramVarArgs.ll), Boolean.valueOf(true) });
      }
      if (paramVarArgs.Qw)
      {
        b(l1, this.kJ, true, 0);
        return;
      }
      b(this.alr, this.kJ, 30);
      return;
    } while ((paramVarArgs.amI != 1) && (paramVarArgs.amI != 2));
    if ((paramVarArgs.state == 2) || (paramVarArgs.state == 13))
    {
      if (paramVarArgs.Qw)
      {
        a(l1, paramVarArgs.peerUin, 1, true);
        long l2 = Long.valueOf(paramVarArgs.peerUin).longValue();
        c(l1, 3, l2);
        f(l1, l2, 1);
        return;
      }
      a(l1, paramVarArgs.peerUin, 1, false);
      O(paramVarArgs.peerUin, paramInt);
      P(paramVarArgs.peerUin, 0);
      return;
    }
    if (paramVarArgs.Qw)
    {
      if (paramBoolean) {
        this.mApp.l(new Object[] { Integer.valueOf(28), paramVarArgs.peerUin, Boolean.valueOf(true) });
      }
      b(l1, Long.valueOf(paramVarArgs.peerUin).longValue(), true, 0);
      return;
    }
    O(paramVarArgs.peerUin, paramInt);
    P(paramVarArgs.peerUin, 0);
    a(l1, 2, true, true);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    ihk.a(paramArrayOfByte);
    if (this.jdField_a_of_type_Imj == null)
    {
      anot.a(null, "CliOper", "", "", "0X80088AE", "0X80088AE", 0, 0, "", "", "", "");
      a(this.mApp.getCurrentAccountUin(), paramLong, paramArrayOfByte);
      return;
    }
    this.jdField_a_of_type_Imj.a(paramArrayOfByte, paramLong);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.K = paramArrayOfFloat;
  }
  
  public void a(long[] paramArrayOfLong)
  {
    String str = this.mApp.getCurrentAccountUin();
    if (str != null)
    {
      long l = jji.B(str);
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setInviteUserList(l, paramArrayOfLong);
      }
    }
  }
  
  public void a(long[] paramArrayOfLong, boolean paramBoolean)
  {
    QLog.w(TAG, 1, "inviteNewMemJoin, uinList[" + paramArrayOfLong + "], needNotifyUI[" + paramBoolean + "], mMultiInviteEntranceFlag[" + this.alw + "]");
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {}
    do
    {
      return;
      if (this.alw == 1)
      {
        int j = paramArrayOfLong.length;
        long[] arrayOfLong = new long[j * 2];
        i = 0;
        while (i < j)
        {
          arrayOfLong[(i * 2)] = 1L;
          arrayOfLong[(i * 2 + 1)] = paramArrayOfLong[i];
          i += 1;
        }
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(arrayOfLong, j, null, 0, 0, false, false, 4);
        i = 0;
        while (i < j)
        {
          if (!b().id.contains(Long.valueOf(paramArrayOfLong[i]))) {
            b().id.add(Long.valueOf(paramArrayOfLong[i]));
          }
          i += 1;
        }
      }
    } while (!paramBoolean);
    int i = paramArrayOfLong.length;
    this.mApp.l(new Object[] { Integer.valueOf(68), Long.valueOf(paramArrayOfLong[0]), Integer.valueOf(i) });
  }
  
  public boolean a(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      alE();
    }
    int j = -999;
    int i = j;
    if (paramLong > 0L)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        this.OQ = true;
        if (paramInt1 != 1) {
          break label139;
        }
        i = paramInt2;
      }
    }
    for (;;)
    {
      i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeUpdateRoomInfo(paramInt1, paramLong, i, true, true, true);
      QLog.w(TAG, 1, "getGAudioRoomMemList, relationType[" + paramInt1 + "], discussId[" + paramLong + "], avtype[" + paramInt2 + "], result[" + i + "]");
      if (i != 0) {
        break;
      }
      return true;
      label139:
      if (paramInt1 == 2) {
        i = 1;
      } else if (paramInt1 == 3) {
        i = 8;
      } else {
        i = 0;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3)
  {
    QLog.d(TAG, 1, "avideo isRequestVideo uinType = " + paramInt1 + ", fromUin = " + paramString1 + ", extraUin = " + paramString2 + ", sig = " + paramArrayOfByte + ", onlyAudio = " + paramBoolean + ", bindID=" + paramString3 + " ,bindType=" + paramInt2);
    if ((this.mApp == null) || (this.mApp.getApp() == null))
    {
      QLog.d(TAG, 1, "isRequestVideo  faile,app is null, return false");
      return false;
    }
    paramBoolean = cn(paramString1);
    if ((paramInt1 == 19) && (!TextUtils.isEmpty(paramString1))) {}
    for (paramInt2 = this.mApp.aj(paramString1);; paramInt2 = a(paramInt1, false, paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "isRequestVideo converted uinType = " + paramInt2 + ",sdkAVAccostType = " + paramInt1 + "|" + VideoConstants.Ow + ", isVideoPaused: " + this.mApp.isBackground_Pause);
      }
      if (this.jdField_b_of_type_Igv.kv() < 2) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "isRequestVideo->pending session exists");
      }
      paramInt1 = -1;
      paramString2 = null;
      if (b() != null)
      {
        paramInt1 = b().uinType;
        paramString2 = b().peerUin;
      }
      if ((paramInt2 == 1011) && (paramInt1 == 1011) && (paramString2 != null) && (paramString2.equals(paramString1))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "isRequestVideo->pending session exists, return false");
      }
      return false;
    }
    boolean bool = isScreenLocked(this.mApp.getApp().getApplicationContext());
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isRequestVideo->isScreenLocked:" + bool);
    }
    if ((paramInt2 != 21) && (paramInt2 != 1011) && ((b().jdField_a_of_type_Iiv$a.anA > 0) || (this.OD)) && (b().jdField_a_of_type_Iiv$a.chatType == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "isRequestVideo when in Random Double");
      }
      if (bool) {
        return false;
      }
    }
    else if ((b().jdField_a_of_type_Iiv$a.anA > 0) && (b().jdField_a_of_type_Iiv$a.chatType == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "isRequestVideo when in Random mulit");
      }
      if (bool) {
        return false;
      }
    }
    else if (b().sY())
    {
      if (paramInt2 == -1) {
        return false;
      }
    }
    else if (((b().state == 7) && (this.kM != 0L)) || (b().state == 14) || (b().state == 13))
    {
      if (bool) {
        return false;
      }
    }
    else if (!this.OB)
    {
      if (((paramInt2 == 21) || (paramInt2 == 1011)) && (b().jdField_a_of_type_Iiv$a.nickName != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "isRequestVideo  auto Accept");
        }
        if ((b().jdField_a_of_type_Iiv$a.peerUin != null) && (!b().jdField_a_of_type_Iiv$a.peerUin.equals(paramString1))) {
          return false;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "isRequestVideo when chatting: fromUin = " + paramString1 + "|" + bool);
        }
        if ((b().peerUin != null) && (paramString1.equals(b().peerUin)))
        {
          igd.aK(TAG, "isRequestVideo when request: fromUin = " + paramString1);
          return false;
        }
        if (bool) {
          return false;
        }
      }
    }
    else if ((this.OB) || (b().state == 8))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "isRequestVideo when in group chat, fromUin = " + paramString1);
      }
      if (bool) {
        return false;
      }
    }
    else if ((b().state == 1) && (b().peerUin != null) && (paramString1.equals(b().peerUin)))
    {
      return false;
    }
    if (this.mApp.sM()) {
      return false;
    }
    if (paramBoolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isRequestVideo orientation: " + this.mOrientation + ", isQQPaused: " + VideoConstants.Ow + ", isVideoPaused: " + this.mApp.isBackground_Pause + ", isScreenLocked: " + bool + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(getAppContext()));
    }
    return true;
  }
  
  public boolean a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return false;
    }
    for (;;)
    {
      boolean bool;
      synchronized (this.hZ)
      {
        int i = this.hZ.size();
        paramInt2 = 0;
        if (paramInt2 >= i) {
          break label173;
        }
        b localb = (b)this.hZ.get(paramInt2);
        if ((localb == null) || (localb.uin != paramLong)) {
          break label186;
        }
        localb.Pk = paramBoolean;
        localb.accountType = paramInt1;
        bool = localb.Pm;
        if (paramBoolean)
        {
          localb.Pm = false;
          paramBoolean = bool;
          return paramBoolean;
        }
      }
      if (localObject.Pl)
      {
        localObject.Pl = false;
        this.mApp.l(new Object[] { Integer.valueOf(157), Long.valueOf(paramLong), Boolean.valueOf(false) });
        paramBoolean = bool;
        continue;
        label173:
        paramBoolean = false;
      }
      else
      {
        paramBoolean = bool;
        continue;
        label186:
        paramInt2 += 1;
      }
    }
  }
  
  boolean a(long paramLong, int paramInt, ArrayList<ioa> paramArrayList)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramArrayList.size())
      {
        if ((((ioa)paramArrayList.get(i)).uin == paramLong) && (((ioa)paramArrayList.get(i)).videoSrcType == paramInt)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean a(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.QuaReport(paramLong1, paramLong2, paramLong3, paramInt, paramLong4);
    }
    if (QLog.isColorLevel()) {}
    return false;
  }
  
  public boolean a(iiv paramiiv1, iiv paramiiv2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramiiv1.peerUin);
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          boolean bool1;
          VideoAppInterface localVideoAppInterface = this.mApp;
          paramiiv2.n(paramLong1, paramiiv1.PY);
          a(paramString, paramiiv2.amI, false, false, false);
          if ((this.aZ != null) && (localVideoAppInterface != null)) {
            localVideoAppInterface.getHandler().removeCallbacks(this.aZ);
          }
          if (!paramiiv1.sU()) {
            a(paramLong1, 2131230749, 1, null);
          }
          int i = paramiiv1.amI;
          paramiiv2.Rp = true;
          paramiiv2.peerUin = paramiiv1.peerUin;
          if ((paramiiv1.state == 15) || (paramiiv1.Qx)) {
            hH(false);
          }
          paramiiv1.bs(3, 12);
          if (i == 1)
          {
            paramiiv1.e(paramLong1, "onGAudioInvite.6", 3);
            paramiiv1.uinType = jll.cM(paramInt);
            paramiiv1.ll = paramLong3;
            if (paramArrayOfLong != null) {
              paramiiv1.f = paramArrayOfLong;
            }
            paramiiv1.aa("onGAudioInvite.1", 1);
            if (localVideoAppInterface != null)
            {
              if (localVideoAppInterface.countObservers() <= 0) {
                break label522;
              }
              paramiiv1.ac("onGAudioInvite3", jjc.cH(paramiiv1.uinType));
              localVideoAppInterface.l(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            }
            paramiiv2 = jko.a(localVideoAppInterface);
            int j = 0;
            if (paramiiv2 != null)
            {
              boolean bool2 = paramiiv2.isActive();
              j = bool2;
              if (bool2)
              {
                paramiiv2.cancelNotification(paramiiv1.sessionId);
                j = bool2;
              }
            }
            if (j != 0) {
              alx();
            }
            return bool1;
            localThrowable = localThrowable;
            localThrowable.printStackTrace();
            continue;
            bool1 = false;
            continue;
          }
          if (i == 2)
          {
            paramiiv1.e(paramLong1, "onGAudioInvite.7", 4);
            continue;
          }
          if (i != 4) {
            break label510;
          }
        }
        catch (Exception paramiiv1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "onGAudioInviteError-->Exception=" + paramiiv1.getMessage());
          }
          this.jdField_b_of_type_Igv.c(paramLong1, paramString);
          return bool1;
        }
        paramiiv1.e(paramLong1, "onGAudioInvite.8", 4);
        continue;
        label510:
        paramiiv1.e(paramLong1, "onGAudioInvite.9", 3);
        continue;
        label522:
        if (localThrowable.isBackground_Stop)
        {
          paramiiv1.ac("onGAudioInvite4", 0);
          a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
          hO(false);
        }
      }
    }
    if ((l1 == paramLong2) && (paramiiv1.Qy))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "dealSwitchP2PShare ], peerUin[" + l1 + "], friendUin[" + paramLong2 + "], isTurnDoubleVideoMeeting2Multi[" + paramiiv1.Qy + "], ret[" + bool1 + "], main[" + paramiiv1 + "], new[" + paramiiv2 + "]");
      }
      paramiiv1.Qy = false;
      if (!bool1) {
        break label559;
      }
    }
    label559:
    return false;
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    long l = getChatRoomId(paramString);
    boolean bool = a(t(this.mApp.getCurrentAccountUin()), t(paramString), l, paramInt, paramLong);
    QLog.d(TAG, 1, "QuaReport --> report result = " + bool + " | node = " + paramInt + " | timestamp = " + paramLong);
    return bool;
  }
  
  public boolean a(String paramString, iiv paramiiv)
  {
    boolean bool2;
    if (paramiiv == null)
    {
      bool2 = false;
      return bool2;
    }
    boolean bool1 = false;
    int i = paramiiv.kN();
    long l1 = paramiiv.getRoomId();
    long l2 = paramiiv.kO();
    long l3;
    if (i == 2)
    {
      l3 = a(paramiiv);
      if (l3 != paramiiv.getRoomId()) {
        paramiiv.bP(l3);
      }
    }
    for (;;)
    {
      l3 = paramiiv.getRoomId();
      long l4 = paramiiv.kO();
      if ((l1 != l3) || (l2 != l4)) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ChatRoomUtil", 2, String.format("checkRoomIdChange, from[%s], ret[%s], session[%s], pre[%s, %s], cur[%s, %s]", new Object[] { paramString, Boolean.valueOf(bool1), paramiiv, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) }));
      return bool1;
      if (i == 1)
      {
        l3 = b(paramiiv);
        if (l3 != paramiiv.getRoomId()) {
          paramiiv.bP(l3);
        }
      }
    }
  }
  
  public boolean a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    iiv localiiv = b();
    String str;
    boolean bool;
    if (paramBoolean) {
      if (paramInt == 3)
      {
        str = igv.a(100, paramString2, new int[0]);
        if (TextUtils.equals(localiiv.sessionId, str)) {
          break label231;
        }
        bool = igv.a().cj(str);
        QLog.i(TAG, 1, "checkMainSession, need reset main session, from[" + paramString1 + "], cur" + localiiv.sessionId + "], coming[" + str + "], ret[" + bool + "]");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "checkMainSession, from[" + paramString1 + "], isFromMAVEngine[" + paramBoolean + "], relationType[" + paramInt + "], relationId[" + paramString2 + "], ret[" + bool + "]");
      }
      return bool;
      str = igv.a(paramInt, paramString2, new int[0]);
      break;
      str = igv.a(paramInt, paramString2, new int[0]);
      break;
      label231:
      bool = false;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.postData(paramLong2, paramArrayOfByte);
  }
  
  public ArrayList<b> aL()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = aN().iterator();
    b localb;
    while (localIterator.hasNext())
    {
      localb = (b)localIterator.next();
      localArrayList.add(localb);
      localHashSet.add(Long.valueOf(localb.uin));
    }
    localIterator = aM().iterator();
    while (localIterator.hasNext())
    {
      localb = (b)localIterator.next();
      if (!localHashSet.contains(Long.valueOf(localb.uin)))
      {
        localb.Pn = false;
        localArrayList.add(localb);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<b> aM()
  {
    if ((AudioHelper.isDev()) && (jht.b.ja != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.hY);
      localArrayList.addAll(jht.b.ja);
      return localArrayList;
    }
    return this.hY;
  }
  
  public void aM(String paramString1, String paramString2)
  {
    this.mApp.l(new Object[] { Integer.valueOf(162), paramString1, paramString2 });
  }
  
  public ArrayList<b> aN()
  {
    synchronized (this.hZ)
    {
      if ((AudioHelper.isDev()) && (jht.b.ja != null))
      {
        localArrayList2 = new ArrayList();
        localArrayList2.addAll(this.hZ);
        localArrayList2.addAll(jht.b.ja);
        return localArrayList2;
      }
      ArrayList localArrayList2 = this.hZ;
      return localArrayList2;
    }
  }
  
  public ArrayList<ResultRecord> aO()
  {
    synchronized (this.hZ)
    {
      Object localObject = aN();
      ArrayList localArrayList2 = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.uin = String.valueOf(localb.uin);
        localArrayList2.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<b> aP()
  {
    if ((AudioHelper.isDev()) && (jht.b.ja != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.ib);
      localArrayList.addAll(jht.b.ja);
      return localArrayList;
    }
    return this.ib;
  }
  
  public ArrayList<Long> aQ()
  {
    ArrayList localArrayList = new ArrayList();
    if (b() == null) {
      return localArrayList;
    }
    Iterator localIterator = b().id.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Long)localIterator.next());
    }
    localIterator = aN().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.accountType == 0) && (localArrayList.contains(Long.valueOf(localb.uin)))) {
        localArrayList.remove(Long.valueOf(localb.uin));
      }
    }
    return localArrayList;
  }
  
  void abandonAudioFocus()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
      this.jdField_a_of_type_AndroidMediaAudioManager = null;
    }
  }
  
  void acV()
  {
    if (this.mAudioFocusChangeListener == null) {
      this.mAudioFocusChangeListener = new ihc(this);
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.appContext.getSystemService("audio"));
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {}
    try
    {
      int i = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 2);
      if ((i != 1) && (QLog.isColorLevel())) {
        QLog.d("AudioManager", 2, "request audio focus fail. " + i);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Intent localIntent;
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "requestAudioFocus e = " + localException);
        }
      }
    }
    localIntent = new Intent("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED");
    localIntent.setPackage(this.mApp.getApp().getPackageName());
    this.mApp.getApp().sendBroadcast(localIntent);
  }
  
  public int af(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.UpdateSelfUin(paramString);
    }
    return -1;
  }
  
  public void ag(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, String.format("onRecvSharpOfflineMsg data=%s", new Object[] { paramBundle }));
    }
    alw();
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    boolean bool = paramBundle.getBoolean("isRequest");
    ak(paramBundle);
    long l = paramBundle.getLong("msf_timestamp");
    l(paramBundle.getString("fromUin"), l);
    QLog.d(TAG, 1, "QuaReport --> onRecvSharpOfflineMsg msf_timestamp = " + l);
    int i = a(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue(), arrayOfByte, null);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "receiveSharpVideoCall result: " + i + ", buf.length: " + arrayOfByte.length);
    }
    if ((bool) && (this.alq == -1)) {
      this.alq = 1;
    }
  }
  
  public int ah(String paramString)
  {
    paramString = b();
    if ((paramString != null) && (paramString.PR)) {
      return 1;
    }
    return 0;
  }
  
  public void ah(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, String.format("onRecvMultiVideoOfflineMsg data=%s", new Object[] { paramBundle }));
    }
    alw();
    if (this.OB) {}
    do
    {
      return;
      paramBundle = paramBundle.getByteArray("buffer");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
        alE();
      }
    } while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null);
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onNativeRecvGAudioCMD(this.alC, paramBundle);
  }
  
  public void ai(Bundle paramBundle)
  {
    alw();
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    String str = paramBundle.getString("fromUin");
    boolean bool = paramBundle.getBoolean("isFriend");
    int i = a(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue(), arrayOfByte, null);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onRecvSharpVideoCallData: selfUin = " + this.mApp.getCurrentAccountUin() + ", fromUin = " + str + ", result = " + i + ",isFriend:" + bool);
    }
    this.alq = 0;
    if ((b().uinType == 1006) && (!b().PT) && (!str.equals(this.mApp.getCurrentAccountUin())))
    {
      b().MP = str;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onRecvSharpVideoCallData: CONTACT_STRANGER_FRIEND  peerUin = " + str);
      }
    }
  }
  
  public void aj(Bundle paramBundle)
  {
    alw();
    paramBundle = paramBundle.getByteArray("buffer");
    int i = b(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue(), paramBundle, null);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onRecvSharpVideoAck: result = " + i);
    }
  }
  
  void alA()
  {
    long l = AudioHelper.hG();
    if (this.ba == null)
    {
      this.ba = new VideoController.18(this, l);
      if ((this.mApp != null) && (this.ba != null)) {
        this.mApp.getHandler().postDelayed(this.ba, 15000L);
      }
    }
  }
  
  void alB()
  {
    GraphicRenderMgr.getInstance().decoderPtrRef = 0;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0L);
    }
  }
  
  void alC()
  {
    if (this.mApp != null) {
      this.mApp.getHandler().postDelayed(this.aW, 25000L);
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "startConnectingTimer");
    }
  }
  
  void alD()
  {
    if (this.mApp != null) {
      this.mApp.getHandler().removeCallbacks(this.aW);
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "stopConnectingTimer");
    }
  }
  
  public void alE()
  {
    boolean bool = imm.isSupportSharpAudio();
    QLog.d(TAG, 1, String.format("initGAudioCtrl isSupportSharpAudio=%s mGAudioCtrl=%s ", new Object[] { Boolean.valueOf(bool), this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl }));
    if (!bool) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = QQGAudioCtrl.getGAudioCtrlInstance();
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
        {
          long l = jji.B(this.mApp.getCurrentAccountUin());
          int i = getApn();
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.SetVideoController(this);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAppid(this.mApp.getAppid());
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.init(this.appContext, l, 1, "3.4.4");
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i);
          if (!TextUtils.isEmpty(this.Mn)) {
            this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetIPAndPort(this.Mn, this.aly);
          }
          GAClientLogReport.instance();
          return;
        }
        QLog.e(TAG, 1, "initGAudioCtrl create instance fail.");
        kq(1014);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TAG, 1, "initGAudioCtrl fail.", localThrowable);
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
      kq(1014);
    }
  }
  
  public void alF()
  {
    if (this.OB)
    {
      long l = this.kJ;
      b(this.alr, this.kJ, 50);
      this.mApp.l(new Object[] { Integer.valueOf(66), Long.valueOf(l) });
    }
  }
  
  public void alG()
  {
    this.mApp.l(new Object[] { Integer.valueOf(307) });
  }
  
  public void alH()
  {
    if (!this.OB) {
      b().Y("clearGAudioState", 0);
    }
  }
  
  public void alI()
  {
    long l;
    if (this.OB) {
      l = jji.B(this.mApp.getCurrentAccountUin());
    }
    synchronized (this.hZ)
    {
      int i;
      if ((this.hZ.size() == 1) && (this.hZ.get(0) != null) && (l == ((b)this.hZ.get(0)).uin))
      {
        i = 1;
        if (i != 0) {
          b().Y("setGAudioState.1", 9);
        }
      }
      else
      {
        i = 0;
      }
    }
    b().Y("setGAudioState.2", 10);
  }
  
  public void alJ()
  {
    QLog.d(TAG, 1, "requestStartTimerOfMemberLists");
    this.mApp.getHandler().removeCallbacks(this.be);
    this.mApp.getHandler().postDelayed(this.be, 3000L);
  }
  
  public void alK()
  {
    QLog.d(TAG, 1, "requestStopTimerOfMemberLists");
    this.mApp.getHandler().removeCallbacks(this.be);
  }
  
  public void alL()
  {
    if ((b().state == 4) || (b().state == 10) || (b().state == 14) || (b().jdField_a_of_type_Iiv$a.anA >= 4))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "Chatting Timer-->Start");
      }
      this.mApp.getHandler().removeCallbacks(this.bf);
      this.mApp.getHandler().postDelayed(this.bf, 1000L);
    }
  }
  
  public void alM()
  {
    this.mApp.getHandler().removeCallbacks(this.bf);
  }
  
  public void alN()
  {
    int i;
    if (b().jdField_if.size() > 0)
    {
      if (getVideoAbilityLevel() == 4) {
        break label420;
      }
      i = b().kK();
      if (i != -1) {
        break label71;
      }
      ((ioa)b().jdField_if.get(0)).Tp = true;
      ((ioa)b().jdField_if.get(0)).Tq = true;
    }
    label71:
    do
    {
      for (;;)
      {
        return;
        ioa localioa1 = (ioa)b().jdField_if.get(i);
        localioa1.Tp = true;
        if (localioa1.uin == Long.valueOf(this.mApp.getCurrentAccountUin()).longValue())
        {
          if (i != 0)
          {
            localioa2 = (ioa)b().jdField_if.get(0);
            localioa2.Tp = false;
            b().jdField_if.set(0, localioa1);
            b().jdField_if.set(i, localioa2);
          }
          synchronized (b().ig)
          {
            b().ig.set(0, localioa1);
            b().ig.set(i, localioa2);
            b().amI();
            if (b().w(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue()) == -1)
            {
              i = 0;
              if (i < b().jdField_if.size())
              {
                if (((ioa)b().jdField_if.get(i)).uin != Long.valueOf(this.mApp.getCurrentAccountUin()).longValue()) {
                  ((ioa)b().jdField_if.get(i)).Tq = true;
                }
                i += 1;
              }
            }
          }
        }
      }
    } while (i == 0);
    ioa localioa2 = (ioa)b().jdField_if.get(0);
    localioa2.Tp = false;
    b().jdField_if.set(0, localObject1);
    b().jdField_if.set(i, localioa2);
    synchronized (b().ig)
    {
      b().ig.set(0, localObject1);
      b().ig.set(i, localioa2);
      b().amI();
      return;
    }
    label420:
    ((ioa)b().jdField_if.get(0)).Tp = true;
  }
  
  public void alO()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (b().relationType == 2) {
        anot.a(null, "CliOper", "", "", "0X80041B1", "0X80041B1", 0, 0, "", "", "", "");
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        int i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeStopVideoSend();
        if (QLog.isColorLevel()) {
          QLog.w(TAG, 1, "goOffStage, ret[" + i + "]");
        }
        return;
        if ((b().relationType == 1) && (b().anb == 10)) {
          anot.a(null, "CliOper", "", "", "0X8005937", "0X8005937", 0, 0, "", "", "", "");
        }
      }
    }
    QLog.e(TAG, 2, "goOffStage-->mGAudioCtrl is null");
  }
  
  public void alR()
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "startRandomTimeout, seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable == null) {
      this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = new AnyChatReqTimeoutRunnable();
    }
    this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable.seq = l;
    this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable, 30000L);
  }
  
  public void alS()
  {
    QLog.w(TAG, 1, "clearSelectMemberActivityIsResume, selectMemberActivityIsResume[" + this.alH + "]");
    this.alH = 0;
  }
  
  public void alT()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onHowling");
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setHowlingDetectEnable(false);
    if (imh.aa(this.appContext))
    {
      boolean bool1 = ss();
      if (!bool1)
      {
        int i = kB();
        a("onHowling", this.kJ, false, false, -1);
        f(-1L, i, kB());
        this.mApp.l(new Object[] { Integer.valueOf(109) });
      }
      boolean bool2 = b().QB;
      if (bool2) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axK();
      }
      PopupDialog.c(this.appContext, 230, null, this.appContext.getString(2131697808), 2131721058, 2131721079, new ihg(this), new ihh(this, bool1, bool2));
      anot.a(null, "CliOper", "", "", "0x8006992", "0x8006992", 0, 0, "", "", "", "");
    }
  }
  
  public void alU()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(TAG, 2, "WL_DEBUG onOpenMicFail");
    }
    if (this.appContext != null) {
      QQToast.a(this.appContext, 2131697895, 1).show();
    }
    Object localObject = b();
    if (localObject != null) {
      if (((iiv)localObject).relationType != 1) {
        break label64;
      }
    }
    label64:
    for (localObject = "0x8007CB5";; localObject = "0x8007CB6")
    {
      imr.iF((String)localObject);
      return;
    }
  }
  
  public void alV()
  {
    iiv localiiv = b();
    if (localiiv != null)
    {
      int j = localiiv.anp;
      int i = j;
      if (j == 0) {
        i = localiiv.YN;
      }
      setVoiceType(i);
      if ((i == 0) || (!localiiv.Rm)) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      enableLoopback(bool);
      return;
    }
  }
  
  public void alW()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.onProcessExit();
    }
  }
  
  public void alX()
  {
    long l = (System.currentTimeMillis() - this.kN) / 1000L;
    anot.a(null, "dc00899", "grp_lbs", "", "video_chat", "app_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l + "");
    anot.a(null, "dc00899", "grp_lbs", "", "video_chat", "visit_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", l + "", "");
    this.kN = 0L;
  }
  
  public void alY()
  {
    if (this.kO == 0L) {
      return;
    }
    long l = (System.currentTimeMillis() - this.kO) / 1000L;
    if (this.jdField_a_of_type_Ign == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Ign.uin)
    {
      anot.a(null, "dc00899", "grp_lbs", str, "video_chat", "video_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l + "");
      this.kO = 0L;
      return;
    }
  }
  
  public void alZ()
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "playRecordVoice, seq[" + l + "]");
    }
    a(l, 2131230752, 1, null);
  }
  
  public void alt()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "startNetWorkTimer");
    }
    if (this.OK) {
      this.mApp.getHandler().removeCallbacks(this.aV);
    }
    this.OK = true;
    this.mApp.getHandler().postDelayed(this.aV, 30000L);
  }
  
  public void alx()
  {
    int j = 3;
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      try
      {
        jko localjko = jko.a(this.mApp);
        localObject2 = b();
        if (!((iiv)localObject2).PT) {
          break label306;
        }
        if (((iiv)localObject2).tc())
        {
          if ((((iiv)localObject2).amI == 1) || (((iiv)localObject2).amI == 2))
          {
            if ((!((iiv)localObject2).QE) && (!((iiv)localObject2).Qw))
            {
              i = 56;
              if ((((iiv)localObject2).uinType != 1011) && (!sw())) {
                break label372;
              }
              i = ((iiv)localObject2).amI;
              if ((i == 3) || (i == 1)) {
                break label665;
              }
              if (((iiv)localObject2).relationType != 7) {
                break label695;
              }
              i = j;
              if (((iiv)localObject2).jdField_a_of_type_Iiv$a.anA <= 4) {
                break label344;
              }
              j = 52;
              if (this.OD)
              {
                j = 60;
                alM();
              }
              localjko.a(((iiv)localObject2).sessionId, "", null, null, j, ((iiv)localObject2).uinType, i);
              alL();
              return;
            }
            i = 55;
            continue;
          }
          localObject3 = String.valueOf(((iiv)localObject2).ll);
          localObject4 = ((iiv)localObject2).peerUin;
          localObject2 = ((iiv)localObject2).sessionId;
          Bitmap localBitmap = this.mApp.a(3000, (String)localObject3, null, true, true);
          localjko.a((String)localObject2, this.mApp.getDisplayName(1004, (String)localObject4, (String)localObject3), localBitmap, (String)localObject3, 57, 3000, 3);
          if (localBitmap != null) {
            continue;
          }
          this.mApp.getHandler().postDelayed(new VideoController.13(this, (String)localObject3, (String)localObject4, (String)localObject2), 1000L);
          continue;
        }
        if (((iiv)localObject2).amI != 1) {
          break label671;
        }
      }
      finally {}
      int i = 47;
      label306:
      if (((iiv)localObject2).isConnected())
      {
        if (((iiv)localObject2).amI != 1) {
          break label680;
        }
        i = 47;
      }
      else
      {
        if (((iiv)localObject2).amI != 1) {
          break label689;
        }
        i = 46;
        break label686;
        label344:
        localObject1.a(((iiv)localObject2).sessionId, "", null, null, 51, ((iiv)localObject2).uinType, i);
        alM();
        continue;
        label372:
        if ((((iiv)localObject2).amI == 3) || (((iiv)localObject2).amI == 4))
        {
          if (((iiv)localObject2).Qw)
          {
            localObject3 = ((iiv)localObject2).MO;
            localObject4 = this.mApp.a(0, ((iiv)localObject2).peerUin, null, true, true);
            localObject1.a(((iiv)localObject2).sessionId, (String)localObject3, (Bitmap)localObject4, String.valueOf(((iiv)localObject2).ll), 48, 0, ((iiv)localObject2).amI);
            continue;
          }
          localObject3 = this.mApp.getDisplayName(b().uinType, String.valueOf(b().ll), null);
          localObject4 = this.mApp.a(((iiv)localObject2).uinType, String.valueOf(((iiv)localObject2).ll), null, true, true);
          if (localObject4 != null)
          {
            localObject1.a(((iiv)localObject2).sessionId, (String)localObject3, (Bitmap)localObject4, String.valueOf(((iiv)localObject2).ll), 44, ((iiv)localObject2).uinType, ((iiv)localObject2).amI);
            continue;
          }
          this.mApp.getHandler().postDelayed(new VideoController.14(this), 1000L);
          continue;
        }
        if (((iiv)localObject2).MO == null) {
          ((iiv)localObject2).MO = this.mApp.getDisplayName(((iiv)localObject2).uinType, ((iiv)localObject2).peerUin, ((iiv)localObject2).MP);
        }
        localObject3 = this.mApp.a(((iiv)localObject2).uinType, ((iiv)localObject2).peerUin, ((iiv)localObject2).MP, true, true);
        localObject1.a(((iiv)localObject2).sessionId, ((iiv)localObject2).MO, (Bitmap)localObject3, null, i, ((iiv)localObject2).uinType, ((iiv)localObject2).amI);
        continue;
        continue;
        for (;;)
        {
          break;
          i = 42;
        }
      }
      for (;;)
      {
        label665:
        label671:
        break;
        label680:
        i = 42;
      }
      for (;;)
      {
        label686:
        break;
        label689:
        i = 41;
      }
      label695:
      i = 1;
    }
  }
  
  void aly()
  {
    if (this.aY == null)
    {
      this.aY = new VideoController.16(this);
      if ((this.mApp != null) && (this.aY != null)) {
        this.mApp.getHandler().postDelayed(this.aY, 20000L);
      }
    }
  }
  
  void alz()
  {
    if (this.aZ == null) {
      this.aZ = new VideoController.17(this);
    }
    if ((this.mApp != null) && (this.aZ != null)) {
      this.mApp.getHandler().postDelayed(this.aZ, 5000L);
    }
  }
  
  public void ama()
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "playRecordDing, seq[" + l + "]");
    }
    if (sB())
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG + "Q.nearby.video_chat", 2, "not playRing");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.dN(l);
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(l, this.mApp, 2131230751, null, 1, null);
  }
  
  void amd()
  {
    if (this.mApp != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.sdk.onRequestVideo");
      localIntent.setPackage(this.mApp.getApp().getPackageName());
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void ame()
  {
    switch (aqiw.getSystemNetwork(null))
    {
    default: 
      kv(0);
      return;
    case 0: 
      kv(3);
      return;
    }
    amf();
  }
  
  public void amg()
  {
    iiv localiiv = b();
    long l = AudioHelper.hG();
    String str;
    int i;
    if ((localiiv.isConnected()) || (localiiv.td()) || (localiiv.state == 9) || (localiiv.te()))
    {
      ivv.a(l, this.mApp, 2);
      str = localiiv.sessionId;
      i = localiiv.amI;
      if (localiiv.state == 9) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      a(str, i, false, bool, localiiv.tn());
      QLog.w(TAG, 1, "reNotifyChatInfo2QQ, sessionInfo[" + localiiv + "]");
      return;
    }
  }
  
  public int b(iiv paramiiv, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomUserSdkVersion(paramiiv, paramString);
    }
    return -1;
  }
  
  public int b(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, String.format("setAudioInputMute enable=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    ihm localihm = this.mApp.a();
    if (localihm != null) {
      localihm.aml();
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.SetAudioInputMute(paramString, paramBoolean);
  }
  
  public long b(iiv paramiiv)
  {
    if (paramiiv == null) {
      return 0L;
    }
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) && ((paramiiv.amI == 3) || (paramiiv.amI == 4)))
    {
      qav_gvideo_sdk_transfer.RespInfo localRespInfo = a(paramiiv.relationType, paramiiv.anb, paramiiv.ll);
      if (localRespInfo.uint32_result.get() == 0)
      {
        paramiiv.bP(localRespInfo.gAudioInfo.uint64_roomId.get());
        paramiiv.kG(localRespInfo.gAudioInfo.uint32_roomCreateTime.get());
      }
    }
    return paramiiv.getRoomId();
  }
  
  public Bitmap b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getRandomFaceFromCache uin: " + paramString + ", anonymous: " + paramBoolean);
    }
    if (paramString == null) {}
    label127:
    do
    {
      b localb;
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
            } while (b().uinType == 25);
            if (!paramString.equals(this.mApp.getAccount())) {
              break label127;
            }
            if (!paramBoolean) {
              break;
            }
          } while (b().jdField_a_of_type_Iiv$a.bc == null);
          return b().jdField_a_of_type_Iiv$a.bc;
        } while (b().jdField_a_of_type_Iiv$a.bb == null);
        return b().jdField_a_of_type_Iiv$a.bb;
        if (b().jdField_a_of_type_Iiv$a.chatType != 3) {
          break;
        }
        localb = a(paramString);
      } while ((localb == null) || (localb.faceBitmap == null));
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getRandomFaceFromCache uin: " + paramString + ", face :" + localb.faceBitmap);
      }
      return localb.faceBitmap;
    } while ((b().jdField_a_of_type_Iiv$a.chatType != 1) || (b().jdField_a_of_type_Iiv$a.ba == null));
    return b().jdField_a_of_type_Iiv$a.ba;
  }
  
  public iiv b()
  {
    return this.jdField_b_of_type_Igv.a();
  }
  
  /* Error */
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 634	com/tencent/mobileqq/utils/AudioHelper:hG	()J
    //   5: lstore 12
    //   7: aload_0
    //   8: getfield 440	com/tencent/av/VideoController:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   11: astore 18
    //   13: iload_1
    //   14: lload_2
    //   15: invokestatic 613	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   18: iconst_0
    //   19: newarray int
    //   21: invokestatic 578	igv:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   24: astore 17
    //   26: iload_1
    //   27: iconst_3
    //   28: if_icmpne +2040 -> 2068
    //   31: bipush 100
    //   33: lload_2
    //   34: invokestatic 613	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   37: iconst_0
    //   38: newarray int
    //   40: invokestatic 578	igv:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   43: astore 17
    //   45: aload_0
    //   46: getfield 201	com/tencent/av/VideoController:jdField_b_of_type_Igv	Ligv;
    //   49: aload 17
    //   51: invokevirtual 581	igv:c	(Ljava/lang/String;)Liiv;
    //   54: astore 19
    //   56: invokestatic 398	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +117 -> 176
    //   62: getstatic 170	com/tencent/av/VideoController:TAG	Ljava/lang/String;
    //   65: astore 20
    //   67: new 400	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 4425
    //   77: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: lload_2
    //   81: invokevirtual 461	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: ldc_w 647
    //   87: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload_1
    //   91: invokevirtual 466	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: ldc_w 2341
    //   97: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 4
    //   102: invokevirtual 466	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc_w 2347
    //   108: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 17
    //   113: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 458
    //   119: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: lload 12
    //   124: invokevirtual 461	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: ldc_w 2430
    //   130: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: astore 21
    //   135: aload 18
    //   137: ifnull +47 -> 184
    //   140: iconst_1
    //   141: istore 16
    //   143: aload 20
    //   145: iconst_1
    //   146: aload 21
    //   148: iload 16
    //   150: invokevirtual 410	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   153: ldc_w 2496
    //   156: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 19
    //   161: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: ldc_w 412
    //   167: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 488	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload 18
    //   178: ifnonnull +12 -> 190
    //   181: aload_0
    //   182: monitorexit
    //   183: return
    //   184: iconst_0
    //   185: istore 16
    //   187: goto -44 -> 143
    //   190: aload 19
    //   192: ifnull -11 -> 181
    //   195: getstatic 383	android/os/Build$VERSION:SDK_INT	I
    //   198: bipush 21
    //   200: if_icmplt +44 -> 244
    //   203: aload_0
    //   204: getfield 2301	com/tencent/av/VideoController:jdField_a_of_type_Jds	Ljds;
    //   207: astore 20
    //   209: aload 20
    //   211: ifnull +17 -> 228
    //   214: aload 20
    //   216: invokevirtual 4428	jds:wG	()Z
    //   219: ifeq +9 -> 228
    //   222: aload 20
    //   224: iconst_4
    //   225: invokevirtual 4430	jds:stop	(I)V
    //   228: invokestatic 398	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +13 -> 244
    //   234: getstatic 170	com/tencent/av/VideoController:TAG	Ljava/lang/String;
    //   237: iconst_2
    //   238: ldc_w 4432
    //   241: invokestatic 420	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: aload 18
    //   246: invokevirtual 3506	com/tencent/av/app/VideoAppInterface:a	()Lilu;
    //   249: astore 20
    //   251: aload 20
    //   253: ifnull +10 -> 263
    //   256: aload 20
    //   258: aload 19
    //   260: invokevirtual 4435	ilu:a	(Liiv;)V
    //   263: aload 18
    //   265: invokevirtual 446	com/tencent/av/app/VideoAppInterface:getHandler	()Landroid/os/Handler;
    //   268: aload_0
    //   269: getfield 329	com/tencent/av/VideoController:mTimeOutRunnable	Ljava/lang/Runnable;
    //   272: invokevirtual 495	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   275: aload_0
    //   276: aconst_null
    //   277: putfield 329	com/tencent/av/VideoController:mTimeOutRunnable	Ljava/lang/Runnable;
    //   280: aload_0
    //   281: getfield 294	com/tencent/av/VideoController:bb	Ljava/lang/Runnable;
    //   284: ifnull +20 -> 304
    //   287: aload 18
    //   289: invokevirtual 446	com/tencent/av/app/VideoAppInterface:getHandler	()Landroid/os/Handler;
    //   292: aload_0
    //   293: getfield 294	com/tencent/av/VideoController:bb	Ljava/lang/Runnable;
    //   296: invokevirtual 495	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   299: aload_0
    //   300: aconst_null
    //   301: putfield 294	com/tencent/av/VideoController:bb	Ljava/lang/Runnable;
    //   304: aload_0
    //   305: getfield 308	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   308: ifnull -127 -> 181
    //   311: aload 18
    //   313: iconst_4
    //   314: anewarray 320	java/lang/Object
    //   317: dup
    //   318: iconst_0
    //   319: sipush 203
    //   322: invokestatic 703	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: aastore
    //   326: dup
    //   327: iconst_1
    //   328: lload_2
    //   329: invokestatic 613	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   332: aastore
    //   333: dup
    //   334: iconst_2
    //   335: aload_0
    //   336: getfield 203	com/tencent/av/VideoController:Ox	Z
    //   339: invokestatic 807	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   342: aastore
    //   343: dup
    //   344: iconst_3
    //   345: lload 12
    //   347: invokestatic 706	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   350: aastore
    //   351: invokevirtual 710	com/tencent/av/app/VideoAppInterface:l	([Ljava/lang/Object;)V
    //   354: aload_0
    //   355: invokevirtual 616	com/tencent/av/VideoController:b	()Liiv;
    //   358: getfield 3400	iiv:ii	Ljava/util/ArrayList;
    //   361: invokevirtual 771	java/util/ArrayList:size	()I
    //   364: ifle +21 -> 385
    //   367: aload_0
    //   368: invokevirtual 616	com/tencent/av/VideoController:b	()Liiv;
    //   371: getfield 684	iiv:QP	Z
    //   374: ifeq +11 -> 385
    //   377: aload_0
    //   378: iconst_2
    //   379: iconst_0
    //   380: iconst_0
    //   381: lconst_0
    //   382: invokevirtual 4438	com/tencent/av/VideoController:c	(IIIJ)V
    //   385: iload_1
    //   386: iconst_2
    //   387: if_icmpne +149 -> 536
    //   390: aload 19
    //   392: getfield 684	iiv:QP	Z
    //   395: ifne +141 -> 536
    //   398: aload 19
    //   400: getfield 3400	iiv:ii	Ljava/util/ArrayList;
    //   403: ifnull +133 -> 536
    //   406: new 817	android/content/Intent
    //   409: dup
    //   410: invokespecial 818	android/content/Intent:<init>	()V
    //   413: astore 20
    //   415: aload 20
    //   417: ldc_w 820
    //   420: invokevirtual 824	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   423: pop
    //   424: aload 20
    //   426: ldc_w 826
    //   429: sipush 411
    //   432: invokevirtual 830	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   435: pop
    //   436: aload 20
    //   438: ldc_w 4440
    //   441: aload_0
    //   442: invokevirtual 616	com/tencent/av/VideoController:b	()Liiv;
    //   445: getfield 3400	iiv:ii	Ljava/util/ArrayList;
    //   448: invokevirtual 4443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   451: pop
    //   452: aload 20
    //   454: ldc_w 832
    //   457: aload_0
    //   458: invokevirtual 616	com/tencent/av/VideoController:b	()Liiv;
    //   461: getfield 1758	iiv:relationType	I
    //   464: invokevirtual 830	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   467: pop
    //   468: aload 20
    //   470: ldc_w 834
    //   473: aload_0
    //   474: invokevirtual 616	com/tencent/av/VideoController:b	()Liiv;
    //   477: getfield 695	iiv:ll	J
    //   480: invokevirtual 837	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   483: pop
    //   484: aload 20
    //   486: ldc_w 841
    //   489: aload_0
    //   490: invokevirtual 616	com/tencent/av/VideoController:b	()Liiv;
    //   493: getfield 681	iiv:anb	I
    //   496: invokevirtual 830	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   499: pop
    //   500: aload 20
    //   502: ldc_w 900
    //   505: ldc_w 4445
    //   508: invokevirtual 905	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   511: pop
    //   512: aload 20
    //   514: aload 18
    //   516: invokevirtual 845	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   519: invokevirtual 850	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   522: invokevirtual 853	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   525: pop
    //   526: aload 18
    //   528: invokevirtual 845	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   531: aload 20
    //   533: invokevirtual 857	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   536: iload_1
    //   537: bipush 7
    //   539: if_icmpne +10 -> 549
    //   542: aload_0
    //   543: iconst_0
    //   544: iconst_0
    //   545: aconst_null
    //   546: invokevirtual 751	com/tencent/av/VideoController:e	(IILjava/lang/String;)V
    //   549: iload_1
    //   550: bipush 9
    //   552: if_icmpne +29 -> 581
    //   555: aload 19
    //   557: getfield 725	iiv:jdField_a_of_type_Iiv$a	Liiv$a;
    //   560: iconst_0
    //   561: putfield 730	iiv$a:anA	I
    //   564: aload_0
    //   565: iconst_0
    //   566: iconst_0
    //   567: aconst_null
    //   568: invokevirtual 751	com/tencent/av/VideoController:e	(IILjava/lang/String;)V
    //   571: aload 19
    //   573: invokevirtual 4448	iiv:amH	()V
    //   576: aload 19
    //   578: invokevirtual 4451	iiv:amG	()V
    //   581: iload_1
    //   582: bipush 10
    //   584: if_icmpne +13 -> 597
    //   587: aload 19
    //   589: invokevirtual 4448	iiv:amH	()V
    //   592: aload 19
    //   594: invokevirtual 4451	iiv:amG	()V
    //   597: iload_1
    //   598: iconst_2
    //   599: if_icmpne +1086 -> 1685
    //   602: ldc_w 1487
    //   605: aload 19
    //   607: getfield 1468	iiv:deviceName	Ljava/lang/String;
    //   610: invokevirtual 1317	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   613: ifeq +30 -> 643
    //   616: aconst_null
    //   617: ldc_w 3714
    //   620: ldc 255
    //   622: ldc 255
    //   624: ldc_w 4453
    //   627: ldc_w 4453
    //   630: iconst_0
    //   631: iconst_0
    //   632: ldc 255
    //   634: ldc 255
    //   636: ldc 255
    //   638: ldc 255
    //   640: invokestatic 2919	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   643: aload_0
    //   644: invokevirtual 4247	com/tencent/av/VideoController:ss	()Z
    //   647: ifeq +30 -> 677
    //   650: aconst_null
    //   651: ldc_w 3714
    //   654: ldc 255
    //   656: ldc 255
    //   658: ldc_w 4455
    //   661: ldc_w 4455
    //   664: iconst_0
    //   665: iconst_0
    //   666: ldc 255
    //   668: ldc 255
    //   670: ldc 255
    //   672: ldc 255
    //   674: invokestatic 2919	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   677: aload 19
    //   679: getfield 1771	iiv:PY	Z
    //   682: ifeq +38 -> 720
    //   685: aconst_null
    //   686: ldc_w 3714
    //   689: ldc 255
    //   691: ldc 255
    //   693: ldc_w 4457
    //   696: ldc_w 4457
    //   699: iconst_0
    //   700: iconst_0
    //   701: ldc 255
    //   703: ldc 255
    //   705: ldc 255
    //   707: ldc 255
    //   709: invokestatic 2919	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   712: aload 19
    //   714: getfield 4460	iiv:isFrontCamera	Z
    //   717: ifeq +938 -> 1655
    //   720: aload_0
    //   721: getfield 331	com/tencent/av/VideoController:OW	Z
    //   724: ifeq +44 -> 768
    //   727: aload_0
    //   728: invokevirtual 3494	com/tencent/av/VideoController:bt	()J
    //   731: lconst_0
    //   732: lcmp
    //   733: ifle +35 -> 768
    //   736: aconst_null
    //   737: ldc_w 3714
    //   740: ldc 255
    //   742: ldc 255
    //   744: ldc_w 4462
    //   747: ldc_w 4462
    //   750: iconst_0
    //   751: iconst_0
    //   752: ldc 255
    //   754: ldc 255
    //   756: aload_0
    //   757: invokevirtual 3494	com/tencent/av/VideoController:bt	()J
    //   760: invokestatic 3668	jll:formatTime	(J)Ljava/lang/String;
    //   763: ldc 255
    //   765: invokestatic 2919	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   768: aload_0
    //   769: getfield 308	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   772: lload_2
    //   773: invokevirtual 4466	com/tencent/av/gaudio/QQGAudioCtrl:getNetTrafficSize	(J)J
    //   776: lstore 14
    //   778: iconst_0
    //   779: istore 5
    //   781: iload 4
    //   783: bipush 7
    //   785: if_icmpeq +1286 -> 2071
    //   788: iload 4
    //   790: bipush 20
    //   792: if_icmpne +6 -> 798
    //   795: goto +1276 -> 2071
    //   798: getstatic 4469	com/tencent/av/core/VcControllerImpl:sIsSpecialDevice	Z
    //   801: ifeq +1215 -> 2016
    //   804: aload_0
    //   805: ldc_w 4470
    //   808: putfield 325	com/tencent/av/VideoController:alG	I
    //   811: new 4472	com/tencent/av/VideoController$24
    //   814: dup
    //   815: aload_0
    //   816: iload 5
    //   818: invokespecial 4475	com/tencent/av/VideoController$24:<init>	(Lcom/tencent/av/VideoController;I)V
    //   821: bipush 16
    //   823: aconst_null
    //   824: iconst_0
    //   825: invokestatic 4481	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   828: aload_0
    //   829: getfield 323	com/tencent/av/VideoController:lock	Ljava/lang/Object;
    //   832: astore 20
    //   834: aload 20
    //   836: monitorenter
    //   837: aload_0
    //   838: getfield 323	com/tencent/av/VideoController:lock	Ljava/lang/Object;
    //   841: sipush 2000
    //   844: i2l
    //   845: invokevirtual 4484	java/lang/Object:wait	(J)V
    //   848: aload 20
    //   850: monitorexit
    //   851: aload_0
    //   852: getfield 325	com/tencent/av/VideoController:alG	I
    //   855: ldc_w 4470
    //   858: if_icmpne +1207 -> 2065
    //   861: sipush 261
    //   864: istore 5
    //   866: getstatic 170	com/tencent/av/VideoController:TAG	Ljava/lang/String;
    //   869: iconst_1
    //   870: new 400	java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   877: ldc_w 4486
    //   880: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: aload_0
    //   884: getfield 325	com/tencent/av/VideoController:alG	I
    //   887: invokevirtual 466	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   890: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   893: invokestatic 910	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   896: aload_0
    //   897: getfield 2351	com/tencent/av/VideoController:OB	Z
    //   900: ifeq +1129 -> 2029
    //   903: aload 19
    //   905: getfield 768	iiv:state	I
    //   908: bipush 9
    //   910: if_icmpne +1119 -> 2029
    //   913: aload 19
    //   915: getfield 779	iiv:QR	Z
    //   918: ifne +1111 -> 2029
    //   921: lconst_0
    //   922: lstore 8
    //   924: aload_0
    //   925: ldc_w 4488
    //   928: iconst_0
    //   929: invokevirtual 2943	com/tencent/av/VideoController:M	(Ljava/lang/String;Z)V
    //   932: aload_0
    //   933: ldc_w 4488
    //   936: iconst_1
    //   937: invokevirtual 2945	com/tencent/av/VideoController:V	(Ljava/lang/String;I)V
    //   940: aload_0
    //   941: getfield 340	com/tencent/av/VideoController:hZ	Ljava/util/ArrayList;
    //   944: astore 20
    //   946: aload 20
    //   948: monitorenter
    //   949: aload_0
    //   950: getfield 340	com/tencent/av/VideoController:hZ	Ljava/util/ArrayList;
    //   953: invokevirtual 771	java/util/ArrayList:size	()I
    //   956: ifne +1103 -> 2059
    //   959: aload_0
    //   960: getfield 2351	com/tencent/av/VideoController:OB	Z
    //   963: ifne +1096 -> 2059
    //   966: aload_0
    //   967: getfield 641	com/tencent/av/VideoController:kJ	J
    //   970: lconst_0
    //   971: lcmp
    //   972: ifne +1087 -> 2059
    //   975: iconst_1
    //   976: istore 6
    //   978: aload_0
    //   979: getfield 340	com/tencent/av/VideoController:hZ	Ljava/util/ArrayList;
    //   982: invokevirtual 771	java/util/ArrayList:size	()I
    //   985: istore 7
    //   987: aload_0
    //   988: getfield 340	com/tencent/av/VideoController:hZ	Ljava/util/ArrayList;
    //   991: invokevirtual 1452	java/util/ArrayList:clear	()V
    //   994: aload 20
    //   996: monitorexit
    //   997: aload_0
    //   998: ldc_w 4488
    //   1001: iconst_0
    //   1002: iconst_0
    //   1003: lconst_0
    //   1004: invokevirtual 669	com/tencent/av/VideoController:a	(Ljava/lang/String;ZIJ)V
    //   1007: aload 19
    //   1009: iconst_0
    //   1010: putfield 672	iiv:QH	Z
    //   1013: aload_0
    //   1014: getfield 308	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   1017: iconst_0
    //   1018: putfield 4491	com/tencent/av/gaudio/QQGAudioCtrl:mIsSwitchGroup	Z
    //   1021: aload 18
    //   1023: invokevirtual 601	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1026: astore 20
    //   1028: lconst_0
    //   1029: lstore 10
    //   1031: aload 20
    //   1033: ifnull +10 -> 1043
    //   1036: aload 20
    //   1038: invokestatic 607	jji:B	(Ljava/lang/String;)J
    //   1041: lstore 10
    //   1043: aload 20
    //   1045: invokestatic 627	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1048: ifne +214 -> 1262
    //   1051: new 817	android/content/Intent
    //   1054: dup
    //   1055: invokespecial 818	android/content/Intent:<init>	()V
    //   1058: astore 21
    //   1060: aload 21
    //   1062: ldc_w 820
    //   1065: invokevirtual 824	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   1068: pop
    //   1069: aload 21
    //   1071: ldc_w 826
    //   1074: bipush 23
    //   1076: invokevirtual 830	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1079: pop
    //   1080: aload 21
    //   1082: ldc_w 839
    //   1085: lload 10
    //   1087: invokevirtual 837	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1090: pop
    //   1091: aload 21
    //   1093: ldc_w 834
    //   1096: lload_2
    //   1097: invokevirtual 837	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1100: pop
    //   1101: aload 21
    //   1103: ldc_w 832
    //   1106: iload_1
    //   1107: invokevirtual 830	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1110: pop
    //   1111: aload 21
    //   1113: ldc_w 841
    //   1116: aload 19
    //   1118: getfield 681	iiv:anb	I
    //   1121: invokevirtual 830	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1124: pop
    //   1125: aload 21
    //   1127: ldc_w 4493
    //   1130: lload 8
    //   1132: invokevirtual 837	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1135: pop
    //   1136: aload 21
    //   1138: ldc_w 893
    //   1141: aload_0
    //   1142: getfield 327	com/tencent/av/VideoController:OV	Z
    //   1145: invokevirtual 896	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1148: pop
    //   1149: aload 21
    //   1151: ldc_w 4495
    //   1154: iload 4
    //   1156: invokevirtual 830	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1159: pop
    //   1160: aload 21
    //   1162: ldc_w 900
    //   1165: ldc_w 4497
    //   1168: invokevirtual 905	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1171: pop
    //   1172: iload 7
    //   1174: iconst_1
    //   1175: if_icmple +871 -> 2046
    //   1178: aload 21
    //   1180: ldc_w 898
    //   1183: iload 7
    //   1185: iconst_1
    //   1186: isub
    //   1187: invokevirtual 830	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1190: pop
    //   1191: aload 21
    //   1193: aload 18
    //   1195: invokevirtual 845	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1198: invokevirtual 850	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   1201: invokevirtual 853	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1204: pop
    //   1205: aload 21
    //   1207: lload 12
    //   1209: invokestatic 3784	jlc:a	(Landroid/content/Intent;J)V
    //   1212: aload 18
    //   1214: invokevirtual 845	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1217: aload 21
    //   1219: invokevirtual 857	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   1222: invokestatic 398	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1225: ifeq +37 -> 1262
    //   1228: getstatic 170	com/tencent/av/VideoController:TAG	Ljava/lang/String;
    //   1231: iconst_1
    //   1232: new 400	java/lang/StringBuilder
    //   1235: dup
    //   1236: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   1239: ldc_w 4499
    //   1242: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: lload 12
    //   1247: invokevirtual 461	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1250: ldc_w 412
    //   1253: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1259: invokestatic 488	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1262: aload 19
    //   1264: ldc_w 4488
    //   1267: aconst_null
    //   1268: invokevirtual 2938	iiv:aQ	(Ljava/lang/String;Ljava/lang/String;)V
    //   1271: aload 19
    //   1273: aconst_null
    //   1274: putfield 4502	iiv:aK	[Ljava/lang/String;
    //   1277: aload_0
    //   1278: invokevirtual 2897	com/tencent/av/VideoController:abandonAudioFocus	()V
    //   1281: aload 19
    //   1283: getfield 949	iiv:if	Ljava/util/ArrayList;
    //   1286: invokevirtual 771	java/util/ArrayList:size	()I
    //   1289: ifle +28 -> 1317
    //   1292: aload 18
    //   1294: iconst_2
    //   1295: anewarray 320	java/lang/Object
    //   1298: dup
    //   1299: iconst_0
    //   1300: bipush 104
    //   1302: invokestatic 703	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1305: aastore
    //   1306: dup
    //   1307: iconst_1
    //   1308: aload 19
    //   1310: getfield 949	iiv:if	Ljava/util/ArrayList;
    //   1313: aastore
    //   1314: invokevirtual 710	com/tencent/av/app/VideoAppInterface:l	([Ljava/lang/Object;)V
    //   1317: aload 19
    //   1319: getfield 1758	iiv:relationType	I
    //   1322: iconst_1
    //   1323: if_icmpne +28 -> 1351
    //   1326: aload 18
    //   1328: iconst_2
    //   1329: anewarray 320	java/lang/Object
    //   1332: dup
    //   1333: iconst_0
    //   1334: sipush 410
    //   1337: invokestatic 703	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1340: aastore
    //   1341: dup
    //   1342: iconst_1
    //   1343: lload_2
    //   1344: invokestatic 706	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1347: aastore
    //   1348: invokevirtual 710	com/tencent/av/app/VideoAppInterface:l	([Ljava/lang/Object;)V
    //   1351: aload 19
    //   1353: getfield 2502	iiv:senderUin	Ljava/lang/String;
    //   1356: astore 21
    //   1358: aload 19
    //   1360: getfield 1758	iiv:relationType	I
    //   1363: iconst_1
    //   1364: if_icmpeq +12 -> 1376
    //   1367: aload 19
    //   1369: getfield 1758	iiv:relationType	I
    //   1372: iconst_2
    //   1373: if_icmpne +44 -> 1417
    //   1376: aload 19
    //   1378: getfield 1771	iiv:PY	Z
    //   1381: ifeq +28 -> 1409
    //   1384: aload 18
    //   1386: iconst_2
    //   1387: anewarray 320	java/lang/Object
    //   1390: dup
    //   1391: iconst_0
    //   1392: bipush 106
    //   1394: invokestatic 703	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1397: aastore
    //   1398: dup
    //   1399: iconst_1
    //   1400: lload 12
    //   1402: invokestatic 706	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1405: aastore
    //   1406: invokevirtual 710	com/tencent/av/app/VideoAppInterface:l	([Ljava/lang/Object;)V
    //   1409: aload 19
    //   1411: lload 12
    //   1413: iconst_0
    //   1414: invokevirtual 2925	iiv:n	(JZ)V
    //   1417: aload 19
    //   1419: lload 12
    //   1421: invokevirtual 4505	iiv:bO	(J)V
    //   1424: aload_0
    //   1425: invokevirtual 4507	com/tencent/av/VideoController:alB	()V
    //   1428: lload 12
    //   1430: aload 18
    //   1432: invokestatic 4510	iwu:a	(JLcom/tencent/av/app/VideoAppInterface;)V
    //   1435: iload 6
    //   1437: ifne +46 -> 1483
    //   1440: aload_0
    //   1441: new 400	java/lang/StringBuilder
    //   1444: dup
    //   1445: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   1448: ldc_w 4512
    //   1451: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: iload 4
    //   1456: invokevirtual 466	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1459: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1462: aload 17
    //   1464: iload_1
    //   1465: invokestatic 2361	jll:cM	(I)I
    //   1468: aload 20
    //   1470: lload_2
    //   1471: invokestatic 613	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1474: bipush 7
    //   1476: aload 21
    //   1478: iconst_0
    //   1479: iconst_0
    //   1480: invokevirtual 2377	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZ)V
    //   1483: aload 19
    //   1485: iconst_m1
    //   1486: putfield 719	iiv:uinType	I
    //   1489: aload 19
    //   1491: iconst_1
    //   1492: putfield 4515	iiv:Qd	Z
    //   1495: aload_0
    //   1496: lload 14
    //   1498: putfield 3645	com/tencent/av/VideoController:kK	J
    //   1501: invokestatic 398	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1504: ifeq +31 -> 1535
    //   1507: getstatic 170	com/tencent/av/VideoController:TAG	Ljava/lang/String;
    //   1510: iconst_2
    //   1511: new 400	java/lang/StringBuilder
    //   1514: dup
    //   1515: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   1518: ldc_w 4517
    //   1521: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: lload 14
    //   1526: invokevirtual 461	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1529: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1532: invokestatic 910	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1535: new 817	android/content/Intent
    //   1538: dup
    //   1539: ldc_w 4519
    //   1542: invokespecial 3306	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1545: astore 19
    //   1547: aload 19
    //   1549: ldc_w 4520
    //   1552: lload 14
    //   1554: invokevirtual 837	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1557: pop
    //   1558: aload 19
    //   1560: aload 18
    //   1562: invokevirtual 845	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1565: invokevirtual 850	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   1568: invokevirtual 853	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1571: pop
    //   1572: iload 6
    //   1574: ifne +13 -> 1587
    //   1577: aload 18
    //   1579: invokevirtual 845	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1582: aload 19
    //   1584: invokevirtual 857	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   1587: aload_0
    //   1588: getfield 201	com/tencent/av/VideoController:jdField_b_of_type_Igv	Ligv;
    //   1591: lload 12
    //   1593: aload 17
    //   1595: invokevirtual 2372	igv:c	(JLjava/lang/String;)Z
    //   1598: istore 16
    //   1600: aload 18
    //   1602: invokestatic 756	jko:a	(Lcom/tencent/av/app/VideoAppInterface;)Ljko;
    //   1605: astore 18
    //   1607: aload 18
    //   1609: ifnull +27 -> 1636
    //   1612: aload 18
    //   1614: invokevirtual 759	jko:isActive	()Z
    //   1617: ifeq +19 -> 1636
    //   1620: aload 18
    //   1622: aload 17
    //   1624: invokevirtual 866	jko:cancelNotification	(Ljava/lang/String;)V
    //   1627: iload 16
    //   1629: ifeq +7 -> 1636
    //   1632: aload_0
    //   1633: invokevirtual 761	com/tencent/av/VideoController:alx	()V
    //   1636: invokestatic 4523	com/tencent/av/utils/PopupDialog:axr	()V
    //   1639: aload_0
    //   1640: iload 5
    //   1642: invokevirtual 1612	com/tencent/av/VideoController:kq	(I)V
    //   1645: goto -1464 -> 181
    //   1648: astore 17
    //   1650: aload_0
    //   1651: monitorexit
    //   1652: aload 17
    //   1654: athrow
    //   1655: aconst_null
    //   1656: ldc_w 3714
    //   1659: ldc 255
    //   1661: ldc 255
    //   1663: ldc_w 4525
    //   1666: ldc_w 4525
    //   1669: iconst_0
    //   1670: iconst_0
    //   1671: ldc 255
    //   1673: ldc 255
    //   1675: ldc 255
    //   1677: ldc 255
    //   1679: invokestatic 2919	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1682: goto -962 -> 720
    //   1685: iload_1
    //   1686: iconst_1
    //   1687: if_icmpne -967 -> 720
    //   1690: ldc_w 1487
    //   1693: aload 19
    //   1695: getfield 1468	iiv:deviceName	Ljava/lang/String;
    //   1698: invokevirtual 1317	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1701: ifeq +40 -> 1741
    //   1704: aload 19
    //   1706: getfield 681	iiv:anb	I
    //   1709: bipush 10
    //   1711: if_icmpne +167 -> 1878
    //   1714: aconst_null
    //   1715: ldc_w 3714
    //   1718: ldc 255
    //   1720: ldc 255
    //   1722: ldc_w 4527
    //   1725: ldc_w 4527
    //   1728: iconst_0
    //   1729: iconst_0
    //   1730: ldc 255
    //   1732: ldc 255
    //   1734: ldc 255
    //   1736: ldc 255
    //   1738: invokestatic 2919	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1741: aload_0
    //   1742: invokevirtual 4247	com/tencent/av/VideoController:ss	()Z
    //   1745: ifeq +40 -> 1785
    //   1748: aload 19
    //   1750: getfield 681	iiv:anb	I
    //   1753: bipush 10
    //   1755: if_icmpne +153 -> 1908
    //   1758: aconst_null
    //   1759: ldc_w 3714
    //   1762: ldc 255
    //   1764: ldc 255
    //   1766: ldc_w 4529
    //   1769: ldc_w 4529
    //   1772: iconst_0
    //   1773: iconst_0
    //   1774: ldc 255
    //   1776: ldc 255
    //   1778: ldc 255
    //   1780: ldc 255
    //   1782: invokestatic 2919	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1785: aload 19
    //   1787: getfield 1771	iiv:PY	Z
    //   1790: ifeq -1070 -> 720
    //   1793: aload 19
    //   1795: getfield 681	iiv:anb	I
    //   1798: bipush 10
    //   1800: if_icmpne +138 -> 1938
    //   1803: aconst_null
    //   1804: ldc_w 3714
    //   1807: ldc 255
    //   1809: ldc 255
    //   1811: ldc_w 4531
    //   1814: ldc_w 4531
    //   1817: iconst_0
    //   1818: iconst_0
    //   1819: ldc 255
    //   1821: ldc 255
    //   1823: ldc 255
    //   1825: ldc 255
    //   1827: invokestatic 2919	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1830: aload 19
    //   1832: getfield 4460	iiv:isFrontCamera	Z
    //   1835: ifne -1115 -> 720
    //   1838: aload 19
    //   1840: getfield 681	iiv:anb	I
    //   1843: bipush 10
    //   1845: if_icmpne +123 -> 1968
    //   1848: aconst_null
    //   1849: ldc_w 3714
    //   1852: ldc 255
    //   1854: ldc 255
    //   1856: ldc_w 4533
    //   1859: ldc_w 4533
    //   1862: iconst_0
    //   1863: iconst_0
    //   1864: ldc 255
    //   1866: ldc 255
    //   1868: ldc 255
    //   1870: ldc 255
    //   1872: invokestatic 2919	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1875: goto -1155 -> 720
    //   1878: aconst_null
    //   1879: ldc_w 3714
    //   1882: ldc 255
    //   1884: ldc 255
    //   1886: ldc_w 4535
    //   1889: ldc_w 4535
    //   1892: iconst_0
    //   1893: iconst_0
    //   1894: ldc 255
    //   1896: ldc 255
    //   1898: ldc 255
    //   1900: ldc 255
    //   1902: invokestatic 2919	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1905: goto -164 -> 1741
    //   1908: aconst_null
    //   1909: ldc_w 3714
    //   1912: ldc 255
    //   1914: ldc 255
    //   1916: ldc_w 4537
    //   1919: ldc_w 4537
    //   1922: iconst_0
    //   1923: iconst_0
    //   1924: ldc 255
    //   1926: ldc 255
    //   1928: ldc 255
    //   1930: ldc 255
    //   1932: invokestatic 2919	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1935: goto -150 -> 1785
    //   1938: aconst_null
    //   1939: ldc_w 3714
    //   1942: ldc 255
    //   1944: ldc 255
    //   1946: ldc_w 4539
    //   1949: ldc_w 4539
    //   1952: iconst_0
    //   1953: iconst_0
    //   1954: ldc 255
    //   1956: ldc 255
    //   1958: ldc 255
    //   1960: ldc 255
    //   1962: invokestatic 2919	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1965: goto -135 -> 1830
    //   1968: aconst_null
    //   1969: ldc_w 3714
    //   1972: ldc 255
    //   1974: ldc 255
    //   1976: ldc_w 4541
    //   1979: ldc_w 4541
    //   1982: iconst_0
    //   1983: iconst_0
    //   1984: ldc 255
    //   1986: ldc 255
    //   1988: ldc 255
    //   1990: ldc 255
    //   1992: invokestatic 2919	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1995: goto -1275 -> 720
    //   1998: astore 21
    //   2000: aload 21
    //   2002: invokevirtual 4542	java/lang/InterruptedException:printStackTrace	()V
    //   2005: goto -1157 -> 848
    //   2008: astore 17
    //   2010: aload 20
    //   2012: monitorexit
    //   2013: aload 17
    //   2015: athrow
    //   2016: aload_0
    //   2017: getfield 308	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   2020: iload 5
    //   2022: invokevirtual 4545	com/tencent/av/gaudio/QQGAudioCtrl:quit	(I)I
    //   2025: pop
    //   2026: goto -1130 -> 896
    //   2029: aload_0
    //   2030: invokevirtual 3494	com/tencent/av/VideoController:bt	()J
    //   2033: lstore 8
    //   2035: goto -1111 -> 924
    //   2038: astore 17
    //   2040: aload 20
    //   2042: monitorexit
    //   2043: aload 17
    //   2045: athrow
    //   2046: aload 21
    //   2048: ldc_w 898
    //   2051: iconst_0
    //   2052: invokevirtual 830	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2055: pop
    //   2056: goto -865 -> 1191
    //   2059: iconst_0
    //   2060: istore 6
    //   2062: goto -1084 -> 978
    //   2065: goto -1199 -> 866
    //   2068: goto -2023 -> 45
    //   2071: iload 4
    //   2073: istore 5
    //   2075: goto -1277 -> 798
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2078	0	this	VideoController
    //   0	2078	1	paramInt1	int
    //   0	2078	2	paramLong	long
    //   0	2078	4	paramInt2	int
    //   779	1295	5	i	int
    //   976	1085	6	j	int
    //   985	202	7	k	int
    //   922	1112	8	l1	long
    //   1029	57	10	l2	long
    //   5	1587	12	l3	long
    //   776	777	14	l4	long
    //   141	1487	16	bool	boolean
    //   24	1599	17	str	String
    //   1648	5	17	localObject1	Object
    //   2008	6	17	localObject2	Object
    //   2038	6	17	localObject3	Object
    //   11	1610	18	localObject4	Object
    //   54	1785	19	localObject5	Object
    //   133	1344	21	localObject7	Object
    //   1998	49	21	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	26	1648	finally
    //   31	45	1648	finally
    //   45	135	1648	finally
    //   143	176	1648	finally
    //   195	209	1648	finally
    //   214	228	1648	finally
    //   228	244	1648	finally
    //   244	251	1648	finally
    //   256	263	1648	finally
    //   263	304	1648	finally
    //   304	385	1648	finally
    //   390	536	1648	finally
    //   542	549	1648	finally
    //   555	581	1648	finally
    //   587	597	1648	finally
    //   602	643	1648	finally
    //   643	677	1648	finally
    //   677	720	1648	finally
    //   720	768	1648	finally
    //   768	778	1648	finally
    //   798	837	1648	finally
    //   851	861	1648	finally
    //   866	896	1648	finally
    //   896	921	1648	finally
    //   924	949	1648	finally
    //   997	1028	1648	finally
    //   1036	1043	1648	finally
    //   1043	1172	1648	finally
    //   1178	1191	1648	finally
    //   1191	1262	1648	finally
    //   1262	1317	1648	finally
    //   1317	1351	1648	finally
    //   1351	1376	1648	finally
    //   1376	1409	1648	finally
    //   1409	1417	1648	finally
    //   1417	1435	1648	finally
    //   1440	1483	1648	finally
    //   1483	1535	1648	finally
    //   1535	1572	1648	finally
    //   1577	1587	1648	finally
    //   1587	1607	1648	finally
    //   1612	1627	1648	finally
    //   1632	1636	1648	finally
    //   1636	1645	1648	finally
    //   1655	1682	1648	finally
    //   1690	1741	1648	finally
    //   1741	1785	1648	finally
    //   1785	1830	1648	finally
    //   1830	1875	1648	finally
    //   1878	1905	1648	finally
    //   1908	1935	1648	finally
    //   1938	1965	1648	finally
    //   1968	1995	1648	finally
    //   2013	2016	1648	finally
    //   2016	2026	1648	finally
    //   2029	2035	1648	finally
    //   2043	2046	1648	finally
    //   2046	2056	1648	finally
    //   837	848	1998	java/lang/InterruptedException
    //   837	848	2008	finally
    //   848	851	2008	finally
    //   2000	2005	2008	finally
    //   2010	2013	2008	finally
    //   949	975	2038	finally
    //   978	997	2038	finally
    //   2040	2043	2038	finally
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    QLog.w(TAG, 1, "onGroupVideoClosed, relationId[" + paramLong + "], reason[" + paramInt2 + "], avtype[" + paramInt3 + "], bKickout[" + this.OC + "], mGAudioInRoom[" + this.OB + "], mGAudioGroupId[" + this.kJ + "]");
    if (this.OC) {
      return;
    }
    if ((this.OB) && (this.kJ == paramLong)) {
      b(1, paramLong, 83);
    }
    for (;;)
    {
      this.mApp.l(new Object[] { Integer.valueOf(88), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      return;
      this.mApp.getHandler().removeCallbacks(this.mTimeOutRunnable);
      this.mTimeOutRunnable = null;
      b().Y("onGroupVideoClosed", 0);
      a(paramInt1, paramLong, 17, 0, paramInt2);
    }
  }
  
  public void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l1 = AudioHelper.hG();
    b().a(l1, "onGaGoOffStageResult", false, false);
    if (this.mApp != null)
    {
      long l2 = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
      this.mApp.l(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l1) });
    }
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "onKickOutFail, groupId[" + paramLong + "], relationType[" + paramInt1 + "], multiAVType[" + paramInt2 + "], errCode[" + paramInt3 + "], strMsg[" + paramString + "]");
    }
    this.mApp.l(new Object[] { Integer.valueOf(518), Boolean.valueOf(false), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
  }
  
  public void b(long paramLong1, long paramLong2, String paramString)
  {
    QLog.w(TAG, 1, "onGroupSecurityLimit, mGAudioInRoom[" + this.OB + "], mGAudioGroupId[" + this.kJ + "], relationId[" + paramLong1 + "], info[" + paramLong2 + "], strMsg[" + paramString + "]");
    if ((this.OB) && (this.kJ == paramLong1)) {
      b(1, paramLong1, 82);
    }
    for (;;)
    {
      this.mApp.l(new Object[] { Integer.valueOf(89), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
      return;
      this.mApp.getHandler().removeCallbacks(this.mTimeOutRunnable);
      this.mTimeOutRunnable = null;
      b().Y("onGroupSecurityLimit", 0);
      a(1, paramLong1, 17, 0);
    }
  }
  
  public void b(long paramLong1, long paramLong2, ArrayList<inx> paramArrayList)
  {
    this.mApp.getHandler().post(new VideoController.29(this, paramArrayList, paramLong1, paramLong2));
  }
  
  @TargetApi(21)
  public void b(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "quitDoubleVideoMeeting, relationId[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    Object localObject = this.jdField_a_of_type_Jds;
    if (localObject != null) {
      ((jds)localObject).stop(4);
    }
    localObject = igv.a(100, String.valueOf(paramLong2), new int[0]);
    iiv localiiv = this.jdField_b_of_type_Igv.c((String)localObject);
    if (localiiv == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 402);
    localIntent.putExtra("relationType", 3);
    localIntent.putExtra("relationId", paramLong2);
    localIntent.putExtra("friendUin", paramLong2);
    localIntent.putExtra("MultiAVType", localiiv.anb);
    localIntent.putExtra("from", "VideoController6");
    jlc.a(localIntent, paramLong1);
    localIntent.setPackage(this.mApp.getApp().getPackageName());
    this.mApp.getApp().sendBroadcast(localIntent);
    a((String)localObject, 0, paramInt, true, "" + paramLong2, "" + paramLong2, false);
    if (localiiv.PY) {
      this.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong1) });
    }
    if (paramBoolean)
    {
      b(3, paramLong2, 84);
      localiiv.R("quitDoubleVideoMeeting", false);
      localiiv.S("quitDoubleVideoMeeting", false);
    }
    for (;;)
    {
      localObject = a();
      if (localObject == null) {
        break;
      }
      ((ScreenShareCtrl)localObject).cz(paramLong2);
      return;
      localiiv.Y("quitDoubleVideoMeeting", 15);
      a(paramLong1, 2131230754, 1, this.c);
      this.aX = new VideoController.32(this);
      this.mApp.getHandler().postDelayed(this.aX, 2000L);
    }
  }
  
  public void b(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    a(this.mApp.getCurrentAccountUin(), paramLong1, paramLong2, paramArrayOfByte);
  }
  
  public void b(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 23) {}
    for (int i = 1;; i = paramInt)
    {
      String str = igv.a(3, paramString, new int[0]);
      if (this.jdField_b_of_type_Igv.ci(str)) {}
      for (iiv localiiv = this.jdField_b_of_type_Igv.c(str); localiiv == null; localiiv = this.jdField_b_of_type_Igv.c(str))
      {
        QLog.w(TAG + "|VideoNodeManager", 1, "doCloseSession, fail to find session, peerUin[" + paramString + "], type[" + i + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], seq[" + paramLong + "]");
        ikp.s(0L, 33);
        ikp.bU(0L);
        return;
        str = igv.a(100, paramString, new int[0]);
      }
      Object localObject = this.mApp.a();
      if (localObject != null) {
        ((ilu)localObject).a(localiiv);
      }
      ikp.d(localiiv.getRoomId(), 16, 0L);
      ikp.s(localiiv.getRoomId(), 33);
      ikp.bU(localiiv.getRoomId());
      localObject = (ikr)this.mApp.a(4);
      if (localiiv.PT) {}
      for (int j = 12;; j = 5)
      {
        ((ikr)localObject).d(localiiv.getRoomId(), j, i + 500);
        ((ikr)localObject).iZ("NoCrash");
        ((ikr)localObject).d(localiiv.getRoomId(), 29, 1L);
        ((ikr)localObject).r(36, 1L);
        ((ikr)localObject).bW(localiiv.getRoomId());
        QLog.w(TAG, 1, "avideo doCloseSession, peerUin[" + paramString + "], type[" + paramInt + "->" + i + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], mIsQuit[" + this.Ox + "], sessionId[" + str + "], sessionInfo.isIdling[" + localiiv.sY() + "], sessionInfo.peerUin[" + localiiv.peerUin + "], sessionInfo.isOnlyAudio[" + localiiv.QE + "], sessionInfo.SessionType[" + localiiv.amI + "], mNetTrafficAllSize[" + this.kK + "], mAnyChatCloseByFriend[" + this.OD + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable != null)
        {
          this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable);
          this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = null;
        }
        if ((!localiiv.sY()) || (paramBoolean)) {
          break;
        }
        QLog.e(TAG, 1, "closeSession state error!!!");
        return;
      }
      if ((localiiv.amI == 2) && (!localiiv.Qw) && (localiiv.state >= 4) && (localiiv.lj > 0L))
      {
        j = this.mApp.ak("BEAUTY_SKIN");
        igd.aK(TAG, "closeSession double video call end with beauty: " + j + " | " + localiiv.lj + " | " + localiiv.state + " | " + localiiv.Qi);
        if ((localiiv.Qi) || (j > 0)) {
          anot.a(null, "CliOper", "", "", "0X8006292", "0X8006292", 0, 0, "", "", "", "");
        }
      }
      if ((this.OW) && (bt() > 0L))
      {
        if (localiiv.amI == 1) {
          anot.a(null, "CliOper", "", "", "0X8008B29 ", "0X8008B29 ", 0, 0, "", "", jll.formatTime(bt()), "");
        }
      }
      else
      {
        label763:
        localiiv.li = 0L;
        localiiv.MW = null;
        localObject = paramString;
        if (!TextUtils.isEmpty(localiiv.peerUin))
        {
          localObject = paramString;
          if (localiiv.peerUin.contains(paramString)) {
            localObject = localiiv.peerUin;
          }
        }
        if ((localiiv.tf()) || (localiiv.tg())) {
          localiiv.ana = i;
        }
        if ((localiiv.ta()) || ((localiiv.tc()) && (i == localiiv.ana))) {
          localiiv.C(paramLong, 0L);
        }
        if ((localiiv.QU) && (this.ba != null))
        {
          this.mApp.getHandler().removeCallbacks(this.ba);
          this.ba = null;
        }
        if (paramInt != 23) {
          break label1585;
        }
        paramBoolean = false;
        if (localiiv.amI == 2) {
          paramBoolean = true;
        }
        a(localiiv.sessionId, localiiv.uinType, paramBoolean, localiiv.peerUin, localiiv.MP);
        label949:
        this.kK = 0L;
        if (!this.jdField_b_of_type_Igv.sk())
        {
          abandonAudioFocus();
          alD();
          alM();
        }
        localiiv.jdField_a_of_type_Iiv$a.Rt = false;
        localiiv.jdField_a_of_type_Iiv$a.headUrl = null;
        localiiv.jdField_a_of_type_Iiv$a.nickName = null;
        localiiv.jdField_a_of_type_Iiv$a.peerUin = null;
        if (this.Ox)
        {
          jjk.b(this, false);
          jjk.c(this, false);
          if (this.mApp.countObservers() > 0) {
            jjk.n(this);
          }
        }
        localiiv.Y("doCloseSession", 0);
        localiiv.e(paramLong, "doCloseSession", 0);
        localiiv.amK = 0;
        localiiv.b.clear();
        localiiv.lo = 0L;
        GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(0, 1);
        localiiv.Rg = false;
        localiiv.aK = null;
        localiiv.aQ("doCloseSession", null);
        localiiv.Qd = true;
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "closeSession uinType = " + localiiv.uinType + " # matchStatus = " + localiiv.jdField_a_of_type_Iiv$a.anA);
        }
        if ((i != 21) && (i != 72) && (localiiv.jdField_a_of_type_Iiv$a.anA != 2) && (!this.OD) && (i != 110))
        {
          localiiv.uinType = -1;
          if (this.mApp.countObservers() <= 0) {
            break label1599;
          }
          this.mApp.l(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(this.Ox) });
        }
        label1261:
        if ((localiiv.uinType != 1011) || ((localiiv.jdField_a_of_type_Iiv$a.anA != 2) && (localiiv.jdField_a_of_type_Iiv$a.anA != 6))) {
          break label1626;
        }
        if ((!this.OD) && (localiiv.jdField_a_of_type_Iiv$a.anA != 6)) {
          break label1609;
        }
        e(6, 1, null);
        label1325:
        this.Ox = false;
        label1330:
        this.mApp.l(new Object[] { Integer.valueOf(203), localObject, Boolean.valueOf(this.Ox), Long.valueOf(paramLong) });
        if ((sw()) && (this.Ox) && ((localiiv.jdField_a_of_type_Iiv$a.chatType == 1) || (localiiv.jdField_a_of_type_Iiv$a.chatType == 2)))
        {
          localiiv.amG();
          e(0, 0, null);
        }
        localiiv.n(paramLong, false);
        localiiv.o(paramLong, false);
        localiiv.C(paramLong, 0L);
        localiiv.bN(paramLong);
        paramBoolean = false;
        if (this.OD) {
          break label1644;
        }
        QLog.d(TAG, 2, "close session removeSession sessionId = " + str);
        paramBoolean = this.jdField_b_of_type_Igv.c(paramLong, str);
      }
      for (;;)
      {
        paramString = jko.a(this.mApp);
        if ((paramString == null) || (!paramString.isActive()) || (this.OD)) {
          break;
        }
        paramString.cancelNotification(str);
        if (!paramBoolean) {
          break;
        }
        alx();
        return;
        if (localiiv.amI != 2) {
          break label763;
        }
        anot.a(null, "CliOper", "", "", "0X8008B2A ", "0X8008B2A ", 0, 0, "", "", jll.formatTime(bt()), "");
        break label763;
        label1585:
        e(paramLong, str, (String)localObject, i);
        break label949;
        label1599:
        if (!this.Ox) {
          break label1261;
        }
        break label1261;
        label1609:
        e(localiiv.jdField_a_of_type_Iiv$a.anA, 1, null);
        break label1325;
        label1626:
        if (!this.OD) {
          break label1330;
        }
        e(6, 1, null);
        break label1330;
        label1644:
        this.jdField_b_of_type_Igv.N(str, 3);
      }
    }
  }
  
  public void b(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    ArrayList localArrayList = a(paramLong1, paramBoolean, paramLong2);
    if (localArrayList != null) {
      this.mApp.l(new Object[] { Integer.valueOf(142), localArrayList, Integer.valueOf(localArrayList.size()) });
    }
    if (paramLong1 == Long.valueOf(this.mApp.getCurrentAccountUin()).longValue())
    {
      if (paramBoolean) {
        anot.a(null, "CliOper", "", "", "0X8005DF2", "0X8005DF2", 0, 0, "", "", "", "");
      }
      anot.a(null, "CliOper", "", "", "0X8005DF0", "0X8005DF0", 0, 0, "", "", "", "");
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    QLog.d(TAG, 1, "onPeerSwitchTerminal. fromUin = " + paramString + ", peerTerminalType = " + paramInt1 + ", peerSdkVersion = " + paramInt2 + ", roomId = " + paramLong);
    if (this.mApp != null) {
      this.mApp.l(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(true) });
    }
    b().QV = true;
    paramString = igv.a().a(paramString);
    if (paramString != null)
    {
      paramString.kE(paramInt2);
      paramString.kF(paramInt1);
      paramString.bP(paramLong);
    }
    a("onPeerSwitchTerminal", b());
  }
  
  public void b(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    paramLong = AudioHelper.hG();
    if ((paramInt == 1) && (1L == b().li))
    {
      b().li = 0L;
      by(paramLong);
    }
  }
  
  public void b(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    paramString = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.receiveTransferMsg(paramString, paramArrayOfByte);
    this.mApp.l(new Object[] { Integer.valueOf(122), paramString });
  }
  
  public void b(String paramString, long paramLong, int paramInt)
  {
    long l = AudioHelper.hG();
    QLog.w(TAG, 1, "onOtherTerminalChatingStatus, fromUin[" + paramString + "], roomid[" + paramLong + "], type[" + paramInt + "], seq[" + l + "]");
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      return;
    }
    Object localObject = igv.a(3, paramString, new int[0]);
    localObject = this.jdField_b_of_type_Igv.c((String)localObject);
    if (localObject != null) {
      ((iiv)localObject).e(l, "onOtherTerminalChatingStatus", paramInt);
    }
    if ((paramInt != 0) && (!TextUtils.isEmpty(b().peerUin)) && ((!b().peerUin.equals(paramString)) || (b().amI == 0)))
    {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendQueryRoomInfoRequest(paramLong, Long.valueOf(paramString).longValue());
      QLog.d(TAG, 1, "onOtherTerminalChatingStatus sendQueryRoomInfoRequest");
    }
    a(0, paramString, paramLong, paramInt);
  }
  
  public void b(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.mApp.l(new Object[] { Integer.valueOf(41), paramString, Long.valueOf(paramLong), paramArrayOfByte });
  }
  
  void b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "sendVideoConfigReqMsg: buf[2] = " + paramArrayOfByte[2]);
    }
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), iho.class);
    localNewIntent.putExtra("reqType", 3);
    localNewIntent.putExtra("selfuin", paramString1);
    localNewIntent.putExtra("toUin", ihk.u(paramString2));
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    a(localNewIntent);
  }
  
  public void b(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onNetworkMonitorInfo_TRAE:network is bad,detail is null");
      }
    }
    label192:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if ((QLog.isColorLevel()) && (paramLong != 1L)) {
              break label192;
            }
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "onNetworkMonitorInfo_TRAE:network is bad");
            }
            if (!this.mApp.sM()) {
              try
              {
                paramArrayOfByte = new String(paramArrayOfByte, "GBK");
                this.mApp.l(new Object[] { Integer.valueOf(26), paramArrayOfByte });
                return;
              }
              catch (NullPointerException paramArrayOfByte)
              {
                if (QLog.isColorLevel())
                {
                  QLog.d(TAG, 2, "onNetworkMonitorInfo fromUin = " + paramString + ", info = " + paramLong, paramArrayOfByte);
                  return;
                }
              }
              catch (UnsupportedEncodingException paramArrayOfByte) {}
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d(TAG, 2, "onNetworkMonitorInfo fromUin = " + paramString + ", info = " + paramLong, paramArrayOfByte);
        return;
      } while (paramLong != 0L);
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        this.mApp.l(new Object[] { Integer.valueOf(19), paramArrayOfByte });
        return;
      }
      catch (Exception paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "onNetworkMonitorInfo fromUin = " + paramString + ", info = " + paramLong, paramArrayOfByte);
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    String str = null;
    if (paramLong == 0L) {
      b().QC = false;
    }
    for (;;)
    {
      this.mApp.l(new Object[] { Integer.valueOf(27), str });
      return;
      if (paramLong == 1L)
      {
        b().QC = true;
      }
      else if (paramLong == 100L)
      {
        b().QD = false;
      }
      else if (paramLong == 101L)
      {
        b().QD = true;
        if (paramArrayOfByte != null) {
          str = new String(paramArrayOfByte);
        }
      }
      else
      {
        b().QC = false;
        b().QD = false;
      }
    }
  }
  
  public boolean b(iiv paramiiv1, iiv paramiiv2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramiiv1.peerUin);
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      boolean bool1;
      for (;;)
      {
        localThrowable.printStackTrace();
        continue;
        bool1 = false;
      }
      for (;;)
      {
        label164:
        int i;
        try
        {
          paramiiv2.n(paramLong1, paramiiv1.PY);
          a(paramString, paramiiv2.amI, false, false, false);
          if ((this.aY != null) && (this.mApp.getHandler() != null)) {
            this.mApp.getHandler().removeCallbacks(this.aY);
          }
          if (!paramiiv1.sU()) {
            a(paramLong1, 2131230749, 1, null);
          }
          i = paramiiv1.amI;
          paramiiv2.peerUin = paramiiv1.peerUin;
          paramiiv2.n(paramLong1, paramiiv1.PY);
          paramiiv2.PV = paramiiv1.PV;
          paramiiv2.P("onGAudioInvite", paramiiv1.QB);
          paramiiv2.aQ("onGAudioInvite", paramiiv1.deviceName);
          paramiiv2.Rp = true;
          paramiiv2.bs(3, 12);
          paramiiv1.bs(3, 12);
          P(paramiiv1.peerUin, 21);
          if (i == 1)
          {
            paramiiv2.e(paramLong1, "onGAudioInvite.2", 3);
            paramiiv2.uinType = jll.cM(paramInt);
            paramiiv2.ll = paramLong3;
            if (paramArrayOfLong != null) {
              paramiiv2.f = paramArrayOfLong;
            }
            paramiiv2.aa("onGAudioInvite.2", 1);
            if (this.mApp.countObservers() <= 0) {
              break label547;
            }
            paramiiv2.ac("onGAudioInvite1", jjc.cH(paramiiv2.uinType));
            this.mApp.l(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            paramiiv1 = jko.a(this.mApp);
            int j = 0;
            if (paramiiv1 != null)
            {
              boolean bool2 = paramiiv1.isActive();
              j = bool2;
              if (bool2)
              {
                paramiiv1.cancelNotification(paramString);
                j = bool2;
              }
            }
            if (j == 0) {
              break;
            }
            alx();
            return bool1;
          }
        }
        catch (Exception paramiiv1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "onGAudioInvite, Exception", paramiiv1);
          }
          this.jdField_b_of_type_Igv.c(paramLong1, paramString);
          return bool1;
        }
        if (i == 2)
        {
          paramiiv2.e(paramLong1, "onGAudioInvite.3", 4);
        }
        else if (i == 4)
        {
          paramiiv2.e(paramLong1, "onGAudioInvite.4", 4);
        }
        else
        {
          paramiiv2.e(paramLong1, "onGAudioInvite.5", 3);
          continue;
          label547:
          if (this.mApp.isBackground_Stop)
          {
            paramiiv2.ac("onGAudioInvite2", 0);
            a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
            hO(false);
          }
        }
      }
    }
    if ((l1 == paramLong2) && (paramiiv1 != paramiiv2))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "dealSwitchP2PAV ], peerUin[" + l1 + "], friendUin[" + paramLong2 + "], ret[" + bool1 + "], main[" + paramiiv1 + "], new[" + paramiiv2 + "]");
      }
      if (!bool1) {
        break label586;
      }
      if (paramiiv1.ana != 0) {
        break label164;
      }
      paramiiv1.Y("onGAudioInvite.2", 0);
      this.jdField_b_of_type_Igv.c(paramLong1, paramString);
      return bool1;
    }
    label586:
    return false;
  }
  
  public void bA(long paramLong)
  {
    int i;
    if (b().PY)
    {
      i = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.switchVideo(b().peerUin);
      if ((QLog.isColorLevel()) || (i == -1)) {
        QLog.w(TAG, 1, "switchVideo , ret[" + i + "], seq[" + paramLong + "]");
      }
    }
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.switchAudio(b().peerUin);
    } while ((!QLog.isColorLevel()) && (i != -1));
    QLog.w(TAG, 1, "switchAudio , ret[" + i + "], seq[" + paramLong + "]");
  }
  
  public void bB(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "send0x265 --> Send 0x265 openId = " + paramLong);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), iho.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", localArrayList);
    a(localNewIntent);
  }
  
  public void bC(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(TAG, 2, "WL_DEBUG onSetMicBySelf uin = " + paramLong);
    }
    synchronized (this.hZ)
    {
      Iterator localIterator = this.hZ.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.uin == paramLong) {
          if (!localb.Pl)
          {
            localb.Pl = true;
            this.mApp.l(new Object[] { Integer.valueOf(157), Long.valueOf(paramLong), Boolean.valueOf(true) });
          }
        }
      }
      return;
    }
  }
  
  public void bD(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onSelfAudioVolumeChange qav.value:=" + paramLong);
    }
    try
    {
      this.mApp.l(new Object[] { Integer.valueOf(20002), Long.valueOf(paramLong), Long.valueOf(0L), Long.valueOf(100L) });
      return;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public void bp(int paramInt1, int paramInt2)
  {
    long l = AudioHelper.hG();
    QLog.w(TAG, 1, "onChangePreviewSize, size[" + paramInt1 + ", " + paramInt2 + "], localHasVideo[" + b().PY + "], preSize[" + ilj.aoB + ", " + ilj.aoC + "], seq[" + l + "]");
    if (b().PY)
    {
      int j;
      int i;
      if (paramInt1 >= 640)
      {
        j = paramInt1;
        i = paramInt2;
        if (paramInt2 >= 480) {}
      }
      else
      {
        QLog.w(TAG, 1, "onChangePreviewSize, size[" + paramInt1 + ", " + paramInt2 + "], use min previewSize[640,480]");
        i = 480;
        j = 640;
      }
      if ((ilj.aoB != j) || (ilj.aoC != i)) {
        this.mApp.l(new Object[] { Integer.valueOf(32), Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l) });
      }
    }
  }
  
  public long bt()
  {
    if (b().lj == 0L) {
      return 0L;
    }
    long l = (SystemClock.elapsedRealtime() - b().lj) / 1000L + b().lk;
    this.mApp.bL(l);
    return l;
  }
  
  public long bu()
  {
    return this.kM;
  }
  
  public long bv()
  {
    return a(b());
  }
  
  public long bw()
  {
    return b(b());
  }
  
  public void bw(ArrayList<Long> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "send0x265 --> tinyIDList is null Or size is 0");
      }
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), iho.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", paramArrayList);
    a(localNewIntent);
  }
  
  public long bx()
  {
    long l = 0L;
    if ((b().amI == 3) || (b().amI == 4)) {
      l = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getEnterRoomTime();
    }
    return l;
  }
  
  public void bx(ArrayList<AVPhoneUserInfo> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "on 0x626Recv --> Size = " + paramArrayList.size());
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "on0x626Recv --> no data");
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    paramArrayList = paramArrayList.iterator();
    AVPhoneUserInfo localAVPhoneUserInfo;
    Iterator localIterator;
    int i;
    label114:
    Object localObject;
    if (paramArrayList.hasNext())
    {
      localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.next();
      localIterator = b().ii.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        localObject = (AVPhoneUserInfo)localIterator.next();
        if ((((AVPhoneUserInfo)localObject).account == 0L) || (((AVPhoneUserInfo)localObject).account != localAVPhoneUserInfo.account)) {
          break label450;
        }
        ((AVPhoneUserInfo)localObject).telInfo.mobile = localAVPhoneUserInfo.telInfo.mobile;
        ((AVPhoneUserInfo)localObject).telInfo.nation = localAVPhoneUserInfo.telInfo.nation;
        ((AVPhoneUserInfo)localObject).telInfo.prefix = localAVPhoneUserInfo.telInfo.prefix;
        i = 1;
      }
    }
    label450:
    for (;;)
    {
      break label114;
      if ((i == 0) && (QLog.isColorLevel()))
      {
        localStringBuilder.append("on0x626Recv --> can not find the item . Info = ");
        localStringBuilder.append(localAVPhoneUserInfo.toString());
        localStringBuilder.append("\n");
      }
      localIterator = this.ib.iterator();
      while (localIterator.hasNext())
      {
        localObject = (b)localIterator.next();
        if ((((b)localObject).accountType == 1) && (((b)localObject).uin == localAVPhoneUserInfo.account))
        {
          if (((b)localObject).a == null) {
            ((b)localObject).a = new AVPhoneUserInfo();
          }
          ((b)localObject).a.accountType = 2;
          ((b)localObject).a.account = localAVPhoneUserInfo.account;
          ((b)localObject).a.telInfo.mobile = localAVPhoneUserInfo.telInfo.mobile;
          ((b)localObject).a.telInfo.nation = localAVPhoneUserInfo.telInfo.nation;
          ((b)localObject).a.telInfo.prefix = localAVPhoneUserInfo.telInfo.prefix;
        }
      }
      break;
      if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
        QLog.e(TAG, 2, localStringBuilder.toString());
      }
      this.mApp.l(new Object[] { Integer.valueOf(406) });
      return;
    }
  }
  
  public long by()
  {
    switch (b().amI)
    {
    default: 
      return 0L;
    case 1: 
    case 2: 
      return bv();
    }
    return bw();
  }
  
  public void by(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "onSubState2 seq[" + paramLong + "]");
    }
    TraeHelper.a(this.mApp, true, paramLong);
    iiv localiiv = b();
    alD();
    localiiv.Y("onSubState2", 4);
    localiiv.C(paramLong, SystemClock.elapsedRealtime());
    if (this.mApp.countObservers() > 0)
    {
      this.mApp.l(new Object[] { Integer.valueOf(13), Long.valueOf(paramLong) });
      if (!localiiv.PV) {
        break label219;
      }
      b(true, localiiv.peerUin);
    }
    for (;;)
    {
      this.Oz = false;
      this.mApp.getHandler().postDelayed(new VideoController.9(this, paramLong), 50L);
      a(localiiv.sessionId, localiiv.amI, true, true, true);
      jjk.k(this);
      jjk.c(this, true);
      jjk.b(this, true);
      if (this.mApp != null)
      {
        ilu localilu = this.mApp.a();
        if (localilu != null) {
          localilu.a(localiiv);
        }
      }
      return;
      alx();
      break;
      label219:
      b(false, localiiv.peerUin);
    }
  }
  
  void bz(long paramLong)
  {
    if ((b().uinType == 1011) || (b().uinType == 21) || (sB())) {}
    while (b().li != 0L) {
      return;
    }
    long l = b().colorRingId;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "startReachedRing, peer colorRingId=" + l);
    }
    String str = aqpr.p(l, 3);
    if (new File(str).exists())
    {
      TraeHelper.a().a(paramLong, this.mApp, 0, str, -1, null);
      b().PU = true;
      int i = b().vipType;
      anot.a(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i, l + "", "", "");
      return;
    }
    TraeHelper.a().a(paramLong, this.mApp, 2131230756, null, -1, null);
    b().PU = true;
  }
  
  public int c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((b().amI == 1) || (b().amI == 2)) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.SetOutputFormat(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return -1;
  }
  
  int c(String paramString, boolean paramBoolean)
  {
    int j = 1;
    int i = 0;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      i = -1;
    }
    while (!this.OB) {
      return i;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
      paramString = paramString + "_stopOrStartGAudioTRAE_stop";
      this.OP = this.OO;
      a(paramString, false, false);
      M(paramString, true);
      V(paramString, 1);
      return 0;
    }
    paramString = paramString + "_stopOrStartGAudioTRAE";
    if (!this.OP)
    {
      paramBoolean = true;
      a(paramString, paramBoolean, false);
      M(paramString, this.OP);
      if (!this.OP) {
        break label164;
      }
    }
    label164:
    for (i = j;; i = 0)
    {
      V(paramString, i);
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioRecv();
      return 0;
      paramBoolean = false;
      break;
    }
  }
  
  public int c(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.SetAudioOutput(paramString, paramBoolean);
  }
  
  public Pair<Integer, ArrayList<b>> c()
  {
    ArrayList localArrayList2;
    HashSet localHashSet;
    Object localObject4;
    synchronized (this.hZ)
    {
      Object localObject1 = this.hZ;
      localObject3 = aM();
      if (((ArrayList)localObject1).size() == 0)
      {
        localObject1 = new Pair(Integer.valueOf(0), null);
        return localObject1;
      }
      localArrayList2 = new ArrayList();
      localHashSet = new HashSet();
      localObject4 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        b localb = (b)((Iterator)localObject4).next();
        localb.Pn = true;
        localArrayList2.add(localb);
        localHashSet.add(Long.valueOf(localb.uin));
      }
    }
    int i = localArrayList2.size();
    Object localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (b)((Iterator)localObject3).next();
      if (!localHashSet.contains(Long.valueOf(((b)localObject4).uin)))
      {
        ((b)localObject4).Pn = false;
        localArrayList2.add(localObject4);
      }
    }
    QLog.d(TAG, 1, "updateMemberAttendedInfo joint number size:=" + localObject2.size() + ";all members:=" + localArrayList2.size());
    Pair localPair = new Pair(Integer.valueOf(i), localArrayList2);
    return localPair;
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    String str = paramInt2 + "|" + paramInt3 + "|" + paramLong;
    qav_gvideo_sdk_transfer.RespInfo localRespInfo = a(paramInt1, str.getBytes());
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "kickOutUsers, event[" + paramInt1 + "], result[" + localRespInfo.uint32_result.get() + "], data[" + str + "]");
    }
  }
  
  public void c(int paramInt1, long paramLong, int paramInt2)
  {
    iiv localiiv = b();
    if (localiiv.isBackground) {}
    while (localiiv.e(paramLong, paramInt2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onRemoteVideoDataComeIn-->uin = " + paramLong + ", videoSrcType=" + paramInt2);
    }
    paramInt1 = 0;
    while (paramInt1 < localiiv.jdField_if.size())
    {
      if ((((ioa)localiiv.jdField_if.get(paramInt1)).uin == paramLong) && (((ioa)localiiv.jdField_if.get(paramInt1)).videoSrcType == paramInt2)) {
        ((ioa)localiiv.jdField_if.get(paramInt1)).Tr = true;
      }
      paramInt1 += 1;
    }
    this.mApp.l(new Object[] { Integer.valueOf(81), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void c(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "onGaSwitchVideoResult, result[" + paramInt1 + "], info[" + paramLong1 + "], groupId[" + paramLong2 + "], relationType[" + paramInt2 + "], seq[" + l + "]");
    }
    if (paramInt1 == 96) {
      if (b().ih.size() > 0)
      {
        b().a(l, "onGaSwitchVideoResult", true, true);
        this.OA = true;
        int j = 0;
        if (j < b().jdField_if.size())
        {
          localObject = (ioa)b().jdField_if.get(j);
          int i;
          if (sm()) {
            if (((ioa)localObject).videoSrcType == 1)
            {
              i = 1;
              label178:
              if ((((ioa)localObject).uin != Long.valueOf(this.mApp.getCurrentAccountUin()).longValue()) || (i == 0)) {
                break label226;
              }
            }
          }
          for (;;)
          {
            j += 1;
            break;
            i = 0;
            break label178;
            i = 1;
            break label178;
            label226:
            if (a(((ioa)localObject).uin, ((ioa)localObject).videoSrcType, b().ih)) {
              ((ioa)localObject).isRender = true;
            } else {
              ((ioa)localObject).isRender = false;
            }
          }
        }
        b().ih.clear();
        b().b(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue(), false, true);
        Object localObject = f(b().jdField_if);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "onGaSwitchVideoResult-->Display VideoViewInfo List = " + (String)localObject);
        }
      }
    }
    for (;;)
    {
      if (this.mApp != null) {
        this.mApp.l(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l) });
      }
      return;
      this.OA = false;
      b().b(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue(), true, true);
      b().ih.clear();
    }
  }
  
  public void c(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "sendLeaveMsg uinType: " + paramInt + ", friendUin: " + paramString1 + ", friendName: " + paramString2 + ", extraUin: " + paramString3 + ", isPtt: " + paramBoolean);
    }
    if (this.mApp != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.leaveMsg");
      localIntent.putExtra("uinType", paramInt);
      localIntent.putExtra("friendUin", paramString1);
      localIntent.putExtra("friendName", paramString2);
      paramString2 = paramString3;
      if (paramInt == 1006)
      {
        paramString2 = paramString3;
        if (paramString3 == null) {
          paramString2 = paramString1;
        }
      }
      localIntent.putExtra("extraUin", paramString2);
      localIntent.putExtra("isPtt", paramBoolean);
      localIntent.setPackage(this.mApp.getApp().getPackageName());
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void c(int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onCheckScreenShareValid, isValid[" + paramInt + "], detail[" + paramArrayOfByte + "]");
    }
    this.mApp.l(new Object[] { Integer.valueOf(521), Integer.valueOf(paramInt), paramArrayOfByte });
  }
  
  public void c(long paramLong1, int paramInt, long paramLong2)
  {
    a(paramLong1, paramInt, paramLong2, -1, false);
  }
  
  public void c(long paramLong1, long paramLong2, String paramString)
  {
    QLog.w(TAG, 1, "onGAudioInviteRespFail, groupId[" + paramLong1 + "], mGAudioGroupId[" + this.kJ + "], err[" + paramLong2 + "], msg[" + paramString + "]");
    if (paramLong1 == this.kJ) {
      QQToast.a(getAppContext(), 2131697862, 1).show();
    }
  }
  
  public void c(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onNetworkInfo_S2C:flag is:" + paramLong);
    }
    if (paramLong != 0L) {
      try
      {
        String str = new String(paramArrayOfByte, "UTF-8");
        this.mApp.l(new Object[] { Integer.valueOf(31), Integer.valueOf((int)paramLong), str });
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(TAG, 2, "onNetworkInfo_S2C fromUin = " + paramString + ", info = " + paramArrayOfByte, localNullPointerException);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(TAG, 2, "onNetworkInfo_S2C fromUin = " + paramString + ", info = " + paramArrayOfByte, localUnsupportedEncodingException);
        return;
      }
    }
    this.mApp.l(new Object[] { Integer.valueOf(31), Integer.valueOf(0), null });
  }
  
  public void checkScreenShareAvailable()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "checkScreenShareValid");
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.checkScreenShareAvailable();
    }
  }
  
  public boolean ck(String paramString)
  {
    boolean bool = false;
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "StopGVideo, from[" + paramString + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopVideoRecv() != 0)
      {
        if (b().jdField_if.size() == 0) {
          b().a(l, "StopGVideo", false, true);
        }
        bool = true;
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return bool;
      } while (!QLog.isColorLevel());
      QLog.e(TAG, 2, "StopGVideo-->Stop GVideo Failed.The Cmd Did Not Send Suc");
      return false;
    }
    QLog.e(TAG, 2, "StopGVideo-->Stop GVideo Failed.The mGAudioCtrl is null");
    return false;
  }
  
  public boolean cl(String paramString)
  {
    int i = getPeerTerminalType(paramString);
    return (i == 5) || (i == 14);
  }
  
  public boolean co(String paramString)
  {
    return a(paramString, 1, 0L);
  }
  
  public int cp(int paramInt)
  {
    if (!b().isConnected()) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setGroundGlassSwitch(b().peerUin, paramInt);
  }
  
  public int d(int paramInt, String paramString)
  {
    boolean bool = b().isConnected();
    QLog.w(TAG, 1, "sendAVFunChatMsg, type[" + paramInt + "], data[" + paramString + "], isConnected[" + bool + "]");
    if (!bool) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendAVFunChatMsg(b().peerUin, paramInt, paramString);
  }
  
  public int d(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((ikr)this.mApp.a(4)).anB();
    }
    for (;;)
    {
      this.OF = paramBoolean;
      return 0;
      Iterator localIterator = this.fb.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.fb.clear();
    }
  }
  
  public String d(String paramString1, String paramString2, int paramInt)
  {
    int j = 1004;
    int i;
    if (paramInt == 1) {
      i = 1000;
    }
    for (;;)
    {
      return this.mApp.getDisplayName(i, paramString1, paramString2);
      i = j;
      if (paramInt != 2)
      {
        i = j;
        if (this.mApp.isFriend(paramString1)) {
          i = 0;
        }
      }
    }
  }
  
  void d(int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onGaRoomSettingChanged-->relationType = " + paramInt1 + " relationUin = " + paramLong + " changedType = " + paramInt2);
    }
    if (paramInt2 == 102) {
      b().QK = true;
    }
    for (;;)
    {
      this.mApp.l(new Object[] { Integer.valueOf(85), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return;
      if (paramInt2 == 103) {
        b().QK = false;
      }
    }
  }
  
  void d(long paramLong, String paramString, int paramInt)
  {
    QLog.w(TAG, 1, "avideo onCloseVideo fromUin[" + paramString + "], type[" + paramInt + "], seq[" + paramLong + "], mStartRing[" + this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable + "]");
    amc();
    String str = igv.a(3, paramString, new int[0]);
    if (this.jdField_b_of_type_Igv.ci(str)) {}
    for (iiv localiiv = this.jdField_b_of_type_Igv.c(str); localiiv == null; localiiv = this.jdField_b_of_type_Igv.c(str))
    {
      igd.aL(TAG, "onCloseVideo fail to find session");
      return;
      str = igv.a(100, paramString, new int[0]);
    }
    localiiv.PS = false;
    if ((sB()) && (paramString != null) && (!paramString.equals(localiiv.peerUin)))
    {
      igd.aK(TAG, "NearbyVideoChat fromUin = " + paramString + ",peerUin = " + localiiv.peerUin);
      return;
    }
    if (this.jdField_a_of_type_Igx != null)
    {
      this.jdField_a_of_type_Igx.stopMonitor();
      this.jdField_a_of_type_Igx = null;
    }
    this.OG = false;
    a(paramString, "inviteUIState", "");
    a(paramString, "screenState", "");
    alD();
    if ((localiiv.li == 1L) && ((paramInt == 2) || (paramInt == 24)))
    {
      e(paramLong, str, paramString, 3);
      label296:
      if (!localiiv.tc()) {
        break label440;
      }
      localiiv.ana = paramInt;
      if ((localiiv.tc()) && (paramInt == localiiv.amI)) {
        localiiv.C(paramLong, 0L);
      }
      localiiv.Y("onCloseVideo.isBeInviting", 6);
      this.mApp.l(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      P(localiiv.peerUin, localiiv.ana);
    }
    for (;;)
    {
      label398:
      if ((this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null) && (this.mApp != null))
      {
        this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        return;
        e(paramLong, str, paramString, paramInt);
        break label296;
        label440:
        if (localiiv.ta())
        {
          localiiv.ana = paramInt;
          localiiv.C(paramLong, 0L);
          int j = 2131230754;
          switch (paramInt)
          {
          default: 
            i = 0;
            this.jdField_a_of_type_ComTencentAvVideoController$c.seq = paramLong;
            if (i == 0) {
              break;
            }
          }
          for (int i = 4;; i = 3)
          {
            a(paramLong, j, i, this.jdField_a_of_type_ComTencentAvVideoController$c);
            localiiv.Y("onCloseVideo.isInviting1", 5);
            this.mApp.l(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
            break label398;
            anot.a(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "2", "", "", "");
            i = 0;
            j = 2131230753;
            break label531;
            if (sw()) {
              break;
            }
            if (localiiv.li != 2L)
            {
              anot.a(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "1", "", "", "");
              i = 0;
              j = 2131230753;
              break label531;
            }
            j = 2131230754;
            i = 1;
            break label531;
            this.jdField_b_of_type_ComTencentAvVideoController$c.seq = paramLong;
            a(paramLong, 2131230754, 1, this.jdField_b_of_type_ComTencentAvVideoController$c);
            localiiv.Y("onCloseVideo.isInviting", 6);
            this.mApp.l(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
            return;
            if (sw()) {
              break;
            }
            anot.a(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "3", "", "", "");
            i = 0;
            j = 2131230753;
            break label531;
            j = 2131230753;
            i = 0;
            break label531;
          }
        }
        label531:
        if (!localiiv.tf())
        {
          localiiv.ana = paramInt;
          if (localiiv.tc()) {
            localiiv.C(paramLong, 0L);
          }
          if (((paramInt == 2) || (paramInt == 24)) && (localiiv.uinType == 1011))
          {
            localiiv.jdField_a_of_type_Iiv$a.anA = 0;
            if (paramInt == 2)
            {
              localiiv.jdField_a_of_type_Iiv$a.anA = 6;
              this.OD = true;
            }
            if (!this.OD) {
              break label1080;
            }
            e(6, 0, null);
            label950:
            jko localjko = jko.a(this.mApp);
            if (this.OD) {
              break label1097;
            }
            if (localjko != null) {
              localjko.axu();
            }
          }
          label976:
          localiiv.Y("onCloseVideo.isClosing1", 6);
          if ((!sB()) && (!jkg.isCalling(this.mApp.getApp()))) {
            break label1104;
          }
          O(localiiv.peerUin, 209);
          ko(209);
          P(localiiv.peerUin, localiiv.ana);
        }
      }
    }
    for (;;)
    {
      this.mApp.l(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      break label398;
      break;
      label1080:
      e(localiiv.jdField_a_of_type_Iiv$a.anA, 0, null);
      break label950;
      label1097:
      alx();
      break label976;
      label1104:
      this.jdField_b_of_type_ComTencentAvVideoController$c.seq = paramLong;
      a(paramLong, 2131230754, 1, this.jdField_b_of_type_ComTencentAvVideoController$c);
      jko.a(this.mApp).cancelNotification(str);
    }
  }
  
  public void d(long paramLong, ArrayList<String> paramArrayList)
  {
    int j = paramArrayList.size();
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      String str = (String)paramArrayList.get(i);
      if (str != null) {
        arrayOfLong[i] = Long.valueOf(str).longValue();
      }
      i += 1;
    }
    a(arrayOfLong, false);
  }
  
  public void d(Class paramClass)
  {
    if (this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker != null) {
      this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker.je(paramClass.getName());
    }
  }
  
  public void d(String paramString, int paramInt, long paramLong)
  {
    long l = AudioHelper.hG();
    iiv localiiv = this.jdField_b_of_type_Igv.b(paramString);
    QLog.w(TAG, 1, "onCloseVideo, fromUin[" + paramString + "], reason[" + paramInt + "], extraParam[" + paramLong + "], seq[" + l + "], Main[" + this.jdField_b_of_type_Igv.a() + "], come[" + localiiv + "]");
    if (localiiv == null) {
      QLog.i(TAG, 1, "onCloseVideo, fromUin[" + paramString + "], no session");
    }
    Object localObject;
    do
    {
      return;
      localObject = this.mApp.a();
      if (localObject != null) {
        ((ihm)localObject).kA(paramInt);
      }
      if (sB()) {
        alY();
      }
      if (((localiiv.uinType != 1011) && (localiiv.uinType != 21)) || (!localiiv.jdField_a_of_type_Iiv$a.Rt)) {
        break;
      }
      igd.aK(TAG, "onCloseVideo fWaitAutoAnswer = " + localiiv.jdField_a_of_type_Iiv$a.Rt);
      localiiv.jdField_a_of_type_Iiv$a.Rt = false;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, 0, this);
    } while ((sB()) && ((paramInt == 2) || (paramInt == 3)));
    kq(paramInt);
    return;
    ip(localiiv.sessionId);
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 13: 
    case 16: 
    case 17: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    default: 
    case 0: 
      for (paramInt = 5;; paramInt = 0)
      {
        P(paramString, paramInt);
        return;
      }
    case 1: 
      if (paramLong == 9L) {
        paramInt = 43;
      }
      break;
    }
    for (;;)
    {
      if ((paramLong == 12L) || (paramLong == 13L) || (paramLong == 15L) || (paramLong == 16L))
      {
        if (localiiv.amI != 2) {
          break label798;
        }
        anot.a(null, "CliOper", "", "", "0X800478B", "0X800478B", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramInt == 49) {
          hQ(true);
        }
        d(l, paramString, paramInt);
        return;
        if (paramLong == 10L)
        {
          paramInt = 54;
          break;
        }
        if (paramLong == 5L)
        {
          paramInt = 49;
          break;
        }
        if ((paramLong == 12L) || (paramLong == 16L))
        {
          a(localiiv.uinType, localiiv.peerUin, localiiv.ln, 0);
          paramInt = 52;
          break;
        }
        if (paramLong == 13L)
        {
          paramInt = 50;
          break;
        }
        if (paramLong == 14L)
        {
          paramInt = 51;
          if (localiiv.amI == 2)
          {
            anot.a(null, "CliOper", "", "", "0X800478A", "0X800478A", 0, 0, "", "", "", "");
            break;
          }
          anot.a(null, "CliOper", "", "", "0X800478E", "0X800478E", 0, 0, "", "", "", "");
          break;
        }
        if (paramLong == 15L)
        {
          paramInt = 55;
          break;
        }
        if (paramLong == 17L)
        {
          paramInt = 56;
          anot.a(null, "CliOper", "", "", "0X80049C9", "0X80049C9", 0, 0, "", "", "", "");
          break;
        }
        if (paramLong == 6L)
        {
          paramInt = 72;
          break;
        }
        if (paramLong == 7L)
        {
          paramInt = 24;
          break;
        }
        if (paramLong != 983055L) {
          break label1103;
        }
        paramInt = 63;
        break;
        label798:
        anot.a(null, "CliOper", "", "", "0X800478F", "0X800478F", 0, 0, "", "", "", "");
      }
      if (paramLong == 100L)
      {
        localObject = igv.a(3, paramString, new int[0]);
        localiiv = null;
        if (this.jdField_b_of_type_Igv.ci((String)localObject)) {
          localiiv = this.jdField_b_of_type_Igv.c((String)localObject);
        }
        if ((localiiv != null) && (localiiv.state == 1))
        {
          QLog.w(TAG, 1, "onCloseVideo, set autoAcceptChat, seq[" + l + "]");
          localiiv.PS = true;
          return;
        }
      }
      paramInt = 3;
      if ((paramLong == 3L) || (paramLong == 65535L)) {
        paramInt = 42;
      }
      d(l, paramString, paramInt);
      return;
      paramInt = 5;
      break;
      d(l, paramString, 25);
      return;
      paramInt = 9;
      break;
      paramInt = 1;
      break;
      paramInt = 4;
      break;
      paramInt = 10;
      break;
      paramInt = 28;
      break;
      paramInt = 29;
      break;
      paramInt = 39;
      break;
      paramInt = 35;
      break;
      d(l, paramString, 12);
      return;
      paramInt = 21;
      break;
      if (paramLong == 62L)
      {
        localiiv.Qg = false;
        d(l, paramString, 12);
        return;
      }
      if (paramLong == 61L)
      {
        localiiv.Qg = false;
        d(l, paramString, 25);
        return;
      }
      paramInt = 64;
      break;
      paramInt = 62;
      d(l, paramString, 62);
      break;
      label1103:
      paramInt = 2;
    }
  }
  
  public void d(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onGetStrangerFaceSuc uin:" + paramString + ",face :" + paramBitmap);
    }
    a(paramString, paramBitmap, false);
    if (this.mApp.countObservers() > 0) {
      this.mApp.l(new Object[] { Integer.valueOf(201), paramString, paramBitmap });
    }
  }
  
  public void d(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    ScreenShareCtrl localScreenShareCtrl = a();
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.d(paramString, paramArrayOfByte, paramLong);
    }
  }
  
  public String dd(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getPhoneNameByPhoneNum --> phoneNum = " + paramString);
    }
    return this.mApp.dh(paramString);
  }
  
  public void e(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "setRandomChatStatus: " + paramInt1 + ", chatType" + paramInt2 + " ,sessionName: " + paramString);
    }
    Object localObject = b();
    if (localObject != null) {
      ((iiv)localObject).jdField_a_of_type_Iiv$a.chatType = paramInt2;
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("tencent.video.v2q.setChatStatus");
    ((Intent)localObject).putExtra("status", paramInt1);
    ((Intent)localObject).putExtra("type", paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      ((Intent)localObject).putExtra("sessionName", paramString);
    }
    if (sx())
    {
      ((Intent)localObject).putExtra("guild_group_id", b().jdField_a_of_type_Iiv$b.groupId);
      ((Intent)localObject).putExtra("guild_member_num", kD());
      ((Intent)localObject).putExtra("guild_business_type", b().jdField_a_of_type_Iiv$b.Nf);
    }
    ((Intent)localObject).setPackage(this.mApp.getApp().getPackageName());
    this.mApp.getApp().sendBroadcast((Intent)localObject);
  }
  
  void e(int paramInt1, long paramLong, int paramInt2)
  {
    if (paramInt2 == 108)
    {
      b().QM = true;
      localiiv = b();
      if (!ss())
      {
        bool = true;
        localiiv.QL = bool;
        i = kB();
        a("onMVSpeakModeChanged_1", this.kJ, false, false, -1);
        f(-1L, i, kB());
      }
    }
    while (!b().QM) {
      for (;;)
      {
        iiv localiiv;
        this.mApp.l(new Object[] { Integer.valueOf(86), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
        return;
        boolean bool = false;
      }
    }
    b().QM = false;
    int i = kB();
    if (b().QL) {
      a("onMVSpeakModeChanged_2", this.kJ, true, false, -1);
    }
    for (;;)
    {
      f(-1L, i, kB());
      break;
      a("onMVSpeakModeChanged_3", this.kJ, false, false, -1);
    }
  }
  
  public void e(int paramInt, ArrayList<ini> paramArrayList)
  {
    int i = 0;
    while (i < paramInt)
    {
      ini localini = (ini)paramArrayList.get(i);
      a(localini.account, localini.accountType, localini.aqC, false);
      i += 1;
    }
    this.mApp.l(new Object[] { Integer.valueOf(141), paramArrayList });
  }
  
  public void e(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "notifyOtherTerminalChatStatus time:" + paramInt + ", camera:" + paramBoolean1 + ", mic:" + paramBoolean2);
    }
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label119;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.notifyAnotherTerChatStatus(Long.valueOf(b().peerUin).longValue(), (j << 21) + ((i << 20) + (paramInt & 0xFFFFF)));
      }
      return;
      i = 0;
      break;
      label119:
      j = 0;
    }
  }
  
  void e(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    iiv localiiv = this.jdField_b_of_type_Igv.c(paramString1);
    QLog.w(TAG, 1, "sendDoubleChatMsgToMQQ, sessionId[" + paramString1 + "], peerUin[" + paramString2 + "], type[" + paramInt + "], seq[" + paramLong + "], \nsession[" + localiiv + "]", new Throwable("打印调用栈"));
    int i;
    String str;
    if ((localiiv != null) && ((!localiiv.QS) || (localiiv.PR)))
    {
      i = this.jdField_b_of_type_Igv.c(paramString1).uinType;
      str = localiiv.MP;
      if ((TextUtils.isEmpty(localiiv.peerUin)) || (!localiiv.peerUin.contains(paramString2))) {
        break label430;
      }
      paramString2 = localiiv.peerUin;
    }
    label430:
    for (;;)
    {
      if (this.jdField_a_of_type_Imj != null)
      {
        i = 9500;
        if (((localiiv.bindType != 1) || (TextUtils.isEmpty(localiiv.MX))) || (this.OH)) {
          i = 0;
        }
      }
      boolean bool = false;
      if (localiiv.amK == 2) {
        bool = true;
      }
      if (!this.mApp.sM())
      {
        a(paramString1, i, paramInt, bool, paramString2, str, false);
        if ((paramInt == 12) && (!TextUtils.isEmpty(b().gK()))) {
          a(paramString1, i, 66, bool, paramString2, str, false);
        }
        if (!this.OB) {
          break label358;
        }
        a("sendDoubleChatMsgToMQQ_1", paramString1, i, paramString2, str, 1, b().senderUin, false, true);
      }
      for (;;)
      {
        localiiv.QS = true;
        localiiv.PR = false;
        return;
        if (!localiiv.PR) {
          break;
        }
        a(paramString1, i, paramInt, bool, paramString2, str, false);
        break;
        label358:
        if (this.mApp.sM()) {
          a("sendDoubleChatMsgToMQQ_2", paramString1, i, paramString2, str, 2, this.jdField_b_of_type_Igv.c(paramString1).senderUin, true, true);
        } else {
          a("sendDoubleChatMsgToMQQ_3", paramString1, i, paramString2, str, 0, this.jdField_b_of_type_Igv.c(paramString1).senderUin, false, true);
        }
      }
    }
  }
  
  public void e(long paramLong, ArrayList<ini> paramArrayList) {}
  
  public void e(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Imj == null) {
      tar.a(null, "Usr_TV_Video", 2, 0, 0);
    }
    alQ();
    if (QLog.isColorLevel()) {
      QLog.d("smartdevice::sharp", 2, "recv broadcast : receive sharp msg");
    }
    a(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue(), paramArrayOfByte, null);
  }
  
  public void e(String paramString, long paramLong, boolean paramBoolean)
  {
    a(paramString, paramLong, paramBoolean, false, -1);
  }
  
  public void e(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    long l = AudioHelper.hG();
    paramArrayOfByte = b();
    QLog.w(TAG, 1, "onSwitchGroup, fromUin[" + paramString + "], flag[" + paramLong + "], seq[" + l + "]");
    if ((paramArrayOfByte.amI == 3) || (paramArrayOfByte.amI == 4)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(paramArrayOfByte.peerUin))) {
      return;
    }
    hO(true);
    if (!paramArrayOfByte.sU()) {
      a(l, 2131230749, 1, null);
    }
    paramArrayOfByte.ac("onSwitchGroup", jjc.cH(paramArrayOfByte.uinType));
    paramArrayOfByte.ll = 0L;
    paramArrayOfByte.bs(2, 11);
    this.mApp.l(new Object[] { Integer.valueOf(101), Long.valueOf(l) });
    aly();
  }
  
  public void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onRecordAudio=" + paramArrayOfByte.length + ", type=" + paramInt1 + ", size=" + paramInt2);
    }
    if (paramInt1 == 100) {
      if ((this.jdField_a_of_type_ArrayOfJhb != null) && (this.jdField_a_of_type_ArrayOfJhb[0] != null)) {
        this.jdField_a_of_type_ArrayOfJhb[0].g(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    while (((paramInt1 != 3) && (paramInt1 != 0)) || (this.jdField_a_of_type_ArrayOfJhb == null) || (this.jdField_a_of_type_ArrayOfJhb[1] == null)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfJhb[1].g(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean enableLoopback(boolean paramBoolean)
  {
    igd.aK(TAG, "enableLoopback| sessionType=" + b().amI + "enable=" + paramBoolean);
    boolean bool = false;
    if ((b().amI == 1) || (b().amI == 2)) {
      bool = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.enableLoopback(paramBoolean);
    }
    while ((b().amI != 3) && (b().amI != 4)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.enableLoopback(paramBoolean);
  }
  
  public String f(ArrayList<ioa> paramArrayList)
  {
    Object localObject;
    if (paramArrayList == null)
    {
      localObject = "VideoViewInfo[0]";
      return localObject;
    }
    String str = "VideoViewInfo[" + paramArrayList.size() + "]\n";
    int i = 0;
    for (;;)
    {
      localObject = str;
      if (i >= paramArrayList.size()) {
        break;
      }
      str = str + i + ", " + paramArrayList.get(i) + "\n";
      i += 1;
    }
  }
  
  public void f(int paramInt1, long paramLong, int paramInt2)
  {
    long l1 = AudioHelper.hG();
    Object localObject1 = TAG + "|VideoNodeManager";
    Object localObject2 = new StringBuilder().append("onCreateRoomSuc, relationType[").append(paramInt1).append("], groupId[").append(paramLong).append("], mGAudioCtrl[");
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject1, 1, bool + "], mutiAvType[" + paramInt2 + "], seq[" + l1 + "]");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        break;
      }
      return;
    }
    localObject1 = b();
    if (a("onCreateRoomSuc", true, paramInt1, String.valueOf(paramLong))) {
      localObject1 = b();
    }
    for (;;)
    {
      ((iiv)localObject1).QA = true;
      ((iiv)localObject1).id.clear();
      if ((jjc.cG(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        alP();
      }
      label779:
      for (;;)
      {
        hP("onCreateRoomSuc");
        a("onCreateSuc", true, paramInt1, paramLong);
        ((iiv)localObject1).Rc = false;
        if (((iiv)localObject1).Qw)
        {
          ((iiv)localObject1).R("onCreateRoomSuc", true);
          ((iiv)localObject1).Qz = true;
        }
        if (QLog.isColorLevel()) {
          QLog.w(TAG, 1, "onCreateRoomSuc, MainSession[" + b() + "]");
        }
        this.mApp.l(new Object[] { Integer.valueOf(83), Long.valueOf(paramLong), Long.valueOf(l1) });
        if (((paramInt1 == 2) || (paramInt1 == 1)) && ((paramInt2 == 10) || (paramInt2 == 1)))
        {
          this.hY.clear();
          if (QLog.isColorLevel()) {
            QLog.w(TAG, 1, "InviteMemberList onCreateRoomSuc, request memberList]" + 0);
          }
        }
        this.alv = 0;
        localObject2 = this.mApp.a();
        if (localObject2 != null) {
          ((ilu)localObject2).a(b());
        }
        if ((!((iiv)localObject1).Qw) && (((iiv)localObject1).relationType != 3)) {
          break;
        }
        localObject2 = a();
        if (localObject2 == null) {
          break;
        }
        ((ScreenShareCtrl)localObject2).b((iiv)localObject1);
        return;
        int i;
        int j;
        if (((iiv)localObject1).any == 5)
        {
          i = ((iiv)localObject1).kM();
          j = ((iiv)localObject1).kL();
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onCreateRoomSuc, double meeting, terminalType[" + i + "], sdkVersion[" + j + "]");
          }
          long l2;
          if ((i == 2) || (i == 12) || ((i == 4) && (j >= 114)))
          {
            localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
            l2 = ((iiv)localObject1).ll;
            i = ((iiv)localObject1).any;
            ((QQGAudioCtrl)localObject2).inviteUser(new long[] { l2 }, 3, i, 0);
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
            l2 = ((iiv)localObject1).ll;
            i = ((iiv)localObject1).any;
            ((QQGAudioCtrl)localObject2).inviteUser(new long[] { l2 }, 4, i, 0);
          }
        }
        else if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() > 0))
        {
          j = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size();
          localObject2 = new long[j];
          i = 0;
          while (i < j)
          {
            localObject2[i] = ((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i)).longValue();
            i += 1;
          }
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject2, 4, ((iiv)localObject1).any, 0);
        }
        else
        {
          if (AudioHelper.jY(19) == 1) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label779;
            }
            AudioHelper.UA(acfp.m(2131716370));
            this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(null, 4, ((iiv)localObject1).any, 0);
            break;
          }
        }
      }
    }
  }
  
  public void f(long paramLong, int paramInt1, int paramInt2)
  {
    this.mApp.l(new Object[] { Integer.valueOf(15001), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void f(long paramLong1, long paramLong2, int paramInt)
  {
    String str = igv.a(100, String.valueOf(paramLong2), new int[0]);
    Object localObject = this.jdField_b_of_type_Igv.c(str);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "closeDoubleVideoMeetingInvite found no session, relationId :" + paramLong2);
      }
      return;
    }
    ((iiv)localObject).Y("closeDoubleVideoMeetingInvite", 0);
    if (paramInt == 23) {
      a(str, 0, true, ((iiv)localObject).peerUin, ((iiv)localObject).peerUin);
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 403);
      localIntent.putExtra("relationType", 3);
      localIntent.putExtra("relationId", paramLong2);
      localIntent.putExtra("friendUin", paramLong2);
      localIntent.putExtra("MultiAVType", ((iiv)localObject).anb);
      localIntent.putExtra("from", "VideoController4");
      localIntent.setPackage(this.mApp.getApp().getPackageName());
      this.mApp.getApp().sendBroadcast(localIntent);
      boolean bool = this.jdField_b_of_type_Igv.c(paramLong1, str);
      localObject = jko.a(this.mApp);
      if ((localObject == null) || (!((jko)localObject).isActive())) {
        break;
      }
      ((jko)localObject).cancelNotification(str);
      if (!bool) {
        break;
      }
      alx();
      return;
      a(str, 0, paramInt, true, "" + paramLong2, "" + paramLong2, false);
    }
  }
  
  public boolean f(int paramInt, long paramLong)
  {
    return (this.OB) && (this.alr == paramInt) && (this.kJ == paramLong);
  }
  
  public void fp()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "sendGetGatewayIpReq");
    }
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), iho.class);
    localNewIntent.putExtra("reqType", 7);
    a(localNewIntent);
  }
  
  public int g(boolean paramBoolean)
  {
    if ((b().isConnected()) || (this.OB))
    {
      int i = 0;
      if (b().amI == 1) {
        if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
          i = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getVolume(paramBoolean);
        }
      }
      do
      {
        return i;
        if (b().amI != 3) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null);
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getVolume();
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getVolume(paramBoolean);
    }
    return 255;
  }
  
  public void g(long paramLong, int paramInt1, int paramInt2)
  {
    int i = this.jdField_b_of_type_Igv.kv();
    long l = AudioHelper.hG();
    QLog.w(TAG, 1, "onDoubleVideoMeetingInvite, inviteUin[" + paramLong + "], aliveSessionCount[" + i + "], multiAVType[" + paramInt1 + "], multiSubType[" + paramInt2 + "], seq[" + l + "], \nmainSession[" + b() + "]");
    if ((i >= 2) && (paramInt2 != 5)) {
      a(l, true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
    }
    Object localObject1;
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      localObject1 = igv.a(100, String.valueOf(paramLong), new int[0]);
      this.jdField_b_of_type_Igv.a((String)localObject1, false);
      VideoConstants.Ow = this.mApp.sL();
      bool1 = false;
      bool2 = isScreenLocked(this.mApp.getApp().getApplicationContext());
      if ((!TextUtils.equals(b().peerUin, String.valueOf(paramLong))) || ((b().switchState != 16) && (paramInt2 != 5))) {
        break;
      }
      if (this.aY != null)
      {
        this.mApp.getHandler().removeCallbacks(this.aY);
        this.aY = null;
      }
      localObject1 = a();
    } while (localObject1 == null);
    ((ScreenShareCtrl)localObject1).c(l, paramLong, paramInt1, paramInt2);
    return;
    if ((TextUtils.equals(b().peerUin, String.valueOf(paramLong))) && (b().switchState == 11))
    {
      if (this.aY != null)
      {
        this.mApp.getHandler().removeCallbacks(this.aY);
        this.aY = null;
      }
      this.jdField_b_of_type_Igv.c((String)localObject1).Y("onDoubleVideoMeetingInvite.1", 2);
      P(b().peerUin, 2);
    }
    if (b().sY()) {
      if (this.mApp.sN()) {
        bool1 = true;
      }
    }
    for (;;)
    {
      this.Ox = true;
      Object localObject2 = this.jdField_b_of_type_Igv.c((String)localObject1);
      if (localObject2 != null)
      {
        ((iiv)localObject2).QE = true;
        ((iiv)localObject2).amK = 2;
        ((iiv)localObject2).uinType = 0;
        ((iiv)localObject2).relationType = 3;
        ((iiv)localObject2).peerUin = String.valueOf(paramLong);
        ((iiv)localObject2).MP = null;
        ((iiv)localObject2).PT = true;
        ((iiv)localObject2).Y("onDoubleVideoMeetingInvite.3", 2);
        ((iiv)localObject2).S("onDoubleVideoMeetingInvite", true);
        ((iiv)localObject2).senderUin = String.valueOf(paramLong);
      }
      if (!this.mApp.sM()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "recv double video meeting when phone is not idle:from uin=" + paramLong);
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.video.v2q.CallingDialog");
      ((Intent)localObject2).putExtra("isAudio", true);
      ((Intent)localObject2).putExtra("friendUin", String.valueOf(paramLong));
      ((Intent)localObject2).putExtra("uinType", 0);
      ((Intent)localObject2).putExtra("type", 1);
      ((Intent)localObject2).putExtra("senderUin", paramLong);
      ((Intent)localObject2).putExtra("isSender", false);
      ((Intent)localObject2).setPackage(this.mApp.getApp().getPackageName());
      this.mApp.getApp().sendBroadcast((Intent)localObject2);
      new atan(this.appContext, null).a(l, 0, 2131230750, null, null, false, 1, false, true, 0);
      c(l, 3, paramLong);
      f(l, paramLong, 1);
      this.jdField_b_of_type_Igv.c(l, (String)localObject1);
      return;
      if ((b().tf()) || (b().tg()) || (b().th()))
      {
        if (String.valueOf(paramLong).equals(b().peerUin))
        {
          bool1 = true;
          this.jdField_b_of_type_Igv.c((String)localObject1).Y("onDoubleVideoMeetingInvite.2", 2);
          hP(true);
          O(b().peerUin, 299);
          ko(299);
          P(b().peerUin, 2);
        }
        else if ((b().tf()) || (b().tg()))
        {
          a(l, true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "onDoubleVideoMeetingInvite-->Reject Video Request when chating");
        }
        if (bool2)
        {
          a(l, true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
          return;
        }
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "onDoubleVideoMeetingInvite, mOrientation[" + this.mOrientation + "], isQQPaused[" + VideoConstants.Ow + "], isVideoPaused[" + this.mApp.isBackground_Pause + "], isScreenLocked[" + bool2 + "], isAppOnForeground[" + GesturePWDUtils.isAppOnForegroundByTasks(getAppContext()) + "], seq[" + l + "]");
    }
    if ((this.OI) && (this.mOrientation == 0) && (!bool2) && (VideoConstants.Ow) && (this.mApp.isBackground_Pause))
    {
      this.mApp.getHandler().postDelayed(new VideoController.25(this, l, (String)localObject1, 0, String.valueOf(paramLong), true, bool1), 100L);
      return;
    }
    a(l, (String)localObject1, 0, String.valueOf(paramLong), null, true, true, bool1, 0);
  }
  
  public String gG()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getAVGQuality();
    }
    return null;
  }
  
  public int getApn()
  {
    int j = 1;
    int i;
    if (AppNetConnInfo.isWifiConn()) {
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getApn: " + i + " mobileType:" + j);
      }
      return i;
      if (AppNetConnInfo.isMobileConn())
      {
        j = AppNetConnInfo.getMobileInfo();
        switch (j)
        {
        default: 
          i = 100;
          break;
        case 1: 
          i = 3;
          break;
        case 2: 
          i = 9;
          break;
        case 3: 
          i = 11;
          break;
        case 4: 
          i = 14;
          break;
        }
      }
      else
      {
        j = -1;
        i = 0;
      }
    }
  }
  
  public Context getAppContext()
  {
    if (this.appContext == null) {
      this.appContext = this.mApp.getApp().getApplicationContext();
    }
    return this.appContext;
  }
  
  public long getChatRoomId(String paramString)
  {
    long l1 = 0L;
    iiv localiiv = igv.a().a(paramString);
    if ((localiiv != null) && (localiiv.getRoomId() != 0L)) {
      l1 = localiiv.getRoomId();
    }
    long l2;
    do
    {
      do
      {
        return l1;
      } while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null);
      l2 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getChatRoomId(paramString);
      QLog.i(TAG, 1, "retry to get room id. new room id = " + l2);
      l1 = l2;
    } while (localiiv == null);
    localiiv.bP(l2);
    return l2;
  }
  
  public Bitmap getCircleFaceBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f2 = this.mApp.getApp().getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < paramInt1 * f2) {
        f1 = i / paramInt1;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(f1 * paramInt2);
    return aqhu.b(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public long getOnPeerFrameRenderEndFunctionPtr()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getOnPeerFrameRenderEndFunctionPtr();
    }
    return 0L;
  }
  
  public int getPeerSdkVersion(String paramString)
  {
    int i = -1;
    iiv localiiv = igv.a().a(paramString);
    if ((localiiv != null) && (localiiv.kL() != -1)) {
      i = localiiv.kL();
    }
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return i;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(paramString);
  }
  
  public int getPeerTerminalType(String paramString)
  {
    int i = -1;
    iiv localiiv = igv.a().a(paramString);
    if ((localiiv != null) && (localiiv.kM() != -1)) {
      i = localiiv.kM();
    }
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return i;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString);
  }
  
  public int getVideoAbilityLevel()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getVideoAbilityLevel();
    }
    return -1;
  }
  
  public void h(long paramLong, int paramInt1, int paramInt2)
  {
    long l = AudioHelper.hG();
    QLog.w(TAG, 1, "onGAudioKickOut, Groupid[" + paramLong + "], relationType[" + paramInt1 + "], seq[" + l + "]");
    paramInt2 = jll.cM(paramInt1);
    if ((this.OB) && (paramLong == this.kJ))
    {
      this.OC = true;
      if (paramInt1 != 3) {
        break label274;
      }
      a(b().sessionId, paramInt2, 7, false, String.valueOf(paramLong), null, false);
      paramInt1 = 7;
      if (paramInt2 != 3000) {
        break label302;
      }
      anot.a(null, "CliOper", "", "", "Multi_call", "Calling_kick_off", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (b().Qw) {
        anot.a(null, "CliOper", "", "", "0X800520B", "0X800520B", 0, 0, "", "", "", "");
      }
      iiv localiiv = b();
      if ((localiiv != null) && (localiiv.PY)) {
        this.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
      }
      b(this.alr, this.kJ, paramInt1);
      this.mApp.l(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong) });
      return;
      label274:
      a(b().sessionId, paramInt2, 20, false, String.valueOf(paramLong), null, false);
      paramInt1 = 20;
      break;
      label302:
      if (paramInt2 == 1) {
        if (b().anb == 10) {
          anot.a(null, "CliOper", "", "", "0X8005932", "0X8005932", 0, 0, "", "", "", "");
        } else {
          anot.a(null, "CliOper", "", "", "0X80046D9", "0X80046D9", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void h(long paramLong1, long paramLong2, long paramLong3)
  {
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), iho.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("selfuin", paramLong1);
    localNewIntent.putExtra("groupuin", paramLong2);
    localNewIntent.putExtra("groupcode", paramLong3);
    localNewIntent.putExtra("reqType", 12);
    a(localNewIntent);
  }
  
  public void h(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "saveRandomNickName uin:" + paramString1 + ",nickname:" + paramString2 + ", anonymous = " + paramBoolean);
    }
    if ((TextUtils.isEmpty(paramString2)) || (!sw())) {}
    label134:
    label155:
    label195:
    do
    {
      do
      {
        return;
        if (paramString1.equals(this.mApp.getAccount()))
        {
          if (!paramBoolean) {
            break label134;
          }
          b().jdField_a_of_type_Iiv$a.Ne = paramString2;
        }
        b localb;
        for (;;)
        {
          if (b().jdField_a_of_type_Iiv$a.chatType != 3) {
            break label195;
          }
          localb = a(paramString1);
          if (localb == null) {
            break label155;
          }
          if (!paramBoolean) {
            break;
          }
          localb.MB = paramString2;
          return;
          b().jdField_a_of_type_Iiv$a.Nd = paramString2;
        }
        localb.name = paramString2;
        return;
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "saveRandomNickName uin:" + paramString1 + ", audiofrind null");
      return;
    } while (b().jdField_a_of_type_Iiv$a.chatType != 1);
    b().jdField_a_of_type_Iiv$a.nickName = paramString2;
  }
  
  public void hD(boolean paramBoolean)
  {
    this.OJ = paramBoolean;
  }
  
  public void hE(boolean paramBoolean)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("notifyAnotherSelfIsRing, isCalling[").append(this.mIsCalling).append("->").append(paramBoolean).append("], mVcCtrl[");
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
      {
        bool = true;
        QLog.w(str, 1, bool + "], sessionInfo SessionType[" + b().amI + "], sessionInfo state[" + b().state + "], isPeerOnPhone[" + b().QF + "]");
      }
    }
    else
    {
      if (this.mIsCalling != paramBoolean) {
        break label139;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label139:
      this.mIsCalling = paramBoolean;
      if (!b().QF)
      {
        if (paramBoolean) {
          if ((b().state > 0) && (b().state <= 4))
          {
            if ((!b().QE) && (b().PY)) {
              hQ(b().peerUin);
            }
            if (!b().PV) {
              b(true, b().peerUin);
            }
            c(false, b().peerUin);
          }
        }
        while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
        {
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.notifyAnotherSelfIsRing(b().peerUin, paramBoolean);
          return;
          c("notifyAnotherSelfIsRing", true);
          continue;
          if ((b().state > 0) && (b().state <= 4))
          {
            if ((!b().QE) && (b().PY)) {
              hR(b().peerUin);
            }
            if (!b().PV) {
              b(false, b().peerUin);
            }
            c(true, b().peerUin);
            alV();
          }
          else
          {
            c("notifyAnotherSelfIsRing", false);
            if (b().QB)
            {
              if (this.bb == null) {
                this.bb = new VideoController.20(this);
              }
              this.mApp.getHandler().postDelayed(this.bb, 2000L);
            }
          }
        }
      }
    }
  }
  
  public void hF(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onNotRecvAudioData bNotRecv = " + paramBoolean);
    }
    if (paramBoolean)
    {
      if (!b().PW) {
        this.mApp.l(new Object[] { Integer.valueOf(24), Boolean.valueOf(true) });
      }
      this.Oy = false;
      return;
    }
    this.Oy = true;
    this.mApp.l(new Object[] { Integer.valueOf(24), Boolean.valueOf(false) });
  }
  
  public void hG(boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "onRecvFirstAudioData, recvFirstAudio[" + paramBoolean + "], seq[" + l + "]");
    }
    if (paramBoolean)
    {
      if (!b().QE) {
        break label144;
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
      {
        if (-1 != this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.switchAudio(b().peerUin)) {
          break label136;
        }
        this.OL = false;
      }
    }
    for (;;)
    {
      this.Oy = true;
      this.mApp.l(new Object[] { Integer.valueOf(25), Boolean.valueOf(paramBoolean), Long.valueOf(l) });
      return;
      label136:
      this.OL = true;
      continue;
      label144:
      this.OL = true;
    }
  }
  
  void hH(boolean paramBoolean)
  {
    long l1 = AudioHelper.hG();
    iiv localiiv = b();
    if (QLog.isColorLevel()) {
      QLog.w("double_2_multi", 2, "DoubleVideoMeeting2MultiVideo begin, session[" + localiiv + "], seq[" + l1 + "]");
    }
    long l2 = Long.valueOf(localiiv.peerUin).longValue();
    int i = localiiv.amI;
    long l3 = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
    boolean bool = ss();
    int j = localiiv.uinType;
    if (this.mApp.countObservers() > 0)
    {
      ioa localioa1 = new ioa();
      ioa localioa2 = new ioa();
      localioa1.uin = l2;
      localioa1.videoSrcType = 1;
      localioa2.uin = l2;
      localioa2.videoSrcType = 2;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localioa2);
      localArrayList.add(localioa1);
      this.mApp.l(new Object[] { Integer.valueOf(104), localArrayList });
      if (localiiv.PY) {
        this.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      }
      hO(true);
      b(l1, l2, true, 0);
      b().peerUin = String.valueOf(l2);
      b().e(l1, "notifyChangeDoubleVideoMeeting2MultiVideo", i);
      b().S("notifyChangeDoubleVideoMeeting2MultiVideo", false);
      b().R("notifyChangeDoubleVideoMeeting2MultiVideo", false);
      b().Qy = true;
      M("notifyChangeDoubleVideoMeeting2MultiVideo", bool);
      if (!bool) {
        break label491;
      }
    }
    label491:
    for (i = 1;; i = 0)
    {
      V("notifyChangeDoubleVideoMeeting2MultiVideo", i);
      if (paramBoolean)
      {
        alz();
        b().bs(4, 11);
        b().ac("notifyChangeDoubleVideoMeeting2MultiVideo", jjc.cH(j));
        this.mApp.l(new Object[] { Integer.valueOf(101), Long.valueOf(l1) });
      }
      if (QLog.isColorLevel()) {
        QLog.w("double_2_multi", 2, "notifyChangeDoubleVideoMeeting2MultiVideo end, mGAudioMute[" + this.OO + "], session[" + localiiv + "], seq[" + l1 + "]");
      }
      return;
      if (localiiv.b(l3, 1) == -1) {
        break;
      }
      localiiv.a(l1, "DoubleVideoMeeting2MultiVideo", true, false);
      break;
    }
  }
  
  public void hI(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "destoryRandomChat:" + paramBoolean + " # matchStatus = " + b().jdField_a_of_type_Iiv$a.anA + " # chatType = " + b().jdField_a_of_type_Iiv$a.chatType + " # state = " + b().state + " # sessionId = " + b().sessionId);
    }
    if (sx())
    {
      if (this.mApp.countObservers() > 0) {
        this.mApp.l(new Object[] { Integer.valueOf(202), Long.valueOf(b().ll), Boolean.valueOf(paramBoolean) });
      }
      iiv localiiv = b();
      if (paramBoolean)
      {
        b(this.alr, this.kJ, 79);
        if (localiiv != null)
        {
          localiiv.jdField_a_of_type_Iiv$a.Rw = false;
          localiiv.jdField_a_of_type_Iiv$a.anA = 0;
          e(0, 0, null);
          localiiv.amG();
          localiiv.amH();
        }
      }
    }
    for (;;)
    {
      if (this.OD) {
        this.OD = false;
      }
      if (paramBoolean) {
        RandomController.a(this.mApp).stop();
      }
      return;
      if ((sw()) || (this.OD)) {
        if (b().jdField_a_of_type_Iiv$a.chatType == 3)
        {
          if (this.mApp.countObservers() > 0) {
            this.mApp.l(new Object[] { Integer.valueOf(202), Long.valueOf(b().ll), Boolean.valueOf(paramBoolean) });
          }
        }
        else if ((b().jdField_a_of_type_Iiv$a.chatType == 1) || (b().jdField_a_of_type_Iiv$a.chatType == 2))
        {
          if (this.mApp.countObservers() > 0) {
            this.mApp.l(new Object[] { Integer.valueOf(204) });
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "destoryRandomChat: double");
          }
        }
      }
    }
  }
  
  public void hJ(boolean paramBoolean)
  {
    this.OX = paramBoolean;
  }
  
  public void hK(boolean paramBoolean)
  {
    QLog.w(TAG, 1, "setSelectMemberActivityIsResume, IsResume[" + paramBoolean + "], mSelectMemberActivityIsResume[" + this.alH + "]");
    if (paramBoolean) {
      this.alH += 1;
    }
    do
    {
      return;
      this.alH -= 1;
    } while (this.alH >= 0);
    this.alH = 0;
  }
  
  public void hL(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = alJ;; i = alK)
    {
      if (this.alL != i)
      {
        this.alL = i;
        QLog.w(TAG, 1, "setLoadPTuSo, bloadSuc[" + paramBoolean + "]");
      }
      return;
    }
  }
  
  public void hM(boolean paramBoolean)
  {
    if (this.mApp != null)
    {
      ihl localihl = this.mApp.a();
      if (localihl != null) {
        localihl.hM(paramBoolean);
      }
    }
  }
  
  public void hN(boolean paramBoolean)
  {
    if (this.mApp != null)
    {
      ihl localihl = this.mApp.a();
      if (localihl != null) {
        localihl.hN(paramBoolean);
      }
    }
  }
  
  public void hO(boolean paramBoolean)
  {
    if (this.mApp != null)
    {
      ihl localihl = this.mApp.a();
      if (localihl != null) {
        localihl.hO(paramBoolean);
      }
    }
  }
  
  public void hP(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "cancelNetWorkTimer[" + paramString + "]");
    }
    this.OK = false;
    if (this.mApp != null) {
      this.mApp.getHandler().removeCallbacks(this.aV);
    }
    PopupDialog.axr();
  }
  
  public void hP(boolean paramBoolean)
  {
    if (this.mApp != null)
    {
      ihl localihl = this.mApp.a();
      if (localihl != null) {
        localihl.hP(paramBoolean);
      }
    }
  }
  
  public void hQ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "pauseVideo");
    }
    if ((b().amI > 0) && (b().amI <= 2) && (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)) {
      if (b().isConnected()) {}
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.pauseVideo(paramString);
    }
    QLog.d("VideoController", 2, "pauseVideo end");
  }
  
  public void hQ(boolean paramBoolean)
  {
    if (this.mApp != null)
    {
      ihl localihl = this.mApp.a();
      if (localihl != null) {
        localihl.hQ(paramBoolean);
      }
    }
  }
  
  public void hR(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "resumeVideo SessionType :" + b().amI);
    }
    GraphicRenderMgr.getInstance();
    if (GraphicRenderMgr.soloaded) {}
    try
    {
      GraphicRenderMgr.getInstance().clearCameraFrames();
      if ((b().amI <= 0) || (b().amI > 2) || (!b().isConnected())) {
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      do
      {
        for (;;)
        {
          localUnsatisfiedLinkError.printStackTrace();
        }
      } while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null);
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.resumeVideo(paramString);
    }
  }
  
  public void hR(boolean paramBoolean)
  {
    if (this.mApp != null)
    {
      ihl localihl = this.mApp.a();
      if (localihl != null) {
        localihl.hR(paramBoolean);
      }
    }
  }
  
  public void hS(String paramString)
  {
    b().Y("onAcceptedVideo", 3);
  }
  
  public void hS(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      long l = System.currentTimeMillis() - this.kP;
      QLog.d(TAG, 1, "callBackNetStatus <--receiveEcho Cost = " + l);
      if (l < 3000L) {
        kv(1);
      }
    }
    for (;;)
    {
      this.kP = -1L;
      return;
      kv(2);
      continue;
      kv(4);
    }
  }
  
  public void hT(String paramString)
  {
    iiv localiiv = b();
    long l = AudioHelper.hG();
    QLog.w(TAG, 1, "onPauseVideo, fromUin[" + paramString + "], remoteHasVideo[" + localiiv.PZ + "], isOnlyAudio[" + localiiv.QE + "], seq[" + l + "]");
    if (irc.getGLVersion(BaseApplication.getContext()) == 1) {
      localiiv.o(l, false);
    }
    while ((localiiv.amI != 2) || (!localiiv.PZ)) {
      return;
    }
    localiiv.o(l, false);
    if (!localiiv.PY)
    {
      localiiv.QE = true;
      localiiv.e(l, "onPauseVideo", 1);
      kp(localiiv.amI);
    }
    this.mApp.l(new Object[] { Integer.valueOf(15) });
    jjk.p(this);
  }
  
  public void hU(String paramString)
  {
    iiv localiiv = b();
    long l = AudioHelper.hG();
    QLog.w(TAG, 1, "onResumeVideo, fromUin[" + paramString + "], remoteHasVideo[" + localiiv.PZ + "], isOnlyAudio[" + localiiv.QE + "], seq[" + l + "]");
    if ((localiiv.amK == 1) && (!sq())) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onResumeVideo !canAVShift()");
      }
    }
    do
    {
      do
      {
        return;
      } while (localiiv.PZ);
      localiiv.o(l, true);
      this.mApp.l(new Object[] { Integer.valueOf(16), Long.valueOf(l) });
      jjk.o(this);
    } while (localiiv.amI != 1);
    localiiv.e(l, "onResumeVideo", 2);
    localiiv.QE = false;
  }
  
  public void hV(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onPauseAudio fromUin = " + paramString + ", remoteMute = " + b().PW);
    }
    if (!b().PW)
    {
      b().PW = true;
      this.mApp.l(new Object[] { Integer.valueOf(17) });
    }
  }
  
  public void hW(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onResumeAudio fromUin = " + paramString + ", remoteMute = " + b().PW + "|" + this.Oy);
    }
    if ((this.Oy) && (b().PW))
    {
      b().PW = false;
      this.mApp.l(new Object[] { Integer.valueOf(18) });
    }
  }
  
  public void hX(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onNetworkDisconnect fromUin = " + paramString);
    }
    this.mApp.l(new Object[] { Integer.valueOf(20) });
  }
  
  public void hY(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onAnotherHaveAccept fromUin = " + paramString);
    }
    hQ(true);
    O(paramString, 206);
    ko(206);
    P(paramString, 7);
  }
  
  public void hZ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onAnotherHaveReject fromUin = " + paramString);
    }
    O(paramString, 207);
    ko(207);
    P(paramString, 7);
  }
  
  public void i(long paramLong, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    case 105: 
    case 106: 
    default: 
      return;
    case 101: 
      b().QJ = true;
      e(paramInt1, paramLong, paramInt2);
      return;
    case 104: 
    case 107: 
    case 108: 
      b().ang = paramInt2;
      e(paramInt1, paramLong, paramInt2);
      return;
    }
    d(paramInt1, paramLong, paramInt2);
  }
  
  public void i(long paramLong1, long paramLong2, long paramLong3)
  {
    iiv localiiv = b();
    if ((localiiv.amI != 2) || ((localiiv.amX != 2) && (localiiv.amX != 3))) {
      return;
    }
    this.mApp.l(new Object[] { Integer.valueOf(10001), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
  }
  
  public void ia(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onConfigSysDealDone fromUin = " + paramString);
    }
  }
  
  public void ib(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onRequestVideoMode fromUin = " + paramString);
    }
    b().anf = 2;
    this.mApp.l(new Object[] { Integer.valueOf(205), paramString });
  }
  
  public void ic(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onAcceptVideoMode fromUin = " + paramString);
    }
    this.mApp.l(new Object[] { Integer.valueOf(206), paramString });
  }
  
  public void id(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onRejectVideoMode fromUin = " + paramString);
    }
    this.mApp.l(new Object[] { Integer.valueOf(207), paramString });
  }
  
  public void ie(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onCancelVideoMode fromUin = " + paramString);
    }
    this.mApp.l(new Object[] { Integer.valueOf(208), paramString });
  }
  
  public void jdMethod_if(String paramString)
  {
    this.mApp.l(new Object[] { Integer.valueOf(129), paramString });
  }
  
  public void ig(String paramString)
  {
    this.mApp.l(new Object[] { Integer.valueOf(131), paramString });
  }
  
  public void ih(String paramString)
  {
    this.mApp.l(new Object[] { Integer.valueOf(132), paramString });
  }
  
  public void ii(String paramString)
  {
    long l = AudioHelper.hG();
    iiv localiiv = b();
    QLog.w(TAG, 1, "onNeedShowPeerVideo, fromUin[" + paramString + "], peerUin[" + localiiv.peerUin + "], extraUin[" + localiiv.MP + "], remoteHasVideo[" + localiiv.PZ + "], mXiaoweiDevice[" + this.OU + "], seq[" + l + "]");
    if ((TextUtils.equals(localiiv.peerUin, paramString)) || (TextUtils.equals(localiiv.MP, paramString)) || (this.OU))
    {
      if ((localiiv.amK != 1) || (sq())) {
        break label165;
      }
      igd.aK(TAG, "onNeedShowPeerVideo, !canAVShift()");
    }
    for (;;)
    {
      return;
      label165:
      if (localiiv.amI == 1) {
        kp(2);
      }
      if (!localiiv.PZ)
      {
        localiiv.o(l, true);
        this.mApp.l(new Object[] { Integer.valueOf(16), Long.valueOf(l) });
        this.mApp.l(new Object[] { Integer.valueOf(29) });
        jjk.o(this);
        if (localiiv.amI == 1)
        {
          localiiv.e(l, "onNeedShowPeerVideo", 2);
          localiiv.QE = false;
        }
      }
      while (!TextUtils.equals(localiiv.peerUin, paramString))
      {
        GraphicRenderMgr.getInstance().onUinChanged(localiiv.peerUin, paramString);
        return;
        this.mApp.l(new Object[] { Integer.valueOf(29) });
      }
    }
  }
  
  public void il(String paramString)
  {
    b().QY = true;
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    im(paramString);
  }
  
  public void im(String paramString)
  {
    long l = getChatRoomId(paramString);
    QLog.d(TAG, 1, "send0x211C2CMsg_Audio_start roomId = " + l);
    if (this.mApp != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.AudioEngineReady");
      localIntent.putExtra("peerUin", paramString);
      localIntent.putExtra("roomId", l);
      localIntent.setPackage(this.mApp.getApp().getPackageName());
      this.mApp.getApp().sendBroadcast(localIntent);
      this.mApp.l(new Object[] { Integer.valueOf(36) });
    }
  }
  
  public void in(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onGetQCallNickName nickName : " + paramString);
    }
    this.mApp.l(new Object[] { Integer.valueOf(600), paramString });
  }
  
  public void io(String paramString)
  {
    a("deviceMemory", ikp.getTotalMemory() + "");
    a("manufacturer", Build.MANUFACTURER);
    a("qqVersion", AppSetting.aq(getAppContext()));
  }
  
  public void ip(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker != null) {
      this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker.jf(paramString);
    }
  }
  
  public void iq(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setupDeviceInfos(paramString);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      QQGAudioCtrl.setandroidapppath(paramString);
    }
  }
  
  public boolean isGameMode()
  {
    boolean bool1 = isScreenLocked(getAppContext());
    boolean bool2 = isLandscape();
    boolean bool3 = this.mApp.sL();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isGameMode isQQPaused: " + bool3 + ", isVideoPaused: " + this.mApp.isBackground_Pause + ", isLandscape: " + bool2 + ", isScreenLocked: " + bool1);
    }
    return (!bool1) && (bool2) && (bool3) && (this.mApp.isBackground_Pause);
  }
  
  public void j(long paramLong, int paramInt1, int paramInt2)
  {
    long l = AudioHelper.hG();
    Object localObject = b();
    if (a("onEnterSuc", true, paramInt1, String.valueOf(paramLong))) {
      localObject = b();
    }
    QLog.w(TAG + "|VideoNodeManager", 1, "onEnterSuc, groupId[" + paramLong + "], relationType[" + paramInt1 + "], multiAVType[" + paramInt2 + "], MainSession[" + localObject + "], seq[" + l + "]");
    hP("onEnterSuc");
    ((iiv)localObject).Rc = false;
    if (paramInt1 == 3)
    {
      ((iiv)localObject).Y("onEnterSuc.1", 14);
      ((iiv)localObject).R("onEnterSuc", true);
      ((iiv)localObject).C(l, SystemClock.elapsedRealtime());
    }
    for (;;)
    {
      this.mApp.l(new Object[] { Integer.valueOf(80), Long.valueOf(paramLong), Long.valueOf(l) });
      if (((paramInt1 == 2) || (paramInt1 == 1)) && ((paramInt2 == 10) || (paramInt2 == 1)))
      {
        this.hY.clear();
        a(paramLong, a(paramInt1, paramInt2, paramLong), false);
        QLog.w(TAG, 1, "InviteMemberList onEnterSuc, send request");
      }
      localObject = this.mApp.a();
      if (localObject != null) {
        ((ilu)localObject).a(b());
      }
      return;
      a("onEnterSuc", true, paramInt1, paramLong);
      localObject = igv.a(paramInt1, String.valueOf(paramLong), new int[0]);
      localObject = igv.a().c((String)localObject);
      if (localObject != null)
      {
        ((iiv)localObject).QH = true;
        ((iiv)localObject).QA = false;
        ((iiv)localObject).Ro = true;
      }
      if ((jjc.cG(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        alP();
      }
    }
  }
  
  public void j(long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onSelfAudioVolumeChange dooubleAV.value:=" + paramLong1);
    }
    try
    {
      this.mApp.l(new Object[] { Integer.valueOf(20002), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      return;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  void k(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null) {
      this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
    }
    this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = new StartRingRunnable(paramString);
    if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable.seq = paramLong;
      this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable, 6000L);
    }
  }
  
  public void k(long paramLong, boolean paramBoolean)
  {
    boolean bool2 = false;
    int i = 0;
    Object localObject;
    if (i < this.hY.size())
    {
      localObject = (b)this.hY.get(i);
      if (((b)localObject).uin == paramLong)
      {
        this.hY.remove(i);
        if (!QLog.isColorLevel()) {
          break label218;
        }
        QLog.d(TAG, 2, "InviteMemberList removeCertainInviteNumber remove: member uin:=" + ((b)localObject).uin);
        i = 1;
      }
    }
    for (;;)
    {
      if ((i != 0) && (paramBoolean)) {
        this.mApp.l(new Object[] { Integer.valueOf(708), Long.valueOf(1L), Long.valueOf(1L), this.hY });
      }
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("InviteMemberList removeCertainInviteNumber uin:").append(paramLong).append(";result:");
      boolean bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (paramBoolean) {
          bool1 = true;
        }
      }
      QLog.d((String)localObject, 1, bool1);
      return;
      i += 1;
      break;
      label218:
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public int kA()
  {
    return this.alq;
  }
  
  public int kB()
  {
    return this.alE;
  }
  
  public int kC()
  {
    if ((!this.OB) || (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getNetLevel();
  }
  
  public int kD()
  {
    synchronized (this.hZ)
    {
      int i = this.hZ.size();
      return i;
    }
  }
  
  public int kE()
  {
    if ((b().isConnected()) || (this.OB)) {
      return 0;
    }
    return 255;
  }
  
  public int kF()
  {
    return this.alL;
  }
  
  public void kn(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onApnChanged netType = " + paramInt);
    }
    if (this.mNetType != paramInt)
    {
      this.mNetType = paramInt;
      if (paramInt != 0) {
        break label145;
      }
      this.mApp.getHandler().postDelayed(this.aV, 60000L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        int i = getApn();
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i);
      }
      if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && ((paramInt == 1) || (paramInt == 2))) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setApType(getApn());
      }
      this.mApp.l(new Object[] { Integer.valueOf(21), Integer.valueOf(paramInt) });
      return;
      label145:
      this.mApp.getHandler().removeCallbacks(this.aV);
    }
  }
  
  public void ko(int paramInt)
  {
    QLog.d(TAG, 1, "reportCloseReasonBeacon,reason  = " + paramInt);
    HashMap localHashMap = new HashMap();
    localHashMap.put("closeReason", String.valueOf(paramInt));
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAvideoCloseReasonB", true, 0L, 0L, localHashMap, "", true);
  }
  
  public void kp(int paramInt)
  {
    if (this.mApp != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.AvSwitch");
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("uinType", b().uinType);
      localIntent.putExtra("peerUin", b().peerUin);
      localIntent.putExtra("extraUin", b().MP);
      localIntent.putExtra("relationType", b().relationType);
      localIntent.putExtra("relationId", b().ll);
      localIntent.putExtra("isDoubleVideoMeeting", b().Qw);
      localIntent.setPackage(this.mApp.getApp().getPackageName());
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void kq(int paramInt)
  {
    long l = AudioHelper.hG();
    QLog.w(TAG, 1, "exitProcess, reason[" + paramInt + "], seq[" + l + "]");
    int i = paramInt;
    if (paramInt < 200) {
      i = paramInt + 200;
    }
    if ((sB()) && ((this.alx == 2) || (this.alx == 3)))
    {
      igd.aK(TAG, "exitProcess return,isNearbyVideoChat, uiMode: " + this.alx);
      return;
    }
    if (TraeHelper.a() != null) {
      TraeHelper.a().ee(l);
    }
    if (this.mOrientationListener != null) {
      this.mOrientationListener.disable();
    }
    Object localObject = jko.a(this.mApp);
    try
    {
      ((jko)localObject).axu();
      localObject = new Intent("tencent.video.destroyService");
      ((Intent)localObject).setPackage(this.mApp.getApp().getPackageName());
      this.mApp.getApp().sendBroadcast((Intent)localObject);
      this.mApp.q(l, i);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        igd.aL(TAG, "exception msg = " + localException.getMessage());
      }
    }
  }
  
  public void kr(int paramInt)
  {
    this.mApp.l(new Object[] { Integer.valueOf(39), Integer.valueOf(paramInt) });
  }
  
  public void ks(int paramInt)
  {
    int i = 15000;
    if (paramInt >= 20) {
      i = Math.min(30000, paramInt * 1000);
    }
    paramInt = b().amJ;
    if ((paramInt == i) || (Build.MODEL.equalsIgnoreCase("HWI-AL00")) || (Build.MODEL.equalsIgnoreCase("VKY-AL00"))) {
      return;
    }
    long l = AudioHelper.hG();
    QLog.w(TAG, 1, "onFpsChange, nFps[" + paramInt + "->" + i + "], seq[" + l + "]");
    b().amJ = i;
    CameraUtils.a(this.appContext).w(l, i);
  }
  
  public void kt(int paramInt)
  {
    if (b().amI != 2) {
      return;
    }
    try
    {
      this.mApp.l(new Object[] { Integer.valueOf(10003), Integer.valueOf(paramInt) });
      return;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public void ku(int paramInt)
  {
    long l = AudioHelper.hG();
    QLog.w(TAG, 1, "onDetectAudioDataIssue, issueType[" + this.als + "->" + paramInt + "], seq[" + l + "]");
    this.als = paramInt;
    this.mApp.l(new Object[] { Integer.valueOf(38), Integer.valueOf(paramInt), Long.valueOf(l) });
  }
  
  public void kv(int paramInt)
  {
    if (b().peerUin == null) {
      QLog.d(TAG, 1, "checkNetStatus <--receiveEcho peerUin = null, return!");
    }
    for (;;)
    {
      return;
      try
      {
        l = Long.valueOf(b().peerUin).longValue();
        if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) || (l <= 0L)) {
          continue;
        }
        QLog.d(TAG, 1, "checkNetStatus <--receiveEcho netStatus = " + paramInt);
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateNetworkTestResult(l, paramInt);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d(TAG, 1, "checkNetStatus Long.valueOf(peerUin) Exception= " + localException.getMessage());
          long l = 0L;
        }
      }
    }
  }
  
  public void kw(int paramInt)
  {
    QLog.d(TAG, 1, "closeVideo timeout. force to exitProcess. closeReason = " + paramInt);
    kq(261);
  }
  
  public int kx()
  {
    return this.alz;
  }
  
  public int ky()
  {
    ArrayList localArrayList = this.hZ;
    int k = 0;
    int i = 0;
    for (;;)
    {
      try
      {
        if (k < this.hZ.size())
        {
          b localb = (b)this.hZ.get(k);
          if ((localb != null) && (localb.uin != jji.B(this.mApp.getCurrentAccountUin())))
          {
            int j = i;
            if (localb.Ph) {
              j = i + 1;
            }
            i = j;
            if (localb.Pj) {
              i = j + 1;
            }
            if (localb.Pi) {
              i += 1;
            }
          }
        }
        else
        {
          return i;
        }
      }
      finally {}
      k += 1;
    }
  }
  
  public int kz()
  {
    return getApn();
  }
  
  public void l(String paramString, long paramLong)
  {
    try
    {
      QLog.d(TAG, 1, String.format("setMSFInviteMessageTimeStamp uin=%s msfTimestamp=%s", new Object[] { paramString, Long.valueOf(paramLong) }));
      long l = Long.valueOf(paramString).longValue();
      if ((l > 0L) && (paramLong > 0L)) {
        this.cw.put(Long.valueOf(l), Long.valueOf(paramLong));
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d(TAG, 1, "setMSFInviteMessageTimeStamp fail.", paramString);
    }
  }
  
  public void lockVideoMaxQP(int paramInt, String paramString)
  {
    if ((b().amI != 4) && (b().amI != 2)) {}
    while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.lockVideoMaxQP(paramInt, paramString);
  }
  
  public void m(long paramLong, int paramInt)
  {
    QLog.w(TAG, 1, "onGAudioMicSetByAdmin, manager uin[" + paramLong + "], old micAuthByAdmin[" + b().ane + "], new micAuthByAdmin[" + paramInt + "], mIsMicOffBySelf[" + this.OY + "], mGAudioGroupId[" + this.kJ + "]");
    b().ad("onGAudioMicSetByAdmin", paramInt);
    if (paramInt == 2) {
      return;
    }
    int i;
    long l;
    boolean bool1;
    if ((paramLong == this.mApp.getLongAccountUin()) || (paramInt != 0))
    {
      i = kB();
      l = this.kJ;
      if (paramInt != 0) {
        break label214;
      }
      bool1 = true;
      if (this.mApp.getLongAccountUin() != paramLong) {
        break label220;
      }
    }
    label214:
    label220:
    for (boolean bool2 = true;; bool2 = false)
    {
      a("onGAudioMicSetByAdmin", l, bool1, bool2, -1);
      f(-1L, i, kB());
      this.mApp.l(new Object[] { Integer.valueOf(140), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      return;
      bool1 = false;
      break;
    }
  }
  
  public Bitmap n(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "requestStrangerFace: " + paramString + ", uinType = " + b().uinType);
    }
    Bitmap localBitmap = b(paramString, false);
    if (localBitmap != null) {
      return localBitmap;
    }
    this.mApp.e(paramString, b().uinType);
    return null;
  }
  
  public void n(int paramInt, long paramLong)
  {
    if (!this.Oz)
    {
      this.kK = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "netTrafficSize dataTransfered: dirction = " + paramInt + ", size = " + paramLong);
      }
      Intent localIntent = new Intent("tencent.video.v2q.VideoFlowSize");
      localIntent.putExtra("direction", paramInt);
      localIntent.putExtra("size", paramLong);
      localIntent.setPackage(this.mApp.getApp().getPackageName());
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void o(int paramInt, long paramLong)
  {
    String str = igv.a(paramInt, String.valueOf(paramLong), new int[0]);
    if (paramInt == 3) {
      str = igv.a(100, String.valueOf(paramLong), new int[0]);
    }
    if (this.jdField_b_of_type_Igv.ci(str)) {}
    for (Object localObject = this.jdField_b_of_type_Igv.c(str);; localObject = null)
    {
      long l = AudioHelper.hG();
      if (QLog.isColorLevel()) {
        QLog.w(TAG, 1, "onGAudioRoomDestroy, relationType[" + paramInt + "], seq[" + l + "], sessionId[" + str + "], \nsession[" + localObject + "]");
      }
      if (localObject == null) {}
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
            this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.dN(l);
          }
          TraeHelper.t(this.mApp);
          TraeHelper.a().axI();
          if ((AudioHelper.aCz()) || (((iiv)localObject).Rc)) {
            QLog.w(TAG, 1, "onGAudioRoomDestroy, \nmainsession[" + b() + "], \nstate[" + ((iiv)localObject).state + "], seq[" + l + "], isAcceptingMultiAV[" + ((iiv)localObject).Rc + "], isCurJoinedGRoom[" + f(paramInt, paramLong) + "]");
          }
        } while (((iiv)localObject).Rc);
        if (this.kM == paramLong)
        {
          this.kM = 0L;
          this.alF = 0;
        }
        if ((paramInt != 3) || (!((iiv)localObject).Qw) || ((((iiv)localObject).peerUin != null) && (paramLong == Long.valueOf(((iiv)localObject).peerUin).longValue()))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "onGAudioRoomDestroy-->RelationId is wrong-->PeerUin = " + ((iiv)localObject).peerUin + " ,relationId = " + paramLong);
      return;
      if ((!((iiv)localObject).QT) && (!((iiv)localObject).Qw))
      {
        int i = 6;
        if (((iiv)localObject).state == 7) {
          i = 5;
        }
        a("onGAudioRoomDestroy", str, jll.cM(paramInt), this.mApp.getCurrentAccountUin(), String.valueOf(paramLong), i, ((iiv)localObject).senderUin, false, false);
      }
      if (f(paramInt, paramLong)) {
        b(paramInt, paramLong, 69);
      }
      ((iiv)localObject).Y("onGAudioRoomDestroy", 0);
      this.mApp.l(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(2) });
      this.mApp.l(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(2) });
      if (this.jdField_b_of_type_Igv.ci(str))
      {
        if (paramInt == 3)
        {
          localObject = this.jdField_b_of_type_Igv.c(str);
          paramInt = jll.cM(paramInt);
          a(((iiv)localObject).sessionId, paramInt, 10, true, String.valueOf(paramLong), null, true);
        }
        if (this.jdField_b_of_type_Igv.c(l, str))
        {
          localObject = jko.a(this.mApp);
          if ((localObject != null) && (((jko)localObject).isActive()))
          {
            ((jko)localObject).cancelNotification(str);
            alx();
          }
        }
      }
      this.hY.clear();
      alK();
      return;
    }
  }
  
  public int registerDAudioDataCallback(int paramInt, boolean paramBoolean)
  {
    if ((b().amI == 1) || (b().amI == 2)) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.registerDAudioDataCallback(paramInt, paramBoolean);
    }
    return -1;
  }
  
  public boolean sA()
  {
    if (AudioHelper.aCz()) {
      QLog.w(TAG, 1, "getSelectMemberActivityIsResume, mSelectMemberActivityIsResume[" + this.alH + "]");
    }
    return this.alH > 0;
  }
  
  public boolean sB()
  {
    if ((b() == null) || (this.mApp == null)) {}
    while ((b().uinType != 10003) && (!this.mApp.Rz)) {
      return false;
    }
    return true;
  }
  
  public boolean sC()
  {
    if (!iow.uW()) {}
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_Iow != null)
      {
        if ((ipd.uJ()) || (ipd.vc())) {
          return true;
        }
        iiv localiiv = b();
        if ((localiiv.amI == 2) || (localiiv.amI == 4)) {}
        for (int i = 1; (i != 0) && ((!localiiv.b.isEmpty()) || (this.mApp.tq()) || (localiiv.Ri)); i = 0) {
          return true;
        }
      }
    }
  }
  
  public int sendSelectVideoModeRequest(long paramLong, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendSelectVideoModeRequest(paramLong, paramInt);
  }
  
  public void sendTransferMsg(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendTransferMsg(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void setAudioOpt(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setAudioOpt(paramBoolean);
    }
  }
  
  public int setGatewayTestResult(int paramInt1, int paramInt2, int paramInt3)
  {
    igd.aJ(TAG, "setGatewayTestResult networkType:" + paramInt1 + " | signalStrength:" + paramInt2 + " | pingResult:" + paramInt3);
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setNativeGatewayTestResult(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean setMicByAdmin(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setMicByAdmin(paramLong, paramBoolean);
  }
  
  public void setSoundEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "setSoundEnable: " + paramBoolean);
      }
    } while (!this.OB);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioRecv();
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
  }
  
  public int setVoiceType(int paramInt)
  {
    igd.aK(TAG, "setVoiceType| sessionType=" + b().amI + "type=" + paramInt);
    int j = -1;
    int i;
    if ((b().amI == 1) || (b().amI == 2))
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        i = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setVoiceType(paramInt);
      }
    }
    do
    {
      do
      {
        return i;
        if (b().amI == 3) {
          break;
        }
        i = j;
      } while (b().amI != 4);
      i = j;
    } while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null);
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setVoiceType(paramInt);
  }
  
  public boolean sn()
  {
    QLog.d(TAG, 1, String.format("initVcController mVcCtrl=%s", new Object[] { this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl }));
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
        {
          Object localObject2 = new DisplayMetrics();
          ((WindowManager)this.mApp.getApp().getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
          localObject1 = String.valueOf(AppSetting.getAppId());
          int j = ((DisplayMetrics)localObject2).widthPixels;
          int k = ((DisplayMetrics)localObject2).heightPixels;
          int i = getApn();
          String str3 = this.mApp.getCurrentAccountUin();
          if (TextUtils.isEmpty(str3)) {
            continue;
          }
          localObject2 = new VcControllerImpl(getAppContext(), (String)localObject1, this, this, j, k, i, str3);
          ClientLogReport.instance().setVideoAppInterface(this.mApp);
          long l = jji.B(str3);
          String str1 = this.mApp.getApp().getPackageName();
          String str2 = auri.getIMEI("62ad83");
          j = aqux.fq(str3);
          str3 = aqgz.getIMSI();
          String str4 = str3 + "," + j;
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("init, [%s], [%s], [%s], [%s]", new Object[] { str2, str3, Integer.valueOf(j), str4 }));
          }
          ((VcControllerImpl)localObject2).init(getAppContext(), l, "3.4.4", Build.MODEL, (String)localObject1, str1, AppSetting.getLC(), str2, imm.getDeviceName(), Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.MANUFACTURER, imm.getCPUName(), i, str4, new SDKConfigInfo.a().a(), jkn.aF(l), jkn.aG(l));
          ((VcControllerImpl)localObject2).updateProcessInfo(0L, "manufacturer", Build.MANUFACTURER);
          localObject1 = ((VcControllerImpl)localObject2).postData(5L, null);
          if (localObject1 != null) {
            continue;
          }
          localObject1 = "";
          QLog.w(TAG, 1, "initVcController, SDK BuildNum[" + (String)localObject1 + "]");
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = ((VcControllerImpl)localObject2);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        QLog.e(TAG, 1, "initVcController fail.", localThrowable);
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
        AVSoUtils.dRG();
        continue;
        QLog.e(TAG, 1, "initVcController selfUin invalid.");
        AVSoUtils.dRG();
        continue;
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
        break label452;
      }
      return true;
      localObject1 = new String((byte[])localObject1);
    }
    label452:
    return false;
  }
  
  public boolean so()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Igv.a().PT)
    {
      if ((this.jdField_b_of_type_Igv.a().amI != 1) && (this.jdField_b_of_type_Igv.a().amI != 2)) {
        break label76;
      }
      bool1 = true;
    }
    for (;;)
    {
      QLog.d(TAG, 1, "CheckIsDoubleReceiveInviting ret=" + bool1);
      return bool1;
      label76:
      bool1 = bool2;
      if (this.jdField_b_of_type_Igv.a().amI == 0) {
        if (this.jdField_b_of_type_Igv.a().amK != 1)
        {
          bool1 = bool2;
          if (this.jdField_b_of_type_Igv.a().amK != 2) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
  
  public boolean sp()
  {
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null;
  }
  
  public boolean sq()
  {
    boolean bool2 = true;
    int i = b().uinType;
    boolean bool1;
    if ((i == 21) || (i == 22) || (i == 26)) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (b().amK != 1);
    String str2 = b().peerUin;
    String str1 = str2;
    if (b().uinType == 1006)
    {
      str1 = str2;
      if (!b().PT)
      {
        str1 = str2;
        if (b().MP != null) {
          str1 = b().MP;
        }
      }
    }
    for (;;)
    {
      try
      {
        long l = jji.B(str1);
        i = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.hasAVShiftAbility(l);
        if (i == -1) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception localException)
      {
        int j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "Can not get Number. PeerUin = " + str1);
        bool1 = false;
        continue;
      }
      if (bool1) {
        return bool1;
      }
      i = getPeerTerminalType(str1);
      j = getPeerSdkVersion(str1);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "canAVShift peerTerminalType: " + i + ", peerSharpVersion: " + j);
      }
      if (j >= 16)
      {
        bool1 = bool2;
        if (i == 4) {
          break;
        }
        bool1 = bool2;
        if (i == 2) {
          break;
        }
        bool1 = bool2;
        if (i == 3) {
          break;
        }
      }
      if (i == 5)
      {
        bool1 = bool2;
        if (j >= 5437) {
          break;
        }
      }
      return false;
      bool1 = false;
    }
    return bool1;
  }
  
  public boolean sr()
  {
    return this.Oy;
  }
  
  public boolean ss()
  {
    return this.OO;
  }
  
  public boolean st()
  {
    for (;;)
    {
      int i;
      boolean bool1;
      boolean bool2;
      synchronized (this.hZ)
      {
        int j = this.hZ.size();
        long l2 = System.currentTimeMillis();
        i = 0;
        bool1 = false;
        if (i < j)
        {
          b localb = (b)this.hZ.get(i);
          if (localb != null)
          {
            bool2 = bool1;
            if (!localb.Pm) {
              break label231;
            }
            if ((localb.kX >= 2000L) && (localb.kX < this.kL))
            {
              l1 = localb.kX;
              bool2 = bool1;
              if (l2 - localb.kW <= l1) {
                break label231;
              }
              localb.Pm = false;
              localb.kW = l2;
              bool1 = true;
              bool2 = bool1;
              if (!QLog.isColorLevel()) {
                break label231;
              }
              QLog.d(TAG, 2, "refreshUserNoiseState : has valid state uin = " + localb.uin + ",isSuspectNoisy = " + localb.Pm);
              bool2 = bool1;
              break label231;
            }
            if (this.kL < 2000L) {
              break label238;
            }
            l1 = this.kL;
            continue;
          }
        }
        else
        {
          return bool1;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label231:
        bool1 = bool2;
      }
      label238:
      long l1 = 2000L;
    }
  }
  
  public boolean su()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return false;
    }
    int j;
    int i;
    synchronized (this.hZ)
    {
      j = this.hZ.size();
      long l = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
      i = 0;
      if (i >= j) {
        break label166;
      }
      b localb = (b)this.hZ.get(i);
      if ((localb == null) || (!localb.Pm)) {
        break label159;
      }
      if (l == localb.uin)
      {
        int k = kB();
        a("setSuspectNoisyUserMicOff", this.kJ, false, true, -1);
        f(-1L, k, kB());
      }
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setMicByAdmin(localObject.uin, true);
    for (;;)
    {
      label147:
      return bool;
      label159:
      label166:
      do
      {
        bool = false;
        break label147;
        i += 1;
        break;
      } while (i == j);
      boolean bool = true;
    }
  }
  
  public boolean sv()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (b().relationType == 2)
      {
        anot.a(null, "CliOper", "", "", "0X80041B0", "0X80041B0", 0, 0, "", "", "", "");
        i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startVideoSend();
        if (QLog.isColorLevel()) {
          QLog.w(TAG, 1, "goOnstage, ret[" + i + "]");
        }
        if (i != 0) {
          break label151;
        }
      }
    }
    label151:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        int i;
        return false;
        if ((b().relationType == 1) && (b().anb == 10)) {
          anot.a(null, "CliOper", "", "", "0X8005936", "0X8005936", 0, 0, "", "", "", "");
        }
      }
      return true;
    }
    QLog.e(TAG, 2, "goOnstage-->mGAudioCtrl is null");
    return false;
  }
  
  public boolean sw()
  {
    return (b().jdField_a_of_type_Iiv$a.anA > 0) && (b().jdField_a_of_type_Iiv$a.anA < 6);
  }
  
  public boolean sx()
  {
    boolean bool2 = false;
    iiv localiiv = b();
    boolean bool1 = bool2;
    if (localiiv != null)
    {
      bool1 = bool2;
      if (localiiv.jdField_a_of_type_Iiv$b.chatType != 0)
      {
        bool1 = bool2;
        if (localiiv.jdField_a_of_type_Iiv$b.groupId > 0L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean sy()
  {
    return this.mApp.sy();
  }
  
  public boolean sz()
  {
    return this.OX;
  }
  
  public long t(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = jji.B(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      igd.aL(TAG, paramString.getMessage());
    }
    return -1L;
  }
  
  public long u(long paramLong)
  {
    long l = 0L;
    if (this.cw.containsKey(Long.valueOf(paramLong))) {
      l = ((Long)this.cw.get(Long.valueOf(paramLong))).longValue();
    }
    QLog.d(TAG, 1, String.format("getMSFInviteMessageTimeStamp uin=%s msfTimestamp=%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) }));
    return l;
  }
  
  void u(byte[] paramArrayOfByte)
  {
    int i;
    if ((this.alu <= 30) && (!this.OE)) {
      i = 0;
    }
    for (;;)
    {
      if ((i > 10) || (paramArrayOfByte[((int)(Math.random() * paramArrayOfByte.length))] != 0))
      {
        if (i < 10) {
          this.OE = true;
        }
        this.alu += 1;
        if ((this.alu == 30) && (!this.OE))
        {
          long l = AudioHelper.hG();
          if (QLog.isColorLevel()) {
            QLog.w(TAG, 1, "checkCamerahasImage, not image, seq[" + l + "]");
          }
          this.mApp.l(new Object[] { Integer.valueOf(38), Integer.valueOf(1), Long.valueOf(l) });
        }
        return;
      }
      i += 1;
    }
  }
  
  public int unregisterDAudioDataCallback(int paramInt, boolean paramBoolean)
  {
    if ((b().amI == 1) || (b().amI == 2)) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.unregisterDAudioDataCallback(paramInt, paramBoolean);
    }
    return -1;
  }
  
  public void uploadSharpNode(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
    {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.uploadSharpNode(paramInt, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("SharpReport_Node", 2, "report_node is" + paramInt);
      }
    }
  }
  
  int v(long paramLong)
  {
    ArrayList localArrayList = this.hZ;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.hZ.size())
        {
          b localb = (b)this.hZ.get(i);
          if ((localb != null) && (localb.uin == paramLong)) {
            return i;
          }
        }
        else
        {
          return -1;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void v(int paramInt1, int paramInt2, int paramInt3)
  {
    this.kL = paramInt3;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAudioNoiseCtrlParam(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void v(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "startCheckAnyChatReqTimeout, ms[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable == null) {
      this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = new AnyChatReqTimeoutRunnable();
    }
    this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable.seq = paramLong1;
    this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable, paramLong2);
  }
  
  public void v(byte[] paramArrayOfByte)
  {
    b(this.mApp.getCurrentAccountUin(), b().peerUin, paramArrayOfByte);
  }
  
  public void w(long paramLong1, long paramLong2)
  {
    if (getChatRoomId(b().peerUin) == paramLong2) {
      b().QZ = true;
    }
    QLog.d(TAG, 1, "onRecvAudioReady uin = " + paramLong1 + ",roomid = " + paramLong2);
    this.mApp.l(new Object[] { Integer.valueOf(37) });
  }
  
  public void w(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, String.format("onRecvMultiVideoCallData buf=%s", new Object[] { paramArrayOfByte }));
    }
    alw();
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      alE();
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onNativeRecvGAudioCMD(this.alA, paramArrayOfByte);
    }
  }
  
  public void x(long paramLong1, long paramLong2)
  {
    iiv localiiv = b();
    int i;
    if ((!TextUtils.isEmpty(localiiv.peerUin)) && ((!localiiv.peerUin.equals(String.valueOf(paramLong2))) || (localiiv.amI == 0)))
    {
      i = sendQueryRoomInfoRequest(paramLong1, paramLong2);
      QLog.w(TAG, 1, "QueryRoomInfo1, result[" + i + "]");
      return;
    }
    if ((this.jdField_b_of_type_Igv.kv() == 0) && (TextUtils.isEmpty(localiiv.sessionId)) && (TextUtils.isEmpty(localiiv.peerUin)))
    {
      i = sendQueryRoomInfoRequest(paramLong1, paramLong2);
      QLog.w(TAG, 1, "QueryRoomInfo2, result[" + i + "]");
      return;
    }
    QLog.w(TAG, 1, "QueryRoomInfo fail, mainSession[" + b() + "]");
  }
  
  public void x(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, String.format("onRecvMultiVideoAck buf=%s", new Object[] { paramArrayOfByte }));
    }
    alw();
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      alE();
    }
    ThreadManager.executeOnSubThread(new VideoController.6(this, paramArrayOfByte));
  }
  
  public void y(byte[] paramArrayOfByte)
  {
    int i = imp.a().m(paramArrayOfByte);
    if (i == 1) {
      this.mApp.l(new Object[] { Integer.valueOf(127) });
    }
    if ((i == 2) && (b().isRecording)) {
      this.mApp.l(new Object[] { Integer.valueOf(164), Integer.valueOf(1) });
    }
  }
  
  public void z(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onRecvIVRPush");
    }
  }
  
  public class AnyChatReqTimeoutRunnable
    implements Runnable
  {
    public long seq = 0L;
    
    AnyChatReqTimeoutRunnable() {}
    
    public void run()
    {
      try
      {
        if (!VideoController.this.b().isConnected())
        {
          if (QLog.isColorLevel()) {
            QLog.e(VideoController.TAG, 2, "AnyChatReqTimeoutRunnable show dialog!");
          }
          Context localContext = VideoController.this.getAppContext();
          PopupDialog.b(localContext, 230, null, localContext.getString(2131721704), 0, 2131721737, new ihj(this), null);
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  static class StartAudioSendRunnable
    implements Runnable
  {
    boolean Po;
    int alY = 5;
    boolean mEnable;
    String mFrom;
    long mSeq;
    
    StartAudioSendRunnable(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.mSeq = paramLong;
      this.mFrom = paramString;
      this.mEnable = paramBoolean1;
      this.Po = paramBoolean2;
    }
    
    public void run()
    {
      this.alY -= 1;
      if (this.alY > 0) {}
      for (int i = 1;; i = 2)
      {
        VideoController.a(VideoController.a(), this.mSeq, "StartAudioSendRunnable", this.mEnable, this.Po, i);
        return;
      }
    }
    
    public String toString()
    {
      return "seq[" + this.mSeq + "], mFrom[" + this.mFrom + "], mEnable[" + this.mEnable + "], mNotifySvr[" + this.Po + "]";
    }
  }
  
  class StartRingRunnable
    implements Runnable
  {
    String mPeerUin;
    long seq = 0L;
    
    StartRingRunnable(String paramString)
    {
      this.mPeerUin = paramString;
    }
    
    public void run()
    {
      if (VideoController.this.b().amR < 0)
      {
        imm.getCpuInfo();
        long l = imm.getMaxCpuFreq();
        int i = imm.getCpuArchitecture();
        int j = Build.VERSION.SDK_INT;
        if ((i < 4) || (l / 1000L < 800L) || (j < 9)) {
          VideoController.this.b().amR = 0;
        }
      }
      if ((VideoController.this.b() != null) && (VideoController.this.b().li == 1L) && (!TextUtils.isEmpty(VideoController.this.b().MW))) {
        VideoController.this.mApp.l(new Object[] { Integer.valueOf(30), this.mPeerUin, VideoController.this.b().MW });
      }
      for (;;)
      {
        VideoController.this.bz(this.seq);
        VideoController.this.a = null;
        return;
        VideoController.this.mApp.l(new Object[] { Integer.valueOf(30), this.mPeerUin });
      }
    }
    
    public String toString()
    {
      return this.seq + "";
    }
  }
  
  public static abstract interface a
  {
    public abstract void amh();
  }
  
  public static class b
  {
    public String MB;
    public boolean Pg;
    public boolean Ph;
    public boolean Pi;
    public boolean Pj;
    public boolean Pk;
    public boolean Pl;
    public boolean Pm;
    public boolean Pn = true;
    public AVPhoneUserInfo a;
    public int accountType;
    public int alU;
    public int alV;
    public int alW;
    public int alX = 0;
    public Bitmap faceBitmap;
    public int gender = -1;
    public String headUrl;
    public long kW;
    public long kX = 2000L;
    public int level = -1;
    public String name;
    public long timeStamp;
    public long uin;
  }
  
  public abstract class c
    implements MediaPlayer.OnCompletionListener
  {
    public long seq;
    
    public c() {}
    
    public String toString()
    {
      return "Custom." + this.seq;
    }
  }
  
  class d
    implements jkf.a
  {
    public d()
    {
      if (QLog.isColorLevel()) {
        QLog.d(VideoController.TAG, 2, "new QQPhoneStatusListener");
      }
    }
    
    protected void finalize()
      throws Throwable
    {
      super.finalize();
      if (QLog.isColorLevel()) {
        QLog.d(VideoController.TAG, 2, "finalize QQPhoneStatusListener");
      }
    }
    
    public void onCallStateChanged(boolean paramBoolean)
    {
      iiv localiiv = VideoController.this.b();
      boolean bool2 = localiiv.QF;
      long l = AudioHelper.hG();
      boolean bool1;
      if (QLog.isColorLevel())
      {
        String str = VideoController.TAG;
        StringBuilder localStringBuilder = new StringBuilder().append("onCallStateChanged, isCalling[").append(localiiv.PQ).append("->").append(paramBoolean).append("], mVcCtrl[");
        if (VideoController.this.a != null)
        {
          bool1 = true;
          QLog.w(str, 1, bool1 + "], sessionInfo state[" + localiiv.state + "], isPeerOnPhone[" + bool2 + "], seq[" + l + "]");
        }
      }
      else
      {
        if (VideoController.this.a != null) {
          break label147;
        }
      }
      for (;;)
      {
        return;
        bool1 = false;
        break;
        label147:
        if (paramBoolean) {
          switch (localiiv.state)
          {
          }
        }
        while (!bool2)
        {
          VideoController.this.G(true, paramBoolean);
          return;
          VideoController.this.O(localiiv.peerUin, 218);
          VideoController.this.ko(218);
          VideoController.this.P(localiiv.peerUin, 0);
          continue;
          VideoController.this.a.rejectVideo(localiiv.peerUin, VideoController.this.getApn(), 65535);
          VideoController.this.O(localiiv.peerUin, 219);
          VideoController.this.ko(219);
          VideoController.this.P(localiiv.peerUin, 1);
          continue;
          VideoController.this.c(l, 3, Long.valueOf(localiiv.peerUin).longValue());
          if (QLog.isColorLevel())
          {
            QLog.e(VideoController.TAG, 2, "Reject Video Request when chating");
            continue;
            VideoController.this.hE(true);
            continue;
            VideoController.this.c(l, VideoController.this.alF, VideoController.this.kM);
            VideoController.this.mApp.l(new Object[] { Integer.valueOf(67), Long.valueOf(VideoController.this.kM), Integer.valueOf(3) });
            continue;
            VideoController.this.b(jll.cL(localiiv.uinType), localiiv.ll, 86);
            VideoController.this.mApp.l(new Object[] { Integer.valueOf(66), Long.valueOf(localiiv.ll) });
            continue;
            switch (localiiv.state)
            {
            case 2: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            default: 
              break;
            case 3: 
            case 4: 
            case 9: 
            case 10: 
              VideoController.this.hE(false);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController
 * JD-Core Version:    0.7.0.1
 */