package com.tencent.mobileqq.utils.httputils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.RichMediaStrategy;
import com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCMTimer.SSCMTimerObserver;
import hem;
import hen;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class HttpCommunicator
  implements SSCMTimer.SSCMTimerObserver
{
  public static final int a = 5;
  private static long jdField_a_of_type_Long = 0L;
  public static final boolean a = true;
  public static final int b = 500;
  private static long jdField_b_of_type_Long = 1L;
  private static final String jdField_b_of_type_JavaLangString = "Q.richmedia.HttpCommunicator";
  public static final int c = 5;
  private static final String jdField_c_of_type_JavaLangString = "content-length zero";
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 5;
  public static final int j = 6;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private HttpCommunicator.PriorityQueue jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue = new HttpCommunicator.PriorityQueue();
  private IHttpCommunicatorFlowCount jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount;
  private Object jdField_a_of_type_JavaLangObject = new ReentrantLock();
  String jdField_a_of_type_JavaLangString = null;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private hen[] jdField_a_of_type_ArrayOfHen;
  boolean jdField_b_of_type_Boolean = true;
  private volatile boolean jdField_c_of_type_Boolean;
  private volatile boolean d = false;
  private boolean e;
  private int k = 0;
  private final int l = 3;
  private final int m;
  private int n;
  private int o;
  
  public HttpCommunicator(IHttpCommunicatorFlowCount paramIHttpCommunicatorFlowCount, int paramInt)
  {
    this.c = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount = paramIHttpCommunicatorFlowCount;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "construct HTTPcomm");
    }
    this.m = paramInt;
    this.n = 3;
    this.o = 0;
    if (Integer.parseInt(Build.VERSION.SDK) < 8) {
      System.setProperty("http.keepAlive", "false");
    }
    System.setProperty("http.maxConnections", "2");
  }
  
  public static long a()
  {
    return jdField_a_of_type_Long;
  }
  
  private HttpURLConnection a(HttpMsg paramHttpMsg)
  {
    String str1 = paramHttpMsg.a();
    Object localObject1 = (String)paramHttpMsg.jdField_a_of_type_JavaUtilHashMap.remove("mType");
    int i1;
    if (localObject1 != null)
    {
      i1 = str1.indexOf("?");
      if (i1 > 0) {
        if (str1.length() == i1 + 1) {
          str1 = str1.substring(0, i1 + 1) + "mType=" + (String)localObject1;
        }
      }
    }
    label285:
    label288:
    label694:
    label954:
    for (;;)
    {
      localObject1 = null;
      String str2 = android.net.Proxy.getDefaultHost();
      int i5 = android.net.Proxy.getDefaultPort();
      int i2 = 0;
      i1 = 0;
      label99:
      Object localObject2;
      int i4;
      if ((i1 == 0) && (i2 < 2))
      {
        localObject2 = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        localObject1 = null;
        if (localObject2 == null) {
          break label948;
        }
        i4 = ((NetworkInfo)localObject2).getType();
        localObject1 = ((NetworkInfo)localObject2).getExtraInfo();
      }
      for (;;)
      {
        String str3 = PkgTools.f((String)localObject1);
        if (!str3.equals(this.jdField_a_of_type_JavaLangString))
        {
          if ((i4 == 1) || (str3.equals(PkgTools.d))) {
            this.jdField_b_of_type_Boolean = false;
          }
        }
        else
        {
          label187:
          if ((i4 == 1) && (("10.0.0.172".equals(str2)) || ("10.0.0.200".equals(str2)))) {
            this.jdField_b_of_type_Boolean = true;
          }
          if ((str2 == null) || (i5 <= 0)) {
            break label943;
          }
        }
        for (i1 = 1;; i1 = 0)
        {
          int i3;
          int i6;
          Object localObject3;
          int i7;
          if ((!this.jdField_b_of_type_Boolean) && (i1 != 0)) {
            if ((str3.equals(PkgTools.d)) || (str3.equals(PkgTools.f)) || (str3.equals(PkgTools.h)))
            {
              localObject1 = PkgTools.b(str1, str2, i5);
              i3 = 1;
              paramHttpMsg.f = i4;
              i6 = NetworkCenter.a().a();
              localObject3 = RichMediaStrategy.a(i6);
              i7 = ((RichMediaStrategy.NetPolicy)localObject3).d();
              ((HttpURLConnection)localObject1).setConnectTimeout(i7);
              if (!"POST".equals(paramHttpMsg.d())) {
                break label694;
              }
            }
          }
          for (i4 = 89500;; i4 = ((RichMediaStrategy.NetPolicy)localObject3).e())
          {
            ((HttpURLConnection)localObject1).setReadTimeout(i4);
            a(paramHttpMsg, "gettingConn", "getConnection type:" + i6 + " activeNetworkInfo: " + localObject2 + " defaultHost:" + str2 + " defaultPort: " + i5 + " last apnType:" + this.jdField_a_of_type_JavaLangString + " forceDirect:" + this.jdField_b_of_type_Boolean + ",connectTimeOut:" + i7 + ",readTimeout:" + i4);
            ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
            localObject2 = paramHttpMsg.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject2).next();
              ((HttpURLConnection)localObject1).setRequestProperty((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
            }
            str1 = str1.substring(0, i1 + 1) + "mType=" + (String)localObject1 + "&" + str1.substring(i1 + 1);
            break;
            if (str1.length() <= 0) {
              break label954;
            }
            str1 = str1 + "?mType=" + (String)localObject1;
            break;
            this.jdField_b_of_type_Boolean = true;
            break label187;
            if (str3.equals(PkgTools.b))
            {
              localObject1 = PkgTools.a(str1, str2, i5);
              break label285;
            }
            localObject1 = PkgTools.a(str1, str2, i5);
            break label285;
            localObject1 = (HttpURLConnection)new URL(str1).openConnection(java.net.Proxy.NO_PROXY);
            i3 = 0;
            break label288;
          }
          if (paramHttpMsg.d().equals("POST"))
          {
            ((HttpURLConnection)localObject1).setDoOutput(true);
            if (paramHttpMsg.b() != null) {
              ((HttpURLConnection)localObject1).setFixedLengthStreamingMode(paramHttpMsg.b().length);
            }
          }
          paramHttpMsg.af = ((HttpURLConnection)localObject1).getRequestProperties().toString();
          try
          {
            ((HttpURLConnection)localObject1).connect();
            i1 = 1;
          }
          catch (Exception localException)
          {
            while (i1 != 0) {
              if ((i3 != 0) && (i1 != 0))
              {
                i1 = 0;
                this.jdField_b_of_type_Boolean = true;
              }
              else if ((i1 != 0) && (i3 == 0))
              {
                i1 = 0;
                this.jdField_b_of_type_Boolean = false;
              }
              else
              {
                throw localException;
              }
            }
            throw localException;
          }
          catch (AssertionError localAssertionError)
          {
            String str4;
            for (;;)
            {
              str4 = localAssertionError.getMessage();
              if (QLog.isColorLevel()) {
                QLog.d("Q.richmedia.HttpCommunicator", 2, "assertion:" + str4);
              }
              if (i1 == 0) {
                break;
              }
              if ((i3 != 0) && (i1 != 0))
              {
                i1 = 0;
                this.jdField_b_of_type_Boolean = true;
              }
              else if ((i1 != 0) && (i3 == 0))
              {
                i1 = 0;
                this.jdField_b_of_type_Boolean = false;
              }
              else
              {
                i1 = 1;
              }
            }
            throw new SocketException("AssertionError : " + str4);
          }
          this.jdField_a_of_type_JavaLangString = str3;
          i2 += 1;
          break label99;
          return localObject1;
        }
        i4 = -1;
      }
    }
  }
  
  private void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SSCM", 2, "msg statuschanged: " + paramInt);
      }
      paramHttpMsg1.a().a(paramHttpMsg1, paramHttpMsg2, paramInt);
    }
  }
  
  public static long b()
  {
    return jdField_b_of_type_Long;
  }
  
  public int a()
  {
    return this.m;
  }
  
  int a(int paramInt)
  {
    switch (paramInt % 5)
    {
    case 0: 
    default: 
      return 404;
    case 1: 
      return 416;
    case 2: 
      return 302;
    case 3: 
      return 501;
    }
    return 400;
  }
  
  public int a(HttpMsg paramHttpMsg)
  {
    int i1 = -1;
    int i3 = this.m;
    int i2 = 1;
    if (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.richmedia.HttpCommunicator", 2, "sendMsg closed");
      }
      if ((paramHttpMsg != null) && (paramHttpMsg.a() != null))
      {
        paramHttpMsg.a(9366, -1, "close");
        paramHttpMsg.a().b(paramHttpMsg, paramHttpMsg);
        i3 = i1;
        return i3;
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() < i3)
        {
          i1 = this.k + 1;
          this.k = i1;
          paramHttpMsg.a(i1);
          this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramHttpMsg);
          paramHttpMsg.a().a(paramHttpMsg, null, 0);
          i1 = this.k;
          i3 = i1;
          if (i2 == 0) {
            break;
          }
          a("sendMsg");
          return i1;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
          if ((paramHttpMsg != null) && (paramHttpMsg.a() != null))
          {
            paramHttpMsg.a(9367, -1, "queen full");
            paramHttpMsg.a().b(paramHttpMsg, paramHttpMsg);
          }
        }
      }
      i2 = 0;
    }
  }
  
  Exception a(int paramInt)
  {
    switch (paramInt % 10)
    {
    default: 
      return new Exception("inject Exception");
    case 0: 
      return new SocketTimeoutException("inject sockettimeout");
    case 1: 
      return new PortUnreachableException("inject PortUnreachableException");
    case 2: 
      return new ConnectException("inject ConnectException");
    case 3: 
      return new NoRouteToHostException("inject NoRouteToHostException");
    case 4: 
      return new IllegalArgumentException("inject IllegalArgumentException");
    case 5: 
      return new IllegalStateException("inject IllegalStateException");
    case 6: 
      return new IOException("inject IOException");
    case 7: 
      return new IOException("preempted by higher msg");
    case 8: 
      return new IOException("HttpCommunicator closed or msg caceled!");
    }
    return new IOException("content-length zero");
  }
  
  public void a()
  {
    int i1 = 0;
    if ((this.d) || (this.c)) {
      throw new IllegalStateException("HttpCommunicator already in using or disposed!");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.c = true;
      this.o = 0;
      this.jdField_a_of_type_AndroidOsHandler = ThreadManager.b();
      this.jdField_a_of_type_ArrayOfHen = new hen[3];
      while (i1 < 3)
      {
        HandlerThread localHandlerThread = new HandlerThread("httpcommunicator_norm_" + i1, 5);
        localHandlerThread.start();
        this.jdField_a_of_type_ArrayOfHen[i1] = new hen(this, localHandlerThread.getLooper());
        this.jdField_a_of_type_ArrayOfHen[i1].jdField_a_of_type_Int = i1;
        i1 += 1;
      }
      i1 = NetworkCenter.a().a();
      if ((i1 == 2) || (i1 == 3))
      {
        this.n = 2;
        return;
      }
      this.n = 3;
    }
  }
  
  public void a(int paramInt)
  {
    localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        this.n = 3;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.HttpCommunicator", 2, "netType:" + paramInt + " concurrent:" + this.n);
        }
        a("netChange");
        return;
      }
      finally {}
      this.n = 2;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  void a(int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    if ((paramHttpURLConnection == null) || (paramHttpMsg == null)) {
      return;
    }
    paramHttpMsg.c(paramInt);
    paramHttpMsg.b("Content-Type", paramHttpURLConnection.getContentType());
    paramHttpMsg.ag = paramHttpURLConnection.getHeaderFields().toString();
    if (paramHttpURLConnection.getHeaderField("User-ReturnCode") != null) {
      paramHttpMsg.b("User-ReturnCode", paramHttpURLConnection.getHeaderField("User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("X-User-ReturnCode") != null) {
      paramHttpMsg.b("X-User-ReturnCode", paramHttpURLConnection.getHeaderField("X-User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("content-range") != null) {
      paramHttpMsg.b("content-range", paramHttpURLConnection.getHeaderField("content-range"));
    }
    if (paramHttpURLConnection.getHeaderField("Range") != null) {
      paramHttpMsg.b("Range", paramHttpURLConnection.getHeaderField("Range"));
    }
    if (paramHttpURLConnection.getHeaderField("X-Range") != null) {
      paramHttpMsg.b("X-Range", paramHttpURLConnection.getHeaderField("X-Range"));
    }
    if (paramHttpURLConnection.getHeaderField("Content-Encoding") != null) {
      paramHttpMsg.b("Content-Encoding", paramHttpURLConnection.getHeaderField("Content-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("X-RtFlag") != null) {
      paramHttpMsg.b("X-RtFlag", paramHttpURLConnection.getHeaderField("X-RtFlag"));
    }
    if (paramHttpURLConnection.getHeaderField("X-httime") != null) {
      paramHttpMsg.b("X-httime", paramHttpURLConnection.getHeaderField("X-httime"));
    }
    if (paramHttpURLConnection.getHeaderField("X-piccachetime") != null) {
      paramHttpMsg.b("X-piccachetime", paramHttpURLConnection.getHeaderField("X-piccachetime"));
    }
    paramHttpMsg.jdField_a_of_type_Long = -1L;
    String str = paramHttpURLConnection.getHeaderField("content-range");
    int i1;
    if (str != null) {
      i1 = str.lastIndexOf("/");
    }
    for (;;)
    {
      try
      {
        paramHttpMsg.jdField_a_of_type_Long = Long.valueOf(str.substring(i1 + 1)).longValue();
        paramHttpMsg.jdField_b_of_type_Long = paramHttpURLConnection.getContentLength();
        a(paramHttpMsg, "copyRespHeader", "resultCode:" + paramInt + " totalLen:" + paramHttpMsg.jdField_a_of_type_Long + ",totalBlockLen:" + paramHttpMsg.jdField_b_of_type_Long);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      paramHttpMsg.jdField_a_of_type_Long = paramHttpURLConnection.getContentLength();
      paramHttpMsg.jdField_b_of_type_Long = paramHttpMsg.jdField_a_of_type_Long;
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    int i1 = 4;
    int i2 = (int)(2L * paramLong / 90000L);
    if (i2 > 4) {}
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(i1 + 9400));
      localHashMap.put("param_PostSize", String.valueOf(paramInt));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "LongHttpRespTime", false, paramLong, 0L, localHashMap, "");
      return;
      i1 = i2;
    }
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramHttpMsg);
      paramHttpMsg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
  }
  
  public void a(HttpMsg paramHttpMsg, hen paramhen)
  {
    int i1 = 0;
    if ((paramHttpMsg != null) && (paramhen != null)) {
      try
      {
        a(paramHttpMsg, "responseTimeout", "");
        if (paramHttpMsg.b() == null) {}
        for (;;)
        {
          a(90000L, i1);
          a(paramhen);
          paramHttpMsg.a(9014, 0, "response timeout");
          paramHttpMsg.a().b(paramHttpMsg, paramHttpMsg);
          return;
          i1 = paramHttpMsg.b().length;
        }
        return;
      }
      catch (Exception paramHttpMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "onResponseTimeout", paramHttpMsg);
        }
      }
    }
  }
  
  /* Error */
  public void a(HttpMsg paramHttpMsg, hen paramhen, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 402	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   4: astore 35
    //   6: aconst_null
    //   7: astore 30
    //   9: aconst_null
    //   10: astore 33
    //   12: aconst_null
    //   13: astore 32
    //   15: aconst_null
    //   16: astore 34
    //   18: aconst_null
    //   19: astore 31
    //   21: iconst_0
    //   22: istore 10
    //   24: lconst_0
    //   25: lstore 16
    //   27: iconst_0
    //   28: istore 12
    //   30: iconst_0
    //   31: istore 9
    //   33: iconst_0
    //   34: istore 8
    //   36: aload_0
    //   37: aload_1
    //   38: aconst_null
    //   39: iconst_1
    //   40: iload_3
    //   41: invokespecial 641	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;IZ)V
    //   44: iconst_0
    //   45: istore 7
    //   47: iconst_0
    //   48: istore 12
    //   50: aconst_null
    //   51: astore 26
    //   53: iconst_m1
    //   54: istore 4
    //   56: aconst_null
    //   57: astore 25
    //   59: aconst_null
    //   60: astore 24
    //   62: lconst_0
    //   63: lstore 14
    //   65: aload_0
    //   66: aload_1
    //   67: ldc_w 643
    //   70: ldc_w 614
    //   73: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_0
    //   77: aload_2
    //   78: aload_1
    //   79: invokevirtual 646	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lhen;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   82: aload_0
    //   83: aload_1
    //   84: invokespecial 648	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)Ljava/net/HttpURLConnection;
    //   87: astore 27
    //   89: aload 27
    //   91: astore 25
    //   93: aload_1
    //   94: aload 25
    //   96: putfield 651	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   99: aload_1
    //   100: invokestatic 656	android/os/SystemClock:uptimeMillis	()J
    //   103: putfield 658	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_Long	J
    //   106: aload_0
    //   107: aload_1
    //   108: ldc_w 660
    //   111: ldc_w 614
    //   114: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   117: iconst_1
    //   118: istore 12
    //   120: invokestatic 663	java/lang/System:currentTimeMillis	()J
    //   123: pop2
    //   124: aload_1
    //   125: invokevirtual 268	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   128: ldc_w 266
    //   131: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +4547 -> 4681
    //   137: new 665	hel
    //   140: dup
    //   141: aload_0
    //   142: aload_1
    //   143: aload_2
    //   144: invokespecial 668	hel:<init>	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lhen;)V
    //   147: astore 28
    //   149: aload_0
    //   150: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   153: aload 28
    //   155: ldc2_w 593
    //   158: invokevirtual 674	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   161: pop
    //   162: aload_1
    //   163: invokevirtual 370	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()[B
    //   166: astore 27
    //   168: aload 25
    //   170: invokevirtual 678	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   173: astore 26
    //   175: aload_0
    //   176: aload_1
    //   177: ldc_w 680
    //   180: new 168	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 682
    //   190: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 27
    //   195: arraylength
    //   196: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   205: iconst_0
    //   206: istore 5
    //   208: iload 5
    //   210: aload 27
    //   212: arraylength
    //   213: if_icmpge +46 -> 259
    //   216: aload_0
    //   217: aload_2
    //   218: aload_1
    //   219: invokevirtual 646	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lhen;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   222: aload 26
    //   224: aload 27
    //   226: iload 5
    //   228: sipush 10240
    //   231: aload 27
    //   233: arraylength
    //   234: iload 5
    //   236: isub
    //   237: invokestatic 688	java/lang/Math:min	(II)I
    //   240: invokevirtual 694	java/io/OutputStream:write	([BII)V
    //   243: aload 26
    //   245: invokevirtual 697	java/io/OutputStream:flush	()V
    //   248: iload 5
    //   250: sipush 10240
    //   253: iadd
    //   254: istore 5
    //   256: goto -48 -> 208
    //   259: aload_2
    //   260: ifnull +13 -> 273
    //   263: aload_2
    //   264: getfield 699	hen:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   267: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   270: ifne +14 -> 284
    //   273: aload_0
    //   274: aload_1
    //   275: ldc_w 704
    //   278: ldc_w 614
    //   281: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload 25
    //   286: invokevirtual 708	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   289: invokevirtual 709	java/net/URL:toString	()Ljava/lang/String;
    //   292: invokevirtual 166	java/lang/String:length	()I
    //   295: i2l
    //   296: lstore 18
    //   298: aload 27
    //   300: arraylength
    //   301: istore 5
    //   303: lload 14
    //   305: iload 5
    //   307: i2l
    //   308: ldc2_w 710
    //   311: lload 18
    //   313: ladd
    //   314: ladd
    //   315: ladd
    //   316: lstore 14
    //   318: aload 26
    //   320: astore 27
    //   322: aload 28
    //   324: astore 24
    //   326: iload 4
    //   328: istore 6
    //   330: lload 16
    //   332: lstore 20
    //   334: iload 4
    //   336: istore 5
    //   338: lload 16
    //   340: lstore 18
    //   342: aload 32
    //   344: astore 29
    //   346: aload_0
    //   347: aload_2
    //   348: aload_1
    //   349: invokevirtual 646	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lhen;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   352: iload 4
    //   354: istore 6
    //   356: lload 16
    //   358: lstore 20
    //   360: iload 4
    //   362: istore 5
    //   364: lload 16
    //   366: lstore 18
    //   368: aload 32
    //   370: astore 29
    //   372: aload 25
    //   374: invokevirtual 714	java/net/HttpURLConnection:getResponseCode	()I
    //   377: istore 4
    //   379: iload 4
    //   381: istore 6
    //   383: lload 16
    //   385: lstore 20
    //   387: iload 4
    //   389: istore 5
    //   391: lload 16
    //   393: lstore 18
    //   395: aload 32
    //   397: astore 29
    //   399: aload_0
    //   400: iload 4
    //   402: aload 25
    //   404: aload_1
    //   405: invokevirtual 716	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   408: aload_2
    //   409: ifnull +252 -> 661
    //   412: iload 4
    //   414: istore 6
    //   416: lload 16
    //   418: lstore 20
    //   420: iload 4
    //   422: istore 5
    //   424: lload 16
    //   426: lstore 18
    //   428: aload 32
    //   430: astore 29
    //   432: aload_2
    //   433: getfield 699	hen:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   436: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   439: istore 13
    //   441: iload 13
    //   443: ifeq +218 -> 661
    //   446: iload 4
    //   448: sipush 200
    //   451: if_icmpeq +11 -> 462
    //   454: iload 4
    //   456: sipush 206
    //   459: if_icmpne +31 -> 490
    //   462: aload_0
    //   463: aload_1
    //   464: ldc_w 718
    //   467: new 168	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   474: ldc_w 720
    //   477: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: iconst_0
    //   481: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   484: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   490: aload_2
    //   491: ifnull +13 -> 504
    //   494: aload_2
    //   495: getfield 699	hen:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   498: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   501: ifne +47 -> 548
    //   504: aload_0
    //   505: aload_1
    //   506: ldc_w 722
    //   509: new 168	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   516: ldc_w 724
    //   519: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: aload_1
    //   523: invokevirtual 726	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   526: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: ldc_w 728
    //   532: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload_1
    //   536: invokevirtual 144	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   539: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   548: aload_0
    //   549: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   552: ifnull +17 -> 569
    //   555: aload 24
    //   557: ifnull +12 -> 569
    //   560: aload_0
    //   561: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   564: aload 24
    //   566: invokevirtual 732	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   569: lload 14
    //   571: lconst_0
    //   572: ladd
    //   573: lstore 14
    //   575: lload 14
    //   577: lconst_0
    //   578: lcmp
    //   579: ifeq +26 -> 605
    //   582: aload_1
    //   583: invokevirtual 268	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   586: ldc_w 266
    //   589: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   592: ifeq +58 -> 650
    //   595: iconst_1
    //   596: istore_3
    //   597: aload_0
    //   598: aload_1
    //   599: iload_3
    //   600: lload 14
    //   602: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   605: iconst_0
    //   606: ifeq +11 -> 617
    //   609: new 737	java/lang/NullPointerException
    //   612: dup
    //   613: invokespecial 738	java/lang/NullPointerException:<init>	()V
    //   616: athrow
    //   617: iconst_0
    //   618: ifeq +11 -> 629
    //   621: new 737	java/lang/NullPointerException
    //   624: dup
    //   625: invokespecial 738	java/lang/NullPointerException:<init>	()V
    //   628: athrow
    //   629: aload 27
    //   631: ifnull +8 -> 639
    //   634: aload 27
    //   636: invokevirtual 740	java/io/OutputStream:close	()V
    //   639: aload 25
    //   641: ifnull +8 -> 649
    //   644: aload 25
    //   646: invokevirtual 743	java/net/HttpURLConnection:disconnect	()V
    //   649: return
    //   650: iconst_0
    //   651: istore_3
    //   652: goto -55 -> 597
    //   655: astore_1
    //   656: aload_1
    //   657: invokevirtual 589	java/lang/Exception:printStackTrace	()V
    //   660: return
    //   661: iload 4
    //   663: istore 6
    //   665: lload 16
    //   667: lstore 20
    //   669: iload 4
    //   671: istore 5
    //   673: lload 16
    //   675: lstore 18
    //   677: aload 32
    //   679: astore 29
    //   681: aload_0
    //   682: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   685: ifnull +37 -> 722
    //   688: aload 24
    //   690: ifnull +32 -> 722
    //   693: iload 4
    //   695: istore 6
    //   697: lload 16
    //   699: lstore 20
    //   701: iload 4
    //   703: istore 5
    //   705: lload 16
    //   707: lstore 18
    //   709: aload 32
    //   711: astore 29
    //   713: aload_0
    //   714: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   717: aload 24
    //   719: invokevirtual 732	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   722: iload 4
    //   724: istore 6
    //   726: lload 16
    //   728: lstore 20
    //   730: iload 4
    //   732: istore 5
    //   734: lload 16
    //   736: lstore 18
    //   738: aload 32
    //   740: astore 29
    //   742: aload_0
    //   743: aload_1
    //   744: ldc_w 745
    //   747: new 168	java/lang/StringBuilder
    //   750: dup
    //   751: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   754: ldc_w 747
    //   757: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: iload 4
    //   762: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   765: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   768: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   771: iload 4
    //   773: sipush 302
    //   776: if_icmpeq +11 -> 787
    //   779: iload 4
    //   781: sipush 301
    //   784: if_icmpne +1255 -> 2039
    //   787: iload 7
    //   789: iconst_5
    //   790: if_icmpge +919 -> 1709
    //   793: iload 4
    //   795: istore 6
    //   797: lload 16
    //   799: lstore 20
    //   801: iload 4
    //   803: istore 5
    //   805: lload 16
    //   807: lstore 18
    //   809: aload 32
    //   811: astore 29
    //   813: aload_0
    //   814: aload_1
    //   815: ldc_w 749
    //   818: new 168	java/lang/StringBuilder
    //   821: dup
    //   822: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   825: ldc_w 751
    //   828: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: aload_1
    //   832: getfield 381	com/tencent/mobileqq/utils/httputils/HttpMsg:af	Ljava/lang/String;
    //   835: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: ldc_w 753
    //   841: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: aload_1
    //   845: getfield 533	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   848: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   854: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   857: iload 4
    //   859: istore 6
    //   861: lload 16
    //   863: lstore 20
    //   865: iload 4
    //   867: istore 5
    //   869: lload 16
    //   871: lstore 18
    //   873: aload 32
    //   875: astore 29
    //   877: aload 25
    //   879: ldc_w 755
    //   882: invokevirtual 538	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   885: astore 26
    //   887: aload 26
    //   889: ifnull +417 -> 1306
    //   892: aload 27
    //   894: ifnull +20 -> 914
    //   897: iload 4
    //   899: istore 5
    //   901: lload 16
    //   903: lstore 18
    //   905: aload 32
    //   907: astore 29
    //   909: aload 27
    //   911: invokevirtual 740	java/io/OutputStream:close	()V
    //   914: iload 4
    //   916: istore 5
    //   918: lload 16
    //   920: lstore 18
    //   922: aload 32
    //   924: astore 29
    //   926: aload 25
    //   928: invokevirtual 743	java/net/HttpURLConnection:disconnect	()V
    //   931: iload 4
    //   933: istore 6
    //   935: lload 16
    //   937: lstore 20
    //   939: iload 4
    //   941: istore 5
    //   943: lload 16
    //   945: lstore 18
    //   947: aload 32
    //   949: astore 29
    //   951: aload_1
    //   952: invokevirtual 757	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()Z
    //   955: ifne +247 -> 1202
    //   958: iload 4
    //   960: istore 6
    //   962: lload 16
    //   964: lstore 20
    //   966: iload 4
    //   968: istore 5
    //   970: lload 16
    //   972: lstore 18
    //   974: aload 32
    //   976: astore 29
    //   978: aload 35
    //   980: aload 26
    //   982: invokeinterface 758 2 0
    //   987: iload 4
    //   989: sipush 200
    //   992: if_icmpeq +11 -> 1003
    //   995: iload 4
    //   997: sipush 206
    //   1000: if_icmpne +31 -> 1031
    //   1003: aload_0
    //   1004: aload_1
    //   1005: ldc_w 718
    //   1008: new 168	java/lang/StringBuilder
    //   1011: dup
    //   1012: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1015: ldc_w 720
    //   1018: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: iconst_0
    //   1022: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1025: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1028: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1031: aload_2
    //   1032: ifnull +13 -> 1045
    //   1035: aload_2
    //   1036: getfield 699	hen:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1039: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1042: ifne +47 -> 1089
    //   1045: aload_0
    //   1046: aload_1
    //   1047: ldc_w 722
    //   1050: new 168	java/lang/StringBuilder
    //   1053: dup
    //   1054: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1057: ldc_w 724
    //   1060: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: aload_1
    //   1064: invokevirtual 726	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   1067: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: ldc_w 728
    //   1073: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: aload_1
    //   1077: invokevirtual 144	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   1080: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1086: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1089: aload_0
    //   1090: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1093: ifnull +17 -> 1110
    //   1096: aload 24
    //   1098: ifnull +12 -> 1110
    //   1101: aload_0
    //   1102: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1105: aload 24
    //   1107: invokevirtual 732	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1110: lload 14
    //   1112: lconst_0
    //   1113: ladd
    //   1114: lstore 14
    //   1116: lload 14
    //   1118: lconst_0
    //   1119: lcmp
    //   1120: ifeq +26 -> 1146
    //   1123: aload_1
    //   1124: invokevirtual 268	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   1127: ldc_w 266
    //   1130: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1133: ifeq +64 -> 1197
    //   1136: iconst_1
    //   1137: istore_3
    //   1138: aload_0
    //   1139: aload_1
    //   1140: iload_3
    //   1141: lload 14
    //   1143: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1146: iconst_0
    //   1147: ifeq +11 -> 1158
    //   1150: new 737	java/lang/NullPointerException
    //   1153: dup
    //   1154: invokespecial 738	java/lang/NullPointerException:<init>	()V
    //   1157: athrow
    //   1158: iconst_0
    //   1159: ifeq +11 -> 1170
    //   1162: new 737	java/lang/NullPointerException
    //   1165: dup
    //   1166: invokespecial 738	java/lang/NullPointerException:<init>	()V
    //   1169: athrow
    //   1170: aload 27
    //   1172: ifnull +8 -> 1180
    //   1175: aload 27
    //   1177: invokevirtual 740	java/io/OutputStream:close	()V
    //   1180: aload 25
    //   1182: ifnull -533 -> 649
    //   1185: aload 25
    //   1187: invokevirtual 743	java/net/HttpURLConnection:disconnect	()V
    //   1190: return
    //   1191: astore_1
    //   1192: aload_1
    //   1193: invokevirtual 589	java/lang/Exception:printStackTrace	()V
    //   1196: return
    //   1197: iconst_0
    //   1198: istore_3
    //   1199: goto -61 -> 1138
    //   1202: iload 4
    //   1204: istore 6
    //   1206: lload 16
    //   1208: lstore 20
    //   1210: iload 4
    //   1212: istore 5
    //   1214: lload 16
    //   1216: lstore 18
    //   1218: aload 32
    //   1220: astore 29
    //   1222: aload_1
    //   1223: ldc_w 760
    //   1226: aload_1
    //   1227: invokevirtual 144	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   1230: invokevirtual 762	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1233: iload 4
    //   1235: istore 6
    //   1237: lload 16
    //   1239: lstore 20
    //   1241: iload 4
    //   1243: istore 5
    //   1245: lload 16
    //   1247: lstore 18
    //   1249: aload 32
    //   1251: astore 29
    //   1253: aload_1
    //   1254: aload 26
    //   1256: invokevirtual 763	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)V
    //   1259: iload 4
    //   1261: istore 6
    //   1263: lload 16
    //   1265: lstore 20
    //   1267: iload 4
    //   1269: istore 5
    //   1271: lload 16
    //   1273: lstore 18
    //   1275: aload 32
    //   1277: astore 29
    //   1279: aload_1
    //   1280: ldc_w 765
    //   1283: invokevirtual 767	com/tencent/mobileqq/utils/httputils/HttpMsg:c	(Ljava/lang/String;)V
    //   1286: iload 7
    //   1288: iconst_1
    //   1289: iadd
    //   1290: istore 7
    //   1292: iconst_1
    //   1293: istore 12
    //   1295: aload 24
    //   1297: astore 26
    //   1299: aload 27
    //   1301: astore 24
    //   1303: goto -1238 -> 65
    //   1306: iload 4
    //   1308: istore 6
    //   1310: lload 16
    //   1312: lstore 20
    //   1314: iload 4
    //   1316: istore 5
    //   1318: lload 16
    //   1320: lstore 18
    //   1322: aload 32
    //   1324: astore 29
    //   1326: new 471	java/io/IOException
    //   1329: dup
    //   1330: ldc_w 769
    //   1333: invokespecial 474	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1336: athrow
    //   1337: astore 29
    //   1339: iconst_1
    //   1340: istore_3
    //   1341: aload 25
    //   1343: astore 30
    //   1345: aconst_null
    //   1346: astore 28
    //   1348: aconst_null
    //   1349: astore 26
    //   1351: lload 14
    //   1353: lstore 16
    //   1355: lload 20
    //   1357: lstore 14
    //   1359: iconst_0
    //   1360: istore 5
    //   1362: iload 6
    //   1364: istore 4
    //   1366: aload 24
    //   1368: astore 25
    //   1370: aload 30
    //   1372: astore 24
    //   1374: iconst_1
    //   1375: istore 6
    //   1377: aload_0
    //   1378: iload_3
    //   1379: iload 4
    //   1381: aload 24
    //   1383: aload_1
    //   1384: aload 29
    //   1386: invokevirtual 772	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ZILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/Throwable;)V
    //   1389: iload_3
    //   1390: ifeq +48 -> 1438
    //   1393: iload 4
    //   1395: sipush 200
    //   1398: if_icmpeq +11 -> 1409
    //   1401: iload 4
    //   1403: sipush 206
    //   1406: if_icmpne +32 -> 1438
    //   1409: aload_0
    //   1410: aload_1
    //   1411: ldc_w 718
    //   1414: new 168	java/lang/StringBuilder
    //   1417: dup
    //   1418: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1421: ldc_w 720
    //   1424: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: iload 5
    //   1429: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1432: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1435: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1438: aload_2
    //   1439: ifnull +13 -> 1452
    //   1442: aload_2
    //   1443: getfield 699	hen:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1446: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1449: ifne +101 -> 1550
    //   1452: aload_0
    //   1453: aload_1
    //   1454: ldc_w 722
    //   1457: new 168	java/lang/StringBuilder
    //   1460: dup
    //   1461: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1464: ldc_w 724
    //   1467: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1470: aload_1
    //   1471: invokevirtual 726	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   1474: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1477: ldc_w 728
    //   1480: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: aload_1
    //   1484: invokevirtual 144	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   1487: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1493: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1496: aload_1
    //   1497: getfield 774	com/tencent/mobileqq/utils/httputils/HttpMsg:h	I
    //   1500: sipush -9527
    //   1503: if_icmpne +47 -> 1550
    //   1506: aload_0
    //   1507: aload_1
    //   1508: ldc_w 776
    //   1511: new 168	java/lang/StringBuilder
    //   1514: dup
    //   1515: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1518: ldc_w 751
    //   1521: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: aload_1
    //   1525: getfield 381	com/tencent/mobileqq/utils/httputils/HttpMsg:af	Ljava/lang/String;
    //   1528: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: ldc_w 753
    //   1534: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: aload_1
    //   1538: getfield 533	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   1541: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1547: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1550: aload_0
    //   1551: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1554: ifnull +17 -> 1571
    //   1557: aload 25
    //   1559: ifnull +12 -> 1571
    //   1562: aload_0
    //   1563: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1566: aload 25
    //   1568: invokevirtual 732	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1571: lload 16
    //   1573: lload 14
    //   1575: ladd
    //   1576: lstore 14
    //   1578: lload 14
    //   1580: lconst_0
    //   1581: lcmp
    //   1582: ifeq +26 -> 1608
    //   1585: aload_1
    //   1586: invokevirtual 268	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   1589: ldc_w 266
    //   1592: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1595: ifeq +2152 -> 3747
    //   1598: iconst_1
    //   1599: istore_3
    //   1600: aload_0
    //   1601: aload_1
    //   1602: iload_3
    //   1603: lload 14
    //   1605: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1608: aload 26
    //   1610: ifnull +8 -> 1618
    //   1613: aload 26
    //   1615: invokevirtual 779	java/io/ByteArrayOutputStream:close	()V
    //   1618: aload 28
    //   1620: ifnull +8 -> 1628
    //   1623: aload 28
    //   1625: invokevirtual 782	java/io/InputStream:close	()V
    //   1628: aload 27
    //   1630: ifnull +8 -> 1638
    //   1633: aload 27
    //   1635: invokevirtual 740	java/io/OutputStream:close	()V
    //   1638: iload 6
    //   1640: istore 4
    //   1642: aload 24
    //   1644: ifnull +12 -> 1656
    //   1647: aload 24
    //   1649: invokevirtual 743	java/net/HttpURLConnection:disconnect	()V
    //   1652: iload 6
    //   1654: istore 4
    //   1656: aload_2
    //   1657: ifnull +13 -> 1670
    //   1660: aload_2
    //   1661: getfield 699	hen:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1664: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1667: ifne -1018 -> 649
    //   1670: aload_1
    //   1671: getfield 621	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1674: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1677: ifne -1028 -> 649
    //   1680: iload 4
    //   1682: ifeq +2097 -> 3779
    //   1685: aload 35
    //   1687: aload_1
    //   1688: aload_1
    //   1689: invokeinterface 421 3 0
    //   1694: return
    //   1695: astore_2
    //   1696: aload_0
    //   1697: aload_1
    //   1698: ldc_w 784
    //   1701: aload_2
    //   1702: invokestatic 790	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1705: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1708: return
    //   1709: iload 4
    //   1711: istore 6
    //   1713: lload 16
    //   1715: lstore 20
    //   1717: iload 4
    //   1719: istore 5
    //   1721: lload 16
    //   1723: lstore 18
    //   1725: aload 32
    //   1727: astore 29
    //   1729: new 137	java/lang/Exception
    //   1732: dup
    //   1733: ldc_w 792
    //   1736: invokespecial 439	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1739: athrow
    //   1740: astore 30
    //   1742: iconst_0
    //   1743: istore 4
    //   1745: aload 29
    //   1747: astore 28
    //   1749: aload 31
    //   1751: astore 29
    //   1753: lload 18
    //   1755: lstore 16
    //   1757: iload 12
    //   1759: istore_3
    //   1760: iload 8
    //   1762: istore 6
    //   1764: aload 24
    //   1766: astore 26
    //   1768: aload 30
    //   1770: astore 24
    //   1772: iload_3
    //   1773: ifeq +48 -> 1821
    //   1776: iload 5
    //   1778: sipush 200
    //   1781: if_icmpeq +11 -> 1792
    //   1784: iload 5
    //   1786: sipush 206
    //   1789: if_icmpne +32 -> 1821
    //   1792: aload_0
    //   1793: aload_1
    //   1794: ldc_w 718
    //   1797: new 168	java/lang/StringBuilder
    //   1800: dup
    //   1801: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1804: ldc_w 720
    //   1807: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1810: iload 6
    //   1812: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1815: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1818: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1821: aload_2
    //   1822: ifnull +13 -> 1835
    //   1825: aload_2
    //   1826: getfield 699	hen:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1829: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1832: ifne +106 -> 1938
    //   1835: aload_0
    //   1836: aload_1
    //   1837: ldc_w 722
    //   1840: new 168	java/lang/StringBuilder
    //   1843: dup
    //   1844: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1847: ldc_w 724
    //   1850: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1853: aload_1
    //   1854: invokevirtual 726	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   1857: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1860: ldc_w 728
    //   1863: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: aload_1
    //   1867: invokevirtual 144	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   1870: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1873: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1876: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1879: iload 4
    //   1881: ifeq +57 -> 1938
    //   1884: aload_1
    //   1885: getfield 774	com/tencent/mobileqq/utils/httputils/HttpMsg:h	I
    //   1888: sipush -9527
    //   1891: if_icmpne +47 -> 1938
    //   1894: aload_0
    //   1895: aload_1
    //   1896: ldc_w 776
    //   1899: new 168	java/lang/StringBuilder
    //   1902: dup
    //   1903: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1906: ldc_w 751
    //   1909: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1912: aload_1
    //   1913: getfield 381	com/tencent/mobileqq/utils/httputils/HttpMsg:af	Ljava/lang/String;
    //   1916: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: ldc_w 753
    //   1922: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1925: aload_1
    //   1926: getfield 533	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   1929: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1932: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1935: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1938: aload_0
    //   1939: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1942: ifnull +17 -> 1959
    //   1945: aload 26
    //   1947: ifnull +12 -> 1959
    //   1950: aload_0
    //   1951: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1954: aload 26
    //   1956: invokevirtual 732	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1959: lload 14
    //   1961: lload 16
    //   1963: ladd
    //   1964: lstore 14
    //   1966: lload 14
    //   1968: lconst_0
    //   1969: lcmp
    //   1970: ifeq +26 -> 1996
    //   1973: aload_1
    //   1974: invokevirtual 268	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   1977: ldc_w 266
    //   1980: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1983: ifeq +1783 -> 3766
    //   1986: iconst_1
    //   1987: istore_3
    //   1988: aload_0
    //   1989: aload_1
    //   1990: iload_3
    //   1991: lload 14
    //   1993: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1996: aload 29
    //   1998: ifnull +8 -> 2006
    //   2001: aload 29
    //   2003: invokevirtual 779	java/io/ByteArrayOutputStream:close	()V
    //   2006: aload 28
    //   2008: ifnull +8 -> 2016
    //   2011: aload 28
    //   2013: invokevirtual 782	java/io/InputStream:close	()V
    //   2016: aload 27
    //   2018: ifnull +8 -> 2026
    //   2021: aload 27
    //   2023: invokevirtual 740	java/io/OutputStream:close	()V
    //   2026: aload 25
    //   2028: ifnull +8 -> 2036
    //   2031: aload 25
    //   2033: invokevirtual 743	java/net/HttpURLConnection:disconnect	()V
    //   2036: aload 24
    //   2038: athrow
    //   2039: iload 4
    //   2041: istore 6
    //   2043: lload 16
    //   2045: lstore 20
    //   2047: iload 4
    //   2049: istore 5
    //   2051: lload 16
    //   2053: lstore 18
    //   2055: aload 32
    //   2057: astore 29
    //   2059: aload_0
    //   2060: aload_1
    //   2061: aconst_null
    //   2062: iconst_2
    //   2063: iload_3
    //   2064: invokespecial 641	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;IZ)V
    //   2067: iload 4
    //   2069: sipush 200
    //   2072: if_icmpeq +11 -> 2083
    //   2075: iload 4
    //   2077: sipush 206
    //   2080: if_icmpne +1624 -> 3704
    //   2083: iload 4
    //   2085: istore 6
    //   2087: lload 16
    //   2089: lstore 20
    //   2091: iload 4
    //   2093: istore 5
    //   2095: lload 16
    //   2097: lstore 18
    //   2099: aload 32
    //   2101: astore 29
    //   2103: aload 25
    //   2105: invokevirtual 525	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2108: astore 26
    //   2110: aload 26
    //   2112: ifnonnull +421 -> 2533
    //   2115: ldc_w 614
    //   2118: astore 26
    //   2120: iload_3
    //   2121: ifne +442 -> 2563
    //   2124: iload 4
    //   2126: istore 6
    //   2128: lload 16
    //   2130: lstore 20
    //   2132: iload 4
    //   2134: istore 5
    //   2136: lload 16
    //   2138: lstore 18
    //   2140: aload 32
    //   2142: astore 29
    //   2144: aload_1
    //   2145: getfield 793	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_b_of_type_Boolean	Z
    //   2148: ifeq +415 -> 2563
    //   2151: iload 4
    //   2153: istore 6
    //   2155: lload 16
    //   2157: lstore 20
    //   2159: iload 4
    //   2161: istore 5
    //   2163: lload 16
    //   2165: lstore 18
    //   2167: aload 32
    //   2169: astore 29
    //   2171: aload 26
    //   2173: ldc_w 795
    //   2176: invokevirtual 162	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2179: iconst_m1
    //   2180: if_icmpne +35 -> 2215
    //   2183: iload 4
    //   2185: istore 6
    //   2187: lload 16
    //   2189: lstore 20
    //   2191: iload 4
    //   2193: istore 5
    //   2195: lload 16
    //   2197: lstore 18
    //   2199: aload 32
    //   2201: astore 29
    //   2203: aload 26
    //   2205: ldc_w 797
    //   2208: invokevirtual 162	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2211: iconst_m1
    //   2212: if_icmpeq +351 -> 2563
    //   2215: iload 4
    //   2217: istore 6
    //   2219: lload 16
    //   2221: lstore 20
    //   2223: iload 4
    //   2225: istore 5
    //   2227: lload 16
    //   2229: lstore 18
    //   2231: aload 32
    //   2233: astore 29
    //   2235: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2238: ifeq +58 -> 2296
    //   2241: iload 4
    //   2243: istore 6
    //   2245: lload 16
    //   2247: lstore 20
    //   2249: iload 4
    //   2251: istore 5
    //   2253: lload 16
    //   2255: lstore 18
    //   2257: aload 32
    //   2259: astore 29
    //   2261: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2264: ifeq +32 -> 2296
    //   2267: iload 4
    //   2269: istore 6
    //   2271: lload 16
    //   2273: lstore 20
    //   2275: iload 4
    //   2277: istore 5
    //   2279: lload 16
    //   2281: lstore 18
    //   2283: aload 32
    //   2285: astore 29
    //   2287: ldc 19
    //   2289: iconst_2
    //   2290: ldc_w 799
    //   2293: invokestatic 413	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2296: iload 4
    //   2298: istore 6
    //   2300: lload 16
    //   2302: lstore 20
    //   2304: iload 4
    //   2306: istore 5
    //   2308: lload 16
    //   2310: lstore 18
    //   2312: aload 32
    //   2314: astore 29
    //   2316: aload_0
    //   2317: aload_1
    //   2318: aload_2
    //   2319: iconst_1
    //   2320: invokevirtual 801	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lhen;Z)V
    //   2323: iload 4
    //   2325: sipush 200
    //   2328: if_icmpeq +11 -> 2339
    //   2331: iload 4
    //   2333: sipush 206
    //   2336: if_icmpne +31 -> 2367
    //   2339: aload_0
    //   2340: aload_1
    //   2341: ldc_w 718
    //   2344: new 168	java/lang/StringBuilder
    //   2347: dup
    //   2348: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   2351: ldc_w 720
    //   2354: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2357: iconst_0
    //   2358: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2361: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2364: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2367: aload_2
    //   2368: ifnull +13 -> 2381
    //   2371: aload_2
    //   2372: getfield 699	hen:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2375: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2378: ifne +47 -> 2425
    //   2381: aload_0
    //   2382: aload_1
    //   2383: ldc_w 722
    //   2386: new 168	java/lang/StringBuilder
    //   2389: dup
    //   2390: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   2393: ldc_w 724
    //   2396: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2399: aload_1
    //   2400: invokevirtual 726	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   2403: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2406: ldc_w 728
    //   2409: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2412: aload_1
    //   2413: invokevirtual 144	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   2416: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2419: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2422: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2425: aload_0
    //   2426: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   2429: ifnull +17 -> 2446
    //   2432: aload 24
    //   2434: ifnull +12 -> 2446
    //   2437: aload_0
    //   2438: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   2441: aload 24
    //   2443: invokevirtual 732	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   2446: lload 14
    //   2448: lconst_0
    //   2449: ladd
    //   2450: lstore 14
    //   2452: lload 14
    //   2454: lconst_0
    //   2455: lcmp
    //   2456: ifeq +26 -> 2482
    //   2459: aload_1
    //   2460: invokevirtual 268	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   2463: ldc_w 266
    //   2466: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2469: ifeq +2223 -> 4692
    //   2472: iconst_1
    //   2473: istore_3
    //   2474: aload_0
    //   2475: aload_1
    //   2476: iload_3
    //   2477: lload 14
    //   2479: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   2482: iconst_0
    //   2483: ifeq +11 -> 2494
    //   2486: new 737	java/lang/NullPointerException
    //   2489: dup
    //   2490: invokespecial 738	java/lang/NullPointerException:<init>	()V
    //   2493: athrow
    //   2494: iconst_0
    //   2495: ifeq +11 -> 2506
    //   2498: new 737	java/lang/NullPointerException
    //   2501: dup
    //   2502: invokespecial 738	java/lang/NullPointerException:<init>	()V
    //   2505: athrow
    //   2506: aload 27
    //   2508: ifnull +8 -> 2516
    //   2511: aload 27
    //   2513: invokevirtual 740	java/io/OutputStream:close	()V
    //   2516: aload 25
    //   2518: ifnull -1869 -> 649
    //   2521: aload 25
    //   2523: invokevirtual 743	java/net/HttpURLConnection:disconnect	()V
    //   2526: return
    //   2527: astore_1
    //   2528: aload_1
    //   2529: invokevirtual 589	java/lang/Exception:printStackTrace	()V
    //   2532: return
    //   2533: iload 4
    //   2535: istore 6
    //   2537: lload 16
    //   2539: lstore 20
    //   2541: iload 4
    //   2543: istore 5
    //   2545: lload 16
    //   2547: lstore 18
    //   2549: aload 32
    //   2551: astore 29
    //   2553: aload 26
    //   2555: invokevirtual 804	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2558: astore 26
    //   2560: goto -440 -> 2120
    //   2563: iload 4
    //   2565: istore 6
    //   2567: lload 16
    //   2569: lstore 20
    //   2571: iload 4
    //   2573: istore 5
    //   2575: lload 16
    //   2577: lstore 18
    //   2579: aload 32
    //   2581: astore 29
    //   2583: aload_1
    //   2584: getfield 557	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_Long	J
    //   2587: lconst_0
    //   2588: lcmp
    //   2589: ifne +66 -> 2655
    //   2592: iload 4
    //   2594: istore 6
    //   2596: lload 16
    //   2598: lstore 20
    //   2600: iload 4
    //   2602: istore 5
    //   2604: lload 16
    //   2606: lstore 18
    //   2608: aload 32
    //   2610: astore 29
    //   2612: aload_1
    //   2613: invokevirtual 268	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   2616: ldc_w 266
    //   2619: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2622: ifne +33 -> 2655
    //   2625: iload 4
    //   2627: istore 6
    //   2629: lload 16
    //   2631: lstore 20
    //   2633: iload 4
    //   2635: istore 5
    //   2637: lload 16
    //   2639: lstore 18
    //   2641: aload 32
    //   2643: astore 29
    //   2645: new 471	java/io/IOException
    //   2648: dup
    //   2649: ldc 22
    //   2651: invokespecial 474	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2654: athrow
    //   2655: iload 4
    //   2657: istore 6
    //   2659: lload 16
    //   2661: lstore 20
    //   2663: iload 4
    //   2665: istore 5
    //   2667: lload 16
    //   2669: lstore 18
    //   2671: aload 32
    //   2673: astore 29
    //   2675: aload_0
    //   2676: aload_1
    //   2677: ldc_w 806
    //   2680: new 168	java/lang/StringBuilder
    //   2683: dup
    //   2684: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   2687: ldc_w 808
    //   2690: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2693: aload_1
    //   2694: getfield 557	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_Long	J
    //   2697: invokevirtual 584	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2700: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2703: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2706: iload 4
    //   2708: istore 6
    //   2710: lload 16
    //   2712: lstore 20
    //   2714: iload 4
    //   2716: istore 5
    //   2718: lload 16
    //   2720: lstore 18
    //   2722: aload 32
    //   2724: astore 29
    //   2726: aload_1
    //   2727: getfield 658	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_Long	J
    //   2730: lconst_0
    //   2731: lcmp
    //   2732: ifeq +35 -> 2767
    //   2735: iload 4
    //   2737: istore 6
    //   2739: lload 16
    //   2741: lstore 20
    //   2743: iload 4
    //   2745: istore 5
    //   2747: lload 16
    //   2749: lstore 18
    //   2751: aload 32
    //   2753: astore 29
    //   2755: aload_1
    //   2756: invokestatic 656	android/os/SystemClock:uptimeMillis	()J
    //   2759: aload_1
    //   2760: getfield 658	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_Long	J
    //   2763: lsub
    //   2764: putfield 810	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_e_of_type_Long	J
    //   2767: iload 4
    //   2769: istore 6
    //   2771: lload 16
    //   2773: lstore 20
    //   2775: iload 4
    //   2777: istore 5
    //   2779: lload 16
    //   2781: lstore 18
    //   2783: aload 32
    //   2785: astore 29
    //   2787: aload 35
    //   2789: aload_1
    //   2790: aload_1
    //   2791: iconst_3
    //   2792: invokeinterface 407 4 0
    //   2797: ifeq +1872 -> 4669
    //   2800: lconst_0
    //   2801: ldc2_w 710
    //   2804: ladd
    //   2805: lstore 16
    //   2807: iload 4
    //   2809: istore 6
    //   2811: lload 16
    //   2813: lstore 20
    //   2815: iload 4
    //   2817: istore 5
    //   2819: lload 16
    //   2821: lstore 18
    //   2823: aload 32
    //   2825: astore 29
    //   2827: aload 25
    //   2829: invokevirtual 814	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2832: astore 28
    //   2834: iload 4
    //   2836: istore 5
    //   2838: lload 16
    //   2840: lstore 18
    //   2842: aload 28
    //   2844: astore 29
    //   2846: new 778	java/io/ByteArrayOutputStream
    //   2849: dup
    //   2850: invokespecial 815	java/io/ByteArrayOutputStream:<init>	()V
    //   2853: astore 26
    //   2855: sipush 10240
    //   2858: newarray byte
    //   2860: astore 29
    //   2862: iconst_0
    //   2863: istore 5
    //   2865: iconst_0
    //   2866: istore 6
    //   2868: iload 5
    //   2870: istore 8
    //   2872: lload 16
    //   2874: lstore 18
    //   2876: iload 5
    //   2878: istore 7
    //   2880: lload 16
    //   2882: lstore 22
    //   2884: aload 28
    //   2886: aload 29
    //   2888: iload 6
    //   2890: aload 29
    //   2892: arraylength
    //   2893: iload 6
    //   2895: isub
    //   2896: invokevirtual 819	java/io/InputStream:read	([BII)I
    //   2899: istore 9
    //   2901: iload 9
    //   2903: ifle +204 -> 3107
    //   2906: iload 5
    //   2908: istore 8
    //   2910: lload 16
    //   2912: lstore 18
    //   2914: iload 5
    //   2916: istore 7
    //   2918: lload 16
    //   2920: lstore 22
    //   2922: aload_0
    //   2923: aload_2
    //   2924: aload_1
    //   2925: invokevirtual 646	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lhen;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   2928: lload 16
    //   2930: iload 9
    //   2932: i2l
    //   2933: ladd
    //   2934: lstore 20
    //   2936: iload 6
    //   2938: iload 9
    //   2940: iadd
    //   2941: istore 11
    //   2943: iload 5
    //   2945: iload 9
    //   2947: iadd
    //   2948: istore 9
    //   2950: iload 9
    //   2952: istore 5
    //   2954: iload 11
    //   2956: istore 6
    //   2958: lload 20
    //   2960: lstore 16
    //   2962: iload 9
    //   2964: istore 8
    //   2966: lload 20
    //   2968: lstore 18
    //   2970: iload 9
    //   2972: istore 7
    //   2974: lload 20
    //   2976: lstore 22
    //   2978: iload 11
    //   2980: aload 29
    //   2982: arraylength
    //   2983: if_icmplt -115 -> 2868
    //   2986: iload 9
    //   2988: istore 8
    //   2990: lload 20
    //   2992: lstore 18
    //   2994: iload 9
    //   2996: istore 7
    //   2998: lload 20
    //   3000: lstore 22
    //   3002: aload_1
    //   3003: invokevirtual 821	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Z
    //   3006: ifeq +64 -> 3070
    //   3009: iload 9
    //   3011: istore 8
    //   3013: lload 20
    //   3015: lstore 18
    //   3017: iload 9
    //   3019: istore 7
    //   3021: lload 20
    //   3023: lstore 22
    //   3025: aload_1
    //   3026: aload 29
    //   3028: invokevirtual 824	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   3031: iload 9
    //   3033: istore 8
    //   3035: lload 20
    //   3037: lstore 18
    //   3039: iload 9
    //   3041: istore 7
    //   3043: lload 20
    //   3045: lstore 22
    //   3047: aload 35
    //   3049: aload_1
    //   3050: aload_1
    //   3051: invokeinterface 826 3 0
    //   3056: iconst_0
    //   3057: istore 6
    //   3059: iload 9
    //   3061: istore 5
    //   3063: lload 20
    //   3065: lstore 16
    //   3067: goto -199 -> 2868
    //   3070: iload 9
    //   3072: istore 8
    //   3074: lload 20
    //   3076: lstore 18
    //   3078: iload 9
    //   3080: istore 7
    //   3082: lload 20
    //   3084: lstore 22
    //   3086: aload 26
    //   3088: aload 29
    //   3090: invokevirtual 828	java/io/ByteArrayOutputStream:write	([B)V
    //   3093: iconst_0
    //   3094: istore 6
    //   3096: iload 9
    //   3098: istore 5
    //   3100: lload 20
    //   3102: lstore 16
    //   3104: goto -236 -> 2868
    //   3107: iload 5
    //   3109: istore 8
    //   3111: lload 16
    //   3113: lstore 18
    //   3115: iload 5
    //   3117: istore 7
    //   3119: lload 16
    //   3121: lstore 22
    //   3123: aload_1
    //   3124: invokevirtual 821	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Z
    //   3127: ifeq +441 -> 3568
    //   3130: iload 6
    //   3132: ifle +99 -> 3231
    //   3135: iload 5
    //   3137: istore 8
    //   3139: lload 16
    //   3141: lstore 18
    //   3143: iload 5
    //   3145: istore 7
    //   3147: lload 16
    //   3149: lstore 22
    //   3151: iload 6
    //   3153: newarray byte
    //   3155: astore 30
    //   3157: iload 5
    //   3159: istore 8
    //   3161: lload 16
    //   3163: lstore 18
    //   3165: iload 5
    //   3167: istore 7
    //   3169: lload 16
    //   3171: lstore 22
    //   3173: aload 29
    //   3175: iconst_0
    //   3176: aload 30
    //   3178: iconst_0
    //   3179: iload 6
    //   3181: invokestatic 832	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3184: iload 5
    //   3186: istore 8
    //   3188: lload 16
    //   3190: lstore 18
    //   3192: iload 5
    //   3194: istore 7
    //   3196: lload 16
    //   3198: lstore 22
    //   3200: aload_1
    //   3201: aload 30
    //   3203: invokevirtual 824	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   3206: iload 5
    //   3208: istore 8
    //   3210: lload 16
    //   3212: lstore 18
    //   3214: iload 5
    //   3216: istore 7
    //   3218: lload 16
    //   3220: lstore 22
    //   3222: aload 35
    //   3224: aload_1
    //   3225: aload_1
    //   3226: invokeinterface 826 3 0
    //   3231: iload 5
    //   3233: istore 8
    //   3235: lload 16
    //   3237: lstore 18
    //   3239: iload 5
    //   3241: istore 7
    //   3243: lload 16
    //   3245: lstore 22
    //   3247: aload 26
    //   3249: invokevirtual 779	java/io/ByteArrayOutputStream:close	()V
    //   3252: aload 26
    //   3254: astore 29
    //   3256: aload 28
    //   3258: astore 26
    //   3260: aload 29
    //   3262: astore 28
    //   3264: aload 35
    //   3266: aload_1
    //   3267: aload_1
    //   3268: iconst_4
    //   3269: invokeinterface 407 4 0
    //   3274: pop
    //   3275: iload 5
    //   3277: istore 6
    //   3279: iload 10
    //   3281: istore 5
    //   3283: iload 4
    //   3285: sipush 200
    //   3288: if_icmpeq +11 -> 3299
    //   3291: iload 4
    //   3293: sipush 206
    //   3296: if_icmpne +32 -> 3328
    //   3299: aload_0
    //   3300: aload_1
    //   3301: ldc_w 718
    //   3304: new 168	java/lang/StringBuilder
    //   3307: dup
    //   3308: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   3311: ldc_w 720
    //   3314: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3317: iload 6
    //   3319: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3322: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3325: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3328: aload_2
    //   3329: ifnull +13 -> 3342
    //   3332: aload_2
    //   3333: getfield 699	hen:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3336: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3339: ifne +106 -> 3445
    //   3342: aload_0
    //   3343: aload_1
    //   3344: ldc_w 722
    //   3347: new 168	java/lang/StringBuilder
    //   3350: dup
    //   3351: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   3354: ldc_w 724
    //   3357: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3360: aload_1
    //   3361: invokevirtual 726	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   3364: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3367: ldc_w 728
    //   3370: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3373: aload_1
    //   3374: invokevirtual 144	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   3377: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3380: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3383: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3386: iload 5
    //   3388: ifeq +57 -> 3445
    //   3391: aload_1
    //   3392: getfield 774	com/tencent/mobileqq/utils/httputils/HttpMsg:h	I
    //   3395: sipush -9527
    //   3398: if_icmpne +47 -> 3445
    //   3401: aload_0
    //   3402: aload_1
    //   3403: ldc_w 776
    //   3406: new 168	java/lang/StringBuilder
    //   3409: dup
    //   3410: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   3413: ldc_w 751
    //   3416: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3419: aload_1
    //   3420: getfield 381	com/tencent/mobileqq/utils/httputils/HttpMsg:af	Ljava/lang/String;
    //   3423: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3426: ldc_w 753
    //   3429: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3432: aload_1
    //   3433: getfield 533	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   3436: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3439: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3442: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3445: aload_0
    //   3446: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   3449: ifnull +17 -> 3466
    //   3452: aload 24
    //   3454: ifnull +12 -> 3466
    //   3457: aload_0
    //   3458: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   3461: aload 24
    //   3463: invokevirtual 732	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3466: lload 14
    //   3468: lload 16
    //   3470: ladd
    //   3471: lstore 14
    //   3473: lload 14
    //   3475: lconst_0
    //   3476: lcmp
    //   3477: ifeq +26 -> 3503
    //   3480: aload_1
    //   3481: invokevirtual 268	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   3484: ldc_w 266
    //   3487: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3490: ifeq +252 -> 3742
    //   3493: iconst_1
    //   3494: istore_3
    //   3495: aload_0
    //   3496: aload_1
    //   3497: iload_3
    //   3498: lload 14
    //   3500: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   3503: aload 28
    //   3505: ifnull +8 -> 3513
    //   3508: aload 28
    //   3510: invokevirtual 779	java/io/ByteArrayOutputStream:close	()V
    //   3513: aload 26
    //   3515: ifnull +8 -> 3523
    //   3518: aload 26
    //   3520: invokevirtual 782	java/io/InputStream:close	()V
    //   3523: aload 27
    //   3525: ifnull +8 -> 3533
    //   3528: aload 27
    //   3530: invokevirtual 740	java/io/OutputStream:close	()V
    //   3533: iload 5
    //   3535: istore 4
    //   3537: aload 25
    //   3539: ifnull -1883 -> 1656
    //   3542: aload 25
    //   3544: invokevirtual 743	java/net/HttpURLConnection:disconnect	()V
    //   3547: iload 5
    //   3549: istore 4
    //   3551: goto -1895 -> 1656
    //   3554: astore 24
    //   3556: aload 24
    //   3558: invokevirtual 589	java/lang/Exception:printStackTrace	()V
    //   3561: iload 5
    //   3563: istore 4
    //   3565: goto -1909 -> 1656
    //   3568: iload 6
    //   3570: ifle +29 -> 3599
    //   3573: iload 5
    //   3575: istore 8
    //   3577: lload 16
    //   3579: lstore 18
    //   3581: iload 5
    //   3583: istore 7
    //   3585: lload 16
    //   3587: lstore 22
    //   3589: aload 26
    //   3591: aload 29
    //   3593: iconst_0
    //   3594: iload 6
    //   3596: invokevirtual 833	java/io/ByteArrayOutputStream:write	([BII)V
    //   3599: iload 5
    //   3601: istore 8
    //   3603: lload 16
    //   3605: lstore 18
    //   3607: iload 5
    //   3609: istore 7
    //   3611: lload 16
    //   3613: lstore 22
    //   3615: aload 26
    //   3617: invokevirtual 834	java/io/ByteArrayOutputStream:flush	()V
    //   3620: iload 5
    //   3622: istore 8
    //   3624: lload 16
    //   3626: lstore 18
    //   3628: iload 5
    //   3630: istore 7
    //   3632: lload 16
    //   3634: lstore 22
    //   3636: aload_1
    //   3637: aload 26
    //   3639: invokevirtual 837	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   3642: invokevirtual 824	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   3645: iload 5
    //   3647: istore 8
    //   3649: lload 16
    //   3651: lstore 18
    //   3653: iload 5
    //   3655: istore 7
    //   3657: lload 16
    //   3659: lstore 22
    //   3661: aload 35
    //   3663: aload_1
    //   3664: aload_1
    //   3665: invokeinterface 826 3 0
    //   3670: goto -439 -> 3231
    //   3673: astore 29
    //   3675: iconst_1
    //   3676: istore_3
    //   3677: lload 14
    //   3679: lstore 16
    //   3681: lload 18
    //   3683: lstore 14
    //   3685: aload 24
    //   3687: astore 30
    //   3689: iload 8
    //   3691: istore 5
    //   3693: aload 25
    //   3695: astore 24
    //   3697: aload 30
    //   3699: astore 25
    //   3701: goto -2327 -> 1374
    //   3704: iconst_1
    //   3705: istore 7
    //   3707: iload 4
    //   3709: istore 6
    //   3711: lload 16
    //   3713: lstore 20
    //   3715: aload_0
    //   3716: iload 4
    //   3718: aload 25
    //   3720: aload_1
    //   3721: invokevirtual 839	com/tencent/mobileqq/utils/httputils/HttpCommunicator:b	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   3724: iconst_1
    //   3725: istore 5
    //   3727: iload 9
    //   3729: istore 6
    //   3731: aload 34
    //   3733: astore 28
    //   3735: aload 33
    //   3737: astore 26
    //   3739: goto -456 -> 3283
    //   3742: iconst_0
    //   3743: istore_3
    //   3744: goto -249 -> 3495
    //   3747: iconst_0
    //   3748: istore_3
    //   3749: goto -2149 -> 1600
    //   3752: astore 24
    //   3754: aload 24
    //   3756: invokevirtual 589	java/lang/Exception:printStackTrace	()V
    //   3759: iload 6
    //   3761: istore 4
    //   3763: goto -2107 -> 1656
    //   3766: iconst_0
    //   3767: istore_3
    //   3768: goto -1780 -> 1988
    //   3771: astore_1
    //   3772: aload_1
    //   3773: invokevirtual 589	java/lang/Exception:printStackTrace	()V
    //   3776: goto -1740 -> 2036
    //   3779: aload 35
    //   3781: aload_1
    //   3782: aload_1
    //   3783: iconst_5
    //   3784: invokeinterface 407 4 0
    //   3789: pop
    //   3790: return
    //   3791: astore_1
    //   3792: goto -3175 -> 617
    //   3795: astore_1
    //   3796: goto -3167 -> 629
    //   3799: astore_1
    //   3800: goto -3161 -> 639
    //   3803: astore_1
    //   3804: goto -2646 -> 1158
    //   3807: astore_1
    //   3808: goto -2638 -> 1170
    //   3811: astore_1
    //   3812: goto -2632 -> 1180
    //   3815: astore_1
    //   3816: goto -1322 -> 2494
    //   3819: astore_1
    //   3820: goto -1314 -> 2506
    //   3823: astore_1
    //   3824: goto -1308 -> 2516
    //   3827: astore 24
    //   3829: goto -316 -> 3513
    //   3832: astore 24
    //   3834: goto -311 -> 3523
    //   3837: astore 24
    //   3839: goto -306 -> 3533
    //   3842: astore 25
    //   3844: goto -2226 -> 1618
    //   3847: astore 25
    //   3849: goto -2221 -> 1628
    //   3852: astore 25
    //   3854: goto -2216 -> 1638
    //   3857: astore_1
    //   3858: goto -1852 -> 2006
    //   3861: astore_1
    //   3862: goto -1846 -> 2016
    //   3865: astore_1
    //   3866: goto -1840 -> 2026
    //   3869: astore 24
    //   3871: aconst_null
    //   3872: astore 27
    //   3874: aconst_null
    //   3875: astore 25
    //   3877: aconst_null
    //   3878: astore 26
    //   3880: iconst_0
    //   3881: istore 4
    //   3883: lconst_0
    //   3884: lstore 14
    //   3886: iconst_m1
    //   3887: istore 5
    //   3889: iconst_0
    //   3890: istore_3
    //   3891: iload 8
    //   3893: istore 6
    //   3895: aload 31
    //   3897: astore 29
    //   3899: aload 30
    //   3901: astore 28
    //   3903: goto -2131 -> 1772
    //   3906: astore 24
    //   3908: aload 26
    //   3910: astore 27
    //   3912: aload 28
    //   3914: astore 26
    //   3916: iconst_0
    //   3917: istore 7
    //   3919: iload 8
    //   3921: istore 6
    //   3923: iload 12
    //   3925: istore_3
    //   3926: iload 4
    //   3928: istore 5
    //   3930: iload 7
    //   3932: istore 4
    //   3934: aload 31
    //   3936: astore 29
    //   3938: aload 30
    //   3940: astore 28
    //   3942: goto -2170 -> 1772
    //   3945: astore 28
    //   3947: aload 24
    //   3949: astore 27
    //   3951: iload 12
    //   3953: istore_3
    //   3954: aload 28
    //   3956: astore 24
    //   3958: iconst_0
    //   3959: istore 7
    //   3961: iload 8
    //   3963: istore 6
    //   3965: iload 4
    //   3967: istore 5
    //   3969: iload 7
    //   3971: istore 4
    //   3973: aload 31
    //   3975: astore 29
    //   3977: aload 30
    //   3979: astore 28
    //   3981: goto -2209 -> 1772
    //   3984: astore 28
    //   3986: iconst_0
    //   3987: istore 7
    //   3989: aload 24
    //   3991: astore 27
    //   3993: iload 12
    //   3995: istore_3
    //   3996: aload 28
    //   3998: astore 24
    //   4000: iload 8
    //   4002: istore 6
    //   4004: iload 4
    //   4006: istore 5
    //   4008: iload 7
    //   4010: istore 4
    //   4012: aload 31
    //   4014: astore 29
    //   4016: aload 30
    //   4018: astore 28
    //   4020: goto -2248 -> 1772
    //   4023: astore 28
    //   4025: iconst_0
    //   4026: istore 7
    //   4028: aload 24
    //   4030: astore 27
    //   4032: aload 28
    //   4034: astore 24
    //   4036: iload 8
    //   4038: istore 6
    //   4040: iload 12
    //   4042: istore_3
    //   4043: iload 4
    //   4045: istore 5
    //   4047: iload 7
    //   4049: istore 4
    //   4051: aload 31
    //   4053: astore 29
    //   4055: aload 30
    //   4057: astore 28
    //   4059: goto -2287 -> 1772
    //   4062: astore 29
    //   4064: iconst_0
    //   4065: istore 7
    //   4067: aload 24
    //   4069: astore 27
    //   4071: aload 28
    //   4073: astore 26
    //   4075: aload 29
    //   4077: astore 24
    //   4079: iload 8
    //   4081: istore 6
    //   4083: iload 12
    //   4085: istore_3
    //   4086: iload 4
    //   4088: istore 5
    //   4090: iload 7
    //   4092: istore 4
    //   4094: aload 31
    //   4096: astore 29
    //   4098: aload 30
    //   4100: astore 28
    //   4102: goto -2330 -> 1772
    //   4105: astore 30
    //   4107: iconst_0
    //   4108: istore 7
    //   4110: aload 26
    //   4112: astore 29
    //   4114: aload 24
    //   4116: astore 26
    //   4118: aload 30
    //   4120: astore 24
    //   4122: iload 8
    //   4124: istore 6
    //   4126: iload 12
    //   4128: istore_3
    //   4129: iload 4
    //   4131: istore 5
    //   4133: iload 7
    //   4135: istore 4
    //   4137: goto -2365 -> 1772
    //   4140: astore 30
    //   4142: iconst_0
    //   4143: istore 8
    //   4145: aload 26
    //   4147: astore 29
    //   4149: aload 24
    //   4151: astore 26
    //   4153: aload 30
    //   4155: astore 24
    //   4157: iload 7
    //   4159: istore 6
    //   4161: iload 12
    //   4163: istore_3
    //   4164: iload 4
    //   4166: istore 5
    //   4168: iload 8
    //   4170: istore 4
    //   4172: lload 22
    //   4174: lstore 16
    //   4176: goto -2404 -> 1772
    //   4179: astore 29
    //   4181: aload 26
    //   4183: astore 30
    //   4185: aload 24
    //   4187: astore 26
    //   4189: aload 29
    //   4191: astore 24
    //   4193: iconst_0
    //   4194: istore 7
    //   4196: iload 5
    //   4198: istore 6
    //   4200: iload 12
    //   4202: istore_3
    //   4203: iload 4
    //   4205: istore 5
    //   4207: iload 7
    //   4209: istore 4
    //   4211: aload 28
    //   4213: astore 29
    //   4215: aload 30
    //   4217: astore 28
    //   4219: goto -2447 -> 1772
    //   4222: astore 28
    //   4224: aload 24
    //   4226: astore 26
    //   4228: aload 28
    //   4230: astore 24
    //   4232: iload 8
    //   4234: istore 6
    //   4236: iload 12
    //   4238: istore_3
    //   4239: iload 4
    //   4241: istore 5
    //   4243: iload 7
    //   4245: istore 4
    //   4247: aload 31
    //   4249: astore 29
    //   4251: aload 30
    //   4253: astore 28
    //   4255: goto -2483 -> 1772
    //   4258: astore 31
    //   4260: iconst_1
    //   4261: istore 7
    //   4263: lload 16
    //   4265: lstore 18
    //   4267: aload 26
    //   4269: astore 29
    //   4271: aload 24
    //   4273: astore 30
    //   4275: aload 31
    //   4277: astore 24
    //   4279: aload 25
    //   4281: astore 26
    //   4283: iload 5
    //   4285: istore 6
    //   4287: iload 4
    //   4289: istore 5
    //   4291: iload 7
    //   4293: istore 4
    //   4295: lload 14
    //   4297: lstore 16
    //   4299: lload 18
    //   4301: lstore 14
    //   4303: aload 30
    //   4305: astore 25
    //   4307: goto -2535 -> 1772
    //   4310: astore 29
    //   4312: aconst_null
    //   4313: astore 26
    //   4315: aconst_null
    //   4316: astore 28
    //   4318: aconst_null
    //   4319: astore 27
    //   4321: aconst_null
    //   4322: astore 24
    //   4324: lconst_0
    //   4325: lstore 16
    //   4327: aconst_null
    //   4328: astore 25
    //   4330: iconst_0
    //   4331: istore 5
    //   4333: iconst_m1
    //   4334: istore 4
    //   4336: lconst_0
    //   4337: lstore 14
    //   4339: iload 12
    //   4341: istore_3
    //   4342: goto -2968 -> 1374
    //   4345: astore 29
    //   4347: aconst_null
    //   4348: astore 31
    //   4350: lload 14
    //   4352: lstore 16
    //   4354: lconst_0
    //   4355: lstore 14
    //   4357: iconst_0
    //   4358: istore 5
    //   4360: aload 25
    //   4362: astore 24
    //   4364: aconst_null
    //   4365: astore 30
    //   4367: aload 26
    //   4369: astore 27
    //   4371: iconst_1
    //   4372: istore_3
    //   4373: aload 28
    //   4375: astore 25
    //   4377: aload 31
    //   4379: astore 26
    //   4381: aload 30
    //   4383: astore 28
    //   4385: goto -3011 -> 1374
    //   4388: astore 29
    //   4390: aconst_null
    //   4391: astore 30
    //   4393: aconst_null
    //   4394: astore 28
    //   4396: aload 24
    //   4398: astore 27
    //   4400: lload 14
    //   4402: lstore 16
    //   4404: lconst_0
    //   4405: lstore 14
    //   4407: iconst_0
    //   4408: istore 5
    //   4410: iload 12
    //   4412: istore_3
    //   4413: aload 25
    //   4415: astore 24
    //   4417: aload 26
    //   4419: astore 25
    //   4421: aload 30
    //   4423: astore 26
    //   4425: goto -3051 -> 1374
    //   4428: astore 29
    //   4430: aconst_null
    //   4431: astore 30
    //   4433: aconst_null
    //   4434: astore 28
    //   4436: aload 24
    //   4438: astore 27
    //   4440: lload 14
    //   4442: lstore 16
    //   4444: lconst_0
    //   4445: lstore 14
    //   4447: iconst_0
    //   4448: istore 5
    //   4450: iload 12
    //   4452: istore_3
    //   4453: aload 25
    //   4455: astore 24
    //   4457: aload 26
    //   4459: astore 25
    //   4461: aload 30
    //   4463: astore 26
    //   4465: goto -3091 -> 1374
    //   4468: astore 29
    //   4470: aconst_null
    //   4471: astore 30
    //   4473: aconst_null
    //   4474: astore 28
    //   4476: aload 24
    //   4478: astore 27
    //   4480: lload 14
    //   4482: lstore 16
    //   4484: lconst_0
    //   4485: lstore 14
    //   4487: iconst_0
    //   4488: istore 5
    //   4490: iconst_1
    //   4491: istore_3
    //   4492: aload 25
    //   4494: astore 24
    //   4496: aload 26
    //   4498: astore 25
    //   4500: aload 30
    //   4502: astore 26
    //   4504: goto -3130 -> 1374
    //   4507: astore 29
    //   4509: iconst_1
    //   4510: istore_3
    //   4511: aconst_null
    //   4512: astore 26
    //   4514: aconst_null
    //   4515: astore 30
    //   4517: aload 24
    //   4519: astore 27
    //   4521: lload 14
    //   4523: lstore 16
    //   4525: lconst_0
    //   4526: lstore 14
    //   4528: iconst_0
    //   4529: istore 5
    //   4531: aload 25
    //   4533: astore 24
    //   4535: aload 28
    //   4537: astore 25
    //   4539: aload 30
    //   4541: astore 28
    //   4543: goto -3169 -> 1374
    //   4546: astore 29
    //   4548: iconst_1
    //   4549: istore_3
    //   4550: aconst_null
    //   4551: astore 30
    //   4553: lload 14
    //   4555: lstore 18
    //   4557: lload 16
    //   4559: lstore 14
    //   4561: aload 24
    //   4563: astore 26
    //   4565: iconst_0
    //   4566: istore 5
    //   4568: aload 25
    //   4570: astore 24
    //   4572: aload 26
    //   4574: astore 25
    //   4576: lload 18
    //   4578: lstore 16
    //   4580: aload 30
    //   4582: astore 26
    //   4584: goto -3210 -> 1374
    //   4587: astore 29
    //   4589: iconst_1
    //   4590: istore_3
    //   4591: lload 14
    //   4593: lstore 18
    //   4595: lload 16
    //   4597: lstore 14
    //   4599: aload 24
    //   4601: astore 30
    //   4603: iconst_0
    //   4604: istore 5
    //   4606: aload 25
    //   4608: astore 24
    //   4610: aload 30
    //   4612: astore 25
    //   4614: lload 18
    //   4616: lstore 16
    //   4618: goto -3244 -> 1374
    //   4621: astore 29
    //   4623: aload 24
    //   4625: astore 31
    //   4627: iconst_1
    //   4628: istore_3
    //   4629: aload 25
    //   4631: astore 24
    //   4633: aload 26
    //   4635: astore 30
    //   4637: lload 14
    //   4639: lstore 18
    //   4641: lload 16
    //   4643: lstore 14
    //   4645: aload 31
    //   4647: astore 25
    //   4649: lload 18
    //   4651: lstore 16
    //   4653: aload 28
    //   4655: astore 26
    //   4657: aload 30
    //   4659: astore 28
    //   4661: goto -3287 -> 1374
    //   4664: astore 28
    //   4666: goto -3735 -> 931
    //   4669: iconst_0
    //   4670: istore 5
    //   4672: aconst_null
    //   4673: astore 28
    //   4675: aconst_null
    //   4676: astore 26
    //   4678: goto -1414 -> 3264
    //   4681: aload 24
    //   4683: astore 27
    //   4685: aload 26
    //   4687: astore 24
    //   4689: goto -4363 -> 326
    //   4692: iconst_0
    //   4693: istore_3
    //   4694: goto -2220 -> 2474
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4697	0	this	HttpCommunicator
    //   0	4697	1	paramHttpMsg	HttpMsg
    //   0	4697	2	paramhen	hen
    //   0	4697	3	paramBoolean	boolean
    //   54	4281	4	i1	int
    //   206	4465	5	i2	int
    //   328	3958	6	i3	int
    //   45	4247	7	i4	int
    //   34	4199	8	i5	int
    //   31	3697	9	i6	int
    //   22	3258	10	i7	int
    //   2941	43	11	i8	int
    //   28	4423	12	bool1	boolean
    //   439	3	13	bool2	boolean
    //   63	4581	14	l1	long
    //   25	4627	16	l2	long
    //   296	4354	18	l3	long
    //   332	3382	20	l4	long
    //   2882	1291	22	l5	long
    //   60	3402	24	localObject1	Object
    //   3554	132	24	localException1	Exception
    //   3695	1	24	localObject2	Object
    //   3752	3	24	localException2	Exception
    //   3827	1	24	localIOException1	IOException
    //   3832	1	24	localIOException2	IOException
    //   3837	1	24	localIOException3	IOException
    //   3869	1	24	localObject3	Object
    //   3906	42	24	localObject4	Object
    //   3956	732	24	localObject5	Object
    //   57	3662	25	localObject6	Object
    //   3842	1	25	localIOException4	IOException
    //   3847	1	25	localIOException5	IOException
    //   3852	1	25	localIOException6	IOException
    //   3875	773	25	localObject7	Object
    //   51	4635	26	localObject8	Object
    //   87	4597	27	localObject9	Object
    //   147	3794	28	localObject10	Object
    //   3945	10	28	localObject11	Object
    //   3979	1	28	localObject12	Object
    //   3984	13	28	localObject13	Object
    //   4018	1	28	localObject14	Object
    //   4023	10	28	localObject15	Object
    //   4057	161	28	localObject16	Object
    //   4222	7	28	localObject17	Object
    //   4253	407	28	localObject18	Object
    //   4664	1	28	localThrowable1	Throwable
    //   4673	1	28	localObject19	Object
    //   344	981	29	localObject20	Object
    //   1337	48	29	localThrowable2	Throwable
    //   1727	1865	29	localObject21	Object
    //   3673	1	29	localThrowable3	Throwable
    //   3897	157	29	localObject22	Object
    //   4062	14	29	localObject23	Object
    //   4096	52	29	localObject24	Object
    //   4179	11	29	localObject25	Object
    //   4213	57	29	localObject26	Object
    //   4310	1	29	localThrowable4	Throwable
    //   4345	1	29	localThrowable5	Throwable
    //   4388	1	29	localThrowable6	Throwable
    //   4428	1	29	localThrowable7	Throwable
    //   4468	1	29	localThrowable8	Throwable
    //   4507	1	29	localThrowable9	Throwable
    //   4546	1	29	localThrowable10	Throwable
    //   4587	1	29	localThrowable11	Throwable
    //   4621	1	29	localThrowable12	Throwable
    //   7	1364	30	localObject27	Object
    //   1740	29	30	localObject28	Object
    //   3155	944	30	localObject29	Object
    //   4105	14	30	localObject30	Object
    //   4140	14	30	localObject31	Object
    //   4183	475	30	localObject32	Object
    //   19	4229	31	localObject33	Object
    //   4258	18	31	localObject34	Object
    //   4348	298	31	localObject35	Object
    //   13	2811	32	localObject36	Object
    //   10	3726	33	localObject37	Object
    //   16	3716	34	localObject38	Object
    //   4	3776	35	localIHttpCommunicatorListener	IHttpCommunicatorListener
    // Exception table:
    //   from	to	target	type
    //   548	555	655	java/lang/Exception
    //   560	569	655	java/lang/Exception
    //   582	595	655	java/lang/Exception
    //   597	605	655	java/lang/Exception
    //   609	617	655	java/lang/Exception
    //   621	629	655	java/lang/Exception
    //   634	639	655	java/lang/Exception
    //   644	649	655	java/lang/Exception
    //   1089	1096	1191	java/lang/Exception
    //   1101	1110	1191	java/lang/Exception
    //   1123	1136	1191	java/lang/Exception
    //   1138	1146	1191	java/lang/Exception
    //   1150	1158	1191	java/lang/Exception
    //   1162	1170	1191	java/lang/Exception
    //   1175	1180	1191	java/lang/Exception
    //   1185	1190	1191	java/lang/Exception
    //   346	352	1337	java/lang/Throwable
    //   372	379	1337	java/lang/Throwable
    //   399	408	1337	java/lang/Throwable
    //   432	441	1337	java/lang/Throwable
    //   681	688	1337	java/lang/Throwable
    //   713	722	1337	java/lang/Throwable
    //   742	771	1337	java/lang/Throwable
    //   813	857	1337	java/lang/Throwable
    //   877	887	1337	java/lang/Throwable
    //   951	958	1337	java/lang/Throwable
    //   978	987	1337	java/lang/Throwable
    //   1222	1233	1337	java/lang/Throwable
    //   1253	1259	1337	java/lang/Throwable
    //   1279	1286	1337	java/lang/Throwable
    //   1326	1337	1337	java/lang/Throwable
    //   1729	1740	1337	java/lang/Throwable
    //   2059	2067	1337	java/lang/Throwable
    //   2103	2110	1337	java/lang/Throwable
    //   2144	2151	1337	java/lang/Throwable
    //   2171	2183	1337	java/lang/Throwable
    //   2203	2215	1337	java/lang/Throwable
    //   2235	2241	1337	java/lang/Throwable
    //   2261	2267	1337	java/lang/Throwable
    //   2287	2296	1337	java/lang/Throwable
    //   2316	2323	1337	java/lang/Throwable
    //   2553	2560	1337	java/lang/Throwable
    //   2583	2592	1337	java/lang/Throwable
    //   2612	2625	1337	java/lang/Throwable
    //   2645	2655	1337	java/lang/Throwable
    //   2675	2706	1337	java/lang/Throwable
    //   2726	2735	1337	java/lang/Throwable
    //   2755	2767	1337	java/lang/Throwable
    //   2787	2800	1337	java/lang/Throwable
    //   2827	2834	1337	java/lang/Throwable
    //   3715	3724	1337	java/lang/Throwable
    //   1685	1694	1695	java/lang/Exception
    //   3779	3790	1695	java/lang/Exception
    //   346	352	1740	finally
    //   372	379	1740	finally
    //   399	408	1740	finally
    //   432	441	1740	finally
    //   681	688	1740	finally
    //   713	722	1740	finally
    //   742	771	1740	finally
    //   813	857	1740	finally
    //   877	887	1740	finally
    //   909	914	1740	finally
    //   926	931	1740	finally
    //   951	958	1740	finally
    //   978	987	1740	finally
    //   1222	1233	1740	finally
    //   1253	1259	1740	finally
    //   1279	1286	1740	finally
    //   1326	1337	1740	finally
    //   1729	1740	1740	finally
    //   2059	2067	1740	finally
    //   2103	2110	1740	finally
    //   2144	2151	1740	finally
    //   2171	2183	1740	finally
    //   2203	2215	1740	finally
    //   2235	2241	1740	finally
    //   2261	2267	1740	finally
    //   2287	2296	1740	finally
    //   2316	2323	1740	finally
    //   2553	2560	1740	finally
    //   2583	2592	1740	finally
    //   2612	2625	1740	finally
    //   2645	2655	1740	finally
    //   2675	2706	1740	finally
    //   2726	2735	1740	finally
    //   2755	2767	1740	finally
    //   2787	2800	1740	finally
    //   2827	2834	1740	finally
    //   2846	2855	1740	finally
    //   2425	2432	2527	java/lang/Exception
    //   2437	2446	2527	java/lang/Exception
    //   2459	2472	2527	java/lang/Exception
    //   2474	2482	2527	java/lang/Exception
    //   2486	2494	2527	java/lang/Exception
    //   2498	2506	2527	java/lang/Exception
    //   2511	2516	2527	java/lang/Exception
    //   2521	2526	2527	java/lang/Exception
    //   3445	3452	3554	java/lang/Exception
    //   3457	3466	3554	java/lang/Exception
    //   3480	3493	3554	java/lang/Exception
    //   3495	3503	3554	java/lang/Exception
    //   3508	3513	3554	java/lang/Exception
    //   3518	3523	3554	java/lang/Exception
    //   3528	3533	3554	java/lang/Exception
    //   3542	3547	3554	java/lang/Exception
    //   2884	2901	3673	java/lang/Throwable
    //   2922	2928	3673	java/lang/Throwable
    //   2978	2986	3673	java/lang/Throwable
    //   3002	3009	3673	java/lang/Throwable
    //   3025	3031	3673	java/lang/Throwable
    //   3047	3056	3673	java/lang/Throwable
    //   3086	3093	3673	java/lang/Throwable
    //   3123	3130	3673	java/lang/Throwable
    //   3151	3157	3673	java/lang/Throwable
    //   3173	3184	3673	java/lang/Throwable
    //   3200	3206	3673	java/lang/Throwable
    //   3222	3231	3673	java/lang/Throwable
    //   3247	3252	3673	java/lang/Throwable
    //   3589	3599	3673	java/lang/Throwable
    //   3615	3620	3673	java/lang/Throwable
    //   3636	3645	3673	java/lang/Throwable
    //   3661	3670	3673	java/lang/Throwable
    //   1550	1557	3752	java/lang/Exception
    //   1562	1571	3752	java/lang/Exception
    //   1585	1598	3752	java/lang/Exception
    //   1600	1608	3752	java/lang/Exception
    //   1613	1618	3752	java/lang/Exception
    //   1623	1628	3752	java/lang/Exception
    //   1633	1638	3752	java/lang/Exception
    //   1647	1652	3752	java/lang/Exception
    //   1938	1945	3771	java/lang/Exception
    //   1950	1959	3771	java/lang/Exception
    //   1973	1986	3771	java/lang/Exception
    //   1988	1996	3771	java/lang/Exception
    //   2001	2006	3771	java/lang/Exception
    //   2011	2016	3771	java/lang/Exception
    //   2021	2026	3771	java/lang/Exception
    //   2031	2036	3771	java/lang/Exception
    //   609	617	3791	java/io/IOException
    //   621	629	3795	java/io/IOException
    //   634	639	3799	java/io/IOException
    //   1150	1158	3803	java/io/IOException
    //   1162	1170	3807	java/io/IOException
    //   1175	1180	3811	java/io/IOException
    //   2486	2494	3815	java/io/IOException
    //   2498	2506	3819	java/io/IOException
    //   2511	2516	3823	java/io/IOException
    //   3508	3513	3827	java/io/IOException
    //   3518	3523	3832	java/io/IOException
    //   3528	3533	3837	java/io/IOException
    //   1613	1618	3842	java/io/IOException
    //   1623	1628	3847	java/io/IOException
    //   1633	1638	3852	java/io/IOException
    //   2001	2006	3857	java/io/IOException
    //   2011	2016	3861	java/io/IOException
    //   2021	2026	3865	java/io/IOException
    //   36	44	3869	finally
    //   175	205	3906	finally
    //   208	248	3906	finally
    //   263	273	3906	finally
    //   273	284	3906	finally
    //   284	303	3906	finally
    //   65	89	3945	finally
    //   93	117	3984	finally
    //   120	149	4023	finally
    //   149	175	4062	finally
    //   2855	2862	4105	finally
    //   2884	2901	4140	finally
    //   2922	2928	4140	finally
    //   2978	2986	4140	finally
    //   3002	3009	4140	finally
    //   3025	3031	4140	finally
    //   3047	3056	4140	finally
    //   3086	3093	4140	finally
    //   3123	3130	4140	finally
    //   3151	3157	4140	finally
    //   3173	3184	4140	finally
    //   3200	3206	4140	finally
    //   3222	3231	4140	finally
    //   3247	3252	4140	finally
    //   3589	3599	4140	finally
    //   3615	3620	4140	finally
    //   3636	3645	4140	finally
    //   3661	3670	4140	finally
    //   3264	3275	4179	finally
    //   3715	3724	4222	finally
    //   1377	1389	4258	finally
    //   36	44	4310	java/lang/Throwable
    //   175	205	4345	java/lang/Throwable
    //   208	248	4345	java/lang/Throwable
    //   263	273	4345	java/lang/Throwable
    //   273	284	4345	java/lang/Throwable
    //   284	303	4345	java/lang/Throwable
    //   65	89	4388	java/lang/Throwable
    //   93	117	4428	java/lang/Throwable
    //   120	149	4468	java/lang/Throwable
    //   149	175	4507	java/lang/Throwable
    //   2846	2855	4546	java/lang/Throwable
    //   2855	2862	4587	java/lang/Throwable
    //   3264	3275	4621	java/lang/Throwable
    //   909	914	4664	java/lang/Throwable
    //   926	931	4664	java/lang/Throwable
  }
  
  public void a(HttpMsg paramHttpMsg, String paramString1, String paramString2)
  {
    RichMediaUtil.a(RichMediaUtil.b(paramHttpMsg.jdField_e_of_type_Int), paramHttpMsg.d().equals("POST"), RichMediaUtil.c(paramHttpMsg.jdField_d_of_type_Int), paramHttpMsg.ad, paramString1, paramString2);
  }
  
  protected void a(HttpMsg paramHttpMsg, boolean paramBoolean, long paramLong)
  {
    paramHttpMsg.i = ((int)paramLong);
    int i1 = paramHttpMsg.jdField_d_of_type_Int;
    int i2 = paramHttpMsg.jdField_e_of_type_Int;
    int i3 = paramHttpMsg.f;
    if (((i1 == -1) || (i2 == -1)) && (QLog.isColorLevel())) {
      QLog.e("flowstat", 2, "fileType:" + i1 + ",busiType:" + i2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount.a(paramBoolean, i3, i1, i2, paramLong);
    }
  }
  
  public void a(hen paramhen)
  {
    if (this.d) {}
    int i1;
    do
    {
      do
      {
        return;
      } while (paramhen == null);
      paramhen.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      i1 = paramhen.jdField_a_of_type_Int;
      if ((i1 >= 0) && (i1 < 3))
      {
        ??? = new HandlerThread("httpcommunicator_norm_new_" + i1, 5);
        ((HandlerThread)???).start();
        hen localhen = new hen(this, ((HandlerThread)???).getLooper());
        localhen.jdField_a_of_type_Int = i1;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_ArrayOfHen[i1] = localhen;
          if (paramhen.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            this.o -= 1;
          }
          a("replaceNewThread index:" + i1);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.HttpCommunicator", 2, "replaceNewThread,index error occurs. " + i1);
  }
  
  void a(hen paramhen, HttpMsg paramHttpMsg)
  {
    if (!this.c) {
      throw new IOException("httpcommunicator closed");
    }
    if (paramHttpMsg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      throw new IOException("request cancelled");
    }
    if ((paramhen != null) && (paramhen.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      throw new RuntimeException("thread should close");
    }
    if (paramHttpMsg.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      a(paramHttpMsg, "interrupt", "preempted");
      throw new IOException("preempted by higher msg");
    }
  }
  
  public void a(String paramString)
  {
    int i1 = 0;
    if (this.d) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.HttpCommunicator", 2, "queueSize:" + this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() + " mConcurrentRunningMsgs:" + this.o + " mConcurrentLimit:" + this.n + " reason:" + paramString + " tid:" + Thread.currentThread().getId());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() == 0) {
        return;
      }
    }
    hen[] arrayOfhen;
    int i2;
    if (this.o < this.n)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(false);
      if (paramString != null)
      {
        arrayOfhen = this.jdField_a_of_type_ArrayOfHen;
        i2 = arrayOfhen.length;
      }
    }
    for (;;)
    {
      hen localhen;
      if (i1 < i2)
      {
        localhen = arrayOfhen[i1];
        if (localhen.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label249;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramString);
        paramString.b();
        localhen.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localhen.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramString;
        localhen.a(paramString);
        this.o += 1;
        if (QLog.isColorLevel()) {
          a(paramString, "attach", "");
        }
      }
      for (;;)
      {
        return;
        label249:
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!localhen.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localhen.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) || (localhen.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.b() <= paramString.b())) {
          break;
        }
        localhen.a();
      }
      i1 += 1;
    }
  }
  
  void a(boolean paramBoolean, int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IllegalArgumentException))
    {
      paramHttpMsg.a(9020, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IllegalStateException))
    {
      paramHttpMsg.a(9057, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IOException))
    {
      if ("request cancelled".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.a(9037, paramInt, paramThrowable.toString());
        return;
      }
      if ("httpcommunicator closed".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.a(9366, paramInt, paramThrowable.getMessage());
        return;
      }
      if ("preempted by higher msg".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.a(9361, paramInt, paramThrowable.toString());
        return;
      }
      if ("content-length zero".equals(paramThrowable.getMessage()))
      {
        paramHttpURLConnection = BaseTransProcessor.a("Q", -9531L);
        paramHttpMsg.b(HttpMsg.ah, paramHttpURLConnection);
        paramHttpMsg.a(-9527, paramInt, "content zero");
        return;
      }
      if ((paramThrowable instanceof MalformedURLException))
      {
        paramHttpMsg.a(9048, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof InterruptedIOException))
      {
        if ((paramThrowable instanceof SocketTimeoutException))
        {
          if (paramBoolean)
          {
            paramHttpMsg.a(9014, paramInt, paramThrowable.toString());
            return;
          }
          paramHttpMsg.a(9050, paramInt, paramThrowable.toString());
          return;
        }
        paramHttpMsg.a(9049, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof SocketException))
      {
        if ((paramThrowable instanceof ConnectException))
        {
          paramHttpMsg.a(9052, paramInt, paramThrowable.toString());
          return;
        }
        if ((paramThrowable instanceof NoRouteToHostException))
        {
          paramHttpMsg.a(9053, paramInt, paramThrowable.toString());
          return;
        }
        if ((paramThrowable instanceof PortUnreachableException))
        {
          paramHttpMsg.a(9054, paramInt, paramThrowable.toString());
          return;
        }
        paramHttpMsg.a(9051, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof UnknownHostException))
      {
        paramHttpMsg.a(9055, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof EOFException))
      {
        paramHttpMsg.a(9056, paramInt, paramThrowable.getMessage());
        return;
      }
      paramHttpMsg.a(9047, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof SecurityException))
    {
      paramHttpMsg.a(9022, paramInt, paramThrowable.toString());
      return;
    }
    paramHttpMsg.a(9322, paramInt, Log.getStackTraceString(paramThrowable));
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public int b()
  {
    return 3;
  }
  
  public int b(HttpMsg paramHttpMsg)
  {
    int i1 = this.m;
    int i2 = -1;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((!this.d) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() < i1))
        {
          i1 = this.k + 1;
          this.k = i1;
          paramHttpMsg.a(i1);
          this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramHttpMsg);
          paramHttpMsg.a().a(paramHttpMsg, null, 0);
          i1 = this.k;
          ??? = new Object();
          paramHttpMsg.jdField_a_of_type_JavaLangObject = ???;
          paramHttpMsg.c = new AtomicBoolean(false);
          a("sendMsgSync");
          if (paramHttpMsg.c.get()) {}
        }
      }
      try
      {
        ???.wait();
        return i1;
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        i1 = i2;
        continue;
        paramHttpMsg = finally;
        throw paramHttpMsg;
      }
      catch (InterruptedException paramHttpMsg)
      {
        for (;;)
        {
          paramHttpMsg.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  public void b()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator close.async doclose");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new hem(this));
  }
  
  void b(int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    new StringBuilder().append("Response code: ").append(paramInt).toString();
    long l2 = 0L;
    String str = paramHttpURLConnection.getHeaderField("X-ErrNo");
    if ((str != null) && (!str.equals(""))) {}
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(str);
        paramHttpURLConnection = BaseTransProcessor.b(paramInt, l1);
        paramHttpMsg.b(HttpMsg.ah, paramHttpURLConnection);
        paramHttpMsg.a(-9527, paramInt, paramHttpURLConnection);
        return;
      }
      catch (Exception paramHttpURLConnection)
      {
        paramHttpURLConnection.printStackTrace();
        l1 = l2;
        continue;
      }
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("User-ReturnCode");
      long l1 = l2;
      if (paramHttpURLConnection != null)
      {
        l1 = l2;
        if (!paramHttpURLConnection.equals("")) {
          try
          {
            l1 = Long.parseLong(paramHttpURLConnection);
          }
          catch (Exception paramHttpURLConnection)
          {
            paramHttpURLConnection.printStackTrace();
            l1 = l2;
          }
        }
      }
    }
  }
  
  public void b(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg != null)
    {
      IHttpCommunicatorListener localIHttpCommunicatorListener = paramHttpMsg.a();
      if ((localIHttpCommunicatorListener instanceof BaseTransProcessor)) {
        ((BaseTransProcessor)localIHttpCommunicatorListener).a(2, 9014, "sscm http timeout");
      }
      paramHttpMsg.a().b(paramHttpMsg, null);
    }
  }
  
  public void c()
  {
    int i1 = 0;
    long l1;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      l1 = System.currentTimeMillis();
      HttpMsg localHttpMsg;
      do
      {
        localHttpMsg = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(true);
        if (localHttpMsg == null) {
          break;
        }
      } while ((localHttpMsg == null) || (localHttpMsg.a() == null));
      localHttpMsg.a(9366, -1, "httpcommunicator_close");
      localHttpMsg.a().b(localHttpMsg, localHttpMsg);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a();
    hen[] arrayOfhen = this.jdField_a_of_type_ArrayOfHen;
    int i2 = arrayOfhen.length;
    while (i1 < i2)
    {
      arrayOfhen[i1].sendEmptyMessage(1);
      i1 += 1;
    }
    this.jdField_a_of_type_ArrayOfHen = null;
    this.o = 0;
    this.n = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator close_inter.elapse:" + (System.currentTimeMillis() - l1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpCommunicator
 * JD-Core Version:    0.7.0.1
 */