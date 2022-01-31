package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetAreaList
  extends JceStruct
{
  public int iLat = 0;
  public int iLon = 0;
  public int iRadius = 0;
  
  public ReqGetAreaList() {}
  
  public ReqGetAreaList(int paramInt1, int paramInt2, int paramInt3)
  {
    this.iLat = paramInt1;
    this.iLon = paramInt2;
    this.iRadius = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iLat = paramJceInputStream.read(this.iLat, 0, true);
    this.iLon = paramJceInputStream.read(this.iLon, 1, true);
    this.iRadius = paramJceInputStream.read(this.iRadius, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iLat, 0);
    paramJceOutputStream.write(this.iLon, 1);
    paramJceOutputStream.write(this.iRadius, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NearbyGroup.ReqGetAreaList
 * JD-Core Version:    0.7.0.1
 */