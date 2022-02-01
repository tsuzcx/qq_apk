import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView.a;
import java.util.Iterator;
import java.util.List;

public class aagk
  implements ValueAnimator.AnimatorUpdateListener
{
  public aagk(RecordMicView paramRecordMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = RecordMicView.a(this.this$0).iterator();
    while (paramValueAnimator.hasNext())
    {
      RecordMicView.a locala = (RecordMicView.a)paramValueAnimator.next();
      locala.alpha = (locala.hc + (locala.hd - locala.hc) * f);
      locala.scaleX = (locala.hf + (locala.hh - locala.hf) * f);
      locala.scaleY = (locala.hg + (locala.hi - locala.hg) * f);
      locala.rotate = (locala.cgA + (int)((locala.cgB - locala.cgA) * f));
    }
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aagk
 * JD-Core Version:    0.7.0.1
 */