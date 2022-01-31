package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class single_detail
  extends JceStruct
{
  static Map cache_singledetail;
  public Map singledetail = null;
  
  public single_detail() {}
  
  public single_detail(Map paramMap)
  {
    this.singledetail = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_singledetail == null)
    {
      cache_singledetail = new HashMap();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_singledetail.put(Integer.valueOf(0), arrayOfByte);
    }
    this.singledetail = ((Map)paramJceInputStream.read(cache_singledetail, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.singledetail != null) {
      paramJceOutputStream.write(this.singledetail, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.single_detail
 * JD-Core Version:    0.7.0.1
 */