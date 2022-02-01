import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class wta
{
  private static String aUd = "";
  private static HashMap<String, String> gK;
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, int paramInt)
  {
    a(paramContext, paramQQAppInterface, paramMessageRecord, paramInt, "");
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    if (a(paramContext, paramMessageRecord))
    {
      paramContext = i(paramMessageRecord);
      if (QLog.isColorLevel()) {
        QLog.d("ECommerceDataReportUtil", 2, "reportECommerceData  reportConfig -> " + gK);
      }
      if (!y(paramQQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ECommerceDataReportUtil", 2, "reportECommerceData load config from QConfigManager");
        }
        paramMessageRecord = new WeakReference(paramQQAppInterface);
        ThreadManager.getFileThreadHandler().post(new ECommerceDataReportUtil.1(paramQQAppInterface, paramMessageRecord, paramContext, paramInt, paramString));
      }
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ECommerceDataReportUtil", 2, "reportECommerceData hit cache");
    }
    b(paramQQAppInterface, paramContext, paramInt, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(null, paramQQAppInterface, (ChatMessage)paramList.next(), paramInt);
      }
    }
  }
  
  private static boolean a(Context paramContext, MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForReplyText))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ECommerceDataReportUtil", 2, "isMessageNeedReport : need -> " + bool);
      }
      return bool;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    Iterator localIterator = gK.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString1)) && (paramString1.contains(str))) {
        if ((paramInt != 5) || ((!TextUtils.isEmpty(paramString2)) && (paramString2.contains(str))))
        {
          paramString1 = (String)localEntry.getValue();
          anot.a(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, paramInt, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("ECommerceDataReportUtil", 2, "checkAndReport : doReport key -> " + str + ", type => " + paramInt + ", reportTag -> " + paramString1 + "， clickUrl -> " + paramString2);
          }
        }
      }
    }
  }
  
  private static String i(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForText))
    {
      paramMessageRecord = (MessageForText)paramMessageRecord;
      if ((paramMessageRecord.sb instanceof aofk)) {
        return ((aofk)paramMessageRecord.sb).mSource;
      }
      if ((paramMessageRecord.sb instanceof Spannable)) {
        return paramMessageRecord.sb.toString();
      }
    }
    else
    {
      if ((paramMessageRecord instanceof MessageForMixedMsg)) {
        return paramMessageRecord.msg;
      }
      if ((paramMessageRecord instanceof MessageForReplyText)) {
        return ((MessageForReplyText)paramMessageRecord).getSummaryMsg();
      }
    }
    return "";
  }
  
  private static boolean y(QQAppInterface paramQQAppInterface)
  {
    return (gK != null) && (!gK.isEmpty()) && (paramQQAppInterface != null) && (!TextUtils.isEmpty(aUd)) && (aUd.equals(paramQQAppInterface.getCurrentAccountUin()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wta
 * JD-Core Version:    0.7.0.1
 */