import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout.a;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.10;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.6;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.8;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.9;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;

public class mza
  implements View.OnClickListener, VideoFeedsGestureLayout.a, AbsListView.e, msd.a, mye.a
{
  private URLImageView H;
  private KandianUrlImageView S;
  private KandianUrlImageView T;
  private ReadInJoyBaseListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView;
  private msd jdField_a_of_type_Msd;
  private mye jdField_a_of_type_Mye;
  private mza.c jdField_a_of_type_Mza$c;
  private articlesummary.VideoDownloadBarInfo jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo;
  private int aKI;
  private int aWo = -1;
  private int aWp = -1;
  protected int aWq;
  protected int aWr;
  private int aWs;
  public int aWt;
  private int aWu;
  private int aWv = 0;
  private FrameLayout ag;
  private boolean aoL;
  private boolean aqA;
  private boolean aqB;
  private boolean aqC;
  private boolean aqy;
  private boolean aqz;
  public kng.a b;
  private msx jdField_b_of_type_Msx;
  private mza.a jdField_b_of_type_Mza$a;
  private nca jdField_b_of_type_Nca;
  private ViewGroup bM;
  private ReadInJoyPatchAdView jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView;
  private VideoFeedsGestureLayout jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout;
  private VideoViewGroup jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup;
  private myc d;
  private int[] ds = new int[2];
  private LinearLayout ed;
  private KandianUrlImageView f;
  private RelativeLayout fj;
  private RelativeLayout fk;
  private SeekBar g;
  private SeekBar h;
  private View hY;
  private mye.b j;
  private List<mza.b> jK;
  private ImageView kg;
  private ImageView kh;
  private ImageView ki;
  private ImageView kj;
  private ImageView kk;
  private ImageView kl;
  private ArrayList<mza.c> lx = new ArrayList(10);
  private Activity mActivity;
  private boolean mInited;
  private int mOriginalHeight;
  private int mOriginalWidth;
  private RotateAnimation mRotateAnimation;
  private SeekBar.OnSeekBarChangeListener mSeekBarChangeListener = new mzf(this);
  private TextView mTitleTextView;
  private Handler mUIHandler = new mzb(this);
  private View mc;
  private View md;
  private View me;
  private TextView qi;
  private TextView sj;
  private TextView sp;
  private TextView sq;
  private TextView sr;
  private TextView ss;
  private TextView st;
  private TextView su;
  private TextView sv;
  private TextView sw;
  private TextView sx;
  private TextView sy;
  
  public mza(FrameLayout paramFrameLayout, ReadInJoyBaseListView paramReadInJoyBaseListView, Activity paramActivity)
  {
    this.ag = paramFrameLayout;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView = paramReadInJoyBaseListView;
    this.mActivity = paramActivity;
    this.jdField_b_of_type_Nca = new nca(this.ag, this);
    this.d = new myc(paramActivity, this.ag, new mzc(this));
    this.jdField_a_of_type_Msd = new msd(this.mActivity, this);
    this.jdField_b_of_type_Msx = new msx(paramActivity);
    paramFrameLayout = this.mActivity.getWindow();
    this.aWq = paramFrameLayout.getAttributes().flags;
    this.aWr = paramFrameLayout.getDecorView().getSystemUiVisibility();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.c(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.setScrollEventCallback(new mzd(this));
    this.mRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.mRotateAnimation.setDuration(1000L);
    this.mRotateAnimation.setRepeatCount(-1);
    this.mRotateAnimation.setRepeatMode(1);
    this.mRotateAnimation.setStartTime(-1L);
    paramFrameLayout = new LinearInterpolator();
    this.mRotateAnimation.setInterpolator(paramFrameLayout);
    this.hY = this.mActivity.findViewById(2131379798);
  }
  
  private boolean DT()
  {
    return this.kg.getVisibility() == 0;
  }
  
  private boolean EW()
  {
    return this.jdField_b_of_type_Nca.EW();
  }
  
  private boolean EY()
  {
    boolean bool = true;
    switch (this.aWv)
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (this.md == null) {
          break;
        }
      } while (this.md.getVisibility() == 0);
      return false;
      if (this.me == null) {
        break;
      }
    } while (this.me.getVisibility() == 0);
    return false;
  }
  
  private boolean EZ()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.H != null)
    {
      bool1 = bool2;
      if (this.H.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static Drawable a(Context paramContext, boolean paramBoolean)
  {
    int k;
    if (paramBoolean) {
      k = aqcx.dip2px(paramContext, 12.0F);
    }
    for (int i = aqcx.dip2px(paramContext, 60.0F);; i = aqcx.dip2px(paramContext, 28.0F))
    {
      return new afej(-2565928, k, i, i);
      k = aqcx.dip2px(paramContext, 6.0F);
    }
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    kwz.a(paramKandianUrlImageView, paramURL, this.mActivity, false);
  }
  
  private void a(boolean paramBoolean, mye.b paramb1, mye.b paramb2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.readinjoy.video.VideoUIManager", 2, "onScreenChange   isFullScreen:" + paramBoolean + "  enterPlayParam:" + paramb1 + "   exitPlayParam:" + paramb2);
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.d;
      int i = ndi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView, paramb1);
      this.aWt = i;
      ((myc)localObject).a(paramb1, i);
      aUi();
      if (this.jK != null) {
        localObject = this.jK.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          return;
        }
        mza.b localb = (mza.b)((Iterator)localObject).next();
        if (localb != null)
        {
          if (paramBoolean)
          {
            localb.aCk();
            continue;
            this.d.aTE();
            break;
          }
          localb.a(paramb1, paramb2);
        }
      }
    }
  }
  
  private void aUA()
  {
    int k = 0;
    if ((this.j == null) || (this.j.d == null) || (this.j.d.mVideoDownloadBarInfo == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), mVideoDownloadBarInfo == null, mPlayingVideoParam:" + this.j);
      }
    }
    int i;
    label244:
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo = this.j.d.mVideoDownloadBarInfo;
          i = k;
          if (!this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_style.has()) {
            break label244;
          }
          i = k;
          if (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_style.get() < 0) {
            break label244;
          }
          this.aWv = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_style.get();
          if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
            break;
          }
          this.aWv = 0;
        } while (!QLog.isColorLevel());
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), 协议字段不合法 1");
        return;
        i = k;
        if (this.aWv != 1) {
          break label244;
        }
        if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get() > 0)) {
          break;
        }
        this.aWv = 0;
      } while (!QLog.isColorLevel());
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), 协议字段不合法 2");
      return;
      i = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get();
    } while (!QLog.isColorLevel());
    QLog.i("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), mDownloadBarStyle:" + this.aWv + ", appearTime:" + i);
  }
  
  private void aUB()
  {
    if (this.aqC) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.video.VideoUIManager", 2, "checkIfShowDownloadBarPlaying(), mDownloadBarClicked, return");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Mye.cZ() / 1000L < this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get());
      if ((!DU()) && (!EX()) && (this.jdField_a_of_type_Mye.qc() == 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video.VideoUIManager", 2, "checkIfShowDownloadBarPlaying(): failure");
    return;
    sT(1);
  }
  
  private void aUC()
  {
    if (this.md == null)
    {
      this.md = ((ViewStub)this.ag.findViewById(2131366064)).inflate();
      this.S = ((KandianUrlImageView)this.md.findViewById(2131362848));
      this.su = ((TextView)this.md.findViewById(2131362849));
      this.md.setOnClickListener(this);
    }
    String str = kA();
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Object localObject = new URL(str);
        this.S.setImagePlaceHolder(a(this.mActivity, false)).setImage((URL)localObject);
        localObject = kB();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.su.setText((CharSequence)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBarPlaying(), iconUrl:" + str + "，iconText:" + (String)localObject);
        }
        this.md.setVisibility(0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.S.setBackgroundDrawable(a(this.mActivity, false));
    }
  }
  
  private void aUD()
  {
    Object localObject;
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null))
    {
      localObject = (articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get();
      if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() != 1) {
        break label247;
      }
      if (kxm.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
        kxm.aJ(this.mActivity, kxm.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
      }
      this.aqC = true;
      if ((this.j != null) && (this.j.d != null))
      {
        localObject = "";
        if (this.aWv != 1) {
          break label329;
        }
        localObject = "0X8009BC5";
      }
    }
    for (;;)
    {
      nce.a locala = new nce.a("", this.j.puin, this.j.videoVid, this.j.d.innerUniqueID);
      locala.a((int)this.j.channelId);
      if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
        locala.a(kxm.a(((articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get()).bytes_common_data));
      }
      kbp.a(null, "", (String)localObject, (String)localObject, 0, 0, "3", "", "", locala.a().toJsonString(), false);
      return;
      label247:
      if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() != 2) {
        break;
      }
      if ((kxm.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle)) && (aqiz.isAppInstalled(this.mActivity, kxm.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle))))
      {
        muj.aP(this.mActivity, kxm.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_schema));
        break;
      }
      if (!kxm.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
        break;
      }
      kxm.aJ(this.mActivity, kxm.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
      break;
      label329:
      if (this.aWv == 2) {
        localObject = "0X8009BC7";
      }
    }
  }
  
  private void aUE()
  {
    if (this.me == null)
    {
      this.me = ((ViewStub)this.ag.findViewById(2131366065)).inflate();
      this.T = ((KandianUrlImageView)this.me.findViewById(2131362848));
      this.sv = ((TextView)this.me.findViewById(2131362849));
      this.sw = ((TextView)this.me.findViewById(2131377130));
      this.sx = ((TextView)this.me.findViewById(2131366094));
      this.sw.setOnClickListener(this);
      this.sx.setOnClickListener(this);
      int i = aqcx.dip2px(this.mActivity, 16.0F);
      localObject1 = this.mActivity.getResources().getDrawable(2130843985);
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      this.sw.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localObject1 = this.mActivity.getResources().getDrawable(2130843903);
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      this.sx.setCompoundDrawables((Drawable)localObject1, null, null, null);
    }
    Object localObject1 = kA();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      try
      {
        Object localObject2 = new URL((String)localObject1);
        this.T.setImagePlaceHolder(a(this.mActivity, true)).setImage((URL)localObject2);
        localObject2 = kB();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.sv.setText((CharSequence)localObject2);
        }
        this.me.setVisibility(0);
        if (this.md != null) {
          this.md.setVisibility(8);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBarComplete(), iconUrl:" + (String)localObject1 + "，iconText:" + (String)localObject2);
        }
        this.f.setVisibility(0);
        this.fj.setVisibility(8);
        aUw();
        this.ed.setVisibility(8);
        this.h.setVisibility(8);
        this.fk.setVisibility(8);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.T.setBackgroundDrawable(a(this.mActivity, true));
    }
  }
  
  private void aUF()
  {
    sU(1);
    sU(2);
  }
  
  private void aUG()
  {
    if ((this.j == null) || (this.j.d == null)) {
      return;
    }
    if ((muj.Es()) && (!TextUtils.isEmpty(this.j.d.mVideoLogoUrl)))
    {
      Object localObject1 = this.j.d.mVideoLogoUrl;
      for (;;)
      {
        try
        {
          if (((String)localObject1).endsWith("zip"))
          {
            localObject1 = lae.a((String)localObject1);
            ((lae)localObject1).setRepeatCount(0);
            this.H.setImageDrawable((Drawable)localObject1);
            ((lae)localObject1).playAnimation();
            this.H.setVisibility(0);
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        Object localObject2 = new URL(localException);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = new afei(0, 50, 150);
        localURLDrawableOptions.mPlayGifImage = true;
        localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
        this.H.setImageDrawable((Drawable)localObject2);
      }
    }
    this.H.setVisibility(8);
  }
  
  private void aUe()
  {
    if (this.mInited) {
      return;
    }
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)this.ag.findViewById(2131381724));
    this.H = ((URLImageView)this.ag.findViewById(2131370907));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.ag.findViewById(2131367963));
    this.fj = ((RelativeLayout)this.ag.findViewById(2131379823));
    this.mTitleTextView = ((TextView)this.ag.findViewById(2131379769));
    this.mc = this.ag.findViewById(2131379850);
    this.qi = ((TextView)this.ag.findViewById(2131366156));
    this.f = ((KandianUrlImageView)this.ag.findViewById(2131368820));
    this.sp = ((TextView)this.ag.findViewById(2131373382));
    this.sy = ((TextView)this.ag.findViewById(2131372761));
    this.kg = ((ImageView)this.ag.findViewById(2131372700));
    this.sq = ((TextView)this.ag.findViewById(2131372701));
    this.sr = ((TextView)this.ag.findViewById(2131370088));
    this.h = ((SeekBar)this.ag.findViewById(2131372760));
    this.fk = ((RelativeLayout)this.ag.findViewById(2131371170));
    this.ed = ((LinearLayout)this.ag.findViewById(2131367813));
    this.ki = ((ImageView)this.ag.findViewById(2131367810));
    this.st = ((TextView)this.ag.findViewById(2131367812));
    this.sj = ((TextView)this.ag.findViewById(2131373694));
    this.g = ((SeekBar)this.ag.findViewById(2131369275));
    this.ss = ((TextView)this.ag.findViewById(2131366158));
    this.kh = ((ImageView)this.ag.findViewById(2131367811));
    this.kg.setOnClickListener(this);
    this.g.setOnSeekBarChangeListener(this.mSeekBarChangeListener);
    this.kh.setOnClickListener(this);
    this.ki.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(this.mActivity);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setSeekBar(this.g);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(this.jdField_b_of_type_Msx);
    this.kl = ((ImageView)this.ag.findViewById(2131381875));
    this.kj = ((ImageView)this.ag.findViewById(2131381874));
    this.kk = ((ImageView)this.ag.findViewById(2131381872));
    this.kl.setOnClickListener(this);
    this.kj.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView = ((ReadInJoyPatchAdView)this.ag.findViewById(2131372905));
    aUf();
    rpq.h(this.kl, 10, 10, 10, 10);
    rpq.h(this.kj, 20, 20, 20, 20);
    mzj.a().k(this.kl);
    mzj.a().k(this.kj);
    this.mInited = true;
  }
  
  private void aUf()
  {
    this.jdField_b_of_type_Kng$a = new mze(this);
    kng.a(this.mActivity, this, this.jdField_a_of_type_Mye, this.d, this.jdField_b_of_type_Mza$a, this.jdField_b_of_type_Kng$a);
  }
  
  private void aUg()
  {
    if (this.j == null) {}
    while (!(this.ag instanceof RoundAngleFrameLayout)) {
      return;
    }
    ((RoundAngleFrameLayout)this.ag).setRaduis(this.j.topLeftRadius, this.j.topRightRadius, this.j.bottomLeftRadius, this.j.bottomRightRadius);
  }
  
  private void aUh()
  {
    if ((this.ag instanceof RoundAngleFrameLayout)) {
      ((RoundAngleFrameLayout)this.ag).setRaduis(0, 0, 0, 0);
    }
  }
  
  private void aUi()
  {
    if (EV())
    {
      aUh();
      return;
    }
    aUg();
  }
  
  private void aUj()
  {
    if (this.j == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "innerConfigVideoUI() mPlayingVideoParam == null ERROR");
      }
      return;
    }
    this.mTitleTextView.setText(this.j.d.mTitle);
    this.st.setText(this.j.d.mTitle);
    this.st.getPaint().setFakeBoldText(true);
    this.mTitleTextView.getPaint().setFakeBoldText(true);
    this.mTitleTextView.setTextColor(this.mActivity.getResources().getColor(2131167654));
    if (this.j.aqp) {
      this.mTitleTextView.setVisibility(8);
    }
    if (this.j.d.mVideoPlayCount == 0)
    {
      this.sp.setVisibility(8);
      label141:
      if (this.j.videoDuration > 0) {
        break label432;
      }
      this.ss.setText("");
      label161:
      lgf.a(this.mActivity, this.f, this.j);
      a(this.f, this.j.d.getVideoCoverUrlWithSmartCut(false));
      if (this.j.d.mXGFileSize <= 0L) {}
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(this.j.channelId);
      if (!aqiw.isWifiConnected(this.mActivity)) {
        break label452;
      }
      this.kg.clearAnimation();
      this.kg.setVisibility(0);
      this.kg.setImageDrawable(this.mActivity.getResources().getDrawable(2130844049));
      this.kg.setTag(Integer.valueOf(1));
      this.sq.setVisibility(8);
    }
    for (;;)
    {
      aUk();
      this.h.setMax(this.j.videoDuration);
      this.g.setMax(this.j.videoDuration);
      resetUI();
      sO(this.j.aVV);
      aUi();
      this.ag.setVisibility(0);
      if (this.j.d.patchStatus.U.get() != 1) {
        kng.a(this);
      }
      if ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView == null) || (!this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.Ag()) || (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.b() == null) || (this.j == this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.b())) {
        break;
      }
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.onCompletion();
      return;
      this.sp.setVisibility(0);
      break label141;
      label432:
      this.ss.setText(kwz.ba(this.j.videoDuration));
      break label161;
      label452:
      this.kg.clearAnimation();
      this.kg.setVisibility(8);
      Drawable localDrawable = this.mActivity.getResources().getDrawable(2130843983);
      this.sq.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.sq.setCompoundDrawablePadding(wja.dp2px(6.0F, this.mActivity.getResources()));
      this.sq.setVisibility(0);
      if (aqux.Mv() != 1) {}
    }
  }
  
  private void aUl()
  {
    this.j.b = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup;
  }
  
  private void aUq()
  {
    this.ag.setTranslationY(0.0F);
    hideTitle();
    aRm();
    this.h.setVisibility(8);
    ViewGroup.LayoutParams localLayoutParams = this.ag.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    this.ag.setLayoutParams(localLayoutParams);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.pL(false);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(true);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.resetUI();
    this.jdField_a_of_type_Mye.setXYaxis(0);
    this.ag.setBackgroundColor(-16777216);
    oS(true);
  }
  
  private void aUr()
  {
    Object localObject = this.jdField_a_of_type_Mye.c();
    String str1;
    String str2;
    if (localObject != null)
    {
      localObject = ((mye.b)localObject).d;
      if (localObject != null)
      {
        str1 = new nce.a(null, ((BaseArticleInfo)localObject).getSubscribeUin(), ((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).getInnerUniqueID(), this.jdField_a_of_type_Mye.cZ(), ((BaseArticleInfo)localObject).getVideoDuration() * 1000L).a((int)((BaseArticleInfo)localObject).mChannelID).a().toJsonString();
        str2 = ((BaseArticleInfo)localObject).getSubscribeUin();
        if (TextUtils.isEmpty(((BaseArticleInfo)localObject).getInnerUniqueID())) {
          break label115;
        }
      }
    }
    label115:
    for (localObject = ((BaseArticleInfo)localObject).getInnerUniqueID();; localObject = "0")
    {
      kbp.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", (String)localObject, str1, false);
      return;
    }
  }
  
  private void aUs()
  {
    if ((this.j == null) || (this.j.d == null)) {}
    do
    {
      return;
      if (this.j.ma != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.readinjoy.video.VideoUIManager", 2, "showXGToast failed for mPlayingVideoParam.feedsVideoCover is null");
    return;
    if (aqux.Mv() == 1) {}
    for (;;)
    {
      int[] arrayOfInt = new int[2];
      this.j.ma.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1] - ImmersiveUtils.getStatusBarHeight(this.mActivity);
      i = (i + (this.j.ma.getHeight() + i) - aqcx.dip2px(this.mActivity, 40.0F)) / 2;
      muj.showToast(this.mActivity, null, i);
      return;
      if (this.j.d.mXGFileSize <= 0L) {}
    }
  }
  
  private void aUt()
  {
    this.f.clearAnimation();
    this.f.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.f.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    this.f.setLayoutParams(localLayoutParams);
    a(this.f, this.j.d.getVideoCoverUrlWithSmartCut(false));
  }
  
  private void aUu()
  {
    this.f.clearAnimation();
    this.f.setVisibility(8);
    this.jdField_b_of_type_Nca.aVr();
    this.h.setVisibility(0);
  }
  
  private void aUv()
  {
    if (this.jdField_a_of_type_Mye != null) {}
    for (int i = (int)(this.jdField_a_of_type_Mye.cZ() / 1000L);; i = 0)
    {
      klv.a(i, this.jdField_a_of_type_Mye);
      if (this.h.isEnabled())
      {
        if (this.h.getVisibility() != 0) {
          this.h.setVisibility(0);
        }
        this.h.setProgress(i);
      }
      if ((this.g.getVisibility() == 0) && (this.g.isEnabled())) {
        this.g.setProgress(i);
      }
      if (this.sj.getVisibility() == 0) {
        this.sj.setText(kwz.ba(i));
      }
      if ((this.jdField_a_of_type_Mza$c != null) && (this.j != null) && (this.jdField_a_of_type_Mye != null)) {
        this.jdField_a_of_type_Mza$c.a(this.jdField_a_of_type_Mye.c(), (int)this.jdField_a_of_type_Mye.cZ(), this.j.videoDuration * 1000);
      }
      if ((this.j != null) && (this.jdField_a_of_type_Mye != null))
      {
        Iterator localIterator = this.lx.iterator();
        while (localIterator.hasNext()) {
          ((mza.c)localIterator.next()).a(this.jdField_a_of_type_Mye.c(), (int)this.jdField_a_of_type_Mye.cZ(), this.j.videoDuration * 1000);
        }
        muj.a(this.sy, this.jdField_a_of_type_Mye.b(this.j.getInnerUniqueID()));
      }
      return;
    }
  }
  
  private void aUw()
  {
    this.sq.setVisibility(8);
    this.kg.clearAnimation();
    this.kg.setVisibility(8);
    this.mUIHandler.removeMessages(103);
  }
  
  private void aUx()
  {
    if (this.j != null)
    {
      Object localObject = this.j.d;
      if (localObject != null)
      {
        localObject = new nce.a(null, this.j.puin, ((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).getInnerUniqueID()).a((int)((BaseArticleInfo)localObject).mChannelID).a().toJsonString();
        kbp.a(null, "", "0X8009505", "0X8009505", 0, 0, "", this.d.kw(), "", (String)localObject, false);
      }
    }
  }
  
  private void aUy()
  {
    if (this.h == null) {
      return;
    }
    this.h.setEnabled(true);
    int i = 0;
    if (this.jdField_a_of_type_Mye != null) {
      i = (int)(this.jdField_a_of_type_Mye.cZ() / 1000L);
    }
    this.h.setProgress(i);
  }
  
  private void aUz()
  {
    int i = 0;
    if (this.sj != null) {
      this.sj.setVisibility(0);
    }
    if (this.ss != null) {
      this.ss.setVisibility(0);
    }
    if (this.kk != null) {
      this.kk.setVisibility(8);
    }
    if (this.kj != null) {
      this.kj.setVisibility(0);
    }
    if (this.g != null)
    {
      this.g.setEnabled(true);
      if (this.jdField_a_of_type_Mye != null) {
        i = (int)(this.jdField_a_of_type_Mye.cZ() / 1000L);
      }
      this.g.setProgress(i);
    }
    if (this.mUIHandler != null) {
      this.mUIHandler.sendEmptyMessageDelayed(101, 3000L);
    }
  }
  
  private void hideTitle()
  {
    muj.a(this.fj, 8, 300);
    this.fk.setVisibility(8);
    muj.a(this.kg, 8, 300);
    if (EV()) {
      this.h.setVisibility(8);
    }
    for (;;)
    {
      if (!muj.Er()) {
        muj.a(this.fj, 8, 300);
      }
      return;
      this.h.setVisibility(0);
    }
  }
  
  private void j(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setVisibility(0);
    if (mzj.a().isMute())
    {
      paramImageView.setImageResource(2130843886);
      return;
    }
    paramImageView.setImageResource(2130843887);
  }
  
  private String kA()
  {
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (kxm.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_url))) {
      return kxm.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_url);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "getDownloadIconUrl(), null:");
    }
    return null;
  }
  
  private String kB()
  {
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (kxm.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_text))) {
      return kxm.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_text);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "getDownloadIconText(), null:");
    }
    return null;
  }
  
  private void oR(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.kh.setImageDrawable(this.mActivity.getResources().getDrawable(2130842612));
      return;
    }
    this.kh.setImageDrawable(this.mActivity.getResources().getDrawable(2130842613));
  }
  
  private void oS(boolean paramBoolean)
  {
    if (!EZ()) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.H.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.width = aqcx.dip2px(this.mActivity, 91.0F);
      localLayoutParams.height = aqcx.dip2px(this.mActivity, 28.0F);
      localLayoutParams.rightMargin = aqcx.dip2px(this.mActivity, 16.0F);
    }
    for (localLayoutParams.topMargin = aqcx.dip2px(this.mActivity, 16.0F);; localLayoutParams.topMargin = aqcx.dip2px(this.mActivity, 8.0F))
    {
      this.H.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = aqcx.dip2px(this.mActivity, 78.0F);
      localLayoutParams.height = aqcx.dip2px(this.mActivity, 24.0F);
      localLayoutParams.rightMargin = aqcx.dip2px(this.mActivity, 8.0F);
    }
  }
  
  private void resetData()
  {
    mst.anQ = false;
    this.aqC = false;
    this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo = null;
    this.aWv = 0;
  }
  
  private void resetUI()
  {
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.resetUI();
    this.f.setVisibility(0);
    this.fj.setVisibility(0);
    this.mc.setVisibility(0);
    aRm();
    aUu();
    this.h.setVisibility(8);
    this.qi.setVisibility(8);
    aUF();
    aUy();
    this.g.setEnabled(true);
    this.H.setVisibility(8);
  }
  
  private void sO(int paramInt)
  {
    if (paramInt == 1)
    {
      this.mTitleTextView.setVisibility(8);
      this.mc.setVisibility(8);
      this.sp.setVisibility(8);
    }
    for (;;)
    {
      if (EV())
      {
        this.fj.setVisibility(8);
        this.sp.setVisibility(8);
      }
      return;
      this.mTitleTextView.setVisibility(0);
      this.mc.setVisibility(0);
      this.sp.setVisibility(0);
    }
  }
  
  private void sR(int paramInt)
  {
    if (this.h.getVisibility() != 0) {
      this.h.setVisibility(0);
    }
    this.h.setEnabled(false);
    this.h.setProgress(paramInt);
    this.mUIHandler.removeMessages(104);
    this.mUIHandler.sendEmptyMessageDelayed(104, 1500L);
  }
  
  private void sS(int paramInt)
  {
    if (this.kj.getVisibility() != 8) {
      this.kj.setVisibility(8);
    }
    if (this.kk.getVisibility() != 0)
    {
      this.kk.setVisibility(0);
      this.kk.setImageResource(2130844000);
    }
    if (paramInt == 0) {
      this.kk.setEnabled(false);
    }
    for (;;)
    {
      if (this.sj.getVisibility() != 8) {
        this.sj.setVisibility(8);
      }
      if (this.ss.getVisibility() != 8) {
        this.ss.setVisibility(8);
      }
      this.g.setEnabled(false);
      this.g.setProgress(paramInt);
      this.mUIHandler.removeMessages(101);
      this.mUIHandler.removeMessages(105);
      this.mUIHandler.sendEmptyMessageDelayed(105, 1500L);
      return;
      this.kk.setEnabled(true);
    }
  }
  
  private void sT(int paramInt)
  {
    if (EY()) {}
    do
    {
      return;
      if (!this.aqC) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBar(): mDownloadBarClicked, just jump.");
    return;
    label56:
    String str;
    switch (paramInt)
    {
    default: 
      if ((this.j != null) && (this.j.d != null))
      {
        str = "";
        if (this.aWv != 1) {
          break label270;
        }
        str = "0X8009BC4";
      }
      break;
    }
    for (;;)
    {
      nce.a locala = new nce.a("", this.j.puin, this.j.videoVid, this.j.d.innerUniqueID);
      locala.a((int)this.j.channelId);
      if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
        locala.a(kxm.a(((articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get()).bytes_common_data));
      }
      kbp.a(null, "", str, str, 0, 0, "3", "", "", locala.a().toJsonString(), false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBar(), barStyle:" + paramInt);
      return;
      aUC();
      break label56;
      aUE();
      break label56;
      label270:
      if (this.aWv == 2) {
        str = "0X8009BC6";
      }
    }
  }
  
  private void sU(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.md == null);
      this.md.setVisibility(8);
      return;
    } while (this.me == null);
    this.me.setVisibility(8);
  }
  
  private void si(int paramInt)
  {
    if (this.sq.getVisibility() == 0) {
      muj.a(this.sq, 8, 300);
    }
    this.mUIHandler.removeMessages(103);
    this.kg.clearAnimation();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.kg.setImageDrawable(this.mActivity.getResources().getDrawable(2130844049));
        this.kg.setTag(Integer.valueOf(1));
      } while (DT());
      muj.a(this.kg, 0, 300);
      return;
      this.kg.setVisibility(0);
      this.kg.startAnimation(this.mRotateAnimation);
      this.kg.setImageDrawable(this.mActivity.getResources().getDrawable(2130844047));
      this.kg.setTag(Integer.valueOf(3));
      return;
      this.kg.setImageDrawable(this.mActivity.getResources().getDrawable(2130844048));
      this.kg.setTag(Integer.valueOf(2));
    } while (DT());
    muj.a(this.kg, 0, 300);
  }
  
  public boolean DU()
  {
    if (this.fk == null) {}
    while (this.fk.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public boolean EV()
  {
    if (this.ag.getVisibility() != 0) {
      return false;
    }
    return this.aoL;
  }
  
  public boolean EX()
  {
    if (this.fj == null) {}
    while (this.fj.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public void G(View paramView, int paramInt)
  {
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
        } while (!DU());
        aRm();
      } while (!this.jdField_a_of_type_Mye.isPause());
      this.aqB = true;
      return;
    } while (!this.aqB);
    aRo();
    this.aqB = false;
  }
  
  public ReadInJoyPatchAdView a()
  {
    return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView;
  }
  
  public void a(myc.b paramb)
  {
    this.d.a(paramb);
  }
  
  public void a(mye.b paramb, myi parammyi, int paramInt1, int paramInt2, Object paramObject)
  {
    boolean bool = true;
    if ((this.j == null) || (paramb == null) || (this.j != paramb)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "onStateChange(): mPlayingVideoParam and videoPlayParam not equal, just return;");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramInt2 == 0)
              {
                if (paramInt1 == 3)
                {
                  if (EV()) {
                    oH(false);
                  }
                  stop();
                  return;
                }
                stop();
                return;
              }
              if (paramInt2 == 1)
              {
                this.fk.setVisibility(8);
                this.mUIHandler.removeMessages(103);
                this.mUIHandler.sendEmptyMessageDelayed(103, 1200L);
                this.mUIHandler.removeMessages(100);
                this.h.setVisibility(8);
                this.kl.setVisibility(8);
                return;
              }
              if (paramInt2 == 2)
              {
                if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1) != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag() instanceof lgf.f)))
                {
                  parammyi = (lgf.f)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag();
                  if ((parammyi != null) && (parammyi.pt != null) && (parammyi.position == 0))
                  {
                    this.sr.setVisibility(8);
                    parammyi.pt.setVisibility(8);
                    if (QLog.isColorLevel()) {
                      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "隐藏大王卡引导Textview");
                    }
                  }
                }
                kng.a(paramb, this, false, this.jdField_b_of_type_Kng$a);
                return;
              }
              if (paramInt2 != 3) {
                break;
              }
              this.mUIHandler.removeMessages(103);
              this.mUIHandler.sendEmptyMessage(102);
              if (paramInt1 == 2)
              {
                if (this.j.aqp) {
                  this.f.setVisibility(8);
                }
                for (;;)
                {
                  this.j.a.am().setBackgroundColor(this.mActivity.getResources().getColor(2131165381));
                  aUw();
                  this.mUIHandler.removeMessages(100);
                  this.mUIHandler.sendEmptyMessageDelayed(100, 3000L);
                  if ((aqiw.isMobileNetWork(this.mActivity)) && (!this.aqA))
                  {
                    aUs();
                    this.aqA = true;
                  }
                  j(this.kl);
                  if ((this.j.aqp) && (this.kl != null)) {
                    this.kl.setVisibility(8);
                  }
                  aUA();
                  aUG();
                  return;
                  muj.a(this.f, 8, 300);
                }
              }
              if (paramInt1 == 4)
              {
                aUw();
                return;
              }
            } while (paramInt1 != 5);
            if ((DT()) && (DU()))
            {
              si(2);
              this.mUIHandler.removeMessages(101);
              this.mUIHandler.sendEmptyMessageDelayed(101, 3000L);
              return;
            }
            if (!EW()) {
              break;
            }
            aUu();
          } while (!aqiw.isMobileNetWork(this.mActivity));
          aUs();
          return;
        } while (!this.j.aqp);
        this.kg.clearAnimation();
        this.kg.setVisibility(8);
        return;
        if (paramInt2 == 4)
        {
          if (paramInt1 == 0)
          {
            this.fk.setVisibility(8);
            aUu();
            si(3);
            this.h.setVisibility(8);
          }
          for (;;)
          {
            this.mUIHandler.removeMessages(102);
            this.mUIHandler.removeMessages(103);
            return;
            if (paramInt1 == 3) {
              si(3);
            }
          }
        }
        if (paramInt2 == 5)
        {
          if (DT()) {
            si(1);
          }
          if (this.j.aqp) {
            si(1);
          }
          this.mUIHandler.removeMessages(100);
          this.mUIHandler.removeMessages(101);
          this.mUIHandler.removeMessages(102);
          this.mUIHandler.removeMessages(103);
          return;
        }
        if (paramInt2 != 6) {
          break;
        }
        this.mUIHandler.removeMessages(102);
        this.mUIHandler.removeMessages(101);
        this.mUIHandler.removeMessages(103);
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
      } while (!(paramObject instanceof int[]));
      paramb = (int[])paramObject;
      return;
    } while (paramInt2 != 7);
    if ((!kwz.b(paramb)) && (this.d.EN()) && (this.j.aqq))
    {
      this.d.b(paramb);
      return;
    }
    if (this.aWv == 2)
    {
      mst.anQ = true;
      sT(2);
      this.mUIHandler.removeCallbacksAndMessages(null);
      label822:
      if (paramb.d.patchStatus.U.get() == 1) {
        break label908;
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getFirstVisiblePosition() != 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1) == null) || (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag() instanceof lgf.f))) {
        break label910;
      }
    }
    for (;;)
    {
      kng.a(paramb, this, bool, false, this.jdField_b_of_type_Mza$a, this.d, this.jdField_b_of_type_Kng$a);
      return;
      oH(false);
      stop();
      break label822;
      label908:
      break;
      label910:
      bool = false;
    }
  }
  
  public void a(mye parammye)
  {
    this.jdField_a_of_type_Mye = parammye;
    this.jdField_a_of_type_Mye.a(this);
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout == null) {
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.ag.findViewById(2131367963));
    }
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_Mye.db());
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(parammye);
    this.d.a(parammye);
  }
  
  public void a(myi parammyi, mye.b paramb) {}
  
  public void a(mza.a parama)
  {
    this.jdField_b_of_type_Mza$a = parama;
  }
  
  public void a(mza.b paramb)
  {
    if (this.jK == null) {
      this.jK = new ArrayList();
    }
    if (!this.jK.contains(paramb)) {
      this.jK.add(paramb);
    }
  }
  
  public void a(mza.c paramc)
  {
    this.jdField_a_of_type_Mza$c = paramc;
  }
  
  public void aRZ() {}
  
  public void aRm()
  {
    if ((this.fk == null) || (this.fk.getVisibility() != 0)) {
      return;
    }
    muj.a(this.fj, 8, 300);
    this.kg.clearAnimation();
    muj.a(this.kg, 8, 300);
    muj.a(this.fk, 8, 300);
    if ((EV()) || (7 == this.jdField_a_of_type_Mye.qc())) {
      this.h.setVisibility(8);
    }
    for (;;)
    {
      this.g.setEnabled(true);
      return;
      this.h.setVisibility(0);
    }
  }
  
  public void aRo()
  {
    if ((this.fk == null) || (this.fk.getVisibility() == 0)) {
      return;
    }
    int i;
    if (EV())
    {
      this.ed.setVisibility(0);
      this.kk.setVisibility(8);
      this.kj.setVisibility(8);
      i = this.jdField_a_of_type_Mye.qc();
      if (i != 5) {
        break label232;
      }
      si(1);
      label69:
      this.jdField_b_of_type_Nca.aVq();
      muj.a(this.fk, 0, 300);
      if (!this.aqy)
      {
        rpq.h(this.kh, 10, 10, 10, 10);
        this.aqy = true;
      }
      this.h.setVisibility(8);
      this.kl.setVisibility(8);
      this.mUIHandler.removeMessages(100);
      aUF();
      if (i != 5) {
        break label245;
      }
      this.mUIHandler.removeMessages(101);
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new VideoUIManager.6(this));
      return;
      this.ed.setVisibility(8);
      this.mc.setVisibility(8);
      if (this.fj.getVisibility() != 0) {
        muj.a(this.fj, 0, 300);
      }
      this.kk.setVisibility(8);
      j(this.kj);
      break;
      label232:
      if (i != 3) {
        break label69;
      }
      si(2);
      break label69;
      label245:
      if (i == 3)
      {
        this.mUIHandler.removeMessages(101);
        this.mUIHandler.sendEmptyMessageDelayed(101, 3000L);
      }
    }
  }
  
  public void aUc()
  {
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView != null) {
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.onPause();
    }
  }
  
  public void aUd()
  {
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView != null) {
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.onPause();
    }
  }
  
  public void aUk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "updateVideoViewSize");
    }
    if (this.j == null) {
      return;
    }
    float f1 = aqgz.aM(this.mActivity);
    if (this.j.aqp) {
      if (this.j.aVU > 0) {
        f1 = this.j.aVU;
      }
    }
    float f2;
    for (;;)
    {
      f2 = f1 * kwz.c(this.j.videoWidth, this.j.videoHeight);
      if (!this.d.EN()) {
        break;
      }
      this.mOriginalWidth = ((int)f1);
      this.mOriginalHeight = ((int)f2);
      aUq();
      return;
      continue;
      f1 = kwz.a(this.mActivity, this.j);
    }
    Object localObject;
    if ((this.ag.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      localObject = (FrameLayout.LayoutParams)this.ag.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = ((int)f1);
      ((FrameLayout.LayoutParams)localObject).height = ((int)f2);
      ((FrameLayout.LayoutParams)localObject).gravity = 1;
      this.ag.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.pL(true);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, kwz.c(this.j.videoWidth, this.j.videoHeight));
      return;
      if ((this.ag.getLayoutParams() instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)this.ag.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).width = ((int)f1);
        ((RelativeLayout.LayoutParams)localObject).height = ((int)f2);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        this.ag.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  @TargetApi(11)
  public void aUm()
  {
    if (this.ag.getVisibility() != 0) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((this.aoL) || (this.j == null) || (this.j.ma == null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getLocationOnScreen(this.ds);
      this.aKI = this.ds[1];
      this.j.ma.getLocationOnScreen(this.ds);
      i = this.ds[1] - this.aKI;
    } while (i == this.ag.getTranslationY());
    adzw.setTranslationY(this.ag, i);
  }
  
  public void aUn()
  {
    if (this.ag != null) {
      this.ag.setVisibility(8);
    }
  }
  
  public void aUo()
  {
    ae(0, true);
  }
  
  public void aUp()
  {
    oH(true);
  }
  
  public void ae(int paramInt, boolean paramBoolean)
  {
    if (this.ag.getVisibility() != 0) {}
    int i;
    do
    {
      do
      {
        return;
        i = this.jdField_a_of_type_Mye.qc();
        if ((i != 0) && (i != 1) && (i != 7) && (i != 2) && (i != 4)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "innerEnterFullScreen => playState=" + myh.bA(i) + ", illegal state just ignore fullscreen.");
      return;
    } while (this.aoL);
    this.aoL = true;
    a(true, this.jdField_a_of_type_Mye.c(), null);
    oR(true);
    this.aWs = this.jdField_a_of_type_Mye.qd();
    if ((paramBoolean) && (kwz.b(this.j))) {
      if (this.jdField_a_of_type_Msd.enable(false)) {
        this.aqz = true;
      }
    }
    for (;;)
    {
      Window localWindow = this.mActivity.getWindow();
      localWindow.setFlags(1024, 1024);
      if ((this.ag != null) && ((this.ag.getParent() instanceof ViewGroup)))
      {
        this.bM = ((ViewGroup)this.ag.getParent());
        this.aWu = this.bM.indexOfChild(this.ag);
        this.j.a.doCacheSurfaceTexture();
        this.bM.removeView(this.ag);
        this.j.a.doRecoverSurfaceTexture();
        localWindow.addContentView(this.ag, new ViewGroup.LayoutParams(-1, -1));
      }
      this.mOriginalWidth = this.ag.getWidth();
      this.mOriginalHeight = this.ag.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "FullScreen => mOriginalWidth=" + this.mOriginalWidth + ", mOriginalHeight=" + this.mOriginalHeight + ", playState=" + myh.bA(i) + "，userClickEnter:" + paramBoolean);
      }
      aUq();
      this.ag.setTranslationY(0.0F);
      aUr();
      return;
      if (paramInt != 0) {}
    }
  }
  
  public void b(mza.c paramc)
  {
    this.lx.add(paramc);
  }
  
  public void cS(View paramView) {}
  
  public void cW(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof lgf.c))) {}
    do
    {
      lgf.c localc;
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              return;
              i = this.jdField_a_of_type_Mye.qc();
              localc = (lgf.c)paramView.getTag();
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  playState=" + myh.bA(i) + ", view id: " + muj.j(paramView));
              }
              if ((i != 7) || (!EY())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.w("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  complete && isDownloadBarShowing, just return.");
            return;
            if (this.jdField_a_of_type_Mye.c() != null) {
              break;
            }
            if (!mst.a().nW()) {
              mzj.a().g(false, "noAutoPlayClickVideoInReadInjoy", 1);
            }
            this.jdField_a_of_type_Mye.a(localc.a());
            paramView = localc.a().d;
          } while ((paramView == null) || (paramView.mChannelID != 56L) || (!AdvertisementInfo.isAdvertisementInfo(paramView)));
          ((AdvertisementInfo)paramView).adbt = ((int)localc.a().xb);
          ((AdvertisementInfo)paramView).adpa = 1;
          ((AdvertisementInfo)paramView).adpb = 2;
          jzk.a(new kku.a().a(this.mActivity).a(jzk.aEO).b(jzk.aFx).a((AdvertisementInfo)paramView).a(jzk.a(((AdvertisementInfo)paramView).adbt, 0, ((AdvertisementInfo)paramView).getAdbf(), 0, 1, 2, paramView.mVideoDuration, jzk.aGs, 0)).a());
          return;
          if (this.jdField_a_of_type_Mye.da() != localc.a().articleID) {
            break;
          }
        } while (i == 1);
        if ((i != 5) || (!EW())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  paused && isErrorLayoutShowing, just return.");
      return;
      if (DU())
      {
        aRm();
        return;
      }
      aRo();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  点击非当前播放的视频feeds，播放点击的视频");
      }
      this.jdField_a_of_type_Mye.stop(2);
      this.jdField_a_of_type_Mye.a(localc.a());
      paramView = localc.a().d;
      if ((paramView != null) && (paramView.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramView)))
      {
        jzk.a(new kku.a().a(this.mActivity).a(jzk.aEO).b(jzk.aFx).a((AdvertisementInfo)paramView).a(jzk.a(0, 0, 1, 0, 1, 2, paramView.mVideoDuration, jzk.aGs, 0)).a());
        ((AdvertisementInfo)paramView).adbt = 0;
        ((AdvertisementInfo)paramView).adpa = 1;
        ((AdvertisementInfo)paramView).adpb = 2;
      }
    } while (mst.a().nW());
    mzj.a().g(false, "noAutoPlayClickVideoInReadInjoy", 1);
  }
  
  public void cb(View paramView)
  {
    if (DU())
    {
      aRm();
      return;
    }
    aRo();
  }
  
  public mye.b d()
  {
    return this.j;
  }
  
  public void d(mye.b paramb)
  {
    this.j = paramb;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "playVideo(): videoPlayParam=" + paramb);
    }
    if ((this.j != null) && (this.j.aqp))
    {
      oQ(false);
      this.aqz = false;
    }
    aUe();
    aUj();
    aUl();
    aUm();
  }
  
  public void destory()
  {
    if (this.d != null)
    {
      this.d.doOnDestroy();
      this.d = null;
    }
    this.jdField_a_of_type_Mye.b(this);
    this.mUIHandler.removeCallbacksAndMessages(null);
    this.j = null;
    if (this.jdField_a_of_type_Msd != null)
    {
      this.jdField_a_of_type_Msd.destory();
      this.jdField_a_of_type_Msd = null;
    }
    this.aqz = false;
    if (this.jdField_b_of_type_Msx != null) {
      this.jdField_b_of_type_Msx.doOnDestory();
    }
    if (this.jdField_b_of_type_Kng$a != null) {
      this.jdField_b_of_type_Kng$a = null;
    }
  }
  
  public void doOnPause()
  {
    this.d.aTH();
  }
  
  public void doOnResume()
  {
    this.d.aTG();
    if (this.aqC) {
      sU(1);
    }
    if (d() != null)
    {
      BaseArticleInfo localBaseArticleInfo = d().d;
      if (((kng.e(localBaseArticleInfo)) || (kng.f(localBaseArticleInfo))) && (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView != null)) {
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.onResume();
      }
      if (kng.c(localBaseArticleInfo)) {
        this.jdField_a_of_type_Mye.a(d());
      }
      if ((kng.d(localBaseArticleInfo)) && (this.jdField_b_of_type_Mza$a != null))
      {
        this.jdField_b_of_type_Mza$a.a(d());
        this.d.aTG();
      }
    }
  }
  
  public void f(AbsListView paramAbsListView)
  {
    if (EV()) {}
    int m;
    int k;
    int i;
    do
    {
      do
      {
        return;
        m = ((ReadInJoyBaseListView)paramAbsListView).getHeaderViewsCount();
        k = paramAbsListView.getFirstVisiblePosition() - m;
        i = k;
        if (k < 0) {
          i = 0;
        }
        k = paramAbsListView.getLastVisiblePosition() - m;
      } while ((this.jdField_a_of_type_Mye == null) || (this.jdField_a_of_type_Mye.c() == null));
      m = this.jdField_a_of_type_Mye.c().position;
    } while ((m < 0) || ((m >= i) && (m <= k)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "triggerVideoRecycleCheck => stop video，firstVisblePosi:" + i + ",lastVisiblePosi:" + k + ",playingPosi:" + m);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "triggerVideoRecycleCheck => stop video，playParam:" + this.jdField_a_of_type_Mye.c());
    }
    this.jdField_a_of_type_Mye.stop(10);
  }
  
  public void l(View paramView, int paramInt1, int paramInt2) {}
  
  public void oH(boolean paramBoolean)
  {
    if (this.ag.getVisibility() != 0) {}
    while (!this.aoL) {
      return;
    }
    this.aoL = false;
    this.d.aTF();
    oR(false);
    Object localObject = this.mActivity.getWindow();
    ((Window)localObject).clearFlags(1024);
    ((Window)localObject).addFlags(this.aWq);
    ((Window)localObject).getDecorView().setSystemUiVisibility(this.aWr);
    if ((this.ag != null) && ((this.ag.getParent() instanceof ViewGroup)))
    {
      this.j.a.doCacheSurfaceTexture();
      ((ViewGroup)this.ag.getParent()).removeView(this.ag);
      this.j.a.doRecoverSurfaceTexture();
      this.bM.addView(this.ag, this.aWu, new ViewGroup.LayoutParams(-1, -1));
      this.bM = null;
    }
    aRm();
    localObject = this.ag.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.mOriginalWidth;
    ((ViewGroup.LayoutParams)localObject).height = this.mOriginalHeight;
    this.ag.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.pL(true);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(false);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.resetUI();
    if (this.aqz) {
      this.jdField_a_of_type_Msd.enable(true);
    }
    this.jdField_a_of_type_Mye.setXYaxis(this.aWs);
    this.ag.setBackgroundColor(0);
    if ((this.d.a() != null) && ((this.d.a() instanceof mye.b))) {
      a(false, (mye.b)this.d.a(), this.j);
    }
    oS(false);
    if (paramBoolean) {
      aUx();
    }
    aUk();
    aUm();
  }
  
  public void oQ(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Msd != null) {
      this.jdField_a_of_type_Msd.enable(paramBoolean);
    }
    if ((this.jdField_a_of_type_Msd != null) && (this.j != null) && (this.j.aqp))
    {
      this.jdField_a_of_type_Msd.enable(false);
      this.aqz = false;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    int k = this.jdField_a_of_type_Mye.qc();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onClick(): current playState=" + myh.bA(k) + ", view id: " + muj.j(paramView));
    }
    if (paramView.getId() == 2131367811) {
      if (EV())
      {
        oH(false);
        ThreadManager.executeOnSubThread(new VideoUIManager.8(this));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aUo();
      break;
      if (paramView.getId() == 2131372700)
      {
        k = ((Integer)paramView.getTag()).intValue();
        switch (k)
        {
        }
        for (;;)
        {
          if (2 == k) {
            i = 1;
          }
          ThreadManager.executeOnSubThread(new VideoUIManager.9(this, i));
          break;
          if (!mst.a().nW()) {
            mzj.a().g(false, "noAutoPlayClickVideoInReadInjoy", 1);
          }
          this.jdField_a_of_type_Mye.fK(true);
          continue;
          this.jdField_a_of_type_Mye.pause(true);
        }
      }
      if (paramView.getId() == 2131366502)
      {
        if (this.jdField_a_of_type_Mye.isPause())
        {
          this.jdField_a_of_type_Mye.fK(true);
        }
        else if ((this.jdField_a_of_type_Mye.qc() == 6) && (this.j != null))
        {
          ncb.aQ(this.j.getInnerUniqueID(), 3);
          this.jdField_a_of_type_Mye.a(this.j);
        }
      }
      else if (paramView.getId() == 2131367810)
      {
        aUp();
      }
      else
      {
        label340:
        Object localObject;
        if ((paramView.getId() == 2131381874) || (paramView.getId() == 2131381875))
        {
          boolean bool;
          nce.a locala;
          if (!mzj.a().isMute())
          {
            bool = true;
            mzj.a().g(bool, "user click audio btn", 1);
            if ((this.j == null) || (this.j.d == null)) {
              continue;
            }
            locala = new nce.a("", this.j.puin, this.j.videoVid, this.j.d.innerUniqueID);
            locala.a((int)this.j.channelId);
            if (!bool) {
              break label482;
            }
          }
          label482:
          for (localObject = "1";; localObject = "0")
          {
            locala.a("status", localObject);
            kbp.a(null, "", "0X8009BD6", "0X8009BD6", 0, 0, "3", "", "", locala.a().toJsonString(), false);
            break;
            bool = false;
            break label340;
          }
        }
        else if (paramView.getId() == 2131377130)
        {
          this.jdField_b_of_type_Nca.aVq();
          this.jdField_a_of_type_Mye.a(this.j);
          if ((this.j != null) && (this.j.d != null))
          {
            localObject = new nce.a("", this.j.puin, this.j.videoVid, this.j.d.innerUniqueID);
            ((nce.a)localObject).a((int)this.j.channelId);
            kbp.a(null, "", "0X8009BC8", "0X8009BC8", 0, 0, "3", "", "", ((nce.a)localObject).a().toJsonString(), false);
          }
        }
        else if ((paramView.getId() == 2131366094) || (paramView.getId() == 2131366100))
        {
          aUD();
        }
        else if ((paramView.getId() == 2131381760) && (this.j != null) && (this.j.d != null))
        {
          if (EV()) {
            oH(false);
          }
          this.mUIHandler.post(new VideoUIManager.10(this));
          ncb.a(this.mActivity, this.j.d, this.jdField_a_of_type_Mye.b(this.j.getInnerUniqueID()), 3, 0);
          ncb.s(this.j.getInnerUniqueID(), 3, 0);
        }
      }
    }
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onOrientationChanged=> orientation=" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      oH(false);
      return;
    case 0: 
      sP(0);
      return;
    case 8: 
      sP(8);
      return;
    }
    oH(false);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramInt1 + paramInt2 - 1;
    if (((this.aWo != -1) && (this.aWo != paramInt1)) || ((this.aWp != -1) && (this.aWp != paramInt2))) {
      f(paramAbsListView);
    }
    this.aWo = paramInt1;
    this.aWp = paramInt2;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      f(paramAbsListView);
    }
  }
  
  public void sP(int paramInt)
  {
    ae(paramInt, false);
  }
  
  public void sQ(int paramInt)
  {
    if ((this.h == null) || (this.j == null)) {
      return;
    }
    mzj.a().sW(paramInt);
    paramInt = (int)(mzj.a().aj() * this.j.videoDuration);
    if (DU())
    {
      sS(paramInt);
      return;
    }
    sR(paramInt);
  }
  
  public void stop()
  {
    this.ag.setVisibility(8);
    this.mUIHandler.removeCallbacksAndMessages(null);
    resetData();
  }
  
  public static abstract interface a
  {
    public abstract void a(mye.b paramb);
  }
  
  public static abstract interface b
  {
    public abstract void a(mye.b paramb1, mye.b paramb2);
    
    public abstract void aCk();
  }
  
  public static abstract interface c
  {
    public abstract void a(mye.b paramb, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mza
 * JD-Core Version:    0.7.0.1
 */