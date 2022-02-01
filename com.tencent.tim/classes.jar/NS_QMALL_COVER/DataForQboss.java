package NS_QMALL_COVER;

import BOSSStrategyCenter.tAdvDesc;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class DataForQboss
  extends JceStruct
{
  static Map<Integer, tAdvDesc> cache_map_adv_desc = new HashMap();
  public Map<Integer, tAdvDesc> map_adv_desc;
  
  static
  {
    tAdvDesc localtAdvDesc = new tAdvDesc();
    cache_map_adv_desc.put(Integer.valueOf(0), localtAdvDesc);
  }
  
  public DataForQboss() {}
  
  public DataForQboss(Map<Integer, tAdvDesc> paramMap)
  {
    this.map_adv_desc = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.map_adv_desc = ((Map)paramJceInputStream.read(cache_map_adv_desc, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.map_adv_desc != null) {
      paramJceOutputStream.write(this.map_adv_desc, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.DataForQboss
 * JD-Core Version:    0.7.0.1
 */