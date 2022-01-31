package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SSOInfo
  extends JceStruct
{
  public long clientId = 0L;
  public long clientIp = 0L;
  public long ssoIp = 0L;
  public long ssoPort = 0L;
  
  public SSOInfo() {}
  
  public SSOInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.ssoIp = paramLong1;
    this.ssoPort = paramLong2;
    this.clientId = paramLong3;
    this.clientIp = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ssoIp = paramJceInputStream.read(this.ssoIp, 0, true);
    this.ssoPort = paramJceInputStream.read(this.ssoPort, 1, true);
    this.clientId = paramJceInputStream.read(this.clientId, 2, true);
    this.clientIp = paramJceInputStream.read(this.clientIp, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ssoIp, 0);
    paramJceOutputStream.write(this.ssoPort, 1);
    paramJceOutputStream.write(this.clientId, 2);
    paramJceOutputStream.write(this.clientIp, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SSOInfo
 * JD-Core Version:    0.7.0.1
 */