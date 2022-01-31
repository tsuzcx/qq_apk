package PasserbySvc;

import NeighborComm.RespHeader;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespCheckIn
  extends JceStruct
{
  static RespHeader cache_stHeader;
  public RespHeader stHeader = null;
  
  public RespCheckIn() {}
  
  public RespCheckIn(RespHeader paramRespHeader)
  {
    this.stHeader = paramRespHeader;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     PasserbySvc.RespCheckIn
 * JD-Core Version:    0.7.0.1
 */