import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.api.motivevideo.GdtMvViewController.6;
import com.tencent.gdtad.api.motivevideo.GdtMvViewController.8;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;

public class yme
  implements airr, Handler.Callback, View.OnClickListener
{
  public int a;
  private long jdField_a_of_type_Long;
  private airs jdField_a_of_type_Airs;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bafb jdField_a_of_type_Bafb;
  private befq jdField_a_of_type_Befq = new befq(Looper.getMainLooper(), this);
  private ylq jdField_a_of_type_Ylq;
  private ymc jdField_a_of_type_Ymc;
  private yml jdField_a_of_type_Yml;
  private ymm jdField_a_of_type_Ymm;
  private ymn jdField_a_of_type_Ymn;
  private yrv jdField_a_of_type_Yrv;
  public boolean a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 15L;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k = true;
  private boolean l;
  private boolean m = true;
  
  public yme(ymm paramymm, ylq paramylq, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Ymm = paramymm;
    this.jdField_a_of_type_Ylq = paramylq;
    this.l = paramBoolean;
    paramymm = this.jdField_a_of_type_Ylq.a();
    paramymm.style = 0;
    if (paramymm.screenOrientation == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      int n = paramymm.getVideoCountDown();
      this.jdField_b_of_type_Long = n;
      paramBoolean = this.jdField_a_of_type_Ylq.a().exp_info.video_countdown_style.has();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Ylq.a().exp_info.video_countdown_style.get();
      yny.a("GdtMvViewController", "GdtMvViewController: video_countdown = " + n + ", countDownStyle = " + this.jdField_b_of_type_Int + ", video_countdown_style has = " + paramBoolean);
      return;
    }
  }
  
  private void a(int paramInt)
  {
    if (SystemClock.uptimeMillis() - this.jdField_c_of_type_Long < 800L) {}
    while ((paramInt == this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Ymc == null)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Ymc.a(paramInt);
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    yny.a("GdtMvViewController", "setVoiceIconState volume =" + paramInt + " mVideoPlayer " + this.jdField_a_of_type_Airs + " isFromVolumeChanged = " + paramBoolean2 + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", viewResumed = " + paramBoolean1 + ", mIsVideoPlayCompleted = " + this.f);
    if ((!paramBoolean1) || (this.jdField_a_of_type_Airs == null)) {}
    do
    {
      return;
      if ((paramInt <= 0) || ((this.jdField_a_of_type_Airs.a()) && (!paramBoolean2))) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      q();
      this.jdField_a_of_type_Airs.a(this.jdField_a_of_type_Boolean);
    } while (this.f);
    if (!this.jdField_a_of_type_Boolean) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      a(paramBoolean1);
      return;
      this.jdField_a_of_type_Boolean = true;
      p();
      break;
    }
  }
  
  private void a(Context paramContext)
  {
    try
    {
      TVK_SDKMgr.installPlugin(paramContext, new ymj(this));
      return;
    }
    catch (Throwable paramContext)
    {
      yny.d("GdtMvViewController", "installSDK t==" + paramContext.toString());
    }
  }
  
  private void a(View paramView)
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Ylq.a();
    if ((this.m) && (paramView != null))
    {
      this.m = false;
      paramView.setTag(2131313371, localGdtVideoData.getAd());
      paramView.setTag(2131313370, new ymk(this));
      yny.a("GdtMvViewController", "initExpoReport");
      yoi.a().a(paramView);
    }
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString1, String paramString2, String paramString3)
  {
    yns localyns = (yns)ymu.a().a(16);
    if (localyns != null) {
      localyns.a(paramGdtMotiveVideoPageData, paramString1, paramString2, paramString3);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      if (paramBoolean)
      {
        yny.a("GdtMvViewController", "[requestSystemAudioFocus] gain is called!");
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 2);
      }
    }
    else {
      return;
    }
    yny.a("GdtMvViewController", "[requestSystemAudioFocus] release is called!");
    this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
  }
  
  private View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    for (;;)
    {
      try
      {
        GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Ylq.a();
        if (this.jdField_b_of_type_Boolean)
        {
          if (localGdtMotiveVideoPageData.vSize == 585)
          {
            this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131493537, paramViewGroup, false);
            if (this.jdField_a_of_type_AndroidViewView != null) {
              break;
            }
            return null;
          }
          this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131493536, paramViewGroup, false);
          continue;
        }
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131493535, paramViewGroup, false);
      }
      catch (Exception paramLayoutInflater)
      {
        yny.d("GdtMvViewController", " viewcontr initViews error", paramLayoutInflater);
        return null;
      }
    }
    this.jdField_a_of_type_Ymc = new ymc(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Ylq);
    ypk.a(this.jdField_a_of_type_AndroidViewView.findViewById(2131305167));
    this.jdField_a_of_type_Ymc.a();
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298706));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296594));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131298708));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      o();
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297307));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296497));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131313164));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      return this.jdField_a_of_type_AndroidViewView;
      if (this.jdField_b_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301352));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299230));
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301357));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        o();
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297308));
        this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298707));
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ymc != null) && (paramBoolean)) {
      this.jdField_a_of_type_Ymc.c();
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      if (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 2) {
        break label104;
      }
    }
    label104:
    for (boolean bool = true;; bool = false)
    {
      this.j = bool;
      this.jdField_a_of_type_Yml = new yml(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Yml, localIntentFilter);
      this.jdField_a_of_type_Ymn = new ymn(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Ymn.a();
      this.jdField_a_of_type_Ymn.a(new ymf(this));
      return;
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Ymc != null)
    {
      this.jdField_a_of_type_Yrv = new yrv(11);
      return;
    }
    yny.d("GdtMvViewController", " initReports error");
  }
  
  private void l()
  {
    Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 1000L) {}
    for (String str = ajjy.a(2131639422) + this.jdField_b_of_type_Long + ajjy.a(2131639423);; str = ajjy.a(2131639427))
    {
      this.jdField_a_of_type_Bafb = babr.a(localContext, 0, null, str, ajjy.a(2131639429), ajjy.a(2131639426), new ymg(this), new ymh(this));
      this.jdField_a_of_type_Bafb.setOnKeyListener(new ymi(this));
      return;
    }
  }
  
  private void m()
  {
    if (this.j)
    {
      yny.d("GdtMvViewController", "refreshVoiceIconDrawable isSilentMode is true");
      this.jdField_a_of_type_Boolean = true;
    }
    n();
  }
  
  private void n()
  {
    if (this.jdField_b_of_type_Int == 0) {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838306));
      }
    }
    while (this.jdField_b_of_type_Int != 1)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838307));
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838306));
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getString(2131627339));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838307));
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getString(2131627338));
  }
  
  private void o()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Int != 0) {
        break label57;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.topMargin += 0;
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.topMargin += 0;
    }
    label57:
    while (this.jdField_b_of_type_Int != 1) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.topMargin += 0;
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.topMargin += 0;
  }
  
  private void p()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838306));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838306));
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getString(2131627339));
  }
  
  private void q()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838307));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838307));
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getString(2131627338));
  }
  
  private void r()
  {
    Object localObject = this.jdField_a_of_type_Ylq.a();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849314);
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849314);
    localObject = URLDrawable.getDrawable(((GdtMotiveVideoPageData)localObject).previewImgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(azue.m);
    ((URLDrawable)localObject).setTag(new int[] { 50 });
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
  }
  
  private void s()
  {
    yny.b("GdtMvViewController", "initVideoView");
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Ylq.a();
    this.jdField_a_of_type_Airs = new airj();
    this.jdField_a_of_type_Airs.a(this.jdField_a_of_type_AndroidViewView.getContext(), aing.a());
    this.jdField_a_of_type_Airs.a(this);
    View localView = this.jdField_a_of_type_Airs.a();
    if ((localView == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null))
    {
      yny.d("GdtMvViewController", "[setViewStatus], videoView is null." + this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(localView, localLayoutParams);
    this.jdField_a_of_type_Airs.a(localGdtMotiveVideoPageData.url, "sd", 0);
  }
  
  private void t()
  {
    TVK_SDKMgr.initSdk(this.jdField_a_of_type_AndroidViewView.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidViewView.getContext()))
    {
      s();
      return;
    }
    a(this.jdField_a_of_type_AndroidViewView.getContext());
  }
  
  private void u()
  {
    if ((this.i) && (this.jdField_a_of_type_Airs != null))
    {
      this.jdField_a_of_type_Airs.a();
      if (this.jdField_a_of_type_Boolean) {
        break label42;
      }
    }
    label42:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      n();
      return;
    }
  }
  
  private void v()
  {
    yny.b("GdtMvViewController", "[doPauseAction] mIsVideoPlayCompleted:" + this.f);
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Ylq.a();
    a(false);
    if ((!this.f) && (this.jdField_a_of_type_Airs != null))
    {
      this.h = false;
      this.jdField_a_of_type_Airs.b();
      if ((this.jdField_a_of_type_Yrv != null) && (localGdtVideoData != null)) {
        this.jdField_a_of_type_Yrv.b(localGdtVideoData, this.jdField_a_of_type_Airs.b());
      }
    }
  }
  
  private void w()
  {
    if ((this.jdField_a_of_type_Airs == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)) {
      return;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Ylq.a();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int i2 = this.jdField_a_of_type_Airs.a();
    int i3 = this.jdField_a_of_type_Airs.b();
    int n;
    if (this.jdField_b_of_type_Boolean)
    {
      n = ypk.f(this.jdField_a_of_type_AndroidContentContext);
      label88:
      if (!this.jdField_b_of_type_Boolean) {
        break label318;
      }
    }
    label318:
    for (int i1 = ypk.e(this.jdField_a_of_type_AndroidContentContext);; i1 = ypk.f(this.jdField_a_of_type_AndroidContentContext))
    {
      yny.b("GdtMvViewController", "[VIDEO_PREPARED] mVideoSize " + this.jdField_b_of_type_Boolean + " vW-" + i2 + " vH-" + i3);
      yny.b("GdtMvViewController", "[VIDEO_PREPARED] mIsPortait " + this.jdField_b_of_type_Boolean + " sW-" + n + " sH-" + i1);
      if ((!this.jdField_b_of_type_Boolean) || (localGdtMotiveVideoPageData.vSize == 585)) {
        break;
      }
      i2 = (int)(1.0F * n * i3 / i2);
      i1 = (int)(i1 * 150.0F / 1334.0F);
      localLayoutParams.height = i2;
      localLayoutParams.width = n;
      localLayoutParams.topMargin = i1;
      yny.b("GdtMvViewController", "[VIDEO_PREPARED] newHeight " + i2 + " newWidth-" + n + " newTop-" + i1);
      return;
      n = ypk.e(this.jdField_a_of_type_AndroidContentContext);
      break label88;
    }
  }
  
  private void x()
  {
    if (this.l)
    {
      e();
      g();
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_Ymc != null) {
      this.jdField_a_of_type_Ymc.b();
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_Befq != null) {
      this.jdField_a_of_type_Befq.post(new GdtMvViewController.8(this));
    }
  }
  
  long a()
  {
    if (this.jdField_a_of_type_Airs != null)
    {
      if (this.f) {
        return this.jdField_a_of_type_Long;
      }
      return this.jdField_a_of_type_Airs.b();
    }
    return 0L;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = b(paramLayoutInflater, paramViewGroup);
    if (paramLayoutInflater == null)
    {
      yny.d("GdtMvViewController", "GdtMvViewController init:rootView==null error");
      return null;
    }
    this.jdField_a_of_type_AndroidContentContext = paramLayoutInflater.getContext();
    yny.a("GdtMvViewController", "GdtMvViewController: init = " + this.l + ", mContext = " + this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!this.l)) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).setVolumeControlStream(3);
    }
    j();
    m();
    r();
    t();
    y();
    l();
    k();
    return paramLayoutInflater;
  }
  
  public ymm a()
  {
    return this.jdField_a_of_type_Ymm;
  }
  
  public void a()
  {
    yny.a("GdtMvViewController", "[onVideoPrepared]");
    if (!this.e)
    {
      this.e = true;
      if (this.jdField_a_of_type_Befq != null)
      {
        yny.a("GdtMvViewController", "[onVideoPrepared] send PREPARED msg");
        this.jdField_a_of_type_Befq.obtainMessage(1).sendToTarget();
      }
    }
    while ((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Airs == null) || (this.jdField_a_of_type_Airs.c())) {
      return;
    }
    yny.a("GdtMvViewController", "[onVideoPrepared] resume VideoPlayer again");
    u();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    QLog.w("GdtMvViewController", 1, "[onVideoError], result:" + paramInt1 + ",code:" + paramInt2 + ",msg:" + paramString);
    paramString = this.jdField_a_of_type_Ylq.a();
    if ((this.jdField_a_of_type_Yrv != null) && (paramString != null)) {
      this.jdField_a_of_type_Yrv.a(paramString);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Ylq.a();
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_Befq.post(new GdtMvViewController.6(this, paramLong1, paramLong2));
    }
    while (this.f) {
      return;
    }
    boolean bool;
    label56:
    long l1;
    if (paramLong2 < this.jdField_b_of_type_Long)
    {
      bool = true;
      this.g = bool;
      if (!this.g) {
        break label237;
      }
      l1 = paramLong1;
      label72:
      if (l1 <= 0L) {
        break label297;
      }
      if (this.jdField_b_of_type_Int != 0) {
        break label250;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajjy.a(2131639430) + l1 + "s");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      if (paramLong2 - paramLong1 == 2L) {
        b(true);
      }
      if (paramLong1 == 3L) {
        b(false);
      }
      if ((paramLong1 > 0L) && (paramLong1 == paramLong2 - this.jdField_b_of_type_Long)) {
        this.jdField_c_of_type_Boolean = true;
      }
      if ((this.h) || (this.jdField_a_of_type_Yrv == null) || (this.jdField_a_of_type_Airs == null) || (localGdtVideoData == null)) {
        break;
      }
      this.h = true;
      this.jdField_a_of_type_Yrv.a(localGdtVideoData, this.jdField_a_of_type_Airs.b());
      return;
      bool = false;
      break label56;
      label237:
      l1 = this.jdField_b_of_type_Long - (paramLong2 - paramLong1);
      break label72;
      label250:
      if (this.jdField_b_of_type_Int == 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(ajjy.a(2131627337), new Object[] { Long.valueOf(l1) }));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    label297:
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = true;
      break;
      if (this.jdField_b_of_type_Int == 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131627336));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
  }
  
  boolean a()
  {
    return ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) || ((this.jdField_d_of_type_AndroidWidgetImageView != null) && (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0));
  }
  
  public void b()
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Ylq.a();
    this.e = false;
    this.f = true;
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Befq != null) {
      this.jdField_a_of_type_Befq.obtainMessage(2).sendToTarget();
    }
    if ((this.jdField_a_of_type_Yrv != null) && (localGdtVideoData != null)) {
      this.jdField_a_of_type_Yrv.b(localGdtVideoData);
    }
  }
  
  boolean b()
  {
    return this.f;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMvViewController", 2, "[onVideoBufferStart]");
    }
  }
  
  public boolean c()
  {
    yny.a("GdtMvViewController", "[onBackEvent] mHasWatchAds " + this.jdField_c_of_type_Boolean);
    try
    {
      if (this.jdField_c_of_type_Boolean) {
        return false;
      }
      if ((this.jdField_a_of_type_Airs != null) && (!this.jdField_a_of_type_Airs.d()))
      {
        this.jdField_d_of_type_Boolean = true;
        v();
      }
      if ((this.jdField_a_of_type_Bafb != null) && (!this.jdField_a_of_type_Bafb.isShowing()))
      {
        yny.a("GdtMvViewController", "mVideoDuration " + this.jdField_a_of_type_Long + " mShotSeconds " + this.jdField_b_of_type_Long);
        bafb localbafb = this.jdField_a_of_type_Bafb;
        if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 1000L) {}
        for (Object localObject = ajjy.a(2131639424) + this.jdField_b_of_type_Long + ajjy.a(2131639428);; localObject = ajjy.a(2131639425))
        {
          localbafb.setMessage((CharSequence)localObject);
          this.jdField_a_of_type_Bafb.show();
          localObject = this.jdField_a_of_type_Bafb.getWindow();
          if (localObject == null) {
            break;
          }
          ((Window)localObject).getDecorView().setSystemUiVisibility(3846);
          break;
        }
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      yny.d("GdtMvViewController", "show dialog err, errInfo->" + localThrowable.getMessage());
      return false;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMvViewController", 2, "[onVideoBufferEnd]");
    }
  }
  
  public void e()
  {
    this.i = false;
    v();
  }
  
  public void f()
  {
    this.i = true;
    yny.b("GdtMvViewController", "[onResume]" + this.jdField_d_of_type_Boolean + " mIsVideoPlayCompleted " + this.f);
    if ((!this.jdField_d_of_type_Boolean) && (!this.f) && (this.e)) {
      u();
    }
    if (this.jdField_a_of_type_Ymc != null) {
      this.jdField_a_of_type_Ymc.g();
    }
  }
  
  public void g()
  {
    yny.b("GdtMvViewController", "[onDestroy]");
    if (this.jdField_a_of_type_Befq != null) {
      this.jdField_a_of_type_Befq.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Ymn != null) {
      this.jdField_a_of_type_Ymn.b();
    }
    if (this.jdField_a_of_type_Airs != null)
    {
      this.jdField_a_of_type_Airs.b(this);
      this.jdField_a_of_type_Airs.b();
      this.jdField_a_of_type_Airs = null;
    }
    if (this.jdField_a_of_type_Ymc != null)
    {
      this.jdField_a_of_type_Ymc.e();
      this.jdField_a_of_type_Ymc = null;
    }
    if (this.jdField_a_of_type_Yrv != null) {
      this.jdField_a_of_type_Yrv = null;
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Yml != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Yml);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    yoi.a().a();
    bbqo.a(BaseApplicationImpl.getApplication().getApplicationContext(), true, 55);
  }
  
  public void h()
  {
    bbqo.a(BaseApplicationImpl.getApplication().getApplicationContext(), false, 55);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        do
        {
          return false;
        } while (this.jdField_a_of_type_Airs == null);
        w();
      } while (this.jdField_a_of_type_Airs == null);
      paramMessage = this.jdField_a_of_type_Airs;
      boolean bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        if (!this.j) {
          break label168;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        paramMessage.a(bool1);
        this.jdField_a_of_type_Long = this.jdField_a_of_type_Airs.a();
        yny.a("GdtMvViewController", "[mDuration]" + this.jdField_a_of_type_Long + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", isSilentMode = " + this.j);
        this.jdField_a_of_type_Ylq.a().setDurationMillis(this.jdField_a_of_type_Long);
        u();
        return false;
      }
    case 2: 
      label168:
      yny.b("GdtMvViewController", "[onVideoCompletion]");
      if (this.jdField_a_of_type_Airs != null) {
        this.jdField_a_of_type_Airs.b(this);
      }
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      for (;;)
      {
        a(false);
        a(1);
        return false;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131627336));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    yny.b("GdtMvViewController", "[VIDEO_SDK_INSTALLED] initVideoView");
    s();
    return false;
  }
  
  public void i()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Ylq.a();
    Intent localIntent = new Intent();
    localIntent.putExtra("duration_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("elapsed_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("profitable_flag", this.jdField_c_of_type_Boolean);
    if (this.f)
    {
      a(localGdtMotiveVideoPageData, String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.f));
      yny.b("GdtMvViewController", "true[beforeFinish] " + this.jdField_a_of_type_Long + " /" + this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ymm.a(-1, localIntent);
      x();
      return;
      if (this.jdField_a_of_type_Airs != null)
      {
        localIntent.putExtra("elapsed_time", this.jdField_a_of_type_Airs.b());
        a(localGdtMotiveVideoPageData, String.valueOf(this.jdField_a_of_type_Airs.b()), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.f));
        yny.b("GdtMvViewController", this.jdField_c_of_type_Boolean + "[beforeFinish] " + this.jdField_a_of_type_Airs.b() + " /" + this.jdField_a_of_type_Long);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        yny.b("GdtMvViewController", " onClick close_ads");
      } while (c());
      this.jdField_a_of_type_Ymm.a();
      return;
    } while (this.jdField_a_of_type_Airs == null);
    boolean bool2 = this.jdField_a_of_type_Airs.a();
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      yny.a("GdtMvViewController", "audioSwitch click is called isSilentMode = " + this.j + ", isMute = " + bool2);
      this.jdField_a_of_type_Airs.a(this.jdField_a_of_type_Boolean);
      if (!this.jdField_a_of_type_Boolean) {
        break label178;
      }
    }
    label178:
    for (int n = 0;; n = 1)
    {
      a(n, true, false);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yme
 * JD-Core Version:    0.7.0.1
 */