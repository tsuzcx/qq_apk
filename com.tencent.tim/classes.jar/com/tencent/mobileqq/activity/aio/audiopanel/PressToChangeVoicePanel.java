package com.tencent.mobileqq.activity.aio.audiopanel;

import alic;
import alit;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aomq;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import wpi;
import wpu;
import wpw;
import xya;

public class PressToChangeVoicePanel
  extends RelativeLayout
  implements View.OnTouchListener, QQRecorder.a, wpi
{
  public static String GW;
  private TextView Io;
  private TextView It;
  protected alic a;
  public BaseChatPie a;
  protected VolumeChangeView a;
  public QQAppInterface app;
  public AudioPanel b;
  public AudioPanelAdapter b;
  protected VolumeChangeView b;
  public ViewGroup ba;
  private boolean bfe;
  public boolean bff;
  public ViewGroup dc;
  protected ViewGroup df;
  protected ViewGroup dg;
  protected ViewGroup di;
  protected ViewGroup dj;
  protected PopupWindow e;
  public double recordTime;
  private ImageView sv;
  private Handler uiHandler = new wpu(this, Looper.getMainLooper());
  protected View ws;
  
  public PressToChangeVoicePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (GW == null) {
        GW = TraeHelper.S(BaseApplicationImpl.sApplication);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "checkVcSo sync:" + GW);
      }
    }
    if (GW == null) {
      ThreadManager.post(new PressToChangeVoicePanel.2(paramBoolean, paramQQAppInterface, paramString), 5, null, false);
    }
  }
  
  private boolean handleTouchEvent(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getRawY();
    int k = (int)paramMotionEvent.getRawX();
    if (i == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.qh()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zV(2);
      }
    }
    for (;;)
    {
      return true;
      if (i == 2)
      {
        paramMotionEvent = new int[2];
        paramView.getLocationOnScreen(paramMotionEvent);
        double d1 = paramView.getWidth();
        double d2 = paramView.getHeight();
        double d3 = paramMotionEvent[0];
        double d4 = paramMotionEvent[1];
        if ((Math.abs(k - (d3 + d1)) > d1) || (Math.abs(j - (d4 + d2)) > d2)) {
          if (this.bfe)
          {
            this.bfe = false;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.qh())
            {
              setClickable(false);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zV(2);
            }
          }
          else
          {
            this.uiHandler.removeMessages(1);
          }
        }
      }
      else if ((i == 1) || (i == 3))
      {
        this.sv.setPressed(false);
        if (this.bfe)
        {
          this.bfe = false;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.qh())
          {
            setClickable(false);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zV(2);
          }
        }
        else
        {
          this.uiHandler.removeMessages(1);
        }
      }
    }
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBeginReceiveData() is called");
    }
    alit.a(this.app).b(paramString, paramRecorderParam, GW);
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.vl();
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChanegVoicePanel.onRecorderPrepare() is called,path is:" + paramString);
    }
    this.uiHandler.sendEmptyMessage(1001);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, false, paramRecorderParam);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderEnd() is called,path is:" + paramString + ", type: " + paramRecorderParam.mAudioType + ", time:" + this.recordTime);
    }
    HashMap localHashMap;
    if (this.recordTime < 800.0D)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.vd(paramString);
      localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(0), paramString);
      localHashMap.put(Integer.valueOf(1), paramRecorderParam);
      this.uiHandler.sendMessage(this.uiHandler.obtainMessage(1003, localHashMap));
      alit.a(this.app).cleanUp();
      anot.a(this.app, "CliOper", "", "", "0X8005A17", "0X8005A17", 1, 0, String.valueOf((int)this.recordTime), "", "", "3.4.4");
      anot.a(this.app, "CliOper", "", "", "changevoice", "0X8006F4E", 0, 0, "1", "", "", "");
    }
    int i;
    do
    {
      return;
      aomq.jK(3, (int)this.recordTime);
      anot.a(this.app, "CliOper", "", "", "changevoice", "0X8006F4E", 0, 0, "0", "", "", "");
      i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getFateOfRecorder();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "fateOfRecorder is:" + i);
      }
      if (i == 2)
      {
        localHashMap = new HashMap();
        localHashMap.put(Integer.valueOf(0), paramString);
        localHashMap.put(Integer.valueOf(1), paramRecorderParam);
        this.uiHandler.sendMessage(this.uiHandler.obtainMessage(1005, localHashMap));
        return;
      }
    } while (i != 1);
    alit.a(this.app).cleanUp();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(paramString, 4, paramRecorderParam);
    this.uiHandler.sendMessage(this.uiHandler.obtainMessage(1004, paramString));
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoicePanel.onRecorderError() is called,path is:" + paramString1 + ",errorCode is:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString1, false, false, paramRecorderParam);
    this.uiHandler.sendEmptyMessage(1006);
    anot.a(this.app, "CliOper", "", "", "0X8005A17", "0X8005A17", 2, 0, "", "", "", "3.4.4");
    alit.a(this.app).cleanUp();
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, (int)paramDouble, paramRecorderParam);
    alit.a(this.app).o(paramArrayOfByte, paramInt1);
    if (this.jdField_a_of_type_Alic.VY()) {
      this.uiHandler.sendMessage(this.uiHandler.obtainMessage(1007, paramInt2, 0, Double.valueOf(paramDouble)));
    }
    this.recordTime = paramDouble;
  }
  
  public void afr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.prepareRecord() is called,time is:" + System.currentTimeMillis());
    }
    wja.bcO = true;
    this.It.setVisibility(8);
    this.di.setVisibility(0);
    this.dj.setVisibility(8);
    this.sv.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.dc.setVisibility(4);
  }
  
  public void as(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zY(paramInt);
    if (paramInt == 1) {}
  }
  
  public void at(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChanegVoicePanel.onRecorderNotReady() is called,path is:" + paramString);
    }
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true, false, paramRecorderParam);
    this.uiHandler.sendEmptyMessage(1006);
    anot.a(this.app, "CliOper", "", "", "0X8005A17", "0X8005A17", 4, 0, "", "", "", "3.4.4");
    alit.a(this.app).cleanUp();
  }
  
  public int bz()
  {
    this.recordTime = 0.0D;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderStart() is called");
    }
    this.uiHandler.sendEmptyMessage(1002);
    aomq.VW(0);
    return 350;
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangePanel.onInitFailed() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true, false, paramRecorderParam);
    this.uiHandler.sendEmptyMessage(1006);
    anot.a(this.app, "CliOper", "", "", "0X8005A17", "0X8005A17", 3, 0, "", "", "", "3.4.4");
  }
  
  public void cau()
  {
    Object localObject;
    if (!this.bff)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.dh != null) {
        break label106;
      }
      localObject = (ListenChangeVoicePanel)LayoutInflater.from(this.app.getApp()).inflate(2131561182, null);
      ((ListenChangeVoicePanel)localObject).a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.ba);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.dh = ((ViewGroup)localObject);
    }
    for (;;)
    {
      localObject = (ListenChangeVoicePanel)this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.dh;
      ((ListenChangeVoicePanel)localObject).caq();
      this.ba.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
      ((ListenChangeVoicePanel)localObject).setVisibility(8);
      this.bff = true;
      return;
      label106:
      localObject = (ViewGroup)this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.dh.getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.dh);
      }
      ((ListenChangeVoicePanel)this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.dh).a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.ba);
    }
  }
  
  void cav()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.9F, 1.0F, 0.9F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setStartOffset(0L);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    localAnimationSet.addAnimation(localScaleAnimation);
    localScaleAnimation = new ScaleAnimation(0.9F, 1.0F, 0.9F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setStartOffset(200L);
    localScaleAnimation.setDuration(150L);
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setAnimationListener(new wpw(this));
    this.sv.startAnimation(localAnimationSet);
  }
  
  @TargetApi(14)
  public void caw()
  {
    if (AppSetting.enableTalkBack) {
      this.sv.postDelayed(new PressToChangeVoicePanel.5(this), 500L);
    }
  }
  
  public void hB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangePanel.onInitSuccess() is called");
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
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoicePanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zV(2);
      bool1 = true;
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.isRecording();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().isFinishing()) && (this.e != null) && (this.e.isShowing())) {
      this.e.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onDestroy() is called,isRecording is:" + bool);
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
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoicePanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.zV(2);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof xya)))
    {
      QQToast.a(BaseApplication.getContext(), 2131692604, 0).show(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getTitleBarHeight());
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoice.onTouch() is called,action is:" + i);
    }
    boolean bool1;
    if (paramView.getId() == 2131373558) {
      if (i == 0)
      {
        this.sv.setPressed(true);
        paramView = new PressToChangeVoicePanel.3(this);
        paramView = Message.obtain(this.uiHandler, paramView);
        paramView.what = 1;
        this.uiHandler.sendMessageDelayed(paramView, 150L);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        handleTouchEvent(paramView, paramMotionEvent);
        bool1 = bool2;
        continue;
        bool1 = false;
      }
    }
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset() is called");
    }
    this.bfe = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().isFinishing()) {
      return;
    }
    this.It.setVisibility(0);
    this.di.setVisibility(8);
    this.dj.setVisibility(8);
    this.sv.setVisibility(0);
    this.Io.setText(AudioPanel.a(0.0D));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.dc.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(1);
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
          break label301;
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
          QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
          continue;
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
          localAlphaAnimation.setDuration(0L);
          localAlphaAnimation.setInterpolator(new LinearInterpolator());
          localException.startAnimation(localAlphaAnimation);
        }
      }
      label301:
      caw();
    }
  }
  
  public void startRecord()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, " PressToSpeakPanel.startRecord() is called, time is " + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.reset();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.reset();
    this.It.setVisibility(8);
    this.di.setVisibility(8);
    this.dj.setVisibility(0);
    this.sv.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
    this.dc.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel
 * JD-Core Version:    0.7.0.1
 */