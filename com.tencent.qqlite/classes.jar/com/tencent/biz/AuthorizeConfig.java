package com.tencent.biz;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import jl;
import mqq.app.MobileQQ;
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
  protected static final String n = "a1";
  protected static final String o = "*.qq.com";
  protected static final String p = "{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\"]}";
  protected static final String q = "[\"*.qq.com\",\"*.tenpay.com\"]";
  protected static final String r = "[\"qq.com\"]";
  protected static final String s = "[\"game.qq.com\",\"id.qq.com\",\"qzone.qq.com\",\"m.qzone.com\",\"qzone.com\"]";
  protected static final String t = "{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\"]}";
  static final String u = "lastMod";
  static final String v = "qqVersion";
  static final String w = "lastVersion";
  public Context a;
  public SharedPreferences a;
  protected JSONObject a;
  protected String[] a;
  protected JSONArray b;
  protected JSONObject b;
  protected String[] b;
  protected JSONArray c;
  protected JSONObject c;
  protected String[] c;
  protected JSONArray d;
  protected JSONObject d;
  protected JSONArray e;
  protected JSONObject e;
  protected JSONArray f;
  
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
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("domainCmdRight", 4);
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
  
  public int a(String paramString, int paramInt)
  {
    int i1 = paramInt;
    if (this.jdField_c_of_type_OrgJsonJSONObject != null) {
      i1 = this.jdField_c_of_type_OrgJsonJSONObject.optInt(paramString, paramInt);
    }
    return i1;
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
    //   5: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   8: areturn
    //   9: aload_1
    //   10: invokestatic 238	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 241	android/net/Uri:getScheme	()Ljava/lang/String;
    //   18: astore 5
    //   20: ldc 243
    //   22: aload 5
    //   24: invokevirtual 247	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +8 -> 35
    //   30: iconst_1
    //   31: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   34: areturn
    //   35: ldc 249
    //   37: aload 5
    //   39: invokevirtual 247	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifne +18 -> 60
    //   45: ldc 251
    //   47: aload 5
    //   49: invokevirtual 247	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifne +8 -> 60
    //   55: iconst_0
    //   56: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   59: areturn
    //   60: aload_1
    //   61: invokevirtual 254	android/net/Uri:getHost	()Ljava/lang/String;
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 256	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   69: ifnonnull +13 -> 82
    //   72: ldc 58
    //   74: aload_1
    //   75: invokestatic 258	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   78: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   81: areturn
    //   82: aload_0
    //   83: getfield 256	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   86: ldc_w 260
    //   89: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   92: astore 5
    //   94: aload 5
    //   96: invokevirtual 268	org/json/JSONArray:length	()I
    //   99: istore 4
    //   101: iconst_0
    //   102: istore_3
    //   103: iload_3
    //   104: iload 4
    //   106: if_icmpge +29 -> 135
    //   109: aload 5
    //   111: iload_3
    //   112: invokevirtual 272	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   115: aload_1
    //   116: invokestatic 258	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   119: ifeq +8 -> 127
    //   122: iconst_1
    //   123: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   126: areturn
    //   127: iload_3
    //   128: iconst_1
    //   129: iadd
    //   130: istore_3
    //   131: goto -28 -> 103
    //   134: astore_1
    //   135: aload_0
    //   136: getfield 256	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   139: ldc_w 274
    //   142: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 268	org/json/JSONArray:length	()I
    //   150: istore 4
    //   152: iconst_0
    //   153: istore_3
    //   154: iload_3
    //   155: iload 4
    //   157: if_icmpge +28 -> 185
    //   160: aload_1
    //   161: iload_3
    //   162: invokevirtual 272	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   165: aload_2
    //   166: invokevirtual 247	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifeq +8 -> 177
    //   172: iconst_1
    //   173: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   176: areturn
    //   177: iload_3
    //   178: iconst_1
    //   179: iadd
    //   180: istore_3
    //   181: goto -27 -> 154
    //   184: astore_1
    //   185: aload_0
    //   186: getfield 256	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   189: ldc_w 276
    //   192: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   195: astore_1
    //   196: aload_1
    //   197: invokevirtual 268	org/json/JSONArray:length	()I
    //   200: istore 4
    //   202: iconst_0
    //   203: istore_3
    //   204: iload_3
    //   205: iload 4
    //   207: if_icmpge +28 -> 235
    //   210: aload_1
    //   211: iload_3
    //   212: invokevirtual 272	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   215: aload_2
    //   216: invokevirtual 247	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   219: ifeq +8 -> 227
    //   222: iconst_1
    //   223: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   226: areturn
    //   227: iload_3
    //   228: iconst_1
    //   229: iadd
    //   230: istore_3
    //   231: goto -27 -> 204
    //   234: astore_1
    //   235: iconst_0
    //   236: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   239: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	AuthorizeConfig
    //   0	240	1	paramString1	String
    //   0	240	2	paramString2	String
    //   102	129	3	i1	int
    //   99	109	4	i2	int
    //   18	92	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   82	101	134	org/json/JSONException
    //   109	122	134	org/json/JSONException
    //   135	152	184	org/json/JSONException
    //   160	172	184	org/json/JSONException
    //   185	202	234	org/json/JSONException
    //   210	222	234	org/json/JSONException
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
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("lastUpdate", 0L);
    if (l1 == jdField_a_of_type_Long) {
      return;
    }
    String str9 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("cmdConfig", null);
    String str8 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("sid", null);
    String str10 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("offlineHtml", null);
    String str7 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("extra", null);
    String str6 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("jump", null);
    String str5 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("skey", null);
    String str4 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("vkey", null);
    String str3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("pskey", null);
    String str2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("schemes", null);
    String str1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("a1", null);
    if (str10 != null) {}
    try
    {
      this.jdField_b_of_type_OrgJsonJSONObject = new JSONObject(str10);
      if (str9 == null) {}
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(str9);
        if (this.jdField_a_of_type_OrgJsonJSONObject != null) {}
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\"]}");
            label217:
            if (str8 != null) {}
            try
            {
              this.jdField_b_of_type_OrgJsonJSONArray = new JSONArray(str8);
              label235:
              if (str7 == null) {}
            }
            catch (JSONException localJSONException2)
            {
              try
              {
                this.jdField_c_of_type_OrgJsonJSONObject = new JSONObject(str7);
                label253:
                if (str6 == null) {}
              }
              catch (JSONException localJSONException2)
              {
                try
                {
                  this.jdField_d_of_type_OrgJsonJSONObject = new JSONObject(str6);
                  label271:
                  if (str5 == null) {}
                }
                catch (JSONException localJSONException2)
                {
                  try
                  {
                    this.jdField_c_of_type_OrgJsonJSONArray = new JSONArray(str5);
                    label289:
                    if (this.jdField_c_of_type_OrgJsonJSONArray != null) {}
                  }
                  catch (JSONException localJSONException2)
                  {
                    try
                    {
                      this.jdField_c_of_type_OrgJsonJSONArray = new JSONArray("[\"*.qq.com\",\"*.tenpay.com\"]");
                      label309:
                      if (str4 != null) {}
                      try
                      {
                        this.jdField_d_of_type_OrgJsonJSONArray = new JSONArray(str4);
                        label327:
                        if (this.jdField_d_of_type_OrgJsonJSONArray != null) {}
                      }
                      catch (JSONException localJSONException2)
                      {
                        try
                        {
                          this.jdField_d_of_type_OrgJsonJSONArray = new JSONArray("[\"qq.com\"]");
                          label347:
                          if (str3 != null) {}
                          try
                          {
                            this.jdField_e_of_type_OrgJsonJSONArray = new JSONArray(str3);
                            label365:
                            if (this.jdField_e_of_type_OrgJsonJSONArray != null) {}
                          }
                          catch (JSONException localJSONException2)
                          {
                            try
                            {
                              this.jdField_e_of_type_OrgJsonJSONArray = new JSONArray("[\"game.qq.com\",\"id.qq.com\",\"qzone.qq.com\",\"m.qzone.com\",\"qzone.com\"]");
                              label385:
                              if (str2 != null) {}
                              try
                              {
                                this.jdField_e_of_type_OrgJsonJSONObject = new JSONObject(str2);
                                label403:
                                if (this.jdField_e_of_type_OrgJsonJSONObject != null) {}
                              }
                              catch (JSONException localJSONException2)
                              {
                                try
                                {
                                  this.jdField_e_of_type_OrgJsonJSONObject = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\"]}");
                                  label423:
                                  if (str1 != null) {}
                                  try
                                  {
                                    this.f = new JSONArray(str1);
                                    jdField_a_of_type_Long = l1;
                                    return;
                                    localJSONException15 = localJSONException15;
                                    if (!QLog.isColorLevel()) {
                                      continue;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mOfflineConfig  error");
                                    continue;
                                    localJSONException13 = localJSONException13;
                                    if (!QLog.isColorLevel()) {
                                      continue;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mCmdConfig error");
                                    continue;
                                    localJSONException12 = localJSONException12;
                                    if (!QLog.isColorLevel()) {
                                      break label235;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode cmdRights error");
                                    break label235;
                                    localJSONException11 = localJSONException11;
                                    if (!QLog.isColorLevel()) {
                                      break label253;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mExtraConfig error");
                                    break label253;
                                    localJSONException10 = localJSONException10;
                                    if (!QLog.isColorLevel()) {
                                      break label271;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mJumpConfig error");
                                    break label271;
                                    localJSONException8 = localJSONException8;
                                    if (!QLog.isColorLevel()) {
                                      break label289;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mSkeyConfig error");
                                    break label289;
                                    localJSONException6 = localJSONException6;
                                    if (!QLog.isColorLevel()) {
                                      break label327;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mVkeyConfig error");
                                    break label327;
                                    localJSONException4 = localJSONException4;
                                    if (!QLog.isColorLevel()) {
                                      break label365;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mPskeyConfig error");
                                    break label365;
                                    localJSONException2 = localJSONException2;
                                    if (!QLog.isColorLevel()) {
                                      break label403;
                                    }
                                    QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
                                  }
                                  catch (JSONException localJSONException1)
                                  {
                                    for (;;)
                                    {
                                      if (QLog.isColorLevel()) {
                                        QLog.d("AuthorizeConfig", 2, "Decode mA1Config error");
                                      }
                                    }
                                  }
                                }
                                catch (JSONException localJSONException3)
                                {
                                  break label423;
                                }
                              }
                            }
                            catch (JSONException localJSONException5)
                            {
                              break label385;
                            }
                          }
                        }
                        catch (JSONException localJSONException7)
                        {
                          break label347;
                        }
                      }
                    }
                    catch (JSONException localJSONException9)
                    {
                      break label309;
                    }
                  }
                }
              }
            }
          }
        }
        catch (JSONException localJSONException14)
        {
          break label217;
        }
      }
    }
  }
  
  /* Error */
  public void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4: astore 8
    //   6: aload_0
    //   7: getfield 132	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   10: invokeinterface 341 1 0
    //   15: astore 9
    //   17: new 198	org/json/JSONObject
    //   20: dup
    //   21: invokespecial 342	org/json/JSONObject:<init>	()V
    //   24: astore 10
    //   26: aload_1
    //   27: ldc_w 344
    //   30: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   33: astore 11
    //   35: aload 11
    //   37: invokevirtual 268	org/json/JSONArray:length	()I
    //   40: istore 6
    //   42: iconst_0
    //   43: istore 4
    //   45: iload 4
    //   47: iload 6
    //   49: if_icmpge +73 -> 122
    //   52: aload 11
    //   54: iload 4
    //   56: invokevirtual 284	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   59: astore 13
    //   61: aload 13
    //   63: ldc_w 346
    //   66: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   69: astore 12
    //   71: aload 13
    //   73: ldc_w 348
    //   76: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   79: astore 13
    //   81: iconst_0
    //   82: istore 5
    //   84: aload 13
    //   86: invokevirtual 268	org/json/JSONArray:length	()I
    //   89: istore 7
    //   91: iload 5
    //   93: iload 7
    //   95: if_icmpge +740 -> 835
    //   98: aload 10
    //   100: aload 13
    //   102: iload 5
    //   104: invokevirtual 291	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   107: aload 12
    //   109: invokevirtual 352	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   112: pop
    //   113: iload 5
    //   115: iconst_1
    //   116: iadd
    //   117: istore 5
    //   119: goto -28 -> 91
    //   122: aload_0
    //   123: aload 10
    //   125: putfield 304	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   128: aload 9
    //   130: ldc 25
    //   132: aload 10
    //   134: invokevirtual 353	org/json/JSONObject:toString	()Ljava/lang/String;
    //   137: invokeinterface 359 3 0
    //   142: pop
    //   143: aload_1
    //   144: ldc 28
    //   146: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   149: astore 10
    //   151: aload_0
    //   152: aload 10
    //   154: putfield 281	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   157: aload 9
    //   159: ldc 28
    //   161: aload 10
    //   163: invokevirtual 360	org/json/JSONArray:toString	()Ljava/lang/String;
    //   166: invokeinterface 359 3 0
    //   171: pop
    //   172: aload_1
    //   173: ldc_w 362
    //   176: invokevirtual 205	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   179: astore 10
    //   181: aload_0
    //   182: aload 10
    //   184: putfield 190	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   187: aload 9
    //   189: ldc 40
    //   191: aload 10
    //   193: invokevirtual 353	org/json/JSONObject:toString	()Ljava/lang/String;
    //   196: invokeinterface 359 3 0
    //   201: pop
    //   202: aload_1
    //   203: ldc_w 364
    //   206: invokevirtual 205	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   209: astore 10
    //   211: aload_0
    //   212: aload 10
    //   214: putfield 218	com/tencent/biz/AuthorizeConfig:jdField_c_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   217: aload 9
    //   219: ldc 34
    //   221: aload 10
    //   223: invokevirtual 353	org/json/JSONObject:toString	()Ljava/lang/String;
    //   226: invokeinterface 359 3 0
    //   231: pop
    //   232: aload_1
    //   233: ldc 37
    //   235: invokevirtual 205	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   238: astore 10
    //   240: aload_0
    //   241: aload 10
    //   243: putfield 256	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   246: aload 9
    //   248: ldc 37
    //   250: aload 10
    //   252: invokevirtual 353	org/json/JSONObject:toString	()Ljava/lang/String;
    //   255: invokeinterface 359 3 0
    //   260: pop
    //   261: aload_1
    //   262: ldc 43
    //   264: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   267: astore 10
    //   269: aload_0
    //   270: aload 10
    //   272: putfield 306	com/tencent/biz/AuthorizeConfig:jdField_c_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   275: aload 9
    //   277: ldc 43
    //   279: aload 10
    //   281: invokevirtual 360	org/json/JSONArray:toString	()Ljava/lang/String;
    //   284: invokeinterface 359 3 0
    //   289: pop
    //   290: aload_0
    //   291: aconst_null
    //   292: putfield 366	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   295: aload_1
    //   296: ldc 46
    //   298: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   301: astore 10
    //   303: aload_0
    //   304: aload 10
    //   306: putfield 308	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   309: aload 9
    //   311: ldc 46
    //   313: aload 10
    //   315: invokevirtual 360	org/json/JSONArray:toString	()Ljava/lang/String;
    //   318: invokeinterface 359 3 0
    //   323: pop
    //   324: aload_0
    //   325: aconst_null
    //   326: putfield 366	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   329: aload_1
    //   330: ldc 49
    //   332: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   335: astore 10
    //   337: aload 10
    //   339: invokevirtual 360	org/json/JSONArray:toString	()Ljava/lang/String;
    //   342: ldc_w 368
    //   345: invokevirtual 371	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   348: ifne +12 -> 360
    //   351: aload 10
    //   353: ldc_w 368
    //   356: invokevirtual 374	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   359: pop
    //   360: aload_0
    //   361: aload 10
    //   363: putfield 310	com/tencent/biz/AuthorizeConfig:jdField_e_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   366: aload 9
    //   368: ldc 49
    //   370: aload 10
    //   372: invokevirtual 360	org/json/JSONArray:toString	()Ljava/lang/String;
    //   375: invokeinterface 359 3 0
    //   380: pop
    //   381: aload_0
    //   382: aconst_null
    //   383: putfield 376	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   386: new 198	org/json/JSONObject
    //   389: dup
    //   390: invokespecial 342	org/json/JSONObject:<init>	()V
    //   393: astore 10
    //   395: aload_1
    //   396: ldc 52
    //   398: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   401: astore 11
    //   403: aload 11
    //   405: invokevirtual 268	org/json/JSONArray:length	()I
    //   408: istore 6
    //   410: iconst_0
    //   411: istore 4
    //   413: iload 4
    //   415: iload 6
    //   417: if_icmpge +170 -> 587
    //   420: aload 11
    //   422: iload 4
    //   424: invokevirtual 284	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   427: astore 13
    //   429: aload 13
    //   431: ldc_w 274
    //   434: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   437: astore 12
    //   439: aload 13
    //   441: ldc_w 348
    //   444: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   447: astore 13
    //   449: iconst_0
    //   450: istore 5
    //   452: aload 13
    //   454: invokevirtual 268	org/json/JSONArray:length	()I
    //   457: istore 7
    //   459: iload 5
    //   461: iload 7
    //   463: if_icmpge +115 -> 578
    //   466: aload 10
    //   468: aload 13
    //   470: iload 5
    //   472: invokevirtual 291	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   475: aload 12
    //   477: invokevirtual 352	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   480: pop
    //   481: iload 5
    //   483: iconst_1
    //   484: iadd
    //   485: istore 5
    //   487: goto -28 -> 459
    //   490: astore 8
    //   492: iconst_0
    //   493: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   496: astore 8
    //   498: goto -355 -> 143
    //   501: astore 8
    //   503: iconst_0
    //   504: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   507: astore 8
    //   509: goto -337 -> 172
    //   512: astore 8
    //   514: iconst_0
    //   515: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   518: astore 8
    //   520: goto -318 -> 202
    //   523: astore 8
    //   525: iconst_0
    //   526: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   529: astore 8
    //   531: goto -299 -> 232
    //   534: astore 8
    //   536: iconst_0
    //   537: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   540: astore 8
    //   542: goto -281 -> 261
    //   545: astore 8
    //   547: iconst_0
    //   548: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   551: astore 8
    //   553: goto -258 -> 295
    //   556: astore 8
    //   558: iconst_0
    //   559: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   562: astore 8
    //   564: goto -235 -> 329
    //   567: astore 8
    //   569: iconst_0
    //   570: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   573: astore 8
    //   575: goto -189 -> 386
    //   578: iload 4
    //   580: iconst_1
    //   581: iadd
    //   582: istore 4
    //   584: goto -171 -> 413
    //   587: aload_0
    //   588: aload 10
    //   590: putfield 312	com/tencent/biz/AuthorizeConfig:jdField_e_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   593: aload 9
    //   595: ldc 52
    //   597: aload 10
    //   599: invokevirtual 353	org/json/JSONObject:toString	()Ljava/lang/String;
    //   602: invokeinterface 359 3 0
    //   607: pop
    //   608: aload_1
    //   609: ldc 55
    //   611: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   614: astore_1
    //   615: aload_0
    //   616: aload_1
    //   617: putfield 314	com/tencent/biz/AuthorizeConfig:f	Lorg/json/JSONArray;
    //   620: aload 9
    //   622: ldc 55
    //   624: aload_1
    //   625: invokevirtual 360	org/json/JSONArray:toString	()Ljava/lang/String;
    //   628: invokeinterface 359 3 0
    //   633: pop
    //   634: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   637: ifeq +30 -> 667
    //   640: ldc 14
    //   642: iconst_2
    //   643: new 170	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   650: ldc_w 378
    //   653: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload 8
    //   658: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   661: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   667: aload 8
    //   669: invokevirtual 384	java/lang/Boolean:booleanValue	()Z
    //   672: ifeq +122 -> 794
    //   675: iconst_2
    //   676: putstatic 102	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_Int	I
    //   679: aload 9
    //   681: ldc 31
    //   683: invokestatic 390	java/lang/System:currentTimeMillis	()J
    //   686: invokeinterface 394 4 0
    //   691: pop
    //   692: aload 9
    //   694: ldc 79
    //   696: ldc_w 396
    //   699: invokeinterface 359 3 0
    //   704: pop
    //   705: aload 9
    //   707: aload_3
    //   708: aload_2
    //   709: invokeinterface 359 3 0
    //   714: pop
    //   715: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   718: ifeq +12 -> 730
    //   721: ldc 14
    //   723: iconst_2
    //   724: ldc_w 398
    //   727: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   730: aconst_null
    //   731: ldc_w 400
    //   734: ldc_w 402
    //   737: ldc_w 404
    //   740: ldc_w 406
    //   743: ldc_w 408
    //   746: iconst_0
    //   747: iconst_1
    //   748: iconst_0
    //   749: ldc_w 404
    //   752: ldc_w 404
    //   755: ldc_w 404
    //   758: ldc_w 404
    //   761: invokestatic 413	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   764: aload 9
    //   766: invokeinterface 416 1 0
    //   771: pop
    //   772: return
    //   773: astore 8
    //   775: iconst_0
    //   776: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   779: astore 8
    //   781: goto -173 -> 608
    //   784: astore_1
    //   785: iconst_0
    //   786: invokestatic 231	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   789: astore 8
    //   791: goto -157 -> 634
    //   794: iconst_0
    //   795: putstatic 102	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_Int	I
    //   798: aconst_null
    //   799: ldc_w 400
    //   802: ldc_w 402
    //   805: ldc_w 404
    //   808: ldc_w 406
    //   811: ldc_w 418
    //   814: iconst_0
    //   815: iconst_1
    //   816: iconst_0
    //   817: ldc_w 404
    //   820: ldc_w 404
    //   823: ldc_w 404
    //   826: ldc_w 404
    //   829: invokestatic 413	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   832: goto -68 -> 764
    //   835: iload 4
    //   837: iconst_1
    //   838: iadd
    //   839: istore 4
    //   841: goto -796 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	844	0	this	AuthorizeConfig
    //   0	844	1	paramJSONObject	JSONObject
    //   0	844	2	paramString1	String
    //   0	844	3	paramString2	String
    //   43	797	4	i1	int
    //   82	404	5	i2	int
    //   40	378	6	i3	int
    //   89	375	7	i4	int
    //   4	1	8	localBoolean1	Boolean
    //   490	1	8	localException1	java.lang.Exception
    //   496	1	8	localBoolean2	Boolean
    //   501	1	8	localJSONException1	JSONException
    //   507	1	8	localBoolean3	Boolean
    //   512	1	8	localJSONException2	JSONException
    //   518	1	8	localBoolean4	Boolean
    //   523	1	8	localJSONException3	JSONException
    //   529	1	8	localBoolean5	Boolean
    //   534	1	8	localJSONException4	JSONException
    //   540	1	8	localBoolean6	Boolean
    //   545	1	8	localJSONException5	JSONException
    //   551	1	8	localBoolean7	Boolean
    //   556	1	8	localJSONException6	JSONException
    //   562	1	8	localBoolean8	Boolean
    //   567	1	8	localJSONException7	JSONException
    //   573	95	8	localBoolean9	Boolean
    //   773	1	8	localException2	java.lang.Exception
    //   779	11	8	localBoolean10	Boolean
    //   15	750	9	localEditor	android.content.SharedPreferences.Editor
    //   24	574	10	localObject1	Object
    //   33	388	11	localJSONArray1	JSONArray
    //   69	407	12	localJSONArray2	JSONArray
    //   59	410	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	42	490	java/lang/Exception
    //   52	81	490	java/lang/Exception
    //   84	91	490	java/lang/Exception
    //   98	113	490	java/lang/Exception
    //   122	143	490	java/lang/Exception
    //   143	172	501	org/json/JSONException
    //   172	202	512	org/json/JSONException
    //   202	232	523	org/json/JSONException
    //   232	261	534	org/json/JSONException
    //   261	295	545	org/json/JSONException
    //   295	329	556	org/json/JSONException
    //   329	360	567	org/json/JSONException
    //   360	386	567	org/json/JSONException
    //   386	410	773	java/lang/Exception
    //   420	449	773	java/lang/Exception
    //   452	459	773	java/lang/Exception
    //   466	481	773	java/lang/Exception
    //   587	608	773	java/lang/Exception
    //   608	634	784	org/json/JSONException
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
      localObject1 = this.jdField_a_of_type_OrgJsonJSONObject.names();
    } while (localObject1 == null);
    int i3 = ((JSONArray)localObject1).length();
    int i1 = 0;
    label91:
    Object localObject2;
    if (i1 < i3)
    {
      localObject2 = ((JSONArray)localObject1).optString(i1);
      if (b((String)localObject2, paramString1)) {
        break label121;
      }
    }
    for (;;)
    {
      i1 += 1;
      break label91;
      break;
      label121:
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
    int i1 = 0;
    if (jdField_b_of_type_Int == 1) {
      return;
    }
    boolean bool;
    if (jdField_b_of_type_Int == -1)
    {
      bool = "com.tencent.qqlite".equals(MobileQQ.getMobileQQ().getProcessName());
      jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis() - jdField_a_of_type_Long;
      if ((l1 < 0L) || (l1 >= 86400000L)) {
        i1 = 1;
      }
      if ((!bool) && (i1 == 0)) {
        break;
      }
      jdField_b_of_type_Int = 1;
      ThreadManager.a(new jl(this));
      return;
      bool = false;
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
        if (!this.jdField_e_of_type_OrgJsonJSONArray.toString().contains("m.qzone.com")) {
          this.jdField_e_of_type_OrgJsonJSONArray.put("m.qzone.com");
        }
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
  
  public String[] c()
  {
    String[] arrayOfString = this.jdField_c_of_type_ArrayOfJavaLangString;
    Object localObject = arrayOfString;
    if (arrayOfString == null)
    {
      localObject = new HashSet(16);
      if ((this.jdField_c_of_type_OrgJsonJSONArray != null) && (this.jdField_c_of_type_OrgJsonJSONArray.length() != 0)) {
        break label85;
      }
      ((Set)localObject).add("*.qq.com".replaceFirst("\\*\\.", ""));
    }
    for (;;)
    {
      localObject = (String[])((Set)localObject).toArray(new String[((Set)localObject).size()]);
      this.jdField_c_of_type_ArrayOfJavaLangString = ((String[])localObject);
      return localObject;
      label85:
      int i2 = this.jdField_c_of_type_OrgJsonJSONArray.length();
      int i1 = 0;
      while (i1 < i2)
      {
        ((Set)localObject).add(this.jdField_c_of_type_OrgJsonJSONArray.optString(i1, "").replaceFirst("\\*\\.", ""));
        i1 += 1;
      }
    }
  }
  
  public boolean d(String paramString)
  {
    String str = Uri.parse(paramString).getScheme();
    if ((!"http".equals(str)) && (!"https".equals(str))) {}
    for (;;)
    {
      return false;
      paramString = Uri.parse(paramString).getHost();
      if (this.f != null)
      {
        int i2 = this.f.length();
        int i1 = 0;
        while (i1 < i2)
        {
          if (b(this.f.optString(i1), paramString)) {
            return true;
          }
          i1 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig
 * JD-Core Version:    0.7.0.1
 */