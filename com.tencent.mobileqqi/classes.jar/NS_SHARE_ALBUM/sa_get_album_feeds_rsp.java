package NS_SHARE_ALBUM;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class sa_get_album_feeds_rsp
  extends JceStruct
{
  static ArrayList cache_all_feeds_data;
  static ArrayList cache_msglist;
  public ArrayList all_feeds_data = null;
  public String attach_info = "";
  public int auto_load = 0;
  public int hasmore = 0;
  public ArrayList msglist = null;
  
  public sa_get_album_feeds_rsp() {}
  
  public sa_get_album_feeds_rsp(int paramInt1, String paramString, ArrayList paramArrayList1, int paramInt2, ArrayList paramArrayList2)
  {
    this.hasmore = paramInt1;
    this.attach_info = paramString;
    this.all_feeds_data = paramArrayList1;
    this.auto_load = paramInt2;
    this.msglist = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasmore = paramJceInputStream.read(this.hasmore, 0, false);
    this.attach_info = paramJceInputStream.readString(1, false);
    Object localObject;
    if (cache_all_feeds_data == null)
    {
      cache_all_feeds_data = new ArrayList();
      localObject = new single_feed();
      cache_all_feeds_data.add(localObject);
    }
    this.all_feeds_data = ((ArrayList)paramJceInputStream.read(cache_all_feeds_data, 2, false));
    this.auto_load = paramJceInputStream.read(this.auto_load, 3, false);
    if (cache_msglist == null)
    {
      cache_msglist = new ArrayList();
      localObject = new PhotoListMsg();
      cache_msglist.add(localObject);
    }
    this.msglist = ((ArrayList)paramJceInputStream.read(cache_msglist, 4, false));
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
    if (this.msglist != null) {
      paramJceOutputStream.write(this.msglist, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_get_album_feeds_rsp
 * JD-Core Version:    0.7.0.1
 */