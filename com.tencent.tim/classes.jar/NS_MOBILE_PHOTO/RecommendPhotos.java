package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RecommendPhotos
  extends JceStruct
{
  static ArrayList<s_picdata> cache_recommend_photos = new ArrayList();
  public String recommend_id = "";
  public ArrayList<s_picdata> recommend_photos;
  
  static
  {
    s_picdata locals_picdata = new s_picdata();
    cache_recommend_photos.add(locals_picdata);
  }
  
  public RecommendPhotos() {}
  
  public RecommendPhotos(ArrayList<s_picdata> paramArrayList, String paramString)
  {
    this.recommend_photos = paramArrayList;
    this.recommend_id = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.recommend_photos = ((ArrayList)paramJceInputStream.read(cache_recommend_photos, 0, false));
    this.recommend_id = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.recommend_photos != null) {
      paramJceOutputStream.write(this.recommend_photos, 0);
    }
    if (this.recommend_id != null) {
      paramJceOutputStream.write(this.recommend_id, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.RecommendPhotos
 * JD-Core Version:    0.7.0.1
 */