import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

public class gbw
  implements IWyFileSystem.IWyCallback
{
  public gbw(WeiYunLogicCenter paramWeiYunLogicCenter, String paramString1, String paramString2) {}
  
  public void a(Void paramVoid)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onSucceed  strFileId[" + this.jdField_a_of_type_JavaLangString + "]strFileName[" + String.valueOf(this.b) + "]");
    }
    FMDataCache.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a(true, 20, new Object[] { Integer.valueOf(0), null, this.jdField_a_of_type_JavaLangString, this.b, Boolean.valueOf(false) });
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onFailed  strFileId[" + this.jdField_a_of_type_JavaLangString + "]strFileName[" + String.valueOf(this.b) + "]errorCode[" + String.valueOf(paramWyErrorStatus.errorCode) + "],errorMsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    FMDataCache.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a(false, 20, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg, this.jdField_a_of_type_JavaLangString, this.b, Boolean.valueOf(false) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gbw
 * JD-Core Version:    0.7.0.1
 */