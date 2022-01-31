package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class QQCustomContextMenuDialog
  extends QQCustomDialog
{
  QQCustomMenu a;
  
  public QQCustomContextMenuDialog(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQCustomContextMenuDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected QQCustomContextMenuDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramQQCustomMenu == null) {}
    do
    {
      return;
      this.a = paramQQCustomMenu;
      String[] arrayOfString = new String[paramQQCustomMenu.a()];
      int i = 0;
      while (i < paramQQCustomMenu.a())
      {
        arrayOfString[i] = paramQQCustomMenu.a(i).a();
        i += 1;
      }
      setItems(arrayOfString, paramOnClickListener);
      paramQQCustomMenu = paramQQCustomMenu.a();
    } while (paramQQCustomMenu == null);
    setTitle(paramQQCustomMenu);
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    QQCustomMenuItem localQQCustomMenuItem = this.a.a(paramInt);
    if (localQQCustomMenuItem != null) {
      return localQQCustomMenuItem.a();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomContextMenuDialog
 * JD-Core Version:    0.7.0.1
 */