package com.tencent.qqmail.account.fragment;

import android.content.Intent;
import android.net.VpnService;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginGmailAuthFragment$8
  implements View.OnClickListener
{
  LoginGmailAuthFragment$8(LoginGmailAuthFragment paramLoginGmailAuthFragment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = VpnService.prepare(this.this$0.getActivity());
    if (localIntent != null) {
      this.this$0.startActivityForResult(localIntent, 0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.onActivityResult(0, -1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginGmailAuthFragment.8
 * JD-Core Version:    0.7.0.1
 */