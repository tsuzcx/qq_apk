import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xfc
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 3000L;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private View jdField_a_of_type_AndroidViewView;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private List<xes> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xex jdField_a_of_type_Xex;
  private xey jdField_a_of_type_Xey;
  private xez jdField_a_of_type_Xez;
  private xfa jdField_a_of_type_Xfa;
  private xfc jdField_a_of_type_Xfc;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private xfc jdField_b_of_type_Xfc;
  
  public static xes a(View... paramVarArgs)
  {
    return new xfc().b(paramVarArgs);
  }
  
  protected AnimatorSet a()
  {
    this.jdField_a_of_type_Boolean = false;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (xes)((Iterator)localObject1).next();
      List localList = ((xes)localObject2).a();
      if (((xes)localObject2).a() != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          ((Animator)localIterator.next()).setInterpolator(((xes)localObject2).a());
        }
      }
      localArrayList.addAll(localList);
    }
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (xes)((Iterator)localObject1).next();
      if (((xes)localObject2).a()) {
        this.jdField_a_of_type_AndroidViewView = ((xes)localObject2).a();
      }
    }
    localObject1 = localArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Animator)((Iterator)localObject1).next();
      if ((localObject2 instanceof ValueAnimator))
      {
        localObject2 = (ValueAnimator)localObject2;
        ((ValueAnimator)localObject2).setRepeatCount(this.jdField_a_of_type_Int);
        ((ValueAnimator)localObject2).setRepeatMode(this.jdField_b_of_type_Int);
        if (!this.jdField_a_of_type_Boolean)
        {
          ((ValueAnimator)localObject2).addListener(new xfd(this));
          this.jdField_a_of_type_Boolean = true;
        }
      }
    }
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).playTogether(localArrayList);
    ((AnimatorSet)localObject1).setDuration(this.jdField_a_of_type_Long);
    ((AnimatorSet)localObject1).setStartDelay(this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_AndroidViewAnimationInterpolator != null) {
      ((AnimatorSet)localObject1).setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
    }
    ((AnimatorSet)localObject1).addListener(new xfe(this));
    return localObject1;
  }
  
  public xfc a()
  {
    if (this.jdField_a_of_type_Xfc != null)
    {
      this.jdField_a_of_type_Xfc.a();
      return this;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = a();
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnPreDrawListener(new xff(this));
      return this;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    return this;
  }
  
  public xfc a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public xfc a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    return this;
  }
  
  public xfc a(xez paramxez)
  {
    this.jdField_a_of_type_Xez = paramxez;
    return this;
  }
  
  public xfc a(xfa paramxfa)
  {
    this.jdField_a_of_type_Xfa = paramxfa;
    return this;
  }
  
  public xes b(View... paramVarArgs)
  {
    paramVarArgs = new xes(this, paramVarArgs);
    this.jdField_a_of_type_JavaUtilList.add(paramVarArgs);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xfc
 * JD-Core Version:    0.7.0.1
 */