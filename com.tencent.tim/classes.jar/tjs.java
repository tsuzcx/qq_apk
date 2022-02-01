import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import org.json.JSONObject;

public class tjs
  extends VasWebviewJsPlugin
{
  private GdtAppReceiver b;
  
  public tjs()
  {
    this.mPluginNameSpace = "qq_gdt_ad";
    if (getActivity() != null) {}
    for (Object localObject = getActivity();; localObject = BaseApplicationImpl.getApplication())
    {
      tlo.a().a((Context)localObject, new tlo.a());
      return;
    }
  }
  
  private void bDE()
  {
    if ((this.b != null) || (this.mRuntime == null)) {
      return;
    }
    tkw.i("GdtAdWebPlugin", "registerReceiverForApp");
    this.b = new GdtAppReceiver();
    this.b.register(getActivity());
  }
  
  private void bDF()
  {
    if ((this.b == null) || (this.mRuntime == null)) {
      return;
    }
    tkw.i("GdtAdWebPlugin", "unregisterReceiverForApp");
    this.b.unregister(getActivity());
    this.b = null;
  }
  
  public GdtAppReceiver a()
  {
    return this.b;
  }
  
  public Activity getActivity()
  {
    if (this.mRuntime != null) {}
    for (Activity localActivity1 = this.mRuntime.getActivity();; localActivity1 = null)
    {
      Activity localActivity2 = localActivity1;
      if ((localActivity1 instanceof BasePluginActivity)) {
        localActivity2 = ((BasePluginActivity)BasePluginActivity.class.cast(localActivity1)).getOutActivity();
      }
      return localActivity2;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramJsBridgeListener = null;
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
      if ("loadAdDemo".equals(paramString3))
      {
        paramJsBridgeListener = tjr.a().a(5);
        if (paramJsBridgeListener != null) {
          paramJsBridgeListener.a(this, paramString1, paramVarArgs);
        }
        return true;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        tkw.e("GdtAdWebPlugin", "GdtAdWebPlugin handleJsCallRequest error ", paramString1);
        paramString1 = null;
        continue;
        if ("getLocation".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(4);
        }
        else if ("getDeviceId".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(7);
        }
        else if ("getMacAddress".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(8);
        }
        else if ("getCarrier".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(9);
        }
        else if ("getNetType".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(10);
        }
        else if ("getOSVersion".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(11);
        }
        else if ("handleClick".equals(paramString3))
        {
          bDE();
          paramJsBridgeListener = tjr.a().a(12);
        }
        else if ("showBanner".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(13);
        }
        else if ("showInterstitial".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(19);
        }
        else if ("showInterstitialForJS".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(20);
        }
        else if ("getDeviceInfo".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(14);
        }
        else if ("c2sReport".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(15);
        }
        else if ("openMotiveVideoAd".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(16);
        }
        else if ("getUserInfo".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(17);
        }
        else if ("preLoadAfterAdLoaded".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(18);
        }
        else if ("getCanvasJson".equals(paramString3))
        {
          paramJsBridgeListener = tjr.a().a(21);
        }
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    tkw.i("GdtAdWebPlugin", String.format("onActivityResult requestCode:%d resultCode:%d", new Object[] { Byte.valueOf(paramByte), Integer.valueOf(paramInt) }));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bDF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tjs
 * JD-Core Version:    0.7.0.1
 */