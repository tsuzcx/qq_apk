package com.tencent.av.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import bkr;
import bks;
import bkt;
import bku;
import bkv;
import bkw;
import bkx;
import bky;
import bkz;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.utils.QQAnimationListener;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.av.utils.RingAnimator;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TipsManager.TYPE;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import java.lang.ref.WeakReference;

public abstract class VideoControlUI
{
  private static final String jdField_a_of_type_JavaLangString = "VideoControlUI";
  public Resources a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  Sensor jdField_a_of_type_AndroidHardwareSensor = null;
  SensorEventListener jdField_a_of_type_AndroidHardwareSensorEventListener = null;
  SensorManager jdField_a_of_type_AndroidHardwareSensorManager = null;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener = null;
  public ViewGroup a;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
  public VideoController a;
  public VideoAppInterface a;
  public ControlUIObserver a;
  QQAnimationListener jdField_a_of_type_ComTencentAvUtilsQQAnimationListener = new bkt(this);
  QQFrameByFrameAnimation jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = null;
  RingAnimator jdField_a_of_type_ComTencentAvUtilsRingAnimator = null;
  public TipsManager a;
  TraeAudioSession jdField_a_of_type_ComTencentSharpJniTraeAudioSession = null;
  public WeakReference a;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  public Sensor b;
  SensorEventListener jdField_b_of_type_AndroidHardwareSensorEventListener = null;
  public View b;
  Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new bkv(this);
  Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation = null;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  Drawable c;
  public Button c;
  public ImageButton c;
  public RelativeLayout c;
  Button jdField_d_of_type_AndroidWidgetButton = null;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout = null;
  public Button e;
  public String e;
  public Button f;
  public TextView f;
  public boolean g = false;
  public int h;
  public boolean h;
  int i;
  public boolean i;
  int j;
  public boolean j;
  public int k;
  Runnable k;
  public boolean k;
  final int jdField_l_of_type_Int = 1;
  Runnable jdField_l_of_type_JavaLangRunnable = new bkr(this);
  boolean jdField_l_of_type_Boolean = false;
  final int jdField_m_of_type_Int = 2;
  Runnable jdField_m_of_type_JavaLangRunnable = new bku(this);
  final int n = 3;
  int o = -1;
  public int p = 0;
  
