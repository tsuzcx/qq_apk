package com.tencent.securemodule;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.securemodule.ui.TransparentActivity;
import com.tencent.securemodule.ui.TransparentActivity.a;

public class am
  implements DialogInterface.OnClickListener
{
  public am(TransparentActivity paramTransparentActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TransparentActivity.c(this.a).sendEmptyMessage(1);
    new TransparentActivity.a(this.a, 0).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.securemodule.am
 * JD-Core Version:    0.7.0.1
 */