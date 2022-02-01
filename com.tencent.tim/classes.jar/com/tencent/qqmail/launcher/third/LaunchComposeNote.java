package com.tencent.qqmail.launcher.third;

import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.launcher.base.LauncherUtils;
import com.tencent.qqmail.model.InterAppsManager;
import moai.oss.KvHelper;

public class LaunchComposeNote
  extends ThirdLauncherActivity
{
  public static final String TAG = "LaunchComposeNote";
  
  protected void route()
  {
    super.initDataSource();
    KvHelper.externalShareComposeNote(new double[0]);
    KvHelper.externalShare(new double[0]);
    getWindow().setWindowAnimations(0);
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    getWindow().setBackgroundDrawable(localColorDrawable);
    setContentView(2131559460);
    InterAppsManager.getInstance().handleCommand(getIntent());
    LauncherUtils.goTo(this, ComposeNoteActivity.class);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.third.LaunchComposeNote
 * JD-Core Version:    0.7.0.1
 */