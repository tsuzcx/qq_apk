import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;

class ajqx
  extends AnimatorListenerAdapter
{
  ajqx(ajqw paramajqw, URLDrawable paramURLDrawable) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.po.setImageDrawable(this.x);
    ObjectAnimator.ofFloat(this.this$0.po, "alpha", new float[] { 0.1F, 1.0F }).setDuration(1500L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqx
 * JD-Core Version:    0.7.0.1
 */