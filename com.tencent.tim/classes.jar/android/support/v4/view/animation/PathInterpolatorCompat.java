package android.support.v4.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;

public final class PathInterpolatorCompat
{
  public static Interpolator create(float paramFloat1, float paramFloat2)
  {
    return PathInterpolatorCompatBase.create(paramFloat1, paramFloat2);
  }
  
  public static Interpolator create(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return PathInterpolatorCompatBase.create(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public static Interpolator create(Path paramPath)
  {
    return PathInterpolatorCompatBase.create(paramPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v4.view.animation.PathInterpolatorCompat
 * JD-Core Version:    0.7.0.1
 */