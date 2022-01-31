import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.mobileqq.pb.PBStringField;

public class wwt
  extends akdo
{
  public wwt(FollowTextView paramFollowTextView) {}
  
  public void b(boolean paramBoolean, String paramString)
  {
    super.b(paramBoolean, paramString);
    FollowTextView.a(this.a, true);
    if (paramBoolean)
    {
      if (!FollowTextView.a(this.a)) {
        FollowTextView.a(this.a, false, FollowTextView.a(this.a));
      }
      this.a.a(0);
      if (FollowTextView.a(this.a) != null)
      {
        if (FollowTextView.a(this.a) != null) {
          FollowTextView.a(this.a).a(false, FollowTextView.a(this.a));
        }
        wpw.a().a(new FollowUpdateEvent(0, FollowTextView.a(this.a).poster.id.get()));
      }
      return;
    }
    bcpw.a(this.a.getContext(), 2131690662, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wwt
 * JD-Core Version:    0.7.0.1
 */