package NS_SHARE_ALBUM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class sa_create_album_req
  extends JceStruct
{
  static Album cache_album;
  static ArrayList cache_uinlist;
  public Album album = null;
  public ArrayList uinlist = null;
  
  public sa_create_album_req() {}
  
  public sa_create_album_req(Album paramAlbum, ArrayList paramArrayList)
  {
    this.album = paramAlbum;
    this.uinlist = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_album == null) {
      cache_album = new Album();
    }
    this.album = ((Album)paramJceInputStream.read(cache_album, 0, false));
    if (cache_uinlist == null)
    {
      cache_uinlist = new ArrayList();
      cache_uinlist.add(Long.valueOf(0L));
    }
    this.uinlist = ((ArrayList)paramJceInputStream.read(cache_uinlist, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.album != null) {
      paramJceOutputStream.write(this.album, 0);
    }
    if (this.uinlist != null) {
      paramJceOutputStream.write(this.uinlist, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_create_album_req
 * JD-Core Version:    0.7.0.1
 */