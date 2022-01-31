package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespGetSelfLastPosition
  extends JceStruct
{
  public int iLat = 900000000;
  public int iLon = 900000000;
  
  public RespGetSelfLastPosition() {}
  
  public RespGetSelfLastPosition(int paramInt1, int paramInt2)
  {
    this.iLat = paramInt1;
    this.iLon = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iLat = paramJceInputStream.read(this.iLat, 0, true);
    this.iLon = paramJceInputStream.read(this.iLon, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iLat, 0);
    paramJceOutputStream.write(this.iLon, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.RespGetSelfLastPosition
 * JD-Core Version:    0.7.0.1
 */