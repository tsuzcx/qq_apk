package NS_SHARE_ALBUM;

import NS_MOBILE_FEEDS.s_user;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class Album
  extends JceStruct
{
  static s_user cache_createUser;
  static ArrayList cache_user_list;
  public String albumid = "";
  public s_user createUser = null;
  public long createtime = 0L;
  public long lastuploadtime = 0L;
  public long modifytime = 0L;
  public String name = "";
  public String news = "";
  public int total = 0;
  public int unread_count = 0;
  public ArrayList user_list = null;
  
  public Album() {}
  
  public Album(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, int paramInt1, s_user params_user, int paramInt2, String paramString3, ArrayList paramArrayList)
  {
    this.albumid = paramString1;
    this.name = paramString2;
    this.createtime = paramLong1;
    this.modifytime = paramLong2;
    this.lastuploadtime = paramLong3;
    this.total = paramInt1;
    this.createUser = params_user;
    this.unread_count = paramInt2;
    this.news = paramString3;
    this.user_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.createtime = paramJceInputStream.read(this.createtime, 2, false);
    this.modifytime = paramJceInputStream.read(this.modifytime, 3, false);
    this.lastuploadtime = paramJceInputStream.read(this.lastuploadtime, 4, false);
    this.total = paramJceInputStream.read(this.total, 5, false);
    if (cache_createUser == null) {
      cache_createUser = new s_user();
    }
    this.createUser = ((s_user)paramJceInputStream.read(cache_createUser, 6, false));
    this.unread_count = paramJceInputStream.read(this.unread_count, 7, false);
    this.news = paramJceInputStream.readString(8, false);
    if (cache_user_list == null)
    {
      cache_user_list = new ArrayList();
      s_user locals_user = new s_user();
      cache_user_list.add(locals_user);
    }
    this.user_list = ((ArrayList)paramJceInputStream.read(cache_user_list, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 0);
    }
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 1);
    }
    paramJceOutputStream.write(this.createtime, 2);
    paramJceOutputStream.write(this.modifytime, 3);
    paramJceOutputStream.write(this.lastuploadtime, 4);
    paramJceOutputStream.write(this.total, 5);
    if (this.createUser != null) {
      paramJceOutputStream.write(this.createUser, 6);
    }
    paramJceOutputStream.write(this.unread_count, 7);
    if (this.news != null) {
      paramJceOutputStream.write(this.news, 8);
    }
    if (this.user_list != null) {
      paramJceOutputStream.write(this.user_list, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.Album
 * JD-Core Version:    0.7.0.1
 */