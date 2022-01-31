import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.Thumbnail;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

public class fxh
  implements IWyFileSystem.IWyCallback
{
  public fxh(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(IWyFileSystem.Thumbnail paramThumbnail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb onSucceed. filePath[" + paramThumbnail.filePath + "]");
    }
    this.a.a.a().a(true, 39, new Object[] { paramThumbnail });
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb onFailed: errcode[" + paramWyErrorStatus.errorCode + "], errmsg[" + paramWyErrorStatus.errorMsg + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fxh
 * JD-Core Version:    0.7.0.1
 */