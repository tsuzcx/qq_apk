package com.tencent.qqmail.launcher.third;

import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.qqmail.ftn.activity.FtnListActivity;
import com.tencent.qqmail.launcher.base.LauncherUtils;
import com.tencent.qqmail.model.InterAppsManager;
import moai.oss.KvHelper;

public class LaunchFtnUpload
  extends ThirdLauncherActivity
{
  public static final String TAG = "LaunchFtnUpload";
  
  protected void route()
  {
    KvHelper.externalShareFtn(new double[0]);
    KvHelper.externalShare(new double[0]);
    if (LauncherUtils.isFromWeChat(getIntent())) {
      KvHelper.externalShareFtnFromWechat(new double[0]);
    }
    for (;;)
    {
      if (LauncherUtils.actionTypeIsViewOrEdit(getIntent())) {
        KvHelper.externalShareFromViewOrEditAction(new double[0]);
      }
      getWindow().setWindowAnimations(0);
      ColorDrawable localColorDrawable = new ColorDrawable(0);
      getWindow().setBackgroundDrawable(localColorDrawable);
      setContentView(2131559460);
      InterAppsManager.getInstance().handleCommand(getIntent());
      LauncherUtils.goTo(this, FtnListActivity.class);
      finish();
      return;
      if (LauncherUtils.isFromQQ(getIntent())) {
        KvHelper.externalShareFtnFromQq(new double[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.third.LaunchFtnUpload
 * JD-Core Version:    0.7.0.1
 */