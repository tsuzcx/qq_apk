package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;

final class cg
  implements View.OnClickListener
{
  cg(CommonVerifyActivity paramCommonVerifyActivity, UpgradeDeterminResult paramUpgradeDeterminResult, QQUser paramQQUser) {}
  
  public final void onClick(View paramView)
  {
    int j = 1;
    int i;
    if (this.a.mMobileAppear == 1)
    {
      i = 1;
      if (i == 0) {
        break label78;
      }
      paramView = new Intent(this.c, NetActiveVryMobileNoSmsActivity.class);
      paramView.putExtra("intent.qquser", this.b);
      paramView.putExtra("page_id", 7);
      paramView.putExtra("intent.upgradedetermin", this.a);
      this.c.startActivity(paramView);
    }
    label188:
    label193:
    label196:
    for (;;)
    {
      return;
      i = 0;
      break;
      label78:
      if (this.a.mQqtokenAppear == 1)
      {
        i = 1;
        if (i == 0)
        {
          if (this.a.mQuesAppear != 1) {
            break label188;
          }
          i = 1;
          label108:
          if (i == 0) {
            if (this.a.mHaveMobile != 1) {
              break label193;
            }
          }
        }
      }
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label196;
        }
        paramView = new Intent(this.c, NetActiveVryOtherListActivity.class);
        paramView.putExtra("intent.qquser", this.b);
        paramView.putExtra("page_id", 7);
        paramView.putExtra("intent.upgradedetermin", this.a);
        this.c.startActivity(paramView);
        return;
        i = 0;
        break;
        i = 0;
        break label108;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cg
 * JD-Core Version:    0.7.0.1
 */