import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acan
  implements View.OnClickListener
{
  public acan(ApolloPanel paramApolloPanel, Bundle paramBundle, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.mBaseChatPie != null) && (this.this$0.mBaseChatPie.mActivity != null))
    {
      Object localObject1 = null;
      if (this.ab != null) {
        localObject1 = this.ab.getString("activityUrl");
      }
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.a.url;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[realshowNewActionFloatView] btn click, activityUrl=", localObject2 });
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new Intent(this.this$0.mBaseChatPie.mActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", (String)localObject2);
        this.this$0.mBaseChatPie.mActivity.startActivity((Intent)localObject1);
      }
      ApolloPanel.b(this.this$0);
      if (this.this$0.g != null) {
        VipUtils.a(this.this$0.mBaseChatPie.app, "cmshow", "Apollo", "action_flame_clickgain", ApolloUtil.gi(this.this$0.g.cZ), 0, new String[] { String.valueOf(this.a.actionId) });
      }
      abhh.g(125, String.valueOf(this.cuq), this.bko, this.bkp);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acan
 * JD-Core Version:    0.7.0.1
 */