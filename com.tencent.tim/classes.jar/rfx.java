import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class rfx
  extends AnimatorListenerAdapter
{
  rfx(rft.b paramb) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ram.d("FaceLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ram.d("FaceLayer", "scaleAnimator end!");
    this.b.nJ = 1.0F;
    this.b.aIo = false;
    this.b.a.notifyChange();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ram.d("FaceLayer", "scaleAnimator start!");
    this.b.aIo = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfx
 * JD-Core Version:    0.7.0.1
 */