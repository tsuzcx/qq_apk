package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetLastPosition
  extends JceStruct
{
  static RespHeader cache_stHeader;
  static ArrayList cache_vecLastPosition;
  public RespHeader stHeader = null;
  public ArrayList vecLastPosition = null;
  
  public RespGetLastPosition() {}
  
  public RespGetLastPosition(RespHeader paramRespHeader, ArrayList paramArrayList)
  {
    this.stHeader = paramRespHeader;
    this.vecLastPosition = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_vecLastPosition == null)
    {
      cache_vecLastPosition = new ArrayList();
      UserLastPosition localUserLastPosition = new UserLastPosition();
      cache_vecLastPosition.add(localUserLastPosition);
    }
    this.vecLastPosition = ((ArrayList)paramJceInputStream.read(cache_vecLastPosition, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.vecLastPosition, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.RespGetLastPosition
 * JD-Core Version:    0.7.0.1
 */