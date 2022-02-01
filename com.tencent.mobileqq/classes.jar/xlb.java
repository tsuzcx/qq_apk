import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.lang.ref.WeakReference;

public class xlb
  implements yck
{
  private WeakReference<xla> a;
  
  public xlb(xla paramxla)
  {
    this.a = new WeakReference(paramxla);
  }
  
  public void a(String paramString, int paramInt)
  {
    yqp.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    xla localxla = (xla)this.a.get();
    if ((localxla == null) || (paramInt == 1002) || (paramInt == 1003)) {}
    do
    {
      return;
      wjz.a(xla.a(localxla), 12, paramString);
    } while ((localxla.a == null) || (localxla.a.a == null));
    paramInt = yqu.a(localxla.a.a);
    if (localxla.a.a.getOwner().isMe()) {}
    for (paramString = "1";; paramString = "2")
    {
      yqu.a("home_page", "clk_reply_nick", paramInt, 0, new String[] { paramString, yqu.a(4444), "", localxla.a.a.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlb
 * JD-Core Version:    0.7.0.1
 */