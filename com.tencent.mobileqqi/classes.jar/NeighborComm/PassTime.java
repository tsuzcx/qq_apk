package NeighborComm;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PassTime
  extends JceStruct
{
  static ArrayList cache_vLocation;
  public int iDistance = 0;
  public int iTime = 0;
  public long lGridId = 0L;
  public String strDescription = "";
  public ArrayList vLocation = null;
  
  public PassTime() {}
  
  public PassTime(long paramLong, int paramInt1, int paramInt2, String paramString, ArrayList paramArrayList)
  {
    this.lGridId = paramLong;
    this.iTime = paramInt1;
    this.iDistance = paramInt2;
    this.strDescription = paramString;
    this.vLocation = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lGridId = paramJceInputStream.read(this.lGridId, 0, true);
    this.iTime = paramJceInputStream.read(this.iTime, 1, true);
    this.iDistance = paramJceInputStream.read(this.iDistance, 2, false);
    this.strDescription = paramJceInputStream.readString(3, false);
    if (cache_vLocation == null)
    {
      cache_vLocation = new ArrayList();
      PoiInfo localPoiInfo = new PoiInfo();
      cache_vLocation.add(localPoiInfo);
    }
    this.vLocation = ((ArrayList)paramJceInputStream.read(cache_vLocation, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lGridId, 0);
    paramJceOutputStream.write(this.iTime, 1);
    paramJceOutputStream.write(this.iDistance, 2);
    if (this.strDescription != null) {
      paramJceOutputStream.write(this.strDescription, 3);
    }
    if (this.vLocation != null) {
      paramJceOutputStream.write(this.vLocation, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborComm.PassTime
 * JD-Core Version:    0.7.0.1
 */