package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class CommonInfo
  extends JceStruct
{
  static Map<String, String> cache_mapExt = new HashMap();
  public String cookie = "";
  public byte hasMore;
  public byte isRefresh;
  public Map<String, String> mapExt;
  
  static
  {
    cache_mapExt.put("", "");
  }
  
  public CommonInfo() {}
  
  public CommonInfo(String paramString, byte paramByte1, Map<String, String> paramMap, byte paramByte2)
  {
    this.cookie = paramString;
    this.hasMore = paramByte1;
    this.mapExt = paramMap;
    this.isRefresh = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cookie = paramJceInputStream.readString(0, false);
    this.hasMore = paramJceInputStream.read(this.hasMore, 1, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 2, false));
    this.isRefresh = paramJceInputStream.read(this.isRefresh, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.cookie != null) {
      paramJceOutputStream.write(this.cookie, 0);
    }
    paramJceOutputStream.write(this.hasMore, 1);
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 2);
    }
    paramJceOutputStream.write(this.isRefresh, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QQRADIO_KUOLIE_PROTOCOL.CommonInfo
 * JD-Core Version:    0.7.0.1
 */