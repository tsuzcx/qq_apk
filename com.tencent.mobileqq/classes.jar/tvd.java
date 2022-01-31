import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class tvd
  implements tqy
{
  tvd(tuu paramtuu, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    Object localObject;
    if (paramInt == tqz.c)
    {
      localObject = (ClipboardManager)tuk.c(this.jdField_a_of_type_Tuu.a).getSystemService("clipboard");
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
      localObject = tuk.d(this.jdField_a_of_type_Tuu.a).getString(2131698367);
      bdcd.a(tuk.e(this.jdField_a_of_type_Tuu.a), 230, (String)localObject, null, 2131690648, 2131690626, new tve(this, paramInt), new tvf(this)).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvd
 * JD-Core Version:    0.7.0.1
 */