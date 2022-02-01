import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ajei
  implements ajdz
{
  public static String TAG = "MsgBackup_MsgBackupMultiMsgProcessor";
  
  public ajei(QQAppInterface paramQQAppInterface) {}
  
  public static String b(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((paramMsgBackupResEntity != null) && (!TextUtils.isEmpty(paramMsgBackupResEntity.extraDataStr))) {
      try
      {
        paramMessageRecord = ajgv.mc(new JSONObject(paramMsgBackupResEntity.extraDataStr).optString("uuid"));
        return paramMessageRecord;
      }
      catch (JSONException paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return "";
  }
  
  public static String b(String paramString, MessageRecord paramMessageRecord)
  {
    String str = ((MessageForStructing)paramMessageRecord).structingMsg.mFileName;
    paramMessageRecord = new JSONObject();
    try
    {
      paramMessageRecord.put("selfuin", paramString);
      paramMessageRecord.put("uuid", str);
      paramMessageRecord.put("msgType", 4);
      paramMessageRecord.put("msgSubType", 10);
      return paramMessageRecord.toString();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static List<MessageRecord> d(HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll((Collection)paramHashMap.get((String)localIterator.next()));
    }
    return localArrayList;
  }
  
  public ajem a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    ajem localajem = new ajem();
    localajem.aWb = a(paramMessageRecord, paramMsgBackupResEntity);
    localajem.cnO = true;
    return localajem;
  }
  
  public String a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((paramMsgBackupResEntity != null) && (!TextUtils.isEmpty(paramMsgBackupResEntity.extraDataStr))) {
      try
      {
        paramMessageRecord = ajgv.mc(new JSONObject(paramMsgBackupResEntity.extraDataStr).optString("uuid"));
        return paramMessageRecord;
      }
      catch (JSONException paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return "";
  }
  
  public boolean aI(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof ChatMessage)) {
      return ajlg.P((ChatMessage)paramMessageRecord);
    }
    return false;
  }
  
  public boolean b(MsgBackupResEntity paramMsgBackupResEntity)
  {
    return paramMsgBackupResEntity.msgType == 4;
  }
  
  public void e(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList) {}
  
  public void f(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajei
 * JD-Core Version:    0.7.0.1
 */