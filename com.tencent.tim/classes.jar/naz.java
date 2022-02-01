import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoReportManager.1;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoReportManager.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class naz
{
  private static final String TAG = naz.class.getSimpleName();
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private naq.d jdField_a_of_type_Naq$d;
  private int aVj;
  private Set<String> ad;
  private String akh;
  private String aki;
  private boolean apF;
  private boolean apn;
  private naq.b b;
  private ArrayList<ncd> lu = new ArrayList();
  private Activity mActivity;
  private Bundle mBundle;
  private long sd;
  
  naz(Activity paramActivity, Bundle paramBundle, VideoFeedsPlayManager paramVideoFeedsPlayManager, naq.d paramd)
  {
    this.mActivity = paramActivity;
    this.mBundle = paramBundle;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Naq$d = paramd;
    initData();
  }
  
  private void a(Intent paramIntent, VideoInfo paramVideoInfo, List<ncd> paramList, mhu parammhu, long paramLong, int paramInt)
  {
    if ((paramVideoInfo != null) && (paramIntent != null))
    {
      String str3 = paramVideoInfo.hH;
      String str4 = paramVideoInfo.vid;
      String str2 = paramVideoInfo.Wz;
      String str1;
      int n;
      int i1;
      int j;
      label77:
      int i3;
      int k;
      label154:
      VideoInfo localVideoInfo;
      int m;
      label176:
      ncd localncd;
      int i;
      label273:
      Object localObject;
      label406:
      boolean bool;
      if ((paramVideoInfo.busiType == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
      {
        str1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        n = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        i1 = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
        if (!this.apF) {
          break label1003;
        }
        j = 1;
        this.apF = false;
        int i2 = paramIntent.getIntExtra("key_source", -1);
        i3 = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
        int i4 = paramIntent.getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        int i5 = paramIntent.getIntExtra("VIDEO_CHAT_TYPE", 0);
        int i6 = paramIntent.getIntExtra("VIDEO_KANDIAN_TYPE", 0);
        String str5 = paramIntent.getStringExtra("VIDEO_CHAT_UIN");
        if ((TextUtils.isEmpty(paramVideoInfo.WE)) || (!muj.Es())) {
          break label1009;
        }
        k = 1;
        int i7 = paramList.size();
        localVideoInfo = this.jdField_a_of_type_Naq$d.f();
        m = 0;
        if (m >= i7) {
          return;
        }
        localncd = (ncd)paramList.get(m);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "播放VV上报 totalPlayTime = " + localncd.totalPlayTime + ", currentPlayTime = " + localncd.xj);
        }
        if ((localncd.xj != 0L) || (localncd.totalPlayTime != 0L))
        {
          if (m != 0) {
            break label1015;
          }
          i = 0;
          localObject = new nce.a(str1, str3, str4, str2).d(localncd.totalPlayTime).a(localncd.xj).y(i).z(i7 - 1).w(i2).B(parammhu.aSr).A(parammhu.aSq).D(parammhu.videoHeight).C(parammhu.videoWidth).b(this.akh).c(this.aki).c(paramLong).l(paramInt).a(409409).a(Boolean.valueOf(paramVideoInfo.adB));
          if (paramVideoInfo.videoReportInfo == null) {
            break label1034;
          }
          paramIntent = paramVideoInfo.videoReportInfo;
          paramIntent = ((nce.a)localObject).a(paramIntent).e(paramVideoInfo.isAD).p(kct.nd()).q(kxm.nR()).e(paramVideoInfo.algorithmID).c(paramVideoInfo.strategyID).E(j).K(paramVideoInfo.aHe).F(i4).g(localVideoInfo.Wz).v(i3).L(i1).j(false).n(0).k(paramVideoInfo.adH).m(paramVideoInfo.WD).S(k);
          if (!paramVideoInfo.yV()) {
            break label1041;
          }
          i = 2;
          label518:
          paramIntent = paramIntent.Y(i);
          if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
            break label1047;
          }
          bool = true;
          label535:
          localObject = paramIntent.l(bool);
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c == null)) {
            break label1053;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c.WT;
          label571:
          paramIntent = ((nce.a)localObject).q(paramIntent);
          if (!paramVideoInfo.yV()) {
            break label1060;
          }
          i = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.aHc;
          label594:
          paramIntent = paramIntent.t(i);
          if ((!paramVideoInfo.yV()) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.appIconUrl)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.appName))) {
            break label1066;
          }
          i = 1;
          label637:
          localObject = paramIntent.Z(i);
          if ((!paramVideoInfo.yV()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h == null)) {
            break label1072;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h.WT;
          label673:
          localObject = ((nce.a)localObject).o(paramIntent);
          if ((!paramVideoInfo.yV()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.k == null)) {
            break label1079;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.k.WT;
          label709:
          paramIntent = ((nce.a)localObject).p(paramIntent).h(localVideoInfo.algorithmID).M(kzc.h(localVideoInfo.width, localVideoInfo.height, localVideoInfo.duration)).N(1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "play video [video_from_type : " + i3 + ", first_video_row_key : " + localVideoInfo.Wz + ", first_video_type : " + i4 + "]");
          }
          if ((paramVideoInfo.busiType == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
            paramIntent.I(i5).J(i6).j(str5);
          }
          localObject = paramIntent.a().toJsonString();
          if (TextUtils.isEmpty(str2)) {
            break label1086;
          }
        }
      }
      label1034:
      label1041:
      label1047:
      label1053:
      label1060:
      label1066:
      label1072:
      label1079:
      label1086:
      for (paramIntent = str2;; paramIntent = "0")
      {
        kbp.b(null, str3, "0X8007409", "0X8007409", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, (String)localObject, false);
        kbp.d("0X8007409", str3, String.valueOf(n), String.valueOf(i1), "", (String)localObject);
        paramIntent = new ReportInfo.b();
        paramIntent.aSC = ((int)localncd.xj);
        paramIntent.videoDuration = ((int)paramLong);
        paramIntent.amK = true;
        paramIntent.amJ = mst.a().Eg();
        paramIntent.aSA = n;
        paramIntent.aSD = i3;
        kct.a(paramVideoInfo, i1, 12, (int)localncd.totalPlayTime, paramIntent, localVideoInfo.Wz);
        m += 1;
        break label176;
        str1 = null;
        break;
        label1003:
        j = -1;
        break label77;
        label1009:
        k = 0;
        break label154;
        label1015:
        if (this.apn)
        {
          i = 2;
          break label273;
        }
        i = 1;
        break label273;
        paramIntent = "";
        break label406;
        i = 1;
        break label518;
        bool = false;
        break label535;
        paramIntent = "";
        break label571;
        i = 0;
        break label594;
        i = 0;
        break label637;
        paramIntent = "";
        break label673;
        paramIntent = "";
        break label709;
      }
    }
  }
  
  private void initData()
  {
    boolean bool = true;
    long l = this.mBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    int i;
    if ((this.mBundle.getInt("VIDEO_FROM_TYPE", -1) == 2) || (this.mBundle.getInt("VIDEO_FROM_TYPE", -1) == 3) || (this.mBundle.getInt("VIDEO_FROM_TYPE", -1) == 6) || (this.mBundle.getInt("VIDEO_FROM_TYPE", -1) == 7))
    {
      i = 1;
      if ((l <= 0L) || (i == 0)) {
        break label141;
      }
    }
    for (;;)
    {
      this.apF = bool;
      this.akh = this.mBundle.getString("ARGS_SESSION_ID");
      this.aki = this.mBundle.getString("ARGS_VIDEO_CHANNEL_SESSION_ID");
      this.sd = System.currentTimeMillis();
      this.ad = new HashSet();
      return;
      i = 0;
      break;
      label141:
      bool = false;
    }
  }
  
  public void W(VideoInfo paramVideoInfo) {}
  
  public void X(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.yV())
    {
      localObject = new nce.a(paramVideoInfo).h(paramVideoInfo.Wz).t(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.aHc);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.j != null) {}
      for (paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.j.WT;; paramVideoInfo = "")
      {
        kbp.b(null, "", "0X800A18C", "0X800A18C", 0, 0, "", "", "", ((nce.a)localObject).o(paramVideoInfo).R(2).N(1).a().toJsonString(), false);
        return;
      }
    }
    Object localObject = new nce.a(null, paramVideoInfo.hH, paramVideoInfo.vid, paramVideoInfo.Wz, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV(), paramVideoInfo.getDuration() * 1000L).a(paramVideoInfo.videoReportInfo).N(1).a().toJsonString();
    String str = paramVideoInfo.hH;
    if (!TextUtils.isEmpty(paramVideoInfo.Wz)) {}
    for (paramVideoInfo = paramVideoInfo.Wz;; paramVideoInfo = "0")
    {
      kbp.a(null, str, "0X80078FD", "0X80078FD", 0, 0, "", "", paramVideoInfo, (String)localObject, false);
      return;
    }
  }
  
  public void Y(VideoInfo paramVideoInfo)
  {
    String str1 = new nce.a(null, paramVideoInfo.hH, paramVideoInfo.vid, paramVideoInfo.Wz, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV(), paramVideoInfo.getDuration() * 1000L).a(-1).N(1).a().toJsonString();
    String str2 = paramVideoInfo.hH;
    if (!TextUtils.isEmpty(paramVideoInfo.Wz)) {}
    for (paramVideoInfo = paramVideoInfo.Wz;; paramVideoInfo = "0")
    {
      kbp.a(null, str2, "0X8007410", "0X8007410", 0, 0, "0", "", paramVideoInfo, str1, false);
      return;
    }
  }
  
  public void Z(VideoInfo paramVideoInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (paramVideoInfo.videoReportInfo == null) {
          continue;
        }
        str = paramVideoInfo.videoReportInfo;
        localJSONObject.put("video_report_info", str);
        localJSONObject.put("video_type", 1);
      }
      catch (JSONException localJSONException)
      {
        String str;
        localJSONException.printStackTrace();
        continue;
      }
      kbp.a(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", kct.a("", "", paramVideoInfo.vid, paramVideoInfo.Wz, localJSONObject), false);
      return;
      str = "";
    }
  }
  
  public void aa(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo == null) {
      return;
    }
    String str;
    Object localObject;
    if ((paramVideoInfo.busiType == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      str = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      localObject = new nce.a(str, paramVideoInfo.hH, paramVideoInfo.vid, paramVideoInfo.Wz, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV(), paramVideoInfo.getDuration() * 1000).N(1);
      ((nce.a)localObject).e(paramVideoInfo.algorithmID).c(paramVideoInfo.strategyID).a(-1).a(paramVideoInfo.videoReportInfo);
      ReportInfo.b localb = new ReportInfo.b();
      localb.aSC = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV());
      localb.videoDuration = (paramVideoInfo.getDuration() * 1000);
      localb.aSA = this.mActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      int i = this.mActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      if (this.jdField_a_of_type_Naq$d.f() == null) {
        break label259;
      }
      str = this.jdField_a_of_type_Naq$d.f().Wz;
      label189:
      kct.a(paramVideoInfo, i, 25, -1, localb, str);
      str = ((nce.a)localObject).a().toJsonString();
      localObject = paramVideoInfo.hH;
      if (TextUtils.isEmpty(paramVideoInfo.Wz)) {
        break label264;
      }
    }
    label259:
    label264:
    for (paramVideoInfo = paramVideoInfo.Wz;; paramVideoInfo = "0")
    {
      kbp.a(null, (String)localObject, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, str, false);
      return;
      str = null;
      break;
      str = null;
      break label189;
    }
  }
  
  public void ab(VideoInfo paramVideoInfo)
  {
    int i = 1;
    if (paramVideoInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel_id", 409409);
      if (paramVideoInfo.adM) {
        i = 0;
      }
      localJSONObject.put("type", i);
      if (paramVideoInfo.videoReportInfo == null) {
        break label212;
      }
      str1 = paramVideoInfo.videoReportInfo;
      localJSONObject.put("video_report_info", str1);
      localJSONObject.put("algorithm_id", paramVideoInfo.algorithmID);
      localJSONObject.put("is_display_download_bar", 0);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar == null) {
        break label219;
      }
      str1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.WT;
      label106:
      localJSONObject.put("common_data", str1);
      localJSONObject.put("video_type", 1);
    }
    catch (Exception localException)
    {
      String str1;
      label126:
      String str3;
      label148:
      String str2;
      break label126;
    }
    if ((paramVideoInfo.busiType == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      str1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      str3 = paramVideoInfo.hH;
      if (TextUtils.isEmpty(paramVideoInfo.Wz)) {
        break label231;
      }
    }
    label212:
    label219:
    label231:
    for (str2 = paramVideoInfo.Wz;; str2 = "0")
    {
      kbp.a(null, str3, "0X80091A9", "0X80091A9", 0, 0, "0", "0", str2, kct.a(str1, paramVideoInfo.hH, paramVideoInfo.vid, paramVideoInfo.Wz, localJSONObject), false);
      return;
      str1 = "";
      break;
      str1 = "";
      break label106;
      str1 = null;
      break label148;
    }
  }
  
  public void d(VideoInfo paramVideoInfo, int paramInt)
  {
    ThreadManager.post(new MultiVideoReportManager.2(this, paramVideoInfo, this.mActivity, paramInt), 1, null, true);
  }
  
  public void d(VideoFeedsPlayManager.b paramb)
  {
    String str1;
    if ((paramb.d.busiType == 0) && (paramb.d.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      str1 = paramb.d.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    for (;;)
    {
      try
      {
        String str3 = paramb.d.hH;
        if (!TextUtils.isEmpty(paramb.d.Wz))
        {
          str2 = paramb.d.Wz;
          kbp.a(null, str3, "0X800740D", "0X800740D", 0, 0, "", "", str2, kct.a(str1, paramb.d.hH, paramb.d.vid, paramb.d.Wz, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV(), paramb.d.getDuration() * 1000, new JSONObject().put("video_type", 1)), false);
          return;
        }
        String str2 = "0";
        continue;
        str1 = null;
      }
      catch (Exception paramb)
      {
        return;
      }
    }
  }
  
  public void e(naq.b paramb)
  {
    this.b = paramb;
    Object localObject = this.b.i();
    String str3 = ((VideoInfo)localObject).hH;
    String str4 = ((VideoInfo)localObject).vid;
    String str2 = ((VideoInfo)localObject).Wz;
    String str1;
    int i;
    if ((((VideoInfo)localObject).busiType == 0) && (((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      str1 = ((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      i = this.mBundle.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      int j = this.mBundle.getInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      localObject = new nce.a(str1, str3, str4, str2).e(((VideoInfo)localObject).algorithmID).c(((VideoInfo)localObject).strategyID).b(this.akh).c(this.aki).g(i).a(409409).l(this.b.qn()).a(Boolean.valueOf(((VideoInfo)localObject).adB)).a(((VideoInfo)localObject).videoReportInfo).e(((VideoInfo)localObject).isAD).p(kct.nd()).q(kxm.nR()).K(((VideoInfo)localObject).aHe).L(j).n(0).k(((VideoInfo)localObject).adH).m(((VideoInfo)localObject).WD).N(1);
      if (TextUtils.isEmpty(str2)) {
        break label297;
      }
      str1 = str2;
      label240:
      kbp.b(null, str3, "0X8007412", "0X8007412", 0, 0, String.valueOf(i), null, str1, ((nce.a)localObject).a().toJsonString(), false);
      i = paramb.qn();
      if (i <= this.aVj) {
        break label305;
      }
    }
    for (;;)
    {
      this.aVj = i;
      return;
      str1 = null;
      break;
      label297:
      str1 = "0";
      break label240;
      label305:
      i = this.aVj;
    }
  }
  
  public void g(VideoFeedsPlayManager.b paramb, boolean paramBoolean)
  {
    if (this.mActivity == null) {
      return;
    }
    VideoInfo localVideoInfo = paramb.d;
    Intent localIntent = this.mActivity.getIntent();
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.getVideoDuration();
    int i;
    Object localObject;
    if (this.b != null)
    {
      i = this.b.qn();
      localObject = new ncd();
      if (!paramBoolean) {
        break label152;
      }
    }
    label152:
    for (long l1 = paramb.e.getDuration();; l1 = paramb.e.dc())
    {
      ((ncd)localObject).xj = l1;
      ((ncd)localObject).totalPlayTime = paramb.e.c(paramBoolean);
      this.lu.add(localObject);
      localObject = new ArrayList(this.lu);
      this.lu.clear();
      ThreadManager.excute(new MultiVideoReportManager.1(this, localIntent, localVideoInfo, (List)localObject, paramb, l2, i), 16, null, true);
      return;
      i = 0;
      break;
    }
  }
  
  public void pf(boolean paramBoolean)
  {
    naa.a().aO("multi_video", this.aVj);
    if (this.b == null) {
      return;
    }
    Object localObject = this.b.i();
    int i = this.b.qn();
    if (this.jdField_a_of_type_Naq$d.f() != null)
    {
      str = this.jdField_a_of_type_Naq$d.f().Wz;
      int j = this.mBundle.getInt("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      localObject = new nce.a("", "", "", "").b(this.akh).a(409409).b((System.currentTimeMillis() - this.sd) / 1000L).e(((VideoInfo)localObject).algorithmID).c(((VideoInfo)localObject).strategyID).l(i).r(((VideoInfo)localObject).nb()).s(this.aVj + 1).d(((VideoInfo)localObject).hH).e(((VideoInfo)localObject).vid).f(((VideoInfo)localObject).Wz).g(str).F(j).N(1);
      if (!paramBoolean) {
        break label249;
      }
    }
    label249:
    for (String str = "1";; str = "0")
    {
      kbp.a(null, "", "0X8007DBB", "0X8007DBB", 0, 0, str, "", "", ((nce.a)localObject).a().toJsonString(), false);
      return;
      str = null;
      break;
    }
  }
  
  public void q(VideoFeedsPlayManager.b paramb)
  {
    VideoInfo localVideoInfo;
    if ((paramb != null) && (paramb.d != null))
    {
      localVideoInfo = paramb.d;
      if (this.jdField_a_of_type_Naq$d.f() == null) {
        break label52;
      }
    }
    label52:
    for (paramb = this.jdField_a_of_type_Naq$d.f().Wz;; paramb = null)
    {
      kct.a(localVideoInfo, 409409, 1, -1, null, paramb);
      return;
    }
  }
  
  public void s(VideoFeedsPlayManager.b paramb)
  {
    if ((paramb != null) && (paramb.e != null))
    {
      ncd localncd = new ncd();
      localncd.totalPlayTime = paramb.e.c(true);
      localncd.xj = paramb.e.getDuration();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + localncd.totalPlayTime + ", detailInfo.currentPlayTime = " + localncd.xj);
      }
      this.lu.add(localncd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     naz
 * JD-Core Version:    0.7.0.1
 */