package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PushCardMsg
  extends JceStruct
{
  static int cache_ePushType;
  static byte[] cache_vPushInfo;
  public int ePushType = PushType.PUSH_TYPE_NONE.value();
  public byte[] vPushInfo;
  
  public PushCardMsg() {}
  
  public PushCardMsg(int paramInt, byte[] paramArrayOfByte)
  {
    this.ePushType = paramInt;
    this.vPushInfo = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ePushType = paramJceInputStream.read(this.ePushType, 0, true);
    if (cache_vPushInfo == null)
    {
      cache_vPushInfo = (byte[])new byte[1];
      ((byte[])cache_vPushInfo)[0] = 0;
    }
    this.vPushInfo = ((byte[])paramJceInputStream.read(cache_vPushInfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ePushType, 0);
    paramJceOutputStream.write(this.vPushInfo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.PushCardMsg
 * JD-Core Version:    0.7.0.1
 */