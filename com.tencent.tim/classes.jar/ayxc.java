import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCountTimeLayout;
import java.util.concurrent.atomic.AtomicBoolean;

public class ayxc
  extends AnimatorListenerAdapter
{
  public ayxc(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    axiy.i("CameraCaptureLayout", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    axiy.i("CameraCaptureLayout", "scaleAnimator end, shortVideoShot:" + this.d.dE.get() + ", mActionUpAnimator:" + this.d.dF.get());
    if (!this.d.dF.get())
    {
      this.d.dE.set(true);
      this.d.handler.sendEmptyMessage(2);
      this.d.eTX();
      this.d.ahO = System.currentTimeMillis();
      this.d.handler.sendEmptyMessage(5);
    }
    for (;;)
    {
      this.d.dF.set(false);
      this.d.a.setVisibility(0);
      return;
      this.d.cxg();
      this.d.bN(1.0F);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    axiy.i("CameraCaptureLayout", "scaleAnimator start!");
    this.d.handler.sendEmptyMessage(9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayxc
 * JD-Core Version:    0.7.0.1
 */