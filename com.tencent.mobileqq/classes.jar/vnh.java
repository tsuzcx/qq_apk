import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.lang.ref.WeakReference;

public class vnh
  implements weq
{
  private WeakReference<vng> a;
  
  public vnh(vng paramvng)
  {
    this.a = new WeakReference(paramvng);
  }
  
  public void a(String paramString, int paramInt)
  {
    wsv.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    vng localvng = (vng)this.a.get();
    if ((localvng == null) || (paramInt == 1002) || (paramInt == 1003)) {}
    do
    {
      return;
      ume.a(vng.a(localvng), 12, paramString);
    } while ((localvng.a == null) || (localvng.a.a == null));
    paramInt = wta.a(localvng.a.a);
    if (localvng.a.a.getOwner().isMe()) {}
    for (paramString = "1";; paramString = "2")
    {
      wta.a("home_page", "clk_reply_nick", paramInt, 0, new String[] { paramString, wta.a(4444), "", localvng.a.a.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vnh
 * JD-Core Version:    0.7.0.1
 */