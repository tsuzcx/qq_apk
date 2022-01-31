package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.token.ch;
import com.tencent.token.do;
import com.tmsdk.TMSDKContext;

class t
  implements View.OnClickListener
{
  t(AccountPageActivity paramAccountPageActivity) {}
  
  public void onClick(View paramView)
  {
    if (do.a().e() == null) {
      this.a.showNoAccountTipDialog(this.a, 5, 0);
    }
    for (;;)
    {
      TMSDKContext.saveActionData(1150062);
      return;
      ch.a().a(System.currentTimeMillis(), 4);
      AccountPageActivity.access$3000(this.a).setVisibility(4);
      paramView = new Intent(this.a, OpreateMsgActivity.class);
      this.a.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.t
 * JD-Core Version:    0.7.0.1
 */