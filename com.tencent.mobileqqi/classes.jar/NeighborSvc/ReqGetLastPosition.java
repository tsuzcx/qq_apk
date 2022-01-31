package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqGetLastPosition
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  static ArrayList cache_vecReqUin;
  public ReqHeader stHeader = null;
  public ArrayList vecReqUin = null;
  
  public ReqGetLastPosition() {}
  
  public ReqGetLastPosition(ReqHeader paramReqHeader, ArrayList paramArrayList)
  {
    this.stHeader = paramReqHeader;
    this.vecReqUin = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_vecReqUin == null)
    {
      cache_vecReqUin = new ArrayList();
      cache_vecReqUin.add(Long.valueOf(0L));
    }
    this.vecReqUin = ((ArrayList)paramJceInputStream.read(cache_vecReqUin, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.vecReqUin, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.ReqGetLastPosition
 * JD-Core Version:    0.7.0.1
 */