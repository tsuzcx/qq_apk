import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;

class vci
  extends AnimatorListenerAdapter
{
  vci(vcb paramvcb) {}
  
  @RequiresApi(api=16)
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    vcb.a(this.a).setAlpha(1.0F);
    vcb.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vci
 * JD-Core Version:    0.7.0.1
 */