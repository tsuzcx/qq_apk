package com.tencent.token.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.ImageView;
import android.widget.TabHost;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.SlidingMenuView;
import com.tencent.token.utils.x;

class mo
  extends BroadcastReceiver
{
  mo(IndexActivity paramIndexActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    paramContext = paramIntent.getAction();
    if (paramContext.equals("com.tencent.token.push_ipc_msg")) {
      if (IndexActivity.access$1400(this.a).getCurrentTab() != 0)
      {
        AccountPageActivity.mNeedShowIpcMsg = true;
        AccountPageActivity.mNeedRefreshEval = true;
        IndexActivity.isShowAccountTip = true;
        if (IndexActivity.access$1500(this.a) != null) {
          IndexActivity.access$1500(this.a).setVisibility(0);
        }
      }
    }
    label138:
    do
    {
      do
      {
        return;
        if (!paramContext.equals("com.tencent.token.push_opr_msg")) {
          break label138;
        }
        if (IndexActivity.access$1400(this.a).getCurrentTab() == 0) {
          break;
        }
        AccountPageActivity.mNeedRefreshEval = true;
        IndexActivity.isShowAccountTip = true;
      } while (IndexActivity.access$1500(this.a) == null);
      IndexActivity.access$1500(this.a).setVisibility(0);
      return;
      paramContext = new Intent("com.tencent.token.account_opr_msg");
      LocalBroadcastManager.getInstance(this.a).sendBroadcast(paramContext);
      return;
      if (paramContext.equals("com.tencent.token.open_menu"))
      {
        paramContext = this.a.slidingMenuView;
        if (this.a.slidingMenuView.getCurrentScreen() == 0) {}
        for (;;)
        {
          paramContext.a(i);
          return;
          i = 0;
        }
      }
      if (paramContext.equals("com.tencent.token.refresh_menu"))
      {
        this.a.remsumeMenu();
        return;
      }
    } while ((!paramContext.equals("com.tencent.token.refresh_statusbar")) || (IndexActivity.access$1400(this.a).getCurrentTab() != 0));
    IndexActivity.access$1602(this.a, paramIntent.getIntExtra("color", 2131492909));
    x.a(this.a, IndexActivity.access$1600(this.a));
    h.c("receive action amend color = " + IndexActivity.access$1600(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mo
 * JD-Core Version:    0.7.0.1
 */