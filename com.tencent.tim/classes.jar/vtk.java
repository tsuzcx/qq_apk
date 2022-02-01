import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;

public class vtk
  implements ValueAnimator.AnimatorUpdateListener
{
  public vtk(SelectedAndSearchBar paramSelectedAndSearchBar, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.v.topMargin = i;
    SelectedAndSearchBar.a(this.this$0).setLayoutParams(this.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vtk
 * JD-Core Version:    0.7.0.1
 */