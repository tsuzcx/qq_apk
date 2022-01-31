package com.tencent.token.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.RqdApplication;

class xg
  implements View.OnClickListener
{
  xg(xf paramxf) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    RealNameStep1InputNameIdActivity.access$3400(this.a.a);
    RealNameStep1InputNameIdActivity.access$3102(this.a.a, true);
    RqdApplication.l().getSharedPreferences("sp_name_global", 0).edit().putBoolean("key_zzb_refused_firsttime", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xg
 * JD-Core Version:    0.7.0.1
 */