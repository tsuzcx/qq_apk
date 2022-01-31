import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

public class gbv
  implements IWyFileSystem.IWyCallback
{
  public gbv(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "getPreviewUrl onSucceed.");
    }
    this.a.a.a().a(true, 40, new Object[] { paramString });
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getPreviewUrl onFailed: errcode[" + paramWyErrorStatus.errorCode + "], errmsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.a.a.a().a(false, 40, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gbv
 * JD-Core Version:    0.7.0.1
 */