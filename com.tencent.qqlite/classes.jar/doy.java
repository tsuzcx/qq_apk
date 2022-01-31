import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class doy
  extends dov
{
  public doy(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateExcepInvalidWhenRecv";
  }
  
  protected void a(int paramInt)
  {
    int i = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]. onFileRequestBeHandledByPC entity is null");
      return;
    }
    if (5 != paramInt)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.d();
      switch (paramInt)
      {
      default: 
        label63:
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  is not foud . handledbypc type error:" + paramInt);
        paramInt = 0;
      }
    }
    while (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.b();
      break label63;
      OnlineFileSessionWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 5);
      OnlineFileSessionWorker.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state change :(" + this.jdField_a_of_type_Don.a() + "->StateAcceptByPC)");
      this.jdField_a_of_type_Don = new dok(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
      paramInt = i;
      continue;
      OnlineFileSessionWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 6);
      OnlineFileSessionWorker.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state change :(" + this.jdField_a_of_type_Don.a() + "->StateRefuseByPC)");
      this.jdField_a_of_type_Don = new dpd(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
      paramInt = i;
      continue;
      OnlineFileSessionWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 8);
      OnlineFileSessionWorker.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state change :(" + this.jdField_a_of_type_Don.a() + "->StateSenderCancelSend)");
      this.jdField_a_of_type_Don = new dpk(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
      paramInt = i;
      continue;
      OnlineFileSessionWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 7);
      OnlineFileSessionWorker.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state change :(" + this.jdField_a_of_type_Don.a() + "->StateSaveToWeiYunByPC)");
      this.jdField_a_of_type_Don = new dph(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
      paramInt = i;
      continue;
      OnlineFileSessionWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
      OnlineFileSessionWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 11);
      OnlineFileSessionWorker.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state change :(" + this.jdField_a_of_type_Don.a() + "->StateUploadingWhenChangeToOff)");
      this.jdField_a_of_type_Don = new dpn(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]. recvOnLineFile entity is null");
      return;
    }
    b(paramInt1, paramInt2);
    OnlineFileSessionWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 9, 11);
    OnlineFileSessionWorker.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 9, 11);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state change :(" + this.jdField_a_of_type_Don.a() + "->StateLocalFailedWhenRecv)");
    this.jdField_a_of_type_Don = new dpc(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]. recvOnLineFile entity is null");
      return;
    }
    OnlineFileSessionWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Don = new doy(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((FileManagerUtil.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.Uuid, 3, false, localFileManagerEntity);
    }
    localFileManagerEntity.cloudType = 1;
    OnlineFileSessionWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 1, 0);
    OnlineFileSessionWorker.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 1, 0);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state change :(" + this.jdField_a_of_type_Don.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Don = new doz(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]. recvOnLineFile entity is null");
      return;
    }
    OnlineFileSessionWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Don = new doq(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
  }
  
  protected void e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]. onFailedOfLocalSomeThingHappen entity is null");
      return;
    }
    OnlineFileSessionWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
    OnlineFileSessionWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 9, 11, true);
    a("StateLocalFailedWhenRecv");
    this.jdField_a_of_type_Don = new dpc(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     doy
 * JD-Core Version:    0.7.0.1
 */