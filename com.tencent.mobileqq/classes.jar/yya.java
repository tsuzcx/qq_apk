import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class yya
{
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final List<Animator> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final yyk jdField_a_of_type_Yyk;
  private boolean jdField_a_of_type_Boolean;
  private final View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private boolean b;
  
  public yya(yyk paramyyk, View... paramVarArgs)
  {
    this.jdField_a_of_type_Yyk = paramyyk;
    this.jdField_a_of_type_ArrayOfAndroidViewView = paramVarArgs;
  }
  
  protected float a(float paramFloat)
  {
    return this.jdField_a_of_type_ArrayOfAndroidViewView[0].getContext().getResources().getDisplayMetrics().density * paramFloat;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ArrayOfAndroidViewView[0];
  }
  
  public Interpolator a()
  {
    return this.jdField_a_of_type_AndroidViewAnimationInterpolator;
  }
  
  protected List<Animator> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public yya a(long paramLong)
  {
    this.jdField_a_of_type_Yyk.a(paramLong);
    return this;
  }
  
  protected yya a(Animator paramAnimator)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramAnimator);
    return this;
  }
  
  public yya a(String paramString, float... paramVarArgs)
  {
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      this.jdField_a_of_type_JavaUtilList.add(ObjectAnimator.ofFloat(localView, paramString, a(paramVarArgs)));
      i += 1;
    }
    return this;
  }
  
  public yya a(yyh paramyyh)
  {
    this.jdField_a_of_type_Yyk.a(paramyyh);
    return this;
  }
  
  public yya a(yyj paramyyj, float... paramVarArgs)
  {
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(a(paramVarArgs));
      if (paramyyj != null) {
        localValueAnimator.addUpdateListener(new yyb(this, paramyyj, localView));
      }
      a(localValueAnimator);
      i += 1;
    }
    return this;
  }
  
  public yya a(float... paramVarArgs)
  {
    return a("translationY", paramVarArgs);
  }
  
  public yya a(View... paramVarArgs)
  {
    return this.jdField_a_of_type_Yyk.b(paramVarArgs);
  }
  
  public yyk a()
  {
    return this.jdField_a_of_type_Yyk.a(new AccelerateInterpolator());
  }
  
  public yyk a(float paramFloat)
  {
    return this.jdField_a_of_type_Yyk.a(new DecelerateInterpolator(paramFloat));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected float[] a(float... paramVarArgs)
  {
    if (!this.b) {
      return paramVarArgs;
    }
    float[] arrayOfFloat = new float[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfFloat[i] = a(paramVarArgs[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public yya b(float... paramVarArgs)
  {
    return a("alpha", paramVarArgs);
  }
  
  public yyk b()
  {
    this.jdField_a_of_type_Yyk.a();
    return this.jdField_a_of_type_Yyk;
  }
  
  public yya c(float... paramVarArgs)
  {
    return a(new yyc(this), paramVarArgs);
  }
  
  public yya d(float... paramVarArgs)
  {
    return a(new yyd(this), paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yya
 * JD-Core Version:    0.7.0.1
 */