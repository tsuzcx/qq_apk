package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ch;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cy;
import com.tencent.token.do;
import com.tencent.token.global.j;
import com.tencent.token.utils.w;
import com.tmsdk.TMSDKContext;

class mq
  implements View.OnClickListener
{
  mq(IndexActivity paramIndexActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        paramView = new Intent(this.a, WtLoginAccountInput.class);
        paramView.putExtra("page_id", 4);
        this.a.startActivity(paramView);
        return;
      } while ((this.a.curruser == null) || (this.a.curruser.mIsBinded));
      IndexActivity.access$1700(this.a);
      return;
      paramView = do.a().b(1);
      IndexActivity.access$1800(this.a, paramView);
      return;
      paramView = do.a().b(2);
      if (paramView == null) {
        TMSDKContext.saveActionData(1150083);
      }
      IndexActivity.access$1800(this.a, paramView);
      return;
      IndexActivity.access$1800(this.a, this.a.curruser);
      return;
      paramView = new Intent(this.a, SettingSubmitCommentActivity.class);
      this.a.startActivity(paramView);
      return;
      paramView = new Intent(this.a, AssistantRecommendFriendQrcode.class);
      this.a.startActivity(paramView);
      return;
      paramView = new Intent(this.a, AboutActivity.class);
      this.a.startActivity(paramView);
      return;
      paramView = new Intent(this.a, CorrectTokenActivity.class);
      this.a.startActivity(paramView);
      return;
      ch.a().a(System.currentTimeMillis(), 6);
      j.a();
      if ((cy.a().c()) && (cy.a().e() == 1)) {}
      for (paramView = new Intent(this.a, StartPwdDigitSelActivity.class);; paramView = new Intent(this.a, StartPwdGestureIndexActivity.class))
      {
        this.a.startActivity(paramView);
        cy.a().b("startpwd_tip_newflag");
        TMSDKContext.saveActionData(1150084);
        return;
      }
      TMSDKContext.saveActionData(1150085);
    } while (this.a.curruser == null);
    String str = this.a.getString(2131230970);
    if (this.a.curruser.mIsBinded) {
      paramView = this.a.curruser.mUinMask;
    }
    for (;;)
    {
      paramView = String.format(str, new Object[] { paramView });
      this.a.showUserDialog(paramView, this.a.getString(2131230969), 2131230899, 2131230886, new mr(this), null);
      return;
      if ((this.a.curruser.mUinMask != null) && (this.a.curruser.mUinMask.length() > 0)) {
        paramView = this.a.curruser.mUinMask;
      } else {
        paramView = w.e(this.a.curruser.mRealUin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mq
 * JD-Core Version:    0.7.0.1
 */