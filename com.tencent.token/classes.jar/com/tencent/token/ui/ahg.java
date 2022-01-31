package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;

final class ahg
  implements View.OnClickListener
{
  ahg(WtLoginAccountInput paramWtLoginAccountInput, UpgradeDeterminResult paramUpgradeDeterminResult, QQUser paramQQUser) {}
  
  public final void onClick(View paramView)
  {
    int j = 1;
    int i;
    if (this.a.mMobileAppear == 1)
    {
      i = 1;
      if (i == 0) {
        break label83;
      }
      paramView = new Intent(this.c, NetActiveVryMobileNoSmsActivity.class);
      paramView.putExtra("intent.qquser", this.b);
      paramView.putExtra("page_id", WtLoginAccountInput.access$1100(this.c));
      paramView.putExtra("intent.upgradedetermin", this.a);
      this.c.startActivity(paramView);
    }
    label198:
    label203:
    label206:
    for (;;)
    {
      return;
      i = 0;
      break;
      label83:
      if (this.a.mQqtokenAppear == 1)
      {
        i = 1;
        if (i == 0)
        {
          if (this.a.mQuesAppear != 1) {
            break label198;
          }
          i = 1;
          label113:
          if (i == 0) {
            if (this.a.mHaveMobile != 1) {
              break label203;
            }
          }
        }
      }
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label206;
        }
        paramView = new Intent(this.c, NetActiveVryOtherListActivity.class);
        paramView.putExtra("intent.qquser", this.b);
        paramView.putExtra("page_id", WtLoginAccountInput.access$1100(this.c));
        paramView.putExtra("intent.upgradedetermin", this.a);
        this.c.startActivity(paramView);
        return;
        i = 0;
        break;
        i = 0;
        break label113;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ahg
 * JD-Core Version:    0.7.0.1
 */