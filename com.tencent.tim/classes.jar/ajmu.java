import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin.6;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ajmu
  extends WebViewPlugin
{
  private JsBridgeListener b;
  private boolean cpr;
  private boolean cps;
  private Handler dg = new ajmy(this, Looper.getMainLooper());
  private ajmi.a mCallback = new ajmw(this);
  private ServiceConnection mConn = new ajmv(this);
  private Context mContext;
  private int mCurrentSongDuration;
  private SongInfo mCurrentSongInfo;
  private int mCurrentSongPosition;
  private int mPlayType;
  private BroadcastReceiver mReceiver = new ajmx(this);
  private ajmj mService;
  private Timer mTimer = new Timer();
  
  public ajmu()
  {
    this.mPluginNameSpace = "qqmusic";
  }
  
  public static Bitmap I(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setDoInput(true);
      paramString.connect();
      paramString = BitmapFactory.decodeStream(paramString.getInputStream());
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void X(Bitmap paramBitmap)
  {
    Object localObject;
    if (paramBitmap != null)
    {
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
      paramBitmap = aqgo.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0);
      localObject = "data:image\\/jpg;base64," + paramBitmap;
      paramBitmap = new JSONObject();
    }
    try
    {
      paramBitmap.put("code", "0");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("imgUrl", localObject);
      paramBitmap.put("data", localJSONObject);
      callJs(String.format("try{qqmusicBridge.appTrigger('%s',  %s);}catch(e){}", new Object[] { "DO_MACK_IMG_CALLBACK", paramBitmap }));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private SongInfo[] a(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject == null) {}
    while (!paramJSONObject.has("list")) {
      return null;
    }
    JSONArray localJSONArray = paramJSONObject.getJSONArray("list");
    SongInfo[] arrayOfSongInfo = new SongInfo[localJSONArray.length()];
    int i = 0;
    if (i < localJSONArray.length())
    {
      JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
      label78:
      SongInfo localSongInfo;
      String str;
      label106:
      long l;
      if (localJSONObject != null)
      {
        if (!localJSONObject.has("songId")) {
          break label329;
        }
        paramJSONObject = localJSONObject.getString("songId");
        localSongInfo = new SongInfo();
        if (!localJSONObject.has("songName")) {
          break label336;
        }
        str = localJSONObject.getString("songName");
        localSongInfo.title = str;
        if (!localJSONObject.has("playUrl")) {
          break label344;
        }
        str = localJSONObject.getString("playUrl");
        label132:
        localSongInfo.url = str;
        if (!localJSONObject.has("albumName")) {
          break label352;
        }
        str = localJSONObject.getString("albumName");
        label160:
        localSongInfo.summary = str;
        if (!localJSONObject.has("albumImg")) {
          break label360;
        }
        str = localJSONObject.getString("albumImg");
        label188:
        localSongInfo.coverUrl = str;
        if (!localJSONObject.has("songPage")) {
          break label368;
        }
        str = localJSONObject.getString("songPage");
        label216:
        localSongInfo.detailUrl = str;
        if (!TextUtils.isEmpty(paramJSONObject)) {
          break label376;
        }
        l = 0L;
        label232:
        localSongInfo.id = l;
        if (!localJSONObject.has("albumName")) {
          break label384;
        }
        paramJSONObject = localJSONObject.getString("albumName");
        label258:
        localSongInfo.album = paramJSONObject;
        if (!localJSONObject.has("singerName")) {
          break label391;
        }
        paramJSONObject = localJSONObject.getString("singerName");
        label284:
        localSongInfo.singer = paramJSONObject;
        if (!localJSONObject.has("songmid")) {
          break label398;
        }
      }
      label384:
      label391:
      label398:
      for (paramJSONObject = localJSONObject.getString("songmid");; paramJSONObject = "")
      {
        localSongInfo.mid = paramJSONObject;
        arrayOfSongInfo[i] = localSongInfo;
        i += 1;
        break;
        label329:
        paramJSONObject = "";
        break label78;
        label336:
        str = "";
        break label106;
        label344:
        str = "";
        break label132;
        label352:
        str = "";
        break label160;
        label360:
        str = "";
        break label188;
        label368:
        str = "";
        break label216;
        label376:
        l = Long.parseLong(paramJSONObject);
        break label232;
        paramJSONObject = "";
        break label258;
        paramJSONObject = "";
        break label284;
      }
    }
    return arrayOfSongInfo;
  }
  
  /* Error */
  private boolean arc()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iload 6
    //   5: istore 5
    //   7: aload_0
    //   8: getfield 309	ajmu:cps	Z
    //   11: ifeq +284 -> 295
    //   14: aload_0
    //   15: invokespecial 313	ajmu:getCurrentSongInfo	()Lcom/tencent/mobileqq/music/SongInfo;
    //   18: astore 7
    //   20: aload_0
    //   21: getfield 193	ajmu:mService	Lajmj;
    //   24: ifnull +452 -> 476
    //   27: aload_0
    //   28: getfield 193	ajmu:mService	Lajmj;
    //   31: invokeinterface 318 1 0
    //   36: istore_1
    //   37: aload_0
    //   38: invokespecial 321	ajmu:getCurrentSongDuration	()I
    //   41: istore_3
    //   42: iload_1
    //   43: istore 4
    //   45: aload 7
    //   47: astore 9
    //   49: ldc 161
    //   51: astore 8
    //   53: aload_0
    //   54: getfield 193	ajmu:mService	Lajmj;
    //   57: ifnull +407 -> 464
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 193	ajmu:mService	Lajmj;
    //   65: invokeinterface 324 1 0
    //   70: invokespecial 328	ajmu:io	(I)I
    //   73: istore_1
    //   74: aload 8
    //   76: astore 7
    //   78: aload_0
    //   79: getfield 193	ajmu:mService	Lajmj;
    //   82: invokeinterface 332 1 0
    //   87: astore 10
    //   89: aload 10
    //   91: ifnull +367 -> 458
    //   94: aload 8
    //   96: astore 7
    //   98: aload 10
    //   100: ldc_w 334
    //   103: invokevirtual 337	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 8
    //   108: aload 8
    //   110: astore 7
    //   112: new 156	org/json/JSONObject
    //   115: dup
    //   116: aload 10
    //   118: ldc 169
    //   120: invokevirtual 337	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   123: invokespecial 338	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   126: astore 10
    //   128: aload 10
    //   130: astore 7
    //   132: aload 7
    //   134: ifnonnull +321 -> 455
    //   137: new 156	org/json/JSONObject
    //   140: dup
    //   141: invokespecial 157	org/json/JSONObject:<init>	()V
    //   144: astore 7
    //   146: iload 6
    //   148: istore 5
    //   150: aload 9
    //   152: ifnull +143 -> 295
    //   155: aload_0
    //   156: getfield 193	ajmu:mService	Lajmj;
    //   159: ifnull +322 -> 481
    //   162: aload_0
    //   163: getfield 193	ajmu:mService	Lajmj;
    //   166: invokeinterface 332 1 0
    //   171: astore 10
    //   173: aload 10
    //   175: ifnull +174 -> 349
    //   178: aload 10
    //   180: ldc_w 340
    //   183: iconst_0
    //   184: invokevirtual 344	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   187: istore_2
    //   188: aload_0
    //   189: aload 9
    //   191: invokespecial 347	ajmu:b	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   194: astore 9
    //   196: aload 9
    //   198: ifnull +166 -> 364
    //   201: aload 9
    //   203: invokevirtual 351	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   206: astore 10
    //   208: aload 10
    //   210: invokeinterface 356 1 0
    //   215: ifeq +149 -> 364
    //   218: aload 10
    //   220: invokeinterface 360 1 0
    //   225: checkcast 177	java/lang/String
    //   228: astore 11
    //   230: aload 7
    //   232: aload 11
    //   234: aload 9
    //   236: aload 11
    //   238: invokevirtual 363	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   241: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   244: pop
    //   245: goto -37 -> 208
    //   248: astore 8
    //   250: aload 8
    //   252: invokevirtual 364	java/lang/Exception:printStackTrace	()V
    //   255: iload 6
    //   257: istore 5
    //   259: aload 7
    //   261: ifnull +34 -> 295
    //   264: aload_0
    //   265: ldc_w 366
    //   268: iconst_2
    //   269: anewarray 173	java/lang/Object
    //   272: dup
    //   273: iconst_0
    //   274: ldc_w 368
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: aload 7
    //   282: invokevirtual 369	org/json/JSONObject:toString	()Ljava/lang/String;
    //   285: aastore
    //   286: invokestatic 181	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   289: invokevirtual 184	ajmu:callJs	(Ljava/lang/String;)V
    //   292: iconst_1
    //   293: istore 5
    //   295: iload 5
    //   297: ireturn
    //   298: astore 8
    //   300: aconst_null
    //   301: astore 7
    //   303: iconst_0
    //   304: istore_1
    //   305: aload 8
    //   307: invokevirtual 364	java/lang/Exception:printStackTrace	()V
    //   310: iconst_0
    //   311: istore_3
    //   312: aload 7
    //   314: astore 9
    //   316: iload_1
    //   317: istore 4
    //   319: goto -270 -> 49
    //   322: astore 8
    //   324: ldc 161
    //   326: astore 7
    //   328: iconst_0
    //   329: istore_1
    //   330: aload 8
    //   332: invokevirtual 364	java/lang/Exception:printStackTrace	()V
    //   335: aconst_null
    //   336: astore 10
    //   338: aload 7
    //   340: astore 8
    //   342: aload 10
    //   344: astore 7
    //   346: goto -214 -> 132
    //   349: iconst_0
    //   350: istore_2
    //   351: goto -163 -> 188
    //   354: astore 10
    //   356: aload 10
    //   358: invokevirtual 364	java/lang/Exception:printStackTrace	()V
    //   361: goto +120 -> 481
    //   364: aload 7
    //   366: ldc_w 371
    //   369: iload 4
    //   371: sipush 1000
    //   374: idiv
    //   375: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   378: pop
    //   379: aload 7
    //   381: ldc_w 376
    //   384: iload_3
    //   385: sipush 1000
    //   388: idiv
    //   389: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   392: pop
    //   393: aload 7
    //   395: ldc_w 378
    //   398: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   401: ifne +14 -> 415
    //   404: aload 7
    //   406: ldc_w 378
    //   409: aload 8
    //   411: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   414: pop
    //   415: aload 7
    //   417: ldc_w 380
    //   420: iload_1
    //   421: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   424: pop
    //   425: aload 7
    //   427: ldc_w 382
    //   430: iload_2
    //   431: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   434: pop
    //   435: goto -180 -> 255
    //   438: astore 8
    //   440: goto -110 -> 330
    //   443: astore 8
    //   445: iconst_0
    //   446: istore_1
    //   447: goto -142 -> 305
    //   450: astore 8
    //   452: goto -147 -> 305
    //   455: goto -309 -> 146
    //   458: aconst_null
    //   459: astore 7
    //   461: goto -329 -> 132
    //   464: iconst_0
    //   465: istore_1
    //   466: aconst_null
    //   467: astore 7
    //   469: ldc 161
    //   471: astore 8
    //   473: goto -341 -> 132
    //   476: iconst_0
    //   477: istore_1
    //   478: goto -441 -> 37
    //   481: iconst_0
    //   482: istore_2
    //   483: goto -295 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	this	ajmu
    //   36	442	1	i	int
    //   187	296	2	j	int
    //   41	348	3	k	int
    //   43	332	4	m	int
    //   5	291	5	bool1	boolean
    //   1	255	6	bool2	boolean
    //   18	450	7	localObject1	Object
    //   51	58	8	str1	String
    //   248	3	8	localException1	Exception
    //   298	8	8	localException2	Exception
    //   322	9	8	localException3	Exception
    //   340	70	8	localObject2	Object
    //   438	1	8	localException4	Exception
    //   443	1	8	localException5	Exception
    //   450	1	8	localException6	Exception
    //   471	1	8	str2	String
    //   47	268	9	localObject3	Object
    //   87	256	10	localObject4	Object
    //   354	3	10	localException7	Exception
    //   228	9	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   188	196	248	java/lang/Exception
    //   201	208	248	java/lang/Exception
    //   208	245	248	java/lang/Exception
    //   356	361	248	java/lang/Exception
    //   364	415	248	java/lang/Exception
    //   415	435	248	java/lang/Exception
    //   14	20	298	java/lang/Exception
    //   60	74	322	java/lang/Exception
    //   155	173	354	java/lang/Exception
    //   178	188	354	java/lang/Exception
    //   78	89	438	java/lang/Exception
    //   98	108	438	java/lang/Exception
    //   112	128	438	java/lang/Exception
    //   20	37	443	java/lang/Exception
    //   37	42	450	java/lang/Exception
  }
  
  private boolean ard()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mService != null) {}
    try
    {
      String str1 = this.mService.getToken();
      String str2 = fk();
      bool1 = bool2;
      if (!TextUtils.isEmpty(str1))
      {
        boolean bool3 = str1.equals(str2);
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return false;
  }
  
  private boolean are()
  {
    return (1 == this.mPlayType) || (2 == this.mPlayType);
  }
  
  private HashMap<String, JSONObject> b(JSONArray paramJSONArray)
  {
    localHashMap = new HashMap();
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
        if (localJSONObject != null) {
          localHashMap.put(localJSONObject.getString("songId"), localJSONObject);
        }
        i += 1;
      }
      return localHashMap;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  private JSONObject b(SongInfo paramSongInfo)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramSongInfo != null)
    {
      localJSONObject.put("playUrl", paramSongInfo.url);
      localJSONObject.put("songPage", paramSongInfo.detailUrl);
      localJSONObject.put("songId", paramSongInfo.id);
      localJSONObject.put("songName", paramSongInfo.title);
      localJSONObject.put("singerName", paramSongInfo.singer);
      localJSONObject.put("albumName", paramSongInfo.album);
      localJSONObject.put("albumImg", paramSongInfo.coverUrl);
    }
    return localJSONObject;
  }
  
  private void bindQQPlayerService()
  {
    try
    {
      if (this.mRuntime != null)
      {
        Activity localActivity = this.mRuntime.getActivity();
        if ((localActivity != null) && (this.mService == null))
        {
          localActivity.bindService(new Intent(localActivity, QQPlayerService.class), this.mConn, 33);
          QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService end!");
          return;
        }
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService activity is null!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService exception", localException);
      return;
    }
    QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService mRuntime is null!");
  }
  
  private void dyu()
  {
    MusicGeneWebViewPlugin.6 local6 = new MusicGeneWebViewPlugin.6(this);
    this.mTimer.schedule(local6, 1000L, 1000L);
  }
  
  private void dyv()
  {
    this.mTimer.cancel();
  }
  
  private void dyw()
  {
    callJs(String.format("try{qqmusicBridge.appTrigger('%s');}catch(e){}", new Object[] { "CALLPAGE_SHARE" }));
  }
  
  private String fk()
  {
    try
    {
      if (are()) {
        return ajmz.getToken();
      }
      String str = this.mService.I(3, "MusicGeneWebViewPlugin");
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private int getCurrentSongDuration()
  {
    if ((this.mCurrentSongDuration <= 0) && (this.mService != null)) {}
    try
    {
      this.mCurrentSongDuration = this.mService.getDuration();
      return this.mCurrentSongDuration;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
  }
  
  private SongInfo getCurrentSongInfo()
  {
    SongInfo localSongInfo2 = this.mCurrentSongInfo;
    SongInfo localSongInfo1 = localSongInfo2;
    if (localSongInfo2 == null)
    {
      localSongInfo1 = localSongInfo2;
      if (this.mService == null) {}
    }
    try
    {
      localSongInfo1 = this.mService.a();
      return localSongInfo1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localSongInfo2;
  }
  
  private int in(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return 103;
    case 0: 
      return 102;
    }
    return 101;
  }
  
  private int io(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 1: 
      return 4;
    case 3: 
      return 2;
    }
    return -1001;
  }
  
  private boolean kw(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = this.mService;
    boolean bool1 = bool2;
    if (this.cpr)
    {
      bool1 = bool2;
      if (localObject == null) {}
    }
    try
    {
      i = ((ajmj)localObject).iH();
      int j = io(paramInt);
      localObject = new JSONObject();
      try
      {
        Bundle localBundle = this.mService.getExtras();
        if (localBundle == null) {
          break label180;
        }
        paramInt = localBundle.getInt("BUNDLE_KEY_PLAY_TYPE", 0);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          paramInt = 0;
          continue;
          localRemoteException.put("code", "0");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      ((JSONObject)localObject).put("state", j);
      ((JSONObject)localObject).put("index", i);
      ((JSONObject)localObject).put("playType", paramInt);
      if (ard())
      {
        ((JSONObject)localObject).put("code", "0");
        bool1 = bool2;
        if (localObject != null)
        {
          callJs(String.format("try{qqmusicBridge.appTrigger('%s', %s);}catch(e){}", new Object[] { "CALLPAGE_SONG_STATE_CHANGE", ((JSONObject)localObject).toString() }));
          bool1 = true;
        }
        return bool1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
        int i = 0;
        continue;
        label180:
        paramInt = 0;
      }
    }
  }
  
  public static boolean nv(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return bool1;
      }
      paramString = Uri.parse(paramString);
      String str = paramString.getScheme();
      if (("http".equalsIgnoreCase(str)) || ("https".equalsIgnoreCase(str)))
      {
        paramString = paramString.getHost();
        bool1 = bool2;
        if (TextUtils.isEmpty(paramString)) {
          return bool1;
        }
        if ((!paramString.contains("y.qq.com")) && (!paramString.contains("music.qq.com")) && (!paramString.contains("imgcache.gtimg.cn")) && (!paramString.contains("article.mp.qq.com")))
        {
          bool1 = bool2;
          if (!paramString.contains("post.mp.qq.com")) {
            return bool1;
          }
        }
      }
      else
      {
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.isURLBelongToQQMusic urlString is not url!");
        return false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.isURLBelongToQQMusic exception: " + paramString);
      return false;
    }
    bool1 = true;
    return bool1;
  }
  
  private void unbindQQPlayerService()
  {
    try
    {
      if (this.mRuntime != null)
      {
        Activity localActivity = this.mRuntime.getActivity();
        if (localActivity != null) {
          localActivity.unbindService(this.mConn);
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934594L) && (this.mContext != null))
    {
      Intent localIntent = new Intent("BROAD_CAST_UPDATE_TITLE");
      localIntent.putExtra("BUNDLE_KEY_URL", paramString);
      this.mContext.sendBroadcast(localIntent, "com.tencent.music.data.permission");
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  /* Error */
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: new 574	java/util/ArrayList
    //   3: dup
    //   4: aload 5
    //   6: invokestatic 580	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   9: invokespecial 583	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   12: astore 20
    //   14: ldc 70
    //   16: aload_3
    //   17: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +2907 -> 2927
    //   23: ldc_w 585
    //   26: aload 4
    //   28: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq +2693 -> 2724
    //   34: aload 20
    //   36: iconst_0
    //   37: invokevirtual 586	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   40: checkcast 177	java/lang/String
    //   43: astore_2
    //   44: new 156	org/json/JSONObject
    //   47: dup
    //   48: aload_2
    //   49: invokespecial 338	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   52: astore_2
    //   53: aload_2
    //   54: ldc_w 588
    //   57: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   60: ifeq +107 -> 167
    //   63: aload_2
    //   64: ldc_w 588
    //   67: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore_3
    //   71: aload_2
    //   72: ldc 169
    //   74: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   77: ifeq +2927 -> 3004
    //   80: aload_2
    //   81: ldc 169
    //   83: invokevirtual 592	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   86: astore_2
    //   87: aload_2
    //   88: ifnull +66 -> 154
    //   91: aload_2
    //   92: ldc_w 382
    //   95: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   98: ifeq +56 -> 154
    //   101: aload_0
    //   102: aload_2
    //   103: ldc_w 382
    //   106: invokevirtual 595	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   109: putfield 399	ajmu:mPlayType	I
    //   112: ldc_w 597
    //   115: aload_3
    //   116: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   119: istore 13
    //   121: iload 13
    //   123: ifeq +86 -> 209
    //   126: ldc_w 437
    //   129: iconst_1
    //   130: ldc_w 599
    //   133: invokestatic 445	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: aload_0
    //   137: getfield 193	ajmu:mService	Lajmj;
    //   140: ifnonnull +29 -> 169
    //   143: aload_0
    //   144: aload_1
    //   145: putfield 201	ajmu:b	Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;
    //   148: aload_0
    //   149: invokespecial 601	ajmu:bindQQPlayerService	()V
    //   152: iconst_1
    //   153: ireturn
    //   154: aload_0
    //   155: iconst_0
    //   156: putfield 399	ajmu:mPlayType	I
    //   159: goto -47 -> 112
    //   162: astore_1
    //   163: aload_1
    //   164: invokevirtual 364	java/lang/Exception:printStackTrace	()V
    //   167: iconst_1
    //   168: ireturn
    //   169: new 156	org/json/JSONObject
    //   172: dup
    //   173: invokespecial 157	org/json/JSONObject:<init>	()V
    //   176: astore_2
    //   177: aload_2
    //   178: ldc 159
    //   180: ldc 161
    //   182: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   185: pop
    //   186: aload_1
    //   187: aload_2
    //   188: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   191: goto -39 -> 152
    //   194: astore_1
    //   195: ldc_w 437
    //   198: iconst_1
    //   199: ldc_w 609
    //   202: aload_1
    //   203: invokestatic 452	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   206: goto -54 -> 152
    //   209: aload_0
    //   210: getfield 193	ajmu:mService	Lajmj;
    //   213: astore 21
    //   215: aload 21
    //   217: ifnonnull +5 -> 222
    //   220: iconst_0
    //   221: ireturn
    //   222: ldc_w 611
    //   225: aload_3
    //   226: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   229: ifeq +413 -> 642
    //   232: ldc_w 613
    //   235: astore_3
    //   236: aload_0
    //   237: aload_2
    //   238: invokespecial 615	ajmu:a	(Lorg/json/JSONObject;)[Lcom/tencent/mobileqq/music/SongInfo;
    //   241: astore 5
    //   243: aload 5
    //   245: ifnull +353 -> 598
    //   248: iconst_0
    //   249: istore 8
    //   251: ldc 161
    //   253: astore_3
    //   254: lconst_0
    //   255: lstore 14
    //   257: aconst_null
    //   258: astore 4
    //   260: aload_2
    //   261: ldc_w 493
    //   264: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   267: ifeq +12 -> 279
    //   270: aload_2
    //   271: ldc_w 493
    //   274: invokevirtual 595	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   277: istore 8
    //   279: aload_2
    //   280: ldc_w 378
    //   283: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   286: ifeq +11 -> 297
    //   289: aload_2
    //   290: ldc_w 378
    //   293: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   296: astore_3
    //   297: aload_2
    //   298: ldc_w 617
    //   301: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   304: ifeq +12 -> 316
    //   307: aload_2
    //   308: ldc_w 617
    //   311: invokevirtual 620	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   314: lstore 14
    //   316: aload_2
    //   317: ldc_w 622
    //   320: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   323: ifeq +11 -> 334
    //   326: aload_2
    //   327: ldc_w 622
    //   330: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   333: pop
    //   334: aload_2
    //   335: ldc 221
    //   337: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   340: ifeq +11 -> 351
    //   343: aload_2
    //   344: ldc 221
    //   346: invokevirtual 229	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   349: astore 4
    //   351: lload 14
    //   353: invokestatic 626	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   356: astore 22
    //   358: new 424	android/content/Intent
    //   361: dup
    //   362: aload_0
    //   363: getfield 550	ajmu:mContext	Landroid/content/Context;
    //   366: ldc_w 628
    //   369: invokespecial 429	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   372: astore 20
    //   374: ldc_w 630
    //   377: iconst_1
    //   378: anewarray 173	java/lang/Object
    //   381: dup
    //   382: iconst_0
    //   383: aload 22
    //   385: aastore
    //   386: invokestatic 181	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   389: astore 23
    //   391: aload 20
    //   393: ldc_w 617
    //   396: aload 22
    //   398: invokevirtual 559	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   401: pop
    //   402: aload 20
    //   404: ldc_w 631
    //   407: aload 23
    //   409: invokevirtual 559	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   412: pop
    //   413: aload 20
    //   415: ldc_w 633
    //   418: iconst_1
    //   419: invokevirtual 636	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   422: pop
    //   423: aload_2
    //   424: ldc_w 638
    //   427: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   430: ifeq +31 -> 461
    //   433: aload_2
    //   434: ldc_w 638
    //   437: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   440: astore 22
    //   442: aload 22
    //   444: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   447: ifne +14 -> 461
    //   450: aload 20
    //   452: ldc_w 631
    //   455: aload 22
    //   457: invokevirtual 559	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   460: pop
    //   461: new 336	android/os/Bundle
    //   464: dup
    //   465: invokespecial 639	android/os/Bundle:<init>	()V
    //   468: astore 22
    //   470: aload 22
    //   472: ldc_w 641
    //   475: lload 14
    //   477: invokevirtual 645	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   480: aload 22
    //   482: ldc_w 334
    //   485: aload_3
    //   486: invokevirtual 649	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload 22
    //   491: ldc_w 340
    //   494: aload_0
    //   495: getfield 399	ajmu:mPlayType	I
    //   498: invokevirtual 653	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   501: aload 4
    //   503: ifnull +16 -> 519
    //   506: aload 22
    //   508: ldc_w 655
    //   511: aload 4
    //   513: invokevirtual 656	org/json/JSONArray:toString	()Ljava/lang/String;
    //   516: invokevirtual 649	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: aload 22
    //   521: ldc 169
    //   523: aload_2
    //   524: invokevirtual 369	org/json/JSONObject:toString	()Ljava/lang/String;
    //   527: invokevirtual 649	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: aload 21
    //   532: aload 22
    //   534: invokeinterface 660 2 0
    //   539: aload 21
    //   541: aload_0
    //   542: getfield 50	ajmu:mCallback	Lajmi$a;
    //   545: invokeinterface 663 2 0
    //   550: aload 20
    //   552: ifnull +12 -> 564
    //   555: aload 21
    //   557: aload 20
    //   559: invokeinterface 667 2 0
    //   564: aload_0
    //   565: invokespecial 474	ajmu:are	()Z
    //   568: ifeq +54 -> 622
    //   571: aload 21
    //   573: bipush 102
    //   575: invokeinterface 671 2 0
    //   580: aload 21
    //   582: aload_0
    //   583: invokespecial 391	ajmu:fk	()Ljava/lang/String;
    //   586: aload 5
    //   588: iload 8
    //   590: invokeinterface 674 4 0
    //   595: ldc 161
    //   597: astore_3
    //   598: new 156	org/json/JSONObject
    //   601: dup
    //   602: invokespecial 157	org/json/JSONObject:<init>	()V
    //   605: astore_2
    //   606: aload_2
    //   607: ldc 159
    //   609: aload_3
    //   610: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   613: pop
    //   614: aload_1
    //   615: aload_2
    //   616: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   619: goto -452 -> 167
    //   622: aload 21
    //   624: bipush 103
    //   626: invokeinterface 671 2 0
    //   631: goto -51 -> 580
    //   634: astore_2
    //   635: aload_2
    //   636: invokevirtual 364	java/lang/Exception:printStackTrace	()V
    //   639: goto -44 -> 595
    //   642: ldc_w 676
    //   645: aload_3
    //   646: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   649: ifeq +46 -> 695
    //   652: aload_0
    //   653: aload 21
    //   655: invokeinterface 318 1 0
    //   660: putfield 678	ajmu:mCurrentSongPosition	I
    //   663: aload 21
    //   665: invokeinterface 681 1 0
    //   670: new 156	org/json/JSONObject
    //   673: dup
    //   674: invokespecial 157	org/json/JSONObject:<init>	()V
    //   677: astore_2
    //   678: aload_2
    //   679: ldc 159
    //   681: ldc 161
    //   683: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   686: pop
    //   687: aload_1
    //   688: aload_2
    //   689: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   692: goto -525 -> 167
    //   695: ldc_w 683
    //   698: aload_3
    //   699: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   702: ifeq +35 -> 737
    //   705: aload 21
    //   707: invokeinterface 686 1 0
    //   712: new 156	org/json/JSONObject
    //   715: dup
    //   716: invokespecial 157	org/json/JSONObject:<init>	()V
    //   719: astore_2
    //   720: aload_2
    //   721: ldc 159
    //   723: ldc 161
    //   725: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   728: pop
    //   729: aload_1
    //   730: aload_2
    //   731: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   734: goto -567 -> 167
    //   737: ldc_w 688
    //   740: aload_3
    //   741: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   744: ifeq +35 -> 779
    //   747: aload 21
    //   749: invokeinterface 691 1 0
    //   754: new 156	org/json/JSONObject
    //   757: dup
    //   758: invokespecial 157	org/json/JSONObject:<init>	()V
    //   761: astore_2
    //   762: aload_2
    //   763: ldc 159
    //   765: ldc 161
    //   767: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   770: pop
    //   771: aload_1
    //   772: aload_2
    //   773: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   776: goto -609 -> 167
    //   779: ldc_w 693
    //   782: aload_3
    //   783: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   786: ifeq +35 -> 821
    //   789: aload 21
    //   791: invokeinterface 696 1 0
    //   796: new 156	org/json/JSONObject
    //   799: dup
    //   800: invokespecial 157	org/json/JSONObject:<init>	()V
    //   803: astore_2
    //   804: aload_2
    //   805: ldc 159
    //   807: ldc 161
    //   809: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   812: pop
    //   813: aload_1
    //   814: aload_2
    //   815: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   818: goto -651 -> 167
    //   821: ldc_w 698
    //   824: aload_3
    //   825: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   828: ifeq +35 -> 863
    //   831: aload 21
    //   833: invokeinterface 701 1 0
    //   838: new 156	org/json/JSONObject
    //   841: dup
    //   842: invokespecial 157	org/json/JSONObject:<init>	()V
    //   845: astore_2
    //   846: aload_2
    //   847: ldc 159
    //   849: ldc 161
    //   851: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   854: pop
    //   855: aload_1
    //   856: aload_2
    //   857: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   860: goto -693 -> 167
    //   863: ldc_w 703
    //   866: aload_3
    //   867: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   870: istore 13
    //   872: iload 13
    //   874: ifeq +424 -> 1298
    //   877: aconst_null
    //   878: astore_2
    //   879: aload 21
    //   881: invokeinterface 332 1 0
    //   886: astore_3
    //   887: aload_3
    //   888: ifnull +2111 -> 2999
    //   891: aload_3
    //   892: astore_2
    //   893: aload_3
    //   894: ldc 169
    //   896: invokevirtual 706	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   899: ifeq +2100 -> 2999
    //   902: aload_3
    //   903: astore_2
    //   904: new 156	org/json/JSONObject
    //   907: dup
    //   908: aload_3
    //   909: ldc 169
    //   911: invokevirtual 337	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   914: invokespecial 338	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   917: astore 4
    //   919: aload 4
    //   921: astore_2
    //   922: aload_3
    //   923: astore 4
    //   925: aload_2
    //   926: ifnonnull +2068 -> 2994
    //   929: new 156	org/json/JSONObject
    //   932: dup
    //   933: invokespecial 157	org/json/JSONObject:<init>	()V
    //   936: astore_3
    //   937: aload_0
    //   938: invokespecial 313	ajmu:getCurrentSongInfo	()Lcom/tencent/mobileqq/music/SongInfo;
    //   941: astore 20
    //   943: aload 4
    //   945: ifnull +2064 -> 3009
    //   948: aload 4
    //   950: ldc_w 340
    //   953: iconst_0
    //   954: invokevirtual 344	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   957: istore 8
    //   959: aload 4
    //   961: ifnull +2054 -> 3015
    //   964: aload 4
    //   966: ldc_w 641
    //   969: invokevirtual 706	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   972: ifeq +2043 -> 3015
    //   975: aload 4
    //   977: ldc_w 641
    //   980: invokevirtual 707	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   983: lstore 14
    //   985: aload 20
    //   987: ifnull +288 -> 1275
    //   990: aconst_null
    //   991: astore 5
    //   993: aload 5
    //   995: astore_2
    //   996: aload 4
    //   998: ifnull +51 -> 1049
    //   1001: aload 5
    //   1003: astore_2
    //   1004: aload 4
    //   1006: ldc_w 655
    //   1009: invokevirtual 706	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1012: ifeq +37 -> 1049
    //   1015: aload_0
    //   1016: new 231	org/json/JSONArray
    //   1019: dup
    //   1020: aload 4
    //   1022: ldc_w 655
    //   1025: invokevirtual 337	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1028: invokespecial 708	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   1031: invokespecial 710	ajmu:b	(Lorg/json/JSONArray;)Ljava/util/HashMap;
    //   1034: aload 20
    //   1036: getfield 283	com/tencent/mobileqq/music/SongInfo:id	J
    //   1039: invokestatic 626	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1042: invokevirtual 713	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1045: checkcast 156	org/json/JSONObject
    //   1048: astore_2
    //   1049: aload_2
    //   1050: ifnonnull +1941 -> 2991
    //   1053: aload_0
    //   1054: aload 20
    //   1056: invokespecial 347	ajmu:b	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   1059: astore_2
    //   1060: aload_2
    //   1061: ifnull +60 -> 1121
    //   1064: aload_2
    //   1065: invokevirtual 351	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   1068: astore 4
    //   1070: aload 4
    //   1072: invokeinterface 356 1 0
    //   1077: ifeq +44 -> 1121
    //   1080: aload 4
    //   1082: invokeinterface 360 1 0
    //   1087: checkcast 177	java/lang/String
    //   1090: astore 5
    //   1092: aload_3
    //   1093: aload 5
    //   1095: aload_2
    //   1096: aload 5
    //   1098: invokevirtual 363	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1101: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1104: pop
    //   1105: goto -35 -> 1070
    //   1108: astore_3
    //   1109: aload_3
    //   1110: invokevirtual 364	java/lang/Exception:printStackTrace	()V
    //   1113: aload_2
    //   1114: astore 4
    //   1116: aconst_null
    //   1117: astore_2
    //   1118: goto -193 -> 925
    //   1121: aload_0
    //   1122: invokespecial 321	ajmu:getCurrentSongDuration	()I
    //   1125: i2l
    //   1126: lstore 18
    //   1128: aload 21
    //   1130: invokeinterface 324 1 0
    //   1135: istore 9
    //   1137: aload_0
    //   1138: iload 9
    //   1140: invokespecial 328	ajmu:io	(I)I
    //   1143: istore 10
    //   1145: iload 9
    //   1147: iconst_3
    //   1148: if_icmpne +102 -> 1250
    //   1151: aload_0
    //   1152: getfield 678	ajmu:mCurrentSongPosition	I
    //   1155: i2l
    //   1156: lstore 16
    //   1158: aload_0
    //   1159: invokespecial 495	ajmu:ard	()Z
    //   1162: ifeq +101 -> 1263
    //   1165: aload_3
    //   1166: ldc 159
    //   1168: ldc 161
    //   1170: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1173: pop
    //   1174: aload_3
    //   1175: ldc_w 371
    //   1178: lload 16
    //   1180: ldc2_w 459
    //   1183: ldiv
    //   1184: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1187: pop
    //   1188: aload_3
    //   1189: ldc_w 376
    //   1192: lload 18
    //   1194: ldc2_w 459
    //   1197: ldiv
    //   1198: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1201: pop
    //   1202: aload_3
    //   1203: ldc_w 380
    //   1206: iload 10
    //   1208: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1211: pop
    //   1212: aload_3
    //   1213: ldc_w 382
    //   1216: iload 8
    //   1218: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1221: pop
    //   1222: aload_3
    //   1223: ldc_w 617
    //   1226: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1229: ifne +13 -> 1242
    //   1232: aload_3
    //   1233: ldc_w 617
    //   1236: lload 14
    //   1238: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1241: pop
    //   1242: aload_1
    //   1243: aload_3
    //   1244: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   1247: goto -1080 -> 167
    //   1250: aload 21
    //   1252: invokeinterface 318 1 0
    //   1257: i2l
    //   1258: lstore 16
    //   1260: goto -102 -> 1158
    //   1263: aload_3
    //   1264: ldc 159
    //   1266: ldc 161
    //   1268: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1271: pop
    //   1272: goto -98 -> 1174
    //   1275: aload_3
    //   1276: ldc 159
    //   1278: ldc_w 613
    //   1281: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1284: pop
    //   1285: aload_3
    //   1286: ldc_w 382
    //   1289: iload 8
    //   1291: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1294: pop
    //   1295: goto -73 -> 1222
    //   1298: ldc_w 715
    //   1301: aload_3
    //   1302: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1305: istore 13
    //   1307: iload 13
    //   1309: ifeq +524 -> 1833
    //   1312: aconst_null
    //   1313: astore_2
    //   1314: aload 21
    //   1316: invokeinterface 332 1 0
    //   1321: astore_3
    //   1322: aload_3
    //   1323: ifnull +1663 -> 2986
    //   1326: aload_3
    //   1327: astore_2
    //   1328: aload_3
    //   1329: ldc 169
    //   1331: invokevirtual 706	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1334: ifeq +1652 -> 2986
    //   1337: aload_3
    //   1338: astore_2
    //   1339: new 156	org/json/JSONObject
    //   1342: dup
    //   1343: aload_3
    //   1344: ldc 169
    //   1346: invokevirtual 337	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1349: invokespecial 338	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1352: astore 4
    //   1354: aload 4
    //   1356: astore_2
    //   1357: aload_3
    //   1358: astore 5
    //   1360: aload_2
    //   1361: ifnonnull +1619 -> 2980
    //   1364: new 156	org/json/JSONObject
    //   1367: dup
    //   1368: invokespecial 157	org/json/JSONObject:<init>	()V
    //   1371: astore 4
    //   1373: aload 5
    //   1375: ifnull +1659 -> 3034
    //   1378: aload 5
    //   1380: ldc_w 340
    //   1383: iconst_0
    //   1384: invokevirtual 344	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1387: istore 11
    //   1389: aload 5
    //   1391: ifnull +1649 -> 3040
    //   1394: aload 5
    //   1396: ldc_w 641
    //   1399: invokevirtual 706	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1402: ifeq +1638 -> 3040
    //   1405: aload 5
    //   1407: ldc_w 641
    //   1410: invokevirtual 707	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1413: lstore 14
    //   1415: aconst_null
    //   1416: astore 20
    //   1418: ldc 161
    //   1420: astore_3
    //   1421: aload 5
    //   1423: ifnull +1551 -> 2974
    //   1426: aload 5
    //   1428: ldc_w 334
    //   1431: invokevirtual 706	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1434: ifeq +1612 -> 3046
    //   1437: aload 5
    //   1439: ldc_w 334
    //   1442: invokevirtual 337	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1445: astore_2
    //   1446: aload_2
    //   1447: astore_3
    //   1448: aload 5
    //   1450: ldc_w 655
    //   1453: invokevirtual 706	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1456: ifeq +1518 -> 2974
    //   1459: new 231	org/json/JSONArray
    //   1462: dup
    //   1463: aload 5
    //   1465: ldc_w 655
    //   1468: invokevirtual 337	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1471: invokespecial 708	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   1474: astore 5
    //   1476: aload_2
    //   1477: astore_3
    //   1478: aload 5
    //   1480: astore_2
    //   1481: iconst_0
    //   1482: istore 12
    //   1484: iconst_0
    //   1485: istore 10
    //   1487: iconst_0
    //   1488: istore 8
    //   1490: iconst_0
    //   1491: istore 9
    //   1493: aload_2
    //   1494: ifnonnull +246 -> 1740
    //   1497: new 231	org/json/JSONArray
    //   1500: dup
    //   1501: invokespecial 716	org/json/JSONArray:<init>	()V
    //   1504: astore_2
    //   1505: aload 21
    //   1507: invokeinterface 719 1 0
    //   1512: astore 5
    //   1514: aload_0
    //   1515: invokespecial 313	ajmu:getCurrentSongInfo	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1518: astore 20
    //   1520: iload 8
    //   1522: istore 10
    //   1524: aload 5
    //   1526: ifnull +1526 -> 3052
    //   1529: iconst_0
    //   1530: istore 8
    //   1532: iload 9
    //   1534: istore 10
    //   1536: iload 8
    //   1538: aload 5
    //   1540: arraylength
    //   1541: if_icmpge +1511 -> 3052
    //   1544: aload 5
    //   1546: iload 8
    //   1548: aaload
    //   1549: astore 22
    //   1551: iload 9
    //   1553: istore 10
    //   1555: aload 22
    //   1557: ifnull +1464 -> 3021
    //   1560: aload_2
    //   1561: iload 8
    //   1563: aload_0
    //   1564: aload 22
    //   1566: invokespecial 347	ajmu:b	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   1569: invokevirtual 722	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   1572: pop
    //   1573: iload 9
    //   1575: istore 10
    //   1577: aload 20
    //   1579: ifnull +1442 -> 3021
    //   1582: iload 9
    //   1584: istore 10
    //   1586: aload 22
    //   1588: getfield 283	com/tencent/mobileqq/music/SongInfo:id	J
    //   1591: aload 20
    //   1593: getfield 283	com/tencent/mobileqq/music/SongInfo:id	J
    //   1596: lcmp
    //   1597: ifne +1424 -> 3021
    //   1600: iload 8
    //   1602: istore 10
    //   1604: goto +1417 -> 3021
    //   1607: astore_3
    //   1608: aload_3
    //   1609: invokevirtual 364	java/lang/Exception:printStackTrace	()V
    //   1612: aload_2
    //   1613: astore 5
    //   1615: aconst_null
    //   1616: astore_2
    //   1617: goto -257 -> 1360
    //   1620: aload 4
    //   1622: ldc_w 493
    //   1625: iload 8
    //   1627: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1630: pop
    //   1631: aload 4
    //   1633: ldc_w 380
    //   1636: aload_0
    //   1637: aload 21
    //   1639: invokeinterface 324 1 0
    //   1644: invokespecial 328	ajmu:io	(I)I
    //   1647: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1650: pop
    //   1651: aload 4
    //   1653: ldc_w 378
    //   1656: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1659: ifne +13 -> 1672
    //   1662: aload 4
    //   1664: ldc_w 378
    //   1667: aload_3
    //   1668: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1671: pop
    //   1672: aload 4
    //   1674: ldc 221
    //   1676: aload_2
    //   1677: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1680: pop
    //   1681: aload_0
    //   1682: invokespecial 495	ajmu:ard	()Z
    //   1685: ifeq +135 -> 1820
    //   1688: aload 4
    //   1690: ldc 159
    //   1692: ldc 161
    //   1694: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1697: pop
    //   1698: aload 4
    //   1700: ldc_w 617
    //   1703: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1706: ifne +14 -> 1720
    //   1709: aload 4
    //   1711: ldc_w 617
    //   1714: lload 14
    //   1716: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1719: pop
    //   1720: aload 4
    //   1722: ldc_w 382
    //   1725: iload 11
    //   1727: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1730: pop
    //   1731: aload_1
    //   1732: aload 4
    //   1734: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   1737: goto -1570 -> 167
    //   1740: aload 21
    //   1742: invokeinterface 719 1 0
    //   1747: astore 5
    //   1749: aload_0
    //   1750: invokespecial 313	ajmu:getCurrentSongInfo	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1753: astore 20
    //   1755: aload 5
    //   1757: ifnull +1210 -> 2967
    //   1760: iconst_0
    //   1761: istore 8
    //   1763: iload 12
    //   1765: istore 9
    //   1767: iload 9
    //   1769: istore 10
    //   1771: iload 8
    //   1773: aload 5
    //   1775: arraylength
    //   1776: if_icmpge +1191 -> 2967
    //   1779: aload 5
    //   1781: iload 8
    //   1783: aaload
    //   1784: astore 22
    //   1786: iload 9
    //   1788: istore 10
    //   1790: aload 22
    //   1792: ifnull +1267 -> 3059
    //   1795: iload 9
    //   1797: istore 10
    //   1799: aload 22
    //   1801: getfield 283	com/tencent/mobileqq/music/SongInfo:id	J
    //   1804: aload 20
    //   1806: getfield 283	com/tencent/mobileqq/music/SongInfo:id	J
    //   1809: lcmp
    //   1810: ifne +1249 -> 3059
    //   1813: iload 8
    //   1815: istore 10
    //   1817: goto +1242 -> 3059
    //   1820: aload 4
    //   1822: ldc 159
    //   1824: ldc 161
    //   1826: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1829: pop
    //   1830: goto -132 -> 1698
    //   1833: ldc_w 724
    //   1836: aload_3
    //   1837: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1840: ifeq +76 -> 1916
    //   1843: bipush 103
    //   1845: istore 9
    //   1847: iload 9
    //   1849: istore 8
    //   1851: aload_2
    //   1852: ifnull +26 -> 1878
    //   1855: iload 9
    //   1857: istore 8
    //   1859: aload_2
    //   1860: ldc_w 726
    //   1863: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1866: ifeq +12 -> 1878
    //   1869: aload_2
    //   1870: ldc_w 726
    //   1873: invokevirtual 595	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1876: istore 8
    //   1878: aload 21
    //   1880: aload_0
    //   1881: iload 8
    //   1883: invokespecial 728	ajmu:in	(I)I
    //   1886: invokeinterface 671 2 0
    //   1891: new 156	org/json/JSONObject
    //   1894: dup
    //   1895: invokespecial 157	org/json/JSONObject:<init>	()V
    //   1898: astore_2
    //   1899: aload_2
    //   1900: ldc 159
    //   1902: ldc 161
    //   1904: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1907: pop
    //   1908: aload_1
    //   1909: aload_2
    //   1910: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   1913: goto -1746 -> 167
    //   1916: ldc_w 730
    //   1919: aload_3
    //   1920: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1923: ifeq +106 -> 2029
    //   1926: aload_2
    //   1927: ifnull +1034 -> 2961
    //   1930: aload_2
    //   1931: ldc_w 732
    //   1934: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1937: ifeq +1024 -> 2961
    //   1940: aload_2
    //   1941: ldc_w 732
    //   1944: invokevirtual 595	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1947: istore 8
    //   1949: new 156	org/json/JSONObject
    //   1952: dup
    //   1953: invokespecial 157	org/json/JSONObject:<init>	()V
    //   1956: astore_3
    //   1957: aload_0
    //   1958: getfield 550	ajmu:mContext	Landroid/content/Context;
    //   1961: astore_2
    //   1962: aload_2
    //   1963: ifnull +991 -> 2954
    //   1966: iload 8
    //   1968: iflt +986 -> 2954
    //   1971: iload 8
    //   1973: bipush 100
    //   1975: if_icmpgt +979 -> 2954
    //   1978: aload_2
    //   1979: ldc_w 734
    //   1982: invokevirtual 737	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1985: checkcast 739	android/media/AudioManager
    //   1988: astore_2
    //   1989: aload_2
    //   1990: ifnull +964 -> 2954
    //   1993: aload_2
    //   1994: iconst_3
    //   1995: aload_2
    //   1996: iconst_3
    //   1997: invokevirtual 742	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   2000: iload 8
    //   2002: imul
    //   2003: bipush 100
    //   2005: idiv
    //   2006: iconst_4
    //   2007: invokevirtual 746	android/media/AudioManager:setStreamVolume	(III)V
    //   2010: ldc 161
    //   2012: astore_2
    //   2013: aload_3
    //   2014: ldc 159
    //   2016: aload_2
    //   2017: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2020: pop
    //   2021: aload_1
    //   2022: aload_3
    //   2023: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   2026: goto -1859 -> 167
    //   2029: ldc_w 748
    //   2032: aload_3
    //   2033: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2036: ifeq +189 -> 2225
    //   2039: aload_2
    //   2040: ifnull +142 -> 2182
    //   2043: aload_2
    //   2044: ldc 167
    //   2046: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2049: ifeq +133 -> 2182
    //   2052: aload_2
    //   2053: ldc 167
    //   2055: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2058: astore_3
    //   2059: aload_2
    //   2060: ldc_w 750
    //   2063: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2066: ifeq +123 -> 2189
    //   2069: aload_2
    //   2070: ldc_w 750
    //   2073: invokevirtual 595	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2076: istore 8
    //   2078: aload_3
    //   2079: invokestatic 755	com/tencent/mobileqq/mqsafeedit/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   2082: astore_2
    //   2083: new 757	java/io/File
    //   2086: dup
    //   2087: new 757	java/io/File
    //   2090: dup
    //   2091: new 143	java/lang/StringBuilder
    //   2094: dup
    //   2095: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   2098: getstatic 762	acbn:SDCARD_PATH	Ljava/lang/String;
    //   2101: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2104: getstatic 765	java/io/File:separator	Ljava/lang/String;
    //   2107: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2110: ldc_w 767
    //   2113: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2116: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2119: invokespecial 768	java/io/File:<init>	(Ljava/lang/String;)V
    //   2122: aload_2
    //   2123: invokespecial 771	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   2126: astore_2
    //   2127: aload_2
    //   2128: ifnull +10 -> 2138
    //   2131: aload_2
    //   2132: invokevirtual 774	java/io/File:exists	()Z
    //   2135: ifne +60 -> 2195
    //   2138: new 776	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin$5
    //   2141: dup
    //   2142: aload_0
    //   2143: aload_3
    //   2144: iload 8
    //   2146: aload_2
    //   2147: invokespecial 779	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin$5:<init>	(Lajmu;Ljava/lang/String;ILjava/io/File;)V
    //   2150: bipush 8
    //   2152: aconst_null
    //   2153: iconst_1
    //   2154: invokestatic 785	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2157: new 156	org/json/JSONObject
    //   2160: dup
    //   2161: invokespecial 157	org/json/JSONObject:<init>	()V
    //   2164: astore_2
    //   2165: aload_2
    //   2166: ldc 159
    //   2168: ldc 161
    //   2170: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2173: pop
    //   2174: aload_1
    //   2175: aload_2
    //   2176: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   2179: goto -2012 -> 167
    //   2182: ldc_w 298
    //   2185: astore_3
    //   2186: goto -127 -> 2059
    //   2189: iconst_0
    //   2190: istore 8
    //   2192: goto -114 -> 2078
    //   2195: aload_0
    //   2196: aload_2
    //   2197: invokevirtual 788	java/io/File:getPath	()Ljava/lang/String;
    //   2200: invokestatic 791	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   2203: invokespecial 208	ajmu:X	(Landroid/graphics/Bitmap;)V
    //   2206: goto -49 -> 2157
    //   2209: astore_2
    //   2210: aload_2
    //   2211: invokevirtual 112	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2214: goto -57 -> 2157
    //   2217: astore_2
    //   2218: aload_2
    //   2219: invokevirtual 364	java/lang/Exception:printStackTrace	()V
    //   2222: goto -65 -> 2157
    //   2225: ldc_w 793
    //   2228: aload_3
    //   2229: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2232: ifeq +104 -> 2336
    //   2235: aload_0
    //   2236: getfield 550	ajmu:mContext	Landroid/content/Context;
    //   2239: astore_2
    //   2240: new 156	org/json/JSONObject
    //   2243: dup
    //   2244: invokespecial 157	org/json/JSONObject:<init>	()V
    //   2247: astore_3
    //   2248: aload_2
    //   2249: ifnull +698 -> 2947
    //   2252: aload_2
    //   2253: ldc_w 734
    //   2256: invokevirtual 737	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2259: checkcast 739	android/media/AudioManager
    //   2262: astore_2
    //   2263: aload_2
    //   2264: ifnull +683 -> 2947
    //   2267: aload_2
    //   2268: iconst_3
    //   2269: invokevirtual 742	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   2272: i2f
    //   2273: fstore 6
    //   2275: aload_2
    //   2276: iconst_3
    //   2277: invokevirtual 796	android/media/AudioManager:getStreamVolume	(I)I
    //   2280: i2f
    //   2281: fstore 7
    //   2283: fload 7
    //   2285: f2i
    //   2286: istore 8
    //   2288: fload 6
    //   2290: fconst_0
    //   2291: fcmpl
    //   2292: ifle +15 -> 2307
    //   2295: fload 7
    //   2297: fload 6
    //   2299: fdiv
    //   2300: ldc_w 797
    //   2303: fmul
    //   2304: f2i
    //   2305: istore 8
    //   2307: aload_3
    //   2308: ldc_w 732
    //   2311: iload 8
    //   2313: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2316: pop
    //   2317: ldc 161
    //   2319: astore_2
    //   2320: aload_3
    //   2321: ldc 159
    //   2323: aload_2
    //   2324: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2327: pop
    //   2328: aload_1
    //   2329: aload_3
    //   2330: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   2333: goto -2166 -> 167
    //   2336: ldc_w 799
    //   2339: aload_3
    //   2340: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2343: ifeq +182 -> 2525
    //   2346: aload_2
    //   2347: ldc_w 800
    //   2350: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2353: astore 4
    //   2355: aload_2
    //   2356: ldc_w 802
    //   2359: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2362: astore 5
    //   2364: aload_2
    //   2365: ldc 167
    //   2367: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2370: astore 20
    //   2372: aload_2
    //   2373: ldc_w 804
    //   2376: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2379: astore 21
    //   2381: aload_2
    //   2382: ldc_w 806
    //   2385: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2388: astore 22
    //   2390: ldc_w 808
    //   2393: astore_3
    //   2394: aload_2
    //   2395: ldc_w 810
    //   2398: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2401: ifeq +11 -> 2412
    //   2404: aload_2
    //   2405: ldc_w 810
    //   2408: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2411: astore_3
    //   2412: aload_0
    //   2413: getfield 550	ajmu:mContext	Landroid/content/Context;
    //   2416: ifnull +84 -> 2500
    //   2419: new 424	android/content/Intent
    //   2422: dup
    //   2423: ldc_w 812
    //   2426: invokespecial 553	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   2429: astore_2
    //   2430: aload_2
    //   2431: ldc_w 814
    //   2434: aload 4
    //   2436: invokevirtual 559	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2439: pop
    //   2440: aload_2
    //   2441: ldc_w 816
    //   2444: aload 5
    //   2446: invokevirtual 559	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2449: pop
    //   2450: aload_2
    //   2451: ldc_w 818
    //   2454: aload 20
    //   2456: invokevirtual 559	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2459: pop
    //   2460: aload_2
    //   2461: ldc_w 820
    //   2464: aload 21
    //   2466: invokevirtual 559	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2469: pop
    //   2470: aload_2
    //   2471: ldc_w 822
    //   2474: aload 22
    //   2476: invokevirtual 559	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2479: pop
    //   2480: aload_2
    //   2481: ldc_w 824
    //   2484: aload_3
    //   2485: invokevirtual 559	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2488: pop
    //   2489: aload_0
    //   2490: getfield 550	ajmu:mContext	Landroid/content/Context;
    //   2493: aload_2
    //   2494: ldc_w 561
    //   2497: invokevirtual 567	android/content/Context:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   2500: new 156	org/json/JSONObject
    //   2503: dup
    //   2504: invokespecial 157	org/json/JSONObject:<init>	()V
    //   2507: astore_2
    //   2508: aload_2
    //   2509: ldc 159
    //   2511: ldc 161
    //   2513: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2516: pop
    //   2517: aload_1
    //   2518: aload_2
    //   2519: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   2522: goto -2355 -> 167
    //   2525: ldc_w 826
    //   2528: aload_3
    //   2529: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2532: ifeq -2365 -> 167
    //   2535: aload_2
    //   2536: ldc_w 800
    //   2539: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2542: astore 4
    //   2544: aload_2
    //   2545: ldc_w 802
    //   2548: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2551: astore 5
    //   2553: aload_2
    //   2554: ldc 167
    //   2556: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2559: astore 20
    //   2561: aload_2
    //   2562: ldc_w 804
    //   2565: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2568: astore 21
    //   2570: aload_2
    //   2571: ldc_w 828
    //   2574: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2577: ifeq +362 -> 2939
    //   2580: aload_2
    //   2581: ldc_w 828
    //   2584: invokevirtual 620	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   2587: lstore 14
    //   2589: ldc_w 808
    //   2592: astore_3
    //   2593: aload_2
    //   2594: ldc_w 810
    //   2597: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2600: ifeq +11 -> 2611
    //   2603: aload_2
    //   2604: ldc_w 810
    //   2607: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2610: astore_3
    //   2611: aload_0
    //   2612: getfield 550	ajmu:mContext	Landroid/content/Context;
    //   2615: ifnull +84 -> 2699
    //   2618: new 424	android/content/Intent
    //   2621: dup
    //   2622: ldc_w 830
    //   2625: invokespecial 553	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   2628: astore_2
    //   2629: aload_2
    //   2630: ldc_w 814
    //   2633: aload 4
    //   2635: invokevirtual 559	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2638: pop
    //   2639: aload_2
    //   2640: ldc_w 816
    //   2643: aload 5
    //   2645: invokevirtual 559	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2648: pop
    //   2649: aload_2
    //   2650: ldc_w 818
    //   2653: aload 20
    //   2655: invokevirtual 559	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2658: pop
    //   2659: aload_2
    //   2660: ldc_w 820
    //   2663: aload 21
    //   2665: invokevirtual 559	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2668: pop
    //   2669: aload_2
    //   2670: ldc_w 832
    //   2673: lload 14
    //   2675: invokevirtual 835	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2678: pop
    //   2679: aload_2
    //   2680: ldc_w 824
    //   2683: aload_3
    //   2684: invokevirtual 559	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2687: pop
    //   2688: aload_0
    //   2689: getfield 550	ajmu:mContext	Landroid/content/Context;
    //   2692: aload_2
    //   2693: ldc_w 561
    //   2696: invokevirtual 567	android/content/Context:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   2699: new 156	org/json/JSONObject
    //   2702: dup
    //   2703: invokespecial 157	org/json/JSONObject:<init>	()V
    //   2706: astore_2
    //   2707: aload_2
    //   2708: ldc 159
    //   2710: ldc 161
    //   2712: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2715: pop
    //   2716: aload_1
    //   2717: aload_2
    //   2718: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   2721: goto -2554 -> 167
    //   2724: ldc_w 837
    //   2727: aload 4
    //   2729: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2732: ifeq +181 -> 2913
    //   2735: aload 20
    //   2737: iconst_0
    //   2738: invokevirtual 586	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2741: checkcast 177	java/lang/String
    //   2744: astore_2
    //   2745: new 156	org/json/JSONObject
    //   2748: dup
    //   2749: aload_2
    //   2750: invokespecial 338	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2753: astore_3
    //   2754: aconst_null
    //   2755: astore_2
    //   2756: aload_3
    //   2757: ldc_w 588
    //   2760: invokevirtual 225	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2763: ifeq +11 -> 2774
    //   2766: aload_3
    //   2767: ldc_w 588
    //   2770: invokevirtual 247	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2773: astore_2
    //   2774: aload_0
    //   2775: getfield 193	ajmu:mService	Lajmj;
    //   2778: invokeinterface 332 1 0
    //   2783: astore_3
    //   2784: aload_3
    //   2785: ifnull +291 -> 3076
    //   2788: aload_3
    //   2789: ldc_w 340
    //   2792: iconst_0
    //   2793: invokevirtual 344	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   2796: istore 8
    //   2798: ldc_w 497
    //   2801: aload_2
    //   2802: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2805: ifeq +58 -> 2863
    //   2808: aload_0
    //   2809: iconst_1
    //   2810: putfield 488	ajmu:cpr	Z
    //   2813: new 156	org/json/JSONObject
    //   2816: dup
    //   2817: invokespecial 157	org/json/JSONObject:<init>	()V
    //   2820: astore_2
    //   2821: aload_2
    //   2822: ldc_w 382
    //   2825: iload 8
    //   2827: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2830: pop
    //   2831: aload_2
    //   2832: ldc 159
    //   2834: ldc 161
    //   2836: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2839: pop
    //   2840: aload_1
    //   2841: aload_2
    //   2842: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   2845: aload_0
    //   2846: invokespecial 839	ajmu:dyu	()V
    //   2849: goto -2682 -> 167
    //   2852: astore_3
    //   2853: aload_3
    //   2854: invokevirtual 364	java/lang/Exception:printStackTrace	()V
    //   2857: iconst_0
    //   2858: istore 8
    //   2860: goto -62 -> 2798
    //   2863: ldc_w 368
    //   2866: aload_2
    //   2867: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2870: ifeq -2703 -> 167
    //   2873: aload_0
    //   2874: iconst_1
    //   2875: putfield 309	ajmu:cps	Z
    //   2878: new 156	org/json/JSONObject
    //   2881: dup
    //   2882: invokespecial 157	org/json/JSONObject:<init>	()V
    //   2885: astore_2
    //   2886: aload_2
    //   2887: ldc_w 382
    //   2890: iload 8
    //   2892: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2895: pop
    //   2896: aload_2
    //   2897: ldc 159
    //   2899: ldc 161
    //   2901: invokevirtual 165	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2904: pop
    //   2905: aload_1
    //   2906: aload_2
    //   2907: invokevirtual 607	com/tencent/mobileqq/webview/swift/JsBridgeListener:onComplete	(Ljava/lang/Object;)V
    //   2910: goto -2743 -> 167
    //   2913: ldc_w 841
    //   2916: aload 4
    //   2918: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2921: ifeq -2754 -> 167
    //   2924: goto -2757 -> 167
    //   2927: aload_0
    //   2928: aload_1
    //   2929: aload_2
    //   2930: aload_3
    //   2931: aload 4
    //   2933: aload 5
    //   2935: invokespecial 843	com/tencent/mobileqq/webview/swift/WebViewPlugin:handleJsRequest	(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   2938: ireturn
    //   2939: ldc2_w 844
    //   2942: lstore 14
    //   2944: goto -355 -> 2589
    //   2947: ldc_w 613
    //   2950: astore_2
    //   2951: goto -631 -> 2320
    //   2954: ldc_w 613
    //   2957: astore_2
    //   2958: goto -945 -> 2013
    //   2961: iconst_0
    //   2962: istore 8
    //   2964: goto -1015 -> 1949
    //   2967: iload 10
    //   2969: istore 8
    //   2971: goto -1351 -> 1620
    //   2974: aload 20
    //   2976: astore_2
    //   2977: goto -1496 -> 1481
    //   2980: aload_2
    //   2981: astore 4
    //   2983: goto -1610 -> 1373
    //   2986: aconst_null
    //   2987: astore_2
    //   2988: goto -1631 -> 1357
    //   2991: goto -1931 -> 1060
    //   2994: aload_2
    //   2995: astore_3
    //   2996: goto -2059 -> 937
    //   2999: aconst_null
    //   3000: astore_2
    //   3001: goto -2079 -> 922
    //   3004: aconst_null
    //   3005: astore_2
    //   3006: goto -2919 -> 87
    //   3009: iconst_0
    //   3010: istore 8
    //   3012: goto -2053 -> 959
    //   3015: lconst_0
    //   3016: lstore 14
    //   3018: goto -2033 -> 985
    //   3021: iload 8
    //   3023: iconst_1
    //   3024: iadd
    //   3025: istore 8
    //   3027: iload 10
    //   3029: istore 9
    //   3031: goto -1499 -> 1532
    //   3034: iconst_0
    //   3035: istore 11
    //   3037: goto -1648 -> 1389
    //   3040: lconst_0
    //   3041: lstore 14
    //   3043: goto -1628 -> 1415
    //   3046: ldc 161
    //   3048: astore_2
    //   3049: goto -1603 -> 1446
    //   3052: iload 10
    //   3054: istore 8
    //   3056: goto -1436 -> 1620
    //   3059: iload 8
    //   3061: iconst_1
    //   3062: iadd
    //   3063: istore 8
    //   3065: iload 10
    //   3067: istore 9
    //   3069: goto -1302 -> 1767
    //   3072: astore_1
    //   3073: goto -2906 -> 167
    //   3076: iconst_0
    //   3077: istore 8
    //   3079: goto -281 -> 2798
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3082	0	this	ajmu
    //   0	3082	1	paramJsBridgeListener	JsBridgeListener
    //   0	3082	2	paramString1	String
    //   0	3082	3	paramString2	String
    //   0	3082	4	paramString3	String
    //   0	3082	5	paramVarArgs	String[]
    //   2273	25	6	f1	float
    //   2281	15	7	f2	float
    //   249	2829	8	i	int
    //   1135	1933	9	j	int
    //   1143	1923	10	k	int
    //   1387	1649	11	m	int
    //   1482	282	12	n	int
    //   119	1189	13	bool	boolean
    //   255	2787	14	l1	long
    //   1156	103	16	l2	long
    //   1126	67	18	l3	long
    //   12	2963	20	localObject1	Object
    //   213	2451	21	localObject2	Object
    //   356	2119	22	localObject3	Object
    //   389	19	23	str	String
    // Exception table:
    //   from	to	target	type
    //   44	87	162	java/lang/Exception
    //   91	112	162	java/lang/Exception
    //   112	121	162	java/lang/Exception
    //   154	159	162	java/lang/Exception
    //   195	206	162	java/lang/Exception
    //   209	215	162	java/lang/Exception
    //   222	232	162	java/lang/Exception
    //   236	243	162	java/lang/Exception
    //   260	279	162	java/lang/Exception
    //   279	297	162	java/lang/Exception
    //   297	316	162	java/lang/Exception
    //   316	334	162	java/lang/Exception
    //   334	351	162	java/lang/Exception
    //   351	461	162	java/lang/Exception
    //   461	501	162	java/lang/Exception
    //   506	519	162	java/lang/Exception
    //   519	530	162	java/lang/Exception
    //   598	619	162	java/lang/Exception
    //   635	639	162	java/lang/Exception
    //   642	692	162	java/lang/Exception
    //   695	734	162	java/lang/Exception
    //   737	776	162	java/lang/Exception
    //   779	818	162	java/lang/Exception
    //   821	860	162	java/lang/Exception
    //   863	872	162	java/lang/Exception
    //   929	937	162	java/lang/Exception
    //   937	943	162	java/lang/Exception
    //   948	959	162	java/lang/Exception
    //   964	985	162	java/lang/Exception
    //   1004	1049	162	java/lang/Exception
    //   1053	1060	162	java/lang/Exception
    //   1064	1070	162	java/lang/Exception
    //   1070	1105	162	java/lang/Exception
    //   1109	1113	162	java/lang/Exception
    //   1121	1145	162	java/lang/Exception
    //   1151	1158	162	java/lang/Exception
    //   1158	1174	162	java/lang/Exception
    //   1174	1222	162	java/lang/Exception
    //   1222	1242	162	java/lang/Exception
    //   1242	1247	162	java/lang/Exception
    //   1250	1260	162	java/lang/Exception
    //   1263	1272	162	java/lang/Exception
    //   1275	1295	162	java/lang/Exception
    //   1298	1307	162	java/lang/Exception
    //   1364	1373	162	java/lang/Exception
    //   1378	1389	162	java/lang/Exception
    //   1394	1415	162	java/lang/Exception
    //   1426	1446	162	java/lang/Exception
    //   1448	1476	162	java/lang/Exception
    //   1497	1520	162	java/lang/Exception
    //   1536	1544	162	java/lang/Exception
    //   1560	1573	162	java/lang/Exception
    //   1586	1600	162	java/lang/Exception
    //   1608	1612	162	java/lang/Exception
    //   1620	1672	162	java/lang/Exception
    //   1672	1698	162	java/lang/Exception
    //   1698	1720	162	java/lang/Exception
    //   1720	1737	162	java/lang/Exception
    //   1740	1755	162	java/lang/Exception
    //   1771	1779	162	java/lang/Exception
    //   1799	1813	162	java/lang/Exception
    //   1820	1830	162	java/lang/Exception
    //   1833	1843	162	java/lang/Exception
    //   1859	1878	162	java/lang/Exception
    //   1878	1913	162	java/lang/Exception
    //   1916	1926	162	java/lang/Exception
    //   1930	1949	162	java/lang/Exception
    //   1949	1962	162	java/lang/Exception
    //   1978	1989	162	java/lang/Exception
    //   1993	2010	162	java/lang/Exception
    //   2013	2026	162	java/lang/Exception
    //   2029	2039	162	java/lang/Exception
    //   2043	2059	162	java/lang/Exception
    //   2059	2078	162	java/lang/Exception
    //   2078	2127	162	java/lang/Exception
    //   2131	2138	162	java/lang/Exception
    //   2138	2157	162	java/lang/Exception
    //   2157	2179	162	java/lang/Exception
    //   2210	2214	162	java/lang/Exception
    //   2218	2222	162	java/lang/Exception
    //   2225	2248	162	java/lang/Exception
    //   2252	2263	162	java/lang/Exception
    //   2267	2283	162	java/lang/Exception
    //   2295	2307	162	java/lang/Exception
    //   2307	2317	162	java/lang/Exception
    //   2320	2333	162	java/lang/Exception
    //   2336	2390	162	java/lang/Exception
    //   2394	2412	162	java/lang/Exception
    //   2412	2500	162	java/lang/Exception
    //   2500	2522	162	java/lang/Exception
    //   2525	2589	162	java/lang/Exception
    //   2593	2611	162	java/lang/Exception
    //   2611	2699	162	java/lang/Exception
    //   2699	2721	162	java/lang/Exception
    //   126	152	194	java/lang/Exception
    //   169	191	194	java/lang/Exception
    //   530	550	634	java/lang/Exception
    //   555	564	634	java/lang/Exception
    //   564	580	634	java/lang/Exception
    //   580	595	634	java/lang/Exception
    //   622	631	634	java/lang/Exception
    //   879	887	1108	java/lang/Exception
    //   893	902	1108	java/lang/Exception
    //   904	919	1108	java/lang/Exception
    //   1314	1322	1607	java/lang/Exception
    //   1328	1337	1607	java/lang/Exception
    //   1339	1354	1607	java/lang/Exception
    //   2195	2206	2209	java/lang/OutOfMemoryError
    //   2195	2206	2217	java/lang/Exception
    //   2774	2784	2852	java/lang/Exception
    //   2788	2798	2852	java/lang/Exception
    //   2745	2754	3072	org/json/JSONException
    //   2756	2774	3072	org/json/JSONException
    //   2774	2784	3072	org/json/JSONException
    //   2788	2798	3072	org/json/JSONException
    //   2798	2849	3072	org/json/JSONException
    //   2853	2857	3072	org/json/JSONException
    //   2863	2910	3072	org/json/JSONException
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    try
    {
      if ((this.mService == null) && (nv(paramString1))) {
        bindQQPlayerService();
      }
      return super.handleSchemaRequest(paramString1, paramString2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.handleSchemaRequest exception", localException);
      }
    }
  }
  
  public void onCreate()
  {
    Activity localActivity = this.mRuntime.getActivity();
    if (localActivity != null) {
      this.mContext = localActivity.getApplicationContext();
    }
    super.onCreate();
  }
  
  public void onDestroy()
  {
    for (;;)
    {
      try
      {
        dyv();
        if (this.mContext != null)
        {
          localObject = this.mService;
          if (localObject == null) {}
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.onCreate exception", localException);
        continue;
      }
      try
      {
        i = this.mService.getPlayState();
        if ((i == 2) || (i == 3)) {}
        try
        {
          localObject = this.mService.getToken();
          if ((localObject != null) && (((String)localObject).startsWith("music_gene_"))) {
            this.mService.stop();
          }
        }
        catch (RemoteException localRemoteException2)
        {
          localRemoteException2.printStackTrace();
          continue;
        }
        kw(4);
        unbindQQPlayerService();
        this.mContext.unregisterReceiver(this.mReceiver);
        this.mContext = null;
        this.b = null;
        super.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException1)
      {
        localRemoteException1.printStackTrace();
        i = 4;
      }
    }
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if (paramCustomWebView != null) {}
    label124:
    for (;;)
    {
      try
      {
        paramCustomWebView = paramCustomWebView.getUrl();
        if (!TextUtils.isEmpty(paramCustomWebView)) {
          break label124;
        }
        aqzv localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
        if ((localaqzv == null) || (!(localaqzv instanceof ardm.o))) {
          break label124;
        }
        paramCustomWebView = ((ardm.o)localaqzv).getCurrentUrl();
        if (this.mContext == null) {
          break;
        }
        if (nv(paramCustomWebView)) {
          bindQQPlayerService();
        }
        paramCustomWebView = new IntentFilter();
        paramCustomWebView.addAction("BROAD_CAST_CALL_PAGE_SHARE");
        this.mContext.registerReceiver(this.mReceiver, paramCustomWebView);
        return;
      }
      catch (Exception paramCustomWebView)
      {
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.onCreate exception", paramCustomWebView);
        return;
      }
      paramCustomWebView = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajmu
 * JD-Core Version:    0.7.0.1
 */