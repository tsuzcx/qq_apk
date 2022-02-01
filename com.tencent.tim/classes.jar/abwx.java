public class abwx
{
  public String msg;
  public long serverTime;
  public long timestamp;
  
  public abwx(String paramString, long paramLong1, long paramLong2)
  {
    this.msg = paramString;
    this.timestamp = paramLong1;
    this.serverTime = paramLong2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.msg).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abwx
 * JD-Core Version:    0.7.0.1
 */