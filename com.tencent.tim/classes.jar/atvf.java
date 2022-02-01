import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

class atvf
  implements IWyFileSystem.IWyCallback<Void>
{
  atvf(atuw paramatuw, WeiYunFileInfo paramWeiYunFileInfo) {}
  
  public void c(Void paramVoid)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onSucceed  strFileId[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.bIk + "]strFileName[" + String.valueOf(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.strFileName) + "]");
    }
    this.jdField_b_of_type_Atuw.app.a().b(true, 20, new Object[] { Integer.valueOf(0), null, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.bIk, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.strFileName, Boolean.valueOf(false) });
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onFailed  strFileId[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.bIk + "]strFileName[" + String.valueOf(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.strFileName) + "]errorCode[" + String.valueOf(paramWyErrorStatus.errorCode) + "],errorMsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.jdField_b_of_type_Atuw.app.a().b(false, 20, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.bIk, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.strFileName, Boolean.valueOf(false) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvf
 * JD-Core Version:    0.7.0.1
 */