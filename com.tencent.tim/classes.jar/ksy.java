import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentTopGestureLayout;

public class ksy
  implements ValueAnimator.AnimatorUpdateListener
{
  public ksy(ReadInJoyCommentTopGestureLayout paramReadInJoyCommentTopGestureLayout, ViewGroup.LayoutParams paramLayoutParams, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jY.setLayoutParams(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksy
 * JD-Core Version:    0.7.0.1
 */