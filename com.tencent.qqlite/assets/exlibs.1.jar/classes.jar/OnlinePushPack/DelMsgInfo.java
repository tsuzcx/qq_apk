package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DelMsgInfo
  extends JceStruct
{
  static byte[] cache_vMsgCookies;
  public long lFromUin = 0L;
  public short shMsgSeq = 0;
  public long uMsgTime = 0L;
  public byte[] vMsgCookies = null;
  
  public DelMsgInfo() {}
  
  public DelMsgInfo(long paramLong1, long paramLong2, short paramShort, byte[] paramArrayOfByte)
  {
    this.lFromUin = paramLong1;
    this.uMsgTime = paramLong2;
    this.shMsgSeq = paramShort;
    this.vMsgCookies = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUin = paramJceInputStream.read(this.lFromUin, 0, true);
    this.uMsgTime = paramJceInputStream.read(this.uMsgTime, 1, true);
    this.shMsgSeq = paramJceInputStream.read(this.shMsgSeq, 2, true);
    if (cache_vMsgCookies == null)
    {
      cache_vMsgCookies = (byte[])new byte[1];
      ((byte[])cache_vMsgCookies)[0] = 0;
    }
    this.vMsgCookies = ((byte[])paramJceInputStream.read(cache_vMsgCookies, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUin, 0);
    paramJceOutputStream.write(this.uMsgTime, 1);
    paramJceOutputStream.write(this.shMsgSeq, 2);
    if (this.vMsgCookies != null) {
      paramJceOutputStream.write(this.vMsgCookies, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     OnlinePushPack.DelMsgInfo
 * JD-Core Version:    0.7.0.1
 */