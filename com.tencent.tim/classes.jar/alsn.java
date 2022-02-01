import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleExplodeView;
import java.util.ArrayList;

public class alsn
  extends AnimatorListenerAdapter
{
  public alsn(ParticleExplodeView paramParticleExplodeView) {}
  
  public void onAnimationEnd(Animator arg1)
  {
    synchronized (this.b.ae)
    {
      this.b.yQ.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alsn
 * JD-Core Version:    0.7.0.1
 */