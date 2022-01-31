package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqUpload
  extends JceStruct
{
  static byte[] cache_vFileMD5;
  public byte cSumCmd = 0;
  public long lFileSize = 0L;
  public long lFromUIN = 0L;
  public long lFromVipLevel = 0L;
  public long lReserve = 0L;
  public long lSeq = 0L;
  public long lToUIN = 0L;
  public long lToVipLevel = 0L;
  public String strFileName = "";
  public String strReserve = "";
  public String strSession = "";
  public byte[] vFileMD5 = null;
  
  public ReqUpload() {}
  
  public ReqUpload(byte paramByte, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString1, long paramLong6, byte[] paramArrayOfByte, String paramString2, long paramLong7, String paramString3)
  {
    this.cSumCmd = paramByte;
    this.lFromUIN = paramLong1;
    this.lToUIN = paramLong2;
    this.lFromVipLevel = paramLong3;
    this.lToVipLevel = paramLong4;
    this.lSeq = paramLong5;
    this.strSession = paramString1;
    this.lFileSize = paramLong6;
    this.vFileMD5 = paramArrayOfByte;
    this.strFileName = paramString2;
    this.lReserve = paramLong7;
    this.strReserve = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cSumCmd = paramJceInputStream.read(this.cSumCmd, 0, true);
    this.lFromUIN = paramJceInputStream.read(this.lFromUIN, 1, true);
    this.lToUIN = paramJceInputStream.read(this.lToUIN, 2, true);
    this.lFromVipLevel = paramJceInputStream.read(this.lFromVipLevel, 3, true);
    this.lToVipLevel = paramJceInputStream.read(this.lToVipLevel, 4, true);
    this.lSeq = paramJceInputStream.read(this.lSeq, 5, true);
    this.strSession = paramJceInputStream.readString(6, true);
    this.lFileSize = paramJceInputStream.read(this.lFileSize, 7, true);
    if (cache_vFileMD5 == null)
    {
      cache_vFileMD5 = (byte[])new byte[1];
      ((byte[])cache_vFileMD5)[0] = 0;
    }
    this.vFileMD5 = ((byte[])paramJceInputStream.read(cache_vFileMD5, 8, true));
    this.strFileName = paramJceInputStream.readString(9, true);
    this.lReserve = paramJceInputStream.read(this.lReserve, 10, true);
    this.strReserve = paramJceInputStream.readString(11, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cSumCmd, 0);
    paramJceOutputStream.write(this.lFromUIN, 1);
    paramJceOutputStream.write(this.lToUIN, 2);
    paramJceOutputStream.write(this.lFromVipLevel, 3);
    paramJceOutputStream.write(this.lToVipLevel, 4);
    paramJceOutputStream.write(this.lSeq, 5);
    paramJceOutputStream.write(this.strSession, 6);
    paramJceOutputStream.write(this.lFileSize, 7);
    paramJceOutputStream.write(this.vFileMD5, 8);
    paramJceOutputStream.write(this.strFileName, 9);
    paramJceOutputStream.write(this.lReserve, 10);
    paramJceOutputStream.write(this.strReserve, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqUpload
 * JD-Core Version:    0.7.0.1
 */