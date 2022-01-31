package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqParaInfo
  extends JceStruct
{
  static byte[] cache_strName;
  static byte[] cache_strValue;
  public byte[] strName = null;
  public byte[] strValue = null;
  
  public ReqParaInfo() {}
  
  public ReqParaInfo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.strName = paramArrayOfByte1;
    this.strValue = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_strName == null)
    {
      cache_strName = (byte[])new byte[1];
      ((byte[])cache_strName)[0] = 0;
    }
    this.strName = ((byte[])paramJceInputStream.read(cache_strName, 1, true));
    if (cache_strValue == null)
    {
      cache_strValue = (byte[])new byte[1];
      ((byte[])cache_strValue)[0] = 0;
    }
    this.strValue = ((byte[])paramJceInputStream.read(cache_strValue, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strName, 1);
    paramJceOutputStream.write(this.strValue, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqParaInfo
 * JD-Core Version:    0.7.0.1
 */