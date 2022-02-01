package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;
import java.util.HashSet;

public class MonitorSocketImplFactory
  implements SocketImplFactory
{
  private static HashSet mServerSocketSet = new HashSet();
  public static final String tag = "MSF.D.MonitorSocket";
  Context context;
  Class socketClass = null;
  SocketImpl socketImpl;
  
  public static void addServerSocket(String paramString)
  {
    mServerSocketSet.add(paramString);
  }
  
  public static boolean isNetworkTypeMobile(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean isServerSocket(String paramString)
  {
    return mServerSocketSet.contains(paramString);
  }
  
  public static void removeServerSocket(String paramString)
  {
    mServerSocketSet.remove(paramString);
  }
  
  public SocketImpl createSocketImpl()
  {
    return new c(this.socketClass, this.context);
  }
  
  public boolean getMsfSocketImpl(Context paramContext)
  {
    try
    {
      this.context = paramContext;
      paramContext = new Socket();
      Field localField = Socket.class.getDeclaredField("impl");
      localField.setAccessible(true);
      this.socketImpl = ((SocketImpl)localField.get(paramContext));
      this.socketClass = this.socketImpl.getClass();
      QLog.i("MSF.D.MonitorSocket", 1, "Socket imple class: " + this.socketClass.getName());
      return true;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, "get SocketImpl failed " + paramContext.getMessage());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketImplFactory
 * JD-Core Version:    0.7.0.1
 */