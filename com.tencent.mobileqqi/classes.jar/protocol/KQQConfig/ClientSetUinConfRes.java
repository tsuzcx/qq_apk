package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class ClientSetUinConfRes
  extends JceStruct
{
  static Map cache_uinConfRes;
  public Map uinConfRes = null;
  
  public ClientSetUinConfRes() {}
  
  public ClientSetUinConfRes(Map paramMap)
  {
    this.uinConfRes = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_uinConfRes == null)
    {
      cache_uinConfRes = new HashMap();
      cache_uinConfRes.put("", Integer.valueOf(0));
    }
    this.uinConfRes = ((Map)paramJceInputStream.read(cache_uinConfRes, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uinConfRes, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.ClientSetUinConfRes
 * JD-Core Version:    0.7.0.1
 */