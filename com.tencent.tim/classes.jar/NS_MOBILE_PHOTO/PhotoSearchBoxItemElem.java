package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PhotoSearchBoxItemElem
  extends JceStruct
{
  static face_show_info cache_face_show = new face_show_info();
  static int cache_type = 0;
  public String categoryid = "";
  public String desc = "";
  public face_show_info face_show;
  public int type;
  public String url = "";
  
  public PhotoSearchBoxItemElem() {}
  
  public PhotoSearchBoxItemElem(int paramInt, String paramString1, String paramString2, face_show_info paramface_show_info, String paramString3)
  {
    this.type = paramInt;
    this.categoryid = paramString1;
    this.desc = paramString2;
    this.face_show = paramface_show_info;
    this.url = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.categoryid = paramJceInputStream.readString(1, false);
    this.desc = paramJceInputStream.readString(2, false);
    this.face_show = ((face_show_info)paramJceInputStream.read(cache_face_show, 3, false));
    this.url = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.categoryid != null) {
      paramJceOutputStream.write(this.categoryid, 1);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 2);
    }
    if (this.face_show != null) {
      paramJceOutputStream.write(this.face_show, 3);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PhotoSearchBoxItemElem
 * JD-Core Version:    0.7.0.1
 */