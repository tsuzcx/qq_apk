package qz_groupphoto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class _LoginInfo
  extends JceStruct
{
  public String strAuthKey = "";
  public String strCookie = "";
  public long uAuthOption;
  public long uAuthType;
  public long uHostUin;
  public long uPtId;
  public long uUserIpNet;
  
  public _LoginInfo() {}
  
  public _LoginInfo(long paramLong1, String paramString1, long paramLong2, long paramLong3, long paramLong4, String paramString2, long paramLong5)
  {
    this.uAuthType = paramLong1;
    this.strAuthKey = paramString1;
    this.uUserIpNet = paramLong2;
    this.uHostUin = paramLong3;
    this.uPtId = paramLong4;
    this.strCookie = paramString2;
    this.uAuthOption = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uAuthType = paramJceInputStream.read(this.uAuthType, 0, false);
    this.strAuthKey = paramJceInputStream.readString(1, false);
    this.uUserIpNet = paramJceInputStream.read(this.uUserIpNet, 2, false);
    this.uHostUin = paramJceInputStream.read(this.uHostUin, 3, false);
    this.uPtId = paramJceInputStream.read(this.uPtId, 4, false);
    this.strCookie = paramJceInputStream.readString(5, false);
    this.uAuthOption = paramJceInputStream.read(this.uAuthOption, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uAuthType, 0);
    if (this.strAuthKey != null) {
      paramJceOutputStream.write(this.strAuthKey, 1);
    }
    paramJceOutputStream.write(this.uUserIpNet, 2);
    paramJceOutputStream.write(this.uHostUin, 3);
    paramJceOutputStream.write(this.uPtId, 4);
    if (this.strCookie != null) {
      paramJceOutputStream.write(this.strCookie, 5);
    }
    paramJceOutputStream.write(this.uAuthOption, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qz_groupphoto._LoginInfo
 * JD-Core Version:    0.7.0.1
 */