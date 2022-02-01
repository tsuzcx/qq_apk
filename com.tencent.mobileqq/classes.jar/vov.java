import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader.PicDownLoadTask;
import java.util.Comparator;

public class vov
  implements Comparator<Runnable>
{
  public vov(QCircleFeedPicLoader paramQCircleFeedPicLoader) {}
  
  public int a(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    if (((paramRunnable1 instanceof QCircleFeedPicLoader.PicDownLoadTask)) && ((paramRunnable2 instanceof QCircleFeedPicLoader.PicDownLoadTask))) {
      return ((QCircleFeedPicLoader.PicDownLoadTask)paramRunnable1).a().d() - ((QCircleFeedPicLoader.PicDownLoadTask)paramRunnable2).a().d();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vov
 * JD-Core Version:    0.7.0.1
 */