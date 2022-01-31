import com.dataline.mpfile.LiteMpFileFileListActivity;
import com.dataline.mpfile.MpfileDataCenter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class db
  implements Runnable
{
  public db(LiteMpFileFileListActivity paramLiteMpFileFileListActivity) {}
  
  public void run()
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)((QQAppInterface)this.a.getAppRuntime()).a(8);
    LiteMpFileFileListActivity.a(this.a, localDataLineHandler.a().a(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     db
 * JD-Core Version:    0.7.0.1
 */