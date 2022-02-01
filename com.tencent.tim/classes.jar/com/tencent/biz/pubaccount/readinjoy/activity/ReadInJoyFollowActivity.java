package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import awit;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import kfs;
import kib;
import mzj;

public class ReadInJoyFollowActivity
  extends IphoneTitleBarActivity
{
  public kfs a;
  
  private void init()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131376777);
    this.a = new kfs(this);
    this.a.oD(70);
    this.a.setChannelType(0);
    this.a.i(localViewGroup);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.a != null) {
      this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    mzj.a().aO(this);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2131560381);
    getWindow().setBackgroundDrawable(null);
    setClickableTitle("BB圈", new kib(this));
    init();
    this.a.onCreate();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.a.onDestroy();
    mzj.a().aP(this);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.a.onPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.a.onResume();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    awit.b(getAppRuntime());
    this.a.onStart();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.a.onStop();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.aBZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFollowActivity
 * JD-Core Version:    0.7.0.1
 */