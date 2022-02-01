package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class PluginInfo
  extends JceStruct
{
  static Map<String, String> cache_extinfo = new HashMap();
  public Map<String, String> extinfo;
  public String iconurl = "";
  public long id;
  public String name = "";
  
  static
  {
    cache_extinfo.put("", "");
  }
  
  public PluginInfo() {}
  
  public PluginInfo(long paramLong, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    this.id = paramLong;
    this.name = paramString1;
    this.iconurl = paramString2;
    this.extinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.iconurl = paramJceInputStream.readString(2, false);
    this.extinfo = ((Map)paramJceInputStream.read(cache_extinfo, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 1);
    }
    if (this.iconurl != null) {
      paramJceOutputStream.write(this.iconurl, 2);
    }
    if (this.extinfo != null) {
      paramJceOutputStream.write(this.extinfo, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_WIDGET.PluginInfo
 * JD-Core Version:    0.7.0.1
 */