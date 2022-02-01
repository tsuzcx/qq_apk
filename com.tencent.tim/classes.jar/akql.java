import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class akql
  extends AnimatorListenerAdapter
{
  akql(akqe paramakqe) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (akqe.a(this.c) != null) {
      akqe.a(this.c).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akql
 * JD-Core Version:    0.7.0.1
 */