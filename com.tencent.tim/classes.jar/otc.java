import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.util.Stack;

public class otc
{
  private static String TAG = "PublicAccountImageCollectionActivityManager";
  private static otc a;
  private static int bfQ = 3;
  private static Stack<Activity> c;
  
  public static otc a()
  {
    if (a == null) {
      a = new otc();
    }
    return a;
  }
  
  private void bgY()
  {
    Activity localActivity = (Activity)c.firstElement();
    if (localActivity != null)
    {
      localActivity.finish();
      c.remove(localActivity);
    }
  }
  
  public void ba(Activity paramActivity)
  {
    if (c == null) {
      c = new Stack();
    }
    c.add(paramActivity);
  }
  
  public void bb(Activity paramActivity)
  {
    if ((c != null) && (paramActivity != null)) {
      c.remove(paramActivity);
    }
  }
  
  public void bgX()
  {
    if ((c != null) && (c.size() > bfQ))
    {
      int j = c.size();
      int k = bfQ;
      int i = 0;
      while (i < j - k)
      {
        bgY();
        i += 1;
      }
    }
  }
  
  public int rS()
  {
    if (c != null)
    {
      int i = c.size();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getActivityStackNum = " + i);
      }
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     otc
 * JD-Core Version:    0.7.0.1
 */