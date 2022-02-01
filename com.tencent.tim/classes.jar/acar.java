import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acar
  implements View.OnClickListener
{
  public acar(ApolloPanel paramApolloPanel, ApolloActionData paramApolloActionData) {}
  
  public void onClick(View paramView)
  {
    abzy localabzy = new abzy();
    localabzy.c = this.d;
    if (ApolloPanel.a(this.this$0) != null) {
      ApolloPanel.a(this.this$0).c(this.this$0.mBaseChatPie, localabzy);
    }
    if (this.this$0.g != null) {
      VipUtils.a(this.this$0.mBaseChatPie.app, "cmshow", "Apollo", "unlockedpreview", ApolloUtil.gi(this.this$0.g.cZ), 0, new String[] { String.valueOf(this.d.actionId) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acar
 * JD-Core Version:    0.7.0.1
 */