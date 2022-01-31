package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.do;
import com.tmsdk.TMSDKContext;

class y
  implements View.OnClickListener
{
  y(AccountPageActivity paramAccountPageActivity) {}
  
  public void onClick(View paramView)
  {
    TMSDKContext.saveActionData(1150058);
    if (do.a().e() == null) {
      this.a.showNoAccountTipDialog(this.a, 4, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.y
 * JD-Core Version:    0.7.0.1
 */