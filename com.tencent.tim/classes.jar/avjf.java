import android.content.ContentValues;
import com.tencent.mobileqq.data.ChatMessage;

public final class avjf
{
  public long azx = 1L;
  public Object gc;
  public String mNickName = "";
  public long mSeq = -1L;
  
  public avjf(long paramLong1, long paramLong2, ContentValues paramContentValues)
  {
    this.mSeq = paramLong1;
    this.azx = paramLong2;
    this.gc = paramContentValues;
    try
    {
      this.mNickName = paramContentValues.getAsString("entityNickName");
      return;
    }
    catch (Exception paramContentValues) {}
  }
  
  public avjf(long paramLong1, long paramLong2, Object paramObject, String paramString)
  {
    this.mSeq = paramLong1;
    this.azx = paramLong2;
    this.gc = paramObject;
    this.mNickName = paramString;
  }
  
  public static class a
  {
    public ChatMessage mMessage;
    public String mNickName;
    
    public a(ChatMessage paramChatMessage, String paramString)
    {
      this.mMessage = paramChatMessage;
      this.mNickName = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avjf
 * JD-Core Version:    0.7.0.1
 */