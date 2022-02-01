package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class modify_travel_photo_scence_rsp
  extends JceStruct
{
  static Map<String, Integer> cache_photo_result;
  static Map<String, Integer> cache_poi_result;
  static Map<Long, Long> cache_time_range = new HashMap();
  public Map<String, Integer> photo_result;
  public Map<String, Integer> poi_result;
  public String poiid = "";
  public Map<Long, Long> time_range;
  
  static
  {
    cache_time_range.put(Long.valueOf(0L), Long.valueOf(0L));
    cache_poi_result = new HashMap();
    cache_poi_result.put("", Integer.valueOf(0));
    cache_photo_result = new HashMap();
    cache_photo_result.put("", Integer.valueOf(0));
  }
  
  public modify_travel_photo_scence_rsp() {}
  
  public modify_travel_photo_scence_rsp(String paramString, Map<Long, Long> paramMap, Map<String, Integer> paramMap1, Map<String, Integer> paramMap2)
  {
    this.poiid = paramString;
    this.time_range = paramMap;
    this.poi_result = paramMap1;
    this.photo_result = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.poiid = paramJceInputStream.readString(0, true);
    this.time_range = ((Map)paramJceInputStream.read(cache_time_range, 1, false));
    this.poi_result = ((Map)paramJceInputStream.read(cache_poi_result, 2, false));
    this.photo_result = ((Map)paramJceInputStream.read(cache_photo_result, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.poiid, 0);
    if (this.time_range != null) {
      paramJceOutputStream.write(this.time_range, 1);
    }
    if (this.poi_result != null) {
      paramJceOutputStream.write(this.poi_result, 2);
    }
    if (this.photo_result != null) {
      paramJceOutputStream.write(this.photo_result, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.modify_travel_photo_scence_rsp
 * JD-Core Version:    0.7.0.1
 */