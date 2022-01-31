import android.annotation.TargetApi;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import com.tencent.biz.qqstory.base.preload.PreloadQueue;
import java.util.List;

@TargetApi(14)
public class unw
  implements unv
{
  public unw(unu paramunu) {}
  
  public void a(int paramInt)
  {
    int i = paramInt + 1;
    if (i < this.a.jdField_a_of_type_JavaUtilList.size())
    {
      PreloadQueue localPreloadQueue = (PreloadQueue)this.a.jdField_a_of_type_JavaUtilList.get(i);
      wxe.b("Q.qqstory.download.preload.PreloadDownloaderManager", "queue " + paramInt + " download completed , turn to " + localPreloadQueue.getId());
      this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(localPreloadQueue);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     unw
 * JD-Core Version:    0.7.0.1
 */