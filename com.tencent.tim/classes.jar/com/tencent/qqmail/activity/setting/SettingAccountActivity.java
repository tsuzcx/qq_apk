package com.tencent.qqmail.activity.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.SetPhotoWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncNickWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.protocol.QMSyncManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;

public class SettingAccountActivity
  extends BaseActivityEx
{
  private static final String ARG_ACCOUNT_ID = "arg_settingaccount_accountId";
  public static final String TAG = "SettingAccountActivity";
  private Account account;
  private boolean accountDeleted = false;
  private int accountId;
  private String accountNick;
  private final UITableView.ClickListener accountTableListOnClickListener = new SettingAccountActivity.7(this);
  private UITableItemView acctItemView;
  private UITableItemView aggreItemView;
  private QMAvatar avatar;
  private Bitmap avatarBitmap;
  private UITableItemView avatarItemView;
  private final UITableView.ClickListener convTableListOnClickListener = new SettingAccountActivity.11(this);
  private boolean isNickNameChanged = false;
  private UITableView mAccountTableView;
  private AvatarSelector mAvatarSelector;
  private UITableView mConvTableView;
  private QMBaseView mSettingView;
  private final UITableView.ClickListener mSyncTableListOnClickListener = new SettingAccountActivity.10(this);
  private UITableView mSyncTableView;
  private UITableItemView nickItemView;
  private EditText nickNameEditText;
  private UITableItemView qmDefaultComposeAliasItemView;
  private SetPhotoWatcher setPhotoWatcher = new SettingAccountActivity.3(this);
  private UITableItemView signItemView;
  private UITableItemView syncMailCountItemView;
  private UITableItemView syncMethodItemView;
  private SyncNickWatcher syncNickWatcher = new SettingAccountActivity.2(this);
  private SyncPhotoWatcher syncPhotoWatcher = new SettingAccountActivity.1(this);
  private Runnable updateQMAliasInfo = new SettingAccountActivity.4(this);
  
  private void ceateDeleteButton()
  {
    UITableView localUITableView = new UITableView(this);
    this.mSettingView.addContentView(localUITableView);
    Button localButton = QMUIKit.getRedFontButton(this, 2131719729, true);
    localUITableView.addView(localButton);
    localButton.setOnClickListener(new SettingAccountActivity.13(this));
  }
  
  private void createAccountTableList()
  {
    this.mAccountTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mAccountTableView);
    this.avatarItemView = this.mAccountTableView.addItem(2131689740);
    this.avatarItemView.hideArrow();
    this.avatar = new QMAvatar(0);
    this.avatarItemView.setDetail(this.avatar.getBitmap());
    this.nickItemView = this.mAccountTableView.addItem(2131689742);
    this.nickItemView.setDetail("");
    this.nickItemView.limitDetailWidth(true);
    if (!this.account.isQQMail()) {
      this.nickItemView.hideArrow();
    }
    if (this.account.isQQMail())
    {
      this.qmDefaultComposeAliasItemView = this.mAccountTableView.addItem(2131689738);
      this.qmDefaultComposeAliasItemView.setDetail("");
      this.qmDefaultComposeAliasItemView.limitDetailWidth(true);
    }
    this.signItemView = this.mAccountTableView.addItem(2131719961);
    this.signItemView.setDetail("");
    this.signItemView.limitDetailWidth(true);
    this.mAccountTableView.setClickListener(this.accountTableListOnClickListener);
    this.mAccountTableView.commit();
    initNickNameEditText();
  }
  
  private void createConvTableList()
  {
    this.mConvTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mConvTableView);
    this.aggreItemView = this.mConvTableView.addItem(2131719888);
    this.aggreItemView.setChecked(true);
    this.mConvTableView.setClickListener(this.convTableListOnClickListener);
    this.mConvTableView.commit();
  }
  
  private void createDefaultAccountButton()
  {
    UITableView localUITableView = new UITableView(this);
    this.mSettingView.addContentView(localUITableView);
    if (!AccountManager.shareInstance().getAccountList().isDefaultMailAccount(this.accountId)) {}
    for (boolean bool = true;; bool = false)
    {
      Button localButton = QMUIKit.getBlueFontButton(this, 2131719726, bool);
      if (!bool) {
        localButton.setText(2131719881);
      }
      localUITableView.setAccessorialView(localButton);
      localButton.setOnClickListener(new SettingAccountActivity.12(this, localButton));
      localUITableView.commit();
      return;
    }
  }
  
  public static Intent createIntent(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingAccountActivity.class);
    localIntent.putExtra("arg_settingaccount_accountId", paramInt);
    return localIntent;
  }
  
  private void createSyncTableList()
  {
    this.mSyncTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mSyncTableView);
    this.acctItemView = this.mSyncTableView.addItem(2131719951);
    if (this.account.isActiveSyncMail()) {}
    for (int i = 2131719985;; i = 2131719980)
    {
      this.syncMailCountItemView = this.mSyncTableView.addItem(i);
      this.syncMailCountItemView.setDetail("");
      this.syncMethodItemView = this.mSyncTableView.addItem(2131719992);
      this.syncMethodItemView.setDetail("");
      this.mSyncTableView.setClickListener(this.mSyncTableListOnClickListener);
      this.mSyncTableView.commit();
      return;
    }
  }
  
  private void disableViews()
  {
    if (this.signItemView != null) {
      this.signItemView.setEnabled(false);
    }
    if (this.avatarItemView != null) {
      this.avatarItemView.setEnabled(false);
    }
    if (this.nickItemView != null) {
      this.nickItemView.setEnabled(false);
    }
    if (this.qmDefaultComposeAliasItemView != null) {
      this.qmDefaultComposeAliasItemView.setEnabled(false);
    }
    if (this.syncMethodItemView != null) {
      this.syncMethodItemView.setEnabled(false);
    }
    if (this.syncMailCountItemView != null) {
      this.syncMailCountItemView.setEnabled(false);
    }
    if (this.acctItemView != null) {
      this.acctItemView.setEnabled(false);
    }
    if (this.aggreItemView != null) {
      this.aggreItemView.setEnabled(false);
    }
  }
  
  private void editNickName(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.nickItemView.setEnabled(false);
      this.nickItemView.hideDetailView();
      this.nickNameEditText.setVisibility(0);
      this.nickNameEditText.requestFocus();
      this.nickNameEditText.setSelection(this.nickNameEditText.getText().length());
      ((InputMethodManager)this.nickNameEditText.getContext().getSystemService("input_method")).showSoftInput(this.nickNameEditText, 0);
      return;
    }
    this.nickItemView.setEnabled(true);
    this.nickNameEditText.setVisibility(8);
    this.nickItemView.showDetailView();
  }
  
  private void handleDeleteAccount()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(2131719729)).setMessage(2131719730).addAction(2131691246, new SettingAccountActivity.15(this))).addAction(0, 2131691840, 2, new SettingAccountActivity.14(this))).create().show();
  }
  
  private void initNickNameEditText()
  {
    this.nickNameEditText = new EditText(this);
    int i = getResources().getDimensionPixelSize(2131299392);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0F);
    localLayoutParams.gravity = 16;
    localLayoutParams.leftMargin = QMUIKit.dpToPx(30);
    localLayoutParams.rightMargin = (-i);
    localLayoutParams.bottomMargin = 1;
    this.nickNameEditText.setLayoutParams(localLayoutParams);
    this.nickNameEditText.setBackgroundColor(0);
    this.nickNameEditText.setPadding(0, 0, i, 0);
    this.nickNameEditText.setSingleLine(true);
    this.nickNameEditText.setTextSize(2, 14.0F);
    this.nickNameEditText.setTextColor(getResources().getColor(2131167535));
    this.nickNameEditText.setGravity(21);
    this.nickNameEditText.setVisibility(8);
    this.nickNameEditText.setImeOptions(6);
    this.nickItemView.addView(this.nickNameEditText);
    this.nickNameEditText.addTextChangedListener(new SettingAccountActivity.8(this));
    this.mSettingView.addOnCompleteInputListener(this.nickNameEditText, new SettingAccountActivity.9(this));
  }
  
  private void initTopBar()
  {
    getTopBar().setButtonLeftBack();
  }
  
  private void loadServerComposeData()
  {
    Threads.runInBackground(new SettingAccountActivity.5(this));
  }
  
  private void saveNickName()
  {
    String str;
    if (this.isNickNameChanged)
    {
      str = this.nickNameEditText.getText().toString();
      Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
      if ((localAccount == null) || (!localAccount.isQQMail())) {
        break label85;
      }
      QMComposeDataManager.sharedInstance().setQMDefaultNick(this.accountId, str);
    }
    for (;;)
    {
      QMPrivateProtocolManager.sharedInstance().setAccountNick(this.accountId, str);
      this.isNickNameChanged = false;
      DataCollector.logDetailEvent("DetailEvent_ModifyNick", this.accountId, 0L, "");
      return;
      label85:
      QMSettingManager.sharedInstance().setAccountNick(this.accountId, str);
    }
  }
  
  public void finish()
  {
    if (QMActivityManager.shareInstance().getActivitySize() <= 1)
    {
      startActivity(SettingActivity.createIntent("from_none"));
      overridePendingTransition(2130772421, 2130772420);
    }
    super.finish();
  }
  
  public void initDataSource()
  {
    this.accountId = getIntent().getIntExtra("arg_settingaccount_accountId", 0);
    this.account = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
  }
  
  public void initDom()
  {
    initTopBar();
    createAccountTableList();
    createSyncTableList();
    createConvTableList();
    if (AccountManager.shareInstance().getAccountList().size() > 1) {
      createDefaultAccountButton();
    }
    ceateDeleteButton();
    this.mAvatarSelector = new AvatarSelector(getBaseActivityImpl(), new SettingAccountActivity.6(this));
    loadServerComposeData();
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mAvatarSelector.onActivityResult(paramInt1, paramInt2, paramIntent)) {}
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    QMPrivateProtocolManager.sharedInstance().bindSyncNickWatcher(this.syncNickWatcher, paramBoolean);
    QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.syncPhotoWatcher, paramBoolean);
    QMPrivateProtocolManager.sharedInstance().bindSetPhotoWatcher(this.setPhotoWatcher, paramBoolean);
  }
  
  public void onButtonBackClick()
  {
    saveNickName();
    super.onButtonBackClick();
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease()
  {
    this.mAvatarSelector.recyle();
  }
  
  public void refreshData()
  {
    Object localObject2 = getTopBar();
    if (this.account != null)
    {
      localObject1 = this.account.getEmail();
      ((QMTopBar)localObject2).setTitle((String)localObject1);
      if (this.account != null)
      {
        localObject1 = QMSettingManager.sharedInstance().getAccountIconLocal(this.account.getEmail(), 4);
        if (localObject1 == null) {
          break label354;
        }
        this.avatar.setAvatar((Bitmap)localObject1);
        this.avatarItemView.setDetail(this.avatar.getBitmap());
        label75:
        if ((this.account.getEmail() != null) && (this.account.isTencentDotCom()))
        {
          this.avatarItemView.setEnabled(false);
          this.avatarItemView.hideArrow();
        }
        if (!this.account.isQQMail())
        {
          this.accountNick = QMSettingManager.sharedInstance().getAccountNick(this.accountId);
          if ((this.accountNick == null) || (this.accountNick.equals(""))) {
            QMPrivateProtocolManager.sharedInstance().syncAccountNick(this.account.getEmail());
          }
          localObject2 = this.nickItemView;
          if (this.accountNick != null) {
            break label399;
          }
          localObject1 = "";
          label181:
          ((UITableItemView)localObject2).setDetail((String)localObject1);
          localObject2 = this.nickNameEditText;
          if (this.accountNick != null) {
            break label407;
          }
        }
      }
    }
    label399:
    label407:
    for (Object localObject1 = "";; localObject1 = this.accountNick)
    {
      ((EditText)localObject2).setText((CharSequence)localObject1);
      if (this.account.isTencentDotCom())
      {
        this.nickItemView.setEnabled(false);
        this.nickNameEditText.setEnabled(false);
      }
      this.isNickNameChanged = false;
      if ((this.account != null) && (this.account.isQQMail()))
      {
        this.accountId = this.account.getId();
        localObject1 = QMComposeDataManager.sharedInstance().getQMDefaultAlias(this.accountId);
        this.accountNick = QMComposeDataManager.sharedInstance().getQMAliasNick((String)localObject1, this.accountId);
        Threads.runOnMainThread(this.updateQMAliasInfo);
      }
      localObject2 = QMSettingManager.sharedInstance().getAccountSignature(this.accountId);
      UITableItemView localUITableItemView = this.signItemView;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localUITableItemView.setDetail((String)localObject1);
      if (!this.account.isQQMail()) {
        break label415;
      }
      this.mConvTableView.setVisibility(8);
      return;
      localObject1 = "";
      break;
      label354:
      this.avatar.setAvatar(this.account.getName());
      this.avatarItemView.setDetail(this.avatar.getBitmap());
      QMPrivateProtocolManager.sharedInstance().loadEmailIconDirectly(this.account.getEmail());
      break label75;
      localObject1 = this.accountNick;
      break label181;
    }
    label415:
    this.aggreItemView.setChecked(QMSettingManager.sharedInstance().getAggregateSubject(this.accountId));
  }
  
  public void render()
  {
    switch (QMSyncManager.sharedInstance().getSyncMethod(this.accountId))
    {
    }
    while (this.account.isActiveSyncMail()) {
      switch (QMSyncManager.sharedInstance().getSyncMailDay(this.accountId))
      {
      default: 
        return;
        this.syncMethodItemView.setDetail(getString(2131719997));
        continue;
        this.syncMethodItemView.setDetail(getString(2131719993));
        continue;
        this.syncMethodItemView.setDetail(getString(2131719995));
        break;
      case 20000: 
        this.syncMailCountItemView.setDetail(getString(2131719986));
        return;
      case 10000: 
        this.syncMailCountItemView.setDetail(getString(2131719989));
        return;
      case 10001: 
        this.syncMailCountItemView.setDetail(getString(2131719990));
        return;
      case 10002: 
        this.syncMailCountItemView.setDetail(getString(2131719991));
        return;
      case 10003: 
        this.syncMailCountItemView.setDetail(getString(2131719988));
        return;
      }
    }
    switch (QMSyncManager.sharedInstance().getSyncMailCount(this.accountId))
    {
    default: 
      return;
    case 100: 
      this.syncMailCountItemView.setDetail(getString(2131719982));
      return;
    case 200: 
      this.syncMailCountItemView.setDetail(getString(2131719983));
      return;
    }
    this.syncMailCountItemView.setDetail(getString(2131719981));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity
 * JD-Core Version:    0.7.0.1
 */