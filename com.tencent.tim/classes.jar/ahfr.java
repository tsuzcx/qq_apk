import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class ahfr
  extends QIPCModule
{
  private static volatile ahfr a;
  
  private ahfr(String paramString)
  {
    super(paramString);
  }
  
  public static ahfr a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ahfr("FlutterMainQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  private void fX(String paramString1, String paramString2)
  {
    ahfn.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ahfs(this, paramString1, paramString2));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {}
    for (paramBundle = "com.tencent.mobileqq:tool";; paramBundle = paramBundle.getString("FlutterCallerIpcProcessName", "com.tencent.mobileqq:tool"))
    {
      QLog.d("FlutterMainQIPCModule", 2, "[onCall] procName=" + paramBundle);
      if (!"ACTION_INSTALL_ENGINE".equals(paramString)) {
        break;
      }
      fX(paramBundle, "ACTION_INSTALL_RESULT");
      return EIPCResult.createSuccessResult(null);
    }
    if ("ACTION_PREDOWNLOAD_ENGINE".equals(paramString))
    {
      fX(paramBundle, "ACTION_PREDOWNLOAD_RESULT");
      return EIPCResult.createSuccessResult(null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahfr
 * JD-Core Version:    0.7.0.1
 */