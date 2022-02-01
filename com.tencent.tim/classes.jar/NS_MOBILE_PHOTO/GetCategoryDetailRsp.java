package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class GetCategoryDetailRsp
  extends JceStruct
{
  static Map<Integer, GetCategoryDetailRspItem> cache_rsp_item_map = new HashMap();
  public long host;
  public Map<Integer, GetCategoryDetailRspItem> rsp_item_map;
  
  static
  {
    GetCategoryDetailRspItem localGetCategoryDetailRspItem = new GetCategoryDetailRspItem();
    cache_rsp_item_map.put(Integer.valueOf(0), localGetCategoryDetailRspItem);
  }
  
  public GetCategoryDetailRsp() {}
  
  public GetCategoryDetailRsp(long paramLong, Map<Integer, GetCategoryDetailRspItem> paramMap)
  {
    this.host = paramLong;
    this.rsp_item_map = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.host = paramJceInputStream.read(this.host, 0, false);
    this.rsp_item_map = ((Map)paramJceInputStream.read(cache_rsp_item_map, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.host, 0);
    if (this.rsp_item_map != null) {
      paramJceOutputStream.write(this.rsp_item_map, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetCategoryDetailRsp
 * JD-Core Version:    0.7.0.1
 */