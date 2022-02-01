import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acal
  implements View.OnClickListener
{
  public acal(ApolloPanel paramApolloPanel, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (ApolloPanel.a(this.this$0) != null)
    {
      abzy localabzy = new abzy();
      localabzy.c = this.a;
      ApolloPanel.a(this.this$0).c(this.this$0.mBaseChatPie, localabzy);
      abhh.g(124, String.valueOf(this.cuq), this.bko, this.bkp);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acal
 * JD-Core Version:    0.7.0.1
 */