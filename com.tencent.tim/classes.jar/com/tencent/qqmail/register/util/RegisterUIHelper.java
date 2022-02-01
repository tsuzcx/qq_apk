package com.tencent.qqmail.register.util;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.utilities.thread.Threads;

public class RegisterUIHelper
{
  private static QMUIDialog currentDialog;
  
  public static void createErrorDialog(Context paramContext, String paramString)
  {
    createErrorDialog(paramContext, paramString, null);
  }
  
  public static void createErrorDialog(Context paramContext, String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Threads.runOnMainThread(new RegisterUIHelper.1(paramContext, paramString, paramOnDismissListener));
  }
  
  public static void createErrorRegisterDialog(Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    createErrorDialog(paramContext, paramContext.getString(2131718697), paramOnDismissListener);
  }
  
  public static void createMessageDialog(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Threads.runOnMainThread(new RegisterUIHelper.4(paramContext, paramString1, paramString2, paramString4, paramOnClickListener2, paramString3, paramOnClickListener1, paramOnDismissListener));
  }
  
  public static void createOverResendMsgDialog(Context paramContext)
  {
    createErrorDialog(paramContext, paramContext.getString(2131718702));
  }
  
  public static void createQuitRegisterDialog(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Threads.runOnMainThread(new RegisterUIHelper.3(paramContext, paramString1, paramString2, paramString4, paramOnClickListener2, paramString3, paramOnClickListener1, paramOnDismissListener));
  }
  
  public static void createTipsDialog(Context paramContext, String paramString)
  {
    createTipsDialog(paramContext, paramString, null);
  }
  
  public static void createTipsDialog(Context paramContext, String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Threads.runOnMainThread(new RegisterUIHelper.2(paramContext, paramString, paramOnDismissListener));
  }
  
  private static void dismissCurrentDialog()
  {
    if (currentDialog != null)
    {
      currentDialog.dismiss();
      currentDialog = null;
    }
  }
  
  private static void setCurrentDialog(QMUIDialog paramQMUIDialog)
  {
    currentDialog = paramQMUIDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.util.RegisterUIHelper
 * JD-Core Version:    0.7.0.1
 */