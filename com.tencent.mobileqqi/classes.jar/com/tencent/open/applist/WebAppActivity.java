package com.tencent.open.applist;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.util.WidgetUtil;
import com.tencent.open.adapter.AppBaseActivity;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appcommon.InterfaceRegisterUtils;
import com.tencent.open.appcommon.js.ImageUploadInterface;
import com.tencent.open.appcommon.js.OpenJsBridge;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.HttpResponseBean;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.img.ImageCache;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebSettings.RenderPriority;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import hle;
import hlf;
import hlg;
import hlh;
import hli;
import hlj;
import hlk;
import hll;
import hlm;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONException;
import org.json.JSONObject;

public class WebAppActivity
  extends AppBaseActivity
{
  public static Map a;
  protected static final int b = 2;
  protected static final int c = 3;
  protected static final String c = "WebAppActivity";
  protected static final int d = 4;
  protected static final String d = "http://mapp.qzone.qq.com/cgi-bin/mapp/mapp_info";
  protected static final int e = 5;
  protected static final int f = 6;
  protected static final int g = 7;
  protected static final int h = 8;
  protected static final int i = 0;
  protected static final int j = -100;
  protected static final int k = -70000002;
  protected static final int l = -70000003;
  protected static final int m = -70000004;
  public ProgressDialog a;
  protected final View.OnClickListener a;
  public ImageView a;
  public RelativeLayout a;
  protected ImageUploadInterface a;
  public OpenJsBridge a;
  protected H5ConfirmDialog.Dialogcallback a;
  protected H5ConfirmDialog a;
  public WebAppActivity.HttpGetAppInfoAsyncTask a;
  protected final DownloadListener a;
  protected final WebChromeClient a;
  public WebView a;
  protected final WebViewClient a;
  protected List a;
  protected boolean a;
  protected Handler b;
  public ImageView b;
  public ProgressBar b;
  protected boolean b;
  public View c;
  public ImageView c;
  public ImageView d;
  protected final String e = "qq.com";
  public String f;
  protected String g;
  public String h;
  public String i;
  protected String j;
  protected String k;
  protected int n;
  public int o;
  protected int p;
  protected int q;
  protected int r;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put("Q-UA", CommonDataAdapter.a().e());
  }
  
  public WebAppActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentOpenApplistWebAppActivity$HttpGetAppInfoAsyncTask = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentSmttSdkWebViewClient = new hle(this);
    this.jdField_a_of_type_ComTencentSmttSdkWebChromeClient = new hlf(this);
    this.jdField_a_of_type_ComTencentSmttSdkDownloadListener = new hlg(this);
    this.jdField_b_of_type_AndroidOsHandler = new hlh(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new hlk(this);
    this.jdField_a_of_type_ComTencentOpenApplistH5ConfirmDialog$Dialogcallback = new hll(this);
  }
  
  /* Error */
  public android.graphics.Bitmap a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: iconst_0
    //   6: istore_2
    //   7: aload_0
    //   8: getfield 144	com/tencent/open/applist/WebAppActivity:i	Ljava/lang/String;
    //   11: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: ldc 14
    //   21: new 152	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   28: ldc 155
    //   30: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: getfield 144	com/tencent/open/applist/WebAppActivity:i	Ljava/lang/String;
    //   37: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 167	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: new 169	org/apache/http/impl/client/DefaultHttpClient
    //   49: dup
    //   50: invokespecial 170	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   53: astore 4
    //   55: aload 4
    //   57: new 172	org/apache/http/client/methods/HttpGet
    //   60: dup
    //   61: aload_0
    //   62: getfield 144	com/tencent/open/applist/WebAppActivity:i	Ljava/lang/String;
    //   65: invokespecial 175	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   68: invokeinterface 181 2 0
    //   73: invokeinterface 187 1 0
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +221 -> 303
    //   85: aload 4
    //   87: invokeinterface 193 1 0
    //   92: astore_3
    //   93: aload_3
    //   94: astore 4
    //   96: new 195	java/io/ByteArrayOutputStream
    //   99: dup
    //   100: invokespecial 196	java/io/ByteArrayOutputStream:<init>	()V
    //   103: astore 5
    //   105: aload_3
    //   106: astore 4
    //   108: sipush 2048
    //   111: newarray byte
    //   113: astore 7
    //   115: aload_3
    //   116: astore 4
    //   118: aload_3
    //   119: aload 7
    //   121: invokevirtual 202	java/io/InputStream:read	([B)I
    //   124: istore_1
    //   125: iload_1
    //   126: iconst_m1
    //   127: if_icmpeq +80 -> 207
    //   130: aload_3
    //   131: astore 4
    //   133: aload 5
    //   135: aload 7
    //   137: iconst_0
    //   138: iload_1
    //   139: invokevirtual 206	java/io/ByteArrayOutputStream:write	([BII)V
    //   142: goto -27 -> 115
    //   145: astore 5
    //   147: aload_3
    //   148: astore 4
    //   150: aload 5
    //   152: invokevirtual 209	java/lang/Exception:printStackTrace	()V
    //   155: aload 6
    //   157: astore 4
    //   159: aload_3
    //   160: ifnull +11 -> 171
    //   163: aload_3
    //   164: invokevirtual 212	java/io/InputStream:close	()V
    //   167: aload 6
    //   169: astore 4
    //   171: new 152	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   178: ldc 214
    //   180: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: astore_3
    //   184: aload 4
    //   186: ifnull +5 -> 191
    //   189: iconst_1
    //   190: istore_2
    //   191: ldc 14
    //   193: aload_3
    //   194: iload_2
    //   195: invokevirtual 217	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   198: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 167	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload 4
    //   206: areturn
    //   207: aload_3
    //   208: astore 4
    //   210: aload 5
    //   212: invokevirtual 221	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   215: iconst_0
    //   216: aload 5
    //   218: invokevirtual 225	java/io/ByteArrayOutputStream:size	()I
    //   221: invokestatic 231	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   224: astore 5
    //   226: aload 5
    //   228: astore 4
    //   230: aload_3
    //   231: astore 5
    //   233: aload 4
    //   235: astore_3
    //   236: aload_3
    //   237: astore 4
    //   239: aload 5
    //   241: ifnull -70 -> 171
    //   244: aload 5
    //   246: invokevirtual 212	java/io/InputStream:close	()V
    //   249: aload_3
    //   250: astore 4
    //   252: goto -81 -> 171
    //   255: astore 4
    //   257: aload_3
    //   258: astore 4
    //   260: goto -89 -> 171
    //   263: astore_3
    //   264: aconst_null
    //   265: astore 4
    //   267: aload 4
    //   269: ifnull +8 -> 277
    //   272: aload 4
    //   274: invokevirtual 212	java/io/InputStream:close	()V
    //   277: aload_3
    //   278: athrow
    //   279: astore_3
    //   280: aload 6
    //   282: astore 4
    //   284: goto -113 -> 171
    //   287: astore 4
    //   289: goto -12 -> 277
    //   292: astore_3
    //   293: goto -26 -> 267
    //   296: astore 5
    //   298: aconst_null
    //   299: astore_3
    //   300: goto -153 -> 147
    //   303: aconst_null
    //   304: astore 5
    //   306: goto -70 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	WebAppActivity
    //   124	15	1	i1	int
    //   6	189	2	bool	boolean
    //   1	257	3	localObject1	Object
    //   263	15	3	localObject2	Object
    //   279	1	3	localIOException1	IOException
    //   292	1	3	localObject3	Object
    //   299	1	3	localObject4	Object
    //   53	198	4	localObject5	Object
    //   255	1	4	localIOException2	IOException
    //   258	25	4	localObject6	Object
    //   287	1	4	localIOException3	IOException
    //   103	31	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   145	72	5	localException1	Exception
    //   224	21	5	localObject7	Object
    //   296	1	5	localException2	Exception
    //   304	1	5	localObject8	Object
    //   3	278	6	localObject9	Object
    //   113	23	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   96	105	145	java/lang/Exception
    //   108	115	145	java/lang/Exception
    //   118	125	145	java/lang/Exception
    //   133	142	145	java/lang/Exception
    //   210	226	145	java/lang/Exception
    //   244	249	255	java/io/IOException
    //   55	80	263	finally
    //   85	93	263	finally
    //   163	167	279	java/io/IOException
    //   272	277	287	java/io/IOException
    //   96	105	292	finally
    //   108	115	292	finally
    //   118	125	292	finally
    //   133	142	292	finally
    //   150	155	292	finally
    //   210	226	292	finally
    //   55	80	296	java/lang/Exception
    //   85	93	296	java/lang/Exception
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", this.n);
    localBundle.putInt("showQuickBar", this.o);
    localBundle.putInt("showDialog", this.p);
    localBundle.putInt("screenOrientation", this.q);
    localBundle.putInt("fullScreen", this.r);
    localBundle.putString("url", this.f);
    localBundle.putString("appName", this.h);
    localBundle.putString("appIconUrl", this.i);
    localBundle.putString("appId", this.g);
    localBundle.putString("args", this.j);
    localBundle.putBoolean("fromShortcut", true);
    return localBundle;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = Common.b() + ImageCache.b + "app" + File.separator + FileUtils.a(paramString);
    if (new File(paramString).exists())
    {
      LogUtility.c("WebAppActivity", "imageIsExist = " + paramString);
      return paramString;
    }
    LogUtility.c("WebAppActivity", "imageIsExist != " + paramString);
    return null;
  }
  
  protected HashMap a(String paramString, Bundle paramBundle)
  {
    LogUtility.c("WebAppActivity", "enter getCookie ");
    HashMap localHashMap = new HashMap();
    int i1 = 0;
    int i2 = 0;
    long l1 = SystemClock.elapsedRealtime();
    int i4 = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_HttpRetryCount");
    if (i4 == 0) {
      i4 = 3;
    }
    for (;;)
    {
      int i3 = 0;
      int i5 = i3 + 1;
      Object localObject1 = new BasicHttpContext();
      Object localObject2 = new BasicCookieStore();
      ((HttpContext)localObject1).setAttribute("http.cookie-store", localObject2);
      try
      {
        localObject1 = HttpBaseUtil.a(paramString, "GET", paramBundle, (HttpContext)localObject1);
        localObject3 = ((HttpBaseUtil.HttpResponseBean)localObject1).jdField_a_of_type_OrgApacheHttpHttpResponse;
        if (((HttpResponse)localObject3).getStatusLine().getStatusCode() != 200) {
          break label381;
        }
        localObject2 = ((CookieStore)localObject2).getCookies();
        if (((List)localObject2).isEmpty()) {
          break label320;
        }
        i3 = ((List)localObject2).size();
        while (i3 > 0)
        {
          LogUtility.c("WebAppActivity", ((Cookie)((List)localObject2).get(i3 - 1)).toString());
          i3 -= 1;
        }
        a((List)localObject2);
      }
      catch (ConnectTimeoutException localConnectTimeoutException)
      {
        try
        {
          Object localObject3;
          i3 = ((JSONObject)localObject3).getInt("ret");
          i2 = ((HttpBaseUtil.HttpResponseBean)localObject1).jdField_a_of_type_Int;
          LogUtility.c("WebAppActivity", "resutl >>> " + (String)localObject2);
          for (;;)
          {
            ReportManager.a().a(paramString, l1, i2, i1, i3, CommonDataAdapter.a().a(), "1000002", null);
            return localHashMap;
            LogUtility.c("WebAppActivity", "cookies.isEmpty() ");
            break;
            localConnectTimeoutException = localConnectTimeoutException;
            localConnectTimeoutException.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            i1 = -7;
            if (i5 < i4) {
              break label636;
            }
            i3 = i1;
            i1 = 0;
            i2 = 0;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            i3 = -4;
          }
        }
        LogUtility.c("WebAppActivity", "response code >>> " + localJSONException.getStatusLine().getStatusCode());
        localHashMap.put("ResultType", Integer.valueOf(0));
        localJSONException.getStatusLine().getStatusCode();
        return localHashMap;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        for (;;)
        {
          localSocketTimeoutException.printStackTrace();
          localHashMap.put("ResultType", Integer.valueOf(0));
          localHashMap.put("ResultValue", localSocketTimeoutException);
          i1 = -8;
        }
      }
      catch (HttpBaseUtil.NetworkUnavailableException paramString)
      {
        paramString.printStackTrace();
        localHashMap.put("ResultType", Integer.valueOf(0));
        localHashMap.put("ResultValue", paramString);
        return localHashMap;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          localHashMap.put("ResultType", Integer.valueOf(0));
          localHashMap.put("ResultValue", paramBundle);
          i3 = -4;
          i1 = 0;
          i2 = 0;
        }
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          localHashMap.put("ResultType", Integer.valueOf(0));
          localHashMap.put("ResultValue", paramBundle);
          i3 = HttpCgiAsyncTask.a(paramBundle);
          i1 = 0;
          i2 = 0;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          localHashMap.put("ResultType", Integer.valueOf(0));
          localHashMap.put("ResultValue", paramBundle);
          i3 = -6;
          i1 = 0;
          i2 = 0;
        }
        i6 = 0;
        i3 = i5;
        i2 = i1;
        i1 = i6;
      }
      localObject2 = HttpBaseUtil.a((HttpResponse)localObject3);
      if (localObject2 != null)
      {
        i1 = ((String)localObject2).length();
        localObject3 = HttpBaseUtil.a((String)localObject2);
        localHashMap.put("ResultType", Integer.valueOf(1));
        localHashMap.put("ResultValue", localObject3);
      }
      for (;;)
      {
        label320:
        label381:
        int i6;
        label636:
        break;
        i3 = i2;
      }
    }
  }
  
  protected void a(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null)
    {
      LogUtility.e("WebAppActivity", "getParams extras is null");
      finish();
      return;
    }
    paramIntent.putBoolean("IsBack", true);
    this.f = paramIntent.getString("url");
    this.n = paramIntent.getInt("type", 1);
    this.o = paramIntent.getInt("showQuickBar", 1);
    this.p = paramIntent.getInt("showDialog", 0);
    this.q = paramIntent.getInt("screenOrientation", 0);
    this.r = paramIntent.getInt("fullScreen", 0);
    if (this.n == 1)
    {
      this.h = paramIntent.getString("appName");
      this.i = paramIntent.getString("appIconUrl");
      this.g = paramIntent.getString("appId");
      this.j = paramIntent.getString("args");
      this.jdField_a_of_type_Boolean = paramIntent.getBoolean("fromShortcut", false);
      return;
    }
    this.h = paramIntent.getString("appName");
    this.i = paramIntent.getString("appIconUrl");
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", new Intent("com.tencent.open.startwebapp"));
    sendBroadcast(localIntent);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    new Handler().post(new hlm(this, paramString1, paramString2, paramBoolean));
  }
  
  protected void a(List paramList)
  {
    try
    {
      CookieSyncManager.createInstance(this);
      CookieManager localCookieManager = CookieManager.getInstance();
      localCookieManager.setAcceptCookie(true);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (Cookie)paramList.next();
        localObject = ((Cookie)localObject).getName() + "=" + ((Cookie)localObject).getValue() + "; domain=" + ((Cookie)localObject).getDomain();
        localCookieManager.setCookie("qq.com", (String)localObject);
        LogUtility.c("WebAppActivity", "setCookie >>> " + (String)localObject);
      }
      CookieSyncManager.getInstance().sync();
    }
    finally {}
    LogUtility.c("WebAppActivity", "synCookies >>> end");
  }
  
  protected boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!this.jdField_a_of_type_Boolean);
      if (this.o != paramJSONObject.optInt("quickbar"))
      {
        LogUtility.c("WebAppActivity", "replaceShortcut >>> " + this.o + " | " + paramJSONObject.optInt("quickbar"));
        return true;
      }
      if (this.p != paramJSONObject.optInt("isGenIcon"))
      {
        LogUtility.c("WebAppActivity", "replaceShortcut >>> " + this.p + " | " + paramJSONObject.optInt("isGenIcon"));
        return true;
      }
      if (this.q != paramJSONObject.optInt("orientation"))
      {
        LogUtility.c("WebAppActivity", "replaceShortcut >>> " + this.q + " | " + paramJSONObject.optInt("orientation"));
        return true;
      }
    } while (this.h.equals(paramJSONObject.optString("name")));
    LogUtility.c("WebAppActivity", "replaceShortcut >>> " + this.h + " | " + paramJSONObject.optString("name"));
    return true;
  }
  
  public boolean c()
  {
    if (Build.VERSION.SDK_INT < 8) {}
    for (Object localObject = "content://com.android.launcher.settings/favorites?notify=true";; localObject = "content://com.android.launcher2.settings/favorites?notify=true")
    {
      localObject = Uri.parse((String)localObject);
      localObject = getContentResolver().query((Uri)localObject, null, "title=?", new String[] { this.h }, null);
      if (localObject == null) {
        break;
      }
      ((Cursor)localObject).close();
      return true;
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView != null) && (!this.jdField_a_of_type_ComTencentSmttSdkWebView.hasFocus()))
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.requestFocus();
      this.jdField_a_of_type_ComTencentSmttSdkWebView.requestFocusFromTouch();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @TargetApi(8)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    LogUtility.c("WebAppActivity", "onCreate");
    d();
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      a(paramBundle);
      j();
      k();
      l();
      if (this.n != 0) {
        break label286;
      }
      if (this.f.indexOf("?") != -1) {
        break label214;
      }
      this.f += "?";
    }
    for (;;)
    {
      LogUtility.b("Jie", "webApp sid=" + CommonDataAdapter.a().a());
      try
      {
        this.f = (this.f + "sid=" + URLEncoder.encode(CommonDataAdapter.a().a(), "UTF-8") + "&uin=" + CommonDataAdapter.a().a());
        if (Build.VERSION.SDK_INT > 7)
        {
          this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.f, jdField_a_of_type_JavaUtilMap);
          return true;
          LogUtility.c("WebAppActivity", "onCreate 0");
          return true;
          label214:
          if (this.f.endsWith("&")) {
            continue;
          }
          this.f += "&";
        }
      }
      catch (UnsupportedEncodingException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.f);
        return true;
      }
    }
    label286:
    this.jdField_a_of_type_AndroidAppProgressDialog.setMessage(getResources().getString(2131559989));
    this.jdField_a_of_type_AndroidAppProgressDialog.show();
    paramBundle = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
    if (TextUtils.isEmpty(CommonDataAdapter.a().a())) {}
    for (paramBundle.what = 3;; paramBundle.what = 2)
    {
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramBundle);
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge != null)
    {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge.a(null);
      this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge = null;
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.setDownloadListener(null);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.destroy();
      this.jdField_a_of_type_ComTencentSmttSdkWebView = null;
    }
    super.doOnDestroy();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      try
      {
        if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)
        {
          if (this.jdField_a_of_type_ComTencentSmttSdkWebView.canGoBack())
          {
            this.jdField_a_of_type_ComTencentSmttSdkWebView.goBack();
            return false;
          }
          if (this.p != 1) {
            break label130;
          }
          if (this.jdField_a_of_type_ComTencentOpenApplistH5ConfirmDialog == null) {
            break label91;
          }
          if (!this.jdField_a_of_type_ComTencentOpenApplistH5ConfirmDialog.isShowing()) {
            break label82;
          }
          this.jdField_a_of_type_ComTencentOpenApplistH5ConfirmDialog.dismiss();
          return false;
        }
      }
      catch (Exception localException)
      {
        LogUtility.c("WebAppActivity", "onKeyDown", localException);
      }
    }
    for (;;)
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
      label82:
      this.jdField_a_of_type_ComTencentOpenApplistH5ConfirmDialog.show();
      return false;
      label91:
      this.jdField_a_of_type_ComTencentOpenApplistH5ConfirmDialog = new H5ConfirmDialog(this);
      this.jdField_a_of_type_ComTencentOpenApplistH5ConfirmDialog.setDialogCallback(this.jdField_a_of_type_ComTencentOpenApplistH5ConfirmDialog$Dialogcallback);
      this.jdField_a_of_type_ComTencentOpenApplistH5ConfirmDialog.show();
      this.jdField_a_of_type_ComTencentOpenApplistH5ConfirmDialog.show();
      return false;
      label130:
      finish();
    }
  }
  
  protected void doOnStop()
  {
    if (Build.VERSION.SDK_INT < 16) {
      WebView.disablePlatformNotifications();
    }
    super.doOnStop();
  }
  
  public void i()
  {
    a(new hli(this), 2000L);
  }
  
  public void j()
  {
    if (this.q == 1) {
      setRequestedOrientation(0);
    }
    for (;;)
    {
      if (this.r == 1) {
        getWindow().setFlags(1024, 1024);
      }
      return;
      if (this.q == 2) {
        setRequestedOrientation(1);
      }
    }
  }
  
  protected void k()
  {
    setContentView(2130903330);
    x();
    this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232104));
    if (this.o == 0)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131232106);
      if (this.o != 0) {
        break label181;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      Object localObject = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject == null) || (((NetworkInfo)localObject).getState() == NetworkInfo.State.DISCONNECTED) || (((NetworkInfo)localObject).getState() == NetworkInfo.State.DISCONNECTING))
      {
        localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
        ((Message)localObject).what = 8;
        this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131232105));
      this.jdField_b_of_type_AndroidWidgetProgressBar.setProgressDrawable(WidgetUtil.a(getResources().getDrawable(2130838195), false, null));
      break;
      label181:
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231188));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231189));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231192));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.d = ((ImageView)findViewById(2131230740));
      this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(8)
  protected void l()
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = ((WebView)findViewById(2131230905));
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(this.jdField_a_of_type_ComTencentSmttSdkWebViewClient);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebChromeClient(this.jdField_a_of_type_ComTencentSmttSdkWebChromeClient);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setDownloadListener(this.jdField_a_of_type_ComTencentSmttSdkDownloadListener);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setOnLongClickListener(new hlj(this));
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setNeedInitialFocus(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setBuiltInZoomControls(false);
    localWebSettings.setPluginsEnabled(true);
    if (Build.VERSION.SDK_INT > 7)
    {
      localWebSettings.setPluginState(WebSettings.PluginState.ON);
      localWebSettings.setDatabaseEnabled(true);
      localWebSettings.setDatabasePath(getApplicationContext().getDir("storage", 2).getPath());
      localWebSettings.setDomStorageEnabled(true);
      localWebSettings.setAppCacheEnabled(true);
      localWebSettings.setAppCachePath(getApplicationContext().getDir("cache", 2).getPath());
    }
    if (Build.VERSION.SDK_INT < 16) {
      WebView.enablePlatformNotifications();
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("accessibility");
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("accessibilityTraversal");
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView.requestFocus();
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge = new OpenJsBridge();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentOpenAppcommonJsImageUploadInterface = new ImageUploadInterface(this, this.jdField_a_of_type_ComTencentSmttSdkWebView);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentOpenAppcommonJsImageUploadInterface);
    InterfaceRegisterUtils.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentSmttSdkWebView, "file://", this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge);
    this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge.a(this.jdField_a_of_type_ComTencentOpenAppcommonJsImageUploadInterface, this.jdField_a_of_type_ComTencentOpenAppcommonJsImageUploadInterface.getInterfaceName());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentOpenAppcommonJsImageUploadInterface.handlePicUploadOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.applist.WebAppActivity
 * JD-Core Version:    0.7.0.1
 */