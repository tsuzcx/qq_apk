package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
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
import btz;
import bua;
import bub;
import buc;
import bud;
import bue;
import buf;
import bug;
import buh;
import bui;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class RecordSoundPanel
  extends RelativeLayout
  implements View.OnClickListener, AudioPanelCallback, QQRecorder.OnQQRecorderListener
{
  private static final int jdField_a_of_type_Int = 1;
  private static final int jdField_b_of_type_Int = 2000;
  private double jdField_a_of_type_Double;
  private Handler jdField_a_of_type_AndroidOsHandler = new btz(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private VolumeIndicateView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VolumeIndicateView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView;
  private ViewGroup c;
  private ViewGroup d;
  private ViewGroup e;
  
  public RecordSoundPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecordSoundPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderStart() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new buc(this));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new buf(this, paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.e = paramViewGroup1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup3;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298134));
    this.c = ((ViewGroup)findViewById(2131298129));
    this.d = ((ViewGroup)findViewById(2131298115));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView = ((VolumeIndicateView)findViewById(2131298116));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView = ((VolumeIndicateView)findViewById(2131298118));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298135));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298136));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramBaseChatPie = paramBaseChatPie.a().getResources();
    paramQQAppInterface = SkinUtils.a(paramBaseChatPie.getDrawable(2130839173));
    paramBaseChatPie = SkinUtils.a(paramBaseChatPie.getDrawable(2130839174));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setIndicateVolumeBitmap(paramQQAppInterface, 3);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setIndicateVolumeBitmap(paramBaseChatPie, 4);
    setClickable(true);
    if (QLog.isColorLevel())
    {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.init() is called,time is:" + System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, "volumeFillLeftBmp is:" + paramQQAppInterface + ",volumeFillRightBmp is:" + paramBaseChatPie);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderPrepare() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new bub(this, paramString));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderError() is called,path is:" + paramString1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.post(new bug(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt, double paramDouble)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(paramString);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new bue(this, paramInt, paramDouble));
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(2);
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBeginReceiveData() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.K();
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 1) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484D", "0X800484D", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i(paramInt);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderEnd() is called,path is:" + paramString);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (this.jdField_a_of_type_Double < 1000.0D)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d(paramString);
      this.jdField_a_of_type_AndroidOsHandler.post(new buh(this));
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "fateOfRecorder is:" + i);
      }
      if (i == 2)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new bui(this, paramString));
        return;
      }
    } while (i != 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, 3);
    this.jdField_a_of_type_AndroidOsHandler.post(new bua(this, paramString));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitSuccess() is called");
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(paramInt);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderNotReady() is called,path is:" + paramString);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitFailed() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new bud(this));
  }
  
  public void e()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(2);
    }
  }
  
  public void f()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(1);
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset() is called");
    }
    setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838610);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("开始录音");
    this.jdField_b_of_type_AndroidWidgetTextView.setText(AudioPanel.a(0.0D));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(1);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
          ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_AndroidViewView = null;
      }
      int j = this.jdField_b_of_type_AndroidViewViewGroup.getChildCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          return;
        }
        View localView = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(i);
        if (localView.getVisibility() != 8) {
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
  
  public void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c.setVisibility(0);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void i()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onClick() is called");
    }
    if (i == 2131298136)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "isRecording is:" + bool);
      }
      if (!bool) {
        break label94;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g())
      {
        setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(2);
      }
    }
    return;
    label94:
    i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getTitleBarHeight();
    if (!FileUtils.a()) {
      QQToast.a(BaseApplication.getContext(), 2131363006, 0).b(i);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Voice_record_clk", 0, 0, "", "", "", "");
      return;
      if (!QQRecorder.d())
      {
        QQToast.a(BaseApplication.getContext(), 2131363007, 0).b(i);
      }
      else if (!QQRecorder.c())
      {
        QQToast.a(BaseApplication.getContext(), 2131363008, 0).b(i);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
      {
        QQToast.a(BaseApplication.getContext(), 2131363140, 0).a();
      }
      else if (AudioHelper.a(1))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838609);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("停止录音");
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(3);
        paramView = new Rect();
        getWindowVisibleDisplayFrame(paramView);
        this.jdField_a_of_type_AndroidWidgetPopupWindow = AudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), paramView.right, paramView.bottom, this.jdField_b_of_type_AndroidViewViewGroup.getHeight(), this, 0, 0, 0);
        this.jdField_a_of_type_AndroidViewView = AudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_b_of_type_AndroidViewViewGroup);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel
 * JD-Core Version:    0.7.0.1
 */