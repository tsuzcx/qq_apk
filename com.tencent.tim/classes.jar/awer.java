import NS_QMALL_COVER.AlbumThemeSkin;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.webviewplugin.QZonePassivePraiseJsPlugin.1;
import java.io.File;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class awer
  extends awfr
  implements avzi
{
  private avrb a;
  private String cPx = "";
  
  private void e(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, String[] paramArrayOfString)
  {
    String str;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null)) {
      str = "";
    }
    do
    {
      for (;;)
      {
        try
        {
          parama = new JSONObject(paramArrayOfString[0]);
          paramWebViewPlugin = parama.getString("zipUrl");
          parama.printStackTrace();
        }
        catch (JSONException parama)
        {
          try
          {
            parama = parama.getString("callback");
            if ((!TextUtils.isEmpty(paramWebViewPlugin)) && (!TextUtils.isEmpty(parama))) {
              break;
            }
            return;
          }
          catch (JSONException parama)
          {
            for (;;)
            {
              continue;
              int i = 0;
            }
          }
          parama = parama;
          paramWebViewPlugin = "";
        }
        parama = str;
      }
      paramWebViewPlugin = paramWebViewPlugin.replace("sbig", aiyf.getVideoPath());
      paramWebViewPlugin = new File(avra.rQ(arwv.toMD5(paramWebViewPlugin)) + aiyf.getVideoPath());
      if ((!paramWebViewPlugin.exists()) || (!paramWebViewPlugin.isDirectory())) {
        break;
      }
      i = 1;
    } while (this.f == null);
    paramWebViewPlugin = "window." + parama + "({checked:" + i + "})";
    this.f.callJs(paramWebViewPlugin);
  }
  
  private void eCN()
  {
    avzf.a().a().eCN();
  }
  
  private void f(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, String[] paramArrayOfString)
  {
    parama.a().getHandler(awfm.class).post(new QZonePassivePraiseJsPlugin.1(this, paramArrayOfString));
  }
  
  private void g(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, String[] paramArrayOfString)
  {
    Object localObject;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null)) {
      localObject = "";
    }
    label56:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            parama = new JSONObject(paramArrayOfString[0]);
            paramWebViewPlugin = parama.getString("zipUrl");
            parama.printStackTrace();
          }
          catch (JSONException parama)
          {
            try
            {
              parama = parama.getString("callback");
              if (!TextUtils.isEmpty(parama)) {
                break;
              }
              return;
            }
            catch (JSONException parama)
            {
              break label56;
            }
            parama = parama;
            paramWebViewPlugin = "";
          }
          parama = (WebViewPlugin.a)localObject;
        }
        paramArrayOfString = avra.rQ(arwv.toMD5(paramWebViewPlugin.replace("sbig", aiyf.getVideoPath())));
        localObject = new File(paramArrayOfString);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      this.a = new avrb(this.f.mRuntime.getActivity());
    } while (!avrb.apU());
    this.a.a(paramWebViewPlugin, paramArrayOfString, true, new awes(this, parama));
  }
  
  private void h(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, String[] paramArrayOfString)
  {
    AlbumThemeSkin localAlbumThemeSkin;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null))
    {
      parama = "";
      localAlbumThemeSkin = new AlbumThemeSkin();
      paramWebViewPlugin = parama;
    }
    for (;;)
    {
      try
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        paramWebViewPlugin = parama;
        localAlbumThemeSkin.iItemId = paramArrayOfString.getInt("itemId");
        paramWebViewPlugin = parama;
        if (localAlbumThemeSkin.iItemId != -1) {
          continue;
        }
        paramWebViewPlugin = parama;
        avzf.a().a().a(0L, localAlbumThemeSkin);
      }
      catch (JSONException parama)
      {
        parama.printStackTrace();
        parama = paramWebViewPlugin;
        continue;
      }
      if (TextUtils.isEmpty(parama)) {}
      return;
      paramWebViewPlugin = parama;
      localAlbumThemeSkin.strPicZipUrl = paramArrayOfString.getString("zipurl");
      paramWebViewPlugin = parama;
      localAlbumThemeSkin.iColor = paramArrayOfString.getInt("icolor");
      paramWebViewPlugin = parama;
      localAlbumThemeSkin.lTabBarSelectedFontColor = paramArrayOfString.getLong("tabBarFontColorSelected");
      paramWebViewPlugin = parama;
      localAlbumThemeSkin.lTabBarUnselectedFontColor = paramArrayOfString.getLong("tabBarFontColor");
      paramWebViewPlugin = parama;
      localAlbumThemeSkin.lVideoButonColor = paramArrayOfString.getLong("videoButonColor");
      paramWebViewPlugin = parama;
      localAlbumThemeSkin.lVideoButtonBgColor = paramArrayOfString.getLong("videoButtonBgColor");
      paramWebViewPlugin = parama;
      localAlbumThemeSkin.lTabbarUnderLineColor = paramArrayOfString.getLong("tabbarUnderLineColor");
      paramWebViewPlugin = parama;
      avzf.a().a().a(0L, localAlbumThemeSkin);
      paramWebViewPlugin = parama;
      paramArrayOfString = paramArrayOfString.getString("callback");
      parama = paramArrayOfString;
      paramWebViewPlugin = paramArrayOfString;
      if (this.f != null)
      {
        paramWebViewPlugin = paramArrayOfString;
        parama = "window." + paramArrayOfString + "({})";
        paramWebViewPlugin = paramArrayOfString;
        this.f.callJs(parama);
        parama = paramArrayOfString;
      }
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934601L)
    {
      String str = QzoneConfig.getInstance().getConfig("H5Url", "GiftDetailPage", "https://h5.qzone.qq.com/gift/detail?_wv=2097155&_proxy=1&uin={uin}&ugcid={ugcid}");
      if (!TextUtils.isEmpty(str))
      {
        int i = str.indexOf("?");
        if (i != -1)
        {
          str = str.substring(0, i);
          if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(str)) && (this.a != null)) {
            this.a.onBackEvent();
          }
        }
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.f == null) || (this.f.mRuntime == null)) {
      return false;
    }
    if ("checkAnimationRs".equalsIgnoreCase(paramString3))
    {
      e(this.f, this.f.mRuntime, paramVarArgs);
      return true;
    }
    if ("downloadAnimationRs".equalsIgnoreCase(paramString3))
    {
      avzf.a().a(this);
      f(this.f, this.f.mRuntime, paramVarArgs);
      return true;
    }
    if ("playAnimation".equalsIgnoreCase(paramString3))
    {
      g(this.f, this.f.mRuntime, paramVarArgs);
      return true;
    }
    if ("SetAlbumListThemeSkin".equalsIgnoreCase(paramString3))
    {
      h(this.f, this.f.mRuntime, paramVarArgs);
      return true;
    }
    if ("hasClickedHighFiveFromLikeList".equalsIgnoreCase(paramString3))
    {
      eCN();
      return true;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    for (;;)
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZoneGiftFullScreenJsPlugin", 2, "call js function,bundle is empty");
        }
      }
      else if ("cmd.downloadPassivePraise".equals(paramString))
      {
        int i = paramBundle.getInt("Gift_DownloadProgress_FullScreen");
        paramString = "-1";
        if (i > 0) {
          if (i >= 100) {
            break label163;
          }
        }
        label163:
        for (paramString = String.format("%.1f", new Object[] { Double.valueOf(i * 0.01D) }); (this.f != null) && (!TextUtils.isEmpty(this.cPx)); paramString = "1")
        {
          paramString = "window." + this.cPx + "({download:" + paramString + "})";
          this.f.callJs(paramString);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awer
 * JD-Core Version:    0.7.0.1
 */