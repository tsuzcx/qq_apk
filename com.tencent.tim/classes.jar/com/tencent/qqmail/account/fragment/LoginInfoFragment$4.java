package com.tencent.qqmail.account.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class LoginInfoFragment$4
  implements View.OnClickListener
{
  LoginInfoFragment$4(LoginInfoFragment paramLoginInfoFragment) {}
  
  public void onClick(View paramView)
  {
    if ((LoginInfoFragment.access$400(this.this$0) != null) && (LoginInfoFragment.access$400(this.this$0).isChecked()))
    {
      LoginInfoFragment.access$400(this.this$0).setChecked(false);
      LoginInfoFragment.access$500(this.this$0, false);
      QMCalendarManager.getInstance().cancelRequest(LoginInfoFragment.access$200(this.this$0));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginInfoFragment.4
 * JD-Core Version:    0.7.0.1
 */