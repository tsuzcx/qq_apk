import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.unifiedebug.SnapshotResultReceiver;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager.5;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager.6;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import mqq.os.MqqHandler;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apzu
{
  public final Queue<apzu.a> N = new LinkedList();
  public Handler dH;
  public Map<String, String> nW;
  ResultReceiver t;
  
  public apzu(SnapshotResultReceiver paramSnapshotResultReceiver)
  {
    this.t = paramSnapshotResultReceiver;
    paramSnapshotResultReceiver = ThreadManager.newFreeHandlerThread("UnifiedDebugMonitor", 0);
    paramSnapshotResultReceiver.start();
    this.dH = new Handler(paramSnapshotResultReceiver.getLooper());
    this.nW = new HashMap();
    this.nW.put("offline_pkg", jpe.hP());
  }
  
  public static void a(Application paramApplication, String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = paramApplication.getSharedPreferences("x5_proxy_setting", 4);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putString("http_proxy_address", paramString + ":" + paramInt);
    localEditor.putBoolean("post_encription", false);
    localEditor.putString("qproxy_address", "http://" + paramString + ":" + paramInt);
    localEditor.putInt("connect_status", 1);
    localEditor.putString("qproxy_address_lists", paramString + ":" + paramInt);
    localEditor.putBoolean("is_in_proxy", true);
    localEditor.putBoolean("need_set_proxy", true);
    localEditor.commit();
    aqft.killProcess(paramApplication, "com.tencent.tim:tool");
    if (QLog.isColorLevel())
    {
      QLog.d("UnifiedDebugManager", 2, "set x5 proxy: " + paramString + ":" + paramInt);
      QLog.d("UnifiedDebugManager", 2, "http_proxy_address: " + localSharedPreferences.getString("http_proxy_address", "no proxy"));
      QLog.d("UnifiedDebugManager", 2, "qproxy_address_lists: " + localSharedPreferences.getString("qproxy_address_lists", "no proxy"));
      QLog.d("UnifiedDebugManager", 2, "sQQBrowserActivityCounter =  " + QQBrowserActivity.bJl);
    }
  }
  
  public static void b(Application paramApplication)
  {
    SharedPreferences localSharedPreferences = paramApplication.getSharedPreferences("x5_proxy_setting", 4);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.remove("http_proxy_address");
    localEditor.putBoolean("post_encription", true);
    localEditor.remove("qproxy_address");
    localEditor.putInt("connect_status", 0);
    localEditor.remove("qproxy_address_lists");
    localEditor.putBoolean("is_in_proxy", false);
    localEditor.putBoolean("need_set_proxy", true);
    localEditor.commit();
    fs(paramApplication);
    ThreadManager.getFileThreadHandler().postDelayed(new UnifiedDebugManager.6(paramApplication), 2000L);
    if (QLog.isColorLevel())
    {
      QLog.d("UnifiedDebugManager", 2, "unset x5 proxy");
      QLog.d("UnifiedDebugManager", 2, "http_proxy_address: " + localSharedPreferences.getString("http_proxy_address", "no proxy"));
      QLog.d("UnifiedDebugManager", 2, "qproxy_address_lists: " + localSharedPreferences.getString("qproxy_address_lists", "no proxy"));
    }
  }
  
  public static boolean b(Application paramApplication)
  {
    Object localObject = ((ActivityManager)paramApplication.getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        String str = localRunningAppProcessInfo.processName;
        if ((str.startsWith("com.tencent.tim")) && (str.indexOf(':') != -1) && (str.endsWith(":tool"))) {
          if ((localRunningAppProcessInfo.importance != 100) && ((localRunningAppProcessInfo.importance != 200) || ((localRunningAppProcessInfo.importance == 200) && (localRunningAppProcessInfo.importanceReasonCode != 0))))
          {
            aqft.killProcess(paramApplication, "com.tencent.tim:tool");
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean bI(Context paramContext)
  {
    return paramContext.getSharedPreferences("x5_proxy_setting", 4).contains("http_proxy_address");
  }
  
  public static void fs(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.ultimatesnapshot");
    localIntent.putExtra("action", 1);
    localIntent.putExtra("id", 0L);
    paramContext.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, "send broadcast to finish all alive webview");
    }
  }
  
  public String BF()
  {
    apzt.a locala = apzt.a("getprop net.dns1");
    if (locala.success)
    {
      if (!locala.result.isEmpty()) {
        return (String)locala.result.get(0);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, locala.errMsg);
    }
    return "";
  }
  
  public String H(Context paramContext, String paramString)
    throws Exception
  {
    Object localObject1 = new URL(paramString);
    paramString = ((URL)localObject1).getProtocol();
    localObject1 = ((URL)localObject1).getHost();
    paramString = paramString + "_" + (String)localObject1 + "_";
    paramContext = new File(aV(paramContext));
    if ((paramContext.exists()) && (paramContext.isDirectory()))
    {
      paramString = paramContext.list(new apzx(this, paramString));
      ArrayList localArrayList = new ArrayList();
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("host", localObject1);
      Object localObject2 = new JSONArray();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject3 = paramString[i];
          localObject3 = SQLiteDatabase.openDatabase(paramContext.getPath() + "/" + (String)localObject3, null, 1);
          Cursor localCursor = ((SQLiteDatabase)localObject3).query("ItemTable", new String[] { "key", "value" }, null, null, null, null, null);
          while (localCursor.moveToNext())
          {
            String str1 = localCursor.getString(0);
            String str2 = new String(localCursor.getBlob(1), "UTF-16LE");
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("key", str1);
            localJSONObject2.put("value", str2);
            ((JSONArray)localObject2).put(localJSONObject2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugManager", 2, "zipLocalStorage value = " + ((JSONArray)localObject2).toString());
          }
          localCursor.close();
          ((SQLiteDatabase)localObject3).close();
          i += 1;
        }
      }
      localJSONObject1.put("data", localObject2);
      localObject2 = new File(paramContext, "json.txt");
      try
      {
        paramString = new BufferedOutputStream(new FileOutputStream((File)localObject2));
        label516:
        return null;
      }
      finally
      {
        try
        {
          paramString.write(localJSONObject1.toString().getBytes());
          paramString.flush();
          localArrayList.add(((File)localObject2).getPath());
          if (paramString != null) {}
          try
          {
            paramString.close();
            if (localArrayList.isEmpty()) {
              break label540;
            }
            paramContext = paramContext.getPath() + "/localstorage_" + (String)localObject1 + ".zip";
            aqac.r(localArrayList, paramContext);
            aqac.deleteFiles(localArrayList);
            return paramContext;
          }
          catch (IOException paramString)
          {
            QLog.e("UnifiedDebugManager", 1, "os closed error", paramString);
          }
          paramContext = finally;
          paramString = null;
        }
        finally
        {
          break label516;
        }
        if (paramString != null) {}
        try
        {
          paramString.close();
          throw paramContext;
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            QLog.e("UnifiedDebugManager", 1, "os closed error", paramString);
          }
        }
      }
    }
  }
  
  public String V(List<String> paramList)
  {
    String str = Environment.getExternalStorageDirectory().getPath() + "/tencent/MobileQQ/unifiedebug/snapshots.zip";
    aqac.r(paramList, str);
    return str;
  }
  
  public apzu.b a(Context paramContext)
  {
    apzu.b localb = new apzu.b();
    localb.phoneModel = (aqgz.BY() + " " + aqgz.getDeviceModel());
    localb.osVersion = Build.VERSION.RELEASE;
    localb.crX = "3.4.4.3058";
    aqgz.a locala = aqgz.a(paramContext);
    localb.network = locala.networkType;
    localb.operator = locala.cth;
    localb.Gq = aqgz.getCpuNumber();
    localb.lz = aqgz.getCpuFrequency();
    localb.asu = aqgz.getSystemTotalMemory();
    localb.crY = aqgz.getCpuType();
    localb.cTg = bI(paramContext);
    localb.dYd = QbSdk.getTbsVersion(paramContext);
    if (localb.dYd == 0) {}
    for (boolean bool = false;; bool = true)
    {
      localb.cTh = bool;
      return localb;
    }
  }
  
  public String a(Context paramContext, List<String> paramList)
    throws Exception
  {
    int i = QbSdk.getTbsVersion(paramContext);
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (i < 30000)
    {
      localObject1 = paramContext.getDatabasePath("webviewCache_x5.db").getPath();
      paramContext = new File(paramContext.getCacheDir(), "webviewCache");
      localObject1 = SQLiteDatabase.openDatabase((String)localObject1, null, 0);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (String)paramList.next();
        localObject2 = ((SQLiteDatabase)localObject1).query("cache", new String[] { "url", "filepath" }, "url=?", new String[] { localObject2 }, null, null, null);
        while (((Cursor)localObject2).moveToNext()) {
          localArrayList.add(new File(paramContext, ((Cursor)localObject2).getString(1)).getPath());
        }
        ((Cursor)localObject2).close();
      }
      ((SQLiteDatabase)localObject1).close();
      paramContext = paramContext.getPath() + "/html_cache.zip";
      aqac.r(localArrayList, paramContext);
      return paramContext;
    }
    paramContext = paramContext.getApplicationContext().getDir("webview", 0).getPath() + "/Cache/";
    Object localObject1 = new File(paramContext);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = ((File)localObject1).list(new apzv(this, oX((String)paramList.next()).substring(0, 16)));
        if (localObject2 != null)
        {
          int j = localObject2.length;
          i = 0;
          while (i < j)
          {
            String str = localObject2[i];
            localArrayList.add(paramContext + str);
            i += 1;
          }
        }
      }
      if (localArrayList.isEmpty()) {
        throw new FileNotFoundException("no cache file was found");
      }
      paramContext = paramContext + "html_cache.zip";
      aqac.r(localArrayList, paramContext);
      return paramContext;
    }
    throw new FileNotFoundException("no cache directory found");
  }
  
  /* Error */
  public String a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
    throws Exception
  {
    // Byte code:
    //   0: new 642	android/os/Bundle
    //   3: dup
    //   4: invokespecial 643	android/os/Bundle:<init>	()V
    //   7: astore 12
    //   9: aload 12
    //   11: ldc_w 645
    //   14: ldc_w 325
    //   17: invokestatic 650	arcp:qc	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 653	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: invokestatic 659	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   26: astore_1
    //   27: aload_1
    //   28: iconst_1
    //   29: invokevirtual 663	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   32: aload_1
    //   33: aload 4
    //   35: invokevirtual 666	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +69 -> 109
    //   43: aload 12
    //   45: ldc_w 668
    //   48: aload_1
    //   49: invokevirtual 653	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +54 -> 109
    //   58: ldc 155
    //   60: iconst_2
    //   61: new 95	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 670
    //   71: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_1
    //   75: iconst_0
    //   76: anewarray 244	java/lang/String
    //   79: invokestatic 675	jqo:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 677
    //   88: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 4
    //   93: iconst_0
    //   94: anewarray 244	java/lang/String
    //   97: invokestatic 680	jqo:filterKeyForLog	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   100: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: new 95	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   116: invokestatic 489	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   119: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: ldc_w 685
    //   125: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: astore 9
    //   133: new 344	java/io/File
    //   136: dup
    //   137: aload 9
    //   139: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual 352	java/io/File:exists	()Z
    //   147: ifne +8 -> 155
    //   150: aload_1
    //   151: invokevirtual 688	java/io/File:mkdirs	()Z
    //   154: pop
    //   155: lload_2
    //   156: invokestatic 692	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   159: astore 10
    //   161: new 95	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   168: aload 9
    //   170: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc_w 383
    //   176: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload 10
    //   181: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc_w 694
    //   187: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: astore 11
    //   195: new 344	java/io/File
    //   198: dup
    //   199: aload 11
    //   201: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   204: astore 6
    //   206: aconst_null
    //   207: astore_1
    //   208: aconst_null
    //   209: astore 8
    //   211: aconst_null
    //   212: astore 7
    //   214: new 437	java/io/FileOutputStream
    //   217: dup
    //   218: aload 6
    //   220: invokespecial 440	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   223: astore 6
    //   225: new 333	java/net/URL
    //   228: dup
    //   229: aload 4
    //   231: invokespecial 334	java/net/URL:<init>	(Ljava/lang/String;)V
    //   234: invokevirtual 698	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   237: checkcast 700	java/net/HttpURLConnection
    //   240: astore_1
    //   241: aload_1
    //   242: ldc_w 702
    //   245: invokevirtual 705	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   248: aload_1
    //   249: sipush 6000
    //   252: invokevirtual 709	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   255: aload_1
    //   256: sipush 6000
    //   259: invokevirtual 712	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   262: aload 12
    //   264: invokevirtual 716	android/os/Bundle:keySet	()Ljava/util/Set;
    //   267: invokeinterface 719 1 0
    //   272: astore 4
    //   274: aload 4
    //   276: invokeinterface 230 1 0
    //   281: ifeq +110 -> 391
    //   284: aload 4
    //   286: invokeinterface 234 1 0
    //   291: checkcast 244	java/lang/String
    //   294: astore 7
    //   296: aload 12
    //   298: aload 7
    //   300: invokevirtual 721	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   303: astore 8
    //   305: aload 8
    //   307: instanceof 244
    //   310: ifeq -36 -> 274
    //   313: aload_1
    //   314: aload 7
    //   316: aload 8
    //   318: checkcast 244	java/lang/String
    //   321: invokevirtual 724	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: goto -50 -> 274
    //   327: astore 7
    //   329: aload 6
    //   331: astore 4
    //   333: aload 7
    //   335: astore 6
    //   337: aload_1
    //   338: astore 7
    //   340: aload 4
    //   342: astore_1
    //   343: aload 7
    //   345: astore 4
    //   347: ldc 155
    //   349: iconst_1
    //   350: ldc_w 726
    //   353: aload 6
    //   355: invokestatic 480	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   358: aload 6
    //   360: athrow
    //   361: astore 7
    //   363: aload_1
    //   364: astore 6
    //   366: aload 7
    //   368: astore_1
    //   369: aload 6
    //   371: ifnull +8 -> 379
    //   374: aload 6
    //   376: invokevirtual 729	java/io/OutputStream:close	()V
    //   379: aload 4
    //   381: ifnull +8 -> 389
    //   384: aload 4
    //   386: invokevirtual 732	java/net/HttpURLConnection:disconnect	()V
    //   389: aload_1
    //   390: athrow
    //   391: aload_1
    //   392: invokevirtual 735	java/net/HttpURLConnection:connect	()V
    //   395: sipush 200
    //   398: aload_1
    //   399: invokevirtual 738	java/net/HttpURLConnection:getResponseCode	()I
    //   402: if_icmpne +56 -> 458
    //   405: sipush 1024
    //   408: newarray byte
    //   410: astore 4
    //   412: new 740	java/io/BufferedInputStream
    //   415: dup
    //   416: aload_1
    //   417: invokevirtual 744	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   420: invokespecial 747	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   423: astore 7
    //   425: aload 7
    //   427: aload 4
    //   429: invokevirtual 753	java/io/InputStream:read	([B)I
    //   432: istore 5
    //   434: iconst_m1
    //   435: iload 5
    //   437: if_icmpeq +16 -> 453
    //   440: aload 6
    //   442: aload 4
    //   444: iconst_0
    //   445: iload 5
    //   447: invokevirtual 756	java/io/OutputStream:write	([BII)V
    //   450: goto -25 -> 425
    //   453: aload 6
    //   455: invokevirtual 757	java/io/OutputStream:flush	()V
    //   458: aload 6
    //   460: ifnull +8 -> 468
    //   463: aload 6
    //   465: invokevirtual 729	java/io/OutputStream:close	()V
    //   468: aload_1
    //   469: ifnull +7 -> 476
    //   472: aload_1
    //   473: invokevirtual 732	java/net/HttpURLConnection:disconnect	()V
    //   476: new 366	java/util/ArrayList
    //   479: dup
    //   480: invokespecial 367	java/util/ArrayList:<init>	()V
    //   483: astore_1
    //   484: aload_1
    //   485: aload 11
    //   487: invokeinterface 459 2 0
    //   492: pop
    //   493: new 95	java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   500: aload 9
    //   502: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: ldc_w 383
    //   508: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload 10
    //   513: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc_w 464
    //   519: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: astore 4
    //   527: aload_1
    //   528: aload 4
    //   530: invokestatic 470	aqac:r	(Ljava/util/List;Ljava/lang/String;)V
    //   533: aload 4
    //   535: areturn
    //   536: astore 4
    //   538: ldc 155
    //   540: iconst_1
    //   541: ldc_w 726
    //   544: aload 4
    //   546: invokestatic 480	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   549: goto -81 -> 468
    //   552: astore 6
    //   554: ldc 155
    //   556: iconst_1
    //   557: ldc_w 726
    //   560: aload 6
    //   562: invokestatic 480	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   565: goto -186 -> 379
    //   568: astore_1
    //   569: aconst_null
    //   570: astore 6
    //   572: aload 8
    //   574: astore 4
    //   576: goto -207 -> 369
    //   579: astore_1
    //   580: aload 8
    //   582: astore 4
    //   584: goto -215 -> 369
    //   587: astore 6
    //   589: aload 7
    //   591: astore 4
    //   593: goto -246 -> 347
    //   596: astore 4
    //   598: aload 6
    //   600: astore_1
    //   601: aload 4
    //   603: astore 6
    //   605: aload 7
    //   607: astore 4
    //   609: goto -262 -> 347
    //   612: astore 7
    //   614: aload_1
    //   615: astore 4
    //   617: aload 7
    //   619: astore_1
    //   620: goto -251 -> 369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	623	0	this	apzu
    //   0	623	1	paramQQAppInterface	QQAppInterface
    //   0	623	2	paramLong	long
    //   0	623	4	paramString	String
    //   432	14	5	i	int
    //   204	260	6	localObject1	Object
    //   552	9	6	localException1	Exception
    //   570	1	6	localObject2	Object
    //   587	12	6	localException2	Exception
    //   603	1	6	str1	String
    //   212	103	7	str2	String
    //   327	7	7	localException3	Exception
    //   338	6	7	localQQAppInterface	QQAppInterface
    //   361	6	7	localObject3	Object
    //   423	183	7	localBufferedInputStream	java.io.BufferedInputStream
    //   612	6	7	localObject4	Object
    //   209	372	8	localObject5	Object
    //   131	370	9	str3	String
    //   159	353	10	str4	String
    //   193	293	11	str5	String
    //   7	290	12	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   241	274	327	java/lang/Exception
    //   274	324	327	java/lang/Exception
    //   391	425	327	java/lang/Exception
    //   425	434	327	java/lang/Exception
    //   440	450	327	java/lang/Exception
    //   453	458	327	java/lang/Exception
    //   347	361	361	finally
    //   463	468	536	java/lang/Exception
    //   374	379	552	java/lang/Exception
    //   214	225	568	finally
    //   225	241	579	finally
    //   214	225	587	java/lang/Exception
    //   225	241	596	java/lang/Exception
    //   241	274	612	finally
    //   274	324	612	finally
    //   391	425	612	finally
    //   425	434	612	finally
    //   440	450	612	finally
    //   453	458	612	finally
  }
  
  public String a(File paramFile, List<String> paramList)
  {
    String str = new File(paramFile, "files-" + System.currentTimeMillis() + ".zip").getAbsolutePath();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      localLinkedList.add(paramFile + "/" + (String)paramList.get(i));
      i += 1;
    }
    aqac.a(paramFile, paramList, str);
    return str;
  }
  
  public Set<String> a(Context paramContext)
    throws SQLiteException
  {
    int i = QbSdk.getTbsVersion(paramContext);
    Object localObject;
    if (i < 30000)
    {
      localObject = new String[1];
      localObject[0] = "domain";
    }
    HashSet localHashSet;
    for (;;)
    {
      paramContext = SQLiteDatabase.openDatabase(k(paramContext, i), null, 1);
      localObject = paramContext.query("cookies", (String[])localObject, null, null, null, null, null);
      localHashSet = new HashSet();
      while (((Cursor)localObject).moveToNext()) {
        localHashSet.add(((Cursor)localObject).getString(0));
      }
      localObject = new String[1];
      localObject[0] = "host_key";
    }
    ((Cursor)localObject).close();
    paramContext.close();
    return localHashSet;
  }
  
  public JSONObject a(File paramFile, String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramFile == null) {
      return localJSONObject;
    }
    label35:
    JSONArray localJSONArray1;
    int i;
    label72:
    Object localObject;
    JSONArray localJSONArray2;
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      paramFile = paramFile.listFiles();
      if (paramFile == null) {
        break label162;
      }
      localJSONObject.put("module_dir", paramString);
      paramString = new JSONArray();
      localJSONArray1 = new JSONArray();
      int j = paramFile.length;
      i = 0;
      if (i >= j) {
        break label200;
      }
      localObject = paramFile[i];
      localJSONArray2 = new JSONArray();
      localJSONArray2.put(localObject.getName());
      if (!localObject.isFile()) {
        break label164;
      }
      localJSONArray2.put(localObject.length() / 1000.0D);
      localJSONArray2.put(0);
      localJSONArray2.put(localObject.lastModified());
      paramString.put(localJSONArray2);
    }
    for (;;)
    {
      i += 1;
      break label72;
      paramFile = null;
      break label35;
      label162:
      break;
      label164:
      localJSONArray2.put(0);
      localJSONArray2.put(0);
      localJSONArray2.put(localObject.lastModified());
      localJSONArray1.put(localJSONArray2);
    }
    label200:
    localJSONObject.put("sub_dir", localJSONArray1);
    localJSONObject.put("files", paramString);
    return localJSONObject;
  }
  
  public void a(Context paramContext, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, SnapshotService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("id", paramLong1);
    localIntent.putExtra("action", 0);
    localIntent.putExtra("seq", paramLong2);
    localIntent.putExtra("seqKey", paramString);
    localIntent.putExtra("maxSnapshotCount", paramInt);
    localIntent.putExtra("callback", this.t);
    paramContext.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, "start alive snapshot to webview(" + paramLong1 + ")");
    }
  }
  
  public void a(Context paramContext, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    synchronized (this.N)
    {
      if (this.N.isEmpty())
      {
        b(paramContext, paramString1, paramInt, paramLong1, paramLong2, paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("UnifiedDebugManager", 2, "start debug(queue is empty): seq=" + paramLong2);
        }
      }
      while (!QLog.isColorLevel())
      {
        this.N.offer(new apzu.a(paramString1, paramInt, paramLong1, paramLong2, paramString2));
        return;
      }
      QLog.d("UnifiedDebugManager", 2, "start debug(only enqueue one cmd): seq=" + paramLong2);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, Handler paramHandler)
    throws IOException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IOException("url is empty");
    }
    String str1 = getHostFromUrl(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, "traceRoute getHost = " + str1);
    }
    String str2 = oY(str1);
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, "traceRoute getIp = " + str2);
    }
    paramString = y(paramString);
    new aqad(paramQQAppInterface, paramHandler).b(paramLong, str1, paramString);
  }
  
  public boolean a(File paramFile, List<String> paramList)
  {
    if ((paramFile == null) || (paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      File localFile = new File(paramFile, (String)paramList.next());
      if (localFile.exists())
      {
        if (localFile.isDirectory()) {
          return VasQuickUpdateEngine.safeDeleteFile(localFile);
        }
        return localFile.delete();
      }
    }
    return false;
  }
  
  String aV(Context paramContext)
  {
    if (QbSdk.getTbsVersion(paramContext) < 30000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnifiedDebugManager", 2, "Local StoragePath = " + paramContext.getApplicationContext().getDir("database_web", 0).getPath());
      }
      return paramContext.getApplicationContext().getDir("database_web", 0).getPath();
    }
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, "Local StoragePath = " + paramContext.getApplicationContext().getDir("webview", 0).getPath() + "/Local Storage/");
    }
    return paramContext.getApplicationContext().getDir("webview", 0).getPath() + "/Local Storage/";
  }
  
  public Set<String> b(Context paramContext)
  {
    paramContext = aqac.u(aV(paramContext));
    HashSet localHashSet = new HashSet();
    if ((paramContext != null) && (paramContext.length > 0))
    {
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramContext[i].split("_");
        if (arrayOfString.length == 3) {
          localHashSet.add(arrayOfString[1]);
        }
        i += 1;
      }
    }
    return localHashSet;
  }
  
  public void b(Context paramContext, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, SnapshotService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("debugUrl", paramString1);
    localIntent.putExtra("seq", paramLong2);
    localIntent.putExtra("seqKey", paramString2);
    localIntent.putExtra("delay", paramLong1);
    localIntent.putExtra("maxSnapshotCount", paramInt);
    localIntent.putExtra("callback", this.t);
    paramContext.startActivity(localIntent);
    this.dH.postDelayed(new UnifiedDebugManager.5(this, paramLong2, paramContext, paramString1, paramInt, paramLong1, paramString2), 120000L + paramLong1);
  }
  
  public void c(Context paramContext, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, SnapshotService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("id", paramLong2);
    localIntent.putExtra("action", 2);
    localIntent.putExtra("debugUrl", paramString1);
    localIntent.putExtra("seq", paramLong2);
    localIntent.putExtra("seqKey", paramString2);
    localIntent.putExtra("delay", paramLong1);
    localIntent.putExtra("maxSnapshotCount", paramInt);
    localIntent.putExtra("callback", this.t);
    paramContext.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, "start alive snapshot, seq=" + paramLong2);
    }
  }
  
  public List<Map<String, Object>> e(Context paramContext, String paramString)
    throws SQLiteException
  {
    int i = QbSdk.getTbsVersion(paramContext);
    String str = paramString;
    if (!paramString.startsWith(".")) {
      str = "." + paramString;
    }
    SQLiteDatabase localSQLiteDatabase;
    Cursor localCursor;
    ArrayList localArrayList;
    if (i < 30000)
    {
      paramString = new String[6];
      paramString[0] = "domain";
      paramString[1] = "name";
      paramString[2] = "value";
      paramString[3] = "path";
      paramString[4] = "expires";
      paramString[5] = "secure";
      localSQLiteDatabase = SQLiteDatabase.openDatabase(k(paramContext, i), null, 1);
      localCursor = localSQLiteDatabase.query("cookies", paramString, null, null, null, null, null);
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      if (!localCursor.moveToNext()) {
        break label319;
      }
      paramContext = localCursor.getString(0);
      if ((str.endsWith(paramContext)) || (str.equals(paramContext)))
      {
        HashMap localHashMap = new HashMap();
        i = 0;
        label175:
        if (i < paramString.length)
        {
          Object localObject = paramString[i];
          if (i <= 3) {}
          for (paramContext = localCursor.getString(i);; paramContext = Integer.valueOf(localCursor.getInt(i)))
          {
            localHashMap.put(localObject, paramContext);
            i += 1;
            break label175;
            paramString = new String[10];
            paramString[0] = "host_key";
            paramString[1] = "name";
            paramString[2] = "value";
            paramString[3] = "path";
            paramString[4] = "expires_utc";
            paramString[5] = "secure";
            paramString[6] = "httponly";
            paramString[7] = "has_expires";
            paramString[8] = "persistent";
            paramString[9] = "priority";
            break;
          }
        }
        localArrayList.add(localHashMap);
      }
    }
    label319:
    localCursor.close();
    localSQLiteDatabase.close();
    return localArrayList;
  }
  
  public void e(Context paramContext, String paramString, List<String> paramList)
    throws SQLiteException
  {
    int i = QbSdk.getTbsVersion(paramContext);
    Object localObject = k(paramContext, i);
    if (i < 30000) {}
    for (paramContext = "domain=? and name=?";; paramContext = "host_key=? and name=?")
    {
      localObject = SQLiteDatabase.openDatabase((String)localObject, null, 0);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((SQLiteDatabase)localObject).delete("cookies", paramContext, new String[] { paramString, (String)paramList.next() });
      }
    }
    ((SQLiteDatabase)localObject).close();
  }
  
  public void f(Context paramContext, String paramString, List<String> paramList)
    throws SQLiteException, MalformedURLException
  {
    Object localObject = new URL(paramString);
    paramString = ((URL)localObject).getProtocol();
    localObject = ((URL)localObject).getHost();
    paramString = paramString + "_" + (String)localObject + "_";
    paramContext = new File(aV(paramContext));
    if ((paramContext.exists()) && (paramContext.isDirectory()))
    {
      paramString = paramContext.list(new apzy(this, paramString));
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          localObject = paramString[i];
          localObject = SQLiteDatabase.openDatabase(paramContext.getPath() + "/" + (String)localObject, null, 0);
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext()) {
            ((SQLiteDatabase)localObject).delete("ItemTable", "key=?", new String[] { (String)localIterator.next() });
          }
          ((SQLiteDatabase)localObject).close();
          i += 1;
        }
      }
    }
  }
  
  public void f(Context paramContext, List<String> paramList)
    throws Exception
  {
    Object localObject1;
    if (QbSdk.getTbsVersion(paramContext) < 30000)
    {
      localObject1 = paramContext.getDatabasePath("webviewCache_x5.db").getPath();
      paramContext = new File(paramContext.getCacheDir(), "webviewCache");
      localObject1 = SQLiteDatabase.openDatabase((String)localObject1, null, 0);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject2 = (String)paramList.next();
        localObject2 = ((SQLiteDatabase)localObject1).query("cache", new String[] { "url", "filepath" }, "url=?", new String[] { localObject2 }, null, null, null);
        while (((Cursor)localObject2).moveToNext())
        {
          String str1 = ((Cursor)localObject2).getString(0);
          String str2 = ((Cursor)localObject2).getString(1);
          File localFile = new File(paramContext, str2);
          if ((localFile.exists()) && (localFile.delete())) {
            ((SQLiteDatabase)localObject1).delete("cache", "url=? and filepath=?", new String[] { str1, str2 });
          }
        }
        ((Cursor)localObject2).close();
      }
      ((SQLiteDatabase)localObject1).close();
      label216:
      return;
    }
    else
    {
      paramContext = new File(paramContext.getApplicationContext().getDir("webview", 0).getPath() + "/Cache");
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label216;
      }
      localObject1 = paramContext.listFiles(new apzw(this, oX((String)paramList.next()).substring(0, 16)));
      if (localObject1 == null) {
        break;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject1[i].delete();
        i += 1;
      }
    }
  }
  
  String getHostFromUrl(String paramString)
    throws MalformedURLException
  {
    return new URL(paramString).getHost();
  }
  
  public boolean j(Context paramContext, long paramLong)
  {
    synchronized (this.N)
    {
      apzu.a locala = (apzu.a)this.N.poll();
      if ((locala != null) && (locala.seq == paramLong))
      {
        locala = (apzu.a)this.N.peek();
        if (locala != null)
        {
          b(paramContext, locala.crU, locala.dYb, locala.delay, locala.seq, locala.crT);
          if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugManager", 2, "finish once webview debug, start new debug(dequeue one cmd): seq=" + locala.seq);
          }
        }
        while (!QLog.isColorLevel()) {
          return true;
        }
        QLog.d("UnifiedDebugManager", 2, "finish once webview debug: seq=" + paramLong);
      }
    }
    return false;
  }
  
  /* Error */
  public String k(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 1043	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   3: astore 18
    //   5: aload 18
    //   7: lload_1
    //   8: invokevirtual 1047	java/util/Calendar:setTimeInMillis	(J)V
    //   11: invokestatic 1043	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   14: astore 19
    //   16: aload 19
    //   18: lload_3
    //   19: invokevirtual 1047	java/util/Calendar:setTimeInMillis	(J)V
    //   22: invokestatic 765	java/lang/System:currentTimeMillis	()J
    //   25: lstore 16
    //   27: lload_3
    //   28: lload 16
    //   30: lcmp
    //   31: iflt +10 -> 41
    //   34: aload 19
    //   36: lload 16
    //   38: invokevirtual 1047	java/util/Calendar:setTimeInMillis	(J)V
    //   41: aload 18
    //   43: iconst_1
    //   44: invokevirtual 1049	java/util/Calendar:get	(I)I
    //   47: istore 7
    //   49: aload 18
    //   51: iconst_2
    //   52: invokevirtual 1049	java/util/Calendar:get	(I)I
    //   55: istore 8
    //   57: aload 18
    //   59: iconst_5
    //   60: invokevirtual 1049	java/util/Calendar:get	(I)I
    //   63: istore 9
    //   65: aload 18
    //   67: bipush 10
    //   69: invokevirtual 1049	java/util/Calendar:get	(I)I
    //   72: istore 10
    //   74: aload 19
    //   76: iconst_1
    //   77: invokevirtual 1049	java/util/Calendar:get	(I)I
    //   80: istore 11
    //   82: aload 19
    //   84: iconst_2
    //   85: invokevirtual 1049	java/util/Calendar:get	(I)I
    //   88: istore 12
    //   90: aload 19
    //   92: iconst_5
    //   93: invokevirtual 1049	java/util/Calendar:get	(I)I
    //   96: istore 13
    //   98: aload 19
    //   100: bipush 10
    //   102: invokevirtual 1049	java/util/Calendar:get	(I)I
    //   105: istore 14
    //   107: new 791	java/util/HashSet
    //   110: dup
    //   111: invokespecial 792	java/util/HashSet:<init>	()V
    //   114: astore 20
    //   116: iconst_0
    //   117: istore 6
    //   119: invokestatic 1053	com/tencent/qphone/base/util/QLog:getLogFileFormatter	()Ljava/text/SimpleDateFormat;
    //   122: lload_1
    //   123: invokestatic 1058	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   126: invokevirtual 1064	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: astore 18
    //   131: aload 20
    //   133: aload 18
    //   135: invokevirtual 1065	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   138: pop
    //   139: iload 6
    //   141: istore 5
    //   143: iload 6
    //   145: ifne +10 -> 155
    //   148: aload 18
    //   150: invokevirtual 1067	java/lang/String:length	()I
    //   153: istore 5
    //   155: lload_1
    //   156: ldc2_w 1068
    //   159: ladd
    //   160: lstore 16
    //   162: iload 5
    //   164: istore 6
    //   166: lload 16
    //   168: lstore_1
    //   169: lload 16
    //   171: lload_3
    //   172: lcmp
    //   173: ifle -54 -> 119
    //   176: new 366	java/util/ArrayList
    //   179: dup
    //   180: invokespecial 367	java/util/ArrayList:<init>	()V
    //   183: astore 22
    //   185: new 344	java/io/File
    //   188: dup
    //   189: invokestatic 1072	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   192: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   195: astore 21
    //   197: aload 21
    //   199: invokevirtual 352	java/io/File:exists	()Z
    //   202: ifeq +183 -> 385
    //   205: aload 21
    //   207: invokevirtual 803	java/io/File:listFiles	()[Ljava/io/File;
    //   210: astore 23
    //   212: aload 23
    //   214: ifnull +177 -> 391
    //   217: aload 23
    //   219: arraylength
    //   220: istore 15
    //   222: iconst_0
    //   223: istore 6
    //   225: iload 6
    //   227: iload 15
    //   229: if_icmpge +162 -> 391
    //   232: aload 23
    //   234: iload 6
    //   236: aaload
    //   237: astore 24
    //   239: aload 24
    //   241: invokevirtual 808	java/io/File:getName	()Ljava/lang/String;
    //   244: astore 19
    //   246: aload 19
    //   248: ldc_w 464
    //   251: invokevirtual 257	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   254: ifeq +12 -> 266
    //   257: iload 6
    //   259: iconst_1
    //   260: iadd
    //   261: istore 6
    //   263: goto -38 -> 225
    //   266: aload 19
    //   268: ldc_w 1074
    //   271: invokevirtual 257	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   274: ifeq +78 -> 352
    //   277: aload 19
    //   279: iconst_0
    //   280: aload 19
    //   282: invokevirtual 1067	java/lang/String:length	()I
    //   285: iconst_4
    //   286: isub
    //   287: invokevirtual 628	java/lang/String:substring	(II)Ljava/lang/String;
    //   290: astore 18
    //   292: aload 18
    //   294: getstatic 1077	com/tencent/qphone/base/util/QLog:packageName	Ljava/lang/String;
    //   297: invokevirtual 248	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   300: ifeq -43 -> 257
    //   303: aload 18
    //   305: aload 18
    //   307: invokevirtual 1067	java/lang/String:length	()I
    //   310: iload 5
    //   312: isub
    //   313: invokevirtual 1079	java/lang/String:substring	(I)Ljava/lang/String;
    //   316: astore 18
    //   318: aload 18
    //   320: invokestatic 886	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   323: ifne -66 -> 257
    //   326: aload 20
    //   328: aload 18
    //   330: invokevirtual 1081	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   333: ifeq -76 -> 257
    //   336: aload 22
    //   338: aload 24
    //   340: invokevirtual 381	java/io/File:getPath	()Ljava/lang/String;
    //   343: invokeinterface 459 2 0
    //   348: pop
    //   349: goto -92 -> 257
    //   352: aload 19
    //   354: astore 18
    //   356: aload 19
    //   358: ldc_w 1083
    //   361: invokevirtual 257	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   364: ifeq -72 -> 292
    //   367: aload 19
    //   369: iconst_0
    //   370: aload 19
    //   372: invokevirtual 1067	java/lang/String:length	()I
    //   375: iconst_5
    //   376: isub
    //   377: invokevirtual 628	java/lang/String:substring	(II)Ljava/lang/String;
    //   380: astore 18
    //   382: goto -90 -> 292
    //   385: aload 21
    //   387: invokevirtual 688	java/io/File:mkdirs	()Z
    //   390: pop
    //   391: aconst_null
    //   392: astore 18
    //   394: aload 21
    //   396: invokevirtual 352	java/io/File:exists	()Z
    //   399: ifeq +145 -> 544
    //   402: new 344	java/io/File
    //   405: dup
    //   406: aload 21
    //   408: ldc_w 1085
    //   411: invokespecial 433	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   414: astore 18
    //   416: new 1087	java/io/BufferedWriter
    //   419: dup
    //   420: new 1089	java/io/OutputStreamWriter
    //   423: dup
    //   424: new 437	java/io/FileOutputStream
    //   427: dup
    //   428: aload 18
    //   430: invokespecial 440	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   433: invokespecial 1090	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   436: invokespecial 1093	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   439: astore 20
    //   441: aload 20
    //   443: astore 19
    //   445: aload 21
    //   447: invokevirtual 803	java/io/File:listFiles	()[Ljava/io/File;
    //   450: astore 21
    //   452: aload 21
    //   454: ifnull +71 -> 525
    //   457: aload 20
    //   459: astore 19
    //   461: aload 21
    //   463: arraylength
    //   464: istore 6
    //   466: iconst_0
    //   467: istore 5
    //   469: iload 5
    //   471: iload 6
    //   473: if_icmpge +52 -> 525
    //   476: aload 21
    //   478: iload 5
    //   480: aaload
    //   481: astore 23
    //   483: aload 20
    //   485: astore 19
    //   487: aload 20
    //   489: new 95	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   496: aload 23
    //   498: invokevirtual 808	java/io/File:getName	()Ljava/lang/String;
    //   501: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: ldc_w 1095
    //   507: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokevirtual 1097	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   516: iload 5
    //   518: iconst_1
    //   519: iadd
    //   520: istore 5
    //   522: goto -53 -> 469
    //   525: aload 20
    //   527: astore 19
    //   529: aload 20
    //   531: invokevirtual 1098	java/io/BufferedWriter:flush	()V
    //   534: aload 20
    //   536: ifnull +8 -> 544
    //   539: aload 20
    //   541: invokevirtual 1099	java/io/BufferedWriter:close	()V
    //   544: aload 18
    //   546: ifnull +16 -> 562
    //   549: aload 22
    //   551: aload 18
    //   553: invokevirtual 381	java/io/File:getPath	()Ljava/lang/String;
    //   556: invokeinterface 459 2 0
    //   561: pop
    //   562: new 344	java/io/File
    //   565: dup
    //   566: ldc_w 1101
    //   569: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   572: astore 18
    //   574: aload 18
    //   576: invokevirtual 352	java/io/File:exists	()Z
    //   579: ifeq +16 -> 595
    //   582: aload 22
    //   584: aload 18
    //   586: invokevirtual 381	java/io/File:getPath	()Ljava/lang/String;
    //   589: invokeinterface 459 2 0
    //   594: pop
    //   595: new 95	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   602: invokestatic 1072	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   605: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: iload 7
    //   610: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   613: ldc_w 342
    //   616: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: iload 8
    //   621: iconst_1
    //   622: iadd
    //   623: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   626: ldc_w 342
    //   629: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: iload 9
    //   634: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   637: ldc_w 342
    //   640: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: iload 10
    //   645: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   648: ldc_w 1103
    //   651: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: iload 11
    //   656: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   659: ldc_w 342
    //   662: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: iload 12
    //   667: iconst_1
    //   668: iadd
    //   669: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   672: ldc_w 342
    //   675: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: iload 13
    //   680: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   683: ldc_w 342
    //   686: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: iload 14
    //   691: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   694: ldc_w 464
    //   697: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: astore 18
    //   705: aload 22
    //   707: aload 18
    //   709: invokestatic 470	aqac:r	(Ljava/util/List;Ljava/lang/String;)V
    //   712: aload 18
    //   714: areturn
    //   715: astore 19
    //   717: ldc 155
    //   719: iconst_1
    //   720: ldc_w 1105
    //   723: aload 19
    //   725: invokestatic 480	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   728: goto -184 -> 544
    //   731: astore 21
    //   733: aconst_null
    //   734: astore 20
    //   736: aload 20
    //   738: astore 19
    //   740: ldc 155
    //   742: iconst_1
    //   743: ldc_w 1107
    //   746: aload 21
    //   748: invokestatic 480	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   751: aload 20
    //   753: ifnull +8 -> 761
    //   756: aload 20
    //   758: invokevirtual 1099	java/io/BufferedWriter:close	()V
    //   761: goto -217 -> 544
    //   764: astore 19
    //   766: ldc 155
    //   768: iconst_1
    //   769: ldc_w 1105
    //   772: aload 19
    //   774: invokestatic 480	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   777: goto -233 -> 544
    //   780: astore 18
    //   782: aconst_null
    //   783: astore 19
    //   785: aload 19
    //   787: ifnull +8 -> 795
    //   790: aload 19
    //   792: invokevirtual 1099	java/io/BufferedWriter:close	()V
    //   795: aload 18
    //   797: athrow
    //   798: astore 19
    //   800: ldc 155
    //   802: iconst_1
    //   803: ldc_w 1105
    //   806: aload 19
    //   808: invokestatic 480	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   811: goto -16 -> 795
    //   814: astore 18
    //   816: goto -31 -> 785
    //   819: astore 21
    //   821: goto -85 -> 736
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	824	0	this	apzu
    //   0	824	1	paramLong1	long
    //   0	824	3	paramLong2	long
    //   141	380	5	i	int
    //   117	357	6	j	int
    //   47	562	7	k	int
    //   55	568	8	m	int
    //   63	570	9	n	int
    //   72	572	10	i1	int
    //   80	575	11	i2	int
    //   88	581	12	i3	int
    //   96	583	13	i4	int
    //   105	585	14	i5	int
    //   220	10	15	i6	int
    //   25	145	16	l	long
    //   3	710	18	localObject1	Object
    //   780	16	18	localObject2	Object
    //   814	1	18	localObject3	Object
    //   14	514	19	localObject4	Object
    //   715	9	19	localIOException1	IOException
    //   738	1	19	localObject5	Object
    //   764	9	19	localIOException2	IOException
    //   783	8	19	localObject6	Object
    //   798	9	19	localIOException3	IOException
    //   114	643	20	localObject7	Object
    //   195	282	21	localObject8	Object
    //   731	16	21	localException1	Exception
    //   819	1	21	localException2	Exception
    //   183	523	22	localArrayList	ArrayList
    //   210	287	23	arrayOfFile	File[]
    //   237	102	24	localFile	File
    // Exception table:
    //   from	to	target	type
    //   539	544	715	java/io/IOException
    //   416	441	731	java/lang/Exception
    //   756	761	764	java/io/IOException
    //   416	441	780	finally
    //   790	795	798	java/io/IOException
    //   445	452	814	finally
    //   461	466	814	finally
    //   487	516	814	finally
    //   529	534	814	finally
    //   740	751	814	finally
    //   445	452	819	java/lang/Exception
    //   461	466	819	java/lang/Exception
    //   487	516	819	java/lang/Exception
    //   529	534	819	java/lang/Exception
  }
  
  String k(Context paramContext, int paramInt)
  {
    if (paramInt < 30000) {
      return paramContext.getDatabasePath("webview_x5.db").getPath();
    }
    return paramContext.getApplicationContext().getDir("webview", 0).getPath() + "/Cookies";
  }
  
  public String oV(String paramString)
  {
    if (this.nW.containsKey(paramString)) {
      return (String)this.nW.get(paramString);
    }
    return paramString;
  }
  
  public String oW(String paramString)
  {
    File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "/tencent/tbs_live_log/com.tencent.mobileqq/");
    paramString = new File(localFile, "com.tencent.mobileqq_tool_livelog_" + paramString + ".livelog");
    if (paramString.exists())
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString.getName());
      return a(localFile, localArrayList);
    }
    return "";
  }
  
  String oX(String paramString)
    throws NoSuchAlgorithmException
  {
    Object localObject = MessageDigest.getInstance("SHA-1");
    ((MessageDigest)localObject).update(paramString.getBytes());
    paramString = ((MessageDigest)localObject).digest();
    localObject = new StringBuffer();
    int i = 0;
    while (i < paramString.length)
    {
      String str = Integer.toHexString(paramString[i] & 0xFF);
      if (str.length() < 2) {
        ((StringBuffer)localObject).append(0);
      }
      ((StringBuffer)localObject).append(str);
      i += 1;
    }
    return ((StringBuffer)localObject).toString();
  }
  
  public String oY(String paramString)
    throws UnknownHostException
  {
    return InetAddress.getByName(paramString).getHostAddress();
  }
  
  @Deprecated
  public List<String> r(Context paramContext)
    throws SQLiteException
  {
    if (QbSdk.getTbsVersion(paramContext) < 30000)
    {
      paramContext = SQLiteDatabase.openDatabase(paramContext.getDatabasePath("webviewCache_x5.db").getPath(), null, 1);
      Cursor localCursor = paramContext.query("cache", new String[] { "url" }, null, null, null, null, null);
      ArrayList localArrayList = new ArrayList();
      while (localCursor.moveToNext()) {
        localArrayList.add(localCursor.getString(0));
      }
      localCursor.close();
      paramContext.close();
      return localArrayList;
    }
    return new ArrayList();
  }
  
  Map<String, Object> y(String paramString)
    throws IOException
  {
    Object localObject = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 10000);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject, 10000);
    localObject = new DefaultHttpClient((HttpParams)localObject);
    paramString = new HttpGet(paramString);
    long l1 = System.currentTimeMillis();
    paramString = ((HttpClient)localObject).execute(paramString);
    long l2 = System.currentTimeMillis();
    int i = paramString.getStatusLine().getStatusCode();
    localObject = new HashMap();
    ((Map)localObject).put("status", Integer.valueOf(i));
    ((Map)localObject).put("downloadTime", Long.valueOf(l2 - l1));
    if (i / 100 == 2) {
      ((Map)localObject).put("size", Integer.valueOf(EntityUtils.toByteArray(paramString.getEntity()).length));
    }
    return localObject;
  }
  
  public Handler z()
  {
    return this.dH;
  }
  
  public class a
  {
    final String crT;
    final String crU;
    final int dYb;
    final long delay;
    public final long seq;
    
    public a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
    {
      this.crU = paramString1;
      this.delay = paramLong1;
      this.seq = paramLong2;
      this.crT = paramString2;
      this.dYb = paramInt;
    }
  }
  
  public class b
  {
    public int Gq;
    public long asu;
    public boolean cTg;
    public boolean cTh;
    public String crX;
    public String crY;
    public int dYd;
    public long lz;
    public String network;
    public String operator;
    public String osVersion;
    public String phoneModel;
    
    public b() {}
    
    public JSONObject toJson()
      throws JSONException
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mobile_mode", this.phoneModel);
      localJSONObject.put("os_version", this.osVersion);
      localJSONObject.put("app_version", this.crX);
      localJSONObject.put("net_type", this.network);
      localJSONObject.put("carrier_type", this.operator);
      localJSONObject.put("cpu_num", this.Gq);
      localJSONObject.put("cpu_freq", this.lz);
      localJSONObject.put("total_ram", this.asu);
      localJSONObject.put("cpu_type", this.crY);
      localJSONObject.put("is_proxy", this.cTg);
      localJSONObject.put("is_X5_support", this.cTh);
      localJSONObject.put("X5_version", this.dYd);
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apzu
 * JD-Core Version:    0.7.0.1
 */