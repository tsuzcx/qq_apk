package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FuncInfo
  extends JceStruct
{
  static byte[] cache_strFuncName;
  static byte[] cache_strValue;
  public long iVersionSeq = 0L;
  public byte[] strFuncName = null;
  public byte[] strValue = null;
  
  public FuncInfo() {}
  
  public FuncInfo(byte[] paramArrayOfByte1, long paramLong, byte[] paramArrayOfByte2)
  {
    this.strFuncName = paramArrayOfByte1;
    this.iVersionSeq = paramLong;
    this.strValue = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_strFuncName == null)
    {
      cache_strFuncName = (byte[])new byte[1];
      ((byte[])cache_strFuncName)[0] = 0;
    }
    this.strFuncName = ((byte[])paramJceInputStream.read(cache_strFuncName, 1, true));
    this.iVersionSeq = paramJceInputStream.read(this.iVersionSeq, 2, true);
    if (cache_strValue == null)
    {
      cache_strValue = (byte[])new byte[1];
      ((byte[])cache_strValue)[0] = 0;
    }
    this.strValue = ((byte[])paramJceInputStream.read(cache_strValue, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strFuncName, 1);
    paramJceOutputStream.write(this.iVersionSeq, 2);
    paramJceOutputStream.write(this.strValue, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.FuncInfo
 * JD-Core Version:    0.7.0.1
 */