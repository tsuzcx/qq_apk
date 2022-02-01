import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

class pir
  implements pdp.a
{
  pir(pio parampio) {}
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    QLog.d("QCircleReplyMessagePresenter", 1, "addFakeComment stComment" + paramStComment.id.get());
  }
  
  public void a(FeedCloudMeta.StReply paramStReply)
  {
    QLog.d("QCircleReplyMessagePresenter", 1, "addFakeReply stReply" + paramStReply.id.get());
    ovx localovx = pio.a(this.b);
    if (localovx != null)
    {
      if (this.b.mViewType != 1) {
        break label140;
      }
      pio.a(this.b, localovx, 7);
    }
    for (;;)
    {
      localovx.a = paramStReply;
      paramStReply = pio.a(this.b);
      if (TextUtils.isEmpty(paramStReply)) {
        break;
      }
      QLog.d("QCircleReplyMessagePresenter", 1, "getFakeReplysKey" + paramStReply);
      paramStReply = pdp.a().a(paramStReply, localovx);
      pio.a(this.b).bF(paramStReply);
      pio.a(this.b).notifyDataSetChanged();
      return;
      label140:
      if (this.b.mViewType == 2) {
        pio.a(this.b, localovx, 11);
      }
    }
    QLog.d("QCircleReplyMessagePresenter", 1, "getFakeReplysKey error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pir
 * JD-Core Version:    0.7.0.1
 */