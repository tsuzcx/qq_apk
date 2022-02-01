import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class wpy
  extends JobSegment<xhh, xhh>
{
  public wpy(wpu paramwpu) {}
  
  protected void a(JobContext paramJobContext, xhh paramxhh)
  {
    paramxhh.a(wpu.a(this.a).a(paramxhh.a.feedId, true), true, true);
    if (paramxhh.a()) {
      paramxhh.a(wpu.a(this.a).a(wpu.a(this.a), false), true, false);
    }
    xvv.a("Q.qqstory.player.CommentFloatDialogController", "load feed data from cache: %s.", wpu.a(this.a).toString());
    notifyResult(paramxhh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpy
 * JD-Core Version:    0.7.0.1
 */