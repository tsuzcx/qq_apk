package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import arul;
import arzs;

public class AppInterface$2
  implements Runnable
{
  AppInterface$2(AppInterface paramAppInterface, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    Resources localResources = this.this$0.activity.getResources();
    arzs localarzs = new arzs(this.this$0.activity);
    localarzs.a(2131692668, this.ae, true);
    localarzs.b(2131692669, this.ae, true);
    localarzs.a(localResources.getString(2131692674));
    localarzs.b(localResources.getString(2131692657));
    localarzs.setCancelable(false);
    localarzs.setOnDismissListener(new arul(this));
    if ((this.this$0.activity != null) && (!this.this$0.activity.isFinishing())) {
      localarzs.show();
    }
    this.this$0.tipDialog = localarzs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.2
 * JD-Core Version:    0.7.0.1
 */