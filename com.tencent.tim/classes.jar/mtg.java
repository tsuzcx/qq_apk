import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;
import com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.VideoInfo.a;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.12;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAioGuideView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout.a;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView.a;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class mtg
  extends RecyclerView.Adapter<mtg.e>
  implements View.OnClickListener, View.OnLongClickListener, VideoFeedsGestureLayout.a, mwc.a, naf, nag
{
  private Set<String> M = new HashSet();
  private Animation U;
  private RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
  private auug jdField_a_of_type_Auug;
  private auuw jdField_a_of_type_Auuw;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  public VideoFeedsRecyclerView.a a;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  public GdtHandler.Params a;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new mti(this);
  private mst jdField_a_of_type_Mst;
  private mtg.d jdField_a_of_type_Mtg$d;
  mtg.i jdField_a_of_type_Mtg$i;
  private mtw jdField_a_of_type_Mtw;
  private mvj jdField_a_of_type_Mvj;
  private mvn jdField_a_of_type_Mvn;
  private mwc jdField_a_of_type_Mwc;
  private mwe jdField_a_of_type_Mwe;
  private mxi jdField_a_of_type_Mxi;
  private mxu jdField_a_of_type_Mxu;
  private nce.a jdField_a_of_type_Nce$a;
  private int aRA = 5;
  private int aUo = 1;
  private int aUp;
  private int aUq;
  private int aUr;
  private int aUs;
  private Set<String> ad = new HashSet();
  private Set<String> ae = new HashSet();
  private String akh;
  private String aki;
  private boolean anU;
  private boolean anV;
  private boolean anW = true;
  private boolean anX;
  private boolean anY = true;
  private boolean anZ;
  private boolean aoa = true;
  private boolean aob;
  private boolean aoc;
  private boolean aod;
  private boolean aoe;
  private boolean aof;
  private boolean aog;
  private boolean aoh;
  private boolean aoi;
  private boolean aoj;
  private boolean aok;
  private final boolean aol;
  private boolean aom;
  private boolean aon;
  private boolean aoo = true;
  private kmh jdField_b_of_type_Kmh;
  private mrp jdField_b_of_type_Mrp;
  private mss jdField_b_of_type_Mss;
  private msx jdField_b_of_type_Msx;
  private mtg.g jdField_b_of_type_Mtg$g;
  private mtg.l jdField_b_of_type_Mtg$l;
  private mud jdField_b_of_type_Mud;
  private mxm jdField_b_of_type_Mxm;
  private Drawable cC;
  private Drawable cG;
  private VideoInfo e;
  public HashMap<String, Integer> ek = new HashMap();
  private Map<Integer, Bitmap> ey = new ConcurrentHashMap();
  private ColorDrawable f;
  private Activity mActivity;
  private QQAppInterface mApp;
  private Context mContext;
  private List<VideoInfo> mDataList;
  private int mFromType;
  private boolean mIsFullScreen;
  private LinearLayoutManager mLayoutManager;
  private Handler mUIHandler = new mtj(this, Looper.getMainLooper());
  private VideoPreDownloadMgr mVideoPreDownloadMgr;
  public long sr = -2147483648L;
  private long wM;
  private long wN;
  
  public mtg(Context paramContext, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, LinearLayoutManager paramLinearLayoutManager, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, int paramInt, mwe parammwe)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView$a = new mtk(this);
    this.mContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.mActivity = paramActivity;
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView$a);
    this.mLayoutManager = paramLinearLayoutManager;
    this.cC = aqhu.c(true);
    this.f = new ColorDrawable(this.mContext.getResources().getColor(2131165381));
    this.jdField_a_of_type_Mst = mst.a();
    this.jdField_b_of_type_Msx = new msx(paramActivity);
    this.jdField_a_of_type_Mvj = new mvj(this.mApp, this.mActivity);
    this.akh = paramString1;
    this.aki = paramString2;
    this.anU = paramBoolean;
    this.mFromType = paramInt;
    this.jdField_a_of_type_Auug = new auug(this.mActivity);
    AppNetConnInfo.registerConnectionChangeReceiver(this.mActivity.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.cG = new ColorDrawable(1930498322);
    this.jdField_a_of_type_Mwe = parammwe;
    setHasStableIds(true);
    registerAdapterDataObserver(new mtg.c(null));
    this.aok = anlm.ayn();
    this.jdField_b_of_type_Kmh = new kmh(paramActivity, this);
    if (Aladdin.getConfig(260).getIntegerFromString("interact_button_style", 0) == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.aol = paramBoolean;
      return;
    }
  }
  
  @NonNull
  private String a(VideoInfo paramVideoInfo, Resources paramResources)
  {
    return knd.a(this.mActivity, paramVideoInfo, paramResources);
  }
  
  private void a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, int paramInt)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if ((localViewHolder instanceof mtg.l))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((mtg.l)localViewHolder).position);
        if ((localVideoInfo.yV()) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.aHc == paramInt)) {
          ((mtg.l)localViewHolder).jdField_a_of_type_Mrx.f(localVideoInfo);
        }
      }
      i += 1;
    }
  }
  
  private void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.isPlaying())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.pause();
    }
    if (this.jdField_b_of_type_Kmh != null) {
      this.jdField_b_of_type_Kmh.a(paramView, paramInt, paramVideoInfo);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    ods.b(this.mActivity, paramAdvertisementInfo, null, 3, true, null);
    paramAdvertisementInfo = jzk.a(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo);
    jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(jzk.aFJ).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(VideoInfo paramVideoInfo, String paramString)
  {
    if ((this.jdField_b_of_type_Mtg$g != null) && (this.jdField_b_of_type_Mtg$g.jR != null) && (this.jdField_b_of_type_Mtg$g.jR.getVisibility() == 0)) {
      kbp.a(null, "", paramString, paramString, 0, 0, "", "", "", new nce.a(paramVideoInfo).a(this.jdField_a_of_type_Mwe.pZ()).b(this.aol).c(paramVideoInfo.duration).N(0).a(paramVideoInfo.videoReportInfo).M(kzc.h(this.e.width, this.e.height, this.e.duration)).a().toJsonString(), false);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, nce.a parama)
  {
    boolean bool = true;
    Object localObject2;
    if (this.anU)
    {
      localObject2 = paramVideoInfo.hH;
      if (!TextUtils.isEmpty(paramVideoInfo.Wz)) {}
      for (localObject1 = paramVideoInfo.Wz;; localObject1 = "0")
      {
        kbp.b(null, (String)localObject2, "0X8009298", "0X8009298", 0, 0, "0", "", (String)localObject1, parama.a().toJsonString(), false);
        a(paramVideoInfo, "0X800AD00");
        return;
      }
    }
    int i;
    if ((!TextUtils.isEmpty(paramVideoInfo.WE)) && (muj.Es()))
    {
      i = 1;
      label97:
      localObject1 = parama.S(i);
      if (!paramVideoInfo.yV()) {
        break label390;
      }
      i = 2;
      label113:
      localObject1 = ((nce.a)localObject1).Y(i);
      if (!paramVideoInfo.yV()) {
        break label395;
      }
      i = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.aHc;
      label136:
      localObject1 = ((nce.a)localObject1).t(i);
      if ((!paramVideoInfo.yV()) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.appIconUrl)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.appName))) {
        break label400;
      }
      i = 1;
      label179:
      localObject2 = ((nce.a)localObject1).Z(i);
      if ((!paramVideoInfo.yV()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h == null)) {
        break label405;
      }
      localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h.WT;
      label216:
      localObject2 = ((nce.a)localObject2).o((String)localObject1);
      if ((!paramVideoInfo.yV()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.k == null)) {
        break label413;
      }
      localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.k.WT;
      label254:
      localObject1 = ((nce.a)localObject2).p((String)localObject1);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
        break label421;
      }
      label270:
      localObject2 = ((nce.a)localObject1).l(bool);
      if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c == null)) {
        break label427;
      }
      localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c.WT;
      label308:
      ((nce.a)localObject2).q((String)localObject1).b(this.aol).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo);
      localObject2 = paramVideoInfo.hH;
      if (TextUtils.isEmpty(paramVideoInfo.Wz)) {
        break label435;
      }
    }
    label390:
    label395:
    label400:
    label405:
    label413:
    label421:
    label427:
    label435:
    for (Object localObject1 = paramVideoInfo.Wz;; localObject1 = "0")
    {
      kbp.b(null, (String)localObject2, "0X8007801", "0X8007801", 0, 0, "0", "", (String)localObject1, parama.a().toJsonString(), false);
      break;
      i = 0;
      break label97;
      i = 1;
      break label113;
      i = 0;
      break label136;
      i = 0;
      break label179;
      localObject1 = "";
      break label216;
      localObject1 = "";
      break label254;
      bool = false;
      break label270;
      localObject1 = "";
      break label308;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramVideoInfo == null) {
      return;
    }
    c(paramVideoInfo, paramBoolean2);
    Object localObject1;
    if ((paramVideoInfo.busiType == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      localObject1 = new nce.a((String)localObject1, paramVideoInfo.hH, paramVideoInfo.vid, paramVideoInfo.Wz, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV(), paramVideoInfo.getDuration() * 1000);
      ((nce.a)localObject1).h(paramBoolean1).i(paramBoolean2).b(this.aol);
      if (!this.anU)
      {
        ((nce.a)localObject1).e(paramVideoInfo.algorithmID).c(paramVideoInfo.strategyID).a(-1).a(paramVideoInfo.videoReportInfo).N(0);
        localObject2 = new ReportInfo.b();
        ((ReportInfo.b)localObject2).aSC = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV());
        ((ReportInfo.b)localObject2).videoDuration = (paramVideoInfo.getDuration() * 1000);
        ((ReportInfo.b)localObject2).aSA = this.mActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        kct.b(paramVideoInfo, this.mActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1), 25, -1, (ReportInfo.b)localObject2, this.e.Wz);
      }
      localObject1 = ((nce.a)localObject1).a().toJsonString();
      if (!this.anU) {
        break label290;
      }
      localObject2 = paramVideoInfo.hH;
      if (TextUtils.isEmpty(paramVideoInfo.Wz)) {
        break label283;
      }
    }
    label283:
    for (paramVideoInfo = paramVideoInfo.Wz;; paramVideoInfo = "0")
    {
      kbp.a(null, (String)localObject2, "0X8009299", "0X8009299", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
      localObject1 = null;
      break;
    }
    label290:
    Object localObject2 = paramVideoInfo.hH;
    if (!TextUtils.isEmpty(paramVideoInfo.Wz)) {}
    for (paramVideoInfo = paramVideoInfo.Wz;; paramVideoInfo = "0")
    {
      kbp.a(null, (String)localObject2, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
    }
  }
  
  private void a(VideoFeedsUGView paramVideoFeedsUGView, boolean paramBoolean)
  {
    if (paramVideoFeedsUGView != null) {
      paramVideoFeedsUGView.setActive(paramBoolean);
    }
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, VideoInfo paramVideoInfo)
  {
    if ((paramKandianUrlImageView == null) || (paramVideoInfo == null)) {
      return;
    }
    if ((!muj.Es()) || (TextUtils.isEmpty(paramVideoInfo.WE)))
    {
      paramKandianUrlImageView.setVisibility(8);
      return;
    }
    Object localObject;
    if (paramVideoInfo.WE.endsWith("zip"))
    {
      localObject = lae.a(paramVideoInfo.WE);
      ((lae)localObject).setRepeatCount(0);
      paramKandianUrlImageView.setImageDrawable((Drawable)localObject);
      if ((paramKandianUrlImageView.getVisibility() == 8) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.isPlaying()) && (this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d == paramVideoInfo)) {
        ((lae)localObject).playAnimation();
      }
    }
    for (;;)
    {
      paramKandianUrlImageView.setVisibility(0);
      return;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      paramKandianUrlImageView.setImageDrawable(URLDrawable.getDrawable(paramVideoInfo.WE, (URLDrawable.URLDrawableOptions)localObject));
    }
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, VideoInfo paramVideoInfo, Boolean paramBoolean)
  {
    int[] arrayOfInt;
    if (paramKandianUrlImageView.getVisibility() == 0)
    {
      arrayOfInt = paramVideoInfo.a(this.mActivity, paramBoolean.booleanValue());
      if ((arrayOfInt[0] >= 0) && (arrayOfInt[1] >= 0)) {}
    }
    else
    {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramKandianUrlImageView.getLayoutParams();
    localLayoutParams.topMargin = arrayOfInt[0];
    localLayoutParams.rightMargin = arrayOfInt[1];
    if ((paramBoolean.booleanValue()) || (paramVideoInfo.k(this.mActivity))) {
      localLayoutParams.width = wja.dp2px(91.0F, this.mActivity.getResources());
    }
    for (localLayoutParams.height = wja.dp2px(28.0F, this.mActivity.getResources());; localLayoutParams.height = wja.dp2px(24.0F, this.mActivity.getResources()))
    {
      paramKandianUrlImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = wja.dp2px(78.0F, this.mActivity.getResources());
    }
  }
  
  private void a(mtg.b paramb)
  {
    int i;
    Object localObject;
    if ((paramb != null) && (paramb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (paramb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null) && (paramb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i = knc.e(jzk.a(paramb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i != 1) {
        break label84;
      }
      paramb = paramb.ly;
      localObject = (LinearLayout.LayoutParams)paramb.getLayoutParams();
      if (localObject != null)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
        paramb.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label84:
    do
    {
      do
      {
        return;
      } while (i != 2);
      localObject = paramb.lz;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.weight = 0.0F;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      paramb = paramb.lA;
      localObject = (LinearLayout.LayoutParams)paramb.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramb.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void a(mtg.b paramb, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View[] paramArrayOfView1, View[] paramArrayOfView2)
  {
    int i = 8;
    int j = 0;
    if (paramVideoInfo.isAD)
    {
      if ((!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (!knc.d(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo))) {
        break label318;
      }
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.d(paramVideoInfo)) {
        break label130;
      }
      ods.b(this.mActivity, paramAdvertisementInfo, null, 3, true, null);
      if (paramInt == jzk.aFJ)
      {
        paramb = jzk.a(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo);
        jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(jzk.aFJ).a(paramb).a(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo).d(jzk.aGy).a());
      }
    }
    else
    {
      return;
    }
    c(paramVideoInfo, jzk.aGg);
    return;
    label130:
    knd.a(paramAdvertisementInfo, 0, null);
    int k = paramArrayOfView1.length;
    i = 0;
    while (i < k)
    {
      paramArrayOfView1[i].setVisibility(0);
      i += 1;
    }
    paramb.aor = true;
    k = paramArrayOfView2.length;
    i = j;
    while (i < k)
    {
      paramArrayOfView2[i].setVisibility(8);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.click();
    if (paramInt == jzk.aFJ)
    {
      jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(jzk.aFV).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo).d(jzk.aGy).a());
      return;
    }
    jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(jzk.aFV).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo).a());
    return;
    label318:
    if (paramInt == jzk.aFJ)
    {
      paramInt = 38;
      paramb = jzk.a(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo);
      jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(jzk.aFJ).a(paramb).a(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo).d(jzk.aGy).a());
    }
    for (;;)
    {
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(paramInt);
      }
      paramb = new kks();
      paramb.afZ = true;
      ods.b(this.mActivity, paramAdvertisementInfo, null, 3, true, paramb);
      return;
      paramInt = i;
      if (this.aob) {
        paramInt = 13;
      }
      c(paramVideoInfo, jzk.aGg);
    }
  }
  
  private void a(mtg.b paramb, boolean paramBoolean1, boolean paramBoolean2, View paramView1, View paramView2, TextView paramTextView1, Drawable paramDrawable1, Drawable paramDrawable2, View paramView3, TextView paramTextView2)
  {
    if (paramView1 != null) {
      paramView1.setVisibility(8);
    }
    if (paramBoolean2)
    {
      paramView2.setVisibility(0);
      paramView2.getParent().requestDisallowInterceptTouchEvent(true);
      paramView2.setOnClickListener(this);
      paramView2.setTag(paramb);
      Object localObject = null;
      paramView1 = localObject;
      if (paramTextView1 != null)
      {
        paramView1 = localObject;
        if (paramb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null)
        {
          paramView1 = a(paramb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d, this.mContext.getResources());
          paramTextView1.setText(paramView1);
        }
      }
      if (!paramBoolean1) {
        break label123;
      }
      paramView2.setBackgroundDrawable(paramDrawable1);
    }
    for (this.aob = true;; this.aob = false)
    {
      a(paramBoolean1, paramView3, paramTextView2, paramView1);
      return;
      label123:
      if ((knc.zR()) && (paramDrawable2 != null)) {
        paramView2.setBackgroundDrawable(paramDrawable2);
      }
    }
  }
  
  private void a(mtg.e parame, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View paramView, View... paramVarArgs)
  {
    int i = 0;
    if ((paramVideoInfo.isAD) && (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (knc.d(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo)))
    {
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.d(paramVideoInfo)) {
        break label118;
      }
      ods.b(this.mActivity, paramAdvertisementInfo, null, 3, true, null);
      if (paramInt == jzk.aFJ) {
        jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(jzk.aFJ).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo).d(jzk.aGy).a());
      }
    }
    else
    {
      return;
    }
    c(paramVideoInfo, jzk.aGg);
    return;
    label118:
    paramView.setVisibility(0);
    ((mtg.b)parame).aor = true;
    paramInt = i;
    while (paramInt < paramVarArgs.length)
    {
      paramVarArgs[paramInt].setVisibility(8);
      paramInt += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.click();
  }
  
  private void a(mtg.g paramg, VideoInfo paramVideoInfo)
  {
    VideoFeedsPlayManager.b localb2 = paramg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b;
    VideoFeedsPlayManager.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new VideoFeedsPlayManager.b();
      localb1.jdField_a_of_type_Msa = paramg.jdField_a_of_type_Mxy;
      localb1.extraData.putInt("jump_from_scene", this.mActivity.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0));
    }
    localb1.d = paramVideoInfo;
    localb1.aVm = paramVideoInfo.k(this.mActivity);
    localb1.videoLayout = paramg.videoLayout;
    localb1.aVn = paramg.aUv;
    localb1.apw = false;
    localb1.extraData.putInt("video_feeds_index", paramg.aUv);
    localb1.startPosition = 0L;
    localb1.apx = true;
    if (paramVideoInfo.isAD)
    {
      if (!paramVideoInfo.j(this.mActivity)) {
        break label170;
      }
      localb1.extraData.putInt("ad_origin", jzk.aFA);
    }
    for (;;)
    {
      paramg.jdField_a_of_type_Mxy.aqa = true;
      paramg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b = localb1;
      paramg.jdField_a_of_type_Nca.a(this, paramg);
      return;
      label170:
      localb1.extraData.putInt("ad_origin", jzk.aFy);
    }
  }
  
  private void a(mtg.g paramg1, mtg.g paramg2)
  {
    VideoInfo localVideoInfo;
    nce.a locala1;
    if ((paramg2 != null) && (paramg2.aUv == paramg1.aUv))
    {
      localVideoInfo = paramg1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
      locala1 = new nce.a(paramg1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d);
      locala1.h(localVideoInfo.Wz).l(this.mApp.getCurrentAccountUin()).m(paramg1.position).l(paramg1.aUv);
      if (paramg1.position != paramg2.position + 1) {
        break label124;
      }
      kbp.a(this.mApp, localVideoInfo.hH, "0X8009952", "0X8009952", 0, 0, "", "", "", locala1.a().toJsonString(), false);
    }
    label124:
    while (paramg1.position != paramg2.position - 1) {
      return;
    }
    nce.a locala2 = locala1.o(0);
    if (paramg2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null) {}
    for (paramg1 = paramg2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.Wz;; paramg1 = "")
    {
      locala2.h(paramg1);
      kbp.a(this.mApp, localVideoInfo.hH, "0X8009953", "0X8009953", 0, 0, "", "", "", locala1.a().toJsonString(), false);
      return;
    }
  }
  
  private void a(mtg.g paramg1, mtg.g paramg2, boolean paramBoolean)
  {
    Activity localActivity = this.mActivity;
    VideoInfo localVideoInfo = paramg1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
    int i = paramg1.position;
    int j = paramg1.aUv;
    int k = paramg1.itemType;
    ThreadManager.post(new VideoFeedsAdapter.4(this, localVideoInfo, localActivity, j, paramg1.aos, i, paramBoolean, k, paramg1, paramg2), 1, null, true);
  }
  
  private void a(mtg.i parami)
  {
    if (this.aUo == 1)
    {
      parami.bl.setVisibility(0);
      parami.C.setVisibility(0);
      parami.rI.setVisibility(0);
      parami.rI.setText(bt(1));
    }
    do
    {
      return;
      if (this.aUo == 2)
      {
        parami.bl.setVisibility(0);
        parami.C.setVisibility(8);
        parami.rI.setVisibility(0);
        parami.rI.setText(bt(2));
        return;
      }
    } while (this.aUo != 3);
    if (parami.itemType == 6)
    {
      parami.bl.setVisibility(0);
      parami.C.setVisibility(0);
      parami.rI.setVisibility(0);
      parami.rI.setText(bt(1));
      return;
    }
    parami.bl.setVisibility(8);
    parami.C.setVisibility(8);
    parami.rI.setVisibility(8);
  }
  
  private void a(mtg.l paraml, VideoInfo paramVideoInfo)
  {
    if (anwa.aze()) {}
    do
    {
      do
      {
        return;
        if (paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) {
          paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.reset();
        }
        if (paraml.b != null) {
          paraml.b.reset();
        }
      } while ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a == null) && (paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a == null));
      if ((paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a != null) && ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.aHw == 1) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.aHw == 2))) {
        paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.setInfo(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a, paramVideoInfo.title, "VideoPlay_ContentMix");
      }
    } while ((paraml.b == null) || (paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a == null) || ((paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.aHw != 1) && (paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.aHw != 2)));
    paraml.b.setInfo(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a, paramVideoInfo.title, "VideoPlay_Shooting");
  }
  
  private void a(mtg.l paraml, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.wM != 0L) {
        ThreadManager.excute(new VideoFeedsAdapter.1(this, paramLong), 16, null, true);
      }
      if ((paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.c != null))
      {
        paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.c.vE = paramLong;
        paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.c.aSw = kxm.b(paramInt, paraml.aUv, false);
      }
      if ((paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.jdField_a_of_type_Mht != null)) {
        paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.jdField_a_of_type_Mht.autoPlay = true;
      }
    }
  }
  
  private void a(boolean paramBoolean, View paramView, TextView paramTextView, String paramString)
  {
    if ((paramView == null) || (paramTextView == null)) {}
    do
    {
      do
      {
        return;
        if (!knc.zR()) {
          break;
        }
        paramView.setVisibility(8);
        paramTextView.setVisibility(0);
      } while (TextUtils.isEmpty(paramString));
      paramTextView.setText(paramString);
      return;
      if (!paramBoolean) {
        break;
      }
      paramView.setVisibility(8);
      paramTextView.setVisibility(0);
    } while (TextUtils.isEmpty(paramString));
    paramTextView.setText(paramString);
    return;
    paramView.setVisibility(0);
    paramTextView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, mtg.b paramb)
  {
    if (!b(paramb)) {
      return;
    }
    TextView localTextView1 = paramb.rm;
    View localView = paramb.lv;
    TextView localTextView2 = paramb.rn;
    if (localView != null) {}
    for (boolean bool = true;; bool = false)
    {
      GradientDrawable localGradientDrawable1 = new GradientDrawable();
      localGradientDrawable1.setColor(Color.parseColor("#FF12B7F6"));
      localGradientDrawable1.setCornerRadius(wja.dp2px(4.0F, this.mActivity.getResources()));
      GradientDrawable localGradientDrawable2 = new GradientDrawable();
      if (knc.zR())
      {
        localGradientDrawable1.setColor(Color.parseColor("#FF12B7F6"));
        localGradientDrawable1.setCornerRadius(wja.dp2px(6.0F, this.mActivity.getResources()));
        localGradientDrawable2.setColor(Color.parseColor("#33FFFFFF"));
        localGradientDrawable2.setCornerRadius(wja.dp2px(6.0F, this.mActivity.getResources()));
      }
      a(paramb, paramBoolean, bool, localTextView1, localView, localTextView2, localGradientDrawable1, localGradientDrawable2, paramb.lw, paramb.ro);
      return;
    }
  }
  
  private void a(boolean paramBoolean, mtg.l paraml)
  {
    if (!(paraml instanceof mtg.b)) {
      return;
    }
    paraml = (mtg.b)paraml;
    int i;
    if ((paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null) && (knc.c(paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo)) && (!paraml.aor))
    {
      a(paramBoolean, paraml);
      if (paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null)
      {
        if (!c(paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d)) {
          break label335;
        }
        i = 8;
        label82:
        if (!c(paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d)) {
          break label340;
        }
      }
    }
    label335:
    label340:
    for (int j = 0;; j = 8)
    {
      paraml.rm.setVisibility(i);
      paraml.fi.setVisibility(j);
      if (knc.zR()) {
        paraml.rm.setVisibility(8);
      }
      if (paraml.lx != null)
      {
        paraml.lx.setOnClickListener(this);
        paraml.lx.getParent().requestDisallowInterceptTouchEvent(true);
        paraml.lx.setTag(paraml);
      }
      if (paraml.lM != null)
      {
        paraml.lM.setOnClickListener(this);
        paraml.lM.getParent().requestDisallowInterceptTouchEvent(true);
        paraml.lM.setTag(paraml);
      }
      if ((paraml.e != null) && (!paraml.aor)) {
        paraml.e.setVisibility(0);
      }
      if ((paraml.lx != null) && (!paraml.aor)) {
        paraml.lx.setVisibility(8);
      }
      if ((paraml.lx != null) && (c(paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d)))
      {
        paraml.lx.setVisibility(8);
        paraml.lv.setVisibility(8);
      }
      if ((paraml.lx != null) && (paraml.lx.getVisibility() == 0))
      {
        paraml.rm.setVisibility(8);
        paraml.lv.setVisibility(8);
      }
      a(paraml);
      return;
      b(paramBoolean, paraml);
      break;
      i = 0;
      break label82;
    }
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, VideoInfo paramVideoInfo)
  {
    int j = paramRecyclerView.getChildCount();
    int k = paramList.indexOf(paramVideoInfo);
    int i = 0;
    while (i < j)
    {
      paramList = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if ((k >= 0) && ((paramList instanceof mtg.l)) && (((mtg.l)paramList).position == k))
      {
        ((mtg.l)paramList).jdField_a_of_type_Mrx.f(paramVideoInfo);
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, String paramString)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if ((localViewHolder instanceof mtg.l))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((mtg.l)localViewHolder).position);
        if (paramString.equals(localVideoInfo.hH)) {
          ((mtg.l)localViewHolder).jdField_a_of_type_Mrx.f(localVideoInfo);
        }
      }
      i += 1;
    }
    return false;
  }
  
  private boolean a(VideoInfo paramVideoInfo, String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramVideoInfo.hH != null)
    {
      bool1 = bool3;
      if (paramVideoInfo.hH.equals(paramString))
      {
        bool1 = bool2;
        if (!paramVideoInfo.isFollowed) {
          bool1 = true;
        }
        paramVideoInfo.isFollowed = true;
      }
    }
    return bool1;
  }
  
  private boolean a(mtg.l paraml)
  {
    boolean bool4 = true;
    boolean bool2 = true;
    boolean bool3 = false;
    paraml.jdField_a_of_type_Mxy.aqa = false;
    boolean bool1 = bool2;
    Bundle localBundle;
    int j;
    if (paraml.aUv == this.aUq)
    {
      bool1 = bool2;
      if (this.mContext != null)
      {
        bool1 = bool2;
        if (paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null)
        {
          bool1 = bool2;
          if (paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null)
          {
            localBundle = this.mActivity.getIntent().getExtras();
            j = localBundle.getInt("VIDEO_FROM_TYPE", 0);
            if (aqiw.isMobileNetWork(this.mContext)) {
              break label138;
            }
            i = 1;
            if ((i == 0) && (!this.anZ)) {
              break label143;
            }
          }
        }
      }
    }
    label138:
    label143:
    for (int i = 1;; i = 0)
    {
      if ((this.mApp == null) || (!this.mApp.bF())) {
        break label148;
      }
      bool1 = false;
      return bool1;
      i = 0;
      break;
    }
    label148:
    if (j == 27)
    {
      if (Aladdin.getConfig(271).getIntegerFromString("auto_play", 1) == 1)
      {
        paraml = paraml.jdField_a_of_type_Mxy;
        bool1 = bool3;
        if (i == 0) {
          bool1 = true;
        }
        paraml.aqa = bool1;
        return true;
      }
      paraml = paraml.jdField_a_of_type_Mxy;
      if (i == 0) {}
      for (bool1 = bool4;; bool1 = false)
      {
        paraml.aqa = bool1;
        return false;
      }
    }
    if (i != 0)
    {
      paraml.jdField_a_of_type_Mxy.aqa = false;
      return true;
    }
    i = localBundle.getInt("VIDEO_PLAY_STATUS", 0);
    paraml = paraml.jdField_a_of_type_Mxy;
    if (((2 != j) && (6 != j) && (5 != j)) || (3 != i))
    {
      bool1 = true;
      label275:
      paraml.aqa = bool1;
      if ((j != 0) && (1 != j) && (12 != j) && (11 != j)) {
        break label320;
      }
    }
    label320:
    for (i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i == 0) {
        break;
      }
      return false;
      bool1 = false;
      break label275;
    }
  }
  
  private void aRX()
  {
    this.mVideoPreDownloadMgr = new VideoPreDownloadMgr(this.mActivity.getApplicationContext());
    this.mVideoPreDownloadMgr.a = new myn(myn.aWc, myn.aWf);
    this.mVideoPreDownloadMgr.a(new mth(this));
  }
  
  private void aRY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "handleNotNetWorkChange mIsActivityOnResume = " + this.anW);
    }
    if (!this.anW) {}
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.oD(false);
  }
  
  private void ai(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount() uin=" + paramString);
    }
    if ((paramString == null) || (this.mApp == null)) {}
    do
    {
      return;
      muj.a(this.mApp, paramString, paramBoolean);
      Iterator localIterator = this.mDataList.iterator();
      paramBoolean = false;
      while (localIterator.hasNext())
      {
        Object localObject = (VideoInfo)localIterator.next();
        boolean bool = paramBoolean | a((VideoInfo)localObject, paramString);
        paramBoolean = bool;
        if (((VideoInfo)localObject).jT != null)
        {
          localObject = ((VideoInfo)localObject).jT.iterator();
          for (;;)
          {
            paramBoolean = bool;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            bool = a((VideoInfo)((Iterator)localObject).next(), paramString) | bool;
          }
        }
      }
      if (paramBoolean) {
        nS(paramString);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount() isDataChanged=" + paramBoolean);
  }
  
  private void akG()
  {
    this.mUIHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.stop(false);
  }
  
  private String b(VideoInfo paramVideoInfo, int paramInt)
  {
    return knd.a(this.mActivity, paramVideoInfo, paramInt);
  }
  
  private void b(VideoAdInfo paramVideoAdInfo)
  {
    paramVideoAdInfo = jzk.a(paramVideoAdInfo);
    if (paramVideoAdInfo != null) {
      ods.h(this.mActivity, paramVideoAdInfo.mPopFormH5Url, paramVideoAdInfo.mAdRl, paramVideoAdInfo.mAdTraceId);
    }
  }
  
  private void b(mtg.b paramb)
  {
    int i;
    Object localObject;
    if ((paramb != null) && (paramb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (paramb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null) && (paramb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i = knc.e(jzk.a(paramb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i != 1) {
        break label88;
      }
      paramb = paramb.lG;
      if (paramb != null)
      {
        localObject = (LinearLayout.LayoutParams)paramb.getLayoutParams();
        if (localObject != null)
        {
          ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
          paramb.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    label88:
    do
    {
      do
      {
        do
        {
          return;
        } while (i != 2);
        localObject = paramb.lH;
        if (localObject != null)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.weight = 0.0F;
            ((View)localObject).setLayoutParams(localLayoutParams);
          }
        }
        paramb = paramb.lI;
      } while (paramb == null);
      localObject = (LinearLayout.LayoutParams)paramb.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramb.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(mtg.g paramg)
  {
    if ((this.jdField_b_of_type_Mtg$g != null) && (this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e != null))
    {
      myi localmyi = this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e;
      if ((!localmyi.isIdle()) && (!localmyi.ER()) && (!localmyi.isPrepared()) && (this.jdField_b_of_type_Mtg$g.aUv == paramg.aUv - 1) && (awit.J(this.mApp)) && (naa.a().b(this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.m(paramg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b);
      }
    }
  }
  
  private void b(boolean paramBoolean, mtg.b paramb)
  {
    if (knc.zR()) {
      a(paramBoolean, paramb);
    }
    while (!b(paramb)) {
      return;
    }
    View localView = paramb.lv;
    TextView localTextView = paramb.rm;
    if ((localTextView != null) && (!paramb.aor)) {}
    for (boolean bool = true;; bool = false)
    {
      ColorDrawable localColorDrawable = new ColorDrawable();
      localColorDrawable.setColor(Color.parseColor("#FF12B7F6"));
      new GradientDrawable().setColor(Color.parseColor("#33FFFFFF"));
      a(paramb, paramBoolean, bool, localView, localTextView, localTextView, localColorDrawable, null, paramb.lw, paramb.ro);
      return;
    }
  }
  
  private boolean b(mtg.b paramb)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramb != null)
    {
      bool2 = bool1;
      if (paramb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null)
      {
        if (paramb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null) {
          break label34;
        }
        bool2 = bool1;
      }
    }
    label34:
    do
    {
      return bool2;
      Object localObject = paramb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
      bool1 = bool3;
      if (((VideoInfo)localObject).isAD)
      {
        localObject = jzk.a(((VideoInfo)localObject).jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo);
        bool1 = bool3;
        if (localObject != null)
        {
          bool1 = bool3;
          if (!((AdvertisementInfo)localObject).mShowAdButton)
          {
            if (paramb.rm != null) {
              paramb.rm.setVisibility(8);
            }
            if (paramb.lv != null) {
              paramb.lv.setVisibility(8);
            }
            bool1 = false;
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "showButton = " + bool1);
    return bool1;
  }
  
  private String bt(int paramInt)
  {
    if (paramInt == 1) {}
    while (paramInt != 2) {
      return null;
    }
    return null;
  }
  
  private void c(VideoInfo paramVideoInfo, int paramInt)
  {
    if (paramVideoInfo == null) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = jzk.a(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo);
    if (paramVideoInfo.j(this.mActivity))
    {
      jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(jzk.aFA).a(localAdvertisementInfo).a(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
      return;
    }
    jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(jzk.aFy).a(localAdvertisementInfo).a(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = new Intent(this.mActivity, ReadInJoyDeliverBiuActivity.class);
      if ((paramVideoInfo.busiType == 6) && (paramVideoInfo.articleInfo != null)) {
        localIntent.putExtra("feedsType", paramVideoInfo.articleInfo.mFeedType);
      }
      localIntent.putExtra("ARG_VIDEO_ARTICLE_ID", paramVideoInfo.Wz);
      localIntent.putExtra("biu_src", 2);
      localIntent.putExtra("arg_from_type", 8);
      localIntent.putExtra("arg_article_info", paramVideoInfo.articleInfo);
      localIntent.putExtra("fast_biu_type", paramBoolean);
      this.mActivity.startActivityForResult(localIntent, 102);
      this.mActivity.overridePendingTransition(0, 0);
      return;
    }
    catch (Exception paramVideoInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "innerOpenReadInJoyBiuActivity error exception = " + paramVideoInfo.getMessage());
    }
  }
  
  private void c(mtg.b paramb)
  {
    if ((paramb == null) || (paramb.lx == null) || (paramb.rp == null) || (paramb.bq == null) || (this.mContext == null) || (this.mContext.getResources() == null)) {
      return;
    }
    if ((paramb.lx != null) && (c(paramb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d))) {
      paramb.lx.setVisibility(8);
    }
    View localView = paramb.lx;
    Object localObject = new GradientDrawable();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    TextView localTextView = paramb.rp;
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramb.bq.getVisibility() == 0)
    {
      ((GradientDrawable)localObject).setCornerRadius(wja.dp2px(6.0F, this.mActivity.getResources()));
      localLayoutParams.height = wja.dp2px(31.0F, this.mActivity.getResources());
      localLayoutParams.topMargin = wja.dp2px(8.0F, this.mActivity.getResources());
      localLayoutParams.bottomMargin = wja.dp2px(10.0F, this.mActivity.getResources());
      localLayoutParams.leftMargin = wja.dp2px(15.0F, this.mActivity.getResources());
      localLayoutParams.rightMargin = wja.dp2px(15.0F, this.mActivity.getResources());
      if (localLayoutParams1 != null)
      {
        localLayoutParams1.addRule(13);
        localTextView.setLayoutParams(localLayoutParams1);
      }
      localObject = this.mContext.getResources().getDrawable(2130843552);
    }
    for (;;)
    {
      localView.setLayoutParams(localLayoutParams);
      if ((paramb.A == null) || (localObject == null)) {
        break;
      }
      paramb.A.setProgressDrawable((Drawable)localObject);
      return;
      localLayoutParams.height = wja.dp2px(42.0F, this.mActivity.getResources());
      localLayoutParams.topMargin = wja.dp2px(15.0F, this.mActivity.getResources());
      localLayoutParams.bottomMargin = wja.dp2px(0.0F, this.mActivity.getResources());
      localLayoutParams.leftMargin = wja.dp2px(0.0F, this.mActivity.getResources());
      localLayoutParams.rightMargin = wja.dp2px(0.0F, this.mActivity.getResources());
      ((GradientDrawable)localObject).setCornerRadius(wja.dp2px(0.0F, this.mActivity.getResources()));
      localObject = this.mContext.getResources().getDrawable(2130843550);
      if (localLayoutParams1 != null)
      {
        localLayoutParams1.addRule(15);
        localTextView.setLayoutParams(localLayoutParams1);
      }
    }
  }
  
  private void c(mtg.g paramg)
  {
    paramg = paramg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b;
    if ((paramg != null) && ((paramg.apw) || ((paramg.e != null) && (paramg.e.qe() != 0))))
    {
      paramg.apw = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.o(paramg);
    }
  }
  
  private static boolean c(VideoInfo paramVideoInfo)
  {
    return knd.c(paramVideoInfo);
  }
  
  public static boolean h(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {}
    do
    {
      return false;
      paramVideoAdInfo = jzk.a(paramVideoAdInfo);
    } while ((TextUtils.isEmpty(paramVideoAdInfo.mPopFormH5Url)) || (!knc.d(paramVideoAdInfo)));
    return true;
  }
  
  private Drawable j(int paramInt)
  {
    Bitmap localBitmap;
    if (!this.ey.containsKey(Integer.valueOf(paramInt)))
    {
      localBitmap = BitmapFactory.decodeResource(this.mContext.getResources(), paramInt);
      if (localBitmap == null) {
        return this.mContext.getResources().getDrawable(paramInt);
      }
      this.ey.put(Integer.valueOf(paramInt), localBitmap);
    }
    for (;;)
    {
      return new BitmapDrawable(this.mContext.getResources(), localBitmap);
      localBitmap = (Bitmap)this.ey.get(Integer.valueOf(paramInt));
    }
  }
  
  private void j(VideoInfo paramVideoInfo)
  {
    int j = 1;
    if (paramVideoInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel_id", 409409);
      if (!paramVideoInfo.adM) {
        break label299;
      }
      i = 0;
      localJSONObject.put("type", i);
      if (paramVideoInfo.videoReportInfo == null) {
        break label304;
      }
      str1 = paramVideoInfo.videoReportInfo;
      label60:
      localJSONObject.put("video_report_info", str1);
      if (!paramVideoInfo.adM) {
        break label103;
      }
      if (this.jdField_a_of_type_Mvn == null) {
        break label357;
      }
      i = this.jdField_a_of_type_Mvn.pV();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        label103:
        String str2;
        label161:
        label191:
        label213:
        label236:
        String str4;
        String str3;
        label299:
        label304:
        label320:
        label325:
        label333:
        label339:
        continue;
        int i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
      }
    }
    localJSONObject.put("style", i);
    localJSONObject.put("algorithm_id", paramVideoInfo.algorithmID);
    if (this.jdField_a_of_type_Mvj != null)
    {
      if (!this.jdField_a_of_type_Mvj.EA()) {
        break label362;
      }
      i = 1;
      localJSONObject.put("is_display_download_bar", i);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar != null)
      {
        str1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.WT;
        localJSONObject.put("common_data", str1);
        localJSONObject.put("video_type", 0);
        if (!this.aol) {
          break label320;
        }
        i = j;
        localJSONObject.put("interact_button_style", i);
        if (!this.anU) {
          break label325;
        }
        str1 = "0X800929C";
        if ((paramVideoInfo.busiType != 0) || (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
          break label333;
        }
        str2 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        str4 = paramVideoInfo.hH;
        if (TextUtils.isEmpty(paramVideoInfo.Wz)) {
          break label339;
        }
      }
      for (str3 = paramVideoInfo.Wz;; str3 = "0")
      {
        kbp.a(null, str4, str1, str1, 0, 0, "0", "0", str3, kct.a(str2, paramVideoInfo.hH, paramVideoInfo.vid, paramVideoInfo.Wz, localJSONObject), false);
        return;
        i = 1;
        break;
        str1 = "";
        break label60;
        str1 = "";
        break label161;
        i = 0;
        break label191;
        str1 = "0X80091A9";
        break label213;
        str2 = null;
        break label236;
      }
    }
  }
  
  private void k(VideoInfo paramVideoInfo)
  {
    int i = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.aHc;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "innerSubscribeColume() columeid=" + i);
    }
    muj.b(this.mApp, i);
    paramVideoInfo = this.mDataList.iterator();
    while (paramVideoInfo.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)paramVideoInfo.next();
      if ((localVideoInfo.yV()) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.aHc == i))
      {
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.amw = true;
        VideoColumnInfo localVideoColumnInfo = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo;
        localVideoColumnInfo.subscribeCount += 1;
        i(localVideoInfo);
      }
    }
    sw(i);
  }
  
  private void n(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.aTm == 1)) {
      kbp.a(null, "", "0X800AC2B", "0X800AC2B", 0, 0, "3", "", "", new nce.a(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).N(0).a().toJsonString(), false);
    }
  }
  
  private void o(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jQ != null)
    {
      int i = 0;
      if (i < paramVideoInfo.jQ.size())
      {
        Object localObject = (VideoInfo.ChannelInfo)paramVideoInfo.jQ.get(i);
        localObject = new nce.a("", "", paramVideoInfo.vid, paramVideoInfo.Wz).t(((VideoInfo.ChannelInfo)localObject).channelID).u(muj.a((VideoInfo.ChannelInfo)localObject)).a(paramVideoInfo.videoReportInfo).a().toJsonString();
        if (this.anU) {
          kbp.a(null, "", "0X8009330", "0X8009330", 0, 0, "3", "", "", (String)localObject, false);
        }
        for (;;)
        {
          i += 1;
          break;
          kbp.a(null, "", "0X80092F8", "0X80092F8", 0, 0, "3", "", "", (String)localObject, false);
        }
      }
    }
  }
  
  private void oh(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "handleConnetNetWorkChange");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.anW)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.oD(paramBoolean);
    this.mUIHandler.post(new VideoFeedsAdapter.12(this, paramBoolean));
  }
  
  public void G(View paramView, int paramInt)
  {
    paramView = (mtg.l)paramView.getTag();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.aom);
        paramView.jdField_a_of_type_Mrx.so(1);
        this.aom = false;
        return;
      } while (paramView.be.getVisibility() != 0);
      paramView.jdField_a_of_type_Mrx.so(2);
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.isPause());
    this.aom = true;
  }
  
  public VideoInfo a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = this.mDataList.iterator();
    VideoInfo localVideoInfo;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break label103;
          }
          localVideoInfo = (VideoInfo)localIterator.next();
          localObject = localVideoInfo;
          if (paramString.equals(localVideoInfo.Wz)) {
            break;
          }
        } while (localVideoInfo.jT == null);
        localObject = localVideoInfo.jT.iterator();
      }
      localVideoInfo = (VideoInfo)((Iterator)localObject).next();
    } while (!paramString.equals(localVideoInfo.Wz));
    return localVideoInfo;
    label103:
    return null;
  }
  
  public mtg.e a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = LayoutInflater.from(paramViewGroup.getContext());
    Object localObject3;
    switch (paramInt)
    {
    case 3: 
    default: 
      localObject3 = null;
      paramViewGroup = null;
      localObject1 = null;
      if (paramViewGroup != null)
      {
        paramViewGroup.jdField_a_of_type_Mrx = ((mrx)localObject3);
        paramViewGroup.jdField_a_of_type_Mxy = new mxy(paramViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.anZ);
        return paramViewGroup;
      }
      break;
    case 2: 
      localObject1 = mwl.a(2131560523, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (mtg.k)((View)localObject1).getTag();
      if (paramViewGroup == null) {
        paramViewGroup = mtg.k.a((View)localObject1);
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        localObject3 = new mtg.j((mtg.k)paramViewGroup);
        try
        {
          paramInt = ayxa.getNotchInScreenHeight(this.mActivity);
          if ((ayxa.isLiuHaiUseValid()) && (paramInt > 0) && (((mtg.k)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null))
          {
            localObject1 = (View)((mtg.k)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.getParent();
            ((View)localObject1).setPadding(((View)localObject1).getPaddingLeft(), paramInt + ((View)localObject1).getPaddingTop(), ((View)localObject1).getPaddingRight(), ((View)localObject1).getPaddingBottom());
          }
          localObject1 = null;
        }
        catch (Exception localException)
        {
          localObject2 = null;
        }
      }
      break;
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131560514, paramViewGroup, false);
      ((LayoutInflater)localObject2).inflate(2131560541, (ViewGroup)paramViewGroup.findViewById(2131365069), true);
      ((LayoutInflater)localObject2).inflate(2131560538, (ViewGroup)paramViewGroup.findViewById(2131365067), true);
      ((LayoutInflater)localObject2).inflate(2131560539, (ViewGroup)paramViewGroup.findViewById(2131365065), true);
      paramViewGroup = new mtg.b(paramViewGroup, paramInt);
      localObject3 = new mtg.a((mtg.b)paramViewGroup);
      Object localObject2 = null;
      break;
      localObject3 = mwl.a(2131560519, true, new ViewGroup.LayoutParams(-1, -1));
      localObject2 = (mtg.i)((View)localObject3).getTag();
      paramViewGroup = (ViewGroup)localObject2;
      if (localObject2 == null) {
        paramViewGroup = new mtg.i((View)localObject3, paramInt);
      }
      this.jdField_a_of_type_Mtg$i = paramViewGroup;
      localObject3 = null;
      localObject2 = paramViewGroup;
      paramViewGroup = null;
      break;
      return localObject2;
    }
  }
  
  public mud a()
  {
    return this.jdField_b_of_type_Mud;
  }
  
  public mxm a()
  {
    return this.jdField_b_of_type_Mxm;
  }
  
  public void a(ADVideoAppDownloadManager paramADVideoAppDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager = paramADVideoAppDownloadManager;
  }
  
  public void a(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, List<VideoInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((VideoInfo)paramList.next()).aBD();
      }
    }
    int j = paramVideoFeedsRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramList = paramVideoFeedsRecyclerView.getChildViewHolder(paramVideoFeedsRecyclerView.getChildAt(i));
      if ((paramList instanceof mtg.l)) {
        ((mtg.l)paramList).jdField_a_of_type_Mrx.aRH();
      }
      i += 1;
    }
  }
  
  public void a(mrp parammrp)
  {
    this.jdField_b_of_type_Mrp = parammrp;
  }
  
  public void a(mss parammss)
  {
    this.jdField_b_of_type_Mss = parammss;
  }
  
  public void a(mtg.d paramd)
  {
    this.jdField_a_of_type_Mtg$d = paramd;
  }
  
  public void a(mtg.e parame, int paramInt)
  {
    parame.position = paramInt;
    parame.aUv = paramInt;
    parame.aos = true;
    if ((paramInt >= 0) && (paramInt < this.mDataList.size()))
    {
      if (this.jdField_b_of_type_Mss != null)
      {
        VideoInfo localVideoInfo = this.jdField_b_of_type_Mss.b(paramInt);
        if (localVideoInfo != null) {
          this.mDataList.set(paramInt, localVideoInfo);
        }
      }
      a(parame, (VideoInfo)this.mDataList.get(paramInt));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parame, paramInt, getItemId(paramInt));
      return;
      a(parame, null);
    }
  }
  
  public void a(mtg.e parame, VideoInfo paramVideoInfo)
  {
    int i = parame.itemType;
    if ((i == 3) || (i == 6))
    {
      a((mtg.i)parame);
      this.jdField_a_of_type_Mtg$i = ((mtg.i)parame);
    }
    do
    {
      return;
      parame = (mtg.g)parame;
      c(parame);
      a(parame, paramVideoInfo);
      TraceCompat.beginSection("refreshMenuUI");
      parame.jdField_a_of_type_Mrx.e(paramVideoInfo);
      TraceCompat.endSection();
      TraceCompat.beginSection("refreshContentUI");
      parame.jdField_a_of_type_Mrx.b(paramVideoInfo, this.anX);
      TraceCompat.endSection();
      if ((this.mIsFullScreen) && (parame == this.jdField_b_of_type_Mtg$g)) {
        parame.jdField_a_of_type_Mrx.nY(this.mIsFullScreen);
      }
    } while (!parame.aos);
    b(parame);
  }
  
  public void a(mtw parammtw)
  {
    this.jdField_a_of_type_Mtw = parammtw;
  }
  
  public void a(mud parammud)
  {
    this.jdField_b_of_type_Mud = parammud;
  }
  
  public void a(mvn parammvn)
  {
    this.jdField_a_of_type_Mvn = parammvn;
  }
  
  public void a(mwc parammwc)
  {
    this.jdField_a_of_type_Mwc = parammwc;
  }
  
  public void a(mxi parammxi)
  {
    this.jdField_a_of_type_Mxi = parammxi;
  }
  
  public void a(mxm parammxm)
  {
    this.jdField_b_of_type_Mxm = parammxm;
  }
  
  public void a(mxu parammxu)
  {
    this.jdField_a_of_type_Mxu = parammxu;
  }
  
  public void aRT()
  {
    int i = this.mDataList.size();
    int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getHeaderViewsCount();
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.findViewHolderForLayoutPosition(i + j - 1);
    if ((localViewHolder instanceof mtg.i)) {
      a((mtg.i)localViewHolder);
    }
  }
  
  public void aRU() {}
  
  public void aRV()
  {
    int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildViewHolder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildAt(i));
      if (((localObject instanceof mtg.l)) && (((mtg.l)localObject).aUv == this.jdField_b_of_type_Mtg$g.aUv + 1))
      {
        localObject = ((mtg.l)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b;
        if ((localObject != null) && ((((VideoFeedsPlayManager.b)localObject).apw) || ((((VideoFeedsPlayManager.b)localObject).e != null) && (!((VideoFeedsPlayManager.b)localObject).e.isIdle()))))
        {
          ((VideoFeedsPlayManager.b)localObject).apw = false;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.o((VideoFeedsPlayManager.b)localObject);
        }
      }
      i += 1;
    }
    if (this.mVideoPreDownloadMgr != null) {
      this.mVideoPreDownloadMgr.aTZ();
    }
  }
  
  public void aRW()
  {
    if ((this.mUIHandler != null) && (!this.aoj))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "rePostMsgForAd");
      }
      this.aoj = true;
      this.mUIHandler.removeMessages(4, null);
      this.mUIHandler.sendEmptyMessageDelayed(4, 1000L);
    }
  }
  
  public void aRZ()
  {
    if ((this.jdField_b_of_type_Mtg$g == null) || (this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b == null) || (this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d == null) || (this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.ry <= 0L)) {
      return;
    }
    this.jdField_b_of_type_Mtg$g.jdField_a_of_type_Nca.l(0, "", "点击重试");
  }
  
  public VideoInfo b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = this.mDataList.iterator();
    VideoInfo localVideoInfo;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break label103;
          }
          localVideoInfo = (VideoInfo)localIterator.next();
          localObject = localVideoInfo;
          if (paramString.equals(localVideoInfo.vid)) {
            break;
          }
        } while (localVideoInfo.jT == null);
        localObject = localVideoInfo.jT.iterator();
      }
      localVideoInfo = (VideoInfo)((Iterator)localObject).next();
    } while (!paramString.equals(localVideoInfo.vid));
    return localVideoInfo;
    label103:
    return null;
  }
  
  public void cS(View paramView) {}
  
  public void cS(List<VideoInfo> paramList)
  {
    this.mDataList = paramList;
  }
  
  public void cX(int paramInt1, int paramInt2)
  {
    this.aRA = paramInt1;
    this.aUp = paramInt2;
  }
  
  public void cb(View paramView)
  {
    if ((this.jdField_a_of_type_Mtw != null) && (this.jdField_a_of_type_Mtw.El()) && (this.jdField_a_of_type_Mtw.Em()))
    {
      this.jdField_a_of_type_Mtw.aSk();
      break label34;
    }
    for (;;)
    {
      label34:
      return;
      if (!this.aoo) {
        continue;
      }
      paramView = (mtg.g)paramView.getTag();
      if (paramView != this.jdField_b_of_type_Mtg$g)
      {
        if (this.jdField_b_of_type_Mtg$g == null) {
          break;
        }
        if ((paramView != null) && (paramView.aUv == this.jdField_b_of_type_Mtg$g.aUv + 1) && (paramView.aUv != getItemCount()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.EK();
          return;
        }
        if ((paramView == null) || (paramView.aUv != this.jdField_b_of_type_Mtg$g.aUv - 1)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.EL();
        return;
      }
      paramView.jdField_a_of_type_Mrx.onVideoClick();
      JSONObject localJSONObject;
      switch (paramView.itemType)
      {
      case 3: 
      case 4: 
      case 6: 
      default: 
      case 2: 
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.isPlaying())) {
          continue;
        }
        localJSONObject = new JSONObject();
      case 5: 
      case 7: 
        try
        {
          localJSONObject.put("channel_id", 409409);
          label221:
          kbp.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", kct.a(null, null, paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.vid, paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.Wz, localJSONObject), false);
          return;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.isPlaying())) {
            continue;
          }
          localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("channel_id", 409409);
            label307:
            kbp.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", kct.a(null, null, paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.vid, paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.Wz, localJSONObject), false);
            return;
          }
          catch (JSONException localJSONException1)
          {
            break label307;
          }
        }
        catch (JSONException localJSONException2)
        {
          break label221;
        }
      }
    }
  }
  
  public boolean dX(String paramString)
  {
    return this.M.contains(paramString);
  }
  
  public void doOnDestory()
  {
    if ((this.jdField_a_of_type_Nce$a != null) && (this.e != null)) {
      a(this.e, this.jdField_a_of_type_Nce$a);
    }
    if (this.jdField_a_of_type_Mtg$d != null) {
      this.jdField_a_of_type_Mtg$d = null;
    }
    if (this.jdField_b_of_type_Mtg$g != null) {
      this.jdField_b_of_type_Mtg$g.x = null;
    }
    this.mUIHandler.removeCallbacksAndMessages(null);
    this.mUIHandler = null;
    this.jdField_a_of_type_Auuw = null;
    this.mApp = null;
    if (this.jdField_b_of_type_Kmh != null) {
      this.jdField_b_of_type_Kmh.destroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if (this.jdField_b_of_type_Msx != null)
    {
      this.jdField_b_of_type_Msx.doOnDestory();
      this.jdField_b_of_type_Msx = null;
    }
    if (this.jdField_a_of_type_Mvj != null)
    {
      this.jdField_a_of_type_Mvj.doOnDestory();
      this.jdField_a_of_type_Mvj = null;
    }
    kmw.aEI();
    arvv.a().b(VideoFeedsUGView.a);
    if (this.jdField_b_of_type_Mtg$l != null)
    {
      a(this.jdField_b_of_type_Mtg$l.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, false);
      a(this.jdField_b_of_type_Mtg$l.b, false);
    }
  }
  
  public void doOnResume()
  {
    this.anW = true;
    ods.c(this);
    if ((this.jdField_b_of_type_Mtg$g != null) && (this.jdField_b_of_type_Mtg$g.jdField_a_of_type_Mrx != null) && ((this.jdField_b_of_type_Mtg$g.jdField_a_of_type_Mrx instanceof mtg.a))) {
      ((mtg.a)this.jdField_b_of_type_Mtg$g.jdField_a_of_type_Mrx).doOnResume();
    }
    ApngImage.playByTag(28);
    ApngImage.playByTag(29);
    ApngImage.playByTag(30);
    kmw.aEH();
    knd.a(this.jdField_b_of_type_Mrp, this, (mtg.l)this.jdField_b_of_type_Mtg$g);
  }
  
  public void e(mtg.l paraml)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "adapter playVideo (VideoItemHolder holder) ");
    }
    this.mUIHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.stop();
    int i;
    boolean bool;
    label105:
    long l1;
    long l2;
    if (this.jdField_b_of_type_Mtg$g != null)
    {
      i = this.jdField_b_of_type_Mtg$g.aUv;
      this.jdField_b_of_type_Mtg$g = paraml;
      if ((this.jdField_b_of_type_Mtg$g.aUv == 0) && (this.jdField_b_of_type_Mtg$g.position == 0))
      {
        paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.startPosition = this.wN;
        this.wN = 0L;
      }
      if ((this.aoa) && (!a(paraml))) {
        break label200;
      }
      bool = true;
      this.aoa = false;
      l1 = System.currentTimeMillis();
      l2 = this.wM;
      if (!bool) {
        break label205;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b, false);
    }
    for (;;)
    {
      a(paraml, bool, l1 - l2, i);
      if ((paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null)) {
        ocp.e(paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.Wz, paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.vid, 0, 0);
      }
      return;
      i = -1;
      break;
      label200:
      bool = false;
      break label105;
      label205:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.l(paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b);
    }
  }
  
  public boolean e(VideoInfo paramVideoInfo)
  {
    return (this.jdField_b_of_type_Mtg$g == null) || (this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b == null) || (this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d == paramVideoInfo);
  }
  
  public void eK(long paramLong)
  {
    this.wN = paramLong;
  }
  
  public int getItemCount()
  {
    if (this.mDataList == null) {
      return 0;
    }
    return this.mDataList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mDataList.size())) {
      return ((VideoInfo)this.mDataList.get(paramInt)).hashCode();
    }
    if ((this.jdField_a_of_type_Mtg$i != null) && (this.jdField_a_of_type_Mtg$i.itemView != null)) {
      return this.jdField_a_of_type_Mtg$i.itemView.hashCode();
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mDataList != null) && (paramInt >= 0) && (paramInt < this.mDataList.size()))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.mDataList.get(paramInt);
      if (!localVideoInfo.isAD) {
        return 2;
      }
      if (localVideoInfo.qU == 1) {
        return 7;
      }
    }
    return 6;
  }
  
  public void h(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (this.jdField_a_of_type_Nce$a != null))
    {
      this.jdField_a_of_type_Nce$a.a(paramVideoInfo.videoReportInfo);
      a(paramVideoInfo, this.jdField_a_of_type_Nce$a);
      this.jdField_a_of_type_Nce$a = null;
    }
  }
  
  public void i(VideoInfo paramVideoInfo)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.mDataList, paramVideoInfo);
  }
  
  public void l(View paramView, int paramInt1, int paramInt2)
  {
    mtg.l locall = (mtg.l)paramView.getTag();
    if (locall != this.jdField_b_of_type_Mtg$g) {}
    while ((!this.aoo) || (locall == null) || (locall.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d == null) || (!(locall instanceof mtg.g)) || (TextUtils.isEmpty(locall.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.Wz))) {
      return;
    }
    Object localObject = locall.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
    boolean bool;
    int i;
    label108:
    JSONObject localJSONObject;
    if (!((VideoInfo)localObject).adM)
    {
      bool = true;
      ((VideoInfo)localObject).adM = true;
      if (!bool) {
        break label570;
      }
      i = ((VideoInfo)localObject).aHi + 1;
      ((VideoInfo)localObject).aHi = i;
      if ((this.jdField_a_of_type_Mvj != null) && ((locall instanceof mtg.k)))
      {
        int j = 0;
        i = j;
        if (this.jdField_a_of_type_Mxi != null)
        {
          i = j;
          if (this.jdField_a_of_type_Mxi.isShowing()) {
            i = 1;
          }
        }
        if (i == 0) {
          this.jdField_a_of_type_Mvj.a((VideoInfo)localObject, (mtg.k)locall);
        }
      }
      locall.jdField_a_of_type_Mrx.k(paramInt1, paramInt2, bool);
      if (bool)
      {
        if (this.jdField_a_of_type_Mtg$d != null) {
          this.jdField_a_of_type_Mtg$d.d((VideoInfo)localObject, ((VideoInfo)localObject).adM);
        }
        j((VideoInfo)localObject);
      }
      if (this.jdField_a_of_type_Mwc != null) {
        this.jdField_a_of_type_Mwc.a(3, (VideoInfo)localObject, 0L);
      }
      localJSONObject = new JSONObject();
      if ((locall.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.busiType != 0) || (locall.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label580;
      }
      paramView = locall.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    try
    {
      label298:
      localJSONObject.put("channel_id", 409409);
      localJSONObject.put("rowkey", locall.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.Wz);
      if (this.jdField_a_of_type_Mvn == null) {
        break label585;
      }
      paramInt1 = this.jdField_a_of_type_Mvn.pV();
      label345:
      localJSONObject.put("style", paramInt1);
      localJSONObject.put("algorithm_id", ((VideoInfo)localObject).algorithmID);
      paramInt1 = 0;
      if (this.jdField_a_of_type_Mvj != null)
      {
        if (!this.jdField_a_of_type_Mvj.EA()) {
          break label590;
        }
        paramInt1 = 1;
      }
      label390:
      localJSONObject.put("is_display_download_bar", paramInt1);
      if (((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar == null) {
        break label595;
      }
      localObject = ((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.WT;
      label418:
      localJSONObject.put("common_data", localObject);
      if (!this.aol) {
        break label603;
      }
      paramInt1 = 1;
      label438:
      localJSONObject.put("interact_button_style", paramInt1);
    }
    catch (Exception localException)
    {
      label448:
      label460:
      String str2;
      String str1;
      label570:
      label580:
      label585:
      label590:
      label595:
      label603:
      label616:
      break label448;
    }
    if (this.anU)
    {
      localObject = "0X80097F5";
      str2 = locall.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.hH;
      if (TextUtils.isEmpty(locall.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.Wz)) {
        break label616;
      }
    }
    for (str1 = locall.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.Wz;; str1 = "0")
    {
      kbp.a(null, str2, (String)localObject, (String)localObject, 0, 0, "0", "0", str1, kct.a(paramView, locall.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.hH, locall.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.vid, locall.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.Wz, localJSONObject), false);
      return;
      bool = false;
      break;
      i = ((VideoInfo)localObject).aHi;
      break label108;
      paramView = null;
      break label298;
      paramInt1 = 0;
      break label345;
      paramInt1 = 0;
      break label390;
      localObject = "";
      break label418;
      paramInt1 = 0;
      break label438;
      localObject = "0X80091AA";
      break label460;
    }
  }
  
  public void l(VideoInfo paramVideoInfo)
  {
    this.e = paramVideoInfo;
  }
  
  public void m(VideoInfo paramVideoInfo)
  {
    if ((this.mDataList != null) && (this.mDataList.contains(paramVideoInfo)))
    {
      int i = this.mDataList.indexOf(paramVideoInfo);
      akG();
      this.mDataList.remove(paramVideoInfo);
      this.jdField_b_of_type_Mtg$g = null;
      notifyItemRemoved(i);
    }
  }
  
  public void nS(String paramString)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.mDataList, paramString);
  }
  
  public void nT(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.mActivity == null)) {
      return;
    }
    paramString = kwt.acJ + aqgo.encodeToString(String.valueOf(paramString).getBytes(), 2);
    kxm.aJ(this.mActivity, paramString);
  }
  
  public void og(boolean paramBoolean)
  {
    this.anX = paramBoolean;
  }
  
  public void oi(boolean paramBoolean)
  {
    this.anY = paramBoolean;
  }
  
  public void oj(boolean paramBoolean)
  {
    this.aon = paramBoolean;
  }
  
  public void ok(boolean paramBoolean)
  {
    this.anZ = paramBoolean;
  }
  
  public void ol(boolean paramBoolean)
  {
    if ((!this.aoh) && (paramBoolean) && (this.aoi))
    {
      if ((this.jdField_b_of_type_Mtg$g instanceof mtg.l)) {
        e((mtg.l)this.jdField_b_of_type_Mtg$g);
      }
      this.aoi = false;
    }
    this.aoh = paramBoolean;
  }
  
  public void om(boolean paramBoolean) {}
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    Object localObject4 = (mtg.e)paramView.getTag();
    Object localObject1;
    if ((localObject4 instanceof mtg.l))
    {
      localObject1 = ((mtg.l)localObject4).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
      if ((this.jdField_b_of_type_Mtg$g != null) && (this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (localObject1 == this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d)) {}
    }
    label128:
    label581:
    label1093:
    label4040:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      for (;;)
      {
        if (localObject1 == null) {
          break label4040;
        }
        Object localObject2 = null;
        long l;
        if (((VideoInfo)localObject1).isAD)
        {
          localObject2 = knl.b(((VideoInfo)localObject1).jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo);
          this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = ods.a(this.mActivity, (AdvertisementInfo)localObject2, null, 3, false, null);
          if (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null)
          {
            l = SystemClock.elapsedRealtime();
            this.sr = l;
          }
        }
        else
        {
          if ((((VideoInfo)localObject1).busiType != 0) || (((VideoInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
            break label581;
          }
        }
        Object localObject5;
        for (Object localObject3 = ((VideoInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();; localObject3 = null)
        {
          localObject5 = new JSONObject();
          switch (paramView.getId())
          {
          default: 
            break;
          case 2131361873: 
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.EK();
            break;
            l = -2147483648L;
            break label128;
          }
        }
        if (this.jdField_a_of_type_Mwe != null) {
          this.jdField_a_of_type_Mwe.aTi();
        }
        this.jdField_b_of_type_Mtg$g.jdField_a_of_type_Nca.aVq();
        if (paramView.getId() != 2131366502) {
          break;
        }
        ncb.aQ(((VideoInfo)localObject1).Wz, 1);
        break;
        if ((this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b == null) || (localObject1 == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.oH(false);
        if (TextUtils.isEmpty(((VideoInfo)localObject1).Wz)) {
          break;
        }
        ncb.a(this.mActivity, mrv.a((VideoInfo)localObject1), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(((VideoInfo)localObject1).Wz), 1, 0);
        ncb.s(((VideoInfo)localObject1).Wz, 1, 0);
        break;
        if ((((mtg.e)localObject4).itemType == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.isPause())) {
          muj.a(((mtg.l)localObject4).be, 8, 200);
        }
        if (this.jdField_a_of_type_Mwe == null) {
          break;
        }
        this.jdField_a_of_type_Mwe.aTi();
        break;
        if (kpn.nx() == 1) {}
        for (boolean bool = true;; bool = false)
        {
          a((VideoInfo)localObject1, false, bool);
          if (this.jdField_a_of_type_Mwc == null) {
            break;
          }
          this.jdField_a_of_type_Mwc.a(2, (VideoInfo)localObject1, 0L);
          break;
        }
        if ((this.jdField_a_of_type_Mtw != null) && (((VideoInfo)localObject1).j(this.mActivity))) {
          this.jdField_a_of_type_Mtw.aSk();
        }
        if (((VideoInfo)localObject1).isAD)
        {
          ods.b(this.mActivity, (AdvertisementInfo)localObject2, null, 3, true, null);
          c((VideoInfo)localObject1, 0);
          break;
        }
        if (((VideoInfo)localObject1).yV())
        {
          muj.a(this.mActivity, ((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h);
          localObject2 = new nce.a((VideoInfo)localObject1).h(((VideoInfo)localObject1).Wz).t(((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.aHc);
          if (((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h != null) {}
          for (localObject1 = ((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h.WT;; localObject1 = "")
          {
            kbp.b(null, "", "0X800A18C", "0X800A18C", 0, 0, "", "", "", ((nce.a)localObject2).o((String)localObject1).R(1).a().toJsonString(), false);
            break;
          }
        }
        if ((((VideoInfo)localObject1).WJ != null) && (!((VideoInfo)localObject1).WJ.equals("")))
        {
          kxm.aJ(this.mActivity, ((VideoInfo)localObject1).WJ);
          break;
        }
        if (((VideoInfo)localObject1).busiType == 6)
        {
          if (!TextUtils.isEmpty(((VideoInfo)localObject1).hH))
          {
            localObject2 = kwt.acF + aqgo.encodeToString(((VideoInfo)localObject1).hH.getBytes(), 2);
            kxm.aJ(this.mActivity, (String)localObject2);
          }
          localObject2 = new nce.a((String)localObject3, ((VideoInfo)localObject1).hH, ((VideoInfo)localObject1).vid, ((VideoInfo)localObject1).Wz, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV(), ((VideoInfo)localObject1).getDuration() * 1000L).a(-1).N(0).a().toJsonString();
          localObject3 = ((VideoInfo)localObject1).hH;
          if (TextUtils.isEmpty(((VideoInfo)localObject1).Wz)) {
            break label1240;
          }
        }
        label1240:
        for (localObject1 = ((VideoInfo)localObject1).Wz;; localObject1 = "0")
        {
          kbp.a(null, (String)localObject3, "0X8007410", "0X8007410", 0, 0, "0", "", (String)localObject1, (String)localObject2, false);
          break;
          if ((TextUtils.isEmpty(((VideoInfo)localObject1).hH)) || (((VideoInfo)localObject1).hH.equals("16888"))) {
            break label1093;
          }
          nT(((VideoInfo)localObject1).hH);
          break label1093;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.aTn();
        break;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.aTn();
        break;
        if (((VideoInfo)localObject1).yV())
        {
          if (((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.amw) {
            break;
          }
          k((VideoInfo)localObject1);
          muj.a(this.mActivity, ((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.j);
          localObject2 = new nce.a((VideoInfo)localObject1).h(((VideoInfo)localObject1).Wz).t(((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.aHc);
          if (((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.j != null) {}
          for (localObject1 = ((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.j.WT;; localObject1 = "")
          {
            kbp.b(null, "", "0X800A18C", "0X800A18C", 0, 0, "", "", "", ((nce.a)localObject2).o((String)localObject1).R(2).N(0).a().toJsonString(), false);
            break;
          }
        }
        if (((VideoInfo)localObject1).isFollowed) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount onClick() puin=" + ((VideoInfo)localObject1).hH + ", isFollowed=" + ((VideoInfo)localObject1).isFollowed + ", pname=" + ((VideoInfo)localObject1).accountName);
        }
        localObject3 = new nce.a(null, ((VideoInfo)localObject1).hH, ((VideoInfo)localObject1).vid, ((VideoInfo)localObject1).Wz, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV(), ((VideoInfo)localObject1).getDuration() * 1000L).a(((VideoInfo)localObject1).videoReportInfo).N(0).a().toJsonString();
        if (this.anU)
        {
          localObject4 = ((VideoInfo)localObject1).hH;
          if (!TextUtils.isEmpty(((VideoInfo)localObject1).Wz)) {}
          for (localObject2 = ((VideoInfo)localObject1).Wz;; localObject2 = "0")
          {
            kbp.a(null, (String)localObject4, "0X800929B", "0X800929B", 0, 0, "", "", (String)localObject2, (String)localObject3, false);
            ai(((VideoInfo)localObject1).hH, ((VideoInfo)localObject1).adB);
            break;
          }
        }
        localObject4 = ((VideoInfo)localObject1).hH;
        if (!TextUtils.isEmpty(((VideoInfo)localObject1).Wz)) {}
        for (localObject2 = ((VideoInfo)localObject1).Wz;; localObject2 = "0")
        {
          kbp.a(null, (String)localObject4, "0X80078FD", "0X80078FD", 0, 0, "", "", (String)localObject2, (String)localObject3, false);
          break;
        }
        if ((!((VideoInfo)localObject1).isAD) || (!(this.jdField_b_of_type_Mtg$g instanceof mtg.b))) {
          break;
        }
        a(paramView, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV(), (VideoInfo)localObject1);
        break;
        if (!((VideoInfo)localObject1).isAD) {
          break;
        }
        ods.b(this.mActivity, (AdvertisementInfo)localObject2, null, 3, true, null);
        c((VideoInfo)localObject1, 0);
        break;
        if (!((VideoInfo)localObject1).isAD) {
          break;
        }
        knd.a((AdvertisementInfo)localObject2, 1000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        ods.b(this.mActivity, (AdvertisementInfo)localObject2, null, 3, false, null);
        c((VideoInfo)localObject1, jzk.aGl);
        break;
        if (!((VideoInfo)localObject1).isAD) {
          break;
        }
        knd.a((AdvertisementInfo)localObject2, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        ods.b(this.mActivity, (AdvertisementInfo)localObject2, null, 3, false, null);
        c((VideoInfo)localObject1, jzk.aGd);
        break;
        if (!((VideoInfo)localObject1).isAD) {
          break;
        }
        knd.a((AdvertisementInfo)localObject2, 3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        ods.b(this.mActivity, (AdvertisementInfo)localObject2, null, 3, false, null);
        c((VideoInfo)localObject1, jzk.aGe);
        break;
        if (!((VideoInfo)localObject1).isAD) {
          break;
        }
        if (this.aog)
        {
          this.aog = false;
          knd.a((AdvertisementInfo)localObject2, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
          ods.b(this.mActivity, (AdvertisementInfo)localObject2, null, 3, false, null);
          c((VideoInfo)localObject1, jzk.aGc);
          break;
        }
        knd.a((AdvertisementInfo)localObject2, 4, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        ods.b(this.mActivity, (AdvertisementInfo)localObject2, null, 3, false, null);
        c((VideoInfo)localObject1, jzk.aGf);
        break;
        if (!(localObject4 instanceof mtg.b)) {
          break;
        }
        if (h(((VideoInfo)localObject1).jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          b(((VideoInfo)localObject1).jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo);
          jzk.a(new kku.a().a(this.mContext).a(jzk.aFu).b(jzk.aFy).a((AdvertisementInfo)localObject2).a());
          break;
        }
        localObject4 = (mtg.b)localObject4;
        int i = 8;
        if (this.aob) {
          i = 13;
        }
        knd.a((AdvertisementInfo)localObject2, i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        c((mtg.b)localObject4);
        localObject3 = new View[1];
        localObject3[0] = ((mtg.b)localObject4).lx;
        if (c((VideoInfo)localObject1)) {
          localObject3 = new View[0];
        }
        a((mtg.b)localObject4, (VideoInfo)localObject1, (AdvertisementInfo)localObject2, -1, (View[])localObject3, new View[] { ((mtg.b)localObject4).rm, ((mtg.b)localObject4).lv, ((mtg.b)localObject4).e });
        break;
        if (!(localObject4 instanceof mtg.b)) {
          break;
        }
        if (h(((VideoInfo)localObject1).jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          b(((VideoInfo)localObject1).jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo);
          jzk.a(new kku.a().a(this.mContext).a(jzk.aFu).b(jzk.aFy).a((AdvertisementInfo)localObject2).a());
        }
        while ((this.jdField_b_of_type_Mtg$g != null) && (this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null))
        {
          knd.a(this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b, true);
          break;
          localObject4 = (mtg.b)localObject4;
          localObject3 = new View[2];
          localObject3[0] = ((mtg.b)localObject4).lM;
          localObject3[1] = ((mtg.b)localObject4).lx;
          if (c((VideoInfo)localObject1))
          {
            localObject3 = new View[1];
            localObject3[0] = ((mtg.b)localObject4).lM;
          }
          localObject5 = ((mtg.b)localObject4).rm;
          View localView = ((mtg.b)localObject4).lv;
          TextView localTextView = ((mtg.b)localObject4).rv;
          SeekBar localSeekBar = ((mtg.b)localObject4).e;
          a((mtg.b)localObject4, (VideoInfo)localObject1, (AdvertisementInfo)localObject2, jzk.aFJ, (View[])localObject3, new View[] { localObject5, localView, localTextView, localSeekBar });
        }
        if (!(localObject4 instanceof mtg.b)) {
          break;
        }
        localObject3 = (mtg.b)localObject4;
        a((mtg.e)localObject4, (VideoInfo)localObject1, (AdvertisementInfo)localObject2, -1, ((mtg.b)localObject3).lx, new View[] { ((mtg.b)localObject3).rm, ((mtg.b)localObject3).lv, ((mtg.b)localObject3).e });
        break;
        if (!(localObject4 instanceof mtg.b)) {
          break;
        }
        localObject3 = (mtg.b)localObject4;
        a((mtg.e)localObject4, (VideoInfo)localObject1, (AdvertisementInfo)localObject2, jzk.aFJ, ((mtg.b)localObject3).lM, new View[] { ((mtg.b)localObject3).rv, ((mtg.b)localObject3).e });
        break;
        cb(paramView);
        break;
        this.jdField_a_of_type_Mtw.aSj();
        if (this.anU)
        {
          localObject2 = "0X800948A";
          label2545:
          localObject3 = (mtg.l)localObject4;
          if (((mtg.l)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b == null) {
            break label2777;
          }
          localObject3 = ((mtg.l)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e;
          localObject4 = new nce.a(null, ((VideoInfo)localObject1).hH, ((VideoInfo)localObject1).vid, ((VideoInfo)localObject1).Wz);
          if (localObject3 == null) {
            break label2783;
          }
          l = ((myi)localObject3).c(((myi)localObject3).isCompleted());
          localObject4 = ((nce.a)localObject4).d(l);
          if (localObject3 == null) {
            break label2791;
          }
          l = ((myi)localObject3).dc();
          label2633:
          localObject4 = ((nce.a)localObject4).a(l);
          if (localObject3 == null) {
            break label2799;
          }
          l = ((myi)localObject3).getDuration();
          label2654:
          localObject4 = ((nce.a)localObject4).c(l).a(409409).a(((VideoInfo)localObject1).videoReportInfo).v(this.mActivity.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).a().toJsonString();
          localObject5 = ((VideoInfo)localObject1).hH;
          if (TextUtils.isEmpty(((VideoInfo)localObject1).Wz)) {
            break label2807;
          }
        }
        label2777:
        label2783:
        label2791:
        label2799:
        label2807:
        for (localObject3 = ((VideoInfo)localObject1).Wz;; localObject3 = "0")
        {
          kbp.a(null, (String)localObject5, (String)localObject2, (String)localObject2, 0, 0, "", "", (String)localObject3, (String)localObject4, false);
          if (this.jdField_a_of_type_Mwc == null) {
            break;
          }
          this.jdField_a_of_type_Mwc.a(4, (VideoInfo)localObject1, 0L);
          break;
          localObject2 = "0X8009485";
          break label2545;
          localObject3 = null;
          break label2570;
          l = -1L;
          break label2612;
          l = -1L;
          break label2633;
          l = -1L;
          break label2654;
        }
        this.jdField_a_of_type_Mtw.aSh();
        for (;;)
        {
          try
          {
            if (((VideoInfo)localObject1).videoReportInfo == null) {
              continue;
            }
            localObject2 = ((VideoInfo)localObject1).videoReportInfo;
            ((JSONObject)localObject5).put("video_report_info", localObject2);
            ((JSONObject)localObject5).put("video_type", 0);
            if (!this.aol) {
              continue;
            }
            i = 1;
            ((JSONObject)localObject5).put("interact_button_style", i);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            continue;
            kbp.a(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", kct.a("", "", ((VideoInfo)localObject1).vid, ((VideoInfo)localObject1).Wz, (JSONObject)localObject5), false);
          }
          if (!this.anU) {
            continue;
          }
          kbp.a(null, "", "0X80092A1", "0X80092A1", 0, 0, "", "", "", kct.a("", "", ((VideoInfo)localObject1).vid, ((VideoInfo)localObject1).Wz, (JSONObject)localObject5), false);
          break;
          localObject2 = "";
          continue;
          i = 0;
        }
        break;
        if (!((VideoInfo)localObject1).adM)
        {
          bool = true;
          label3016:
          ((VideoInfo)localObject1).adM = bool;
          if (!((VideoInfo)localObject1).adM) {
            break label3218;
          }
          i = ((VideoInfo)localObject1).aHi + 1;
        }
        for (;;)
        {
          ((VideoInfo)localObject1).aHi = i;
          if ((localObject4 instanceof mtg.l)) {
            ((mtg.l)localObject4).jdField_a_of_type_Mrx.aRJ();
          }
          if ((this.jdField_a_of_type_Mvn != null) && (((VideoInfo)localObject1).adM)) {
            this.jdField_a_of_type_Mvn.y((float)(aqgz.hK() / 2L), (float)(aqgz.hL() / 2L));
          }
          if (this.jdField_a_of_type_Mwc != null) {
            this.jdField_a_of_type_Mwc.a(3, (VideoInfo)localObject1, 0L);
          }
          if (this.jdField_a_of_type_Mtg$d != null) {
            this.jdField_a_of_type_Mtg$d.d((VideoInfo)localObject1, ((VideoInfo)localObject1).adM);
          }
          if ((this.jdField_a_of_type_Mvj != null) && ((localObject4 instanceof mtg.k)))
          {
            int j = 0;
            i = j;
            if (this.jdField_a_of_type_Mxi != null)
            {
              i = j;
              if (this.jdField_a_of_type_Mxi.isShowing()) {
                i = 1;
              }
            }
            if (i == 0) {
              this.jdField_a_of_type_Mvj.a((VideoInfo)localObject1, (mtg.k)localObject4);
            }
          }
          j((VideoInfo)localObject1);
          break;
          bool = false;
          break label3016;
          if (((VideoInfo)localObject1).aHi > 0) {
            i = ((VideoInfo)localObject1).aHi - 1;
          } else {
            i = 0;
          }
        }
        if ((!(localObject4 instanceof mtg.k)) || (((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo == null)) {
          break;
        }
        muj.a(this.mActivity, ((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h);
        localObject1 = new nce.a((VideoInfo)localObject1).a(((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).h(((VideoInfo)localObject1).Wz).N(0).a();
        kbp.a(this.mApp, "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", ((nce)localObject1).toJsonString(), false);
        break;
        this.jdField_b_of_type_Mrp.aRE();
        a(false, (mtg.l)localObject4);
        e((mtg.l)localObject4);
        c((VideoInfo)localObject1, jzk.aGk);
        break;
        knd.a(localJSONException, 15, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        this.jdField_b_of_type_Mrp.aRF();
        ods.b(this.mActivity, localJSONException, null, 3, true, null);
        c((VideoInfo)localObject1, jzk.aGh);
        break;
        knd.a(localJSONException, 16, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        this.jdField_b_of_type_Mrp.aRF();
        ods.b(this.mActivity, localJSONException, null, 3, true, null);
        c((VideoInfo)localObject1, jzk.aGi);
        break;
        knd.a(localJSONException, 17, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        if (h(((VideoInfo)localObject1).jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          b(((VideoInfo)localObject1).jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo);
          jzk.a(new kku.a().a(this.mContext).a(jzk.aFu).b(jzk.aFy).a(localJSONException).a());
          break;
        }
        this.jdField_b_of_type_Mrp.aRF();
        if (localJSONException != null) {
          ods.b(this.mActivity, localJSONException, null, 3, true, null);
        }
        c((VideoInfo)localObject1, jzk.aGj);
        break;
        knd.a(localJSONException, 4001, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a((VideoInfo)localObject1, localJSONException, 4001);
        break;
        knd.a(localJSONException, 4002, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a((VideoInfo)localObject1, localJSONException, 4002);
        break;
        knd.a(localJSONException, 4007, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a((VideoInfo)localObject1, localJSONException, 4007);
        break;
        knd.a(localJSONException, 4000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a((VideoInfo)localObject1, localJSONException, 4000);
        break;
        this.mUIHandler.sendMessage(this.mUIHandler.obtainMessage(9, Boolean.valueOf(false)));
        this.aoc = true;
        if (!(this.jdField_b_of_type_Mtg$g instanceof mtg.b)) {
          break;
        }
        c((mtg.b)this.jdField_b_of_type_Mtg$g);
        break;
        knd.a(localJSONException, 34, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a((VideoInfo)localObject1, localJSONException, jzk.aGv);
        break;
        knd.a(localJSONException, 35, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a((VideoInfo)localObject1, localJSONException, jzk.aGu);
        break;
        knd.a(localJSONException, 37, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a((VideoInfo)localObject1, localJSONException, jzk.aGw);
        break;
        knd.a(localJSONException, 2003, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a((VideoInfo)localObject1, localJSONException, 2003);
        break;
        knd.a(localJSONException, 2004, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a((VideoInfo)localObject1, localJSONException, 2004);
        break;
        knd.a(localJSONException, 18, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a((VideoInfo)localObject1, localJSONException, jzk.aGx);
        break;
        if (TextUtils.isEmpty(((VideoInfo)localObject1).WF)) {
          break;
        }
        RIJRedPacketManager.a().a(this.mActivity, 4, ((VideoInfo)localObject1).WF, ((VideoInfo)localObject1).Wz, new mtl(this), false, null);
        nce localnce = new nce.a((VideoInfo)localObject1).a((VideoInfo)localObject1).h(((VideoInfo)localObject1).Wz).n(1).a();
        kbp.a(null, "", "0X800ABBA", "0X800ABBA", 0, 0, "", "", ((VideoInfo)localObject1).Wz, localnce.toJsonString(), false);
        break;
        if ((this.jdField_b_of_type_Mtg$g == null) || (this.jdField_b_of_type_Mtg$g.jR == null)) {
          break;
        }
        this.jdField_a_of_type_Mwe.aTl();
        a(this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d, "0X8009F42");
        break;
        localObject1 = null;
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    mtg.e locale = (mtg.e)paramView.getTag();
    VideoInfo localVideoInfo = null;
    if ((locale instanceof mtg.l))
    {
      localVideoInfo = ((mtg.l)locale).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
      if ((this.jdField_b_of_type_Mtg$g != null) && (this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (localVideoInfo == this.jdField_b_of_type_Mtg$g.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d)) {}
    }
    while (localVideoInfo == null) {
      return false;
    }
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (kpn.ny() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localVideoInfo, true, bool);
      if (this.jdField_a_of_type_Mwc != null) {
        this.jdField_a_of_type_Mwc.a(2, localVideoInfo, 0L);
      }
      return true;
    }
  }
  
  public void setVideoPlayManager(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    aRX();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.mVideoPreDownloadMgr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(new mtm(this));
  }
  
  public void sv(int paramInt)
  {
    this.aUq = paramInt;
  }
  
  public void sw(int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.mDataList, paramInt);
  }
  
  public void sx(int paramInt)
  {
    this.anW = false;
    if (this.mUIHandler != null) {
      this.mUIHandler.removeMessages(2, null);
    }
    ApngImage.pauseByTag(28);
    ApngImage.pauseByTag(29);
    ApngImage.pauseByTag(30);
    if (paramInt == 1) {
      kmw.aE(this.mActivity);
    }
  }
  
  public void sy(int paramInt)
  {
    this.aUo = paramInt;
  }
  
  public class a
    extends mtg.h
  {
    private mtg.b b;
    
    public a(mtg.b paramb)
    {
      super(paramb);
      this.b = paramb;
    }
    
    private boolean g(VideoInfo paramVideoInfo)
    {
      return (paramVideoInfo != null) && (paramVideoInfo.b != null) && (!paramVideoInfo.b.adA) && (knc.g(paramVideoInfo.b)) && (knd.i(paramVideoInfo.b));
    }
    
    private void on(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.b.bj.getLayoutParams();
        localMarginLayoutParams.bottomMargin = wja.dp2px(0.0F, mtg.a(mtg.this).getResources());
        this.b.bj.setLayoutParams(localMarginLayoutParams);
        return;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.b.bj.getLayoutParams();
      localMarginLayoutParams.bottomMargin = (wja.dp2px(15.0F, mtg.a(mtg.this).getResources()) - 20);
      this.b.bj.setLayoutParams(localMarginLayoutParams);
    }
    
    public void a(ImageView paramImageView, VideoInfo paramVideoInfo, int paramInt1, int paramInt2)
    {
      if (paramImageView != null)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.hH))
        {
          paramImageView.setImageDrawable(aqdj.a(mtg.a(mtg.this), 1, paramVideoInfo.hH, 1, mtg.a(mtg.this), mtg.a(mtg.this)));
          paramImageView.setOnClickListener(mtg.this);
          paramImageView.setTag(this.b);
        }
      }
      else {
        return;
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = wja.dp2px(paramInt1, mtg.a(mtg.this).getResources());
      localURLDrawableOptions.mRequestHeight = wja.dp2px(paramInt1, mtg.a(mtg.this).getResources());
      localURLDrawableOptions.mLoadingDrawable = mtg.a(mtg.this);
      localURLDrawableOptions.mFailedDrawable = mtg.a(mtg.this);
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramVideoInfo.WC)) {
            break label369;
          }
          localObject1 = new URL("https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
          Object localObject2 = localObject1;
          if (mtg.f(paramVideoInfo))
          {
            String str = paramVideoInfo.b.Ws;
            localObject2 = localObject1;
            if (!TextUtils.isEmpty(str)) {
              localObject2 = new URL(str);
            }
          }
          localObject1 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
          ((URLDrawable)localObject1).setTag(aqbn.d(wja.dp2px(paramInt1, mtg.a(mtg.this).getResources()), wja.dp2px(paramInt1, mtg.a(mtg.this).getResources()), wja.dp2px(paramInt2, mtg.a(mtg.this).getResources())));
          if ((!mtg.f(paramVideoInfo)) || (this.b.jM == null) || (this.b.jM != paramImageView)) {
            break label385;
          }
          ((URLDrawable)localObject1).setTag(new int[] { 0, 0, paramInt2, 3 });
          ((URLDrawable)localObject1).setDecodeHandler(aqbn.j);
          paramImageView.setImageDrawable((Drawable)localObject1);
        }
        catch (MalformedURLException paramVideoInfo) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoItemContentUI() ERROR e = " + paramVideoInfo.getMessage());
        break;
        label369:
        Object localObject1 = new URL(paramVideoInfo.WC);
        continue;
        label385:
        ((URLDrawable)localObject1).setDecodeHandler(aqbn.a);
      }
    }
    
    public void a(mtg.b paramb, VideoInfo paramVideoInfo)
    {
      if ((paramb == null) || (paramb.videoLayout == null) || (mtg.a(mtg.this) == null) || (paramVideoInfo == null)) {}
      int[] arrayOfInt;
      RelativeLayout.LayoutParams localLayoutParams;
      do
      {
        do
        {
          return;
          arrayOfInt = muj.c(mtg.a(mtg.this));
        } while (!(paramb instanceof mtg.b));
        paramb = paramb.videoLayout;
        localLayoutParams = (RelativeLayout.LayoutParams)paramb.getLayoutParams();
      } while ((!paramVideoInfo.k(mtg.a(mtg.this))) || (arrayOfInt[0] == 0) || (arrayOfInt[1] / arrayOfInt[0] <= 1.777778F) || (localLayoutParams == null));
      if (mtg.c(mtg.this) != 0) {
        localLayoutParams.topMargin = mtg.c(mtg.this);
      }
      if (mtg.d(mtg.this) != 0) {
        localLayoutParams.bottomMargin = mtg.d(mtg.this);
      }
      paramb.setLayoutParams(localLayoutParams);
    }
    
    public void b(VideoInfo paramVideoInfo, boolean paramBoolean)
    {
      super.b(paramVideoInfo, paramBoolean);
      mtg.g(mtg.this, false);
      if (this.b.ly != null)
      {
        this.b.ly.setTag(this.b);
        localObject = new GestureDetector(new mtn(this));
        this.b.ly.setOnTouchListener(new mto(this, (GestureDetector)localObject));
      }
      this.b.e.setProgress(0);
      this.b.d.setProgress(0);
      mtg.a(mtg.this, false, this.b);
      if (paramVideoInfo.k(mtg.a(mtg.this))) {
        this.b.w.setImageDrawable(null);
      }
      while (paramVideoInfo.d() == null) {
        return;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.d(), (URLDrawable.URLDrawableOptions)localObject);
      paramVideoInfo.setDecodeHandler(aqbn.w);
      paramVideoInfo.setAlpha(80);
      this.b.w.setImageDrawable(paramVideoInfo);
    }
    
    public void b(mtg.b paramb, VideoInfo paramVideoInfo)
    {
      if (paramb == null) {}
      for (;;)
      {
        return;
        if (g(paramVideoInfo))
        {
          paramb = paramb.bq;
          if ((mtg.d(mtg.this) == 0) && (paramb != null) && (paramb.getLayoutParams() != null)) {
            mtg.b(mtg.this, paramb.getLayoutParams().height);
          }
        }
        while ((mtg.c(mtg.this) == 0) && (mtg.a(mtg.this) != null) && ((mtg.a(mtg.this) instanceof VideoFeedsPlayActivity)) && (((VideoFeedsPlayActivity)mtg.a(mtg.this)).m() != null))
        {
          mtg.c(mtg.this, ((VideoFeedsPlayActivity)mtg.a(mtg.this)).m().getMeasuredHeight());
          return;
          paramb = paramb.rm;
          if ((mtg.d(mtg.this) == 0) && (paramb != null) && (paramb.getLayoutParams() != null)) {
            mtg.b(mtg.this, paramb.getLayoutParams().height);
          }
        }
      }
    }
    
    protected void dW(boolean paramBoolean)
    {
      if (this.b.ly != null)
      {
        boolean bool;
        if (!paramBoolean) {
          if ((mtg.j(mtg.this)) && (!mtg.i(mtg.this)))
          {
            if ((this.b.lJ.getVisibility() == 8) && (!mtg.b(mtg.this)))
            {
              if (this.b.lF != null)
              {
                mtg.a(mtg.this, this.b);
                this.b.lF.setVisibility(0);
              }
              muj.H(this.b.lJ, 0);
            }
            bool = paramBoolean;
            if (mtg.b(mtg.this))
            {
              if (this.b.be.getVisibility() != 8) {
                break label148;
              }
              bool = true;
              this.b.be.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          super.dW(bool);
          return;
          label148:
          bool = paramBoolean;
          if (this.b.be.getVisibility() == 0)
          {
            this.b.be.setVisibility(8);
            bool = paramBoolean;
            continue;
            if ((this.b.ly.getVisibility() == 8) && (!mtg.b(mtg.this))) {
              muj.H(this.b.ly, 0);
            }
            bool = paramBoolean;
            if (this.b.be.getVisibility() == 0)
            {
              this.b.be.setVisibility(8);
              bool = paramBoolean;
              continue;
              if ((mtg.j(mtg.this)) && (!mtg.i(mtg.this)))
              {
                bool = paramBoolean;
                if (this.b.lJ.getVisibility() == 0)
                {
                  if (this.b.lF != null) {
                    this.b.lF.setVisibility(8);
                  }
                  muj.H(this.b.lJ, 8);
                  bool = paramBoolean;
                }
              }
              else
              {
                if (this.b.ly.getVisibility() == 0) {
                  muj.H(this.b.ly, 8);
                }
                bool = paramBoolean;
                if (this.b.be.getVisibility() == 8)
                {
                  this.b.be.setVisibility(0);
                  bool = paramBoolean;
                }
              }
            }
          }
        }
      }
      super.dW(paramBoolean);
      if (paramBoolean)
      {
        this.b.e.setVisibility(8);
        return;
      }
      this.b.e.setVisibility(0);
    }
    
    public void doOnResume()
    {
      if ((this.b != null) && (this.b.rm != null) && (this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null))
      {
        if (mtg.f(this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d))
        {
          this.b.rC.setText(mtg.a(mtg.this, this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d, 1));
          this.b.rv.setText(mtg.a(mtg.this, this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d, 2));
          this.b.lx.setVisibility(8);
          this.b.lv.setVisibility(8);
        }
      }
      else {
        return;
      }
      this.b.rm.setText(mtg.a(mtg.this, this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d, mtg.a(mtg.this).getResources()));
    }
    
    public void e(VideoInfo paramVideoInfo)
    {
      mtg.g(mtg.this, false);
      mtg.b(mtg.this, false);
      b(this.b, paramVideoInfo);
      a(this.b, paramVideoInfo);
      Object localObject5 = mtg.a(mtg.this).getResources();
      if (paramVideoInfo.busiType != 0) {
        if (this.b.itemType == 4)
        {
          this.b.bp.setVisibility(0);
          this.b.bp.setTag(this.b);
          this.b.bp.setOnClickListener(mtg.this);
          this.b.dY.setTag(this.b);
          this.b.dY.setOnClickListener(mtg.this);
          if (!TextUtils.isEmpty(paramVideoInfo.accountName))
          {
            this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.accountName);
            this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setTag(this.b);
            this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(mtg.this);
          }
          this.b.c.setImagePlaceHolder(mtg.a(mtg.this));
          if (TextUtils.isEmpty(paramVideoInfo.hH)) {
            break label899;
          }
          this.b.c.setHeadImgByUin(Long.valueOf(paramVideoInfo.hH).longValue(), false);
          label234:
          this.b.c.setTag(this.b);
          this.b.c.setOnClickListener(mtg.this);
        }
      }
      Object localObject4;
      label606:
      Object localObject6;
      Object localObject7;
      Object localObject8;
      for (;;)
      {
        knd.a(paramVideoInfo, this.b);
        if (this.b.itemType != 4) {
          break label941;
        }
        this.b.fg.setTag(this.b);
        this.b.fg.setOnClickListener(mtg.this);
        this.b.rl.setMaxWidth((int)(((Resources)localObject5).getDisplayMetrics().widthPixels * 0.7D));
        if (!TextUtils.isEmpty(paramVideoInfo.title)) {
          this.b.rl.setText(paramVideoInfo.title);
        }
        this.b.rk.setMaxWidth((int)(((Resources)localObject5).getDisplayMetrics().widthPixels * 0.224D));
        if ((paramVideoInfo.b != null) && (!TextUtils.isEmpty(paramVideoInfo.b.Wi))) {
          this.b.rk.setText(paramVideoInfo.b.Wi);
        }
        if ((mtg.a(mtg.this) == this.b) && (this.b.itemType == 4) && (mtg.a(mtg.this)))
        {
          if (this.b.bp != null) {
            this.b.bp.setVisibility(8);
          }
          if (this.b.bq != null) {
            this.b.bq.setVisibility(8);
          }
        }
        this.b.bk.setVisibility(8);
        if (!g(paramVideoInfo)) {
          break label3304;
        }
        muj.y(paramVideoInfo);
        if (this.b.bq != null)
        {
          this.b.bq.setVisibility(0);
          localObject1 = this.b.e;
          localObject5 = ((SeekBar)localObject1).getLayoutParams();
          if ((localObject5 instanceof LinearLayout.LayoutParams))
          {
            localObject4 = (ViewGroup)((SeekBar)localObject1).getParent();
            ((ViewGroup)localObject4).removeView((View)localObject1);
            localObject5 = (LinearLayout.LayoutParams)localObject5;
            if (!knc.c(paramVideoInfo.b)) {
              break label3280;
            }
            ((LinearLayout.LayoutParams)localObject5).topMargin = 0;
            ((ViewGroup)localObject4).addView((View)localObject1, ((ViewGroup)localObject4).getChildCount() - 2, (ViewGroup.LayoutParams)localObject5);
            localObject1 = this.b.rm;
            localObject4 = this.b.lv;
            localObject5 = this.b.lx;
            localObject6 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
            localObject7 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
            localObject8 = (LinearLayout.LayoutParams)((View)localObject5).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject6).topMargin = wja.dp2px(14.0F, mtg.a(mtg.this).getResources());
            ((LinearLayout.LayoutParams)localObject7).topMargin = wja.dp2px(14.0F, mtg.a(mtg.this).getResources());
            ((LinearLayout.LayoutParams)localObject8).topMargin = wja.dp2px(14.0F, mtg.a(mtg.this).getResources());
            ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject6);
            ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject7);
            ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject8);
          }
          b(this.b, paramVideoInfo);
        }
        label772:
        if (knc.zR())
        {
          this.b.c.setVisibility(8);
          paramVideoInfo = this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getLayoutParams();
          if ((paramVideoInfo instanceof LinearLayout.LayoutParams)) {
            ((LinearLayout.LayoutParams)paramVideoInfo).leftMargin = wja.dp2px(15.0F, mtg.a(mtg.this).getResources());
          }
          this.b.rl.setTextSize(14.0F);
          this.b.rm.setVisibility(8);
        }
        return;
        this.b.bp.setVisibility(8);
        this.b.rj.setTag(this.b);
        this.b.rj.setOnClickListener(mtg.this);
        break;
        label899:
        if (TextUtils.isEmpty(paramVideoInfo.WC)) {
          break label234;
        }
        this.b.c.setImageSrc(paramVideoInfo.WC);
        break label234;
        this.b.bp.setVisibility(8);
      }
      label941:
      int i;
      try
      {
        localObject1 = new JSONObject(paramVideoInfo.b.mAdExtInfo);
        if (((JSONObject)localObject1).has("down_time"))
        {
          i = ((JSONObject)localObject1).optInt("down_time") * 1000;
          if (i > 0) {
            this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.setDuration(i);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "has downtime!! down_time=" + i);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          label1600:
          localJSONException.printStackTrace();
          continue;
          this.b.rv.setText(mtg.a(mtg.this, paramVideoInfo, (Resources)localObject5));
          continue;
          label1846:
          this.b.eb.setVisibility(0);
          this.b.rz.setText(paramVideoInfo.b.Wv);
          this.b.eb.setTag(this.b);
          this.b.eb.setOnClickListener(mtg.this);
        }
        label1905:
        if ((this.b.rx == null) || (paramVideoInfo.b == null) || (TextUtils.isEmpty(paramVideoInfo.b.Wt))) {
          break label1980;
        }
        this.b.rx.setOnClickListener(mtg.this);
        this.b.rx.setText(paramVideoInfo.b.Wt);
        this.b.rx.setTag(this.b);
        label1980:
        if (!mtg.f(paramVideoInfo)) {
          break label2151;
        }
        this.b.rB.setText(paramVideoInfo.b.Wt);
        this.b.rC.setText(mtg.a(mtg.this, paramVideoInfo, 1));
        a(this.b.jM, paramVideoInfo, 32, 6);
        this.b.rB.setOnClickListener(mtg.this);
        this.b.rB.setTag(this.b);
        this.b.rC.setOnClickListener(mtg.this);
        this.b.rC.setTag(this.b);
        this.b.jM.setOnClickListener(mtg.this);
        this.b.jM.setTag(this.b);
        this.b.fi.setOnClickListener(mtg.this);
        this.b.fi.setTag(this.b);
        label2151:
        if (!mtg.f(paramVideoInfo)) {
          break label3185;
        }
      }
      if (this.b.rv != null)
      {
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setCornerRadius(Utils.dp2px(6.0D));
        ((GradientDrawable)localObject1).setColor(Color.parseColor("#FF00CAFC"));
        this.b.rv.setBackgroundDrawable((Drawable)localObject1);
        mtg.b(mtg.this, this.b);
      }
      if (this.b.lE != null)
      {
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setCornerRadius(Utils.dp2px(2.0D));
        ((GradientDrawable)localObject1).setColor(Color.parseColor("#12B7F6"));
        this.b.lE.setBackgroundDrawable((Drawable)localObject1);
      }
      if (this.b.lJ != null)
      {
        if (this.b.lF != null) {
          this.b.lF.setVisibility(8);
        }
        if (this.b.lG != null)
        {
          this.b.lG.setOnClickListener(mtg.this);
          this.b.lG.setTag(this.b);
        }
        this.b.lJ.setVisibility(8);
        this.b.lJ.setOnClickListener(mtg.this);
        this.b.lJ.getParent().requestDisallowInterceptTouchEvent(true);
        this.b.lJ.setTag(this.b);
      }
      Object localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(Utils.dp2px(6.0D));
      ((GradientDrawable)localObject1).setColor(Color.parseColor("#ffffff"));
      this.b.lK.setBackgroundDrawable((Drawable)localObject1);
      this.b.lL.setOnClickListener(mtg.this);
      this.b.lL.setTag(this.b);
      int j;
      int k;
      if (mtg.f(paramVideoInfo))
      {
        this.b.rv.setText(mtg.a(mtg.this, paramVideoInfo, 2));
        this.b.rv.setOnClickListener(mtg.this);
        this.b.rv.setTag(this.b);
        if (paramVideoInfo.b == null) {
          break label1980;
        }
        if (this.b.rA != null)
        {
          this.b.rA.setText(paramVideoInfo.b.Wu);
          this.b.rA.setTag(this.b);
          this.b.rA.setOnClickListener(mtg.this);
        }
        if (this.b.rz != null)
        {
          if (!TextUtils.isEmpty(paramVideoInfo.b.Wv)) {
            break label1846;
          }
          this.b.eb.setVisibility(8);
          localObject1 = (LinearLayout.LayoutParams)this.b.ec.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).setMargins(0, ((LinearLayout.LayoutParams)localObject1).topMargin, ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
          this.b.ec.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if ((paramVideoInfo.b.jP.size() <= 0) || (this.b.ec == null)) {
          break label1905;
        }
        this.b.ec.removeAllViews();
        i = this.b.eb.getWidth();
        localObject1 = paramVideoInfo.b.jP.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject6 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject6).rightMargin = wja.dp2px(6.0F, mtg.a(mtg.this).getResources());
            localObject7 = new TextView(mtg.a(mtg.this));
            ((TextView)localObject7).setTextSize(10.0F);
            ((TextView)localObject7).setTextColor(Color.parseColor("#737373"));
            ((TextView)localObject7).setIncludeFontPadding(false);
            ((TextView)localObject7).setBackgroundResource(2130850184);
            ((TextView)localObject7).setText((CharSequence)localObject4);
            ((TextView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject6);
            ((TextView)localObject7).setOnClickListener(new mtp(this, paramVideoInfo));
            j = kxm.a(mtg.a(mtg.this))[0];
            k = wja.dp2px(125.0F, (Resources)localObject5);
            int m = (int)((TextView)localObject7).getPaint().measureText((String)localObject4);
            if (i + m >= j - k) {
              break label3575;
            }
            this.b.ec.addView((View)localObject7);
            i = m + i + 6;
          }
        }
      }
      label2181:
      label3185:
      label3575:
      for (;;)
      {
        break label1600;
        this.b.fh.setVisibility(0);
        this.b.ea.setVisibility(8);
        if (this.b.rt != null)
        {
          if (!TextUtils.isEmpty(paramVideoInfo.accountName)) {
            this.b.rt.setText(paramVideoInfo.accountName);
          }
          this.b.rt.setOnClickListener(mtg.this);
          this.b.rt.setTag(this.b);
        }
        if (this.b.ru != null)
        {
          if (!TextUtils.isEmpty(paramVideoInfo.title)) {
            this.b.ru.setText(paramVideoInfo.title);
          }
          this.b.ru.setOnClickListener(mtg.this);
          this.b.ru.setTag(this.b);
        }
        i = 12;
        if (mtg.f(paramVideoInfo)) {
          i = 2;
        }
        a(this.b.jL, paramVideoInfo, 60, i);
        this.b.ly.setVisibility(0);
        this.b.fg.setVisibility(8);
        mtg.a(mtg.this, false, this.b);
        localObject6 = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(paramVideoInfo.title))
        {
          ((SpannableStringBuilder)localObject6).append(kxm.E(paramVideoInfo.title, 72));
          ((SpannableStringBuilder)localObject6).append("  ");
        }
        localObject4 = "";
        j = 1;
        for (;;)
        {
          try
          {
            localObject7 = new JSONObject(paramVideoInfo.b.mAdExtInfo);
            i = j;
            localObject2 = localObject4;
            if (((JSONObject)localObject7).has("AdsIconText"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "detail ad  video in new style adInconText:" + ((JSONObject)localObject7).optString("AdsIconText"));
              }
              if (TextUtils.isEmpty(((JSONObject)localObject7).optString("AdsIconText"))) {
                continue;
              }
              localObject2 = ((JSONObject)localObject7).optString("AdsIconText");
              i = j;
            }
          }
          catch (Exception localException)
          {
            Object localObject2;
            float f;
            RectF localRectF1;
            RectF localRectF2;
            RectF localRectF3;
            localException.printStackTrace();
            i = j;
            localObject3 = localObject4;
            continue;
            localObject3 = new RectF(0.0F, j, i, k - j);
            ((Paint)localObject4).setColor(452984831);
            ((Canvas)localObject8).drawRoundRect((RectF)localObject3, 2.0F, 2.0F, (Paint)localObject4);
            continue;
          }
          if (i != 0)
          {
            localObject4 = new Paint();
            ((Paint)localObject4).setAntiAlias(true);
            ((Paint)localObject4).setStyle(Paint.Style.FILL);
            ((Paint)localObject4).setTextSize(wja.dp2px(10.0F, (Resources)localObject5));
            ((Paint)localObject4).setColor(-1291845633);
            f = ((Paint)localObject4).measureText((String)localObject2);
            i = wja.dp2px(6.0F, (Resources)localObject5);
            i = (int)f + i;
            j = wja.dp2px(1.0F, (Resources)localObject5) / 2;
            k = wja.dp2px(14.0F, (Resources)localObject5);
            localObject7 = Bitmap.createBitmap(i, k, Bitmap.Config.ARGB_8888);
            localObject8 = new Canvas((Bitmap)localObject7);
            ((Canvas)localObject8).drawText((String)localObject2, wja.dp2px(3.0F, (Resources)localObject5), k / 2 - (((Paint)localObject4).descent() + ((Paint)localObject4).ascent()) / 2.0F, (Paint)localObject4);
            if (knc.zR()) {
              continue;
            }
            localObject2 = new RectF(j, k, i - j, k - j);
            localRectF1 = new RectF(j, j, i - j, 0.0F);
            localRectF2 = new RectF(0.0F, k - j, j, j);
            localRectF3 = new RectF(i - j, k - j, i, j);
            ((Canvas)localObject8).drawRect((RectF)localObject2, (Paint)localObject4);
            ((Canvas)localObject8).drawRect(localRectF1, (Paint)localObject4);
            ((Canvas)localObject8).drawRect(localRectF2, (Paint)localObject4);
            ((Canvas)localObject8).drawRect(localRectF3, (Paint)localObject4);
            ((SpannableStringBuilder)localObject6).setSpan(new VerticalCenterImageSpan(mtg.a(mtg.this), (Bitmap)localObject7), ((SpannableStringBuilder)localObject6).length() - 1, ((SpannableStringBuilder)localObject6).length(), 33);
            ((SpannableStringBuilder)localObject6).setSpan(new mtq(this), ((SpannableStringBuilder)localObject6).length() - 1, ((SpannableStringBuilder)localObject6).length(), 33);
            localObject2 = this.b.rl;
            ((TextView)localObject2).setPadding(((TextView)localObject2).getPaddingLeft(), ((TextView)localObject2).getPaddingTop(), ((TextView)localObject2).getPaddingRight(), wja.dp2px(1.0F, (Resources)localObject5));
          }
          this.b.rl.setMovementMethod(LinkMovementMethod.getInstance());
          this.b.rl.setText((CharSequence)localObject6);
          this.b.rl.setTag(this.b);
          this.b.rl.setOnClickListener(mtg.this);
          if (this.b.lB != null) {
            this.b.lB.setOnClickListener(null);
          }
          a(this.b.jK, paramVideoInfo, 70, 11);
          if (this.b.rq != null)
          {
            if (!TextUtils.isEmpty(paramVideoInfo.accountName)) {
              this.b.rq.setText(paramVideoInfo.accountName);
            }
            this.b.rq.setOnClickListener(mtg.this);
            this.b.rq.setTag(this.b);
          }
          if (this.b.rr != null)
          {
            i = wja.dp2px(12.0F, (Resources)localObject5);
            localObject2 = ((Resources)localObject5).getDrawable(2130843917);
            ((Drawable)localObject2).setBounds(0, 0, i, i);
            this.b.rr.setCompoundDrawables((Drawable)localObject2, null, null, null);
          }
          if (this.b.lD != null)
          {
            this.b.lD.setOnClickListener(mtg.this);
            this.b.lD.setTag(this.b);
          }
          if (this.b.lE == null) {
            break;
          }
          this.b.lE.setOnClickListener(mtg.this);
          this.b.lE.setTag(this.b);
          break;
          this.b.fh.setVisibility(8);
          this.b.ea.setVisibility(0);
          break label2181;
          i = 0;
          localObject2 = localObject4;
        }
        ((LinearLayout.LayoutParams)localObject5).topMargin = wja.dp2px(7.0F, mtg.a(mtg.this).getResources());
        break label606;
        Object localObject3 = this.b.e;
        localObject5 = ((SeekBar)localObject3).getLayoutParams();
        if ((localObject5 instanceof LinearLayout.LayoutParams))
        {
          localObject4 = (ViewGroup)((SeekBar)localObject3).getParent();
          ((ViewGroup)localObject4).removeView((View)localObject3);
          localObject5 = (LinearLayout.LayoutParams)localObject5;
          i = 3;
          if (mtg.f(paramVideoInfo))
          {
            i = 4;
            ((LinearLayout.LayoutParams)localObject5).bottomMargin = wja.dp2px(0.5F, mtg.a(mtg.this).getResources());
          }
          ((LinearLayout.LayoutParams)localObject5).topMargin = wja.dp2px(10, mtg.a(mtg.this).getResources());
          ((ViewGroup)localObject4).addView((View)localObject3, i, (ViewGroup.LayoutParams)localObject5);
          paramVideoInfo = this.b.rm;
          localObject3 = this.b.lv;
          localObject4 = this.b.lx;
          localObject5 = (LinearLayout.LayoutParams)paramVideoInfo.getLayoutParams();
          localObject6 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
          localObject7 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject5).topMargin = wja.dp2px(0.0F, mtg.a(mtg.this).getResources());
          ((LinearLayout.LayoutParams)localObject6).topMargin = wja.dp2px(7.0F, mtg.a(mtg.this).getResources());
          ((LinearLayout.LayoutParams)localObject7).topMargin = wja.dp2px(15.0F, mtg.a(mtg.this).getResources());
          paramVideoInfo.setLayoutParams((ViewGroup.LayoutParams)localObject5);
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject6);
          ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject7);
        }
        if (this.b.bq == null) {
          break label772;
        }
        this.b.bq.setVisibility(8);
        break label772;
      }
    }
    
    public void f(VideoInfo paramVideoInfo)
    {
      super.f(paramVideoInfo);
    }
    
    public void k(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (mtg.a(mtg.this) != null) {
        mtg.a(mtg.this).y(paramInt1, paramInt2);
      }
      if (paramBoolean) {
        aRJ();
      }
    }
    
    public void nX(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        mtg.k(mtg.this, true);
        mtg.g(mtg.this, true);
        if (!paramBoolean) {
          break label146;
        }
        if (!this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.k(mtg.a(mtg.this)))
        {
          this.b.bf.setPadding(0, 0, 0, muj.m(mtg.a(mtg.this)));
          on(true);
        }
        if (this.b.be.getVisibility() == 0) {
          this.b.be.setVisibility(8);
        }
        if (this.b.ly != null) {
          this.b.ly.setVisibility(8);
        }
      }
      label146:
      label235:
      do
      {
        do
        {
          return;
          mtg.k(mtg.this, false);
          mtg.g(mtg.this, false);
          break;
          if (this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.k(mtg.a(mtg.this))) {
            break label235;
          }
          this.b.bf.setPadding(0, 0, 0, 0);
          on(false);
        } while ((this.b.be == null) || (this.b.be.getVisibility() != 8) || (this.b.ly == null));
        this.b.ly.setVisibility(0);
        return;
      } while ((this.b.be == null) || (this.b.be.getVisibility() != 8) || (this.b.ly == null));
      this.b.ly.setVisibility(0);
    }
    
    public void nY(boolean paramBoolean) {}
    
    public void onVideoClick()
    {
      boolean bool2 = true;
      boolean bool1 = true;
      if ((mtg.j(mtg.this)) && (!mtg.i(mtg.this)))
      {
        if (this.b.lJ.getVisibility() == 0) {}
        for (;;)
        {
          mtg.i(mtg.this, bool1);
          dW(bool1);
          return;
          bool1 = false;
        }
      }
      if (this.b.be.getVisibility() == 8) {}
      for (bool1 = bool2;; bool1 = false)
      {
        dW(bool1);
        return;
      }
    }
    
    public void onVisibilityChanged(boolean paramBoolean)
    {
      dW(false);
      if (((this.b.itemType == 5) || (this.b.itemType == 7)) && (!paramBoolean))
      {
        mtg.a(mtg.this, false, this.b);
        if (this.b.e != null) {
          this.b.e.setProgress(0);
        }
        if (this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
        {
          this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(4);
          this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.mz(false);
          this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.resetState();
        }
      }
    }
  }
  
  public static class b
    extends mtg.l
  {
    ProgressBar A;
    ProgressBar B;
    ReadInJoyAdGestureView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView;
    CircleCountdownView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView;
    public boolean aor;
    LinearLayout dY;
    LinearLayout dZ;
    LinearLayout ea;
    LinearLayout eb;
    LinearLayout ec;
    RelativeLayout fg;
    RelativeLayout fh;
    RelativeLayout fi;
    ImageView jI;
    ImageView jJ;
    ImageView jK;
    ImageView jL;
    ImageView jM;
    ImageView jN;
    View lA;
    View lB;
    View lC;
    View lD;
    View lE;
    View lF;
    View lG;
    View lH;
    View lI;
    View lJ;
    View lK;
    View lL;
    View lM;
    View lv;
    View lw;
    public View lx;
    View ly;
    View lz;
    TextView rA;
    TextView rB;
    TextView rC;
    TextView rj;
    TextView rk;
    public TextView rl;
    TextView rm;
    TextView rn;
    TextView ro;
    TextView rp;
    TextView rq;
    TextView rr;
    TextView rs;
    TextView rt;
    TextView ru;
    TextView rv;
    TextView rw;
    TextView rx;
    TextView ry;
    TextView rz;
    URLImageView w;
    
    public b(View paramView, int paramInt)
    {
      super(paramInt);
      if (paramInt == 4)
      {
        this.bp = ((ViewGroup)paramView.findViewById(2131368467));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131368439));
        this.c = ((ReadInJoyHeadImageView)paramView.findViewById(2131368436));
        this.dY = ((LinearLayout)paramView.findViewById(2131362109));
        this.rj = ((TextView)paramView.findViewById(2131362110));
        this.jI = ((ImageView)paramView.findViewById(2131362108));
        this.fg = ((RelativeLayout)paramView.findViewById(2131362087));
        this.rk = ((TextView)paramView.findViewById(2131362098));
        this.rl = ((TextView)paramView.findViewById(2131362062));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView = ((ReadInJoyAdGestureView)paramView.findViewById(2131362053));
        this.dZ = ((LinearLayout)paramView.findViewById(2131362123));
        this.ly = paramView.findViewById(2131362124);
        this.lz = paramView.findViewById(2131362125);
        this.lA = paramView.findViewById(2131362126);
        return;
        if ((paramInt == 5) || (paramInt == 7))
        {
          this.bp = ((ViewGroup)paramView.findViewById(2131368467));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131362118));
          this.c = ((ReadInJoyHeadImageView)paramView.findViewById(2131362116));
          this.rj = ((TextView)paramView.findViewById(2131362120));
          this.fg = ((RelativeLayout)paramView.findViewById(2131362087));
          this.rk = ((TextView)paramView.findViewById(2131362098));
          this.rl = ((TextView)paramView.findViewById(2131362121));
          this.rm = ((TextView)paramView.findViewById(2131362088));
          this.lv = paramView.findViewById(2131362089);
          this.rn = ((TextView)paramView.findViewById(2131362092));
          this.lw = paramView.findViewById(2131362090);
          this.ro = ((TextView)paramView.findViewById(2131362091));
          this.lB = paramView.findViewById(2131368259);
          this.lC = paramView.findViewById(2131368238);
          this.jK = ((ImageView)paramView.findViewById(2131368249));
          this.rq = ((TextView)paramView.findViewById(2131368260));
          this.lD = paramView.findViewById(2131368266);
          this.rr = ((TextView)paramView.findViewById(2131368268));
          this.lE = paramView.findViewById(2131368246);
          this.rs = ((TextView)paramView.findViewById(2131368248));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView = ((CircleCountdownView)paramView.findViewById(2131368264));
          this.lx = paramView.findViewById(2131362094);
          this.A = ((ProgressBar)paramView.findViewById(2131362095));
          this.A.setClickable(false);
          this.A.setFocusable(false);
          this.A.setEnabled(false);
          this.rp = ((TextView)paramView.findViewById(2131362097));
          this.jJ = ((ImageView)paramView.findViewById(2131362096));
          this.jJ.setVisibility(0);
          this.jJ.setImageResource(2130843549);
          this.aor = false;
          this.w = ((URLImageView)paramView.findViewById(2131363240));
          this.fi = ((RelativeLayout)paramView.findViewById(2131366106));
          this.jM = ((ImageView)paramView.findViewById(2131366108));
          this.rB = ((TextView)paramView.findViewById(2131366109));
          this.rC = ((TextView)paramView.findViewById(2131366104));
          this.jN = ((ImageView)paramView.findViewById(2131366103));
          this.lF = paramView.findViewById(2131362104);
          this.lG = paramView.findViewById(2131362101);
          this.lH = paramView.findViewById(2131362102);
          this.lI = paramView.findViewById(2131362103);
          this.lJ = paramView.findViewById(2131368230);
          this.jL = ((ImageView)paramView.findViewById(2131368231));
          this.lK = paramView.findViewById(2131368229);
          this.rt = ((TextView)paramView.findViewById(2131368232));
          this.ru = ((TextView)paramView.findViewById(2131368233));
          this.rv = ((TextView)paramView.findViewById(2131368242));
          this.lM = paramView.findViewById(2131362100);
          this.B = ((ProgressBar)paramView.findViewById(2131362105));
          this.B.setClickable(false);
          this.B.setFocusable(false);
          this.B.setEnabled(false);
          this.rw = ((TextView)paramView.findViewById(2131362106));
          this.lL = paramView.findViewById(2131368236);
          this.ea = ((LinearLayout)paramView.findViewById(2131372457));
          this.fh = ((RelativeLayout)paramView.findViewById(2131366105));
          this.eb = ((LinearLayout)paramView.findViewById(2131366113));
          this.ec = ((LinearLayout)paramView.findViewById(2131366110));
          this.rx = ((TextView)paramView.findViewById(2131366107));
          this.ry = ((TextView)paramView.findViewById(2131366114));
          this.rz = ((TextView)paramView.findViewById(2131366112));
          this.rA = ((TextView)paramView.findViewById(2131366111));
        }
      }
    }
    
    public ReadInJoyAdGestureView a()
    {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView;
    }
    
    public void a(mtg parammtg, LinearLayoutManager paramLinearLayoutManager, boolean paramBoolean)
    {
      int i = 1;
      super.a(parammtg, paramLinearLayoutManager, paramBoolean);
      if (paramLinearLayoutManager.getOrientation() == 1)
      {
        if (i == 0) {
          break label129;
        }
        i = paramLinearLayoutManager.getDecoratedMeasuredHeight(this.itemView);
      }
      for (float f1 = Math.abs(paramLinearLayoutManager.getDecoratedTop(this.itemView) - (paramLinearLayoutManager.getHeight() / 2 - i / 2)) / i;; f1 = Math.abs(paramLinearLayoutManager.getDecoratedLeft(this.itemView) - (paramLinearLayoutManager.getWidth() / 2 - i / 2)) / i)
      {
        float f2 = Math.round(f1 * 100.0F) / 100.0F;
        f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        if ((paramBoolean) && (f1 <= 0.5D)) {
          parammtg.aRW();
        }
        kmw.a(mtg.a(parammtg), f1, this, paramBoolean);
        return;
        i = 0;
        break;
        label129:
        i = paramLinearLayoutManager.getDecoratedMeasuredWidth(this.itemView);
      }
    }
    
    public LinearLayout c()
    {
      return this.dY;
    }
    
    public TextView r()
    {
      return this.rj;
    }
  }
  
  class c
    extends RecyclerView.AdapterDataObserver
  {
    private c() {}
    
    public void onChanged() {}
    
    public void onItemRangeChanged(int paramInt1, int paramInt2) {}
    
    public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      onItemRangeChanged(paramInt1, paramInt2);
    }
  }
  
  public static abstract interface d
  {
    public abstract void aSb();
    
    public abstract void d(VideoInfo paramVideoInfo, boolean paramBoolean);
    
    public abstract void f(mtg.l paraml);
    
    public abstract void onProgressChanged(long paramLong);
  }
  
  public static class e
    extends RecyclerView.ViewHolder
  {
    public VideoFeedsAlphaMaskView a;
    public int aUv;
    public boolean aos;
    public final int itemType;
    public int position;
    
    public e(View paramView, int paramInt)
    {
      super();
      this.a = ((VideoFeedsAlphaMaskView)paramView.findViewById(2131365079));
      this.itemType = paramInt;
    }
    
    public void a(mtg parammtg, LinearLayoutManager paramLinearLayoutManager, boolean paramBoolean)
    {
      int i = 1;
      if ((this.a == null) || (this.a.getVisibility() != 0)) {
        return;
      }
      if (paramLinearLayoutManager.getOrientation() == 1)
      {
        if (i == 0) {
          break label118;
        }
        i = paramLinearLayoutManager.getDecoratedMeasuredHeight(this.itemView);
      }
      for (float f1 = Math.abs(paramLinearLayoutManager.getDecoratedTop(this.itemView) - (paramLinearLayoutManager.getHeight() / 2 - i / 2)) / i;; f1 = Math.abs(paramLinearLayoutManager.getDecoratedLeft(this.itemView) - (paramLinearLayoutManager.getWidth() / 2 - i / 2)) / i)
      {
        float f2 = Math.round(f1 * 100.0F) / 100.0F;
        f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        this.a.setAlpha(f1);
        return;
        i = 0;
        break;
        label118:
        i = paramLinearLayoutManager.getDecoratedMeasuredWidth(this.itemView);
      }
    }
  }
  
  public abstract class f
    implements mrx
  {
    private mtg.g e;
    
    public f(mtg.g paramg)
    {
      this.e = paramg;
    }
    
    private boolean a(ImageView paramImageView, URL paramURL)
    {
      boolean bool = true;
      Object localObject = mtg.a(mtg.this).getIntent();
      int j = ((Intent)localObject).getIntExtra("item_width", 0);
      int i = ((Intent)localObject).getIntExtra("item_height", 0);
      j = ((Intent)localObject).getIntExtra("item_image_width", j);
      i = ((Intent)localObject).getIntExtra("item_image_height", i);
      if ((j == 0) || (i == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "tryLoadExtraCoverCache: width or height = 0");
        }
        bool = false;
      }
      do
      {
        do
        {
          return bool;
          localObject = new noz();
          ((noz)localObject).url = kxm.b(paramURL.toString());
          ((noz)localObject).reqWidth = j;
          ((noz)localObject).reqHeight = i;
          localObject = noy.a().a((noz)localObject);
          if ((localObject == null) || (((nov)localObject).Q() == null)) {
            break;
          }
          paramImageView.setImageDrawable(new npf(((nov)localObject).Q()));
        } while (!QLog.isDevelopLevel());
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "tryLoadExtraCoverCache: ImageManager hitCache");
        return true;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = j;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
        paramURL = URLDrawable.getDrawable(paramURL, (URLDrawable.URLDrawableOptions)localObject);
        if ((paramURL == null) || (paramURL.getStatus() != 1)) {
          break;
        }
        paramImageView.setImageDrawable(paramURL);
      } while (!QLog.isDevelopLevel());
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "tryLoadExtraCoverCache: urlDrawable hitCache");
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "tryLoadExtraCoverCache: missCache");
      }
      return false;
    }
    
    private boolean a(mtg.g paramg)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (mtg.a(mtg.this) != null)
      {
        bool1 = bool2;
        if (aqiw.isMobileNetWork(mtg.a(mtg.this)))
        {
          bool1 = bool2;
          if (paramg != null)
          {
            bool1 = bool2;
            if (paramg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null)
            {
              bool1 = bool2;
              if (paramg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null)
              {
                bool1 = bool2;
                if (paramg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.ry >= 0L)
                {
                  bool1 = bool2;
                  if ((paramg instanceof mtg.l))
                  {
                    bool1 = bool2;
                    if (!mtg.a(mtg.this, (mtg.l)paramg)) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    
    private void e(VideoInfo paramVideoInfo, boolean paramBoolean)
    {
      ViewGroup.LayoutParams localLayoutParams = this.e.itemView.getLayoutParams();
      int i = paramVideoInfo.i(mtg.a(mtg.this));
      int j = muj.c(mtg.a(mtg.this))[0];
      if (paramBoolean)
      {
        localLayoutParams.height = -1;
        localLayoutParams.width = -1;
      }
      for (;;)
      {
        this.e.itemView.setLayoutParams(localLayoutParams);
        return;
        if (paramVideoInfo.j(mtg.a(mtg.this))) {}
        for (localLayoutParams.height = i;; localLayoutParams.height = i)
        {
          if (!this.e.aos) {
            break label115;
          }
          localLayoutParams.width = -1;
          break;
        }
        label115:
        localLayoutParams.width = (j - 2);
      }
    }
    
    private void f(VideoInfo paramVideoInfo, boolean paramBoolean)
    {
      int i = paramVideoInfo.j(mtg.a(mtg.this));
      ViewGroup.LayoutParams localLayoutParams = this.e.x.getLayoutParams();
      if (paramBoolean)
      {
        localLayoutParams.height = -1;
        localLayoutParams.width = -1;
      }
      for (;;)
      {
        this.e.x.setLayoutParams(localLayoutParams);
        return;
        localLayoutParams.width = -1;
        if (paramVideoInfo.k(mtg.a(mtg.this)) != 2) {
          break;
        }
        localLayoutParams.height = -1;
      }
      if (i > 0) {}
      for (;;)
      {
        localLayoutParams.height = i;
        break;
        i = -1;
      }
    }
    
    public void S(float paramFloat)
    {
      this.e.jdField_a_of_type_Mxy.oJ(false);
      if (this.e.be.getVisibility() == 0)
      {
        this.e.d.setEnabled(false);
        this.e.d.setProgress((int)(100.0F * paramFloat));
        this.e.rD.setVisibility(8);
        this.e.rF.setVisibility(8);
        this.e.jP.setVisibility(0);
        if (paramFloat == 0.0F) {
          this.e.jP.setEnabled(false);
        }
      }
      for (;;)
      {
        mtg.a(mtg.this).removeMessages(0);
        mtg.a(mtg.this).sendEmptyMessageDelayed(0, 1500L);
        return;
        this.e.jP.setEnabled(true);
        continue;
        this.e.e.setEnabled(false);
        this.e.e.setProgress((int)(100.0F * paramFloat));
      }
    }
    
    public void Z(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (a(this.e)) {
        a(this.e, mtg.k(mtg.this));
      }
      for (;;)
      {
        this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(0.0F);
        if ((this.e.aUv != 0) || (this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.busiType != 0)) {
          break;
        }
        dW(true);
        return;
        this.e.bg.setVisibility(8);
      }
      dW(false);
    }
    
    protected void a(mtg.g paramg, boolean paramBoolean)
    {
      Object localObject = paramg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
      if (paramBoolean) {}
      for (;;)
      {
        paramg.jO.setVisibility(8);
        localObject = mtg.a(mtg.this).getResources().getDrawable(2130843983);
        paramg.ps.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
        paramg.ps.setCompoundDrawablePadding(wja.dp2px(6.0F, mtg.a(mtg.this).getResources()));
        paramg.ps.setVisibility(0);
        paramg.ps.setOnClickListener(mtg.this);
        paramg.ps.setTag(paramg);
        if ((!paramBoolean) && (!TextUtils.isEmpty(aqux.pT("kandian"))))
        {
          paramg.pt.setVisibility(0);
          muj.a(mtg.a(mtg.this), paramg.pt);
        }
        return;
        muj.ax(((VideoInfo)localObject).ry);
      }
    }
    
    public void aRH()
    {
      e(this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d, mtg.a(mtg.this));
      f(this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d, mtg.a(mtg.this));
    }
    
    public void aRI()
    {
      if (mtg.a(mtg.this).be.getVisibility() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        oo(bool);
        return;
      }
    }
    
    public void b(VideoInfo paramVideoInfo, boolean paramBoolean)
    {
      this.e.bk.setTag(this.e);
      this.e.bk.setOnClickListener(mtg.this);
      paramVideoInfo.i(mtg.a(mtg.this));
      int i = muj.c(mtg.a(mtg.this))[0];
      int j = paramVideoInfo.j(mtg.a(mtg.this));
      e(paramVideoInfo, mtg.a(mtg.this));
      this.e.bf.setOnClickListener(mtg.this);
      this.e.bf.setTag(this.e);
      if ((paramVideoInfo.width > 0) && (paramVideoInfo.height > 0) && (paramVideoInfo.height < 10000) && (paramVideoInfo.width < 10000) && (this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "refreshContentUI: setFixedSize width=" + paramVideoInfo.width + ", height=" + paramVideoInfo.height);
        }
        this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e.setXYaxis(paramVideoInfo.k(mtg.a(mtg.this)));
        if (this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e.b() != null) {
          this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e.b().setFixedSize(paramVideoInfo.width, paramVideoInfo.height);
        }
      }
      this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setTag(this.e);
      this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(mtg.this);
      this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(mtg.a(mtg.this));
      this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(mtg.a(mtg.this));
      this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(409409L);
      this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(mtg.a(mtg.this));
      this.e.jO.setBackgroundDrawable(null);
      this.e.jO.setTag(this.e);
      this.e.jO.setOnClickListener(mtg.this);
      URL localURL = paramVideoInfo.d();
      URLImageView localURLImageView = this.e.x;
      f(paramVideoInfo, mtg.a(mtg.this));
      if (localURL != null)
      {
        if ((this.e.aUv != 0) || (this.e.position != 0) || (!a(localURLImageView, localURL)))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = i;
          localURLDrawableOptions.mRequestHeight = j;
          localURLDrawableOptions.mPlayGifImage = true;
          localURLDrawableOptions.mLoadingDrawable = mtg.a(mtg.this);
          localURLDrawableOptions.mFailedDrawable = mtg.a(mtg.this);
          localURLImageView.setImageDrawable(URLDrawable.getDrawable(localURL, localURLDrawableOptions));
        }
        localURLImageView.setVisibility(0);
        this.e.d.setProgress(0);
        muj.a(this.e.rD, 0L);
        muj.a(this.e.rF, paramVideoInfo.getDuration() * 1000);
        if ((mtg.c(mtg.this)) || (this.e.aUv != 0)) {
          break label803;
        }
        this.e.bg.setVisibility(0);
        label609:
        this.e.be.setVisibility(8);
        this.e.e.setProgress(0);
        this.e.bi.setTag(this.e);
        this.e.bi.setOnClickListener(mtg.this);
        this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(1.0F);
        this.e.rG.setVisibility(8);
        this.e.jO.setVisibility(0);
        this.e.ps.setVisibility(8);
        this.e.pt.setVisibility(8);
        this.e.lN.setVisibility(8);
        if (this.e.jR != null)
        {
          this.e.jR.setOnClickListener(mtg.this);
          this.e.jR.setTag(this.e);
          if (!nbs.a.Fg()) {
            break label818;
          }
          this.e.jR.setVisibility(0);
        }
      }
      for (;;)
      {
        dW(false);
        return;
        localURLImageView.setImageDrawable(null);
        break;
        label803:
        this.e.bg.setVisibility(8);
        break label609;
        label818:
        this.e.jR.setVisibility(8);
      }
    }
    
    protected void dW(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        if (this.e.be.getVisibility() == 8) {
          muj.H(this.e.be, 0);
        }
        if (this.e.bg.getVisibility() == 8) {
          muj.H(this.e.bg, 0);
        }
      }
      for (;;)
      {
        oo(paramBoolean);
        return;
        if (this.e.be.getVisibility() == 0) {
          muj.H(this.e.be, 8);
        }
        if ((mtg.a(mtg.this).isPlaying()) && (this.e.bg.getVisibility() == 0)) {
          muj.H(this.e.bg, 8);
        }
        if (mtg.a(mtg.this)) {
          this.e.e.setVisibility(8);
        } else {
          this.e.e.setVisibility(0);
        }
      }
    }
    
    public void nX(boolean paramBoolean) {}
    
    public void nY(boolean paramBoolean)
    {
      e(this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d, paramBoolean);
      f(this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d, paramBoolean);
      if (paramBoolean)
      {
        this.e.bh.setVisibility(0);
        this.e.jQ.setBackgroundDrawable(mtg.a(mtg.this, 2130842612));
        this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setVisibility(8);
      }
      for (;;)
      {
        if ((mtg.a(mtg.this) != null) && (mtg.a(mtg.this).isShowing())) {
          mtg.a(mtg.this).dismiss();
        }
        if (mtg.a(mtg.this) != null) {
          mtg.a(mtg.this).dismiss();
        }
        this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(paramBoolean);
        this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.resetUI();
        dW(false);
        if (ayxa.isLiuHaiUseValid())
        {
          if (!paramBoolean) {
            break;
          }
          this.e.be.setPadding(ayxa.getNotchInScreenHeight(mtg.a(mtg.this)), 0, ayxa.getNotchInScreenHeight(mtg.a(mtg.this)), 0);
        }
        return;
        this.e.bh.setVisibility(8);
        this.e.jQ.setBackgroundDrawable(mtg.a(mtg.this, 2130842613));
        this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setVisibility(0);
      }
      this.e.be.setPadding(0, 0, 0, 0);
    }
    
    public void nZ(boolean paramBoolean)
    {
      dW(paramBoolean);
    }
    
    public void oa(boolean paramBoolean)
    {
      if (paramBoolean) {
        if (this.e.jO != null)
        {
          this.e.jO.setVisibility(0);
          this.e.ps.setVisibility(8);
          if ((!mtg.k(mtg.this)) && (!TextUtils.isEmpty(aqux.pT("kandian")))) {
            this.e.pt.setVisibility(8);
          }
        }
      }
      while (!a(this.e)) {
        return;
      }
      a(this.e, mtg.k(mtg.this));
    }
    
    public void onVideoClick()
    {
      boolean bool = false;
      if (this.e.be.getVisibility() == 8) {
        this.e.e.setVisibility(8);
      }
      for (;;)
      {
        if (this.e.be.getVisibility() == 8) {
          bool = true;
        }
        dW(bool);
        return;
        if (!mtg.a(mtg.this)) {
          this.e.e.setVisibility(0);
        }
      }
    }
    
    public void onVisibilityChanged(boolean paramBoolean)
    {
      if ((this.e.aUv == 0) && (this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.busiType == 0)) {
        dW(true);
      }
      for (;;)
      {
        if (paramBoolean)
        {
          if (a(this.e)) {
            a(this.e, mtg.k(mtg.this));
          }
          this.e.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(0.0F);
        }
        return;
        dW(false);
        if (this.e.bg.getVisibility() == 0) {
          muj.H(this.e.bg, 8);
        }
      }
    }
    
    protected void oo(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.e.d.setEnabled(true);
        this.e.rD.setVisibility(0);
        this.e.rF.setVisibility(0);
        this.e.jP.setVisibility(8);
      }
      for (;;)
      {
        this.e.jdField_a_of_type_Mxy.oJ(true);
        this.e.jdField_a_of_type_Mxy.aTD();
        return;
        this.e.e.setEnabled(true);
      }
    }
    
    public void so(int paramInt)
    {
      if (paramInt == 1) {
        dW(true);
      }
      while (paramInt != 2) {
        return;
      }
      dW(false);
    }
    
    public void sp(int paramInt)
    {
      if (this.e.jR != null) {
        this.e.jR.setImageResource(paramInt);
      }
    }
  }
  
  public static class g
    extends mtg.e
  {
    VideoFeedsGestureLayout a;
    public VideoFeedsPlayManager.b a;
    public mrx a;
    public mxy a;
    public nca a;
    public ViewGroup be;
    public ViewGroup bf;
    public ViewGroup bg;
    ViewGroup bh;
    ViewGroup bi;
    ViewGroup bj;
    ViewGroup bk;
    SeekBar d;
    SeekBar e;
    public ImageView jO;
    ImageView jP;
    ImageView jQ;
    ImageView jR;
    View lN;
    TextView ps;
    TextView pt;
    TextView rD;
    TextView rE;
    TextView rF;
    TextView rG;
    TextView rH;
    ViewGroup videoLayout;
    public URLImageView x;
    
    public g(View paramView, int paramInt)
    {
      super(paramInt);
      this.e = ((SeekBar)paramView.findViewById(2131369264));
      this.bf = ((ViewGroup)paramView.findViewById(2131365065));
      paramView = this.bf;
      this.videoLayout = ((ViewGroup)paramView.findViewById(2131381724));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)paramView.findViewById(2131367963));
      this.x = ((URLImageView)paramView.findViewById(2131365489));
      this.jO = ((ImageView)paramView.findViewById(2131373379));
      this.be = ((ViewGroup)paramView.findViewById(2131381641));
      this.d = ((SeekBar)paramView.findViewById(2131377920));
      this.rD = ((TextView)paramView.findViewById(2131365556));
      this.rF = ((TextView)paramView.findViewById(2131380115));
      this.bg = ((ViewGroup)paramView.findViewById(2131373380));
      this.bj = ((ViewGroup)paramView.findViewById(2131363651));
      this.bk = ((ViewGroup)paramView.findViewById(2131367807));
      this.jQ = ((ImageView)paramView.findViewById(2131367808));
      this.ps = ((TextView)paramView.findViewById(2131372701));
      this.rG = ((TextView)paramView.findViewById(2131367063));
      this.pt = ((TextView)paramView.findViewById(2131370088));
      this.rE = ((TextView)paramView.findViewById(2131378317));
      this.bh = ((LinearLayout)paramView.findViewById(2131367806));
      this.bi = ((LinearLayout)paramView.findViewById(2131364690));
      this.rH = ((TextView)paramView.findViewById(2131367809));
      this.jP = ((ImageView)paramView.findViewById(2131381873));
      this.lN = paramView.findViewById(2131381665);
      this.jR = ((ImageView)paramView.findViewById(2131381810));
      this.jdField_a_of_type_Nca = new nca(paramView, null);
    }
  }
  
  public abstract class h
    extends mtg.f
  {
    private mtg.l c;
    
    public h(mtg.l paraml)
    {
      super(paraml);
      this.c = paraml;
    }
    
    public void aRJ()
    {
      if (mtg.a(mtg.this) == null)
      {
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        localScaleAnimation.setDuration(200L);
        localScaleAnimation.setRepeatCount(1);
        localScaleAnimation.setRepeatMode(2);
        localScaleAnimation.setInterpolator(new DecelerateInterpolator());
        mtg.a(mtg.this, localScaleAnimation);
      }
      mtg.a(mtg.this).setAnimationListener(new mtr(this));
      this.c.jW.startAnimation(mtg.a(mtg.this));
    }
    
    public void b(VideoInfo paramVideoInfo, boolean paramBoolean)
    {
      super.b(paramVideoInfo, paramBoolean);
      this.c.titleTextView.setVisibility(0);
      if (((this.c.aUv == 0) && (this.c.position == 0) && ((mtg.a(mtg.this) instanceof VideoFeedsPlayActivity)) && (paramBoolean)) || (paramVideoInfo.isAD))
      {
        this.c.titleTextView.setText("");
        this.c.rH.setText("");
      }
      for (;;)
      {
        this.c.titleTextView.getPaint().setFakeBoldText(true);
        this.c.rH.getPaint().setFakeBoldText(true);
        mtg.a(mtg.this, this.c, paramVideoInfo);
        op(true);
        if (this.c.bu != null) {
          this.c.bu.setVisibility(8);
        }
        return;
        this.c.titleTextView.setText(paramVideoInfo.title);
        this.c.rH.setText(paramVideoInfo.title);
      }
    }
    
    protected void b(mtg.l paraml, VideoInfo paramVideoInfo)
    {
      if (paraml.rP != null)
      {
        paraml.rP.setOnClickListener(mtg.this);
        paraml.rP.setTag(paraml);
      }
      paraml.br.setTag(paraml);
      paraml.br.setOnClickListener(mtg.this);
      paraml.br.setVisibility(0);
      paraml.jV.setTag(paraml);
      paraml.jV.setOnClickListener(mtg.this);
      paraml.jV.setOnLongClickListener(mtg.this);
      if (paraml.bs != null)
      {
        paraml.bs.setOnClickListener(mtg.this);
        paraml.bs.setOnLongClickListener(mtg.this);
        paraml.bs.setTag(paraml);
      }
      if (!paramVideoInfo.isAD) {
        paraml.jV.setVisibility(0);
      }
      for (;;)
      {
        paraml.jW.setTag(paraml);
        paraml.jW.setOnClickListener(mtg.this);
        paraml.jW.setVisibility(0);
        f(paramVideoInfo);
        return;
        paraml.jV.setVisibility(8);
      }
    }
    
    public void e(VideoInfo paramVideoInfo) {}
    
    public void f(VideoInfo paramVideoInfo)
    {
      p(paramVideoInfo);
      VideoFeedsAccessibilityHelper.E(this.c.rQ, paramVideoInfo.commentCount);
      this.c.jW.setImageDrawable(mtg.a(mtg.this, m(paramVideoInfo.adM)));
      muj.b(this.c.rR, paramVideoInfo.aHi, "赞");
      muj.b(this.c.rS, paramVideoInfo.aHb, "Biu");
    }
    
    public void k(int paramInt1, int paramInt2, boolean paramBoolean) {}
    
    int m(boolean paramBoolean)
    {
      if (paramBoolean) {
        return 2130843926;
      }
      return 2130843830;
    }
    
    public void nW(boolean paramBoolean)
    {
      if (this.c.bp != null)
      {
        if ((this.c.a.d.busiType == 0) || (!this.c.a.d.yR())) {
          this.c.bp.setVisibility(8);
        }
      }
      else {
        return;
      }
      if (paramBoolean)
      {
        this.c.bp.setVisibility(0);
        return;
      }
      this.c.bp.setVisibility(8);
    }
    
    public void nY(boolean paramBoolean)
    {
      super.nY(paramBoolean);
      if (paramBoolean)
      {
        this.c.titleTextView.setVisibility(8);
        op(false);
        nW(false);
        oq(false);
        return;
      }
      this.c.titleTextView.setVisibility(0);
      op(true);
      nW(true);
      oq(true);
    }
    
    public void op(boolean paramBoolean)
    {
      if (this.c.bt != null)
      {
        if (paramBoolean) {
          this.c.bt.setVisibility(0);
        }
      }
      else {
        return;
      }
      this.c.bt.setVisibility(8);
    }
    
    public void oq(boolean paramBoolean)
    {
      if (this.c.bq != null)
      {
        if (!this.c.a.d.yR()) {
          this.c.bq.setVisibility(8);
        }
      }
      else {
        return;
      }
      if (paramBoolean)
      {
        this.c.bq.setVisibility(0);
        return;
      }
      this.c.bq.setVisibility(8);
    }
    
    void p(VideoInfo paramVideoInfo)
    {
      if (paramVideoInfo.commentCount > 0)
      {
        this.c.rQ.setVisibility(0);
        muj.b(this.c.rQ, paramVideoInfo.commentCount, "0");
        this.c.jU.setImageResource(2130843924);
        return;
      }
      this.c.rQ.setVisibility(8);
      this.c.jU.setImageResource(2130843925);
    }
  }
  
  public static class i
    extends mtg.e
  {
    ProgressBar C = (ProgressBar)this.itemView.findViewById(2131370811);
    ViewGroup bl = (ViewGroup)this.itemView.findViewById(2131370805);
    TextView rI = (TextView)this.itemView.findViewById(2131370816);
    
    public i(View paramView, int paramInt)
    {
      super(paramInt);
    }
    
    public void a(mtg parammtg, LinearLayoutManager paramLinearLayoutManager, boolean paramBoolean) {}
  }
  
  public class j
    extends mtg.h
  {
    private mtg.k a;
    
    public j(mtg.k paramk)
    {
      super(paramk);
      this.a = paramk;
    }
    
    private void a(VideoInfo paramVideoInfo, TextView paramTextView)
    {
      if (paramTextView == null) {
        return;
      }
      if (paramVideoInfo.yV())
      {
        paramTextView.setVisibility(0);
        return;
      }
      if ((paramVideoInfo.busiType != 0) && (paramVideoInfo.busiType != 5) && (paramVideoInfo.playCount > 0))
      {
        paramTextView.setText(muj.bu(paramVideoInfo.playCount));
        paramTextView.setVisibility(0);
        return;
      }
      paramTextView.setVisibility(8);
    }
    
    private void a(VideoInfo paramVideoInfo, boolean paramBoolean)
    {
      if (this.a.jdField_a_of_type_Mrw == null) {
        return;
      }
      if (paramVideoInfo.yV()) {}
      for (boolean bool = paramVideoInfo.a.amw; (TextUtils.isEmpty(paramVideoInfo.hH)) || ("16888".equals(paramVideoInfo.hH)) || (paramVideoInfo.isAD) || (paramVideoInfo.d(mtg.a(mtg.this))); bool = paramVideoInfo.isFollowed)
      {
        this.a.jdField_a_of_type_Mrw.getView().setVisibility(8);
        return;
      }
      this.a.jdField_a_of_type_Mrw.a(paramVideoInfo, paramVideoInfo.isFollowed);
      if ((paramBoolean) && (this.a == mtg.a(mtg.this)) && (mtg.a(mtg.this) != null) && (bool) && (this.a.jdField_a_of_type_Mrw.getView().getVisibility() == 0))
      {
        mtg.a(mtg.this).sendEmptyMessageDelayed(7, this.a.jdField_a_of_type_Mrw.cS());
        return;
      }
      if (bool)
      {
        this.a.jdField_a_of_type_Mrw.getView().setVisibility(8);
        return;
      }
      this.a.jdField_a_of_type_Mrw.getView().setVisibility(0);
    }
    
    private void on(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.bj.getLayoutParams();
        localMarginLayoutParams.bottomMargin = wja.dp2px(0.0F, mtg.a(mtg.this).getResources());
        this.a.bj.setLayoutParams(localMarginLayoutParams);
        return;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.bj.getLayoutParams();
      localMarginLayoutParams.bottomMargin = (wja.dp2px(15.0F, mtg.a(mtg.this).getResources()) - 20);
      this.a.bj.setLayoutParams(localMarginLayoutParams);
    }
    
    private void q(VideoInfo paramVideoInfo)
    {
      if ((paramVideoInfo.a != null) && (paramVideoInfo.a.aTm == 1))
      {
        if (this.a.bo == null)
        {
          ((ViewStub)this.a.bt.findViewById(2131381696)).inflate();
          this.a.bo = ((ViewGroup)this.a.bt.findViewById(2131381681));
          this.a.rO = ((TextView)this.a.bo.findViewById(2131381690));
          this.a.rN = ((TextView)this.a.bo.findViewById(2131381691));
          this.a.z = ((URLImageView)this.a.bo.findViewById(2131381676));
        }
        this.a.bo.setOnClickListener(mtg.this);
        this.a.bo.setTag(this.a);
        this.a.bo.setVisibility(0);
        this.a.rO.setText(paramVideoInfo.a.columnName);
        this.a.rN.setText(paramVideoInfo.a.aiR);
        if (!TextUtils.isEmpty(paramVideoInfo.a.aiO))
        {
          paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.a.aiO);
          this.a.z.setImageDrawable(paramVideoInfo);
        }
      }
      while (this.a.bo == null)
      {
        return;
        this.a.z.setImageDrawable(null);
        return;
      }
      this.a.bo.setVisibility(8);
    }
    
    private void s(VideoInfo paramVideoInfo)
    {
      if (!TextUtils.isEmpty(paramVideoInfo.vIconUrl))
      {
        this.a.O.setVisibility(0);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestHeight = this.a.O.getHeight();
        localURLDrawableOptions.mRequestWidth = this.a.O.getWidth();
        paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.vIconUrl, localURLDrawableOptions);
        this.a.O.setImageDrawable(paramVideoInfo);
        return;
      }
      this.a.O.setVisibility(8);
    }
    
    private void t(VideoInfo paramVideoInfo)
    {
      this.a.ak.setVisibility(8);
      this.a.Q.setVisibility(0);
      this.a.lQ.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = mtg.a(mtg.this);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = mtg.a(mtg.this);
      try
      {
        localObject = URLDrawable.getDrawable(new URL(paramVideoInfo.a.aiO), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setTag(aqbn.d(aqcx.dip2px(mtg.a(mtg.this), 40.0F), aqcx.dip2px(mtg.a(mtg.this), 40.0F), aqcx.dip2px(mtg.a(mtg.this), 4.0F)));
        ((URLDrawable)localObject).setDecodeHandler(aqbn.a);
        this.a.Q.setImageDrawable((Drawable)localObject);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.a.jW());
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoItemContentUI() ERROR e = " + localMalformedURLException.getMessage());
          }
        }
      }
    }
    
    private void u(VideoInfo paramVideoInfo)
    {
      if (paramVideoInfo.yV())
      {
        t(paramVideoInfo);
        return;
      }
      this.a.c.setImagePlaceHolder(mtg.a(mtg.this));
      if (!paramVideoInfo.adB)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.accountName))
        {
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.accountName);
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
          VideoFeedsAccessibilityHelper.g(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.accountName);
          VideoFeedsAccessibilityHelper.h(this.a.c, paramVideoInfo.accountName);
        }
        if (!TextUtils.isEmpty(paramVideoInfo.WC)) {
          this.a.c.setImageSrc(paramVideoInfo.WC);
        }
      }
      for (;;)
      {
        if (mtg.m(mtg.this)) {
          this.a.ak.setForeground(null);
        }
        this.a.ak.setVisibility(0);
        this.a.Q.setVisibility(8);
        this.a.lQ.setVisibility(8);
        return;
        if (!TextUtils.isEmpty(paramVideoInfo.hH))
        {
          this.a.c.setHeadImgByUin(Long.valueOf(paramVideoInfo.hH).longValue(), false);
          continue;
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(paramVideoInfo.hH);
          this.a.c.setHeadImgByUin(paramVideoInfo.hH);
        }
      }
    }
    
    public void b(VideoInfo paramVideoInfo, boolean paramBoolean)
    {
      super.b(paramVideoInfo, paramBoolean);
      this.a.titleTextView.getPaint().setFakeBoldText(false);
      if (mtg.a(mtg.this) != null) {
        mtg.a(mtg.this).a(paramVideoInfo, this.a, false);
      }
      if (paramVideoInfo.jQ != null) {
        if ((this.a.bm != null) && (this.a.bm.getVisibility() != 8))
        {
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.post(new VideoFeedsAdapter.ShortVideoItemDelegate.1(this, paramVideoInfo));
          this.a.be.setBackgroundDrawable(null);
          if (!paramVideoInfo.k(mtg.a(mtg.this))) {
            break label397;
          }
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(0);
          if (this.a.lO != null) {
            this.a.lO.setVisibility(0);
          }
          label155:
          on(false);
          if ((mtg.a(mtg.this).El()) && (mtg.l(mtg.this)))
          {
            mtg.h(mtg.this, false);
            nX(true);
          }
          if ((this.a.aUv != 0) || (paramVideoInfo.busiType != 0)) {
            break label434;
          }
          if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
            this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = new VideoFeedsAioGuideView(mtg.a(mtg.this), mtg.a(mtg.this), mtg.a(mtg.this));
          }
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a(this.a);
          label273:
          if (!paramVideoInfo.k(mtg.a(mtg.this))) {
            break label465;
          }
          this.a.w.setImageDrawable(null);
        }
      }
      for (;;)
      {
        a(paramVideoInfo, this.a.pw);
        q(paramVideoInfo);
        r(paramVideoInfo);
        return;
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setHorizontalMargin(0);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(0);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setArticleInfo(mtg.a(mtg.this), mtg.this, paramVideoInfo, mtg.c(mtg.this), mtg.e(mtg.this));
        break;
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(8);
        break;
        label397:
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(8);
        if (this.a.lO == null) {
          break label155;
        }
        this.a.lO.setVisibility(8);
        break label155;
        label434:
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
          break label273;
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.aSe();
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = null;
        break label273;
        label465:
        if (paramVideoInfo.d() != null)
        {
          Object localObject = URLDrawable.URLDrawableOptions.obtain();
          ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
          localObject = URLDrawable.getDrawable(paramVideoInfo.d(), (URLDrawable.URLDrawableOptions)localObject);
          ((URLDrawable)localObject).setDecodeHandler(aqbn.w);
          ((URLDrawable)localObject).setAlpha(35);
          this.a.w.setImageDrawable((Drawable)localObject);
        }
      }
    }
    
    protected void dW(boolean paramBoolean)
    {
      super.dW(paramBoolean);
      if (paramBoolean)
      {
        if (this.a.bt.getVisibility() == 0)
        {
          muj.a(this.a.bt, 8, 200);
          this.a.bt.animate().translationY(20.0F).setDuration(200L).start();
          this.a.bj.animate().translationY(-20.0F).setDuration(200L).start();
        }
        if ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) && (!mtg.a(mtg.this))) {
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.aSc();
        }
      }
      do
      {
        return;
        if ((!mtg.a(mtg.this)) && (this.a.bt.getVisibility() == 8))
        {
          muj.a(this.a.bt, 0, 200);
          this.a.bt.animate().translationY(0.0F).setDuration(200L).start();
          this.a.bj.animate().translationY(0.0F).setDuration(200L).start();
        }
      } while (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.aSd();
    }
    
    public void e(VideoInfo paramVideoInfo)
    {
      nW(true);
      if (this.a.bp.getVisibility() == 0)
      {
        u(paramVideoInfo);
        s(paramVideoInfo);
        a(paramVideoInfo, false);
        this.a.bp.setTag(this.a);
        this.a.bp.setOnClickListener(mtg.this);
        this.a.jdField_a_of_type_Mrw.getView().setTag(this.a);
        this.a.jdField_a_of_type_Mrw.getView().setOnClickListener(mtg.this);
      }
      oq(true);
      if (this.a.bq.getVisibility() == 0) {
        b(this.a, paramVideoInfo);
      }
      if (paramVideoInfo.k(mtg.a(mtg.this))) {
        this.a.bk.setVisibility(8);
      }
      for (;;)
      {
        if ((mtg.a(mtg.this) == this.a) && (mtg.a(mtg.this)))
        {
          nW(false);
          oq(false);
        }
        if (paramVideoInfo.yR()) {
          this.a.jW.setImageDrawable(mtg.a(mtg.this, m(paramVideoInfo.adM)));
        }
        VideoFeedsAccessibilityHelper.a(this.a, mtg.this);
        mtg.a(mtg.this, this.a.P, paramVideoInfo);
        mtg.a(mtg.this, this.a.P, paramVideoInfo, Boolean.valueOf(mtg.a(mtg.this)));
        return;
        this.a.bk.setVisibility(0);
      }
    }
    
    public void f(VideoInfo paramVideoInfo)
    {
      super.f(paramVideoInfo);
      u(paramVideoInfo);
      s(paramVideoInfo);
      this.a.titleTextView.setText(paramVideoInfo.title);
      this.a.rH.setText(paramVideoInfo.title);
      mtg.a(mtg.this, this.a, paramVideoInfo);
      a(paramVideoInfo, true);
      if ((paramVideoInfo.jQ != null) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.getVisibility() == 8))
      {
        if ((this.a.bm == null) || (this.a.bm.getVisibility() == 8)) {
          break label194;
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.post(new VideoFeedsAdapter.ShortVideoItemDelegate.2(this, paramVideoInfo));
      }
      for (;;)
      {
        mtg.a(mtg.this, paramVideoInfo);
        a(paramVideoInfo, this.a.pw);
        mtg.a(mtg.this, this.a.P, paramVideoInfo);
        mtg.a(mtg.this, this.a.P, paramVideoInfo, Boolean.valueOf(mtg.a(mtg.this)));
        q(paramVideoInfo);
        return;
        label194:
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setHorizontalMargin(0);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(0);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setArticleInfo(mtg.a(mtg.this), mtg.this, paramVideoInfo, mtg.c(mtg.this), mtg.e(mtg.this));
      }
    }
    
    public void k(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (mtg.a(mtg.this) != null) {
        mtg.a(mtg.this).y(paramInt1, paramInt2);
      }
      if (paramBoolean) {
        aRJ();
      }
    }
    
    int m(boolean paramBoolean)
    {
      if (this.a.aol)
      {
        if (paramBoolean) {
          return 2130843954;
        }
        return 2130843956;
      }
      return super.m(paramBoolean);
    }
    
    public void nX(boolean paramBoolean)
    {
      this.a.x.clearAnimation();
      if (paramBoolean)
      {
        if (!this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.k(mtg.a(mtg.this)))
        {
          this.a.bf.setPadding(0, 0, 0, muj.m(mtg.a(mtg.this)));
          on(true);
        }
        if (this.a.be.getVisibility() == 0) {
          this.a.be.setVisibility(8);
        }
        this.a.bk.setVisibility(8);
        return;
      }
      if (!this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.k(mtg.a(mtg.this)))
      {
        this.a.bf.setPadding(0, 0, 0, 0);
        on(false);
        this.a.bk.setVisibility(0);
        return;
      }
      this.a.bk.setVisibility(8);
    }
    
    public void nY(boolean paramBoolean)
    {
      super.nY(paramBoolean);
      if (paramBoolean)
      {
        this.a.bf.setPadding(0, 0, 0, 0);
        this.a.be.setBackgroundDrawable(mtg.b(mtg.this));
        on(true);
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) {
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.aSd();
        }
      }
      label216:
      for (;;)
      {
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) {
          mtg.a(mtg.this, this.a.P, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d, Boolean.valueOf(paramBoolean));
        }
        return;
        this.a.be.setBackgroundDrawable(null);
        if (!mtg.a(mtg.this).El()) {
          on(false);
        }
        for (;;)
        {
          if ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) || (this.a.aUv != 0) || (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b == null) || (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.busiType != 0)) {
            break label216;
          }
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.aSc();
          break;
          this.a.bf.setPadding(0, 0, 0, muj.m(mtg.a(mtg.this)));
        }
      }
    }
    
    public void onVideoClick()
    {
      if (this.a.be.getVisibility() == 8) {}
      for (boolean bool = true;; bool = false)
      {
        dW(bool);
        return;
      }
    }
    
    void p(VideoInfo paramVideoInfo)
    {
      if (this.a.aol)
      {
        muj.b(this.a.rQ, paramVideoInfo.commentCount, "评论");
        this.a.jU.setImageResource(2130843953);
        return;
      }
      super.p(paramVideoInfo);
    }
    
    public void r(VideoInfo paramVideoInfo)
    {
      if ((paramVideoInfo.adJ) && (!TextUtils.isEmpty(paramVideoInfo.WG)))
      {
        this.a.e.setVisibility(0);
        this.a.e.setText(paramVideoInfo.WG);
        this.a.e.setTag(this.a);
        this.a.e.setOnClickListener(mtg.this);
        return;
      }
      this.a.e.setVisibility(8);
    }
  }
  
  public static class k
    extends mtg.l
  {
    KandianUrlImageView O;
    KandianUrlImageView P;
    KandianUrlImageView Q;
    VideoFeedsAioGuideView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView;
    VideoFeedsGradientMaskView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView;
    public VideoFeedsTopicViewGroup a;
    CircleCountdownView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView;
    FrameLayout ak;
    boolean aol;
    public ViewGroup bm;
    ViewGroup bn;
    ViewGroup bo;
    RIJRedPacketPopupView e;
    ImageView jK;
    ImageView jS;
    ImageView jT;
    View lB;
    View lC;
    View lO;
    public View lP;
    View lQ;
    TextView pw;
    TextView rJ;
    TextView rK;
    TextView rL;
    TextView rM;
    TextView rN;
    TextView rO;
    TextView rq;
    URLImageView w;
    URLImageView y;
    URLImageView z;
    
    public k(View paramView)
    {
      super(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView = ((VideoFeedsGradientMaskView)paramView.findViewById(2131369268));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup = ((VideoFeedsTopicViewGroup)paramView.findViewById(2131381765));
      this.O = ((KandianUrlImageView)paramView.findViewById(2131368441));
      this.lP = VideoFeedsAccessibilityHelper.e(paramView);
      this.w = ((URLImageView)paramView.findViewById(2131363240));
      this.pw = ((TextView)paramView.findViewById(2131381759));
      this.P = ((KandianUrlImageView)paramView.findViewById(2131370907));
      this.ak = ((FrameLayout)paramView.findViewById(2131368437));
      this.Q = ((KandianUrlImageView)paramView.findViewById(2131368454));
      this.lQ = paramView.findViewById(2131368455);
      this.lO = paramView.findViewById(2131381688);
      this.e = ((RIJRedPacketPopupView)paramView.findViewById(2131381685));
      this.e.nP(false);
      this.e.nO(false);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView != null)
      {
        int i = (int)(Aladdin.getConfig(263).getFloatFromString("bottom_mask_alpha", 0.7F) * 255.0F);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setMaskAlpha(i);
      }
      if (this.lO != null)
      {
        float f = Aladdin.getConfig(263).getFloatFromString("tiktok_bar_mask_alpha", 0.4F);
        this.lO.setAlpha(f);
      }
      if (this.bq != null) {
        muj.s(this.bq);
      }
    }
    
    public static k a(View paramView)
    {
      boolean bool;
      ViewStub localViewStub1;
      ViewStub localViewStub2;
      if (Aladdin.getConfig(260).getIntegerFromString("interact_button_style", 0) == 1)
      {
        bool = true;
        if (!bool) {
          break label86;
        }
        localViewStub1 = (ViewStub)paramView.findViewById(2131381703);
        localViewStub2 = (ViewStub)paramView.findViewById(2131381695);
        ((ViewStub)paramView.findViewById(2131381701)).inflate();
        localViewStub1.inflate();
        localViewStub2.inflate();
      }
      for (;;)
      {
        paramView = new k(paramView);
        paramView.aol = bool;
        return paramView;
        bool = false;
        break;
        label86:
        localViewStub1 = (ViewStub)paramView.findViewById(2131381699);
        localViewStub2 = (ViewStub)paramView.findViewById(2131381697);
        ((ViewStub)paramView.findViewById(2131381700)).inflate();
        localViewStub1.inflate();
        localViewStub2.inflate();
      }
    }
  }
  
  public static class l
    extends mtg.g
    implements ReadInJoyNickNameTextView.a
  {
    URLImageView A;
    public URLImageView B;
    URLImageView C;
    public URLImageView D;
    public URLImageView E;
    public URLImageView F;
    KandianUrlImageView R;
    public ReadInjoyHeaderAdDownloadView a;
    VideoFeedsUGView a;
    public ReadInJoyNickNameTextView a;
    public mrw a;
    public ReadInjoyHeaderAdDownloadView b;
    VideoFeedsUGView b;
    public ViewGroup bA;
    public Button bT;
    public ViewGroup bp;
    ViewGroup bq;
    ViewGroup br;
    ViewGroup bs;
    ViewGroup bt;
    ViewGroup bu;
    public ViewGroup bv;
    ViewGroup bw;
    ViewGroup bx;
    public ViewGroup by;
    public ViewGroup bz;
    public ReadInJoyHeadImageView c;
    ImageView jU;
    ImageView jV;
    ImageView jW;
    public ImageView jX;
    View lR;
    public View lS;
    public View lT;
    public View lU;
    public View lV;
    ViewStub p;
    ViewStub q;
    TextView rP;
    TextView rQ;
    TextView rR;
    TextView rS;
    TextView rT;
    public TextView rU;
    public TextView rV;
    public TextView rW;
    public TextView rX;
    TextView rY;
    TextView rZ;
    View rootView;
    TextView sa;
    TextView sb;
    public TextView sc;
    public TextView sd;
    public TextView se;
    public TextView sf;
    public TextView sg;
    public TextView sh;
    public TextView titleTextView;
    
    public l(View paramView, int paramInt)
    {
      super(paramInt);
      this.rootView = paramView;
      this.titleTextView = ((TextView)paramView.findViewById(2131379863));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView = ((VideoFeedsUGView)paramView.findViewById(2131381183));
      this.b = ((VideoFeedsUGView)paramView.findViewById(2131381181));
      this.bp = ((ViewGroup)paramView.findViewById(2131368467));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131368439));
      VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, this);
      this.c = ((ReadInJoyHeadImageView)paramView.findViewById(2131368436));
      this.jdField_a_of_type_Mrw = ((mrw)paramView.findViewById(2131368430));
      this.bq = ((ViewGroup)paramView.findViewById(2131367481));
      this.jV = ((ImageView)paramView.findViewById(2131367467));
      if (paramInt == 2) {
        this.bs = ((ViewGroup)paramView.findViewById(2131372628));
      }
      this.jW = ((ImageView)paramView.findViewById(2131367474));
      this.br = ((ViewGroup)paramView.findViewById(2131367491));
      this.jU = ((ImageView)paramView.findViewById(2131367468));
      this.rQ = ((TextView)paramView.findViewById(2131367470));
      this.rP = ((TextView)paramView.findViewById(2131367490));
      this.rR = ((TextView)paramView.findViewById(2131367477));
      this.rS = ((TextView)paramView.findViewById(2131367465));
      this.bt = ((ViewGroup)paramView.findViewById(2131381667));
      this.p = ((ViewStub)paramView.findViewById(2131374341));
      this.q = ((ViewStub)paramView.findViewById(2131374337));
    }
    
    public void nU(String paramString)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
      {
        VideoFeedsAccessibilityHelper.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramString);
        VideoFeedsAccessibilityHelper.h(this.c, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtg
 * JD-Core Version:    0.7.0.1
 */