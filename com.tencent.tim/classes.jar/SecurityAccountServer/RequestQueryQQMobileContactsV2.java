package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestQueryQQMobileContactsV2
  extends JceStruct
{
  static byte[] cache_sessionSid;
  public boolean Compressd;
  public long nextFlag;
  public byte[] sessionSid;
  public long timeStamp;
  
  public RequestQueryQQMobileContactsV2() {}
  
  public RequestQueryQQMobileContactsV2(long paramLong1, long paramLong2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this.nextFlag = paramLong1;
    this.timeStamp = paramLong2;
    this.sessionSid = paramArrayOfByte;
    this.Compressd = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 1, true);
    if (cache_sessionSid == null)
    {
      cache_sessionSid = (byte[])new byte[1];
      ((byte[])cache_sessionSid)[0] = 0;
    }
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 2, true));
    this.Compressd = paramJceInputStream.read(this.Compressd, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    paramJceOutputStream.write(this.sessionSid, 2);
    paramJceOutputStream.write(this.Compressd, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SecurityAccountServer.RequestQueryQQMobileContactsV2
 * JD-Core Version:    0.7.0.1
 */