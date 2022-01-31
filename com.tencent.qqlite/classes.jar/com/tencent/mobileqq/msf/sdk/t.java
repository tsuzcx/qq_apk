package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.core.k;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.IBaseService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

class t
{
  private static final String a = "MSF.D.RemoteServiceProxy";
  protected static ConcurrentLinkedQueue f = new ConcurrentLinkedQueue();
  protected static ConcurrentHashMap g = new ConcurrentHashMap();
  static final String k = "appTimeoutReq";
  protected volatile IBaseService d;
  protected Object e = new Object();
  protected volatile Handler h;
  protected volatile long i = -1L;
  AtomicInteger j = new AtomicInteger();
  String l;
  protected ServiceConnection m = new u(this);
  
  public t(String paramString)
  {
    this.l = paramString;
  }
  
  protected int a(ToServiceMsg paramToServiceMsg)
    throws RemoteException
  {
    return this.d.sendToServiceMsg(paramToServiceMsg);
  }
  
  protected FromServiceMsg a(ToServiceMsg paramToServiceMsg, String paramString)
  {
    paramToServiceMsg = k.a(paramToServiceMsg);
    paramToServiceMsg.setBusinessFail(1013, paramString);
    return paramToServiceMsg;
  }
  
  void a()
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.l);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      BaseApplication.getContext().startService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.RemoteServiceProxy", 2, " start service finish");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  /* Error */
  public int b(ToServiceMsg paramToServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_m1
    //   5: ireturn
    //   6: aload_1
    //   7: invokevirtual 147	com/tencent/qphone/base/remote/ToServiceMsg:getAppSeq	()I
    //   10: ifge +10 -> 20
    //   13: aload_1
    //   14: invokestatic 152	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getNextAppSeq	()I
    //   17: invokevirtual 156	com/tencent/qphone/base/remote/ToServiceMsg:setAppSeq	(I)V
    //   20: aload_0
    //   21: getfield 49	com/tencent/mobileqq/msf/sdk/t:e	Ljava/lang/Object;
    //   24: astore_3
    //   25: aload_3
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 158	com/tencent/mobileqq/msf/sdk/t:h	Landroid/os/Handler;
    //   31: ifnonnull +36 -> 67
    //   34: new 160	android/os/HandlerThread
    //   37: dup
    //   38: ldc 162
    //   40: iconst_5
    //   41: invokespecial 165	android/os/HandlerThread:<init>	(Ljava/lang/String;I)V
    //   44: astore 4
    //   46: aload 4
    //   48: invokevirtual 168	android/os/HandlerThread:start	()V
    //   51: aload_0
    //   52: new 170	android/os/Handler
    //   55: dup
    //   56: aload 4
    //   58: invokevirtual 174	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   61: invokespecial 177	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   64: putfield 158	com/tencent/mobileqq/msf/sdk/t:h	Landroid/os/Handler;
    //   67: aload_0
    //   68: invokevirtual 179	com/tencent/mobileqq/msf/sdk/t:h	()Z
    //   71: ifeq +127 -> 198
    //   74: iconst_1
    //   75: istore_2
    //   76: aload_3
    //   77: monitorexit
    //   78: aload_1
    //   79: invokevirtual 183	com/tencent/qphone/base/remote/ToServiceMsg:getTimeout	()J
    //   82: ldc2_w 50
    //   85: lcmp
    //   86: ifne +10 -> 96
    //   89: aload_1
    //   90: ldc2_w 184
    //   93: invokevirtual 189	com/tencent/qphone/base/remote/ToServiceMsg:setTimeout	(J)V
    //   96: aload_1
    //   97: invokevirtual 192	com/tencent/qphone/base/remote/ToServiceMsg:isNeedCallback	()Z
    //   100: ifeq +86 -> 186
    //   103: aload_1
    //   104: ldc 17
    //   106: aload_0
    //   107: getfield 58	com/tencent/mobileqq/msf/sdk/t:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   110: invokevirtual 195	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   113: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: getstatic 44	com/tencent/mobileqq/msf/sdk/t:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   123: aload_1
    //   124: invokevirtual 147	com/tencent/qphone/base/remote/ToServiceMsg:getAppSeq	()I
    //   127: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   130: aload_1
    //   131: invokevirtual 209	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   134: pop
    //   135: new 6	com/tencent/mobileqq/msf/sdk/t$a
    //   138: dup
    //   139: aload_0
    //   140: aload_1
    //   141: invokespecial 212	com/tencent/mobileqq/msf/sdk/t$a:<init>	(Lcom/tencent/mobileqq/msf/sdk/t;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   144: astore_3
    //   145: ldc 214
    //   147: aload_1
    //   148: invokevirtual 217	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   151: invokevirtual 223	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   154: ifne +15 -> 169
    //   157: ldc 225
    //   159: aload_1
    //   160: invokevirtual 217	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   163: invokevirtual 223	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   166: ifeq +52 -> 218
    //   169: aload_0
    //   170: getfield 158	com/tencent/mobileqq/msf/sdk/t:h	Landroid/os/Handler;
    //   173: aload_3
    //   174: aload_1
    //   175: invokevirtual 183	com/tencent/qphone/base/remote/ToServiceMsg:getTimeout	()J
    //   178: ldc2_w 226
    //   181: ladd
    //   182: invokevirtual 231	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   185: pop
    //   186: iload_2
    //   187: ifeq +66 -> 253
    //   190: aload_0
    //   191: aload_1
    //   192: invokevirtual 233	com/tencent/mobileqq/msf/sdk/t:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)I
    //   195: istore_2
    //   196: iload_2
    //   197: ireturn
    //   198: iconst_0
    //   199: istore_2
    //   200: goto -124 -> 76
    //   203: astore 4
    //   205: aload_3
    //   206: monitorexit
    //   207: aload 4
    //   209: athrow
    //   210: astore_3
    //   211: aload_0
    //   212: aload_1
    //   213: invokevirtual 236	com/tencent/mobileqq/msf/sdk/t:c	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   216: iconst_m1
    //   217: ireturn
    //   218: aload_0
    //   219: getfield 158	com/tencent/mobileqq/msf/sdk/t:h	Landroid/os/Handler;
    //   222: aload_3
    //   223: aload_1
    //   224: invokevirtual 183	com/tencent/qphone/base/remote/ToServiceMsg:getTimeout	()J
    //   227: ldc2_w 237
    //   230: ladd
    //   231: invokevirtual 231	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   234: pop
    //   235: goto -49 -> 186
    //   238: astore_3
    //   239: aload_0
    //   240: getfield 72	com/tencent/mobileqq/msf/sdk/t:d	Lcom/tencent/qphone/base/remote/IBaseService;
    //   243: ifnonnull +37 -> 280
    //   246: aload_0
    //   247: aload_1
    //   248: invokevirtual 236	com/tencent/mobileqq/msf/sdk/t:c	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   251: iconst_m1
    //   252: ireturn
    //   253: aload_0
    //   254: aload_1
    //   255: invokevirtual 236	com/tencent/mobileqq/msf/sdk/t:c	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   258: aload_0
    //   259: getfield 49	com/tencent/mobileqq/msf/sdk/t:e	Ljava/lang/Object;
    //   262: astore_3
    //   263: aload_3
    //   264: monitorenter
    //   265: aload_0
    //   266: invokevirtual 240	com/tencent/mobileqq/msf/sdk/t:i	()V
    //   269: aload_3
    //   270: monitorexit
    //   271: iconst_m1
    //   272: ireturn
    //   273: astore 4
    //   275: aload_3
    //   276: monitorexit
    //   277: aload 4
    //   279: athrow
    //   280: aload_3
    //   281: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   284: iconst_m1
    //   285: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	t
    //   0	286	1	paramToServiceMsg	ToServiceMsg
    //   75	125	2	n	int
    //   210	13	3	localDeadObjectException	android.os.DeadObjectException
    //   238	1	3	localException	Exception
    //   44	13	4	localHandlerThread	android.os.HandlerThread
    //   203	5	4	localObject3	Object
    //   273	5	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   27	67	203	finally
    //   67	74	203	finally
    //   76	78	203	finally
    //   205	207	203	finally
    //   20	27	210	android/os/DeadObjectException
    //   78	96	210	android/os/DeadObjectException
    //   96	169	210	android/os/DeadObjectException
    //   169	186	210	android/os/DeadObjectException
    //   190	196	210	android/os/DeadObjectException
    //   207	210	210	android/os/DeadObjectException
    //   218	235	210	android/os/DeadObjectException
    //   253	265	210	android/os/DeadObjectException
    //   277	280	210	android/os/DeadObjectException
    //   20	27	238	java/lang/Exception
    //   78	96	238	java/lang/Exception
    //   96	169	238	java/lang/Exception
    //   169	186	238	java/lang/Exception
    //   190	196	238	java/lang/Exception
    //   207	210	238	java/lang/Exception
    //   218	235	238	java/lang/Exception
    //   253	265	238	java/lang/Exception
    //   277	280	238	java/lang/Exception
    //   265	271	273	finally
    //   275	277	273	finally
  }
  
  /* Error */
  boolean b()
  {
    // Byte code:
    //   0: new 94	android/content/ComponentName
    //   3: dup
    //   4: invokestatic 100	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   7: invokevirtual 106	android/content/Context:getPackageName	()Ljava/lang/String;
    //   10: aload_0
    //   11: getfield 67	com/tencent/mobileqq/msf/sdk/t:l	Ljava/lang/String;
    //   14: invokespecial 109	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: astore_2
    //   18: new 111	android/content/Intent
    //   21: dup
    //   22: invokespecial 112	android/content/Intent:<init>	()V
    //   25: astore_3
    //   26: aload_3
    //   27: aload_2
    //   28: invokevirtual 116	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   31: pop
    //   32: invokestatic 100	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   35: aload_3
    //   36: aload_0
    //   37: getfield 65	com/tencent/mobileqq/msf/sdk/t:m	Landroid/content/ServiceConnection;
    //   40: iconst_1
    //   41: invokevirtual 244	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   44: istore_1
    //   45: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq +40 -> 88
    //   51: ldc 10
    //   53: iconst_2
    //   54: new 246	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   61: ldc 249
    //   63: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: getfield 67	com/tencent/mobileqq/msf/sdk/t:l	Ljava/lang/String;
    //   70: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 255
    //   75: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload_1
    //   79: invokevirtual 258	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   82: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: iload_1
    //   89: ireturn
    //   90: astore_2
    //   91: iconst_0
    //   92: istore_1
    //   93: aload_2
    //   94: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   97: iload_1
    //   98: ireturn
    //   99: astore_2
    //   100: goto -7 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	t
    //   44	54	1	bool	boolean
    //   17	11	2	localComponentName	ComponentName
    //   90	4	2	localException1	Exception
    //   99	1	2	localException2	Exception
    //   25	11	3	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   0	45	90	java/lang/Exception
    //   45	88	99	java/lang/Exception
  }
  
  protected void c(ToServiceMsg paramToServiceMsg)
  {
    f.add(paramToServiceMsg);
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      paramToServiceMsg.getActionListener().onRecvFromMsg(paramFromServiceMsg);
      return;
    }
    catch (RemoteException paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
  }
  
  public boolean c()
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext(), this.l);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      boolean bool = BaseApplication.getContext().stopService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.RemoteServiceProxy", 2, " stopService " + this.l + " service finished " + bool);
      }
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  protected void d()
  {
    v localv = new v(this);
    localv.setName("handleWaitSendProxyMsgThread");
    localv.start();
  }
  
  public void g()
  {
    try
    {
      BaseApplication.getContext().unbindService(this.m);
      this.d = null;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.RemoteServiceProxy", 2, " unbindService service finished");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected boolean h()
  {
    return this.d != null;
  }
  
  public void i()
  {
    long l1 = System.currentTimeMillis();
    if ((this.i == -1L) || (l1 - this.i > 10000L))
    {
      this.i = l1;
      a();
      b();
      return;
    }
    QLog.d("MSF.D.RemoteServiceProxy", 1, "wait start " + this.l + " service result, skiped...");
  }
  
  protected class a
    implements Runnable
  {
    private ToServiceMsg b;
    
    public a(ToServiceMsg paramToServiceMsg)
    {
      this.b = paramToServiceMsg;
    }
    
    public void run()
    {
      Object localObject = (ToServiceMsg)t.g.get(Integer.valueOf(this.b.getAppSeq()));
      if ((localObject != null) && (((ToServiceMsg)localObject).getAttribute("appTimeoutReq", Integer.valueOf(-1)) == this.b.getAttribute("appTimeoutReq", Integer.valueOf(-2))) && ((ToServiceMsg)t.g.remove(Integer.valueOf(this.b.getAppSeq())) != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.D.RemoteServiceProxy", 2, "found timeout req, appseq is " + this.b.getAppSeq());
        }
        localObject = t.this.a(this.b, this.b.getServiceName() + " timeout");
        t.this.a(this.b, (FromServiceMsg)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.t
 * JD-Core Version:    0.7.0.1
 */