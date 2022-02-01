package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class GetAlbumCommShareKeyReq
  extends JceStruct
{
  static Map<String, String> cache_ins;
  static int cache_scene = 0;
  public Map<String, String> ins;
  public int scene = 0;
  public long uin;
  
  static
  {
    cache_ins = new HashMap();
    cache_ins.put("", "");
  }
  
  public GetAlbumCommShareKeyReq() {}
  
  public GetAlbumCommShareKeyReq(long paramLong, int paramInt, Map<String, String> paramMap)
  {
    this.uin = paramLong;
    this.scene = paramInt;
    this.ins = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.scene = paramJceInputStream.read(this.scene, 1, false);
    this.ins = ((Map)paramJceInputStream.read(cache_ins, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.scene, 1);
    if (this.ins != null) {
      paramJceOutputStream.write(this.ins, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetAlbumCommShareKeyReq
 * JD-Core Version:    0.7.0.1
 */