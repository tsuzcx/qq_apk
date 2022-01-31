package com.tencent.token.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.RqdApplication;

final class ur
  implements View.OnClickListener
{
  ur(RealNameActivity paramRealNameActivity, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    if (this.a) {
      if (RealNameActivity.access$100(this.b).regVersion == 1)
      {
        RealNameActivity.access$300(this.b, false);
        RqdApplication.i().getSharedPreferences("sp_name_global", 0).edit().putBoolean("key_zzb_refused_firsttime", true).commit();
      }
    }
    while (RealNameActivity.access$100(this.b).mRealStatus != 3) {
      for (;;)
      {
        return;
        RealNameActivity.access$300(this.b, true);
      }
    }
    RealNameActivity.access$400(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ur
 * JD-Core Version:    0.7.0.1
 */