package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_feed_alert_req
  extends JceStruct
{
  public long uMask = 0L;
  
  public mobile_feed_alert_req() {}
  
  public mobile_feed_alert_req(long paramLong)
  {
    this.uMask = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uMask = paramJceInputStream.read(this.uMask, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uMask, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_UNDEAL_COUNT.mobile_feed_alert_req
 * JD-Core Version:    0.7.0.1
 */