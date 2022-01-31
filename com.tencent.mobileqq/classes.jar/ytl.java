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

public class ytl
{
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final List<Animator> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final ytv jdField_a_of_type_Ytv;
  private boolean jdField_a_of_type_Boolean;
  private final View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private boolean b;
  
  public ytl(ytv paramytv, View... paramVarArgs)
  {
    this.jdField_a_of_type_Ytv = paramytv;
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
  
  public ytl a(long paramLong)
  {
    this.jdField_a_of_type_Ytv.a(paramLong);
    return this;
  }
  
  protected ytl a(Animator paramAnimator)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramAnimator);
    return this;
  }
  
  public ytl a(String paramString, float... paramVarArgs)
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
  
  public ytl a(yts paramyts)
  {
    this.jdField_a_of_type_Ytv.a(paramyts);
    return this;
  }
  
  public ytl a(ytu paramytu, float... paramVarArgs)
  {
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(a(paramVarArgs));
      if (paramytu != null) {
        localValueAnimator.addUpdateListener(new ytm(this, paramytu, localView));
      }
      a(localValueAnimator);
      i += 1;
    }
    return this;
  }
  
  public ytl a(float... paramVarArgs)
  {
    return a("translationY", paramVarArgs);
  }
  
  public ytl a(View... paramVarArgs)
  {
    return this.jdField_a_of_type_Ytv.b(paramVarArgs);
  }
  
  public ytv a()
  {
    return this.jdField_a_of_type_Ytv.a(new AccelerateInterpolator());
  }
  
  public ytv a(float paramFloat)
  {
    return this.jdField_a_of_type_Ytv.a(new DecelerateInterpolator(paramFloat));
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
  
  public ytl b(float... paramVarArgs)
  {
    return a("alpha", paramVarArgs);
  }
  
  public ytv b()
  {
    this.jdField_a_of_type_Ytv.a();
    return this.jdField_a_of_type_Ytv;
  }
  
  public ytl c(float... paramVarArgs)
  {
    return a(new ytn(this), paramVarArgs);
  }
  
  public ytl d(float... paramVarArgs)
  {
    return a(new yto(this), paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ytl
 * JD-Core Version:    0.7.0.1
 */