package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BigDataIpInfo
  extends JceStruct
{
  public String sIp = "";
  public long uPort = 0L;
  public long uType = 0L;
  
  public BigDataIpInfo() {}
  
  public BigDataIpInfo(long paramLong1, String paramString, long paramLong2)
  {
    this.uType = paramLong1;
    this.sIp = paramString;
    this.uPort = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uType = paramJceInputStream.read(this.uType, 0, true);
    this.sIp = paramJceInputStream.readString(1, true);
    this.uPort = paramJceInputStream.read(this.uPort, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uType, 0);
    paramJceOutputStream.write(this.sIp, 1);
    paramJceOutputStream.write(this.uPort, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ConfigPush.BigDataIpInfo
 * JD-Core Version:    0.7.0.1
 */