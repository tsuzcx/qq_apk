import com.tencent.mobileqq.activity.contact.addcontact.PublicView;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.XListView;

public class wfe
  extends PublicAccountObserver
{
  public wfe(PublicView paramPublicView) {}
  
  public void a(boolean paramBoolean)
  {
    if (true == paramBoolean)
    {
      PublicView.a(this.a).a(0);
      PublicView.a(this.a).sendEmptyMessage(1);
      PublicView.a(this.a).sendEmptyMessage(3);
      return;
    }
    PublicView.a(this.a).springBackOverScrollHeaderView();
    PublicView.a(this.a, 1, 2131434332);
    PublicView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wfe
 * JD-Core Version:    0.7.0.1
 */