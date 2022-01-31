package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class CommonListenPanel
  extends RelativeLayout
  implements View.OnClickListener, AudioPanelCallback, VoicePlayer.VoicePlayerListener
{
  public static final int a = 1;
  public static final int b = 2;
  public static int c = 0;
  public static int d = jdField_c_of_type_Int + 1;
  public static final int e = 101;
  public static final int f = 102;
  public static final int g = 103;
  private double jdField_a_of_type_Double;
  Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView;
  private VolumeIndicateView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VolumeIndicateView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView;
  private TextView c;
  private int h;
  private int i = jdField_c_of_type_Int;
  
  static
  {
    jdField_c_of_type_Int = 1;
  }
  
  public CommonListenPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonListenPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130838608);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription("开始试听");
    a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Handler paramHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.h = 2;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView = ((VolumeIndicateView)findViewById(2131298116));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView = ((VolumeIndicateView)findViewById(2131298118));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298117));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(0.0D));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView = ((CircleProgressView)findViewById(2131298119));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298121));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298122));
    paramBaseActivity = paramBaseActivity.getResources();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramQQAppInterface = SkinUtils.a(paramBaseActivity.getDrawable(2130839173));
    paramBaseActivity = SkinUtils.a(paramBaseActivity.getDrawable(2130839174));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setIndicateVolumeBitmap(paramQQAppInterface, 3);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setIndicateVolumeBitmap(paramBaseActivity, 4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
    if (QLog.isColorLevel())
    {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.init() is called");
      QLog.d("AIOAudioPanel", 2, "volumeFillLeftBmp is:" + paramQQAppInterface + ",volumeFillRightBmp is:" + paramBaseActivity);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      paramInt1 = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(paramInt1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(paramInt2));
      return;
      if (paramInt2 > paramInt1) {
        paramInt1 = 100;
      } else {
        paramInt1 = paramInt2 * 100 / paramInt1;
      }
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    a();
    return false;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onPause() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(this.jdField_a_of_type_Double));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130838608);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription("开始试听");
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onDestroy() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    a();
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    int k = paramView.getId();
    if (k == 2131298119) {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.i == d)
        {
          ReportController.b(paramView, "CliOper", "", "", "0X8004602", "0X8004602", 0, 0, j + "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "ListenPanel listened, jump source = " + this.i);
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(103);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) {
          break label217;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(this.jdField_a_of_type_JavaLangString, new Handler());
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(getContext());
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130838609);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription("ͣ停止试听");
      }
    }
    label217:
    do
    {
      do
      {
        do
        {
          return;
          j = 2;
          break;
          a();
          this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(this.jdField_a_of_type_Double));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130838608);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription("开始试听");
          return;
          if (k != 2131298121) {
            break label297;
          }
          a();
        } while (this.h != 2);
        setVisibility(8);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
        return;
      } while (k != 2131298122);
      a();
      if (this.jdField_a_of_type_Double < 1000.0D)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362984), 0).a();
        return;
      }
    } while (this.h != 2);
    label297:
    setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAudioPath(String paramString, double paramDouble)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Double = paramDouble;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(paramDouble));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130838608);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription("开始试听");
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.setAudioPath() is called,path is:" + paramString + ",recordTime is:" + paramDouble);
    }
  }
  
  public void setJumpSource(int paramInt)
  {
    this.i = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonListenPanel
 * JD-Core Version:    0.7.0.1
 */