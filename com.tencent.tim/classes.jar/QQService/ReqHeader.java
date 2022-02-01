package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqHeader
  extends JceStruct
{
  public int iSeq;
  public long lMID;
  public short shVersion;
  
  public ReqHeader() {}
  
  public ReqHeader(short paramShort, int paramInt, long paramLong)
  {
    this.shVersion = paramShort;
    this.iSeq = paramInt;
    this.lMID = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
    this.lMID = paramJceInputStream.read(this.lMID, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.lMID, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.ReqHeader
 * JD-Core Version:    0.7.0.1
 */