package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RspSearchNearPoiListApi
  extends JceStruct
{
  static GPS cache_stUsrLoc;
  static ArrayList cache_vPoiList;
  public int iTotalNum = 0;
  public GPS stUsrLoc = null;
  public ArrayList vPoiList = null;
  
  public RspSearchNearPoiListApi() {}
  
  public RspSearchNearPoiListApi(GPS paramGPS, int paramInt, ArrayList paramArrayList)
  {
    this.stUsrLoc = paramGPS;
    this.iTotalNum = paramInt;
    this.vPoiList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stUsrLoc == null) {
      cache_stUsrLoc = new GPS();
    }
    this.stUsrLoc = ((GPS)paramJceInputStream.read(cache_stUsrLoc, 0, true));
    this.iTotalNum = paramJceInputStream.read(this.iTotalNum, 1, true);
    if (cache_vPoiList == null)
    {
      cache_vPoiList = new ArrayList();
      PoiInfo localPoiInfo = new PoiInfo();
      cache_vPoiList.add(localPoiInfo);
    }
    this.vPoiList = ((ArrayList)paramJceInputStream.read(cache_vPoiList, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stUsrLoc, 0);
    paramJceOutputStream.write(this.iTotalNum, 1);
    paramJceOutputStream.write(this.vPoiList, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     LBSAddrProtocol.RspSearchNearPoiListApi
 * JD-Core Version:    0.7.0.1
 */