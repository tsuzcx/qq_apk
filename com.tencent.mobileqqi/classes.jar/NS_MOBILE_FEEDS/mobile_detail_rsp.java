package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_detail_rsp
  extends JceStruct
{
  static single_detail cache_detail_data;
  public int adbanner_info = 0;
  public String attach_info = "";
  public single_detail detail_data = null;
  public int hasmore = 0;
  
  public mobile_detail_rsp() {}
  
  public mobile_detail_rsp(single_detail paramsingle_detail, int paramInt1, String paramString, int paramInt2)
  {
    this.detail_data = paramsingle_detail;
    this.hasmore = paramInt1;
    this.attach_info = paramString;
    this.adbanner_info = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_detail_data == null) {
      cache_detail_data = new single_detail();
    }
    this.detail_data = ((single_detail)paramJceInputStream.read(cache_detail_data, 0, false));
    this.hasmore = paramJceInputStream.read(this.hasmore, 1, false);
    this.attach_info = paramJceInputStream.readString(2, false);
    this.adbanner_info = paramJceInputStream.read(this.adbanner_info, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.detail_data != null) {
      paramJceOutputStream.write(this.detail_data, 0);
    }
    paramJceOutputStream.write(this.hasmore, 1);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
    paramJceOutputStream.write(this.adbanner_info, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_detail_rsp
 * JD-Core Version:    0.7.0.1
 */