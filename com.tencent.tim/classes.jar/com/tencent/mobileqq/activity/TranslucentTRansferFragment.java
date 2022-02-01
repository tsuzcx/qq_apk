package com.tencent.mobileqq.activity;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import aqha;
import aqju;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import vxq;
import vxr;
import vxs;

public class TranslucentTRansferFragment
  extends PublicBaseFragment
{
  private void bWm()
  {
    switch (getActivity().getIntent().getIntExtra("action", -1))
    {
    default: 
      return;
    }
    bWn();
  }
  
  private void bWn()
  {
    if (getActivity() == null) {}
    aqju localaqju;
    do
    {
      return;
      localaqju = aqha.b(getActivity(), 0, null, "你是否要去注册QQ？", null, null, null, null);
      localaqju.setPositiveButton(acfp.m(2131715437), new vxq(this, localaqju));
      localaqju.setNegativeButton(acfp.m(2131715435), new vxr(this, localaqju));
      localaqju.setOnDismissListener(new vxs(this));
    } while (getActivity().isFinishing());
    localaqju.show();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getActivity() == null) {
      return;
    }
    bWm();
  }
  
  public void onFinish()
  {
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    localFragmentActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TranslucentTRansferFragment
 * JD-Core Version:    0.7.0.1
 */