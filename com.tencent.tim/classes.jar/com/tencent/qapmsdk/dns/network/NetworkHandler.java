package com.tencent.qapmsdk.dns.network;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qapmsdk.common.logger.Logger;

public class NetworkHandler
{
  private static final INetworkHandler DEFAULT_NETWORK_HANDLER = new DefaultNetworkHandler();
  private static long DELAY = 2000L;
  private static final String TAG = "QAPM_DNS_NetworkHandler";
  private static INetworkHandler networkHandler;
  
  static void notifyNetworkChanged(Context paramContext)
  {
    if (networkHandler == null) {
      networkHandler = DEFAULT_NETWORK_HANDLER;
    }
    try
    {
      networkHandler.onNetworkChanged();
      return;
    }
    catch (Throwable paramContext)
    {
      Logger.INSTANCE.exception("QAPM_DNS_NetworkHandler", "onNetworkChanged handle error!!", paramContext);
    }
  }
  
  public static void setNetworkHandler(INetworkHandler paramINetworkHandler, long paramLong)
  {
    if ((paramINetworkHandler == null) || (paramLong < 0L)) {
      Logger.INSTANCE.w(new String[] { "QAPM_DNS_NetworkHandler", "Illegal Argument, handler is null or delay less than 0" });
    }
    networkHandler = paramINetworkHandler;
    DELAY = paramLong;
  }
  
  static final class DefaultNetworkHandler
    implements NetworkHandler.INetworkHandler
  {
    Handler handler;
    NetworkUtils.NetworkType lastNetworkType;
    String lastSsid;
    NetworkUtils.NetworkType lastValidNetworkType;
    final Runnable networkChangedTask = new NetworkHandler.DefaultNetworkHandler.1(this);
    
    DefaultNetworkHandler()
    {
      HandlerThread localHandlerThread = new HandlerThread("httpdns_networkchanged");
      localHandlerThread.start();
      this.handler = new Handler(localHandlerThread.getLooper());
    }
    
    public void onNetworkChanged()
    {
      this.handler.removeCallbacks(this.networkChangedTask);
      this.handler.postDelayed(this.networkChangedTask, NetworkHandler.DELAY);
    }
  }
  
  public static abstract interface INetworkHandler
  {
    public abstract void onNetworkChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.network.NetworkHandler
 * JD-Core Version:    0.7.0.1
 */