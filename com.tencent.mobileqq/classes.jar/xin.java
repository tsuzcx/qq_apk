import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;

@TargetApi(14)
public class xin
{
  public static int a;
  public static int b;
  
  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 < paramInt4) {
      return 1.0F;
    }
    return paramInt4 / paramInt2;
  }
  
  public static int a()
  {
    return b(BaseApplicationImpl.getApplication().getBaseContext(), 24.0F);
  }
  
  public static int a(Context paramContext)
  {
    if (a > 0) {
      return a;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (a = localPoint.x;; a = paramContext.getDefaultDisplay().getWidth()) {
      return a;
    }
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static void a(Canvas paramCanvas, xip paramxip, xiq paramxiq, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = a();
    paramCanvas.concat(paramxip.b(paramxiq));
    int i = (int)(paramxiq.n * paramxiq.j * paramxiq.p) + paramxiq.e * 2;
    int j = (int)(paramxiq.o * paramxiq.j * paramxiq.p) + paramxiq.e * 2;
    paramCanvas.translate(-i * 1.0F / 2.0F, -j * 1.0F / 2.0F);
    paramxip = new Paint();
    paramxip.setStyle(Paint.Style.STROKE);
    paramxip.setColor(BaseApplicationImpl.getApplication().getResources().getColor(2131167206));
    paramxip.setStrokeWidth(b(BaseApplicationImpl.getApplication().getBaseContext(), 1.0F));
    int k = b(BaseApplicationImpl.getApplication().getBaseContext(), 3.0F);
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, i, j), k, k, paramxip);
    paramCanvas.translate(-paramInt1 / 2, -paramInt1 / 2);
    paramCanvas.translate(i, j);
    paramxip = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt3);
    paramxip.setBounds(0, 0, paramInt1, paramInt1);
    paramxip.draw(paramCanvas);
    paramCanvas.translate(0.0F, -j);
    paramxip = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt2);
    paramxip.setBounds(0, 0, paramInt1, paramInt1);
    paramxip.draw(paramCanvas);
  }
  
  public static int b(Context paramContext)
  {
    if (b > 0) {
      return b;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (b = localPoint.y;; b = paramContext.getDefaultDisplay().getHeight()) {
      return b;
    }
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int c(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xin
 * JD-Core Version:    0.7.0.1
 */