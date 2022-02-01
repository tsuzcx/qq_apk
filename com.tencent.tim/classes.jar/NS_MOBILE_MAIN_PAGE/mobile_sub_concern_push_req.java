package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_sub_concern_push_req
  extends JceStruct
{
  static Map<Integer, String> cache_map_ext = new HashMap();
  public Map<Integer, String> map_ext;
  public long objuin;
  public int push_type;
  
  static
  {
    cache_map_ext.put(Integer.valueOf(0), "");
  }
  
  public mobile_sub_concern_push_req() {}
  
  public mobile_sub_concern_push_req(long paramLong, int paramInt, Map<Integer, String> paramMap)
  {
    this.objuin = paramLong;
    this.push_type = paramInt;
    this.map_ext = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.objuin = paramJceInputStream.read(this.objuin, 0, true);
    this.push_type = paramJceInputStream.read(this.push_type, 1, true);
    this.map_ext = ((Map)paramJceInputStream.read(cache_map_ext, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.objuin, 0);
    paramJceOutputStream.write(this.push_type, 1);
    if (this.map_ext != null) {
      paramJceOutputStream.write(this.map_ext, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_concern_push_req
 * JD-Core Version:    0.7.0.1
 */