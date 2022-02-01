package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_sub_set_photo_wall_combinepic_rsp
  extends JceStruct
{
  static Map<String, String> cache_extinfo;
  public Map<String, String> extinfo;
  public int ret;
  
  public mobile_sub_set_photo_wall_combinepic_rsp() {}
  
  public mobile_sub_set_photo_wall_combinepic_rsp(int paramInt, Map<String, String> paramMap)
  {
    this.ret = paramInt;
    this.extinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    if (cache_extinfo == null)
    {
      cache_extinfo = new HashMap();
      cache_extinfo.put("", "");
    }
    this.extinfo = ((Map)paramJceInputStream.read(cache_extinfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.extinfo != null) {
      paramJceOutputStream.write(this.extinfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_set_photo_wall_combinepic_rsp
 * JD-Core Version:    0.7.0.1
 */