package com.tencent.mobileqq.apollo.lightGame;

import abxh;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class CmGameSocketConnection
{
  private HandlerThread B;
  private HandlerThread C;
  private long NV;
  private ReadRunnable jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$ReadRunnable;
  private b jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$b;
  private AtomicBoolean co = new AtomicBoolean(false);
  private Handler cs;
  private List<String> eM;
  private WeakReference<a> fE;
  private int mConnTimeOut;
  private MsfSocketInputBuffer mInputBuffer;
  private OutputStream mOutputStream;
  private int mPort;
  private int mReadBufferSize;
  private int mReadTimeout;
  private Socket mSocket;
  private ConcurrentLinkedQueue<byte[]> t = new ConcurrentLinkedQueue();
  
  public CmGameSocketConnection(c paramc)
  {
    a(paramc);
    this.mReadBufferSize = 32768;
  }
  
  private boolean YE()
  {
    return (this.t != null) && (!this.t.isEmpty());
  }
  
  /* Error */
  private boolean YF()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_0
    //   5: getfield 59	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:co	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   8: invokevirtual 81	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   11: ifne +13 -> 24
    //   14: ldc 83
    //   16: iconst_1
    //   17: ldc 85
    //   19: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: iconst_0
    //   23: ireturn
    //   24: iload_2
    //   25: istore_1
    //   26: aload_0
    //   27: getfield 64	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:t	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   30: invokevirtual 75	java/util/concurrent/ConcurrentLinkedQueue:isEmpty	()Z
    //   33: ifne +110 -> 143
    //   36: iload_2
    //   37: istore_1
    //   38: aload_0
    //   39: getfield 64	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:t	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   42: invokevirtual 95	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
    //   45: checkcast 97	[B
    //   48: astore 4
    //   50: aload 4
    //   52: ifnull +91 -> 143
    //   55: iload_2
    //   56: istore_1
    //   57: aload_0
    //   58: getfield 99	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:mOutputStream	Ljava/io/OutputStream;
    //   61: ifnull +82 -> 143
    //   64: iload_2
    //   65: istore_1
    //   66: aload_0
    //   67: getfield 99	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:mOutputStream	Ljava/io/OutputStream;
    //   70: astore 5
    //   72: iload_2
    //   73: istore_1
    //   74: aload 5
    //   76: monitorenter
    //   77: iload_3
    //   78: istore_2
    //   79: aload_0
    //   80: getfield 99	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:mOutputStream	Ljava/io/OutputStream;
    //   83: aload 4
    //   85: invokevirtual 105	java/io/OutputStream:write	([B)V
    //   88: iload_3
    //   89: istore_2
    //   90: aload_0
    //   91: getfield 99	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:mOutputStream	Ljava/io/OutputStream;
    //   94: invokevirtual 108	java/io/OutputStream:flush	()V
    //   97: aload 5
    //   99: monitorexit
    //   100: iconst_1
    //   101: istore_1
    //   102: iload_1
    //   103: ireturn
    //   104: astore 4
    //   106: iload_2
    //   107: istore_1
    //   108: iload_1
    //   109: istore_2
    //   110: aload 5
    //   112: monitorexit
    //   113: aload 4
    //   115: athrow
    //   116: astore 4
    //   118: ldc 83
    //   120: iconst_1
    //   121: ldc 110
    //   123: aload 4
    //   125: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_0
    //   129: iconst_1
    //   130: invokevirtual 117	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:DQ	(Z)V
    //   133: goto -31 -> 102
    //   136: astore 4
    //   138: iconst_1
    //   139: istore_1
    //   140: goto -32 -> 108
    //   143: iconst_0
    //   144: istore_1
    //   145: goto -43 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	CmGameSocketConnection
    //   25	120	1	bool1	boolean
    //   1	109	2	bool2	boolean
    //   3	86	3	bool3	boolean
    //   48	36	4	arrayOfByte	byte[]
    //   104	10	4	localObject1	Object
    //   116	8	4	localException	Exception
    //   136	1	4	localObject2	Object
    //   70	41	5	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   79	88	104	finally
    //   90	97	104	finally
    //   110	113	104	finally
    //   26	36	116	java/lang/Exception
    //   38	50	116	java/lang/Exception
    //   57	64	116	java/lang/Exception
    //   66	72	116	java/lang/Exception
    //   74	77	116	java/lang/Exception
    //   113	116	116	java/lang/Exception
    //   97	100	136	finally
  }
  
  /* Error */
  private boolean YG()
  {
    // Byte code:
    //   0: ldc 83
    //   2: iconst_1
    //   3: ldc 120
    //   5: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: aload_0
    //   9: getfield 59	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:co	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   12: invokevirtual 81	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   15: ifne +13 -> 28
    //   18: ldc 83
    //   20: iconst_1
    //   21: ldc 122
    //   23: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: aload_0
    //   29: getfield 124	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:fE	Ljava/lang/ref/WeakReference;
    //   32: ifnull +83 -> 115
    //   35: aload_0
    //   36: getfield 124	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:fE	Ljava/lang/ref/WeakReference;
    //   39: invokevirtual 128	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   42: checkcast 9	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection$a
    //   45: astore_2
    //   46: aload_2
    //   47: ifnull +68 -> 115
    //   50: aload_2
    //   51: invokeinterface 132 1 0
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull +57 -> 115
    //   61: aload_0
    //   62: getfield 99	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:mOutputStream	Ljava/io/OutputStream;
    //   65: ifnull +50 -> 115
    //   68: aload_0
    //   69: getfield 99	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:mOutputStream	Ljava/io/OutputStream;
    //   72: astore_2
    //   73: aload_2
    //   74: monitorenter
    //   75: aload_0
    //   76: getfield 99	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:mOutputStream	Ljava/io/OutputStream;
    //   79: aload_3
    //   80: invokevirtual 105	java/io/OutputStream:write	([B)V
    //   83: aload_0
    //   84: getfield 99	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:mOutputStream	Ljava/io/OutputStream;
    //   87: invokevirtual 108	java/io/OutputStream:flush	()V
    //   90: aload_2
    //   91: monitorexit
    //   92: goto +23 -> 115
    //   95: astore_3
    //   96: aload_2
    //   97: monitorexit
    //   98: aload_3
    //   99: athrow
    //   100: astore_2
    //   101: ldc 83
    //   103: iconst_1
    //   104: ldc 134
    //   106: aload_2
    //   107: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   110: iconst_0
    //   111: istore_1
    //   112: goto +5 -> 117
    //   115: iconst_1
    //   116: istore_1
    //   117: iload_1
    //   118: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	CmGameSocketConnection
    //   111	7	1	bool	boolean
    //   100	7	2	localException	Exception
    //   56	24	3	arrayOfByte	byte[]
    //   95	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   75	92	95	finally
    //   96	98	95	finally
    //   28	46	100	java/lang/Exception
    //   50	57	100	java/lang/Exception
    //   61	75	100	java/lang/Exception
    //   98	100	100	java/lang/Exception
  }
  
  private void cDh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConnection", 2, "[clearLastestConnection]");
    }
    if (!this.co.get())
    {
      QLog.w("CmGameConnection", 1, "[clearLastestConnection] not connected now");
      return;
    }
    this.co.set(false);
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$b != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$b.removeCallbacksAndMessages(null);
      }
      if (this.mOutputStream != null)
      {
        this.mOutputStream.close();
        this.mOutputStream = null;
      }
      if (this.cs != null) {
        this.cs.removeCallbacksAndMessages(null);
      }
      if (this.mSocket != null)
      {
        this.mSocket.close();
        this.mSocket = null;
      }
      this.mInputBuffer = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.d("CmGameConnection", 1, "[clearLastestConnection] exception=", localException);
    }
  }
  
  private boolean connect()
  {
    QLog.d("CmGameConnection", 1, "[connect]");
    if ((this.eM == null) || (this.eM.size() == 0))
    {
      QLog.e("CmGameConnection", 1, "[connect] empty host");
      return false;
    }
    if (this.co.get())
    {
      QLog.e("CmGameConnection", 1, "[connect] already running");
      return false;
    }
    long l1 = SystemClock.uptimeMillis();
    int k = this.eM.size();
    int i = 14;
    boolean bool1 = false;
    int j = 0;
    boolean bool2;
    for (;;)
    {
      bool2 = bool1;
      Object localObject;
      if (j < k)
      {
        localObject = (String)this.eM.get(j);
        bool2 = bool1;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          QLog.d("CmGameConnection", 2, new Object[] { "[connect] host=", localObject, ", port=", Integer.valueOf(this.mPort) });
        }
        bool2 = bool1;
        localObject = new InetSocketAddress((String)localObject, this.mPort);
        bool2 = bool1;
        this.mSocket = new Socket();
        bool2 = bool1;
        this.mSocket.setKeepAlive(true);
        bool2 = bool1;
        this.mSocket.setTcpNoDelay(true);
        bool2 = bool1;
        this.mSocket.setSoTimeout(this.mReadTimeout);
        bool2 = bool1;
        this.mSocket.setSendBufferSize(524288);
        bool2 = bool1;
        long l2 = SystemClock.uptimeMillis();
        bool2 = bool1;
        this.mSocket.connect((SocketAddress)localObject, this.mConnTimeOut);
        bool2 = bool1;
        QLog.d("CmGameConnection", 1, new Object[] { "[connect] cost time=", Long.valueOf(SystemClock.uptimeMillis() - l2), "ms" });
        bool2 = bool1;
        this.mOutputStream = this.mSocket.getOutputStream();
        bool2 = bool1;
        this.mInputBuffer = new MsfSocketInputBuffer(this.mSocket, this.mReadBufferSize, "US-ASCII", -1);
        bool2 = bool1;
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$ReadRunnable = new ReadRunnable(this);
        bool2 = bool1;
        this.C = ThreadManager.newFreeHandlerThread("CmGame_Socket_Reader", 0);
        bool2 = bool1;
        this.C.start();
        bool2 = bool1;
        this.cs = new Handler(this.C.getLooper());
        bool2 = bool1;
        this.co.set(true);
        bool2 = bool1;
        this.cs.post(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$ReadRunnable);
        bool2 = true;
        bool1 = true;
        this.NV = SystemClock.uptimeMillis();
        i = 0;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          bool1 = aqiw.bW(BaseApplicationImpl.getApplication().getApplicationContext());
          QLog.d("CmGameConnection", 1, new Object[] { "[connect] hasNet=", Boolean.valueOf(bool1), ", exception=", localThrowable });
          String str = localThrowable.toString().toLowerCase();
          if (!bool1)
          {
            i = 3;
            bool1 = bool2;
          }
          else if (str.indexOf("illegal") > -1)
          {
            i = 1;
            bool1 = bool2;
          }
          else if (str.indexOf("route to host") > -1)
          {
            i = 2;
            bool1 = bool2;
          }
          else if (str.indexOf("unreachable") > -1)
          {
            i = 3;
            bool1 = bool2;
          }
          else if (str.indexOf("permission") > -1)
          {
            i = 4;
            bool1 = bool2;
          }
          else if (str.indexOf("refused") > -1)
          {
            i = 5;
            bool1 = bool2;
          }
          else if (str.indexOf("reset") > -1)
          {
            i = 6;
            bool1 = bool2;
          }
          else if ((str.indexOf("timeoutexception") > -1) || (str.indexOf(") after") > -1))
          {
            i = 7;
            bool1 = bool2;
          }
          else if (str.indexOf("unknownhost") > -1)
          {
            i = 8;
            bool1 = bool2;
          }
          else if (str.indexOf("unresolved") > -1)
          {
            i = 9;
            bool1 = bool2;
          }
          else if (str.indexOf("enotsock") > -1)
          {
            i = 10;
            bool1 = bool2;
          }
          else if (str.indexOf("enobufs") > -1)
          {
            i = 11;
            bool1 = bool2;
          }
          else if (str.indexOf("ebadf") > -1)
          {
            i = 12;
            bool1 = bool2;
          }
          else if (str.indexOf("operation") > -1)
          {
            i = 7;
            bool1 = bool2;
          }
          else if (str.indexOf("invalid") > -1)
          {
            i = 13;
            bool1 = bool2;
          }
          else
          {
            i = 14;
            bool1 = bool2;
          }
        }
        j += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CmGameConnection", 2, new Object[] { "[connect] index=", Integer.valueOf(j), ", success=", Boolean.valueOf(bool1) });
      }
      if (bool1)
      {
        bool2 = bool1;
        QLog.d("CmGameConnection", 1, new Object[] { "[connect] isSuccess=", Boolean.valueOf(bool2), ", failCode=", Integer.valueOf(i), ", duration=", Long.valueOf(SystemClock.uptimeMillis() - l1), "ms" });
        return bool2;
      }
    }
  }
  
  public void DQ(boolean paramBoolean)
  {
    try
    {
      QLog.d("CmGameConnection", 1, new Object[] { "[disconnect] shouldReconnect=", Boolean.valueOf(paramBoolean), ", conn duration=", Long.valueOf(SystemClock.uptimeMillis() - this.NV), "ms" });
      cDh();
      if (this.fE != null)
      {
        a locala = (a)this.fE.get();
        if (locala != null) {
          locala.DN(paramBoolean);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    this.fE = new WeakReference(parama);
  }
  
  public void a(c paramc)
  {
    this.eM = paramc.ipList;
    this.mPort = paramc.port;
    this.mReadTimeout = paramc.readTimeout;
    this.mConnTimeOut = paramc.connectionTimeout;
  }
  
  public void cDi()
  {
    QLog.d("CmGameConnection", 1, "[notifyConnSuccess]");
    if (this.fE != null)
    {
      a locala = (a)this.fE.get();
      if (locala != null) {
        locala.cDc();
      }
    }
  }
  
  public void cDj()
  {
    cDh();
    if (this.fE != null)
    {
      a locala = (a)this.fE.get();
      if (locala != null) {
        locala.cDd();
      }
    }
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConnection", 2, "[destroy]");
    }
    try
    {
      this.co.set(false);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$b != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$b.removeCallbacksAndMessages(null);
      }
      if (this.B != null)
      {
        this.B.quit();
        this.B = null;
      }
      if (this.mOutputStream != null)
      {
        this.mOutputStream.close();
        this.mOutputStream = null;
      }
      if (this.C != null)
      {
        this.C.quit();
        this.C = null;
      }
      if (this.cs != null)
      {
        this.cs.removeCallbacksAndMessages(null);
        this.cs = null;
      }
      if (this.mSocket != null)
      {
        this.mSocket.close();
        this.mSocket = null;
      }
      this.mInputBuffer = null;
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$ReadRunnable = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.d("CmGameConnection", 1, "[destoryInner] exception=", localException);
    }
  }
  
  public boolean isConnected()
  {
    return this.co.get();
  }
  
  /* Error */
  public void open()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 83
    //   4: iconst_1
    //   5: ldc_w 433
    //   8: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11: aload_0
    //   12: getfield 59	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:co	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   15: invokevirtual 81	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   18: ifeq +15 -> 33
    //   21: ldc 83
    //   23: iconst_1
    //   24: ldc_w 435
    //   27: invokestatic 158	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: getfield 425	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:B	Landroid/os/HandlerThread;
    //   37: ifnonnull +21 -> 58
    //   40: aload_0
    //   41: ldc_w 437
    //   44: iconst_0
    //   45: invokestatic 288	com/tencent/mobileqq/app/ThreadManager:newFreeHandlerThread	(Ljava/lang/String;I)Landroid/os/HandlerThread;
    //   48: putfield 425	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:B	Landroid/os/HandlerThread;
    //   51: aload_0
    //   52: getfield 425	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:B	Landroid/os/HandlerThread;
    //   55: invokevirtual 295	android/os/HandlerThread:start	()V
    //   58: aload_0
    //   59: getfield 163	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$b	Lcom/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection$b;
    //   62: ifnonnull +22 -> 84
    //   65: aload_0
    //   66: new 12	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection$b
    //   69: dup
    //   70: aload_0
    //   71: getfield 425	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:B	Landroid/os/HandlerThread;
    //   74: invokevirtual 299	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   77: aload_0
    //   78: invokespecial 440	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection$b:<init>	(Landroid/os/Looper;Lcom/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection;)V
    //   81: putfield 163	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$b	Lcom/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection$b;
    //   84: aload_0
    //   85: getfield 163	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$b	Lcom/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection$b;
    //   88: iconst_1
    //   89: invokevirtual 444	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection$b:sendEmptyMessage	(I)Z
    //   92: pop
    //   93: goto -63 -> 30
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	CmGameSocketConnection
    //   96	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	30	96	finally
    //   33	58	96	finally
    //   58	84	96	finally
    //   84	93	96	finally
  }
  
  public void wakeup()
  {
    QLog.d("CmGameConnection", 1, "wakeup");
    if (!this.co.get())
    {
      QLog.w("CmGameConnection", 1, "[wakeup] failed, not connected");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$b.removeMessages(2);
    this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$b.sendEmptyMessage(2);
  }
  
  static class ReadRunnable
    implements Runnable
  {
    private WeakReference<CmGameSocketConnection> fF;
    
    public ReadRunnable(CmGameSocketConnection paramCmGameSocketConnection)
    {
      this.fF = new WeakReference(paramCmGameSocketConnection);
    }
    
    public void run()
    {
      if (this.fF != null)
      {
        CmGameSocketConnection localCmGameSocketConnection = (CmGameSocketConnection)this.fF.get();
        for (;;)
        {
          if ((localCmGameSocketConnection != null) && (CmGameSocketConnection.a(localCmGameSocketConnection).get())) {
            try
            {
              MsfSocketInputBuffer localMsfSocketInputBuffer = CmGameSocketConnection.a(localCmGameSocketConnection);
              if (localMsfSocketInputBuffer == null) {
                return;
              }
              while (!localMsfSocketInputBuffer.isDataAvailable(10000)) {
                if (!CmGameSocketConnection.a(localCmGameSocketConnection).get()) {
                  return;
                }
              }
              if (CmGameSocketConnection.a(localCmGameSocketConnection).get())
              {
                if (CmGameSocketConnection.a(localCmGameSocketConnection) != null)
                {
                  CmGameSocketConnection.a locala = (CmGameSocketConnection.a)CmGameSocketConnection.a(localCmGameSocketConnection).get();
                  if (locala != null) {
                    locala.a(localMsfSocketInputBuffer);
                  }
                }
                localMsfSocketInputBuffer.reset();
              }
            }
            catch (Exception localException)
            {
              QLog.e("CmGameConnection.ReadRunnable", 1, "read exception, e=", localException);
              localCmGameSocketConnection.DQ(true);
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void DN(boolean paramBoolean);
    
    public abstract byte[] O();
    
    public abstract void a(MsfSocketInputBuffer paramMsfSocketInputBuffer);
    
    public abstract void cDc();
    
    public abstract void cDd();
  }
  
  static class b
    extends Handler
  {
    private WeakReference<CmGameSocketConnection> fF;
    
    public b(Looper paramLooper, CmGameSocketConnection paramCmGameSocketConnection)
    {
      super();
      this.fF = new WeakReference(paramCmGameSocketConnection);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmGameConnection.ConnectionHandler", 2, "[handleMessage] msg=" + paramMessage.what);
      }
      if (this.fF != null) {}
      for (CmGameSocketConnection localCmGameSocketConnection = (CmGameSocketConnection)this.fF.get();; localCmGameSocketConnection = null)
      {
        if (localCmGameSocketConnection == null) {
          QLog.e("CmGameConnection.ConnectionHandler", 1, "[handleMessage] no connection");
        }
        boolean bool;
        label165:
        do
        {
          do
          {
            return;
            switch (paramMessage.what)
            {
            default: 
              return;
            case 1: 
              bool = CmGameSocketConnection.a(localCmGameSocketConnection);
              if (QLog.isColorLevel()) {
                QLog.d("CmGameConnection.ConnectionHandler", 2, new Object[] { "[handleMessage] conn result=", Boolean.valueOf(bool), ", connected=", Boolean.valueOf(localCmGameSocketConnection.isConnected()) });
              }
              if (bool) {
                break label165;
              }
            }
          } while (localCmGameSocketConnection.isConnected());
          localCmGameSocketConnection.cDj();
          return;
          super.removeMessages(2);
          paramMessage = super.obtainMessage(2);
          paramMessage.obj = Boolean.valueOf(true);
          super.sendMessage(paramMessage);
          return;
          bool = CmGameSocketConnection.b(localCmGameSocketConnection);
          super.removeMessages(2);
          if (QLog.isColorLevel()) {
            QLog.d("CmGameConnection.ConnectionHandler", 1, new Object[] { "[handleMessage] heartbeat, result=", Boolean.valueOf(bool), ", flag=", paramMessage.obj });
          }
          if (bool)
          {
            if ((paramMessage.obj != null) && (((Boolean)paramMessage.obj).booleanValue())) {
              localCmGameSocketConnection.cDi();
            }
            if (abxh.OP > 0L) {}
            for (l = abxh.OP;; l = 120000L)
            {
              super.sendEmptyMessageDelayed(2, l);
              return;
            }
          }
          localCmGameSocketConnection.DQ(true);
          return;
          bool = CmGameSocketConnection.c(localCmGameSocketConnection);
          if (QLog.isColorLevel()) {
            QLog.d("CmGameConnection.ConnectionHandler", 1, new Object[] { "[handleMessage] send, result=", Boolean.valueOf(bool) });
          }
        } while (!bool);
        super.removeMessages(2);
        if (abxh.OP > 0L) {}
        for (long l = abxh.OP;; l = 120000L)
        {
          super.sendEmptyMessageDelayed(2, l);
          if (!CmGameSocketConnection.d(localCmGameSocketConnection)) {
            break;
          }
          super.removeMessages(3);
          super.sendEmptyMessage(3);
          return;
        }
      }
    }
  }
  
  public static class c
  {
    public int connectionTimeout;
    public List<String> ipList;
    public int port;
    public int readTimeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameSocketConnection
 * JD-Core Version:    0.7.0.1
 */