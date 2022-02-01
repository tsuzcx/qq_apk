import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

class oza
  implements DialogInterface.OnShowListener
{
  oza(oyu paramoyu, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (oyu.a(this.this$0) != null) {
      oyu.a(this.this$0).a(paramDialogInterface);
    }
    paramDialogInterface = pdp.a().b(oyu.a(this.this$0), this.jdField_f_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_f_of_type_FeedcloudFeedCloudMeta$StReply);
    oyu.a(this.this$0).setText(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oza
 * JD-Core Version:    0.7.0.1
 */