import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;

public class aysv
  implements ValueAnimator.AnimatorUpdateListener
{
  public aysv(PickerContainer paramPickerContainer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.this$0.setAlpha(PickerContainer.b(this.this$0).floatValue());
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysv
 * JD-Core Version:    0.7.0.1
 */