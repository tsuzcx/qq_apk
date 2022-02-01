import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.activity.aio.anim.ComboAnimation3;

public class wnn
  extends Animation
{
  private float mPivotX;
  private float mPivotY;
  
  public wnn(ComboAnimation3 paramComboAnimation3) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f2 = 1.5F;
    float f1 = 0.0F;
    if (paramFloat < this.a.pG * 5.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      paramTransformation.setAlpha(f1);
      paramTransformation.getMatrix().setScale(paramFloat, paramFloat, this.mPivotX, this.mPivotY);
      return;
      if (paramFloat < 13.0F * this.a.pG)
      {
        f1 = 0.5F - (paramFloat - this.a.pG * 5.0F) / (this.a.pG * 8.0F) * 0.5F;
        paramFloat = 1.5F + (paramFloat - this.a.pG * 5.0F) / (this.a.pG * 8.0F) * 0.5F;
      }
      else
      {
        paramFloat = 2.0F;
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
 * Qualified Name:     wnn
 * JD-Core Version:    0.7.0.1
 */