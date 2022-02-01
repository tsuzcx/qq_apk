package com.tencent.token;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;
import taiji.aa;
import taiji.ao;

public class gp
{
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }
  
  static int a(float paramFloat1, float paramFloat2)
  {
    return a((int)paramFloat1, (int)paramFloat2);
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 - b(paramInt1, paramInt2) * paramInt2;
  }
  
  public static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return (int)(paramInt1 + paramFloat * (paramInt2 - paramInt1));
  }
  
  public static void a(ao paramao, Path paramPath)
  {
    paramPath.reset();
    PointF localPointF1 = paramao.a();
    paramPath.moveTo(localPointF1.x, localPointF1.y);
    localPointF1 = new PointF(localPointF1.x, localPointF1.y);
    int i = 0;
    while (i < paramao.c().size())
    {
      Object localObject = (aa)paramao.c().get(i);
      PointF localPointF2 = ((aa)localObject).a();
      PointF localPointF3 = ((aa)localObject).b();
      localObject = ((aa)localObject).c();
      if ((localPointF2.equals(localPointF1)) && (localPointF3.equals(localObject))) {
        paramPath.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
      } else {
        paramPath.cubicTo(localPointF2.x, localPointF2.y, localPointF3.x, localPointF3.y, ((PointF)localObject).x, ((PointF)localObject).y);
      }
      localPointF1.set(((PointF)localObject).x, ((PointF)localObject).y);
      i += 1;
    }
    if (paramao.b()) {
      paramPath.close();
    }
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    int j = paramInt1 / paramInt2;
    int i = j;
    if ((paramInt1 ^ paramInt2) < 0)
    {
      i = j;
      if (paramInt2 * j != paramInt1) {
        i = j - 1;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gp
 * JD-Core Version:    0.7.0.1
 */