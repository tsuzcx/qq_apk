package com.tencent.token.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.ch;
import com.tencent.token.global.RqdApplication;

class xf
  implements View.OnClickListener
{
  xf(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity) {}
  
  public void onClick(View paramView)
  {
    if ((RealNameStep1InputNameIdActivity.access$1800(this.a) != null) && (RealNameStep1InputNameIdActivity.access$1900(this.a) != null))
    {
      RealNameStep1InputNameIdActivity.access$1800(this.a).clearFocus();
      RealNameStep1InputNameIdActivity.access$1900(this.a).clearFocus();
    }
    if (RealNameStep1InputNameIdActivity.access$1000(this.a))
    {
      if (RealNameStep1InputNameIdActivity.access$3300(this.a, RealNameStep1InputNameIdActivity.access$1900(this.a).getText().toString())) {
        break label119;
      }
      RealNameStep1InputNameIdActivity.access$700(this.a).setVisibility(0);
      RealNameStep1InputNameIdActivity.access$700(this.a).setText(this.a.getResources().getString(2131231651));
      RealNameStep1InputNameIdActivity.access$700(this.a).setTextColor(-65536);
    }
    label119:
    do
    {
      return;
      if (!RealNameStep1InputNameIdActivity.access$3100(this.a))
      {
        if (RealNameStep1InputNameIdActivity.access$1600(this.a) != AddFaceResultActivity.ADD_FACE_UPDATE_ZZB_DEFAULT_VALUE) {
          ch.a().a(System.currentTimeMillis(), 216);
        }
        this.a.showUserDialogComfig(2130968730, null, String.format(this.a.getResources().getString(2131231367), new Object[] { RealNameStep1InputNameIdActivity.access$1800(this.a).getText().toString(), RealNameStep1InputNameIdActivity.access$1900(this.a).getText().toString() }), 0, new xg(this), new xh(this));
        return;
      }
      this.a.dismiss();
      RealNameStep1InputNameIdActivity.access$3400(this.a);
    } while (RealNameStep1InputNameIdActivity.access$1600(this.a) == AddFaceResultActivity.ADD_FACE_UPDATE_ZZB_DEFAULT_VALUE);
    RqdApplication.l().getSharedPreferences("sp_name_global", 0).edit().putBoolean("key_zzb_refused_firsttime", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xf
 * JD-Core Version:    0.7.0.1
 */