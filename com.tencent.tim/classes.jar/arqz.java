import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenCardContainer.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arqz
  implements View.OnClickListener
{
  public arqz(OpenAuthorityAccountView paramOpenAuthorityAccountView) {}
  
  public void onClick(View paramView)
  {
    if (OpenAuthorityAccountView.a(this.this$0) != null) {
      OpenAuthorityAccountView.a(this.this$0).elq();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqz
 * JD-Core Version:    0.7.0.1
 */