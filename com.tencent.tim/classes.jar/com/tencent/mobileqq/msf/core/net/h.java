package com.tencent.mobileqq.msf.core.net;

import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.SocketImpl;

public final class h
  extends Socket
{
  private static final String a = "MSFSocket";
  
  private int b()
  {
    j = -1;
    for (;;)
    {
      try
      {
        localObject1 = Socket.class.getDeclaredField("impl");
        ((Field)localObject1).setAccessible(true);
        localObject1 = (SocketImpl)((Field)localObject1).get(this);
        localObject2 = Socket.class.getClassLoader().loadClass("java.net.SocketImpl").getDeclaredMethod("getFileDescriptor", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        localObject1 = (FileDescriptor)((Method)localObject2).invoke(localObject1, new Object[0]);
        if (localObject1 != null) {
          continue;
        }
        i = -1;
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        Object localObject2;
        int i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSFSocket", 1, "getSocketFd fail", localThrowable);
        i = j;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSFSocket", 1, "getSocketFd = " + i);
      }
      return i;
      localObject2 = FileDescriptor.class.getDeclaredField("descriptor");
      ((Field)localObject2).setAccessible(true);
      i = ((Integer)((Field)localObject2).get(localObject1)).intValue();
    }
  }
  
  public long a()
  {
    for (;;)
    {
      try
      {
        int i = b();
        long l2;
        if (i != -1)
        {
          l1 = CodecWarpper.getPacketLossLength(i);
          l2 = l1;
        }
        long l1 = 0L;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("MSFSocket", 1, "getLossPacketLength = " + l1);
            l2 = l1;
          }
          return l2;
        }
        catch (Throwable localThrowable2)
        {
          continue;
        }
        localThrowable1 = localThrowable1;
        l1 = 0L;
        l2 = l1;
        if (QLog.isColorLevel())
        {
          QLog.d("MSFSocket", 1, "getLossPacketLength fail", localThrowable1);
          return l1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.h
 * JD-Core Version:    0.7.0.1
 */