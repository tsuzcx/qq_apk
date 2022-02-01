import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class ozk
  implements ouy.a
{
  ozk(oyu.c paramc, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StComment paramStComment) {}
  
  public void onClick(int paramInt)
  {
    Object localObject;
    if (paramInt == ouy.b.bgr)
    {
      localObject = (ClipboardManager)oyu.c(this.b.this$0).getSystemService("clipboard");
      if (localObject != null)
      {
        localClipData = ClipData.newPlainText("", this.jdField_g_of_type_FeedcloudFeedCloudMeta$StReply.content.get());
        alkw.a((ClipboardManager)localObject, localClipData);
        ((ClipboardManager)localObject).setPrimaryClip(localClipData);
      }
    }
    while (paramInt != ouy.b.bgt)
    {
      ClipData localClipData;
      return;
    }
    if (ovd.a((FeedCloudMeta.StUser)this.jdField_g_of_type_FeedcloudFeedCloudMeta$StReply.postUser.get())) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = oyu.d(this.b.this$0).getString(2131700170);
      aqha.a(oyu.e(this.b.this$0), 230, (String)localObject, null, 2131721058, 2131691042, new ozl(this, paramInt), new ozm(this)).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ozk
 * JD-Core Version:    0.7.0.1
 */