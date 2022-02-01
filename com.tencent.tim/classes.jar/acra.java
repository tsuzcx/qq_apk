import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class acra
{
  private static boolean bJV;
  private static boolean bJW;
  
  public static void FY(String paramString)
  {
    if (!bJV)
    {
      bJV = true;
      Ga("reportSaveInvalidUserError");
      annt.e(new RuntimeException(), paramString);
    }
  }
  
  public static void FZ(String paramString)
  {
    if (!bJW)
    {
      bJW = true;
      Ga("reportInvalidRefredshLastMsg");
      annt.e(new RuntimeException(), paramString);
    }
  }
  
  public static void Ga(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder(512);
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfStackTraceElement[i].toString()).append("\n");
      i += 1;
    }
    QLog.i(paramString, 1, localStringBuilder.toString());
  }
  
  public static void X(MessageRecord paramMessageRecord)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramMessageRecord.istroop));
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actInvalidMessageRecord", false, 0L, 0L, localHashMap, "");
  }
  
  public static boolean j(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramInt == 1008) && (paramQQAppInterface != null))
    {
      paramQQAppInterface = ((acff)paramQQAppInterface.getManager(51)).c(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.isFriend())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acra
 * JD-Core Version:    0.7.0.1
 */