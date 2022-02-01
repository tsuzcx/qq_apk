package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class photo_adapt_req
  extends JceStruct
{
  static ArrayList<String> cache_photoUrls;
  static int cache_reqSource = 0;
  public ArrayList<String> photoUrls;
  public int reqSource;
  
  static
  {
    cache_photoUrls = new ArrayList();
    cache_photoUrls.add("");
  }
  
  public photo_adapt_req() {}
  
  public photo_adapt_req(int paramInt, ArrayList<String> paramArrayList)
  {
    this.reqSource = paramInt;
    this.photoUrls = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reqSource = paramJceInputStream.read(this.reqSource, 0, true);
    this.photoUrls = ((ArrayList)paramJceInputStream.read(cache_photoUrls, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reqSource, 0);
    paramJceOutputStream.write(this.photoUrls, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.photo_adapt_req
 * JD-Core Version:    0.7.0.1
 */