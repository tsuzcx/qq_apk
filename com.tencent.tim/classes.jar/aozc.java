import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import com.tencent.mobileqq.widget.TabBarView2;

public class aozc
  implements ValueAnimator.AnimatorUpdateListener
{
  public aozc(NewTroopCreateActivity paramNewTroopCreateActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = (RelativeLayout.LayoutParams)this.b.b.getLayoutParams();
    paramValueAnimator.topMargin = i;
    this.b.b.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aozc
 * JD-Core Version:    0.7.0.1
 */