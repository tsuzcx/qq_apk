import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.PackageUtil;

public class ujq
  implements Runnable
{
  public ujq(AppGuideTipsManager paramAppGuideTipsManager) {}
  
  public void run()
  {
    AppGuideTipsManager.b(this.a, PackageUtil.a(AppGuideTipsManager.a(this.a).getApp(), "com.tencent.tim"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujq
 * JD-Core Version:    0.7.0.1
 */