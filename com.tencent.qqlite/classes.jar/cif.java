import com.tencent.mobileqq.activity.photo.AlbumListAdapter;
import com.tencent.mobileqq.utils.LogTag;

public class cif
  implements Runnable
{
  public cif(AlbumListAdapter paramAlbumListAdapter) {}
  
  public void run()
  {
    LogTag.a();
    AlbumListAdapter.a(this.a, 100);
    LogTag.a("PEAK", "queryAlbumList");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cif
 * JD-Core Version:    0.7.0.1
 */