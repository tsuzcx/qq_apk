import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

public class dmb
  extends SubAccountBindObserver
{
  public dmb(SubAccountMessageActivity paramSubAccountMessageActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    this.a.e();
    if (SubAccountMessageActivity.c(this.a))
    {
      SubAccountMessageActivity.c(this.a, false);
      if ((paramBoolean) && (paramSubAccountBackProtocData != null) && (paramSubAccountBackProtocData.a()))
      {
        this.a.b(this.a.getString(2131562792));
        SubAccountAssistantForward.a(this.a.b, this.a, this.a.b.getAccount());
        this.a.finish();
      }
    }
    while ((!paramBoolean) || (paramSubAccountBackProtocData == null) || ((SubAccountMessageActivity.a(this.a) != null) && (!TextUtils.isEmpty(SubAccountMessageActivity.a(this.a).subuin)) && (SubAccountMessageActivity.a(this.a).subuin.equalsIgnoreCase(SubAccountAssistantImpl.a().a(this.a.b))))) {
      for (;;)
      {
        return;
        this.a.a(this.a.getString(2131562086));
      }
    }
    this.a.a(this.a.getString(2131562520), this.a.getString(2131563026), this.a.getString(2131562540), new dmc(this));
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    String str2;
    StringBuilder localStringBuilder;
    if ((QLog.isColorLevel()) && (paramSubAccountBackProtocData != null))
    {
      str2 = SubAccountMessageActivity.a(this.a);
      localStringBuilder = new StringBuilder().append("onUnBindSubAccount:");
      if (!paramBoolean) {
        break label196;
      }
    }
    label196:
    for (String str1 = "..success";; str1 = "...failed..")
    {
      QLog.d(str2, 2, str1 + " ...errorMsg = " + paramSubAccountBackProtocData.a + "...errorType = " + paramSubAccountBackProtocData.p);
      this.a.e();
      if (!paramBoolean) {
        break;
      }
      this.a.b.a().c(AppConstants.O, 7000);
      SubAccountAssistantForward.b(this.a.b);
      SubAccountAssistantForward.a(this.a.b);
      SubAccountAssistantForward.e(this.a.b);
      SubAccountAssistantForward.c(this.a.b);
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
      SubAccountAssistantForward.b(this.a.b);
      SubAccountAssistantForward.a(this.a.b);
      SubAccountAssistantForward.e(this.a.b);
      SubAccountAssistantForward.c(this.a.b);
      this.a.a(this.a.getString(2131563297));
      SubAccountAssistantForward.a(this.a.b, this.a.a(), this.a.b.getAccount());
      this.a.finish();
      return;
    }
    paramSubAccountBackProtocData = this.a.getString(2131562520);
    str1 = this.a.getString(2131563286);
    this.a.a(paramSubAccountBackProtocData, str1, new dmd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmb
 * JD-Core Version:    0.7.0.1
 */