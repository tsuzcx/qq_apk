import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.lang.ref.WeakReference;

public class tlw
  implements udf
{
  private WeakReference<tlv> a;
  
  public tlw(tlv paramtlv)
  {
    this.a = new WeakReference(paramtlv);
  }
  
  public void a(String paramString, int paramInt)
  {
    urk.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    tlv localtlv = (tlv)this.a.get();
    if ((localtlv == null) || (paramInt == 1002) || (paramInt == 1003)) {}
    do
    {
      return;
      skt.a(tlv.a(localtlv), 12, paramString);
    } while ((localtlv.a == null) || (localtlv.a.a == null));
    paramInt = urp.a(localtlv.a.a);
    if (localtlv.a.a.getOwner().isMe()) {}
    for (paramString = "1";; paramString = "2")
    {
      urp.a("home_page", "clk_reply_nick", paramInt, 0, new String[] { paramString, urp.a(4444), "", localtlv.a.a.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlw
 * JD-Core Version:    0.7.0.1
 */