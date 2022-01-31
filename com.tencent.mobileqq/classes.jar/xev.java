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

public class xev
{
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final List<Animator> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final xff jdField_a_of_type_Xff;
  private boolean jdField_a_of_type_Boolean;
  private final View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private boolean b;
  
  public xev(xff paramxff, View... paramVarArgs)
  {
    this.jdField_a_of_type_Xff = paramxff;
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
  
  public xev a(long paramLong)
  {
    this.jdField_a_of_type_Xff.a(paramLong);
    return this;
  }
  
  protected xev a(Animator paramAnimator)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramAnimator);
    return this;
  }
  
  public xev a(String paramString, float... paramVarArgs)
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
  
  public xev a(xfc paramxfc)
  {
    this.jdField_a_of_type_Xff.a(paramxfc);
    return this;
  }
  
  public xev a(xfe paramxfe, float... paramVarArgs)
  {
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(a(paramVarArgs));
      if (paramxfe != null) {
        localValueAnimator.addUpdateListener(new xew(this, paramxfe, localView));
      }
      a(localValueAnimator);
      i += 1;
    }
    return this;
  }
  
  public xev a(float... paramVarArgs)
  {
    return a("translationY", paramVarArgs);
  }
  
  public xev a(View... paramVarArgs)
  {
    return this.jdField_a_of_type_Xff.b(paramVarArgs);
  }
  
  public xff a()
  {
    return this.jdField_a_of_type_Xff.a(new AccelerateInterpolator());
  }
  
  public xff a(float paramFloat)
  {
    return this.jdField_a_of_type_Xff.a(new DecelerateInterpolator(paramFloat));
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
  
  public xev b(float... paramVarArgs)
  {
    return a("alpha", paramVarArgs);
  }
  
  public xff b()
  {
    this.jdField_a_of_type_Xff.a();
    return this.jdField_a_of_type_Xff;
  }
  
  public xev c(float... paramVarArgs)
  {
    return a(new xex(this), paramVarArgs);
  }
  
  public xev d(float... paramVarArgs)
  {
    return a(new xey(this), paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xev
 * JD-Core Version:    0.7.0.1
 */