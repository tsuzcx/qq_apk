import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class ugh
  implements View.OnClickListener
{
  public ugh(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131362223)) {
      AssociatedAccountActivity.a(this.this$0);
    }
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == null) || ((paramView.getTag() instanceof abdp.b)))
      {
        localObject1 = (abdp.b)paramView.getTag();
        if ((localObject1 == null) || (((abdp.b)localObject1).a != null))
        {
          localObject2 = ((abdp.b)localObject1).a;
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "onItemClick type = " + ((anxi)localObject2).type);
          }
          switch (((anxi)localObject2).type)
          {
          case 5: 
          default: 
            localObject1 = null;
            label163:
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (akwp.a().a(this.this$0.app, this.this$0)) && (this.this$0.QN()))
            {
              if (((anxi)localObject2).isLogined) {
                break label673;
              }
              if (QLog.isColorLevel()) {
                QLog.d("AssociatedAccountActivity", 2, "onItemClick goto SubAccountUgActivity");
              }
              this.this$0.aKS = ((String)localObject1);
              this.this$0.aRv = true;
              localObject2 = new Intent("before_account_change");
              this.this$0.sendBroadcast((Intent)localObject2);
              localObject2 = new Intent(this.this$0, SubAccountUgActivity.class);
              ((Intent)localObject2).putExtra("subAccount", (String)localObject1);
              ((Intent)localObject2).putExtra("from_associated_activity", true);
              this.this$0.startActivity((Intent)localObject2);
            }
            break;
          }
        }
      }
    }
    if ((((anxi)localObject2).eY != null) && ((((anxi)localObject2).eY instanceof SimpleAccount))) {}
    for (Object localObject1 = ((SimpleAccount)((anxi)localObject2).eY).getUin();; localObject1 = null)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "0X8007141", "0X8007141", 0, 0, "", "", "", "");
      break label163;
      AssociatedAccountActivity.a(this.this$0);
      anot.a(this.this$0.app, "CliOper", "", "", "0X800714A", "0X800714A", 0, 0, "", "", "", "");
      break;
      if ((((anxi)localObject2).eY != null) && ((((anxi)localObject2).eY instanceof SubAccountMessage))) {}
      for (localObject1 = ((SubAccountMessage)((anxi)localObject2).eY).subUin;; localObject1 = null)
      {
        anot.a(this.this$0.app, "dc00898", "", "", "0X800AC3D", "0X800AC3D", 0, 0, "", "", "", "");
        anot.a(this.this$0.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
        break label163;
        if ((((anxi)localObject2).eY != null) && ((((anxi)localObject2).eY instanceof SubAccountInfo))) {}
        for (localObject1 = ((SubAccountInfo)((anxi)localObject2).eY).subuin;; localObject1 = null)
        {
          if (((anxi)localObject2).type == 2)
          {
            anot.a(this.this$0.app, "dc00898", "", "", "0X800AC3C", "0X800AC3C", 0, 0, "", "", "", "");
            anot.a(this.this$0.app, "CliOper", "", "", "0X800713F", "0X800713F", 0, 0, "", "", "", "");
            break label163;
          }
          anot.a(this.this$0.app, "dc00898", "", "", "0X800AC3D", "0X800AC3D", 0, 0, "", "", "", "");
          anot.a(this.this$0.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
          break label163;
          label673:
          if ((((anxi)localObject2).isLogined) && (((anxi)localObject2).type == 2))
          {
            if ((((anxi)localObject2).eY == null) || (!(((anxi)localObject2).eY instanceof SubAccountInfo)) || (this.this$0.a == null)) {
              break;
            }
            localObject1 = (SubAccountInfo)((anxi)localObject2).eY;
            if ((TextUtils.isEmpty(((SubAccountInfo)localObject1).subuin)) || (((SubAccountInfo)localObject1).subuin.equals(this.this$0.a.subuin))) {
              break;
            }
            this.this$0.a = ((SubAccountInfo)localObject1);
            AssociatedAccountActivity.b(this.this$0, true);
            break;
          }
          this.this$0.yC(2131696678);
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "onItemClick mNeed2ConfirmMsgNum = " + this.this$0.bDW + "  toUin=" + (String)localObject1);
          }
          if (this.this$0.bDW > 0)
          {
            this.this$0.aKS = ((String)localObject1);
            localObject2 = (MessageHandler)this.this$0.app.getBusinessHandler(0);
            anxr localanxr = (anxr)this.this$0.app.getManager(61);
            Iterator localIterator = this.this$0.oM.iterator();
            int i = 0;
            for (;;)
            {
              j = i;
              if (!localIterator.hasNext()) {
                break;
              }
              SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
              if ((localSubAccountInfo != null) && (!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localanxr.eA(localSubAccountInfo.subuin) > 0))
              {
                i += 1;
                ((MessageHandler)localObject2).a().fi(localSubAccountInfo.subuin, "sub.account.switchAccount");
              }
            }
          }
          int j = 0;
          if (j > 0)
          {
            this.this$0.bDW = j;
            break;
          }
          AssociatedAccountActivity.b(this.this$0, false, (String)localObject1);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugh
 * JD-Core Version:    0.7.0.1
 */