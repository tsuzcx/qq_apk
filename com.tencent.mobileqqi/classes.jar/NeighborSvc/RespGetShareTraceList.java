package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetShareTraceList
  extends JceStruct
{
  static RespHeader cache_stHeader;
  static ArrayList cache_vecOpenUIN;
  public RespHeader stHeader = null;
  public ArrayList vecOpenUIN = null;
  
  public RespGetShareTraceList() {}
  
  public RespGetShareTraceList(RespHeader paramRespHeader, ArrayList paramArrayList)
  {
    this.stHeader = paramRespHeader;
    this.vecOpenUIN = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_vecOpenUIN == null)
    {
      cache_vecOpenUIN = new ArrayList();
      UserShareTraceInfo localUserShareTraceInfo = new UserShareTraceInfo();
      cache_vecOpenUIN.add(localUserShareTraceInfo);
    }
    this.vecOpenUIN = ((ArrayList)paramJceInputStream.read(cache_vecOpenUIN, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.vecOpenUIN, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.RespGetShareTraceList
 * JD-Core Version:    0.7.0.1
 */