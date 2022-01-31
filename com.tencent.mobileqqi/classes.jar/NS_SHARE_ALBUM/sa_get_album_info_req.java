package NS_SHARE_ALBUM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class sa_get_album_info_req
  extends JceStruct
{
  public String albumid = "";
  
  public sa_get_album_info_req() {}
  
  public sa_get_album_info_req(String paramString)
  {
    this.albumid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_get_album_info_req
 * JD-Core Version:    0.7.0.1
 */