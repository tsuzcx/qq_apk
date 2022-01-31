package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetPositionRsp
  extends JceStruct
{
  static stGeoInfo cache_stGeoInfo;
  static stGPS cache_stUsrLoc;
  public stGeoInfo stGeoInfo = null;
  public stGPS stUsrLoc = null;
  
  public stGetPositionRsp() {}
  
  public stGetPositionRsp(stGPS paramstGPS, stGeoInfo paramstGeoInfo)
  {
    this.stUsrLoc = paramstGPS;
    this.stGeoInfo = paramstGeoInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stUsrLoc == null) {
      cache_stUsrLoc = new stGPS();
    }
    this.stUsrLoc = ((stGPS)paramJceInputStream.read(cache_stUsrLoc, 0, true));
    if (cache_stGeoInfo == null) {
      cache_stGeoInfo = new stGeoInfo();
    }
    this.stGeoInfo = ((stGeoInfo)paramJceInputStream.read(cache_stGeoInfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stUsrLoc, 0);
    paramJceOutputStream.write(this.stGeoInfo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     LBSClientInterfaceV2.stGetPositionRsp
 * JD-Core Version:    0.7.0.1
 */