package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_sub_get_photo_wall_rsp
  extends JceStruct
{
  static ArrayList<PhotoWall> cache_vecUrls;
  public String attachInfo = "";
  public int iHasMore;
  public int photoWallCombinePic;
  public int total_pic;
  public ArrayList<PhotoWall> vecUrls;
  
  public mobile_sub_get_photo_wall_rsp() {}
  
  public mobile_sub_get_photo_wall_rsp(ArrayList<PhotoWall> paramArrayList, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.vecUrls = paramArrayList;
    this.total_pic = paramInt1;
    this.attachInfo = paramString;
    this.iHasMore = paramInt2;
    this.photoWallCombinePic = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecUrls == null)
    {
      cache_vecUrls = new ArrayList();
      PhotoWall localPhotoWall = new PhotoWall();
      cache_vecUrls.add(localPhotoWall);
    }
    this.vecUrls = ((ArrayList)paramJceInputStream.read(cache_vecUrls, 0, false));
    this.total_pic = paramJceInputStream.read(this.total_pic, 1, false);
    this.attachInfo = paramJceInputStream.readString(2, false);
    this.iHasMore = paramJceInputStream.read(this.iHasMore, 3, false);
    this.photoWallCombinePic = paramJceInputStream.read(this.photoWallCombinePic, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecUrls != null) {
      paramJceOutputStream.write(this.vecUrls, 0);
    }
    paramJceOutputStream.write(this.total_pic, 1);
    if (this.attachInfo != null) {
      paramJceOutputStream.write(this.attachInfo, 2);
    }
    paramJceOutputStream.write(this.iHasMore, 3);
    paramJceOutputStream.write(this.photoWallCombinePic, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp
 * JD-Core Version:    0.7.0.1
 */