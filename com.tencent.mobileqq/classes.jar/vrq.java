import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.lang.ref.WeakReference;

public class vrq
  implements wiz
{
  private WeakReference<vrp> a;
  
  public vrq(vrp paramvrp)
  {
    this.a = new WeakReference(paramvrp);
  }
  
  public void a(String paramString, int paramInt)
  {
    wxe.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    vrp localvrp = (vrp)this.a.get();
    if ((localvrp == null) || (paramInt == 1002) || (paramInt == 1003)) {}
    do
    {
      return;
      uqn.a(vrp.a(localvrp), 12, paramString);
    } while ((localvrp.a == null) || (localvrp.a.a == null));
    paramInt = wxj.a(localvrp.a.a);
    if (localvrp.a.a.getOwner().isMe()) {}
    for (paramString = "1";; paramString = "2")
    {
      wxj.a("home_page", "clk_reply_nick", paramInt, 0, new String[] { paramString, wxj.a(4444), "", localvrp.a.a.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vrq
 * JD-Core Version:    0.7.0.1
 */