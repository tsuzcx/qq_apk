import android.view.ViewGroup.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.VariableSizeTextView;

public class njl
  implements ValueAnimator.AnimatorUpdateListener
{
  public njl(VariableSizeTextView paramVariableSizeTextView, ViewGroup.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f == this.a.mContentHeight)
    {
      this.a.setFocusable(true);
      this.a.setClickable(true);
    }
    this.b.height = ((int)(f + 0.5F));
    this.a.setLayoutParams(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njl
 * JD-Core Version:    0.7.0.1
 */