package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;

public class c
  implements SocketImplFactory
{
  public static final String a = "MSF.D.MonitorSocket";
  SocketImpl b;
  Class c = null;
  Context d;
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return false;
    }
    return true;
  }
  
  public boolean a(Context paramContext)
  {
    try
    {
      this.d = paramContext;
      paramContext = new Socket();
      Field localField = Socket.class.getDeclaredField("impl");
      localField.setAccessible(true);
      this.b = ((SocketImpl)localField.get(paramContext));
      this.c = this.b.getClass();
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
  
  public SocketImpl createSocketImpl()
  {
    return new b(this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.c
 * JD-Core Version:    0.7.0.1
 */