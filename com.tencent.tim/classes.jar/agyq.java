import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;>;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class agyq
  extends agyo
{
  public agyq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private String a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "";
    }
    do
    {
      return paramString1;
      paramString2 = acbn.bmj + ahbr.b(paramLong, paramInt, paramString2);
      if (!aY(paramString1, paramString2)) {
        break;
      }
      paramString1 = paramString2;
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileMsgBackupHandler<QFile>", 4, "getThumbSavePath. thumbPath[" + paramString2 + "]");
    return paramString2;
    QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "getThumbSavePath. move file failed.");
    return "";
  }
  
  private boolean b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    if (paramMessageRecord.isMultiMsg) {}
    for (Object localObject1 = (MessageForTroopFile)ahav.e((ChatMessage)paramMessageRecord); localObject1 == null; localObject1 = (MessageForTroopFile)paramMessageRecord)
    {
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "onImport: get updateTroopFileRecord failed. get troop file msg is null. isMulti[" + paramMessageRecord.isMultiMsg + "]");
      return false;
    }
    long l = Long.parseLong(((MessageForTroopFile)localObject1).frienduin);
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.mApp, l);
    localObject1 = apsv.a(this.mApp, (MessageForTroopFile)localObject1);
    if ((localTroopFileTransferManager == null) || (localObject1 == null))
    {
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "onImport: get troopFileTransferManager failed.");
      return false;
    }
    if (((apcy)localObject1).Id == null)
    {
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "onImport: updateTroopFileRecord failed. troop file status info uuid is null");
      return false;
    }
    TroopFileTransferManager.Item localItem = localTroopFileTransferManager.a(((apcy)localObject1).Id);
    Object localObject2;
    String str;
    if (localItem != null) {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        localObject1 = "";
        localObject2 = "";
        Iterator localIterator = paramList.iterator();
        paramList = (List<MsgBackupResEntity>)localObject2;
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject2 = (MsgBackupResEntity)localIterator.next();
            if ((a((MsgBackupResEntity)localObject2)) && (b(paramMessageRecord, (MsgBackupResEntity)localObject2)))
            {
              str = a((MsgBackupResEntity)localObject2);
              if (TextUtils.isEmpty(str)) {
                break label381;
              }
              if (((MsgBackupResEntity)localObject2).msgSubType == 12)
              {
                if (aqhq.fileExistsAndNotEmpty(localItem.largeThumbnailFile)) {
                  continue;
                }
                localObject1 = a(l, str, localItem.Id.toString(), 640);
              }
            }
          }
        }
      }
    }
    label381:
    for (;;)
    {
      break;
      if (((MsgBackupResEntity)localObject2).msgSubType == 11)
      {
        if (aqhq.fileExistsAndNotEmpty(localItem.LocalFile)) {
          break;
        }
        paramList = aZ(str, localItem.FileName);
        continue;
        if (aqhq.fileExistsAndNotEmpty(paramList))
        {
          localItem.LocalFile = paramList;
          localItem.Status = 11;
          localTroopFileTransferManager.b(localItem);
        }
        if (aqhq.fileExistsAndNotEmpty((String)localObject1))
        {
          localItem.largeThumbnailFile = ((String)localObject1);
          localItem.HasThumbnailFile_Large = true;
          localTroopFileTransferManager.b(localItem);
        }
        return true;
        return false;
      }
    }
  }
  
  private void d(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    if (paramMessageRecord.isMultiMsg) {}
    for (Object localObject1 = (MessageForTroopFile)ahav.e((ChatMessage)paramMessageRecord); localObject1 == null; localObject1 = (MessageForTroopFile)paramMessageRecord)
    {
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "onImport: createTroopFileRecord failed. get troop file msg is null. isMulti[" + paramMessageRecord.isMultiMsg + "]");
      return;
    }
    long l = Long.parseLong(((MessageForTroopFile)localObject1).frienduin);
    if (apsc.a(l) == null) {
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "createTroopFileRecord: get TroopFileDataManager failed.");
    }
    apbr localapbr = apsf.a(this.mApp, l).b(((MessageForTroopFile)localObject1).url, ((MessageForTroopFile)localObject1).fileName, ((MessageForTroopFile)localObject1).fileSize, ((MessageForTroopFile)localObject1).bisID);
    Object localObject2;
    String str;
    if ((localapbr != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      localObject1 = "";
      localObject2 = "";
      Iterator localIterator = paramList.iterator();
      paramList = (List<MsgBackupResEntity>)localObject2;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject2 = (MsgBackupResEntity)localIterator.next();
          if ((a((MsgBackupResEntity)localObject2)) && (b(paramMessageRecord, (MsgBackupResEntity)localObject2)))
          {
            str = a((MsgBackupResEntity)localObject2);
            if (TextUtils.isEmpty(str)) {
              break label412;
            }
            if (((MsgBackupResEntity)localObject2).msgSubType == 12) {
              localObject1 = a(l, str, UUID.nameUUIDFromBytes(localapbr.mFileId.getBytes()).toString(), 640);
            }
          }
        }
      }
    }
    label412:
    for (;;)
    {
      break;
      if (((MsgBackupResEntity)localObject2).msgSubType == 11)
      {
        paramList = aZ(str, localapbr.str_file_name);
        continue;
        if (aqhq.fileExistsAndNotEmpty(paramList))
        {
          localapbr.LocalFile = paramList;
          localapbr.Status = 11;
          G("TroopFileMsgBackupHandler<QFile>", "createTroopFileRecord", String.valueOf(paramMessageRecord.msgseq), "save origin path. path[" + paramList + "]");
        }
        if (aqhq.fileExistsAndNotEmpty((String)localObject1))
        {
          localapbr.ThumbnailFile_Large = ((String)localObject1);
          G("TroopFileMsgBackupHandler<QFile>", "createTroopFileRecord", String.valueOf(paramMessageRecord.msgseq), "save large thumb path. path[" + (String)localObject1 + "]");
        }
        TroopFileTransferManager.a(this.mApp, l).o(localapbr);
        return;
      }
    }
  }
  
  protected String a(MessageRecord paramMessageRecord, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msgType", 5);
      localJSONObject.put("msgSubType", paramInt);
      MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramMessageRecord;
      if (QLog.isDevelopLevel()) {
        QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo fileType[" + 3 + "]");
      }
      localJSONObject.put("uint32_file_type", 3);
      localJSONObject.put("uint64_sender_uin", paramMessageRecord.senderuin);
      localJSONObject.put("uint64_receiver_uin", paramMessageRecord.frienduin);
      Object localObject = localMessageForTroopFile.url;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo fileUuid[" + (String)localObject + "]");
        }
        localJSONObject.put("bytes_file_uuid", localObject);
      }
      localObject = localMessageForTroopFile.fileName;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo fileName[" + (String)localObject + "]");
        }
        localJSONObject.put("str_file_name", localObject);
      }
      long l = localMessageForTroopFile.fileSize;
      if (QLog.isDevelopLevel()) {
        QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo fileSize[" + l + "]");
      }
      localJSONObject.put("uint64_file_size", l);
      localObject = localMessageForTroopFile.sha1;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo strSHA1[" + (String)localObject + "]");
        }
        localJSONObject.put("sha", localObject);
      }
      paramInt = localMessageForTroopFile.width;
      if (paramInt != 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo imgWidth[" + paramInt + "]");
        }
        localJSONObject.put("uint32_img_width", paramInt);
      }
      paramInt = localMessageForTroopFile.height;
      if (paramInt != 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo imgHeight[" + paramInt + "]");
        }
        localJSONObject.put("uint32_img_height", paramInt);
      }
      localObject = apsv.a(this.mApp, localMessageForTroopFile);
      if ((localObject != null) && (((apcy)localObject).dTo > 0) && (((apcy)localObject).dTp > 0))
      {
        localJSONObject.put("uint32_img_width", ((apcy)localObject).dTo);
        localJSONObject.put("uint32_img_height", ((apcy)localObject).dTp);
      }
      l = localMessageForTroopFile.lastTime;
      if (l != 0L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo deadTime[" + l + "]");
        }
        localJSONObject.put("int64_dead_time", l);
      }
      l = localMessageForTroopFile.duration;
      if (l != 0L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo videoDur[" + l + "]");
        }
        localJSONObject.put("uint64_video_duration", l);
      }
      paramInt = localMessageForTroopFile.bisID;
      if (paramInt != 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo bizId[" + paramInt + "]");
        }
        localJSONObject.put("uint32_bus_id", paramInt);
      }
      if (paramMessageRecord.isMultiMsg) {}
      for (paramInt = 1;; paramInt = 0)
      {
        localJSONObject.put("nest_forward", paramInt);
        paramMessageRecord = localJSONObject.toString();
        return paramMessageRecord;
      }
      return "{}";
    }
    catch (JSONException paramMessageRecord) {}
  }
  
  public String a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    HashMap localHashMap = s(paramMsgBackupResEntity.extraDataStr);
    String str2 = "";
    String str1 = "";
    if (paramMsgBackupResEntity.msgSubType == 12)
    {
      str1 = (String)localHashMap.get("uint64_receiver_uin");
      long l = 0L;
      if (!TextUtils.isEmpty(str1))
      {
        l = Long.parseLong(str1);
        str2 = (String)localHashMap.get("bytes_file_uuid");
        if (QLog.isDebugVersion()) {
          QLog.i("<QFile_Backup>", 1, "getTempFilePath: troop file uin[" + str1 + "] fileId[" + str2 + "]");
        }
        str2 = ahbr.b(l, 640, str2);
        str1 = FILE_THUMB_DIR;
      }
    }
    for (;;)
    {
      G("TroopFileMsgBackupHandler<QFile>", "getTempFilePath", "", "resType[" + paramMsgBackupResEntity.msgType + "] tempPath[" + str1 + str2 + "]");
      return str1 + str2;
      QLog.i("<QFile_Backup>", 1, "getTempFilePath: troop file uin is null");
      break;
      if (paramMsgBackupResEntity.msgSubType == 11)
      {
        str1 = (String)localHashMap.get("str_file_name");
        if (QLog.isDebugVersion()) {
          QLog.i("<QFile_Backup>", 1, "getTempFilePath: troop fileName[" + str1 + "]");
        }
        str2 = (String)localHashMap.get("bytes_file_uuid");
        str2 = MD5.toMD5(str1 + str2);
        if (QLog.isDebugVersion()) {
          QLog.i("<QFile_Backup>", 1, "getTempFilePath: troop temp msg backup fileName[" + str2 + "]");
        }
        str1 = bJx;
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("<QFile_Backup>", 1, "Export: type[troop] contactUin[" + paramMessageRecord.frienduin + "] senderUin[" + paramMessageRecord.senderuin + "] uniSeq[" + paramMessageRecord.uniseq + "] msgSeq[" + paramMessageRecord.msgseq + "]");
    }
    Object localObject1;
    if (paramMessageRecord.isMultiMsg)
    {
      localObject1 = (MessageForTroopFile)ahav.e((ChatMessage)paramMessageRecord);
      localObject1 = apsv.a(this.mApp, (MessageForTroopFile)localObject1);
      if (localObject1 != null) {
        break label145;
      }
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "handleExport: get TroopFileStatusInfo failed.");
    }
    for (;;)
    {
      return;
      localObject1 = (MessageForTroopFile)paramMessageRecord;
      localObject1 = apsv.a(this.mApp, (MessageForTroopFile)localObject1);
      break;
      label145:
      int i = ahav.getFileType(((apcy)localObject1).FileName);
      if ((i == 0) || (i == 2))
      {
        Object localObject2 = ((apcy)localObject1).ThumbnailFile_Large;
        if (aqhq.fileExistsAndNotEmpty((String)localObject2))
        {
          localObject2 = a(paramMessageRecord, 12, (String)localObject2);
          paramList.add(localObject2);
          G("TroopFileMsgBackupHandler<QFile>", "handleExport", String.valueOf(paramMessageRecord.msgseq), "add resource. resType[" + ((MsgBackupResEntity)localObject2).msgType + "]");
        }
      }
      localObject1 = ((apcy)localObject1).LocalFile;
      if (aqhq.fileExistsAndNotEmpty((String)localObject1))
      {
        localObject1 = a(paramMessageRecord, 11, (String)localObject1);
        paramList.add(localObject1);
        G("TroopFileMsgBackupHandler<QFile>", "handleExport", String.valueOf(paramMessageRecord.msgseq), "add resource. resType[" + ((MsgBackupResEntity)localObject1).msgType + "]");
      }
      if ((QLog.isDebugVersion()) && (paramList != null))
      {
        QLog.i("<QFile_Backup>", 1, "Export --step: msgSeq[" + paramMessageRecord.msgseq + "resourceSize[" + paramList.size() + "]");
        paramMessageRecord = paramList.iterator();
        while (paramMessageRecord.hasNext())
        {
          paramList = (MsgBackupResEntity)paramMessageRecord.next();
          QLog.i("<QFile_Backup>", 1, "Export --step: backup entity [" + paramList.toLogString() + "]");
        }
      }
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    boolean bool1 = true;
    if (paramMsgBackupResEntity == null) {}
    do
    {
      return false;
      paramMessageRecord = s(paramMsgBackupResEntity.extraDataStr);
      String str = (String)paramMessageRecord.get("bytes_file_uuid");
      paramMessageRecord = (String)paramMessageRecord.get("uint64_receiver_uin");
      if (TextUtils.isEmpty(str))
      {
        QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: troop fileId is null");
        return false;
      }
      if (TextUtils.isEmpty(paramMessageRecord))
      {
        QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: troop uin is null");
        return false;
      }
      TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.mApp, Long.parseLong(paramMessageRecord));
      paramMessageRecord = null;
      if (localTroopFileTransferManager != null) {
        paramMessageRecord = localTroopFileTransferManager.a(str);
      }
      if (paramMessageRecord == null)
      {
        QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "checkNeedDownloadRes: get troopStatusInfo failed.");
        return true;
      }
      QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: troop fileId[" + str + "]");
      if (paramMsgBackupResEntity.msgSubType == 12)
      {
        bool1 = aqhq.fileExistsAndNotEmpty(paramMessageRecord.ThumbnailFile_Large);
        QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: offline large thumb exist[" + bool1 + "]");
        if (!bool1) {}
        for (bool1 = true;; bool1 = false) {
          return bool1;
        }
      }
    } while (paramMsgBackupResEntity.msgSubType != 11);
    boolean bool2 = aqhq.fileExistsAndNotEmpty(paramMessageRecord.LocalFile);
    QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: troop origin file exist[" + bool2 + "]");
    if (!bool2) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public void b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    if (QLog.isDebugVersion())
    {
      QLog.i("<QFile_Backup>", 1, "Import: type[troop] contactUin[" + paramMessageRecord.frienduin + "] senderUin[" + paramMessageRecord.senderuin + "] uniSeq[" + paramMessageRecord.uniseq + "] msgSeq[" + paramMessageRecord.msgseq + "]");
      if (paramList != null)
      {
        QLog.i("<QFile_Backup>", 1, "Import --step: msgSeq[" + paramMessageRecord.msgseq + "resourceSize[" + paramList.size() + "]");
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          MsgBackupResEntity localMsgBackupResEntity = (MsgBackupResEntity)localIterator.next();
          QLog.i("<QFile_Backup>", 1, "Import --step: backup entity [" + localMsgBackupResEntity.toLogString() + "]");
        }
      }
    }
    if (b(paramMessageRecord, paramList)) {
      G("TroopFileMsgBackupHandler<QFile>", "handleImport", String.valueOf(paramMessageRecord.msgseq), "update troop file record.");
    }
    for (;;)
    {
      am(paramMessageRecord);
      return;
      d(paramMessageRecord, paramList);
      G("TroopFileMsgBackupHandler<QFile>", "handleImport", String.valueOf(paramMessageRecord.msgseq), "create troop file record.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agyq
 * JD-Core Version:    0.7.0.1
 */