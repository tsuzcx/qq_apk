package com.tencent.viola.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONObject;

public class EventModule
  extends BaseModule
{
  public static final long BROCAST_DATA_MAX_SIZE = 460800L;
  public static final String MODULE_NAME = "event";
  public static String TAG = "EventModule";
  public static final String VIOLA_ACTION_EVENT_DISPATCH = "com.tencent.viola.action.VIOLA_ACTION_EVENT_DISPATCH";
  public static final String VIOLA_KEY_DATA = "data";
  public static final String VIOLA_KEY_EVENT = "event";
  public static final String VIOLA_KEY_UNIQUE = "unique";
  public static final String VIOLA_PERMISSION_EVENT_NOTIFY = "com.tencent.viola.permission.event.notify";
  private static BroadcastReceiver mBroadcastReceiver = null;
  private static HashSet<WeakReference<EventModule>> mRegisteredModuleObservers = null;
  private static boolean sGlobalReceiverRegistered = false;
  private HashMap<String, String> mEvents;
  private boolean mIsReceiverRegistered = false;
  private WeakReference<EventModule> mModuleObserver;
  private String mUniqueMark;
  
  private void callJs(String paramString1, String paramString2)
  {
    ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString1, paramString2, true);
  }
  
  private void createBroadcastReceiver()
  {
    if (this.mIsReceiverRegistered) {
      return;
    }
    if (mBroadcastReceiver == null) {
      createGlobalBroadcastReceiver();
    }
    if ((!sGlobalReceiverRegistered) && (getViolaInstance().getContext() != null))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.viola.action.VIOLA_ACTION_EVENT_DISPATCH");
      getViolaInstance().getContext().registerReceiver(mBroadcastReceiver, localIntentFilter);
    }
    this.mIsReceiverRegistered = true;
    this.mEvents = new HashMap();
    this.mModuleObserver = new WeakReference(this);
    mRegisteredModuleObservers.add(this.mModuleObserver);
  }
  
  private void createGlobalBroadcastReceiver()
  {
    mRegisteredModuleObservers = new HashSet();
    mBroadcastReceiver = new EventModule.1(this);
  }
  
  private String getUniqueMark()
  {
    if (!TextUtils.isEmpty(this.mUniqueMark)) {
      return this.mUniqueMark;
    }
    Context localContext = getViolaInstance().getContext();
    if (localContext != null) {}
    for (this.mUniqueMark = (String.valueOf(System.currentTimeMillis()) + String.valueOf(localContext.hashCode()));; this.mUniqueMark = (String.valueOf(System.currentTimeMillis()) + String.valueOf((int)(Math.random() * 1000000.0D)))) {
      return this.mUniqueMark;
    }
  }
  
  private void handleEvent(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.mEvents == null)) {}
    do
    {
      return;
      paramString1 = (String)this.mEvents.get(paramString1);
    } while (TextUtils.isEmpty(paramString1));
    callJs(paramString1, paramString2);
  }
  
  private void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = paramIntent.getStringExtra("unique");
    } while (getUniqueMark().equals(paramContext));
    handleEvent(paramIntent.getStringExtra("event"), paramIntent.getStringExtra("data"));
  }
  
  @JSMethod
  public void addEventListener(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      ViolaLogUtils.e(TAG, "addEventListener error: event name is empty");
      return;
    }
    createBroadcastReceiver();
    this.mEvents.put(paramString1, paramString2);
  }
  
  @JSMethod
  public void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    String str;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          ViolaLogUtils.e(TAG, "dispatchEvent error: event name is empty");
          return;
        }
        if (paramJSONObject != null)
        {
          str = paramJSONObject.toString();
          if ((TextUtils.isEmpty(str)) || (str.length() < 460800L)) {
            break;
          }
          ViolaLogUtils.e(TAG, "dispatchEvent error: data is over size");
          return;
        }
      }
      catch (Throwable paramString)
      {
        ViolaLogUtils.e(TAG, "dispatchEvent error: " + paramString.getMessage());
        return;
      }
      str = "";
    }
    Intent localIntent = new Intent("com.tencent.viola.action.VIOLA_ACTION_EVENT_DISPATCH");
    localIntent.putExtra("event", paramString);
    if (paramJSONObject != null) {
      localIntent.putExtra("data", paramJSONObject.toString());
    }
    localIntent.putExtra("unique", getUniqueMark());
    paramJSONObject = getViolaInstance().getContext();
    if (paramJSONObject != null) {
      paramJSONObject.sendBroadcast(localIntent);
    }
    handleEvent(paramString, str);
  }
  
  public void onActivityDestroy()
  {
    if (this.mIsReceiverRegistered)
    {
      mRegisteredModuleObservers.remove(this.mModuleObserver);
      if (mRegisteredModuleObservers.size() == 0)
      {
        Context localContext = getViolaInstance().getContext();
        if (localContext != null)
        {
          localContext.unregisterReceiver(mBroadcastReceiver);
          sGlobalReceiverRegistered = false;
        }
      }
    }
  }
  
  @JSMethod
  public void removeEventListener(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      ViolaLogUtils.e(TAG, "removeEventListener error: event name is empty");
    }
    while (this.mEvents == null) {
      return;
    }
    this.mEvents.remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.module.EventModule
 * JD-Core Version:    0.7.0.1
 */