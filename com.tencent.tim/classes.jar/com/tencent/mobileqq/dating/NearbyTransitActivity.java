package com.tencent.mobileqq.dating;

import acfv;
import acgf;
import afck;
import afcx;
import ajrk;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import anot;
import aqgw;
import aqiw;
import arib;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;
import wja;

public class NearbyTransitActivity
  extends BaseActivity
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, Handler.Callback
{
  private static long Xj;
  public static final String aGn = acfv.bon;
  public arib a;
  private MqqHandler b;
  private String bCZ;
  private String bDa;
  private boolean bXq = true;
  protected int cQc;
  private int cQk;
  private int cQl;
  private acgf d = new afcx(this);
  long ie;
  private int mAction;
  private boolean mDestroy;
  private int mExtraFlag;
  private String mFrom;
  
  public static void a(Context paramContext, String paramString, int paramInt, HashMap<String, String> paramHashMap)
  {
    ev("openNearbyTransitActivity", 0);
    long l = Math.abs(System.currentTimeMillis() - Xj);
    if ((paramContext == null) || ((l >= 0L) && (l < 800L)) || (paramHashMap == null)) {
      return;
    }
    Xj = System.currentTimeMillis();
    String str1;
    String str2;
    label89:
    String str3;
    label109:
    String str4;
    label129:
    String str5;
    label149:
    String str6;
    label169:
    String str7;
    if (paramHashMap.containsKey("src_type"))
    {
      str1 = (String)paramHashMap.get("src_type");
      if (!paramHashMap.containsKey("from_type")) {
        break label342;
      }
      str2 = (String)paramHashMap.get("from_type");
      if (!paramHashMap.containsKey("from")) {
        break label349;
      }
      str3 = (String)paramHashMap.get("from");
      if (!paramHashMap.containsKey("version")) {
        break label356;
      }
      str4 = (String)paramHashMap.get("version");
      if (!paramHashMap.containsKey("onwall")) {
        break label363;
      }
      str5 = (String)paramHashMap.get("onwall");
      if (!paramHashMap.containsKey("nonelbs")) {
        break label370;
      }
      str6 = (String)paramHashMap.get("nonelbs");
      if (!paramHashMap.containsKey("fissile")) {
        break label377;
      }
      str7 = (String)paramHashMap.get("fissile");
      label189:
      if (!paramHashMap.containsKey("newly_created")) {
        break label384;
      }
    }
    label384:
    for (paramHashMap = (String)paramHashMap.get("newly_created");; paramHashMap = "")
    {
      Intent localIntent = new Intent(paramContext, NearbyTransitActivity.class);
      localIntent.putExtra("src_type", str1);
      localIntent.putExtra("from_type", str2);
      localIntent.putExtra("from", str3);
      localIntent.putExtra("version", str4);
      localIntent.putExtra("action", paramInt);
      localIntent.putExtra("hotnamecode", paramString);
      localIntent.putExtra("newly_created", paramHashMap);
      localIntent.putExtra("onwall", str5);
      localIntent.putExtra("nonelbs", str6);
      localIntent.putExtra("fissile", str7);
      localIntent.putExtra("enter_time", System.currentTimeMillis());
      paramContext.startActivity(localIntent);
      return;
      str1 = "";
      break;
      label342:
      str2 = "";
      break label89;
      label349:
      str3 = "";
      break label109;
      label356:
      str4 = "";
      break label129;
      label363:
      str5 = "";
      break label149;
      label370:
      str6 = "";
      break label169;
      label377:
      str7 = "";
      break label189;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      ajrk.f("NearbyTransitActivity", "reportResult", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    }
    ThreadManager.getSubThreadHandler().post(new NearbyTransitActivity.4(paramInt, paramString, paramBoolean, paramLong));
  }
  
  private boolean a(HotChatInfo paramHotChatInfo)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(60)).a();
    anot.a(this.app, "CliOper", "", "", "0X8004412", "0X8004412", 1, 0, "", "", "", "");
    if (localHotChatInfo == null)
    {
      c(paramHotChatInfo);
      return true;
    }
    if (TextUtils.equals(paramHotChatInfo.uuid, localHotChatInfo.uuid))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTransitActivity", 2, "enter poi hotchat start aio, has joined");
      }
      aF(paramHotChatInfo.troopUin, paramHotChatInfo.troopCode, paramHotChatInfo.name);
      return true;
    }
    c(paramHotChatInfo);
    return true;
  }
  
  private void aF(String paramString1, String paramString2, String paramString3)
  {
    ev("enterAIO", 1);
    if (this.cQk > 0)
    {
      localIntent = wja.a(new Intent(this, SplashActivity.class), null);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("troop_uin", paramString2);
      localIntent.putExtra("uinname", paramString3);
      paramString1 = localIntent;
      startActivity(paramString1);
      long l = System.currentTimeMillis() - this.ie;
      if (l > 0L) {
        a(this.app.getCurrentAccountUin(), true, l, 0);
      }
      finish();
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("troop_uin", paramString2);
    localIntent.putExtra("uinname", paramString3);
    localIntent.addFlags(67108864);
    localIntent.putExtra("is_from_web", true);
    localIntent.putExtra("is_new_add", true);
    paramString1 = getIntent().getStringExtra("newly_created");
    if ((paramString1 != null) && ("1".equals(paramString1))) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("param_newly_created_hot_chat", bool);
      localIntent.putExtra("hotnamecode", getIntent().getStringExtra("hotnamecode"));
      localIntent.putExtra("HOTCHAT_EXTRA_FLAG", this.mExtraFlag);
      if ("10002".equals(this.mFrom))
      {
        localIntent.putExtra("abp_flag", true);
        localIntent.addFlags(268435456);
      }
      paramString1 = localIntent;
      break;
    }
  }
  
  public static void bv(Context paramContext, String paramString)
  {
    ev("openNearbyTransitActivity", 0);
    long l = Math.abs(System.currentTimeMillis() - Xj);
    if ((paramContext == null) || ((l >= 0L) && (l < 800L))) {
      return;
    }
    Xj = System.currentTimeMillis();
    Intent localIntent = new Intent(paramContext, NearbyTransitActivity.class);
    localIntent.putExtra("from", "10002");
    localIntent.putExtra("action", 2);
    localIntent.putExtra("params", paramString);
    localIntent.putExtra("enter_time", System.currentTimeMillis());
    paramContext.startActivity(localIntent);
  }
  
  private void c(HotChatInfo paramHotChatInfo)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    localMessage.obj = HotChatInfo.createWifiPOIInfo(paramHotChatInfo);
    this.b.sendMessage(localMessage);
  }
  
  private void doAction()
  {
    int j = 0;
    int k = 0;
    int i = 0;
    ev("doAction", 1);
    afck.l("NearbyTransitActivity", new Object[] { "doAction", Boolean.valueOf(this.mDestroy) });
    if (this.mDestroy) {
      return;
    }
    Object localObject;
    if (aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.app.addObserver(this.d, true);
      if (this.mAction == 1)
      {
        localObject = (acfv)this.app.getBusinessHandler(35);
        if ((localObject != null) && (!TextUtils.isEmpty(this.bCZ))) {
          if (this.cQk > 0)
          {
            if (!((acfv)localObject).a(this.bCZ, this.mExtraFlag, this.bXq, 0, this.cQk)) {
              i = 1;
            }
            j = i;
            if (j == 0) {
              break label467;
            }
            i = 6;
          }
        }
        for (;;)
        {
          label147:
          k = j;
          j = i;
          i = k;
          label153:
          if (i == 0) {
            break label461;
          }
          localObject = Message.obtain();
          ((Message)localObject).what = 1;
          ((Message)localObject).arg1 = j;
          ((Message)localObject).obj = aGn;
          label182:
          if (localObject == null) {
            break label465;
          }
          this.b.sendMessageDelayed((Message)localObject, 200L);
          return;
          i = j;
          if (!((acfv)localObject).f(this.bCZ, this.mExtraFlag, this.bXq)) {
            i = 1;
          }
          j = i;
          break;
          if (localObject == null)
          {
            i = 9;
            j = 1;
          }
          else
          {
            i = 10;
            j = 1;
          }
        }
      }
      if ((this.mAction != 2) || (this.bDa == null)) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(this.bDa).getJSONObject("params");
        localHotChatInfo = HotChatInfo.createHotChat((JSONObject)localObject);
        if (localHotChatInfo == null) {
          break label481;
        }
        boolean bool = localHotChatInfo.isWifiHotChat;
        if (bool)
        {
          i = 1;
          j = 1;
          k = i;
          m = j;
        }
      }
      catch (JSONException localJSONException)
      {
        HotChatInfo localHotChatInfo;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyTransitActivity", 2, "", localJSONException);
        this.app.removeObserver(this.d);
        k = 7;
        int m = 1;
        continue;
      }
      try
      {
        if (((JSONObject)localObject).has("fissile"))
        {
          this.cQl = ((JSONObject)localObject).getInt("fissile");
          m = j;
          k = i;
        }
      }
      catch (Exception localException)
      {
        localException.fillInStackTrace();
        k = i;
        m = j;
        continue;
      }
      i = m;
      j = k;
      break label153;
      i = k;
      if (!a(localHotChatInfo))
      {
        i = 1;
        break label472;
        j = 1;
        i = 1;
        break label153;
        Message localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.arg1 = 2;
        localMessage.obj = getString(2131694663);
        break label182;
        label461:
        localMessage = null;
        break label182;
        label465:
        break;
        label467:
        i = 1;
        break label147;
      }
      label472:
      k = 1;
      j = i;
      i = k;
      continue;
      label481:
      i = 8;
      j = 1;
    }
  }
  
  public static void ev(String paramString, int paramInt) {}
  
  private void parseParams()
  {
    afck.l("NearbyTransitActivity", new Object[] { "parseParams" });
    Intent localIntent = getIntent();
    Bundle localBundle = localIntent.getExtras();
    this.mFrom = localBundle.getString("from");
    this.mAction = localBundle.getInt("action");
    this.bDa = localBundle.getString("params");
    if (this.mAction == 1) {
      this.bCZ = localIntent.getExtras().getString("hotnamecode");
    }
    if ("1".equals(localBundle.getString("onwall"))) {
      this.mExtraFlag |= 0x2;
    }
    if ("1".equals(localBundle.getString("nonelbs"))) {
      this.bXq = false;
    }
    if ("1".equals(localBundle.getString("fissile"))) {
      this.cQl = 1;
    }
    this.ie = localIntent.getLongExtra("enter_time", System.currentTimeMillis());
    this.a = new arib(this, 2131561628);
    this.cQc = getResources().getDimensionPixelSize(2131299627);
    this.mDestroy = false;
    this.b = new aqgw(Looper.getMainLooper(), this);
  }
  
  protected void a(Common.WifiPOIInfo paramWifiPOIInfo)
  {
    if (aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.b.removeMessages(2);
      this.b.removeMessages(5);
      this.b.sendEmptyMessageDelayed(5, 200L);
      this.b.sendEmptyMessageDelayed(2, 30000L);
      ThreadManager.post(new NearbyTransitActivity.3(this, paramWifiPOIInfo), 5, null, true);
      return;
    }
    paramWifiPOIInfo = Message.obtain();
    paramWifiPOIInfo.what = 1;
    paramWifiPOIInfo.arg1 = 2;
    paramWifiPOIInfo.obj = getString(2131694663);
    this.b.sendMessage(paramWifiPOIInfo);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    ev("doOnCreate", 1);
    super.doOnCreate(paramBundle);
    parseParams();
    if (this.mAction == 1)
    {
      this.b.sendEmptyMessageDelayed(5, 800L);
      this.b.sendEmptyMessageDelayed(2, 30000L);
    }
    ThreadManager.getFileThreadHandler().post(new NearbyTransitActivity.1(this));
    return false;
  }
  
  public void doOnDestroy()
  {
    afck.l("NearbyTransitActivity", new Object[] { "doOnDestroy" });
    this.mDestroy = true;
    this.b.removeCallbacksAndMessages(null);
    this.app.removeObserver(this.d);
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    afck.l("NearbyTransitActivity", new Object[] { "handleMessage", Integer.valueOf(paramMessage.what) });
    switch (paramMessage.what)
    {
    }
    label226:
    do
    {
      return false;
      if (this.a != null) {
        this.a.dismiss();
      }
      long l;
      if ((paramMessage.what == 2) || ((paramMessage.obj instanceof String)))
      {
        if (paramMessage.what == 2)
        {
          str1 = getString(2131694663);
          if ((paramMessage.obj instanceof String)) {
            str1 = (String)paramMessage.obj;
          }
          QQToast.a(BaseApplication.getContext(), str1, 0).show(this.cQc);
        }
      }
      else
      {
        this.b.removeCallbacksAndMessages(null);
        this.app.removeObserver(this.d);
        l = System.currentTimeMillis() - this.ie;
        if (l > 0L)
        {
          str1 = this.app.getCurrentAccountUin();
          if (paramMessage.what != 2) {
            break label226;
          }
        }
      }
      for (int i = 4;; i = paramMessage.arg1)
      {
        a(str1, false, l, i);
        finish();
        return false;
        str1 = aGn;
        break;
      }
      if (this.a != null) {
        this.a.dismiss();
      }
      paramMessage = (Object[])paramMessage.obj;
      aF((String)paramMessage[0], (String)paramMessage[1], (String)paramMessage[2]);
      this.b.removeCallbacksAndMessages(null);
      this.app.removeObserver(this.d);
      finish();
      return false;
      a((Common.WifiPOIInfo)paramMessage.obj);
      return false;
    } while (this.a == null);
    if (this.cQl == 1) {}
    for (String str1 = getString(2131694651);; str1 = getString(2131694650))
    {
      String str2 = str1;
      if (paramMessage.obj != null)
      {
        str2 = str1;
        if ((paramMessage.obj instanceof String))
        {
          str2 = (String)paramMessage.obj;
          ajrk.m("NearbyTransitActivity", new Object[] { "handleMessage MSG_SHOW_LOADING ", str2 });
        }
      }
      this.a.a(0, str2, 0, this);
      return false;
    }
  }
  
  public boolean onBackEvent()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = 3;
    this.b.sendMessage(localMessage);
    return true;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = Message.obtain();
    paramDialogInterface.what = 1;
    paramDialogInterface.arg1 = 3;
    this.b.sendMessage(paramDialogInterface);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyTransitActivity
 * JD-Core Version:    0.7.0.1
 */