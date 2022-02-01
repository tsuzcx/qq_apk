import android.view.View;
import android.view.ViewGroup;

public class arjq
{
  private static boolean dbQ;
  private static long mDuration = 400L;
  
  public static void V(ViewGroup paramViewGroup)
  {
    if (dbQ) {
      return;
    }
    dbQ = true;
    paramViewGroup.invalidate();
    View localView = paramViewGroup.getChildAt(0);
    paramViewGroup = paramViewGroup.getChildAt(1);
    aril localaril = new aril(paramViewGroup);
    localaril.setDuration(mDuration);
    localaril.setFillAfter(true);
    localaril.setAnimationListener(new arjr(localView, paramViewGroup));
    paramViewGroup.startAnimation(localaril);
  }
  
  public static void reset()
  {
    dbQ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjq
 * JD-Core Version:    0.7.0.1
 */