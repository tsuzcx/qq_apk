package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileDownloadResp
  extends JceStruct
{
  static int cache_cType;
  static byte[] cache_vDownloadURL;
  static byte[] cache_vFileMD5;
  public int cType = 0;
  public long lFromUIN = 0L;
  public long lToUIN = 0L;
  public int nRetCode = 0;
  public short shDownloadPort = 0;
  public String strRetMessage = "";
  public long uDownloadIP = 0L;
  public byte[] vDownloadURL = null;
  public byte[] vFileMD5 = null;
  
  public FileDownloadResp() {}
  
  public FileDownloadResp(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString, long paramLong3, short paramShort, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.lFromUIN = paramLong1;
    this.lToUIN = paramLong2;
    this.cType = paramInt1;
    this.nRetCode = paramInt2;
    this.strRetMessage = paramString;
    this.uDownloadIP = paramLong3;
    this.shDownloadPort = paramShort;
    this.vDownloadURL = paramArrayOfByte1;
    this.vFileMD5 = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUIN = paramJceInputStream.read(this.lFromUIN, 0, true);
    this.lToUIN = paramJceInputStream.read(this.lToUIN, 1, true);
    this.cType = paramJceInputStream.read(this.cType, 2, true);
    this.nRetCode = paramJceInputStream.read(this.nRetCode, 3, true);
    this.strRetMessage = paramJceInputStream.readString(4, true);
    this.uDownloadIP = paramJceInputStream.read(this.uDownloadIP, 5, true);
    this.shDownloadPort = paramJceInputStream.read(this.shDownloadPort, 6, true);
    if (cache_vDownloadURL == null)
    {
      cache_vDownloadURL = (byte[])new byte[1];
      ((byte[])cache_vDownloadURL)[0] = 0;
    }
    this.vDownloadURL = ((byte[])paramJceInputStream.read(cache_vDownloadURL, 7, true));
    if (cache_vFileMD5 == null)
    {
      cache_vFileMD5 = (byte[])new byte[1];
      ((byte[])cache_vFileMD5)[0] = 0;
    }
    this.vFileMD5 = ((byte[])paramJceInputStream.read(cache_vFileMD5, 8, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUIN, 0);
    paramJceOutputStream.write(this.lToUIN, 1);
    paramJceOutputStream.write(this.cType, 2);
    paramJceOutputStream.write(this.nRetCode, 3);
    paramJceOutputStream.write(this.strRetMessage, 4);
    paramJceOutputStream.write(this.uDownloadIP, 5);
    paramJceOutputStream.write(this.shDownloadPort, 6);
    paramJceOutputStream.write(this.vDownloadURL, 7);
    paramJceOutputStream.write(this.vFileMD5, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.FileDownloadResp
 * JD-Core Version:    0.7.0.1
 */