package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MsgItem
  extends JceStruct
{
  static byte[] cache_MsgContent;
  public byte[] MsgContent = null;
  public byte cType = 0;
  
  public MsgItem() {}
  
  public MsgItem(byte paramByte, byte[] paramArrayOfByte)
  {
    this.cType = paramByte;
    this.MsgContent = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cType = paramJceInputStream.read(this.cType, 0, true);
    if (cache_MsgContent == null)
    {
      cache_MsgContent = (byte[])new byte[1];
      ((byte[])cache_MsgContent)[0] = 0;
    }
    this.MsgContent = ((byte[])paramJceInputStream.read(cache_MsgContent, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cType, 0);
    paramJceOutputStream.write(this.MsgContent, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.MsgItem
 * JD-Core Version:    0.7.0.1
 */