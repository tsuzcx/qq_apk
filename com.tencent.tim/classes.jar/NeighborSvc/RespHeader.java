package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespHeader
  extends JceStruct
{
  static int cache_eReplyCode;
  public int eReplyCode;
  public long lMID;
  public short shVersion;
  public String strResult = "";
  
  public RespHeader() {}
  
  public RespHeader(short paramShort, long paramLong, int paramInt, String paramString)
  {
    this.shVersion = paramShort;
    this.lMID = paramLong;
    this.eReplyCode = paramInt;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.lMID = paramJceInputStream.read(this.lMID, 1, true);
    this.eReplyCode = paramJceInputStream.read(this.eReplyCode, 2, true);
    this.strResult = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.lMID, 1);
    paramJceOutputStream.write(this.eReplyCode, 2);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NeighborSvc.RespHeader
 * JD-Core Version:    0.7.0.1
 */