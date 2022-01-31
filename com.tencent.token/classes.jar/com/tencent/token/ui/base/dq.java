package com.tencent.token.ui.base;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.NetActiveVryMobileNoSmsActivity;
import com.tencent.token.ui.NetActiveVryOtherListActivity;

final class dq
  implements View.OnClickListener
{
  dq(dk paramdk, UpgradeDeterminResult paramUpgradeDeterminResult, QQUser paramQQUser) {}
  
  public final void onClick(View paramView)
  {
    int j = 1;
    int i;
    if (this.a.mMobileAppear == 1)
    {
      i = 1;
      if (i == 0) {
        break label84;
      }
      paramView = new Intent(dk.a(this.c), NetActiveVryMobileNoSmsActivity.class);
      paramView.putExtra("intent.qquser", this.b);
      paramView.putExtra("page_id", 7);
      paramView.putExtra("intent.upgradedetermin", this.a);
      dk.a(this.c).startActivity(paramView);
    }
    label200:
    label205:
    label208:
    for (;;)
    {
      return;
      i = 0;
      break;
      label84:
      if (this.a.mQqtokenAppear == 1)
      {
        i = 1;
        if (i == 0)
        {
          if (this.a.mQuesAppear != 1) {
            break label200;
          }
          i = 1;
          label114:
          if (i == 0) {
            if (this.a.mHaveMobile != 1) {
              break label205;
            }
          }
        }
      }
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label208;
        }
        paramView = new Intent(dk.a(this.c), NetActiveVryOtherListActivity.class);
        paramView.putExtra("intent.qquser", this.b);
        paramView.putExtra("page_id", 7);
        paramView.putExtra("intent.upgradedetermin", this.a);
        dk.a(this.c).startActivity(paramView);
        return;
        i = 0;
        break;
        i = 0;
        break label114;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.dq
 * JD-Core Version:    0.7.0.1
 */