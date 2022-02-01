import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.qphone.base.util.QLog;

public class sho
{
  private static SharedPreferences w;
  
  public static SharedPreferences e(Context paramContext)
  {
    if (w == null)
    {
      if (paramContext == null)
      {
        QLog.e("SubscribeSpUtil", 2, "getPreference error, context is null");
        return null;
      }
      w = paramContext.getSharedPreferences("biz_subscribe", 0);
    }
    return w;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sho
 * JD-Core Version:    0.7.0.1
 */