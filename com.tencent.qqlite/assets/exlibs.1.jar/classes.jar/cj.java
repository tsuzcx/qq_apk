import com.dataline.mpfile.LiteMpFileFileListActivity;
import com.dataline.mpfile.MpfileDataCenter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class cj
  implements Runnable
{
  public cj(LiteMpFileFileListActivity paramLiteMpFileFileListActivity) {}
  
  public void run()
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)((QQAppInterface)this.a.getAppRuntime()).a(8);
    LiteMpFileFileListActivity.a(this.a, localDataLineHandler.a().a(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cj
 * JD-Core Version:    0.7.0.1
 */