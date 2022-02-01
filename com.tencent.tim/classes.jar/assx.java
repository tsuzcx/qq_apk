import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class assx
  extends BaseJsPlugin
{
  public static String REFER = "famous";
  private RequestEvent a;
  private String cacheArgs;
  private Handler handler = new Handler();
  private long lastClickTime;
  Dialog mDownloadingDialog;
  private aqju openDialog;
  private BroadcastReceiver troopAlbumReceiver = new assy(this);
  
  private void a(JSONObject paramJSONObject, RequestEvent paramRequestEvent)
  {
    try
    {
      paramJSONObject.getJSONObject("data");
      paramJSONObject = new Bundle();
      paramJSONObject.putInt("key_personal_album_enter_model", 0);
      paramJSONObject.putBoolean("key_pass_result_by_bundle", true);
      avpw.d locald = avpw.d.a();
      locald.cMP = BaseApplicationImpl.sApplication.getRuntime().getAccount();
      paramJSONObject.putBoolean("key_need_change_to_jpg", true);
      avpw.a(this.mMiniAppContext.getAttachedActivity(), locald, paramJSONObject, 100);
      this.a = paramRequestEvent;
      paramJSONObject = new IntentFilter();
      paramJSONObject.addAction("troop_select");
      this.mMiniAppContext.getAttachedActivity().registerReceiver(this.troopAlbumReceiver, paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopAlbumPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
    }
  }
  
  private void alertDownloadErrorCount(Activity paramActivity, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
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
        str = String.format(paramActivity.getString(2131718143), new Object[] { Integer.valueOf(paramInt1) }) + "，";
        str = str + paramString + acfp.m(2131715536);
      }
      paramString = str + String.format(paramActivity.getString(2131718136), new Object[] { Integer.valueOf(paramInt2) });
      aqha.a(paramActivity, 232).setMessage(paramString).setNegativeButton(2131721079, new aste(this)).show();
      return;
    }
    arxa.a().showToast(paramActivity.getString(2131718144) + paramString + acfp.m(2131715535));
  }
  
  private void b(JSONObject paramJSONObject, RequestEvent paramRequestEvent)
    throws JSONException
  {
    Object localObject = paramJSONObject.getJSONObject("data");
    paramJSONObject = ((JSONObject)localObject).optString("albumname");
    long l = ((JSONObject)localObject).getLong("groupCode");
    localObject = ((JSONObject)localObject).optString("albumid");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (int i = 2;; i = 1)
    {
      avpw.b(this.mMiniAppContext.getAttachedActivity(), BaseApplicationImpl.sApplication.getRuntime().getAccount(), i, 1, l, "", (String)localObject, paramJSONObject, 7001, 43);
      this.a = paramRequestEvent;
      paramJSONObject = new IntentFilter();
      paramJSONObject.addAction("troop_upload");
      this.mMiniAppContext.getAttachedActivity().registerReceiver(this.troopAlbumReceiver, paramJSONObject);
      return;
    }
  }
  
  private void bY(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = this.mMiniAppContext.getAttachedActivity().getSharedPreferences("troop_album" + BaseApplicationImpl.sApplication.getRuntime().getAccount(), 0).getBoolean("is_exit_fail_misson", false);
      QLog.w("TroopAlbumPlugin", 2, "isExitFailMission:" + bool);
      if (bool)
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("count", 1);
        paramJSONObject.put("isFail", true);
        sendSubscribeEvent("groupAlbum_onGroupAlbumUpload", paramJSONObject.toString());
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopAlbumPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
    }
  }
  
  private void bZ(JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getJSONObject("data");
    int i = paramJSONObject.optInt("categoryType");
    paramJSONObject = paramJSONObject.optString("categoryId");
    Activity localActivity = this.mMiniAppContext.getAttachedActivity();
    if (localActivity != null) {
      avpw.b(localActivity, BaseApplicationImpl.sApplication.getRuntime().getAccount(), i, paramJSONObject, -1);
    }
  }
  
  private void c(JSONObject paramJSONObject, RequestEvent paramRequestEvent)
    throws JSONException
  {
    if (System.currentTimeMillis() - this.lastClickTime < 2000L)
    {
      QLog.d("TroopAlbumPlugin", 4, "handleShowPhotoList too many return " + (System.currentTimeMillis() - this.lastClickTime));
      return;
    }
    Object localObject1 = paramJSONObject.getJSONObject("data");
    int i = ((JSONObject)localObject1).getInt("groupID");
    paramJSONObject = ((JSONObject)localObject1).optString("albumID");
    Object localObject4 = ((JSONObject)localObject1).optString("photoID");
    Object localObject3 = ((JSONObject)localObject1).optString("uin");
    Object localObject2 = ((JSONObject)localObject1).optString("bigurl");
    long l = ((JSONObject)localObject1).optLong("uin");
    int j = ((JSONObject)localObject1).optInt("isVideo");
    int k = ((JSONObject)localObject1).optInt("orgVideoSize");
    int m = ((JSONObject)localObject1).optInt("videoWidth");
    int n = ((JSONObject)localObject1).optInt("videoHeight");
    paramRequestEvent = ((JSONObject)localObject1).optString("videoURL");
    String str = ((JSONObject)localObject1).optString("videoID");
    localObject1 = avpw.d.a();
    ((avpw.d)localObject1).cMP = ((String)localObject3);
    localObject3 = new Bundle();
    ArrayList localArrayList = new ArrayList();
    PhotoInfo localPhotoInfo = new PhotoInfo();
    localPhotoInfo.bigUrl = ((String)localObject2);
    localPhotoInfo.aAu = l;
    localPhotoInfo.albumId = paramJSONObject;
    localPhotoInfo.lloc = ((String)localObject4);
    localPhotoInfo.appid = i;
    localPhotoInfo.videoflag = j;
    localPhotoInfo.a = new VideoInfo();
    localPhotoInfo.a.videoId = str;
    localObject4 = new PictureUrl();
    ((PictureUrl)localObject4).url = ((String)localObject2);
    localPhotoInfo.a.d = ((PictureUrl)localObject4);
    localObject2 = new VideoUrl();
    ((VideoUrl)localObject2).url = paramRequestEvent;
    localPhotoInfo.a.originVideoSize = k;
    localPhotoInfo.a.videoId = str;
    localPhotoInfo.a.actionUrl = paramRequestEvent;
    localPhotoInfo.a.a = ((VideoUrl)localObject2);
    localPhotoInfo.a.width = m;
    localPhotoInfo.a.height = n;
    localPhotoInfo.a.videoStatus = 5;
    localArrayList.add(localPhotoInfo);
    paramRequestEvent = new PhotoParam();
    paramRequestEvent.albumid = paramJSONObject;
    paramRequestEvent.cell_id = paramJSONObject;
    ((Bundle)localObject3).putSerializable("picturelist", localArrayList);
    ((Bundle)localObject3).putInt("curindex", 0);
    ((Bundle)localObject3).putInt("mode", 13);
    ((Bundle)localObject3).putBoolean("need_clear_cache", true);
    avpw.c(this.mMiniAppContext.getAttachedActivity(), (avpw.d)localObject1, (Bundle)localObject3, 6);
    this.lastClickTime = System.currentTimeMillis();
  }
  
  private void ca(JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getJSONObject("data");
    long l = paramJSONObject.optLong("uin");
    paramJSONObject.optString("nick");
    paramJSONObject = new Intent();
    QzonePluginProxyActivity.x(paramJSONObject, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramJSONObject.putExtra("qqid", l);
    paramJSONObject.putExtra("refer", REFER);
    paramJSONObject.setFlags(67108864);
    paramJSONObject.putExtra("autoShowTimeLine", false);
    QzonePluginProxyActivity.a(this.mMiniAppContext.getAttachedActivity(), BaseApplicationImpl.sApplication.getRuntime().getAccount(), paramJSONObject, 0);
  }
  
  private void cb(JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject = paramJSONObject.getJSONObject("data");
    paramJSONObject = ((JSONObject)localObject).optString("albumname");
    int i = ((JSONObject)localObject).getInt("groupCode");
    localObject = ((JSONObject)localObject).optString("albumid");
    ChatHistoryActivity.g(this.mMiniAppContext.getAttachedActivity(), String.valueOf(i), (String)localObject, paramJSONObject);
  }
  
  private void cc(JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject = new Intent();
    paramJSONObject = paramJSONObject.getJSONObject("data").toString();
    ((Intent)localObject).putExtra("photos", paramJSONObject);
    avzf.a().a(new assz(this, paramJSONObject));
    if (!isSdcardWorking())
    {
      arxa.a().showToast(acfp.m(2131715531));
      return;
    }
    if (!NetworkState.isNetSupport())
    {
      arxa.a().showToast(acfp.m(2131715530));
      return;
    }
    if (!NetworkState.isWifiConn())
    {
      localObject = this.mMiniAppContext.getAttachedActivity();
      aqha.a((Context)localObject, 230).setTitle(((Context)localObject).getString(2131718140)).setMessage(((Context)localObject).getString(2131718142)).setPositiveButton(((Context)localObject).getString(2131718139), new astd(this, paramJSONObject)).setNegativeButton(((Context)localObject).getString(2131721058), new astc(this)).show();
      return;
    }
    avzf.a().a().aaw(paramJSONObject);
  }
  
  private void esg()
  {
    avpw.d.a();
    avpw.i(this.mMiniAppContext.getAttachedActivity(), null, 0);
  }
  
  private boolean isSdcardWorking()
  {
    return SDCardMountMonitorReceiver.a().aLC();
  }
  
  @JsEvent({"groupAlbum_downloadGroupAlbumPhoto"})
  public void groupAlbumDownloadGroupAlbumPhoto(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_downloadGroupAlbumPhoto succeed");
      cc(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_downloadGroupAlbumPhoto failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_groupUploadPhoto"})
  public void groupAlbumGroupUploadPhoto(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_groupUploadPhoto succeed");
      b(new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent);
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbumGroupUploadPhoto failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_importGroupAIO"})
  public void groupAlbumImportGroupAIO(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_importGroupAIO succeed");
      cb(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_importGroupAIO failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_jumpCategoryAlbum"})
  public void groupAlbumJumpCategoryAlbum(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_jumpCategoryAlbum succeed");
      bZ(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_jumpCategoryAlbum failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_jumpGroupAlbumSendBox"})
  public void groupAlbumJumpGroupAlbumSendBox(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_jumpGroupAlbumSendBox succeed");
      esg();
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_jumpGroupAlbumSendBox failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_openUserQzoneHome"})
  public void groupAlbumOpenUserQzoneHome(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_openUserQzoneHome succeed");
      ca(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_openUserQzoneHome failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_pickQzoneAlbum"})
  public void groupAlbumPickQzoneAlbum(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_pickQzoneAlbum succeed");
      a(new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent);
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_pickQzoneAlbum failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_showGroupPhotoBrowser"})
  public void groupAlbumShowGroupPhotoBrowser(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_showGroupPhotoBrowser succeed");
      c(new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent);
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_showGroupPhotoBrowser failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_start"})
  public void groupAlbumStart(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_start succeed");
      bY(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_start failed, ", paramRequestEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     assx
 * JD-Core Version:    0.7.0.1
 */