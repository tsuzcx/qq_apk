package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqSetCardSwitch
  extends JceStruct
{
  static ReqHead cache_stHeader;
  public ReqHead stHeader;
  public long uCloseNeighborVote = 2L;
  public long uCloseTimeGateVote = 2L;
  
  public ReqSetCardSwitch() {}
  
  public ReqSetCardSwitch(ReqHead paramReqHead, long paramLong1, long paramLong2)
  {
    this.stHeader = paramReqHead;
    this.uCloseNeighborVote = paramLong1;
    this.uCloseTimeGateVote = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.uCloseNeighborVote = paramJceInputStream.read(this.uCloseNeighborVote, 1, true);
    this.uCloseTimeGateVote = paramJceInputStream.read(this.uCloseTimeGateVote, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.uCloseNeighborVote, 1);
    paramJceOutputStream.write(this.uCloseTimeGateVote, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.ReqSetCardSwitch
 * JD-Core Version:    0.7.0.1
 */