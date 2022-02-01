import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class uaq
  extends tzh
{
  private static BroadcastReceiver ac;
  private static HashSet<WeakReference<uaq>> av;
  private static boolean sGlobalReceiverRegistered;
  private String aKp;
  private boolean auZ;
  private HashMap<String, tzd> mEvents;
  private WeakReference<uaq> mRef;
  private String mUniqueMark;
  
  private static void createGlobalBroadcastReceiver()
  {
    av = new HashSet();
    ac = new uar();
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramString = paramJSONObject.optString("event", "");
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.w("DoraemonOpenAPI.event", 2, "event name is required");
        }
        ubu.a(paramtzd, -1, "event name is required");
      }
      break;
    }
    String str1;
    label239:
    JSONObject localJSONObject;
    for (;;)
    {
      return true;
      bbD();
      this.mEvents.put(paramString, paramtzd);
      ubu.a(paramtzd, tzf.EMPTY);
      continue;
      paramString = paramJSONObject.optString("event", "");
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.w("DoraemonOpenAPI.event", 2, "event name is required");
        }
        ubu.a(paramtzd, -1, "event name is required");
      }
      else
      {
        if (this.mEvents != null) {
          this.mEvents.remove(paramString);
        }
        ubu.a(paramtzd, tzf.EMPTY);
        continue;
        try
        {
          str1 = paramJSONObject.optString("event");
          if (!TextUtils.isEmpty(str1)) {
            break label239;
          }
          if (QLog.isColorLevel()) {
            QLog.w("DoraemonOpenAPI.event", 2, "event name is required");
          }
          ubu.a(paramtzd, -1, "event name is required");
        }
        catch (Throwable paramString)
        {
          QLog.e("DoraemonOpenAPI.event", 1, paramString.getMessage(), paramString);
          ubu.a(paramtzd, -3, paramString.getMessage());
        }
        continue;
        localJSONObject = paramJSONObject.optJSONObject("data");
        if (localJSONObject == null) {
          break label658;
        }
        paramString = localJSONObject.toString();
        label258:
        if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 460800L)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.w("DoraemonOpenAPI.event", 2, "param data is over size");
        }
        ubu.a(paramtzd, -2, "param data is over size");
      }
    }
    paramString = paramJSONObject.optJSONObject("options");
    int j = 1;
    boolean bool1 = true;
    paramJSONObject = new ArrayList();
    boolean bool2;
    boolean bool3;
    int i;
    if (paramString != null)
    {
      bool2 = paramString.optBoolean("echo", true);
      bool3 = paramString.optBoolean("broadcast", true);
      paramString = paramString.optJSONArray("domains");
      bool1 = bool3;
      j = bool2;
      if (paramString != null)
      {
        paramInt = 0;
        i = paramString.length();
      }
    }
    for (;;)
    {
      bool1 = bool3;
      j = bool2;
      Object localObject;
      if (paramInt < i)
      {
        localObject = paramString.optString(paramInt);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramJSONObject.add(localObject);
        }
      }
      else
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("appid", this.b.mAppid);
        ((JSONObject)localObject).put("appType", this.b.bDo);
        if (paramJSONObject.size() == 0) {
          paramJSONObject.add(oI());
        }
        Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        localIntent.putExtra("broadcast", bool1);
        localIntent.putExtra("unique", getUniqueMark());
        localIntent.putExtra("event", str1);
        if (localJSONObject != null) {
          localIntent.putExtra("data", localJSONObject.toString());
        }
        localIntent.putStringArrayListExtra("domains", paramJSONObject);
        localIntent.putExtra("source", ((JSONObject)localObject).toString());
        String str2;
        if (QLog.isColorLevel())
        {
          str2 = toString();
          if (localJSONObject == null) {
            break label652;
          }
        }
        label652:
        for (paramString = localJSONObject.toString();; paramString = "NULL")
        {
          QLog.d("DoraemonOpenAPI.event", 2, String.format("send event broadcast, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", new Object[] { str2, str1, paramString, TextUtils.join(",", paramJSONObject), localObject }));
          BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
          if (j != 0) {
            c(str1, localJSONObject, (JSONObject)localObject);
          }
          ubu.a(paramtzd, tzf.EMPTY);
          break;
        }
        label658:
        paramString = "";
        break label258;
      }
      paramInt += 1;
    }
  }
  
  protected void bbD()
  {
    if (this.auZ) {
      return;
    }
    if (ac == null) {
      createGlobalBroadcastReceiver();
    }
    if (!sGlobalReceiverRegistered)
    {
      sGlobalReceiverRegistered = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      BaseApplicationImpl.getApplication().registerReceiver(ac, localIntentFilter, "com.tencent.tim.msg.permission.pushnotify", null);
    }
    this.auZ = true;
    this.mEvents = new HashMap();
    this.mRef = new WeakReference(this);
    av.add(this.mRef);
  }
  
  protected void c(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    tzd localtzd;
    if (this.mEvents == null) {
      localtzd = null;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      if (localtzd != null) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("event", paramString);
        localJSONObject.put("data", paramJSONObject1);
        localJSONObject.put("source", paramJSONObject2);
        ubu.b(localtzd, localJSONObject);
        return;
        localtzd = (tzd)this.mEvents.get(paramString);
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          QLog.e("DoraemonOpenAPI.event", 1, paramString.getMessage(), paramString);
        }
      }
    }
  }
  
  public void destroy()
  {
    if (this.auZ)
    {
      av.remove(this.mRef);
      if (av.size() == 0)
      {
        sGlobalReceiverRegistered = false;
        BaseApplicationImpl.getApplication().unregisterReceiver(ac);
      }
    }
  }
  
  protected String getUniqueMark()
  {
    if (this.mUniqueMark == null) {
      this.mUniqueMark = (String.valueOf(System.currentTimeMillis()) + String.valueOf((int)(Math.random() * 1000000.0D)));
    }
    return this.mUniqueMark;
  }
  
  protected String oI()
  {
    if (this.aKp == null) {
      this.aKp = (this.b.bDo + "_" + this.b.mAppid + ".virtual_host");
    }
    return this.aKp;
  }
  
  /* Error */
  protected void onReceive(android.content.Context paramContext, Intent paramIntent)
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
    //   11: ldc 146
    //   13: iconst_1
    //   14: invokevirtual 347	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   17: ifeq -8 -> 9
    //   20: aload_2
    //   21: ldc 205
    //   23: invokevirtual 350	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +14 -> 42
    //   31: aload_1
    //   32: aload_0
    //   33: invokevirtual 208	uaq:getUniqueMark	()Ljava/lang/String;
    //   36: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifne -30 -> 9
    //   42: aload_2
    //   43: ldc 46
    //   45: invokevirtual 350	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 6
    //   50: aload 6
    //   52: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne -46 -> 9
    //   58: aload_2
    //   59: ldc 116
    //   61: invokevirtual 350	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +181 -> 247
    //   69: new 50	org/json/JSONObject
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 354	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: aload_2
    //   79: ldc 148
    //   81: invokevirtual 358	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   84: astore 7
    //   86: aload 7
    //   88: ifnull -79 -> 9
    //   91: aload_2
    //   92: ldc 217
    //   94: invokevirtual 350	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 8
    //   99: aload 5
    //   101: astore_2
    //   102: aload 8
    //   104: ifnull +13 -> 117
    //   107: new 50	org/json/JSONObject
    //   110: dup
    //   111: aload 8
    //   113: invokespecial 354	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   116: astore_2
    //   117: aload_0
    //   118: invokevirtual 192	uaq:oI	()Ljava/lang/String;
    //   121: astore 8
    //   123: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +64 -> 190
    //   129: aload_0
    //   130: invokevirtual 220	java/lang/Object:toString	()Ljava/lang/String;
    //   133: astore 9
    //   135: aload_1
    //   136: ifnull +93 -> 229
    //   139: aload_1
    //   140: invokevirtual 123	org/json/JSONObject:toString	()Ljava/lang/String;
    //   143: astore 5
    //   145: ldc 68
    //   147: iconst_2
    //   148: ldc_w 360
    //   151: iconst_5
    //   152: anewarray 219	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload 9
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: aload 6
    //   164: aastore
    //   165: dup
    //   166: iconst_2
    //   167: aload 5
    //   169: aastore
    //   170: dup
    //   171: iconst_3
    //   172: ldc 224
    //   174: aload 7
    //   176: invokestatic 228	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   179: aastore
    //   180: dup
    //   181: iconst_4
    //   182: aload_2
    //   183: aastore
    //   184: invokestatic 232	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   187: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload 7
    //   192: invokevirtual 189	java/util/ArrayList:size	()I
    //   195: istore 4
    //   197: iload_3
    //   198: iload 4
    //   200: if_icmpge -191 -> 9
    //   203: aload 7
    //   205: iload_3
    //   206: invokevirtual 363	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   209: checkcast 125	java/lang/String
    //   212: aload 8
    //   214: invokestatic 369	jml:A	(Ljava/lang/String;Ljava/lang/String;)Z
    //   217: ifeq +19 -> 236
    //   220: aload_0
    //   221: aload 6
    //   223: aload_1
    //   224: aload_2
    //   225: invokevirtual 253	uaq:c	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   228: return
    //   229: ldc 255
    //   231: astore 5
    //   233: goto -88 -> 145
    //   236: iload_3
    //   237: iconst_1
    //   238: iadd
    //   239: istore_3
    //   240: goto -43 -> 197
    //   243: astore_1
    //   244: return
    //   245: astore_1
    //   246: return
    //   247: aconst_null
    //   248: astore_1
    //   249: goto -171 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	uaq
    //   0	252	1	paramContext	android.content.Context
    //   0	252	2	paramIntent	Intent
    //   4	236	3	i	int
    //   195	6	4	j	int
    //   1	231	5	str1	String
    //   48	174	6	str2	String
    //   84	120	7	localArrayList	ArrayList
    //   97	116	8	str3	String
    //   133	25	9	str4	String
    // Exception table:
    //   from	to	target	type
    //   107	117	243	org/json/JSONException
    //   69	78	245	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uaq
 * JD-Core Version:    0.7.0.1
 */