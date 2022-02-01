package com.tencent.token;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

public final class atd
{
  public static void a(anb paramanb, Path paramPath)
  {
    paramPath.reset();
    PointF localPointF1 = paramanb.b;
    paramPath.moveTo(localPointF1.x, localPointF1.y);
    localPointF1 = new PointF(localPointF1.x, localPointF1.y);
    int i = 0;
    while (i < paramanb.a.size())
    {
      Object localObject = (aml)paramanb.a.get(i);
      PointF localPointF2 = ((aml)localObject).a;
      PointF localPointF3 = ((aml)localObject).b;
      localObject = ((aml)localObject).c;
      if ((localPointF2.equals(localPointF1)) && (localPointF3.equals(localObject))) {
        paramPath.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
      } else {
        paramPath.cubicTo(localPointF2.x, localPointF2.y, localPointF3.x, localPointF3.y, ((PointF)localObject).x, ((PointF)localObject).y);
      }
      localPointF1.set(((PointF)localObject).x, ((PointF)localObject).y);
      i += 1;
    }
    if (paramanb.c) {
      paramPath.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.atd
 * JD-Core Version:    0.7.0.1
 */