package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespDownload
  extends JceStruct
{
  static byte[] cache_vFileMD5;
  public byte cSumCmd = 0;
  public long lDownloadIP = 0L;
  public int lReplyCode = 0;
  public long lReserve = 0L;
  public short shDownloadPort = 0;
  public String strDownloadURL = "";
  public String strReserve = "";
  public String strResult = "";
  public byte[] vFileMD5 = null;
  
  public RespDownload() {}
  
  public RespDownload(byte paramByte, int paramInt, String paramString1, long paramLong1, short paramShort, String paramString2, byte[] paramArrayOfByte, long paramLong2, String paramString3)
  {
    this.cSumCmd = paramByte;
    this.lReplyCode = paramInt;
    this.strResult = paramString1;
    this.lDownloadIP = paramLong1;
    this.shDownloadPort = paramShort;
    this.strDownloadURL = paramString2;
    this.vFileMD5 = paramArrayOfByte;
    this.lReserve = paramLong2;
    this.strReserve = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cSumCmd = paramJceInputStream.read(this.cSumCmd, 0, true);
    this.lReplyCode = paramJceInputStream.read(this.lReplyCode, 1, true);
    this.strResult = paramJceInputStream.readString(2, true);
    this.lDownloadIP = paramJceInputStream.read(this.lDownloadIP, 3, true);
    this.shDownloadPort = paramJceInputStream.read(this.shDownloadPort, 4, true);
    this.strDownloadURL = paramJceInputStream.readString(5, true);
    if (cache_vFileMD5 == null)
    {
      cache_vFileMD5 = (byte[])new byte[1];
      ((byte[])cache_vFileMD5)[0] = 0;
    }
    this.vFileMD5 = ((byte[])paramJceInputStream.read(cache_vFileMD5, 6, true));
    this.lReserve = paramJceInputStream.read(this.lReserve, 7, true);
    this.strReserve = paramJceInputStream.readString(8, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cSumCmd, 0);
    paramJceOutputStream.write(this.lReplyCode, 1);
    paramJceOutputStream.write(this.strResult, 2);
    paramJceOutputStream.write(this.lDownloadIP, 3);
    paramJceOutputStream.write(this.shDownloadPort, 4);
    paramJceOutputStream.write(this.strDownloadURL, 5);
    paramJceOutputStream.write(this.vFileMD5, 6);
    paramJceOutputStream.write(this.lReserve, 7);
    paramJceOutputStream.write(this.strReserve, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespDownload
 * JD-Core Version:    0.7.0.1
 */