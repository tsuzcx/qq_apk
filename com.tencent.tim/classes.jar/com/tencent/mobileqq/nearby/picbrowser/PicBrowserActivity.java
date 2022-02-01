package com.tencent.mobileqq.nearby.picbrowser;

import akbn;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.image.AbstractVideoImage;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import sxz;

public class PicBrowserActivity
  extends BaseActivity
{
  public sxz b = new akbn(this);
  public boolean crm;
  protected ImmersiveTitleBar2 i;
  public int mIndex;
  public ArrayList<PicInfo> mPicInfos;
  
  public void dAw()
  {
    this.i.setVisibility(8);
  }
  
  public void doOnBackPressed()
  {
    if (!this.b.onBackEvent()) {
      super.doOnBackPressed();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = true;
    super.doOnCreate(paramBundle);
    setContentView(2131561478);
    initViews();
    initData();
    this.b.onCreate(this);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.b.onDestroy(this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.b.onKeyDown(paramInt, paramKeyEvent)) {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void doOnPause()
  {
    AbstractVideoImage.pauseAll();
    this.b.onPause();
  }
  
  public void doOnResume()
  {
    AbstractVideoImage.resumeAll();
    this.b.onResume();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.b.bh(this);
    }
  }
  
  protected void initData()
  {
    this.mIndex = getIntent().getIntExtra("intent_param_index", 0);
    this.mPicInfos = getIntent().getParcelableArrayListExtra("intent_param_pic_infos");
    this.crm = getIntent().getBooleanExtra("report_visited_pic", false);
  }
  
  protected void initViews()
  {
    this.i = ((ImmersiveTitleBar2)findViewById(2131379866));
    this.i.setVisibility(0);
    ImmersiveUtils.a(getWindow(), ThemeUtil.isNowThemeIsDefault(this.app, false, null));
    this.i.setBackgroundColor(getResources().getColor(2131165381));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity
 * JD-Core Version:    0.7.0.1
 */