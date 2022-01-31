package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespCheckIn
  extends JceStruct
{
  static GPS cache_stGps;
  static RespHeader cache_stHeader;
  public GPS stGps = null;
  public RespHeader stHeader = null;
  
  public RespCheckIn() {}
  
  public RespCheckIn(RespHeader paramRespHeader, GPS paramGPS)
  {
    this.stHeader = paramRespHeader;
    this.stGps = paramGPS;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stGps == null) {
      cache_stGps = new GPS();
    }
    this.stGps = ((GPS)paramJceInputStream.read(cache_stGps, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    if (this.stGps != null) {
      paramJceOutputStream.write(this.stGps, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.RespCheckIn
 * JD-Core Version:    0.7.0.1
 */