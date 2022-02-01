package dov.com.qq.im.ptv;

import acfp;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import anlc;
import aqcl;
import ayaj;
import ayas;
import ayat;
import ayau;
import ayav;
import azbx;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LightWeightCaptureButtonCornerLayout
  extends LightWeightCaptureButtonLayout
{
  public LightWeightCaptureButtonCornerLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public LightWeightCaptureButtonCornerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void ePF()
  {
    float f1 = this.jdField_b_of_type_DovComQqImPtvBaseButton.getTranslationY();
    float f2 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.yDiff;
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setTranslationY(f1 + f2);
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
  
  private void ePI()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "alpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "scaleX", new float[] { 1.5F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "scaleY", new float[] { 1.5F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator3);
    localAnimatorSet.setDuration(100L);
    localAnimatorSet.addListener(new ayas(this));
    localAnimatorSet.start();
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.c, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator1.setDuration(100L);
    localObjectAnimator1.start();
    oj(100L);
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvBaseButton, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator1.setDuration(100L);
    localObjectAnimator1.start();
  }
  
  private void ePJ()
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
    localObject2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "translationY", new float[] { this.jdField_b_of_type_DovComQqImPtvBaseButton.getTranslationY(), 0.0F });
    this.Gm.clear();
    this.Gm.add(localObjectAnimator);
    this.Gm.add(localObject2);
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "rollBackDeleteAnimatorToActiveCorner deleteView ScaleX:" + this.jdField_b_of_type_DovComQqImPtvBaseButton.getScaleX() + " ScaleY:" + this.jdField_b_of_type_DovComQqImPtvBaseButton.getScaleY());
    }
    localObject1 = a(this.jdField_b_of_type_DovComQqImPtvBaseButton, 1.5F, 1.533F, 1.533F, 1.0F, (Animator)localObject1, this.Gm, 140L, 50L);
    ((AnimatorSet)localObject1).addListener(new ayat(this));
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
    ((AnimatorSet)localObject1).addListener(new ayau(this));
    ((AnimatorSet)localObject1).start();
    i = getResources().getColor(2131166538);
    localObject1 = ObjectAnimator.ofInt(this.jdField_b_of_type_DovComQqImPtvLightWeightProgress, "deleteColor", new int[] { i, this.jdField_b_of_type_DovComQqImPtvLightWeightProgress.RH() });
    ((ObjectAnimator)localObject1).setStartDelay(90L);
    ((ObjectAnimator)localObject1).setDuration(50L);
    ((ObjectAnimator)localObject1).addListener(new ayav(this));
    ((ObjectAnimator)localObject1).start();
  }
  
  private void ePK()
  {
    ePL();
    anlc.a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView, 0.0F, 0.0F, this.Ft, 0.0F, 400, 0.0F, 1.0F);
    anlc.a(this.jdField_b_of_type_DovComQqImPtvLightWeightProgress, 0.0F, 0.0F, this.Ft, 0.0F, 400, 0.0F, 1.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvBaseButton, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(400L);
    int i = getResources().getColor(2131165517);
    int j = getResources().getColor(2131165516);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { i, j });
    localObjectAnimator2.setEvaluator(ayaj.a());
    localObjectAnimator2.setDuration(400L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvBaseButton, "scaleX", new float[] { 0.42F, 1.0F });
    localObjectAnimator3.setDuration(400L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvBaseButton, "scaleY", new float[] { 0.42F, 1.0F });
    localObjectAnimator4.setDuration(400L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator3);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator4);
    localAnimatorSet.start();
  }
  
  private void ePL()
  {
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setVisibility(0);
    this.c.setVisibility(0);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.c, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(400L);
    Object localObject = ObjectAnimator.ofFloat(this.c, "translationX", new float[] { 0.0F, -this.Fu });
    ((ObjectAnimator)localObject).setDuration(330L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.c, "translationX", new float[] { this.Fs });
    localObjectAnimator2.setDuration(70L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject).before(localObjectAnimator2);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localAnimatorSet);
    ((AnimatorSet)localObject).start();
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(400L);
    localObject = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "translationY", new float[] { 0.0F, -this.Fu });
    ((ObjectAnimator)localObject).setDuration(330L);
    localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "translationY", new float[] { this.Fs });
    localObjectAnimator2.setDuration(70L);
    localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject).before(localObjectAnimator2);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localAnimatorSet);
    ((AnimatorSet)localObject).start();
  }
  
  protected void a(LightWeightCaptureButtonLayout.b paramb, SimpleEffectsCaptureView paramSimpleEffectsCaptureView, LightWeightProgress paramLightWeightProgress)
  {
    super.a(paramb, paramSimpleEffectsCaptureView, paramLightWeightProgress);
    ePK();
  }
  
  protected boolean a(LWMotionEvent paramLWMotionEvent)
  {
    if (super.a(paramLWMotionEvent)) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO)
      {
        ePI();
        return true;
      }
    } while (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status < 2);
    ePH();
    return true;
  }
  
  protected boolean aQb()
  {
    return true;
  }
  
  protected void c(LWMotionEvent paramLWMotionEvent)
  {
    super.c(paramLWMotionEvent);
  }
  
  protected void ePD()
  {
    super.ePD();
    if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c != null) {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c.ePA();
    }
  }
  
  protected void ePE()
  {
    float f1;
    float f2;
    if (!this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxN)
    {
      f1 = Math.abs(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.xDiff);
      f2 = Math.abs(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.yDiff);
      if ((f1 <= LightWeightCaptureButtonLayout.a.eJh) || (f1 <= f2) || (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.xDiff >= 0.0F)) {
        break label245;
      }
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO = false;
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxN = true;
      if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxN)
      {
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxS = false;
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxT = false;
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.eJk = RG();
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.eJl = RF();
      }
    }
    if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxN)
    {
      if (!this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO) {
        break label767;
      }
      f2 = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationY() + this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.yDiff;
      f1 = f2;
      if (f2 > 0.0F) {
        f1 = 0.0F;
      }
      this.jdField_a_of_type_DovComQqImPtvBaseButton.setTranslationY(f1);
      f2 = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationY();
      f1 = Math.abs(f2);
      switch (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status)
      {
      }
    }
    label245:
    label767:
    do
    {
      do
      {
        float f4;
        do
        {
          do
          {
            do
            {
              return;
              if ((f2 <= LightWeightCaptureButtonLayout.a.eJh) || (f2 <= f1) || (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.yDiff >= 0.0F)) {
                break;
              }
              this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO = true;
              this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxN = true;
              break;
              if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxS)
              {
                f3 = Math.abs(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.xDiff);
                f4 = Math.abs(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.yDiff);
                if ((f3 > 6.0F) && (f3 > f4) && (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.xDiff < 0.0F))
                {
                  this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO = false;
                  this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxS = false;
                  return;
                }
                if ((f4 > 6.0F) && (f4 > f3) && (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.yDiff < 0.0F))
                {
                  this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO = true;
                  this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxS = false;
                }
              }
            } while ((f2 > 0.0F) || (f1 <= LightWeightCaptureButtonLayout.a.eJi));
            this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageResource(2130845313);
            this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 1;
            return;
            if ((f2 <= 0.0F) && (f1 > LightWeightCaptureButtonLayout.a.eJj))
            {
              this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 2;
              return;
            }
          } while ((f2 > 0.0F) || (f1 > LightWeightCaptureButtonLayout.a.eJi));
          this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 0;
          this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageResource(2130845315);
          this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxS = true;
          return;
          ePX();
          this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.Fv = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX();
          this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxU = false;
          return;
          f3 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.eJk;
          l2 = SystemClock.uptimeMillis() - this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.aCE;
          l1 = l2;
          if (l2 >= this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.duration) {
            l1 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.duration;
          }
          f2 = (float)l1 * 1.0F / (float)this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.duration;
          this.jdField_b_of_type_DovComQqImPtvBaseButton.setTranslationY(f2 * (f3 - f1));
          f1 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.Fv;
          this.jdField_a_of_type_DovComQqImPtvBaseButton.setTranslationX((1.0F - f2) * f1);
          return;
          if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxU) {
            break label700;
          }
          this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxU = true;
          f2 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.eJk;
          this.jdField_b_of_type_DovComQqImPtvBaseButton.setTranslationY(f2 - f1);
          this.jdField_a_of_type_DovComQqImPtvBaseButton.setTranslationX(0.0F);
        } while (!AppSetting.enableTalkBack);
        aqcl.speak(this.jdField_a_of_type_DovComQqImPtvBaseButton, acfp.m(2131707714));
        return;
        ePF();
        return;
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 6;
        ePF();
        return;
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 7;
        ePF();
        return;
        if ((f2 <= 0.0F) && (f1 <= LightWeightCaptureButtonLayout.a.eJj))
        {
          ePJ();
          this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 10;
          return;
        }
        ePF();
        return;
        f2 = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX() + this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.xDiff;
        f1 = f2;
        if (f2 >= 0.0F) {
          f1 = 0.0F;
        }
        this.jdField_a_of_type_DovComQqImPtvBaseButton.setTranslationX(f1);
        f2 = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX();
        f1 = Math.abs(f2);
        switch (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status)
        {
        default: 
          return;
        case 0: 
          if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxT)
          {
            f3 = Math.abs(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.xDiff);
            f4 = Math.abs(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.yDiff);
            if ((f3 <= 6.0F) || (f3 <= f4) || (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.xDiff >= 0.0F)) {
              break label979;
            }
            this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO = false;
            this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxT = false;
          }
          while ((f4 <= 6.0F) || (f4 <= f3) || (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.yDiff >= 0.0F))
          {
            if ((f2 > 0.0F) || (f1 <= LightWeightCaptureButtonLayout.a.eJi)) {
              break;
            }
            this.c.setImageResource(2130845331);
            this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 1;
            return;
          }
          this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO = true;
          this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxT = false;
          return;
        case 1: 
          if ((f2 <= 0.0F) && (f1 > LightWeightCaptureButtonLayout.a.eJj))
          {
            this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 2;
            return;
          }
          break;
        }
      } while ((f2 > 0.0F) || (f1 > LightWeightCaptureButtonLayout.a.eJi));
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 0;
      this.c.setImageResource(2130845332);
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxT = true;
      return;
      ePY();
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.Fw = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationY();
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxV = false;
      return;
      float f3 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.eJl;
      long l2 = SystemClock.uptimeMillis() - this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.aCE;
      long l1 = l2;
      if (l2 >= this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.duration) {
        l1 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.duration;
      }
      f2 = (float)l1 * 1.0F / (float)this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.duration;
      this.c.setTranslationX(f2 * (f3 - f1));
      f1 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.Fw;
      this.jdField_a_of_type_DovComQqImPtvBaseButton.setTranslationY((1.0F - f2) * f1);
      return;
      if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxV) {
        break label1279;
      }
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxV = true;
      f2 = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.eJl;
      this.c.setTranslationX(f2 - f1);
      this.jdField_a_of_type_DovComQqImPtvBaseButton.setTranslationY(0.0F);
    } while (!AppSetting.enableTalkBack);
    label700:
    label979:
    aqcl.speak(this.jdField_a_of_type_DovComQqImPtvBaseButton, acfp.m(2131707728));
    return;
    label1279:
    ePG();
    return;
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 6;
    ePG();
    return;
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 7;
    ePG();
    return;
    if ((f2 <= 0.0F) && (f1 <= LightWeightCaptureButtonLayout.a.eJj))
    {
      eQa();
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 10;
      return;
    }
    ePG();
  }
  
  protected int getLayoutId()
  {
    return 2131561116;
  }
  
  protected void init()
  {
    super.init();
    this.dxH = true;
    this.dxI = false;
    int i = getResources().getColor(2131165516);
    int j = getResources().getColor(2131165523);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowStrokeMaxWidth(azbx.dip2px(30.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setBackgroundColor(i);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowColor(j);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageWidth(azbx.dip2px(40.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageHeight(azbx.dip2px(40.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageResource(2130845325);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCaptureButtonCornerLayout
 * JD-Core Version:    0.7.0.1
 */