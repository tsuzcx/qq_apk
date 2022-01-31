package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetSign
  extends JceStruct
{
  static byte[] cache_vA2;
  static byte[] cache_vCiphertext;
  public byte cA2Type = 0;
  public long lUIN = 0L;
  public long uAppID = 0L;
  public long uSSOVer = 0L;
  public byte[] vA2 = null;
  public byte[] vCiphertext = null;
  
  public ReqGetSign() {}
  
  public ReqGetSign(long paramLong1, long paramLong2, long paramLong3, byte paramByte, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.lUIN = paramLong1;
    this.uSSOVer = paramLong2;
    this.uAppID = paramLong3;
    this.cA2Type = paramByte;
    this.vA2 = paramArrayOfByte1;
    this.vCiphertext = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.uSSOVer = paramJceInputStream.read(this.uSSOVer, 1, true);
    this.uAppID = paramJceInputStream.read(this.uAppID, 2, true);
    this.cA2Type = paramJceInputStream.read(this.cA2Type, 3, true);
    if (cache_vA2 == null)
    {
      cache_vA2 = (byte[])new byte[1];
      ((byte[])cache_vA2)[0] = 0;
    }
    this.vA2 = ((byte[])paramJceInputStream.read(cache_vA2, 4, true));
    if (cache_vCiphertext == null)
    {
      cache_vCiphertext = (byte[])new byte[1];
      ((byte[])cache_vCiphertext)[0] = 0;
    }
    this.vCiphertext = ((byte[])paramJceInputStream.read(cache_vCiphertext, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.uSSOVer, 1);
    paramJceOutputStream.write(this.uAppID, 2);
    paramJceOutputStream.write(this.cA2Type, 3);
    paramJceOutputStream.write(this.vA2, 4);
    if (this.vCiphertext != null) {
      paramJceOutputStream.write(this.vCiphertext, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqGetSign
 * JD-Core Version:    0.7.0.1
 */