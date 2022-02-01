import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerFrameLayout;

class afqn
  implements Animator.AnimatorListener
{
  afqn(afqm paramafqm) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.this$0.b != null)
    {
      float f = this.this$0.b.getTranslationX();
      this.this$0.b.setTranslationX(0.0F);
      this.this$0.P((int)(this.this$0.b.getLeft() + f), this.this$0.b.getTop(), (int)(f + this.this$0.b.getLeft() + this.this$0.b.getWidth()), this.this$0.b.getBottom());
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqn
 * JD-Core Version:    0.7.0.1
 */