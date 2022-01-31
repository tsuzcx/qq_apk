package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AddFriendResp
  extends JceStruct
{
  static int cache_adduinsetting;
  static byte[] cache_name;
  static int cache_result;
  static byte[] cache_sig;
  public String ErrorString = "";
  public long adduin = 0L;
  public int adduinsetting = 0;
  public short errorCode = 0;
  public byte myAllowFlag = 0;
  public byte myfriendgroupid = 0;
  public byte[] name = null;
  public int result = 0;
  public byte[] sig = null;
  public long uin = 0L;
  
  public AddFriendResp() {}
  
  public AddFriendResp(long paramLong1, long paramLong2, int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, short paramShort, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.uin = paramLong1;
    this.adduin = paramLong2;
    this.adduinsetting = paramInt1;
    this.myAllowFlag = paramByte1;
    this.myfriendgroupid = paramByte2;
    this.result = paramInt2;
    this.errorCode = paramShort;
    this.ErrorString = paramString;
    this.sig = paramArrayOfByte1;
    this.name = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.adduin = paramJceInputStream.read(this.adduin, 1, true);
    this.adduinsetting = paramJceInputStream.read(this.adduinsetting, 2, true);
    this.myAllowFlag = paramJceInputStream.read(this.myAllowFlag, 3, true);
    this.myfriendgroupid = paramJceInputStream.read(this.myfriendgroupid, 4, true);
    this.result = paramJceInputStream.read(this.result, 6, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 7, false);
    this.ErrorString = paramJceInputStream.readString(8, false);
    if (cache_sig == null)
    {
      cache_sig = (byte[])new byte[1];
      ((byte[])cache_sig)[0] = 0;
    }
    this.sig = ((byte[])paramJceInputStream.read(cache_sig, 9, false));
    if (cache_name == null)
    {
      cache_name = (byte[])new byte[1];
      ((byte[])cache_name)[0] = 0;
    }
    this.name = ((byte[])paramJceInputStream.read(cache_name, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.adduin, 1);
    paramJceOutputStream.write(this.adduinsetting, 2);
    paramJceOutputStream.write(this.myAllowFlag, 3);
    paramJceOutputStream.write(this.myfriendgroupid, 4);
    paramJceOutputStream.write(this.result, 6);
    paramJceOutputStream.write(this.errorCode, 7);
    if (this.ErrorString != null) {
      paramJceOutputStream.write(this.ErrorString, 8);
    }
    if (this.sig != null) {
      paramJceOutputStream.write(this.sig, 9);
    }
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.AddFriendResp
 * JD-Core Version:    0.7.0.1
 */