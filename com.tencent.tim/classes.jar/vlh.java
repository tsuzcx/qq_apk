import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class vlh
  extends aclm
{
  public vlh(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void bh(int paramInt, String paramString)
  {
    Object localObject = this.a;
    RelativeLayout localRelativeLayout = this.a.fY;
    if (paramInt == 0) {}
    for (int i = 1;; i = 3)
    {
      PhoneUnityBindInfoActivity.a((PhoneUnityBindInfoActivity)localObject, localRelativeLayout, i, 2);
      if (paramInt != 0)
      {
        if (paramInt != 39) {
          break;
        }
        anot.a(this.a.app, "CliOper", "", "", "0X8005BFD", "0X8005BFD", 0, 0, "", "", "", "");
        aqha.a(this.a, 230, this.a.getString(2131696796), this.a.getString(2131696795), null, this.a.getString(2131693212), new vlm(this), null).show();
      }
      return;
    }
    localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = this.a.getString(2131696794);
    }
    QQToast.a(this.a, (CharSequence)localObject, 0).show(this.a.getTitleBarHeight());
  }
  
  public void v(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.isFinishing()) {
      return;
    }
    QLog.i("IphoneTitleBarActivity", 1, "onGetPhoneUnityInfo, success=" + paramBoolean);
    if (paramBoolean)
    {
      ausj localausj = this.a.mActionSheet;
      if (localausj != null) {
        localausj.dismiss();
      }
    }
    for (;;)
    {
      PhoneUnityBindInfoActivity.a(this.a, paramBoolean, paramBundle, true);
      return;
      PhoneUnityBindInfoActivity.a(this.a, 2131696664);
    }
  }
  
  public void w(boolean paramBoolean, Bundle paramBundle)
  {
    QLog.i("IphoneTitleBarActivity", 1, "onSetPhoneUnityInfo, success=" + paramBoolean);
    PhoneUnityBindInfoActivity.a(this.a);
    if (this.a.isFinishing()) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            return;
            if (paramBoolean) {
              break label456;
            }
            if (paramBundle == null) {
              break label420;
            }
            this.a.ad = paramBundle;
            localObject = this.a;
            i = paramBundle.getInt("sso_result", -1);
            QLog.i("IphoneTitleBarActivity", 1, "onSetPhoneUnityInfo, fail, result=" + i);
            if (i != 66) {
              break;
            }
            if (this.a.H == null)
            {
              this.a.H = aqha.a((Context)localObject, 230, acfp.m(2131709547), "该手机号码已绑定一个无密码的QQ号，需给原QQ号设置密码后才能解绑并绑定新QQ号。", null, acfp.m(2131709544), new vli(this), null);
              this.a.H.setOnCancelListener(new vlj(this));
            }
            if ((this.a.H != null) && (!this.a.H.isShowing()) && (!this.a.isFinishing()))
            {
              this.a.H.show();
              this.a.aZd = true;
            }
            paramBundle = this.a.mActionSheet;
          } while (paramBundle == null);
          paramBundle.dismiss();
          return;
          if (i != 65) {
            break;
          }
          if (this.a.I == null)
          {
            this.a.I = aqha.a((Context)localObject, 230, acfp.m(2131709537), acfp.m(2131709533), null, acfp.m(2131709525), new vlk(this), null);
            this.a.I.setOnCancelListener(new vll(this));
          }
          if ((this.a.I != null) && (!this.a.I.isShowing()) && (!this.a.isFinishing()))
          {
            this.a.I.show();
            this.a.aZd = true;
          }
          paramBundle = this.a.mActionSheet;
        } while (paramBundle == null);
        paramBundle.dismiss();
        return;
      } while (!paramBundle.containsKey("skip_url"));
      paramBundle = paramBundle.getString("skip_url");
    } while (TextUtils.isEmpty(paramBundle));
    QLog.i("IphoneTitleBarActivity", 1, "onSetPhoneUnityInfo, startVerifyActivity");
    PhoneUnityBindInfoActivity.a(this.a, paramBundle);
    return;
    label420:
    QQToast.a(this.a, this.a.getString(2131696775), 0).show(this.a.getTitleBarHeight());
    this.a.finish();
    return;
    label456:
    if (paramBoolean)
    {
      localObject = this.a.mActionSheet;
      if (localObject != null) {
        ((ausj)localObject).dismiss();
      }
      anot.a(this.a.app, "CliOper", "", "", "0X8005D0B", "0X8005D0B", 0, 0, "", "", "", "");
      PhoneUnityBindInfoActivity.a(this.a, paramBoolean, paramBundle, true);
      return;
    }
    PhoneUnityBindInfoActivity.b(this.a, acfp.m(2131709527));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vlh
 * JD-Core Version:    0.7.0.1
 */