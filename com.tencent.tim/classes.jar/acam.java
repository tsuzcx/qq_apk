import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acam
  implements View.OnClickListener
{
  public acam(ApolloPanel paramApolloPanel, acad paramacad, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.mBaseChatPie != null) && (this.this$0.mBaseChatPie.app != null) && (ApolloPanel.a(this.this$0) != null)) {
      ApolloPanel.a(this.this$0).b(this.this$0.mBaseChatPie, this.jdField_a_of_type_Acad);
    }
    ApolloPanel.b(this.this$0);
    if (this.this$0.g != null) {
      VipUtils.a(this.this$0.mBaseChatPie.app, "cmshow", "Apollo", "action_flame_clicksend", ApolloUtil.gi(this.this$0.g.cZ), 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId) });
    }
    abhh.g(102, String.valueOf(this.cuq), this.bko, this.bkp);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acam
 * JD-Core Version:    0.7.0.1
 */