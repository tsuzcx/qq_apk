import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.qqstory.widget.circularreveal.CircularRevealCompatLayout;

public class zjh
  extends ValueAnimator
{
  private ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener;
  private View jdField_a_of_type_AndroidViewView;
  
  private zjh(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    setObjectValues(new Object[] { new zjk(paramFloat1, paramFloat2, paramFloat3), new zjk(paramFloat4, paramFloat5, paramFloat6) });
    setEvaluator(new zjl(null));
    this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new zji(this, a(paramView));
    addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
  }
  
  private CircularRevealCompatLayout a(View paramView)
  {
    if ((paramView instanceof CircularRevealCompatLayout)) {
      return (CircularRevealCompatLayout)paramView;
    }
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if ((localViewGroup instanceof CircularRevealCompatLayout)) {
      return (CircularRevealCompatLayout)localViewGroup;
    }
    CircularRevealCompatLayout localCircularRevealCompatLayout = new CircularRevealCompatLayout(paramView.getContext());
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeView(paramView);
    localCircularRevealCompatLayout.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
    localViewGroup.addView(localCircularRevealCompatLayout, i, localLayoutParams);
    return localCircularRevealCompatLayout;
  }
  
  public static zjh a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    return new zjh(paramView, paramInt1, paramInt2, paramFloat1, paramInt1, paramInt2, paramFloat2);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getParent();
    if ((localObject instanceof CircularRevealCompatLayout))
    {
      localObject = (CircularRevealCompatLayout)localObject;
      ((CircularRevealCompatLayout)localObject).removeView(this.jdField_a_of_type_AndroidViewView);
      ViewGroup localViewGroup = (ViewGroup)((CircularRevealCompatLayout)localObject).getParent();
      ViewGroup.LayoutParams localLayoutParams = ((CircularRevealCompatLayout)localObject).getLayoutParams();
      int i = localViewGroup.indexOfChild((View)localObject);
      localViewGroup.removeView((View)localObject);
      localViewGroup.addView(this.jdField_a_of_type_AndroidViewView, i, localLayoutParams);
    }
  }
  
  public void removeAllUpdateListeners()
  {
    super.removeAllUpdateListeners();
    addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjh
 * JD-Core Version:    0.7.0.1
 */