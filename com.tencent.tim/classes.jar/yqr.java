import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView.b;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.XListView;

public class yqr
  extends acje
{
  public yqr(PublicView paramPublicView) {}
  
  public void AB(boolean paramBoolean)
  {
    if (true == paramBoolean)
    {
      PublicView.a(this.b).tT(0);
      PublicView.a(this.b).sendEmptyMessage(1);
      PublicView.a(this.b).sendEmptyMessage(3);
      return;
    }
    PublicView.a(this.b).springBackOverScrollHeaderView();
    PublicView.a(this.b, 1, 2131720480);
    PublicView.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqr
 * JD-Core Version:    0.7.0.1
 */