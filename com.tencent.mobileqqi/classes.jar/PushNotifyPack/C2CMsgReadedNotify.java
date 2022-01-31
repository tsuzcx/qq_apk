package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class C2CMsgReadedNotify
  extends JceStruct
{
  public long lLastReadTime = 0L;
  public long lPeerUin = 0L;
  
  public C2CMsgReadedNotify() {}
  
  public C2CMsgReadedNotify(long paramLong1, long paramLong2)
  {
    this.lPeerUin = paramLong1;
    this.lLastReadTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lPeerUin = paramJceInputStream.read(this.lPeerUin, 0, false);
    this.lLastReadTime = paramJceInputStream.read(this.lLastReadTime, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lPeerUin, 0);
    paramJceOutputStream.write(this.lLastReadTime, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     PushNotifyPack.C2CMsgReadedNotify
 * JD-Core Version:    0.7.0.1
 */