package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PhotoSearchBoxItem
  extends JceStruct
{
  static ArrayList<PhotoSearchBoxItemElem> cache_elems = new ArrayList();
  public String desc = "";
  public ArrayList<PhotoSearchBoxItemElem> elems;
  
  static
  {
    PhotoSearchBoxItemElem localPhotoSearchBoxItemElem = new PhotoSearchBoxItemElem();
    cache_elems.add(localPhotoSearchBoxItemElem);
  }
  
  public PhotoSearchBoxItem() {}
  
  public PhotoSearchBoxItem(ArrayList<PhotoSearchBoxItemElem> paramArrayList, String paramString)
  {
    this.elems = paramArrayList;
    this.desc = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.elems = ((ArrayList)paramJceInputStream.read(cache_elems, 0, false));
    this.desc = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.elems != null) {
      paramJceOutputStream.write(this.elems, 0);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PhotoSearchBoxItem
 * JD-Core Version:    0.7.0.1
 */