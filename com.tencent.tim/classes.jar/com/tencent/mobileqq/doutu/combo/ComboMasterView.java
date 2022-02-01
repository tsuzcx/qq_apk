package com.tencent.mobileqq.doutu.combo;

import afec;
import afed;
import afee;
import afee.a;
import afef;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import wja;

@TargetApi(14)
public class ComboMasterView
  extends LinearLayout
  implements Animator.AnimatorListener
{
  public afed a;
  afee.a jdField_a_of_type_Afee$a;
  private afef jdField_a_of_type_Afef;
  AnimatorSet am;
  boolean bXH = true;
  boolean canceled = false;
  private int mCount;
  private ImageView yA;
  private ImageView yB;
  private ImageView yC;
  
  public ComboMasterView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComboMasterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private PathMeasure a()
  {
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = getContext().getResources().getDisplayMetrics().heightPixels;
    try
    {
      f2 = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      f1 = f2;
      if (QLog.isColorLevel())
      {
        QLog.d("ComboMasterView", 2, "get status_bar_height " + f2);
        f1 = f2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        Path localPath;
        float f1 = (int)(getContext().getResources().getDisplayMetrics().density * 25.0F + 0.5D);
      }
    }
    f1 = f1 + wja.dp2px(54.0F, getContext().getResources()) + getContext().getResources().getDimension(2131299627);
    f2 = i - wja.dp2px(40.0F, getContext().getResources());
    f3 = i / 2.0F;
    f4 = j / 2.0F;
    f5 = f2 - f3;
    f6 = f1 - f4;
    f7 = (f5 - 0.0F) * 1.0F / 14.0F + 0.0F;
    f8 = (0.0F - f6) * 1.0F / 13.0F + f6;
    localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.quadTo(f7, f8, f5, f6);
    if (QLog.isColorLevel()) {
      QLog.d("ComboMasterView", 2, "mCount " + this.mCount + " startX: " + f3 + " startY:" + f4 + " toX:" + f2 + " toY: " + f1 + " middleX:" + f7 + " middleY: " + f8);
    }
    return new PathMeasure(localPath, false);
  }
  
  private Drawable a(View paramView, afee.a parama)
  {
    paramView = paramView.getLayoutParams();
    paramView.width = parama.width;
    paramView.height = parama.height;
    return parama.drawable;
  }
  
  private boolean a(ImageView paramImageView, int paramInt)
  {
    afee.a locala = afee.b(paramInt);
    if (locala == null)
    {
      this.bXH = false;
      return false;
    }
    paramImageView.setImageDrawable(a(paramImageView, locala));
    return true;
  }
  
  private boolean jh(int paramInt)
  {
    afee.a locala = afee.c(paramInt);
    if (locala == null)
    {
      this.bXH = false;
      return false;
    }
    this.jdField_a_of_type_Afee$a = locala;
    return true;
  }
  
  public void M(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      paramViewGroup.removeView(this);
      this.canceled = true;
      this.am.cancel();
    }
  }
  
  public void a(afef paramafef)
  {
    this.yA = ((ImageView)findViewById(2131362386));
    this.yB = ((ImageView)findViewById(2131362387));
    this.yC = ((ImageView)findViewById(2131362388));
    this.jdField_a_of_type_Afef = paramafef;
  }
  
  public boolean b(afed paramafed)
  {
    this.jdField_a_of_type_Afed = paramafed;
    int k = this.jdField_a_of_type_Afed.cQE;
    int j = k / 10;
    int i;
    if (j != 0)
    {
      i = j % 10;
      j /= 10;
    }
    for (;;)
    {
      if (j != 0) {
        j %= 100;
      }
      for (;;)
      {
        this.yC.setVisibility(0);
        a(this.yC, k % 10);
        if (j == 0) {
          if (i == 0)
          {
            this.yB.setVisibility(8);
            this.yA.setVisibility(8);
            jh(1);
          }
        }
        for (;;)
        {
          setPadding(wja.dp2px(162.0F / afee.vW, getContext().getResources()), 0, 0, 0);
          ((LinearLayout.LayoutParams)this.yA.getLayoutParams()).setMargins(0, 0, 0 - wja.dp2px(20.0F / afee.vW, getContext().getResources()), 0);
          ((LinearLayout.LayoutParams)this.yB.getLayoutParams()).setMargins(0, 0, 0 - wja.dp2px(20.0F / afee.vW, getContext().getResources()), 0);
          this.mCount = k;
          return this.bXH;
          this.yB.setVisibility(0);
          this.yA.setVisibility(8);
          a(this.yB, i);
          jh(2);
          continue;
          this.yB.setVisibility(0);
          this.yA.setVisibility(0);
          a(this.yB, i);
          a(this.yA, j);
          jh(3);
        }
        j = 0;
      }
      i = 0;
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Afef != null) && (this.am != null))
    {
      if (!this.canceled) {
        this.jdField_a_of_type_Afef.a(paramAnimator, this);
      }
      paramAnimator.removeAllListeners();
      this.jdField_a_of_type_Afef = null;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void pI()
  {
    setBackgroundDrawable(a(this, this.jdField_a_of_type_Afee$a));
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { 0.0F, 1.1F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { 0.0F, 1.1F });
    localObjectAnimator1.setDuration(200L);
    localObjectAnimator2.setDuration(200L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.1F, 1.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.1F, 1.0F });
    localObjectAnimator3.setDuration(200L);
    localObjectAnimator4.setDuration(200L);
    Object localObject = a();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, ((PathMeasure)localObject).getLength() });
    localValueAnimator.addUpdateListener(new afec(this, (PathMeasure)localObject, new float[2]));
    localValueAnimator.setDuration(400L);
    localObject = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.0F, 0.27F });
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.0F, 0.27F });
    ((ValueAnimator)localObject).setDuration(400L);
    localObjectAnimator5.setDuration(400L);
    localObjectAnimator6.setDuration(400L);
    this.am = new AnimatorSet();
    this.am.play(localObjectAnimator1).with(localObjectAnimator2).before(localObjectAnimator3);
    this.am.play(localObjectAnimator3).with(localObjectAnimator4);
    localValueAnimator.setStartDelay(600L);
    ((ValueAnimator)localObject).setStartDelay(600L);
    localObjectAnimator5.setStartDelay(600L);
    localObjectAnimator6.setStartDelay(600L);
    this.am.play(localValueAnimator);
    this.am.play((Animator)localObject);
    this.am.play(localObjectAnimator5);
    this.am.play(localObjectAnimator6);
    this.am.addListener(this);
    this.am.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboMasterView
 * JD-Core Version:    0.7.0.1
 */