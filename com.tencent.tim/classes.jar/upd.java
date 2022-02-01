import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatSettingActivity.a;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import mqq.os.MqqHandler;

public final class upd
  implements arfj.a
{
  public upd(ChatSettingActivity.a parama, QQAppInterface paramQQAppInterface, String paramString, int paramInt, Activity paramActivity) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    if (this.a != null)
    {
      if (paramBoolean)
      {
        this.a.h(this.val$app, 0);
        this.a.i(this.val$app, 0);
      }
      this.a.h(this.val$app, 1);
      this.a.i(this.val$app, 1);
    }
    paramDialog = new StringBuilder();
    paramView = (achs)this.val$app.getManager(92);
    paramView.init(this.val$uin);
    int i = paramView.a(this.val$uin, this.ber, paramDialog);
    if ((paramDialog != null) && (paramDialog.length() > 0)) {}
    for (paramDialog = paramDialog.toString();; paramDialog = null)
    {
      if (i <= 0)
      {
        QQToast.a(BaseApplication.getContext(), 2, 2131692510, 1).show();
        if (this.a != null) {
          this.a.bt(this.val$context);
        }
      }
      label356:
      do
      {
        return;
        long l2 = 0L;
        List localList = this.val$app.b().k(this.val$uin, this.ber);
        long l1 = l2;
        if (localList != null)
        {
          l1 = l2;
          if (!localList.isEmpty())
          {
            if (!((MessageRecord)localList.get(localList.size() - 1)).isSendFromLocal()) {
              break label356;
            }
            l1 = ((MessageRecord)localList.get(localList.size() - 1)).time + 2L;
          }
        }
        if (FriendsStatusUtil.k(this.val$app, this.val$uin, this.ber))
        {
          FriendsStatusUtil.r(this.val$app, this.val$uin, this.ber);
          this.val$app.b().a(this.val$uin, this.ber, true, false);
        }
        for (;;)
        {
          abrb.F(this.val$app, "chat_history_c2c_start_del_msg");
          if (!paramBoolean) {
            break label442;
          }
          if (aqiw.isNetSupport(BaseApplication.getContext())) {
            break label405;
          }
          QQToast.a(BaseApplication.getContext(), 2131692507, 1).show();
          return;
          l1 = ((MessageRecord)localList.get(localList.size() - 1)).time;
          break;
          this.val$app.b().N(this.val$uin, this.ber);
        }
        ((achs)this.val$app.getManager(92)).cKF();
        this.val$app.a().eE(this.val$uin, this.ber);
        paramView.cKK();
        this.val$app.b().cc(this.val$uin, this.ber);
        if (paramDialog != null) {
          l2 = 0L;
        }
        try
        {
          long l3 = Long.parseLong(paramDialog);
          l2 = l3;
        }
        catch (Exception paramDialog)
        {
          for (;;)
          {
            paramDialog.printStackTrace();
          }
        }
        l1 = Math.max(l2, l1);
        if (l1 > 0L) {
          this.val$app.a().F(this.val$uin, this.ber, l1);
        }
        paramView.a().cKG();
        paramView.cKx();
        if (paramBoolean) {
          paramView.cKK();
        }
        paramDialog = this.val$app.getHandler(Conversation.class);
        if (paramDialog != null)
        {
          paramView = paramDialog.obtainMessage(1017);
          paramView.obj = this.val$uin;
          paramView.arg1 = this.ber;
          paramDialog.sendMessage(paramView);
        }
      } while (this.a == null);
      label405:
      label442:
      this.a.bt(this.val$context);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upd
 * JD-Core Version:    0.7.0.1
 */