import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

class vmv
  implements vth
{
  vmv(vms paramvms) {}
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    QLog.d("QCircleReplyMessagePresenter", 1, "addFakeComment stComment" + paramStComment.id.get());
  }
  
  public void a(FeedCloudMeta.StReply paramStReply)
  {
    QLog.d("QCircleReplyMessagePresenter", 1, "addFakeReply stReply" + paramStReply.id.get());
    uzk localuzk = vms.a(this.a);
    if (localuzk != null)
    {
      if (this.a.a != 1) {
        break label140;
      }
      vms.a(this.a, localuzk, 7);
    }
    for (;;)
    {
      localuzk.a = paramStReply;
      paramStReply = vms.a(this.a);
      if (TextUtils.isEmpty(paramStReply)) {
        break;
      }
      QLog.d("QCircleReplyMessagePresenter", 1, "getFakeReplysKey" + paramStReply);
      paramStReply = vtd.a().a(paramStReply, localuzk);
      vms.a(this.a).a(paramStReply);
      vms.a(this.a).notifyDataSetChanged();
      return;
      label140:
      if (this.a.a == 2) {
        vms.a(this.a, localuzk, 11);
      }
    }
    QLog.d("QCircleReplyMessagePresenter", 1, "getFakeReplysKey error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmv
 * JD-Core Version:    0.7.0.1
 */