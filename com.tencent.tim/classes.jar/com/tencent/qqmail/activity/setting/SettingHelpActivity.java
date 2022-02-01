package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import com.alibaba.fastjson.JSONArray;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer;
import com.tencent.qqmail.utilities.WebviewUtilities;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.QMWebView;

public class SettingHelpActivity
  extends WebViewExplorer
{
  private boolean ableFlingToBack = false;
  private JSONArray sceneArray;
  
  public static Intent createIntent(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingHelpActivity.class);
    localIntent.putExtra("url", paramString);
    return localIntent;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772421, 2130772420);
  }
  
  public void initTopBar()
  {
    this.topBar.setButtonLeftBack().setButtonLeftOnclickListener(new SettingHelpActivity.1(this));
    this.topBar.setTitle(2131719843);
    this.topBar.setButtonRightBlue(2131691897);
    this.topBar.getButtonRight().setOnClickListener(new SettingHelpActivity.2(this));
  }
  
  public void initWebView()
  {
    super.initWebView();
    if (Build.VERSION.SDK_INT >= 21) {
      this.mWebView.getSettings().setMixedContentMode(0);
    }
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      this.ableFlingToBack = WebviewUtilities.isOnLeftEdge(this.mWebView);
    }
    return this.ableFlingToBack;
  }
  
  public void updateTitle(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingHelpActivity
 * JD-Core Version:    0.7.0.1
 */