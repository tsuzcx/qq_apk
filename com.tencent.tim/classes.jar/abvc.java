import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.2;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.3;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.PreloadCGITask.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class abvc
  implements abvf.a, Handler.Callback
{
  private static long OB = new Random().nextInt(263167);
  public static String bhY = acfp.m(2131702668);
  private volatile abvb jdField_a_of_type_Abvb;
  private abve jdField_a_of_type_Abve = new abve();
  private volatile boolean bFM;
  private boolean bFN = true;
  private boolean bFO;
  private boolean bFP;
  private final String bhZ;
  private String bia;
  private final AtomicBoolean clientIsReady = new AtomicBoolean(false);
  private final AtomicBoolean cu = new AtomicBoolean(false);
  private String currUrl;
  private ConcurrentHashMap<String, abvc.a> dA = new ConcurrentHashMap();
  private Message e;
  private String gv;
  public final String id;
  private final AtomicBoolean isWaitingForDestroy = new AtomicBoolean(false);
  private final AtomicBoolean isWaitingForSessionThread = new AtomicBoolean(false);
  private volatile CustomWebView mWebView;
  private final Handler mainHandler = new Handler(Looper.getMainLooper(), this);
  private volatile InputStream pendingWebResourceStream;
  private final AtomicInteger sessionState = new AtomicInteger(0);
  private String srcUrl;
  private final AtomicBoolean wasInterceptInvoked = new AtomicBoolean(false);
  private final AtomicBoolean wasLoadDataInvoked = new AtomicBoolean(false);
  private final AtomicBoolean wasLoadUrlInvoked = new AtomicBoolean(false);
  
  public abvc(String paramString1, String paramString2)
  {
    this.bhZ = paramString2;
    long l = OB;
    OB = 1L + l;
    this.id = String.valueOf(l);
    this.srcUrl = abuj.x(paramString1, "apollo_task_id", String.valueOf(this.id));
    this.currUrl = this.srcUrl;
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") create:id=" + this.id + ", url = " + paramString1);
    }
  }
  
  public static abvc a(boolean paramBoolean, String paramString)
  {
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString))
    {
      String str = abvd.a().iQ(paramString);
      if (abvd.a().jF(str))
      {
        paramString = new abvc(paramString, str);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 2, "createInterceptor startSessionNewThread:" + paramBoolean + ",use:" + (System.currentTimeMillis() - l));
        }
        paramString.start(paramBoolean);
        return paramString;
      }
    }
    return null;
  }
  
  private void cFB()
  {
    long l = System.currentTimeMillis();
    Object localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    if ((localObject != null) && (!TextUtils.isEmpty(this.bhZ)))
    {
      abvd.a().a(BaseApplicationImpl.getContext(), this.bhZ, this.currUrl, (AppInterface)localObject, this.jdField_a_of_type_Abve);
      localObject = abvd.a().aj(this.bhZ);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          abuy.a locala = (abuy.a)((Iterator)localObject).next();
          if (locala.jQ())
          {
            abvc.a locala1 = new abvc.a(locala);
            this.dA.put(locala.mUrl, locala1);
            locala1.cFE();
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "preloadSSOData use:" + (System.currentTimeMillis() - l));
    }
  }
  
  private void cFC()
  {
    if (1 != this.sessionState.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") runDataTask error:sessionState=" + this.sessionState.get() + ".");
      }
      this.bFO = true;
      this.isWaitingForSessionThread.set(false);
      this.mainHandler.sendEmptyMessage(3);
      return;
    }
    this.mainHandler.removeMessages(255);
    long l1 = System.currentTimeMillis();
    this.bia = abuj.getFileName(this.currUrl);
    if (TextUtils.isEmpty(this.bia))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") runDataTask error:fileName is null");
      }
      this.bFO = true;
      this.isWaitingForSessionThread.set(false);
      this.mainHandler.sendEmptyMessage(3);
      return;
    }
    Object localObject1 = abuj.getFilePath(this.bia);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") runDataTask url is " + this.currUrl + " filePath is " + (String)localObject1);
    }
    Object localObject2 = new File((String)localObject1);
    localObject1 = abuj.m((File)localObject2);
    this.jdField_a_of_type_Abve.OH = (System.currentTimeMillis() - l1);
    boolean bool1;
    label296:
    boolean bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      bool1 = true;
      if (!bool1) {
        break label663;
      }
      long l2 = System.currentTimeMillis();
      if (abvd.a().aq(this.bhZ, (String)localObject1)) {
        break label652;
      }
      localObject1 = null;
      ((File)localObject2).delete();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") runDataTask md5 not match delete localFile! url is " + this.currUrl);
      }
      this.jdField_a_of_type_Abve.csY = 1;
      bool1 = false;
      label387:
      this.jdField_a_of_type_Abve.OI = (System.currentTimeMillis() - l2);
      localObject2 = localObject1;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "verify use:" + (System.currentTimeMillis() - l2));
        bool2 = bool1;
        localObject2 = localObject1;
      }
      label451:
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "get LocalFile use:" + (System.currentTimeMillis() - l1));
      }
      localObject1 = this.mainHandler.obtainMessage(1);
      this.e = ((Message)localObject1);
      if (!bool2) {
        break label682;
      }
      ((Message)localObject1).arg1 = 2;
      ((Message)localObject1).obj = localObject2;
      this.mainHandler.sendMessage((Message)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") runDataTask hasHtmlCache:" + bool2);
      }
      this.gv = ((String)localObject2);
    }
    for (;;)
    {
      switchState(1, 2, true);
      this.isWaitingForSessionThread.set(false);
      if ((!postForceDestroyIfNeed()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.id + ") runDataTask:send force destroy message.");
      return;
      bool1 = false;
      break label296;
      label652:
      this.jdField_a_of_type_Abve.csY = 2;
      break label387;
      label663:
      this.jdField_a_of_type_Abve.csY = 0;
      localObject2 = localObject1;
      bool2 = bool1;
      break label451;
      label682:
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") runDataTask has no cache, do first load flow.");
      }
      ((Message)localObject1).arg1 = 1;
      this.mainHandler.sendMessage((Message)localObject1);
      if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext()))
      {
        if (!TextUtils.isEmpty(bhY)) {
          this.mainHandler.sendEmptyMessageDelayed(255, 1500L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 1, "task(" + this.id + ") runDataTask error:network is not valid!");
        }
      }
      else
      {
        cFD();
      }
    }
  }
  
  private void cFD()
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Abvb = new abvb(this.currUrl, true, null, null);
    long l2 = System.currentTimeMillis();
    int j = this.jdField_a_of_type_Abvb.connect();
    int i = j;
    Map localMap;
    if (j == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") connection connect cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      l2 = System.currentTimeMillis();
      j = this.jdField_a_of_type_Abvb.getResponseCode();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") connection response cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      l2 = System.currentTimeMillis();
      localMap = this.jdField_a_of_type_Abvb.getResponseHeaderFields();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") connection get header fields cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      i = j;
      if (localMap != null)
      {
        if (!localMap.containsKey("Set-Cookie")) {
          break label410;
        }
        localObject = "Set-Cookie";
      }
    }
    label410:
    do
    {
      for (;;)
      {
        i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (List)localMap.get(localObject);
          abuj.setCookie(this.currUrl, (List)localObject);
          i = j;
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.id + ") handleFlow_Connection: respCode = " + i + ", cost " + (System.currentTimeMillis() - l1) + " ms.");
        }
        if (!isDestroyedOrWaitingForDestroy()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 6, "task(" + this.id + ") handleFlow_Connection: destroy before server response.");
        }
        return;
        if (localMap.containsKey("set-cookie")) {
          localObject = "set-cookie";
        }
      }
      if (200 == i) {
        break;
      }
      if (this.bFN)
      {
        this.mainHandler.removeMessages(1);
        localObject = this.mainHandler.obtainMessage(5);
        ((Message)localObject).arg1 = i;
        this.mainHandler.sendMessage((Message)localObject);
      }
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.id + ") handleFlow_Connection: response code not 200, response code = " + i);
    return;
    handleFlow_FirstLoad();
  }
  
  private boolean canDestroy()
  {
    if ((this.isWaitingForSessionThread.get()) || (this.cu.get()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") canDestroy:false, isWaitingForSessionThread=" + this.isWaitingForSessionThread.get() + ", isWaitingForBlinkCloseStream=" + this.cu.get() + " isWaitingForDestroy:" + this.isWaitingForDestroy);
      }
      return false;
    }
    return true;
  }
  
  private void destroy(boolean paramBoolean)
  {
    int i = this.sessionState.get();
    if (3 != i)
    {
      this.mWebView = null;
      this.pendingWebResourceStream = null;
      this.gv = null;
      if (this.e != null) {
        this.e = null;
      }
      if ((!paramBoolean) && (!canDestroy())) {
        break label227;
      }
      if ((this.jdField_a_of_type_Abvb != null) && (!paramBoolean))
      {
        this.jdField_a_of_type_Abvb.disconnect();
        this.jdField_a_of_type_Abvb = null;
      }
      this.sessionState.set(3);
      synchronized (this.sessionState)
      {
        this.sessionState.notify();
        this.mainHandler.removeMessages(10);
        this.isWaitingForDestroy.set(false);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") final destroy, force=" + paramBoolean + ".");
        }
        this.mainHandler.removeMessages(255);
        ??? = this.dA.values().iterator();
        if (((Iterator)???).hasNext()) {
          ((abvc.a)((Iterator)???).next()).onDestroy();
        }
      }
      this.dA.clear();
    }
    label227:
    do
    {
      do
      {
        return;
        this.mainHandler.removeMessages(255);
      } while (!this.isWaitingForDestroy.compareAndSet(false, true));
      this.mainHandler.sendEmptyMessageDelayed(10, 6000L);
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") waiting for destroy, current state =" + i + ".");
  }
  
  private void handleFlow_FirstLoad()
  {
    int i = 2;
    Object localObject1 = this.jdField_a_of_type_Abvb.a(this.wasInterceptInvoked, null);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") handleFlow_FirstLoad error:responseDataTuple is null!");
      }
      this.bFO = true;
      this.mainHandler.sendEmptyMessage(3);
      return;
    }
    this.pendingWebResourceStream = new abvf(this, ((abvb.a)localObject1).outputStream, ((abvb.a)localObject1).responseStream);
    if (((abvb.a)localObject1).isComplete) {}
    for (;;)
    {
      try
      {
        localObject1 = ((abvb.a)localObject1).outputStream.toString("UTF-8");
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          this.gv = ((String)localObject1);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label399;
          }
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.id + ") handleFlow_FirstLoad:hasCacheData=" + bool + ".");
          }
          this.mainHandler.removeMessages(1);
          localObject2 = this.mainHandler.obtainMessage(2);
          ((Message)localObject2).obj = localObject1;
          if (!bool) {
            break label404;
          }
          ((Message)localObject2).arg1 = i;
          this.e = ((Message)localObject2);
          this.mainHandler.sendMessage((Message)localObject2);
          if ((!bool) || (this.bFM)) {
            break;
          }
          long l = System.currentTimeMillis();
          abvd.a().ar(this.currUrl, (String)localObject1);
          this.bFM = true;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.id + ") handleFlow_FirstLoad :save htmlString " + (System.currentTimeMillis() - l) + " ms.");
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            boolean bool;
            Object localObject2 = localObject1;
          }
        }
        localThrowable1 = localThrowable1;
        localObject2 = null;
      }
      this.pendingWebResourceStream = null;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") handleFlow_FirstLoad error:" + localThrowable1.getMessage() + ".");
        localObject1 = localObject2;
        continue;
        label399:
        bool = false;
        continue;
        label404:
        i = 1;
        continue;
        localObject1 = null;
      }
    }
  }
  
  private boolean isDestroyedOrWaitingForDestroy()
  {
    return (3 == this.sessionState.get()) || (this.isWaitingForDestroy.get());
  }
  
  private boolean postForceDestroyIfNeed()
  {
    if ((this.isWaitingForDestroy.get()) && (canDestroy()))
    {
      this.mainHandler.sendEmptyMessage(10);
      return true;
    }
    return false;
  }
  
  private boolean switchState(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.sessionState.compareAndSet(paramInt1, paramInt2))
    {
      if (paramBoolean) {
        synchronized (this.sessionState)
        {
          this.sessionState.notify();
        }
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  public boolean Zk()
  {
    return !this.bFO;
  }
  
  public abve a()
  {
    return this.jdField_a_of_type_Abve;
  }
  
  public boolean a(CustomWebView paramCustomWebView)
  {
    if (this.mWebView == null)
    {
      this.mWebView = paramCustomWebView;
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") bind client.");
      return true;
    }
    return false;
  }
  
  public void destroy()
  {
    destroy(false);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (10 == paramMessage.what)
    {
      destroy(true);
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") handleMessage:force destroy.");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        if (!isDestroyedOrWaitingForDestroy()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") handleMessage error: is destroyed or waiting for destroy.");
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") handleMessage: msg what = " + paramMessage.what + ".");
      }
      if ((paramMessage.what > 0) && (paramMessage.what < 7) && (!this.clientIsReady.get()))
      {
        this.e = Message.obtain(paramMessage);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") handleMessage: client not ready, core msg = " + paramMessage.what + ".");
        }
        return true;
      }
      if (paramMessage == this.e) {
        this.e = null;
      }
      switch (paramMessage.what)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloUrlInterceptor", 2, "msg.what " + paramMessage.what);
    return false;
    if (paramMessage.arg1 == 1) {
      if (this.wasLoadUrlInvoked.compareAndSet(false, true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") handleClientCoreMessage_PreLoad:PRE_LOAD_NO_CACHE load url.");
        }
        this.jdField_a_of_type_Abve.OM = System.currentTimeMillis();
        if (this.mWebView != null) {
          this.mWebView.loadUrlOriginal(this.currUrl);
        }
      }
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel())
      {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") handleClientCoreMessage_PreLoad:wasLoadUrlInvoked = true.");
        continue;
        if (paramMessage.arg1 == 2) {
          if (this.wasLoadDataInvoked.compareAndSet(false, true))
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") handleClientCoreMessage_PreLoad:PRE_LOAD_WITH_CACHE load data.");
            }
            paramMessage = (String)paramMessage.obj;
            this.jdField_a_of_type_Abve.OM = System.currentTimeMillis();
            if (this.mWebView != null) {
              if (this.mWebView.getX5WebViewExtension() != null)
              {
                this.mWebView.loadDataWithBaseURL(this.currUrl, paramMessage, "text/html", "utf-8", this.currUrl);
              }
              else
              {
                this.mWebView.loadUrlOriginal(this.currUrl);
                QLog.e("apollo_client_ApolloUrlInterceptor", 1, "handleMessage CLIENT_CORE_MSG_PRE_LOAD PRE_LOAD_WITH_CACHE but not x5 Core");
              }
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") handleClientCoreMessage_PreLoad:wasLoadDataInvoked = true.");
            continue;
            if (paramMessage.arg1 == 1)
            {
              if (this.wasInterceptInvoked.get())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") handleClientCoreMessage_FirstLoad:FIRST_LOAD_NO_CACHE.");
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") handleClientCoreMessage_FirstLoad:url was not invoked.");
              }
            }
            else if (paramMessage.arg1 == 2) {
              if (this.wasLoadUrlInvoked.compareAndSet(false, true))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(\" + id + \") handleClientCoreMessage_FirstLoad with cache, url:" + this.currUrl);
                }
                this.bFP = true;
                this.jdField_a_of_type_Abve.OM = System.currentTimeMillis();
                if (this.mWebView != null) {
                  if (this.mWebView.getX5WebViewExtension() != null)
                  {
                    this.mWebView.loadDataWithBaseURL(this.currUrl, (String)paramMessage.obj, "text/html", "utf-8", this.currUrl);
                  }
                  else
                  {
                    this.mWebView.loadUrlOriginal(this.currUrl);
                    QLog.e("apollo_client_ApolloUrlInterceptor", 1, "handleMessage CLIENT_CORE_MSG_FIRST_LOAD PRE_LOAD_WITH_CACHE but not x5 Core");
                  }
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") FIRST_LOAD_WITH_CACHE load url was invoked.");
                continue;
                if (this.wasLoadUrlInvoked.compareAndSet(false, true))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("apollo_client_ApolloUrlInterceptor", 2, "handleClientCoreMessage_ConnectionError: load src url.");
                  }
                  if (this.mWebView != null)
                  {
                    this.mWebView.loadUrlOriginal(this.currUrl);
                    continue;
                    if ((this.clientIsReady.get()) && (!isDestroyedOrWaitingForDestroy()) && (!TextUtils.isEmpty(bhY))) {
                      Toast.makeText(BaseApplicationImpl.getContext(), bhY, 1).show();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean isMatchCurrentUrl(String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(this.currUrl);
      paramString = Uri.parse(paramString);
      Object localObject = localUri.getHost() + localUri.getPath();
      String str = paramString.getHost() + paramString.getPath();
      if (localUri.getHost().equalsIgnoreCase(paramString.getHost()))
      {
        paramString = (String)localObject;
        if (!((String)localObject).endsWith("/")) {
          paramString = (String)localObject + "/";
        }
        localObject = str;
        if (!str.endsWith("/")) {
          localObject = str + "/";
        }
        boolean bool = paramString.equalsIgnoreCase((String)localObject);
        return bool;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("apollo_client_ApolloUrlInterceptor", 2, "isMatchCurrentUrl error:" + paramString.getMessage());
    }
    return false;
  }
  
  public boolean jE(String paramString)
  {
    boolean bool = false;
    if ((!this.bFO) && (isMatchCurrentUrl(paramString)) && (this.clientIsReady.compareAndSet(false, true)))
    {
      this.currUrl = abuj.x(paramString, "apollo_task_id", String.valueOf(this.id));
      this.jdField_a_of_type_Abve.OL = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("task(").append(this.id).append(") onWebViewInited: mPendingClientCoreMessage not null:");
        if (this.e != null) {
          bool = true;
        }
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, bool + ",currUrl:" + this.currUrl);
      }
      if (this.e != null)
      {
        paramString = this.e;
        this.e = null;
        handleMessage(paramString);
      }
      while (this.sessionState.get() != 0) {
        return true;
      }
      start(true);
      return true;
    }
    return false;
  }
  
  public void onClose(boolean paramBoolean, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    boolean bool = true;
    if (this.pendingWebResourceStream != null) {
      this.pendingWebResourceStream = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 1, "task(" + this.id + ") onClose:readComplete:" + paramBoolean);
    }
    long l = System.currentTimeMillis();
    if ((paramBoolean) && (paramByteArrayOutputStream != null))
    {
      ThreadManager.getSubThreadHandler().postDelayed(new ApolloUrlInterceptor.3(this, paramByteArrayOutputStream), 3000L);
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("task(").append(this.id).append(") onClose error:readComplete =").append(paramBoolean).append(", outputStream is null -> ");
      if (paramByteArrayOutputStream != null) {
        break label262;
      }
    }
    label262:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      QLog.e("apollo_client_ApolloUrlInterceptor", 6, paramBoolean);
      this.cu.set(false);
      if (postForceDestroyIfNeed()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") onClose: postForceDestroyIfNeed send destroy message in chromium_io thread.");
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("apollo_client_ApolloUrlInterceptor", 6, "task(" + this.id + ") onClose cost " + (System.currentTimeMillis() - l) + " ms.");
      return;
    }
  }
  
  /* Error */
  public Object p(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 326	abvc:bFO	Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 497	abvc:mWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   13: ifnull +66 -> 79
    //   16: invokestatic 198	abvd:a	()Labvd;
    //   19: aload_1
    //   20: invokevirtual 729	abvd:jG	(Ljava/lang/String;)Z
    //   23: ifeq +56 -> 79
    //   26: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +29 -> 58
    //   32: ldc 159
    //   34: iconst_2
    //   35: new 161	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 731
    //   45: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: invokestatic 198	abvd:a	()Labvd;
    //   61: aload_1
    //   62: aload_0
    //   63: getfield 128	abvc:bhZ	Ljava/lang/String;
    //   66: invokevirtual 734	abvd:e	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   69: astore 5
    //   71: aload 5
    //   73: ifnull +6 -> 79
    //   76: aload 5
    //   78: areturn
    //   79: aload_0
    //   80: getfield 497	abvc:mWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   83: ifnull +139 -> 222
    //   86: aload_0
    //   87: getfield 126	abvc:dA	Ljava/util/concurrent/ConcurrentHashMap;
    //   90: invokevirtual 735	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   93: ifne +129 -> 222
    //   96: aload_0
    //   97: getfield 126	abvc:dA	Ljava/util/concurrent/ConcurrentHashMap;
    //   100: invokevirtual 515	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   103: invokeinterface 518 1 0
    //   108: astore 5
    //   110: aload 5
    //   112: invokeinterface 289 1 0
    //   117: ifeq +105 -> 222
    //   120: aload 5
    //   122: invokeinterface 293 1 0
    //   127: checkcast 10	abvc$a
    //   130: astore 6
    //   132: aload_1
    //   133: aload 6
    //   135: invokestatic 738	abvc$a:a	(Labvc$a;)Labuy$a;
    //   138: getfield 304	abuy$a:mUrl	Ljava/lang/String;
    //   141: invokevirtual 741	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   144: ifeq -34 -> 110
    //   147: aload 6
    //   149: aload_1
    //   150: invokevirtual 744	abvc$a:d	(Ljava/lang/String;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   153: astore 7
    //   155: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +40 -> 198
    //   161: ldc 159
    //   163: iconst_2
    //   164: new 161	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 746
    //   174: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_1
    //   178: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc_w 748
    //   184: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 7
    //   189: invokevirtual 494	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload_0
    //   199: getfield 126	abvc:dA	Ljava/util/concurrent/ConcurrentHashMap;
    //   202: aload 6
    //   204: invokestatic 738	abvc$a:a	(Labvc$a;)Labuy$a;
    //   207: getfield 304	abuy$a:mUrl	Ljava/lang/String;
    //   210: invokevirtual 751	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   213: pop
    //   214: aload 7
    //   216: ifnull -106 -> 110
    //   219: aload 7
    //   221: areturn
    //   222: aload_0
    //   223: aload_1
    //   224: invokevirtual 684	abvc:isMatchCurrentUrl	(Ljava/lang/String;)Z
    //   227: ifne +49 -> 276
    //   230: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -226 -> 7
    //   236: ldc 159
    //   238: iconst_2
    //   239: new 161	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   246: ldc 164
    //   248: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_0
    //   252: getfield 136	abvc:id	Ljava/lang/String;
    //   255: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc_w 753
    //   261: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_1
    //   265: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aconst_null
    //   275: areturn
    //   276: aload_0
    //   277: getfield 89	abvc:wasInterceptInvoked	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   280: invokevirtual 485	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   283: ifeq +47 -> 330
    //   286: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +41 -> 330
    //   292: ldc 159
    //   294: iconst_2
    //   295: new 161	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   302: ldc 164
    //   304: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_0
    //   308: getfield 136	abvc:id	Ljava/lang/String;
    //   311: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc_w 755
    //   317: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_1
    //   321: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: aload_0
    //   331: getfield 89	abvc:wasInterceptInvoked	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   334: iconst_0
    //   335: iconst_1
    //   336: invokevirtual 528	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   339: ifne +47 -> 386
    //   342: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq +41 -> 386
    //   348: ldc 159
    //   350: iconst_2
    //   351: new 161	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   358: ldc 164
    //   360: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_0
    //   364: getfield 136	abvc:id	Ljava/lang/String;
    //   367: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: ldc_w 757
    //   373: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload_1
    //   377: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   389: ifeq +41 -> 430
    //   392: ldc 159
    //   394: iconst_2
    //   395: new 161	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   402: ldc 164
    //   404: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_0
    //   408: getfield 136	abvc:id	Ljava/lang/String;
    //   411: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc_w 759
    //   417: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_1
    //   421: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: invokestatic 187	java/lang/System:currentTimeMillis	()J
    //   433: lstore_2
    //   434: aload_0
    //   435: getfield 82	abvc:sessionState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   438: invokevirtual 317	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   441: iconst_1
    //   442: if_icmpne +357 -> 799
    //   445: aload_0
    //   446: getfield 82	abvc:sessionState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   449: astore_1
    //   450: aload_1
    //   451: monitorenter
    //   452: aload_0
    //   453: getfield 82	abvc:sessionState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   456: invokevirtual 317	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   459: iconst_1
    //   460: if_icmpne +53 -> 513
    //   463: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   466: ifeq +37 -> 503
    //   469: ldc 159
    //   471: iconst_2
    //   472: new 161	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   479: ldc 164
    //   481: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload_0
    //   485: getfield 136	abvc:id	Ljava/lang/String;
    //   488: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: ldc_w 761
    //   494: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: aload_0
    //   504: getfield 82	abvc:sessionState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   507: ldc2_w 762
    //   510: invokevirtual 767	java/lang/Object:wait	(J)V
    //   513: aload_1
    //   514: monitorexit
    //   515: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq +74 -> 592
    //   521: new 161	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   528: ldc 164
    //   530: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload_0
    //   534: getfield 136	abvc:id	Ljava/lang/String;
    //   537: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: ldc_w 769
    //   543: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: astore_1
    //   547: aload_0
    //   548: getfield 499	abvc:pendingWebResourceStream	Ljava/io/InputStream;
    //   551: ifnull +298 -> 849
    //   554: iconst_1
    //   555: istore 4
    //   557: ldc 159
    //   559: iconst_2
    //   560: aload_1
    //   561: iload 4
    //   563: invokevirtual 213	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   566: ldc_w 473
    //   569: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: invokestatic 187	java/lang/System:currentTimeMillis	()J
    //   575: lload_2
    //   576: lsub
    //   577: invokevirtual 218	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   580: ldc_w 771
    //   583: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   592: aload_0
    //   593: getfield 499	abvc:pendingWebResourceStream	Ljava/io/InputStream;
    //   596: ifnonnull +54 -> 650
    //   599: aload_0
    //   600: getfield 404	abvc:gv	Ljava/lang/String;
    //   603: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   606: ifne +44 -> 650
    //   609: aload_0
    //   610: new 773	java/io/ByteArrayInputStream
    //   613: dup
    //   614: aload_0
    //   615: getfield 404	abvc:gv	Ljava/lang/String;
    //   618: ldc_w 559
    //   621: invokevirtual 777	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   624: invokespecial 780	java/io/ByteArrayInputStream:<init>	([B)V
    //   627: putfield 499	abvc:pendingWebResourceStream	Ljava/io/InputStream;
    //   630: aload_0
    //   631: iconst_1
    //   632: putfield 643	abvc:bFP	Z
    //   635: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   638: ifeq +12 -> 650
    //   641: ldc 159
    //   643: iconst_2
    //   644: ldc_w 782
    //   647: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   650: aload_0
    //   651: getfield 499	abvc:pendingWebResourceStream	Ljava/io/InputStream;
    //   654: ifnull +236 -> 890
    //   657: aload_0
    //   658: invokespecial 243	abvc:isDestroyedOrWaitingForDestroy	()Z
    //   661: ifne +209 -> 870
    //   664: new 784	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   667: dup
    //   668: aload_0
    //   669: getfield 151	abvc:currUrl	Ljava/lang/String;
    //   672: invokestatic 787	abuj:getMime	(Ljava/lang/String;)Ljava/lang/String;
    //   675: ldc_w 625
    //   678: aload_0
    //   679: getfield 499	abvc:pendingWebResourceStream	Ljava/io/InputStream;
    //   682: invokespecial 790	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   685: astore_1
    //   686: aload_0
    //   687: getfield 97	abvc:cu	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   690: iconst_1
    //   691: invokevirtual 329	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   694: aload_0
    //   695: getfield 643	abvc:bFP	Z
    //   698: ifeq +8 -> 706
    //   701: aload_0
    //   702: iconst_0
    //   703: putfield 643	abvc:bFP	Z
    //   706: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   709: ifeq +29 -> 738
    //   712: ldc 159
    //   714: iconst_2
    //   715: new 161	java/lang/StringBuilder
    //   718: dup
    //   719: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   722: ldc_w 792
    //   725: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: aload_1
    //   729: invokevirtual 494	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   732: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   738: aload_0
    //   739: aconst_null
    //   740: putfield 499	abvc:pendingWebResourceStream	Ljava/io/InputStream;
    //   743: aload_1
    //   744: areturn
    //   745: astore 5
    //   747: ldc 159
    //   749: iconst_2
    //   750: new 161	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   757: ldc 164
    //   759: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload_0
    //   763: getfield 136	abvc:id	Ljava/lang/String;
    //   766: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: ldc_w 794
    //   772: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: aload 5
    //   777: invokevirtual 575	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   780: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   786: invokestatic 633	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   789: goto -276 -> 513
    //   792: astore 5
    //   794: aload_1
    //   795: monitorexit
    //   796: aload 5
    //   798: athrow
    //   799: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   802: ifeq -287 -> 515
    //   805: ldc 159
    //   807: iconst_2
    //   808: new 161	java/lang/StringBuilder
    //   811: dup
    //   812: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   815: ldc 164
    //   817: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload_0
    //   821: getfield 136	abvc:id	Ljava/lang/String;
    //   824: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: ldc_w 796
    //   830: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: aload_0
    //   834: getfield 82	abvc:sessionState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   837: invokevirtual 494	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   840: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   846: goto -331 -> 515
    //   849: iconst_0
    //   850: istore 4
    //   852: goto -295 -> 557
    //   855: astore_1
    //   856: ldc 159
    //   858: iconst_2
    //   859: aload_1
    //   860: iconst_0
    //   861: anewarray 4	java/lang/Object
    //   864: invokestatic 799	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   867: goto -232 -> 635
    //   870: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   873: ifeq +12 -> 885
    //   876: ldc 159
    //   878: iconst_2
    //   879: ldc_w 801
    //   882: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   885: aconst_null
    //   886: astore_1
    //   887: goto -193 -> 694
    //   890: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   893: ifeq -886 -> 7
    //   896: ldc 159
    //   898: iconst_2
    //   899: ldc_w 803
    //   902: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   905: aconst_null
    //   906: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	907	0	this	abvc
    //   0	907	1	paramString	String
    //   433	143	2	l	long
    //   555	296	4	bool	boolean
    //   69	52	5	localObject1	Object
    //   745	31	5	localThrowable	Throwable
    //   792	5	5	localObject2	Object
    //   130	73	6	locala	abvc.a
    //   153	67	7	localWebResourceResponse	WebResourceResponse
    // Exception table:
    //   from	to	target	type
    //   452	503	745	java/lang/Throwable
    //   503	513	745	java/lang/Throwable
    //   452	503	792	finally
    //   503	513	792	finally
    //   513	515	792	finally
    //   747	789	792	finally
    //   794	796	792	finally
    //   609	635	855	java/lang/Throwable
  }
  
  public void start(boolean paramBoolean)
  {
    if (!this.sessionState.compareAndSet(0, 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") start error:sessionState=" + this.sessionState.get() + ".");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.id + ") now post task flow task.");
    }
    this.isWaitingForSessionThread.set(true);
    if (paramBoolean)
    {
      ThreadManager.postImmediately(new ApolloUrlInterceptor.2(this), null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask in AsyncThread start!");
    }
    abve localabve = this.jdField_a_of_type_Abve;
    long l = System.currentTimeMillis();
    localabve.OJ = l;
    cFB();
    cFC();
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask use:" + (System.currentTimeMillis() - l));
    }
    this.jdField_a_of_type_Abve.OK = System.currentTimeMillis();
  }
  
  public class a
  {
    private abuy.a jdField_a_of_type_Abuy$a;
    private abvf jdField_a_of_type_Abvf;
    private AtomicInteger aX;
    private abvb b;
    private volatile boolean bFQ;
    private AtomicBoolean cv;
    private HashMap<String, String> iB;
    private String mContentType;
    private long mCostTime;
    
    a(abuy.a parama)
    {
      this.jdField_a_of_type_Abuy$a = parama;
      this.cv = new AtomicBoolean(false);
      this.aX = new AtomicInteger(0);
      this.iB = new HashMap();
    }
    
    private void PD()
    {
      if ((this.jdField_a_of_type_Abuy$a == null) || (!this.jdField_a_of_type_Abuy$a.jQ())) {}
      long l1;
      long l2;
      do
      {
        return;
        l1 = System.currentTimeMillis();
        this.b = new abvb(this.jdField_a_of_type_Abuy$a.mUrl, true, this.jdField_a_of_type_Abuy$a, abuj.iL(abvc.a(abvc.this)));
        l2 = System.currentTimeMillis();
      } while (this.bFQ);
      int j = this.b.connect();
      this.aX.set(1);
      int i = j;
      Object localObject2;
      if (j == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Apollo_client_PreloadCGITask", 2, "task(" + this.jdField_a_of_type_Abuy$a.mUrl + ") connection connect cost = " + (System.currentTimeMillis() - l2) + " ms.");
        }
        l2 = System.currentTimeMillis();
        i = this.b.getResponseCode();
        if (QLog.isColorLevel()) {
          QLog.d("Apollo_client_PreloadCGITask", 2, "task(" + this.jdField_a_of_type_Abuy$a.mUrl + ") connection response cost = " + (System.currentTimeMillis() - l2) + " ms.");
        }
        l2 = System.currentTimeMillis();
        localObject2 = this.b.getResponseHeaderFields();
        if (QLog.isColorLevel()) {
          QLog.d("Apollo_client_PreloadCGITask", 2, "task(" + this.jdField_a_of_type_Abuy$a.mUrl + ") connection get header fields cost = " + (System.currentTimeMillis() - l2) + " ms.");
        }
        if (localObject2 != null) {
          if (((Map)localObject2).containsKey("Set-Cookie")) {
            ??? = "Set-Cookie";
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (!TextUtils.isEmpty((CharSequence)???))
          {
            ??? = (List)((Map)localObject2).get(???);
            abuj.setCookie(this.jdField_a_of_type_Abuy$a.mUrl, (List)???);
          }
          ??? = ((Map)localObject2).entrySet().iterator();
          for (;;)
          {
            if (((Iterator)???).hasNext())
            {
              Object localObject7 = (Map.Entry)((Iterator)???).next();
              localObject2 = (String)((Map.Entry)localObject7).getKey();
              localObject7 = (List)((Map.Entry)localObject7).getValue();
              if ((localObject7 != null) && (((List)localObject7).size() > 0))
              {
                this.iB.put(localObject2, ((List)localObject7).get(0));
                continue;
                if (!((Map)localObject2).containsKey("set-cookie")) {
                  break label1081;
                }
                ??? = "set-cookie";
                break;
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("Apollo_client_PreloadCGITask", 2, "task(" + this.jdField_a_of_type_Abuy$a.mUrl + ") mHeaderMap:" + this.iB);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Apollo_client_PreloadCGITask", 4, "task(" + this.jdField_a_of_type_Abuy$a.mUrl + ") handleFlow_Connection: respCode = " + i + ", cost " + (System.currentTimeMillis() - l1) + " ms.");
          }
          if (abvc.c(abvc.this))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Apollo_client_PreloadCGITask", 6, "task(" + this.jdField_a_of_type_Abuy$a.mUrl + ") handleFlow_Connection: destroy before server response.");
            }
            if (this.b != null)
            {
              this.b.disconnect();
              this.b = null;
            }
            this.aX.set(2);
            synchronized (this.aX)
            {
              this.aX.notifyAll();
              this.mCostTime = (System.currentTimeMillis() - l1);
              hb(this.mCostTime);
              return;
            }
          }
          if (200 != i)
          {
            if (this.b != null)
            {
              this.b.disconnect();
              this.b = null;
            }
            this.jdField_a_of_type_Abvf = null;
            if (QLog.isColorLevel()) {
              QLog.d("Apollo_client_PreloadCGITask", 4, "task(" + this.jdField_a_of_type_Abuy$a.mUrl + ") handleFlow_Connection: response code not 200, response code = " + i);
            }
            this.aX.set(2);
            synchronized (this.aX)
            {
              this.aX.notifyAll();
              this.mCostTime = (System.currentTimeMillis() - l1);
              hb(this.mCostTime);
              return;
            }
          }
          if (this.bFQ) {
            break;
          }
          ??? = this.b.a(this.cv, null);
          if (??? == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Apollo_client_PreloadCGITask", 2, "task(" + this.jdField_a_of_type_Abuy$a.mUrl + ") handleFlow_FirstLoad error:responseDataTuple is null!");
            }
            this.jdField_a_of_type_Abvf = null;
            this.aX.set(2);
            synchronized (this.aX)
            {
              this.aX.notifyAll();
              this.mCostTime = (System.currentTimeMillis() - l1);
              hb(this.mCostTime);
              return;
            }
          }
          if (this.bFQ) {
            break;
          }
          this.jdField_a_of_type_Abvf = new abvf(null, ((abvb.a)???).outputStream, ((abvb.a)???).responseStream);
          this.aX.set(2);
          synchronized (this.aX)
          {
            this.aX.notifyAll();
            this.mCostTime = (System.currentTimeMillis() - l1);
            hb(this.mCostTime);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Apollo_client_PreloadCGITask", 2, "task(" + this.jdField_a_of_type_Abuy$a.mUrl + ") mCostTime:" + this.mCostTime);
            return;
          }
        }
        label1081:
        ??? = null;
      }
    }
    
    private void Z(int paramInt, long paramLong)
    {
      try
      {
        if ((abvc.a(abvc.this) != null) && (this.jdField_a_of_type_Abuy$a != null))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("preloadSuccess", paramInt);
          localJSONObject.put("costTime", paramLong);
          abvc.a(abvc.this).bi.put(this.jdField_a_of_type_Abuy$a.mUrl, localJSONObject);
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("Apollo_client_PreloadCGITask", 1, localException, new Object[0]);
      }
    }
    
    private void hb(long paramLong)
    {
      try
      {
        if ((abvc.a(abvc.this) != null) && (this.jdField_a_of_type_Abuy$a != null))
        {
          JSONObject localJSONObject = abvc.a(abvc.this).bi.optJSONObject(this.jdField_a_of_type_Abuy$a.mUrl);
          if (localJSONObject != null)
          {
            localJSONObject.put("costTime", paramLong);
            abvc.a(abvc.this).bi.put(this.jdField_a_of_type_Abuy$a.mUrl, localJSONObject);
          }
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("Apollo_client_PreloadCGITask", 1, localException, new Object[0]);
      }
    }
    
    public void cFE()
    {
      ThreadManagerV2.excute(new ApolloUrlInterceptor.PreloadCGITask.1(this), 128, null, false);
    }
    
    public WebResourceResponse d(String paramString)
    {
      this.cv.set(true);
      if (this.aX.get() == 1) {}
      synchronized (this.aX)
      {
        try
        {
          if (this.aX.get() == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Apollo_client_PreloadCGITask", 2, "getCgiResource(" + paramString + ") now wait for pendingWebResourceStream!");
            }
            this.aX.wait(200L);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("Apollo_client_PreloadCGITask", 2, "getCgiResource" + localThrowable);
          }
        }
        if (this.jdField_a_of_type_Abvf != null)
        {
          if (TextUtils.isEmpty(this.mContentType)) {
            this.mContentType = abuj.getMime(paramString);
          }
          paramString = new WebResourceResponse(this.mContentType, "utf-8", this.jdField_a_of_type_Abvf);
          if (!this.iB.isEmpty()) {
            paramString.setResponseHeaders(this.iB);
          }
          Z(1, this.mCostTime);
          this.bFQ = true;
          this.jdField_a_of_type_Abvf = null;
          return paramString;
        }
      }
      this.bFQ = true;
      Z(0, this.mCostTime);
      return null;
    }
    
    public void onDestroy()
    {
      if (this.b != null)
      {
        this.b.disconnect();
        this.b = null;
      }
      if (this.jdField_a_of_type_Abvf != null) {
        this.jdField_a_of_type_Abvf = null;
      }
      QLog.d("Apollo_client_PreloadCGITask", 1, "PreloadCGITask onDestroy ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abvc
 * JD-Core Version:    0.7.0.1
 */