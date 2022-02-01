package com.tencent.qapmsdk.socket.util;

import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.socket.TrafficSocketImplFactory;
import com.tencent.qapmsdk.socket.ssl.TrafficOpenSslProvider;
import com.tencent.qapmsdk.socket.ssl.TrafficSSLSocketFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImplFactory;
import java.security.Security;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLContext;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class HookUtils
{
  private static final TrafficHookCompatImpl HOOK_IMPL = new TrafficHookCompatImplBase(null);
  private static final String TAG = "QAPM_Socket_HookUtils";
  private static AtomicBoolean sInit = new AtomicBoolean();
  
  public static void hook()
  {
    if (sInit.getAndSet(true))
    {
      Logger.INSTANCE.w(new String[] { "QAPM_Socket_HookUtils", "qapm socket traffic monitor has been hooked!" });
      return;
    }
    try
    {
      HOOK_IMPL.hook();
      Logger.INSTANCE.i(new String[] { "QAPM_Socket_HookUtils", "qapm socket traffic hook all success!" });
      return;
    }
    catch (Throwable localThrowable)
    {
      ReflectionHelper.processException(localThrowable);
    }
  }
  
  static abstract interface TrafficHookCompatImpl
  {
    public abstract void hook()
      throws Exception;
  }
  
  static class TrafficHookCompatImplBase
    implements HookUtils.TrafficHookCompatImpl
  {
    public void hook()
      throws Exception
    {
      hookSocketFactoryImpl();
      Logger.INSTANCE.d(new String[] { "QAPM_Socket_HookUtils", "hook SocketFactoryImpl success" });
      Security.insertProviderAt(new TrafficOpenSslProvider(), 1);
      Logger.INSTANCE.d(new String[] { "QAPM_Socket_HookUtils", "insert TrafficOpenSslProvider success" });
      try
      {
        Security.setProperty("ssl.SocketFactory.provider", TrafficSSLSocketFactory.class.getName());
        Logger.INSTANCE.d(new String[] { "QAPM_Socket_HookUtils", "set ssl.SocketFactory.provider property success" });
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          try
          {
            SSLContext.setDefault(SSLContext.getInstance("Default"));
            Logger.INSTANCE.d(new String[] { "QAPM_Socket_HookUtils", "change default SSLContext success" });
            return;
          }
          catch (Exception localException)
          {
            Logger.INSTANCE.exception("QAPM_Socket_HookUtils", "update default sslcontext failed!", localException);
          }
          localNullPointerException = localNullPointerException;
          Logger.INSTANCE.exception("QAPM_Socket_HookUtils", "set socketfacotry provider failed!", localNullPointerException);
        }
      }
    }
    
    void hookSocketFactoryImpl()
      throws Exception
    {
      try
      {
        Socket.setSocketImplFactory(new TrafficSocketImplFactory());
        return;
      }
      catch (IOException localIOException)
      {
        SocketImplFactory localSocketImplFactory;
        do
        {
          localSocketImplFactory = (SocketImplFactory)ReflectionHelper.of(Socket.class).field("factory").get(null);
        } while ((localSocketImplFactory instanceof TrafficSocketImplFactory));
        ReflectionHelper.of(Socket.class).field("factory").set(null, new TrafficSocketImplFactory(localSocketImplFactory));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.util.HookUtils
 * JD-Core Version:    0.7.0.1
 */