import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.activity.aio.anim.ComboAnimation3;

public class wnl
  extends Animation
{
  private float mPivotX;
  private float mPivotY;
  
  public wnl(ComboAnimation3 paramComboAnimation3) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f2 = 1.0F;
    float f1;
    if (paramFloat < this.a.pG * 11.0F)
    {
      f1 = paramFloat / (this.a.pG * 11.0F);
      if (paramFloat >= this.a.pG * 6.0F) {
        break label139;
      }
      f2 = 1.0F + paramFloat / (this.a.pG * 6.0F) * 0.5F;
    }
    for (;;)
    {
      paramTransformation.setAlpha(f1);
      paramTransformation.getMatrix().setScale(f2, f2, this.mPivotX, this.mPivotY);
      return;
      if (paramFloat < this.a.pG * 20.0F)
      {
        f1 = 1.0F;
        break;
      }
      f1 = 1.0F - (paramFloat - this.a.pG * 20.0F) / (4.0F * this.a.pG);
      break;
      label139:
      if (paramFloat < this.a.pG * 11.0F) {
        f2 = 1.5F - (paramFloat - this.a.pG * 6.0F) * 0.5F / (5.0F * this.a.pG);
      }
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mPivotX = (paramInt1 * 0.5F);
    this.mPivotY = (paramInt2 * 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wnl
 * JD-Core Version:    0.7.0.1
 */