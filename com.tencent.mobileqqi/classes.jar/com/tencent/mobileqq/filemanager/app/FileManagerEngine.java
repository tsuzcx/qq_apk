package com.tencent.mobileqq.filemanager.app;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.core.ThumbDownLoader;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class FileManagerEngine
{
  private static final String jdField_a_of_type_JavaLangString = "FileManagerEngine<FileAssistant>";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private ThumbDownLoader jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbDownLoader = null;
  WeiYunLogicCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter;
  
  public FileManagerEngine(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter == null) {
      a();
    }
  }
  
  private void a(long paramLong, String paramString, int paramInt)
  {
    if (paramLong < 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "uniseq is wrong!can't retry!uniseq[" + String.valueOf(paramLong) + "]");
      }
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramString, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileOf2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", null);
      return;
    }
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = 4;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(25, paramFileManagerEntity);
  }
  
  private void b(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "queryFileManagerEntity is fail!,check sessionID[" + String.valueOf(paramLong) + "]");
      }
    }
    do
    {
      do
      {
        return;
        switch (localFileManagerEntity.nOpType)
        {
        }
      } while (!QLog.isColorLevel());
      QLog.e("FileManagerEngine<FileAssistant>", 2, "unknow operation type!");
      return;
      if (localFileManagerEntity.cloudType == 0)
      {
        localFileManagerEntity.cloudType = 1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      return;
      a().a(localFileManagerEntity, localFileManagerEntity.peerType, true);
      return;
      a(localFileManagerEntity, localFileManagerEntity.peerType);
      return;
      a(localFileManagerEntity);
      return;
      b(localFileManagerEntity, 20);
      return;
      if (localFileManagerEntity.cloudType == 0)
      {
        if (localFileManagerEntity.bDelInFM == true)
        {
          localFileManagerEntity.bDelInFM = false;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("FileManagerEngine<FileAssistant>", 2, "err cloud type.when reTry :" + localFileManagerEntity.cloudType);
  }
  
  public WeiYunLogicCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter = new WeiYunLogicCenter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    paramString = a().a(paramFileManagerEntity, paramString);
    if (paramFileManagerEntity.peerType == 3000)
    {
      b(paramString, 20);
      return paramString;
    }
    a(paramString);
    return paramString;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity , FilemanagerEntity is null!");
      }
      FileManagerUtil.a();
      return null;
    }
    String str = TransfileUtile.a("", 0L, 0, true);
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = FileManagerUtil.a(localFileManagerEntity.strFilePath);
    }
    if ((localFileManagerEntity.strFilePath == null) || (localFileManagerEntity.strFilePath.length() == 0)) {
      localFileManagerEntity.strFilePath = localFileManagerEntity.fileName;
    }
    long l = MessageRecordFactory.a(-1000).uniseq;
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.nOpType = 7;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, null, paramInt);
    if (paramFileManagerEntity.peerType == 3000) {}
    for (localFileManagerEntity.selfUin = paramFileManagerEntity.peerUin;; localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())
    {
      localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
      localFileManagerEntity.cloudType = 1;
      localFileManagerEntity.status = 2;
      localFileManagerEntity.msgSeq = FileManagerUtil.a();
      localFileManagerEntity.msgUid = FileManagerUtil.b();
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + FileManagerUtil.a(localFileManagerEntity));
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, paramString1, true, localFileManagerEntity.strFilePath, localFileManagerEntity.fileSize, true, paramInt, str, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, localFileManagerEntity.Uuid, 1, l, localFileManagerEntity.msgUid, -1L, MessageCache.a());
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + FileManagerUtil.a(localFileManagerEntity));
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public FileManagerEntity a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why FileManagerRSCenter is null???");
      }
      return null;
    }
    String str2 = TransfileUtile.a(paramString1, 0L, 0, true);
    String str1 = FileManagerUtil.a(paramString1);
    long l = -1L;
    int i;
    int j;
    label63:
    FileManagerEntity localFileManagerEntity;
    if (paramBoolean)
    {
      i = 0;
      if (!paramBoolean) {
        break label403;
      }
      j = 3;
      if (paramBoolean) {
        l = MessageRecordFactory.a(-1000).uniseq;
      }
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, paramString3, paramInt);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.nOpType = i;
      localFileManagerEntity.fileSize = FileManagerUtil.a(paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "toOffline[" + String.valueOf(paramBoolean) + "], filepath[" + paramString1 + "]:size[" + String.valueOf(localFileManagerEntity.fileSize) + "]");
      }
      localFileManagerEntity.isReaded = true;
      localFileManagerEntity.peerUin = paramString3;
      localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, null, paramInt);
      localFileManagerEntity.strFilePath = paramString1;
      localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
      localFileManagerEntity.fileName = str1;
      localFileManagerEntity.nFileType = FileManagerUtil.a(paramString1);
      localFileManagerEntity.cloudType = 3;
      localFileManagerEntity.bSend = paramBoolean;
      localFileManagerEntity.msgSeq = FileManagerUtil.a();
      localFileManagerEntity.msgUid = FileManagerUtil.b();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramInt != 1004) && (paramInt != 1000)) {
        break label409;
      }
      str1 = paramString2;
    }
    for (;;)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString3, str1, true, paramString1, 0L, true, paramInt, str2, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, null, j, l, localFileManagerEntity.msgUid, -1L, MessageCache.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      return localFileManagerEntity;
      i = 6;
      break;
      label403:
      j = 2;
      break label63;
      label409:
      if (paramInt == 1006)
      {
        localFileManagerEntity.tmpSessionFromPhone = paramString2;
        localFileManagerEntity.tmpSessionToPhone = paramString3;
        str1 = paramString2;
      }
    }
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbDownLoader == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbDownLoader = new ThumbDownLoader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbDownLoader.a(paramFileManagerEntity, paramInt);
  }
  
  public String a(String paramString, int paramInt, boolean paramBoolean, Object paramObject)
  {
    return a().a(paramString, paramInt, paramBoolean, paramObject);
  }
  
  public String a(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return a().a(paramString1, paramString2, paramInt, paramObject);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a().a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1, paramLong2, paramString, paramInt1, paramInt2);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", null);
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardOfflineFile, nId[" + paramFileManagerEntity.nSessionId + "], type[" + paramInt + "]");
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    if (paramInt == 3000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(106, paramFileManagerEntity);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    paramFileManagerEntity = a().a(paramFileManagerEntity, paramString1, paramString2, paramInt);
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramFileManagerEntity);
    a().a(paramFileManagerEntity, paramInt, false);
  }
  
  public void a(String paramString)
  {
    int i = 0;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_sent_files", 0, 0, "", paramString, "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Succ_upload", 0, 0, "", paramString, String.valueOf(FMDataCache.b().size()), "");
    while (i < FMDataCache.b().size())
    {
      a(((FileInfo)FMDataCache.b().get(i)).c(), paramString);
      i += 1;
    }
    FMDataCache.b();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    a().a(paramString, paramInt1, paramInt2, paramLong);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    a().a(paramString1, paramInt, paramString2);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1, paramString2, paramLong, paramInt2, paramString3, null);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    a(paramLong, paramString, paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a().a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "sendAllSelectedFiles, strSendUin[" + FileManagerUtil.e(paramString1) + "], recvUin[" + FileManagerUtil.e(paramString2) + "], peerType[" + paramInt + "]");
    }
    int i = 0;
    while (i < FMDataCache.e().size())
    {
      b(FileManagerUtil.a((WeiYunFileInfo)FMDataCache.e().get(i)), paramString1, paramString2, paramInt);
      i += 1;
    }
    i = 0;
    Object localObject;
    while (i < FMDataCache.d().size())
    {
      localObject = (OfflineFileInfo)FMDataCache.d().get(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(FileManagerUtil.a((OfflineFileInfo)localObject, paramInt), paramString1, paramString2, paramInt);
      ((FileManagerEntity)localObject).peerType = paramInt;
      ((FileManagerEntity)localObject).status = 2;
      a((FileManagerEntity)localObject, paramInt);
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= FMDataCache.c().size()) {
        break;
      }
      localObject = (FileManagerEntity)FMDataCache.c().get(i);
      FileCategoryUtil.a((FileManagerEntity)localObject);
      a(((FileManagerEntity)localObject).nSessionId, paramString1, paramString2, paramInt, true);
      i += 1;
    }
    while (j < FMDataCache.b().size())
    {
      a(((FileInfo)FMDataCache.b().get(j)).c(), paramString1, paramString2, paramInt, true).strApkPackageName = ((FileInfo)FMDataCache.b().get(j)).b();
      j += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "deleteOfflineFile, peerUin[" + FileManagerUtil.e(paramString1) + "],fileName[" + paramString2 + "],uuid[" + paramString3 + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString3, paramString2, paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
  }
  
  public boolean a(long paramLong)
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "sessionid[" + String.valueOf(paramLong) + "] call Pause");
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "sessionid[" + String.valueOf(paramLong) + "] item is not exist");
      }
      return false;
    }
    if ((localFileManagerEntity.cloudType == 0) && (1 != localFileManagerEntity.nOpType))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      return true;
    }
    FileManagerReporter.fileAssistantReportData localfileAssistantReportData;
    if (1 == localFileManagerEntity.nOpType)
    {
      localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
      localfileAssistantReportData.jdField_a_of_type_JavaLangString = "recv_file_cancel";
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localfileAssistantReportData);
    }
    while ((localFileManagerEntity.peerUin == null) || (localFileManagerEntity.uniseq == -1L))
    {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      if (localFileManagerEntity.nOpType == 0)
      {
        localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
        localfileAssistantReportData.jdField_a_of_type_JavaLangString = "send_file_cancel";
        FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localfileAssistantReportData);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.peerUin, localFileManagerEntity.uniseq, localFileManagerEntity.peerType);
  }
  
  public boolean a(long paramLong, String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why entity is null you can choose!!!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerEngine<FileAssistant>", 2, "Printe FileManagerEntity InfoItem [" + FileManagerUtil.a(localFileManagerEntity) + " ]");
    }
    return a(localFileManagerEntity.strFilePath, paramString);
  }
  
  public boolean a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1);
    paramString = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2, paramString.Uuid, paramString.strTroopFilePath, paramString.fileName, paramString.fileSize, paramString.busId);
    if ((paramString == null) || (paramString.d == null)) {
      return false;
    }
    if (paramInt == 1)
    {
      paramInt = Math.abs(new Random().nextInt());
      TroopFileStatusInfo localTroopFileStatusInfo = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3).a(paramString.d, paramLong2, paramString.jdField_e_of_type_JavaLangString, paramString.jdField_a_of_type_JavaLangString, paramString.b, paramString.jdField_e_of_type_Int, paramInt);
      TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.b, localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString(), paramInt, String.valueOf(paramString.jdField_a_of_type_Long));
      return true;
    }
    return true;
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
    if (localFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why entity is null you can choose!!!");
      }
    }
    label460:
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "Printe FileManagerEntity InfoItem [" + FileManagerUtil.a(localFileManagerEntity) + " ]");
      }
      if ((localFileManagerEntity.cloudType == 2) && (localFileManagerEntity.WeiYunFileId != null) && (paramBoolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerEngine<FileAssistant>", 2, "Send lastOperation list type id weiyun to offlinefile, fileid[" + localFileManagerEntity.WeiYunFileId + "], filename[" + localFileManagerEntity.fileName + "], filename[" + localFileManagerEntity.fileSize + "]");
        }
        FileManagerUtil.b(localFileManagerEntity.nSessionId);
        if ((paramString1 == null) || (paramString1.length() == 0))
        {
          a(localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString2, paramInt);
          return false;
        }
        b(localFileManagerEntity, paramString1, paramString2, paramInt);
        return false;
      }
      if ((localFileManagerEntity.cloudType == 1) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerEngine<FileAssistant>", 2, "cloud is offline,so try offline to offline!, nSessionId[" + paramLong + "], strSendUin[" + FileManagerUtil.e(paramString1) + "], recvUin[" + FileManagerUtil.e(paramString2) + "], peerType[" + paramInt + "], toOffline[" + paramBoolean + "]");
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if ((paramInt == 1004) || (paramInt == 1000)) {
          localObject = paramString1;
        }
        for (;;)
        {
          localObject = a(localFileManagerEntity, (String)localObject, paramString2, paramInt);
          FileManagerUtil.b(((FileManagerEntity)localObject).nSessionId);
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, (FileManagerEntity)localObject);
          if (localFileManagerEntity.peerType != 3000) {
            break label460;
          }
          if (paramInt != 3000) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((FileManagerEntity)localObject, 22);
          return false;
          if (paramInt == 1006) {
            localObject = paramString1;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((FileManagerEntity)localObject, 21);
        return false;
        a((FileManagerEntity)localObject, paramInt);
        return false;
      }
      if (localFileManagerEntity.strFilePath != null)
      {
        if (a(localFileManagerEntity.strFilePath, paramString1, paramString2, paramInt, paramBoolean) != null) {}
        for (paramBoolean = true;; paramBoolean = false) {
          return paramBoolean;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("FileManagerEngine<FileAssistant>", 2, "what's type for this file!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    return false;
  }
  
  public boolean a(String paramString, long paramLong, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong, paramInt);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramString2));
    if (localObject != null)
    {
      int i = Math.abs(new Random().nextInt());
      localObject = ((TroopFileTransferManager)localObject).a(paramString1, true, i);
      paramString1 = new File(paramString1);
      TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1.getName(), paramString1.length(), ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null);
    }
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    QLog.e("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nOperationType[" + paramInt + "]");
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDisc2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", null);
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nId[" + paramFileManagerEntity.nSessionId + "], type[" + paramInt + "]");
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = paramInt;
    int i = 0;
    switch (paramInt)
    {
    }
    while (paramFileManagerEntity.selfUin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
    {
      QLog.e("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nId[" + paramFileManagerEntity.nSessionId + "], type[" + paramInt + "] error");
      if (!QLog.isDevelopLevel()) {
        break;
      }
      throw new NullPointerException("讨论组转发，selfUin不能为自己！！！");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.fileSize, paramFileManagerEntity.selfUin, paramFileManagerEntity.fileName, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5);
      return;
      i = 3;
      continue;
      i = 25;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, i);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 1)
    {
      a().a(paramFileManagerEntity, paramString2);
      return;
    }
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    a(paramFileManagerEntity, str, paramString2, paramInt);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public boolean b(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    boolean bool1;
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "delete record fail. entity is null, sessionid: " + paramLong);
      }
      bool1 = false;
      return bool1;
    }
    if (localFileManagerEntity.cloudType == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    }
    for (;;)
    {
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      bool1 = bool2;
      if (localFileManagerEntity == null) {
        break;
      }
      bool1 = bool2;
      if (!localFileManagerEntity.bDelInAio) {
        break;
      }
      bool1 = bool2;
      if (!localFileManagerEntity.bDelInFM) {
        break;
      }
      bool1 = bool2;
      if (localFileManagerEntity.cloudType != 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity.nSessionId);
      return bool2;
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong)) && (QLog.isColorLevel())) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "Pause[" + String.valueOf(paramLong) + "] faild!,status[" + String.valueOf(localFileManagerEntity.status) + "]");
      }
    }
  }
  
  public void c()
  {
    a().a();
  }
  
  public void c(String paramString)
  {
    a().b(paramString);
  }
  
  public boolean c()
  {
    return a().a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public void e()
  {
    a().b();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileManagerEngine
 * JD-Core Version:    0.7.0.1
 */