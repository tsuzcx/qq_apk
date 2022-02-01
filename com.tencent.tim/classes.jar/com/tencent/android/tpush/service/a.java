package com.tencent.android.tpush.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.service.protocol.m;
import com.tencent.android.tpush.service.protocol.n;
import com.tencent.android.tpush.service.protocol.r;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.android.tpush.service.util.f;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.mqttchannel.api.MqttChannel;
import com.tencent.tpns.mqttchannel.api.MqttConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@JgClassChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.INTENTCHECK})
public class a
{
  private static a a = null;
  private static volatile a b = null;
  private static volatile c c = null;
  private static volatile d d = null;
  private volatile boolean e = false;
  private ArrayList<Intent> f = new ArrayList();
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent("com.tencent.android.xg.vip.action.QUERYTAGS.RESULT.V4");
    localIntent.putExtra("data", paramString2);
    localIntent.putExtra("operation", 0);
    if (!i.b(paramString1)) {
      localIntent.setPackage(paramString1);
    }
    BroadcastAgent.sendBroadcast(b.e(), localIntent);
    a(paramInt1, paramString1, paramString2, paramString3);
  }
  
  private void a(int paramInt, m paramm, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    paramString2 = f.a(paramInt, paramString2, 1);
    paramString2.putExtra("accId", paramm.a);
    if ((paramString1 != null) && (paramString1.length() != 0)) {
      paramString2.putExtra("token", paramString1);
    }
    if ((paramm.e != null) && (paramm.e.length() != 0))
    {
      paramString2.putExtra("ticket", paramm.e);
      paramString2.putExtra("ticketType", paramm.f);
    }
    if ((paramm.c != null) && (paramm.c.length() != 0)) {
      paramString2.putExtra("deviceId", paramm.c);
    }
    if (paramLong >= 0L)
    {
      paramString2.putExtra("otherPushType", paramLong);
      if (!i.b(paramString3)) {
        paramString2.putExtra("otherPushToken", paramString3);
      }
    }
    if (a(paramm)) {
      paramString2.putExtra("registerFromCloudControl", true);
    }
    BroadcastAgent.sendBroadcast(b.e(), paramString2);
  }
  
  private void a(int paramInt, n paramn, m paramm, String paramString, boolean paramBoolean)
  {
    Object localObject = new Intent("com.tencent.android.xg.vip.action.REGISTER.RESULT.V4");
    ((Intent)localObject).putExtra("accId", paramm.a);
    ((Intent)localObject).putExtra("data", paramn.b);
    ((Intent)localObject).putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
    ((Intent)localObject).putExtra("code", paramInt);
    ((Intent)localObject).putExtra("operation", 0);
    ((Intent)localObject).putExtra("otherPushType", paramn.d);
    ((Intent)localObject).putExtra("otherPushToken", paramn.e);
    RegisterEntity localRegisterEntity = new RegisterEntity();
    localRegisterEntity.accessId = paramm.a;
    localRegisterEntity.accessKey = paramm.b;
    localRegisterEntity.token = paramn.b;
    localRegisterEntity.channelId = paramm.s;
    localRegisterEntity.packageName = paramString;
    localRegisterEntity.timestamp = (System.currentTimeMillis() / 1000L);
    CacheManager.addRegisterInfo(localRegisterEntity);
    localRegisterEntity.guid = paramn.c;
    if (!i.b(paramString)) {
      ((Intent)localObject).setPackage(paramString);
    }
    BroadcastAgent.sendBroadcast(b.e(), (Intent)localObject);
    try
    {
      localObject = paramn.i;
      if (i.b((String)localObject)) {
        a(paramInt, paramm, paramn.b, paramString, paramn.d, paramn.e);
      }
      for (;;)
      {
        if (b.e() != null) {
          com.tencent.android.tpush.a.b(b.e());
        }
        return;
        a(paramInt, (String)localObject, paramn.j, paramString);
      }
    }
    catch (Throwable paramn)
    {
      for (;;)
      {
        TLogger.w("PushServiceBroadcastHandler", "unexpected for registerSuccessHandler");
      }
    }
  }
  
  private void a(int paramInt, r paramr, String paramString)
  {
    paramr = new Intent("com.tencent.android.xg.vip.action.UNREGISTER.RESULT.V4");
    paramr.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
    paramr.putExtra("operation", 0);
    CacheManager.UnregisterInfoSuccessByPkgName(paramString);
    CacheManager.removeRegisterInfos(paramString);
    if (!i.b(paramString)) {
      paramr.setPackage(paramString);
    }
    BroadcastAgent.sendBroadcast(b.e(), paramr);
    a(paramInt, paramString);
  }
  
  private void a(int paramInt, String paramString)
  {
    paramString = f.a(paramInt, paramString, 2);
    BroadcastAgent.sendBroadcast(b.e(), paramString);
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    JSONArray localJSONArray;
    JSONObject localJSONObject;
    if (!i.b(paramString1))
    {
      localJSONArray = new JSONArray();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("account", paramString1);
      localJSONObject.put("accountType", paramInt2);
      localJSONArray.put(localJSONObject);
      a(paramInt1, localJSONArray.toString(), paramString1, 0, paramString2);
      return;
    }
    catch (Throwable paramString1)
    {
      TLogger.ww("PushServiceBroadcastHandler", "getTypeAccountsJsonArrayStr:", paramString1);
    }
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    paramString2 = f.a(paramInt1, paramString2, 3);
    paramString2.putExtra("tagName", Rijndael.encrypt(paramString1));
    paramString2.putExtra("tagFlag", paramInt2);
    paramString2.putExtra("tagOperageName", paramString3);
    BroadcastAgent.sendBroadcast(b.e(), paramString2);
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent("com.tencent.android.xg.vip.action.ATTRIBUTE.RESULT.V4");
    localIntent.putExtra("flag", paramInt2);
    localIntent.putExtra("operation", 0);
    if (!i.b(paramString2)) {
      localIntent.setPackage(paramString2);
    }
    if (!i.b(paramString4)) {
      localIntent.putExtra("data", paramString4);
    }
    BroadcastAgent.sendBroadcast(b.e(), localIntent);
    b(paramInt1, paramString1, paramInt2, paramString2, paramString3);
  }
  
  private void a(int paramInt, String paramString1, m paramm, String paramString2)
  {
    Intent localIntent = new Intent("com.tencent.android.xg.vip.action.REGISTER.RESULT.V4");
    localIntent.putExtra("data", "");
    localIntent.putExtra("code", paramInt);
    localIntent.putExtra("msg", paramString1);
    localIntent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
    localIntent.putExtra("operation", 1);
    if (!i.b(paramString2)) {
      localIntent.setPackage(paramString2);
    }
    try
    {
      BroadcastAgent.sendBroadcast(b.e(), localIntent);
      if (paramm != null)
      {
        paramString1 = paramm.e;
        if (i.b(paramString1))
        {
          a(paramInt, paramm, GuidInfoManager.getToken(b.e()), paramString2, -1L, null);
          return;
        }
        a(paramInt, paramString1, paramm.f, paramString2);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      TLogger.w("PushServiceBroadcastHandler", "unexpected for registerFailHandler");
    }
  }
  
  private void a(int paramInt, String paramString1, r paramr, String paramString2)
  {
    TLogger.e("PushServiceBroadcastHandler", "unregisterFailHandler failed with (" + paramInt + "," + paramString1 + "," + paramr + "," + paramString2 + ")");
    paramr = new Intent("com.tencent.android.xg.vip.action.UNREGISTER.RESULT.V4");
    paramr.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
    paramr.putExtra("code", paramInt);
    paramr.putExtra("msg", paramString1);
    paramr.putExtra("operation", 1);
    if (!i.b(paramString2)) {
      paramr.setPackage(paramString2);
    }
    BroadcastAgent.sendBroadcast(b.e(), paramr);
    a(paramInt, paramString2);
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    paramString3 = f.a(paramInt1, paramString3, 6);
    paramString3.putExtra("accountName", Rijndael.encrypt(paramString1));
    paramString3.putExtra("accountFeedBack", paramString2);
    paramString3.putExtra("operateType", paramInt2);
    BroadcastAgent.sendBroadcast(b.e(), paramString3);
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    TLogger.e("PushServiceBroadcastHandler", "attributesFailHandler failed with (" + paramInt1 + "," + paramString1 + "," + paramString3 + ")");
    Intent localIntent = new Intent("com.tencent.android.xg.vip.action.ATTRIBUTE.RESULT.V4");
    localIntent.putExtra("flag", paramInt2);
    localIntent.putExtra("code", paramInt1);
    localIntent.putExtra("msg", paramString1);
    localIntent.putExtra("operation", 1);
    if (!i.b(paramString3)) {
      localIntent.setPackage(paramString3);
    }
    BroadcastAgent.sendBroadcast(b.e(), localIntent);
    b(paramInt1, paramString2, paramInt2, paramString3, paramString4);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = f.a(paramInt, paramString1, 8);
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.putExtra("data", Rijndael.encrypt(paramString2));
    }
    paramString1.putExtra("queryTagsName", paramString3);
    BroadcastAgent.sendBroadcast(b.e(), paramString1);
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4)
  {
    TLogger.e("PushServiceBroadcastHandler", "accountFailHandler failed with (" + paramInt1 + "," + paramString1 + "," + paramString4 + ")");
    Intent localIntent = new Intent("com.tencent.android.xg.vip.action.ACCOUNT.RESULT.V4");
    localIntent.putExtra("flag", paramInt2);
    localIntent.putExtra("code", paramInt1);
    localIntent.putExtra("msg", paramString1);
    localIntent.putExtra("operation", 1);
    if (!i.b(paramString4)) {
      localIntent.setPackage(paramString4);
    }
    BroadcastAgent.sendBroadcast(b.e(), localIntent);
    a(paramInt1, paramString2, paramString3, paramInt2, paramString4);
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getDataString();
    if ((paramIntent != null) && (paramContext != null) && (f.d(paramContext, paramIntent.substring(8))))
    {
      b.b().d();
      CommonWorkingThread.getInstance().execute(new a.1(this, paramContext), 2000L);
    }
  }
  
  private static boolean a(Object paramObject)
  {
    return false;
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    TLogger.e("PushServiceBroadcastHandler", "tagFailHandler failed with (" + paramInt1 + "," + paramString2 + "," + paramString1 + ")");
    Intent localIntent = new Intent("com.tencent.android.xg.vip.action.TAG.RESULT.V4");
    localIntent.putExtra("code", paramInt1);
    localIntent.putExtra("msg", paramString2);
    localIntent.putExtra("operation", 1);
    if (!i.b(paramString1)) {
      localIntent.setPackage(paramString1);
    }
    BroadcastAgent.sendBroadcast(b.e(), localIntent);
    a(paramInt1, paramString1, paramString2, paramString3);
  }
  
  private void b(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    paramString2 = f.a(paramInt1, paramString2, 7);
    paramString2.putExtra("attributesName", Rijndael.encrypt(paramString1));
    paramString2.putExtra("attributesFlag", paramInt2);
    paramString2.putExtra("attributesOperateName", paramString3);
    BroadcastAgent.sendBroadcast(b.e(), paramString2);
  }
  
  private void b(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    Intent localIntent = new Intent("com.tencent.android.xg.vip.action.ACCOUNT.RESULT.V4");
    localIntent.putExtra("flag", paramInt2);
    localIntent.putExtra("operation", 0);
    if (!i.b(paramString3)) {
      localIntent.setPackage(paramString3);
    }
    BroadcastAgent.sendBroadcast(b.e(), localIntent);
    a(paramInt1, paramString1, paramString2, paramInt2, paramString3);
  }
  
  private void b(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    TLogger.e("PushServiceBroadcastHandler", "tagFailHandler failed with (" + paramInt1 + "," + paramString1 + "," + paramString3 + ")");
    Intent localIntent = new Intent("com.tencent.android.xg.vip.action.TAG.RESULT.V4");
    localIntent.putExtra("flag", paramInt2);
    localIntent.putExtra("code", paramInt1);
    localIntent.putExtra("msg", paramString1);
    localIntent.putExtra("operation", 1);
    if (!i.b(paramString3)) {
      localIntent.setPackage(paramString3);
    }
    BroadcastAgent.sendBroadcast(b.e(), localIntent);
    a(paramInt1, paramString2, paramInt2, paramString3, paramString4);
  }
  
  private void b(Context paramContext, Intent paramIntent)
  {
    String str2;
    String str3;
    String str4;
    String str5;
    int i;
    String str1;
    String str6;
    String str7;
    long l1;
    String str8;
    String str9;
    String str10;
    long l2;
    long l3;
    boolean bool;
    String str11;
    String str12;
    long l4;
    if ((paramContext != null) && (paramIntent != null))
    {
      str2 = Rijndael.decrypt(paramIntent.getStringExtra("accId"));
      str3 = Rijndael.decrypt(paramIntent.getStringExtra("accKey"));
      str4 = Rijndael.decrypt(paramIntent.getStringExtra("packName"));
      str5 = Rijndael.decrypt(paramIntent.getStringExtra("ticket"));
      i = paramIntent.getIntExtra("ticketType", -1);
      str1 = Rijndael.decrypt(paramIntent.getStringExtra("qua"));
      str6 = paramIntent.getStringExtra("appVer");
      str7 = Rijndael.decrypt(paramIntent.getStringExtra("reserved"));
      TLogger.d("PushServiceBroadcastHandler", "receive intent, reserved: " + str7);
      l1 = paramIntent.getLongExtra("accChannel", -1L);
      str8 = paramIntent.getStringExtra("url");
      str9 = paramIntent.getStringExtra("otherToken");
      str10 = paramIntent.getStringExtra("payload");
      l2 = paramIntent.getLongExtra("otherPushType", -1L);
      l3 = paramIntent.getLongExtra("otherPushTokenOpType", -1L);
      bool = paramIntent.getBooleanExtra("aidl", false);
      str11 = paramIntent.getStringExtra("channelToken");
      str12 = paramIntent.getStringExtra("channelType");
      l4 = CloudManager.getInstance(paramContext).getCloudVersion();
    }
    try
    {
      if (!i.b(str1)) {
        CacheManager.setQua(paramContext, Long.parseLong(str2), str1);
      }
      paramIntent = "";
    }
    catch (Throwable paramContext)
    {
      label258:
      TLogger.e("PushServiceBroadcastHandler", ">> register error " + paramContext);
      TLogger.e("PushServiceBroadcastHandler", ">> register error-> " + TLogger.getStackTraceString(paramContext));
      return;
    }
    try
    {
      str1 = TpnsSecurity.getEncryptAPKSignature(paramContext.createPackageContext(str4, 0));
      paramIntent = str1;
    }
    catch (Throwable localThrowable)
    {
      break label258;
    }
    c.a().a(Long.parseLong(str2), str3, com.tencent.android.tpush.service.util.a.a(), str5, i, paramIntent, str6, str7, l2, str8, str10, str9, l3, l1, str11, str12, l4, new a.3(this, paramContext, str2, str4, bool));
  }
  
  private void c(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent("com.tencent.android.xg.vip.action.TAG.RESULT.V4");
    localIntent.putExtra("flag", paramInt2);
    localIntent.putExtra("operation", 0);
    if (!i.b(paramString2)) {
      localIntent.setPackage(paramString2);
    }
    BroadcastAgent.sendBroadcast(b.e(), localIntent);
    a(paramInt1, paramString1, paramInt2, paramString2, paramString3);
  }
  
  private void c(Context paramContext, Intent paramIntent)
  {
    long l;
    int i;
    String str1;
    String str2;
    if ((paramContext != null) && (paramIntent != null))
    {
      l = paramIntent.getLongExtra("accId", -1L);
      paramContext = Rijndael.decrypt(paramIntent.getStringExtra("accKey"));
      i = paramIntent.getIntExtra("operateType", -1);
      str1 = Rijndael.decrypt(paramIntent.getStringExtra("account"));
      str2 = paramIntent.getStringExtra("accountFeedBack");
      paramIntent = Rijndael.decrypt(paramIntent.getStringExtra("packName"));
    }
    try
    {
      c.a().a(l, paramContext, str1, i, new a.4(this, l, paramIntent, str1, str2, i));
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("PushServiceBroadcastHandler", ">> AccountHandler error " + paramContext);
      TLogger.e("PushServiceBroadcastHandler", ">> AccountHandler error-> " + TLogger.getStackTraceString(paramContext));
    }
  }
  
  private void d(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {
      return;
    }
    long l = paramIntent.getLongExtra("accId", -1L);
    paramContext = Rijndael.decrypt(paramIntent.getStringExtra("accKey"));
    String str1 = Rijndael.decrypt(paramIntent.getStringExtra("packName"));
    int i = paramIntent.getIntExtra("attributesFlag", -1);
    String str2 = Rijndael.decrypt(paramIntent.getStringExtra("attributesName"));
    paramIntent = paramIntent.getStringExtra("attributesOperateName");
    try
    {
      c.a().b(l, paramContext, str1, i, str2, new a.5(this, l, i, str2, str1, paramIntent));
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("PushServiceBroadcastHandler", ">> attributes Handler error " + paramContext);
    }
  }
  
  private void e(Context paramContext, Intent paramIntent)
  {
    long l;
    String str1;
    int i;
    int j;
    String str2;
    if ((paramContext != null) && (paramIntent != null))
    {
      l = paramIntent.getLongExtra("accId", -1L);
      paramContext = Rijndael.decrypt(paramIntent.getStringExtra("accKey"));
      str1 = Rijndael.decrypt(paramIntent.getStringExtra("packName"));
      i = paramIntent.getIntExtra("offset", -1);
      j = paramIntent.getIntExtra("limit", -1);
      str2 = paramIntent.getStringExtra("tagType");
      paramIntent = paramIntent.getStringExtra("queryTagsName");
    }
    try
    {
      c.a().a(l, paramContext, str1, i, j, str2, new a.6(this, l, i, j, str1, paramIntent, str2));
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("PushServiceBroadcastHandler", ">> QueryTagsHandler error " + paramContext);
      TLogger.e("PushServiceBroadcastHandler", ">> QueryTagsHandler error-> " + TLogger.getStackTraceString(paramContext));
    }
  }
  
  private void f(Context paramContext, Intent paramIntent)
  {
    long l;
    String str1;
    int i;
    String str2;
    if ((paramContext != null) && (paramIntent != null))
    {
      l = paramIntent.getLongExtra("accId", -1L);
      paramContext = Rijndael.decrypt(paramIntent.getStringExtra("accKey"));
      str1 = Rijndael.decrypt(paramIntent.getStringExtra("packName"));
      i = paramIntent.getIntExtra("tagFlag", -1);
      str2 = Rijndael.decrypt(paramIntent.getStringExtra("tagName"));
      paramIntent = paramIntent.getStringExtra("tagOperageName");
    }
    try
    {
      c.a().a(l, paramContext, str1, i, str2, new a.7(this, l, i, str2, str1, paramIntent));
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("PushServiceBroadcastHandler", ">> TagHandler error " + paramContext);
      TLogger.e("PushServiceBroadcastHandler", ">> TagHandler error-> " + TLogger.getStackTraceString(paramContext));
    }
  }
  
  private void g(Context paramContext, Intent paramIntent)
  {
    String str1;
    String str2;
    if ((paramContext != null) && (paramIntent != null))
    {
      paramContext = Rijndael.decrypt(paramIntent.getStringExtra("accId"));
      str1 = Rijndael.decrypt(paramIntent.getStringExtra("accKey"));
      str2 = Rijndael.decrypt(paramIntent.getStringExtra("packName"));
      paramIntent = Rijndael.decrypt(paramIntent.getStringExtra("token"));
      CacheManager.UnregisterInfoByPkgName(str2);
    }
    try
    {
      c.a().a(paramIntent, com.tencent.android.tpush.service.util.a.a(), Long.parseLong(paramContext), str1, str2, new a.8(this, paramContext, str2));
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("PushServiceBroadcastHandler", ">>> unregister error " + paramContext);
    }
  }
  
  private void h(Context paramContext, Intent paramIntent)
  {
    String str1;
    String str2;
    String str3;
    String str4;
    if ((paramContext != null) && (paramIntent != null))
    {
      str1 = Rijndael.decrypt(paramIntent.getStringExtra("accId"));
      str2 = Rijndael.decrypt(paramIntent.getStringExtra("accKey"));
      str3 = Rijndael.decrypt(paramIntent.getStringExtra("token"));
      str4 = Rijndael.decrypt(paramIntent.getStringExtra("other_push_type"));
      paramIntent = Rijndael.decrypt(paramIntent.getStringExtra("other_push_token"));
      TLogger.i("PushServiceBroadcastHandler", "binder OtherPush token with accid = " + str1 + "  token = " + str3 + " otherPushType = " + str4 + " otherPushToken = " + paramIntent);
      String str5 = SharePrefsUtil.getString(paramContext, str1 + "otherpush", "");
      if (i.b(str5)) {
        break label311;
      }
      long l = SharePrefsUtil.getLong(paramContext, str1 + "otherpush" + "ts", -1L);
      if ((str5.equals(str3 + ":" + paramIntent)) && (Math.abs(System.currentTimeMillis() - l) < 86400000L)) {
        TLogger.ii("PushServiceBroadcastHandler", "Already binder OtherPush succeed token with accid = " + str1 + "  token = " + str3 + " otherPushType = " + str4 + " otherPushToken = " + paramIntent);
      }
    }
    else
    {
      return;
    }
    TLogger.ii("PushServiceBroadcastHandler", "OtherToken or Mid changed , go on binder");
    label311:
    c.a().a(Long.parseLong(str1), str2, str4, paramIntent, new a.9(this, str1, str3, str4, paramIntent, paramContext));
  }
  
  private void i(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null))
    {
      String str1 = Rijndael.decrypt(paramIntent.getStringExtra("accessId"));
      String str2 = paramIntent.getStringExtra("pkgName");
      c.a().a(paramIntent, new a.2(this, str1, paramContext, str2, paramIntent));
    }
  }
  
  private void j(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramContext != null))
    {
      int i = paramIntent.getIntExtra("interval", -1);
      if ((i >= 10) && (i < 36000)) {
        MqttConfig.setKeepAliveInterval(paramContext, i);
      }
    }
  }
  
  private void k(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramContext != null))
    {
      boolean bool = paramIntent.getBooleanExtra("debugMode", false);
      com.tencent.android.tpush.XGPushConfig.enableDebug = bool;
      TLogger.enableDebug(paramContext, bool);
    }
  }
  
  /* Error */
  public void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 242
    //   4: new 331	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 731
    //   14: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: getfield 58	com/tencent/android/tpush/service/a:f	Ljava/util/ArrayList;
    //   21: invokevirtual 734	java/util/ArrayList:size	()I
    //   24: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 681	com/tencent/android/tpush/logging/TLogger:ii	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: iconst_1
    //   35: putfield 53	com/tencent/android/tpush/service/a:e	Z
    //   38: new 63	android/content/Intent
    //   41: dup
    //   42: ldc_w 736
    //   45: invokespecial 68	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   48: astore_2
    //   49: aload_2
    //   50: ldc_w 738
    //   53: invokestatic 93	com/tencent/android/tpush/service/b:e	()Landroid/content/Context;
    //   56: invokevirtual 741	android/content/Context:getPackageName	()Ljava/lang/String;
    //   59: invokevirtual 74	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   62: pop
    //   63: aload_2
    //   64: ldc_w 743
    //   67: ldc_w 745
    //   70: invokevirtual 74	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   73: pop
    //   74: invokestatic 93	com/tencent/android/tpush/service/b:e	()Landroid/content/Context;
    //   77: aload_2
    //   78: invokestatic 99	com/tencent/android/tpush/common/BroadcastAgent:sendBroadcast	(Landroid/content/Context;Landroid/content/Intent;)V
    //   81: aload_0
    //   82: getfield 58	com/tencent/android/tpush/service/a:f	Ljava/util/ArrayList;
    //   85: invokevirtual 749	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   88: astore_2
    //   89: aload_2
    //   90: invokeinterface 755 1 0
    //   95: ifeq +82 -> 177
    //   98: aload_2
    //   99: invokeinterface 759 1 0
    //   104: checkcast 63	android/content/Intent
    //   107: astore_3
    //   108: ldc 242
    //   110: new 331	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 761
    //   120: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_0
    //   124: getfield 58	com/tencent/android/tpush/service/a:f	Ljava/util/ArrayList;
    //   127: invokevirtual 734	java/util/ArrayList:size	()I
    //   130: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 681	com/tencent/android/tpush/logging/TLogger:ii	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: invokestatic 394	com/tencent/tpns/baseapi/base/util/CommonWorkingThread:getInstance	()Lcom/tencent/tpns/baseapi/base/util/CommonWorkingThread;
    //   142: new 9	com/tencent/android/tpush/service/a$b
    //   145: dup
    //   146: aload_0
    //   147: aload_1
    //   148: aload_3
    //   149: invokespecial 763	com/tencent/android/tpush/service/a$b:<init>	(Lcom/tencent/android/tpush/service/a;Landroid/content/Context;Landroid/content/Intent;)V
    //   152: invokevirtual 766	com/tencent/tpns/baseapi/base/util/CommonWorkingThread:execute	(Ljava/lang/Runnable;)Z
    //   155: pop
    //   156: goto -67 -> 89
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    //   164: astore_2
    //   165: ldc 242
    //   167: ldc_w 767
    //   170: aload_2
    //   171: invokestatic 769	com/tencent/android/tpush/logging/TLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -93 -> 81
    //   177: aload_0
    //   178: getfield 58	com/tencent/android/tpush/service/a:f	Ljava/util/ArrayList;
    //   181: invokevirtual 772	java/util/ArrayList:clear	()V
    //   184: aload_0
    //   185: monitorexit
    //   186: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	a
    //   0	187	1	paramContext	Context
    //   48	51	2	localObject	Object
    //   164	7	2	localThrowable	Throwable
    //   107	42	3	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   2	38	159	finally
    //   38	81	159	finally
    //   81	89	159	finally
    //   89	156	159	finally
    //   165	174	159	finally
    //   177	184	159	finally
    //   38	81	164	java/lang/Throwable
  }
  
  /* Error */
  public void b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 242
    //   4: ldc_w 774
    //   7: invokestatic 476	com/tencent/android/tpush/logging/TLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +548 -> 559
    //   14: getstatic 43	com/tencent/android/tpush/service/a:b	Lcom/tencent/android/tpush/service/a$a;
    //   17: ifnonnull +59 -> 76
    //   20: new 6	com/tencent/android/tpush/service/a$a
    //   23: dup
    //   24: aload_0
    //   25: aconst_null
    //   26: invokespecial 777	com/tencent/android/tpush/service/a$a:<init>	(Lcom/tencent/android/tpush/service/a;Lcom/tencent/android/tpush/service/a$1;)V
    //   29: putstatic 43	com/tencent/android/tpush/service/a:b	Lcom/tencent/android/tpush/service/a$a;
    //   32: new 779	android/content/IntentFilter
    //   35: dup
    //   36: invokespecial 780	android/content/IntentFilter:<init>	()V
    //   39: astore_2
    //   40: aload_2
    //   41: ldc_w 782
    //   44: invokevirtual 785	android/content/IntentFilter:addDataScheme	(Ljava/lang/String;)V
    //   47: aload_2
    //   48: ldc_w 787
    //   51: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   54: aload_2
    //   55: ldc_w 792
    //   58: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   61: aload_2
    //   62: ldc_w 794
    //   65: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   68: aload_1
    //   69: getstatic 43	com/tencent/android/tpush/service/a:b	Lcom/tencent/android/tpush/service/a$a;
    //   72: aload_2
    //   73: invokestatic 798	com/tencent/android/tpush/common/BroadcastAgent:registerReceiver	(Landroid/content/Context;Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V
    //   76: getstatic 45	com/tencent/android/tpush/service/a:c	Lcom/tencent/android/tpush/service/a$c;
    //   79: ifnonnull +386 -> 465
    //   82: new 12	com/tencent/android/tpush/service/a$c
    //   85: dup
    //   86: aload_0
    //   87: aconst_null
    //   88: invokespecial 799	com/tencent/android/tpush/service/a$c:<init>	(Lcom/tencent/android/tpush/service/a;Lcom/tencent/android/tpush/service/a$1;)V
    //   91: putstatic 45	com/tencent/android/tpush/service/a:c	Lcom/tencent/android/tpush/service/a$c;
    //   94: new 779	android/content/IntentFilter
    //   97: dup
    //   98: invokespecial 780	android/content/IntentFilter:<init>	()V
    //   101: astore_2
    //   102: aload_1
    //   103: invokevirtual 741	android/content/Context:getPackageName	()Ljava/lang/String;
    //   106: astore_3
    //   107: aload_2
    //   108: new 331	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   115: aload_3
    //   116: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc_w 801
    //   122: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   131: aload_2
    //   132: new 331	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   139: aload_3
    //   140: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 803
    //   146: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   155: aload_2
    //   156: new 331	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   163: aload_3
    //   164: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc_w 805
    //   170: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   179: aload_2
    //   180: new 331	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   187: aload_3
    //   188: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 807
    //   194: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   203: aload_2
    //   204: new 331	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   211: aload_3
    //   212: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc_w 809
    //   218: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   227: aload_2
    //   228: new 331	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   235: aload_3
    //   236: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc_w 811
    //   242: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   251: aload_2
    //   252: new 331	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   259: aload_3
    //   260: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc_w 813
    //   266: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   275: aload_2
    //   276: new 331	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   283: aload_3
    //   284: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 815
    //   290: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   299: aload_2
    //   300: ldc_w 817
    //   303: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   306: aload_2
    //   307: ldc_w 819
    //   310: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   313: aload_2
    //   314: new 331	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   321: aload_3
    //   322: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 821
    //   328: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   337: aload_2
    //   338: new 331	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   345: aload_3
    //   346: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: ldc_w 823
    //   352: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   361: aload_2
    //   362: new 331	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   369: aload_3
    //   370: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: ldc_w 825
    //   376: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   385: aload_2
    //   386: new 331	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   393: aload_3
    //   394: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc_w 827
    //   400: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   409: aload_2
    //   410: new 331	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   417: aload_3
    //   418: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: ldc_w 829
    //   424: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   433: aload_2
    //   434: new 331	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   441: aload_3
    //   442: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc_w 831
    //   448: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   457: aload_1
    //   458: getstatic 45	com/tencent/android/tpush/service/a:c	Lcom/tencent/android/tpush/service/a$c;
    //   461: aload_2
    //   462: invokestatic 798	com/tencent/android/tpush/common/BroadcastAgent:registerReceiver	(Landroid/content/Context;Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V
    //   465: getstatic 47	com/tencent/android/tpush/service/a:d	Lcom/tencent/android/tpush/service/a$d;
    //   468: ifnonnull +91 -> 559
    //   471: new 15	com/tencent/android/tpush/service/a$d
    //   474: dup
    //   475: aload_0
    //   476: aconst_null
    //   477: invokespecial 832	com/tencent/android/tpush/service/a$d:<init>	(Lcom/tencent/android/tpush/service/a;Lcom/tencent/android/tpush/service/a$1;)V
    //   480: putstatic 47	com/tencent/android/tpush/service/a:d	Lcom/tencent/android/tpush/service/a$d;
    //   483: new 779	android/content/IntentFilter
    //   486: dup
    //   487: invokespecial 780	android/content/IntentFilter:<init>	()V
    //   490: astore_2
    //   491: aload_2
    //   492: ldc_w 834
    //   495: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   498: aload_2
    //   499: ldc_w 836
    //   502: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   505: aload_2
    //   506: ldc_w 838
    //   509: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   512: aload_2
    //   513: ldc_w 840
    //   516: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   519: aload_2
    //   520: ldc_w 787
    //   523: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   526: aload_2
    //   527: ldc_w 792
    //   530: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   533: aload_2
    //   534: ldc_w 794
    //   537: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   540: aload_2
    //   541: ldc_w 842
    //   544: invokevirtual 790	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   547: aload_1
    //   548: invokevirtual 845	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   551: getstatic 47	com/tencent/android/tpush/service/a:d	Lcom/tencent/android/tpush/service/a$d;
    //   554: aload_2
    //   555: invokevirtual 848	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   558: pop
    //   559: aload_0
    //   560: monitorexit
    //   561: return
    //   562: astore_2
    //   563: ldc 242
    //   565: ldc_w 849
    //   568: aload_2
    //   569: invokestatic 769	com/tencent/android/tpush/logging/TLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   572: goto -496 -> 76
    //   575: astore_1
    //   576: aload_0
    //   577: monitorexit
    //   578: aload_1
    //   579: athrow
    //   580: astore_2
    //   581: ldc 242
    //   583: ldc_w 849
    //   586: aload_2
    //   587: invokestatic 769	com/tencent/android/tpush/logging/TLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   590: goto -125 -> 465
    //   593: astore_1
    //   594: ldc 242
    //   596: ldc_w 851
    //   599: aload_1
    //   600: invokestatic 769	com/tencent/android/tpush/logging/TLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   603: goto -44 -> 559
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	this	a
    //   0	606	1	paramContext	Context
    //   39	516	2	localIntentFilter	android.content.IntentFilter
    //   562	7	2	localThrowable1	Throwable
    //   580	7	2	localThrowable2	Throwable
    //   106	336	3	str	String
    // Exception table:
    //   from	to	target	type
    //   14	76	562	java/lang/Throwable
    //   2	10	575	finally
    //   14	76	575	finally
    //   76	465	575	finally
    //   465	559	575	finally
    //   563	572	575	finally
    //   581	590	575	finally
    //   594	603	575	finally
    //   76	465	580	java/lang/Throwable
    //   465	559	593	java/lang/Throwable
  }
  
  public void c(Context paramContext)
  {
    try
    {
      this.f.clear();
      if (paramContext != null)
      {
        if (b != null)
        {
          i.a(paramContext, b);
          b = null;
        }
        if (c != null)
        {
          i.a(paramContext, c);
          c = null;
        }
        if (d != null)
        {
          i.a(paramContext, d);
          d = null;
        }
      }
      return;
    }
    finally {}
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      TLogger.d("PushServiceBroadcastHandler", "PackageChangesReceiver - onReceiver");
      if ((paramIntent != null) && (paramContext != null))
      {
        if (a.a(a.this)) {
          CommonWorkingThread.getInstance().execute(new a.b(a.this, paramContext, paramIntent));
        }
      }
      else {
        return;
      }
      if (a.b(a.this).size() < 10)
      {
        a.b(a.this).add(paramIntent);
        TLogger.ii("PushServiceBroadcastHandler", "PackageChangesReceiver add intend to beforeInitedIntents,action:" + paramIntent.getAction() + ", size:" + a.b(a.this).size());
        return;
      }
      TLogger.ee("PushServiceBroadcastHandler", "Too much beforeInitedIntents. discard it");
    }
  }
  
  @JgClassChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.INTENTCHECK})
  class b
    implements Runnable
  {
    private Context b = null;
    private Intent c = null;
    
    b(Context paramContext, Intent paramIntent)
    {
      this.b = paramContext;
      this.c = paramIntent;
    }
    
    public void run()
    {
      try
      {
        String str = this.c.getAction();
        if (str == null) {
          return;
        }
        str = str.replace(this.b.getPackageName(), "");
        TLogger.d("PushServiceBroadcastHandler", "PushServiceRannable, intent action:" + str);
        if (("android.intent.action.PACKAGE_ADDED".equals(str)) || ("android.intent.action.PACKAGE_REPLACED".equals(str)))
        {
          a.a(a.this, this.b, this.c);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        TLogger.e("PushServiceBroadcastHandler", "PushServiceBroadcastHandler run error.", localThrowable);
        return;
      }
      if (!"android.intent.action.PACKAGE_REMOVED".equals(localThrowable))
      {
        if ("com.tencent.android.xg.vip.action.REGISTER.V4".equals(localThrowable))
        {
          a.b(a.this, this.b, this.c);
          return;
        }
        if ("com.tencent.android.xg.vip.action.UNREGISTER.V4".equals(localThrowable))
        {
          a.c(a.this, this.b, this.c);
          return;
        }
        if ("com.tencent.android.xg.vip.action.ENABLE_DEBUG.V4".equals(localThrowable))
        {
          a.d(a.this, this.b, this.c);
          return;
        }
        if ("com.tencent.android.xg.vip.action.SET_HTINTERVALMS.V4".equals(localThrowable))
        {
          a.e(a.this, this.b, this.c);
          return;
        }
        if (!"com.tencent.android.xg.vip.action.MSG_ACK.V4".equals(localThrowable))
        {
          if ("com.tencent.android.xg.vip.action.ACCOUNT.V4".equals(localThrowable))
          {
            a.f(a.this, this.b, this.c);
            return;
          }
          if ("com.tencent.android.xg.vip.action.TAG.V4".equals(localThrowable))
          {
            a.g(a.this, this.b, this.c);
            return;
          }
          if ("com.tencent.android.xg.vip.action.QUERYTAGS.V4".equals(localThrowable))
          {
            a.h(a.this, this.b, this.c);
            return;
          }
          if ((!"com.tencent.android.xg.vip.action.PUSH_CLICK.RESULT.V4".equals(localThrowable)) && (!"com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4".equals(localThrowable)) && (!"com.tencent.android.xg.vip.action.ack.sdk2srv.V4".equals(localThrowable)))
          {
            if ("com.tencent.android.xg.vip.action.UPDATE_OTHER_PUSH_TOKEN.V4".equals(localThrowable))
            {
              a.i(a.this, this.b, this.c);
              return;
            }
            if ("com.tencent.android.xg.vip.action.COMM_REPORT.V4".equals(localThrowable))
            {
              a.j(a.this, this.b, this.c);
              return;
            }
            NetworkInfo localNetworkInfo;
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(localThrowable))
            {
              localNetworkInfo = (NetworkInfo)this.c.getParcelableExtra("networkInfo");
              if (localNetworkInfo != null)
              {
                TLogger.d("PushServiceBroadcastHandler", "Connection state changed to --- " + localNetworkInfo.toString());
                if (!this.c.getBooleanExtra("noConnectivity", false))
                {
                  if (NetworkInfo.State.CONNECTED == localNetworkInfo.getState())
                  {
                    TLogger.v("PushServiceBroadcastHandler", "network connected and start XGService 3s later");
                    b.a(this.b, 3000L);
                    return;
                  }
                  if (NetworkInfo.State.DISCONNECTED == localNetworkInfo.getState())
                  {
                    TLogger.v("PushServiceBroadcastHandler", "Network is disconnected.");
                    MqttChannel.getInstance(this.b).stopConnect(null);
                    return;
                  }
                  TLogger.v("PushServiceBroadcastHandler", "other network state - " + localNetworkInfo.getState() + ". Do nothing.");
                }
              }
            }
            else
            {
              if ("com.tencent.android.xg.vip.action.FLUSH.V4".equals(localNetworkInfo))
              {
                TBaseLogger.flush(new a.b.1(this));
                return;
              }
              if ("com.tencent.android.xg.vip.action.ATTRIBUTE.V4".equals(localNetworkInfo)) {
                a.k(a.this, this.b, this.c);
              }
            }
          }
        }
      }
    }
  }
  
  class c
    extends BroadcastReceiver
  {
    private c() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      TLogger.d("PushServiceBroadcastHandler", "TPushAppReceiver - onReceiver");
      if ((paramIntent != null) && (paramContext != null))
      {
        if (a.a(a.this)) {
          CommonWorkingThread.getInstance().execute(new a.b(a.this, paramContext, paramIntent));
        }
      }
      else {
        return;
      }
      if (a.b(a.this).size() < 10)
      {
        a.b(a.this).add(paramIntent);
        TLogger.ii("PushServiceBroadcastHandler", "TPushAppReceiver add intend to beforeInitedIntents,action:" + paramIntent.getAction() + ", size:" + a.b(a.this).size());
        return;
      }
      TLogger.ee("PushServiceBroadcastHandler", "Too much beforeInitedIntents. discard it");
    }
  }
  
  class d
    extends BroadcastReceiver
  {
    long a = 0L;
    
    private d() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      NetworkInfo localNetworkInfo;
      if ((paramIntent != null) && (paramContext != null))
      {
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
          break label168;
        }
        localNetworkInfo = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
        if (localNetworkInfo != null) {
          break label35;
        }
      }
      label35:
      label168:
      do
      {
        do
        {
          return;
          TLogger.v("PushServiceBroadcastHandler", "Connection state changed to - " + localNetworkInfo.toString());
        } while (paramIntent.getBooleanExtra("noConnectivity", false));
        if (NetworkInfo.State.CONNECTED == localNetworkInfo.getState())
        {
          TLogger.v("PushServiceBroadcastHandler", "Internl network connected and call MqttChannel.startConnect on 5s later");
          CommonWorkingThread.getInstance().execute(new a.d.1(this, paramContext), 5000L);
          return;
        }
        if (NetworkInfo.State.DISCONNECTED == localNetworkInfo.getState())
        {
          TLogger.v("PushServiceBroadcastHandler", "Network is disconnected.");
          MqttChannel.getInstance(paramContext).stopConnect(null);
          return;
        }
        TLogger.v("PushServiceBroadcastHandler", "other network state - " + localNetworkInfo.getState() + ". Do nothing.");
        return;
        TLogger.d("PushServiceBroadcastHandler", "--UserPresentReceiver--");
      } while (Math.abs(System.currentTimeMillis() - this.a) <= 8000L);
      CommonWorkingThread.getInstance().execute(new a.d.2(this, paramContext), 2000L);
      this.a = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.a
 * JD-Core Version:    0.7.0.1
 */