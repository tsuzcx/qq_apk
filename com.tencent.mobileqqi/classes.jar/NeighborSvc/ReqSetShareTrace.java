package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqSetShareTrace
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  public byte bIsOpen = 0;
  public ReqHeader stHeader = null;
  
  public ReqSetShareTrace() {}
  
  public ReqSetShareTrace(ReqHeader paramReqHeader, byte paramByte)
  {
    this.stHeader = paramReqHeader;
    this.bIsOpen = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.bIsOpen = paramJceInputStream.read(this.bIsOpen, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.bIsOpen, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.ReqSetShareTrace
 * JD-Core Version:    0.7.0.1
 */