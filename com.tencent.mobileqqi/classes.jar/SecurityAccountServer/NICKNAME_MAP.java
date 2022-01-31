package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class NICKNAME_MAP
  extends JceStruct
{
  static Map cache__nicknameMap;
  public Map _nicknameMap = null;
  
  public NICKNAME_MAP() {}
  
  public NICKNAME_MAP(Map paramMap)
  {
    this._nicknameMap = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache__nicknameMap == null)
    {
      cache__nicknameMap = new HashMap();
      cache__nicknameMap.put(Long.valueOf(0L), "");
    }
    this._nicknameMap = ((Map)paramJceInputStream.read(cache__nicknameMap, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this._nicknameMap, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SecurityAccountServer.NICKNAME_MAP
 * JD-Core Version:    0.7.0.1
 */