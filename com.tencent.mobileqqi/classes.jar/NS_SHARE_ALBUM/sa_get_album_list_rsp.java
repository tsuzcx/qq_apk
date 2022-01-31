package NS_SHARE_ALBUM;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class sa_get_album_list_rsp
  extends JceStruct
{
  static ArrayList cache_all_album_list_data;
  public ArrayList all_album_list_data = null;
  public String attach_info = "";
  public int hasmore = 0;
  public int total = 0;
  
  public sa_get_album_list_rsp() {}
  
  public sa_get_album_list_rsp(ArrayList paramArrayList, int paramInt1, String paramString, int paramInt2)
  {
    this.all_album_list_data = paramArrayList;
    this.hasmore = paramInt1;
    this.attach_info = paramString;
    this.total = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_all_album_list_data == null)
    {
      cache_all_album_list_data = new ArrayList();
      single_feed localsingle_feed = new single_feed();
      cache_all_album_list_data.add(localsingle_feed);
    }
    this.all_album_list_data = ((ArrayList)paramJceInputStream.read(cache_all_album_list_data, 0, false));
    this.hasmore = paramJceInputStream.read(this.hasmore, 1, false);
    this.attach_info = paramJceInputStream.readString(2, false);
    this.total = paramJceInputStream.read(this.total, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.all_album_list_data != null) {
      paramJceOutputStream.write(this.all_album_list_data, 0);
    }
    paramJceOutputStream.write(this.hasmore, 1);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
    paramJceOutputStream.write(this.total, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_get_album_list_rsp
 * JD-Core Version:    0.7.0.1
 */