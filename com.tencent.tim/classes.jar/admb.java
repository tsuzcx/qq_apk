import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.ar.view.QRScanEntryView;

public class admb
  extends AnimatorListenerAdapter
{
  public admb(QRScanEntryView paramQRScanEntryView, View paramView, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.val$targetView != null)
    {
      this.val$targetView.setAlpha(1.0F);
      if (!this.val$visible) {
        this.val$targetView.setVisibility(4);
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.val$targetView != null) && (this.val$visible)) {
      this.val$targetView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     admb
 * JD-Core Version:    0.7.0.1
 */