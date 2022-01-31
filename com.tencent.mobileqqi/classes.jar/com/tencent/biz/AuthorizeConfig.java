package com.tencent.biz;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import bgi;
import com.tencent.biz.common.util.Util;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizeConfig
{
  protected static final int a = 86400000;
  protected static volatile long a = 0L;
  protected static AuthorizeConfig a;
  static final String a = "AuthorizeConfig";
  protected static final JSONArray a;
  public static volatile int b = 0;
  protected static final String b = "http://pub.idqqimg.com/qqmobile/config/webview_whitelist2.json";
  protected static final String c = "domainCmdRight";
  protected static final String d = "cmdConfig";
  protected static final String e = "sid";
  protected static final String f = "lastUpdate";
  protected static final String g = "extra";
  protected static final String h = "jump";
  protected static final String i = "offlineHtml";
  protected static final String j = "skey";
  protected static final String k = "vkey";
  protected static final String l = "pskey";
  protected static final String m = "schemes";
  protected static final String n = "*.qq.com";
  protected static final String o = "{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*.imqq.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\"]}";
  protected static final String p = "[\"*.qq.com\",\"*.tenpay.com\"]";
  protected static final String q = "[\"qq.com\"]";
  protected static final String r = "[\"game.qq.com\",\"id.qq.com\"]";
  protected static final String s = "{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\"]}";
  protected static final String t = "mp.imqq.com";
  public Context a;
  public JSONObject a;
  public String[] a;
  public JSONArray b;
  public JSONObject b;
  public String[] b;
  public JSONArray c;
  public JSONObject c;
  public JSONArray d;
  public JSONObject d;
  public JSONArray e;
  public JSONObject e;
  
  static
  {
    try
    {
      JSONArray localJSONArray1 = new JSONArray("[{\"dev-m.mail.qq.com\":\"sid\"},{\"*mail.qq.com\":\"3g_sid\"},{\"*.qq.com\":\"sid\"},{\"*.qzone.com\":\"sid\"},{\"qq.com\":\"sid\"},{\"qzone.com\":\"sid\"}]");
      jdField_a_of_type_OrgJsonJSONArray = localJSONArray1;
      jdField_b_of_type_Int = -1;
      jdField_a_of_type_Long = -1L;
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONArray localJSONArray2 = new JSONArray();
      }
    }
  }
  
  private AuthorizeConfig(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorizeConfig", 2, "AuthorizeConfig init");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static AuthorizeConfig a()
  {
    if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
      jdField_a_of_type_ComTencentBizAuthorizeConfig = new AuthorizeConfig(BaseApplication.getContext());
    }
    jdField_a_of_type_ComTencentBizAuthorizeConfig.a();
    jdField_a_of_type_ComTencentBizAuthorizeConfig.b();
    return jdField_a_of_type_ComTencentBizAuthorizeConfig;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    paramString1 = paramString1.replaceAll("\\.", "\\\\.").replaceAll("\\*", ".+");
    return paramString2.matches("^" + paramString1 + "$");
  }
  
  public int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_b_of_type_OrgJsonJSONObject == null)) {}
    do
    {
      do
      {
        return 0;
        paramString = paramString.split("\\?");
      } while (!this.jdField_b_of_type_OrgJsonJSONObject.has(paramString[0]));
      try
      {
        int i1 = this.jdField_b_of_type_OrgJsonJSONObject.getJSONObject(paramString[0]).getInt("delay");
        return i1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getCheckUpDelayTime error");
    return 0;
  }
  
  public Boolean a(String paramString, Boolean paramBoolean)
  {
    Boolean localBoolean = paramBoolean;
    if (this.jdField_c_of_type_OrgJsonJSONObject != null) {}
    try
    {
      boolean bool = this.jdField_c_of_type_OrgJsonJSONObject.getBoolean(paramString);
      localBoolean = Boolean.valueOf(bool);
      return localBoolean;
    }
    catch (JSONException paramString) {}
    return paramBoolean;
  }
  
  /* Error */
  public Boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +8 -> 9
    //   4: iconst_0
    //   5: invokestatic 209	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   8: areturn
    //   9: aload_1
    //   10: invokestatic 216	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 219	android/net/Uri:getScheme	()Ljava/lang/String;
    //   18: astore 5
    //   20: ldc 221
    //   22: aload 5
    //   24: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +8 -> 35
    //   30: iconst_1
    //   31: invokestatic 209	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   34: areturn
    //   35: ldc 227
    //   37: aload 5
    //   39: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifne +18 -> 60
    //   45: ldc 229
    //   47: aload 5
    //   49: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifne +8 -> 60
    //   55: iconst_0
    //   56: invokestatic 209	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   59: areturn
    //   60: aload_1
    //   61: invokevirtual 232	android/net/Uri:getHost	()Ljava/lang/String;
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 234	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   69: ifnonnull +13 -> 82
    //   72: ldc 55
    //   74: aload_1
    //   75: invokestatic 236	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   78: invokestatic 209	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   81: areturn
    //   82: aload_0
    //   83: getfield 234	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   86: ldc 238
    //   88: invokevirtual 242	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   91: astore 5
    //   93: aload 5
    //   95: invokevirtual 246	org/json/JSONArray:length	()I
    //   98: istore 4
    //   100: iconst_0
    //   101: istore_3
    //   102: iload_3
    //   103: iload 4
    //   105: if_icmpge +29 -> 134
    //   108: aload 5
    //   110: iload_3
    //   111: invokevirtual 250	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   114: aload_1
    //   115: invokestatic 236	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   118: ifeq +8 -> 126
    //   121: iconst_1
    //   122: invokestatic 209	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   125: areturn
    //   126: iload_3
    //   127: iconst_1
    //   128: iadd
    //   129: istore_3
    //   130: goto -28 -> 102
    //   133: astore_1
    //   134: aload_0
    //   135: getfield 234	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   138: ldc 252
    //   140: invokevirtual 242	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   143: astore_1
    //   144: aload_1
    //   145: invokevirtual 246	org/json/JSONArray:length	()I
    //   148: istore 4
    //   150: iconst_0
    //   151: istore_3
    //   152: iload_3
    //   153: iload 4
    //   155: if_icmpge +28 -> 183
    //   158: aload_1
    //   159: iload_3
    //   160: invokevirtual 250	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   163: aload_2
    //   164: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   167: ifeq +8 -> 175
    //   170: iconst_1
    //   171: invokestatic 209	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   174: areturn
    //   175: iload_3
    //   176: iconst_1
    //   177: iadd
    //   178: istore_3
    //   179: goto -27 -> 152
    //   182: astore_1
    //   183: aload_0
    //   184: getfield 234	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   187: ldc 254
    //   189: invokevirtual 242	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual 246	org/json/JSONArray:length	()I
    //   197: istore 4
    //   199: iconst_0
    //   200: istore_3
    //   201: iload_3
    //   202: iload 4
    //   204: if_icmpge +28 -> 232
    //   207: aload_1
    //   208: iload_3
    //   209: invokevirtual 250	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   212: aload_2
    //   213: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   216: ifeq +8 -> 224
    //   219: iconst_1
    //   220: invokestatic 209	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   223: areturn
    //   224: iload_3
    //   225: iconst_1
    //   226: iadd
    //   227: istore_3
    //   228: goto -27 -> 201
    //   231: astore_1
    //   232: iconst_0
    //   233: invokestatic 209	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   236: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	AuthorizeConfig
    //   0	237	1	paramString1	String
    //   0	237	2	paramString2	String
    //   101	127	3	i1	int
    //   98	107	4	i2	int
    //   18	91	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   82	100	133	org/json/JSONException
    //   108	121	133	org/json/JSONException
    //   134	150	182	org/json/JSONException
    //   158	170	182	org/json/JSONException
    //   183	199	231	org/json/JSONException
    //   207	219	231	org/json/JSONException
  }
  
  public String a(String paramString)
  {
    int i2 = 0;
    paramString = Uri.parse(paramString).getHost();
    int i3;
    int i1;
    if (this.jdField_b_of_type_OrgJsonJSONArray != null)
    {
      i3 = this.jdField_b_of_type_OrgJsonJSONArray.length();
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < i3) {}
      try
      {
        Object localObject1 = this.jdField_b_of_type_OrgJsonJSONArray.getJSONObject(i1);
        str = ((JSONObject)localObject1).names().getString(0);
        if (b(str, paramString))
        {
          localObject1 = ((JSONObject)localObject1).getString(str);
          bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (bool) {
            return null;
          }
          return localObject1;
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          String str;
          boolean bool;
          i1 += 1;
          break;
          i3 = jdField_a_of_type_OrgJsonJSONArray.length();
          i1 = i2;
          if (i1 >= i3) {
            continue;
          }
          try
          {
            Object localObject2 = jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i1);
            str = ((JSONObject)localObject2).names().getString(0);
            if (b(str, paramString))
            {
              localObject2 = ((JSONObject)localObject2).getString(str);
              bool = TextUtils.isEmpty((CharSequence)localObject2);
              if (bool) {
                continue;
              }
              return localObject2;
            }
          }
          catch (JSONException localJSONException2)
          {
            i1 += 1;
          }
          catch (NullPointerException localNullPointerException1)
          {
            label170:
            break label170;
          }
        }
      }
      catch (NullPointerException localNullPointerException2)
      {
        label92:
        break label92;
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (this.jdField_c_of_type_OrgJsonJSONObject != null) {}
    try
    {
      str = this.jdField_c_of_type_OrgJsonJSONObject.getString(paramString1);
      return str;
    }
    catch (JSONException paramString1) {}
    return paramString2;
  }
  
  protected void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("domainCmdRight", 0);
    long l1 = ((SharedPreferences)localObject).getLong("lastUpdate", 0L);
    if (l1 == jdField_a_of_type_Long) {
      return;
    }
    String str7 = ((SharedPreferences)localObject).getString("cmdConfig", null);
    String str6 = ((SharedPreferences)localObject).getString("sid", null);
    String str8 = ((SharedPreferences)localObject).getString("offlineHtml", null);
    String str5 = ((SharedPreferences)localObject).getString("extra", null);
    String str4 = ((SharedPreferences)localObject).getString("jump", null);
    String str3 = ((SharedPreferences)localObject).getString("skey", null);
    String str2 = ((SharedPreferences)localObject).getString("vkey", null);
    String str1 = ((SharedPreferences)localObject).getString("pskey", null);
    localObject = ((SharedPreferences)localObject).getString("schemes", null);
    if (str8 != null) {}
    try
    {
      this.jdField_b_of_type_OrgJsonJSONObject = new JSONObject(str8);
      if (str7 == null) {}
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(str7);
        label164:
        if (this.jdField_a_of_type_OrgJsonJSONObject != null) {}
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*.imqq.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\"]}");
            label184:
            if (str6 != null) {}
            try
            {
              this.jdField_b_of_type_OrgJsonJSONArray = new JSONArray(str6);
              label202:
              if (str5 == null) {}
            }
            catch (JSONException localJSONException1)
            {
              try
              {
                this.jdField_c_of_type_OrgJsonJSONObject = new JSONObject(str5);
                label220:
                if (str4 == null) {}
              }
              catch (JSONException localJSONException1)
              {
                try
                {
                  this.jdField_d_of_type_OrgJsonJSONObject = new JSONObject(str4);
                  label238:
                  if (str3 == null) {}
                }
                catch (JSONException localJSONException1)
                {
                  try
                  {
                    this.jdField_c_of_type_OrgJsonJSONArray = new JSONArray(str3);
                    label256:
                    if (this.jdField_c_of_type_OrgJsonJSONArray != null) {}
                  }
                  catch (JSONException localJSONException1)
                  {
                    try
                    {
                      this.jdField_c_of_type_OrgJsonJSONArray = new JSONArray("[\"*.qq.com\",\"*.tenpay.com\"]");
                      label276:
                      if (str2 != null) {}
                      try
                      {
                        this.jdField_d_of_type_OrgJsonJSONArray = new JSONArray(str2);
                        label294:
                        if (this.jdField_d_of_type_OrgJsonJSONArray != null) {}
                      }
                      catch (JSONException localJSONException1)
                      {
                        try
                        {
                          this.jdField_d_of_type_OrgJsonJSONArray = new JSONArray("[\"qq.com\"]");
                          label314:
                          if (str1 != null) {}
                          try
                          {
                            this.jdField_e_of_type_OrgJsonJSONArray = new JSONArray(str1);
                            label332:
                            if (this.jdField_e_of_type_OrgJsonJSONArray != null) {}
                          }
                          catch (JSONException localJSONException1)
                          {
                            try
                            {
                              this.jdField_e_of_type_OrgJsonJSONArray = new JSONArray("[\"game.qq.com\",\"id.qq.com\"]");
                              label352:
                              if (localObject != null) {}
                              try
                              {
                                this.jdField_e_of_type_OrgJsonJSONObject = new JSONObject((String)localObject);
                                if (this.jdField_e_of_type_OrgJsonJSONObject != null) {}
                              }
                              catch (JSONException localJSONException1)
                              {
                                try
                                {
                                  label388:
                                  do
                                  {
                                    this.jdField_e_of_type_OrgJsonJSONObject = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\"]}");
                                    jdField_a_of_type_Long = l1;
                                    return;
                                    localJSONException14 = localJSONException14;
                                    if (!QLog.isColorLevel()) {
                                      break;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mOfflineConfig  error");
                                    break;
                                    localJSONException12 = localJSONException12;
                                    if (!QLog.isColorLevel()) {
                                      break label164;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mCmdConfig error");
                                    break label164;
                                    localJSONException11 = localJSONException11;
                                    if (!QLog.isColorLevel()) {
                                      break label202;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode cmdRights error");
                                    break label202;
                                    localJSONException10 = localJSONException10;
                                    if (!QLog.isColorLevel()) {
                                      break label220;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mExtraConfig error");
                                    break label220;
                                    localJSONException9 = localJSONException9;
                                    if (!QLog.isColorLevel()) {
                                      break label238;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mJumpConfig error");
                                    break label238;
                                    localJSONException7 = localJSONException7;
                                    if (!QLog.isColorLevel()) {
                                      break label256;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mSkeyConfig error");
                                    break label256;
                                    localJSONException5 = localJSONException5;
                                    if (!QLog.isColorLevel()) {
                                      break label294;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mVkeyConfig error");
                                    break label294;
                                    localJSONException3 = localJSONException3;
                                    if (!QLog.isColorLevel()) {
                                      break label332;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mPskeyConfig error");
                                    break label332;
                                    localJSONException1 = localJSONException1;
                                  } while (!QLog.isColorLevel());
                                  QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
                                }
                                catch (JSONException localJSONException2)
                                {
                                  break label388;
                                }
                              }
                            }
                            catch (JSONException localJSONException4)
                            {
                              break label352;
                            }
                          }
                        }
                        catch (JSONException localJSONException6)
                        {
                          break label314;
                        }
                      }
                    }
                    catch (JSONException localJSONException8)
                    {
                      break label276;
                    }
                  }
                }
              }
            }
          }
        }
        catch (JSONException localJSONException13)
        {
          break label184;
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    String str = Uri.parse(paramString).getScheme();
    if ((!"http".equals(str)) && (!"https".equals(str))) {}
    for (;;)
    {
      return false;
      paramString = Uri.parse(paramString).getHost();
      if (this.jdField_c_of_type_OrgJsonJSONArray == null) {
        return b("*.qq.com", paramString);
      }
      int i2 = this.jdField_c_of_type_OrgJsonJSONArray.length();
      int i1 = 0;
      while (i1 < i2)
      {
        if (b(this.jdField_c_of_type_OrgJsonJSONArray.optString(i1), paramString)) {
          return true;
        }
        i1 += 1;
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    Object localObject1;
    do
    {
      do
      {
        return false;
        paramString1 = Uri.parse(paramString1);
        localObject1 = paramString1.getScheme();
        if ("file".equals(localObject1)) {
          return true;
        }
      } while ((!"http".equals(localObject1)) && (!"https".equals(localObject1)));
      paramString1 = paramString1.getHost();
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        return b("*.qq.com", paramString1);
      }
      if (paramString1.equals("mp.imqq.com")) {
        return true;
      }
      localObject1 = this.jdField_a_of_type_OrgJsonJSONObject.names();
    } while (localObject1 == null);
    int i3 = ((JSONArray)localObject1).length();
    int i1 = 0;
    label102:
    Object localObject2;
    if (i1 < i3)
    {
      localObject2 = ((JSONArray)localObject1).optString(i1);
      if (b((String)localObject2, paramString1)) {
        break label132;
      }
    }
    for (;;)
    {
      i1 += 1;
      break label102;
      break;
      label132:
      localObject2 = this.jdField_a_of_type_OrgJsonJSONObject.optJSONArray((String)localObject2);
      if (localObject2 != null)
      {
        int i4 = ((JSONArray)localObject2).length();
        int i2 = 0;
        while (i2 < i4)
        {
          if (b(((JSONArray)localObject2).optString(i2), paramString2)) {
            return true;
          }
          i2 += 1;
        }
      }
    }
  }
  
  public String[] a()
  {
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    Object localObject = arrayOfString;
    if (arrayOfString == null)
    {
      localObject = new HashSet(16);
      if ((this.jdField_c_of_type_OrgJsonJSONArray != null) && (this.jdField_c_of_type_OrgJsonJSONArray.length() != 0)) {
        break label120;
      }
      ((Set)localObject).add("*.qq.com".replaceFirst("\\*\\.", ""));
      if ((this.jdField_d_of_type_OrgJsonJSONArray != null) && (this.jdField_d_of_type_OrgJsonJSONArray.length() != 0)) {
        break label169;
      }
      ((Set)localObject).add("*.qq.com".replaceFirst("\\*\\.", ""));
    }
    for (;;)
    {
      localObject = (String[])((Set)localObject).toArray(new String[((Set)localObject).size()]);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
      return localObject;
      label120:
      int i2 = this.jdField_c_of_type_OrgJsonJSONArray.length();
      int i1 = 0;
      while (i1 < i2)
      {
        ((Set)localObject).add(this.jdField_c_of_type_OrgJsonJSONArray.optString(i1, "").replaceFirst("\\*\\.", ""));
        i1 += 1;
      }
      break;
      label169:
      i2 = this.jdField_d_of_type_OrgJsonJSONArray.length();
      i1 = 0;
      while (i1 < i2)
      {
        ((Set)localObject).add(this.jdField_d_of_type_OrgJsonJSONArray.optString(i1, ""));
        i1 += 1;
      }
    }
  }
  
  public String b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_b_of_type_OrgJsonJSONObject == null)) {}
    do
    {
      do
      {
        return null;
        paramString = paramString.split("\\?");
      } while (!this.jdField_b_of_type_OrgJsonJSONObject.has(paramString[0]));
      try
      {
        paramString = this.jdField_b_of_type_OrgJsonJSONObject.getJSONObject(paramString[0]).getString("bid");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getOfflineId error");
    return null;
  }
  
  protected void b()
  {
    int i2 = 0;
    if (jdField_b_of_type_Int == 1) {
      return;
    }
    if (jdField_b_of_type_Int == -1) {
      jdField_b_of_type_Int = 0;
    }
    for (int i1 = 1;; i1 = 0)
    {
      long l1 = System.currentTimeMillis() - jdField_a_of_type_Long;
      if ((l1 < 0L) || (l1 >= 86400000L)) {
        i2 = 1;
      }
      if ((i1 == 0) && (i2 == 0)) {
        break;
      }
      jdField_b_of_type_Int = 1;
      new Thread(new bgi(this)).start();
      return;
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i2;
    int i1;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() > 0)
      {
        i2 = this.jdField_e_of_type_OrgJsonJSONArray.length();
        i1 = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 < i2)
      {
        if (paramString.equalsIgnoreCase(this.jdField_e_of_type_OrgJsonJSONArray.optString(i1))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public String[] b()
  {
    String[] arrayOfString = this.jdField_b_of_type_ArrayOfJavaLangString;
    Object localObject = arrayOfString;
    if (arrayOfString == null)
    {
      localObject = new HashSet(16);
      if ((this.jdField_e_of_type_OrgJsonJSONArray != null) && (this.jdField_e_of_type_OrgJsonJSONArray.length() != 0))
      {
        int i2 = this.jdField_e_of_type_OrgJsonJSONArray.length();
        int i1 = 0;
        while (i1 < i2)
        {
          ((Set)localObject).add(this.jdField_e_of_type_OrgJsonJSONArray.optString(i1, ""));
          i1 += 1;
        }
      }
      localObject = (String[])((Set)localObject).toArray(new String[((Set)localObject).size()]);
      this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])localObject);
    }
    return localObject;
  }
  
  public String c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_b_of_type_OrgJsonJSONObject == null)) {}
    do
    {
      do
      {
        return null;
        paramString = paramString.split("\\?");
      } while (!this.jdField_b_of_type_OrgJsonJSONObject.has(paramString[0]));
      try
      {
        paramString = this.jdField_b_of_type_OrgJsonJSONObject.getJSONObject(paramString[0]).getString("duck");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getCheckUpType error");
    return null;
  }
  
  public boolean c(String paramString)
  {
    if ((paramString == null) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {}
    for (;;)
    {
      return false;
      paramString = Util.c(paramString);
      if (paramString.length() > 0)
      {
        int i2 = this.jdField_d_of_type_OrgJsonJSONArray.length();
        int i1 = 0;
        while (i1 < i2)
        {
          if (paramString.equalsIgnoreCase(this.jdField_d_of_type_OrgJsonJSONArray.optString(i1))) {
            return true;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    Object localObject1 = paramString1;
    if (paramString1 == null) {
      localObject1 = "http://localhost/";
    }
    paramString1 = Uri.parse((String)localObject1);
    localObject1 = paramString1.getScheme();
    if ("file".equals(localObject1)) {
      return true;
    }
    if ((!"http".equals(localObject1)) && (!"https".equals(localObject1))) {
      return false;
    }
    paramString1 = paramString1.getHost();
    if (this.jdField_e_of_type_OrgJsonJSONObject == null) {
      return b("*.qq.com", paramString1);
    }
    localObject1 = this.jdField_e_of_type_OrgJsonJSONObject.names();
    if (localObject1 == null) {
      return false;
    }
    int i3 = ((JSONArray)localObject1).length();
    int i1 = 0;
    label102:
    if (i1 < i3)
    {
      Object localObject2 = ((JSONArray)localObject1).optString(i1);
      if (!b((String)localObject2, paramString1)) {}
      for (;;)
      {
        i1 += 1;
        break label102;
        localObject2 = this.jdField_e_of_type_OrgJsonJSONObject.optJSONArray((String)localObject2);
        if (localObject2 != null)
        {
          int i4 = ((JSONArray)localObject2).length();
          int i2 = 0;
          for (;;)
          {
            if (i2 >= i4) {
              break label186;
            }
            if (b(((JSONArray)localObject2).optString(i2), paramString2)) {
              break;
            }
            i2 += 1;
          }
        }
      }
    }
    label186:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig
 * JD-Core Version:    0.7.0.1
 */