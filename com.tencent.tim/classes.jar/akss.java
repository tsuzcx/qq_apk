import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class akss
  extends Animation
{
  akss(aksl paramaksl, View paramView, int paramInt) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat == 1.0F) {
      this.val$view.setVisibility(8);
    }
    do
    {
      return;
      paramTransformation = this.val$view.getLayoutParams();
    } while (paramTransformation == null);
    paramTransformation.height = (this.aMN - (int)(this.aMN * paramFloat));
    this.val$view.setLayoutParams(paramTransformation);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akss
 * JD-Core Version:    0.7.0.1
 */