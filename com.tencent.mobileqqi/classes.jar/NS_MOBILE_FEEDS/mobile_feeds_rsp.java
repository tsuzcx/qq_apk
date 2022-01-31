package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_feeds_rsp
  extends JceStruct
{
  static ArrayList cache_all_feeds_data;
  public ArrayList all_feeds_data = null;
  public String attach_info = "";
  public int auto_load = 0;
  public int hasmore = 0;
  public long newcount = 0L;
  public int no_update = 0;
  public long req_count = 0L;
  
  public mobile_feeds_rsp() {}
  
  public mobile_feeds_rsp(int paramInt1, String paramString, ArrayList paramArrayList, long paramLong1, int paramInt2, int paramInt3, long paramLong2)
  {
    this.hasmore = paramInt1;
    this.attach_info = paramString;
    this.all_feeds_data = paramArrayList;
    this.newcount = paramLong1;
    this.auto_load = paramInt2;
    this.no_update = paramInt3;
    this.req_count = paramLong2;
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
    this.newcount = paramJceInputStream.read(this.newcount, 3, false);
    this.auto_load = paramJceInputStream.read(this.auto_load, 4, false);
    this.no_update = paramJceInputStream.read(this.no_update, 5, false);
    this.req_count = paramJceInputStream.read(this.req_count, 6, false);
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
    paramJceOutputStream.write(this.newcount, 3);
    paramJceOutputStream.write(this.auto_load, 4);
    paramJceOutputStream.write(this.no_update, 5);
    paramJceOutputStream.write(this.req_count, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_feeds_rsp
 * JD-Core Version:    0.7.0.1
 */