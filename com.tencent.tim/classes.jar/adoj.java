import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.QQSchemeHandler.1;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.QQSchemeHandler.2;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.QQSchemeHandler.3;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.2;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class adoj
{
  private static HashMap<String, adoj.b> jE = new HashMap();
  
  static
  {
    jE.put("qq", new adoj.d());
    jE.put("tel", new adoj.f());
    jE.put("app", new adoj.a());
    jE.put("mqzone", new adoj.e());
    jE.put("miniapp", new adoj.c());
  }
  
  public static boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    QLog.e("ArkApp", 2, "navigate url: " + paramString1);
    Object localObject = paramString1.split(":");
    if (localObject.length <= 1) {
      return false;
    }
    if (MiniAppLauncher.isMiniAppUrl(paramString1)) {
      try
      {
        i = Integer.parseInt((String)aurr.getArguments(paramString1.substring(paramString1.indexOf("?") + 1)).get("scene"));
        paramString2 = getEntryModel();
        MiniAppLauncher.startMiniApp(BaseActivity.sTopActivity, paramString1, i, paramString2, null);
        return true;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          QLog.e("ArkApp", 1, "Ark parse miniapp scene failed.", paramString2);
          int i = 2059;
        }
      }
    }
    localObject = localObject[0];
    adoj.b localb = (adoj.b)jE.get(localObject);
    if (localb == null) {
      return false;
    }
    localObject = paramString1.substring(((String)localObject).length() + 1);
    paramString1 = (String)localObject;
    if (((String)localObject).startsWith("//")) {
      paramString1 = ((String)localObject).substring(2);
    }
    localb.a(paramString1, paramString2, paramJSONObject, paramLong, paramString3);
    return true;
  }
  
  public static Map<String, Object> b(JSONObject paramJSONObject)
    throws JSONException
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = paramJSONObject.get(str);
      Object localObject1;
      if ((localObject2 instanceof JSONArray)) {
        localObject1 = f((JSONArray)localObject2);
      }
      for (;;)
      {
        localHashMap.put(str, localObject1);
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject)) {
          localObject1 = b((JSONObject)localObject2);
        }
      }
    }
    return localHashMap;
  }
  
  public static List<Object> f(JSONArray paramJSONArray)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject2 = paramJSONArray.get(i);
      Object localObject1;
      if ((localObject2 instanceof JSONArray)) {
        localObject1 = f((JSONArray)localObject2);
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        i += 1;
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject)) {
          localObject1 = b((JSONObject)localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  private static EntryModel getEntryModel()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof FragmentActivity))
    {
      localObject = (FragmentActivity)localObject;
      if (((FragmentActivity)localObject).getChatFragment() != null)
      {
        localObject = ((FragmentActivity)localObject).getChatFragment().a();
        if ((localObject instanceof TroopChatPie)) {
          return ((BaseChatPie)localObject).a();
        }
      }
    }
    return null;
  }
  
  public static class a
    implements adoj.b
  {
    private void c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      anan localanan = new anan();
      j = 268435456;
      try
      {
        k = Integer.parseInt(paramString4);
        if ((k & 0x4000000) != 67108864) {
          break label99;
        }
        j = 335544320;
      }
      catch (Exception paramString4)
      {
        for (;;)
        {
          int k;
          int i;
          continue;
          j = 268435456;
        }
      }
      i = j;
      if ((k & 0x20000000) == 536870912) {
        i = j | 0x20000000;
      }
      j = i;
      if ((k & 0x400000) == 4194304) {
        j = i | 0x400000;
      }
      localanan.a(getAppInterface(), paramContext, paramString1, paramString2, paramString3, j);
    }
    
    private boolean e(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity == null) {
        return false;
      }
      Object localObject1 = null;
      String str1 = "platform=qq_m&current_uin=$OPID$&launchfrom=Ark&openid=$OPID$&atoken=$AT$&ptoken=$PT$" + "&big_brother_source_key=" + paramString3;
      try
      {
        Object localObject2 = adoj.b(new JSONObject(paramString2));
        Object localObject3 = ((Map)localObject2).get("url");
        paramString2 = (String)localObject1;
        if (localObject3 != null)
        {
          paramString2 = (String)localObject1;
          if ((localObject3 instanceof String)) {
            paramString2 = (String)localObject3;
          }
        }
        try
        {
          localObject1 = ((Map)localObject2).get("data");
          if ((localObject1 == null) || (!(localObject1 instanceof Map))) {
            break label383;
          }
          localObject2 = (Map)localObject1;
          localObject1 = new StringBuilder();
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
            localObject3 = ((Map.Entry)localObject4).getKey();
            localObject4 = ((Map.Entry)localObject4).getValue();
            if ((localObject3 != null) && ((localObject3 instanceof String)) && (localObject4 != null))
            {
              ((StringBuilder)localObject1).append("&");
              ((StringBuilder)localObject1).append(localObject3);
              ((StringBuilder)localObject1).append("=");
              ((StringBuilder)localObject1).append(localObject4.toString());
            }
          }
          if (!QLog.isColorLevel()) {
            break label256;
          }
        }
        catch (JSONException localJSONException) {}
      }
      catch (JSONException paramString2)
      {
        for (;;)
        {
          paramString2 = null;
        }
      }
      QLog.i("ArkApp", 1, "ArkAppSchemeCenter.AppSchemeHandler.jsonParseError");
      label256:
      if (!isAppInstalled(localBaseActivity, paramString4)) {
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1 = new Intent(localBaseActivity, QQBrowserActivity.class);
          paramString1.putExtra("url", paramString2);
          ArkAppCenter.r(paramString1, paramString3);
          paramString1.putExtra("fromArkAppDownload", true);
          localBaseActivity.startActivity(paramString1);
        }
      }
      for (;;)
      {
        return true;
        String str2 = str1 + localJSONException;
        str1 = str2;
        break;
        if (QLog.isColorLevel())
        {
          QLog.i("ArkApp", 1, "ArkAppSchemeCenter.AppSchemeHandler, download url is empty");
          continue;
          c(localBaseActivity, paramString1, str1, paramString4, "0");
        }
      }
    }
    
    private boolean isAppInstalled(Context paramContext, String paramString)
    {
      boolean bool = false;
      paramContext = paramContext.getPackageManager();
      try
      {
        paramContext = paramContext.getPackageInfo(paramString.trim(), 0);
        if (paramContext != null) {
          bool = true;
        }
        return bool;
      }
      catch (Exception paramContext) {}
      return false;
    }
    
    public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
    {
      if (paramLong != 0L) {
        return false;
      }
      paramString3 = BaseActivity.sTopActivity;
      if (paramString3 == null) {
        return false;
      }
      if (TextUtils.isEmpty(paramString1)) {
        return false;
      }
      if (paramJSONObject == null) {}
      for (paramJSONObject = "biz_src_jc_ark";; paramJSONObject = paramJSONObject.optString("businessId", "biz_src_jc_ark"))
      {
        String str = BaseApplication.getContext().getSharedPreferences("arkappid2pkname_entry", 4).getString(paramString1, null);
        if ((str == null) || (str.length() <= 0) || (!isAppInstalled(paramString3, str))) {
          break;
        }
        e(paramString1, paramString2, paramJSONObject, str);
        return true;
      }
      paramString3 = getAppInterface();
      if (paramString3 == null)
      {
        QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate.app is null.");
        return false;
      }
      ((ArkAppCenter)paramString3.getManager(121)).a(paramString1, this, new adok(this, paramString2, paramJSONObject));
      return true;
    }
    
    protected QQAppInterface getAppInterface()
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        return (QQAppInterface)localAppRuntime;
      }
      return null;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3);
  }
  
  public static class c
    implements adoj.b
  {
    public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
    {
      if (paramLong != 0L) {
        return false;
      }
      paramString2 = BaseActivity.sTopActivity;
      if (paramString2 == null) {
        return false;
      }
      if (paramString1.startsWith("open/")) {
        try
        {
          int j = Integer.parseInt(paramString1.substring("open/".length(), paramString1.indexOf("?")));
          paramJSONObject = (String)aurr.getArgumentsFromURL(paramString1).get("url");
          int i = j;
          if (j != 1007)
          {
            i = j;
            if (j != 1008)
            {
              i = j;
              if (j != 1014)
              {
                i = j;
                if (j != 1036)
                {
                  i = j;
                  if (j != 2061)
                  {
                    i = j;
                    if (j != 2072)
                    {
                      i = j;
                      if (j != 2075)
                      {
                        i = j;
                        if (j != 2085)
                        {
                          i = j;
                          if (j != 2105) {
                            i = 2059;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          MiniAppLauncher.startMiniApp(paramString2, paramJSONObject, i, adoj.b(), null);
          return true;
        }
        catch (Exception paramString2)
        {
          QLog.e("ArkApp", 1, "parse miniapp scheme failed:" + paramString1, paramString2);
          return false;
        }
      }
      return false;
    }
  }
  
  public static class d
    implements adoj.b
  {
    private void c(Map<String, Object> paramMap, Map<String, String> paramMap1)
    {
      paramMap = new ArkAppSchemeCenter.QQSchemeHandler.1(this, paramMap, paramMap1);
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        ThreadManagerV2.getUIHandlerV2().post(paramMap);
        return;
      }
      paramMap.run();
    }
    
    private void d(Map<String, Object> paramMap, Map<String, String> paramMap1)
    {
      paramMap = new ArkAppSchemeCenter.QQSchemeHandler.2(this, paramMap, paramMap1);
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        ThreadManagerV2.getUIHandlerV2().post(paramMap);
        return;
      }
      paramMap.run();
    }
    
    private void e(Map<String, Object> paramMap, Map<String, String> paramMap1)
    {
      paramMap = new ArkAppSchemeCenter.QQSchemeHandler.3(this, paramMap, paramMap1);
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        ThreadManagerV2.getUIHandlerV2().post(paramMap);
        return;
      }
      paramMap.run();
    }
    
    private void fr(String paramString1, String paramString2)
    {
      Map localMap;
      try
      {
        QLog.i("QQSchemeHandler", 1, "handleTogether " + paramString1 + paramString2);
        paramString1 = aurr.getArgumentsFromURL(paramString1);
        localMap = adoj.b(new JSONObject(paramString2));
        Object localObject = localMap.get("type");
        if ((localObject == null) || (!(localObject instanceof String))) {
          break label165;
        }
        paramString2 = ((String)localObject).toLowerCase();
        if ("watch".equals(paramString2))
        {
          c(localMap, paramString1);
          return;
        }
        if ("sing".equals(paramString2))
        {
          d(localMap, paramString1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("QQSchemeHandler", 1, paramString1, new Object[0]);
        return;
      }
      if ("listen".equals(paramString2))
      {
        e(localMap, paramString1);
        return;
      }
      QLog.i("QQSchemeHandler", 1, "handleTogether type no support" + paramString2);
      return;
      label165:
      QLog.i("QQSchemeHandler", 1, "handleTogether metaJson error" + paramString2);
    }
    
    protected void GF(String paramString)
    {
      String str1 = null;
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      String str2;
      String str3;
      if ((localBaseActivity instanceof FragmentActivity))
      {
        str2 = "";
        str3 = "";
      }
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          if (!localJSONObject.has("lat")) {
            break label196;
          }
          paramString = localJSONObject.getString("lat");
          if (localJSONObject.has("lon")) {
            str1 = localJSONObject.getString("lon");
          }
          if (localJSONObject.has("title")) {
            str2 = localJSONObject.getString("title");
          }
          if (localJSONObject.has("loc")) {
            str3 = localJSONObject.getString("loc");
          }
          if ((paramString == null) || (str1 == null)) {
            return;
          }
        }
        catch (JSONException paramString)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("ArkApp", 1, "QQ.showQMapView parameter error: " + paramString.getMessage());
          return;
        }
        paramString = aqik.c(getAppInterface(), localBaseActivity, String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=%s&lon=%s&title=%s&loc=%s&dpid=null", new Object[] { paramString, str1, str2, str3 }));
        if (paramString != null)
        {
          paramString.ace();
          return;
          label196:
          paramString = null;
        }
      }
    }
    
    /* Error */
    public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
    {
      // Byte code:
      //   0: lload 4
      //   2: lconst_0
      //   3: lcmp
      //   4: ifeq +5 -> 9
      //   7: iconst_0
      //   8: ireturn
      //   9: aload_1
      //   10: ldc 196
      //   12: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   15: ifeq +66 -> 81
      //   18: getstatic 141	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
      //   21: instanceof 143
      //   24: ifeq +55 -> 79
      //   27: getstatic 141	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
      //   30: checkcast 143	android/support/v4/app/FragmentActivity
      //   33: invokevirtual 200	android/support/v4/app/FragmentActivity:getSupportFragmentManager	()Landroid/support/v4/app/FragmentManager;
      //   36: ldc 202
      //   38: invokevirtual 207	java/lang/Class:getName	()Ljava/lang/String;
      //   41: invokevirtual 213	android/support/v4/app/FragmentManager:findFragmentByTag	(Ljava/lang/String;)Landroid/support/v4/app/Fragment;
      //   44: checkcast 202	com/tencent/mobileqq/activity/ChatFragment
      //   47: checkcast 202	com/tencent/mobileqq/activity/ChatFragment
      //   50: astore_1
      //   51: aload_1
      //   52: ifnull +27 -> 79
      //   55: aload_1
      //   56: invokevirtual 216	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
      //   59: astore_1
      //   60: aload_1
      //   61: ifnull +18 -> 79
      //   64: aload_1
      //   65: instanceof 218
      //   68: ifeq +11 -> 79
      //   71: aload_1
      //   72: checkcast 218	ycd
      //   75: aload_2
      //   76: invokevirtual 221	ycd:yx	(Ljava/lang/String;)V
      //   79: iconst_1
      //   80: ireturn
      //   81: aload_1
      //   82: ldc 223
      //   84: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   87: ifeq +10 -> 97
      //   90: aload_0
      //   91: aload_2
      //   92: invokevirtual 225	adoj$d:GF	(Ljava/lang/String;)V
      //   95: iconst_1
      //   96: ireturn
      //   97: ldc 227
      //   99: aload_1
      //   100: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   103: ifeq +31 -> 134
      //   106: aload_0
      //   107: invokevirtual 176	adoj$d:getAppInterface	()Lcom/tencent/mobileqq/app/QQAppInterface;
      //   110: astore_1
      //   111: aload_1
      //   112: ifnull +20 -> 132
      //   115: aload_1
      //   116: sipush 153
      //   119: invokevirtual 233	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
      //   122: checkcast 235	abhh
      //   125: invokevirtual 238	abhh:a	()Labhf;
      //   128: aload_2
      //   129: invokevirtual 243	abhf:BC	(Ljava/lang/String;)V
      //   132: iconst_1
      //   133: ireturn
      //   134: ldc 245
      //   136: aload_1
      //   137: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   140: ifeq +124 -> 264
      //   143: new 89	org/json/JSONObject
      //   146: dup
      //   147: aload_2
      //   148: invokespecial 92	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   151: astore_1
      //   152: aload_1
      //   153: ldc 247
      //   155: invokevirtual 251	org/json/JSONObject:getLong	(Ljava/lang/String;)J
      //   158: lstore 4
      //   160: aload_1
      //   161: ldc 253
      //   163: invokevirtual 251	org/json/JSONObject:getLong	(Ljava/lang/String;)J
      //   166: lstore 7
      //   168: aload_1
      //   169: ldc 255
      //   171: invokevirtual 258	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   174: astore_1
      //   175: aload_0
      //   176: invokevirtual 176	adoj$d:getAppInterface	()Lcom/tencent/mobileqq/app/QQAppInterface;
      //   179: astore_2
      //   180: aload_2
      //   181: ifnull +37 -> 218
      //   184: aload_2
      //   185: bipush 20
      //   187: invokevirtual 262	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
      //   190: checkcast 264	acms
      //   193: new 64	java/lang/StringBuilder
      //   196: dup
      //   197: invokespecial 65	java/lang/StringBuilder:<init>	()V
      //   200: lload 4
      //   202: invokevirtual 267	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   205: ldc 145
      //   207: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   210: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   213: lload 7
      //   215: invokevirtual 271	acms:aa	(Ljava/lang/String;J)V
      //   218: ldc_w 273
      //   221: ldc_w 275
      //   224: ldc_w 277
      //   227: iconst_1
      //   228: iconst_0
      //   229: iconst_1
      //   230: anewarray 106	java/lang/String
      //   233: dup
      //   234: iconst_0
      //   235: lload 4
      //   237: invokestatic 281	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   240: aastore
      //   241: invokestatic 286	aqfr:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
      //   244: getstatic 141	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
      //   247: aload_1
      //   248: iconst_1
      //   249: invokestatic 292	kgw:f	(Landroid/content/Context;Ljava/lang/String;I)V
      //   252: iconst_0
      //   253: ireturn
      //   254: astore_2
      //   255: aconst_null
      //   256: astore_1
      //   257: aload_2
      //   258: invokevirtual 295	org/json/JSONException:printStackTrace	()V
      //   261: goto -17 -> 244
      //   264: ldc_w 297
      //   267: aload_1
      //   268: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   271: ifeq +13 -> 284
      //   274: invokestatic 302	adpa:a	()Ladpa;
      //   277: aload_2
      //   278: invokevirtual 305	adpa:GI	(Ljava/lang/String;)V
      //   281: goto -29 -> 252
      //   284: ldc_w 307
      //   287: aload_1
      //   288: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   291: ifeq +43 -> 334
      //   294: aload_2
      //   295: invokestatic 310	aqfr:Ux	(Ljava/lang/String;)V
      //   298: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   301: ifeq -49 -> 252
      //   304: ldc_w 312
      //   307: iconst_2
      //   308: new 64	java/lang/StringBuilder
      //   311: dup
      //   312: invokespecial 65	java/lang/StringBuilder:<init>	()V
      //   315: ldc_w 314
      //   318: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   321: aload_2
      //   322: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   325: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   328: invokestatic 316	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   331: goto -79 -> 252
      //   334: ldc_w 318
      //   337: aload_1
      //   338: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   341: ifeq +156 -> 497
      //   344: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   347: ifeq +30 -> 377
      //   350: ldc_w 320
      //   353: iconst_2
      //   354: new 64	java/lang/StringBuilder
      //   357: dup
      //   358: invokespecial 65	java/lang/StringBuilder:<init>	()V
      //   361: ldc_w 322
      //   364: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   367: aload_2
      //   368: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   371: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   374: invokestatic 81	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   377: aload_0
      //   378: invokevirtual 176	adoj$d:getAppInterface	()Lcom/tencent/mobileqq/app/QQAppInterface;
      //   381: astore_1
      //   382: aload_1
      //   383: ifnull -131 -> 252
      //   386: aload_1
      //   387: sipush 312
      //   390: invokevirtual 233	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
      //   393: checkcast 324	alsg
      //   396: astore_1
      //   397: aload_1
      //   398: aload_2
      //   399: invokevirtual 327	alsg:OL	(Ljava/lang/String;)V
      //   402: aload_1
      //   403: aload_2
      //   404: invokevirtual 330	alsg:a	(Ljava/lang/String;)Laeoq$a;
      //   407: astore_1
      //   408: aload_1
      //   409: ifnull +53 -> 462
      //   412: aload_1
      //   413: getfield 336	aeoq$a:resUrl	Ljava/lang/String;
      //   416: invokestatic 342	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   419: ifne +43 -> 462
      //   422: invokestatic 347	awll:a	()Lawll;
      //   425: invokevirtual 350	awll:aNh	()Z
      //   428: ifeq +34 -> 462
      //   431: invokestatic 355	awlg:a	()Lawlg;
      //   434: invokevirtual 358	awlg:eEo	()V
      //   437: invokestatic 355	awlg:a	()Lawlg;
      //   440: invokevirtual 361	awlg:eEn	()V
      //   443: ldc_w 363
      //   446: iconst_1
      //   447: aconst_null
      //   448: invokestatic 368	asgf:b	(Ljava/lang/String;ZLasge$a;)V
      //   451: invokestatic 347	awll:a	()Lawll;
      //   454: aload_1
      //   455: aconst_null
      //   456: invokevirtual 371	awll:a	(Laeoq$a;Lawkt;)V
      //   459: goto -207 -> 252
      //   462: ldc_w 320
      //   465: iconst_1
      //   466: new 64	java/lang/StringBuilder
      //   469: dup
      //   470: invokespecial 65	java/lang/StringBuilder:<init>	()V
      //   473: ldc_w 373
      //   476: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   479: invokestatic 347	awll:a	()Lawll;
      //   482: invokevirtual 350	awll:aNh	()Z
      //   485: invokevirtual 376	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   488: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   491: invokestatic 81	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   494: goto -242 -> 252
      //   497: ldc_w 378
      //   500: aload_1
      //   501: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   504: ifeq +206 -> 710
      //   507: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   510: ifeq +30 -> 540
      //   513: ldc_w 320
      //   516: iconst_2
      //   517: new 64	java/lang/StringBuilder
      //   520: dup
      //   521: invokespecial 65	java/lang/StringBuilder:<init>	()V
      //   524: ldc_w 380
      //   527: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   530: aload_2
      //   531: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   534: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   537: invokestatic 81	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   540: aload_0
      //   541: invokevirtual 176	adoj$d:getAppInterface	()Lcom/tencent/mobileqq/app/QQAppInterface;
      //   544: astore_1
      //   545: aload_1
      //   546: ifnull -294 -> 252
      //   549: aload_1
      //   550: sipush 312
      //   553: invokevirtual 233	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
      //   556: checkcast 324	alsg
      //   559: astore_3
      //   560: aload_3
      //   561: aload_2
      //   562: invokevirtual 330	alsg:a	(Ljava/lang/String;)Laeoq$a;
      //   565: astore_1
      //   566: aload_1
      //   567: ifnull +103 -> 670
      //   570: aload_1
      //   571: getfield 336	aeoq$a:resUrl	Ljava/lang/String;
      //   574: invokestatic 342	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   577: ifne +93 -> 670
      //   580: invokestatic 347	awll:a	()Lawll;
      //   583: invokevirtual 350	awll:aNh	()Z
      //   586: ifeq +84 -> 670
      //   589: sipush 600
      //   592: invokestatic 384	awlg:bZ	(I)Z
      //   595: ifeq +62 -> 657
      //   598: new 386	android/content/Intent
      //   601: dup
      //   602: getstatic 141	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
      //   605: ldc_w 388
      //   608: invokespecial 391	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
      //   611: astore_2
      //   612: aload_2
      //   613: ldc_w 393
      //   616: aload_1
      //   617: getfield 336	aeoq$a:resUrl	Ljava/lang/String;
      //   620: invokevirtual 397	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   623: pop
      //   624: aload_2
      //   625: ldc_w 399
      //   628: aload_1
      //   629: getfield 402	aeoq$a:md5	Ljava/lang/String;
      //   632: invokevirtual 397	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   635: pop
      //   636: aload_2
      //   637: ldc_w 404
      //   640: ldc_w 406
      //   643: invokevirtual 397	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   646: pop
      //   647: getstatic 141	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
      //   650: aload_2
      //   651: invokevirtual 410	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
      //   654: goto -402 -> 252
      //   657: ldc_w 320
      //   660: iconst_1
      //   661: ldc_w 412
      //   664: invokestatic 81	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   667: goto -415 -> 252
      //   670: ldc_w 320
      //   673: iconst_1
      //   674: new 64	java/lang/StringBuilder
      //   677: dup
      //   678: invokespecial 65	java/lang/StringBuilder:<init>	()V
      //   681: ldc_w 414
      //   684: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   687: invokestatic 347	awll:a	()Lawll;
      //   690: invokevirtual 350	awll:aNh	()Z
      //   693: invokevirtual 376	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   696: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   699: invokestatic 81	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   702: aload_3
      //   703: aload_2
      //   704: invokevirtual 417	alsg:fJ	(Ljava/lang/String;)V
      //   707: goto -455 -> 252
      //   710: aload_1
      //   711: ldc_w 419
      //   714: invokevirtual 422	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   717: ifeq -465 -> 252
      //   720: aload_0
      //   721: aload_1
      //   722: aload_2
      //   723: invokespecial 424	adoj$d:fr	(Ljava/lang/String;Ljava/lang/String;)V
      //   726: iconst_1
      //   727: ireturn
      //   728: astore_2
      //   729: goto -472 -> 257
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	732	0	this	d
      //   0	732	1	paramString1	String
      //   0	732	2	paramString2	String
      //   0	732	3	paramJSONObject	JSONObject
      //   0	732	4	paramLong	long
      //   0	732	6	paramString3	String
      //   166	48	7	l	long
      // Exception table:
      //   from	to	target	type
      //   143	175	254	org/json/JSONException
      //   175	180	728	org/json/JSONException
      //   184	218	728	org/json/JSONException
      //   218	244	728	org/json/JSONException
    }
    
    protected QQAppInterface getAppInterface()
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        return (QQAppInterface)localAppRuntime;
      }
      return null;
    }
  }
  
  public static class e
    implements adoj.b
  {
    public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
    {
      if (paramLong != 0L) {}
      do
      {
        return false;
        paramJSONObject = BaseActivity.sTopActivity;
      } while (paramJSONObject == null);
      paramString3 = new Intent(paramJSONObject, TranslucentActivity.class);
      paramString3.addFlags(268435456);
      QzonePluginProxyActivity.x(paramString3, "com.qzone.misc.web.QZoneTranslucentActivity");
      paramString3.setAction("action_js2qzone");
      paramString3.putExtra("cmd", "Schema");
      paramString2 = paramString1;
      if (paramString1.startsWith("arouse/detailbyurl?base64url"))
      {
        paramString2 = paramString1;
        if (!paramString1.contains("from")) {
          paramString2 = paramString1 + "&from=aio";
        }
      }
      paramString3.putExtra("schema", "mqzone://" + paramString2);
      paramString3.putExtra("from", 2);
      paramJSONObject.startActivity(paramString3);
      return true;
    }
  }
  
  public static class f
    implements adoj.b
  {
    public void GG(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      ArkAppCenter.a().postToMainThread(new ArkAppSchemeCenter.TelSchemeHandler.1(this, paramString));
    }
    
    public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
    {
      ArkAppCenter.a().send(paramString3, new ArkAppSchemeCenter.TelSchemeHandler.2(this, paramString3, paramString1, paramLong, paramString2));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adoj
 * JD-Core Version:    0.7.0.1
 */