import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class ouk
  implements RejectedExecutionHandler
{
  public ouk(QCircleFeedPicLoader paramQCircleFeedPicLoader) {}
  
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    QLog.d(QCircleFeedPicLoader.TAG, 4, "reject decode");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ouk
 * JD-Core Version:    0.7.0.1
 */