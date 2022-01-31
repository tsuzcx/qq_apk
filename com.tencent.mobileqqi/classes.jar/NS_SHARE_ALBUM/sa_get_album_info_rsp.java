package NS_SHARE_ALBUM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class sa_get_album_info_rsp
  extends JceStruct
{
  static Album cache_albuminfo;
  public Album albuminfo = null;
  
  public sa_get_album_info_rsp() {}
  
  public sa_get_album_info_rsp(Album paramAlbum)
  {
    this.albuminfo = paramAlbum;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_albuminfo == null) {
      cache_albuminfo = new Album();
    }
    this.albuminfo = ((Album)paramJceInputStream.read(cache_albuminfo, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.albuminfo != null) {
      paramJceOutputStream.write(this.albuminfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_get_album_info_rsp
 * JD-Core Version:    0.7.0.1
 */