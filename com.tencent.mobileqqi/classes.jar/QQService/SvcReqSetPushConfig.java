package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcReqSetPushConfig
  extends JceStruct
{
  static ArrayList cache_vAddGroupPush;
  static ArrayList cache_vUin;
  public byte cAllWhiteList = 0;
  public byte cKeepOnlineTimeBegin = 0;
  public byte cKeepOnlineTimeEnd = 0;
  public byte cPushTimeBegin = 0;
  public byte cPushTimeEnd = 0;
  public byte cType = 0;
  public long lUin = 0L;
  public String strAutoRespContent = "";
  public ArrayList vAddGroupPush = null;
  public ArrayList vUin = null;
  
  public SvcReqSetPushConfig() {}
  
  public SvcReqSetPushConfig(long paramLong, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, ArrayList paramArrayList1, byte paramByte6, String paramString, ArrayList paramArrayList2)
  {
    this.lUin = paramLong;
    this.cType = paramByte1;
    this.cKeepOnlineTimeBegin = paramByte2;
    this.cKeepOnlineTimeEnd = paramByte3;
    this.cPushTimeBegin = paramByte4;
    this.cPushTimeEnd = paramByte5;
    this.vUin = paramArrayList1;
    this.cAllWhiteList = paramByte6;
    this.strAutoRespContent = paramString;
    this.vAddGroupPush = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cType = paramJceInputStream.read(this.cType, 1, true);
    this.cKeepOnlineTimeBegin = paramJceInputStream.read(this.cKeepOnlineTimeBegin, 2, false);
    this.cKeepOnlineTimeEnd = paramJceInputStream.read(this.cKeepOnlineTimeEnd, 3, false);
    this.cPushTimeBegin = paramJceInputStream.read(this.cPushTimeBegin, 4, false);
    this.cPushTimeEnd = paramJceInputStream.read(this.cPushTimeEnd, 5, false);
    if (cache_vUin == null)
    {
      cache_vUin = new ArrayList();
      cache_vUin.add(Long.valueOf(0L));
    }
    this.vUin = ((ArrayList)paramJceInputStream.read(cache_vUin, 6, false));
    this.cAllWhiteList = paramJceInputStream.read(this.cAllWhiteList, 7, false);
    this.strAutoRespContent = paramJceInputStream.readString(8, false);
    if (cache_vAddGroupPush == null)
    {
      cache_vAddGroupPush = new ArrayList();
      stGroupInfo localstGroupInfo = new stGroupInfo();
      cache_vAddGroupPush.add(localstGroupInfo);
    }
    this.vAddGroupPush = ((ArrayList)paramJceInputStream.read(cache_vAddGroupPush, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cType, 1);
    paramJceOutputStream.write(this.cKeepOnlineTimeBegin, 2);
    paramJceOutputStream.write(this.cKeepOnlineTimeEnd, 3);
    paramJceOutputStream.write(this.cPushTimeBegin, 4);
    paramJceOutputStream.write(this.cPushTimeEnd, 5);
    if (this.vUin != null) {
      paramJceOutputStream.write(this.vUin, 6);
    }
    paramJceOutputStream.write(this.cAllWhiteList, 7);
    if (this.strAutoRespContent != null) {
      paramJceOutputStream.write(this.strAutoRespContent, 8);
    }
    if (this.vAddGroupPush != null) {
      paramJceOutputStream.write(this.vAddGroupPush, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcReqSetPushConfig
 * JD-Core Version:    0.7.0.1
 */