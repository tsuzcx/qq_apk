import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class xon
  extends JobSegment<yfw, yfw>
{
  public xon(xoj paramxoj) {}
  
  protected void a(JobContext paramJobContext, yfw paramyfw)
  {
    paramyfw.a(xoj.a(this.a).a(paramyfw.a.feedId, true), true, true);
    if (paramyfw.a()) {
      paramyfw.a(xoj.a(this.a).a(xoj.a(this.a), false), true, false);
    }
    yuk.a("Q.qqstory.player.CommentFloatDialogController", "load feed data from cache: %s.", xoj.a(this.a).toString());
    notifyResult(paramyfw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xon
 * JD-Core Version:    0.7.0.1
 */