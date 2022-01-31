package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestQueryQQMobileContacts
  extends JceStruct
{
  static byte[] cache_sessionSid;
  public boolean Compressd = false;
  public long nextFlag = 0L;
  public byte[] sessionSid = null;
  public long timeStamp = 0L;
  public byte version = 0;
  
  public RequestQueryQQMobileContacts() {}
  
  public RequestQueryQQMobileContacts(long paramLong1, long paramLong2, byte[] paramArrayOfByte, byte paramByte, boolean paramBoolean)
  {
    this.nextFlag = paramLong1;
    this.timeStamp = paramLong2;
    this.sessionSid = paramArrayOfByte;
    this.version = paramByte;
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
    this.version = paramJceInputStream.read(this.version, 3, false);
    this.Compressd = paramJceInputStream.read(this.Compressd, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    paramJceOutputStream.write(this.sessionSid, 2);
    paramJceOutputStream.write(this.version, 3);
    paramJceOutputStream.write(this.Compressd, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SecurityAccountServer.RequestQueryQQMobileContacts
 * JD-Core Version:    0.7.0.1
 */