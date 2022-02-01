import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout.a;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class nai
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, VideoFeedsGestureLayout.a, naq.b
{
  private static final String TAG = nai.class.getSimpleName();
  private VideoFeedsGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout;
  private VideoFeedsPlayManager.b jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b;
  protected naq.a a;
  protected naq.d a;
  protected nba a;
  private int aXc;
  private ViewGroup bN;
  private ViewGroup bO;
  private ViewGroup bP;
  private ViewGroup bQ;
  private ViewGroup bR;
  @Nullable
  protected ViewGroup bS;
  @Nullable
  protected ViewGroup bT;
  @Nullable
  protected ViewGroup bU;
  private ViewGroup bV;
  private ViewGroup be;
  private ViewGroup bj;
  private ViewGroup bk;
  private ViewGroup bq;
  public VideoInfo c;
  private SeekBar d;
  private SeekBar e;
  private Map<Integer, Bitmap> ey = new ConcurrentHashMap();
  private ScaleAnimation h;
  public boolean isFullScreen;
  public int itemType;
  private ImageView jO;
  private ImageView jP;
  private ImageView jQ;
  @Nullable
  private ImageView km;
  private View lN;
  protected Activity mActivity;
  private Handler.Callback mCallback = new nak(this);
  private Handler mUIHandler = new auru(this.mCallback);
  private View mask;
  private View mf;
  public int position;
  private TextView ps;
  private TextView pt;
  @Nullable
  public TextView pw;
  private TextView rD;
  private TextView rF;
  private TextView rG;
  private View rootView;
  @Nullable
  private TextView sA;
  @Nullable
  protected TextView sB;
  @Nullable
  private TextView sC;
  private TextView sD;
  private TextView sE;
  private TextView sz;
  private TextView titleTextView;
  private ViewGroup videoLayout;
  private URLImageView w;
  private URLImageView x;
  
  public nai(View paramView, Activity paramActivity, int paramInt)
  {
    super(paramView);
    this.itemType = paramInt;
    this.mActivity = paramActivity;
    this.rootView = paramView;
    this.bN = ((ViewGroup)paramView.findViewById(2131365100));
    this.videoLayout = ((ViewGroup)paramView.findViewById(2131381724));
    this.bR = ((ViewGroup)this.bN.getParent());
    this.aXc = this.bR.indexOfChild(this.bN);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)paramView.findViewById(2131367963));
    this.x = ((URLImageView)paramView.findViewById(2131365489));
    this.w = ((URLImageView)paramView.findViewById(2131363240));
    this.mf = paramView.findViewById(2131363241);
    this.e = ((SeekBar)paramView.findViewById(2131369264));
    this.d = ((SeekBar)paramView.findViewById(2131377920));
    this.bj = ((ViewGroup)paramView.findViewById(2131363651));
    this.rD = ((TextView)paramView.findViewById(2131365556));
    this.rF = ((TextView)paramView.findViewById(2131380115));
    this.bk = ((ViewGroup)paramView.findViewById(2131367807));
    this.jQ = ((ImageView)paramView.findViewById(2131367808));
    this.be = ((ViewGroup)paramView.findViewById(2131381641));
    this.jP = ((ImageView)paramView.findViewById(2131381873));
    this.titleTextView = ((TextView)paramView.findViewById(2131379863));
    this.pw = ((TextView)paramView.findViewById(2131381759));
    this.bV = ((ViewGroup)paramView.findViewById(2131381667));
    this.sE = ((TextView)paramView.findViewById(2131381761));
    this.sD = ((TextView)paramView.findViewById(2131367809));
    this.bQ = ((LinearLayout)paramView.findViewById(2131364690));
    this.bP = ((LinearLayout)paramView.findViewById(2131367806));
    this.jO = ((ImageView)paramView.findViewById(2131373379));
    this.jO.getLayoutParams().height = aqnm.dpToPx(50.0F);
    this.jO.getLayoutParams().width = aqnm.dpToPx(50.0F);
    this.sz = ((TextView)paramView.findViewById(2131366511));
    this.bO = ((ViewGroup)paramView.findViewById(2131373380));
    this.ps = ((TextView)paramView.findViewById(2131372701));
    this.rG = ((TextView)paramView.findViewById(2131367063));
    this.pt = ((TextView)paramView.findViewById(2131370088));
    this.lN = paramView.findViewById(2131381665);
    this.mask = paramView.findViewById(2131372075);
    this.mask.setAlpha(kzc.ag());
    this.bq = ((ViewGroup)paramView.findViewById(2131367481));
    this.sB = ((TextView)paramView.findViewById(2131367467));
    this.sA = ((TextView)paramView.findViewById(2131367470));
    this.bS = ((ViewGroup)paramView.findViewById(2131367475));
    this.sC = ((TextView)paramView.findViewById(2131367477));
    this.km = ((ImageView)paramView.findViewById(2131367474));
    this.bT = ((ViewGroup)paramView.findViewById(2131367491));
    this.bU = ((ViewGroup)paramView.findViewById(2131367466));
    if (this.bS != null) {
      this.bS.setOnClickListener(this);
    }
    if (this.bU != null) {
      this.bU.setOnClickListener(this);
    }
    if (this.bT != null) {
      this.bT.setOnClickListener(this);
    }
    this.mask.setOnClickListener(this);
  }
  
  private void O(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b = new VideoFeedsPlayManager.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.a = this.jdField_a_of_type_Nba;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d = paramVideoInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.videoLayout = this.videoLayout;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.aVn = this.position;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.apw = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.extraData.putInt("video_feeds_index", this.position);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.startPosition = 0L;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.apx = true;
  }
  
  private void a(VideoFeedsPlayManager paramVideoFeedsPlayManager, msx parammsx)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(paramVideoFeedsPlayManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(this.mActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(parammsx);
  }
  
  private void aVc()
  {
    muj.I(this.mask, 8);
    this.mUIHandler.removeMessages(1);
    this.bq.setAlpha(0.35F);
  }
  
  private void aVd()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e.aTP();
    }
    if ((this.bN.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.bN.getParent()).removeView(this.bN);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e.aTQ();
    }
  }
  
  private void aVe()
  {
    ViewGroup.LayoutParams localLayoutParams = this.bN.getLayoutParams();
    if (this.isFullScreen) {
      localLayoutParams.height = -1;
    }
    for (localLayoutParams.width = -1;; localLayoutParams.width = -1)
    {
      this.bN.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.height = nap.a(this.mActivity, this.c);
    }
  }
  
  private boolean b(ImageView paramImageView, URL paramURL)
  {
    boolean bool = true;
    Object localObject = this.mActivity.getIntent();
    int j = ((Intent)localObject).getIntExtra("item_width", 0);
    int i = ((Intent)localObject).getIntExtra("item_height", 0);
    j = ((Intent)localObject).getIntExtra("item_image_width", j);
    i = ((Intent)localObject).getIntExtra("item_image_height", i);
    if ((j == 0) || (i == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "innerTryLoadExtraCoverCache: width or height = 0");
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
      QLog.d(TAG, 2, "innerTryLoadExtraCoverCache: ImageManager hitCache");
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
    QLog.d(TAG, 2, "innerTryLoadExtraCoverCache: urlDrawable hitCache");
    return true;
    if (QLog.isDevelopLevel()) {
      QLog.d(TAG, 2, "innerTryLoadExtraCoverCache: missCache");
    }
    return false;
  }
  
  private void c(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    nba.a locala = new nba.a();
    locala.d = this.d;
    locala.e = this.e;
    locala.be = this.be;
    locala.rD = this.rD;
    locala.rF = this.rF;
    locala.x = this.x;
    locala.lN = this.lN;
    locala.rG = this.rG;
    locala.jO = this.jO;
    locala.bg = this.bO;
    locala.sz = this.sz;
    locala.ps = this.ps;
    locala.pt = this.pt;
    if ((this instanceof kmd))
    {
      this.jdField_a_of_type_Nba = new kme(new kme.a(), locala, paramVideoFeedsPlayManager, false);
      return;
    }
    this.jdField_a_of_type_Nba = new nba(locala, paramVideoFeedsPlayManager, false);
  }
  
  private int n(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843829;
    }
    return 2130843830;
  }
  
  private void oo(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.rD.setVisibility(0);
      this.rF.setVisibility(0);
      this.jP.setVisibility(8);
      this.d.setEnabled(true);
    }
    this.e.setEnabled(true);
    this.jdField_a_of_type_Nba.oJ(true);
    this.jdField_a_of_type_Nba.aTD();
  }
  
  private void pb(boolean paramBoolean)
  {
    this.mUIHandler.removeMessages(1);
    int i = kzc.oc();
    if (i > 0)
    {
      this.mUIHandler.sendEmptyMessageDelayed(1, i * 1000);
      return;
    }
    View localView = this.mask;
    if (paramBoolean) {}
    for (i = 0;; i = 300)
    {
      muj.m(localView, 0, i);
      this.bq.setAlpha(0.2F);
      return;
    }
  }
  
  private void pc(boolean paramBoolean)
  {
    aVe();
    aVd();
    if (paramBoolean)
    {
      this.mActivity.getWindow().addContentView(this.bN, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    this.bR.addView(this.bN, this.aXc);
  }
  
  private void pd(boolean paramBoolean)
  {
    if (this.h == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      this.h = localScaleAnimation;
    }
    this.h.setAnimationListener(new naj(this, paramBoolean));
    if (this.km != null) {
      this.km.startAnimation(this.h);
    }
    muj.b(this.sC, this.c.aHi, "赞");
  }
  
  private void pe(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      muj.H(this.be, 0);
      muj.H(this.bO, 0);
      if (!this.isFullScreen) {
        muj.I(this.bV, 0);
      }
      this.e.setVisibility(8);
    }
    for (;;)
    {
      oo(paramBoolean);
      return;
      muj.H(this.be, 8);
      if (this.jdField_a_of_type_Naq$d.a(this)) {
        muj.H(this.bO, 8);
      }
      muj.I(this.bV, 8);
      this.sz.setVisibility(8);
      this.e.setVisibility(0);
    }
  }
  
  public void G(View paramView, int paramInt) {}
  
  public void HN() {}
  
  public void S(float paramFloat)
  {
    this.jdField_a_of_type_Nba.oJ(false);
    if (this.be.getVisibility() == 0)
    {
      this.d.setEnabled(false);
      this.d.setProgress((int)(100.0F * paramFloat));
      this.rD.setVisibility(8);
      this.rF.setVisibility(8);
      this.jP.setVisibility(0);
      if (paramFloat == 0.0F) {
        this.jP.setEnabled(false);
      }
    }
    for (;;)
    {
      this.mUIHandler.removeMessages(0);
      this.mUIHandler.sendEmptyMessageDelayed(0, 1500L);
      return;
      this.jP.setEnabled(true);
      continue;
      this.e.setVisibility(0);
      this.e.setEnabled(false);
      this.e.setProgress((int)(100.0F * paramFloat));
    }
  }
  
  public void a(naq.d paramd, naq.a parama, VideoFeedsPlayManager paramVideoFeedsPlayManager, msx parammsx)
  {
    this.jdField_a_of_type_Naq$d = paramd;
    this.jdField_a_of_type_Naq$a = parama;
    c(paramVideoFeedsPlayManager);
    a(paramVideoFeedsPlayManager, parammsx);
  }
  
  public void aEx()
  {
    muj.b(this.sA, this.c.commentCount, "评论");
    if (this.sA != null) {
      this.sA.setVisibility(0);
    }
    VideoFeedsAccessibilityHelper.E(this.sA, this.c.commentCount);
    muj.b(this.sB, this.c.aHb, "Biu");
    if (this.sB != null) {
      this.sB.setVisibility(0);
    }
    VideoFeedsAccessibilityHelper.F(this.sB, this.c.aHb);
    if (this.bS != null) {
      this.bS.setVisibility(0);
    }
    muj.b(this.sC, this.c.aHi, "赞");
    if (this.km != null) {
      this.km.setImageDrawable(j(n(this.c.adM)));
    }
    VideoFeedsAccessibilityHelper.c(this.bS, this.c.aHi, this.c.adM);
  }
  
  public void aEy()
  {
    muj.m(this.mask, 8, 0);
    pb(true);
    int i = this.c.j(this.mActivity);
    Object localObject1 = this.bN.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).height = nap.a(this.mActivity, this.c);
    ((ViewGroup.LayoutParams)localObject1).width = -1;
    this.bN.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.c.d();
    Object localObject2;
    if (localObject1 != null)
    {
      if ((this.position != 0) || (!b(this.x, (URL)localObject1)))
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = muj.c(this.mActivity)[0];
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(this.mActivity.getResources().getColor(2131165381));
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = new ColorDrawable(this.mActivity.getResources().getColor(2131165381));
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        this.x.setImageDrawable((Drawable)localObject1);
      }
      muj.m(this.x, 0, 0);
      if ((this.c.k(this.mActivity)) && (this.c.d() != null)) {
        break label486;
      }
      this.w.setImageDrawable(null);
      this.mf.setVisibility(8);
    }
    for (;;)
    {
      this.jO.setBackgroundDrawable(null);
      this.jO.setTag(this);
      this.jO.setOnClickListener(this);
      this.jO.setVisibility(0);
      this.d.setProgress(0);
      muj.a(this.rD, 0L);
      muj.a(this.rF, this.c.getDuration() * 1000);
      muj.a(this.sE, this.c.getDuration() * 1000);
      this.bO.setVisibility(0);
      this.jdField_a_of_type_Nba.sL(0);
      this.be.setVisibility(8);
      this.e.setProgress(0);
      this.bk.setTag(this);
      this.bk.setOnClickListener(this);
      this.bQ.setTag(this);
      this.bQ.setOnClickListener(this);
      this.titleTextView.setVisibility(0);
      this.titleTextView.setText(this.c.title);
      this.titleTextView.getPaint().setFakeBoldText(true);
      this.bV.setVisibility(0);
      if (this.pw != null) {
        this.pw.setText(nap.bu(this.c.playCount));
      }
      this.sD.setText(this.c.title);
      this.sD.getPaint().setFakeBoldText(true);
      return;
      this.x.setImageDrawable(null);
      break;
      label486:
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      localObject1 = URLDrawable.getDrawable(this.c.d(), (URLDrawable.URLDrawableOptions)localObject1);
      ((URLDrawable)localObject1).setDecodeHandler(aqbn.w);
      this.w.setImageDrawable((Drawable)localObject1);
      this.mf.setVisibility(0);
    }
  }
  
  public void aEz()
  {
    muj.b(this.sA, this.c.commentCount, "评论");
    VideoFeedsAccessibilityHelper.E(this.sA, this.c.commentCount);
    muj.b(this.sB, this.c.aHb, "Biu");
    VideoFeedsAccessibilityHelper.F(this.sB, this.c.aHb);
    muj.b(this.sC, this.c.aHi, "赞");
    if (this.km != null) {
      this.km.setImageDrawable(j(n(this.c.adM)));
    }
    VideoFeedsAccessibilityHelper.c(this.bS, this.c.aHi, this.c.adM);
    this.titleTextView.setText(this.c.title);
    this.sD.setText(this.c.title);
    if (this.pw != null) {
      this.pw.setText(nap.bu(this.c.playCount));
    }
  }
  
  public VideoFeedsPlayManager.b b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b;
  }
  
  public void cS(View paramView) {}
  
  public void cb(View paramView)
  {
    if (this.jdField_a_of_type_Naq$d.a(this)) {
      if (this.be.getVisibility() != 8) {
        break label33;
      }
    }
    label33:
    for (boolean bool = true;; bool = false)
    {
      pe(bool);
      return;
    }
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    this.c = paramVideoInfo;
    O(paramVideoInfo);
    aEy();
    aEx();
    if (ayxa.isLiuHaiUseValid())
    {
      if (this.c.k(this.mActivity))
      {
        this.bP.setPadding(0, 0, 0, 0);
        nap.a(this.mActivity, this.bP);
      }
    }
    else {
      return;
    }
    this.bP.setPadding(0, 0, 0, 0);
    nap.b(this.mActivity, this.bP);
  }
  
  public VideoInfo i()
  {
    return this.c;
  }
  
  protected Drawable j(int paramInt)
  {
    Bitmap localBitmap;
    if (!this.ey.containsKey(Integer.valueOf(paramInt)))
    {
      localBitmap = BitmapFactory.decodeResource(this.mActivity.getResources(), paramInt);
      if (localBitmap == null) {
        return this.mActivity.getResources().getDrawable(paramInt);
      }
      this.ey.put(Integer.valueOf(paramInt), localBitmap);
    }
    for (;;)
    {
      return new BitmapDrawable(this.mActivity.getResources(), localBitmap);
      localBitmap = (Bitmap)this.ey.get(Integer.valueOf(paramInt));
    }
  }
  
  public void l(View paramView, int paramInt1, int paramInt2)
  {
    if ((this.isFullScreen) || (!this.jdField_a_of_type_Naq$d.a(this))) {
      return;
    }
    if (this.jdField_a_of_type_Naq$d != null)
    {
      paramView = new int[2];
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.getLocationInWindow(paramView);
      this.jdField_a_of_type_Naq$d.a(this.c, paramView[0] + paramInt1, paramView[1] + paramInt2);
    }
    pd(this.c.adM);
  }
  
  public void mq(boolean paramBoolean)
  {
    if (paramBoolean) {
      aVc();
    }
    for (;;)
    {
      if (this.mUIHandler != null)
      {
        if (!paramBoolean) {
          break;
        }
        this.mUIHandler.removeMessages(0);
        this.mUIHandler.sendEmptyMessageDelayed(0, 3000L);
      }
      return;
      if ((!this.mUIHandler.hasMessages(1)) && (this.mask.getVisibility() == 8)) {
        pb(false);
      }
      pe(false);
    }
    this.mUIHandler.removeMessages(0);
    muj.I(this.bV, 0);
  }
  
  public void nY(boolean paramBoolean)
  {
    this.isFullScreen = paramBoolean;
    pc(paramBoolean);
    if (paramBoolean)
    {
      this.e.setVisibility(8);
      this.bP.setVisibility(0);
      this.jQ.setBackgroundDrawable(j(2130842612));
      if ((ayxa.isLiuHaiUseValid()) && (!this.c.k(this.mActivity))) {
        nap.b(this.mActivity, this.bj);
      }
    }
    for (;;)
    {
      pe(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(paramBoolean);
      return;
      this.bj.setPadding(0, 0, 0, 0);
      continue;
      this.e.setVisibility(0);
      this.bP.setVisibility(8);
      this.jQ.setBackgroundDrawable(j(2130842613));
      this.bj.setPadding(0, 0, 0, 0);
    }
  }
  
  public void onClick(View paramView)
  {
    nai localnai = (nai)paramView.getTag();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!this.jdField_a_of_type_Naq$d.a(this))
      {
        this.jdField_a_of_type_Naq$a.tf(this.position);
        continue;
        if (this.isFullScreen)
        {
          this.jdField_a_of_type_Naq$a.aUp();
        }
        else
        {
          this.jdField_a_of_type_Naq$a.aVf();
          continue;
          this.jdField_a_of_type_Naq$a.aUp();
          continue;
          if (this.jdField_a_of_type_Naq$d != null)
          {
            this.jdField_a_of_type_Naq$d.aTi();
            continue;
            if (this.jdField_a_of_type_Naq$d != null)
            {
              this.jdField_a_of_type_Naq$d.aVh();
              continue;
              if (this.jdField_a_of_type_Naq$d != null)
              {
                this.jdField_a_of_type_Naq$d.T(this.c);
                continue;
                if (this.jdField_a_of_type_Naq$d != null) {
                  this.jdField_a_of_type_Naq$d.U(this.c);
                }
                pd(this.c.adM);
              }
            }
          }
        }
      }
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((paramInt == 0) && (!this.jdField_a_of_type_Naq$d.a(this))) {
      pb(false);
    }
    while (kzc.oc() <= 0) {
      return;
    }
    aVc();
  }
  
  public void ox(boolean paramBoolean)
  {
    this.x.clearAnimation();
    aVe();
    aVd();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Naq$a.a(this.bN, 0, new FrameLayout.LayoutParams(this.bN.getLayoutParams()));
      return;
    }
    this.bR.addView(this.bN, this.aXc);
    this.lN.clearAnimation();
    this.lN.setVisibility(8);
  }
  
  public int qn()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nai
 * JD-Core Version:    0.7.0.1
 */