package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CategoryRecommendItem
  extends JceStruct
{
  static ArrayList<PhotoFeedsData> cache_photos = new ArrayList();
  public String categoryid = "";
  public String desc = "";
  public ArrayList<PhotoFeedsData> photos;
  
  static
  {
    PhotoFeedsData localPhotoFeedsData = new PhotoFeedsData();
    cache_photos.add(localPhotoFeedsData);
  }
  
  public CategoryRecommendItem() {}
  
  public CategoryRecommendItem(ArrayList<PhotoFeedsData> paramArrayList, String paramString1, String paramString2)
  {
    this.photos = paramArrayList;
    this.categoryid = paramString1;
    this.desc = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photos = ((ArrayList)paramJceInputStream.read(cache_photos, 0, false));
    this.categoryid = paramJceInputStream.readString(1, false);
    this.desc = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.photos != null) {
      paramJceOutputStream.write(this.photos, 0);
    }
    if (this.categoryid != null) {
      paramJceOutputStream.write(this.categoryid, 1);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.CategoryRecommendItem
 * JD-Core Version:    0.7.0.1
 */