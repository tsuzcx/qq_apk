package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CategoryPhoto
  extends JceStruct
{
  static ArrayList<PhotoFeedsData> cache_cover_photos;
  static ArrayList<PhotoFeedsData> cache_photos = new ArrayList();
  public String categoryid = "";
  public ArrayList<PhotoFeedsData> cover_photos;
  public boolean has_more;
  public String photo_page_str = "";
  public ArrayList<PhotoFeedsData> photos;
  
  static
  {
    PhotoFeedsData localPhotoFeedsData = new PhotoFeedsData();
    cache_photos.add(localPhotoFeedsData);
    cache_cover_photos = new ArrayList();
    localPhotoFeedsData = new PhotoFeedsData();
    cache_cover_photos.add(localPhotoFeedsData);
  }
  
  public CategoryPhoto() {}
  
  public CategoryPhoto(ArrayList<PhotoFeedsData> paramArrayList1, String paramString1, String paramString2, boolean paramBoolean, ArrayList<PhotoFeedsData> paramArrayList2)
  {
    this.photos = paramArrayList1;
    this.categoryid = paramString1;
    this.photo_page_str = paramString2;
    this.has_more = paramBoolean;
    this.cover_photos = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photos = ((ArrayList)paramJceInputStream.read(cache_photos, 0, false));
    this.categoryid = paramJceInputStream.readString(1, false);
    this.photo_page_str = paramJceInputStream.readString(2, false);
    this.has_more = paramJceInputStream.read(this.has_more, 3, false);
    this.cover_photos = ((ArrayList)paramJceInputStream.read(cache_cover_photos, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.photos != null) {
      paramJceOutputStream.write(this.photos, 0);
    }
    if (this.categoryid != null) {
      paramJceOutputStream.write(this.categoryid, 1);
    }
    if (this.photo_page_str != null) {
      paramJceOutputStream.write(this.photo_page_str, 2);
    }
    paramJceOutputStream.write(this.has_more, 3);
    if (this.cover_photos != null) {
      paramJceOutputStream.write(this.cover_photos, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.CategoryPhoto
 * JD-Core Version:    0.7.0.1
 */