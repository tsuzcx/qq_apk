package GroupPic;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespHeader
  extends JceStruct
{
  static int cache_eReplyCode;
  public int eReplyCode = 0;
  public int iSeq = 0;
  public long lUin = 0L;
  public short shVer = 0;
  public String strResult = "";
  
  public RespHeader() {}
  
  public RespHeader(int paramInt1, short paramShort, long paramLong, int paramInt2, String paramString)
  {
    this.iSeq = paramInt1;
    this.shVer = paramShort;
    this.lUin = paramLong;
    this.eReplyCode = paramInt2;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iSeq = paramJceInputStream.read(this.iSeq, 0, true);
    this.shVer = paramJceInputStream.read(this.shVer, 1, true);
    this.lUin = paramJceInputStream.read(this.lUin, 2, true);
    this.eReplyCode = paramJceInputStream.read(this.eReplyCode, 3, true);
    this.strResult = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iSeq, 0);
    paramJceOutputStream.write(this.shVer, 1);
    paramJceOutputStream.write(this.lUin, 2);
    paramJceOutputStream.write(this.eReplyCode, 3);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     GroupPic.RespHeader
 * JD-Core Version:    0.7.0.1
 */