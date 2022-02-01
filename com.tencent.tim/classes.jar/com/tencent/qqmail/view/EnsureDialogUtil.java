package com.tencent.qqmail.view;

import android.content.Context;
import androidx.annotation.IdRes;
import androidx.annotation.StringRes;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

public class EnsureDialogUtil
{
  public static void ensureDialog(Context paramContext, @IdRes int paramInt1, @IdRes int paramInt2, @IdRes int paramInt3, @IdRes int paramInt4, Callback paramCallback)
  {
    paramContext = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramContext).setTitle(paramInt1)).setMessage(paramInt2).addAction(paramInt3, new EnsureDialogUtil.2(paramCallback))).addAction(0, paramInt4, 0, new EnsureDialogUtil.1(paramCallback))).create();
    paramContext.setCancelable(false);
    paramContext.show();
  }
  
  public static void ensureDialog(Context paramContext, String paramString1, String paramString2, @StringRes int paramInt1, @StringRes int paramInt2, Callback paramCallback)
  {
    paramContext = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramContext).setTitle(paramString1)).setMessage(paramString2).addAction(paramInt1, new EnsureDialogUtil.4(paramCallback))).addAction(0, paramInt2, 0, new EnsureDialogUtil.3(paramCallback))).create();
    paramContext.setCancelable(false);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
  }
  
  public static abstract interface Callback
  {
    public abstract void ensure(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.EnsureDialogUtil
 * JD-Core Version:    0.7.0.1
 */