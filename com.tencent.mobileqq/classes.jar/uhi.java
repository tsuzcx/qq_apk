import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

class uhi
  implements ubb
{
  uhi(uhf paramuhf) {}
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    QLog.d("QCircleReplyMessagePresenter", 1, "addFakeComment stComment" + paramStComment.id.get());
  }
  
  public void a(FeedCloudMeta.StReply paramStReply)
  {
    QLog.d("QCircleReplyMessagePresenter", 1, "addFakeReply stReply" + paramStReply.id.get());
    trx localtrx = uhf.a(this.a);
    if (localtrx != null)
    {
      if (this.a.a != 1) {
        break label140;
      }
      uhf.a(this.a, localtrx, 7);
    }
    for (;;)
    {
      localtrx.a = paramStReply;
      paramStReply = uhf.a(this.a);
      if (TextUtils.isEmpty(paramStReply)) {
        break;
      }
      QLog.d("QCircleReplyMessagePresenter", 1, "getFakeReplysKey" + paramStReply);
      paramStReply = uax.a().a(paramStReply, localtrx);
      uhf.a(this.a).a(paramStReply);
      uhf.a(this.a).notifyDataSetChanged();
      return;
      label140:
      if (this.a.a == 2) {
        uhf.a(this.a, localtrx, 11);
      }
    }
    QLog.d("QCircleReplyMessagePresenter", 1, "getFakeReplysKey error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhi
 * JD-Core Version:    0.7.0.1
 */