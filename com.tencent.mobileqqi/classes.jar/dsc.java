import android.app.Activity;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

public class dsc
  extends SubAccountBindObserver
{
  public dsc(SubAccountSettingActivity paramSubAccountSettingActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    this.a.e();
    if (SubAccountSettingActivity.a(this.a))
    {
      SubAccountSettingActivity.a(this.a, false);
      if ((paramBoolean) && (paramSubAccountBackProtocData != null)) {
        if (paramSubAccountBackProtocData.a())
        {
          SubAccountAssistantForward.a(this.a.b, this.a.a(), this.a.b.getAccount());
          this.a.finish();
        }
      }
    }
    while ((!paramBoolean) || (paramSubAccountBackProtocData == null) || ((SubAccountSettingActivity.a(this.a) != null) && (SubAccountSettingActivity.a(this.a).subuin != null) && (SubAccountSettingActivity.a(this.a).subuin.equals(paramSubAccountBackProtocData.c))))
    {
      for (;;)
      {
        return;
        SubAccountAssistantForward.a(this.a.b, this.a.a(), this.a.b.getAccount());
      }
      this.a.a(this.a.getString(2131562086));
      return;
    }
    this.a.a(this.a.getString(2131562520), this.a.getString(2131563026), this.a.getString(2131562540), new dsf(this));
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    String str2;
    StringBuilder localStringBuilder;
    if ((QLog.isColorLevel()) && (paramSubAccountBackProtocData != null))
    {
      str2 = SubAccountSettingActivity.a(this.a);
      localStringBuilder = new StringBuilder().append("onUnBindSubAccount:....SubAccountSettingActivity......unbindSub ............");
      if (!paramBoolean) {
        break label156;
      }
    }
    label156:
    for (String str1 = "..success";; str1 = "...failed..")
    {
      QLog.d(str2, 2, str1 + " ...errorMsg = " + paramSubAccountBackProtocData.a + "...errorType = " + paramSubAccountBackProtocData.p);
      this.a.e();
      if (!paramBoolean) {
        break;
      }
      this.a.b.a().c(AppConstants.O, 7000);
      this.a.a().setTitle("");
      SubAccountAssistantForward.a(this.a.b, this.a.a(), this.a.b.getAccount());
      this.a.finish();
      return;
    }
    switch (paramSubAccountBackProtocData.p)
    {
    default: 
      this.a.a(this.a.getString(2131561771));
      return;
    case 1008: 
      paramSubAccountBackProtocData = this.a.getString(2131562520);
      str1 = this.a.getString(2131563297);
      this.a.a(paramSubAccountBackProtocData, str1, new dsd(this));
      return;
    }
    paramSubAccountBackProtocData = this.a.getString(2131562520);
    str1 = this.a.getString(2131563286);
    this.a.a(paramSubAccountBackProtocData, str1, new dse(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dsc
 * JD-Core Version:    0.7.0.1
 */