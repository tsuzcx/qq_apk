package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqVote
  extends JceStruct
{
  static ReqHead cache_stHeader;
  public long lMID = 0L;
  public ReqHead stHeader = null;
  
  public ReqVote() {}
  
  public ReqVote(ReqHead paramReqHead, long paramLong)
  {
    this.stHeader = paramReqHead;
    this.lMID = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.lMID = paramJceInputStream.read(this.lMID, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.lMID, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqVote
 * JD-Core Version:    0.7.0.1
 */