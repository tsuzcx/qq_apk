package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.setting.tableactivity.BaseTableActivity;
import com.tencent.qqmail.activity.setting.tableactivity.model.CheckBoxTableItem;
import com.tencent.qqmail.activity.setting.tableactivity.model.DetailTableItem;
import com.tencent.qqmail.activity.setting.tableactivity.model.Table;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.NoteStorage;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.ChangeNoteDefaultCategoryWatcher;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.ShortcutUtility;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import moai.core.watcher.Watchers;
import org.apache.commons.lang3.StringUtils;

public class SettingNoteActivity
  extends BaseTableActivity
{
  public static final String ARG_FROM_SHORTCUT = "arg_from_shortcut";
  private static final String CREATE_CATEGORY_TABLE_VALUE = "createCategoryTable";
  private static final String CREATE_SHORTCUT_TABLE_VALUE = "createShortcutTable";
  private static final String MAIN_SWITCH_TABLE_VALUE = "mainSwitchTable";
  private static final String SHOW_HOME_TABLE_VALUE = "showHomeTable";
  private static final String TAG = "SettingNoteActivity";
  private int accountId;
  private UITableView.ClickListener accountTableClickListener = new SettingNoteActivity.6(this);
  private ChangeNoteDefaultCategoryWatcher changeNoteDefaultCategoryWatcher = new SettingNoteActivity.1(this);
  private boolean checked;
  private UITableItemView defaultAccountItemView;
  private boolean isFromShortcut;
  private UITableView mAccountTable;
  private QMRadioGroup mRadioGroup;
  private QMTips qmTips;
  
  private void bindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.changeNoteDefaultCategoryWatcher, paramBoolean);
  }
  
  private void createAccountTable()
  {
    this.mAccountTable = new UITableView(this);
    this.mSettingView.addContentView(this.mAccountTable);
    this.defaultAccountItemView = this.mAccountTable.addItem(2131719725);
    this.defaultAccountItemView.setDetail("");
    int i = QMSettingManager.sharedInstance().getDefaultNoteAccountID();
    Account localAccount;
    if (i != -1)
    {
      localAccount = AccountManager.shareInstance().getAccountList().getAccountById(i);
      if (getQQAccountNum() >= 2) {
        break label125;
      }
      this.defaultAccountItemView.setDetail(localAccount.getEmail(), UITableItemView.STYLE_GRAY);
    }
    for (;;)
    {
      if (getQQAccountNum() < 2) {
        this.defaultAccountItemView.setEnabled(false);
      }
      this.mAccountTable.setClickListener(this.accountTableClickListener);
      this.mAccountTable.commit();
      return;
      label125:
      this.defaultAccountItemView.setDetail(localAccount.getEmail());
    }
  }
  
  private void createCategoryTalbe()
  {
    String str = getDefaultNoteCategoryName();
    createTable("createCategoryTable").add(new DetailTableItem(2131690416, 1, str, UITableItemView.STYLE_GRAY, false));
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingNoteActivity.class);
  }
  
  public static Intent createIntentFromShortcut()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingNoteActivity.class);
    localIntent.putExtra("arg_from_shortcut", true);
    return localIntent;
  }
  
  private void createMainSwitchTable()
  {
    createTable("mainSwitchTable").add(new CheckBoxTableItem(2131719902, 1, QMSettingManager.sharedInstance().getNoteDisplay()));
  }
  
  private void createRadioGroup()
  {
    this.mRadioGroup = new QMRadioGroup(this);
    this.mSettingView.addContentView(this.mRadioGroup);
    this.mRadioGroup.setCaption(2131719905);
    this.mRadioGroup.addItem(1, 2131719909);
    this.mRadioGroup.addItem(2, 2131719907);
    this.mRadioGroup.addItem(3, 2131719906);
    this.mRadioGroup.addItem(0, 2131719908);
    this.mRadioGroup.setOnCheckedChangeListener(new SettingNoteActivity.7(this));
    this.mRadioGroup.commit();
    int i = QMSettingManager.sharedInstance().getNoteImgCompressRatio();
    this.mRadioGroup.setSelectedItem(i);
  }
  
  private boolean createShortcut(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true; paramBoolean; paramBoolean = false)
    {
      ShortcutUtility.addApplicationShortcut(getString(2131690417), 2130842234);
      DataCollector.logEvent("Event_Add_Note_Shortcut_In_Setting");
      return paramBoolean;
    }
    ShortcutUtility.deleteApplicationShortcut(getString(2131690417));
    return paramBoolean;
  }
  
  private void createShortcutTable()
  {
    String str = getString(2131690417);
    createTable("createShortcutTable").add(new CheckBoxTableItem(2131690422, 1, ShortcutUtility.isShortcutExist(str)));
  }
  
  private void createShowHomeTable()
  {
    if (FolderDataManager.getInnerAppIdList().indexOf(Integer.valueOf(-4)) == -1) {}
    for (boolean bool = true;; bool = false)
    {
      createTable("showHomeTable").add(new CheckBoxTableItem(2131719652, 1, bool));
      return;
    }
  }
  
  private boolean enableNoteApp(boolean paramBoolean)
  {
    if (getQQAccountNum() > 0) {
      if (!paramBoolean)
      {
        paramBoolean = true;
        this.checked = paramBoolean;
        QMSettingManager.sharedInstance().setNoteDisplay(this.checked);
        if (!this.checked) {
          break label59;
        }
        DataCollector.logEvent("Event_Turn_On_Note");
        label41:
        refreshData();
        render();
      }
    }
    for (;;)
    {
      return this.checked;
      paramBoolean = false;
      break;
      label59:
      DataCollector.logEvent("Event_Turn_Off_Note");
      break label41;
      QMUIDialog localQMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(2131719904)).setMessage(2131719903).addAction(2131691246, new SettingNoteActivity.3(this))).addAction(2131719650, new SettingNoteActivity.2(this))).create();
      localQMUIDialog.setCanceledOnTouchOutside(false);
      localQMUIDialog.show();
    }
  }
  
  private void enterAccountListOrFolderList()
  {
    Object localObject = AccountManager.shareInstance().getAccountList();
    if (((AccountList)localObject).size() == 0) {
      localObject = AccountTypeListActivity.createIntent();
    }
    for (;;)
    {
      ((Intent)localObject).setFlags(268435456);
      QMApplicationContext.sharedInstance().startActivity((Intent)localObject);
      return;
      if (((AccountList)localObject).size() == 1) {
        localObject = MailFragmentActivity.createIntentToFolderList(((AccountList)localObject).get(0).getId());
      } else {
        localObject = MailFragmentActivity.createIntentToAccountList();
      }
    }
  }
  
  @NonNull
  private String getDefaultNoteCategoryName()
  {
    Object localObject;
    if (NoteManager.sharedInstance() == null) {
      localObject = "未分类";
    }
    String str;
    do
    {
      return localObject;
      localObject = NoteStorage.getDefaultCatId();
      str = NoteManager.sharedInstance().findCategoryNameByCid((String)localObject);
      if (StringUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      localObject = str;
    } while (!StringUtils.isEmpty(str));
    return "";
  }
  
  private int getQQAccountNum()
  {
    int i = 0;
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    int k;
    for (int j = 0; i < localAccountList.size(); j = k)
    {
      k = j;
      if (localAccountList.get(i).isQQMail()) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131719902);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void loadCatalogs()
  {
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnSuccess(new SettingNoteActivity.4(this));
    localMailManagerDelegate.setOnError(new SettingNoteActivity.5(this));
    NoteManager localNoteManager = NoteManager.sharedInstance();
    if (localNoteManager != null) {
      localNoteManager.getCatalogList(localMailManagerDelegate);
    }
  }
  
  private void showAlert()
  {
    QMUIDialog localQMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(2131719904)).setMessage(2131719903).addAction(2131691246, new SettingNoteActivity.9(this))).addAction(2131719650, new SettingNoteActivity.8(this))).create();
    localQMUIDialog.setCanceledOnTouchOutside(false);
    localQMUIDialog.show();
  }
  
  private boolean showHomeTable(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      paramBoolean = true;
      if (!paramBoolean) {
        break label37;
      }
      FolderDataManager.moveAppFromInnerToHomeAndSendToServer(-4);
      DataCollector.logEvent("Event_Note_Setting_Show_Home");
    }
    for (;;)
    {
      QMLog.log(4, "SettingNoteActivity", "move app:16842960 to send config");
      return paramBoolean;
      paramBoolean = false;
      break;
      label37:
      FolderDataManager.moveAppFromHomeToInnerAndSendToServer(-4);
      DataCollector.logEvent("Event_Note_Setting_Show_Inner");
    }
  }
  
  private void showNoteCategory()
  {
    startActivity(SettingDefaultNoteCatalogActivity.createIntent());
    overridePendingTransition(2130772422, 2130772419);
  }
  
  public void finish()
  {
    if ((this.isFromShortcut) || (QMActivityManager.shareInstance().getActivitySize() == 1))
    {
      QMActivityManager.shareInstance().finishAllActivity();
      enterAccountListOrFolderList();
      overridePendingTransition(2130772421, 2130772420);
      return;
    }
    super.finish();
  }
  
  public void initDataSource()
  {
    super.initDataSource();
    this.isFromShortcut = getIntent().getBooleanExtra("arg_from_shortcut", false);
  }
  
  public void initDom()
  {
    super.initDom();
    initTopBar();
    createAccountTable();
    createRadioGroup();
    if (this.isFromShortcut) {
      showAlert();
    }
    this.qmTips = new QMTips(this);
    bindEvent(true);
    if (AccountManager.shareInstance().getAccountList().getDefaultNoteAccount() != null) {
      loadCatalogs();
    }
  }
  
  public void initViewData()
  {
    createMainSwitchTable();
    createShowHomeTable();
    createShortcutTable();
    createCategoryTalbe();
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease()
  {
    bindEvent(false);
  }
  
  public void refreshData()
  {
    int i = this.accountId;
    this.accountId = QMSettingManager.sharedInstance().getDefaultNoteAccountID();
    if (this.accountId != -1)
    {
      Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
      this.defaultAccountItemView.setDetail(localAccount.getEmail());
    }
    if ((this.accountId != -1) && (i != this.accountId)) {
      loadCatalogs();
    }
    this.checked = QMSettingManager.sharedInstance().getNoteDisplay();
    if ((SettingActivity.ADDACCOUNT == SettingActivity.ADDING) && (getQQAccountNum() > 0))
    {
      QMSettingManager.sharedInstance().setNoteDisplay(true);
      getTableItemViewByResid(2131719902).setChecked(true);
      SettingActivity.ADDACCOUNT = SettingActivity.ADDSUCCESS;
    }
    while ((SettingActivity.ADDACCOUNT != SettingActivity.ADDING) || (getQQAccountNum() != 0)) {
      return;
    }
    SettingActivity.ADDACCOUNT = SettingActivity.NOADD;
  }
  
  public void render()
  {
    if (this.checked)
    {
      this.mAccountTable.setVisibility(0);
      this.mRadioGroup.setVisibility(0);
      getTableViewByValue("showHomeTable").setVisibility(0);
      getTableViewByValue("createShortcutTable").setVisibility(0);
      getTableViewByValue("createCategoryTable").setVisibility(0);
    }
    for (;;)
    {
      getTableItemViewByResid(2131690416).limitDetailWidth(true);
      return;
      this.mAccountTable.setVisibility(4);
      this.mRadioGroup.setVisibility(4);
      getTableViewByValue("showHomeTable").setVisibility(4);
      getTableViewByValue("createShortcutTable").setVisibility(4);
      getTableViewByValue("createCategoryTable").setVisibility(4);
      ShortcutUtility.deleteApplicationShortcut(getString(2131690417));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingNoteActivity
 * JD-Core Version:    0.7.0.1
 */