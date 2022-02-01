package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class get_photo_comment_req
  extends JceStruct
{
  static Map<String, String> cache_extent_info = new HashMap();
  public String albumid = "";
  public String attach_info = "";
  public int commenttype;
  public Map<String, String> extent_info;
  public int order;
  public String photoid = "";
  public int refresh_type = 8;
  public String topicid = "";
  public long uin;
  
  static
  {
    cache_extent_info.put("", "");
  }
  
  public get_photo_comment_req() {}
  
  public get_photo_comment_req(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.uin = paramLong;
    this.albumid = paramString1;
    this.photoid = paramString2;
    this.commenttype = paramInt;
    this.topicid = paramString3;
  }
  
  public get_photo_comment_req(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, Map<String, String> paramMap)
  {
    this.uin = paramLong;
    this.albumid = paramString1;
    this.photoid = paramString2;
    this.commenttype = paramInt;
    this.topicid = paramString3;
    this.extent_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.photoid = paramJceInputStream.readString(2, true);
    this.attach_info = paramJceInputStream.readString(3, true);
    this.refresh_type = paramJceInputStream.read(this.refresh_type, 4, false);
    this.order = paramJceInputStream.read(this.order, 5, false);
    this.commenttype = paramJceInputStream.read(this.commenttype, 6, false);
    this.topicid = paramJceInputStream.readString(7, false);
    this.extent_info = ((Map)paramJceInputStream.read(cache_extent_info, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.albumid, 1);
    paramJceOutputStream.write(this.photoid, 2);
    paramJceOutputStream.write(this.attach_info, 3);
    paramJceOutputStream.write(this.refresh_type, 4);
    paramJceOutputStream.write(this.order, 5);
    paramJceOutputStream.write(this.commenttype, 6);
    if (this.topicid != null) {
      paramJceOutputStream.write(this.topicid, 7);
    }
    if (this.extent_info != null) {
      paramJceOutputStream.write(this.extent_info, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_photo_comment_req
 * JD-Core Version:    0.7.0.1
 */