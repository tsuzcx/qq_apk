package NS_SHARE_ALBUM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class sa_add_reply_req
  extends JceStruct
{
  static Map cache_busi_param;
  public String albumId = "";
  public Map busi_param = null;
  public String commentid = "";
  public long commentuin = 0L;
  public String content = "";
  public long ownuin = 0L;
  public long uin = 0L;
  
  public sa_add_reply_req() {}
  
  public sa_add_reply_req(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, Map paramMap)
  {
    this.uin = paramLong1;
    this.ownuin = paramLong2;
    this.commentuin = paramLong3;
    this.albumId = paramString1;
    this.commentid = paramString2;
    this.content = paramString3;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.ownuin = paramJceInputStream.read(this.ownuin, 2, false);
    this.commentuin = paramJceInputStream.read(this.commentuin, 3, false);
    this.albumId = paramJceInputStream.readString(4, false);
    this.commentid = paramJceInputStream.readString(5, false);
    this.content = paramJceInputStream.readString(6, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.ownuin, 2);
    paramJceOutputStream.write(this.commentuin, 3);
    if (this.albumId != null) {
      paramJceOutputStream.write(this.albumId, 4);
    }
    if (this.commentid != null) {
      paramJceOutputStream.write(this.commentid, 5);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 6);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_add_reply_req
 * JD-Core Version:    0.7.0.1
 */