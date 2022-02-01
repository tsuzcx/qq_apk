package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_original
  extends JceStruct
{
  static Map<Integer, byte[]> cache_original_data = new HashMap();
  public Map<Integer, byte[]> original_data;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_original_data.put(Integer.valueOf(0), arrayOfByte);
  }
  
  public cell_original() {}
  
  public cell_original(Map<Integer, byte[]> paramMap)
  {
    this.original_data = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.original_data = ((Map)paramJceInputStream.read(cache_original_data, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.original_data != null) {
      paramJceOutputStream.write(this.original_data, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_original
 * JD-Core Version:    0.7.0.1
 */