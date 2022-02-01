import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aror
  implements View.OnClickListener
{
  public aror(AuthorityAccountView paramAuthorityAccountView, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((AuthorityAccountView.a(this.this$0) instanceof AuthorityActivity)) {
      ((AuthorityActivity)AuthorityAccountView.a(this.this$0)).dt(this.val$account, true);
    }
    for (;;)
    {
      if (AuthorityAccountView.a(this.this$0) != null) {
        AuthorityAccountView.a(this.this$0).dismiss();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((AuthorityAccountView.a(this.this$0) instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)AuthorityAccountView.a(this.this$0)).dt(this.val$account, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aror
 * JD-Core Version:    0.7.0.1
 */