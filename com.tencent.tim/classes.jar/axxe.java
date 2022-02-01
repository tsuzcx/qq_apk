import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;

public final class axxe
{
  private static final Interpolator r = new LinearInterpolator();
  private final axxe.b a;
  private ValueAnimator aa;
  private final View mTarget;
  
  public axxe(View paramView)
  {
    this.mTarget = paramView;
    this.a = new axxe.b(paramView);
  }
  
  public static void a(View paramView, long paramLong, View.OnClickListener paramOnClickListener)
  {
    if (paramView == null) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.75F, 0.5F, 0.75F, 1.0F });
    paramView = new axxe.a(paramView, paramOnClickListener);
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.setInterpolator(r);
    localValueAnimator.addUpdateListener(paramView);
    localValueAnimator.addListener(paramView);
    localValueAnimator.start();
  }
  
  public static void a(View paramView, long paramLong, View.OnClickListener paramOnClickListener, float... paramVarArgs)
  {
    if (paramView == null) {
      return;
    }
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramView = new axxe.a(paramView, paramOnClickListener);
    paramVarArgs.setDuration(paramLong);
    paramVarArgs.setInterpolator(r);
    paramVarArgs.addUpdateListener(paramView);
    paramVarArgs.addListener(paramView);
    paramVarArgs.start();
  }
  
  public boolean aPU()
  {
    return this.a.mScale != 1.0F;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.mTarget.getPaddingLeft();
    int j = this.mTarget.getRight() - this.mTarget.getLeft() - this.mTarget.getPaddingRight();
    int m = this.mTarget.getPaddingTop();
    int n = this.mTarget.getBottom();
    int i1 = this.mTarget.getTop();
    int i2 = this.mTarget.getPaddingBottom();
    int k = (i + j) / 2;
    m = (m + (n - i1 - i2)) / 2;
    paramCanvas.scale(this.a.mScale, this.a.mScale, k, m);
    if (QLog.isColorLevel()) {
      QLog.d("PressScaleAnimDelegate ", 2, "draw, left=" + i + ",right=" + j + ",centerX=" + k + ",centerY=" + m + ",scale=" + this.a.mScale);
    }
  }
  
  public void ejg()
  {
    if (this.aa != null)
    {
      this.aa.cancel();
      this.aa.removeUpdateListener(this.a);
    }
    this.aa = ValueAnimator.ofFloat(new float[] { 1.0F, 0.75F, 0.5F, 0.75F, 1.0F });
    this.aa.setDuration(200L);
    this.aa.setInterpolator(r);
    this.aa.addUpdateListener(this.a);
    this.aa.start();
  }
  
  static final class a
    implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
  {
    final View.OnClickListener mListener;
    final View mTarget;
    
    a(View paramView, View.OnClickListener paramOnClickListener)
    {
      this.mTarget = paramView;
      this.mListener = paramOnClickListener;
    }
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (this.mListener != null) {
        this.mListener.onClick(this.mTarget);
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      this.mTarget.setScaleX(f);
      this.mTarget.setScaleY(f);
    }
  }
  
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    float mScale = 1.0F;
    final View mTarget;
    
    b(View paramView)
    {
      this.mTarget = paramView;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      this.mScale = f;
      this.mTarget.invalidate();
      if (QLog.isColorLevel()) {
        QLog.d("PressScaleAnimDelegate ", 2, "do scale animtion, scale=" + f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxe
 * JD-Core Version:    0.7.0.1
 */