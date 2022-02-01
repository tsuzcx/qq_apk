import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

class uhw
  extends WtloginObserver
{
  uhw(uhv paramuhv) {}
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AutoLoginHelper", 2, "OnGetStViaSMSVerifyLogin  userAccount = " + paramString + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("AutoLoginHelper", 2, "OnGetStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    if (paramInt2 == 0) {}
    do
    {
      return;
      uhv.a(this.this$0);
    } while (uhv.a(this.this$0) == null);
    paramString = new Intent(uhv.a(this.this$0), LoginActivity.class);
    paramString.putExtra("uin", uhv.a(this.this$0));
    paramString.putExtra("tab_index", MainFragment.bIk);
    paramString.addFlags(131072);
    uhv.a(this.this$0).startActivity(paramString);
    uhv.a(this.this$0).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhw
 * JD-Core Version:    0.7.0.1
 */