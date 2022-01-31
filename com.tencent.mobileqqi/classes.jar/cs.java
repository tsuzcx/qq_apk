import com.dataline.mpfile.LiteMpFileDownloadActivity;
import com.dataline.mpfile.LiteMpFileDownloadActivity.SortComparator;
import com.dataline.mpfile.MpfileDataCenter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Collections;
import java.util.Comparator;

public class cs
  implements Runnable
{
  public cs(LiteMpFileDownloadActivity paramLiteMpFileDownloadActivity) {}
  
  public void run()
  {
    Object localObject = (DataLineHandler)this.a.b.a(8);
    LiteMpFileDownloadActivity.a(this.a, ((DataLineHandler)localObject).a().a());
    localObject = new LiteMpFileDownloadActivity.SortComparator(this.a);
    Collections.sort(LiteMpFileDownloadActivity.a(this.a), (Comparator)localObject);
    this.a.runOnUiThread(new ct(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     cs
 * JD-Core Version:    0.7.0.1
 */