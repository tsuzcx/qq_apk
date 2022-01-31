package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class get_album_rsp
  extends JceStruct
{
  static Album cache_album;
  public Album album = null;
  
  public get_album_rsp() {}
  
  public get_album_rsp(Album paramAlbum)
  {
    this.album = paramAlbum;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_album == null) {
      cache_album = new Album();
    }
    this.album = ((Album)paramJceInputStream.read(cache_album, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.album, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_album_rsp
 * JD-Core Version:    0.7.0.1
 */