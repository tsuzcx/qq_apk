import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

public class nha
{
  private static nha a;
  private Integer J;
  private Integer K;
  private oea b;
  
  public static nha a(Activity paramActivity)
  {
    int i;
    int j;
    if (a == null)
    {
      a = new nha();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      i = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
    }
    try
    {
      a.b = new oea(paramActivity, i, j);
      a.b.a(new nhb());
      return a;
    }
    catch (SecurityException paramActivity)
    {
      for (;;)
      {
        QLog.e("ReadInJoyScreenShotReporter", 1, "SecurityException error = " + paramActivity.toString());
        a.b = null;
      }
    }
  }
  
  public void aWY()
  {
    if (a != null)
    {
      a.J = null;
      a.K = null;
    }
  }
  
  public void di(int paramInt1, int paramInt2)
  {
    if (a != null)
    {
      a.J = new Integer(paramInt2);
      a.K = new Integer(paramInt1);
    }
  }
  
  public void doOnDestory()
  {
    if ((a != null) && (a.b != null))
    {
      a.b.onDestroy();
      a.b = null;
    }
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nha
 * JD-Core Version:    0.7.0.1
 */