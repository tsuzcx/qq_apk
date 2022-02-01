package com.tencent.qqmail.activity.webviewexplorer;

import android.content.Intent;
import android.view.MotionEvent;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.view.QMTopBar;

public class SimpleWebViewExplorer
  extends WebViewExplorer
{
  protected static final String ARG_SHOW_GESTURE_PWD = "arg_show_gesture_pwd";
  public static String ARG_TOPBAR_LEFT_STYLE = "topbar_left_style";
  public static int TOPBAR_LEFT_BUTTON = 1;
  public static int TOPBAR_LEFT_ICON = 0;
  private int topbar_left_style = 0;
  
  private static Intent createIntent(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SimpleWebViewExplorer.class);
    localIntent.putExtra("url", paramString);
    return localIntent;
  }
  
  public static Intent createIntent(String paramString, int paramInt)
  {
    paramString = createIntent(paramString);
    paramString.putExtra(ARG_TOPBAR_LEFT_STYLE, paramInt);
    paramString.addFlags(268435456);
    return paramString;
  }
  
  public static Intent createIntent(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SimpleWebViewExplorer.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra(ARG_TOPBAR_LEFT_STYLE, paramInt1);
    localIntent.putExtra("accountid", paramInt2);
    localIntent.putExtra("is_edit_attach", paramBoolean);
    return localIntent;
  }
  
  private static Intent createIntent(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SimpleWebViewExplorer.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("title", paramString2);
    return localIntent;
  }
  
  public static Intent createIntent(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = createIntent(paramString1, paramString2);
    paramString1.putExtra(ARG_TOPBAR_LEFT_STYLE, paramInt);
    return paramString1;
  }
  
  public static Intent createIntent(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = createIntent(paramString1, paramString2);
    if (paramBoolean) {
      paramString1.putExtra("arg_show_gesture_pwd", true);
    }
    return paramString1;
  }
  
  public static Intent createIntent(String paramString, boolean paramBoolean)
  {
    paramString = createIntent(paramString);
    if (paramBoolean) {
      paramString.putExtra("arg_show_gesture_pwd", true);
    }
    return paramString;
  }
  
  public boolean checkGesturePassword()
  {
    return getIntent().getBooleanExtra("arg_show_gesture_pwd", false);
  }
  
  public void finish()
  {
    Object localObject = null;
    if (QMActivityManager.shareInstance().getActivitySize() <= 1)
    {
      Intent localIntent = onLastFinish();
      localObject = localIntent;
      if (localIntent != null)
      {
        startActivity(localIntent);
        localObject = localIntent;
      }
    }
    super.finish();
    onOverridePendingTransitionInFinish(localObject);
  }
  
  protected void initTopBar()
  {
    this.topbar_left_style = getIntent().getIntExtra(ARG_TOPBAR_LEFT_STYLE, TOPBAR_LEFT_ICON);
    if (this.topbar_left_style == TOPBAR_LEFT_ICON) {
      this.topBar.setButtonLeftBack().setButtonLeftOnclickListener(new SimpleWebViewExplorer.1(this));
    }
    while (this.topbar_left_style != TOPBAR_LEFT_BUTTON) {
      return;
    }
    this.topBar.setButtonLeftIcon(2130841088);
    this.topBar.setOnlyButtonLeftIconOnClickListener(new SimpleWebViewExplorer.2(this));
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return this.topbar_left_style != TOPBAR_LEFT_BUTTON;
  }
  
  public void onOverridePendingTransition()
  {
    if (this.topbar_left_style == TOPBAR_LEFT_BUTTON)
    {
      overridePendingTransition(2130772401, 2130772430);
      return;
    }
    if (this.topbar_left_style == TOPBAR_LEFT_ICON)
    {
      overridePendingTransition(2130772422, 2130772419);
      return;
    }
    super.onOverridePendingTransition();
  }
  
  public void onOverridePendingTransitionInFinish(Intent paramIntent)
  {
    if (this.topbar_left_style == TOPBAR_LEFT_BUTTON)
    {
      overridePendingTransition(0, 2130772402);
      return;
    }
    if (this.topbar_left_style == TOPBAR_LEFT_ICON)
    {
      overridePendingTransition(2130772421, 2130772420);
      return;
    }
    super.onOverridePendingTransitionInFinish(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.SimpleWebViewExplorer
 * JD-Core Version:    0.7.0.1
 */