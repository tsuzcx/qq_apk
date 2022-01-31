package wifiphoto;

public class WifiPhotoMsgStrategy
{
  private long a = 0L;
  
  public long a()
  {
    if (this.a == 0L) {
      this.a = (System.currentTimeMillis() / 1000L);
    }
    long l = this.a + 1L;
    this.a = l;
    return l;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public boolean a(long paramLong)
  {
    return paramLong == this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     wifiphoto.WifiPhotoMsgStrategy
 * JD-Core Version:    0.7.0.1
 */