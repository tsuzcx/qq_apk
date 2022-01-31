package NS_SHARE_ALBUM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class sa_del_photo_req
  extends JceStruct
{
  static ArrayList cache_photoid_list;
  public String albumid = "";
  public int del_type = 0;
  public String photoid = "";
  public ArrayList photoid_list = null;
  
  public sa_del_photo_req() {}
  
  public sa_del_photo_req(String paramString1, int paramInt, String paramString2, ArrayList paramArrayList)
  {
    this.albumid = paramString1;
    this.del_type = paramInt;
    this.photoid = paramString2;
    this.photoid_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, false);
    this.del_type = paramJceInputStream.read(this.del_type, 1, false);
    this.photoid = paramJceInputStream.readString(2, false);
    if (cache_photoid_list == null)
    {
      cache_photoid_list = new ArrayList();
      cache_photoid_list.add("");
    }
    this.photoid_list = ((ArrayList)paramJceInputStream.read(cache_photoid_list, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 0);
    }
    paramJceOutputStream.write(this.del_type, 1);
    if (this.photoid != null) {
      paramJceOutputStream.write(this.photoid, 2);
    }
    if (this.photoid_list != null) {
      paramJceOutputStream.write(this.photoid_list, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_del_photo_req
 * JD-Core Version:    0.7.0.1
 */