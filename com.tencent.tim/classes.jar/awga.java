import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.6;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class awga
  extends awfr
{
  private static String cPN = "";
  private BroadcastReceiver bZ = new awgb(this);
  private String cacheArgs;
  private Handler handler = new Handler();
  long lastClickTime = 0L;
  Dialog mDownloadingDialog;
  private aqju openDialog;
  
  private void aA(String... paramVarArgs)
  {
    int i = 4;
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleGroupQuote " + paramVarArgs[0]);
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramVarArgs[0]);
        int j = ((JSONObject)localObject).getInt("groupCode");
        paramVarArgs = ((JSONObject)localObject).optString("albumid");
        localObject = ((JSONObject)localObject).optString("albumname");
        String str = this.f.mRuntime.a().getAccount();
        if (TextUtils.isEmpty(paramVarArgs)) {
          break label150;
        }
        avpw.a(this.f.mRuntime.getActivity(), str, i, 4, j, "", paramVarArgs, (String)localObject, 7001, 43);
        return;
      }
      catch (Exception paramVarArgs) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleGroupUploadPhoto,decode param error");
      return;
      label150:
      i = 3;
    }
  }
  
  private void aB(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      for (;;)
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunDidPickAlbum " + paramVarArgs[0]);
        }
        try
        {
          Object localObject = new JSONObject(paramVarArgs[0]);
          paramVarArgs = ((JSONObject)localObject).getString("albumid");
          String str = ((JSONObject)localObject).optString("albumname");
          localObject = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("UploadPhoto.key_album_id", paramVarArgs);
          localBundle.putString("UploadPhoto.key_album_name", str);
          ((Intent)localObject).putExtras(localBundle);
          paramVarArgs = this.f.mRuntime.getActivity();
          if ((paramVarArgs != null) && (!paramVarArgs.isFinishing()))
          {
            paramVarArgs.setResult(-1, (Intent)localObject);
            paramVarArgs.finish();
            return;
          }
        }
        catch (Exception paramVarArgs) {}
      }
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunDidPickAlbum,decode param error");
  }
  
  private void aC(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunPickQzoneAlbum " + paramVarArgs[0]);
      }
      try
      {
        cPN = new JSONObject(paramVarArgs[0]).getString("callback");
        paramVarArgs = new Bundle();
        paramVarArgs.putInt("key_personal_album_enter_model", 0);
        paramVarArgs.putBoolean("key_pass_result_by_bundle", true);
        avpw.d locald = avpw.d.a();
        locald.cMP = this.f.mRuntime.a().getCurrentAccountUin();
        paramVarArgs.putBoolean("key_need_change_to_jpg", true);
        avpw.a(this.f.mRuntime.getActivity(), locald, paramVarArgs, avpw.a(this.f, this.f.mRuntime, 6));
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
  }
  
  private void abj(String paramString)
  {
    avzf.a().a().aaw(paramString);
  }
  
  private void aco(int paramInt)
  {
    if ((this.f == null) || (this.f.mRuntime == null)) {}
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.f.mRuntime.getWebView();
    } while (localCustomWebView == null);
    localCustomWebView.callJs("window.QZQunRedPointInterface.onReceive({data:" + paramInt + "});");
  }
  
  private void ar(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunDetailDelete ");
    }
    try
    {
      paramVarArgs = new Intent("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete");
      this.f.mRuntime.getActivity().sendBroadcast(paramVarArgs);
      return;
    }
    catch (Exception paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunDetailDelete exception:" + paramVarArgs);
    }
  }
  
  private void as(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunJumpDetail " + paramVarArgs[0]);
      }
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]).getString("url");
        Intent localIntent = new Intent(this.f.mRuntime.getActivity(), QQBrowserDelegationActivity.class);
        localIntent.putExtra("url", paramVarArgs);
        localIntent.putExtra("fromQZone", true);
        localIntent.putExtra("injectrecommend", true);
        if (arap.sPluginNameSpaceHashMap.containsKey("Qzone")) {
          localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
        }
        localIntent.putExtra("source_name", this.f.mRuntime.getActivity().getString(2131717944));
        localIntent.setData(Uri.parse(paramVarArgs));
        this.f.startActivityForResult(localIntent, (byte)0);
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunJumpDetail,decode param error");
  }
  
  private void at(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, "handleStartQunRedPointNotify " + paramVarArgs[0]);
      }
      try
      {
        int i = new JSONObject(paramVarArgs[0]).getInt("groupCode");
        i = aqgx.m(this.f.mRuntime.a().getAccount(), "troop_photo_message", String.valueOf(i));
        if (QLog.isDevelopLevel()) {
          QLog.d("QzoneQunFeedJsPlugin", 4, "handleStartQunRedPointNotify data=" + i);
        }
        aco(i);
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleStartQunRedPointNotify,decode param error");
  }
  
  private void au(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleEndQunRedPointNotify");
    }
  }
  
  private void av(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleHideTopicComment");
    }
  }
  
  private void aw(String... paramVarArgs)
  {
    int i = 1;
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleGroupUploadPhoto " + paramVarArgs[0]);
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      long l = ((JSONObject)localObject).getLong("groupCode");
      paramVarArgs = ((JSONObject)localObject).optString("albumid");
      localObject = ((JSONObject)localObject).optString("albumname");
      String str = this.f.mRuntime.a().getAccount();
      if (!TextUtils.isEmpty(paramVarArgs)) {
        i = 2;
      }
      avpw.b(this.f.mRuntime.getActivity(), str, i, 1, l, "", paramVarArgs, (String)localObject, 7001, 43);
      return;
    }
    catch (Exception paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleGroupUploadPhoto,decode param error");
    }
  }
  
  private void ax(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleGroupUploadPhoto " + paramVarArgs[0]);
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      int i = ((JSONObject)localObject).getInt("groupCode");
      paramVarArgs = ((JSONObject)localObject).optString("albumid");
      localObject = ((JSONObject)localObject).optString("albumname");
      this.f.mRuntime.a().getAccount();
      ChatHistoryActivity.g(this.f.mRuntime.getActivity(), String.valueOf(i), paramVarArgs, (String)localObject);
      return;
    }
    catch (Exception paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleImportGroupAio,decode param error");
    }
  }
  
  private void ay(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleGroupUploadPhoto " + paramVarArgs[0]);
    }
    if (System.currentTimeMillis() - this.lastClickTime < 2000L) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleShowPhotoList too many return " + (System.currentTimeMillis() - this.lastClickTime));
    }
    do
    {
      return;
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        int i = ((JSONObject)localObject2).getInt("groupID");
        paramVarArgs = ((JSONObject)localObject2).optString("albumID");
        Object localObject5 = ((JSONObject)localObject2).optString("photoID");
        Object localObject4 = ((JSONObject)localObject2).optString("uin");
        Object localObject3 = ((JSONObject)localObject2).optString("bigurl");
        long l = ((JSONObject)localObject2).optLong("uin");
        int j = ((JSONObject)localObject2).optInt("isVideo");
        int k = ((JSONObject)localObject2).optInt("orgVideoSize");
        int m = ((JSONObject)localObject2).optInt("videoWidth");
        int n = ((JSONObject)localObject2).optInt("videoHeight");
        Object localObject1 = ((JSONObject)localObject2).optString("videoURL");
        String str = ((JSONObject)localObject2).optString("videoID");
        localObject2 = avpw.d.a();
        ((avpw.d)localObject2).cMP = ((String)localObject4);
        localObject4 = new Bundle();
        ArrayList localArrayList = new ArrayList();
        PhotoInfo localPhotoInfo = new PhotoInfo();
        localPhotoInfo.bigUrl = ((String)localObject3);
        localPhotoInfo.aAu = l;
        localPhotoInfo.albumId = paramVarArgs;
        localPhotoInfo.lloc = ((String)localObject5);
        localPhotoInfo.appid = i;
        localPhotoInfo.videoflag = j;
        localPhotoInfo.a = new VideoInfo();
        localPhotoInfo.a.videoId = str;
        localObject5 = new PictureUrl();
        ((PictureUrl)localObject5).url = ((String)localObject3);
        localPhotoInfo.a.d = ((PictureUrl)localObject5);
        localObject3 = new VideoUrl();
        ((VideoUrl)localObject3).url = ((String)localObject1);
        localPhotoInfo.a.originVideoSize = k;
        localPhotoInfo.a.videoId = str;
        localPhotoInfo.a.actionUrl = ((String)localObject1);
        localPhotoInfo.a.a = ((VideoUrl)localObject3);
        localPhotoInfo.a.width = m;
        localPhotoInfo.a.height = n;
        localPhotoInfo.a.videoStatus = 5;
        localArrayList.add(localPhotoInfo);
        localObject1 = new PhotoParam();
        ((PhotoParam)localObject1).albumid = paramVarArgs;
        ((PhotoParam)localObject1).cell_id = paramVarArgs;
        ((Bundle)localObject4).putSerializable("picturelist", localArrayList);
        ((Bundle)localObject4).putInt("curindex", 0);
        ((Bundle)localObject4).putInt("mode", 13);
        ((Bundle)localObject4).putBoolean("need_clear_cache", true);
        avpw.c(this.f.mRuntime.getActivity(), (avpw.d)localObject2, (Bundle)localObject4, 6);
        this.lastClickTime = System.currentTimeMillis();
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleGroupUploadPhoto,decode param error");
  }
  
  private void az(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunDownloadPhoto " + paramVarArgs[0]);
    }
    new Intent().putExtra("photos", paramVarArgs[0]);
    avzf.a().a(new awgc(this, paramVarArgs));
    if (!isSdcardWorking())
    {
      arxa.a().showToast(acfp.m(2131713335));
      return;
    }
    if (!NetworkState.isNetSupport())
    {
      arxa.a().showToast(acfp.m(2131713333));
      return;
    }
    if (!NetworkState.isWifiConn())
    {
      Activity localActivity = this.f.mRuntime.getActivity();
      aqha.a(localActivity, 230).setTitle(localActivity.getString(2131718140)).setMessage(localActivity.getString(2131718142)).setPositiveButton(localActivity.getString(2131718139), new awgg(this, paramVarArgs)).setNegativeButton(localActivity.getString(2131718138), new awgf(this)).show();
      return;
    }
    abj(paramVarArgs[0]);
  }
  
  private void c(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    Activity localActivity = this.f.mRuntime.getActivity();
    if ((this.mDownloadingDialog != null) && (this.mDownloadingDialog.isShowing())) {
      this.mDownloadingDialog.dismiss();
    }
    if (paramBoolean) {
      return;
    }
    if (paramInt2 > 0)
    {
      String str = "";
      if (paramInt1 > 0)
      {
        str = String.format(localActivity.getString(2131718143), new Object[] { Integer.valueOf(paramInt1) }) + "，";
        str = str + paramString + acfp.m(2131713337);
      }
      paramString = str + String.format(localActivity.getString(2131718136), new Object[] { Integer.valueOf(paramInt2) });
      aqha.a(localActivity, 232).setMessage(paramString).setNegativeButton(2131718141, new awgh(this)).show();
      return;
    }
    arxa.a().showToast(localActivity.getString(2131718144) + paramString + acfp.m(2131713336));
  }
  
  private void eDz()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.qq.syncQunMsg");
      this.f.mRuntime.getActivity().registerReceiver(this.bZ, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.w("QzoneQunFeedJsPlugin", 1, "registerUnreadMsgReceiver----", localException);
    }
  }
  
  private boolean isSdcardWorking()
  {
    return SDCardMountMonitorReceiver.a().aLC();
  }
  
  public void c(WebViewPlugin paramWebViewPlugin)
  {
    super.c(paramWebViewPlugin);
    eDz();
    SDCardMountMonitorReceiver.a().registerReceiver();
    if ((paramWebViewPlugin != null) && (paramWebViewPlugin.mRuntime != null) && (paramWebViewPlugin.mRuntime.getActivity() != null)) {
      paramWebViewPlugin.mRuntime.getActivity().setResult(50);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.f == null) || (this.f.mRuntime == null)) {
      return false;
    }
    if (paramString3.equalsIgnoreCase("StartQunRedPointNotify"))
    {
      at(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("EndQunRedPointNotify"))
    {
      au(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("GroupUploadPhoto"))
    {
      aw(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunDownloadPhoto"))
    {
      az(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("GroupQuote"))
    {
      aA(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunDidPickAlbum"))
    {
      aB(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunPickQzoneAlbum"))
    {
      aC(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("HideTopicComment"))
    {
      av(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunJumpDetail"))
    {
      as(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunDetailDelete"))
    {
      ar(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("ShowGroupPhotoBrowser"))
    {
      ay(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("ImportGroupAIO"))
    {
      ax(paramVarArgs);
      return true;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(cPN)) || (paramIntent == null));
      String str1 = paramIntent.getStringExtra("key_selected_albuminfo.id");
      String str2 = paramIntent.getStringExtra("key_selected_albuminfo.name");
      String str3 = paramIntent.getStringExtra("key_selected_albuminfo.cover");
      paramByte = paramIntent.getIntExtra("key_selected_albuminfo.permission", 0);
      paramIntent = new StringBuilder();
      paramIntent.append("{albumid:\"").append(str1).append("\",albumname:\"").append(str2).append("\",albumcover:\"").append(str3).append("\",albumpermission:").append(paramByte).append("}");
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, paramIntent.toString());
      }
      this.f.callJs(cPN, new String[] { paramIntent.toString() });
      return;
    } while (paramInt != -1);
    this.handler.postDelayed(new QzoneQunFeedJsPlugin.6(this), 2000L);
  }
  
  public void onDestroy()
  {
    try
    {
      this.f.mRuntime.getActivity().unregisterReceiver(this.bZ);
      SDCardMountMonitorReceiver.a().unregisterReceiver();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awga
 * JD-Core Version:    0.7.0.1
 */