  public VideoControlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_k_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_f_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_c_of_type_AndroidWidgetButton = null;
    this.jdField_e_of_type_AndroidWidgetButton = null;
    this.jdField_f_of_type_AndroidWidgetButton = null;
    this.jdField_c_of_type_AndroidWidgetImageButton = null;
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidHardwareSensor = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    paramVideoAppInterface = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoControlUI", 2, "VideoControlUI-->can not get AVActivity");
      }
      return;
    }
    this.jdField_a_of_type_AndroidContentResResources = paramVideoAppInterface.getResources();
    if (this.jdField_a_of_type_AndroidContentResResources == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoControlUI", 2, "mRes is null. exit video progress");
      }
      paramAVActivity = paramVideoAppInterface.getString(2131560117) + " 0x01";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoControlUI", 2, "mVideoController is null. exit video progress");
      }
      paramAVActivity = this.jdField_a_of_type_AndroidContentResResources.getString(2131560117) + " 0x01";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = paramControlUIObserver;
    this.jdField_k_of_type_JavaLangRunnable = new bky(this);
    S();
  }
  
  private float a(float paramFloat)
  {
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext == null) {
      return 0.0F;
    }
    int i1 = UITools.a(localContext);
    float f1 = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi / 160.0F;
    return i1 * paramFloat / 480.0F / f1;
  }
  
  void D()
  {
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession(((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext(), new bks(this));
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.c();
  }
  
  public void N()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoControlUI", 2, "onPauseAudio");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_AUDIO_CLOSE_MIC, true);
    }
  }
  
  public void O()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoControlUI", 2, "onResumeAudio");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_AUDIO_CLOSE_MIC, false);
    }
  }
  
  protected void P()
  {
    float f1 = a(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427670));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_d_of_type_AndroidWidgetButton.getLayoutParams();
    localMarginLayoutParams.leftMargin = ((int)f1);
    localMarginLayoutParams.rightMargin = ((int)f1);
    this.jdField_d_of_type_AndroidWidgetButton.requestLayout();
  }
  
  public void Q()
  {
    if (this.g) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoControlUI", 2, "startTimer");
      }
      this.g = true;
    } while (this.jdField_k_of_type_JavaLangRunnable == null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_k_of_type_JavaLangRunnable, 0L);
  }
  
  public void R()
  {
    if (!this.g) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoControlUI", 2, "stopTimer");
      }
      this.g = false;
    } while (this.jdField_k_of_type_JavaLangRunnable == null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
  }
  
  public void S()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localContext != null) {
        this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)localContext.getSystemService("sensor"));
      }
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
    {
      this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
      this.jdField_b_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
    }
    this.jdField_a_of_type_AndroidHardwareSensorEventListener = new bkw(this);
    this.jdField_b_of_type_AndroidHardwareSensorEventListener = new bkx(this);
  }
  
  void T()
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a();
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = null;
    }
  }
  
  public void U()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoControlUI", 2, "setScreenDarken");
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
    }
  }
  
  void V()
  {
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = new QQFrameByFrameAnimation();
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(100);
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.c(8);
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(new int[] { 2130838232, 2130838233 });
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener);
  }
  
  public void W()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().a == 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a == 4)) {
      if (this.jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_m_of_type_JavaLangRunnable);
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().a != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().e())) {}
      }
    }
    while ((this.jdField_a_of_type_ComTencentAvVideoController.a().a != 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a != 3))
    {
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_m_of_type_JavaLangRunnable, 5000L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_m_of_type_JavaLangRunnable);
      return;
    }
    if (!this.jdField_h_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().a == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().e()))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_m_of_type_JavaLangRunnable);
        return;
      }
      u();
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_m_of_type_JavaLangRunnable);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    do
    {
      return 0;
      if (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null) {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232209));
      }
    } while (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null);
    if (this.jdField_h_of_type_Boolean) {}
    for (int i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427636) + this.jdField_c_of_type_AndroidWidgetRelativeLayout.getHeight();; i1 = 0) {
      return i1;
    }
  }
  
  public abstract int a(int paramInt);
  
  protected void a()
  {
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232200));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232199));
    this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232201));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232204));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838227);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838228);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838226);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232197));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232209));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232197));
    P();
    b(this.jdField_a_of_type_ComTencentAvVideoController.a().n, false);
    int i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427680);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, i1, 0.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(700L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, -i1, 0.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(700L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoControlUI", 2, "onClose type = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
    {
      f(paramInt);
      return;
    }
    if (paramInt == 25) {
      f(paramInt);
    }
    m();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    }
    Button localButton;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (this.jdField_c_of_type_AndroidWidgetButton == null);
            this.jdField_c_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
            return;
          } while (this.jdField_d_of_type_AndroidWidgetButton == null);
          this.jdField_d_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
          return;
        } while (this.jdField_e_of_type_AndroidWidgetButton == null);
        this.jdField_e_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
        return;
      } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
      localButton = (Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232207);
    } while (localButton == null);
    localButton.setEnabled(paramBoolean);
    localButton.clearAnimation();
    if (paramBoolean)
    {
      localButton.startAnimation(AnimationUtils.loadAnimation(localButton.getContext(), 2130968631));
      return;
    }
    localButton.startAnimation(AnimationUtils.loadAnimation(localButton.getContext(), 2130968632));
  }
  
  public abstract void a(Intent paramIntent);
  
  public abstract void a(View paramView);
  
  public void a(TipsManager paramTipsManager)
  {
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = paramTipsManager;
  }
  
  public abstract void a(String paramString);
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a();
      return;
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
  }
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    do
    {
      return 0;
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232197));
      }
    } while (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null);
    if (this.jdField_h_of_type_Boolean) {}
    for (int i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427637) + this.jdField_b_of_type_AndroidWidgetRelativeLayout.getHeight();; i1 = 0) {
      return i1;
    }
  }
  
  public abstract void b();
  
  public abstract void b(int paramInt);
  
  public void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      if (paramInt != 0) {
        break label26;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NETWORK_INFO_S2C.ordinal());
    }
    label26:
    while (paramString == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NETWORK_INFO_S2C.ordinal(), paramString);
  }
  
  public abstract void b(String paramString);
  
  public abstract void b(boolean paramBoolean);
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = (AudioManager)((Context)localObject).getSystemService("audio");
      int i1 = ((AudioManager)localObject).getStreamVolume(this.p);
      int i2 = ((AudioManager)localObject).getStreamMaxVolume(this.p);
      i2 = (int)(i1 / i2 * 100.0F);
      if (i2 < 30) {
        i1 = 1;
      }
      while ((paramBoolean1 != this.jdField_a_of_type_ComTencentAvVideoController.a().n) || (i1 != this.o) || (paramBoolean2))
      {
        if (i2 < 30) {
          localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        }
        for (;;)
        {
          label113:
          this.o = i1;
          this.jdField_c_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject, null, null);
          if (paramBoolean1) {
            this.jdField_c_of_type_AndroidWidgetButton.setSelected(true);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a().n = paramBoolean1;
            return;
            if ((i2 >= 30) && (i2 <= 70))
            {
              i1 = 2;
              break;
            }
            if (i2 <= 70) {
              break label241;
            }
            i1 = 3;
            break;
            if ((i2 >= 30) && (i2 <= 70))
            {
              localObject = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
              break label113;
            }
            if (i2 <= 70) {
              break label235;
            }
            localObject = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
            break label113;
            this.jdField_c_of_type_AndroidWidgetButton.setSelected(false);
          }
          label235:
          localObject = null;
        }
        label241:
        i1 = 0;
      }
    }
  }
  
  public abstract void c();
  
  void c(int paramInt) {}
  
  public abstract void c(boolean paramBoolean);
  
  public abstract void d();
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NETWORK_BAD.ordinal(), null);
    }
  }
  
  boolean d()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      AudioManager localAudioManager = (AudioManager)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSystemService("audio");
      int i1 = localAudioManager.getStreamVolume(this.p);
      int i2 = localAudioManager.getStreamMaxVolume(this.p);
      if ((int)(i1 / i2 * 100.0F) < 30) {
        return true;
      }
    }
    return false;
  }
  
  public abstract void e();
  
  public void e(int paramInt)
  {
    ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(paramInt, this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NETWORK_BAD.ordinal(), paramString);
    }
  }
  
  public abstract void e(boolean paramBoolean);
  
  public abstract void f();
  
  void f(int paramInt)
  {
    int i1 = 2131560241;
    switch (paramInt)
    {
    default: 
      i1 = 2131560243;
    }
    for (;;)
    {
      c(i1);
      return;
      i1 = 2131560135;
      continue;
      i1 = 2131560242;
      continue;
      i1 = 2131560244;
    }
  }
  
  public void f(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().f == 11) {
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_SWITCH_TO_MULTI_REMOTE, true);
      }
    }
    while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_SWITCH_TO_MULTI_WAITING_TIPS.ordinal(), paramString, 0L, false);
  }
  
  void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoControlUI", 2, "setSensors " + paramBoolean);
    }
    if ((this.jdField_a_of_type_AndroidHardwareSensorEventListener == null) || (this.jdField_b_of_type_AndroidHardwareSensorEventListener == null)) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
    } while (this.jdField_l_of_type_Boolean);
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_a_of_type_AndroidHardwareSensor, 3);
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_b_of_type_AndroidHardwareSensorEventListener, this.jdField_b_of_type_AndroidHardwareSensor, 3);
    return;
    if (this.jdField_l_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener);
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_b_of_type_AndroidHardwareSensorEventListener);
    }
    this.jdField_l_of_type_Boolean = false;
  }
  
  public void g()
  {
    R();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_m_of_type_JavaLangRunnable);
    }
  }
  
  void g(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131232199: 
      UITools.a(this.jdField_c_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131560155));
      b(true, false);
      return;
    case 2131232200: 
      UITools.a(this.jdField_d_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131560163));
      this.jdField_d_of_type_AndroidWidgetButton.setSelected(true);
      return;
    }
    UITools.a(this.jdField_e_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131560151));
    this.jdField_e_of_type_AndroidWidgetButton.setSelected(true);
  }
  
  public abstract void h();
  
  public void h(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131232199: 
      UITools.a(this.jdField_c_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131560156));
      b(false, false);
      return;
    case 2131232200: 
      UITools.a(this.jdField_d_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131560164));
      this.jdField_d_of_type_AndroidWidgetButton.setSelected(false);
      return;
    }
    UITools.a(this.jdField_e_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131560150));
    this.jdField_e_of_type_AndroidWidgetButton.setSelected(false);
  }
  
  public void i() {}
  
  public void i(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoControlUI", 2, "onResumeVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_VIDEO_REMOTE_CLOSE_CAMERA, false);
    }
  }
  
  public abstract void k();
  
  public abstract void l();
  
  void m() {}
  
  public void n() {}
  
  public abstract void o();
  
  public void p() {}
  
  public void s() {}
  
  public abstract void t();
  
  public void u()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("VideoControlUI", 2, "switchToolBar-->mVideoController is null, Why???");
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().a == 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a == 3)) {
        this.jdField_h_of_type_Boolean = true;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidViewViewGroup == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("VideoControlUI", 2, "switchToolBar-->mRootView is null Why");
          return;
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().a == 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a == 4))
          {
            if (!this.jdField_h_of_type_Boolean) {}
            for (;;)
            {
              this.jdField_h_of_type_Boolean = bool;
              break;
              bool = false;
            }
          }
        }
      }
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232197));
      }
      if (this.jdField_h_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(false);
        }
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968630);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968638);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener == null) {
          this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new bkz(this);
        }
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        if (VcSystemInfo.a()) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        return;
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968629);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968637);
        if (this.jdField_b_of_type_AndroidViewView != null) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      }
    } while (this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener == null);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener.onAnimationEnd(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI
 * JD-Core Version:    0.7.0.1
 */