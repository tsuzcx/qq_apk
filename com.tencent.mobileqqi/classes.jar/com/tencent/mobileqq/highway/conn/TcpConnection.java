package com.tencent.mobileqq.highway.conn;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.codec.HttpProtocolDataCodec;
import com.tencent.mobileqq.highway.codec.IProtocolCodecListener;
import com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.IRequestListener;
import com.tencent.mobileqq.highway.segment.RequestHeartBreak;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class TcpConnection
  implements IConnection, IProtocolCodecListener
{
  public static final int DEDAULT_CONN_TIMEOUT_xG = 20000;
  public static final int DEFAULT_CONN_TIMEOUT_Wi = 10000;
  public static final int DEFAULT_READ_BUF_SIZE = 32768;
  public static final int DEFAULT_READ_TIMEOUT = 30000;
  public static final int DEFAULT_SEND_BUF_SIZE = 524288;
  public static final int HEARTBREAK_DELTA = 20000;
  private static final int MAX_CONTINUE_HREAT = 2;
  private StringBuilder closeDebug = new StringBuilder("ConnTag:");
  private int connId;
  private ConnReportInfo connInfo = new ConnReportInfo();
  private IConnectionListener connListener;
  private ConnManager connManager;
  private int continueHeartBreak = 0;
  private TcpProtocolDataCodec dataCodec;
  private AtomicBoolean isConn = new AtomicBoolean(false);
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private volatile boolean isUrgent = false;
  private AtomicBoolean isWritting = new AtomicBoolean(false);
  private long lastHeartBreakTime = 0L;
  private ReentrantLock lock = new ReentrantLock();
  private ConnWorker mConnHandler;
  private HandlerThread mConnThread;
  private int mConnTimeOut = 0;
  private EndPoint mEp;
  private MsfSocketInputBuffer mInputBuffer = null;
  public int mLastDataSegSize = 0;
  public long mLastDataTransTime = 0L;
  private int mNetFlowDw = 0;
  private int mNetFlowUp = 0;
  private OutputStream mOutputStream;
  private int mReadBufferSize;
  private ReadThread mReadThread;
  private int mReadTimeout;
  public long mRtt = 0L;
  private Handler mServletHandler = null;
  private Socket mSocket;
  private InetSocketAddress serverAddress = null;
  private AtomicBoolean shouldCloseConn = new AtomicBoolean(false);
  
  public TcpConnection(ConnManager paramConnManager, int paramInt1, EndPoint paramEndPoint, int paramInt2, int paramInt3)
  {
    if (paramEndPoint.protoType == 2) {}
    for (this.dataCodec = new HttpProtocolDataCodec();; this.dataCodec = new TcpProtocolDataCodec())
    {
      this.connManager = paramConnManager;
      this.mReadBufferSize = 32768;
      this.mReadTimeout = paramInt3;
      this.connId = paramInt1;
      this.mEp = paramEndPoint;
      this.mConnTimeOut = paramInt2;
      this.mConnThread = new HandlerThread("BDH-CONN" + paramInt1);
      this.dataCodec.setProtocolCodecListener(this);
      this.mServletHandler = new Handler(Looper.getMainLooper());
      return;
    }
  }
  
  private void closeConn(final int paramInt)
  {
    QLog.d("BDH_LOG", 1, "CCloseConn at : ConnId:" + this.connId + " Src:" + paramInt);
    if (this.mInputBuffer != null)
    {
      localObject1 = this.mInputBuffer.instream;
      if (localObject1 != null) {
        setExclusiveStream(false, localObject1.toString());
      }
    }
    if (this.mOutputStream != null) {
      setExclusiveStream(false, this.mOutputStream.toString());
    }
    this.isRunning.set(false);
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool3 = false;
    boolean bool1 = bool5;
    boolean bool2 = bool6;
    for (;;)
    {
      try
      {
        if (this.mSocket == null) {
          return;
        }
        bool1 = bool5;
        bool2 = bool6;
        if (!this.isConn.get()) {
          return;
        }
        bool1 = bool5;
        bool2 = bool6;
        boolean bool7 = this.lock.tryLock(30000L, TimeUnit.MILLISECONDS);
        if (!bool7) {
          continue;
        }
        bool3 = bool4;
      }
      catch (InterruptedException localInterruptedException)
      {
        final int i;
        BdhLogUtil.LogException("C", "CloseConn Error.", localInterruptedException);
        continue;
        bool1 = bool5;
        bool2 = bool6;
        this.shouldCloseConn.set(true);
        bool1 = bool3;
        continue;
      }
      catch (Exception localException1)
      {
        label228:
        BdhLogUtil.LogException("C", "CloseConn Error.", localException1);
        bool1 = bool2;
        continue;
      }
      try
      {
        localObject1 = this.mConnHandler;
        if (localObject1 != null)
        {
          bool3 = bool4;
          ((ConnWorker)localObject1).notifyToQuit();
        }
        bool3 = bool4;
        this.mInputBuffer = null;
        bool3 = bool4;
        this.mOutputStream = null;
        bool3 = bool4;
      }
      finally
      {
        bool1 = bool3;
        bool2 = bool3;
        this.lock.unlock();
        bool1 = bool3;
        bool2 = bool3;
      }
    }
    try
    {
      if (this.mSocket != null)
      {
        bool3 = bool4;
        this.mSocket.close();
      }
    }
    catch (Exception localException2)
    {
      break label228;
    }
    bool3 = bool4;
    this.isConn.set(false);
    bool3 = bool4;
    this.mSocket = null;
    bool3 = bool4;
    this.mReadThread = null;
    bool1 = true;
    bool5 = true;
    bool2 = true;
    bool4 = true;
    bool3 = bool1;
    this.connInfo.finished = true;
    bool3 = bool1;
    this.connInfo.connLifeLong = (SystemClock.uptimeMillis() - this.connInfo.connStartTime);
    bool3 = bool1;
    paramInt = this.mNetFlowUp;
    bool3 = bool1;
    i = this.mNetFlowDw;
    bool3 = bool1;
    this.mNetFlowUp = 0;
    bool3 = bool1;
    this.mNetFlowDw = 0;
    bool3 = bool1;
    new Thread(new Runnable()
    {
      public void run()
      {
        HwServlet.reportTraffic4PicUp(TcpConnection.this.connManager.engine.app, TcpConnection.this.connInfo.serverIp, TcpConnection.this.connInfo.port, true, paramInt);
        HwServlet.reportTraffic4PicUp(TcpConnection.this.connManager.engine.app, TcpConnection.this.connInfo.serverIp, TcpConnection.this.connInfo.port, false, i);
      }
    }).start();
    bool1 = bool5;
    this.lock.unlock();
    bool1 = bool4;
    Object localObject1 = this.connListener;
    if (localObject1 != null) {
      ((IConnectionListener)localObject1).onDisConnect(this.connId, this);
    }
    BdhLogUtil.LogEvent("C", "CloseConn End. connId:" + this.connId + " isCloseSuccess:" + bool1);
    return;
  }
  
  private void doSendData()
  {
    for (;;)
    {
      if ((!this.isRunning.get()) || (this.isWritting.get())) {
        label20:
        return;
      }
      try
      {
        ??? = this.connManager.pullNextRequest(this, this.isUrgent, this.mLastDataTransTime, this.mRtt, this.mLastDataSegSize);
        if (??? == null)
        {
          this.isWritting.set(false);
          if (SystemClock.uptimeMillis() - this.lastHeartBreakTime <= 60000L) {
            break label20;
          }
          this.lastHeartBreakTime = SystemClock.uptimeMillis();
          ??? = this.connManager;
          i = this.connId;
          if (this.continueHeartBreak == 0)
          {
            bool = true;
            label102:
            ((ConnManager)???).onConnectionIdle(i, bool);
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        int i;
        boolean bool;
        BdhLogUtil.LogException("C", "SendThread Error.", localException2);
        synchronized (this.closeDebug)
        {
          this.closeDebug.append("By SendWorker :" + localException2.getMessage() + ";");
          closeConn(2);
          continue;
          bool = false;
          break label102;
          BdhLogUtil.LogEvent("R", "req sending: reqId = " + ((HwRequest)???).getHwSeq() + " req.timeOutCount = " + ((HwRequest)???).timeOutCount + " req.timeOut = " + ((HwRequest)???).timeOut);
          this.isWritting.set(true);
          ((HwRequest)???).endpoint = this.mEp;
          if ((??? instanceof RequestHeartBreak))
          {
            if (this.continueHeartBreak > 2)
            {
              this.connInfo.killSelf = true;
              closeConn(4);
              return;
            }
            this.continueHeartBreak += 1;
          }
          for (;;)
          {
            try
            {
              arrayOfByte = ((HwRequest)???).getRequestBody();
              if ((arrayOfByte != null) || (!((HwRequest)???).hasRequestBody())) {
                break label374;
              }
              ((HwRequest)???).reqListener.handleError(-1004, "NullBody");
              this.isWritting.set(false);
            }
            catch (Exception localException1)
            {
              this.isWritting.set(false);
            }
            break;
            this.continueHeartBreak = 0;
            this.lastHeartBreakTime = 0L;
          }
          label374:
          byte[] arrayOfByte = this.dataCodec.encodeC2SData(this.mEp, localException1, arrayOfByte);
          if (arrayOfByte == null)
          {
            this.isWritting.set(false);
            continue;
          }
          if (localException1.retryCount == 0)
          {
            localObject3 = this.connInfo;
            ((ConnReportInfo)localObject3).sentRequestCount += 1;
            localObject3 = this.connInfo;
            ((ConnReportInfo)localObject3).sentDataLen += arrayOfByte.length;
            localException1.sendTime = SystemClock.uptimeMillis();
            long l1 = SystemClock.uptimeMillis();
            localObject3 = this.mOutputStream;
            if (localObject3 != null)
            {
              ((OutputStream)localObject3).write(arrayOfByte);
              ((OutputStream)localObject3).flush();
            }
            i = arrayOfByte.length;
            this.connManager.increaseDataFlowUp(i);
            long l2 = SystemClock.uptimeMillis();
            this.mNetFlowUp += i;
            localException1.reqListener.handleSendEnd(this.connId, getProtoType());
            BdhLogUtil.LogEvent("R", "SendRequest End. CostTrace  reqId: " + localException1.getHwSeq() + " SendComsume:" + localException1.sendComsume + " WriteComsume:" + (l2 - l1) + " ConnID:" + this.connId + " ReqInfo:" + localException1.dumpBaseInfo() + " ContinueHeartBreak:" + this.continueHeartBreak);
            this.isWritting.set(false);
            continue;
          }
          Object localObject3 = this.connInfo;
          ((ConnReportInfo)localObject3).sentRetryCount += 1;
        }
      }
    }
  }
  
  /* Error */
  private int openConn(EndPoint paramEndPoint)
  {
    // Byte code:
    //   0: ldc 249
    //   2: iconst_1
    //   3: new 110	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 493
    //   13: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_1
    //   17: getfield 497	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   20: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 499
    //   26: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: getfield 502	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   33: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: ldc_w 504
    //   39: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 158	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   46: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 506
    //   52: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 145	com/tencent/mobileqq/highway/utils/EndPoint:protoType	I
    //   59: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 508
    //   65: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_0
    //   75: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   78: invokevirtual 281	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   81: ifne +13 -> 94
    //   84: aload_0
    //   85: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   88: invokevirtual 281	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   91: ifeq +26 -> 117
    //   94: aload_0
    //   95: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   98: invokevirtual 281	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   101: ifeq +16 -> 117
    //   104: aload_0
    //   105: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   108: iconst_0
    //   109: invokevirtual 275	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   112: aload_0
    //   113: iconst_2
    //   114: invokespecial 235	com/tencent/mobileqq/highway/conn/TcpConnection:closeConn	(I)V
    //   117: iconst_0
    //   118: istore 9
    //   120: iconst_0
    //   121: istore 7
    //   123: iconst_0
    //   124: istore 10
    //   126: iconst_0
    //   127: istore 6
    //   129: bipush 14
    //   131: istore_2
    //   132: invokestatic 312	android/os/SystemClock:uptimeMillis	()J
    //   135: lstore 16
    //   137: ldc2_w 509
    //   140: lstore 14
    //   142: iload_2
    //   143: istore 4
    //   145: aload_0
    //   146: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   149: ldc2_w 282
    //   152: getstatic 289	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   155: invokevirtual 293	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   158: istore 8
    //   160: iload_2
    //   161: istore 4
    //   163: iload 8
    //   165: ifeq +844 -> 1009
    //   168: iload 9
    //   170: istore 6
    //   172: iload_2
    //   173: istore 4
    //   175: lload 14
    //   177: lstore 12
    //   179: iload 10
    //   181: istore 8
    //   183: iload_2
    //   184: istore_3
    //   185: aload_0
    //   186: new 512	java/net/InetSocketAddress
    //   189: dup
    //   190: aload_1
    //   191: getfield 497	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   194: aload_1
    //   195: getfield 502	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   198: invokespecial 515	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   201: putfield 100	com/tencent/mobileqq/highway/conn/TcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   204: iload 9
    //   206: istore 6
    //   208: iload_2
    //   209: istore 4
    //   211: lload 14
    //   213: lstore 12
    //   215: iload 10
    //   217: istore 8
    //   219: iload_2
    //   220: istore_3
    //   221: aload_0
    //   222: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   225: iconst_0
    //   226: invokevirtual 275	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   229: iload 9
    //   231: istore 6
    //   233: iload_2
    //   234: istore 4
    //   236: lload 14
    //   238: lstore 12
    //   240: iload 10
    //   242: istore 8
    //   244: iload_2
    //   245: istore_3
    //   246: aload_0
    //   247: new 298	java/net/Socket
    //   250: dup
    //   251: invokespecial 516	java/net/Socket:<init>	()V
    //   254: putfield 277	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   257: iload 9
    //   259: istore 6
    //   261: iload_2
    //   262: istore 4
    //   264: lload 14
    //   266: lstore 12
    //   268: iload 10
    //   270: istore 8
    //   272: iload_2
    //   273: istore_3
    //   274: aload_0
    //   275: getfield 277	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   278: iconst_1
    //   279: invokevirtual 519	java/net/Socket:setKeepAlive	(Z)V
    //   282: iload 9
    //   284: istore 6
    //   286: iload_2
    //   287: istore 4
    //   289: lload 14
    //   291: lstore 12
    //   293: iload 10
    //   295: istore 8
    //   297: iload_2
    //   298: istore_3
    //   299: aload_0
    //   300: getfield 277	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   303: iconst_1
    //   304: invokevirtual 522	java/net/Socket:setTcpNoDelay	(Z)V
    //   307: iload 9
    //   309: istore 6
    //   311: iload_2
    //   312: istore 4
    //   314: lload 14
    //   316: lstore 12
    //   318: iload 10
    //   320: istore 8
    //   322: iload_2
    //   323: istore_3
    //   324: aload_0
    //   325: getfield 277	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   328: aload_0
    //   329: getfield 156	com/tencent/mobileqq/highway/conn/TcpConnection:mReadTimeout	I
    //   332: invokevirtual 525	java/net/Socket:setSoTimeout	(I)V
    //   335: iload 9
    //   337: istore 6
    //   339: iload_2
    //   340: istore 4
    //   342: lload 14
    //   344: lstore 12
    //   346: iload 10
    //   348: istore 8
    //   350: iload_2
    //   351: istore_3
    //   352: aload_0
    //   353: getfield 277	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   356: ldc 27
    //   358: invokevirtual 528	java/net/Socket:setSendBufferSize	(I)V
    //   361: iload 9
    //   363: istore 6
    //   365: iload_2
    //   366: istore 4
    //   368: lload 14
    //   370: lstore 12
    //   372: iload 10
    //   374: istore 8
    //   376: iload_2
    //   377: istore_3
    //   378: invokestatic 312	android/os/SystemClock:uptimeMillis	()J
    //   381: lstore 14
    //   383: iload 9
    //   385: istore 6
    //   387: iload_2
    //   388: istore 4
    //   390: lload 14
    //   392: lstore 12
    //   394: iload 10
    //   396: istore 8
    //   398: iload_2
    //   399: istore_3
    //   400: aload_0
    //   401: getfield 277	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   404: aload_0
    //   405: getfield 100	com/tencent/mobileqq/highway/conn/TcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   408: aload_0
    //   409: getfield 104	com/tencent/mobileqq/highway/conn/TcpConnection:mConnTimeOut	I
    //   412: invokevirtual 532	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   415: iload 9
    //   417: istore 6
    //   419: iload_2
    //   420: istore 4
    //   422: lload 14
    //   424: lstore 12
    //   426: iload 10
    //   428: istore 8
    //   430: iload_2
    //   431: istore_3
    //   432: aload_0
    //   433: invokestatic 312	android/os/SystemClock:uptimeMillis	()J
    //   436: lload 14
    //   438: lsub
    //   439: putfield 135	com/tencent/mobileqq/highway/conn/TcpConnection:mRtt	J
    //   442: iload 9
    //   444: istore 6
    //   446: iload_2
    //   447: istore 4
    //   449: lload 14
    //   451: lstore 12
    //   453: iload 10
    //   455: istore 8
    //   457: iload_2
    //   458: istore_3
    //   459: aload_0
    //   460: aload_0
    //   461: getfield 277	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   464: invokevirtual 536	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   467: putfield 272	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   470: iload 9
    //   472: istore 6
    //   474: iload_2
    //   475: istore 4
    //   477: lload 14
    //   479: lstore 12
    //   481: iload 10
    //   483: istore 8
    //   485: iload_2
    //   486: istore_3
    //   487: aload_0
    //   488: new 261	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   491: dup
    //   492: aload_0
    //   493: getfield 277	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   496: aload_0
    //   497: getfield 154	com/tencent/mobileqq/highway/conn/TcpConnection:mReadBufferSize	I
    //   500: ldc_w 538
    //   503: iconst_m1
    //   504: invokespecial 541	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   507: putfield 102	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   510: iload 9
    //   512: istore 6
    //   514: iload_2
    //   515: istore 4
    //   517: lload 14
    //   519: lstore 12
    //   521: iload 10
    //   523: istore 8
    //   525: iload_2
    //   526: istore_3
    //   527: iconst_1
    //   528: aload_0
    //   529: getfield 102	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   532: getfield 265	com/tencent/qphone/base/util/MsfSocketInputBuffer:instream	Ljava/io/InputStream;
    //   535: invokevirtual 266	java/lang/Object:toString	()Ljava/lang/String;
    //   538: invokestatic 270	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   541: iload 9
    //   543: istore 6
    //   545: iload_2
    //   546: istore 4
    //   548: lload 14
    //   550: lstore 12
    //   552: iload 10
    //   554: istore 8
    //   556: iload_2
    //   557: istore_3
    //   558: iconst_1
    //   559: aload_0
    //   560: getfield 272	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   563: invokevirtual 266	java/lang/Object:toString	()Ljava/lang/String;
    //   566: invokestatic 270	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   569: iload 9
    //   571: istore 6
    //   573: iload_2
    //   574: istore 4
    //   576: lload 14
    //   578: lstore 12
    //   580: iload 10
    //   582: istore 8
    //   584: iload_2
    //   585: istore_3
    //   586: aload_0
    //   587: new 15	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread
    //   590: dup
    //   591: aload_0
    //   592: invokespecial 543	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:<init>	(Lcom/tencent/mobileqq/highway/conn/TcpConnection;)V
    //   595: putfield 303	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   598: iload 9
    //   600: istore 6
    //   602: iload_2
    //   603: istore 4
    //   605: lload 14
    //   607: lstore 12
    //   609: iload 10
    //   611: istore 8
    //   613: iload_2
    //   614: istore_3
    //   615: aload_0
    //   616: getfield 108	com/tencent/mobileqq/highway/conn/TcpConnection:isRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   619: iconst_1
    //   620: invokevirtual 275	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   623: iload 9
    //   625: istore 6
    //   627: iload_2
    //   628: istore 4
    //   630: lload 14
    //   632: lstore 12
    //   634: iload 10
    //   636: istore 8
    //   638: iload_2
    //   639: istore_3
    //   640: aload_0
    //   641: getfield 303	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   644: invokevirtual 544	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:start	()V
    //   647: iload 9
    //   649: istore 6
    //   651: iload_2
    //   652: istore 4
    //   654: lload 14
    //   656: lstore 12
    //   658: iload 10
    //   660: istore 8
    //   662: iload_2
    //   663: istore_3
    //   664: aload_0
    //   665: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   668: iconst_1
    //   669: invokevirtual 275	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   672: iconst_1
    //   673: istore 7
    //   675: iconst_1
    //   676: istore 10
    //   678: iconst_1
    //   679: istore 11
    //   681: iconst_1
    //   682: istore 9
    //   684: iload 7
    //   686: istore 6
    //   688: iload_2
    //   689: istore 4
    //   691: lload 14
    //   693: lstore 12
    //   695: iload 11
    //   697: istore 8
    //   699: iload_2
    //   700: istore_3
    //   701: new 110	java/lang/StringBuilder
    //   704: dup
    //   705: ldc_w 546
    //   708: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   711: astore 18
    //   713: iload 7
    //   715: istore 6
    //   717: iload_2
    //   718: istore 4
    //   720: lload 14
    //   722: lstore 12
    //   724: iload 11
    //   726: istore 8
    //   728: iload_2
    //   729: istore_3
    //   730: aload_0
    //   731: getfield 160	com/tencent/mobileqq/highway/conn/TcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   734: getfield 497	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   737: ldc_w 548
    //   740: invokevirtual 554	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   743: ifeq +126 -> 869
    //   746: iload 7
    //   748: istore 6
    //   750: iload_2
    //   751: istore 4
    //   753: lload 14
    //   755: lstore 12
    //   757: iload 11
    //   759: istore 8
    //   761: iload_2
    //   762: istore_3
    //   763: aload_0
    //   764: getfield 277	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   767: invokevirtual 558	java/net/Socket:getRemoteSocketAddress	()Ljava/net/SocketAddress;
    //   770: astore 19
    //   772: aload 19
    //   774: ifnull +95 -> 869
    //   777: iload 7
    //   779: istore 6
    //   781: iload_2
    //   782: istore 4
    //   784: lload 14
    //   786: lstore 12
    //   788: iload 11
    //   790: istore 8
    //   792: iload_2
    //   793: istore_3
    //   794: aload 19
    //   796: instanceof 512
    //   799: ifeq +70 -> 869
    //   802: iload 7
    //   804: istore 6
    //   806: iload_2
    //   807: istore 4
    //   809: lload 14
    //   811: lstore 12
    //   813: iload 11
    //   815: istore 8
    //   817: iload_2
    //   818: istore_3
    //   819: aload 19
    //   821: checkcast 512	java/net/InetSocketAddress
    //   824: invokevirtual 562	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   827: invokevirtual 567	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   830: astore 19
    //   832: iload 7
    //   834: istore 6
    //   836: iload_2
    //   837: istore 4
    //   839: lload 14
    //   841: lstore 12
    //   843: iload 11
    //   845: istore 8
    //   847: iload_2
    //   848: istore_3
    //   849: aload 18
    //   851: ldc_w 569
    //   854: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload 19
    //   859: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: ldc_w 571
    //   865: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: pop
    //   869: iconst_0
    //   870: istore 4
    //   872: iconst_0
    //   873: istore 5
    //   875: iconst_0
    //   876: istore_3
    //   877: iconst_0
    //   878: istore_2
    //   879: iload 7
    //   881: istore 6
    //   883: lload 14
    //   885: lstore 12
    //   887: iload 11
    //   889: istore 8
    //   891: ldc_w 342
    //   894: new 110	java/lang/StringBuilder
    //   897: dup
    //   898: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   901: ldc_w 573
    //   904: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: aload_1
    //   908: getfield 497	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   911: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: ldc_w 499
    //   917: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: aload_1
    //   921: getfield 502	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   924: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   927: ldc_w 504
    //   930: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: aload_0
    //   934: getfield 158	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   937: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   940: ldc_w 575
    //   943: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: lload 14
    //   948: invokevirtual 405	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   951: ldc_w 577
    //   954: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: aload 18
    //   959: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   962: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: ldc_w 579
    //   968: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: aload_0
    //   972: getfield 277	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   975: invokevirtual 582	java/net/Socket:getLocalPort	()I
    //   978: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   981: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   984: invokestatic 355	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   987: iload 10
    //   989: istore 7
    //   991: iload 5
    //   993: istore 4
    //   995: aload_0
    //   996: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   999: invokevirtual 332	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1002: iload_2
    //   1003: istore 4
    //   1005: iload 9
    //   1007: istore 6
    //   1009: aload_0
    //   1010: getfield 140	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1013: iload 6
    //   1015: putfield 585	com/tencent/mobileqq/highway/conn/ConnReportInfo:result	Z
    //   1018: aload_0
    //   1019: getfield 140	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1022: invokestatic 312	android/os/SystemClock:uptimeMillis	()J
    //   1025: aload_0
    //   1026: getfield 140	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1029: getfield 315	com/tencent/mobileqq/highway/conn/ConnReportInfo:connStartTime	J
    //   1032: lsub
    //   1033: putfield 588	com/tencent/mobileqq/highway/conn/ConnReportInfo:connElapseTime	J
    //   1036: invokestatic 312	android/os/SystemClock:uptimeMillis	()J
    //   1039: lstore 12
    //   1041: aload_0
    //   1042: getfield 334	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   1045: ifnull +100 -> 1145
    //   1048: ldc 249
    //   1050: iconst_1
    //   1051: new 110	java/lang/StringBuilder
    //   1054: dup
    //   1055: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1058: ldc_w 590
    //   1061: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: aload_0
    //   1065: getfield 158	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   1068: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1071: ldc_w 592
    //   1074: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: iload 6
    //   1079: invokevirtual 349	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1082: ldc_w 594
    //   1085: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: iload 4
    //   1090: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1093: ldc_w 596
    //   1096: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: lload 12
    //   1101: lload 16
    //   1103: lsub
    //   1104: invokevirtual 405	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1107: ldc_w 598
    //   1110: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1116: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1119: aload_0
    //   1120: getfield 334	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   1123: iload 6
    //   1125: aload_0
    //   1126: getfield 158	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   1129: aload_0
    //   1130: aload_0
    //   1131: getfield 160	com/tencent/mobileqq/highway/conn/TcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   1134: iload 4
    //   1136: aload_0
    //   1137: getfield 140	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1140: invokeinterface 602 7 0
    //   1145: iload 6
    //   1147: ifeq +673 -> 1820
    //   1150: aload_0
    //   1151: getfield 140	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1154: invokestatic 312	android/os/SystemClock:uptimeMillis	()J
    //   1157: putfield 605	com/tencent/mobileqq/highway/conn/ConnReportInfo:connLifeBegin	J
    //   1160: aload_0
    //   1161: getfield 215	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
    //   1164: invokevirtual 608	com/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker:wakeupToWrite	()V
    //   1167: iload 4
    //   1169: ireturn
    //   1170: astore 18
    //   1172: iload 6
    //   1174: istore 8
    //   1176: iload 4
    //   1178: istore_3
    //   1179: aload_0
    //   1180: getfield 152	com/tencent/mobileqq/highway/conn/TcpConnection:connManager	Lcom/tencent/mobileqq/highway/conn/ConnManager;
    //   1183: invokevirtual 611	com/tencent/mobileqq/highway/conn/ConnManager:hasNet	()Z
    //   1186: istore 7
    //   1188: iload 6
    //   1190: istore 8
    //   1192: iload 4
    //   1194: istore_3
    //   1195: ldc_w 342
    //   1198: new 110	java/lang/StringBuilder
    //   1201: dup
    //   1202: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1205: ldc_w 613
    //   1208: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: aload_1
    //   1212: getfield 497	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   1215: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: ldc_w 499
    //   1221: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: aload_1
    //   1225: getfield 502	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   1228: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1231: ldc_w 504
    //   1234: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: aload_0
    //   1238: getfield 158	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   1241: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1244: ldc_w 575
    //   1247: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: lload 12
    //   1252: invokevirtual 405	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1255: ldc_w 615
    //   1258: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: iload 7
    //   1263: invokevirtual 349	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1266: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1269: aload 18
    //   1271: invokestatic 361	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1274: iload 6
    //   1276: istore 8
    //   1278: iload 4
    //   1280: istore_3
    //   1281: aload 18
    //   1283: invokevirtual 616	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1286: invokevirtual 619	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1289: astore 19
    //   1291: iload 7
    //   1293: ifne +78 -> 1371
    //   1296: iconst_3
    //   1297: istore_2
    //   1298: iload 6
    //   1300: istore 7
    //   1302: iload_2
    //   1303: istore 4
    //   1305: aload_0
    //   1306: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1309: invokevirtual 332	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1312: iload_2
    //   1313: istore 4
    //   1315: goto -306 -> 1009
    //   1318: astore 18
    //   1320: ldc_w 342
    //   1323: new 110	java/lang/StringBuilder
    //   1326: dup
    //   1327: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1330: ldc_w 621
    //   1333: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: aload_1
    //   1337: getfield 497	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   1340: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: ldc_w 499
    //   1346: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1349: aload_1
    //   1350: getfield 502	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   1353: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1356: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1359: aload 18
    //   1361: invokestatic 361	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1364: iload 7
    //   1366: istore 6
    //   1368: goto -359 -> 1009
    //   1371: iload 6
    //   1373: istore 8
    //   1375: iload 4
    //   1377: istore_3
    //   1378: aload 19
    //   1380: ldc_w 623
    //   1383: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1386: iconst_m1
    //   1387: if_icmple +8 -> 1395
    //   1390: iconst_1
    //   1391: istore_2
    //   1392: goto -94 -> 1298
    //   1395: iload 6
    //   1397: istore 8
    //   1399: iload 4
    //   1401: istore_3
    //   1402: aload 19
    //   1404: ldc_w 629
    //   1407: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1410: iconst_m1
    //   1411: if_icmple +8 -> 1419
    //   1414: iconst_2
    //   1415: istore_2
    //   1416: goto -118 -> 1298
    //   1419: iload 6
    //   1421: istore 8
    //   1423: iload 4
    //   1425: istore_3
    //   1426: aload 19
    //   1428: ldc_w 631
    //   1431: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1434: iconst_m1
    //   1435: if_icmple +8 -> 1443
    //   1438: iconst_3
    //   1439: istore_2
    //   1440: goto -142 -> 1298
    //   1443: iload 6
    //   1445: istore 8
    //   1447: iload 4
    //   1449: istore_3
    //   1450: aload 19
    //   1452: ldc_w 633
    //   1455: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1458: iconst_m1
    //   1459: if_icmple +8 -> 1467
    //   1462: iconst_4
    //   1463: istore_2
    //   1464: goto -166 -> 1298
    //   1467: iload 6
    //   1469: istore 8
    //   1471: iload 4
    //   1473: istore_3
    //   1474: aload 19
    //   1476: ldc_w 635
    //   1479: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1482: iconst_m1
    //   1483: if_icmple +8 -> 1491
    //   1486: iconst_5
    //   1487: istore_2
    //   1488: goto -190 -> 1298
    //   1491: iload 6
    //   1493: istore 8
    //   1495: iload 4
    //   1497: istore_3
    //   1498: aload 19
    //   1500: ldc_w 637
    //   1503: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1506: iconst_m1
    //   1507: if_icmple +9 -> 1516
    //   1510: bipush 6
    //   1512: istore_2
    //   1513: goto -215 -> 1298
    //   1516: iload 6
    //   1518: istore 8
    //   1520: iload 4
    //   1522: istore_3
    //   1523: aload 19
    //   1525: ldc_w 639
    //   1528: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1531: iconst_m1
    //   1532: if_icmpgt +298 -> 1830
    //   1535: iload 6
    //   1537: istore 8
    //   1539: iload 4
    //   1541: istore_3
    //   1542: aload 19
    //   1544: ldc_w 641
    //   1547: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1550: iconst_m1
    //   1551: if_icmple +6 -> 1557
    //   1554: goto +276 -> 1830
    //   1557: iload 6
    //   1559: istore 8
    //   1561: iload 4
    //   1563: istore_3
    //   1564: aload 19
    //   1566: ldc_w 643
    //   1569: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1572: iconst_m1
    //   1573: if_icmple +9 -> 1582
    //   1576: bipush 8
    //   1578: istore_2
    //   1579: goto -281 -> 1298
    //   1582: iload 6
    //   1584: istore 8
    //   1586: iload 4
    //   1588: istore_3
    //   1589: aload 19
    //   1591: ldc_w 645
    //   1594: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1597: iconst_m1
    //   1598: if_icmple +9 -> 1607
    //   1601: bipush 9
    //   1603: istore_2
    //   1604: goto -306 -> 1298
    //   1607: iload 6
    //   1609: istore 8
    //   1611: iload 4
    //   1613: istore_3
    //   1614: aload 19
    //   1616: ldc_w 647
    //   1619: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1622: iconst_m1
    //   1623: if_icmple +9 -> 1632
    //   1626: bipush 10
    //   1628: istore_2
    //   1629: goto -331 -> 1298
    //   1632: iload 6
    //   1634: istore 8
    //   1636: iload 4
    //   1638: istore_3
    //   1639: aload 19
    //   1641: ldc_w 649
    //   1644: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1647: iconst_m1
    //   1648: if_icmple +9 -> 1657
    //   1651: bipush 11
    //   1653: istore_2
    //   1654: goto -356 -> 1298
    //   1657: iload 6
    //   1659: istore 8
    //   1661: iload 4
    //   1663: istore_3
    //   1664: aload 19
    //   1666: ldc_w 651
    //   1669: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1672: iconst_m1
    //   1673: if_icmple +9 -> 1682
    //   1676: bipush 12
    //   1678: istore_2
    //   1679: goto -381 -> 1298
    //   1682: iload 6
    //   1684: istore 8
    //   1686: iload 4
    //   1688: istore_3
    //   1689: aload 19
    //   1691: ldc_w 653
    //   1694: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1697: iconst_m1
    //   1698: if_icmple +9 -> 1707
    //   1701: bipush 7
    //   1703: istore_2
    //   1704: goto -406 -> 1298
    //   1707: iload 6
    //   1709: istore 8
    //   1711: iload 4
    //   1713: istore_3
    //   1714: aload 19
    //   1716: ldc_w 655
    //   1719: invokevirtual 627	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1722: iconst_m1
    //   1723: if_icmple +9 -> 1732
    //   1726: bipush 13
    //   1728: istore_2
    //   1729: goto -431 -> 1298
    //   1732: bipush 14
    //   1734: istore 4
    //   1736: iload 6
    //   1738: istore 8
    //   1740: iload 4
    //   1742: istore_3
    //   1743: aload 18
    //   1745: invokestatic 661	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1748: astore 18
    //   1750: iload 4
    //   1752: istore_2
    //   1753: iload 6
    //   1755: istore 8
    //   1757: iload 4
    //   1759: istore_3
    //   1760: aload 18
    //   1762: invokevirtual 664	java/lang/String:length	()I
    //   1765: sipush 200
    //   1768: if_icmple -470 -> 1298
    //   1771: iload 6
    //   1773: istore 8
    //   1775: iload 4
    //   1777: istore_3
    //   1778: aload 18
    //   1780: iconst_0
    //   1781: sipush 200
    //   1784: invokevirtual 668	java/lang/String:substring	(II)Ljava/lang/String;
    //   1787: pop
    //   1788: iload 4
    //   1790: istore_2
    //   1791: goto -493 -> 1298
    //   1794: astore 18
    //   1796: iload 8
    //   1798: istore 7
    //   1800: iload_3
    //   1801: istore 4
    //   1803: aload_0
    //   1804: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1807: invokevirtual 332	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1810: iload 8
    //   1812: istore 7
    //   1814: iload_3
    //   1815: istore 4
    //   1817: aload 18
    //   1819: athrow
    //   1820: aload_0
    //   1821: getfield 215	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
    //   1824: invokevirtual 296	com/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker:notifyToQuit	()V
    //   1827: iload 4
    //   1829: ireturn
    //   1830: bipush 7
    //   1832: istore_2
    //   1833: goto -535 -> 1298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1836	0	this	TcpConnection
    //   0	1836	1	paramEndPoint	EndPoint
    //   131	1702	2	i	int
    //   184	1631	3	j	int
    //   143	1685	4	k	int
    //   873	119	5	m	int
    //   127	1645	6	bool1	boolean
    //   121	1692	7	bool2	boolean
    //   158	1653	8	bool3	boolean
    //   118	888	9	bool4	boolean
    //   124	864	10	bool5	boolean
    //   679	209	11	bool6	boolean
    //   177	1074	12	l1	long
    //   140	807	14	l2	long
    //   135	967	16	l3	long
    //   711	247	18	localStringBuilder	StringBuilder
    //   1170	112	18	localThrowable	java.lang.Throwable
    //   1318	426	18	localInterruptedException	InterruptedException
    //   1748	31	18	str	String
    //   1794	24	18	localObject1	Object
    //   770	945	19	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   185	204	1170	java/lang/Throwable
    //   221	229	1170	java/lang/Throwable
    //   246	257	1170	java/lang/Throwable
    //   274	282	1170	java/lang/Throwable
    //   299	307	1170	java/lang/Throwable
    //   324	335	1170	java/lang/Throwable
    //   352	361	1170	java/lang/Throwable
    //   378	383	1170	java/lang/Throwable
    //   400	415	1170	java/lang/Throwable
    //   432	442	1170	java/lang/Throwable
    //   459	470	1170	java/lang/Throwable
    //   487	510	1170	java/lang/Throwable
    //   527	541	1170	java/lang/Throwable
    //   558	569	1170	java/lang/Throwable
    //   586	598	1170	java/lang/Throwable
    //   615	623	1170	java/lang/Throwable
    //   640	647	1170	java/lang/Throwable
    //   664	672	1170	java/lang/Throwable
    //   701	713	1170	java/lang/Throwable
    //   730	746	1170	java/lang/Throwable
    //   763	772	1170	java/lang/Throwable
    //   794	802	1170	java/lang/Throwable
    //   819	832	1170	java/lang/Throwable
    //   849	869	1170	java/lang/Throwable
    //   891	987	1170	java/lang/Throwable
    //   145	160	1318	java/lang/InterruptedException
    //   995	1002	1318	java/lang/InterruptedException
    //   1305	1312	1318	java/lang/InterruptedException
    //   1803	1810	1318	java/lang/InterruptedException
    //   1817	1820	1318	java/lang/InterruptedException
    //   185	204	1794	finally
    //   221	229	1794	finally
    //   246	257	1794	finally
    //   274	282	1794	finally
    //   299	307	1794	finally
    //   324	335	1794	finally
    //   352	361	1794	finally
    //   378	383	1794	finally
    //   400	415	1794	finally
    //   432	442	1794	finally
    //   459	470	1794	finally
    //   487	510	1794	finally
    //   527	541	1794	finally
    //   558	569	1794	finally
    //   586	598	1794	finally
    //   615	623	1794	finally
    //   640	647	1794	finally
    //   664	672	1794	finally
    //   701	713	1794	finally
    //   730	746	1794	finally
    //   763	772	1794	finally
    //   794	802	1794	finally
    //   819	832	1794	finally
    //   849	869	1794	finally
    //   891	987	1794	finally
    //   1179	1188	1794	finally
    //   1195	1274	1794	finally
    //   1281	1291	1794	finally
    //   1378	1390	1794	finally
    //   1402	1414	1794	finally
    //   1426	1438	1794	finally
    //   1450	1462	1794	finally
    //   1474	1486	1794	finally
    //   1498	1510	1794	finally
    //   1523	1535	1794	finally
    //   1542	1554	1794	finally
    //   1564	1576	1794	finally
    //   1589	1601	1794	finally
    //   1614	1626	1794	finally
    //   1639	1651	1794	finally
    //   1664	1676	1794	finally
    //   1689	1701	1794	finally
    //   1714	1726	1794	finally
    //   1743	1750	1794	finally
    //   1760	1771	1794	finally
    //   1778	1788	1794	finally
  }
  
  public static void setExclusiveStream(boolean paramBoolean, String paramString)
  {
    synchronized (BaseApplication.exclusiveStreamList)
    {
      ArrayList localArrayList2 = BaseApplication.exclusiveStreamList;
      if (paramBoolean)
      {
        localArrayList2.add(paramString);
        return;
      }
      localArrayList2.remove(paramString);
    }
  }
  
  public void connect()
  {
    BdhLogUtil.LogEvent("C", "Connect : About to send conn request.");
    this.mConnThread.start();
    this.mConnHandler = new ConnWorker(this.mConnThread.getLooper());
    this.mConnHandler.sendEmptyMessage(1);
    this.connInfo.connStartTime = SystemClock.uptimeMillis();
    this.connInfo.serverIp = this.mEp.host;
    this.connInfo.port = this.mEp.port;
  }
  
  public void disConnect()
  {
    synchronized (this.closeDebug)
    {
      this.closeDebug.append("By : disConnect;");
      closeConn(3);
      return;
    }
  }
  
  public int getConnId()
  {
    return this.connId;
  }
  
  public EndPoint getEndPoint()
  {
    return this.mEp;
  }
  
  public int getProtoType()
  {
    return 1;
  }
  
  public boolean isWritable()
  {
    return (this.isRunning.get()) && (!this.isWritting.get());
  }
  
  public void onDecodeInvalidData(int paramInt)
  {
    QLog.d("BDH_LOG", 1, "C.  ConnId:" + this.connId + " Host:" + this.mEp.host + " Port:" + this.mEp.port + " OnDecodeInvalidData : code : " + paramInt);
    if (this.connListener != null) {
      this.connListener.onRecvInvalidData(this.mEp);
    }
    disConnect();
  }
  
  public void onDecodeSucessfully(List<HwResponse> paramList)
  {
    this.connInfo.recvRespCount = paramList.size();
    this.connManager.onDecodeSucessfully(paramList);
  }
  
  public void onEncodePkgError(HwRequest paramHwRequest, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    HwResponse localHwResponse = new HwResponse();
    localHwResponse.hwSeq = paramHwRequest.getHwSeq();
    localHwResponse.cmd = paramHwRequest.hwCmd;
    localHwResponse.errCode = paramInt;
    localHwResponse.recvTime = SystemClock.uptimeMillis();
    localHwResponse.shouldRetry = false;
    this.connManager.onDecodeSucessfully(localArrayList);
  }
  
  public void setConnectListener(IConnectionListener paramIConnectionListener)
  {
    this.connListener = paramIConnectionListener;
  }
  
  public void setUrgentFlag(boolean paramBoolean)
  {
    this.isUrgent = paramBoolean;
    wakeupChannel();
  }
  
  public void wakeupChannel()
  {
    ConnWorker localConnWorker = this.mConnHandler;
    if ((this.isRunning.get()) && (localConnWorker != null)) {
      localConnWorker.wakeupToWrite();
    }
  }
  
  class ConnWorker
    extends Handler
  {
    public static final int CONN = 1;
    public static final int QUIT = 3;
    public static final int SEND = 2;
    
    public ConnWorker(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1) {
        TcpConnection.this.openConn(TcpConnection.this.mEp);
      }
      do
      {
        return;
        if (paramMessage.what == 2)
        {
          TcpConnection.this.doSendData();
          return;
        }
      } while (paramMessage.what != 3);
      TcpConnection.this.mConnThread.quit();
      TcpConnection.access$1102(TcpConnection.this, null);
      TcpConnection.access$1202(TcpConnection.this, null);
    }
    
    public void notifyToQuit()
    {
      if (TcpConnection.this.mConnHandler != null) {
        TcpConnection.this.mConnHandler.sendEmptyMessage(3);
      }
    }
    
    public void wakeupToWrite()
    {
      ConnWorker localConnWorker = TcpConnection.this.mConnHandler;
      if (localConnWorker != null) {
        localConnWorker.sendEmptyMessage(2);
      }
    }
  }
  
  class ReadThread
    extends Thread
  {
    ReadThread() {}
    
    public void run()
    {
      while (TcpConnection.this.isRunning.get()) {
        try
        {
          ??? = TcpConnection.this.mInputBuffer;
          if (??? == null) {
            return;
          }
          while (!((MsfSocketInputBuffer)???).isDataAvailable(30000)) {
            if (!TcpConnection.this.isRunning.get()) {
              return;
            }
          }
          if (TcpConnection.this.isRunning.get())
          {
            int i = ((MsfSocketInputBuffer)???).getBufferlen();
            ConnReportInfo localConnReportInfo = TcpConnection.this.connInfo;
            localConnReportInfo.receiveDataLen += i;
            TcpConnection.this.connManager.increaseDataFlowDw(i);
            TcpConnection.access$402(TcpConnection.this, TcpConnection.this.mNetFlowDw + i);
            TcpConnection.this.dataCodec.onRecvData((MsfSocketInputBuffer)???);
            ((MsfSocketInputBuffer)???).reset();
          }
        }
        catch (Exception localException)
        {
          BdhLogUtil.LogException("C", "ReadThread Error.", localException);
          synchronized (TcpConnection.this.closeDebug)
          {
            TcpConnection.this.closeDebug.append("By ReadThread : " + localException.getMessage() + ";");
            TcpConnection.this.closeConn(1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.TcpConnection
 * JD-Core Version:    0.7.0.1
 */