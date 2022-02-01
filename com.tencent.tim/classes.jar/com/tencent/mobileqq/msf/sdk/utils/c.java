package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.y;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.SocketTimeoutException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class c
  extends SocketImpl
{
  public static String k = "notfound";
  public static short l = 0;
  public static short m = 1;
  static ConcurrentHashMap n = new ConcurrentHashMap();
  static ConcurrentHashMap o = new ConcurrentHashMap();
  private static final int s = 30000;
  private static HandlerThread t = new HandlerThread("MsfSocketTimeoutChecker");
  private static Handler u;
  private static int v = 0;
  private static long w = 0L;
  private static long x = 0L;
  private static CopyOnWriteArrayList y = new CopyOnWriteArrayList();
  public String a = "";
  public String b = "";
  public int c;
  public String d;
  public String e = "";
  public String f = "";
  public MonitorHttpInfo g;
  MonitorSocketInputStream h;
  MonitorSocketOutputStream i;
  String j;
  public Context p;
  private SocketImpl q;
  private Class r;
  
  public c(Class paramClass, Context paramContext)
  {
    try
    {
      Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[0]);
      localConstructor.setAccessible(true);
      this.q = ((SocketImpl)localConstructor.newInstance(new Object[0]));
      this.p = paramContext;
      this.r = paramClass;
      e();
      b();
      BaseApplication.httpMonitorBan = paramContext.getSharedPreferences("StepUpdate", 4).getBoolean("httpMonitorBan", false);
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
  
  private void a(b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.MonitorSocket", 2, paramb.toString());
    }
    for (;;)
    {
      v += 1;
      w += paramb.f;
      y.addIfAbsent(paramb.h);
      long l1 = System.currentTimeMillis();
      if (l1 - x > 60000L)
      {
        if ((v > 1000) || (w > 100000000L)) {
          QLog.i("MSF.D.MonitorSocket", 1, "netflowSize:" + w + " ,netflowCount:" + v + " ,mType:" + y.toString());
        }
        v = 0;
        w = 0L;
        x = l1;
        y.clear();
      }
      return;
      if (paramb.f > 500000L) {
        QLog.d("MSF.D.MonitorSocket", 1, paramb.toString());
      }
    }
  }
  
  private void e()
  {
    try
    {
      Method localMethod = Socket.class.getClassLoader().loadClass("java.net.SocketImpl").getDeclaredMethod("getFileDescriptor", new Class[0]);
      localMethod.setAccessible(true);
      this.fd = ((FileDescriptor)localMethod.invoke(this.q, new Object[0]));
      this.e = (this.b + ":" + this.c + "_" + this.fd.hashCode() + " ");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      Field localField = SocketImpl.class.getDeclaredField("fd");
      localField.setAccessible(true);
      localField.set(this.q, this.fd);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private int g()
  {
    if (this.fd == null) {
      return -1;
    }
    try
    {
      Field localField = FileDescriptor.class.getDeclaredField("descriptor");
      localField.setAccessible(true);
      int i1 = ((Integer)localField.get(this.fd)).intValue();
      return i1;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, localThrowable.getMessage());
      }
    }
    return -1;
  }
  
  private boolean h()
  {
    if (this.fd == null) {
      return false;
    }
    Object localObject = "isSocket";
    if (Build.VERSION.SDK_INT >= 23) {
      localObject = "isSocket$";
    }
    try
    {
      localObject = FileDescriptor.class.getClassLoader().loadClass("java.io.FileDescriptor").getDeclaredMethod((String)localObject, new Class[0]);
      ((Method)localObject).setAccessible(true);
      boolean bool = ((Boolean)((Method)localObject).invoke(this.fd, new Object[0])).booleanValue();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, localThrowable.getMessage());
      }
    }
    return false;
  }
  
  private void i()
  {
    StringWriter localStringWriter = new StringWriter();
    new PrintWriter(localStringWriter);
    this.f = (localStringWriter.toString() + "_");
    int i2 = this.f.lastIndexOf("com.tencent");
    int i1 = i2;
    if (i2 <= 0) {
      i1 = this.f.lastIndexOf("qq");
    }
    i2 = i1;
    if (i1 <= 0) {
      i2 = this.f.lastIndexOf("qzone");
    }
    if (i2 > 0)
    {
      i1 = this.f.indexOf(")", i2);
      if ((i1 <= 0) || (i1 <= i2)) {
        break label212;
      }
    }
    label212:
    for (this.f = (this.f.substring(i2, i1 + 1) + "_"); this.fd != null; this.f = (this.f.substring(i2) + "_"))
    {
      this.e = (this.b + ":" + this.c + "_" + this.fd.hashCode() + " ");
      return;
    }
    this.e = (this.b + ":" + this.c + "_ ");
  }
  
  private void j()
  {
    for (;;)
    {
      try
      {
        if ((BaseApplication.httpMonitorBan) || (this.g == null)) {
          break label231;
        }
        if (BaseApplication.networkMonitorCallback != null)
        {
          if ((this.g.getFileType() != 1) && (this.g.getFileType() != 2)) {
            break label231;
          }
          y.b().post(new d(this));
          if (!QLog.isColorLevel()) {
            break label231;
          }
          str3 = this.g.toString();
          if (this.d == null) {
            break label232;
          }
          str1 = this.d;
          QLog.d("MSF.D.MonitorSocket", 2, new Object[] { str3, " ProcessName=", str1 });
          return;
        }
        if (!QLog.isColorLevel()) {
          break label231;
        }
        str3 = this.g.toString();
        if (this.d == null) {
          continue;
        }
        str1 = this.d;
      }
      catch (Throwable localThrowable)
      {
        String str1;
        if (!QLog.isColorLevel()) {
          break label231;
        }
        String str3 = localThrowable.toString();
        if (this.d == null) {
          continue;
        }
        str2 = this.d;
        QLog.d("MSF.D.MonitorSocket", 2, new Object[] { "report failed ", str3, " ProcessName=", str2 });
        return;
        str2 = "";
        continue;
        str2 = "";
        continue;
      }
      QLog.d("MSF.D.MonitorSocket", 2, new Object[] { "report failed ", str3, " ProcessName=", str1 });
      return;
      label231:
      return;
      label232:
      String str2 = "";
    }
  }
  
  public Handler a()
  {
    return u;
  }
  
  public Runnable a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, "addSocketTimeoutCheck keyHashCode is 0.");
      }
      return null;
    }
    b localb;
    if (l == paramInt2) {
      localb = (b)o.get(Integer.valueOf(paramInt1));
    }
    for (;;)
    {
      if (localb == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.D.MonitorSocket", 2, "addSocketTimeoutCheck dataFlowItem is null.");
        }
        return null;
        if (m == paramInt2) {
          localb = (b)n.get(Integer.valueOf(paramInt1));
        }
      }
      else
      {
        a locala = new a(paramInt1, paramInt2);
        localb.l = locala;
        u.postDelayed(locala, 30000L);
        return locala;
      }
      localb = null;
    }
  }
  
  protected void accept(SocketImpl paramSocketImpl)
    throws IOException
  {}
  
  protected int available()
    throws IOException
  {
    try
    {
      Method localMethod = a(this.r, "available", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.q, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void b()
  {
    this.d = MsfSdkUtils.getProcessName(this.p);
    try
    {
      if (u == null) {
        synchronized (t)
        {
          if (u == null)
          {
            if (!t.isAlive())
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.D.MonitorSocket", 2, "initSocketTimeoutChecker PID=" + Process.myPid() + " TID=" + t.getId());
              }
              t.start();
            }
            u = new Handler(t.getLooper());
          }
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.D.MonitorSocket", 1, "initHandler exception " + localException.toString());
    }
  }
  
  protected void bind(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    try
    {
      Method localMethod = a(this.r, "bind", new Class[] { InetAddress.class, Integer.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this.q, new Object[] { paramInetAddress, Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramInetAddress)
    {
      paramInetAddress.printStackTrace();
    }
  }
  
  public void c()
  {
    try
    {
      if ((this.d != null) && (this.d.endsWith(":MSF")) && (MsfCore.sCore.statReporter != null)) {
        MsfCore.sCore.statReporter.b(this.r.getName());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void close()
    throws IOException
  {
    try
    {
      localMethod = a(this.r, "close", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this.q, new Object[0]);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, this.e + " close MonitorSocket succ.");
      }
      localMethod = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Method localMethod;
        b localb;
        label318:
        if (QLog.isColorLevel()) {
          QLog.d("MSF.D.MonitorSocket", 2, this.e + "close MonitorSocket failed.", localException);
        }
      }
    }
    try
    {
      j();
      if (!n.isEmpty())
      {
        localb = (b)n.remove(Integer.valueOf(this.e.hashCode()));
        if ((localb != null) && (!TextUtils.isEmpty(this.f)))
        {
          if ((TextUtils.isEmpty(localb.h)) || (localb.h.equals(k))) {
            localb.h = this.f.substring(0, this.f.indexOf("_"));
          }
          BaseApplication.monitor.insertData(localb);
          if (localb.l != null)
          {
            u.removeCallbacks(localb.l);
            localb.l = null;
          }
          a(localb);
        }
      }
      if (!o.isEmpty())
      {
        localb = (b)o.remove(Integer.valueOf(this.e.hashCode()));
        if ((localb != null) && (!TextUtils.isEmpty(this.f)))
        {
          if ((TextUtils.isEmpty(localb.h)) || (localb.h.equals(k))) {
            localb.h = this.f.substring(0, this.f.indexOf("_"));
          }
          BaseApplication.monitor.insertData(localb);
          if (localb.l != null)
          {
            u.removeCallbacks(localb.l);
            localb.l = null;
          }
          a(localb);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      if (!QLog.isColorLevel()) {
        break label318;
      }
      QLog.w("MSF.D.MonitorSocket", 2, localThrowable.getMessage(), localThrowable);
      break label318;
    }
    if (localMethod != null) {
      throw new IOException(localMethod.toString());
    }
  }
  
  protected void connect(String paramString, int paramInt)
    throws IOException
  {
    this.b = paramString;
    this.c = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.MonitorSocket", 2, this.e + "connect to host 1 " + paramString + " fd=" + g() + " isSocket=" + h());
    }
    try
    {
      e();
      Method localMethod = a(this.r, "connect", new Class[] { String.class, Integer.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this.q, new Object[] { paramString, Integer.valueOf(paramInt) });
      e();
      i();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, this.e + "connect to host 1 " + paramString + " succ.");
      }
      return;
    }
    catch (Exception paramString)
    {
      if ((paramString instanceof InvocationTargetException)) {
        throw new IOException(((InvocationTargetException)paramString).getTargetException().toString());
      }
      throw new IOException(paramString.toString());
    }
  }
  
  protected void connect(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    try
    {
      this.b = paramInetAddress.getHostName();
      this.c = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, this.e + "connect to host 2 " + this.b + " fd=" + g() + " isSocket=" + h());
      }
      e();
      Method localMethod = a(this.r, "connect", new Class[] { InetAddress.class, Integer.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this.q, new Object[] { paramInetAddress, Integer.valueOf(paramInt) });
      e();
      i();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, this.e + "connect to host 2 " + this.b + " succ.");
      }
      return;
    }
    catch (Exception paramInetAddress)
    {
      if ((paramInetAddress instanceof InvocationTargetException)) {
        throw new IOException(((InvocationTargetException)paramInetAddress).getTargetException().toString());
      }
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
      Object localObject = ((InetSocketAddress)paramSocketAddress).getAddress();
      if (localObject == null) {
        l1 = l2;
      }
      for (this.b = ((InetSocketAddress)paramSocketAddress).getHostName();; this.b = ((InetAddress)localObject).getHostAddress())
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          l1 = l2;
          QLog.d("MSF.D.MonitorSocket", 1, this.e + "connect to host 3 " + this.b + " fd=" + g() + " isSocket=" + h());
        }
        l1 = l2;
        e();
        l1 = l2;
        localObject = a(this.r, "connect", new Class[] { SocketAddress.class, Integer.TYPE });
        l1 = l2;
        ((Method)localObject).setAccessible(true);
        l1 = l2;
        l2 = System.currentTimeMillis();
        l1 = l2;
        ((Method)localObject).invoke(this.q, new Object[] { paramSocketAddress, Integer.valueOf(paramInt) });
        l1 = l2;
        e();
        l1 = l2;
        i();
        l1 = l2;
        if (!QLog.isColorLevel()) {
          break;
        }
        l1 = l2;
        QLog.d("MSF.D.MonitorSocket", 1, this.e + "connect to host 3 " + this.b + " succ. impl:" + toString());
        return;
        l1 = l2;
      }
      return;
    }
    catch (Exception paramSocketAddress)
    {
      if (System.currentTimeMillis() - l1 >= paramInt) {
        throw new SocketTimeoutException("timeoutexception " + paramSocketAddress.toString());
      }
      if ((paramSocketAddress instanceof InvocationTargetException)) {
        throw new IOException(((InvocationTargetException)paramSocketAddress).getTargetException().toString());
      }
      throw new IOException(paramSocketAddress.toString());
    }
  }
  
  protected void create(boolean paramBoolean)
    throws IOException
  {
    try
    {
      Method localMethod = a(this.r, "create", new Class[] { Boolean.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this.q, new Object[] { Boolean.valueOf(paramBoolean) });
      e();
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
      Object localObject = a(this.r, "getInetAddress", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = (InetAddress)((Method)localObject).invoke(this.q, new Object[0]);
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
      f();
      Object localObject = a(this.r, "getInputStream", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = new MonitorSocketInputStream((InputStream)((Method)localObject).invoke(this.q, new Object[0]), this, this.p);
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
    return this.q.getOption(paramInt);
  }
  
  protected OutputStream getOutputStream()
    throws IOException
  {
    try
    {
      f();
      Object localObject = a(this.r, "getOutputStream", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = new MonitorSocketOutputStream((OutputStream)((Method)localObject).invoke(this.q, new Object[0]), this, this.p);
      this.i = ((MonitorSocketOutputStream)localObject);
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
      Method localMethod = a(this.r, "getPort", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.q, new Object[0])).intValue();
      return i1;
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
      Method localMethod = a(this.r, "sendUrgentData", new Class[] { Integer.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this.q, new Object[] { Integer.valueOf(paramInt) });
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
    if (this.q != null) {
      this.q.setOption(paramInt, paramObject);
    }
  }
  
  class a
    implements Runnable
  {
    private int b;
    private int c;
    
    public a(int paramInt1, int paramInt2)
    {
      this.b = paramInt1;
      this.c = paramInt2;
    }
    
    public void run()
    {
      if (this.b == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.D.MonitorSocket", 2, "taskRun keyHashCode is 0.");
        }
        return;
      }
      b localb;
      if (c.l == this.c) {
        localb = (b)c.o.remove(Integer.valueOf(this.b));
      }
      for (;;)
      {
        if (localb == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MSF.D.MonitorSocket", 2, "taskRun dataFlowItem is null.,type:" + this.c + " ,keyhashCode:" + this.b);
          return;
          if (c.m != this.c) {
            break label255;
          }
          localb = (b)c.n.remove(Integer.valueOf(this.b));
          continue;
        }
        if ((localb.k > 0L) && (localb.l != null) && (System.currentTimeMillis() - localb.k < 3000L))
        {
          c.d().postDelayed(localb.l, 10000L);
          if (c.l == this.c)
          {
            c.o.put(Integer.valueOf(this.b), localb);
            return;
          }
          if (c.m != this.c) {
            break;
          }
          c.n.put(Integer.valueOf(this.b), localb);
          return;
        }
        c.a(c.this);
        localb.l = null;
        BaseApplication.monitor.insertData(localb);
        c.a(c.this, localb);
        return;
        label255:
        localb = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.c
 * JD-Core Version:    0.7.0.1
 */