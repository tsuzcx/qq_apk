package ShareAlbumHelperProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetMyAlbumListRspAlbumExt
  extends JceStruct
{
  public String id = "";
  public boolean is_unread_album = false;
  public String last_feed = "";
  public long last_time = 0L;
  public long unread = 0L;
  
  public GetMyAlbumListRspAlbumExt() {}
  
  public GetMyAlbumListRspAlbumExt(String paramString1, long paramLong1, String paramString2, long paramLong2, boolean paramBoolean)
  {
    this.id = paramString1;
    this.unread = paramLong1;
    this.last_feed = paramString2;
    this.last_time = paramLong2;
    this.is_unread_album = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, true);
    this.unread = paramJceInputStream.read(this.unread, 1, false);
    this.last_feed = paramJceInputStream.readString(2, false);
    this.last_time = paramJceInputStream.read(this.last_time, 3, false);
    this.is_unread_album = paramJceInputStream.read(this.is_unread_album, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.unread, 1);
    if (this.last_feed != null) {
      paramJceOutputStream.write(this.last_feed, 2);
    }
    paramJceOutputStream.write(this.last_time, 3);
    paramJceOutputStream.write(this.is_unread_album, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ShareAlbumHelperProtocol.GetMyAlbumListRspAlbumExt
 * JD-Core Version:    0.7.0.1
 */