package com.tencent.mobileqq.ptt;

import acfp;
import alhu.a;
import alhu.b;
import alhu.d;
import alhv;
import alhw;
import alhx;
import alhy;
import alhz;
import alia;
import alid;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aojs;
import aqge;
import aqhq;
import aqjh;
import aqlv;
import auru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateSquareView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.a;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import ujt;
import wpi;
import xkx;

public final class LSRecordPanel
  extends RelativeLayout
  implements Handler.Callback, TouchProxyRelativeLayout.a, QQRecorder.a, wpi
{
  private Point D = new Point();
  private View Gh;
  private View Gi;
  private a jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a;
  private LSRecordTextView jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView;
  public Animation aO;
  public Animation aP;
  public Animation aQ;
  public Animation aR;
  private long agC;
  public alhu.d b;
  private TouchProxyRelativeLayout b;
  private String bWu;
  private boolean beZ;
  public alhu.d c;
  private VolumeIndicateSquareView c;
  private Rect cv = new Rect();
  private Rect cw = new Rect();
  private Rect cx = new Rect();
  private boolean cxd;
  private boolean cxe = true;
  private QQRecorder d;
  private int due;
  private View fN;
  private QQAppInterface mApp;
  private volatile boolean mDone;
  private String mErrMsg;
  private volatile int mMode;
  private SessionInfo mSessionInfo = new SessionInfo();
  private Handler mUIHandler;
  private View tS;
  
  public LSRecordPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public LSRecordPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LSRecordPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void NL(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS stopCheckingChick:" + paramBoolean);
    }
    if (!paramBoolean)
    {
      if (this.cxd)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.fN.getLayoutParams();
        int i = (int)(getResources().getDisplayMetrics().density * 4.0F);
        localLayoutParams.height -= i;
        localLayoutParams.width -= i;
        int j = localLayoutParams.rightMargin;
        localLayoutParams.rightMargin = (i / 2 + j);
        this.cxd = false;
        this.fN.setLayoutParams(localLayoutParams);
      }
      this.mUIHandler.removeMessages(101);
      setMode(0);
      if (this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a.a(false, -1, acfp.m(2131707989), true, false);
      }
      return;
    }
    expand();
  }
  
  private void NM(boolean paramBoolean)
  {
    int i = -43434;
    int j;
    if (paramBoolean)
    {
      j = -15550475;
      if (!paramBoolean) {
        break label117;
      }
      label14:
      if (this.jdField_c_of_type_Alhu$d == null) {
        break label123;
      }
      i = this.jdField_c_of_type_Alhu$d.mColor;
    }
    for (;;)
    {
      alhu.b localb = new alhu.b(this.Gh, i, j, this.jdField_c_of_type_Alhu$d);
      localb.setInterpolator(new AccelerateDecelerateInterpolator());
      localb.setDuration(300L);
      localb.setFillAfter(true);
      localb.setAnimationListener(new alhz(this));
      this.Gh.startAnimation(localb);
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "LS startSideAnimation");
      }
      return;
      j = -43434;
      break;
      label117:
      i = -15550475;
      break label14;
      label123:
      this.jdField_c_of_type_Alhu$d = new alhu.d();
      this.jdField_c_of_type_Alhu$d.mColor = i;
    }
  }
  
  private void NN(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setText("-:--");
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.reset();
    setMode(0);
    if (this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a.a(this.mDone, -1, this.mErrMsg, false, paramBoolean);
    }
    this.mErrMsg = null;
    this.mDone = false;
  }
  
  private void a(QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS sendPtt");
    }
    alid.nZ(this.bWu);
    MessageRecord localMessageRecord = ujt.a(this.mApp, this.bWu, this.mSessionInfo, -2, paramRecorderParam.mAudioType);
    if (localMessageRecord == null) {
      return;
    }
    ((MessageForPtt)localMessageRecord).c2cViaOffline = true;
    long l = localMessageRecord.uniseq;
    Bundle localBundle = new Bundle();
    localBundle.putInt("DiyTextId", localMessageRecord.vipBubbleDiyTextId);
    ujt.a(this.mApp, this.mSessionInfo.cZ, this.mSessionInfo.aTl, this.bWu, l, false, this.due, paramRecorderParam.mAudioType, true, 0, 2, true, localMessageRecord.vipSubBubbleId, localBundle);
    this.bWu = null;
    aqjh.b(this.mApp, this.mSessionInfo.cZ, 8, this.due);
  }
  
  private QQRecorder.RecorderParam b()
  {
    if ((this.mSessionInfo.cZ == 0) || (this.mSessionInfo.cZ == 3000)) {
      return aqlv.a(this.mApp, false);
    }
    return new QQRecorder.RecorderParam(aqlv.dZQ, 8000, 0);
  }
  
  private void close(boolean paramBoolean)
  {
    cm(paramBoolean, false);
  }
  
  private void cm(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS close: " + this.mMode + " done:" + paramBoolean1);
    }
    this.mUIHandler.removeMessages(101);
    if ((this.mMode == 0) || ((!paramBoolean2) && (this.mMode == 5))) {}
    do
    {
      return;
      this.mDone = paramBoolean1;
      if (this.mMode == 1)
      {
        NL(false);
        return;
      }
      if (!paramBoolean2) {
        break;
      }
    } while (!this.cxd);
    setMode(5);
    this.fN.clearAnimation();
    this.fN.setVisibility(0);
    this.Gh.setAnimation(null);
    this.Gh.setVisibility(4);
    ((GradientDrawable)this.fN.getBackground()).setColor(-15550475);
    this.aO = null;
    dGd();
    stopRecord();
    this.jdField_b_of_type_Alhu$d = null;
    this.aP = null;
    Object localObject = (RelativeLayout.LayoutParams)this.fN.getLayoutParams();
    int i = (int)(getResources().getDisplayMetrics().density * 4.0F);
    ((RelativeLayout.LayoutParams)localObject).height -= i;
    ((RelativeLayout.LayoutParams)localObject).width -= i;
    int j = ((RelativeLayout.LayoutParams)localObject).rightMargin;
    ((RelativeLayout.LayoutParams)localObject).rightMargin = (i / 2 + j);
    this.cxd = false;
    this.fN.setLayoutParams((ViewGroup.LayoutParams)localObject);
    dGb();
    return;
    if (this.jdField_b_of_type_Alhu$d != null)
    {
      setMode(5);
      this.fN.setVisibility(0);
      this.Gh.setAnimation(null);
      this.Gh.setVisibility(4);
      localObject = (GradientDrawable)this.fN.getBackground();
      i = this.jdField_b_of_type_Alhu$d.mColor;
      ((GradientDrawable)localObject).setColor(i);
      float f = this.jdField_b_of_type_Alhu$d.yI;
      this.aO = null;
      dGd();
      alhu.a locala = new alhu.a(f, 1.0F, f, 1.0F, 1, 0.5F, 1, 0.5F, this.jdField_b_of_type_Alhu$d);
      locala.a((GradientDrawable)localObject, i, -15550475);
      locala.setInterpolator(new LinearInterpolator());
      locala.setDuration(500L);
      locala.setFillAfter(true);
      locala.setAnimationListener(new alia(this));
      this.aP = locala;
      this.fN.startAnimation(this.aP);
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "LS startCloseAnimation");
      }
      dGb();
      return;
    }
    NN(false);
  }
  
  private void dGe() {}
  
  private void dGf() {}
  
  private void dGg()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startCheckingClick");
    }
    setMode(1);
    this.mUIHandler.sendEmptyMessageDelayed(101, 250L);
    if (this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a.a(false, false, this);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.fN.getLayoutParams();
    int i = (int)(getResources().getDisplayMetrics().density * 4.0F);
    localLayoutParams.height += i;
    localLayoutParams.width += i;
    localLayoutParams.rightMargin -= i / 2;
    this.cxd = true;
    this.fN.setLayoutParams(localLayoutParams);
  }
  
  private void dGh()
  {
    if (this.bWu != null)
    {
      alid.Of(this.bWu);
      this.bWu = null;
      aqjh.Q(this.mApp, 8);
    }
  }
  
  private void expand()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS expand");
    }
    setMode(2);
    Object localObject;
    float f1;
    if (this.jdField_b_of_type_Alhu$d == null)
    {
      getGlobalVisibleRect(this.cx);
      localObject = new Rect();
      this.fN.getGlobalVisibleRect((Rect)localObject);
      f1 = ((Rect)localObject).width() * 0.5F;
      float f2 = ((Rect)localObject).left + f1 - this.cx.left;
      float f3 = ((Rect)localObject).top + f1 - this.cx.top;
      f3 = (float)Math.sqrt(f3 * f3 + f2 * f2);
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "LS init dest bgTrack: " + f2 + ", " + f3);
      }
      f1 = f3 / f1;
      this.jdField_b_of_type_Alhu$d = new alhu.d();
      this.jdField_b_of_type_Alhu$d.yI = 1.0F;
    }
    for (;;)
    {
      this.aP = null;
      localObject = new alhu.a(1.0F, f1, 1.0F, f1, 1, 0.5F, 1, 0.5F, this.jdField_b_of_type_Alhu$d);
      ((alhu.a)localObject).setInterpolator(new LinearInterpolator());
      ((Animation)localObject).setDuration(450L);
      ((Animation)localObject).setFillAfter(true);
      ((Animation)localObject).setAnimationListener(new alhy(this));
      this.aO = ((Animation)localObject);
      this.fN.startAnimation(this.aO);
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "LS startExpandAnimation");
      }
      dGa();
      return;
      f1 = this.jdField_b_of_type_Alhu$d.yI;
    }
  }
  
  private void initUI()
  {
    this.mMode = 0;
    this.tS = super.findViewById(2131381936);
    this.tS.setVisibility(4);
    this.Gh = super.findViewById(2131381935);
    this.Gh.setVisibility(4);
    this.fN = super.findViewById(2131381937);
    if (AppSetting.enableTalkBack)
    {
      super.setContentDescription(null);
      this.tS.setContentDescription(null);
      this.Gh.setContentDescription(null);
      this.fN.setContentDescription(acfp.m(2131707988));
    }
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView = ((LSRecordTextView)super.findViewById(2131378610));
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)super.findViewById(2131369146));
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setNotLayoutInSettingText(true);
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setVisibility(4);
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(4);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if ((int)(localDisplayMetrics.widthPixels / localDisplayMetrics.density) >= 320) {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setCount(30);
    }
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setText("-:--");
    this.Gi = super.findViewById(2131376956);
    this.Gi.setOnClickListener(new alhx(this));
    this.Gi.setContentDescription(acfp.m(2131707985));
  }
  
  private void setMode(int paramInt)
  {
    if (paramInt == this.mMode) {}
    do
    {
      return;
      this.mMode = paramInt;
    } while (!QLog.isDevelopLevel());
    QLog.d("LsRecord", 4, "LS setMode: " + this.mMode);
  }
  
  private void stopRecord()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS stopRecord");
    }
    boolean bool;
    if ((this.d != null) && (!this.d.isStop()) && (!this.mUIHandler.hasMessages(16711686)))
    {
      this.mUIHandler.removeMessages(16711688);
      this.mUIHandler.removeMessages(16711686);
      this.mUIHandler.removeMessages(16711687);
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      bool = this.d.stop();
      zX(2131230757);
      aqge.m(BaseApplicationImpl.sApplication, false);
    }
    for (;;)
    {
      if ((!bool) || (!this.cxe)) {
        NN(true);
      }
      return;
      bool = false;
    }
  }
  
  private void zX(int paramInt)
  {
    aqge.ce(paramInt, false);
  }
  
  public void V(String paramString1, int paramInt, String paramString2)
  {
    this.mSessionInfo.cZ = paramInt;
    this.mSessionInfo.aTl = paramString1;
    this.mSessionInfo.troopUin = paramString2;
  }
  
  public boolean VY()
  {
    if (this.agC == 0L) {
      this.agC = SystemClock.uptimeMillis();
    }
    while (SystemClock.uptimeMillis() - this.agC >= 75L)
    {
      this.agC = SystemClock.uptimeMillis();
      return true;
    }
    return false;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onBeginReceiveData");
    }
    int i = xkx.f(this.mApp, "Normal_MaxPtt") * 1000;
    int j = VipUtils.a(this.mApp, null);
    if ((j & 0x4) != 0) {
      i = xkx.f(this.mApp, "SVIP_MaxPtt") * 1000;
    }
    for (;;)
    {
      i -= 200;
      this.mUIHandler.sendEmptyMessageDelayed(16711687, i);
      return i + 200;
      if ((j & 0x2) != 0) {
        i = xkx.f(this.mApp, "VIP_MaxPtt") * 1000;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, TouchProxyRelativeLayout paramTouchProxyRelativeLayout, a parama)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_b_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout = paramTouchProxyRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a = parama;
    this.mUIHandler = new auru(Looper.getMainLooper(), this);
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS init");
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderPrepare");
    }
    paramRecorderParam = aqlv.c(paramRecorderParam.mAudioType, paramRecorderParam.mSampleRate);
    alid.nY(paramString);
    alid.a(paramString, paramRecorderParam, paramRecorderParam.length);
    this.bWu = paramString;
    this.mUIHandler.post(new LSRecordPanel.7(this));
    if (this.bWu != null) {
      zX(2131230746);
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderEnd");
    }
    this.mUIHandler.removeMessages(1);
    if (this.mDone) {
      if (this.due < 500)
      {
        this.mDone = false;
        this.mErrMsg = acfp.m(2131707986);
        dGh();
      }
    }
    for (;;)
    {
      this.mUIHandler.post(new LSRecordPanel.9(this));
      return;
      a(paramRecorderParam);
      continue;
      dGh();
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderError");
    }
    dGh();
    this.mUIHandler.post(new LSRecordPanel.10(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    alid.a(paramString, paramArrayOfByte, paramInt1);
    if (this.beZ)
    {
      this.beZ = false;
      this.mUIHandler.removeMessages(1);
    }
    if ((VY()) && (this.mMode != 5)) {
      this.mUIHandler.post(new LSRecordPanel.13(this, paramInt2, paramDouble));
    }
    this.due = ((int)paramDouble);
  }
  
  public boolean an(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if (getVisibility() != 0) {
      return false;
    }
    this.jdField_b_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.getGlobalVisibleRect(this.cw, this.D);
    this.Gi.getGlobalVisibleRect(this.cv);
    int i = this.cv.right;
    int j = this.cv.left;
    Rect localRect = this.cv;
    localRect.left -= this.D.x;
    this.cv.right = (i - j + this.cv.left);
    i = this.cv.bottom;
    j = this.cv.top;
    localRect = this.cv;
    localRect.top -= this.D.y;
    this.cv.bottom = (i - j + this.cv.top);
    j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS agent:" + paramMotionEvent + "\n container: " + this.cw + "\n bg: " + this.cv);
    }
    boolean bool1;
    if (this.mMode == 0)
    {
      if ((paramMotionEvent.getAction() != 0) || (!this.cv.contains(j, k))) {
        break label738;
      }
      this.due = 0;
      dGg();
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (this.mMode != 5)
      {
        if (this.mMode == 1)
        {
          if (paramMotionEvent.getAction() != 2) {
            NL(false);
          }
          i = 1;
        }
        for (bool1 = true;; bool1 = false)
        {
          if (i == 0)
          {
            if (paramMotionEvent.getAction() == 3)
            {
              close(false);
              bool1 = bool2;
              break;
            }
            if (paramMotionEvent.getAction() == 1)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("LsRecord", 4, "LS ACTION_UP: " + this.mMode);
              }
              if ((this.mMode == 3) || (this.mMode == 2))
              {
                if (this.due >= 500)
                {
                  close(true);
                  bool1 = bool2;
                  break;
                }
                this.mErrMsg = acfp.m(2131707987);
                close(false);
                bool1 = bool2;
                break;
              }
              bool1 = bool2;
              if (this.mMode != 4) {
                break;
              }
              close(false);
              bool1 = bool2;
              break;
            }
            bool1 = bool2;
            if (paramMotionEvent.getAction() != 2) {
              break;
            }
            super.getGlobalVisibleRect(this.cx);
            i = this.cx.right;
            int m = this.cx.left;
            paramMotionEvent = this.cx;
            paramMotionEvent.left -= this.D.x;
            this.cx.right = (i - m + this.cx.left);
            i = this.cx.bottom;
            m = this.cx.top;
            paramMotionEvent = this.cx;
            paramMotionEvent.top -= this.D.y;
            this.cx.bottom = (i - m + this.cx.top);
            if (this.cx.contains(j, k))
            {
              if (this.mMode == 4) {
                NM(true);
              }
              bool1 = bool2;
              if (this.mMode == 3) {
                break;
              }
              setMode(3);
              bool1 = bool2;
              if (this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a.a(true, false, this);
              bool1 = bool2;
              break;
            }
            if (this.mMode == 3) {
              NM(false);
            }
            bool1 = bool2;
            if (this.mMode == 4) {
              break;
            }
            setMode(4);
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a.a(false, true, this);
            bool1 = bool2;
            break;
          }
          break;
          i = 0;
        }
        label738:
        bool1 = false;
      }
    }
  }
  
  public void as(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderVolumeStateChanged");
    }
  }
  
  public void at(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderNotReady");
    }
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderAbnormal");
    }
    dGh();
    this.mUIHandler.post(new LSRecordPanel.12(this));
  }
  
  public int bz()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderStart");
    }
    this.due = 0;
    this.mUIHandler.post(new LSRecordPanel.8(this));
    this.mUIHandler.removeMessages(1);
    this.mUIHandler.sendEmptyMessageDelayed(1, 2000L);
    this.beZ = true;
    return 350;
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onInitFailed");
    }
    dGh();
    this.mUIHandler.post(new LSRecordPanel.11(this));
  }
  
  public void dGa()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startRecordingMark");
    }
    this.tS.setBackgroundColor(-16777216);
    this.tS.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.6F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(300L);
    this.tS.startAnimation(localAlphaAnimation);
    if (this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a.bTi();
    }
  }
  
  public void dGb()
  {
    this.tS.setBackgroundColor(-16777216);
    this.tS.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.6F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(300L);
    this.tS.startAnimation(localAlphaAnimation);
    if (this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a.bTj();
    }
  }
  
  public void dGc()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startRecordingBarAnimation");
    }
    this.aR = null;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(200L);
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(0);
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.startAnimation(localAlphaAnimation);
    this.aQ = new AlphaAnimation(0.0F, 1.0F);
    this.aQ.setDuration(200L);
    this.aQ.setFillAfter(true);
    this.aQ.setAnimationListener(new alhv(this));
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.startAnimation(this.aQ);
  }
  
  public void dGd()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.getVisibility() != 0) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS stopRecordingBarAnimation");
    }
    this.aQ = null;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(200L);
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.startAnimation(localAlphaAnimation);
    this.aR = new AlphaAnimation(1.0F, 0.0F);
    this.aR.setDuration(200L);
    this.aR.setFillAfter(true);
    this.aR.setAnimationListener(new alhw(this));
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.startAnimation(this.aR);
  }
  
  public void hB()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onInitSuccess");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 16711687: 
      close(true);
      return true;
    case 16711686: 
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
      }
      this.d.stop();
      zX(2131230757);
      aqge.m(BaseApplicationImpl.sApplication, false);
      return true;
    }
    NL(true);
    return true;
  }
  
  public void jd(int paramInt)
  {
    paramInt /= 1180;
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.CB(paramInt);
  }
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onDestroy() {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    initUI();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onLayout: " + paramBoolean);
    }
  }
  
  public void onPause()
  {
    cm(false, true);
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS requestLayout");
    }
  }
  
  public void startRecord()
  {
    if ((this.mMode == 5) || (this.mMode == 0)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startRecord");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$a.a(true, false, this);
    }
    this.fN.setAnimation(null);
    this.fN.setVisibility(4);
    if (this.mMode == 4)
    {
      this.Gh.setBackgroundColor(-43434);
      this.Gh.setVisibility(0);
      setMode(3);
      localObject2 = b();
      if (aqhq.aCJ()) {
        break label147;
      }
      this.mErrMsg = getResources().getString(2131696377);
    }
    for (;;)
    {
      if (this.mErrMsg == null) {
        break label256;
      }
      close(false);
      return;
      this.Gh.setBackgroundColor(-15616011);
      break;
      label147:
      if (!QQRecorder.aES()) {
        this.mErrMsg = getResources().getString(2131719248);
      } else if (!QQRecorder.mw(((QQRecorder.RecorderParam)localObject2).mAudioType)) {
        this.mErrMsg = getResources().getString(2131695039);
      } else if (this.mApp.bF()) {
        this.mErrMsg = getResources().getString(2131697385);
      } else if (AudioHelper.isForbidByRubbishMeizu(1)) {
        this.mErrMsg = getResources().getString(2131700599);
      } else {
        this.mErrMsg = null;
      }
    }
    label256:
    if (this.d == null) {
      this.d = new QQRecorder(BaseApplicationImpl.sApplication);
    }
    this.d.b((QQRecorder.RecorderParam)localObject2);
    Object localObject1 = aojs.a(this.mApp.getCurrentAccountUin(), null, 2, null, false);
    Object localObject2 = MessageForPtt.getLocalFilePath(((QQRecorder.RecorderParam)localObject2).mAudioType, (String)localObject1);
    if ((localObject1 != null) && (!((String)localObject1).equals(localObject2)))
    {
      new File((String)localObject1).deleteOnExit();
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQRecorder", 2, "path: " + (String)localObject1);
      }
      this.d.a(this);
      aqge.m(BaseApplicationImpl.sApplication, true);
      if (QLog.isColorLevel()) {
        QLog.d("LsRecord", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setText("-:--");
      this.jdField_c_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.reset();
      this.d.start((String)localObject1, true);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2, boolean paramBoolean3);
    
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, LSRecordPanel paramLSRecordPanel);
    
    public abstract void bTi();
    
    public abstract void bTj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordPanel
 * JD-Core Version:    0.7.0.1
 */