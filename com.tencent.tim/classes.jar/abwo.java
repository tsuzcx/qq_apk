import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class abwo
{
  public static void s(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    int i;
    do
    {
      String str;
      for (;;)
      {
        return;
        try
        {
          if (abwk.Zn())
          {
            i = paramBundle.getInt("featureId");
            str = paramBundle.getString("featureKey");
            if ("action_begin_trace".equals(paramString))
            {
              abwk.a().e(i, str, paramBundle);
              return;
            }
          }
        }
        catch (Exception paramString)
        {
          QLog.e("TraceReport", 1, paramString, new Object[0]);
          return;
        }
      }
      if ("action_end_trace".equals(paramString))
      {
        abwk.a().f(i, str, paramBundle);
        return;
      }
      if ("action_report_span".equals(paramString))
      {
        abwk.a().g(i, str, paramBundle);
        return;
      }
      if ("action_update_trace".equals(paramString))
      {
        abwk.a().w(i, paramBundle);
        return;
      }
    } while (!"action_enable_trace".equals(paramString));
    boolean bool = paramBundle.getBoolean("enable");
    abwk.a().bl(i, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abwo
 * JD-Core Version:    0.7.0.1
 */