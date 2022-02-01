import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView.a;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

public class pfw
  implements rxc.a<FeedCloudWrite.StDoFollowRsp>
{
  public pfw(QCircleFollowView paramQCircleFollowView, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    boolean bool = true;
    QLog.d("QCircleFollowView", 1, "doFollow: isSuccess" + paramBoolean + "retCode:" + paramLong + "    errMsg:" + paramString);
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (!QCircleFollowView.a(this.this$0)) {}
      this.this$0.an(this.bio, true);
      if ((QCircleFollowView.b(this.this$0)) && (this.bio == 1)) {
        QQToast.a(this.this$0.getContext(), 2, 2131700110, 0).show();
      }
      if (this.bio == 1) {
        rwv.a().a(new QCircleFuelAnimationEvent());
      }
      if (QCircleFollowView.a(this.this$0) != null)
      {
        if (QCircleFollowView.a(this.this$0) != null) {
          QCircleFollowView.a(this.this$0).a(true, QCircleFollowView.a(this.this$0));
        }
        rwv.a().a(new QCircleFollowUpdateEvent(this.bio, QCircleFollowView.a(this.this$0).id.get()));
        QCircleFollowView.h(this.this$0.getContext(), QCircleFollowView.a(this.this$0).id.get(), this.bio);
        paramString = pbu.a();
        paramStDoFollowRsp = QCircleFollowView.a(this.this$0).id.get();
        if (this.bio != 1) {
          break label273;
        }
      }
      label273:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramString.setUinFollowed(paramStDoFollowRsp, paramBoolean);
        return;
      }
    }
    paramString = this.this$0.getContext();
    if (this.tT) {}
    for (int i = 2131700109;; i = 2131700184)
    {
      QQToast.a(paramString, 1, i, 0).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pfw
 * JD-Core Version:    0.7.0.1
 */