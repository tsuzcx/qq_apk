package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.global.h;
import com.tmsdk.TMSDKContext;

class pv
  implements View.OnClickListener
{
  int a;
  SafeMsgItem b;
  
  public pv(ps paramps, SafeMsgItem paramSafeMsgItem, int paramInt)
  {
    this.a = paramInt;
    this.b = paramSafeMsgItem;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ps.a(this.c), OpMsgDisplayActivity.class);
    paramView.putExtra("position", this.a);
    paramView.putExtra("type", 1);
    paramView.putExtra("ipcmsg", this.b.q());
    h.c("ipsmsg = " + this.b.q());
    ps.a(this.c).startActivity(paramView);
    TMSDKContext.SaveStringData(1150064, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pv
 * JD-Core Version:    0.7.0.1
 */