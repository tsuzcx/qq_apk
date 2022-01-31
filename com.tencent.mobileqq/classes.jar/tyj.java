import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class tyj
  extends JobSegment<ups, ups>
{
  public tyj(tyf paramtyf) {}
  
  protected void a(JobContext paramJobContext, ups paramups)
  {
    paramups.a(tyf.a(this.a).a(paramups.a.feedId, true), true, true);
    if (paramups.a()) {
      paramups.a(tyf.a(this.a).a(tyf.a(this.a), false), true, false);
    }
    veg.a("Q.qqstory.player.CommentFloatDialogController", "load feed data from cache: %s.", tyf.a(this.a).toString());
    notifyResult(paramups);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyj
 * JD-Core Version:    0.7.0.1
 */