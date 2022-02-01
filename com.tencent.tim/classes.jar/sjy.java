import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView.a;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

public class sjy
  extends acje
{
  public sjy(FollowTextView paramFollowTextView) {}
  
  public void v(boolean paramBoolean, String paramString)
  {
    super.v(paramBoolean, paramString);
    FollowTextView.a(this.f, true);
    if (paramBoolean)
    {
      if (!FollowTextView.a(this.f)) {
        FollowTextView.a(this.f, false, FollowTextView.a(this.f));
      }
      this.f.vt(0);
      if (FollowTextView.a(this.f) != null)
      {
        if (FollowTextView.a(this.f) != null) {
          FollowTextView.a(this.f).a(false, FollowTextView.a(this.f));
        }
        rwv.a().a(new FollowUpdateEvent(0, FollowTextView.a(this.f).poster.id.get()));
      }
      return;
    }
    QQToast.a(this.f.getContext(), 2131691358, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjy
 * JD-Core Version:    0.7.0.1
 */