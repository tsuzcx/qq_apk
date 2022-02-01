import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

public class uzb
  implements ausj.a
{
  public uzb(FriendProfileCardActivity paramFriendProfileCardActivity, PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$sheet.superDismiss();
      return;
      Object localObject;
      if (aqiw.isNetSupport(this.this$0.app.getApplication().getApplicationContext()))
      {
        localObject = this.this$0.a.gh[3];
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramView = (View)localObject;
          if (!((String)localObject).equals(this.this$0.a.a.mobileNo)) {}
        }
        else
        {
          paramView = this.this$0.a.e.contactName;
        }
        if (!TextUtils.isEmpty(paramView))
        {
          localObject = paramView;
          if (!paramView.equals(this.this$0.a.a.mobileNo)) {}
        }
        else
        {
          localObject = this.this$0.a.a.nickName;
        }
        localObject = ahlr.a(this.this$0.app, this.this$0, this.this$0.a.e.uin, (String)localObject, this.this$0.a.a.bindQQ);
        paramView = new Bundle();
        paramView.putString("uin", this.this$0.a.a.mobileNo);
        paramView.putInt("uintype", 1006);
        paramView.putInt("forward_type", 20);
        paramView.putInt("structmsg_service_id", ((AbsShareMsg)localObject).mMsgServiceID);
        paramView.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject).getBytes());
        paramView.putBoolean("k_dataline", false);
        paramView.putInt("pa_type", this.this$0.a.e.pa);
        localObject = new Intent();
        ((Intent)localObject).putExtras(paramView);
        ahgq.f(this.this$0, (Intent)localObject, 21);
        if (this.this$0.a.e.pa == 53) {
          anot.a(this.this$0.app, "CliOper", "", "", "0X8007016", "0X8007016", 0, 0, "", "", "", "");
        } else {
          anot.a(this.this$0.app, "CliOper", "", "", "0X8007168", "0X8007168", 0, 0, "", "", "", "");
        }
      }
      else
      {
        QQToast.a(this.this$0, 1, acfp.m(2131706618), 1000).show();
        continue;
        if (aqiw.isNetSupport(this.this$0.app.getApplication().getApplicationContext()))
        {
          paramView = this.c;
          localObject = FriendProfileCardActivity.a(this.this$0.a.e);
          label472:
          QQAppInterface localQQAppInterface;
          if (!this.aWD)
          {
            paramView.bd((String)localObject, bool);
            this.this$0.showProgressDialog();
            localQQAppInterface = this.this$0.app;
            if (!this.aWD) {
              break label548;
            }
            paramView = "0X800603E";
            label505:
            if (!this.aWD) {
              break label554;
            }
          }
          label548:
          label554:
          for (localObject = "0X800603E";; localObject = "0X800603D")
          {
            anot.a(localQQAppInterface, "CliOper", "", "", paramView, (String)localObject, 0, 0, "", "", "", "");
            break;
            bool = false;
            break label472;
            paramView = "0X800603D";
            break label505;
          }
        }
        QQToast.a(this.this$0, 1, acfp.m(2131706603), 1000).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzb
 * JD-Core Version:    0.7.0.1
 */