package NS_SHARE_ALBUM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class sa_get_photo_list_ex_req
  extends JceStruct
{
  static Map cache_busi_param;
  public String albumid = "";
  public Map busi_param = null;
  public String curlloc = "";
  public long left = 0L;
  public long right = 0L;
  public long type = 0L;
  public String url = "";
  
  public sa_get_photo_list_ex_req() {}
  
  public sa_get_photo_list_ex_req(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, String paramString3, Map paramMap)
  {
    this.albumid = paramString1;
    this.curlloc = paramString2;
    this.left = paramLong1;
    this.right = paramLong2;
    this.type = paramLong3;
    this.url = paramString3;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, false);
    this.curlloc = paramJceInputStream.readString(1, false);
    this.left = paramJceInputStream.read(this.left, 2, false);
    this.right = paramJceInputStream.read(this.right, 3, false);
    this.type = paramJceInputStream.read(this.type, 4, false);
    this.url = paramJceInputStream.readString(5, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 0);
    }
    if (this.curlloc != null) {
      paramJceOutputStream.write(this.curlloc, 1);
    }
    paramJceOutputStream.write(this.left, 2);
    paramJceOutputStream.write(this.right, 3);
    paramJceOutputStream.write(this.type, 4);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 5);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_get_photo_list_ex_req
 * JD-Core Version:    0.7.0.1
 */