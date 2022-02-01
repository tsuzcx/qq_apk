import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.b;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.c;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.1;
import java.util.concurrent.ConcurrentHashMap;

public class pdb
  extends QCircleFeedPicLoader.c
{
  public pdb(QCircleFeedPicPreloadScroller.1 param1) {}
  
  public void a(int paramInt, QCircleFeedPicLoader.b paramb)
  {
    if ((paramInt == QCircleFeedPicLoader.STATE_SUCCESS) || (paramInt == QCircleFeedPicLoader.bgi)) {
      pda.a(this.a.this$0).put(paramb.getCacheKey(), Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdb
 * JD-Core Version:    0.7.0.1
 */