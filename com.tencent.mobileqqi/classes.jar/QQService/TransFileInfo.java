package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TransFileInfo
  extends JceStruct
{
  static int cache_cType;
  static byte[] cache_vPartMd5;
  static byte[] cache_vTriMd5;
  public byte cFileType = 0;
  public int cType = 0;
  public long lUIN = 0L;
  public int shPort = 0;
  public String strFileName = "";
  public String strUrl = "";
  public String strUuid = "";
  public long uFileSize = 0L;
  public long uIP = 0L;
  public long uLifeTime = 0L;
  public long uUploadTime = 0L;
  public byte[] vPartMd5 = null;
  public byte[] vTriMd5 = null;
  
  public TransFileInfo() {}
  
  public TransFileInfo(long paramLong1, int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString3, long paramLong2, long paramLong3, int paramInt2, long paramLong4, long paramLong5, byte paramByte)
  {
    this.lUIN = paramLong1;
    this.cType = paramInt1;
    this.strUuid = paramString1;
    this.strUrl = paramString2;
    this.vPartMd5 = paramArrayOfByte1;
    this.vTriMd5 = paramArrayOfByte2;
    this.strFileName = paramString3;
    this.uFileSize = paramLong2;
    this.uIP = paramLong3;
    this.shPort = paramInt2;
    this.uLifeTime = paramLong4;
    this.uUploadTime = paramLong5;
    this.cFileType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.cType = paramJceInputStream.read(this.cType, 1, true);
    this.strUuid = paramJceInputStream.readString(2, true);
    this.strUrl = paramJceInputStream.readString(3, true);
    if (cache_vPartMd5 == null)
    {
      cache_vPartMd5 = (byte[])new byte[1];
      ((byte[])cache_vPartMd5)[0] = 0;
    }
    this.vPartMd5 = ((byte[])paramJceInputStream.read(cache_vPartMd5, 4, true));
    if (cache_vTriMd5 == null)
    {
      cache_vTriMd5 = (byte[])new byte[1];
      ((byte[])cache_vTriMd5)[0] = 0;
    }
    this.vTriMd5 = ((byte[])paramJceInputStream.read(cache_vTriMd5, 5, true));
    this.strFileName = paramJceInputStream.readString(6, true);
    this.uFileSize = paramJceInputStream.read(this.uFileSize, 7, true);
    this.uIP = paramJceInputStream.read(this.uIP, 8, true);
    this.shPort = paramJceInputStream.read(this.shPort, 9, true);
    this.uLifeTime = paramJceInputStream.read(this.uLifeTime, 10, true);
    this.uUploadTime = paramJceInputStream.read(this.uUploadTime, 11, true);
    this.cFileType = paramJceInputStream.read(this.cFileType, 12, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.cType, 1);
    paramJceOutputStream.write(this.strUuid, 2);
    paramJceOutputStream.write(this.strUrl, 3);
    paramJceOutputStream.write(this.vPartMd5, 4);
    paramJceOutputStream.write(this.vTriMd5, 5);
    paramJceOutputStream.write(this.strFileName, 6);
    paramJceOutputStream.write(this.uFileSize, 7);
    paramJceOutputStream.write(this.uIP, 8);
    paramJceOutputStream.write(this.shPort, 9);
    paramJceOutputStream.write(this.uLifeTime, 10);
    paramJceOutputStream.write(this.uUploadTime, 11);
    paramJceOutputStream.write(this.cFileType, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.TransFileInfo
 * JD-Core Version:    0.7.0.1
 */