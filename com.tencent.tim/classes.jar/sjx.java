import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView.a;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

public class sjx
  extends acje
{
  public sjx(FollowTextView paramFollowTextView) {}
  
  public void m(boolean paramBoolean, String paramString)
  {
    super.m(paramBoolean, paramString);
    FollowTextView.a(this.f, true);
    if (paramBoolean)
    {
      if (!FollowTextView.a(this.f)) {
        FollowTextView.a(this.f, true, FollowTextView.a(this.f));
      }
      this.f.vt(1);
      if (FollowTextView.a(this.f) != null)
      {
        if (FollowTextView.a(this.f) != null) {
          FollowTextView.a(this.f).a(true, FollowTextView.a(this.f));
        }
        rwv.a().a(new FollowUpdateEvent(1, FollowTextView.a(this.f).poster.id.get()));
      }
      return;
    }
    QQToast.a(this.f.getContext(), 2131691349, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjx
 * JD-Core Version:    0.7.0.1
 */