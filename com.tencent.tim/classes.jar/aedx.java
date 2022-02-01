import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.Point;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.colornote.anim.MusicDanceImageView;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;

public class aedx
  implements Animator.AnimatorListener
{
  public aedx(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (LinearLayout.LayoutParams)ColorNoteSmallScreenRelativeLayout.a(this.this$0).getLayoutParams();
    if (!this.this$0.agr())
    {
      paramAnimator.leftMargin = aqcx.dip2px(this.this$0.getContext(), 14.5F);
      paramAnimator.rightMargin = 0;
    }
    ColorNoteSmallScreenRelativeLayout.a(this.this$0).setLayoutParams(paramAnimator);
    ColorNoteSmallScreenRelativeLayout.a(this.this$0).setVisibility(0);
    ((LinearLayout.LayoutParams)ColorNoteSmallScreenRelativeLayout.a(this.this$0).getLayoutParams()).leftMargin = aqcx.dip2px(this.this$0.getContext(), 13.5F);
    ColorNoteSmallScreenRelativeLayout.a(this.this$0).x = this.this$0.Ci();
    paramAnimator = this.this$0;
    if (ColorNoteSmallScreenRelativeLayout.a(this.this$0).x < 0) {}
    for (int i = 0;; i = 1)
    {
      ColorNoteSmallScreenRelativeLayout.b(paramAnimator, i);
      ColorNoteSmallScreenRelativeLayout.d(this.this$0, false);
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ColorNoteSmallScreenRelativeLayout.d(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedx
 * JD-Core Version:    0.7.0.1
 */