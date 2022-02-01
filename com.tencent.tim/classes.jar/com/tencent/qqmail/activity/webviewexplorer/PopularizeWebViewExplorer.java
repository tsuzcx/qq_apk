package com.tencent.qqmail.activity.webviewexplorer;

import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.uma.QMUmaManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMTopBar;

public class PopularizeWebViewExplorer
  extends WebViewExplorer
{
  private static final String ANIMATION_TYPE = "animation_type";
  private static final String ARG_ID = "arg_id";
  private static final String ARG_URL = "arg_url";
  private static final String TAG = "PopularizeWebViewExplorer";
  private int animationType;
  private boolean isLeftEdgeDrag = false;
  protected Popularize popularize;
  
  public static Intent createIntent(String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), PopularizeWebViewExplorer.class);
    localIntent.putExtra("arg_url", paramString);
    localIntent.putExtra("arg_id", paramInt1);
    localIntent.putExtra("animation_type", paramInt2);
    return localIntent;
  }
  
  public void finish()
  {
    super.finish();
    if (this.animationType == 1) {
      overridePendingTransition(0, 2130772402);
    }
    while (this.animationType != 2) {
      return;
    }
    overridePendingTransition(2130772421, 2130772420);
  }
  
  public void initDataSource()
  {
    super.initDataSource();
    int i = getIntent().getIntExtra("arg_id", 0);
    this.popularize = PopularizeManager.sharedInstance().getPopularizeById(i);
    if (this.popularize != null)
    {
      this.title = this.popularize.getSubject();
      Object localObject = AccountManager.shareInstance().getAccountList().getFirstQQMailAccount();
      if (localObject != null) {
        this.mAccountId = ((QQMailAccount)localObject).getId();
      }
      localObject = getIntent().getStringExtra("arg_url");
      if (localObject != null) {}
      for (this.url = ((String)localObject);; this.url = this.popularize.getOpenUrl())
      {
        if (this.popularize.getSessionType() == 2) {
          initUrlWithVidSession(this.url);
        }
        return;
      }
    }
    QMLog.log(6, "PopularizeWebViewExplorer", "popularize null : " + i);
    finish();
  }
  
  protected void initTopBar()
  {
    super.initTopBar();
    if ((this.popularize != null) && ((this.popularize.getType() == 4) || (this.popularize.getType() == 0) || (this.popularize.getType() == 10)))
    {
      this.topBar.setButtonLeftIcon(2130841088);
      return;
    }
    this.topBar.setButtonLeftBack();
  }
  
  public void initUI()
  {
    super.initUI();
    this.animationType = getIntent().getIntExtra("animation_type", 0);
    if (this.animationType == 1) {
      overridePendingTransition(2130772401, 2130772430);
    }
    while (this.animationType != 2) {
      return;
    }
    overridePendingTransition(2130772422, 2130772419);
  }
  
  protected void initUrlWithVidSession(String paramString)
  {
    this.url = (paramString + "&vid=" + QMApplicationContext.sharedInstance().getVid() + "&session=" + Uri.encode(QMUmaManager.sharedInstance().getEncodeUmaSession()));
  }
  
  protected void loadUrlWithToken()
  {
    super.loadUrlWithToken();
    DataCollector.logEvent("Event_Ad_Webview_Show");
    if (shouldLoadUrlWithToken()) {
      DataCollector.logEvent("Event_Ad_Webview_Token_Show");
    }
    for (;;)
    {
      DataCollector.submit();
      return;
      DataCollector.logEvent("Event_Ad_Webview_NoToken_Show");
    }
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    if ((this.popularize != null) && ((this.popularize.getType() == 4) || (this.popularize.getType() == 0))) {
      return false;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getRawX() < QMUIKit.getScreenWidth() / 5)) {
      this.isLeftEdgeDrag = true;
    }
    return this.isLeftEdgeDrag;
  }
  
  public Intent onLastFinish()
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    if (localAccountList.size() == 0) {
      return AccountTypeListActivity.createIntent(true);
    }
    if (localAccountList.size() == 1) {
      return MailFragmentActivity.createIntentToFolderList(localAccountList.get(0).getId());
    }
    return MailFragmentActivity.createIntentToAccountList();
  }
  
  protected boolean shouldLoadUrlWithToken()
  {
    return (this.popularize != null) && (this.popularize.getSessionType() == 1);
  }
  
  protected void updateTitle(String paramString)
  {
    if ((this.popularize != null) && (this.popularize.getSubject() != null))
    {
      this.title = this.popularize.getSubject();
      this.topBar.setTitle(this.title);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.PopularizeWebViewExplorer
 * JD-Core Version:    0.7.0.1
 */