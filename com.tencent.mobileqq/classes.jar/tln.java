import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class tln
  extends JobSegment<ucw, ucw>
{
  public tln(tlj paramtlj) {}
  
  protected void a(JobContext paramJobContext, ucw paramucw)
  {
    paramucw.a(tlj.a(this.a).a(paramucw.a.feedId, true), true, true);
    if (paramucw.a()) {
      paramucw.a(tlj.a(this.a).a(tlj.a(this.a), false), true, false);
    }
    urk.a("Q.qqstory.player.CommentFloatDialogController", "load feed data from cache: %s.", tlj.a(this.a).toString());
    notifyResult(paramucw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tln
 * JD-Core Version:    0.7.0.1
 */