import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.d;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class mwe
  implements VideoFeedsPlayManager.d, VideoFeedsRecyclerView.a
{
  public static final float[] ap = { 1.0F, 1.5F, 2.0F };
  public static final int[] dr = { 2130842626, 2130842625, 2130842627 };
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private mwc jdField_a_of_type_Mwc;
  private int aRA = 5;
  private int aUp;
  private int aVs;
  private int aVt;
  private String akh;
  private String aki;
  private boolean anU;
  private final boolean aol;
  private boolean apF;
  private boolean apn;
  private mss b;
  private Handler bb;
  private VideoInfo e;
  private VideoFeedsPlayManager.b jdField_f_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b;
  private mtg.g jdField_f_of_type_Mtg$g;
  private mtg.g g;
  private VideoInfo k;
  private ArrayList<VideoInfo> lt;
  private ArrayList<ncd> lu = new ArrayList();
  private Activity mActivity;
  private QQAppInterface mApp;
  
  public mwe(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, ArrayList<VideoInfo> paramArrayList)
  {
    this.mActivity = paramActivity;
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.anU = paramBoolean1;
    this.akh = paramString1;
    this.aki = paramString2;
    this.apF = paramBoolean2;
    this.apn = paramBoolean3;
    this.lt = paramArrayList;
    this.bb = new Handler();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this);
    paramVideoFeedsRecyclerView.a(this);
    this.e = ((VideoInfo)this.lt.get(0));
    this.aRA = kxm.nR();
    this.aUp = kct.nd();
    int i = this.mActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    if (Aladdin.getConfig(260).getIntegerFromString("interact_button_style", 0) == 1) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.aol = paramBoolean1;
      if ((i == 4) || (i == 5) || (i == 2) || (i == 1)) {
        this.aRA = 5;
      }
      this.mActivity.getWindow().addFlags(128);
      aTh();
      return;
    }
  }
  
  private void a(Intent paramIntent, VideoInfo paramVideoInfo, List<ncd> paramList, mhu parammhu, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramVideoInfo != null) && (paramIntent != null))
    {
      String str3 = paramVideoInfo.hH;
      String str4 = paramVideoInfo.vid;
      String str1 = paramVideoInfo.Wz;
      String str2;
      int i1;
      int i2;
      int j;
      label77:
      int i4;
      int m;
      label154:
      int n;
      label174:
      ncd localncd;
      int i;
      label271:
      Object localObject;
      label405:
      label501:
      boolean bool;
      if ((paramVideoInfo.busiType == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
      {
        str2 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        i1 = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        i2 = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
        if (!this.apF) {
          break label1085;
        }
        j = 1;
        this.apF = false;
        int i3 = paramIntent.getIntExtra("key_source", -1);
        i4 = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
        int i5 = paramIntent.getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        int i6 = paramIntent.getIntExtra("VIDEO_CHAT_TYPE", 0);
        int i7 = paramIntent.getIntExtra("VIDEO_KANDIAN_TYPE", 0);
        String str5 = paramIntent.getStringExtra("VIDEO_CHAT_UIN");
        if ((TextUtils.isEmpty(paramVideoInfo.WE)) || (!muj.Es())) {
          break label1091;
        }
        m = 1;
        int i8 = paramIntent.getIntExtra("RETURN_SCENE", 0);
        int i9 = paramList.size();
        n = 0;
        if (n >= i9) {
          return;
        }
        localncd = (ncd)paramList.get(n);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsRecommendPresenter", 2, "播放VV上报 totalPlayTime = " + localncd.totalPlayTime + ", currentPlayTime = " + localncd.xj);
        }
        if ((localncd.xj != 0L) || (localncd.totalPlayTime != 0L))
        {
          if (n != 0) {
            break label1097;
          }
          i = 0;
          localObject = new nce.a(str2, str3, str4, str1).d(localncd.totalPlayTime).a(localncd.xj).y(i).z(i9 - 1).w(i3).B(parammhu.aSr).A(parammhu.aSq).D(parammhu.videoHeight).C(parammhu.videoWidth).b(this.akh).c(this.aki).c(paramLong).l(paramInt1).a(409409).a(Boolean.valueOf(paramVideoInfo.adB));
          if (paramVideoInfo.videoReportInfo == null) {
            break label1116;
          }
          paramIntent = paramVideoInfo.videoReportInfo;
          paramIntent = ((nce.a)localObject).a(paramIntent).e(paramVideoInfo.isAD).p(this.aUp).q(this.aRA).e(paramVideoInfo.algorithmID).c(paramVideoInfo.strategyID).E(j).K(paramVideoInfo.aHe).F(i5).g(this.e.Wz).v(i4).L(i2).j(false);
          if ((paramBoolean) || (paramInt2 <= 0)) {
            break label1123;
          }
          i = 1;
          paramIntent = paramIntent.n(i).k(paramVideoInfo.adH).m(paramVideoInfo.WD).S(m);
          if (!paramVideoInfo.yV()) {
            break label1129;
          }
          i = 2;
          label537:
          paramIntent = paramIntent.Y(i);
          if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
            break label1135;
          }
          bool = true;
          label554:
          localObject = paramIntent.l(bool);
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c == null)) {
            break label1141;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c.WT;
          label590:
          paramIntent = ((nce.a)localObject).q(paramIntent);
          if (!paramVideoInfo.yV()) {
            break label1148;
          }
          i = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.aHc;
          label613:
          paramIntent = paramIntent.t(i);
          if ((!paramVideoInfo.yV()) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.appIconUrl)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.appName))) {
            break label1154;
          }
          i = 1;
          label656:
          localObject = paramIntent.Z(i);
          if ((!paramVideoInfo.yV()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h == null)) {
            break label1160;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h.WT;
          label692:
          localObject = ((nce.a)localObject).o(paramIntent);
          if ((!paramVideoInfo.yV()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.k == null)) {
            break label1167;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.k.WT;
          label728:
          paramIntent = ((nce.a)localObject).p(paramIntent).h(this.e.algorithmID).M(kzc.h(this.e.width, this.e.height, this.e.duration)).N(0).b(this.aol).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).ad(i8).m(nbs.a.Fg()).a(paramVideoInfo);
          if (!paramBoolean) {
            paramIntent.m(paramInt2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "play video [video_from_type : " + i4 + ", first_video_row_key : " + this.e.Wz + ", first_video_type : " + i5 + "]");
          }
          if ((paramVideoInfo.busiType == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
            paramIntent.I(i6).J(i7).j(str5);
          }
          localObject = paramIntent.a().toJsonString();
          if (!this.anU) {
            break label1181;
          }
          if (TextUtils.isEmpty(str1)) {
            break label1174;
          }
        }
      }
      label1154:
      label1160:
      label1167:
      label1174:
      for (paramIntent = str1;; paramIntent = "0")
      {
        kbp.b(null, str3, "0X8009297", "0X8009297", 0, 0, String.valueOf(i1), String.valueOf(i2), paramIntent, (String)localObject, false);
        kbp.d("0X8009297", str3, String.valueOf(i1), String.valueOf(i2), "", (String)localObject);
        paramIntent = new ReportInfo.b();
        paramIntent.aSC = ((int)localncd.xj);
        paramIntent.videoDuration = ((int)paramLong);
        paramIntent.amK = true;
        paramIntent.amJ = mst.a().Eg();
        paramIntent.aSA = i1;
        paramIntent.aSD = i4;
        kct.b(paramVideoInfo, i2, 12, (int)localncd.totalPlayTime, paramIntent, this.e.Wz);
        n += 1;
        break label174;
        str2 = null;
        break;
        label1085:
        j = -1;
        break label77;
        label1091:
        m = 0;
        break label154;
        label1097:
        if (this.apn)
        {
          i = 2;
          break label271;
        }
        i = 1;
        break label271;
        label1116:
        paramIntent = "";
        break label405;
        label1123:
        i = 0;
        break label501;
        label1129:
        i = 1;
        break label537;
        label1135:
        bool = false;
        break label554;
        label1141:
        paramIntent = "";
        break label590;
        label1148:
        i = 0;
        break label613;
        i = 0;
        break label656;
        paramIntent = "";
        break label692;
        paramIntent = "";
        break label728;
      }
      label1181:
      if (!TextUtils.isEmpty(str1)) {}
      for (paramIntent = str1;; paramIntent = "0")
      {
        kbp.b(null, str3, "0X8007409", "0X8007409", 0, 0, String.valueOf(i1), String.valueOf(i2), paramIntent, (String)localObject, false);
        kbp.d("0X8007409", str3, String.valueOf(i1), String.valueOf(i2), "", (String)localObject);
        break;
      }
    }
  }
  
  private void aTh()
  {
    int i = this.mActivity.getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
    int j = this.mActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    nce.a locala = new nce.a(this.e);
    locala.N(0).X(i).n(this.e.Wz);
    kbp.b(null, this.e.hH, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", this.e.Wz, locala.a().toJsonString(), false);
  }
  
  private void aTj()
  {
    if (this.k != null)
    {
      nce.a locala = new nce.a(this.k);
      locala.P(this.aVs);
      kbp.a(this.mApp, this.k.hH, "0X8009B79", "0X8009B79", 0, 0, "", "", "", locala.a().toJsonString(), false);
    }
  }
  
  private static boolean c(VideoFeedsPlayManager.b paramb)
  {
    return (paramb != null) && (paramb.d != null) && (paramb.a != null) && (paramb.d.isAD) && (paramb.d.b != null);
  }
  
  public boolean EJ()
  {
    return this.aol;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(VideoFeedsPlayManager.b paramb)
  {
    if (this.b != null) {
      this.b.a(this.g.aUv, paramb, this.lt);
    }
    kbp.a(null, "", "0X800AF11", "0X800AF11", 0, 0, "", "", "", String.valueOf(System.currentTimeMillis()), false);
  }
  
  public void a(VideoFeedsPlayManager.b paramb, int paramInt)
  {
    if ((paramb != null) && (paramb.e != null))
    {
      ncd localncd = new ncd();
      localncd.totalPlayTime = paramb.e.c(true);
      localncd.xj = paramb.e.getDuration();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendPresenter", 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + localncd.totalPlayTime + ", detailInfo.currentPlayTime = " + localncd.xj);
      }
      this.lu.add(localncd);
      if ((c(paramb)) && (this.apn) && (this.mActivity != null)) {
        knr.a(paramb, this.mActivity, paramb.e);
      }
      if (this.b != null) {
        this.b.b(this.g.aUv, paramb, this.lt);
      }
    }
  }
  
  public void a(VideoFeedsPlayManager.b paramb, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(mwc parammwc)
  {
    this.jdField_a_of_type_Mwc = parammwc;
  }
  
  public void aSa() {}
  
  public void aTi()
  {
    int j = 0;
    VideoFeedsPlayManager.b localb;
    int i;
    if (this.g != null)
    {
      localb = this.g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b;
      i = j;
      if (localb != null)
      {
        i = j;
        if (localb.e != null) {
          i = localb.e.qe();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendPresenter", 2, "handlePlayButtonClick() status()=" + i);
      }
    }
    switch (i)
    {
    default: 
    case 0: 
    case 7: 
    case 6: 
    case 3: 
    case 4: 
    case 5: 
      do
      {
        return;
        localb = null;
        break;
        if (c(localb)) {
          localb.a.autoPlay = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(localb, false);
        return;
        if (c(localb)) {
          localb.a.autoPlay = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.o(localb);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(localb, true);
        return;
        String str1;
        if ((localb.d.busiType == 0) && (localb.d.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          str1 = localb.d.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        }
        for (;;)
        {
          try
          {
            String str3 = localb.d.hH;
            if (TextUtils.isEmpty(localb.d.Wz)) {
              continue;
            }
            str2 = localb.d.Wz;
            kbp.a(null, str3, "0X800740D", "0X800740D", 0, 0, "", "", str2, kct.a(str1, localb.d.hH, localb.d.vid, localb.d.Wz, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV(), localb.d.getDuration() * 1000, new JSONObject().put("video_type", 0)), false);
          }
          catch (Exception localException)
          {
            String str2;
            continue;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.pause();
          return;
          str1 = null;
          continue;
          str2 = "0";
        }
        if (c(localb)) {
          localb.a.autoPlay = false;
        }
      } while (localb.o("continue_pause", false));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.restart();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.pause();
      return;
    }
    if (c(localb)) {
      localb.a.autoPlay = false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.start();
  }
  
  public void aTk()
  {
    this.aVt = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.setSpeedRatio(ap[0]);
    if (this.g != null) {
      this.g.jdField_a_of_type_Mrx.sp(dr[this.aVt]);
    }
  }
  
  public void aTl()
  {
    int i;
    if (this.g != null)
    {
      i = this.aVt;
      if (i < ap.length - 1) {
        break label64;
      }
      i = 0;
    }
    for (;;)
    {
      float f1 = ap[i];
      this.aVt = i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.setSpeedRatio(f1);
      this.g.jdField_a_of_type_Mrx.sp(dr[this.aVt]);
      return;
      label64:
      i += 1;
    }
  }
  
  public void b(VideoFeedsPlayManager.b paramb) {}
  
  public void b(mss parammss)
  {
    this.b = parammss;
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_f_of_type_Mtg$g = this.g;
    if ((paramViewHolder instanceof mtg.g))
    {
      this.g = ((mtg.g)paramViewHolder);
      this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b = this.g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b;
      this.k = this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
      if (this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e != null) {
        this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e.aTR();
      }
    }
    for (;;)
    {
      if ((this.jdField_f_of_type_Mtg$g != null) && (this.g != null) && (this.jdField_f_of_type_Mtg$g.aUv > this.g.aUv)) {
        this.aVs += 1;
      }
      aTk();
      return;
      this.g = null;
      this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b = null;
      this.k = null;
    }
  }
  
  public void d(VideoFeedsPlayManager.b paramb) {}
  
  public void g(VideoFeedsPlayManager.b paramb, boolean paramBoolean)
  {
    if (this.mActivity == null) {
      return;
    }
    VideoInfo localVideoInfo = paramb.d;
    Intent localIntent = this.mActivity.getIntent();
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.getVideoDuration();
    int i;
    int j;
    label63:
    boolean bool;
    label83:
    Object localObject;
    if (this.jdField_f_of_type_Mtg$g != null)
    {
      i = this.jdField_f_of_type_Mtg$g.aUv;
      if (this.jdField_f_of_type_Mtg$g == null) {
        break label190;
      }
      j = this.jdField_f_of_type_Mtg$g.position;
      if ((this.jdField_f_of_type_Mtg$g == null) || (!this.jdField_f_of_type_Mtg$g.aos)) {
        break label196;
      }
      bool = true;
      localObject = new ncd();
      if (!paramBoolean) {
        break label202;
      }
    }
    label190:
    label196:
    label202:
    for (long l1 = paramb.e.getDuration();; l1 = paramb.e.dc())
    {
      ((ncd)localObject).xj = l1;
      ((ncd)localObject).totalPlayTime = paramb.e.c(paramBoolean);
      this.lu.add(localObject);
      localObject = new ArrayList(this.lu);
      this.lu.clear();
      ThreadManager.excute(new VideoFeedsRecommendPresenter.1(this, localIntent, localVideoInfo, (List)localObject, paramb, l2, i, j, bool), 16, null, true);
      return;
      i = 0;
      break;
      j = 0;
      break label63;
      bool = false;
      break label83;
    }
  }
  
  public void h(VideoFeedsPlayManager.b paramb, boolean paramBoolean) {}
  
  public void i(VideoFeedsPlayManager.b paramb) {}
  
  public void onDestroyView()
  {
    aTj();
    this.mActivity = null;
    this.mApp = null;
  }
  
  public int pZ()
  {
    return this.aVt;
  }
  
  public void q(VideoFeedsPlayManager.b paramb)
  {
    if ((paramb != null) && (paramb.d != null) && (!this.anU)) {
      kct.b(paramb.d, 409409, 1, -1, null, this.e.Wz);
    }
  }
  
  public void r(VideoFeedsPlayManager.b paramb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwe
 * JD-Core Version:    0.7.0.1
 */