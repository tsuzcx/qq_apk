package com.tencent.token.ui.qqpim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.token.dz;
import com.tencent.token.upload.o;

class f
  extends BroadcastReceiver
{
  f(QQPimActivity paramQQPimActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext != null)
    {
      if (!paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
        break label100;
      }
      if (!o.a()) {
        break label40;
      }
      if (!dz.f().g()) {
        dz.f().a();
      }
    }
    label40:
    label100:
    while (!paramContext.equals("noConnectivity"))
    {
      do
      {
        return;
      } while (!dz.f().g());
      dz.f().c();
      QQPimActivity.access$000(this.a).setVisibility(0);
      QQPimActivity.access$100(this.a).setVisibility(4);
      QQPimActivity.access$000(this.a).setText(this.a.getResources().getText(2131231311));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.f
 * JD-Core Version:    0.7.0.1
 */