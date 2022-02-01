import android.graphics.Matrix;

public class akpp
{
  private static final Matrix M = new Matrix();
  private static final Matrix s = new Matrix();
  
  public static void a(akpm paramakpm1, akpm paramakpm2, float paramFloat1, float paramFloat2, akpm paramakpm3, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramakpm1.c(paramakpm2);
    if (!akpm.equals(paramakpm2.getZoom(), paramakpm3.getZoom())) {
      paramakpm1.d(interpolate(paramakpm2.getZoom(), paramakpm3.getZoom(), paramFloat5), paramFloat1, paramFloat2);
    }
    float f2 = paramakpm2.getRotation();
    float f3 = paramakpm3.getRotation();
    float f1;
    if (Math.abs(f2 - f3) <= 180.0F)
    {
      if (akpm.equals(f2, f3)) {
        break label189;
      }
      f1 = interpolate(f2, f3, paramFloat5);
    }
    for (;;)
    {
      if (!Float.isNaN(f1)) {
        paramakpm1.m(f1, paramFloat1, paramFloat2);
      }
      paramakpm1.V(interpolate(0.0F, paramFloat3 - paramFloat1, paramFloat5), interpolate(0.0F, paramFloat4 - paramFloat2, paramFloat5));
      return;
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = f2 + 360.0F;
      }
      f2 = f3;
      if (f3 < 0.0F) {
        f2 = f3 + 360.0F;
      }
      if (!akpm.equals(f1, f2)) {
        f1 = interpolate(f1, f2, paramFloat5);
      } else {
        label189:
        f1 = (0.0F / 0.0F);
      }
    }
  }
  
  public static void a(akpm paramakpm1, akpm paramakpm2, akpm paramakpm3, float paramFloat)
  {
    a(paramakpm1, paramakpm2, paramakpm2.getX(), paramakpm2.getY(), paramakpm3, paramakpm3.getX(), paramakpm3.getY(), paramFloat);
  }
  
  public static void a(float[] paramArrayOfFloat, akpm paramakpm1, akpm paramakpm2)
  {
    paramakpm1.d(s);
    s.invert(M);
    M.mapPoints(paramArrayOfFloat);
    paramakpm2.d(s);
    s.mapPoints(paramArrayOfFloat);
  }
  
  public static float d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
  }
  
  public static float interpolate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akpp
 * JD-Core Version:    0.7.0.1
 */