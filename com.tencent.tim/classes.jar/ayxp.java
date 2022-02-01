import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr;
import dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr.DragViewIcon;

public class ayxp
  extends AnimatorListenerAdapter
{
  public ayxp(DragAnimationMgr paramDragAnimationMgr) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    int i = DragAnimationMgr.a(this.this$0).getOffset();
    DragAnimationMgr.a(this.this$0, DragAnimationMgr.a(this.this$0), i);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i = DragAnimationMgr.a(this.this$0).getOffset();
    DragAnimationMgr.a(this.this$0, DragAnimationMgr.a(this.this$0), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayxp
 * JD-Core Version:    0.7.0.1
 */