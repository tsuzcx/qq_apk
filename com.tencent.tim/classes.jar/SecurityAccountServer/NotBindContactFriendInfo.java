package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class NotBindContactFriendInfo
  extends JceStruct
{
  static byte[] cache_MobileNoMask = (byte[])new byte[1];
  public byte[] MobileNoMask;
  public long bindUin;
  public String contactsInfoEncrypt = "";
  public long uAbiFlag;
  
  static
  {
    ((byte[])cache_MobileNoMask)[0] = 0;
  }
  
  public NotBindContactFriendInfo() {}
  
  public NotBindContactFriendInfo(String paramString, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    this.contactsInfoEncrypt = paramString;
    this.MobileNoMask = paramArrayOfByte;
    this.uAbiFlag = paramLong1;
    this.bindUin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.contactsInfoEncrypt = paramJceInputStream.readString(0, true);
    this.MobileNoMask = ((byte[])paramJceInputStream.read(cache_MobileNoMask, 1, true));
    this.uAbiFlag = paramJceInputStream.read(this.uAbiFlag, 2, false);
    this.bindUin = paramJceInputStream.read(this.bindUin, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.contactsInfoEncrypt, 0);
    paramJceOutputStream.write(this.MobileNoMask, 1);
    paramJceOutputStream.write(this.uAbiFlag, 2);
    paramJceOutputStream.write(this.bindUin, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SecurityAccountServer.NotBindContactFriendInfo
 * JD-Core Version:    0.7.0.1
 */