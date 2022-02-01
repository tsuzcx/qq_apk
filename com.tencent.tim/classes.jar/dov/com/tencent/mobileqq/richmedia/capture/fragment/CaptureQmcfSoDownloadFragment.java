package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import anfv;
import angp.a;
import anhs;
import anhs.a;
import ankq;
import aqha;
import aqiw;
import axcd;
import axce;
import axce.a;
import axiy;
import aywy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.c;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import java.util.ArrayList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.os.MqqHandler;
import shb;

public class CaptureQmcfSoDownloadFragment
  extends ReportV4Fragment
  implements View.OnClickListener, angp.a, anhs.a, axce.a, CameraCaptureView.c, ShortVideoResourceManager.c
{
  private int aEt;
  private CameraCaptureView b;
  private volatile int bHF;
  private String buw;
  private boolean byH;
  private int cjr;
  private boolean dBt;
  private volatile boolean dBu;
  private volatile boolean dBv;
  private volatile boolean dBw;
  private int eMT;
  private CircleProgress f;
  private QQAppInterface mApp;
  private TextView tipsView;
  
  private void AL(String paramString)
  {
    cxK();
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.2(this, paramString));
  }
  
  private void AM(String paramString)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.3(this, paramString));
  }
  
  private boolean WX()
  {
    return false;
  }
  
  private void a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    paramSVConfigItem.name = "new_qq_android_native_short_video_66";
    paramSVConfigItem.arm_url = "https://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_66_test.zip";
    paramSVConfigItem.armv7a_url = "https://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_66_test.zip";
    paramSVConfigItem.x86_url = "https://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_66_test.zip";
    paramSVConfigItem.arm64v8a_url = "https://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_for64bit_66_test_1.zip";
    paramSVConfigItem.arm_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    paramSVConfigItem.armv7a_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    paramSVConfigItem.x86_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    paramSVConfigItem.arm64v8a_md5 = "480b96a75193cee3979c62fea8018768";
    paramSVConfigItem.versionCode = 66;
    paramSVConfigItem.predownload = false;
  }
  
  private void cxJ()
  {
    boolean bool = aqiw.isNetworkAvailable(null);
    VideoEnvironment.k("CaptureQmcfSoDownloadFragment", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.k("CaptureQmcfSoDownloadFragment", acfp.m(2131703432), null);
      ShortVideoResourceManager.b(this.mApp, this);
      return;
    }
    AM(acfp.m(2131703444));
  }
  
  private void cxK()
  {
    if (WX())
    {
      int i = (this.cjr + this.bHF) / 2;
      AM(acfp.m(2131703446) + i + "%");
      return;
    }
    AM(acfp.m(2131703455) + this.cjr + "%");
  }
  
  private void cxL()
  {
    if (WX()) {
      if ((this.byH) && (this.bHF > 100) && (this.dBt)) {
        ePv();
      }
    }
    do
    {
      return;
      axiy.i("CaptureQmcfSoDownloadFragment", "【isAvCodecDownloaded】" + this.byH);
    } while ((!this.byH) || (!this.dBt));
    ePv();
  }
  
  private void eTV()
  {
    boolean bool = aqiw.isNetworkAvailable(null);
    VideoEnvironment.k("CaptureQmcfSoDownloadFragment", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      axce.a().a(axcd.c, this, false);
      return;
    }
    axiy.e("CaptureQmcfSoDownloadFragment", "【END】startDownloadAEKitBase:" + acfp.m(2131703425));
    AM(acfp.m(2131703425));
  }
  
  public void a(axcd paramaxcd, long paramLong1, long paramLong2)
  {
    if (paramaxcd == axcd.c)
    {
      int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      this.eMT = i;
      this.cjr = ((this.aEt + this.eMT) / 2);
      AL("doUserDownloadResource:");
      VideoEnvironment.k("CaptureQmcfSoDownloadFragment", "packageIdx=" + paramaxcd.index + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
    }
  }
  
  public void a(axcd paramaxcd, String paramString, boolean paramBoolean, int paramInt)
  {
    axiy.i("CaptureQmcfSoDownloadFragment", "【onAEResDownloadResult】[packageIdx] :" + paramaxcd.index + "[isDownloaded] :" + paramBoolean + "[errorType] :" + paramInt);
    if (paramaxcd == axcd.c)
    {
      if (paramBoolean)
      {
        this.eMT = 100;
        this.dBt = true;
        cxL();
      }
    }
    else {
      return;
    }
    VideoEnvironment.k("CaptureQmcfSoDownloadFragment", acfp.m(2131703424) + paramInt + "]", null);
    ShortVideoResourceManager.Qu(acfp.m(2131703440));
    anfv.jw(2, paramInt);
  }
  
  public void aFW()
  {
    AM(acfp.m(2131703434));
    VideoEnvironment.k("CaptureQmcfSoDownloadFragment", acfp.m(2131703422), null);
    anfv.jw(3, -1500);
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.5(this, paramBoolean1, paramInt));
  }
  
  public void cu(int paramInt1, int paramInt2)
  {
    VideoEnvironment.k("CaptureQmcfSoDownloadFragment", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.k("CaptureQmcfSoDownloadFragment", acfp.m(2131703421) + paramInt2 + "]", null);
        ShortVideoResourceManager.Qu(acfp.m(2131703437) + "serverError" + paramInt2);
        anfv.jw(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.mApp, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.k("CaptureQmcfSoDownloadFragment", acfp.m(2131703452), null);
        ShortVideoResourceManager.a(this.mApp, localArrayList, this);
        return;
      }
      if (paramInt1 == -2)
      {
        paramInt1 = 0;
        while (paramInt1 < localArrayList.size())
        {
          a((ShortVideoResourceManager.SVConfigItem)localArrayList.get(paramInt1));
          paramInt1 += 1;
        }
        axiy.e("CaptureQmcfSoDownloadFragment", acfp.m(2131689992));
        ShortVideoResourceManager.a(this.mApp, localArrayList, this);
        return;
      }
      if (paramInt1 == -101)
      {
        ShortVideoResourceManager.SVConfigItem localSVConfigItem = new ShortVideoResourceManager.SVConfigItem();
        a(localSVConfigItem);
        localArrayList.add(localSVConfigItem);
        axiy.e("CaptureQmcfSoDownloadFragment", acfp.m(2131689993));
        ShortVideoResourceManager.a(this.mApp, localArrayList, this);
        return;
      }
      VideoEnvironment.k("CaptureQmcfSoDownloadFragment", acfp.m(2131703436) + paramInt1 + "]", null);
      ShortVideoResourceManager.Qu(acfp.m(2131703423) + "errorCode:" + paramInt1);
      anfv.jw(1, paramInt1);
      return;
    }
    VideoEnvironment.k("CaptureQmcfSoDownloadFragment", acfp.m(2131703450) + paramInt2 + "]", null);
    ShortVideoResourceManager.Qu(acfp.m(2131703442) + "result:" + paramInt1);
    anfv.jw(1, paramInt2);
  }
  
  public void cxN()
  {
    this.bHF = 0;
    anhs.a().a(true, this);
    boolean bool = anhs.a().ug();
    if (QLog.isColorLevel()) {
      QLog.d("CaptureQmcfSoDownloadFragment", 2, "preDownloadGestureRes:" + bool);
    }
    if (!bool)
    {
      ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.4(this));
      return;
    }
    this.bHF = 101;
  }
  
  public void dLc()
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (!(getActivity() instanceof CaptureQmcfSoDownloadActivity)) {
      return;
    }
    CaptureQmcfSoDownloadActivity localCaptureQmcfSoDownloadActivity = (CaptureQmcfSoDownloadActivity)getActivity();
    int i;
    if (localCaptureQmcfSoDownloadActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (localCaptureQmcfSoDownloadActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label92;
      }
    }
    label92:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label97;
      }
      this.dBu = true;
      localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
      i = 0;
      break;
    }
    label97:
    if (i != 0)
    {
      this.dBu = true;
      localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      return;
    }
    this.dBu = true;
    localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    this.dBv = false;
    Object localObject = getActivity();
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
      ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.7(this, (String)localObject));
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
  
  protected void ePv()
  {
    try
    {
      this.dBw = true;
      if ((!this.dBu) || (this.dBv))
      {
        a locala = (a)getActivity();
        if (locala != null) {
          locala.onFinish();
        }
      }
      return;
    }
    finally {}
  }
  
  public void f(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.aEt = i;
    }
    this.cjr = ((this.aEt + this.eMT) / 2);
    AL("doUserDownloadResource:");
    VideoEnvironment.k("CaptureQmcfSoDownloadFragment", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
  }
  
  protected int getLayoutId()
  {
    return 2131561256;
  }
  
  /* Error */
  @mqq.app.QQPermissionGrant(1)
  public void grant()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 394	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:dBv	Z
    //   7: aload_0
    //   8: getfield 408	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:dBw	Z
    //   11: ifeq +24 -> 35
    //   14: aload_0
    //   15: invokevirtual 370	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   18: checkcast 18	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment$a
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull +9 -> 32
    //   26: aload_1
    //   27: invokeinterface 411 1 0
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: getfield 85	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:b	Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView;
    //   39: iconst_1
    //   40: invokevirtual 430	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:setCameraPermissionResult	(Z)V
    //   43: goto -11 -> 32
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	CaptureQmcfSoDownloadFragment
    //   21	6	1	locala	a
    //   46	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	46	finally
    //   26	32	46	finally
    //   35	43	46	finally
  }
  
  public void o(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label110;
      }
      VideoEnvironment.k("CaptureQmcfSoDownloadFragment", acfp.m(2131703456) + paramInt + "]", null);
      ShortVideoResourceManager.Qu(acfp.m(2131703433));
      anfv.jw(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.k("CaptureQmcfSoDownloadFragment", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      label110:
      this.aEt = 100;
      this.byH = true;
      cxL();
    }
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
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
    this.b = ((CameraCaptureView)paramLayoutInflater.findViewById(2131364201));
    this.b.setDarkModeEnable(false);
    this.b.setCameraPermissionListener(this);
    paramViewGroup = aywy.a().a(paramLayoutInflater.getContext());
    paramViewGroup.Ov(false);
    this.b.Ot(false);
    this.b.setCaptureParam(paramViewGroup);
    ((Button)paramLayoutInflater.findViewById(2131364221)).setOnClickListener(this);
    this.f = ((CircleProgress)paramLayoutInflater.findViewById(2131365505));
    this.f.setBgAndProgressColor(100, getResources().getColor(2131167654), 100, getResources().getColor(2131165409));
    this.f.setStrokeWidth(6.0F);
    this.f.setProgress(0.0F);
    this.f.setOnClickListener(this);
    this.tipsView = ((TextView)paramLayoutInflater.findViewById(2131367345));
    this.mApp = ((QQAppInterface)getActivity().getAppInterface());
    boolean bool = VideoEnvironment.p(this.mApp);
    this.buw = getActivity().getIntent().getExtras().getString("ARG_ACTIVITY_ID");
    if (!bool) {
      QQToast.a(VideoEnvironment.getContext(), acfp.m(2131703438), 1);
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      label252:
      int i;
      if (WX())
      {
        cxN();
        bool = VideoEnvironment.r(this.mApp);
        if (ankq.aB(BaseApplicationImpl.getContext()) == 2) {
          break label334;
        }
        i = 1;
        label274:
        if ((bool) && (i != 0)) {
          break label368;
        }
        if (bool) {
          break label340;
        }
        anfv.UL(2);
        axiy.i("CaptureQmcfSoDownloadFragment", "【START】startDownloadConfig");
        cxJ();
      }
      for (;;)
      {
        if (i != 0) {
          break label354;
        }
        axiy.i("CaptureQmcfSoDownloadFragment", "【START】startDownloadAEKitBase");
        eTV();
        break;
        this.bHF = 101;
        break label252;
        label334:
        i = 0;
        break label274;
        label340:
        this.byH = true;
        this.aEt = 100;
      }
      label354:
      this.dBt = true;
      this.eMT = 100;
      continue;
      label368:
      VideoEnvironment.k("CaptureQmcfSoDownloadFragment", "checkAVCodecLoadIsOK loaded=true, activityId=" + this.buw, null);
      ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadFragment.1(this), 5L);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    anhs.a().a(false, this);
    if (QLog.isDevelopLevel()) {
      QLog.d("CaptureQmcfSoDownloadFragment", 4, "in CaptureQmcfSoDownloadFragment onDestroy");
    }
    removeCallbacks();
  }
  
  public void onDownloadProgress(int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.6(this, paramInt));
  }
  
  public void onPause()
  {
    super.onPause();
    this.b.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.b.onResume();
    if (Build.VERSION.SDK_INT >= 29) {
      shb.e(getActivity().getWindow());
    }
  }
  
  public void removeCallbacks()
  {
    if (this.mApp != null)
    {
      ShortVideoResourceManager.a(this.mApp, this);
      this.mApp = null;
    }
    axce.a().b(this);
  }
  
  public static abstract interface a
  {
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment
 * JD-Core Version:    0.7.0.1
 */