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

public class yvv
  implements ajep, Handler.Callback, View.OnClickListener
{
  public int a;
  private long jdField_a_of_type_Long;
  private ajeq jdField_a_of_type_Ajeq;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbgg jdField_a_of_type_Bbgg;
  private bfnk jdField_a_of_type_Bfnk = new bfnk(Looper.getMainLooper(), this);
  private yvh jdField_a_of_type_Yvh;
  private yvt jdField_a_of_type_Yvt;
  private ywc jdField_a_of_type_Ywc;
  private ywd jdField_a_of_type_Ywd;
  private ywe jdField_a_of_type_Ywe;
  private zbn jdField_a_of_type_Zbn;
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
  
  public yvv(ywd paramywd, yvh paramyvh, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Ywd = paramywd;
    this.jdField_a_of_type_Yvh = paramyvh;
    this.l = paramBoolean;
    paramywd = this.jdField_a_of_type_Yvh.a();
    paramywd.style = 0;
    if (paramywd.screenOrientation == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      int n = paramywd.getVideoCountDown();
      this.jdField_b_of_type_Long = n;
      paramBoolean = this.jdField_a_of_type_Yvh.a().exp_info.video_countdown_style.has();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Yvh.a().exp_info.video_countdown_style.get();
      yxs.a("GdtMvViewController", "GdtMvViewController: video_countdown = " + n + ", countDownStyle = " + this.jdField_b_of_type_Int + ", video_countdown_style has = " + paramBoolean);
      return;
    }
  }
  
  private void a(int paramInt)
  {
    if (SystemClock.uptimeMillis() - this.jdField_c_of_type_Long < 800L) {}
    while ((paramInt == this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Yvt == null)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Yvt.a(paramInt);
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    yxs.a("GdtMvViewController", "setVoiceIconState volume =" + paramInt + " mVideoPlayer " + this.jdField_a_of_type_Ajeq + " isFromVolumeChanged = " + paramBoolean2 + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", viewResumed = " + paramBoolean1 + ", mIsVideoPlayCompleted = " + this.f);
    if ((!paramBoolean1) || (this.jdField_a_of_type_Ajeq == null)) {}
    do
    {
      return;
      if ((paramInt <= 0) || ((this.jdField_a_of_type_Ajeq.a()) && (!paramBoolean2))) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      q();
      this.jdField_a_of_type_Ajeq.a(this.jdField_a_of_type_Boolean);
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
      TVK_SDKMgr.installPlugin(paramContext, new ywa(this));
      return;
    }
    catch (Throwable paramContext)
    {
      yxs.d("GdtMvViewController", "installSDK t==" + paramContext.toString());
    }
  }
  
  private void a(View paramView)
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Yvh.a();
    if ((this.m) && (paramView != null))
    {
      this.m = false;
      paramView.setTag(2131379206, localGdtVideoData.getAd());
      paramView.setTag(2131379205, new ywb(this));
      yxs.a("GdtMvViewController", "initExpoReport");
      yyb.a().a(paramView);
    }
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString1, String paramString2, String paramString3)
  {
    yxo localyxo = (yxo)ywl.a().a(16);
    if (localyxo != null) {
      localyxo.a(paramGdtMotiveVideoPageData, paramString1, paramString2, paramString3);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      if (paramBoolean)
      {
        yxs.a("GdtMvViewController", "[requestSystemAudioFocus] gain is called!");
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 2);
      }
    }
    else {
      return;
    }
    yxs.a("GdtMvViewController", "[requestSystemAudioFocus] release is called!");
    this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
  }
  
  private View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    for (;;)
    {
      try
      {
        GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Yvh.a();
        if (this.jdField_b_of_type_Boolean)
        {
          if (localGdtMotiveVideoPageData.vSize == 585)
          {
            this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559106, paramViewGroup, false);
            if (this.jdField_a_of_type_AndroidViewView != null) {
              break;
            }
            return null;
          }
          this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559105, paramViewGroup, false);
          continue;
        }
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559104, paramViewGroup, false);
      }
      catch (Exception paramLayoutInflater)
      {
        yxs.d("GdtMvViewController", " viewcontr initViews error", paramLayoutInflater);
        return null;
      }
    }
    this.jdField_a_of_type_Yvt = new yvt(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Yvh);
    yze.a(this.jdField_a_of_type_AndroidViewView.findViewById(2131370840));
    this.jdField_a_of_type_Yvt.a();
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364264));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362135));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364266));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      o();
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362847));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362038));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378999));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      return this.jdField_a_of_type_AndroidViewView;
      if (this.jdField_b_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366961));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364793));
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366966));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        o();
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362848));
        this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364265));
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Yvt != null) && (paramBoolean)) {
      this.jdField_a_of_type_Yvt.c();
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
      this.jdField_a_of_type_Ywc = new ywc(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Ywc, localIntentFilter);
      this.jdField_a_of_type_Ywe = new ywe(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Ywe.a();
      this.jdField_a_of_type_Ywe.a(new yvw(this));
      return;
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Yvt != null)
    {
      this.jdField_a_of_type_Zbn = new zbn(11);
      return;
    }
    yxs.d("GdtMvViewController", " initReports error");
  }
  
  private void l()
  {
    Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 1000L) {}
    for (String str = ajyc.a(2131705207) + this.jdField_b_of_type_Long + ajyc.a(2131705208);; str = ajyc.a(2131705212))
    {
      this.jdField_a_of_type_Bbgg = bbcv.a(localContext, 0, null, str, ajyc.a(2131705214), ajyc.a(2131705211), new yvx(this), new yvy(this));
      this.jdField_a_of_type_Bbgg.setOnKeyListener(new yvz(this));
      return;
    }
  }
  
  private void m()
  {
    if (this.j)
    {
      yxs.d("GdtMvViewController", "refreshVoiceIconDrawable isSilentMode is true");
      this.jdField_a_of_type_Boolean = true;
    }
    n();
  }
  
  private void n()
  {
    if (this.jdField_b_of_type_Int == 0) {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838314));
      }
    }
    while (this.jdField_b_of_type_Int != 1)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838315));
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838314));
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getString(2131692977));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838315));
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getString(2131692976));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838314));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838314));
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getString(2131692977));
  }
  
  private void q()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838315));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838315));
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getString(2131692976));
  }
  
  private void r()
  {
    Object localObject = this.jdField_a_of_type_Yvh.a();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849549);
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849549);
    localObject = URLDrawable.getDrawable(((GdtMotiveVideoPageData)localObject).previewImgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(bavi.m);
    ((URLDrawable)localObject).setTag(new int[] { 50 });
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
  }
  
  private void s()
  {
    yxs.b("GdtMvViewController", "initVideoView");
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Yvh.a();
    this.jdField_a_of_type_Ajeq = new ajeh();
    this.jdField_a_of_type_Ajeq.a(this.jdField_a_of_type_AndroidViewView.getContext(), ajae.a());
    this.jdField_a_of_type_Ajeq.a(this);
    View localView = this.jdField_a_of_type_Ajeq.a();
    if ((localView == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null))
    {
      yxs.d("GdtMvViewController", "[setViewStatus], videoView is null." + this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(localView, localLayoutParams);
    this.jdField_a_of_type_Ajeq.a(localGdtMotiveVideoPageData.url, "sd", 0);
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
    if ((this.i) && (this.jdField_a_of_type_Ajeq != null))
    {
      this.jdField_a_of_type_Ajeq.a();
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
    yxs.b("GdtMvViewController", "[doPauseAction] mIsVideoPlayCompleted:" + this.f);
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Yvh.a();
    a(false);
    if ((!this.f) && (this.jdField_a_of_type_Ajeq != null))
    {
      this.h = false;
      this.jdField_a_of_type_Ajeq.b();
      if ((this.jdField_a_of_type_Zbn != null) && (localGdtVideoData != null)) {
        this.jdField_a_of_type_Zbn.b(localGdtVideoData, this.jdField_a_of_type_Ajeq.b());
      }
    }
  }
  
  private void w()
  {
    if ((this.jdField_a_of_type_Ajeq == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)) {
      return;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Yvh.a();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int i2 = this.jdField_a_of_type_Ajeq.a();
    int i3 = this.jdField_a_of_type_Ajeq.b();
    int n;
    if (this.jdField_b_of_type_Boolean)
    {
      n = yze.f(this.jdField_a_of_type_AndroidContentContext);
      label88:
      if (!this.jdField_b_of_type_Boolean) {
        break label318;
      }
    }
    label318:
    for (int i1 = yze.e(this.jdField_a_of_type_AndroidContentContext);; i1 = yze.f(this.jdField_a_of_type_AndroidContentContext))
    {
      yxs.b("GdtMvViewController", "[VIDEO_PREPARED] mVideoSize " + this.jdField_b_of_type_Boolean + " vW-" + i2 + " vH-" + i3);
      yxs.b("GdtMvViewController", "[VIDEO_PREPARED] mIsPortait " + this.jdField_b_of_type_Boolean + " sW-" + n + " sH-" + i1);
      if ((!this.jdField_b_of_type_Boolean) || (localGdtMotiveVideoPageData.vSize == 585)) {
        break;
      }
      i2 = (int)(1.0F * n * i3 / i2);
      i1 = (int)(i1 * 150.0F / 1334.0F);
      localLayoutParams.height = i2;
      localLayoutParams.width = n;
      localLayoutParams.topMargin = i1;
      yxs.b("GdtMvViewController", "[VIDEO_PREPARED] newHeight " + i2 + " newWidth-" + n + " newTop-" + i1);
      return;
      n = yze.e(this.jdField_a_of_type_AndroidContentContext);
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
    if (this.jdField_a_of_type_Yvt != null) {
      this.jdField_a_of_type_Yvt.b();
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_Bfnk != null) {
      this.jdField_a_of_type_Bfnk.post(new GdtMvViewController.8(this));
    }
  }
  
  long a()
  {
    if (this.jdField_a_of_type_Ajeq != null)
    {
      if (this.f) {
        return this.jdField_a_of_type_Long;
      }
      return this.jdField_a_of_type_Ajeq.b();
    }
    return 0L;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = b(paramLayoutInflater, paramViewGroup);
    if (paramLayoutInflater == null)
    {
      yxs.d("GdtMvViewController", "GdtMvViewController init:rootView==null error");
      return null;
    }
    this.jdField_a_of_type_AndroidContentContext = paramLayoutInflater.getContext();
    yxs.a("GdtMvViewController", "GdtMvViewController: init = " + this.l + ", mContext = " + this.jdField_a_of_type_AndroidContentContext);
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
  
  public ywd a()
  {
    return this.jdField_a_of_type_Ywd;
  }
  
  public void a()
  {
    yxs.a("GdtMvViewController", "[onVideoPrepared]");
    if (!this.e)
    {
      this.e = true;
      if (this.jdField_a_of_type_Bfnk != null)
      {
        yxs.a("GdtMvViewController", "[onVideoPrepared] send PREPARED msg");
        this.jdField_a_of_type_Bfnk.obtainMessage(1).sendToTarget();
      }
    }
    while ((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Ajeq == null) || (this.jdField_a_of_type_Ajeq.c())) {
      return;
    }
    yxs.a("GdtMvViewController", "[onVideoPrepared] resume VideoPlayer again");
    u();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    QLog.w("GdtMvViewController", 1, "[onVideoError], result:" + paramInt1 + ",code:" + paramInt2 + ",msg:" + paramString);
    paramString = this.jdField_a_of_type_Yvh.a();
    if ((this.jdField_a_of_type_Zbn != null) && (paramString != null)) {
      this.jdField_a_of_type_Zbn.a(paramString);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Yvh.a();
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_Bfnk.post(new GdtMvViewController.6(this, paramLong1, paramLong2));
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajyc.a(2131705215) + l1 + "s");
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
      if ((this.h) || (this.jdField_a_of_type_Zbn == null) || (this.jdField_a_of_type_Ajeq == null) || (localGdtVideoData == null)) {
        break;
      }
      this.h = true;
      this.jdField_a_of_type_Zbn.a(localGdtVideoData, this.jdField_a_of_type_Ajeq.b());
      return;
      bool = false;
      break label56;
      label237:
      l1 = this.jdField_b_of_type_Long - (paramLong2 - paramLong1);
      break label72;
      label250:
      if (this.jdField_b_of_type_Int == 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(ajyc.a(2131692975), new Object[] { Long.valueOf(l1) }));
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
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ajyc.a(2131692974));
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
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Yvh.a();
    this.e = false;
    this.f = true;
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bfnk != null) {
      this.jdField_a_of_type_Bfnk.obtainMessage(2).sendToTarget();
    }
    if ((this.jdField_a_of_type_Zbn != null) && (localGdtVideoData != null)) {
      this.jdField_a_of_type_Zbn.b(localGdtVideoData);
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
    yxs.a("GdtMvViewController", "[onBackEvent] mHasWatchAds " + this.jdField_c_of_type_Boolean);
    try
    {
      if (this.jdField_c_of_type_Boolean) {
        return false;
      }
      if ((this.jdField_a_of_type_Ajeq != null) && (!this.jdField_a_of_type_Ajeq.d()))
      {
        this.jdField_d_of_type_Boolean = true;
        v();
      }
      if ((this.jdField_a_of_type_Bbgg != null) && (!this.jdField_a_of_type_Bbgg.isShowing()))
      {
        yxs.a("GdtMvViewController", "mVideoDuration " + this.jdField_a_of_type_Long + " mShotSeconds " + this.jdField_b_of_type_Long);
        bbgg localbbgg = this.jdField_a_of_type_Bbgg;
        if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 1000L) {}
        for (Object localObject = ajyc.a(2131705209) + this.jdField_b_of_type_Long + ajyc.a(2131705213);; localObject = ajyc.a(2131705210))
        {
          localbbgg.setMessage((CharSequence)localObject);
          this.jdField_a_of_type_Bbgg.show();
          localObject = this.jdField_a_of_type_Bbgg.getWindow();
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
      yxs.d("GdtMvViewController", "show dialog err, errInfo->" + localThrowable.getMessage());
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
    yxs.b("GdtMvViewController", "[onResume]" + this.jdField_d_of_type_Boolean + " mIsVideoPlayCompleted " + this.f);
    if ((!this.jdField_d_of_type_Boolean) && (!this.f) && (this.e)) {
      u();
    }
    if (this.jdField_a_of_type_Yvt != null) {
      this.jdField_a_of_type_Yvt.g();
    }
  }
  
  public void g()
  {
    yxs.b("GdtMvViewController", "[onDestroy]");
    if (this.jdField_a_of_type_Bfnk != null) {
      this.jdField_a_of_type_Bfnk.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Ywe != null) {
      this.jdField_a_of_type_Ywe.b();
    }
    if (this.jdField_a_of_type_Ajeq != null)
    {
      this.jdField_a_of_type_Ajeq.b(this);
      this.jdField_a_of_type_Ajeq.b();
      this.jdField_a_of_type_Ajeq = null;
    }
    if (this.jdField_a_of_type_Yvt != null)
    {
      this.jdField_a_of_type_Yvt.e();
      this.jdField_a_of_type_Yvt = null;
    }
    if (this.jdField_a_of_type_Zbn != null) {
      this.jdField_a_of_type_Zbn = null;
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Ywc != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Ywc);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    yyb.a().a();
    bctn.a(BaseApplicationImpl.getApplication().getApplicationContext(), true, 55);
  }
  
  public void h()
  {
    bctn.a(BaseApplicationImpl.getApplication().getApplicationContext(), false, 55);
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
        } while (this.jdField_a_of_type_Ajeq == null);
        w();
      } while (this.jdField_a_of_type_Ajeq == null);
      paramMessage = this.jdField_a_of_type_Ajeq;
      boolean bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        if (!this.j) {
          break label168;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        paramMessage.a(bool1);
        this.jdField_a_of_type_Long = this.jdField_a_of_type_Ajeq.a();
        yxs.a("GdtMvViewController", "[mDuration]" + this.jdField_a_of_type_Long + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", isSilentMode = " + this.j);
        this.jdField_a_of_type_Yvh.a().setDurationMillis(this.jdField_a_of_type_Long);
        u();
        return false;
      }
    case 2: 
      label168:
      yxs.b("GdtMvViewController", "[onVideoCompletion]");
      if (this.jdField_a_of_type_Ajeq != null) {
        this.jdField_a_of_type_Ajeq.b(this);
      }
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      for (;;)
      {
        a(false);
        a(1);
        return false;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ajyc.a(2131692974));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    yxs.b("GdtMvViewController", "[VIDEO_SDK_INSTALLED] initVideoView");
    s();
    return false;
  }
  
  public void i()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Yvh.a();
    yxs.a("GdtMvViewController", "GDT beforeFinish call stack:", new Throwable());
    Intent localIntent = new Intent();
    localIntent.putExtra("duration_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("elapsed_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("profitable_flag", this.jdField_c_of_type_Boolean);
    if (this.f)
    {
      a(localGdtMotiveVideoPageData, String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.f));
      yxs.b("GdtMvViewController", "true[beforeFinish] " + this.jdField_a_of_type_Long + " /" + this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ywd.a(-1, localIntent);
      x();
      return;
      if (this.jdField_a_of_type_Ajeq != null)
      {
        localIntent.putExtra("elapsed_time", this.jdField_a_of_type_Ajeq.b());
        a(localGdtMotiveVideoPageData, String.valueOf(this.jdField_a_of_type_Ajeq.b()), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.f));
        yxs.b("GdtMvViewController", this.jdField_c_of_type_Boolean + "[beforeFinish] " + this.jdField_a_of_type_Ajeq.b() + " /" + this.jdField_a_of_type_Long);
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
        yxs.b("GdtMvViewController", " onClick close_ads");
      } while (c());
      this.jdField_a_of_type_Ywd.a();
      return;
    } while (this.jdField_a_of_type_Ajeq == null);
    boolean bool2 = this.jdField_a_of_type_Ajeq.a();
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      yxs.a("GdtMvViewController", "audioSwitch click is called isSilentMode = " + this.j + ", isMute = " + bool2);
      this.jdField_a_of_type_Ajeq.a(this.jdField_a_of_type_Boolean);
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
 * Qualified Name:     yvv
 * JD-Core Version:    0.7.0.1
 */