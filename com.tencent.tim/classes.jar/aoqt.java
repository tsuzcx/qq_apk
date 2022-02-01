import android.support.annotation.NonNull;

public class aoqt
  implements aoqs
{
  public boolean cOe;
  public String ip = "";
  public int port;
  
  public String getIp()
  {
    return this.ip;
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public boolean isIpv6()
  {
    return this.cOe;
  }
  
  @NonNull
  public String toString()
  {
    if (this.ip == null) {
      this.ip = "";
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(this.ip).append(":").append(this.port);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqt
 * JD-Core Version:    0.7.0.1
 */