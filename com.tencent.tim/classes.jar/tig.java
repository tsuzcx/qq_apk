import android.app.Activity;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RewardedVideoAdPlugin;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/RewardedBrowsingCallbackData;", "", "rewardedVideoAdPlugin", "Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RewardedVideoAdPlugin;", "compId", "", "activity", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "event", "webView", "Lcom/tencent/mobileqq/mini/webview/JsRuntime;", "callbackId", "", "isMiniGame", "", "(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RewardedVideoAdPlugin;Ljava/lang/String;Lmqq/util/WeakReference;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;IZ)V", "getActivity", "()Lmqq/util/WeakReference;", "getCallbackId", "()I", "getCompId", "()Ljava/lang/String;", "getEvent", "()Z", "getRewardedVideoAdPlugin", "()Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RewardedVideoAdPlugin;", "getWebView", "()Lcom/tencent/mobileqq/mini/webview/JsRuntime;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "createKey", "equals", "other", "hashCode", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tig
{
  public static final tig.a a;
  private static int index;
  @NotNull
  private final RewardedVideoAdPlugin jdField_a_of_type_ComTencentMobileqqMiniAppbrandJsapiPluginsRewardedVideoAdPlugin;
  @NotNull
  private final JsRuntime jdField_a_of_type_ComTencentMobileqqMiniWebviewJsRuntime;
  @NotNull
  private final String aJt;
  private final int callbackId;
  @NotNull
  private final String event;
  private final boolean isMiniGame;
  @NotNull
  private final WeakReference<Activity> q;
  
  static
  {
    jdField_a_of_type_Tig$a = new tig.a(null);
  }
  
  public tig(@NotNull RewardedVideoAdPlugin paramRewardedVideoAdPlugin, @NotNull String paramString1, @NotNull WeakReference<Activity> paramWeakReference, @NotNull String paramString2, @NotNull JsRuntime paramJsRuntime, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqMiniAppbrandJsapiPluginsRewardedVideoAdPlugin = paramRewardedVideoAdPlugin;
    this.aJt = paramString1;
    this.q = paramWeakReference;
    this.event = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqMiniWebviewJsRuntime = paramJsRuntime;
    this.callbackId = paramInt;
    this.isMiniGame = paramBoolean;
  }
  
  @NotNull
  public final WeakReference<Activity> a()
  {
    return this.q;
  }
  
  @NotNull
  public final String createKey()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("REWARDED_PLUGIN_ACTION_MOTIVE_BROWSING_END#").append(this.aJt).append('#').append(this.event).append('#').append(this.callbackId).append('#').append(this.isMiniGame).append('#');
    int i = index;
    index = i + 1;
    return i;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof tig))
      {
        paramObject = (tig)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqMiniAppbrandJsapiPluginsRewardedVideoAdPlugin, paramObject.jdField_a_of_type_ComTencentMobileqqMiniAppbrandJsapiPluginsRewardedVideoAdPlugin)) || (!Intrinsics.areEqual(this.aJt, paramObject.aJt)) || (!Intrinsics.areEqual(this.q, paramObject.q)) || (!Intrinsics.areEqual(this.event, paramObject.event)) || (!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqMiniWebviewJsRuntime, paramObject.jdField_a_of_type_ComTencentMobileqqMiniWebviewJsRuntime)) || (this.callbackId != paramObject.callbackId) || (this.isMiniGame != paramObject.isMiniGame)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @NotNull
  public final JsRuntime getWebView()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniWebviewJsRuntime;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean isMiniGame()
  {
    return this.isMiniGame;
  }
  
  @NotNull
  public final String om()
  {
    return this.aJt;
  }
  
  @NotNull
  public final String on()
  {
    return this.event;
  }
  
  @NotNull
  public String toString()
  {
    return "RewardedBrowsingCallbackData(rewardedVideoAdPlugin=" + this.jdField_a_of_type_ComTencentMobileqqMiniAppbrandJsapiPluginsRewardedVideoAdPlugin + ", compId=" + this.aJt + ", activity=" + this.q + ", event=" + this.event + ", webView=" + this.jdField_a_of_type_ComTencentMobileqqMiniWebviewJsRuntime + ", callbackId=" + this.callbackId + ", isMiniGame=" + this.isMiniGame + ")";
  }
  
  public final int uV()
  {
    return this.callbackId;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/RewardedBrowsingCallbackData$Companion;", "", "()V", "index", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tig
 * JD-Core Version:    0.7.0.1
 */