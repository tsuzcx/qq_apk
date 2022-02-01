package NS_MOBILE_QBOSS_PROTO;

import BOSSStrategyCenter.tAdvDesc;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class MobileQbossAdvRsp
  extends JceStruct
{
  static Map<Integer, ArrayList<tAdvDesc>> cache_mapAdv = new HashMap();
  static Map<Integer, Long> cache_map_next_query_ts;
  public int iRet;
  public Map<Integer, ArrayList<tAdvDesc>> mapAdv;
  public Map<Integer, Long> map_next_query_ts;
  public String sMsg = "";
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new tAdvDesc());
    cache_mapAdv.put(Integer.valueOf(0), localArrayList);
    cache_map_next_query_ts = new HashMap();
    cache_map_next_query_ts.put(Integer.valueOf(0), Long.valueOf(0L));
  }
  
  public MobileQbossAdvRsp() {}
  
  public MobileQbossAdvRsp(int paramInt, String paramString, Map<Integer, ArrayList<tAdvDesc>> paramMap, Map<Integer, Long> paramMap1)
  {
    this.iRet = paramInt;
    this.sMsg = paramString;
    this.mapAdv = paramMap;
    this.map_next_query_ts = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, true);
    this.sMsg = paramJceInputStream.readString(1, true);
    this.mapAdv = ((Map)paramJceInputStream.read(cache_mapAdv, 2, true));
    this.map_next_query_ts = ((Map)paramJceInputStream.read(cache_map_next_query_ts, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    paramJceOutputStream.write(this.sMsg, 1);
    paramJceOutputStream.write(this.mapAdv, 2);
    if (this.map_next_query_ts != null) {
      paramJceOutputStream.write(this.map_next_query_ts, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp
 * JD-Core Version:    0.7.0.1
 */