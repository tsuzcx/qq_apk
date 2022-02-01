import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import java.io.Closeable;

public final class twy
{
  private static final float SQRT_2 = (float)Math.sqrt(2.0D);
  private static final PathMeasure pathMeasure = new PathMeasure();
  private static final float[] points;
  private static final Path tempPath = new Path();
  private static final Path tempPath2 = new Path();
  
  static
  {
    points = new float[4];
  }
  
  public static void a(Path paramPath, @Nullable ttf paramttf)
  {
    if (paramttf == null) {
      return;
    }
    applyTrimPathIfNeeded(paramPath, ((Float)paramttf.a().getValue()).floatValue() / 100.0F, ((Float)paramttf.b().getValue()).floatValue() / 100.0F, ((Float)paramttf.c().getValue()).floatValue() / 360.0F);
  }
  
  public static boolean a(trx paramtrx, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramtrx.getMajorVersion() < paramInt1) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramtrx.getMajorVersion() > paramInt1);
        if (paramtrx.getMinorVersion() < paramInt2) {
          return false;
        }
        bool1 = bool2;
      } while (paramtrx.getMinorVersion() > paramInt2);
      bool1 = bool2;
    } while (paramtrx.uX() >= paramInt3);
    return false;
  }
  
  public static void applyTrimPathIfNeeded(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    trt.beginSection("applyTrimPathIfNeeded");
    pathMeasure.setPath(paramPath, false);
    float f2 = pathMeasure.getLength();
    if ((paramFloat1 == 1.0F) && (paramFloat2 == 0.0F))
    {
      trt.endSection("applyTrimPathIfNeeded");
      return;
    }
    if ((f2 < 1.0F) || (Math.abs(paramFloat2 - paramFloat1 - 1.0F) < 0.01D))
    {
      trt.endSection("applyTrimPathIfNeeded");
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
        paramFloat3 = twx.floorMod(paramFloat2, f2);
        paramFloat1 = twx.floorMod(f1, f2);
      }
    }
    paramFloat2 = paramFloat3;
    if (paramFloat3 < 0.0F) {
      paramFloat2 = twx.floorMod(paramFloat3, f2);
    }
    paramFloat3 = paramFloat1;
    if (paramFloat1 < 0.0F) {
      paramFloat3 = twx.floorMod(paramFloat1, f2);
    }
    if (paramFloat2 == paramFloat3)
    {
      paramPath.reset();
      trt.endSection("applyTrimPathIfNeeded");
      return;
    }
    paramFloat1 = paramFloat2;
    if (paramFloat2 >= paramFloat3) {
      paramFloat1 = paramFloat2 - f2;
    }
    tempPath.reset();
    pathMeasure.getSegment(paramFloat1, paramFloat3, tempPath, true);
    if (paramFloat3 > f2)
    {
      tempPath2.reset();
      pathMeasure.getSegment(0.0F, paramFloat3 % f2, tempPath2, true);
      tempPath.addPath(tempPath2);
    }
    for (;;)
    {
      paramPath.set(tempPath);
      trt.endSection("applyTrimPathIfNeeded");
      return;
      if (paramFloat1 < 0.0F)
      {
        tempPath2.reset();
        pathMeasure.getSegment(paramFloat1 + f2, f2, tempPath2, true);
        tempPath.addPath(tempPath2);
      }
    }
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static Path createPath(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    Path localPath = new Path();
    localPath.moveTo(paramPointF1.x, paramPointF1.y);
    if ((paramPointF3 != null) && (paramPointF4 != null) && ((paramPointF3.length() != 0.0F) || (paramPointF4.length() != 0.0F)))
    {
      localPath.cubicTo(paramPointF1.x + paramPointF3.x, paramPointF1.y + paramPointF3.y, paramPointF2.x + paramPointF4.x, paramPointF2.y + paramPointF4.y, paramPointF2.x, paramPointF2.y);
      return localPath;
    }
    localPath.lineTo(paramPointF2.x, paramPointF2.y);
    return localPath;
  }
  
  public static float getScale(Matrix paramMatrix)
  {
    points[0] = 0.0F;
    points[1] = 0.0F;
    points[2] = SQRT_2;
    points[3] = SQRT_2;
    paramMatrix.mapPoints(points);
    float f1 = points[2];
    float f2 = points[0];
    float f3 = points[3];
    float f4 = points[1];
    return (float)Math.hypot(f1 - f2, f3 - f4) / 2.0F;
  }
  
  public static int hashFor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 17;
    if (paramFloat1 != 0.0F) {
      j = (int)(527 * paramFloat1);
    }
    int i = j;
    if (paramFloat2 != 0.0F) {
      i = (int)(j * 31 * paramFloat2);
    }
    j = i;
    if (paramFloat3 != 0.0F) {
      j = (int)(i * 31 * paramFloat3);
    }
    i = j;
    if (paramFloat4 != 0.0F) {
      i = (int)(j * 31 * paramFloat4);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     twy
 * JD-Core Version:    0.7.0.1
 */