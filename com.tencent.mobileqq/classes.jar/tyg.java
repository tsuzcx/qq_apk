import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class tyg
  extends JobSegment<upp, upp>
{
  public tyg(tyc paramtyc) {}
  
  protected void a(JobContext paramJobContext, upp paramupp)
  {
    paramupp.a(tyc.a(this.a).a(paramupp.a.feedId, true), true, true);
    if (paramupp.a()) {
      paramupp.a(tyc.a(this.a).a(tyc.a(this.a), false), true, false);
    }
    ved.a("Q.qqstory.player.CommentFloatDialogController", "load feed data from cache: %s.", tyc.a(this.a).toString());
    notifyResult(paramupp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyg
 * JD-Core Version:    0.7.0.1
 */