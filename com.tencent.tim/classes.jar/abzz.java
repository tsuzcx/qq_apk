import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class abzz
  extends aqrd
{
  public abzz(ApolloLinearLayout paramApolloLinearLayout) {}
  
  protected void onAuthResponse(boolean paramBoolean, Object paramObject)
  {
    if ((this.this$0.i == null) || (this.this$0.i.app == null) || (this.this$0.mSessionInfo == null)) {}
    label598:
    for (;;)
    {
      return;
      Object localObject = new ApolloActionData();
      paramObject = (HashMap)paramObject;
      String str = (String)paramObject.get("optFrom");
      if ((!TextUtils.isEmpty(str)) && ("actionPanel".equals(str)))
      {
        int i = Integer.parseInt((String)paramObject.get("id"));
        ((ApolloActionData)localObject).actionId = i;
        localObject = this.this$0.a((ApolloActionData)localObject);
        if (localObject != null)
        {
          ((ImageView)((View)localObject).findViewById(2131379764)).setVisibility(8);
          ((View)localObject).setClickable(true);
          if (this.this$0.bb.incrementAndGet() == this.this$0.ba.get())
          {
            this.this$0.ba.set(0);
            this.this$0.bb.set(0);
            this.this$0.i.app.removeObserver(this.this$0.f);
          }
          if (paramBoolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloLinearLayout", 2, "action auth success actionid=" + i);
            }
            paramObject.put("APOLLO_POP_TYPE", "toast");
            paramObject.put("tips", this.this$0.i.mContext.getString(2131690328));
            ((aqrb)this.this$0.i.app.getBusinessHandler(71)).ag(this.this$0.i.app.getCurrentUin(), 128, "obtained action");
          }
          for (;;)
          {
            if ((this.this$0.i == null) || (this.this$0.i.app == null)) {
              break label598;
            }
            localObject = this.this$0.i.app.getHandler(ChatActivity.class);
            if (localObject == null) {
              break;
            }
            VipUtils.a(this.this$0.i.app, "cmshow", "Apollo", "activity_alert_show", ApolloUtil.gi(this.this$0.mSessionInfo.cZ), 0, new String[] { "" + i, "0" });
            localObject = ((MqqHandler)localObject).obtainMessage(45);
            ((Message)localObject).obj = paramObject;
            ((Message)localObject).sendToTarget();
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloLinearLayout", 2, "action auth fail actionid=" + i);
            }
            paramObject.put("APOLLO_POP_TYPE", "dialog");
            paramObject.put("feeType", String.valueOf(6));
            paramObject.put("title", acfp.m(2131702604));
            if (TextUtils.isEmpty((String)paramObject.get("content"))) {
              paramObject.put("content", acfp.m(2131702603));
            }
            paramObject.put("rightString", acfp.m(2131702605));
            paramObject.put("isActionBack", "true");
            paramObject.put("actionId", "" + i);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abzz
 * JD-Core Version:    0.7.0.1
 */