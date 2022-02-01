import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;

class nbd
  extends auqs.a
{
  nbd(nba paramnba, AlphaAnimation paramAlphaAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsVideoUIDelegate", 2, "onVideoEndSoon appearAnim onAnimationEnd: ");
    }
    this.this$0.a.lN.startAnimation(this.i);
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbd
 * JD-Core Version:    0.7.0.1
 */