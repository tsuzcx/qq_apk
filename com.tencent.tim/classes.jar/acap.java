import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acap
  implements View.OnClickListener
{
  public acap(ApolloPanel paramApolloPanel, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    ApolloUtil.d(this.this$0.mBaseChatPie.mActivity, this.this$0.mBaseChatPie.app.getCurrentUin(), "lmx_actchat");
    ApolloPanel.b(this.this$0);
    if (this.this$0.g != null) {
      VipUtils.a(this.this$0.mBaseChatPie.app, "cmshow", "Apollo", "action_flame_clickgain", ApolloUtil.gi(this.this$0.g.cZ), 0, new String[] { String.valueOf(this.a.actionId) });
    }
    abhh.g(125, String.valueOf(this.cuq), this.bko, this.bkp);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acap
 * JD-Core Version:    0.7.0.1
 */