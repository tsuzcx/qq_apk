import com.tencent.mobileqq.activity.photo.AlbumListAdapter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.LogTag;

public class cjk
  implements Runnable
{
  public cjk(AlbumListAdapter paramAlbumListAdapter) {}
  
  public void run()
  {
    LogTag.a();
    QQAlbumInfo localQQAlbumInfo = this.a.a(AlbumListAdapter.a(this.a), 200, 100, AlbumListAdapter.a(this.a));
    AlbumListAdapter.b(this.a, localQQAlbumInfo);
    LogTag.a("PEAK", "queryRecentBucket");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cjk
 * JD-Core Version:    0.7.0.1
 */