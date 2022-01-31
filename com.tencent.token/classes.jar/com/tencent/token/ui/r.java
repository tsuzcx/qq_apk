package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ch;
import com.tencent.token.do;
import com.tmsdk.TMSDKContext;

class r
  implements View.OnClickListener
{
  r(AccountPageActivity paramAccountPageActivity) {}
  
  public void onClick(View paramView)
  {
    if (do.a().e() == null) {
      this.a.showNoAccountTipDialog(this.a, 6, 0);
    }
    for (;;)
    {
      TMSDKContext.saveActionData(1150059);
      return;
      ch.a().a(System.currentTimeMillis(), 5);
      paramView = new Intent(this.a, LoginMsgActivity.class);
      paramView.putExtra("skey", AccountPageActivity.access$2000(this.a));
      this.a.startActivity(paramView);
      AccountPageActivity.mNeedShowIpcMsg = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.r
 * JD-Core Version:    0.7.0.1
 */