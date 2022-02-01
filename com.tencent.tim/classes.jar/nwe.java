import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nwe
{
  public static final String TAG = BridgeModule.TAG + ".event";
  private String aox;
  private boolean auZ;
  private WeakReference<BridgeModule> cA;
  private BroadcastReceiver mBroadcastReceiver;
  private HashMap<String, ArrayList<nwe.a>> mEvents;
  private String mUniqueMark;
  
  public nwe(BridgeModule paramBridgeModule)
  {
    this.cA = new WeakReference(paramBridgeModule);
  }
  
  private void J(String paramString1, String paramString2, String paramString3)
  {
    if ((this.mEvents == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    if (this.mEvents.containsKey(paramString1))
    {
      localArrayList = (ArrayList)this.mEvents.get(paramString1);
      localArrayList.add(new nwe.a(paramString2, paramString3));
      this.mEvents.put(paramString1, localArrayList);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new nwe.a(paramString2, paramString3));
    this.mEvents.put(paramString1, localArrayList);
  }
  
  private void K(String paramString1, String paramString2, String paramString3)
  {
    if ((this.mEvents == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while (!this.mEvents.containsKey(paramString1));
      localArrayList = (ArrayList)this.mEvents.remove(paramString1);
      int i = 0;
      while (i < localArrayList.size())
      {
        nwe.a locala = (nwe.a)localArrayList.get(i);
        if ((locala.identifier.equals(paramString2)) && (locala.callback.equals(paramString3))) {
          localArrayList.remove(locala);
        }
        i += 1;
      }
    } while (localArrayList.size() <= 0);
    this.mEvents.put(paramString1, localArrayList);
  }
  
  private void bbD()
  {
    if (this.auZ) {
      return;
    }
    if (this.mBroadcastReceiver == null) {
      createBroadcastReceiver();
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.mBroadcastReceiver, localIntentFilter, "com.tencent.tim.msg.permission.pushnotify", null);
    this.auZ = true;
    this.mEvents = new HashMap();
  }
  
  private void createBroadcastReceiver()
  {
    this.mBroadcastReceiver = new nwf(this);
  }
  
  private String getHost()
  {
    if (!TextUtils.isEmpty(this.aox)) {
      return Uri.parse(this.aox).getHost();
    }
    return null;
  }
  
  private String getUniqueMark()
  {
    if (this.mUniqueMark == null) {
      this.mUniqueMark = (String.valueOf(System.currentTimeMillis()) + String.valueOf((int)(Math.random() * 1000000.0D)));
    }
    return this.mUniqueMark;
  }
  
  private String getUrl()
  {
    if ((this.cA != null) && (this.cA.get() != null))
    {
      BridgeModule localBridgeModule = (BridgeModule)this.cA.get();
      if ((localBridgeModule.getViolaInstance() != null) && (localBridgeModule.getViolaInstance().getFragment() != null) && ((localBridgeModule.getViolaInstance().getFragment() instanceof ViolaFragment))) {
        return ((ViolaFragment)localBridgeModule.getViolaInstance().getFragment()).getUrl();
      }
    }
    return "https://qq.com";
  }
  
  private void invokeErrorCallJS(String paramString1, String paramString2)
  {
    if ((this.cA != null) && (this.cA.get() != null)) {
      ((BridgeModule)this.cA.get()).invokeErrorCallJS(paramString1, paramString2);
    }
  }
  
  private void n(String paramString, JSONObject paramJSONObject)
  {
    if ((this.cA != null) && (this.cA.get() != null)) {
      ((BridgeModule)this.cA.get()).invokeCallJS(paramString, paramJSONObject);
    }
  }
  
  protected void b(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    ArrayList localArrayList;
    if (this.mEvents == null) {
      localArrayList = null;
    }
    for (;;)
    {
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        int i = 0;
        label26:
        if (i < localArrayList.size())
        {
          String str = ((nwe.a)localArrayList.get(i)).callback;
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("event", paramString);
            localJSONObject.put("data", paramJSONObject1);
            localJSONObject.put("source", paramJSONObject2);
            n(str, localJSONObject);
            i += 1;
            break label26;
            localArrayList = (ArrayList)this.mEvents.get(paramString);
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              QLog.e(TAG, 1, localJSONException.getMessage(), localJSONException);
            }
          }
        }
      }
    }
  }
  
  public void g(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("event", paramJSONObject.optString("eventName", ""));
    this.aox = getUrl();
    if (TextUtils.isEmpty(this.aox))
    {
      if (QLog.isColorLevel()) {
        QLog.w(TAG, 2, "source url is null");
      }
      invokeErrorCallJS(paramString, "source url is null");
    }
    do
    {
      return;
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.w(TAG, 2, "event name is null");
        }
        invokeErrorCallJS(paramString, "event name is null");
        return;
      }
      bbD();
    } while ((this.cA == null) || (this.cA.get() == null));
    J(str, paramJSONObject.optString("identifier", ((BridgeModule)this.cA.get()).getViolaInstance().getInstanceId()), paramString);
  }
  
  public void h(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("event", paramJSONObject.optString("eventName", ""));
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.w(TAG, 2, "event name is null");
      }
      invokeErrorCallJS(paramString, "event name is null");
      return;
    }
    if ((this.mEvents != null) && (this.cA != null) && (this.cA.get() != null)) {
      K(str, paramJSONObject.optString("identifier", ((BridgeModule)this.cA.get()).getViolaInstance().getInstanceId()), paramString);
    }
    n(paramString, new JSONObject());
  }
  
  public void i(JSONObject paramJSONObject, String paramString)
  {
    int i = 0;
    int k = 1;
    String str1 = paramJSONObject.optString("event", paramJSONObject.optString("eventName", ""));
    Object localObject2 = getUrl();
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.w(TAG, 2, "event name is null");
      }
      invokeErrorCallJS(paramString, "event name is null");
      return;
    }
    JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
    if (localJSONObject != null) {}
    for (Object localObject1 = localJSONObject.toString(); (!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).length() >= 460800L); localObject1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.w(TAG, 2, "param data is over size");
      }
      invokeErrorCallJS(paramString, "param data is over size");
      return;
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("options");
        localObject1 = new ArrayList();
        if (paramJSONObject == null) {
          break label516;
        }
        boolean bool2 = paramJSONObject.optBoolean("echo", true);
        boolean bool3 = paramJSONObject.optBoolean("broadcast", true);
        paramJSONObject = paramJSONObject.optJSONArray("domains");
        bool1 = bool3;
        k = bool2;
        if (paramJSONObject != null)
        {
          int j = paramJSONObject.length();
          bool1 = bool3;
          k = bool2;
          if (i < j)
          {
            localObject3 = paramJSONObject.optString(i);
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break label509;
            }
            ((ArrayList)localObject1).add(localObject3);
            break label509;
          }
        }
        Object localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("url", localObject2);
        if ((((ArrayList)localObject1).size() == 0) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          paramJSONObject = Uri.parse((String)localObject2);
          if (paramJSONObject.isHierarchical()) {
            ((ArrayList)localObject1).add(paramJSONObject.getHost());
          }
        }
        localObject2 = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        ((Intent)localObject2).putExtra("broadcast", bool1);
        ((Intent)localObject2).putExtra("unique", getUniqueMark());
        ((Intent)localObject2).putExtra("event", str1);
        if (localJSONObject != null) {
          ((Intent)localObject2).putExtra("data", localJSONObject.toString());
        }
        ((Intent)localObject2).putStringArrayListExtra("domains", (ArrayList)localObject1);
        ((Intent)localObject2).putExtra("source", ((JSONObject)localObject3).toString());
        if (QLog.isColorLevel())
        {
          String str2 = TAG;
          String str3 = this.cA.toString();
          if (localJSONObject != null)
          {
            paramJSONObject = localJSONObject.toString();
            QLog.d(str2, 2, String.format("send event broadcast, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", new Object[] { str3, str1, paramJSONObject, TextUtils.join(",", (Iterable)localObject1), localObject3 }));
          }
        }
        else
        {
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject2, "com.tencent.tim.msg.permission.pushnotify");
          if (k != 0) {}
          n(paramString, new JSONObject());
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        invokeErrorCallJS(paramString, paramJSONObject.getMessage());
        return;
      }
      paramJSONObject = "NULL";
      continue;
      label509:
      i += 1;
      continue;
      label516:
      boolean bool1 = true;
    }
  }
  
  public void onDestroy()
  {
    if ((this.auZ) && (this.mBroadcastReceiver != null))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.mBroadcastReceiver);
      this.mBroadcastReceiver = null;
    }
    if (this.cA != null)
    {
      this.cA.clear();
      this.cA = null;
    }
    if (this.mEvents != null)
    {
      Iterator localIterator = this.mEvents.values().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList = (ArrayList)localIterator.next();
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          localArrayList.clear();
        }
      }
      this.mEvents.clear();
      this.mEvents = null;
    }
  }
  
  /* Error */
  protected void t(android.content.Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_2
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_2
    //   11: ldc_w 295
    //   14: iconst_1
    //   15: invokevirtual 391	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   18: ifeq -9 -> 9
    //   21: aload_2
    //   22: ldc_w 321
    //   25: invokevirtual 395	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_1
    //   29: aload_1
    //   30: ifnull +14 -> 44
    //   33: aload_1
    //   34: aload_0
    //   35: invokespecial 323	nwe:getUniqueMark	()Ljava/lang/String;
    //   38: invokevirtual 105	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifne -32 -> 9
    //   44: aload_2
    //   45: ldc 219
    //   47: invokevirtual 395	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore 7
    //   52: aload 7
    //   54: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne -48 -> 9
    //   60: aload_2
    //   61: ldc 224
    //   63: invokevirtual 395	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull +207 -> 275
    //   71: new 216	org/json/JSONObject
    //   74: dup
    //   75: aload_1
    //   76: invokespecial 396	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   79: astore_1
    //   80: aload_2
    //   81: ldc_w 297
    //   84: invokevirtual 400	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   87: astore 8
    //   89: aload 8
    //   91: ifnull -82 -> 9
    //   94: aload_2
    //   95: ldc 226
    //   97: invokevirtual 395	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 6
    //   102: aload 5
    //   104: astore_2
    //   105: aload 6
    //   107: ifnull +13 -> 120
    //   110: new 216	org/json/JSONObject
    //   113: dup
    //   114: aload 6
    //   116: invokespecial 396	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   119: astore_2
    //   120: aload_0
    //   121: invokespecial 401	nwe:getHost	()Ljava/lang/String;
    //   124: astore 9
    //   126: invokestatic 252	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +80 -> 209
    //   132: getstatic 43	nwe:TAG	Ljava/lang/String;
    //   135: astore 10
    //   137: aload_0
    //   138: getfield 53	nwe:cA	Ljava/lang/ref/WeakReference;
    //   141: ifnull +107 -> 248
    //   144: aload_0
    //   145: getfield 53	nwe:cA	Ljava/lang/ref/WeakReference;
    //   148: invokevirtual 331	java/lang/Object:toString	()Ljava/lang/String;
    //   151: astore 5
    //   153: aload_1
    //   154: ifnull +102 -> 256
    //   157: aload_1
    //   158: invokevirtual 278	org/json/JSONObject:toString	()Ljava/lang/String;
    //   161: astore 6
    //   163: aload 10
    //   165: iconst_2
    //   166: ldc_w 403
    //   169: iconst_5
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload 5
    //   177: aastore
    //   178: dup
    //   179: iconst_1
    //   180: aload 7
    //   182: aastore
    //   183: dup
    //   184: iconst_2
    //   185: aload 6
    //   187: aastore
    //   188: dup
    //   189: iconst_3
    //   190: ldc_w 335
    //   193: aload 8
    //   195: invokestatic 339	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   198: aastore
    //   199: dup
    //   200: iconst_4
    //   201: aload_2
    //   202: aastore
    //   203: invokestatic 343	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   206: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aload 8
    //   211: invokevirtual 94	java/util/ArrayList:size	()I
    //   214: istore 4
    //   216: iload_3
    //   217: iload 4
    //   219: if_icmpge -210 -> 9
    //   222: aload 8
    //   224: iload_3
    //   225: invokevirtual 97	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   228: checkcast 102	java/lang/String
    //   231: aload 9
    //   233: invokestatic 409	jml:A	(Ljava/lang/String;Ljava/lang/String;)Z
    //   236: ifeq +28 -> 264
    //   239: aload_0
    //   240: aload 7
    //   242: aload_1
    //   243: aload_2
    //   244: invokevirtual 411	nwe:b	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   247: return
    //   248: ldc_w 358
    //   251: astore 5
    //   253: goto -100 -> 153
    //   256: ldc_w 358
    //   259: astore 6
    //   261: goto -98 -> 163
    //   264: iload_3
    //   265: iconst_1
    //   266: iadd
    //   267: istore_3
    //   268: goto -52 -> 216
    //   271: astore_1
    //   272: return
    //   273: astore_1
    //   274: return
    //   275: aconst_null
    //   276: astore_1
    //   277: goto -197 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	nwe
    //   0	280	1	paramContext	android.content.Context
    //   0	280	2	paramIntent	Intent
    //   4	264	3	i	int
    //   214	6	4	j	int
    //   1	251	5	str1	String
    //   100	160	6	str2	String
    //   50	191	7	str3	String
    //   87	136	8	localArrayList	ArrayList
    //   124	108	9	str4	String
    //   135	29	10	str5	String
    // Exception table:
    //   from	to	target	type
    //   110	120	271	org/json/JSONException
    //   71	80	273	org/json/JSONException
  }
  
  class a
  {
    public String callback;
    public String identifier;
    
    a(String paramString1, String paramString2)
    {
      this.identifier = paramString1;
      this.callback = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwe
 * JD-Core Version:    0.7.0.1
 */