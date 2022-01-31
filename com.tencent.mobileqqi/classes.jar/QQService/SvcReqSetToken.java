package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcReqSetToken
  extends JceStruct
{
  static ArrayList cache_vTokenID;
  public byte bOnlinePush = 0;
  public byte bPushMsg = 1;
  public byte bPushQZone = 1;
  public long lUin = 0L;
  public String sExtends = "";
  public String sSound = "";
  public ArrayList vTokenID = null;
  
  public SvcReqSetToken() {}
  
  public SvcReqSetToken(long paramLong, ArrayList paramArrayList, String paramString1, String paramString2, byte paramByte1, byte paramByte2, byte paramByte3)
  {
    this.lUin = paramLong;
    this.vTokenID = paramArrayList;
    this.sSound = paramString1;
    this.sExtends = paramString2;
    this.bPushMsg = paramByte1;
    this.bPushQZone = paramByte2;
    this.bOnlinePush = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    if (cache_vTokenID == null)
    {
      cache_vTokenID = new ArrayList();
      cache_vTokenID.add(Integer.valueOf(0));
    }
    this.vTokenID = ((ArrayList)paramJceInputStream.read(cache_vTokenID, 1, true));
    this.sSound = paramJceInputStream.readString(2, true);
    this.sExtends = paramJceInputStream.readString(3, true);
    this.bPushMsg = paramJceInputStream.read(this.bPushMsg, 4, false);
    this.bPushQZone = paramJceInputStream.read(this.bPushQZone, 5, false);
    this.bOnlinePush = paramJceInputStream.read(this.bOnlinePush, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.vTokenID, 1);
    paramJceOutputStream.write(this.sSound, 2);
    paramJceOutputStream.write(this.sExtends, 3);
    paramJceOutputStream.write(this.bPushMsg, 4);
    paramJceOutputStream.write(this.bPushQZone, 5);
    paramJceOutputStream.write(this.bOnlinePush, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcReqSetToken
 * JD-Core Version:    0.7.0.1
 */