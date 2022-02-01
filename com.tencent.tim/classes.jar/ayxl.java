import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import java.util.concurrent.atomic.AtomicBoolean;

public class ayxl
  extends AnimatorListenerAdapter
{
  public ayxl(CameraCaptureButtonLayout paramCameraCaptureButtonLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "scaleAnimator cancel!");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "scaleAnimator end, shortVideoShot:" + this.a.dE.get() + ", mActionUpAnimator:" + this.a.dF.get());
    }
    if (!this.a.dF.get())
    {
      this.a.dE.set(true);
      CameraCaptureButtonLayout.a(this.a).sendEmptyMessage(2);
      CameraCaptureButtonLayout.a(this.a, System.currentTimeMillis());
      CameraCaptureButtonLayout.a(this.a).sendEmptyMessage(5);
    }
    for (;;)
    {
      this.a.dF.set(false);
      return;
      CameraCaptureButtonLayout.a(this.a).setVisibility(8);
      CameraCaptureButtonLayout.a(this.a);
      CameraCaptureButtonLayout.a(this.a, 1.0F);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "scaleAnimator start!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayxl
 * JD-Core Version:    0.7.0.1
 */