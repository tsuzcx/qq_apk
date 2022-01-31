import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class vrh
  extends JobSegment<wiq, wiq>
{
  public vrh(vrd paramvrd) {}
  
  protected void a(JobContext paramJobContext, wiq paramwiq)
  {
    paramwiq.a(vrd.a(this.a).a(paramwiq.a.feedId, true), true, true);
    if (paramwiq.a()) {
      paramwiq.a(vrd.a(this.a).a(vrd.a(this.a), false), true, false);
    }
    wxe.a("Q.qqstory.player.CommentFloatDialogController", "load feed data from cache: %s.", vrd.a(this.a).toString());
    notifyResult(paramwiq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vrh
 * JD-Core Version:    0.7.0.1
 */