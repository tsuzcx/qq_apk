package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import Override;
import acmo;
import aeuz;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import anot;
import aoll;
import aolm;
import aolm.a;
import aolm.b;
import aomg;
import aomh;
import aomj;
import aona.d.a;
import aqiw;
import aqoh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kwstudio.office.base.IGlobal;
import com.tencent.kwstudio.office.base.ILog;
import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.preview.IHostInterface;
import com.tencent.kwstudio.office.preview.IHostInterface.IDownloadListener;
import com.tencent.kwstudio.office.preview.IHostInterface.IHttpListener;
import com.tencent.kwstudio.office.preview.IHostInterface.IPreferencesCallback;
import com.tencent.kwstudio.office.preview.IHostInterface.IWebClient;
import com.tencent.kwstudio.office.preview.TdsReaderView;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.ProtectedWebView;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import mqq.app.AppRuntime;
import mqq.app.TicketManagerImpl;
import mqq.os.MqqHandler;
import wgv;

public final class TdsReaderGlobal
  implements IHostInterface
{
  private static final aona.d.a jdField_a_of_type_Aona$d$a = new aona.d.a();
  private static volatile boolean ceV;
  private static volatile boolean ceW;
  private static final Map<String, String> kJ = new HashMap();
  private static volatile boolean sIsEnable;
  private volatile aolm.a jdField_a_of_type_Aolm$a;
  private volatile aolm c;
  private final BaseApplicationImpl e;
  private volatile Executor k;
  private volatile Executor o;
  
  static
  {
    aona.d.a locala = jdField_a_of_type_Aona$d$a;
    locala.dQi /= 2;
    locala = jdField_a_of_type_Aona$d$a;
    locala.dQj /= 2;
    locala = jdField_a_of_type_Aona$d$a;
    locala.dQk /= 2;
  }
  
  private TdsReaderGlobal(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.e = paramBaseApplicationImpl;
  }
  
  private void X(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 4)) {}
    boolean bool1;
    IHostInterface.IPreferencesCallback localIPreferencesCallback;
    do
    {
      return;
      String str = (String)paramArrayOfObject[0];
      bool1 = ((Boolean)paramArrayOfObject[1]).booleanValue();
      boolean bool2 = ((Boolean)paramArrayOfObject[2]).booleanValue();
      localIPreferencesCallback = (IHostInterface.IPreferencesCallback)paramArrayOfObject[3];
      SharedPreferences localSharedPreferences = this.e.getSharedPreferences("tencentdoc_olc_pref", 4);
      paramArrayOfObject = str;
      if (bool2) {
        paramArrayOfObject = aY(getUserId(), str);
      }
      bool1 = localSharedPreferences.getBoolean(paramArrayOfObject, bool1);
    } while (localIPreferencesCallback == null);
    localIPreferencesCallback.onResult(bool1);
  }
  
  private void Y(Object[] paramArrayOfObject)
  {
    int i = 0;
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 4)) {}
    String str1;
    boolean bool;
    String str2;
    do
    {
      return;
      str1 = (String)paramArrayOfObject[0];
      bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
      str2 = (String)paramArrayOfObject[2];
      localObject = (IHostInterface.IHttpListener)paramArrayOfObject[3];
      if (aqiw.isNetworkAvailable(this.e)) {
        break;
      }
    } while (localObject == null);
    ((IHostInterface.IHttpListener)localObject).onResponse(9004, null);
    return;
    paramArrayOfObject = new aoll();
    paramArrayOfObject.bZ = str1;
    if (bool) {
      i = 1;
    }
    paramArrayOfObject.mHttpMethod = i;
    paramArrayOfObject.dPo = 1;
    paramArrayOfObject.cMY = true;
    paramArrayOfObject.mExcuteTimeLimit = 5000L;
    paramArrayOfObject.f = new f(str1, (IHostInterface.IHttpListener)localObject, null);
    Object localObject = getUserId();
    String str3 = ((TicketManagerImpl)this.e.getRuntime().getManager(2)).getSkey((String)localObject);
    localObject = "uin=" + (String)localObject + ";skey=" + str3;
    if (bool) {
      paramArrayOfObject.X = str2.getBytes();
    }
    paramArrayOfObject.u = new HashMap();
    paramArrayOfObject.u.put("Cookie", localObject);
    Log.i("TdsReaderView_", "sendReq url:" + str1);
    c().a(paramArrayOfObject);
  }
  
  private void Z(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 4)) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return;
      str1 = (String)paramArrayOfObject[0];
      str2 = (String)paramArrayOfObject[1];
      str3 = (String)paramArrayOfObject[2];
      paramArrayOfObject = (IHostInterface.IDownloadListener)paramArrayOfObject[3];
      if (aqiw.isNetworkAvailable(this.e)) {
        break;
      }
    } while (paramArrayOfObject == null);
    paramArrayOfObject.onDownloadFinished(str1, false, 9004);
    return;
    aoll localaoll = new aoll();
    localaoll.bZ = str2;
    localaoll.atY = str3;
    localaoll.mHttpMethod = 0;
    localaoll.dPo = 1;
    localaoll.cMY = true;
    localaoll.b = jdField_a_of_type_Aona$d$a.c();
    localaoll.jdField_a_of_type_Aolm$a = a();
    localaoll.f = new e(str1, paramArrayOfObject, null);
    c().a(localaoll);
  }
  
  private aolm.a a()
  {
    try
    {
      if (this.jdField_a_of_type_Aolm$a == null) {
        this.jdField_a_of_type_Aolm$a = new a(null);
      }
      aolm.a locala = this.jdField_a_of_type_Aolm$a;
      return locala;
    }
    finally {}
  }
  
  private static String aY(String paramString1, String paramString2)
  {
    return paramString1 + paramString2;
  }
  
  private aolm c()
  {
    try
    {
      if (this.c == null)
      {
        localObject1 = new HttpCommunicator(new c(null), 128);
        ((HttpCommunicator)localObject1).start();
        this.c = new aomj((HttpCommunicator)localObject1, true);
      }
      Object localObject1 = this.c;
      return localObject1;
    }
    finally {}
  }
  
  public static void c(boolean paramBoolean, Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    if (paramBoolean) {
      try
      {
        for (;;)
        {
          synchronized (kJ)
          {
            kJ.putAll(paramMap);
          }
          synchronized (kJ)
          {
            kJ.clear();
            kJ.putAll(paramMap);
          }
        }
      }
      finally {}
    }
  }
  
  private Executor d()
  {
    try
    {
      if (this.k == null) {
        this.k = acmo.a(64);
      }
      Executor localExecutor = this.k;
      return localExecutor;
    }
    finally {}
  }
  
  private Executor e()
  {
    try
    {
      if (this.o == null) {
        this.o = acmo.a(128);
      }
      Executor localExecutor = this.o;
      return localExecutor;
    }
    finally {}
  }
  
  public static void init()
  {
    try
    {
      if (!ceV)
      {
        ceV = true;
        ThreadManager.getFileThreadHandler().post(new RunnableImpl(null, 1, new Object[0], null));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isEnable()
  {
    return (ceW) && (sIsEnable);
  }
  
  public static void setEnable(boolean paramBoolean)
  {
    sIsEnable = paramBoolean;
    synchronized (kJ)
    {
      if (kJ.size() > 0)
      {
        i = 1;
        if ((paramBoolean) && (!ceW) && (i != 0))
        {
          TdsReaderView.init(new TdsReaderGlobal(BaseApplicationImpl.getApplication()));
          ceW = true;
        }
        return;
      }
      int i = 0;
    }
  }
  
  public static void unInit()
  {
    try
    {
      ceV = false;
      sIsEnable = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void commitPreferences(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    SharedPreferences.Editor localEditor = this.e.getSharedPreferences("tencentdoc_olc_pref", 4).edit();
    String str = paramString;
    if (paramBoolean2) {
      str = aY(getUserId(), paramString);
    }
    localEditor.putBoolean(str, paramBoolean1).apply();
  }
  
  public IGlobal createGlobal()
  {
    return new b(this, null);
  }
  
  public ILog createLog()
  {
    return new d(null);
  }
  
  public Object createRecyclerView(Context paramContext)
  {
    return new RecyclerViewCompat(paramContext);
  }
  
  public Object createWebView(Context paramContext, IHostInterface.IWebClient paramIWebClient)
  {
    if (paramContext == null) {}
    for (Object localObject = this.e;; localObject = paramContext)
    {
      ProtectedWebView localProtectedWebView = new ProtectedWebView((Context)localObject);
      if (paramIWebClient != null)
      {
        localProtectedWebView.setWebChromeClient(new g(paramIWebClient, null));
        localObject = paramContext;
        if (paramContext == null) {
          localObject = this.e;
        }
        localProtectedWebView.setWebViewClient(new h((Context)localObject, paramIWebClient, null));
      }
      paramContext = localProtectedWebView.getX5WebViewExtension();
      if (paramContext != null)
      {
        paramContext.setHorizontalScrollBarEnabled(false);
        paramContext.setVerticalScrollBarEnabled(false);
        paramContext.setScrollBarFadingEnabled(false);
      }
      return localProtectedWebView;
    }
  }
  
  public void downloadResource(String paramString1, String paramString2, String paramString3, IHostInterface.IDownloadListener paramIDownloadListener)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("http"))) {
      e().execute(new RunnableImpl(this, 4, new Object[] { paramString1, paramString2, paramString3, paramIDownloadListener }, null));
    }
    do
    {
      return;
      Log.e("TdsReaderView_", "not supported url:" + paramString2);
    } while (paramIDownloadListener == null);
    paramIDownloadListener.onDownloadFinished(paramString1, false, -1);
  }
  
  public String getAppId()
  {
    return "1001";
  }
  
  public String getConfig(String paramString)
  {
    synchronized (kJ)
    {
      paramString = (String)kJ.get(paramString);
      return paramString;
    }
  }
  
  public String getUserId()
  {
    return Long.toString(this.e.getRuntime().getLongAccountUin());
  }
  
  public void queryPreferences(String paramString, boolean paramBoolean1, boolean paramBoolean2, IHostInterface.IPreferencesCallback paramIPreferencesCallback)
  {
    d().execute(new RunnableImpl(this, 2, new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramIPreferencesCallback }, null));
  }
  
  public void reportEvent(String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", paramString1, paramString1, paramInt, 0, "", "", paramString2, "");
      return;
    }
  }
  
  public void sendHttpRequest(String paramString1, boolean paramBoolean, String paramString2, IHostInterface.IHttpListener paramIHttpListener)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith("http"))) {
      e().execute(new RunnableImpl(this, 3, new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString2, paramIHttpListener }, null));
    }
    do
    {
      return;
      Log.e("TdsReaderView_", "invalid url:" + paramString1);
    } while (paramIHttpListener == null);
    paramIHttpListener.onResponse(-1, null);
  }
  
  static final class RunnableImpl
    implements Runnable
  {
    private final WeakReference<TdsReaderGlobal> gT;
    private final Object[] mArgs;
    private final int mJobType;
    
    private RunnableImpl(TdsReaderGlobal paramTdsReaderGlobal, int paramInt, Object... paramVarArgs)
    {
      if (paramTdsReaderGlobal == null) {}
      for (paramTdsReaderGlobal = null;; paramTdsReaderGlobal = new WeakReference(paramTdsReaderGlobal))
      {
        this.gT = paramTdsReaderGlobal;
        this.mJobType = paramInt;
        this.mArgs = paramVarArgs;
        return;
      }
    }
    
    public void run()
    {
      TdsReaderGlobal localTdsReaderGlobal;
      if (this.gT == null)
      {
        localTdsReaderGlobal = null;
        switch (this.mJobType)
        {
        }
      }
      do
      {
        do
        {
          do
          {
            return;
            localTdsReaderGlobal = (TdsReaderGlobal)this.gT.get();
            break;
            aeuz.initConfig();
            return;
          } while (localTdsReaderGlobal == null);
          TdsReaderGlobal.a(localTdsReaderGlobal, this.mArgs);
          return;
        } while (localTdsReaderGlobal == null);
        TdsReaderGlobal.b(localTdsReaderGlobal, this.mArgs);
        return;
      } while (localTdsReaderGlobal == null);
      TdsReaderGlobal.c(localTdsReaderGlobal, this.mArgs);
    }
  }
  
  static final class a
    implements aolm.a
  {
    public void a(aomg paramaomg, aomh paramaomh)
    {
      if ((paramaomg == null) || (paramaomh == null)) {}
      do
      {
        do
        {
          return;
        } while (!(paramaomg instanceof aoll));
        paramaomg = (aoll)paramaomg;
        paramaomg.apS += paramaomh.apW;
        paramaomh.apW = 0L;
        paramaomh = "bytes=" + paramaomg.apS + "-";
        paramaomg.u.put("Range", paramaomh);
        paramaomh = paramaomg.bZ;
      } while (!paramaomh.contains("range="));
      paramaomh = paramaomh.substring(0, paramaomh.lastIndexOf("range="));
      paramaomg.bZ = (paramaomh + "range=" + paramaomg.apS);
    }
  }
  
  static final class b
    implements IGlobal
  {
    private final TdsReaderGlobal a;
    
    private b(TdsReaderGlobal paramTdsReaderGlobal)
    {
      this.a = paramTdsReaderGlobal;
    }
    
    public Context getApplicationContext()
    {
      return TdsReaderGlobal.a(this.a);
    }
    
    public Executor getExecutor()
    {
      return TdsReaderGlobal.a(this.a);
    }
    
    public String getFileDir()
    {
      Context localContext = getApplicationContext();
      File localFile2 = localContext.getExternalFilesDir(null);
      File localFile1 = localFile2;
      if (localFile2 == null) {
        localFile1 = localContext.getFilesDir();
      }
      return localFile1.getAbsolutePath();
    }
    
    public InputStream getResourceAsStream(String paramString)
    {
      return null;
    }
  }
  
  static final class c
    implements aqoh
  {
    public void countFlow(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  }
  
  static final class d
    implements ILog
  {
    public void d(String paramString1, String paramString2)
    {
      QLog.d("TdsReaderView_" + paramString1, 2, paramString2);
    }
    
    public void d(String paramString1, String paramString2, Throwable paramThrowable)
    {
      QLog.d("TdsReaderView_" + paramString1, 2, paramString2, paramThrowable);
    }
    
    public void e(String paramString1, String paramString2)
    {
      QLog.e("TdsReaderView_" + paramString1, 1, paramString2);
    }
    
    public void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      QLog.e("TdsReaderView_" + paramString1, 1, paramString2, paramThrowable);
    }
    
    public int getLogLevel()
    {
      return 1;
    }
    
    public void i(String paramString1, String paramString2)
    {
      QLog.i("TdsReaderView_" + paramString1, 2, paramString2);
    }
    
    public void i(String paramString1, String paramString2, Throwable paramThrowable)
    {
      QLog.i("TdsReaderView_" + paramString1, 2, paramString2, paramThrowable);
    }
    
    public void v(String paramString1, String paramString2)
    {
      QLog.i("TdsReaderView_" + paramString1, 2, paramString2);
    }
    
    public void v(String paramString1, String paramString2, Throwable paramThrowable)
    {
      QLog.i("TdsReaderView_" + paramString1, 2, paramString2, paramThrowable);
    }
    
    public void w(String paramString1, String paramString2)
    {
      QLog.w("TdsReaderView_" + paramString1, 1, paramString2);
    }
    
    public void w(String paramString1, String paramString2, Throwable paramThrowable)
    {
      QLog.w("TdsReaderView_" + paramString1, 1, paramString2, paramThrowable);
    }
  }
  
  static final class e
    implements aolm.b
  {
    private final IHostInterface.IDownloadListener a;
    private final String name;
    
    private e(String paramString, IHostInterface.IDownloadListener paramIDownloadListener)
    {
      this.name = paramString;
      this.a = paramIDownloadListener;
    }
    
    public void onResp(aomh paramaomh)
    {
      int i = 0;
      if (paramaomh.mResult == 3) {}
      label74:
      label80:
      for (;;)
      {
        return;
        boolean bool;
        if (paramaomh.mResult == 0)
        {
          bool = true;
          if (!bool) {
            break label74;
          }
        }
        for (;;)
        {
          if (this.a == null) {
            break label80;
          }
          if (bool) {
            this.a.onDownloadProgress(this.name, paramaomh.apU, 1.0F);
          }
          this.a.onDownloadFinished(this.name, bool, i);
          return;
          bool = false;
          break;
          i = paramaomh.mErrCode;
        }
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
    {
      if (paramLong2 != 0L)
      {
        float f = (float)paramLong1 / (float)paramLong2;
        if (this.a != null) {
          this.a.onDownloadProgress(this.name, paramLong2, f);
        }
      }
    }
  }
  
  static final class f
    implements aolm.b
  {
    private final IHostInterface.IHttpListener a;
    private final String url;
    
    private f(String paramString, IHostInterface.IHttpListener paramIHttpListener)
    {
      this.url = paramString;
      this.a = paramIHttpListener;
    }
    
    public void onResp(aomh paramaomh)
    {
      if ((paramaomh.dPy == 200) || (paramaomh.dPy == 206)) {}
      for (String str = new String(paramaomh.mRespData);; str = null)
      {
        if (this.a != null) {
          this.a.onResponse(paramaomh.dPy, str);
        }
        Log.i("TdsReaderView_", "onResp url:" + this.url + ", status=" + paramaomh.dPy + ", rsp=" + str);
        return;
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  static final class g
    extends WebChromeClient
  {
    private final IHostInterface.IWebClient a;
    
    private g(IHostInterface.IWebClient paramIWebClient)
    {
      this.a = paramIWebClient;
    }
    
    public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      if ((this.a == null) || (!this.a.onConsoleMessage(paramConsoleMessage.message(), paramConsoleMessage.lineNumber(), paramConsoleMessage.sourceId()))) {
        return super.onConsoleMessage(paramConsoleMessage);
      }
      return true;
    }
    
    public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
    {
      if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {}
      do
      {
        return true;
        if ((this.a == null) || (!this.a.onJsPrompt(paramWebView, paramString1, paramString2, paramString3))) {
          return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
        }
      } while (paramJsPromptResult == null);
      paramJsPromptResult.cancel();
      return true;
    }
    
    @Override
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
      super.onProgressChanged(paramWebView, paramInt);
    }
  }
  
  static final class h
    extends WebViewClient
  {
    private final IHostInterface.IWebClient a;
    private final Context context;
    
    private h(Context paramContext, IHostInterface.IWebClient paramIWebClient)
    {
      this.context = paramContext;
      this.a = paramIWebClient;
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      if ((this.a == null) || (!this.a.onPageFinished(paramWebView, paramString))) {
        super.onPageFinished(paramWebView, paramString);
      }
    }
    
    @Override
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if ((this.a == null) || (!this.a.shouldOverrideUrlLoading(paramWebView, paramString)))
      {
        paramWebView = new Intent(this.context, QQBrowserDelegationActivity.class);
        paramWebView.putExtra("param_force_internal_browser", true);
        paramWebView.putExtra("url", paramString);
        wgv.c(this.context, paramWebView, paramString);
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsReaderGlobal
 * JD-Core Version:    0.7.0.1
 */