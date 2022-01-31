import com.tencent.mobileqq.activity.photo.AlbumListAdapter;
import com.tencent.mobileqq.utils.LogTag;

public class chz
  implements Runnable
{
  public chz(AlbumListAdapter paramAlbumListAdapter) {}
  
  public void run()
  {
    LogTag.a();
    AlbumListAdapter.a(this.a, 100);
    LogTag.a("PEAK", "queryAlbumList");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     chz
 * JD-Core Version:    0.7.0.1
 */