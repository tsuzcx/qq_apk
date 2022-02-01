import android.view.View;
import android.widget.FrameLayout;

public class arjp
{
  private static boolean dbQ;
  private static long mDuration = 400L;
  
  public static void g(FrameLayout paramFrameLayout)
  {
    if (dbQ) {
      return;
    }
    dbQ = true;
    paramFrameLayout.invalidate();
    View localView = paramFrameLayout.getChildAt(1);
    paramFrameLayout = paramFrameLayout.getChildAt(0);
    arfb localarfb = new arfb(localView);
    localarfb.setDuration(mDuration);
    localarfb.setFillAfter(true);
    arfc localarfc = new arfc(paramFrameLayout);
    localarfc.setDuration(mDuration);
    localarfc.setFillAfter(true);
    localView.startAnimation(localarfb);
    paramFrameLayout.startAnimation(localarfc);
  }
  
  public static void reset()
  {
    dbQ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjp
 * JD-Core Version:    0.7.0.1
 */