package com.tencent.av.smallscreen;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.WindowManager;
import anot;
import aqiw;
import aqmj;
import com.tencent.av.VideoConstants.EmShareOps;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import iid;
import iiv;
import iiv.a;
import ivq;
import ivr;
import ivs;
import ivv;
import ivz;
import jds;

public class SmallScreenService
  extends BaseSmallScreenService
  implements SmallScreenRelativeLayout.a
{
  public static boolean Vy;
  boolean Vz = false;
  public VideoController a;
  public OnSelectMemberActivityIsResumeChangedRunnable a;
  private iid a;
  public ivz a;
  Runnable bG = null;
  final boolean[] i = new boolean[3];
  final boolean[] j = new boolean[3];
  VideoAppInterface mApp;
  BroadcastReceiver mReceiver = new ivr(this);
  WindowManager mWindowManager = null;
  
  public SmallScreenService()
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable = null;
    this.jdField_a_of_type_Ivz = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_Iid = new ivs(this);
  }
  
  private void jK(String paramString)
  {
    if ((this.Vn) || (this.jdField_a_of_type_ComTencentAvVideoController == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SmallScreenService", 2, "initSmallScreenVideoUI, isDestroyed.");
      }
      return;
    }
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentAvVideoController.a().wG())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SmallScreenService", 2, "initSmallScreenVideoUI, shareScreen[" + bool + "], uiCtrl[" + this.jdField_a_of_type_Ivz + "], from[" + paramString + "]");
      }
      if ((bool) || (this.jdField_a_of_type_Ivz != null)) {
        break;
      }
      this.jdField_a_of_type_Ivz = new ivz(this);
      this.jdField_a_of_type_Ivz.b(this.app);
      this.jdField_a_of_type_Ivz.onStart();
      this.jdField_a_of_type_Ivz.onResume();
      return;
    }
  }
  
  void A(long paramLong, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SmallScreenService", 4, "sendStateBroadcast, state[" + paramInt + "], sCanSendStateDelayFlag[" + Vy + "]");
    }
    Vy = false;
    if (this.bG != null) {
      getHandler().removeCallbacks(this.bG);
    }
    if (ivv.a(paramLong, this.mApp, paramInt)) {
      this.aua = paramInt;
    }
  }
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (this.jdField_a_of_type_Ivz != null) {
      this.jdField_a_of_type_Ivz.ark();
    }
  }
  
  protected void a(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int k = ((iiv)localObject).amI;
    int m = ((iiv)localObject).relationType;
    String str;
    if ((k == 1) || (k == 2))
    {
      k = 1;
      if (paramArrayOfBoolean1[1] == 0) {
        break label176;
      }
      if (paramArrayOfBoolean2[1] != 0) {
        break label222;
      }
      str = "0X80057E6";
      if (paramArrayOfBoolean2[0] == 0) {
        break label231;
      }
      if (k == 0) {
        break label150;
      }
      localObject = "0X8005A4A";
    }
    for (;;)
    {
      label64:
      if ((paramArrayOfBoolean1[0] != 0) && (paramArrayOfBoolean2[0] == 0) && (paramArrayOfBoolean2[1] != 0)) {
        if (k != 0) {
          paramArrayOfBoolean1 = "0X8005A4D";
        }
      }
      for (;;)
      {
        if (str != null) {
          anot.a(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
        }
        if (paramArrayOfBoolean1 != null) {
          anot.a(null, "CliOper", "", "", paramArrayOfBoolean1, paramArrayOfBoolean1, 0, 0, "", "", "", "");
        }
        return;
        k = 0;
        break;
        label150:
        if (m == 1)
        {
          localObject = "0X8005A4C";
          break label64;
        }
        if (m != 2) {
          break label231;
        }
        localObject = "0X8005A4B";
        break label64;
        label176:
        if (paramArrayOfBoolean2[1] == 0) {
          break label222;
        }
        str = "0X80057E5";
        localObject = null;
        break label64;
        if (m == 1) {
          paramArrayOfBoolean1 = "0X8005A4F";
        } else if (m == 2) {
          paramArrayOfBoolean1 = "0X8005A4E";
        } else {
          paramArrayOfBoolean1 = (boolean[])localObject;
        }
      }
      label222:
      localObject = null;
      str = null;
      continue;
      label231:
      localObject = null;
    }
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == a(2)) {
      are();
    }
    if (this.jdField_a_of_type_Ivz != null) {
      this.jdField_a_of_type_Ivz.onClick();
    }
    for (;;)
    {
      return true;
      ivz.a(getApplicationContext(), this.jdField_a_of_type_ComTencentAvVideoController);
    }
  }
  
  void af(int paramInt, String paramString)
  {
    super.af(paramInt, paramString);
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenService", 1, "doPhoneStateChange, state[" + paramInt + "], incomingNumber[" + paramString + "], mIsInCall[" + this.Vz + "], seq[" + l + "]");
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      cC(l);
      return;
      this.Vz = false;
      continue;
      this.Vz = true;
      continue;
      this.Vz = true;
    }
  }
  
  void aqR()
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenService", 1, "onOpChanged, mIsOpEnable[" + this.Vo + "], seq[" + l + "]");
    }
    cC(l);
    if (this.Vo)
    {
      str = "0X80057D9";
      anot.a(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.atY > 0) {
        if (!this.Vo) {
          break label139;
        }
      }
    }
    label139:
    for (String str = "0X80057DA";; str = "0X80057DC")
    {
      anot.a(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      return;
      str = "0X80057DB";
      break;
    }
  }
  
  void aqS()
  {
    super.aqS();
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenService", 1, "doInitRunnable, start, seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.sz()) {
        QLog.w("SmallScreenService", 1, "doInitRunnable, AvActivityIsResume, seq[" + l + "]");
      }
    }
    for (;;)
    {
      return;
      iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      if (localiiv != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("SmallScreenService", 1, "InitRunnable, SessionType[" + localiiv.amI + "], matchStatus[" + localiiv.a.anA + "]");
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.OD) {
          localiiv.e(l, "doInitRunnable", 1);
        }
        if ((localiiv.amI == 1) || (localiiv.amI == 3) || (localiiv.a.anA > 0))
        {
          this.mIsInit = false;
          cC(l);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.w("SmallScreenService", 1, "doInitRunnable, end, seq[" + l + "]");
        return;
        if (localiiv.amI == 4)
        {
          if ((!aqiw.isWifiConnected(this.mApp.getApp())) && (!localiiv.Rb))
          {
            this.mIsInit = false;
            cC(l);
          }
        }
        else if ((localiiv.amI == 0) && (localiiv.PT) && ((localiiv.state == 1) || (localiiv.state == 2)))
        {
          int k = localiiv.amK;
          if ((k == 1) || (k == 2))
          {
            QLog.w("SmallScreenService", 1, "doInitRunnable, sessionInfo.BeginSessionType,[" + k + "]");
            this.mIsInit = false;
            cC(l);
            continue;
            if (QLog.isColorLevel())
            {
              QLog.w("SmallScreenService", 1, "doInitRunnable, sessionInfo为空, seq[" + l + "]");
              continue;
              if (QLog.isColorLevel()) {
                QLog.w("SmallScreenService", 1, "doInitRunnable, VideoController为空, seq[" + l + "]");
              }
            }
          }
        }
      }
    }
  }
  
  @TargetApi(21)
  protected void are()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject != null) {
      ((ScreenShareCtrl)localObject).a(VideoConstants.EmShareOps.STOP);
    }
    localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject != null) {
      ((jds)localObject).stop(2);
    }
  }
  
  public void cC(long paramLong)
  {
    Object localObject;
    boolean bool4;
    boolean bool5;
    label50:
    boolean bool1;
    boolean bool2;
    boolean bool6;
    label128:
    label154:
    boolean bool7;
    int k;
    label189:
    boolean bool3;
    label211:
    int m;
    int n;
    if (!this.Vn)
    {
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
      if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentAvVideoController.a().wG()))
      {
        bool4 = true;
        if (this.atY <= 0) {
          break label360;
        }
        bool5 = true;
        bool1 = false;
        if (this.mApp != null)
        {
          bool2 = ivv.isFloatWindowOpAllowed(this.mApp.getApp());
          bool1 = bool2;
          if (((iiv)localObject).Qw)
          {
            bool1 = bool2;
            if (((iiv)localObject).state == 15) {
              bool1 = false;
            }
          }
        }
        this.Vp = isAppOnForeground();
        if ((bool4) || (!bool5) || (!ivv.vM())) {
          break label366;
        }
        bool6 = true;
        if ((bool4) || (bool5) || (!ivv.vN()) || (!this.Vp)) {
          break label372;
        }
        bool2 = true;
        bool7 = this.jdField_a_of_type_ComTencentAvVideoController.sA();
        if ((this.Vz) || (!bool1) || (bool7) || (this.Vm)) {
          break label378;
        }
        k = 1;
        if ((k == 0) || ((!bool4) && (!bool6) && (!bool2))) {
          break label383;
        }
        bool3 = true;
        m = ((iiv)localObject).amI;
        n = ((iiv)localObject).relationType;
        String str = ((iiv)localObject).sessionId;
        if ((str == null) || (!str.startsWith("10-")) || (((iiv)localObject).Qw)) {
          break label389;
        }
        k = 1;
        label258:
        if ((n != 10) && (k == 0)) {
          break label1017;
        }
        bool3 = false;
        bool2 = false;
      }
    }
    label318:
    label360:
    label366:
    label372:
    label1017:
    for (;;)
    {
      if ((!bool4) && (bool3) && (this.jdField_a_of_type_Ivz == null)) {
        jK("showHideToast");
      }
      if ((bool5) && (this.mIsInit)) {
        this.mIsInit = false;
      }
      k = 0;
      if (k < 3)
      {
        if (this.jdField_a_of_type_ArrayOfIvq[k] != null) {
          this.i[k] = this.jdField_a_of_type_ArrayOfIvq[k].isVisible();
        }
        for (;;)
        {
          k += 1;
          break label318;
          bool4 = false;
          break;
          bool5 = false;
          break label50;
          bool6 = false;
          break label128;
          bool2 = false;
          break label154;
          label378:
          k = 0;
          break label189;
          label383:
          bool3 = false;
          break label211;
          k = 0;
          break label258;
          this.i[k] = false;
        }
      }
      localObject = this.j;
      int i1;
      if ((bool2) && (bool3) && (!this.mIsInit))
      {
        i1 = 1;
        localObject[0] = i1;
        localObject = this.j;
        if ((!bool6) || (!bool3)) {
          break label734;
        }
        i1 = 1;
        localObject[1] = i1;
        localObject = this.j;
        if ((!bool4) || (!bool3)) {
          break label740;
        }
        i1 = 1;
        localObject[2] = i1;
        if (QLog.isColorLevel()) {
          QLog.w("SmallScreenService", 2, "showHideToast, hasVideo[" + bool5 + "], mIsInCall[" + this.Vz + "], isOpEnable[" + bool1 + "], isVideoToastCanShow[" + bool6 + "], isAudioToastCanShow[" + bool2 + "], isShareToastCanShow[" + bool4 + "], isToastShow[" + bool3 + "], mIsLock[" + this.Vm + "], mIsInit[" + this.mIsInit + "], mIsAppOnForeground[" + this.Vp + "], SessionType[" + m + "], relationType[" + n + "], isSelectMemberActivityIsResume[" + bool7 + "], mSmallScreenStateBroadcast[" + this.aua + "], seq[" + paramLong + "]");
        }
        k = 0;
        if (k >= 3) {
          break label784;
        }
        localObject = this.jdField_a_of_type_ArrayOfIvq[k];
        if ((localObject != null) && (((ivq)localObject).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null) && (((ivq)localObject).jdField_a_of_type_Ivu != null)) {
          break label746;
        }
      }
      for (;;)
      {
        k += 1;
        break label687;
        i1 = 0;
        break;
        i1 = 0;
        break label455;
        i1 = 0;
        break label480;
        ((ivq)localObject).a(this);
        if ((((ivq)localObject).isVisible()) && (this.j[k] == 0)) {
          this.atZ = ((ivq)localObject).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.lH();
        }
      }
      k = 0;
      if (k < 3)
      {
        localObject = this.jdField_a_of_type_ArrayOfIvq[k];
        if ((localObject == null) || (((ivq)localObject).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout == null) || (((ivq)localObject).jdField_a_of_type_Ivu == null)) {}
        for (;;)
        {
          k += 1;
          break;
          ((ivq)localObject).v(this.j[k], this.atZ);
        }
      }
      if ((bool3) && ((this.j[0] != 0) || (this.j[1] != 0))) {
        if (this.aua != 3) {
          A(paramLong, 3);
        }
      }
      for (;;)
      {
        a(this.j, this.i);
        return;
        if ((!bool7) && (!this.Vm) && (this.Vp) && (this.aua != 2)) {
          if ((bool3) && (this.j[2] != 0))
          {
            A(paramLong, 2);
          }
          else if (this.aua == 1)
          {
            localObject = getHandler();
            if (this.bG == null) {
              this.bG = new SmallScreenService.4(this, paramLong);
            }
            ((Handler)localObject).removeCallbacks(this.bG);
            Vy = true;
            ((Handler)localObject).postDelayed(this.bG, 1000L);
          }
          else
          {
            A(paramLong, 2);
          }
        }
      }
    }
  }
  
  protected boolean isAppOnForeground()
  {
    boolean bool2 = true;
    boolean bool3 = this.mApp.sL();
    boolean bool1;
    if ((!bool3) || (!this.mApp.isBackground_Pause))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "isAppOnForeground result = " + bool1 + ", isQQPaused = " + bool3 + ", isAVPaused = " + this.mApp.isBackground_Pause);
      }
      if (!bool1) {
        break label108;
      }
    }
    for (;;)
    {
      try
      {
        bool3 = GesturePWDUtils.isAppOnForegroundByTasks(this);
        if (!bool3) {
          continue;
        }
        bool1 = bool2;
        bool2 = bool1;
      }
      catch (Exception localException)
      {
        label108:
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SmallScreenService", 2, "isAppOnForeground e = " + localException);
      }
      return bool2;
      bool1 = false;
      break;
      bool1 = false;
    }
    return bool1;
  }
  
  public void lN(int paramInt)
  {
    long l = AudioHelper.hG();
    if (QLog.isDevelopLevel()) {
      QLog.w("SmallScreenService", 1, "onVideoNumChanged, videoViewCount[" + this.atY + "->" + paramInt + "], seq[" + l + "]");
    }
    this.atY = paramInt;
    cC(l);
  }
  
  public void onCreate()
  {
    long l = AudioHelper.hG();
    QLog.w("SmallScreenService", 1, "avideo onCreate start, seq[" + l + "]");
    super.onCreate();
    this.mApp = ((VideoAppInterface)this.app);
    this.mApp.addObserver(this.jdField_a_of_type_Iid);
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
    A(l, 1);
    this.mWindowManager = ((WindowManager)getSystemService("window"));
    SharedPreferences localSharedPreferences = aqmj.j(this.mApp.getApp());
    if (this.jdField_a_of_type_ComTencentAvVideoController.isGameMode()) {}
    for (this.atZ = localSharedPreferences.getInt("small_window_position_land", 12);; this.atZ = ((iiv)localObject).anh)
    {
      ((iiv)localObject).anh = this.atZ;
      int k = 0;
      while (k < 3)
      {
        localObject = a(k);
        if (localObject != null) {
          ((SmallScreenRelativeLayout)localObject).setCurPosition(this.atZ);
        }
        k += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable == null)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable = new OnSelectMemberActivityIsResumeChangedRunnable();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable.seq = l;
    }
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.NEW_OUTGOING_CALL");
    ((IntentFilter)localObject).addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
    registerReceiver(this.mReceiver, (IntentFilter)localObject);
    this.Vz = this.mApp.sM();
    jK("onCreate");
    cC(l);
    QLog.d("SmallScreenService", 1, "onCreate end");
  }
  
  public void onDestroy()
  {
    long l = AudioHelper.hG();
    QLog.w("SmallScreenService", 1, "avideo onDestroy start, seq[" + l + "], sLastActionOnFrom[" + ivv.auD + "]");
    if (this.atY > 0) {}
    for (SmallScreenRelativeLayout localSmallScreenRelativeLayout = a(1);; localSmallScreenRelativeLayout = a(0))
    {
      if (localSmallScreenRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.b().anh = localSmallScreenRelativeLayout.lH();
      }
      savePosition();
      super.onDestroy();
      A(l, 0);
      this.bG = null;
      if (this.jdField_a_of_type_Ivz != null)
      {
        this.jdField_a_of_type_Ivz.onPause();
        this.jdField_a_of_type_Ivz.onStop();
        this.jdField_a_of_type_Ivz.onDestroy(l);
      }
      unregisterReceiver(this.mReceiver);
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable != null) {
        this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable);
      }
      this.mApp.deleteObserver(this.jdField_a_of_type_Iid);
      this.jdField_a_of_type_Iid = null;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable = null;
      this.jdField_a_of_type_Ivz = null;
      this.mReceiver = null;
      this.mApp = null;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "onDestroy end");
      }
      return;
    }
  }
  
  void savePosition()
  {
    ThreadManager.excute(new SmallScreenService.3(this), 16, null, true);
  }
  
  public class OnSelectMemberActivityIsResumeChangedRunnable
    implements Runnable
  {
    public long seq = 0L;
    
    OnSelectMemberActivityIsResumeChangedRunnable() {}
    
    public void run()
    {
      if ((SmallScreenService.this.a != null) && (!SmallScreenService.this.a.sz())) {
        SmallScreenService.this.cC(this.seq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenService
 * JD-Core Version:    0.7.0.1
 */