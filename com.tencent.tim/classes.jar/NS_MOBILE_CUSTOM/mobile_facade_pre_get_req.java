package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_facade_pre_get_req
  extends JceStruct
{
  static Map<String, String> cache_mapExtInfo;
  static ArrayList<Long> cache_vecReqUin;
  public long lLastFetchTimestamp;
  public Map<String, String> mapExtInfo;
  public ArrayList<Long> vecReqUin;
  
  public mobile_facade_pre_get_req() {}
  
  public mobile_facade_pre_get_req(ArrayList<Long> paramArrayList, long paramLong, Map<String, String> paramMap)
  {
    this.vecReqUin = paramArrayList;
    this.lLastFetchTimestamp = paramLong;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecReqUin == null)
    {
      cache_vecReqUin = new ArrayList();
      cache_vecReqUin.add(Long.valueOf(0L));
    }
    this.vecReqUin = ((ArrayList)paramJceInputStream.read(cache_vecReqUin, 0, false));
    this.lLastFetchTimestamp = paramJceInputStream.read(this.lLastFetchTimestamp, 1, false);
    if (cache_mapExtInfo == null)
    {
      cache_mapExtInfo = new HashMap();
      cache_mapExtInfo.put("", "");
    }
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecReqUin != null) {
      paramJceOutputStream.write(this.vecReqUin, 0);
    }
    paramJceOutputStream.write(this.lLastFetchTimestamp, 1);
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.mobile_facade_pre_get_req
 * JD-Core Version:    0.7.0.1
 */