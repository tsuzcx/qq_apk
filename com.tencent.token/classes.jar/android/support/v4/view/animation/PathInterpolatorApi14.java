package android.support.v4.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

class PathInterpolatorApi14
  implements Interpolator
{
  private static final float PRECISION = 0.002F;
  private final float[] mX;
  private final float[] mY;
  
  PathInterpolatorApi14(float paramFloat1, float paramFloat2)
  {
    this(createQuad(paramFloat1, paramFloat2));
  }
  
  PathInterpolatorApi14(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(createCubic(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  PathInterpolatorApi14(Path paramPath)
  {
    paramPath = new PathMeasure(paramPath, false);
    float f = paramPath.getLength();
    int j = (int)(f / 0.002F) + 1;
    this.mX = new float[j];
    this.mY = new float[j];
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < j)
    {
      paramPath.getPosTan(i * f / (j - 1), arrayOfFloat, null);
      this.mX[i] = arrayOfFloat[0];
      this.mY[i] = arrayOfFloat[1];
      i += 1;
    }
  }
  
  private static Path createCubic(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1.0F, 1.0F);
    return localPath;
  }
  
  private static Path createQuad(float paramFloat1, float paramFloat2)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.quadTo(paramFloat1, paramFloat2, 1.0F, 1.0F);
    return localPath;
  }
  
  public float getInterpolation(float paramFloat)
  {
    float f = 1.0F;
    if (paramFloat <= 0.0F) {
      f = 0.0F;
    }
    while (paramFloat >= 1.0F) {
      return f;
    }
    int j = 0;
    int i = this.mX.length - 1;
    if (i - j > 1)
    {
      int k = (j + i) / 2;
      if (paramFloat < this.mX[k]) {
        i = k;
      }
      for (;;)
      {
        break;
        j = k;
      }
    }
    f = this.mX[i] - this.mX[j];
    if (f == 0.0F) {
      return this.mY[j];
    }
    paramFloat = (paramFloat - this.mX[j]) / f;
    f = this.mY[j];
    return paramFloat * (this.mY[i] - f) + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.animation.PathInterpolatorApi14
 * JD-Core Version:    0.7.0.1
 */