package com.tencent.mobileqq.nearby;

import acig;
import affz;
import afjy;
import ajoz;
import ajpf;
import ajph;
import ajpy;
import ajpz;
import ajqa;
import ajqb;
import ajqe;
import ajqf;
import ajqg;
import ajrb;
import ajrm;
import ajvd;
import akkm;
import akks;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import aqcr;
import aqdj.a;
import aqeh;
import aqep;
import aqep.a;
import aqfo;
import aqgo;
import aqhu;
import aqyg;
import aqzd;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import jnl;
import jqc;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import skj;
import tencent.im.oidb.cmd0x8c1.oidb_0x8c1.ReqBody;
import tencent.im.oidb.cmd0x8c1.oidb_0x8c1.UserDeviceInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NearbyJsInterface
  extends aqzd
  implements aqdj.a
{
  aqcr jdField_a_of_type_Aqcr = null;
  private b jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$b;
  private String aEt;
  private String bSb = "";
  private String bSc = "";
  private String bSd = "";
  private String bSe;
  private String bSf = "";
  private String bSg = "";
  private BroadcastReceiver bu = new ajpy(this);
  public Context context;
  public HashMap<String, a> lT = new HashMap();
  private BroadcastReceiver mBroadcastReceiver = new ajpz(this);
  public skj mClient;
  private int mFrom;
  
  public NearbyJsInterface()
  {
    ayA();
  }
  
  private void a(a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "openNearbyAio, from = " + this.mFrom);
    }
    Activity localActivity = this.mRuntime.getActivity();
    Intent localIntent = new Intent(localActivity, ChatActivity.class);
    localIntent.putExtra("PREVIOUS_UIN", parama.uin);
    localIntent.putExtra("uin", parama.uin);
    if (this.mFrom == 1) {}
    for (int i = 10002;; i = 1001)
    {
      localIntent.putExtra("uintype", i);
      localIntent.putExtra("gender", 1);
      localIntent.addFlags(67108864);
      localActivity.startActivity(localIntent);
      return;
    }
  }
  
  private void ayA()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.NearbyJsInterface");
    BaseApplicationImpl.getApplication().registerReceiver(this.bu, localIntentFilter);
  }
  
  private void ayB()
  {
    BaseApplicationImpl.getApplication().unregisterReceiver(this.bu);
  }
  
  private void iN(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("before", paramInt1);
      localJSONObject.put("after", paramInt2);
      callJs(this.bSg, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("NearbyJsInterface", 1, "notifyWebNetworkChange exception: " + localJSONException.toString());
      }
    }
  }
  
  /* Error */
  public void clearFilterList(String paramString)
  {
    // Byte code:
    //   0: invokestatic 175	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: invokevirtual 216	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6: ldc 218
    //   8: invokevirtual 224	mqq/app/AppRuntime:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   11: checkcast 226	com/tencent/mobileqq/nearby/NearbyAppInterface
    //   14: astore 5
    //   16: new 189	org/json/JSONObject
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 228	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore_3
    //   25: aload_3
    //   26: ldc 230
    //   28: invokevirtual 234	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   31: istore_2
    //   32: iload_2
    //   33: iconst_1
    //   34: if_icmpne +122 -> 156
    //   37: iconst_1
    //   38: istore_2
    //   39: aload_3
    //   40: ldc 236
    //   42: invokevirtual 240	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: pop
    //   46: aload_0
    //   47: getfield 111	com/tencent/mobileqq/nearby/NearbyJsInterface:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   50: invokevirtual 117	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   53: astore_3
    //   54: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +47 -> 104
    //   60: ldc 87
    //   62: iconst_2
    //   63: new 89	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   70: ldc 242
    //   72: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 244
    //   81: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 5
    //   86: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: ldc 249
    //   91: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_3
    //   95: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: aload 5
    //   106: ifnull +49 -> 155
    //   109: aload_3
    //   110: instanceof 251
    //   113: ifeq +42 -> 155
    //   116: aload_3
    //   117: checkcast 251	com/tencent/mobileqq/app/BaseActivity
    //   120: astore_1
    //   121: iload_2
    //   122: ifeq +78 -> 200
    //   125: aload_1
    //   126: invokevirtual 254	com/tencent/mobileqq/app/BaseActivity:isFinishing	()Z
    //   129: ifne +71 -> 200
    //   132: aload 5
    //   134: iconst_3
    //   135: invokevirtual 258	com/tencent/mobileqq/nearby/NearbyAppInterface:getBusinessHandler	(I)Laccg;
    //   138: checkcast 260	acig
    //   141: astore_1
    //   142: aload_1
    //   143: ifnull +7 -> 150
    //   146: aload_1
    //   147: invokevirtual 263	acig:cKR	()V
    //   150: aload 5
    //   152: invokestatic 268	ahng:a	(Lcom/tencent/mobileqq/nearby/NearbyAppInterface;)V
    //   155: return
    //   156: iconst_0
    //   157: istore_2
    //   158: goto -119 -> 39
    //   161: astore 4
    //   163: aconst_null
    //   164: astore_3
    //   165: ldc 87
    //   167: iconst_2
    //   168: new 89	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 270
    //   178: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 4
    //   183: invokevirtual 208	org/json/JSONException:toString	()Ljava/lang/String;
    //   186: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: iconst_0
    //   196: istore_2
    //   197: goto -158 -> 39
    //   200: invokestatic 276	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   203: invokestatic 282	aqiw:isNetSupport	(Landroid/content/Context;)Z
    //   206: ifeq +49 -> 255
    //   209: aload_1
    //   210: invokevirtual 254	com/tencent/mobileqq/app/BaseActivity:isFinishing	()Z
    //   213: ifne +42 -> 255
    //   216: aload 5
    //   218: invokestatic 268	ahng:a	(Lcom/tencent/mobileqq/nearby/NearbyAppInterface;)V
    //   221: new 119	android/content/Intent
    //   224: dup
    //   225: aload_1
    //   226: ldc_w 284
    //   229: invokespecial 124	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   232: astore_3
    //   233: aload_3
    //   234: ldc 142
    //   236: invokevirtual 287	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   239: pop
    //   240: aload_3
    //   241: ldc_w 289
    //   244: iconst_1
    //   245: invokevirtual 292	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   248: pop
    //   249: aload_1
    //   250: aload_3
    //   251: invokevirtual 293	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   254: return
    //   255: invokestatic 276	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   258: iconst_1
    //   259: aload_1
    //   260: ldc_w 294
    //   263: invokevirtual 298	com/tencent/mobileqq/app/BaseActivity:getString	(I)Ljava/lang/String;
    //   266: iconst_0
    //   267: invokestatic 303	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   270: aload_1
    //   271: invokevirtual 307	com/tencent/mobileqq/app/BaseActivity:getTitleBarHeight	()I
    //   274: invokevirtual 311	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   277: pop
    //   278: return
    //   279: astore 4
    //   281: goto -116 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	NearbyJsInterface
    //   0	284	1	paramString	String
    //   31	166	2	i	int
    //   24	227	3	localObject	Object
    //   161	21	4	localJSONException1	JSONException
    //   279	1	4	localJSONException2	JSONException
    //   14	203	5	localNearbyAppInterface	NearbyAppInterface
    // Exception table:
    //   from	to	target	type
    //   16	25	161	org/json/JSONException
    //   25	32	279	org/json/JSONException
  }
  
  public void clearUnReadRedTouch(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "clearUnReadRedTouch:" + paramString);
    }
    try
    {
      int i = new JSONObject(paramString).optInt("appid");
      ((ajvd)((NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby")).getManager(214)).Ru(i);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "clearUnReadRedTouch exp:" + paramString.toString());
    }
  }
  
  public void contentLoaded()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "contentLoaded");
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mRuntime.getActivity() != null)
    {
      localObject1 = localObject2;
      if ((this.mRuntime.getActivity() instanceof NearbyActivity)) {
        localObject1 = (NearbyActivity)this.mRuntime.getActivity();
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((NearbyActivity)localObject1).a();
      if (localObject1 != null) {
        ((NearbyHybridFragment)localObject1).dpd();
      }
    }
  }
  
  public void createMsgFromOther(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.aEt = paramString.optString("callback");
      String str = paramString.optString("tinyid");
      int i = paramString.optInt("isSuperLove");
      this.mFrom = paramString.optInt("from");
      getMatchPeopleInfo(str, false, i);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void editSchool(String paramString)
  {
    if (this.mClient == null)
    {
      this.mClient = skj.a();
      this.mClient.bzj();
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optString("schoolName");
      int i = paramString.optInt("isValid");
      this.mClient.bB(str, i);
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, paramString, new Object[0]);
    }
  }
  
  public void filterList(String paramString)
  {
    acig localacig = (acig)((NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby")).getBusinessHandler(3);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "save filterList: params=" + paramString);
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      if (((JSONObject)localObject).optInt("filter") == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NearbyJsInterface", 2, "filter==0, return");
        }
      }
      else
      {
        int i = ((JSONObject)localObject).optInt("sex");
        int j = ((JSONObject)localObject).optInt("time");
        int k = ((JSONObject)localObject).optInt("age");
        int m = ((JSONObject)localObject).optInt("interest");
        int n = ((JSONObject)localObject).optInt("profession");
        int i1 = ((JSONObject)localObject).optInt("country");
        int i2 = ((JSONObject)localObject).optInt("province");
        int i3 = ((JSONObject)localObject).optInt("city");
        int i4 = ((JSONObject)localObject).optInt("contellation");
        paramString = ((JSONObject)localObject).optString("strCountry");
        String str1 = ((JSONObject)localObject).optString("strProvince");
        String str2 = ((JSONObject)localObject).optString("strCity");
        localObject = ((JSONObject)localObject).optString("callback");
        localacig.a(i, j, k, m, n, i1, i2, i3, i4, paramString, str1, str2);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          callJs((String)localObject, new String[] { "" });
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyJsInterface", 2, "save filterList exp:", paramString);
      }
    }
  }
  
  public void followUser(String paramString)
  {
    Object localObject = new NewIntent(this.mRuntime.a().getApplication().getApplicationContext(), jnl.class);
    ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.follow_user");
    WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
    localWebSsoRequestBody.type.set(0);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localJSONObject.remove("callback");
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      ((NewIntent)localObject).putExtra("data", localWebSsoRequestBody.toByteArray());
      ((NewIntent)localObject).setObserver(new ajqf(this, paramString));
      this.mRuntime.a().startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        try
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("targetuin", new JSONObject(paramString).getString("targetuin"));
          paramString = affz.a("ipc_should_refresh_cardinfo", "", 0, (Bundle)localObject);
          afjy.a().cq(paramString);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("NearbyJsInterface", 2, "followUser failed! json failed, msg = " + paramString.getMessage());
      return;
    }
  }
  
  public void getFilterList(String paramString)
  {
    for (;;)
    {
      try
      {
        if ((this.mRuntime.getActivity() != null) && ((this.mRuntime.getActivity() instanceof NearbyActivity)))
        {
          localObject2 = (NearbyActivity)this.mRuntime.getActivity();
          String str = "";
          Object localObject1 = str;
          if (localObject2 != null)
          {
            localObject2 = ((NearbyActivity)localObject2).a();
            localObject1 = str;
            if (localObject2 != null)
            {
              localObject1 = ((NearbyHybridFragment)localObject2).a();
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("sex", ((ajph)localObject1).gender);
              ((JSONObject)localObject2).put("time", ((ajph)localObject1).time);
              ((JSONObject)localObject2).put("age", ((ajph)localObject1).age);
              ((JSONObject)localObject2).put("interest", ((ajph)localObject1).dke);
              ((JSONObject)localObject2).put("profession", ((ajph)localObject1).career);
              ((JSONObject)localObject2).put("country", localObject1.fx[0]);
              ((JSONObject)localObject2).put("province", localObject1.fx[1]);
              ((JSONObject)localObject2).put("city", localObject1.fx[2]);
              ((JSONObject)localObject2).put("contellation", ((ajph)localObject1).dkf);
              ((JSONObject)localObject2).put("strCountry", ((ajph)localObject1).country);
              ((JSONObject)localObject2).put("strProvince", ((ajph)localObject1).province);
              ((JSONObject)localObject2).put("strCity", ((ajph)localObject1).city);
              localObject1 = ((JSONObject)localObject2).toString();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("NearbyJsInterface", 2, "getFilterList: param=" + paramString + ", ret=" + (String)localObject1);
          }
          callJs(new JSONObject(paramString).optString("callback"), new String[] { localObject1 });
          return;
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NearbyJsInterface", 2, "getFilterList exp:" + paramString.toString());
        return;
      }
      Object localObject2 = null;
    }
  }
  
  public void getFilterListV2(String paramString)
  {
    Object localObject = "";
    try
    {
      ajph localajph = ajph.a(this.mRuntime.a().getCurrentAccountUin());
      if (localajph != null)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("sex", localajph.gender);
        ((JSONObject)localObject).put("time", localajph.time);
        ((JSONObject)localObject).put("age", localajph.age);
        ((JSONObject)localObject).put("interest", localajph.dke);
        ((JSONObject)localObject).put("profession", localajph.career);
        ((JSONObject)localObject).put("country", localajph.fx[0]);
        ((JSONObject)localObject).put("province", localajph.fx[1]);
        ((JSONObject)localObject).put("city", localajph.fx[2]);
        ((JSONObject)localObject).put("contellation", localajph.dkf);
        ((JSONObject)localObject).put("strCountry", localajph.country);
        ((JSONObject)localObject).put("strProvince", localajph.province);
        ((JSONObject)localObject).put("strCity", localajph.city);
        localObject = ((JSONObject)localObject).toString();
      }
      if (QLog.isColorLevel()) {
        QLog.d("NearbyJsInterface", 2, "getFilterListV2: param=" + paramString + ", ret=" + (String)localObject);
      }
      callJs(new JSONObject(paramString).optString("callback"), new String[] { localObject });
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "getFilterListV2 exp:" + paramString.toString());
    }
  }
  
  public void getLbsInfo(String paramString)
  {
    String str = "";
    try
    {
      this.aEt = new JSONObject(paramString).optString("callback");
      SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.b();
      if (localSosoLbsInfo != null)
      {
        paramString = localSosoLbsInfo;
        if (localSosoLbsInfo.a != null) {}
      }
      else
      {
        paramString = SosoInterface.b();
      }
      if (paramString != null) {
        str = ajpf.a(paramString);
      }
      callJs(this.aEt, new String[] { str });
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getMatchPeople(String paramString, int paramInt)
  {
    a locala = (a)this.lT.get(String.valueOf(paramString));
    if ((locala != null) && (!TextUtils.isEmpty(locala.uin)) && (!locala.uin.equals("0")))
    {
      a(locala);
      return;
    }
    getMatchPeopleInfo(paramString, true, paramInt);
  }
  
  public void getMatchPeopleInfo(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.mClient == null)
    {
      this.mClient = skj.a();
      this.mClient.bzj();
    }
    Object localObject1 = new oidb_0x8c1.ReqBody();
    Object localObject2 = new oidb_0x8c1.UserDeviceInfo();
    ((oidb_0x8c1.UserDeviceInfo)localObject2).int32_client_type.set(1);
    ((oidb_0x8c1.UserDeviceInfo)localObject2).uint32_instance_id.set(AppSetting.getAppId());
    ((oidb_0x8c1.UserDeviceInfo)localObject2).uint32_portal.set(4);
    ((oidb_0x8c1.ReqBody)localObject1).msg_req_info.set((MessageMicro)localObject2);
    ((oidb_0x8c1.ReqBody)localObject1).int32_is_super_love.set(paramInt);
    try
    {
      ((oidb_0x8c1.ReqBody)localObject1).uint64_first_rater_tinyid.set(Long.parseLong(paramString));
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2241);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x8c1.ReqBody)localObject1).toByteArray()));
      localObject1 = new NewIntent(BaseApplication.getContext(), jnl.class);
      ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x8c1_1");
      ((NewIntent)localObject1).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((NewIntent)localObject1).setObserver(new ajqe(this, paramString, paramBoolean));
      this.mRuntime.a().startServlet((NewIntent)localObject1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyJsInterface", 2, "getMatchPeopleInfo parseLong Failed :" + localException);
        }
      }
    }
  }
  
  public String getNameSpace()
  {
    return "nearby";
  }
  
  public void getNearbyPeopleAvatar(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramString);
        this.bSe = ((JSONObject)localObject1).optString("callback");
        paramString = (NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby");
        localObject1 = ((JSONObject)localObject1).optString("tinyid");
        localObject2 = aqhu.aV();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        this.jdField_a_of_type_Aqcr = new aqeh(paramString, 32, 202, String.valueOf(Long.parseLong((String)localObject1)), (byte)1, 1, true, (Drawable)localObject2, (Drawable)localObject2, this, false);
        localObject2 = this.jdField_a_of_type_Aqcr.aF();
        paramString = new ByteArrayOutputStream(1024);
        localObject1 = new StringBuilder("data:image/jpeg;base64,");
        if (localObject2 == null) {
          continue;
        }
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, paramString);
        ((StringBuilder)localObject1).append(aqgo.encodeToString(paramString.toByteArray(), 2));
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("ret", 0);
        ((JSONObject)localObject2).put("data", localObject1);
        callJs(this.bSe, new String[] { ((JSONObject)localObject2).toString() });
      }
      catch (Exception paramString)
      {
        Object localObject2;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("NearbyJsInterface", 2, "getNearbyPeopleAvatar failed:" + paramString);
        return;
        callJs(this.bSe, new String[] { "{\"ret\":1}" });
        continue;
      }
      paramString.flush();
      paramString.close();
      return;
      this.jdField_a_of_type_Aqcr = new aqeh(paramString, 32, 200, this.mRuntime.a().getCurrentAccountUin(), (byte)1, 1, true, (Drawable)localObject2, (Drawable)localObject2, this, false);
    }
  }
  
  public void getNearbyPublishBase64Images(String paramString)
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      String str = akks.mu(((AppRuntime)localObject).getAccount());
      akks.gP(((AppRuntime)localObject).getAccount(), "");
      QLog.d("NearbyPublishMenuHelper", 1, "getPicBase64, params=" + paramString + ", picBase64.len=" + str.length());
      localObject = new JSONArray();
      ((JSONArray)localObject).put(new JSONObject(str));
      callJs(new JSONObject(paramString).optString("callback"), new String[] { "0", ((JSONArray)localObject).toString() });
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("NearbyPublishMenuHelper", 1, "getPicBase64 failed!, exp=" + paramString.toString());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("NearbyPublishMenuHelper", 1, "getPicBase64 OOM! err=" + paramString.toString());
    }
  }
  
  public void getNearbyRedDotInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "getNearbyRedDotInfo:" + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("appid");
        paramString = paramString.optString("callback");
        if ((i <= 0) || (TextUtils.isEmpty(paramString))) {
          return;
        }
        localRedTypeInfo = ((ajvd)((NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby")).getManager(214)).b(i);
        localJSONObject = new JSONObject();
        if (localRedTypeInfo == null) {
          continue;
        }
        i = localRedTypeInfo.red_type.get();
        if (i != 0) {
          continue;
        }
        localJSONObject.put("redDotType", 1);
      }
      catch (Exception paramString)
      {
        int i;
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo;
        JSONObject localJSONObject;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("NearbyJsInterface", 2, "getNearbyRedDotInfo exp:" + paramString.toString());
        return;
        localJSONObject.put("redDotType", 0);
        continue;
      }
      callJs(paramString, new String[] { localJSONObject.toString() });
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("NearbyJsInterface", 2, "callJs: ret=" + localJSONObject);
      return;
      if (i == 5)
      {
        localJSONObject.put("redDotType", 2);
        localJSONObject.put("redDotNum", localRedTypeInfo.red_content.get());
      }
    }
  }
  
  public void getPerformance(String paramString)
  {
    if ((this.mRuntime.getActivity() != null) && ((this.mRuntime.getActivity() instanceof NearbyActivity))) {}
    Object localObject1;
    for (NearbyActivity localNearbyActivity = (NearbyActivity)this.mRuntime.getActivity();; localObject1 = null)
    {
      do
      {
        for (;;)
        {
          JSONObject localJSONObject;
          try
          {
            boolean bool = new JSONObject(paramString).getString("from").equals("now");
            if (!bool) {
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("NearbyJsInterface", 2, localJSONException, new Object[0]);
            }
            if (localNearbyActivity == null) {
              continue;
            }
            localJSONObject = new JSONObject();
          }
          try
          {
            localJSONObject.put("mClickTime", localNearbyActivity.Gp);
            localJSONObject.put("mOnCreateMilliTimeStamp", localNearbyActivity.Gq);
            Object localObject2 = localNearbyActivity.a();
            if (localObject2 != null)
            {
              localObject2 = ((NowLiveFragment)localObject2).a;
              localJSONObject.put("mTimeBeforeLoadUrl", ((aqyg)localObject2).getmTimeBeforeLoadUrl());
              localJSONObject.put("mStartLoadUrlMilliTimeStamp", ((aqyg)localObject2).mStartLoadUrlMilliTimeStamp);
              localJSONObject.put("mNowOnCreateTime", localNearbyActivity.Gr);
              localJSONObject.put("mNowViewInflateTime", localNearbyActivity.Gs);
              localJSONObject.put("mInitTime", localNearbyActivity.Gt);
              localJSONObject.put("mInitWebViewTime", localNearbyActivity.Gu);
              localJSONObject.put("isMainPageUseLocalFile", ((aqyg)localObject2).isMainPageUseLocalFile());
              localJSONObject.put("mPerfFirstLoadTag", ((aqyg)localObject2).ismPerfFirstLoadTag());
              localJSONObject.put("isWebViewCache", WebAccelerateHelper.isWebViewCache);
              localJSONObject.put("OpenUrlAfterCheckOfflineTime", ((aqyg)localObject2).getOpenUrlAfterCheckOfflineTime());
              localJSONObject.put("ReadIndexFromOfflineTime", ((aqyg)localObject2).getReadIndexFromOfflineTime());
              localJSONObject.put("IsReloadUrl", ((aqyg)localObject2).getIsReloadUrl());
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("NearbyJsInterface", 2, localException, new Object[0]);
              }
            }
          }
        }
        try
        {
          callJs(new JSONObject(paramString).getString("callback"), new String[] { localJSONObject.toString() });
          return;
        }
        catch (JSONException paramString) {}
      } while (!QLog.isColorLevel());
      QLog.e("NearbyJsInterface", 2, paramString, new Object[0]);
      return;
    }
  }
  
  public void getRedDotPushData(String paramString)
  {
    try
    {
      this.bSb = new JSONObject(paramString).optString("callback");
      paramString = new Intent();
      paramString.setAction("com.tencent.biz.TroopRedpoint.TroopRedTouchManager");
      paramString.putExtra("request_type", 1);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("NearbyJsInterface", 1, "getRedDotPushData failed " + paramString.getMessage());
    }
  }
  
  public void getSettingState(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("callback");
        localObject = ((JSONObject)localObject).optJSONArray("keys");
        JSONObject localJSONObject = new JSONObject();
        if ((localObject != null) && (i < ((JSONArray)localObject).length()))
        {
          String str = ((JSONArray)localObject).optString(i);
          if ("greetingsReceive".equals(str)) {
            localJSONObject.put(str, localSharedPreferences.getString("nearby_settings_greetings_receive", "0"));
          }
        }
        else
        {
          callJs(paramString, new String[] { localJSONObject.toString() });
          return;
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NearbyJsInterface", 2, "getSettingState failed! msg = " + paramString.getMessage());
        return;
      }
      i += 1;
    }
  }
  
  public void getSlidePosition(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "getSlidePosition: params=" + paramString);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mRuntime.getActivity() != null)
    {
      localObject1 = localObject2;
      if ((this.mRuntime.getActivity() instanceof NearbyActivity)) {
        localObject1 = (NearbyActivity)this.mRuntime.getActivity();
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((NearbyActivity)localObject1).a();
      if (localObject1 == null) {
        break label208;
      }
    }
    label208:
    for (int i = ((NearbyHybridFragment)localObject1).Fc();; i = 0) {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("position", i);
        if (QLog.isColorLevel()) {
          QLog.d("NearbyJsInterface", 2, "retJson=" + localObject1);
        }
        callJs(new JSONObject(paramString).optString("callback"), new String[] { ((JSONObject)localObject1).toString() });
        return;
      }
      catch (Exception paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("NearbyJsInterface", 2, "getSlidePosition exp:" + paramString.toString());
        return;
      }
    }
  }
  
  public void listenRedDotPushData(String paramString)
  {
    try
    {
      this.bSc = new JSONObject(paramString).optString("callback");
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("NearbyJsInterface", 1, "listenRedDotPushData failed " + paramString.getMessage());
    }
  }
  
  public void nearbySafetyReport(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyJsInterface", 2, "nearbySafetyReport params=" + paramString);
      }
      paramString = new JSONObject(paramString);
      str = paramString.optString("tinyId");
      l1 = 0L;
    }
    catch (Exception paramString)
    {
      String str;
      long l1;
      long l2;
      label65:
      int i;
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "nearbySafetyReport exp=" + paramString.toString());
      return;
    }
    try
    {
      l2 = Long.valueOf(str).longValue();
      l1 = l2;
    }
    catch (Exception localException)
    {
      break label65;
    }
    i = paramString.optInt("scene");
    str = paramString.optString("subapp");
    paramString = new aqep.a().a(paramString.optString("text_evidence")).b(paramString.optString("img_evidence")).d(paramString.optString("video_evidence")).c(paramString.optString("url_evidence")).e(paramString.optString("file_evidence")).f(paramString.optString("audio_evidence")).g(paramString.optString("user_input_param")).s();
    aqep.b((BaseActivity)this.mRuntime.getActivity(), l1, "0", null, i, str, paramString);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "onActivityResult, intent=" + paramIntent + ", requestCode=" + paramByte + ", resultCode=" + paramInt);
    }
    if ((paramByte == 100) && (!TextUtils.isEmpty(this.bSf)))
    {
      try
      {
        paramIntent = new JSONObject();
        if (paramInt == -1) {
          paramIntent.put("retcode", 0);
        }
        for (;;)
        {
          callJs(this.bSf, new String[] { paramIntent.toString() });
          if (QLog.isColorLevel()) {
            QLog.d("NearbyJsInterface", 2, "callJs, mBindPhoneCallback=" + this.bSf + ", ret=" + paramIntent);
          }
          this.bSf = "";
          return;
          paramIntent.put("retcode", 1);
        }
        QLog.e("NearbyJsInterface", 2, "onActivityResult, exp:" + paramIntent.toString());
      }
      catch (Exception paramIntent)
      {
        this.bSf = "";
        if (!QLog.isColorLevel()) {
          return;
        }
      }
    }
    else
    {
      Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
      paramIntent = ((SharedPreferences)localObject).getString("nearby_now_edit_profile_js_callback", "");
      paramInt = ((SharedPreferences)localObject).getInt("nearby_now_edit_profile_code_int", 1);
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("retcode", paramInt);
        callJs(paramIntent, new String[] { "" + localObject });
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
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.context = this.mRuntime.getActivity();
    IntentFilter localIntentFilter = new IntentFilter("tribe_profile_edit_finish");
    BaseApplicationImpl.getContext().registerReceiver(this.mBroadcastReceiver, localIntentFilter);
  }
  
  public void onDestroy()
  {
    if (this.mClient != null) {
      this.mClient.bzk();
    }
    if (this.mBroadcastReceiver != null) {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.mBroadcastReceiver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$b != null) {
      AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$b);
    }
    ayB();
    super.onDestroy();
  }
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 1)) {
      try
      {
        Object localObject = this.jdField_a_of_type_Aqcr.aF();
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
        StringBuilder localStringBuilder = new StringBuilder("data:image/jpeg;base64,");
        if (localObject != null)
        {
          ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
          localStringBuilder.append(aqgo.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
          localObject = new JSONObject();
          ((JSONObject)localObject).put("ret", 0);
          ((JSONObject)localObject).put("data", localStringBuilder);
          callJs(this.bSe, new String[] { ((JSONObject)localObject).toString() });
        }
        for (;;)
        {
          localByteArrayOutputStream.flush();
          localByteArrayOutputStream.close();
          return;
          callJs(this.bSe, new String[] { "{\"ret\":1}" });
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyJsInterface", 2, "getNearbyPeopleAvatar failed:" + localException);
        }
      }
    }
  }
  
  public void openBindPhonePage(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "openBindPhonePage:" + paramString);
    }
    try
    {
      this.bSf = new JSONObject(paramString).optString("callback");
      if (!TextUtils.isEmpty(this.bSf))
      {
        paramString = new Intent(this.mRuntime.getActivity(), BindNumberActivity.class);
        paramString.putExtra("kSrouce", 20);
        startActivityForResult(paramString, (byte)100);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "openBindPhonePage exp:" + paramString.toString());
    }
  }
  
  public void openFreshDetail(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("feedId");
      Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
      localIntent.putExtra("url", "https://nearby.qq.com/fresh/detail.html?feed_id=" + paramString);
      this.context.startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "openFreshDetail failed: msg = " + paramString.getMessage());
    }
  }
  
  public void openInterestPeopleAio(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("tinyid");
      this.mFrom = ((JSONObject)localObject).optInt("from");
      localObject = (a)this.lT.get(String.valueOf(paramString));
      if ((localObject != null) && (!TextUtils.isEmpty(((a)localObject).uin)) && (!((a)localObject).uin.equals("0")))
      {
        a((a)localObject);
        return;
      }
      if (this.mClient == null)
      {
        this.mClient = skj.a();
        this.mClient.bzj();
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramString);
      this.mClient.a((ArrayList)localObject, new ajqa(this));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void openMatchPeopleAio(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optString("tinyid");
      int i = paramString.optInt("isSuperLove");
      this.mFrom = paramString.optInt("from");
      getMatchPeople(str, i);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void openMyVisitorList()
  {
    Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://nearby.qq.com/nearby-visitor/index.html?_proxy=1&_wwv=128");
    this.context.startActivity(localIntent);
  }
  
  public void openProfileCard(String paramString)
  {
    NearbyAppInterface localNearbyAppInterface = (NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby");
    Object localObject1 = (acig)localNearbyAppInterface.getBusinessHandler(3);
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramString);
        localObject1 = ((JSONObject)localObject2).optString("uin");
        i = ((JSONObject)localObject2).optInt("mode", -1);
        j = ((JSONObject)localObject2).optInt("from");
        l = ((JSONObject)localObject2).optLong("now_id", 0L);
        k = ((JSONObject)localObject2).optInt("now_user_type", 0);
        localObject3 = ((JSONObject)localObject2).optString("callback");
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          this.bSd = ((String)localObject3);
        }
      }
      catch (Exception paramString)
      {
        Object localObject2;
        int i;
        int j;
        long l;
        int k;
        Object localObject3;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("NearbyJsInterface", 2, "openProfileCard failed! msg = " + paramString.getMessage());
        return;
        if (!(this.context instanceof Activity)) {
          continue;
        }
        ((Activity)this.context).startActivityForResult(new Intent(this.context, JumpActivity.class).setData(Uri.parse(paramString)), 32357);
        return;
        this.context.startActivity(new Intent(this.context, JumpActivity.class).setData(Uri.parse(paramString)));
        return;
        if (i == 1) {
          continue;
        }
        if ((j == 1) || (j == 7) || (j == 8) || (j == 9) || (j == 10) || (j == 12) || (j == 20)) {
          continue;
        }
        if ((j < 21) || (j > 28)) {
          continue;
        }
        continue;
      }
      try
      {
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("targetuin", new JSONObject(paramString).getString("targetuin"));
        paramString = affz.a("ipc_should_refresh_cardinfo", "", 0, (Bundle)localObject3);
        afjy.a().cq(paramString);
        localObject3 = ((JSONObject)localObject2).optString("tinnyid");
        paramString = new StringBuffer();
        if (j != 0) {
          paramString.append("&from=" + j);
        }
        if (i != -1) {
          paramString.append("&mode=" + i);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          paramString.append("&tinnyid=" + (String)localObject3);
        }
        localObject2 = ((JSONObject)localObject2).optString("reportsource");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramString.append("&reportsource=" + (String)localObject2);
        }
        paramString.append("&now_id=").append(l);
        paramString.append("&now_user_type=").append(k);
        paramString = "mqq://card/show_pslcard/?uin=" + (String)localObject1 + "&card_type=nearby" + paramString.toString();
        if (QLog.isColorLevel())
        {
          QLog.i("NearbyJsInterface", 2, "openProfileCard, jumpUrl=" + paramString);
          continue;
          l = Long.parseLong((String)localObject1);
          paramString = new ajqg(this, (String)localObject1, j);
          acig.a(localNearbyAppInterface, new long[] { l }, paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void openVideoChat(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        j = paramString.optInt("gender");
      }
      catch (Exception paramString)
      {
        int k;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyJsInterface", 2, "openVideoChat failed:" + paramString);
        return;
        return;
      }
      catch (JSONException paramString)
      {
        int i = 0;
        int j = 0;
        continue;
      }
      try
      {
        i = paramString.optInt("rank");
      }
      catch (JSONException paramString)
      {
        i = 0;
        continue;
      }
      try
      {
        k = paramString.optInt("age");
        paramString = skj.a();
        paramString.bzj();
        paramString.f(new ajqb(this, paramString, j, i, k));
        return;
      }
      catch (JSONException paramString)
      {
        continue;
      }
      QLog.e("NearbyJsInterface", 1, "openVideoChat web params error!");
      k = 0;
    }
  }
  
  public void preloadImage(String paramString)
  {
    ThreadManager.post(new NearbyJsInterface.7(this, paramString, System.currentTimeMillis()), 8, null, true);
  }
  
  public void preloadVideos(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("NearbyJsInterface", 2, "preloadVideos 已废弃, params=" + paramString);
    }
  }
  
  public void qbrowserNetworkChange(String paramString)
  {
    try
    {
      this.bSg = new JSONObject(paramString).optString("callback");
      iN(-1, jqc.getNetWorkType());
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$b == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$b = new b();
        AppNetConnInfo.registerNetChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$b);
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("NearbyJsInterface", 2, "qbrowserNetworkChange is called repeatedly");
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("NearbyJsInterface", 1, "qbrowserNetworkChange failed! msg = " + paramString.getMessage());
    }
  }
  
  public void reportFriend(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("uin");
      paramString = "mqq://nearby/reportFriend/?uin=" + paramString;
      this.context.startActivity(new Intent(this.context, JumpActivity.class).setData(Uri.parse(paramString)));
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("NearbyJsInterface", 2, "reportFriend exception:" + QLog.getStackTraceString(paramString));
    }
  }
  
  public void setDeleteShortVideoCallback(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit().putString("nearby_now_delete_success_js_callback", paramString).commit();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "setDeleteShortVideoCallback failed! msg = " + paramString.getMessage());
    }
  }
  
  public void setEditProfileCallback(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit().putString("nearby_now_edit_profile_js_callback", paramString).commit();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "setUpLoadVideoFinishedCallback failed! msg = " + paramString.getMessage());
    }
  }
  
  public void setLiveTabWebViewUrlParam(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "setLiveTabWebViewUrlParam:" + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localObject = ajrb.xz();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramString = paramString.toString();
          ajrb.MT(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("NearbyJsInterface", 2, "setLiveTabWebViewUrlParam:" + paramString);
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        try
        {
          Object localObject = ajrb.mergeJson(new JSONObject((String)localObject), paramString);
          paramString = (String)localObject;
        }
        catch (JSONException localJSONException) {}
        paramString = paramString;
        if (QLog.isColorLevel())
        {
          QLog.e("NearbyJsInterface", 2, "setLiveTabWebViewUrlParam exp:" + paramString.toString());
          return;
        }
      }
    }
  }
  
  public void setPublishButton(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit().putString("nearby_now_publish_click_js_callback", paramString).commit();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "setUpLoadVideoFinishedCallback failed! msg = " + paramString.getMessage());
    }
  }
  
  public void setSettingState(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit();
      paramString = new JSONObject(paramString);
      if ("greetingsReceive".equals(paramString.optString("key")))
      {
        localEditor.putString("nearby_settings_greetings_receive", paramString.optString("value"));
        if ("0".equals(paramString.optString("value")))
        {
          paramString = new Bundle();
          paramString.putBoolean("isOn", false);
          paramString = affz.a("ipc_cmd_nearby_setting_change", null, 0, paramString);
          afjy.a().cq(paramString);
        }
      }
      localEditor.apply();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "setSettingState failed! msg = " + paramString.getMessage());
    }
  }
  
  @TargetApi(23)
  public void setStatusBarTextDark(String paramString)
  {
    boolean bool2 = true;
    bool1 = true;
    int j = 0;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyJsInterface", 2, "setStatusBarTextDark: params=" + paramString);
        }
        localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("callback");
        i = ((JSONObject)localObject).optInt("darkMode");
        localObject = this.mRuntime.getActivity();
        if (!ImmersiveUtils.eB()) {
          continue;
        }
        localObject = ((Activity)localObject).getWindow();
        if (i != 1) {
          continue;
        }
        bool2 = ImmersiveUtils.a((Window)localObject, bool1);
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("NearbyJsInterface", 2, "setStatusBarDarkMode isSucced=" + bool2);
          bool1 = bool2;
        }
      }
      catch (Exception paramString)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyJsInterface", 2, "setStatusBarTextDark exp:" + paramString.toString());
        continue;
        int i = 0;
        continue;
        i = -1;
        continue;
        bool1 = false;
        continue;
      }
      localObject = new StringBuilder().append("{\"ret\":");
      if (!bool1) {
        continue;
      }
      i = j;
      callJs(paramString, new String[] { i + "}" });
      if (QLog.isColorLevel()) {
        QLog.d("NearbyJsInterface", 2, "isKITKAT=" + VersionUtils.isKITKAT() + ", enableForMiUI=" + ImmersiveUtils.iT + ", isMIUI=" + aqfo.isMIUI() + ", isFlyme=" + aqfo.isFlyme() + ", SDK_INT=" + Build.VERSION.SDK_INT);
      }
      return;
      bool1 = false;
      continue;
      if (Build.VERSION.SDK_INT < 23) {
        continue;
      }
      if (i != 1) {
        continue;
      }
      i = 9216;
      ((Activity)localObject).getWindow().getDecorView().setSystemUiVisibility(i);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("NearbyJsInterface", 2, "setStatusBarDarkMode setSystemUiVisibility");
        bool1 = bool2;
      }
    }
  }
  
  public void setUpLoadVideoFailedCallback(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit().putString("nearby_now_publish_failed_js_callback", paramString).commit();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "setUpLoadVideoFinishedCallback failed! msg = " + paramString.getMessage());
    }
  }
  
  public void setUpLoadVideoFinishedCallback(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit().putString("nearby_now_publish_success_js_callback", paramString).commit();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "setUpLoadVideoFinishedCallback failed! msg = " + paramString.getMessage());
    }
  }
  
  public void setUrlParam(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "setUrlParam:" + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localObject = ajrb.xy();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramString = paramString.toString();
          ajrb.MS(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("NearbyJsInterface", 2, "setNearbyTabUrlParams:" + paramString);
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        try
        {
          Object localObject = ajrb.mergeJson(new JSONObject((String)localObject), paramString);
          paramString = (String)localObject;
        }
        catch (JSONException localJSONException) {}
        paramString = paramString;
        if (QLog.isColorLevel())
        {
          QLog.e("NearbyJsInterface", 2, "setNearbyTabUrlParams exp:" + paramString.toString());
          return;
        }
      }
    }
  }
  
  public void setVideoEnterVisibility(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyJsInterface", 2, "setVideoEnterVisibility    step1:" + paramString);
    }
    String str = null;
    Object localObject = str;
    if (this.mRuntime.getActivity() != null)
    {
      localObject = str;
      if ((this.mRuntime.getActivity() instanceof NearbyActivity)) {
        localObject = (NearbyActivity)this.mRuntime.getActivity();
      }
    }
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyJsInterface", 2, "setVideoEnterVisibility    step2 activity not null");
      }
      localObject = ((NearbyActivity)localObject).a();
      if (localObject != null) {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyJsInterface", 2, "setVideoEnterVisibility    step3 fragment not null");
        }
      }
    }
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("visiable", 0);
      int j = paramString.optInt("faceScoreTalentState", 0);
      str = paramString.optString("jumpUrl");
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((NearbyHybridFragment)localObject).m(bool, j, str);
        if (QLog.isColorLevel()) {
          QLog.i("NearbyJsInterface", 2, "setVideoEnterVisibility    step4 set success");
        }
        paramString = paramString.optJSONArray("menu");
        if (paramString != null)
        {
          ajrb.c(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "key_nearby_publish_menu", paramString.toString());
          if (QLog.isColorLevel()) {
            QLog.d("NearbyJsInterface", 2, "menuItem=" + paramString);
          }
        }
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("NearbyJsInterface", 1, "setVideoEnterVisibility exception:" + paramString.toString());
    }
  }
  
  public void setViewChangeCallback(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit().putString("nearby_view_change_callback", paramString).commit();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "setViewChangeCallback failed! msg = " + paramString.getMessage());
    }
  }
  
  public void shootAvatar()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "shootAvatar");
    }
    NearbyAppInterface localNearbyAppInterface = (NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby");
    ajrm.b(this.mRuntime.getActivity(), localNearbyAppInterface, 1);
  }
  
  public void showFilterAndExitSheet()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "showFilterAndExitSheet");
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mRuntime.getActivity() != null)
    {
      localObject1 = localObject2;
      if ((this.mRuntime.getActivity() instanceof NearbyActivity)) {
        localObject1 = (NearbyActivity)this.mRuntime.getActivity();
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((NearbyActivity)localObject1).a();
      if (localObject1 != null) {
        ((NearbyHybridFragment)localObject1).showFilterAndExitSheet();
      }
    }
  }
  
  public void showGuideDownloadView(String paramString)
  {
    Object localObject;
    try
    {
      if (!(this.context instanceof Activity)) {
        return;
      }
      localObject = (Activity)this.context;
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      paramString = new JSONObject(paramString).optJSONObject("nearby_guide_config");
      if (paramString == null)
      {
        QLog.e("NearbyJsInterface", 1, "showGuideDownloadView: there is no nearby_guide_config");
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("NearbyJsInterface", 1, "showGuideDownloadView failed! msg = " + paramString.getMessage());
      return;
    }
    JSONObject localJSONObject = paramString.optJSONObject("alert_config");
    if (localJSONObject == null)
    {
      QLog.e("NearbyJsInterface", 1, "showGuideDownloadView: there is no alert_config");
      return;
    }
    paramString = ajoz.a((Context)localObject, localJSONObject);
    if (paramString != null)
    {
      paramString.d1 = (localJSONObject.optInt("source") + "");
      localObject = new akkm((Context)localObject);
      ((akkm)localObject).a(paramString);
      ((akkm)localObject).show();
    }
  }
  
  public void tribePersonalDataModify()
  {
    callJs("javascript:mqq.dispatchEvent(\"tribePersonalDataModify\")");
  }
  
  public void unlistenRedDotPushData(String paramString)
  {
    this.bSc = "";
  }
  
  public void updateFollowStatus(String paramString)
  {
    try
    {
      Bundle localBundle = new Bundle();
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("targetuin");
      localObject = ((JSONObject)localObject).optString("tinyid");
      if (!TextUtils.isEmpty(paramString)) {
        localBundle.putString("targetuin", paramString);
      }
      for (;;)
      {
        paramString = affz.a("ipc_should_refresh_cardinfo", "", 0, localBundle);
        afjy.a().cq(paramString);
        return;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localBundle.putString("tinyid", (String)localObject);
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static class a
  {
    public int dks;
    public String uin;
    
    public a(String paramString, int paramInt)
    {
      this.uin = paramString;
      this.dks = paramInt;
    }
  }
  
  class b
    implements INetEventHandler
  {
    private int As = -1;
    
    b() {}
    
    public void onNetChangeEvent(boolean paramBoolean)
    {
      int i = jqc.getNetWorkType();
      NearbyJsInterface.a(NearbyJsInterface.this, this.As, i);
      this.As = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface
 * JD-Core Version:    0.7.0.1
 */