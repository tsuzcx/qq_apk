package tmsdk.Protocol.MCommon;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TimeCtrl
  extends JceStruct
{
  public boolean bEngross = true;
  public int exectime = 0;
  public int time = 0;
  public int validEndTime = 0;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.time = paramJceInputStream.read(this.time, 0, true);
    this.bEngross = paramJceInputStream.read(this.bEngross, 1, true);
    this.validEndTime = paramJceInputStream.read(this.validEndTime, 2, false);
    this.exectime = paramJceInputStream.read(this.exectime, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.time, 0);
    paramJceOutputStream.write(this.bEngross, 1);
    if (this.validEndTime != 0) {
      paramJceOutputStream.write(this.validEndTime, 2);
    }
    if (this.exectime != 0) {
      paramJceOutputStream.write(this.exectime, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MCommon.TimeCtrl
 * JD-Core Version:    0.7.0.1
 */