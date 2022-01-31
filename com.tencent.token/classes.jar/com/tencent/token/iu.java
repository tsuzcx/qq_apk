package com.tencent.token;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import taiji.n;

public final class iu
{
  private static final PathMeasure a = new PathMeasure();
  private static final Path b = new Path();
  private static final Path c = new Path();
  private static final float[] d = new float[4];
  private static final float e = (float)Math.sqrt(2.0D);
  
  public static float a(Matrix paramMatrix)
  {
    d[0] = 0.0F;
    d[1] = 0.0F;
    d[2] = e;
    d[3] = e;
    paramMatrix.mapPoints(d);
    float f1 = d[2];
    float f2 = d[0];
    float f3 = d[3];
    float f4 = d[1];
    return (float)Math.hypot(f1 - f2, f3 - f4) / 2.0F;
  }
  
  public static void a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    uilib.doraemon.m.a("applyTrimPathIfNeeded");
    a.setPath(paramPath, false);
    float f2 = a.getLength();
    if ((paramFloat1 == 1.0F) && (paramFloat2 == 0.0F))
    {
      uilib.doraemon.m.b("applyTrimPathIfNeeded");
      return;
    }
    if ((f2 < 1.0F) || (Math.abs(paramFloat2 - paramFloat1 - 1.0F) < 0.01D))
    {
      uilib.doraemon.m.b("applyTrimPathIfNeeded");
      return;
    }
    float f1 = f2 * paramFloat1;
    paramFloat2 = f2 * paramFloat2;
    paramFloat1 = Math.min(f1, paramFloat2);
    f1 = Math.max(f1, paramFloat2);
    paramFloat3 *= f2;
    paramFloat2 = paramFloat1 + paramFloat3;
    f1 += paramFloat3;
    paramFloat3 = paramFloat2;
    paramFloat1 = f1;
    if (paramFloat2 >= f2)
    {
      paramFloat3 = paramFloat2;
      paramFloat1 = f1;
      if (f1 >= f2)
      {
        paramFloat3 = it.a(paramFloat2, f2);
        paramFloat1 = it.a(f1, f2);
      }
    }
    paramFloat2 = paramFloat3;
    if (paramFloat3 < 0.0F) {
      paramFloat2 = it.a(paramFloat3, f2);
    }
    paramFloat3 = paramFloat1;
    if (paramFloat1 < 0.0F) {
      paramFloat3 = it.a(paramFloat1, f2);
    }
    if (paramFloat2 == paramFloat3)
    {
      paramPath.reset();
      uilib.doraemon.m.b("applyTrimPathIfNeeded");
      return;
    }
    paramFloat1 = paramFloat2;
    if (paramFloat2 >= paramFloat3) {
      paramFloat1 = paramFloat2 - f2;
    }
    b.reset();
    a.getSegment(paramFloat1, paramFloat3, b, true);
    if (paramFloat3 > f2)
    {
      c.reset();
      a.getSegment(0.0F, paramFloat3 % f2, c, true);
      b.addPath(c);
    }
    for (;;)
    {
      paramPath.set(b);
      uilib.doraemon.m.b("applyTrimPathIfNeeded");
      return;
      if (paramFloat1 < 0.0F)
      {
        c.reset();
        a.getSegment(paramFloat1 + f2, f2, c, true);
        b.addPath(c);
      }
    }
  }
  
  public static void a(Path paramPath, taiji.m paramm)
  {
    if (paramm == null) {
      return;
    }
    a(paramPath, ((Float)paramm.d().b()).floatValue() / 100.0F, ((Float)paramm.e().b()).floatValue() / 100.0F, ((Float)paramm.f().b()).floatValue() / 360.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.iu
 * JD-Core Version:    0.7.0.1
 */