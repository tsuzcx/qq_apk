package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PhotoSearchBoxPhoto
  extends JceStruct
{
  static ArrayList<PhotoFeedsData> cache_photos = new ArrayList();
  public String attach_info = "";
  public boolean hasmore;
  public ArrayList<PhotoFeedsData> photos;
  public long total;
  
  static
  {
    PhotoFeedsData localPhotoFeedsData = new PhotoFeedsData();
    cache_photos.add(localPhotoFeedsData);
  }
  
  public PhotoSearchBoxPhoto() {}
  
  public PhotoSearchBoxPhoto(ArrayList<PhotoFeedsData> paramArrayList, long paramLong, boolean paramBoolean, String paramString)
  {
    this.photos = paramArrayList;
    this.total = paramLong;
    this.hasmore = paramBoolean;
    this.attach_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photos = ((ArrayList)paramJceInputStream.read(cache_photos, 0, false));
    this.total = paramJceInputStream.read(this.total, 1, false);
    this.hasmore = paramJceInputStream.read(this.hasmore, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.photos != null) {
      paramJceOutputStream.write(this.photos, 0);
    }
    paramJceOutputStream.write(this.total, 1);
    paramJceOutputStream.write(this.hasmore, 2);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PhotoSearchBoxPhoto
 * JD-Core Version:    0.7.0.1
 */