package ShareAlbumHelperProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetMyAlbumListRspAlbumBase
  extends JceStruct
{
  static ArrayList cache_users;
  public String cover_image = "";
  public String id = "";
  public String name = "";
  public long user_total = 0L;
  public ArrayList users = null;
  
  public GetMyAlbumListRspAlbumBase() {}
  
  public GetMyAlbumListRspAlbumBase(String paramString1, String paramString2, String paramString3, long paramLong, ArrayList paramArrayList)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.cover_image = paramString3;
    this.user_total = paramLong;
    this.users = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, true);
    this.name = paramJceInputStream.readString(1, true);
    this.cover_image = paramJceInputStream.readString(2, false);
    this.user_total = paramJceInputStream.read(this.user_total, 3, false);
    if (cache_users == null)
    {
      cache_users = new ArrayList();
      cache_users.add(Long.valueOf(0L));
    }
    this.users = ((ArrayList)paramJceInputStream.read(cache_users, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.name, 1);
    if (this.cover_image != null) {
      paramJceOutputStream.write(this.cover_image, 2);
    }
    paramJceOutputStream.write(this.user_total, 3);
    if (this.users != null) {
      paramJceOutputStream.write(this.users, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ShareAlbumHelperProtocol.GetMyAlbumListRspAlbumBase
 * JD-Core Version:    0.7.0.1
 */