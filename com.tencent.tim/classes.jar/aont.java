import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aont
{
  public static long aqk;
  public static long aql;
  public static long aqm;
  public static boolean cNr = true;
  public static Object fj;
  public static HashMap<Long, Object> nU = new HashMap();
  
  static
  {
    fj = new Object();
  }
  
  public static boolean Q(int paramInt, String paramString)
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = cNr;
    if (R(paramInt, paramString)) {
      if (cNr) {
        break label61;
      }
    }
    label61:
    for (bool1 = bool3;; bool1 = false)
    {
      cNr = bool1;
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : sEnablePreUpload" + cNr);
      bool1 = bool2;
      return bool1;
    }
  }
  
  public static boolean R(int paramInt, String paramString)
  {
    if (!aAm()) {}
    do
    {
      return false;
      if ((paramInt == 0) && ("51640996".equalsIgnoreCase(paramString))) {
        return true;
      }
    } while ((paramInt != 1) || (!"498450958".equalsIgnoreCase(paramString)));
    return true;
  }
  
  public static boolean aAm()
  {
    return false;
  }
  
  public static void f(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    if ((!R(paramSessionInfo.cZ, paramSessionInfo.aTl)) || (paramString == null)) {
      return;
    }
    ujt.e(paramQQAppInterface, paramContext, paramSessionInfo, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aont
 * JD-Core Version:    0.7.0.1
 */