import NS_QMALL_COVER.AlbumThemeSkin;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.album.QzonePhotoInfo;
import cooperation.qzone.remote.logic.RemoteRequestSender.1;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class avzh
{
  private static final String TAG = avzh.class.getName();
  private avzf c;
  
  public avzh(avzf paramavzf)
  {
    this.c = paramavzf;
  }
  
  public void A(String paramString1, String paramString2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("type", paramString1);
    localBundle.putString("value", paramString2);
    localBundle.putLong("uin", paramLong);
    this.c.a("cmd.update.friendsetting", localBundle, false);
  }
  
  public int M(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("value", paramBoolean);
    return this.c.a("cmd.qzoneFontChanged", localBundle, false);
  }
  
  public int N(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("value", paramBoolean);
    return this.c.a("cmd.qzoneBarrageEffectChanged", localBundle, false);
  }
  
  public int O(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("value", paramBoolean);
    return this.c.a("cmd.qzoneUpdateCustomBrowserInfo", localBundle, false);
  }
  
  public int P(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("value", paramBoolean);
    return this.c.a("cmd.qzoneSuperFontChanged", localBundle, false);
  }
  
  public int PV()
  {
    return this.c.a("cmd.qzoneFeedSkinSwitchChanged", null, false);
  }
  
  public int PW()
  {
    Bundle localBundle = new Bundle();
    return this.c.a("cmd.qzoneUpdateFontList", localBundle, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, ArrayList<SongInfo> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.origin", paramInt1);
    localBundle.putInt("param.index", paramInt2);
    localBundle.putSerializable("param.songList", paramArrayList);
    this.c.a("cmd.playMusicList", localBundle, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, ArrayList<SongInfo> paramArrayList, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.origin", paramInt1);
    localBundle.putInt("param.index", paramInt2);
    localBundle.putSerializable("param.songList", paramArrayList);
    localBundle.putInt("param.playMode", paramInt3);
    this.c.a("cmd.playAudioList", localBundle, false);
  }
  
  public void a(long paramLong, AlbumThemeSkin paramAlbumThemeSkin)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putSerializable("param.album_theme", paramAlbumThemeSkin);
    this.c.a("cmd.alumb.theme", localBundle, false);
  }
  
  public void a(Map<Integer, String> paramMap, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMap);
    localBundle.putSerializable("param.feedDataCookie", localArrayList);
    localBundle.putInt("param.reportPosi", paramInt1);
    localBundle.putInt("param.actionExpectation", paramInt2);
    localBundle.putLong("costTime", paramLong1);
    localBundle.putLong("error_code", paramLong2);
    ThreadManager.post(new RemoteRequestSender.1(this, localBundle), 2, null, false);
  }
  
  public void aa(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.textContent", paramString1);
    localBundle.putString("param.signInPictureUrl", paramString2);
    localBundle.putString("param.fontId", paramString3);
    localBundle.putString("param.fontUrl", paramString4);
    this.c.a("cmd.SyncWechatWithSignIn", localBundle, false);
  }
  
  public void aat(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.DynamicCmd", paramString);
    this.c.a("cmd.getDynamicPhoto", localBundle, true);
  }
  
  public void aau(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.DynamicCmd", paramString);
    this.c.a("cmd.getDynamicSelnum", localBundle, true);
  }
  
  public void aav(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.CloudDynamicCmd", paramString);
    this.c.a("cmd.getDynamicCloudPhoto", localBundle, true);
  }
  
  public void aaw(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramString);
    this.c.a("cmd.troop.download.photo", localBundle, true);
  }
  
  public void aax(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.videoClientKey", paramString);
    this.c.a("cmd.videoGetFakeFeedCover", localBundle, true);
  }
  
  public void aay(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.recordTempVideoPath", paramString);
    this.c.a("cmd.qzoneDeleteTempVideo", localBundle, false);
  }
  
  public void aaz(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.videoForH5Json", paramString);
    this.c.a("cmd.videoUploadForH5", localBundle, false);
  }
  
  public void ab(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("music_id", paramString1);
    localBundle.putString("lrc_id", paramString2);
    localBundle.putString("climax_start", paramString3);
    localBundle.putString("climax_endure", paramString4);
    this.c.a("cmd.UpdateDynamicAlbumInfo", localBundle, true);
  }
  
  public void ac(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("DeviceStrDiyMemo", paramString1);
    localBundle.putString("DeviceStrDeviceTail", paramString2);
    localBundle.putString("DeviceStrDeviceIcon", paramString3);
    localBundle.putString("DeviceStrIdentifySqua", paramString4);
    this.c.a("cmd.setUserTail", localBundle, true);
  }
  
  public int al(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.tmpLocalFile", paramString1);
    localBundle.putString("param.jsBid", paramString2);
    return this.c.a("cmd.qzoneUploadUps", localBundle, true);
  }
  
  public int ax(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramLong);
    return this.c.a("cmd.pre.getpassivefeeds", localBundle, true);
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, ArrayList<SongInfo> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.origin", paramInt1);
    localBundle.putInt("param.index", paramInt2);
    localBundle.putSerializable("param.songList", paramArrayList);
    this.c.a("cmd.playFMBroadCastList", localBundle, false);
  }
  
  public void bA(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (new JSONObject(paramString1).optInt("certificateResult") == 1) {
            if (paramString2.equals("notifyCampusFriendCertificateResult"))
            {
              LocalMultiProcConfig.putInt4Uin("qzone_campusInfo_verfyStatus", 2, Long.valueOf(paramString3).longValue());
              return;
            }
          }
        }
        catch (JSONException paramString1)
        {
          QLog.i(TAG, 1, "updateSchoolCertificate exception", paramString1);
          return;
        }
      }
    } while (!paramString2.equals("notifyUploadSutudentIDResult"));
    LocalMultiProcConfig.putInt4Uin("qzone_campusInfo_verfyStatus", 1, Long.valueOf(paramString3).longValue());
  }
  
  public void bB(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("GiftId_FullScreen", paramString1);
    localBundle.putString("GiftUrl_FullScreen", paramString2);
    localBundle.putString("GiftMd5_FullScreen", paramString3);
    this.c.a("cmd.downloadGift", localBundle, true);
  }
  
  public void be(long paramLong, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putString("param.payKey", paramString);
    this.c.a("cmd.qzoneSetRedKeyData", localBundle, true);
  }
  
  public void bl(long paramLong, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramLong);
    localBundle.putInt("isHide", paramInt);
    this.c.a("cmd.refreshWeishiMedalStatus", localBundle, false);
  }
  
  public void eCA()
  {
    this.c.a("cmd.notifyPlayListChange", null, false);
  }
  
  public void eCB()
  {
    this.c.a("cmd.dynamicDestroy", null, true);
  }
  
  public void eCC()
  {
    Bundle localBundle = new Bundle();
    this.c.a("cmd.deletePrePostPhoto", localBundle, true);
  }
  
  public void eCD()
  {
    Bundle localBundle = new Bundle();
    this.c.a("cmd.cancelAllpreLoad", localBundle, true);
  }
  
  public void eCE()
  {
    Bundle localBundle = new Bundle();
    this.c.a("cmd.enableUploadFirstDynamicPhoto", localBundle, true);
  }
  
  public void eCF()
  {
    this.c.a("cmd.getDeviceInfos", null, true);
  }
  
  public void eCG()
  {
    this.c.a("cmd.videoStopAll", null, false);
  }
  
  public void eCH()
  {
    this.c.a("cmd.getRecommedPhoto", null, true);
  }
  
  public void eCI()
  {
    this.c.a("cmd.getLocalPhotoSwitcher", null, true);
  }
  
  public void eCJ()
  {
    this.c.a("cmd.getEventVideoAlbumState", null, true);
  }
  
  public void eCK()
  {
    this.c.a("cmd.getQuickMakeDynamicStatus", null, true);
  }
  
  public void eCL()
  {
    this.c.a("cmd.getHistoryEventTag", null, true);
  }
  
  public void eCM()
  {
    this.c.a("cmd.deleteTimerShuoShuo", null, false);
  }
  
  public void eCN()
  {
    this.c.a("cmd.refreshPassiveFeeds", null, false);
  }
  
  public void eCz()
  {
    this.c.a("cmd.getPlayingSong", null, true);
  }
  
  public void ei(Bundle paramBundle)
  {
    this.c.a("cmd.setLocalPhotoSwitcher", paramBundle, false);
  }
  
  public void ej(Bundle paramBundle)
  {
    this.c.a("cmd.setEventVideoAlbumState", paramBundle, false);
  }
  
  public void ek(Bundle paramBundle)
  {
    this.c.a("cmd.setQuickMakeDynamicStatus", paramBundle, false);
  }
  
  public void el(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.c.a("cmd.setHistoryEventTag", paramBundle, false);
      return;
    }
    this.c.a("cmd.setHistoryEventTag", null, false);
  }
  
  public void em(Bundle paramBundle)
  {
    this.c.a("cmd.selectEventTag", paramBundle, false);
  }
  
  public void f(Bundle paramBundle, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      LocalMultiProcConfig.putString4Uin("qzone_campusInfo_name", paramBundle.getString("name"), Long.valueOf(paramString).longValue());
      LocalMultiProcConfig.putString4Uin("qzone_campusInfo_school_id", paramBundle.getString("schoolid"), Long.valueOf(paramString).longValue());
      LocalMultiProcConfig.putString4Uin("qzone_campusInfo_school_idx", paramBundle.getString("idx"), Long.valueOf(paramString).longValue());
    }
  }
  
  public void fO(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.videoRemoteUrls", paramString);
    this.c.a("cmd.videoDownload", localBundle, false);
  }
  
  public void fu(ArrayList<QzonePhotoInfo> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("param.DynamicCloudPhotolist", paramArrayList);
    this.c.a("cmd.DynamicCloudPhotoSendSuccess", localBundle, true);
  }
  
  public void gX(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.FirstDynamicPhotoPath", paramString);
    localBundle.putInt("param.DynamicTotalPhotoNum", paramInt);
    this.c.a("cmd.UploadFirstDynamicPhoto", localBundle, true);
  }
  
  public int gb(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.customPraiseData", paramString);
    return this.c.a("cmd.qzoneUpdateCustomPraise", localBundle, false);
  }
  
  public int gc(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.ploymorphicPraise", paramString);
    return this.c.a("cmd.qzoneUpdatePloymorphicPraise", localBundle, false);
  }
  
  public void getLivingInfo()
  {
    this.c.a("cmd.getLivingInfo", null, true);
  }
  
  public void getPlayMode()
  {
    this.c.a("cmd.getPlayMode", null, true);
  }
  
  public void initUserInfo()
  {
    this.c.a("cmd.initUserInfo", null, false);
  }
  
  public void j(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.playModeRandom", paramInt1);
    localBundle.putInt("param.playModeAuto", paramInt2);
    localBundle.putInt("param.playModeLoop", paramInt3);
    this.c.a("cmd.savePlayMode", localBundle, false);
  }
  
  public void jv(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("GiftId_FullScreen", paramString1);
    localBundle.putString("GiftUrl_FullScreen", paramString2);
    this.c.a("cmd.downloadPassivePraise", localBundle, true);
  }
  
  public void nO(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", paramLong);
    this.c.a("cmd.getTravelGroup", localBundle, true);
  }
  
  public void p(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("param.videoRemoteUrls", paramArrayList1);
    localBundle.putStringArrayList("param.videoId", paramArrayList2);
    this.c.a("cmd.videoGetLocalProxyUrl", localBundle, true);
  }
  
  public void pausePlay()
  {
    this.c.a("cmd.pausePlay", null, false);
  }
  
  public void q(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("param.videoRemoteUrls", paramArrayList1);
    localBundle.putStringArrayList("param.videoStates", paramArrayList2);
    this.c.a("cmd.videoSetState", localBundle, false);
  }
  
  public void resumePlay()
  {
    this.c.a("cmd.resumePlay", null, false);
  }
  
  public void stopPlay()
  {
    this.c.a("cmd.stopPlay", null, false);
  }
  
  public void w(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.DynamicCloudPhotolistAlbumId", paramString1);
    localBundle.putString("param.DynamicCloudPhotolistlloc", paramString2);
    localBundle.putString("param.DynamicCloudPhotolist", paramString3);
    localBundle.putBoolean("param.DynamicIsFromAlbum", true);
    localBundle.putInt("param.DynamicTotalPhotoNum", paramInt);
    this.c.a("cmd.UploadFirstDynamicPhoto", localBundle, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avzh
 * JD-Core Version:    0.7.0.1
 */