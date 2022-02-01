import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;

class pds
  implements peo.b
{
  pds(pdp parampdp, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply) {}
  
  public void onDismiss()
  {
    if (pdp.a(this.b) != null)
    {
      pdp.a(this.b).qG("");
      pdp.a().a(this.j, this.jdField_f_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_f_of_type_FeedcloudFeedCloudMeta$StReply, pdp.a(this.b).getText());
      pdp.a(this.b).setText("");
    }
    pdp.a(this.b, null);
    pdp.a(this.b, null);
    pdp.a(this.b).qG(this.b.b(null, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pds
 * JD-Core Version:    0.7.0.1
 */