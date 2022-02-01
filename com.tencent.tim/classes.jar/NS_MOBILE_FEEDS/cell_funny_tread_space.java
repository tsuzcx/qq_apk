package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cell_funny_tread_space
  extends JceStruct
{
  static ArrayList<String> cache_actions = new ArrayList();
  static Map<String, String> cache_extendInfo;
  public ArrayList<String> actions;
  public Map<String, String> extendInfo;
  
  static
  {
    cache_actions.add("");
    cache_extendInfo = new HashMap();
    cache_extendInfo.put("", "");
  }
  
  public cell_funny_tread_space() {}
  
  public cell_funny_tread_space(ArrayList<String> paramArrayList, Map<String, String> paramMap)
  {
    this.actions = paramArrayList;
    this.extendInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.actions = ((ArrayList)paramJceInputStream.read(cache_actions, 0, false));
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.actions != null) {
      paramJceOutputStream.write(this.actions, 0);
    }
    if (this.extendInfo != null) {
      paramJceOutputStream.write(this.extendInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_funny_tread_space
 * JD-Core Version:    0.7.0.1
 */