package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MsfOnlineInfo
  extends JceStruct
{
  public long appid = 0L;
  public byte bCanKick = 0;
  public long clientid = 0L;
  public long clientip = 0L;
  public int clientport = 0;
  public String info = "";
  public long ssoip = 0L;
  public int ssoport = 0;
  
  public MsfOnlineInfo() {}
  
  public MsfOnlineInfo(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4, String paramString, byte paramByte)
  {
    this.ssoip = paramLong1;
    this.ssoport = paramInt1;
    this.clientip = paramLong2;
    this.clientport = paramInt2;
    this.clientid = paramLong3;
    this.appid = paramLong4;
    this.info = paramString;
    this.bCanKick = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ssoip = paramJceInputStream.read(this.ssoip, 0, true);
    this.ssoport = paramJceInputStream.read(this.ssoport, 1, true);
    this.clientip = paramJceInputStream.read(this.clientip, 2, true);
    this.clientport = paramJceInputStream.read(this.clientport, 3, true);
    this.clientid = paramJceInputStream.read(this.clientid, 4, true);
    this.appid = paramJceInputStream.read(this.appid, 5, true);
    this.info = paramJceInputStream.readString(6, true);
    this.bCanKick = paramJceInputStream.read(this.bCanKick, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ssoip, 0);
    paramJceOutputStream.write(this.ssoport, 1);
    paramJceOutputStream.write(this.clientip, 2);
    paramJceOutputStream.write(this.clientport, 3);
    paramJceOutputStream.write(this.clientid, 4);
    paramJceOutputStream.write(this.appid, 5);
    paramJceOutputStream.write(this.info, 6);
    paramJceOutputStream.write(this.bCanKick, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.MsfOnlineInfo
 * JD-Core Version:    0.7.0.1
 */