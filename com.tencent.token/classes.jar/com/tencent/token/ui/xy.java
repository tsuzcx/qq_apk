package com.tencent.token.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.token.utils.s;

final class xy
  extends BroadcastReceiver
{
  xy(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
    {
      paramContext = (TextView)this.a.findViewById(2131296784);
      if (paramContext != null) {
        break label30;
      }
    }
    label30:
    do
    {
      return;
      paramContext.setText(2131362643);
    } while (RealNameStep1InputNameIdActivity.access$800(this.a) == null);
    if (!s.a())
    {
      RealNameStep1InputNameIdActivity.access$800(this.a).setVisibility(0);
      RealNameStep1InputNameIdActivity.access$800(this.a).findViewById(2131296785).setOnClickListener(new xz(this));
      return;
    }
    RealNameStep1InputNameIdActivity.access$800(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xy
 * JD-Core Version:    0.7.0.1
 */