import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.Thumbnail;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

public class fxi
  implements IWyFileSystem.IWyCallback
{
  public fxi(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(IWyFileSystem.Thumbnail paramThumbnail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "getOfflinePicThumb onSucceed.");
    }
    this.a.a.a().a(true, 39, new Object[] { paramThumbnail });
    FileManagerEntity localFileManagerEntity;
    if ((paramThumbnail.context instanceof FileManagerEntity))
    {
      localFileManagerEntity = (FileManagerEntity)paramThumbnail.context;
      if ((paramThumbnail.filePath != null) && (paramThumbnail.filePath.length() >= 1)) {}
    }
    else
    {
      return;
    }
    localFileManagerEntity.strThumbPath = paramThumbnail.filePath;
    this.a.a.a().c(localFileManagerEntity);
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getOfflinePicThumb onFailed: errcode[" + paramWyErrorStatus.errorCode + "], errmsg[" + paramWyErrorStatus.errorMsg + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fxi
 * JD-Core Version:    0.7.0.1
 */