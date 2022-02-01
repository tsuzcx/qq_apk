package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqfo;
import awit;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.d;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import kxm;
import mqq.os.MqqHandler;
import msg;
import odd;

public class ReadInJoySelfActivity
  extends IphoneTitleBarActivity
  implements KandianMergeManager.d
{
  protected ReadInJoySelfFragment a;
  private boolean afw = true;
  private boolean afx;
  private boolean afy;
  protected KandianMergeManager b;
  protected QQAppInterface mApp;
  
  private void initTitle()
  {
    if (this.afx)
    {
      hideTitleBar();
      setImmersiveStatus();
      this.titleRoot = ((RelativeLayout)findViewById(2131379881));
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        super.getWindow().addFlags(67108864);
        ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
        this.titleRoot.setFitsSystemWindows(false);
        this.titleRoot.setPadding(0, 0, 0, 0);
        if (this.mSystemBarComp == null) {
          this.mSystemBarComp = new SystemBarCompact(this, true, -1);
        }
        this.mSystemBarComp.init();
        this.mSystemBarComp.setStatusBarColor(0);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
      return;
    }
    aDb();
  }
  
  private void initUI()
  {
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (this.app == null) {
      return;
    }
    msg.a().nR(this.mApp.getCurrentAccountUin());
    Object localObject1;
    Object localObject2;
    if (this.b != null)
    {
      localObject1 = msg.a();
      localObject2 = this.mApp.getCurrentAccountUin();
      if (!this.b.BD()) {
        break label198;
      }
    }
    label198:
    for (int i = 0;; i = 1)
    {
      ((msg)localObject1).aN((String)localObject2, i);
      this.afx = awit.P(this.mApp);
      setContentView(2131558505);
      initTitle();
      localObject1 = getIntent();
      if (localObject1 != null) {
        this.afy = ((Intent)localObject1).getBooleanExtra("redTouch", false);
      }
      localObject1 = getSupportFragmentManager().beginTransaction();
      this.a = new ReadInJoySelfFragment();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("from_type", 1);
      ((Bundle)localObject2).putBoolean("show_type", this.afx);
      ((Bundle)localObject2).putBoolean("redTouch", this.afy);
      this.a.setArguments((Bundle)localObject2);
      ((FragmentTransaction)localObject1).add(2131367554, this.a);
      ((FragmentTransaction)localObject1).show(this.a);
      ((FragmentTransaction)localObject1).commit();
      return;
    }
  }
  
  public void aDb()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label156;
      }
      if ((aqfo.isMIUI()) || (aqfo.isFlyme())) {
        break label136;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130850369);
      if (this.centerView != null) {
        this.centerView.setTextColor(-16777216);
      }
      this.vg.setBackgroundColor(-1);
      return;
      label136:
      this.mSystemBarComp.setStatusBarColor(-7829368);
      this.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label156:
      if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!aqfo.isFlyme())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  public void aDh()
  {
    ThreadManager.getUIHandler().post(new ReadInJoySelfActivity.1(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mApp = ((QQAppInterface)kxm.getAppRuntime());
    this.b = ((KandianMergeManager)this.mApp.getManager(162));
    this.b.a(this);
    initUI();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.b != null) {
      this.b.b(this);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (!this.afw) {
      odd.bU("self_tab_cost", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity
 * JD-Core Version:    0.7.0.1
 */