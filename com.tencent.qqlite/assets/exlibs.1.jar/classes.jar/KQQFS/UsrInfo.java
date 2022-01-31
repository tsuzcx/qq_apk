package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UsrInfo
  extends JceStruct
{
  static byte[] cache_otherID;
  static byte[] cache_vKey;
  public byte cNetType = 0;
  public byte cPicType = 0;
  public byte encryAbi = 0;
  public long lAppID = 0L;
  public long lFromMID = 0L;
  public long lToMID = 0L;
  public byte[] otherID = null;
  public int sessionID = 0;
  public short shBuisType = 0;
  public short shKeyType = 0;
  public short shType = 0;
  public int uSeq = 0;
  public byte[] vKey = null;
  
  public UsrInfo() {}
  
  public UsrInfo(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, short paramShort1, short paramShort2, short paramShort3, byte[] paramArrayOfByte1, byte paramByte1, byte[] paramArrayOfByte2, byte paramByte2, byte paramByte3)
  {
    this.lFromMID = paramLong1;
    this.lToMID = paramLong2;
    this.sessionID = paramInt1;
    this.uSeq = paramInt2;
    this.lAppID = paramLong3;
    this.shBuisType = paramShort1;
    this.shType = paramShort2;
    this.shKeyType = paramShort3;
    this.vKey = paramArrayOfByte1;
    this.encryAbi = paramByte1;
    this.otherID = paramArrayOfByte2;
    this.cNetType = paramByte2;
    this.cPicType = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromMID = paramJceInputStream.read(this.lFromMID, 0, true);
    this.lToMID = paramJceInputStream.read(this.lToMID, 1, true);
    this.sessionID = paramJceInputStream.read(this.sessionID, 2, true);
    this.uSeq = paramJceInputStream.read(this.uSeq, 3, true);
    this.lAppID = paramJceInputStream.read(this.lAppID, 4, true);
    this.shBuisType = paramJceInputStream.read(this.shBuisType, 5, true);
    this.shType = paramJceInputStream.read(this.shType, 6, true);
    this.shKeyType = paramJceInputStream.read(this.shKeyType, 7, true);
    if (cache_vKey == null)
    {
      cache_vKey = (byte[])new byte[1];
      ((byte[])cache_vKey)[0] = 0;
    }
    this.vKey = ((byte[])paramJceInputStream.read(cache_vKey, 8, true));
    this.encryAbi = paramJceInputStream.read(this.encryAbi, 9, true);
    if (cache_otherID == null)
    {
      cache_otherID = (byte[])new byte[1];
      ((byte[])cache_otherID)[0] = 0;
    }
    this.otherID = ((byte[])paramJceInputStream.read(cache_otherID, 10, false));
    this.cNetType = paramJceInputStream.read(this.cNetType, 11, false);
    this.cPicType = paramJceInputStream.read(this.cPicType, 12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromMID, 0);
    paramJceOutputStream.write(this.lToMID, 1);
    paramJceOutputStream.write(this.sessionID, 2);
    paramJceOutputStream.write(this.uSeq, 3);
    paramJceOutputStream.write(this.lAppID, 4);
    paramJceOutputStream.write(this.shBuisType, 5);
    paramJceOutputStream.write(this.shType, 6);
    paramJceOutputStream.write(this.shKeyType, 7);
    paramJceOutputStream.write(this.vKey, 8);
    paramJceOutputStream.write(this.encryAbi, 9);
    if (this.otherID != null) {
      paramJceOutputStream.write(this.otherID, 10);
    }
    paramJceOutputStream.write(this.cNetType, 11);
    paramJceOutputStream.write(this.cPicType, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQFS.UsrInfo
 * JD-Core Version:    0.7.0.1
 */