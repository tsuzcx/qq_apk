package NS_MOBILE_QUN;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class qun_feeds_rsp
  extends JceStruct
{
  static ArrayList cache_all_feeds_data;
  public ArrayList all_feeds_data = null;
  public String attach_info = "";
  public int auto_load = 0;
  public int hasmore = 0;
  
  public qun_feeds_rsp() {}
  
  public qun_feeds_rsp(int paramInt1, String paramString, ArrayList paramArrayList, int paramInt2)
  {
    this.hasmore = paramInt1;
    this.attach_info = paramString;
    this.all_feeds_data = paramArrayList;
    this.auto_load = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasmore = paramJceInputStream.read(this.hasmore, 0, false);
    this.attach_info = paramJceInputStream.readString(1, false);
    if (cache_all_feeds_data == null)
    {
      cache_all_feeds_data = new ArrayList();
      single_feed localsingle_feed = new single_feed();
      cache_all_feeds_data.add(localsingle_feed);
    }
    this.all_feeds_data = ((ArrayList)paramJceInputStream.read(cache_all_feeds_data, 2, false));
    this.auto_load = paramJceInputStream.read(this.auto_load, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hasmore, 0);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 1);
    }
    if (this.all_feeds_data != null) {
      paramJceOutputStream.write(this.all_feeds_data, 2);
    }
    paramJceOutputStream.write(this.auto_load, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_feeds_rsp
 * JD-Core Version:    0.7.0.1
 */