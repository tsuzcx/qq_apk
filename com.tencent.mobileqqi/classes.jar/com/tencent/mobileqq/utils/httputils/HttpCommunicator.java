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
import hit;
import hiu;
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
  private hiu[] jdField_a_of_type_ArrayOfHiu;
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
      this.jdField_a_of_type_ArrayOfHiu = new hiu[3];
      while (i1 < 3)
      {
        HandlerThread localHandlerThread = new HandlerThread("httpcommunicator_norm_" + i1, 5);
        localHandlerThread.start();
        this.jdField_a_of_type_ArrayOfHiu[i1] = new hiu(this, localHandlerThread.getLooper());
        this.jdField_a_of_type_ArrayOfHiu[i1].jdField_a_of_type_Int = i1;
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
  
  public void a(HttpMsg paramHttpMsg, hiu paramhiu)
  {
    int i1 = 0;
    if ((paramHttpMsg != null) && (paramhiu != null)) {
      try
      {
        a(paramHttpMsg, "responseTimeout", "");
        if (paramHttpMsg.b() == null) {}
        for (;;)
        {
          a(90000L, i1);
          a(paramhiu);
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
  public void a(HttpMsg paramHttpMsg, hiu paramhiu, boolean paramBoolean)
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
    //   25: lstore 14
    //   27: iconst_0
    //   28: istore 22
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
    //   48: istore 22
    //   50: aconst_null
    //   51: astore 26
    //   53: iconst_m1
    //   54: istore 4
    //   56: aconst_null
    //   57: astore 25
    //   59: aconst_null
    //   60: astore 24
    //   62: lconst_0
    //   63: lstore 12
    //   65: aload_0
    //   66: aload_1
    //   67: ldc_w 643
    //   70: ldc_w 614
    //   73: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_0
    //   77: aload_2
    //   78: aload_1
    //   79: invokevirtual 646	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lhiu;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
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
    //   118: istore 22
    //   120: invokestatic 663	java/lang/System:currentTimeMillis	()J
    //   123: pop2
    //   124: aload_1
    //   125: invokevirtual 268	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   128: ldc_w 266
    //   131: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +4571 -> 4705
    //   137: new 665	his
    //   140: dup
    //   141: aload_0
    //   142: aload_1
    //   143: aload_2
    //   144: invokespecial 668	his:<init>	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lhiu;)V
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
    //   219: invokevirtual 646	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lhiu;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
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
    //   264: getfield 699	hiu:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
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
    //   296: lstore 16
    //   298: aload 27
    //   300: arraylength
    //   301: istore 5
    //   303: lload 12
    //   305: iload 5
    //   307: i2l
    //   308: ldc2_w 710
    //   311: lload 16
    //   313: ladd
    //   314: ladd
    //   315: ladd
    //   316: lstore 12
    //   318: aload 26
    //   320: astore 27
    //   322: aload 28
    //   324: astore 24
    //   326: iload 4
    //   328: istore 5
    //   330: lload 14
    //   332: lstore 18
    //   334: iload 4
    //   336: istore 6
    //   338: lload 14
    //   340: lstore 16
    //   342: aload 32
    //   344: astore 29
    //   346: aload_0
    //   347: aload_2
    //   348: aload_1
    //   349: invokevirtual 646	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lhiu;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   352: iload 4
    //   354: istore 5
    //   356: lload 14
    //   358: lstore 18
    //   360: iload 4
    //   362: istore 6
    //   364: lload 14
    //   366: lstore 16
    //   368: aload 32
    //   370: astore 29
    //   372: aload 25
    //   374: invokevirtual 714	java/net/HttpURLConnection:getResponseCode	()I
    //   377: istore 4
    //   379: iload 4
    //   381: istore 5
    //   383: lload 14
    //   385: lstore 18
    //   387: iload 4
    //   389: istore 6
    //   391: lload 14
    //   393: lstore 16
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
    //   414: istore 5
    //   416: lload 14
    //   418: lstore 18
    //   420: iload 4
    //   422: istore 6
    //   424: lload 14
    //   426: lstore 16
    //   428: aload 32
    //   430: astore 29
    //   432: aload_2
    //   433: getfield 699	hiu:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   436: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   439: istore 23
    //   441: iload 23
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
    //   495: getfield 699	hiu:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
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
    //   569: lload 12
    //   571: lconst_0
    //   572: ladd
    //   573: lstore 12
    //   575: lload 12
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
    //   600: lload 12
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
    //   663: istore 5
    //   665: lload 14
    //   667: lstore 18
    //   669: iload 4
    //   671: istore 6
    //   673: lload 14
    //   675: lstore 16
    //   677: aload 32
    //   679: astore 29
    //   681: aload_0
    //   682: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   685: ifnull +37 -> 722
    //   688: aload 24
    //   690: ifnull +32 -> 722
    //   693: iload 4
    //   695: istore 5
    //   697: lload 14
    //   699: lstore 18
    //   701: iload 4
    //   703: istore 6
    //   705: lload 14
    //   707: lstore 16
    //   709: aload 32
    //   711: astore 29
    //   713: aload_0
    //   714: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   717: aload 24
    //   719: invokevirtual 732	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   722: iload 4
    //   724: istore 5
    //   726: lload 14
    //   728: lstore 18
    //   730: iload 4
    //   732: istore 6
    //   734: lload 14
    //   736: lstore 16
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
    //   784: if_icmpne +1263 -> 2047
    //   787: iload 7
    //   789: iconst_5
    //   790: if_icmpge +923 -> 1713
    //   793: iload 4
    //   795: istore 5
    //   797: lload 14
    //   799: lstore 18
    //   801: iload 4
    //   803: istore 6
    //   805: lload 14
    //   807: lstore 16
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
    //   859: istore 5
    //   861: lload 14
    //   863: lstore 18
    //   865: iload 4
    //   867: istore 6
    //   869: lload 14
    //   871: lstore 16
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
    //   899: istore 6
    //   901: lload 14
    //   903: lstore 16
    //   905: aload 32
    //   907: astore 29
    //   909: aload 27
    //   911: invokevirtual 740	java/io/OutputStream:close	()V
    //   914: iload 4
    //   916: istore 6
    //   918: lload 14
    //   920: lstore 16
    //   922: aload 32
    //   924: astore 29
    //   926: aload 25
    //   928: invokevirtual 743	java/net/HttpURLConnection:disconnect	()V
    //   931: iload 4
    //   933: istore 5
    //   935: lload 14
    //   937: lstore 18
    //   939: iload 4
    //   941: istore 6
    //   943: lload 14
    //   945: lstore 16
    //   947: aload 32
    //   949: astore 29
    //   951: aload_1
    //   952: invokevirtual 757	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()Z
    //   955: ifne +247 -> 1202
    //   958: iload 4
    //   960: istore 5
    //   962: lload 14
    //   964: lstore 18
    //   966: iload 4
    //   968: istore 6
    //   970: lload 14
    //   972: lstore 16
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
    //   1036: getfield 699	hiu:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
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
    //   1110: lload 12
    //   1112: lconst_0
    //   1113: ladd
    //   1114: lstore 12
    //   1116: lload 12
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
    //   1141: lload 12
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
    //   1204: istore 5
    //   1206: lload 14
    //   1208: lstore 18
    //   1210: iload 4
    //   1212: istore 6
    //   1214: lload 14
    //   1216: lstore 16
    //   1218: aload 32
    //   1220: astore 29
    //   1222: aload_1
    //   1223: ldc_w 760
    //   1226: aload_1
    //   1227: invokevirtual 144	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   1230: invokevirtual 762	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1233: iload 4
    //   1235: istore 5
    //   1237: lload 14
    //   1239: lstore 18
    //   1241: iload 4
    //   1243: istore 6
    //   1245: lload 14
    //   1247: lstore 16
    //   1249: aload 32
    //   1251: astore 29
    //   1253: aload_1
    //   1254: aload 26
    //   1256: invokevirtual 763	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)V
    //   1259: iload 4
    //   1261: istore 5
    //   1263: lload 14
    //   1265: lstore 18
    //   1267: iload 4
    //   1269: istore 6
    //   1271: lload 14
    //   1273: lstore 16
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
    //   1293: istore 22
    //   1295: aload 24
    //   1297: astore 26
    //   1299: aload 27
    //   1301: astore 24
    //   1303: goto -1238 -> 65
    //   1306: iload 4
    //   1308: istore 5
    //   1310: lload 14
    //   1312: lstore 18
    //   1314: iload 4
    //   1316: istore 6
    //   1318: lload 14
    //   1320: lstore 16
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
    //   1351: iconst_0
    //   1352: istore 6
    //   1354: iload 5
    //   1356: istore 4
    //   1358: lload 12
    //   1360: lstore 14
    //   1362: lload 18
    //   1364: lstore 12
    //   1366: iload 6
    //   1368: istore 5
    //   1370: aload 24
    //   1372: astore 25
    //   1374: aload 30
    //   1376: astore 24
    //   1378: iconst_1
    //   1379: istore 6
    //   1381: aload_0
    //   1382: iload_3
    //   1383: iload 4
    //   1385: aload 24
    //   1387: aload_1
    //   1388: aload 29
    //   1390: invokevirtual 772	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ZILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/Throwable;)V
    //   1393: iload_3
    //   1394: ifeq +48 -> 1442
    //   1397: iload 4
    //   1399: sipush 200
    //   1402: if_icmpeq +11 -> 1413
    //   1405: iload 4
    //   1407: sipush 206
    //   1410: if_icmpne +32 -> 1442
    //   1413: aload_0
    //   1414: aload_1
    //   1415: ldc_w 718
    //   1418: new 168	java/lang/StringBuilder
    //   1421: dup
    //   1422: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1425: ldc_w 720
    //   1428: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: iload 5
    //   1433: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1436: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1439: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1442: aload_2
    //   1443: ifnull +13 -> 1456
    //   1446: aload_2
    //   1447: getfield 699	hiu:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1450: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1453: ifne +101 -> 1554
    //   1456: aload_0
    //   1457: aload_1
    //   1458: ldc_w 722
    //   1461: new 168	java/lang/StringBuilder
    //   1464: dup
    //   1465: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1468: ldc_w 724
    //   1471: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: aload_1
    //   1475: invokevirtual 726	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   1478: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1481: ldc_w 728
    //   1484: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1487: aload_1
    //   1488: invokevirtual 144	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   1491: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1497: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1500: aload_1
    //   1501: getfield 774	com/tencent/mobileqq/utils/httputils/HttpMsg:h	I
    //   1504: sipush -9527
    //   1507: if_icmpne +47 -> 1554
    //   1510: aload_0
    //   1511: aload_1
    //   1512: ldc_w 776
    //   1515: new 168	java/lang/StringBuilder
    //   1518: dup
    //   1519: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1522: ldc_w 751
    //   1525: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: aload_1
    //   1529: getfield 381	com/tencent/mobileqq/utils/httputils/HttpMsg:af	Ljava/lang/String;
    //   1532: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: ldc_w 753
    //   1538: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: aload_1
    //   1542: getfield 533	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   1545: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1548: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1551: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1554: aload_0
    //   1555: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1558: ifnull +17 -> 1575
    //   1561: aload 25
    //   1563: ifnull +12 -> 1575
    //   1566: aload_0
    //   1567: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1570: aload 25
    //   1572: invokevirtual 732	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1575: lload 14
    //   1577: lload 12
    //   1579: ladd
    //   1580: lstore 12
    //   1582: lload 12
    //   1584: lconst_0
    //   1585: lcmp
    //   1586: ifeq +26 -> 1612
    //   1589: aload_1
    //   1590: invokevirtual 268	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   1593: ldc_w 266
    //   1596: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1599: ifeq +2156 -> 3755
    //   1602: iconst_1
    //   1603: istore_3
    //   1604: aload_0
    //   1605: aload_1
    //   1606: iload_3
    //   1607: lload 12
    //   1609: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1612: aload 26
    //   1614: ifnull +8 -> 1622
    //   1617: aload 26
    //   1619: invokevirtual 779	java/io/ByteArrayOutputStream:close	()V
    //   1622: aload 28
    //   1624: ifnull +8 -> 1632
    //   1627: aload 28
    //   1629: invokevirtual 782	java/io/InputStream:close	()V
    //   1632: aload 27
    //   1634: ifnull +8 -> 1642
    //   1637: aload 27
    //   1639: invokevirtual 740	java/io/OutputStream:close	()V
    //   1642: iload 6
    //   1644: istore 4
    //   1646: aload 24
    //   1648: ifnull +12 -> 1660
    //   1651: aload 24
    //   1653: invokevirtual 743	java/net/HttpURLConnection:disconnect	()V
    //   1656: iload 6
    //   1658: istore 4
    //   1660: aload_2
    //   1661: ifnull +13 -> 1674
    //   1664: aload_2
    //   1665: getfield 699	hiu:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1668: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1671: ifne -1022 -> 649
    //   1674: aload_1
    //   1675: getfield 621	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1678: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1681: ifne -1032 -> 649
    //   1684: iload 4
    //   1686: ifeq +2101 -> 3787
    //   1689: aload 35
    //   1691: aload_1
    //   1692: aload_1
    //   1693: invokeinterface 421 3 0
    //   1698: return
    //   1699: astore_2
    //   1700: aload_0
    //   1701: aload_1
    //   1702: ldc_w 784
    //   1705: aload_2
    //   1706: invokestatic 790	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1709: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1712: return
    //   1713: iload 4
    //   1715: istore 5
    //   1717: lload 14
    //   1719: lstore 18
    //   1721: iload 4
    //   1723: istore 6
    //   1725: lload 14
    //   1727: lstore 16
    //   1729: aload 32
    //   1731: astore 29
    //   1733: new 137	java/lang/Exception
    //   1736: dup
    //   1737: ldc_w 792
    //   1740: invokespecial 439	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1743: athrow
    //   1744: astore 30
    //   1746: iconst_0
    //   1747: istore 4
    //   1749: aload 29
    //   1751: astore 28
    //   1753: aload 31
    //   1755: astore 29
    //   1757: lload 16
    //   1759: lstore 14
    //   1761: iload 6
    //   1763: istore 5
    //   1765: iload 22
    //   1767: istore_3
    //   1768: iload 8
    //   1770: istore 6
    //   1772: aload 24
    //   1774: astore 26
    //   1776: aload 30
    //   1778: astore 24
    //   1780: iload_3
    //   1781: ifeq +48 -> 1829
    //   1784: iload 5
    //   1786: sipush 200
    //   1789: if_icmpeq +11 -> 1800
    //   1792: iload 5
    //   1794: sipush 206
    //   1797: if_icmpne +32 -> 1829
    //   1800: aload_0
    //   1801: aload_1
    //   1802: ldc_w 718
    //   1805: new 168	java/lang/StringBuilder
    //   1808: dup
    //   1809: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1812: ldc_w 720
    //   1815: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1818: iload 6
    //   1820: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1823: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1826: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1829: aload_2
    //   1830: ifnull +13 -> 1843
    //   1833: aload_2
    //   1834: getfield 699	hiu:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1837: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1840: ifne +106 -> 1946
    //   1843: aload_0
    //   1844: aload_1
    //   1845: ldc_w 722
    //   1848: new 168	java/lang/StringBuilder
    //   1851: dup
    //   1852: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1855: ldc_w 724
    //   1858: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1861: aload_1
    //   1862: invokevirtual 726	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   1865: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1868: ldc_w 728
    //   1871: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: aload_1
    //   1875: invokevirtual 144	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   1878: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1881: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1884: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1887: iload 4
    //   1889: ifeq +57 -> 1946
    //   1892: aload_1
    //   1893: getfield 774	com/tencent/mobileqq/utils/httputils/HttpMsg:h	I
    //   1896: sipush -9527
    //   1899: if_icmpne +47 -> 1946
    //   1902: aload_0
    //   1903: aload_1
    //   1904: ldc_w 776
    //   1907: new 168	java/lang/StringBuilder
    //   1910: dup
    //   1911: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1914: ldc_w 751
    //   1917: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1920: aload_1
    //   1921: getfield 381	com/tencent/mobileqq/utils/httputils/HttpMsg:af	Ljava/lang/String;
    //   1924: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1927: ldc_w 753
    //   1930: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1933: aload_1
    //   1934: getfield 533	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   1937: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1940: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1943: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1946: aload_0
    //   1947: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1950: ifnull +17 -> 1967
    //   1953: aload 26
    //   1955: ifnull +12 -> 1967
    //   1958: aload_0
    //   1959: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1962: aload 26
    //   1964: invokevirtual 732	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1967: lload 12
    //   1969: lload 14
    //   1971: ladd
    //   1972: lstore 12
    //   1974: lload 12
    //   1976: lconst_0
    //   1977: lcmp
    //   1978: ifeq +26 -> 2004
    //   1981: aload_1
    //   1982: invokevirtual 268	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   1985: ldc_w 266
    //   1988: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1991: ifeq +1783 -> 3774
    //   1994: iconst_1
    //   1995: istore_3
    //   1996: aload_0
    //   1997: aload_1
    //   1998: iload_3
    //   1999: lload 12
    //   2001: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   2004: aload 29
    //   2006: ifnull +8 -> 2014
    //   2009: aload 29
    //   2011: invokevirtual 779	java/io/ByteArrayOutputStream:close	()V
    //   2014: aload 28
    //   2016: ifnull +8 -> 2024
    //   2019: aload 28
    //   2021: invokevirtual 782	java/io/InputStream:close	()V
    //   2024: aload 27
    //   2026: ifnull +8 -> 2034
    //   2029: aload 27
    //   2031: invokevirtual 740	java/io/OutputStream:close	()V
    //   2034: aload 25
    //   2036: ifnull +8 -> 2044
    //   2039: aload 25
    //   2041: invokevirtual 743	java/net/HttpURLConnection:disconnect	()V
    //   2044: aload 24
    //   2046: athrow
    //   2047: iload 4
    //   2049: istore 5
    //   2051: lload 14
    //   2053: lstore 18
    //   2055: iload 4
    //   2057: istore 6
    //   2059: lload 14
    //   2061: lstore 16
    //   2063: aload 32
    //   2065: astore 29
    //   2067: aload_0
    //   2068: aload_1
    //   2069: aconst_null
    //   2070: iconst_2
    //   2071: iload_3
    //   2072: invokespecial 641	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;IZ)V
    //   2075: iload 4
    //   2077: sipush 200
    //   2080: if_icmpeq +11 -> 2091
    //   2083: iload 4
    //   2085: sipush 206
    //   2088: if_icmpne +1624 -> 3712
    //   2091: iload 4
    //   2093: istore 5
    //   2095: lload 14
    //   2097: lstore 18
    //   2099: iload 4
    //   2101: istore 6
    //   2103: lload 14
    //   2105: lstore 16
    //   2107: aload 32
    //   2109: astore 29
    //   2111: aload 25
    //   2113: invokevirtual 525	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2116: astore 26
    //   2118: aload 26
    //   2120: ifnonnull +421 -> 2541
    //   2123: ldc_w 614
    //   2126: astore 26
    //   2128: iload_3
    //   2129: ifne +442 -> 2571
    //   2132: iload 4
    //   2134: istore 5
    //   2136: lload 14
    //   2138: lstore 18
    //   2140: iload 4
    //   2142: istore 6
    //   2144: lload 14
    //   2146: lstore 16
    //   2148: aload 32
    //   2150: astore 29
    //   2152: aload_1
    //   2153: getfield 793	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_b_of_type_Boolean	Z
    //   2156: ifeq +415 -> 2571
    //   2159: iload 4
    //   2161: istore 5
    //   2163: lload 14
    //   2165: lstore 18
    //   2167: iload 4
    //   2169: istore 6
    //   2171: lload 14
    //   2173: lstore 16
    //   2175: aload 32
    //   2177: astore 29
    //   2179: aload 26
    //   2181: ldc_w 795
    //   2184: invokevirtual 162	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2187: iconst_m1
    //   2188: if_icmpne +35 -> 2223
    //   2191: iload 4
    //   2193: istore 5
    //   2195: lload 14
    //   2197: lstore 18
    //   2199: iload 4
    //   2201: istore 6
    //   2203: lload 14
    //   2205: lstore 16
    //   2207: aload 32
    //   2209: astore 29
    //   2211: aload 26
    //   2213: ldc_w 797
    //   2216: invokevirtual 162	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2219: iconst_m1
    //   2220: if_icmpeq +351 -> 2571
    //   2223: iload 4
    //   2225: istore 5
    //   2227: lload 14
    //   2229: lstore 18
    //   2231: iload 4
    //   2233: istore 6
    //   2235: lload 14
    //   2237: lstore 16
    //   2239: aload 32
    //   2241: astore 29
    //   2243: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2246: ifeq +58 -> 2304
    //   2249: iload 4
    //   2251: istore 5
    //   2253: lload 14
    //   2255: lstore 18
    //   2257: iload 4
    //   2259: istore 6
    //   2261: lload 14
    //   2263: lstore 16
    //   2265: aload 32
    //   2267: astore 29
    //   2269: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2272: ifeq +32 -> 2304
    //   2275: iload 4
    //   2277: istore 5
    //   2279: lload 14
    //   2281: lstore 18
    //   2283: iload 4
    //   2285: istore 6
    //   2287: lload 14
    //   2289: lstore 16
    //   2291: aload 32
    //   2293: astore 29
    //   2295: ldc 19
    //   2297: iconst_2
    //   2298: ldc_w 799
    //   2301: invokestatic 413	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2304: iload 4
    //   2306: istore 5
    //   2308: lload 14
    //   2310: lstore 18
    //   2312: iload 4
    //   2314: istore 6
    //   2316: lload 14
    //   2318: lstore 16
    //   2320: aload 32
    //   2322: astore 29
    //   2324: aload_0
    //   2325: aload_1
    //   2326: aload_2
    //   2327: iconst_1
    //   2328: invokevirtual 801	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lhiu;Z)V
    //   2331: iload 4
    //   2333: sipush 200
    //   2336: if_icmpeq +11 -> 2347
    //   2339: iload 4
    //   2341: sipush 206
    //   2344: if_icmpne +31 -> 2375
    //   2347: aload_0
    //   2348: aload_1
    //   2349: ldc_w 718
    //   2352: new 168	java/lang/StringBuilder
    //   2355: dup
    //   2356: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   2359: ldc_w 720
    //   2362: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2365: iconst_0
    //   2366: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2369: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2372: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2375: aload_2
    //   2376: ifnull +13 -> 2389
    //   2379: aload_2
    //   2380: getfield 699	hiu:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2383: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2386: ifne +47 -> 2433
    //   2389: aload_0
    //   2390: aload_1
    //   2391: ldc_w 722
    //   2394: new 168	java/lang/StringBuilder
    //   2397: dup
    //   2398: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   2401: ldc_w 724
    //   2404: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2407: aload_1
    //   2408: invokevirtual 726	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   2411: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2414: ldc_w 728
    //   2417: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2420: aload_1
    //   2421: invokevirtual 144	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   2424: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2427: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2430: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2433: aload_0
    //   2434: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   2437: ifnull +17 -> 2454
    //   2440: aload 24
    //   2442: ifnull +12 -> 2454
    //   2445: aload_0
    //   2446: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   2449: aload 24
    //   2451: invokevirtual 732	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   2454: lload 12
    //   2456: lconst_0
    //   2457: ladd
    //   2458: lstore 12
    //   2460: lload 12
    //   2462: lconst_0
    //   2463: lcmp
    //   2464: ifeq +26 -> 2490
    //   2467: aload_1
    //   2468: invokevirtual 268	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   2471: ldc_w 266
    //   2474: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2477: ifeq +2239 -> 4716
    //   2480: iconst_1
    //   2481: istore_3
    //   2482: aload_0
    //   2483: aload_1
    //   2484: iload_3
    //   2485: lload 12
    //   2487: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   2490: iconst_0
    //   2491: ifeq +11 -> 2502
    //   2494: new 737	java/lang/NullPointerException
    //   2497: dup
    //   2498: invokespecial 738	java/lang/NullPointerException:<init>	()V
    //   2501: athrow
    //   2502: iconst_0
    //   2503: ifeq +11 -> 2514
    //   2506: new 737	java/lang/NullPointerException
    //   2509: dup
    //   2510: invokespecial 738	java/lang/NullPointerException:<init>	()V
    //   2513: athrow
    //   2514: aload 27
    //   2516: ifnull +8 -> 2524
    //   2519: aload 27
    //   2521: invokevirtual 740	java/io/OutputStream:close	()V
    //   2524: aload 25
    //   2526: ifnull -1877 -> 649
    //   2529: aload 25
    //   2531: invokevirtual 743	java/net/HttpURLConnection:disconnect	()V
    //   2534: return
    //   2535: astore_1
    //   2536: aload_1
    //   2537: invokevirtual 589	java/lang/Exception:printStackTrace	()V
    //   2540: return
    //   2541: iload 4
    //   2543: istore 5
    //   2545: lload 14
    //   2547: lstore 18
    //   2549: iload 4
    //   2551: istore 6
    //   2553: lload 14
    //   2555: lstore 16
    //   2557: aload 32
    //   2559: astore 29
    //   2561: aload 26
    //   2563: invokevirtual 804	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2566: astore 26
    //   2568: goto -440 -> 2128
    //   2571: iload 4
    //   2573: istore 5
    //   2575: lload 14
    //   2577: lstore 18
    //   2579: iload 4
    //   2581: istore 6
    //   2583: lload 14
    //   2585: lstore 16
    //   2587: aload 32
    //   2589: astore 29
    //   2591: aload_1
    //   2592: getfield 557	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_Long	J
    //   2595: lconst_0
    //   2596: lcmp
    //   2597: ifne +66 -> 2663
    //   2600: iload 4
    //   2602: istore 5
    //   2604: lload 14
    //   2606: lstore 18
    //   2608: iload 4
    //   2610: istore 6
    //   2612: lload 14
    //   2614: lstore 16
    //   2616: aload 32
    //   2618: astore 29
    //   2620: aload_1
    //   2621: invokevirtual 268	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   2624: ldc_w 266
    //   2627: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2630: ifne +33 -> 2663
    //   2633: iload 4
    //   2635: istore 5
    //   2637: lload 14
    //   2639: lstore 18
    //   2641: iload 4
    //   2643: istore 6
    //   2645: lload 14
    //   2647: lstore 16
    //   2649: aload 32
    //   2651: astore 29
    //   2653: new 471	java/io/IOException
    //   2656: dup
    //   2657: ldc 22
    //   2659: invokespecial 474	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2662: athrow
    //   2663: iload 4
    //   2665: istore 5
    //   2667: lload 14
    //   2669: lstore 18
    //   2671: iload 4
    //   2673: istore 6
    //   2675: lload 14
    //   2677: lstore 16
    //   2679: aload 32
    //   2681: astore 29
    //   2683: aload_0
    //   2684: aload_1
    //   2685: ldc_w 806
    //   2688: new 168	java/lang/StringBuilder
    //   2691: dup
    //   2692: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   2695: ldc_w 808
    //   2698: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2701: aload_1
    //   2702: getfield 557	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_Long	J
    //   2705: invokevirtual 584	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2708: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2711: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2714: iload 4
    //   2716: istore 5
    //   2718: lload 14
    //   2720: lstore 18
    //   2722: iload 4
    //   2724: istore 6
    //   2726: lload 14
    //   2728: lstore 16
    //   2730: aload 32
    //   2732: astore 29
    //   2734: aload_1
    //   2735: getfield 658	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_Long	J
    //   2738: lconst_0
    //   2739: lcmp
    //   2740: ifeq +35 -> 2775
    //   2743: iload 4
    //   2745: istore 5
    //   2747: lload 14
    //   2749: lstore 18
    //   2751: iload 4
    //   2753: istore 6
    //   2755: lload 14
    //   2757: lstore 16
    //   2759: aload 32
    //   2761: astore 29
    //   2763: aload_1
    //   2764: invokestatic 656	android/os/SystemClock:uptimeMillis	()J
    //   2767: aload_1
    //   2768: getfield 658	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_Long	J
    //   2771: lsub
    //   2772: putfield 810	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_e_of_type_Long	J
    //   2775: iload 4
    //   2777: istore 5
    //   2779: lload 14
    //   2781: lstore 18
    //   2783: iload 4
    //   2785: istore 6
    //   2787: lload 14
    //   2789: lstore 16
    //   2791: aload 32
    //   2793: astore 29
    //   2795: aload 35
    //   2797: aload_1
    //   2798: aload_1
    //   2799: iconst_3
    //   2800: invokeinterface 407 4 0
    //   2805: ifeq +1888 -> 4693
    //   2808: lconst_0
    //   2809: ldc2_w 710
    //   2812: ladd
    //   2813: lstore 14
    //   2815: iload 4
    //   2817: istore 5
    //   2819: lload 14
    //   2821: lstore 18
    //   2823: iload 4
    //   2825: istore 6
    //   2827: lload 14
    //   2829: lstore 16
    //   2831: aload 32
    //   2833: astore 29
    //   2835: aload 25
    //   2837: invokevirtual 814	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2840: astore 28
    //   2842: iload 4
    //   2844: istore 6
    //   2846: lload 14
    //   2848: lstore 16
    //   2850: aload 28
    //   2852: astore 29
    //   2854: new 778	java/io/ByteArrayOutputStream
    //   2857: dup
    //   2858: invokespecial 815	java/io/ByteArrayOutputStream:<init>	()V
    //   2861: astore 26
    //   2863: sipush 10240
    //   2866: newarray byte
    //   2868: astore 30
    //   2870: iconst_0
    //   2871: istore 5
    //   2873: iconst_0
    //   2874: istore 6
    //   2876: iload 5
    //   2878: istore 8
    //   2880: lload 14
    //   2882: lstore 16
    //   2884: iload 5
    //   2886: istore 9
    //   2888: lload 14
    //   2890: lstore 20
    //   2892: aload 28
    //   2894: aload 30
    //   2896: iload 6
    //   2898: aload 30
    //   2900: arraylength
    //   2901: iload 6
    //   2903: isub
    //   2904: invokevirtual 819	java/io/InputStream:read	([BII)I
    //   2907: istore 7
    //   2909: iload 7
    //   2911: ifle +204 -> 3115
    //   2914: iload 5
    //   2916: istore 8
    //   2918: lload 14
    //   2920: lstore 16
    //   2922: iload 5
    //   2924: istore 9
    //   2926: lload 14
    //   2928: lstore 20
    //   2930: aload_0
    //   2931: aload_2
    //   2932: aload_1
    //   2933: invokevirtual 646	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lhiu;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   2936: lload 14
    //   2938: iload 7
    //   2940: i2l
    //   2941: ladd
    //   2942: lstore 18
    //   2944: iload 6
    //   2946: iload 7
    //   2948: iadd
    //   2949: istore 11
    //   2951: iload 5
    //   2953: iload 7
    //   2955: iadd
    //   2956: istore 7
    //   2958: iload 7
    //   2960: istore 5
    //   2962: iload 11
    //   2964: istore 6
    //   2966: lload 18
    //   2968: lstore 14
    //   2970: iload 7
    //   2972: istore 8
    //   2974: lload 18
    //   2976: lstore 16
    //   2978: iload 7
    //   2980: istore 9
    //   2982: lload 18
    //   2984: lstore 20
    //   2986: iload 11
    //   2988: aload 30
    //   2990: arraylength
    //   2991: if_icmplt -115 -> 2876
    //   2994: iload 7
    //   2996: istore 8
    //   2998: lload 18
    //   3000: lstore 16
    //   3002: iload 7
    //   3004: istore 9
    //   3006: lload 18
    //   3008: lstore 20
    //   3010: aload_1
    //   3011: invokevirtual 821	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Z
    //   3014: ifeq +64 -> 3078
    //   3017: iload 7
    //   3019: istore 8
    //   3021: lload 18
    //   3023: lstore 16
    //   3025: iload 7
    //   3027: istore 9
    //   3029: lload 18
    //   3031: lstore 20
    //   3033: aload_1
    //   3034: aload 30
    //   3036: invokevirtual 824	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   3039: iload 7
    //   3041: istore 8
    //   3043: lload 18
    //   3045: lstore 16
    //   3047: iload 7
    //   3049: istore 9
    //   3051: lload 18
    //   3053: lstore 20
    //   3055: aload 35
    //   3057: aload_1
    //   3058: aload_1
    //   3059: invokeinterface 826 3 0
    //   3064: iconst_0
    //   3065: istore 6
    //   3067: iload 7
    //   3069: istore 5
    //   3071: lload 18
    //   3073: lstore 14
    //   3075: goto -199 -> 2876
    //   3078: iload 7
    //   3080: istore 8
    //   3082: lload 18
    //   3084: lstore 16
    //   3086: iload 7
    //   3088: istore 9
    //   3090: lload 18
    //   3092: lstore 20
    //   3094: aload 26
    //   3096: aload 30
    //   3098: invokevirtual 828	java/io/ByteArrayOutputStream:write	([B)V
    //   3101: iconst_0
    //   3102: istore 6
    //   3104: iload 7
    //   3106: istore 5
    //   3108: lload 18
    //   3110: lstore 14
    //   3112: goto -236 -> 2876
    //   3115: iload 5
    //   3117: istore 8
    //   3119: lload 14
    //   3121: lstore 16
    //   3123: iload 5
    //   3125: istore 9
    //   3127: lload 14
    //   3129: lstore 20
    //   3131: aload_1
    //   3132: invokevirtual 821	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Z
    //   3135: ifeq +441 -> 3576
    //   3138: iload 6
    //   3140: ifle +99 -> 3239
    //   3143: iload 5
    //   3145: istore 8
    //   3147: lload 14
    //   3149: lstore 16
    //   3151: iload 5
    //   3153: istore 9
    //   3155: lload 14
    //   3157: lstore 20
    //   3159: iload 6
    //   3161: newarray byte
    //   3163: astore 29
    //   3165: iload 5
    //   3167: istore 8
    //   3169: lload 14
    //   3171: lstore 16
    //   3173: iload 5
    //   3175: istore 9
    //   3177: lload 14
    //   3179: lstore 20
    //   3181: aload 30
    //   3183: iconst_0
    //   3184: aload 29
    //   3186: iconst_0
    //   3187: iload 6
    //   3189: invokestatic 832	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3192: iload 5
    //   3194: istore 8
    //   3196: lload 14
    //   3198: lstore 16
    //   3200: iload 5
    //   3202: istore 9
    //   3204: lload 14
    //   3206: lstore 20
    //   3208: aload_1
    //   3209: aload 29
    //   3211: invokevirtual 824	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   3214: iload 5
    //   3216: istore 8
    //   3218: lload 14
    //   3220: lstore 16
    //   3222: iload 5
    //   3224: istore 9
    //   3226: lload 14
    //   3228: lstore 20
    //   3230: aload 35
    //   3232: aload_1
    //   3233: aload_1
    //   3234: invokeinterface 826 3 0
    //   3239: iload 5
    //   3241: istore 8
    //   3243: lload 14
    //   3245: lstore 16
    //   3247: iload 5
    //   3249: istore 9
    //   3251: lload 14
    //   3253: lstore 20
    //   3255: aload 26
    //   3257: invokevirtual 779	java/io/ByteArrayOutputStream:close	()V
    //   3260: aload 26
    //   3262: astore 29
    //   3264: aload 28
    //   3266: astore 26
    //   3268: aload 29
    //   3270: astore 28
    //   3272: aload 35
    //   3274: aload_1
    //   3275: aload_1
    //   3276: iconst_4
    //   3277: invokeinterface 407 4 0
    //   3282: pop
    //   3283: iload 5
    //   3285: istore 6
    //   3287: iload 10
    //   3289: istore 5
    //   3291: iload 4
    //   3293: sipush 200
    //   3296: if_icmpeq +11 -> 3307
    //   3299: iload 4
    //   3301: sipush 206
    //   3304: if_icmpne +32 -> 3336
    //   3307: aload_0
    //   3308: aload_1
    //   3309: ldc_w 718
    //   3312: new 168	java/lang/StringBuilder
    //   3315: dup
    //   3316: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   3319: ldc_w 720
    //   3322: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3325: iload 6
    //   3327: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3330: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3333: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3336: aload_2
    //   3337: ifnull +13 -> 3350
    //   3340: aload_2
    //   3341: getfield 699	hiu:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3344: invokevirtual 702	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3347: ifne +106 -> 3453
    //   3350: aload_0
    //   3351: aload_1
    //   3352: ldc_w 722
    //   3355: new 168	java/lang/StringBuilder
    //   3358: dup
    //   3359: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   3362: ldc_w 724
    //   3365: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3368: aload_1
    //   3369: invokevirtual 726	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   3372: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3375: ldc_w 728
    //   3378: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3381: aload_1
    //   3382: invokevirtual 144	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   3385: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3388: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3391: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3394: iload 5
    //   3396: ifeq +57 -> 3453
    //   3399: aload_1
    //   3400: getfield 774	com/tencent/mobileqq/utils/httputils/HttpMsg:h	I
    //   3403: sipush -9527
    //   3406: if_icmpne +47 -> 3453
    //   3409: aload_0
    //   3410: aload_1
    //   3411: ldc_w 776
    //   3414: new 168	java/lang/StringBuilder
    //   3417: dup
    //   3418: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   3421: ldc_w 751
    //   3424: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3427: aload_1
    //   3428: getfield 381	com/tencent/mobileqq/utils/httputils/HttpMsg:af	Ljava/lang/String;
    //   3431: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3434: ldc_w 753
    //   3437: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3440: aload_1
    //   3441: getfield 533	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   3444: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3447: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3450: invokevirtual 302	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3453: aload_0
    //   3454: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   3457: ifnull +17 -> 3474
    //   3460: aload 24
    //   3462: ifnull +12 -> 3474
    //   3465: aload_0
    //   3466: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   3469: aload 24
    //   3471: invokevirtual 732	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3474: lload 12
    //   3476: lload 14
    //   3478: ladd
    //   3479: lstore 12
    //   3481: lload 12
    //   3483: lconst_0
    //   3484: lcmp
    //   3485: ifeq +26 -> 3511
    //   3488: aload_1
    //   3489: invokevirtual 268	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   3492: ldc_w 266
    //   3495: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3498: ifeq +252 -> 3750
    //   3501: iconst_1
    //   3502: istore_3
    //   3503: aload_0
    //   3504: aload_1
    //   3505: iload_3
    //   3506: lload 12
    //   3508: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   3511: aload 28
    //   3513: ifnull +8 -> 3521
    //   3516: aload 28
    //   3518: invokevirtual 779	java/io/ByteArrayOutputStream:close	()V
    //   3521: aload 26
    //   3523: ifnull +8 -> 3531
    //   3526: aload 26
    //   3528: invokevirtual 782	java/io/InputStream:close	()V
    //   3531: aload 27
    //   3533: ifnull +8 -> 3541
    //   3536: aload 27
    //   3538: invokevirtual 740	java/io/OutputStream:close	()V
    //   3541: iload 5
    //   3543: istore 4
    //   3545: aload 25
    //   3547: ifnull -1887 -> 1660
    //   3550: aload 25
    //   3552: invokevirtual 743	java/net/HttpURLConnection:disconnect	()V
    //   3555: iload 5
    //   3557: istore 4
    //   3559: goto -1899 -> 1660
    //   3562: astore 24
    //   3564: aload 24
    //   3566: invokevirtual 589	java/lang/Exception:printStackTrace	()V
    //   3569: iload 5
    //   3571: istore 4
    //   3573: goto -1913 -> 1660
    //   3576: iload 6
    //   3578: ifle +29 -> 3607
    //   3581: iload 5
    //   3583: istore 8
    //   3585: lload 14
    //   3587: lstore 16
    //   3589: iload 5
    //   3591: istore 9
    //   3593: lload 14
    //   3595: lstore 20
    //   3597: aload 26
    //   3599: aload 30
    //   3601: iconst_0
    //   3602: iload 6
    //   3604: invokevirtual 833	java/io/ByteArrayOutputStream:write	([BII)V
    //   3607: iload 5
    //   3609: istore 8
    //   3611: lload 14
    //   3613: lstore 16
    //   3615: iload 5
    //   3617: istore 9
    //   3619: lload 14
    //   3621: lstore 20
    //   3623: aload 26
    //   3625: invokevirtual 834	java/io/ByteArrayOutputStream:flush	()V
    //   3628: iload 5
    //   3630: istore 8
    //   3632: lload 14
    //   3634: lstore 16
    //   3636: iload 5
    //   3638: istore 9
    //   3640: lload 14
    //   3642: lstore 20
    //   3644: aload_1
    //   3645: aload 26
    //   3647: invokevirtual 837	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   3650: invokevirtual 824	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   3653: iload 5
    //   3655: istore 8
    //   3657: lload 14
    //   3659: lstore 16
    //   3661: iload 5
    //   3663: istore 9
    //   3665: lload 14
    //   3667: lstore 20
    //   3669: aload 35
    //   3671: aload_1
    //   3672: aload_1
    //   3673: invokeinterface 826 3 0
    //   3678: goto -439 -> 3239
    //   3681: astore 29
    //   3683: iconst_1
    //   3684: istore_3
    //   3685: lload 12
    //   3687: lstore 14
    //   3689: lload 16
    //   3691: lstore 12
    //   3693: aload 24
    //   3695: astore 30
    //   3697: iload 8
    //   3699: istore 5
    //   3701: aload 25
    //   3703: astore 24
    //   3705: aload 30
    //   3707: astore 25
    //   3709: goto -2331 -> 1378
    //   3712: iconst_1
    //   3713: istore 7
    //   3715: iload 4
    //   3717: istore 5
    //   3719: lload 14
    //   3721: lstore 18
    //   3723: aload_0
    //   3724: iload 4
    //   3726: aload 25
    //   3728: aload_1
    //   3729: invokevirtual 839	com/tencent/mobileqq/utils/httputils/HttpCommunicator:b	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   3732: iconst_1
    //   3733: istore 5
    //   3735: iload 9
    //   3737: istore 6
    //   3739: aload 34
    //   3741: astore 28
    //   3743: aload 33
    //   3745: astore 26
    //   3747: goto -456 -> 3291
    //   3750: iconst_0
    //   3751: istore_3
    //   3752: goto -249 -> 3503
    //   3755: iconst_0
    //   3756: istore_3
    //   3757: goto -2153 -> 1604
    //   3760: astore 24
    //   3762: aload 24
    //   3764: invokevirtual 589	java/lang/Exception:printStackTrace	()V
    //   3767: iload 6
    //   3769: istore 4
    //   3771: goto -2111 -> 1660
    //   3774: iconst_0
    //   3775: istore_3
    //   3776: goto -1780 -> 1996
    //   3779: astore_1
    //   3780: aload_1
    //   3781: invokevirtual 589	java/lang/Exception:printStackTrace	()V
    //   3784: goto -1740 -> 2044
    //   3787: aload 35
    //   3789: aload_1
    //   3790: aload_1
    //   3791: iconst_5
    //   3792: invokeinterface 407 4 0
    //   3797: pop
    //   3798: return
    //   3799: astore_1
    //   3800: goto -3183 -> 617
    //   3803: astore_1
    //   3804: goto -3175 -> 629
    //   3807: astore_1
    //   3808: goto -3169 -> 639
    //   3811: astore_1
    //   3812: goto -2654 -> 1158
    //   3815: astore_1
    //   3816: goto -2646 -> 1170
    //   3819: astore_1
    //   3820: goto -2640 -> 1180
    //   3823: astore_1
    //   3824: goto -1322 -> 2502
    //   3827: astore_1
    //   3828: goto -1314 -> 2514
    //   3831: astore_1
    //   3832: goto -1308 -> 2524
    //   3835: astore 24
    //   3837: goto -316 -> 3521
    //   3840: astore 24
    //   3842: goto -311 -> 3531
    //   3845: astore 24
    //   3847: goto -306 -> 3541
    //   3850: astore 25
    //   3852: goto -2230 -> 1622
    //   3855: astore 25
    //   3857: goto -2225 -> 1632
    //   3860: astore 25
    //   3862: goto -2220 -> 1642
    //   3865: astore_1
    //   3866: goto -1852 -> 2014
    //   3869: astore_1
    //   3870: goto -1846 -> 2024
    //   3873: astore_1
    //   3874: goto -1840 -> 2034
    //   3877: astore 24
    //   3879: aconst_null
    //   3880: astore 27
    //   3882: aconst_null
    //   3883: astore 25
    //   3885: aconst_null
    //   3886: astore 26
    //   3888: iconst_0
    //   3889: istore 4
    //   3891: lconst_0
    //   3892: lstore 12
    //   3894: iconst_m1
    //   3895: istore 5
    //   3897: iconst_0
    //   3898: istore_3
    //   3899: iload 8
    //   3901: istore 6
    //   3903: aload 31
    //   3905: astore 29
    //   3907: aload 30
    //   3909: astore 28
    //   3911: goto -2131 -> 1780
    //   3914: astore 24
    //   3916: aload 26
    //   3918: astore 27
    //   3920: aload 28
    //   3922: astore 26
    //   3924: iconst_0
    //   3925: istore 7
    //   3927: iload 8
    //   3929: istore 6
    //   3931: iload 22
    //   3933: istore_3
    //   3934: iload 4
    //   3936: istore 5
    //   3938: iload 7
    //   3940: istore 4
    //   3942: aload 31
    //   3944: astore 29
    //   3946: aload 30
    //   3948: astore 28
    //   3950: goto -2170 -> 1780
    //   3953: astore 28
    //   3955: aload 24
    //   3957: astore 27
    //   3959: iload 22
    //   3961: istore_3
    //   3962: aload 28
    //   3964: astore 24
    //   3966: iconst_0
    //   3967: istore 7
    //   3969: iload 8
    //   3971: istore 6
    //   3973: iload 4
    //   3975: istore 5
    //   3977: iload 7
    //   3979: istore 4
    //   3981: aload 31
    //   3983: astore 29
    //   3985: aload 30
    //   3987: astore 28
    //   3989: goto -2209 -> 1780
    //   3992: astore 28
    //   3994: iconst_0
    //   3995: istore 7
    //   3997: aload 24
    //   3999: astore 27
    //   4001: iload 22
    //   4003: istore_3
    //   4004: aload 28
    //   4006: astore 24
    //   4008: iload 8
    //   4010: istore 6
    //   4012: iload 4
    //   4014: istore 5
    //   4016: iload 7
    //   4018: istore 4
    //   4020: aload 31
    //   4022: astore 29
    //   4024: aload 30
    //   4026: astore 28
    //   4028: goto -2248 -> 1780
    //   4031: astore 28
    //   4033: iconst_0
    //   4034: istore 7
    //   4036: aload 24
    //   4038: astore 27
    //   4040: aload 28
    //   4042: astore 24
    //   4044: iload 8
    //   4046: istore 6
    //   4048: iload 22
    //   4050: istore_3
    //   4051: iload 4
    //   4053: istore 5
    //   4055: iload 7
    //   4057: istore 4
    //   4059: aload 31
    //   4061: astore 29
    //   4063: aload 30
    //   4065: astore 28
    //   4067: goto -2287 -> 1780
    //   4070: astore 29
    //   4072: iconst_0
    //   4073: istore 7
    //   4075: aload 24
    //   4077: astore 27
    //   4079: aload 28
    //   4081: astore 26
    //   4083: aload 29
    //   4085: astore 24
    //   4087: iload 8
    //   4089: istore 6
    //   4091: iload 22
    //   4093: istore_3
    //   4094: iload 4
    //   4096: istore 5
    //   4098: iload 7
    //   4100: istore 4
    //   4102: aload 31
    //   4104: astore 29
    //   4106: aload 30
    //   4108: astore 28
    //   4110: goto -2330 -> 1780
    //   4113: astore 30
    //   4115: iconst_0
    //   4116: istore 7
    //   4118: aload 26
    //   4120: astore 29
    //   4122: aload 24
    //   4124: astore 26
    //   4126: aload 30
    //   4128: astore 24
    //   4130: iload 8
    //   4132: istore 6
    //   4134: iload 22
    //   4136: istore_3
    //   4137: iload 4
    //   4139: istore 5
    //   4141: iload 7
    //   4143: istore 4
    //   4145: goto -2365 -> 1780
    //   4148: astore 30
    //   4150: iconst_0
    //   4151: istore 7
    //   4153: aload 26
    //   4155: astore 29
    //   4157: aload 24
    //   4159: astore 26
    //   4161: aload 30
    //   4163: astore 24
    //   4165: iload 9
    //   4167: istore 6
    //   4169: iload 22
    //   4171: istore_3
    //   4172: iload 4
    //   4174: istore 5
    //   4176: iload 7
    //   4178: istore 4
    //   4180: lload 20
    //   4182: lstore 14
    //   4184: goto -2404 -> 1780
    //   4187: astore 29
    //   4189: aload 26
    //   4191: astore 30
    //   4193: aload 24
    //   4195: astore 26
    //   4197: aload 29
    //   4199: astore 24
    //   4201: iconst_0
    //   4202: istore 7
    //   4204: iload 5
    //   4206: istore 6
    //   4208: iload 22
    //   4210: istore_3
    //   4211: iload 4
    //   4213: istore 5
    //   4215: iload 7
    //   4217: istore 4
    //   4219: aload 28
    //   4221: astore 29
    //   4223: aload 30
    //   4225: astore 28
    //   4227: goto -2447 -> 1780
    //   4230: astore 28
    //   4232: aload 24
    //   4234: astore 26
    //   4236: aload 28
    //   4238: astore 24
    //   4240: iload 8
    //   4242: istore 6
    //   4244: iload 22
    //   4246: istore_3
    //   4247: iload 4
    //   4249: istore 5
    //   4251: iload 7
    //   4253: istore 4
    //   4255: aload 31
    //   4257: astore 29
    //   4259: aload 30
    //   4261: astore 28
    //   4263: goto -2483 -> 1780
    //   4266: astore 31
    //   4268: iconst_1
    //   4269: istore 7
    //   4271: lload 14
    //   4273: lstore 16
    //   4275: aload 26
    //   4277: astore 29
    //   4279: aload 24
    //   4281: astore 30
    //   4283: aload 31
    //   4285: astore 24
    //   4287: aload 25
    //   4289: astore 26
    //   4291: iload 5
    //   4293: istore 6
    //   4295: iload 4
    //   4297: istore 5
    //   4299: iload 7
    //   4301: istore 4
    //   4303: lload 12
    //   4305: lstore 14
    //   4307: lload 16
    //   4309: lstore 12
    //   4311: aload 30
    //   4313: astore 25
    //   4315: goto -2535 -> 1780
    //   4318: astore 29
    //   4320: aconst_null
    //   4321: astore 26
    //   4323: aconst_null
    //   4324: astore 28
    //   4326: aconst_null
    //   4327: astore 27
    //   4329: aconst_null
    //   4330: astore 24
    //   4332: lconst_0
    //   4333: lstore 14
    //   4335: aconst_null
    //   4336: astore 25
    //   4338: iconst_0
    //   4339: istore 5
    //   4341: iconst_m1
    //   4342: istore 4
    //   4344: lconst_0
    //   4345: lstore 12
    //   4347: iload 22
    //   4349: istore_3
    //   4350: goto -2972 -> 1378
    //   4353: astore 29
    //   4355: aconst_null
    //   4356: astore 30
    //   4358: lload 12
    //   4360: lstore 14
    //   4362: lconst_0
    //   4363: lstore 12
    //   4365: iconst_0
    //   4366: istore 5
    //   4368: aload 25
    //   4370: astore 24
    //   4372: aconst_null
    //   4373: astore 31
    //   4375: aload 26
    //   4377: astore 27
    //   4379: iconst_1
    //   4380: istore_3
    //   4381: aload 28
    //   4383: astore 25
    //   4385: aload 30
    //   4387: astore 26
    //   4389: aload 31
    //   4391: astore 28
    //   4393: goto -3015 -> 1378
    //   4396: astore 29
    //   4398: aconst_null
    //   4399: astore 30
    //   4401: aconst_null
    //   4402: astore 28
    //   4404: aload 24
    //   4406: astore 27
    //   4408: lload 12
    //   4410: lstore 14
    //   4412: lconst_0
    //   4413: lstore 12
    //   4415: iconst_0
    //   4416: istore 5
    //   4418: iload 22
    //   4420: istore_3
    //   4421: aload 25
    //   4423: astore 24
    //   4425: aload 26
    //   4427: astore 25
    //   4429: aload 30
    //   4431: astore 26
    //   4433: goto -3055 -> 1378
    //   4436: astore 29
    //   4438: aconst_null
    //   4439: astore 31
    //   4441: aload 25
    //   4443: astore 28
    //   4445: aconst_null
    //   4446: astore 30
    //   4448: aload 24
    //   4450: astore 27
    //   4452: lload 12
    //   4454: lstore 14
    //   4456: lconst_0
    //   4457: lstore 12
    //   4459: aload 26
    //   4461: astore 25
    //   4463: iconst_0
    //   4464: istore 5
    //   4466: iload 22
    //   4468: istore_3
    //   4469: aload 28
    //   4471: astore 24
    //   4473: aload 31
    //   4475: astore 26
    //   4477: aload 30
    //   4479: astore 28
    //   4481: goto -3103 -> 1378
    //   4484: astore 29
    //   4486: aconst_null
    //   4487: astore 31
    //   4489: aload 25
    //   4491: astore 28
    //   4493: aconst_null
    //   4494: astore 30
    //   4496: aload 24
    //   4498: astore 27
    //   4500: lload 12
    //   4502: lstore 14
    //   4504: lconst_0
    //   4505: lstore 12
    //   4507: iconst_0
    //   4508: istore 5
    //   4510: aload 26
    //   4512: astore 25
    //   4514: iconst_1
    //   4515: istore_3
    //   4516: aload 28
    //   4518: astore 24
    //   4520: aload 31
    //   4522: astore 26
    //   4524: aload 30
    //   4526: astore 28
    //   4528: goto -3150 -> 1378
    //   4531: astore 29
    //   4533: iconst_1
    //   4534: istore_3
    //   4535: aconst_null
    //   4536: astore 26
    //   4538: aconst_null
    //   4539: astore 30
    //   4541: aload 24
    //   4543: astore 27
    //   4545: lload 12
    //   4547: lstore 14
    //   4549: lconst_0
    //   4550: lstore 12
    //   4552: iconst_0
    //   4553: istore 5
    //   4555: aload 25
    //   4557: astore 24
    //   4559: aload 28
    //   4561: astore 25
    //   4563: aload 30
    //   4565: astore 28
    //   4567: goto -3189 -> 1378
    //   4570: astore 29
    //   4572: iconst_1
    //   4573: istore_3
    //   4574: aconst_null
    //   4575: astore 30
    //   4577: lload 12
    //   4579: lstore 16
    //   4581: lload 14
    //   4583: lstore 12
    //   4585: aload 24
    //   4587: astore 26
    //   4589: iconst_0
    //   4590: istore 5
    //   4592: aload 25
    //   4594: astore 24
    //   4596: aload 26
    //   4598: astore 25
    //   4600: lload 16
    //   4602: lstore 14
    //   4604: aload 30
    //   4606: astore 26
    //   4608: goto -3230 -> 1378
    //   4611: astore 29
    //   4613: iconst_1
    //   4614: istore_3
    //   4615: lload 12
    //   4617: lstore 16
    //   4619: lload 14
    //   4621: lstore 12
    //   4623: aload 24
    //   4625: astore 30
    //   4627: iconst_0
    //   4628: istore 5
    //   4630: aload 25
    //   4632: astore 24
    //   4634: aload 30
    //   4636: astore 25
    //   4638: lload 16
    //   4640: lstore 14
    //   4642: goto -3264 -> 1378
    //   4645: astore 29
    //   4647: aload 24
    //   4649: astore 31
    //   4651: iconst_1
    //   4652: istore_3
    //   4653: aload 25
    //   4655: astore 24
    //   4657: aload 26
    //   4659: astore 30
    //   4661: lload 12
    //   4663: lstore 16
    //   4665: lload 14
    //   4667: lstore 12
    //   4669: aload 31
    //   4671: astore 25
    //   4673: lload 16
    //   4675: lstore 14
    //   4677: aload 28
    //   4679: astore 26
    //   4681: aload 30
    //   4683: astore 28
    //   4685: goto -3307 -> 1378
    //   4688: astore 28
    //   4690: goto -3759 -> 931
    //   4693: iconst_0
    //   4694: istore 5
    //   4696: aconst_null
    //   4697: astore 28
    //   4699: aconst_null
    //   4700: astore 26
    //   4702: goto -1430 -> 3272
    //   4705: aload 24
    //   4707: astore 27
    //   4709: aload 26
    //   4711: astore 24
    //   4713: goto -4387 -> 326
    //   4716: iconst_0
    //   4717: istore_3
    //   4718: goto -2236 -> 2482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4721	0	this	HttpCommunicator
    //   0	4721	1	paramHttpMsg	HttpMsg
    //   0	4721	2	paramhiu	hiu
    //   0	4721	3	paramBoolean	boolean
    //   54	4289	4	i1	int
    //   206	4489	5	i2	int
    //   336	3958	6	i3	int
    //   45	4255	7	i4	int
    //   34	4207	8	i5	int
    //   31	4135	9	i6	int
    //   22	3266	10	i7	int
    //   2949	43	11	i8	int
    //   63	4605	12	l1	long
    //   25	4651	14	l2	long
    //   296	4378	16	l3	long
    //   332	3390	18	l4	long
    //   2890	1291	20	l5	long
    //   28	4439	22	bool1	boolean
    //   439	3	23	bool2	boolean
    //   60	3410	24	localObject1	Object
    //   3562	132	24	localException1	Exception
    //   3703	1	24	localObject2	Object
    //   3760	3	24	localException2	Exception
    //   3835	1	24	localIOException1	IOException
    //   3840	1	24	localIOException2	IOException
    //   3845	1	24	localIOException3	IOException
    //   3877	1	24	localObject3	Object
    //   3914	42	24	localObject4	Object
    //   3964	748	24	localObject5	Object
    //   57	3670	25	localObject6	Object
    //   3850	1	25	localIOException4	IOException
    //   3855	1	25	localIOException5	IOException
    //   3860	1	25	localIOException6	IOException
    //   3883	789	25	localObject7	Object
    //   51	4659	26	localObject8	Object
    //   87	4621	27	localObject9	Object
    //   147	3802	28	localObject10	Object
    //   3953	10	28	localObject11	Object
    //   3987	1	28	localObject12	Object
    //   3992	13	28	localObject13	Object
    //   4026	1	28	localObject14	Object
    //   4031	10	28	localObject15	Object
    //   4065	161	28	localObject16	Object
    //   4230	7	28	localObject17	Object
    //   4261	423	28	localObject18	Object
    //   4688	1	28	localThrowable1	Throwable
    //   4697	1	28	localObject19	Object
    //   344	981	29	localObject20	Object
    //   1337	52	29	localThrowable2	Throwable
    //   1731	1538	29	localObject21	Object
    //   3681	1	29	localThrowable3	Throwable
    //   3905	157	29	localObject22	Object
    //   4070	14	29	localObject23	Object
    //   4104	52	29	localObject24	Object
    //   4187	11	29	localObject25	Object
    //   4221	57	29	localObject26	Object
    //   4318	1	29	localThrowable4	Throwable
    //   4353	1	29	localThrowable5	Throwable
    //   4396	1	29	localThrowable6	Throwable
    //   4436	1	29	localThrowable7	Throwable
    //   4484	1	29	localThrowable8	Throwable
    //   4531	1	29	localThrowable9	Throwable
    //   4570	1	29	localThrowable10	Throwable
    //   4611	1	29	localThrowable11	Throwable
    //   4645	1	29	localThrowable12	Throwable
    //   7	1368	30	localObject27	Object
    //   1744	33	30	localObject28	Object
    //   2868	1239	30	localObject29	Object
    //   4113	14	30	localObject30	Object
    //   4148	14	30	localObject31	Object
    //   4191	491	30	localObject32	Object
    //   19	4237	31	localObject33	Object
    //   4266	18	31	localObject34	Object
    //   4373	297	31	localObject35	Object
    //   13	2819	32	localObject36	Object
    //   10	3734	33	localObject37	Object
    //   16	3724	34	localObject38	Object
    //   4	3784	35	localIHttpCommunicatorListener	IHttpCommunicatorListener
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
    //   1733	1744	1337	java/lang/Throwable
    //   2067	2075	1337	java/lang/Throwable
    //   2111	2118	1337	java/lang/Throwable
    //   2152	2159	1337	java/lang/Throwable
    //   2179	2191	1337	java/lang/Throwable
    //   2211	2223	1337	java/lang/Throwable
    //   2243	2249	1337	java/lang/Throwable
    //   2269	2275	1337	java/lang/Throwable
    //   2295	2304	1337	java/lang/Throwable
    //   2324	2331	1337	java/lang/Throwable
    //   2561	2568	1337	java/lang/Throwable
    //   2591	2600	1337	java/lang/Throwable
    //   2620	2633	1337	java/lang/Throwable
    //   2653	2663	1337	java/lang/Throwable
    //   2683	2714	1337	java/lang/Throwable
    //   2734	2743	1337	java/lang/Throwable
    //   2763	2775	1337	java/lang/Throwable
    //   2795	2808	1337	java/lang/Throwable
    //   2835	2842	1337	java/lang/Throwable
    //   3723	3732	1337	java/lang/Throwable
    //   1689	1698	1699	java/lang/Exception
    //   3787	3798	1699	java/lang/Exception
    //   346	352	1744	finally
    //   372	379	1744	finally
    //   399	408	1744	finally
    //   432	441	1744	finally
    //   681	688	1744	finally
    //   713	722	1744	finally
    //   742	771	1744	finally
    //   813	857	1744	finally
    //   877	887	1744	finally
    //   909	914	1744	finally
    //   926	931	1744	finally
    //   951	958	1744	finally
    //   978	987	1744	finally
    //   1222	1233	1744	finally
    //   1253	1259	1744	finally
    //   1279	1286	1744	finally
    //   1326	1337	1744	finally
    //   1733	1744	1744	finally
    //   2067	2075	1744	finally
    //   2111	2118	1744	finally
    //   2152	2159	1744	finally
    //   2179	2191	1744	finally
    //   2211	2223	1744	finally
    //   2243	2249	1744	finally
    //   2269	2275	1744	finally
    //   2295	2304	1744	finally
    //   2324	2331	1744	finally
    //   2561	2568	1744	finally
    //   2591	2600	1744	finally
    //   2620	2633	1744	finally
    //   2653	2663	1744	finally
    //   2683	2714	1744	finally
    //   2734	2743	1744	finally
    //   2763	2775	1744	finally
    //   2795	2808	1744	finally
    //   2835	2842	1744	finally
    //   2854	2863	1744	finally
    //   2433	2440	2535	java/lang/Exception
    //   2445	2454	2535	java/lang/Exception
    //   2467	2480	2535	java/lang/Exception
    //   2482	2490	2535	java/lang/Exception
    //   2494	2502	2535	java/lang/Exception
    //   2506	2514	2535	java/lang/Exception
    //   2519	2524	2535	java/lang/Exception
    //   2529	2534	2535	java/lang/Exception
    //   3453	3460	3562	java/lang/Exception
    //   3465	3474	3562	java/lang/Exception
    //   3488	3501	3562	java/lang/Exception
    //   3503	3511	3562	java/lang/Exception
    //   3516	3521	3562	java/lang/Exception
    //   3526	3531	3562	java/lang/Exception
    //   3536	3541	3562	java/lang/Exception
    //   3550	3555	3562	java/lang/Exception
    //   2892	2909	3681	java/lang/Throwable
    //   2930	2936	3681	java/lang/Throwable
    //   2986	2994	3681	java/lang/Throwable
    //   3010	3017	3681	java/lang/Throwable
    //   3033	3039	3681	java/lang/Throwable
    //   3055	3064	3681	java/lang/Throwable
    //   3094	3101	3681	java/lang/Throwable
    //   3131	3138	3681	java/lang/Throwable
    //   3159	3165	3681	java/lang/Throwable
    //   3181	3192	3681	java/lang/Throwable
    //   3208	3214	3681	java/lang/Throwable
    //   3230	3239	3681	java/lang/Throwable
    //   3255	3260	3681	java/lang/Throwable
    //   3597	3607	3681	java/lang/Throwable
    //   3623	3628	3681	java/lang/Throwable
    //   3644	3653	3681	java/lang/Throwable
    //   3669	3678	3681	java/lang/Throwable
    //   1554	1561	3760	java/lang/Exception
    //   1566	1575	3760	java/lang/Exception
    //   1589	1602	3760	java/lang/Exception
    //   1604	1612	3760	java/lang/Exception
    //   1617	1622	3760	java/lang/Exception
    //   1627	1632	3760	java/lang/Exception
    //   1637	1642	3760	java/lang/Exception
    //   1651	1656	3760	java/lang/Exception
    //   1946	1953	3779	java/lang/Exception
    //   1958	1967	3779	java/lang/Exception
    //   1981	1994	3779	java/lang/Exception
    //   1996	2004	3779	java/lang/Exception
    //   2009	2014	3779	java/lang/Exception
    //   2019	2024	3779	java/lang/Exception
    //   2029	2034	3779	java/lang/Exception
    //   2039	2044	3779	java/lang/Exception
    //   609	617	3799	java/io/IOException
    //   621	629	3803	java/io/IOException
    //   634	639	3807	java/io/IOException
    //   1150	1158	3811	java/io/IOException
    //   1162	1170	3815	java/io/IOException
    //   1175	1180	3819	java/io/IOException
    //   2494	2502	3823	java/io/IOException
    //   2506	2514	3827	java/io/IOException
    //   2519	2524	3831	java/io/IOException
    //   3516	3521	3835	java/io/IOException
    //   3526	3531	3840	java/io/IOException
    //   3536	3541	3845	java/io/IOException
    //   1617	1622	3850	java/io/IOException
    //   1627	1632	3855	java/io/IOException
    //   1637	1642	3860	java/io/IOException
    //   2009	2014	3865	java/io/IOException
    //   2019	2024	3869	java/io/IOException
    //   2029	2034	3873	java/io/IOException
    //   36	44	3877	finally
    //   175	205	3914	finally
    //   208	248	3914	finally
    //   263	273	3914	finally
    //   273	284	3914	finally
    //   284	303	3914	finally
    //   65	89	3953	finally
    //   93	117	3992	finally
    //   120	149	4031	finally
    //   149	175	4070	finally
    //   2863	2870	4113	finally
    //   2892	2909	4148	finally
    //   2930	2936	4148	finally
    //   2986	2994	4148	finally
    //   3010	3017	4148	finally
    //   3033	3039	4148	finally
    //   3055	3064	4148	finally
    //   3094	3101	4148	finally
    //   3131	3138	4148	finally
    //   3159	3165	4148	finally
    //   3181	3192	4148	finally
    //   3208	3214	4148	finally
    //   3230	3239	4148	finally
    //   3255	3260	4148	finally
    //   3597	3607	4148	finally
    //   3623	3628	4148	finally
    //   3644	3653	4148	finally
    //   3669	3678	4148	finally
    //   3272	3283	4187	finally
    //   3723	3732	4230	finally
    //   1381	1393	4266	finally
    //   36	44	4318	java/lang/Throwable
    //   175	205	4353	java/lang/Throwable
    //   208	248	4353	java/lang/Throwable
    //   263	273	4353	java/lang/Throwable
    //   273	284	4353	java/lang/Throwable
    //   284	303	4353	java/lang/Throwable
    //   65	89	4396	java/lang/Throwable
    //   93	117	4436	java/lang/Throwable
    //   120	149	4484	java/lang/Throwable
    //   149	175	4531	java/lang/Throwable
    //   2854	2863	4570	java/lang/Throwable
    //   2863	2870	4611	java/lang/Throwable
    //   3272	3283	4645	java/lang/Throwable
    //   909	914	4688	java/lang/Throwable
    //   926	931	4688	java/lang/Throwable
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
  
  public void a(hiu paramhiu)
  {
    if (this.d) {}
    int i1;
    do
    {
      do
      {
        return;
      } while (paramhiu == null);
      paramhiu.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      i1 = paramhiu.jdField_a_of_type_Int;
      if ((i1 >= 0) && (i1 < 3))
      {
        ??? = new HandlerThread("httpcommunicator_norm_new_" + i1, 5);
        ((HandlerThread)???).start();
        hiu localhiu = new hiu(this, ((HandlerThread)???).getLooper());
        localhiu.jdField_a_of_type_Int = i1;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_ArrayOfHiu[i1] = localhiu;
          if (paramhiu.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            this.o -= 1;
          }
          a("replaceNewThread index:" + i1);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.HttpCommunicator", 2, "replaceNewThread,index error occurs. " + i1);
  }
  
  void a(hiu paramhiu, HttpMsg paramHttpMsg)
  {
    if (!this.c) {
      throw new IOException("httpcommunicator closed");
    }
    if (paramHttpMsg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      throw new IOException("request cancelled");
    }
    if ((paramhiu != null) && (paramhiu.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
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
    hiu[] arrayOfhiu;
    int i2;
    if (this.o < this.n)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(false);
      if (paramString != null)
      {
        arrayOfhiu = this.jdField_a_of_type_ArrayOfHiu;
        i2 = arrayOfhiu.length;
      }
    }
    for (;;)
    {
      hiu localhiu;
      if (i1 < i2)
      {
        localhiu = arrayOfhiu[i1];
        if (localhiu.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label249;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramString);
        paramString.b();
        localhiu.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localhiu.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramString;
        localhiu.a(paramString);
        this.o += 1;
        if (QLog.isColorLevel()) {
          a(paramString, "attach", "");
        }
      }
      for (;;)
      {
        return;
        label249:
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!localhiu.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localhiu.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) || (localhiu.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.b() <= paramString.b())) {
          break;
        }
        localhiu.a();
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
    this.jdField_a_of_type_AndroidOsHandler.post(new hit(this));
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
    hiu[] arrayOfhiu = this.jdField_a_of_type_ArrayOfHiu;
    int i2 = arrayOfhiu.length;
    while (i1 < i2)
    {
      arrayOfhiu[i1].sendEmptyMessage(1);
      i1 += 1;
    }
    this.jdField_a_of_type_ArrayOfHiu = null;
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