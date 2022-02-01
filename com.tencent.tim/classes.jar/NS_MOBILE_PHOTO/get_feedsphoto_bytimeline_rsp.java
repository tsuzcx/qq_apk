package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class get_feedsphoto_bytimeline_rsp
  extends JceStruct
{
  static ArrayList<PhotoFeedsData> cache_all_applist_data = new ArrayList();
  public ArrayList<PhotoFeedsData> all_applist_data;
  public String attach_info = "";
  public int hasmore;
  
  static
  {
    PhotoFeedsData localPhotoFeedsData = new PhotoFeedsData();
    cache_all_applist_data.add(localPhotoFeedsData);
  }
  
  public get_feedsphoto_bytimeline_rsp() {}
  
  public get_feedsphoto_bytimeline_rsp(ArrayList<PhotoFeedsData> paramArrayList, int paramInt, String paramString)
  {
    this.all_applist_data = paramArrayList;
    this.hasmore = paramInt;
    this.attach_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.all_applist_data = ((ArrayList)paramJceInputStream.read(cache_all_applist_data, 0, false));
    this.hasmore = paramJceInputStream.read(this.hasmore, 1, false);
    this.attach_info = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.all_applist_data != null) {
      paramJceOutputStream.write(this.all_applist_data, 0);
    }
    paramJceOutputStream.write(this.hasmore, 1);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_feedsphoto_bytimeline_rsp
 * JD-Core Version:    0.7.0.1
 */