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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class SyncTcpConnection
  implements IConnection, IProtocolCodecListener
{
  public static final int DEFAULT_READ_BUF_SIZE = 32768;
  public static final int DEFAULT_READ_TIMEOUT = 30000;
  public static final int DEFAULT_SEND_BUF_SIZE = 524288;
  public static final int HEARTBREAK_DELTA = 20000;
  private static final int MAX_CONTINUE_HREAT = 2;
  private StringBuilder closeDebug = new StringBuilder("ConnTag:");
  private int connId;
  private ConnReportInfo connInfo = null;
  private IConnectionListener connListener;
  private ConnManager connManager;
  private HandlerThread connThread;
  private int connType = 1;
  private int continueHeartBreak = 0;
  private TcpProtocolDataCodec dataCodec;
  private AtomicBoolean isConn = new AtomicBoolean(false);
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private volatile boolean isUrgent = false;
  private AtomicBoolean isWritting = new AtomicBoolean(false);
  private long lastHeartBreakTime = 0L;
  private ReentrantLock lock = new ReentrantLock();
  private ConnWorker mConnHandler;
  private EndPoint mEp;
  private MsfSocketInputBuffer mInputBuffer = null;
  private OutputStream mOutputStream;
  private int mReadBufferSize;
  private int mReadTimeout;
  private Socket mSocket;
  private int protoType = 1;
  private ReadThread readThread;
  private InetSocketAddress serverAddress = null;
  private AtomicBoolean shouldCloseConn = new AtomicBoolean(false);
  
  public SyncTcpConnection(ConnManager paramConnManager, int paramInt1, int paramInt2, int paramInt3, int paramInt4, EndPoint paramEndPoint, ConnReportInfo paramConnReportInfo)
  {
    if (paramEndPoint.protoType == 2) {}
    for (this.dataCodec = new HttpProtocolDataCodec();; this.dataCodec = new TcpProtocolDataCodec())
    {
      this.protoType = paramEndPoint.protoType;
      this.connManager = paramConnManager;
      this.mReadBufferSize = paramInt1;
      this.mReadTimeout = paramInt2;
      this.connId = paramInt3;
      this.mEp = paramEndPoint;
      this.connInfo = paramConnReportInfo;
      this.connType = paramInt4;
      this.connThread = new HandlerThread("BDH-CONN" + paramInt3);
      this.dataCodec.setProtocolCodecListener(this);
      return;
    }
  }
  
  /* Error */
  private void closeConn(int paramInt)
  {
    // Byte code:
    //   0: ldc 208
    //   2: iconst_1
    //   3: new 101	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   10: ldc 210
    //   12: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: getfield 132	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connId	I
    //   19: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc 212
    //   24: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_1
    //   28: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_0
    //   38: getfield 95	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   41: ifnull +26 -> 67
    //   44: aload_0
    //   45: getfield 95	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   48: getfield 224	com/tencent/qphone/base/util/MsfSocketInputBuffer:instream	Ljava/io/InputStream;
    //   51: astore 6
    //   53: aload 6
    //   55: ifnull +12 -> 67
    //   58: iconst_0
    //   59: aload 6
    //   61: invokevirtual 225	java/lang/Object:toString	()Ljava/lang/String;
    //   64: invokestatic 229	com/tencent/mobileqq/highway/conn/SyncTcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   67: aload_0
    //   68: getfield 231	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   71: ifnull +14 -> 85
    //   74: iconst_0
    //   75: aload_0
    //   76: getfield 231	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   79: invokevirtual 225	java/lang/Object:toString	()Ljava/lang/String;
    //   82: invokestatic 229	com/tencent/mobileqq/highway/conn/SyncTcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   85: aload_0
    //   86: getfield 99	com/tencent/mobileqq/highway/conn/SyncTcpConnection:isRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   89: iconst_0
    //   90: invokevirtual 234	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   93: iconst_0
    //   94: istore 4
    //   96: iconst_0
    //   97: istore_3
    //   98: iload 4
    //   100: istore_2
    //   101: aload_0
    //   102: getfield 236	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   105: ifnull +256 -> 361
    //   108: iload 4
    //   110: istore_2
    //   111: aload_0
    //   112: getfield 85	com/tencent/mobileqq/highway/conn/SyncTcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   115: invokevirtual 240	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   118: ifne +4 -> 122
    //   121: return
    //   122: iload 4
    //   124: istore_2
    //   125: aload_0
    //   126: getfield 78	com/tencent/mobileqq/highway/conn/SyncTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   129: ldc2_w 241
    //   132: getstatic 248	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   135: invokevirtual 252	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   138: istore 5
    //   140: iload 5
    //   142: ifeq +198 -> 340
    //   145: aload_0
    //   146: getfield 173	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/SyncTcpConnection$ConnWorker;
    //   149: ifnull +10 -> 159
    //   152: aload_0
    //   153: getfield 173	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/SyncTcpConnection$ConnWorker;
    //   156: invokevirtual 255	com/tencent/mobileqq/highway/conn/SyncTcpConnection$ConnWorker:notifyToQuit	()V
    //   159: aload_0
    //   160: aconst_null
    //   161: putfield 95	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   164: aload_0
    //   165: aconst_null
    //   166: putfield 231	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   169: aload_0
    //   170: getfield 236	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   173: ifnull +10 -> 183
    //   176: aload_0
    //   177: getfield 236	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   180: invokevirtual 260	java/net/Socket:close	()V
    //   183: aload_0
    //   184: getfield 85	com/tencent/mobileqq/highway/conn/SyncTcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   187: iconst_0
    //   188: invokevirtual 234	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   191: aload_0
    //   192: aconst_null
    //   193: putfield 236	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 262	com/tencent/mobileqq/highway/conn/SyncTcpConnection:readThread	Lcom/tencent/mobileqq/highway/conn/SyncTcpConnection$ReadThread;
    //   201: aload_0
    //   202: getfield 116	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   205: iconst_1
    //   206: putfield 267	com/tencent/mobileqq/highway/conn/ConnReportInfo:finished	Z
    //   209: aload_0
    //   210: getfield 116	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   213: invokestatic 273	android/os/SystemClock:uptimeMillis	()J
    //   216: aload_0
    //   217: getfield 116	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   220: getfield 276	com/tencent/mobileqq/highway/conn/ConnReportInfo:connStartTime	J
    //   223: lsub
    //   224: putfield 279	com/tencent/mobileqq/highway/conn/ConnReportInfo:connLifeLong	J
    //   227: aload_0
    //   228: getfield 281	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   231: ifnull +22 -> 253
    //   234: aload_0
    //   235: getfield 281	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   238: aload_0
    //   239: getfield 132	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connId	I
    //   242: aload_0
    //   243: invokeinterface 287 3 0
    //   248: aload_0
    //   249: aconst_null
    //   250: putfield 281	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   253: iconst_1
    //   254: istore_2
    //   255: iconst_1
    //   256: istore_3
    //   257: aload_0
    //   258: getfield 78	com/tencent/mobileqq/highway/conn/SyncTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   261: invokevirtual 290	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   264: iload_3
    //   265: istore_2
    //   266: ldc_w 292
    //   269: new 101	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 294
    //   279: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_0
    //   283: getfield 132	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connId	I
    //   286: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   289: ldc_w 296
    //   292: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: iload_2
    //   296: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   299: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 305	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: return
    //   306: astore 6
    //   308: iload 4
    //   310: istore_2
    //   311: aload_0
    //   312: getfield 78	com/tencent/mobileqq/highway/conn/SyncTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   315: invokevirtual 290	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   318: iload 4
    //   320: istore_2
    //   321: aload 6
    //   323: athrow
    //   324: astore 6
    //   326: ldc_w 292
    //   329: ldc_w 307
    //   332: aload 6
    //   334: invokestatic 311	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   337: goto -71 -> 266
    //   340: iload 4
    //   342: istore_2
    //   343: aload_0
    //   344: getfield 87	com/tencent/mobileqq/highway/conn/SyncTcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   347: iconst_1
    //   348: invokevirtual 234	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   351: iload_3
    //   352: istore_2
    //   353: goto -87 -> 266
    //   356: astore 6
    //   358: goto -175 -> 183
    //   361: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	SyncTcpConnection
    //   0	362	1	paramInt	int
    //   100	253	2	bool1	boolean
    //   97	255	3	bool2	boolean
    //   94	247	4	bool3	boolean
    //   138	3	5	bool4	boolean
    //   51	9	6	localInputStream	java.io.InputStream
    //   306	16	6	localObject	Object
    //   324	9	6	localInterruptedException	java.lang.InterruptedException
    //   356	1	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   145	159	306	finally
    //   159	169	306	finally
    //   169	183	306	finally
    //   183	253	306	finally
    //   101	108	324	java/lang/InterruptedException
    //   111	121	324	java/lang/InterruptedException
    //   125	140	324	java/lang/InterruptedException
    //   257	264	324	java/lang/InterruptedException
    //   311	318	324	java/lang/InterruptedException
    //   321	324	324	java/lang/InterruptedException
    //   343	351	324	java/lang/InterruptedException
    //   169	183	356	java/lang/Exception
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
        HwRequest localHwRequest = this.connManager.pullNextRequest(this, this.isUrgent);
        if (localHwRequest == null)
        {
          this.isWritting.set(false);
          if ((SystemClock.uptimeMillis() - this.lastHeartBreakTime <= 60000L) || (this.connType == 2)) {
            break label20;
          }
          this.lastHeartBreakTime = SystemClock.uptimeMillis();
          ??? = this.connManager;
          int i = this.connId;
          if (this.continueHeartBreak == 0)
          {
            bool = true;
            label97:
            ((ConnManager)???).onConnectionIdle(i, bool);
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        boolean bool;
        BdhLogUtil.LogException("C", "SendThread Error.", localException2);
        label301:
        Object localObject2;
        synchronized (this.closeDebug)
        {
          this.closeDebug.append("By SendWorker :" + localException2.getMessage() + ";");
          closeConn(2);
          continue;
          bool = false;
          break label97;
          this.isWritting.set(true);
          localException2.sentEndpoint = this.mEp;
          if ((localException2 instanceof RequestHeartBreak))
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
              ??? = localException2.getRequestBody();
              if ((??? != null) || (!localException2.hasRequestBody())) {
                break label301;
              }
              localException2.reqListener.handleError(-1004);
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
          byte[] arrayOfByte = this.dataCodec.encodeC2SData(this.mEp, localException2, localException1);
          if (arrayOfByte == null)
          {
            this.isWritting.set(false);
            continue;
          }
          if (localException2.retryCount == 0)
          {
            localObject2 = this.connInfo;
            ((ConnReportInfo)localObject2).sentRequestCount += 1;
          }
          for (;;)
          {
            localObject2 = this.connInfo;
            ((ConnReportInfo)localObject2).sentDataLen += arrayOfByte.length;
            localException2.sendTime = SystemClock.uptimeMillis();
            StringBuilder localStringBuilder = new StringBuilder().append(localException2.dumpBaseInfo()).append(" Step:SendRequest In Channel ").append(this.connId).append(" CHNL:");
            if (this.protoType != 2) {
              break label623;
            }
            localObject2 = "Http";
            BdhLogUtil.LogEvent("R", (String)localObject2 + " ContinueHeartBreak:" + this.continueHeartBreak);
            localObject2 = this.mOutputStream;
            if (localObject2 != null)
            {
              ((OutputStream)localObject2).write(arrayOfByte);
              ((OutputStream)localObject2).flush();
            }
            this.connManager.increaseDataFlowUp(arrayOfByte.length);
            HwServlet.reportTraffic4PicUp(this.connManager.engine.app, this.connInfo.serverIp, this.connInfo.port, true, arrayOfByte.length);
            localException2.reqListener.handleSendEnd(this.connId, this.protoType, this.connType);
            BdhLogUtil.LogEvent("R", "SendRequest End. reqId: " + localException2.getHwSeq() + " SendComsume:" + localException2.sendComsume);
            if (this.protoType != 1) {
              break;
            }
            this.isWritting.set(false);
            break;
            localObject2 = this.connInfo;
            ((ConnReportInfo)localObject2).sentRetryCount += 1;
          }
          label623:
          localObject2 = "TCP";
        }
      }
    }
  }
  
  /* Error */
  private int openConn(EndPoint paramEndPoint)
  {
    // Byte code:
    //   0: ldc 208
    //   2: iconst_1
    //   3: new 101	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 450
    //   13: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_1
    //   17: getfield 453	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   20: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 455
    //   26: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: getfield 456	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   33: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: ldc_w 458
    //   39: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 132	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connId	I
    //   46: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 460
    //   52: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 119	com/tencent/mobileqq/highway/utils/EndPoint:protoType	I
    //   59: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 462
    //   65: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_0
    //   69: getfield 91	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connType	I
    //   72: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_0
    //   82: getfield 87	com/tencent/mobileqq/highway/conn/SyncTcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   85: invokevirtual 240	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   88: ifne +13 -> 101
    //   91: aload_0
    //   92: getfield 85	com/tencent/mobileqq/highway/conn/SyncTcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   95: invokevirtual 240	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   98: ifeq +26 -> 124
    //   101: aload_0
    //   102: getfield 87	com/tencent/mobileqq/highway/conn/SyncTcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   105: invokevirtual 240	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   108: ifeq +16 -> 124
    //   111: aload_0
    //   112: getfield 87	com/tencent/mobileqq/highway/conn/SyncTcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   115: iconst_0
    //   116: invokevirtual 234	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   119: aload_0
    //   120: iconst_2
    //   121: invokespecial 189	com/tencent/mobileqq/highway/conn/SyncTcpConnection:closeConn	(I)V
    //   124: iconst_0
    //   125: istore 9
    //   127: iconst_0
    //   128: istore 7
    //   130: iconst_0
    //   131: istore 10
    //   133: iconst_0
    //   134: istore 6
    //   136: bipush 14
    //   138: istore_2
    //   139: invokestatic 273	android/os/SystemClock:uptimeMillis	()J
    //   142: lstore 16
    //   144: ldc2_w 463
    //   147: lstore 14
    //   149: iload_2
    //   150: istore 4
    //   152: aload_0
    //   153: getfield 78	com/tencent/mobileqq/highway/conn/SyncTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   156: ldc2_w 241
    //   159: getstatic 248	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   162: invokevirtual 252	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   165: istore 8
    //   167: iload_2
    //   168: istore 4
    //   170: iload 8
    //   172: ifeq +841 -> 1013
    //   175: iload 9
    //   177: istore 6
    //   179: iload_2
    //   180: istore 4
    //   182: lload 14
    //   184: lstore 12
    //   186: iload 10
    //   188: istore 8
    //   190: iload_2
    //   191: istore_3
    //   192: aload_0
    //   193: new 466	java/net/InetSocketAddress
    //   196: dup
    //   197: aload_1
    //   198: getfield 453	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   201: aload_1
    //   202: getfield 456	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   205: invokespecial 469	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   208: putfield 93	com/tencent/mobileqq/highway/conn/SyncTcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   211: iload 9
    //   213: istore 6
    //   215: iload_2
    //   216: istore 4
    //   218: lload 14
    //   220: lstore 12
    //   222: iload 10
    //   224: istore 8
    //   226: iload_2
    //   227: istore_3
    //   228: aload_0
    //   229: getfield 85	com/tencent/mobileqq/highway/conn/SyncTcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   232: iconst_0
    //   233: invokevirtual 234	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   236: iload 9
    //   238: istore 6
    //   240: iload_2
    //   241: istore 4
    //   243: lload 14
    //   245: lstore 12
    //   247: iload 10
    //   249: istore 8
    //   251: iload_2
    //   252: istore_3
    //   253: aload_0
    //   254: new 257	java/net/Socket
    //   257: dup
    //   258: invokespecial 470	java/net/Socket:<init>	()V
    //   261: putfield 236	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   264: iload 9
    //   266: istore 6
    //   268: iload_2
    //   269: istore 4
    //   271: lload 14
    //   273: lstore 12
    //   275: iload 10
    //   277: istore 8
    //   279: iload_2
    //   280: istore_3
    //   281: aload_0
    //   282: getfield 236	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   285: iconst_1
    //   286: invokevirtual 473	java/net/Socket:setKeepAlive	(Z)V
    //   289: iload 9
    //   291: istore 6
    //   293: iload_2
    //   294: istore 4
    //   296: lload 14
    //   298: lstore 12
    //   300: iload 10
    //   302: istore 8
    //   304: iload_2
    //   305: istore_3
    //   306: aload_0
    //   307: getfield 236	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   310: iconst_1
    //   311: invokevirtual 476	java/net/Socket:setTcpNoDelay	(Z)V
    //   314: iload 9
    //   316: istore 6
    //   318: iload_2
    //   319: istore 4
    //   321: lload 14
    //   323: lstore 12
    //   325: iload 10
    //   327: istore 8
    //   329: iload_2
    //   330: istore_3
    //   331: aload_0
    //   332: getfield 236	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   335: aload_0
    //   336: getfield 130	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mReadTimeout	I
    //   339: invokevirtual 479	java/net/Socket:setSoTimeout	(I)V
    //   342: iload 9
    //   344: istore 6
    //   346: iload_2
    //   347: istore 4
    //   349: lload 14
    //   351: lstore 12
    //   353: iload 10
    //   355: istore 8
    //   357: iload_2
    //   358: istore_3
    //   359: aload_0
    //   360: getfield 236	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   363: ldc 21
    //   365: invokevirtual 482	java/net/Socket:setSendBufferSize	(I)V
    //   368: iload 9
    //   370: istore 6
    //   372: iload_2
    //   373: istore 4
    //   375: lload 14
    //   377: lstore 12
    //   379: iload 10
    //   381: istore 8
    //   383: iload_2
    //   384: istore_3
    //   385: invokestatic 273	android/os/SystemClock:uptimeMillis	()J
    //   388: lstore 14
    //   390: iload 9
    //   392: istore 6
    //   394: iload_2
    //   395: istore 4
    //   397: lload 14
    //   399: lstore 12
    //   401: iload 10
    //   403: istore 8
    //   405: iload_2
    //   406: istore_3
    //   407: aload_0
    //   408: getfield 236	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   411: aload_0
    //   412: getfield 93	com/tencent/mobileqq/highway/conn/SyncTcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   415: sipush 30000
    //   418: invokevirtual 486	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   421: iload 9
    //   423: istore 6
    //   425: iload_2
    //   426: istore 4
    //   428: lload 14
    //   430: lstore 12
    //   432: iload 10
    //   434: istore 8
    //   436: iload_2
    //   437: istore_3
    //   438: invokestatic 273	android/os/SystemClock:uptimeMillis	()J
    //   441: lload 14
    //   443: lsub
    //   444: lstore 14
    //   446: iload 9
    //   448: istore 6
    //   450: iload_2
    //   451: istore 4
    //   453: lload 14
    //   455: lstore 12
    //   457: iload 10
    //   459: istore 8
    //   461: iload_2
    //   462: istore_3
    //   463: aload_0
    //   464: aload_0
    //   465: getfield 236	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   468: invokevirtual 490	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   471: putfield 231	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   474: iload 9
    //   476: istore 6
    //   478: iload_2
    //   479: istore 4
    //   481: lload 14
    //   483: lstore 12
    //   485: iload 10
    //   487: istore 8
    //   489: iload_2
    //   490: istore_3
    //   491: aload_0
    //   492: new 220	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   495: dup
    //   496: aload_0
    //   497: getfield 236	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   500: aload_0
    //   501: getfield 128	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mReadBufferSize	I
    //   504: ldc_w 492
    //   507: iconst_m1
    //   508: invokespecial 495	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   511: putfield 95	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   514: iload 9
    //   516: istore 6
    //   518: iload_2
    //   519: istore 4
    //   521: lload 14
    //   523: lstore 12
    //   525: iload 10
    //   527: istore 8
    //   529: iload_2
    //   530: istore_3
    //   531: iconst_1
    //   532: aload_0
    //   533: getfield 95	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   536: getfield 224	com/tencent/qphone/base/util/MsfSocketInputBuffer:instream	Ljava/io/InputStream;
    //   539: invokevirtual 225	java/lang/Object:toString	()Ljava/lang/String;
    //   542: invokestatic 229	com/tencent/mobileqq/highway/conn/SyncTcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   545: iload 9
    //   547: istore 6
    //   549: iload_2
    //   550: istore 4
    //   552: lload 14
    //   554: lstore 12
    //   556: iload 10
    //   558: istore 8
    //   560: iload_2
    //   561: istore_3
    //   562: iconst_1
    //   563: aload_0
    //   564: getfield 231	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   567: invokevirtual 225	java/lang/Object:toString	()Ljava/lang/String;
    //   570: invokestatic 229	com/tencent/mobileqq/highway/conn/SyncTcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   573: iload 9
    //   575: istore 6
    //   577: iload_2
    //   578: istore 4
    //   580: lload 14
    //   582: lstore 12
    //   584: iload 10
    //   586: istore 8
    //   588: iload_2
    //   589: istore_3
    //   590: aload_0
    //   591: new 13	com/tencent/mobileqq/highway/conn/SyncTcpConnection$ReadThread
    //   594: dup
    //   595: aload_0
    //   596: invokespecial 497	com/tencent/mobileqq/highway/conn/SyncTcpConnection$ReadThread:<init>	(Lcom/tencent/mobileqq/highway/conn/SyncTcpConnection;)V
    //   599: putfield 262	com/tencent/mobileqq/highway/conn/SyncTcpConnection:readThread	Lcom/tencent/mobileqq/highway/conn/SyncTcpConnection$ReadThread;
    //   602: iload 9
    //   604: istore 6
    //   606: iload_2
    //   607: istore 4
    //   609: lload 14
    //   611: lstore 12
    //   613: iload 10
    //   615: istore 8
    //   617: iload_2
    //   618: istore_3
    //   619: aload_0
    //   620: getfield 99	com/tencent/mobileqq/highway/conn/SyncTcpConnection:isRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   623: iconst_1
    //   624: invokevirtual 234	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   627: iload 9
    //   629: istore 6
    //   631: iload_2
    //   632: istore 4
    //   634: lload 14
    //   636: lstore 12
    //   638: iload 10
    //   640: istore 8
    //   642: iload_2
    //   643: istore_3
    //   644: aload_0
    //   645: getfield 262	com/tencent/mobileqq/highway/conn/SyncTcpConnection:readThread	Lcom/tencent/mobileqq/highway/conn/SyncTcpConnection$ReadThread;
    //   648: invokevirtual 500	com/tencent/mobileqq/highway/conn/SyncTcpConnection$ReadThread:start	()V
    //   651: iload 9
    //   653: istore 6
    //   655: iload_2
    //   656: istore 4
    //   658: lload 14
    //   660: lstore 12
    //   662: iload 10
    //   664: istore 8
    //   666: iload_2
    //   667: istore_3
    //   668: aload_0
    //   669: getfield 85	com/tencent/mobileqq/highway/conn/SyncTcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   672: iconst_1
    //   673: invokevirtual 234	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   676: iconst_1
    //   677: istore 7
    //   679: iconst_1
    //   680: istore 10
    //   682: iconst_1
    //   683: istore 11
    //   685: iconst_1
    //   686: istore 9
    //   688: iload 7
    //   690: istore 6
    //   692: iload_2
    //   693: istore 4
    //   695: lload 14
    //   697: lstore 12
    //   699: iload 11
    //   701: istore 8
    //   703: iload_2
    //   704: istore_3
    //   705: new 101	java/lang/StringBuilder
    //   708: dup
    //   709: ldc_w 502
    //   712: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   715: astore 18
    //   717: iload 7
    //   719: istore 6
    //   721: iload_2
    //   722: istore 4
    //   724: lload 14
    //   726: lstore 12
    //   728: iload 11
    //   730: istore 8
    //   732: iload_2
    //   733: istore_3
    //   734: aload_0
    //   735: getfield 134	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   738: getfield 453	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   741: ldc_w 504
    //   744: invokevirtual 510	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   747: ifeq +126 -> 873
    //   750: iload 7
    //   752: istore 6
    //   754: iload_2
    //   755: istore 4
    //   757: lload 14
    //   759: lstore 12
    //   761: iload 11
    //   763: istore 8
    //   765: iload_2
    //   766: istore_3
    //   767: aload_0
    //   768: getfield 236	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   771: invokevirtual 514	java/net/Socket:getRemoteSocketAddress	()Ljava/net/SocketAddress;
    //   774: astore 19
    //   776: aload 19
    //   778: ifnull +95 -> 873
    //   781: iload 7
    //   783: istore 6
    //   785: iload_2
    //   786: istore 4
    //   788: lload 14
    //   790: lstore 12
    //   792: iload 11
    //   794: istore 8
    //   796: iload_2
    //   797: istore_3
    //   798: aload 19
    //   800: instanceof 466
    //   803: ifeq +70 -> 873
    //   806: iload 7
    //   808: istore 6
    //   810: iload_2
    //   811: istore 4
    //   813: lload 14
    //   815: lstore 12
    //   817: iload 11
    //   819: istore 8
    //   821: iload_2
    //   822: istore_3
    //   823: aload 19
    //   825: checkcast 466	java/net/InetSocketAddress
    //   828: invokevirtual 518	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   831: invokevirtual 523	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   834: astore 19
    //   836: iload 7
    //   838: istore 6
    //   840: iload_2
    //   841: istore 4
    //   843: lload 14
    //   845: lstore 12
    //   847: iload 11
    //   849: istore 8
    //   851: iload_2
    //   852: istore_3
    //   853: aload 18
    //   855: ldc_w 525
    //   858: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: aload 19
    //   863: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: ldc_w 527
    //   869: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: pop
    //   873: iconst_0
    //   874: istore 4
    //   876: iconst_0
    //   877: istore 5
    //   879: iconst_0
    //   880: istore_3
    //   881: iconst_0
    //   882: istore_2
    //   883: iload 7
    //   885: istore 6
    //   887: lload 14
    //   889: lstore 12
    //   891: iload 11
    //   893: istore 8
    //   895: ldc_w 292
    //   898: new 101	java/lang/StringBuilder
    //   901: dup
    //   902: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   905: ldc_w 529
    //   908: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: aload_1
    //   912: getfield 453	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   915: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: ldc_w 455
    //   921: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: aload_1
    //   925: getfield 456	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   928: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   931: ldc_w 458
    //   934: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: aload_0
    //   938: getfield 132	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connId	I
    //   941: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   944: ldc_w 531
    //   947: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: lload 14
    //   952: invokevirtual 441	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   955: ldc_w 533
    //   958: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: aload 18
    //   963: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: ldc_w 535
    //   972: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: aload_0
    //   976: getfield 236	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   979: invokevirtual 538	java/net/Socket:getLocalPort	()I
    //   982: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   985: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokestatic 305	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   991: iload 10
    //   993: istore 7
    //   995: iload 5
    //   997: istore 4
    //   999: aload_0
    //   1000: getfield 78	com/tencent/mobileqq/highway/conn/SyncTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1003: invokevirtual 290	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1006: iload_2
    //   1007: istore 4
    //   1009: iload 9
    //   1011: istore 6
    //   1013: aload_0
    //   1014: getfield 116	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1017: iload 6
    //   1019: putfield 541	com/tencent/mobileqq/highway/conn/ConnReportInfo:result	Z
    //   1022: aload_0
    //   1023: getfield 116	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1026: invokestatic 273	android/os/SystemClock:uptimeMillis	()J
    //   1029: aload_0
    //   1030: getfield 116	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1033: getfield 276	com/tencent/mobileqq/highway/conn/ConnReportInfo:connStartTime	J
    //   1036: lsub
    //   1037: putfield 544	com/tencent/mobileqq/highway/conn/ConnReportInfo:connElapseTime	J
    //   1040: invokestatic 273	android/os/SystemClock:uptimeMillis	()J
    //   1043: lstore 12
    //   1045: aload_0
    //   1046: getfield 281	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   1049: ifnull +100 -> 1149
    //   1052: ldc 208
    //   1054: iconst_1
    //   1055: new 101	java/lang/StringBuilder
    //   1058: dup
    //   1059: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   1062: ldc_w 546
    //   1065: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: aload_0
    //   1069: getfield 132	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connId	I
    //   1072: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1075: ldc_w 548
    //   1078: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: iload 6
    //   1083: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1086: ldc_w 550
    //   1089: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: iload 4
    //   1094: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1097: ldc_w 552
    //   1100: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: lload 12
    //   1105: lload 16
    //   1107: lsub
    //   1108: invokevirtual 441	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1111: ldc_w 554
    //   1114: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1120: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1123: aload_0
    //   1124: getfield 281	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   1127: iload 6
    //   1129: aload_0
    //   1130: getfield 132	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connId	I
    //   1133: aload_0
    //   1134: aload_0
    //   1135: getfield 134	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   1138: iload 4
    //   1140: aload_0
    //   1141: getfield 116	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1144: invokeinterface 558 7 0
    //   1149: iload 6
    //   1151: ifeq +673 -> 1824
    //   1154: aload_0
    //   1155: getfield 116	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1158: invokestatic 273	android/os/SystemClock:uptimeMillis	()J
    //   1161: putfield 561	com/tencent/mobileqq/highway/conn/ConnReportInfo:connLifeBegin	J
    //   1164: aload_0
    //   1165: getfield 173	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/SyncTcpConnection$ConnWorker;
    //   1168: invokevirtual 564	com/tencent/mobileqq/highway/conn/SyncTcpConnection$ConnWorker:wakeupToWrite	()V
    //   1171: iload 4
    //   1173: ireturn
    //   1174: astore 18
    //   1176: iload 6
    //   1178: istore 8
    //   1180: iload 4
    //   1182: istore_3
    //   1183: aload_0
    //   1184: getfield 126	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connManager	Lcom/tencent/mobileqq/highway/conn/ConnManager;
    //   1187: invokevirtual 567	com/tencent/mobileqq/highway/conn/ConnManager:hasNet	()Z
    //   1190: istore 7
    //   1192: iload 6
    //   1194: istore 8
    //   1196: iload 4
    //   1198: istore_3
    //   1199: ldc_w 292
    //   1202: new 101	java/lang/StringBuilder
    //   1205: dup
    //   1206: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   1209: ldc_w 569
    //   1212: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: aload_1
    //   1216: getfield 453	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   1219: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: ldc_w 455
    //   1225: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1228: aload_1
    //   1229: getfield 456	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   1232: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1235: ldc_w 458
    //   1238: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: aload_0
    //   1242: getfield 132	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connId	I
    //   1245: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1248: ldc_w 531
    //   1251: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: lload 12
    //   1256: invokevirtual 441	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1259: ldc_w 571
    //   1262: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: iload 7
    //   1267: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1270: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1273: aload 18
    //   1275: invokestatic 311	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1278: iload 6
    //   1280: istore 8
    //   1282: iload 4
    //   1284: istore_3
    //   1285: aload 18
    //   1287: invokevirtual 572	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1290: invokevirtual 575	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1293: astore 19
    //   1295: iload 7
    //   1297: ifne +78 -> 1375
    //   1300: iconst_3
    //   1301: istore_2
    //   1302: iload 6
    //   1304: istore 7
    //   1306: iload_2
    //   1307: istore 4
    //   1309: aload_0
    //   1310: getfield 78	com/tencent/mobileqq/highway/conn/SyncTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1313: invokevirtual 290	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1316: iload_2
    //   1317: istore 4
    //   1319: goto -306 -> 1013
    //   1322: astore 18
    //   1324: ldc_w 292
    //   1327: new 101	java/lang/StringBuilder
    //   1330: dup
    //   1331: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   1334: ldc_w 577
    //   1337: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: aload_1
    //   1341: getfield 453	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   1344: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1347: ldc_w 455
    //   1350: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: aload_1
    //   1354: getfield 456	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   1357: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1360: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1363: aload 18
    //   1365: invokestatic 311	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1368: iload 7
    //   1370: istore 6
    //   1372: goto -359 -> 1013
    //   1375: iload 6
    //   1377: istore 8
    //   1379: iload 4
    //   1381: istore_3
    //   1382: aload 19
    //   1384: ldc_w 579
    //   1387: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1390: iconst_m1
    //   1391: if_icmple +8 -> 1399
    //   1394: iconst_1
    //   1395: istore_2
    //   1396: goto -94 -> 1302
    //   1399: iload 6
    //   1401: istore 8
    //   1403: iload 4
    //   1405: istore_3
    //   1406: aload 19
    //   1408: ldc_w 585
    //   1411: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1414: iconst_m1
    //   1415: if_icmple +8 -> 1423
    //   1418: iconst_2
    //   1419: istore_2
    //   1420: goto -118 -> 1302
    //   1423: iload 6
    //   1425: istore 8
    //   1427: iload 4
    //   1429: istore_3
    //   1430: aload 19
    //   1432: ldc_w 587
    //   1435: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1438: iconst_m1
    //   1439: if_icmple +8 -> 1447
    //   1442: iconst_3
    //   1443: istore_2
    //   1444: goto -142 -> 1302
    //   1447: iload 6
    //   1449: istore 8
    //   1451: iload 4
    //   1453: istore_3
    //   1454: aload 19
    //   1456: ldc_w 589
    //   1459: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1462: iconst_m1
    //   1463: if_icmple +8 -> 1471
    //   1466: iconst_4
    //   1467: istore_2
    //   1468: goto -166 -> 1302
    //   1471: iload 6
    //   1473: istore 8
    //   1475: iload 4
    //   1477: istore_3
    //   1478: aload 19
    //   1480: ldc_w 591
    //   1483: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1486: iconst_m1
    //   1487: if_icmple +8 -> 1495
    //   1490: iconst_5
    //   1491: istore_2
    //   1492: goto -190 -> 1302
    //   1495: iload 6
    //   1497: istore 8
    //   1499: iload 4
    //   1501: istore_3
    //   1502: aload 19
    //   1504: ldc_w 593
    //   1507: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1510: iconst_m1
    //   1511: if_icmple +9 -> 1520
    //   1514: bipush 6
    //   1516: istore_2
    //   1517: goto -215 -> 1302
    //   1520: iload 6
    //   1522: istore 8
    //   1524: iload 4
    //   1526: istore_3
    //   1527: aload 19
    //   1529: ldc_w 595
    //   1532: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1535: iconst_m1
    //   1536: if_icmpgt +298 -> 1834
    //   1539: iload 6
    //   1541: istore 8
    //   1543: iload 4
    //   1545: istore_3
    //   1546: aload 19
    //   1548: ldc_w 597
    //   1551: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1554: iconst_m1
    //   1555: if_icmple +6 -> 1561
    //   1558: goto +276 -> 1834
    //   1561: iload 6
    //   1563: istore 8
    //   1565: iload 4
    //   1567: istore_3
    //   1568: aload 19
    //   1570: ldc_w 599
    //   1573: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1576: iconst_m1
    //   1577: if_icmple +9 -> 1586
    //   1580: bipush 8
    //   1582: istore_2
    //   1583: goto -281 -> 1302
    //   1586: iload 6
    //   1588: istore 8
    //   1590: iload 4
    //   1592: istore_3
    //   1593: aload 19
    //   1595: ldc_w 601
    //   1598: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1601: iconst_m1
    //   1602: if_icmple +9 -> 1611
    //   1605: bipush 9
    //   1607: istore_2
    //   1608: goto -306 -> 1302
    //   1611: iload 6
    //   1613: istore 8
    //   1615: iload 4
    //   1617: istore_3
    //   1618: aload 19
    //   1620: ldc_w 603
    //   1623: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1626: iconst_m1
    //   1627: if_icmple +9 -> 1636
    //   1630: bipush 10
    //   1632: istore_2
    //   1633: goto -331 -> 1302
    //   1636: iload 6
    //   1638: istore 8
    //   1640: iload 4
    //   1642: istore_3
    //   1643: aload 19
    //   1645: ldc_w 605
    //   1648: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1651: iconst_m1
    //   1652: if_icmple +9 -> 1661
    //   1655: bipush 11
    //   1657: istore_2
    //   1658: goto -356 -> 1302
    //   1661: iload 6
    //   1663: istore 8
    //   1665: iload 4
    //   1667: istore_3
    //   1668: aload 19
    //   1670: ldc_w 607
    //   1673: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1676: iconst_m1
    //   1677: if_icmple +9 -> 1686
    //   1680: bipush 12
    //   1682: istore_2
    //   1683: goto -381 -> 1302
    //   1686: iload 6
    //   1688: istore 8
    //   1690: iload 4
    //   1692: istore_3
    //   1693: aload 19
    //   1695: ldc_w 609
    //   1698: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1701: iconst_m1
    //   1702: if_icmple +9 -> 1711
    //   1705: bipush 7
    //   1707: istore_2
    //   1708: goto -406 -> 1302
    //   1711: iload 6
    //   1713: istore 8
    //   1715: iload 4
    //   1717: istore_3
    //   1718: aload 19
    //   1720: ldc_w 611
    //   1723: invokevirtual 583	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1726: iconst_m1
    //   1727: if_icmple +9 -> 1736
    //   1730: bipush 13
    //   1732: istore_2
    //   1733: goto -431 -> 1302
    //   1736: bipush 14
    //   1738: istore 4
    //   1740: iload 6
    //   1742: istore 8
    //   1744: iload 4
    //   1746: istore_3
    //   1747: aload 18
    //   1749: invokestatic 617	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1752: astore 18
    //   1754: iload 4
    //   1756: istore_2
    //   1757: iload 6
    //   1759: istore 8
    //   1761: iload 4
    //   1763: istore_3
    //   1764: aload 18
    //   1766: invokevirtual 620	java/lang/String:length	()I
    //   1769: sipush 200
    //   1772: if_icmple -470 -> 1302
    //   1775: iload 6
    //   1777: istore 8
    //   1779: iload 4
    //   1781: istore_3
    //   1782: aload 18
    //   1784: iconst_0
    //   1785: sipush 200
    //   1788: invokevirtual 624	java/lang/String:substring	(II)Ljava/lang/String;
    //   1791: pop
    //   1792: iload 4
    //   1794: istore_2
    //   1795: goto -493 -> 1302
    //   1798: astore 18
    //   1800: iload 8
    //   1802: istore 7
    //   1804: iload_3
    //   1805: istore 4
    //   1807: aload_0
    //   1808: getfield 78	com/tencent/mobileqq/highway/conn/SyncTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1811: invokevirtual 290	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1814: iload 8
    //   1816: istore 7
    //   1818: iload_3
    //   1819: istore 4
    //   1821: aload 18
    //   1823: athrow
    //   1824: aload_0
    //   1825: getfield 173	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/SyncTcpConnection$ConnWorker;
    //   1828: invokevirtual 255	com/tencent/mobileqq/highway/conn/SyncTcpConnection$ConnWorker:notifyToQuit	()V
    //   1831: iload 4
    //   1833: ireturn
    //   1834: bipush 7
    //   1836: istore_2
    //   1837: goto -535 -> 1302
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1840	0	this	SyncTcpConnection
    //   0	1840	1	paramEndPoint	EndPoint
    //   138	1699	2	i	int
    //   191	1628	3	j	int
    //   150	1682	4	k	int
    //   877	119	5	m	int
    //   134	1642	6	bool1	boolean
    //   128	1689	7	bool2	boolean
    //   165	1650	8	bool3	boolean
    //   125	885	9	bool4	boolean
    //   131	861	10	bool5	boolean
    //   683	209	11	bool6	boolean
    //   184	1071	12	l1	long
    //   147	804	14	l2	long
    //   142	964	16	l3	long
    //   715	247	18	localStringBuilder	StringBuilder
    //   1174	112	18	localThrowable	java.lang.Throwable
    //   1322	426	18	localInterruptedException	java.lang.InterruptedException
    //   1752	31	18	str	String
    //   1798	24	18	localObject1	Object
    //   774	945	19	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   192	211	1174	java/lang/Throwable
    //   228	236	1174	java/lang/Throwable
    //   253	264	1174	java/lang/Throwable
    //   281	289	1174	java/lang/Throwable
    //   306	314	1174	java/lang/Throwable
    //   331	342	1174	java/lang/Throwable
    //   359	368	1174	java/lang/Throwable
    //   385	390	1174	java/lang/Throwable
    //   407	421	1174	java/lang/Throwable
    //   438	446	1174	java/lang/Throwable
    //   463	474	1174	java/lang/Throwable
    //   491	514	1174	java/lang/Throwable
    //   531	545	1174	java/lang/Throwable
    //   562	573	1174	java/lang/Throwable
    //   590	602	1174	java/lang/Throwable
    //   619	627	1174	java/lang/Throwable
    //   644	651	1174	java/lang/Throwable
    //   668	676	1174	java/lang/Throwable
    //   705	717	1174	java/lang/Throwable
    //   734	750	1174	java/lang/Throwable
    //   767	776	1174	java/lang/Throwable
    //   798	806	1174	java/lang/Throwable
    //   823	836	1174	java/lang/Throwable
    //   853	873	1174	java/lang/Throwable
    //   895	991	1174	java/lang/Throwable
    //   152	167	1322	java/lang/InterruptedException
    //   999	1006	1322	java/lang/InterruptedException
    //   1309	1316	1322	java/lang/InterruptedException
    //   1807	1814	1322	java/lang/InterruptedException
    //   1821	1824	1322	java/lang/InterruptedException
    //   192	211	1798	finally
    //   228	236	1798	finally
    //   253	264	1798	finally
    //   281	289	1798	finally
    //   306	314	1798	finally
    //   331	342	1798	finally
    //   359	368	1798	finally
    //   385	390	1798	finally
    //   407	421	1798	finally
    //   438	446	1798	finally
    //   463	474	1798	finally
    //   491	514	1798	finally
    //   531	545	1798	finally
    //   562	573	1798	finally
    //   590	602	1798	finally
    //   619	627	1798	finally
    //   644	651	1798	finally
    //   668	676	1798	finally
    //   705	717	1798	finally
    //   734	750	1798	finally
    //   767	776	1798	finally
    //   798	806	1798	finally
    //   823	836	1798	finally
    //   853	873	1798	finally
    //   895	991	1798	finally
    //   1183	1192	1798	finally
    //   1199	1278	1798	finally
    //   1285	1295	1798	finally
    //   1382	1394	1798	finally
    //   1406	1418	1798	finally
    //   1430	1442	1798	finally
    //   1454	1466	1798	finally
    //   1478	1490	1798	finally
    //   1502	1514	1798	finally
    //   1527	1539	1798	finally
    //   1546	1558	1798	finally
    //   1568	1580	1798	finally
    //   1593	1605	1798	finally
    //   1618	1630	1798	finally
    //   1643	1655	1798	finally
    //   1668	1680	1798	finally
    //   1693	1705	1798	finally
    //   1718	1730	1798	finally
    //   1747	1754	1798	finally
    //   1764	1775	1798	finally
    //   1782	1792	1798	finally
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
    this.connThread.start();
    this.mConnHandler = new ConnWorker(this.connThread.getLooper());
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
  
  public int getConnType()
  {
    return this.connType;
  }
  
  public EndPoint getEndPoint()
  {
    return this.mEp;
  }
  
  public int getProtoType()
  {
    return this.protoType;
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
    if (this.protoType == 2)
    {
      this.isWritting.compareAndSet(true, false);
      if (this.connType != 1) {
        break label52;
      }
      wakeupChannel();
    }
    label52:
    while (this.connType != 2) {
      return;
    }
    disConnect();
    this.connManager.wakeupConnectionToWrite(1, false);
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
        SyncTcpConnection.this.openConn(SyncTcpConnection.this.mEp);
      }
      do
      {
        return;
        if (paramMessage.what == 2)
        {
          SyncTcpConnection.this.doSendData();
          return;
        }
      } while (paramMessage.what != 3);
      SyncTcpConnection.this.connThread.quit();
      SyncTcpConnection.access$1002(SyncTcpConnection.this, null);
      SyncTcpConnection.access$1102(SyncTcpConnection.this, null);
    }
    
    public void notifyToQuit()
    {
      if (SyncTcpConnection.this.mConnHandler != null) {
        SyncTcpConnection.this.mConnHandler.sendEmptyMessage(3);
      }
    }
    
    public void wakeupToWrite()
    {
      ConnWorker localConnWorker = SyncTcpConnection.this.mConnHandler;
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
      while (SyncTcpConnection.this.isRunning.get()) {
        try
        {
          ??? = SyncTcpConnection.this.mInputBuffer;
          if (??? == null) {
            return;
          }
          while (!((MsfSocketInputBuffer)???).isDataAvailable(30000)) {
            if (!SyncTcpConnection.this.isRunning.get()) {
              return;
            }
          }
          if (SyncTcpConnection.this.isRunning.get())
          {
            int i = ((MsfSocketInputBuffer)???).getBufferlen();
            ConnReportInfo localConnReportInfo = SyncTcpConnection.this.connInfo;
            localConnReportInfo.receiveDataLen += i;
            SyncTcpConnection.this.connManager.increaseDataFlowDw(i);
            HwServlet.reportTraffic4PicUp(SyncTcpConnection.this.connManager.engine.app, SyncTcpConnection.this.connInfo.serverIp, SyncTcpConnection.this.connInfo.port, false, i);
            SyncTcpConnection.this.dataCodec.onRecvData((MsfSocketInputBuffer)???);
            ((MsfSocketInputBuffer)???).reset();
          }
        }
        catch (Exception localException)
        {
          BdhLogUtil.LogException("C", "ReadThread Error.", localException);
          synchronized (SyncTcpConnection.this.closeDebug)
          {
            SyncTcpConnection.this.closeDebug.append("By ReadThread : " + localException.getMessage() + ";");
            SyncTcpConnection.this.closeConn(1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.SyncTcpConnection
 * JD-Core Version:    0.7.0.1
 */