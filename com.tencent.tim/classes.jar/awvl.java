import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import dov.com.qq.im.ae.album.nocropper.AECropperImageView;

public class awvl
  implements ValueAnimator.AnimatorUpdateListener
{
  public awvl(AECropperImageView paramAECropperImageView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Matrix localMatrix = this.a.getImageMatrix();
    localMatrix.reset();
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    localMatrix.postScale((this.DJ - this.DK) * paramValueAnimator.intValue() / 20.0F + this.DK, (this.DJ - this.DK) * paramValueAnimator.intValue() / 20.0F + this.DK);
    float f1 = (this.DL - this.DM) * paramValueAnimator.intValue() / 20.0F;
    float f2 = this.DM;
    float f3 = this.DN;
    float f4 = this.DO;
    localMatrix.postTranslate(f1 + f2, paramValueAnimator.intValue() * (f3 - f4) / 20.0F + this.DO);
    this.a.setImageMatrix(localMatrix);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awvl
 * JD-Core Version:    0.7.0.1
 */