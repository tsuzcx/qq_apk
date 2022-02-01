package com.tencent.mobileqq.activity.aio.audiopanel;

import acfp;
import alic;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aomq;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kbp;
import wpi;
import wqa;
import ycd;

public class RecordSoundPanel
  extends RelativeLayout
  implements View.OnClickListener, QQRecorder.a, wpi
{
  protected TextView Ip;
  protected TextView Iq;
  protected alic a;
  public BaseChatPie a;
  protected VolumeChangeView a;
  protected QQAppInterface app;
  protected String audioPath;
  protected AudioPanel b;
  protected VolumeChangeView b;
  protected ViewGroup ba;
  protected boolean beZ = true;
  protected boolean bfm = true;
  protected ViewGroup dc;
  protected ViewGroup df;
  protected ViewGroup dg;
  protected ViewGroup di;
  protected ViewGroup dj;
  protected PopupWindow e;
  protected double recordTime;
  protected ImageView su;
  public Handler uiHandler = new wqa(this, Looper.getMainLooper());
  protected View ws;
  
  public RecordSoundPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecordSoundPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBeginReceiveData() is called");
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.vl();
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3, ViewGroup paramViewGroup4)
  {
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.ba = paramViewGroup1;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.dc = paramViewGroup2;
    this.df = paramViewGroup3;
    this.dg = paramViewGroup4;
    this.Ip = ((TextView)findViewById(2131373560));
    this.Ip.setContentDescription(acfp.m(2131713771));
    this.di = ((ViewGroup)findViewById(2131378702));
    this.dj = ((ViewGroup)findViewById(2131369145));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131369147));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131369148));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167295));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167295));
    this.Iq = ((TextView)findViewById(2131376977));
    this.su = ((ImageView)findViewById(2131376970));
    this.su.setOnClickListener(this);
    paramBaseChatPie.a().getResources();
    setClickable(true);
    this.jdField_a_of_type_Alic = new alic();
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      this.Ip.setTextColor(Color.parseColor("#FF737373"));
      this.Iq.setTextColor(Color.parseColor("#FF4A4A4A"));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167295));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167295));
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.init() is called,time is:" + System.currentTimeMillis());
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderPrepare() is called");
    }
    this.uiHandler.post(new RecordSoundPanel.2(this, paramString));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, false, paramRecorderParam);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderEnd() is called,path is:" + paramString);
    }
    this.uiHandler.removeMessages(1);
    if (this.recordTime < 500.0D)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.vd(paramString);
      this.uiHandler.post(new RecordSoundPanel.8(this, paramString, paramRecorderParam));
    }
    int i;
    do
    {
      return;
      aomq.jK(2, (int)this.recordTime);
      i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getFateOfRecorder();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "fateOfRecorder is:" + i);
      }
      if (i == 2)
      {
        this.uiHandler.post(new RecordSoundPanel.9(this, paramString, paramRecorderParam));
        return;
      }
    } while (i != 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(paramString, 3, paramRecorderParam);
    this.uiHandler.post(new RecordSoundPanel.10(this, paramString));
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderError() is called,path is:" + paramString1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString1, false, false, paramRecorderParam);
    this.uiHandler.removeMessages(1);
    this.uiHandler.post(new RecordSoundPanel.7(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, (int)paramDouble, paramRecorderParam);
    if (this.beZ)
    {
      this.beZ = false;
      this.uiHandler.removeMessages(1);
    }
    if (this.jdField_a_of_type_Alic.VY()) {
      this.uiHandler.post(new RecordSoundPanel.5(this, paramInt2, paramDouble));
    }
    this.recordTime = paramDouble;
  }
  
  public void afr()
  {
    this.Ip.setVisibility(8);
    this.di.setVisibility(0);
    this.dj.setVisibility(8);
    this.su.setVisibility(0);
    this.dc.setVisibility(4);
  }
  
  public void as(int paramInt)
  {
    if (paramInt == 1) {
      anot.a(this.app, "CliOper", "", "", "0X800484D", "0X800484D", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zY(paramInt);
  }
  
  public void at(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderNotReady() is called,path is:" + paramString);
    }
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true, false, paramRecorderParam);
    this.uiHandler.removeMessages(1);
    this.uiHandler.post(new RecordSoundPanel.6(this));
  }
  
  public int bz()
  {
    this.recordTime = 0.0D;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderStart() is called");
    }
    this.uiHandler.post(new RecordSoundPanel.3(this));
    this.uiHandler.removeMessages(1);
    this.uiHandler.sendEmptyMessageDelayed(1, 2000L);
    this.beZ = true;
    aomq.VW(2);
    return 350;
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitFailed() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true, false, paramRecorderParam);
    this.uiHandler.post(new RecordSoundPanel.4(this));
  }
  
  public void hB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitSuccess() is called");
    }
  }
  
  public void jd(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "level = " + paramInt);
    }
    paramInt = this.jdField_a_of_type_Alic.iI(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.CB(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.CB(paramInt);
  }
  
  public boolean onBackEvent()
  {
    boolean bool1 = false;
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zV(2);
      bool1 = true;
    }
    return bool1;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onClick() is called");
    }
    wja.bcO = true;
    if (i == 2131376970)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.isRecording();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "isRecording is:" + bool);
      }
      if (!bool) {
        break label108;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.qh())
      {
        setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zV(2);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
    return;
    label108:
    aomq.aqc = SystemClock.uptimeMillis();
    i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getTitleBarHeight();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if (!QQRecorder.aES()) {
      QQToast.a(BaseApplication.getContext(), 2131719248, 0).show(i);
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "Voice_record", "Voice_record_clk", 0, 0, "", "", "", "");
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ycd)) {
        break;
      }
      kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005854", "0X8005854", 0, 0, "", "", Double.toString(this.recordTime), "", false);
      break;
      if (!QQRecorder.mw(((QQRecorder.RecorderParam)localObject).mAudioType))
      {
        QQToast.a(BaseApplication.getContext(), 2131695039, 0).show(i);
      }
      else if (this.app.bF())
      {
        QQToast.a(BaseApplication.getContext(), 2131697385, 0).show();
      }
      else if (AudioHelper.isForbidByRubbishMeizu(1))
      {
        ChatActivityUtils.db(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      }
      else
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.Cs(5);
        this.su.setImageResource(2130845671);
        this.su.setContentDescription(acfp.m(2131713772));
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this, this.bfm, (QQRecorder.RecorderParam)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.setFateOfRecorder(2);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(3);
        localObject = new Rect();
        getWindowVisibleDisplayFrame((Rect)localObject);
        Rect localRect = new Rect();
        this.df.getGlobalVisibleRect(localRect);
        localRect = new Rect();
        this.dg.getGlobalVisibleRect(localRect);
        int j = localRect.bottom;
        if (((!Build.MODEL.startsWith("Coolpad")) || (Build.VERSION.SDK_INT != 19)) && ((!Build.MODEL.startsWith("Coolpad A8")) || (Build.VERSION.SDK_INT != 22)) && ((!Build.MODEL.startsWith("Coolpad B770")) || (Build.VERSION.SDK_INT != 22)))
        {
          i = j;
          if (Build.MODEL.startsWith("ivvi"))
          {
            i = j;
            if (Build.VERSION.SDK_INT != 22) {}
          }
        }
        else
        {
          i = j - ((Rect)localObject).top;
        }
        if (localRect.top <= getResources().getDisplayMetrics().heightPixels) {
          this.e = AudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), ((Rect)localObject).width(), i, this, 0, 0, 0);
        }
        this.ws = AudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.df, this.dg);
      }
    }
  }
  
  public void onDestroy()
  {
    reset();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zV(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.setFateOfRecorder(1);
    }
  }
  
  public void onPause()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zV(2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.isRecording();
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset() is called");
    }
    setClickable(true);
    this.Ip.setVisibility(0);
    this.di.setVisibility(8);
    this.dj.setVisibility(8);
    this.su.setVisibility(0);
    this.su.setImageResource(2130845670);
    this.su.setContentDescription(acfp.m(2131713773));
    this.Iq.setText(AudioPanel.a(0.0D));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(1);
    this.dc.setVisibility(0);
    if ((this.e == null) || (this.e.isShowing())) {}
    try
    {
      this.e.dismiss();
      this.e = null;
      if (this.ws != null)
      {
        if (this.ws.getParent() != null) {
          ((ViewGroup)this.ws.getParent()).removeView(this.ws);
        }
        this.ws = null;
      }
      Object localObject = (PanelIconLinearLayout)this.dg;
      if (localObject != null)
      {
        ((PanelIconLinearLayout)localObject).setAllAlpha(1.0F);
        ((PanelIconLinearLayout)localObject).setAllEnable(true);
      }
      int j = this.df.getChildCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          return;
        }
        localObject = this.df.getChildAt(i);
        if (((View)localObject).getVisibility() != 8) {
          break;
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
          continue;
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
          localAlphaAnimation.setDuration(0L);
          localAlphaAnimation.setInterpolator(new LinearInterpolator());
          localException.startAnimation(localAlphaAnimation);
        }
      }
    }
  }
  
  public void startRecord()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.reset();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.reset();
    }
    this.Ip.setVisibility(8);
    this.di.setVisibility(8);
    this.dj.setVisibility(0);
    this.su.setVisibility(0);
    this.dc.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel
 * JD-Core Version:    0.7.0.1
 */