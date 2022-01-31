package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqSetUserState
  extends JceStruct
{
  static int cache_eUserState;
  static ReqHeader cache_stHeader;
  public int eUserState = 0;
  public ReqHeader stHeader = null;
  
  public ReqSetUserState() {}
  
  public ReqSetUserState(ReqHeader paramReqHeader, int paramInt)
  {
    this.stHeader = paramReqHeader;
    this.eUserState = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.eUserState = paramJceInputStream.read(this.eUserState, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.eUserState, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.ReqSetUserState
 * JD-Core Version:    0.7.0.1
 */