import com.tencent.mobileqq.app.DiscussionIconHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class csg
  implements Runnable
{
  public csg(DiscussionIconHelper paramDiscussionIconHelper) {}
  
  public void run()
  {
    long l = DeviceInfoUtil.a();
    int i = DeviceInfoUtil.b();
    if ((l != 0L) && (l < 1024L) && (i <= 1)) {
      DiscussionIconHelper.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     csg
 * JD-Core Version:    0.7.0.1
 */