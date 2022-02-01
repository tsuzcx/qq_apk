import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class oui
  implements RejectedExecutionHandler
{
  public oui(QCircleFeedPicLoader paramQCircleFeedPicLoader) {}
  
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    QLog.d(QCircleFeedPicLoader.TAG, 4, "reject download");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oui
 * JD-Core Version:    0.7.0.1
 */