package mqq.observer;

public class ServerNotifyObserver
{
  private String key;
  private int seq;
  
  public String getKey()
  {
    return this.key;
  }
  
  public int getSeq()
  {
    return this.seq;
  }
  
  public void onReceiveVerifyCode(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte) {}
  
  public void onVerifyClose() {}
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setSeq(int paramInt)
  {
    this.seq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     mqq.observer.ServerNotifyObserver
 * JD-Core Version:    0.7.0.1
 */