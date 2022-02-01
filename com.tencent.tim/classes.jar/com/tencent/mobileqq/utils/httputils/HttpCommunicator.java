package com.tencent.mobileqq.utils.httputils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import anpc;
import aojn;
import aomi;
import aona;
import aona.c;
import aona.d.a;
import aonc;
import aqgo;
import aqof;
import aqog;
import aqoh;
import aqoi;
import aqoj;
import aqok;
import auyd.a;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.HttpsURLConnection;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class HttpCommunicator
  implements auyd.a
{
  private static long att = 1L;
  private MqqHandler N;
  private b jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b = new b();
  private a[] jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a;
  boolean bJO = true;
  private WeakReference<aqoh> bh;
  String bqw = null;
  private volatile boolean cUW;
  private volatile boolean cUX;
  private final int eaD = 4;
  private final int eaE;
  private int eaF;
  private int eaG;
  private AtomicBoolean eh = new AtomicBoolean(false);
  private Runnable hS;
  private Object locker = new ReentrantLock();
  private int seed;
  
  public HttpCommunicator(aqoh paramaqoh, int paramInt)
  {
    this.bh = new WeakReference(paramaqoh);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "construct HTTPcomm");
    }
    this.eaE = paramInt;
    this.eaF = 4;
    this.eaG = 0;
    if (Integer.parseInt(Build.VERSION.SDK) < 8) {
      System.setProperty("http.keepAlive", "false");
    }
    System.setProperty("http.maxConnections", "2");
  }
  
  private HttpURLConnection a(aqog paramaqog)
    throws Throwable
  {
    Object localObject1 = paramaqog.getUrl();
    String str1 = (String)paramaqog.oY.remove("mType");
    String str2;
    int i1;
    int k;
    int i;
    label52:
    Object localObject2;
    int j;
    if (str1 != null)
    {
      str1 = MsfSdkUtils.insertMtype(str1, (String)localObject1);
      localObject1 = null;
      str2 = android.net.Proxy.getDefaultHost();
      i1 = android.net.Proxy.getDefaultPort();
      k = 0;
      i = 0;
      if ((i != 0) || (k >= 2)) {
        break label951;
      }
      localObject2 = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      localObject1 = null;
      if (localObject2 == null) {
        break label960;
      }
      j = ((NetworkInfo)localObject2).getType();
      localObject1 = ((NetworkInfo)localObject2).getExtraInfo();
    }
    for (;;)
    {
      String str3 = aqoj.getApnType((String)localObject1);
      paramaqog.cVc = aqoj.APN_TYPE_CMWAP.equals(str3);
      if (!str3.equals(this.bqw))
      {
        if ((j == 1) || (str3.equals(aqoj.APN_TYPE_CMWAP))) {
          this.bJO = false;
        }
      }
      else
      {
        label151:
        if ((j == 1) && (("10.0.0.172".equals(str2)) || ("10.0.0.200".equals(str2)))) {
          this.bJO = true;
        }
        if ((str2 == null) || (i1 <= 0)) {
          break label954;
        }
      }
      label285:
      label951:
      label954:
      for (int m = 1;; m = 0)
      {
        int i2;
        Object localObject3;
        int n;
        if ((!this.bJO) && (m != 0)) {
          if ((str3.equals(aqoj.APN_TYPE_CMWAP)) || (str3.equals(aqoj.APN_TYPE_UNIWAP)) || (str3.equals(aqoj.APN_TYPE_3GWAP))) {
            if (!paramaqog.cVd) {
              switch (paramaqog.eaI)
              {
              default: 
                localObject1 = aqoj.getConnectionWithXOnlineHost(str1, str2, i1);
                i = 1;
                a((HttpURLConnection)localObject1, paramaqog);
                paramaqog.netType = j;
                i2 = aomi.a().getNetType();
                if (paramaqog.d == null)
                {
                  localObject3 = aona.a(i2);
                  n = ((aona.c)localObject3).getConnectTimeout();
                  if ("POST".equals(paramaqog.getRequestMethod())) {
                    j = 89500;
                  }
                }
                break;
              }
            }
          }
        }
        for (;;)
        {
          ((HttpURLConnection)localObject1).setConnectTimeout(n);
          ((HttpURLConnection)localObject1).setReadTimeout(j);
          a(paramaqog, "gettingConn", "getConnection type:" + i2 + " activeNetworkInfo: " + localObject2 + " defaultHost:" + str2 + " defaultPort: " + i1 + " last apnType:" + this.bqw + " forceDirect:" + this.bJO + ",connectTimeOut:" + n + ",readTimeout:" + j);
          ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
          localObject2 = paramaqog.oY.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            ((HttpURLConnection)localObject1).setRequestProperty((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
          }
          str1 = MsfSdkUtils.insertMtype("Other", (String)localObject1);
          break;
          this.bJO = true;
          break label151;
          localObject1 = (HttpURLConnection)new URL(str1).openConnection(java.net.Proxy.NO_PROXY);
          i = 0;
          break label285;
          localObject1 = aqoj.getConnectionWithDefaultProxy(str1, str2, i1);
          i = 1;
          break label285;
          localObject1 = aqoj.getConnectionWithXOnlineHost(str1, str2, i1);
          i = 1;
          break label285;
          if (str3.equals(aqoj.APN_TYPE_CTWAP))
          {
            localObject1 = aqoj.getConnectionWithDefaultProxy(str1, str2, i1);
            i = 1;
            break label285;
          }
          localObject1 = aqoj.getConnectionWithDefaultProxy(str1, str2, i1);
          i = 1;
          break label285;
          localObject1 = (HttpURLConnection)new URL(str1).openConnection();
          i = 0;
          break label285;
          j = ((aona.c)localObject3).getReadTimeout();
          continue;
          n = paramaqog.d.jC(i2);
          j = paramaqog.d.jB(i2);
        }
        if (paramaqog.getRequestMethod().equals("POST"))
        {
          ((HttpURLConnection)localObject1).setDoOutput(true);
          if (paramaqog.aC() != null) {
            ((HttpURLConnection)localObject1).setFixedLengthStreamingMode(paramaqog.aC().length);
          }
        }
        paramaqog.cuv = ((HttpURLConnection)localObject1).getRequestProperties().toString();
        try
        {
          ((HttpURLConnection)localObject1).connect();
          i = 1;
        }
        catch (Exception localException)
        {
          while (m != 0) {
            if ((i != 0) && (m != 0))
            {
              i = 0;
              this.bJO = true;
            }
            else if ((m != 0) && (i == 0))
            {
              i = 0;
              this.bJO = false;
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
            if (m == 0) {
              break;
            }
            if ((i != 0) && (m != 0))
            {
              i = 0;
              this.bJO = true;
            }
            else if ((m != 0) && (i == 0))
            {
              i = 0;
              this.bJO = false;
            }
            else
            {
              i = 1;
            }
          }
          throw new SocketException("AssertionError : " + str4);
        }
        this.bqw = str3;
        k += 1;
        break label52;
        return localObject1;
      }
      label960:
      j = -1;
    }
  }
  
  private void a(aqog paramaqog1, aqog paramaqog2, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SSCM", 2, "msg statuschanged: " + paramInt);
      }
      paramaqog1.a().a(paramaqog1, paramaqog2, paramInt);
    }
  }
  
  private void a(HttpURLConnection paramHttpURLConnection, aqog paramaqog)
  {
    String str;
    aqof localaqof;
    if ((paramaqog.mIsHttps) && ((paramHttpURLConnection instanceof HttpsURLConnection)))
    {
      paramHttpURLConnection = (HttpsURLConnection)paramHttpURLConnection;
      str = paramaqog.cux;
      localaqof = new aqof(this, str, paramaqog);
      if (paramaqog.cML)
      {
        paramHttpURLConnection.setRequestProperty("host", str);
        paramHttpURLConnection.setSSLSocketFactory(new aqok(str, localaqof));
        paramHttpURLConnection.setHostnameVerifier(localaqof);
      }
    }
    else
    {
      return;
    }
    paramHttpURLConnection.setRequestProperty("host", str);
    paramHttpURLConnection.setHostnameVerifier(localaqof);
  }
  
  private boolean bA(boolean paramBoolean)
  {
    int j = 0;
    synchronized (this.locker)
    {
      if (this.cUX) {
        return false;
      }
      if (!this.cUW) {
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b.Mj() > 0) {
        return false;
      }
    }
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a == null) || (this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a.length == 0)) {
      return false;
    }
    if (this.eaG > 0) {
      return false;
    }
    a[] arrayOfa = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a;
    int k = arrayOfa.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        a locala = arrayOfa[i];
        if ((locala != null) && (locala.ei != null) && (locala.ei.get())) {
          return false;
        }
      }
      else
      {
        if (paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator checkThreadPoolIdle ，ThreadPool Quit ");
          }
          arrayOfa = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a;
          k = arrayOfa.length;
          i = j;
          while (i < k)
          {
            arrayOfa[i].sendEmptyMessage(1);
            i += 1;
          }
          this.eaG = 0;
          this.eaF = 0;
          this.cUW = false;
          this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a = null;
        }
        return true;
      }
      i += 1;
    }
  }
  
  public String Cm()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b != null) {
      return this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b.Cn();
    }
    return "";
  }
  
  public void UZ(String paramString)
  {
    int i = 0;
    if (this.cUX) {
      return;
    }
    synchronized (this.locker)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.HttpCommunicator", 2, "queueSize:" + this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b.Mj() + " mConcurrentRunningMsgs:" + this.eaG + " mConcurrentLimit:" + this.eaF + " reason:" + paramString + " tid:" + Thread.currentThread().getId());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b.Mj() == 0) {
        return;
      }
    }
    a[] arrayOfa;
    int j;
    if (this.eaG < this.eaF)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b.a(false);
      if (paramString != null)
      {
        arrayOfa = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a;
        j = arrayOfa.length;
      }
    }
    for (;;)
    {
      a locala;
      aqog localaqog;
      if (i < j)
      {
        locala = arrayOfa[i];
        localaqog = locala.h;
        if (locala.ei.get()) {
          break label268;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b.b(paramString);
        paramString.refresh();
        locala.ei.set(true);
        locala.h = paramString;
        locala.h(paramString);
        this.eaG += 1;
        paramString.apv = (SystemClock.uptimeMillis() - paramString.atw);
        if (QLog.isColorLevel()) {
          a(paramString, "attach", "");
        }
      }
      for (;;)
      {
        return;
        label268:
        if ((!this.eh.get()) || (!locala.ei.get()) || (localaqog == null) || (localaqog.getPriority() <= paramString.getPriority())) {
          break;
        }
        locala.eeE();
      }
      i += 1;
    }
  }
  
  public void XG(int paramInt)
  {
    localObject1 = this.locker;
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        this.eaF = 4;
        this.eh.set(false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.HttpCommunicator", 2, "netType:" + paramInt + " concurrent:" + this.eaF);
        }
        UZ("netChange");
        return;
      }
      finally {}
      this.eaF = 3;
      this.eh.set(true);
    }
  }
  
  public int a(aqog paramaqog)
  {
    int i = -1;
    int k = this.eaE;
    int j = 1;
    if (this.cUX)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.richmedia.HttpCommunicator", 2, "sendMsg closed");
      }
      if ((paramaqog != null) && (paramaqog.a() != null))
      {
        paramaqog.P(9366, -1, "close");
        paramaqog.a().b(paramaqog, paramaqog);
        k = i;
        return k;
      }
    }
    if (!this.cUW) {
      start();
    }
    Object localObject = this.locker;
    if (paramaqog != null) {}
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b.Mj() < k)
        {
          i = this.seed + 1;
          this.seed = i;
          paramaqog.XH(i);
          paramaqog.atw = SystemClock.uptimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b.i(paramaqog);
          paramaqog.a().a(paramaqog, null, 0);
          i = this.seed;
          k = i;
          if (j == 0) {
            break;
          }
          UZ("sendMsg");
          return i;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        }
        if ((paramaqog != null) && (paramaqog.a() != null))
        {
          paramaqog.P(9367, -1, "queen full");
          paramaqog.a().b(paramaqog, paramaqog);
        }
      }
      finally {}
      j = 0;
    }
  }
  
  void a(int paramInt, HttpURLConnection paramHttpURLConnection, aqog paramaqog)
  {
    if ((paramHttpURLConnection == null) || (paramaqog == null)) {
      return;
    }
    paramaqog.setResponseCode(paramInt);
    paramaqog.ip("Content-Type", paramHttpURLConnection.getContentType());
    paramaqog.cuw = paramHttpURLConnection.getHeaderFields().toString();
    if (paramHttpURLConnection.getHeaderField("User-ReturnCode") != null) {
      paramaqog.ip("User-ReturnCode", paramHttpURLConnection.getHeaderField("User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("X-User-ReturnCode") != null) {
      paramaqog.ip("X-User-ReturnCode", paramHttpURLConnection.getHeaderField("X-User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("content-range") != null) {
      paramaqog.ip("content-range", paramHttpURLConnection.getHeaderField("content-range"));
    }
    if (paramHttpURLConnection.getHeaderField("Range") != null) {
      paramaqog.ip("Range", paramHttpURLConnection.getHeaderField("Range"));
    }
    if (paramHttpURLConnection.getHeaderField("X-Range") != null) {
      paramaqog.ip("X-Range", paramHttpURLConnection.getHeaderField("X-Range"));
    }
    if (paramHttpURLConnection.getHeaderField("Content-Encoding") != null) {
      paramaqog.ip("Content-Encoding", paramHttpURLConnection.getHeaderField("Content-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("Transfer-Encoding") != null) {
      paramaqog.ip("Transfer-Encoding", paramHttpURLConnection.getHeaderField("Transfer-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("X-RtFlag") != null) {
      paramaqog.ip("X-RtFlag", paramHttpURLConnection.getHeaderField("X-RtFlag"));
    }
    if (paramHttpURLConnection.getHeaderField("X-httime") != null) {
      paramaqog.ip("X-httime", paramHttpURLConnection.getHeaderField("X-httime"));
    }
    if (paramHttpURLConnection.getHeaderField("X-piccachetime") != null) {
      paramaqog.ip("X-piccachetime", paramHttpURLConnection.getHeaderField("X-piccachetime"));
    }
    paramaqog.totalLen = -1L;
    String str = paramHttpURLConnection.getHeaderField("content-range");
    int i;
    if (str != null) {
      i = str.lastIndexOf("/");
    }
    for (;;)
    {
      try
      {
        paramaqog.totalLen = Long.valueOf(str.substring(i + 1)).longValue();
        paramaqog.atu = paramHttpURLConnection.getContentLength();
        a(paramaqog, "copyRespHeader", "resultCode:" + paramInt + " totalLen:" + paramaqog.totalLen + ",totalBlockLen:" + paramaqog.atu);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      paramaqog.totalLen = paramHttpURLConnection.getContentLength();
      paramaqog.atu = paramaqog.totalLen;
    }
  }
  
  public void a(aqog paramaqog, a parama)
  {
    int i = 0;
    if ((paramaqog != null) && (parama != null)) {
      try
      {
        a(paramaqog, "responseTimeout", "");
        if (paramaqog.aC() == null) {}
        for (;;)
        {
          aX(90000L, i);
          a(parama);
          paramaqog.P(9014, 0, "response timeout");
          paramaqog.a().b(paramaqog, paramaqog);
          return;
          i = paramaqog.aC().length;
        }
        return;
      }
      catch (Exception paramaqog)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "onResponseTimeout", paramaqog);
        }
      }
    }
  }
  
  /* Error */
  public void a(aqog paramaqog, a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 430	aqog:a	()Laqoi;
    //   4: astore 31
    //   6: aconst_null
    //   7: astore 24
    //   9: aconst_null
    //   10: astore 29
    //   12: aconst_null
    //   13: astore 27
    //   15: aconst_null
    //   16: astore 23
    //   18: aconst_null
    //   19: astore 30
    //   21: aconst_null
    //   22: astore 28
    //   24: iconst_m1
    //   25: istore 4
    //   27: lconst_0
    //   28: lstore 13
    //   30: lconst_0
    //   31: lstore 15
    //   33: iconst_0
    //   34: istore 11
    //   36: iconst_0
    //   37: istore 8
    //   39: iconst_0
    //   40: istore 7
    //   42: aload_0
    //   43: aload_1
    //   44: aconst_null
    //   45: iconst_1
    //   46: iload_3
    //   47: invokespecial 709	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Laqog;IZ)V
    //   50: iconst_0
    //   51: istore 6
    //   53: iconst_0
    //   54: istore 11
    //   56: aconst_null
    //   57: astore 25
    //   59: aload_0
    //   60: aload_1
    //   61: ldc_w 711
    //   64: ldc_w 501
    //   67: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: aload_2
    //   72: aload_1
    //   73: invokevirtual 714	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator$a;Laqog;)V
    //   76: aload_0
    //   77: aload_1
    //   78: invokespecial 716	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;)Ljava/net/HttpURLConnection;
    //   81: astore 26
    //   83: aload 26
    //   85: astore 24
    //   87: aload_1
    //   88: aload 24
    //   90: putfield 720	aqog:f	Ljava/net/HttpURLConnection;
    //   93: aload_1
    //   94: invokestatic 549	android/os/SystemClock:uptimeMillis	()J
    //   97: putfield 723	aqog:startTime	J
    //   100: aload_0
    //   101: aload_1
    //   102: ldc_w 725
    //   105: ldc_w 501
    //   108: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   111: iconst_1
    //   112: istore 11
    //   114: invokestatic 728	java/lang/System:currentTimeMillis	()J
    //   117: pop2
    //   118: aload_1
    //   119: invokevirtual 265	aqog:getRequestMethod	()Ljava/lang/String;
    //   122: ldc_w 262
    //   125: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: ifeq +5223 -> 5351
    //   131: new 730	com/tencent/mobileqq/utils/httputils/HttpCommunicator$1
    //   134: dup
    //   135: aload_0
    //   136: aload_1
    //   137: aload_2
    //   138: invokespecial 733	com/tencent/mobileqq/utils/httputils/HttpCommunicator$1:<init>	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;Laqog;Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator$a;)V
    //   141: astore 26
    //   143: aload_0
    //   144: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   147: aload 26
    //   149: ldc2_w 689
    //   152: invokevirtual 739	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   155: pop
    //   156: aload_1
    //   157: invokevirtual 394	aqog:aC	()[B
    //   160: astore 32
    //   162: aload 24
    //   164: invokevirtual 743	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   167: astore 25
    //   169: aload_0
    //   170: aload_1
    //   171: ldc_w 745
    //   174: new 279	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   181: ldc_w 747
    //   184: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 32
    //   189: arraylength
    //   190: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   199: iconst_0
    //   200: istore 5
    //   202: iload 5
    //   204: aload 32
    //   206: arraylength
    //   207: if_icmpge +46 -> 253
    //   210: aload_0
    //   211: aload_2
    //   212: aload_1
    //   213: invokevirtual 714	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator$a;Laqog;)V
    //   216: aload 25
    //   218: aload 32
    //   220: iload 5
    //   222: sipush 10240
    //   225: aload 32
    //   227: arraylength
    //   228: iload 5
    //   230: isub
    //   231: invokestatic 753	java/lang/Math:min	(II)I
    //   234: invokevirtual 759	java/io/OutputStream:write	([BII)V
    //   237: aload 25
    //   239: invokevirtual 762	java/io/OutputStream:flush	()V
    //   242: iload 5
    //   244: sipush 10240
    //   247: iadd
    //   248: istore 5
    //   250: goto -48 -> 202
    //   253: aload_2
    //   254: ifnull +13 -> 267
    //   257: aload_2
    //   258: getfield 765	com/tencent/mobileqq/utils/httputils/HttpCommunicator$a:ej	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   261: invokevirtual 486	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   264: ifne +14 -> 278
    //   267: aload_0
    //   268: aload_1
    //   269: ldc_w 767
    //   272: ldc_w 501
    //   275: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   278: aload 24
    //   280: invokevirtual 771	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   283: invokevirtual 772	java/net/URL:toString	()Ljava/lang/String;
    //   286: invokevirtual 775	java/lang/String:length	()I
    //   289: i2l
    //   290: lstore 17
    //   292: aload 32
    //   294: arraylength
    //   295: istore 5
    //   297: lload 13
    //   299: iload 5
    //   301: i2l
    //   302: ldc2_w 776
    //   305: lload 17
    //   307: ladd
    //   308: ladd
    //   309: ladd
    //   310: lstore 13
    //   312: aload_0
    //   313: aload_2
    //   314: aload_1
    //   315: invokevirtual 714	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator$a;Laqog;)V
    //   318: aload 24
    //   320: invokevirtual 780	java/net/HttpURLConnection:getResponseCode	()I
    //   323: istore 5
    //   325: aload_0
    //   326: iload 5
    //   328: aload 24
    //   330: aload_1
    //   331: invokevirtual 782	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ILjava/net/HttpURLConnection;Laqog;)V
    //   334: aload_2
    //   335: ifnull +232 -> 567
    //   338: aload_2
    //   339: getfield 765	com/tencent/mobileqq/utils/httputils/HttpCommunicator$a:ej	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   342: invokevirtual 486	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   345: istore 12
    //   347: iload 12
    //   349: ifeq +218 -> 567
    //   352: iload 5
    //   354: sipush 200
    //   357: if_icmpeq +11 -> 368
    //   360: iload 5
    //   362: sipush 206
    //   365: if_icmpne +31 -> 396
    //   368: aload_0
    //   369: aload_1
    //   370: ldc_w 784
    //   373: new 279	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 786
    //   383: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: iconst_0
    //   387: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload_2
    //   397: ifnull +13 -> 410
    //   400: aload_2
    //   401: getfield 765	com/tencent/mobileqq/utils/httputils/HttpCommunicator$a:ej	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   404: invokevirtual 486	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   407: ifne +47 -> 454
    //   410: aload_0
    //   411: aload_1
    //   412: ldc_w 788
    //   415: new 279	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   422: ldc_w 790
    //   425: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload_1
    //   429: invokevirtual 793	aqog:getErrorString	()Ljava/lang/String;
    //   432: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: ldc_w 795
    //   438: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload_1
    //   442: invokevirtual 798	aqog:Co	()Ljava/lang/String;
    //   445: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload_0
    //   455: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   458: ifnull +17 -> 475
    //   461: aload 26
    //   463: ifnull +12 -> 475
    //   466: aload_0
    //   467: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   470: aload 26
    //   472: invokevirtual 802	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   475: lload 13
    //   477: lconst_0
    //   478: ladd
    //   479: lstore 13
    //   481: lload 13
    //   483: lconst_0
    //   484: lcmp
    //   485: ifeq +26 -> 511
    //   488: aload_1
    //   489: invokevirtual 265	aqog:getRequestMethod	()Ljava/lang/String;
    //   492: ldc_w 262
    //   495: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   498: ifeq +58 -> 556
    //   501: iconst_1
    //   502: istore_3
    //   503: aload_0
    //   504: aload_1
    //   505: iload_3
    //   506: lload 13
    //   508: invokevirtual 805	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;ZJ)V
    //   511: iconst_0
    //   512: ifeq +11 -> 523
    //   515: new 807	java/lang/NullPointerException
    //   518: dup
    //   519: invokespecial 808	java/lang/NullPointerException:<init>	()V
    //   522: athrow
    //   523: iconst_0
    //   524: ifeq +11 -> 535
    //   527: new 807	java/lang/NullPointerException
    //   530: dup
    //   531: invokespecial 808	java/lang/NullPointerException:<init>	()V
    //   534: athrow
    //   535: aload 25
    //   537: ifnull +8 -> 545
    //   540: aload 25
    //   542: invokevirtual 810	java/io/OutputStream:close	()V
    //   545: aload 24
    //   547: ifnull +8 -> 555
    //   550: aload 24
    //   552: invokevirtual 813	java/net/HttpURLConnection:disconnect	()V
    //   555: return
    //   556: iconst_0
    //   557: istore_3
    //   558: goto -55 -> 503
    //   561: astore_1
    //   562: aload_1
    //   563: invokevirtual 685	java/lang/Exception:printStackTrace	()V
    //   566: return
    //   567: aload_0
    //   568: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   571: ifnull +17 -> 588
    //   574: aload 26
    //   576: ifnull +12 -> 588
    //   579: aload_0
    //   580: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   583: aload 26
    //   585: invokevirtual 802	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   588: aload_0
    //   589: aload_1
    //   590: ldc_w 815
    //   593: new 279	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   600: ldc_w 817
    //   603: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: iload 5
    //   608: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   611: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   617: iload 5
    //   619: sipush 302
    //   622: if_icmpeq +11 -> 633
    //   625: iload 5
    //   627: sipush 301
    //   630: if_icmpne +1588 -> 2218
    //   633: iload 6
    //   635: iconst_5
    //   636: if_icmpge +1292 -> 1928
    //   639: aload_0
    //   640: aload_1
    //   641: ldc_w 819
    //   644: new 279	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   651: ldc_w 821
    //   654: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: aload_1
    //   658: getfield 405	aqog:cuv	Ljava/lang/String;
    //   661: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: ldc_w 823
    //   667: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload_1
    //   671: getfield 622	aqog:cuw	Ljava/lang/String;
    //   674: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   683: aload 24
    //   685: ldc_w 825
    //   688: invokevirtual 627	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   691: astore 32
    //   693: aload 32
    //   695: ifnull +760 -> 1455
    //   698: aload 25
    //   700: ifnull +8 -> 708
    //   703: aload 25
    //   705: invokevirtual 810	java/io/OutputStream:close	()V
    //   708: aload 24
    //   710: invokevirtual 813	java/net/HttpURLConnection:disconnect	()V
    //   713: iload 6
    //   715: ifne +378 -> 1093
    //   718: aload_1
    //   719: getfield 828	aqog:cMM	Z
    //   722: istore 12
    //   724: iload 12
    //   726: ifeq +367 -> 1093
    //   729: aload_1
    //   730: getfield 831	aqog:cMH	Z
    //   733: ifeq +323 -> 1056
    //   736: aload_1
    //   737: invokevirtual 835	aqog:ac	()Ljava/util/HashMap;
    //   740: ldc_w 453
    //   743: invokevirtual 837	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   746: checkcast 157	java/lang/String
    //   749: astore 23
    //   751: aload 23
    //   753: invokestatic 843	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   756: ifne +337 -> 1093
    //   759: aload 23
    //   761: ldc_w 845
    //   764: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   767: ifeq +326 -> 1093
    //   770: new 353	java/net/URL
    //   773: dup
    //   774: aload 32
    //   776: invokespecial 356	java/net/URL:<init>	(Ljava/lang/String;)V
    //   779: invokevirtual 848	java/net/URL:getHost	()Ljava/lang/String;
    //   782: invokestatic 854	akyd:nS	(Ljava/lang/String;)Z
    //   785: istore 12
    //   787: iload 12
    //   789: ifne +304 -> 1093
    //   792: iload 5
    //   794: sipush 200
    //   797: if_icmpeq +11 -> 808
    //   800: iload 5
    //   802: sipush 206
    //   805: if_icmpne +31 -> 836
    //   808: aload_0
    //   809: aload_1
    //   810: ldc_w 784
    //   813: new 279	java/lang/StringBuilder
    //   816: dup
    //   817: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   820: ldc_w 786
    //   823: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: iconst_0
    //   827: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   836: aload_2
    //   837: ifnull +13 -> 850
    //   840: aload_2
    //   841: getfield 765	com/tencent/mobileqq/utils/httputils/HttpCommunicator$a:ej	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   844: invokevirtual 486	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   847: ifne +101 -> 948
    //   850: aload_0
    //   851: aload_1
    //   852: ldc_w 788
    //   855: new 279	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   862: ldc_w 790
    //   865: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload_1
    //   869: invokevirtual 793	aqog:getErrorString	()Ljava/lang/String;
    //   872: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: ldc_w 795
    //   878: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: aload_1
    //   882: invokevirtual 798	aqog:Co	()Ljava/lang/String;
    //   885: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   891: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   894: aload_1
    //   895: getfield 857	aqog:errCode	I
    //   898: sipush -9527
    //   901: if_icmpne +47 -> 948
    //   904: aload_0
    //   905: aload_1
    //   906: ldc_w 859
    //   909: new 279	java/lang/StringBuilder
    //   912: dup
    //   913: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   916: ldc_w 821
    //   919: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: aload_1
    //   923: getfield 405	aqog:cuv	Ljava/lang/String;
    //   926: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: ldc_w 823
    //   932: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: aload_1
    //   936: getfield 622	aqog:cuw	Ljava/lang/String;
    //   939: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   945: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   948: aload_0
    //   949: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   952: ifnull +17 -> 969
    //   955: aload 26
    //   957: ifnull +12 -> 969
    //   960: aload_0
    //   961: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   964: aload 26
    //   966: invokevirtual 802	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   969: lload 13
    //   971: lconst_0
    //   972: ladd
    //   973: lstore 13
    //   975: lload 13
    //   977: lconst_0
    //   978: lcmp
    //   979: ifeq +26 -> 1005
    //   982: aload_1
    //   983: invokevirtual 265	aqog:getRequestMethod	()Ljava/lang/String;
    //   986: ldc_w 262
    //   989: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   992: ifeq +83 -> 1075
    //   995: iconst_1
    //   996: istore_3
    //   997: aload_0
    //   998: aload_1
    //   999: iload_3
    //   1000: lload 13
    //   1002: invokevirtual 805	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;ZJ)V
    //   1005: iconst_0
    //   1006: ifeq +11 -> 1017
    //   1009: new 807	java/lang/NullPointerException
    //   1012: dup
    //   1013: invokespecial 808	java/lang/NullPointerException:<init>	()V
    //   1016: athrow
    //   1017: iconst_0
    //   1018: ifeq +11 -> 1029
    //   1021: new 807	java/lang/NullPointerException
    //   1024: dup
    //   1025: invokespecial 808	java/lang/NullPointerException:<init>	()V
    //   1028: athrow
    //   1029: aload 25
    //   1031: ifnull +8 -> 1039
    //   1034: aload 25
    //   1036: invokevirtual 810	java/io/OutputStream:close	()V
    //   1039: aload 24
    //   1041: ifnull -486 -> 555
    //   1044: aload 24
    //   1046: invokevirtual 813	java/net/HttpURLConnection:disconnect	()V
    //   1049: return
    //   1050: astore_1
    //   1051: aload_1
    //   1052: invokevirtual 685	java/lang/Exception:printStackTrace	()V
    //   1055: return
    //   1056: new 353	java/net/URL
    //   1059: dup
    //   1060: aload_1
    //   1061: invokevirtual 143	aqog:getUrl	()Ljava/lang/String;
    //   1064: invokespecial 356	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1067: invokevirtual 848	java/net/URL:getHost	()Ljava/lang/String;
    //   1070: astore 23
    //   1072: goto -321 -> 751
    //   1075: iconst_0
    //   1076: istore_3
    //   1077: goto -80 -> 997
    //   1080: astore 23
    //   1082: aload_0
    //   1083: aload_1
    //   1084: ldc_w 861
    //   1087: ldc_w 863
    //   1090: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   1093: aload_1
    //   1094: invokevirtual 866	aqog:aFo	()Z
    //   1097: ifne +227 -> 1324
    //   1100: aload 31
    //   1102: aload 32
    //   1104: invokeinterface 869 2 0
    //   1109: iload 5
    //   1111: sipush 200
    //   1114: if_icmpeq +11 -> 1125
    //   1117: iload 5
    //   1119: sipush 206
    //   1122: if_icmpne +31 -> 1153
    //   1125: aload_0
    //   1126: aload_1
    //   1127: ldc_w 784
    //   1130: new 279	java/lang/StringBuilder
    //   1133: dup
    //   1134: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   1137: ldc_w 786
    //   1140: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: iconst_0
    //   1144: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1147: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1150: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   1153: aload_2
    //   1154: ifnull +13 -> 1167
    //   1157: aload_2
    //   1158: getfield 765	com/tencent/mobileqq/utils/httputils/HttpCommunicator$a:ej	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1161: invokevirtual 486	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1164: ifne +47 -> 1211
    //   1167: aload_0
    //   1168: aload_1
    //   1169: ldc_w 788
    //   1172: new 279	java/lang/StringBuilder
    //   1175: dup
    //   1176: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   1179: ldc_w 790
    //   1182: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: aload_1
    //   1186: invokevirtual 793	aqog:getErrorString	()Ljava/lang/String;
    //   1189: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: ldc_w 795
    //   1195: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: aload_1
    //   1199: invokevirtual 798	aqog:Co	()Ljava/lang/String;
    //   1202: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   1211: aload_0
    //   1212: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   1215: ifnull +17 -> 1232
    //   1218: aload 26
    //   1220: ifnull +12 -> 1232
    //   1223: aload_0
    //   1224: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   1227: aload 26
    //   1229: invokevirtual 802	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1232: lload 13
    //   1234: lconst_0
    //   1235: ladd
    //   1236: lstore 13
    //   1238: lload 13
    //   1240: lconst_0
    //   1241: lcmp
    //   1242: ifeq +26 -> 1268
    //   1245: aload_1
    //   1246: invokevirtual 265	aqog:getRequestMethod	()Ljava/lang/String;
    //   1249: ldc_w 262
    //   1252: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1255: ifeq +64 -> 1319
    //   1258: iconst_1
    //   1259: istore_3
    //   1260: aload_0
    //   1261: aload_1
    //   1262: iload_3
    //   1263: lload 13
    //   1265: invokevirtual 805	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;ZJ)V
    //   1268: iconst_0
    //   1269: ifeq +11 -> 1280
    //   1272: new 807	java/lang/NullPointerException
    //   1275: dup
    //   1276: invokespecial 808	java/lang/NullPointerException:<init>	()V
    //   1279: athrow
    //   1280: iconst_0
    //   1281: ifeq +11 -> 1292
    //   1284: new 807	java/lang/NullPointerException
    //   1287: dup
    //   1288: invokespecial 808	java/lang/NullPointerException:<init>	()V
    //   1291: athrow
    //   1292: aload 25
    //   1294: ifnull +8 -> 1302
    //   1297: aload 25
    //   1299: invokevirtual 810	java/io/OutputStream:close	()V
    //   1302: aload 24
    //   1304: ifnull -749 -> 555
    //   1307: aload 24
    //   1309: invokevirtual 813	java/net/HttpURLConnection:disconnect	()V
    //   1312: return
    //   1313: astore_1
    //   1314: aload_1
    //   1315: invokevirtual 685	java/lang/Exception:printStackTrace	()V
    //   1318: return
    //   1319: iconst_0
    //   1320: istore_3
    //   1321: goto -61 -> 1260
    //   1324: aload_1
    //   1325: getfield 872	aqog:cVb	Z
    //   1328: ifeq +12 -> 1340
    //   1331: aload 31
    //   1333: aload 32
    //   1335: invokeinterface 869 2 0
    //   1340: aload_1
    //   1341: getfield 875	aqog:cMK	Z
    //   1344: ifne +14 -> 1358
    //   1347: aload_1
    //   1348: ldc_w 877
    //   1351: aload_1
    //   1352: invokevirtual 143	aqog:getUrl	()Ljava/lang/String;
    //   1355: invokevirtual 878	aqog:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1358: aload_1
    //   1359: aload 32
    //   1361: invokevirtual 881	aqog:setUrl	(Ljava/lang/String;)V
    //   1364: aload_1
    //   1365: getfield 831	aqog:cMH	Z
    //   1368: ifeq +56 -> 1424
    //   1371: aload 32
    //   1373: invokestatic 886	aopd:getHostFromUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   1376: astore 23
    //   1378: aload 23
    //   1380: invokestatic 843	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1383: ifne +12 -> 1395
    //   1386: aload_1
    //   1387: ldc_w 453
    //   1390: aload 23
    //   1392: invokevirtual 878	aqog:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1395: aload_0
    //   1396: aload_1
    //   1397: ldc_w 819
    //   1400: new 279	java/lang/StringBuilder
    //   1403: dup
    //   1404: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   1407: ldc_w 888
    //   1410: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: aload 23
    //   1415: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1421: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   1424: aload_1
    //   1425: ldc_w 890
    //   1428: invokevirtual 893	aqog:setRequestMethod	(Ljava/lang/String;)V
    //   1431: iload 6
    //   1433: iconst_1
    //   1434: iadd
    //   1435: istore 6
    //   1437: iload 5
    //   1439: istore 4
    //   1441: aload 25
    //   1443: astore 23
    //   1445: iconst_1
    //   1446: istore 11
    //   1448: aload 26
    //   1450: astore 25
    //   1452: goto -1393 -> 59
    //   1455: new 707	java/io/IOException
    //   1458: dup
    //   1459: ldc_w 895
    //   1462: invokespecial 896	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1465: athrow
    //   1466: astore 29
    //   1468: aload 26
    //   1470: astore 28
    //   1472: iconst_0
    //   1473: istore 6
    //   1475: iconst_1
    //   1476: istore_3
    //   1477: lconst_0
    //   1478: lstore 17
    //   1480: iload 5
    //   1482: istore 4
    //   1484: aload 24
    //   1486: astore 23
    //   1488: aconst_null
    //   1489: astore 24
    //   1491: aconst_null
    //   1492: astore 27
    //   1494: aload 25
    //   1496: astore 26
    //   1498: aload 24
    //   1500: astore 25
    //   1502: lload 13
    //   1504: lstore 15
    //   1506: lload 17
    //   1508: lstore 13
    //   1510: iload 6
    //   1512: istore 5
    //   1514: aload 28
    //   1516: astore 24
    //   1518: aload 29
    //   1520: astore 28
    //   1522: iconst_1
    //   1523: istore 6
    //   1525: aload 28
    //   1527: instanceof 707
    //   1530: istore 11
    //   1532: iload 11
    //   1534: ifeq +62 -> 1596
    //   1537: aload 23
    //   1539: ifnull +57 -> 1596
    //   1542: aconst_null
    //   1543: astore 30
    //   1545: aload 23
    //   1547: invokevirtual 900	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   1550: astore 29
    //   1552: aload 29
    //   1554: astore 30
    //   1556: sipush 10240
    //   1559: newarray byte
    //   1561: astore 32
    //   1563: aload 29
    //   1565: ifnull +21 -> 1586
    //   1568: aload 29
    //   1570: astore 30
    //   1572: aload 29
    //   1574: aload 32
    //   1576: invokevirtual 906	java/io/InputStream:read	([B)I
    //   1579: istore 7
    //   1581: iload 7
    //   1583: ifgt -15 -> 1568
    //   1586: aload 29
    //   1588: ifnull +8 -> 1596
    //   1591: aload 29
    //   1593: invokevirtual 907	java/io/InputStream:close	()V
    //   1596: aload_0
    //   1597: iload_3
    //   1598: iload 4
    //   1600: aload 23
    //   1602: aload_1
    //   1603: aload 28
    //   1605: invokevirtual 910	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ZILjava/net/HttpURLConnection;Laqog;Ljava/lang/Throwable;)V
    //   1608: iload_3
    //   1609: ifeq +48 -> 1657
    //   1612: iload 4
    //   1614: sipush 200
    //   1617: if_icmpeq +11 -> 1628
    //   1620: iload 4
    //   1622: sipush 206
    //   1625: if_icmpne +32 -> 1657
    //   1628: aload_0
    //   1629: aload_1
    //   1630: ldc_w 784
    //   1633: new 279	java/lang/StringBuilder
    //   1636: dup
    //   1637: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   1640: ldc_w 786
    //   1643: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1646: iload 5
    //   1648: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1651: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1654: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   1657: aload_2
    //   1658: ifnull +13 -> 1671
    //   1661: aload_2
    //   1662: getfield 765	com/tencent/mobileqq/utils/httputils/HttpCommunicator$a:ej	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1665: invokevirtual 486	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1668: ifne +101 -> 1769
    //   1671: aload_0
    //   1672: aload_1
    //   1673: ldc_w 788
    //   1676: new 279	java/lang/StringBuilder
    //   1679: dup
    //   1680: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   1683: ldc_w 790
    //   1686: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1689: aload_1
    //   1690: invokevirtual 793	aqog:getErrorString	()Ljava/lang/String;
    //   1693: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1696: ldc_w 795
    //   1699: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1702: aload_1
    //   1703: invokevirtual 798	aqog:Co	()Ljava/lang/String;
    //   1706: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1709: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1712: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   1715: aload_1
    //   1716: getfield 857	aqog:errCode	I
    //   1719: sipush -9527
    //   1722: if_icmpne +47 -> 1769
    //   1725: aload_0
    //   1726: aload_1
    //   1727: ldc_w 859
    //   1730: new 279	java/lang/StringBuilder
    //   1733: dup
    //   1734: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   1737: ldc_w 821
    //   1740: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1743: aload_1
    //   1744: getfield 405	aqog:cuv	Ljava/lang/String;
    //   1747: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1750: ldc_w 823
    //   1753: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1756: aload_1
    //   1757: getfield 622	aqog:cuw	Ljava/lang/String;
    //   1760: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1766: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   1769: aload_0
    //   1770: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   1773: ifnull +17 -> 1790
    //   1776: aload 24
    //   1778: ifnull +12 -> 1790
    //   1781: aload_0
    //   1782: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   1785: aload 24
    //   1787: invokevirtual 802	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1790: lload 15
    //   1792: lload 13
    //   1794: ladd
    //   1795: lstore 13
    //   1797: lload 13
    //   1799: lconst_0
    //   1800: lcmp
    //   1801: ifeq +26 -> 1827
    //   1804: aload_1
    //   1805: invokevirtual 265	aqog:getRequestMethod	()Ljava/lang/String;
    //   1808: ldc_w 262
    //   1811: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1814: ifeq +2558 -> 4372
    //   1817: iconst_1
    //   1818: istore_3
    //   1819: aload_0
    //   1820: aload_1
    //   1821: iload_3
    //   1822: lload 13
    //   1824: invokevirtual 805	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;ZJ)V
    //   1827: aload 25
    //   1829: ifnull +8 -> 1837
    //   1832: aload 25
    //   1834: invokevirtual 913	java/io/ByteArrayOutputStream:close	()V
    //   1837: aload 27
    //   1839: ifnull +8 -> 1847
    //   1842: aload 27
    //   1844: invokevirtual 907	java/io/InputStream:close	()V
    //   1847: aload 26
    //   1849: ifnull +8 -> 1857
    //   1852: aload 26
    //   1854: invokevirtual 810	java/io/OutputStream:close	()V
    //   1857: iload 6
    //   1859: istore 5
    //   1861: aload 23
    //   1863: ifnull +12 -> 1875
    //   1866: aload 23
    //   1868: invokevirtual 813	java/net/HttpURLConnection:disconnect	()V
    //   1871: iload 6
    //   1873: istore 5
    //   1875: aload_2
    //   1876: ifnull +13 -> 1889
    //   1879: aload_2
    //   1880: getfield 765	com/tencent/mobileqq/utils/httputils/HttpCommunicator$a:ej	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1883: invokevirtual 486	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1886: ifne -1331 -> 555
    //   1889: aload_1
    //   1890: getfield 916	aqog:ek	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1893: invokevirtual 486	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1896: ifne -1341 -> 555
    //   1899: iload 5
    //   1901: ifeq +2503 -> 4404
    //   1904: aload 31
    //   1906: aload_1
    //   1907: aload_1
    //   1908: invokeinterface 587 3 0
    //   1913: return
    //   1914: astore_2
    //   1915: aload_0
    //   1916: aload_1
    //   1917: ldc_w 918
    //   1920: aload_2
    //   1921: invokestatic 924	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1924: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   1927: return
    //   1928: new 135	java/lang/Exception
    //   1931: dup
    //   1932: ldc_w 926
    //   1935: invokespecial 927	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1938: athrow
    //   1939: astore 23
    //   1941: iconst_0
    //   1942: istore 4
    //   1944: iload 11
    //   1946: istore_3
    //   1947: iload 7
    //   1949: istore 6
    //   1951: iload_3
    //   1952: ifeq +48 -> 2000
    //   1955: iload 5
    //   1957: sipush 200
    //   1960: if_icmpeq +11 -> 1971
    //   1963: iload 5
    //   1965: sipush 206
    //   1968: if_icmpne +32 -> 2000
    //   1971: aload_0
    //   1972: aload_1
    //   1973: ldc_w 784
    //   1976: new 279	java/lang/StringBuilder
    //   1979: dup
    //   1980: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   1983: ldc_w 786
    //   1986: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1989: iload 6
    //   1991: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1994: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1997: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   2000: aload_2
    //   2001: ifnull +13 -> 2014
    //   2004: aload_2
    //   2005: getfield 765	com/tencent/mobileqq/utils/httputils/HttpCommunicator$a:ej	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2008: invokevirtual 486	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2011: ifne +106 -> 2117
    //   2014: aload_0
    //   2015: aload_1
    //   2016: ldc_w 788
    //   2019: new 279	java/lang/StringBuilder
    //   2022: dup
    //   2023: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   2026: ldc_w 790
    //   2029: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2032: aload_1
    //   2033: invokevirtual 793	aqog:getErrorString	()Ljava/lang/String;
    //   2036: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2039: ldc_w 795
    //   2042: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2045: aload_1
    //   2046: invokevirtual 798	aqog:Co	()Ljava/lang/String;
    //   2049: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2052: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2055: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   2058: iload 4
    //   2060: ifeq +57 -> 2117
    //   2063: aload_1
    //   2064: getfield 857	aqog:errCode	I
    //   2067: sipush -9527
    //   2070: if_icmpne +47 -> 2117
    //   2073: aload_0
    //   2074: aload_1
    //   2075: ldc_w 859
    //   2078: new 279	java/lang/StringBuilder
    //   2081: dup
    //   2082: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   2085: ldc_w 821
    //   2088: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2091: aload_1
    //   2092: getfield 405	aqog:cuv	Ljava/lang/String;
    //   2095: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2098: ldc_w 823
    //   2101: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2104: aload_1
    //   2105: getfield 622	aqog:cuw	Ljava/lang/String;
    //   2108: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2111: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2114: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   2117: aload_0
    //   2118: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   2121: ifnull +17 -> 2138
    //   2124: aload 26
    //   2126: ifnull +12 -> 2138
    //   2129: aload_0
    //   2130: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   2133: aload 26
    //   2135: invokevirtual 802	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   2138: lload 13
    //   2140: lload 15
    //   2142: ladd
    //   2143: lstore 13
    //   2145: lload 13
    //   2147: lconst_0
    //   2148: lcmp
    //   2149: ifeq +26 -> 2175
    //   2152: aload_1
    //   2153: invokevirtual 265	aqog:getRequestMethod	()Ljava/lang/String;
    //   2156: ldc_w 262
    //   2159: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2162: ifeq +2229 -> 4391
    //   2165: iconst_1
    //   2166: istore_3
    //   2167: aload_0
    //   2168: aload_1
    //   2169: iload_3
    //   2170: lload 13
    //   2172: invokevirtual 805	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;ZJ)V
    //   2175: aload 28
    //   2177: ifnull +8 -> 2185
    //   2180: aload 28
    //   2182: invokevirtual 913	java/io/ByteArrayOutputStream:close	()V
    //   2185: aload 27
    //   2187: ifnull +8 -> 2195
    //   2190: aload 27
    //   2192: invokevirtual 907	java/io/InputStream:close	()V
    //   2195: aload 25
    //   2197: ifnull +8 -> 2205
    //   2200: aload 25
    //   2202: invokevirtual 810	java/io/OutputStream:close	()V
    //   2205: aload 24
    //   2207: ifnull +8 -> 2215
    //   2210: aload 24
    //   2212: invokevirtual 813	java/net/HttpURLConnection:disconnect	()V
    //   2215: aload 23
    //   2217: athrow
    //   2218: aload_0
    //   2219: aload_1
    //   2220: aconst_null
    //   2221: iconst_2
    //   2222: iload_3
    //   2223: invokespecial 709	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Laqog;IZ)V
    //   2226: iload 5
    //   2228: sipush 200
    //   2231: if_icmpeq +11 -> 2242
    //   2234: iload 5
    //   2236: sipush 206
    //   2239: if_icmpne +1696 -> 3935
    //   2242: aload 24
    //   2244: invokevirtual 613	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2247: astore 23
    //   2249: aload 23
    //   2251: ifnonnull +281 -> 2532
    //   2254: ldc_w 501
    //   2257: astore 23
    //   2259: iload_3
    //   2260: ifne +282 -> 2542
    //   2263: aload_1
    //   2264: getfield 930	aqog:cUY	Z
    //   2267: ifeq +275 -> 2542
    //   2270: aload 23
    //   2272: ldc_w 932
    //   2275: invokevirtual 935	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2278: iconst_m1
    //   2279: if_icmpne +15 -> 2294
    //   2282: aload 23
    //   2284: ldc_w 937
    //   2287: invokevirtual 935	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2290: iconst_m1
    //   2291: if_icmpeq +251 -> 2542
    //   2294: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2297: ifeq +18 -> 2315
    //   2300: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2303: ifeq +12 -> 2315
    //   2306: ldc 87
    //   2308: iconst_2
    //   2309: ldc_w 939
    //   2312: invokestatic 578	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2315: aload_0
    //   2316: aload_1
    //   2317: aload_2
    //   2318: iconst_1
    //   2319: invokevirtual 941	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator$a;Z)V
    //   2322: iload 5
    //   2324: sipush 200
    //   2327: if_icmpeq +11 -> 2338
    //   2330: iload 5
    //   2332: sipush 206
    //   2335: if_icmpne +31 -> 2366
    //   2338: aload_0
    //   2339: aload_1
    //   2340: ldc_w 784
    //   2343: new 279	java/lang/StringBuilder
    //   2346: dup
    //   2347: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   2350: ldc_w 786
    //   2353: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2356: iconst_0
    //   2357: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2360: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2363: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   2366: aload_2
    //   2367: ifnull +13 -> 2380
    //   2370: aload_2
    //   2371: getfield 765	com/tencent/mobileqq/utils/httputils/HttpCommunicator$a:ej	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2374: invokevirtual 486	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2377: ifne +47 -> 2424
    //   2380: aload_0
    //   2381: aload_1
    //   2382: ldc_w 788
    //   2385: new 279	java/lang/StringBuilder
    //   2388: dup
    //   2389: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   2392: ldc_w 790
    //   2395: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2398: aload_1
    //   2399: invokevirtual 793	aqog:getErrorString	()Ljava/lang/String;
    //   2402: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2405: ldc_w 795
    //   2408: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2411: aload_1
    //   2412: invokevirtual 798	aqog:Co	()Ljava/lang/String;
    //   2415: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2418: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2421: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   2424: aload_0
    //   2425: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   2428: ifnull +17 -> 2445
    //   2431: aload 26
    //   2433: ifnull +12 -> 2445
    //   2436: aload_0
    //   2437: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   2440: aload 26
    //   2442: invokevirtual 802	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   2445: lload 13
    //   2447: lconst_0
    //   2448: ladd
    //   2449: lstore 13
    //   2451: lload 13
    //   2453: lconst_0
    //   2454: lcmp
    //   2455: ifeq +26 -> 2481
    //   2458: aload_1
    //   2459: invokevirtual 265	aqog:getRequestMethod	()Ljava/lang/String;
    //   2462: ldc_w 262
    //   2465: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2468: ifeq +2894 -> 5362
    //   2471: iconst_1
    //   2472: istore_3
    //   2473: aload_0
    //   2474: aload_1
    //   2475: iload_3
    //   2476: lload 13
    //   2478: invokevirtual 805	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;ZJ)V
    //   2481: iconst_0
    //   2482: ifeq +11 -> 2493
    //   2485: new 807	java/lang/NullPointerException
    //   2488: dup
    //   2489: invokespecial 808	java/lang/NullPointerException:<init>	()V
    //   2492: athrow
    //   2493: iconst_0
    //   2494: ifeq +11 -> 2505
    //   2497: new 807	java/lang/NullPointerException
    //   2500: dup
    //   2501: invokespecial 808	java/lang/NullPointerException:<init>	()V
    //   2504: athrow
    //   2505: aload 25
    //   2507: ifnull +8 -> 2515
    //   2510: aload 25
    //   2512: invokevirtual 810	java/io/OutputStream:close	()V
    //   2515: aload 24
    //   2517: ifnull -1962 -> 555
    //   2520: aload 24
    //   2522: invokevirtual 813	java/net/HttpURLConnection:disconnect	()V
    //   2525: return
    //   2526: astore_1
    //   2527: aload_1
    //   2528: invokevirtual 685	java/lang/Exception:printStackTrace	()V
    //   2531: return
    //   2532: aload 23
    //   2534: invokevirtual 944	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2537: astore 23
    //   2539: goto -280 -> 2259
    //   2542: aload_1
    //   2543: getfield 948	aqog:hX	[Ljava/lang/String;
    //   2546: ifnull +224 -> 2770
    //   2549: aload_1
    //   2550: getfield 948	aqog:hX	[Ljava/lang/String;
    //   2553: arraylength
    //   2554: ifle +216 -> 2770
    //   2557: aload 23
    //   2559: invokevirtual 775	java/lang/String:length	()I
    //   2562: ifle +208 -> 2770
    //   2565: iconst_0
    //   2566: istore 8
    //   2568: aload_1
    //   2569: getfield 948	aqog:hX	[Ljava/lang/String;
    //   2572: arraylength
    //   2573: iconst_1
    //   2574: if_icmpne +100 -> 2674
    //   2577: aload_1
    //   2578: getfield 948	aqog:hX	[Ljava/lang/String;
    //   2581: iconst_0
    //   2582: aaload
    //   2583: ifnull +91 -> 2674
    //   2586: aload_1
    //   2587: getfield 948	aqog:hX	[Ljava/lang/String;
    //   2590: iconst_0
    //   2591: aaload
    //   2592: invokevirtual 944	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2595: ldc_w 950
    //   2598: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2601: ifeq +73 -> 2674
    //   2604: iconst_1
    //   2605: istore 4
    //   2607: iload 4
    //   2609: ifne +161 -> 2770
    //   2612: new 279	java/lang/StringBuilder
    //   2615: dup
    //   2616: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   2619: astore 30
    //   2621: aload_1
    //   2622: getfield 948	aqog:hX	[Ljava/lang/String;
    //   2625: astore 29
    //   2627: aload 29
    //   2629: arraylength
    //   2630: istore 6
    //   2632: iconst_0
    //   2633: istore 4
    //   2635: iload 4
    //   2637: iload 6
    //   2639: if_icmpge +88 -> 2727
    //   2642: aload 29
    //   2644: iload 4
    //   2646: aaload
    //   2647: astore 32
    //   2649: aload 32
    //   2651: ifnull +2716 -> 5367
    //   2654: aload 30
    //   2656: aload 32
    //   2658: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2661: pop
    //   2662: aload 30
    //   2664: ldc_w 952
    //   2667: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2670: pop
    //   2671: goto +2696 -> 5367
    //   2674: aload_1
    //   2675: getfield 948	aqog:hX	[Ljava/lang/String;
    //   2678: astore 30
    //   2680: aload 30
    //   2682: arraylength
    //   2683: istore 9
    //   2685: iconst_0
    //   2686: istore 6
    //   2688: iload 8
    //   2690: istore 4
    //   2692: iload 6
    //   2694: iload 9
    //   2696: if_icmpge -89 -> 2607
    //   2699: aload 30
    //   2701: iload 6
    //   2703: aaload
    //   2704: astore 29
    //   2706: aload 29
    //   2708: ifnull +2668 -> 5376
    //   2711: aload 23
    //   2713: aload 29
    //   2715: invokevirtual 955	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2718: ifeq +2658 -> 5376
    //   2721: iconst_1
    //   2722: istore 4
    //   2724: goto -117 -> 2607
    //   2727: new 707	java/io/IOException
    //   2730: dup
    //   2731: new 279	java/lang/StringBuilder
    //   2734: dup
    //   2735: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   2738: ldc_w 957
    //   2741: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2744: aload 23
    //   2746: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2749: ldc_w 959
    //   2752: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2755: aload 30
    //   2757: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2760: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2763: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2766: invokespecial 896	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2769: athrow
    //   2770: aload_1
    //   2771: getfield 650	aqog:totalLen	J
    //   2774: lconst_0
    //   2775: lcmp
    //   2776: ifne +27 -> 2803
    //   2779: aload_1
    //   2780: invokevirtual 265	aqog:getRequestMethod	()Ljava/lang/String;
    //   2783: ldc_w 262
    //   2786: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2789: ifne +14 -> 2803
    //   2792: new 707	java/io/IOException
    //   2795: dup
    //   2796: ldc_w 961
    //   2799: invokespecial 896	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2802: athrow
    //   2803: aload_0
    //   2804: aload_1
    //   2805: ldc_w 963
    //   2808: new 279	java/lang/StringBuilder
    //   2811: dup
    //   2812: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   2815: ldc_w 965
    //   2818: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2821: aload_1
    //   2822: getfield 650	aqog:totalLen	J
    //   2825: invokevirtual 525	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2828: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2831: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   2834: aload_1
    //   2835: getfield 723	aqog:startTime	J
    //   2838: lconst_0
    //   2839: lcmp
    //   2840: ifeq +15 -> 2855
    //   2843: aload_1
    //   2844: invokestatic 549	android/os/SystemClock:uptimeMillis	()J
    //   2847: aload_1
    //   2848: getfield 723	aqog:startTime	J
    //   2851: lsub
    //   2852: putfield 968	aqog:cost	J
    //   2855: aload 31
    //   2857: aload_1
    //   2858: aload_1
    //   2859: iconst_3
    //   2860: invokeinterface 435 4 0
    //   2865: istore_3
    //   2866: iload_3
    //   2867: ifeq +2469 -> 5336
    //   2870: lconst_0
    //   2871: ldc2_w 776
    //   2874: ladd
    //   2875: lstore 15
    //   2877: aload 24
    //   2879: invokevirtual 971	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2882: astore 23
    //   2884: invokestatic 977	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   2887: astore 29
    //   2889: invokestatic 980	com/tencent/commonsdk/pool/ByteArrayPool:getMaxBufInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   2892: astore 27
    //   2894: aload_1
    //   2895: getfield 983	aqog:cMY	Z
    //   2898: ifeq +251 -> 3149
    //   2901: aload_1
    //   2902: invokevirtual 986	aqog:aFn	()Z
    //   2905: ifne +244 -> 3149
    //   2908: new 988	aqjg
    //   2911: dup
    //   2912: aload 27
    //   2914: aload_1
    //   2915: getfield 650	aqog:totalLen	J
    //   2918: l2i
    //   2919: invokespecial 991	aqjg:<init>	(Lcom/tencent/commonsdk/pool/ByteArrayPool;I)V
    //   2922: astore 27
    //   2924: aload_1
    //   2925: getfield 983	aqog:cMY	Z
    //   2928: ifeq +290 -> 3218
    //   2931: aload 29
    //   2933: sipush 10240
    //   2936: invokevirtual 995	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   2939: astore 28
    //   2941: iconst_0
    //   2942: istore 6
    //   2944: iconst_0
    //   2945: istore 4
    //   2947: iload 4
    //   2949: istore 8
    //   2951: lload 15
    //   2953: lstore 19
    //   2955: iload 4
    //   2957: istore 9
    //   2959: lload 15
    //   2961: lstore 21
    //   2963: aload 23
    //   2965: aload 28
    //   2967: iload 6
    //   2969: aload 28
    //   2971: arraylength
    //   2972: iload 6
    //   2974: isub
    //   2975: invokevirtual 998	java/io/InputStream:read	([BII)I
    //   2978: istore 7
    //   2980: iload 7
    //   2982: ifle +283 -> 3265
    //   2985: iload 4
    //   2987: istore 8
    //   2989: lload 15
    //   2991: lstore 19
    //   2993: iload 4
    //   2995: istore 9
    //   2997: lload 15
    //   2999: lstore 21
    //   3001: aload_0
    //   3002: aload_2
    //   3003: aload_1
    //   3004: invokevirtual 714	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator$a;Laqog;)V
    //   3007: lload 15
    //   3009: iload 7
    //   3011: i2l
    //   3012: ladd
    //   3013: lstore 17
    //   3015: iload 6
    //   3017: iload 7
    //   3019: iadd
    //   3020: istore 10
    //   3022: iload 4
    //   3024: iload 7
    //   3026: iadd
    //   3027: istore 7
    //   3029: iload 7
    //   3031: istore 4
    //   3033: lload 17
    //   3035: lstore 15
    //   3037: iload 10
    //   3039: istore 6
    //   3041: iload 7
    //   3043: istore 8
    //   3045: lload 17
    //   3047: lstore 19
    //   3049: iload 7
    //   3051: istore 9
    //   3053: lload 17
    //   3055: lstore 21
    //   3057: iload 10
    //   3059: aload 28
    //   3061: arraylength
    //   3062: if_icmplt -115 -> 2947
    //   3065: iload 7
    //   3067: istore 8
    //   3069: lload 17
    //   3071: lstore 19
    //   3073: iload 7
    //   3075: istore 9
    //   3077: lload 17
    //   3079: lstore 21
    //   3081: aload_1
    //   3082: invokevirtual 986	aqog:aFn	()Z
    //   3085: ifeq +143 -> 3228
    //   3088: iload 7
    //   3090: istore 8
    //   3092: lload 17
    //   3094: lstore 19
    //   3096: iload 7
    //   3098: istore 9
    //   3100: lload 17
    //   3102: lstore 21
    //   3104: aload_1
    //   3105: aload 28
    //   3107: invokevirtual 1002	aqog:bD	([B)V
    //   3110: iload 7
    //   3112: istore 8
    //   3114: lload 17
    //   3116: lstore 19
    //   3118: iload 7
    //   3120: istore 9
    //   3122: lload 17
    //   3124: lstore 21
    //   3126: aload 31
    //   3128: aload_1
    //   3129: aload_1
    //   3130: invokeinterface 1004 3 0
    //   3135: iconst_0
    //   3136: istore 6
    //   3138: iload 7
    //   3140: istore 4
    //   3142: lload 17
    //   3144: lstore 15
    //   3146: goto -199 -> 2947
    //   3149: new 912	java/io/ByteArrayOutputStream
    //   3152: dup
    //   3153: invokespecial 1005	java/io/ByteArrayOutputStream:<init>	()V
    //   3156: astore 27
    //   3158: goto -234 -> 2924
    //   3161: astore 28
    //   3163: iconst_0
    //   3164: istore 6
    //   3166: iconst_1
    //   3167: istore_3
    //   3168: lload 15
    //   3170: lstore 17
    //   3172: aload 23
    //   3174: astore 27
    //   3176: iload 5
    //   3178: istore 4
    //   3180: aconst_null
    //   3181: astore 30
    //   3183: aload 26
    //   3185: astore 29
    //   3187: aload 24
    //   3189: astore 23
    //   3191: lload 13
    //   3193: lstore 15
    //   3195: aload 25
    //   3197: astore 26
    //   3199: aload 29
    //   3201: astore 24
    //   3203: iload 6
    //   3205: istore 5
    //   3207: lload 17
    //   3209: lstore 13
    //   3211: aload 30
    //   3213: astore 25
    //   3215: goto -1693 -> 1522
    //   3218: sipush 10240
    //   3221: newarray byte
    //   3223: astore 28
    //   3225: goto -284 -> 2941
    //   3228: iload 7
    //   3230: istore 8
    //   3232: lload 17
    //   3234: lstore 19
    //   3236: iload 7
    //   3238: istore 9
    //   3240: lload 17
    //   3242: lstore 21
    //   3244: aload 27
    //   3246: aload 28
    //   3248: invokevirtual 1007	java/io/ByteArrayOutputStream:write	([B)V
    //   3251: iconst_0
    //   3252: istore 6
    //   3254: iload 7
    //   3256: istore 4
    //   3258: lload 17
    //   3260: lstore 15
    //   3262: goto -315 -> 2947
    //   3265: iload 4
    //   3267: istore 8
    //   3269: lload 15
    //   3271: lstore 19
    //   3273: iload 4
    //   3275: istore 9
    //   3277: lload 15
    //   3279: lstore 21
    //   3281: aload_1
    //   3282: invokevirtual 986	aqog:aFn	()Z
    //   3285: ifeq +494 -> 3779
    //   3288: iload 6
    //   3290: ifle +99 -> 3389
    //   3293: iload 4
    //   3295: istore 8
    //   3297: lload 15
    //   3299: lstore 19
    //   3301: iload 4
    //   3303: istore 9
    //   3305: lload 15
    //   3307: lstore 21
    //   3309: iload 6
    //   3311: newarray byte
    //   3313: astore 30
    //   3315: iload 4
    //   3317: istore 8
    //   3319: lload 15
    //   3321: lstore 19
    //   3323: iload 4
    //   3325: istore 9
    //   3327: lload 15
    //   3329: lstore 21
    //   3331: aload 28
    //   3333: iconst_0
    //   3334: aload 30
    //   3336: iconst_0
    //   3337: iload 6
    //   3339: invokestatic 1011	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3342: iload 4
    //   3344: istore 8
    //   3346: lload 15
    //   3348: lstore 19
    //   3350: iload 4
    //   3352: istore 9
    //   3354: lload 15
    //   3356: lstore 21
    //   3358: aload_1
    //   3359: aload 30
    //   3361: invokevirtual 1002	aqog:bD	([B)V
    //   3364: iload 4
    //   3366: istore 8
    //   3368: lload 15
    //   3370: lstore 19
    //   3372: iload 4
    //   3374: istore 9
    //   3376: lload 15
    //   3378: lstore 21
    //   3380: aload 31
    //   3382: aload_1
    //   3383: aload_1
    //   3384: invokeinterface 1004 3 0
    //   3389: iload 4
    //   3391: istore 8
    //   3393: lload 15
    //   3395: lstore 19
    //   3397: iload 4
    //   3399: istore 9
    //   3401: lload 15
    //   3403: lstore 21
    //   3405: aload_1
    //   3406: getfield 983	aqog:cMY	Z
    //   3409: ifeq +26 -> 3435
    //   3412: iload 4
    //   3414: istore 8
    //   3416: lload 15
    //   3418: lstore 19
    //   3420: iload 4
    //   3422: istore 9
    //   3424: lload 15
    //   3426: lstore 21
    //   3428: aload 29
    //   3430: aload 28
    //   3432: invokevirtual 1014	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   3435: iload 4
    //   3437: istore 8
    //   3439: lload 15
    //   3441: lstore 19
    //   3443: iload 4
    //   3445: istore 9
    //   3447: lload 15
    //   3449: lstore 21
    //   3451: aload 27
    //   3453: invokevirtual 913	java/io/ByteArrayOutputStream:close	()V
    //   3456: aload 27
    //   3458: astore 28
    //   3460: aload 23
    //   3462: astore 27
    //   3464: aload 28
    //   3466: astore 23
    //   3468: aload 31
    //   3470: aload_1
    //   3471: aload_1
    //   3472: iconst_4
    //   3473: invokeinterface 435 4 0
    //   3478: pop
    //   3479: iload 4
    //   3481: istore 6
    //   3483: iconst_0
    //   3484: istore 4
    //   3486: aload 23
    //   3488: astore 28
    //   3490: aload 27
    //   3492: astore 23
    //   3494: iload 5
    //   3496: sipush 200
    //   3499: if_icmpeq +11 -> 3510
    //   3502: iload 5
    //   3504: sipush 206
    //   3507: if_icmpne +32 -> 3539
    //   3510: aload_0
    //   3511: aload_1
    //   3512: ldc_w 784
    //   3515: new 279	java/lang/StringBuilder
    //   3518: dup
    //   3519: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   3522: ldc_w 786
    //   3525: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3528: iload 6
    //   3530: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3533: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3536: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   3539: aload_2
    //   3540: ifnull +13 -> 3553
    //   3543: aload_2
    //   3544: getfield 765	com/tencent/mobileqq/utils/httputils/HttpCommunicator$a:ej	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3547: invokevirtual 486	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3550: ifne +106 -> 3656
    //   3553: aload_0
    //   3554: aload_1
    //   3555: ldc_w 788
    //   3558: new 279	java/lang/StringBuilder
    //   3561: dup
    //   3562: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   3565: ldc_w 790
    //   3568: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3571: aload_1
    //   3572: invokevirtual 793	aqog:getErrorString	()Ljava/lang/String;
    //   3575: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3578: ldc_w 795
    //   3581: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3584: aload_1
    //   3585: invokevirtual 798	aqog:Co	()Ljava/lang/String;
    //   3588: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3591: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3594: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   3597: iload 4
    //   3599: ifeq +57 -> 3656
    //   3602: aload_1
    //   3603: getfield 857	aqog:errCode	I
    //   3606: sipush -9527
    //   3609: if_icmpne +47 -> 3656
    //   3612: aload_0
    //   3613: aload_1
    //   3614: ldc_w 859
    //   3617: new 279	java/lang/StringBuilder
    //   3620: dup
    //   3621: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   3624: ldc_w 821
    //   3627: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3630: aload_1
    //   3631: getfield 405	aqog:cuv	Ljava/lang/String;
    //   3634: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3637: ldc_w 823
    //   3640: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3643: aload_1
    //   3644: getfield 622	aqog:cuw	Ljava/lang/String;
    //   3647: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3650: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3653: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   3656: aload_0
    //   3657: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   3660: ifnull +17 -> 3677
    //   3663: aload 26
    //   3665: ifnull +12 -> 3677
    //   3668: aload_0
    //   3669: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   3672: aload 26
    //   3674: invokevirtual 802	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3677: lload 15
    //   3679: lload 13
    //   3681: ladd
    //   3682: lstore 13
    //   3684: lload 13
    //   3686: lconst_0
    //   3687: lcmp
    //   3688: ifeq +26 -> 3714
    //   3691: aload_1
    //   3692: invokevirtual 265	aqog:getRequestMethod	()Ljava/lang/String;
    //   3695: ldc_w 262
    //   3698: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3701: ifeq +572 -> 4273
    //   3704: iconst_1
    //   3705: istore_3
    //   3706: aload_0
    //   3707: aload_1
    //   3708: iload_3
    //   3709: lload 13
    //   3711: invokevirtual 805	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;ZJ)V
    //   3714: aload 28
    //   3716: ifnull +8 -> 3724
    //   3719: aload 28
    //   3721: invokevirtual 913	java/io/ByteArrayOutputStream:close	()V
    //   3724: aload 23
    //   3726: ifnull +8 -> 3734
    //   3729: aload 23
    //   3731: invokevirtual 907	java/io/InputStream:close	()V
    //   3734: aload 25
    //   3736: ifnull +8 -> 3744
    //   3739: aload 25
    //   3741: invokevirtual 810	java/io/OutputStream:close	()V
    //   3744: iload 4
    //   3746: istore 5
    //   3748: aload 24
    //   3750: ifnull -1875 -> 1875
    //   3753: aload 24
    //   3755: invokevirtual 813	java/net/HttpURLConnection:disconnect	()V
    //   3758: iload 4
    //   3760: istore 5
    //   3762: goto -1887 -> 1875
    //   3765: astore 23
    //   3767: aload 23
    //   3769: invokevirtual 685	java/lang/Exception:printStackTrace	()V
    //   3772: iload 4
    //   3774: istore 5
    //   3776: goto -1901 -> 1875
    //   3779: iload 6
    //   3781: ifle +29 -> 3810
    //   3784: iload 4
    //   3786: istore 8
    //   3788: lload 15
    //   3790: lstore 19
    //   3792: iload 4
    //   3794: istore 9
    //   3796: lload 15
    //   3798: lstore 21
    //   3800: aload 27
    //   3802: aload 28
    //   3804: iconst_0
    //   3805: iload 6
    //   3807: invokevirtual 1015	java/io/ByteArrayOutputStream:write	([BII)V
    //   3810: iload 4
    //   3812: istore 8
    //   3814: lload 15
    //   3816: lstore 19
    //   3818: iload 4
    //   3820: istore 9
    //   3822: lload 15
    //   3824: lstore 21
    //   3826: aload 27
    //   3828: invokevirtual 1016	java/io/ByteArrayOutputStream:flush	()V
    //   3831: iload 4
    //   3833: istore 8
    //   3835: lload 15
    //   3837: lstore 19
    //   3839: iload 4
    //   3841: istore 9
    //   3843: lload 15
    //   3845: lstore 21
    //   3847: aload_1
    //   3848: aload 27
    //   3850: invokevirtual 1019	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   3853: invokevirtual 1002	aqog:bD	([B)V
    //   3856: iload 4
    //   3858: istore 8
    //   3860: lload 15
    //   3862: lstore 19
    //   3864: iload 4
    //   3866: istore 9
    //   3868: lload 15
    //   3870: lstore 21
    //   3872: aload 31
    //   3874: aload_1
    //   3875: aload_1
    //   3876: invokeinterface 1004 3 0
    //   3881: goto -492 -> 3389
    //   3884: astore 28
    //   3886: aload 23
    //   3888: astore 29
    //   3890: iload 5
    //   3892: istore 4
    //   3894: iconst_1
    //   3895: istore_3
    //   3896: aload 24
    //   3898: astore 23
    //   3900: aload 25
    //   3902: astore 30
    //   3904: lload 13
    //   3906: lstore 15
    //   3908: aload 27
    //   3910: astore 25
    //   3912: aload 26
    //   3914: astore 24
    //   3916: iload 8
    //   3918: istore 5
    //   3920: lload 19
    //   3922: lstore 13
    //   3924: aload 30
    //   3926: astore 26
    //   3928: aload 29
    //   3930: astore 27
    //   3932: goto -2410 -> 1522
    //   3935: aload_1
    //   3936: getfield 213	aqog:cVc	Z
    //   3939: ifeq +301 -> 4240
    //   3942: aload_1
    //   3943: getfield 229	aqog:eaI	I
    //   3946: ifeq +294 -> 4240
    //   3949: aload_1
    //   3950: getfield 226	aqog:cVd	Z
    //   3953: ifne +287 -> 4240
    //   3956: aload_0
    //   3957: aload_1
    //   3958: ldc_w 1021
    //   3961: ldc_w 1023
    //   3964: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   3967: aload_1
    //   3968: iconst_1
    //   3969: putfield 226	aqog:cVd	Z
    //   3972: aload_0
    //   3973: aload_1
    //   3974: aload_2
    //   3975: iconst_0
    //   3976: invokevirtual 941	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator$a;Z)V
    //   3979: new 151	java/util/HashMap
    //   3982: dup
    //   3983: invokespecial 1024	java/util/HashMap:<init>	()V
    //   3986: astore 23
    //   3988: aload 23
    //   3990: ldc_w 1026
    //   3993: aload_1
    //   3994: getfield 229	aqog:eaI	I
    //   3997: invokestatic 1028	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   4000: invokevirtual 1032	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4003: pop
    //   4004: invokestatic 177	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4007: invokestatic 1037	anpc:a	(Landroid/content/Context;)Lanpc;
    //   4010: aconst_null
    //   4011: ldc_w 1039
    //   4014: iconst_0
    //   4015: lconst_0
    //   4016: lconst_0
    //   4017: aload 23
    //   4019: ldc_w 501
    //   4022: invokevirtual 1043	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   4025: iload 5
    //   4027: sipush 200
    //   4030: if_icmpeq +11 -> 4041
    //   4033: iload 5
    //   4035: sipush 206
    //   4038: if_icmpne +31 -> 4069
    //   4041: aload_0
    //   4042: aload_1
    //   4043: ldc_w 784
    //   4046: new 279	java/lang/StringBuilder
    //   4049: dup
    //   4050: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   4053: ldc_w 786
    //   4056: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4059: iconst_0
    //   4060: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4063: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4066: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   4069: aload_2
    //   4070: ifnull +13 -> 4083
    //   4073: aload_2
    //   4074: getfield 765	com/tencent/mobileqq/utils/httputils/HttpCommunicator$a:ej	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4077: invokevirtual 486	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   4080: ifne +47 -> 4127
    //   4083: aload_0
    //   4084: aload_1
    //   4085: ldc_w 788
    //   4088: new 279	java/lang/StringBuilder
    //   4091: dup
    //   4092: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   4095: ldc_w 790
    //   4098: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4101: aload_1
    //   4102: invokevirtual 793	aqog:getErrorString	()Ljava/lang/String;
    //   4105: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4108: ldc_w 795
    //   4111: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4114: aload_1
    //   4115: invokevirtual 798	aqog:Co	()Ljava/lang/String;
    //   4118: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4121: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4124: invokevirtual 315	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;Ljava/lang/String;Ljava/lang/String;)V
    //   4127: aload_0
    //   4128: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   4131: ifnull +17 -> 4148
    //   4134: aload 26
    //   4136: ifnull +12 -> 4148
    //   4139: aload_0
    //   4140: getfield 422	com/tencent/mobileqq/utils/httputils/HttpCommunicator:N	Lmqq/os/MqqHandler;
    //   4143: aload 26
    //   4145: invokevirtual 802	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   4148: lload 13
    //   4150: lconst_0
    //   4151: ladd
    //   4152: lstore 13
    //   4154: lload 13
    //   4156: lconst_0
    //   4157: lcmp
    //   4158: ifeq +26 -> 4184
    //   4161: aload_1
    //   4162: invokevirtual 265	aqog:getRequestMethod	()Ljava/lang/String;
    //   4165: ldc_w 262
    //   4168: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4171: ifeq +64 -> 4235
    //   4174: iconst_1
    //   4175: istore_3
    //   4176: aload_0
    //   4177: aload_1
    //   4178: iload_3
    //   4179: lload 13
    //   4181: invokevirtual 805	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;ZJ)V
    //   4184: iconst_0
    //   4185: ifeq +11 -> 4196
    //   4188: new 807	java/lang/NullPointerException
    //   4191: dup
    //   4192: invokespecial 808	java/lang/NullPointerException:<init>	()V
    //   4195: athrow
    //   4196: iconst_0
    //   4197: ifeq +11 -> 4208
    //   4200: new 807	java/lang/NullPointerException
    //   4203: dup
    //   4204: invokespecial 808	java/lang/NullPointerException:<init>	()V
    //   4207: athrow
    //   4208: aload 25
    //   4210: ifnull +8 -> 4218
    //   4213: aload 25
    //   4215: invokevirtual 810	java/io/OutputStream:close	()V
    //   4218: aload 24
    //   4220: ifnull -3665 -> 555
    //   4223: aload 24
    //   4225: invokevirtual 813	java/net/HttpURLConnection:disconnect	()V
    //   4228: return
    //   4229: astore_1
    //   4230: aload_1
    //   4231: invokevirtual 685	java/lang/Exception:printStackTrace	()V
    //   4234: return
    //   4235: iconst_0
    //   4236: istore_3
    //   4237: goto -61 -> 4176
    //   4240: iconst_1
    //   4241: istore 4
    //   4243: aload_0
    //   4244: iload 5
    //   4246: aload 24
    //   4248: aload_1
    //   4249: invokevirtual 1045	com/tencent/mobileqq/utils/httputils/HttpCommunicator:b	(ILjava/net/HttpURLConnection;Laqog;)V
    //   4252: lconst_0
    //   4253: lstore 15
    //   4255: iconst_1
    //   4256: istore 4
    //   4258: iload 8
    //   4260: istore 6
    //   4262: aload 30
    //   4264: astore 28
    //   4266: aload 29
    //   4268: astore 23
    //   4270: goto -776 -> 3494
    //   4273: iconst_0
    //   4274: istore_3
    //   4275: goto -569 -> 3706
    //   4278: astore 29
    //   4280: aload 30
    //   4282: ifnull -2686 -> 1596
    //   4285: aload 30
    //   4287: invokevirtual 907	java/io/InputStream:close	()V
    //   4290: goto -2694 -> 1596
    //   4293: astore 29
    //   4295: goto -2699 -> 1596
    //   4298: astore 28
    //   4300: aconst_null
    //   4301: astore 29
    //   4303: aload 29
    //   4305: ifnull +8 -> 4313
    //   4308: aload 29
    //   4310: invokevirtual 907	java/io/InputStream:close	()V
    //   4313: aload 28
    //   4315: athrow
    //   4316: astore 30
    //   4318: lload 15
    //   4320: lstore 17
    //   4322: aload 25
    //   4324: astore 28
    //   4326: aload 26
    //   4328: astore 25
    //   4330: aload 23
    //   4332: astore 29
    //   4334: iload 4
    //   4336: istore 7
    //   4338: iconst_1
    //   4339: istore 4
    //   4341: aload 30
    //   4343: astore 23
    //   4345: aload 24
    //   4347: astore 26
    //   4349: iload 5
    //   4351: istore 6
    //   4353: iload 7
    //   4355: istore 5
    //   4357: lload 13
    //   4359: lstore 15
    //   4361: lload 17
    //   4363: lstore 13
    //   4365: aload 29
    //   4367: astore 24
    //   4369: goto -2418 -> 1951
    //   4372: iconst_0
    //   4373: istore_3
    //   4374: goto -2555 -> 1819
    //   4377: astore 23
    //   4379: aload 23
    //   4381: invokevirtual 685	java/lang/Exception:printStackTrace	()V
    //   4384: iload 6
    //   4386: istore 5
    //   4388: goto -2513 -> 1875
    //   4391: iconst_0
    //   4392: istore_3
    //   4393: goto -2226 -> 2167
    //   4396: astore_1
    //   4397: aload_1
    //   4398: invokevirtual 685	java/lang/Exception:printStackTrace	()V
    //   4401: goto -2186 -> 2215
    //   4404: aload 31
    //   4406: aload_1
    //   4407: aload_1
    //   4408: iconst_5
    //   4409: invokeinterface 435 4 0
    //   4414: pop
    //   4415: return
    //   4416: astore_1
    //   4417: goto -3894 -> 523
    //   4420: astore_1
    //   4421: goto -3886 -> 535
    //   4424: astore_1
    //   4425: goto -3880 -> 545
    //   4428: astore_1
    //   4429: goto -3412 -> 1017
    //   4432: astore_1
    //   4433: goto -3404 -> 1029
    //   4436: astore_1
    //   4437: goto -3398 -> 1039
    //   4440: astore_1
    //   4441: goto -3161 -> 1280
    //   4444: astore_1
    //   4445: goto -3153 -> 1292
    //   4448: astore_1
    //   4449: goto -3147 -> 1302
    //   4452: astore_1
    //   4453: goto -1960 -> 2493
    //   4456: astore_1
    //   4457: goto -1952 -> 2505
    //   4460: astore_1
    //   4461: goto -1946 -> 2515
    //   4464: astore_1
    //   4465: goto -269 -> 4196
    //   4468: astore_1
    //   4469: goto -261 -> 4208
    //   4472: astore_1
    //   4473: goto -255 -> 4218
    //   4476: astore 26
    //   4478: goto -754 -> 3724
    //   4481: astore 23
    //   4483: goto -749 -> 3734
    //   4486: astore 23
    //   4488: goto -744 -> 3744
    //   4491: astore 29
    //   4493: goto -2897 -> 1596
    //   4496: astore 29
    //   4498: goto -185 -> 4313
    //   4501: astore 24
    //   4503: goto -2666 -> 1837
    //   4506: astore 24
    //   4508: goto -2661 -> 1847
    //   4511: astore 24
    //   4513: goto -2656 -> 1857
    //   4516: astore_1
    //   4517: goto -2332 -> 2185
    //   4520: astore_1
    //   4521: goto -2326 -> 2195
    //   4524: astore_1
    //   4525: goto -2320 -> 2205
    //   4528: astore 23
    //   4530: aconst_null
    //   4531: astore 26
    //   4533: iconst_0
    //   4534: istore_3
    //   4535: lconst_0
    //   4536: lstore 13
    //   4538: iconst_m1
    //   4539: istore 5
    //   4541: aconst_null
    //   4542: astore 25
    //   4544: aconst_null
    //   4545: astore 24
    //   4547: iconst_0
    //   4548: istore 4
    //   4550: iload 7
    //   4552: istore 6
    //   4554: goto -2603 -> 1951
    //   4557: astore 23
    //   4559: iload 4
    //   4561: istore 5
    //   4563: iconst_0
    //   4564: istore 4
    //   4566: iload 7
    //   4568: istore 6
    //   4570: iload 11
    //   4572: istore_3
    //   4573: goto -2622 -> 1951
    //   4576: astore 23
    //   4578: iload 4
    //   4580: istore 5
    //   4582: iconst_0
    //   4583: istore 4
    //   4585: iload 7
    //   4587: istore 6
    //   4589: iload 11
    //   4591: istore_3
    //   4592: goto -2641 -> 1951
    //   4595: astore 29
    //   4597: aload 25
    //   4599: astore 26
    //   4601: iload 11
    //   4603: istore_3
    //   4604: iload 4
    //   4606: istore 5
    //   4608: aload 23
    //   4610: astore 25
    //   4612: aload 29
    //   4614: astore 23
    //   4616: iconst_0
    //   4617: istore 4
    //   4619: iload 7
    //   4621: istore 6
    //   4623: goto -2672 -> 1951
    //   4626: astore 29
    //   4628: aload 25
    //   4630: astore 26
    //   4632: iload 11
    //   4634: istore_3
    //   4635: iload 4
    //   4637: istore 5
    //   4639: aload 23
    //   4641: astore 25
    //   4643: iconst_0
    //   4644: istore 4
    //   4646: aload 29
    //   4648: astore 23
    //   4650: iload 7
    //   4652: istore 6
    //   4654: goto -2703 -> 1951
    //   4657: astore 29
    //   4659: aload 25
    //   4661: astore 26
    //   4663: iload 4
    //   4665: istore 5
    //   4667: aload 23
    //   4669: astore 25
    //   4671: iconst_0
    //   4672: istore 4
    //   4674: aload 29
    //   4676: astore 23
    //   4678: iload 7
    //   4680: istore 6
    //   4682: iload 11
    //   4684: istore_3
    //   4685: goto -2734 -> 1951
    //   4688: astore 29
    //   4690: iload 4
    //   4692: istore 5
    //   4694: aload 23
    //   4696: astore 25
    //   4698: aload 29
    //   4700: astore 23
    //   4702: iconst_0
    //   4703: istore 4
    //   4705: iload 7
    //   4707: istore 6
    //   4709: iload 11
    //   4711: istore_3
    //   4712: goto -2761 -> 1951
    //   4715: astore 23
    //   4717: iconst_0
    //   4718: istore 4
    //   4720: iload 7
    //   4722: istore 6
    //   4724: iload 11
    //   4726: istore_3
    //   4727: goto -2776 -> 1951
    //   4730: astore 29
    //   4732: iconst_0
    //   4733: istore 4
    //   4735: aload 23
    //   4737: astore 27
    //   4739: aload 29
    //   4741: astore 23
    //   4743: iload 7
    //   4745: istore 6
    //   4747: iload 11
    //   4749: istore_3
    //   4750: goto -2799 -> 1951
    //   4753: astore 29
    //   4755: iconst_0
    //   4756: istore 4
    //   4758: aload 27
    //   4760: astore 28
    //   4762: aload 23
    //   4764: astore 27
    //   4766: aload 29
    //   4768: astore 23
    //   4770: iload 7
    //   4772: istore 6
    //   4774: iload 11
    //   4776: istore_3
    //   4777: goto -2826 -> 1951
    //   4780: astore 29
    //   4782: iload 9
    //   4784: istore 6
    //   4786: lload 21
    //   4788: lstore 15
    //   4790: aload 27
    //   4792: astore 28
    //   4794: aload 23
    //   4796: astore 27
    //   4798: iconst_0
    //   4799: istore 4
    //   4801: aload 29
    //   4803: astore 23
    //   4805: iload 11
    //   4807: istore_3
    //   4808: goto -2857 -> 1951
    //   4811: astore 29
    //   4813: iload 4
    //   4815: istore 6
    //   4817: aload 23
    //   4819: astore 28
    //   4821: aload 29
    //   4823: astore 23
    //   4825: iconst_0
    //   4826: istore 4
    //   4828: iload 11
    //   4830: istore_3
    //   4831: goto -2880 -> 1951
    //   4834: astore 23
    //   4836: iload 7
    //   4838: istore 6
    //   4840: iload 11
    //   4842: istore_3
    //   4843: goto -2892 -> 1951
    //   4846: astore 28
    //   4848: goto -545 -> 4303
    //   4851: astore 28
    //   4853: lconst_0
    //   4854: lstore 13
    //   4856: aconst_null
    //   4857: astore 25
    //   4859: aconst_null
    //   4860: astore 26
    //   4862: aconst_null
    //   4863: astore 24
    //   4865: aconst_null
    //   4866: astore 27
    //   4868: lconst_0
    //   4869: lstore 15
    //   4871: iconst_m1
    //   4872: istore 4
    //   4874: aconst_null
    //   4875: astore 23
    //   4877: iconst_0
    //   4878: istore 5
    //   4880: iload 11
    //   4882: istore_3
    //   4883: goto -3361 -> 1522
    //   4886: astore 28
    //   4888: aload 26
    //   4890: astore 27
    //   4892: iconst_0
    //   4893: istore 5
    //   4895: lconst_0
    //   4896: lstore 17
    //   4898: aload 25
    //   4900: astore 26
    //   4902: lload 13
    //   4904: lstore 15
    //   4906: iconst_1
    //   4907: istore_3
    //   4908: aconst_null
    //   4909: astore 29
    //   4911: aconst_null
    //   4912: astore 25
    //   4914: aload 24
    //   4916: astore 23
    //   4918: aload 27
    //   4920: astore 24
    //   4922: lload 17
    //   4924: lstore 13
    //   4926: aload 29
    //   4928: astore 27
    //   4930: goto -3408 -> 1522
    //   4933: astore 28
    //   4935: aload 26
    //   4937: astore 27
    //   4939: iconst_0
    //   4940: istore 5
    //   4942: iconst_1
    //   4943: istore_3
    //   4944: lconst_0
    //   4945: lstore 17
    //   4947: aload 25
    //   4949: astore 26
    //   4951: aload 24
    //   4953: astore 23
    //   4955: lload 13
    //   4957: lstore 15
    //   4959: aconst_null
    //   4960: astore 29
    //   4962: aconst_null
    //   4963: astore 25
    //   4965: aload 27
    //   4967: astore 24
    //   4969: lload 17
    //   4971: lstore 13
    //   4973: aload 29
    //   4975: astore 27
    //   4977: goto -3455 -> 1522
    //   4980: astore 28
    //   4982: lconst_0
    //   4983: lstore 17
    //   4985: aconst_null
    //   4986: astore 27
    //   4988: aload 23
    //   4990: astore 26
    //   4992: aconst_null
    //   4993: astore 29
    //   4995: iload 11
    //   4997: istore_3
    //   4998: lload 13
    //   5000: lstore 15
    //   5002: aload 24
    //   5004: astore 23
    //   5006: iconst_0
    //   5007: istore 5
    //   5009: aload 25
    //   5011: astore 24
    //   5013: lload 17
    //   5015: lstore 13
    //   5017: aload 27
    //   5019: astore 25
    //   5021: aload 29
    //   5023: astore 27
    //   5025: goto -3503 -> 1522
    //   5028: astore 28
    //   5030: iconst_0
    //   5031: istore 5
    //   5033: lconst_0
    //   5034: lstore 17
    //   5036: aconst_null
    //   5037: astore 29
    //   5039: aload 23
    //   5041: astore 26
    //   5043: lload 13
    //   5045: lstore 15
    //   5047: aconst_null
    //   5048: astore 27
    //   5050: iload 11
    //   5052: istore_3
    //   5053: aload 24
    //   5055: astore 23
    //   5057: aload 25
    //   5059: astore 24
    //   5061: lload 17
    //   5063: lstore 13
    //   5065: aload 29
    //   5067: astore 25
    //   5069: goto -3547 -> 1522
    //   5072: astore 28
    //   5074: iconst_0
    //   5075: istore 5
    //   5077: lconst_0
    //   5078: lstore 17
    //   5080: aload 23
    //   5082: astore 26
    //   5084: lload 13
    //   5086: lstore 15
    //   5088: aconst_null
    //   5089: astore 27
    //   5091: iconst_1
    //   5092: istore_3
    //   5093: aload 24
    //   5095: astore 23
    //   5097: aconst_null
    //   5098: astore 29
    //   5100: aload 25
    //   5102: astore 24
    //   5104: lload 17
    //   5106: lstore 13
    //   5108: aload 29
    //   5110: astore 25
    //   5112: goto -3590 -> 1522
    //   5115: astore 28
    //   5117: iconst_0
    //   5118: istore 5
    //   5120: iconst_1
    //   5121: istore_3
    //   5122: lconst_0
    //   5123: lstore 17
    //   5125: aload 23
    //   5127: astore 27
    //   5129: lload 13
    //   5131: lstore 15
    //   5133: aconst_null
    //   5134: astore 25
    //   5136: aconst_null
    //   5137: astore 29
    //   5139: aload 24
    //   5141: astore 23
    //   5143: aload 26
    //   5145: astore 24
    //   5147: lload 17
    //   5149: lstore 13
    //   5151: aload 27
    //   5153: astore 26
    //   5155: aload 29
    //   5157: astore 27
    //   5159: goto -3637 -> 1522
    //   5162: astore 28
    //   5164: iconst_0
    //   5165: istore 6
    //   5167: iconst_1
    //   5168: istore_3
    //   5169: aconst_null
    //   5170: astore 29
    //   5172: iload 5
    //   5174: istore 4
    //   5176: aconst_null
    //   5177: astore 30
    //   5179: lload 13
    //   5181: lstore 17
    //   5183: aload 24
    //   5185: astore 23
    //   5187: aload 25
    //   5189: astore 27
    //   5191: aload 26
    //   5193: astore 24
    //   5195: iload 6
    //   5197: istore 5
    //   5199: lload 15
    //   5201: lstore 13
    //   5203: lload 17
    //   5205: lstore 15
    //   5207: aload 30
    //   5209: astore 25
    //   5211: aload 27
    //   5213: astore 26
    //   5215: aload 29
    //   5217: astore 27
    //   5219: goto -3697 -> 1522
    //   5222: astore 28
    //   5224: iconst_0
    //   5225: istore 6
    //   5227: iconst_1
    //   5228: istore_3
    //   5229: lload 15
    //   5231: lstore 17
    //   5233: aload 23
    //   5235: astore 29
    //   5237: iload 5
    //   5239: istore 4
    //   5241: aload 26
    //   5243: astore 30
    //   5245: aload 24
    //   5247: astore 23
    //   5249: lload 13
    //   5251: lstore 15
    //   5253: aload 25
    //   5255: astore 26
    //   5257: aload 30
    //   5259: astore 24
    //   5261: iload 6
    //   5263: istore 5
    //   5265: lload 17
    //   5267: lstore 13
    //   5269: aload 27
    //   5271: astore 25
    //   5273: aload 29
    //   5275: astore 27
    //   5277: goto -3755 -> 1522
    //   5280: astore 28
    //   5282: iload 4
    //   5284: istore 6
    //   5286: lload 15
    //   5288: lstore 17
    //   5290: lload 13
    //   5292: lstore 15
    //   5294: iload 5
    //   5296: istore 4
    //   5298: aload 25
    //   5300: astore 29
    //   5302: aload 23
    //   5304: astore 25
    //   5306: iconst_1
    //   5307: istore_3
    //   5308: aload 24
    //   5310: astore 23
    //   5312: aload 26
    //   5314: astore 24
    //   5316: iload 6
    //   5318: istore 5
    //   5320: lload 17
    //   5322: lstore 13
    //   5324: aload 29
    //   5326: astore 26
    //   5328: goto -3806 -> 1522
    //   5331: astore 23
    //   5333: goto -4620 -> 713
    //   5336: iconst_0
    //   5337: istore 4
    //   5339: lconst_0
    //   5340: lstore 15
    //   5342: aconst_null
    //   5343: astore 23
    //   5345: aconst_null
    //   5346: astore 27
    //   5348: goto -1880 -> 3468
    //   5351: aload 25
    //   5353: astore 26
    //   5355: aload 23
    //   5357: astore 25
    //   5359: goto -5047 -> 312
    //   5362: iconst_0
    //   5363: istore_3
    //   5364: goto -2891 -> 2473
    //   5367: iload 4
    //   5369: iconst_1
    //   5370: iadd
    //   5371: istore 4
    //   5373: goto -2738 -> 2635
    //   5376: iload 6
    //   5378: iconst_1
    //   5379: iadd
    //   5380: istore 6
    //   5382: goto -2694 -> 2688
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5385	0	this	HttpCommunicator
    //   0	5385	1	paramaqog	aqog
    //   0	5385	2	parama	a
    //   0	5385	3	paramBoolean	boolean
    //   25	5347	4	i	int
    //   200	5119	5	j	int
    //   51	5330	6	k	int
    //   40	4797	7	m	int
    //   37	4222	8	n	int
    //   2683	2100	9	i1	int
    //   3020	43	10	i2	int
    //   34	5017	11	bool1	boolean
    //   345	443	12	bool2	boolean
    //   28	5295	13	l1	long
    //   31	5310	15	l2	long
    //   290	5031	17	l3	long
    //   2953	968	19	l4	long
    //   2961	1826	21	l5	long
    //   16	1055	23	str	String
    //   1080	1	23	localException1	Exception
    //   1376	491	23	localObject1	Object
    //   1939	277	23	localObject2	Object
    //   2247	1483	23	localObject3	Object
    //   3765	122	23	localException2	Exception
    //   3898	446	23	localObject4	Object
    //   4377	3	23	localException3	Exception
    //   4481	1	23	localIOException1	IOException
    //   4486	1	23	localIOException2	IOException
    //   4528	1	23	localObject5	Object
    //   4557	1	23	localObject6	Object
    //   4576	33	23	localObject7	Object
    //   4614	87	23	localObject8	Object
    //   4715	21	23	localObject9	Object
    //   4741	83	23	localObject10	Object
    //   4834	1	23	localObject11	Object
    //   4875	436	23	localObject12	Object
    //   5331	1	23	localThrowable1	Throwable
    //   5343	13	23	localObject13	Object
    //   7	4361	24	localObject14	Object
    //   4501	1	24	localIOException3	IOException
    //   4506	1	24	localIOException4	IOException
    //   4511	1	24	localIOException5	IOException
    //   4545	770	24	localObject15	Object
    //   57	5301	25	localObject16	Object
    //   81	4267	26	localObject17	Object
    //   4476	1	26	localIOException6	IOException
    //   4531	823	26	localObject18	Object
    //   13	5334	27	localObject19	Object
    //   22	3084	28	localObject20	Object
    //   3161	1	28	localThrowable2	Throwable
    //   3223	580	28	localObject21	Object
    //   3884	1	28	localThrowable3	Throwable
    //   4264	1	28	localObject22	Object
    //   4298	16	28	localObject23	Object
    //   4324	496	28	localObject24	Object
    //   4846	1	28	localObject25	Object
    //   4851	1	28	localThrowable4	Throwable
    //   4886	1	28	localThrowable5	Throwable
    //   4933	1	28	localThrowable6	Throwable
    //   4980	1	28	localThrowable7	Throwable
    //   5028	1	28	localThrowable8	Throwable
    //   5072	1	28	localThrowable9	Throwable
    //   5115	1	28	localThrowable10	Throwable
    //   5162	1	28	localThrowable11	Throwable
    //   5222	1	28	localThrowable12	Throwable
    //   5280	1	28	localThrowable13	Throwable
    //   10	1	29	localObject26	Object
    //   1466	53	29	localThrowable14	Throwable
    //   1550	2717	29	localObject27	Object
    //   4278	1	29	localException4	Exception
    //   4293	1	29	localIOException7	IOException
    //   4301	65	29	localObject28	Object
    //   4491	1	29	localIOException8	IOException
    //   4496	1	29	localIOException9	IOException
    //   4595	18	29	localObject29	Object
    //   4626	21	29	localObject30	Object
    //   4657	18	29	localObject31	Object
    //   4688	11	29	localObject32	Object
    //   4730	10	29	localObject33	Object
    //   4753	14	29	localObject34	Object
    //   4780	22	29	localObject35	Object
    //   4811	11	29	localObject36	Object
    //   4909	416	29	localObject37	Object
    //   19	4267	30	localObject38	Object
    //   4316	26	30	localObject39	Object
    //   5177	81	30	localObject40	Object
    //   4	4401	31	localaqoi	aqoi
    //   160	2497	32	localObject41	Object
    // Exception table:
    //   from	to	target	type
    //   454	461	561	java/lang/Exception
    //   466	475	561	java/lang/Exception
    //   488	501	561	java/lang/Exception
    //   503	511	561	java/lang/Exception
    //   515	523	561	java/lang/Exception
    //   527	535	561	java/lang/Exception
    //   540	545	561	java/lang/Exception
    //   550	555	561	java/lang/Exception
    //   948	955	1050	java/lang/Exception
    //   960	969	1050	java/lang/Exception
    //   982	995	1050	java/lang/Exception
    //   997	1005	1050	java/lang/Exception
    //   1009	1017	1050	java/lang/Exception
    //   1021	1029	1050	java/lang/Exception
    //   1034	1039	1050	java/lang/Exception
    //   1044	1049	1050	java/lang/Exception
    //   729	751	1080	java/lang/Exception
    //   751	787	1080	java/lang/Exception
    //   1056	1072	1080	java/lang/Exception
    //   1211	1218	1313	java/lang/Exception
    //   1223	1232	1313	java/lang/Exception
    //   1245	1258	1313	java/lang/Exception
    //   1260	1268	1313	java/lang/Exception
    //   1272	1280	1313	java/lang/Exception
    //   1284	1292	1313	java/lang/Exception
    //   1297	1302	1313	java/lang/Exception
    //   1307	1312	1313	java/lang/Exception
    //   325	334	1466	java/lang/Throwable
    //   338	347	1466	java/lang/Throwable
    //   567	574	1466	java/lang/Throwable
    //   579	588	1466	java/lang/Throwable
    //   588	617	1466	java/lang/Throwable
    //   639	693	1466	java/lang/Throwable
    //   718	724	1466	java/lang/Throwable
    //   729	751	1466	java/lang/Throwable
    //   751	787	1466	java/lang/Throwable
    //   1056	1072	1466	java/lang/Throwable
    //   1082	1093	1466	java/lang/Throwable
    //   1093	1109	1466	java/lang/Throwable
    //   1324	1340	1466	java/lang/Throwable
    //   1340	1358	1466	java/lang/Throwable
    //   1358	1395	1466	java/lang/Throwable
    //   1395	1424	1466	java/lang/Throwable
    //   1424	1431	1466	java/lang/Throwable
    //   1455	1466	1466	java/lang/Throwable
    //   1928	1939	1466	java/lang/Throwable
    //   2218	2226	1466	java/lang/Throwable
    //   2242	2249	1466	java/lang/Throwable
    //   2263	2294	1466	java/lang/Throwable
    //   2294	2315	1466	java/lang/Throwable
    //   2315	2322	1466	java/lang/Throwable
    //   2532	2539	1466	java/lang/Throwable
    //   2542	2565	1466	java/lang/Throwable
    //   2568	2604	1466	java/lang/Throwable
    //   2612	2632	1466	java/lang/Throwable
    //   2654	2671	1466	java/lang/Throwable
    //   2674	2685	1466	java/lang/Throwable
    //   2711	2721	1466	java/lang/Throwable
    //   2727	2770	1466	java/lang/Throwable
    //   2770	2803	1466	java/lang/Throwable
    //   2803	2855	1466	java/lang/Throwable
    //   2855	2866	1466	java/lang/Throwable
    //   3935	4025	1466	java/lang/Throwable
    //   4243	4252	1466	java/lang/Throwable
    //   1904	1913	1914	java/lang/Exception
    //   4404	4415	1914	java/lang/Exception
    //   325	334	1939	finally
    //   338	347	1939	finally
    //   567	574	1939	finally
    //   579	588	1939	finally
    //   588	617	1939	finally
    //   639	693	1939	finally
    //   703	708	1939	finally
    //   708	713	1939	finally
    //   718	724	1939	finally
    //   729	751	1939	finally
    //   751	787	1939	finally
    //   1056	1072	1939	finally
    //   1082	1093	1939	finally
    //   1093	1109	1939	finally
    //   1324	1340	1939	finally
    //   1340	1358	1939	finally
    //   1358	1395	1939	finally
    //   1395	1424	1939	finally
    //   1424	1431	1939	finally
    //   1455	1466	1939	finally
    //   1928	1939	1939	finally
    //   2218	2226	1939	finally
    //   2242	2249	1939	finally
    //   2263	2294	1939	finally
    //   2294	2315	1939	finally
    //   2315	2322	1939	finally
    //   2532	2539	1939	finally
    //   2542	2565	1939	finally
    //   2568	2604	1939	finally
    //   2612	2632	1939	finally
    //   2654	2671	1939	finally
    //   2674	2685	1939	finally
    //   2711	2721	1939	finally
    //   2727	2770	1939	finally
    //   2770	2803	1939	finally
    //   2803	2855	1939	finally
    //   2855	2866	1939	finally
    //   3935	4025	1939	finally
    //   2424	2431	2526	java/lang/Exception
    //   2436	2445	2526	java/lang/Exception
    //   2458	2471	2526	java/lang/Exception
    //   2473	2481	2526	java/lang/Exception
    //   2485	2493	2526	java/lang/Exception
    //   2497	2505	2526	java/lang/Exception
    //   2510	2515	2526	java/lang/Exception
    //   2520	2525	2526	java/lang/Exception
    //   2884	2924	3161	java/lang/Throwable
    //   3149	3158	3161	java/lang/Throwable
    //   3656	3663	3765	java/lang/Exception
    //   3668	3677	3765	java/lang/Exception
    //   3691	3704	3765	java/lang/Exception
    //   3706	3714	3765	java/lang/Exception
    //   3719	3724	3765	java/lang/Exception
    //   3729	3734	3765	java/lang/Exception
    //   3739	3744	3765	java/lang/Exception
    //   3753	3758	3765	java/lang/Exception
    //   2963	2980	3884	java/lang/Throwable
    //   3001	3007	3884	java/lang/Throwable
    //   3057	3065	3884	java/lang/Throwable
    //   3081	3088	3884	java/lang/Throwable
    //   3104	3110	3884	java/lang/Throwable
    //   3126	3135	3884	java/lang/Throwable
    //   3244	3251	3884	java/lang/Throwable
    //   3281	3288	3884	java/lang/Throwable
    //   3309	3315	3884	java/lang/Throwable
    //   3331	3342	3884	java/lang/Throwable
    //   3358	3364	3884	java/lang/Throwable
    //   3380	3389	3884	java/lang/Throwable
    //   3405	3412	3884	java/lang/Throwable
    //   3428	3435	3884	java/lang/Throwable
    //   3451	3456	3884	java/lang/Throwable
    //   3800	3810	3884	java/lang/Throwable
    //   3826	3831	3884	java/lang/Throwable
    //   3847	3856	3884	java/lang/Throwable
    //   3872	3881	3884	java/lang/Throwable
    //   4127	4134	4229	java/lang/Exception
    //   4139	4148	4229	java/lang/Exception
    //   4161	4174	4229	java/lang/Exception
    //   4176	4184	4229	java/lang/Exception
    //   4188	4196	4229	java/lang/Exception
    //   4200	4208	4229	java/lang/Exception
    //   4213	4218	4229	java/lang/Exception
    //   4223	4228	4229	java/lang/Exception
    //   1545	1552	4278	java/lang/Exception
    //   1556	1563	4278	java/lang/Exception
    //   1572	1581	4278	java/lang/Exception
    //   4285	4290	4293	java/io/IOException
    //   1545	1552	4298	finally
    //   1525	1532	4316	finally
    //   1591	1596	4316	finally
    //   1596	1608	4316	finally
    //   4285	4290	4316	finally
    //   4308	4313	4316	finally
    //   4313	4316	4316	finally
    //   1769	1776	4377	java/lang/Exception
    //   1781	1790	4377	java/lang/Exception
    //   1804	1817	4377	java/lang/Exception
    //   1819	1827	4377	java/lang/Exception
    //   1832	1837	4377	java/lang/Exception
    //   1842	1847	4377	java/lang/Exception
    //   1852	1857	4377	java/lang/Exception
    //   1866	1871	4377	java/lang/Exception
    //   2117	2124	4396	java/lang/Exception
    //   2129	2138	4396	java/lang/Exception
    //   2152	2165	4396	java/lang/Exception
    //   2167	2175	4396	java/lang/Exception
    //   2180	2185	4396	java/lang/Exception
    //   2190	2195	4396	java/lang/Exception
    //   2200	2205	4396	java/lang/Exception
    //   2210	2215	4396	java/lang/Exception
    //   515	523	4416	java/io/IOException
    //   527	535	4420	java/io/IOException
    //   540	545	4424	java/io/IOException
    //   1009	1017	4428	java/io/IOException
    //   1021	1029	4432	java/io/IOException
    //   1034	1039	4436	java/io/IOException
    //   1272	1280	4440	java/io/IOException
    //   1284	1292	4444	java/io/IOException
    //   1297	1302	4448	java/io/IOException
    //   2485	2493	4452	java/io/IOException
    //   2497	2505	4456	java/io/IOException
    //   2510	2515	4460	java/io/IOException
    //   4188	4196	4464	java/io/IOException
    //   4200	4208	4468	java/io/IOException
    //   4213	4218	4472	java/io/IOException
    //   3719	3724	4476	java/io/IOException
    //   3729	3734	4481	java/io/IOException
    //   3739	3744	4486	java/io/IOException
    //   1591	1596	4491	java/io/IOException
    //   4308	4313	4496	java/io/IOException
    //   1832	1837	4501	java/io/IOException
    //   1842	1847	4506	java/io/IOException
    //   1852	1857	4511	java/io/IOException
    //   2180	2185	4516	java/io/IOException
    //   2190	2195	4520	java/io/IOException
    //   2200	2205	4524	java/io/IOException
    //   42	50	4528	finally
    //   169	199	4557	finally
    //   202	242	4557	finally
    //   257	267	4557	finally
    //   267	278	4557	finally
    //   278	297	4557	finally
    //   312	325	4576	finally
    //   59	83	4595	finally
    //   87	111	4626	finally
    //   114	143	4657	finally
    //   143	169	4688	finally
    //   2877	2884	4715	finally
    //   2884	2924	4730	finally
    //   3149	3158	4730	finally
    //   2924	2941	4753	finally
    //   3218	3225	4753	finally
    //   2963	2980	4780	finally
    //   3001	3007	4780	finally
    //   3057	3065	4780	finally
    //   3081	3088	4780	finally
    //   3104	3110	4780	finally
    //   3126	3135	4780	finally
    //   3244	3251	4780	finally
    //   3281	3288	4780	finally
    //   3309	3315	4780	finally
    //   3331	3342	4780	finally
    //   3358	3364	4780	finally
    //   3380	3389	4780	finally
    //   3405	3412	4780	finally
    //   3428	3435	4780	finally
    //   3451	3456	4780	finally
    //   3800	3810	4780	finally
    //   3826	3831	4780	finally
    //   3847	3856	4780	finally
    //   3872	3881	4780	finally
    //   3468	3479	4811	finally
    //   4243	4252	4834	finally
    //   1556	1563	4846	finally
    //   1572	1581	4846	finally
    //   42	50	4851	java/lang/Throwable
    //   169	199	4886	java/lang/Throwable
    //   202	242	4886	java/lang/Throwable
    //   257	267	4886	java/lang/Throwable
    //   267	278	4886	java/lang/Throwable
    //   278	297	4886	java/lang/Throwable
    //   312	325	4933	java/lang/Throwable
    //   59	83	4980	java/lang/Throwable
    //   87	111	5028	java/lang/Throwable
    //   114	143	5072	java/lang/Throwable
    //   143	169	5115	java/lang/Throwable
    //   2877	2884	5162	java/lang/Throwable
    //   2924	2941	5222	java/lang/Throwable
    //   3218	3225	5222	java/lang/Throwable
    //   3468	3479	5280	java/lang/Throwable
    //   703	708	5331	java/lang/Throwable
    //   708	713	5331	java/lang/Throwable
  }
  
  public void a(aqog paramaqog, String paramString1, String paramString2)
  {
    try
    {
      aonc.b(aonc.fG(paramaqog.busiType), paramaqog.getRequestMethod().equals("POST"), aonc.fH(paramaqog.fileType), paramaqog.msgId, paramString1, paramString2);
      return;
    }
    catch (OutOfMemoryError paramaqog) {}
  }
  
  protected void a(aqog paramaqog, boolean paramBoolean, long paramLong)
  {
    paramaqog.flow = ((int)paramLong);
    int i = paramaqog.fileType;
    int j = paramaqog.busiType;
    int k = paramaqog.netType;
    if (((i == -1) || (j == -1)) && (QLog.isColorLevel())) {
      QLog.e("flowstat", 2, "fileType:" + i + ",busiType:" + j);
    }
    if ((this.bh != null) && (this.bh.get() != null)) {
      ((aqoh)this.bh.get()).countFlow(paramBoolean, k, i, j, paramLong);
    }
  }
  
  public void a(a parama)
  {
    if (this.cUX) {}
    int i;
    do
    {
      do
      {
        return;
      } while (parama == null);
      parama.ej.set(true);
      i = parama.index;
      if ((i >= 0) && (i < 4))
      {
        ??? = new HandlerThread("httpcommunicator_norm_new_" + i, 5);
        ((HandlerThread)???).start();
        a locala = new a(((HandlerThread)???).getLooper());
        locala.index = i;
        synchronized (this.locker)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a[i] = locala;
          if (parama.ei.get()) {
            this.eaG -= 1;
          }
          UZ("replaceNewThread index:" + i);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.HttpCommunicator", 2, "replaceNewThread,index error occurs. " + i);
  }
  
  void a(a parama, aqog paramaqog)
    throws IOException
  {
    if (!this.cUW) {
      throw new IOException("httpcommunicator closed");
    }
    if (paramaqog.ek.get()) {
      throw new IOException("request cancelled");
    }
    if ((parama != null) && (parama.ej.get())) {
      throw new RuntimeException("thread should close");
    }
    if (paramaqog.el.get())
    {
      a(paramaqog, "interrupt", "preempted");
      throw new IOException("preempted by higher msg");
    }
  }
  
  void a(boolean paramBoolean, int paramInt, HttpURLConnection paramHttpURLConnection, aqog paramaqog, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IllegalArgumentException))
    {
      paramaqog.P(9020, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IllegalStateException))
    {
      paramaqog.P(9057, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IOException))
    {
      if ("request cancelled".equals(paramThrowable.getMessage()))
      {
        paramaqog.P(9037, paramInt, paramThrowable.toString());
        return;
      }
      if ("httpcommunicator closed".equals(paramThrowable.getMessage()))
      {
        paramaqog.P(9366, paramInt, paramThrowable.getMessage());
        return;
      }
      if ("preempted by higher msg".equals(paramThrowable.getMessage()))
      {
        paramaqog.P(9361, paramInt, paramThrowable.toString());
        return;
      }
      if ("content-length zero".equals(paramThrowable.getMessage()))
      {
        paramHttpURLConnection = aojn.x("Q", -9531L);
        paramaqog.ip(aqog.cuy, paramHttpURLConnection);
        paramaqog.P(-9527, paramInt, "content zero");
        return;
      }
      if ((paramThrowable instanceof MalformedURLException))
      {
        paramaqog.P(9048, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof InterruptedIOException))
      {
        if ((paramThrowable instanceof SocketTimeoutException))
        {
          if (paramBoolean)
          {
            paramaqog.P(9014, paramInt, paramThrowable.toString());
            return;
          }
          paramaqog.P(9050, paramInt, paramThrowable.toString());
          return;
        }
        paramaqog.P(9049, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof SocketException))
      {
        paramHttpURLConnection = paramThrowable.toString();
        if (QLog.isColorLevel())
        {
          paramHttpURLConnection = new StringBuilder();
          StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
          int j = arrayOfStackTraceElement.length;
          int i = 0;
          while (i < j)
          {
            StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
            paramHttpURLConnection.append("\n").append(localStackTraceElement.toString());
            i += 1;
          }
          paramHttpURLConnection = paramHttpURLConnection.toString();
        }
        if ((paramThrowable instanceof ConnectException))
        {
          paramaqog.P(9052, paramInt, paramHttpURLConnection);
          return;
        }
        if ((paramThrowable instanceof NoRouteToHostException))
        {
          paramaqog.P(9053, paramInt, paramHttpURLConnection);
          return;
        }
        if ((paramThrowable instanceof PortUnreachableException))
        {
          paramaqog.P(9054, paramInt, paramHttpURLConnection);
          return;
        }
        paramaqog.P(9051, paramInt, paramHttpURLConnection);
        return;
      }
      if ((paramThrowable instanceof UnknownHostException))
      {
        paramaqog.P(9055, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof EOFException))
      {
        paramaqog.P(9056, paramInt, paramThrowable.getMessage());
        return;
      }
      paramThrowable = paramThrowable.toString();
      if (paramThrowable.contains("unreachable)")) {
        paramHttpURLConnection = "N_" + -20005;
      }
      for (;;)
      {
        paramaqog.P(9047, paramInt, paramThrowable);
        paramaqog.ip(aqog.cuy, paramHttpURLConnection);
        return;
        if (paramThrowable.contains("Connection refused"))
        {
          paramHttpURLConnection = "N_" + -20002;
        }
        else if (paramThrowable.contains("No route to host"))
        {
          if (paramThrowable.contains("SocketException")) {
            paramHttpURLConnection = "N_" + -20003;
          } else {
            paramHttpURLConnection = "N_" + -20004;
          }
        }
        else if (paramThrowable.contains("unexpected end of stream"))
        {
          paramHttpURLConnection = "N_" + -20005;
        }
        else if (paramThrowable.contains("Connection timed out"))
        {
          paramHttpURLConnection = "N_" + -20006;
        }
        else
        {
          if (paramThrowable.contains("unaccpet content type"))
          {
            paramaqog.P(9064, paramInt, paramThrowable);
            return;
          }
          paramHttpURLConnection = "N_" + -20007;
        }
      }
    }
    if ((paramThrowable instanceof SecurityException))
    {
      paramaqog.P(9022, paramInt, paramThrowable.toString());
      return;
    }
    paramHttpURLConnection = paramThrowable.getMessage();
    if ((!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("FlowDecoderExp")))
    {
      paramaqog.P(9058, paramInt, paramHttpURLConnection);
      return;
    }
    if ((!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("DecryptError")))
    {
      paramaqog.P(9059, paramInt, paramHttpURLConnection);
      return;
    }
    try
    {
      paramaqog.P(9322, paramInt, Log.getStackTraceString(paramThrowable));
      return;
    }
    catch (OutOfMemoryError paramHttpURLConnection) {}
  }
  
  void aX(long paramLong, int paramInt)
  {
    int i = 4;
    int j = (int)(2L * paramLong / 90000L);
    if (j > 4) {}
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(i + 9400));
      localHashMap.put("param_PostSize", String.valueOf(paramInt));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "LongHttpRespTime", false, paramLong, 0L, localHashMap, "");
      return;
      i = j;
    }
  }
  
  public int b(aqog paramaqog)
  {
    int i = this.eaE;
    int j = -1;
    for (;;)
    {
      synchronized (this.locker)
      {
        if ((!this.cUX) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b.Mj() < i))
        {
          i = this.seed + 1;
          this.seed = i;
          paramaqog.XH(i);
          this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b.i(paramaqog);
          paramaqog.a().a(paramaqog, null, 0);
          j = this.seed;
          i = j;
          if (!this.cUW)
          {
            start();
            i = j;
          }
          ??? = new Object();
          paramaqog.fv = ???;
          paramaqog.em = new AtomicBoolean(false);
          UZ("sendMsgSync");
          if (paramaqog.em.get()) {}
        }
      }
      try
      {
        ???.wait();
        return i;
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        i = j;
        continue;
        paramaqog = finally;
        throw paramaqog;
      }
      catch (InterruptedException paramaqog)
      {
        for (;;)
        {
          paramaqog.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  void b(int paramInt, HttpURLConnection paramHttpURLConnection, aqog paramaqog)
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
        paramHttpURLConnection = aojn.e(paramInt, l1);
        paramaqog.ip(aqog.cuy, paramHttpURLConnection);
        paramaqog.P(-9527, paramInt, paramHttpURLConnection);
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
  
  public void close()
  {
    this.N.post(new HttpCommunicator.3(this));
  }
  
  public void eeD()
  {
    int i = 0;
    long l;
    synchronized (this.locker)
    {
      l = System.currentTimeMillis();
      aqog localaqog;
      do
      {
        localaqog = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b.a(true);
        if (localaqog == null) {
          break;
        }
      } while ((localaqog == null) || (localaqog.a() == null));
      localaqog.P(9366, -1, "httpcommunicator_close");
      localaqog.a().b(localaqog, localaqog);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b.eeF();
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a != null)
    {
      a[] arrayOfa = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a;
      int j = arrayOfa.length;
      while (i < j)
      {
        arrayOfa[i].sendEmptyMessage(1);
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a = null;
    this.eaG = 0;
    this.eaF = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator close_inter.elapse:" + (System.currentTimeMillis() - l));
    }
  }
  
  public void f(aqog paramaqog)
  {
    if (paramaqog == null) {
      return;
    }
    synchronized (this.locker)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$b.b(paramaqog);
      paramaqog.ek.set(true);
      return;
    }
  }
  
  public void g(aqog paramaqog)
  {
    if (paramaqog != null)
    {
      aqoi localaqoi = paramaqog.a();
      if ((localaqoi instanceof aojn)) {
        ((aojn)localaqoi).L(2, 9014, "sscm http timeout");
      }
      paramaqog.a().b(paramaqog, null);
    }
  }
  
  public void start()
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.locker)
      {
        if ((this.cUX) || (this.cUW)) {
          return;
        }
        if ((this.N != null) && (this.hS != null)) {
          this.N.removeCallbacks(this.hS);
        }
        this.cUW = true;
        this.eaG = 0;
        if (this.N == null) {
          this.N = ThreadManager.getSubThreadHandler();
        }
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a == null)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a = new a[4];
          if (i < 4)
          {
            HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("httpcommunicator_norm_" + i, 5);
            localHandlerThread.start();
            this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a[i] = new a(localHandlerThread.getLooper());
            this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsHttputilsHttpCommunicator$a[i].index = i;
            i += 1;
            continue;
          }
        }
        i = aomi.a().getNetType();
        if ((i == 2) || (i == 3))
        {
          this.eaF = 3;
          return;
        }
      }
      this.eaF = 4;
    }
  }
  
  class HttpThread
    extends Thread
  {
    public void run() {}
  }
  
  class a
    extends Handler
  {
    public AtomicBoolean ei = new AtomicBoolean();
    public AtomicBoolean ej = new AtomicBoolean();
    public aqog h;
    public int index;
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void eeE()
    {
      try
      {
        if (this.h != null)
        {
          HttpCommunicator.this.a(this.h, "requeustInterupt", "msgId:" + this.h.msgId + " thread id:" + this.index);
          this.h.el.set(true);
          if (this.h.f != null)
          {
            this.h.f.disconnect();
            getLooper().getThread().interrupt();
          }
          HttpCommunicator.this.a(this);
          this.h.P(9361, 0, "preempted by higher msg");
          this.h.a().b(this.h, this.h);
          this.h = null;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public void h(aqog paramaqog)
    {
      sendMessage(obtainMessage(0, paramaqog));
    }
    
    public void handleMessage(Message arg1)
    {
      if (???.what == 0)
      {
        if ((HttpCommunicator.a(HttpCommunicator.this) != null) && (HttpCommunicator.a(HttpCommunicator.this) != null)) {
          HttpCommunicator.a(HttpCommunicator.this).removeCallbacks(HttpCommunicator.a(HttpCommunicator.this));
        }
        if ((???.obj != null) && ((???.obj instanceof aqog)))
        {
          localaqog = (aqog)???.obj;
          if (localaqog.ek.get()) {
            break label274;
          }
          HttpCommunicator.this.a(localaqog, this, false);
          if (localaqog.fv != null) {
            localaqog.em.set(true);
          }
        }
      }
      label274:
      while (???.what != 1)
      {
        synchronized (localaqog.fv)
        {
          aqog localaqog;
          localaqog.fv.notify();
          if (this.ej.get())
          {
            getLooper().quit();
            return;
          }
        }
        this.ei.set(false);
        this.h = null;
        for (???.obj = null;; ???.obj = null)
        {
          synchronized (HttpCommunicator.a(HttpCommunicator.this))
          {
            HttpCommunicator.a(HttpCommunicator.this);
            HttpCommunicator.this.UZ("handleMsgFin thread index:" + this.index);
            if ((!HttpCommunicator.c(HttpCommunicator.this, false)) || (HttpCommunicator.a(HttpCommunicator.this) == null)) {
              break;
            }
            HttpCommunicator.a(HttpCommunicator.this, new HttpCommunicator.HttpCommunicatorHandler.1(this));
            HttpCommunicator.a(HttpCommunicator.this).postDelayed(HttpCommunicator.a(HttpCommunicator.this), 2000L);
            return;
          }
          this.ei.set(false);
          this.h = null;
        }
      }
      getLooper().quit();
    }
  }
  
  public static class b
  {
    private ArrayList<LinkedList<aqog>> CR = new ArrayList();
    public int eaH;
    
    public b()
    {
      int i = 0;
      while (i < 3)
      {
        this.CR.add(new LinkedList());
        i += 1;
      }
    }
    
    public String Cn()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < this.CR.size())
      {
        int j = 0;
        while (j < ((LinkedList)this.CR.get(i)).size())
        {
          localStringBuilder.append(aqgo.encodeToString(((aqog)((LinkedList)this.CR.get(i)).get(j)).getRealUrl().getBytes(), 0));
          localStringBuilder.append("\r\n");
          j += 1;
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public int Mj()
    {
      return this.eaH;
    }
    
    public aqog a(boolean paramBoolean)
    {
      int i = 0;
      while (i < this.CR.size())
      {
        if (((LinkedList)this.CR.get(i)).size() != 0)
        {
          if (paramBoolean)
          {
            aqog localaqog = (aqog)((LinkedList)this.CR.get(i)).remove(0);
            this.eaH -= 1;
            return localaqog;
          }
          return (aqog)((LinkedList)this.CR.get(i)).get(0);
        }
        i += 1;
      }
      return null;
    }
    
    public boolean b(aqog paramaqog)
    {
      boolean bool2 = false;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < this.CR.size())
        {
          if (((LinkedList)this.CR.get(i)).remove(paramaqog))
          {
            this.eaH -= 1;
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    public void eeF()
    {
      int i = 0;
      while (i < this.CR.size())
      {
        ((LinkedList)this.CR.get(i)).clear();
        i += 1;
      }
      this.eaH = 0;
    }
    
    public void i(aqog paramaqog)
    {
      if (paramaqog == null) {}
      int i;
      do
      {
        return;
        i = paramaqog.getPriority() - 200;
      } while ((i < 0) || (i >= this.CR.size()));
      ((LinkedList)this.CR.get(i)).add(paramaqog);
      this.eaH += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpCommunicator
 * JD-Core Version:    0.7.0.1
 */