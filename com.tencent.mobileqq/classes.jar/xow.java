import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.lang.ref.WeakReference;

public class xow
  implements ygf
{
  private WeakReference<xov> a;
  
  public xow(xov paramxov)
  {
    this.a = new WeakReference(paramxov);
  }
  
  public void a(String paramString, int paramInt)
  {
    yuk.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    xov localxov = (xov)this.a.get();
    if ((localxov == null) || (paramInt == 1002) || (paramInt == 1003)) {}
    do
    {
      return;
      wnu.a(xov.a(localxov), 12, paramString);
    } while ((localxov.a == null) || (localxov.a.a == null));
    paramInt = yup.a(localxov.a.a);
    if (localxov.a.a.getOwner().isMe()) {}
    for (paramString = "1";; paramString = "2")
    {
      yup.a("home_page", "clk_reply_nick", paramInt, 0, new String[] { paramString, yup.a(4444), "", localxov.a.a.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xow
 * JD-Core Version:    0.7.0.1
 */