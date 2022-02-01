import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.c;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.d;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.ptv.LWMotionEvent;
import dov.com.qq.im.ptv.LightVideoConfigMgr;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.10;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.11;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.12;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.2;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.4;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.6;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.7;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.8;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.9;
import dov.com.qq.im.ptv.LightWeightCaptureButtonCornerLayout;
import dov.com.qq.im.ptv.LightWeightCaptureButtonHorizontalLayout;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout.b;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout.c;
import dov.com.qq.im.ptv.LightWeightCaptureShadow;
import dov.com.qq.im.ptv.LightWeightProgress;
import dov.com.qq.im.ptv.PtvCameraCaptureActivity;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

@TargetApi(11)
public class ayan
  implements View.OnClickListener, View.OnTouchListener, aybu, aycc, CameraCaptureView.c, CameraCaptureView.d, SimpleEffectsCaptureView.b, LightWeightCaptureButtonLayout.b, LightWeightCaptureButtonLayout.c
{
  protected alwm a;
  protected alwp a;
  protected alwr a;
  public ayca a;
  public aycb a;
  protected CameraFocusView a;
  protected SimpleEffectsCaptureView a;
  public LightWeightCaptureButtonLayout a;
  private LightWeightCaptureShadow a;
  protected long aBw;
  private long aBx = 3L;
  private aqju ad;
  protected aybv b;
  protected LightWeightProgress b;
  private alvs c;
  protected int cdN;
  protected boolean drq;
  protected boolean dxD;
  protected boolean dxE;
  private boolean dxF;
  private GestureDetector mGestureDetector;
  private BroadcastReceiver mReceiver = new ayao(this);
  protected RelativeLayout oe;
  protected View rootView;
  private Handler uiHandler;
  protected ImageView xR;
  
  public ayan()
  {
    this.jdField_b_of_type_Aybv = new aybv(10000, 100, 2);
  }
  
  public ayan(aycb paramaycb, ayca paramayca)
  {
    this.jdField_b_of_type_Aybv = new aybv(10000, 100, 2);
    this.jdField_a_of_type_Aycb = paramaycb;
    this.jdField_a_of_type_Ayca = paramayca;
  }
  
  private void dQI()
  {
    this.dxD = false;
    if (this.jdField_a_of_type_Aycb.getActivity().getIntent().getIntExtra("flow_camera_show_mode_style", 0) == 1) {
      this.dxD = true;
    }
    this.dxE = this.jdField_a_of_type_Aycb.getActivity().getIntent().getBooleanExtra("flow_camera_show_panel", false);
    this.cdN = this.jdField_a_of_type_Aycb.getActivity().getIntent().getIntExtra("light_video_entry_type", 0);
  }
  
  private void eFa()
  {
    if (this.ad == null)
    {
      Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
      String str = localActivity.getString(2131701579);
      this.ad = aqha.a(localActivity, 230).setMessage(str).setPositiveButton(localActivity.getString(2131695681), new ayar(this));
    }
  }
  
  private void ePx()
  {
    if (this.dxD)
    {
      this.c = alvs.a();
      this.rootView.post(new LightWeightCameraCaptureUnit.6(this));
    }
  }
  
  public void OB(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightCameraCaptureUnit", 2, "onSoLoad soLoaded=" + paramBoolean);
    }
  }
  
  protected alwm a()
  {
    return new alwm(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView);
  }
  
  protected CameraCaptureView.e a()
  {
    return aywy.a().c(this.jdField_a_of_type_Aycb.getActivity());
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightCameraCaptureUnit", 2, "onVideoCaptured[co-new]. videoFrameCount = " + paramVideoCaptureResult.videoFrameCount + " ; minFrameCount = " + this.aBx);
    }
    if (paramVideoCaptureResult.videoFrameCount < this.aBx)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightWeightCameraCaptureUnit", 2, "onVideoCaptured. videoFrameCount = " + paramVideoCaptureResult.videoFrameCount + " ; minFrameCount = " + this.aBx);
      }
      this.drq = false;
      ThreadManager.getUIHandler().post(new LightWeightCameraCaptureUnit.7(this));
      rar.a("clk_shoot", rar.ea(alwx.dyy), 2, new String[0]);
    }
  }
  
  public void a(CameraCaptureView.h paramh) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public void ac(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new LightWeightCameraCaptureUnit.2(this, paramString));
    }
    alxg.dyL = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.Is();
  }
  
  public void aeW(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.getBeautyLevel() == paramInt) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setBeauty(paramInt);
  }
  
  public void b(LWMotionEvent paramLWMotionEvent)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("IPC onTouchHook...  uiHandler!=null: ");
      if (this.uiHandler == null) {
        break label68;
      }
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("LightWeightCameraCaptureUnit", 2, bool);
      if (this.uiHandler != null) {
        this.uiHandler.post(new LightWeightCameraCaptureUnit.11(this, paramLWMotionEvent));
      }
      return;
    }
  }
  
  public void bST()
  {
    if (this.aBw != -1L)
    {
      long l = System.currentTimeMillis() - this.aBw;
      QLog.d("LightWeightCameraCaptureUnit", 1, "(NEW)LaunchActivity to FirstFrameShown cost : " + l + "ms");
      anfv.aS("sv_light_cost_time_total", l);
    }
    aytu.eTy();
    QLog.i("LightWeightCameraCaptureUnit", 1, "(NEW)LaunchActivity to onFirstFrameShown mIsCornerStyle: " + this.dxD);
    this.rootView.post(new LightWeightCameraCaptureUnit.4(this));
  }
  
  public void bSU() {}
  
  public void bSV()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightCameraCaptureUnit", 2, "onVideoCaptureStart[co-new].");
    }
  }
  
  protected View cM()
  {
    return null;
  }
  
  public void coA()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LightWeightCameraCaptureUnit", 2, "onCaptureButtonVideoStart!");
    }
    this.drq = true;
    boolean bool = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.aQc();
    if (QLog.isColorLevel()) {
      QLog.i("LightWeightCameraCaptureUnit", 2, "onCaptureButtonVideoStart!  enabled: " + bool);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.dKM();
    }
  }
  
  public void coB()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LightWeightCameraCaptureUnit", 2, "onCaptureButtonVideoStop!");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.dKN();
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.setCaptureEnable(false);
  }
  
  public void dLA()
  {
    aeW(60);
  }
  
  public void dLc()
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (!(this.jdField_a_of_type_Aycb.getActivity() instanceof PtvCameraCaptureActivity)) {
      return;
    }
    PtvCameraCaptureActivity localPtvCameraCaptureActivity = (PtvCameraCaptureActivity)this.jdField_a_of_type_Aycb.getActivity();
    int i;
    if (localPtvCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (localPtvCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label97;
      }
    }
    label97:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label102;
      }
      localPtvCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
      i = 0;
      break;
    }
    label102:
    if (i != 0)
    {
      localPtvCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      return;
    }
    localPtvCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    int j = 1;
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Aycb.getActivity();
    int i;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label80;
      }
      label43:
      if ((i == 0) || (j == 0)) {
        break label85;
      }
      localObject = acfp.m(2131707709);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new LightWeightCameraCaptureUnit.10(this, (String)localObject));
      return;
      i = 0;
      break;
      label80:
      j = 0;
      break label43;
      label85:
      if (i != 0) {
        localObject = acfp.m(2131707741);
      } else {
        localObject = acfp.m(2131707739);
      }
    }
  }
  
  protected void eEV()
  {
    this.jdField_a_of_type_Ayca.acX(2);
  }
  
  public void eFm() {}
  
  public void ePA()
  {
    this.jdField_a_of_type_Ayca.acX(1);
  }
  
  public void ePB()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LightWeightCameraCaptureUnit", 2, "onCaptureButtonVideoCancel!");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.dKL();
  }
  
  public void ePC()
  {
    if (!this.dxD) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("IPC onIPCExitEvent...  uiHandler!=null: ");
      if (this.uiHandler == null) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("LightWeightCameraCaptureUnit", 2, bool);
      if (this.uiHandler == null) {
        break;
      }
      this.uiHandler.post(new LightWeightCameraCaptureUnit.12(this));
      return;
    }
  }
  
  public void ePy()
  {
    ThreadManager.getUIHandler().post(new LightWeightCameraCaptureUnit.8(this));
  }
  
  public void ePz()
  {
    this.xR.setVisibility(0);
    this.rootView.setOnTouchListener(this);
  }
  
  public void ecC()
  {
    this.xR.setVisibility(8);
    this.rootView.setOnTouchListener(null);
  }
  
  public void finish() {}
  
  protected int getLayoutId()
  {
    return 2131561099;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setCameraPermissionResult(true);
  }
  
  public void kR(long paramLong) {}
  
  public void lp(int paramInt1, int paramInt2) {}
  
  public void onActivityPause()
  {
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwr);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwm);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwp);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.onPause();
    if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.onPause();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onActivityResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightCameraCaptureUnit", 2, "onActivityResume");
    }
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwr);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwm);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwp);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.onResume();
    if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.onResume();
    }
    if (!this.dxF)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      localIntentFilter.addAction("tencent.qq.ipc.event");
      this.jdField_a_of_type_Aycb.getActivity().registerReceiver(this.mReceiver, localIntentFilter);
      this.dxF = true;
    }
    ePx();
  }
  
  public void onActivityStart() {}
  
  public void onActivityStop()
  {
    if (this.dxF)
    {
      this.jdField_a_of_type_Aycb.getActivity().unregisterReceiver(this.mReceiver);
      this.dxF = false;
    }
  }
  
  public boolean onBackPressed()
  {
    this.jdField_a_of_type_Aycb.eET();
    return true;
  }
  
  public void onCaptureError(int paramInt)
  {
    this.drq = false;
    QLog.e("LightWeightCameraCaptureUnit", 2, "onCaptureError. errorCode = " + paramInt);
    ThreadManager.getUIHandler().post(new LightWeightCameraCaptureUnit.9(this, paramInt));
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.xR) {
      this.jdField_a_of_type_Ayca.acX(0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.aBw = this.jdField_a_of_type_Aycb.getActivity().getIntent().getLongExtra("ACTIVITY_START_TIME", -1L);
    alxg.clear();
    this.uiHandler = new Handler();
    this.mGestureDetector = new GestureDetector(this.jdField_a_of_type_Aycb.getActivity(), new ayan.a(null));
  }
  
  public View onCreateView()
  {
    dQI();
    View localView = cM();
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_Aycb.getActivity());
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    Object localObject = localView;
    if (localView == null) {
      localObject = this.jdField_a_of_type_Aycb.getActivity().getLayoutInflater().inflate(getLayoutId(), localRelativeLayout, false);
    }
    this.rootView = ((View)localObject).findViewById(2131367347);
    if (!this.dxD) {
      this.rootView.setOnTouchListener(this);
    }
    this.oe = ((RelativeLayout)this.rootView.findViewById(2131364270));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView = ((SimpleEffectsCaptureView)this.rootView.findViewById(2131364201));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.Ot(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setCaptureParam(a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setCaptureListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setCameraPermissionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setUseVideoOrientation(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setFaceEffectListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setDynamicResolutionMode(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)this.rootView.findViewById(2131364211));
    this.jdField_a_of_type_Alwr = new alwr(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView);
    this.jdField_a_of_type_Alwm = a();
    this.jdField_a_of_type_Alwp = new alwp();
    localObject = (SessionInfo)this.jdField_a_of_type_Aycb.getActivity().getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    if (this.dxD)
    {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout = ((LightWeightCaptureButtonCornerLayout)this.rootView.findViewById(2131364119));
      if (localObject != null) {
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.mSessionType = ((SessionInfo)localObject).cZ;
      }
      if (!this.dxD) {
        break label545;
      }
      ainc.PU(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.mSessionType);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureShadow = ((LightWeightCaptureShadow)this.rootView.findViewById(2131364271));
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureShadow.setVisibility(0);
      this.jdField_b_of_type_DovComQqImPtvLightWeightProgress = ((LightWeightProgress)this.rootView.findViewById(2131373699));
      int i = LightVideoConfigMgr.a().RC();
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.setMaxDuration(i * 1000);
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.a(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView, this.jdField_b_of_type_DovComQqImPtvLightWeightProgress);
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.setVisibility(0);
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.setUIButtonListener(this);
      if (this.dxE)
      {
        localObject = (RelativeLayout.LayoutParams)this.oe.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = (azbx.dip2px(73.5F) - azbx.dip2px(8.0F));
        this.oe.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.jdField_b_of_type_DovComQqImPtvLightWeightProgress.setStrokeWidth(2.0F);
      this.jdField_b_of_type_DovComQqImPtvLightWeightProgress.setVisibility(8);
      this.xR = ((ImageView)this.rootView.findViewById(2131363227));
      this.xR.setOnClickListener(this);
      if (!this.dxD) {
        this.xR.setVisibility(0);
      }
      return this.rootView;
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout = ((LightWeightCaptureButtonHorizontalLayout)this.rootView.findViewById(2131364120));
      break;
      label545:
      ainc.PT(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.mSessionType);
      ainc.PW(this.cdN);
    }
  }
  
  public void onDestroy()
  {
    GLGestureProxy.getInstance().removeAllListener();
    if (this.dxF)
    {
      this.jdField_a_of_type_Aycb.getActivity().unregisterReceiver(this.mReceiver);
      this.dxF = false;
    }
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onProgress(int paramInt)
  {
    this.jdField_b_of_type_DovComQqImPtvLightWeightProgress.setCurrentProgress(paramInt);
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.mGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  class a
    implements GestureDetector.OnGestureListener
  {
    private a() {}
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      paramMotionEvent2.getX();
      paramMotionEvent1.getX();
      paramMotionEvent1.getX();
      paramMotionEvent2.getX();
      paramFloat1 = paramMotionEvent2.getY();
      float f = paramMotionEvent1.getY();
      paramMotionEvent1.getY();
      paramMotionEvent2.getY();
      if ((paramFloat1 - f > 120) && (Math.abs(paramFloat2) > 20)) {
        ayan.this.ePA();
      }
      return true;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent) {}
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return true;
    }
    
    public void onShowPress(MotionEvent paramMotionEvent) {}
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayan
 * JD-Core Version:    0.7.0.1
 */