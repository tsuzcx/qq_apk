package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DebugReportReq
  extends JceStruct
{
  static byte[] cache_sContent;
  public int iEncType = 0;
  public int iUin = 0;
  public byte[] sContent = null;
  
  public DebugReportReq() {}
  
  public DebugReportReq(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.iUin = paramInt1;
    this.iEncType = paramInt2;
    this.sContent = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 1, true);
    this.iEncType = paramJceInputStream.read(this.iEncType, 2, true);
    if (cache_sContent == null)
    {
      cache_sContent = (byte[])new byte[1];
      ((byte[])cache_sContent)[0] = 0;
    }
    this.sContent = ((byte[])paramJceInputStream.read(cache_sContent, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 1);
    paramJceOutputStream.write(this.iEncType, 2);
    paramJceOutputStream.write(this.sContent, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.DebugReportReq
 * JD-Core Version:    0.7.0.1
 */