package com.tencent.biz.qrcode.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import rvh;

public abstract class QRLoginBaseActivity
  extends IphoneTitleBarActivity
{
  protected ImageView nM;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    initUI();
    hideTitleBar();
    this.nM = ((ImageView)super.findViewById(2131370344));
    this.nM.setContentDescription(getText(2131691039));
    this.nM.setOnClickListener(new rvh(this));
    return true;
  }
  
  public void doOnResume()
  {
    int j = 0;
    super.doOnResume();
    int i = j;
    if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      i = j;
      if (!ThemeUtil.isGoldenTheme()) {
        i = 1;
      }
    }
    if (i != 0) {
      ImmersiveUtils.setStatusTextColor(true, getWindow());
    }
  }
  
  protected abstract void initUI();
  
  public void setImmersiveStatus()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (this.mActNeedImmersive)
      {
        int i = getResources().getColor(2131167361);
        if (this.mSystemBarComp == null)
        {
          this.mSystemBarComp = new SystemBarCompact(this, true, i);
          if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
            break label103;
          }
          this.mSystemBarComp.setStatusDrawable(getResources().getDrawable(2130838900));
        }
      }
    }
    for (;;)
    {
      if (!isInMultiWindow()) {
        ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      }
      return;
      label103:
      this.mSystemBarComp.setStatusDrawable(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginBaseActivity
 * JD-Core Version:    0.7.0.1
 */