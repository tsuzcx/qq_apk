package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_count_req
  extends JceStruct
{
  static Map<Integer, String> cache_extendinfo;
  static Map<Long, s_comm_data> cache_mapBuf = new HashMap();
  static Map<Long, Long> cache_mapDyncShowTime;
  static Map<Long, Long> cache_mapLastGetTime;
  static Map<String, String> cache_mapSqDyncFeedsInfo;
  static Map<Integer, Long> cache_mapTimeStamp;
  static Map<Integer, count_info> cache_stMapCountInfo;
  public Map<Integer, String> extendinfo;
  public int iRelationType;
  public int iVisitQZoneType;
  public long lastSqDynamicFeedsTime;
  public String lastUndealCountTime = "";
  public Map<Long, s_comm_data> mapBuf;
  public Map<Long, Long> mapDyncShowTime;
  public Map<Long, Long> mapLastGetTime;
  public Map<String, String> mapSqDyncFeedsInfo;
  public Map<Integer, Long> mapTimeStamp;
  public String sTransParam = "";
  public Map<Integer, count_info> stMapCountInfo;
  public long uMask;
  
  static
  {
    Object localObject = new s_comm_data();
    cache_mapBuf.put(Long.valueOf(0L), localObject);
    cache_mapTimeStamp = new HashMap();
    cache_mapTimeStamp.put(Integer.valueOf(0), Long.valueOf(0L));
    cache_mapLastGetTime = new HashMap();
    cache_mapLastGetTime.put(Long.valueOf(0L), Long.valueOf(0L));
    cache_stMapCountInfo = new HashMap();
    localObject = new count_info();
    cache_stMapCountInfo.put(Integer.valueOf(0), localObject);
    cache_extendinfo = new HashMap();
    cache_extendinfo.put(Integer.valueOf(0), "");
    cache_mapSqDyncFeedsInfo = new HashMap();
    cache_mapSqDyncFeedsInfo.put("", "");
    cache_mapDyncShowTime = new HashMap();
    cache_mapDyncShowTime.put(Long.valueOf(0L), Long.valueOf(0L));
  }
  
  public mobile_count_req() {}
  
  public mobile_count_req(long paramLong1, int paramInt1, int paramInt2, Map<Long, s_comm_data> paramMap, Map<Integer, Long> paramMap1, Map<Long, Long> paramMap2, String paramString1, Map<Integer, count_info> paramMap3, Map<Integer, String> paramMap4, String paramString2, long paramLong2, Map<String, String> paramMap5, Map<Long, Long> paramMap6)
  {
    this.uMask = paramLong1;
    this.iRelationType = paramInt1;
    this.iVisitQZoneType = paramInt2;
    this.mapBuf = paramMap;
    this.mapTimeStamp = paramMap1;
    this.mapLastGetTime = paramMap2;
    this.sTransParam = paramString1;
    this.stMapCountInfo = paramMap3;
    this.extendinfo = paramMap4;
    this.lastUndealCountTime = paramString2;
    this.lastSqDynamicFeedsTime = paramLong2;
    this.mapSqDyncFeedsInfo = paramMap5;
    this.mapDyncShowTime = paramMap6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uMask = paramJceInputStream.read(this.uMask, 0, false);
    this.iRelationType = paramJceInputStream.read(this.iRelationType, 1, false);
    this.iVisitQZoneType = paramJceInputStream.read(this.iVisitQZoneType, 2, false);
    this.mapBuf = ((Map)paramJceInputStream.read(cache_mapBuf, 3, false));
    this.mapTimeStamp = ((Map)paramJceInputStream.read(cache_mapTimeStamp, 4, false));
    this.mapLastGetTime = ((Map)paramJceInputStream.read(cache_mapLastGetTime, 5, false));
    this.sTransParam = paramJceInputStream.readString(6, false);
    this.stMapCountInfo = ((Map)paramJceInputStream.read(cache_stMapCountInfo, 7, false));
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 8, false));
    this.lastUndealCountTime = paramJceInputStream.readString(9, false);
    this.lastSqDynamicFeedsTime = paramJceInputStream.read(this.lastSqDynamicFeedsTime, 10, false);
    this.mapSqDyncFeedsInfo = ((Map)paramJceInputStream.read(cache_mapSqDyncFeedsInfo, 11, false));
    this.mapDyncShowTime = ((Map)paramJceInputStream.read(cache_mapDyncShowTime, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uMask, 0);
    paramJceOutputStream.write(this.iRelationType, 1);
    paramJceOutputStream.write(this.iVisitQZoneType, 2);
    if (this.mapBuf != null) {
      paramJceOutputStream.write(this.mapBuf, 3);
    }
    if (this.mapTimeStamp != null) {
      paramJceOutputStream.write(this.mapTimeStamp, 4);
    }
    if (this.mapLastGetTime != null) {
      paramJceOutputStream.write(this.mapLastGetTime, 5);
    }
    if (this.sTransParam != null) {
      paramJceOutputStream.write(this.sTransParam, 6);
    }
    if (this.stMapCountInfo != null) {
      paramJceOutputStream.write(this.stMapCountInfo, 7);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 8);
    }
    if (this.lastUndealCountTime != null) {
      paramJceOutputStream.write(this.lastUndealCountTime, 9);
    }
    paramJceOutputStream.write(this.lastSqDynamicFeedsTime, 10);
    if (this.mapSqDyncFeedsInfo != null) {
      paramJceOutputStream.write(this.mapSqDyncFeedsInfo, 11);
    }
    if (this.mapDyncShowTime != null) {
      paramJceOutputStream.write(this.mapDyncShowTime, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_UNDEAL_COUNT.mobile_count_req
 * JD-Core Version:    0.7.0.1
 */