package com.tencent.qapmsdk.socket;

import android.os.SystemClock;
import android.support.annotation.RestrictTo;
import android.system.ErrnoException;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.dns.model.DnsInfo;
import com.tencent.qapmsdk.impl.report.TrafficMonitorReport;
import com.tencent.qapmsdk.socket.model.SocketInfo;
import com.tencent.qapmsdk.socket.util.ReflectionHelper;
import com.tencent.qapmsdk.socket.util.ReflectionHelper.Cache;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class TrafficSocketImpl
  extends SocketImpl
{
  private static final Object EMPTY = new Object();
  private static final Map<String, Object> FIELD_CACHE = new ConcurrentHashMap();
  private static final String TAG = "QAPM_Socket_TrafficSocketImpl";
  private SocketImpl socketImpl;
  private SocketInfo socketInfo = new SocketInfo();
  private String trafficHost;
  private TrafficInputStream trafficInputStream;
  private String trafficIp;
  private TrafficOutputStream trafficOutputStream;
  private int trafficPort;
  
  TrafficSocketImpl(SocketImpl paramSocketImpl)
  {
    this.socketImpl = paramSocketImpl;
    update();
  }
  
  private String getFd()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = ReflectionHelper.of(SocketImpl.class).field("fd").get(this);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label19:
      break label19;
    }
    return ReflectionHelper.printFd(localObject1);
  }
  
  private Object getField(String paramString)
  {
    Object localObject3 = FIELD_CACHE.get(paramString);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject1 = ReflectionHelper.of(SocketImpl.class).field(paramString);
      FIELD_CACHE.put(paramString, localObject1);
      return localObject1;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Logger.INSTANCE.w(new String[] { "QAPM_Socket_TrafficSocketImpl", "get field ", paramString, " error: ", localNoSuchFieldException.toString() });
        Object localObject2 = EMPTY;
      }
    }
  }
  
  private int getImplHashCode()
  {
    if (this.socketImpl != null) {
      return this.socketImpl.hashCode();
    }
    return 0;
  }
  
  private void update()
  {
    update("fd", this.socketImpl, this);
    update("address", this.socketImpl, this);
    update("port", this.socketImpl, this);
    update("localport", this.socketImpl, this);
    update("socket", this, this.socketImpl);
    update("serverSocket", this, this.socketImpl);
  }
  
  private void update(String paramString, Object paramObject1, Object paramObject2)
  {
    Object localObject = getField(paramString);
    if ((localObject instanceof Field)) {
      localObject = (Field)localObject;
    }
    try
    {
      ((Field)localObject).set(paramObject2, ((Field)localObject).get(paramObject1));
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      Logger.INSTANCE.w(new String[] { "QAPM_Socket_TrafficSocketImpl", "set field ", paramString, "error: ", paramObject1.toString() });
    }
  }
  
  protected void accept(SocketImpl paramSocketImpl)
    throws IOException
  {
    if (!TrafficMonitor.config().isEnableNetwork()) {
      throw new IOException("Disable network by developer!");
    }
    try
    {
      ReflectionHelper.of(this.socketImpl.getClass()).method("accept", new Class[] { SocketImpl.class }).invoke(this.socketImpl, new Object[] { paramSocketImpl });
      update();
      return;
    }
    catch (Exception paramSocketImpl)
    {
      if (((paramSocketImpl instanceof InvocationTargetException)) && ((paramSocketImpl.getCause() instanceof IOException))) {
        throw ((IOException)paramSocketImpl.getCause());
      }
      ReflectionHelper.processException(paramSocketImpl);
      throw new IOException(paramSocketImpl);
    }
  }
  
  protected int available()
    throws IOException
  {
    try
    {
      Object localObject = ReflectionHelper.of(this.socketImpl.getClass()).method("available", new Class[0]).invoke(this.socketImpl, new Object[0]);
      if (localObject != null)
      {
        int i = ((Integer)localObject).intValue();
        return i;
      }
    }
    catch (Exception localException)
    {
      if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
        throw ((IOException)localException.getCause());
      }
      ReflectionHelper.processException(localException);
      throw new IOException(localException);
    }
    return 0;
  }
  
  protected void bind(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    if (!TrafficMonitor.config().isEnableNetwork()) {
      throw new IOException("Disable network by developer!");
    }
    try
    {
      ReflectionHelper.of(this.socketImpl.getClass()).method("bind", new Class[] { InetAddress.class, Integer.TYPE }).invoke(this.socketImpl, new Object[] { paramInetAddress, Integer.valueOf(paramInt) });
      update();
      return;
    }
    catch (Exception paramInetAddress)
    {
      if (((paramInetAddress instanceof InvocationTargetException)) && ((paramInetAddress.getCause() instanceof IOException))) {
        throw ((IOException)paramInetAddress.getCause());
      }
      ReflectionHelper.processException(paramInetAddress);
      throw new IOException(paramInetAddress);
    }
  }
  
  protected void close()
    throws IOException
  {
    try
    {
      ReflectionHelper.of(this.socketImpl.getClass()).method("close", new Class[0]).invoke(this.socketImpl, new Object[0]);
      TrafficMonitorReport.getInstance().doReport();
      update();
      return;
    }
    catch (Exception localException)
    {
      if ((localException instanceof InvocationTargetException))
      {
        if ((localException.getCause() instanceof IOException)) {
          throw ((IOException)localException.getCause());
        }
        if ((localException.getCause() instanceof NullPointerException)) {
          throw new IOException(localException);
        }
      }
      ReflectionHelper.processException(localException);
      throw new IOException(localException);
    }
  }
  
  protected void connect(String paramString, int paramInt)
    throws IOException
  {
    if (!TrafficMonitor.config().isEnableNetwork()) {
      throw new IOException("Disable network by developer!");
    }
    this.trafficHost = paramString;
    this.trafficIp = "";
    this.trafficPort = paramInt;
    long l = SystemClock.elapsedRealtime();
    try
    {
      ReflectionHelper.of(this.socketImpl.getClass()).method("connect", new Class[] { String.class, Integer.TYPE }).invoke(this.socketImpl, new Object[] { paramString, Integer.valueOf(paramInt) });
      TrafficConnectReporter.onConnected(true, this.trafficHost, this.trafficPort, SystemClock.elapsedRealtime() - l, this.socketInfo);
      update();
      return;
    }
    catch (Exception paramString)
    {
      this.socketInfo.exception = paramString;
      TrafficConnectReporter.onConnected(false, this.trafficHost, this.trafficPort, SystemClock.elapsedRealtime() - l, this.socketInfo);
      if (((paramString instanceof InvocationTargetException)) && ((paramString.getCause() instanceof IOException))) {
        throw ((IOException)paramString.getCause());
      }
      ReflectionHelper.processException(paramString);
      throw new IOException(paramString);
    }
  }
  
  protected void connect(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    if (!TrafficMonitor.config().isEnableNetwork()) {
      throw new IOException("Disable network by developer!");
    }
    this.trafficHost = paramInetAddress.getHostName();
    this.trafficIp = paramInetAddress.getHostAddress();
    this.trafficPort = paramInt;
    long l = SystemClock.elapsedRealtime();
    try
    {
      ReflectionHelper.of(this.socketImpl.getClass()).method("connect", new Class[] { InetAddress.class, Integer.TYPE }).invoke(this.socketImpl, new Object[] { paramInetAddress, Integer.valueOf(paramInt) });
      TrafficConnectReporter.onConnected(true, this.trafficHost, this.trafficPort, SystemClock.elapsedRealtime() - l, this.socketInfo);
      update();
      return;
    }
    catch (Exception paramInetAddress)
    {
      this.socketInfo.exception = paramInetAddress;
      TrafficConnectReporter.onConnected(false, this.trafficHost, this.trafficPort, SystemClock.elapsedRealtime() - l, this.socketInfo);
      if (((paramInetAddress instanceof InvocationTargetException)) && ((paramInetAddress.getCause() instanceof IOException))) {
        throw ((IOException)paramInetAddress.getCause());
      }
      ReflectionHelper.processException(paramInetAddress);
      throw new IOException(paramInetAddress);
    }
  }
  
  protected void connect(SocketAddress paramSocketAddress, int paramInt)
    throws IOException
  {
    if (!TrafficMonitor.config().isEnableNetwork()) {
      throw new IOException("Disable network by developer!");
    }
    InetSocketAddress localInetSocketAddress;
    if ((paramSocketAddress instanceof InetSocketAddress))
    {
      localInetSocketAddress = (InetSocketAddress)paramSocketAddress;
      if (AndroidVersion.isKitKat()) {}
      for (this.trafficHost = localInetSocketAddress.getHostString(); this.trafficHost == null; this.trafficHost = localInetSocketAddress.getHostName()) {
        throw new IOException("Can't find host");
      }
      if (!localInetSocketAddress.isUnresolved()) {
        break label213;
      }
    }
    for (localObject = "";; localObject = localInetSocketAddress.getAddress().getHostAddress())
    {
      this.trafficIp = ((String)localObject);
      if (this.trafficHost.equals(this.trafficIp)) {
        this.trafficHost = DnsInfo.getHostFromIp(this.trafficIp);
      }
      this.trafficPort = localInetSocketAddress.getPort();
      long l = SystemClock.elapsedRealtime();
      try
      {
        ReflectionHelper.of(this.socketImpl.getClass()).method("connect", new Class[] { SocketAddress.class, Integer.TYPE }).invoke(this.socketImpl, new Object[] { paramSocketAddress, Integer.valueOf(paramInt) });
        TrafficConnectReporter.onConnected(true, this.trafficHost, this.trafficPort, SystemClock.elapsedRealtime() - l, this.socketInfo);
        update();
        return;
      }
      catch (Exception paramSocketAddress)
      {
        label213:
        this.socketInfo.exception = paramSocketAddress;
        TrafficConnectReporter.onConnected(false, this.trafficHost, this.trafficPort, SystemClock.elapsedRealtime() - l, this.socketInfo);
        if (!(paramSocketAddress instanceof InvocationTargetException)) {
          break label449;
        }
        boolean bool = AndroidVersion.isL();
        localObject = paramSocketAddress.getCause();
        if (!(localObject instanceof IOException)) {
          break;
        }
        throw ((IOException)localObject);
        if (!(localObject instanceof ClassCastException)) {
          break label305;
        }
        throw new IOException(paramSocketAddress);
        if ((!bool) || (!(localObject instanceof ErrnoException)) || (!((Throwable)localObject).getMessage().contains("EBADF"))) {
          break label341;
        }
        throw new IOException(paramSocketAddress);
        if ((!bool) || (!(localObject instanceof ErrnoException)) || (!((Throwable)localObject).getMessage().contains("EACCES"))) {
          break label377;
        }
        throw new IOException(paramSocketAddress);
        if ((!bool) || (!(localObject instanceof ErrnoException)) || (!((Throwable)localObject).getMessage().contains("ENOTSOCK"))) {
          break label413;
        }
        throw new IOException(paramSocketAddress);
        if ((!bool) || (!(localObject instanceof ErrnoException)) || (!((Throwable)localObject).getMessage().contains("ENETUNREACH"))) {
          break label449;
        }
        throw new IOException(paramSocketAddress);
        ReflectionHelper.processException(paramSocketAddress);
        throw new IOException(paramSocketAddress);
      }
    }
  }
  
  protected void create(boolean paramBoolean)
    throws IOException
  {
    try
    {
      ReflectionHelper.of(this.socketImpl.getClass()).method("create", new Class[] { Boolean.TYPE }).invoke(this.socketImpl, new Object[] { Boolean.valueOf(paramBoolean) });
      update();
      return;
    }
    catch (Exception localException)
    {
      if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
        throw ((IOException)localException.getCause());
      }
      ReflectionHelper.processException(localException);
      throw new IOException(localException);
    }
  }
  
  protected FileDescriptor getFileDescriptor()
  {
    try
    {
      Object localObject = ReflectionHelper.of(this.socketImpl.getClass()).method("getFileDescriptor", new Class[0]).invoke(this.socketImpl, new Object[0]);
      if (localObject != null)
      {
        localObject = (FileDescriptor)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
    }
    return super.getFileDescriptor();
  }
  
  protected InetAddress getInetAddress()
  {
    try
    {
      Object localObject = ReflectionHelper.of(this.socketImpl.getClass()).method("getInetAddress", new Class[0]).invoke(this.socketImpl, new Object[0]);
      if (localObject != null)
      {
        localObject = (InetAddress)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
    }
    return super.getInetAddress();
  }
  
  protected InputStream getInputStream()
    throws IOException
  {
    if (!TrafficMonitor.config().isEnableNetwork()) {
      throw new IOException("Disable network by developer!");
    }
    if (this.trafficInputStream == null) {}
    try
    {
      this.trafficInputStream = new TrafficInputStream((InputStream)ReflectionHelper.of(this.socketImpl.getClass()).method("getInputStream", new Class[0]).invoke(this.socketImpl, new Object[0]), this.socketInfo);
      this.socketInfo.isEnd = false;
      return this.trafficInputStream;
    }
    catch (Exception localException)
    {
      if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
        throw ((IOException)localException.getCause());
      }
      ReflectionHelper.processException(localException);
      throw new IOException(localException);
    }
  }
  
  protected int getLocalPort()
  {
    try
    {
      Object localObject = ReflectionHelper.of(this.socketImpl.getClass()).method("getLocalPort", new Class[0]).invoke(this.socketImpl, new Object[0]);
      if (localObject != null)
      {
        int i = ((Integer)localObject).intValue();
        return i;
      }
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
    }
    return super.getLocalPort();
  }
  
  public SocketImpl getOldImpl()
  {
    return this.socketImpl;
  }
  
  public Object getOption(int paramInt)
    throws SocketException
  {
    return this.socketImpl.getOption(paramInt);
  }
  
  protected OutputStream getOutputStream()
    throws IOException
  {
    if (!TrafficMonitor.config().isEnableNetwork()) {
      throw new IOException("Disable network by developer!");
    }
    if (this.trafficOutputStream == null) {}
    try
    {
      this.trafficOutputStream = new TrafficOutputStream((OutputStream)ReflectionHelper.of(this.socketImpl.getClass()).method("getOutputStream", new Class[0]).invoke(this.socketImpl, new Object[0]), this.socketInfo);
      this.trafficOutputStream.initData(false, this.trafficHost, this.trafficIp, this.trafficPort, getFd(), getImplHashCode());
      return this.trafficOutputStream;
    }
    catch (Exception localException)
    {
      if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
        throw ((IOException)localException.getCause());
      }
      ReflectionHelper.processException(localException);
      throw new IOException(localException);
    }
  }
  
  protected int getPort()
  {
    try
    {
      Object localObject = ReflectionHelper.of(this.socketImpl.getClass()).method("getPort", new Class[0]).invoke(this.socketImpl, new Object[0]);
      if (localObject != null)
      {
        int i = ((Integer)localObject).intValue();
        return i;
      }
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
    }
    return super.getPort();
  }
  
  protected void listen(int paramInt)
    throws IOException
  {
    if (!TrafficMonitor.config().isEnableNetwork()) {
      throw new IOException("Disable network by developer!");
    }
    try
    {
      ReflectionHelper.of(this.socketImpl.getClass()).method("listen", new Class[] { Integer.TYPE }).invoke(this.socketImpl, new Object[] { Integer.valueOf(this.port) });
      update();
      return;
    }
    catch (Exception localException)
    {
      if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
        throw ((IOException)localException.getCause());
      }
      ReflectionHelper.processException(localException);
      throw new IOException(localException);
    }
  }
  
  protected void sendUrgentData(int paramInt)
    throws IOException
  {
    try
    {
      ReflectionHelper.of(this.socketImpl.getClass()).method("sendUrgentData", new Class[] { Integer.TYPE }).invoke(this.socketImpl, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
        throw ((IOException)localException.getCause());
      }
      ReflectionHelper.processException(localException);
      throw new IOException(localException);
    }
  }
  
  public void setOption(int paramInt, Object paramObject)
    throws SocketException
  {
    this.socketImpl.setOption(paramInt, paramObject);
  }
  
  protected void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      ReflectionHelper.of(this.socketImpl.getClass()).method("setPerformancePreferences", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }).invoke(this.socketImpl, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      super.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ReflectionHelper.processException(localException);
      }
    }
  }
  
  protected void shutdownInput()
    throws IOException
  {
    try
    {
      ReflectionHelper.of(this.socketImpl.getClass()).method("shutdownInput", new Class[0]).invoke(this.socketImpl, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
        throw ((IOException)localException.getCause());
      }
      ReflectionHelper.processException(localException);
      throw new IOException(localException);
    }
  }
  
  protected void shutdownOutput()
    throws IOException
  {
    try
    {
      ReflectionHelper.of(this.socketImpl.getClass()).method("shutdownOutput", new Class[0]).invoke(this.socketImpl, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
        throw ((IOException)localException.getCause());
      }
      ReflectionHelper.processException(localException);
      throw new IOException(localException);
    }
  }
  
  protected boolean supportsUrgentData()
  {
    try
    {
      Object localObject = ReflectionHelper.of(this.socketImpl.getClass()).method("supportsUrgentData", new Class[0]).invoke(this.socketImpl, new Object[0]);
      if (localObject != null)
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        return bool;
      }
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
    }
    return super.supportsUrgentData();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TrafficSocketImpl[");
    try
    {
      localStringBuilder.append(ReflectionHelper.of(this.socketImpl.getClass()).method("toString", new Class[0]).invoke(this.socketImpl, new Object[0]));
      return "]";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localStringBuilder.append(super.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.TrafficSocketImpl
 * JD-Core Version:    0.7.0.1
 */