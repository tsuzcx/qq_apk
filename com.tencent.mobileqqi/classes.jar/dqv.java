import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.SubAccountBaseActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class dqv
  extends SubAccountBindObserver
{
  public dqv(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    this.a.e();
    StringBuilder localStringBuilder;
    if (SubAccountBindActivity.a(this.a))
    {
      SubAccountBindActivity.a(this.a, false);
      if ((paramBoolean) && (paramSubAccountBackProtocData != null)) {
        if (paramSubAccountBackProtocData.a())
        {
          SubAccountAssistantForward.a(this.a.b);
          SubAccountAssistantForward.a(this.a.b, this.a, this.a.b.getAccount());
          this.a.finish();
          if ((QLog.isColorLevel()) && (paramSubAccountBackProtocData != null))
          {
            localStringBuilder = new StringBuilder().append("onGetBindSubAccount:");
            if (!paramBoolean) {
              break label251;
            }
          }
        }
      }
    }
    label251:
    for (String str = "..success";; str = "...failed..")
    {
      QLog.d("Q.subaccount.SubAccountBindActivity", 2, str + " ...errorMsg = " + paramSubAccountBackProtocData.a + "...errorType = " + paramSubAccountBackProtocData.p);
      return;
      this.a.a(this.a.getString(2131562086));
      break;
      this.a.a(this.a.getString(2131562086));
      break;
      if ((!paramBoolean) || (paramSubAccountBackProtocData == null) || (!paramSubAccountBackProtocData.a())) {
        break;
      }
      this.a.a(this.a.getString(2131562520), this.a.getString(2131563288), this.a.getString(2131562540), new dqy(this));
      break;
    }
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    this.a.e();
    Object localObject2;
    if (paramBoolean)
    {
      if (SubAccountBaseActivity.b) {
        ReportController.a(this.a.b, "CliOper", "", "", "0X8004003", "0X8004003", 0, 0, "", "", "", "");
      }
      this.a.b(this.a.getString(2131561720));
      SubAccountAssistantForward.a(this.a.b);
      this.a.a().setTitle("");
      localObject1 = new Intent(this.a, SplashActivity.class);
      ((Intent)localObject1).putExtra("tab_index", 0);
      ((Intent)localObject1).setFlags(67108864);
      this.a.startActivity((Intent)localObject1);
      this.a.finish();
      if ((QLog.isColorLevel()) && (paramSubAccountBackProtocData != null))
      {
        localObject2 = new StringBuilder().append("onBindSubAccount:");
        if (!paramBoolean) {
          break label859;
        }
      }
    }
    label859:
    for (Object localObject1 = "..success";; localObject1 = "...failed..")
    {
      QLog.d("Q.subaccount.SubAccountBindActivity", 2, (String)localObject1 + " ...errorMsg = " + paramSubAccountBackProtocData.a + "...errorType = " + paramSubAccountBackProtocData.p);
      return;
      switch (paramSubAccountBackProtocData.p)
      {
      default: 
        localObject2 = this.a.getString(2131561710);
        localObject1 = localObject2;
        if (paramSubAccountBackProtocData != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            localObject1 = paramSubAccountBackProtocData.a;
          }
        }
        this.a.a((String)localObject1);
        break;
      case 1002: 
        localObject1 = this.a.getString(2131562520);
        localObject2 = this.a.getString(2131563286);
        this.a.a((String)localObject1, (String)localObject2, new dqw(this));
        break;
      case 1003: 
        this.a.a(this.a.getString(2131563083));
        break;
      case 1004: 
        switch (paramSubAccountBackProtocData.q)
        {
        default: 
          localObject2 = paramSubAccountBackProtocData.a;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onBindSubAccount:bind error happen but msg is null shit, ");
            }
            localObject1 = this.a.getString(2131561710);
          }
          this.a.a((String)localObject1);
          break;
        case 1200: 
        case 1214: 
        case 1215: 
          localObject1 = this.a.getString(2131562520);
          localObject2 = this.a.getString(2131561673);
          this.a.a((String)localObject1, (String)localObject2, new dqx(this, paramSubAccountBackProtocData));
          break;
        case 1218: 
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            break;
          }
          localObject1 = this.a.b.a().getResources().getString(2131561469);
          this.a.a((String)localObject1);
          break;
        case 1232: 
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            break;
          }
          localObject1 = this.a.b.a().getResources().getString(2131563067);
          this.a.a((String)localObject1);
          break;
        case 1233: 
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            break;
          }
          localObject1 = this.a.b.a().getResources().getString(2131563066);
          this.a.a((String)localObject1);
          break;
        case 1240: 
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            break;
          }
          localObject1 = this.a.b.a().getResources().getString(2131563068);
          this.a.a((String)localObject1);
          break;
        case 1241: 
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            break;
          }
          localObject1 = this.a.b.a().getResources().getString(2131562530);
          this.a.a((String)localObject1);
          break;
        case 1242: 
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            break;
          }
          localObject1 = this.a.b.a().getResources().getString(2131562153);
          this.a.a((String)localObject1);
        }
        break;
      case 1011: 
        localObject2 = this.a.getString(2131561710);
        localObject1 = localObject2;
        if (paramSubAccountBackProtocData != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            localObject1 = paramSubAccountBackProtocData.a;
          }
        }
        this.a.a((String)localObject1);
        localObject1 = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject1).putExtra("subuin", paramSubAccountBackProtocData.c);
        this.a.startActivity((Intent)localObject1);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dqv
 * JD-Core Version:    0.7.0.1
 */