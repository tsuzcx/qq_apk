package com.tencent.mobileqq.bigbrother;

import adws;
import adwt;
import adwu;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import aqha;
import aqju;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class JumpConfirmFragment
  extends PublicBaseFragment
{
  private String bvP;
  private int callbackId;
  private int id;
  private String src;
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject = getArguments();
    this.src = ((Bundle)localObject).getString("big_brother_source_key");
    this.id = ((Bundle)localObject).getInt("key_id");
    this.bvP = ((Bundle)localObject).getString("key_process_id");
    this.callbackId = ((Bundle)localObject).getInt("key_callback_id", 0);
    try
    {
      localObject = aqha.b(getActivity(), 0, null, "即将离开QQ\n打开其他应用", getString(2131721058), getString(2131721897), new adws(this), new adwt(this));
      ((aqju)localObject).setOnDismissListener(new adwu(this));
      getActivity().setJumpDialog((Dialog)localObject);
      ((aqju)localObject).show();
      paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("JumpConfirmFragment", 1, localThrowable, new Object[0]);
        JefsClass.getInstance().E(this.id, this.bvP, this.callbackId);
        getActivity().finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.JumpConfirmFragment
 * JD-Core Version:    0.7.0.1
 */