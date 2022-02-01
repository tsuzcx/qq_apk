import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.lang.ref.WeakReference;

public class wqh
  implements xhq
{
  private WeakReference<wqg> a;
  
  public wqh(wqg paramwqg)
  {
    this.a = new WeakReference(paramwqg);
  }
  
  public void a(String paramString, int paramInt)
  {
    xvv.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    wqg localwqg = (wqg)this.a.get();
    if ((localwqg == null) || (paramInt == 1002) || (paramInt == 1003)) {}
    do
    {
      return;
      vpl.a(wqg.a(localwqg), 12, paramString);
    } while ((localwqg.a == null) || (localwqg.a.a == null));
    paramInt = xwa.a(localwqg.a.a);
    if (localwqg.a.a.getOwner().isMe()) {}
    for (paramString = "1";; paramString = "2")
    {
      xwa.a("home_page", "clk_reply_nick", paramInt, 0, new String[] { paramString, xwa.a(4444), "", localwqg.a.a.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqh
 * JD-Core Version:    0.7.0.1
 */