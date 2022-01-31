package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MsgType0x210SubMsgType0xa
  extends JceStruct
{
  static byte[] cache_strFileName;
  static byte[] cache_strOriginfile_md5;
  static byte[] cache_vMd5;
  static byte[] cache_vTokenKey;
  static byte[] cache_vUrlNotify;
  public long lSessionId = 0L;
  public byte[] strFileName = null;
  public byte[] strOriginfile_md5 = null;
  public long uDstAppId = 0L;
  public long uDstInstId = 0L;
  public long uDstUin = 0L;
  public long uFileLen = 0L;
  public long uOriginfiletype = 0L;
  public long uSeq = 0L;
  public long uServerIp = 0L;
  public long uServerPort = 0L;
  public long uSrcAppId = 0L;
  public long uSrcInstId = 0L;
  public long uType = 0L;
  public byte[] vMd5 = null;
  public byte[] vTokenKey = null;
  public byte[] vUrlNotify = null;
  
  public MsgType0x210SubMsgType0xa() {}
  
  public MsgType0x210SubMsgType0xa(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong9, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, long paramLong10, byte[] paramArrayOfByte5, long paramLong11, long paramLong12)
  {
    this.uSrcAppId = paramLong1;
    this.uSrcInstId = paramLong2;
    this.uDstAppId = paramLong3;
    this.uDstInstId = paramLong4;
    this.uDstUin = paramLong5;
    this.uType = paramLong6;
    this.uServerIp = paramLong7;
    this.uServerPort = paramLong8;
    this.vUrlNotify = paramArrayOfByte1;
    this.vTokenKey = paramArrayOfByte2;
    this.uFileLen = paramLong9;
    this.strFileName = paramArrayOfByte3;
    this.vMd5 = paramArrayOfByte4;
    this.lSessionId = paramLong10;
    this.strOriginfile_md5 = paramArrayOfByte5;
    this.uOriginfiletype = paramLong11;
    this.uSeq = paramLong12;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uSrcAppId = paramJceInputStream.read(this.uSrcAppId, 0, false);
    this.uSrcInstId = paramJceInputStream.read(this.uSrcInstId, 1, false);
    this.uDstAppId = paramJceInputStream.read(this.uDstAppId, 2, false);
    this.uDstInstId = paramJceInputStream.read(this.uDstInstId, 3, false);
    this.uDstUin = paramJceInputStream.read(this.uDstUin, 4, false);
    this.uType = paramJceInputStream.read(this.uType, 5, false);
    this.uServerIp = paramJceInputStream.read(this.uServerIp, 6, false);
    this.uServerPort = paramJceInputStream.read(this.uServerPort, 7, false);
    if (cache_vUrlNotify == null)
    {
      cache_vUrlNotify = (byte[])new byte[1];
      ((byte[])cache_vUrlNotify)[0] = 0;
    }
    this.vUrlNotify = ((byte[])paramJceInputStream.read(cache_vUrlNotify, 8, false));
    if (cache_vTokenKey == null)
    {
      cache_vTokenKey = (byte[])new byte[1];
      ((byte[])cache_vTokenKey)[0] = 0;
    }
    this.vTokenKey = ((byte[])paramJceInputStream.read(cache_vTokenKey, 9, false));
    this.uFileLen = paramJceInputStream.read(this.uFileLen, 10, false);
    if (cache_strFileName == null)
    {
      cache_strFileName = (byte[])new byte[1];
      ((byte[])cache_strFileName)[0] = 0;
    }
    this.strFileName = ((byte[])paramJceInputStream.read(cache_strFileName, 11, false));
    if (cache_vMd5 == null)
    {
      cache_vMd5 = (byte[])new byte[1];
      ((byte[])cache_vMd5)[0] = 0;
    }
    this.vMd5 = ((byte[])paramJceInputStream.read(cache_vMd5, 12, false));
    this.lSessionId = paramJceInputStream.read(this.lSessionId, 13, false);
    if (cache_strOriginfile_md5 == null)
    {
      cache_strOriginfile_md5 = (byte[])new byte[1];
      ((byte[])cache_strOriginfile_md5)[0] = 0;
    }
    this.strOriginfile_md5 = ((byte[])paramJceInputStream.read(cache_strOriginfile_md5, 14, false));
    this.uOriginfiletype = paramJceInputStream.read(this.uOriginfiletype, 15, false);
    this.uSeq = paramJceInputStream.read(this.uSeq, 16, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uSrcAppId, 0);
    paramJceOutputStream.write(this.uSrcInstId, 1);
    paramJceOutputStream.write(this.uDstAppId, 2);
    paramJceOutputStream.write(this.uDstInstId, 3);
    paramJceOutputStream.write(this.uDstUin, 4);
    paramJceOutputStream.write(this.uType, 5);
    paramJceOutputStream.write(this.uServerIp, 6);
    paramJceOutputStream.write(this.uServerPort, 7);
    if (this.vUrlNotify != null) {
      paramJceOutputStream.write(this.vUrlNotify, 8);
    }
    if (this.vTokenKey != null) {
      paramJceOutputStream.write(this.vTokenKey, 9);
    }
    paramJceOutputStream.write(this.uFileLen, 10);
    if (this.strFileName != null) {
      paramJceOutputStream.write(this.strFileName, 11);
    }
    if (this.vMd5 != null) {
      paramJceOutputStream.write(this.vMd5, 12);
    }
    paramJceOutputStream.write(this.lSessionId, 13);
    if (this.strOriginfile_md5 != null) {
      paramJceOutputStream.write(this.strOriginfile_md5, 14);
    }
    paramJceOutputStream.write(this.uOriginfiletype, 15);
    paramJceOutputStream.write(this.uSeq, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     IMMsgBodyPack.MsgType0x210SubMsgType0xa
 * JD-Core Version:    0.7.0.1
 */