package com.tencent.qqmail.account.helper;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Process;
import android.widget.EditText;
import com.tencent.qqmail.BaseActivity;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.PickerViewControl;
import com.tencent.qqmail.model.alias.AliasItem;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.ConfirmMessageDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.dialog.PasswordDialogBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class LoginUIHelper
{
  private static final String TAG = "LoginUIHelper";
  private static QMUIDialog currentDialog = null;
  
  private static void clearCurrentDialog()
  {
    try
    {
      if (currentDialog != null) {
        currentDialog = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static QMUIDialog createErrorDialog(Context paramContext, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramContext = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramContext).setTitle(paramString1)).setMessage(paramCharSequence).addAction(paramString3, new LoginUIHelper.4(paramOnClickListener2))).addAction(paramString2, new LoginUIHelper.3(paramOnClickListener1))).create();
    paramContext.setOnDismissListener(new LoginUIHelper.5(paramOnDismissListener));
    return paramContext;
  }
  
  private static QMUIDialog createErrorDialog(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramContext = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramContext).setTitle(paramString1)).setMessage(paramString2).addAction(paramString3, new LoginUIHelper.1(paramOnClickListener))).create();
    paramContext.setOnDismissListener(new LoginUIHelper.2(paramOnDismissListener));
    return paramContext;
  }
  
  public static void createExitAppDialog(BaseActivity paramBaseActivity)
  {
    paramBaseActivity = new QMUIDialog.ConfirmMessageDialogBuilder(paramBaseActivity);
    ((QMUIDialog.ConfirmMessageDialogBuilder)((QMUIDialog.ConfirmMessageDialogBuilder)((QMUIDialog.ConfirmMessageDialogBuilder)paramBaseActivity.setTitle(2131696374)).setMessage(2131696375).setChecked(true).addAction(2131691246, new LoginUIHelper.22())).addAction(2131691552, new LoginUIHelper.21(paramBaseActivity))).create().show();
  }
  
  private static QMUIDialog createSecondPasswordDialog(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    PasswordDialogBuilder localPasswordDialogBuilder = new PasswordDialogBuilder(paramContext);
    if ((paramString != null) && (paramString.length() > 0)) {
      localPasswordDialogBuilder.setTitle(paramString);
    }
    localPasswordDialogBuilder.setPlaceholder(2131695561);
    localPasswordDialogBuilder.setInputType(129);
    localPasswordDialogBuilder.addAction(2131691246, new LoginUIHelper.15(paramOnClickListener2));
    localPasswordDialogBuilder.addAction(2131696547, new LoginUIHelper.16(paramOnClickListener1));
    localPasswordDialogBuilder.setNeedEye(true);
    if (paramInt == 6) {
      localPasswordDialogBuilder.setLeftAction(paramContext.getResources().getString(2131695526), new LoginUIHelper.17(paramContext));
    }
    paramContext = localPasswordDialogBuilder.create();
    paramContext.setOnDismissListener(new LoginUIHelper.18(paramOnDismissListener));
    paramContext.setCanceledOnTouchOutside(false);
    paramString = localPasswordDialogBuilder.getEditText();
    paramString.setOnKeyListener(new LoginUIHelper.19(paramOnClickListener1, paramContext));
    setCurrentDialogAndShow(paramContext, true);
    KeyBoardHelper.showSoftInputDelay(paramString, 500L);
    return paramContext;
  }
  
  public static void killAllQMProcess()
  {
    killAllQMProcess(false);
  }
  
  private static void killAllQMProcess(boolean paramBoolean)
  {
    int j = Process.myUid();
    int i = Process.myPid();
    Object localObject1 = QMApplicationContext.sharedInstance().getPackageName();
    Object localObject2 = ((ActivityManager)QMApplicationContext.sharedInstance().getSystemService("activity")).getRunningAppProcesses();
    ArrayList localArrayList = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
      if ((localRunningAppProcessInfo != null) && (localRunningAppProcessInfo.uid == j) && ((!paramBoolean) || (!((String)localObject1 + ":Push").equals(localRunningAppProcessInfo.processName)))) {
        localArrayList.add(Integer.valueOf(localRunningAppProcessInfo.pid));
      }
    }
    localObject1 = localArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      j = ((Integer)((Iterator)localObject1).next()).intValue();
      if (j != i) {
        Process.killProcess(j);
      }
    }
    Process.killProcess(i);
  }
  
  public static void processCGIError(Account paramAccount, QMCGIError paramQMCGIError, Context paramContext, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Threads.runOnMainThread(new LoginUIHelper.7(paramQMCGIError, paramContext, paramOnClickListener, paramOnDismissListener, paramAccount));
  }
  
  public static void processCustomError(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Threads.runOnMainThread(new LoginUIHelper.6(paramContext, paramString, paramOnClickListener, paramOnDismissListener, paramBoolean));
  }
  
  public static void processDomainError(Context paramContext, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    processCustomError(paramContext, paramContext.getString(2131695543), false, paramOnClickListener, paramOnDismissListener);
  }
  
  public static void processImapError(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Threads.runOnMainThread(new LoginUIHelper.11(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramOnDismissListener));
  }
  
  public static void processNetworkError(Context paramContext, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    processCustomError(paramContext, paramContext.getString(2131695513), false, paramOnClickListener, paramOnDismissListener);
  }
  
  public static void processNormalError(int paramInt, Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    QMLog.log(6, "LoginUIHelper", "processNormalError errorType:" + paramInt + ",errMsg:" + paramString);
    Threads.runOnMainThread(new LoginUIHelper.14(paramInt, paramContext, paramString, paramOnClickListener1, paramOnDismissListener, paramOnClickListener2));
  }
  
  public static void processQQAccountAliasExitError(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Threads.runOnMainThread(new LoginUIHelper.9(paramContext, paramString, paramOnClickListener1, paramOnClickListener2, paramOnDismissListener));
  }
  
  public static void processQQAccountNoExitError(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Threads.runOnMainThread(new LoginUIHelper.10(paramContext, paramOnClickListener1, paramOnClickListener2, paramOnDismissListener));
  }
  
  public static void processQQPwdError(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Threads.runOnMainThread(new LoginUIHelper.12(paramContext, paramString, paramOnClickListener1, paramOnClickListener2, paramOnDismissListener));
  }
  
  public static void processRecoverMobileError(Context paramContext, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Threads.runOnMainThread(new LoginUIHelper.13(paramContext, paramCharSequence, paramOnClickListener1, paramOnClickListener2, paramOnDismissListener));
  }
  
  public static void processSSLError(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Threads.runOnMainThread(new LoginUIHelper.20(paramContext, paramString, paramOnClickListener1, paramOnClickListener2, paramOnDismissListener, paramBoolean));
  }
  
  public static void processUnknownError(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    processCustomError(paramContext, paramString, false, paramOnClickListener, paramOnDismissListener);
  }
  
  public static void processWtLoginError(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Threads.runOnMainThread(new LoginUIHelper.8(paramContext, paramString1, paramString2, paramOnClickListener1, paramOnClickListener2, paramOnDismissListener));
  }
  
  /* Error */
  private static void setCurrentDialogAndShow(QMUIDialog paramQMUIDialog, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +32 -> 36
    //   7: aload_0
    //   8: invokevirtual 397	com/tencent/qqmail/qmui/dialog/QMUIDialog:getContext	()Landroid/content/Context;
    //   11: instanceof 399
    //   14: ifeq +22 -> 36
    //   17: aload_0
    //   18: invokevirtual 397	com/tencent/qqmail/qmui/dialog/QMUIDialog:getContext	()Landroid/content/Context;
    //   21: checkcast 399	android/app/Activity
    //   24: invokevirtual 402	android/app/Activity:isFinishing	()Z
    //   27: istore_1
    //   28: iload_1
    //   29: ifeq +7 -> 36
    //   32: ldc 2
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: putstatic 17	com/tencent/qqmail/account/helper/LoginUIHelper:currentDialog	Lcom/tencent/qqmail/qmui/dialog/QMUIDialog;
    //   40: getstatic 17	com/tencent/qqmail/account/helper/LoginUIHelper:currentDialog	Lcom/tencent/qqmail/qmui/dialog/QMUIDialog;
    //   43: invokevirtual 128	com/tencent/qqmail/qmui/dialog/QMUIDialog:show	()V
    //   46: goto -14 -> 32
    //   49: astore_0
    //   50: aconst_null
    //   51: putstatic 17	com/tencent/qqmail/account/helper/LoginUIHelper:currentDialog	Lcom/tencent/qqmail/qmui/dialog/QMUIDialog;
    //   54: goto -22 -> 32
    //   57: astore_0
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramQMUIDialog	QMUIDialog
    //   0	63	1	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   40	46	49	java/lang/Exception
    //   7	28	57	finally
    //   36	40	57	finally
    //   40	46	57	finally
    //   50	54	57	finally
  }
  
  public static void showGesPwdAccountPicker(Activity paramActivity, int paramInt, SelectPicker paramSelectPicker)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = AccountManager.shareInstance().getAccountList().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Account)((Iterator)localObject1).next();
      if (!((Account)localObject2).isGMail()) {
        localArrayList.add(localObject2);
      }
    }
    localObject1 = new PickerViewControl();
    ((PickerViewControl)localObject1).setGroup(false);
    ((PickerViewControl)localObject1).setTitle("选择帐号");
    Object localObject2 = new ArrayList();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      AliasItem localAliasItem = new AliasItem();
      localAliasItem.setAccountId(localAccount.getId());
      localAliasItem.setAlias(localAccount.getEmail());
      ((ArrayList)localObject2).add(localAliasItem);
    }
    ((PickerViewControl)localObject1).appendData((List)localObject2);
    ((PickerViewControl)localObject1).setDefaultSelect(((Account)localArrayList.get(paramInt)).getEmail());
    ((PickerViewControl)localObject1).setCallback(new LoginUIHelper.23(paramActivity, paramSelectPicker, localArrayList));
    ((PickerViewControl)localObject1).show();
  }
  
  public static abstract interface SelectPicker
  {
    public abstract void select(int paramInt, Account paramAccount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.LoginUIHelper
 * JD-Core Version:    0.7.0.1
 */