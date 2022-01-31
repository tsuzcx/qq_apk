package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;

final class ad
  implements DialogInterface.OnClickListener
{
  ad(aa paramaa) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ax.a().e();
    if (paramDialogInterface == null) {
      return;
    }
    Intent localIntent = new Intent(this.a.a, WtLoginAccountInput.class);
    localIntent.putExtra("page_id", 8);
    localIntent.putExtra("intent.uin", paramDialogInterface.mRealUin);
    this.a.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ad
 * JD-Core Version:    0.7.0.1
 */