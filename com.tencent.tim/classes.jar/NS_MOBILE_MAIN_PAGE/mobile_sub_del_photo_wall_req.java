package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_sub_del_photo_wall_req
  extends JceStruct
{
  static ArrayList<PhotoWall> cache_vecUrls;
  public ArrayList<PhotoWall> vecUrls;
  
  public mobile_sub_del_photo_wall_req() {}
  
  public mobile_sub_del_photo_wall_req(ArrayList<PhotoWall> paramArrayList)
  {
    this.vecUrls = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecUrls == null)
    {
      cache_vecUrls = new ArrayList();
      PhotoWall localPhotoWall = new PhotoWall();
      cache_vecUrls.add(localPhotoWall);
    }
    this.vecUrls = ((ArrayList)paramJceInputStream.read(cache_vecUrls, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecUrls, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_del_photo_wall_req
 * JD-Core Version:    0.7.0.1
 */