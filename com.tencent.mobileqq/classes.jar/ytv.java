import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ytv
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 3000L;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private View jdField_a_of_type_AndroidViewView;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private List<ytl> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ytq jdField_a_of_type_Ytq;
  private ytr jdField_a_of_type_Ytr;
  private yts jdField_a_of_type_Yts;
  private ytt jdField_a_of_type_Ytt;
  private ytv jdField_a_of_type_Ytv;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private ytv jdField_b_of_type_Ytv;
  
  public static ytl a(View... paramVarArgs)
  {
    return new ytv().b(paramVarArgs);
  }
  
  protected AnimatorSet a()
  {
    this.jdField_a_of_type_Boolean = false;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ytl)((Iterator)localObject1).next();
      List localList = ((ytl)localObject2).a();
      if (((ytl)localObject2).a() != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          ((Animator)localIterator.next()).setInterpolator(((ytl)localObject2).a());
        }
      }
      localArrayList.addAll(localList);
    }
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ytl)((Iterator)localObject1).next();
      if (((ytl)localObject2).a()) {
        this.jdField_a_of_type_AndroidViewView = ((ytl)localObject2).a();
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
          ((ValueAnimator)localObject2).addListener(new ytw(this));
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
    ((AnimatorSet)localObject1).addListener(new ytx(this));
    return localObject1;
  }
  
  public ytv a()
  {
    if (this.jdField_a_of_type_Ytv != null)
    {
      this.jdField_a_of_type_Ytv.a();
      return this;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = a();
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnPreDrawListener(new yty(this));
      return this;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    return this;
  }
  
  public ytv a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public ytv a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    return this;
  }
  
  public ytv a(yts paramyts)
  {
    this.jdField_a_of_type_Yts = paramyts;
    return this;
  }
  
  public ytv a(ytt paramytt)
  {
    this.jdField_a_of_type_Ytt = paramytt;
    return this;
  }
  
  public ytl b(View... paramVarArgs)
  {
    paramVarArgs = new ytl(this, paramVarArgs);
    this.jdField_a_of_type_JavaUtilList.add(paramVarArgs);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ytv
 * JD-Core Version:    0.7.0.1
 */