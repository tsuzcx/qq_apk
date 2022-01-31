package com.tencent.token.upload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.token.do;
import com.tencent.token.global.h;
import com.tencent.token.utils.x;

class l
  extends BroadcastReceiver
{
  l(NetInfoService paramNetInfoService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
    {
      NetInfoService.a(this.a, (ConnectivityManager)this.a.getSystemService("connectivity"));
      NetInfoService.a(this.a, NetInfoService.b(this.a).getActiveNetworkInfo());
      if ((NetInfoService.c(this.a) == null) || (!NetInfoService.c(this.a).isConnectedOrConnecting())) {
        break label317;
      }
      NetInfoService.a(this.a, NetInfoService.b(this.a, NetInfoService.c(this.a)));
    }
    for (;;)
    {
      h.a("currentStateCode:" + NetInfoService.d(this.a));
      h.a("lastStateCode:" + NetInfoService.e(this.a));
      if ((x.m()) && (NetInfoService.d(this.a) != NetInfoService.e(this.a)))
      {
        NetInfoService.b(this.a, NetInfoService.d(this.a));
        if (NetInfoService.d(this.a) == NetInfoService.NetState.NET_NO) {}
      }
      try
      {
        if (do.a().e() != null)
        {
          paramContext = new HandlerThread("deviceinfouploader", 1);
          paramContext.start();
          new Handler(paramContext.getLooper()).postDelayed(new m(this), 1000L);
        }
        if ((NetInfoService.f(this.a)) && (NetInfoService.d(this.a) != NetInfoService.NetState.NET_NO)) {}
        try
        {
          paramContext = new HandlerThread("dynamicdomainreport", 1);
          paramContext.start();
          new Handler(paramContext.getLooper()).postDelayed(new n(this), 1000L);
          return;
        }
        catch (Exception paramContext)
        {
          label317:
          paramContext.printStackTrace();
        }
        NetInfoService.a(this.a, NetInfoService.NetState.NET_NO);
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.l
 * JD-Core Version:    0.7.0.1
 */