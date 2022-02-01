import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.1;
import cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.2;
import cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.3;
import cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.4;
import cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.5;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class awgj
  extends awfr
  implements avzi
{
  private ConcurrentHashMap<String, String> gG = new ConcurrentHashMap();
  
  private void a(String paramString, Bundle paramBundle, awgj.a parama)
  {
    Bundle localBundle;
    if ((paramBundle != null) && (parama != null))
    {
      localBundle = b(paramBundle, paramString);
      if (localBundle != null) {
        paramBundle = new JSONObject();
      }
    }
    try
    {
      parama.e(paramBundle, localBundle);
      if (paramString != null) {
        this.f.callJs(paramString, new String[] { paramBundle.toString() });
      }
      return;
    }
    catch (Throwable parama)
    {
      for (;;)
      {
        QLog.e("QzoneRecommedPhotoJsPlugin", 1, "onCallJsBridge.setData error", parama);
      }
    }
  }
  
  private void a(String paramString1, String paramString2, Runnable paramRunnable, boolean paramBoolean)
  {
    try
    {
      String str = new JSONObject(paramString2).optString("callback");
      if ((paramBoolean) && (TextUtils.isEmpty(str))) {
        return;
      }
      if (!TextUtils.isEmpty(paramString1)) {
        this.gG.put(paramString1, str);
      }
      this.f.mRuntime.a().getHandler(awgt.class).post(paramRunnable);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleRunnable error" + paramString2, paramString1);
    }
  }
  
  private void aaK(String paramString)
  {
    if (paramString == null) {
      return;
    }
    QLog.w("QzoneRecommedPhotoJsPlugin", 1, "errorCallBack error");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", -1);
      this.f.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "errorCallBack error", paramString);
    }
  }
  
  private void abk(String paramString)
  {
    a("cmd.getEventVideoAlbumState", paramString, new QzoneRecommedPhotoJsPlugin.1(this), true);
  }
  
  private void abl(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      if (!TextUtils.isEmpty(paramString))
      {
        this.gG.put("cmd.getRecommedPhoto", paramString);
        this.f.mRuntime.a().getHandler(awgt.class).post(new QzoneRecommedPhotoJsPlugin.2(this));
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleGetRecommendphoto error", paramString);
    }
  }
  
  private void abm(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("photoEventID");
      Intent localIntent = new Intent("action_enter_to_qzone_recommend_photo");
      localIntent.putExtra("param.formSchemeToRecommend", true);
      localIntent.putExtra("param.photoUnikey", paramString);
      avpw.a(this.f.mRuntime.getActivity(), avpw.d.a(), localIntent, 0);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleForwardToRecommedPhoto error", paramString);
    }
  }
  
  private void abn(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("recommend_on", paramString.optString("recommend_on"));
      localBundle.putString("recommendPush_on", paramString.optString("recommendPush_on"));
      localBundle.putString("recommendChatCachePhoto_on", paramString.optString("recommendChatCachePhoto_on"));
      avzf.a().a().ei(localBundle);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleSetShouldScanPhotoEventState error", paramString);
    }
  }
  
  private void abo(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("event_video_album_state", paramString.optString("event_video_album_state"));
      avzf.a().a().ej(localBundle);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleSetEventVideoAlbumState error", paramString);
    }
  }
  
  private void abp(String paramString)
  {
    a("cmd.getLocalPhotoSwitcher", paramString, new QzoneRecommedPhotoJsPlugin.3(this), true);
  }
  
  private void abq(String paramString)
  {
    a("cmd.getQuickMakeDynamicStatus", paramString, new QzoneRecommedPhotoJsPlugin.4(this), true);
  }
  
  private void abr(String paramString)
  {
    a("cmd.setQuickMakeDynamicStatus", paramString, new QzoneRecommedPhotoJsPlugin.5(this, paramString), false);
  }
  
  private Bundle b(Bundle paramBundle, String paramString)
  {
    if (paramBundle.containsKey("data")) {
      try
      {
        paramBundle = paramBundle.getBundle("data");
        if (paramBundle == null) {
          QLog.e("QzoneRecommedPhotoJsPlugin", 1, "call js function,bundle is empty");
        }
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        QLog.w("QzoneRecommedPhotoJsPlugin", 1, "onWebEvent error", paramBundle);
        aaK(paramString);
      }
    }
    for (;;)
    {
      return null;
      aaK(paramString);
    }
  }
  
  private String sd(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return awfn.c(paramString, 200, 200, true);
    }
    return "";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("getEventVideoAlbumState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      avzf.a().a(this);
      abk(paramVarArgs[0]);
      return true;
    }
    if (("setEventVideoAlbumState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      abo(paramVarArgs[0]);
      return true;
    }
    if (("getRecommendPhotoEvent".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      avzf.a().a(this);
      abl(paramVarArgs[0]);
      return true;
    }
    if (("enterPhotoEventDetail".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      abm(paramVarArgs[0]);
      return true;
    }
    if (("setShouldScanPhotoEventState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      abn(paramVarArgs[0]);
      return true;
    }
    if (("getShouldScanPhotoEventState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      avzf.a().a(this);
      abp(paramVarArgs[0]);
      return true;
    }
    if (("getQuickMakeDynamicStatus".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      avzf.a().a(this);
      abq(paramVarArgs[0]);
      return true;
    }
    if (("setQuickMakeDynamicStatus".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      abr(paramVarArgs[0]);
      return true;
    }
    return false;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    Object localObject1;
    do
    {
      return;
      str = (String)this.gG.get(paramString);
      if (!"cmd.getRecommedPhoto".equals(paramString)) {
        break;
      }
      localObject1 = b(paramBundle, str);
    } while (localObject1 == null);
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject();
        paramString.put("code", 0);
        paramString.put("photoEventID", ((Bundle)localObject1).getString("photoEventID"));
        paramString.put("title", ((Bundle)localObject1).getString("title"));
        paramString.put("time", ((Bundle)localObject1).getString("time"));
        paramString.put("mediaCount", ((Bundle)localObject1).getInt("mediaCount"));
        paramBundle = ((Bundle)localObject1).getIntegerArrayList("dataType");
        localObject1 = ((Bundle)localObject1).getStringArrayList("dataPath");
        JSONArray localJSONArray = new JSONArray();
        if ((paramBundle != null) && (paramBundle.size() > 0) && (localObject1 != null) && (((ArrayList)localObject1).size() > 0) && (paramBundle.size() == ((ArrayList)localObject1).size()))
        {
          i = 0;
          if (i < paramBundle.size())
          {
            Object localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("imageData", "data:image/jpg;base64," + sd((String)((ArrayList)localObject1).get(i)));
            ((JSONObject)localObject2).put("type", paramBundle.get(i));
            localJSONArray.put(localObject2);
            if (((Integer)paramBundle.get(i)).intValue() != 3) {
              break label445;
            }
            localObject2 = new File((String)((ArrayList)localObject1).get(i));
            if (!((File)localObject2).exists()) {
              break label445;
            }
            ((File)localObject2).delete();
            break label445;
          }
          paramString.put("thumbInfos", localJSONArray);
          if (str == null) {
            break;
          }
          this.f.callJs(str, new String[] { paramString.toString() });
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.w("QzoneRecommedPhotoJsPlugin", 1, "onWebEvent error", paramString);
        return;
      }
      aaK(str);
      return;
      if ("cmd.getLocalPhotoSwitcher".equals(paramString))
      {
        a(str, paramBundle, new awgk(this));
        return;
      }
      if ("cmd.getQuickMakeDynamicStatus".equals(paramString))
      {
        a(str, paramBundle, new awgl(this));
        return;
      }
      if (!"cmd.getEventVideoAlbumState".equals(paramString)) {
        break;
      }
      a(str, paramBundle, new awgm(this));
      return;
      label445:
      i += 1;
    }
  }
  
  static abstract interface a
  {
    public abstract void e(JSONObject paramJSONObject, Bundle paramBundle)
      throws JSONException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgj
 * JD-Core Version:    0.7.0.1
 */