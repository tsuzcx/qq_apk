package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.global.e;

final class qi
  implements View.OnClickListener
{
  int a;
  SafeMsgItem b;
  
  public qi(qf paramqf, SafeMsgItem paramSafeMsgItem, int paramInt)
  {
    this.a = paramInt;
    this.b = paramSafeMsgItem;
  }
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    paramView = new Intent(qf.a(this.c), OpMsgDisplayActivity.class);
    paramView.putExtra("position", this.a);
    paramView.putExtra("type", 1);
    StringBuilder localStringBuilder;
    if ((this.b.mFlag & 0x4) == 4)
    {
      bool1 = true;
      paramView.putExtra("ipcmsg", bool1);
      localStringBuilder = new StringBuilder().append("ipsmsg = ");
      if ((this.b.mFlag & 0x4) != 4) {
        break label119;
      }
    }
    label119:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      e.c(bool1);
      qf.a(this.c).startActivity(paramView);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qi
 * JD-Core Version:    0.7.0.1
 */