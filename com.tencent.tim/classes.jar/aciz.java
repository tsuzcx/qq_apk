import android.app.Activity;
import com.tencent.mobileqq.activity.SplashActivity;
import mqq.app.Foreground;

public class aciz
{
  public static String rH()
  {
    Activity localActivity = Foreground.getTopActivity();
    String str;
    if (localActivity != null)
    {
      str = localActivity.getClass().getName();
      if ((localActivity instanceof SplashActivity))
      {
        if (SplashActivity.bKT == 1) {
          return str + "_" + ((SplashActivity)localActivity).getCurrentTab();
        }
        return str + "_ChatFragment";
      }
    }
    else
    {
      return "Null";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aciz
 * JD-Core Version:    0.7.0.1
 */