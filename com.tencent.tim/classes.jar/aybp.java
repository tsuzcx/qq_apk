import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.ptv.LightWeightProgress;
import dov.com.qq.im.ptv.LightWeightSoDownloadUnit.1;
import dov.com.qq.im.ptv.LightWeightSoDownloadUnit.2;
import dov.com.qq.im.ptv.LightWeightSoDownloadUnit.3;
import dov.com.qq.im.ptv.LightWeightSoDownloadUnit.4;
import dov.com.qq.im.ptv.PtvCameraCaptureActivity;
import java.util.ArrayList;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

public class aybp
  implements View.OnClickListener, angp.a, aycc, CameraCaptureView.c, ShortVideoResourceManager.c
{
  private ImageView IK;
  private ayca jdField_a_of_type_Ayca;
  private aycb jdField_a_of_type_Aycb;
  protected CameraCaptureSegmentView a;
  protected LightWeightProgress a;
  protected long aBw;
  private int aEt;
  private boolean byH;
  private boolean byI;
  private int cjq;
  private int cjr;
  public CircleProgress f;
  private QQAppInterface mApp;
  protected RelativeLayout oe;
  protected View rootView;
  private TextView tipsView;
  
  public aybp(aycb paramaycb, ayca paramayca)
  {
    this.jdField_a_of_type_Aycb = paramaycb;
    this.jdField_a_of_type_Ayca = paramayca;
  }
  
  private void AL(String paramString)
  {
    ThreadManager.getUIHandler().post(new LightWeightSoDownloadUnit.3(this, paramString));
  }
  
  private void AM(String paramString)
  {
    ThreadManager.getUIHandler().post(new LightWeightSoDownloadUnit.2(this, paramString));
  }
  
  private void cxJ()
  {
    boolean bool = aqiw.isNetworkAvailable(null);
    VideoEnvironment.k("LightWeightSoDownloadUnit", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.k("LightWeightSoDownloadUnit", acfp.m(2131707711), null);
      ShortVideoResourceManager.b(this.mApp, this);
      return;
    }
    AM(acfp.m(2131707727));
  }
  
  protected CameraCaptureView.e a()
  {
    return aywy.a().c(this.jdField_a_of_type_Aycb.getActivity());
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public void aFW()
  {
    AM(acfp.m(2131707717));
    VideoEnvironment.k("LightWeightSoDownloadUnit", acfp.m(2131707723), null);
    anfv.jw(3, -1500);
  }
  
  public void cu(int paramInt1, int paramInt2)
  {
    VideoEnvironment.k("LightWeightSoDownloadUnit", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.k("LightWeightSoDownloadUnit", acfp.m(2131707718) + paramInt2 + "]", null);
        ShortVideoResourceManager.Qu(acfp.m(2131707710));
        anfv.jw(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.mApp, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.k("LightWeightSoDownloadUnit", acfp.m(2131707706), null);
        ShortVideoResourceManager.a(this.mApp, localArrayList, this);
        paramInt1 = ankq.aB(VideoEnvironment.getContext());
        VideoEnvironment.k("LightWeightSoDownloadUnit", "PtvFilterSoLoad.getFilterSoState resultCode=" + paramInt1, null);
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
        VideoEnvironment.k("LightWeightSoDownloadUnit", "onConfigResult| supportSVFilterDownloadSo=false", null);
        return;
      }
      VideoEnvironment.k("LightWeightSoDownloadUnit", acfp.m(2131707713) + paramInt1 + "]", null);
      ShortVideoResourceManager.Qu(acfp.m(2131707707));
      anfv.jw(1, paramInt1);
      return;
    }
    VideoEnvironment.k("LightWeightSoDownloadUnit", acfp.m(2131707722) + paramInt2 + "]", null);
    ShortVideoResourceManager.Qu(acfp.m(2131707733));
    anfv.jw(1, paramInt2);
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
        break label93;
      }
    }
    label93:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label98;
      }
      localPtvCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
      i = 0;
      break;
    }
    label98:
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
        break label77;
      }
      label41:
      if ((i == 0) || (j == 0)) {
        break label82;
      }
      localObject = acfp.m(2131707724);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new LightWeightSoDownloadUnit.4(this, (String)localObject));
      return;
      i = 0;
      break;
      label77:
      j = 0;
      break label41;
      label82:
      if (i != 0) {
        localObject = acfp.m(2131707737);
      } else {
        localObject = acfp.m(2131707712);
      }
    }
  }
  
  public void ePv()
  {
    if ((this.byH) && (this.byI))
    {
      aybp.a locala = (aybp.a)this.jdField_a_of_type_Aycb.getActivity();
      if (locala != null) {
        locala.ePw();
      }
    }
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
      AM(acfp.m(2131707726) + this.cjr + "%");
      VideoEnvironment.k("LightWeightSoDownloadUnit", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
      if (paramString.startsWith("new_qq_android_native_short_filter_")) {
        this.cjq = i;
      }
    }
  }
  
  public void finish() {}
  
  protected int getLayoutId()
  {
    return 2131561100;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setCameraPermissionResult(true);
  }
  
  public void lp(int paramInt1, int paramInt2) {}
  
  public void o(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      if (paramInt != 0)
      {
        VideoEnvironment.k("LightWeightSoDownloadUnit", acfp.m(2131707715) + paramInt + "]", null);
        ShortVideoResourceManager.Qu(acfp.m(2131707721));
        anfv.jw(2, paramInt);
      }
    }
    for (;;)
    {
      VideoEnvironment.k("LightWeightSoDownloadUnit", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      this.aEt = 100;
      this.byH = true;
      ePv();
      continue;
      if (paramString1.startsWith("new_qq_android_native_short_filter_")) {
        if (paramInt != 0)
        {
          VideoEnvironment.k("LightWeightSoDownloadUnit", acfp.m(2131707740) + paramInt + "]", null);
          ShortVideoResourceManager.Qu(acfp.m(2131707729));
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
  
  public void onActivityPause()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.onPause();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onActivityResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightSoDownloadUnit", 2, "onActivityResume");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.onResume();
  }
  
  public void onActivityStart() {}
  
  public void onActivityStop() {}
  
  public boolean onBackPressed()
  {
    this.jdField_a_of_type_Aycb.eET();
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
      onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.aBw = this.jdField_a_of_type_Aycb.getActivity().getIntent().getLongExtra("ACTIVITY_START_TIME", -1L);
  }
  
  public View onCreateView()
  {
    Object localObject = new RelativeLayout(this.jdField_a_of_type_Aycb.getActivity());
    ((RelativeLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localObject = this.jdField_a_of_type_Aycb.getActivity().getLayoutInflater().inflate(getLayoutId(), (ViewGroup)localObject, false);
    this.rootView = ((View)localObject).findViewById(2131367347);
    this.oe = ((RelativeLayout)this.rootView.findViewById(2131364270));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView = ((CameraCaptureSegmentView)this.rootView.findViewById(2131364201));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.Ot(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setCaptureParam(a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setCameraPermissionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setUseVideoOrientation(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setDynamicResolutionMode(false);
    this.f = ((CircleProgress)((View)localObject).findViewById(2131365505));
    Resources localResources = this.jdField_a_of_type_Aycb.getActivity().getResources();
    this.f.setBgAndProgressColor(100, localResources.getColor(2131167654), 100, localResources.getColor(2131165409));
    this.f.setStrokeWidth(6.0F);
    this.f.setProgress(0.0F);
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress = ((LightWeightProgress)this.rootView.findViewById(2131373699));
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setStrokeWidth(3.0F);
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setVisibility(0);
    this.IK = ((ImageView)this.rootView.findViewById(2131363227));
    this.IK.setVisibility(0);
    this.IK.setOnClickListener(this);
    this.tipsView = ((TextView)((View)localObject).findViewById(2131367345));
    this.mApp = ((QQAppInterface)this.jdField_a_of_type_Aycb.getAppInterface());
    if (!VideoEnvironment.p(this.mApp)) {
      QQToast.a(VideoEnvironment.getContext(), acfp.m(2131707725), 1);
    }
    for (;;)
    {
      return this.rootView;
      boolean bool = VideoEnvironment.r(this.mApp);
      if (ankq.aB(this.jdField_a_of_type_Aycb.getActivity()) != 2) {}
      for (int i = 1;; i = 0)
      {
        if ((bool) && (i != 0)) {
          break label406;
        }
        anfv.UL(2);
        cxJ();
        break;
      }
      label406:
      this.aEt = 100;
      this.byH = true;
      this.cjq = 100;
      this.byI = true;
      VideoEnvironment.k("LightWeightSoDownloadUnit", "checkAVCodecLoadIsOK loaded=true", null);
      ThreadManager.getUIHandler().postDelayed(new LightWeightSoDownloadUnit.1(this), 5L);
    }
  }
  
  public void onDestroy()
  {
    GLGestureProxy.getInstance().removeAllListener();
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void ePw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aybp
 * JD-Core Version:    0.7.0.1
 */