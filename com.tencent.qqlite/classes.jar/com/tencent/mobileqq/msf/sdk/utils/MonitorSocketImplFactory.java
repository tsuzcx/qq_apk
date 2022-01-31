package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;

public class MonitorSocketImplFactory
  implements SocketImplFactory
{
  public static final String tag = "MSF.D.MonitorSocket";
  Context context;
  Class socketClass = null;
  SocketImpl socketImpl;
  
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
  
  public SocketImpl createSocketImpl()
  {
    return new b(this.socketClass, this.context);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketImplFactory
 * JD-Core Version:    0.7.0.1
 */