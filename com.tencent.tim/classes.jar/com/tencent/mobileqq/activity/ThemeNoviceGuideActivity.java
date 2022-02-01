package com.tencent.mobileqq.activity;

import acfp;
import altq;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import anot;
import aqft;
import aqfy;
import aqqj;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import vxp;

public class ThemeNoviceGuideActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  Handler mHandler = new vxp(this, Looper.getMainLooper());
  
  private void initUI()
  {
    setLeftButton(2131721059, null);
    ((Button)findViewById(2131379065)).setOnClickListener(this);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    super.setContentView(2131563184);
    initUI();
    setTitle(acfp.m(2131715317));
    this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 0, null), 5L);
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((WebProcessManager)this.app.getManager(13)).egu();
  }
  
  public boolean onBackEvent()
  {
    finish();
    aqfy.anim(this, false, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131379065)
    {
      if (!aqft.cC()) {
        break label128;
      }
      finish();
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("FromWhere", "FromThemeNoviceGuide");
      VasWebviewUtil.openQQBrowserWithoutAD(this, aqqj.o(this, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, localIntent, false, -1);
      if (this.app != null) {
        ((altq)this.app.getManager(36)).OS("100005.100002");
      }
    }
    for (;;)
    {
      if (this.app != null) {
        anot.a(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "theme_popup_click", 0, 0, "", "", "", "");
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label128:
      Toast.makeText(getApplicationContext(), getString(2131719242), 0).show();
    }
  }
  
  public String setLastActivityName()
  {
    return getString(2131691039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ThemeNoviceGuideActivity
 * JD-Core Version:    0.7.0.1
 */