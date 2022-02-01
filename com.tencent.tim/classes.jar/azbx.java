import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class azbx
{
  private static float DENSITY;
  private static float He = 1.1F;
  private static float Hf = 1.34F;
  public static int SCREEN_WIDTH;
  public static int cIE;
  private static Context context = ;
  
  static
  {
    SCREEN_WIDTH = 320;
    cIE = 480;
    WindowManager localWindowManager = (WindowManager)context.getSystemService("window");
    SCREEN_WIDTH = localWindowManager.getDefaultDisplay().getWidth();
    cIE = localWindowManager.getDefaultDisplay().getHeight();
  }
  
  @TargetApi(13)
  public static int aC(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (cIE = localPoint.y;; cIE = paramContext.getDefaultDisplay().getHeight()) {
      return cIE;
    }
  }
  
  public static boolean bG(int paramInt1, int paramInt2)
  {
    float f = paramInt2 * 1.0F / paramInt1;
    return (f > He) && (f < Hf);
  }
  
  public static int dip2px(float paramFloat)
  {
    if (DENSITY == 0.0F) {
      DENSITY = context.getResources().getDisplayMetrics().density;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScreenUtil", 2, "[@] ScreenUtil.dip2px DENSITY = " + DENSITY);
    }
    return (int)(DENSITY * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azbx
 * JD-Core Version:    0.7.0.1
 */