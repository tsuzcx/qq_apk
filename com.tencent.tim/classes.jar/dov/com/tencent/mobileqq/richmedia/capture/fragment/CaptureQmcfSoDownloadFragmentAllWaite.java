package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import acfp;
import android.content.Intent;
import android.content.res.Resources;
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
import aqiw;
import aywy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class CaptureQmcfSoDownloadFragmentAllWaite
  extends ReportV4Fragment
  implements View.OnClickListener, angp.a, anhs.a, ShortVideoResourceManager.c
{
  private int aEt;
  private CameraCaptureView b;
  private volatile int bHF;
  private String buw;
  private boolean byH;
  private boolean byI;
  private int cjq;
  private int cjr;
  private boolean dBx;
  private int eMU;
  private CircleProgress f;
  private QQAppInterface mApp;
  private TextView tipsView;
  
  private void AL(String paramString)
  {
    cxK();
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.2(this, paramString));
  }
  
  private void AM(String paramString)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.3(this, paramString));
  }
  
  private boolean WX()
  {
    return false;
  }
  
  private boolean aRk()
  {
    return true;
  }
  
  private void cxJ()
  {
    boolean bool = aqiw.isNetworkAvailable(null);
    VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", acfp.m(2131703454), null);
      ShortVideoResourceManager.b(this.mApp, this);
      return;
    }
    AM(acfp.m(2131703453));
  }
  
  private void cxK()
  {
    if (WX())
    {
      int i = (this.cjr + this.bHF) / 2;
      AM(acfp.m(2131703447) + i + "%");
      return;
    }
    AM(acfp.m(2131703431) + this.cjr + "%");
  }
  
  private void cxL()
  {
    if (WX()) {
      if ((this.byH) && (this.byI) && (this.dBx) && (this.bHF > 100)) {
        ePv();
      }
    }
    while ((!this.byH) || (!this.byI) || (!this.dBx)) {
      return;
    }
    ePv();
  }
  
  public void aFW()
  {
    AM(acfp.m(2131703448));
    VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", acfp.m(2131703426), null);
    anfv.jw(3, -1500);
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.5(this, paramBoolean1, paramInt));
  }
  
  public void cu(int paramInt1, int paramInt2)
  {
    VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", acfp.m(2131703443) + paramInt2 + "]", null);
        ShortVideoResourceManager.Qu(acfp.m(2131703429));
        anfv.jw(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.mApp, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", acfp.m(2131703435), null);
        ShortVideoResourceManager.a(this.mApp, localArrayList, this);
        paramInt1 = ankq.aB(VideoEnvironment.getContext());
        VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", "PtvFilterSoLoad.getFilterSoState resultCode=" + paramInt1, null);
        if (paramInt1 == 2) {
          ShortVideoResourceManager.b(this.mApp, localArrayList, this);
        }
        for (;;)
        {
          paramInt1 = ankq.JS();
          if ((aRk()) && (paramInt1 != 0)) {
            break;
          }
          this.eMU = 100;
          this.dBx = true;
          VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", "onConfigResult| supportQmcfDownloadSo=false", null);
          return;
          if (paramInt1 == 1) {
            ShortVideoResourceManager.b(this.mApp, localArrayList, null);
          }
          this.cjq = 100;
          this.byI = true;
          VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", "onConfigResult| supportSVFilterDownloadSo=false", null);
        }
        ShortVideoResourceManager.c(this.mApp, localArrayList, this);
        return;
      }
      VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", acfp.m(2131703420) + paramInt1 + "]", null);
      ShortVideoResourceManager.Qu(acfp.m(2131703445));
      anfv.jw(1, paramInt1);
      return;
    }
    VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", acfp.m(2131703428) + paramInt2 + "]", null);
    ShortVideoResourceManager.Qu(acfp.m(2131703441));
    anfv.jw(1, paramInt2);
  }
  
  public void cxN()
  {
    this.bHF = 0;
    anhs.a().a(true, this);
    boolean bool = anhs.a().ug();
    if (QLog.isColorLevel()) {
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "preDownloadGestureRes:" + bool);
    }
    if (!bool)
    {
      ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.4(this));
      return;
    }
    this.bHF = 101;
  }
  
  protected void ePv()
  {
    CaptureQmcfSoDownloadFragment.a locala = (CaptureQmcfSoDownloadFragment.a)getActivity();
    if (locala != null) {
      locala.onFinish();
    }
  }
  
  public void f(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_"))
    {
      this.aEt = i;
      if (!aRk()) {
        break label160;
      }
    }
    label160:
    for (this.cjr = ((this.aEt + this.cjq + this.eMU) / 3);; this.cjr = ((this.aEt + this.cjq) / 2))
    {
      AL("doUserDownloadResourceAVCodec:");
      VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
      if (paramString.startsWith("new_qq_android_native_short_filter_"))
      {
        this.cjq = i;
        break;
      }
      if (!paramString.startsWith("new_qq_android_native_art_filter_")) {
        break;
      }
      this.eMU = i;
      break;
    }
  }
  
  protected int getLayoutId()
  {
    return 2131561256;
  }
  
  public void o(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      if (paramInt != 0)
      {
        VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", acfp.m(2131703418) + paramInt + "]", null);
        ShortVideoResourceManager.Qu(acfp.m(2131703430));
        anfv.jw(2, paramInt);
      }
    }
    for (;;)
    {
      VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      this.aEt = 100;
      this.byH = true;
      cxL();
      continue;
      if (paramString1.startsWith("new_qq_android_native_short_filter_"))
      {
        if (paramInt != 0)
        {
          VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", acfp.m(2131703427) + paramInt + "]", null);
          ShortVideoResourceManager.Qu(acfp.m(2131703419));
          anfv.jw(2, paramInt);
        }
        else
        {
          this.cjq = 100;
          this.byI = true;
          cxL();
        }
      }
      else if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        if (paramInt != 0)
        {
          VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", acfp.m(2131703451) + paramInt + "]", null);
          ShortVideoResourceManager.Qu(acfp.m(2131703439));
          anfv.jw(2, paramInt);
        }
        else
        {
          this.eMU = 100;
          this.dBx = true;
          cxL();
        }
      }
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
    int j = 0;
    paramLayoutInflater = paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
    this.b = ((CameraCaptureView)paramLayoutInflater.findViewById(2131364201));
    this.b.setDarkModeEnable(false);
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
      QQToast.a(VideoEnvironment.getContext(), acfp.m(2131703449), 1);
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      if (WX())
      {
        cxN();
        label247:
        bool = VideoEnvironment.r(this.mApp);
        if (ankq.aB(getActivity()) == 2) {
          break label322;
        }
      }
      label322:
      for (int i = 1;; i = 0)
      {
        if ((!aRk()) || (ankq.JS() != 2)) {
          j = 1;
        }
        if ((bool) && (i != 0) && (j != 0)) {
          break label328;
        }
        anfv.UL(2);
        cxJ();
        break;
        this.bHF = 101;
        break label247;
      }
      label328:
      VideoEnvironment.k("CaptureSoDownloadFragmentAllWaite", "checkAVCodecLoadIsOK loaded=true, activityId=" + this.buw, null);
      ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadFragmentAllWaite.1(this), 5L);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mApp != null)
    {
      ShortVideoResourceManager.a(this.mApp, this);
      ShortVideoResourceManager.b(this.mApp, this);
      ShortVideoResourceManager.c(this.mApp, this);
    }
    anhs.a().a(false, this);
  }
  
  public void onDownloadProgress(int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.6(this, paramInt));
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite
 * JD-Core Version:    0.7.0.1
 */