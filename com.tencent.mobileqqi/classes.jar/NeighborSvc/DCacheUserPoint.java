package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DCacheUserPoint
  extends JceStruct
{
  public int iLat = 900000000;
  public int iLon = 900000000;
  public int lTime = 0;
  
  public DCacheUserPoint() {}
  
  public DCacheUserPoint(int paramInt1, int paramInt2, int paramInt3)
  {
    this.lTime = paramInt1;
    this.iLat = paramInt2;
    this.iLon = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lTime = paramJceInputStream.read(this.lTime, 0, true);
    this.iLat = paramJceInputStream.read(this.iLat, 1, true);
    this.iLon = paramJceInputStream.read(this.iLon, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lTime, 0);
    paramJceOutputStream.write(this.iLat, 1);
    paramJceOutputStream.write(this.iLon, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.DCacheUserPoint
 * JD-Core Version:    0.7.0.1
 */