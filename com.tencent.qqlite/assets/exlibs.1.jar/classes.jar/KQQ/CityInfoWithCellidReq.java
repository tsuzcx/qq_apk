package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CityInfoWithCellidReq
  extends JceStruct
{
  static GSMCell cache_cell;
  static ClientInfo cache_clientInfo;
  static GPSPoint cache_coords;
  static int cache_type;
  static ArrayList cache_vMacs;
  public GSMCell cell = null;
  public ClientInfo clientInfo = null;
  public GPSPoint coords = null;
  public int type = QUERYTYPE.GPS_CELL_V1.value();
  public ArrayList vMacs = null;
  
  public CityInfoWithCellidReq() {}
  
  public CityInfoWithCellidReq(GSMCell paramGSMCell, GPSPoint paramGPSPoint, int paramInt, ClientInfo paramClientInfo, ArrayList paramArrayList)
  {
    this.cell = paramGSMCell;
    this.coords = paramGPSPoint;
    this.type = paramInt;
    this.clientInfo = paramClientInfo;
    this.vMacs = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_cell == null) {
      cache_cell = new GSMCell();
    }
    this.cell = ((GSMCell)paramJceInputStream.read(cache_cell, 1, true));
    if (cache_coords == null) {
      cache_coords = new GPSPoint();
    }
    this.coords = ((GPSPoint)paramJceInputStream.read(cache_coords, 2, true));
    this.type = paramJceInputStream.read(this.type, 3, false);
    if (cache_clientInfo == null) {
      cache_clientInfo = new ClientInfo();
    }
    this.clientInfo = ((ClientInfo)paramJceInputStream.read(cache_clientInfo, 4, false));
    if (cache_vMacs == null)
    {
      cache_vMacs = new ArrayList();
      cache_vMacs.add(Long.valueOf(0L));
    }
    this.vMacs = ((ArrayList)paramJceInputStream.read(cache_vMacs, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cell, 1);
    paramJceOutputStream.write(this.coords, 2);
    paramJceOutputStream.write(this.type, 3);
    if (this.clientInfo != null) {
      paramJceOutputStream.write(this.clientInfo, 4);
    }
    if (this.vMacs != null) {
      paramJceOutputStream.write(this.vMacs, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.CityInfoWithCellidReq
 * JD-Core Version:    0.7.0.1
 */