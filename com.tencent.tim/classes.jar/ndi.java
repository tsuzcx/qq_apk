import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.q;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.12;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.13;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.14;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.15;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.21;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.25;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.27;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.28;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.31;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.4;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView.b;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.IHotReloadChangedObserver;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.TextHook;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.ListView.d;
import cooperation.plugin.PluginBaseActivity;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public abstract class ndi
  extends sof
  implements View.OnClickListener, View.OnLongClickListener, ListView.d, myp.a, mza.b
{
  private static int aDk;
  private static int aDl;
  static final int aOi = Color.parseColor("#999999");
  static final int aOj = Color.parseColor("#262626");
  public static int aYb = 20;
  public static int aYc = 250;
  public static int aYd = 1000;
  private static lrj jdField_c_of_type_Lrj;
  public static float kq;
  public HashSet<String> L = new HashSet();
  protected Set<Long> U;
  public HashSet<String> V = new HashSet();
  private acln jdField_a_of_type_Acln = new ned(this);
  public ReadInJoyBaseListView.b a;
  public ReadInJoyXListView a;
  private ProteusParserWithHotReload.IHotReloadChangedObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver = new nee(this);
  public GdtHandler.Params a;
  private kmw jdField_a_of_type_Kmw;
  public lgf.c a;
  private mst jdField_a_of_type_Mst;
  public mye a;
  protected myp a;
  private mza.b jdField_a_of_type_Mza$b;
  private ndc jdField_a_of_type_Ndc;
  protected ndi.a a;
  protected ndi.b a;
  protected ndi.c a;
  protected ndi.d a;
  private ndi.e jdField_a_of_type_Ndi$e;
  njk jdField_a_of_type_Njk = new njk();
  private nrl jdField_a_of_type_Nrl;
  oaw jdField_a_of_type_Oaw = new nea(this);
  public int aQo = -1;
  private int aYe = -1;
  public boolean afO;
  protected Set<Long> ak;
  public boolean akw;
  protected boolean arA;
  private boolean arB;
  private boolean arC;
  protected boolean arq;
  protected boolean arr = true;
  protected boolean ars;
  protected boolean art;
  private boolean aru;
  private boolean arv = true;
  private boolean arw;
  private boolean arx;
  public boolean ary;
  public boolean arz;
  private SparseArray<lfz> au;
  private Rect ay = new Rect();
  private auua jdField_b_of_type_Auua;
  private jzh jdField_b_of_type_Jzh;
  protected msl b;
  private myq jdField_b_of_type_Myq;
  private autw jdField_c_of_type_Autw;
  public INetInfoHandler c;
  protected Drawable cC;
  private Drawable cJ;
  private Runnable cN = new ReadInJoyBaseAdapter.21(this);
  private AnimationSet d;
  public Map<Long, mgu> ek;
  private AnimationSet f;
  public List<BaseArticleInfo> gO = new ArrayList();
  public AbsListView.e j;
  private MqqHandler j;
  protected List<Object> jR = new ArrayList();
  private AbsListView.e k;
  public mye.b k;
  private AbsListView.e l = new ndv(this);
  public ArrayList<mgu> lB = new ArrayList();
  private ArrayList<ndc> lC = new ArrayList();
  public int mChannelID = -1;
  protected int mChannelType;
  public Activity mContext;
  protected LayoutInflater mInflater;
  public boolean mIsResume;
  int mScrollState = -1;
  private Handler mUiHandler;
  private VafContext mVafContext = new luh();
  protected VideoPreDownloadMgr mVideoPreDownloadMgr;
  private long qC;
  public long sr = -2147483648L;
  private int startIndex;
  private long xm = -1L;
  public long xn;
  
  static
  {
    aDk = 10;
    aDl = 10;
    kq = ViewConfiguration.getScrollFriction();
    if (Build.VERSION.SDK_INT < 21) {
      kq = 0.025F;
    }
    jdField_c_of_type_Lrj = new lrj();
  }
  
  public ndi(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<lfz> paramSparseArray)
  {
    this.jdField_j_of_type_MqqOsMqqHandler = new MqqHandler();
    this.jdField_j_of_type_ComTencentWidgetAbsListView$e = new ndt(this);
    this.jdField_k_of_type_ComTencentWidgetAbsListView$e = new ndu(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$b = new ndw(this);
    this.jdField_c_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ndx(this);
    this.mContext = paramActivity;
    this.mInflater = paramLayoutInflater;
    this.mChannelID = paramInt;
    this.mVafContext.setContext(paramActivity);
    this.mVafContext.setCurActivity(paramActivity);
    this.aQo = kxm.nQ();
    kvx.a(this.mVafContext, "default_feeds");
    jdField_c_of_type_Lrj.b(this.mVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)paramListView);
    this.ak = new HashSet();
    a(paramSparseArray);
    this.jdField_b_of_type_Myq = new myq(paramActivity);
    aVQ();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyXListView)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnDrawCompleteListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$b);
    }
    this.mUiHandler = new ndj(this, Looper.getMainLooper());
    aVJ();
    aVI();
    ((ReadInJoyXListView)paramListView).a(this);
  }
  
  private boolean Fp()
  {
    boolean bool2 = false;
    ArticleInfo localArticleInfo = c();
    boolean bool1 = bool2;
    if (this.jdField_k_of_type_Mye$b == null)
    {
      bool1 = bool2;
      if (localArticleInfo != null)
      {
        bool1 = bool2;
        if (c(0) != null)
        {
          bool1 = bool2;
          if (localArticleInfo.mArticleID == c(0).mArticleID) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean Fq()
  {
    return false;
  }
  
  @Deprecated
  public static boolean K(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    switch (paramArticleInfo.mFeedType)
    {
    case 10: 
    case 11: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean L(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    return paramArticleInfo.isPGCShortContent();
  }
  
  public static boolean M(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArticleInfo != null)
    {
      bool1 = bool2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramArticleInfo.mSocialFeedInfo.aSG == 9) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean N(ArticleInfo paramArticleInfo)
  {
    if ((!P(paramArticleInfo)) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean O(ArticleInfo paramArticleInfo)
  {
    return (P(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c != null);
  }
  
  public static boolean P(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    if (paramArticleInfo == null) {
      return false;
    }
    if ((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo != null)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean Q(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.aSG)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean R(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 10) {
      return false;
    }
    return true;
  }
  
  public static boolean S(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean T(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while ((paramArticleInfo.mFeedType != 18) && (paramArticleInfo.mFeedType != 19)) {
      return false;
    }
    return true;
  }
  
  public static boolean U(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean V(ArticleInfo paramArticleInfo)
  {
    return (U(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa == 1);
  }
  
  public static boolean W(ArticleInfo paramArticleInfo)
  {
    return (S(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa == 1);
  }
  
  public static boolean X(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while ((paramArticleInfo.mFeedType != 16) && (paramArticleInfo.mFeedType != 17)) {
      return false;
    }
    return true;
  }
  
  public static boolean Y(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null);
  }
  
  public static boolean Z(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.size() == 0);
  }
  
  public static int a(ListView paramListView, mye.b paramb)
  {
    if (paramb != null)
    {
      paramb = paramListView.getChildAt(paramb.position + paramListView.getHeaderViewsCount() - paramListView.getFirstVisiblePosition());
      if (paramb != null) {
        return paramb.getBottom() - wja.dp2px(175.0F, paramListView.getResources());
      }
    }
    return 0;
  }
  
  private Bundle a(mye.b paramb, BaseArticleInfo paramBaseArticleInfo)
  {
    Bundle localBundle1 = new Bundle();
    label111:
    boolean bool;
    label148:
    label170:
    label303:
    label436:
    int i;
    label410:
    Bundle localBundle2;
    if (paramb.aDs == 1)
    {
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramb.aDs != 6) {
        break label1267;
      }
      localBundle1.putString("VIDEO_H5_URL", ((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).share_url);
      localBundle1.putString("VIDEO_CREATE_TIME", kxl.c(((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aTe, true));
      localBundle1.putString("VIDEO_TIME", String.valueOf(paramb.videoDuration));
      if (paramBaseArticleInfo.mVideoJsonWidth == 0) {
        break label1298;
      }
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramBaseArticleInfo.mVideoJsonWidth));
      if (paramBaseArticleInfo.mVideoJsonHeight == 0) {
        break label1341;
      }
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramBaseArticleInfo.mVideoJsonHeight));
      localBundle1.putString("VIDEO_VID", paramb.videoVid);
      localBundle1.putString("VIDEO_COVER", paramb.videoCoverUrl);
      localBundle1.putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
      localBundle1.putInt("VIDEO_STRATEGY_ID", paramBaseArticleInfo.mStrategyId);
      localBundle1.putLong("VIDEO_ALGORITHM_ID", paramBaseArticleInfo.mAlgorithmID);
      localBundle1.putString("VIDEO_SECOND_INDEX_INNER_ID", paramb.akN);
      if ((this.jdField_a_of_type_Lgf$c == null) || (this.jdField_a_of_type_Lgf$c.a() == null) || (this.jdField_a_of_type_Mye == null) || (this.jdField_a_of_type_Lgf$c.a().articleID != paramb.articleID)) {
        break label1384;
      }
      localBundle1.putLong("VIDEO_PLAY_POSITION", this.jdField_a_of_type_Mye.cZ());
      if (paramb.aDs != 6) {
        break label1396;
      }
      localBundle1.putString("VIDEO_ARTICLE_ID", ((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aim);
      localBundle1.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.y.longValue());
      localBundle1.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.intValue());
      localBundle1.putString("VIDEO_TITLE", ((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).title);
      localBundle1.putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", awit.nJ(this.mChannelType));
      if (paramb.aDs != 1) {
        break label1423;
      }
      bool = true;
      localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
      localBundle1.putString("VIDEO_RECOMMEND_REASON", paramBaseArticleInfo.mRecommentdReason);
      localBundle1.putBoolean("isFromKandian", true);
      localBundle1.putLong("channelID", paramBaseArticleInfo.mChannelID);
      localBundle1.putLong("algorithmID", paramBaseArticleInfo.mAlgorithmID);
      localBundle1.putString("innderId", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putLong("strategyId", paramBaseArticleInfo.mStrategyId);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label1429;
      }
      i = 0;
      label528:
      localBundle1.putInt("interactionType", i);
      localBundle1.putString("VIDEO_THIRD_ICON", paramb.thirdIcon);
      localBundle1.putString("VIDEO_THIRD_NAME", paramb.thirdName);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramb.thirdAction);
      localBundle1.putString("VIDEO_THIRD_URL", paramb.ahw);
      localBundle1.putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramb.xc);
      localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramb.aDs);
      localBundle2 = new Bundle();
      localBundle2.putString("VINFO", paramb.videoVid);
      localBundle2.putString("TINFO", paramb.videoVid);
      localBundle2.putInt("PREVIEW_VIDEO_TIME", paramb.videoDuration);
      if (this.jdField_a_of_type_Mye != null) {
        break label1434;
      }
      i = 0;
      label663:
      localBundle2.putInt("PREVIEW_START_POSI", myh.T(i, paramb.videoDuration));
      localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramb.videoWidth);
      localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramb.videoHeight);
      localBundle2.putInt("FULL_VIDEO_TIME", paramb.videoDuration);
      localBundle2.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramb.aDs != 1) {
        break label1446;
      }
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      label759:
      if ((paramb.aDs != 6) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.size() <= 0)) {
        break label1473;
      }
      localBundle2.putString("compatible_text", ((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).title + ": " + ((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).share_url);
      localBundle2.putInt("req_type", 125);
      label894:
      localBundle2.putInt("TYPE", paramb.aDs);
      localBundle2.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle2.putInt("layout_item", 5);
      localBundle2.putBoolean("video_url_load", false);
      localBundle2.putString("image_url_remote", paramb.videoCoverUrl);
      if (paramBaseArticleInfo.aioShareUrl == null) {
        break label1487;
      }
      localBundle2.putString("detail_url", paramBaseArticleInfo.aioShareUrl);
    }
    for (;;)
    {
      localBundle2.putString("video_url", paramb.videoVid);
      localBundle2.putString("title", paramBaseArticleInfo.mTitle);
      localBundle2.putString("req_create_time", kxl.ap(paramBaseArticleInfo.mTime));
      localBundle2.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)anre.a(localBundle2)).getBytes());
      localBundle1.putString("VIDEO_SUBS_TEXT", paramBaseArticleInfo.mVideoArticleSubsText);
      localBundle1.putString("VIDEO_SUBS_COLOR", paramBaseArticleInfo.mVideoArticleSubsColor);
      localBundle1.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      localBundle1.putInt("VIDEO_PLAY_COUNT", paramBaseArticleInfo.mVideoPlayCount);
      return localBundle1;
      if (paramb.aDs == 6)
      {
        if (ak(paramBaseArticleInfo)) {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin);
        }
        for (;;)
        {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.nickName);
          if (aa((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle1.putString("VIDEO_URL", ((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).video_url);
          break;
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin);
        }
      }
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label1267:
      localBundle1.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle1.putString("VIDEO_CREATE_TIME", kxl.c(paramBaseArticleInfo.mTime, true));
      break label111;
      label1298:
      if (paramb.aDs != 6) {
        break label148;
      }
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aTc));
      break label148;
      label1341:
      if (paramb.aDs != 6) {
        break label170;
      }
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aTd));
      break label170;
      label1384:
      localBundle1.putLong("VIDEO_PLAY_POSITION", 0L);
      break label303;
      label1396:
      localBundle1.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      break label410;
      label1423:
      bool = false;
      break label436;
      label1429:
      i = 1;
      break label528;
      label1434:
      i = (int)this.jdField_a_of_type_Mye.cZ();
      break label663;
      label1446:
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break label759;
      label1473:
      localBundle2.putInt("req_type", 140);
      break label894;
      label1487:
      localBundle2.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl + "&sourcefrom=0");
    }
  }
  
  private lgf.c a(AbsListView paramAbsListView)
  {
    Object localObject;
    if ((!Fo()) || (this.jdField_a_of_type_Mst == null) || (paramAbsListView.getChildCount() <= 0))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    label27:
    if (i < paramAbsListView.getChildCount())
    {
      View localView = paramAbsListView.getChildAt(i);
      if ((localView.getTag() instanceof lgf.c))
      {
        localObject = (lgf.c)localView.getTag();
        if (!((lgf.c)localObject).z(localView)) {}
      }
    }
    for (paramAbsListView = (AbsListView)localObject;; paramAbsListView = null)
    {
      localObject = paramAbsListView;
      if (paramAbsListView != null) {
        break;
      }
      localObject = paramAbsListView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.readinjoy.video", 2, "checkPlayableArea(): no item can auto play...");
      return paramAbsListView;
      i += 1;
      break label27;
    }
  }
  
  private lis a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    c(paramInt2);
    ArticleInfo localArticleInfo = null;
    if (paramInt2 < getCount() - 1) {
      localArticleInfo = (ArticleInfo)c(paramInt2 + 1);
    }
    return new lis(this.mContext, paramArticleInfo, paramInt1, this.mChannelID, this.mChannelType, paramInt2, this.akw, getCount(), localArticleInfo, this);
  }
  
  public static mye.b a(BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramBaseArticleInfo, false);
  }
  
  public static mye.b a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    mye.b localb = new mye.b();
    localb.videoVid = paramBaseArticleInfo.getVideoVid();
    localb.articleID = paramBaseArticleInfo.mArticleID;
    localb.videoDuration = paramBaseArticleInfo.getVideoDuration();
    localb.videoWidth = paramBaseArticleInfo.getVideoWidth();
    localb.videoHeight = paramBaseArticleInfo.getVideoHeight();
    localb.vn = paramBaseArticleInfo.mXGFileSize;
    localb.title = paramBaseArticleInfo.mTitle;
    Object localObject;
    if (paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false) == null)
    {
      localObject = null;
      localb.videoCoverUrl = ((String)localObject);
      localb.puin = paramBaseArticleInfo.getSubscribeUin();
      localb.strategyId = paramBaseArticleInfo.mStrategyId;
      localb.algorithmID = paramBaseArticleInfo.mAlgorithmID;
      localObject = new mhu();
      ((mhu)localObject).w = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((mhu)localObject).rowkey = paramBaseArticleInfo.innerUniqueID;
      ((mhu)localObject).vid = paramBaseArticleInfo.getVideoVid();
      ((mhu)localObject).busiType = paramBaseArticleInfo.busiType;
      ((mhu)localObject).videoWidth = paramBaseArticleInfo.getVideoWidth();
      ((mhu)localObject).videoHeight = paramBaseArticleInfo.getVideoHeight();
      ((mhu)localObject).vI = paramBaseArticleInfo.getVideoDuration();
      ((mhu)localObject).aSt = 0;
      ((mhu)localObject).skipFramesTotalCount = 0;
      ((mhu)localObject).aSu = 0;
      ((mhu)localObject).amE = false;
      ((mhu)localObject).amF = false;
      ((mhu)localObject).amG = false;
      ((mhu)localObject).ahy = "";
      localb.c = ((mhu)localObject);
      localb.thirdIcon = paramBaseArticleInfo.thirdIcon;
      localb.thirdName = paramBaseArticleInfo.thirdName;
      localb.thirdAction = paramBaseArticleInfo.thirdAction;
      localb.aDs = paramBaseArticleInfo.busiType;
      localb.akK = paramBaseArticleInfo.getInnerUniqueID();
      localb.channelId = paramBaseArticleInfo.mChannelID;
      localb.ahw = paramBaseArticleInfo.mThirdVideoURL;
      localb.xc = paramBaseArticleInfo.mThirdVideoURLExpireTime;
      localb.d = paramBaseArticleInfo;
      if (!paramBoolean) {
        break label402;
      }
    }
    label402:
    for (int i = 3;; i = 0)
    {
      localb.IH = i;
      if (k((ArticleInfo)paramBaseArticleInfo) == 4) {
        localb.aqq = true;
      }
      if ((paramBaseArticleInfo.mChannelID == 56L) && (kxm.AY()))
      {
        i = aqcx.dip2px(BaseApplicationImpl.getApplication().getApplicationContext(), 8.0F);
        localb.topLeftRadius = i;
        localb.topRightRadius = i;
        localb.bottomLeftRadius = i;
        localb.bottomRightRadius = i;
      }
      return localb;
      localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false).getPath();
      break;
    }
  }
  
  public static JSONArray a(String paramString1, String paramString2)
  {
    paramString1 = e(paramString1);
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      paramString1 = null;
    }
    do
    {
      return paramString1;
      paramString2 = paramString1.optJSONArray(paramString2);
      if (paramString2 == null) {
        break;
      }
      paramString1 = paramString2;
    } while (paramString2.length() > 0);
    return null;
  }
  
  private void a(SparseArray<lfz> paramSparseArray)
  {
    this.au = paramSparseArray;
    int i = 0;
    while (i < this.au.size())
    {
      ((lfz)this.au.valueAt(i)).a(this);
      i += 1;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString, int paramInt, Bundle paramBundle)
  {
    if (paramArticleInfo == null) {
      return;
    }
    String str2 = "";
    long l2 = 0L;
    int i = 0;
    long l3 = paramArticleInfo.mFeedId;
    int m = paramInt + 1;
    long l1;
    String str1;
    if ((ak(paramArticleInfo)) || (S(paramArticleInfo)) || (T(paramArticleInfo)) || (U(paramArticleInfo)))
    {
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label376;
      }
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null) {
        break label376;
      }
      str2 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin);
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la == null) {
        break label376;
      }
      paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.size();
      l1 = 0L;
      str1 = str2;
    }
    for (;;)
    {
      paramString = kxm.a(paramInt, m, paramString, kxm.a(paramArticleInfo), paramArticleInfo.innerUniqueID, paramArticleInfo);
      str2 = kxm.a(paramInt, m, null, kxm.a(paramArticleInfo), paramArticleInfo.innerUniqueID, kxm.f(paramArticleInfo), paramArticleInfo);
      paramBundle.putString("to_uin", str1);
      paramBundle.putString("feeds_id", Long.toString(l3));
      paramBundle.putString("article_id", Long.toString(l1));
      paramBundle.putInt("position", m);
      paramBundle.putString("read_article_r5", paramString);
      paramBundle.putString("scroll_image_r5", str2);
      paramBundle.putLong("channel_id", paramArticleInfo.mChannelID);
      paramBundle.putString("strategy_id", "" + paramArticleInfo.mStrategyId);
      return;
      str2 = paramArticleInfo.mSubscribeID;
      l2 = paramArticleInfo.mArticleID;
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        l1 = l2;
        str1 = str2;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null)
        {
          l1 = l2;
          str1 = str2;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY != null)
          {
            paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY.size();
            l1 = l2;
            str1 = str2;
            continue;
          }
        }
      }
      label376:
      paramInt = i;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt, Map<String, Object> paramMap)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Object localObject = kxm.f(paramArticleInfo);
    if (paramArticleInfo.hasChannelInfo()) {
      int i = paramArticleInfo.mChannelInfoId;
    }
    if (TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {}
    try
    {
      localObject = kxm.a(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), paramInt, aqiw.isWifiConnected(null), (String)localObject, paramArticleInfo.innerUniqueID, kxm.h(paramArticleInfo), 0, kxm.nQ(), paramArticleInfo);
      if ((paramMap != null) && (paramMap.entrySet() != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while ((paramMap != null) && (paramMap.hasNext()))
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue().toString());
          continue;
          kbp.a(null, kxm.f(paramArticleInfo), paramString1, paramString2, 0, 0, ay(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), paramMap, false);
        }
      }
    }
    catch (Exception paramMap)
    {
      wja.a("ReadInJoyBaseAdapter", "reportClickEvent", new IllegalArgumentException(paramMap));
      paramMap = null;
    }
    for (;;)
    {
      odv.a.l(paramArticleInfo, paramInt);
      return;
      paramMap = ((JSONObject)localObject).toString();
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, TextView paramTextView1, View paramView1, TextView paramTextView2, KandianUrlImageView paramKandianUrlImageView, View paramView2)
  {
    int i = awit.Qh();
    boolean bool2 = awit.aMN();
    paramTextView1.setMaxLines(i);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTextView1.getLayoutParams();
    float f1;
    boolean bool1;
    if (bool2)
    {
      f1 = 5.0F;
      localLayoutParams.bottomMargin = wja.dp2px(f1, this.mContext.getResources());
      if (bool2) {
        break label188;
      }
      bool1 = true;
      label60:
      localLayoutParams.alignWithParent = bool1;
      paramTextView1.setLayoutParams(localLayoutParams);
      if (paramView1 != null) {
        if (!bool2) {
          break label194;
        }
      }
    }
    label188:
    label194:
    for (i = 0;; i = 8)
    {
      paramView1.setVisibility(i);
      if (!paramBaseArticleInfo.hasFamilyCommentIcon()) {
        break label213;
      }
      try
      {
        paramTextView1 = new URL(paramBaseArticleInfo.familyCommentInfo.agS);
        if (paramBaseArticleInfo.familyCommentInfo.BT > 0) {
          a(paramKandianUrlImageView, paramTextView1, paramBaseArticleInfo.familyCommentInfo.aOw, paramBaseArticleInfo.familyCommentInfo.BT);
        }
        paramKandianUrlImageView.setOnClickListener(new ndk(this, paramBaseArticleInfo.familyCommentInfo.agT, paramView2));
        paramKandianUrlImageView.setVisibility(0);
        paramTextView2.setVisibility(8);
        return;
      }
      catch (MalformedURLException paramBaseArticleInfo)
      {
        QLog.d("ReadInJoyBaseAdapter", 2, "innerConfigTwoItemVideoUI exception");
        return;
      }
      f1 = 8.0F;
      break;
      bool1 = false;
      break label60;
    }
    label213:
    QLog.d("ReadInJoyBaseAdapter", 2, "innerConfigTwoItemVideoUI setCommentCountText");
    paramKandianUrlImageView.setVisibility(8);
    paramTextView2.setVisibility(0);
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, ImageView paramImageView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    boolean bool;
    URL localURL;
    if ((paramBaseArticleInfo.isUseGif) && (aqiw.isWifiConnected(this.mContext)))
    {
      bool = true;
      paramBaseArticleInfo.isShowGif = bool;
      localURL = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
      if (!paramBaseArticleInfo.isShowGif) {
        break label94;
      }
      paramImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mLoadingDrawable = an();
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramBaseArticleInfo.gifCoverUrl, localURLDrawableOptions));
    }
    for (;;)
    {
      a(paramKandianUrlImageView, localURL, paramBoolean);
      return;
      bool = false;
      break;
      label94:
      paramImageView.setVisibility(8);
    }
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    a(paramKandianUrlImageView, paramURL, false);
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, int paramInt1, int paramInt2)
  {
    if ((paramKandianUrlImageView == null) || (paramInt2 <= 0)) {
      return;
    }
    double d1 = paramInt1 / paramInt2;
    ViewGroup.LayoutParams localLayoutParams = paramKandianUrlImageView.getLayoutParams();
    QLog.d("ReadInJoyBaseAdapter", 2, "configImage | whRate " + d1 + ", origin width " + localLayoutParams.width + " ,origin height " + localLayoutParams.height);
    if (localLayoutParams != null)
    {
      localLayoutParams.height = Utils.dp2px(18.0D);
      localLayoutParams.width = ((int)(localLayoutParams.height * d1));
      QLog.d("ReadInJoyBaseAdapter", 2, "configImage | whRate " + d1 + ", width " + localLayoutParams.width + " , height " + localLayoutParams.height);
      paramKandianUrlImageView.setLayoutParams(localLayoutParams);
    }
    a(paramKandianUrlImageView, paramURL, false);
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean)
  {
    kwz.a(paramKandianUrlImageView, paramURL, this.mContext, paramBoolean);
  }
  
  private void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = null;
    if (this.cC == null) {
      this.cC = aqhu.at();
    }
    if ((kxm.F(paramBaseArticleInfo)) || ((paramBaseArticleInfo.busiType == 1) && (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))))
    {
      paramReadInJoyHeadImageView.setHeadImgByUin(paramBaseArticleInfo.getSubscribeUin());
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramReadInJoyHeadImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramReadInJoyHeadImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = this.cC;
    localURLDrawableOptions.mFailedDrawable = this.cC;
    label197:
    label329:
    for (;;)
    {
      AdvertisementInfo localAdvertisementInfo;
      boolean bool;
      try
      {
        if (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
          break label265;
        }
        localAdvertisementInfo = (AdvertisementInfo)paramBaseArticleInfo;
        bool = AdvertisementInfo.isAppAdvertisementInfo(paramBaseArticleInfo);
        if (!bool) {
          break label235;
        }
      }
      catch (MalformedURLException paramReadInJoyHeadImageView) {}
      try
      {
        paramBaseArticleInfo = new JSONObject(localAdvertisementInfo.mAdExt).getString("applogo");
        bool = TextUtils.isEmpty(paramBaseArticleInfo);
        if (!bool) {
          break label197;
        }
        paramBaseArticleInfo = null;
      }
      catch (JSONException paramBaseArticleInfo)
      {
        paramBaseArticleInfo = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyBaseAdapter", 2, "cannot get avatar from app advertisement");
        paramBaseArticleInfo = localObject;
        continue;
      }
      if (paramBaseArticleInfo == null)
      {
        paramReadInJoyHeadImageView.setImageDrawable(this.cC);
        paramReadInJoyHeadImageView.setVisibility(0);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyBaseAdapter", 2, "configVideoItemUI() ERROR e = " + paramReadInJoyHeadImageView.getMessage());
        return;
        paramBaseArticleInfo = new URL(paramBaseArticleInfo);
        continue;
        label235:
        paramBaseArticleInfo = localObject;
        if (TextUtils.isEmpty(localAdvertisementInfo.mAdCorporateLogo)) {
          continue;
        }
        paramBaseArticleInfo = new URL(localAdvertisementInfo.mAdCorporateLogo);
        continue;
        if (TextUtils.isEmpty(paramBaseArticleInfo.thirdIcon))
        {
          paramBaseArticleInfo = new URL("https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
          break label329;
        }
        paramBaseArticleInfo = new URL(paramBaseArticleInfo.thirdIcon);
        break label329;
      }
      paramBaseArticleInfo = URLDrawable.getDrawable(paramBaseArticleInfo, localURLDrawableOptions);
      paramBaseArticleInfo.setDecodeHandler(aqbn.b);
      paramReadInJoyHeadImageView.setImageDrawable(paramBaseArticleInfo);
      paramReadInJoyHeadImageView.setVisibility(0);
      return;
    }
  }
  
  private void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (kxm.F(paramBaseArticleInfo))
    {
      paramReadInJoyNickNameTextView.setNickNameByUin(paramBaseArticleInfo.getSubscribeUin());
      return;
    }
    if (paramBoolean)
    {
      paramReadInJoyNickNameTextView.setText(knd.a(paramBaseArticleInfo));
      return;
    }
    paramReadInJoyNickNameTextView.setText(kwz.C(paramBaseArticleInfo.getSubscribeName(), 18));
  }
  
  private void a(RoundAngleFrameLayout paramRoundAngleFrameLayout)
  {
    if (kxm.AY())
    {
      paramRoundAngleFrameLayout.setRaduis(28);
      return;
    }
    paramRoundAngleFrameLayout.setRaduis(0);
  }
  
  private void a(lgf.f paramf)
  {
    if (paramf == null) {
      return;
    }
    paramf.ja.setOnClickListener(this);
    paramf.pP.setOnClickListener(this);
    paramf.pO.setOnClickListener(this);
    paramf.pO.setTag(paramf);
    paramf.pP.setTag(paramf);
    paramf.ja.setTag(paramf);
  }
  
  public static void a(lgf.f paramf, BaseArticleInfo paramBaseArticleInfo)
  {
    mye.b localb = a(paramBaseArticleInfo);
    localb.ma = paramf.h;
    localb.position = paramf.position;
    localb.d = paramBaseArticleInfo;
    paramf.jdField_a_of_type_Mye$b = localb;
  }
  
  private static void a(mgu parammgu)
  {
    int i = 0;
    if (kxm.s(parammgu.j)) {
      parammgu.amq = true;
    }
    while (parammgu.amq) {
      return;
    }
    parammgu.amq = true;
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = kxm.getLongAccountUin();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = parammgu.v.longValue();
    if (parammgu.j != null) {
      i = (int)parammgu.j.mChannelID;
    }
    localReportInfo.mChannelId = i;
    localReportInfo.mAlgorithmId = ((int)parammgu.mAlgorithmID);
    localReportInfo.mStrategyId = parammgu.mStrategyId;
    localReportInfo.mOperation = 7;
    localReportInfo.mServerContext = parammgu.mServerContext;
    localReportInfo.mReadTimeLength = -1;
    localReportInfo.mInnerId = parammgu.agO;
    if ((parammgu.j != null) && (parammgu.j.mVideoColumnInfo != null)) {
      localReportInfo.mColumnID = parammgu.j.mVideoColumnInfo.aHc;
    }
    if ((parammgu.j != null) && (parammgu.j.mSocialFeedInfo != null) && (!kxm.u(parammgu.j)))
    {
      ReportInfo.a locala = new ReportInfo.a();
      locala.vd = parammgu.j.mSocialFeedInfo.mFeedId;
      if (parammgu.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
        locala.vg = parammgu.j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
      }
      locala.aSx = parammgu.j.mSocialFeedInfo.mLikeCount;
      locala.aSy = parammgu.j.mSocialFeedInfo.mCommentCount;
      Object localObject = parammgu.j.mSocialFeedInfo.iS;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        locala.iR = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          SocializeFeedsInfo.e locale = (SocializeFeedsInfo.e)((Iterator)localObject).next();
          if (locale != null) {
            locala.iR.add(Long.valueOf(locale.uin));
          }
        }
      }
      localReportInfo.mFeedsReportData = locala;
    }
    if ((parammgu.j != null) && (kys.dv((int)parammgu.j.mChannelID)))
    {
      localReportInfo.mSearchTagName = parammgu.agP;
      kvs.a(localReportInfo);
      return;
    }
    localArrayList.add(localReportInfo);
    QLog.d("ReadInJoyBaseAdapter", 2, "report0x64eExposureInfo: article " + localReportInfo.mSourceArticleId + " exposed!");
    lbz.a().cb(localArrayList);
  }
  
  private boolean a(AbsListView paramAbsListView)
  {
    float f1 = paramAbsListView.getFlingVelocity();
    float f2 = (float)aqgz.hL();
    return (f1 > 0.0F) && (f1 > f2 * 1.0F);
  }
  
  private void aVI()
  {
    if ((getActivity() instanceof ReadInJoyChannelActivity))
    {
      this.art = getActivity().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
      this.arq = getActivity().getIntent().getBooleanExtra("is_need_show_animation_adapter", false);
    }
    this.f = ((AnimationSet)AnimationUtils.loadAnimation(this.mContext, 2130772128));
    if (!muj.Eq()) {
      this.f.setDuration(400L);
    }
    if (this.mChannelID == 56)
    {
      msv.a().oe(true);
      msv.a().setSceneType(0);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.mContext, this.jdField_c_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void aVJ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "cpu:" + aqgz.getCpuNumber() + " mem:" + aqgz.getSystemTotalMemory() + " fre:" + aqgz.getCpuFrequency());
    }
    int i = aqgz.getCpuNumber();
    long l1 = aqgz.getSystemTotalMemory();
    if ((i >= 4) && (l1 >= 1610612736.0D))
    {
      aDk = 6;
      return;
    }
    aDk = 4;
  }
  
  private void aVP()
  {
    int m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
    int n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
    {
      int i1 = m - n + i;
      if ((i1 >= getCount()) || (i1 < 0)) {}
      for (;;)
      {
        i += 1;
        break;
        ArticleInfo localArticleInfo = (ArticleInfo)getItem(i1);
        if (localArticleInfo != null) {
          a(localArticleInfo, new lis(this.mContext, localArticleInfo, getItemViewType(i1), this.mChannelID, this.mChannelType, i1, this.akw, getCount(), null, this), System.currentTimeMillis(), i1);
        }
      }
    }
  }
  
  private void aVQ()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c(this.jdField_j_of_type_ComTencentWidgetAbsListView$e);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c(this.jdField_k_of_type_ComTencentWidgetAbsListView$e);
  }
  
  private void aVT()
  {
    if (!PublicAccountImageCollectionPreloadManager.a().Hp()) {}
    for (;;)
    {
      return;
      PublicAccountImageCollectionPreloadManager.a().bdm();
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
      nh();
      while (i <= m)
      {
        Object localObject = getItem(i);
        if (localObject != null)
        {
          localObject = (BaseArticleInfo)localObject;
          if (localObject != null)
          {
            int n = dA(i);
            if ((n == 8) || (n == 7)) {
              PublicAccountImageCollectionPreloadManager.a().oZ(String.valueOf(((BaseArticleInfo)localObject).innerUniqueID));
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private void aVU()
  {
    if (!aqiw.isWifiConnected(this.mContext)) {}
    try
    {
      Object localObject = this.jdField_a_of_type_Mye.c();
      long l1 = ((mye.b)localObject).articleID;
      localObject = c(((mye.b)localObject).position);
      if ((localObject != null) && (l1 != ((BaseArticleInfo)localObject).mArticleID))
      {
        this.jdField_a_of_type_Mye.stop(12);
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.video", 2, "fixVideoPlayErrorState stopVideo videoVid:" + ((BaseArticleInfo)localObject).getVideoVid());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.readinjoy.video", 2, "fixVideoPlayErrorState stopVideo throwable:" + localThrowable.getMessage());
    }
  }
  
  private void aVW()
  {
    if (this.jdField_a_of_type_Mye != null) {
      this.jdField_a_of_type_Mye.aTM();
    }
  }
  
  public static boolean aa(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.size() == 0);
  }
  
  private boolean ab(int paramInt1, int paramInt2)
  {
    lfz locallfz = b(0);
    if ((locallfz instanceof lgf)) {
      return ((lgf)locallfz).ab(paramInt2, paramInt1);
    }
    return false;
  }
  
  public static boolean ag(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 36);
  }
  
  public static boolean ah(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof ArticleInfo)) {
      return false;
    }
    if ((paramBaseArticleInfo.mChannelID == 0L) && ((S((ArticleInfo)paramBaseArticleInfo)) || (O((ArticleInfo)paramBaseArticleInfo)) || (L((ArticleInfo)paramBaseArticleInfo)) || (ag(paramBaseArticleInfo)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean ai(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.aSP == 1);
  }
  
  public static boolean aj(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.aSP == 0) && (L((ArticleInfo)paramBaseArticleInfo));
  }
  
  public static boolean ak(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return false;
    }
    switch (paramBaseArticleInfo.mFeedType)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean al(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 1) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.longValue() == 11L);
  }
  
  public static boolean am(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 11) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld != null);
  }
  
  private Drawable an()
  {
    if (this.cJ == null) {
      this.cJ = new ColorDrawable(0);
    }
    return this.cJ;
  }
  
  public static boolean an(BaseArticleInfo paramBaseArticleInfo)
  {
    return ((paramBaseArticleInfo instanceof ArticleInfo)) && (aa((ArticleInfo)paramBaseArticleInfo));
  }
  
  public static boolean ao(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType != 30) && ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lc.isEmpty()));
  }
  
  public static boolean ap(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mSocialFeedInfo.mTopicRecommendFeedsInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld == null) || (paramBaseArticleInfo.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld.isEmpty());
  }
  
  public static String ay(long paramLong)
  {
    long l1 = (paramLong >>> 1) / 5L;
    return Long.toString(l1) + (paramLong - 10L * l1);
  }
  
  private void azO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "prefetch data");
    }
    if (this.jdField_a_of_type_Ndi$e != null) {
      this.jdField_a_of_type_Ndi$e.azP();
    }
  }
  
  public static int b(ArticleInfo paramArticleInfo, int paramInt)
  {
    int i = 16;
    if (paramArticleInfo == null) {
      label7:
      return 0;
    }
    if (luy.Y(paramArticleInfo)) {
      return luy.g(paramArticleInfo);
    }
    if (lrj.C(paramArticleInfo)) {
      return jdField_c_of_type_Lrj.f(paramArticleInfo);
    }
    if (paramArticleInfo.mFeedType == 20)
    {
      paramInt = 82;
      if (paramArticleInfo.mRecommendFollowInfos != null) {
        switch (paramArticleInfo.mRecommendFollowInfos.cardStyle)
        {
        default: 
          paramInt = 82;
        }
      }
      for (;;)
      {
        return paramInt;
        paramInt = 82;
        continue;
        paramInt = 87;
        continue;
        paramInt = 88;
      }
    }
    if (paramArticleInfo.mFeedType == 36) {
      if (paramArticleInfo.isPGCShortContent()) {
        paramInt = 139;
      }
    }
    for (;;)
    {
      return paramInt;
      if (kxm.J(paramArticleInfo))
      {
        paramInt = 138;
      }
      else
      {
        paramInt = 137;
        continue;
        if ((paramArticleInfo.mFeedType == 21) || (paramArticleInfo.mFeedType == 22))
        {
          paramInt = kxm.a(paramArticleInfo, false);
        }
        else if (paramArticleInfo.mFeedType == 28)
        {
          paramInt = 93;
        }
        else if (paramArticleInfo.mFeedType == 24)
        {
          paramInt = kxm.b(paramArticleInfo);
        }
        else if (paramArticleInfo.mFeedType == 34)
        {
          paramInt = 123;
        }
        else if ((paramArticleInfo.mGroupSubArticleList != null) && (paramArticleInfo.mFeedType != 29))
        {
          paramInt = 53;
        }
        else if (paramArticleInfo.mFeedType == 25)
        {
          paramInt = 89;
        }
        else if (paramArticleInfo.mFeedType == 15)
        {
          paramInt = 38;
        }
        else if ((paramArticleInfo.mFeedType == 3) || (paramArticleInfo.mFeedType == 13))
        {
          paramInt = 15;
        }
        else if (paramArticleInfo.mFeedType == 30)
        {
          paramInt = 107;
        }
        else
        {
          if ((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mChannelID == 56L)) {
            break label1127;
          }
          paramInt = kxr.d(paramArticleInfo);
          if ((paramInt == 21) || (paramInt == 22))
          {
            paramInt = kxm.a(paramArticleInfo, true);
          }
          else if (paramInt == 11)
          {
            paramInt = 33;
          }
          else if (kxm.n(paramArticleInfo))
          {
            switch (paramArticleInfo.mSocialFeedInfo.aSG)
            {
            default: 
              paramInt = 12;
              break;
            case 1: 
              paramInt = 10;
              break;
            case 2: 
              paramInt = 27;
              break;
            case 9: 
              paramInt = 35;
              break;
            }
          }
          else
          {
            if (!kxm.o(paramArticleInfo)) {
              break;
            }
            switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa)
            {
            default: 
              paramInt = 24;
              break;
            case 1: 
              paramInt = 24;
              break;
            case 2: 
            case 3: 
              paramInt = 25;
              break;
            case 4: 
            case 5: 
              paramInt = 26;
            }
          }
        }
      }
    }
    if (kxm.k(paramArticleInfo)) {
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY.size() <= 0)) {
        break label2658;
      }
    }
    label2658:
    for (paramInt = ComponentContentGridImage.Q(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY.size(), paramArticleInfo.mSocialFeedInfo.aSG);; paramInt = 0)
    {
      if (paramInt != 0) {
        switch (paramInt)
        {
        default: 
          paramInt = 0;
          break;
        case 1: 
          paramInt = 49;
          break;
        case 3: 
          paramInt = 62;
          break;
        case 9: 
          paramInt = 63;
          break;
        }
      }
      switch (paramArticleInfo.mSocialFeedInfo.aSG)
      {
      default: 
        paramInt = 12;
        break;
      case 9: 
        paramInt = 63;
        break;
      case 3: 
        paramInt = 62;
        break;
      case 8: 
        paramInt = 49;
        break;
        if (paramInt == 25)
        {
          paramInt = 92;
          break;
        }
        if ((paramInt == 27) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$q != null))
        {
          if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$q.coverUrl))
          {
            paramInt = 94;
            break;
          }
          paramInt = 95;
          break;
        }
        if ((paramInt == 32) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g != null))
        {
          paramInt = 26;
          break;
        }
        if (!S(paramArticleInfo))
        {
          if (paramArticleInfo.mSocialFeedInfo.aSG == 0)
          {
            paramInt = 12;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 112;
            break;
          }
          if (paramArticleInfo.mSocialFeedInfo.aSG == 1)
          {
            paramInt = 10;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 113;
            break;
          }
          if (paramArticleInfo.mSocialFeedInfo.aSG == 5)
          {
            paramInt = 11;
            break;
          }
          if (paramArticleInfo.mSocialFeedInfo.aSG == 2)
          {
            paramInt = 27;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 113;
            break;
          }
          if (paramArticleInfo.mSocialFeedInfo.aSG == 6)
          {
            paramInt = 28;
            break;
          }
          if (paramArticleInfo.mSocialFeedInfo.aSG == 9)
          {
            paramInt = 35;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 114;
            break;
          }
          paramInt = 12;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          paramInt = 112;
          break;
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa == 1)
        {
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lc.size() > 0)
          {
            paramInt = 108;
            break;
          }
          paramInt = 24;
          break;
        }
        if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa == 3) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa == 2))
        {
          if ((paramArticleInfo.mSocialFeedInfo.aSG == 9) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.size() > 1))
          {
            paramInt = 37;
            break;
          }
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$h != null)
          {
            paramInt = 81;
            break;
          }
          paramInt = 25;
          break;
        }
        paramInt = 26;
        break;
        label1127:
        if (((paramArticleInfo.mFeedType == 11) || (paramArticleInfo.mFeedType == 14)) && (paramArticleInfo.mTopicRecommendFeedsInfo != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.ld != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.ld.size() > 0))
        {
          if (paramArticleInfo.mTopicRecommendFeedsInfo.ld.size() > 1)
          {
            paramInt = 30;
            break;
          }
          paramInt = 29;
          break;
        }
        if (K(paramArticleInfo))
        {
          paramInt = i;
          if (paramArticleInfo.mSocialFeedInfo == null) {
            break;
          }
          paramInt = i;
          switch (paramArticleInfo.mSocialFeedInfo.aSG)
          {
          case 8: 
          default: 
            paramInt = i;
            break;
          case 0: 
            paramInt = 20;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 109;
            break;
          case 5: 
            paramInt = 17;
            break;
          case 2: 
            paramInt = 18;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 110;
            break;
          case 6: 
            paramInt = 19;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 133;
            break;
          case 9: 
            paramInt = 34;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 111;
            break;
          case 3: 
            paramInt = i;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 111;
            break;
          case 1: 
            paramInt = i;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 132;
            break;
          case 19191924: 
            paramInt = i;
            if (!paramArticleInfo.isPGCShortContent()) {
              break;
            }
            paramInt = 134;
            break;
          }
        }
        if ((paramArticleInfo.mFeedType == 32) && (paramArticleInfo.mSocialFeedInfo != null))
        {
          paramInt = 120;
          break;
        }
        if ((ak(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo != null))
        {
          paramInt = i(paramArticleInfo);
          break;
        }
        if ((kxm.i(paramArticleInfo)) || (kxm.j(paramArticleInfo)))
        {
          paramInt = 40;
          if (paramArticleInfo.mSocialFeedInfo == null) {
            break;
          }
        }
        switch (paramArticleInfo.mSocialFeedInfo.aSG)
        {
        default: 
          paramInt = 40;
          break;
        case 2: 
          paramInt = 40;
          break;
        case 1: 
          paramInt = 41;
          break;
        case 9: 
          paramInt = 42;
          break;
          if ((kxm.l(paramArticleInfo)) || (kxm.m(paramArticleInfo)))
          {
            paramInt = j(paramArticleInfo);
            break;
          }
          if (R(paramArticleInfo))
          {
            paramInt = 31;
            if (paramArticleInfo.mSocialFeedInfo == null) {
              break;
            }
            switch (paramArticleInfo.mSocialFeedInfo.aSG)
            {
            case 3: 
            case 4: 
            case 7: 
            case 8: 
            default: 
              paramInt = 86;
              if (!paramArticleInfo.isPGCShortContent()) {
                break;
              }
              paramInt = 109;
              break;
            case 2: 
              paramInt = 31;
              if (!paramArticleInfo.isPGCShortContent()) {
                break;
              }
              paramInt = 110;
              break;
            case 6: 
              paramInt = 32;
              break;
            case 1: 
              paramInt = 83;
              if (!paramArticleInfo.isPGCShortContent()) {
                break;
              }
              paramInt = 111;
              break;
            case 5: 
              paramInt = 84;
              break;
            case 9: 
              paramInt = 85;
              if (!paramArticleInfo.isPGCShortContent()) {
                break;
              }
              paramInt = 111;
              break;
            case 0: 
              paramInt = 86;
              if (!paramArticleInfo.isPGCShortContent()) {
                break;
              }
              paramInt = 109;
              break;
            }
          }
          if (paramArticleInfo.mFeedType == 23)
          {
            paramInt = i;
            if (paramArticleInfo.mSocialFeedInfo == null) {
              break;
            }
            switch (paramArticleInfo.mSocialFeedInfo.aSG)
            {
            default: 
              paramInt = i;
              break;
            case 3: 
              paramInt = 64;
              break;
            case 9: 
              paramInt = 65;
              break;
            case 8: 
              paramInt = 48;
              break;
            }
          }
          if ((paramArticleInfo.mChannelID == 0L) && (paramArticleInfo.mSimpleVideoColumnInfo != null) && (kxm.j(paramArticleInfo)))
          {
            paramInt = 128;
            break;
          }
          if ((paramArticleInfo.mChannelID == 0L) && (paramArticleInfo.mVideoColumnInfo != null) && (kxm.j(paramArticleInfo)))
          {
            paramInt = 118;
            break;
          }
          if (paramArticleInfo.multiVideoColumnInfo != null)
          {
            if (paramArticleInfo.multiVideoColumnInfo.amw)
            {
              paramInt = 125;
              break;
            }
            paramInt = 124;
            break;
          }
          if (paramArticleInfo.mKdLiveInfo != null)
          {
            if (paramArticleInfo.mKdLiveInfo.style == 4)
            {
              paramInt = 130;
              break;
            }
            paramInt = 129;
            break;
          }
          if (paramArticleInfo.isWeishiGridTwoItemFeed())
          {
            paramInt = 70;
            break;
          }
          if (paramArticleInfo.isTwoItemVideoFeed())
          {
            if ((paramArticleInfo.mFeedType == 33) && (paramArticleInfo.mChannelID != 56L) && (paramArticleInfo.mChannelID != 70L))
            {
              paramInt = 121;
              break;
            }
            paramInt = 46;
            break;
          }
          if (paramArticleInfo.isWormhole()) {
            return 136;
          }
          if ((kxm.j(paramArticleInfo)) && (paramArticleInfo.mPictures != null) && (paramArticleInfo.mPictures.length >= 3) && (paramArticleInfo.mChannelID == 0L))
          {
            paramInt = 14;
            break;
          }
          if (kxm.j(paramArticleInfo))
          {
            if (paramArticleInfo.mVideoType == 0)
            {
              if (kxm.AI())
              {
                if ((paramArticleInfo.mChannelID == 56L) || (paramInt == 3))
                {
                  paramInt = 4;
                  break;
                }
                if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
                {
                  if (((AdvertisementInfo)paramArticleInfo).isIMaxAndNewStyle)
                  {
                    paramInt = 115;
                    break;
                  }
                  paramInt = 66;
                  break;
                }
                if (muj.pQ() == 0)
                {
                  paramInt = 126;
                  break;
                }
                paramInt = 6;
                break;
              }
              if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
              {
                if (((AdvertisementInfo)paramArticleInfo).isIMaxAndNewStyle)
                {
                  paramInt = 115;
                  break;
                }
                paramInt = 66;
                break;
              }
              if (muj.pQ() == 0)
              {
                paramInt = 126;
                break;
              }
              paramInt = 6;
              break;
            }
            if (paramArticleInfo.mChannelID == 56L)
            {
              paramInt = 4;
              break;
            }
            paramInt = 5;
            break;
          }
          if (kxm.k(paramArticleInfo))
          {
            if (paramArticleInfo.mGalleryFeedsInfo.enum_article_style.get() == 3)
            {
              paramInt = 103;
              break;
            }
            if (paramArticleInfo.mGalleryFeedsInfo.enum_article_style.get() == 2)
            {
              paramInt = 102;
              break;
            }
            paramInt = 101;
            break;
          }
          if (paramArticleInfo.mShowBigPicture)
          {
            if (paramArticleInfo.mIsGallery == 0)
            {
              if (paramArticleInfo.mTopicPicWHRatio != 0.0D)
              {
                paramInt = 9;
                break;
              }
              if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
              {
                paramInt = knd.g((AdvertisementInfo)paramArticleInfo);
                break;
              }
              paramInt = 2;
              break;
            }
            if (paramArticleInfo.articleStyle == 3)
            {
              paramInt = 47;
              break;
            }
            if (paramArticleInfo.articleStyle == 4)
            {
              paramInt = 60;
              break;
            }
            if (paramArticleInfo.articleStyle == 5)
            {
              paramInt = 61;
              break;
            }
            if (paramArticleInfo.articleStyle == 6)
            {
              paramInt = 96;
              break;
            }
            paramInt = 8;
            break;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (knd.m((AdvertisementInfo)paramArticleInfo))) {
            return 116;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (knd.n((AdvertisementInfo)paramArticleInfo))) {
            return 39;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (knd.o((AdvertisementInfo)paramArticleInfo))) {
            return 117;
          }
          if (kxm.p(paramArticleInfo))
          {
            if (kxm.q(paramArticleInfo)) {
              return 91;
            }
            return 90;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (knd.p((AdvertisementInfo)paramArticleInfo))) {
            return 127;
          }
          if ((!TextUtils.isEmpty(paramArticleInfo.smallGameData)) && (paramArticleInfo.mFeedType == 38)) {
            return 140;
          }
          if (paramArticleInfo.mFeedType == 39) {
            return 141;
          }
          if ((paramArticleInfo.mPictures != null) && (paramArticleInfo.mPictures.length >= 3))
          {
            if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
            {
              paramInt = 105;
              break;
            }
            paramInt = 3;
            break;
          }
          if (TextUtils.isEmpty(paramArticleInfo.mFirstPagePicUrl)) {
            break label7;
          }
          if ((AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (knd.q((AdvertisementInfo)paramArticleInfo)))
          {
            paramInt = 122;
            break;
          }
          if (paramArticleInfo.mFeedType == 37)
          {
            paramInt = 135;
            break;
          }
          if (paramArticleInfo.mIsGallery == 0)
          {
            if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
            {
              if (jzk.a(paramArticleInfo))
              {
                paramInt = 106;
                break;
              }
              paramInt = 104;
              break;
            }
            paramInt = 1;
            break;
          }
          paramInt = 7;
          break;
        }
        break;
      }
    }
  }
  
  private Bundle b(mye.b paramb, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject1 = null;
    Object localObject3;
    Object localObject2;
    if ((kxm.w(paramBaseArticleInfo)) && (paramb != null))
    {
      localObject3 = paramBaseArticleInfo.mNewPolymericInfo.iP.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (mhr.a)((Iterator)localObject3).next();
        if ((((mhr.a)localObject2).a == null) || (!TextUtils.equals(paramb.videoVid, ((mhr.a)localObject2).a.vid))) {
          break label989;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (mhr.a)paramBaseArticleInfo.mNewPolymericInfo.iP.get(0);
      }
      localObject1 = new Bundle();
      label392:
      boolean bool;
      if (((mhr.a)localObject2).isUgc)
      {
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((mhr.a)localObject2).a.shareUrl);
        ((Bundle)localObject1).putLong("VIDEO_FEED_ID", ((mhr.a)localObject2).sD);
        ((Bundle)localObject1).putInt("VIDEO_FEED_TYPE", ((mhr.a)localObject2).feedsType);
        if (((mhr.a)localObject2).a != null) {}
        ((Bundle)localObject1).putString("VIDEO_TIME", String.valueOf(paramb.videoDuration));
        ((Bundle)localObject1).putString("VIDEO_WIDTH", String.valueOf(paramb.videoWidth));
        ((Bundle)localObject1).putString("VIDEO_HEIGHT", String.valueOf(paramb.videoHeight));
        ((Bundle)localObject1).putString("VIDEO_VID", paramb.videoVid);
        ((Bundle)localObject1).putString("VIDEO_COVER", paramb.videoCoverUrl);
        ((Bundle)localObject1).putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
        ((Bundle)localObject1).putInt("VIDEO_STRATEGY_ID", paramb.strategyId);
        ((Bundle)localObject1).putLong("VIDEO_ALGORITHM_ID", paramb.algorithmID);
        ((Bundle)localObject1).putString("VIDEO_SECOND_INDEX_INNER_ID", paramb.akN);
        if ((this.jdField_a_of_type_Lgf$c == null) || (this.jdField_a_of_type_Lgf$c.a() == null) || (this.jdField_a_of_type_Mye == null) || (this.jdField_a_of_type_Lgf$c.a().articleID != paramb.articleID)) {
          break label959;
        }
        ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", this.jdField_a_of_type_Mye.cZ());
        ((Bundle)localObject1).putString("VIDEO_ARTICLE_ID", ((mhr.a)localObject2).ahs);
        ((Bundle)localObject1).putString("VIDEO_TITLE", ((mhr.a)localObject2).articleTitle);
        ((Bundle)localObject1).putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", awit.nJ(this.mChannelType));
        if (paramb.aDs != 1) {
          break label971;
        }
        bool = true;
        label444:
        ((Bundle)localObject1).putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
        ((Bundle)localObject1).putBoolean("isFromKandian", true);
        ((Bundle)localObject1).putLong("channelID", paramBaseArticleInfo.mChannelID);
        ((Bundle)localObject1).putLong("algorithmID", ((mhr.a)localObject2).algorithmID);
        ((Bundle)localObject1).putString("innderId", ((mhr.a)localObject2).ahs);
        ((Bundle)localObject1).putLong("strategyId", ((mhr.a)localObject2).strategyID);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ICON", paramb.thirdIcon);
        ((Bundle)localObject1).putString("VIDEO_THIRD_NAME", paramb.thirdName);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ACTION", paramb.thirdAction);
        ((Bundle)localObject1).putString("VIDEO_THIRD_URL", paramb.ahw);
        ((Bundle)localObject1).putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramb.xc);
        ((Bundle)localObject1).putInt("VIDEO_ARTICLE_BUSITYPE", paramb.aDs);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("VINFO", paramb.videoVid);
        ((Bundle)localObject3).putString("TINFO", paramb.videoVid);
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_TIME", paramb.videoDuration);
        if (this.jdField_a_of_type_Mye != null) {
          break label977;
        }
      }
      label959:
      label971:
      label977:
      for (int i = 0;; i = (int)this.jdField_a_of_type_Mye.cZ())
      {
        ((Bundle)localObject3).putInt("PREVIEW_START_POSI", myh.T(i, paramb.videoDuration));
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_WIDTH", paramb.videoWidth);
        ((Bundle)localObject3).putInt("PREVIEW_VIDEO_HEIGHT", paramb.videoHeight);
        ((Bundle)localObject3).putInt("FULL_VIDEO_TIME", paramb.videoDuration);
        ((Bundle)localObject3).putString("source_puin", ((mhr.a)localObject2).subscribeID);
        ((Bundle)localObject3).putString("ACCOUNT_UIN", ((mhr.a)localObject2).subscribeID);
        ((Bundle)localObject3).putString("ACCOUNT_NAME", ((mhr.a)localObject2).subscribeName);
        ((Bundle)localObject3).putInt("TYPE", paramb.aDs);
        ((Bundle)localObject3).putString("ARTICLE_ID", ((mhr.a)localObject2).ahs);
        ((Bundle)localObject3).putInt("layout_item", 5);
        ((Bundle)localObject3).putBoolean("video_url_load", false);
        ((Bundle)localObject3).putString("image_url_remote", paramb.videoCoverUrl);
        ((Bundle)localObject3).putString("detail_url", ((mhr.a)localObject2).articleContentUrl + "&sourcefrom=0");
        ((Bundle)localObject3).putString("video_url", paramb.videoVid);
        ((Bundle)localObject3).putString("title", ((mhr.a)localObject2).articleTitle);
        ((Bundle)localObject3).putString("req_create_time", kxl.ap(paramBaseArticleInfo.mTime));
        ((Bundle)localObject3).putString("brief_key", ((mhr.a)localObject2).articleTitle);
        ((Bundle)localObject3).putInt("req_type", 140);
        ((Bundle)localObject1).putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)anre.a((Bundle)localObject3)).getBytes());
        ((Bundle)localObject1).putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
        return localObject1;
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", ((mhr.a)localObject2).subscribeID);
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_NAME", ((mhr.a)localObject2).subscribeName);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((mhr.a)localObject2).articleContentUrl);
        break;
        ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", 0L);
        break label392;
        bool = false;
        break label444;
      }
      label989:
      break;
      localObject1 = null;
    }
  }
  
  public static String b(String paramString, Map<String, Object> paramMap)
  {
    JSONObject localJSONObject;
    if ((paramMap != null) && (paramMap.size() > 0)) {
      try
      {
        localJSONObject = new JSONObject(paramString);
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
          continue;
          return paramString;
        }
      }
      catch (Exception paramMap)
      {
        QLog.e("ReadInJoyBaseAdapter", 1, paramMap.getMessage());
      }
    }
    paramMap = localJSONObject.toString();
    return paramMap;
  }
  
  private void b(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    BaseArticleInfo localBaseArticleInfo = c(((lgf.f)paramView.getTag()).position);
    if (localBaseArticleInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_Mye.isPlaying()) {
      this.jdField_a_of_type_Mye.pause();
    }
    if (this.jdField_a_of_type_Myp != null) {
      this.jdField_a_of_type_Myp.a(1, localBaseArticleInfo, 0L, 0L);
    }
    paramView = new Intent(getActivity(), ReadInJoyDeliverBiuActivity.class);
    paramView.putExtra("arg_article_info", (ArticleInfo)localBaseArticleInfo);
    paramView.putExtra("biu_src", 2);
    paramView.putExtra("arg_from_type", 7);
    paramView.putExtra("fast_biu_type", paramBoolean2);
    getActivity().startActivityForResult(paramView, 2);
    getActivity().overridePendingTransition(0, 0);
    long l2 = 0L;
    paramView = this.jdField_a_of_type_Mye.c();
    long l1 = l2;
    if (paramView != null)
    {
      l1 = l2;
      if (paramView.videoVid.equals(localBaseArticleInfo.mVideoVid)) {
        l1 = this.jdField_a_of_type_Mye.cZ();
      }
    }
    String str1 = new nce.a(null, localBaseArticleInfo.mSubscribeID, localBaseArticleInfo.mVideoVid, localBaseArticleInfo.innerUniqueID).a(l1).c(localBaseArticleInfo.mVideoDuration * 1000).e(localBaseArticleInfo.mAlgorithmID).c(localBaseArticleInfo.mStrategyId).a(this.mChannelID).h(paramBoolean1).i(paramBoolean2).a().toJsonString();
    String str2 = localBaseArticleInfo.mSubscribeID;
    if (!TextUtils.isEmpty(localBaseArticleInfo.innerUniqueID))
    {
      paramView = localBaseArticleInfo.innerUniqueID;
      kbp.a(null, str2, "0X8007B89", "0X8007B89", 0, 0, "1", "", paramView, str1, false);
      l2 = getActivity().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      paramView = new ReportInfo.b();
      paramView.aSC = ((int)l1);
      paramView.videoDuration = (localBaseArticleInfo.mVideoDuration * 1000);
      if (l2 != 0L) {
        break label390;
      }
    }
    label390:
    for (int i = 1;; i = 2)
    {
      paramView.aSB = i;
      kct.a(localBaseArticleInfo, this.mChannelID, 25, -1L, paramView);
      return;
      paramView = "0";
      break;
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    if (paramArticleInfo == null) {
      return;
    }
    long l2 = paramArticleInfo.mFeedId;
    paramInt1 += 1;
    String str1;
    long l1;
    if ((ak(paramArticleInfo)) || (S(paramArticleInfo)) || (T(paramArticleInfo)) || (U(paramArticleInfo)))
    {
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null)) {
        break label273;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin);
      l1 = 0L;
    }
    for (;;)
    {
      label77:
      String str3 = kxm.a(paramInt2, paramInt1, null, kxm.a(paramArticleInfo), paramArticleInfo.innerUniqueID, kxm.f(paramArticleInfo), paramArticleInfo);
      if (odv.aT(paramArticleInfo.mChannelID)) {}
      for (String str2 = "0X8009363";; str2 = "0X8008899")
      {
        kbp.a(null, "CliOper", "", str1, str2, str2, 0, 0, Long.toString(l2), Long.toString(l1), "" + paramArticleInfo.mStrategyId, str3, false);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "reportGridImageClickEvent report click data, toUin: ", str1, ", r2(feedsId): ", Long.valueOf(l2), ", r3(articleId): ", Long.valueOf(l1), " r4(imagePos): ", Integer.valueOf(paramInt1), ", r5: ", str3 });
        return;
        str1 = paramArticleInfo.mSubscribeID;
        l1 = paramArticleInfo.mArticleID;
        break label77;
      }
      label273:
      l1 = 0L;
      str1 = "";
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt)
  {
    a(paramArticleInfo, paramString1, paramString2, paramInt, null);
  }
  
  private void cW(List<BaseArticleInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      QLog.d("ReadInJoyBaseAdapter", 1, "articleInfo list size =  " + paramList.size());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
        if (localBaseArticleInfo != null) {
          localArrayList.add(localBaseArticleInfo);
        } else {
          QLog.d("ReadInJoyBaseAdapter", 1, "has null items");
        }
      }
      paramList.clear();
      paramList.addAll(localArrayList);
    }
    QLog.d("ReadInJoyBaseAdapter", 1, "tempList size =  " + localArrayList.size());
  }
  
  private void cj(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "preloadImg start:" + paramInt1 + " count:" + paramInt2);
    }
    long l1 = System.currentTimeMillis();
    if (!aqiw.isWifiConnected(this.mContext)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.gO);
    ThreadManager.post(new ReadInJoyBaseAdapter.4(this, this.qC, localArrayList, paramInt1, paramInt2, l1), 5, null, true);
  }
  
  public static String d(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((jdField_c_of_type_Lrj != null) && (lrj.C(paramArticleInfo)))
    {
      paramArticleInfo = jdField_c_of_type_Lrj.l(paramArticleInfo);
      QLog.d("ReadInJoyBaseAdapter", 2, "getProteusFamilyCardViewType | dynamic viewType : " + paramArticleInfo);
      return paramArticleInfo;
    }
    paramArticleInfo = String.valueOf(b(paramArticleInfo, paramInt));
    QLog.d("ReadInJoyBaseAdapter", 2, "getProteusFamilyCardViewType | normal viewType : " + paramArticleInfo);
    return paramArticleInfo;
  }
  
  private void dg(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
      if ((this.gO.size() > 0) && (paramInt1 == 70))
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)this.gO.get(0);
        if (localBaseArticleInfo != null) {
          ((KandianSubscribeManager)localQQAppInterface.getManager(280)).a((ArticleInfo)localBaseArticleInfo, NetConnInfoCenter.getServerTime());
        }
      }
    }
  }
  
  public static JSONObject e(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static boolean ec(int paramInt)
  {
    return (paramInt == 49) || (paramInt == 62) || (paramInt == 63);
  }
  
  private void g(View paramView1, View paramView2)
  {
    p(paramView1, true);
    p(paramView2, false);
  }
  
  public static void g(ArticleInfo paramArticleInfo, int paramInt)
  {
    String str = odv.aB(paramInt);
    b(paramArticleInfo, str, str, paramInt);
  }
  
  private void g(AbsListView paramAbsListView)
  {
    if (paramAbsListView.getFirstVisiblePosition() == 0)
    {
      this.startIndex = 0;
      return;
    }
    ThreadManager.post(new ReadInJoyBaseAdapter.25(this, paramAbsListView), 8, null, true);
  }
  
  public static QQAppInterface getApp()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static void h(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      return;
    }
    int i;
    label17:
    int m;
    label29:
    String str1;
    String str2;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label238;
      }
      m = 0;
      str1 = kxm.f(paramArticleInfo);
      str2 = kxm.a(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), paramInt, i, m, aqiw.isWifiConnected(null), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, kxm.h(paramArticleInfo), paramArticleInfo);
      if ((!ak(paramArticleInfo)) && (!S(paramArticleInfo)) && (!T(paramArticleInfo)) && (!U(paramArticleInfo))) {
        break label243;
      }
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null)) {
        break label252;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin);
    }
    for (;;)
    {
      String str3 = odv.aB(paramInt);
      kbp.a(null, "CliOper", "", str1, str3, str3, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), str2, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "reportGridClickEvent channelId: ", Integer.valueOf(paramInt), ", toUin: ", str1, ", r5: ", str2 });
      return;
      i = 0;
      break label17;
      label238:
      m = 1;
      break label29;
      label243:
      str1 = paramArticleInfo.mSubscribeID;
      continue;
      label252:
      str1 = "";
    }
  }
  
  private void h(AbsListView paramAbsListView)
  {
    lgf.c localc = a(paramAbsListView);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 4, "playVideoInArea:" + localc);
    }
    mye.b localb;
    if (localc != null)
    {
      paramAbsListView = localc.a();
      localb = this.jdField_a_of_type_Mye.c();
      if (paramAbsListView == this.jdField_a_of_type_Mye.f) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "error state not play" + paramAbsListView.videoVid);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((localb != null) && (localb.articleID == paramAbsListView.articleID) && (localb.channelId == this.mChannelID) && (!this.jdField_a_of_type_Mye.isPause()) && (!this.jdField_a_of_type_Mye.isReady()));
        mzj.a().aUJ();
        a(localc);
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "checkPlayableArea vid: " + paramAbsListView.videoVid);
      return;
      aVX();
    } while (this.jdField_a_of_type_Mye.a() == null);
    this.jdField_a_of_type_Mye.a().f(paramAbsListView);
    this.jdField_a_of_type_Mye.a().aUn();
  }
  
  public static int i(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "ugc feeds info is null");
      }
      return 21;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa)
    {
    case 1: 
    default: 
      return 21;
    case 2: 
    case 3: 
      if ((paramArticleInfo.mSocialFeedInfo.aSG == 9) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.size() > 1)) {
        return 36;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$h != null) {
        return 80;
      }
      return 22;
    case 4: 
    case 5: 
      return 23;
    }
    if (paramArticleInfo.isWeishiGridTwoItemFeed()) {
      return 70;
    }
    if (paramArticleInfo.isTwoItemVideoFeed()) {
      return 46;
    }
    if (paramArticleInfo.mChannelID == 0L) {
      return 71;
    }
    if ((paramArticleInfo.mChannelID == 70L) || (paramArticleInfo.mChannelID == 41403L)) {
      return 23;
    }
    return 4;
  }
  
  public static int j(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null))
    {
      QLog.d("ReadInJoyBaseAdapter", 1, "getTopicRecommendAndUpdateUGCType ugc feeds info is null. article info is: " + paramArticleInfo);
      return 54;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa)
    {
    case 1: 
    default: 
      return 54;
    case 2: 
    case 3: 
      return 55;
    }
    return 56;
  }
  
  private void j(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.feedsFirstExposurePos == -1)) {
      paramBaseArticleInfo.feedsFirstExposurePos = paramInt;
    }
  }
  
  public static int k(ArticleInfo paramArticleInfo)
  {
    return b(paramArticleInfo, 0);
  }
  
  private void nT(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = kwt.acJ + aqgo.encodeToString(String.valueOf(paramString).getBytes(), 2);
    kxm.aJ(getActivity(), paramString);
  }
  
  public static boolean o(int paramInt, long paramLong)
  {
    return (paramInt == 4) || (paramInt == 5) || (paramInt == 25) || (paramInt == 32) || ((paramInt == 1) && ((paramLong == 4L) || (paramLong == 5L) || (paramLong == 25L) || (paramLong == 32L)));
  }
  
  private void p(View paramView, boolean paramBoolean)
  {
    paramView.getPaddingLeft();
    int n = paramView.getPaddingTop();
    paramView.getPaddingRight();
    int i1 = paramView.getPaddingBottom();
    int i;
    int m;
    if (kxm.AY())
    {
      i = aqcx.dip2px(getActivity(), 8.0F);
      if (!paramBoolean) {
        break label79;
      }
      m = qy();
      i /= 2;
    }
    for (;;)
    {
      paramView.setPadding(m, n, i, i1);
      return;
      i = aqcx.dip2px(getActivity(), 3.0F);
      break;
      label79:
      m = i / 2;
      i = qy();
    }
  }
  
  private int qy()
  {
    if (kxm.AY()) {
      return aqcx.dip2px(getActivity(), 14.0F);
    }
    return aqcx.dip2px(getActivity(), 6.0F);
  }
  
  public abstract boolean Fo();
  
  public aqdf a()
  {
    return null;
  }
  
  public autw a()
  {
    if (this.jdField_c_of_type_Autw == null) {
      this.jdField_c_of_type_Autw = new autw(this.mContext);
    }
    return this.jdField_c_of_type_Autw;
  }
  
  public auua a()
  {
    if (this.jdField_b_of_type_Auua == null) {
      this.jdField_b_of_type_Auua = new auua(this.mContext);
    }
    return this.jdField_b_of_type_Auua;
  }
  
  public abstract BaseArticleInfo a(int paramInt, long paramLong);
  
  public kmw a()
  {
    return this.jdField_a_of_type_Kmw;
  }
  
  public lgf.f a(String paramString)
  {
    int m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
    int i = Math.max(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount(), m);
    int n;
    if (i < getData().size() + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount())
    {
      n = i - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
      BaseArticleInfo localBaseArticleInfo = c(n);
      if ((4 == getItemViewType(n)) && (localBaseArticleInfo != null) && (TextUtils.equals(localBaseArticleInfo.getInnerUniqueID(), paramString)))
      {
        int i1 = i - m;
        if ((i1 >= 0) && (i1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())) {
          paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i - m);
        }
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        return (lgf.f)paramString.getTag();
        if ((n >= 0) && (n < getData().size())) {
          paramString = getView(n, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        }
      }
      else
      {
        return null;
        i += 1;
        break;
        return null;
      }
      paramString = null;
    }
  }
  
  public lrj a()
  {
    return jdField_c_of_type_Lrj;
  }
  
  public msl a()
  {
    return this.jdField_b_of_type_Msl;
  }
  
  public mye a()
  {
    return this.jdField_a_of_type_Mye;
  }
  
  public ndi.a a()
  {
    return this.jdField_a_of_type_Ndi$a;
  }
  
  public ndi.b a()
  {
    return this.jdField_a_of_type_Ndi$b;
  }
  
  public ndi.c a()
  {
    return this.jdField_a_of_type_Ndi$c;
  }
  
  public ndi.d a()
  {
    return this.jdField_a_of_type_Ndi$d;
  }
  
  public nrl a()
  {
    if (this.jdField_a_of_type_Nrl == null) {
      this.jdField_a_of_type_Nrl = new nrl(this.mContext, this);
    }
    return this.jdField_a_of_type_Nrl;
  }
  
  public abstract void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, ArrayList<DislikeInfo> paramArrayList);
  
  public abstract void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1);
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject)
  {
    a(paramInt, paramArrayList, paramArrayList1, paramObject, false, true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean)
  {
    a(paramInt, paramArrayList, paramArrayList1, paramObject, paramBoolean, true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.gO.removeAll(paramArrayList);
      this.arB = true;
      notifyDataSetChanged();
    }
    BaseArticleInfo localBaseArticleInfo = null;
    if (paramArrayList.size() > 0) {
      localBaseArticleInfo = (BaseArticleInfo)paramArrayList.get(0);
    }
    int i = 2131701914;
    if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) {
      i = 2131701915;
    }
    if ((this.mContext instanceof BaseActivity))
    {
      QQToast.a(this.mContext, -1, this.mContext.getString(i), 0).show(((BaseActivity)this.mContext).getTitleBarHeight());
      a(paramInt, paramArrayList, paramArrayList1);
      if ((AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) || (kni.g(localBaseArticleInfo)))
      {
        long l2 = 0L;
        long l1 = l2;
        if (paramObject != null)
        {
          l1 = l2;
          if ((paramObject instanceof DislikeInfo)) {
            l1 = ((DislikeInfo)paramObject).vf;
          }
        }
        paramArrayList = null;
        if (!(localBaseArticleInfo instanceof AdvertisementInfo)) {
          break label412;
        }
        paramArrayList = (AdvertisementInfo)localBaseArticleInfo;
        label178:
        lbz.a().a(this.mContext, paramArrayList, l1, paramArrayList1, paramBoolean1);
      }
    }
    for (;;)
    {
      try
      {
        paramArrayList = new JSONObject();
        paramArrayList.put("time", System.currentTimeMillis() / 1000L);
        paramArrayList.put("channel_id", this.mChannelID);
        if (paramArrayList1 == null) {
          continue;
        }
        paramInt = paramArrayList1.size();
        paramArrayList.put("tag_num", paramInt);
        if (!(this.mContext instanceof BaseActivity)) {
          continue;
        }
        paramArrayList.put("folder_status", kxm.aMw);
        paramArrayList.put("kandian_mode", kxm.nR());
        if (localBaseArticleInfo != null)
        {
          paramArrayList.put("feeds_type", "" + kxm.a(localBaseArticleInfo));
          paramArrayList.put("rowkey", odv.r(localBaseArticleInfo));
        }
        paramArrayList = paramArrayList.toString();
        kbp.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", kxm.j(paramArrayList1), paramArrayList, false);
      }
      catch (JSONException paramArrayList)
      {
        label412:
        paramArrayList.printStackTrace();
        continue;
      }
      lvd.f(localBaseArticleInfo);
      return;
      if (!(this.mContext instanceof PluginBaseActivity)) {
        break;
      }
      QQToast.a(this.mContext, -1, this.mContext.getString(i), 0).show(((PluginBaseActivity)this.mContext).getTitleBarHeight());
      break;
      if (!kni.g(localBaseArticleInfo)) {
        break label178;
      }
      paramArrayList = localBaseArticleInfo.mSocialFeedInfo.g;
      break label178;
      paramInt = 0;
      continue;
      if ((this.mContext instanceof PluginBaseActivity))
      {
        paramArrayList.put("folder_status", 1);
        anot.a(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", paramArrayList.toString());
      }
    }
  }
  
  public void a(View paramView, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramInt == 46) {
      return;
    }
    VideoReport.setElementId(paramView, "card");
    lal locallal = new lal().a(this.mChannelID);
    if (paramBaseArticleInfo != null) {}
    for (String str = paramBaseArticleInfo.innerUniqueID;; str = "")
    {
      VideoReport.setElementParams(paramView, locallal.a(str).build());
      VideoReport.setElementReuseIdentifier(paramView, paramBaseArticleInfo.innerUniqueID);
      return;
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, lie paramlie, long paramLong, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (this.U == null) || (((paramBaseArticleInfo instanceof ArticleInfo)) && (jdField_c_of_type_Lrj.D((ArticleInfo)paramBaseArticleInfo)))) {
      break label31;
    }
    label31:
    while ((((paramBaseArticleInfo instanceof ArticleInfo)) && (luy.E((ArticleInfo)paramBaseArticleInfo))) || ((kxm.s(paramBaseArticleInfo)) && (!kxm.u(paramBaseArticleInfo)))) {
      return;
    }
    if ((paramBaseArticleInfo.hasOnlyTwoVideoFeeds()) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (paramBaseArticleInfo.mFeedType != 121))
    {
      Iterator localIterator = paramBaseArticleInfo.mSubArtilceList.iterator();
      while (localIterator.hasNext()) {
        a((ArticleInfo)localIterator.next(), new lis(this.mContext, (ArticleInfo)paramBaseArticleInfo, 46, this.mChannelID, this.mChannelType, paramInt, this.akw, getCount(), null, this), paramLong, paramInt);
      }
    }
    int i;
    if ((kxm.B(paramBaseArticleInfo)) && (paramBaseArticleInfo.mNewPolymericInfo.amx)) {
      if (!this.ek.containsKey(Long.valueOf(-paramBaseArticleInfo.mArticleID))) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        ThreadManager.post(new ReadInJoyBaseAdapter.12(this, paramBaseArticleInfo, paramlie, paramInt, paramLong, paramBaseArticleInfo), 5, null, true);
      }
      if (!kxm.AW()) {
        break;
      }
      ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.13(this, paramBaseArticleInfo));
      return;
      i = 0;
      continue;
      if (!this.ek.containsKey(Long.valueOf(paramBaseArticleInfo.mArticleID))) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public void a(jzh paramjzh)
  {
    this.jdField_b_of_type_Jzh = paramjzh;
  }
  
  public void a(kmw paramkmw)
  {
    this.jdField_a_of_type_Kmw = paramkmw;
  }
  
  /* Error */
  public void a(lgf.a parama, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: getfield 2776	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   9: ifnull +142 -> 151
    //   12: aload_2
    //   13: getfield 2776	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   16: astore 4
    //   18: aload 4
    //   20: getfield 2779	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:aiR	Ljava/lang/String;
    //   23: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +404 -> 430
    //   29: aload_1
    //   30: getfield 2784	lgf$a:pu	Landroid/widget/TextView;
    //   33: aload 4
    //   35: getfield 2779	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:aiR	Ljava/lang/String;
    //   38: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   41: aload_1
    //   42: getfield 2784	lgf$a:pu	Landroid/widget/TextView;
    //   45: iconst_0
    //   46: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   49: aload 4
    //   51: getfield 2788	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:aiO	Ljava/lang/String;
    //   54: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +395 -> 452
    //   60: new 1091	java/net/URL
    //   63: dup
    //   64: aload 4
    //   66: getfield 2788	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:aiO	Ljava/lang/String;
    //   69: invokespecial 1319	java/net/URL:<init>	(Ljava/lang/String;)V
    //   72: astore 5
    //   74: aload_1
    //   75: getfield 2790	lgf$a:i	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   78: aload 5
    //   80: invokevirtual 2794	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   83: pop
    //   84: aload_1
    //   85: getfield 2790	lgf$a:i	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   88: iconst_0
    //   89: invokevirtual 1343	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   92: aload 4
    //   94: getfield 2797	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:columnName	Ljava/lang/String;
    //   97: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   100: ifne +382 -> 482
    //   103: aload_1
    //   104: getfield 2800	lgf$a:pv	Landroid/widget/TextView;
    //   107: aload 4
    //   109: getfield 2797	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:columnName	Ljava/lang/String;
    //   112: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   115: aload_1
    //   116: getfield 2800	lgf$a:pv	Landroid/widget/TextView;
    //   119: iconst_0
    //   120: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   123: aload 4
    //   125: getfield 2803	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:aiS	Ljava/lang/String;
    //   128: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +20 -> 151
    //   134: aload 4
    //   136: getfield 2803	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:aiS	Ljava/lang/String;
    //   139: invokestatic 186	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   142: istore_3
    //   143: aload_1
    //   144: getfield 2800	lgf$a:pv	Landroid/widget/TextView;
    //   147: iload_3
    //   148: invokevirtual 2806	android/widget/TextView:setTextColor	(I)V
    //   151: aload_2
    //   152: invokestatic 1555	ndi:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lmye$b;
    //   155: astore 4
    //   157: aload 4
    //   159: aload_1
    //   160: getfield 2807	lgf$a:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   163: putfield 1562	mye$b:ma	Landroid/view/View;
    //   166: aload 4
    //   168: aload_1
    //   169: getfield 2808	lgf$a:position	I
    //   172: putfield 465	mye$b:position	I
    //   175: aload 4
    //   177: aload_2
    //   178: putfield 1046	mye$b:d	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   181: aload_1
    //   182: aload 4
    //   184: putfield 2809	lgf$a:jdField_a_of_type_Mye$b	Lmye$b;
    //   187: aload_1
    //   188: getfield 2812	lgf$a:pp	Landroid/widget/TextView;
    //   191: aload_2
    //   192: getfield 790	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   195: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   198: aload_1
    //   199: getfield 2812	lgf$a:pp	Landroid/widget/TextView;
    //   202: invokevirtual 2816	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   205: iconst_1
    //   206: invokevirtual 2821	android/text/TextPaint:setFakeBoldText	(Z)V
    //   209: aload_1
    //   210: getfield 2812	lgf$a:pp	Landroid/widget/TextView;
    //   213: aload_0
    //   214: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   217: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   220: ldc_w 2822
    //   223: invokevirtual 2827	android/content/res/Resources:getColor	(I)I
    //   226: invokevirtual 2806	android/widget/TextView:setTextColor	(I)V
    //   229: aload_1
    //   230: getfield 2830	lgf$a:pq	Landroid/widget/TextView;
    //   233: bipush 8
    //   235: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   238: aload_1
    //   239: getfield 2833	lgf$a:pr	Landroid/widget/TextView;
    //   242: aload 4
    //   244: getfield 553	mye$b:videoDuration	I
    //   247: invokestatic 2836	kwz:ba	(I)Ljava/lang/String;
    //   250: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   253: aload_1
    //   254: getfield 2839	lgf$a:iU	Landroid/widget/ImageView;
    //   257: bipush 10
    //   259: bipush 10
    //   261: bipush 10
    //   263: bipush 10
    //   265: invokestatic 2844	rpq:h	(Landroid/view/View;IIII)V
    //   268: aload_1
    //   269: getfield 2839	lgf$a:iU	Landroid/widget/ImageView;
    //   272: aload_1
    //   273: invokevirtual 1552	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   276: aload_1
    //   277: getfield 2839	lgf$a:iU	Landroid/widget/ImageView;
    //   280: aload_0
    //   281: invokevirtual 1539	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   284: aload_0
    //   285: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   288: aload_1
    //   289: getfield 2807	lgf$a:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   292: aload_1
    //   293: getfield 2809	lgf$a:jdField_a_of_type_Mye$b	Lmye$b;
    //   296: invokestatic 2847	lgf:a	(Landroid/content/Context;Landroid/widget/ImageView;Lmye$b;)V
    //   299: aload_0
    //   300: aload_1
    //   301: getfield 2807	lgf$a:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   304: aload_2
    //   305: iconst_0
    //   306: invokevirtual 968	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   309: iconst_0
    //   310: invokespecial 1392	ndi:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   313: aload_1
    //   314: getfield 2807	lgf$a:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   317: aload_0
    //   318: invokevirtual 2851	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   321: aload_1
    //   322: getfield 2854	lgf$a:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   325: fconst_1
    //   326: aload 4
    //   328: getfield 739	mye$b:videoWidth	I
    //   331: aload 4
    //   333: getfield 744	mye$b:videoHeight	I
    //   336: invokestatic 2857	kwz:c	(II)F
    //   339: invokevirtual 2863	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   342: aload_1
    //   343: getfield 2854	lgf$a:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   346: aload_1
    //   347: invokevirtual 2864	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   350: aload_0
    //   351: aload_0
    //   352: getfield 197	ndi:mChannelID	I
    //   355: aload_2
    //   356: getfield 394	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   359: invokevirtual 2866	ndi:n	(IJ)Z
    //   362: ifeq +23 -> 385
    //   365: aload_1
    //   366: getfield 2869	lgf$a:itemView	Landroid/view/View;
    //   369: aload_0
    //   370: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   373: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   376: ldc_w 2870
    //   379: invokevirtual 2827	android/content/res/Resources:getColor	(I)I
    //   382: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   385: aload_2
    //   386: getfield 584	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   389: lconst_0
    //   390: lcmp
    //   391: ifgt +3 -> 394
    //   394: aload_0
    //   395: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   398: invokestatic 1190	aqiw:isWifiConnected	(Landroid/content/Context;)Z
    //   401: ifeq +93 -> 494
    //   404: aload_1
    //   405: getfield 2876	lgf$a:iT	Landroid/widget/ImageView;
    //   408: iconst_0
    //   409: invokevirtual 1360	android/widget/ImageView:setVisibility	(I)V
    //   412: aload_1
    //   413: getfield 2879	lgf$a:ps	Landroid/widget/TextView;
    //   416: bipush 8
    //   418: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   421: aload_1
    //   422: getfield 2882	lgf$a:kr	Landroid/view/View;
    //   425: iconst_0
    //   426: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   429: return
    //   430: aload_1
    //   431: getfield 2784	lgf$a:pu	Landroid/widget/TextView;
    //   434: bipush 8
    //   436: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   439: goto -390 -> 49
    //   442: astore 5
    //   444: aload 5
    //   446: invokevirtual 2883	java/lang/Exception:printStackTrace	()V
    //   449: goto -357 -> 92
    //   452: aload_1
    //   453: getfield 2790	lgf$a:i	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   456: bipush 8
    //   458: invokevirtual 1343	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   461: goto -369 -> 92
    //   464: astore 4
    //   466: aload_1
    //   467: getfield 2800	lgf$a:pv	Landroid/widget/TextView;
    //   470: ldc_w 2885
    //   473: invokestatic 186	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   476: invokevirtual 2806	android/widget/TextView:setTextColor	(I)V
    //   479: goto -328 -> 151
    //   482: aload_1
    //   483: getfield 2800	lgf$a:pv	Landroid/widget/TextView;
    //   486: bipush 8
    //   488: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   491: goto -340 -> 151
    //   494: aload_1
    //   495: getfield 2876	lgf$a:iT	Landroid/widget/ImageView;
    //   498: bipush 8
    //   500: invokevirtual 1360	android/widget/ImageView:setVisibility	(I)V
    //   503: aload_0
    //   504: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   507: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   510: ldc_w 2886
    //   513: invokevirtual 2889	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   516: astore 4
    //   518: aload_1
    //   519: getfield 2879	lgf$a:ps	Landroid/widget/TextView;
    //   522: aload 4
    //   524: aconst_null
    //   525: aconst_null
    //   526: aconst_null
    //   527: invokevirtual 2893	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   530: aload_1
    //   531: getfield 2879	lgf$a:ps	Landroid/widget/TextView;
    //   534: ldc_w 2545
    //   537: aload_0
    //   538: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   541: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   544: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   547: invokevirtual 2896	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   550: aload_1
    //   551: getfield 2879	lgf$a:ps	Landroid/widget/TextView;
    //   554: iconst_0
    //   555: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   558: invokestatic 2901	aqux:Mv	()I
    //   561: iconst_1
    //   562: if_icmpne +21 -> 583
    //   565: aload_1
    //   566: getfield 2904	lgf$a:pt	Landroid/widget/TextView;
    //   569: bipush 8
    //   571: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   574: aload_1
    //   575: getfield 2882	lgf$a:kr	Landroid/view/View;
    //   578: iconst_0
    //   579: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   582: return
    //   583: invokestatic 2907	awit:aMT	()Z
    //   586: ifeq +281 -> 867
    //   589: aload_0
    //   590: getfield 2909	ndi:ary	Z
    //   593: ifne +274 -> 867
    //   596: aload_1
    //   597: getfield 2808	lgf$a:position	I
    //   600: ifne +267 -> 867
    //   603: invokestatic 2912	awit:Hc	()Ljava/lang/String;
    //   606: astore 5
    //   608: invokestatic 2915	awit:Hd	()Ljava/lang/String;
    //   611: astore 6
    //   613: invokestatic 2918	awit:He	()Ljava/lang/String;
    //   616: astore 7
    //   618: aload 5
    //   620: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   623: ifne +210 -> 833
    //   626: invokestatic 2920	kxm:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   629: astore 8
    //   631: ldc_w 843
    //   634: astore 4
    //   636: aload 8
    //   638: ifnull +10 -> 648
    //   641: aload 8
    //   643: invokevirtual 2923	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   646: astore 4
    //   648: new 2241	nce$a
    //   651: dup
    //   652: aconst_null
    //   653: aconst_null
    //   654: aconst_null
    //   655: aconst_null
    //   656: invokespecial 2244	nce$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   659: aload 4
    //   661: invokevirtual 2926	nce$a:l	(Ljava/lang/String;)Lnce$a;
    //   664: aload_2
    //   665: getfield 681	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   668: invokevirtual 2928	nce$a:h	(Ljava/lang/String;)Lnce$a;
    //   671: invokevirtual 2267	nce$a:a	()Lnce;
    //   674: invokevirtual 2272	nce:toJsonString	()Ljava/lang/String;
    //   677: astore_2
    //   678: aload_1
    //   679: getfield 2904	lgf$a:pt	Landroid/widget/TextView;
    //   682: iconst_0
    //   683: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   686: aload_1
    //   687: getfield 2904	lgf$a:pt	Landroid/widget/TextView;
    //   690: fconst_2
    //   691: aload_0
    //   692: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   695: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   698: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   701: invokevirtual 2896	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   704: aload_0
    //   705: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   708: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   711: ldc_w 2929
    //   714: invokevirtual 2889	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   717: astore 4
    //   719: aload 4
    //   721: iconst_0
    //   722: iconst_0
    //   723: ldc_w 2930
    //   726: aload_0
    //   727: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   730: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   733: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   736: ldc_w 2930
    //   739: aload_0
    //   740: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   743: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   746: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   749: invokevirtual 2935	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   752: aload_1
    //   753: getfield 2904	lgf$a:pt	Landroid/widget/TextView;
    //   756: aconst_null
    //   757: aconst_null
    //   758: aload 4
    //   760: aconst_null
    //   761: invokevirtual 2938	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   764: aload_0
    //   765: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   768: aload_1
    //   769: getfield 2904	lgf$a:pt	Landroid/widget/TextView;
    //   772: aload 6
    //   774: aload 7
    //   776: aload 5
    //   778: new 2940	nei
    //   781: dup
    //   782: aload_0
    //   783: aload_2
    //   784: aload_1
    //   785: invokespecial 2943	nei:<init>	(Lndi;Ljava/lang/String;Llgf$a;)V
    //   788: invokestatic 2946	muj:a	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   791: aload_1
    //   792: getfield 2882	lgf$a:kr	Landroid/view/View;
    //   795: ldc_w 2947
    //   798: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   801: aload_0
    //   802: iconst_1
    //   803: putfield 2909	ndi:ary	Z
    //   806: aconst_null
    //   807: ldc_w 843
    //   810: ldc_w 2949
    //   813: ldc_w 2949
    //   816: iconst_0
    //   817: iconst_0
    //   818: ldc_w 843
    //   821: ldc_w 843
    //   824: ldc_w 843
    //   827: aload_2
    //   828: iconst_0
    //   829: invokestatic 1259	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   832: return
    //   833: aload_1
    //   834: getfield 2904	lgf$a:pt	Landroid/widget/TextView;
    //   837: bipush 8
    //   839: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   842: aload_1
    //   843: getfield 2882	lgf$a:kr	Landroid/view/View;
    //   846: iconst_0
    //   847: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   850: invokestatic 919	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   853: ifeq -849 -> 4
    //   856: ldc_w 921
    //   859: iconst_2
    //   860: ldc_w 2951
    //   863: invokestatic 927	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: return
    //   867: aload_1
    //   868: getfield 2904	lgf$a:pt	Landroid/widget/TextView;
    //   871: bipush 8
    //   873: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   876: aload_1
    //   877: getfield 2882	lgf$a:kr	Landroid/view/View;
    //   880: iconst_0
    //   881: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   884: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	885	0	this	ndi
    //   0	885	1	parama	lgf.a
    //   0	885	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	885	3	paramInt	int
    //   16	316	4	localObject1	Object
    //   464	1	4	localThrowable	Throwable
    //   516	243	4	localObject2	Object
    //   72	7	5	localURL	URL
    //   442	3	5	localException	Exception
    //   606	171	5	str1	String
    //   611	162	6	str2	String
    //   616	159	7	str3	String
    //   629	13	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   60	92	442	java/lang/Exception
    //   134	151	464	java/lang/Throwable
  }
  
  /* Error */
  public void a(lgf.b paramb, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: getfield 2955	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   9: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +502 -> 514
    //   15: aload_1
    //   16: getfield 2960	lgf$b:pz	Landroid/widget/TextView;
    //   19: aload_2
    //   20: getfield 2955	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   23: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   26: aload_2
    //   27: getfield 2963	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   30: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +472 -> 505
    //   36: ldc_w 2965
    //   39: astore 4
    //   41: aload 4
    //   43: invokestatic 186	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   46: istore_3
    //   47: aload_1
    //   48: getfield 2960	lgf$b:pz	Landroid/widget/TextView;
    //   51: iload_3
    //   52: invokevirtual 2806	android/widget/TextView:setTextColor	(I)V
    //   55: aload_1
    //   56: getfield 2960	lgf$b:pz	Landroid/widget/TextView;
    //   59: iconst_0
    //   60: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   63: aload_1
    //   64: getfield 2968	lgf$b:px	Landroid/widget/TextView;
    //   67: aload_2
    //   68: getfield 523	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   71: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   74: aload_2
    //   75: invokevirtual 1307	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:hasFamilyCommentIcon	()Z
    //   78: ifeq +463 -> 541
    //   81: new 1091	java/net/URL
    //   84: dup
    //   85: aload_2
    //   86: getfield 1311	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lmhd;
    //   89: getfield 1316	mhd:agS	Ljava/lang/String;
    //   92: invokespecial 1319	java/net/URL:<init>	(Ljava/lang/String;)V
    //   95: astore 4
    //   97: aload_2
    //   98: getfield 1311	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lmhd;
    //   101: getfield 1322	mhd:BT	I
    //   104: ifle +27 -> 131
    //   107: aload_0
    //   108: aload_1
    //   109: getfield 2970	lgf$b:j	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   112: aload 4
    //   114: aload_2
    //   115: getfield 1311	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lmhd;
    //   118: getfield 1325	mhd:aOw	I
    //   121: aload_2
    //   122: getfield 1311	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lmhd;
    //   125: getfield 1322	mhd:BT	I
    //   128: invokespecial 1328	ndi:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;II)V
    //   131: aload_1
    //   132: getfield 2970	lgf$b:j	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   135: iconst_0
    //   136: invokevirtual 1343	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   139: aload_1
    //   140: getfield 2973	lgf$b:py	Landroid/widget/TextView;
    //   143: bipush 8
    //   145: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   148: aload_2
    //   149: getfield 2976	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   152: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne +426 -> 581
    //   158: new 1091	java/net/URL
    //   161: dup
    //   162: aload_2
    //   163: getfield 2976	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   166: invokespecial 1319	java/net/URL:<init>	(Ljava/lang/String;)V
    //   169: astore 4
    //   171: aload_1
    //   172: getfield 2978	lgf$b:k	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   175: aload 4
    //   177: invokevirtual 2794	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   180: pop
    //   181: aload_1
    //   182: getfield 2978	lgf$b:k	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   185: iconst_0
    //   186: invokevirtual 1343	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   189: aload_1
    //   190: getfield 2979	lgf$b:iU	Landroid/widget/ImageView;
    //   193: bipush 10
    //   195: bipush 10
    //   197: bipush 10
    //   199: bipush 10
    //   201: invokestatic 2844	rpq:h	(Landroid/view/View;IIII)V
    //   204: aload_1
    //   205: getfield 2979	lgf$b:iU	Landroid/widget/ImageView;
    //   208: aload_1
    //   209: invokevirtual 1552	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   212: aload_1
    //   213: getfield 2979	lgf$b:iU	Landroid/widget/ImageView;
    //   216: aload_0
    //   217: invokevirtual 1539	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   220: aload_2
    //   221: invokestatic 1555	ndi:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lmye$b;
    //   224: astore 4
    //   226: aload 4
    //   228: aload_1
    //   229: getfield 2980	lgf$b:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   232: putfield 1562	mye$b:ma	Landroid/view/View;
    //   235: aload 4
    //   237: aload_1
    //   238: getfield 2981	lgf$b:position	I
    //   241: putfield 465	mye$b:position	I
    //   244: aload 4
    //   246: aload_2
    //   247: putfield 1046	mye$b:d	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   250: aload 4
    //   252: iconst_1
    //   253: putfield 2984	mye$b:aVV	I
    //   256: aload_1
    //   257: aload 4
    //   259: putfield 2985	lgf$b:jdField_a_of_type_Mye$b	Lmye$b;
    //   262: aload_1
    //   263: getfield 2986	lgf$b:pp	Landroid/widget/TextView;
    //   266: bipush 8
    //   268: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   271: aload_1
    //   272: getfield 2989	lgf$b:pw	Landroid/widget/TextView;
    //   275: bipush 8
    //   277: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   280: aload_1
    //   281: getfield 2992	lgf$b:ks	Landroid/view/View;
    //   284: bipush 8
    //   286: invokevirtual 1304	android/view/View:setVisibility	(I)V
    //   289: aload_1
    //   290: getfield 2995	lgf$b:titleTextView	Landroid/widget/TextView;
    //   293: aload_2
    //   294: getfield 790	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   297: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   300: aload_1
    //   301: getfield 2995	lgf$b:titleTextView	Landroid/widget/TextView;
    //   304: astore 5
    //   306: invokestatic 1701	lbz:a	()Llbz;
    //   309: aload_2
    //   310: getfield 394	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   313: invokevirtual 2998	lbz:aO	(J)Z
    //   316: ifeq +277 -> 593
    //   319: getstatic 188	ndi:aOi	I
    //   322: istore_3
    //   323: aload 5
    //   325: iload_3
    //   326: invokevirtual 2806	android/widget/TextView:setTextColor	(I)V
    //   329: aload_1
    //   330: getfield 2999	lgf$b:pr	Landroid/widget/TextView;
    //   333: aload 4
    //   335: getfield 553	mye$b:videoDuration	I
    //   338: invokestatic 2836	kwz:ba	(I)Ljava/lang/String;
    //   341: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   344: aload_0
    //   345: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   348: aload_1
    //   349: getfield 2980	lgf$b:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   352: aload_1
    //   353: getfield 2985	lgf$b:jdField_a_of_type_Mye$b	Lmye$b;
    //   356: invokestatic 2847	lgf:a	(Landroid/content/Context;Landroid/widget/ImageView;Lmye$b;)V
    //   359: aload_0
    //   360: aload_1
    //   361: getfield 2980	lgf$b:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   364: aload_2
    //   365: iconst_0
    //   366: invokevirtual 968	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   369: iconst_0
    //   370: invokespecial 1392	ndi:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   373: aload_1
    //   374: getfield 2980	lgf$b:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   377: aload_0
    //   378: invokevirtual 2851	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   381: aload_1
    //   382: getfield 2999	lgf$b:pr	Landroid/widget/TextView;
    //   385: iconst_0
    //   386: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   389: aload_1
    //   390: getfield 2999	lgf$b:pr	Landroid/widget/TextView;
    //   393: invokevirtual 3002	android/widget/TextView:clearAnimation	()V
    //   396: aload_1
    //   397: getfield 3003	lgf$b:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   400: fconst_1
    //   401: aload 4
    //   403: getfield 739	mye$b:videoWidth	I
    //   406: aload 4
    //   408: getfield 744	mye$b:videoHeight	I
    //   411: invokestatic 2857	kwz:c	(II)F
    //   414: invokevirtual 2863	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   417: aload_1
    //   418: getfield 3003	lgf$b:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   421: aload_1
    //   422: invokevirtual 2864	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   425: aload_0
    //   426: aload_0
    //   427: getfield 197	ndi:mChannelID	I
    //   430: aload_2
    //   431: getfield 394	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   434: invokevirtual 2866	ndi:n	(IJ)Z
    //   437: ifeq +23 -> 460
    //   440: aload_1
    //   441: getfield 3004	lgf$b:itemView	Landroid/view/View;
    //   444: aload_0
    //   445: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   448: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   451: ldc_w 2870
    //   454: invokevirtual 2827	android/content/res/Resources:getColor	(I)I
    //   457: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   460: aload_2
    //   461: getfield 584	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   464: lconst_0
    //   465: lcmp
    //   466: ifgt +3 -> 469
    //   469: aload_0
    //   470: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   473: invokestatic 1190	aqiw:isWifiConnected	(Landroid/content/Context;)Z
    //   476: ifeq +124 -> 600
    //   479: aload_1
    //   480: getfield 3005	lgf$b:iT	Landroid/widget/ImageView;
    //   483: iconst_0
    //   484: invokevirtual 1360	android/widget/ImageView:setVisibility	(I)V
    //   487: aload_1
    //   488: getfield 3006	lgf$b:ps	Landroid/widget/TextView;
    //   491: bipush 8
    //   493: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   496: aload_1
    //   497: getfield 3007	lgf$b:kr	Landroid/view/View;
    //   500: iconst_0
    //   501: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   504: return
    //   505: aload_2
    //   506: getfield 2963	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   509: astore 4
    //   511: goto -470 -> 41
    //   514: aload_1
    //   515: getfield 2960	lgf$b:pz	Landroid/widget/TextView;
    //   518: bipush 8
    //   520: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   523: goto -460 -> 63
    //   526: astore 4
    //   528: ldc_w 1233
    //   531: iconst_2
    //   532: ldc_w 3009
    //   535: invokestatic 1348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   538: goto -390 -> 148
    //   541: aload_1
    //   542: getfield 2970	lgf$b:j	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   545: bipush 8
    //   547: invokevirtual 1343	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   550: aload_1
    //   551: getfield 2973	lgf$b:py	Landroid/widget/TextView;
    //   554: iconst_0
    //   555: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   558: ldc_w 1233
    //   561: iconst_2
    //   562: ldc_w 3011
    //   565: invokestatic 1348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   568: goto -420 -> 148
    //   571: astore 4
    //   573: aload 4
    //   575: invokevirtual 2883	java/lang/Exception:printStackTrace	()V
    //   578: goto -389 -> 189
    //   581: aload_1
    //   582: getfield 2978	lgf$b:k	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   585: bipush 8
    //   587: invokevirtual 1343	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   590: goto -401 -> 189
    //   593: getstatic 192	ndi:aOj	I
    //   596: istore_3
    //   597: goto -274 -> 323
    //   600: aload_1
    //   601: getfield 3005	lgf$b:iT	Landroid/widget/ImageView;
    //   604: bipush 8
    //   606: invokevirtual 1360	android/widget/ImageView:setVisibility	(I)V
    //   609: aload_0
    //   610: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   613: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   616: ldc_w 2886
    //   619: invokevirtual 2889	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   622: astore 4
    //   624: aload_1
    //   625: getfield 3006	lgf$b:ps	Landroid/widget/TextView;
    //   628: aload 4
    //   630: aconst_null
    //   631: aconst_null
    //   632: aconst_null
    //   633: invokevirtual 2893	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   636: aload_1
    //   637: getfield 3006	lgf$b:ps	Landroid/widget/TextView;
    //   640: ldc_w 2545
    //   643: aload_0
    //   644: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   647: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   650: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   653: invokevirtual 2896	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   656: aload_1
    //   657: getfield 3006	lgf$b:ps	Landroid/widget/TextView;
    //   660: iconst_0
    //   661: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   664: invokestatic 2901	aqux:Mv	()I
    //   667: iconst_1
    //   668: if_icmpne +21 -> 689
    //   671: aload_1
    //   672: getfield 3012	lgf$b:pt	Landroid/widget/TextView;
    //   675: bipush 8
    //   677: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   680: aload_1
    //   681: getfield 3007	lgf$b:kr	Landroid/view/View;
    //   684: iconst_0
    //   685: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   688: return
    //   689: invokestatic 2907	awit:aMT	()Z
    //   692: ifeq +281 -> 973
    //   695: aload_0
    //   696: getfield 2909	ndi:ary	Z
    //   699: ifne +274 -> 973
    //   702: aload_1
    //   703: getfield 2981	lgf$b:position	I
    //   706: ifne +267 -> 973
    //   709: invokestatic 2912	awit:Hc	()Ljava/lang/String;
    //   712: astore 5
    //   714: invokestatic 2915	awit:Hd	()Ljava/lang/String;
    //   717: astore 6
    //   719: invokestatic 2918	awit:He	()Ljava/lang/String;
    //   722: astore 7
    //   724: aload 5
    //   726: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   729: ifne +210 -> 939
    //   732: invokestatic 2920	kxm:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   735: astore 8
    //   737: ldc_w 843
    //   740: astore 4
    //   742: aload 8
    //   744: ifnull +10 -> 754
    //   747: aload 8
    //   749: invokevirtual 2923	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   752: astore 4
    //   754: new 2241	nce$a
    //   757: dup
    //   758: aconst_null
    //   759: aconst_null
    //   760: aconst_null
    //   761: aconst_null
    //   762: invokespecial 2244	nce$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   765: aload 4
    //   767: invokevirtual 2926	nce$a:l	(Ljava/lang/String;)Lnce$a;
    //   770: aload_2
    //   771: getfield 681	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   774: invokevirtual 2928	nce$a:h	(Ljava/lang/String;)Lnce$a;
    //   777: invokevirtual 2267	nce$a:a	()Lnce;
    //   780: invokevirtual 2272	nce:toJsonString	()Ljava/lang/String;
    //   783: astore_2
    //   784: aload_1
    //   785: getfield 3012	lgf$b:pt	Landroid/widget/TextView;
    //   788: iconst_0
    //   789: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   792: aload_1
    //   793: getfield 3012	lgf$b:pt	Landroid/widget/TextView;
    //   796: fconst_2
    //   797: aload_0
    //   798: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   801: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   804: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   807: invokevirtual 2896	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   810: aload_0
    //   811: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   814: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   817: ldc_w 2929
    //   820: invokevirtual 2889	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   823: astore 4
    //   825: aload 4
    //   827: iconst_0
    //   828: iconst_0
    //   829: ldc_w 2930
    //   832: aload_0
    //   833: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   836: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   839: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   842: ldc_w 2930
    //   845: aload_0
    //   846: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   849: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   852: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   855: invokevirtual 2935	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   858: aload_1
    //   859: getfield 3012	lgf$b:pt	Landroid/widget/TextView;
    //   862: aconst_null
    //   863: aconst_null
    //   864: aload 4
    //   866: aconst_null
    //   867: invokevirtual 2938	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   870: aload_0
    //   871: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   874: aload_1
    //   875: getfield 3012	lgf$b:pt	Landroid/widget/TextView;
    //   878: aload 6
    //   880: aload 7
    //   882: aload 5
    //   884: new 3014	neh
    //   887: dup
    //   888: aload_0
    //   889: aload_2
    //   890: aload_1
    //   891: invokespecial 3017	neh:<init>	(Lndi;Ljava/lang/String;Llgf$b;)V
    //   894: invokestatic 2946	muj:a	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   897: aload_1
    //   898: getfield 3007	lgf$b:kr	Landroid/view/View;
    //   901: ldc_w 2947
    //   904: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   907: aload_0
    //   908: iconst_1
    //   909: putfield 2909	ndi:ary	Z
    //   912: aconst_null
    //   913: ldc_w 843
    //   916: ldc_w 2949
    //   919: ldc_w 2949
    //   922: iconst_0
    //   923: iconst_0
    //   924: ldc_w 843
    //   927: ldc_w 843
    //   930: ldc_w 843
    //   933: aload_2
    //   934: iconst_0
    //   935: invokestatic 1259	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   938: return
    //   939: aload_1
    //   940: getfield 3012	lgf$b:pt	Landroid/widget/TextView;
    //   943: bipush 8
    //   945: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   948: aload_1
    //   949: getfield 3007	lgf$b:kr	Landroid/view/View;
    //   952: iconst_0
    //   953: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   956: invokestatic 919	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   959: ifeq -955 -> 4
    //   962: ldc_w 921
    //   965: iconst_2
    //   966: ldc_w 2951
    //   969: invokestatic 927	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   972: return
    //   973: aload_1
    //   974: getfield 3012	lgf$b:pt	Landroid/widget/TextView;
    //   977: bipush 8
    //   979: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   982: aload_1
    //   983: getfield 3007	lgf$b:kr	Landroid/view/View;
    //   986: iconst_0
    //   987: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   990: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	991	0	this	ndi
    //   0	991	1	paramb	lgf.b
    //   0	991	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	991	3	paramInt	int
    //   39	471	4	localObject1	Object
    //   526	1	4	localMalformedURLException	MalformedURLException
    //   571	3	4	localException	Exception
    //   622	243	4	localObject2	Object
    //   304	579	5	localObject3	Object
    //   717	162	6	str1	String
    //   722	159	7	str2	String
    //   735	13	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   81	131	526	java/net/MalformedURLException
    //   131	148	526	java/net/MalformedURLException
    //   158	189	571	java/lang/Exception
  }
  
  public void a(lgf.c paramc)
  {
    this.jdField_a_of_type_Mye.stop(2);
    this.jdField_a_of_type_Lgf$c = paramc;
    this.jdField_k_of_type_Mye$b = paramc.a();
    this.jdField_a_of_type_Mye.a(this.jdField_k_of_type_Mye$b);
  }
  
  /* Error */
  public void a(lgf.d paramd, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: getfield 3026	lgf$d:pA	Landroid/widget/TextView;
    //   9: invokevirtual 2816	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   12: iconst_1
    //   13: invokevirtual 2821	android/text/TextPaint:setFakeBoldText	(Z)V
    //   16: aload_2
    //   17: getfield 1624	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   20: ifnull +248 -> 268
    //   23: aload_2
    //   24: getfield 1624	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   27: astore 5
    //   29: aload 5
    //   31: getfield 3029	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:aTl	I
    //   34: iconst_1
    //   35: if_icmpne +535 -> 570
    //   38: aload_1
    //   39: getfield 3031	lgf$d:l	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   42: invokevirtual 1394	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   45: astore 4
    //   47: aload 4
    //   49: aload_0
    //   50: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   53: ldc_w 3032
    //   56: invokestatic 1077	aqcx:dip2px	(Landroid/content/Context;F)I
    //   59: putfield 1411	android/view/ViewGroup$LayoutParams:height	I
    //   62: aload_1
    //   63: getfield 3031	lgf$d:l	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   66: aload 4
    //   68: invokevirtual 1423	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   71: aload 5
    //   73: getfield 3035	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:aiP	Ljava/lang/String;
    //   76: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +527 -> 606
    //   82: aload_0
    //   83: aload_1
    //   84: getfield 3031	lgf$d:l	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   87: new 1091	java/net/URL
    //   90: dup
    //   91: aload 5
    //   93: getfield 3035	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:aiP	Ljava/lang/String;
    //   96: invokespecial 1319	java/net/URL:<init>	(Ljava/lang/String;)V
    //   99: invokespecial 3037	ndi:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   102: aload 5
    //   104: getfield 3040	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:aiQ	Ljava/lang/String;
    //   107: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +539 -> 649
    //   113: aload 5
    //   115: getfield 3040	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:aiQ	Ljava/lang/String;
    //   118: invokestatic 3043	kwz:g	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   121: astore 4
    //   123: aload_1
    //   124: getfield 3047	lgf$d:aU	Landroid/view/ViewGroup;
    //   127: aload 4
    //   129: invokevirtual 3052	android/view/ViewGroup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   132: aload_0
    //   133: aload_1
    //   134: getfield 3054	lgf$d:m	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   137: new 1091	java/net/URL
    //   140: dup
    //   141: aload 5
    //   143: getfield 3057	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:ahk	Ljava/lang/String;
    //   146: invokespecial 1319	java/net/URL:<init>	(Ljava/lang/String;)V
    //   149: invokespecial 3037	ndi:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   152: aload_1
    //   153: getfield 3026	lgf$d:pA	Landroid/widget/TextView;
    //   156: aload 5
    //   158: getfield 2797	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:columnName	Ljava/lang/String;
    //   161: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   164: aload 5
    //   166: getfield 3058	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:amw	Z
    //   169: ifeq +545 -> 714
    //   172: aload_1
    //   173: getfield 3061	lgf$d:pC	Landroid/widget/TextView;
    //   176: bipush 8
    //   178: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   181: aload_1
    //   182: getfield 3064	lgf$d:pD	Landroid/widget/TextView;
    //   185: aload 5
    //   187: getfield 3067	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:appName	Ljava/lang/String;
    //   190: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   193: aload_1
    //   194: getfield 3070	lgf$d:c	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   197: aload_0
    //   198: invokevirtual 1734	ndi:getActivity	()Landroid/app/Activity;
    //   201: fconst_2
    //   202: invokestatic 1077	aqcx:dip2px	(Landroid/content/Context;F)I
    //   205: invokevirtual 3075	com/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView:setCorner	(I)V
    //   208: aload_0
    //   209: aload_1
    //   210: getfield 3070	lgf$d:c	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   213: new 1091	java/net/URL
    //   216: dup
    //   217: aload 5
    //   219: getfield 3078	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:appIconUrl	Ljava/lang/String;
    //   222: invokespecial 1319	java/net/URL:<init>	(Ljava/lang/String;)V
    //   225: invokespecial 3037	ndi:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;)V
    //   228: aload_1
    //   229: getfield 3082	lgf$d:fa	Landroid/widget/RelativeLayout;
    //   232: aload_1
    //   233: invokevirtual 3085	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   236: aload_1
    //   237: getfield 3061	lgf$d:pC	Landroid/widget/TextView;
    //   240: aload_1
    //   241: invokevirtual 1551	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   244: aload_1
    //   245: getfield 3088	lgf$d:aV	Landroid/view/ViewGroup;
    //   248: aload_1
    //   249: invokevirtual 3089	android/view/ViewGroup:setTag	(Ljava/lang/Object;)V
    //   252: aload_1
    //   253: getfield 3070	lgf$d:c	Lcom/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView;
    //   256: aload_1
    //   257: invokevirtual 3090	com/tencent/biz/pubaccount/readinjoy/view/KanDianUrlRoundCornerImageView:setTag	(Ljava/lang/Object;)V
    //   260: aload_1
    //   261: getfield 3064	lgf$d:pD	Landroid/widget/TextView;
    //   264: aload_1
    //   265: invokevirtual 1551	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   268: aload_1
    //   269: getfield 3091	lgf$d:iU	Landroid/widget/ImageView;
    //   272: aload_1
    //   273: invokevirtual 1552	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   276: aload_1
    //   277: getfield 3091	lgf$d:iU	Landroid/widget/ImageView;
    //   280: aload_0
    //   281: invokevirtual 1539	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   284: aload_2
    //   285: invokestatic 1555	ndi:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lmye$b;
    //   288: astore 4
    //   290: aload 4
    //   292: aload_1
    //   293: getfield 3092	lgf$d:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   296: putfield 1562	mye$b:ma	Landroid/view/View;
    //   299: aload 4
    //   301: aload_1
    //   302: getfield 3093	lgf$d:position	I
    //   305: putfield 465	mye$b:position	I
    //   308: aload 4
    //   310: aload_2
    //   311: putfield 1046	mye$b:d	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   314: aload_1
    //   315: aload 4
    //   317: putfield 3094	lgf$d:jdField_a_of_type_Mye$b	Lmye$b;
    //   320: aload_1
    //   321: getfield 3095	lgf$d:pp	Landroid/widget/TextView;
    //   324: aload_2
    //   325: getfield 790	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   328: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   331: aload_1
    //   332: getfield 3095	lgf$d:pp	Landroid/widget/TextView;
    //   335: invokevirtual 2816	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   338: iconst_1
    //   339: invokevirtual 2821	android/text/TextPaint:setFakeBoldText	(Z)V
    //   342: aload_1
    //   343: getfield 3095	lgf$d:pp	Landroid/widget/TextView;
    //   346: aload_0
    //   347: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   350: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   353: ldc_w 2822
    //   356: invokevirtual 2827	android/content/res/Resources:getColor	(I)I
    //   359: invokevirtual 2806	android/widget/TextView:setTextColor	(I)V
    //   362: aload_2
    //   363: getfield 838	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   366: ifne +359 -> 725
    //   369: aload_1
    //   370: getfield 3096	lgf$d:pw	Landroid/widget/TextView;
    //   373: bipush 8
    //   375: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   378: aload_1
    //   379: getfield 3097	lgf$d:pr	Landroid/widget/TextView;
    //   382: aload 4
    //   384: getfield 553	mye$b:videoDuration	I
    //   387: invokestatic 2836	kwz:ba	(I)Ljava/lang/String;
    //   390: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   393: aload_0
    //   394: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   397: aload_1
    //   398: getfield 3092	lgf$d:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   401: aload_1
    //   402: getfield 3094	lgf$d:jdField_a_of_type_Mye$b	Lmye$b;
    //   405: invokestatic 2847	lgf:a	(Landroid/content/Context;Landroid/widget/ImageView;Lmye$b;)V
    //   408: aload_0
    //   409: aload_1
    //   410: getfield 3092	lgf$d:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   413: aload_2
    //   414: iconst_0
    //   415: invokevirtual 968	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   418: iconst_0
    //   419: invokespecial 1392	ndi:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   422: aload_1
    //   423: getfield 3092	lgf$d:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   426: aload_0
    //   427: invokevirtual 2851	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   430: aload_1
    //   431: getfield 3092	lgf$d:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   434: aload_1
    //   435: invokevirtual 3098	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   438: aload_1
    //   439: getfield 3097	lgf$d:pr	Landroid/widget/TextView;
    //   442: iconst_0
    //   443: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   446: aload_1
    //   447: getfield 3097	lgf$d:pr	Landroid/widget/TextView;
    //   450: invokevirtual 3002	android/widget/TextView:clearAnimation	()V
    //   453: aload_1
    //   454: getfield 3099	lgf$d:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   457: fconst_1
    //   458: aload 4
    //   460: getfield 739	mye$b:videoWidth	I
    //   463: aload 4
    //   465: getfield 744	mye$b:videoHeight	I
    //   468: invokestatic 2857	kwz:c	(II)F
    //   471: invokevirtual 2863	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   474: aload_1
    //   475: getfield 3099	lgf$d:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   478: aload_1
    //   479: invokevirtual 2864	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   482: aload_0
    //   483: aload_0
    //   484: getfield 197	ndi:mChannelID	I
    //   487: aload_2
    //   488: getfield 394	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   491: invokevirtual 2866	ndi:n	(IJ)Z
    //   494: ifeq +23 -> 517
    //   497: aload_1
    //   498: getfield 3100	lgf$d:itemView	Landroid/view/View;
    //   501: aload_0
    //   502: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   505: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   508: ldc_w 2870
    //   511: invokevirtual 2827	android/content/res/Resources:getColor	(I)I
    //   514: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   517: aload_2
    //   518: getfield 584	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   521: lconst_0
    //   522: lcmp
    //   523: ifgt +3 -> 526
    //   526: aload_0
    //   527: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   530: invokestatic 1190	aqiw:isWifiConnected	(Landroid/content/Context;)Z
    //   533: ifeq +203 -> 736
    //   536: aload_1
    //   537: getfield 3101	lgf$d:iT	Landroid/widget/ImageView;
    //   540: iconst_0
    //   541: invokevirtual 1360	android/widget/ImageView:setVisibility	(I)V
    //   544: aload_1
    //   545: getfield 3102	lgf$d:ps	Landroid/widget/TextView;
    //   548: bipush 8
    //   550: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   553: aload_1
    //   554: getfield 3103	lgf$d:ks	Landroid/view/View;
    //   557: iconst_0
    //   558: invokevirtual 1304	android/view/View:setVisibility	(I)V
    //   561: aload_1
    //   562: getfield 3104	lgf$d:kr	Landroid/view/View;
    //   565: iconst_0
    //   566: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   569: return
    //   570: aload_1
    //   571: getfield 3031	lgf$d:l	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   574: invokevirtual 1394	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   577: astore 4
    //   579: aload 4
    //   581: aload_0
    //   582: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   585: ldc_w 3105
    //   588: invokestatic 1077	aqcx:dip2px	(Landroid/content/Context;F)I
    //   591: putfield 1411	android/view/ViewGroup$LayoutParams:height	I
    //   594: aload_1
    //   595: getfield 3031	lgf$d:l	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   598: aload 4
    //   600: invokevirtual 1423	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   603: goto -532 -> 71
    //   606: aload_1
    //   607: getfield 3031	lgf$d:l	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   610: new 1921	android/graphics/drawable/ColorDrawable
    //   613: dup
    //   614: ldc_w 3106
    //   617: invokespecial 1923	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   620: invokevirtual 3107	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   623: goto -521 -> 102
    //   626: astore 4
    //   628: invokestatic 919	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   631: ifeq -529 -> 102
    //   634: ldc_w 1233
    //   637: iconst_2
    //   638: ldc_w 3109
    //   641: aload 4
    //   643: invokestatic 3112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   646: goto -544 -> 102
    //   649: new 1921	android/graphics/drawable/ColorDrawable
    //   652: dup
    //   653: ldc_w 3106
    //   656: invokespecial 1923	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   659: astore 4
    //   661: goto -538 -> 123
    //   664: astore 4
    //   666: invokestatic 919	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   669: ifeq +15 -> 684
    //   672: ldc_w 1233
    //   675: iconst_2
    //   676: ldc_w 3114
    //   679: aload 4
    //   681: invokestatic 3112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   684: aload_1
    //   685: getfield 3047	lgf$d:aU	Landroid/view/ViewGroup;
    //   688: new 1921	android/graphics/drawable/ColorDrawable
    //   691: dup
    //   692: ldc_w 3106
    //   695: invokespecial 1923	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   698: invokevirtual 3052	android/view/ViewGroup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   701: goto -569 -> 132
    //   704: astore 4
    //   706: aload 4
    //   708: invokevirtual 3115	java/net/MalformedURLException:printStackTrace	()V
    //   711: goto -559 -> 152
    //   714: aload_1
    //   715: getfield 3061	lgf$d:pC	Landroid/widget/TextView;
    //   718: iconst_0
    //   719: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   722: goto -541 -> 181
    //   725: aload_1
    //   726: getfield 3096	lgf$d:pw	Landroid/widget/TextView;
    //   729: iconst_0
    //   730: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   733: goto -355 -> 378
    //   736: aload_1
    //   737: getfield 3101	lgf$d:iT	Landroid/widget/ImageView;
    //   740: bipush 8
    //   742: invokevirtual 1360	android/widget/ImageView:setVisibility	(I)V
    //   745: aload_0
    //   746: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   749: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   752: ldc_w 2886
    //   755: invokevirtual 2889	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   758: astore 4
    //   760: aload_1
    //   761: getfield 3102	lgf$d:ps	Landroid/widget/TextView;
    //   764: aload 4
    //   766: aconst_null
    //   767: aconst_null
    //   768: aconst_null
    //   769: invokevirtual 2893	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   772: aload_1
    //   773: getfield 3102	lgf$d:ps	Landroid/widget/TextView;
    //   776: ldc_w 2545
    //   779: aload_0
    //   780: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   783: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   786: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   789: invokevirtual 2896	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   792: aload_1
    //   793: getfield 3102	lgf$d:ps	Landroid/widget/TextView;
    //   796: iconst_0
    //   797: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   800: invokestatic 2901	aqux:Mv	()I
    //   803: iconst_1
    //   804: if_icmpne +29 -> 833
    //   807: aload_1
    //   808: getfield 3116	lgf$d:pt	Landroid/widget/TextView;
    //   811: bipush 8
    //   813: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   816: aload_1
    //   817: getfield 3103	lgf$d:ks	Landroid/view/View;
    //   820: iconst_0
    //   821: invokevirtual 1304	android/view/View:setVisibility	(I)V
    //   824: aload_1
    //   825: getfield 3104	lgf$d:kr	Landroid/view/View;
    //   828: iconst_0
    //   829: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   832: return
    //   833: invokestatic 2907	awit:aMT	()Z
    //   836: ifeq +296 -> 1132
    //   839: aload_0
    //   840: getfield 2909	ndi:ary	Z
    //   843: ifne +289 -> 1132
    //   846: aload_1
    //   847: getfield 3093	lgf$d:position	I
    //   850: ifne +282 -> 1132
    //   853: invokestatic 2912	awit:Hc	()Ljava/lang/String;
    //   856: astore 5
    //   858: invokestatic 2915	awit:Hd	()Ljava/lang/String;
    //   861: astore 6
    //   863: invokestatic 2918	awit:He	()Ljava/lang/String;
    //   866: astore 7
    //   868: aload 5
    //   870: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   873: ifne +217 -> 1090
    //   876: invokestatic 2920	kxm:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   879: astore 8
    //   881: ldc_w 843
    //   884: astore 4
    //   886: aload 8
    //   888: ifnull +10 -> 898
    //   891: aload 8
    //   893: invokevirtual 2923	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   896: astore 4
    //   898: new 2241	nce$a
    //   901: dup
    //   902: aconst_null
    //   903: aconst_null
    //   904: aconst_null
    //   905: aconst_null
    //   906: invokespecial 2244	nce$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   909: aload 4
    //   911: invokevirtual 2926	nce$a:l	(Ljava/lang/String;)Lnce$a;
    //   914: aload_2
    //   915: getfield 681	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   918: invokevirtual 2928	nce$a:h	(Ljava/lang/String;)Lnce$a;
    //   921: invokevirtual 2267	nce$a:a	()Lnce;
    //   924: invokevirtual 2272	nce:toJsonString	()Ljava/lang/String;
    //   927: astore_2
    //   928: aload_1
    //   929: getfield 3116	lgf$d:pt	Landroid/widget/TextView;
    //   932: iconst_0
    //   933: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   936: aload_1
    //   937: getfield 3116	lgf$d:pt	Landroid/widget/TextView;
    //   940: fconst_2
    //   941: aload_0
    //   942: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   945: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   948: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   951: invokevirtual 2896	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   954: aload_0
    //   955: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   958: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   961: ldc_w 2929
    //   964: invokevirtual 2889	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   967: astore 4
    //   969: aload 4
    //   971: iconst_0
    //   972: iconst_0
    //   973: ldc_w 2930
    //   976: aload_0
    //   977: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   980: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   983: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   986: ldc_w 2930
    //   989: aload_0
    //   990: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   993: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   996: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   999: invokevirtual 2935	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   1002: aload_1
    //   1003: getfield 3116	lgf$d:pt	Landroid/widget/TextView;
    //   1006: aconst_null
    //   1007: aconst_null
    //   1008: aload 4
    //   1010: aconst_null
    //   1011: invokevirtual 2938	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1014: aload_0
    //   1015: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   1018: aload_1
    //   1019: getfield 3116	lgf$d:pt	Landroid/widget/TextView;
    //   1022: aload 6
    //   1024: aload 7
    //   1026: aload 5
    //   1028: new 3118	nej
    //   1031: dup
    //   1032: aload_0
    //   1033: aload_2
    //   1034: invokespecial 3121	nej:<init>	(Lndi;Ljava/lang/String;)V
    //   1037: invokestatic 2946	muj:a	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   1040: aload_1
    //   1041: getfield 3104	lgf$d:kr	Landroid/view/View;
    //   1044: ldc_w 2947
    //   1047: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   1050: aload_1
    //   1051: getfield 3103	lgf$d:ks	Landroid/view/View;
    //   1054: iconst_0
    //   1055: invokevirtual 1304	android/view/View:setVisibility	(I)V
    //   1058: aload_0
    //   1059: iconst_1
    //   1060: putfield 2909	ndi:ary	Z
    //   1063: aconst_null
    //   1064: ldc_w 843
    //   1067: ldc_w 2949
    //   1070: ldc_w 2949
    //   1073: iconst_0
    //   1074: iconst_0
    //   1075: ldc_w 843
    //   1078: ldc_w 843
    //   1081: ldc_w 843
    //   1084: aload_2
    //   1085: iconst_0
    //   1086: invokestatic 1259	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1089: return
    //   1090: aload_1
    //   1091: getfield 3116	lgf$d:pt	Landroid/widget/TextView;
    //   1094: bipush 8
    //   1096: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   1099: aload_1
    //   1100: getfield 3103	lgf$d:ks	Landroid/view/View;
    //   1103: iconst_0
    //   1104: invokevirtual 1304	android/view/View:setVisibility	(I)V
    //   1107: aload_1
    //   1108: getfield 3104	lgf$d:kr	Landroid/view/View;
    //   1111: iconst_0
    //   1112: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   1115: invokestatic 919	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1118: ifeq -1114 -> 4
    //   1121: ldc_w 921
    //   1124: iconst_2
    //   1125: ldc_w 2951
    //   1128: invokestatic 927	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1131: return
    //   1132: aload_1
    //   1133: getfield 3116	lgf$d:pt	Landroid/widget/TextView;
    //   1136: bipush 8
    //   1138: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   1141: aload_1
    //   1142: getfield 3103	lgf$d:ks	Landroid/view/View;
    //   1145: iconst_0
    //   1146: invokevirtual 1304	android/view/View:setVisibility	(I)V
    //   1149: aload_1
    //   1150: getfield 3104	lgf$d:kr	Landroid/view/View;
    //   1153: iconst_0
    //   1154: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   1157: return
    //   1158: astore 4
    //   1160: goto -932 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1163	0	this	ndi
    //   0	1163	1	paramd	lgf.d
    //   0	1163	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	1163	3	paramInt	int
    //   45	554	4	localObject1	Object
    //   626	16	4	localException1	Exception
    //   659	1	4	localColorDrawable	ColorDrawable
    //   664	16	4	localException2	Exception
    //   704	3	4	localMalformedURLException	MalformedURLException
    //   758	251	4	localObject2	Object
    //   1158	1	4	localException3	Exception
    //   27	1000	5	localObject3	Object
    //   861	162	6	str1	String
    //   866	159	7	str2	String
    //   879	13	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   71	102	626	java/lang/Exception
    //   606	623	626	java/lang/Exception
    //   102	123	664	java/lang/Exception
    //   123	132	664	java/lang/Exception
    //   649	661	664	java/lang/Exception
    //   132	152	704	java/net/MalformedURLException
    //   193	228	1158	java/lang/Exception
  }
  
  public void a(lgf.e parame, BaseArticleInfo paramBaseArticleInfo)
  {
    parame.itemView.setOnClickListener(null);
    parame.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    parame.jdField_f_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    parame.rootView.setBackgroundColor(this.mContext.getResources().getColor(2131167654));
    g(parame.aW, parame.aX);
    paramBaseArticleInfo = parame.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    a(paramBaseArticleInfo, parame.pG, parame.ku, parame.pE, parame.n, parame.itemView);
    a(parame.a);
    parame.pG.setText(paramBaseArticleInfo.mTitle);
    parame.pG.getPaint().setFakeBoldText(true);
    parame.pH.setText(muj.bw(paramBaseArticleInfo.mVideoPlayCount));
    a(parame.p, parame.iV, paramBaseArticleInfo, false);
    parame.p.setTag(parame);
    parame.p.setOnClickListener(this);
    VideoReport.setElementId(parame.p, "card");
    VideoReport.setElementParams(parame.p, new lal().a(this.mChannelID).a(paramBaseArticleInfo.innerUniqueID).build());
    VideoReport.setElementReuseIdentifier(parame.p, paramBaseArticleInfo.innerUniqueID);
    parame.n.setTag(paramBaseArticleInfo);
    muj.a(paramBaseArticleInfo.mVideoArticleSubsText, paramBaseArticleInfo.mVideoArticleSubsColor, parame.pI);
    long l1;
    if ((paramBaseArticleInfo.isAccountShown) && (this.mChannelID == 0) && (paramBaseArticleInfo.mPartnerAccountInfo != null))
    {
      parame.kw.setVisibility(0);
      parame.kw.setTag(paramBaseArticleInfo);
      parame.kw.setTag(2131376790, parame);
      l1 = 0L;
      if (paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.has()) {
        l1 = paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
      }
      parame.g.setHeadImgByUin(l1);
      parame.g.setTag(paramBaseArticleInfo);
      parame.g.setTag(2131376790, parame);
      kxm.d(parame.g, 10, 10, 10, 10);
      paramBaseArticleInfo = kxm.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
      if (TextUtils.isEmpty(paramBaseArticleInfo)) {}
    }
    try
    {
      paramBaseArticleInfo = new URL(paramBaseArticleInfo);
      parame.q.setImage(paramBaseArticleInfo);
      label394:
      parame.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
      parame.kw.setOnClickListener(this);
      parame.g.setOnClickListener(this);
      for (;;)
      {
        paramBaseArticleInfo = parame.jdField_f_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        paramBaseArticleInfo.isTwoItem = true;
        a(paramBaseArticleInfo, parame.pJ, parame.kv, parame.pF, parame.o, parame.itemView);
        a(parame.b);
        parame.pJ.setText(paramBaseArticleInfo.mTitle);
        parame.pJ.getPaint().setFakeBoldText(true);
        parame.pK.setText(muj.bw(paramBaseArticleInfo.mVideoPlayCount));
        a(parame.r, parame.iW, paramBaseArticleInfo, false);
        parame.r.setTag(parame);
        parame.r.setOnClickListener(this);
        VideoReport.setElementId(parame.r, "card");
        VideoReport.setElementParams(parame.r, new lal().a(this.mChannelID).a(paramBaseArticleInfo.innerUniqueID).build());
        VideoReport.setElementReuseIdentifier(parame.r, paramBaseArticleInfo.innerUniqueID);
        parame.o.setTag(paramBaseArticleInfo);
        muj.a(paramBaseArticleInfo.mVideoArticleSubsText, paramBaseArticleInfo.mVideoArticleSubsColor, parame.pL);
        if ((paramBaseArticleInfo.isAccountShown) && (this.mChannelID == 0) && (paramBaseArticleInfo.mPartnerAccountInfo != null))
        {
          parame.kx.setVisibility(0);
          parame.kx.setTag(paramBaseArticleInfo);
          parame.kx.setTag(2131376790, parame);
          long l2 = 0L;
          l1 = l2;
          if (paramBaseArticleInfo.mPartnerAccountInfo != null)
          {
            l1 = l2;
            if (paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.has()) {
              l1 = paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
            }
          }
          parame.h.setHeadImgByUin(l1);
          parame.h.setTag(paramBaseArticleInfo);
          parame.h.setTag(2131376790, parame);
          kxm.d(parame.h, 10, 10, 10, 10);
          paramBaseArticleInfo = kxm.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
          if (TextUtils.isEmpty(paramBaseArticleInfo)) {}
        }
        try
        {
          paramBaseArticleInfo = new URL(paramBaseArticleInfo);
          parame.s.setImage(paramBaseArticleInfo);
          label769:
          parame.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
          parame.kx.setOnClickListener(this);
          parame.h.setOnClickListener(this);
          return;
          parame.kw.setVisibility(8);
          continue;
          parame.kx.setVisibility(8);
          return;
        }
        catch (Exception paramBaseArticleInfo)
        {
          break label769;
        }
      }
    }
    catch (Exception paramBaseArticleInfo)
    {
      break label394;
    }
  }
  
  /* Error */
  public void a(lgf.f paramf, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: aload_2
    //   7: invokestatic 3269	ndi:a	(Llgf$f;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   10: aload_1
    //   11: getfield 1565	lgf$f:jdField_a_of_type_Mye$b	Lmye$b;
    //   14: astore 5
    //   16: aload_1
    //   17: getfield 3270	lgf$f:pp	Landroid/widget/TextView;
    //   20: aload_2
    //   21: getfield 790	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   24: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   27: aload_1
    //   28: getfield 3270	lgf$f:pp	Landroid/widget/TextView;
    //   31: invokevirtual 2816	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   34: iconst_1
    //   35: invokevirtual 2821	android/text/TextPaint:setFakeBoldText	(Z)V
    //   38: aload_1
    //   39: getfield 3270	lgf$f:pp	Landroid/widget/TextView;
    //   42: aload_0
    //   43: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   46: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   49: ldc_w 2822
    //   52: invokevirtual 2827	android/content/res/Resources:getColor	(I)I
    //   55: invokevirtual 2806	android/widget/TextView:setTextColor	(I)V
    //   58: aload_2
    //   59: getfield 838	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   62: ifne +712 -> 774
    //   65: aload_1
    //   66: getfield 3271	lgf$f:pq	Landroid/widget/TextView;
    //   69: bipush 8
    //   71: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   74: aload_1
    //   75: getfield 3272	lgf$f:pr	Landroid/widget/TextView;
    //   78: aload 5
    //   80: getfield 553	mye$b:videoDuration	I
    //   83: invokestatic 2836	kwz:ba	(I)Ljava/lang/String;
    //   86: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   89: aload_0
    //   90: aload_1
    //   91: getfield 3274	lgf$f:g	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   94: aload_2
    //   95: aload_2
    //   96: invokestatic 1445	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   99: invokespecial 3276	ndi:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Z)V
    //   102: aload_0
    //   103: aload_1
    //   104: getfield 3278	lgf$f:i	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   107: aload_2
    //   108: invokespecial 3280	ndi:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   111: aload_1
    //   112: getfield 3278	lgf$f:i	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   115: aload_2
    //   116: invokevirtual 1521	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getSubscribeName	()Ljava/lang/String;
    //   119: invokevirtual 3283	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   122: aload_1
    //   123: getfield 3274	lgf$f:g	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   126: iconst_0
    //   127: invokevirtual 3284	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setVisibility	(I)V
    //   130: aload_1
    //   131: getfield 3274	lgf$f:g	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   134: aload_2
    //   135: invokevirtual 1521	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getSubscribeName	()Ljava/lang/String;
    //   138: invokevirtual 3285	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   141: aload_1
    //   142: getfield 3288	lgf$f:aY	Landroid/view/ViewGroup;
    //   145: aload_2
    //   146: invokevirtual 3089	android/view/ViewGroup:setTag	(Ljava/lang/Object;)V
    //   149: aload_1
    //   150: getfield 3288	lgf$f:aY	Landroid/view/ViewGroup;
    //   153: ldc_w 3190
    //   156: aload_1
    //   157: invokevirtual 3289	android/view/ViewGroup:setTag	(ILjava/lang/Object;)V
    //   160: aload_1
    //   161: getfield 3288	lgf$f:aY	Landroid/view/ViewGroup;
    //   164: aload_0
    //   165: invokevirtual 3290	android/view/ViewGroup:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   168: aload_2
    //   169: getfield 2976	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   172: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   175: ifne +620 -> 795
    //   178: new 1091	java/net/URL
    //   181: dup
    //   182: aload_2
    //   183: getfield 2976	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   186: invokespecial 1319	java/net/URL:<init>	(Ljava/lang/String;)V
    //   189: astore 6
    //   191: aload_1
    //   192: getfield 3291	lgf$f:k	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   195: aload 6
    //   197: invokevirtual 2794	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   200: pop
    //   201: aload_1
    //   202: getfield 3291	lgf$f:k	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   205: iconst_0
    //   206: invokevirtual 1343	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   209: aload_2
    //   210: invokestatic 1445	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   213: ifeq +686 -> 899
    //   216: aload_2
    //   217: checkcast 1442	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   220: astore 6
    //   222: aload_1
    //   223: getfield 1547	lgf$f:pO	Landroid/widget/TextView;
    //   226: iconst_0
    //   227: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   230: invokestatic 1060	kxm:AY	()Z
    //   233: ifeq +574 -> 807
    //   236: aload_1
    //   237: getfield 1547	lgf$f:pO	Landroid/widget/TextView;
    //   240: aconst_null
    //   241: invokestatic 3297	kvl:setBackground	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   244: aload_1
    //   245: getfield 1547	lgf$f:pO	Landroid/widget/TextView;
    //   248: ldc_w 3299
    //   251: invokestatic 186	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   254: invokevirtual 2806	android/widget/TextView:setTextColor	(I)V
    //   257: aload_1
    //   258: getfield 1543	lgf$f:pP	Landroid/widget/TextView;
    //   261: ldc_w 3301
    //   264: invokestatic 186	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   267: invokevirtual 2806	android/widget/TextView:setTextColor	(I)V
    //   270: aload_2
    //   271: getfield 2955	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   274: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   277: ifne +553 -> 830
    //   280: aload_1
    //   281: getfield 1547	lgf$f:pO	Landroid/widget/TextView;
    //   284: aload_2
    //   285: getfield 2955	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   288: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   291: aload_1
    //   292: getfield 3305	lgf$f:dJ	Landroid/widget/LinearLayout;
    //   295: iconst_0
    //   296: invokevirtual 3308	android/widget/LinearLayout:setVisibility	(I)V
    //   299: aload_2
    //   300: invokestatic 1468	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   303: ifeq +547 -> 850
    //   306: iconst_0
    //   307: istore_3
    //   308: new 1100	org/json/JSONObject
    //   311: dup
    //   312: aload 6
    //   314: getfield 1471	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   317: invokespecial 1472	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   320: astore 7
    //   322: aload_0
    //   323: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   326: aload 7
    //   328: ldc_w 3310
    //   331: invokevirtual 3313	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   334: invokestatic 3319	aqiz:isAppInstalled	(Landroid/content/Context;Ljava/lang/String;)Z
    //   337: istore 4
    //   339: iload 4
    //   341: ifeq +5 -> 346
    //   344: iconst_1
    //   345: istore_3
    //   346: aload 6
    //   348: getfield 3322	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   351: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   354: ifne +19 -> 373
    //   357: iload_3
    //   358: ifne +15 -> 373
    //   361: aload_1
    //   362: getfield 1543	lgf$f:pP	Landroid/widget/TextView;
    //   365: aload 6
    //   367: getfield 3322	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   370: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   373: new 1100	org/json/JSONObject
    //   376: dup
    //   377: aload 6
    //   379: getfield 3325	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   382: invokespecial 1472	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   385: astore 6
    //   387: aload 6
    //   389: ldc_w 3327
    //   392: invokevirtual 3313	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   395: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   398: ifne +18 -> 416
    //   401: aload_1
    //   402: getfield 1547	lgf$f:pO	Landroid/widget/TextView;
    //   405: aload 6
    //   407: ldc_w 3327
    //   410: invokevirtual 3313	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   413: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   416: aload_0
    //   417: aload_1
    //   418: invokespecial 3329	ndi:a	(Llgf$f;)V
    //   421: aload_1
    //   422: getfield 3332	lgf$f:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   425: bipush 8
    //   427: invokevirtual 3335	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   430: aload_1
    //   431: getfield 3338	lgf$f:dI	Landroid/widget/LinearLayout;
    //   434: bipush 8
    //   436: invokevirtual 3308	android/widget/LinearLayout:setVisibility	(I)V
    //   439: aload_0
    //   440: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   443: aload_1
    //   444: getfield 1558	lgf$f:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   447: aload_1
    //   448: getfield 1565	lgf$f:jdField_a_of_type_Mye$b	Lmye$b;
    //   451: invokestatic 2847	lgf:a	(Landroid/content/Context;Landroid/widget/ImageView;Lmye$b;)V
    //   454: aload_0
    //   455: aload_1
    //   456: getfield 1558	lgf$f:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   459: aload_2
    //   460: iconst_0
    //   461: invokevirtual 968	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   464: iconst_0
    //   465: invokespecial 1392	ndi:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   468: aload_1
    //   469: getfield 1558	lgf$f:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   472: aload_0
    //   473: invokevirtual 1342	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   476: aload_1
    //   477: getfield 1558	lgf$f:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   480: aload_0
    //   481: invokevirtual 2851	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   484: aload_1
    //   485: getfield 1558	lgf$f:h	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   488: aload_1
    //   489: invokevirtual 3098	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   492: aload_1
    //   493: getfield 3272	lgf$f:pr	Landroid/widget/TextView;
    //   496: iconst_0
    //   497: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   500: aload_1
    //   501: getfield 3272	lgf$f:pr	Landroid/widget/TextView;
    //   504: invokevirtual 3002	android/widget/TextView:clearAnimation	()V
    //   507: aload_1
    //   508: getfield 3339	lgf$f:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   511: fconst_1
    //   512: aload 5
    //   514: getfield 739	mye$b:videoWidth	I
    //   517: aload 5
    //   519: getfield 744	mye$b:videoHeight	I
    //   522: invokestatic 2857	kwz:c	(II)F
    //   525: invokevirtual 2863	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   528: aload_1
    //   529: getfield 3339	lgf$f:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   532: aload_0
    //   533: invokevirtual 3340	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   536: aload_1
    //   537: getfield 3339	lgf$f:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   540: aload_1
    //   541: invokevirtual 2864	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   544: aload_0
    //   545: aload_0
    //   546: getfield 197	ndi:mChannelID	I
    //   549: aload_2
    //   550: getfield 394	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   553: invokevirtual 2866	ndi:n	(IJ)Z
    //   556: ifeq +23 -> 579
    //   559: aload_1
    //   560: getfield 3341	lgf$f:itemView	Landroid/view/View;
    //   563: aload_0
    //   564: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   567: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   570: ldc_w 2870
    //   573: invokevirtual 2827	android/content/res/Resources:getColor	(I)I
    //   576: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   579: aload_0
    //   580: invokevirtual 1734	ndi:getActivity	()Landroid/app/Activity;
    //   583: aload_1
    //   584: getfield 3344	lgf$f:aZ	Landroid/view/ViewGroup;
    //   587: aload_1
    //   588: getfield 3346	lgf$f:c	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   591: invokestatic 3349	kxr:a	(Landroid/content/Context;Landroid/view/View;Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;)V
    //   594: invokestatic 1060	kxm:AY	()Z
    //   597: ifeq +396 -> 993
    //   600: aload_1
    //   601: getfield 3352	lgf$f:pM	Landroid/widget/TextView;
    //   604: aload_0
    //   605: invokevirtual 1734	ndi:getActivity	()Landroid/app/Activity;
    //   608: ldc_w 1288
    //   611: invokestatic 1077	aqcx:dip2px	(Landroid/content/Context;F)I
    //   614: invokevirtual 2896	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   617: aload_0
    //   618: invokevirtual 1734	ndi:getActivity	()Landroid/app/Activity;
    //   621: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   624: ldc_w 3353
    //   627: invokevirtual 2889	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   630: astore 5
    //   632: aload_0
    //   633: invokevirtual 1734	ndi:getActivity	()Landroid/app/Activity;
    //   636: ldc_w 3354
    //   639: invokestatic 1077	aqcx:dip2px	(Landroid/content/Context;F)I
    //   642: istore_3
    //   643: aload 5
    //   645: iconst_0
    //   646: iconst_0
    //   647: iload_3
    //   648: iload_3
    //   649: invokevirtual 2935	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   652: aload_1
    //   653: getfield 3352	lgf$f:pM	Landroid/widget/TextView;
    //   656: aload 5
    //   658: aconst_null
    //   659: aconst_null
    //   660: aconst_null
    //   661: invokevirtual 2938	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   664: aload_1
    //   665: getfield 3346	lgf$f:c	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   668: aload_0
    //   669: invokevirtual 3355	com/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   672: aload_1
    //   673: getfield 3346	lgf$f:c	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   676: aload_1
    //   677: invokevirtual 3356	com/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout:setTag	(Ljava/lang/Object;)V
    //   680: aload_1
    //   681: getfield 3352	lgf$f:pM	Landroid/widget/TextView;
    //   684: aload_0
    //   685: invokevirtual 1544	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   688: aload_1
    //   689: getfield 3352	lgf$f:pM	Landroid/widget/TextView;
    //   692: aload_1
    //   693: invokevirtual 1551	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   696: aload_1
    //   697: getfield 3359	lgf$f:fb	Landroid/widget/RelativeLayout;
    //   700: aload_0
    //   701: invokevirtual 3360	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   704: aload_1
    //   705: getfield 3359	lgf$f:fb	Landroid/widget/RelativeLayout;
    //   708: aload_1
    //   709: invokevirtual 3085	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   712: aload_2
    //   713: getfield 584	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   716: lconst_0
    //   717: lcmp
    //   718: ifgt +3 -> 721
    //   721: aload_0
    //   722: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   725: invokestatic 1190	aqiw:isWifiConnected	(Landroid/content/Context;)Z
    //   728: ifeq +310 -> 1038
    //   731: aload_1
    //   732: getfield 3361	lgf$f:iT	Landroid/widget/ImageView;
    //   735: iconst_0
    //   736: invokevirtual 1360	android/widget/ImageView:setVisibility	(I)V
    //   739: aload_1
    //   740: getfield 3362	lgf$f:ps	Landroid/widget/TextView;
    //   743: bipush 8
    //   745: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   748: aload_1
    //   749: getfield 3363	lgf$f:ks	Landroid/view/View;
    //   752: iconst_0
    //   753: invokevirtual 1304	android/view/View:setVisibility	(I)V
    //   756: aload_1
    //   757: getfield 3364	lgf$f:kr	Landroid/view/View;
    //   760: iconst_0
    //   761: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   764: aload_1
    //   765: getfield 3367	lgf$f:kz	Landroid/view/View;
    //   768: bipush 8
    //   770: invokevirtual 1304	android/view/View:setVisibility	(I)V
    //   773: return
    //   774: aload_1
    //   775: getfield 3271	lgf$f:pq	Landroid/widget/TextView;
    //   778: iconst_0
    //   779: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   782: goto -708 -> 74
    //   785: astore 6
    //   787: aload 6
    //   789: invokevirtual 2883	java/lang/Exception:printStackTrace	()V
    //   792: goto -583 -> 209
    //   795: aload_1
    //   796: getfield 3291	lgf$f:k	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   799: bipush 8
    //   801: invokevirtual 1343	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   804: goto -595 -> 209
    //   807: aload_1
    //   808: getfield 1547	lgf$f:pO	Landroid/widget/TextView;
    //   811: ldc_w 3369
    //   814: invokestatic 186	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   817: aload_0
    //   818: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   821: invokestatic 3372	knd:a	(ILandroid/content/Context;)Landroid/graphics/drawable/ShapeDrawable;
    //   824: invokestatic 3297	kvl:setBackground	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   827: goto -557 -> 270
    //   830: aload_1
    //   831: getfield 1547	lgf$f:pO	Landroid/widget/TextView;
    //   834: aload_0
    //   835: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   838: ldc_w 3373
    //   841: invokevirtual 2618	android/app/Activity:getString	(I)Ljava/lang/String;
    //   844: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   847: goto -556 -> 291
    //   850: aload 6
    //   852: getfield 3322	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   855: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   858: ifne -485 -> 373
    //   861: aload_1
    //   862: getfield 1543	lgf$f:pP	Landroid/widget/TextView;
    //   865: aload 6
    //   867: getfield 3322	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   870: invokevirtual 2785	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   873: goto -500 -> 373
    //   876: astore 6
    //   878: invokestatic 919	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   881: ifeq -465 -> 416
    //   884: ldc_w 1233
    //   887: iconst_2
    //   888: ldc_w 3375
    //   891: aload 6
    //   893: invokestatic 3112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   896: goto -480 -> 416
    //   899: aload_1
    //   900: getfield 1547	lgf$f:pO	Landroid/widget/TextView;
    //   903: bipush 8
    //   905: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   908: aload_1
    //   909: getfield 3305	lgf$f:dJ	Landroid/widget/LinearLayout;
    //   912: bipush 8
    //   914: invokevirtual 3308	android/widget/LinearLayout:setVisibility	(I)V
    //   917: aload_1
    //   918: getfield 3332	lgf$f:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   921: iconst_0
    //   922: invokevirtual 3335	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   925: aload_1
    //   926: getfield 3338	lgf$f:dI	Landroid/widget/LinearLayout;
    //   929: iconst_0
    //   930: invokevirtual 3308	android/widget/LinearLayout:setVisibility	(I)V
    //   933: aload_1
    //   934: getfield 3332	lgf$f:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   937: aload_2
    //   938: aload_0
    //   939: aload_0
    //   940: getfield 197	ndi:mChannelID	I
    //   943: aload_0
    //   944: getfield 336	ndi:ak	Ljava/util/Set;
    //   947: invokevirtual 3379	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setArticleInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Landroid/widget/BaseAdapter;ILjava/util/Set;)V
    //   950: aload_1
    //   951: getfield 3382	lgf$f:iX	Landroid/widget/ImageView;
    //   954: aload_0
    //   955: invokevirtual 1539	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   958: aload_1
    //   959: getfield 3382	lgf$f:iX	Landroid/widget/ImageView;
    //   962: aload_1
    //   963: invokevirtual 1552	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   966: aload_1
    //   967: getfield 3385	lgf$f:iY	Landroid/widget/ImageView;
    //   970: aload_0
    //   971: invokevirtual 1539	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   974: aload_1
    //   975: getfield 3385	lgf$f:iY	Landroid/widget/ImageView;
    //   978: aload_0
    //   979: invokevirtual 3386	android/widget/ImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   982: aload_1
    //   983: getfield 3385	lgf$f:iY	Landroid/widget/ImageView;
    //   986: aload_1
    //   987: invokevirtual 1552	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   990: goto -551 -> 439
    //   993: aload_1
    //   994: getfield 3352	lgf$f:pM	Landroid/widget/TextView;
    //   997: aload_0
    //   998: invokevirtual 1734	ndi:getActivity	()Landroid/app/Activity;
    //   1001: fconst_0
    //   1002: invokestatic 1077	aqcx:dip2px	(Landroid/content/Context;F)I
    //   1005: invokevirtual 2896	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1008: aload_0
    //   1009: invokevirtual 1734	ndi:getActivity	()Landroid/app/Activity;
    //   1012: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1015: ldc_w 3387
    //   1018: invokevirtual 2889	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1021: astore 5
    //   1023: aload_1
    //   1024: getfield 3352	lgf$f:pM	Landroid/widget/TextView;
    //   1027: aload 5
    //   1029: aconst_null
    //   1030: aconst_null
    //   1031: aconst_null
    //   1032: invokevirtual 2893	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1035: goto -371 -> 664
    //   1038: aload_1
    //   1039: getfield 3361	lgf$f:iT	Landroid/widget/ImageView;
    //   1042: bipush 8
    //   1044: invokevirtual 1360	android/widget/ImageView:setVisibility	(I)V
    //   1047: aload_0
    //   1048: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   1051: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1054: ldc_w 2886
    //   1057: invokevirtual 2889	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1060: astore 5
    //   1062: aload_1
    //   1063: getfield 3362	lgf$f:ps	Landroid/widget/TextView;
    //   1066: aload 5
    //   1068: aconst_null
    //   1069: aconst_null
    //   1070: aconst_null
    //   1071: invokevirtual 2893	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1074: aload_1
    //   1075: getfield 3362	lgf$f:ps	Landroid/widget/TextView;
    //   1078: ldc_w 2545
    //   1081: aload_0
    //   1082: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   1085: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1088: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   1091: invokevirtual 2896	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1094: aload_1
    //   1095: getfield 3362	lgf$f:ps	Landroid/widget/TextView;
    //   1098: iconst_0
    //   1099: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   1102: invokestatic 2901	aqux:Mv	()I
    //   1105: iconst_1
    //   1106: if_icmpne +31 -> 1137
    //   1109: aload_1
    //   1110: getfield 3388	lgf$f:pt	Landroid/widget/TextView;
    //   1113: bipush 8
    //   1115: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   1118: aload_1
    //   1119: getfield 3363	lgf$f:ks	Landroid/view/View;
    //   1122: iconst_0
    //   1123: invokevirtual 1304	android/view/View:setVisibility	(I)V
    //   1126: aload_1
    //   1127: getfield 3364	lgf$f:kr	Landroid/view/View;
    //   1130: iconst_0
    //   1131: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   1134: goto -370 -> 764
    //   1137: invokestatic 2907	awit:aMT	()Z
    //   1140: ifeq +301 -> 1441
    //   1143: aload_0
    //   1144: getfield 2909	ndi:ary	Z
    //   1147: ifne +294 -> 1441
    //   1150: aload_1
    //   1151: getfield 1563	lgf$f:position	I
    //   1154: ifne +287 -> 1441
    //   1157: invokestatic 2912	awit:Hc	()Ljava/lang/String;
    //   1160: astore 6
    //   1162: invokestatic 2915	awit:Hd	()Ljava/lang/String;
    //   1165: astore 7
    //   1167: invokestatic 2918	awit:He	()Ljava/lang/String;
    //   1170: astore 8
    //   1172: aload 6
    //   1174: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1177: ifne +220 -> 1397
    //   1180: invokestatic 2920	kxm:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1183: astore 9
    //   1185: ldc_w 843
    //   1188: astore 5
    //   1190: aload 9
    //   1192: ifnull +10 -> 1202
    //   1195: aload 9
    //   1197: invokevirtual 2923	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1200: astore 5
    //   1202: new 2241	nce$a
    //   1205: dup
    //   1206: aconst_null
    //   1207: aconst_null
    //   1208: aconst_null
    //   1209: aconst_null
    //   1210: invokespecial 2244	nce$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1213: aload 5
    //   1215: invokevirtual 2926	nce$a:l	(Ljava/lang/String;)Lnce$a;
    //   1218: aload_2
    //   1219: getfield 681	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1222: invokevirtual 2928	nce$a:h	(Ljava/lang/String;)Lnce$a;
    //   1225: invokevirtual 2267	nce$a:a	()Lnce;
    //   1228: invokevirtual 2272	nce:toJsonString	()Ljava/lang/String;
    //   1231: astore_2
    //   1232: aload_1
    //   1233: getfield 3388	lgf$f:pt	Landroid/widget/TextView;
    //   1236: iconst_0
    //   1237: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   1240: aload_1
    //   1241: getfield 3388	lgf$f:pt	Landroid/widget/TextView;
    //   1244: fconst_2
    //   1245: aload_0
    //   1246: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   1249: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1252: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   1255: invokevirtual 2896	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1258: aload_0
    //   1259: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   1262: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1265: ldc_w 2929
    //   1268: invokevirtual 2889	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1271: astore 5
    //   1273: aload 5
    //   1275: iconst_0
    //   1276: iconst_0
    //   1277: ldc_w 2930
    //   1280: aload_0
    //   1281: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   1284: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1287: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   1290: ldc_w 2930
    //   1293: aload_0
    //   1294: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   1297: invokevirtual 1291	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1300: invokestatic 493	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   1303: invokevirtual 2935	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   1306: aload_1
    //   1307: getfield 3388	lgf$f:pt	Landroid/widget/TextView;
    //   1310: aconst_null
    //   1311: aconst_null
    //   1312: aload 5
    //   1314: aconst_null
    //   1315: invokevirtual 2938	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1318: aload_0
    //   1319: getfield 302	ndi:mContext	Landroid/app/Activity;
    //   1322: aload_1
    //   1323: getfield 3388	lgf$f:pt	Landroid/widget/TextView;
    //   1326: aload 7
    //   1328: aload 8
    //   1330: aload 6
    //   1332: new 3390	neg
    //   1335: dup
    //   1336: aload_0
    //   1337: aload_2
    //   1338: aload_1
    //   1339: invokespecial 3393	neg:<init>	(Lndi;Ljava/lang/String;Llgf$f;)V
    //   1342: invokestatic 2946	muj:a	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   1345: aload_1
    //   1346: getfield 3364	lgf$f:kr	Landroid/view/View;
    //   1349: ldc_w 2947
    //   1352: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   1355: aload_1
    //   1356: getfield 3363	lgf$f:ks	Landroid/view/View;
    //   1359: iconst_0
    //   1360: invokevirtual 1304	android/view/View:setVisibility	(I)V
    //   1363: aload_0
    //   1364: iconst_1
    //   1365: putfield 2909	ndi:ary	Z
    //   1368: aconst_null
    //   1369: ldc_w 843
    //   1372: ldc_w 2949
    //   1375: ldc_w 2949
    //   1378: iconst_0
    //   1379: iconst_0
    //   1380: ldc_w 843
    //   1383: ldc_w 843
    //   1386: ldc_w 843
    //   1389: aload_2
    //   1390: iconst_0
    //   1391: invokestatic 1259	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1394: goto -630 -> 764
    //   1397: aload_1
    //   1398: getfield 3388	lgf$f:pt	Landroid/widget/TextView;
    //   1401: bipush 8
    //   1403: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   1406: aload_1
    //   1407: getfield 3363	lgf$f:ks	Landroid/view/View;
    //   1410: iconst_0
    //   1411: invokevirtual 1304	android/view/View:setVisibility	(I)V
    //   1414: aload_1
    //   1415: getfield 3364	lgf$f:kr	Landroid/view/View;
    //   1418: iconst_0
    //   1419: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   1422: invokestatic 919	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1425: ifeq -661 -> 764
    //   1428: ldc_w 921
    //   1431: iconst_2
    //   1432: ldc_w 2951
    //   1435: invokestatic 927	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1438: goto -674 -> 764
    //   1441: aload_1
    //   1442: getfield 3388	lgf$f:pt	Landroid/widget/TextView;
    //   1445: bipush 8
    //   1447: invokevirtual 1344	android/widget/TextView:setVisibility	(I)V
    //   1450: aload_1
    //   1451: getfield 3363	lgf$f:ks	Landroid/view/View;
    //   1454: iconst_0
    //   1455: invokevirtual 1304	android/view/View:setVisibility	(I)V
    //   1458: aload_1
    //   1459: getfield 3364	lgf$f:kr	Landroid/view/View;
    //   1462: iconst_0
    //   1463: invokevirtual 2873	android/view/View:setBackgroundColor	(I)V
    //   1466: goto -702 -> 764
    //   1469: astore 7
    //   1471: goto -1125 -> 346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1474	0	this	ndi
    //   0	1474	1	paramf	lgf.f
    //   0	1474	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	1474	3	paramInt	int
    //   337	3	4	bool	boolean
    //   14	1299	5	localObject1	Object
    //   189	217	6	localObject2	Object
    //   785	81	6	localException	Exception
    //   876	16	6	localJSONException1	JSONException
    //   1160	171	6	str1	String
    //   320	1007	7	localObject3	Object
    //   1469	1	7	localJSONException2	JSONException
    //   1170	159	8	str2	String
    //   1183	13	9	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   178	209	785	java/lang/Exception
    //   373	416	876	org/json/JSONException
    //   308	339	1469	org/json/JSONException
  }
  
  public void a(lgf.j paramj, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    paramj.itemView.setOnClickListener(null);
    paramj.itemView.setOnLongClickListener(this);
    paramj.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramj.jdField_f_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    BaseArticleInfo localBaseArticleInfo = paramj.jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    paramj.pG.setText(localBaseArticleInfo.mTitle);
    paramj.pG.getPaint().setFakeBoldText(true);
    paramj.pH.setText(muj.bw(localBaseArticleInfo.mVideoPlayCount));
    paramBaseArticleInfo = this.mContext.getResources().getDrawable(2130843984);
    paramInt = aqnm.dpToPx(8.0F);
    paramBaseArticleInfo.setBounds(0, 0, paramInt, paramInt);
    paramj.pH.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    paramj.pH.setCompoundDrawablePadding(aqnm.dpToPx(3.0F));
    URL localURL = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramj.p, localURL, false);
    paramj.p.setTag(paramj);
    paramj.p.setOnClickListener(this);
    paramj.p.setOnLongClickListener(this);
    muj.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramj.pI);
    localBaseArticleInfo = paramj.jdField_f_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    paramj.pJ.setText(localBaseArticleInfo.mTitle);
    paramj.pJ.getPaint().setFakeBoldText(true);
    paramj.pK.setText(muj.bw(localBaseArticleInfo.mVideoPlayCount));
    paramj.pK.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    paramj.pK.setCompoundDrawablePadding(aqnm.dpToPx(3.0F));
    paramBaseArticleInfo = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramj.r, paramBaseArticleInfo, false);
    paramj.r.setTag(paramj);
    paramj.r.setOnClickListener(this);
    paramj.r.setOnLongClickListener(this);
    muj.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramj.pL);
  }
  
  public void a(mye.b paramb, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramb, paramBaseArticleInfo, false);
  }
  
  public void a(mye.b paramb, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    a(paramb, paramBaseArticleInfo, paramBoolean, true);
  }
  
  public void a(mye.b paramb, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramb.xb + ",vid : " + paramb.videoVid + ", showComment : " + paramBoolean1);
    }
    if (this.jdField_a_of_type_Mye != null) {
      this.jdField_a_of_type_Mye.aTM();
    }
    this.arA = true;
    Bundle localBundle;
    if (kxm.B(paramBaseArticleInfo)) {
      localBundle = b(paramb, paramBaseArticleInfo);
    }
    for (;;)
    {
      int i;
      label137:
      Object localObject;
      label266:
      label275:
      Intent localIntent;
      if (this.jdField_a_of_type_Mye != null)
      {
        if (this.jdField_a_of_type_Mye.da() == paramBaseArticleInfo.mArticleID)
        {
          i = this.jdField_a_of_type_Mye.qc();
          localBundle.putInt("VIDEO_PLAY_STATUS", i);
        }
      }
      else
      {
        if (paramb.aDs == 2)
        {
          localObject = kxv.a(paramb.videoVid);
          if (localObject != null)
          {
            localBundle.putString("VIDEO_THIRD_VID_URL", ((kxz)localObject).url);
            localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((kxz)localObject).time);
          }
        }
        localBundle.putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
        localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
        if (this.mChannelID != 0) {
          break label754;
        }
        if (!kxm.r(paramBaseArticleInfo)) {
          break label707;
        }
        localBundle.putInt("VIDEO_FROM_TYPE", 4);
        localBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.vr);
        localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.uin);
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
        localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", this.mChannelID);
        localBundle.putParcelable("VIDEO_COLUMN_INFO", paramBaseArticleInfo.mVideoColumnInfo);
        localBundle.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
        localObject = getActivity();
        localIntent = new Intent((Context)localObject, VideoFeedsPlayActivity.class);
        localIntent.addFlags(536870912);
        if (BaseApplicationImpl.sProcessId != 1)
        {
          localBundle.putBoolean("param_needSmooth", mzj.a().Fc());
          mzj.a().oY(true);
          localBundle.putBoolean("param_needAlertInXg", mst.Ei());
        }
        localIntent.putExtras(localBundle);
        if ((paramb.aDs == 6) && (!kxm.B(paramBaseArticleInfo))) {
          localIntent.putExtra("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
        }
        i = 9091;
        if (1 != paramBaseArticleInfo.mVideoType) {
          break label1076;
        }
        i = 1;
        label432:
        localIntent.putExtra("VIDEO_FEEDS_INNER_SESSION_ID", paramb.akL);
        localIntent.putExtra("VIDEO_CHANNEL_SESSION_ID", paramb.akM);
        localIntent.putExtra("item_x", paramb.aKB);
        localIntent.putExtra("item_y", paramb.aKC);
        localIntent.putExtra("item_width", paramb.viewWidth);
        localIntent.putExtra("item_height", paramb.viewHeight);
        muj.a(paramBaseArticleInfo, localIntent);
        localIntent.putExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", kxm.a(paramBaseArticleInfo));
        localIntent.putExtra("VIDEO_SHOW_COMMENT", paramBoolean1);
      }
      try
      {
        paramBoolean1 = kzc.b(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
        if (paramBoolean1)
        {
          MultiVideoFragment.d(this.mContext, localIntent, i);
          ((Activity)localObject).overridePendingTransition(2130772027, 0);
          mxt.aTA();
          if (this.mVideoPreDownloadMgr != null)
          {
            this.mVideoPreDownloadMgr.aTZ();
            this.aru = true;
          }
          if (awit.aMH()) {
            kbp.a(null, "", "0X8008B68", "0X8008B68", 0, 0, "", "", "", kct.a(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID, nh(), null), false);
          }
          return;
          localBundle = a(paramb, paramBaseArticleInfo);
          continue;
          i = 1;
          break label137;
          label707:
          if (kxm.B(paramBaseArticleInfo))
          {
            localBundle.putInt("VIDEO_FROM_TYPE", 13);
            localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.uin);
            break label266;
          }
          localBundle.putInt("VIDEO_FROM_TYPE", 3);
          break label266;
          label754:
          if (this.mChannelID == 56)
          {
            if (kxm.r(paramBaseArticleInfo))
            {
              localBundle.putInt("VIDEO_FROM_TYPE", 5);
              localBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.vr);
              localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.uin);
            }
            for (;;)
            {
              localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 4);
              break;
              if (kxm.B(paramBaseArticleInfo))
              {
                localBundle.putInt("VIDEO_FROM_TYPE", 5);
                localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.uin);
              }
              else if (this.xm == 1004L)
              {
                localBundle.putInt("VIDEO_FROM_TYPE", 25);
              }
              else
              {
                localBundle.putInt("VIDEO_FROM_TYPE", 2);
              }
            }
          }
          if (this.mChannelID == 70)
          {
            if (kxm.B(paramBaseArticleInfo))
            {
              localBundle.putInt("VIDEO_FROM_TYPE", 14);
              localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.uin);
              break label275;
            }
            localBundle.putInt("VIDEO_FROM_TYPE", 8);
            localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
            break label275;
          }
          if (this.mChannelID == 40677)
          {
            localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 6);
            localBundle.putInt("VIDEO_FROM_TYPE", 9);
            localBundle.putInt("key_source", 0);
            localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 8);
            break label275;
          }
          if (kys.dv(this.mChannelID))
          {
            localBundle.putInt("VIDEO_FROM_TYPE", 24);
            break label275;
          }
          if (this.mChannelType == 3) {
            localBundle.putInt("VIDEO_FROM_TYPE", 6);
          }
          for (;;)
          {
            localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 5);
            break;
            localBundle.putInt("VIDEO_FROM_TYPE", 7);
          }
          label1076:
          if (0L != paramBaseArticleInfo.mChannelID) {
            break label432;
          }
          i = 1;
        }
      }
      catch (Exception paramb)
      {
        for (;;)
        {
          paramBoolean1 = false;
          continue;
          ((Activity)localObject).startActivityForResult(localIntent, i);
          ((Activity)localObject).overridePendingTransition(2130772129, 2130772130);
        }
      }
    }
  }
  
  public void a(mye.b paramb1, mye.b paramb2)
  {
    if (paramb1 != paramb2)
    {
      if (((paramb1.d instanceof ArticleInfo)) && ((paramb2.d instanceof ArticleInfo))) {
        lbz.a().a(this.mChannelID, (ArticleInfo)paramb1.d, (ArticleInfo)paramb2.d);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.clearFocus();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postDelayed(new ReadInJoyBaseAdapter.27(this, paramb1, paramb2), 100L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mza$b != null) {
        this.jdField_a_of_type_Mza$b.a(paramb1, paramb2);
      }
      return;
      if (this.jdField_a_of_type_Mye.qc() == 7) {
        e(paramb1);
      }
    }
  }
  
  public void a(mye parammye, mst parammst)
  {
    this.jdField_a_of_type_Mye = parammye;
    this.jdField_a_of_type_Mst = parammst;
    if (mst.as(this.mContext.getApplicationContext())) {
      this.jdField_a_of_type_Mst.od(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "setVideoPlayManager " + this.jdField_c_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler + " mVideoPlayManager " + this.jdField_a_of_type_Mye + " mIsCleanData " + this.arx);
      }
      if ((this.jdField_a_of_type_Mye != null) && (!this.arx))
      {
        aVK();
        this.jdField_a_of_type_Mye.a(this.mVideoPreDownloadMgr);
        this.jdField_a_of_type_Mye.a(this.jdField_a_of_type_Mst);
        if (awit.nJ(this.mChannelType)) {
          this.jdField_a_of_type_Mye.setXYaxis(0);
        }
      }
      if ((knd.dh(this.mChannelID)) && (this.jdField_a_of_type_Mye != null))
      {
        this.jdField_b_of_type_Msl = new msl(this.mContext, this, this.jdField_a_of_type_Mye, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.mChannelID);
        this.jdField_a_of_type_Mye.a(this.jdField_b_of_type_Msl);
      }
      return;
      this.jdField_a_of_type_Mst.od(false);
    }
  }
  
  public void a(ndc paramndc)
  {
    this.jdField_a_of_type_Ndc = paramndc;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoteCardLifeCycle(paramndc);
    }
  }
  
  public void a(ndi.a parama)
  {
    this.jdField_a_of_type_Ndi$a = parama;
  }
  
  public void a(ndi.b paramb)
  {
    this.jdField_a_of_type_Ndi$b = paramb;
  }
  
  public void a(ndi.c paramc)
  {
    this.jdField_a_of_type_Ndi$c = paramc;
  }
  
  public void a(ndi.d paramd)
  {
    this.jdField_a_of_type_Ndi$d = paramd;
  }
  
  public void a(ndi.e parame)
  {
    this.jdField_a_of_type_Ndi$e = parame;
  }
  
  public void a(boolean paramBoolean, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, String paramString)
  {
    a(paramBoolean, paramArticleInfo1, paramArticleInfo2, paramString, null);
  }
  
  public void a(boolean paramBoolean, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, String paramString, Map<String, Object> paramMap)
  {
    mye.b localb = a(paramArticleInfo1);
    localb.akN = paramString;
    localb.akL = kct.ic();
    if ((this.jdField_a_of_type_Mye != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Mye.kx()))) {
      localb.akM = this.jdField_a_of_type_Mye.kx();
    }
    paramString = new nce.a(null, null, null, null);
    int i;
    if (paramBoolean)
    {
      i = 0;
      kbp.a(null, "", "0X8008D33", "0X8008D33", 0, 0, "", "", "", paramString.x(i).b(localb.akL).c(localb.akM).a(this.mChannelID).k(paramArticleInfo1.mVideoAdsSource).j(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).O((int)this.xm).a().toJsonString(), false);
      if (!muj.a(paramArticleInfo1, getActivity())) {
        break label192;
      }
      b(localb, paramArticleInfo1);
    }
    label192:
    label467:
    label474:
    do
    {
      return;
      i = 1;
      break;
      if ((paramArticleInfo1.isAccountShown) && (this.mChannelID == 0) && (!TextUtils.isEmpty(paramArticleInfo1.mArticleContentUrl)))
      {
        kxm.C(getActivity(), paramArticleInfo1.mArticleContentUrl);
        paramString = new nce.a(null, null, paramArticleInfo1.mVideoVid, paramArticleInfo1.innerUniqueID);
        if (paramBoolean)
        {
          i = 0;
          paramArticleInfo2 = paramString.x(i).b(localb.akL).c(localb.akM).a(this.mChannelID).k(paramArticleInfo1.mVideoAdsSource).j(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).O((int)this.xm).W(kxm.a(paramArticleInfo1)).e(paramArticleInfo1).R(7).f(paramArticleInfo2);
          if ((paramArticleInfo1.columnEntrances != null) && (paramArticleInfo1.columnEntrances.size() > 0))
          {
            paramArticleInfo1 = (VideoColumnInfo)paramArticleInfo1.columnEntrances.get(0);
            if (paramArticleInfo1.aHc == 0) {
              break label474;
            }
            paramArticleInfo2.a("is_column", "1");
            paramArticleInfo2.a("column_id", String.valueOf(paramArticleInfo1.aHc));
            if (!paramArticleInfo1.amw) {
              break label467;
            }
            paramArticleInfo1 = "1";
            paramArticleInfo2.a("subscribe_flag", paramArticleInfo1);
          }
        }
        for (;;)
        {
          kbp.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", b(paramArticleInfo2.a().toJsonString(), paramMap), false);
          return;
          i = 1;
          break;
          paramArticleInfo1 = "2";
          break label414;
          paramArticleInfo2.a("is_column", "0");
        }
      }
      if (paramArticleInfo1.isVideoItemForAdJump())
      {
        paramArticleInfo2 = getActivity();
        if (paramArticleInfo2 != null)
        {
          paramString = new Intent(paramArticleInfo2, QQBrowserActivity.class);
          paramString.putExtra("url", paramArticleInfo1.mVideoAdsJumpUrl);
          paramString.putExtra("big_brother_source_key", kxm.bg(nh()));
          paramArticleInfo2.startActivity(paramString);
        }
        b(localb, paramArticleInfo1);
        return;
      }
      if ((this.mChannelID != 0) && (this.mChannelID != 56)) {
        break label801;
      }
      if (!muj.a(this.mContext, paramArticleInfo1)) {
        break label698;
      }
      b(localb, paramArticleInfo1);
    } while ((this.mChannelID != 56) || (paramArticleInfo1.mVideoDownloadBarInfo == null) || (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo == null) || (!kxm.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) || (!kxm.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail)));
    label414:
    muj.nW(kxm.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + kxm.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail));
    return;
    label698:
    if ((this.mChannelID == 56) && (paramArticleInfo1.mVideoDownloadBarInfo != null) && (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo != null) && (kxm.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (kxm.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail))) {
      muj.nW(kxm.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + kxm.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail));
    }
    label801:
    if (paramArticleInfo1.videoJumpChannelID > 0)
    {
      if (paramArticleInfo1.videoJumpChannelID == 56) {
        kgw.a(this.mContext, paramArticleInfo2, paramArticleInfo1, true);
      }
      for (;;)
      {
        b(localb, paramArticleInfo1);
        return;
        paramArticleInfo2 = new HashMap();
        paramArticleInfo2.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo1.mArticleID));
        kgw.b(this.mContext, paramArticleInfo1.videoJumpChannelID, paramArticleInfo1.videoJumpChannelName, paramArticleInfo1.videoJumpChannelType, 5, paramArticleInfo2);
      }
    }
    if (awit.i(BaseApplicationImpl.getApplication().getRuntime()) == 1)
    {
      kgw.a(this.mContext, paramArticleInfo2, paramArticleInfo1, true);
      b(localb, paramArticleInfo1);
      return;
    }
    localb.eA = paramMap;
    a(localb, paramArticleInfo1);
  }
  
  public void a(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo)
  {
    if (!paramBoolean) {}
    while (this.mChannelID != 56) {
      return;
    }
    long l2 = 0L;
    int i = 0;
    for (;;)
    {
      long l1 = l2;
      if (i < this.gO.size())
      {
        if (paramBaseArticleInfo.mRecommendSeq != ((BaseArticleInfo)this.gO.get(i)).mRecommendSeq) {
          break label117;
        }
        i += 1;
        l1 = l2;
        if (i <= this.gO.size() - 1) {
          l1 = ((BaseArticleInfo)this.gO.get(i)).mAlgorithmID;
        }
      }
      lbz.a().c(56, 3, paramBaseArticleInfo.mArticleID, l1);
      return;
      label117:
      i += 1;
    }
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, boolean paramBoolean)
  {
    if ((getData() != null) && (getData().contains(paramBaseArticleInfo1)))
    {
      int i = getData().indexOf(paramBaseArticleInfo1);
      if (paramBoolean) {
        getData().remove(i + 1);
      }
      getData().add(i + 1, paramBaseArticleInfo2);
      notifyDataSetChanged();
    }
    return false;
  }
  
  public void aCk()
  {
    if (this.jdField_a_of_type_Mza$b != null) {
      this.jdField_a_of_type_Mza$b.aCk();
    }
  }
  
  public void aVK()
  {
    this.mVideoPreDownloadMgr = new VideoPreDownloadMgr(this.mContext.getApplicationContext());
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.mVideoPreDownloadMgr;
    if (this.mChannelID == 56) {}
    for (int i = myn.aWb;; i = myn.aWa)
    {
      localVideoPreDownloadMgr.a = new myn(i, myn.aWf);
      this.mVideoPreDownloadMgr.a(new ndr(this));
      return;
    }
  }
  
  public void aVL()
  {
    if ((this.aru) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null))
    {
      this.mVideoPreDownloadMgr.resume();
      int m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
      int i = m;
      if (m >= getCount()) {
        i = 0;
      }
      this.mVideoPreDownloadMgr.sN(i);
      this.aru = false;
    }
  }
  
  public void aVM()
  {
    if (this.mVideoPreDownloadMgr != null)
    {
      this.mVideoPreDownloadMgr.destroy();
      this.mVideoPreDownloadMgr = null;
    }
  }
  
  public void aVN()
  {
    if (this.jdField_a_of_type_Mye != null) {
      this.jdField_a_of_type_Mye.a(new ndl(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyBaseAdapter", 2, "mVideoPlayManager == null");
  }
  
  public void aVO()
  {
    if ((this.jdField_a_of_type_Mye != null) && (this.jdField_a_of_type_Mye.a() != null)) {}
  }
  
  public void aVR()
  {
    if (!PreloadManager.a().Gu()) {}
    for (;;)
    {
      return;
      PreloadManager.a().bdm();
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
      int n = nh();
      while (i <= m)
      {
        Object localObject = getItem(i);
        if ((localObject != null) && ((localObject instanceof BaseArticleInfo)))
        {
          localObject = (BaseArticleInfo)localObject;
          if ((!kxm.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!kxm.j((BaseArticleInfo)localObject)) && (!m(n, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (sum.gg((String)localObject)) {
              PreloadManager.a().oZ((String)localObject);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void aVS()
  {
    if ((!awit.Q(getApp())) || (!awit.R(getApp()))) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
    int m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
    ArrayList localArrayList = new ArrayList();
    while (i <= m)
    {
      Object localObject = getItem(i);
      if (localObject != null)
      {
        localObject = (BaseArticleInfo)localObject;
        if (!kxm.j((BaseArticleInfo)localObject)) {
          localArrayList.add((ArticleInfo)localObject);
        }
      }
      i += 1;
    }
    lbz.a().a().bQ(localArrayList);
  }
  
  public void aVV()
  {
    this.ars = true;
    if ((this.jdField_a_of_type_Mye != null) && ((Fp()) || (this.jdField_a_of_type_Mst.nW())) && (!this.jdField_a_of_type_Mst.Ef()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getVisibility() == 0))
    {
      this.mUiHandler.removeMessages(1001);
      this.mUiHandler.sendEmptyMessage(1001);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "checkPlayableArea after transAnim: ");
      }
    }
  }
  
  public void aVX()
  {
    this.jdField_a_of_type_Mye.stop(9);
  }
  
  public void aVY()
  {
    if ((this.jdField_a_of_type_Mye != null) && (knd.dh(this.mChannelID))) {
      aVX();
    }
  }
  
  public void aVZ()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.tx(7);
    }
  }
  
  public void ad(int paramInt, boolean paramBoolean)
  {
    if (this.mVideoPreDownloadMgr != null) {
      this.mVideoPreDownloadMgr.ad(paramInt, paramBoolean);
    }
  }
  
  public String az(long paramLong)
  {
    return null;
  }
  
  public ListView b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  }
  
  public lfz b(int paramInt)
  {
    return (lfz)this.au.get(paramInt);
  }
  
  public lgf.f b(String paramString)
  {
    Object localObject2 = null;
    int m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
    int n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
    int i = Math.max(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount(), m);
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i <= n)
      {
        int i1 = i - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
        localObject1 = c(i1);
        if ((localObject1 == null) || (4 != getItemViewType(i1)) || (!TextUtils.equals(((BaseArticleInfo)localObject1).innerUniqueID, paramString))) {
          break label119;
        }
        paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i - m);
        localObject1 = localObject2;
        if (paramString != null) {
          localObject1 = (lgf.f)paramString.getTag();
        }
      }
      return localObject1;
      label119:
      i += 1;
    }
  }
  
  public void b(Set<Long> paramSet, Map<Long, mgu> paramMap)
  {
    this.U = paramSet;
    this.ek = paramMap;
  }
  
  public void b(mye.b paramb, BaseArticleInfo paramBaseArticleInfo)
  {
    int n = nh();
    String str1 = kxm.f(paramBaseArticleInfo);
    int i;
    int m;
    label40:
    nce.a locala;
    if (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo())
    {
      i = paramBaseArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label529;
      }
      m = 0;
      kbp.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), kxm.b(paramBaseArticleInfo.mAlgorithmID, kxm.a(paramBaseArticleInfo), this.mChannelID, i), false);
      kbp.d("0X80066FA", "", "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), kxm.b(paramBaseArticleInfo.mAlgorithmID, kxm.a(paramBaseArticleInfo), this.mChannelID, i));
      locala = new nce.a(kxm.a(paramBaseArticleInfo.mAlgorithmID, kxm.a(paramBaseArticleInfo), n, i, m, aqiw.isWifiConnected(this.mContext), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, kxm.h(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      locala.a(this.jdField_a_of_type_Myp, paramBaseArticleInfo.mArticleID).a(this.jdField_a_of_type_Myp).g(kct.aHF).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(kxm.F(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo);
      if (n != 0) {
        break label535;
      }
      paramb.akL = kct.ic();
      locala.b(paramb.akL);
      if (paramBaseArticleInfo.mVideoColumnInfo != null) {
        locala.aa(paramBaseArticleInfo.mVideoColumnInfo.aHc);
      }
      if (k((ArticleInfo)paramBaseArticleInfo) == 6) {
        locala.ac(muj.pQ());
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Mye != null) && (this.jdField_a_of_type_Mye.c() == paramb))
      {
        long l1 = this.jdField_a_of_type_Mye.cZ();
        if (l1 != 0L) {
          locala.f(l1);
        }
      }
      if (this.mChannelID != 40677) {
        break label586;
      }
      locala.b(paramBaseArticleInfo.mVideoAdsJumpType).a(rpw.isWeishiInstalled(this.mContext));
      locala.i(2);
      kbp.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, "0X8009293", "0X8009293", 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), locala.a().toJsonString(), false);
      kbp.d("0X8009293", paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), kxm.a(paramBaseArticleInfo.mAlgorithmID, kxm.a(paramBaseArticleInfo), n, i, m, aqiw.isWifiConnected(this.mContext), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, kxm.h(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      return;
      i = 0;
      break;
      label529:
      m = 1;
      break label40;
      label535:
      if ((n == 56) && (this.jdField_a_of_type_Mye != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Mye.kx())))
      {
        paramb.akM = this.jdField_a_of_type_Mye.kx();
        locala.c(paramb.akM);
      }
    }
    label586:
    locala.a(paramBaseArticleInfo).O((int)this.xm).c(paramBaseArticleInfo).a(paramBaseArticleInfo, true).d(paramBaseArticleInfo).f(paramBaseArticleInfo);
    if ((kxm.u(paramBaseArticleInfo)) && (paramBaseArticleInfo.mPolymericInfo != null)) {
      locala.x(paramBaseArticleInfo.mPolymericInfo.aSh + 1);
    }
    String str2 = odv.aB(this.mChannelID);
    kbp.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), b(locala.a().toJsonString(), paramb.eA), false);
    kbp.d(str2, paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), kxm.a(paramBaseArticleInfo.mAlgorithmID, kxm.a(paramBaseArticleInfo), n, i, m, aqiw.isWifiConnected(this.mContext), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, kxm.h(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
  }
  
  public void b(mza.b paramb)
  {
    this.jdField_a_of_type_Mza$b = paramb;
  }
  
  public void b(ndc paramndc)
  {
    this.lC.add(paramndc);
  }
  
  public void b(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo)
  {
    nce.a locala;
    if ((paramBaseArticleInfo.isAccountShown) && (this.mChannelID == 0) && (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)))
    {
      kxm.C(getActivity(), paramBaseArticleInfo.mArticleContentUrl);
      locala = new nce.a(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID);
      if (!paramBoolean) {
        break label144;
      }
    }
    label144:
    for (int i = 0;; i = 1)
    {
      kbp.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", locala.x(i).a(this.mChannelID).a(paramBaseArticleInfo.videoReportInfo).a(paramBaseArticleInfo).O((int)this.xm).W(kxm.a(paramBaseArticleInfo)).e(paramBaseArticleInfo).R(6).f(paramBaseArticleInfo).a().toJsonString(), false);
      return;
    }
  }
  
  public Bitmap c(long paramLong)
  {
    return null;
  }
  
  public ArticleInfo c()
  {
    long l1 = getActivity().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
    ArticleInfo localArticleInfo2 = lbz.a().a(0, l1);
    ArticleInfo localArticleInfo1 = localArticleInfo2;
    if (localArticleInfo2 == null) {
      localArticleInfo1 = (ArticleInfo)getActivity().getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
    }
    return localArticleInfo1;
  }
  
  public BaseArticleInfo c(int paramInt)
  {
    if ((this.gO.size() > 0) && (paramInt < this.gO.size())) {
      return (BaseArticleInfo)this.gO.get(paramInt);
    }
    return null;
  }
  
  public jzh c()
  {
    return this.jdField_b_of_type_Jzh;
  }
  
  public void c(ndc paramndc)
  {
    this.lC.remove(paramndc);
  }
  
  public void cV(List<BaseArticleInfo> paramList)
  {
    if ((paramList != null) && (this.gO.getClass().isInstance(paramList)) && (paramList.size() > 0)) {
      this.gO.removeAll(paramList);
    }
  }
  
  public void clearData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "clearData " + this.jdField_c_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    this.arx = true;
    this.gO.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.aWb();
    this.mUiHandler.removeCallbacksAndMessages(null);
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_c_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_c_of_type_Autw = null;
    this.jdField_b_of_type_Auua = null;
    if (this.mChannelID == 56) {
      msv.a().reset();
    }
    if (this.jdField_b_of_type_Myq != null) {
      this.jdField_b_of_type_Myq.doOnDestory();
    }
    kpc.aFH();
    if (this.jdField_b_of_type_Msl != null) {
      this.jdField_b_of_type_Msl.Destroy();
    }
  }
  
  public abstract BaseArticleInfo d(int paramInt);
  
  public abstract int dA(int paramInt);
  
  public long di()
  {
    long l1 = 0L;
    if (this.jdField_a_of_type_Mye != null) {
      l1 = this.jdField_a_of_type_Mye.cZ();
    }
    return l1;
  }
  
  public void doOnPause()
  {
    int n = 0;
    if (this.jdField_b_of_type_Msl != null) {
      this.jdField_b_of_type_Msl.doOnPause();
    }
    if (!this.mIsResume) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video_" + this.mChannelID, 2, "ReadInJoyBaseAdapter doOnPause()");
      }
      this.mIsResume = false;
      if ((this.jdField_c_of_type_Autw != null) && (this.jdField_c_of_type_Autw.isShowing())) {
        this.jdField_c_of_type_Autw.dismiss();
      }
      this.aYe = aqiw.getNetworkType(this.mContext);
      this.jdField_a_of_type_Oaw.n(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 5);
      aVW();
      if ((!awit.aMM()) && (kvx.a(this.mVafContext, "default_feeds")))
      {
        QLog.d("ReadInJoyBaseAdapter", 2, "hasRefresh notifyDataSetChanged");
        notifyDataSetChanged();
      }
      int i = 0;
      int m;
      for (;;)
      {
        m = n;
        if (i >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount()) {
          break;
        }
        View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
        if (((localView instanceof nda)) && (((nda)localView).isResumed()))
        {
          ((nda)localView).setIsResume(false);
          ((nda)localView).onViewPause();
        }
        i += 1;
      }
      while (m < this.lC.size())
      {
        ((ndc)this.lC.get(m)).aMR();
        m += 1;
      }
      if (this.jdField_a_of_type_Ndc != null) {
        this.jdField_a_of_type_Ndc.aMR();
      }
      ((SensorManager)getActivity().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_Acln);
    } while (!ProteusParserWithHotReload.getInstance().isSupportHotReload());
    ProteusParserWithHotReload.getInstance().removeHotReloadChangedObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver);
  }
  
  public void doOnResume()
  {
    int m = 0;
    if (this.jdField_b_of_type_Msl != null) {
      this.jdField_b_of_type_Msl.doOnResume();
    }
    if (this.mIsResume) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video_" + this.mChannelID, 2, "ReadInJoyBaseAdapter doOnResume()");
      }
      if (awit.Vs()) {
        aVP();
      }
      this.arC = true;
      this.mIsResume = true;
      aVL();
      this.mUiHandler.postDelayed(new ReadInJoyBaseAdapter.31(this), 1000L);
      if (Build.VERSION.SDK_INT < 21) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setFriction(kq);
      }
      this.jdField_a_of_type_Oaw.n(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 4);
      this.arz = false;
      this.ary = false;
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
        if (((localObject instanceof nda)) && (!((nda)localObject).isResumed()))
        {
          ((nda)localObject).setIsResume(true);
          ((nda)localObject).onViewResume();
        }
        i += 1;
      }
      i = 0;
      while (i < this.lC.size())
      {
        ((ndc)this.lC.get(i)).aMQ();
        i += 1;
      }
      if (this.jdField_a_of_type_Ndc != null) {
        this.jdField_a_of_type_Ndc.aMQ();
      }
      Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if ((ljp.oH() == 2) && (ljp.o(getActivity(), (String)localObject) > 0))
      {
        localObject = (SensorManager)getActivity().getSystemService("sensor");
        acln localacln = this.jdField_a_of_type_Acln;
        Sensor localSensor = ((SensorManager)localObject).getDefaultSensor(1);
        i = m;
        if (anpq.a().ayH()) {
          i = 2;
        }
        ((SensorManager)localObject).registerListener(localacln, localSensor, i);
      }
    } while (!ProteusParserWithHotReload.getInstance().isSupportHotReload());
    ProteusParserWithHotReload.getInstance().addHotReloadChangedObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewParseProteusParserWithHotReload$IHotReloadChangedObserver);
  }
  
  public void e(mye.b paramb)
  {
    if ((this.jdField_c_of_type_Autw != null) && (this.jdField_c_of_type_Autw.isShowing())) {
      this.jdField_c_of_type_Autw.dismiss();
    }
    if ((this.jdField_b_of_type_Auua != null) && (this.jdField_b_of_type_Auua.isShowing())) {
      this.jdField_b_of_type_Auua.dismiss();
    }
    this.mUiHandler.postDelayed(new ReadInJoyBaseAdapter.28(this, paramb), 1000L);
  }
  
  public void e(mye.b paramb, int paramInt)
  {
    if (this.jdField_a_of_type_Lgf$c != null) {}
    for (;;)
    {
      return;
      lgf.f localf = a(paramb.akK);
      if (localf != null)
      {
        this.jdField_a_of_type_Lgf$c = localf;
        paramb.ma = localf.h;
      }
      while ((this.jdField_a_of_type_Mye != null) && (this.jdField_a_of_type_Mye.a() != null))
      {
        paramb = this.jdField_a_of_type_Mye.a();
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyBaseAdapter", 2, "notifyVideoPositionChanged:");
        }
        paramb.aUm();
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyBaseAdapter", 2, "fixNowPlayHolder failed videoPlayParam:" + paramb + "    callSource:" + paramInt);
        }
      }
    }
  }
  
  public void eJ(long paramLong)
  {
    this.xm = paramLong;
  }
  
  public boolean eb(int paramInt)
  {
    return paramInt == 46;
  }
  
  public AnimationSet f()
  {
    if (this.d == null) {
      this.d = ((AnimationSet)AnimationUtils.loadAnimation(this.mContext, 2130772117));
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    List localList = this.d.getAnimations();
    int m = localList.size();
    int i = 0;
    while (i < m)
    {
      localAnimationSet.addAnimation((Animation)localList.get(i));
      i += 1;
    }
    return localAnimationSet;
  }
  
  public abstract Activity getActivity();
  
  public int getCount()
  {
    return this.gO.size();
  }
  
  public List<BaseArticleInfo> getData()
  {
    return this.gO;
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.gO.size())) {
      return this.gO.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof BaseArticleInfo)) {
      return ((BaseArticleInfo)localObject).mArticleID;
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int m = dA(paramInt);
    int i = m;
    if (ab(m, paramInt)) {
      i = 119;
    }
    return i;
  }
  
  public VafContext getVafContext()
  {
    return this.mVafContext;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    auvk.traceBegin("ReadInJoyBaseAdapter.getView");
    System.currentTimeMillis();
    j(c(paramInt), paramInt);
    BaseArticleInfo localBaseArticleInfo = c(paramInt);
    int i = getItemViewType(paramInt);
    Object localObject = a((ArticleInfo)localBaseArticleInfo, i, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "getView: " + localBaseArticleInfo + " type= " + i);
    }
    View localView = (View)lgd.a(this.au, new nef(this, "onAdapterGetView", i, localBaseArticleInfo, paramInt, paramView, paramViewGroup));
    if (localView != null)
    {
      a(localBaseArticleInfo, (lie)localObject, System.currentTimeMillis(), paramInt);
      localObject = super.a(localView, paramInt);
      a((View)localObject, i, localBaseArticleInfo);
      TextHook.updateFont(paramView);
      auvk.traceEnd();
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if ((getActivity() instanceof ReadInJoyChannelActivity)) {
      if ((this.arq) && (paramView != null) && (paramInt > 0) && (paramInt <= 2))
      {
        if ((paramInt != 1) || (!this.arr)) {
          break label321;
        }
        this.arr = false;
        paramView.startAnimation(this.f);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, "adapter animation start at item position" + paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " judge adapter animation show or not：");
      }
      QLog.d("ReadInJoyBaseAdapter", 1, "get view has error, return then convert view， viewType : " + i);
      localObject = paramView;
      break;
      label321:
      if (paramInt == 2)
      {
        if (this.arq) {
          this.arq = false;
        }
        paramView.startAnimation(this.f);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return jdField_c_of_type_Lrj.oL() + 142 + luy.getViewTypeCount();
  }
  
  public boolean isEmpty()
  {
    return this.gO.isEmpty();
  }
  
  public boolean isResume()
  {
    return this.mIsResume;
  }
  
  public void j(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    paramInt1 = 0;
    Object localObject1;
    if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
      if ((localObject1 instanceof ProteusItemView))
      {
        localObject1 = ((ProteusItemView)localObject1).a();
        if (localObject1 != null)
        {
          localObject1 = (ndb)((Container)localObject1).getTag(2131376750);
          if ((localObject1 == null) || (!((ndb)localObject1).CC())) {}
        }
      }
    }
    for (;;)
    {
      paramInt1 = paramInt2;
      if (localObject1 != null)
      {
        paramInt1 = paramInt2;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.Fz())
        {
          ((ndb)localObject1).aMS();
          paramInt1 = paramInt2;
        }
      }
      for (;;)
      {
        if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
        {
          Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
          if ((localObject2 instanceof ProteusItemView))
          {
            localObject2 = ((ProteusItemView)localObject2).a();
            if (localObject2 != null)
            {
              localObject2 = (ndb)((Container)localObject2).getTag(2131376750);
              if ((localObject2 != null) && (localObject2 != localObject1)) {
                ((ndb)localObject2).aMT();
              }
            }
          }
          paramInt1 += 1;
          continue;
          paramInt1 += 1;
          break;
        }
      }
      return;
      localObject1 = null;
    }
  }
  
  public void j(BaseArticleInfo paramBaseArticleInfo)
  {
    this.gO.remove(paramBaseArticleInfo);
    notifyDataSetChanged();
    this.arB = true;
  }
  
  public void j(AbsListView paramAbsListView, int paramInt)
  {
    Object localObject = a(paramAbsListView);
    if (this.mChannelID == 40677) {}
    label16:
    do
    {
      do
      {
        do
        {
          break label16;
          do
          {
            return;
          } while (((this.jdField_a_of_type_Mye != null) && (this.jdField_a_of_type_Mye.isFullScreen())) || (knj.a().getShowStatus() == 1));
          if (localObject == null) {
            break;
          }
          localObject = ((lgf.c)localObject).a();
        } while ((localObject != null) && (((mye.b)localObject).d != null) && (((mye.b)localObject).d.patchStatus.U.get() == 1));
      } while ((this.jdField_a_of_type_Mye == null) || (!this.jdField_a_of_type_Mst.nW()) || (this.jdField_a_of_type_Mst.Ef()) || (paramAbsListView == null) || (paramAbsListView.getVisibility() != 0));
      this.mUiHandler.removeMessages(1001);
      this.mUiHandler.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "checkPlayableArea delay: " + paramInt);
  }
  
  public void k(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.isAccountShown) && (this.mChannelID == 0) && (!TextUtils.isEmpty(kxm.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url)))) {
      kxm.C(getActivity(), kxm.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url));
    }
  }
  
  public void k(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.mChannelID == 0) || (this.mChannelID == 40677)) {}
    do
    {
      do
      {
        return;
      } while ((!aqiw.isNetworkAvailable(this.mContext)) || (this.jdField_a_of_type_Mye == null) || (paramAbsListView == null));
      this.mUiHandler.removeMessages(1001);
      this.mUiHandler.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "force checkPlayableArea delay: " + paramInt);
  }
  
  public void m(AdvertisementInfo paramAdvertisementInfo)
  {
    int m = 0;
    if (paramAdvertisementInfo == null) {}
    label16:
    label86:
    label216:
    label225:
    for (;;)
    {
      return;
      aVY();
      int n = -1;
      int i = 0;
      Object localObject;
      if (i < this.gO.size())
      {
        localObject = (BaseArticleInfo)this.gO.get(i);
        if (((localObject instanceof AdvertisementInfo)) && (paramAdvertisementInfo.mAdTraceId.equals(((AdvertisementInfo)localObject).mAdTraceId))) {
          localObject = (AdvertisementInfo)localObject;
        }
      }
      for (;;)
      {
        if ((i < 0) || (localObject == null)) {
          break label225;
        }
        if (m < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount()) {
          if (localObject != ((lie)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(m).getTag(2131381960)).a()) {}
        }
        for (paramAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(m);; paramAdvertisementInfo = null)
        {
          if (paramAdvertisementInfo == null) {
            break label216;
          }
          if ((paramAdvertisementInfo instanceof ProteusItemView)) {
            paramAdvertisementInfo = ((ProteusItemView)paramAdvertisementInfo).a();
          }
          for (;;)
          {
            localObject = new neb(this, (BaseArticleInfo)localObject, i);
            Animation localAnimation = (Animation)paramAdvertisementInfo.getTag(2131370016);
            if (localAnimation == null) {
              break;
            }
            localAnimation.setAnimationListener((Animation.AnimationListener)localObject);
            paramAdvertisementInfo.startAnimation(localAnimation);
            return;
            i += 1;
            break label16;
            m += 1;
            break label86;
          }
        }
        break;
        localObject = null;
        i = n;
      }
    }
  }
  
  public abstract boolean m(int paramInt, long paramLong);
  
  public abstract boolean n(int paramInt, long paramLong);
  
  public int nh()
  {
    return this.mChannelID;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    lgd.a(this.au, new ndz(this, "onNotifyDataSetChange"));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "notifyDataSetChanged");
    }
    if (((this.jdField_a_of_type_Lgf$c != null) || (this.jdField_k_of_type_Mye$b != null)) && (this.mVideoPreDownloadMgr != null))
    {
      int m = -1;
      int i = m;
      if (this.jdField_a_of_type_Lgf$c != null)
      {
        i = m;
        if (this.jdField_a_of_type_Lgf$c.a() != null) {
          i = this.jdField_a_of_type_Lgf$c.a().position;
        }
      }
      if (this.jdField_k_of_type_Mye$b != null) {
        i = this.jdField_k_of_type_Mye$b.position;
      }
      this.mVideoPreDownloadMgr.ad(i, true);
    }
  }
  
  public void nq(boolean paramBoolean)
  {
    this.akw = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    if ((this.mContext instanceof ReadInJoyFeedsActivity)) {
      ((ReadInJoyFeedsActivity)this.mContext).oT(16);
    }
    this.mUiHandler.removeMessages(1001);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = (lgf.f)paramView.getTag();
      Object localObject2 = c(((lgf.c)localObject1).getPosition());
      if ((this.jdField_a_of_type_Mye.a() != null) && (this.jdField_a_of_type_Mye.a().a() != null) && (this.jdField_a_of_type_Mye.a().a().Ag()))
      {
        this.jdField_a_of_type_Mye.a().a().pr(5);
      }
      else
      {
        int i;
        if (!muj.a((BaseArticleInfo)localObject2, getActivity()))
        {
          if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2))
          {
            ods.b(this.mContext, (ArticleInfo)localObject2, this, 56);
            ods.a(this.mContext, (ArticleInfo)localObject2, this, 56, true, null);
            continue;
          }
          if ((!muj.Er()) || (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2))) {
            break label553;
          }
          i = 1;
          label429:
          if (((this.jdField_a_of_type_Mst.nW()) || (awit.f(getApp()) <= 0)) && (i == 0)) {
            break label558;
          }
          if (localObject2 == null) {
            continue;
          }
          if (i != 0) {
            kbp.a(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", new nce.a(null, null, ((BaseArticleInfo)localObject2).mVideoVid, ((BaseArticleInfo)localObject2).innerUniqueID).a((int)((BaseArticleInfo)localObject2).mChannelID).O((int)this.xm).R(1).a().toJsonString(), false);
          }
          a(((lgf.c)localObject1).a(), (BaseArticleInfo)localObject2, false);
        }
        for (;;)
        {
          lgf.cu(paramView);
          break;
          label553:
          i = 0;
          break label429;
          label558:
          this.jdField_a_of_type_Mye.a().cW(paramView);
        }
        localObject1 = (articlesummary.ChannelInfo)paramView.getTag();
        if (localObject1 != null) {
          if ((((articlesummary.ChannelInfo)localObject1).bytes_channel_url.has()) && (((articlesummary.ChannelInfo)localObject1).bytes_channel_url.get() != null))
          {
            if (!TextUtils.isEmpty(((articlesummary.ChannelInfo)localObject1).bytes_channel_url.get().toStringUtf8())) {
              kxm.aJ(this.mContext, ((articlesummary.ChannelInfo)localObject1).bytes_channel_url.get().toStringUtf8());
            }
          }
          else
          {
            kgw.b(this.mContext, ((articlesummary.ChannelInfo)localObject1).uint32_channel_id.get(), kxm.a((articlesummary.ChannelInfo)localObject1), ((articlesummary.ChannelInfo)localObject1).uint32_channel_type.get(), 6, null);
            continue;
            localObject1 = (lgf.f)paramView.getTag();
            localObject2 = c(((lgf.f)localObject1).position);
            if (localObject2 != null) {
              if (!muj.a((BaseArticleInfo)localObject2, getActivity()))
              {
                if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2))
                {
                  ods.b(this.mContext, (ArticleInfo)localObject2, this, 56);
                  ods.a(this.mContext, (ArticleInfo)localObject2, this, 56, true, null);
                }
                else
                {
                  a(((lgf.f)localObject1).jdField_a_of_type_Mye$b, (BaseArticleInfo)localObject2);
                }
              }
              else
              {
                ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.14(this, (BaseArticleInfo)localObject2));
                lgf.cu(paramView);
                continue;
                localObject1 = (lgf.f)paramView.getTag();
                localObject2 = c(((lgf.f)localObject1).position);
                if (localObject2 != null)
                {
                  a(((lgf.f)localObject1).jdField_a_of_type_Mye$b, (BaseArticleInfo)localObject2, true);
                  ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.15(this, (BaseArticleInfo)localObject2));
                  lgf.cu(paramView);
                  continue;
                  localObject1 = paramView.getTag();
                  if ((localObject1 instanceof lgf.g))
                  {
                    ((lgf.g)localObject1).onClick(paramView);
                  }
                  else
                  {
                    if (kpn.nx() == 1) {}
                    for (boolean bool = true;; bool = false)
                    {
                      b(paramView, false, bool);
                      lgf.cu(paramView);
                      break;
                    }
                    localObject1 = (lgf.f)paramView.getTag();
                    localObject2 = c(((lgf.f)localObject1).position);
                    if (localObject2 == null)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ReadInJoyBaseAdapter", 2, "articleInfo == null, ERROR");
                      }
                    }
                    else
                    {
                      if ((this.jdField_a_of_type_Mye != null) && (this.jdField_a_of_type_Mye.isPlaying()))
                      {
                        this.jdField_a_of_type_Mye.pause();
                        this.afO = true;
                      }
                      this.jdField_b_of_type_Myq.K(((lgf.f)localObject1).itemView, ((lgf.f)localObject1).position);
                      this.jdField_b_of_type_Myq.setAdapter(this);
                      this.jdField_b_of_type_Myq.a((BaseArticleInfo)localObject2, a(((lgf.f)localObject1).jdField_a_of_type_Mye$b, (BaseArticleInfo)localObject2), this.jdField_a_of_type_Mye, new ndm(this, (BaseArticleInfo)localObject2), this.mChannelID);
                      lgf.cu(paramView);
                      continue;
                      a();
                      a();
                      localObject2 = (lgf.i)paramView.getTag();
                      if (localObject2 != null)
                      {
                        localObject1 = (BaseArticleInfo)this.gO.get(((lgf.i)localObject2).position);
                        try
                        {
                          JSONObject localJSONObject = new JSONObject();
                          localJSONObject.put("time", System.currentTimeMillis() / 1000L);
                          localJSONObject.put("channel_id", this.mChannelID);
                          if ((this.mContext instanceof BaseActivity))
                          {
                            localJSONObject.put("folder_status", kxm.aMw);
                            localJSONObject.put("kandian_mode", kxm.nR());
                            localJSONObject.put("feeds_type", "" + kxm.a((BaseArticleInfo)localObject1));
                            localJSONObject.put("rowkey", odv.r((BaseArticleInfo)localObject1));
                            kbp.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", localJSONObject.toString(), false);
                          }
                          while (localObject1 != null)
                          {
                            i = ((lgf.i)localObject2).position;
                            localObject2 = new ndn(this, i, (lgf.i)localObject2, (BaseArticleInfo)localObject1);
                            if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1)) {
                              break label1466;
                            }
                            if ((this.jdField_c_of_type_Autw != null) && (this.jdField_c_of_type_Autw.isShowing())) {
                              this.jdField_c_of_type_Autw.dismiss();
                            }
                            this.jdField_b_of_type_Auua.b(i, this.mChannelID, kxm.a((BaseArticleInfo)localObject1), ((AdvertisementInfo)localObject1).mAdDislikeInfos);
                            this.jdField_b_of_type_Auua.a(paramView, (autw.a)localObject2);
                            this.jdField_b_of_type_Auua.a(new ndp(this, (BaseArticleInfo)localObject1));
                            this.jdField_b_of_type_Auua.setOnDismissListener(new ndq(this));
                            if ((this.jdField_a_of_type_Mye != null) && (this.jdField_a_of_type_Mye.isPlaying()))
                            {
                              this.jdField_a_of_type_Mye.pause();
                              this.afO = true;
                            }
                            lgf.cu(paramView);
                            break;
                            if ((this.mContext instanceof PluginBaseActivity))
                            {
                              localJSONObject.put("folder_status", 1);
                              anot.a(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", localJSONObject.toString());
                            }
                          }
                        }
                        catch (JSONException localJSONException)
                        {
                          for (;;)
                          {
                            localJSONException.printStackTrace();
                            continue;
                            label1466:
                            if ((this.jdField_b_of_type_Auua != null) && (this.jdField_b_of_type_Auua.isShowing())) {
                              this.jdField_b_of_type_Auua.dismiss();
                            }
                            this.jdField_c_of_type_Autw.a(i, this.mChannelID, kxm.a((BaseArticleInfo)localObject1), ((BaseArticleInfo)localObject1).mDislikeInfos, ((BaseArticleInfo)localObject1).innerUniqueID);
                            this.jdField_c_of_type_Autw.a(paramView, (autw.a)localObject2);
                            this.jdField_c_of_type_Autw.setOnDismissListener(new nds(this));
                          }
                        }
                        Object localObject3 = (BaseArticleInfo)paramView.getTag();
                        localObject2 = null;
                        label1589:
                        Object localObject4;
                        long l1;
                        if ((!TextUtils.isEmpty(((BaseArticleInfo)localObject3).getSubscribeUin())) && (!"16888".equals(((BaseArticleInfo)localObject3).getSubscribeUin())))
                        {
                          localObject1 = ((BaseArticleInfo)localObject3).getSubscribeUin();
                          if (localObject1 != null) {
                            nT((String)localObject1);
                          }
                          localObject2 = ((BaseArticleInfo)localObject3).mVideoVid;
                          localObject4 = String.valueOf(((BaseArticleInfo)localObject3).innerUniqueID);
                          if (this.jdField_a_of_type_Mye != null) {
                            break label1806;
                          }
                          l1 = 0L;
                          label1627:
                          localObject4 = new nce.a(null, (String)localObject1, (String)localObject2, (String)localObject4, l1, ((BaseArticleInfo)localObject3).mVideoDuration * 1000).a(this.mChannelID).a().toJsonString();
                          if (TextUtils.isEmpty(((BaseArticleInfo)localObject3).innerUniqueID)) {
                            break label1818;
                          }
                        }
                        label1806:
                        label1818:
                        for (localObject2 = String.valueOf(((BaseArticleInfo)localObject3).innerUniqueID);; localObject2 = "0")
                        {
                          kbp.a(null, (String)localObject1, "0X8007410", "0X8007410", 0, 0, "2", "", (String)localObject2, (String)localObject4, false);
                          ods.b(this.mContext, (ArticleInfo)localObject3, this, 56);
                          ods.a(this.mContext, (ArticleInfo)localObject3, this, 56, true, null);
                          if (paramView.getId() != 2131361894) {
                            break;
                          }
                          lgf.cu(paramView);
                          break;
                          localObject1 = localObject2;
                          if (TextUtils.isEmpty(((BaseArticleInfo)localObject3).thirdUin)) {
                            break label1589;
                          }
                          localObject1 = localObject2;
                          if ("16888".equals(((BaseArticleInfo)localObject3).thirdUin)) {
                            break label1589;
                          }
                          localObject1 = ((BaseArticleInfo)localObject3).thirdUin;
                          break label1589;
                          l1 = this.jdField_a_of_type_Mye.cZ();
                          break label1627;
                        }
                        localObject1 = c(((lgf.f)paramView.getTag()).position);
                        ods.b(this.mContext, (ArticleInfo)localObject1, this, 56);
                        ods.a(this.mContext, (ArticleInfo)localObject1, this, 56, true, null);
                        lgf.cu(paramView);
                        continue;
                        if (paramView.getId() == 2131370375)
                        {
                          localObject1 = (ArticleInfo)((lgf.e)paramView.getTag()).jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
                          localObject4 = ((lgf.e)paramView.getTag()).jdField_f_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
                          localObject2 = localObject1;
                          localObject3 = localObject1;
                          label1929:
                          if (paramView.getId() != 2131370375) {
                            break label2013;
                          }
                        }
                        label2013:
                        for (bool = true;; bool = false)
                        {
                          a(bool, (ArticleInfo)localObject2, (ArticleInfo)localObject3, (String)localObject4);
                          break;
                          localObject2 = (ArticleInfo)((lgf.e)paramView.getTag()).jdField_f_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
                          localObject1 = ((lgf.e)paramView.getTag()).jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
                          localObject3 = (ArticleInfo)((lgf.e)paramView.getTag()).jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
                          ((ArticleInfo)localObject2).isTwoItem = true;
                          localObject4 = localObject1;
                          break label1929;
                        }
                        if (paramView.getId() == 2131368136) {
                          localObject1 = ((lgf.j)paramView.getTag()).jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
                        }
                        for (localObject2 = ((lgf.j)paramView.getTag()).jdField_f_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;; localObject2 = ((lgf.j)paramView.getTag()).jdField_e_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID)
                        {
                          localObject3 = a((BaseArticleInfo)localObject1);
                          ((mye.b)localObject3).akN = ((String)localObject2);
                          ((mye.b)localObject3).akL = kct.ic();
                          if ((this.jdField_a_of_type_Mye != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Mye.kx()))) {
                            ((mye.b)localObject3).akM = this.jdField_a_of_type_Mye.kx();
                          }
                          localObject2 = new int[2];
                          paramView.getLocationOnScreen((int[])localObject2);
                          ((mye.b)localObject3).aKB = localObject2[0];
                          ((mye.b)localObject3).aKC = localObject2[1];
                          ((mye.b)localObject3).viewWidth = paramView.getWidth();
                          ((mye.b)localObject3).viewHeight = paramView.getHeight();
                          if (!((BaseArticleInfo)localObject1).isVideoItemForCommonUrlJump()) {
                            break label2217;
                          }
                          kxm.C(this.mContext, ((BaseArticleInfo)localObject1).mVideoAdsJumpUrl);
                          b((mye.b)localObject3, (BaseArticleInfo)localObject1);
                          break;
                          localObject1 = ((lgf.j)paramView.getTag()).jdField_f_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
                        }
                        label2217:
                        if (((BaseArticleInfo)localObject1).isVideoItemForWeishiJump())
                        {
                          if (rpw.isWeishiInstalled(this.mContext)) {
                            oem.aT(this.mContext, "video_type_videopublic");
                          }
                          for (;;)
                          {
                            b((mye.b)localObject3, (BaseArticleInfo)localObject1);
                            break;
                            oem.aU(this.mContext, "video_type_videopublic");
                          }
                        }
                        a((mye.b)localObject3, (BaseArticleInfo)localObject1);
                        continue;
                        localObject1 = (BaseArticleInfo)paramView.getTag();
                        if (localObject1 != null)
                        {
                          if (paramView.getId() == 2131370375) {}
                          for (bool = true;; bool = false)
                          {
                            b(bool, (BaseArticleInfo)localObject1);
                            lgf.cu(paramView);
                            break;
                          }
                          localObject1 = (BaseArticleInfo)paramView.getTag();
                          if (localObject1 != null)
                          {
                            k((BaseArticleInfo)localObject1);
                            lgf.cu(paramView);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (kpn.ny() == 1) {
      bool = true;
    }
    b(paramView, true, bool);
    return true;
  }
  
  public int qx()
  {
    return this.mChannelType;
  }
  
  public void s(int paramInt, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Mye == null) {}
    long l1;
    int i;
    mye.b localb;
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt)
          {
          default: 
            return;
          }
        } while (this.mChannelID == 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult for OPEN_FULLPLAY");
        }
        this.arC = true;
        this.arA = false;
        l1 = -1L;
        i = -1;
        if (paramIntent != null)
        {
          l1 = paramIntent.getLongExtra("VIDEO_PLAY_POSITION", -1L);
          i = paramIntent.getIntExtra("VIDEO_PLAY_STATUS", -1);
        }
        if ((!this.jdField_a_of_type_Mye.isPause()) || (!this.jdField_a_of_type_Mye.EP())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "onActivityResult video is pause  && isPausedByMannul, just return");
      return;
      localb = this.jdField_a_of_type_Mye.c();
      if (localb != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "onActivityResult getCurrentPlayVideoParam = null, just return");
    return;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramIntent != null)
    {
      localObject1 = localObject2;
      if (paramIntent.getExtras() != null) {
        localObject1 = paramIntent.getExtras().getString("VIDEO_ARTICLE_ID");
      }
    }
    if (!TextUtils.equals(localb.akK, (CharSequence)localObject1))
    {
      paramIntent = b((String)localObject1);
      if (paramIntent == null)
      {
        l1 = localb.xb;
        paramInt = 0;
      }
    }
    for (;;)
    {
      label237:
      boolean bool;
      if ((i == 3) || (i == 0) || (i == 4))
      {
        bool = true;
        label254:
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult shouldContinuePlay = " + bool + ", playState=" + myh.bA(i) + ", startPosition=" + l1 + "，curPlayParam=" + localb);
        }
        if (!bool) {
          break label530;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult continue play");
        }
        if (paramInt == 0) {
          break label442;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult resume playResumeVideo:" + (String)localObject1);
        }
        a(paramIntent);
      }
      for (;;)
      {
        mzj.a().g(false, "readinoy video continuePlay", 1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.readinjoy.video", 2, "volumeControl set mute shouldContinuePlay");
        return;
        if (paramIntent.jdField_a_of_type_Mye$b != null) {
          paramIntent.jdField_a_of_type_Mye$b.xb = l1;
        }
        paramInt = 1;
        break label237;
        bool = false;
        break label254;
        label442:
        if ((l1 >= 0L) && (localb != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult resume with position:" + l1);
          }
          this.jdField_a_of_type_Mye.a((int)l1, localb);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult resume");
          }
          this.jdField_a_of_type_Mye.fK(true);
        }
      }
      label530:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult stop");
      }
      if (this.jdField_a_of_type_Lgf$c == null) {
        break;
      }
      long l2 = this.jdField_a_of_type_Mye.cZ();
      this.jdField_a_of_type_Mye.stop(4);
      paramIntent = this.jdField_a_of_type_Lgf$c.a();
      if (l1 > 0L) {
        l2 = l1;
      }
      paramIntent.xb = l2;
      if (l1 > 0L) {
        this.jdField_a_of_type_Lgf$c.a().aVT = -1;
      }
      this.jdField_a_of_type_Lgf$c = null;
      return;
      this.arC = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult for REFRESH_EVENT_CHECK_PLAYAREA");
      }
      aVU();
      j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 50);
      QLog.d("gifvideo.ReadInJoyBaseAdapter", 2, "check shortcontent play");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video", 2, "do nothing!");
      return;
      paramInt = 0;
      paramIntent = null;
    }
  }
  
  public void sN(int paramInt)
  {
    ad(paramInt, true);
  }
  
  public void setChannelType(int paramInt)
  {
    this.mChannelType = paramInt;
  }
  
  public void setData(List<BaseArticleInfo> paramList)
  {
    lgd.a(this.au, new ndy(this, "onSetData", paramList));
    StringBuilder localStringBuilder;
    if ((paramList != null) && (this.gO.getClass().isInstance(paramList)) && (paramList.size() > 0))
    {
      cW(paramList);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("setData ");
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
          localStringBuilder.append("recommendSeq = " + localBaseArticleInfo.mRecommendSeq + ",\n ");
        }
        QLog.d("ReadInJoyBaseAdapter", 1, localStringBuilder.toString());
      }
      this.gO.clear();
      this.gO.addAll(paramList);
      this.arB = true;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("setData:");
      if (paramList != null) {
        break label232;
      }
    }
    label232:
    for (int i = 0;; i = paramList.size())
    {
      QLog.d("ReadInJoyBaseAdapter", 2, i);
      this.qC = System.nanoTime();
      msv.a().a(this, this.gO);
      return;
    }
  }
  
  public void t(List<ArticleInfo> paramList, int paramInt)
  {
    this.gO.removeAll(paramList);
    this.arB = true;
    notifyDataSetChanged();
    int i = 0;
    if (i < paramList.size())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList.get(i);
      if (localArticleInfo == null) {}
      for (;;)
      {
        i += 1;
        break;
        long l1 = localArticleInfo.mRecommendSeq;
        if (lgy.aP(l1)) {
          lgy.a().F(this.mChannelID, l1);
        } else {
          lbz.a().b(this.mChannelID, localArticleInfo);
        }
      }
    }
    dg(this.mChannelID, paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static abstract interface b
  {
    public abstract void a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong);
  }
  
  public static abstract interface c
  {
    public abstract void onRefresh();
  }
  
  public static abstract interface d
  {
    public abstract void a(View paramView, ArticleInfo paramArticleInfo, int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract void azP();
  }
  
  public static class f
  {
    public Pair<Integer, Integer> c;
    public URL url;
    
    public static f a(URL paramURL, Pair<Integer, Integer> paramPair)
    {
      f localf = new f();
      localf.url = paramURL;
      localf.c = paramPair;
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ndi
 * JD-Core Version:    0.7.0.1
 */