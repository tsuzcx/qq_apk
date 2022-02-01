import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.animation.AnimationUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.jetbrains.annotations.Nullable;

public class aolf
  extends aoiz
{
  private static aolf.a a = ;
  private static boolean cMD;
  private static boolean cME;
  private boolean cMC;
  protected AtomicBoolean dY = new AtomicBoolean(false);
  
  public aolf() {}
  
  public aolf(boolean paramBoolean, Object paramObject)
  {
    this.cMC = paramBoolean;
  }
  
  private static int a(int paramInt, Exception paramException, boolean paramBoolean)
  {
    String str = paramException.getMessage();
    if ((paramException instanceof SocketException))
    {
      if ((paramException instanceof ConnectException)) {
        return paramInt + 10;
      }
      if ((paramException instanceof NoRouteToHostException)) {
        return paramInt + 11;
      }
      if ((paramException instanceof PortUnreachableException)) {
        return paramInt + 12;
      }
      return paramInt + 13;
    }
    if ((paramException instanceof InterruptedIOException))
    {
      if ((paramException instanceof SocketTimeoutException))
      {
        if (paramBoolean) {
          return paramInt + 100;
        }
        return paramInt + 101;
      }
      return paramInt + 102;
    }
    if ((paramException instanceof IOException))
    {
      if ((paramException instanceof MalformedURLException)) {
        return paramInt + 200;
      }
      if ((paramException instanceof UnknownHostException)) {
        return paramInt + 201;
      }
      if ((paramException instanceof EOFException)) {
        return paramInt + 202;
      }
      if (str == null) {
        return paramInt + 307;
      }
      if (str.contains("unreachable)")) {
        return paramInt + 300;
      }
      if (str.contains("Connection refused")) {
        return paramInt + 301;
      }
      if (str.contains("No route to host"))
      {
        if (str.contains("SocketException")) {
          return paramInt + 302;
        }
        return paramInt + 303;
      }
      if (str.contains("unexpected end of stream")) {
        return paramInt + 304;
      }
      if (str.contains("Connection timed out")) {
        return paramInt + 305;
      }
      if (str.contains("unaccpet content type")) {
        return paramInt + 306;
      }
      return paramInt + 307;
    }
    return paramInt + 400;
  }
  
  private static aolf.a a()
  {
    Object localObject1 = new SchemeRegistry();
    ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    for (;;)
    {
      try
      {
        if ((Build.VERSION.SDK_INT < 23) && (!azW())) {
          continue;
        }
        localObject2 = SSLSocketFactory.getSocketFactory();
        ((SSLSocketFactory)localObject2).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        ((SchemeRegistry)localObject1).register(new Scheme("https", (SocketFactory)localObject2, 443));
      }
      catch (Exception localException)
      {
        Object localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("URLDrawable_", 2, "createHttpClient():Can't support https on this devices.", localException);
        continue;
      }
      localObject2 = new BasicHttpParams();
      ConnManagerParams.setTimeout((HttpParams)localObject2, 20000L);
      ConnManagerParams.setMaxConnectionsPerRoute((HttpParams)localObject2, new ConnPerRouteBean(10));
      ConnManagerParams.setMaxTotalConnections((HttpParams)localObject2, 10);
      HttpConnectionParams.setSocketBufferSize((HttpParams)localObject2, 8192);
      localObject1 = new aolf.a(new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1), (HttpParams)localObject2);
      ((aolf.a)localObject1).setRedirectHandler(new aolh());
      return localObject1;
      ((SchemeRegistry)localObject1).register(new Scheme("https", new aoog(aolf.class.getSimpleName()), 443));
    }
  }
  
  private void a(DownloadParams paramDownloadParams, boolean paramBoolean1, URL paramURL, HttpContext paramHttpContext, boolean paramBoolean2, int paramInt1, int paramInt2, IOException paramIOException)
  {
    int j = 0;
    int i = j;
    if (paramDownloadParams.mHttpDownloaderParams != null)
    {
      i = j;
      if ((paramDownloadParams.mHttpDownloaderParams instanceof aoli))
      {
        j = ((aoli)paramDownloadParams.mHttpDownloaderParams).businessType;
        i = j;
        if (paramHttpContext != null)
        {
          paramHttpContext.setAttribute("mobileqq_report_extra", paramDownloadParams.mHttpDownloaderParams);
          i = j;
        }
      }
    }
    QLog.d("HttpDownloader", 1, "f.businessType =  " + i + " success = " + paramBoolean1 + "config.mHttpDownloaderParams =" + paramDownloadParams.mHttpDownloaderParams);
    switch (i)
    {
    default: 
      return;
    }
    a(paramBoolean1, paramURL, paramHttpContext, paramBoolean2, paramInt1, paramInt2, paramIOException, null);
  }
  
  private void a(InputStream paramInputStream, long paramLong, OutputStream paramOutputStream, URLDrawableHandler paramURLDrawableHandler)
    throws IOException
  {
    paramInputStream = new BufferedInputStream(paramInputStream, 4096);
    try
    {
      byte[] arrayOfByte = new byte[4096];
      long l1 = 0L;
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
        long l2 = l1 + i;
        l1 = l2;
        if (AnimationUtils.currentAnimationTimeMillis() - 0L > 100L)
        {
          paramURLDrawableHandler.publishProgress((int)((float)l2 / (float)paramLong * 9500.0F));
          l1 = l2;
        }
      }
    }
    finally
    {
      paramInputStream.close();
    }
    if (this.dY.get()) {
      throw new IOException("cancelled");
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, Exception paramException, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    int i = paramInt2;
    if (paramException != null)
    {
      if (paramInt2 != -1) {
        break label223;
      }
      paramInt2 = a(20000, paramException, paramBoolean);
    }
    for (;;)
    {
      localHashMap.put("ERROR_MSG", paramException.getMessage());
      i = paramInt2;
      localHashMap.put("param_FailCode", String.valueOf(i));
      localHashMap.put("url", "" + paramString);
      localHashMap.put("API_LEVEL", "" + Build.VERSION.SDK_INT);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actHttpsDownloadFail", false, paramInt1, paramInt3, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.e("HttpDownloader", 2, "[reportHttpsResult] url=" + paramString + " port=" + paramInt1 + " responseCode=" + i + " " + paramInt3);
      }
      return;
      label223:
      paramInt2 += 10000;
    }
  }
  
  public static void a(String paramString, aoli paramaoli, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    String str;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      str = aoiz.getFilePath(paramString);
      if (!new File(str).exists()) {}
    }
    else
    {
      return;
    }
    aolm localaolm = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getNetEngine(0);
    aoll localaoll = new aoll();
    localaoll.cMG = true;
    localaoll.cMK = true;
    localaoll.f = new aolg(paramURLDrawableHandler, paramString, paramaoli);
    localaoll.bZ = paramString;
    localaoll.mHttpMethod = 0;
    localaoll.atY = str;
    localaoll.dPo = 2;
    localaoll.cMM = paramaoli.isPreDownload;
    localaolm.a(localaoll);
  }
  
  public static void a(boolean paramBoolean1, URL paramURL, HttpContext paramHttpContext, boolean paramBoolean2, int paramInt1, int paramInt2, IOException paramIOException, aoli paramaoli)
  {
    String str1 = paramURL.toString();
    String str2 = paramURL.getHost();
    Object localObject9 = null;
    Object localObject8 = null;
    Object localObject5 = null;
    int j;
    int i;
    int k;
    int m;
    Object localObject6;
    Object localObject4;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (paramaoli != null)
    {
      j = paramaoli.dPw;
      i = paramaoli.dPx;
      paramURL = paramaoli.clN;
      paramHttpContext = paramURL;
      k = i;
      m = j;
      if (!paramaoli.isPreDownload) {
        break label897;
      }
      localObject6 = "pre";
      localObject4 = null;
      localObject5 = null;
      localObject2 = null;
      paramaoli = paramURL;
      paramHttpContext = null;
      localObject3 = null;
      localObject1 = null;
      paramURL = (URL)localObject6;
    }
    for (;;)
    {
      if (!paramBoolean1)
      {
        try
        {
          localObject6 = InetAddress.getByName(str2);
          if (localObject6 == null) {
            break label838;
          }
          localObject6 = ((InetAddress)localObject6).getHostAddress();
        }
        catch (UnknownHostException localUnknownHostException)
        {
          for (;;)
          {
            int n;
            label196:
            label348:
            label367:
            localObject7 = localObject8;
            continue;
            k = 0;
            paramInt1 = 0;
            continue;
            localObject7 = null;
          }
        }
        n = paramInt1 * 10000;
        if (paramInt1 == 200) {
          if (!aqfo.isExistSDCard())
          {
            k = 1;
            paramInt1 = 1;
            m = paramInt1;
            if (paramIOException != null)
            {
              localObject8 = paramIOException.getMessage();
              m = paramInt1;
              paramURL = (URL)localObject8;
              if (k == 0)
              {
                m = a(paramInt1, paramIOException, paramBoolean2);
                paramURL = (URL)localObject8;
              }
            }
            if (n < 0) {
              break label788;
            }
            paramInt1 = m + n;
            localObject8 = new HashMap();
            ((HashMap)localObject8).put("param_FailCode", String.valueOf(paramInt1));
            ((HashMap)localObject8).put("param_Url", str1);
            ((HashMap)localObject8).put("serviceId", String.valueOf(j));
            ((HashMap)localObject8).put("templateId", String.valueOf(i));
            ((HashMap)localObject8).put("param_RetryCount", String.valueOf(paramInt2));
            ((HashMap)localObject8).put("param_Host", str2);
            ((HashMap)localObject8).put("param_Address", localObject6);
            ((HashMap)localObject8).put("param_First_Direct_Host", localObject5);
            ((HashMap)localObject8).put("param_First_Direct_Address", localObject4);
            ((HashMap)localObject8).put("param_Last_Direct_Host", localObject3);
            ((HashMap)localObject8).put("param_Last_Direct_Address", localObject2);
            if (localObject1 != null) {
              break label798;
            }
            paramIOException = "";
            ((HashMap)localObject8).put("param_DirectList", paramIOException);
            if (paramHttpContext != null) {
              break label808;
            }
            paramHttpContext = "";
            ((HashMap)localObject8).put("param_LastDirectUrl", paramHttpContext);
            ((HashMap)localObject8).put("param_ErrDesc", paramURL);
            ((HashMap)localObject8).put("uintype", paramaoli);
            if (QLog.isDevelopLevel()) {
              QLog.d("HttpDownloader", 4, "f =  " + ((HashMap)localObject8).toString());
            }
            anpc.a(BaseApplication.getContext()).collectPerformance(null, "StructMsgPicDown", paramBoolean1, 0L, 0L, (HashMap)localObject8, null);
            return;
            if (paramHttpContext == null) {
              break label943;
            }
            paramURL = paramHttpContext.getAttribute("mobileqq_report_extra");
            if ((paramURL == null) || (!(paramURL instanceof aoli))) {
              break label930;
            }
            paramURL = (aoli)paramURL;
            j = paramURL.dPw;
            i = paramURL.dPx;
          }
        }
      }
      for (paramURL = paramURL.clN;; paramURL = "0")
      {
        paramaoli = paramHttpContext.getAttribute("mobileqq_direct_uri");
        paramHttpContext = paramURL;
        k = i;
        m = j;
        if (paramaoli != null)
        {
          paramHttpContext = paramURL;
          k = i;
          m = j;
          if ((paramaoli instanceof List))
          {
            List localList = (List)paramaoli;
            StringBuilder localStringBuilder = new StringBuilder();
            localObject1 = null;
            localObject3 = null;
            localObject2 = null;
            localObject4 = null;
            k = 0;
            paramHttpContext = (HttpContext)localObject5;
            label578:
            if (k < localList.size())
            {
              URI localURI = (URI)localList.get(k);
              localStringBuilder.append(localURI.getHost()).append("|");
              localObject5 = null;
              try
              {
                localObject6 = InetAddress.getByName(localURI.getHost());
                paramaoli = (aoli)localObject5;
                if (localObject6 != null) {
                  paramaoli = ((InetAddress)localObject6).getHostAddress();
                }
              }
              catch (UnknownHostException paramaoli)
              {
                for (;;)
                {
                  paramaoli = (aoli)localObject5;
                }
              }
              if (paramaoli != null) {
                localStringBuilder.append(paramaoli);
              }
              localStringBuilder.append("|");
              if (k == 0)
              {
                localObject5 = localURI.getHost();
                localObject6 = paramaoli;
                if (k != localList.size() - 1) {
                  break label854;
                }
                paramHttpContext = localURI.toString();
              }
              label838:
              label854:
              for (;;)
              {
                k += 1;
                localObject3 = localObject6;
                localObject1 = localObject5;
                break label578;
                localObject6 = localObject3;
                localObject5 = localObject1;
                if (k != localList.size() - 1) {
                  break label688;
                }
                localObject2 = localURI.getHost();
                localObject4 = paramaoli;
                localObject6 = localObject3;
                localObject5 = localObject1;
                break label688;
                if (aqfo.getSDCardAvailableSize() < 8L)
                {
                  k = 1;
                  paramInt1 = 2;
                  break;
                  paramInt1 = n - m;
                  break label196;
                  paramIOException = localObject1.toString();
                  break label348;
                  break label367;
                }
                paramInt1 = 0;
                localObject7 = localObject9;
                break label196;
              }
            }
            label688:
            localList = null;
            label788:
            label798:
            label808:
            localObject5 = localObject3;
            paramaoli = paramURL;
            Object localObject7 = localObject1;
            localObject3 = localObject2;
            localObject1 = localStringBuilder;
            paramURL = localList;
            localObject2 = localObject4;
            localObject4 = localObject5;
            localObject5 = localObject7;
            break;
          }
        }
        label897:
        paramURL = null;
        localObject4 = null;
        localObject5 = null;
        localObject2 = null;
        j = m;
        paramaoli = paramHttpContext;
        paramHttpContext = null;
        i = k;
        localObject1 = null;
        localObject3 = null;
        break;
        label930:
        j = 0;
        i = 0;
      }
      label943:
      paramaoli = "0";
      localObject4 = null;
      paramURL = null;
      localObject5 = null;
      localObject2 = null;
      j = 0;
      i = 0;
      paramHttpContext = null;
      localObject1 = null;
      localObject3 = null;
    }
  }
  
  public static boolean azW()
  {
    if (!cMD) {
      cMD = true;
    }
    try
    {
      Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.aio_config.name(), "");
      if (QLog.isColorLevel()) {
        QLog.d("HttpDownloader", 2, "shutdownSniSupport:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 15) {
        cME = localObject[15].equals("1");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HttpDownloader", 2, "shutdownSniSupport e:" + localException.toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("HttpDownloader", 2, "shutdownSniSupport " + cME);
    }
    return cME;
  }
  
  public static void m(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramInt1));
    localHashMap.put("host", "" + paramString1);
    localHashMap.put("port", "" + paramInt2);
    localHashMap.put("businessType", paramString2);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actHttpsSniSupport", false, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.e("HttpDownloader", 2, "[reportHttpsSniMethod] reflectOrNot=" + paramInt1 + " host=" + paramString1 + " " + paramInt2);
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws IOException
  {
    return a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler, 0, null);
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt, URL paramURL)
    throws IOException
  {
    boolean bool1 = paramDownloadParams.needCheckNetType;
    boolean bool2 = aoop.isMobileNet();
    boolean bool3 = aoop.bE(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.i("HttpDownloader", 2, " downloadImage url = " + paramDownloadParams.url.toString() + " needCheckNetType:" + bool1 + " isMobileNet:" + bool2 + "isAutoDownloadAbled:" + bool3);
    }
    if ((paramDownloadParams.needCheckNetType) && (bool2) && (!bool3)) {
      return null;
    }
    if (a(paramDownloadParams, paramURLDrawableHandler)) {
      return null;
    }
    String str = null;
    bool3 = false;
    for (;;)
    {
      Object localObject1;
      int j;
      HttpGet localHttpGet;
      try
      {
        localObject1 = paramDownloadParams.url;
        if (paramURL != null) {
          localObject1 = paramURL;
        }
        QLog.d("HttpDownloader", 1, "HttpDownloader url " + ((URL)localObject1).toString());
        localObject2 = a((URL)localObject1, paramInt);
        if (localObject2 == null) {
          break label942;
        }
        bool2 = true;
        localObject1 = localObject2;
        j = -1;
        localHttpGet = a(paramDownloadParams, (URL)localObject1, bool2);
        localObject2 = a.getParams();
        if (localObject2 != null) {
          break label939;
        }
        localObject2 = new BasicHttpParams();
      }
      catch (URISyntaxException paramOutputStream)
      {
        label232:
        a(null, paramOutputStream.toString(), paramURLDrawableHandler);
        throw new IllegalArgumentException("illegal uri: " + paramDownloadParams.url.toString());
      }
      ((HttpParams)localObject2).setParameter("http.protocol.handle-redirects", Boolean.valueOf(bool1));
      ((HttpParams)localObject2).setParameter("http.connection.timeout", Integer.valueOf(10000));
      ((HttpParams)localObject2).setParameter("http.socket.timeout", Integer.valueOf(20000));
      a.setParams((HttpParams)localObject2);
      try
      {
        paramURLDrawableHandler.onFileDownloadStarted();
        if (!this.dY.get()) {
          break label404;
        }
        throw new IOException("cancelled");
      }
      catch (IOException paramURL)
      {
        i = -1;
        bool1 = false;
        paramOutputStream = str;
        a(paramDownloadParams, paramInt, paramOutputStream, bool1, i, paramURL);
        throw paramURL;
      }
      finally
      {
        localHttpGet.abort();
      }
      label398:
      bool1 = false;
      continue;
      label404:
      Object localObject2 = a.createHttpContext();
      bool1 = bool3;
      int i = j;
      try
      {
        HttpResponse localHttpResponse = a((URL)localObject1, localHttpGet, (HttpContext)localObject2);
        bool3 = true;
        bool1 = bool3;
        i = j;
        j = localHttpResponse.getStatusLine().getStatusCode();
        if (j != 200) {
          if (bool2) {
            if ((j == 301) || (j == 302) || (j == 303) || (j == 307))
            {
              bool1 = bool3;
              i = j;
              localObject1 = localHttpResponse.getFirstHeader("location");
              if (localObject1 == null) {
                break label730;
              }
              bool1 = bool3;
              i = j;
              str = ((Header)localObject1).getValue();
              bool1 = bool3;
              i = j;
              bool2 = TextUtils.isEmpty(str);
              if (bool2) {
                break label730;
              }
              bool1 = bool3;
              i = j;
            }
          }
        }
        label939:
        label942:
        label948:
        label959:
        for (;;)
        {
          try
          {
            localObject1 = new URL(str);
            paramURL = (URL)localObject1;
            bool1 = bool3;
            i = j;
            if (QLog.isColorLevel())
            {
              bool1 = bool3;
              i = j;
              QLog.e("HttpDownloader", 2, "302 new url=" + str);
            }
            bool1 = bool3;
            i = j;
            paramOutputStream = a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt + 1, paramURL);
            localHttpGet.abort();
            return paramOutputStream;
          }
          catch (Exception localException)
          {
            bool1 = bool3;
            i = j;
            if (!QLog.isColorLevel()) {
              break label959;
            }
          }
          bool1 = bool3;
          i = j;
          QLog.e("HttpDownloader", 2, "302 failed convert redirectUrl");
          break label959;
          bool1 = bool3;
          i = j;
          aopd.a().X(paramDownloadParams.url.getHost(), localException.getHost(), 1010);
          label730:
          bool1 = bool3;
          i = j;
          if (paramInt < paramDownloadParams.retryCount)
          {
            bool1 = bool3;
            i = j;
            paramOutputStream = a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt + 1, null);
            localHttpGet.abort();
            return paramOutputStream;
          }
          bool1 = bool3;
          i = j;
          paramURLDrawableHandler.onFileDownloadFailed(j);
          bool1 = bool3;
          i = j;
          throw new IOException("response error::response_code=" + j + ",url=" + paramDownloadParams.url + " . reason: " + localHttpResponse.getStatusLine().getReasonPhrase());
          bool1 = bool3;
          i = j;
          a(localHttpResponse, null, paramURLDrawableHandler);
          bool1 = bool3;
          i = j;
          paramURL = localHttpResponse.getEntity();
          bool1 = bool3;
          i = j;
          paramOutputStream = a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt, (HttpContext)localObject2, true, j, paramURL.getContent(), paramURL.getContentLength());
          localHttpGet.abort();
          return paramOutputStream;
          break label948;
          bool2 = false;
          break;
          if (bool2) {
            break label398;
          }
          bool1 = true;
          break label232;
        }
      }
      catch (IOException paramURL)
      {
        paramOutputStream = (OutputStream)localObject2;
      }
    }
  }
  
  @Nullable
  protected File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, HttpContext paramHttpContext, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong)
    throws IOException
  {
    a(paramInputStream, paramLong, paramOutputStream, paramURLDrawableHandler);
    a(paramDownloadParams, true, paramDownloadParams.url, paramHttpContext, paramBoolean, paramInt2, paramInt1, null);
    if ("https".equals(paramDownloadParams.url.getProtocol())) {
      a(paramDownloadParams.url.getHost(), paramDownloadParams.url.getPort(), paramInt2, paramInt1, null, paramBoolean);
    }
    paramURLDrawableHandler.onFileDownloadSucceed(paramLong);
    return null;
  }
  
  public URL a(URL paramURL, int paramInt)
    throws MalformedURLException
  {
    if ((this.cMC) && (paramInt == 0) && ("http".equals(paramURL.getProtocol())))
    {
      Object localObject = paramURL.getHost();
      if (!aqmr.isEmpty((String)localObject))
      {
        String str = aopd.a().aC((String)localObject, 1010);
        if ((!((String)localObject).equals(str)) && (!aqmr.isEmpty(str)))
        {
          paramURL = aopd.bK(paramURL.toString(), str);
          localObject = new URL(paramURL);
          QLog.d("HttpDownloader", 1, "HttpDownloader use ip " + paramURL);
          return localObject;
        }
      }
    }
    return null;
  }
  
  public HttpResponse a(URL paramURL, HttpGet paramHttpGet, HttpContext paramHttpContext)
    throws IOException
  {
    Object localObject2 = null;
    long l1 = System.currentTimeMillis();
    HttpResponse localHttpResponse = a.execute(paramHttpGet, paramHttpContext);
    long l2 = System.currentTimeMillis();
    int i = localHttpResponse.getStatusLine().getStatusCode();
    Object localObject1;
    if (localHttpResponse != null) {
      if (localHttpResponse.getHeaders("X-Server-Ip") != null)
      {
        paramHttpGet = localHttpResponse.getHeaders("X-Server-Ip");
        if ((paramHttpGet != null) && (paramHttpGet.length > 0) && (paramHttpGet[0] != null))
        {
          paramHttpGet = paramHttpGet[0].getValue();
          paramHttpContext = paramHttpGet;
          localObject1 = localObject2;
          if (localHttpResponse.getHeaders("X-Client-Ip") != null)
          {
            Header[] arrayOfHeader = localHttpResponse.getHeaders("X-Client-Ip");
            paramHttpContext = paramHttpGet;
            localObject1 = localObject2;
            if (arrayOfHeader != null)
            {
              paramHttpContext = paramHttpGet;
              localObject1 = localObject2;
              if (arrayOfHeader.length > 0)
              {
                paramHttpContext = paramHttpGet;
                localObject1 = localObject2;
                if (arrayOfHeader[0] != null)
                {
                  localObject1 = arrayOfHeader[0].getValue();
                  paramHttpContext = paramHttpGet;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.e("HttpDownloader", 1, "responseCode " + i + " url " + paramURL + " clientIp " + (String)localObject1 + " serverIp " + paramHttpContext + " responseTime: " + (l2 - l1));
      return localHttpResponse;
      paramHttpGet = null;
      break;
      paramHttpContext = null;
      localObject1 = localObject2;
    }
  }
  
  public HttpGet a(DownloadParams paramDownloadParams, URL paramURL, boolean paramBoolean)
    throws URISyntaxException, IOException
  {
    if (this.dY.get()) {
      throw new IOException("cancelled");
    }
    try
    {
      localObject = new HttpGet(paramURL.toURI());
      paramURL = (URL)localObject;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      for (;;)
      {
        Object localObject;
        paramURL = new HttpGet(new URI(paramURL.getProtocol(), paramURL.getHost(), paramURL.getPath(), paramURL.getQuery(), null));
      }
      if ((paramDownloadParams.headers == null) || (paramDownloadParams.headers.length <= 0)) {
        break label195;
      }
      Header[] arrayOfHeader = paramDownloadParams.headers;
      int j = arrayOfHeader.length;
      int i = 0;
      while (i < j)
      {
        paramURL.addHeader(arrayOfHeader[i]);
        i += 1;
      }
      label195:
      if (!paramBoolean) {
        return paramURL;
      }
      paramURL.addHeader("host", paramDownloadParams.url.getHost());
    }
    if (paramDownloadParams.cookies != null)
    {
      localObject = a.getCookieSpecs().getCookieSpec("best-match").formatCookies(paramDownloadParams.cookies.getCookies()).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramURL.addHeader((Header)((Iterator)localObject).next());
      }
    }
    return paramURL;
  }
  
  protected void a(DownloadParams paramDownloadParams, int paramInt1, HttpContext paramHttpContext, boolean paramBoolean, int paramInt2, IOException paramIOException)
  {
    a(paramDownloadParams, false, paramDownloadParams.url, paramHttpContext, paramBoolean, paramInt2, paramInt1, paramIOException);
    if ("https".equals(paramDownloadParams.url.getProtocol())) {
      a(paramDownloadParams.url.getHost(), paramDownloadParams.url.getPort(), paramInt2, paramInt1, paramIOException, paramBoolean);
    }
  }
  
  protected void a(HttpResponse paramHttpResponse, String paramString, URLDrawableHandler paramURLDrawableHandler) {}
  
  public boolean a(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    aoli localaoli;
    if ((paramDownloadParams.mHttpDownloaderParams != null) && ((paramDownloadParams.mHttpDownloaderParams instanceof aoli)))
    {
      localaoli = (aoli)paramDownloadParams.mHttpDownloaderParams;
      if ((localaoli.businessType != 1001) || (!akyd.mIsOpen)) {}
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("HttpDownloader", 2, " structMsgCover download downloadImageByHttpEngine url = " + paramDownloadParams.url.toString());
      }
      label79:
      a(paramDownloadParams.url.toString(), localaoli, paramURLDrawableHandler, 0);
      return true;
      return false;
    }
    catch (Exception localException)
    {
      break label79;
    }
  }
  
  public boolean azK()
  {
    return true;
  }
  
  public void cancel()
  {
    this.dY.set(true);
  }
  
  public static class a
    extends DefaultHttpClient
  {
    public a(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
    {
      super(null);
    }
    
    public HttpContext createHttpContext()
    {
      return super.createHttpContext();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aolf
 * JD-Core Version:    0.7.0.1
 */