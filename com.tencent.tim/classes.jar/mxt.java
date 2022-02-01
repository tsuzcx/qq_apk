import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class mxt
{
  public static long startTimeStamp;
  
  public static void aTA()
  {
    startTimeStamp = System.currentTimeMillis();
  }
  
  public static void cd(Context paramContext)
  {
    long l = System.currentTimeMillis();
    if (l - startTimeStamp < 10000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_starttime", String.valueOf(l - startTimeStamp));
      kxm.d(paramContext, kxm.getAccount(), true, localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsStartStatistic", 2, "doReportStartTime param_starttime=" + (l - startTimeStamp));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxt
 * JD-Core Version:    0.7.0.1
 */