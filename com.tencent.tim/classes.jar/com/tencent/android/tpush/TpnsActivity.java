package com.tencent.android.tpush;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ResolveInfo.DisplayNameComparator;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Md5;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@JgClassChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.ACTIVITYCHECK, com.jg.EType.INTENTCHECK, com.jg.EType.INTENTSCHEMECHECK})
public class TpnsActivity
  extends Activity
{
  public static final String CHECK_CODE = "checkCode";
  public static final String CUSTOM_CONTENT = "customContent";
  public static final String JUMP_type = "jumpType";
  public static final String MSG_TYPE = "msgType";
  public static final String TARGE_ACTIVITY = "targetActivity";
  public static final String TIMESTAMP = "timestamp";
  static Application.ActivityLifecycleCallbacks a = null;
  static List<String> b = null;
  static String c = "";
  static long d = 0L;
  static long e = 0L;
  private String f = "";
  private int g = 100;
  
  private static String a(Context paramContext)
  {
    try
    {
      Object localObject = new Intent("android.intent.action.MAIN", null);
      ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
      ((Intent)localObject).setPackage(paramContext.getPackageName());
      paramContext = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0).iterator();
      while (paramContext.hasNext())
      {
        localObject = (ResolveInfo)paramContext.next();
        if (((ResolveInfo)localObject).activityInfo != null)
        {
          paramContext = ((ResolveInfo)localObject).activityInfo.name;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.e("TpnsActivity", "get Activity error", paramContext);
    }
    return null;
  }
  
  private void a()
  {
    Intent localIntent = new Intent();
    if ((this.f == null) || (TextUtils.isEmpty(this.f))) {
      this.f = a(this);
    }
    TLogger.i("TpnsActivity", "TpnsActivity receiver  jumpOtherChannelActivity targetActivity = " + this.f);
    localIntent.setClassName(getApplicationContext(), this.f);
    localIntent.setFlags(603979776);
    localIntent.putExtra("pushChannel", this.g);
    try
    {
      startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      TLogger.ii("TpnsActivity", "TpnsActivity receiver ActivityNotFoundException = " + localActivityNotFoundException);
    }
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (paramInt == 0)
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
      localBuilder.setOnCancelListener(new TpnsActivity.7(this, paramIntent)).setTitle("提示").setMessage("是否确定打开此应用？").setPositiveButton("打开", new TpnsActivity.6(this, paramIntent)).setNegativeButton("取消", new TpnsActivity.5(this, paramIntent));
      localBuilder.create().show();
    }
  }
  
  static void a(Application paramApplication)
  {
    if (a == null)
    {
      a = new TpnsActivity.4();
      if (paramApplication == null) {}
    }
    try
    {
      ((Application)paramApplication.getApplicationContext()).registerActivityLifecycleCallbacks(a);
      return;
    }
    catch (Throwable paramApplication) {}
  }
  
  private void a(Uri paramUri)
  {
    for (;;)
    {
      try
      {
        String str1 = paramUri.getQueryParameter("jumpType");
        Object localObject = paramUri.getQueryParameter("busiMsgId");
        String str2 = paramUri.getQueryParameter("msgId");
        String str7 = paramUri.getQueryParameter("msgType");
        String str8 = paramUri.getQueryParameter("groupId");
        String str3 = paramUri.getQueryParameter("pushChannel");
        String str9 = paramUri.getQueryParameter("targetType");
        String str10 = paramUri.getQueryParameter("pushTime");
        String str11 = paramUri.getQueryParameter("source");
        String str12 = paramUri.getQueryParameter("timestamp");
        String str4 = paramUri.getQueryParameter("customContent");
        String str5 = paramUri.getQueryParameter("targetActivity");
        String str6 = paramUri.getQueryParameter("tmpl");
        paramUri = paramUri.getQueryParameter("trace");
        Intent localIntent = new Intent();
        if (localObject != null)
        {
          l = Long.valueOf((String)localObject).longValue();
          localIntent.putExtra("busiMsgId", l);
          if (str2 == null) {
            break label775;
          }
          l = Long.valueOf(str2).longValue();
          localIntent.putExtra("msgId", l);
          if (str7 == null) {
            break label780;
          }
          l = Long.valueOf(str7).longValue();
          localIntent.putExtra("type", l);
          localIntent.putExtra("groupId", str8);
          if (str3 == null) {
            break label785;
          }
          i = Integer.valueOf(str3).intValue();
          localIntent.putExtra("pushChannel", i);
          if (str9 == null) {
            break label790;
          }
          l = Long.valueOf(str9).longValue();
          localIntent.putExtra("targetType", l);
          if (str10 == null) {
            break label795;
          }
          l = Long.valueOf(str10).longValue() * 1000L;
          localIntent.putExtra("pushTime", l);
          if (str11 == null) {
            break label800;
          }
          l = Long.valueOf(str11).longValue();
          localIntent.putExtra("source", l);
          if (str12 == null) {
            break label805;
          }
          l = Long.valueOf(str12).longValue() * 1000L;
          localIntent.putExtra("timestamps", l);
          localIntent.putExtra("templateId", str6);
          localIntent.putExtra("traceId", paramUri);
          g(localIntent);
          TLogger.i("TpnsActivity", "TpnsActivity receiver params : msgBuildId " + (String)localObject + " , msgId = " + str2 + " , jumpType = " + str1 + " , msgType = " + str7 + " , groupId = " + str8 + " , pushChannel = " + str3 + " , targetType = " + str9 + " , pushTime = " + str10 + " , source = " + str11 + " , timestamp = " + str12 + " , templateId = " + str6 + " , traceId = " + paramUri);
          localObject = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
          ((Intent)localObject).setPackage(getApplicationContext().getPackageName());
          ((Intent)localObject).putExtra("TPUSH.FEEDBACK", 4);
          ((Intent)localObject).putExtra("TPUSH.ERRORCODE", 0);
          if (str3 == null) {
            break label810;
          }
          i = Integer.valueOf(str3).intValue();
          ((Intent)localObject).putExtra("PUSH.CHANNEL", i);
          ((Intent)localObject).putExtra("action", NotificationAction.clicked.getType());
          if (str1 != null)
          {
            i = Integer.valueOf(str1).intValue();
            ((Intent)localObject).putExtra("notificationActionType", i);
            ((Intent)localObject).putExtra("custom_content", str4);
            if (str2 == null) {
              break label815;
            }
            l = Long.valueOf(str2).longValue();
            ((Intent)localObject).putExtra("msgId", l);
            ((Intent)localObject).putExtra("templateId", str6);
            ((Intent)localObject).putExtra("traceId", paramUri);
            if ((str5 != null) && (!TextUtils.isEmpty(str5)))
            {
              ((Intent)localObject).putExtra("activity", str5);
              BroadcastAgent.sendBroadcast(getApplicationContext(), (Intent)localObject);
            }
          }
          else
          {
            i = NotificationAction.activity.getType();
            continue;
          }
          this.f = a(this);
          ((Intent)localObject).putExtra("activity", this.f);
          continue;
        }
        l = 0L;
      }
      catch (Throwable paramUri)
      {
        TLogger.ii("TpnsActivity", "TpnsActivity reportOtherChannelDeepLink exception:" + paramUri);
        return;
      }
      continue;
      label775:
      long l = 0L;
      continue;
      label780:
      l = 1L;
      continue;
      label785:
      int i = 0;
      continue;
      label790:
      l = 0L;
      continue;
      label795:
      l = 0L;
      continue;
      label800:
      l = 0L;
      continue;
      label805:
      l = 0L;
      continue;
      label810:
      i = 0;
      continue;
      label815:
      l = 0L;
    }
  }
  
  private void a(Bundle paramBundle, XGPushClickedResult paramXGPushClickedResult)
  {
    for (;;)
    {
      try
      {
        Object localObject = paramBundle.getString("groupId");
        String str4 = paramBundle.getString("ts");
        String str5 = paramBundle.getString("targetType");
        String str6 = paramBundle.getString("busiMsgId");
        String str1 = paramBundle.getString("msgId");
        String str7 = paramBundle.getString("pushTime");
        String str8 = paramBundle.getString("source");
        String str9 = paramBundle.getString("type");
        String str2 = paramBundle.getString("pushChannel");
        String str3 = paramBundle.getString("templateId");
        paramBundle = paramBundle.getString("traceId");
        Intent localIntent = new Intent();
        if (str6 != null)
        {
          l = Long.valueOf(e).longValue();
          localIntent.putExtra("busiMsgId", l);
          if (str1 == null) {
            break label631;
          }
          l = Long.valueOf(str1).longValue();
          localIntent.putExtra("msgId", l);
          if (str9 == null) {
            break label637;
          }
          l = Long.valueOf(str9).longValue();
          localIntent.putExtra("type", l);
          localIntent.putExtra("groupId", (String)localObject);
          if (str2 == null) {
            break label643;
          }
          i = Integer.valueOf(str2).intValue();
          localIntent.putExtra("pushChannel", i);
          if (str5 == null) {
            break label649;
          }
          l = Long.valueOf(str5).longValue();
          localIntent.putExtra("targetType", l);
          if (str7 == null) {
            break label655;
          }
          l = Long.valueOf(str7).longValue() * 1000L;
          localIntent.putExtra("pushTime", l);
          if (str8 == null) {
            break label661;
          }
          l = Long.valueOf(str8).longValue();
          localIntent.putExtra("source", l);
          if (str4 == null) {
            break label667;
          }
          l = Long.valueOf(str4).longValue() * 1000L;
          localIntent.putExtra("timestamps", l);
          localIntent.putExtra("templateId", str3);
          localIntent.putExtra("traceId", paramBundle);
          g(localIntent);
          localObject = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
          ((Intent)localObject).setPackage(getApplicationContext().getPackageName());
          ((Intent)localObject).putExtra("TPUSH.FEEDBACK", 4);
          ((Intent)localObject).putExtra("TPUSH.ERRORCODE", 0);
          if (str2 == null) {
            break label673;
          }
          i = Integer.valueOf(str2).intValue();
          ((Intent)localObject).putExtra("PUSH.CHANNEL", i);
          ((Intent)localObject).putExtra("action", NotificationAction.clicked.getType());
          if (paramXGPushClickedResult.notificationActionType != 0)
          {
            i = paramXGPushClickedResult.notificationActionType;
            ((Intent)localObject).putExtra("notificationActionType", i);
            ((Intent)localObject).putExtra("custom_content", paramXGPushClickedResult.customContent);
            if (str1 == null) {
              break label679;
            }
            l = Long.valueOf(str1).longValue();
            ((Intent)localObject).putExtra("msgId", l);
            ((Intent)localObject).putExtra("templateId", str3);
            ((Intent)localObject).putExtra("traceId", paramBundle);
            if ((paramXGPushClickedResult.activityName != null) && (!TextUtils.isEmpty(paramXGPushClickedResult.activityName)))
            {
              ((Intent)localObject).putExtra("activity", paramXGPushClickedResult.activityName);
              BroadcastAgent.sendBroadcast(getApplicationContext(), (Intent)localObject);
            }
          }
          else
          {
            i = NotificationAction.activity.getType();
            continue;
          }
          this.f = a(this);
          ((Intent)localObject).putExtra("activity", this.f);
          continue;
        }
        l = 0L;
      }
      catch (Throwable paramBundle)
      {
        TLogger.ii("TpnsActivity", "TpnsActivity reportAndFeekbackFcmChannelDeepLink e:" + paramBundle);
        return;
      }
      continue;
      label631:
      long l = 0L;
      continue;
      label637:
      l = 1L;
      continue;
      label643:
      int i = 101;
      continue;
      label649:
      l = 0L;
      continue;
      label655:
      l = 0L;
      continue;
      label661:
      l = 0L;
      continue;
      label667:
      l = 0L;
      continue;
      label673:
      i = 101;
      continue;
      label679:
      l = 0L;
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      TLogger.i("TpnsActivity", "TpnsActivity receiver  jumpOtherChannelActivitys targetActivity = " + paramString);
      localIntent.setClassName(getApplicationContext(), paramString);
      localIntent.putExtra("pushChannel", this.g);
      localIntent.setFlags(603979776);
      startActivity(localIntent);
      return;
    }
    catch (Throwable paramString)
    {
      TLogger.ii("TpnsActivity", "TpnsActivity receiver jumpOtherChannelActivitys = " + paramString);
    }
  }
  
  private void a(String paramString, Intent paramIntent)
  {
    try
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.setFlags(268435456);
      paramString.putExtra("pushChannel", this.g);
      XGPushManager.a(this);
      startActivity(paramString);
      finish();
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        TLogger.e("TpnsActivity", "openUrl error.", paramString);
      }
    }
  }
  
  private boolean a(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.hasExtra("protect"))
      {
        paramIntent = paramIntent.getStringExtra("protect");
        bool1 = bool2;
        if (!i.b(paramIntent)) {
          paramIntent = Rijndael.decrypt(paramIntent);
        }
      }
    }
    try
    {
      paramIntent = Long.valueOf(paramIntent);
      bool1 = bool2;
      if (paramIntent.longValue() > 0L)
      {
        long l1 = System.currentTimeMillis();
        long l2 = paramIntent.longValue();
        bool1 = bool2;
        if (l1 >= l2) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (NumberFormatException paramIntent) {}
    return false;
  }
  
  public static void addActivityNames(String paramString)
  {
    if (i.b(paramString)) {}
    do
    {
      return;
      if (b == null) {
        b = new ArrayList();
      }
    } while (b.contains(paramString));
    b.add(paramString);
  }
  
  private void b(int paramInt, Intent paramIntent)
  {
    if (paramInt == 0)
    {
      str = paramIntent.getStringExtra("activity");
      if (paramIntent.getIntExtra("action_confirm", 0) == 1) {
        new AlertDialog.Builder(this).setTitle("提示").setCancelable(false).setMessage("是否打开网站:" + str + "?").setPositiveButton("确认", new TpnsActivity.9(this, str, paramIntent)).setNegativeButton("取消", new TpnsActivity.8(this, paramIntent)).show();
      }
    }
    while (paramInt != 1)
    {
      String str;
      return;
      a(str, paramIntent);
      return;
    }
    if (paramIntent.getIntExtra("action_confirm", 0) == 1)
    {
      new AlertDialog.Builder(this).setTitle("提示").setCancelable(false).setMessage("继续打开Intent?").setPositiveButton("确认", new TpnsActivity.2(this, paramIntent)).setNegativeButton("取消", new TpnsActivity.10(this, paramIntent)).show();
      return;
    }
    f(paramIntent);
  }
  
  private void b(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null) {
      finish();
    }
    String str = paramIntent.getStringExtra("checkCode");
    paramIntent = Md5.md5(paramIntent.getStringExtra("msgId"));
    if ((paramIntent != null) && (str.equals(paramIntent)))
    {
      paramIntent = localBundle.getString("content");
      TLogger.ii("TpnsActivity", "fcmChannelDeepLink content ：" + paramIntent);
      if ((paramIntent == null) || (TextUtils.isEmpty(paramIntent))) {}
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramIntent);
        localObject1 = ((JSONObject)localObject2).optJSONObject("action");
        i = ((JSONObject)localObject1).optInt("action_type", 0);
        paramIntent = ((JSONObject)localObject1).optString("activity");
        str = ((JSONObject)localObject1).optJSONObject("browser").optString("url");
        localObject1 = ((JSONObject)localObject1).optString("intent");
        localObject2 = ((JSONObject)localObject2).optString("custom_content");
        localXGPushClickedResult = new XGPushClickedResult();
        switch (i)
        {
        }
      }
      catch (Throwable paramIntent)
      {
        Object localObject2;
        Object localObject1;
        int i;
        XGPushClickedResult localXGPushClickedResult;
        TLogger.ii("TpnsActivity", "TpnsActivity fcmChannelDeepLink e:" + paramIntent);
        continue;
        localXGPushClickedResult.activityName = paramIntent;
        a();
        continue;
        if ((str == null) || (TextUtils.isEmpty(str))) {
          continue;
        }
        localXGPushClickedResult.activityName = str;
        b(str);
        continue;
        if ((localObject1 == null) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          continue;
        }
        localXGPushClickedResult.activityName = ((String)localObject1);
        c((String)localObject1);
        continue;
      }
      localXGPushClickedResult.notificationActionType = i;
      localXGPushClickedResult.customContent = ((String)localObject2);
      CommonWorkingThread.getInstance().execute(new TpnsActivity.1(this, localBundle, localXGPushClickedResult));
      finish();
      return;
      if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent)))
      {
        localXGPushClickedResult.activityName = paramIntent;
        a(paramIntent);
      }
      else
      {
        finish();
      }
    }
  }
  
  private void b(String paramString)
  {
    try
    {
      TLogger.i("TpnsActivity", "TpnsActivity receiver jumpOtherChannelUrl targetActivity :" + paramString);
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.setFlags(268435456);
      paramString.putExtra("pushChannel", this.g);
      startActivity(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      TLogger.e("TpnsActivity", "openUrl error.", paramString);
    }
  }
  
  private void c(Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        paramIntent = paramIntent.getData();
        if (paramIntent != null)
        {
          str1 = paramIntent.toString();
          TLogger.ii("TpnsActivity", "TpnsActivity receiver otherChannelDeepLink url:" + str1);
          str2 = paramIntent.getQueryParameter("msgId");
          str1 = paramIntent.getQueryParameter("checkCode");
          String str3 = paramIntent.getQueryParameter("pushChannel");
          if (!TextUtils.isEmpty(str3)) {
            this.g = Integer.parseInt(str3);
          }
          if ((str2 != null) && (!TextUtils.isEmpty(str2)) && (str1 != null) && (!TextUtils.isEmpty(str1)))
          {
            str2 = Md5.md5(str2);
            if ((str2 != null) && (str1.equals(str2)))
            {
              str1 = paramIntent.getQueryParameter("jumpType");
              str2 = paramIntent.getQueryParameter("targetActivity");
              if ((str1 != null) && (str2 != null) && (!TextUtils.isEmpty(str2))) {
                continue;
              }
              TLogger.i("TpnsActivity", "TpnsActivity receiver jumpType == null || targetIntent == null");
              a();
              CommonWorkingThread.getInstance().execute(new TpnsActivity.3(this, paramIntent));
            }
          }
        }
        finish();
        return;
        if ((str2 == null) || (str2.length() <= 0)) {
          continue;
        }
        if ((str1 != null) && (str1.equals("0")))
        {
          a();
          continue;
        }
        if (str1 == null) {
          break label269;
        }
      }
      catch (Throwable paramIntent)
      {
        TLogger.ii("TpnsActivity", "TpnsActivity receiver e:" + paramIntent);
        finish();
        return;
      }
      if (str1.equals("1")) {
        a(str2);
      } else {
        label269:
        if ((str1 != null) && (str1.equals("2"))) {
          b(str2);
        } else if ((str1 != null) && (str1.equals("3"))) {
          c(str2);
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      TLogger.i("TpnsActivity", "TpnsActivity receiver jumpOtherChannelIntent targetActivity:" + paramString);
      paramString = Uri.parse(paramString);
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(paramString);
      localIntent.putExtra("pushChannel", this.g);
      if (localIntent.resolveActivity(getPackageManager()) != null) {
        startActivity(localIntent);
      }
      return;
    }
    catch (Throwable paramString)
    {
      TLogger.e("TpnsActivity", "jumpOtherChannelIntent error.", paramString);
    }
  }
  
  private ResolveInfo d(String paramString)
  {
    try
    {
      Object localObject1 = getPackageManager();
      Object localObject2 = new Intent("android.intent.action.MAIN", null);
      ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
      localObject2 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0);
      Collections.sort((List)localObject2, new ResolveInfo.DisplayNameComparator((PackageManager)localObject1));
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResolveInfo)((Iterator)localObject1).next();
        String str = ((ResolveInfo)localObject2).activityInfo.name;
        boolean bool = ((ResolveInfo)localObject2).activityInfo.packageName.equals(paramString);
        if (bool) {
          return localObject2;
        }
      }
    }
    catch (Throwable paramString)
    {
      TLogger.e("TpnsActivity", "查找主Activity出错", paramString);
    }
    return null;
  }
  
  private void d(Intent paramIntent)
  {
    String str = null;
    if (paramIntent != null)
    {
      if (paramIntent.getStringExtra("activity") == null) {
        break label189;
      }
      str = paramIntent.getStringExtra("activity");
    }
    for (;;)
    {
      if (XGPushConfig.enableDebug) {
        TLogger.i("TpnsActivity", "activity intent =" + paramIntent + "activity = " + str + "intent.getFlags()" + paramIntent.getFlags());
      }
      d = paramIntent.getLongExtra("msgId", 0L);
      e = paramIntent.getLongExtra("busiMsgId", 0L);
      c = str;
      Intent localIntent = new Intent();
      if (paramIntent != null)
      {
        localIntent.addFlags(paramIntent.getFlags());
        localIntent.setClassName(getApplicationContext(), str);
        paramIntent.putExtra("tag.tpush.MSG", "true");
        localIntent.putExtras(paramIntent);
      }
      localIntent.addFlags(536870912);
      localIntent.putExtra("tag.tpush.NOTIFIC", XGPushManager.a(this));
      try
      {
        a(getApplication());
        startActivity(localIntent);
        label184:
        finish();
        return;
        label189:
        str = "";
      }
      catch (ActivityNotFoundException paramIntent)
      {
        break label184;
      }
    }
  }
  
  private void e(Intent paramIntent)
  {
    g(paramIntent);
    Object localObject = d(paramIntent.getStringExtra("packageName"));
    if (localObject != null)
    {
      String str = ((ResolveInfo)localObject).activityInfo.name;
      localObject = ((ResolveInfo)localObject).activityInfo.packageName;
      Intent localIntent = new Intent();
      localIntent.putExtras(paramIntent);
      localIntent.setComponent(new ComponentName((String)localObject, str));
      a(0, localIntent);
      return;
    }
    a(1, paramIntent);
  }
  
  private void f(Intent paramIntent)
  {
    try
    {
      Intent localIntent = new Intent();
      int i = paramIntent.getIntExtra("action_type", NotificationAction.intent.getType());
      if (i == NotificationAction.intent.getType())
      {
        this.g = paramIntent.getIntExtra("PUSH.CHANNEL", 100);
        if ((this.g == 101) || (this.g == 99))
        {
          paramIntent = Uri.parse(URLDecoder.decode(paramIntent.getStringExtra("activity"), "UTF-8"));
          localIntent.setAction("android.intent.action.VIEW");
          localIntent.setData(paramIntent);
        }
      }
      for (;;)
      {
        localIntent.putExtra("pushChannel", this.g);
        XGPushManager.a(this);
        if (localIntent.resolveActivity(getPackageManager()) != null) {
          startActivity(localIntent);
        }
        finish();
        return;
        paramIntent = Uri.parse(paramIntent.getStringExtra("activity"));
        break;
        if (i == NotificationAction.intent_with_action.getType())
        {
          localIntent.setAction(paramIntent.getStringExtra("activity"));
          localIntent.setPackage(getPackageName());
          localIntent.setFlags(268435456);
        }
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      TLogger.e("TpnsActivity", "openIntent error.", paramIntent);
    }
  }
  
  private void g(Intent paramIntent)
  {
    XGPushManager.a(getApplicationContext(), paramIntent);
  }
  
  public static long getMsgIdWithIntent(Intent paramIntent)
  {
    long l2;
    if (paramIntent == null)
    {
      l2 = 0L;
      return l2;
    }
    for (;;)
    {
      try
      {
        Object localObject = paramIntent.getExtras();
        if (localObject != null)
        {
          localObject = ((Bundle)localObject).get("msgId");
          if (localObject != null)
          {
            if ((localObject instanceof String))
            {
              l1 = Long.parseLong((String)localObject);
              l2 = l1;
              if (l1 != 0L) {
                break;
              }
              paramIntent = paramIntent.getData();
              l2 = l1;
              if (paramIntent == null) {
                break;
              }
              paramIntent = paramIntent.getQueryParameter("msgId");
              l2 = l1;
              if (i.b(paramIntent)) {
                break;
              }
              return Long.parseLong(paramIntent);
            }
            if ((localObject instanceof Long))
            {
              l1 = ((Long)localObject).longValue();
              continue;
            }
          }
        }
        long l1 = 0L;
      }
      catch (Throwable paramIntent)
      {
        return 0L;
      }
    }
  }
  
  public static boolean isMonitorActivityNames(String paramString)
  {
    if (b == null) {}
    while ((i.b(paramString)) || (!b.contains(paramString))) {
      return false;
    }
    return true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      paramBundle = getIntent();
      TLogger.i("TpnsActivity", "TpnsActivity receiver intent:" + paramBundle);
      if ((paramBundle != null) && (paramBundle.getExtras() != null))
      {
        Object localObject = paramBundle.getExtras();
        if ((((Bundle)localObject).containsKey("pushChannel")) && ((((Bundle)localObject).get("pushChannel") instanceof String)))
        {
          localObject = ((Bundle)localObject).getString("pushChannel");
          if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
          {
            this.g = Integer.valueOf((String)localObject).intValue();
            if (this.g == 101) {
              b(paramBundle);
            }
          }
        }
      }
      if (a(paramBundle))
      {
        this.g = paramBundle.getIntExtra("pushChannel", 100);
        i = paramBundle.getIntExtra("action_type", NotificationAction.activity.getType());
        if (i == NotificationAction.activity.getType())
        {
          d(paramBundle);
          return;
        }
        if (i == NotificationAction.action_package.getType())
        {
          e(paramBundle);
          return;
        }
      }
    }
    catch (Throwable paramBundle)
    {
      int i;
      TLogger.ww("TpnsActivity", "warning", paramBundle);
      try
      {
        finish();
        return;
      }
      catch (Throwable paramBundle)
      {
        return;
      }
      if (i == NotificationAction.url.getType())
      {
        b(0, paramBundle);
        return;
      }
      if ((i == NotificationAction.intent.getType()) || (i == NotificationAction.intent_with_action.getType()))
      {
        b(1, paramBundle);
        return;
      }
      finish();
      return;
    }
    c(paramBundle);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.TpnsActivity
 * JD-Core Version:    0.7.0.1
 */