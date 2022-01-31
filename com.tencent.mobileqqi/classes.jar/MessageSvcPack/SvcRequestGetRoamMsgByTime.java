package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestGetRoamMsgByTime
  extends JceStruct
{
  public byte cMsgStoreType = 0;
  public byte cReserve = 0;
  public byte cVerifyType = 0;
  public long lBeginTime = 0L;
  public long lEndTime = 0L;
  public long lPeerUin = 0L;
  public long lUin = 0L;
  public short shMaxCnt = 0;
  
  public SvcRequestGetRoamMsgByTime() {}
  
  public SvcRequestGetRoamMsgByTime(long paramLong1, byte paramByte1, long paramLong2, long paramLong3, long paramLong4, short paramShort, byte paramByte2, byte paramByte3)
  {
    this.lUin = paramLong1;
    this.cVerifyType = paramByte1;
    this.lPeerUin = paramLong2;
    this.lBeginTime = paramLong3;
    this.lEndTime = paramLong4;
    this.shMaxCnt = paramShort;
    this.cMsgStoreType = paramByte2;
    this.cReserve = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 1, true);
    this.lPeerUin = paramJceInputStream.read(this.lPeerUin, 2, true);
    this.lBeginTime = paramJceInputStream.read(this.lBeginTime, 3, true);
    this.lEndTime = paramJceInputStream.read(this.lEndTime, 4, true);
    this.shMaxCnt = paramJceInputStream.read(this.shMaxCnt, 5, true);
    this.cMsgStoreType = paramJceInputStream.read(this.cMsgStoreType, 6, false);
    this.cReserve = paramJceInputStream.read(this.cReserve, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cVerifyType, 1);
    paramJceOutputStream.write(this.lPeerUin, 2);
    paramJceOutputStream.write(this.lBeginTime, 3);
    paramJceOutputStream.write(this.lEndTime, 4);
    paramJceOutputStream.write(this.shMaxCnt, 5);
    paramJceOutputStream.write(this.cMsgStoreType, 6);
    paramJceOutputStream.write(this.cReserve, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestGetRoamMsgByTime
 * JD-Core Version:    0.7.0.1
 */