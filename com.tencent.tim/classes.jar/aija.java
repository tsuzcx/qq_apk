import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.vip.manager.MonitorManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aija
  extends WebViewPlugin
{
  public static CopyOnWriteArrayList<WeakReference<aija>> ah;
  public static volatile BroadcastReceiver bp;
  public static AtomicBoolean di = new AtomicBoolean(false);
  WeakReference<aija> hi = null;
  String mUniqueMark = "";
  
  public aija()
  {
    this.mPluginNameSpace = "event";
  }
  
  public static void a(String paramString1, JSONObject paramJSONObject, ArrayList<String> paramArrayList, String paramString2)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    localIntent.putExtra("event", paramString1);
    if (paramJSONObject != null) {
      localIntent.putExtra("data", paramJSONObject.toString());
    }
    localIntent.putStringArrayListExtra("domains", paramArrayList);
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("url", paramString2);
      label61:
      localIntent.putExtra("source", paramString1.toString());
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      break label61;
    }
  }
  
  private static void dsG()
  {
    bp = new aijb();
    if (QLog.isColorLevel()) {
      QLog.d("EventApiPlugin", 2, "init dispatch Event Receiver!");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(bp, localIntentFilter, "com.tencent.tim.msg.permission.pushnotify", null);
    if (ah == null) {
      ah = new CopyOnWriteArrayList();
    }
  }
  
  public static void dsH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EventApiPlugin", 2, "unRegisterEventReceiver");
    }
    if (ah != null) {
      ah.clear();
    }
    if ((bp != null) && (di.compareAndSet(true, false)))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(bp);
      bp = null;
    }
  }
  
  void Ls(String paramString)
  {
    if ((!Build.MANUFACTURER.contains("Xiaomi")) || (TextUtils.isEmpty(paramString))) {}
    label190:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.e("EventApiPlugin", 2, "handleMiUIInstallIntercepterEvent,finger print:" + Build.FINGERPRINT + ",config:" + paramString);
          }
          try
          {
            paramString = a(new JSONObject(paramString));
            if ((paramString == null) || (this.mRuntime == null)) {
              break label190;
            }
            Activity localActivity = this.mRuntime.getActivity();
            if (localActivity != null)
            {
              localActivity.startActivity(paramString);
              return;
            }
          }
          catch (JSONException paramString)
          {
            if (QLog.isColorLevel())
            {
              QLog.d("EventApiPlugin", 2, "error:" + paramString.toString());
              return;
              if (QLog.isColorLevel())
              {
                QLog.d("EventApiPlugin", 2, "activity is null.");
                return;
              }
            }
          }
          catch (Exception paramString) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("EventApiPlugin", 2, "error:" + paramString.toString());
      return;
    } while (!QLog.isColorLevel());
    QLog.d("EventApiPlugin", 2, "intent or runtime is null");
  }
  
  ComponentName a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("/");
      if ((paramString != null) && (paramString.length == 2)) {
        return new ComponentName(paramString[0], paramString[1]);
      }
    }
    return null;
  }
  
  Intent a(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    Intent localIntent;
    Object localObject;
    do
    {
      do
      {
        return paramJSONObject;
        localIntent = new Intent();
        localObject = paramJSONObject.optString("action", "");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localIntent.setAction((String)localObject);
        }
        localObject = paramJSONObject.optString("category", "");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localIntent.addCategory((String)localObject);
        }
        localObject = paramJSONObject.optString("componentName", "");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localIntent.setComponent(a((String)localObject));
        }
        localObject = paramJSONObject.getJSONObject("intentExtras");
        paramJSONObject = localIntent;
      } while (localObject == null);
      localObject = c((JSONObject)localObject);
      paramJSONObject = localIntent;
    } while (localObject == null);
    localIntent.putExtras((Bundle)localObject);
    return localIntent;
  }
  
  Bundle c(JSONObject paramJSONObject)
    throws JSONException
  {
    Iterator localIterator = paramJSONObject.keys();
    if (localIterator != null)
    {
      Bundle localBundle = new Bundle();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str)) {
          localBundle.putCharSequence(str, paramJSONObject.getString(str));
        }
      }
      return localBundle;
    }
    return null;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934606L)
    {
      paramString = new JSONObject();
      if (paramMap != null) {}
      try
      {
        paramString.put("x", (Integer)paramMap.get("X"));
        paramString.put("y", (Integer)paramMap.get("Y"));
        dispatchJsEvent("qbrowserTitleBarClick", paramString, null);
        return true;
      }
      catch (ClassCastException localClassCastException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EventApiPlugin", 2, "ClassCastException, " + paramMap.get("X") + ", " + paramMap.get("Y"));
          }
          localClassCastException.printStackTrace();
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EventApiPlugin", 2, "JSONException, " + paramMap.get("X") + ", " + paramMap.get("Y"));
          }
          localJSONException.printStackTrace();
        }
      }
    }
    if (paramLong == 8589934607L)
    {
      dispatchJsEvent("qbrowserOptionsButtonClick", null, null);
      return true;
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("event".equals(paramString2)) {
      if ((!"dispatchEvent".equals(paramString3)) || (paramVarArgs.length != 1) || (this.hi == null)) {}
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = this.mRuntime.getWebView();
        if (localObject1 == null) {
          return true;
        }
        paramString3 = new JSONObject(paramVarArgs[0]);
        paramString1 = paramString3.optString("event");
        if (TextUtils.isEmpty(paramString1))
        {
          if (!QLog.isColorLevel()) {
            break label696;
          }
          QLog.w("EventApiPlugin", 2, "param event is requested");
          break label696;
        }
        paramString2 = paramString3.optJSONObject("data");
        if (paramString2 == null) {
          break label698;
        }
        paramJsBridgeListener = paramString2.toString();
        if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (paramJsBridgeListener.length() >= 460800L))
        {
          QLog.e("EventApiPlugin", 1, "param data is over size! " + paramJsBridgeListener.length());
          return true;
        }
        paramVarArgs = paramString3.optJSONObject("options");
        int k = 1;
        boolean bool1 = true;
        paramString3 = new ArrayList();
        paramJsBridgeListener = new ArrayList();
        localObject1 = ((WebView)localObject1).getUrl();
        Object localObject2;
        if (paramVarArgs != null)
        {
          boolean bool2 = paramVarArgs.optBoolean("echo", true);
          boolean bool3 = paramVarArgs.optBoolean("broadcast", true);
          localObject2 = paramVarArgs.optJSONArray("domains");
          int j;
          if (localObject2 != null)
          {
            i = 0;
            j = ((JSONArray)localObject2).length();
            if (i < j)
            {
              String str = ((JSONArray)localObject2).optString(i);
              if (TextUtils.isEmpty(str)) {
                break label704;
              }
              paramString3.add(str);
              break label704;
            }
          }
          paramVarArgs = paramVarArgs.optJSONArray("platos");
          bool1 = bool3;
          k = bool2;
          if (paramVarArgs != null)
          {
            i = 0;
            j = paramVarArgs.length();
            bool1 = bool3;
            k = bool2;
            if (i < j)
            {
              localObject2 = paramVarArgs.optString(i);
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label713;
              }
              paramJsBridgeListener.add(localObject2);
              break label713;
            }
          }
        }
        paramVarArgs = new JSONObject();
        paramVarArgs.put("url", localObject1);
        if ((paramString3.size() == 0) && (localObject1 != null))
        {
          localObject1 = Uri.parse((String)localObject1);
          if (((Uri)localObject1).isHierarchical()) {
            paramString3.add(((Uri)localObject1).getHost());
          }
        }
        localObject1 = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        ((Intent)localObject1).putExtra("broadcast", bool1);
        ((Intent)localObject1).putExtra("unique", wU());
        ((Intent)localObject1).putExtra("event", paramString1);
        if (paramString2 != null) {
          ((Intent)localObject1).putExtra("data", paramString2.toString());
        }
        ((Intent)localObject1).putStringArrayListExtra("domains", paramString3);
        ((Intent)localObject1).putStringArrayListExtra("platos", paramJsBridgeListener);
        ((Intent)localObject1).putExtra("source", paramVarArgs.toString());
        if (QLog.isColorLevel())
        {
          localObject2 = this.hi.toString();
          if (paramString2 != null)
          {
            paramJsBridgeListener = paramString2.toString();
            QLog.d("EventApiPlugin", 2, String.format("send event broadcast, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", new Object[] { localObject2, paramString1, paramJsBridgeListener, TextUtils.join(",", paramString3), paramVarArgs }));
          }
        }
        else
        {
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject1, "com.tencent.tim.msg.permission.pushnotify");
          if (k != 0) {
            dispatchJsEvent(paramString1, paramString2, paramVarArgs);
          }
          if (!"cancelPayDialog".equals(paramString1)) {
            break;
          }
          MonitorManager.a().j(1, 6, "取消支付", "");
          break;
        }
        paramJsBridgeListener = "NULL";
        continue;
        if (!"miuiInstallInterceptor".equals(paramString3)) {
          break;
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      if ((paramVarArgs.length < 1) && (QLog.isColorLevel()))
      {
        QLog.e("EventApiPlugin", 2, "no arguments.");
        return true;
      }
      Ls(paramVarArgs[0]);
      return true;
      return false;
      label696:
      return true;
      label698:
      paramJsBridgeListener = "";
      continue;
      label704:
      i += 1;
      continue;
      label713:
      i += 1;
    }
    return true;
  }
  
  public void onActivityReady()
  {
    if (di.compareAndSet(false, true)) {}
    try
    {
      dsG();
      if ((bp != null) && (ah != null))
      {
        this.hi = new WeakReference(this);
        ah.add(this.hi);
        if (QLog.isColorLevel()) {
          QLog.d("EventApiPlugin", 2, "put current EventApiPlugin into sDispatchEventPlugins: " + this.hi.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EventApiPlugin", 2, "error:" + localException.toString());
        }
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.hi != null) && (ah != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EventApiPlugin", 2, "remove current EventApiPlugin from sDispatchEventPlugins: " + this.hi.toString());
      }
      ah.remove(this.hi);
      this.hi = null;
    }
  }
  
  /* Error */
  public void onReceive(android.content.Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_2
    //   6: ifnull +20 -> 26
    //   9: aload_0
    //   10: getfield 35	aija:hi	Ljava/lang/ref/WeakReference;
    //   13: ifnull +13 -> 26
    //   16: aload_0
    //   17: getfield 35	aija:hi	Ljava/lang/ref/WeakReference;
    //   20: invokevirtual 489	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   23: ifnonnull +4 -> 27
    //   26: return
    //   27: aload_2
    //   28: ldc_w 388
    //   31: iconst_1
    //   32: invokevirtual 492	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   35: ifeq -9 -> 26
    //   38: aload_2
    //   39: ldc_w 423
    //   42: invokevirtual 495	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +14 -> 61
    //   50: aload_1
    //   51: aload_0
    //   52: invokevirtual 426	aija:wU	()Ljava/lang/String;
    //   55: invokevirtual 343	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne -32 -> 26
    //   61: aload_2
    //   62: ldc 37
    //   64: invokevirtual 495	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   67: astore 6
    //   69: aload 6
    //   71: invokestatic 168	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   74: ifne -48 -> 26
    //   77: aload_2
    //   78: ldc 57
    //   80: invokevirtual 495	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +275 -> 360
    //   88: new 59	org/json/JSONObject
    //   91: dup
    //   92: aload_1
    //   93: invokespecial 187	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   96: astore_1
    //   97: aload_2
    //   98: ldc 65
    //   100: invokevirtual 499	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   103: astore 7
    //   105: aload 7
    //   107: ifnull -81 -> 26
    //   110: aload_2
    //   111: ldc 78
    //   113: invokevirtual 495	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 8
    //   118: aload 5
    //   120: astore_2
    //   121: aload 8
    //   123: ifnull +13 -> 136
    //   126: new 59	org/json/JSONObject
    //   129: dup
    //   130: aload 8
    //   132: invokespecial 187	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   135: astore_2
    //   136: aload_0
    //   137: getfield 194	aija:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   140: invokevirtual 349	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   143: astore 5
    //   145: aload 5
    //   147: ifnull -121 -> 26
    //   150: aload 5
    //   152: invokevirtual 380	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   155: astore 8
    //   157: aload 8
    //   159: ifnull -133 -> 26
    //   162: aload 8
    //   164: invokestatic 412	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   167: invokevirtual 418	android/net/Uri:getHost	()Ljava/lang/String;
    //   170: astore 9
    //   172: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +68 -> 243
    //   178: aload_0
    //   179: getfield 35	aija:hi	Ljava/lang/ref/WeakReference;
    //   182: invokevirtual 429	java/lang/Object:toString	()Ljava/lang/String;
    //   185: astore 10
    //   187: aload_1
    //   188: ifnull +114 -> 302
    //   191: aload_1
    //   192: invokevirtual 63	org/json/JSONObject:toString	()Ljava/lang/String;
    //   195: astore 5
    //   197: ldc 108
    //   199: iconst_2
    //   200: ldc_w 501
    //   203: iconst_5
    //   204: anewarray 428	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: aload 10
    //   211: aastore
    //   212: dup
    //   213: iconst_1
    //   214: aload 6
    //   216: aastore
    //   217: dup
    //   218: iconst_2
    //   219: aload 5
    //   221: aastore
    //   222: dup
    //   223: iconst_3
    //   224: ldc_w 433
    //   227: aload 7
    //   229: invokestatic 437	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   232: aastore
    //   233: dup
    //   234: iconst_4
    //   235: aload_2
    //   236: aastore
    //   237: invokestatic 441	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   240: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload 6
    //   245: ldc_w 503
    //   248: invokevirtual 343	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifne +14 -> 265
    //   254: aload 6
    //   256: ldc_w 505
    //   259: invokevirtual 343	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   262: ifeq +48 -> 310
    //   265: invokestatic 510	jml:a	()Ljml;
    //   268: aload 8
    //   270: ldc_w 512
    //   273: invokevirtual 516	jml:z	(Ljava/lang/String;Ljava/lang/String;)Z
    //   276: ifne +17 -> 293
    //   279: invokestatic 510	jml:a	()Ljml;
    //   282: aload 8
    //   284: ldc_w 518
    //   287: invokevirtual 516	jml:z	(Ljava/lang/String;Ljava/lang/String;)Z
    //   290: ifeq +20 -> 310
    //   293: aload_0
    //   294: aload 6
    //   296: aload_1
    //   297: aload_2
    //   298: invokevirtual 317	aija:dispatchJsEvent	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   301: return
    //   302: ldc_w 456
    //   305: astore 5
    //   307: goto -110 -> 197
    //   310: aload 7
    //   312: invokevirtual 406	java/util/ArrayList:size	()I
    //   315: istore 4
    //   317: iload_3
    //   318: iload 4
    //   320: if_icmpge -294 -> 26
    //   323: aload 7
    //   325: iload_3
    //   326: invokevirtual 521	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   329: checkcast 159	java/lang/String
    //   332: aload 9
    //   334: invokestatic 524	jml:A	(Ljava/lang/String;Ljava/lang/String;)Z
    //   337: ifeq +12 -> 349
    //   340: aload_0
    //   341: aload 6
    //   343: aload_1
    //   344: aload_2
    //   345: invokevirtual 317	aija:dispatchJsEvent	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   348: return
    //   349: iload_3
    //   350: iconst_1
    //   351: iadd
    //   352: istore_3
    //   353: goto -36 -> 317
    //   356: astore_1
    //   357: return
    //   358: astore_1
    //   359: return
    //   360: aconst_null
    //   361: astore_1
    //   362: goto -265 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	aija
    //   0	365	1	paramContext	android.content.Context
    //   0	365	2	paramIntent	Intent
    //   4	349	3	i	int
    //   315	6	4	j	int
    //   1	305	5	localObject	Object
    //   67	275	6	str1	String
    //   103	221	7	localArrayList	ArrayList
    //   116	167	8	str2	String
    //   170	163	9	str3	String
    //   185	25	10	str4	String
    // Exception table:
    //   from	to	target	type
    //   126	136	356	org/json/JSONException
    //   88	97	358	org/json/JSONException
  }
  
  String wU()
  {
    if (!TextUtils.isEmpty(this.mUniqueMark)) {
      return this.mUniqueMark;
    }
    Activity localActivity = this.mRuntime.getActivity();
    if (localActivity != null) {}
    for (this.mUniqueMark = (String.valueOf(System.currentTimeMillis()) + String.valueOf(localActivity.hashCode()));; this.mUniqueMark = (String.valueOf(System.currentTimeMillis()) + String.valueOf((int)(Math.random() * 1000000.0D)))) {
      return this.mUniqueMark;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aija
 * JD-Core Version:    0.7.0.1
 */