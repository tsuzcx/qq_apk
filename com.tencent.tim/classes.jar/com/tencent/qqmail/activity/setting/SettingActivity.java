package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.helper.LoginUIHelper;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.List;

public class SettingActivity
  extends BaseActivityEx
{
  public static int ADDACCOUNT = 0;
  public static int ADDING = 1;
  public static int ADDSUCCESS = 2;
  private static final String ARG_CLEAR_CACHE = "arg_clear_cache";
  private static final String ARG_FROM = "arg_from";
  public static int NOADD = 0;
  private static final String TAG = "SettingActivity";
  private UITableItemView aboutItemView;
  private final UITableView.ClickListener accountListOnClickListener = new SettingActivity.3(this);
  private AccountList accts;
  private UITableItemView adMailAggregateItemView;
  private final UITableView.ClickListener appRelationListOnClickListener = new SettingActivity.10(this);
  private UITableView.ClickListener appTableOnClickListener = new SettingActivity.8(this);
  private UITableItemView attachmentManageItemView;
  private UITableItemView autoLoadPicItemView;
  private UITableItemView bookMailAggregateItemView;
  private UITableView.ClickListener clearCacheTableOnClickListener = new SettingActivity.7(this);
  private UITableItemView developerItemView;
  private UITableItemView inquireMailItemView;
  private UITableView mAboutListTableView;
  private UITableView mAccountListTableView;
  private final UITableView.ClickListener mAppOptionListOnClickListener = new SettingActivity.6(this);
  private UITableView mAppOptionListTableView;
  private UITableView mAppTableView;
  private UITableItemView mBlackNameListItemView;
  private UITableItemView mCacheItemView;
  private UITableItemView mClearCacheItemView;
  private UITableView mClearCacheTableView;
  private UITableItemView mExitUserItemView;
  private UITableView mExitUserTableView;
  private UITableView mMailOptionListTableView;
  private UITableView mNewMailRemindTableView;
  private UITableItemView mSendMailSoundItemView;
  private QMBaseView mSettingView;
  private UITableItemView mWeCallItemView;
  private UITableItemView mWhiteNameListItemView;
  private UITableView.ClickListener mailContentServiceTableOnClickListener = new SettingActivity.9(this);
  private final UITableView.ClickListener mailOptionListOnClickListener = new SettingActivity.5(this);
  private final UITableView.ClickListener newMailRemindOnClickListener = new SettingActivity.4(this);
  private UITableItemView replyForwardSubjectItemView;
  private UITableItemView showMailListHeadItemView;
  private String sizeBeforeClean;
  private UITableItemView suggestItemView;
  
  private void createAboutListTableView()
  {
    this.mAboutListTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mAboutListTableView);
    this.suggestItemView = this.mAboutListTableView.addItem(2131719843);
    if (AccountManager.shareInstance().getAccountList().hasQQMailAccounts()) {
      this.inquireMailItemView = this.mAboutListTableView.addItem(2131694977);
    }
    this.aboutItemView = this.mAboutListTableView.addItem(2131689594);
    this.developerItemView = this.mAboutListTableView.addItem(getString(2131719822));
    this.mAboutListTableView.setClickListener(this.appRelationListOnClickListener);
    this.mAboutListTableView.commit();
    this.mAboutListTableView.setVisibility(8);
  }
  
  private void createAccountListTableView()
  {
    this.mAccountListTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mAccountListTableView);
    this.mAccountListTableView.setClickListener(this.accountListOnClickListener);
  }
  
  private void createAppOptionListTableView()
  {
    this.mAppOptionListTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mAppOptionListTableView);
    this.mAppOptionListTableView.setClickListener(this.mAppOptionListOnClickListener);
    this.mSendMailSoundItemView = this.mAppOptionListTableView.addItem(2131719950);
    this.mSendMailSoundItemView.setChecked(QMSettingManager.sharedInstance().getEnableSendMailSound());
    this.replyForwardSubjectItemView = this.mAppOptionListTableView.addItem(2131719939);
    this.mBlackNameListItemView = this.mAppOptionListTableView.addItem(2131719659);
    if (AccountManager.shareInstance().getAccountList().getQQAccountList().size() > 0) {
      this.mWhiteNameListItemView = this.mAppOptionListTableView.addItem(2131720013);
    }
    this.mAppOptionListTableView.commit();
  }
  
  private void createAppTableView()
  {
    this.mAppTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mAppTableView);
    this.mAppTableView.setClickListener(this.appTableOnClickListener);
    this.mAppTableView.addItem(2131690444);
    this.mAppTableView.commit();
    this.mAppTableView.setVisibility(8);
  }
  
  private void createClearCacheTableView()
  {
    this.mClearCacheTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mClearCacheTableView);
    this.mClearCacheTableView.setClickListener(this.clearCacheTableOnClickListener);
    this.mCacheItemView = this.mClearCacheTableView.addItem(2131719710);
    this.mClearCacheItemView = this.mClearCacheTableView.addItem(2131719653);
    this.mClearCacheItemView.setDetail(SettingAutoClearAttachmentsActivity.getClearLevel(), UITableItemView.STYLE_GRAY);
    this.mClearCacheTableView.commit();
  }
  
  private void createExitUser()
  {
    this.mExitUserTableView = new UITableView(this);
    this.mExitUserItemView = this.mExitUserTableView.addItem(2131693295);
    this.mExitUserItemView.hideArrow();
    this.mExitUserItemView.setDetail("");
    this.mExitUserTableView.setClickListener(new SettingActivity.11(this));
    this.mExitUserTableView.commit();
    this.mSettingView.addContentView(this.mExitUserTableView);
    this.mExitUserItemView.setVisibility(8);
  }
  
  public static Intent createIntent(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingActivity.class);
    localIntent.putExtra("arg_from", paramString);
    return localIntent;
  }
  
  public static Intent createIntentToClearCache(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingActivity.class);
    localIntent.putExtra("arg_from", paramString);
    localIntent.putExtra("arg_clear_cache", true);
    return localIntent;
  }
  
  private void createMailOptionListTableView()
  {
    this.mMailOptionListTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mMailOptionListTableView);
    this.mMailOptionListTableView.setClickListener(this.mailOptionListOnClickListener);
    this.showMailListHeadItemView = this.mMailOptionListTableView.addItem(2131719960);
    this.showMailListHeadItemView.setChecked(QMSettingManager.sharedInstance().getMailListIcon());
    this.adMailAggregateItemView = this.mMailOptionListTableView.addItem(2131719648);
    this.adMailAggregateItemView.setChecked(QMSettingManager.sharedInstance().getAggregateAdMail());
    this.bookMailAggregateItemView = this.mMailOptionListTableView.addItem(2131719977);
    this.bookMailAggregateItemView.setChecked(QMSettingManager.sharedInstance().getAggregateSubscribeMail());
    this.autoLoadPicItemView = this.mMailOptionListTableView.addItem(2131719886);
    this.autoLoadPicItemView.setDetail("", UITableItemView.STYLE_GRAY);
    int i = DownloadInfoManager.shareInstance().getUnCompletedCnt();
    this.attachmentManageItemView = this.mMailOptionListTableView.addItem(2131692945);
    UITableItemView localUITableItemView = this.attachmentManageItemView;
    if (i == 0) {}
    for (String str = "";; str = String.valueOf(i))
    {
      localUITableItemView.setDetail(str);
      this.mMailOptionListTableView.commit();
      return;
    }
  }
  
  private void createNewMailRemindTableView()
  {
    this.mNewMailRemindTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mNewMailRemindTableView);
    this.mNewMailRemindTableView.setClickListener(this.newMailRemindOnClickListener);
    this.mNewMailRemindTableView.addItem(2131719937);
    this.mNewMailRemindTableView.commit();
  }
  
  private void exitUser()
  {
    QMLogStream.submitLog(true, true);
    LoginUIHelper.createExitAppDialog(this);
  }
  
  private void handleClearCache()
  {
    if (getIntent().getBooleanExtra("arg_clear_cache", false)) {
      startActivity(SettingCacheClearActivity.createIntent());
    }
  }
  
  private void handleGoBack()
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    String str = getIntent().getStringExtra("arg_from");
    if ((this.accts.size() == 1) && (str != null) && ((str.equals("from_schema")) || (str.equals("from_account_list"))))
    {
      QMActivityManager.shareInstance().finishAllActivity();
      startActivity(MailFragmentActivity.createIntentToFolderList(this.accts.get(0).getId()));
      return;
    }
    if ((QMActivityManager.shareInstance().getActivitySize() <= 1) && (localAccountList.size() == 1))
    {
      startActivity(MailFragmentActivity.createIntentToFolderList(localAccountList.get(0).getId()));
      finish();
      return;
    }
    if ((QMActivityManager.shareInstance().getActivitySize() <= 1) && (localAccountList.size() != 1))
    {
      startActivity(MailFragmentActivity.createIntentToAccountList());
      finish();
      return;
    }
    if ((ADDACCOUNT == ADDSUCCESS) && (str != null) && (!str.equals("from_account_list")))
    {
      ADDACCOUNT = NOADD;
      startActivity(MailFragmentActivity.createIntentToAccountList());
      finish();
      return;
    }
    finish();
    overridePendingTransition(2130772023, 2130772402);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131720003);
    localQMTopBar.setButtonLeftBack();
    localQMTopBar.setButtonLeftOnclickListener(new SettingActivity.2(this));
  }
  
  private void refreshAccountList()
  {
    this.mAccountListTableView.clear();
    if (this.accts != null)
    {
      int i = 0;
      if (i < this.accts.size())
      {
        localObject2 = this.mAccountListTableView;
        if (this.accts.get(i).getEmail() == null) {}
        for (localObject1 = "";; localObject1 = this.accts.get(i).getEmail())
        {
          localObject1 = ((UITableView)localObject2).addItem((String)localObject1);
          if ((this.accts.size() > 1) && (AccountManager.shareInstance().getAccountList().isDefaultMailAccount(this.accts.get(i).getId()))) {
            ((UITableItemView)localObject1).setDetail(getResources().getString(2131692448), UITableItemView.STYLE_GRAY);
          }
          i += 1;
          break;
        }
      }
    }
    Object localObject1 = this.mAccountListTableView.addItem(2131689702);
    if ((QMSettingManager.sharedInstance().getUpgradeFromOldApp()) && (!QMSettingManager.sharedInstance().getAppGuideUpgradedAccount()))
    {
      QMSettingManager.sharedInstance().setAppGuideUpgradedAccount();
      ((UITableItemView)localObject1).showNew(true);
    }
    this.mAccountListTableView.commit();
    Object localObject2 = new ImageView(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    localLayoutParams.rightMargin = QMUIKit.dpToPx(4);
    ((ImageView)localObject2).setBackgroundResource(2130840738);
    ((UITableItemView)localObject1).addView((View)localObject2, 0, localLayoutParams);
  }
  
  private double trimSize(double paramDouble)
  {
    return Math.round(paramDouble * 100.0D) / 100.0D;
  }
  
  public void initDataSource()
  {
    this.accts = AccountManager.shareInstance().getAccountList();
  }
  
  public void initDom()
  {
    initTopBar();
    createAccountListTableView();
    createMailOptionListTableView();
    createAppOptionListTableView();
    createClearCacheTableView();
    createAppTableView();
    createAboutListTableView();
    createExitUser();
    handleClearCache();
    if (BrandUtil.isHuawei()) {
      overridePendingTransition(2130772401, 2130772430);
    }
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBackPressed()
  {
    handleGoBack();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData()
  {
    this.accts = AccountManager.shareInstance().getAccountList();
    refreshAccountList();
    if (QMSettingManager.sharedInstance().getMailLoadImgType() == 0) {
      this.autoLoadPicItemView.setDetail(getResources().getString(2131719876), UITableItemView.STYLE_GRAY);
    }
    for (;;)
    {
      DataCollector.logStatus("AppStat_is_Load_Image", String.valueOf(QMSettingManager.sharedInstance().getMailLoadImgType()));
      if (this.accts == null) {
        break;
      }
      int j = 0;
      i = 0;
      for (;;)
      {
        k = i;
        if (j >= this.accts.size()) {
          break;
        }
        if (this.accts.get(j).isQQMail()) {
          i = 1;
        }
        j += 1;
      }
      if (QMSettingManager.sharedInstance().getMailLoadImgType() == 1) {
        this.autoLoadPicItemView.setDetail(getResources().getString(2131719878), UITableItemView.STYLE_GRAY);
      } else if (QMSettingManager.sharedInstance().getMailLoadImgType() == 2) {
        this.autoLoadPicItemView.setDetail(getResources().getString(2131719877), UITableItemView.STYLE_GRAY);
      }
    }
    int k = 0;
    if (k == 0)
    {
      QMSettingManager.sharedInstance().setNoteDisplay(false);
      QMSettingManager.sharedInstance().setFtnDisplay(false);
    }
    if (!FileUtil.hasSdcard())
    {
      QMSettingManager.sharedInstance().setShowMailListAvatar(false);
      this.showMailListHeadItemView.setVisibility(8);
    }
    this.accts = AccountManager.shareInstance().getAccountList();
    int i = 0;
    if (i < this.accts.size()) {
      if ((!this.accts.get(i).isQQMail()) || (this.accts.get(i).isBizMail())) {}
    }
    for (i = 1;; i = 0)
    {
      label278:
      label307:
      label324:
      UITableItemView localUITableItemView;
      if (i != 0)
      {
        this.bookMailAggregateItemView.setVisibility(0);
        if ((!QMPushConfigUtil.showUpgradeVersion()) || (QMSettingManager.sharedInstance().getNewVersionRead())) {
          break label386;
        }
        this.aboutItemView.showNew(true);
        DataCollector.logEvent("Event_Setting_About_New_Show");
        if (!QMSettingManager.sharedInstance().getBonus()) {
          break label397;
        }
        this.developerItemView.setVisibility(0);
        this.mClearCacheItemView.setDetail(SettingAutoClearAttachmentsActivity.getClearLevel(), UITableItemView.STYLE_GRAY);
        i = DownloadInfoManager.shareInstance().getUnCompletedCnt();
        localUITableItemView = this.attachmentManageItemView;
        if (i != 0) {
          break label409;
        }
      }
      label386:
      label397:
      label409:
      for (String str = "";; str = String.valueOf(i))
      {
        localUITableItemView.setDetail(str);
        return;
        i += 1;
        break;
        this.bookMailAggregateItemView.setVisibility(8);
        break label278;
        this.aboutItemView.showNew(false);
        break label307;
        this.developerItemView.setVisibility(8);
        break label324;
      }
    }
  }
  
  public void render()
  {
    if (QMPushConfigUtil.getTopbarPopWindowHasNewUnClick())
    {
      if ((QMPushConfigUtil.showUpgradeVersion()) && (!QMSettingManager.sharedInstance().getNewVersionRead()))
      {
        DataCollector.logEvent("Event_Topbar_Popwindow_Red_Dot_Click");
        runOnMainThread(new SettingActivity.1(this), 50L);
      }
      QMPushConfigUtil.setTopbarPopWindowHasNewUnClick(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingActivity
 * JD-Core Version:    0.7.0.1
 */