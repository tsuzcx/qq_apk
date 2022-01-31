package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SSummaryCardRsp
  extends JceStruct
{
  static int cache_res;
  public long cardid = 0L;
  public int res = 0;
  
  public SSummaryCardRsp() {}
  
  public SSummaryCardRsp(int paramInt, long paramLong)
  {
    this.res = paramInt;
    this.cardid = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.res = paramJceInputStream.read(this.res, 0, true);
    this.cardid = paramJceInputStream.read(this.cardid, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.res, 0);
    paramJceOutputStream.write(this.cardid, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SummaryCardTaf.SSummaryCardRsp
 * JD-Core Version:    0.7.0.1
 */