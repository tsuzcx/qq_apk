package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_feed_alert_rsp
  extends JceStruct
{
  static count_info cache_stActiveInfo;
  public count_info stActiveInfo = null;
  
  public mobile_feed_alert_rsp() {}
  
  public mobile_feed_alert_rsp(count_info paramcount_info)
  {
    this.stActiveInfo = paramcount_info;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stActiveInfo == null) {
      cache_stActiveInfo = new count_info();
    }
    this.stActiveInfo = ((count_info)paramJceInputStream.read(cache_stActiveInfo, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stActiveInfo != null) {
      paramJceOutputStream.write(this.stActiveInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_UNDEAL_COUNT.mobile_feed_alert_rsp
 * JD-Core Version:    0.7.0.1
 */