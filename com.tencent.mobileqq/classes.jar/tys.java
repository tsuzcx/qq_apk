import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.lang.ref.WeakReference;

public class tys
  implements uqb
{
  private WeakReference<tyr> a;
  
  public tys(tyr paramtyr)
  {
    this.a = new WeakReference(paramtyr);
  }
  
  public void a(String paramString, int paramInt)
  {
    veg.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    tyr localtyr = (tyr)this.a.get();
    if ((localtyr == null) || (paramInt == 1002) || (paramInt == 1003)) {}
    do
    {
      return;
      sxp.a(tyr.a(localtyr), 12, paramString);
    } while ((localtyr.a == null) || (localtyr.a.a == null));
    paramInt = vel.a(localtyr.a.a);
    if (localtyr.a.a.getOwner().isMe()) {}
    for (paramString = "1";; paramString = "2")
    {
      vel.a("home_page", "clk_reply_nick", paramInt, 0, new String[] { paramString, vel.a(4444), "", localtyr.a.a.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tys
 * JD-Core Version:    0.7.0.1
 */