package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetCooperateCms
  extends JceStruct
{
  public int cmsType;
  public long preTime;
  
  public ReqGetCooperateCms() {}
  
  public ReqGetCooperateCms(int paramInt, long paramLong)
  {
    this.cmsType = paramInt;
    this.preTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cmsType = paramJceInputStream.read(this.cmsType, 0, true);
    this.preTime = paramJceInputStream.read(this.preTime, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmsType, 0);
    paramJceOutputStream.write(this.preTime, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acs.ReqGetCooperateCms
 * JD-Core Version:    0.7.0.1
 */