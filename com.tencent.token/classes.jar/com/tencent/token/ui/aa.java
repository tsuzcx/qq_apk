package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.do;
import com.tmsdk.TMSDKContext;

class aa
  implements View.OnClickListener
{
  aa(AccountPageActivity paramAccountPageActivity) {}
  
  public void onClick(View paramView)
  {
    if (do.a().e() == null) {
      this.a.showNoAccountTipDialog(this.a, 10, 0);
    }
    TMSDKContext.saveActionData(1150061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aa
 * JD-Core Version:    0.7.0.1
 */