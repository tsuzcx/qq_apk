package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqFunInfo
  extends JceStruct
{
  static byte[] cache_strFuncName;
  public long iVersionSeq = 0L;
  public byte[] strFuncName = null;
  
  public ReqFunInfo() {}
  
  public ReqFunInfo(byte[] paramArrayOfByte, long paramLong)
  {
    this.strFuncName = paramArrayOfByte;
    this.iVersionSeq = paramLong;
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
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strFuncName, 1);
    paramJceOutputStream.write(this.iVersionSeq, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqFunInfo
 * JD-Core Version:    0.7.0.1
 */