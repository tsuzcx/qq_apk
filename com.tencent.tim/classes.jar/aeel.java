import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

public class aeel
{
  private static double ct = 0.25D;
  private static double cu = 0.5D;
  private static float vG;
  private static float vH;
  private static float vI;
  private int mScreenHeight;
  private int mScreenWidth;
  
  public aeel(Context paramContext)
  {
    eg(paramContext);
    paramContext = paramContext.getResources();
    vG = paramContext.getDimensionPixelSize(2131297940);
    vH = paramContext.getDimensionPixelSize(2131297941);
    vI = paramContext.getDimensionPixelSize(2131297939);
  }
  
  private void eg(Context paramContext)
  {
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      this.mScreenWidth = paramContext.getDefaultDisplay().getWidth();
      this.mScreenHeight = paramContext.getDefaultDisplay().getHeight();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("TouchStateDetector", 1, paramContext, new Object[0]);
    }
  }
  
  public double a(MotionEvent paramMotionEvent)
  {
    float f = paramMotionEvent.getRawX();
    paramMotionEvent.getRawY();
    if (f <= ct * this.mScreenWidth) {
      return 0.0D;
    }
    if (f >= cu * this.mScreenWidth) {
      return 1.0D;
    }
    return (f - ct * this.mScreenWidth) / ((cu - ct) * this.mScreenWidth);
  }
  
  public boolean a(MotionEvent paramMotionEvent, Context paramContext)
  {
    return (a(paramMotionEvent) + 1.0E-008D > 1.0D) && (paramMotionEvent.getRawX() > this.mScreenWidth - vH) && (paramMotionEvent.getRawY() > this.mScreenHeight - vG - vI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeel
 * JD-Core Version:    0.7.0.1
 */