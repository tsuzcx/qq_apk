package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TimeRange
  extends JceStruct
{
  public long iTimeBegin;
  public long iTimeEnd;
  
  public TimeRange() {}
  
  public TimeRange(long paramLong1, long paramLong2)
  {
    this.iTimeBegin = paramLong1;
    this.iTimeEnd = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTimeBegin = paramJceInputStream.read(this.iTimeBegin, 0, true);
    this.iTimeEnd = paramJceInputStream.read(this.iTimeEnd, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTimeBegin, 0);
    paramJceOutputStream.write(this.iTimeEnd, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_AD_BANNER.TimeRange
 * JD-Core Version:    0.7.0.1
 */