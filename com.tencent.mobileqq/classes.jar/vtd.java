import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import qqcircle.QQCircleCounter.CountInfoRsp;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

public class vtd
{
  public static int a()
  {
    try
    {
      String str = a("folder_message_notice_bubble_last_expose_num");
      i = a().getInt(str, 0);
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getFolderMessageNoticeBubbleLastExposeNum error!", localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        QLog.d("QCircleEeveeRedPoint_Util", 2, "getFolderMessageNoticeBubbleLastExposeNum key: " + str + ", result: " + i);
        return i;
      }
      catch (Throwable localThrowable2)
      {
        int i;
        break label56;
      }
      localThrowable1 = localThrowable1;
      i = 0;
    }
    label56:
    return i;
  }
  
  public static long a()
  {
    try
    {
      String str = a("notice_feed_list_last_rsp_timestamp");
      l = a().getLong(str, -1L);
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getNoticeFeedListLastRspTimestamp error!", localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        QLog.d("QCircleEeveeRedPoint_Util", 2, "getNoticeFeedListLastRspTimestamp key: " + str + ", result: " + l);
        return l;
      }
      catch (Throwable localThrowable2)
      {
        long l;
        break label58;
      }
      localThrowable1 = localThrowable1;
      l = 0L;
    }
    label58:
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
  
  public static QQCircleCounter.RedPointInfo a(String paramString, QQCircleCounter.CountInfoRsp paramCountInfoRsp)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramCountInfoRsp == null)) {
      return null;
    }
    paramCountInfoRsp = paramCountInfoRsp.rptRedPoint.get();
    if ((paramCountInfoRsp != null) && (paramCountInfoRsp.size() > 0))
    {
      paramCountInfoRsp = paramCountInfoRsp.iterator();
      while (paramCountInfoRsp.hasNext())
      {
        QQCircleCounter.RedPointInfo localRedPointInfo = (QQCircleCounter.RedPointInfo)paramCountInfoRsp.next();
        if ((localRedPointInfo != null) && (TextUtils.equals(paramString, localRedPointInfo.appid.get()))) {
          return localRedPointInfo;
        }
      }
    }
    return null;
  }
  
  public static void a(int paramInt)
  {
    try
    {
      String str = a("folder_message_notice_bubble_last_expose_num");
      a().edit().putInt(str, paramInt).apply();
      QLog.d("QCircleEeveeRedPoint_Util", 2, "saveFolderMessageNoticeBubbleLastExposeNum key: " + str + ", value: " + paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveFolderMessageNoticeBubbleLastExposeNum error!", localThrowable);
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      String str = a("notice_feed_list_last_rsp_timestamp");
      a().edit().putLong(str, paramLong).apply();
      QLog.d("QCircleEeveeRedPoint_Util", 2, "saveNoticeFeedListLastRspTimestamp key: " + str + ", value: " + paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveNoticeFeedListLastRspTimestamp error!", localThrowable);
    }
  }
  
  public static boolean a(String paramString, QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      QLog.d("QCircleEeveeRedPoint_Util", 1, "[filterInvalidRedPointInfo] reddot has been filtered! appid is empty!");
    }
    do
    {
      return bool2;
      if ((paramRedPointInfo != null) && ("circle_entrance".equals(paramString))) {}
      switch (paramRedPointInfo.redType.get())
      {
      default: 
        bool1 = true;
        bool2 = bool1;
      }
    } while (bool1);
    QLog.d("QCircleEeveeRedPoint_Util", 1, "[filterInvalidRedPointInfo] reddot has been filtered! ");
    return bool1;
    long l1 = paramRedPointInfo.lastVisitTime.get();
    long l2 = b();
    long l3 = d();
    if ((l1 < l2) || (l1 < l3)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      paramString = new StringBuilder();
      paramString.append("[filterInvalidRedPointInfo] SmallRedPoint").append(", redDotLastVisitTime: ").append(l1).append(", followTabFeedListLastRspTimestamp: ").append(l2).append(", lastReadedSmallRedPointTimestamp: ").append(l3).append(", reportInfo: ").append(paramRedPointInfo.extend.get());
      QLog.d("QCircleEeveeRedPoint_Util", 1, new Object[] { paramString });
      break;
      l1 = paramRedPointInfo.lastVisitTime.get();
      l2 = a();
      l3 = e();
      if ((l1 < l2) || (l1 < l3)) {}
      for (bool1 = false;; bool1 = true)
      {
        paramString = new StringBuilder();
        paramString.append("[filterInvalidRedPointInfo] NumRedPoint").append(", redDotLastVisitTime: ").append(l1).append(", noticeFeedListLastRspTimestamp: ").append(l2).append(", lastReadedNumRedPointTimestamp: ").append(l3).append(", reportInfo: ").append(paramRedPointInfo.extend.get());
        QLog.d("QCircleEeveeRedPoint_Util", 1, new Object[] { paramString });
        break;
        l1 = paramRedPointInfo.lastVisitTime.get();
        l2 = g();
        l3 = b();
        long l4 = f();
        if ((l1 < l2) || (l1 < l3) || (l1 < l4)) {}
        for (bool1 = false;; bool1 = true)
        {
          paramString = new StringBuilder();
          paramString.append("[filterInvalidRedPointInfo] OutLayerRedPoint").append(", redDotLastVisitTime: ").append(l1).append(", lastOuterEntranceRedPointClearRspTimestamp: ").append(l2).append(", followTabFeedListLastRspTimestamp: ").append(l3).append(", lastReadedOuterEntranceRedPointTimestamp: ").append(l4).append(", combineRedTypes : ").append(paramRedPointInfo.outLayerInfo.combineRedTypes.get()).append(", reportInfo: ").append(paramRedPointInfo.extend.get());
          QLog.d("QCircleEeveeRedPoint_Util", 1, new Object[] { paramString });
          break;
        }
      }
    }
  }
  
  public static long b()
  {
    try
    {
      String str = a("follow_tab_feed_list_last_rsp_timestamp");
      l = a().getLong(str, -1L);
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getFollowTabFeedListLastRspTimestamp error!", localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        QLog.d("QCircleEeveeRedPoint_Util", 2, "getFollowTabFeedListLastRspTimestamp key: " + str + ", result: " + l);
        return l;
      }
      catch (Throwable localThrowable2)
      {
        long l;
        break label60;
      }
      localThrowable1 = localThrowable1;
      l = 0L;
    }
    label60:
    return l;
  }
  
  public static void b(long paramLong)
  {
    try
    {
      String str = a("follow_tab_feed_list_last_rsp_timestamp");
      a().edit().putLong(str, paramLong).apply();
      QLog.d("QCircleEeveeRedPoint_Util", 2, "saveFollowTabFeedListLastRspTimestamp key: " + str + ", value: " + paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveFollowTabFeedListLastRspTimestamp error!", localThrowable);
    }
  }
  
  public static long c()
  {
    try
    {
      String str = a("follow_tab_feed_list_last_pre_rsp_timestamp");
      l = a().getLong(str, -1L);
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getFollowTabFeedListLastPreRspTimestamp error!", localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        QLog.d("QCircleEeveeRedPoint_Util", 2, "getFollowTabFeedListLastPreRspTimestamp key: " + str + ", result: " + l);
        return l;
      }
      catch (Throwable localThrowable2)
      {
        long l;
        break label60;
      }
      localThrowable1 = localThrowable1;
      l = 0L;
    }
    label60:
    return l;
  }
  
  public static void c(long paramLong)
  {
    try
    {
      String str = a("follow_tab_feed_list_last_pre_rsp_timestamp");
      a().edit().putLong(str, paramLong).apply();
      QLog.d("QCircleEeveeRedPoint_Util", 2, "saveFollowTabFeedListLastPreRspTimestamp key: " + str + ", value: " + paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveFollowTabFeedListLastPreRspTimestamp error!", localThrowable);
    }
  }
  
  public static long d()
  {
    try
    {
      String str = a("last_readed_small_red_point_timestamp");
      l = a().getLong(str, -1L);
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getLastReadedSmallRedPointTimestamp error!", localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        QLog.d("QCircleEeveeRedPoint_Util", 2, "getLastReadedSmallRedPointTimestamp key: " + str + ", result: " + l);
        return l;
      }
      catch (Throwable localThrowable2)
      {
        long l;
        break label60;
      }
      localThrowable1 = localThrowable1;
      l = 0L;
    }
    label60:
    return l;
  }
  
  public static void d(long paramLong)
  {
    try
    {
      String str = a("last_readed_small_red_point_timestamp");
      a().edit().putLong(str, paramLong).apply();
      QLog.d("QCircleEeveeRedPoint_Util", 2, "saveLastReadedSmallRedPointTimestamp key: " + str + ", value: " + paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveLastReadedSmallRedPointTimestamp error!", localThrowable);
    }
  }
  
  public static long e()
  {
    try
    {
      String str = a("last_readed_num_red_point_timestamp");
      l = a().getLong(str, -1L);
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getLastReadedNumRedPointTimestamp error!", localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        QLog.d("QCircleEeveeRedPoint_Util", 2, "getLastReadedNumRedPointTimestamp key: " + str + ", result: " + l);
        return l;
      }
      catch (Throwable localThrowable2)
      {
        long l;
        break label60;
      }
      localThrowable1 = localThrowable1;
      l = 0L;
    }
    label60:
    return l;
  }
  
  public static void e(long paramLong)
  {
    try
    {
      String str = a("last_readed_num_red_point_timestamp");
      a().edit().putLong(str, paramLong).apply();
      QLog.d("QCircleEeveeRedPoint_Util", 2, "saveLastReadedNumRedPointTimestamp key: " + str + ", value: " + paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveLastReadedNumRedPointTimestamp error!", localThrowable);
    }
  }
  
  public static long f()
  {
    try
    {
      String str = a("last_readed_outer_entrance_red_point_timestamp");
      l = a().getLong(str, -1L);
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getLastReadedOuterEntranceRedPointTimestamp error!", localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        QLog.d("QCircleEeveeRedPoint_Util", 2, "getLastReadedOuterEntranceRedPointTimestamp key: " + str + ", result: " + l);
        return l;
      }
      catch (Throwable localThrowable2)
      {
        long l;
        break label60;
      }
      localThrowable1 = localThrowable1;
      l = 0L;
    }
    label60:
    return l;
  }
  
  public static void f(long paramLong)
  {
    try
    {
      String str = a("last_outer_entrance_red_point_clear_rsp_timestamp");
      a().edit().putLong(str, paramLong).apply();
      QLog.d("QCircleEeveeRedPoint_Util", 2, "saveLastOuterEntranceRedPointClearRspTimestamp key: " + str + ", value: " + paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveLastOuterEntranceRedPointClearRspTimestamp error!", localThrowable);
    }
  }
  
  public static long g()
  {
    try
    {
      String str = a("last_outer_entrance_red_point_clear_rsp_timestamp");
      l = a().getLong(str, -1L);
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getLastOuterEntranceRedPointClearRspTimestamp error!", localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        QLog.d("QCircleEeveeRedPoint_Util", 2, "getLastOuterEntranceRedPointClearRspTimestamp key: " + str + ", result: " + l);
        return l;
      }
      catch (Throwable localThrowable2)
      {
        long l;
        break label60;
      }
      localThrowable1 = localThrowable1;
      l = 0L;
    }
    label60:
    return l;
  }
  
  public static void g(long paramLong)
  {
    try
    {
      String str = a("follow_tab_update_notification_show_interval");
      a().edit().putLong(str, paramLong).apply();
      QLog.d("QCircleEeveeRedPoint_Util", 2, "saveFollowTabUpdateNotificationShowInterval key: " + str + ", value: " + paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveFollowTabUpdateNotificationShowInterval error!", localThrowable);
    }
  }
  
  public static long h()
  {
    long l2 = QzoneConfig.getQQCircleFollowTabUpdateNotificationShowInterval();
    try
    {
      String str = a("follow_tab_update_notification_show_interval");
      long l1 = a().getLong(str, l2);
      label83:
      return l1;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        QLog.d("QCircleEeveeRedPoint_Util", 2, "getFollowTabUpdateNotificationShowInterval key: " + str + ", result: " + l1 + ", defaultValue: " + l2);
        if (l1 > 0L) {
          return l1;
        }
        return l2;
      }
      catch (Throwable localThrowable2)
      {
        break label83;
      }
      localThrowable1 = localThrowable1;
      l1 = 0L;
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getFollowTabUpdateNotificationShowInterval error!", localThrowable1);
      return l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtd
 * JD-Core Version:    0.7.0.1
 */