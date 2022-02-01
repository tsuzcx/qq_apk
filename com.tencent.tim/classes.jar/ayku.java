import android.graphics.Matrix;
import android.graphics.RectF;

public class ayku
{
  private static final Matrix Q = new Matrix();
  
  public static aylk a(RectF paramRectF1, RectF paramRectF2)
  {
    aylk localaylk = new aylk(0.0F, 0.0F, 1.0F, 0.0F);
    if (paramRectF1.equals(paramRectF2)) {
      return localaylk;
    }
    localaylk.scale = Math.max(paramRectF1.width() / paramRectF2.width(), paramRectF1.height() / paramRectF2.height());
    RectF localRectF = new RectF();
    Q.setScale(localaylk.scale, localaylk.scale, paramRectF2.centerX(), paramRectF2.centerY());
    Q.mapRect(localRectF, paramRectF2);
    localaylk.x += paramRectF1.centerX() - localRectF.centerX();
    float f = localaylk.y;
    localaylk.y = (paramRectF1.centerY() - localRectF.centerY() + f);
    return localaylk;
  }
  
  public static aylk a(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2)
  {
    aylk localaylk = new aylk(0.0F, 0.0F, 1.0F, 0.0F);
    if (paramRectF2.contains(paramRectF1)) {}
    RectF localRectF;
    do
    {
      return localaylk;
      if ((paramRectF2.width() < paramRectF1.width()) && (paramRectF2.height() < paramRectF1.height())) {
        localaylk.scale = Math.min(paramRectF1.width() / paramRectF2.width(), paramRectF1.height() / paramRectF2.height());
      }
      localRectF = new RectF();
      Q.setScale(localaylk.scale, localaylk.scale, paramFloat1, paramFloat2);
      Q.mapRect(localRectF, paramRectF2);
      if (localRectF.width() < paramRectF1.width()) {
        localaylk.x += paramRectF1.centerX() - localRectF.centerX();
      }
      while (localRectF.height() < paramRectF1.height())
      {
        paramFloat1 = localaylk.y;
        localaylk.y = (paramRectF1.centerY() - localRectF.centerY() + paramFloat1);
        return localaylk;
        if (localRectF.left > paramRectF1.left) {
          localaylk.x += paramRectF1.left - localRectF.left;
        } else if (localRectF.right < paramRectF1.right) {
          localaylk.x += paramRectF1.right - localRectF.right;
        }
      }
      if (localRectF.top > paramRectF1.top)
      {
        paramFloat1 = localaylk.y;
        localaylk.y = (paramRectF1.top - localRectF.top + paramFloat1);
        return localaylk;
      }
    } while (localRectF.bottom >= paramRectF1.bottom);
    paramFloat1 = localaylk.y;
    localaylk.y = (paramRectF1.bottom - localRectF.bottom + paramFloat1);
    return localaylk;
  }
  
  public static void a(RectF paramRectF1, RectF paramRectF2, float paramFloat)
  {
    a(paramRectF1, paramRectF2, paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public static void a(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramRectF1.isEmpty()) || (paramRectF2.isEmpty())) {
      return;
    }
    float f2 = paramFloat1;
    float f1 = paramFloat3;
    if (paramRectF1.width() < paramFloat1 + paramFloat3)
    {
      f1 = 0.0F;
      f2 = 0.0F;
    }
    paramFloat3 = paramFloat2;
    paramFloat1 = paramFloat4;
    if (paramRectF1.height() < paramFloat2 + paramFloat4)
    {
      paramFloat1 = 0.0F;
      paramFloat3 = 0.0F;
    }
    paramFloat2 = paramRectF1.width();
    paramFloat4 = paramRectF1.height();
    paramFloat2 = Math.min((paramFloat2 - f2 - f1) / paramRectF2.width(), (paramFloat4 - paramFloat3 - paramFloat1) / paramRectF2.height());
    paramRectF2.set(0.0F, 0.0F, paramRectF2.width() * paramFloat2, paramFloat2 * paramRectF2.height());
    paramRectF2.offset(paramRectF1.centerX() + (f2 - f1) / 2.0F - paramRectF2.centerX(), paramRectF1.centerY() + (paramFloat3 - paramFloat1) / 2.0F - paramRectF2.centerY());
  }
  
  public static aylk b(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2)
  {
    aylk localaylk = new aylk(0.0F, 0.0F, 1.0F, 0.0F);
    if (paramRectF2.contains(paramRectF1)) {}
    RectF localRectF;
    do
    {
      return localaylk;
      if ((paramRectF2.width() < paramRectF1.width()) || (paramRectF2.height() < paramRectF1.height())) {
        localaylk.scale = Math.max(paramRectF1.width() / paramRectF2.width(), paramRectF1.height() / paramRectF2.height());
      }
      localRectF = new RectF();
      Q.setScale(localaylk.scale, localaylk.scale, paramFloat1, paramFloat2);
      Q.mapRect(localRectF, paramRectF2);
      if (localRectF.left > paramRectF1.left) {
        localaylk.x += paramRectF1.left - localRectF.left;
      }
      while (localRectF.top > paramRectF1.top)
      {
        paramFloat1 = localaylk.y;
        localaylk.y = (paramRectF1.top - localRectF.top + paramFloat1);
        return localaylk;
        if (localRectF.right < paramRectF1.right) {
          localaylk.x += paramRectF1.right - localRectF.right;
        }
      }
    } while (localRectF.bottom >= paramRectF1.bottom);
    paramFloat1 = localaylk.y;
    localaylk.y = (paramRectF1.bottom - localRectF.bottom + paramFloat1);
    return localaylk;
  }
  
  public static void b(RectF paramRectF1, RectF paramRectF2)
  {
    paramRectF2.offset(paramRectF1.centerX() - paramRectF2.centerX(), paramRectF1.centerY() - paramRectF2.centerY());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayku
 * JD-Core Version:    0.7.0.1
 */