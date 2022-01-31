package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqGetShareTraceList
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  static ArrayList cache_vecReqUIN;
  public ReqHeader stHeader = null;
  public ArrayList vecReqUIN = null;
  
  public ReqGetShareTraceList() {}
  
  public ReqGetShareTraceList(ReqHeader paramReqHeader, ArrayList paramArrayList)
  {
    this.stHeader = paramReqHeader;
    this.vecReqUIN = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_vecReqUIN == null)
    {
      cache_vecReqUIN = new ArrayList();
      cache_vecReqUIN.add(Long.valueOf(0L));
    }
    this.vecReqUIN = ((ArrayList)paramJceInputStream.read(cache_vecReqUIN, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.vecReqUIN, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.ReqGetShareTraceList
 * JD-Core Version:    0.7.0.1
 */