import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import dov.com.qq.im.ae.album.nocropper.AECropperImageView;

public class awvn
  implements ValueAnimator.AnimatorUpdateListener
{
  public awvn(AECropperImageView paramAECropperImageView, Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.a.getImageMatrix();
    float f2 = AECropperImageView.a(this.a, this.O, 2);
    float f3 = AECropperImageView.a(this.a, this.O, 5);
    paramValueAnimator.postTranslate(this.DP * f1 - (f2 - this.DQ), f1 * this.DR - (f3 - this.DS));
    this.a.setImageMatrix(paramValueAnimator);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awvn
 * JD-Core Version:    0.7.0.1
 */