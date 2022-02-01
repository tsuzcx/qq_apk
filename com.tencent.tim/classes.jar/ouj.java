import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.PicDeCodeTask;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.b;
import java.util.Comparator;

public class ouj
  implements Comparator<Runnable>
{
  public ouj(QCircleFeedPicLoader paramQCircleFeedPicLoader) {}
  
  public int compare(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    if (((paramRunnable1 instanceof QCircleFeedPicLoader.PicDeCodeTask)) && ((paramRunnable2 instanceof QCircleFeedPicLoader.PicDeCodeTask))) {
      return ((QCircleFeedPicLoader.PicDeCodeTask)paramRunnable1).a().getPriority() - ((QCircleFeedPicLoader.PicDeCodeTask)paramRunnable2).a().getPriority();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ouj
 * JD-Core Version:    0.7.0.1
 */