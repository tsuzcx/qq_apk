package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class NodeList
  extends JceStruct
{
  static Map cache_UserDayInfo;
  public Map UserDayInfo = null;
  
  public NodeList() {}
  
  public NodeList(Map paramMap)
  {
    this.UserDayInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_UserDayInfo == null)
    {
      cache_UserDayInfo = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new DCacheUserPoint());
      cache_UserDayInfo.put(Long.valueOf(0L), localArrayList);
    }
    this.UserDayInfo = ((Map)paramJceInputStream.read(cache_UserDayInfo, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.UserDayInfo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.NodeList
 * JD-Core Version:    0.7.0.1
 */