import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

public class mua
{
  private static final String TAG = mua.class.getSimpleName();
  private VideoInfo.EntranceDownloadInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo;
  private kcr jdField_a_of_type_Kcr;
  private mua.b jdField_a_of_type_Mua$b;
  private String akj;
  private boolean aow;
  private ColorBandVideoEntranceButton jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton;
  private kcs jdField_b_of_type_Kcs;
  private VideoInfo g;
  private String mCurrentUin;
  private int mReqType;
  private VideoPreDownloadMgr mVideoPreDownloadMgr;
  
  public mua(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton, Context paramContext)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = paramColorBandVideoEntranceButton;
    this.mVideoPreDownloadMgr = new VideoPreDownloadMgr(paramContext.getApplicationContext());
    paramColorBandVideoEntranceButton = kxm.a();
    if (paramColorBandVideoEntranceButton != null)
    {
      this.mCurrentUin = paramColorBandVideoEntranceButton.getAccount();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo = a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo == null) {
        break label121;
      }
      e(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_Kcr = ((kcr)paramColorBandVideoEntranceButton.getBusinessHandler(90));
      this.jdField_b_of_type_Kcs = new mua.a(null);
      paramColorBandVideoEntranceButton.addObserver(this.jdField_b_of_type_Kcs);
      this.jdField_a_of_type_Mua$b = new mua.b(null);
      lcc.a().b(this.jdField_a_of_type_Mua$b);
      return;
      label121:
      this.g = b();
      e(this.g);
    }
  }
  
  private VideoInfo.EntranceDownloadInfo a()
  {
    SharedPreferences localSharedPreferences = awit.o(this.mCurrentUin);
    if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("key_has_entrance_download_info", false)))
    {
      VideoInfo.EntranceDownloadInfo localEntranceDownloadInfo = new VideoInfo.EntranceDownloadInfo();
      localEntranceDownloadInfo.iconUrl = localSharedPreferences.getString("key_icon_url", null);
      localEntranceDownloadInfo.smallIconUrl = localSharedPreferences.getString("key_small_icon_url", null);
      localEntranceDownloadInfo.isUseGif = localSharedPreferences.getBoolean("key_is_use_gif", false);
      localEntranceDownloadInfo.WT = localSharedPreferences.getString("key_common_data", null);
      localEntranceDownloadInfo.a = new UrlJumpInfo();
      localEntranceDownloadInfo.a.jumpType = localSharedPreferences.getInt("key_jump_type", 0);
      localEntranceDownloadInfo.a.jumpUrl = localSharedPreferences.getString("key_jump_url", null);
      localEntranceDownloadInfo.a.aiM = localSharedPreferences.getString("key_jump_bundle", null);
      localEntranceDownloadInfo.a.jumpSchema = localSharedPreferences.getString("key_jump_schema", null);
      return localEntranceDownloadInfo;
    }
    return null;
  }
  
  private void a(VideoInfo.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onGetEntranceDownloadInfo downloadInfo=" + paramEntranceDownloadInfo);
    }
    if (a(paramEntranceDownloadInfo))
    {
      if (muj.Eu()) {
        break label62;
      }
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "onGetEntranceDownloadInfo isVideoEntranceJumpAppEnable == false");
      }
    }
    label62:
    do
    {
      int i;
      int j;
      do
      {
        return;
        i = mru.a().pI();
        j = muj.pU();
        if ((j <= 0) || (i < j)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(TAG, 2, "onGetEntranceDownloadInfo displayCount=" + i + " exceed maxDisplayCount=" + j);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onGetEntranceDownloadInfo displayCount=" + i + ", maxDisplayCount=" + j);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo = paramEntranceDownloadInfo;
      e(paramEntranceDownloadInfo);
      aSp();
      aSo();
      this.g = null;
    } while ((this.mReqType == 3) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0));
    c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo);
  }
  
  private boolean a(VideoInfo.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    if ((paramEntranceDownloadInfo != null) && (!TextUtils.isEmpty(paramEntranceDownloadInfo.iconUrl)) && (paramEntranceDownloadInfo.a != null) && (!TextUtils.isEmpty(paramEntranceDownloadInfo.a.jumpUrl))) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e(TAG, 2, "checkIsValidEntranceDownloadInfo failed!:" + paramEntranceDownloadInfo);
    }
    return false;
  }
  
  private void aSn()
  {
    if (this.g != null)
    {
      localObject = awit.o(this.mCurrentUin);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("VIDEO_VID", this.g.vid).putString("VIDEO_ARTICLE_ID", this.g.Wz).putString("VIDEO_PUB_ACCOUNT_UIN", this.g.hH).putString("VIDEO_PUB_ACCOUNT_NAME", this.g.accountName).putString("VIDEO_THIRD_ACTION", this.g.thirdAction).putString("VIDEO_THIRD_ICON", this.g.WC).putString("VIDEO_THIRD_NAME", this.g.thirdUinName).putString("VIDEO_TITLE", this.g.title).putString("VIDEO_SUMMARY", this.g.summary).putString("VIDEO_COVER", this.g.coverUrl).putString("VIDEO_H5_URL", this.g.webUrl).putString("VIDEO_URL", this.g.videoUrl).putInt("VIDEO_WIDTH", this.g.width).putInt("VIDEO_HEIGHT", this.g.height).putInt("VIDEO_TIME", this.g.duration).putInt("VIDEO_ARTICLE_BUSITYPE", this.g.busiType).putInt("VIDEO_FEED_TYPE", this.g.feedType).putLong("VIDEO_FEED_ID", this.g.rA).putLong("VIDEO_XG_FILE_SIZE", this.g.ry).putString("VIDEO_CREATE_TIME", this.g.createTime).putBoolean("key_is_use_gif", this.g.isUseGif).putString("key_gif_url", this.g.Gx).putBoolean("key_is_show_cover", this.g.adF).putBoolean("key_has_video_info", true).apply();
      }
    }
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = TAG;
      localStringBuilder = new StringBuilder().append("start save video info, uin: ").append(this.mCurrentUin).append(", ");
      if (this.g == null) {
        break label449;
      }
    }
    label449:
    for (Object localObject = this.g.toLogString();; localObject = "video info is null")
    {
      QLog.d(str, 2, (String)localObject);
      return;
    }
  }
  
  private void aSo()
  {
    if (this.g != null)
    {
      localObject = awit.o(this.mCurrentUin);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().remove("VIDEO_VID").remove("VIDEO_ARTICLE_ID").remove("VIDEO_PUB_ACCOUNT_UIN").remove("VIDEO_PUB_ACCOUNT_NAME").remove("VIDEO_THIRD_ACTION").remove("VIDEO_THIRD_ICON").remove("VIDEO_THIRD_NAME").remove("VIDEO_TITLE").remove("VIDEO_SUMMARY").remove("VIDEO_COVER").remove("VIDEO_H5_URL").remove("VIDEO_URL").remove("VIDEO_WIDTH").remove("VIDEO_HEIGHT").remove("VIDEO_TIME").remove("VIDEO_ARTICLE_BUSITYPE").remove("VIDEO_FEED_TYPE").remove("VIDEO_FEED_ID").remove("VIDEO_XG_FILE_SIZE").remove("VIDEO_CREATE_TIME").remove("key_is_use_gif").remove("key_gif_url").remove("key_is_show_cover").remove("key_has_video_info").apply();
      }
    }
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = TAG;
      localStringBuilder = new StringBuilder().append("remove video info when click bb circle, uin: ").append(this.mCurrentUin).append(", ");
      if (this.g == null) {
        break label287;
      }
    }
    label287:
    for (Object localObject = this.g.toLogString();; localObject = "video info is null")
    {
      QLog.d(str, 2, (String)localObject);
      return;
    }
  }
  
  private void aSp()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo != null)
    {
      SharedPreferences localSharedPreferences = awit.o(this.mCurrentUin);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putString("key_icon_url", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.iconUrl).putString("key_small_icon_url", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.smallIconUrl).putBoolean("key_is_use_gif", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.isUseGif).putString("key_common_data", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.WT).putInt("key_jump_type", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.a.jumpType).putString("key_jump_url", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.a.jumpUrl).putString("key_jump_bundle", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.a.aiM).putString("key_jump_schema", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.a.jumpSchema).putBoolean("key_has_entrance_download_info", true).apply();
      }
    }
  }
  
  private void aSq()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo != null)
    {
      SharedPreferences localSharedPreferences = awit.o(this.mCurrentUin);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().remove("key_icon_url").remove("key_small_icon_url").remove("key_is_use_gif").remove("key_common_data").remove("key_jump_type").remove("key_jump_url").remove("key_jump_schema").remove("key_jump_bundle").remove("key_has_entrance_download_info").apply();
      }
    }
  }
  
  private VideoInfo b()
  {
    Object localObject = awit.o(this.mCurrentUin);
    VideoInfo localVideoInfo;
    if ((localObject != null) && (((SharedPreferences)localObject).getBoolean("key_has_video_info", false)))
    {
      localVideoInfo = new VideoInfo();
      localVideoInfo.vid = ((SharedPreferences)localObject).getString("VIDEO_VID", null);
      localVideoInfo.Wz = ((SharedPreferences)localObject).getString("VIDEO_ARTICLE_ID", null);
      localVideoInfo.hH = ((SharedPreferences)localObject).getString("VIDEO_PUB_ACCOUNT_UIN", null);
      localVideoInfo.accountName = ((SharedPreferences)localObject).getString("VIDEO_PUB_ACCOUNT_NAME", null);
      localVideoInfo.thirdAction = ((SharedPreferences)localObject).getString("VIDEO_THIRD_ACTION", null);
      localVideoInfo.WC = ((SharedPreferences)localObject).getString("VIDEO_THIRD_ICON", null);
      localVideoInfo.thirdUinName = ((SharedPreferences)localObject).getString("VIDEO_THIRD_NAME", null);
      localVideoInfo.title = ((SharedPreferences)localObject).getString("VIDEO_TITLE", null);
      localVideoInfo.summary = ((SharedPreferences)localObject).getString("VIDEO_SUMMARY", null);
      localVideoInfo.coverUrl = ((SharedPreferences)localObject).getString("VIDEO_COVER", null);
      localVideoInfo.webUrl = ((SharedPreferences)localObject).getString("VIDEO_H5_URL", null);
      localVideoInfo.videoUrl = ((SharedPreferences)localObject).getString("VIDEO_URL", null);
      localVideoInfo.width = ((SharedPreferences)localObject).getInt("VIDEO_WIDTH", -1);
      localVideoInfo.height = ((SharedPreferences)localObject).getInt("VIDEO_HEIGHT", -1);
      localVideoInfo.duration = ((SharedPreferences)localObject).getInt("VIDEO_TIME", -1);
      localVideoInfo.busiType = ((SharedPreferences)localObject).getInt("VIDEO_ARTICLE_BUSITYPE", -1);
      localVideoInfo.feedType = ((SharedPreferences)localObject).getInt("VIDEO_FEED_TYPE", -1);
      localVideoInfo.rA = ((SharedPreferences)localObject).getLong("VIDEO_FEED_ID", -1L);
      localVideoInfo.ry = ((SharedPreferences)localObject).getLong("VIDEO_XG_FILE_SIZE", 0L);
      localVideoInfo.createTime = ((SharedPreferences)localObject).getString("VIDEO_CREATE_TIME", null);
      localVideoInfo.isUseGif = ((SharedPreferences)localObject).getBoolean("key_is_use_gif", false);
      localVideoInfo.Gx = ((SharedPreferences)localObject).getString("key_gif_url", null);
      localVideoInfo.adF = ((SharedPreferences)localObject).getBoolean("key_is_show_cover", true);
    }
    for (;;)
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = TAG;
        localStringBuilder = new StringBuilder().append("load video info from local, uin: ").append(this.mCurrentUin).append(", video info: ");
        if (localVideoInfo == null) {
          break label419;
        }
      }
      label419:
      for (localObject = localVideoInfo.toLogString();; localObject = "null")
      {
        QLog.d(str, 2, (String)localObject);
        return localVideoInfo;
      }
      localVideoInfo = null;
    }
  }
  
  private static void b(VideoInfo paramVideoInfo, String paramString)
  {
    if ((paramVideoInfo != null) && (QLog.isColorLevel()))
    {
      QLog.d(TAG, 2, paramString);
      return;
    }
    nV(paramString);
  }
  
  public static void c(nss paramnss)
  {
    mru.a().b(paramnss);
    if (paramnss == null) {}
    label201:
    label244:
    do
    {
      int i;
      do
      {
        return;
        for (;;)
        {
          try
          {
            if (!(paramnss instanceof VideoInfo)) {
              break label244;
            }
            localObject = (VideoInfo)paramnss;
            JSONObject localJSONObject = kxm.v();
            localJSONObject.put("kandian_mode", 3);
            localJSONObject.put("tab_source", 5);
            if (localObject != null)
            {
              i = 2;
              localJSONObject.put("reddot", i);
              if (localObject == null) {
                break label201;
              }
              paramnss = ((VideoInfo)localObject).Wz;
              localJSONObject.put("rowkey", paramnss);
              kbp.a(null, "CliOper", "", "", "0X80081C6", "0X80081C6", 0, 0, "", "", "", localJSONObject.toString(), false);
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.4tab", 2, "reportForVideoEntranceRedDotExposure has finished, r5: " + localJSONObject.toString());
              }
              i = awit.Qi();
              if (i != 1) {
                break;
              }
              kbp.a(null, "", "0X8009A22", "0X8009A22", 0, 0, "", "", "", kxm.a((VideoInfo)localObject, i), false);
              return;
            }
          }
          catch (Exception paramnss)
          {
            paramnss.printStackTrace();
            return;
          }
          i = 1;
          continue;
          paramnss = "";
        }
      } while (i != 2);
      kbp.a(null, "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", kxm.a((VideoInfo)localObject, i), false);
      return;
    } while (!(paramnss instanceof VideoInfo.EntranceDownloadInfo));
    paramnss = (VideoInfo.EntranceDownloadInfo)paramnss;
    Object localObject = new nce.a("", "", "", "");
    ((nce.a)localObject).V(1).a(paramnss.WT).a(0);
    kbp.a(null, "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", ((nce.a)localObject).a().toJsonString(), false);
  }
  
  public static void d(nss paramnss)
  {
    ThreadManager.excute(new VideoFeedsFirstVideoRecommendationManager.1(paramnss), 16, null, true);
  }
  
  private void e(nss paramnss)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramnss);
    }
    f(paramnss);
  }
  
  private void f(nss paramnss)
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0))
    {
      if (paramnss != null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.i(paramnss);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setNotMsg();
  }
  
  private static void nV(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, paramString);
    }
  }
  
  private void w(VideoInfo paramVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onGetFirstRecommendVideoInfo videoInfo=" + paramVideoInfo);
    }
    if (paramVideoInfo != null)
    {
      if ((this.g != null) && (this.g.adF) && (!paramVideoInfo.adF)) {
        return;
      }
      this.g = paramVideoInfo;
      e(paramVideoInfo);
      aSn();
    }
    if ((this.mReqType != 3) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0)) {
      c(this.g);
    }
    if (paramVideoInfo != null) {}
    for (String str = paramVideoInfo.toLogString();; str = "videoInfo is null!")
    {
      b(paramVideoInfo, str);
      return;
    }
  }
  
  public void aSm()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
    }
    aSq();
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo = null;
  }
  
  public boolean o(Bundle paramBundle)
  {
    boolean bool = false;
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (this.g != null)
    {
      localBundle.putParcelable("VIDEO_OBJ", this.g);
      bool = true;
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
      }
      aSo();
      this.g = null;
    }
    return bool;
  }
  
  public void onAccountChange()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.baG();
    }
    QQAppInterface localQQAppInterface = kxm.a();
    if (localQQAppInterface != null)
    {
      this.jdField_a_of_type_Kcr = ((kcr)localQQAppInterface.getBusinessHandler(90));
      localQQAppInterface.addObserver(this.jdField_b_of_type_Kcs);
      this.mCurrentUin = localQQAppInterface.getAccount();
      this.g = b();
      e(this.g);
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "start change account");
    }
  }
  
  public void onDestroy()
  {
    removeObserver();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = null;
    if (this.mVideoPreDownloadMgr != null)
    {
      this.mVideoPreDownloadMgr.destroy(false);
      this.mVideoPreDownloadMgr = null;
    }
    this.jdField_a_of_type_Kcr = null;
    lcc.a().c(this.jdField_a_of_type_Mua$b);
  }
  
  public void removeObserver()
  {
    QQAppInterface localQQAppInterface = kxm.a();
    if ((localQQAppInterface != null) && (this.jdField_b_of_type_Kcs != null)) {
      localQQAppInterface.removeObserver(this.jdField_b_of_type_Kcs);
    }
  }
  
  public void sA(int paramInt)
  {
    boolean bool;
    if ((this.jdField_a_of_type_Kcr != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) && (!this.aow))
    {
      kcr localkcr = this.jdField_a_of_type_Kcr;
      kcs localkcs = this.jdField_b_of_type_Kcs;
      String str = this.akj;
      if (this.g != null)
      {
        bool = true;
        localkcr.a(localkcs, str, paramInt, bool);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "start fetch first recommend video, reqType: " + paramInt);
        }
      }
    }
    for (;;)
    {
      this.mReqType = paramInt;
      this.aow = false;
      return;
      bool = false;
      break;
      if ((this.aow) && (QLog.isColorLevel())) {
        QLog.d(TAG, 2, "filter auto refresh");
      }
    }
  }
  
  public class a
    extends kcs
  {
    private a() {}
    
    protected void o(boolean paramBoolean, Bundle paramBundle)
    {
      if (paramBundle.getBoolean("is_from_first_recommend_video"))
      {
        VideoInfo.EntranceDownloadInfo localEntranceDownloadInfo = (VideoInfo.EntranceDownloadInfo)paramBundle.getParcelable("value_entrance_download_info");
        if (localEntranceDownloadInfo == null) {
          break label32;
        }
        mua.a(mua.this, localEntranceDownloadInfo);
      }
      for (;;)
      {
        return;
        label32:
        mua.a(mua.this, paramBundle.getString("VALUE_COOKIE"));
        if (paramBoolean)
        {
          paramBundle = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
          if ((paramBundle != null) && (paramBundle.size() > 0))
          {
            paramBundle = (VideoInfo)paramBundle.get(0);
            mua.a(mua.this, paramBundle);
          }
        }
        while (paramBundle != null)
        {
          ThreadManager.post(new VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1(this, paramBundle), 5, null, true);
          return;
          paramBundle = null;
        }
      }
    }
  }
  
  class b
    extends lce
  {
    private b() {}
    
    public void aJH()
    {
      mua.a(mua.this, true);
    }
    
    public void qA(int paramInt)
    {
      mua.this.sA(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mua
 * JD-Core Version:    0.7.0.1
 */