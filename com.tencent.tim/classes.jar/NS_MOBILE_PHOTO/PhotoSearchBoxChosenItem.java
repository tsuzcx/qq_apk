package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PhotoSearchBoxChosenItem
  extends JceStruct
{
  static ArrayList<PhotoSearchBoxChosenItemElem> cache_elems = new ArrayList();
  public ArrayList<PhotoSearchBoxChosenItemElem> elems;
  
  static
  {
    PhotoSearchBoxChosenItemElem localPhotoSearchBoxChosenItemElem = new PhotoSearchBoxChosenItemElem();
    cache_elems.add(localPhotoSearchBoxChosenItemElem);
  }
  
  public PhotoSearchBoxChosenItem() {}
  
  public PhotoSearchBoxChosenItem(ArrayList<PhotoSearchBoxChosenItemElem> paramArrayList)
  {
    this.elems = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.elems = ((ArrayList)paramJceInputStream.read(cache_elems, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.elems != null) {
      paramJceOutputStream.write(this.elems, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PhotoSearchBoxChosenItem
 * JD-Core Version:    0.7.0.1
 */