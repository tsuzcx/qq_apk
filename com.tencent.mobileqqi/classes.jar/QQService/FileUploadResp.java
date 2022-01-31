package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileUploadResp
  extends JceStruct
{
  static int cache_cType;
  static byte[] cache_vFileKey;
  public int cType = 0;
  public boolean isFileExist = false;
  public long lFromUIN = 0L;
  public long lToUIN = 0L;
  public int nPackSize = 0;
  public int nRangFrom = 0;
  public int nRetCode = 0;
  public short shUploadPort = 0;
  public String strFilePath = "";
  public String strRetMessage = "";
  public long uUploadIP = 0L;
  public byte[] vFileKey = null;
  
  public FileUploadResp() {}
  
  public FileUploadResp(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString1, int paramInt3, long paramLong3, short paramShort, String paramString2, byte[] paramArrayOfByte, int paramInt4, boolean paramBoolean)
  {
    this.lFromUIN = paramLong1;
    this.lToUIN = paramLong2;
    this.cType = paramInt1;
    this.nRetCode = paramInt2;
    this.strRetMessage = paramString1;
    this.nRangFrom = paramInt3;
    this.uUploadIP = paramLong3;
    this.shUploadPort = paramShort;
    this.strFilePath = paramString2;
    this.vFileKey = paramArrayOfByte;
    this.nPackSize = paramInt4;
    this.isFileExist = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUIN = paramJceInputStream.read(this.lFromUIN, 0, true);
    this.lToUIN = paramJceInputStream.read(this.lToUIN, 1, true);
    this.cType = paramJceInputStream.read(this.cType, 2, true);
    this.nRetCode = paramJceInputStream.read(this.nRetCode, 3, true);
    this.strRetMessage = paramJceInputStream.readString(4, true);
    this.nRangFrom = paramJceInputStream.read(this.nRangFrom, 5, true);
    this.uUploadIP = paramJceInputStream.read(this.uUploadIP, 6, true);
    this.shUploadPort = paramJceInputStream.read(this.shUploadPort, 7, true);
    this.strFilePath = paramJceInputStream.readString(8, true);
    if (cache_vFileKey == null)
    {
      cache_vFileKey = (byte[])new byte[1];
      ((byte[])cache_vFileKey)[0] = 0;
    }
    this.vFileKey = ((byte[])paramJceInputStream.read(cache_vFileKey, 9, true));
    this.nPackSize = paramJceInputStream.read(this.nPackSize, 10, true);
    this.isFileExist = paramJceInputStream.read(this.isFileExist, 11, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUIN, 0);
    paramJceOutputStream.write(this.lToUIN, 1);
    paramJceOutputStream.write(this.cType, 2);
    paramJceOutputStream.write(this.nRetCode, 3);
    paramJceOutputStream.write(this.strRetMessage, 4);
    paramJceOutputStream.write(this.nRangFrom, 5);
    paramJceOutputStream.write(this.uUploadIP, 6);
    paramJceOutputStream.write(this.shUploadPort, 7);
    paramJceOutputStream.write(this.strFilePath, 8);
    paramJceOutputStream.write(this.vFileKey, 9);
    paramJceOutputStream.write(this.nPackSize, 10);
    paramJceOutputStream.write(this.isFileExist, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.FileUploadResp
 * JD-Core Version:    0.7.0.1
 */