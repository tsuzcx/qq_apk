package com.tencent.token.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.RqdApplication;

class ue
  implements View.OnClickListener
{
  ue(RealNameActivity paramRealNameActivity, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.a)
    {
      this.b.mRightOptionImage = null;
      if (RealNameActivity.access$100(this.b).regVersion == 1)
      {
        RealNameActivity.access$500(this.b, false);
        RqdApplication.l().getSharedPreferences("sp_name_global", 0).edit().putBoolean("key_zzb_refused_firsttime", true).commit();
      }
    }
    while (RealNameActivity.access$100(this.b).mRealStatus != 3) {
      for (;;)
      {
        return;
        RealNameActivity.access$500(this.b, true);
      }
    }
    RealNameActivity.access$600(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ue
 * JD-Core Version:    0.7.0.1
 */