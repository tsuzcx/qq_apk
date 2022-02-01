package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.qphone.base.util.QLog;
import dxt;
import dxu;
import dxv;
import dxw;
import dxx;
import dxy;
import dxz;
import dya;
import dyb;
import dyc;
import dyd;

public class PressToSpeakPanel
  extends RelativeLayout
  implements View.OnTouchListener, AudioPanelCallback, QQRecorder.OnQQRecorderListener
{
  private static final int jdField_b_of_type_Int = 150;
  private static final int jdField_c_of_type_Int = 1;
  private static final int jdField_d_of_type_Int = 0;
  private static final int jdField_e_of_type_Int = 1;
  private static final int jdField_f_of_type_Int = 2;
  private static final int g = 3;
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = -1;
  private Rect jdField_a_of_type_AndroidGraphicsRect = null;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ChatActivity jdField_a_of_type_ComTencentMobileqqActivityChatActivity;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private MoveDistIndicateView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
  private VolumeIndicateView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  private Rect jdField_b_of_type_AndroidGraphicsRect = null;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private MoveDistIndicateView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
  private VolumeIndicateView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private ViewGroup jdField_e_of_type_AndroidViewViewGroup;
  private ViewGroup jdField_f_of_type_AndroidViewViewGroup;
  private int h = 0;
  
  public PressToSpeakPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public PressToSpeakPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private double a(int paramInt1, int paramInt2, View paramView)
  {
    double d1 = paramView.getWidth();
    double d3 = paramView.getHeight();
    if ((paramView == null) || (paramView.getVisibility() != 0)) {
      return -1.0D;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    d1 /= 2.0D;
    double d2 = arrayOfInt[0];
    d3 /= 2.0D;
    double d4 = arrayOfInt[1];
    return Math.sqrt(Math.pow(paramInt1 - (d1 + d2), 2.0D) + Math.pow(paramInt2 - (d3 + d4), 2.0D));
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() != 0) {
      return false;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsRect == null) || (this.jdField_a_of_type_AndroidGraphicsRect.left == this.jdField_a_of_type_AndroidGraphicsRect.right))
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getLocationOnScreen(arrayOfInt);
      this.jdField_a_of_type_AndroidGraphicsRect.left = arrayOfInt[0];
      this.jdField_a_of_type_AndroidGraphicsRect.top = arrayOfInt[1];
      Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      int i = localRect.right;
      localRect.right = (arrayOfInt[0] + i);
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      i = localRect.bottom;
      localRect.bottom = (arrayOfInt[1] + i);
    }
    return this.jdField_a_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2);
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() != 0) {
      return false;
    }
    if ((this.jdField_b_of_type_AndroidGraphicsRect == null) || (this.jdField_b_of_type_AndroidGraphicsRect.left == this.jdField_b_of_type_AndroidGraphicsRect.right))
    {
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getDrawingRect(this.jdField_b_of_type_AndroidGraphicsRect);
      int[] arrayOfInt = new int[2];
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getLocationOnScreen(arrayOfInt);
      this.jdField_b_of_type_AndroidGraphicsRect.left = arrayOfInt[0];
      this.jdField_b_of_type_AndroidGraphicsRect.top = arrayOfInt[1];
      Rect localRect = this.jdField_b_of_type_AndroidGraphicsRect;
      int i = localRect.right;
      localRect.right = (arrayOfInt[0] + i);
      localRect = this.jdField_b_of_type_AndroidGraphicsRect;
      i = localRect.bottom;
      localRect.bottom = (arrayOfInt[1] + i);
    }
    return this.jdField_b_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2);
  }
  
  public void a()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.f();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d(2);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatActivity paramChatActivity, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity = paramChatActivity;
    this.f = paramViewGroup1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup3;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131232863));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232867));
    this.c = ((ViewGroup)findViewById(2131232868));
    this.d = ((ViewGroup)findViewById(2131232853));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView = ((VolumeIndicateView)findViewById(2131232854));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView = ((VolumeIndicateView)findViewById(2131232856));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232855));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131232866));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView = ((MoveDistIndicateView)findViewById(2131232864));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView = ((MoveDistIndicateView)findViewById(2131232865));
    this.e = ((ViewGroup)findViewById(2131232862));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    paramQQAppInterface = paramChatActivity.getResources();
    paramChatActivity = SkinUtils.a(paramQQAppInterface.getDrawable(2130839758));
    paramViewGroup1 = SkinUtils.a(paramQQAppInterface.getDrawable(2130839759));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setIndicateVolumeBitmap(paramChatActivity, 3);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setIndicateVolumeBitmap(paramViewGroup1, 4);
    paramAudioPanel = SkinUtils.a(paramQQAppInterface.getDrawable(2130839742));
    paramViewGroup2 = SkinUtils.a(paramQQAppInterface.getDrawable(2130839740));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setScaleBitmap(paramAudioPanel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setAfterBitmap(paramViewGroup2);
    paramViewGroup3 = SkinUtils.a(paramQQAppInterface.getDrawable(2130839742));
    Bitmap localBitmap = SkinUtils.a(paramQQAppInterface.getDrawable(2130839740));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setScaleBitmap(paramViewGroup3);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setAfterBitmap(localBitmap);
    if (QLog.isColorLevel())
    {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.init() is called");
      QLog.d("AIOAudioPanel", 2, "volumeFillLeftBmp is:" + paramChatActivity + ",volumeFillRightBmp is:" + paramViewGroup1 + ",listenIndicateMoveDist is:" + paramAudioPanel + ",listenIndicateEnter is:" + paramViewGroup2 + ",delIndicateMoveDist is:" + paramViewGroup3 + ",delIndicateEnter is:" + localBitmap);
    }
    if (this.jdField_a_of_type_Int == -1)
    {
      paramChatActivity = new Rect();
      getWindowVisibleDisplayFrame(paramChatActivity);
      int i = paramChatActivity.right / 2;
      int j = AIOUtils.a(75.0F, paramQQAppInterface);
      this.jdField_a_of_type_Int = (i - j);
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "rect is:" + paramChatActivity + "entirePanelWidth is:" + i + ",listenRight is:" + j + ",mBasicDistance is:" + this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderPrepare() is called,path is:" + paramString);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new dxw(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a(paramString, false);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderError() is called,path is:" + paramString1 + ",errorCode is:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a(paramString1);
    this.jdField_a_of_type_AndroidOsHandler.post(new dxz(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt, double paramDouble)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a(paramString, paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d(paramString);
    this.jdField_a_of_type_AndroidOsHandler.post(new dxy(this, paramInt, paramDouble));
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.f();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d(2);
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    int m = (int)paramMotionEvent.getRawY();
    int n = (int)paramMotionEvent.getRawX();
    if ((k == 0) || (k == 2))
    {
      this.h = 3;
      double d1;
      double d2;
      int j;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() == 0)
      {
        d1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getWidth() / 2.0D;
        d2 = a(n, m, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView);
        if ((d2 >= 0.0D) && (d2 <= this.jdField_a_of_type_Int + d1))
        {
          if (d2 <= d1) {
            this.h = 1;
          }
          i = (int)(100.0D - (d2 - d1) / this.jdField_a_of_type_Int * 100.0D);
          if (this.h != 1) {
            break label335;
          }
          i = 100;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
          this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
          j = i;
          if (i > 100) {
            j = 100;
          }
          paramMotionEvent.setLevel(j);
        }
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() == 0)
      {
        d1 = this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getWidth() / 2.0D;
        d2 = a(n, m, this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView);
        if ((d2 >= 0.0D) && (d2 <= this.jdField_a_of_type_Int + d1))
        {
          if (d2 <= d1) {
            this.h = 2;
          }
          i = (int)(100.0D - (d2 - d1) / this.jdField_a_of_type_Int * 100.0D);
          if (this.h != 2) {
            break label354;
          }
          i = 100;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
          this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
          label302:
          paramMotionEvent = this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
          j = i;
          if (i > 100) {
            j = 100;
          }
          paramMotionEvent.setLevel(j);
        }
      }
    }
    if (k == 0) {}
    label335:
    label354:
    while ((k == 2) || ((k != 1) && (k != 3)))
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(0);
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(0);
      break label302;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    int i = 0;
    if (this.h == 1) {
      i = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d(i);
      break;
      if (this.h == 2) {
        i = 1;
      } else if (this.h == 3) {
        i = 0;
      }
    }
  }
  
  public void b()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.f();
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.e(1);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderNotReady() is called,path is:" + paramString);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset() is called");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.isFinishing()) {}
    for (;;)
    {
      return;
      this.e.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(AudioPanel.a(0.0D));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130839751);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(1);
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
        while (i < j)
        {
          View localView = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(i);
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
          localAlphaAnimation.setDuration(0L);
          localAlphaAnimation.setInterpolator(new LinearInterpolator());
          localView.startAnimation(localAlphaAnimation);
          i += 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
          }
        }
      }
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderEnd() is called,path is:" + paramString);
    }
    int i = StreamDataManager.a(paramString);
    if (i < 512)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.c(paramString);
      this.jdField_a_of_type_AndroidOsHandler.post(new dya(this));
      return;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "time is:" + i + ",fateOfRecorder is:" + j);
    }
    if (j == 2)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new dyb(this, paramString));
      return;
    }
    if (j == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a(paramString, 1, (int)(this.jdField_a_of_type_Double / 1000.0D));
      this.jdField_a_of_type_AndroidOsHandler.post(new dyc(this, paramString));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a(paramString, 1);
    this.jdField_a_of_type_AndroidOsHandler.post(new dyd(this, paramString));
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.prepareRecord() is called,time is:" + System.currentTimeMillis());
    }
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c.setVisibility(0);
    this.d.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, " PressToSpeakPanel.startRecord() is called, time is " + System.currentTimeMillis());
    }
    this.e.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setDuration(150L);
    localAnimationSet.setInterpolator(new LinearInterpolator());
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.86F, 1.0F, 0.86F, 1.0F, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setAnimationListener(new dxt(this));
    this.e.startAnimation(localAnimationSet);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderStart() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new dxx(this));
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBeginReceiveData() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.x();
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitSuccess() is called");
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitFailed() is called");
    }
  }
  
  public void j()
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
    localAnimationSet.setAnimationListener(new dxv(this));
    this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onTouch() is called,action is:" + i);
    }
    if (paramView.getId() == 2131232866)
    {
      if (i == 0)
      {
        paramView = new dxu(this, paramMotionEvent);
        paramView = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, paramView);
        paramView.what = 1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 150L);
      }
      do
      {
        do
        {
          do
          {
            return true;
            if (i != 2) {
              break;
            }
          } while ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.f()));
          a(paramMotionEvent);
          return true;
        } while ((i != 3) && (i != 1));
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_Boolean = false;
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.f());
      a(paramMotionEvent);
      return true;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel
 * JD-Core Version:    0.7.0.1
 */