package com.tencent.mobileqq.ark.API;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import apuh;
import aqmr;
import auts;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tgc.a;
import tkv;
import tlb;
import wki;

public class ArkAppNotifyCenter
{
  public static final String TAG = "ark.ArkAppNotifyCenter";
  public static ArkClickListener arkClickListener;
  private static int callbackId;
  private static HashMap<String, b> notifyRegs = new HashMap();
  private static d receiver;
  
  static
  {
    callbackId = -1;
    Object localObject = new c();
    notifyRegs.put("com.tencent.troopapp", localObject);
    notifyRegs.put("com.tencent.test.troopapp", localObject);
    localObject = new a();
    notifyRegs.put("com.tencent.yundong", localObject);
    notifyRegs.put("com.tencent.gdt.gouwu", localObject);
    notifyRegs.put("com.tencent.gdt.label", localObject);
    notifyRegs.put("com.tencent.gdt.IllustratedView", localObject);
    notifyRegs.put("com.tencent.gdt.funPlayView", localObject);
    notifyRegs.put("com.tencent.mobileqq.reading", localObject);
    notifyRegs.put("com.tencent.tangram.card", localObject);
    notifyRegs.put("com.tencent.tangram.test", localObject);
    notifyRegs.put("com.tencent.weather", localObject);
    notifyRegs.put("com.tencent.pcg.qzone.qqcps", localObject);
    notifyRegs.put("com.tencent.qqcomic.care", localObject);
    notifyRegs.put("com.tencent.carecomic.normal", localObject);
    notifyRegs.put("com.tencent.carecomic.update", localObject);
  }
  
  private static void callbackMuteStatus(String paramString)
  {
    try
    {
      if (((AudioManager)getAppInterface().getApplication().getApplicationContext().getSystemService("audio")).getRingerMode() != 2) {}
      for (boolean bool = true;; bool = false)
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("is_muted", bool);
        if (QLog.isColorLevel()) {
          QLog.i("ark.ArkAppNotifyCenter", 2, "ad_query_mute: " + localJSONObject1.toString());
        }
        ark.arkNotify(paramString, "ad_query_mute_callback", localJSONObject1.toString(), "json");
        return;
      }
      JSONObject localJSONObject2;
      return;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("is_muted", false);
        ark.arkNotify(paramString, "ad_query_mute_callback", localJSONObject2.toString(), "json");
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static ChatMessage getAdArkItemIndexInAIO(List<ChatMessage> paramList, String paramString)
  {
    ChatMessage localChatMessage;
    if ((paramList == null) || (paramList.isEmpty()) || (aqmr.isEmpty(paramString)))
    {
      localChatMessage = null;
      return localChatMessage;
    }
    int i = 0;
    for (;;)
    {
      for (;;)
      {
        if (i >= paramList.size()) {
          break label133;
        }
        localChatMessage = (ChatMessage)paramList.get(i);
        Object localObject;
        if ((localChatMessage instanceof MessageForArkApp))
        {
          localObject = ((MessageForArkApp)localChatMessage).ark_app_message;
          if (localObject != null)
          {
            localObject = ((ArkAppMessage)localObject).metaList;
            if (aqmr.isEmpty((String)localObject)) {}
          }
        }
        try
        {
          boolean bool = paramString.equals(new JSONObject((String)localObject).optJSONObject("gdt").optString("traceid"));
          if (bool) {
            break;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
      i += 1;
    }
    label133:
    return null;
  }
  
  protected static QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private static View getViewByPosition(ChatMessage paramChatMessage, ChatXListView paramChatXListView)
  {
    int i = ((wki)((auts)paramChatXListView.getAdapter()).getWrappedAdapter()).b(paramChatMessage) + paramChatXListView.getHeaderViewsCount();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + i);
    }
    if (i < 0) {
      return null;
    }
    return paramChatXListView.getChildAt(i - paramChatXListView.getFirstVisiblePosition());
  }
  
  private static Rect getVisibilityRect(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    return localRect;
  }
  
  public static boolean notify(String paramString1, String paramString2, String paramString3)
  {
    b localb = (b)notifyRegs.get(paramString1);
    if (localb != null)
    {
      ThreadManager.getSubThreadHandler().post(new ArkAppNotifyCenter.1(localb, paramString1, paramString2, paramString3));
      return true;
    }
    return false;
  }
  
  public static void registVolumnReceiver()
  {
    if (receiver == null) {
      receiver = new d(null);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
    localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(receiver, localIntentFilter);
  }
  
  public static void setNotify(String paramString, WeakReference<b> paramWeakReference)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null))
    {
      notifyRegs.put(paramString, paramWeakReference.get());
      return;
    }
    notifyRegs.remove(paramString);
  }
  
  public static void unRegistVolumnReceiver()
  {
    if (receiver != null)
    {
      BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(receiver);
      receiver = null;
    }
  }
  
