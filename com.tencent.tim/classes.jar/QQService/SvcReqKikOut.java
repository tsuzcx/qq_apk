package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcReqKikOut
  extends JceStruct
{
  static byte[] cache_sKey;
  public long appid;
  public byte cKeyType;
  public long lUin;
  public byte[] sKey;
  
  public SvcReqKikOut() {}
  
  public SvcReqKikOut(long paramLong1, long paramLong2, byte paramByte, byte[] paramArrayOfByte)
  {
    this.lUin = paramLong1;
    this.appid = paramLong2;
    this.cKeyType = paramByte;
    this.sKey = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.appid = paramJceInputStream.read(this.appid, 1, true);
    this.cKeyType = paramJceInputStream.read(this.cKeyType, 2, true);
    if (cache_sKey == null)
    {
      cache_sKey = (byte[])new byte[1];
      ((byte[])cache_sKey)[0] = 0;
    }
    this.sKey = ((byte[])paramJceInputStream.read(cache_sKey, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.cKeyType, 2);
    paramJceOutputStream.write(this.sKey, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.SvcReqKikOut
 * JD-Core Version:    0.7.0.1
 */