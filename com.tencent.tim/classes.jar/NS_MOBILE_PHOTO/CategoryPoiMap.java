package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CategoryPoiMap
  extends JceStruct
{
  public String poi_map_key = "";
  
  public CategoryPoiMap() {}
  
  public CategoryPoiMap(String paramString)
  {
    this.poi_map_key = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.poi_map_key = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.poi_map_key != null) {
      paramJceOutputStream.write(this.poi_map_key, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.CategoryPoiMap
 * JD-Core Version:    0.7.0.1
 */