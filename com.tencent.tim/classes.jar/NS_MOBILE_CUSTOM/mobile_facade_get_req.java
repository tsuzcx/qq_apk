package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_facade_get_req
  extends JceStruct
{
  static Map<String, String> cache_mapExtInfo;
  public long lUin;
  public Map<String, String> mapExtInfo;
  public String strId = "";
  
  public mobile_facade_get_req() {}
  
  public mobile_facade_get_req(long paramLong, String paramString, Map<String, String> paramMap)
  {
    this.lUin = paramLong;
    this.strId = paramString;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, false);
    this.strId = paramJceInputStream.readString(1, false);
    if (cache_mapExtInfo == null)
    {
      cache_mapExtInfo = new HashMap();
      cache_mapExtInfo.put("", "");
    }
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    if (this.strId != null) {
      paramJceOutputStream.write(this.strId, 1);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.mobile_facade_get_req
 * JD-Core Version:    0.7.0.1
 */