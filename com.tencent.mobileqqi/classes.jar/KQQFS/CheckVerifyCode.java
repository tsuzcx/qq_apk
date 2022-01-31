package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CheckVerifyCode
  extends JceStruct
{
  static byte[] cache_vEncryptUsrInfo;
  public String strVerifyCode = "";
  public byte[] vEncryptUsrInfo = null;
  
  public CheckVerifyCode() {}
  
  public CheckVerifyCode(byte[] paramArrayOfByte, String paramString)
  {
    this.vEncryptUsrInfo = paramArrayOfByte;
    this.strVerifyCode = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vEncryptUsrInfo == null)
    {
      cache_vEncryptUsrInfo = (byte[])new byte[1];
      ((byte[])cache_vEncryptUsrInfo)[0] = 0;
    }
    this.vEncryptUsrInfo = ((byte[])paramJceInputStream.read(cache_vEncryptUsrInfo, 0, true));
    this.strVerifyCode = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vEncryptUsrInfo, 0);
    paramJceOutputStream.write(this.strVerifyCode, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     KQQFS.CheckVerifyCode
 * JD-Core Version:    0.7.0.1
 */