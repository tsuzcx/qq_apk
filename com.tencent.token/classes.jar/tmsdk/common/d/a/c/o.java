package tmsdk.common.d.a.c;

import android.content.Context;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class o
{
  protected e a;
  private byte c = 0;
  private boolean d = true;
  private Context e;
  private boolean f = true;
  private Thread g;
  private Socket h;
  private DataOutputStream i;
  private DataInputStream j;
  private i k;
  private q l;
  
  public o()
  {
    this((byte)0, false);
  }
  
  public o(byte paramByte, boolean paramBoolean)
  {
    this.c = paramByte;
    this.d = paramBoolean;
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = this.l;
    if (localObject != null) {
      try
      {
        ((q)localObject).a(paramInt, paramArrayOfByte);
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("recv() handleData() Throwable ");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        ((StringBuilder)localObject).toString();
        paramArrayOfByte = this.l;
      }
    }
  }
  
  private boolean a(Context paramContext, e parame, boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start() isRestart ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.toString();
      if (a())
      {
        paramContext = new StringBuilder();
        paramContext.append("start() isStarted() ");
        paramContext.append(a());
        paramContext.toString();
        return true;
      }
      if (parame == null) {
        return false;
      }
      this.e = paramContext;
      boolean bool = j();
      if (!bool) {
        return false;
      }
      this.a = parame;
      if (this.l != null) {
        paramContext = this.l;
      }
      bool = b(this.a);
      if (!bool) {
        return false;
      }
      this.f = false;
      if (this.c == 0) {
        f();
      }
      if (this.l != null) {
        if (paramBoolean) {
          paramContext = this.l;
        } else {
          paramContext = this.l;
        }
      }
      return true;
    }
    finally {}
  }
  
  private boolean a(i parami)
  {
    if (!i()) {
      h();
    }
    this.k = parami;
    this.h = a(InetAddress.getByName(parami.b()), parami.a());
    parami = this.h;
    if (parami == null) {
      return false;
    }
    switch (this.c)
    {
    default: 
      break;
    case 1: 
      parami.setSoTimeout(60000);
      break;
    case 0: 
      this.i = new DataOutputStream(parami.getOutputStream());
      this.j = new DataInputStream(this.h.getInputStream());
    }
    return c();
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("stop() bySvr ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(" isRestart ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).toString();
      boolean bool = h();
      if (!bool) {
        return false;
      }
      this.f = true;
      if (this.l != null) {
        if (paramBoolean1) {
          localObject1 = this.l;
        } else if (paramBoolean2) {
          localObject1 = this.l;
        } else {
          localObject1 = this.l;
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("stop() bySvr ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(" isRestart ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append(" stop() done");
      ((StringBuilder)localObject1).toString();
      return true;
    }
    finally {}
  }
  
  public static byte[] a(InputStream paramInputStream, int paramInt1, int paramInt2, h paramh)
  {
    paramh = new byte[paramInt2];
    int n = 0;
    int m = paramInt1;
    paramInt1 = paramInt2;
    while ((n < paramInt2) && (paramInt1 > 0))
    {
      int i1 = paramInputStream.read(paramh, m, paramInt1);
      if (i1 < 0) {
        break;
      }
      n += i1;
      m += i1;
      paramInt1 -= i1;
    }
    if (n != paramInt2) {
      return null;
    }
    return paramh;
  }
  
  private int b(byte[] paramArrayOfByte)
  {
    if ((!b) && (this.c != 0)) {
      throw new AssertionError();
    }
    if ((!b) && (this.i == null)) {
      throw new AssertionError("mSocketWriter is null");
    }
    try
    {
      synchronized (this.h)
      {
        if (!c()) {
          return -180000;
        }
        Object localObject2 = new ByteArrayOutputStream();
        DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject2);
        localDataOutputStream.writeInt(paramArrayOfByte.length);
        localDataOutputStream.write(paramArrayOfByte);
        paramArrayOfByte = ((ByteArrayOutputStream)localObject2).toByteArray();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendDataInAsync() realSendData.lenght ");
        ((StringBuilder)localObject2).append(paramArrayOfByte.length);
        ((StringBuilder)localObject2).toString();
        this.i.write(paramArrayOfByte);
        return 0;
      }
      return -120000;
    }
    catch (Throwable paramArrayOfByte)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("sendDataInAsync() has a Throwable when sendDataInAsync() t ");
      ((StringBuilder)???).append(paramArrayOfByte.toString());
      ((StringBuilder)???).toString();
      return -150000;
    }
    catch (SocketException paramArrayOfByte)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("sendDataInAsync() has a Throwable when sendDataInAsync() e ");
      ((StringBuilder)???).append(paramArrayOfByte.toString());
      ((StringBuilder)???).toString();
    }
  }
  
  private boolean b(e parame)
  {
    int m = 0;
    boolean bool = false;
    while (m < 3)
    {
      i locali = parame.a();
      if (locali == null) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkSocketWithRetry() before checkSocket(ipPoint) ipPoint ");
      localStringBuilder.append(locali.toString());
      localStringBuilder.append(" localIp ");
      localStringBuilder.append(d());
      localStringBuilder.append(" localPort ");
      localStringBuilder.append(e());
      localStringBuilder.toString();
      bool = b(locali);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkSocketWithRetry() after checkSocket(ipPoint) ipPoint ");
      localStringBuilder.append(locali.toString());
      localStringBuilder.append(" localIp ");
      localStringBuilder.append(d());
      localStringBuilder.append(" localPort ");
      localStringBuilder.append(e());
      localStringBuilder.append(" ret ");
      localStringBuilder.append(bool);
      localStringBuilder.toString();
      if (bool) {
        return bool;
      }
      m += 1;
    }
    return bool;
  }
  
  private boolean b(i parami)
  {
    if (parami == null) {
      return false;
    }
    if (c()) {
      return true;
    }
    try
    {
      boolean bool = a(parami);
      return bool;
    }
    catch (Throwable parami)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkSocket() Throwable ");
      localStringBuilder.append(parami.toString());
      localStringBuilder.toString();
      parami = this.l;
      return false;
    }
    catch (SocketTimeoutException parami)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkSocket() SocketTimeoutException ");
      localStringBuilder.append(parami.toString());
      localStringBuilder.toString();
      parami = this.l;
      return false;
    }
    catch (UnknownHostException parami)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkSocket() UnknownHostException ");
      localStringBuilder.append(parami.toString());
      localStringBuilder.toString();
      parami = this.l;
    }
    return false;
  }
  
  private int c(byte[] paramArrayOfByte)
  {
    if ((!b) && (1 != this.c)) {
      throw new AssertionError();
    }
    try
    {
      this.i.writeInt(paramArrayOfByte.length);
      this.i.write(paramArrayOfByte);
      return 0;
    }
    catch (Throwable paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendDataInSync() has a Throwable when sendDataInsync() ");
      localStringBuilder.append(paramArrayOfByte.toString());
      localStringBuilder.toString();
    }
    return -150000;
  }
  
  private void f()
  {
    this.g = new p(this, "RcvThread");
    this.g.setPriority(10);
    this.g.start();
  }
  
  private void g()
  {
    if (!this.f) {}
    int n;
    label258:
    label263:
    do
    {
      for (;;)
      {
        try
        {
          if (!this.d) {
            break label258;
          }
          m = this.j.readInt();
          n = this.j.readInt();
          if ((b) || (n >= 0)) {
            break label263;
          }
          throw new AssertionError("recv() size < 4");
          if ((!b) && (this.j == null)) {
            throw new AssertionError("null != mSocketReader");
          }
          a(m, a(this.j, 0, n, null));
        }
        catch (Throwable localThrowable)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("recv() Throwable ");
          localStringBuilder.append(localThrowable.toString());
          localStringBuilder.toString();
          a(true, false);
          q localq1 = this.l;
        }
        catch (EOFException localEOFException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("recv() EOFException ");
          localStringBuilder.append(localEOFException.toString());
          localStringBuilder.toString();
          a(true, false);
          q localq2 = this.l;
        }
        catch (SocketException localSocketException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("recv() SocketException ");
          localStringBuilder.append(localSocketException.toString());
          localStringBuilder.toString();
          a(true, false);
          q localq3 = this.l;
        }
        break;
        b();
        return;
        int m = 0;
      }
    } while (n < 1000000);
  }
  
  private boolean h()
  {
    if (i()) {
      return true;
    }
    StringBuilder localStringBuilder;
    if (!this.h.isInputShutdown()) {
      try
      {
        this.h.shutdownInput();
      }
      catch (Exception localException1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopSocket() mSocket.shutdownInput() ");
        localStringBuilder.append(localException1);
        localStringBuilder.toString();
      }
    }
    try
    {
      this.j.close();
      label64:
      if (!this.h.isOutputShutdown()) {
        try
        {
          this.h.shutdownOutput();
        }
        catch (Exception localException2)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("stopSocket() mSocket.shutdownOutput() ");
          localStringBuilder.append(localException2);
          localStringBuilder.toString();
        }
      }
      try
      {
        this.i.close();
      }
      catch (Exception localException3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopSocket() mSocketWriter.close() ");
        localStringBuilder.append(localException3);
        localStringBuilder.toString();
      }
      try
      {
        this.h.close();
        this.h = null;
        Thread.sleep(2000L);
        return true;
      }
      catch (IOException localIOException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopSocket() mSocket.close() ");
        localStringBuilder.append(localIOException);
        localStringBuilder.toString();
        return false;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopSocket() InterruptedException ");
        localStringBuilder.append(localInterruptedException);
        localStringBuilder.toString();
        return true;
      }
    }
    catch (Exception localException4)
    {
      break label64;
    }
  }
  
  private boolean i()
  {
    Socket localSocket = this.h;
    if (localSocket == null) {
      return true;
    }
    return (localSocket != null) && (localSocket.isClosed());
  }
  
  private boolean j()
  {
    NetworkInfo localNetworkInfo = k();
    if (localNetworkInfo == null) {
      return false;
    }
    return localNetworkInfo.isConnected();
  }
  
  private NetworkInfo k()
  {
    try
    {
      NetworkInfo localNetworkInfo = tmsdk.common.b.a().a();
      return localNetworkInfo;
    }
    catch (NullPointerException localNullPointerException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getActiveNetworkInfo NullPointerException--- \n");
      localStringBuilder.append(localNullPointerException.getMessage());
      localStringBuilder.toString();
    }
    return null;
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    if (i()) {
      return -190000;
    }
    if (!c()) {
      return -180000;
    }
    switch (this.c)
    {
    default: 
      return -200000;
    case 1: 
      return c(paramArrayOfByte);
    }
    return b(paramArrayOfByte);
  }
  
  public Socket a(InetAddress paramInetAddress, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("acquireSocketWithTimeOut, addr: ");
    ((StringBuilder)localObject).append(paramInetAddress);
    ((StringBuilder)localObject).append(", port: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).toString();
    localObject = new Socket();
    ((Socket)localObject).setSoLinger(false, 0);
    ((Socket)localObject).connect(new InetSocketAddress(paramInetAddress, paramInt), 60000);
    return localObject;
  }
  
  public void a(q paramq)
  {
    this.l = paramq;
  }
  
  public boolean a()
  {
    return this.f ^ true;
  }
  
  public boolean a(Context paramContext, e parame)
  {
    return a(paramContext, parame, false);
  }
  
  protected boolean a(e parame)
  {
    if (!a(false, true)) {
      return false;
    }
    return a(this.e, parame, true);
  }
  
  public boolean b()
  {
    return a(false, false);
  }
  
  protected boolean c()
  {
    Socket localSocket = this.h;
    boolean bool2 = false;
    if (localSocket == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!i())
    {
      bool1 = bool2;
      if (this.h.isConnected()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String d()
  {
    Socket localSocket = this.h;
    if (localSocket == null) {
      return "null";
    }
    return localSocket.getLocalAddress().toString();
  }
  
  public int e()
  {
    Socket localSocket = this.h;
    if (localSocket == null) {
      return 0;
    }
    return localSocket.getLocalPort();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.o
 * JD-Core Version:    0.7.0.1
 */