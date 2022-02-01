import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyCloudFileSystem;
import com.weiyun.sdk.IWyFileSystem;
import com.weiyun.sdk.IWyTaskManager;
import com.weiyun.sdk.IWyTaskManager.Task;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.UUID;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ExtensionReq;

public class atuw
{
  static boolean cej;
  IWyFileSystem a;
  LinkedHashMap<String, WeiYunFileInfo> ad;
  int alY = 0;
  QQAppInterface app;
  
  public atuw(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    if (cej) {
      awph.eEL();
    }
    this.a = awph.a();
    cej = true;
  }
  
  public void Ze(String paramString)
  {
    this.a.getCloudFileSystem().getPreviewAddress(paramString, new atux(this));
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "insertWeiYun2OfflineEntity : entity is null, peerUin[" + audx.kZ(paramString2) + "], peerType[" + paramInt + "]");
      }
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = audx.d().longValue();
    String str = aoon.a("", 0L, 0, true);
    long l = anbi.d(-1000).uniseq;
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.nOpType = 3;
    localFileManagerEntity.peerNick = audx.a(this.app, paramString2, null, paramInt);
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.selfUin = this.app.getAccount();
    localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = audx.bA();
    localFileManagerEntity.msgUid = audx.ge();
    this.app.a().jo(paramFileManagerEntity.nSessionId);
    this.app.a().s(localFileManagerEntity);
    paramFileManagerEntity = this.app.getAccount();
    if ((paramInt == 1004) || (paramInt == 1000)) {
      paramFileManagerEntity = paramString1;
    }
    for (;;)
    {
      this.app.a().a(paramString2, paramFileManagerEntity, true, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, true, paramInt, str, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, null, 2, l, localFileManagerEntity.msgUid, -1L, anaz.gQ());
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "insertWeiYun2OfflineEntity peerType[" + paramInt + "],FileManagerEntity:" + audx.d(localFileManagerEntity));
      }
      return localFileManagerEntity;
      if (paramInt == 1006)
      {
        localFileManagerEntity.tmpSessionFromPhone = paramString1;
        localFileManagerEntity.tmpSessionToPhone = paramString2;
        paramFileManagerEntity = paramString1;
      }
    }
  }
  
  public IWyTaskManager.Task a(String paramString, Object paramObject)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "uploadWeiYunFile strPath is null");
      }
    }
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "uploadWeiYunFile, strPath[" + paramString + "]");
      }
      paramString = this.a.getTaskManager().createUploadTask(paramString, paramObject);
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "uploadWeiYunFile create upload task faild!");
    return null;
    return paramString;
  }
  
  public IWyTaskManager.Task a(String paramString1, String paramString2, long paramLong1, long paramLong2, Object paramObject)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "downLoadWeiYunFile fileId is null");
      }
      paramString1 = null;
      return paramString1;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "downLoadWeiYunFile fileName is null!");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      if ("downLoadWeiYunFile, fileId[" + paramString1 + "], fileName[" + paramString2 + "], fileName[" + paramString2 != null) {
        break label145;
      }
    }
    label145:
    for (String str = "null";; str = paramString2 + "], fileSize[" + String.valueOf(paramLong1) + "],modifyTime[" + String.valueOf(paramLong2) + "]")
    {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, str);
      paramString2 = this.a.getTaskManager().createDownloadTask(paramString1, paramString2, paramLong1, paramLong2, paramObject);
      paramString1 = paramString2;
      if (paramString2 != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "create download task faild!");
      }
      return null;
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2OfflineFile : entity is null");
      }
      audx.a(this.app, 0L, "actFileWy2Of", 0L, "", "", "", "", 9006L, "entity is null", 0L, 0L, 0L, "", "", 0, "", null);
      audx.ti();
      return;
    }
    paramFileManagerEntity.status = 2;
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      paramFileManagerEntity.isReaded = false;
      this.app.a().dhl();
      this.app.a().b(false, 3, null);
      this.app.a().b(false, 33, new Object[] { Integer.valueOf(2), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2OfflineFile : network error");
      }
      audx.a(this.app, paramFileManagerEntity.nSessionId, "actFileWy2Of", 0L, "", paramFileManagerEntity.peerUin, "", "", 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "", null);
      this.app.a().u(paramFileManagerEntity);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "sendWyFile2QqOffline, peerUin[" + audx.kZ(paramFileManagerEntity.peerUin) + "peerType[" + paramInt + "]], WeiYunFileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + paramFileManagerEntity.fileSize + "], nWeiYunSrcType[" + paramFileManagerEntity.nWeiYunSrcType + "]");
    }
    paramFileManagerEntity.setfProgress(0.0F);
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramFileManagerEntity.peerUin.replace("+", ""));
      aizg localaizg = (aizg)this.app.getManager(16);
      if ((localaizg != null) && (localaizg.nf(paramFileManagerEntity.peerUin)))
      {
        audx.JI("该好友已被屏蔽！请先解除屏蔽！");
        paramFileManagerEntity.status = 0;
        this.app.a().dhl();
        this.app.a().b(false, 3, null);
        this.app.a().b(false, 33, new Object[] { Integer.valueOf(10), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
        if (QLog.isColorLevel()) {
          QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2OfflineFile : shield");
        }
        this.app.a().u(paramFileManagerEntity);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l1;
      for (;;)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.w("WeiYunLogicCenter<FileAssistant>", 2, "number format failed!");
          l1 = l2;
        }
      }
      if ((TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) || (TextUtils.isEmpty(paramFileManagerEntity.fileName)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWyFile2QqOffline onFailed: weiyunID is null[" + TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId) + "], fileName is Null[" + TextUtils.isEmpty(paramFileManagerEntity.fileName) + "]");
        }
        paramFileManagerEntity.status = 0;
        paramFileManagerEntity.isReaded = false;
        this.app.a().dhl();
        this.app.a().u(paramFileManagerEntity);
        this.app.a().o(paramFileManagerEntity.nSessionId, 1005);
        this.app.a().b(false, 33, new Object[] { Integer.valueOf(1), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
        return;
      }
      int i = 3;
      if (paramInt == 3000) {
        i = 106;
      }
      Object localObject = null;
      if (paramFileManagerEntity.tmpSessionType > 0L)
      {
        Cmd0X31B.ExtensionReq localExtensionReq = new Cmd0X31B.ExtensionReq();
        localExtensionReq.uint64_type.set(paramFileManagerEntity.tmpSessionType);
        localExtensionReq.uint64_id.set(3L);
        if (paramFileManagerEntity.tmpSessionType == 102L) {
          localExtensionReq.str_dst_phonenum.set(paramFileManagerEntity.peerUin);
        }
        paramFileManagerEntity.tmpSessionSig = audx.a(this.app, paramFileManagerEntity.peerUin, (int)paramFileManagerEntity.tmpSessionType);
        localObject = localExtensionReq;
        if (paramFileManagerEntity.tmpSessionSig != null)
        {
          localObject = localExtensionReq;
          if (paramFileManagerEntity.tmpSessionSig.length > 0)
          {
            localExtensionReq.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
            localObject = localExtensionReq;
          }
        }
      }
      if ((TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) || (TextUtils.isEmpty(paramFileManagerEntity.fileName)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWyFile2QqOffline onFailed: weiyunID is null[" + TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId) + "], fileName is Null[" + TextUtils.isEmpty(paramFileManagerEntity.fileName) + "]");
        }
        paramFileManagerEntity.status = 0;
        paramFileManagerEntity.isReaded = false;
        this.app.a().dhl();
        this.app.a().u(paramFileManagerEntity);
        this.app.a().o(paramFileManagerEntity.nSessionId, 1005);
        this.app.a().b(false, 33, new Object[] { Integer.valueOf(1), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
        return;
      }
      this.a.getCloudFileSystem().sendWyFile2Ftn(paramFileManagerEntity.WeiYunFileId, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.nWeiYunSrcType, null, l1, i, null, localObject, new atva(this, paramFileManagerEntity, paramInt));
      audx.jR(paramFileManagerEntity.nSessionId);
    }
  }
  
  public void a(IWyTaskManager.Task paramTask)
  {
    this.a.getTaskManager().submitTask(paramTask);
  }
  
  public FileManagerEntity b(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "insertOfflineFile2WeiYunEntity : entity is null!");
      }
      audx.ti();
      return null;
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "insertOfflineFile2WeiYunEntity : fromUin is null!");
      }
      audx.ti();
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = audx.d().longValue();
    localFileManagerEntity.uniseq = -1L;
    localFileManagerEntity.nOpType = 4;
    localFileManagerEntity.peerNick = audx.a(this.app, paramString, null, paramFileManagerEntity.peerType);
    localFileManagerEntity.peerType = paramFileManagerEntity.peerType;
    localFileManagerEntity.peerUin = paramString;
    if (paramFileManagerEntity.peerType == 3000) {}
    for (localFileManagerEntity.selfUin = paramFileManagerEntity.peerUin;; localFileManagerEntity.selfUin = this.app.getAccount())
    {
      localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
      localFileManagerEntity.status = 2;
      this.app.a().s(localFileManagerEntity);
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "insertWeiYun2OfflineEntity FileManagerEntity:" + audx.d(localFileManagerEntity));
      }
      return localFileManagerEntity;
    }
  }
  
  public void b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, strFileId[" + String.valueOf(paramWeiYunFileInfo.bIk) + "],strFileName[" + paramWeiYunFileInfo.strFileName + "]");
    }
    atwb.a(paramWeiYunFileInfo.bIk, paramWeiYunFileInfo);
    this.a.getCloudFileSystem().deleteWyFile(paramWeiYunFileInfo.bIk, paramWeiYunFileInfo.cYi, new atvf(this, paramWeiYunFileInfo));
  }
  
  public void bj(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryOfflineFileList, type[" + paramInt1 + "], offset[" + paramInt2 + "], count[" + paramInt3 + "]");
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.app.a().b(false, 32, new Object[] { Integer.valueOf(0), "network error" });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "net work error");
      }
      return;
    }
    this.a.getCloudFileSystem().listOfflineFiles(paramInt1, paramInt2, paramInt3, new atuz(this));
  }
  
  public String d(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb : strFileId[" + paramString1 + "], strFileName[" + paramString2 + "], WeiYunThumbnailType[" + paramInt + "]");
    }
    Object localObject;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      this.app.a().b(false, 39, new Object[] { paramString1, paramObject });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb : fileID error");
      }
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = this.a.getThumbnail(paramString1, com.weiyun.sdk.IWyFileSystem.ThumbnailType.values()[paramInt], paramString2, 0L);
      localObject = str;
    } while (str != null);
    if ((!aqiw.isNetSupport(BaseApplication.getContext())) || (paramString1 == null))
    {
      this.app.a().b(false, 39, new Object[] { paramString1, paramObject });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb : network error");
      }
      return null;
    }
    this.a.getThumbnail(paramString1, com.weiyun.sdk.IWyFileSystem.ThumbnailType.values()[paramInt], paramString2, 0L, paramObject, new atve(this));
    return null;
  }
  
  public void f(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (paramFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop : entity is null");
      }
    }
    TroopFileTransferManager localTroopFileTransferManager;
    int i;
    apcy localapcy;
    do
    {
      do
      {
        return;
        localTroopFileTransferManager = TroopFileTransferManager.a(this.app, Long.valueOf(paramString).longValue());
      } while (localTroopFileTransferManager == null);
      i = Math.abs(new Random().nextInt());
      localapcy = localTroopFileTransferManager.a(paramFileManagerEntity.WeiYunFileId, paramFileManagerEntity.fileName, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileSize, 25, i, 8888L);
    } while (localapcy == null);
    int j = audx.fM(localapcy.LocalFile);
    Object localObject;
    TroopFileTransferManager.Item localItem;
    if ((aueh.isFileExists(localapcy.LocalFile)) && ((j == 0) || (j == 2))) {
      if (j == 0)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(localapcy.LocalFile, (BitmapFactory.Options)localObject);
        apsv.a(this.app, paramString, localapcy.FileName, localapcy.ProgressTotal, localapcy.Id.toString(), i, String.valueOf(localapcy.TroopUin), paramFileManagerEntity.nSessionId, ((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight);
        localItem = localTroopFileTransferManager.a(localapcy.Id);
        if (localItem != null)
        {
          localItem.width = ((BitmapFactory.Options)localObject).outWidth;
          localItem.height = ((BitmapFactory.Options)localObject).outHeight;
        }
      }
    }
    for (;;)
    {
      paramFileManagerEntity.status = 2;
      if (aqiw.isNetSupport(BaseApplication.getContext())) {
        break label440;
      }
      paramFileManagerEntity.status = 0;
      paramFileManagerEntity.isReaded = false;
      localTroopFileTransferManager.a(localapcy.Id, -1, null, "当前网络不可用，请检查你的网络设置");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop : network error");
      return;
      if (j == 2)
      {
        localObject = ShortVideoUtils.n(localapcy.LocalFile);
        apsv.a(this.app, paramString, localapcy.FileName, localapcy.ProgressTotal, localapcy.Id.toString(), i, String.valueOf(localapcy.TroopUin), paramFileManagerEntity.nSessionId, localObject[0], localObject[1], localObject[2]);
        localItem = localTroopFileTransferManager.a(localapcy.Id);
        if (localItem != null)
        {
          localItem.width = localObject[0];
          localItem.height = localObject[1];
          continue;
          apsv.a(this.app, paramString, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, localapcy.Id.toString(), i, String.valueOf(8888L), paramFileManagerEntity.nSessionId);
        }
      }
    }
    label440:
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop, peerUin[" + audx.kZ(paramFileManagerEntity.peerUin) + "], WeiYunFileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + paramFileManagerEntity.fileSize + "], nWeiYunSrcType[" + paramFileManagerEntity.nWeiYunSrcType + "]");
    }
    paramFileManagerEntity.setfProgress(0.0F);
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramString);
      paramString = null;
      if (paramFileManagerEntity.tmpSessionType > 0L)
      {
        localObject = new Cmd0X31B.ExtensionReq();
        ((Cmd0X31B.ExtensionReq)localObject).uint64_type.set(paramFileManagerEntity.tmpSessionType);
        ((Cmd0X31B.ExtensionReq)localObject).uint64_id.set(3L);
        if (paramFileManagerEntity.tmpSessionType == 102L) {
          ((Cmd0X31B.ExtensionReq)localObject).str_dst_phonenum.set(paramFileManagerEntity.peerUin);
        }
        paramFileManagerEntity.tmpSessionSig = audx.a(this.app, paramFileManagerEntity.peerUin, (int)paramFileManagerEntity.tmpSessionType);
        paramString = (String)localObject;
        if (paramFileManagerEntity.tmpSessionSig != null)
        {
          paramString = (String)localObject;
          if (paramFileManagerEntity.tmpSessionSig.length > 0)
          {
            ((Cmd0X31B.ExtensionReq)localObject).bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
            paramString = (String)localObject;
          }
        }
      }
      this.a.getCloudFileSystem().sendWyFile2Ftn(paramFileManagerEntity.WeiYunFileId, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.nWeiYunSrcType, paramFileManagerEntity.strFileMd5, l1, 102, null, paramString, new atvd(this, paramFileManagerEntity, localTroopFileTransferManager, localapcy));
      this.app.a().jo(paramFileManagerEntity.nSessionId);
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.w("WeiYunLogicCenter<FileAssistant>", 2, "number format failed!");
          l1 = l2;
        }
      }
    }
  }
  
  public void g(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList, categoryId[" + paramString + "], offset[" + paramInt1 + "], count[" + paramInt2 + "], timestamp[" + paramLong + "]");
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.app.a().b(false, 31, new Object[] { Integer.valueOf(0), "network error", paramString });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList : network error");
      }
    }
    do
    {
      return;
      if (paramInt1 == 0)
      {
        if (this.ad != null) {
          this.ad.clear();
        }
        this.ad = new LinkedHashMap();
        this.alY = 0;
      }
      while (this.ad != null)
      {
        this.alY += 1;
        this.a.getCloudFileSystem().listCloudFiles(paramString, paramInt1, paramInt2, paramLong, new atuy(this, paramString, paramInt2));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList : start not from zero?!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atuw
 * JD-Core Version:    0.7.0.1
 */