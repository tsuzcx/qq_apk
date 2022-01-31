import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.lang.ref.WeakReference;

public class typ
  implements upy
{
  private WeakReference<tyo> a;
  
  public typ(tyo paramtyo)
  {
    this.a = new WeakReference(paramtyo);
  }
  
  public void a(String paramString, int paramInt)
  {
    ved.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    tyo localtyo = (tyo)this.a.get();
    if ((localtyo == null) || (paramInt == 1002) || (paramInt == 1003)) {}
    do
    {
      return;
      sxm.a(tyo.a(localtyo), 12, paramString);
    } while ((localtyo.a == null) || (localtyo.a.a == null));
    paramInt = vei.a(localtyo.a.a);
    if (localtyo.a.a.getOwner().isMe()) {}
    for (paramString = "1";; paramString = "2")
    {
      vei.a("home_page", "clk_reply_nick", paramInt, 0, new String[] { paramString, vei.a(4444), "", localtyo.a.a.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     typ
 * JD-Core Version:    0.7.0.1
 */