import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class abui
  extends Animation
{
  private final int bTf;
  private final int bTg;
  private final int csR;
  private final int csS;
  private final int mStartX;
  private final int mStartY;
  
  public abui(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mStartX = paramInt1;
    this.mStartY = paramInt2;
    this.bTf = paramInt5;
    this.bTg = paramInt6;
    this.csR = paramInt3;
    this.csS = paramInt4;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.mStartX;
    float f2 = this.csR;
    float f3 = this.bTf;
    float f4 = this.mStartY;
    float f5 = this.csS;
    float f6 = this.bTg;
    paramTransformation.getMatrix().preTranslate((1.0F - paramFloat) * (1.0F - paramFloat) * f1 + 2.0F * paramFloat * (1.0F - paramFloat) * f2 + paramFloat * paramFloat * f3, (1.0F - paramFloat) * (1.0F - paramFloat) * f4 + 2.0F * paramFloat * (1.0F - paramFloat) * f5 + paramFloat * paramFloat * f6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abui
 * JD-Core Version:    0.7.0.1
 */