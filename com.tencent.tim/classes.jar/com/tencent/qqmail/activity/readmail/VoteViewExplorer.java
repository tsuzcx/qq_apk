package com.tencent.qqmail.activity.readmail;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.QMWebView;

public class VoteViewExplorer
  extends WebViewExplorer
{
  public static final String ARG_HTML_CONTENT = "html-content";
  public static final String ARG_TITLE = "title";
  private static final String ENCODING = "utf-8";
  private static final String MIME_TYPE = "text/html";
  
  public static Intent createIntent(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new Intent(paramContext, VoteViewExplorer.class);
    paramContext.putExtra("html-content", paramString1);
    paramContext.putExtra("title", paramString2);
    return paramContext;
  }
  
  public void initTopBar()
  {
    this.topBar.onWindowFocusChanged(true);
    this.topBar.setTitle(getIntent().getStringExtra("title"));
    this.topBar.setButtonLeftIcon(2130841088);
    this.topBar.setButtonLeftOnclickListener(new VoteViewExplorer.1(this));
  }
  
  public void loadUrlWithToken()
  {
    String str = getIntent().getStringExtra("html-content");
    this.mWebView.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
  }
  
  public void onOverridePendingTransition()
  {
    overridePendingTransition(2130772401, 2130772430);
  }
  
  public void onOverridePendingTransitionInFinish(Intent paramIntent)
  {
    overridePendingTransition(0, 2130772402);
  }
  
  public void updateTitle(String paramString)
  {
    paramString = getIntent().getStringExtra("title");
    if (paramString != null) {
      this.topBar.setTitle(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.VoteViewExplorer
 * JD-Core Version:    0.7.0.1
 */