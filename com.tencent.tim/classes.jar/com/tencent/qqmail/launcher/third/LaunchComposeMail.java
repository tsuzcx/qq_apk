package com.tencent.qqmail.launcher.third;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.launcher.base.LauncherUtils;
import com.tencent.qqmail.model.uidomain.SendMailInterAppsManager;
import com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler;
import moai.oss.KvHelper;

public class LaunchComposeMail
  extends ThirdLauncherActivity
{
  private static final String TAG = "LaunchComposeMail";
  
  protected void route()
  {
    KvHelper.externalShareComposeMail(new double[0]);
    KvHelper.externalShare(new double[0]);
    boolean bool;
    if (LauncherUtils.isFromWeChat(getIntent()))
    {
      KvHelper.externalShareComposeMailFromWechat(new double[0]);
      if (LauncherUtils.actionTypeIsViewOrEdit(getIntent())) {
        KvHelper.externalShareFromViewOrEditAction(new double[0]);
      }
      getWindow().setWindowAnimations(0);
      Object localObject = new ColorDrawable(0);
      getWindow().setBackgroundDrawable((Drawable)localObject);
      setContentView(2131559460);
      localObject = SendMailInterAppsManager.getInstance();
      ((SendMailInterAppsManager)localObject).handleCommand(getIntent());
      if ((!((SendMailInterAppsManager)localObject).hasTo()) && (TextUtils.isEmpty(((SendMailInterAppsManager)localObject).getSubject())) && (TextUtils.isEmpty(((SendMailInterAppsManager)localObject).getContent()))) {
        break label169;
      }
      bool = LauncherUtils.goTo(this, ComposeMailActivity.class);
    }
    for (;;)
    {
      if ((bool) && (QMActivityManager.shareInstance().getActivitySize() > 1))
      {
        ThirdPartyCallDialogHelpler.dimissIfExist();
        if (LauncherUtils.ignoreShare(this))
        {
          finishWithNoCheck();
          return;
          if (!LauncherUtils.isFromQQ(getIntent())) {
            break;
          }
          KvHelper.externalShareComposeMailFromQq(new double[0]);
          break;
          label169:
          bool = LauncherUtils.goTo(this, MailFragmentActivity.class);
          continue;
        }
        QMActivityManager.shareInstance().finishAllActivity(this);
      }
    }
    finishWithNoCheck();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.third.LaunchComposeMail
 * JD-Core Version:    0.7.0.1
 */