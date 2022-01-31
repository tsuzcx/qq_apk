package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.UpgradeDeterminResult;

final class sh
  implements View.OnClickListener
{
  sh(NoCheckWithAuthActivity paramNoCheckWithAuthActivity) {}
  
  public final void onClick(View paramView)
  {
    int j = 1;
    int i;
    if (NoCheckWithAuthActivity.access$200(this.a).mMobileAppear == 1)
    {
      i = 1;
      if (i == 0) {
        break label87;
      }
      paramView = new Intent(this.a, NetActiveVryMobileNoSmsActivity.class);
      paramView.putExtra("intent.qquser", NoCheckWithAuthActivity.access$100(this.a));
      paramView.putExtra("page_id", 7);
      paramView.putExtra("intent.upgradedetermin", NoCheckWithAuthActivity.access$200(this.a));
      this.a.startActivity(paramView);
    }
    label87:
    label217:
    label220:
    for (;;)
    {
      return;
      i = 0;
      break;
      if (NoCheckWithAuthActivity.access$200(this.a).mQqtokenAppear == 1)
      {
        i = 1;
        if (i == 0)
        {
          if (NoCheckWithAuthActivity.access$200(this.a).mQuesAppear != 1) {
            break label212;
          }
          i = 1;
          label123:
          if (i == 0) {
            if (NoCheckWithAuthActivity.access$200(this.a).mHaveMobile != 1) {
              break label217;
            }
          }
        }
      }
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label220;
        }
        paramView = new Intent(this.a, NetActiveVryOtherListActivity.class);
        paramView.putExtra("intent.qquser", NoCheckWithAuthActivity.access$100(this.a));
        paramView.putExtra("page_id", 7);
        paramView.putExtra("intent.upgradedetermin", NoCheckWithAuthActivity.access$200(this.a));
        this.a.startActivity(paramView);
        return;
        i = 0;
        break;
        i = 0;
        break label123;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sh
 * JD-Core Version:    0.7.0.1
 */