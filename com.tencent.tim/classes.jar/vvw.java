import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class vvw
  extends acmf
{
  public vvw(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  protected void b(boolean paramBoolean, anxs paramanxs)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramanxs != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() mainAccount=" + paramanxs.aLa + " subAccount=" + paramanxs.aQf + " errType=" + paramanxs.errorType + " errMsg=" + paramanxs.errorMsg);
      }
    }
    this.a.ath();
    Object localObject2;
    if (paramBoolean)
    {
      this.a.wA(this.a.getString(2131720543));
      anxj.dZ(this.a.app);
      this.a.getActivity().setTitle("");
      this.a.finish();
      if ((QLog.isColorLevel()) && (paramanxs != null))
      {
        localObject2 = new StringBuilder().append("onBindSubAccount:");
        if (!paramBoolean) {
          break label873;
        }
      }
    }
    label873:
    for (Object localObject1 = "..success";; localObject1 = "...failed..")
    {
      QLog.d("SUB_ACCOUNT", 2, (String)localObject1 + " ...errorMsg = " + paramanxs.errorMsg + "...errorType = " + paramanxs.errorType);
      do
      {
        return;
      } while (paramanxs == null);
      switch (paramanxs.errorType)
      {
      default: 
        localObject2 = this.a.getString(2131720532);
        localObject1 = localObject2;
        if (paramanxs != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramanxs.errorMsg)) {
            localObject1 = paramanxs.errorMsg;
          }
        }
        this.a.wz((String)localObject1);
        break;
      case 1002: 
        anxk.a(this.a.app, this.a);
        break;
      case 1003: 
        this.a.wz(this.a.getString(2131720533));
        break;
      case 1004: 
        switch (paramanxs.serverErrorType)
        {
        default: 
          localObject2 = paramanxs.errorMsg;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onBindSubAccount:bind error happen but msg is null shit, ");
            }
            localObject1 = this.a.getString(2131720532);
          }
          this.a.wz((String)localObject1);
          break;
        case 1200: 
        case 1214: 
        case 1215: 
          localObject1 = this.a.getString(2131720583);
          localObject2 = this.a.getString(2131720535);
          this.a.a((String)localObject1, (String)localObject2, new vvx(this, paramanxs));
          break;
        case 1218: 
          if (!TextUtils.isEmpty(paramanxs.errorMsg)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131718993);
          this.a.wz((String)localObject1);
          break;
        case 1232: 
          if (!TextUtils.isEmpty(paramanxs.errorMsg)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131720536);
          this.a.wz((String)localObject1);
          break;
        case 1233: 
          if (!TextUtils.isEmpty(paramanxs.errorMsg)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131720526);
          this.a.wz((String)localObject1);
          break;
        case 1240: 
          if (!TextUtils.isEmpty(paramanxs.errorMsg)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131720539);
          this.a.wz((String)localObject1);
          break;
        case 1241: 
          if (!TextUtils.isEmpty(paramanxs.errorMsg)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131720525);
          this.a.wz((String)localObject1);
          break;
        case 1242: 
          if (!TextUtils.isEmpty(paramanxs.errorMsg)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131720541);
          this.a.wz((String)localObject1);
        }
        break;
      case 1011: 
        localObject2 = this.a.getString(2131720532);
        localObject1 = localObject2;
        if (paramanxs != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramanxs.errorMsg)) {
            localObject1 = paramanxs.errorMsg;
          }
        }
        this.a.wz((String)localObject1);
        localObject1 = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject1).putExtra("subuin", paramanxs.aQf);
        ((Intent)localObject1).putExtra("fromWhere", this.a.aOa);
        this.a.startActivity((Intent)localObject1);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vvw
 * JD-Core Version:    0.7.0.1
 */