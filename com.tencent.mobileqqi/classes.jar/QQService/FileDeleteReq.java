package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileDeleteReq
  extends JceStruct
{
  static int cache_cType;
  public int cType = 0;
  public byte cVer = 1;
  public long lFromUIN = 0L;
  public long lToUIN = 0L;
  public String strFilePath = "";
  
  public FileDeleteReq() {}
  
  public FileDeleteReq(long paramLong1, long paramLong2, int paramInt, String paramString, byte paramByte)
  {
    this.lFromUIN = paramLong1;
    this.lToUIN = paramLong2;
    this.cType = paramInt;
    this.strFilePath = paramString;
    this.cVer = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUIN = paramJceInputStream.read(this.lFromUIN, 0, true);
    this.lToUIN = paramJceInputStream.read(this.lToUIN, 1, true);
    this.cType = paramJceInputStream.read(this.cType, 2, true);
    this.strFilePath = paramJceInputStream.readString(3, true);
    this.cVer = paramJceInputStream.read(this.cVer, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUIN, 0);
    paramJceOutputStream.write(this.lToUIN, 1);
    paramJceOutputStream.write(this.cType, 2);
    paramJceOutputStream.write(this.strFilePath, 3);
    paramJceOutputStream.write(this.cVer, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.FileDeleteReq
 * JD-Core Version:    0.7.0.1
 */