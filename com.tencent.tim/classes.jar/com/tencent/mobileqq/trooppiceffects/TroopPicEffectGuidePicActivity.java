package com.tencent.mobileqq.trooppiceffects;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import apyt;
import apyu;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class TroopPicEffectGuidePicActivity
  extends BaseActivity
  implements View.OnClickListener
{
  protected ImageView ET;
  protected ImageButton aO;
  protected ImageButton aP;
  protected URLImageView bT;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    setContentView(2131563282);
    this.aO = ((ImageButton)findViewById(2131380377));
    this.aP = ((ImageButton)findViewById(2131380378));
    this.bT = ((URLImageView)findViewById(2131380379));
    this.ET = ((ImageView)findViewById(2131380381));
    this.aO.setOnClickListener(this);
    this.aP.setOnClickListener(this);
    in(this.aO);
    in(this.aP);
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    Object localObject = new ColorDrawable(0);
    paramBundle.mFailedDrawable = ((Drawable)localObject);
    paramBundle.mLoadingDrawable = ((Drawable)localObject);
    paramBundle = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/troop_effect_pic_preview_img.png", paramBundle);
    this.bT.setImageDrawable(paramBundle);
    this.bT.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    localObject = getResources().getDrawable(2130851834);
    paramBundle.mFailedDrawable = ((Drawable)localObject);
    paramBundle.mLoadingDrawable = ((Drawable)localObject);
    paramBundle = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_select_pic_button.png", paramBundle);
    this.aO.setBackgroundDrawable(paramBundle);
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    localObject = new ColorDrawable(0);
    paramBundle.mFailedDrawable = ((Drawable)localObject);
    paramBundle.mLoadingDrawable = ((Drawable)localObject);
    paramBundle = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_select_pic_wording.png", paramBundle);
    this.ET.setBackgroundDrawable(paramBundle);
    apyu.ih("app_entry_guide", "page_exp");
    return true;
  }
  
  protected void in(View paramView)
  {
    paramView.setOnTouchListener(new apyt(this));
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.aO)
    {
      TroopPicEffectsEditActivity.f(this, getIntent().getStringExtra("friendUin"), getIntent().getStringExtra("troopUin"));
      finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.aP) {
        finish();
      }
    }
  }
  
  public void setImmersiveStatus()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if ((this.mActNeedImmersive) && (this.mSystemBarComp == null)) {
        this.mSystemBarComp = new SystemBarCompact(this, true, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity
 * JD-Core Version:    0.7.0.1
 */