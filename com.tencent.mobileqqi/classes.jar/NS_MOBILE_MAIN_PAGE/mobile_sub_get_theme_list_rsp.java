package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_COMM.yellow_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_sub_get_theme_list_rsp
  extends JceStruct
{
  static Map cache_mapTimeStamp;
  static ArrayList cache_vecThemeInfo;
  static yellow_info cache_yellowFlag;
  public Map mapTimeStamp = null;
  public String strAttachInfo = "";
  public long uHasMore = 0L;
  public long uTotalCount = 0L;
  public ArrayList vecThemeInfo = null;
  public yellow_info yellowFlag = null;
  
  public mobile_sub_get_theme_list_rsp() {}
  
  public mobile_sub_get_theme_list_rsp(ArrayList paramArrayList, String paramString, long paramLong1, long paramLong2, Map paramMap, yellow_info paramyellow_info)
  {
    this.vecThemeInfo = paramArrayList;
    this.strAttachInfo = paramString;
    this.uTotalCount = paramLong1;
    this.uHasMore = paramLong2;
    this.mapTimeStamp = paramMap;
    this.yellowFlag = paramyellow_info;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecThemeInfo == null)
    {
      cache_vecThemeInfo = new ArrayList();
      ThemeInfo localThemeInfo = new ThemeInfo();
      cache_vecThemeInfo.add(localThemeInfo);
    }
    this.vecThemeInfo = ((ArrayList)paramJceInputStream.read(cache_vecThemeInfo, 0, false));
    this.strAttachInfo = paramJceInputStream.readString(1, false);
    this.uTotalCount = paramJceInputStream.read(this.uTotalCount, 2, false);
    this.uHasMore = paramJceInputStream.read(this.uHasMore, 3, false);
    if (cache_mapTimeStamp == null)
    {
      cache_mapTimeStamp = new HashMap();
      cache_mapTimeStamp.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    this.mapTimeStamp = ((Map)paramJceInputStream.read(cache_mapTimeStamp, 4, false));
    if (cache_yellowFlag == null) {
      cache_yellowFlag = new yellow_info();
    }
    this.yellowFlag = ((yellow_info)paramJceInputStream.read(cache_yellowFlag, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecThemeInfo != null) {
      paramJceOutputStream.write(this.vecThemeInfo, 0);
    }
    if (this.strAttachInfo != null) {
      paramJceOutputStream.write(this.strAttachInfo, 1);
    }
    paramJceOutputStream.write(this.uTotalCount, 2);
    paramJceOutputStream.write(this.uHasMore, 3);
    if (this.mapTimeStamp != null) {
      paramJceOutputStream.write(this.mapTimeStamp, 4);
    }
    if (this.yellowFlag != null) {
      paramJceOutputStream.write(this.yellowFlag, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_theme_list_rsp
 * JD-Core Version:    0.7.0.1
 */