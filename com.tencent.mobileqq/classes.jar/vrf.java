import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader.PicDownLoadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class vrf
  implements RejectedExecutionHandler
{
  public vrf(QCircleFeedPicLoader paramQCircleFeedPicLoader) {}
  
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    QLog.d(QCircleFeedPicLoader.a, 4, "seq = " + ((QCircleFeedPicLoader.PicDownLoadTask)paramRunnable).a().a() + " reject task");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrf
 * JD-Core Version:    0.7.0.1
 */