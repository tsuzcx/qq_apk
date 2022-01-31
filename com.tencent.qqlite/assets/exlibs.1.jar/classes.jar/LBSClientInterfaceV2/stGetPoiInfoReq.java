package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetPoiInfoReq
  extends JceStruct
{
  static stGPS cache_stGps;
  public int iAccuracy = 0;
  public int iDistance = 100;
  public int iLocateCostTime = 0;
  public int iNum = 30;
  public int iPage = 1;
  public stGPS stGps = null;
  public String strClientIP = "";
  public String strKeyWord = "";
  
  public stGetPoiInfoReq() {}
  
  public stGetPoiInfoReq(stGPS paramstGPS, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.stGps = paramstGPS;
    this.strClientIP = paramString1;
    this.strKeyWord = paramString2;
    this.iDistance = paramInt1;
    this.iPage = paramInt2;
    this.iNum = paramInt3;
    this.iAccuracy = paramInt4;
    this.iLocateCostTime = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGps == null) {
      cache_stGps = new stGPS();
    }
    this.stGps = ((stGPS)paramJceInputStream.read(cache_stGps, 0, true));
    this.strClientIP = paramJceInputStream.readString(1, true);
    this.strKeyWord = paramJceInputStream.readString(2, true);
    this.iDistance = paramJceInputStream.read(this.iDistance, 3, true);
    this.iPage = paramJceInputStream.read(this.iPage, 4, true);
    this.iNum = paramJceInputStream.read(this.iNum, 5, true);
    this.iAccuracy = paramJceInputStream.read(this.iAccuracy, 6, false);
    this.iLocateCostTime = paramJceInputStream.read(this.iLocateCostTime, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stGps, 0);
    paramJceOutputStream.write(this.strClientIP, 1);
    paramJceOutputStream.write(this.strKeyWord, 2);
    paramJceOutputStream.write(this.iDistance, 3);
    paramJceOutputStream.write(this.iPage, 4);
    paramJceOutputStream.write(this.iNum, 5);
    paramJceOutputStream.write(this.iAccuracy, 6);
    paramJceOutputStream.write(this.iLocateCostTime, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     LBSClientInterfaceV2.stGetPoiInfoReq
 * JD-Core Version:    0.7.0.1
 */