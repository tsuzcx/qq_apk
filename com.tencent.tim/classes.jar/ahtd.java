import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;

public class ahtd
{
  public static String r(MessageRecord paramMessageRecord)
  {
    TinyInfo localTinyInfo = new TinyInfo();
    localTinyInfo.parseFromMessageRecord(paramMessageRecord);
    if (paramMessageRecord.isSend()) {
      return localTinyInfo.fromRoleId;
    }
    return localTinyInfo.toRoleId;
  }
  
  public static String s(MessageRecord paramMessageRecord)
  {
    TinyInfo localTinyInfo = new TinyInfo();
    localTinyInfo.parseFromMessageRecord(paramMessageRecord);
    if (paramMessageRecord.isSend()) {
      return localTinyInfo.toRoleId;
    }
    return localTinyInfo.fromRoleId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahtd
 * JD-Core Version:    0.7.0.1
 */