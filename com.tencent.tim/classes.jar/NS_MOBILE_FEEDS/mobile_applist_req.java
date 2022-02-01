package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_applist_req
  extends JceStruct
{
  static Map<String, String> cache_mapEx = new HashMap();
  public int album_show_type;
  public int appid;
  public String attach_info = "";
  public int count;
  public int extrance_type;
  public Map<String, String> mapEx;
  public int refresh_type;
  public long uin;
  
  static
  {
    cache_mapEx.put("", "");
  }
  
  public mobile_applist_req() {}
  
  public mobile_applist_req(long paramLong, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5, Map<String, String> paramMap)
  {
    this.uin = paramLong;
    this.appid = paramInt1;
    this.count = paramInt2;
    this.attach_info = paramString;
    this.album_show_type = paramInt3;
    this.refresh_type = paramInt4;
    this.extrance_type = paramInt5;
    this.mapEx = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.appid = paramJceInputStream.read(this.appid, 1, false);
    this.count = paramJceInputStream.read(this.count, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    this.album_show_type = paramJceInputStream.read(this.album_show_type, 4, false);
    this.refresh_type = paramJceInputStream.read(this.refresh_type, 5, false);
    this.extrance_type = paramJceInputStream.read(this.extrance_type, 6, false);
    this.mapEx = ((Map)paramJceInputStream.read(cache_mapEx, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.count, 2);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
    paramJceOutputStream.write(this.album_show_type, 4);
    paramJceOutputStream.write(this.refresh_type, 5);
    paramJceOutputStream.write(this.extrance_type, 6);
    if (this.mapEx != null) {
      paramJceOutputStream.write(this.mapEx, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_applist_req
 * JD-Core Version:    0.7.0.1
 */