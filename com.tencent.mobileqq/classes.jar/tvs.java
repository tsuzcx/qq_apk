import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class tvs
  implements tqy
{
  tvs(tvj paramtvj, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    Object localObject;
    if (paramInt == tqz.c)
    {
      localObject = (ClipboardManager)tuz.c(this.jdField_a_of_type_Tvj.a).getSystemService("clipboard");
      if (localObject != null) {
        ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.content.get()));
      }
    }
    while (paramInt != tqz.e) {
      return;
    }
    if (tra.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get())) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = tuz.d(this.jdField_a_of_type_Tvj.a).getString(2131698379);
      bdgm.a(tuz.e(this.jdField_a_of_type_Tvj.a), 230, (String)localObject, null, 2131690648, 2131690626, new tvt(this, paramInt), new tvu(this)).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvs
 * JD-Core Version:    0.7.0.1
 */