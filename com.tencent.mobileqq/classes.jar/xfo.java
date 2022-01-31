import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.activity.QQMapActivity.MapRuntime;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.buscard.BuscardHelper;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.troop.NearbyVideoChatProxyActivity;
import mqq.app.AppRuntime;

public class xfo
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    Object localObject2 = null;
    String str = paramBaseApplicationImpl.getPackageName();
    Object localObject1;
    if (str.equals(paramString)) {
      localObject1 = new QQAppInterface(paramBaseApplicationImpl, paramString);
    }
    for (;;)
    {
      return localObject1;
      localObject1 = localObject2;
      if (paramString.equals(str + ":msf")) {
        continue;
      }
      localObject1 = localObject2;
      if (paramString.equals(str + ":notifypush")) {
        continue;
      }
      if (paramString.equals(str + ":video")) {
        return new VideoAppInterface(paramBaseApplicationImpl, "video");
      }
      if (paramString.equals(str + ":qzone"))
      {
        paramBaseApplicationImpl = bfpr.b(paramBaseApplicationImpl, "qzone");
        paramBaseApplicationImpl.setAsToolRuntime();
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":qzonevideo")) {
        return bfpr.e(paramBaseApplicationImpl, "qzonevideo");
      }
      if (paramString.equals(str + ":qzonelive")) {
        return bfpr.c(paramBaseApplicationImpl, "qzonelive");
      }
      if (paramString.equals(str + ":picture")) {
        return bfpr.d(paramBaseApplicationImpl, "picture");
      }
      if (paramString.equals(str + ":openSdk")) {
        return new OpenSDKAppInterface(paramBaseApplicationImpl, "openSdk");
      }
      if (paramString.equals(str + ":photoedit"))
      {
        paramBaseApplicationImpl = new PluginRuntime();
        awqx.a(paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":zebra")) {
        return new PluginRuntime();
      }
      if (paramString.equals(str + ":demoji"))
      {
        paramBaseApplicationImpl = new PluginRuntime();
        awqx.a(paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":map")) {
        return new QQMapActivity.MapRuntime();
      }
      if (paramString.equals(str + ":weiyun"))
      {
        paramBaseApplicationImpl = bgtw.a(paramBaseApplicationImpl);
        awqx.a(paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":qwallet"))
      {
        paramBaseApplicationImpl = QWalletHelper.createQWalletAppInterface(paramBaseApplicationImpl, "qwallet");
        localObject1 = paramBaseApplicationImpl;
        if (paramBaseApplicationImpl == null) {
          continue;
        }
        awqx.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":qqfav")) {
        return bfhn.a(paramBaseApplicationImpl);
      }
      if (paramString.equals(str + ":qlink")) {
        return bffo.a(paramBaseApplicationImpl, "qlink");
      }
      if (paramString.equals(str + ":miniapp")) {
        return new com.tencent.mobileqq.microapp.MiniAppInterface(paramBaseApplicationImpl, "miniapp");
      }
      if ((paramString.equals(str + ":mini")) || (paramString.equals(str + ":mini1")) || (paramString.equals(str + ":mini2")) || (paramString.equals(str + ":mini3")) || (paramString.equals(str + ":mini4")) || (paramString.equals(str + ":mini5")) || (paramString.equals(str + ":mini6")) || (paramString.equals(str + ":mini7")) || (paramString.equals(str + ":mini_internal"))) {
        localObject1 = "mini";
      }
      try
      {
        paramString = paramString.substring(str.length() + 1);
        return new com.tencent.mobileqq.mini.MiniAppInterface(paramBaseApplicationImpl, paramString);
        localObject1 = localObject2;
        if (paramString.equals(str + ":qqwifi")) {
          continue;
        }
        localObject1 = localObject2;
        if (paramString.equals(str + ":qqwifiditu")) {
          continue;
        }
        if (paramString.equals(str + ":dataline")) {
          return bfgt.a(paramBaseApplicationImpl, "dataline");
        }
        if (paramString.equals(str + ":smartdevice")) {
          return bgnd.a(paramBaseApplicationImpl, "smartdevice");
        }
        if (paramString.equals(str + ":buscard"))
        {
          paramBaseApplicationImpl = BuscardHelper.a(paramBaseApplicationImpl, "buscard");
          awqx.a((PluginRuntime)paramBaseApplicationImpl);
          return paramBaseApplicationImpl;
        }
        if (paramString.equals(str + ":hce")) {
          return QWalletHelper.createVfcPluginAppInterface(paramBaseApplicationImpl, "hce");
        }
        localObject1 = localObject2;
        if (paramString.equals(str + ":readinjoy")) {
          continue;
        }
        if (paramString.equals(str + ":troopmemcard"))
        {
          paramBaseApplicationImpl = bgnp.a(paramBaseApplicationImpl, "troop_member_card_plugin.apk");
          awqx.a((PluginRuntime)paramBaseApplicationImpl);
          return paramBaseApplicationImpl;
        }
        if (paramString.equals(str + ":troopmanage"))
        {
          paramBaseApplicationImpl = bgnp.a(paramBaseApplicationImpl, "troop_manage_plugin.apk");
          awqx.a((PluginRuntime)paramBaseApplicationImpl);
          return paramBaseApplicationImpl;
        }
        if (paramString.equals(str + ":pluginbridge"))
        {
          paramBaseApplicationImpl = BridgeHelper.a(paramBaseApplicationImpl, "pluginbridge");
          localObject1 = paramBaseApplicationImpl;
          if (paramBaseApplicationImpl == null) {
            continue;
          }
          awqx.a((PluginRuntime)paramBaseApplicationImpl);
          return paramBaseApplicationImpl;
        }
        if (paramString.equals(str + ":groupvideo")) {
          return bfch.a(paramBaseApplicationImpl, "groupvideo");
        }
        if (paramString.equals(str + ":tool"))
        {
          paramBaseApplicationImpl = new ToolAppRuntime();
          paramBaseApplicationImpl.setAsToolRuntime();
          return paramBaseApplicationImpl;
        }
        if (paramString.equals(str + ":peak"))
        {
          paramBaseApplicationImpl = new ToolRuntimePeak();
          paramBaseApplicationImpl.setAsToolRuntime();
          return paramBaseApplicationImpl;
        }
        if (paramString.equals(str + ":huanji")) {
          return bfey.a(paramBaseApplicationImpl, "huanji");
        }
        if (paramString.equals(str + ":nearby_video")) {
          return NearbyVideoChatProxyActivity.a(paramBaseApplicationImpl, "nearby_video");
        }
        paramBaseApplicationImpl = new PluginRuntime();
        awqx.a(paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = (String)localObject1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xfo
 * JD-Core Version:    0.7.0.1
 */