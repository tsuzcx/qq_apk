import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Iterator;

public class aaeq
{
  public static Bitmap a(wrb paramwrb, int paramInt1, int paramInt2)
  {
    if ((paramwrb == null) || (paramwrb.bI() == null) || (paramwrb.bI().size() <= 0)) {
      return null;
    }
    float f2;
    float f6;
    float f3;
    float f7;
    label548:
    do
    {
      for (;;)
      {
        float f8;
        try
        {
          int i = paramwrb.a().k().width();
          int j = paramwrb.a().k().height();
          localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          localCanvas = new Canvas(localBitmap);
          localCanvas.drawColor(-1);
          localPaint = new Paint(7);
          localPaint.setStyle(Paint.Style.STROKE);
          localPaint.setColor(-16777216);
          localPaint.setStrokeWidth(paramInt1 / 16.0F);
          localPaint.setStrokeCap(Paint.Cap.ROUND);
          localPaint.setStrokeJoin(Paint.Join.ROUND);
          f2 = i;
          f6 = 0.0F;
          f3 = j;
          f7 = 0.0F;
          localObject1 = paramwrb.bI().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = ((wrx)((Iterator)localObject1).next()).bJ().iterator();
          f8 = f2;
          f5 = f6;
          f4 = f3;
          f1 = f7;
          f7 = f1;
          f3 = f4;
          f6 = f5;
          f2 = f8;
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject3 = (wrx.a)((Iterator)localObject2).next();
          f2 = f8;
          if (((wrx.a)localObject3).getX() < f8) {
            f2 = ((wrx.a)localObject3).getX();
          }
          f3 = f5;
          if (((wrx.a)localObject3).getX() > f5) {
            f3 = ((wrx.a)localObject3).getX();
          }
          f5 = f4;
          if (((wrx.a)localObject3).getY() < f4) {
            f5 = ((wrx.a)localObject3).getY();
          }
          if (((wrx.a)localObject3).getY() <= f1) {
            break label548;
          }
          f1 = ((wrx.a)localObject3).getY();
        }
        catch (Throwable paramwrb)
        {
          Bitmap localBitmap;
          Canvas localCanvas;
          Paint localPaint;
          Object localObject1;
          Object localObject2;
          float f1;
          Object localObject3;
          wrx localwrx;
          ArrayList localArrayList;
          paramwrb.printStackTrace();
          return null;
        }
        float f4 = f6 - f2;
        float f5 = f7 - f3;
        f1 = Math.max(f4, f5);
        f2 -= (f1 - f4) / 2.0F;
        f3 -= (f1 - f5) / 2.0F;
        localObject2 = new Path();
        f4 = paramInt1 / f1;
        f1 = paramInt2 / f1;
        localObject3 = paramwrb.bI().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localwrx = (wrx)((Iterator)localObject3).next();
          paramwrb = localwrx.a();
          if (paramwrb != null)
          {
            ((Path)localObject2).moveTo((paramwrb.getX() - f2) * f4, (paramwrb.getY() - f3) * f1);
            localArrayList = localwrx.bJ();
            paramInt1 = 1;
            if (paramInt1 < localwrx.wa())
            {
              localObject1 = (wrx.a)localArrayList.get(paramInt1);
              ((Path)localObject2).quadTo((paramwrb.getX() - f2) * f4, (paramwrb.getY() - f3) * f1, (((wrx.a)localObject1).getX() - f2) * f4, (((wrx.a)localObject1).getY() - f3) * f1);
              paramInt1 += 1;
              paramwrb = (wrb)localObject1;
            }
          }
        }
        else
        {
          localCanvas.drawPath((Path)localObject2, localPaint);
          return localBitmap;
          f4 = f5;
          f5 = f3;
          f8 = f2;
        }
      }
    } while ((f2 <= f6) && (f3 <= f7));
    return null;
  }
  
  public static void f(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaeq
 * JD-Core Version:    0.7.0.1
 */