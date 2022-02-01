import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

class aksk
  implements View.OnClickListener
{
  aksk(akrv paramakrv) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof akrv.a)) {}
    Object localObject1;
    SubAccountInfo localSubAccountInfo;
    switch (((akrv.a)paramView.getTag()).type)
    {
    default: 
    case 0: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (aqft.aCd())
        {
          QQToast.a(akrv.a(this.this$0), 2131695539, 0).show();
        }
        else
        {
          localObject1 = new Intent(akrv.a(this.this$0), AddAccountActivity.class);
          akrv.a(this.this$0).startActivity((Intent)localObject1);
          akrv.a(this.this$0).overridePendingTransition(2130772009, 2130772002);
          anxj.l(akrv.a(this.this$0), akrv.a(this.this$0));
          anot.a(akrv.a(this.this$0), "CliOper", "", "", "0X80072D4", "0X80072D4", 0, 0, "", "", "", "");
        }
      }
    case 2: 
      localSubAccountInfo = (SubAccountInfo)paramView.getTag(2131361913);
      if (localSubAccountInfo != null)
      {
        localObject1 = akrv.a(this.this$0).getApplication().getAllAccounts();
        Object localObject2 = new ArrayList();
        if (localObject1 != null) {
          ((List)localObject2).addAll((Collection)localObject1);
        }
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = ((List)localObject2).iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = (SimpleAccount)((Iterator)localObject2).next();
          } while (!TextUtils.equals(((SimpleAccount)localObject1).getUin(), localSubAccountInfo.subuin));
        }
      }
      break;
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.this$0.a((SimpleAccount)localObject1, akrv.a(this.this$0).app);
      }
      for (;;)
      {
        anot.a(akrv.a(this.this$0), "dc00898", "", "", "0X800AC36", "0X800AC36", 0, 0, "", "", "", "");
        anot.a(akrv.a(this.this$0), "CliOper", "", "", "0X80072D2", "0X80072D2", 0, 0, "", "", "", "");
        break;
        if (localSubAccountInfo != null)
        {
          localObject1 = new Intent("before_account_change");
          akrv.a(this.this$0).sendBroadcast((Intent)localObject1);
          localObject1 = new Intent(akrv.a(this.this$0), SubAccountUgActivity.class);
          ((Intent)localObject1).putExtra("subAccount", localSubAccountInfo.subuin);
          akrv.a(this.this$0).startActivity((Intent)localObject1);
        }
      }
      localObject1 = (SimpleAccount)paramView.getTag(2131361913);
      this.this$0.a((SimpleAccount)localObject1, akrv.a(this.this$0));
      anot.a(akrv.a(this.this$0), "dc00898", "", "", "0X800AC36", "0X800AC36", 0, 0, "", "", "", "");
      anot.a(akrv.a(this.this$0), "CliOper", "", "", "0X80072D3", "0X80072D3", 0, 0, "", "", "", "");
      break;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aksk
 * JD-Core Version:    0.7.0.1
 */