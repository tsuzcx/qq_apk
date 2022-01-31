package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestDelRoamMsgByDay
  extends JceStruct
{
  public byte cVerifyType = 0;
  public long lPeerUin = 0L;
  public long lTime = 0L;
  public long lUin = 0L;
  
  public SvcRequestDelRoamMsgByDay() {}
  
  public SvcRequestDelRoamMsgByDay(long paramLong1, byte paramByte, long paramLong2, long paramLong3)
  {
    this.lUin = paramLong1;
    this.cVerifyType = paramByte;
    this.lPeerUin = paramLong2;
    this.lTime = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 1, true);
    this.lPeerUin = paramJceInputStream.read(this.lPeerUin, 2, true);
    this.lTime = paramJceInputStream.read(this.lTime, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cVerifyType, 1);
    paramJceOutputStream.write(this.lPeerUin, 2);
    paramJceOutputStream.write(this.lTime, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestDelRoamMsgByDay
 * JD-Core Version:    0.7.0.1
 */