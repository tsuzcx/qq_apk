package com.tencent.qqmail.nativepages;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.moai.nativepages.AdLandingPagesUI;
import com.tencent.moai.nativepages.util.DataUtil;
import com.tencent.moai.nativepages.util.LogUtil;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.readmail.model.VirtualAdManager;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import moai.oss.KvHelper;

public class NativePagesActivity
  extends AdLandingPagesUI
{
  private static final String POPULARIZE_ID = "POPULARIZE_ID";
  public static final String TAG = "NativePagesActivity";
  private Popularize popularize;
  private int popularizeId;
  private String shareUrl;
  private long startEnterTimeNew;
  
  public static Intent createIntent(String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), NativePagesActivity.class);
    localIntent.putExtra("ARG_LANDING_PAGE_XML", paramString1);
    localIntent.putExtra("ARG_LANDING_PAGE_XML_PREFIX", paramString2);
    localIntent.putExtra("POPULARIZE_ID", paramInt);
    return localIntent;
  }
  
  private void forwardMail()
  {
    DataCollector.logEvent("Event_AD_Mail_Forward");
    Account localAccount = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
    if (localAccount != null) {
      startActivity(ComposeMailActivity.createIntentForVirtualAdsMail(localAccount.getId(), getShareHtml(), this.popularize.getSubject()));
    }
  }
  
  private String getShareHtml()
  {
    return "<a href=\"" + getShareUrl() + "\"><img src=\"" + this.popularize.getSubImageUrl() + "\"></a>";
  }
  
  private String getShareUrl()
  {
    if (TextUtils.isEmpty(this.shareUrl)) {
      this.shareUrl = VirtualAdManager.getInstance().appendPopularizeUrlRequestParams(this.popularize);
    }
    return this.shareUrl;
  }
  
  private void unlike()
  {
    DataCollector.logEvent("Event_AD_Mail_Delete");
    VirtualAdManager.getInstance().reportDeleteOrUnLike(1, this.popularize);
    PopularizeUIHelper.handleCancel(this.popularize);
    finish();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772421, 2130772420);
  }
  
  public void more()
  {
    Object localObject = new QMBottomDialog.BottomListSheetBuilder(this);
    ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(2130840816, getString(2131696180), getString(2131696180));
    ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(2130840843, getString(2131696181), getString(2131696181));
    ((QMBottomDialog.BottomListSheetBuilder)localObject).setOnSheetItemClickListener(new NativePagesActivity.3(this));
    localObject = ((QMBottomDialog.BottomListSheetBuilder)localObject).build();
    ((QMBottomDialog)localObject).setOnDismissListener(new NativePagesActivity.4(this));
    ((QMBottomDialog)localObject).show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    overridePendingTransition(2130772422, 2130772419);
    this.popularizeId = getIntent().getExtras().getInt("POPULARIZE_ID");
    this.popularize = PopularizeManager.sharedInstance().getPopularizeById(this.popularizeId);
    this.popularize.setIsRead(true);
    PopularizeManager.sharedInstance().updatePopularizeIsRead(true, this.popularize);
    DataUtil.setDelegate(new NativePagesActivity.1(this));
    LogUtil.setDelegate(new NativePagesActivity.2(this));
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.startEnterTimeNew != 0L) && ((System.currentTimeMillis() - this.startEnterTimeNew) / 1000L > 0L)) {
      KvHelper.detaileventAdMailWatchTimeNew(new double[] { (System.currentTimeMillis() - this.startEnterTimeNew) / 1000L });
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.startEnterTimeNew = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.nativepages.NativePagesActivity
 * JD-Core Version:    0.7.0.1
 */