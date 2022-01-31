package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class HttpDownloadResp
  extends JceStruct
{
  static byte[] cache_encryKey;
  static VerifyCode cache_stVerifyCode;
  static byte[] cache_vFileData;
  public int encryFrom = 0;
  public byte[] encryKey = null;
  public int encryTo = 0;
  public byte encryType = 0;
  public int iReplyCode = 0;
  public long lMID = 0L;
  public int sessionID = 0;
  public VerifyCode stVerifyCode = null;
  public String strFileName = "";
  public String strResult = "";
  public long uFileLen = 0L;
  public int uSeq = 0;
  public byte[] vFileData = null;
  
  public HttpDownloadResp() {}
  
  public HttpDownloadResp(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, String paramString1, byte paramByte, byte[] paramArrayOfByte1, int paramInt4, int paramInt5, byte[] paramArrayOfByte2, VerifyCode paramVerifyCode, String paramString2)
  {
    this.lMID = paramLong1;
    this.sessionID = paramInt1;
    this.uSeq = paramInt2;
    this.uFileLen = paramLong2;
    this.iReplyCode = paramInt3;
    this.strResult = paramString1;
    this.encryType = paramByte;
    this.encryKey = paramArrayOfByte1;
    this.encryFrom = paramInt4;
    this.encryTo = paramInt5;
    this.vFileData = paramArrayOfByte2;
    this.stVerifyCode = paramVerifyCode;
    this.strFileName = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lMID = paramJceInputStream.read(this.lMID, 0, true);
    this.sessionID = paramJceInputStream.read(this.sessionID, 1, true);
    this.uSeq = paramJceInputStream.read(this.uSeq, 2, true);
    this.uFileLen = paramJceInputStream.read(this.uFileLen, 3, true);
    this.iReplyCode = paramJceInputStream.read(this.iReplyCode, 4, true);
    this.strResult = paramJceInputStream.readString(5, true);
    this.encryType = paramJceInputStream.read(this.encryType, 6, true);
    if (cache_encryKey == null)
    {
      cache_encryKey = (byte[])new byte[1];
      ((byte[])cache_encryKey)[0] = 0;
    }
    this.encryKey = ((byte[])paramJceInputStream.read(cache_encryKey, 7, true));
    this.encryFrom = paramJceInputStream.read(this.encryFrom, 8, true);
    this.encryTo = paramJceInputStream.read(this.encryTo, 9, true);
    if (cache_vFileData == null)
    {
      cache_vFileData = (byte[])new byte[1];
      ((byte[])cache_vFileData)[0] = 0;
    }
    this.vFileData = ((byte[])paramJceInputStream.read(cache_vFileData, 10, true));
    if (cache_stVerifyCode == null) {
      cache_stVerifyCode = new VerifyCode();
    }
    this.stVerifyCode = ((VerifyCode)paramJceInputStream.read(cache_stVerifyCode, 11, false));
    this.strFileName = paramJceInputStream.readString(12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lMID, 0);
    paramJceOutputStream.write(this.sessionID, 1);
    paramJceOutputStream.write(this.uSeq, 2);
    paramJceOutputStream.write(this.uFileLen, 3);
    paramJceOutputStream.write(this.iReplyCode, 4);
    paramJceOutputStream.write(this.strResult, 5);
    paramJceOutputStream.write(this.encryType, 6);
    paramJceOutputStream.write(this.encryKey, 7);
    paramJceOutputStream.write(this.encryFrom, 8);
    paramJceOutputStream.write(this.encryTo, 9);
    paramJceOutputStream.write(this.vFileData, 10);
    if (this.stVerifyCode != null) {
      paramJceOutputStream.write(this.stVerifyCode, 11);
    }
    if (this.strFileName != null) {
      paramJceOutputStream.write(this.strFileName, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     KQQFS.HttpDownloadResp
 * JD-Core Version:    0.7.0.1
 */