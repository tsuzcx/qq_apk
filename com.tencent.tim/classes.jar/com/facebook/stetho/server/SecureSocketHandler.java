package com.facebook.stetho.server;

import android.content.Context;
import android.net.Credentials;
import android.net.LocalSocket;
import com.facebook.stetho.common.LogUtil;
import java.io.IOException;

public abstract class SecureSocketHandler
  implements SocketHandler
{
  private final Context mContext;
  
  public SecureSocketHandler(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private static void enforcePermission(Context paramContext, LocalSocket paramLocalSocket)
    throws IOException, PeerAuthorizationException
  {
    paramLocalSocket = paramLocalSocket.getPeerCredentials();
    int i = paramLocalSocket.getUid();
    int j = paramLocalSocket.getPid();
    if (LogUtil.isLoggable(2)) {
      LogUtil.v("Got request from uid=%d, pid=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
    if (paramContext.checkPermission("android.permission.DUMP", j, i) != 0) {
      throw new PeerAuthorizationException("Peer pid=" + j + ", uid=" + i + " does not have " + "android.permission.DUMP");
    }
  }
  
  public final void onAccepted(LocalSocket paramLocalSocket)
    throws IOException
  {
    try
    {
      enforcePermission(this.mContext, paramLocalSocket);
      onSecured(paramLocalSocket);
      return;
    }
    catch (PeerAuthorizationException paramLocalSocket)
    {
      LogUtil.e("Unauthorized request: " + paramLocalSocket.getMessage());
    }
  }
  
  protected abstract void onSecured(LocalSocket paramLocalSocket)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.SecureSocketHandler
 * JD-Core Version:    0.7.0.1
 */