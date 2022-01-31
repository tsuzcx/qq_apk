package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetSelfLastPosition
  extends JceStruct
{
  public long lUIN = 0L;
  
  public ReqGetSelfLastPosition() {}
  
  public ReqGetSelfLastPosition(long paramLong)
  {
    this.lUIN = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.ReqGetSelfLastPosition
 * JD-Core Version:    0.7.0.1
 */