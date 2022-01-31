import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.mobileqq.pb.PBStringField;

public class whq
  extends ajpe
{
  public whq(FollowTextView paramFollowTextView) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    FollowTextView.a(this.a, true);
    if (paramBoolean)
    {
      if (!FollowTextView.a(this.a)) {
        FollowTextView.a(this.a, true, FollowTextView.a(this.a));
      }
      this.a.a(1);
      if (FollowTextView.a(this.a) != null)
      {
        if (FollowTextView.a(this.a) != null) {
          FollowTextView.a(this.a).a(true, FollowTextView.a(this.a));
        }
        wcj.a().a(new FollowUpdateEvent(1, FollowTextView.a(this.a).poster.id.get()));
      }
      return;
    }
    bbmy.a(this.a.getContext(), 2131625092, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     whq
 * JD-Core Version:    0.7.0.1
 */