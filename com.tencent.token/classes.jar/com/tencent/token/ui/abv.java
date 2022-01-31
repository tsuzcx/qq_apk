package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;
import com.tmsdk.TMSDKContext;

class abv
  implements View.OnClickListener
{
  abv(UtilsActivity paramUtilsActivity) {}
  
  public void onClick(View paramView)
  {
    TMSDKContext.saveActionData(1150068);
    paramView = this.a.getResources().getString(2131231345);
    QQUser localQQUser = do.a().e();
    if (localQQUser == null) {
      paramView = this.a.getResources().getString(2131231480);
    }
    for (;;)
    {
      this.a.showUserDialogWithCancel(2130968781, paramView, new abw(this, localQQUser), new abx(this), null);
      return;
      if (!localQQUser.mIsBinded) {
        paramView = this.a.getResources().getString(2131231658);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abv
 * JD-Core Version:    0.7.0.1
 */