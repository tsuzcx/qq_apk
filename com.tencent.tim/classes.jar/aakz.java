import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public final class aakz
{
  private static int a(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser)
  {
    int j = 0;
    int i = 0;
    if (paramRecentUser == null)
    {
      j = i;
      if (QLog.isDevelopLevel())
      {
        QLog.d("RecentReportHelper", 4, "getReportID: null RecentUser for " + paramRecentBaseData);
        j = i;
      }
      return j;
    }
    switch (paramRecentUser.getType())
    {
    default: 
      i = j;
    }
    for (;;)
    {
      j = i;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("RecentReportHelper", 4, "getReportID:" + i + ", for uin:" + paramRecentUser.uin + " and type:" + paramRecentUser.getType());
      return i;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 8;
      continue;
      i = 10;
      continue;
      i = 11;
      continue;
      i = 12;
      continue;
      i = 13;
      continue;
      i = 14;
      continue;
      i = 17;
      continue;
      i = 18;
      continue;
      i = 19;
      continue;
      i = 20;
      continue;
      i = 21;
      continue;
      i = 22;
      continue;
      i = 23;
      continue;
      i = 24;
      continue;
      i = 25;
      continue;
      i = 26;
      continue;
      if ("2909288299".equals(paramRecentUser.uin))
      {
        i = 27;
      }
      else
      {
        i = j;
        if ("2010741172".equals(paramRecentUser.uin))
        {
          i = 28;
          continue;
          i = 29;
          continue;
          i = 30;
          continue;
          i = 31;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData, RecentUser paramRecentUser)
  {
    int i = a(paramRecentBaseData, paramRecentUser);
    if (i > 0) {
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X8006824", "0X8006824", 0, 0, "" + i, "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData, RecentUser paramRecentUser, boolean paramBoolean)
  {
    int j = a(paramRecentBaseData, paramRecentUser);
    if (j > 0) {
      if (!paramBoolean) {
        break label63;
      }
    }
    label63:
    for (int i = 1;; i = 0)
    {
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X8006821", "0X8006821", i, 0, "" + j, "", "", "");
      return;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData, RecentUser paramRecentUser)
  {
    if (paramRecentBaseData.wU() <= 0) {}
    int i;
    do
    {
      return;
      i = a(paramRecentBaseData, paramRecentUser);
    } while (i <= 0);
    anot.a(paramQQAppInterface, "dc00898", "", "", "0X8006823", "0X8006823", 0, 0, "" + i, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aakz
 * JD-Core Version:    0.7.0.1
 */