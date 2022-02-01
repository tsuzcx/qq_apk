import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;

class pdr
  implements DialogInterface.OnShowListener
{
  pdr(pdp parampdp, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = pdp.a().b(this.j, this.jdField_f_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_f_of_type_FeedcloudFeedCloudMeta$StReply);
    pdp.a(this.b).setText(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdr
 * JD-Core Version:    0.7.0.1
 */