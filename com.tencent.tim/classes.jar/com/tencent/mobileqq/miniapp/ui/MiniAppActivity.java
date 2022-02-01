package com.tencent.mobileqq.miniapp.ui;

import ajcm;
import ajcn;
import ajcr;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import pmi;

public class MiniAppActivity
  extends FragmentActivity
{
  private MiniAppBaseFragment a;
  protected int bDo;
  public ajcn d;
  protected String mAppId;
  
  public void a(MiniAppBaseFragment paramMiniAppBaseFragment)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.replace(2131367554, paramMiniAppBaseFragment);
    localFragmentTransaction.commit();
    this.a = paramMiniAppBaseFragment;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131558500);
    paramBundle = getIntent().getExtras();
    Object localObject = new MiniAppLoadingFragment();
    ((MiniAppLoadingFragment)localObject).setArguments(paramBundle);
    a((MiniAppBaseFragment)localObject);
    ajcr.a();
    this.mAppId = getIntent().getStringExtra("key_appid");
    this.bDo = getIntent().getIntExtra("key_appType", 0);
    paramBundle = (MiniAppOptions)getIntent().getParcelableExtra("key_options");
    localObject = new ajcm();
    ((ajcm)localObject).type = 2;
    ((ajcm)localObject).isSuccess = true;
    ((ajcm)localObject).s = new Object[] { this, this.mAppId, Integer.valueOf(this.bDo), paramBundle };
    pmi.a().dispatch("MiniAppManager", (Dispatcher.Dispatchable)localObject);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ajcm localajcm = new ajcm();
    localajcm.type = 3;
    localajcm.isSuccess = true;
    localajcm.s = new Object[] { this.mAppId, Integer.valueOf(this.bDo) };
    pmi.a().dispatch("MiniAppManager", localajcm);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    moveTaskToBack(true);
    overridePendingTransition(2130772368, 2130772002);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.ui.MiniAppActivity
 * JD-Core Version:    0.7.0.1
 */