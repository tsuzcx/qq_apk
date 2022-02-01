package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.SpannableString;
import aqha;
import aqju;

public final class FMDialogUtil$3
  implements Runnable
{
  public FMDialogUtil$3(Context paramContext, CharSequence paramCharSequence, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void run()
  {
    if (((this.val$context instanceof Activity)) && (((Activity)this.val$context).isFinishing())) {}
    do
    {
      return;
      if ((this.X instanceof String))
      {
        aqha.a(this.val$context, 230, this.val$title, (String)this.X, 2131693507, 2131693512, this.J, this.K).show();
        return;
      }
    } while (!(this.X instanceof SpannableString));
    aqha.a(this.val$context, 230, this.val$title, this.X, 2131693507, 2131693512, this.J, this.K).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMDialogUtil.3
 * JD-Core Version:    0.7.0.1
 */