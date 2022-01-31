package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ResponsePushNotify
  extends JceStruct
{
  public byte cReplyCode = 0;
  public long lUin = 0L;
  
  public ResponsePushNotify() {}
  
  public ResponsePushNotify(long paramLong, byte paramByte)
  {
    this.lUin = paramLong;
    this.cReplyCode = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cReplyCode, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     PushNotifyPack.ResponsePushNotify
 * JD-Core Version:    0.7.0.1
 */