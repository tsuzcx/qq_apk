package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class qun_del_comment_req
  extends JceStruct
{
  static Map cache_busi_param;
  public String albumid = "";
  public Map busi_param = null;
  public String commentid = "";
  public String qunid = "";
  public long srcuin = 0L;
  
  public qun_del_comment_req() {}
  
  public qun_del_comment_req(String paramString1, String paramString2, String paramString3, long paramLong, Map paramMap)
  {
    this.qunid = paramString1;
    this.albumid = paramString2;
    this.commentid = paramString3;
    this.srcuin = paramLong;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.commentid = paramJceInputStream.readString(2, true);
    this.srcuin = paramJceInputStream.read(this.srcuin, 3, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.qunid, 0);
    paramJceOutputStream.write(this.albumid, 1);
    paramJceOutputStream.write(this.commentid, 2);
    paramJceOutputStream.write(this.srcuin, 3);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_del_comment_req
 * JD-Core Version:    0.7.0.1
 */