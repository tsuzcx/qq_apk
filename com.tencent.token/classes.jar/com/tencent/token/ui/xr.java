package com.tencent.token.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.RqdApplication;

final class xr
  implements View.OnClickListener
{
  xr(xq paramxq) {}
  
  public final void onClick(View paramView)
  {
    this.a.a.dismiss();
    RealNameStep1InputNameIdActivity.access$3100(this.a.a);
    RealNameStep1InputNameIdActivity.access$2802(this.a.a, true);
    RqdApplication.i().getSharedPreferences("sp_name_global", 0).edit().putBoolean("key_zzb_refused_firsttime", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xr
 * JD-Core Version:    0.7.0.1
 */