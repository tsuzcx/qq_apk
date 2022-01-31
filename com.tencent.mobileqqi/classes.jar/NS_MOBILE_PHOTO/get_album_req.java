package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class get_album_req
  extends JceStruct
{
  static Map cache_busi_param;
  public String albumid = "";
  public Map busi_param = null;
  public int type = 0;
  
  public get_album_req() {}
  
  public get_album_req(String paramString, int paramInt, Map paramMap)
  {
    this.albumid = paramString;
    this.type = paramInt;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, true);
    this.type = paramJceInputStream.read(this.type, 1, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albumid, 0);
    paramJceOutputStream.write(this.type, 1);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_album_req
 * JD-Core Version:    0.7.0.1
 */