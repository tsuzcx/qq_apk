package tmsdk.common.d.a.c;

import android.content.Context;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.InputStream;
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
  
  static
  {
    if (!o.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
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
    if (this.l != null) {}
    try
    {
      this.l.a(paramInt, paramArrayOfByte);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      new StringBuilder().append("recv() handleData() Throwable ").append(paramArrayOfByte.toString()).toString();
      paramArrayOfByte = this.l;
    }
  }
  
  /* Error */
  private boolean a(Context paramContext, e parame, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: new 60	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   12: ldc 78
    //   14: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: iload_3
    //   18: invokevirtual 81	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   21: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: pop
    //   25: aload_0
    //   26: invokevirtual 83	tmsdk/common/d/a/c/o:a	()Z
    //   29: ifeq +35 -> 64
    //   32: new 60	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   39: ldc 85
    //   41: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: invokevirtual 83	tmsdk/common/d/a/c/o:a	()Z
    //   48: invokevirtual 81	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: pop
    //   55: iload 5
    //   57: istore 4
    //   59: aload_0
    //   60: monitorexit
    //   61: iload 4
    //   63: ireturn
    //   64: aload_2
    //   65: ifnonnull +9 -> 74
    //   68: iconst_0
    //   69: istore 4
    //   71: goto -12 -> 59
    //   74: aload_0
    //   75: aload_1
    //   76: putfield 87	tmsdk/common/d/a/c/o:e	Landroid/content/Context;
    //   79: aload_0
    //   80: invokespecial 89	tmsdk/common/d/a/c/o:j	()Z
    //   83: ifne +9 -> 92
    //   86: iconst_0
    //   87: istore 4
    //   89: goto -30 -> 59
    //   92: aload_0
    //   93: aload_2
    //   94: putfield 91	tmsdk/common/d/a/c/o:a	Ltmsdk/common/d/a/c/e;
    //   97: aload_0
    //   98: getfield 54	tmsdk/common/d/a/c/o:l	Ltmsdk/common/d/a/c/q;
    //   101: ifnull +8 -> 109
    //   104: aload_0
    //   105: getfield 54	tmsdk/common/d/a/c/o:l	Ltmsdk/common/d/a/c/q;
    //   108: astore_1
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 91	tmsdk/common/d/a/c/o:a	Ltmsdk/common/d/a/c/e;
    //   114: invokespecial 94	tmsdk/common/d/a/c/o:b	(Ltmsdk/common/d/a/c/e;)Z
    //   117: ifne +9 -> 126
    //   120: iconst_0
    //   121: istore 4
    //   123: goto -64 -> 59
    //   126: aload_0
    //   127: iconst_0
    //   128: putfield 49	tmsdk/common/d/a/c/o:f	Z
    //   131: aload_0
    //   132: getfield 45	tmsdk/common/d/a/c/o:c	B
    //   135: ifne +7 -> 142
    //   138: aload_0
    //   139: invokespecial 96	tmsdk/common/d/a/c/o:f	()V
    //   142: iload 5
    //   144: istore 4
    //   146: aload_0
    //   147: getfield 54	tmsdk/common/d/a/c/o:l	Ltmsdk/common/d/a/c/q;
    //   150: ifnull -91 -> 59
    //   153: iload_3
    //   154: ifeq +15 -> 169
    //   157: aload_0
    //   158: getfield 54	tmsdk/common/d/a/c/o:l	Ltmsdk/common/d/a/c/q;
    //   161: astore_1
    //   162: iload 5
    //   164: istore 4
    //   166: goto -107 -> 59
    //   169: aload_0
    //   170: getfield 54	tmsdk/common/d/a/c/o:l	Ltmsdk/common/d/a/c/q;
    //   173: astore_1
    //   174: iload 5
    //   176: istore 4
    //   178: goto -119 -> 59
    //   181: astore_1
    //   182: aload_0
    //   183: monitorexit
    //   184: aload_1
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	o
    //   0	186	1	paramContext	Context
    //   0	186	2	parame	e
    //   0	186	3	paramBoolean	boolean
    //   57	120	4	bool1	boolean
    //   1	174	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	55	181	finally
    //   74	86	181	finally
    //   92	109	181	finally
    //   109	120	181	finally
    //   126	142	181	finally
    //   146	153	181	finally
    //   157	162	181	finally
    //   169	174	181	finally
  }
  
  private boolean a(i parami)
  {
    if (!i()) {
      h();
    }
    this.k = parami;
    this.h = a(InetAddress.getByName(parami.b()), parami.a());
    if (this.h == null) {
      return false;
    }
    switch (this.c)
    {
    }
    for (;;)
    {
      return c();
      this.i = new DataOutputStream(this.h.getOutputStream());
      this.j = new DataInputStream(this.h.getInputStream());
      continue;
      this.h.setSoTimeout(60000);
    }
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        new StringBuilder().append("stop() bySvr ").append(paramBoolean1).append(" isRestart ").append(paramBoolean2).toString();
        boolean bool2 = h();
        if (!bool2)
        {
          paramBoolean1 = false;
          return paramBoolean1;
        }
        this.f = true;
        if (this.l != null)
        {
          if (paramBoolean1) {
            q localq1 = this.l;
          }
        }
        else
        {
          new StringBuilder().append("stop() bySvr ").append(paramBoolean1).append(" isRestart ").append(paramBoolean2).append(" stop() done").toString();
          paramBoolean1 = bool1;
          continue;
        }
        if (!paramBoolean2) {
          break label131;
        }
      }
      finally {}
      q localq2 = this.l;
      continue;
      label131:
      localq2 = this.l;
    }
  }
  
  public static byte[] a(InputStream paramInputStream, int paramInt1, int paramInt2, h paramh)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    int n = 0;
    int m = paramInt2;
    for (;;)
    {
      int i1;
      if ((n < paramInt2) && (m > 0))
      {
        i1 = paramInputStream.read(arrayOfByte, paramInt1, m);
        if (i1 >= 0) {
          break label55;
        }
        if (paramh == null) {}
      }
      paramInputStream = arrayOfByte;
      if (n != paramInt2) {
        paramInputStream = null;
      }
      return paramInputStream;
      label55:
      n += i1;
      paramInt1 += i1;
      m -= i1;
    }
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
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
        localDataOutputStream.writeInt(paramArrayOfByte.length);
        localDataOutputStream.write(paramArrayOfByte);
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        new StringBuilder().append("sendDataInAsync() realSendData.lenght ").append(paramArrayOfByte.length).toString();
        this.i.write(paramArrayOfByte);
        return 0;
      }
      return -150000;
    }
    catch (SocketException paramArrayOfByte)
    {
      new StringBuilder().append("sendDataInAsync() has a Throwable when sendDataInAsync() e ").append(paramArrayOfByte.toString()).toString();
      return -120000;
    }
    catch (Throwable paramArrayOfByte)
    {
      new StringBuilder().append("sendDataInAsync() has a Throwable when sendDataInAsync() t ").append(paramArrayOfByte.toString()).toString();
    }
  }
  
  private boolean b(e parame)
  {
    int m = 0;
    label26:
    boolean bool2;
    for (boolean bool1 = false;; bool1 = bool2)
    {
      i locali;
      if (m < 3)
      {
        locali = parame.a();
        if (locali != null) {
          break label26;
        }
        bool1 = false;
      }
      do
      {
        return bool1;
        new StringBuilder().append("checkSocketWithRetry() before checkSocket(ipPoint) ipPoint ").append(locali.toString()).append(" localIp ").append(d()).append(" localPort ").append(e()).toString();
        bool2 = b(locali);
        new StringBuilder().append("checkSocketWithRetry() after checkSocket(ipPoint) ipPoint ").append(locali.toString()).append(" localIp ").append(d()).append(" localPort ").append(e()).append(" ret ").append(bool2).toString();
        bool1 = bool2;
      } while (bool2);
      m += 1;
    }
  }
  
  private boolean b(i parami)
  {
    if (parami == null) {}
    do
    {
      for (;;)
      {
        return false;
        if (c()) {
          return true;
        }
        try
        {
          boolean bool = a(parami);
          return bool;
        }
        catch (UnknownHostException parami)
        {
          new StringBuilder().append("checkSocket() UnknownHostException ").append(parami.toString()).toString();
          if (this.l != null)
          {
            parami = this.l;
            return false;
          }
        }
        catch (SocketTimeoutException parami)
        {
          new StringBuilder().append("checkSocket() SocketTimeoutException ").append(parami.toString()).toString();
          if (this.l != null)
          {
            parami = this.l;
            return false;
          }
        }
        catch (Throwable parami)
        {
          new StringBuilder().append("checkSocket() Throwable ").append(parami.toString()).toString();
        }
      }
    } while (this.l == null);
    parami = this.l;
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
      new StringBuilder().append("sendDataInSync() has a Throwable when sendDataInsync() ").append(paramArrayOfByte.toString()).toString();
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
    for (;;)
    {
      try
      {
        if (!this.d) {
          break label248;
        }
        m = this.j.readInt();
        n = this.j.readInt();
        if ((!b) && (n < 0)) {
          throw new AssertionError("recv() size < 4");
        }
      }
      catch (SocketException localSocketException)
      {
        new StringBuilder().append("recv() SocketException ").append(localSocketException.toString()).toString();
        a(true, false);
        if (this.l == null) {
          break;
        }
        q localq1 = this.l;
        break;
        if (n >= 1000000) {
          return;
        }
        if ((!b) && (this.j == null)) {
          throw new AssertionError("null != mSocketReader");
        }
      }
      catch (EOFException localEOFException)
      {
        int n;
        new StringBuilder().append("recv() EOFException ").append(localEOFException.toString()).toString();
        a(true, false);
        if (this.l == null) {
          break;
        }
        q localq2 = this.l;
        break;
        a(m, a(this.j, 0, n, null));
      }
      catch (Throwable localThrowable)
      {
        new StringBuilder().append("recv() Throwable ").append(localThrowable.toString()).toString();
        a(true, false);
      }
      if (this.l == null) {
        break;
      }
      q localq3 = this.l;
      break;
      b();
      return;
      label248:
      int m = 0;
    }
  }
  
  /* Error */
  private boolean h()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 99	tmsdk/common/d/a/c/o:i	()Z
    //   4: ifeq +5 -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 121	tmsdk/common/d/a/c/o:h	Ljava/net/Socket;
    //   13: invokevirtual 292	java/net/Socket:isInputShutdown	()Z
    //   16: ifne +10 -> 26
    //   19: aload_0
    //   20: getfield 121	tmsdk/common/d/a/c/o:h	Ljava/net/Socket;
    //   23: invokevirtual 295	java/net/Socket:shutdownInput	()V
    //   26: aload_0
    //   27: getfield 147	tmsdk/common/d/a/c/o:j	Ljava/io/DataInputStream;
    //   30: invokevirtual 298	java/io/DataInputStream:close	()V
    //   33: aload_0
    //   34: getfield 121	tmsdk/common/d/a/c/o:h	Ljava/net/Socket;
    //   37: invokevirtual 301	java/net/Socket:isOutputShutdown	()Z
    //   40: ifne +10 -> 50
    //   43: aload_0
    //   44: getfield 121	tmsdk/common/d/a/c/o:h	Ljava/net/Socket;
    //   47: invokevirtual 304	java/net/Socket:shutdownOutput	()V
    //   50: aload_0
    //   51: getfield 136	tmsdk/common/d/a/c/o:i	Ljava/io/DataOutputStream;
    //   54: invokevirtual 305	java/io/DataOutputStream:close	()V
    //   57: aload_0
    //   58: getfield 121	tmsdk/common/d/a/c/o:h	Ljava/net/Socket;
    //   61: invokevirtual 306	java/net/Socket:close	()V
    //   64: aload_0
    //   65: aconst_null
    //   66: putfield 121	tmsdk/common/d/a/c/o:h	Ljava/net/Socket;
    //   69: ldc2_w 307
    //   72: invokestatic 312	java/lang/Thread:sleep	(J)V
    //   75: iconst_1
    //   76: ireturn
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual 315	java/lang/InterruptedException:printStackTrace	()V
    //   82: new 60	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 317
    //   92: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_1
    //   96: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: pop
    //   103: iconst_1
    //   104: ireturn
    //   105: astore_1
    //   106: new 60	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 322
    //   116: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: pop
    //   127: goto -101 -> 26
    //   130: astore_1
    //   131: new 60	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 324
    //   141: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_1
    //   145: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: pop
    //   152: goto -102 -> 50
    //   155: astore_1
    //   156: new 60	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 326
    //   166: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_1
    //   170: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: pop
    //   177: goto -120 -> 57
    //   180: astore_1
    //   181: new 60	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 328
    //   191: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_1
    //   195: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: pop
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_1
    //   205: goto -172 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	o
    //   77	19	1	localInterruptedException	java.lang.InterruptedException
    //   105	15	1	localException1	java.lang.Exception
    //   130	15	1	localException2	java.lang.Exception
    //   155	15	1	localException3	java.lang.Exception
    //   180	15	1	localIOException	java.io.IOException
    //   204	1	1	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   57	75	77	java/lang/InterruptedException
    //   19	26	105	java/lang/Exception
    //   43	50	130	java/lang/Exception
    //   50	57	155	java/lang/Exception
    //   57	75	180	java/io/IOException
    //   26	33	204	java/lang/Exception
  }
  
  private boolean i()
  {
    if (this.h == null) {}
    while ((this.h != null) && (this.h.isClosed())) {
      return true;
    }
    return false;
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
      new StringBuilder().append(" getActiveNetworkInfo NullPointerException--- \n").append(localNullPointerException.getMessage()).toString();
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
    case 0: 
      return b(paramArrayOfByte);
    }
    return c(paramArrayOfByte);
  }
  
  public Socket a(InetAddress paramInetAddress, int paramInt)
  {
    new StringBuilder().append("acquireSocketWithTimeOut, addr: ").append(paramInetAddress).append(", port: ").append(paramInt).toString();
    Socket localSocket = new Socket();
    localSocket.setSoLinger(false, 0);
    localSocket.connect(new InetSocketAddress(paramInetAddress, paramInt), 60000);
    return localSocket;
  }
  
  public void a(q paramq)
  {
    this.l = paramq;
  }
  
  public boolean a()
  {
    return !this.f;
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
    Context localContext = this.e;
    return a(this.e, parame, true);
  }
  
  public boolean b()
  {
    return a(false, false);
  }
  
  protected boolean c()
  {
    if (this.h == null) {}
    while ((i()) || (!this.h.isConnected())) {
      return false;
    }
    return true;
  }
  
  public String d()
  {
    if (this.h == null) {
      return "null";
    }
    return this.h.getLocalAddress().toString();
  }
  
  public int e()
  {
    if (this.h == null) {
      return 0;
    }
    return this.h.getLocalPort();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.o
 * JD-Core Version:    0.7.0.1
 */