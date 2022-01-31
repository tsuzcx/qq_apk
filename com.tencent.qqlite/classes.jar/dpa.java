import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class dpa
  extends don
{
  public dpa(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateLocalFailedWhenChangeToOff";
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (a("onSenderUploadException")) {
      return;
    }
    OnlineFileSessionWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 12, true);
    a("StateExcepInvalidWhenChangeToOff");
    this.jdField_a_of_type_Don = new dow(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
  }
  
  protected void a(long paramLong)
  {
    b(paramLong);
  }
  
  protected boolean a()
  {
    if (a("onRecvOnLineFile")) {
      return false;
    }
    OnlineFileSessionWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 9, 11);
    OnlineFileSessionWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.jdField_a_of_type_Don = new dpp(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
    return true;
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    if (a("onSenderUploadCompleted")) {
      return false;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((FileManagerUtil.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.Uuid, 3, false, localFileManagerEntity);
    }
    localFileManagerEntity.cloudType = 1;
    OnlineFileSessionWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 13, true);
    a("StateUploadoneWhenChangeToOff");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Don = new dpq(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
    return true;
  }
  
  protected void b()
  {
    if (a("onSenderCancelUpload")) {
      return;
    }
    OnlineFileSessionWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Don = new doq(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
  }
  
  protected void k() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dpa
 * JD-Core Version:    0.7.0.1
 */