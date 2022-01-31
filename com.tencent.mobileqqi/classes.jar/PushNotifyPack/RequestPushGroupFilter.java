package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestPushGroupFilter
  extends JceStruct
{
  public long cMsgMask = 0L;
  public byte cType = 0;
  public long lGroupCode = 0L;
  public long lGroupUin = 0L;
  public long lUin = 0L;
  public String strCmd = "";
  public String strService = "";
  
  public RequestPushGroupFilter() {}
  
  public RequestPushGroupFilter(long paramLong1, byte paramByte, String paramString1, String paramString2, long paramLong2, long paramLong3, long paramLong4)
  {
    this.lUin = paramLong1;
    this.cType = paramByte;
    this.strService = paramString1;
    this.strCmd = paramString2;
    this.lGroupCode = paramLong2;
    this.lGroupUin = paramLong3;
    this.cMsgMask = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cType = paramJceInputStream.read(this.cType, 1, true);
    this.strService = paramJceInputStream.readString(2, true);
    this.strCmd = paramJceInputStream.readString(3, true);
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 4, true);
    this.lGroupUin = paramJceInputStream.read(this.lGroupUin, 5, true);
    this.cMsgMask = paramJceInputStream.read(this.cMsgMask, 6, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cType, 1);
    paramJceOutputStream.write(this.strService, 2);
    paramJceOutputStream.write(this.strCmd, 3);
    paramJceOutputStream.write(this.lGroupCode, 4);
    paramJceOutputStream.write(this.lGroupUin, 5);
    paramJceOutputStream.write(this.cMsgMask, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     PushNotifyPack.RequestPushGroupFilter
 * JD-Core Version:    0.7.0.1
 */