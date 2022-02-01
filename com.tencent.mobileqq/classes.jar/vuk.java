import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class vuk
  extends vrh
{
  public vuk(QCircleFeedPicPreloadScroller.1 param1) {}
  
  public void a(int paramInt, vrd paramvrd)
  {
    if ((paramInt == QCircleFeedPicLoader.f) || (paramInt == QCircleFeedPicLoader.c))
    {
      vuj.a(this.a.this$0).put(paramvrd.b(), Boolean.valueOf(true));
      QLog.d(vuj.a, 4, "preload time lin video success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vuk
 * JD-Core Version:    0.7.0.1
 */