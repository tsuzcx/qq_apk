package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class qun_get_detail_req
  extends JceStruct
{
  static Map cache_busi_param;
  static Map cache_mqqinfo;
  public String albumid = "";
  public String attach_info = "";
  public Map busi_param = null;
  public int count = 0;
  public Map mqqinfo = null;
  public String qunid = "";
  public int refresh_type = 0;
  
  public qun_get_detail_req() {}
  
  public qun_get_detail_req(String paramString1, String paramString2, Map paramMap1, int paramInt1, int paramInt2, String paramString3, Map paramMap2)
  {
    this.qunid = paramString1;
    this.albumid = paramString2;
    this.busi_param = paramMap1;
    this.refresh_type = paramInt1;
    this.count = paramInt2;
    this.attach_info = paramString3;
    this.mqqinfo = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, false);
    this.albumid = paramJceInputStream.readString(1, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 2, false));
    this.refresh_type = paramJceInputStream.read(this.refresh_type, 3, false);
    this.count = paramJceInputStream.read(this.count, 4, false);
    this.attach_info = paramJceInputStream.readString(5, false);
    if (cache_mqqinfo == null)
    {
      cache_mqqinfo = new HashMap();
      cache_mqqinfo.put("", "");
    }
    this.mqqinfo = ((Map)paramJceInputStream.read(cache_mqqinfo, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.qunid != null) {
      paramJceOutputStream.write(this.qunid, 0);
    }
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 1);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 2);
    }
    paramJceOutputStream.write(this.refresh_type, 3);
    paramJceOutputStream.write(this.count, 4);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 5);
    }
    if (this.mqqinfo != null) {
      paramJceOutputStream.write(this.mqqinfo, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_get_detail_req
 * JD-Core Version:    0.7.0.1
 */