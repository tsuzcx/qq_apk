import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.app.WtloginPrivacyListenerImpl;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.json.JSONException;
import org.json.JSONObject;

public class aiiu
  extends WebViewPlugin
{
  private ardm.m jdField_a_of_type_Ardm$m;
  private ardm.o jdField_a_of_type_Ardm$o;
  private ardm.q jdField_a_of_type_Ardm$q;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  private ardm.c b;
  jml mAuthConfig;
  skj mClient;
  protected Client.b mOnRemoteResp = new aiiv(this);
  
  public aiiu()
  {
    this.mPluginNameSpace = "data";
  }
  
  private void Lk(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if ((TextUtils.isEmpty(paramString)) || (!((AppInterface)localObject).isLogin())) {}
    String str1;
    do
    {
      do
      {
        return;
        str1 = ((AppInterface)localObject).getAccount();
        localObject = CookieManager.getInstance().getCookie(paramString);
      } while ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).contains("uin=")));
      String str2 = SwiftBrowserCookieMonster.pX(str1);
      str1 = jqo.dV(paramString);
      QLog.e("DataApiPlugin", 1, "can not find uin from " + jqo.filterKeyForLog(paramString, new String[0]) + ", dump cookie: " + jqo.b((String)localObject, new String[0]));
      if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
      {
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
      }
      localObject = String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=21600;", new Object[] { "uin", str2, str1 });
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString, (String)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("DataApiPlugin", 2, "set uin cookie for host " + str1 + ", cookie : " + jqo.b((String)localObject, new String[0]));
  }
  
  private void gw(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.a();
    if ((TextUtils.isEmpty(paramString1)) || (!((AppInterface)localObject).isLogin())) {}
    do
    {
      do
      {
        return;
        str = ((AppInterface)localObject).getAccount();
        localObject = CookieManager.getInstance().getCookie(paramString1);
      } while ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).contains("p_uin=")));
      String str = SwiftBrowserCookieMonster.pX(str);
      QLog.e("DataApiPlugin", 1, "can not find p_uin from " + jqo.filterKeyForLog(paramString1, new String[0]) + ", dump cookie: " + jqo.b((String)localObject, new String[0]));
      if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
      {
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
      }
      localObject = String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=21600;", new Object[] { "p_uin", str, paramString2 });
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, (String)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("DataApiPlugin", 2, "set p_uin cookie for host " + paramString2 + ", cookie: " + jqo.b((String)localObject, new String[0]));
  }
  
  private void j(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    long l = 0L;
    String str = null;
    if ((this.jdField_a_of_type_Ardm$m != null) && (this.jdField_a_of_type_Ardm$q != null))
    {
      i = this.jdField_a_of_type_Ardm$m.zP();
      l = this.jdField_a_of_type_Ardm$q.getmClickTime();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfString[0]);
      int j = localJSONObject.getJSONObject("data").getInt("status");
      paramArrayOfString = "onFirstLine";
      paramString = "state_activity_first_line";
      if ((j != 12) && (j != 13))
      {
        if (str != null) {
          str.Wg(paramString);
        }
        if ((i < j) && (this.jdField_a_of_type_Ardm$o != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQBrowser_report", 2, "try report web status, " + paramArrayOfString + ", step: " + j + ", stepTime: " + (System.currentTimeMillis() - l) + ", totalTime: " + (System.currentTimeMillis() - l) + ", \n " + this.jdField_a_of_type_Ardm$o.getCurrentUrl());
          }
          if (this.jdField_a_of_type_Ardm$m == null) {
            break label306;
          }
          this.jdField_a_of_type_Ardm$m.HY(j);
          this.jdField_a_of_type_Ardm$m.gY(System.currentTimeMillis());
        }
        label232:
        while (str == null)
        {
          paramString = localJSONObject.optString("callback");
          if (!TextUtils.isEmpty(paramString)) {
            callJs(paramString, new String[] { "{\"result\": 0}" });
          }
          return;
          paramString = (arbz)super.getBrowserComponent(-2);
          str = paramString;
          if (paramString == null) {
            break;
          }
          i = paramString.a.mCurrentStep;
          l = paramString.mClickTime;
          str = paramString;
          break;
          paramArrayOfString = "onPageFinished";
          break label424;
        }
        label299:
        label306:
        str.a.mCurrentStep = j;
        str.a.aiB = System.currentTimeMillis();
        switch (j)
        {
        }
      }
      for (;;)
      {
        str.avk = (str.a.aiB - l);
        break label232;
        str.avl = (str.a.aiB - l);
        break label232;
        str.avm = (str.a.aiB - l);
        break label232;
        if (j != 12) {
          break label299;
        }
        paramArrayOfString = "onPageVisible";
        label424:
        if (j == 12)
        {
          paramString = "state_first_screen";
          break;
        }
        paramString = "state_page_finished";
        break;
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  void a(String paramString1, WUserSigInfo paramWUserSigInfo, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (paramWUserSigInfo == null)
    {
      gv(paramString2, "get WUserSigInfo = null");
      return;
    }
    int i = 0;
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    String str = jqo.getSpecifiedLevelDomain(paramString1, 1);
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if ((paramInt & 0x1000) != 0)
    {
      localObject2 = null;
      localObject3 = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4096);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Ticket)localObject3)._sig != null) {
          localObject1 = new String(((Ticket)localObject3)._sig);
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label404;
      }
      j = -2;
      localStringBuilder.append("skey获取失败;");
      label112:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label444;
      }
      QLog.i("DataApiPlugin", 1, jqo.b("skey=" + (String)localObject1, new String[0]));
      label154:
      i = j;
      if (localObject3 != null)
      {
        QLog.i("DataApiPlugin", 1, "last refresh skey time: " + ((Ticket)localObject3)._create_time);
        localStringBuilder.append("skey create time: " + ((Ticket)localObject3)._create_time);
        i = j;
      }
    }
    if (((0x100000 & paramInt) != 0) && ((0x8000000 & paramInt) == 0))
    {
      localObject2 = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 1048576);
      if ((localObject2 == null) || (((Ticket)localObject2)._pskey_map == null))
      {
        i = -2;
        localStringBuilder.append("pskey获取失败;Ticket = null or ticket._pskey_map = null");
        label280:
        if ((0x8000000 & paramInt) == 0) {
          break label812;
        }
        paramWUserSigInfo = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 1048576);
        if (paramWUserSigInfo != null) {
          break label662;
        }
        paramInt = -2;
        localStringBuilder.append("pt4token获取失败;Ticket = null");
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject();
        paramString1.put("result", paramInt);
        if (paramInt < 0) {
          paramString1.put("message", localStringBuilder.toString());
        }
        callJs(paramString2, new String[] { paramString1.toString() });
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("DataApiPlugin", 2, "updateLoginInfo error: " + paramString1.getMessage());
      return;
      label404:
      localObject2 = String.format("skey=%1$s; PATH=/; DOMAIN=.%2$s;", new Object[] { localObject1, str });
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, (String)localObject2);
      Lk(paramString1);
      break label112;
      label444:
      QLog.e("DataApiPlugin", 1, "skey is null!");
      break label154;
      localObject3 = (byte[])((Ticket)localObject2)._pskey_map.get(paramString3);
      localObject1 = new String();
      if (localObject3 != null) {
        localObject1 = new String((byte[])localObject3);
      }
      for (;;)
      {
        QLog.i("DataApiPlugin", 1, "last refresh pskey time: " + ((Ticket)localObject2)._create_time);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label603;
        }
        i = -2;
        localStringBuilder.append("pskey获取失败;pskey = null, create time: " + ((Ticket)localObject2)._create_time);
        break;
        QLog.e("DataApiPlugin", 1, "onDoneGetTicket pskey_map not contain domain: " + paramString3);
      }
      label603:
      localObject1 = "p_skey=" + (String)localObject1 + "; PATH=/; DOMAIN=." + paramString3 + ';';
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, (String)localObject1);
      gw(paramString1, paramString3);
      break label280;
      label662:
      paramString3 = new String((byte[])paramWUserSigInfo._pt4token_map.get(paramString4));
      QLog.i("DataApiPlugin", 1, "last refresh pt4token time: " + paramWUserSigInfo._create_time);
      if (TextUtils.isEmpty(paramString3))
      {
        paramInt = -2;
        localStringBuilder.append("pt4token获取失败;pt4token = null, create time: " + paramWUserSigInfo._create_time);
      }
      for (;;)
      {
        paramWUserSigInfo = "pt4_token=" + paramString3 + "; PATH=/; DOMAIN=." + paramString4 + ';';
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, paramWUserSigInfo);
        break;
        paramInt = i;
      }
      label812:
      paramInt = i;
    }
  }
  
  public void gu(String paramString1, String paramString2)
  {
    String str1;
    int i;
    String str2;
    JSONObject localJSONObject;
    String str3;
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor;
    Object localObject1;
    int k;
    int j;
    String str4;
    try
    {
      str1 = aqrs.d(this.mRuntime.a(), "ticketInterval");
      if (TextUtils.isEmpty(str1)) {
        break label1001;
      }
      i = Integer.parseInt(str1);
      localObject2 = new JSONObject(paramString1);
      str2 = ((JSONObject)localObject2).optString("callback");
      localJSONObject = new JSONObject();
      if (!this.mRuntime.a().isLogin())
      {
        localJSONObject.put("result", -2);
        localJSONObject.put("message", acfp.m(2131704604));
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
      }
      str3 = this.mRuntime.a().getCurrentAccountUin();
      localSharedPreferences = this.mRuntime.a().getApplication().getSharedPreferences(str3 + "_get_ticket_interval", 0);
      localEditor = localSharedPreferences.edit();
      if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
      {
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
      }
      if (this.mAuthConfig == null) {
        this.mAuthConfig = jml.a();
      }
      str1 = null;
      localObject1 = null;
      paramString1 = null;
      k = 0;
      j = 0;
      str4 = ((JSONObject)localObject2).optString("key");
      if (!TextUtils.isEmpty(str4)) {
        break label320;
      }
      localJSONObject.put("result", -2);
      localJSONObject.put("message", "参数key为空");
      callJs(str2, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString1)
    {
      if (!QLog.isColorLevel()) {
        break label1008;
      }
    }
    QLog.e("DataApiPlugin", 2, "updateLoginInfo error: " + paramString1.getMessage());
    return;
    label320:
    Object localObject2 = new WUserSigInfo();
    long l;
    if ("skey".equals(str4))
    {
      l = localSharedPreferences.getLong("skey", 0L);
      if (System.currentTimeMillis() - l > i * 1000)
      {
        localEditor.putLong("skey", System.currentTimeMillis());
        localEditor.commit();
        i = j;
        if (!this.mAuthConfig.cQ(paramString2)) {
          break label1009;
        }
        i = 4096;
        break label1009;
      }
    }
    label1001:
    label1008:
    label1009:
    label1012:
    for (;;)
    {
      if (i == 0)
      {
        localJSONObject.put("result", -2);
        localJSONObject.put("message", acfp.m(2131704606));
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("result", 1);
        localJSONObject.put("message", acfp.m(2131704605));
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
        if ("pskey".equals(str4))
        {
          str1 = this.mAuthConfig.dH(paramString2);
          l = localSharedPreferences.getLong("pskey_" + str1, 0L);
          if (System.currentTimeMillis() - l > i * 1000)
          {
            localEditor.putLong("pskey_" + str1, System.currentTimeMillis());
            localEditor.commit();
            i = k;
            if (TextUtils.isEmpty(str1)) {
              break label1012;
            }
            ((WUserSigInfo)localObject2)._domains.add(str1);
            i = 1048576;
            break label1012;
          }
          localJSONObject.put("result", 1);
          localJSONObject.put("message", acfp.m(2131704607));
          callJs(str2, new String[] { localJSONObject.toString() });
          return;
        }
        paramString1 = (String)localObject1;
        if ("pt4_token".equals(str4))
        {
          localObject1 = this.mAuthConfig.dI(paramString2);
          l = localSharedPreferences.getLong("pt4_token_" + (String)localObject1, 0L);
          if (System.currentTimeMillis() - l > i * 1000)
          {
            localEditor.putLong("pt4_token_" + (String)localObject1, System.currentTimeMillis());
            localEditor.commit();
            paramString1 = (String)localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              ((WUserSigInfo)localObject2)._domains.add(String.format(Locale.getDefault(), "(%d)%s", new Object[] { Integer.valueOf(134217728), localObject1 }));
              i = 135266304;
              paramString1 = (String)localObject1;
            }
          }
          else
          {
            localJSONObject.put("result", 1);
            localJSONObject.put("message", acfp.m(2131704608));
            callJs(str2, new String[] { localJSONObject.toString() });
          }
        }
      }
      else
      {
        QLog.d("DataApiPlugin", 1, "GetStWithoutPasswd|key=" + i);
        localObject1 = new WtloginHelper(this.mRuntime.a().getApplication(), WtloginPrivacyListenerImpl.getSingleton());
        ((WtloginHelper)localObject1).setCallSource(30);
        ((WtloginHelper)localObject1).SetListener(new aiiu.a(paramString2, str2, str1, paramString1));
        ((WtloginHelper)localObject1).GetStWithoutPasswd(str3, 16L, 16L, 1L, i, (WUserSigInfo)localObject2);
        return;
      }
      i = 0;
      continue;
      i = 28800;
      break;
      return;
    }
  }
  
  void gv(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", -2);
      localJSONObject.put("message", paramString2);
      callJs(paramString1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("DataApiPlugin", 2, "updateLoginInfo error: " + paramString1.getMessage());
    }
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 32
    //   2: aload_3
    //   3: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +4966 -> 4972
    //   9: ldc_w 547
    //   12: aload 4
    //   14: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +1145 -> 1162
    //   20: aload 5
    //   22: arraylength
    //   23: iconst_1
    //   24: if_icmpne +1138 -> 1162
    //   27: new 182	org/json/JSONObject
    //   30: dup
    //   31: aload 5
    //   33: iconst_0
    //   34: aaload
    //   35: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   38: ldc 246
    //   40: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 11
    //   45: aload_0
    //   46: getfield 43	aiiu:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   49: invokevirtual 551	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   52: invokevirtual 556	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull +4968 -> 5027
    //   62: aload 5
    //   64: ldc_w 558
    //   67: invokevirtual 561	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   70: ifeq +4957 -> 5027
    //   73: aload 5
    //   75: invokestatic 566	jpa:dN	(Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 5
    //   80: aload_0
    //   81: getfield 43	aiiu:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   84: invokevirtual 48	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   87: astore 17
    //   89: aload 5
    //   91: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifne +11 -> 105
    //   97: aload 17
    //   99: invokevirtual 60	com/tencent/common/app/AppInterface:isLogin	()Z
    //   102: ifne +29 -> 131
    //   105: aload 11
    //   107: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +21 -> 131
    //   113: aload_0
    //   114: aload 11
    //   116: iconst_1
    //   117: anewarray 78	java/lang/String
    //   120: dup
    //   121: iconst_0
    //   122: ldc_w 568
    //   125: aastore
    //   126: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   129: iconst_1
    //   130: ireturn
    //   131: aload_0
    //   132: getfield 438	aiiu:mAuthConfig	Ljml;
    //   135: ifnonnull +10 -> 145
    //   138: aload_0
    //   139: invokestatic 443	jml:a	()Ljml;
    //   142: putfield 438	aiiu:mAuthConfig	Ljml;
    //   145: aload_0
    //   146: getfield 438	aiiu:mAuthConfig	Ljml;
    //   149: aload 5
    //   151: invokevirtual 571	jml:dE	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +915 -> 1072
    //   160: iconst_1
    //   161: istore 6
    //   163: aload_0
    //   164: getfield 438	aiiu:mAuthConfig	Ljml;
    //   167: aload 5
    //   169: invokevirtual 473	jml:cQ	(Ljava/lang/String;)Z
    //   172: istore 9
    //   174: aload_0
    //   175: getfield 438	aiiu:mAuthConfig	Ljml;
    //   178: aload 5
    //   180: invokevirtual 574	jml:dJ	(Ljava/lang/String;)Ljava/lang/String;
    //   183: astore 13
    //   185: aload_0
    //   186: getfield 438	aiiu:mAuthConfig	Ljml;
    //   189: aload 5
    //   191: invokevirtual 497	jml:dI	(Ljava/lang/String;)Ljava/lang/String;
    //   194: astore 16
    //   196: aload_0
    //   197: getfield 438	aiiu:mAuthConfig	Ljml;
    //   200: aload 5
    //   202: invokevirtual 480	jml:dH	(Ljava/lang/String;)Ljava/lang/String;
    //   205: astore 18
    //   207: aload 17
    //   209: iconst_2
    //   210: invokevirtual 578	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   213: checkcast 580	mqq/manager/TicketManager
    //   216: astore 14
    //   218: new 182	org/json/JSONObject
    //   221: dup
    //   222: invokespecial 340	org/json/JSONObject:<init>	()V
    //   225: astore 12
    //   227: aload 17
    //   229: invokevirtual 64	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   232: astore 15
    //   234: aload 12
    //   236: ldc 131
    //   238: aload 15
    //   240: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   243: pop
    //   244: aload 17
    //   246: invokevirtual 422	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   249: new 95	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   256: getstatic 586	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   259: invokevirtual 587	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   262: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 15
    //   267: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokevirtual 590	mqq/app/MobileQQ:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   276: astore_1
    //   277: aload_1
    //   278: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   281: ifeq +4741 -> 5022
    //   284: invokestatic 596	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   287: invokevirtual 602	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   290: astore_2
    //   291: aload_2
    //   292: new 95	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 604
    //   302: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 15
    //   307: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 610	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   316: aconst_null
    //   317: ldc_w 612
    //   320: iconst_1
    //   321: anewarray 78	java/lang/String
    //   324: dup
    //   325: iconst_0
    //   326: aload 15
    //   328: aastore
    //   329: aconst_null
    //   330: invokestatic 618	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   333: astore_2
    //   334: aload_2
    //   335: ifnull +4681 -> 5016
    //   338: aload_2
    //   339: astore_3
    //   340: aload_2
    //   341: invokeinterface 623 1 0
    //   346: ifeq +4670 -> 5016
    //   349: aload_2
    //   350: astore_3
    //   351: aload_2
    //   352: aload_2
    //   353: ldc_w 625
    //   356: invokeinterface 628 2 0
    //   361: invokeinterface 631 2 0
    //   366: astore 4
    //   368: aload_2
    //   369: astore_3
    //   370: aload 4
    //   372: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   375: ifne +4638 -> 5013
    //   378: aload_2
    //   379: astore_3
    //   380: new 78	java/lang/String
    //   383: dup
    //   384: aload 4
    //   386: invokevirtual 635	java/lang/String:getBytes	()[B
    //   389: ldc_w 637
    //   392: invokespecial 640	java/lang/String:<init>	([BLjava/lang/String;)V
    //   395: invokestatic 645	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   398: astore 4
    //   400: aload 4
    //   402: astore_1
    //   403: aload_1
    //   404: astore 4
    //   406: aload_2
    //   407: astore_3
    //   408: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +34 -> 445
    //   414: aload_2
    //   415: astore_3
    //   416: ldc 93
    //   418: iconst_2
    //   419: new 95	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   426: ldc_w 647
    //   429: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload_1
    //   433: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: aload_1
    //   443: astore 4
    //   445: aload 4
    //   447: astore_3
    //   448: aload_2
    //   449: ifnull +12 -> 461
    //   452: aload_2
    //   453: invokeinterface 650 1 0
    //   458: aload 4
    //   460: astore_3
    //   461: aload 12
    //   463: ldc_w 652
    //   466: aload_3
    //   467: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   470: pop
    //   471: iload 6
    //   473: ifeq +3 -> 476
    //   476: iload 9
    //   478: ifeq +566 -> 1044
    //   481: aload_0
    //   482: aload 5
    //   484: invokespecial 361	aiiu:Lk	(Ljava/lang/String;)V
    //   487: aload 5
    //   489: invokestatic 91	jqo:dV	(Ljava/lang/String;)Ljava/lang/String;
    //   492: astore_1
    //   493: aload_0
    //   494: getfield 121	aiiu:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   497: ifnonnull +18 -> 515
    //   500: aload_0
    //   501: invokestatic 70	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   504: putfield 121	aiiu:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   507: aload_0
    //   508: getfield 121	aiiu:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   511: iconst_1
    //   512: invokevirtual 125	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   515: aload 14
    //   517: aload 15
    //   519: invokeinterface 655 2 0
    //   524: astore_2
    //   525: aload 12
    //   527: ldc_w 452
    //   530: aload_2
    //   531: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   534: pop
    //   535: aload_2
    //   536: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   539: ifne +89 -> 628
    //   542: ldc_w 359
    //   545: iconst_2
    //   546: anewarray 129	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: aload_2
    //   552: aastore
    //   553: dup
    //   554: iconst_1
    //   555: aload_1
    //   556: aastore
    //   557: invokestatic 135	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   560: astore_1
    //   561: aload_0
    //   562: getfield 121	aiiu:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   565: aload 5
    //   567: aload_1
    //   568: invokevirtual 139	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   574: ifeq +54 -> 628
    //   577: ldc 93
    //   579: iconst_2
    //   580: new 95	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   587: ldc_w 657
    //   590: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload_1
    //   594: iconst_0
    //   595: anewarray 78	java/lang/String
    //   598: invokestatic 110	jqo:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   601: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: ldc_w 659
    //   607: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: aload 5
    //   612: iconst_0
    //   613: anewarray 78	java/lang/String
    //   616: invokestatic 106	jqo:filterKeyForLog	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   619: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: aload 18
    //   630: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   633: ifne +144 -> 777
    //   636: aload_0
    //   637: aload 5
    //   639: aload 18
    //   641: invokespecial 386	aiiu:gw	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: aload 14
    //   646: aload 15
    //   648: aload 18
    //   650: invokeinterface 663 3 0
    //   655: astore_1
    //   656: aload_1
    //   657: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   660: ifne +117 -> 777
    //   663: aload 12
    //   665: ldc_w 665
    //   668: aload_1
    //   669: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   672: pop
    //   673: new 95	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   680: ldc_w 379
    //   683: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_1
    //   687: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: ldc_w 381
    //   693: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: aload 18
    //   698: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: bipush 59
    //   703: invokevirtual 384	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   706: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: astore_1
    //   710: aload_0
    //   711: getfield 121	aiiu:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   714: aload 5
    //   716: aload_1
    //   717: invokevirtual 139	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   723: ifeq +54 -> 777
    //   726: ldc 93
    //   728: iconst_2
    //   729: new 95	java/lang/StringBuilder
    //   732: dup
    //   733: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   736: ldc_w 657
    //   739: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload_1
    //   743: iconst_0
    //   744: anewarray 78	java/lang/String
    //   747: invokestatic 110	jqo:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   750: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: ldc_w 659
    //   756: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload 5
    //   761: iconst_0
    //   762: anewarray 78	java/lang/String
    //   765: invokestatic 106	jqo:filterKeyForLog	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   768: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: aload 16
    //   779: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   782: ifne +132 -> 914
    //   785: aload 17
    //   787: aload 16
    //   789: invokestatic 668	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:f	(Lmqq/app/AppRuntime;Ljava/lang/String;)Ljava/lang/String;
    //   792: astore_1
    //   793: aload_1
    //   794: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   797: ifne +117 -> 914
    //   800: aload 12
    //   802: ldc_w 494
    //   805: aload_1
    //   806: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   809: pop
    //   810: new 95	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   817: ldc_w 395
    //   820: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload_1
    //   824: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: ldc_w 381
    //   830: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: aload 16
    //   835: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: bipush 59
    //   840: invokevirtual 384	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   843: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: astore_1
    //   847: aload_0
    //   848: getfield 121	aiiu:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   851: aload 5
    //   853: aload_1
    //   854: invokevirtual 139	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   857: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   860: ifeq +54 -> 914
    //   863: ldc 93
    //   865: iconst_2
    //   866: new 95	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   873: ldc_w 657
    //   876: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload_1
    //   880: iconst_0
    //   881: anewarray 78	java/lang/String
    //   884: invokestatic 110	jqo:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   887: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: ldc_w 659
    //   893: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: aload 5
    //   898: iconst_0
    //   899: anewarray 78	java/lang/String
    //   902: invokestatic 106	jqo:filterKeyForLog	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   905: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   914: aload 13
    //   916: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   919: ifne +125 -> 1044
    //   922: aload 14
    //   924: aload 15
    //   926: invokeinterface 671 2 0
    //   931: astore_1
    //   932: aload_1
    //   933: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   936: ifne +108 -> 1044
    //   939: new 95	java/lang/StringBuilder
    //   942: dup
    //   943: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   946: ldc_w 673
    //   949: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: aload_1
    //   953: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: ldc_w 381
    //   959: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: aload 13
    //   964: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: ldc_w 675
    //   970: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: astore_1
    //   977: aload_0
    //   978: getfield 121	aiiu:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   981: aload 5
    //   983: aload_1
    //   984: invokevirtual 139	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   987: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   990: ifeq +54 -> 1044
    //   993: ldc 93
    //   995: iconst_2
    //   996: new 95	java/lang/StringBuilder
    //   999: dup
    //   1000: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1003: ldc_w 657
    //   1006: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: aload_1
    //   1010: iconst_0
    //   1011: anewarray 78	java/lang/String
    //   1014: invokestatic 110	jqo:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1017: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: ldc_w 659
    //   1023: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: aload 5
    //   1028: iconst_0
    //   1029: anewarray 78	java/lang/String
    //   1032: invokestatic 106	jqo:filterKeyForLog	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1035: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1041: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1044: aload 11
    //   1046: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1049: ifne +21 -> 1070
    //   1052: aload_0
    //   1053: aload 11
    //   1055: iconst_1
    //   1056: anewarray 78	java/lang/String
    //   1059: dup
    //   1060: iconst_0
    //   1061: aload 12
    //   1063: invokevirtual 352	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1066: aastore
    //   1067: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1070: iconst_1
    //   1071: ireturn
    //   1072: iconst_0
    //   1073: istore 6
    //   1075: goto -912 -> 163
    //   1078: astore 4
    //   1080: aconst_null
    //   1081: astore_2
    //   1082: aload_2
    //   1083: astore_3
    //   1084: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1087: ifeq +35 -> 1122
    //   1090: aload_2
    //   1091: astore_3
    //   1092: ldc 93
    //   1094: iconst_2
    //   1095: new 95	java/lang/StringBuilder
    //   1098: dup
    //   1099: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1102: ldc_w 677
    //   1105: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: aload 4
    //   1110: invokestatic 681	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1113: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1122: aload_1
    //   1123: astore_3
    //   1124: aload_2
    //   1125: ifnull -664 -> 461
    //   1128: aload_2
    //   1129: invokeinterface 650 1 0
    //   1134: aload_1
    //   1135: astore_3
    //   1136: goto -675 -> 461
    //   1139: astore_1
    //   1140: aload_1
    //   1141: invokevirtual 684	org/json/JSONException:printStackTrace	()V
    //   1144: goto -74 -> 1070
    //   1147: astore_1
    //   1148: aconst_null
    //   1149: astore_3
    //   1150: aload_3
    //   1151: ifnull +9 -> 1160
    //   1154: aload_3
    //   1155: invokeinterface 650 1 0
    //   1160: aload_1
    //   1161: athrow
    //   1162: ldc_w 686
    //   1165: aload 4
    //   1167: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1170: ifeq +35 -> 1205
    //   1173: new 688	com/tencent/mobileqq/jsp/DataApiPlugin$2
    //   1176: dup
    //   1177: aload_0
    //   1178: aload 5
    //   1180: iconst_0
    //   1181: aaload
    //   1182: aload_0
    //   1183: getfield 43	aiiu:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   1186: invokevirtual 551	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1189: invokevirtual 556	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   1192: invokespecial 691	com/tencent/mobileqq/jsp/DataApiPlugin$2:<init>	(Laiiu;Ljava/lang/String;Ljava/lang/String;)V
    //   1195: bipush 8
    //   1197: aconst_null
    //   1198: iconst_1
    //   1199: invokestatic 697	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1202: goto -132 -> 1070
    //   1205: ldc_w 699
    //   1208: aload 4
    //   1210: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1213: ifeq +259 -> 1472
    //   1216: aload_0
    //   1217: getfield 43	aiiu:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   1220: invokevirtual 703	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   1223: invokevirtual 709	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   1226: astore_1
    //   1227: aload_1
    //   1228: ldc_w 711
    //   1231: iconst_m1
    //   1232: invokevirtual 717	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1235: istore 6
    //   1237: new 182	org/json/JSONObject
    //   1240: dup
    //   1241: invokespecial 340	org/json/JSONObject:<init>	()V
    //   1244: astore_2
    //   1245: aload_0
    //   1246: getfield 43	aiiu:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   1249: invokevirtual 48	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   1252: invokevirtual 64	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1255: astore_3
    //   1256: new 182	org/json/JSONObject
    //   1259: dup
    //   1260: aload 5
    //   1262: iconst_0
    //   1263: aaload
    //   1264: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1267: ldc 246
    //   1269: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1272: astore 4
    //   1274: aload_2
    //   1275: ldc 131
    //   1277: aload_3
    //   1278: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1281: pop
    //   1282: iload 6
    //   1284: iconst_m1
    //   1285: if_icmpne +62 -> 1347
    //   1288: aload_2
    //   1289: ldc_w 719
    //   1292: ldc_w 721
    //   1295: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1298: pop
    //   1299: aload 4
    //   1301: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1304: ifne -234 -> 1070
    //   1307: aload_0
    //   1308: aload 4
    //   1310: iconst_1
    //   1311: anewarray 78	java/lang/String
    //   1314: dup
    //   1315: iconst_0
    //   1316: aload_2
    //   1317: invokevirtual 352	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1320: aastore
    //   1321: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1324: goto -254 -> 1070
    //   1327: astore_1
    //   1328: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1331: ifeq -261 -> 1070
    //   1334: ldc 93
    //   1336: iconst_2
    //   1337: ldc_w 723
    //   1340: aload_1
    //   1341: invokestatic 727	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1344: goto -274 -> 1070
    //   1347: iload 6
    //   1349: iconst_1
    //   1350: if_icmpne +47 -> 1397
    //   1353: aload_2
    //   1354: ldc_w 729
    //   1357: aload_1
    //   1358: ldc_w 731
    //   1361: invokevirtual 734	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1364: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1367: pop
    //   1368: aload_2
    //   1369: ldc_w 719
    //   1372: ldc_w 736
    //   1375: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1378: pop
    //   1379: aload_2
    //   1380: ldc_w 738
    //   1383: aload_1
    //   1384: ldc_w 740
    //   1387: invokevirtual 734	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1390: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1393: pop
    //   1394: goto -95 -> 1299
    //   1397: iload 6
    //   1399: sipush 3000
    //   1402: if_icmpne +32 -> 1434
    //   1405: aload_2
    //   1406: ldc_w 742
    //   1409: aload_1
    //   1410: ldc_w 742
    //   1413: invokevirtual 734	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1416: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1419: pop
    //   1420: aload_2
    //   1421: ldc_w 719
    //   1424: ldc_w 744
    //   1427: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1430: pop
    //   1431: goto -52 -> 1379
    //   1434: aload_1
    //   1435: ldc_w 746
    //   1438: invokevirtual 734	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1441: astore_3
    //   1442: aload_3
    //   1443: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1446: ifne +12 -> 1458
    //   1449: aload_2
    //   1450: ldc_w 746
    //   1453: aload_3
    //   1454: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1457: pop
    //   1458: aload_2
    //   1459: ldc_w 719
    //   1462: ldc_w 748
    //   1465: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1468: pop
    //   1469: goto -90 -> 1379
    //   1472: ldc_w 750
    //   1475: aload 4
    //   1477: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1480: ifeq +102 -> 1582
    //   1483: new 182	org/json/JSONObject
    //   1486: dup
    //   1487: aload 5
    //   1489: iconst_0
    //   1490: aaload
    //   1491: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1494: astore_2
    //   1495: aload_2
    //   1496: ldc 246
    //   1498: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1501: astore_1
    //   1502: aload_2
    //   1503: ldc 131
    //   1505: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1508: astore_2
    //   1509: aload_2
    //   1510: aload_0
    //   1511: getfield 43	aiiu:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   1514: invokevirtual 48	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   1517: invokevirtual 64	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1520: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1523: ifeq -453 -> 1070
    //   1526: aload_1
    //   1527: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1530: ifne -460 -> 1070
    //   1533: new 752	android/os/Bundle
    //   1536: dup
    //   1537: invokespecial 753	android/os/Bundle:<init>	()V
    //   1540: astore_3
    //   1541: aload_3
    //   1542: ldc 131
    //   1544: aload_2
    //   1545: invokevirtual 756	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1548: ldc_w 758
    //   1551: aload_1
    //   1552: aload_0
    //   1553: getfield 30	aiiu:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$b;
    //   1556: getfield 762	com/tencent/mobileqq/emosm/Client$b:key	I
    //   1559: aload_3
    //   1560: invokestatic 767	affz:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1563: astore_1
    //   1564: invokestatic 772	afjy:a	()Lafjy;
    //   1567: aload_1
    //   1568: invokevirtual 776	afjy:cq	(Landroid/os/Bundle;)V
    //   1571: goto -501 -> 1070
    //   1574: astore_1
    //   1575: aload_1
    //   1576: invokevirtual 684	org/json/JSONException:printStackTrace	()V
    //   1579: goto -509 -> 1070
    //   1582: ldc_w 778
    //   1585: aload 4
    //   1587: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1590: ifeq +137 -> 1727
    //   1593: aload 5
    //   1595: arraylength
    //   1596: iconst_1
    //   1597: if_icmpne +130 -> 1727
    //   1600: new 182	org/json/JSONObject
    //   1603: dup
    //   1604: aload 5
    //   1606: iconst_0
    //   1607: aaload
    //   1608: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1611: astore_1
    //   1612: aload_1
    //   1613: ldc 246
    //   1615: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1618: astore_2
    //   1619: aload_2
    //   1620: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1623: ifne -553 -> 1070
    //   1626: ldc_w 780
    //   1629: aload_1
    //   1630: ldc_w 445
    //   1633: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1636: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1639: ifeq +23 -> 1662
    //   1642: aload_0
    //   1643: aload_2
    //   1644: iconst_1
    //   1645: anewarray 78	java/lang/String
    //   1648: dup
    //   1649: iconst_0
    //   1650: getstatic 785	com/tencent/mobileqq/activity/QQBrowserActivity:bJl	I
    //   1653: invokestatic 787	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1656: aastore
    //   1657: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1660: iconst_1
    //   1661: ireturn
    //   1662: aconst_null
    //   1663: astore_1
    //   1664: aload_0
    //   1665: getfield 43	aiiu:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   1668: invokevirtual 703	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   1671: astore_3
    //   1672: aload_3
    //   1673: ifnull +14 -> 1687
    //   1676: aload_3
    //   1677: invokevirtual 709	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   1680: ldc_w 789
    //   1683: invokevirtual 734	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1686: astore_1
    //   1687: aload_1
    //   1688: ifnonnull +31 -> 1719
    //   1691: ldc_w 791
    //   1694: astore_1
    //   1695: aload_0
    //   1696: aload_2
    //   1697: iconst_1
    //   1698: anewarray 78	java/lang/String
    //   1701: dup
    //   1702: iconst_0
    //   1703: aload_1
    //   1704: aastore
    //   1705: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1708: goto -638 -> 1070
    //   1711: astore_1
    //   1712: aload_1
    //   1713: invokevirtual 684	org/json/JSONException:printStackTrace	()V
    //   1716: goto -646 -> 1070
    //   1719: aload_1
    //   1720: invokestatic 794	jqo:toJsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1723: astore_1
    //   1724: goto -29 -> 1695
    //   1727: ldc_w 796
    //   1730: aload 4
    //   1732: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1735: ifeq +126 -> 1861
    //   1738: aload 5
    //   1740: arraylength
    //   1741: iconst_1
    //   1742: if_icmpne +119 -> 1861
    //   1745: new 182	org/json/JSONObject
    //   1748: dup
    //   1749: aload 5
    //   1751: iconst_0
    //   1752: aaload
    //   1753: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1756: astore_1
    //   1757: aload_1
    //   1758: ldc_w 798
    //   1761: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1764: astore_2
    //   1765: aload_1
    //   1766: ldc 246
    //   1768: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1771: astore_1
    //   1772: aload_2
    //   1773: ifnonnull +3237 -> 5010
    //   1776: ldc_w 791
    //   1779: astore_2
    //   1780: invokestatic 596	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1783: ldc_w 800
    //   1786: invokevirtual 804	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1789: checkcast 806	android/text/ClipboardManager
    //   1792: astore_3
    //   1793: aload_3
    //   1794: ifnull +32 -> 1826
    //   1797: aload_3
    //   1798: aload_2
    //   1799: invokevirtual 810	android/text/ClipboardManager:setText	(Ljava/lang/CharSequence;)V
    //   1802: aload_1
    //   1803: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1806: ifne +18 -> 1824
    //   1809: aload_0
    //   1810: aload_1
    //   1811: iconst_1
    //   1812: anewarray 78	java/lang/String
    //   1815: dup
    //   1816: iconst_0
    //   1817: ldc_w 812
    //   1820: aastore
    //   1821: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1824: iconst_1
    //   1825: ireturn
    //   1826: aload_1
    //   1827: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1830: ifne -760 -> 1070
    //   1833: aload_0
    //   1834: aload_1
    //   1835: iconst_1
    //   1836: anewarray 78	java/lang/String
    //   1839: dup
    //   1840: iconst_0
    //   1841: ldc_w 814
    //   1844: aastore
    //   1845: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1848: goto -778 -> 1070
    //   1851: astore_2
    //   1852: aconst_null
    //   1853: astore_1
    //   1854: aload_2
    //   1855: invokevirtual 684	org/json/JSONException:printStackTrace	()V
    //   1858: goto -32 -> 1826
    //   1861: ldc_w 816
    //   1864: aload 4
    //   1866: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1869: ifeq +123 -> 1992
    //   1872: aload 5
    //   1874: arraylength
    //   1875: iconst_1
    //   1876: if_icmpne +116 -> 1992
    //   1879: new 182	org/json/JSONObject
    //   1882: dup
    //   1883: aload 5
    //   1885: iconst_0
    //   1886: aaload
    //   1887: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1890: ldc 246
    //   1892: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1895: astore_2
    //   1896: aload_2
    //   1897: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1900: ifne -830 -> 1070
    //   1903: invokestatic 596	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1906: ldc_w 800
    //   1909: invokevirtual 804	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1912: checkcast 806	android/text/ClipboardManager
    //   1915: astore_1
    //   1916: aload_1
    //   1917: ifnull +3086 -> 5003
    //   1920: aload_1
    //   1921: invokevirtual 820	android/text/ClipboardManager:getText	()Ljava/lang/CharSequence;
    //   1924: astore_1
    //   1925: aload_1
    //   1926: ifnull +3077 -> 5003
    //   1929: aload_1
    //   1930: invokeinterface 823 1 0
    //   1935: astore_1
    //   1936: aload_0
    //   1937: aload_2
    //   1938: iconst_1
    //   1939: anewarray 78	java/lang/String
    //   1942: dup
    //   1943: iconst_0
    //   1944: aload_1
    //   1945: invokestatic 794	jqo:toJsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1948: aastore
    //   1949: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1952: goto -882 -> 1070
    //   1955: astore_1
    //   1956: ldc 93
    //   1958: iconst_1
    //   1959: new 95	java/lang/StringBuilder
    //   1962: dup
    //   1963: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1966: ldc_w 825
    //   1969: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1972: aload_1
    //   1973: invokevirtual 357	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1976: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1979: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1982: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1985: aload_1
    //   1986: invokevirtual 826	java/lang/Exception:printStackTrace	()V
    //   1989: goto -919 -> 1070
    //   1992: ldc_w 828
    //   1995: aload 4
    //   1997: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2000: ifeq +203 -> 2203
    //   2003: aload 5
    //   2005: arraylength
    //   2006: iconst_1
    //   2007: if_icmpne +196 -> 2203
    //   2010: new 182	org/json/JSONObject
    //   2013: dup
    //   2014: aload 5
    //   2016: iconst_0
    //   2017: aaload
    //   2018: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2021: astore_1
    //   2022: aload_1
    //   2023: ldc_w 830
    //   2026: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2029: astore_2
    //   2030: aload_1
    //   2031: ldc_w 832
    //   2034: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2037: astore_3
    //   2038: aload_1
    //   2039: ldc_w 834
    //   2042: iconst_1
    //   2043: invokevirtual 838	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2046: istore 9
    //   2048: aload_1
    //   2049: ldc 246
    //   2051: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2054: astore 4
    //   2056: new 182	org/json/JSONObject
    //   2059: dup
    //   2060: invokespecial 340	org/json/JSONObject:<init>	()V
    //   2063: astore 5
    //   2065: aload_2
    //   2066: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2069: ifne +109 -> 2178
    //   2072: aload_3
    //   2073: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2076: ifne +102 -> 2178
    //   2079: aload_0
    //   2080: getfield 43	aiiu:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   2083: invokevirtual 48	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   2086: astore_1
    //   2087: aload_1
    //   2088: instanceof 840
    //   2091: ifeq +2907 -> 4998
    //   2094: aload_1
    //   2095: checkcast 840	com/tencent/mobileqq/app/QQAppInterface
    //   2098: astore_1
    //   2099: aload_1
    //   2100: aload_2
    //   2101: aload_3
    //   2102: iload 9
    //   2104: invokestatic 845	annx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2107: aload 5
    //   2109: ldc_w 342
    //   2112: iconst_0
    //   2113: invokevirtual 346	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2116: pop
    //   2117: aload 5
    //   2119: ldc_w 348
    //   2122: ldc_w 847
    //   2125: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2128: pop
    //   2129: aload 4
    //   2131: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2134: ifne -1064 -> 1070
    //   2137: aload_0
    //   2138: aload 4
    //   2140: iconst_1
    //   2141: anewarray 78	java/lang/String
    //   2144: dup
    //   2145: iconst_0
    //   2146: aload 5
    //   2148: invokevirtual 352	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2151: aastore
    //   2152: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2155: goto -1085 -> 1070
    //   2158: astore_1
    //   2159: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2162: ifeq -1092 -> 1070
    //   2165: ldc 93
    //   2167: iconst_2
    //   2168: aload_1
    //   2169: invokevirtual 357	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2172: invokestatic 849	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2175: goto -1105 -> 1070
    //   2178: aload 5
    //   2180: ldc_w 342
    //   2183: iconst_m1
    //   2184: invokevirtual 346	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2187: pop
    //   2188: aload 5
    //   2190: ldc_w 348
    //   2193: ldc_w 851
    //   2196: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2199: pop
    //   2200: goto -71 -> 2129
    //   2203: ldc_w 853
    //   2206: aload 4
    //   2208: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2211: ifeq +473 -> 2684
    //   2214: aload 5
    //   2216: arraylength
    //   2217: iconst_1
    //   2218: if_icmpne +466 -> 2684
    //   2221: new 182	org/json/JSONObject
    //   2224: dup
    //   2225: aload 5
    //   2227: iconst_0
    //   2228: aaload
    //   2229: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2232: astore_1
    //   2233: aload_1
    //   2234: ldc_w 855
    //   2237: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2240: astore_3
    //   2241: aload_1
    //   2242: ldc_w 857
    //   2245: invokevirtual 188	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2248: astore_1
    //   2249: aload_0
    //   2250: getfield 43	aiiu:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   2253: invokevirtual 48	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   2256: astore_2
    //   2257: ldc_w 859
    //   2260: aload_3
    //   2261: invokevirtual 862	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2264: ifeq +232 -> 2496
    //   2267: aload_1
    //   2268: ldc_w 864
    //   2271: ldc_w 791
    //   2274: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2277: astore_3
    //   2278: aload_1
    //   2279: ldc_w 868
    //   2282: invokevirtual 870	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2285: astore 4
    //   2287: aload_1
    //   2288: ldc_w 872
    //   2291: invokevirtual 870	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2294: astore 5
    //   2296: aload_1
    //   2297: ldc_w 874
    //   2300: invokevirtual 870	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2303: astore 11
    //   2305: aload_1
    //   2306: ldc_w 876
    //   2309: ldc_w 791
    //   2312: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2315: astore 12
    //   2317: aload_1
    //   2318: ldc_w 878
    //   2321: iconst_0
    //   2322: invokevirtual 881	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2325: istore 6
    //   2327: aload_1
    //   2328: ldc_w 883
    //   2331: iconst_1
    //   2332: invokevirtual 881	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2335: istore 7
    //   2337: aload_1
    //   2338: ldc_w 885
    //   2341: iconst_0
    //   2342: invokevirtual 881	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2345: istore 8
    //   2347: aload_1
    //   2348: ldc_w 887
    //   2351: ldc_w 791
    //   2354: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2357: astore 13
    //   2359: aload_1
    //   2360: ldc_w 889
    //   2363: ldc_w 791
    //   2366: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2369: astore 14
    //   2371: aload_1
    //   2372: ldc_w 891
    //   2375: ldc_w 791
    //   2378: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2381: astore 15
    //   2383: aload_1
    //   2384: ldc_w 893
    //   2387: ldc_w 791
    //   2390: invokevirtual 866	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2393: astore 16
    //   2395: aconst_null
    //   2396: astore_1
    //   2397: aload_2
    //   2398: instanceof 840
    //   2401: ifeq +8 -> 2409
    //   2404: aload_2
    //   2405: checkcast 840	com/tencent/mobileqq/app/QQAppInterface
    //   2408: astore_1
    //   2409: aload_2
    //   2410: invokevirtual 60	com/tencent/common/app/AppInterface:isLogin	()Z
    //   2413: ifeq +53 -> 2466
    //   2416: aload_1
    //   2417: aload 4
    //   2419: aload_3
    //   2420: aload 12
    //   2422: aload 5
    //   2424: aload 11
    //   2426: iload 6
    //   2428: iload 7
    //   2430: iload 8
    //   2432: aload 13
    //   2434: aload 14
    //   2436: aload 15
    //   2438: aload 16
    //   2440: invokestatic 898	anot:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2443: goto -1373 -> 1070
    //   2446: astore_1
    //   2447: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2450: ifeq -1380 -> 1070
    //   2453: ldc 93
    //   2455: iconst_2
    //   2456: aload_1
    //   2457: invokevirtual 899	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2460: invokestatic 849	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2463: goto -1393 -> 1070
    //   2466: aload_1
    //   2467: aload 4
    //   2469: aload_3
    //   2470: aload 12
    //   2472: aload 5
    //   2474: aload 11
    //   2476: iload 6
    //   2478: iload 7
    //   2480: iload 8
    //   2482: aload 13
    //   2484: aload 14
    //   2486: aload 15
    //   2488: aload 16
    //   2490: invokestatic 901	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2493: goto -1423 -> 1070
    //   2496: ldc_w 903
    //   2499: aload_3
    //   2500: invokevirtual 862	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2503: ifeq +163 -> 2666
    //   2506: aload_1
    //   2507: ldc_w 905
    //   2510: invokevirtual 870	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2513: astore_3
    //   2514: aload_1
    //   2515: ldc_w 907
    //   2518: iconst_1
    //   2519: invokevirtual 838	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2522: istore 9
    //   2524: aload_1
    //   2525: ldc_w 909
    //   2528: iconst_1
    //   2529: invokevirtual 838	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2532: istore 10
    //   2534: aload_1
    //   2535: ldc_w 911
    //   2538: iconst_0
    //   2539: invokevirtual 881	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2542: istore 6
    //   2544: aload_1
    //   2545: ldc_w 913
    //   2548: iconst_0
    //   2549: invokevirtual 881	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2552: istore 7
    //   2554: new 915	java/util/HashMap
    //   2557: dup
    //   2558: invokespecial 916	java/util/HashMap:<init>	()V
    //   2561: astore 4
    //   2563: aload_1
    //   2564: ldc_w 918
    //   2567: invokevirtual 921	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2570: astore_1
    //   2571: aload_1
    //   2572: ifnull +53 -> 2625
    //   2575: aload_1
    //   2576: invokevirtual 925	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   2579: astore 5
    //   2581: aload 5
    //   2583: ifnull +42 -> 2625
    //   2586: aload 5
    //   2588: invokeinterface 930 1 0
    //   2593: ifeq +32 -> 2625
    //   2596: aload 5
    //   2598: invokeinterface 934 1 0
    //   2603: checkcast 78	java/lang/String
    //   2606: astore 11
    //   2608: aload 4
    //   2610: aload 11
    //   2612: aload_1
    //   2613: aload 11
    //   2615: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2618: invokevirtual 937	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2621: pop
    //   2622: goto -41 -> 2581
    //   2625: aconst_null
    //   2626: astore_1
    //   2627: aload_2
    //   2628: invokevirtual 60	com/tencent/common/app/AppInterface:isLogin	()Z
    //   2631: ifeq +8 -> 2639
    //   2634: aload_2
    //   2635: invokevirtual 64	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   2638: astore_1
    //   2639: aconst_null
    //   2640: invokestatic 942	anpc:a	(Landroid/content/Context;)Lanpc;
    //   2643: aload_1
    //   2644: aload_3
    //   2645: iload 10
    //   2647: iload 6
    //   2649: i2l
    //   2650: iload 7
    //   2652: i2l
    //   2653: aload 4
    //   2655: ldc_w 791
    //   2658: iload 9
    //   2660: invokevirtual 946	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2663: goto -1593 -> 1070
    //   2666: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2669: ifeq -1599 -> 1070
    //   2672: ldc 93
    //   2674: iconst_2
    //   2675: ldc_w 948
    //   2678: invokestatic 849	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2681: goto -1611 -> 1070
    //   2684: ldc_w 950
    //   2687: aload 4
    //   2689: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2692: ifeq +175 -> 2867
    //   2695: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2698: ifeq +12 -> 2710
    //   2701: ldc 93
    //   2703: iconst_2
    //   2704: ldc_w 950
    //   2707: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2710: new 182	org/json/JSONObject
    //   2713: dup
    //   2714: aload 5
    //   2716: iconst_0
    //   2717: aaload
    //   2718: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2721: astore_2
    //   2722: aload_2
    //   2723: ldc 246
    //   2725: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2728: astore_1
    //   2729: aload_2
    //   2730: ldc 131
    //   2732: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2735: astore_2
    //   2736: aload_1
    //   2737: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2740: ifne +109 -> 2849
    //   2743: new 752	android/os/Bundle
    //   2746: dup
    //   2747: invokespecial 753	android/os/Bundle:<init>	()V
    //   2750: astore_3
    //   2751: aload_2
    //   2752: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2755: ifne +75 -> 2830
    //   2758: aload_3
    //   2759: ldc 131
    //   2761: aload_2
    //   2762: invokevirtual 756	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2765: ldc_w 952
    //   2768: aload_1
    //   2769: aload_0
    //   2770: getfield 30	aiiu:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$b;
    //   2773: getfield 762	com/tencent/mobileqq/emosm/Client$b:key	I
    //   2776: aload_3
    //   2777: invokestatic 767	affz:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   2780: astore_1
    //   2781: invokestatic 772	afjy:a	()Lafjy;
    //   2784: aload_1
    //   2785: invokevirtual 776	afjy:cq	(Landroid/os/Bundle;)V
    //   2788: goto -1718 -> 1070
    //   2791: astore_1
    //   2792: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2795: ifeq -1725 -> 1070
    //   2798: ldc 93
    //   2800: iconst_2
    //   2801: new 95	java/lang/StringBuilder
    //   2804: dup
    //   2805: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2808: ldc_w 954
    //   2811: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2814: aload_1
    //   2815: invokevirtual 899	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2818: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2821: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2824: invokestatic 849	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2827: goto -1757 -> 1070
    //   2830: aload_3
    //   2831: ldc 131
    //   2833: aload_0
    //   2834: getfield 43	aiiu:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   2837: invokevirtual 48	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   2840: invokevirtual 64	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   2843: invokevirtual 756	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2846: goto -81 -> 2765
    //   2849: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2852: ifeq -1782 -> 1070
    //   2855: ldc 93
    //   2857: iconst_2
    //   2858: ldc_w 956
    //   2861: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2864: goto -1794 -> 1070
    //   2867: ldc_w 958
    //   2870: aload 4
    //   2872: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2875: ifeq +116 -> 2991
    //   2878: aload 5
    //   2880: arraylength
    //   2881: iconst_1
    //   2882: if_icmpne +109 -> 2991
    //   2885: new 182	org/json/JSONObject
    //   2888: dup
    //   2889: aload 5
    //   2891: iconst_0
    //   2892: aaload
    //   2893: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2896: ldc 246
    //   2898: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2901: astore_1
    //   2902: aload_1
    //   2903: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2906: ifne -1836 -> 1070
    //   2909: aload_0
    //   2910: aload_1
    //   2911: iconst_1
    //   2912: anewarray 78	java/lang/String
    //   2915: dup
    //   2916: iconst_0
    //   2917: new 95	java/lang/StringBuilder
    //   2920: dup
    //   2921: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2924: ldc_w 960
    //   2927: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2930: invokestatic 965	com/tencent/common/config/AppSetting:getAppId	()I
    //   2933: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2936: ldc_w 967
    //   2939: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2942: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2945: aastore
    //   2946: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2949: goto -1879 -> 1070
    //   2952: astore_1
    //   2953: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2956: ifeq -1886 -> 1070
    //   2959: ldc 93
    //   2961: iconst_2
    //   2962: new 95	java/lang/StringBuilder
    //   2965: dup
    //   2966: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2969: ldc_w 969
    //   2972: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2975: aload_1
    //   2976: invokevirtual 899	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2979: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2982: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2985: invokestatic 849	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2988: goto -1918 -> 1070
    //   2991: ldc_w 971
    //   2994: aload 4
    //   2996: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2999: ifeq +520 -> 3519
    //   3002: aload 5
    //   3004: arraylength
    //   3005: iconst_1
    //   3006: if_icmpne +513 -> 3519
    //   3009: new 182	org/json/JSONObject
    //   3012: dup
    //   3013: aload 5
    //   3015: iconst_0
    //   3016: aaload
    //   3017: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3020: astore_1
    //   3021: aload_1
    //   3022: ldc 246
    //   3024: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3027: astore_3
    //   3028: aload_1
    //   3029: ldc_w 973
    //   3032: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3035: astore_1
    //   3036: aload_1
    //   3037: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3040: ifne +1952 -> 4992
    //   3043: aload_1
    //   3044: invokevirtual 976	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   3047: astore 4
    //   3049: aload_0
    //   3050: getfield 43	aiiu:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   3053: invokevirtual 48	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   3056: astore_2
    //   3057: aload_2
    //   3058: ifnull +1934 -> 4992
    //   3061: aload_2
    //   3062: invokevirtual 60	com/tencent/common/app/AppInterface:isLogin	()Z
    //   3065: ifeq +1927 -> 4992
    //   3068: aload_2
    //   3069: invokevirtual 64	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   3072: astore_1
    //   3073: aload_2
    //   3074: iconst_2
    //   3075: invokevirtual 578	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3078: checkcast 580	mqq/manager/TicketManager
    //   3081: astore_2
    //   3082: aload_2
    //   3083: aload_1
    //   3084: aload 4
    //   3086: invokeinterface 663 3 0
    //   3091: astore 13
    //   3093: aload_2
    //   3094: aload_1
    //   3095: aload 4
    //   3097: invokeinterface 979 3 0
    //   3102: astore 5
    //   3104: aload 13
    //   3106: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3109: ifne +1883 -> 4992
    //   3112: new 95	java/lang/StringBuilder
    //   3115: dup
    //   3116: bipush 111
    //   3118: invokespecial 981	java/lang/StringBuilder:<init>	(I)V
    //   3121: astore_2
    //   3122: aload_1
    //   3123: invokevirtual 984	java/lang/String:length	()I
    //   3126: bipush 10
    //   3128: if_icmpge +32 -> 3160
    //   3131: aload_1
    //   3132: invokevirtual 984	java/lang/String:length	()I
    //   3135: istore 6
    //   3137: iload 6
    //   3139: bipush 10
    //   3141: if_icmpge +19 -> 3160
    //   3144: aload_2
    //   3145: bipush 48
    //   3147: invokevirtual 384	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3150: pop
    //   3151: iload 6
    //   3153: iconst_1
    //   3154: iadd
    //   3155: istore 6
    //   3157: goto -20 -> 3137
    //   3160: aload_2
    //   3161: aload_1
    //   3162: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3165: pop
    //   3166: invokestatic 70	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   3169: astore 11
    //   3171: aload 11
    //   3173: iconst_1
    //   3174: invokevirtual 125	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   3177: new 95	java/lang/StringBuilder
    //   3180: dup
    //   3181: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3184: ldc_w 986
    //   3187: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3190: aload 4
    //   3192: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3195: bipush 47
    //   3197: invokevirtual 384	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3200: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3203: astore 12
    //   3205: new 95	java/lang/StringBuilder
    //   3208: dup
    //   3209: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3212: ldc 152
    //   3214: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3217: aload_2
    //   3218: invokevirtual 989	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   3221: ldc_w 381
    //   3224: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3227: aload 4
    //   3229: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3232: bipush 59
    //   3234: invokevirtual 384	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3237: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3240: astore 14
    //   3242: aload 11
    //   3244: aload 12
    //   3246: aload 14
    //   3248: invokevirtual 139	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3251: ldc_w 791
    //   3254: astore_1
    //   3255: ldc_w 791
    //   3258: astore_2
    //   3259: aload 13
    //   3261: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3264: ifne +49 -> 3313
    //   3267: new 95	java/lang/StringBuilder
    //   3270: dup
    //   3271: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3274: ldc_w 379
    //   3277: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3280: aload 13
    //   3282: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3285: ldc_w 381
    //   3288: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3291: aload 4
    //   3293: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3296: bipush 59
    //   3298: invokevirtual 384	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3301: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3304: astore_1
    //   3305: aload 11
    //   3307: aload 12
    //   3309: aload_1
    //   3310: invokevirtual 139	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3313: aload 5
    //   3315: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3318: ifne +49 -> 3367
    //   3321: new 95	java/lang/StringBuilder
    //   3324: dup
    //   3325: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3328: ldc_w 395
    //   3331: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3334: aload 5
    //   3336: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3339: ldc_w 381
    //   3342: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3345: aload 4
    //   3347: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3350: bipush 59
    //   3352: invokevirtual 384	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3355: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3358: astore_2
    //   3359: aload 11
    //   3361: aload 12
    //   3363: aload_2
    //   3364: invokevirtual 139	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3367: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3370: ifeq +1660 -> 5030
    //   3373: ldc 93
    //   3375: iconst_2
    //   3376: new 95	java/lang/StringBuilder
    //   3379: dup
    //   3380: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3383: ldc_w 657
    //   3386: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3389: aload 14
    //   3391: iconst_0
    //   3392: anewarray 78	java/lang/String
    //   3395: invokestatic 110	jqo:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3398: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3401: aload_1
    //   3402: iconst_0
    //   3403: anewarray 78	java/lang/String
    //   3406: invokestatic 110	jqo:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3409: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3412: aload_2
    //   3413: iconst_0
    //   3414: anewarray 78	java/lang/String
    //   3417: invokestatic 110	jqo:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3420: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3423: ldc_w 659
    //   3426: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3429: aload 12
    //   3431: iconst_0
    //   3432: anewarray 78	java/lang/String
    //   3435: invokestatic 106	jqo:filterKeyForLog	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3438: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3441: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3444: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3447: goto +1583 -> 5030
    //   3450: aload_3
    //   3451: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3454: ifne -2384 -> 1070
    //   3457: aload_0
    //   3458: aload_3
    //   3459: iconst_1
    //   3460: anewarray 78	java/lang/String
    //   3463: dup
    //   3464: iconst_0
    //   3465: new 95	java/lang/StringBuilder
    //   3468: dup
    //   3469: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3472: ldc_w 991
    //   3475: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3478: iload 6
    //   3480: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3483: ldc_w 967
    //   3486: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3489: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3492: aastore
    //   3493: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3496: goto -2426 -> 1070
    //   3499: astore_1
    //   3500: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3503: ifeq -2433 -> 1070
    //   3506: ldc 93
    //   3508: iconst_2
    //   3509: ldc_w 993
    //   3512: aload_1
    //   3513: invokestatic 727	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3516: goto -2446 -> 1070
    //   3519: ldc_w 995
    //   3522: aload 4
    //   3524: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3527: ifeq +13 -> 3540
    //   3530: aload_0
    //   3531: aload_2
    //   3532: aload 5
    //   3534: invokespecial 997	aiiu:j	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3537: goto -2467 -> 1070
    //   3540: ldc_w 999
    //   3543: aload 4
    //   3545: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3548: ifeq +137 -> 3685
    //   3551: aconst_null
    //   3552: astore_2
    //   3553: aload_2
    //   3554: astore_1
    //   3555: new 182	org/json/JSONObject
    //   3558: dup
    //   3559: aload 5
    //   3561: iconst_0
    //   3562: aaload
    //   3563: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3566: astore_3
    //   3567: aload_2
    //   3568: astore_1
    //   3569: aload_3
    //   3570: ldc 246
    //   3572: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3575: astore_2
    //   3576: aload_2
    //   3577: astore_1
    //   3578: aload_3
    //   3579: ldc 131
    //   3581: invokevirtual 870	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3584: astore_3
    //   3585: aload_2
    //   3586: astore_1
    //   3587: invokestatic 772	afjy:a	()Lafjy;
    //   3590: invokevirtual 1002	afjy:ajq	()Z
    //   3593: ifeq -2523 -> 1070
    //   3596: aload_2
    //   3597: astore_1
    //   3598: new 752	android/os/Bundle
    //   3601: dup
    //   3602: invokespecial 753	android/os/Bundle:<init>	()V
    //   3605: astore 4
    //   3607: aload_2
    //   3608: astore_1
    //   3609: aload 4
    //   3611: ldc 131
    //   3613: aload_3
    //   3614: invokevirtual 756	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3617: aload_2
    //   3618: astore_1
    //   3619: ldc_w 1004
    //   3622: aload_2
    //   3623: aload_0
    //   3624: getfield 30	aiiu:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$b;
    //   3627: getfield 762	com/tencent/mobileqq/emosm/Client$b:key	I
    //   3630: aload 4
    //   3632: invokestatic 767	affz:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   3635: astore_3
    //   3636: aload_2
    //   3637: astore_1
    //   3638: invokestatic 772	afjy:a	()Lafjy;
    //   3641: aload_3
    //   3642: invokevirtual 776	afjy:cq	(Landroid/os/Bundle;)V
    //   3645: goto -2575 -> 1070
    //   3648: astore_2
    //   3649: aload_1
    //   3650: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3653: ifne -2583 -> 1070
    //   3656: aload_0
    //   3657: aload_1
    //   3658: iconst_1
    //   3659: anewarray 78	java/lang/String
    //   3662: dup
    //   3663: iconst_0
    //   3664: ldc_w 1006
    //   3667: iconst_1
    //   3668: anewarray 129	java/lang/Object
    //   3671: dup
    //   3672: iconst_0
    //   3673: aload_2
    //   3674: aastore
    //   3675: invokestatic 135	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3678: aastore
    //   3679: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3682: goto -2612 -> 1070
    //   3685: ldc_w 1008
    //   3688: aload 4
    //   3690: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3693: ifeq +128 -> 3821
    //   3696: new 182	org/json/JSONObject
    //   3699: dup
    //   3700: aload 5
    //   3702: iconst_0
    //   3703: aaload
    //   3704: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3707: astore_1
    //   3708: ldc_w 1010
    //   3711: aload_1
    //   3712: ldc_w 1012
    //   3715: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3718: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3721: ifeq +24 -> 3745
    //   3724: aload_0
    //   3725: getfield 43	aiiu:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   3728: invokevirtual 703	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   3731: astore_2
    //   3732: aload_2
    //   3733: ifnull +12 -> 3745
    //   3736: aload_2
    //   3737: iconst_m1
    //   3738: invokevirtual 1015	android/app/Activity:setResult	(I)V
    //   3741: aload_2
    //   3742: invokevirtual 1018	android/app/Activity:finish	()V
    //   3745: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3748: ifeq -2678 -> 1070
    //   3751: ldc 93
    //   3753: iconst_2
    //   3754: new 95	java/lang/StringBuilder
    //   3757: dup
    //   3758: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3761: ldc_w 1020
    //   3764: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3767: aload_1
    //   3768: invokevirtual 1023	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3771: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3774: invokestatic 849	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3777: goto -2707 -> 1070
    //   3780: astore_1
    //   3781: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3784: ifeq +13 -> 3797
    //   3787: ldc 93
    //   3789: iconst_2
    //   3790: ldc_w 1025
    //   3793: aload_1
    //   3794: invokestatic 727	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3797: aload_0
    //   3798: getfield 43	aiiu:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   3801: invokevirtual 703	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   3804: astore_1
    //   3805: aload_1
    //   3806: ifnull -2736 -> 1070
    //   3809: aload_1
    //   3810: iconst_0
    //   3811: invokevirtual 1015	android/app/Activity:setResult	(I)V
    //   3814: aload_1
    //   3815: invokevirtual 1018	android/app/Activity:finish	()V
    //   3818: goto -2748 -> 1070
    //   3821: ldc_w 1027
    //   3824: aload 4
    //   3826: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3829: ifeq +380 -> 4209
    //   3832: aload 5
    //   3834: arraylength
    //   3835: iconst_1
    //   3836: if_icmpne +373 -> 4209
    //   3839: new 182	org/json/JSONObject
    //   3842: dup
    //   3843: aload 5
    //   3845: iconst_0
    //   3846: aaload
    //   3847: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3850: astore_3
    //   3851: aload_3
    //   3852: ldc 246
    //   3854: invokevirtual 870	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3857: astore_2
    //   3858: aload_3
    //   3859: ldc_w 1029
    //   3862: invokevirtual 870	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3865: astore 4
    //   3867: aload_3
    //   3868: ldc_w 973
    //   3871: invokevirtual 870	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3874: astore_1
    //   3875: aload_0
    //   3876: getfield 438	aiiu:mAuthConfig	Ljml;
    //   3879: ifnonnull +10 -> 3889
    //   3882: aload_0
    //   3883: invokestatic 443	jml:a	()Ljml;
    //   3886: putfield 438	aiiu:mAuthConfig	Ljml;
    //   3889: iconst_0
    //   3890: istore 10
    //   3892: iload 10
    //   3894: istore 9
    //   3896: aload 4
    //   3898: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3901: ifne +71 -> 3972
    //   3904: iload 10
    //   3906: istore 9
    //   3908: aload_1
    //   3909: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3912: ifne +60 -> 3972
    //   3915: new 95	java/lang/StringBuilder
    //   3918: dup
    //   3919: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3922: ldc_w 986
    //   3925: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3928: aload_1
    //   3929: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3932: ldc_w 1031
    //   3935: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3938: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3941: astore_1
    //   3942: ldc_w 1033
    //   3945: aload 4
    //   3947: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3950: ifeq +67 -> 4017
    //   3953: aload_3
    //   3954: ldc_w 1035
    //   3957: invokevirtual 870	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3960: astore_3
    //   3961: aload_0
    //   3962: getfield 438	aiiu:mAuthConfig	Ljml;
    //   3965: aload_1
    //   3966: aload_3
    //   3967: invokevirtual 1039	jml:z	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3970: istore 9
    //   3972: iload 9
    //   3974: ifeq +228 -> 4202
    //   3977: ldc_w 1041
    //   3980: astore_1
    //   3981: aload_0
    //   3982: aload_2
    //   3983: iconst_1
    //   3984: anewarray 78	java/lang/String
    //   3987: dup
    //   3988: iconst_0
    //   3989: aload_1
    //   3990: aastore
    //   3991: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3994: goto -2924 -> 1070
    //   3997: astore_1
    //   3998: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4001: ifeq -2931 -> 1070
    //   4004: ldc 93
    //   4006: iconst_2
    //   4007: ldc_w 1043
    //   4010: aload_1
    //   4011: invokestatic 727	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4014: goto -2944 -> 1070
    //   4017: ldc_w 452
    //   4020: aload 4
    //   4022: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4025: ifeq +16 -> 4041
    //   4028: aload_0
    //   4029: getfield 438	aiiu:mAuthConfig	Ljml;
    //   4032: aload_1
    //   4033: invokevirtual 473	jml:cQ	(Ljava/lang/String;)Z
    //   4036: istore 9
    //   4038: goto -66 -> 3972
    //   4041: ldc_w 1045
    //   4044: aload 4
    //   4046: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4049: ifeq +23 -> 4072
    //   4052: aload_0
    //   4053: getfield 438	aiiu:mAuthConfig	Ljml;
    //   4056: aload_1
    //   4057: invokevirtual 571	jml:dE	(Ljava/lang/String;)Ljava/lang/String;
    //   4060: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4063: ifne +973 -> 5036
    //   4066: iconst_1
    //   4067: istore 9
    //   4069: goto -97 -> 3972
    //   4072: ldc_w 477
    //   4075: aload 4
    //   4077: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4080: ifeq +23 -> 4103
    //   4083: aload_0
    //   4084: getfield 438	aiiu:mAuthConfig	Ljml;
    //   4087: aload_1
    //   4088: invokevirtual 480	jml:dH	(Ljava/lang/String;)Ljava/lang/String;
    //   4091: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4094: ifne +948 -> 5042
    //   4097: iconst_1
    //   4098: istore 9
    //   4100: goto -128 -> 3972
    //   4103: ldc_w 1047
    //   4106: aload 4
    //   4108: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4111: ifeq +25 -> 4136
    //   4114: aload_3
    //   4115: ldc_w 1047
    //   4118: invokevirtual 870	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4121: astore_3
    //   4122: aload_0
    //   4123: getfield 438	aiiu:mAuthConfig	Ljml;
    //   4126: aload_1
    //   4127: aload_3
    //   4128: invokevirtual 1050	jml:B	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4131: istore 9
    //   4133: goto -161 -> 3972
    //   4136: ldc_w 494
    //   4139: aload 4
    //   4141: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4144: ifeq +23 -> 4167
    //   4147: aload_0
    //   4148: getfield 438	aiiu:mAuthConfig	Ljml;
    //   4151: aload_1
    //   4152: invokevirtual 497	jml:dI	(Ljava/lang/String;)Ljava/lang/String;
    //   4155: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4158: ifne +890 -> 5048
    //   4161: iconst_1
    //   4162: istore 9
    //   4164: goto -192 -> 3972
    //   4167: iload 10
    //   4169: istore 9
    //   4171: ldc_w 1052
    //   4174: aload 4
    //   4176: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4179: ifeq -207 -> 3972
    //   4182: aload_0
    //   4183: getfield 438	aiiu:mAuthConfig	Ljml;
    //   4186: aload_1
    //   4187: invokevirtual 574	jml:dJ	(Ljava/lang/String;)Ljava/lang/String;
    //   4190: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4193: ifne +861 -> 5054
    //   4196: iconst_1
    //   4197: istore 9
    //   4199: goto -227 -> 3972
    //   4202: ldc_w 1054
    //   4205: astore_1
    //   4206: goto -225 -> 3981
    //   4209: ldc_w 1056
    //   4212: aload 4
    //   4214: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4217: ifeq +110 -> 4327
    //   4220: new 182	org/json/JSONObject
    //   4223: dup
    //   4224: aload 5
    //   4226: iconst_0
    //   4227: aaload
    //   4228: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4231: astore_1
    //   4232: aload_1
    //   4233: ldc_w 342
    //   4236: iconst_0
    //   4237: invokevirtual 838	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   4240: istore 9
    //   4242: aload_0
    //   4243: getfield 1058	aiiu:mClient	Lskj;
    //   4246: ifnonnull +17 -> 4263
    //   4249: aload_0
    //   4250: invokestatic 1063	skj:a	()Lskj;
    //   4253: putfield 1058	aiiu:mClient	Lskj;
    //   4256: aload_0
    //   4257: getfield 1058	aiiu:mClient	Lskj;
    //   4260: invokevirtual 1066	skj:bzj	()V
    //   4263: aload_0
    //   4264: getfield 1058	aiiu:mClient	Lskj;
    //   4267: iload 9
    //   4269: invokevirtual 1069	skj:uP	(Z)V
    //   4272: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4275: ifeq -3205 -> 1070
    //   4278: ldc 93
    //   4280: iconst_2
    //   4281: new 95	java/lang/StringBuilder
    //   4284: dup
    //   4285: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4288: ldc_w 1071
    //   4291: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4294: aload_1
    //   4295: invokevirtual 1023	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4298: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4301: invokestatic 849	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4304: goto -3234 -> 1070
    //   4307: astore_1
    //   4308: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4311: ifeq -3241 -> 1070
    //   4314: ldc 93
    //   4316: iconst_2
    //   4317: ldc_w 1025
    //   4320: aload_1
    //   4321: invokestatic 727	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4324: goto -3254 -> 1070
    //   4327: ldc_w 1073
    //   4330: aload 4
    //   4332: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4335: ifeq +146 -> 4481
    //   4338: new 182	org/json/JSONObject
    //   4341: dup
    //   4342: aload 5
    //   4344: iconst_0
    //   4345: aaload
    //   4346: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4349: astore_1
    //   4350: aload_1
    //   4351: ldc_w 1075
    //   4354: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4357: astore_2
    //   4358: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4361: ifeq +29 -> 4390
    //   4364: ldc 93
    //   4366: iconst_2
    //   4367: new 95	java/lang/StringBuilder
    //   4370: dup
    //   4371: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4374: ldc_w 1077
    //   4377: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4380: aload_2
    //   4381: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4384: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4387: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4390: aload_0
    //   4391: getfield 205	aiiu:jdField_a_of_type_Ardm$o	Lardm$o;
    //   4394: invokeinterface 1078 1 0
    //   4399: astore_2
    //   4400: aload_2
    //   4401: ifnull -3331 -> 1070
    //   4404: aload_2
    //   4405: invokevirtual 1082	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   4408: astore_2
    //   4409: aload_2
    //   4410: iconst_1
    //   4411: anewarray 78	java/lang/String
    //   4414: dup
    //   4415: iconst_0
    //   4416: ldc_w 1084
    //   4419: aastore
    //   4420: invokevirtual 1090	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:aa	([Ljava/lang/String;)V
    //   4423: aload_2
    //   4424: ldc_w 1084
    //   4427: invokevirtual 1093	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   4430: astore_2
    //   4431: aload_2
    //   4432: ifnull -3362 -> 1070
    //   4435: aload_2
    //   4436: instanceof 1095
    //   4439: ifeq -3369 -> 1070
    //   4442: aload_2
    //   4443: checkcast 1095	svs
    //   4446: aload_1
    //   4447: ldc_w 1097
    //   4450: invokevirtual 194	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4453: aload_1
    //   4454: ldc_w 1099
    //   4457: invokevirtual 194	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4460: aload_1
    //   4461: ldc_w 1101
    //   4464: invokevirtual 194	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4467: invokevirtual 1105	svs:setData	(III)V
    //   4470: goto -3400 -> 1070
    //   4473: astore_1
    //   4474: aload_1
    //   4475: invokevirtual 684	org/json/JSONException:printStackTrace	()V
    //   4478: goto -3408 -> 1070
    //   4481: ldc_w 1107
    //   4484: aload 4
    //   4486: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4489: ifeq +130 -> 4619
    //   4492: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4495: ifeq +30 -> 4525
    //   4498: ldc 93
    //   4500: iconst_2
    //   4501: new 95	java/lang/StringBuilder
    //   4504: dup
    //   4505: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4508: ldc_w 1109
    //   4511: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4514: aload 5
    //   4516: invokevirtual 1023	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4519: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4522: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4525: aload 5
    //   4527: ifnull -3457 -> 1070
    //   4530: aload 5
    //   4532: arraylength
    //   4533: ifle -3463 -> 1070
    //   4536: new 182	org/json/JSONObject
    //   4539: dup
    //   4540: aload 5
    //   4542: iconst_0
    //   4543: aaload
    //   4544: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4547: astore_1
    //   4548: aload_1
    //   4549: ldc_w 1111
    //   4552: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4555: astore_2
    //   4556: aload_1
    //   4557: ldc 246
    //   4559: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4562: astore_1
    //   4563: aload_1
    //   4564: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4567: ifne -3497 -> 1070
    //   4570: aload_2
    //   4571: invokestatic 1116	ajri:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   4574: astore_2
    //   4575: new 182	org/json/JSONObject
    //   4578: dup
    //   4579: invokespecial 340	org/json/JSONObject:<init>	()V
    //   4582: astore_3
    //   4583: aload_3
    //   4584: ldc_w 1118
    //   4587: aload_2
    //   4588: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4591: pop
    //   4592: aload_0
    //   4593: aload_1
    //   4594: iconst_1
    //   4595: anewarray 78	java/lang/String
    //   4598: dup
    //   4599: iconst_0
    //   4600: aload_3
    //   4601: invokevirtual 352	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4604: aastore
    //   4605: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4608: goto -3538 -> 1070
    //   4611: astore_1
    //   4612: aload_1
    //   4613: invokevirtual 684	org/json/JSONException:printStackTrace	()V
    //   4616: goto -3546 -> 1070
    //   4619: ldc_w 1120
    //   4622: aload 4
    //   4624: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4627: ifeq +130 -> 4757
    //   4630: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4633: ifeq +30 -> 4663
    //   4636: ldc 93
    //   4638: iconst_2
    //   4639: new 95	java/lang/StringBuilder
    //   4642: dup
    //   4643: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4646: ldc_w 1122
    //   4649: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4652: aload 5
    //   4654: invokevirtual 1023	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4657: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4660: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4663: aload 5
    //   4665: ifnull -3595 -> 1070
    //   4668: aload 5
    //   4670: arraylength
    //   4671: ifle -3601 -> 1070
    //   4674: new 182	org/json/JSONObject
    //   4677: dup
    //   4678: aload 5
    //   4680: iconst_0
    //   4681: aaload
    //   4682: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4685: astore_1
    //   4686: aload_1
    //   4687: ldc_w 1124
    //   4690: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4693: astore_2
    //   4694: aload_1
    //   4695: ldc 246
    //   4697: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4700: astore_1
    //   4701: aload_1
    //   4702: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4705: ifne -3635 -> 1070
    //   4708: aload_2
    //   4709: invokestatic 1125	ajri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   4712: astore_2
    //   4713: new 182	org/json/JSONObject
    //   4716: dup
    //   4717: invokespecial 340	org/json/JSONObject:<init>	()V
    //   4720: astore_3
    //   4721: aload_3
    //   4722: ldc_w 1127
    //   4725: aload_2
    //   4726: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4729: pop
    //   4730: aload_0
    //   4731: aload_1
    //   4732: iconst_1
    //   4733: anewarray 78	java/lang/String
    //   4736: dup
    //   4737: iconst_0
    //   4738: aload_3
    //   4739: invokevirtual 352	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4742: aastore
    //   4743: invokevirtual 254	aiiu:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4746: goto -3676 -> 1070
    //   4749: astore_1
    //   4750: aload_1
    //   4751: invokevirtual 684	org/json/JSONException:printStackTrace	()V
    //   4754: goto -3684 -> 1070
    //   4757: ldc_w 1129
    //   4760: aload 4
    //   4762: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4765: ifeq +109 -> 4874
    //   4768: new 182	org/json/JSONObject
    //   4771: dup
    //   4772: aload 5
    //   4774: iconst_0
    //   4775: aaload
    //   4776: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4779: ldc_w 1131
    //   4782: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4785: astore_1
    //   4786: aload_0
    //   4787: getfield 1058	aiiu:mClient	Lskj;
    //   4790: ifnonnull +17 -> 4807
    //   4793: aload_0
    //   4794: invokestatic 1063	skj:a	()Lskj;
    //   4797: putfield 1058	aiiu:mClient	Lskj;
    //   4800: aload_0
    //   4801: getfield 1058	aiiu:mClient	Lskj;
    //   4804: invokevirtual 1066	skj:bzj	()V
    //   4807: aload_0
    //   4808: getfield 1058	aiiu:mClient	Lskj;
    //   4811: iconst_1
    //   4812: aload_1
    //   4813: invokevirtual 1135	skj:G	(ZLjava/lang/String;)V
    //   4816: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4819: ifeq -3749 -> 1070
    //   4822: ldc 93
    //   4824: iconst_2
    //   4825: new 95	java/lang/StringBuilder
    //   4828: dup
    //   4829: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4832: ldc_w 1137
    //   4835: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4838: aload 5
    //   4840: iconst_0
    //   4841: aaload
    //   4842: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4845: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4848: invokestatic 849	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4851: goto -3781 -> 1070
    //   4854: astore_1
    //   4855: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4858: ifeq -3788 -> 1070
    //   4861: ldc 93
    //   4863: iconst_2
    //   4864: ldc_w 1139
    //   4867: aload_1
    //   4868: invokestatic 727	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4871: goto -3801 -> 1070
    //   4874: ldc_w 1141
    //   4877: aload 4
    //   4879: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4882: ifeq -3812 -> 1070
    //   4885: aload_0
    //   4886: getfield 43	aiiu:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   4889: invokevirtual 703	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   4892: astore_1
    //   4893: aload_1
    //   4894: ifnull -3824 -> 1070
    //   4897: aload_1
    //   4898: invokevirtual 709	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   4901: astore_1
    //   4902: new 182	org/json/JSONObject
    //   4905: dup
    //   4906: aload 5
    //   4908: iconst_0
    //   4909: aaload
    //   4910: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4913: ldc_w 1143
    //   4916: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4919: astore_2
    //   4920: aload_2
    //   4921: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4924: ifne -3854 -> 1070
    //   4927: aload_1
    //   4928: ifnull -3858 -> 1070
    //   4931: aload_1
    //   4932: ldc_w 1145
    //   4935: aload_2
    //   4936: invokevirtual 1149	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4939: pop
    //   4940: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4943: ifeq -3873 -> 1070
    //   4946: ldc 93
    //   4948: iconst_2
    //   4949: ldc_w 1151
    //   4952: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4955: goto -3885 -> 1070
    //   4958: astore_1
    //   4959: ldc 93
    //   4961: iconst_2
    //   4962: ldc_w 1153
    //   4965: aload_1
    //   4966: invokestatic 1155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4969: goto -3899 -> 1070
    //   4972: iconst_0
    //   4973: ireturn
    //   4974: astore_2
    //   4975: goto -3121 -> 1854
    //   4978: astore_1
    //   4979: goto -3829 -> 1150
    //   4982: astore 4
    //   4984: goto -3902 -> 1082
    //   4987: astore 4
    //   4989: goto -3907 -> 1082
    //   4992: iconst_1
    //   4993: istore 6
    //   4995: goto -1545 -> 3450
    //   4998: aconst_null
    //   4999: astore_1
    //   5000: goto -2901 -> 2099
    //   5003: ldc_w 791
    //   5006: astore_1
    //   5007: goto -3071 -> 1936
    //   5010: goto -3230 -> 1780
    //   5013: goto -4610 -> 403
    //   5016: aload_1
    //   5017: astore 4
    //   5019: goto -4574 -> 445
    //   5022: aload_1
    //   5023: astore_3
    //   5024: goto -4563 -> 461
    //   5027: goto -4947 -> 80
    //   5030: iconst_0
    //   5031: istore 6
    //   5033: goto -1583 -> 3450
    //   5036: iconst_0
    //   5037: istore 9
    //   5039: goto -1067 -> 3972
    //   5042: iconst_0
    //   5043: istore 9
    //   5045: goto -1073 -> 3972
    //   5048: iconst_0
    //   5049: istore 9
    //   5051: goto -1079 -> 3972
    //   5054: iconst_0
    //   5055: istore 9
    //   5057: goto -1085 -> 3972
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5060	0	this	aiiu
    //   0	5060	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	5060	2	paramString1	String
    //   0	5060	3	paramString2	String
    //   0	5060	4	paramString3	String
    //   0	5060	5	paramVarArgs	String[]
    //   161	4871	6	i	int
    //   2335	316	7	j	int
    //   2345	136	8	k	int
    //   172	4884	9	bool1	boolean
    //   2532	1636	10	bool2	boolean
    //   43	3317	11	localObject1	Object
    //   225	3205	12	localObject2	Object
    //   183	3098	13	str1	String
    //   216	3174	14	localObject3	Object
    //   232	2255	15	str2	String
    //   194	2295	16	str3	String
    //   87	699	17	localAppInterface	AppInterface
    //   205	492	18	str4	String
    // Exception table:
    //   from	to	target	type
    //   291	334	1078	java/lang/Exception
    //   27	57	1139	org/json/JSONException
    //   62	80	1139	org/json/JSONException
    //   80	105	1139	org/json/JSONException
    //   105	129	1139	org/json/JSONException
    //   131	145	1139	org/json/JSONException
    //   145	160	1139	org/json/JSONException
    //   163	291	1139	org/json/JSONException
    //   452	458	1139	org/json/JSONException
    //   461	471	1139	org/json/JSONException
    //   481	515	1139	org/json/JSONException
    //   515	628	1139	org/json/JSONException
    //   628	777	1139	org/json/JSONException
    //   777	914	1139	org/json/JSONException
    //   914	1044	1139	org/json/JSONException
    //   1044	1070	1139	org/json/JSONException
    //   1128	1134	1139	org/json/JSONException
    //   1154	1160	1139	org/json/JSONException
    //   1160	1162	1139	org/json/JSONException
    //   291	334	1147	finally
    //   1256	1282	1327	org/json/JSONException
    //   1288	1299	1327	org/json/JSONException
    //   1299	1324	1327	org/json/JSONException
    //   1353	1379	1327	org/json/JSONException
    //   1379	1394	1327	org/json/JSONException
    //   1405	1431	1327	org/json/JSONException
    //   1434	1458	1327	org/json/JSONException
    //   1458	1469	1327	org/json/JSONException
    //   1483	1571	1574	org/json/JSONException
    //   1600	1660	1711	org/json/JSONException
    //   1664	1672	1711	org/json/JSONException
    //   1676	1687	1711	org/json/JSONException
    //   1695	1708	1711	org/json/JSONException
    //   1719	1724	1711	org/json/JSONException
    //   1745	1772	1851	org/json/JSONException
    //   1879	1916	1955	java/lang/Exception
    //   1920	1925	1955	java/lang/Exception
    //   1929	1936	1955	java/lang/Exception
    //   1936	1952	1955	java/lang/Exception
    //   2010	2099	2158	java/lang/Exception
    //   2099	2129	2158	java/lang/Exception
    //   2129	2155	2158	java/lang/Exception
    //   2178	2200	2158	java/lang/Exception
    //   2221	2395	2446	org/json/JSONException
    //   2397	2409	2446	org/json/JSONException
    //   2409	2443	2446	org/json/JSONException
    //   2466	2493	2446	org/json/JSONException
    //   2496	2571	2446	org/json/JSONException
    //   2575	2581	2446	org/json/JSONException
    //   2586	2622	2446	org/json/JSONException
    //   2627	2639	2446	org/json/JSONException
    //   2639	2663	2446	org/json/JSONException
    //   2666	2681	2446	org/json/JSONException
    //   2710	2765	2791	org/json/JSONException
    //   2765	2788	2791	org/json/JSONException
    //   2830	2846	2791	org/json/JSONException
    //   2849	2864	2791	org/json/JSONException
    //   2885	2949	2952	org/json/JSONException
    //   3009	3057	3499	org/json/JSONException
    //   3061	3137	3499	org/json/JSONException
    //   3144	3151	3499	org/json/JSONException
    //   3160	3251	3499	org/json/JSONException
    //   3259	3313	3499	org/json/JSONException
    //   3313	3367	3499	org/json/JSONException
    //   3367	3447	3499	org/json/JSONException
    //   3450	3496	3499	org/json/JSONException
    //   3555	3567	3648	org/json/JSONException
    //   3569	3576	3648	org/json/JSONException
    //   3578	3585	3648	org/json/JSONException
    //   3587	3596	3648	org/json/JSONException
    //   3598	3607	3648	org/json/JSONException
    //   3609	3617	3648	org/json/JSONException
    //   3619	3636	3648	org/json/JSONException
    //   3638	3645	3648	org/json/JSONException
    //   3696	3732	3780	java/lang/Exception
    //   3736	3745	3780	java/lang/Exception
    //   3745	3777	3780	java/lang/Exception
    //   3839	3889	3997	org/json/JSONException
    //   3896	3904	3997	org/json/JSONException
    //   3908	3972	3997	org/json/JSONException
    //   3981	3994	3997	org/json/JSONException
    //   4017	4038	3997	org/json/JSONException
    //   4041	4066	3997	org/json/JSONException
    //   4072	4097	3997	org/json/JSONException
    //   4103	4133	3997	org/json/JSONException
    //   4136	4161	3997	org/json/JSONException
    //   4171	4196	3997	org/json/JSONException
    //   4220	4263	4307	java/lang/Exception
    //   4263	4304	4307	java/lang/Exception
    //   4338	4390	4473	org/json/JSONException
    //   4390	4400	4473	org/json/JSONException
    //   4404	4431	4473	org/json/JSONException
    //   4435	4470	4473	org/json/JSONException
    //   4536	4608	4611	org/json/JSONException
    //   4674	4746	4749	org/json/JSONException
    //   4768	4807	4854	java/lang/Exception
    //   4807	4851	4854	java/lang/Exception
    //   4885	4893	4958	java/lang/Exception
    //   4897	4927	4958	java/lang/Exception
    //   4931	4955	4958	java/lang/Exception
    //   1780	1793	4974	org/json/JSONException
    //   1797	1824	4974	org/json/JSONException
    //   340	349	4978	finally
    //   351	368	4978	finally
    //   370	378	4978	finally
    //   380	400	4978	finally
    //   408	414	4978	finally
    //   416	442	4978	finally
    //   1084	1090	4978	finally
    //   1092	1122	4978	finally
    //   340	349	4982	java/lang/Exception
    //   351	368	4982	java/lang/Exception
    //   370	378	4982	java/lang/Exception
    //   380	400	4982	java/lang/Exception
    //   408	414	4987	java/lang/Exception
    //   416	442	4987	java/lang/Exception
  }
  
  public void onCreate()
  {
    super.onCreate();
    afjy.a().a(this.mOnRemoteResp);
    aqzv localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
    if ((localaqzv != null) && ((localaqzv instanceof ardm.m))) {
      this.jdField_a_of_type_Ardm$m = ((ardm.m)localaqzv);
    }
    localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
    if ((localaqzv != null) && ((localaqzv instanceof ardm.o))) {
      this.jdField_a_of_type_Ardm$o = ((ardm.o)localaqzv);
    }
    localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
    if ((localaqzv != null) && ((localaqzv instanceof ardm.q))) {
      this.jdField_a_of_type_Ardm$q = ((ardm.q)localaqzv);
    }
    localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
    if ((localaqzv != null) && ((localaqzv instanceof ardm.c))) {
      this.b = ((ardm.c)localaqzv);
    }
  }
  
  public void onDestroy()
  {
    afjy.a().b(this.mOnRemoteResp);
    if (this.mClient != null) {
      this.mClient.bzk();
    }
    super.onDestroy();
  }
  
  class a
    extends WtloginListener
  {
    private String bNU;
    private String bNV;
    private String callback;
    private String url;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.url = paramString1;
      this.callback = paramString2;
      this.bNU = paramString3;
      this.bNV = paramString4;
    }
    
    public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
    {
      if (paramInt2 == 0)
      {
        aiiu.this.a(this.url, paramWUserSigInfo, this.callback, paramInt1, this.bNU, this.bNV);
        return;
      }
      aiiu.this.gv(this.callback, "getTicket fail code = " + paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiiu
 * JD-Core Version:    0.7.0.1
 */