import android.view.animation.Interpolator;

public final class wop
  implements Interpolator
{
  private float a = 1.6F;
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return (paramFloat * (this.a + 1.0F) + this.a) * (paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wop
 * JD-Core Version:    0.7.0.1
 */