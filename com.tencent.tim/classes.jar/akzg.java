import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;

class akzg
  implements Animator.AnimatorListener
{
  akzg(akze paramakze, View paramView1, View paramView2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = (RelativeLayout.LayoutParams)this.Bg.getLayoutParams();
    paramAnimator.topMargin = (-akze.a(this.this$0));
    this.Bg.setLayoutParams(paramAnimator);
    if (this.this$0.bQO)
    {
      this.Bh.setAlpha(0.0F);
      this.Bh.setVisibility(8);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (RelativeLayout.LayoutParams)this.Bg.getLayoutParams();
    paramAnimator.topMargin = (-akze.a(this.this$0));
    this.Bg.setLayoutParams(paramAnimator);
    if (this.this$0.bQO)
    {
      this.Bh.setAlpha(0.0F);
      this.Bh.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (!this.this$0.bQO) {
      this.Bh.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzg
 * JD-Core Version:    0.7.0.1
 */