package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.SocketTimeoutException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class b
  extends SocketImpl
{
  public static String h = "notfound";
  public String a = "";
  public int b;
  public String c = "";
  public String d = "";
  MonitorSocketInputStream e;
  MonitorSocketOutputStream f;
  String g;
  ConcurrentHashMap i = new ConcurrentHashMap();
  ConcurrentHashMap j = new ConcurrentHashMap();
  public Context k;
  private SocketImpl l;
  private Class m;
  
  public b(Class paramClass, Context paramContext)
  {
    try
    {
      Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[0]);
      localConstructor.setAccessible(true);
      this.l = ((SocketImpl)localConstructor.newInstance(new Object[0]));
      this.k = paramContext;
      this.m = paramClass;
      a();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        try
        {
          a(paramClass, "wait", new Class[0]);
          return;
        }
        catch (Exception paramClass)
        {
          paramClass.printStackTrace();
        }
        paramContext = paramContext;
        paramContext.printStackTrace();
      }
    }
  }
  
  public static Method a(Class paramClass, String paramString, Class... paramVarArgs)
  {
    localObject = null;
    new StringBuilder();
    try
    {
      Method localMethod = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      paramClass = localMethod;
    }
    catch (Exception localException)
    {
      Class localClass;
      do
      {
        localClass = paramClass.getSuperclass();
        paramClass = localObject;
      } while (localClass == null);
      return a(localClass, paramString, paramVarArgs);
    }
    return paramClass;
  }
  
  private void a()
  {
    try
    {
      Method localMethod = Socket.class.getClassLoader().loadClass("java.net.SocketImpl").getDeclaredMethod("getFileDescriptor", new Class[0]);
      localMethod.setAccessible(true);
      this.fd = ((FileDescriptor)localMethod.invoke(this.l, new Object[0]));
      this.c = (this.a + ":" + this.b + "_" + this.fd.hashCode() + " ");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void b()
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    new Throwable("MonitorSocketDump").printStackTrace(localPrintWriter);
    this.d = (localStringWriter.toString() + "_");
    int i1 = this.d.lastIndexOf("com.tencent");
    int n = i1;
    if (i1 <= 0) {
      n = this.d.lastIndexOf("qq");
    }
    i1 = n;
    if (n <= 0) {
      i1 = this.d.lastIndexOf("qzone");
    }
    if (i1 > 0)
    {
      n = this.d.indexOf(")", i1);
      if ((n <= 0) || (n <= i1)) {
        break label218;
      }
    }
    label218:
    for (this.d = (this.d.substring(i1, n + 1) + "_"); this.fd != null; this.d = (this.d.substring(i1) + "_"))
    {
      this.c = (this.a + ":" + this.b + "_" + this.fd.hashCode() + " ");
      return;
    }
    this.c = (this.a + ":" + this.b + "_ ");
  }
  
  protected void accept(SocketImpl paramSocketImpl)
    throws IOException
  {}
  
  protected int available()
    throws IOException
  {
    try
    {
      Method localMethod = a(this.m, "available", new Class[0]);
      localMethod.setAccessible(true);
      int n = ((Integer)localMethod.invoke(this.l, new Object[0])).intValue();
      return n;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  protected void bind(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    try
    {
      Method localMethod = a(this.m, "bind", new Class[] { InetAddress.class, Integer.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this.l, new Object[] { paramInetAddress, Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramInetAddress)
    {
      paramInetAddress.printStackTrace();
    }
  }
  
  protected void close()
    throws IOException
  {
    try
    {
      if (!this.i.isEmpty())
      {
        localObject = (a)this.i.get(Integer.valueOf(this.c.hashCode()));
        ((a)localObject).h = this.d.substring(0, this.d.indexOf("_"));
        MonitorSocketStat.dataFlow.add(localObject);
        this.i.clear();
      }
      if (!this.j.isEmpty())
      {
        localObject = (a)this.j.get(Integer.valueOf(this.c.hashCode()));
        ((a)localObject).h = this.d.substring(0, this.d.indexOf("_"));
        MonitorSocketStat.dataFlow.add(localObject);
        this.j.clear();
      }
      Object localObject = a(this.m, "close", new Class[0]);
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(this.l, new Object[0]);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, this.c + " close MonitorSocket succ.");
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, this.c + "close MonitorSocket failed.", localException);
      }
      throw new IOException(localException.toString());
    }
  }
  
  protected void connect(String paramString, int paramInt)
    throws IOException
  {
    this.a = paramString;
    this.b = paramInt;
    try
    {
      Method localMethod = a(this.m, "connect", new Class[] { String.class, Integer.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this.l, new Object[] { paramString, Integer.valueOf(paramInt) });
      a();
      b();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, this.c + "connect to host 1 " + paramString + " succ.");
      }
      return;
    }
    catch (Exception paramString)
    {
      throw new IOException(paramString.toString());
    }
  }
  
  protected void connect(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    try
    {
      this.a = paramInetAddress.getHostName();
      this.b = paramInt;
      Method localMethod = a(this.m, "connect", new Class[] { InetAddress.class, Integer.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this.l, new Object[] { paramInetAddress, Integer.valueOf(paramInt) });
      a();
      b();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, this.c + "connect to host 2 " + this.a + " succ.");
      }
      return;
    }
    catch (Exception paramInetAddress)
    {
      throw new IOException(paramInetAddress.toString());
    }
  }
  
  public void connect(SocketAddress paramSocketAddress, int paramInt)
    throws IOException
  {
    long l2 = 0L;
    long l1 = l2;
    try
    {
      this.a = ((InetSocketAddress)paramSocketAddress).getHostName();
      l1 = l2;
      this.b = ((InetSocketAddress)paramSocketAddress).getPort();
      l1 = l2;
      Method localMethod = a(this.m, "connect", new Class[] { SocketAddress.class, Integer.TYPE });
      l1 = l2;
      localMethod.setAccessible(true);
      l1 = l2;
      l2 = System.currentTimeMillis();
      l1 = l2;
      localMethod.invoke(this.l, new Object[] { paramSocketAddress, Integer.valueOf(paramInt) });
      l1 = l2;
      a();
      l1 = l2;
      b();
      l1 = l2;
      QLog.d("MSF.D.MonitorSocket", 1, this.c + "connect to host 3 " + this.a + " succ.");
      return;
    }
    catch (Exception paramSocketAddress)
    {
      if (System.currentTimeMillis() - l1 >= paramInt) {
        throw new SocketTimeoutException("timeoutexception " + paramSocketAddress.toString());
      }
      throw new IOException(paramSocketAddress.toString());
    }
  }
  
  protected void create(boolean paramBoolean)
    throws IOException
  {
    try
    {
      Method localMethod = a(this.m, "create", new Class[] { Boolean.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this.l, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      throw new IOException(localException.toString());
    }
  }
  
  protected InetAddress getInetAddress()
  {
    try
    {
      Object localObject = a(this.m, "getInetAddress", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = (InetAddress)((Method)localObject).invoke(this.l, new Object[0]);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  protected InputStream getInputStream()
    throws IOException
  {
    try
    {
      Object localObject = a(this.m, "getInputStream", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = new MonitorSocketInputStream((InputStream)((Method)localObject).invoke(this.l, new Object[0]), this, this.k);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new IOException(localException.toString());
    }
  }
  
  public Object getOption(int paramInt)
    throws SocketException
  {
    return this.l.getOption(paramInt);
  }
  
  protected OutputStream getOutputStream()
    throws IOException
  {
    try
    {
      Object localObject = a(this.m, "getOutputStream", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = new MonitorSocketOutputStream((OutputStream)((Method)localObject).invoke(this.l, new Object[0]), this, this.k);
      this.f = ((MonitorSocketOutputStream)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new IOException(localException.toString());
    }
  }
  
  protected int getPort()
  {
    try
    {
      Method localMethod = a(this.m, "getPort", new Class[0]);
      localMethod.setAccessible(true);
      int n = ((Integer)localMethod.invoke(this.l, new Object[0])).intValue();
      return n;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  protected void listen(int paramInt)
    throws IOException
  {}
  
  protected void sendUrgentData(int paramInt)
    throws IOException
  {
    try
    {
      Method localMethod = a(this.m, "sendUrgentData", new Class[] { Integer.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this.l, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      throw new IOException(localException.toString());
    }
  }
  
  public void setOption(int paramInt, Object paramObject)
    throws SocketException
  {
    if (this.l != null) {
      this.l.setOption(paramInt, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.b
 * JD-Core Version:    0.7.0.1
 */