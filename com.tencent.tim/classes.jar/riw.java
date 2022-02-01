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
public class riw
{
  public static int bsk;
  public static int bsl;
  
  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 < paramInt4) {
      return 1.0F;
    }
    return paramInt4 / paramInt2;
  }
  
  public static void a(Canvas paramCanvas, riy paramriy, riy.a parama, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = tw();
    paramCanvas.concat(paramriy.b(parama));
    int i = (int)(parama.width * parama.scaleValue * parama.nJ) + parama.bsp * 2;
    int j = (int)(parama.height * parama.scaleValue * parama.nJ) + parama.bsp * 2;
    paramCanvas.translate(-i * 1.0F / 2.0F, -j * 1.0F / 2.0F);
    paramriy = new Paint();
    paramriy.setStyle(Paint.Style.STROKE);
    paramriy.setColor(BaseApplicationImpl.getApplication().getResources().getColor(2131167671));
    paramriy.setStrokeWidth(dip2px(BaseApplicationImpl.getApplication().getBaseContext(), 1.0F));
    int k = dip2px(BaseApplicationImpl.getApplication().getBaseContext(), 3.0F);
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, i, j), k, k, paramriy);
    paramCanvas.translate(-paramInt1 / 2, -paramInt1 / 2);
    paramCanvas.translate(i, j);
    paramriy = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt3);
    paramriy.setBounds(0, 0, paramInt1, paramInt1);
    paramriy.draw(paramCanvas);
    paramCanvas.translate(0.0F, -j);
    paramriy = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt2);
    paramriy.setBounds(0, 0, paramInt1, paramInt1);
    paramriy.draw(paramCanvas);
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int getWindowScreenHeight(Context paramContext)
  {
    if (bsl > 0) {
      return bsl;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (bsl = localPoint.y;; bsl = paramContext.getDefaultDisplay().getHeight()) {
      return bsl;
    }
  }
  
  public static int getWindowScreenWidth(Context paramContext)
  {
    if (bsk > 0) {
      return bsk;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (bsk = localPoint.x;; bsk = paramContext.getDefaultDisplay().getWidth()) {
      return bsk;
    }
  }
  
  public static int px2dip(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int px2sp(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public static int tw()
  {
    return dip2px(BaseApplicationImpl.getApplication().getBaseContext(), 24.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     riw
 * JD-Core Version:    0.7.0.1
 */