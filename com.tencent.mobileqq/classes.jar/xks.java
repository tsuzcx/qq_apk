import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class xks
  extends JobSegment<ycb, ycb>
{
  public xks(xko paramxko) {}
  
  protected void a(JobContext paramJobContext, ycb paramycb)
  {
    paramycb.a(xko.a(this.a).a(paramycb.a.feedId, true), true, true);
    if (paramycb.a()) {
      paramycb.a(xko.a(this.a).a(xko.a(this.a), false), true, false);
    }
    yqp.a("Q.qqstory.player.CommentFloatDialogController", "load feed data from cache: %s.", xko.a(this.a).toString());
    notifyResult(paramycb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xks
 * JD-Core Version:    0.7.0.1
 */