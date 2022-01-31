import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew;

public class wkc
  implements ValueAnimator.AnimatorUpdateListener
{
  private View jdField_a_of_type_AndroidViewView;
  
  private wkc(TopPanelViewNew paramTopPanelViewNew, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wkc
 * JD-Core Version:    0.7.0.1
 */