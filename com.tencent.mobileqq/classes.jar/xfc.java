import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.lang.ref.WeakReference;

public class xfc
  implements xwl
{
  private WeakReference<xfb> a;
  
  public xfc(xfb paramxfb)
  {
    this.a = new WeakReference(paramxfb);
  }
  
  public void a(String paramString, int paramInt)
  {
    ykq.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    xfb localxfb = (xfb)this.a.get();
    if ((localxfb == null) || (paramInt == 1002) || (paramInt == 1003)) {}
    do
    {
      return;
      weg.a(xfb.a(localxfb), 12, paramString);
    } while ((localxfb.a == null) || (localxfb.a.a == null));
    paramInt = ykv.a(localxfb.a.a);
    if (localxfb.a.a.getOwner().isMe()) {}
    for (paramString = "1";; paramString = "2")
    {
      ykv.a("home_page", "clk_reply_nick", paramInt, 0, new String[] { paramString, ykv.a(4444), "", localxfb.a.a.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfc
 * JD-Core Version:    0.7.0.1
 */