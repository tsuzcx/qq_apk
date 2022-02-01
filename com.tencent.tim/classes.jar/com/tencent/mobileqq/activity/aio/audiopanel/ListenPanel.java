package com.tencent.mobileqq.activity.aio.audiopanel;

import alic;
import alim;
import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqnt;
import aqnt.a;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import kbp;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import wja;
import wpi;
import wpj;
import wpj.b;
import wpm;
import wpt;
import ycd;

public class ListenPanel
  extends RelativeLayout
  implements alim, Handler.Callback, View.OnClickListener, aqnt.a, wpi, wpj.b
{
  public static int bQf = 1;
  public static int bQg = bQf + 1;
  private TextView Io;
  private TextView Is;
  private alic jdField_a_of_type_Alic;
  private aqnt jdField_a_of_type_Aqnt;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private VolumeChangeView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
  private QQAppInterface app;
  private String audioPath;
  private AudioPanel jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private CircleProgressView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView;
  private VolumeChangeView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
  private QQRecorder.RecorderParam jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  int bPS;
  private int bQe;
  private int bQh = bQf;
  private ViewGroup ba;
  private boolean beY;
  private boolean bfd;
  private double by;
  private QQRecorder.RecorderParam c;
  private TextView cancelTv;
  LottieDrawable d;
  Drawable dF;
  private ViewGroup dc;
  private Runnable ej = new ListenPanel.2(this);
  private LinearLayout gX;
  private Handler uiHandler;
  
  public ListenPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ListenPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void Cw(int paramInt)
  {
    this.bPS = paramInt;
    wpj localwpj = wpj.a();
    if ((this.d != null) && (localwpj.a(this.d))) {
      localwpj.b(this.d);
    }
    this.d = localwpj.a(getContext(), this.bPS);
    if (this.d != null) {
      cat();
    }
  }
  
  private boolean b(float paramFloat, int paramInt)
  {
    return Math.abs(paramFloat - paramInt) < 1.0E-007D;
  }
  
  private void cat()
  {
    if (!(this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.getDrawable() instanceof LottieDrawable)) {
      this.dF = this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.getDrawable();
    }
    if ((this.d.getIntrinsicWidth() > 0) && (b(this.d.getScale(), 1))) {
      this.d.setScale(this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.getWidth() / this.d.getIntrinsicWidth(), this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.getHeight() / this.d.getIntrinsicHeight());
    }
    wpj.a().a(this.d, this.bPS, this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView, true);
  }
  
  private void yM(boolean paramBoolean)
  {
    int j = 8;
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (this.c.mAudioType == 1) {
        break label45;
      }
      i = j;
    }
    label45:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(i);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  private void yN(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.setPlayImageState:" + paramBoolean);
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (XPanelContainer.aLe != (int)(196.0F * getContext().getResources().getDisplayMetrics().density))
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setBackgroundResource(2130850793);
      if (paramBoolean) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130845666));
      }
      for (;;)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.gX.getLayoutParams();
        localLayoutParams.height = wja.dp2px(75.0F, getContext().getResources());
        this.gX.setLayoutParams(localLayoutParams);
        return;
        this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130845668));
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setBackgroundResource(2130850794);
    if (paramBoolean) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130845667));
    }
    for (;;)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.gX.getLayoutParams();
      localLayoutParams.height = wja.dp2px(64.0F, getContext().getResources());
      this.gX.setLayoutParams(localLayoutParams);
      return;
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130845669));
    }
  }
  
  public void Cv(int paramInt)
  {
    paramInt = wpm.fe(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel startPlayAnimByType:,type= " + paramInt + " isEnabled()" + isEnabled() + " getVisibility=" + getVisibility());
    }
    if (!wpj.a().bT()) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "fileNotExsit");
      }
    }
    while ((this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.getCurrentItem() != 1) || (getVisibility() != 0) || (!isEnabled())) {
      return;
    }
    wpj.a().a(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.cak();
    Cw(paramInt);
  }
  
  public void a(Animator paramAnimator, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel onAnimationEnd  type=" + paramInt);
    }
    if (wpm.gs(paramInt)) {}
    while (this.dF == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(this.dF);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, int paramInt)
  {
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.dc = paramViewGroup2;
    this.ba = paramViewGroup1;
    this.bQe = paramInt;
    this.uiHandler = new Handler(Looper.getMainLooper(), this);
    this.Io = ((TextView)findViewById(2131378610));
    this.Io.setText(AudioPanel.a(0.0D));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView = ((CircleProgressView)findViewById(2131370579));
    this.cancelTv = ((TextView)findViewById(2131370578));
    this.gX = ((LinearLayout)findViewById(2131370580));
    this.Is = ((TextView)findViewById(2131370581));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131369147));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131369148));
    yN(true);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setOnClickListener(this);
    this.cancelTv.setOnClickListener(this);
    this.Is.setOnClickListener(this);
    this.jdField_a_of_type_Alic = new alic();
    this.c = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167295));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167295));
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null)) {
      this.Io.setTextColor(Color.parseColor("#FF4A4A4A"));
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setRingColor(getResources().getColor(2131167292));
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.init() is called");
    }
  }
  
  public void a(LottieDrawable paramLottieDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel onDrawableLoaded mCurAnimType:" + this.bPS + ",type= " + paramInt + " drawable=" + paramLottieDrawable);
    }
    if (wpm.gs(paramInt)) {}
    do
    {
      do
      {
        return;
      } while (this.bPS != paramInt);
      this.d = paramLottieDrawable;
    } while (this.d == null);
    ThreadManager.getUIHandler().removeCallbacks(this.ej);
    ThreadManager.getUIHandler().post(this.ej);
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    yN(true);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131692114));
    yM(false);
    cap();
  }
  
  public void c(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      paramInt1 = 0;
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(paramInt1);
      this.Io.setText(AudioPanel.a(paramInt2));
      return;
      if (paramInt2 > paramInt1) {
        paramInt1 = 100;
      } else {
        paramInt1 = paramInt2 * 100 / paramInt1;
      }
    }
  }
  
  void cap()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel. stopAudioPlayer " + this.audioPath);
    }
    Cv(203);
    if (this.jdField_a_of_type_Aqnt != null)
    {
      this.jdField_a_of_type_Aqnt.release();
      this.jdField_a_of_type_Aqnt = null;
    }
  }
  
  public void d(String paramString, int paramInt1, int paramInt2) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    jd(paramMessage.arg1);
    return true;
  }
  
  public void jd(int paramInt)
  {
    paramInt = this.jdField_a_of_type_Alic.iI(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.CB(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.CB(paramInt);
  }
  
  public void onAudioData(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (this.jdField_a_of_type_Alic.VY()))
    {
      int i = (int)AudioHelper.a(this.app.getApplication().getApplicationContext(), paramArrayOfByte, paramArrayOfByte.length, 1.0F);
      this.uiHandler.sendMessage(this.uiHandler.obtainMessage(1, i, 0));
    }
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.audioPath);
    }
    cap();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    String str = this.audioPath;
    int i;
    if (this.bQh == bQg)
    {
      i = 3;
      ((BaseChatPie)localObject).b(str, i, this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(this.audioPath, null);
      if (this.bQe != 1) {
        break label127;
      }
      setVisibility(8);
      localObject = (PressToSpeakPanel)this.ba.findViewById(2131373563);
      ((PressToSpeakPanel)localObject).reset();
      ((PressToSpeakPanel)localObject).setVisibility(0);
    }
    label127:
    while (this.bQe != 2)
    {
      return false;
      i = 2;
      break;
    }
    setVisibility(8);
    localObject = (RecordSoundPanel)this.ba.findViewById(2131376971);
    ((RecordSoundPanel)localObject).reset();
    ((RecordSoundPanel)localObject).setVisibility(0);
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131370579)
    {
      if (AppSetting.enableTalkBack) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zX(2131230758);
      }
      if (!this.beY)
      {
        this.beY = true;
        localObject1 = this.app;
        localObject2 = new StringBuilder();
        if (this.bQh != bQg) {
          break label287;
        }
        i = 1;
        anot.a((QQAppInterface)localObject1, "CliOper", "", "", "0X8004602", "0X8004602", 0, 0, i + "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "ListenPanel listened, jump source = " + this.bQh);
        }
      }
      if (this.jdField_a_of_type_Aqnt == null)
      {
        this.jdField_a_of_type_Aqnt = new aqnt(this.audioPath, new Handler(), this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.mAudioType);
        if ((this.bfd) && (this.jdField_a_of_type_Aqnt.aFj())) {
          this.jdField_a_of_type_Aqnt.a(this);
        }
        this.jdField_a_of_type_Aqnt.cf(getContext());
        this.jdField_a_of_type_Aqnt.aFk();
        this.jdField_a_of_type_Aqnt.a(this);
        this.jdField_a_of_type_Aqnt.start();
        yN(false);
        Cv(202);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131692115));
        yM(true);
      }
    }
    label287:
    label383:
    int j;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2;
      break;
      yN(true);
      cap();
      this.Io.setText(AudioPanel.a(this.by));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131692114));
      yM(false);
      continue;
      if (i == 2131370578)
      {
        cap();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
        localObject2 = this.audioPath;
        if (this.bQh == bQg)
        {
          i = 3;
          ((BaseChatPie)localObject1).b((String)localObject2, i, this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(this.audioPath, null);
          if (this.bQe != 1) {
            break label460;
          }
          setVisibility(8);
          localObject1 = (PressToSpeakPanel)this.ba.findViewById(2131373563);
          ((PressToSpeakPanel)localObject1).reset();
          ((PressToSpeakPanel)localObject1).setVisibility(0);
        }
        for (;;)
        {
          yM(false);
          break;
          i = 2;
          break label383;
          label460:
          if (this.bQe == 2)
          {
            setVisibility(8);
            localObject1 = (RecordSoundPanel)this.ba.findViewById(2131376971);
            ((RecordSoundPanel)localObject1).reset();
            ((RecordSoundPanel)localObject1).setVisibility(0);
            anot.a(this.app, "CliOper", "", "", "Voice_record", "Voice_record _cancel", 0, 0, "", "", "", "");
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ycd)) {
              kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005856", "0X8005856", 0, 0, "", "", "", "", false);
            }
          }
        }
      }
      if (i == 2131370581)
      {
        cap();
        j = (int)this.by;
        if (this.bQe == 2)
        {
          anot.a(this.app, "CliOper", "", "", "Voice_record", "Record_attribute", 0, 0, String.valueOf(j), "", "", "");
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ycd)) {
            kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005855", "0X8005855", 0, 0, "", "", "", "", false);
          }
        }
        if (this.by >= 1000.0D) {
          break label737;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getString(2131700689), 0).show();
      }
    }
    label737:
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aSM;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(this.audioPath, null);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    Object localObject2 = this.audioPath;
    if (this.bQh == bQf) {}
    for (i = 2;; i = 3)
    {
      ((BaseChatPie)localObject1).a((String)localObject2, i, j, this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam, 0, true, 0);
      if (!bool) {
        break label836;
      }
      localObject1 = (PressToSpeakPanel)this.ba.findViewById(2131373563);
      ((PressToSpeakPanel)localObject1).caz();
      ((PressToSpeakPanel)localObject1).reset();
      break;
    }
    label836:
    if (this.bQe == 1)
    {
      setVisibility(8);
      localObject1 = (PressToSpeakPanel)this.ba.findViewById(2131373563);
      ((PressToSpeakPanel)localObject1).reset();
      ((PressToSpeakPanel)localObject1).setVisibility(0);
    }
    for (;;)
    {
      yM(false);
      break;
      if (this.bQe == 2)
      {
        setVisibility(8);
        localObject1 = (RecordSoundPanel)this.ba.findViewById(2131376971);
        ((RecordSoundPanel)localObject1).reset();
        ((RecordSoundPanel)localObject1).setVisibility(0);
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onDestroy() is called,audioPath is:" + this.audioPath);
    }
    cap();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    String str = this.audioPath;
    int i;
    if (this.bQh == bQg)
    {
      i = 3;
      ((BaseChatPie)localObject).b(str, i, this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(this.audioPath, null);
      if (this.bQe != 1) {
        break label126;
      }
      setVisibility(8);
      localObject = (PressToSpeakPanel)this.ba.findViewById(2131373563);
      ((PressToSpeakPanel)localObject).reset();
      ((PressToSpeakPanel)localObject).setVisibility(0);
    }
    label126:
    while (this.bQe != 2)
    {
      return;
      i = 2;
      break;
    }
    setVisibility(8);
    localObject = (RecordSoundPanel)this.ba.findViewById(2131376971);
    ((RecordSoundPanel)localObject).reset();
    ((RecordSoundPanel)localObject).setVisibility(0);
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onPause() is called,audioPath is:" + this.audioPath);
    }
    if (this.jdField_a_of_type_Aqnt != null)
    {
      cap();
      this.Io.setText(AudioPanel.a(this.by));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
      yN(true);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131692114));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAudioPath(String paramString, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.audioPath = paramString;
    this.by = paramDouble;
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    this.Io.setText(AudioPanel.a(paramDouble));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setAnimFlag(true);
    yN(true);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131692114));
    if (AppSetting.enableTalkBack)
    {
      this.Io.setFocusable(true);
      ViewCompat.setAccessibilityDelegate(this.Io, new wpt(this));
      this.cancelTv.setContentDescription(this.cancelTv.getText() + getContext().getString(2131692117));
      this.Is.setContentDescription(this.Is.getText() + getContext().getString(2131692117));
      QQAppInterface.EI(getContext().getString(2131692112));
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.setAudioPath() is called,path is:" + paramString + ",recordTime is:" + paramDouble);
    }
  }
  
  public void setJumpSource(int paramInt)
  {
    this.bQh = paramInt;
  }
  
  public void setNeedAudioData(boolean paramBoolean)
  {
    this.bfd = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel
 * JD-Core Version:    0.7.0.1
 */