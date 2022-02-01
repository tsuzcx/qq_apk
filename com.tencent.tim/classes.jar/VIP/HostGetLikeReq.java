package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class HostGetLikeReq
  extends JceStruct
{
  public long iUin;
  
  public HostGetLikeReq() {}
  
  public HostGetLikeReq(long paramLong)
  {
    this.iUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VIP.HostGetLikeReq
 * JD-Core Version:    0.7.0.1
 */