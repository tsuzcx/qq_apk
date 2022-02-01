package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespGetSign
  extends JceStruct
{
  static byte[] cache_vKey;
  static byte[] cache_vSign;
  public int iReplyCode;
  public long lUIN;
  public byte[] vKey;
  public byte[] vSign;
  
  public RespGetSign() {}
  
  public RespGetSign(long paramLong, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.lUIN = paramLong;
    this.iReplyCode = paramInt;
    this.vKey = paramArrayOfByte1;
    this.vSign = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.iReplyCode = paramJceInputStream.read(this.iReplyCode, 1, true);
    if (cache_vKey == null)
    {
      cache_vKey = (byte[])new byte[1];
      ((byte[])cache_vKey)[0] = 0;
    }
    this.vKey = ((byte[])paramJceInputStream.read(cache_vKey, 2, true));
    if (cache_vSign == null)
    {
      cache_vSign = (byte[])new byte[1];
      ((byte[])cache_vSign)[0] = 0;
    }
    this.vSign = ((byte[])paramJceInputStream.read(cache_vSign, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.iReplyCode, 1);
    paramJceOutputStream.write(this.vKey, 2);
    paramJceOutputStream.write(this.vSign, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.RespGetSign
 * JD-Core Version:    0.7.0.1
 */