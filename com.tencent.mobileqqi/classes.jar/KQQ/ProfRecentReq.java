package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ProfRecentReq
  extends JceStruct
{
  public long uTimeStamp = 0L;
  
  public ProfRecentReq() {}
  
  public ProfRecentReq(long paramLong)
  {
    this.uTimeStamp = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uTimeStamp = paramJceInputStream.read(this.uTimeStamp, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uTimeStamp, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     KQQ.ProfRecentReq
 * JD-Core Version:    0.7.0.1
 */