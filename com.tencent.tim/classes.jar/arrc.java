import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenCardContainer.a;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arrc
  implements View.OnClickListener
{
  public arrc(OpenAuthorityAccountView paramOpenAuthorityAccountView, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (((OpenAuthorityAccountView.a(this.this$0) instanceof PublicFragmentActivityForOpenSDK)) && (OpenAuthorityAccountView.a(this.this$0) != null)) {
      OpenAuthorityAccountView.a(this.this$0).dw(this.val$account, true);
    }
    for (;;)
    {
      if (OpenAuthorityAccountView.a(this.this$0) != null) {
        OpenAuthorityAccountView.a(this.this$0).dismiss();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((OpenAuthorityAccountView.a(this.this$0) instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)OpenAuthorityAccountView.a(this.this$0)).dt(this.val$account, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arrc
 * JD-Core Version:    0.7.0.1
 */