import com.tencent.biz.qqcircle.events.QCircleDoublePraiseAnimationEvent;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

public class par
  implements piz
{
  public par(QCircleContentImage paramQCircleContentImage, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void aWq()
  {
    if (this.c != null)
    {
      String str = this.c.id.get();
      int i = pcr.a().getPageId();
      rwv.a().a(new QCircleDoublePraiseAnimationEvent(str, i, QCircleContentImage.a(this.b)));
      QLog.d("QCircleContentImage", 1, "dispatchEvent id:" + str + " pageType:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     par
 * JD-Core Version:    0.7.0.1
 */