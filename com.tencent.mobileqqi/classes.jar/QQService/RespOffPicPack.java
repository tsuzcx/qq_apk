package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespOffPicPack
  extends JceStruct
{
  static byte[] cache_vBody;
  public int iReplyCode = 0;
  public long lUIN = 0L;
  public String strReplyReason = "";
  public byte[] vBody = null;
  
  public RespOffPicPack() {}
  
  public RespOffPicPack(long paramLong, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.lUIN = paramLong;
    this.iReplyCode = paramInt;
    this.strReplyReason = paramString;
    this.vBody = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.iReplyCode = paramJceInputStream.read(this.iReplyCode, 1, true);
    this.strReplyReason = paramJceInputStream.readString(2, true);
    if (cache_vBody == null)
    {
      cache_vBody = (byte[])new byte[1];
      ((byte[])cache_vBody)[0] = 0;
    }
    this.vBody = ((byte[])paramJceInputStream.read(cache_vBody, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.iReplyCode, 1);
    paramJceOutputStream.write(this.strReplyReason, 2);
    paramJceOutputStream.write(this.vBody, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespOffPicPack
 * JD-Core Version:    0.7.0.1
 */