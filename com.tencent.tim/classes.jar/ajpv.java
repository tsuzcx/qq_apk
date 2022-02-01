import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

class ajpv
  extends AnimatorListenerAdapter
{
  ajpv(ajpu paramajpu, ajpu.b paramb, URLDrawable paramURLDrawable) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.this$0.a() != null)
    {
      this.a.bp.setImageDrawable(this.x);
      paramAnimator = ObjectAnimator.ofFloat(this.a.bp, "alpha", new float[] { 0.2F, 1.0F });
      paramAnimator.setInterpolator(new DecelerateInterpolator());
      paramAnimator.setDuration(300L).start();
      return;
    }
    this.a.bp.setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajpv
 * JD-Core Version:    0.7.0.1
 */