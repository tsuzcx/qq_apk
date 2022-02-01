import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.11;
import com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.3;
import com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.4;
import com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.8;
import com.tencent.biz.qqstory.album.view.RoundCornerLayout;
import com.tencent.biz.qqstory.album.view.StoryFormSwitchItem;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import java.util.List;
import mqq.os.MqqHandler;

public class plh
  implements Handler.Callback, View.OnClickListener, plq.b
{
  public static float ew = 0.85F;
  private long Aa = -1L;
  private long Ab = -1L;
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  private axwn jdField_a_of_type_Axwn;
  private SlideProgressNotifier jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier;
  private SpeedFlexibleRecyclerView jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView;
  private plh.a jdField_a_of_type_Plh$a;
  private plq jdField_a_of_type_Plq;
  private boolean aAk;
  private boolean aAl;
  private boolean aAm;
  private boolean aAn;
  private boolean aAo;
  private boolean aAp;
  private boolean aAq;
  private boolean aAr;
  private boolean aAs;
  private boolean animated;
  private pju jdField_b_of_type_Pju = (pju)psx.a(30);
  private plc jdField_b_of_type_Plc;
  private int bjj = -1;
  private int bjk = -1;
  private int bjl = -1;
  private Runnable dk;
  private Runnable dl;
  private long iu;
  private Activity mActivity;
  private int mAlbumItemWidthPadding;
  private RecyclerView.OnChildAttachStateChangeListener mAttachListener = new plp(this);
  private View mCancel;
  private boolean mIsCreated;
  private boolean mIsScrolling;
  private int mLatestLargestAlbumIndex = -1;
  private int mMaxHeightAlbum;
  private int mMaxWidthAlbum;
  private int mMinHeightAlbum;
  private int mMinWidthAlbum;
  private View mRootView;
  private int mScreenHeight;
  private int mScreenWidth;
  private ImageView mSetting;
  private TextView mSettingDesc;
  private View mSettingLayout;
  private StoryFormSwitchItem mSettingSwitch;
  private Handler mUIHandler;
  private RecyclerView.OnScrollListener mVideoItemScrollerListener = new plj(this);
  private int mVideoPaddingSpace;
  private int mVideoSplitSpace;
  private View nX;
  private TextView wV;
  private TextView wW;
  
  public plh(Activity paramActivity, View paramView, @NonNull plh.a parama)
  {
    this.mActivity = paramActivity;
    this.mRootView = paramView;
    this.jdField_a_of_type_Plh$a = parama;
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
    this.mScreenWidth = this.mRootView.getResources().getDisplayMetrics().widthPixels;
    this.mScreenHeight = this.mRootView.getResources().getDisplayMetrics().heightPixels;
    if (azbx.bG(this.mScreenWidth, this.mScreenHeight))
    {
      this.mMinHeightAlbum = ((int)(this.mScreenWidth * 0.38D / 2.0D * 3.0D));
      this.mMaxHeightAlbum = ((int)(this.mScreenWidth * 0.47D / 2.0D * 3.0D));
      this.mMaxWidthAlbum = ((int)(this.mScreenWidth * 0.47D));
    }
    for (this.mMinWidthAlbum = ((int)(this.mScreenWidth * 0.38D));; this.mMinWidthAlbum = ((int)(this.mScreenWidth * 0.53D)))
    {
      this.mAlbumItemWidthPadding = ((this.mMaxWidthAlbum - this.mMinWidthAlbum) / 2);
      this.mVideoSplitSpace = ((int)(this.mScreenWidth * 0.1D - this.mAlbumItemWidthPadding) / 2);
      this.mVideoPaddingSpace = ((this.mScreenWidth - this.mMaxWidthAlbum) / 2);
      pjq.a().blk();
      return;
      this.mMinHeightAlbum = ((int)(this.mScreenWidth * 0.53D / 2.0D * 3.0D));
      this.mMaxHeightAlbum = ((int)(this.mScreenWidth * 0.62D / 2.0D * 3.0D));
      this.mMaxWidthAlbum = ((int)(this.mScreenWidth * 0.62D));
    }
  }
  
  private static float a(int paramInt1, int paramInt2, float paramFloat)
  {
    return 1.0F - (paramInt1 - paramInt2) * paramFloat / paramInt1;
  }
  
  public static float a(plc paramplc, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramplc.cD.getLayoutParams();
    localLayoutParams.width = ((int)(paramplc.mItemView.getWidth() * 0.95F));
    paramplc.cD.setLayoutParams(localLayoutParams);
    paramplc.kx.setTextColor(paramplc.kx.getTextColors().withAlpha((int)(255.0F * paramFloat)));
    paramplc.kz.setTextColor(paramplc.kz.getTextColors().withAlpha((int)(178.5F * paramFloat)));
    paramplc.ky.setTextColor(paramplc.ky.getTextColors().withAlpha((int)(153.0F * paramFloat)));
    float f1 = 0.2F * paramFloat + 0.8F;
    paramplc.cD.setScaleX(f1);
    paramplc.cD.setScaleY(f1);
    paramplc.a.setAlpha(ew);
    f1 = a(paramInt2, paramInt1, 1.0F - paramFloat);
    float f2 = a(paramInt4, paramInt3, 1.0F - paramFloat);
    paramplc.a.setScaleX(f1);
    paramplc.a.setScaleY(f2);
    f1 = ew;
    f2 = ew;
    paramplc.a.setAlpha(f1 * paramFloat + f2);
    QLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", 4, " setVideoItemScale i=" + paramInt5 + " percent=" + paramFloat);
    return paramFloat;
  }
  
  private void blA() {}
  
  private void blv()
  {
    ram.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "open album");
    this.jdField_b_of_type_Pju.rC(true);
    ie();
    blz();
  }
  
  private void blw()
  {
    ram.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "close album");
    this.jdField_b_of_type_Pju.rC(false);
    this.jdField_a_of_type_Plq.blF();
    blz();
  }
  
  private void blx()
  {
    boolean bool = this.jdField_b_of_type_Pju.Ic();
    this.mSettingSwitch.setChecked(bool);
    rF(bool);
  }
  
  private void bly()
  {
    pkd localpkd = this.jdField_a_of_type_Plq.a();
    if (localpkd != null)
    {
      if (!localpkd.Id()) {
        break label173;
      }
      if ((localpkd.bjd == 1) || (localpkd.bjd == 4))
      {
        this.wV.setText(acfp.m(2131702346));
        this.wV.setAlpha(1.0F);
      }
    }
    else
    {
      return;
    }
    if (localpkd.bjd == 3)
    {
      this.wV.setText(acfp.m(2131702321));
      this.wV.setAlpha(1.0F);
      return;
    }
    if (localpkd.bjd == 5)
    {
      this.wV.setText(acfp.m(2131702326));
      this.wV.setAlpha(1.0F);
      return;
    }
    if (localpkd.bjd == 2)
    {
      this.wV.setText(acfp.m(2131702315));
      this.wV.setAlpha(0.5F);
      return;
    }
    this.wV.setText(acfp.m(2131702317));
    this.wV.setAlpha(0.5F);
    return;
    label173:
    this.wV.setText(acfp.m(2131702322));
    this.wV.setAlpha(1.0F);
  }
  
  private void fd(long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new AlbumGalleryCapturePart.8(this), paramLong);
  }
  
  private void g(pkd parampkd)
  {
    ram.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "preload album :%s", parampkd);
    if ((this.Ab == -1L) || (System.currentTimeMillis() - this.Ab >= 30000L))
    {
      rma.a().l(parampkd);
      rma.a().bvu();
    }
  }
  
  private void i(pkd parampkd)
  {
    if (parampkd.bjd == 1)
    {
      this.jdField_a_of_type_Plh$a.blD();
      rar.a("video_shoot_slides", "clk_selectbutton", 0, 0, new String[0]);
    }
    do
    {
      return;
      if (parampkd.bjd == 4)
      {
        this.jdField_a_of_type_Plh$a.blD();
        rar.a("video_shoot_slides", "clk_noalbum", 0, 0, new String[0]);
        return;
      }
      if (parampkd.bjd == 5)
      {
        rar.a("video_shoot_slides", "clk_research", 0, 0, new String[0]);
        if (!rpc.hasInternet(this.mActivity))
        {
          QQToast.a(this.mActivity, acfp.m(2131702345), 0).show();
          return;
        }
        ie();
        return;
      }
    } while (parampkd.bjd != 3);
    blv();
    rar.a("video_shoot_slides", "clk_onalbum", 0, 0, new String[0]);
  }
  
  private void ie()
  {
    if (!this.jdField_b_of_type_Pju.Ic())
    {
      ram.w("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data error ,detect user close scan!");
      return;
    }
    Bosses.get().postJob(new plo(this));
  }
  
  private void initUI()
  {
    this.nX = this.mRootView.findViewById(2131362658);
    this.mCancel = this.mRootView.findViewById(2131362577);
    this.wV = ((TextView)this.mRootView.findViewById(2131377932));
    this.wW = ((TextView)this.mRootView.findViewById(2131365643));
    this.mSetting = ((ImageView)this.mRootView.findViewById(2131362642));
    this.mSettingLayout = this.mRootView.findViewById(2131362644);
    this.mSettingDesc = ((TextView)this.mRootView.findViewById(2131362645));
    this.mSettingSwitch = ((StoryFormSwitchItem)this.mRootView.findViewById(2131362646));
    this.mSettingSwitch.setOnCheckedChangeListener(new pli(this));
    this.mCancel.setOnClickListener(this);
    this.mSetting.setOnClickListener(this);
    this.wV.setOnClickListener(this);
    this.mSettingLayout.setOnClickListener(this);
    this.mRootView.findViewById(2131362643).setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView = ((SpeedFlexibleRecyclerView)this.mRootView.findViewById(2131364253));
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setMaxFlingVelocityX();
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setNestedScrollingEnabled(true);
    this.jdField_a_of_type_Plq = new plq(this.mActivity, this, this.mMaxWidthAlbum, this.mMaxHeightAlbum);
    this.jdField_a_of_type_Plq.setMinSize(this.mMinWidthAlbum, this.mMinHeightAlbum);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setAdapter(this.jdField_a_of_type_Plq);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new LinearLayoutManager(this.mRootView.getContext(), 0, false);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
    axpf.a locala = new axpf.a(this.mVideoSplitSpace, this.mVideoSplitSpace, 0, 0);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.addItemDecoration(locala);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setOverScrollMode(2);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setPadding(this.mVideoPaddingSpace - this.mVideoSplitSpace, 0, this.mVideoPaddingSpace + this.mVideoSplitSpace, 0);
    this.jdField_a_of_type_Axwn = new axwn();
    this.jdField_a_of_type_Axwn.a(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView);
    this.dk = new AlbumGalleryCapturePart.3(this);
    this.dl = new AlbumGalleryCapturePart.4(this);
    this.aAk = psr.IQ();
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.addOnScrollListener(this.mVideoItemScrollerListener);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.addOnChildAttachStateChangeListener(this.mAttachListener);
    this.nX.setVisibility(0);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier = new SlideProgressNotifier(this.mActivity, 2131561628);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier.a(new plm(this));
    this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new pln(this));
    this.mRootView.requestLayout();
    blx();
  }
  
  private void j(pkd parampkd)
  {
    if (this.aAs)
    {
      ram.e("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "you have clicked album when handling");
      return;
    }
    this.aAs = true;
    this.Ab = System.currentTimeMillis();
    rar.a("video_shoot_slides", "clk_makebutton", 0, 0, new String[] { String.valueOf(parampkd.getReportType()) });
    Bosses.get().postJob(new plk(this, parampkd));
  }
  
  private void rF(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mSettingDesc.setText(acfp.m(2131702314));
      return;
    }
    this.mSettingDesc.setText(acfp.m(2131702336));
  }
  
  public void Aj()
  {
    bly();
  }
  
  public void a(pkd parampkd, int paramInt)
  {
    fd(300L);
  }
  
  public void blz()
  {
    int j = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildAt(i);
        float f = scrollPercent((View)localObject);
        localObject = (plc)this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildViewHolder((View)localObject);
        if (localObject != null) {
          a((plc)localObject, this.mMinWidthAlbum, this.mMaxWidthAlbum, this.mMinHeightAlbum, this.mMaxHeightAlbum, f, i);
        }
        if (f <= 0.8F) {
          break label135;
        }
        if (this.mLatestLargestAlbumIndex == i) {
          break label108;
        }
        this.mUIHandler.sendEmptyMessage(1003);
      }
      for (;;)
      {
        this.mLatestLargestAlbumIndex = i;
        return;
        label108:
        this.mUIHandler.removeMessages(1003);
        this.mUIHandler.sendEmptyMessageDelayed(1003, 300L);
      }
      label135:
      i += 1;
    }
  }
  
  public void h(pkd parampkd)
  {
    if (this.mIsScrolling) {
      ram.w("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "album scrolling , select ignore :%s", new Object[] { parampkd });
    }
    while (parampkd == null) {
      return;
    }
    ram.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on album select :%s", parampkd);
    if (parampkd.Id())
    {
      i(parampkd);
      return;
    }
    j(parampkd);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    boolean bool2 = false;
    switch (paramMessage.what)
    {
    }
    label217:
    label355:
    do
    {
      do
      {
        return true;
        paramMessage = this.jdField_a_of_type_Axwn.a(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getLayoutManager());
        if (paramMessage == null)
        {
          ram.w("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on handle find snap msg , not found snap view !");
          return true;
        }
        plc localplc = (plc)this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildViewHolder(paramMessage);
        if ((this.jdField_b_of_type_Plc != null) && (this.jdField_b_of_type_Plc != localplc)) {
          this.jdField_b_of_type_Plc.stopPlay();
        }
        if ((localplc != null) && (this.jdField_b_of_type_Plc != localplc))
        {
          localplc.a.setAlpha(1.0F);
          ram.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "SNAP, startPlay");
          localplc.startPlay();
          if ((this.aAk) && (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.getPosition(paramMessage) == 0) && (!this.animated)) {
            this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.postDelayed(new AlbumGalleryCapturePart.11(this), 3500L);
          }
        }
        this.jdField_b_of_type_Plc = localplc;
        int j = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildAdapterPosition(paramMessage);
        if (j != this.jdField_a_of_type_Plq.getSelectPosition())
        {
          i = 1;
          this.jdField_a_of_type_Plq.a(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView, j);
          boolean bool1 = bool2;
          if (this.aAm)
          {
            bool1 = bool2;
            if (i != 0) {
              bool1 = true;
            }
          }
          this.aAm = bool1;
          bly();
          this.bjl = Math.max(this.jdField_a_of_type_Plq.getSelectPosition(), this.bjl);
          paramMessage = this.jdField_a_of_type_Plq.a();
          if ((paramMessage != null) && (!paramMessage.Id()) && (i != 0)) {
            g(this.jdField_a_of_type_Plq.a());
          }
          if ((paramMessage != null) && (paramMessage.Id()))
          {
            if (paramMessage.bjd != 1) {
              break label355;
            }
            this.aAn = true;
          }
        }
        while (this.aAl)
        {
          blA();
          return true;
          i = 0;
          break label217;
          if (paramMessage.bjd == 4) {
            this.aAo = true;
          } else if (paramMessage.bjd == 3) {
            this.aAq = true;
          } else if (paramMessage.bjd == 5) {
            this.aAp = true;
          } else if (paramMessage.bjd != 2) {}
        }
        paramMessage = this.jdField_a_of_type_Plq.bH();
        if (this.Aa != -1L) {
          while (i < paramMessage.size())
          {
            if (((pkd)paramMessage.get(i)).getID() == this.Aa)
            {
              this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.scrollToPosition(i);
              fd(200L);
              this.Aa = -1L;
              ram.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "start ,scroll to position %d automatically", Integer.valueOf(i));
              return true;
            }
            i += 1;
          }
        }
      } while ((this.bjk < 0) || (this.bjk >= paramMessage.size()));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.scrollToPosition(this.bjk);
      fd(200L);
      this.bjk = -1;
      ram.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "start ,scroll to position %d automatically", Integer.valueOf(this.bjk));
      return true;
      QQToast.a(this.mActivity, acfp.m(2131702332), 0).show();
      this.jdField_a_of_type_Plq.blG();
      return true;
      ram.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "handle msg ,showAfterLoadingTip : %s", Boolean.valueOf(this.aAm));
    } while (!this.aAm);
    i = this.jdField_a_of_type_Plq.getSelectPosition();
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.smoothScrollToPosition(i + 1);
    fd(200L);
    this.aAm = false;
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      pkd localpkd = this.jdField_a_of_type_Plq.a();
      if (localpkd != null)
      {
        long l = SystemClock.uptimeMillis();
        if (l - this.iu > 500L) {
          h(localpkd);
        }
        for (;;)
        {
          this.iu = l;
          break;
          ram.w("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "you click too fast, wait...");
        }
        if (this.jdField_a_of_type_Plh$a != null)
        {
          this.jdField_a_of_type_Plh$a.blC();
          continue;
          if (this.mSettingLayout.getVisibility() == 0)
          {
            this.mSettingLayout.setVisibility(8);
            this.mSetting.setImageResource(2130847299);
          }
          for (;;)
          {
            rar.a("video_shoot_slides", "clk_setting", 0, 0, new String[0]);
            break;
            this.aAr = true;
            blx();
            this.mSettingLayout.setVisibility(0);
            this.mSetting.setImageResource(2130847300);
          }
          this.mSettingLayout.setVisibility(8);
          this.mSetting.setImageResource(2130847299);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (this.mIsCreated) {
      return;
    }
    this.mIsCreated = true;
    ram.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on create");
    if (paramBundle != null)
    {
      this.Aa = paramBundle.getLong("BUNDLE_KEY_LOCATE_ALBUM_ID", -1L);
      this.bjk = paramBundle.getInt("BUNDLE_KEY_LOCATE_INDEX", -1);
      ram.w("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "onCreate albumId = %s , index = %d", new Object[] { Long.valueOf(this.Aa), Integer.valueOf(this.bjk) });
    }
    initUI();
    ie();
  }
  
  public void onDestroy()
  {
    if (!this.mIsCreated) {}
    do
    {
      return;
      ram.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on destroy");
      this.mIsCreated = false;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier.dismiss();
      }
      if (this.jdField_b_of_type_Plc != null)
      {
        this.jdField_b_of_type_Plc.stopPlay();
        this.jdField_b_of_type_Plc = null;
      }
      if (this.jdField_a_of_type_Plq != null) {
        this.jdField_a_of_type_Plq.onDestroy();
      }
      this.mUIHandler.removeCallbacksAndMessages(null);
      if (this.aAn) {
        rar.a("video_shoot_slides", "exp_selectbutton", 0, 0, new String[0]);
      }
      if (this.aAo) {
        rar.a("video_shoot_slides", "exp_noalbum", 0, 0, new String[0]);
      }
      if (this.aAp) {
        rar.a("video_shoot_slides", "exp_research", 0, 0, new String[0]);
      }
      if (this.aAq) {
        rar.a("video_shoot_slides", "exp_onalbum", 0, 0, new String[0]);
      }
    } while (this.bjl < 0);
    rar.a("video_shoot_slides", "swap_smartalbum", 0, 0, new String[] { String.valueOf(this.bjl) });
  }
  
  public void onResume()
  {
    ram.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on resume");
    if (this.jdField_b_of_type_Plc != null)
    {
      ram.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "onResume, startPlay");
      this.jdField_b_of_type_Plc.startPlay();
    }
  }
  
  public void onStop()
  {
    ram.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on stop");
    if (this.jdField_b_of_type_Plc != null) {
      this.jdField_b_of_type_Plc.stopPlay();
    }
    this.mUIHandler.removeCallbacksAndMessages(null);
    this.aAs = false;
  }
  
  public void rG(boolean paramBoolean)
  {
    this.mUIHandler.removeMessages(1005);
    if ((paramBoolean) && (!this.aAm))
    {
      this.mUIHandler.sendEmptyMessageDelayed(1006, 6000L);
      this.aAm = true;
    }
    ram.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "onReceiveScanResult :%s", Boolean.valueOf(paramBoolean));
  }
  
  public float scrollPercent(View paramView)
  {
    int i = Math.min(paramView.getLeft(), this.mScreenWidth - paramView.getRight());
    float f = this.mMinWidthAlbum / 2.0F;
    f = (i + f) / (this.mScreenWidth / 2.0F);
    if (f < 0.0F) {
      return 0.0F;
    }
    if (f > 1.0F) {
      return 1.0F;
    }
    return f;
  }
  
  public static abstract interface a
  {
    public abstract void blC();
    
    public abstract void blD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     plh
 * JD-Core Version:    0.7.0.1
 */