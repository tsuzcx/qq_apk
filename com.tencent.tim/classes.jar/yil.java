import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class yil
{
  public static void c(QQAppInterface paramQQAppInterface, List<String> paramList)
  {
    if ((paramQQAppInterface == null) || (paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        v(paramQQAppInterface, (String)paramList.next());
      }
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, List<String> paramList)
  {
    if ((paramQQAppInterface == null) || (paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        w(paramQQAppInterface, (String)paramList.next());
      }
    }
  }
  
  public static void v(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      x(paramQQAppInterface, paramString);
      MessageRecord localMessageRecord = anbi.d(-1026);
      long l = anaz.gQ();
      localMessageRecord.init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, "", l, -1026, 0, l);
      localMessageRecord.isread = true;
      paramQQAppInterface.b().b(localMessageRecord, localMessageRecord.selfuin);
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8004C56", "0X8004C56", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("GatherContactsTipsHelper", 2, "insertUncommonlyUsedContactsTips success, currentUin: " + paramQQAppInterface.getCurrentAccountUin() + " friendUin:" + paramString);
  }
  
  public static void w(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      x(paramQQAppInterface, paramString);
      MessageRecord localMessageRecord = anbi.d(-1027);
      long l = anaz.gQ();
      localMessageRecord.init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, "", l, -1027, 0, l);
      localMessageRecord.isread = true;
      paramQQAppInterface.b().b(localMessageRecord, localMessageRecord.selfuin);
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8004C57", "0X8004C57", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("GatherContactsTipsHelper", 2, "insertUncommonlyUsedContactsCancelSetTips success, currentUin: " + paramQQAppInterface.getCurrentAccountUin() + " friendUin:" + paramString);
  }
  
  public static void x(QQAppInterface paramQQAppInterface, String paramString)
  {
    Iterator localIterator = paramQQAppInterface.b().k(paramString, 0).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.msgtype == -1026) || (localMessageRecord.msgtype == -1027))
      {
        paramQQAppInterface.b().t(paramString, 0, localMessageRecord.uniseq);
        if (QLog.isColorLevel()) {
          QLog.d("GatherContactsTipsHelper", 2, "deleteUncommonlyUsedContactsAndCancelTips, currentUin: " + paramQQAppInterface.getCurrentAccountUin() + " friendUin:" + paramString + " msgtype:" + localMessageRecord.msgtype);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yil
 * JD-Core Version:    0.7.0.1
 */