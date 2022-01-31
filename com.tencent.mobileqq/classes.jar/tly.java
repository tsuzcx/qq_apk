import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class tly
  extends ulp
{
  public tly(tlv paramtlv) {}
  
  public void a(int paramInt, View paramView, Object paramObject, unw paramunw)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(tlv.a(this.a)).size())) {}
    do
    {
      return;
      paramObject = (CommentEntry)this.a.a.a(tlv.a(this.a)).get(paramInt);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
    skt.a(paramView.getContext(), 12, paramObject.authorUnionId);
    return;
    if (tlv.a(this.a) != null) {
      tlv.a(this.a).a(paramObject, paramInt, tlv.a(this.a).a());
    }
    tlv.a(this.a).a(tlv.a(this.a).a());
  }
  
  public void b(int paramInt, View paramView, Object paramObject, unw paramunw)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(tlv.a(this.a)).size())) {
      return;
    }
    paramObject = (CommentEntry)this.a.a.a(tlv.a(this.a)).get(paramInt);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298910: 
      paramView = tlv.a(this.a).a();
      if ((paramView != null) && (paramView.a != null)) {
        if (!paramView.a.getOwner().isMe()) {
          break label194;
        }
      }
      label194:
      for (paramView = "2";; paramView = "1")
      {
        urp.a("home_page", "press_reply", 0, 0, new String[] { paramView, urp.a(tlv.a(this.a)) });
        if (tlv.a(this.a) == null) {
          break;
        }
        tlv.a(this.a).b(paramObject, paramInt, tlv.a(this.a).a());
        return;
      }
    }
    tlv.a(this.a).a(tlv.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tly
 * JD-Core Version:    0.7.0.1
 */