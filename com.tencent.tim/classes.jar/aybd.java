import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;

public class aybd
  extends AnimatorListenerAdapter
{
  public aybd(LightWeightCaptureButtonLayout paramLightWeightCaptureButtonLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "rollBackLockAnimatorToActiveCorner captureView 190ms all end ScaleX:" + this.this$0.jdField_a_of_type_DovComQqImPtvBaseButton.getScaleX() + " ScaleY:" + this.this$0.jdField_a_of_type_DovComQqImPtvBaseButton.getScaleY());
    }
    this.this$0.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 1;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "rollBackLockAnimatorToActiveCorner captureView begin  ScaleX:" + this.this$0.jdField_a_of_type_DovComQqImPtvBaseButton.getScaleX() + " ScaleY:" + this.this$0.jdField_a_of_type_DovComQqImPtvBaseButton.getScaleY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aybd
 * JD-Core Version:    0.7.0.1
 */