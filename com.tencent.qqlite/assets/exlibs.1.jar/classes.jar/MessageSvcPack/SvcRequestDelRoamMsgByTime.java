package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestDelRoamMsgByTime
  extends JceStruct
{
  public byte cVerifyType = 0;
  public long lBeginTime = 0L;
  public long lEndTime = 0L;
  public long lUin = 0L;
  
  public SvcRequestDelRoamMsgByTime() {}
  
  public SvcRequestDelRoamMsgByTime(long paramLong1, byte paramByte, long paramLong2, long paramLong3)
  {
    this.lUin = paramLong1;
    this.cVerifyType = paramByte;
    this.lBeginTime = paramLong2;
    this.lEndTime = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 1, true);
    this.lBeginTime = paramJceInputStream.read(this.lBeginTime, 2, true);
    this.lEndTime = paramJceInputStream.read(this.lEndTime, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cVerifyType, 1);
    paramJceOutputStream.write(this.lBeginTime, 2);
    paramJceOutputStream.write(this.lEndTime, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     MessageSvcPack.SvcRequestDelRoamMsgByTime
 * JD-Core Version:    0.7.0.1
 */