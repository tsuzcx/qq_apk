import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.ApolloGameNormalStartHandler.3;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abhg
  implements View.OnClickListener
{
  public abhg(ApolloGameNormalStartHandler.3 param3) {}
  
  public void onClick(View paramView)
  {
    abhf.a(this.a.this$0).dismiss();
    abhf.a(this.a.this$0, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhg
 * JD-Core Version:    0.7.0.1
 */