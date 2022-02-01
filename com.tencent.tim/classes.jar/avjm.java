import android.content.Context;
import android.os.Looper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import java.util.UUID;
import mqq.manager.Manager;

public class avjm
  implements Manager
{
  private avjl jdField_a_of_type_Avjl;
  private avjo jdField_a_of_type_Avjo = new avjo(new avjn(this, Looper.getMainLooper()));
  private QQAppInterface mApp;
  public Context mContext;
  public String mUin;
  
  public avjm(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = this.mApp.getApplication();
    this.mUin = this.mApp.getCurrentAccountUin();
    this.mApp.addObserver(this.jdField_a_of_type_Avjo);
    this.jdField_a_of_type_Avjl = ((avjl)this.mApp.getBusinessHandler(176));
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, long paramLong1, long paramLong2, int paramInt)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.mApp, Long.valueOf(paramLong1).longValue());
    if (localTroopFileTransferManager == null) {}
    do
    {
      int i;
      apcy localapcy;
      do
      {
        return;
        i = Math.abs(new Random().nextInt());
        localapcy = localTroopFileTransferManager.a(paramFileManagerEntity, 102, i, Long.parseLong(this.mApp.getCurrentUin()));
      } while (localapcy == null);
      apsv.a(this.mApp, "" + paramLong1, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, localapcy.Id.toString(), i, null, paramFileManagerEntity.nSessionId, paramLong2, paramInt);
      paramFileManagerEntity.strTroopFileUuid = localapcy.Id.toString();
      if (aqiw.isNetSupport(BaseApplication.getContext())) {
        break;
      }
      paramFileManagerEntity.status = 0;
      paramFileManagerEntity.isReaded = false;
      localTroopFileTransferManager.a(localapcy.Id, -1, null, acfp.m(2131716918));
    } while (!QLog.isColorLevel());
    QLog.i("QfavFileForwardManager", 2, "forwardToTroop : network error");
    return;
    this.jdField_a_of_type_Avjl.a(1, paramFileManagerEntity, paramLong1);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, long paramLong1, long paramLong2, int paramInt)
  {
    paramFileManagerEntity = c(paramFileManagerEntity, this.mApp.getCurrentAccountUin(), paramLong1 + "", paramFileManagerEntity.peerType, paramInt);
    ahav.jR(paramFileManagerEntity.nSessionId);
    ahav.a(this.mApp, this.mApp.getCurrentAccountUin(), paramLong1 + "", paramFileManagerEntity);
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.fProgress = 0.0F;
    this.jdField_a_of_type_Avjl.a(2, paramFileManagerEntity, paramLong1);
  }
  
  public FileManagerEntity c(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QfavFileForwardManager", 2, "insertWeiYun2OfflineEntity : entity is null, peerUin[" + ahav.kZ(paramString2) + "], peerType[" + paramInt1 + "]");
      }
      paramFileManagerEntity = null;
      return paramFileManagerEntity;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = ahav.d().longValue();
    String str = aoon.a(localFileManagerEntity.getFilePath(), localFileManagerEntity.fileSize, 0, true);
    long l = anbi.d(-1000).uniseq;
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.setCloudType(10);
    localFileManagerEntity.nOpType = 37;
    localFileManagerEntity.peerNick = ahav.a(this.mApp, paramString2, null, paramInt1);
    localFileManagerEntity.peerType = paramInt1;
    localFileManagerEntity.selfUin = this.mApp.getAccount();
    localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = ahav.bA();
    localFileManagerEntity.msgUid = ahav.ge();
    if (paramInt2 != 0) {
      wte.a().i(l, 0L, paramInt2);
    }
    this.mApp.a().s(localFileManagerEntity);
    paramFileManagerEntity = this.mApp.getAccount();
    if ((paramInt1 == 1004) || (paramInt1 == 1000)) {
      paramFileManagerEntity = paramString1;
    }
    for (;;)
    {
      this.mApp.a().a(paramString2, paramFileManagerEntity, true, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, true, paramInt1, str, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, null, 1, l, localFileManagerEntity.msgUid, -1L, anaz.gQ());
      paramFileManagerEntity = localFileManagerEntity;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QfavFileForwardManager", 2, "insertWeiYun2OfflineEntity peerType[" + paramInt1 + "],FileManagerEntity:" + ahav.d(localFileManagerEntity));
      return localFileManagerEntity;
      if (paramInt1 == 1006)
      {
        localFileManagerEntity.tmpSessionFromPhone = paramString1;
        localFileManagerEntity.tmpSessionToPhone = paramString2;
        paramFileManagerEntity = paramString1;
      }
    }
  }
  
  public void c(FileManagerEntity paramFileManagerEntity, long paramLong1, long paramLong2, int paramInt)
  {
    if (this.mApp == null)
    {
      QLog.e("QfavFileForwardManager", 1, "insertFav2OfflineEntity mApp=null");
      return;
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.selfuin = this.mApp.getCurrentUin();
    localDataLineMsgRecord.filename = paramFileManagerEntity.fileName;
    localDataLineMsgRecord.filesize = paramFileManagerEntity.fileSize;
    localDataLineMsgRecord.busId = 236;
    localDataLineMsgRecord.fileFrom = 6;
    localDataLineMsgRecord.nOpType = 38;
    localDataLineMsgRecord.istroop = 0;
    acde localacde = (acde)this.mApp.getBusinessHandler(8);
    localDataLineMsgRecord.sessionid = localacde.a(0, 0).longValue();
    localDataLineMsgRecord.msg = "";
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    ((acle)this.mApp.getBusinessHandler(13)).W(localDataLineMsgRecord);
    localDataLineMsgRecord.time = anaz.gQ();
    localDataLineMsgRecord.progress = 0.2F;
    localDataLineMsgRecord.fileMsgStatus = 0L;
    localDataLineMsgRecord.msgtype = acde.gu(0);
    localDataLineMsgRecord.bIsTransfering = true;
    localDataLineMsgRecord.bNoInsertFm = true;
    localDataLineMsgRecord.entityID = paramFileManagerEntity.nSessionId;
    this.mApp.b().a(DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid)).a(localDataLineMsgRecord, true);
    localacde.e(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)acde.gv(localDataLineMsgRecord.msgtype)), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(localDataLineMsgRecord.filesize) });
    this.jdField_a_of_type_Avjl.a(3, paramFileManagerEntity, paramLong1, localDataLineMsgRecord.sessionid);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Avjo.cLZ();
    this.mApp.removeObserver(this.jdField_a_of_type_Avjo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avjm
 * JD-Core Version:    0.7.0.1
 */