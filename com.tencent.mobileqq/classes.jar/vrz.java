import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class vrz
  extends voy
{
  public vrz(QCircleFeedPicPreloadScroller.2 param2) {}
  
  public void a(int paramInt, vou paramvou)
  {
    if ((paramInt == QCircleFeedPicLoader.f) || (paramInt == QCircleFeedPicLoader.c))
    {
      vrx.a(this.a.this$0).put(paramvou.b(), Boolean.valueOf(true));
      QLog.d(vrx.a, 4, "preload time lin pic success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrz
 * JD-Core Version:    0.7.0.1
 */