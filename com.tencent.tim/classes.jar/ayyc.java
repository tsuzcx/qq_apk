import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCountTimeLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;
import java.util.concurrent.atomic.AtomicBoolean;

public class ayyc
  extends AnimatorListenerAdapter
{
  public ayyc(QIMCameraSegmentCaptureButtonLayout paramQIMCameraSegmentCaptureButtonLayout, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSegmentCaptureLayout", 2, "scaleAnimator end, shortVideoShot:" + this.b.dE.get() + " segmentShot:" + this.b.eT.get() + ", mActionUpAnimator:" + this.b.dF.get());
    }
    if (!this.b.dF.get())
    {
      if (this.dBT) {
        this.b.dE.set(true);
      }
      this.b.eT.set(true);
      this.b.handler.sendEmptyMessage(2);
      this.b.eTX();
      this.b.ahO = System.currentTimeMillis();
      this.b.handler.sendEmptyMessage(5);
      this.b.a.setVisibility(0);
    }
    for (;;)
    {
      this.b.dF.set(false);
      return;
      if (this.dBT)
      {
        this.b.cxg();
        this.b.ba(1.0F);
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSegmentCaptureLayout", 2, "scaleAnimator start!");
    }
    this.b.handler.sendEmptyMessageDelayed(9, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayyc
 * JD-Core Version:    0.7.0.1
 */