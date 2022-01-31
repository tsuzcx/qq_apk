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

public class xes
{
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final List<Animator> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final xfc jdField_a_of_type_Xfc;
  private boolean jdField_a_of_type_Boolean;
  private final View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private boolean b;
  
  public xes(xfc paramxfc, View... paramVarArgs)
  {
    this.jdField_a_of_type_Xfc = paramxfc;
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
  
  public xes a(long paramLong)
  {
    this.jdField_a_of_type_Xfc.a(paramLong);
    return this;
  }
  
  protected xes a(Animator paramAnimator)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramAnimator);
    return this;
  }
  
  public xes a(String paramString, float... paramVarArgs)
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
  
  public xes a(xez paramxez)
  {
    this.jdField_a_of_type_Xfc.a(paramxez);
    return this;
  }
  
  public xes a(xfb paramxfb, float... paramVarArgs)
  {
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(a(paramVarArgs));
      if (paramxfb != null) {
        localValueAnimator.addUpdateListener(new xet(this, paramxfb, localView));
      }
      a(localValueAnimator);
      i += 1;
    }
    return this;
  }
  
  public xes a(float... paramVarArgs)
  {
    return a("translationY", paramVarArgs);
  }
  
  public xes a(View... paramVarArgs)
  {
    return this.jdField_a_of_type_Xfc.b(paramVarArgs);
  }
  
  public xfc a()
  {
    return this.jdField_a_of_type_Xfc.a(new AccelerateInterpolator());
  }
  
  public xfc a(float paramFloat)
  {
    return this.jdField_a_of_type_Xfc.a(new DecelerateInterpolator(paramFloat));
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
  
  public xes b(float... paramVarArgs)
  {
    return a("alpha", paramVarArgs);
  }
  
  public xfc b()
  {
    this.jdField_a_of_type_Xfc.a();
    return this.jdField_a_of_type_Xfc;
  }
  
  public xes c(float... paramVarArgs)
  {
    return a(new xeu(this), paramVarArgs);
  }
  
  public xes d(float... paramVarArgs)
  {
    return a(new xev(this), paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xes
 * JD-Core Version:    0.7.0.1
 */