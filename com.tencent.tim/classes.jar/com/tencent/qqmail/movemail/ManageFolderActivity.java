package com.tencent.qqmail.movemail;

import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.helper.Helper;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.rule.QMRuleManager;
import com.tencent.qqmail.model.mail.watcher.FolderOperationWatcher;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMTopBar;
import moai.core.watcher.Watchers;

public class ManageFolderActivity
  extends BaseActivityEx
{
  public static final String ARG_ACCOUNT_ID = "arg_account_id";
  public static final String ARG_DEFAULT_FOLDER_NAME = "arg_default_folder_name";
  public static final String ARG_FOLDER_ID = "arg_folder_id";
  public static final String ARG_FOLDER_NAME = "arg_folder_name";
  public static final String ARG_FOR_ONE = "arg_for_one";
  public static final String ARG_IS_QQ_WITH_POP = "arg_is_qq_with_pop";
  public static final String ARG_IS_TAG = "arg_is_tag";
  public static final String ARG_MAILIDS = "arg_mailids";
  public static final String TAG = "ManageFolderActivity";
  private Account account;
  private int accountId;
  private String defaultFoldername;
  private Button delBtn;
  private QMFolder folder;
  private int folderId;
  private FolderOperationWatcher folderOperationWatcher = new ManageFolderActivity.1(this);
  private String foldername;
  private MailContact[] fromAddrs;
  private boolean hideTab;
  private EditText input;
  private boolean isCreate;
  private boolean isQQWithPop;
  private boolean isTag;
  private long[] mailIds;
  private QMTips tips;
  private String title;
  private QMTopBar topBar;
  
  private boolean canCreateWhenNetworkNotReady()
  {
    if ((!this.account.isQQMail()) && (this.isTag)) {
      return true;
    }
    return isNetworkReady();
  }
  
  private void createFolder(String paramString, boolean paramBoolean)
  {
    Threads.runInBackground(new ManageFolderActivity.10(this, paramBoolean, paramString));
  }
  
  public static Intent createIntent(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return createIntentForRename(paramInt, -1, paramString, paramBoolean1, paramBoolean2, false);
  }
  
  public static Intent createIntentForMoveFolder(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long[] paramArrayOfLong, int paramInt2)
  {
    paramString1 = createIntentForRename(paramInt1, -1, paramString1, paramBoolean1, paramBoolean2, true);
    paramString1.putExtra("arg_mailids", paramArrayOfLong);
    paramString1.putExtra("arg_folder_id", paramInt2);
    paramString1.putExtra("arg_default_folder_name", paramString2);
    return paramString1;
  }
  
  public static Intent createIntentForOne(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return createIntentForRename(paramInt, -1, paramString, paramBoolean1, paramBoolean2, true);
  }
  
  public static Intent createIntentForRename(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ManageFolderActivity.class);
    localIntent.putExtra("arg_account_id", paramInt1);
    localIntent.putExtra("arg_folder_id", paramInt2);
    localIntent.putExtra("arg_folder_name", paramString);
    localIntent.putExtra("arg_is_tag", paramBoolean1);
    localIntent.putExtra("arg_is_qq_with_pop", paramBoolean2);
    localIntent.putExtra("arg_for_one", paramBoolean3);
    return localIntent;
  }
  
  private void focusInput()
  {
    this.input.requestFocus();
    this.input.postDelayed(new ManageFolderActivity.8(this), 200L);
  }
  
  private String getFormattedAddress()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.fromAddrs != null) && (this.fromAddrs.length > 0))
    {
      int k = Math.min(this.fromAddrs.length, 2);
      int i = 0;
      if (i < k)
      {
        String str1 = this.fromAddrs[i].getName();
        String str2 = this.fromAddrs[i].getAddress();
        int j;
        if ((str1 != null) && (!str1.equals("")))
        {
          j = 1;
          localStringBuilder.append(str1).append("<");
        }
        for (;;)
        {
          localStringBuilder.append(str2);
          if (j != 0) {
            localStringBuilder.append(">");
          }
          if (i < k - 1) {
            localStringBuilder.append(", ");
          }
          i += 1;
          break;
          j = 0;
        }
      }
      if (this.fromAddrs.length > 2) {
        localStringBuilder.append("...");
      }
    }
    return localStringBuilder.toString();
  }
  
  private boolean isInboxFolder()
  {
    return (this.folder != null) && (this.folder.getType() == 1);
  }
  
  private boolean isNetworkReady()
  {
    if ((!this.isTag) && (!this.account.isQQMail()) && (!QMNetworkUtils.isNetworkConnected(this)))
    {
      QMUIHelper.showToast(QMApplicationContext.sharedInstance(), 2131696288, "");
      DataCollector.logException(7, 5, "Event_Error", QMApplicationContext.sharedInstance().getString(2131696288), false);
      return false;
    }
    return true;
  }
  
  private void moveConfirmDialog(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(2131690666)).setMessage(String.format(getString(2131690665), new Object[] { getFormattedAddress() })).addAction(2131690663, new ManageFolderActivity.12(this, paramRunnable2))).addAction(2131690664, new ManageFolderActivity.11(this, paramRunnable1))).create().show();
  }
  
  private void renameFolder(String paramString)
  {
    Threads.runInBackground(new ManageFolderActivity.9(this, paramString));
  }
  
  private void renderInputAndButton()
  {
    if (this.isQQWithPop)
    {
      this.input.setHint(2131689718);
      this.delBtn.setText(2131692489);
      return;
    }
    if (this.isTag)
    {
      this.input.setHint(2131689823);
      this.delBtn.setText(2131692492);
      return;
    }
    this.input.setHint(2131689777);
    this.delBtn.setText(2131692469);
  }
  
  private void renderTopBar()
  {
    int i = 2131693951;
    if (this.isTag) {
      i = 2131720744;
    }
    if (this.isQQWithPop) {
      i = 2131717016;
    }
    this.title = getString(i);
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.setTitle(this.title).setButtonLeftNormal(2131691246).setButtonRightBlue(2131693745);
  }
  
  private void showQMDialog(String paramString1, String paramString2, Runnable paramRunnable)
  {
    QMUIHelper.showQMDialog(this, paramString1, paramString2, paramRunnable);
  }
  
  private void switchTab(boolean paramBoolean)
  {
    this.input.requestFocus();
    if (paramBoolean)
    {
      findViewById(2131379155).setSelected(false);
      findViewById(2131379161).setSelected(true);
    }
    for (;;)
    {
      this.isTag = paramBoolean;
      renderTopBar();
      renderInputAndButton();
      return;
      findViewById(2131379155).setSelected(true);
      findViewById(2131379161).setSelected(false);
    }
  }
  
  public void finishWithNoCheck()
  {
    hideKeyBoard();
    super.finishWithNoCheck();
  }
  
  public void initDataSource()
  {
    boolean bool = false;
    this.isTag = getIntent().getBooleanExtra("arg_is_tag", false);
    this.isQQWithPop = getIntent().getBooleanExtra("arg_is_qq_with_pop", false);
    this.foldername = getIntent().getStringExtra("arg_folder_name");
    this.defaultFoldername = getIntent().getStringExtra("arg_default_folder_name");
    this.folderId = getIntent().getIntExtra("arg_folder_id", 0);
    this.hideTab = getIntent().getBooleanExtra("arg_for_one", false);
    this.accountId = getIntent().getIntExtra("arg_account_id", 0);
    this.account = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
    this.mailIds = getIntent().getLongArrayExtra("arg_mailids");
    this.folder = QMFolderManager.sharedInstance().getFolder(this.folderId);
    if (this.foldername == null) {
      bool = true;
    }
    this.isCreate = bool;
    if ((this.mailIds != null) && (this.mailIds.length > 0)) {
      this.fromAddrs = QMMailManager.sharedInstance().getMailContacts(this.mailIds);
    }
  }
  
  public void initDom()
  {
    boolean bool = true;
    this.input = ((EditText)findViewById(2131367376));
    this.delBtn = ((Button)findViewById(2131365680));
    switchTab(this.isTag);
    int i;
    View localView;
    if ((!this.hideTab) && (this.isCreate))
    {
      i = 1;
      localView = findViewById(2131379137);
      if (i == 0) {
        break label197;
      }
      i = 0;
      label68:
      localView.setVisibility(i);
      if (this.foldername == null) {
        break label203;
      }
      this.input.setText(this.foldername);
      this.input.setSelection(this.input.getText().length());
      this.delBtn.setVisibility(0);
      label118:
      if ((this.isCreate) && (this.defaultFoldername != null))
      {
        this.input.setText(this.defaultFoldername);
        this.input.setSelection(this.input.getText().length());
      }
      localView = this.topBar.getButtonRight();
      if (this.input.getText().toString().length() == 0) {
        break label215;
      }
    }
    for (;;)
    {
      localView.setEnabled(bool);
      return;
      i = 0;
      break;
      label197:
      i = 8;
      break label68;
      label203:
      this.delBtn.setVisibility(8);
      break label118;
      label215:
      bool = false;
    }
  }
  
  public void initUI()
  {
    setContentView(2131559525);
    this.tips = new QMTips(this);
    this.tips.setCanceledOnTouchOutside(false);
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.folderOperationWatcher, paramBoolean);
    this.topBar.getButtonLeft().setOnClickListener(new ManageFolderActivity.2(this));
    this.topBar.getButtonRight().setOnClickListener(new ManageFolderActivity.3(this));
    findViewById(2131379161).setOnClickListener(new ManageFolderActivity.4(this));
    findViewById(2131379155).setOnClickListener(new ManageFolderActivity.5(this));
    Helper.initEditTextAndClearButton((EditText)findViewById(2131367376), (Button)findViewById(2131364664));
    this.input.addTextChangedListener(new ManageFolderActivity.6(this));
    paramBoolean = QMRuleManager.sharedInstance().isAutoMove(this.accountId, this.folderId);
    int i;
    int j;
    if (this.isTag)
    {
      i = 2131692494;
      this.title = getString(2131692492);
      if (!this.isTag) {
        break label269;
      }
      j = 2131692493;
    }
    for (;;)
    {
      findViewById(2131365680).setOnClickListener(new ManageFolderActivity.7(this, i, j));
      return;
      if (this.isQQWithPop)
      {
        i = 2131692487;
        break;
      }
      if (this.account.isQQMail())
      {
        if (paramBoolean) {}
        for (i = 2131692472;; i = 2131692471)
        {
          this.title = getString(2131692469);
          break;
        }
      }
      if (paramBoolean) {}
      for (i = 2131692477;; i = 2131692476)
      {
        this.title = getString(2131692469);
        break;
      }
      label269:
      if ((this.isQQWithPop) || (!this.account.isQQMail())) {
        j = 2131692474;
      } else {
        j = 2131692470;
      }
    }
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render()
  {
    focusInput();
    if (!canCreateWhenNetworkNotReady()) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity
 * JD-Core Version:    0.7.0.1
 */