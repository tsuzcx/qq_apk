package com.tencent.mobileqq.richmedia.conn;

import alyi;
import alyj;
import alyk;
import alyl;
import alym;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class LiteTcpConnection
  implements alyk
{
  private HandlerThread C;
  private alyi jdField_a_of_type_Alyi;
  private alyl jdField_a_of_type_Alyl;
  private alym jdField_a_of_type_Alym = new alym();
  private ReadRunnable jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ReadRunnable;
  private a jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$a;
  private long ahZ;
  private alyj c;
  private Handler cs;
  private AtomicBoolean isConn = new AtomicBoolean(false);
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private AtomicBoolean isWritting = new AtomicBoolean(false);
  private ReentrantLock lock = new ReentrantLock(true);
  private HandlerThread mConnThread;
  private int mConnTimeOut;
  private MsfSocketInputBuffer mInputBuffer;
  private OutputStream mOutputStream;
  private int mReadBufferSize;
  private int mReadTimeout;
  public long mRtt;
  private Socket mSocket;
  private InetSocketAddress serverAddress;
  private AtomicBoolean shouldCloseConn = new AtomicBoolean(false);
  
  public LiteTcpConnection(alyi paramalyi, long paramLong, alyj paramalyj, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Alyi = paramalyi;
    this.mReadBufferSize = 32768;
    this.mReadTimeout = paramInt2;
    this.ahZ = paramLong;
    this.c = paramalyj;
    this.mConnTimeOut = paramInt1;
    this.mConnThread = ThreadManager.newFreeHandlerThread("SubTitle-CONN", 0);
  }
  
  /* Error */
  private int a(alyj paramalyj)
  {
    // Byte code:
    //   0: ldc 105
    //   2: iconst_1
    //   3: new 107	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   10: ldc 110
    //   12: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: getfield 120	alyj:host	Ljava/lang/String;
    //   19: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 122
    //   24: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: getfield 125	alyj:port	I
    //   31: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: ldc 130
    //   36: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 83	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:ahZ	J
    //   43: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 65	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   56: invokevirtual 147	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   59: ifne +13 -> 72
    //   62: aload_0
    //   63: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   66: invokevirtual 147	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   69: ifeq +26 -> 95
    //   72: aload_0
    //   73: getfield 65	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   76: invokevirtual 147	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   79: ifeq +16 -> 95
    //   82: aload_0
    //   83: getfield 65	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   86: iconst_0
    //   87: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   90: aload_0
    //   91: iconst_2
    //   92: invokespecial 154	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:closeConn	(I)V
    //   95: bipush 14
    //   97: istore_2
    //   98: invokestatic 160	android/os/SystemClock:uptimeMillis	()J
    //   101: lstore 8
    //   103: ldc2_w 161
    //   106: lstore 6
    //   108: aload_0
    //   109: getfield 58	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   112: ldc2_w 163
    //   115: getstatic 170	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   118: invokevirtual 174	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   121: istore 10
    //   123: iload 10
    //   125: ifeq +947 -> 1072
    //   128: lload 6
    //   130: lstore 4
    //   132: aload_0
    //   133: new 176	java/net/InetSocketAddress
    //   136: dup
    //   137: aload_1
    //   138: getfield 120	alyj:host	Ljava/lang/String;
    //   141: aload_1
    //   142: getfield 125	alyj:port	I
    //   145: invokespecial 179	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   148: putfield 181	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   151: lload 6
    //   153: lstore 4
    //   155: aload_0
    //   156: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   159: iconst_0
    //   160: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   163: lload 6
    //   165: lstore 4
    //   167: aload_0
    //   168: new 183	java/net/Socket
    //   171: dup
    //   172: invokespecial 184	java/net/Socket:<init>	()V
    //   175: putfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mSocket	Ljava/net/Socket;
    //   178: lload 6
    //   180: lstore 4
    //   182: aload_0
    //   183: getfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mSocket	Ljava/net/Socket;
    //   186: iconst_1
    //   187: invokevirtual 189	java/net/Socket:setKeepAlive	(Z)V
    //   190: lload 6
    //   192: lstore 4
    //   194: aload_0
    //   195: getfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mSocket	Ljava/net/Socket;
    //   198: iconst_1
    //   199: invokevirtual 192	java/net/Socket:setTcpNoDelay	(Z)V
    //   202: lload 6
    //   204: lstore 4
    //   206: aload_0
    //   207: getfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mSocket	Ljava/net/Socket;
    //   210: aload_0
    //   211: getfield 81	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mReadTimeout	I
    //   214: invokevirtual 195	java/net/Socket:setSoTimeout	(I)V
    //   217: lload 6
    //   219: lstore 4
    //   221: aload_0
    //   222: getfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mSocket	Ljava/net/Socket;
    //   225: ldc 196
    //   227: invokevirtual 199	java/net/Socket:setSendBufferSize	(I)V
    //   230: lload 6
    //   232: lstore 4
    //   234: invokestatic 160	android/os/SystemClock:uptimeMillis	()J
    //   237: lstore 6
    //   239: lload 6
    //   241: lstore 4
    //   243: aload_0
    //   244: getfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mSocket	Ljava/net/Socket;
    //   247: aload_0
    //   248: getfield 181	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   251: aload_0
    //   252: getfield 87	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mConnTimeOut	I
    //   255: invokevirtual 203	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   258: lload 6
    //   260: lstore 4
    //   262: aload_0
    //   263: invokestatic 160	android/os/SystemClock:uptimeMillis	()J
    //   266: lload 6
    //   268: lsub
    //   269: putfield 205	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mRtt	J
    //   272: lload 6
    //   274: lstore 4
    //   276: aload_0
    //   277: aload_0
    //   278: getfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mSocket	Ljava/net/Socket;
    //   281: invokevirtual 209	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   284: putfield 211	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   287: lload 6
    //   289: lstore 4
    //   291: aload_0
    //   292: new 213	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   295: dup
    //   296: aload_0
    //   297: getfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mSocket	Ljava/net/Socket;
    //   300: aload_0
    //   301: getfield 79	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mReadBufferSize	I
    //   304: ldc 215
    //   306: iconst_m1
    //   307: invokespecial 218	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   310: putfield 220	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   313: lload 6
    //   315: lstore 4
    //   317: aload_0
    //   318: new 8	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable
    //   321: dup
    //   322: aload_0
    //   323: invokespecial 223	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable:<init>	(Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection;)V
    //   326: putfield 225	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ReadRunnable	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable;
    //   329: lload 6
    //   331: lstore 4
    //   333: aload_0
    //   334: ldc 227
    //   336: iconst_0
    //   337: invokestatic 95	com/tencent/mobileqq/app/ThreadManager:newFreeHandlerThread	(Ljava/lang/String;I)Landroid/os/HandlerThread;
    //   340: putfield 229	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:C	Landroid/os/HandlerThread;
    //   343: lload 6
    //   345: lstore 4
    //   347: aload_0
    //   348: getfield 229	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:C	Landroid/os/HandlerThread;
    //   351: invokevirtual 234	android/os/HandlerThread:start	()V
    //   354: lload 6
    //   356: lstore 4
    //   358: aload_0
    //   359: new 236	android/os/Handler
    //   362: dup
    //   363: aload_0
    //   364: getfield 229	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:C	Landroid/os/HandlerThread;
    //   367: invokevirtual 240	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   370: invokespecial 243	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   373: putfield 245	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:cs	Landroid/os/Handler;
    //   376: lload 6
    //   378: lstore 4
    //   380: aload_0
    //   381: getfield 69	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:isRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   384: iconst_1
    //   385: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   388: lload 6
    //   390: lstore 4
    //   392: aload_0
    //   393: getfield 245	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:cs	Landroid/os/Handler;
    //   396: aload_0
    //   397: getfield 225	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ReadRunnable	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable;
    //   400: invokevirtual 249	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   403: pop
    //   404: lload 6
    //   406: lstore 4
    //   408: aload_0
    //   409: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   412: iconst_1
    //   413: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   416: iconst_1
    //   417: istore 10
    //   419: new 107	java/lang/StringBuilder
    //   422: dup
    //   423: ldc 251
    //   425: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   428: astore 12
    //   430: aload_0
    //   431: getfield 85	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:c	Lalyj;
    //   434: getfield 120	alyj:host	Ljava/lang/String;
    //   437: ldc_w 256
    //   440: invokevirtual 262	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   443: ifeq +58 -> 501
    //   446: aload_0
    //   447: getfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mSocket	Ljava/net/Socket;
    //   450: invokevirtual 266	java/net/Socket:getRemoteSocketAddress	()Ljava/net/SocketAddress;
    //   453: astore 13
    //   455: aload 13
    //   457: ifnull +44 -> 501
    //   460: aload 13
    //   462: instanceof 176
    //   465: ifeq +36 -> 501
    //   468: aload 13
    //   470: checkcast 176	java/net/InetSocketAddress
    //   473: invokevirtual 270	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   476: invokevirtual 275	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   479: astore 13
    //   481: aload 12
    //   483: ldc_w 277
    //   486: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 13
    //   491: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc_w 279
    //   497: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: iconst_0
    //   502: istore_2
    //   503: ldc 105
    //   505: iconst_1
    //   506: new 107	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   513: ldc_w 281
    //   516: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload_1
    //   520: getfield 120	alyj:host	Ljava/lang/String;
    //   523: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: ldc 122
    //   528: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_1
    //   532: getfield 125	alyj:port	I
    //   535: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: ldc 130
    //   540: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload_0
    //   544: getfield 83	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:ahZ	J
    //   547: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   550: ldc_w 283
    //   553: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: lload 6
    //   558: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   561: ldc_w 285
    //   564: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload 12
    //   569: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: ldc_w 287
    //   578: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload_0
    //   582: getfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mSocket	Ljava/net/Socket;
    //   585: invokevirtual 291	java/net/Socket:getLocalPort	()I
    //   588: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   597: aload_0
    //   598: getfield 58	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   601: invokevirtual 297	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   604: iconst_1
    //   605: istore 10
    //   607: invokestatic 160	android/os/SystemClock:uptimeMillis	()J
    //   610: lstore 4
    //   612: aload_0
    //   613: getfield 299	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Alyl	Lalyl;
    //   616: ifnull +94 -> 710
    //   619: ldc 105
    //   621: iconst_1
    //   622: new 107	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   629: ldc_w 301
    //   632: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: aload_0
    //   636: getfield 83	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:ahZ	J
    //   639: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   642: ldc_w 303
    //   645: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: iload 10
    //   650: invokevirtual 306	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   653: ldc_w 308
    //   656: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: iload_2
    //   660: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   663: ldc_w 310
    //   666: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: lload 4
    //   671: lload 8
    //   673: lsub
    //   674: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   677: ldc_w 312
    //   680: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   689: aload_0
    //   690: getfield 299	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Alyl	Lalyl;
    //   693: iload 10
    //   695: aload_0
    //   696: getfield 83	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:ahZ	J
    //   699: aload_0
    //   700: aload_0
    //   701: getfield 85	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:c	Lalyj;
    //   704: iload_2
    //   705: invokeinterface 317 7 0
    //   710: iload 10
    //   712: ifeq +195 -> 907
    //   715: aload_0
    //   716: getfield 319	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$a	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$a;
    //   719: invokevirtual 322	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$a:wakeupToWrite	()V
    //   722: iload_2
    //   723: ireturn
    //   724: astore 12
    //   726: bipush 14
    //   728: istore_2
    //   729: iconst_0
    //   730: istore 10
    //   732: aload_0
    //   733: getfield 76	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Alyi	Lalyi;
    //   736: invokevirtual 327	alyi:hasNet	()Z
    //   739: istore 11
    //   741: ldc 105
    //   743: iconst_1
    //   744: new 107	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   751: ldc_w 329
    //   754: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload_1
    //   758: getfield 120	alyj:host	Ljava/lang/String;
    //   761: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: ldc 122
    //   766: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: aload_1
    //   770: getfield 125	alyj:port	I
    //   773: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   776: ldc 130
    //   778: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: aload_0
    //   782: getfield 83	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:ahZ	J
    //   785: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   788: ldc_w 283
    //   791: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: lload 4
    //   796: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   799: ldc_w 331
    //   802: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: iload 11
    //   807: invokevirtual 306	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   810: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: aload 12
    //   815: invokestatic 334	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   818: aload_0
    //   819: aload 12
    //   821: iload 11
    //   823: invokespecial 337	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:a	(Ljava/lang/Throwable;Z)I
    //   826: istore_3
    //   827: iload_3
    //   828: istore_2
    //   829: aload_0
    //   830: getfield 58	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   833: invokevirtual 297	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   836: goto -229 -> 607
    //   839: astore 12
    //   841: ldc 105
    //   843: iconst_1
    //   844: new 107	java/lang/StringBuilder
    //   847: dup
    //   848: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   851: ldc_w 339
    //   854: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload_1
    //   858: getfield 120	alyj:host	Ljava/lang/String;
    //   861: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: ldc 122
    //   866: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: aload_1
    //   870: getfield 125	alyj:port	I
    //   873: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   876: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   879: aload 12
    //   881: invokestatic 334	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   884: goto -277 -> 607
    //   887: astore 12
    //   889: iconst_0
    //   890: istore 10
    //   892: aload_0
    //   893: getfield 58	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   896: invokevirtual 297	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   899: aload 12
    //   901: athrow
    //   902: astore 12
    //   904: goto -63 -> 841
    //   907: new 341	java/util/HashMap
    //   910: dup
    //   911: invokespecial 342	java/util/HashMap:<init>	()V
    //   914: astore 12
    //   916: aload 12
    //   918: ldc_w 344
    //   921: new 107	java/lang/StringBuilder
    //   924: dup
    //   925: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   928: ldc_w 346
    //   931: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: iload_2
    //   935: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   938: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: invokevirtual 350	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   944: pop
    //   945: aload 12
    //   947: ldc_w 352
    //   950: new 107	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   957: ldc_w 346
    //   960: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: aload_1
    //   964: getfield 120	alyj:host	Ljava/lang/String;
    //   967: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: invokevirtual 350	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   976: pop
    //   977: invokestatic 358	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   980: invokestatic 363	anpc:a	(Landroid/content/Context;)Lanpc;
    //   983: aconst_null
    //   984: ldc_w 365
    //   987: iconst_1
    //   988: lconst_0
    //   989: lconst_0
    //   990: aload 12
    //   992: aconst_null
    //   993: invokevirtual 369	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   996: aload_0
    //   997: getfield 319	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$a	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$a;
    //   1000: invokevirtual 372	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$a:notifyToQuit	()V
    //   1003: iload_2
    //   1004: ireturn
    //   1005: astore 12
    //   1007: bipush 14
    //   1009: istore_2
    //   1010: iconst_0
    //   1011: istore 10
    //   1013: goto -172 -> 841
    //   1016: astore 12
    //   1018: iconst_0
    //   1019: istore_2
    //   1020: iconst_1
    //   1021: istore 10
    //   1023: goto -182 -> 841
    //   1026: astore 12
    //   1028: goto -136 -> 892
    //   1031: astore 12
    //   1033: iconst_0
    //   1034: istore_2
    //   1035: goto -143 -> 892
    //   1038: astore 12
    //   1040: goto -148 -> 892
    //   1043: astore 12
    //   1045: bipush 14
    //   1047: istore_2
    //   1048: iconst_1
    //   1049: istore 10
    //   1051: lload 6
    //   1053: lstore 4
    //   1055: goto -323 -> 732
    //   1058: astore 12
    //   1060: iconst_1
    //   1061: istore 10
    //   1063: lload 6
    //   1065: lstore 4
    //   1067: iconst_0
    //   1068: istore_2
    //   1069: goto -337 -> 732
    //   1072: iconst_0
    //   1073: istore 10
    //   1075: bipush 14
    //   1077: istore_2
    //   1078: goto -471 -> 607
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1081	0	this	LiteTcpConnection
    //   0	1081	1	paramalyj	alyj
    //   97	981	2	i	int
    //   826	2	3	j	int
    //   130	936	4	l1	long
    //   106	958	6	l2	long
    //   101	571	8	l3	long
    //   121	953	10	bool1	boolean
    //   739	83	11	bool2	boolean
    //   428	140	12	localStringBuilder	java.lang.StringBuilder
    //   724	96	12	localThrowable1	Throwable
    //   839	41	12	localInterruptedException1	java.lang.InterruptedException
    //   887	13	12	localObject1	Object
    //   902	1	12	localInterruptedException2	java.lang.InterruptedException
    //   914	77	12	localHashMap	java.util.HashMap
    //   1005	1	12	localInterruptedException3	java.lang.InterruptedException
    //   1016	1	12	localInterruptedException4	java.lang.InterruptedException
    //   1026	1	12	localObject2	Object
    //   1031	1	12	localObject3	Object
    //   1038	1	12	localObject4	Object
    //   1043	1	12	localThrowable2	Throwable
    //   1058	1	12	localThrowable3	Throwable
    //   453	37	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   132	151	724	java/lang/Throwable
    //   155	163	724	java/lang/Throwable
    //   167	178	724	java/lang/Throwable
    //   182	190	724	java/lang/Throwable
    //   194	202	724	java/lang/Throwable
    //   206	217	724	java/lang/Throwable
    //   221	230	724	java/lang/Throwable
    //   234	239	724	java/lang/Throwable
    //   243	258	724	java/lang/Throwable
    //   262	272	724	java/lang/Throwable
    //   276	287	724	java/lang/Throwable
    //   291	313	724	java/lang/Throwable
    //   317	329	724	java/lang/Throwable
    //   333	343	724	java/lang/Throwable
    //   347	354	724	java/lang/Throwable
    //   358	376	724	java/lang/Throwable
    //   380	388	724	java/lang/Throwable
    //   392	404	724	java/lang/Throwable
    //   408	416	724	java/lang/Throwable
    //   829	836	839	java/lang/InterruptedException
    //   132	151	887	finally
    //   155	163	887	finally
    //   167	178	887	finally
    //   182	190	887	finally
    //   194	202	887	finally
    //   206	217	887	finally
    //   221	230	887	finally
    //   234	239	887	finally
    //   243	258	887	finally
    //   262	272	887	finally
    //   276	287	887	finally
    //   291	313	887	finally
    //   317	329	887	finally
    //   333	343	887	finally
    //   347	354	887	finally
    //   358	376	887	finally
    //   380	388	887	finally
    //   392	404	887	finally
    //   408	416	887	finally
    //   892	902	902	java/lang/InterruptedException
    //   108	123	1005	java/lang/InterruptedException
    //   597	604	1016	java/lang/InterruptedException
    //   419	455	1026	finally
    //   460	501	1026	finally
    //   503	597	1031	finally
    //   732	827	1038	finally
    //   419	455	1043	java/lang/Throwable
    //   460	501	1043	java/lang/Throwable
    //   503	597	1058	java/lang/Throwable
  }
  
  private int a(Throwable paramThrowable, boolean paramBoolean)
  {
    paramThrowable = paramThrowable.toString().toLowerCase();
    if (!paramBoolean) {}
    do
    {
      return 3;
      if (paramThrowable.indexOf("illegal") > -1) {
        return 1;
      }
      if (paramThrowable.indexOf("route to host") > -1) {
        return 2;
      }
    } while (paramThrowable.indexOf("unreachable") > -1);
    if (paramThrowable.indexOf("permission") > -1) {
      return 4;
    }
    if (paramThrowable.indexOf("refused") > -1) {
      return 5;
    }
    if (paramThrowable.indexOf("reset") > -1) {
      return 6;
    }
    if ((paramThrowable.indexOf("timeoutexception") > -1) || (paramThrowable.indexOf(") after") > -1)) {
      return 7;
    }
    if (paramThrowable.indexOf("unknownhost") > -1) {
      return 8;
    }
    if (paramThrowable.indexOf("unresolved") > -1) {
      return 9;
    }
    if (paramThrowable.indexOf("enotsock") > -1) {
      return 10;
    }
    if (paramThrowable.indexOf("enobufs") > -1) {
      return 11;
    }
    if (paramThrowable.indexOf("ebadf") > -1) {
      return 12;
    }
    if (paramThrowable.indexOf("operation") > -1) {
      return 7;
    }
    if (paramThrowable.indexOf("invalid") > -1) {
      return 13;
    }
    return 14;
  }
  
  /* Error */
  private void closeConn(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_2
    //   7: ldc 105
    //   9: iconst_1
    //   10: new 107	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 429
    //   20: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 83	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:ahZ	J
    //   27: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: ldc_w 431
    //   33: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload_1
    //   37: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: getfield 69	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:isRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   50: iconst_0
    //   51: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   54: aload_0
    //   55: getfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mSocket	Ljava/net/Socket;
    //   58: ifnull +275 -> 333
    //   61: aload_0
    //   62: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   65: invokevirtual 147	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   68: ifne +4 -> 72
    //   71: return
    //   72: aload_0
    //   73: getfield 58	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   76: ldc2_w 163
    //   79: getstatic 170	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   82: invokevirtual 174	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   85: ifeq +199 -> 284
    //   88: aload_0
    //   89: getfield 211	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   92: astore 5
    //   94: aload 5
    //   96: ifnull +3 -> 99
    //   99: aload_0
    //   100: getfield 319	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$a	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$a;
    //   103: astore 5
    //   105: aload 5
    //   107: ifnull +8 -> 115
    //   110: aload 5
    //   112: invokevirtual 372	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$a:notifyToQuit	()V
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 220	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   120: aload_0
    //   121: aconst_null
    //   122: putfield 211	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   125: aload_0
    //   126: getfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mSocket	Ljava/net/Socket;
    //   129: ifnull +10 -> 139
    //   132: aload_0
    //   133: getfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mSocket	Ljava/net/Socket;
    //   136: invokevirtual 434	java/net/Socket:close	()V
    //   139: aload_0
    //   140: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   143: iconst_0
    //   144: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   147: aload_0
    //   148: aconst_null
    //   149: putfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:mSocket	Ljava/net/Socket;
    //   152: aload_0
    //   153: getfield 229	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:C	Landroid/os/HandlerThread;
    //   156: ifnull +16 -> 172
    //   159: aload_0
    //   160: getfield 229	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:C	Landroid/os/HandlerThread;
    //   163: invokevirtual 437	android/os/HandlerThread:quit	()Z
    //   166: pop
    //   167: aload_0
    //   168: aconst_null
    //   169: putfield 229	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:C	Landroid/os/HandlerThread;
    //   172: aload_0
    //   173: aconst_null
    //   174: putfield 245	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:cs	Landroid/os/Handler;
    //   177: aload_0
    //   178: aconst_null
    //   179: putfield 225	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ReadRunnable	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable;
    //   182: aload_0
    //   183: getfield 58	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   186: invokevirtual 297	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   189: iconst_1
    //   190: istore_2
    //   191: aload_0
    //   192: getfield 299	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Alyl	Lalyl;
    //   195: astore 5
    //   197: aload 5
    //   199: ifnull +15 -> 214
    //   202: aload 5
    //   204: aload_0
    //   205: getfield 83	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:ahZ	J
    //   208: aload_0
    //   209: invokeinterface 440 4 0
    //   214: ldc 105
    //   216: iconst_1
    //   217: new 107	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 442
    //   227: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_0
    //   231: getfield 83	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:ahZ	J
    //   234: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   237: ldc_w 444
    //   240: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: iload_2
    //   244: invokevirtual 306	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   247: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: return
    //   254: astore 5
    //   256: aload_0
    //   257: getfield 58	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   260: invokevirtual 297	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   263: aload 5
    //   265: athrow
    //   266: astore 5
    //   268: iload_3
    //   269: istore_2
    //   270: ldc 105
    //   272: iconst_1
    //   273: ldc_w 446
    //   276: aload 5
    //   278: invokestatic 334	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   281: goto -90 -> 191
    //   284: aload_0
    //   285: getfield 65	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   288: iconst_1
    //   289: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   292: goto -101 -> 191
    //   295: astore 5
    //   297: iload 4
    //   299: istore_2
    //   300: ldc 105
    //   302: iconst_1
    //   303: ldc_w 446
    //   306: aload 5
    //   308: invokestatic 334	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: goto -120 -> 191
    //   314: astore 5
    //   316: iconst_1
    //   317: istore_2
    //   318: goto -18 -> 300
    //   321: astore 5
    //   323: iconst_1
    //   324: istore_2
    //   325: goto -55 -> 270
    //   328: astore 5
    //   330: goto -191 -> 139
    //   333: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	LiteTcpConnection
    //   0	334	1	paramInt	int
    //   6	319	2	bool1	boolean
    //   1	268	3	bool2	boolean
    //   3	295	4	bool3	boolean
    //   92	111	5	localObject1	Object
    //   254	10	5	localObject2	Object
    //   266	11	5	localInterruptedException1	java.lang.InterruptedException
    //   295	12	5	localException1	Exception
    //   314	1	5	localException2	Exception
    //   321	1	5	localInterruptedException2	java.lang.InterruptedException
    //   328	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   99	105	254	finally
    //   110	115	254	finally
    //   115	125	254	finally
    //   125	139	254	finally
    //   139	172	254	finally
    //   172	182	254	finally
    //   54	71	266	java/lang/InterruptedException
    //   72	94	266	java/lang/InterruptedException
    //   256	266	266	java/lang/InterruptedException
    //   284	292	266	java/lang/InterruptedException
    //   54	71	295	java/lang/Exception
    //   72	94	295	java/lang/Exception
    //   256	266	295	java/lang/Exception
    //   284	292	295	java/lang/Exception
    //   182	189	314	java/lang/Exception
    //   182	189	321	java/lang/InterruptedException
    //   125	139	328	java/lang/Exception
  }
  
  private void doSendData()
  {
    if (this.isWritting.get())
    {
      if (QLog.isColorLevel()) {
        QLog.e("PeakAudioTransHandler LiteTcpConnection", 2, "do send data break ");
      }
      return;
    }
    try
    {
      this.isWritting.set(true);
      byte[] arrayOfByte;
      localOutputStream = this.mOutputStream;
    }
    catch (Exception localException1)
    {
      try
      {
        arrayOfByte = this.jdField_a_of_type_Alyi.getData();
        if (arrayOfByte != null) {
          break label113;
        }
        this.isWritting.set(false);
        return;
      }
      catch (Exception localException2)
      {
        this.isWritting.set(false);
        return;
      }
      localException1 = localException1;
      if (QLog.isColorLevel()) {
        QLog.e("PeakAudioTransHandler LiteTcpConnection", 2, "By SendWorker :" + localException1.getMessage() + ";");
      }
      closeConn(2);
      return;
    }
    label113:
    OutputStream localOutputStream;
    if (localOutputStream != null)
    {
      localOutputStream.write(localException2);
      localOutputStream.flush();
    }
    this.isWritting.set(false);
  }
  
  public void a(alyl paramalyl)
  {
    this.jdField_a_of_type_Alyl = paramalyl;
  }
  
  public void connect()
  {
    this.mConnThread.start();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$a = new a(this.mConnThread.getLooper());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$a.sendEmptyMessage(1);
  }
  
  public void disConnect()
  {
    closeConn(3);
  }
  
  public void wakeupChannel()
  {
    a locala = this.jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$a;
    if ((this.isRunning.get()) && (locala != null)) {
      locala.wakeupToWrite();
    }
  }
  
  class ReadRunnable
    implements Runnable
  {
    ReadRunnable() {}
    
    public void run()
    {
      while (LiteTcpConnection.a(LiteTcpConnection.this).get()) {
        try
        {
          MsfSocketInputBuffer localMsfSocketInputBuffer = LiteTcpConnection.a(LiteTcpConnection.this);
          if (localMsfSocketInputBuffer == null) {
            return;
          }
          while (!localMsfSocketInputBuffer.isDataAvailable(10000)) {
            if (!LiteTcpConnection.a(LiteTcpConnection.this).get()) {
              return;
            }
          }
          if (!LiteTcpConnection.a(LiteTcpConnection.this).get()) {
            break;
          }
          LiteTcpConnection.a(LiteTcpConnection.this).onRecvData(localMsfSocketInputBuffer);
          localMsfSocketInputBuffer.reset();
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PeakAudioTransHandler LiteTcpConnection", 2, "read exception " + localException.getMessage() + ";");
          }
          LiteTcpConnection.a(LiteTcpConnection.this, 1);
        }
      }
    }
  }
  
  class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1) {
        LiteTcpConnection.a(LiteTcpConnection.this, LiteTcpConnection.a(LiteTcpConnection.this));
      }
      do
      {
        return;
        if (paramMessage.what == 2)
        {
          LiteTcpConnection.a(LiteTcpConnection.this);
          return;
        }
      } while (paramMessage.what != 3);
      LiteTcpConnection.a(LiteTcpConnection.this).quit();
      LiteTcpConnection.a(LiteTcpConnection.this, null);
      LiteTcpConnection.a(LiteTcpConnection.this, null);
    }
    
    public void notifyToQuit()
    {
      if (LiteTcpConnection.a(LiteTcpConnection.this) != null) {
        LiteTcpConnection.a(LiteTcpConnection.this).sendEmptyMessage(3);
      }
    }
    
    public void wakeupToWrite()
    {
      a locala = LiteTcpConnection.a(LiteTcpConnection.this);
      if (locala != null) {
        locala.sendEmptyMessage(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.LiteTcpConnection
 * JD-Core Version:    0.7.0.1
 */