import com.tencent.mobileqq.activity.photo.AlbumListAdapter;
import com.tencent.mobileqq.utils.LogTag;

public class cic
  implements Runnable
{
  public cic(AlbumListAdapter paramAlbumListAdapter) {}
  
  public void run()
  {
    LogTag.a();
    AlbumListAdapter.a(this.a);
    LogTag.a("PEAK", "queryAllAlbumList");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cic
 * JD-Core Version:    0.7.0.1
 */