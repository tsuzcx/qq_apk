import com.dataline.mpfile.LiteMpFileDownloadActivity;
import com.dataline.mpfile.LiteMpFileDownloadActivity.SortComparator;
import com.dataline.mpfile.MpfileDataCenter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Collections;
import java.util.Comparator;

public class bz
  implements Runnable
{
  public bz(LiteMpFileDownloadActivity paramLiteMpFileDownloadActivity) {}
  
  public void run()
  {
    Object localObject = (DataLineHandler)this.a.app.a(8);
    LiteMpFileDownloadActivity.a(this.a, ((DataLineHandler)localObject).a().a());
    localObject = new LiteMpFileDownloadActivity.SortComparator(this.a);
    Collections.sort(LiteMpFileDownloadActivity.a(this.a), (Comparator)localObject);
    this.a.runOnUiThread(new ca(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bz
 * JD-Core Version:    0.7.0.1
 */