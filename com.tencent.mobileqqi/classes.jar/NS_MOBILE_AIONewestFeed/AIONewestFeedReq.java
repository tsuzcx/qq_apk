package NS_MOBILE_AIONewestFeed;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AIONewestFeedReq
  extends JceStruct
{
  static ArrayList cache_uHostUin;
  public ArrayList uHostUin = null;
  public long uLastTime = 0L;
  public long uOpUin = 0L;
  
  public AIONewestFeedReq() {}
  
  public AIONewestFeedReq(long paramLong1, ArrayList paramArrayList, long paramLong2)
  {
    this.uOpUin = paramLong1;
    this.uHostUin = paramArrayList;
    this.uLastTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uOpUin = paramJceInputStream.read(this.uOpUin, 0, false);
    if (cache_uHostUin == null)
    {
      cache_uHostUin = new ArrayList();
      cache_uHostUin.add(Long.valueOf(0L));
    }
    this.uHostUin = ((ArrayList)paramJceInputStream.read(cache_uHostUin, 1, false));
    this.uLastTime = paramJceInputStream.read(this.uLastTime, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uOpUin, 0);
    if (this.uHostUin != null) {
      paramJceOutputStream.write(this.uHostUin, 1);
    }
    paramJceOutputStream.write(this.uLastTime, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_AIONewestFeed.AIONewestFeedReq
 * JD-Core Version:    0.7.0.1
 */