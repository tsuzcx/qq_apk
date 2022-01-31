package NS_SHARE_ALBUM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class sa_edit_album_req
  extends JceStruct
{
  static int cache_type;
  static ArrayList cache_uinlist;
  public String albumid = "";
  public String name = "";
  public int type = 0;
  public ArrayList uinlist = null;
  
  public sa_edit_album_req() {}
  
  public sa_edit_album_req(String paramString1, int paramInt, String paramString2, ArrayList paramArrayList)
  {
    this.albumid = paramString1;
    this.type = paramInt;
    this.name = paramString2;
    this.uinlist = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
    this.name = paramJceInputStream.readString(2, false);
    if (cache_uinlist == null)
    {
      cache_uinlist = new ArrayList();
      cache_uinlist.add(Long.valueOf(0L));
    }
    this.uinlist = ((ArrayList)paramJceInputStream.read(cache_uinlist, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 0);
    }
    paramJceOutputStream.write(this.type, 1);
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 2);
    }
    if (this.uinlist != null) {
      paramJceOutputStream.write(this.uinlist, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_edit_album_req
 * JD-Core Version:    0.7.0.1
 */