import android.view.View;
import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;

class nbc
  extends auqs.a
{
  nbc(nba paramnba) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsVideoUIDelegate", 2, "onVideoEndSoon disappearAnim onAnimationEnd: ");
    }
    this.this$0.a.lN.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbc
 * JD-Core Version:    0.7.0.1
 */