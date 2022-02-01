import android.widget.TextView;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

class ozb
  implements peo.b
{
  ozb(oyu paramoyu, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply) {}
  
  public void onDismiss()
  {
    oyu.a(this.this$0, null);
    if (oyu.a(this.this$0) != null)
    {
      oyu.a(this.this$0).qG("");
      if ((oyu.c(this.this$0)) && (oyu.b(this.this$0) != null)) {
        oyu.b(this.this$0).setText(oyu.a(this.this$0).getText());
      }
      pdp.a().a(oyu.a(this.this$0), this.jdField_f_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_f_of_type_FeedcloudFeedCloudMeta$StReply, oyu.a(this.this$0).getText());
      oyu.a(this.this$0).setText("");
    }
    if ((oyu.d(this.this$0)) && (oyu.a(this.this$0) != 0L))
    {
      oyu.a(this.this$0, false);
      oyu.c(this.this$0, false);
    }
    if (oyu.a(this.this$0) != null) {
      oyu.a(this.this$0).bxM();
    }
    oyu.c(this.this$0, null);
    oyu.b(this.this$0, null);
    oyu.b(this.this$0, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ozb
 * JD-Core Version:    0.7.0.1
 */