import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class ajpb
{
  public String bRU = "";
  public String bRV = "";
  public String bRW = "";
  public boolean cpC;
  public long expireTime;
  public boolean isShowCard;
  
  public ajpb() {}
  
  public ajpb(boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.isShowCard = paramBoolean1;
    this.cpC = paramBoolean2;
    this.expireTime = paramLong;
    this.bRU = paramString1;
    this.bRV = paramString2;
    this.bRW = paramString3;
  }
  
  public boolean isExpired()
  {
    long l = NetConnInfoCenter.getServerTime();
    return (this.expireTime <= 0L) || (l > this.expireTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajpb
 * JD-Core Version:    0.7.0.1
 */