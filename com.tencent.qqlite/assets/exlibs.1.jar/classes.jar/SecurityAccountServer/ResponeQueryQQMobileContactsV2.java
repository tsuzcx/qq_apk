package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ResponeQueryQQMobileContactsV2
  extends JceStruct
{
  static ArrayList cache_alreadyBindContacts;
  static byte[] cache_sessionSid;
  public ArrayList alreadyBindContacts = null;
  public long nextFlag = 0L;
  public byte[] sessionSid = null;
  public long timeStamp = 0L;
  
  public ResponeQueryQQMobileContactsV2() {}
  
  public ResponeQueryQQMobileContactsV2(long paramLong1, long paramLong2, byte[] paramArrayOfByte, ArrayList paramArrayList)
  {
    this.nextFlag = paramLong1;
    this.timeStamp = paramLong2;
    this.sessionSid = paramArrayOfByte;
    this.alreadyBindContacts = paramArrayList;
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
    if (cache_alreadyBindContacts == null)
    {
      cache_alreadyBindContacts = new ArrayList();
      MobileContactsDetailInfoEncrypt localMobileContactsDetailInfoEncrypt = new MobileContactsDetailInfoEncrypt();
      cache_alreadyBindContacts.add(localMobileContactsDetailInfoEncrypt);
    }
    this.alreadyBindContacts = ((ArrayList)paramJceInputStream.read(cache_alreadyBindContacts, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    paramJceOutputStream.write(this.sessionSid, 2);
    paramJceOutputStream.write(this.alreadyBindContacts, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SecurityAccountServer.ResponeQueryQQMobileContactsV2
 * JD-Core Version:    0.7.0.1
 */