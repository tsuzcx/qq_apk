package com.tencent.token.ui.qqpim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.token.dz;
import com.tencent.token.upload.o;

class n
  extends BroadcastReceiver
{
  n(QQPimNewActivity paramQQPimNewActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext != null)
    {
      if (!paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
        break label128;
      }
      paramContext = o.o(this.a);
      if ((!o.a()) || (!"WIFI".equals(paramContext))) {
        break label68;
      }
      if (!QQPimNewActivity.access$100(this.a)) {
        QQPimNewActivity.access$200(this.a);
      }
    }
    label68:
    while (!paramContext.equals("noConnectivity"))
    {
      QQPimNewActivity.access$102(this.a, false);
      do
      {
        return;
      } while (!dz.f().g());
      dz.f().c();
      QQPimNewActivity.access$300(this.a).setVisibility(0);
      QQPimNewActivity.access$400(this.a).setVisibility(4);
      QQPimNewActivity.access$300(this.a).setText(this.a.getResources().getText(2131231311));
      return;
    }
    label128:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.n
 * JD-Core Version:    0.7.0.1
 */