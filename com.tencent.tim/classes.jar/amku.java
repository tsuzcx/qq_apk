import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class amku
  implements ausj.a
{
  amku(amkt paramamkt, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, amow[] paramArrayOfamow1, amow[] paramArrayOfamow2, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    int j = 1;
    int k = 1;
    paramInt = 1;
    switch (paramView.getId())
    {
    default: 
    case 2131362369: 
    case 2131362370: 
    case 2131362365: 
    case 2131362371: 
    case 2131362368: 
    case 2131362366: 
    case 2131362367: 
      for (;;)
      {
        this.val$actionSheet.dismiss();
        return;
        ((ClipboardManager)this.val$context.getSystemService("clipboard")).setText(this.caH);
        anot.a(this.val$app, "dc00898", "", "", "0X800A926", "0X800A926", amks.a(this.jdField_a_of_type_Amkt.a), 0, "", "", "", "");
        continue;
        xov.a(this.val$app, (Activity)this.val$context, amks.a(this.jdField_a_of_type_Amkt.a), amks.a(this.jdField_a_of_type_Amkt.a));
        anot.a(this.val$app, "dc00898", "", "", "0X800A927", "0X800A927", amks.a(this.jdField_a_of_type_Amkt.a), 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_ArrayOfAmow[0].dDr == 2)
        {
          QQToast.a(this.val$context, 0, 2131689789, 0).show();
          paramView = this.val$app;
          if (this.b[0] != null) {
            break label389;
          }
        }
        for (;;)
        {
          anot.a(paramView, "dc00898", "", "", "0X800A928", "0X800A928", paramInt, 0, "", "", "", "");
          break;
          paramView = new SearchResultItem();
          paramView.lUIN = Long.parseLong(this.jdField_a_of_type_ArrayOfAmow[0].id);
          try
          {
            if ((asgx.mS(this.jdField_a_of_type_ArrayOfAmow[0].dDo)) || (asgx.cU(this.jdField_a_of_type_ArrayOfAmow[0].dDo))) {
              paramView.lUIN = Long.parseLong(this.jdField_a_of_type_ArrayOfAmow[0].cbm);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.i("UinSearcher", 1, "qidian corp jump error");
            }
          }
          paramView.strNick = this.jdField_a_of_type_ArrayOfAmow[0].name;
          AddFriendActivity.a((Activity)this.val$context, paramView, this.val$app, false, 1);
          break label232;
          paramInt = 3;
        }
        if (this.b[0].dDr == 3)
        {
          QQToast.a(this.val$context, 0, 2131695148, 0).show();
          paramView = this.val$app;
          if (this.jdField_a_of_type_ArrayOfAmow[0] != null) {
            break label532;
          }
        }
        for (paramInt = i;; paramInt = 3)
        {
          anot.a(paramView, "dc00898", "", "", "0X800A929", "0X800A929", paramInt, 0, "", "", "", "");
          break;
          if (this.b[0].dDs == 1)
          {
            QQToast.a(this.val$context, 0, 2131695147, 0).show();
            break label422;
          }
          paramView = TroopInfoActivity.a(this.b[0].id, this.b[0].bOx, 105);
          apuh.a(this.val$context, paramView, 2);
          break label422;
        }
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.caH));
        paramView.putExtra("big_brother_source_key", amks.c(this.jdField_a_of_type_Amkt.a));
        this.val$context.startActivity(paramView);
        anot.a(this.val$app, "dc00898", "", "", "0X800A92A", "0X800A92A", amks.a(this.jdField_a_of_type_Amkt.a), 0, "", "", "", "");
        continue;
        aofk.ca(this.val$context, this.caH);
        anot.a(this.val$app, "dc00898", "", "", "0X800A92B", "0X800A92B", amks.a(this.jdField_a_of_type_Amkt.a), 0, "", "", "", "");
        continue;
        aqep.c((Activity)this.val$context, this.val$app.getCurrentUin(), amks.d(this.jdField_a_of_type_Amkt.a), amks.b(this.jdField_a_of_type_Amkt.a), this.caH);
        anot.a(this.val$app, "dc00898", "", "", "0X800A92C", "0X800A92C", amks.a(this.jdField_a_of_type_Amkt.a), 0, "", "", "", "");
      }
    case 2131362372: 
      label232:
      paramView = new Intent(this.val$context, FriendProfileCardActivity.class);
      label389:
      label422:
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.caH, 1);
      label532:
      localAllInOne.bJa = 124;
      paramView.putExtra("AllInOne", localAllInOne);
      this.val$context.startActivity(paramView);
      paramView = this.val$app;
      if (this.b[0] == null) {}
      for (paramInt = j;; paramInt = 3)
      {
        anot.a(paramView, "dc00898", "", "", "0X800AA69", "0X800AA69", paramInt, 0, "", "", "", "");
        break;
      }
    }
    paramView = new Intent();
    paramView.putExtra("troop_code", ((TroopManager)this.val$app.getManager(52)).b(this.caH).troopcode);
    paramView.putExtra("troop_uin", this.caH);
    apuh.a(this.val$context, paramView.getExtras(), 1);
    paramView = this.val$app;
    if (this.jdField_a_of_type_ArrayOfAmow[0] == null) {}
    for (paramInt = k;; paramInt = 3)
    {
      anot.a(paramView, "dc00898", "", "", "0X800AA6A", "0X800AA6A", paramInt, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amku
 * JD-Core Version:    0.7.0.1
 */