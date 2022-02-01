import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.util.HashMap;

public class acvz
  extends acuk
{
  public acvz(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 13);
    localBundle.putString("viewParam", paramString1);
    if (paramString2 != null) {
      localBundle.putString("entry", paramString2);
    }
    if (paramLong != 0L) {
      localBundle.putLong("vacreport_key_seq", paramLong);
    }
    if (paramBundle != null) {
      localBundle.putBundle("extra_pay_data", paramBundle);
    }
    VACDReportUtil.b(paramLong, null, "loadPluginStart", null, 0, null);
    QWalletPayBridge.launchForeground((Activity)this.context, this.app, localBundle);
    return true;
  }
  
  private boolean acH()
  {
    if (!(this.context instanceof BaseActivity)) {
      return false;
    }
    QWalletHelper.launchQWalletAct((BaseActivity)this.context, this.app, true, false);
    return true;
  }
  
  private boolean e(String paramString1, String paramString2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 13);
    localBundle.putString("viewParam", paramString1);
    if (paramString2 != null) {
      localBundle.putString("entry", paramString2);
    }
    paramString1 = new Intent(this.context, JumpActivity.class);
    paramString1.putExtra("srvBundle", localBundle);
    if (paramLong != 0L) {
      paramString1.putExtra("vacreport_key_seq", paramLong);
    }
    paramString1.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=10&entry=" + paramString2 + "&seq=" + paramLong));
    this.context.startActivity(paramString1);
    return true;
  }
  
  public boolean ace()
  {
    for (;;)
    {
      try
      {
        if (("0".equals(this.attrs.get("viewtype"))) && (!TextUtils.isEmpty((CharSequence)this.attrs.get("src_type"))) && ((this.attrs.get("view") == null) || ("0".equals(this.attrs.get("view"))))) {
          return acH();
        }
        if (("0".equals(this.attrs.get("viewtype"))) && (!TextUtils.isEmpty((CharSequence)this.attrs.get("src_type"))))
        {
          if (!this.attrs.containsKey("entry")) {
            break label461;
          }
          str1 = (String)this.attrs.get("entry");
          if (!this.attrs.containsKey("seq")) {
            break label467;
          }
          str2 = (String)this.attrs.get("seq");
          l1 = 0L;
          bool = TextUtils.isEmpty(str2);
          if (bool) {
            break label456;
          }
        }
      }
      catch (Exception localException1)
      {
        String str1;
        boolean bool;
        long l2;
        Bundle localBundle;
        QLog.e("QwalletToHomeAction", 1, "doAction error: " + localException1.getMessage());
        Ge("QwalletToHomeAction");
        return false;
      }
      try
      {
        l2 = Long.valueOf(str2).longValue();
        l1 = l2;
        VACDReportUtil.b(l2, "", "jumpParse", null, 0, null);
        l1 = l2;
      }
      catch (Exception localException2)
      {
        Object localObject;
        continue;
      }
      String str2 = (String)this.attrs.get("view");
      if (("1".equals(str2)) || ("2".equals(str2)) || ("3".equals(str2)) || ("4".equals(str2)) || ("5".equals(str2)) || ("6".equals(str2)) || ("7".equals(str2)) || ("9".equals(str2)) || ("10".equals(str2)) || ("11".equals(str2)))
      {
        localBundle = new Bundle();
        if (this.attrs.containsKey("tokenid")) {
          localBundle.putString("tokenid", (String)this.attrs.get("tokenid"));
        }
        if (this.attrs.containsKey("data")) {
          localBundle.putString("data", (String)this.attrs.get("data"));
        }
        return a(str2, str1, l1, localBundle);
      }
      if ("8".equals(str2))
      {
        bool = e(str2, str1, l1);
        return bool;
      }
      return false;
      label456:
      long l1 = 0L;
      continue;
      label461:
      localObject = null;
      continue;
      label467:
      str2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvz
 * JD-Core Version:    0.7.0.1
 */