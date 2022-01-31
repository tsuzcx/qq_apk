package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetPositionReq
  extends JceStruct
{
  static stGPS cache_stGps;
  public int iAccuracy = 0;
  public int iLocateCostTime = 0;
  public stGPS stGps = null;
  public String strClientIP = "";
  
  public stGetPositionReq() {}
  
  public stGetPositionReq(stGPS paramstGPS, String paramString, int paramInt1, int paramInt2)
  {
    this.stGps = paramstGPS;
    this.strClientIP = paramString;
    this.iAccuracy = paramInt1;
    this.iLocateCostTime = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGps == null) {
      cache_stGps = new stGPS();
    }
    this.stGps = ((stGPS)paramJceInputStream.read(cache_stGps, 0, true));
    this.strClientIP = paramJceInputStream.readString(1, true);
    this.iAccuracy = paramJceInputStream.read(this.iAccuracy, 2, false);
    this.iLocateCostTime = paramJceInputStream.read(this.iLocateCostTime, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stGps, 0);
    paramJceOutputStream.write(this.strClientIP, 1);
    paramJceOutputStream.write(this.iAccuracy, 2);
    paramJceOutputStream.write(this.iLocateCostTime, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     LBSClientInterfaceV2.stGetPositionReq
 * JD-Core Version:    0.7.0.1
 */