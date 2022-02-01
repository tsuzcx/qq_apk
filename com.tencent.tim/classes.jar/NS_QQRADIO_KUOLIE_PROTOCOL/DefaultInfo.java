package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class DefaultInfo
  extends JceStruct
{
  static Map<String, ArrayList<String>> cache_topicAndRoomName = new HashMap();
  public Map<String, ArrayList<String>> topicAndRoomName;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("");
    cache_topicAndRoomName.put("", localArrayList);
  }
  
  public DefaultInfo() {}
  
  public DefaultInfo(Map<String, ArrayList<String>> paramMap)
  {
    this.topicAndRoomName = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.topicAndRoomName = ((Map)paramJceInputStream.read(cache_topicAndRoomName, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.topicAndRoomName != null) {
      paramJceOutputStream.write(this.topicAndRoomName, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QQRADIO_KUOLIE_PROTOCOL.DefaultInfo
 * JD-Core Version:    0.7.0.1
 */