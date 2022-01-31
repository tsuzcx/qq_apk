package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class single_feed
  extends JceStruct
{
  static Map cache_singlefeed;
  public String feed_attach_info = "";
  public String feed_info = "";
  public String feedskey = "";
  public Map singlefeed = null;
  public long status = 0L;
  public int time = 0;
  
  public single_feed() {}
  
  public single_feed(Map paramMap, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.singlefeed = paramMap;
    this.status = paramLong;
    this.feed_info = paramString1;
    this.feed_attach_info = paramString2;
    this.feedskey = paramString3;
    this.time = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_singlefeed == null)
    {
      cache_singlefeed = new HashMap();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_singlefeed.put(Integer.valueOf(0), arrayOfByte);
    }
    this.singlefeed = ((Map)paramJceInputStream.read(cache_singlefeed, 0, false));
    this.status = paramJceInputStream.read(this.status, 1, false);
    this.feed_info = paramJceInputStream.readString(2, false);
    this.feed_attach_info = paramJceInputStream.readString(3, false);
    this.feedskey = paramJceInputStream.readString(4, false);
    this.time = paramJceInputStream.read(this.time, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.singlefeed != null) {
      paramJceOutputStream.write(this.singlefeed, 0);
    }
    paramJceOutputStream.write(this.status, 1);
    if (this.feed_info != null) {
      paramJceOutputStream.write(this.feed_info, 2);
    }
    if (this.feed_attach_info != null) {
      paramJceOutputStream.write(this.feed_attach_info, 3);
    }
    if (this.feedskey != null) {
      paramJceOutputStream.write(this.feedskey, 4);
    }
    paramJceOutputStream.write(this.time, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.single_feed
 * JD-Core Version:    0.7.0.1
 */