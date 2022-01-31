package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.core.bean.j;
import com.tencent.token.utils.w;
import java.lang.reflect.Field;

class mk
  implements DialogInterface.OnClickListener
{
  mk(IndexActivity paramIndexActivity, String paramString, j paramj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    w.a(this.c, this.a);
    if (3 == this.b.a) {}
    try
    {
      Field localField = paramDialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
      localField.setAccessible(true);
      localField.set(paramDialogInterface, Boolean.valueOf(false));
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mk
 * JD-Core Version:    0.7.0.1
 */