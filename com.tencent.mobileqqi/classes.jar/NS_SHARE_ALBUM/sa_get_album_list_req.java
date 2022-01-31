package NS_SHARE_ALBUM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class sa_get_album_list_req
  extends JceStruct
{
  public String attach_info = "";
  
  public sa_get_album_list_req() {}
  
  public sa_get_album_list_req(String paramString)
  {
    this.attach_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attach_info = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_get_album_list_req
 * JD-Core Version:    0.7.0.1
 */