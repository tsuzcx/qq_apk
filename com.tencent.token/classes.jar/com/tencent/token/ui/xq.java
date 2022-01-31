package com.tencent.token.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.global.RqdApplication;

final class xq
  implements View.OnClickListener
{
  xq(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity) {}
  
  public final void onClick(View paramView)
  {
    if (RealNameStep1InputNameIdActivity.access$1000(this.a))
    {
      if (!RealNameStep1InputNameIdActivity.access$3000(this.a, RealNameStep1InputNameIdActivity.access$1700(this.a).getText().toString()))
      {
        RealNameStep1InputNameIdActivity.access$700(this.a).setVisibility(0);
        RealNameStep1InputNameIdActivity.access$700(this.a).setText(this.a.getResources().getString(2131362553));
        RealNameStep1InputNameIdActivity.access$700(this.a).setTextColor(-65536);
      }
    }
    else {
      return;
    }
    if (!RealNameStep1InputNameIdActivity.access$2800(this.a))
    {
      this.a.showUserDialogComfig(2130903168, null, String.format(this.a.getResources().getString(2131362540), new Object[] { RealNameStep1InputNameIdActivity.access$1600(this.a).getText().toString(), RealNameStep1InputNameIdActivity.access$1700(this.a).getText().toString() }), 0, new xr(this), new xs(this));
      return;
    }
    this.a.dismiss();
    RealNameStep1InputNameIdActivity.access$3100(this.a);
    RqdApplication.i().getSharedPreferences("sp_name_global", 0).edit().putBoolean("key_zzb_refused_firsttime", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xq
 * JD-Core Version:    0.7.0.1
 */