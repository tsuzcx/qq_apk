package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileUploadReq
  extends JceStruct
{
  static int cache_cType;
  static byte[] cache_vData;
  static byte[] cache_vEncryptBuff;
  static byte[] cache_vFileMD5;
  static byte[] cache_vOrgFileMD5;
  static byte[] cache_vSkey;
  static byte[] cache_vTokenKey;
  public byte cKeyType = 8;
  public int cType = 0;
  public byte cVer = 1;
  public long lFromUIN = 0L;
  public long lSessionId = 0L;
  public long lToUIN = 0L;
  public int nRecvVipLevel = 3;
  public int nSendVipLevel = 3;
  public int shWebSvrPort = 0;
  public String strFileName = "";
  public long uDstIns = 1L;
  public long uFileSize = 0L;
  public long uOrgFileType = 0L;
  public long uSrcIns = 1001L;
  public long uWebSvrIP = 0L;
  public byte[] vData = null;
  public byte[] vEncryptBuff = null;
  public byte[] vFileMD5 = null;
  public byte[] vOrgFileMD5 = null;
  public byte[] vSkey = null;
  public byte[] vTokenKey = null;
  
  public FileUploadReq() {}
  
  public FileUploadReq(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, long paramLong3, byte[] paramArrayOfByte2, String paramString, byte paramByte1, byte[] paramArrayOfByte3, long paramLong4, int paramInt4, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte paramByte2, long paramLong5, long paramLong6, long paramLong7, byte[] paramArrayOfByte6, long paramLong8)
  {
    this.lFromUIN = paramLong1;
    this.lToUIN = paramLong2;
    this.cType = paramInt1;
    this.nSendVipLevel = paramInt2;
    this.nRecvVipLevel = paramInt3;
    this.vSkey = paramArrayOfByte1;
    this.uFileSize = paramLong3;
    this.vFileMD5 = paramArrayOfByte2;
    this.strFileName = paramString;
    this.cVer = paramByte1;
    this.vData = paramArrayOfByte3;
    this.uWebSvrIP = paramLong4;
    this.shWebSvrPort = paramInt4;
    this.vEncryptBuff = paramArrayOfByte4;
    this.vTokenKey = paramArrayOfByte5;
    this.cKeyType = paramByte2;
    this.uSrcIns = paramLong5;
    this.uDstIns = paramLong6;
    this.lSessionId = paramLong7;
    this.vOrgFileMD5 = paramArrayOfByte6;
    this.uOrgFileType = paramLong8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUIN = paramJceInputStream.read(this.lFromUIN, 0, true);
    this.lToUIN = paramJceInputStream.read(this.lToUIN, 1, true);
    this.cType = paramJceInputStream.read(this.cType, 2, true);
    this.nSendVipLevel = paramJceInputStream.read(this.nSendVipLevel, 3, true);
    this.nRecvVipLevel = paramJceInputStream.read(this.nRecvVipLevel, 4, true);
    if (cache_vSkey == null)
    {
      cache_vSkey = (byte[])new byte[1];
      ((byte[])cache_vSkey)[0] = 0;
    }
    this.vSkey = ((byte[])paramJceInputStream.read(cache_vSkey, 5, true));
    this.uFileSize = paramJceInputStream.read(this.uFileSize, 6, true);
    if (cache_vFileMD5 == null)
    {
      cache_vFileMD5 = (byte[])new byte[1];
      ((byte[])cache_vFileMD5)[0] = 0;
    }
    this.vFileMD5 = ((byte[])paramJceInputStream.read(cache_vFileMD5, 7, true));
    this.strFileName = paramJceInputStream.readString(8, true);
    this.cVer = paramJceInputStream.read(this.cVer, 9, true);
    if (cache_vData == null)
    {
      cache_vData = (byte[])new byte[1];
      ((byte[])cache_vData)[0] = 0;
    }
    this.vData = ((byte[])paramJceInputStream.read(cache_vData, 10, true));
    this.uWebSvrIP = paramJceInputStream.read(this.uWebSvrIP, 11, false);
    this.shWebSvrPort = paramJceInputStream.read(this.shWebSvrPort, 12, false);
    if (cache_vEncryptBuff == null)
    {
      cache_vEncryptBuff = (byte[])new byte[1];
      ((byte[])cache_vEncryptBuff)[0] = 0;
    }
    this.vEncryptBuff = ((byte[])paramJceInputStream.read(cache_vEncryptBuff, 13, false));
    if (cache_vTokenKey == null)
    {
      cache_vTokenKey = (byte[])new byte[1];
      ((byte[])cache_vTokenKey)[0] = 0;
    }
    this.vTokenKey = ((byte[])paramJceInputStream.read(cache_vTokenKey, 14, false));
    this.cKeyType = paramJceInputStream.read(this.cKeyType, 15, false);
    this.uSrcIns = paramJceInputStream.read(this.uSrcIns, 16, false);
    this.uDstIns = paramJceInputStream.read(this.uDstIns, 17, false);
    this.lSessionId = paramJceInputStream.read(this.lSessionId, 18, false);
    if (cache_vOrgFileMD5 == null)
    {
      cache_vOrgFileMD5 = (byte[])new byte[1];
      ((byte[])cache_vOrgFileMD5)[0] = 0;
    }
    this.vOrgFileMD5 = ((byte[])paramJceInputStream.read(cache_vOrgFileMD5, 19, false));
    this.uOrgFileType = paramJceInputStream.read(this.uOrgFileType, 20, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUIN, 0);
    paramJceOutputStream.write(this.lToUIN, 1);
    paramJceOutputStream.write(this.cType, 2);
    paramJceOutputStream.write(this.nSendVipLevel, 3);
    paramJceOutputStream.write(this.nRecvVipLevel, 4);
    paramJceOutputStream.write(this.vSkey, 5);
    paramJceOutputStream.write(this.uFileSize, 6);
    paramJceOutputStream.write(this.vFileMD5, 7);
    paramJceOutputStream.write(this.strFileName, 8);
    paramJceOutputStream.write(this.cVer, 9);
    paramJceOutputStream.write(this.vData, 10);
    paramJceOutputStream.write(this.uWebSvrIP, 11);
    paramJceOutputStream.write(this.shWebSvrPort, 12);
    if (this.vEncryptBuff != null) {
      paramJceOutputStream.write(this.vEncryptBuff, 13);
    }
    if (this.vTokenKey != null) {
      paramJceOutputStream.write(this.vTokenKey, 14);
    }
    paramJceOutputStream.write(this.cKeyType, 15);
    paramJceOutputStream.write(this.uSrcIns, 16);
    paramJceOutputStream.write(this.uDstIns, 17);
    paramJceOutputStream.write(this.lSessionId, 18);
    if (this.vOrgFileMD5 != null) {
      paramJceOutputStream.write(this.vOrgFileMD5, 19);
    }
    paramJceOutputStream.write(this.uOrgFileType, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.FileUploadReq
 * JD-Core Version:    0.7.0.1
 */