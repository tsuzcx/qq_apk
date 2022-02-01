import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;

class vtf
  implements DialogInterface.OnShowListener
{
  vtf(vtd paramvtd, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = vtd.a().a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
    vtd.a(this.jdField_a_of_type_Vtd).a(vtd.a(this.jdField_a_of_type_Vtd).a(paramDialogInterface));
    vtd.a(this.jdField_a_of_type_Vtd).a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtf
 * JD-Core Version:    0.7.0.1
 */