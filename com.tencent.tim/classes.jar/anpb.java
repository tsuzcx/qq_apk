import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageReportData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class anpb
{
  private static List<MessageReportData> GG;
  
  public static void F(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = paramString1 + paramString2;
    paramContext = paramContext.getSharedPreferences(paramString1 + "statistic", 0);
    int i = paramContext.getInt(paramString2, 0);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticAssist", 2, paramString2 + ": " + i);
    }
    paramContext.edit().putInt(paramString2, i + 1).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    paramString4 = new MessageReportData(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10);
    paramString1 = null;
    if (GG == null)
    {
      paramString5 = paramQQAppInterface.a().createEntityManager();
      paramString1 = paramString5.query(MessageReportData.class, false, "senderUin=? and recieverUin=?", new String[] { paramString2, paramString3 }, null, null, null, null);
      paramString5.close();
    }
    for (;;)
    {
      try
      {
        if (GG != null) {
          break label231;
        }
        if (paramString1 != null)
        {
          GG = paramString1;
          break label231;
          if (i >= GG.size()) {
            break label225;
          }
          paramString1 = (MessageReportData)GG.get(i);
          if (paramString1.equals(paramString4))
          {
            paramString1.msgCount += 1;
            paramString4.msgCount = paramString1.msgCount;
            i = 0;
            if (i != 0)
            {
              GG.add(paramString4);
              paramString4.msgCount = 1;
            }
            paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
            paramQQAppInterface.persistOrReplace(paramString4);
            paramQQAppInterface.close();
          }
        }
        else
        {
          GG = new ArrayList();
        }
      }
      finally {}
      i += 1;
      continue;
      label225:
      int i = 1;
      continue;
      label231:
      i = 0;
    }
  }
  
  public static int g(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = paramString1 + paramString2;
    return paramContext.getSharedPreferences(paramString1 + "statistic", 0).getInt(paramString2, 0);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences(paramString + "statistic", 0).edit().clear().commit();
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.drop(MessageReportData.class);
    paramQQAppInterface.close();
  }
  
  public static List<MessageReportData> n(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    List localList = paramQQAppInterface.query(MessageReportData.class, false, null, null, null, null, null, null);
    paramQQAppInterface.close();
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpb
 * JD-Core Version:    0.7.0.1
 */