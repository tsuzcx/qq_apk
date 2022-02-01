import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;

public class aysw
  implements Animator.AnimatorListener
{
  public aysw(PickerContainer paramPickerContainer) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (PickerContainer.a(this.this$0))
    {
      if (PickerContainer.b(this.this$0).floatValue() < 0.01F) {
        this.this$0.setVisibility(4);
      }
      PickerContainer.a(this.this$0, false);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (PickerContainer.a(this.this$0))
    {
      if (PickerContainer.b(this.this$0).floatValue() < 0.01F) {
        this.this$0.setVisibility(4);
      }
      PickerContainer.a(this.this$0, false);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysw
 * JD-Core Version:    0.7.0.1
 */