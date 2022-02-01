import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class odd
{
  public static boolean awr = true;
  public static boolean aws = true;
  public static boolean awt = true;
  public static boolean awu = true;
  public static boolean awv = true;
  private static ConcurrentHashMap<String, Long> bC = new ConcurrentHashMap(new HashMap(8));
  public static int tabIndex = 1;
  private static long yA;
  private static long yB;
  private static long yC;
  private static long yD;
  private static long yE;
  private static long yz;
  
  public static void bU(String paramString1, String paramString2)
  {
    long l = SystemClock.uptimeMillis();
    if (paramString1 != null)
    {
      paramString2 = (Long)bC.remove(paramString1);
      if (paramString2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PubAccAutoMonitor", 2, paramString1 + ", cost=" + (l - paramString2.longValue()));
        }
        if (!TextUtils.equals(paramString1, "KANDIAN_NEW_FEEDS_CREATE")) {
          break label82;
        }
        yC = l - paramString2.longValue();
      }
    }
    label82:
    label627:
    while (paramString2 == null)
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (TextUtils.equals(paramString1, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE"))
              {
                yD = l - paramString2.longValue();
                return;
              }
              if (TextUtils.equals(paramString1, "KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW"))
              {
                yE = l - paramString2.longValue();
                return;
              }
              if (TextUtils.equals(paramString1, "KANDIAN_FEEDS_STAGE_1_COST"))
              {
                yz = l - paramString2.longValue();
                return;
              }
              if (TextUtils.equals(paramString1, "KANDIAN_FEEDS_STAGE_2_COST"))
              {
                yA = l - paramString2.longValue();
                return;
              }
              yB = l - paramString2.longValue();
            } while (yB > 10000L);
            if (TextUtils.equals(paramString1, "SUBSCRIPT_FEEDS_COST"))
            {
              anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actSubscribeOpenCost", true, yB, 0L, null, null);
              return;
            }
            if (TextUtils.equals(paramString1, "SUBSCRIPT_AIO_COST"))
            {
              anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actSubscribeAIOOpenCost", true, yB, 0L, null, null);
              return;
            }
            if (!TextUtils.equals(paramString1, "KANDIAN_FEEDS_COST")) {
              break;
            }
            paramString1 = new HashMap();
            paramString1.put("stage_total", String.valueOf(yB));
            paramString1.put("tab_index", String.valueOf(tabIndex));
            paramString1.put("stage_1", String.valueOf(yz));
            paramString1.put("stage_2", String.valueOf(yA));
            paramString1.put("on_create", String.valueOf(yC));
            paramString1.put("load_article", String.valueOf(yD));
            paramString1.put("listView_cost", String.valueOf(yE));
            anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianOpenCost", true, yB, 0L, paramString1, null);
          } while (!QLog.isColorLevel());
          QLog.i("PubAccAutoMonitor", 2, "isRecommendFirst = " + awr);
          QLog.d("PubAccAutoMonitor", 2, new Object[] { "kandian_feeds_open_cost, total_cost = ", Long.valueOf(yB), ", tab_index = ", Integer.valueOf(tabIndex) });
          return;
          if (TextUtils.equals(paramString1, "KANDIAN_TO_SUBSCRIPT_COST"))
          {
            anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianToSubscribeCost", true, yB, 0L, null, null);
            return;
          }
        } while (TextUtils.equals(paramString1, "LEBA_KANDIAN_FEEDS_COST"));
        if (TextUtils.equals(paramString1, "SERVICE_FOLDER_COST"))
        {
          anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actServiceFolderToServiceNumListCost", true, yB, 0L, null, null);
          return;
        }
        if (TextUtils.equals(paramString1, "recommend_tab_cost"))
        {
          if (QLog.isColorLevel()) {
            QLog.i("PubAccAutoMonitor", 2, "isRecommendCostFirst = " + aws);
          }
          paramString2 = new HashMap();
          if (aws)
          {
            i = 1;
            paramString2.put("first", String.valueOf(i));
            paramString2.put("which", String.valueOf(1));
            if (!awit.aMG()) {
              break label627;
            }
          }
          for (paramString1 = "0";; paramString1 = "1")
          {
            paramString2.put("which_kandian", paramString1);
            anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianTabOpenCost", true, yB, 0L, paramString2, null);
            aws = false;
            return;
            i = 0;
            break;
          }
        }
        if (TextUtils.equals(paramString1, "video_tab_cost"))
        {
          if (QLog.isColorLevel()) {
            QLog.i("PubAccAutoMonitor", 2, "isVideoFirst = " + awt);
          }
          paramString1 = new HashMap();
          if (awt) {}
          for (i = 1;; i = 0)
          {
            paramString1.put("first", String.valueOf(i));
            paramString1.put("which", String.valueOf(2));
            anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianTabOpenCost", true, yB, 0L, paramString1, null);
            awt = false;
            return;
          }
        }
        if (TextUtils.equals(paramString1, "subscribe_tab_cost"))
        {
          if (QLog.isColorLevel()) {
            QLog.i("PubAccAutoMonitor", 2, "isSubscribeFirst = " + awu);
          }
          paramString1 = new HashMap();
          if (awu) {}
          for (i = 1;; i = 0)
          {
            paramString1.put("first", String.valueOf(i));
            paramString1.put("which", String.valueOf(3));
            anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianTabOpenCost", true, yB, 0L, paramString1, null);
            awu = false;
            return;
          }
        }
      } while (!TextUtils.equals(paramString1, "self_tab_cost"));
      if (QLog.isColorLevel()) {
        QLog.i("PubAccAutoMonitor", 2, "isSelfFirst = " + awv);
      }
      paramString1 = new HashMap();
      if (awv) {}
      for (int i = 1;; i = 0)
      {
        paramString1.put("first", String.valueOf(i));
        paramString1.put("which", String.valueOf(4));
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianTabOpenCost", true, yB, 0L, paramString1, null);
        awv = false;
        return;
      }
    }
    if (TextUtils.equals(paramString2, "KANDIAN_NEW_FEEDS_CREATE")) {
      yC = 0L;
    }
    for (;;)
    {
      bC.put(paramString2, Long.valueOf(l));
      return;
      if (TextUtils.equals(paramString2, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE")) {
        yD = 0L;
      } else if (TextUtils.equals(paramString2, "KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW")) {
        yE = 0L;
      } else if (TextUtils.equals(paramString2, "KANDIAN_FEEDS_STAGE_1_COST")) {
        yz = 0L;
      } else if (TextUtils.equals(paramString2, "KANDIAN_FEEDS_STAGE_2_COST")) {
        yA = 0L;
      } else {
        yB = 0L;
      }
    }
  }
  
  public static void clear()
  {
    awr = true;
    aws = true;
    awt = true;
    awu = true;
    awv = true;
    tabIndex = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     odd
 * JD-Core Version:    0.7.0.1
 */