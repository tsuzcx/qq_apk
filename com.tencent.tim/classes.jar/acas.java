import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanel.a;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acas
  implements View.OnClickListener
{
  public acas(ApolloPanel paramApolloPanel, ApolloActionData paramApolloActionData) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.a != null) {
      this.this$0.a.gQ(3, this.d.actionId);
    }
    for (;;)
    {
      ApolloPanel.b(this.this$0);
      if (this.this$0.g != null) {
        VipUtils.a(this.this$0.mBaseChatPie.app, "cmshow", "Apollo", "unlockeddownload", ApolloUtil.gi(this.this$0.g.cZ), 0, new String[] { String.valueOf(this.d.actionId) });
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e("ApolloPanel", 1, "showKapuLockActionView mAppController null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acas
 * JD-Core Version:    0.7.0.1
 */