package com.tencent.gdtad.api.motivebrowsing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RewardedVideoAdPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import kotlin.Metadata;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/RewardedBrowsingCallbackReceiver;", "Landroid/content/BroadcastReceiver;", "plugin", "Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RewardedVideoAdPlugin;", "proxy", "Lcom/tencent/qqmini/proxyimpl/AdProxyImpl;", "(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RewardedVideoAdPlugin;Lcom/tencent/qqmini/proxyimpl/AdProxyImpl;)V", "mPlugin", "Lmqq/util/WeakReference;", "mProxy", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RewardedBrowsingCallbackReceiver
  extends BroadcastReceiver
{
  public static final a a = new a(null);
  private final WeakReference<RewardedVideoAdPlugin> Q;
  private final WeakReference<AdProxyImpl> R;
  
  public RewardedBrowsingCallbackReceiver()
  {
    this(null, null, 3, null);
  }
  
  public RewardedBrowsingCallbackReceiver(@Nullable RewardedVideoAdPlugin paramRewardedVideoAdPlugin, @Nullable AdProxyImpl paramAdProxyImpl)
  {
    this.Q = new WeakReference(paramRewardedVideoAdPlugin);
    this.R = new WeakReference(paramAdProxyImpl);
  }
  
  public void onReceive(@Nullable Context paramContext, @Nullable Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RewardedBrowsingCallbackReceiver", 2, "RewardedBrowsingCallbackReceiver onReceive");
    }
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (!TextUtils.equals((CharSequence)paramContext, (CharSequence)"REWARDED_PLUGIN_ACTION_MOTIVE_BROWSING_END")) {
        break label59;
      }
      paramContext = (RewardedVideoAdPlugin)this.Q.get();
      if (paramContext != null) {
        paramContext.onReceiveVideoClose(paramIntent);
      }
    }
    label59:
    do
    {
      do
      {
        return;
      } while (!TextUtils.equals((CharSequence)paramContext, (CharSequence)"AD_PROXY_ACTION_MOTIVE_BROWSING_END"));
      paramContext = (AdProxyImpl)this.R.get();
    } while (paramContext == null);
    paramContext.onReceiveVideoClose(paramIntent);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/RewardedBrowsingCallbackReceiver$Companion;", "", "()V", "ACTION_MOTIVE_BROWSING_END_PLUGIN", "", "ACTION_MOTIVE_BROWSING_END_PROXY", "TAG", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.RewardedBrowsingCallbackReceiver
 * JD-Core Version:    0.7.0.1
 */