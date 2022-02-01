import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleDropView;

class alsj
  extends AnimatorListenerAdapter
{
  alsj(alsg paramalsg) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (alsg.a(this.this$0) != null) {
      alsg.a(this.this$0).onStop();
    }
    alsg.a(this.this$0, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alsj
 * JD-Core Version:    0.7.0.1
 */