import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class akzl
  extends auqs.a
{
  akzl(akze paramakze) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "RESUME_GESTURE_ANI, " + this.this$0.mState);
    }
    this.this$0.Cc.setVisibility(8);
    this.this$0.mUIHandler.sendEmptyMessageDelayed(1001, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzl
 * JD-Core Version:    0.7.0.1
 */