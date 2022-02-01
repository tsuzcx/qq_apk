import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class ajed
  implements ajdz
{
  private agyp jdField_a_of_type_Agyp;
  private agyq jdField_a_of_type_Agyq;
  private QQAppInterface mApp;
  
  public ajed(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private agyo a(int paramInt)
  {
    QLog.i("MsgBackupFileProcessor<QFile>", 1, "getMsgBackupHandler: chatTYpe[" + paramInt + "]");
    Object localObject1 = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Agyp == null) {
        this.jdField_a_of_type_Agyp = new agyp(this.mApp);
      }
      localObject1 = this.jdField_a_of_type_Agyp;
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        QLog.i("MsgBackupFileProcessor<QFile>", 1, "getMsgBackupHandler: target backup handle is null");
        if (this.jdField_a_of_type_Agyp == null) {
          this.jdField_a_of_type_Agyp = new agyp(this.mApp);
        }
        localObject2 = this.jdField_a_of_type_Agyp;
      }
      return localObject2;
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_Agyp == null) {
          this.jdField_a_of_type_Agyp = new agyp(this.mApp);
        }
        localObject1 = this.jdField_a_of_type_Agyp;
      }
      else if (paramInt == 3)
      {
        if (this.jdField_a_of_type_Agyq == null) {
          this.jdField_a_of_type_Agyq = new agyq(this.mApp);
        }
        localObject1 = this.jdField_a_of_type_Agyq;
      }
    }
  }
  
  private agyo a(MessageRecord paramMessageRecord)
  {
    Object localObject = null;
    if (paramMessageRecord.isMultiMsg)
    {
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType");
      if (!TextUtils.isEmpty(paramMessageRecord))
      {
        if (Integer.parseInt(paramMessageRecord) != 3) {
          break label72;
        }
        if (this.jdField_a_of_type_Agyq == null) {
          this.jdField_a_of_type_Agyq = new agyq(this.mApp);
        }
        localObject = this.jdField_a_of_type_Agyq;
      }
    }
    for (;;)
    {
      if (localObject == null) {
        QLog.i("MsgBackupFileProcessor<QFile>", 1, "getMsgBackupHandler: target backup handle is null");
      }
      return localObject;
      label72:
      if (this.jdField_a_of_type_Agyp == null) {
        this.jdField_a_of_type_Agyp = new agyp(this.mApp);
      }
      localObject = this.jdField_a_of_type_Agyp;
      continue;
      if ((paramMessageRecord instanceof MessageForFile))
      {
        if (this.jdField_a_of_type_Agyp == null) {
          this.jdField_a_of_type_Agyp = new agyp(this.mApp);
        }
        localObject = this.jdField_a_of_type_Agyp;
      }
      else if ((paramMessageRecord instanceof MessageForTroopFile))
      {
        if (this.jdField_a_of_type_Agyq == null) {
          this.jdField_a_of_type_Agyq = new agyq(this.mApp);
        }
        localObject = this.jdField_a_of_type_Agyq;
      }
    }
  }
  
  private HashMap<String, String> s(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localHashMap;
      try
      {
        paramString = new JSONObject(paramString);
        String str;
        if (paramString.has("uint64_sender_uin"))
        {
          str = paramString.getString("uint64_sender_uin");
          if (QLog.isDevelopLevel()) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo senderUin[" + str + "]");
          }
          localHashMap.put("uint64_sender_uin", str);
        }
        if (paramString.has("uint64_receiver_uin"))
        {
          str = paramString.getString("uint64_receiver_uin");
          if (QLog.isDevelopLevel()) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo recvUin[" + str + "]");
          }
          localHashMap.put("uint64_receiver_uin", str);
        }
        int i;
        if (paramString.has("uint32_file_type"))
        {
          i = paramString.getInt("uint32_file_type");
          if (QLog.isDevelopLevel()) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo peerType[" + i + "]");
          }
          localHashMap.put("uint32_file_type", String.valueOf(i));
        }
        if (paramString.has("bytes_file_uuid"))
        {
          str = paramString.getString("bytes_file_uuid");
          if (QLog.isDevelopLevel()) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo fileUuid[" + str + "]");
          }
          localHashMap.put("bytes_file_uuid", str);
        }
        if (paramString.has("str_file_name"))
        {
          str = paramString.getString("str_file_name");
          if (QLog.isDevelopLevel()) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo fileName[" + str + "]");
          }
          localHashMap.put("str_file_name", str);
        }
        if (paramString.has("uint64_file_size"))
        {
          long l = paramString.getLong("uint64_file_size");
          if (QLog.isDevelopLevel()) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo fileSize[" + l + "]");
          }
          localHashMap.put("uint64_file_size", String.valueOf(l));
        }
        if (paramString.has("md5"))
        {
          str = paramString.getString("md5");
          if (!TextUtils.isEmpty(str))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo fileMd5[" + str + "]");
            }
            localHashMap.put("md5", str);
          }
        }
        if (paramString.has("md510"))
        {
          str = paramString.getString("md510");
          if (!TextUtils.isEmpty(str))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo file10Md5[" + str + "]");
            }
            localHashMap.put("md510", str);
          }
        }
        if (paramString.has("sha"))
        {
          str = paramString.getString("sha");
          if (!TextUtils.isEmpty(str))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo sha[" + str + "]");
            }
            localHashMap.put("sha", str);
          }
        }
        if (paramString.has("sha3"))
        {
          str = paramString.getString("sha3");
          if (!TextUtils.isEmpty(str))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo sha3[" + str + "]");
            }
            localHashMap.put("sha3", str);
          }
        }
        if (paramString.has("uint32_img_width"))
        {
          i = paramString.getInt("uint32_img_width");
          if (i != 0)
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo imgWidth[" + i + "]");
            }
            localHashMap.put("uint32_img_width", String.valueOf(i));
          }
        }
        if (paramString.has("uint32_img_height"))
        {
          i = paramString.getInt("uint32_img_height");
          if (i != 0)
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo imgWidth[" + i + "]");
            }
            localHashMap.put("uint32_img_height", String.valueOf(i));
            return localHashMap;
          }
        }
      }
      catch (Exception paramString) {}
    }
    return localHashMap;
  }
  
  public ajem a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    ajem localajem = new ajem();
    if (paramMsgBackupResEntity == null)
    {
      QLog.i("MsgBackupFileProcessor<QFile>", 1, "isNeedDownloadRes: res entity is null.");
      localajem.cnO = false;
      return localajem;
    }
    if (paramMsgBackupResEntity.msgType != 5)
    {
      QLog.i("MsgBackupFileProcessor<QFile>", 1, "isNeedDownloadRes: res entity is null.");
      localajem.cnO = false;
      return localajem;
    }
    String str = (String)s(paramMsgBackupResEntity.extraDataStr).get("uint32_file_type");
    if (TextUtils.isEmpty(str))
    {
      QLog.i("MsgBackupFileProcessor<QFile>", 1, "isNeedDownloadRes: can not find chatType from extInfo. resInfo[" + paramMsgBackupResEntity.toLogString() + "]");
      localajem.cnO = false;
      return localajem;
    }
    localajem.cnO = a(Integer.parseInt(str)).a(paramMessageRecord, paramMsgBackupResEntity);
    return localajem;
  }
  
  public String a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    paramMessageRecord = new File(agyo.bJx);
    if (!paramMessageRecord.exists()) {
      paramMessageRecord.mkdirs();
    }
    paramMessageRecord = new File(agyo.FILE_THUMB_DIR);
    if (!paramMessageRecord.exists()) {
      paramMessageRecord.mkdirs();
    }
    return a(Integer.parseInt((String)s(paramMsgBackupResEntity.extraDataStr).get("uint32_file_type"))).a(paramMsgBackupResEntity);
  }
  
  public boolean aI(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForTroopFile)) {}
    while ((paramMessageRecord instanceof MessageForFile)) {
      return true;
    }
    return false;
  }
  
  public boolean b(MsgBackupResEntity paramMsgBackupResEntity)
  {
    return (paramMsgBackupResEntity != null) && (paramMsgBackupResEntity.msgType == 5);
  }
  
  public void e(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    agyo localagyo = a(paramMessageRecord);
    if (localagyo != null) {
      localagyo.a(paramMessageRecord, paramList);
    }
  }
  
  public void f(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    agyo localagyo = a(paramMessageRecord);
    if (localagyo != null) {
      localagyo.b(paramMessageRecord, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajed
 * JD-Core Version:    0.7.0.1
 */