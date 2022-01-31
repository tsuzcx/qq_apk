package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.ah;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.p;
import com.tencent.token.ui.base.SlidingMenuView;

final class mo
  implements View.OnClickListener
{
  mo(IndexActivity paramIndexActivity) {}
  
  public final void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while (this.a.curruser.mIsBinded);
      IndexActivity.access$1200(this.a);
      this.a.slidingMenuView.a(1);
      return;
      paramView = ax.a().b(1);
      IndexActivity.access$1300(this.a, paramView);
      return;
      paramView = ax.a().b(2);
      IndexActivity.access$1300(this.a, paramView);
      return;
      IndexActivity.access$1300(this.a, this.a.curruser);
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
      p.a().a(System.currentTimeMillis(), 6);
      if ((ah.a().c()) && (ah.a().e() == 1)) {}
      for (paramView = new Intent(this.a, StartPwdDigitSelActivity.class);; paramView = new Intent(this.a, StartPwdGestureIndexActivity.class))
      {
        this.a.startActivity(paramView);
        ah.a();
        ah.d("startpwd_tip_newflag");
        return;
      }
    } while (this.a.curruser == null);
    if (!this.a.curruser.mIsBinded)
    {
      this.a.showUserDialog(2131361808, this.a.getString(2131361912), 2131361800, 2131361804, new mp(this), null);
      return;
    }
    long l = this.a.curruser.mUin;
    this.a.slidingMenuView.a(1);
    af.a().g(l, IndexActivity.access$300(this.a));
    this.a.showProDialog(this.a, 2131361808, 2131361905, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mo
 * JD-Core Version:    0.7.0.1
 */