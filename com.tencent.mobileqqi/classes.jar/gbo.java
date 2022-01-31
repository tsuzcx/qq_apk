import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

public class gbo
  implements IWyFileSystem.IWyCallback
{
  public gbo(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onSucceed");
    }
    this.a.a.a().a(true, 45, new Object[] { Integer.valueOf(0), null, paramString });
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onFailed. errorCode[" + String.valueOf(paramWyErrorStatus.errorCode) + "],errorMsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.a.a.a().a(false, 45, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg, null });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gbo
 * JD-Core Version:    0.7.0.1
 */