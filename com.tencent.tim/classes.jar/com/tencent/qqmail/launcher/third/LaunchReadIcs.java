package com.tencent.qqmail.launcher.third;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.Window;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

public class LaunchReadIcs
  extends ThirdLauncherActivity
{
  public static final String TAG = "LaunchReadIcs";
  
  protected void route()
  {
    getWindow().setWindowAnimations(0);
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    getWindow().setBackgroundDrawable(localColorDrawable);
    setContentView(2131559460);
    try
    {
      if (!"android.intent.action.VIEW".equals(getIntent().getAction())) {
        return;
      }
      if (AccountManager.shareInstance().getAccountList().size() == 0)
      {
        SharedPreferenceUtil.setShownWelcomePage(true);
        startActivity(AccountTypeListActivity.createIntent());
        finish();
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "LaunchReadIcs", localException.getMessage());
      return;
    }
    Object localObject = getIntent().getParcelableExtra("android.intent.extra.STREAM");
    if ((localObject instanceof Uri))
    {
      localObject = (Uri)localObject;
      localObject = CommUtils.contentUri2Path(QMApplicationContext.sharedInstance(), (Uri)localObject);
      if ((localObject == null) || (((String)localObject).equals("")))
      {
        Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131690557), 0).show();
        QMLog.log(4, "LaunchReadIcs", "handleCommand. file not exist");
        return;
      }
      startActivity(MailFragmentActivity.createIntentToReadIcsEvent((String)localObject));
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.third.LaunchReadIcs
 * JD-Core Version:    0.7.0.1
 */