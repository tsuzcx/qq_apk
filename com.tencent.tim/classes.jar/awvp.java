import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import dov.com.qq.im.ae.album.nocropper.AECropperImageView;

public class awvp
  implements ValueAnimator.AnimatorUpdateListener
{
  public awvp(AECropperImageView paramAECropperImageView, float paramFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = this.a.getImageMatrix();
    if (AECropperImageView.a(this.a, paramValueAnimator) <= AECropperImageView.a(this.a)) {
      return;
    }
    double d = Math.pow(AECropperImageView.a(this.a) / this.val$scale, 0.0500000007450581D);
    paramValueAnimator.postScale((float)d, (float)d, AECropperImageView.b(this.a), AECropperImageView.c(this.a));
    this.a.setImageMatrix(paramValueAnimator);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awvp
 * JD-Core Version:    0.7.0.1
 */