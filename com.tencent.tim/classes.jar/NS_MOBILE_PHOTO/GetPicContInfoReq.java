package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetPicContInfoReq
  extends JceStruct
{
  static ArrayList<String> cache_pic_url = new ArrayList();
  public ArrayList<String> pic_url;
  public long uin;
  
  static
  {
    cache_pic_url.add("");
  }
  
  public GetPicContInfoReq() {}
  
  public GetPicContInfoReq(ArrayList<String> paramArrayList, long paramLong)
  {
    this.pic_url = paramArrayList;
    this.uin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pic_url = ((ArrayList)paramJceInputStream.read(cache_pic_url, 0, false));
    this.uin = paramJceInputStream.read(this.uin, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.pic_url != null) {
      paramJceOutputStream.write(this.pic_url, 0);
    }
    paramJceOutputStream.write(this.uin, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetPicContInfoReq
 * JD-Core Version:    0.7.0.1
 */