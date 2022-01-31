package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileQueryReq
  extends JceStruct
{
  static int cache_cType;
  public byte cQueryType = 0;
  public int cType = 0;
  public byte cVer = 1;
  public long lFromUIN = 0L;
  public long lToUIN = 0L;
  public short shBegin = 0;
  public short shCount = 0;
  public String strFilePath = "";
  
  public FileQueryReq() {}
  
  public FileQueryReq(long paramLong1, long paramLong2, int paramInt, byte paramByte1, short paramShort1, short paramShort2, byte paramByte2, String paramString)
  {
    this.lFromUIN = paramLong1;
    this.lToUIN = paramLong2;
    this.cType = paramInt;
    this.cQueryType = paramByte1;
    this.shBegin = paramShort1;
    this.shCount = paramShort2;
    this.cVer = paramByte2;
    this.strFilePath = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUIN = paramJceInputStream.read(this.lFromUIN, 0, true);
    this.lToUIN = paramJceInputStream.read(this.lToUIN, 1, true);
    this.cType = paramJceInputStream.read(this.cType, 2, true);
    this.cQueryType = paramJceInputStream.read(this.cQueryType, 3, true);
    this.shBegin = paramJceInputStream.read(this.shBegin, 4, true);
    this.shCount = paramJceInputStream.read(this.shCount, 5, true);
    this.cVer = paramJceInputStream.read(this.cVer, 6, true);
    this.strFilePath = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUIN, 0);
    paramJceOutputStream.write(this.lToUIN, 1);
    paramJceOutputStream.write(this.cType, 2);
    paramJceOutputStream.write(this.cQueryType, 3);
    paramJceOutputStream.write(this.shBegin, 4);
    paramJceOutputStream.write(this.shCount, 5);
    paramJceOutputStream.write(this.cVer, 6);
    if (this.strFilePath != null) {
      paramJceOutputStream.write(this.strFilePath, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.FileQueryReq
 * JD-Core Version:    0.7.0.1
 */