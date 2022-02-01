package dov.com.qq.im.ptv;

import acfp;
import ainc;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlc;
import aqcl;
import ayaj;
import ayaw;
import ayax;
import ayay;
import ayaz;
import ayba;
import azbx;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LightWeightCaptureButtonHorizontalLayout
  extends LightWeightCaptureButtonLayout
{
  private boolean dxG;
  private TextView my;
  private int yOffset;
  
  public LightWeightCaptureButtonHorizontalLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public LightWeightCaptureButtonHorizontalLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void bB(float paramFloat)
  {
    if (!this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxV)
    {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxV = true;
      float f = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.eJl;
      this.c.setTranslationX(f - paramFloat);
      if (AppSetting.enableTalkBack) {
        aqcl.speak(this.jdField_a_of_type_DovComQqImPtvBaseButton, acfp.m(2131707720));
      }
      return;
    }
    ePG();
  }
  
  private void bC(float paramFloat)
  {
    if (!this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxU)
    {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxU = true;
      float f = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.eJk;
      this.jdField_b_of_type_DovComQqImPtvBaseButton.setTranslationX(-(f - paramFloat));
      if (AppSetting.enableTalkBack) {
        aqcl.speak(this.jdField_a_of_type_DovComQqImPtvBaseButton, acfp.m(2131707735));
      }
      return;
    }
    ePF();
  }
  
  private void ePF()
  {
    float f1 = this.jdField_b_of_type_DovComQqImPtvBaseButton.getTranslationX();
    float f2 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.xDiff;
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setTranslationX(f1 + f2);
  }
  
  private void ePG()
  {
    float f1 = this.c.getTranslationX();
    float f2 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.xDiff;
    this.c.setTranslationX(f1 + f2);
  }
  
  private void ePH()
  {
    if (!this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxR)
    {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxR = true;
      ePZ();
    }
  }
  
  private void ePM()
  {
    int i = getResources().getColor(2131165520);
    int j = getResources().getColor(2131165521);
    ePN();
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setBackgroundColor(i);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowColor(j);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageWidth(azbx.dip2px(32.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageHeight(azbx.dip2px(32.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageResource(2130845326);
    i = getResources().getColor(2131165321);
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setBackgroundColor(-1);
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageWidth(azbx.dip2px(30.0F));
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageHeight(azbx.dip2px(30.0F));
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageResource(2130845315);
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setShadowColor(i);
    this.c.setBackgroundColor(-1);
    this.c.setShadowColor(i);
    this.c.setImageWidth(azbx.dip2px(30.0F));
    this.c.setImageHeight(azbx.dip2px(30.0F));
    this.c.setImageResource(2130845332);
  }
  
  private void ePN()
  {
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowStrokeMaxWidth(azbx.dip2px(10.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowStrokeWidth(azbx.dip2px(10.0F));
  }
  
  private void ePO()
  {
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowStrokeMaxWidth(azbx.dip2px(30.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowStrokeWidth(azbx.dip2px(2.0F));
  }
  
  private void ePP()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "alpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "scaleX", new float[] { 1.5F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "scaleY", new float[] { 1.5F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator3);
    localAnimatorSet.setDuration(100L);
    localAnimatorSet.addListener(new ayaw(this));
    localAnimatorSet.start();
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.c, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator1.setDuration(100L);
    localObjectAnimator1.start();
    this.jdField_b_of_type_DovComQqImPtvLightWeightProgress.setStatus(true);
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvLightWeightProgress, "currentProgress", new float[] { 0.0F });
    localObjectAnimator1.setDuration(100L);
    localObjectAnimator1.start();
    localObjectAnimator1.addListener(new ayax(this));
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvBaseButton, "translationX", new float[] { this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX(), this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.Fv });
    localObjectAnimator1.setDuration(100L);
    localObjectAnimator1.start();
  }
  
  private void ePQ()
  {
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setVisibility(0);
    this.c.setVisibility(0);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(100L);
    localObjectAnimator.start();
    localObjectAnimator = ObjectAnimator.ofFloat(this.c, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(100L);
    localObjectAnimator.start();
  }
  
  private void ePR()
  {
    int j = getResources().getColor(2131165321);
    int i = getResources().getColor(2131165743);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.jdField_b_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { i, -1 });
    localObjectAnimator.setEvaluator(ayaj.a());
    int k = getResources().getColor(2131165744);
    Object localObject2 = ObjectAnimator.ofInt(this.jdField_b_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { k, j });
    ((ObjectAnimator)localObject2).setEvaluator(ayaj.a());
    Object localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).play(localObjectAnimator).with((Animator)localObject2);
    ((AnimatorSet)localObject1).setDuration(100L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "rotation", new float[] { 180.0F, 0.0F });
    localObject2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "translationX", new float[] { this.jdField_b_of_type_DovComQqImPtvBaseButton.getTranslationX(), 0.0F });
    this.Gm.clear();
    this.Gm.add(localObjectAnimator);
    this.Gm.add(localObject2);
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "rollBackDeleteAnimatorToActive deleteView ScaleX:" + this.jdField_b_of_type_DovComQqImPtvBaseButton.getScaleX() + " ScaleY:" + this.jdField_b_of_type_DovComQqImPtvBaseButton.getScaleY());
    }
    localObject1 = a(this.jdField_b_of_type_DovComQqImPtvBaseButton, 1.5F, 1.533F, 1.533F, 1.0F, (Animator)localObject1, this.Gm, 140L, 50L);
    ((AnimatorSet)localObject1).addListener(new ayay(this));
    ((AnimatorSet)localObject1).start();
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageResource(2130845313);
    j = getResources().getColor(2131165516);
    k = getResources().getColor(2131165523);
    int m = getResources().getColor(2131165519);
    localObject1 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { i, j });
    ((ObjectAnimator)localObject1).setEvaluator(ayaj.a());
    localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { m, k });
    localObjectAnimator.setEvaluator(ayaj.a());
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play((Animator)localObject1).with(localObjectAnimator);
    ((AnimatorSet)localObject2).setDuration(100L);
    localObject1 = a(this.jdField_a_of_type_DovComQqImPtvBaseButton, 1.0F, 1.022F, 1.022F, 1.0F, (Animator)localObject2, null, 140L, 50L);
    ((AnimatorSet)localObject1).addListener(new ayaz(this));
    ((AnimatorSet)localObject1).start();
    i = getResources().getColor(2131166538);
    localObject1 = ObjectAnimator.ofInt(this.jdField_b_of_type_DovComQqImPtvLightWeightProgress, "deleteColor", new int[] { i, this.jdField_b_of_type_DovComQqImPtvLightWeightProgress.RH() });
    ((ObjectAnimator)localObject1).setStartDelay(90L);
    ((ObjectAnimator)localObject1).setDuration(50L);
    ((ObjectAnimator)localObject1).addListener(new ayba(this));
    ((ObjectAnimator)localObject1).start();
  }
  
  protected void a(LightWeightCaptureButtonLayout.b paramb, SimpleEffectsCaptureView paramSimpleEffectsCaptureView, LightWeightProgress paramLightWeightProgress)
  {
    super.a(paramb, paramSimpleEffectsCaptureView, paramLightWeightProgress);
    anlc.a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView, 0.0F, 0.0F, this.yOffset, 0.0F, 400, 0.0F, 1.0F);
    anlc.a(this.jdField_b_of_type_DovComQqImPtvLightWeightProgress, 0.0F, 0.0F, this.yOffset, 0.0F, 400, 0.0F, 1.0F);
  }
  
  protected boolean a(LWMotionEvent paramLWMotionEvent)
  {
    if (super.a(paramLWMotionEvent)) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO)
      {
        ePP();
        return true;
      }
    } while (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status < 2);
    ePH();
    return true;
  }
  
  protected void c(LWMotionEvent paramLWMotionEvent)
  {
    int i = getResources().getColor(2131165516);
    int j = getResources().getColor(2131165523);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setBackgroundColor(i);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowColor(j);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageWidth(azbx.dip2px(40.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageHeight(azbx.dip2px(40.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageResource(2130845325);
    ePO();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImPtvBaseButton.getLayoutParams();
    i = azbx.dip2px('');
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    localLayoutParams.bottomMargin = azbx.dip2px(2.5F);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setLayoutParams(localLayoutParams);
    this.dxG = true;
    ePQ();
    this.my.clearAnimation();
    this.my.setVisibility(8);
    if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c != null) {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c.ecC();
    }
    ainc.PV(this.mSessionType);
    super.c(paramLWMotionEvent);
  }
  
  protected void d(LWMotionEvent paramLWMotionEvent)
  {
    if (this.dxG)
    {
      if (this.jdField_a_of_type_DovComQqImPtvBaseButton.isLayoutRequested())
      {
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxP = true;
        return;
      }
      this.dxG = false;
      if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxP)
      {
        super.c(paramLWMotionEvent);
        return;
      }
      super.d(paramLWMotionEvent);
      return;
    }
    super.d(paramLWMotionEvent);
  }
  
  protected void ePD()
  {
    super.ePD();
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setVisibility(8);
    this.c.setVisibility(8);
    this.my.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImPtvBaseButton.getLayoutParams();
    int i = azbx.dip2px(91.0F);
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    localLayoutParams.bottomMargin = azbx.dip2px(32.0F);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setLayoutParams(localLayoutParams);
    ePM();
    anlc.a(this.jdField_a_of_type_DovComQqImPtvBaseButton, 0.0F, 0.0F, 0.0F, 0.0F, 100, 0.0F, 1.0F);
    if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c != null) {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c.ePz();
    }
  }
  
  protected void ePE()
  {
    float f2;
    if ((!this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxN) && (Math.abs(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.xDiff) > LightWeightCaptureButtonLayout.a.eJh))
    {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxN = true;
      if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.xDiff > 0.0F)
      {
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO = true;
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.Fv = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX();
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.eJk = RE();
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.eJl = RF();
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxS = false;
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxT = false;
      }
    }
    else if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxN)
    {
      this.jdField_a_of_type_DovComQqImPtvBaseButton.setTranslationX(this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX() + this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.xDiff);
      f1 = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX();
      f2 = Math.abs(f1);
      if (!this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO) {
        break label504;
      }
      switch (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status)
      {
      }
    }
    label504:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO = false;
            break;
            if (f1 > LightWeightCaptureButtonLayout.a.eJi)
            {
              this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageResource(2130845313);
              this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 1;
              return;
            }
          } while ((f1 >= 0.0F) || (f2 <= LightWeightCaptureButtonLayout.a.eJi));
          this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO = false;
          this.c.setImageResource(2130845331);
          this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 1;
          return;
          if (f1 > LightWeightCaptureButtonLayout.a.eJj)
          {
            this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 2;
            return;
          }
        } while (f1 > LightWeightCaptureButtonLayout.a.eJi);
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 0;
        this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageResource(2130845315);
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxS = true;
        return;
        ePX();
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxU = false;
        return;
        f2 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.eJk;
        l2 = SystemClock.uptimeMillis() - this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.aCE;
        l1 = l2;
        if (l2 >= this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.duration) {
          l1 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.duration;
        }
        f3 = (float)l1 * 1.0F / (float)this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.duration;
        this.jdField_b_of_type_DovComQqImPtvBaseButton.setTranslationX(-(f3 * (f2 - f1)));
        return;
        bC(f1);
        return;
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 6;
        bC(f1);
        return;
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 7;
        ePF();
        return;
        if (f1 <= LightWeightCaptureButtonLayout.a.eJj)
        {
          ePR();
          this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 10;
          return;
        }
        ePF();
        return;
        switch (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status)
        {
        default: 
          return;
        case 0: 
          if ((f1 < 0.0F) && (f2 > LightWeightCaptureButtonLayout.a.eJi))
          {
            this.c.setImageResource(2130845331);
            this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 1;
            return;
          }
          break;
        }
      } while (f1 <= LightWeightCaptureButtonLayout.a.eJi);
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO = true;
      this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageResource(2130845313);
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 1;
      return;
      if ((f1 < 0.0F) && (f2 > LightWeightCaptureButtonLayout.a.eJj))
      {
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 2;
        return;
      }
    } while ((f1 <= 0.0F) && (f2 > LightWeightCaptureButtonLayout.a.eJi));
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 0;
    this.c.setImageResource(2130845332);
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxT = true;
    return;
    ePY();
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxV = false;
    return;
    float f1 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.eJl;
    long l2 = SystemClock.uptimeMillis() - this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.aCE;
    long l1 = l2;
    if (l2 >= this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.duration) {
      l1 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.duration;
    }
    float f3 = (float)l1 * 1.0F / (float)this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.duration;
    this.c.setTranslationX(f3 * (f1 - f2));
    return;
    bB(f2);
    return;
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 6;
    bB(f2);
    return;
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 7;
    ePG();
    return;
    if ((f1 > 0.0F) || (f2 <= LightWeightCaptureButtonLayout.a.eJj))
    {
      eQa();
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 10;
      return;
    }
    ePG();
  }
  
  protected int getLayoutId()
  {
    return 2131561117;
  }
  
  protected void init()
  {
    super.init();
    this.yOffset = azbx.dip2px(5.0F);
    this.my = ((TextView)findViewById(2131376983));
    ePM();
    anlc.a(this.jdField_a_of_type_DovComQqImPtvBaseButton, 0.0F, 0.0F, this.yOffset, 0.0F, 400, 0.0F, 1.0F);
    anlc.a(this.my, 0.0F, 0.0F, this.yOffset, 0.0F, 400, 0.0F, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCaptureButtonHorizontalLayout
 * JD-Core Version:    0.7.0.1
 */