import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

class voz
  implements vwd
{
  voz(vow paramvow) {}
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    QLog.d("QCircleReplyMessagePresenter", 1, "addFakeComment stComment" + paramStComment.id.get());
  }
  
  public void a(FeedCloudMeta.StReply paramStReply)
  {
    QLog.d("QCircleReplyMessagePresenter", 1, "addFakeReply stReply" + paramStReply.id.get());
    vba localvba = vow.a(this.a);
    if (localvba != null)
    {
      if (this.a.a != 1) {
        break label140;
      }
      vow.a(this.a, localvba, 7);
    }
    for (;;)
    {
      localvba.a = paramStReply;
      paramStReply = vow.a(this.a);
      if (TextUtils.isEmpty(paramStReply)) {
        break;
      }
      QLog.d("QCircleReplyMessagePresenter", 1, "getFakeReplysKey" + paramStReply);
      paramStReply = vvz.a().a(paramStReply, localvba);
      vow.a(this.a).a(paramStReply);
      vow.a(this.a).notifyDataSetChanged();
      return;
      label140:
      if (this.a.a == 2) {
        vow.a(this.a, localvba, 11);
      }
    }
    QLog.d("QCircleReplyMessagePresenter", 1, "getFakeReplysKey error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     voz
 * JD-Core Version:    0.7.0.1
 */