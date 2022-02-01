import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class arfc
  extends Animation
{
  private Camera mCamera;
  private int mHeight;
  private Matrix mMatrix;
  private View mView;
  private int mWidth;
  
  public arfc(View paramView)
  {
    this.mView = paramView;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    paramFloat = 90.0F * paramFloat;
    this.mCamera.save();
    this.mCamera.rotateX(paramFloat);
    this.mCamera.getMatrix(this.mMatrix);
    this.mCamera.restore();
    if (this.mView != null)
    {
      this.mView.setAlpha(1.0F - paramFloat / 90.0F);
      this.mView.invalidate();
    }
    this.mMatrix.preTranslate(-this.mWidth, -this.mHeight);
    this.mMatrix.postTranslate(this.mWidth, this.mHeight);
    paramTransformation.getMatrix().postConcat(this.mMatrix);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mCamera = new Camera();
    this.mMatrix = new Matrix();
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfc
 * JD-Core Version:    0.7.0.1
 */