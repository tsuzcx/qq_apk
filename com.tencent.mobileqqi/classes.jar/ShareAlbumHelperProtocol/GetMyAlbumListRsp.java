package ShareAlbumHelperProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetMyAlbumListRsp
  extends JceStruct
{
  static ArrayList cache_album_ids;
  static GetMyAlbumListRspFeed cache_last_feed;
  static ArrayList cache_update_album_bases;
  static ArrayList cache_update_album_exts;
  public ArrayList album_ids = null;
  public GetMyAlbumListRspFeed last_feed = null;
  public long last_visit_time = 0L;
  public ArrayList update_album_bases = null;
  public ArrayList update_album_exts = null;
  
  public GetMyAlbumListRsp() {}
  
  public GetMyAlbumListRsp(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, long paramLong, GetMyAlbumListRspFeed paramGetMyAlbumListRspFeed)
  {
    this.update_album_bases = paramArrayList1;
    this.update_album_exts = paramArrayList2;
    this.album_ids = paramArrayList3;
    this.last_visit_time = paramLong;
    this.last_feed = paramGetMyAlbumListRspFeed;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    Object localObject;
    if (cache_update_album_bases == null)
    {
      cache_update_album_bases = new ArrayList();
      localObject = new GetMyAlbumListRspAlbumBase();
      cache_update_album_bases.add(localObject);
    }
    this.update_album_bases = ((ArrayList)paramJceInputStream.read(cache_update_album_bases, 0, false));
    if (cache_update_album_exts == null)
    {
      cache_update_album_exts = new ArrayList();
      localObject = new GetMyAlbumListRspAlbumExt();
      cache_update_album_exts.add(localObject);
    }
    this.update_album_exts = ((ArrayList)paramJceInputStream.read(cache_update_album_exts, 1, false));
    if (cache_album_ids == null)
    {
      cache_album_ids = new ArrayList();
      cache_album_ids.add("");
    }
    this.album_ids = ((ArrayList)paramJceInputStream.read(cache_album_ids, 2, false));
    this.last_visit_time = paramJceInputStream.read(this.last_visit_time, 3, false);
    if (cache_last_feed == null) {
      cache_last_feed = new GetMyAlbumListRspFeed();
    }
    this.last_feed = ((GetMyAlbumListRspFeed)paramJceInputStream.read(cache_last_feed, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.update_album_bases != null) {
      paramJceOutputStream.write(this.update_album_bases, 0);
    }
    if (this.update_album_exts != null) {
      paramJceOutputStream.write(this.update_album_exts, 1);
    }
    if (this.album_ids != null) {
      paramJceOutputStream.write(this.album_ids, 2);
    }
    paramJceOutputStream.write(this.last_visit_time, 3);
    if (this.last_feed != null) {
      paramJceOutputStream.write(this.last_feed, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ShareAlbumHelperProtocol.GetMyAlbumListRsp
 * JD-Core Version:    0.7.0.1
 */