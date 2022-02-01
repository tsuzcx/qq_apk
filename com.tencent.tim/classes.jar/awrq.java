import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.c;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.d;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.QIMCameraBroadcastReceiver;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.QIMCameraCaptureUnit.1;
import dov.com.qq.im.QIMCameraCaptureUnit.10;
import dov.com.qq.im.QIMCameraCaptureUnit.11;
import dov.com.qq.im.QIMCameraCaptureUnit.13;
import dov.com.qq.im.QIMCameraCaptureUnit.14;
import dov.com.qq.im.QIMCameraCaptureUnit.2;
import dov.com.qq.im.QIMCameraCaptureUnit.4;
import dov.com.qq.im.QIMCameraCaptureUnit.5;
import dov.com.qq.im.QIMCameraCaptureUnit.6;
import dov.com.qq.im.QIMCameraCaptureUnit.7;
import dov.com.qq.im.QIMCameraCaptureUnit.8;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout.a;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

public class awrq
  extends awrx
  implements alxa.a, View.OnClickListener, View.OnTouchListener, aycc, MediaScanner.OnMediaInfoScannerListener, CameraCaptureView.c, CameraCaptureView.d, QIMCameraCaptureButtonLayout.a
{
  protected View Gm;
  public ImageView HK;
  protected ImageView HL;
  public View LO;
  public List<LocalMediaInfo> LX = new ArrayList();
  List<CameraCaptureView.VideoCaptureResult> LY = new ArrayList();
  protected alwm a;
  protected alwo a;
  protected alwr a;
  awrz a;
  public ayca a;
  public aycb a;
  protected CameraFocusView a;
  public CaptureModeController a;
  public QIMCameraCaptureButtonLayout a;
  public QIMCameraSegmentCaptureButtonLayout a;
  protected long aBw;
  protected long aBx = 3L;
  private aqju ad;
  protected aybv b;
  public CameraCaptureView b;
  protected QIMCameraCaptureButtonLayout b;
  public RelativeLayout bottom_blackLH;
  protected int byT = 0;
  public CameraCaptureView.VideoCaptureResult c;
  public boolean cAD;
  public String cSo = acfp.m(2131711181);
  public String cSp;
  protected FrameLayout cz;
  protected CameraCaptureView.VideoCaptureResult d;
  public boolean drA;
  protected boolean drm = true;
  protected boolean drn;
  public boolean dro;
  protected boolean drp;
  public boolean drq;
  private boolean drr;
  public boolean drs;
  public boolean drt;
  protected boolean dru;
  private boolean drv;
  public boolean drw = true;
  public boolean drx;
  private boolean dry;
  public boolean drz;
  public int eCw = 0;
  protected AtomicBoolean eI = new AtomicBoolean(true);
  protected ViewGroup eZ;
  public Bitmap er;
  protected TextView fd;
  private LocalMediaInfo g;
  protected LocalMediaInfo h;
  protected Button hQ;
  protected Button hR;
  public Button hS;
  private BroadcastReceiver mReceiver = new QIMCameraBroadcastReceiver(this);
  protected RelativeLayout nQ;
  public View rootView;
  protected LinearLayout top_blackLH;
  
  public awrq(aycb paramaycb, ayca paramayca)
  {
    this.jdField_b_of_type_Aybv = new aybv(10000, 100, 2);
    this.jdField_a_of_type_Aycb = paramaycb;
    this.jdField_a_of_type_Ayca = paramayca;
  }
  
  private boolean aNu()
  {
    return this.eCw != 5;
  }
  
  public void Bx(boolean paramBoolean)
  {
    if (this.hS == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.11(this, paramBoolean));
  }
  
  public int QA()
  {
    if (this.bottom_blackLH == null) {
      return 0;
    }
    return this.bottom_blackLH.getMeasuredHeight();
  }
  
  public int Qw()
  {
    return 0;
  }
  
  public int Qx()
  {
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.dKT();
    return this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Is();
  }
  
  public int Qy()
  {
    return this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Is();
  }
  
  public int Qz()
  {
    if (this.top_blackLH == null) {
      return 0;
    }
    return this.top_blackLH.getMeasuredHeight();
  }
  
  protected void R(List<CameraCaptureView.VideoCaptureResult> paramList, List<LocalMediaInfo> paramList1)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentVideoCaptured results empty");
      }
    }
    do
    {
      return;
      if (this.eI.get()) {
        break;
      }
      this.dru = true;
    } while (!QLog.isColorLevel());
    QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentVideoCaptured segment not finish, wait");
    return;
    if ((!this.drv) || (paramList.size() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentVideoCaptured segment need not merge, directly queryMediaInfoAsync");
      }
      if ((paramList.size() == 1) && (this.drv))
      {
        this.g.path = ((CameraCaptureView.VideoCaptureResult)paramList.get(0)).videoMp4FilePath;
        this.g.mMimeType = "video";
        this.c = ((CameraCaptureView.VideoCaptureResult)paramList.get(0));
      }
      MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(new awrw(this), this.g);
      return;
    }
    ThreadManager.excute(new QIMCameraCaptureUnit.10(this, paramList), 16, null, true);
  }
  
  public void Xp(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, new Object[] { "handleSegmentCaptureMode", Boolean.valueOf(paramBoolean) });
    }
    if (this.cAD != paramBoolean)
    {
      this.jdField_a_of_type_Awrz = ((awrz)axov.a().c(13));
      this.jdField_a_of_type_Awrz.Xx(paramBoolean);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof AppInterface)) {
        localAppRuntime.notifyObservers(axrf.class, 7, false, null);
      }
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setSegmentMode(paramBoolean);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.dLa();
      if (paramBoolean)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.reset();
        this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.setVisibility(0);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout;
        this.HK.setVisibility(8);
        coy();
        cox();
        eFo();
        this.cAD = true;
        this.eI.set(true);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.setVisibility(8);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.reset();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
    this.LX.clear();
    this.LY.clear();
    this.cAD = false;
    this.eI.set(false);
    if (this.drt)
    {
      Xq(false);
      return;
    }
    coy();
    cox();
  }
  
  public void Xq(boolean paramBoolean)
  {
    if (this.drt != paramBoolean)
    {
      this.drt = paramBoolean;
      if (!paramBoolean) {
        break label41;
      }
      if (this.cz != null)
      {
        this.cz.setAlpha(1.0F);
        this.cz.setTranslationY(0.0F);
      }
    }
    return;
    label41:
    cox();
    float f = rpq.dip2px(this.jdField_a_of_type_Aycb.getActivity(), 90.0F);
    ArrayList localArrayList = new ArrayList();
    if (this.cz != null)
    {
      localArrayList.add(new axwc.a(this.cz, "translationY", 0.0F, f, 450L, 0L));
      localArrayList.add(new axwc.a(this.cz, "alpha", 1.0F, 0.0F, 450L, 0L));
    }
    if (this.eZ != null)
    {
      localArrayList.add(new axwc.a(this.eZ, "translationY", f, 0.0F, 450L, 0L));
      localArrayList.add(new axwc.a(this.eZ, "alpha", 0.0F, 1.0F, 450L, 0L));
      this.eZ.setAlpha(0.0F);
    }
    Object localObject = hE();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        localArrayList.add(new axwc.a(localView, "translationY", f, 0.0F, 450L, 0L));
        localArrayList.add(new axwc.a(localView, "alpha", 0.0F, 1.0F, 450L, 0L));
        localView.setAlpha(0.0F);
      }
    }
    axwc.a(localArrayList, new awrs(this));
  }
  
  public void Xr(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      cox();
      eFo();
    }
  }
  
  public void Xs(boolean paramBoolean) {}
  
  public void Xt(boolean paramBoolean) {}
  
  public void Xu(boolean paramBoolean) {}
  
  public void Xv(boolean paramBoolean) {}
  
  public void Xw(boolean paramBoolean) {}
  
  protected void Zx()
  {
    axro localaxro = (axro)axov.a().c(8);
    if ((localaxro != null) && (localaxro.isPlaying()))
    {
      this.dry = true;
      localaxro.Zx();
    }
  }
  
  protected alwm a()
  {
    return new alwm(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView);
  }
  
  public IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    return localIntentFilter;
  }
  
  protected CameraCaptureView.e a()
  {
    if (anki.axO()) {
      return aywy.a().a(this.jdField_a_of_type_Aycb.getActivity());
    }
    return aywy.a().b(this.jdField_a_of_type_Aycb.getActivity());
  }
  
  public CameraCaptureView a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
  }
  
  public void a(int paramInt, axqo paramaxqo) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, new Object[] { "handleSegmentVideoResult, ", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean)
    {
      this.LX.add(paramLocalMediaInfo);
      this.LY.add(this.c);
      if (QLog.isColorLevel()) {
        QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onMediaInfoChanged, mediaInfos size = " + this.LX.size());
      }
    }
    this.drv = true;
    this.eI.set(true);
    boolean bool = this.dru;
    ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.8(this, paramBoolean, paramLocalMediaInfo, bool));
    if ((this.dru) && (this.drw))
    {
      R(this.LY, this.LX);
      this.drs = true;
      this.dru = false;
    }
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    this.c = paramVideoCaptureResult;
    if (this.drx)
    {
      this.drx = false;
      this.drq = false;
      ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.4(this));
      return;
    }
    int i;
    if ((this.cAD) && (alxg.videoDuration < 500L))
    {
      i = 1;
      if ((paramVideoCaptureResult.videoFrameCount >= this.aBx) && (i == 0)) {
        break label191;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMCameraCaptureUnit", 2, "onVideoCaptured. videoFrameCount = " + paramVideoCaptureResult.videoFrameCount + " ; minFrameCount = " + this.aBx);
      }
      if ((!this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.aRv()) || (!this.cAD)) {
        break label168;
      }
      a(null, false);
    }
    for (;;)
    {
      rar.a("clk_shoot", rar.ea(alwx.dyy), 2, new String[0]);
      return;
      i = 0;
      break;
      label168:
      this.drq = false;
      ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.5(this));
    }
    label191:
    coz();
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void a(CameraCaptureView.h paramh) {}
  
  protected void a(CameraCaptureView paramCameraCaptureView)
  {
    if (paramCameraCaptureView != null) {
      paramCameraCaptureView.Ot(false);
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public boolean aNt()
  {
    return (this.LX.size() > 0) && (this.LY.size() > 0);
  }
  
  public boolean aNv()
  {
    if (this.cAD) {
      return this.eI.get();
    }
    return true;
  }
  
  public void ac(boolean paramBoolean, String paramString)
  {
    this.drz = paramBoolean;
    this.cSp = paramString;
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.2(this, paramString));
    }
    alxg.dyL = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Is();
  }
  
  public void auC()
  {
    if (this.drt) {
      if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
        this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().eNY();
      }
    }
    for (;;)
    {
      rar.a("clk_cancel", rar.ea(this.jdField_b_of_type_Aybv.RI()), 0, new String[0]);
      return;
      this.jdField_a_of_type_Aycb.getActivity().onBackPressed();
      alxg.dKF();
      alwx.dKw();
    }
  }
  
  public void b(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.bP((float)paramLocalMediaInfo.mDuration);
  }
  
  public void bST()
  {
    if (this.aBw != -1L) {
      QLog.d("QIMCameraCaptureUnit", 1, "(NEW)LaunchActivity to FirstFrameShown cost : " + (System.currentTimeMillis() - this.aBw) + "ms");
    }
  }
  
  public void bSU() {}
  
  public void bSV() {}
  
  public void cN(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void coA()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureUnit", 2, "onCaptureButtonVideoStart");
    }
    this.drq = true;
    if (this.cAD) {
      this.eI.set(false);
    }
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.dKM();
    coy();
  }
  
  public void coB()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureUnit", 2, "onCaptureButtonVideoStop");
    }
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.dKN();
  }
  
  public void cox()
  {
    int i = 8;
    if (aeah.agb())
    {
      this.hQ.setVisibility(0);
      this.hR.setVisibility(0);
      if (!GLVideoClipUtil.aRj()) {
        break label88;
      }
      this.hS.setVisibility(0);
      label39:
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
      if (!this.cAD) {
        break label151;
      }
      if (!this.drt) {
        break label121;
      }
      if (this.cz != null) {
        this.cz.setVisibility(0);
      }
    }
    label88:
    label121:
    do
    {
      do
      {
        return;
        this.hQ.setVisibility(4);
        break;
        if ((this.hS == null) || (!this.drr)) {
          break label39;
        }
        this.hS.setVisibility(0);
        this.hS.setSelected(false);
        break label39;
      } while (this.eZ == null);
      localViewGroup = this.eZ;
      if (this.drn) {}
      for (;;)
      {
        localViewGroup.setVisibility(i);
        return;
        i = 0;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.reset();
      if (this.drm) {
        this.HK.setVisibility(0);
      }
    } while (this.eZ == null);
    label151:
    ViewGroup localViewGroup = this.eZ;
    if (this.drn) {}
    for (;;)
    {
      localViewGroup.setVisibility(i);
      return;
      i = 0;
    }
  }
  
  public void coy()
  {
    this.hQ.setVisibility(8);
    this.hR.setVisibility(8);
    this.hS.setVisibility(8);
    this.HK.setVisibility(8);
    if (this.cz != null) {
      this.cz.setVisibility(8);
    }
    if (this.eZ != null) {
      this.eZ.setVisibility(8);
    }
  }
  
  protected void coz()
  {
    if (!this.cAD) {
      ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.6(this));
    }
    this.g = new LocalMediaInfo();
    this.g.path = this.c.videoMp4FilePath;
    this.g.mMimeType = "video";
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, new Object[] { "onVideoCaptured. isSegmentMode:", Boolean.valueOf(this.cAD), " result = " + this.c.toString() });
    }
    MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(this, this.g);
  }
  
  public void dKK()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureUnit", 2, "onCaptureButtonPhoto!");
    }
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.dKU();
  }
  
  public void dLc()
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (!(this.jdField_a_of_type_Aycb.getActivity() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Aycb.getActivity();
    int i;
    if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label97;
      }
    }
    label97:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label102;
      }
      localQIMCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
      i = 0;
      break;
    }
    label102:
    if (i != 0)
    {
      localQIMCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      return;
    }
    localQIMCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Aycb.getActivity();
    int i;
    int j;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label93;
      }
      j = 1;
      label43:
      if ((i == 0) || (j == 0)) {
        break label98;
      }
      localObject = aqha.i(new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.13(this, (String)localObject));
      return;
      i = 0;
      break;
      label93:
      j = 0;
      break label43;
      label98:
      if (i != 0) {
        localObject = aqha.i(new String[] { "android.permission.CAMERA" });
      } else {
        localObject = aqha.i(new String[] { "android.permission.RECORD_AUDIO" });
      }
    }
  }
  
  public void eEV()
  {
    this.jdField_a_of_type_Ayca.acX(2);
  }
  
  protected void eEW()
  {
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = ((QIMCameraCaptureButtonLayout)this.rootView.findViewById(2131364256));
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.a(this, this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout = ((QIMCameraSegmentCaptureButtonLayout)this.rootView.findViewById(2131377927));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.a(this, this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
  }
  
  public void eEX()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.getLayoutParams();
    localLayoutParams.bottomMargin = wja.dp2px(-30.0F, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.getResources());
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.eTW();
    if (this.drm)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.HK.getLayoutParams();
      localLayoutParams.bottomMargin = wja.dp2px(50.0F, this.HK.getResources());
      this.HK.setLayoutParams(localLayoutParams);
    }
  }
  
  protected void eEY()
  {
    ThreadManager.excute(new QIMCameraCaptureUnit.1(this), 64, null, true);
  }
  
  public void eEZ()
  {
    coy();
    eFd();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
    R(this.LY, this.LX);
    this.drs = true;
  }
  
  public void eFa()
  {
    if (this.ad != null) {
      return;
    }
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    String str = localActivity.getString(2131701579);
    this.ad = aqha.a(localActivity, 230).setMessage(str).setPositiveButton(localActivity.getString(2131695681), new awrv(this));
  }
  
  public void eFb()
  {
    if (!aNv()) {}
    do
    {
      do
      {
        return;
      } while (!aNt());
      this.LX.remove(this.LX.size() - 1);
      this.LY.remove(this.LY.size() - 1);
      this.drv = true;
      if (QLog.isColorLevel()) {
        QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentCaptureDelete, mediaInfos size = " + this.LX.size());
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.eNz();
      if ((this.LX.size() == 0) || (this.LY.size() == 0)) {
        eFc();
      }
    } while ((this.g == null) || (this.g.mTransferPosList == null) || (this.g.mTransferPosList.size() <= 0));
    this.g.mTransferPosList.remove(this.g.mTransferPosList.size() - 1);
  }
  
  protected void eFc()
  {
    Xq(false);
  }
  
  public void eFd()
  {
    if (this.LO != null) {
      this.LO.setVisibility(0);
    }
  }
  
  public void eFe()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureUnit", 2, "onCaptureButtonTouchedWhenDisable");
    }
  }
  
  public void eFf()
  {
    coy();
  }
  
  public void eFg()
  {
    cox();
    eFm();
    QQToast.a(BaseApplicationImpl.getContext(), this.cSo, 0).show();
  }
  
  public void eFh() {}
  
  public void eFi()
  {
    this.dru = true;
    coy();
    eFd();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
  }
  
  public void eFj() {}
  
  public void eFk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentCaptureError, mediaInfos size = " + this.LX.size());
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.eNz();
    eFl();
  }
  
  public void eFl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentError");
    }
    this.eI.set(true);
    this.dru = false;
    if (this.LO != null) {
      this.LO.setVisibility(8);
    }
  }
  
  public void eFm() {}
  
  public void eFn() {}
  
  public void eFo() {}
  
  public void eFp() {}
  
  public void eFq() {}
  
  public void eFr() {}
  
  public void eFs()
  {
    this.dro = ayxa.a(this.top_blackLH, this.bottom_blackLH, aqnm.dip2px(1.0F));
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(this.rootView, this.bottom_blackLH, this.dro, this.nQ);
    }
  }
  
  public ArrayList<Integer> eG()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(0));
    return localArrayList;
  }
  
  public void finish() {}
  
  public Activity getActivity()
  {
    if (this.jdField_a_of_type_Aycb == null) {
      return null;
    }
    return this.jdField_a_of_type_Aycb.getActivity();
  }
  
  protected int getLayoutId()
  {
    return 2131561101;
  }
  
  public View getView()
  {
    return this.rootView;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCameraPermissionResult(true);
  }
  
  protected List<View> hE()
  {
    return null;
  }
  
  public void lp(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.14(this));
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    this.drA = false;
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwr);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwm);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwo);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onPause();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.onPause();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, "onActivityResume");
    }
    this.drA = true;
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwr);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwm);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwo);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onResume();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.onResume();
    if (this.cAD) {
      this.eI.set(true);
    }
    cox();
    if (this.LO != null) {
      this.LO.setVisibility(8);
    }
    if (this.HK.getVisibility() == 0) {
      eEY();
    }
    this.drs = false;
    Bx(false);
    if (this.drp)
    {
      this.drp = false;
      a(this.d, this.h);
      this.d = null;
      this.h = null;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.eNW();
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.onActivityResume();
    }
  }
  
  public void onActivityStart()
  {
    super.onActivityStart();
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.onActivityStart();
    }
  }
  
  public void onActivityStop()
  {
    super.onActivityStop();
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.onActivityStop();
    }
  }
  
  public boolean onBackPressed()
  {
    if (this.drt)
    {
      if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
        this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().eNY();
      }
      return false;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.Xx(false);
    }
    this.jdField_a_of_type_Aycb.eET();
    return true;
  }
  
  public void onCaptureError(int paramInt)
  {
    this.drq = false;
    QLog.e("QIMCameraCaptureUnit", 2, "onCaptureError. errorCode = " + paramInt);
    ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.7(this, paramInt));
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    int i = 1;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      axxe.a(this.hQ, 200L, null);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.dKT();
      if (this.hQ != null)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Is() != 1) {
          break label148;
        }
        this.hQ.setContentDescription(this.hQ.getResources().getString(2131718861));
      }
      for (;;)
      {
        alxg.dKG();
        rar.a("clk_switch", this.jdField_b_of_type_Aybv.RI(), 0, new String[0]);
        break;
        label148:
        this.hQ.setContentDescription(this.hQ.getResources().getString(2131718862));
      }
      axxe.a(this.hR, 200L, null);
      boolean bool;
      if (!this.hR.isSelected())
      {
        bool = true;
        label195:
        if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.bj(bool)) {
          this.hR.setSelected(bool);
        }
        alxg.dKE();
        if (!bool) {
          break label261;
        }
      }
      for (;;)
      {
        alwx.TC(i);
        rar.a("clk_flash", this.jdField_b_of_type_Aybv.RI(), 0, new String[0]);
        axim.a().eKQ();
        break;
        bool = false;
        break label195;
        label261:
        i = 2;
      }
      axxe.a(this.hS, 200L, null);
      if (!this.hS.isSelected())
      {
        bool = true;
        label290:
        this.hS.setSelected(bool);
        this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Or(bool);
        if (bool) {
          break label343;
        }
        this.drr = true;
        label318:
        alxg.Oo(bool);
        if (!bool) {
          break label351;
        }
      }
      label343:
      label351:
      for (i = j;; i = 2)
      {
        alwx.TB(i);
        break;
        bool = false;
        break label290;
        this.drr = false;
        break label318;
      }
      axxe.a(paramView, 200L, null);
      auC();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.aBw = this.jdField_a_of_type_Aycb.getActivity().getIntent().getLongExtra("ACTIVITY_START_TIME", -1L);
    if (paramBundle != null) {
      this.c = ((CameraCaptureView.VideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
    }
    this.jdField_a_of_type_Aycb.getActivity().registerReceiver(this.mReceiver, a());
    alxg.clear();
  }
  
  public View onCreateView()
  {
    aytu.AK("onCreateView");
    Object localObject = new RelativeLayout(this.jdField_a_of_type_Aycb.getActivity());
    ((RelativeLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.rootView = this.jdField_a_of_type_Aycb.getActivity().getLayoutInflater().inflate(getLayoutId(), (ViewGroup)localObject, false).findViewById(2131367347);
    aytu.AK("onCreateView1");
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)this.rootView.findViewById(2131364201));
    a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureParam(a());
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(true);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureListener(this);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeListener(this);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCameraPermissionListener(this);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setUseVideoOrientation(false);
    if (anki.axO()) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDynamicResolutionMode(true);
    }
    for (;;)
    {
      this.nQ = ((RelativeLayout)this.rootView.findViewById(2131367348));
      this.top_blackLH = ((LinearLayout)this.rootView.findViewById(2131363559));
      this.bottom_blackLH = ((RelativeLayout)this.rootView.findViewById(2131363557));
      this.dro = ayxa.a(this.top_blackLH, this.bottom_blackLH, aqnm.dip2px(1.0F));
      if (QLog.isColorLevel()) {
        QLog.i("QIMCameraCaptureUnit", 1, "initLiuHaiScreenUI_Common mEnableLHLayout:" + this.dro);
      }
      this.hQ = ((Button)this.rootView.findViewById(2131364422));
      this.hQ.setOnClickListener(this);
      this.hQ.setContentDescription(this.hQ.getResources().getString(2131718862));
      if (!aeah.agb())
      {
        this.hQ.setVisibility(4);
        this.hQ.setEnabled(false);
      }
      this.hR = ((Button)this.rootView.findViewById(2131367213));
      this.hR.setOnClickListener(this);
      this.hR.setSelected(false);
      this.hS = ((Button)this.rootView.findViewById(2131365586));
      this.hS.setOnClickListener(this);
      this.hS.setSelected(false);
      this.hS.setVisibility(8);
      this.fd = ((TextView)this.rootView.findViewById(2131364221));
      this.HL = ((ImageView)this.rootView.findViewById(2131364226));
      eEW();
      this.LO = this.rootView.findViewById(2131374692);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)this.rootView.findViewById(2131364211));
      this.drm = this.jdField_a_of_type_Aycb.getActivity().getIntent().getBooleanExtra("enable_local_video", false);
      this.HK = ((ImageView)this.rootView.findViewById(2131370835));
      this.HK.setOnClickListener(this);
      this.HK.setVisibility(8);
      localObject = this.rootView.getResources().getDrawable(2130850065);
      int i = wja.dp2px(36.0F, this.rootView.getResources());
      ((Drawable)localObject).setBounds(0, 0, i, i);
      this.HK.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_Alwr = new alwr(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
      this.jdField_a_of_type_Alwm = a();
      this.jdField_a_of_type_Alwo = new alwo(this.jdField_a_of_type_Aycb.getActivity());
      this.Gm = this.rootView.findViewById(2131367317);
      this.cz = ((FrameLayout)this.rootView.findViewById(2131364263));
      this.cz.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController = new CaptureModeController(this);
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.eNV();
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(this.rootView, this.bottom_blackLH, this.dro);
      this.eZ = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.eZ;
      return this.rootView;
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDynamicResolutionMode(false);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.onDestroy();
    }
    GLGestureProxy.getInstance().removeAllListener();
    this.jdField_a_of_type_Aycb.getActivity().unregisterReceiver(this.mReceiver);
  }
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, new Object[] { "onMediaInfoChanged, suc:", Boolean.valueOf(paramBoolean), " isSegmentMode:", Boolean.valueOf(this.cAD) });
    }
    this.drq = false;
    if (!paramBoolean)
    {
      onCaptureError(101);
      return;
    }
    int i = j;
    if (this.cAD)
    {
      i = j;
      if (!anhq.a().axb()) {
        i = 1;
      }
    }
    if (i == 0)
    {
      a(this.c, paramLocalMediaInfo);
      this.drs = true;
      return;
    }
    a(paramLocalMediaInfo, true);
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.c);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.Ny, this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  protected void resumeMusic()
  {
    if (this.dry)
    {
      this.dry = false;
      axro localaxro = (axro)axov.a().c(8);
      if (localaxro != null) {
        localaxro.resumeMusic();
      }
    }
  }
  
  public String yI()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView != null) {
      return this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.yI();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awrq
 * JD-Core Version:    0.7.0.1
 */