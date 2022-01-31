package com.tencent.mobileqq.filemanager.discoperation;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import gcg;

public class DiscFileOperator
  extends FileTransferObserver
  implements IFileHttpBase
{
  final int jdField_a_of_type_Int = 1000;
  long jdField_a_of_type_Long = 0L;
  public QQAppInterface a;
  FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = null;
  public FileManagerEntity a;
  DiscFileUploader jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationDiscFileUploader = null;
  FileHttpUploder jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder = null;
  public FileReportData a;
  final String jdField_a_of_type_JavaLangString = "DiscFileOperator<FileAssistant>";
  public boolean a;
  
  public DiscFileOperator(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData = new FileReportData(paramQQAppInterface.a(), "actDiscussFileUp");
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.i("DiscFileOperator<FileAssistant>", 1, "nID[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]notifyUIRefresh[" + paramBoolean + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath }, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgUid, this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder.a();
      }
    }
  }
  
  private boolean a(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      QLog.i("DiscFileOperator<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]" + "checkParam-->Host null");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      if (paramLong == 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = 9048L;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c = "onSendDiscFile Host null";
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c();
        a(false);
        bool = false;
      }
    }
    while ((paramString2 != null) && (paramString2.length() != 0) && (paramString3 != null) && (paramString3.length() != 0)) {
      for (;;)
      {
        return bool;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = ((int)paramLong);
      }
    }
    QLog.i("DiscFileOperator<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]" + "checkParam-->param error");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    if (paramLong == 0L) {}
    for (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = 9005L;; this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = ((int)paramLong))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c = "onSendDiscFile param error";
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c();
      a(false);
      return false;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Int = 3000;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.d = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.k = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    ThreadManager.a().post(new gcg(this));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)paramLong1 / (float)paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    paramLong1 = System.currentTimeMillis();
    if (paramLong1 - this.jdField_a_of_type_Long >= 1000L)
    {
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
      if (QLog.isDevelopLevel()) {
        QLog.d("DiscFileOperator<FileAssistant>", 4, "Id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]" + "Notify UI Progress! and send continue!");
      }
    }
  }
  
  public void a(Object paramObject)
  {
    a(false);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
  {
    if (this.jdField_a_of_type_Boolean) {
      QLog.w("DiscFileOperator<FileAssistant>", 1, "nID[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],onSendDiscFile user canceled!");
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.e = System.currentTimeMillis();
      if (!paramBoolean)
      {
        QLog.i("DiscFileOperator<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]" + "onSendDiscFile-->failed");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        if (paramLong == -100001L) {}
        for (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = 9043L;; this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = 9045L)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c = "server retError";
          if (paramString6 != null) {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c = paramString6;
          }
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c();
          a(false);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("DiscFileOperator<FileAssistant>", 2, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]" + "onSendDiscFile");
      }
    } while (!a(paramLong, paramString4, paramString3, paramString2));
    QLog.i("DiscFileOperator<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "],retCode[" + String.valueOf(paramLong) + "]");
    if ((paramString6 != null) && (paramString6.length() > 0))
    {
      QLog.e("DiscFileOperator<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] will show taost, retCode[" + String.valueOf(paramLong) + "], retMsg:" + paramString6);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 4, null, (int)paramLong, paramString6);
    }
    if (paramInt == 0) {}
    for (paramString2 = "http://" + paramString4 + "/ftn_handler";; paramString2 = "http://" + paramString4 + ":" + paramInt + "/ftn_handler")
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscFileOperator<FileAssistant>", 2, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]" + "strUrl[" + paramString2 + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = paramString1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationDiscFileUploader = new DiscFileUploader();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationDiscFileUploader.a(paramString3, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder = new FileHttpUploder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData, paramString2, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationDiscFileUploader);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder.b();
      return;
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = paramLong.longValue();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 6, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  public void b()
  {
    a(true);
  }
  
  public int c()
  {
    return (int)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder.a();
    }
  }
  
  public String d()
  {
    return null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = 9004L;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_h_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c();
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = 9037L;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_h_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = false;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.discoperation.DiscFileOperator
 * JD-Core Version:    0.7.0.1
 */