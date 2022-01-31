package com.tencent.token.ui;

import android.app.Dialog;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.fk;
import com.tencent.token.global.RqdApplication;

class ol
  implements View.OnClickListener
{
  ol(LogoActivity paramLogoActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    RqdApplication.a();
    fk.a("privacy_dialog_agree_time", System.currentTimeMillis());
    if (Build.VERSION.SDK_INT >= 23)
    {
      LogoActivity.access$000(this.b);
      return;
    }
    Log.i("SecureGuideUtil", "andriod 版本小于23，无需引导权限");
    LogoActivity.access$100(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ol
 * JD-Core Version:    0.7.0.1
 */