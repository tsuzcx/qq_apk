package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ListenPanel
  extends RelativeLayout
  implements View.OnClickListener, AudioPanelCallback, VoicePlayer.VoicePlayerListener
{
  public static final int a = 1;
  public static final int b = 2;
  public static int c;
  public static int d = jdField_c_of_type_Int + 1;
  private double jdField_a_of_type_Double;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ChatActivity jdField_a_of_type_ComTencentMobileqqActivityChatActivity;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView;
  private VolumeIndicateView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VolumeIndicateView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView;
  private TextView c;
  private int e;
  private int f = jdField_c_of_type_Int;
  
  static
  {
    jdField_c_of_type_Int = 1;
  }
  
  public ListenPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ListenPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onPause() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      c();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(this.jdField_a_of_type_Double));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130838668);
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130838668);
    c();
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatActivity paramChatActivity, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity = paramChatActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup1;
    this.e = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView = ((VolumeIndicateView)findViewById(2131232854));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView = ((VolumeIndicateView)findViewById(2131232856));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232855));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(0.0D));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView = ((CircleProgressView)findViewById(2131232857));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232859));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232860));
    paramChatActivity = paramChatActivity.getResources();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramQQAppInterface = SkinUtils.a(paramChatActivity.getDrawable(2130839758));
    paramChatActivity = SkinUtils.a(paramChatActivity.getDrawable(2130839759));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setIndicateVolumeBitmap(paramQQAppInterface, 3);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setIndicateVolumeBitmap(paramChatActivity, 4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
    if (QLog.isColorLevel())
    {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.init() is called");
      QLog.d("AIOAudioPanel", 2, "volumeFillLeftBmp is:" + paramQQAppInterface + ",volumeFillRightBmp is:" + paramChatActivity);
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
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    c();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.f == d) {
      i = 3;
    }
    ((ChatActivity)localObject).a(str, i);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b(this.jdField_a_of_type_JavaLangString);
    if (this.e == 1)
    {
      setVisibility(8);
      localObject = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131232861);
      ((PressToSpeakPanel)localObject).c();
      ((PressToSpeakPanel)localObject).setVisibility(0);
    }
    return false;
  }
  
  public void b()
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onDestroy() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    c();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.f == d) {
      i = 3;
    }
    ((ChatActivity)localObject).a(str, i);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b(this.jdField_a_of_type_JavaLangString);
    if (this.e == 1)
    {
      setVisibility(8);
      localObject = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131232861);
      ((PressToSpeakPanel)localObject).c();
      ((PressToSpeakPanel)localObject).setVisibility(0);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131232857)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject = new StringBuilder();
        if (this.f != d) {
          break label192;
        }
        i = 1;
        ReportController.b(paramView, "CliOper", "", "", "0X8004602", "0X8004602", 0, 0, i + "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "ListenPanel listened, jump source = " + this.f);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(this.jdField_a_of_type_JavaLangString, new Handler());
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(getContext());
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130838669);
      }
    }
    label192:
    do
    {
      return;
      i = 2;
      break;
      c();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(this.jdField_a_of_type_Double));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130838668);
      return;
      if (i == 2131232859)
      {
        c();
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity;
        localObject = this.jdField_a_of_type_JavaLangString;
        if (this.f == d) {}
        for (i = 3;; i = 2)
        {
          paramView.a((String)localObject, i);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b(this.jdField_a_of_type_JavaLangString);
          if (this.e != 1) {
            break;
          }
          setVisibility(8);
          paramView = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131232861);
          paramView.c();
          paramView.setVisibility(0);
          return;
        }
      }
    } while (i != 2131232860);
    c();
    if (this.e == 2) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Record_attribute", 0, 0, String.valueOf(this.jdField_a_of_type_Double), "", "", "");
    }
    if (this.jdField_a_of_type_Double < 1000.0D)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131562736), 0).a();
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity;
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (this.f == jdField_c_of_type_Int) {}
    for (i = 2;; i = 3)
    {
      paramView.a((String)localObject, i, (int)(this.jdField_a_of_type_Double / 1000.0D));
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b(this.jdField_a_of_type_JavaLangString);
      if (this.e != 1) {
        break;
      }
      setVisibility(8);
      paramView = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131232861);
      paramView.c();
      paramView.setVisibility(0);
      return;
    }
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130838668);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.setAudioPath() is called,path is:" + paramString + ",recordTime is:" + paramDouble);
    }
  }
  
  public void setJumpSource(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel
 * JD-Core Version:    0.7.0.1
 */