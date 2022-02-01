package com.tencent.qg.qq;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import asgm;
import com.tencent.mobileqq.miniapp.ui.MiniAppBaseFragment;
import com.tencent.qg.sdk.QGGLSurfaceView;
import com.tencent.qg.sdk.doraemon.DoraemonApiWrapper;
import com.tencent.qg.sdk.doraemon.impl.DoraemonApiWrapperMockImpl;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import tzk;

public class GameDemoFragment
  extends MiniAppBaseFragment
{
  private QGGLSurfaceView a;
  public DoraemonApiWrapper a;
  private String[] iy;
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.iy = getArguments().getStringArray("key_run_js");
    getActivity().getWindowManager().getDefaultDisplay().getWidth();
    getActivity().getWindowManager().getDefaultDisplay().getHeight();
    tzk.a(getActivity(), 3, getAppId());
    this.jdField_a_of_type_ComTencentQgSdkQGGLSurfaceView = new QGGLSurfaceView(getActivity());
    this.jdField_a_of_type_ComTencentQgSdkDoraemonDoraemonApiWrapper = new DoraemonApiWrapperMockImpl(this.jdField_a_of_type_ComTencentQgSdkQGGLSurfaceView);
    this.jdField_a_of_type_ComTencentQgSdkQGGLSurfaceView.setQGEventListener(new asgm(this));
    paramLayoutInflater = this.jdField_a_of_type_ComTencentQgSdkQGGLSurfaceView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_ComTencentQgSdkDoraemonDoraemonApiWrapper != null)
    {
      this.jdField_a_of_type_ComTencentQgSdkDoraemonDoraemonApiWrapper.release();
      this.jdField_a_of_type_ComTencentQgSdkDoraemonDoraemonApiWrapper = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qg.qq.GameDemoFragment
 * JD-Core Version:    0.7.0.1
 */