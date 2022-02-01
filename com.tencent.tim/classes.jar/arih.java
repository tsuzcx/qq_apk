import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class arih
  extends Animation
{
  private int ehY = 0;
  private Camera mCamera;
  private float mCenterX;
  private float mCenterY;
  private final float mDepthZ;
  private final float mFromDegrees;
  private final boolean mReverse;
  private final float mToDegrees;
  
  public arih(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean)
  {
    this(paramFloat1, paramFloat2, 0, paramFloat3, paramFloat4, paramFloat5, paramBoolean);
  }
  
  public arih(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean)
  {
    this.mFromDegrees = paramFloat1;
    this.mToDegrees = paramFloat2;
    this.mCenterX = paramFloat3;
    this.mCenterY = paramFloat4;
    this.mDepthZ = paramFloat5;
    this.mReverse = paramBoolean;
    this.ehY = paramInt;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.mFromDegrees;
    float f2 = this.mToDegrees;
    float f3 = this.mCenterX;
    float f4 = this.mCenterY;
    Camera localCamera = this.mCamera;
    paramTransformation = paramTransformation.getMatrix();
    localCamera.save();
    if (this.mReverse) {
      localCamera.translate(0.0F, 0.0F, this.mDepthZ * paramFloat);
    }
    for (;;)
    {
      localCamera.rotateY(f1 + (f2 - f1) * paramFloat);
      localCamera.getMatrix(paramTransformation);
      localCamera.restore();
      paramTransformation.preTranslate(-f3, -f4);
      paramTransformation.postTranslate(f3, f4);
      return;
      localCamera.translate(0.0F, 0.0F, this.mDepthZ * (1.0F - paramFloat));
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mCamera = new Camera();
    if (this.ehY == 1)
    {
      this.mCenterX = (paramInt1 * this.mCenterX);
      this.mCenterY = (paramInt2 * this.mCenterY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arih
 * JD-Core Version:    0.7.0.1
 */