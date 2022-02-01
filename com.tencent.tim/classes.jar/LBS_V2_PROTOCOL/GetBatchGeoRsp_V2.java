package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetBatchGeoRsp_V2
  extends JceStruct
{
  static ArrayList<GeoInfoCell_V2> cache_vecGeoInfoCell;
  public ArrayList<GeoInfoCell_V2> vecGeoInfoCell;
  
  public GetBatchGeoRsp_V2() {}
  
  public GetBatchGeoRsp_V2(ArrayList<GeoInfoCell_V2> paramArrayList)
  {
    this.vecGeoInfoCell = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecGeoInfoCell == null)
    {
      cache_vecGeoInfoCell = new ArrayList();
      GeoInfoCell_V2 localGeoInfoCell_V2 = new GeoInfoCell_V2();
      cache_vecGeoInfoCell.add(localGeoInfoCell_V2);
    }
    this.vecGeoInfoCell = ((ArrayList)paramJceInputStream.read(cache_vecGeoInfoCell, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecGeoInfoCell != null) {
      paramJceOutputStream.write(this.vecGeoInfoCell, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     LBS_V2_PROTOCOL.GetBatchGeoRsp_V2
 * JD-Core Version:    0.7.0.1
 */