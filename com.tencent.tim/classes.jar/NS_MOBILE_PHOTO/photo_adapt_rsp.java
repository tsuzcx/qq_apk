package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class photo_adapt_rsp
  extends JceStruct
{
  static Map<String, st_adapt_result> cache_urlStatus = new HashMap();
  public Map<String, st_adapt_result> urlStatus;
  
  static
  {
    st_adapt_result localst_adapt_result = new st_adapt_result();
    cache_urlStatus.put("", localst_adapt_result);
  }
  
  public photo_adapt_rsp() {}
  
  public photo_adapt_rsp(Map<String, st_adapt_result> paramMap)
  {
    this.urlStatus = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.urlStatus = ((Map)paramJceInputStream.read(cache_urlStatus, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.urlStatus, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.photo_adapt_rsp
 * JD-Core Version:    0.7.0.1
 */