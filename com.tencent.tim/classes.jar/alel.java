import android.view.animation.Interpolator;

final class alel
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.3333333F) {
      return 0.0F;
    }
    return (paramFloat - 0.3333333F) * 1.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alel
 * JD-Core Version:    0.7.0.1
 */