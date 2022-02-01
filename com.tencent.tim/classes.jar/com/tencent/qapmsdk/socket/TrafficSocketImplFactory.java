package com.tencent.qapmsdk.socket;

import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.socket.util.ReflectionHelper;
import com.tencent.qapmsdk.socket.util.ReflectionHelper.Cache;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class TrafficSocketImplFactory
  implements SocketImplFactory
{
  private static final String TAG = "QAPM_Socket_TrafficSocketImplFactory";
  private static Constructor<?> socketImplConstructor;
  private SocketImplFactory oldSocketImplFactory;
  
  public TrafficSocketImplFactory()
    throws Exception
  {
    Class localClass = ReflectionHelper.of(Socket.class).field("impl").get(new Socket()).getClass();
    try
    {
      socketImplConstructor = ReflectionHelper.of(localClass).constructor(new Class[0]);
      Logger.INSTANCE.i(new String[] { "QAPM_Socket_TrafficSocketImplFactory", "TrafficSocketImplFactory init success, SocketImpl: ", localClass.toString() });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        if ((localClass == TrafficSocketImpl.class) && (socketImplConstructor == null)) {
          if (!AndroidVersion.isN()) {
            socketImplConstructor = ReflectionHelper.of("java.net.PlainSocketImpl").constructor(new Class[0]);
          } else {
            socketImplConstructor = ReflectionHelper.of("java.net.SocksSocketImpl").constructor(new Class[0]);
          }
        }
      }
    }
  }
  
  public TrafficSocketImplFactory(SocketImplFactory paramSocketImplFactory)
  {
    Logger.INSTANCE.i(new String[] { "QAPM_Socket_TrafficSocketImplFactory", "TrafficSocketImplFactory init, old SocketImplFactory: ", paramSocketImplFactory.toString() });
    this.oldSocketImplFactory = paramSocketImplFactory;
  }
  
  private static boolean stackContainServerSocket()
  {
    for (;;)
    {
      try
      {
        StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
        if ((arrayOfStackTraceElement == null) || (arrayOfStackTraceElement.length <= 0)) {
          break;
        }
        i = 0;
        if (i >= arrayOfStackTraceElement.length) {
          break;
        }
        if (arrayOfStackTraceElement[i] != null)
        {
          boolean bool = arrayOfStackTraceElement[i].toString().contains("java.net.ServerSocket");
          if (!bool) {}
        }
      }
      catch (Exception localException1)
      {
        int i;
        return false;
      }
      try
      {
        Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficSocketImplFactory", "socket stack contain ServerSocket" });
        return true;
      }
      catch (Exception localException2)
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public SocketImpl createSocketImpl()
  {
    if (this.oldSocketImplFactory != null) {
      return new TrafficSocketImpl(this.oldSocketImplFactory.createSocketImpl());
    }
    try
    {
      if (stackContainServerSocket()) {
        return (SocketImpl)socketImplConstructor.newInstance(new Object[0]);
      }
      TrafficSocketImpl localTrafficSocketImpl = new TrafficSocketImpl((SocketImpl)socketImplConstructor.newInstance(new Object[0]));
      return localTrafficSocketImpl;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.w(new String[] { "QAPM_Socket_TrafficSocketImplFactory", "create TrafficSocketImpl instance failed:", localThrowable.toString() });
      ReflectionHelper.processException(localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.TrafficSocketImplFactory
 * JD-Core Version:    0.7.0.1
 */