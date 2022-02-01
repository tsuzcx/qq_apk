import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.CommonFtnFile;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

class atva
  implements IWyFileSystem.IWyCallback<IWyFileSystem.CommonFtnFile>
{
  atva(atuw paramatuw, FileManagerEntity paramFileManagerEntity, int paramInt) {}
  
  public void a(IWyFileSystem.CommonFtnFile paramCommonFtnFile)
  {
    paramCommonFtnFile = paramCommonFtnFile.guid;
    if ((paramCommonFtnFile == null) || (paramCommonFtnFile.length() < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "sendWyFile2QqOffline onSucceed,But uuid is null!!!");
      }
      this.jdField_b_of_type_Atuw.app.a().b(false, 33, new Object[] { Integer.valueOf(13), "", Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) });
      audx.a(this.jdField_b_of_type_Atuw.app, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileWy2Of", 0L, "", this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, "", this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9001L, "onSucceed but guid null", 0L, 0L, 0L, "", "", 0, "onSucceed but guid null", null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "sendWyFile2QqOffline onSucceed, Uuid[" + paramCommonFtnFile + "]");
    }
    if ((!aqhq.fileExistsAndNotEmpty(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath)) && (audx.fM(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) == 2))
    {
      String str = this.jdField_b_of_type_Atuw.app.a().a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (str != null) {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = str;
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = paramCommonFtnFile;
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(1);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend = true;
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setfProgress(0.0F);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = paramCommonFtnFile;
    this.jdField_b_of_type_Atuw.app.a().dhl();
    this.jdField_b_of_type_Atuw.app.a().u(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    audx.jR(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    this.jdField_b_of_type_Atuw.app.a().a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 8, "");
    if (this.bPa == 3000) {
      this.jdField_b_of_type_Atuw.app.a().a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_b_of_type_Atuw.app.getCurrentAccountUin(), this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgUid, new atvb(this));
    }
    for (;;)
    {
      paramCommonFtnFile = new audw.b();
      paramCommonFtnFile.bJE = "send_file_suc";
      paramCommonFtnFile.cYX = 1;
      audw.a(this.jdField_b_of_type_Atuw.app.getCurrentAccountUin(), paramCommonFtnFile);
      return;
      paramCommonFtnFile = this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin.replace("+", "");
      this.jdField_b_of_type_Atuw.app.a().a(paramCommonFtnFile, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, new atvc(this));
    }
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWyFile2QqOffline onFailed: errcode[" + paramWyErrorStatus.errorCode + "], errmsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
    this.jdField_b_of_type_Atuw.app.a().dhl();
    this.jdField_b_of_type_Atuw.app.a().u(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_b_of_type_Atuw.app.a().o(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, 1005);
    this.jdField_b_of_type_Atuw.app.a().b(false, 33, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg, Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) });
    audx.a(this.jdField_b_of_type_Atuw.app, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileWy2Of", 0L, "", this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, "", "", paramWyErrorStatus.errorCode, paramWyErrorStatus.errorMsg, 0L, 0L, 0L, "", "", 0, paramWyErrorStatus.errorMsg, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atva
 * JD-Core Version:    0.7.0.1
 */