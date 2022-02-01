import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Gravity;
import com.tencent.mobileqq.ocr.view.gesture.Settings;

public class akpo
{
  private static final RectF aI = new RectF();
  private static final Rect bH = new Rect();
  private static final Rect cm = new Rect();
  private static final Matrix s = new Matrix();
  
  public static void a(akpm paramakpm, Settings paramSettings, Rect paramRect)
  {
    paramakpm.d(s);
    a(s, paramSettings, paramRect);
  }
  
  public static void a(Matrix paramMatrix, Settings paramSettings, Rect paramRect)
  {
    aI.set(0.0F, 0.0F, paramSettings.GY(), paramSettings.GZ());
    paramMatrix.mapRect(aI);
    int i = Math.round(aI.width());
    int j = Math.round(aI.height());
    bH.set(0, 0, paramSettings.GU(), paramSettings.GV());
    Gravity.apply(paramSettings.getGravity(), i, j, bH, paramRect);
  }
  
  public static void a(Settings paramSettings, Point paramPoint)
  {
    a(paramSettings, cm);
    Gravity.apply(paramSettings.getGravity(), 0, 0, cm, bH);
    paramPoint.set(bH.left, bH.top);
  }
  
  public static void a(Settings paramSettings, Rect paramRect)
  {
    bH.set(0, 0, paramSettings.GU(), paramSettings.GV());
    Gravity.apply(paramSettings.getGravity(), paramSettings.GW(), paramSettings.GX(), bH, paramRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akpo
 * JD-Core Version:    0.7.0.1
 */