import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.activity.QQMapActivity.MapRuntime;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.buscard.BuscardHelper;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.troop.NearbyVideoChatProxyActivity;
import mqq.app.AppRuntime;

public class swn
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    String str = paramBaseApplicationImpl.getPackageName();
    QLog.d("11111", 2, "packagename : " + str + "; processname : " + paramString1);
    Object localObject1;
    if (str.equals(paramString1)) {
      localObject1 = new QQAppInterface(paramBaseApplicationImpl, paramString1);
    }
    for (;;)
    {
      return localObject1;
      localObject1 = localObject2;
      if (paramString1.equals(str + ":msf")) {
        continue;
      }
      localObject1 = localObject2;
      if (paramString1.equals(str + ":notifypush")) {
        continue;
      }
      if (paramString1.equals(str + ":video")) {
        return new VideoAppInterface(paramBaseApplicationImpl, "video");
      }
      if (paramString1.equals(str + ":qzone"))
      {
        paramBaseApplicationImpl = avpw.j(paramBaseApplicationImpl, "qzone");
        paramBaseApplicationImpl.setAsToolRuntime();
        return paramBaseApplicationImpl;
      }
      if (paramString1.equals(str + ":qzonevideo")) {
        return avpw.m(paramBaseApplicationImpl, "qzonevideo");
      }
      if (paramString1.equals(str + ":qzonelive")) {
        return avpw.k(paramBaseApplicationImpl, "qzonelive");
      }
      if (paramString1.equals(str + ":picture")) {
        return avpw.l(paramBaseApplicationImpl, "picture");
      }
      if (paramString1.equals(str + ":openSdk")) {
        return new OpenSDKAppInterface(paramBaseApplicationImpl, "openSdk");
      }
      if (paramString1.equals(str + ":photoedit"))
      {
        paramBaseApplicationImpl = new PluginRuntime();
        anot.a(paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString1.equals(str + ":zebra")) {
        return new PluginRuntime();
      }
      if (paramString1.equals(str + ":demoji"))
      {
        paramBaseApplicationImpl = new PluginRuntime();
        anot.a(paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString1.equals(str + ":map")) {
        return new QQMapActivity.MapRuntime();
      }
      if (paramString1.equals(str + ":weiyun"))
      {
        paramBaseApplicationImpl = awph.a(paramBaseApplicationImpl);
        anot.a(paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString1.equals(str + ":qwallet"))
      {
        paramBaseApplicationImpl = QWalletHelper.createQWalletAppInterface(paramBaseApplicationImpl, "qwallet");
        localObject1 = paramBaseApplicationImpl;
        if (paramBaseApplicationImpl == null) {
          continue;
        }
        anot.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString1.equals(str + ":qqfav")) {
        return avja.b(paramBaseApplicationImpl);
      }
      if (paramString1.equals(str + ":qlink")) {
        return avho.b(paramBaseApplicationImpl, "qlink");
      }
      if (paramString1.equals(str + ":miniapp")) {
        return new com.tencent.mobileqq.microapp.MiniAppInterface(paramBaseApplicationImpl, "miniapp");
      }
      if ((paramString1.equals(str + ":mini")) || (paramString1.equals(str + ":mini1")) || (paramString1.equals(str + ":mini2")) || (paramString1.equals(str + ":mini3")) || (paramString1.equals(str + ":mini4")) || (paramString1.equals(str + ":mini5")) || (paramString1.equals(str + ":mini6")) || (paramString1.equals(str + ":mini7")) || (paramString1.equals(str + ":mini_internal"))) {
        paramString2 = "mini";
      }
      try
      {
        paramString1 = paramString1.substring(str.length() + 1);
        return new com.tencent.mobileqq.mini.MiniAppInterface(paramBaseApplicationImpl, paramString1);
        localObject1 = localObject2;
        if (paramString1.equals(str + ":qqwifi")) {
          continue;
        }
        localObject1 = localObject2;
        if (paramString1.equals(str + ":qqwifiditu")) {
          continue;
        }
        if (paramString1.equals(str + ":dataline")) {
          return avim.c(paramBaseApplicationImpl, "dataline");
        }
        if (paramString1.equals(str + ":smartdevice")) {
          return awjb.d(paramBaseApplicationImpl, "smartdevice");
        }
        if (paramString1.equals(str + ":buscard"))
        {
          paramBaseApplicationImpl = BuscardHelper.a(paramBaseApplicationImpl, "buscard");
          anot.a((PluginRuntime)paramBaseApplicationImpl);
          return paramBaseApplicationImpl;
        }
        if (paramString1.equals(str + ":hce")) {
          return QWalletHelper.createVfcPluginAppInterface(paramBaseApplicationImpl, "hce");
        }
        localObject1 = localObject2;
        if (paramString1.equals(str + ":readinjoy")) {
          continue;
        }
        if (paramString1.equals(str + ":troopmemcard"))
        {
          paramBaseApplicationImpl = awjl.n(paramBaseApplicationImpl, "troop_member_card_plugin.apk");
          anot.a((PluginRuntime)paramBaseApplicationImpl);
          return paramBaseApplicationImpl;
        }
        if (paramString1.equals(str + ":troopmanage"))
        {
          paramBaseApplicationImpl = awjl.n(paramBaseApplicationImpl, "troop_manage_plugin.apk");
          anot.a((PluginRuntime)paramBaseApplicationImpl);
          return paramBaseApplicationImpl;
        }
        if (paramString1.equals(str + ":pluginbridge"))
        {
          paramBaseApplicationImpl = BridgeHelper.d(paramBaseApplicationImpl, "pluginbridge");
          localObject1 = paramBaseApplicationImpl;
          if (paramBaseApplicationImpl == null) {
            continue;
          }
          anot.a((PluginRuntime)paramBaseApplicationImpl);
          return paramBaseApplicationImpl;
        }
        if (paramString1.equals(str + ":groupvideo")) {
          return avfh.c(paramBaseApplicationImpl, "groupvideo");
        }
        if (paramString1.equals(str + ":tool"))
        {
          paramBaseApplicationImpl = new ToolAppRuntime();
          paramBaseApplicationImpl.setAsToolRuntime();
          return paramBaseApplicationImpl;
        }
        if (paramString1.equals(str + ":peak"))
        {
          paramBaseApplicationImpl = new ToolRuntimePeak();
          paramBaseApplicationImpl.setAsToolRuntime();
          return paramBaseApplicationImpl;
        }
        if (paramString1.equals(str + ":huanji")) {
          return avha.e(paramBaseApplicationImpl, "huanji");
        }
        if (paramString1.equals(str + ":nearby_video")) {
          return NearbyVideoChatProxyActivity.c(paramBaseApplicationImpl, "nearby_video");
        }
        if (paramString1.equals(str + ":dingdong")) {
          return atni.a(paramBaseApplicationImpl, "dingdong");
        }
        if (paramString1.equals(str + ":mail"))
        {
          paramBaseApplicationImpl = augn.b(paramBaseApplicationImpl, "mail_plugin.apk", paramString2);
          QLog.d("1111", 2, "createMailPluginAppInterface, app:" + paramBaseApplicationImpl);
          return paramBaseApplicationImpl;
        }
        paramBaseApplicationImpl = new PluginRuntime();
        anot.a(paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1 = paramString2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     swn
 * JD-Core Version:    0.7.0.1
 */