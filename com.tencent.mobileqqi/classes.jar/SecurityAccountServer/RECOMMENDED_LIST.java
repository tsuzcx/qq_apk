package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class RECOMMENDED_LIST
  extends JceStruct
{
  static Map cache__mobileList;
  public Map _mobileList = null;
  
  public RECOMMENDED_LIST() {}
  
  public RECOMMENDED_LIST(Map paramMap)
  {
    this._mobileList = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache__mobileList == null)
    {
      cache__mobileList = new HashMap();
      MOBILE_LIST_ITEM localMOBILE_LIST_ITEM = new MOBILE_LIST_ITEM();
      cache__mobileList.put("", localMOBILE_LIST_ITEM);
    }
    this._mobileList = ((Map)paramJceInputStream.read(cache__mobileList, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this._mobileList, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SecurityAccountServer.RECOMMENDED_LIST
 * JD-Core Version:    0.7.0.1
 */