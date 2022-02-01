package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picurl;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_outshare
  extends JceStruct
{
  static Map<Integer, s_picurl> cache_photourl = new HashMap();
  public int album_right;
  public String md5 = "";
  public Map<Integer, s_picurl> photourl;
  public String qq_url = "";
  public int space_right;
  public String summary = "";
  public String title = "";
  public String weixin_url = "";
  public String xcx_name = "";
  public String xcx_share_path = "";
  
  static
  {
    s_picurl locals_picurl = new s_picurl();
    cache_photourl.put(Integer.valueOf(0), locals_picurl);
  }
  
  public s_outshare() {}
  
  public s_outshare(String paramString1, String paramString2, String paramString3, String paramString4, Map<Integer, s_picurl> paramMap, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7)
  {
    this.weixin_url = paramString1;
    this.qq_url = paramString2;
    this.title = paramString3;
    this.summary = paramString4;
    this.photourl = paramMap;
    this.space_right = paramInt1;
    this.album_right = paramInt2;
    this.xcx_share_path = paramString5;
    this.xcx_name = paramString6;
    this.md5 = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.weixin_url = paramJceInputStream.readString(0, false);
    this.qq_url = paramJceInputStream.readString(1, false);
    this.title = paramJceInputStream.readString(2, false);
    this.summary = paramJceInputStream.readString(3, false);
    this.photourl = ((Map)paramJceInputStream.read(cache_photourl, 4, false));
    this.space_right = paramJceInputStream.read(this.space_right, 5, false);
    this.album_right = paramJceInputStream.read(this.album_right, 6, false);
    this.xcx_share_path = paramJceInputStream.readString(7, false);
    this.xcx_name = paramJceInputStream.readString(8, false);
    this.md5 = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.weixin_url != null) {
      paramJceOutputStream.write(this.weixin_url, 0);
    }
    if (this.qq_url != null) {
      paramJceOutputStream.write(this.qq_url, 1);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 2);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 3);
    }
    if (this.photourl != null) {
      paramJceOutputStream.write(this.photourl, 4);
    }
    paramJceOutputStream.write(this.space_right, 5);
    paramJceOutputStream.write(this.album_right, 6);
    if (this.xcx_share_path != null) {
      paramJceOutputStream.write(this.xcx_share_path, 7);
    }
    if (this.xcx_name != null) {
      paramJceOutputStream.write(this.xcx_name, 8);
    }
    if (this.md5 != null) {
      paramJceOutputStream.write(this.md5, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.s_outshare
 * JD-Core Version:    0.7.0.1
 */