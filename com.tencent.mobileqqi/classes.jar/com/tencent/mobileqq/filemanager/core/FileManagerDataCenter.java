package com.tencent.mobileqq.filemanager.core;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fud;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FileManagerDataCenter
{
  static final String jdField_a_of_type_JavaLangString = "FileManagerDataCenter<FileAssistant>";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public FileManagerDataCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private TransFileInfo a(MessageRecord paramMessageRecord)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null)
    {
      localObject1 = localObject2;
      if (localEntityManager != null) {
        localObject1 = (TransFileInfo)localEntityManager.a(TransFileInfo.class, new String[] { String.valueOf(paramMessageRecord.time), String.valueOf(paramMessageRecord.msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramMessageRecord.frienduin });
      }
    }
    if ((localObject1 == null) && (paramMessageRecord != null) && (QLog.isColorLevel())) {
      QLog.e("FileManagerDataCenter<FileAssistant>", 2, "get TransferInfo null, time[" + String.valueOf(paramMessageRecord.time) + "],msgseq[" + String.valueOf(paramMessageRecord.msgseq) + "],uin[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "], frienduin[" + paramMessageRecord.frienduin + "]");
    }
    return localObject1;
  }
  
  public int a(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2, String paramString3, Bundle paramBundle)
  {
    paramInt1 = -1;
    if (paramString2 == null) {}
    for (;;)
    {
      try
      {
        QLog.e("FileManagerDataCenter<FileAssistant>", 1, " insertExternalFileToFM. sourceId:" + paramInt2);
        return paramInt1;
      }
      finally {}
      if ((paramInt2 < 14) || (paramInt2 > 40))
      {
        QLog.e("FileManagerDataCenter<FileAssistant>", 1, " insertExternalFileToFM. error sourceId:" + paramInt2);
      }
      else
      {
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, " insertExternalFileToFM. filePath:" + paramString2 + " size:" + paramLong + " sourceId:" + paramInt2);
        long l = MessageRecordFactory.a(-1000).uniseq;
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, AppConstants.M, 0);
        if (paramString1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. but entry = null");
          }
        }
        else
        {
          paramString1.cloudType = 3;
          paramString1.fileName = FileManagerUtil.a(paramString2);
          if (0L == paramLong) {}
          for (paramString1.fileSize = FileManagerUtil.a(paramString2);; paramString1.fileSize = paramLong)
          {
            paramString1.strFilePath = paramString2;
            paramString1.nOpType = paramInt2;
            paramString1.peerNick = null;
            paramString1.peerType = 0;
            paramString1.peerUin = AppConstants.M;
            paramString1.srvTime = (MessageCache.a() * 1000L);
            paramString1.status = -1;
            paramString1.Uuid = null;
            paramString1.isReaded = true;
            paramString1.bSend = false;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1);
            FileManagerUtil.c(paramString2);
            paramInt1 = 0;
            break;
          }
        }
        paramInt1 = -3;
      }
    }
  }
  
  public long a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt, paramLong1, paramLong2, paramLong3, paramLong4);
  }
  
  public long a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramLong1 <= 0L) {
      return 0L;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, "strUin[" + FileManagerUtil.e(paramString) + "], peeryType[" + String.valueOf(paramInt) + "], uniseq[" + String.valueOf(paramLong2) + "]");
    }
    MessageRecord localMessageRecord = null;
    if (paramLong2 > 0L) {
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, paramLong2);
    }
    if ((localMessageRecord != null) && (localEntityManager != null))
    {
      paramString = (TransFileInfo)localEntityManager.a(TransFileInfo.class, new String[] { String.valueOf(localMessageRecord.time), String.valueOf(localMessageRecord.msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString });
      if (paramString == null) {}
    }
    for (paramLong1 = paramString.transferedSize * 100L / paramLong1;; paramLong1 = 0L)
    {
      localEntityManager.a();
      return paramLong1;
    }
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString3)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramInt2);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localMessageRecord.frienduin = paramString1;
    localMessageRecord.senderuin = paramString2;
    localMessageRecord.msg = paramString3;
    localMessageRecord.msgtype = paramInt2;
    localMessageRecord.isread = true;
    if (paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      localMessageRecord.issend = paramInt2;
      localMessageRecord.istroop = paramInt1;
      localMessageRecord.msgseq = paramLong1;
      localMessageRecord.shmsgseq = paramLong1;
      localMessageRecord.msgUid = paramLong2;
      localMessageRecord.time = MessageCache.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      QLog.i("FileManagerDataCenter<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(localMessageRecord.uniseq) + "], selfuin[" + FileManagerUtil.e(localMessageRecord.selfuin) + "], frienduin[" + FileManagerUtil.e(localMessageRecord.frienduin) + "], senderuin[" + FileManagerUtil.e(localMessageRecord.senderuin) + "], issend[" + String.valueOf(localMessageRecord.issend) + "], istroop[" + String.valueOf(localMessageRecord.istroop) + "], shmsgseq[" + String.valueOf(localMessageRecord.shmsgseq) + "], msgUid[" + String.valueOf(localMessageRecord.msgUid) + "], time[" + String.valueOf(localMessageRecord.time) + "]");
      return localMessageRecord.uniseq;
    }
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramInt2);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localMessageRecord.frienduin = paramString1;
    localMessageRecord.senderuin = paramString2;
    localMessageRecord.msg = paramString3;
    localMessageRecord.msgtype = paramInt2;
    localMessageRecord.isread = true;
    if (paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      localMessageRecord.issend = paramInt2;
      localMessageRecord.istroop = paramInt1;
      paramInt1 = MobileQQService.c;
      MobileQQService.c = paramInt1 + 1;
      localMessageRecord.msgseq = paramInt1;
      localMessageRecord.shmsgseq = Math.abs(new Random().nextInt());
      localMessageRecord.msgUid = FileManagerUtil.b();
      localMessageRecord.time = MessageCache.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      QLog.i("FileManagerDataCenter<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(localMessageRecord.uniseq) + "], selfuin[" + FileManagerUtil.e(localMessageRecord.selfuin) + "], frienduin[" + FileManagerUtil.e(localMessageRecord.frienduin) + "], senderuin[" + FileManagerUtil.e(localMessageRecord.senderuin) + "], issend[" + String.valueOf(localMessageRecord.issend) + "], istroop[" + String.valueOf(localMessageRecord.istroop) + "], shmsgseq[" + String.valueOf(localMessageRecord.shmsgseq) + "], msgUid[" + String.valueOf(localMessageRecord.msgUid) + "], time[" + String.valueOf(localMessageRecord.time) + "]");
      return localMessageRecord.uniseq;
    }
  }
  
  public long a(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, long paramLong1, boolean paramBoolean2, int paramInt1, String paramString4, long paramLong2, long paramLong3, String paramString5, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramString5 = MessageRecordFactory.a(-2005);
    paramString5.uniseq = paramLong4;
    paramString5.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramString5.frienduin = paramString1;
    paramString5.senderuin = paramString2;
    if (paramString4 != null)
    {
      paramString2 = paramString4;
      if (paramString4.length() >= 1) {}
    }
    else
    {
      paramString2 = TransfileUtile.a(paramString3, paramLong1, 0, paramBoolean2);
    }
    paramString5.msg = paramString2;
    paramString5.msgtype = -2005;
    paramString5.isread = paramBoolean2;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      paramString5.issend = paramInt2;
      paramString5.istroop = paramInt1;
      paramString5.msgseq = paramLong2;
      paramLong1 = paramLong3;
      if (paramLong3 == 0L) {
        paramLong1 = Math.abs(new Random().nextInt());
      }
      paramString5.shmsgseq = paramLong1;
      paramString5.msgUid = paramLong5;
      paramString5.time = paramLong7;
      if (paramInt1 == 3000) {
        paramString5.shmsgseq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1).shmsgseq;
      }
      if (!paramString5.isSend()) {
        break label436;
      }
      ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(paramString5);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      QLog.i("FileManagerDataCenter<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(paramString5.uniseq) + "], selfuin[" + FileManagerUtil.e(paramString5.selfuin) + "], frienduin[" + FileManagerUtil.e(paramString5.frienduin) + "], senderuin[" + FileManagerUtil.e(paramString5.senderuin) + "], issend[" + String.valueOf(paramString5.issend) + "], istroop[" + String.valueOf(paramString5.istroop) + "], shmsgseq[" + String.valueOf(paramString5.shmsgseq) + "], msgUid[" + String.valueOf(paramString5.msgUid) + "], time[" + String.valueOf(paramString5.time) + "], vipBubbleID[" + String.valueOf(paramLong6) + "]");
      return paramString5.uniseq;
      paramInt2 = 0;
      break;
      label436:
      if (paramLong6 != -1L) {
        paramString5.vipBubbleID = paramLong6;
      } else {
        paramString5.vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1);
      }
    }
  }
  
  public FileManagerEntity a(long paramLong)
  {
    if (paramLong == -1L)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId nSessionId[" + paramLong + "] is error");
      return null;
    }
    FileManagerProxy localFileManagerProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localFileManagerProxy == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId get FileManagerProxy null! nSessionId[" + paramLong + "]");
      return null;
    }
    FileManagerEntity localFileManagerEntity = localFileManagerProxy.a(paramLong);
    if (localFileManagerEntity != null)
    {
      localFileManagerProxy.a(localFileManagerEntity);
      FileCategoryUtil.a(localFileManagerEntity);
      return localFileManagerEntity;
    }
    localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(FileManagerEntity.class, String.valueOf(paramLong));
    if (localFileManagerEntity != null)
    {
      localFileManagerProxy.a(localFileManagerEntity);
      FileCategoryUtil.a(localFileManagerEntity);
      return localFileManagerEntity;
    }
    QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId get entry null! nSessionId[" + paramLong + "]");
    return null;
  }
  
  public FileManagerEntity a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = a(paramLong1);
    if (localFileManagerEntity != null)
    {
      QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityBySessionid for queryall, FileManagerEntity exist, sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], uniseq[" + String.valueOf(localFileManagerEntity.uniseq) + "], strUin[" + FileManagerUtil.e(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
      return localFileManagerEntity;
    }
    localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = paramLong1;
    localFileManagerEntity.uniseq = paramLong2;
    localFileManagerEntity.peerUin = paramString;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localFileManagerEntity.isReaded = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityBySessionid, new a FileManagerEntity, sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], uniseq[" + String.valueOf(paramLong2) + "], strUin[" + FileManagerUtil.e(paramString) + "], peerType[" + String.valueOf(paramInt) + "]");
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(long paramLong, String paramString, int paramInt)
  {
    if (paramString == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByuniseq  strUin is null, uniseq[" + paramLong + "], peerType[" + paramInt + "]");
      return null;
    }
    if (paramLong <= 0L)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByuniseq uniseq[" + paramLong + "] is error, strUin[" + FileManagerUtil.e(paramString) + "], peerType[" + paramInt + "]");
      return null;
    }
    FileManagerProxy localFileManagerProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localFileManagerProxy == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByuniseq get FileManagerProxy null! strUin[" + FileManagerUtil.e(paramString) + "], uniseq[" + paramLong + "], peerType[" + paramInt + "]");
      return null;
    }
    FileManagerEntity localFileManagerEntity = localFileManagerProxy.a(paramLong, paramString, paramInt);
    if (localFileManagerEntity != null)
    {
      FileCategoryUtil.a(localFileManagerEntity);
      return localFileManagerEntity;
    }
    return localFileManagerProxy.b(paramLong, paramString, paramInt);
  }
  
  public FileManagerEntity a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (-1L != paramLong2) {}
    for (FileManagerEntity localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);; localFileManagerEntity1 = null)
    {
      FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
      if (localFileManagerEntity1 == null)
      {
        localFileManagerEntity2 = localFileManagerEntity1;
        if (paramLong1 > 0L) {
          localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1, paramString, paramInt);
        }
      }
      if (localFileManagerEntity2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, "why sessionId[" + String.valueOf(paramLong2) + "] and uniseq[" + String.valueOf(paramLong1) + "] is wrong");
        }
        return null;
      }
      return localFileManagerEntity2;
    }
  }
  
  public FileManagerEntity a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
  }
  
  public FileManagerEntity a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByOLfileSessionId get FileManagerProxy null! nOLfileSessionId[" + paramLong + "]");
      return null;
    }
    FileManagerEntity localFileManagerEntity1 = ((FileManagerProxy)localObject).a(paramString, paramLong);
    if (localFileManagerEntity1 != null) {
      return localFileManagerEntity1;
    }
    localObject = "select * from " + FileManagerEntity.tableName() + " where (nOLfileSessionId = " + paramLong + " or (nSessionId = " + paramLong + " and nOLfileSessionId = 0)) order by srvTime desc";
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localObject = localEntityManager.a(FileManagerEntity.class, (String)localObject, null);
    FileManagerEntity localFileManagerEntity2;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      Iterator localIterator = ((List)localObject).iterator();
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localFileManagerEntity2 = (FileManagerEntity)localIterator.next();
        } while (!paramString.equalsIgnoreCase(localFileManagerEntity2.peerUin));
        localObject = localFileManagerEntity2;
        if (paramLong == localFileManagerEntity2.nOLfileSessionId) {
          break;
        }
      } while ((paramLong != localFileManagerEntity2.nSessionId) || (0L != localFileManagerEntity2.nOLfileSessionId));
    }
    for (localObject = localFileManagerEntity2;; localObject = localFileManagerEntity1)
    {
      if ((localObject != null) && (0L == ((FileManagerEntity)localObject).nOLfileSessionId))
      {
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, "QueryOLfileSessionEntity find a old ver data. nOLfileSessionId[" + paramLong + "]");
        ((FileManagerEntity)localObject).nOLfileSessionId = paramLong;
        c((FileManagerEntity)localObject);
      }
      localEntityManager.a();
      return localObject;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 0, null);
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    FileManagerEntity localFileManagerEntity = a(paramLong);
    if (localFileManagerEntity == null)
    {
      QLog.w("FileManagerDataCenter<FileAssistant>", 2, "sessionnid[" + String.valueOf(paramLong) + "] item is not exist!may be is deleted!");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, paramString);
  }
  
  public void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    FileManagerEntity localFileManagerEntity = a(paramLong1, paramString, paramInt, -1L);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "updateFileManagerTime error, entity is null,uinseq[" + String.valueOf(paramLong1) + "], frienduin[" + String.valueOf(paramString) + "], istroop[" + String.valueOf(paramInt) + "], time[" + String.valueOf(paramLong2) + "]");
      }
      return;
    }
    localFileManagerEntity.srvTime = (1000L * paramLong2);
    c(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
  }
  
  protected void a(MessageRecord paramMessageRecord, String paramString1, long paramLong, int paramInt, String paramString2, String paramString3)
  {
    paramMessageRecord = a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (paramMessageRecord != null)
    {
      paramMessageRecord.fProgress = ((float)paramLong / (float)paramMessageRecord.fileSize);
      paramMessageRecord.status = FileManagerUtil.c(paramInt);
      if (paramMessageRecord.status == 0) {
        paramMessageRecord.isReaded = false;
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        a();
        c(paramMessageRecord);
        return;
        if (paramMessageRecord.status == 1) {
          paramMessageRecord.fProgress = 0.0F;
        }
      }
    }
    if ("strUin[" + FileManagerUtil.e(paramString1) + "], mtransferedSize[" + String.valueOf(paramLong) + "], status[" + String.valueOf(paramInt) + "], strUuid[" + paramString2 + "], strFileId[" + paramString3 == null) {}
    for (paramMessageRecord = "null";; paramMessageRecord = paramString3 + "] entry == null ??")
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 2, paramMessageRecord);
      return;
    }
  }
  
  /* Error */
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 201	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/data/FileManagerProxy;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnonnull +68 -> 79
    //   14: ldc 8
    //   16: iconst_1
    //   17: new 68	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 501
    //   27: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: getfield 368	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   34: invokevirtual 105	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: ldc 217
    //   39: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: getfield 369	com/tencent/mobileqq/filemanager/data/FileManagerEntity:uniseq	J
    //   46: invokevirtual 105	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: ldc_w 503
    //   52: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 167	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   59: invokestatic 210	com/tencent/mobileqq/filemanager/util/FileManagerUtil:e	(Ljava/lang/String;)Ljava/lang/String;
    //   62: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc 83
    //   67: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: ldc 8
    //   81: iconst_2
    //   82: new 68	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 505
    //   92: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_1
    //   96: invokestatic 508	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)Ljava/lang/String;
    //   99: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 110	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_2
    //   109: aload_1
    //   110: invokevirtual 510	com/tencent/mobileqq/filemanager/data/FileManagerProxy:b	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   113: aload_0
    //   114: getfield 19	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   117: invokevirtual 452	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   120: iconst_1
    //   121: iconst_3
    //   122: aconst_null
    //   123: invokevirtual 457	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(ZILjava/lang/Object;)V
    //   126: goto -50 -> 76
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	FileManagerDataCenter
    //   0	134	1	paramFileManagerEntity	FileManagerEntity
    //   9	100	2	localFileManagerProxy	FileManagerProxy
    // Exception table:
    //   from	to	target	type
    //   2	10	129	finally
    //   14	76	129	finally
    //   79	126	129	finally
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "Save of2of [" + String.valueOf(paramBoolean) + "],query FileManagerEntity renturn null, SessionId[" + String.valueOf(paramLong) + "], ");
      }
      return;
    }
    if (paramBoolean)
    {
      localFileManagerEntity.lastTime = (MessageCache.a() * 1000L + 604800000L);
      localFileManagerEntity.isReaded = false;
      localFileManagerEntity.bSend = true;
      localFileManagerEntity.status = 1;
      localFileManagerEntity.fProgress = 0.0F;
      localFileManagerEntity.Uuid = paramString2;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      localFileManagerEntity.status = 2;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      FileManagerUtil.b(localFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 6, "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.peerUin, localFileManagerEntity, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 15, null, paramInt, paramString1);
    localFileManagerEntity.isReaded = false;
    localFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", localFileManagerEntity.peerUin, localFileManagerEntity.Uuid, paramInt, paramString1, 0L, 0L, 0L, "", "", 0, paramString1, null);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    Object localObject2 = a(paramLong);
    if (localObject2 == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, "strUin[" + FileManagerUtil.e(((FileManagerEntity)localObject2).peerUin) + "], peeryType[" + String.valueOf(((FileManagerEntity)localObject2).peerType) + "], uniseq[" + String.valueOf(((FileManagerEntity)localObject2).uniseq) + "]");
    }
    Object localObject1 = null;
    if (-1L != ((FileManagerEntity)localObject2).uniseq) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType, ((FileManagerEntity)localObject2).uniseq);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localObject1 = a((MessageRecord)localObject1);
    if ((localObject2 != null) && (localObject2 != null) && (localObject1 != null))
    {
      ((TransFileInfo)localObject1).status = paramInt;
      ((EntityManager)localObject2).a((Entity)localObject1);
      return true;
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    Object localObject2 = a(paramLong1);
    if (localObject2 == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, "strUin[" + FileManagerUtil.e(((FileManagerEntity)localObject2).peerUin) + "], peeryType[" + String.valueOf(((FileManagerEntity)localObject2).peerType) + "], uniseq[" + String.valueOf(((FileManagerEntity)localObject2).uniseq) + "]");
    }
    Object localObject1 = null;
    if (-1L != ((FileManagerEntity)localObject2).uniseq) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType, ((FileManagerEntity)localObject2).uniseq);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localObject1 = a((MessageRecord)localObject1);
    if ((localObject2 != null) && (localObject1 != null))
    {
      ((TransFileInfo)localObject1).transferedSize = paramLong2;
      ((EntityManager)localObject2).a((Entity)localObject1);
      return true;
    }
    return false;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, "setFMDelete FileManagerEntity is null!!!");
        }
        bool = false;
        return bool;
      }
      finally {}
      paramFileManagerEntity.bDelInFM = true;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, true);
    }
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, "SetRead: strUin[" + FileManagerUtil.e(paramString) + "], peeryType[" + paramInt + "], uniseq[" + paramLong + "]");
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, paramLong);
    if (paramString != null)
    {
      paramString.isread = true;
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong);
  }
  
  public FileManagerEntity b(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
  }
  
  public FileManagerEntity b(long paramLong, String paramString, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject == null) {
      return null;
    }
    if (paramLong > 0L)
    {
      FileManagerEntity localFileManagerEntity = ((FileManagerProxy)localObject).a(paramLong, paramString, paramInt);
      if (localFileManagerEntity != null)
      {
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByuniseq for memory, FileManagerEntity exist, sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], uniseq[" + String.valueOf(localFileManagerEntity.uniseq) + "], strUin[" + FileManagerUtil.e(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
        return localFileManagerEntity;
      }
      localObject = ((FileManagerProxy)localObject).b(paramLong, paramString, paramInt);
      if (localObject != null)
      {
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByuniseq for db, FileManagerEntity exist, sessionId[" + String.valueOf(((FileManagerEntity)localObject).nSessionId) + "], uniseq[" + String.valueOf(((FileManagerEntity)localObject).uniseq) + "], strUin[" + FileManagerUtil.e(((FileManagerEntity)localObject).peerUin) + "], peerType[" + String.valueOf(((FileManagerEntity)localObject).peerType) + "]");
        return localObject;
      }
    }
    localObject = new FileManagerEntity();
    ((FileManagerEntity)localObject).nSessionId = FileManagerUtil.a().longValue();
    ((FileManagerEntity)localObject).uniseq = paramLong;
    ((FileManagerEntity)localObject).peerUin = paramString;
    ((FileManagerEntity)localObject).peerType = paramInt;
    ((FileManagerEntity)localObject).selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((FileManagerEntity)localObject).isReaded = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject);
    QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByuniseq, new a FileManagerEntity, sessionId[" + String.valueOf(((FileManagerEntity)localObject).nSessionId) + "], uniseq[" + String.valueOf(paramLong) + "], strUin[" + FileManagerUtil.e(paramString) + "], peerType[" + String.valueOf(paramInt) + "]");
    return localObject;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d();
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      FileManagerProxy localFileManagerProxy;
      try
      {
        localFileManagerProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (localFileManagerProxy == null)
        {
          QLog.e("FileManagerDataCenter<FileAssistant>", 1, "insertToFMListAddOrReplaceDB get FileManagerProxy null! nSessionId[" + paramFileManagerEntity.nSessionId + "], uniseq[" + paramFileManagerEntity.uniseq + "], peerUin[" + FileManagerUtil.e(paramFileManagerEntity.peerUin) + "]");
          return;
        }
        if ((FileManagerEntity)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(FileManagerEntity.class, String.valueOf(paramFileManagerEntity.nSessionId)) == null)
        {
          localFileManagerProxy.b(paramFileManagerEntity);
          continue;
        }
        localFileManagerProxy.c(paramFileManagerEntity);
      }
      finally {}
      localFileManagerProxy.e(paramFileManagerEntity);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, "setAioDelete FileManagerEntity is null!!!");
        }
        bool = false;
        return bool;
      }
      finally {}
      paramFileManagerEntity.bDelInAio = true;
      paramFileManagerEntity.uniseq = -1L;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, true);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramFileManagerEntity);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null))
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new fud(this);
      }
      IntentFilter localIntentFilter = new IntentFilter("com.opensdk.downloadmanager.renameFilename");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  public void d(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter
 * JD-Core Version:    0.7.0.1
 */