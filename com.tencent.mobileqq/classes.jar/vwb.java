import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;

class vwb
  implements DialogInterface.OnShowListener
{
  vwb(vvz paramvvz, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, vkl paramvkl) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = vvz.a().a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
    this.jdField_a_of_type_Vkl.a(this.jdField_a_of_type_Vkl.a(paramDialogInterface));
    this.jdField_a_of_type_Vkl.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwb
 * JD-Core Version:    0.7.0.1
 */