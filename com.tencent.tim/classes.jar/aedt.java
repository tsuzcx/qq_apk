import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;
import java.util.Iterator;
import java.util.List;

public class aedt
  implements Animator.AnimatorListener
{
  public aedt(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, LinearLayout paramLinearLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ColorNoteSmallScreenRelativeLayout.c(this.this$0, false);
    paramAnimator = ColorNoteSmallScreenRelativeLayout.a(this.this$0).iterator();
    while (paramAnimator.hasNext()) {
      ((ColorNote)paramAnimator.next()).animate = false;
    }
    this.this$0.cVZ();
    this.iB.animate().setListener(null).translationX(0.0F).setDuration(200L).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedt
 * JD-Core Version:    0.7.0.1
 */