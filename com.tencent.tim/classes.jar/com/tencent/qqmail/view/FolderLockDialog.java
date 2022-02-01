package com.tencent.qqmail.view;

import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.EditTextDialogBuilder;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.view.dialog.PasswordDialogBuilder;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class FolderLockDialog
{
  public static final int FOLDER_LOCK_NETWORK_ERROR = 3;
  public static final int FOLDER_LOCK_NORMAL = 1;
  public static final int FOLDER_LOCK_PWD_ERROR = 2;
  private static final String TAG = "FolderLockDialog";
  private Account account = null;
  private int accountId;
  private Context context;
  private int folderId;
  private PasswordDialogBuilder mBuilder;
  private boolean multiLock;
  private QMUIDialog qmDialog;
  private QMTips tips;
  private QMUnlockFolderPwdWatcher watcher;
  
  public FolderLockDialog(Context paramContext, int paramInt1, int paramInt2, QMUnlockFolderPwdWatcher paramQMUnlockFolderPwdWatcher)
  {
    this.context = paramContext;
    this.folderId = paramInt1;
    this.accountId = paramInt2;
    this.watcher = paramQMUnlockFolderPwdWatcher;
    if (paramInt2 == 0) {
      paramContext = AccountManager.shareInstance().getAccountList().iterator();
    }
    for (;;)
    {
      if (paramContext.hasNext())
      {
        paramQMUnlockFolderPwdWatcher = (Account)paramContext.next();
        if (!paramQMUnlockFolderPwdWatcher.isLocked()) {
          continue;
        }
        if (this.account != null) {
          this.multiLock = true;
        }
      }
      else
      {
        return;
      }
      this.account = paramQMUnlockFolderPwdWatcher;
    }
  }
  
  public static boolean isFolderLock(int paramInt)
  {
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    if (paramInt == -4)
    {
      localObject = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((QQMailAccount)localObject).mLockNote)
        {
          bool1 = bool2;
          if (StringUtils.isEmpty(((QQMailAccount)localObject).getEncryptedFolderPwd())) {
            bool1 = true;
          }
        }
      }
    }
    Account localAccount;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            localObject = QMFolderManager.sharedInstance().getFolder(paramInt);
            bool1 = bool2;
          } while (localObject == null);
          localAccount = AccountManager.shareInstance().getAccountList().getAccountById(((QMFolder)localObject).getAccountId());
          bool1 = bool2;
        } while (localAccount == null);
        if ((localAccount.mLockMy) && (((QMFolder)localObject).getType() == 12)) {
          break;
        }
        bool1 = bool2;
      } while (!localAccount.mLockPop);
      bool1 = bool2;
    } while (((QMFolder)localObject).getType() != 13);
    return StringUtils.isEmpty(localAccount.getEncryptedFolderPwd());
  }
  
  public QMUIDialog cancelDialog()
  {
    this.qmDialog.cancel();
    return this.qmDialog;
  }
  
  public QMUIDialog createDialog(int paramInt)
  {
    int j = this.accountId;
    int i = j;
    String str2;
    if (j == 0)
    {
      i = j;
      if (this.account != null)
      {
        j = this.account.getId();
        i = j;
        if (this.multiLock) {
          str2 = "(" + this.account.getEmail() + ")";
        }
      }
    }
    for (;;)
    {
      this.tips = new QMTips(this.context);
      String str1;
      if (paramInt == 3) {
        str1 = QMApplicationContext.sharedInstance().getString(2131696288);
      }
      for (;;)
      {
        this.mBuilder = new PasswordDialogBuilder(this.context);
        ((QMUIDialog.EditTextDialogBuilder)((QMUIDialog.EditTextDialogBuilder)this.mBuilder.setTitle(str1)).setPlaceholder(2131693950).setTransformationMethod(PasswordTransformationMethod.getInstance()).addAction(2131691246, new FolderLockDialog.2(this, j))).addAction(2131696547, new FolderLockDialog.1(this, str2, j));
        this.qmDialog = this.mBuilder.create();
        this.qmDialog.setCanceledOnTouchOutside(true);
        this.qmDialog.setOnCancelListener(new FolderLockDialog.3(this));
        this.qmDialog.setOnDismissListener(new FolderLockDialog.4(this, j));
        this.mBuilder.getEditText().setEnabled(true);
        this.mBuilder.getEditText().setOnKeyListener(new FolderLockDialog.5(this, j));
        KeyBoardHelper.showSoftInputDelay(this.mBuilder.getEditText(), 20L);
        KeyBoardHelper.showSoftInputDelay(this.mBuilder.getEditText(), 200L);
        return this.qmDialog;
        if (paramInt == 2) {
          str1 = QMApplicationContext.sharedInstance().getString(2131718586) + str2;
        } else {
          str1 = QMApplicationContext.sharedInstance().getString(2131693948) + str2;
        }
      }
      str2 = "";
      j = i;
    }
  }
  
  public QMTips dismissTips()
  {
    if (this.tips != null)
    {
      this.tips.dismissTipsManually();
      return this.tips;
    }
    return null;
  }
  
  public QMUIDialog errorDialog()
  {
    if (this.qmDialog != null) {
      this.qmDialog.cancel();
    }
    if (!QMNetworkUtils.isNetworkConnected(this.context)) {
      createDialog(3);
    }
    for (;;)
    {
      showDialog();
      return this.qmDialog;
      createDialog(2);
    }
  }
  
  public EditText getEditText()
  {
    return this.mBuilder.getEditText();
  }
  
  public QMUIDialog hideDialog()
  {
    this.qmDialog.hide();
    return this.qmDialog;
  }
  
  public void hideKeyBoard()
  {
    if (this.mBuilder != null) {
      KeyBoardHelper.hideKeyBoard(this.mBuilder.getEditText());
    }
  }
  
  public boolean isShowing()
  {
    return this.qmDialog.isShowing();
  }
  
  public QMTips loadingTips()
  {
    this.tips.showLoading(2131693949);
    return this.tips;
  }
  
  public void setDialogCancelable(boolean paramBoolean)
  {
    this.qmDialog.setCancelable(paramBoolean);
  }
  
  public QMUIDialog showDialog()
  {
    this.qmDialog.show();
    return this.qmDialog;
  }
  
  public QMUIDialog showDialogTouchOutsideFalse()
  {
    this.qmDialog.show();
    this.qmDialog.setCanceledOnTouchOutside(false);
    return this.qmDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.FolderLockDialog
 * JD-Core Version:    0.7.0.1
 */