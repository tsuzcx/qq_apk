import android.support.v4.util.LruCache;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;

public class wna
{
  public static LruCache<String, PAMessage> i = new LruCache(50);
  
  public static PAMessage a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord.frienduin, paramMessageRecord.shmsgseq, paramMessageRecord.msgUid, paramMessageRecord.msgData);
  }
  
  public static PAMessage a(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    String str = a(paramString, paramLong1, paramLong2);
    PAMessage localPAMessage = (PAMessage)i.get(str);
    paramString = localPAMessage;
    if (localPAMessage == null)
    {
      paramArrayOfByte = obj.a(paramArrayOfByte);
      paramString = paramArrayOfByte;
      if (paramArrayOfByte != null)
      {
        i.put(str, paramArrayOfByte);
        paramString = paramArrayOfByte;
      }
    }
    return paramString;
  }
  
  private static String a(String paramString, long paramLong1, long paramLong2)
  {
    return paramString + "&" + paramLong1 + "&" + paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wna
 * JD-Core Version:    0.7.0.1
 */