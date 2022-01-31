import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.CommonFtnFile;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

public class dqt
  implements IWyFileSystem.IWyCallback
{
  public dqt(WeiYunLogicCenter paramWeiYunLogicCenter, FileManagerEntity paramFileManagerEntity, int paramInt) {}
  
  public void a(IWyFileSystem.CommonFtnFile paramCommonFtnFile)
  {
    paramCommonFtnFile = paramCommonFtnFile.guid;
    if ((paramCommonFtnFile == null) || (paramCommonFtnFile.length() < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "sendWyFile2QqOffline onSucceed,But uuid is null!!!");
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a(false, 33, new Object[] { Integer.valueOf(13), "", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) });
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileWy2Of", 0L, "", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, "", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9001L, "onSucceed but guid null", 0L, 0L, 0L, "", "", 0, "onSucceed but guid null", null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "sendWyFile2QqOffline onSucceed, Uuid[" + paramCommonFtnFile + "]");
    }
    int i;
    String str;
    if (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath))
    {
      i = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      if (i != 0) {
        break label465;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a(paramCommonFtnFile, 3, true, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (str != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = str;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = paramCommonFtnFile;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = paramCommonFtnFile;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 8, "");
    if (this.jdField_a_of_type_Int == 3000) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgUid, null);
    }
    for (;;)
    {
      paramCommonFtnFile = new FileManagerReporter.fileAssistantReportData();
      paramCommonFtnFile.b = "send_file_suc";
      paramCommonFtnFile.jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a(), paramCommonFtnFile);
      return;
      label465:
      if (i != 2) {
        break;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 2);
      if (str == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = str;
      break;
      paramCommonFtnFile = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin.replace("+", "");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a(paramCommonFtnFile, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, null);
    }
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWyFile2QqOffline onFailed: errcode[" + paramWyErrorStatus.errorCode + "], errmsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, 1005);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a(false, 33, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) });
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileWy2Of", 0L, "", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, "", "", paramWyErrorStatus.errorCode, paramWyErrorStatus.errorMsg, 0L, 0L, 0L, "", "", 0, paramWyErrorStatus.errorMsg, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dqt
 * JD-Core Version:    0.7.0.1
 */