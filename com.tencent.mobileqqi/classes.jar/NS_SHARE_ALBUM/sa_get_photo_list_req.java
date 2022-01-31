package NS_SHARE_ALBUM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class sa_get_photo_list_req
  extends JceStruct
{
  public String albumid = "";
  public String attach_info = "";
  
  public sa_get_photo_list_req() {}
  
  public sa_get_photo_list_req(String paramString1, String paramString2)
  {
    this.albumid = paramString1;
    this.attach_info = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, false);
    this.attach_info = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 0);
    }
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_get_photo_list_req
 * JD-Core Version:    0.7.0.1
 */