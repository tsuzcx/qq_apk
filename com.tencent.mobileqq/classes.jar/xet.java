import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class xet
  extends JobSegment<xwc, xwc>
{
  public xet(xep paramxep) {}
  
  protected void a(JobContext paramJobContext, xwc paramxwc)
  {
    paramxwc.a(xep.a(this.a).a(paramxwc.a.feedId, true), true, true);
    if (paramxwc.a()) {
      paramxwc.a(xep.a(this.a).a(xep.a(this.a), false), true, false);
    }
    ykq.a("Q.qqstory.player.CommentFloatDialogController", "load feed data from cache: %s.", xep.a(this.a).toString());
    notifyResult(paramxwc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xet
 * JD-Core Version:    0.7.0.1
 */