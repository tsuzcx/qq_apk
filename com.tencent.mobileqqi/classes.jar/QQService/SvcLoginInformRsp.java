package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcLoginInformRsp
  extends JceStruct
{
  public int iStatus = 11;
  public long lBid = 0L;
  public long lClientIP = 0L;
  public long lLoginTime = 0L;
  public long lUin = 0L;
  public String sAppIdDesc = "";
  public String sAppIdPic = "";
  
  public SvcLoginInformRsp() {}
  
  public SvcLoginInformRsp(long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2, long paramLong3, long paramLong4)
  {
    this.lUin = paramLong1;
    this.lBid = paramLong2;
    this.iStatus = paramInt;
    this.sAppIdDesc = paramString1;
    this.sAppIdPic = paramString2;
    this.lLoginTime = paramLong3;
    this.lClientIP = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.lBid = paramJceInputStream.read(this.lBid, 1, true);
    this.iStatus = paramJceInputStream.read(this.iStatus, 2, true);
    this.sAppIdDesc = paramJceInputStream.readString(3, true);
    this.sAppIdPic = paramJceInputStream.readString(4, true);
    this.lLoginTime = paramJceInputStream.read(this.lLoginTime, 5, true);
    this.lClientIP = paramJceInputStream.read(this.lClientIP, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.lBid, 1);
    paramJceOutputStream.write(this.iStatus, 2);
    paramJceOutputStream.write(this.sAppIdDesc, 3);
    paramJceOutputStream.write(this.sAppIdPic, 4);
    paramJceOutputStream.write(this.lLoginTime, 5);
    paramJceOutputStream.write(this.lClientIP, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcLoginInformRsp
 * JD-Core Version:    0.7.0.1
 */