import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

public class dqp
  implements IWyFileSystem.IWyCallback
{
  public dqp(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(Boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryNeedVerifyPwd, onSucceed  need pwd[" + paramBoolean + "]");
    }
    this.a.a.a().a(true, 44, new Object[] { Integer.valueOf(0), null, paramBoolean });
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryNeedVerifyPwd, onFailed. errorCode[" + String.valueOf(paramWyErrorStatus.errorCode) + "],errorMsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.a.a.a().a(false, 44, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg, null });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dqp
 * JD-Core Version:    0.7.0.1
 */