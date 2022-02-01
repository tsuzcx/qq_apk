import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.PicDownLoadTask;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.b;
import java.util.Comparator;

public class ouh
  implements Comparator<Runnable>
{
  public ouh(QCircleFeedPicLoader paramQCircleFeedPicLoader) {}
  
  public int compare(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    if (((paramRunnable1 instanceof QCircleFeedPicLoader.PicDownLoadTask)) && ((paramRunnable2 instanceof QCircleFeedPicLoader.PicDownLoadTask))) {
      return ((QCircleFeedPicLoader.PicDownLoadTask)paramRunnable1).a().getPriority() - ((QCircleFeedPicLoader.PicDownLoadTask)paramRunnable2).a().getPriority();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ouh
 * JD-Core Version:    0.7.0.1
 */