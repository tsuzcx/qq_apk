package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;

class ck
  implements View.OnClickListener
{
  ck(CheckMobileAvailableActivity paramCheckMobileAvailableActivity) {}
  
  public void onClick(View paramView)
  {
    if (CheckMobileAvailableActivity.access$200(this.a) == 0)
    {
      this.a.startTimeTask();
      this.a.showProgressDialog();
      cw.a().a("", CheckMobileAvailableActivity.access$300(this.a).mRealUin, 1, 1, "", CheckMobileAvailableActivity.access$900(this.a));
    }
    do
    {
      return;
      if (CheckMobileAvailableActivity.access$200(this.a) == 5)
      {
        paramView = new Intent(this.a, RealNameSmsContentTipActivity.class);
        paramView.putExtra("realname_result", CheckMobileAvailableActivity.access$1000(this.a));
        paramView.putExtra("real_uin", CheckMobileAvailableActivity.access$800(this.a));
        paramView.putExtra("realname_mobile", CheckMobileAvailableActivity.access$1100(this.a));
        paramView.putExtra("scene_id", CheckMobileAvailableActivity.access$500(this.a));
        paramView.putExtra("zzb_recommend_view", CheckMobileAvailableActivity.access$1200(this.a));
        paramView.putExtra("up_sms_scene_id", CheckMobileAvailableActivity.access$200(this.a));
        this.a.startActivity(paramView);
        return;
      }
      if (CheckMobileAvailableActivity.access$200(this.a) == 6)
      {
        this.a.startTimeTask();
        this.a.showProgressDialog();
        cw.a().a("", CheckMobileAvailableActivity.access$800(this.a), 1, 3, "", CheckMobileAvailableActivity.access$900(this.a));
        return;
      }
    } while (CheckMobileAvailableActivity.access$200(this.a) != 7);
    this.a.startTimeTask();
    this.a.showProgressDialog();
    cw.a().a("", CheckMobileAvailableActivity.access$800(this.a), 1, 5, "", CheckMobileAvailableActivity.access$900(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ck
 * JD-Core Version:    0.7.0.1
 */