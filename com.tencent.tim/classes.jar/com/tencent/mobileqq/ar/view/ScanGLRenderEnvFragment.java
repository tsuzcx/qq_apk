package com.tencent.mobileqq.ar.view;

import adcl;
import adcs;
import adkx;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.ar.ARArguments;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class ScanGLRenderEnvFragment
  extends ScanGLRenderBaseFragment
{
  private VideoRecordController a;
  
  public static ScanGLRenderEnvFragment a(ARArguments paramARArguments)
  {
    ScanGLRenderEnvFragment localScanGLRenderEnvFragment = new ScanGLRenderEnvFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("AR_ARGUMENTS", paramARArguments);
    localScanGLRenderEnvFragment.setArguments(localBundle);
    return localScanGLRenderEnvFragment;
  }
  
  private void cTv()
  {
    boolean bool = adcs.adD();
    QLog.d("AREngine_ScanGLRenderEnvFragment", 2, String.format("initVideoRecord support=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bool)
    {
      if (this.a == null)
      {
        this.a = new VideoRecordController(getActivity());
        adcl.a().bf(this.a);
      }
      adkx localadkx = this.c;
      if (localadkx != null) {
        localadkx.a(this.a);
      }
    }
  }
  
  private void cTw()
  {
    boolean bool = adcs.adD();
    QLog.d("AREngine_ScanGLRenderEnvFragment", 2, String.format("unInitVideoRecord support=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bool)
    {
      adkx localadkx = this.c;
      if (localadkx != null) {
        localadkx.a(null);
      }
      adcl.a().bg(this.a);
      if (this.a != null) {
        this.a = null;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    cTv();
    paramLayoutInflater = this.b;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    QLog.i("AREngine_ScanGLRenderEnvFragment", 1, "onResume");
    cTw();
    super.onDestroy();
  }
  
  public void onPause()
  {
    QLog.i("AREngine_ScanGLRenderEnvFragment", 1, "onPause");
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("AREngine_ScanGLRenderEnvFragment", 1, "onResume");
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanGLRenderEnvFragment
 * JD-Core Version:    0.7.0.1
 */