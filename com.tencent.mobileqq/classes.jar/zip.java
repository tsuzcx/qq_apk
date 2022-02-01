import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class zip
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, ziq
{
  protected final float a;
  protected final Interpolator a;
  protected final zio a;
  protected final ziw a;
  protected final float b;
  
  public zip(ziw paramziw, float paramFloat)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
    this.jdField_a_of_type_Ziw = paramziw;
    this.jdField_a_of_type_Float = paramFloat;
    this.b = (2.0F * paramFloat);
    this.jdField_a_of_type_Zio = new zio();
  }
  
  protected Animator a()
  {
    float f1 = 0.0F;
    Object localObject1 = this.jdField_a_of_type_Ziw.a();
    Object localObject2 = this.jdField_a_of_type_Ziw.jdField_a_of_type_Zir;
    Object localObject3 = this.jdField_a_of_type_Ziw.jdField_a_of_type_Ziv;
    float f3 = this.jdField_a_of_type_Ziw.jdField_a_of_type_Float;
    ((zir)localObject2).a((View)localObject1, this.jdField_a_of_type_Zio);
    if ((f3 == 0.0F) || ((f3 < 0.0F) && (((ziv)localObject3).jdField_a_of_type_Boolean)) || ((f3 > 0.0F) && (!((ziv)localObject3).jdField_a_of_type_Boolean))) {
      return a(this.jdField_a_of_type_Zio.jdField_a_of_type_Float);
    }
    float f2 = -f3 / this.jdField_a_of_type_Float;
    if (f2 < 0.0F) {}
    for (;;)
    {
      f2 = -f3 * f3 / this.b + this.jdField_a_of_type_Zio.jdField_a_of_type_Float;
      localObject1 = a((View)localObject1, (int)f1, f2);
      localObject2 = a(f2);
      localObject3 = new AnimatorSet();
      ((AnimatorSet)localObject3).playSequentially(new Animator[] { localObject1, localObject2 });
      return localObject3;
      f1 = f2;
    }
  }
  
  protected ObjectAnimator a(float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_Ziw.a();
    ziv localziv = this.jdField_a_of_type_Ziw.jdField_a_of_type_Ziv;
    paramFloat = Math.abs(paramFloat) / this.jdField_a_of_type_Zio.b;
    localObject = ObjectAnimator.ofFloat(localObject, this.jdField_a_of_type_Zio.jdField_a_of_type_AndroidUtilProperty, new float[] { localziv.jdField_a_of_type_Float });
    ((ObjectAnimator)localObject).setDuration(Math.max((int)(paramFloat * 800.0F), 200));
    ((ObjectAnimator)localObject).setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
    ((ObjectAnimator)localObject).addUpdateListener(this);
    return localObject;
  }
  
  protected ObjectAnimator a(View paramView, int paramInt, float paramFloat)
  {
    paramView = ObjectAnimator.ofFloat(paramView, this.jdField_a_of_type_Zio.jdField_a_of_type_AndroidUtilProperty, new float[] { paramFloat });
    paramView.setDuration(paramInt);
    paramView.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
    paramView.addUpdateListener(this);
    return paramView;
  }
  
  public void a(ziq paramziq)
  {
    paramziq = a();
    paramziq.addListener(this);
    paramziq.start();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_Ziw.a(this.jdField_a_of_type_Ziw.jdField_a_of_type_Zis);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zip
 * JD-Core Version:    0.7.0.1
 */