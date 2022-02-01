import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.1;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.2;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.3;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class agkf
{
  public QQAppInterface app;
  private agku b;
  private BroadcastReceiver be;
  
  public agkf(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private TransFileInfo a(MessageRecord paramMessageRecord)
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null)
    {
      localObject1 = localObject2;
      if (localEntityManager != null) {
        localObject1 = (TransFileInfo)localEntityManager.find(TransFileInfo.class, new String[] { String.valueOf(paramMessageRecord.time), String.valueOf(paramMessageRecord.msgseq), this.app.getCurrentAccountUin(), paramMessageRecord.frienduin });
      }
    }
    if ((localObject1 == null) && (paramMessageRecord != null) && (QLog.isColorLevel())) {
      QLog.e("FileManagerDataCenter<FileAssistant>", 2, "get TransferInfo null, time[" + String.valueOf(paramMessageRecord.time) + "],msgseq[" + String.valueOf(paramMessageRecord.msgseq) + "],uin[" + this.app.getCurrentAccountUin() + "], frienduin[" + paramMessageRecord.frienduin + "]");
    }
    return localObject1;
  }
  
  private void cz(Bundle paramBundle)
  {
    ThreadManager.executeOnSubThread(new FileManagerDataCenter.2(this, paramBundle));
  }
  
  public int a(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2, String paramString3, Bundle paramBundle)
  {
    if (paramString2 == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. sourceId:" + paramInt2);
        }
        paramInt1 = -1;
        return paramInt1;
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. filePath:" + paramString2 + " size:" + paramLong + " sourceId:" + paramInt2);
      }
      if (this.app == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. but app = null");
        }
      }
      else
      {
        long l = anbi.d(-1000).uniseq;
        paramString1 = this.app.a().b(l, acbn.bks, 0);
        if (paramString1 == null)
        {
          if (!QLog.isColorLevel()) {
            break label443;
          }
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. but entry = null");
          break label443;
        }
        paramString1.setCloudType(3);
        paramString1.fileName = ahav.getFileName(paramString2);
        if (0L == paramLong)
        {
          paramString1.fileSize = ahav.getFileSizes(paramString2);
          paramString1.setFilePath(paramString2);
          paramString1.nOpType = paramInt2;
          paramString1.peerNick = null;
          paramString1.peerType = 0;
          paramString1.peerUin = acbn.bks;
          paramString1.srvTime = (anaz.gQ() * 1000L);
          paramString1.status = 1;
          paramString1.Uuid = null;
          paramString1.isReaded = true;
          paramString1.bSend = false;
          if (paramBundle != null)
          {
            if (paramBundle.getBoolean("FILE_TMP_IS_ZIPINNER_FILE"))
            {
              paramString3 = paramBundle.getString("FILE_TMP_SERVER_PATH");
              String str = paramBundle.getString("FILE_TMP_DIR_PATH");
              paramLong = paramBundle.getLong("FILE_TMP_RELATED_ID");
              paramBundle = paramBundle.getString("FILE_TMP_ZIP_FILEID");
              paramString1.isZipInnerFile = true;
              paramString1.nRelatedSessionId = paramLong;
              paramString1.zipInnerPath = str;
              paramString1.strServerPath = paramString3;
              paramString1.zipFileId = paramBundle;
              this.app.a().D(paramString1);
            }
          }
          else
          {
            this.app.a().s(paramString1);
            ahav.cZ(paramString2);
            paramInt1 = 0;
          }
        }
        else
        {
          paramString1.fileSize = paramLong;
          continue;
        }
        paramString3 = paramBundle.getString("FILE_TMP_SERVER_PATH");
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString1.status = 1;
          paramString1.strServerPath = paramString3;
          paramString1.bDelInAio = true;
        }
        paramInt1 = paramBundle.getInt("FILE_FROM", -1);
        if (paramInt1 == -1) {
          continue;
        }
        paramString1.nOpType = paramInt1;
        continue;
      }
      paramInt1 = -2;
      continue;
      label443:
      paramInt1 = -3;
    }
  }
  
  public long a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return this.app.a().a(paramInt, paramLong1, paramLong2, paramLong3, paramLong4);
  }
  
  public long a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramLong1 <= 0L) {
      return 0L;
    }
    EntityManager localEntityManager = this.app.a().createEntityManager();
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, "strUin[" + ahav.kZ(paramString) + "], peeryType[" + String.valueOf(paramInt) + "], uniseq[" + String.valueOf(paramLong2) + "]");
    }
    MessageRecord localMessageRecord = null;
    if (paramLong2 > 0L) {
      localMessageRecord = this.app.b().b(paramString, paramInt, paramLong2);
    }
    if ((localMessageRecord != null) && (localEntityManager != null))
    {
      paramString = (TransFileInfo)localEntityManager.find(TransFileInfo.class, new String[] { String.valueOf(localMessageRecord.time), String.valueOf(localMessageRecord.msgseq), this.app.getCurrentAccountUin(), paramString });
      if (paramString == null) {}
    }
    for (paramLong1 = paramString.transferedSize * 100L / paramLong1;; paramLong1 = 0L)
    {
      localEntityManager.close();
      return paramLong1;
    }
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    return a(paramString1, paramString2, paramInt1, paramInt2, null, paramString3, -1L, -1L, -1L);
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, int paramInt2, Map<String, String> paramMap, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    MessageRecord localMessageRecord = anbi.d(paramInt2);
    localMessageRecord.selfuin = this.app.getCurrentAccountUin();
    localMessageRecord.frienduin = paramString1;
    localMessageRecord.senderuin = paramString2;
    localMessageRecord.msg = paramString3;
    localMessageRecord.msgtype = paramInt2;
    localMessageRecord.isread = true;
    long l;
    if (paramString2.equals(this.app.getAccount()))
    {
      paramInt2 = 1;
      localMessageRecord.issend = paramInt2;
      localMessageRecord.istroop = paramInt1;
      if (paramLong2 <= 0L) {
        break label214;
      }
      l = paramLong2;
      label92:
      localMessageRecord.msgseq = l;
      if (paramLong2 <= 0L) {
        break label231;
      }
      label106:
      localMessageRecord.shmsgseq = paramLong2;
      if (paramLong1 <= 0L) {
        break label250;
      }
      label120:
      localMessageRecord.msgUid = paramLong1;
      if (paramLong3 <= 0L) {
        break label258;
      }
    }
    for (;;)
    {
      localMessageRecord.time = paramLong3;
      if ((paramMap == null) || (paramMap.size() <= 0)) {
        break label266;
      }
      paramString1 = paramMap.keySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        localMessageRecord.saveExtInfoToExtStr(paramString2, (String)paramMap.get(paramString2));
      }
      paramInt2 = 0;
      break;
      label214:
      paramInt1 = amzo.seq;
      amzo.seq = paramInt1 + 1;
      l = paramInt1;
      break label92;
      label231:
      paramLong2 = Math.abs(new Random().nextInt());
      break label106;
      label250:
      paramLong1 = ahav.ge();
      break label120;
      label258:
      paramLong3 = anaz.gQ();
    }
    label266:
    localMessageRecord.extraflag |= 0xFFFF7FFF;
    this.app.b().b(localMessageRecord, this.app.getCurrentAccountUin());
    QLog.i("FileManagerDataCenter<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(localMessageRecord.uniseq) + "], selfuin[" + ahav.kZ(localMessageRecord.selfuin) + "], frienduin[" + ahav.kZ(localMessageRecord.frienduin) + "], senderuin[" + ahav.kZ(localMessageRecord.senderuin) + "], issend[" + String.valueOf(localMessageRecord.issend) + "], istroop[" + String.valueOf(localMessageRecord.istroop) + "], shmsgseq[" + String.valueOf(localMessageRecord.shmsgseq) + "], msgUid[" + String.valueOf(localMessageRecord.msgUid) + "], time[" + String.valueOf(localMessageRecord.time) + "], msgtype[" + String.valueOf(paramString3) + "]");
    return localMessageRecord.uniseq;
  }
  
  public long a(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, long paramLong1, boolean paramBoolean2, int paramInt1, String paramString4, long paramLong2, long paramLong3, String paramString5, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return a(paramString1, paramString2, paramBoolean1, paramString3, paramLong1, paramBoolean2, paramInt1, paramString4, paramLong2, paramLong3, paramString5, paramInt2, paramLong4, paramLong5, paramLong6, paramLong7, -1);
  }
  
  public long a(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, long paramLong1, boolean paramBoolean2, int paramInt1, String paramString4, long paramLong2, long paramLong3, String paramString5, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt3)
  {
    MessageRecord localMessageRecord = anbi.d(-2005);
    localMessageRecord.uniseq = paramLong4;
    localMessageRecord.selfuin = this.app.getCurrentAccountUin();
    localMessageRecord.frienduin = paramString1;
    localMessageRecord.senderuin = paramString2;
    if (paramString4 != null)
    {
      paramString5 = paramString4;
      if (paramString4.length() >= 1) {}
    }
    else
    {
      paramString5 = aoon.a(paramString3, paramLong1, 0, paramBoolean2);
    }
    localMessageRecord.msg = paramString5;
    localMessageRecord.msgtype = -2005;
    localMessageRecord.isread = paramBoolean2;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      localMessageRecord.issend = paramInt2;
      localMessageRecord.istroop = paramInt1;
      localMessageRecord.msgseq = paramLong2;
      localMessageRecord.shmsgseq = anbk.d(paramLong2, paramInt1);
      paramLong1 = paramLong5;
      if (paramLong5 == 0L) {
        paramLong1 = anbk.I(anbk.Ji());
      }
      localMessageRecord.msgUid = paramLong1;
      localMessageRecord.time = paramLong7;
      if (paramInt1 == 3000) {
        localMessageRecord.shmsgseq = this.app.b().a(paramString1, paramInt1).shmsgseq;
      }
      if (!localMessageRecord.isSend()) {
        break label495;
      }
      ((acle)this.app.getBusinessHandler(13)).W(localMessageRecord);
    }
    for (;;)
    {
      localMessageRecord.vipBubbleDiyTextId = paramInt3;
      if (TextUtils.isEmpty(((MessageForFile)localMessageRecord).fileName)) {
        ((MessageForFile)localMessageRecord).fileName = ahav.getFileName(paramString3);
      }
      this.app.b().b(localMessageRecord, this.app.getCurrentAccountUin());
      ahav.j(this.app, paramString2, paramString1, paramInt1);
      QLog.i("FileManagerDataCenter<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(localMessageRecord.uniseq) + "], selfuin[" + ahav.kZ(localMessageRecord.selfuin) + "], frienduin[" + ahav.kZ(localMessageRecord.frienduin) + "], senderuin[" + ahav.kZ(localMessageRecord.senderuin) + "], issend[" + String.valueOf(localMessageRecord.issend) + "], istroop[" + String.valueOf(localMessageRecord.istroop) + "], shmsgseq[" + String.valueOf(localMessageRecord.shmsgseq) + "], msgUid[" + String.valueOf(localMessageRecord.msgUid) + "], time[" + String.valueOf(localMessageRecord.time) + "], vipBubbleID[" + String.valueOf(paramLong6) + "], vipBubbleDiyTextID[" + String.valueOf(paramInt3) + "]");
      return localMessageRecord.uniseq;
      paramInt2 = 0;
      break;
      label495:
      if (paramLong6 != -1L) {
        localMessageRecord.vipBubbleID = paramLong6;
      } else {
        localMessageRecord.vipBubbleID = this.app.b().S(paramString1);
      }
    }
  }
  
  public agku a()
  {
    if (this.b == null) {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "getTmpController mTmpController is null");
    }
    for (;;)
    {
      agku localagku = this.b;
      this.b = null;
      return localagku;
      QLog.d("FileManagerDataCenter<FileAssistant>", 1, "getTmpController " + this.b.getClass().getName());
    }
  }
  
  public FileManagerEntity a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = b(paramLong1);
    if (localFileManagerEntity != null)
    {
      QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityBySessionid for queryall, FileManagerEntity exist, sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], uniseq[" + String.valueOf(localFileManagerEntity.uniseq) + "], strUin[" + ahav.kZ(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
      return localFileManagerEntity;
    }
    localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = paramLong1;
    localFileManagerEntity.uniseq = paramLong2;
    localFileManagerEntity.peerUin = paramString;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.selfUin = this.app.getAccount();
    localFileManagerEntity.isReaded = false;
    this.app.a().v(localFileManagerEntity);
    QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityBySessionid, new a FileManagerEntity, sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], uniseq[" + String.valueOf(paramLong2) + "], strUin[" + ahav.kZ(paramString) + "], peerType[" + String.valueOf(paramInt) + "]");
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
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByuniseq uniseq[" + paramLong + "] is error, strUin[" + ahav.kZ(paramString) + "], peerType[" + paramInt + "]");
      return null;
    }
    agne localagne = this.app.a();
    if (localagne == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByuniseq get FileManagerProxy null! strUin[" + ahav.kZ(paramString) + "], uniseq[" + paramLong + "], peerType[" + paramInt + "]");
      return null;
    }
    FileManagerEntity localFileManagerEntity = localagne.c(paramLong, paramString, paramInt);
    if (localFileManagerEntity != null)
    {
      ahap.G(localFileManagerEntity);
      return localFileManagerEntity;
    }
    return localagne.d(paramLong, paramString, paramInt);
  }
  
  public FileManagerEntity a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (-1L != paramLong2) {}
    for (FileManagerEntity localFileManagerEntity1 = this.app.a().b(paramLong2);; localFileManagerEntity1 = null)
    {
      FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
      if (localFileManagerEntity1 == null)
      {
        localFileManagerEntity2 = localFileManagerEntity1;
        if (paramLong1 > 0L) {
          localFileManagerEntity2 = this.app.a().a(paramLong1, paramString, paramInt);
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
    return this.app.a().a(paramString);
  }
  
  public FileManagerEntity a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      return null;
    }
    Object localObject = this.app.a();
    if (localObject == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByOLfileSessionId get FileManagerProxy null! nOLfileSessionId[" + paramLong + "]");
      return null;
    }
    FileManagerEntity localFileManagerEntity1 = ((agne)localObject).b(paramString, paramLong);
    if (localFileManagerEntity1 != null) {
      return localFileManagerEntity1;
    }
    localObject = "select * from " + FileManagerEntity.tableName() + " where (nOLfileSessionId = " + paramLong + " or (nSessionId = " + paramLong + " and nOLfileSessionId = 0)) order by srvTime desc";
    EntityManager localEntityManager = this.app.a().createEntityManager();
    localObject = localEntityManager.rawQuery(FileManagerEntity.class, (String)localObject, null);
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
        u((FileManagerEntity)localObject);
      }
      localEntityManager.close();
      return localObject;
    }
  }
  
  public List<FileManagerEntity> a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return this.app.a().b(paramString1, paramString2, paramBoolean);
  }
  
  public void a(agku paramagku)
  {
    QLog.d("FileManagerDataCenter<FileAssistant>", 1, "regTmpController" + paramagku.getClass().getName());
    this.b = paramagku;
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.app.a().b(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "Save of2of [" + String.valueOf(paramBoolean1) + "],query FileManagerEntity renturn null, SessionId[" + String.valueOf(paramLong) + "], ");
      }
      return;
    }
    if (paramBoolean1)
    {
      localFileManagerEntity.lastTime = (anaz.gQ() * 1000L + 604800000L);
      localFileManagerEntity.isReaded = false;
      localFileManagerEntity.bSend = true;
      localFileManagerEntity.status = 1;
      localFileManagerEntity.fProgress = 0.0F;
      localFileManagerEntity.Uuid = paramString2;
      localFileManagerEntity.bUseMediaPlatform = paramBoolean2;
      localFileManagerEntity.fileIdCrc = paramString3;
      this.app.a().u(localFileManagerEntity);
      localFileManagerEntity.status = 2;
      this.app.a().dhl();
      ahav.jR(localFileManagerEntity.nSessionId);
      this.app.a().a(localFileManagerEntity, 6, "");
      this.app.a().a(localFileManagerEntity.peerUin, localFileManagerEntity, null);
      return;
    }
    this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 15, null, paramInt, paramString1);
    localFileManagerEntity.isReaded = false;
    localFileManagerEntity.status = 0;
    if ((paramInt == -6101) || (paramInt == -7003))
    {
      localFileManagerEntity.status = 16;
      if ((localFileManagerEntity.mContext != null) && ((localFileManagerEntity.mContext instanceof FileManagerEntity)))
      {
        paramString2 = (FileManagerEntity)localFileManagerEntity.mContext;
        paramString2.status = 16;
        this.app.a().u(paramString2);
        localFileManagerEntity.mContext = null;
      }
    }
    this.app.a().u(localFileManagerEntity);
    this.app.a().dhl();
    ahav.a(this.app, localFileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", "", localFileManagerEntity.peerUin, localFileManagerEntity.Uuid, paramInt, paramString1, 0L, 0L, 0L, "", "", 0, paramString1, null);
  }
  
  public void aIH()
  {
    this.app.a().aIH();
  }
  
  public void aoq()
  {
    ThreadManager.executeOnSubThread(new FileManagerDataCenter.3(this));
  }
  
  public void ap(long paramLong, String paramString)
  {
    FileManagerEntity localFileManagerEntity = b(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerDataCenter<FileAssistant>", 2, "sessionnid[" + String.valueOf(paramLong) + "] item is not exist!may be is deleted!");
      }
      return;
    }
    this.app.a().a(localFileManagerEntity, paramString);
  }
  
  public void aq(long paramLong, String paramString)
  {
    this.app.a().aq(paramLong, paramString);
  }
  
  public FileManagerEntity b(long paramLong)
  {
    if (paramLong == -1L)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId nSessionId[" + paramLong + "] is error");
      return null;
    }
    agne localagne = this.app.a();
    if (localagne == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId get FileManagerProxy null! nSessionId[" + paramLong + "]");
      return null;
    }
    FileManagerEntity localFileManagerEntity = localagne.d(paramLong);
    if (localFileManagerEntity != null)
    {
      localagne.v(localFileManagerEntity);
      ahap.G(localFileManagerEntity);
      return localFileManagerEntity;
    }
    localFileManagerEntity = (FileManagerEntity)this.app.a().createEntityManager().find(FileManagerEntity.class, String.valueOf(paramLong));
    if (localFileManagerEntity != null)
    {
      localagne.v(localFileManagerEntity);
      ahap.G(localFileManagerEntity);
      return localFileManagerEntity;
    }
    QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId get entry null! nSessionId[" + paramLong + "]");
    return null;
  }
  
  public FileManagerEntity b(long paramLong, String paramString, int paramInt)
  {
    Object localObject = this.app.a();
    if (localObject == null) {
      return null;
    }
    if (paramLong > 0L)
    {
      FileManagerEntity localFileManagerEntity = ((agne)localObject).c(paramLong, paramString, paramInt);
      if (localFileManagerEntity != null)
      {
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByuniseq for memory, FileManagerEntity exist, sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], uniseq[" + String.valueOf(localFileManagerEntity.uniseq) + "], strUin[" + ahav.kZ(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
        return localFileManagerEntity;
      }
      localObject = ((agne)localObject).d(paramLong, paramString, paramInt);
      if (localObject != null)
      {
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByuniseq for db, FileManagerEntity exist, sessionId[" + String.valueOf(((FileManagerEntity)localObject).nSessionId) + "], uniseq[" + String.valueOf(((FileManagerEntity)localObject).uniseq) + "], strUin[" + ahav.kZ(((FileManagerEntity)localObject).peerUin) + "], peerType[" + String.valueOf(((FileManagerEntity)localObject).peerType) + "]");
        return localObject;
      }
    }
    localObject = new FileManagerEntity();
    ((FileManagerEntity)localObject).nSessionId = ahav.d().longValue();
    ((FileManagerEntity)localObject).uniseq = paramLong;
    ((FileManagerEntity)localObject).peerUin = paramString;
    ((FileManagerEntity)localObject).peerType = paramInt;
    ((FileManagerEntity)localObject).selfUin = this.app.getAccount();
    ((FileManagerEntity)localObject).isReaded = false;
    this.app.a().v((FileManagerEntity)localObject);
    QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByuniseq, new a FileManagerEntity, sessionId[" + String.valueOf(((FileManagerEntity)localObject).nSessionId) + "], uniseq[" + String.valueOf(paramLong) + "], strUin[" + ahav.kZ(paramString) + "], peerType[" + String.valueOf(paramInt) + "]");
    return localObject;
  }
  
  public FileManagerEntity b(String paramString)
  {
    return this.app.a().b(paramString);
  }
  
  public FileManagerEntity c(long paramLong)
  {
    return this.app.a().d(paramLong);
  }
  
  public FileManagerEntity c(String paramString)
  {
    return this.app.a().c(paramString);
  }
  
  public boolean cb(long paramLong)
  {
    return this.app.a().cb(paramLong);
  }
  
  public FileManagerEntity d(String paramString)
  {
    return this.app.a().d(paramString);
  }
  
  public List<FileManagerEntity> d(String paramString, long paramLong)
  {
    return this.app.a().d(paramString, paramLong);
  }
  
  public List<FileManagerEntity> d(List<Integer> paramList, String paramString)
  {
    return this.app.a().f(paramList, paramString);
  }
  
  public void d(long paramLong1, String paramString, int paramInt, long paramLong2)
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
    u(localFileManagerEntity);
    this.app.a().b(true, 3, null);
  }
  
  public boolean d(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, "SetRead: strUin[" + ahav.kZ(paramString) + "], peeryType[" + paramInt + "], uniseq[" + paramLong + "]");
    }
    paramString = this.app.b().b(paramString, paramInt, paramLong);
    if (paramString != null)
    {
      paramString.isread = true;
      return true;
    }
    return false;
  }
  
  public void dgm()
  {
    this.app.a().dgm();
  }
  
  public void dhl()
  {
    this.app.a().b(true, 0, null);
  }
  
  public void dhm()
  {
    ThreadManager.executeOnSubThread(new FileManagerDataCenter.1(this));
  }
  
  public void dhn()
  {
    this.app.a().dit();
  }
  
  public FileManagerEntity e(String paramString)
  {
    return this.app.a().k(paramString);
  }
  
  public List<FileManagerEntity> e(List<Integer> paramList, String paramString)
  {
    return this.app.a().g(paramList, paramString);
  }
  
  public void eE(String paramString, int paramInt)
  {
    this.app.a().eG(paramString, paramInt);
  }
  
  public void jo(long paramLong)
  {
    try
    {
      this.app.a().jo(paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean k(FileManagerEntity paramFileManagerEntity)
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
      boolean bool = this.app.a().b(paramFileManagerEntity, true);
    }
  }
  
  public boolean l(FileManagerEntity paramFileManagerEntity)
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
      boolean bool = this.app.a().b(paramFileManagerEntity, true);
    }
  }
  
  public boolean o(long paramLong, int paramInt)
  {
    Object localObject2 = b(paramLong);
    if (localObject2 == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, "strUin[" + ahav.kZ(((FileManagerEntity)localObject2).peerUin) + "], peeryType[" + String.valueOf(((FileManagerEntity)localObject2).peerType) + "], uniseq[" + String.valueOf(((FileManagerEntity)localObject2).uniseq) + "]");
    }
    Object localObject1 = null;
    if (-1L != ((FileManagerEntity)localObject2).uniseq) {
      localObject1 = this.app.b().b(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType, ((FileManagerEntity)localObject2).uniseq);
    }
    localObject2 = this.app.a().createEntityManager();
    localObject1 = a((MessageRecord)localObject1);
    if ((localObject2 != null) && (localObject2 != null) && (localObject1 != null))
    {
      ((TransFileInfo)localObject1).status = paramInt;
      ((EntityManager)localObject2).update((Entity)localObject1);
      return true;
    }
    return false;
  }
  
  public Map<String, List<FileManagerEntity>> p(String paramString)
  {
    return this.app.a().q(paramString);
  }
  
  public boolean r(String paramString, long paramLong)
  {
    return this.app.a().r(paramString, paramLong);
  }
  
  /* Error */
  public void s(FileManagerEntity paramFileManagerEntity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	agkf:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 258	com/tencent/mobileqq/app/QQAppInterface:a	()Lagne;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnonnull +69 -> 80
    //   14: ldc 74
    //   16: iconst_1
    //   17: new 76	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 817
    //   27: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: getfield 530	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   34: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: ldc_w 302
    //   40: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: getfield 531	com/tencent/mobileqq/filemanager/data/FileManagerEntity:uniseq	J
    //   47: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   50: ldc_w 819
    //   53: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: getfield 194	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   60: invokestatic 295	ahav:kZ	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 91
    //   68: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +32 -> 115
    //   86: ldc 74
    //   88: iconst_2
    //   89: new 76	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 821
    //   99: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokestatic 824	ahav:d	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)Ljava/lang/String;
    //   106: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 131	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload_2
    //   116: aload_1
    //   117: invokevirtual 827	agne:z	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   120: aload_0
    //   121: getfield 17	agkf:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   124: invokevirtual 651	com/tencent/mobileqq/app/QQAppInterface:a	()Lagkh;
    //   127: iconst_1
    //   128: iconst_3
    //   129: aconst_null
    //   130: invokevirtual 756	agkh:b	(ZILjava/lang/Object;)V
    //   133: goto -56 -> 77
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	agkf
    //   0	141	1	paramFileManagerEntity	FileManagerEntity
    //   9	107	2	localagne	agne
    // Exception table:
    //   from	to	target	type
    //   2	10	136	finally
    //   14	77	136	finally
    //   80	115	136	finally
    //   115	133	136	finally
  }
  
  public void t(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      agne localagne;
      try
      {
        localagne = this.app.a();
        if (localagne == null)
        {
          QLog.e("FileManagerDataCenter<FileAssistant>", 1, "insertToFMListAddOrReplaceDB get FileManagerProxy null! nSessionId[" + paramFileManagerEntity.nSessionId + "], uniseq[" + paramFileManagerEntity.uniseq + "], peerUin[" + ahav.kZ(paramFileManagerEntity.peerUin) + "]");
          return;
        }
        if ((FileManagerEntity)this.app.a().createEntityManager().find(FileManagerEntity.class, String.valueOf(paramFileManagerEntity.nSessionId)) == null)
        {
          localagne.z(paramFileManagerEntity);
          continue;
        }
        localagne.A(paramFileManagerEntity);
      }
      finally {}
      localagne.B(paramFileManagerEntity);
    }
  }
  
  public void u(FileManagerEntity paramFileManagerEntity)
  {
    this.app.a().u(paramFileManagerEntity);
  }
  
  public void v(FileManagerEntity paramFileManagerEntity)
  {
    this.app.a().v(paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agkf
 * JD-Core Version:    0.7.0.1
 */