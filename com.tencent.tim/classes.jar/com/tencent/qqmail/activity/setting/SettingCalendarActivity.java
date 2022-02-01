package com.tencent.qqmail.activity.setting;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.model.QMCalendarProtocolManager;
import com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.LoginType;
import com.tencent.qqmail.calendar.provider.CalendarProviderConversionManager;
import com.tencent.qqmail.calendar.reminder.QMReminderer;
import com.tencent.qqmail.calendar.reminder.QMReminderer.Action;
import com.tencent.qqmail.calendar.reminder.QMRemindererBroadcast;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import com.tencent.qqmail.utilities.ui.ShortcutUtility;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import moai.oss.KvHelper;

public class SettingCalendarActivity
  extends BaseActivityEx
{
  private static final String ARG_TIPS = "arg_tips";
  public static final String TAG = "SettingCalendarActivity";
  private UITableView.ClickListener CalendarClickListener = new SettingCalendarActivity.12(this);
  private UITableView.ClickListener TimeClickListener = new SettingCalendarActivity.13(this);
  private List<Integer> accountIds = new ArrayList();
  private UITableView.ClickListener accountTableClickListener = new SettingCalendarActivity.4(this);
  private int animationType;
  private boolean checked;
  private List<Boolean> isSyn = new ArrayList();
  private boolean isVerify = false;
  Object lock = new Object();
  private UITableView.ClickListener lunarCalendarClickListener = new SettingCalendarActivity.11(this);
  private UITableView mAccountTable;
  private UITableView mCalendarTable;
  private UITableView mLunarCalendarTable;
  private QMBaseView mSettingView;
  private UITableView mShortcutTable;
  private UITableView mShowTable;
  private UITableView mStatusTable;
  private UITableView mTimeTable;
  private QMTopBar mTopBar = null;
  private QMCalendarManager qmCalendarManager = QMCalendarManager.getInstance();
  private UITableView.ClickListener shortcutClickListener = new SettingCalendarActivity.10(this);
  private UITableItemView shortcutItemView;
  private UITableItemView showItemView;
  private UITableItemView showLunarCalendarItemView;
  private UITableItemView showSystemCalendarItemView;
  private UITableView.ClickListener showTableClickListener = new SettingCalendarActivity.3(this);
  private UITableItemView statusItemView;
  private UITableView.ClickListener statusTableClickListener = new SettingCalendarActivity.2(this);
  private UITableItemView weekStartDaySettingView;
  
  private void createAccountTable()
  {
    this.mAccountTable = new UITableView(this);
    this.mAccountTable.setCaption(2131719704);
    this.mSettingView.addContentView(this.mAccountTable);
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    int i = 0;
    if (i < localAccountList.size())
    {
      UITableItemView localUITableItemView = this.mAccountTable.addItem(localAccountList.get(i).getEmail());
      if (this.qmCalendarManager.getCalendarFoldersByAccountId(localAccountList.get(i).getId()) != null) {
        this.isSyn.add(Boolean.valueOf(true));
      }
      for (;;)
      {
        localUITableItemView.setChecked(((Boolean)this.isSyn.get(i)).booleanValue());
        this.accountIds.add(Integer.valueOf(localAccountList.get(i).getId()));
        i += 1;
        break;
        this.isSyn.add(Boolean.valueOf(false));
      }
    }
    this.showSystemCalendarItemView = this.mAccountTable.addItem(2131691209);
    this.showSystemCalendarItemView.setChecked(this.qmCalendarManager.isShowSystemCalendar());
    this.mAccountTable.setClickListener(this.accountTableClickListener);
    this.mAccountTable.commit();
  }
  
  private void createCalendarTable()
  {
    this.mCalendarTable = new UITableView(this);
    this.mSettingView.addContentView(this.mCalendarTable);
    this.mCalendarTable.addItem(2131719703);
    this.mCalendarTable.addItem(2131719687);
    this.mCalendarTable.setClickListener(this.CalendarClickListener);
    this.mCalendarTable.commit();
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingCalendarActivity.class);
  }
  
  public static Intent createIntentWithiTips(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingCalendarActivity.class);
    localIntent.putExtra("arg_tips", paramString);
    return localIntent;
  }
  
  private void createLunarCalendarTable()
  {
    this.mLunarCalendarTable = new UITableView(this);
    this.mSettingView.addContentView(this.mLunarCalendarTable);
    this.showLunarCalendarItemView = this.mLunarCalendarTable.addItem(2131691207);
    this.showLunarCalendarItemView.setChecked(this.qmCalendarManager.isShowLunarCalendar());
    this.mLunarCalendarTable.setClickListener(this.lunarCalendarClickListener);
    this.mLunarCalendarTable.commit();
  }
  
  private void createShortcutTable()
  {
    this.mShortcutTable = new UITableView(this);
    this.mSettingView.addContentView(this.mShortcutTable);
    this.shortcutItemView = this.mShortcutTable.addItem(getString(2131690422));
    this.shortcutItemView.setChecked(ShortcutUtility.isShortcutExist(getString(2131690401)));
    this.mShortcutTable.setClickListener(this.shortcutClickListener);
    this.mShortcutTable.commit();
  }
  
  private void createShowTable()
  {
    this.mShowTable = new UITableView(this);
    this.mSettingView.addContentView(this.mShowTable);
    this.showItemView = this.mShowTable.addItem(2131719652);
    if (FolderDataManager.getInnerAppIdList().indexOf(Integer.valueOf(-18)) == -1) {
      this.showItemView.setChecked(true);
    }
    for (;;)
    {
      this.mShowTable.setClickListener(this.showTableClickListener);
      this.mShowTable.commit();
      return;
      this.showItemView.setChecked(false);
    }
  }
  
  private void createStatusTable()
  {
    this.checked = QMSettingManager.sharedInstance().getCalendarDisplay();
    this.mStatusTable = new UITableView(this);
    this.mSettingView.addContentView(this.mStatusTable);
    this.statusItemView = this.mStatusTable.addItem(2131691226);
    this.statusItemView.setChecked(this.checked);
    this.mStatusTable.setClickListener(this.statusTableClickListener);
    this.mStatusTable.commit();
  }
  
  private void createTimeTable()
  {
    this.mTimeTable = new UITableView(this);
    this.mSettingView.addContentView(this.mTimeTable);
    this.mTimeTable.addItem(2131719690);
    this.mTimeTable.addItem(2131719688);
    this.mTimeTable.addItem(2131719705);
    this.weekStartDaySettingView = this.mTimeTable.addItem(2131719706);
    this.weekStartDaySettingView.setDetail("", 2131165860);
    this.mTimeTable.setClickListener(this.TimeClickListener);
    this.mTimeTable.commit();
  }
  
  private void initTopBar()
  {
    refreshTopBar(null, null);
  }
  
  private void refreshTopBar(Account paramAccount, UITableItemView paramUITableItemView)
  {
    this.mTopBar = getTopBar();
    if (!this.isVerify)
    {
      this.mTopBar.showLoading(false);
      this.mTopBar.setTitle(getResources().getString(2131691226));
      this.mTopBar.setButtonLeftBack();
    }
    for (;;)
    {
      this.mTopBar.setButtonLeftOnclickListener(new SettingCalendarActivity.1(this, paramAccount, paramUITableItemView));
      return;
      this.mTopBar.showLoading(true);
      this.mTopBar.setTitle(getResources().getString(2131719699));
      this.mTopBar.setButtonLeftNormal(2131691246);
    }
  }
  
  private void setTableEnabled(boolean paramBoolean)
  {
    Iterator localIterator = this.isSyn.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((Boolean)localIterator.next()).booleanValue());
    for (int i = 0;; i = 1)
    {
      if (this.showSystemCalendarItemView.isChecked()) {
        i = 0;
      }
      if ((i != 0) || (!QMSettingManager.sharedInstance().getCalendarDisplay()))
      {
        this.mCalendarTable.setVisibility(8);
        this.mTimeTable.setVisibility(8);
        this.mLunarCalendarTable.setVisibility(8);
        this.mShortcutTable.setVisibility(8);
        ShortcutUtility.deleteApplicationShortcut(getString(2131690401));
      }
      while (paramBoolean)
      {
        this.statusItemView.getChildAt(1).setEnabled(false);
        this.statusItemView.getTitleView().setTextColor(getResources().getColor(2131167531));
        i = 1;
        for (;;)
        {
          if (i <= this.isSyn.size() + 1)
          {
            this.mAccountTable.getItem(i).getChildAt(1).setEnabled(false);
            this.mAccountTable.getItem(i).getTitleView().setTextColor(getResources().getColor(2131167531));
            i += 1;
            continue;
            this.mCalendarTable.setVisibility(0);
            this.mTimeTable.setVisibility(0);
            this.mLunarCalendarTable.setVisibility(0);
            this.mShortcutTable.setVisibility(0);
            break;
          }
        }
        this.mCalendarTable.getItem(0).setClickable(false);
        this.mCalendarTable.getItem(0).getTitleView().setTextColor(getResources().getColor(2131167531));
        this.mCalendarTable.getItem(1).setClickable(false);
        this.mCalendarTable.getItem(1).getTitleView().setTextColor(getResources().getColor(2131167531));
        this.mTimeTable.getItem(0).setClickable(false);
        this.mTimeTable.getItem(0).getTitleView().setTextColor(getResources().getColor(2131167531));
        this.mTimeTable.getItem(1).setClickable(false);
        this.mTimeTable.getItem(1).getTitleView().setTextColor(getResources().getColor(2131167531));
        this.mTimeTable.getItem(2).setClickable(false);
        this.mTimeTable.getItem(2).getTitleView().setTextColor(getResources().getColor(2131167531));
        this.mLunarCalendarTable.getItem(0).getChildAt(1).setEnabled(false);
        this.mLunarCalendarTable.getItem(0).getTitleView().setTextColor(getResources().getColor(2131167531));
        this.mShortcutTable.getItem(0).getChildAt(1).setEnabled(false);
        this.mShortcutTable.getItem(0).getTitleView().setTextColor(getResources().getColor(2131167531));
        return;
      }
      this.statusItemView.getChildAt(1).setEnabled(true);
      this.statusItemView.getTitleView().setTextColor(getResources().getColor(2131167519));
      i = 1;
      while (i <= this.isSyn.size() + 1)
      {
        this.mAccountTable.getItem(i).getChildAt(1).setEnabled(true);
        this.mAccountTable.getItem(i).getTitleView().setTextColor(getResources().getColor(2131167519));
        i += 1;
      }
      this.mCalendarTable.getItem(0).setClickable(true);
      this.mCalendarTable.getItem(0).getTitleView().setTextColor(getResources().getColor(2131167519));
      this.mCalendarTable.getItem(1).setClickable(true);
      this.mCalendarTable.getItem(1).getTitleView().setTextColor(getResources().getColor(2131167519));
      this.mTimeTable.getItem(0).setClickable(true);
      this.mTimeTable.getItem(0).getTitleView().setTextColor(getResources().getColor(2131167519));
      this.mTimeTable.getItem(1).setClickable(true);
      this.mTimeTable.getItem(1).getTitleView().setTextColor(getResources().getColor(2131167519));
      this.mTimeTable.getItem(2).setClickable(true);
      this.mTimeTable.getItem(2).getTitleView().setTextColor(getResources().getColor(2131167519));
      this.mLunarCalendarTable.getItem(0).getChildAt(1).setEnabled(true);
      this.mLunarCalendarTable.getItem(0).getTitleView().setTextColor(getResources().getColor(2131167519));
      this.mShortcutTable.getItem(0).getChildAt(1).setEnabled(true);
      this.mShortcutTable.getItem(0).getTitleView().setTextColor(getResources().getColor(2131167519));
      return;
    }
  }
  
  private void showChangeCalendarDefaultFolderDialog(Account paramAccount, ActionCallback paramActionCallback)
  {
    QMCalendarFolder localQMCalendarFolder1 = this.qmCalendarManager.getCalendarFolder(this.qmCalendarManager.getDefaultAccountId(), this.qmCalendarManager.getDefaultFolderId());
    QMCalendarFolder localQMCalendarFolder2 = this.qmCalendarManager.getNextDefaultFolder(paramAccount);
    if ((localQMCalendarFolder1 != null) && (localQMCalendarFolder2 != null)) {
      if (localQMCalendarFolder1.getCategory() == 1)
      {
        paramAccount = this.qmCalendarManager.getLocalAccount().getName();
        paramAccount = String.format(getString(2131691222), new Object[] { localQMCalendarFolder1.getName(), paramAccount, localQMCalendarFolder2.getName() });
        ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131696424)).setMessage(paramAccount).addAction(2131691246, new SettingCalendarActivity.6(this))).addAction(0, 2131696547, 2, new SettingCalendarActivity.5(this, paramActionCallback))).create().show();
      }
    }
    while (paramActionCallback == null)
    {
      return;
      if (localQMCalendarFolder2.getCategory() == 1) {}
      for (paramAccount = localQMCalendarFolder2.getName();; paramAccount = QMCalendarProtocolManager.getLoginTypeWithAccountTypeNone(AccountManager.shareInstance().getAccountList().getAccountById(localQMCalendarFolder2.getAccountId())).getName())
      {
        paramAccount = String.format(getString(2131691216), new Object[] { localQMCalendarFolder1.getName(), paramAccount, localQMCalendarFolder2.getName() });
        break;
      }
    }
    paramActionCallback.doAction();
  }
  
  private void showErrorDialog(int paramInt)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131696424)).setMessage(paramInt).addAction(2131696547, new SettingCalendarActivity.14(this))).create().show();
  }
  
  private void showTipsDialog(String paramString)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(2131691100)).setMessage(paramString).addAction(2131696547, new SettingCalendarActivity.15(this))).create().show();
  }
  
  private void syncSystemCalendar(UITableItemView paramUITableItemView, boolean paramBoolean)
  {
    paramUITableItemView.setChecked(paramBoolean);
    if (paramBoolean) {
      KvHelper.eventCalendarOpenSystemCalendar(new double[0]);
    }
    for (;;)
    {
      this.qmCalendarManager.setShowSystemCalendar(paramBoolean);
      CalendarProviderConversionManager.sharedInstance().onSystemCalendarDisplayChanged(paramBoolean);
      if ((!paramBoolean) && (this.qmCalendarManager.getDefaultAccountId() == 0)) {
        this.qmCalendarManager.closeDefaultAccount(QMCalendarManager.getInstance().getLocalAccount());
      }
      setTableEnabled(false);
      return;
      KvHelper.eventCalendarCloseSystemCalendar(new double[0]);
    }
  }
  
  private void toggleSyncCalendar(UITableItemView arg1, int paramInt)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(((Integer)this.accountIds.get(paramInt)).intValue());
    if (((Boolean)this.isSyn.get(paramInt)).booleanValue())
    {
      QMNotificationConstructor.getInstance().clearCalendarPushNotifyList();
      ???.setChecked(false);
      this.isSyn.set(paramInt, Boolean.valueOf(false));
      setTableEnabled(false);
      runInBackground(new SettingCalendarActivity.7(this, localAccount));
      return;
    }
    this.isVerify = true;
    ???.setChecked(true);
    refreshTopBar(localAccount, ???);
    setTableEnabled(true);
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnError(new SettingCalendarActivity.8(this, ???, localAccount, paramInt));
    localMailManagerDelegate.setOnSuccess(new SettingCalendarActivity.9(this, ???, paramInt));
    synchronized (this.lock)
    {
      this.qmCalendarManager.login(localAccount, null, localMailManagerDelegate);
      return;
    }
  }
  
  public int getSelectedStartDayOfWeekIndex()
  {
    int i = 2;
    int j = this.qmCalendarManager.getDefaultStartDayOfWeek();
    if (j == 2) {
      i = 1;
    }
    while (j == 7) {
      return i;
    }
    return 0;
  }
  
  public void initDataSource()
  {
    getIntent();
    String str = getIntent().getStringExtra("arg_tips");
    if (!StringExtention.isNullOrEmpty(str)) {
      showTipsDialog(str);
    }
  }
  
  public void initDom()
  {
    initTopBar();
    createStatusTable();
    createShowTable();
    createShortcutTable();
    createLunarCalendarTable();
    createAccountTable();
    createCalendarTable();
    createTimeTable();
  }
  
  public void initUI()
  {
    this.animationType = getIntent().getIntExtra("animationType", 0);
    if (this.animationType == 1) {
      overridePendingTransition(2130772401, 2130772430);
    }
    for (;;)
    {
      this.mSettingView = initScrollView(this);
      return;
      if (this.animationType == 2) {
        overridePendingTransition(2130772422, 2130772419);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent.getExtras().getInt("result") == 1))
    {
      this.mAccountTable.getItem(paramInt1).setChecked(true);
      this.isSyn.set(paramInt1 - 1, Boolean.valueOf(true));
    }
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public Intent onLastFinish()
  {
    Intent localIntent = super.onLastFinish();
    Object localObject = localIntent;
    if (localIntent == null) {
      if (getIntent().getStringExtra("from") != null) {
        break label35;
      }
    }
    label35:
    for (localObject = "";; localObject = getIntent().getStringExtra("from"))
    {
      localObject = SettingActivity.createIntent((String)localObject);
      return localObject;
    }
  }
  
  public void onRelease() {}
  
  public void refreshData()
  {
    this.checked = QMSettingManager.sharedInstance().getCalendarDisplay();
    if (this.checked)
    {
      this.mShortcutTable.setVisibility(0);
      this.mAccountTable.setVisibility(0);
      this.mLunarCalendarTable.setVisibility(0);
      this.mCalendarTable.setVisibility(0);
      this.mTimeTable.setVisibility(0);
      this.mShowTable.setVisibility(0);
      QMReminderer.reDeploySentinel();
    }
    for (;;)
    {
      setTableEnabled(false);
      this.weekStartDaySettingView.setDetail(QMCalendarUtil.getWeekString(this.qmCalendarManager.getDefaultStartDayOfWeek()));
      return;
      this.mShortcutTable.setVisibility(4);
      this.mAccountTable.setVisibility(4);
      this.mLunarCalendarTable.setVisibility(4);
      this.mCalendarTable.setVisibility(4);
      this.mTimeTable.setVisibility(4);
      this.mShowTable.setVisibility(4);
      Object localObject = new Intent(QMApplicationContext.sharedInstance(), QMRemindererBroadcast.class);
      ((Intent)localObject).setAction(QMReminderer.Action.EVENT.toString());
      localObject = PendingIntent.getBroadcast(QMApplicationContext.sharedInstance(), 0, (Intent)localObject, 0);
      ((AlarmManager)getSystemService("alarm")).cancel((PendingIntent)localObject);
    }
  }
  
  public void render() {}
  
  static abstract interface ActionCallback
  {
    public abstract void doAction();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity
 * JD-Core Version:    0.7.0.1
 */