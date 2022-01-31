package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageReportData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class StatisticAssist
{
  private static final String jdField_a_of_type_JavaLangString = "StatisticAssist";
  private static List jdField_a_of_type_JavaUtilList;
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = paramString1 + paramString2;
    return paramContext.getSharedPreferences(paramString1 + "statistic", 0).getInt(paramString2, 0);
  }
  
  public static List a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    List localList = paramQQAppInterface.a(MessageReportData.class, false, null, null, null, null, null, null);
    paramQQAppInterface.a();
    return localList;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = paramString1 + paramString2;
    paramContext = paramContext.getSharedPreferences(paramString1 + "statistic", 0);
    int i = paramContext.getInt(paramString2, 0);
    if (QLog.isColorLevel()) {
      QLog.d("report", 2, "fight...report.....emosm...statistic...key= " + paramString2 + "......count = " + i);
    }
    paramContext.edit().putInt(paramString2, i + 1).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences(paramString + "statistic", 0).edit().clear().commit();
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.a(MessageReportData.class);
    paramQQAppInterface.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    if (a == null)
    {
      a = new ArrayList();
      EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
      List localList = localEntityManager.a(MessageReportData.class, false, "senderUin=? and recieverUin=?", new String[] { paramString2, paramString3 }, null, null, null, null);
      localEntityManager.a();
      if (localList != null) {
        a = localList;
      }
    }
    paramString1 = new MessageReportData(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10);
    int i = 0;
    if (i < a.size())
    {
      paramString2 = (MessageReportData)a.get(i);
      if (paramString2.equals(paramString1))
      {
        paramString2.msgCount += 1;
        paramString1.msgCount = paramString2.msgCount;
      }
    }
    for (i = 0;; i = 1)
    {
      if (i != 0)
      {
        a.add(paramString1);
        paramString1.msgCount = 1;
      }
      paramString2 = a.iterator();
      for (;;)
      {
        if (paramString2.hasNext())
        {
          paramString3 = (MessageReportData)paramString2.next();
          if (QLog.isColorLevel())
          {
            QLog.d("StatisticAssist", 2, paramString3.getWholeMsgReport() + " msgCount " + paramString3.msgCount);
            continue;
            i += 1;
            break;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("StatisticAssist", 2, "getTextMsgReport " + paramString1.getWholeMsgReport() + " msgCount " + paramString1.msgCount);
      }
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      paramQQAppInterface.b(paramString1);
      paramQQAppInterface.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticAssist
 * JD-Core Version:    0.7.0.1
 */