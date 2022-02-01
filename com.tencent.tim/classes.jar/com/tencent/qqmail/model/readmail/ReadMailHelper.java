package com.tencent.qqmail.model.readmail;

import android.content.Context;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;

public class ReadMailHelper
{
  public static final String TAG = "ReadMailHelper";
  
  private static void expireAttachActionAfterSync(ArrayList<Object> paramArrayList, AfterValidateMail paramAfterValidateMail, String paramString1, String paramString2, Context paramContext)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (paramArrayList.size() > 1) {}
      for (paramArrayList = String.format(paramContext.getString(2131690841), new Object[] { ((MailBigAttach)paramArrayList.get(0)).getName() + QMUIKit.ELLIPSIZE_FIXED, Integer.valueOf(paramArrayList.size()), paramString1 });; paramArrayList = String.format(paramContext.getString(2131690840), new Object[] { ((MailBigAttach)paramArrayList.get(0)).getName() + QMUIKit.ELLIPSIZE_FIXED, paramString1 }))
      {
        ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramContext).setMessage(paramArrayList).addAction(2131691246, new ReadMailHelper.4())).addAction(paramString2, new ReadMailHelper.3(paramAfterValidateMail))).create().show();
        return;
      }
    }
    paramAfterValidateMail.action();
  }
  
  private static void expireAttachDraftAfterSync(ArrayList<Object> paramArrayList, AfterValidateMail paramAfterValidateMail, Context paramContext)
  {
    expireAttachActionAfterSync(paramArrayList, paramAfterValidateMail, paramContext.getString(2131693003), paramContext.getString(2131692260), paramContext);
  }
  
  public static void expireAttachDraftEditLocal(AfterValidateMail paramAfterValidateMail, MailUI paramMailUI, Context paramContext)
  {
    expireAttachDraftAfterSync(BigAttachHelper.getExpireBigAttaches(paramMailUI), paramAfterValidateMail, paramContext);
  }
  
  private static void expireAttachForwardAfterSync(ArrayList<Object> paramArrayList, AfterValidateMail paramAfterValidateMail, Context paramContext)
  {
    expireAttachActionAfterSync(paramArrayList, paramAfterValidateMail, paramContext.getString(2131693977), paramContext.getString(2131692258), paramContext);
  }
  
  public static void expireAttachForwardLocal(AfterValidateMail paramAfterValidateMail, MailUI paramMailUI, Context paramContext)
  {
    expireAttachForwardAfterSync(BigAttachHelper.getExpireBigAttaches(paramMailUI), paramAfterValidateMail, paramContext);
  }
  
  private static void expireAttachReEditAfterSync(ArrayList<Object> paramArrayList, AfterValidateMail paramAfterValidateMail, Context paramContext)
  {
    expireAttachActionAfterSync(paramArrayList, paramAfterValidateMail, paramContext.getString(2131718665), paramContext.getString(2131692260), paramContext);
  }
  
  public static void expireAttachReEditLocal(AfterValidateMail paramAfterValidateMail, MailUI paramMailUI, Context paramContext)
  {
    expireAttachReEditAfterSync(BigAttachHelper.getExpireBigAttaches(paramMailUI), paramAfterValidateMail, paramContext);
  }
  
  public static void reEditSepMail(AfterValidateMail paramAfterValidateMail, MailUI paramMailUI, Context paramContext)
  {
    if (paramMailUI.getStatus().isSepCpy())
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramContext).setMessage(paramContext.getString(2131718319)).addAction(2131691246, new ReadMailHelper.2())).addAction(2131692260, new ReadMailHelper.1(paramAfterValidateMail))).create().show();
      return;
    }
    paramAfterValidateMail.action();
  }
  
  public static abstract interface AfterValidateMail
  {
    public abstract void action();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.readmail.ReadMailHelper
 * JD-Core Version:    0.7.0.1
 */