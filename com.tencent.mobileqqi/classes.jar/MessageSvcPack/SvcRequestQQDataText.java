package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestQQDataText
  extends JceStruct
{
  static byte[] cache_vBuf;
  static byte[] cache_vMsgSynCookie;
  public byte cVerifyType = 0;
  public byte[] vBuf = null;
  public byte[] vMsgSynCookie = null;
  
  public SvcRequestQQDataText() {}
  
  public SvcRequestQQDataText(byte paramByte, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.cVerifyType = paramByte;
    this.vBuf = paramArrayOfByte1;
    this.vMsgSynCookie = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 0, false);
    if (cache_vBuf == null)
    {
      cache_vBuf = (byte[])new byte[1];
      ((byte[])cache_vBuf)[0] = 0;
    }
    this.vBuf = ((byte[])paramJceInputStream.read(cache_vBuf, 1, true));
    if (cache_vMsgSynCookie == null)
    {
      cache_vMsgSynCookie = (byte[])new byte[1];
      ((byte[])cache_vMsgSynCookie)[0] = 0;
    }
    this.vMsgSynCookie = ((byte[])paramJceInputStream.read(cache_vMsgSynCookie, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cVerifyType, 0);
    paramJceOutputStream.write(this.vBuf, 1);
    if (this.vMsgSynCookie != null) {
      paramJceOutputStream.write(this.vMsgSynCookie, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestQQDataText
 * JD-Core Version:    0.7.0.1
 */