import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.c;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.d;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView.a;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFollowManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashSet;

public class naw
  implements VideoFeedsPlayManager.c, VideoFeedsPlayManager.d, VideoFeedsRecyclerView.a, mtw.a, mwq.a, naq.d
{
  private static final String TAG = naw.class.getSimpleName();
  private Boolean G;
  private HashSet<VideoInfo> U = new HashSet();
  private VideoFollowManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager;
  private mtw jdField_a_of_type_Mtw;
  private naf jdField_a_of_type_Naf;
  private nal jdField_a_of_type_Nal;
  private nam jdField_a_of_type_Nam;
  private naq.a jdField_a_of_type_Naq$a;
  private naq.b jdField_a_of_type_Naq$b;
  private naq.c jdField_a_of_type_Naq$c;
  private nar jdField_a_of_type_Nar;
  private naz jdField_a_of_type_Naz;
  private int aVi;
  private int aXe = -1;
  private boolean anY = true;
  private boolean apC;
  private boolean apE;
  private boolean aqX;
  private msx b;
  private VideoFeedsPlayManager jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private mwq jdField_c_of_type_Mwq;
  private ArrayList<VideoInfo> lt = new ArrayList();
  private FragmentActivity mActivity;
  private QQAppInterface mApp;
  private Bundle mBundle;
  private Handler mHandler;
  private boolean mIsFullScreen;
  private VideoPreDownloadMgr mVideoPreDownloadMgr;
  private long wW;
  
  public naw(FragmentActivity paramFragmentActivity, Bundle paramBundle, naq.a parama)
  {
    this.mActivity = paramFragmentActivity;
    this.mApp = ((QQAppInterface)kxm.getAppRuntime());
    this.mBundle = paramBundle;
    this.jdField_a_of_type_Naq$a = parama;
    this.mHandler = new Handler();
    initData();
    Rt();
    aTh();
  }
  
  private void Rt()
  {
    this.jdField_a_of_type_Naq$c = new nat(this.mActivity, this.lt, this.aVi, this.mBundle, this);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(this.mActivity, this.mApp, 1);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this);
    this.b = new msx(this.mActivity);
    this.jdField_c_of_type_Mwq = new mwq(this.mActivity, this.mApp, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.aVi, false, this, 1);
    this.jdField_c_of_type_Mwq.l(f());
    this.jdField_a_of_type_Naz = new naz(this.mActivity, this.mBundle, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this);
    this.mVideoPreDownloadMgr = new VideoPreDownloadMgr(this.mActivity);
    this.mVideoPreDownloadMgr.a = new myn(myn.aWe, myn.aWf);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.mVideoPreDownloadMgr);
    this.mVideoPreDownloadMgr.a(new nax(this));
  }
  
  private void aTh()
  {
    VideoInfo localVideoInfo = f();
    if (localVideoInfo != null)
    {
      int i = this.mActivity.getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      int j = this.mActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      nce.a locala = new nce.a(localVideoInfo);
      locala.N(2).X(i).n(localVideoInfo.Wz);
      kbp.b(null, localVideoInfo.hH, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", localVideoInfo.Wz, locala.a().toJsonString(), false);
    }
  }
  
  private void b(naq.b paramb)
  {
    VideoInfo localVideoInfo = paramb.i();
    paramb.mq(true);
    paramb = paramb.b();
    paramb.startPosition = this.wW;
    this.wW = 0L;
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(paramb, false);
    this.jdField_c_of_type_Mwq.v(localVideoInfo);
    this.jdField_a_of_type_Mtw.v(localVideoInfo);
    if (this.apC)
    {
      this.apC = false;
      paramb = (AnchorData)this.mBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
      this.jdField_a_of_type_Mtw.b(paramb);
    }
  }
  
  private void c(naq.b paramb)
  {
    if (this.jdField_a_of_type_Naq$b != null) {}
    for (VideoFeedsPlayManager.b localb = this.jdField_a_of_type_Naq$b.b();; localb = null)
    {
      if ((localb != null) && (localb.e != null))
      {
        int i = localb.e.qe();
        if ((i != 0) && (i != 1) && (i != 2) && (this.jdField_a_of_type_Naq$b.qn() == paramb.qn() - 1) && (aqiw.isWifiConnected(this.mActivity)) && (awit.J(this.mApp))) {
          this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.m(paramb.b());
        }
      }
      return;
    }
  }
  
  private void initData()
  {
    boolean bool2 = true;
    this.G = Boolean.valueOf(this.mBundle.getBoolean("VIDEO_FROM_AIO", false));
    this.aVi = this.mBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.wW = this.mBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    this.apC = this.mBundle.getBoolean("VIDEO_SHOW_COMMENT", false);
    if ((this.mBundle.getInt("VIDEO_FROM_TYPE", -1) == 2) || (this.mBundle.getInt("VIDEO_FROM_TYPE", -1) == 3) || (this.mBundle.getInt("VIDEO_FROM_TYPE", -1) == 6) || (this.mBundle.getInt("VIDEO_FROM_TYPE", -1) == 7))
    {
      bool1 = true;
      this.apE = bool1;
      if (this.apE) {
        break label189;
      }
    }
    label189:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.anY = bool1;
      if (this.mBundle.getInt("KEY_LOAD_DELEGATE_TYPE", 0) == 0)
      {
        VideoInfo localVideoInfo = nap.b(this.mBundle);
        if (localVideoInfo != null) {
          this.lt.add(localVideoInfo);
        }
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void B(VideoInfo paramVideoInfo) {}
  
  public void Q(VideoInfo paramVideoInfo)
  {
    this.jdField_c_of_type_Mwq.sJ(0);
    this.jdField_a_of_type_Naz.W(paramVideoInfo);
  }
  
  public boolean Q(boolean paramBoolean)
  {
    if (this.mIsFullScreen)
    {
      this.jdField_a_of_type_Naq$a.aUp();
      return true;
    }
    if (this.jdField_a_of_type_Mtw.El())
    {
      this.jdField_a_of_type_Mtw.aSk();
      return true;
    }
    this.jdField_a_of_type_Naz.pf(paramBoolean);
    return false;
  }
  
  public void R(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager.L(paramVideoInfo);
    this.jdField_a_of_type_Naz.X(paramVideoInfo);
  }
  
  public void S(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.yV()) {
      muj.a(this.mActivity, paramVideoInfo.a.h);
    }
    for (;;)
    {
      this.jdField_a_of_type_Naz.Y(paramVideoInfo);
      return;
      if ((paramVideoInfo.WJ != null) && (!paramVideoInfo.WJ.equals(""))) {
        kxm.aJ(this.mActivity, paramVideoInfo.WJ);
      } else if (paramVideoInfo.busiType == 6)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.hH))
        {
          String str = kwt.acF + aqgo.encodeToString(paramVideoInfo.hH.getBytes(), 2);
          kxm.aJ(this.mActivity, str);
        }
      }
      else if ((!TextUtils.isEmpty(paramVideoInfo.hH)) && (!paramVideoInfo.hH.equals("16888"))) {
        nap.t(this.mActivity, paramVideoInfo.hH);
      }
    }
  }
  
  public void T(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Nal.P(paramVideoInfo);
    this.jdField_a_of_type_Naz.aa(paramVideoInfo);
  }
  
  public void U(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Nar.V(paramVideoInfo);
    this.jdField_a_of_type_Naz.ab(paramVideoInfo);
  }
  
  public VideoFeedsPlayManager a()
  {
    return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  }
  
  public msx a()
  {
    return this.b;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.mIsFullScreen = paramBoolean;
    if ((paramViewHolder instanceof naq.b)) {
      ((naq.b)paramViewHolder).nY(paramBoolean);
    }
    if (paramBoolean)
    {
      this.mActivity.getWindow().addFlags(1024);
      if (Build.VERSION.SDK_INT >= 19)
      {
        paramViewHolder = this.mActivity.getWindow().getDecorView();
        this.aXe = paramViewHolder.getSystemUiVisibility();
        paramViewHolder.setSystemUiVisibility(4102);
      }
    }
    while ((Build.VERSION.SDK_INT < 19) || (this.aXe == -1)) {
      return;
    }
    this.mActivity.getWindow().getDecorView().setSystemUiVisibility(this.aXe);
  }
  
  public void a(VideoInfo paramVideoInfo, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Nar.b(paramVideoInfo, paramInt1, paramInt2);
    this.jdField_a_of_type_Naz.ab(paramVideoInfo);
  }
  
  public void a(VideoFeedsPlayManager.b paramb)
  {
    if ((aqiw.isWifiConnected(this.mActivity)) && (awit.J(this.mApp)))
    {
      paramb = this.jdField_a_of_type_Naq$a.a(this.jdField_a_of_type_Naq$b.qn() + 1);
      if ((paramb != null) && (paramb.b() != null)) {
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.m(paramb.b());
      }
    }
    if (this.jdField_a_of_type_Naq$b != null) {
      this.jdField_a_of_type_Naq$b.HN();
    }
  }
  
  public void a(VideoFeedsPlayManager.b paramb, int paramInt)
  {
    this.jdField_a_of_type_Naz.s(paramb);
  }
  
  public void a(VideoFeedsPlayManager.b paramb, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, naf paramnaf, View paramView)
  {
    this.jdField_a_of_type_Naf = paramnaf;
    paramVideoFeedsRecyclerView.a(this);
    this.jdField_a_of_type_Naq$c.aVg();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager = new VideoFollowManager(this.mActivity, this.mApp, this.jdField_a_of_type_Naf, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.lt, 1);
    this.jdField_a_of_type_Nal = new nal(this.mActivity, this.jdField_a_of_type_Naf, this);
    this.jdField_a_of_type_Nar = new nar(this.mActivity, this.jdField_a_of_type_Naf);
    this.jdField_a_of_type_Nam = new nam(this.mActivity, this.jdField_a_of_type_Naf, this);
    this.jdField_a_of_type_Mtw = new mtw(this.mActivity, this.mActivity.getSupportFragmentManager(), null, this.jdField_a_of_type_Naf, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, (ViewGroup)paramView.findViewById(2131365045));
    this.jdField_a_of_type_Mtw.initUI();
    if (ayxa.isLiuHaiUseValid()) {
      this.jdField_a_of_type_Mtw.sz(ImmersiveUtils.getStatusBarHeight(this.mActivity));
    }
    this.jdField_a_of_type_Mtw.a(this);
    mzj.a().aO(this.mActivity);
  }
  
  public void a(naq.b paramb)
  {
    c(paramb);
    if (paramb.qn() != 0) {
      this.jdField_a_of_type_Naz.d(paramb.i(), paramb.qn());
    }
    this.U.add(paramb.i());
  }
  
  public boolean a(nai paramnai)
  {
    if (paramnai == this.jdField_a_of_type_Naq$b) {
      return true;
    }
    this.jdField_a_of_type_Naq$a.Jw();
    return false;
  }
  
  public boolean a(naq.b paramb)
  {
    return paramb == this.jdField_a_of_type_Naq$b;
  }
  
  public void aGM()
  {
    this.aqX = true;
  }
  
  public void aJ(boolean paramBoolean)
  {
    this.jdField_a_of_type_Naq$a.ox(paramBoolean);
    if (this.jdField_a_of_type_Naq$b != null) {
      this.jdField_a_of_type_Naq$b.ox(paramBoolean);
    }
  }
  
  public void aRC()
  {
    this.jdField_a_of_type_Naq$a.aRC();
  }
  
  public void aRD()
  {
    this.jdField_a_of_type_Naq$a.aRD();
  }
  
  public void aSa()
  {
    this.jdField_a_of_type_Naq$c.aVg();
  }
  
  public void aTi()
  {
    VideoFeedsPlayManager.b localb = this.jdField_a_of_type_Naq$b.b();
    if ((localb != null) && (localb.e != null)) {}
    for (int i = localb.e.qe();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "handlePlayButtonClick() status()=" + i);
      }
      switch (i)
      {
      default: 
        return;
      case 0: 
      case 7: 
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(localb, false);
        return;
      case 6: 
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.o(localb);
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(localb, true);
        return;
      case 3: 
      case 4: 
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.pause();
        this.jdField_a_of_type_Naz.d(localb);
        return;
      case 5: 
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.restart();
        return;
      case 1: 
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.pause();
        return;
      }
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.start();
      return;
    }
  }
  
  public void aVh()
  {
    this.jdField_a_of_type_Mtw.aSh();
    this.jdField_a_of_type_Naz.Z(this.jdField_a_of_type_Naq$b.i());
  }
  
  public void aVl()
  {
    this.jdField_a_of_type_Naq$a.te(2);
  }
  
  public void b(VideoFeedsPlayManager.b paramb) {}
  
  public ArrayList<VideoInfo> bg()
  {
    return this.lt;
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (naq.b)paramViewHolder;
    if (this.jdField_a_of_type_Naq$b != null)
    {
      this.jdField_a_of_type_Naq$b.mq(false);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.stop();
    }
    this.jdField_a_of_type_Naq$b = paramViewHolder;
    b(this.jdField_a_of_type_Naq$b);
    this.jdField_a_of_type_Naz.e(paramViewHolder);
    this.jdField_a_of_type_Naq$c.tg(paramViewHolder.qn());
  }
  
  public HashSet<VideoInfo> d()
  {
    return this.U;
  }
  
  public void d(VideoFeedsPlayManager.b paramb) {}
  
  public void dd(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Naq$a.te(1);
    this.jdField_a_of_type_Naq$a.dc(paramInt1, paramInt2);
    this.jdField_a_of_type_Nam.da(paramInt1, paramInt2);
  }
  
  public void doOnDestory()
  {
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.doOnDestory();
    this.jdField_a_of_type_Naq$c.doOnDestory();
    this.jdField_c_of_type_Mwq.onDestroy();
    this.b.doOnDestory();
    this.jdField_a_of_type_Nam.doOnDestory();
    this.jdField_a_of_type_Nar.onDestory();
    mzj.a().aP(this.mActivity);
  }
  
  public void doOnPause()
  {
    if (this.aqX)
    {
      this.aqX = false;
      return;
    }
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.doOnPause();
    this.jdField_c_of_type_Mwq.onPause();
    mzj.a().z(false, "multivideo doOnPause");
  }
  
  public void doOnResume()
  {
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.doOnResume();
    this.jdField_c_of_type_Mwq.onResume();
    this.jdField_a_of_type_Naq$a.a(new nay(this));
    mzj.a().z(true, "multivideo doOnResume");
  }
  
  @Nullable
  public VideoInfo f()
  {
    if (!this.lt.isEmpty()) {
      return (VideoInfo)this.lt.get(0);
    }
    return null;
  }
  
  public void g(VideoFeedsPlayManager.b paramb, boolean paramBoolean)
  {
    this.jdField_a_of_type_Naz.g(paramb, paramBoolean);
  }
  
  public void h(VideoFeedsPlayManager.b paramb, boolean paramBoolean) {}
  
  public void i(VideoFeedsPlayManager.b paramb) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.jdField_c_of_type_Mwq.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_Nal.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_Mtw.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putAll(paramIntent.getExtras());
        muj.b(this.mApp, (Bundle)localObject);
        continue;
        if (paramInt2 == -1)
        {
          if (!paramIntent.getBooleanExtra("bFailed", false)) {
            i = 1;
          }
          localObject = new QQToast(this.mActivity.getApplicationContext());
          ((QQToast)localObject).setDuration(2000);
          if (i != 0)
          {
            ((QQToast)localObject).setToastIcon(QQToast.getIconRes(2));
            ((QQToast)localObject).setToastMsg(2131693408);
            ((QQToast)localObject).show(this.mActivity.getApplicationContext().getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel(this.mActivity.getApplicationContext(), 5.0F));
          }
          else
          {
            ((QQToast)localObject).setToastIcon(QQToast.getIconRes(1));
            ((QQToast)localObject).setToastMsg(2131693409);
            ((QQToast)localObject).show(this.mActivity.getApplicationContext().getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel(this.mActivity.getApplicationContext(), 5.0F));
            continue;
            if (paramInt2 == -1)
            {
              QQToast.a(this.mActivity, 2131720247, 0).show();
              continue;
              if (paramInt2 == -1) {
                QQToast.a(this.mActivity, -1, this.mActivity.getResources().getString(2131701915), 0).show(this.mActivity.getTitleBarHeight());
              }
            }
          }
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_Naq$b != null)
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        mzj.a().sW(paramInt);
        this.jdField_a_of_type_Naq$b.S(mzj.a().aj());
        return true;
      }
    }
    return false;
  }
  
  public void onProgressChanged(long paramLong) {}
  
  public void q(VideoFeedsPlayManager.b paramb)
  {
    this.jdField_a_of_type_Naz.q(paramb);
  }
  
  public void r(VideoFeedsPlayManager.b paramb)
  {
    if ((!this.mIsFullScreen) && (!this.jdField_a_of_type_Mtw.El())) {
      this.jdField_a_of_type_Naq$a.Jw();
    }
  }
  
  public void th(int paramInt)
  {
    this.jdField_a_of_type_Naq$a.td(paramInt);
    this.jdField_a_of_type_Nam.da(0, 1);
    this.jdField_c_of_type_Mwq.l(f());
    this.jdField_a_of_type_Naz.d((VideoInfo)this.lt.get(0), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     naw
 * JD-Core Version:    0.7.0.1
 */