  public static abstract interface ArkClickListener
  {
    public abstract void onArkClick(String paramString1, String paramString2, String paramString3);
  }
  
  public static class a
    implements ArkAppNotifyCenter.b
  {
    tgc.a d;
    
    public boolean notify(String paramString1, String paramString2, String paramString3)
    {
      if (paramString2.equals("ad_query_mute"))
      {
        ArkAppNotifyCenter.callbackMuteStatus(paramString1);
        return true;
      }
      if (paramString3 == null) {
        return false;
      }
      QLog.d("ark.ArkAppNotifyCenter", 1, "appname : " + paramString1 + "eventName : " + paramString2 + " params : " + paramString3, null);
      if (ArkAppNotifyCenter.arkClickListener != null) {
        ArkAppNotifyCenter.arkClickListener.onArkClick(paramString1, paramString2, paramString3);
      }
      if (paramString2.equals("ad_c2s_report")) {
        try
        {
          paramString1 = new JSONObject(paramString3);
          tlb.a(paramString1.getInt("op"), 0, (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), paramString1.getJSONObject("adInfo"))));
          QLog.d("ark.ArkAppNotifyCenter", 1, "report c2s end", null);
          return true;
        }
        catch (JSONException paramString1)
        {
          QLog.d("ark.ArkAppNotifyCenter", 1, paramString1, new Object[0]);
          return false;
        }
      }
      if (BaseActivity.sTopActivity == null)
      {
        QLog.d("ark.ArkAppNotifyCenter", 1, "top activity is null");
        return false;
      }
      Object localObject = new JSONObject();
      if (paramString2.equals("ad_query_cell_rect"))
      {
        ThreadManagerV2.getUIHandlerV2().post(new ArkAppNotifyCenter.GdtNotify.1(this, (JSONObject)localObject, paramString3, paramString1));
        return true;
      }
      localObject = new WeakReference(BaseActivity.sTopActivity);
      WeakReference localWeakReference = new WeakReference(BaseActivity.sTopActivity);
      if (paramString2.equals("ad_click"))
      {
        ArkAppCenter.a().postToMainThread(new ArkAppNotifyCenter.GdtNotify.2(this, paramString3, (WeakReference)localObject, paramString1));
        ark.arkNotify(paramString1, "ad_click_callback", paramString3, "json");
      }
      for (;;)
      {
        return true;
        if (paramString2.equals("ad_request"))
        {
          if (!"com.tencent.yundong".equals(paramString1)) {}
          ArkAppCenter.a().postToMainThread(new ArkAppNotifyCenter.GdtNotify.3(this, paramString1, paramString3, localWeakReference));
        }
        else if (paramString2.equals("get_device_info"))
        {
          QLog.d("ark.ArkAppNotifyCenter", 1, "ark get_device_info", null);
          ArkAppCenter.a().post(paramString1, new ArkAppNotifyCenter.GdtNotify.4(this, localWeakReference, paramString3, paramString1));
        }
        else if (paramString2.equals("ad_preload_after_ad_loaded"))
        {
          QLog.d("ark.ArkAppNotifyCenter", 1, "ark ad_preload_after_ad_loaded", null);
          ArkAppCenter.a().postToMainThread(new ArkAppNotifyCenter.GdtNotify.5(this, paramString3));
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean notify(String paramString1, String paramString2, String paramString3);
  }
  
  public static class c
    implements ArkAppNotifyCenter.b
  {
    public boolean notify(String paramString1, String paramString2, String paramString3)
    {
      JSONObject localJSONObject = null;
      try
      {
        paramString3 = new JSONObject(paramString3).optString("gc");
        if (TextUtils.isEmpty(paramString3)) {
          return false;
        }
      }
      catch (Exception paramString3)
      {
        for (;;)
        {
          QLog.e("ark.ArkAppNotifyCenter", 1, "notify json error!", paramString3);
          paramString3 = localJSONObject;
        }
        if (paramString2.equals("GetIsTroopOwner")) {
          try
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("isOwner", apuh.f(ArkAppNotifyCenter.getAppInterface(), paramString3, ArkAppNotifyCenter.getAppInterface().getCurrentUin()));
            ark.arkNotify(paramString1, paramString2, localJSONObject.toString(), "json");
            return true;
          }
          catch (Throwable paramString1)
          {
            for (;;)
            {
              QLog.e("ark.ArkAppNotifyCenter", 1, "ark.notify error!", paramString1);
            }
          }
        }
      }
      return false;
    }
  }
  
  static class d
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ark.ArkAppNotifyCenter", 2, "--VolumeReceiver---" + paramIntent.getAction());
      }
      ArkAppNotifyCenter.callbackMuteStatus("com.tencent.gouwu.video");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter
 * JD-Core Version:    0.7.0.1
 */