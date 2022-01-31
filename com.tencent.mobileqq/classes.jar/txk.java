import com.tencent.biz.qqcircle.events.QCircleDoublePraiseAnimationEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

class txk
  implements ucr
{
  txk(txj paramtxj) {}
  
  public void a()
  {
    if (txj.a(this.a) != null)
    {
      String str = txj.a(this.a).id.get();
      int i = tzy.a().a();
      yiw.a().a(new QCircleDoublePraiseAnimationEvent(str, i, txj.a(this.a)));
      QLog.d("QCircleContentHorizontalAdapter", 1, "dispatchEvent id:" + str + " pageType:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txk
 * JD-Core Version:    0.7.0.1
 */