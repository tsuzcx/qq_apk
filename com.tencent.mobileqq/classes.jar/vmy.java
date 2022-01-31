import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class vmy
  extends JobSegment<weh, weh>
{
  public vmy(vmu paramvmu) {}
  
  protected void a(JobContext paramJobContext, weh paramweh)
  {
    paramweh.a(vmu.a(this.a).a(paramweh.a.feedId, true), true, true);
    if (paramweh.a()) {
      paramweh.a(vmu.a(this.a).a(vmu.a(this.a), false), true, false);
    }
    wsv.a("Q.qqstory.player.CommentFloatDialogController", "load feed data from cache: %s.", vmu.a(this.a).toString());
    notifyResult(paramweh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmy
 * JD-Core Version:    0.7.0.1
 */