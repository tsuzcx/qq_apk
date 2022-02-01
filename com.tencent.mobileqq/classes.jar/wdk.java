import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

class wdk
  implements uze
{
  wdk(wdg paramwdg, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a(int paramInt)
  {
    if (paramInt == uzf.c)
    {
      ClipboardManager localClipboardManager = (ClipboardManager)this.jdField_a_of_type_Wdg.a.getContext().getSystemService("clipboard");
      if (localClipboardManager != null) {
        localClipboardManager.setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.content.get()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdk
 * JD-Core Version:    0.7.0.1
 */