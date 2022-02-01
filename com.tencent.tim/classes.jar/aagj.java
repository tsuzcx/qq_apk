import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView.a;
import java.util.Iterator;
import java.util.List;

public class aagj
  implements ValueAnimator.AnimatorUpdateListener
{
  public aagj(KSongMicView paramKSongMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = KSongMicView.a(this.b).iterator();
    while (paramValueAnimator.hasNext())
    {
      KSongMicView.a locala = (KSongMicView.a)paramValueAnimator.next();
      locala.alpha = (locala.hc + (locala.hd - locala.hc) * f);
      locala.scaleX = (locala.hf + (locala.hh - locala.hf) * f);
      locala.scaleY = (locala.hg + (locala.hi - locala.hg) * f);
      locala.rotate = (locala.cgA + (int)((locala.cgB - locala.cgA) * f));
    }
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aagj
 * JD-Core Version:    0.7.0.1
 */