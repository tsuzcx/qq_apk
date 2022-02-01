package NS_MOBILE_QBOSS_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SceneExt
  extends JceStruct
{
  static Map<String, String> cache_mapExtend;
  public Map<String, String> mapExtend;
  
  public SceneExt() {}
  
  public SceneExt(Map<String, String> paramMap)
  {
    this.mapExtend = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_mapExtend == null)
    {
      cache_mapExtend = new HashMap();
      cache_mapExtend.put("", "");
    }
    this.mapExtend = ((Map)paramJceInputStream.read(cache_mapExtend, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mapExtend != null) {
      paramJceOutputStream.write(this.mapExtend, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_QBOSS_PROTO.SceneExt
 * JD-Core Version:    0.7.0.1
 */