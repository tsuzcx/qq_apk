package com.tencent.token.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.token.utils.w;

class xn
  extends BroadcastReceiver
{
  xn(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
    {
      paramContext = (TextView)this.a.findViewById(2131558987);
      if (paramContext != null) {
        break label30;
      }
    }
    label30:
    do
    {
      return;
      paramContext.setText(2131231361);
    } while (RealNameStep1InputNameIdActivity.access$800(this.a) == null);
    if (!w.a())
    {
      RealNameStep1InputNameIdActivity.access$800(this.a).setVisibility(0);
      RealNameStep1InputNameIdActivity.access$800(this.a).findViewById(2131558988).setOnClickListener(new xo(this));
      return;
    }
    RealNameStep1InputNameIdActivity.access$800(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xn
 * JD-Core Version:    0.7.0.1
 */