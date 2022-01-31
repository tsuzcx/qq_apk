package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespGetSelfShareTrace
  extends JceStruct
{
  static RespHeader cache_stHeader;
  public byte bIsOpen = 0;
  public RespHeader stHeader = null;
  
  public RespGetSelfShareTrace() {}
  
  public RespGetSelfShareTrace(RespHeader paramRespHeader, byte paramByte)
  {
    this.stHeader = paramRespHeader;
    this.bIsOpen = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.bIsOpen = paramJceInputStream.read(this.bIsOpen, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.bIsOpen, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.RespGetSelfShareTrace
 * JD-Core Version:    0.7.0.1
 */