import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class abfb
  extends Animation
{
  abfb(abex paramabex, View paramView, int paramInt) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramFloat = (float)(paramFloat * (0.5D + Math.sqrt(paramFloat) / 2.0D));
    this.xA.getLayoutParams().width = (this.coe - (int)(this.coe * paramFloat));
    this.xA.requestLayout();
    if (paramFloat <= 0.4F) {
      this.xA.setAlpha((0.4F - Math.min(paramFloat, 0.4F)) / 0.4F);
    }
    do
    {
      do
      {
        return;
        if (paramFloat > 0.99F) {
          break;
        }
      } while (this.xA.getVisibility() == 4);
      this.xA.setVisibility(4);
      this.xA.setAlpha(0.0F);
      return;
    } while (this.xA.getVisibility() == 8);
    this.xA.setVisibility(8);
    this.xA.setAlpha(0.0F);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abfb
 * JD-Core Version:    0.7.0.1
 */