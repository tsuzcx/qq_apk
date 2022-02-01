import com.tencent.biz.qqcircle.events.QCircleDoublePraiseAnimationEvent;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.a;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

class pap
  implements QCircleDoubleClickLayout.a
{
  pap(pao parampao) {}
  
  public void biX()
  {
    if (pao.a(this.a) != null)
    {
      String str = pao.a(this.a).id.get();
      int i = pcr.a().getPageId();
      rwv.a().a(new QCircleDoublePraiseAnimationEvent(str, i, pao.a(this.a)));
      QLog.d("QCircleContentHorizontalAdapter", 1, "dispatchEvent id:" + str + " pageType:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pap
 * JD-Core Version:    0.7.0.1
 */