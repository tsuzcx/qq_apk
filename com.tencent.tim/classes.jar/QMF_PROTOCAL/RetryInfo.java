package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RetryInfo
  extends JceStruct
{
  public short Flag;
  public long PkgId;
  public int RetryCount;
  
  public RetryInfo() {}
  
  public RetryInfo(short paramShort, int paramInt, long paramLong)
  {
    this.Flag = paramShort;
    this.RetryCount = paramInt;
    this.PkgId = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Flag = paramJceInputStream.read(this.Flag, 0, true);
    this.RetryCount = paramJceInputStream.read(this.RetryCount, 1, true);
    this.PkgId = paramJceInputStream.read(this.PkgId, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Flag, 0);
    paramJceOutputStream.write(this.RetryCount, 1);
    paramJceOutputStream.write(this.PkgId, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QMF_PROTOCAL.RetryInfo
 * JD-Core Version:    0.7.0.1
 */