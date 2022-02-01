import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class vqs
{
  public static long a()
  {
    try
    {
      String str = a("notice_feed_list_last_rsp_timestamp");
      l = a().getLong(str, 0L);
      QLog.e("EeveeRedpointUtil", 2, "getNoticeFeedListLastRspTimestamp error!", localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        QLog.d("EeveeRedpointUtil", 2, "getNoticeFeedListLastRspTimestamp key: " + str + ", result: " + l);
        return l;
      }
      catch (Throwable localThrowable2)
      {
        long l;
        break label56;
      }
      localThrowable1 = localThrowable1;
      l = 0L;
    }
    label56:
    return l;
  }
  
  private static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
  }
  
  private static String a(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return str + paramString;
  }
  
  public static void a(long paramLong)
  {
    try
    {
      String str = a("notice_feed_list_last_rsp_timestamp");
      a().edit().putLong(str, paramLong).apply();
      QLog.d("EeveeRedpointUtil", 2, "saveNoticeFeedListLastRspTimestamp key: " + str + ", value: " + paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("EeveeRedpointUtil", 2, "saveNoticeFeedListLastRspTimestamp error!", localThrowable);
    }
  }
  
  public static long b()
  {
    try
    {
      String str = a("follow_tab_feed_list_last_rsp_timestamp");
      l = a().getLong(str, 0L);
      QLog.e("EeveeRedpointUtil", 2, "getFollowTabFeedListLastRspTimestamp error!", localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        QLog.d("EeveeRedpointUtil", 2, "getFollowTabFeedListLastRspTimestamp key: " + str + ", result: " + l);
        return l;
      }
      catch (Throwable localThrowable2)
      {
        long l;
        break label56;
      }
      localThrowable1 = localThrowable1;
      l = 0L;
    }
    label56:
    return l;
  }
  
  public static void b(long paramLong)
  {
    try
    {
      String str = a("follow_tab_feed_list_last_rsp_timestamp");
      a().edit().putLong(str, paramLong).apply();
      QLog.d("EeveeRedpointUtil", 2, "saveFollowTabFeedListLastRspTimestamp key: " + str + ", value: " + paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("EeveeRedpointUtil", 2, "saveFollowTabFeedListLastRspTimestamp error!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqs
 * JD-Core Version:    0.7.0.1
 */