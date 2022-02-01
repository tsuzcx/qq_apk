import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr;
import dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr.DragViewIcon;
import dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr.a;

public class ayxq
  extends AnimatorListenerAdapter
{
  public ayxq(DragAnimationMgr paramDragAnimationMgr, DragAnimationMgr.DragViewIcon paramDragViewIcon) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.b.dBM = false;
    DragAnimationMgr.a(this.this$0);
    if (DragAnimationMgr.a(this.this$0) != null) {
      DragAnimationMgr.a(this.this$0).eUk();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.dBM = false;
    DragAnimationMgr.a(this.this$0);
    if (DragAnimationMgr.a(this.this$0) != null) {
      DragAnimationMgr.a(this.this$0).eUk();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayxq
 * JD-Core Version:    0.7.0.1
 */