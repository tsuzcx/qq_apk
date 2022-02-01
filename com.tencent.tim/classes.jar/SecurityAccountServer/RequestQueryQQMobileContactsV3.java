package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestQueryQQMobileContactsV3
  extends JceStruct
{
  static int cache_bindState = 0;
  static int cache_queryFlag;
  static byte[] cache_sessionSid = (byte[])new byte[1];
  public boolean Compressd;
  public long MaxsignTimeStamp;
  public String MobileUniqueNo = "";
  public boolean OmitOffline;
  public int bindState = 0;
  public long nextFlag;
  public int queryFlag;
  public long queryFrom;
  public byte[] sessionSid;
  public long timeStamp;
  
  static
  {
    ((byte[])cache_sessionSid)[0] = 0;
    cache_queryFlag = 0;
  }
  
  public RequestQueryQQMobileContactsV3() {}
  
  public RequestQueryQQMobileContactsV3(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean1, long paramLong3, String paramString, boolean paramBoolean2, long paramLong4, int paramInt2)
  {
    this.nextFlag = paramLong1;
    this.timeStamp = paramLong2;
    this.sessionSid = paramArrayOfByte;
    this.queryFlag = paramInt1;
    this.Compressd = paramBoolean1;
    this.MaxsignTimeStamp = paramLong3;
    this.MobileUniqueNo = paramString;
    this.OmitOffline = paramBoolean2;
    this.queryFrom = paramLong4;
    this.bindState = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 1, true);
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 2, true));
    this.queryFlag = paramJceInputStream.read(this.queryFlag, 3, true);
    this.Compressd = paramJceInputStream.read(this.Compressd, 4, false);
    this.MaxsignTimeStamp = paramJceInputStream.read(this.MaxsignTimeStamp, 5, false);
    this.MobileUniqueNo = paramJceInputStream.readString(6, false);
    this.OmitOffline = paramJceInputStream.read(this.OmitOffline, 7, false);
    this.queryFrom = paramJceInputStream.read(this.queryFrom, 8, false);
    this.bindState = paramJceInputStream.read(this.bindState, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    paramJceOutputStream.write(this.sessionSid, 2);
    paramJceOutputStream.write(this.queryFlag, 3);
    paramJceOutputStream.write(this.Compressd, 4);
    paramJceOutputStream.write(this.MaxsignTimeStamp, 5);
    if (this.MobileUniqueNo != null) {
      paramJceOutputStream.write(this.MobileUniqueNo, 6);
    }
    paramJceOutputStream.write(this.OmitOffline, 7);
    paramJceOutputStream.write(this.queryFrom, 8);
    paramJceOutputStream.write(this.bindState, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SecurityAccountServer.RequestQueryQQMobileContactsV3
 * JD-Core Version:    0.7.0.1
 */