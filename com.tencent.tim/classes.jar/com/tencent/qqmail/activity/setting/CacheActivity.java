package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.cacheclear.ClearCacheConfig;
import com.tencent.qqmail.utilities.cacheclear.QMClearCacheManager;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;

public class CacheActivity
  extends BaseActivityEx
{
  private static final int daySecond = 86400;
  private UITableItemView bConfigItemView;
  private UITableItemView bSizeItemView;
  private UITableItemView cConfigItemView;
  private UITableItemView cSizeItemView;
  private UITableItemView clearItemView;
  private UITableView configTableView;
  private UITableItemView dConfigItemView;
  private UITableItemView dSizeItemView;
  private UITableItemView eConfigItemView;
  private UITableItemView eSizeItemView;
  private UITableItemView fConfigItemView;
  private UITableItemView fSizeItemView;
  private UITableItemView gSizeItemView;
  private UITableItemView keyItemView;
  private QMBaseView mSettingView;
  private UITableView optTableView;
  private UITableItemView refreshItemView;
  private UITableItemView reminderSizeItemView;
  private UITableItemView reportItemView;
  private UITableItemView resetClearTime;
  private UITableView sizeTableView;
  private UITableItemView systemSizeItemView;
  private UITableItemView testDebugItemView;
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), CacheActivity.class);
  }
  
  private void initConfigTable()
  {
    this.configTableView = new UITableView(this);
    this.mSettingView.addContentView(this.configTableView);
    this.keyItemView = this.configTableView.addItem(2131719673);
    this.keyItemView.setDetail("");
    this.keyItemView.hideArrow();
    this.bConfigItemView = this.configTableView.addItem(2131719667);
    this.bConfigItemView.setDetail("");
    this.bConfigItemView.hideArrow();
    this.cConfigItemView = this.configTableView.addItem(2131719668);
    this.cConfigItemView.setDetail("");
    this.cConfigItemView.hideArrow();
    this.dConfigItemView = this.configTableView.addItem(2131719669);
    this.dConfigItemView.setDetail("");
    this.dConfigItemView.hideArrow();
    this.eConfigItemView = this.configTableView.addItem(2131719670);
    this.eConfigItemView.setDetail("");
    this.eConfigItemView.hideArrow();
    this.fConfigItemView = this.configTableView.addItem(2131719671);
    this.fConfigItemView.setDetail("");
    this.fConfigItemView.hideArrow();
    this.configTableView.commit();
  }
  
  private void initOptTable()
  {
    this.optTableView = new UITableView(this);
    this.mSettingView.addContentView(this.optTableView);
    this.testDebugItemView = this.optTableView.addItem(2131719672);
    this.testDebugItemView.setChecked(QMClearCacheManager.isTestDebug());
    this.refreshItemView = this.optTableView.addItem(2131719674);
    this.resetClearTime = this.optTableView.addItem(2131719676);
    this.clearItemView = this.optTableView.addItem(2131719666);
    this.reportItemView = this.optTableView.addItem(2131719675);
    this.optTableView.setClickListener(new CacheActivity.2(this));
    this.optTableView.commit();
  }
  
  private void initSizeTable()
  {
    this.sizeTableView = new UITableView(this);
    this.mSettingView.addContentView(this.sizeTableView);
    this.bSizeItemView = this.sizeTableView.addItem(2131719677);
    this.bSizeItemView.setDetail("");
    this.bSizeItemView.hideArrow();
    this.cSizeItemView = this.sizeTableView.addItem(2131719678);
    this.cSizeItemView.setDetail("");
    this.cSizeItemView.hideArrow();
    this.dSizeItemView = this.sizeTableView.addItem(2131719679);
    this.dSizeItemView.setDetail("");
    this.dSizeItemView.hideArrow();
    this.eSizeItemView = this.sizeTableView.addItem(2131719680);
    this.eSizeItemView.setDetail("");
    this.eSizeItemView.hideArrow();
    this.fSizeItemView = this.sizeTableView.addItem(2131719681);
    this.fSizeItemView.setDetail("");
    this.fSizeItemView.hideArrow();
    this.gSizeItemView = this.sizeTableView.addItem(2131719682);
    this.gSizeItemView.setDetail("");
    this.gSizeItemView.hideArrow();
    this.reminderSizeItemView = this.sizeTableView.addItem(2131719683);
    this.reminderSizeItemView.setDetail("");
    this.reminderSizeItemView.hideArrow();
    this.systemSizeItemView = this.sizeTableView.addItem(2131719684);
    this.systemSizeItemView.setDetail("");
    this.systemSizeItemView.hideArrow();
    this.sizeTableView.commit();
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131719685);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void loadSizeInBackGround()
  {
    Threads.runInBackground(new CacheActivity.1(this));
  }
  
  private void refreshConfig()
  {
    ClearCacheConfig localClearCacheConfig = QMClearCacheManager.parseClearCacheConfig();
    if (localClearCacheConfig != null)
    {
      this.keyItemView.setDetail(localClearCacheConfig.getKey() + "G");
      this.bConfigItemView.setDetail(localClearCacheConfig.getClearCardTime() / 86400L + "天");
      this.cConfigItemView.setDetail(localClearCacheConfig.getClearAvatarSize() / 1024L + "M");
      this.dConfigItemView.setDetail(localClearCacheConfig.getClearLogTime() / 86400L + "天");
      this.eConfigItemView.setDetail(localClearCacheConfig.getClearImageCacheTime() / 86400L + "天");
      this.fConfigItemView.setDetail(localClearCacheConfig.getClearAttachTime() / 86400L + "天");
    }
  }
  
  public void initDataSource()
  {
    initTopBar();
    initConfigTable();
    initSizeTable();
    initOptTable();
  }
  
  public void initDom() {}
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData()
  {
    refreshConfig();
    loadSizeInBackGround();
  }
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.CacheActivity
 * JD-Core Version:    0.7.0.1
 */