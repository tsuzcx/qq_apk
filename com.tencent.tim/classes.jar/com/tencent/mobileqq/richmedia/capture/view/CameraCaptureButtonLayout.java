package com.tencent.mobileqq.richmedia.capture.view;

import acfp;
import alxk;
import alxl;
import alxm;
import alxn;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlc;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import wja;

public class CameraCaptureButtonLayout
  extends RelativeLayout
{
  private View Gn;
  private TextView XY;
  private TextView XZ;
  private a jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout$a;
  private b jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout$b;
  private c jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout$c;
  private CameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
  private long ahO;
  private ValueAnimator animator;
  private boolean cAn;
  public AtomicBoolean dE = new AtomicBoolean(false);
  public AtomicBoolean dF = new AtomicBoolean(false);
  private int dyO = wja.dp2px(45.0F, getResources());
  private int dyP = wja.dp2px(70.0F, getResources());
  private int dyQ = 1;
  private Handler handler = new alxn(this);
  private boolean isOver;
  private boolean isPaused;
  private CircleProgress j;
  private View.OnTouchListener onTouchListener = new alxm(this);
  public ImageView wr;
  private ImageView ws;
  private float za = 10000.0F;
  
  public CameraCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CameraCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void AQ()
  {
    ba(1.0F);
    this.j.setProgress(0.0F);
    this.XZ.setText("");
    this.wr.setEnabled(true);
    this.wr.setVisibility(0);
    this.wr.setImageDrawable(null);
    this.ws.setVisibility(8);
  }
  
  private void adc()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout$c;
    if (localObject != null)
    {
      this.isOver = ((c)localObject).a(this.XZ, this.j, this.ahO, this.za);
      if (this.isOver) {
        stopCapture();
      }
      return;
    }
    long l = System.currentTimeMillis() - this.ahO;
    boolean bool;
    if ((float)l >= this.za)
    {
      bool = true;
      label72:
      this.isOver = bool;
      if (!this.isOver) {
        break label185;
      }
    }
    label185:
    for (int i = 100;; i = (int)((float)l / this.za * 100.0F))
    {
      localObject = (int)l / 1000 + acfp.m(2131703353);
      this.XZ.setText((CharSequence)localObject);
      this.j.setProgress(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CameraCaptureLayout", 2, "updateProgress percent:" + i + ", time:" + (String)localObject);
      break;
      bool = false;
      break label72;
    }
  }
  
  private void ba(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.wr.getLayoutParams();
    localLayoutParams.width = ((int)(this.dyO * paramFloat));
    localLayoutParams.height = ((int)(this.dyO * paramFloat));
    localLayoutParams.addRule(13);
    this.wr.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    localLayoutParams.width = ((int)(this.dyP * paramFloat));
    localLayoutParams.height = ((int)(this.dyP * paramFloat));
    localLayoutParams.addRule(13);
    this.j.setLayoutParams(localLayoutParams);
  }
  
  @TargetApi(11)
  private void cxg()
  {
    if (this.ws != null)
    {
      Animation localAnimation = this.ws.getAnimation();
      if (localAnimation != null)
      {
        localAnimation.cancel();
        localAnimation.setAnimationListener(null);
      }
      this.ws.clearAnimation();
    }
    if (this.animator != null) {
      this.animator.cancel();
    }
  }
  
  @TargetApi(11)
  private void cxj()
  {
    this.ws.setVisibility(8);
    anlc.a(this.ws, 0.1F, 1.0F, 0.1F, 1.2F, 400, null);
    this.animator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.1333F });
    this.animator.setDuration(400L);
    this.animator.addUpdateListener(new alxk(this));
    this.animator.addListener(new alxl(this));
    this.animator.start();
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(2131561357, this, true);
    this.Gn = findViewById(2131367263);
    this.XZ = ((TextView)findViewById(2131367345));
    this.XY = ((TextView)findViewById(2131366478));
    this.j = ((CircleProgress)findViewById(2131365505));
    this.wr = ((ImageView)findViewById(2131367247));
    this.ws = ((ImageView)findViewById(2131367248));
    this.wr.setOnTouchListener(this.onTouchListener);
    this.wr.setEnabled(true);
    this.j.setBgAndProgressColor(100, getResources().getColor(2131167654), 100, getResources().getColor(2131165409));
    this.j.setStrokeWidth(4.5F);
  }
  
  private void stopCapture()
  {
    if (!this.cAn) {
      return;
    }
    if ((this.dyQ == 3) || (this.dyQ == 1))
    {
      this.dF.set(true);
      this.handler.removeMessages(5);
      cxg();
      if (this.dE.get()) {
        this.handler.sendEmptyMessage(3);
      }
    }
    for (;;)
    {
      this.cAn = false;
      return;
      this.handler.removeMessages(1);
      if (this.dyQ == 1)
      {
        this.handler.sendEmptyMessage(4);
        continue;
        if (this.dyQ == 2) {
          this.handler.sendEmptyMessage(4);
        }
      }
    }
  }
  
  public void by(boolean paramBoolean, int paramInt)
  {
    float f = this.Gn.getHeight();
    ObjectAnimator localObjectAnimator;
    if (paramBoolean) {
      localObjectAnimator = ObjectAnimator.ofFloat(this.Gn, "translationY", new float[] { 0.0F, f });
    }
    for (ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);; localScaleAnimation = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F))
    {
      localScaleAnimation.setDuration(paramInt);
      localScaleAnimation.setFillAfter(true);
      localObjectAnimator.setDuration(paramInt).start();
      this.wr.startAnimation(localScaleAnimation);
      this.j.startAnimation(localScaleAnimation);
      return;
      localObjectAnimator = ObjectAnimator.ofFloat(this.Gn, "translationY", new float[] { f, 0.0F });
    }
  }
  
  public void dKJ()
  {
    if ((this.XY != null) && (this.XY.getVisibility() == 0))
    {
      this.XY.clearAnimation();
      this.XY.setVisibility(8);
    }
  }
  
  public void reset()
  {
    AQ();
    this.dF.set(false);
    this.dE.set(false);
    this.ahO = 0L;
    this.isOver = false;
    this.cAn = false;
    this.handler.removeCallbacksAndMessages(null);
  }
  
  public void setButtonListenerInterceptor(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout$b = paramb;
  }
  
  public void setCaptureButtonProgressInterceptor(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout$c = paramc;
  }
  
  public void setFunctionFlag(int paramInt)
  {
    this.dyQ = paramInt;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.za = paramFloat;
  }
  
  public void setRecordTipsWording(String paramString)
  {
    this.XY.setText(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void coA();
    
    public abstract void coB();
    
    public abstract void dKK();
  }
  
  public static abstract interface b
  {
    public abstract boolean auP();
  }
  
  public static abstract interface c
  {
    public abstract boolean a(@NonNull TextView paramTextView, @NonNull CircleProgress paramCircleProgress, long paramLong, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */