package dov.com.qq.im.ptv;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anfv;
import angp.a;
import ankq;
import aqiw;
import ayan;
import aywy;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureSegmentView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.c;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import java.util.ArrayList;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

public class LightVideoSoDownloadFragment
  extends PublicBaseFragment
  implements View.OnClickListener, angp.a, CameraCaptureView.c, ShortVideoResourceManager.c
{
  private ImageView IK;
  public CameraCaptureSegmentView a;
  protected LightWeightProgress a;
  private int aEt;
  private Bundle args;
  private boolean byH;
  private boolean byI;
  private String cWB;
  private int cjq;
  private int cjr;
  private boolean dxB;
  private boolean dxC;
  private int eJd;
  protected CircleProgress f;
  private boolean hasRequest;
  BaseActivity mActivity;
  private QQAppInterface mApp;
  protected RelativeLayout oe;
  protected View rootView;
  private TextView tipsView;
  
  private void AL(String paramString)
  {
    ThreadManager.getUIHandler().post(new LightVideoSoDownloadFragment.3(this, paramString));
  }
  
  private void AM(String paramString)
  {
    ThreadManager.getUIHandler().post(new LightVideoSoDownloadFragment.2(this, paramString));
  }
  
  private void cxJ()
  {
    boolean bool = aqiw.isNetworkAvailable(null);
    VideoEnvironment.k("LightVideoSoDownloadFragment", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.k("LightVideoSoDownloadFragment", acfp.m(2131707687), null);
      ShortVideoResourceManager.b(this.mApp, this);
      return;
    }
    AM(acfp.m(2131707703));
  }
  
  private void initParam()
  {
    this.dxB = this.mActivity.getIntent().getBooleanExtra("flow_camera_show_panel", false);
    if (!this.dxB) {
      this.mActivity.getWindow().setBackgroundDrawableResource(2130845451);
    }
    this.dxC = this.mActivity.isInMultiWindow();
    VideoEnvironment.k("LightVideoSoDownloadFragment", "initParam : mIsMultiWindowMode=" + this.dxC, null);
    if (this.dxC)
    {
      QQToast.a(this.mActivity, acfp.m(2131707693), 0).show();
      this.mActivity.finish();
    }
    do
    {
      return;
      this.cWB = this.mActivity.getIntent().getStringExtra("PTV_SO_ARG_FRAGMENT_CLASS");
      this.hasRequest = this.mActivity.getIntent().hasExtra("PTV_pendingIntentRequest");
      if (this.hasRequest) {
        this.eJd = this.mActivity.getIntent().getIntExtra("PTV_pendingIntentRequest", 0);
      }
      this.args = this.mActivity.getIntent().getExtras();
    } while (!QLog.isColorLevel());
    QLog.i("LightVideoSoDownloadFragment", 2, "fragmentName:" + this.cWB + " hasRequest:" + this.hasRequest + "pendingIntentRequest" + this.eJd);
  }
  
  protected CameraCaptureView.e a()
  {
    return aywy.a().c(getActivity());
  }
  
  public void aFW()
  {
    AM(acfp.m(2131707705));
    VideoEnvironment.k("LightVideoSoDownloadFragment", acfp.m(2131707692), null);
    anfv.jw(3, -1500);
  }
  
  public void cu(int paramInt1, int paramInt2)
  {
    VideoEnvironment.k("LightVideoSoDownloadFragment", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.k("LightVideoSoDownloadFragment", acfp.m(2131707702) + paramInt2 + "]", null);
        ShortVideoResourceManager.Qu(acfp.m(2131707696));
        anfv.jw(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.mApp, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.k("LightVideoSoDownloadFragment", acfp.m(2131707699), null);
        ShortVideoResourceManager.a(this.mApp, localArrayList, this);
        paramInt1 = ankq.aB(VideoEnvironment.getContext());
        VideoEnvironment.k("LightVideoSoDownloadFragment", "PtvFilterSoLoad.getFilterSoState resultCode=" + paramInt1, null);
        if (paramInt1 == 2)
        {
          ShortVideoResourceManager.b(this.mApp, localArrayList, this);
          return;
        }
        if (paramInt1 == 1) {
          ShortVideoResourceManager.b(this.mApp, localArrayList, this);
        }
        this.cjq = 100;
        this.byI = true;
        VideoEnvironment.k("LightVideoSoDownloadFragment", "onConfigResult| supportSVFilterDownloadSo=false", null);
        return;
      }
      VideoEnvironment.k("LightVideoSoDownloadFragment", acfp.m(2131707685) + paramInt1 + "]", null);
      ShortVideoResourceManager.Qu(acfp.m(2131707674));
      anfv.jw(1, paramInt1);
      return;
    }
    VideoEnvironment.k("LightVideoSoDownloadFragment", acfp.m(2131707680) + paramInt2 + "]", null);
    ShortVideoResourceManager.Qu(acfp.m(2131707676));
    anfv.jw(1, paramInt2);
  }
  
  public void dLc()
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (!(getActivity() instanceof PublicTransFragmentActivity)) {
      return;
    }
    PublicTransFragmentActivity localPublicTransFragmentActivity = (PublicTransFragmentActivity)getActivity();
    int i;
    if (localPublicTransFragmentActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (localPublicTransFragmentActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label87;
      }
    }
    label87:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label92;
      }
      localPublicTransFragmentActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
      i = 0;
      break;
    }
    label92:
    if (i != 0)
    {
      localPublicTransFragmentActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      return;
    }
    localPublicTransFragmentActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    int j = 1;
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = getActivity();
    int i;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label75;
      }
      label38:
      if ((i == 0) || (j == 0)) {
        break label80;
      }
      localObject = acfp.m(2131707688);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new LightVideoSoDownloadFragment.4(this, (String)localObject));
      return;
      i = 0;
      break;
      label75:
      j = 0;
      break label38;
      label80:
      if (i != 0) {
        localObject = acfp.m(2131707701);
      } else {
        localObject = acfp.m(2131707683);
      }
    }
  }
  
  protected void ePv()
  {
    if ((this.byH) && (this.byI)) {
      ePw();
    }
  }
  
  public void ePw()
  {
    if (TextUtils.isEmpty(this.cWB)) {
      this.cWB = ayan.class.getName();
    }
    if (this.args != null) {
      if (getActivity() == null) {
        QLog.d("LightVideoSoDownloadFragment", 1, "activity is null");
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (this.hasRequest)
      {
        this.args.putBoolean("flow_camera_download_light", true);
        PtvCameraCaptureActivity.b(getActivity(), this.cWB, this.args, this.eJd);
        return;
      }
      PtvCameraCaptureActivity.b(getActivity(), this.cWB, this.args);
      getActivity().finish();
      return;
    }
    QLog.i("LightVideoSoDownloadFragment", 2, "fragmentName:" + this.cWB + " hasRequest:" + this.hasRequest + "pendingIntentRequest" + this.eJd + " mIsMultiWindowMode: " + this.dxC + " args=null error.");
  }
  
  public void f(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.aEt = i;
    }
    for (;;)
    {
      this.cjr = ((this.aEt + this.cjq) / 2);
      AL("doUserDownloadResourceAVCodec:");
      AM(acfp.m(2131707689) + this.cjr + "%");
      VideoEnvironment.k("LightVideoSoDownloadFragment", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
      if (paramString.startsWith("new_qq_android_native_short_filter_")) {
        this.cjq = i;
      }
    }
  }
  
  protected int getLayoutId()
  {
    return 2131561100;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setCameraPermissionResult(true);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void o(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      if (paramInt != 0)
      {
        VideoEnvironment.k("LightVideoSoDownloadFragment", acfp.m(2131707690) + paramInt + "]", null);
        ShortVideoResourceManager.Qu(acfp.m(2131707675));
        anfv.jw(2, paramInt);
      }
    }
    for (;;)
    {
      VideoEnvironment.k("LightVideoSoDownloadFragment", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      this.aEt = 100;
      this.byH = true;
      ePv();
      continue;
      if (paramString1.startsWith("new_qq_android_native_short_filter_")) {
        if (paramInt != 0)
        {
          VideoEnvironment.k("LightVideoSoDownloadFragment", acfp.m(2131707694) + paramInt + "]", null);
          ShortVideoResourceManager.Qu(acfp.m(2131707679));
          anfv.jw(2, paramInt);
        }
        else
        {
          this.cjq = 100;
          this.byI = true;
          ePv();
        }
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    VideoEnvironment.k("LightVideoSoDownloadFragment", "onActivityResult : hasRequest=" + this.hasRequest, null);
    if (this.hasRequest)
    {
      getActivity().setResult(paramInt2, paramIntent);
      getActivity().finish();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = getActivity();
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
      getActivity().doOnBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initParam();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = new RelativeLayout(getActivity());
    paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramLayoutInflater = paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
    this.rootView = paramLayoutInflater.findViewById(2131367347);
    this.oe = ((RelativeLayout)this.rootView.findViewById(2131364270));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView = ((CameraCaptureSegmentView)this.rootView.findViewById(2131364201));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.Ot(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setCaptureParam(a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setCameraPermissionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setUseVideoOrientation(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setDynamicResolutionMode(false);
    this.f = ((CircleProgress)paramLayoutInflater.findViewById(2131365505));
    paramViewGroup = getResources();
    this.f.setBgAndProgressColor(100, paramViewGroup.getColor(2131167654), 100, paramViewGroup.getColor(2131165409));
    this.f.setStrokeWidth(6.0F);
    this.f.setProgress(0.0F);
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress = ((LightWeightProgress)this.rootView.findViewById(2131373699));
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setStrokeWidth(3.0F);
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setVisibility(0);
    this.IK = ((ImageView)this.rootView.findViewById(2131363227));
    this.IK.setVisibility(0);
    this.IK.setOnClickListener(this);
    this.tipsView = ((TextView)paramLayoutInflater.findViewById(2131367345));
    this.mApp = ((QQAppInterface)getActivity().getAppInterface());
    if (!VideoEnvironment.p(this.mApp)) {
      QQToast.a(VideoEnvironment.getContext(), acfp.m(2131707686), 1);
    }
    for (;;)
    {
      paramLayoutInflater = this.rootView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      boolean bool = VideoEnvironment.r(this.mApp);
      if (ankq.aB(getActivity()) != 2) {}
      for (int i = 1;; i = 0)
      {
        if ((bool) && (i != 0)) {
          break label384;
        }
        anfv.UL(2);
        cxJ();
        break;
      }
      label384:
      this.aEt = 100;
      this.byH = true;
      this.cjq = 100;
      this.byI = true;
      VideoEnvironment.k("LightVideoSoDownloadFragment", "checkAVCodecLoadIsOK loaded=true", null);
      ThreadManager.getUIHandler().postDelayed(new LightVideoSoDownloadFragment.1(this), 5L);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    GLGestureProxy.getInstance().removeAllListener();
    if (this.mApp != null)
    {
      ShortVideoResourceManager.a(this.mApp, this);
      ShortVideoResourceManager.b(this.mApp, this);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getActivity().getIntent().putExtras(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.onPause();
    VideoEnvironment.k("LightVideoSoDownloadFragment", "onPause", null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.onResume();
    VideoEnvironment.k("LightVideoSoDownloadFragment", "onResume", null);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightVideoSoDownloadFragment
 * JD-Core Version:    0.7.0.1
 */